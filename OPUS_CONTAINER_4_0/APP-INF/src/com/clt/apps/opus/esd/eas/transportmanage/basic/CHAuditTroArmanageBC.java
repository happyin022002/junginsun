/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CHAuditTroArmanageBC.java
*@FileTitle : C/H Audit
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
 * CHAuditTroArmanageBC PDTO(Data Transfer Object including Parameters)<br>
 */
public interface CHAuditTroArmanageBC {

	/**
	 * Retrieve C/H Audit List
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchChAuditList(Event e) throws EventException;
	
	/**
	 * Retrieve C/H Audit Detail per BKG unit
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchChAuditBKGList(Event e) throws EventException;
	
	/**
	 * Retrieve Sub office Function of User choosed Office
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchSubOfficeList(Event e) throws EventException;
}
