/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PreDispatchStatusBC.java
*@FileTitle : Pre-Dispatch Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-19
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-12-19 kim_sang_geun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.predispatchstatus.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kim_sang_geun
 * @see EsdTrs0020EventResponse 참조
 * @since J2EE 1.4
 */
public interface PreDispatchStatusBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * PreDispatchStatus화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_020Event
	 * @return EventResponse ESD_TRS_020EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPreDispatchStatus(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * PreDispatchStatus화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_020Event
	 * @return EventResponse ESD_TRS_020EventResponse
	 * @exception EventException
	 */
	public EventResponse search01PreDispatchStatus(Event e) throws EventException;

}