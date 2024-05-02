/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MSCCheckmanageBC.java
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * MSCCheckmanageBC  PDTO(Data Transfer Object including Parameters)<br>
 */
public interface MSCCheckmanageBC {

	/**
	 * MSC Check Search List.
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchMSCList(Event e) throws EventException;
	

	/**
	 * Search EURO TRO Office
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchSubOfcList(Event e) throws EventException;
}
