/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0942HTMLAction.java
*@FileTitle : eDO Issue Application Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InboundBLMgtSC로 실행요청<br>
 * - InboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author
 * @see EsmBkg0682Event 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0942HTMLAction extends HTMLActionSupport {

    /**
     *
     */
    private static final long serialVersionUID = -3889119389133086344L;

    public ESM_BKG_0942HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsmBkg0942Event로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {

        FormCommand command = FormCommand.fromRequest(request);
        EsmBkg0942Event event = new EsmBkg0942Event();

        String cntrNo    = "";
        String poNo     = "";
        
        log.debug("===================================");
        log.debug("    ESM_BKG_0942HTMLAction Start   " + request.getParameter("frm_cntr_no"));
        log.debug("===================================");



        	cntrNo = request.getParameter("frm_cntr_no");
        	poNo  = request.getParameter("frm_po_no");
            
            event.setCntrNo(cntrNo);
            event.setPoNo(poNo);

            log.debug("=======================================");
            log.debug("    cntrNo1  : "+ cntrNo                 );
            log.debug("    poNo2    : "+ poNo                   );
            log.debug("    poNo3    : "+ command.isCommand (FormCommand.SEARCH));
            log.debug("=======================================");

        if(command.isCommand(FormCommand.SEARCH)) {

            log.debug("===================================");
            log.debug("    SEARCH EVENT                   ");
            log.debug("===================================");

        }
        request.setAttribute("Event", event);
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