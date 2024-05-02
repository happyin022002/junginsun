/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SpecialSOCheckBC.java
*@FileTitle : Special S/O Check - Supplement & Other
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ENIS-SpecialSOCheck Business Logic Command Interface<br>
 */
public interface SpecialSOCheckBC {

	/**
	 * Special SO Search List
	 * @param e EsdEas0003Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchSpecialSOCheckList(Event e) throws EventException;
	
	/**
	 * Other SO Search List
	 * @param e EsdEas0003Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchOtherSOCheckList(Event e) throws EventException;
}