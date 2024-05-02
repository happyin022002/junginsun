/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaRailYardManageBC.java
*@FileTitle : UsaRailYardManage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usarailyardmanage.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * UsaRailYardManage Business Logic Command Interface<br>
 * An interface to the business logic for UsaRailYardManage<br>
 *
 * @author
 * @see Refer to EsdTrs0084EventResponse 
 * @since
 */
public interface UsaRailYardManageBC  {

	/**
	 * retrieve event process<br>
	 * UsaRailYardManage retrieve event process<br>
	 * 
	 * @param e ESD_TRS_0084Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchUsaRailYardManage(Event e) throws EventException;

	/**
	 * multi event process<br>
	 * ESD_TRS_084 multi event process<br>
	 * 
	 * @param e ESD_TRS_0084Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiUsaRailYardManage(Event e) throws EventException;

}