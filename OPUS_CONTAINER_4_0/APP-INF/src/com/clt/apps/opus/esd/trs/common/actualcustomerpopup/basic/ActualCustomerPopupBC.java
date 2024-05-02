/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ActualCustomerPopupBC.java
*@FileTitle : actual customer retrieve and creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.common.actualcustomerpopup.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * Actual Customer Pop Business Logic Command Interface<br>
 * An interface to the business logic for Actual Customer Pop<br>
 *
 * @author
 * @see Refer to EsdTrs0914Event
 * @since
 */ 
public interface ActualCustomerPopupBC  {
	/**
	 * retrieve event process<br>
	 * Actual customer Popup List retrieve event process<br>
	 * 
	 * @param e EsdTrs0914Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchActualCustomerList(Event e) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * Actual customer Popup Detail retrieve event process<br>
	 * 
	 * @param e EsdTrs0914Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchActualCustomer(Event e) throws EventException;

}