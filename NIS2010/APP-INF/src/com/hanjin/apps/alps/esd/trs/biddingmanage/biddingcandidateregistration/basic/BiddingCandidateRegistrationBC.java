/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BiddingManageSC.java
*@FileTitle : Bidding Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2015-06-01
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 1.0 최초 생성
* 
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author SHIN DONG IL
 * @see ESD_TRS_0940EventResponse,BiddingCandidateBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public interface BiddingCandidateRegistrationBC {
	/**
	 * 조회 이벤트 처리<br>
	 * Bidding Candidate 조회<br>
	 * 
	 * @param e Event 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSpotBidCnddtTermList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Bidding Candidate 조회<br>
	 * 
	 * @param e Event 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSpotBidCnddtVndrList(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Bidding Candidate 조회<br>
	 * 
	 * @param e Event 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse addSpotBidCnddtTerm(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Bidding Candidate 조회<br>
	 * 
	 * @param e Event 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse delSpotBidCnddtTerm(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Bidding Candidate 조회<br>
	 * 
	 * @param e Event 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse addSpotBidCnddtVndr(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Bidding Candidate 조회<br>
	 * 
	 * @param e Event 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse delSpotBidCnddtVndr(Event e) throws EventException;
}