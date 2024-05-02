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

import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.vo.VslSkdCngNotificationSetupVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * NIS2010-ScheduleUtilityManagement Business Logic Command Interface<br>
 * - NIS2010-ScheduleUtilityManagement 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SEO CHANG YUL
 * @see Ui_vsk-0202EventResponse 참조
 * @since J2EE 1.4
 */

public interface ScheduleNotificationManagementBC {

	/**
	 * Vessel Schedule Notice 기본정보 setup 조회
	 * 
	 * @param  VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO
	 * @return List<VslSkdCngNotificationSetupVO>
	 * @exception EventException
	 */
	public List<VslSkdCngNotificationSetupVO> searchVslSkdCngNotificationSetupList(VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO) throws EventException;

	/**
	 * Vessel Schedule Notice 기본정보 setup 저장
	 * 
	 * @param  VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO
	 * @exception EventException
	 */
	public void manageVslSkdCngNotificationSetup	(VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO) throws EventException;
	
	/**
	 * Vessel Schedule Notice 기본정보 setup 삭제
	 * 
	 * @param  VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO
	 * @exception EventException
	 */
	public void removeVslSkdCngNotificationSetup	(VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO) throws EventException;	
	
	/**
	 * Vessel Schedule Notice 기본정보 setup PK 업데이트
	 * 
	 * @param  VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO
	 * @exception EventException
	 */
	public void modifyVslSkdCngNotificationSetup	(VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO) throws EventException;		
	
	
	
}