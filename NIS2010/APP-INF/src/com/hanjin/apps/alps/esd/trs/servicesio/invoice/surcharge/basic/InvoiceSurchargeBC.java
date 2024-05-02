/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCreationBC.java
*@FileTitle : SPP TRS 메인화면 Invoice 조회 Basic Command 
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-04-04 sunghwan cho : Submit 기능을 PI eNIS모듈 호출방식으로 변경하여, 관련 루틴 삭제
* 2007-04-13 sunghwan cho : WorkOrder, Invoice Surcharge SQL 준리
* 2007-07-20 jungjae  kim : to send parameters to TRS, searchWorkOrderSurchargeInquiryForTRS 추가
*@LastModifyDate : 2007-07-20
*@LastModifier : jungjae  kim
*@LastVersion : 1.3
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.basic;

import java.util.Collection;

import com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.event.SurchargeVO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.event.InvoiceSurchargeInquiry;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * SPP TRS Invoice Command Interface<br>
 * - SPP TRS 메인화면 Invoice 관련 Interface<br>
 * 
 * @author sunghwan cho
 * @see SppTrsI10EventResponse,InvoiceNoticeBC 참조
 * @since J2EE 1.4
 */
public interface InvoiceSurchargeBC  {

	/**
	 * searchInvoiceSurchargeInquiry<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response InvoiceSurchargeInquiry[]
	 * @exception EventException
	 */
	public InvoiceSurchargeInquiry[] searchInvoiceSurchargeInquiry(Event e) throws EventException;

	/**
	 * searchWorkOrderSurchargeInquiry<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response InvoiceSurchargeInquiry[]
	 * @exception EventException
	 */
	public InvoiceSurchargeInquiry[] searchWorkOrderSurchargeInquiry(Event e) throws EventException;
	
	/**
	 * searchWorkOrderSurchargeInquiryForTRS<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @param surchargeVOCollection Collection
	 * @return Collection
	 * @throws EventException
	 */
	public Collection searchWorkOrderSurchargeInquiryForTRS(Event e,Collection surchargeVOCollection) throws EventException;
	
}