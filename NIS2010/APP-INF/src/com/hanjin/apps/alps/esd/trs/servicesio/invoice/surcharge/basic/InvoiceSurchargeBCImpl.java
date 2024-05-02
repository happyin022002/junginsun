/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCreationBCImpl.java
*@FileTitle : SPP TRS Basic Command Implementation
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
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.SppTrsU02Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.integration.InvoiceSurchargeDBDAO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.event.SppTrsI04Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.event.InvoiceSurchargeInquiry;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * Basic Command Implementation<br>
 * - SPP TRS Surcharge Basic Command Implementation<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceSurchargeBCImpl extends BasicCommandSupport implements InvoiceSurchargeBC {
	private static final long serialVersionUID = 1L;
	
	//Database Access Object
	private transient InvoiceSurchargeDBDAO dbDao=null;

	/**
	 * 생성자<br>
	 * 
	 * @param void
	 * @return void
	 * @exception 
	 */
	public InvoiceSurchargeBCImpl(){
		dbDao = new InvoiceSurchargeDBDAO();
	}

	/**
	 * doEnd<br>
	 * 
	 */
	public void doEnd() {
		dbDao = null;
	}
	
	/**
	 * searchInvoiceSurchargeInquiry<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return invoiceCreationData InvoiceCreationInquiry[]
	 * @exception EventException
	 */
	public InvoiceSurchargeInquiry[] searchInvoiceSurchargeInquiry(Event e) throws EventException {
		
		//PDTO(Data Transfer Object including Parameters)
		SppTrsI04Event event = (SppTrsI04Event)e;
		InvoiceSurchargeInquiry[] invoiceSurchargeData = null;

		try {
			invoiceSurchargeData = dbDao.searchInvoiceSurchargeInquiry(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return invoiceSurchargeData;
		
	}
	
	/**
	 * searchWorkOrderSurchargeInquiry<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return invoiceCreationData InvoiceCreationInquiry[]
	 * @exception EventException
	 */
	public InvoiceSurchargeInquiry[] searchWorkOrderSurchargeInquiry(Event e) throws EventException {
		
		//PDTO(Data Transfer Object including Parameters)
		SppTrsI04Event event = (SppTrsI04Event)e;
		InvoiceSurchargeInquiry[] invoiceSurchargeData = null;

		try {
			invoiceSurchargeData = dbDao.searchWorkOrderSurchargeInquiry(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return invoiceSurchargeData;
		
	}
	
	/**
	 * searchWorkOrderSurchargeInquiryForTRS<br>
	 * 조회 이벤트 처리<br>
	 * inserted by kjj(2007.07.20), sending parameters to TRS
	 * 
	 * @param e Event
	 * @param surchargeVOCollection Collection
	 * @return Collection
	 * @throws EventException
	 */
	public Collection searchWorkOrderSurchargeInquiryForTRS(Event e,Collection surchargeVOCollection) throws EventException {
		
		//PDTO(Data Transfer Object including Parameters)
		SppTrsU02Event event = (SppTrsU02Event)e;

		try {
			surchargeVOCollection = dbDao.searchWorkOrderSurchargeInquiryForTRS(event,surchargeVOCollection);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return surchargeVOCollection;
		
	}

}
