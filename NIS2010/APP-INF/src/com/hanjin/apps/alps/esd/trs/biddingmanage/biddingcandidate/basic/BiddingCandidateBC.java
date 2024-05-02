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
package com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.basic;

import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author SHIN DONG IL
 * @see ESD_TRS_0940EventResponse,BiddingCandidateBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public interface BiddingCandidateBC {
	/**
	 * 조회 이벤트 처리<br>
	 * Bidding Candidate 조회<br>
	 * 
	 * @param e Event 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchBiddingCandidateList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Vendor 조회<br>
	 * 
	 * @param e Event 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvitationVendor(Event e) throws EventException;
	
	/**
	 * ESD_TRS_0940 OK Event처리 
	 * Spot Bidding data생성
	 * 
	 * @param e Event
	 * @param account SignOnUserAccount   
	 * @exception EventException
	 */
	public void multiSpotBidManage(Event e,SignOnUserAccount account) throws EventException;
	
	/**
	 * ESD_TRS_0940 OK Event처리 
	 * Invitation E-mail 전송
	 * 
	 * @param e Event 
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void sendInvitationVendor(Event e,SignOnUserAccount account) throws EventException;
	
	/**
	 * S/O Delete Event처리시  
	 * Invitation Cancel E-mail 전송
	 * 
	 * @param singleTransportationVOS SingleTransportationVO[] 
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void sendMailSpotBiddingCancel(SingleTransportationVO[] singleTransportationVOS,SignOnUserAccount account) throws EventException;
}