/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RehandExpmanageBC.java
*@FileTitle : Rehandling Expense & TPB Check
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.esd.eas.terminalmanage.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ENIS-RehandExpmanage Business Logic Command Interface<br>
 */
public interface RehandExpmanageBC  {

	/**
	 * Handling Retrieve Event of RehandExpmanage<br>
	 * 
	 * @param e ESD_EAS_001Event
	 * @return EventResponse ESD_EAS_0001EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRehandTPBCheckList(Event e) throws EventException;

	/**
	 * Expense Audit Remark 
	 * @param e Event
	 * @return response ESD_EAS_0901EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRehandExpnAudRmk(Event e) throws EventException;
	
	/**
	 * Expense Audit Remark modify
	 * @param e Event
	 * @return response ESD_EAS_0901EventResponse
	 * @exception EventException
	 */
	public EventResponse multiRehandExpnAudRmk(Event e) throws EventException;

	
	
}