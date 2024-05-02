/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1022HTMLAction.java
*@FileTitle : MTY Repo Inquiry by VVD
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.enis.ees.eqr.cntrcodconfirm 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 cntrcodconfirmSC로 실행요청<br>
 * - cntrcodconfirmSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author dev098
 * @see EesEqr1022Event 참조
 * @since J2EE 1.6
 */
public class EES_EQR_1022HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;
    /**
     * EES_EQR_1049HTMLAction 객체를 생성
     */
    public EES_EQR_1022HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 CNTROperatioNPerformanceMgtEvent로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
        FormCommand command = FormCommand.fromRequest(request);
        EesEqr1022Event event = new EesEqr1022Event();
        

        if(command.isCommand(FormCommand.SEARCH)) {
            String vvd = request.getParameter("vvd");
            String version = request.getParameter("version");
            event.setAttribute("vvd", vvd);
            event.setAttribute("version", version);
        }else if(command.isCommand(FormCommand.SEARCH01)) {
            String vvd = request.getParameter("vvd");
            event.setAttribute("vvd", vvd);
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
