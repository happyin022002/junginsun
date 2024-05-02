/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusHistoryMgtBCImpl.java
*@FileTitle : StatusHistory
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.statushistorymgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.mnr.generalmanage.statushistorymgt.integration.StatusHistoryMgtDBDAO;
import com.clt.apps.opus.ees.mnr.generalmanage.statushistorymgt.vo.CustomMnrStsHisVO;
import com.clt.apps.opus.ees.mnr.generalmanage.statushistorymgt.vo.StatusHistoryGRPVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-GeneralManage Business Logic Basic Command implementation<br>
 *
 * @author     
 * @see DAO class reference
 * @since J2EE 1.4      
 */
public  class StatusHistoryMgtBCImpl extends BasicCommandSupport implements StatusHistoryMgtBC {
	// Database Access Object 
	private transient StatusHistoryMgtDBDAO dbDao = null; 
		
	/** 	
	 * creating StatusHistoryMgtBCImpl object<br>
	 * creating StatusHistoryMgtDBDAO <br>
	 */    
	public StatusHistoryMgtBCImpl() {  
		dbDao = new StatusHistoryMgtDBDAO(); 
	} 

	/**
	 * [EES_MNR_0098] retrieving Total Loss Request. <br>
	 *
	 * @param StatusHistoryGRPVO statusHistoryGRPVO
	 * @return StatusHistoryGRPVO
	 * @exception EventException
	 */
	public StatusHistoryGRPVO searchStatusHistoryBasic(StatusHistoryGRPVO statusHistoryGRPVO) throws EventException {
		try { 
			List<CustomMnrStsHisVO> listCustomMnrStsHisVO = null; 
			
			listCustomMnrStsHisVO = dbDao.searchStatusHistoryData(statusHistoryGRPVO);
				
			statusHistoryGRPVO.setListCustomMnrStsHisVO(listCustomMnrStsHisVO);   
			return statusHistoryGRPVO;          
			
		} catch (DAOException ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0098] searchStatusHistoryBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0098] searchStatusHistoryBasic"}).getMessage(),ex);
		}
	} 
	
	/**
	 * [EES_MNR_0098] adding/modification/deletion Total Loss Request. <br>
	 *
	 * @param StatusHistoryGRPVO statusHistoryGRPVO
	 * @param SignOnUserAccount account
	 * @return StatusHistoryGRPVO
	 * @exception EventException
	 */
	public StatusHistoryGRPVO manageStatusHistorysBasic(StatusHistoryGRPVO statusHistoryGRPVO, SignOnUserAccount account) throws EventException{
		try {
			// setting MNR STS REF NO 
			String paramMnrStsRefNo	= statusHistoryGRPVO.getArrayCustomMnrStsHisVO()[0].getMnrStsRefNo();
			String newMnrStsRefNo	= "";
			
			if(paramMnrStsRefNo.equals("NEW")) {
				// retrieving MNR STS REF No 
				newMnrStsRefNo = dbDao.searchStatusHistoryRefNoData();
				for (int i=0; i<statusHistoryGRPVO.getArrayCustomMnrStsHisVO().length; i++) {
					statusHistoryGRPVO.getArrayCustomMnrStsHisVO()[i].setMnrStsRefNo(newMnrStsRefNo);
				}
			}

			// setting VO List 
			List<CustomMnrStsHisVO> insertVoList = new ArrayList<CustomMnrStsHisVO>();
			List<CustomMnrStsHisVO> updateVoList = new ArrayList<CustomMnrStsHisVO>();
			List<CustomMnrStsHisVO> deleteVoList = new ArrayList<CustomMnrStsHisVO>();
			
			for ( int i=0; i<statusHistoryGRPVO.getArrayCustomMnrStsHisVO().length; i++ ) {
				if ( statusHistoryGRPVO.getArrayCustomMnrStsHisVO()[i].getIbflag().equals("U")){
					statusHistoryGRPVO.getArrayCustomMnrStsHisVO()[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(statusHistoryGRPVO.getArrayCustomMnrStsHisVO()[i]);
				} 
				else if (statusHistoryGRPVO.getArrayCustomMnrStsHisVO()[i].getIbflag().equals("I")){
					statusHistoryGRPVO.getArrayCustomMnrStsHisVO()[i].setTempSeq((i)+1+"");
					statusHistoryGRPVO.getArrayCustomMnrStsHisVO()[i].setCreUsrId(account.getUsr_id());
					statusHistoryGRPVO.getArrayCustomMnrStsHisVO()[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(statusHistoryGRPVO.getArrayCustomMnrStsHisVO()[i]);
				} 
				else if ( statusHistoryGRPVO.getArrayCustomMnrStsHisVO()[i].getIbflag().equals("D")){
					deleteVoList.add(statusHistoryGRPVO.getArrayCustomMnrStsHisVO()[i]);
				} 
			}  
			
 			//saving
			if ( insertVoList.size() > 0 ) {
				dbDao.addStatusHistoryData(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyStatusHistoryData(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeStatusHistoryData(deleteVoList);
			}
			
			//returing MNR STS REF NO after saving
			if(paramMnrStsRefNo.equals("NEW")) {
				statusHistoryGRPVO.setMnrStsRefNo(newMnrStsRefNo);
			} else {
				statusHistoryGRPVO.setMnrStsRefNo(paramMnrStsRefNo);
			}
			return statusHistoryGRPVO;
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0098] manageStatusHistorysBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0098] manageStatusHistorysBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0098] deleting Ref No History of Total Loss Request. <br>
	 *
	 * @param StatusHistoryGRPVO statusHistoryGRPVO
	 * @param SignOnUserAccount account
	 * @return StatusHistoryGRPVO
	 * @exception EventException
	 */
	public StatusHistoryGRPVO removeStatusHistorysAllBasic(StatusHistoryGRPVO statusHistoryGRPVO, SignOnUserAccount account) throws EventException{
		try {
			CustomMnrStsHisVO customMnrStsHisVO = new CustomMnrStsHisVO();
			customMnrStsHisVO.setMnrStsRefNo(statusHistoryGRPVO.getMnrStsRefNo());
			dbDao.removeStatusHistoryALLData(customMnrStsHisVO);
			return statusHistoryGRPVO;
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0098] manageStatusHistorysBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0098] manageStatusHistorysBasic"}).getMessage(),ex);
		}
	}

}
