/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCreationBCImpl.java
*@FileTitle : SPP TRS 메인화면 Invoice 조회 Basic Command Implementation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-28
*@LastModifier : sunghwan cho
*@LastVersion : 1.0
* 2006-12-28 sunghwan cho
* 1.0 최초 생성
=========================================================
History
2012.02.15 윤권영 [CHM-201216122][SPP] Cancelled W/O 에 대한 Invoice 처리 불가 메세지 추가(1건)
2012.02.22 윤권영 [] 품질 결함 수정-메소드 주석을 기술한다:확인결과 해당사항 없음.
2012.03.02 윤권영 [] 품질 결함 수정-메소드 주석을 기술한다 : @return 에 대한 return; 를 추가적용(1건)
2012.03.13 윤권영 [] 품질 결함 수정-메소드 주석을 기술한다 : 메소드 주석 @return 삭제(1건)
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.basic;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.integration.InvoiceCreationDBDAO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.SppTrsI01Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.SppTrsU02Event;

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
public class InvoiceCreationBCImpl extends BasicCommandSupport implements InvoiceCreationBC {
	private static final long serialVersionUID = 1L;
	
	//Database Access Object
	private transient InvoiceCreationDBDAO dbDao=null;

	/**
	 * 생성자<br>
	 * 
	 * @param void
	 * @return void
	 * @exception 
	 */
	public InvoiceCreationBCImpl(){
		dbDao = new InvoiceCreationDBDAO();
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
	public InvoiceCreationInquiry[] searchInvoiceCreationList(Event e) throws EventException {
		
		//PDTO(Data Transfer Object including Parameters)
		SppTrsI01Event event = (SppTrsI01Event)e;
		InvoiceCreationInquiry[] invoiceCreationData = null;

		try {
			invoiceCreationData = dbDao.searchInvoiceCreationList(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return invoiceCreationData;
		
	}
	
	/**
	 * checkExistWorkOrderNo<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @exception EventException
	 */
	public void checkExistWorkOrderNo(Event e) throws EventException {
		//PDTO(Data Transfer Object including Parameters)
		SppTrsI01Event event = (SppTrsI01Event)e;
		try {		
			dbDao.checkExistWorkOrderNo(event);
		}catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return;
	}
	
}