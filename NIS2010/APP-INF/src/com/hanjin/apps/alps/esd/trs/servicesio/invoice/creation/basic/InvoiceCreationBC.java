/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCreationBC.java
*@FileTitle : SPP TRS 메인화면 Invoice 조회 Basic Command 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-28
*@LastModifier : sunghwan cho
*@LastVersion : 1.0
* 2006-12-28 sunghwan cho
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.basic;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiry;

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
public interface InvoiceCreationBC  {

	/**
	 * searchInvoiceNoticeList<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response InvoiceNoticeInquiry[]
	 * @exception EventException
	 */
	public InvoiceCreationInquiry[] searchInvoiceCreationList(Event e) throws EventException;
	
}