/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ROUTUnMatmanageBC
*@FileTitle : Route Unmatch List
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
 * ROUTUnMatmanageBC PDTO(Data Transfer Object including Parameters)<br>
 */
public interface ROUTUnMatmanageBC {

	
	/**
	 * Route Unmatch List Main
	 * @param e EsdEas0002Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchRoutUnMatList(Event e) throws EventException;

	/**
	 * Route Unmatch List Detail First
	 * @param e Event
	 * @return response ESD_EAS_0002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRoutUnMatBlInforDetail(Event e) throws EventException;

	/**
	 * Route Unmatch List Detail Second
	 * @param e Event
	 * @return response ESD_EAS_0002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRoutUnMatSoInforDetail(Event e) throws EventException;
	
	/**
	 * Retrieve Expense Audit Remark
	 * @param e Event
	 * @return response ESD_EAS_0902EventResponse
	 * @exception EventException
	 */
	public EventResponse searchExpnAudRmk(Event e) throws EventException;
	
	/**
	 * Modify Expense Audit Remark
	 * @param e Event
	 * @return response ESD_EAS_0902EventResponse
	 * @exception EventException
	 */
	public EventResponse multiExpnAudRmk(Event e) throws EventException;
}
