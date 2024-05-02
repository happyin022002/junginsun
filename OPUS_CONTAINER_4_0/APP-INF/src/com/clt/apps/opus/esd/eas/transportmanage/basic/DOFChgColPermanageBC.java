/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DOFChgColPermanageBC
*@FileTitle : Drop Off Charge Collection Performance
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
 * DOFChgColPermanageBC PDTO(Data Transfer Object including Parameters)<br>
 */
public interface DOFChgColPermanageBC {

	
	/**
	 * Drop off charge collection Performance Search list<br>
	 * @param e Event
	 * @return response ESD_EAS_0009EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDofChgColPerList(Event e) throws EventException;
	
}
