/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PLSEInvoiceInquirySC.java
*@FileTitle : Rental payable invoice inquiry by Lessee via SPP
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.08.18 김성광
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.exp.spp.plseinvoiceinquiry;

import java.util.List;

//import com.hanjin.apps.alps.exp.spp.plseinvoiceinquiry.invoiceinquiry.integration;
import com.hanjin.apps.alps.exp.spp.plseinvoiceinquiry.invoiceinquiry.basic.InvoiceInquiryBC;
import com.hanjin.apps.alps.exp.spp.plseinvoiceinquiry.invoiceinquiry.basic.InvoiceInquiryBCImpl;
import com.hanjin.apps.alps.exp.spp.plseinvoiceinquiry.invoiceinquiry.event.ExpSpp0302Event;
import com.hanjin.apps.alps.exp.spp.plseinvoiceinquiry.invoiceinquiry.vo.PayableInvoiceDataVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-PLSEInvoiceInquiry Business Logic ServiceCommand - ALPS-PLSEInvoiceInquiry 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Kim Seong Kwang
 * @see InvoiceInquiryDBDAO
 * @since J2EE 1.4
 */

public class PLSEInvoiceInquirySC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * PLSEInvoiceInquiry system 업무 시나리오 선행작업<br>
	 * EXP_SPP_0302 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("PLSEInvoiceInquirySC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * PLSEInvoiceInquiry system 업무 시나리오 마감작업<br>
	 * EXP_SPP_0302 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("PLSEInvoiceInquirySC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-PLSEInvoiceInquiry system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse response 
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if(e.getEventName().equalsIgnoreCase("ExpSpp0302Event")){  //EXP_SPP_0302 Rental payable invoice inquiry by Lessee via SPP UI
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {  //when Retreive button click
				eventResponse = searchPayableInvoiceService(e);
			}
		}
		
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Rental payable invoice inquiry by Lessee via SPP 화면의 retrieve 조회 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse response 
	 * @exception EventException
	 */
	private EventResponse searchPayableInvoiceService(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		ExpSpp0302Event event = (ExpSpp0302Event)e;
		InvoiceInquiryBC command = new InvoiceInquiryBCImpl();
		try{
			List<PayableInvoiceDataVO> list = command.searchPayableInvoiceBasic(event.getPayableInvoiceDataVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	

		return eventResponse;
	}
	

	
}