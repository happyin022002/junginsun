/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ChassisGensetSOManageBC.java
*@FileTitle : Service Order 생성화면 - Chassis or Genset
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.04
*@LastModifier : 최 선 
*@LastVersion : 1.1
* 2006.10.04 조풍연
* 1.0 최초 생성
* ----------------------------------------------------------
* History
* 2011.01.04 최 선         1.1 [CHM-201108174] Report 화면 중 S/P code 선택 시 오류팝업 수정요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.basic;

import java.util.ArrayList;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author poong
 * @see EsdTrs0014EventResponse 참조
 * @since J2EE 1.4
 */
public interface ChassisGensetSOManageBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param v
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchTrspSvcOrdList(ArrayList v) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse removeChassisGensetList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVendorList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVendor(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVendorChld(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVendorPrnt(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChassisCorrectionList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGensetCorrectionList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchImportedChassis(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchImportedGenset(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChassisSOManage(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGensetSOManage(Event e) throws EventException;

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_014 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyChassisGensetSOManage(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchChassisGensetSOManageList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * verifyChassisGensetSOManage 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse verifyEqNo(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * verifyChassisGensetSOManage 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse verifyChassisGensetSOManage(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * verifyChassisGensetSOManage 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public ArrayList addTRS_TRSP_SVC_ORD(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchChassisTpSzCdList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchGensetTpSzCdList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchContainerTpSzCdList(Event e) throws EventException;
	
	
}