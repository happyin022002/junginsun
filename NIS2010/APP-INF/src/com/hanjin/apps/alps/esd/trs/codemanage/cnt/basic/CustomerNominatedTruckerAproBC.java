/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomerNominatedTruckerAproBC.java
*@FileTitle : CNT(Customer Nominated Trucker) Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2014-06-17
*@LastModifier : 김도현
*@LastVersion : 1.0
* 2014-05-28 최종혁
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.cnt.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author agreement
 * @see EsdTrs0087EventResponse 참조
 * @since J2EE 1.6
 */
public interface CustomerNominatedTruckerAproBC  {
	/**
	 * CNT(Customer Nominated Trucker) Approval 조회<br>
	 * 
	 * @param e ESD_TRS_0087Event
	 * @param account SignOnUserAccount
	 * @return EventResponse ESD_TRS_0087EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntApproval(Event e, SignOnUserAccount account) throws EventException;
	
	/**
	 * CNT(Customer Nominated Trucker) Approval - Approval Status 조회<br>
	 * 
	 * @param e ESD_TRS_0087Event
	 * @return EventResponse ESD_TRS_0087EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDtAproDiv(Event e) throws EventException;	

	/**
	 * CNT(Customer Nominated Trucker) Approval - Save <br>
	 * 
	 * @param e ESD_TRS_0087Event
	 * @param account SignOnUserAccount
	 * @return EventResponse ESD_TRS_0087EventResponse
	 * @exception EventException
	 */
	public EventResponse updateCntAproSave(Event e, SignOnUserAccount account) throws EventException;	

	/**
	 * CNT(Customer Nominated Trucker) Approval - Reject <br>
	 * 
	 * @param e ESD_TRS_0087Event
	 * @param account SignOnUserAccount
	 * @return EventResponse ESD_TRS_0087EventResponse
	 * @exception EventException
	 */
	public EventResponse updateCntRjct(Event e, SignOnUserAccount account) throws EventException;	

	/**
	 * CNT(Customer Nominated Trucker) Approval - Approval <br>
	 * 
	 * @param e ESD_TRS_0087Event
	 * @param account SignOnUserAccount
	 * @return EventResponse ESD_TRS_0087EventResponse
	 * @exception EventException
	 */
	public EventResponse updateCntApro(Event e, SignOnUserAccount account) throws EventException;	

	/**
	 * CNT(Customer Nominated Trucker) Approval - Save <br>
	 * 
	 * @param e ESD_TRS_0087Event
	 * @param account SignOnUserAccount
	 * @return EventResponse ESD_TRS_0087EventResponse
	 * @exception EventException
	 */
	public EventResponse saveCntApro(Event e, SignOnUserAccount account) throws EventException;
	
	/**
	 * CNT(Customer Nominated Trucker) Approval - Cancle <br>
	 * 
	 * @param e ESD_TRS_0087Event
	 * @param account SignOnUserAccount
	 * @return EventResponse ESD_TRS_0087EventResponse
	 * @exception EventException
	 */
	public EventResponse updateCntCxl(Event e, SignOnUserAccount account) throws EventException;	

	/**
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Registration 화면의 Destination을 조회하는 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMtRtnYdNm(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Registration 화면의 AGMT No를 조회하는 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgmtNo(Event e) throws EventException;
	
	
	/**
	 * CNT(Customer Nominated Trucker) Approval S/P 화면의 Vendor 조회하는 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return String
	 * @exception EventException
	 */
	public String searchCntVendorCheck(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
     * CNT(Customer Nominated Trucker) Approval Grid Door Yard 변경시 Yard name 조회<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntAproDorYdNm(Event e) throws EventException;
	
	/**
	 * CNT(Customer Nominated Trucker) Approval - Delete <br>
	 * 
	 * @param e ESD_TRS_0087Event
	 * @param account SignOnUserAccount
	 * @return EventResponse ESD_TRS_0087EventResponse
	 * @exception EventException
	 */
	public EventResponse updateCntDel(Event e, SignOnUserAccount account) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
     * CNT(Customer Nominated Trucker) Approval Grid Door Yard 변경시 Location name 조회<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntAproDorLocNm(Event e) throws EventException;
	
}
