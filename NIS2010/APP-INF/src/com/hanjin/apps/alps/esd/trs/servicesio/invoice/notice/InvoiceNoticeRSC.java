/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceNoticeRSC.java
*@FileTitle : SPP TRS Notice
*Open Issues :
*Change history :
* 2007-01-02 sunghwan cho : 신규 작성
* 2007-04-10 sunghwan cho : parentVendorCode 추가 체크
*@LastModifyDate : 2007-04-10
*@LastModifier : sunghwan cho
*@LastVersion : 1.1
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.event.SppTrsI10Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.event.SppTrsI10EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.basic.InvoiceNoticeBC;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.basic.InvoiceNoticeBCImpl;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;

/**
 * Remote Service Component<br>
 * - SPP TRS Notice<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceNoticeRSC extends ServiceCommandSupport {
	private static final long serialVersionUID = 1L;
	
    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * - TRS 메인화면 Notice 관련 업무에서 발생하는 모든 이벤트의 분기처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        EventResponse eventResponse = null;

        if (e.getEventName().equalsIgnoreCase("SppTrsI10Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchInvoiceNoticeInquiry(e);
        	}
        }
        
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * - TRS 메인화면의 Pending Invoice건수와 최근 Invoice List화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     * @author sunghwan cho
     * @date 2006.12.28
     */
    private EventResponse searchInvoiceNoticeInquiry(Event e) throws EventException {
    	// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	SppTrsI10EventResponse eventResponse = null;
        
        try {
        	log.debug("[debug]=== InvoiceNoticeRSC searchInvoiceNoticeInquiry Start!");
        	begin();
        	
        	SppTrsI10Event event = (SppTrsI10Event)e;
        	eventResponse = new SppTrsI10EventResponse();
        	InvoiceNoticeBC basicCommand = new InvoiceNoticeBCImpl();

        	// 입력된 값 검증
        	// 벤더코드(필수)
        	if ( event.getVendorCode() == null || event.getVendorCode().equals("") ) {
        		throw new EventException("System error : first input vendor code!");
        	} else {
       			for (int i=0; i < event.getVendorCode().length(); i++ ) {
       				if ( "1234567890".indexOf(event.getVendorCode().substring(i, i+1)) < 0 ){
       					throw new EventException("System error : invalid vendor code!");
       				}
       			}
        	}
        	
        	//Parent 벤더코드(필수)
        	if ( event.getParentVendorCode() == null || event.getParentVendorCode().equals("") ) {
        		throw new EventException("System error : first input parent vendor code!");
        	} else {
       			for (int i=0; i < event.getParentVendorCode().length(); i++ ) {
       				if ( "1234567890".indexOf(event.getParentVendorCode().substring(i, i+1)) < 0 ){
       					throw new EventException("System error : invalid parent vendor code!");
       				}
       			}
        	}
        	
        	String mainFlag = event.getMainFlag();
        	
        	log.debug("[debug]=== InvoiceNoticeRSC searchInvoiceNoticeInquiry INPUT getVendorCode =" + event.getVendorCode());
        	log.debug("[debug]=== InvoiceNoticeRSC searchInvoiceNoticeInquiry INPUT getParentVendorCode =" + event.getParentVendorCode());
        	log.debug("[debug]=== InvoiceNoticeRSC searchInvoiceNoticeInquiry INPUT mainFlag =" + mainFlag);
        	
        	if(mainFlag != null && !"".equals(mainFlag)){
        		if("I".equals(mainFlag)){
                	//Invoice List 산출
                    eventResponse.setInvoiceNoticeData(basicCommand.searchInvoiceNoticeList(event));
                    log.debug("[debug]=== InvoiceNoticeRSC searchInvoiceNoticeList = " + eventResponse.getInvoiceNoticeData().length);
        		}else if("C".equals(mainFlag)){
                	//Pending Invoice Count 산출
                	eventResponse.setPendingInvoiceCount(basicCommand.searchInvoicePendingCount(event));
                	log.debug("[debug]=== InvoiceNoticeRSC searchInvoicePendingCount = " + eventResponse.getPendingInvoiceCount());
        		}
        	}
            commit();
            
            log.debug("[debug]=== InvoiceNoticeRSC searchInvoiceNoticeInquiry End!");
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
}
