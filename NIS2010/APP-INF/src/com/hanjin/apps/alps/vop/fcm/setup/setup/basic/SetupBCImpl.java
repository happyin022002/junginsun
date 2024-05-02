/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : VesselReportBCImpl.java
 *@FileTitle : VesselReport
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.04
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.10.04 유혁
 * 1.0 Creation
 * 
 * History
 * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
 * 2012.04.23 진마리아 CHM-201217192-01 Vessel Registration 선박 추가 로직 변경 요청건
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.setup.setup.basic;


import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.fcm.setup.setup.integration.SetupDBDAO;
import com.hanjin.apps.alps.vop.fcm.setup.setup.vo.FcmSavItmRgstVO;
import com.hanjin.apps.alps.vop.fcm.setup.setup.vo.FcmVslCntrRgstVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ScgImdgPckGrpVO;
import com.hanjin.apps.alps.vop.fcm.setup.setup.vo.FcmDepRptErrRtVO;

/**
 * ALPS-Setup Business Logic Basic Command implementation<br>
 * - ALPS-Setup에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Ryu Hyuk
 * @see VOP_FCM_0041EventResponse,SetupBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SetupBCImpl extends BasicCommandSupport implements
SetupBC {

	// Database Access Object
	private transient SetupDBDAO dbDao = null;

	/**
	 * SetupBCImpl 객체 생성<br>
	 * SetupDBDAO 생성한다.<br>
	 */
	public SetupBCImpl() {
		dbDao = new SetupDBDAO();
	}
	
	/**
	 * Vessel Registration 정보를 생성합니다.
	 * 
	 * @param FcmVslCntrRgstVO fcmVslCntrRgstVO
	 * @return List<FcmVslCntrRgstVO>
	 * @exception EventException
	 */
	public List<FcmVslCntrRgstVO> searchFcmVslCntrRgst(FcmVslCntrRgstVO fcmVslCntrRgstVO) throws EventException {
		try {

			return dbDao.searchFcmVslCntrRgst(fcmVslCntrRgstVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Registration"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Registration"}).getMessage(), ex);
		} 
	}
	
	/**
	 * Vessel Registration 정보를 변경합니다.
	 * 
	 * @param FcmVslCntrRgstVO[] fcmVslCntrRgstVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiFcmVslCntrRgst(FcmVslCntrRgstVO[] fcmVslCntrRgstVOs,SignOnUserAccount account) throws EventException{
		try {
			for(int i = 0 ; i < fcmVslCntrRgstVOs.length ;i++) {				
				FcmVslCntrRgstVO vslCntrRgstVO = fcmVslCntrRgstVOs[i];
				vslCntrRgstVO.setCreUsrId(account.getUsr_id());
				vslCntrRgstVO.setUpdUsrId(account.getUsr_id());
				if(vslCntrRgstVO.getIbflag().equals("U")){
					dbDao.modifyFcmVslCntrRgst(vslCntrRgstVO);	
				}else{
					dbDao.addFcmVslCntrRgst(vslCntrRgstVO);
				}
			 }
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel Registration"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel Registration"}).getMessage(), ex);
		} 
	}
	
	/**
	 * Vessel Registration 정보를 삭제합니다.
	 * 
	 * @param FcmVslCntrRgstVO[] fcmVslCntrRgstVOs
	 * @exception EventException
	 */
	public void removeFcmVslCntrRgst(FcmVslCntrRgstVO[] fcmVslCntrRgstVOs) throws EventException {
		try {
			List<FcmVslCntrRgstVO> deleteVoList = new ArrayList<FcmVslCntrRgstVO>();
			for(int i=0; i<fcmVslCntrRgstVOs.length; i++){
				if("D".equals(fcmVslCntrRgstVOs[i].getIbflag())){
					deleteVoList.add(fcmVslCntrRgstVOs[i]);
				}
			}
			dbDao.deleteFcmVslCntrRgst(deleteVoList);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12197", new String[]{"Vessel Registration"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12197", new String[]{"Vessel Registration"}).getMessage(), ex);
		}
	}

	/**
	 * Item Registration 정보를 삭제합니다.
	 * 
	 * @param FcmSavItmRgstVO fcmSavItmRgstVO
	 * @exception EventException
	 */
	public void removeFcmItmRgst(FcmSavItmRgstVO fcmSavItmRgstVO) throws EventException {
		try {
			dbDao.deleteFcmItmRgst(fcmSavItmRgstVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12197", new String[]{"Saving Item Registration"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12197", new String[]{"Saving Item Registration"}).getMessage(), ex);
		}
	}
	
	/**
	 * Item Registration 정보를 생성합니다.
	 * 
	 * @param FcmSavItmRgstVO fcmSavItmRgstVO
	 * @return List<FcmSavItmRgstVO>
	 * @exception EventException
	 */
	public List<FcmSavItmRgstVO> searchFcmItmRgst(FcmSavItmRgstVO fcmSavItmRgstVO) throws EventException{
		try {

			return dbDao.searchFcmItmRgst(fcmSavItmRgstVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Saving Item Registration"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Saving Item Registration"}).getMessage(), ex);
		} 
	}
	
	/**
	 * Item Registration 정보를 변경합니다.
	 * 
	 * @param FcmSavItmRgstVO[] fcmSavItmRgstVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiFcmItmRgst(FcmSavItmRgstVO[] fcmSavItmRgstVOs, SignOnUserAccount account) throws EventException{
		try {
			for(int i = 0 ; i < fcmSavItmRgstVOs.length ;i++) {				
				FcmSavItmRgstVO itmRgstVO = fcmSavItmRgstVOs[i];
				itmRgstVO.setCreUsrId(account.getUsr_id());
				itmRgstVO.setUpdUsrId(account.getUsr_id());
				itmRgstVO.setN1stVarDgrVal("2");
				itmRgstVO.setN2ndVarDgrVal("1");
				if(itmRgstVO.getIbflag().equals("D")){
					dbDao.deleteFcmItmRgst(itmRgstVO);	
				}else{
					dbDao.addFcmSavItmRgstVO(itmRgstVO);
				}
			 }
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12192", new String[]{"Saving Item Registration"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12192", new String[]{"Saving Item Registration"}).getMessage(), ex);
		} 
	}

	/**
	 * Item Registration의 각 Design Capa에 대한 Vessel Sub Class Code를 구한다.
	 * 
	 * @param FcmSavItmRgstVO fcmSavItmRgstVO
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchVslClassSubCode(FcmSavItmRgstVO fcmSavItmRgstVO) throws EventException {
		try {
			return dbDao.searchVslClassSubCode(fcmSavItmRgstVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Saving Item Registration"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Saving Item Registration"}).getMessage(), ex);
		} 
	}
	
	/**
	 * Vessel Registration에 기등록된 Vsl인지 check합니다.
	 * 
	 * @param String vslCd
	 * @return String
	 * @exception EventException
	 */
	public String searchVslCntrRgstExist(String vslCd) throws EventException {
		try {
			return dbDao.searchVslCntrRgstExist(vslCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Registration Check"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Registration Check"}).getMessage(), ex);
		} 
	}
	
	/**
	 * dep.report error rate 조회
	 * 
	 * @param String vslCd
	 * @return List<FcmDepRptErrRtVO>
	 * @exception EventException
	 */
	public List<FcmDepRptErrRtVO> searchFcmDepRptErrRt(String vslCd) throws EventException{
		try {
			return dbDao.searchFcmDepRptErrRt(vslCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Registration Check"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Registration Check"}).getMessage(), ex);
		} 
	}
	
	
	/**
	 * modify dep error rate setting<br>
	 * 
	 * @param FcmDepRptErrRtVO[] fcmDepRptErrRtVOs
	 * @param account
	 * @exception EventException
	 */
	public void manageFcmDepRptErrRt(FcmDepRptErrRtVO[] fcmDepRptErrRtVOs, SignOnUserAccount account) throws EventException {
		try {
			
			List<FcmDepRptErrRtVO> updateVoList = new ArrayList<FcmDepRptErrRtVO>();
			List<FcmDepRptErrRtVO> deleteVoList = new ArrayList<FcmDepRptErrRtVO>();
			List<FcmDepRptErrRtVO> insertVoList = new ArrayList<FcmDepRptErrRtVO>();
			
			for(int i = 0 ; i < fcmDepRptErrRtVOs.length ;i++) {

				log.debug("**fcmDepRptErrRtVOs[i].getIbflag()***"+fcmDepRptErrRtVOs[i].getIbflag());
				if ( fcmDepRptErrRtVOs[i].getIbflag().equals("I")){
					fcmDepRptErrRtVOs[i].setCreUsrId(account.getUsr_id());
					    insertVoList.add(fcmDepRptErrRtVOs[i]);
				} else if ( fcmDepRptErrRtVOs[i].getIbflag().equals("U")){
			    	   fcmDepRptErrRtVOs[i].setCreUsrId(account.getUsr_id());
					   updateVoList.add(fcmDepRptErrRtVOs[i]);
				} else if ( fcmDepRptErrRtVOs[i].getIbflag().equals("D")){
					   fcmDepRptErrRtVOs[i].setCreUsrId(account.getUsr_id());
					   deleteVoList.add(fcmDepRptErrRtVOs[i]);
				}
			 }
			
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addFcmDepRptErrRt(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.addFcmDepRptErrRt(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeFcmDepRptErrRt(deleteVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"DEP.REPORT ERROR RATING Registration Check"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"DEP.REPORT ERROR RATING Registration Check"}).getMessage(), ex);
		} 
	}
	/**
	 * MDM의 Vessel 정보를 조회합니다.
	 * 
	 * @param String vslCd
	 * @return FcmVslCntrRgstVO
	 * @exception EventException
	 */
	public FcmVslCntrRgstVO searchMdmVslCntrRgstList(String vslCd) throws EventException {
		try {
			return dbDao.searchMdmVslCntrRgstList(vslCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Container Data"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Container Data"}).getMessage(), ex);
		} 
	}
	
	/**
	 * Search FMS vessel info.
	 * 
	 * @param vslCd
	 * @return FcmVslCntrRgstVO
	 * @throws EventException
	 */
	public FcmVslCntrRgstVO searchFmsVslCntr(String vslCd) throws EventException {
		try {
			return dbDao.searchFmsVslCntr(vslCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Container Data"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Container Data"}).getMessage(), ex);
		}
	}

}