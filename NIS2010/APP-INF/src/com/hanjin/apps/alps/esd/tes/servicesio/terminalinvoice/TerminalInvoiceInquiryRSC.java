/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SPP_TES_005RSC.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-18
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-10-18 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice;


import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.SppTes0005Event;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.SppTes0006Event;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.basic.TerminalInvoiceInquiryBC;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.basic.TerminalInvoiceInquiryBCImpl;

/**
 * SPP_TES Business Logic ServiceCommand<br>
 * - SPP_TES에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author doomi
 * @see SPP_TES_005EventResponse,TerminalInvoiceListDBDAO 참조
 * @since J2EE 1.4
 */
public class TerminalInvoiceInquiryRSC extends ServiceCommandSupport {
	
	
	// serial UID
	private static final long serialVersionUID = 1L;
	
    // Login User Information
    private SignOnUserAccount account = null;

    

    /**
     * tes 업무 시나리오 선행작업<br>
     * WorkOrder업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            account=getSignOnUserAccount();
        } catch (Exception e) {
            log.error("TerminalInvoiceInquiryRSC 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * tes 업무 시나리오 마감작업<br>
     * WorkOrder업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("TerminalInvoiceInquiryRSC 종료");
    }    
    
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * SPP_TES 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		log.debug("event : " + e);

		

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("SPP_TES_005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTerminalInvoiceList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTerminalInvoiceExcelPrint(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("SPP_TES_006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMarineTerminalInvoiceDiscrepancyCntr(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = searchOffDockCYInvoiceDiscrepancyCntr(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				eventResponse = searchMarineTerminalStorageInvoiceDiscrepancyCntr(e);
			}
		}
		return eventResponse;
	}


	
	/**
	 * 조회 이벤트 처리<br>
	 * WOInquiry의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalInvoiceList(Event e) throws EventException {
		
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
    
        // PDTO(Data Transfer Object including Parameters)
		SppTes0005Event event = (SppTes0005Event)e;
	 
		try {
			TerminalInvoiceInquiryBC command = new TerminalInvoiceInquiryBCImpl();
			eventResponse = command.searchTerminalInvoiceList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 엑셀 프린터 이벤트 처리<br>
	 * WOInquiry의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalInvoiceExcelPrint(Event e) throws EventException {
		
		
			    // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
    
        // PDTO(Data Transfer Object including Parameters)
		SppTes0005Event event = (SppTes0005Event)e;
	 
		try {
			TerminalInvoiceInquiryBC command = new TerminalInvoiceInquiryBCImpl();
			eventResponse = command.searchTerminalInvoiceExcelPrint(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchMarineTerminalInvoiceDiscrepancyCntr(Event e) throws EventException{
	    // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
    
        // PDTO(Data Transfer Object including Parameters)
		SppTes0006Event event = (SppTes0006Event)e;
	 
		try {
			TerminalInvoiceInquiryBC command = new TerminalInvoiceInquiryBCImpl();
			eventResponse = command.searchMarineTerminalInvoiceDiscrepancyCntr(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchOffDockCYInvoiceDiscrepancyCntr(Event e) throws EventException{
	    // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
    
        // PDTO(Data Transfer Object including Parameters)
        SppTes0006Event event = (SppTes0006Event)e;
	 
		try {
			TerminalInvoiceInquiryBC command = new TerminalInvoiceInquiryBCImpl();
			eventResponse = command.searchOffDockCYInvoiceDiscrepancyCntr(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchMarineTerminalStorageInvoiceDiscrepancyCntr(Event e) throws EventException{
	    // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
    
        // PDTO(Data Transfer Object including Parameters)
        SppTes0006Event event = (SppTes0006Event)e;
	 
		try {
			TerminalInvoiceInquiryBC command = new TerminalInvoiceInquiryBCImpl();
			eventResponse = command.searchMarineTerminalStorageInvoiceDiscrepancyCntr(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
}