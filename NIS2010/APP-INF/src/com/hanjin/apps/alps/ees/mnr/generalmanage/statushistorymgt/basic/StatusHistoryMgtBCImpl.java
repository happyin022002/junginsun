/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusHistoryMgtBCImpl.java
*@FileTitle : StatusHistory
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.09.22 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.integration.StatusHistoryMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.vo.CustomMnrStsHisVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.vo.StatusHistoryGRPVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-GeneralManage Business Logic Basic Command implementation<br>
 * - alps-GeneralManage 에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author WanGyu Kim    
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4      
 */
public  class StatusHistoryMgtBCImpl extends BasicCommandSupport implements StatusHistoryMgtBC {
	// Database Access Object 
	private transient StatusHistoryMgtDBDAO dbDao = null; 
		
	/** 	
	 * StatusHistoryMgtBCImpl 객체 생성<br>
	 * StatusHistoryMgtDBDAO 생성한다.<br>
	 */    
	public StatusHistoryMgtBCImpl() {  
		dbDao = new StatusHistoryMgtDBDAO(); 
	} 

	/**
	 * [EES_MNR_0098]Total Loss Request의 정보를 조회 합니다. <br>
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
	 * [EES_MNR_0098]Total Loss Request의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param StatusHistoryGRPVO statusHistoryGRPVO
	 * @param SignOnUserAccount account
	 * @return StatusHistoryGRPVO
	 * @exception EventException
	 */
	public StatusHistoryGRPVO manageStatusHistorysBasic(StatusHistoryGRPVO statusHistoryGRPVO, SignOnUserAccount account) throws EventException{
		try {
			//MNR STS REF NO 설정//////////////////////////////////////////////////////////////////////
			String paramMnrStsRefNo	= statusHistoryGRPVO.getArrayCustomMnrStsHisVO()[0].getMnrStsRefNo();
			String newMnrStsRefNo	= "";
			
			if(paramMnrStsRefNo.equals("NEW")) {
				//MNR STS REF No 생성 조회
				newMnrStsRefNo = dbDao.searchStatusHistoryRefNoData();
				for (int i=0; i<statusHistoryGRPVO.getArrayCustomMnrStsHisVO().length; i++) {
					statusHistoryGRPVO.getArrayCustomMnrStsHisVO()[i].setMnrStsRefNo(newMnrStsRefNo);
				}
			}

			//VO List 설정//////////////////////////////////////////////////////////////////////
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
			
 			//저장실행
			if ( insertVoList.size() > 0 ) {
				dbDao.addStatusHistoryData(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyStatusHistoryData(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeStatusHistoryData(deleteVoList);
			}
			
			//저장후 MNR STS REF NO Return
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
	 * [EES_MNR_0098]Total Loss Request의  Ref No 관련 History 정보를 모두 삭제 합니다. <br>
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
