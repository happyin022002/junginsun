/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingCancelManageBC.java
*@FileTitle : Rail Billing Cancel
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-06
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2007-02-06 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lee Sang-Woo
 * @see RailBillingCancelEventResponse 참조
 * @since J2EE 1.4
 */
public interface RailBillingCancelManageBC  {


	/**
	 * 멀티 이벤트 처리<br>
	 * WORejectEvent에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e WORejectEvent
	 * @return EventResponse WORejectEventResponse
	 * @exception EventException
	 */
	public EventResponse cancelRailBillingList(Event e) throws EventException;

	
}