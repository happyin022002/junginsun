/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderCCManageBC.java
*@FileTitle : Transportation Report & Code
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderccmanage.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-WorkOrderManage Business Logic Command Interface<br>
 *
 * @author 
 * @see EsdTrs0072EventResponse 
 * @since J2EE 1.4
 */
public interface WorkOrderCCManageBC  {

	/**
	 * Inquiry event process<br>
	 * WorkOrderCCManage - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_072Event
	 * @return EventResponse ESD_TRS_072EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderCCFaxList(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * WorkOrderCCManage - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_072Event
	 * @return EventResponse ESD_TRS_072EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderCCEmailList(Event e) throws EventException;
	
	/**
	 * Multi-event processing<br>
	 * ESD_TRS_072  - Multi-event processing<br>
	 * 
	 * @param e ESD_TRS_072Event
	 * @return EventResponse ESD_TRS_072EventResponse
	 * @exception EventException
	 */
	public EventResponse multiWorkOrderCCManageList(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * WorkOrderCCManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchWorkOrderCCManageList(Event e) throws EventException;

}