/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ActualCustomerPopupBC.java
*@FileTitle : actual customer 조회  생성화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-09
*@LastModifier : eunhee
*@LastVersion : 1.0
* 2009-09-09 eunhee
* 1.0 최초 생성
* -----------------------------------------------------------------
* History
* 2012.05.08 김종호 [CHM-201217449] [TRS] Additional 칼럼, Other S/O creation 화면 입력기능 일부 변경 : Actual Customer 자동 조회 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.actualcustomerpopup.basic;

import com.hanjin.apps.alps.esd.trs.common.actualcustomerpopup.event.EsdTrs0914Event;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * Actual Customer Pop Business Logic Command Interface<br>
 * - Actual Customer Pop에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author eunhee
 * @see EsdTrs0914Event 참조
 * @since J2EE 1.4
 */ 
public interface ActualCustomerPopupBC  {
	/**
	 * 조회 이벤트 처리<br>
	 * Actual customer Popup List 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EsdTrs0914Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchActualCustomerList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Actual customer Popup 화면에 대한 Detail 조회 이벤트 처리<br>
	 * 
	 * @param e EsdTrs0914Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchActualCustomer(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Actual customer 의 코드입력시 자동 조회<br>
	 * 
	 * @param e EsdTrs0914Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchActualCustomerName(Event e) throws EventException;

}