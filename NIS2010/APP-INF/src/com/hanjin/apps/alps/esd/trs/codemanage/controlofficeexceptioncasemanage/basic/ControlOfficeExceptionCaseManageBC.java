/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ControlOfficeExceptionCaseManageBC.java
*@FileTitle : Control Office Exception Case Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-27
*@LastModifier : poong
*@LastVersion : 1.0
* 2006-09-27 poong
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.controlofficeexceptioncasemanage.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author poong
 * @see EsdTrs0079EventResponse 참조
 * @since J2EE 1.4
 */
public interface ControlOfficeExceptionCaseManageBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * ESD_TRS_079 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchControlOfficeExceptionCaseManageList(Event e) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_079 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse multiControlOfficeExceptionCaseManage(Event e) throws EventException;

	/**
	 * SEARCH01 이벤트 처리<br>
	 * ESD_TRS_079 화면에 대한 SEARCH01 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchYardCodeManage(Event e) throws EventException;
	
	/**
	 * SEARCH02 이벤트 처리<br>
	 * ESD_TRS_079 화면에 대한 SEARCH02 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCountryCodeManage(Event e) throws EventException;
	
	/**
	 * SEARCH03 이벤트 처리<br>
	 * ESD_TRS_079 화면에 대한 SEARCH03 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchControlOfficeCodeManage(Event e) throws EventException;
	
	/**
	 * SEARCH03 이벤트 처리<br>
	 * ESD_TRS_079 화면에 대한 SEARCH03 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEquipmentSZ(Event e) throws EventException;
	
	/**
	 * SEARCH03 이벤트 처리<br>
	 * ESD_TRS_079 화면에 대한 SEARCH03 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEquipmentTP(Event e) throws EventException;
	
	/**
	 * SEARCH03 이벤트 처리<br>
	 * ESD_TRS_079 화면에 대한 SEARCH03 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyControlOfficeCD(Event e) throws EventException;
	
	
	/**
	 * SEARCH03 이벤트 처리<br>
	 * ESD_TRS_079 화면에 대한 SEARCH03 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse verifySOOfficeCD(Event e) throws EventException;

}