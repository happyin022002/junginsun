/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderInquiryBC.java
*@FileTitle : W/O 발행내역을 조회하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-26
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2006-12-26 poong_yeon
* 1.0 최초 생성
* 2015.07.20 9014787 [CHM-201536387] ALPS Auth 사후 결재 기능 개발
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-workordermanage Business Logic Command Interface<br>
 * - ESD-workordermanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author poong_yeon
 * @see EsdTrs0025EventResponse 참조
 * @since J2EE 1.4
 */
public interface WorkOrderInquiryBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_025Event
	 * @return EventResponse ESD_TRS_025EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderInquiry(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchWorkOrderInquiryList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchWorkOrderList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchSvcOrdHisList(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchWorkOrderInquiryAddCancel(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrder Auth화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse searchAuthWrkOrdList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Authorization Approval Confirm 화면에 대한 TRS 용 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse searchAuthApproTrsList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Authorization Approval Inquiry 화면에 대한 TRS 용 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse searchAuthAproTrsInquiry(Event e) throws EventException;

}