/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CommonPopUpManageBC.java
*@FileTitle : CY & Door S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esd.eas.common.popup.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-EAS Business Logic Command Interface<br>
 */
public interface CommonPopUpManageBC
{

	/**
	 * Retrieve event  Common Office UI<br>
	 *
	 * @param e ESD_EAS_COM_0001Event
	 * @return EventResponse ESD_EAS_COM_0001EventResponse
	 * @exception EventException
	 */
	public EventResponse searchServiceOfficeCodeManage(Event e) throws EventException;
}