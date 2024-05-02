/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderInquiryBC.java
*@FileTitle : W/O issue list retrieve
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderinquiry.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-workordermanage Business Logic Command Interface<br>
 * An interface to the business logic for Workordermanage<br>
 *
 * @author
 * @see Refer to EsdTrs0025EventResponse
 * @since
 */
public interface WorkOrderInquiryBC  {

	/**
	 * retrieve event process<br>
	 * WorkOrderInquiry retrieve event process<br>
	 * 
	 * @param e ESD_TRS_025Event
	 * @return EventResponse ESD_TRS_025EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderInquiry(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * WorkOrderInquiry retrieve event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchWorkOrderInquiryList(Event e) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * WorkOrderInquiry retrieve event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchWorkOrderList(Event e) throws EventException;

}