/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DVFactorMgtBCImpl.java
*@FileTitle : DV Factor
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.dvfactormgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.mnr.generalmanage.dvfactormgt.integration.DVFactorMgtDBDAO;
import com.clt.apps.opus.ees.mnr.generalmanage.dvfactormgt.vo.CustomMnrEqDpcVO;
import com.clt.apps.opus.ees.mnr.generalmanage.dvfactormgt.vo.DVFactorGRPVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
        
/**
 * COM-GeneralManage Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see ESS_MNR_0107EventResponse,DVFactorMgtBC DAO class reference
 * @since J2EE 1.4   
 */        
    
public class DVFactorMgtBCImpl extends BasicCommandSupport implements DVFactorMgtBC {

	// Database Access Object
	private transient DVFactorMgtDBDAO dbDao = null; 

	/** 
	 * creating DVFactorMgtBCImpl object <br>
	 * creating CDVFactorMgtDBDAO <br>
	 */    
	public DVFactorMgtBCImpl() {  
		dbDao = new DVFactorMgtDBDAO();
	}
	
	/**
	 * [EES_MNR_0107]retrieving  DV Factor List. <br>
	 *
	 * @param DVFactorGRPVO dVFactorGRPVO
	 * @return DVFactorGRPVO
	 * @exception EventException
	 */
	public DVFactorGRPVO searchDVFactorListBasic(DVFactorGRPVO dVFactorGRPVO) throws EventException {
		try { 
			//multiple search
			List<List<CustomMnrEqDpcVO>> listCustomMnrEqDpcVOs = new ArrayList<List<CustomMnrEqDpcVO>>();
			
			dVFactorGRPVO.getDVFactorINVO().setEqKndCd("U");  //U:CONTAINER
			List<CustomMnrEqDpcVO> customMnrEqDpcVO0 = dbDao.searchDVFactorListData(dVFactorGRPVO.getDVFactorINVO());
			dVFactorGRPVO.getDVFactorINVO().setEqKndCd("Z");  //Z:CHASSIS
			List<CustomMnrEqDpcVO> customMnrEqDpcVO1 = dbDao.searchDVFactorListData(dVFactorGRPVO.getDVFactorINVO());
			dVFactorGRPVO.getDVFactorINVO().setEqKndCd("G");  //G:GENSET
			List<CustomMnrEqDpcVO> customMnrEqDpcVO2 = dbDao.searchDVFactorListData(dVFactorGRPVO.getDVFactorINVO());
			
			listCustomMnrEqDpcVOs.add(customMnrEqDpcVO0);      
			listCustomMnrEqDpcVOs.add(customMnrEqDpcVO1); 
			listCustomMnrEqDpcVOs.add(customMnrEqDpcVO2);    
			                      
			dVFactorGRPVO.setListCustomMnrEqDpcVOs(listCustomMnrEqDpcVOs);
			
			return dVFactorGRPVO;
		} catch (DAOException ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0107] searchDVFactorListBasic"}).getMessage(),ex);
		} catch (Exception ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0107] searchDVFactorListBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0107]adding/modification/deletion DV Factor. <br>
	 *
	 * @param DVFactorGRPVO dVFactorGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDVFactorBasic(DVFactorGRPVO dVFactorGRPVO, SignOnUserAccount account) throws EventException{
		try {     
			List<CustomMnrEqDpcVO> updateVoList = new ArrayList<CustomMnrEqDpcVO>();
			 
			CustomMnrEqDpcVO[] customMnrEqDpcVO = dVFactorGRPVO.getArrayCustomMnrEqDpcVOs();
			    
			for ( int i=0; i< customMnrEqDpcVO.length; i++ ) {
				//creUsrId using on SQL Merge
				if  ( customMnrEqDpcVO[i].getIbflag().equals("U")){
					customMnrEqDpcVO[i].setCreUsrId(account.getUsr_id());
					customMnrEqDpcVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(customMnrEqDpcVO[i]);  
				}           
			}             
			    
			if ( updateVoList.size() > 0 ) { 
				dbDao.modifyDVFactorData(updateVoList);
			}   
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[ ] manageDVFactorBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[ ] manageDVFactorBasic"}).getMessage(),ex);
		}
	}
	
}