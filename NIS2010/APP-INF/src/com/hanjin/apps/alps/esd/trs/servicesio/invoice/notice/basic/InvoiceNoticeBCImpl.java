/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceNoticeBCImpl.java
*@FileTitle : SPP TRS 메인화면 Invoice 조회 Basic Command Implementation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-28
*@LastModifier : sunghwan cho
*@LastVersion : 1.0
* 2006-12-28 sunghwan cho
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.basic;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.integration.InvoiceNoticeDBDAO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.event.SppTrsI10Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.event.InvoiceNoticeInquiry;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * SPP TRS Invoice Command Interface Implementation<br>
 * - SPP TRS 메인화면 Invoice 관련 Interface Implementation<br>
 * 
 * @author sunghwan cho
 * @see SppTrsI10EventResponse,InvoiceNoticeBC 참조
 * @since J2EE 1.4
 */
public class InvoiceNoticeBCImpl extends BasicCommandSupport implements InvoiceNoticeBC {
	private static final long serialVersionUID = 1L;
	
	//Database Access Object
	private transient InvoiceNoticeDBDAO dbDao=null;

	/**
	 * 생성자<br>
	 * 
	 * @param void
	 * @return void
	 * @exception 
	 */
	public InvoiceNoticeBCImpl(){
		dbDao = new InvoiceNoticeDBDAO();
	}

	/**
	 * doEnd<br>
	 * 
	 */
	public void doEnd() {
		dbDao = null;
	}
	
	/**
	 * searchInvoicePendingCount<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return iPendingInvoiceCount int
	 * @exception EventException
	 */
	public int searchInvoicePendingCount(Event e) throws EventException {
		
		//PDTO(Data Transfer Object including Parameters)
		SppTrsI10Event event = (SppTrsI10Event)e;
		int iPendingInvoiceCount = 0;

		try {
			iPendingInvoiceCount = dbDao.searchInvoicePendingCount(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return iPendingInvoiceCount;
		
	}

	/**
	 * searchInvoiceNoticeList<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return invoiceNoticeData InvoiceNoticeInquiry[]
	 * @exception EventException
	 */
	public InvoiceNoticeInquiry[] searchInvoiceNoticeList(Event e) throws EventException {
		
		//PDTO(Data Transfer Object including Parameters)
		SppTrsI10Event event = (SppTrsI10Event)e;
		InvoiceNoticeInquiry[] invoiceNoticeData = null;

		try {
			invoiceNoticeData = dbDao.searchInvoiceNoticeList(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return invoiceNoticeData;
		
	}
	
}