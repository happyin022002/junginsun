/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScheduleNotificationManagementBC.java
*@FileTitle : Schedule Notification
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.19
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2013.07.19 정상기
* 1.0 Creation
*  History
* 2013.07.19 [CHM-201325067]   [VOP-VSK] 스케줄 변경 시 개인별 설정 시간에 따라 개별 메일 통지 기능
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.integration.ScheduleNotificationManagementDBDAO;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.vo.VslSkdCngNotificationSetupVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * NIS2010-ScheduleUtilityManagement Business Logic Basic Command implementation<br>
 * - NIS2010-ScheduleUtilityManagement 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Maria Chin
 * @see UI_VSK-0290EventResponse,ScheduleTransmitManagementBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class ScheduleNotificationManagementBCImpl extends BasicCommandSupport implements ScheduleNotificationManagementBC {

	// Database Access Object
	private transient ScheduleNotificationManagementDBDAO dbDao = null;

	/**
	 * ScheduleNotificationManagementBCImpl 객체 생성<br>
	 * ScheduleNotificationManagementDBDAO를 생성한다.<br>
	 */
	public ScheduleNotificationManagementBCImpl() {
		dbDao = new ScheduleNotificationManagementDBDAO();
	}
	
	/**
	 * Vessel Schedule Notice 기본정보 setup 조회
	 * 
	 * @param  VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO
	 * @return List<VslSkdCngNotificationSetupVO>
	 * @exception EventException
	 */
	public List<VslSkdCngNotificationSetupVO> searchVslSkdCngNotificationSetupList(VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO) throws EventException {
		try {
			return dbDao.searchVslSkdCngNotificationSetupList(vslSkdCngNotificationSetupVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}
	}
	
	/**
	 * Vessel Schedule Notice 기본정보 setup 저장
	 * 
	 * @param  VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO
	 * @exception EventException
	 */
	public void manageVslSkdCngNotificationSetup(VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO) throws EventException {
		try {

			if (vslSkdCngNotificationSetupVO != null) {
				dbDao.manageVslSkdCngNotificationSetup(vslSkdCngNotificationSetupVO);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12208", new String[]{"Vessel Schedule Notification Setup"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12208", new String[]{"Vessel Schedule Notification Setup"}).getMessage(), ex);
		}
	}
	
	/**
	 * Vessel Schedule Notice 기본정보 setup 삭제
	 * 
	 * @param  VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO
	 * @exception EventException
	 */
	public void removeVslSkdCngNotificationSetup(VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO) throws EventException {
		try {

			if (vslSkdCngNotificationSetupVO != null) {
				dbDao.removeVslSkdCngNotificationSetup(vslSkdCngNotificationSetupVO);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12208", new String[]{"Vessel Schedule Notification Setup"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12208", new String[]{"Vessel Schedule Notification Setup"}).getMessage(), ex);
		}
	}	
	
	/**
	 * Vessel Schedule Notice 기본정보 setup PK 업데이트
	 * 
	 * @param  VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO
	 * @exception EventException
	 */
	public void modifyVslSkdCngNotificationSetup(VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO) throws EventException {
		try {

			if (vslSkdCngNotificationSetupVO != null) {
				dbDao.modifyVslSkdCngNotificationSetup(vslSkdCngNotificationSetupVO);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12208", new String[]{"Vessel Schedule Notification Setup"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12208", new String[]{"Vessel Schedule Notification Setup"}).getMessage(), ex);
		}
	}	
	
/*	public void manageEtaSendResult(EtaSendTgtVO[] etaSendTgtVOs, SignOnUserAccount account) throws EventException {
		try {
			List<EtaSendTgtVO> updateVoList = new ArrayList<EtaSendTgtVO>();
			
			for(EtaSendTgtVO vo : etaSendTgtVOs){
				if("ALPS".equals(vo.getTrsmOwnrCd())){
					
					if("U".equals(vo.getIbflag())){
						vo.setUpdUsrId(account.getUsr_id());
						updateVoList.add(vo);
					}
				
				*//*** "ESVC" --- SPP ***//*
				}else{
					vo.setUpdUsrId(account.getUsr_id());					
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyEtaSendResult(updateVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12208", new String[]{"ETA Sending RPM Result"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12208", new String[]{"ETA Sending RPM Result"}).getMessage(), ex);
		}
	}	
	*/
	
	


}