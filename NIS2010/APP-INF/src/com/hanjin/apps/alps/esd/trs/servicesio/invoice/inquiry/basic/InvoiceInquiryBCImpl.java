/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCreationBCImpl.java
*@FileTitle : SPP TRS Inquiry Basic Command Implementation
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-05-15 sunghwan cho : searchInvoiceInquiryExcelExtract 메서드 추가
* 2007-08-03 Jung-Jae Kim : 프레임워크 표준에 따른 패키지 수정
*@LastModifyDate : 2007-08-03
*@LastModifier : Jung-Jae Kim
*@LastVersion : 1.2
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.basic;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.event.InvoiceInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.event.SppTrsI05Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.integration.InvoiceInquiryDBDAO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * Basic Command Implementation<br>
 * - SPP TRS Inquiry Basic Command Implementation<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceInquiryBCImpl extends BasicCommandSupport implements InvoiceInquiryBC {
	private static final long serialVersionUID = 1L;
	
	//Database Access Object
	private transient InvoiceInquiryDBDAO dbDao=null;

	/**
	 * 생성자<br>
	 * 
	 * @param void
	 * @return void
	 * @exception 
	 */
	public InvoiceInquiryBCImpl(){
		dbDao = new InvoiceInquiryDBDAO();
	}

	/**
	 * doEnd<br>
	 * 
	 */
	public void doEnd() {
		dbDao = null;
	}
	
	/**
	 * searchInvoiceCreationList<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return invoiceCreationData InvoiceCreationInquiry[]
	 * @exception EventException
	 */
	public InvoiceInquiry[] searchInvoiceInquiryList(Event e) throws EventException {
		
		//PDTO(Data Transfer Object including Parameters)
		SppTrsI05Event event = (SppTrsI05Event)e;
		InvoiceInquiry[] invoiceInquiryData = null;

		try {
			invoiceInquiryData = dbDao.searchInvoiceInquiryList(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return invoiceInquiryData;
		
	}
	
	/**
	 * searchInvoiceInquiryExcelExtract<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return invoiceCreationData InvoiceCreationInquiry[]
	 * @exception EventException
	 */

	public InvoiceInquiry[] searchInvoiceInquiryExcelExtract(Event e) throws EventException {
		
		//PDTO(Data Transfer Object including Parameters)
		SppTrsI05Event event = (SppTrsI05Event)e;
		InvoiceInquiry[] invoiceInquiryData = null;

		try {
			invoiceInquiryData = dbDao.searchInvoiceInquiryExcelExtract(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return invoiceInquiryData;
		
	}
	
	
	/**
	 * searchInvoiceInquiryExcelExtract<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return invoiceCreationData InvoiceCreationInquiry[]
	 * @exception EventException
	 */

	public InvoiceInquiry searchInvoiceInquiryExcelHeader(Event e) throws EventException {
		
		//PDTO(Data Transfer Object including Parameters)
		SppTrsI05Event event = (SppTrsI05Event)e;
		InvoiceInquiry invoiceInquiryData = null;

		try {
			invoiceInquiryData = dbDao.searchInvoiceInquiryExcelHeader(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return invoiceInquiryData;
		
	}

	
	/**
	 * searchInvoiceEquipmentList<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param vendorCode String
	 * @param invoiceNo String
	 * @return response InvoiceCreationInquiry[]
	 * @exception EventException
	 */
	public InvoiceCreationInquiry[] searchInvoiceEquipmentList(String vendorCode, String invoiceNo) throws EventException {
		
		InvoiceCreationInquiry[] invoiceCreationData = null;

		try {
			invoiceCreationData = dbDao.searchInvoiceEquipmentList(vendorCode, invoiceNo);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return invoiceCreationData;
		
	}
	
}