/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingVerifyManageBC.java
*@FileTitle : Rail Billing Verify
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-06
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2007-02-06 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingverifymanage.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lee Sang-Woo
 * @see RailBillingVerifyEventResponse 참조
 * @since J2EE 1.4
 */
public interface RailBillingVerifyManageBC  {


	/**
	 * 멀티 이벤트 처리<br>
	 * WORejectEvent에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e WORejectEvent
	 * @return EventResponse WORejectEventResponse
	 * @exception EventException
	 * @throws Exception 
	 */
	public EventResponse verifyRailBillingCNTRList(Event e) throws EventException;

	
}