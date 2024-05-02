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
 * DOFChgTrfmanageBC PDTO(Data Transfer Object including Parameters)<br>
 */
public interface DOFChgTrfmanageBC {

	
	/**
	 * search DofChgTrfList<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDofChgTrfList(Event e) throws EventException;
	
	/**
	 * search Effective date<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEffDT(Event e) throws EventException;
	
	/**
	 * Create, Modifu, Delete multiDofChgTrf
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiDofChgTrf( Event e ) throws EventException;
	
	/**
	 * search EURO Office code<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse searchEUROffcd( Event e ) throws EventException;
	
	/**
	 * search duplication count <br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse searchDofChgDupCnt( Event e ) throws EventException;
	
	/**
	 * verify Location by MDM<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse verifyLocCd( Event e ) throws EventException;

	/**
	 * verify Customer Cd by MDM<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse verifyCustCd( Event e ) throws EventException;

	/**
	 * verify Container Type Siez by MDM<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse verifyTpSz( Event e ) throws EventException;

	/**
	 * verify Currency by MDM<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse verifyCurr( Event e ) throws EventException;
	
}
