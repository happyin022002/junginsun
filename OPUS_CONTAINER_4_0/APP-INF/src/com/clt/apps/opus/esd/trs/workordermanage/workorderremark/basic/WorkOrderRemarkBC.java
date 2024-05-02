/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : WorkOrderRemarkBC.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderremark.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-WorkOrderManage Business Logic Command Interface<br>
 * 
 * @author
 * @see EsdTrs0078EventResponse
 * @since J2EE 1.4
 */
public interface WorkOrderRemarkBC {

	/**
	 * Delete event processing<br>
	 * ESD_TRS_078<br>
	 * 
	 * @param e ESD_TRS_078Event
	 * @return EventResponse ESD_TRS_078EventResponse
	 * @exception EventException
	 */
	public EventResponse removeWorkOrderRemark(Event e) throws EventException;

	/**
	 * Multi-event processing<br>
	 * ESD_TRS_078 - Multi-event processing<br>
	 * 
	 * @param e ESD_TRS_078Event
	 * @return EventResponse ESD_TRS_078EventResponse
	 * @exception EventException
	 */
	public EventResponse multiWorkOrderRemark(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * WorkOrderRemark - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_078Event
	 * @return response ESD_TRS_078EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderRemarkList(Event e) throws EventException;

}