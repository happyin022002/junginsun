/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_7006HTMLAction.java
*@FileTitle : Fax/E-mail Sending History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.14 mun jung cheol
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtPayrCntcPntVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.PayerInfoListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.apls.ees.dmt.dmtexceptionmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DMTExceptionMgtSC로 실행요청<br>
 * - DMTInvoiceMgtSC 에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author mun jung cheol
 * @see DMTExceptionMgtEvent 참조
 * @since J2EE 1.4
 */

public class EES_DMT_7020HTMLAction extends HTMLActionSupport {
    
    private static final long serialVersionUID = 1L;
    
    private static final String CREATE_URI = "/hanjin/EES_DMT_7020.do";
    private static final String INQUIRY_URI = "/hanjin/EES_DMT_7021.do";
    
    
    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 InvoiceMgtEvent로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
        
        FormCommand command = FormCommand.fromRequest(request);
        EesDmt7020Event event = new EesDmt7020Event();
        
        // Creation & Inquiry 두가지 화면의 구분을 위해 프로그램 번호 세팅
        if(request.getRequestURI().equals(CREATE_URI)) {
        	event.setProgramNo("EES_DMT_7020");        	
        } else if(request.getRequestURI().equals(INQUIRY_URI)) {
        	event.setProgramNo("EES_DMT_7021");
        }
        
        if(command.isCommand(FormCommand.SEARCH)) {
        	event.setPayerInfoListVO((PayerInfoListVO)getVO(request, PayerInfoListVO.class));
        }else if (command.isCommand(FormCommand.MULTI)) {
        	PayerInfoListVO payerInfoListVO = new PayerInfoListVO();
    		event.setPayerInfoListVOs(payerInfoListVO.fromRequestGrid(request));
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
