/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_5101HTMLAction.java
*@FileTitle : Hold Reason Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.12 mun jung cheol
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.apls.ees.dmt.dmtexceptionmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DMTExceptionMgtSC로 실행요청<br>
 * - DMTInvoiceMgtSC 에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author mun jung cheol
 * @see DMTExceptionMgtEvent 참조
 * @since J2EE 1.4
 */

public class EES_DMT_5101HTMLAction extends HTMLActionSupport {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 InvoiceMgtEvent로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
        FormCommand command = FormCommand.fromRequest(request);
        String invoiceNo = JSPUtil.getParameter(request, "invoiceNo".trim(), "");
        String holdReasn = JSPUtil.getParameter(request, "holdReasn".trim(), "");
        String holdRemrk = JSPUtil.getParameter(request, "holdRemrk".trim(), "");
        
        log.debug("####### HTML searchHoldReason invoiceNo [" + invoiceNo + "]");

        EesDmt5101Event event = new EesDmt5101Event();
        event.setAttribute("invoiceNo",invoiceNo);        
        event.setAttribute("holdReasn",holdReasn);
        event.setAttribute("holdRemrk",holdRemrk);
        if(command.isCommand(FormCommand.SEARCH01)) {
            event.setInvoiceNo(invoiceNo);
        }else if(command.isCommand(FormCommand.SEARCH)) {
            event.setInvoiceNo(invoiceNo);
        }else if(command.isCommand(FormCommand.MULTI)) {
            event.setInvoiceNo(invoiceNo);
            event.setHoldReasn(holdReasn);
            event.setHoldRemrk(holdRemrk);
        }
        return  event;
    }

    /**
     * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
     * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @param eventResponse EventResponse interface를 구현한 객체
     */
    public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
        request.setAttribute("EventResponse", eventResponse);
    }

    /**
     * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
     * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @param event Event interface를 구현한 객체
     */
    public void doEnd(HttpServletRequest request, Event event) {
        request.setAttribute("Event", event);
    }
}