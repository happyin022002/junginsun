/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OtherSOManageBC.java
*@FileTitle : Other SO 생성화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : kimjin
*@LastVersion : 1.0
* 2009-10-01 kimjin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.basic;

import java.util.ArrayList;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-OtherSOManage Business Logic Command Interface<br>
 * - ESD-OtherSOManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kimjin
 * @see EsdTrs0018EventResponse 참조
 * @since J2EE 1.6
 */
public interface OtherSOManageBC  {
	
	/**
	 * 조회 이벤트 처리<br>
	 * OtherSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param v	
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTrspSvcOrdList(ArrayList v) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * OtherSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_018Event
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerEqNo(Event e) throws EventException;
	
	/**
	 * 삭제 이벤트 처리<br>
	 * ESD_TRS_018 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_018Event
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGensetEqNo(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESD_TRS_018 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_018Event
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOtherSOCorrectionList(Event e) throws EventException;
	
	/**
	 * Rate Apply 처리<br>
	 * ESD_TRS_018 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_018Event
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRateApplyList(Event e) throws EventException;
	
	/**
	 * 삭제 이벤트 처리<br>
	 * ESD_TRS_018 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_018Event
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChassisEqNo(Event e) throws EventException;
	
	/**
	 * 추가 이벤트 처리<br>
	 * ESD_TRS_018 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_018Event
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public ArrayList addOtherSOManage(Event e) throws EventException;

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_018 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_018Event
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOtherSOManage(Event e) throws EventException;

	/**
	 * 삭제 이벤트 처리<br>
	 * ESD_TRS_018 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_018Event
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOtherSOManage(Event e) throws EventException;

}