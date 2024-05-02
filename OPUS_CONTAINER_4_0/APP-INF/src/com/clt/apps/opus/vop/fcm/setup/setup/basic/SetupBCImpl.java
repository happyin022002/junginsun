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
package com.clt.apps.opus.vop.fcm.setup.setup.basic;


import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.vop.fcm.setup.setup.integration.SetupDBDAO;
import com.clt.apps.opus.vop.fcm.setup.setup.vo.FcmVslCntrRgstVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

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