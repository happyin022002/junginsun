/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DOFChgColInqmanageBC
*@FileTitle : Drop Off Charge Collection Inquiry
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * DOFChgColInqmanageBC PDTO(Data Transfer Object including Parameters)<br>
 */
public interface DOFChgColInqmanageBC {

	
	/**
	 * Handling Retrieve Settlement Request<br>
	 * @param e Event
	 * @return response ESD_EAS_0008EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDofChgColList(Event e) throws EventException;
	
}
