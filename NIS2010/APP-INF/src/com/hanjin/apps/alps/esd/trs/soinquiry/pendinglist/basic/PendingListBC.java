/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PendingListBC.java
*@FileTitle : Pending List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-18
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-18 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.soinquiry.pendinglist.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author juhyun
 * @see EsdTrs0001EventResponse 참조
 * @since J2EE 1.4
 */
public interface PendingListBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * PendingList화면에 대한 조회 이벤트 처리<br>
	 * @param e EsdTrs0001Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchPendingListList(Event e) throws EventException;
	
	/**
	 *  vvd체크  이벤트 처리<br>
	 * PendingList화면에 대한 조회 이벤트 처리<br>
	 * @param e EsdTrs0001Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse search_vvd(Event e) throws EventException;	
	
	
	/**
	 *  vvd체크  이벤트 처리<br>
	 * PendingList화면에 대한 조회 이벤트 처리<br>
	 * @param e EsdTrs0001Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse search_ofc(Event e) throws EventException;		
	

}