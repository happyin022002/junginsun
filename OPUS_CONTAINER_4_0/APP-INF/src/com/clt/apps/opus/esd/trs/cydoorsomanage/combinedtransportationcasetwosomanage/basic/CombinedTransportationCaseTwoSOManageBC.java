/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CombinedTransportationCaseTwoSOManageBC.java
*@FileTitle : CY & Door S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.cydoorsomanage.combinedtransportationcasetwosomanage.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author z_kim_sang_geun
 * @see EsdTrs0920EventResponse 참조
 * @since J2EE 1.4
 */
public interface CombinedTransportationCaseTwoSOManageBC
{

	/**
	 * 조회 이벤트 처리<br>
	 * CombinedTransportationCaseTwoSOManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e EsdTrs0920Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchCombinedTransportationCaseTwoSOManage(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * CombinedTransportationCaseTwoSOManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e EsdTrs0920Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse search02CombinedTransportationCaseTwoSOManage(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ServiceOfficeCodeSOManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e EsdTrs0920Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse search03ServiceOfficeCodeSOManage(Event e) throws EventException;
}