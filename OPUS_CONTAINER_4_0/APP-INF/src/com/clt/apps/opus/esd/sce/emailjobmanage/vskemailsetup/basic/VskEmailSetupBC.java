/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VskEmailSetupBC.java
*@FileTitle : VSL SKD e-mailing Set-up
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.06
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.08.06 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsetup.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;

/**
 * Emailjobmanage Business Logic Command Interface<br>
 * - Emailjobmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Park Jun Yong
 * @see GeneralEventResponse 
 * @since J2EE 1.6
 */
public interface VskEmailSetupBC {
	
	/**
	 * VSL E-MAIL 대상 조회<br>
	 * @return EventResponse
	 * @throws EventException
	 */
	public GeneralEventResponse searchVslSkdEmlSetUp() throws EventException;
	
	/**
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse addVslSkdEmlSetUp(Event e) throws EventException;
	
	/**
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse removeVslSkdEmlSetUp(Event e) throws EventException; 
	
	/**
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public GeneralEventResponse searchLaneVerify(Event e) throws EventException;
	
	/**
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public GeneralEventResponse searchPortVerify(Event e) throws EventException;
}