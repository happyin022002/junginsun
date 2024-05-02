/*=========================================================
*Copyright(c) 2014 ScgUtilEai
*@FileName : ScgUtilEai.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.20
*@LastModifier : dongsoo
*@LastVersion : 1.0
* 2014.11.20 dongsoo
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scgutileai.basic;


import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.scg.scgcommon.scgutileai.integration.ScgUtilDBDAO;
import com.clt.apps.opus.vop.scg.scgcommon.scgutileai.integration.ScgUtilEAIDAO;
import com.clt.apps.opus.vop.scg.scgcommon.scgutileai.vo.DgEdiFltFileVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgutileai.vo.FlatFileAckVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgutileai.vo.SendDgEdiHeaderInfoVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgutileai.vo.SendFlatFileVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * -ScgUtilEai<br>
 * - -ScgUtilEai common business logic is processed.<br>
 *
 * @author 
 * @see DAO Reference
 * @since J2EE 1.6
 */
public class ScgUtilEai extends BasicCommandSupport{
    
	// Database Access Object    
    private transient ScgUtilEAIDAO eaoDao = null;    
 // Database Access Object    
    private transient ScgUtilDBDAO dbDao = null;
   
    public ScgUtilEai() {
        eaoDao = new ScgUtilEAIDAO();  
        dbDao  = new ScgUtilDBDAO();
    }
    
    /**
     *  Manifest Transmit Common Functions<br>
     * @author 	  
     * @param 	SendFlatFileVO sendFlatFileVO
     * @return	FlatFileAckVO flatFileAckVO
     * @throws EventException
     */    
	public FlatFileAckVO sendFlatFile(SendFlatFileVO sendFlatFileVO) throws EventException {
		FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
		try {
			flatFileAckVO = eaoDao.sendFlatFile(sendFlatFileVO);
		}catch(EventException ex){
			throw ex;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}

		return flatFileAckVO;
	}
	
	/**
	 * Retrieve SearchEdiSendHeader <br>
	 * 
	 * @param Map<String, String> mapVO
	 * @return String
	 * @exception EventException
	 */
	public List<SendDgEdiHeaderInfoVO> searchSendEdiHeader(Map<String, String> mapVO) throws EventException {
		try {
			return dbDao.searchSendEdiHeader(mapVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG EDI HEADER "}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG EDI HEADER "}).getMessage(), ex);
        }
	}
	
	/**
	 * EDI, SEND OR RECEIVED EXCEPTION 발생시 저장하는 로직 <br>
	 * 
	 * @param DgEdiFltFileVO excVO
	 * @exception EventException
	 */
	public void addScgPrnrSpclCgoFltFile(DgEdiFltFileVO excVO) throws EventException{

		try {
			
			boolean	isExistFlatFileLog	= dbDao.checkPrnrSpclCgoFltFileExist	(excVO);
			
			if(isExistFlatFileLog){
				dbDao.modifyScgPrnrSpclCgoFltFile	(excVO);	
			}else{
				dbDao.addScgPrnrSpclCgoFltFile		(excVO);				
			}
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Application Request & Approval Status"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Application Request & Approval Status"}).getMessage(), ex);
        }
	}
} 
