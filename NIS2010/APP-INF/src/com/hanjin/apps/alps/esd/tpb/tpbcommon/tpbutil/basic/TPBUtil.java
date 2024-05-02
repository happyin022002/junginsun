/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TPBEdiUtil.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.12
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2009.04.23 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.tpbcommon.tpbutil.basic;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.esd.tpb.tpbcommon.tpbutil.integration.TPBUtilDBDAO;
import com.hanjin.apps.alps.esd.tpb.tpbcommon.tpbutil.integration.TPBUtilEAIDAO;
import com.hanjin.apps.alps.esd.tpb.tpbcommon.tpbutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esd.tpb.tpbcommon.tpbutil.vo.SendFlatFileVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;



/**
 * NIS2010-BookingUtil<br>
 * - NIS2010-BookingCommon에 대한 공통 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Youngchul
 * @see UI_Booking_UtilEventResponse 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class TPBUtil{
    // Database Access Object
    private transient TPBUtilDBDAO dbDao = null;
    private transient TPBUtilEAIDAO eaoDao = null;
    private transient Logger log = null;
 
    /**
     * BookingUtil 객체 생성<br>
     * BookingUtilDBDAO를 생성한다.<br>
     */
    public TPBUtil() {

        dbDao = new TPBUtilDBDAO();
        eaoDao = new TPBUtilEAIDAO();        
        log = Logger.getLogger(this.getClass().getName());
    }
    
	/**
	 * EDI Transmit 공통 함수<br>
	 * @param SendFlatFileVO sendFlatFileVO
	 * @return FlatFileAckVO
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
	 * TPB에서 사용하는 Flat File Header 생성 <br> 
	 * @param String sndrId
	 * @param String rcvId
	 * @param String msgId
	 * @return String
	 * @throws EventException
	 */
	public String searchTPBEdiHeader(String sndrId, String rcvId, String msgId)throws EventException {
	    try {
	        return dbDao.searchTPBEdiHeader(sndrId, rcvId, msgId);
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
}