/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName 		: LEACommonHTMLAction.java
*@FileTitle 	:  
*Open Issues 	:
*Change history :
*@LastModifyDate: 2006-09-07
*@LastModifier 	: junghyung kim
*@LastVersion 	: 1.0
* 2006-09-07 junghyung kim
* 1.0 최초 생성
* @History
* 2011-05-02 이정수 : Office COMBO가 정상적으로 생성되도록 수정
=========================================================*/
package com.hanjin.apps.alps.esd.lea.common.codecomboutil.event;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.lea.common.LEAUtils;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.enis.esd.lea 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 LEACommonSC로 실행요청<br>
 * - LEACommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author junghyung kim
 * @see CommonEvent 참조
 * @since J2EE 1.4
 */
public class CommonHTMLAction extends HTMLActionSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5990745731311751667L;

	/**
     * CommonHTMLAction 객체를 생성
     */
    public CommonHTMLAction() {
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 CommonEvent로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
        // 화면에 있는 컨트롤 변수들
    	FormCommand command = FormCommand.fromRequest(request);
    	CommonEvent event = new CommonEvent();
    	
    	HashMap hash = LEAUtils.requestToHashMap(request);
    	event.setAttribute("fRequest", hash);
    	
        event.setCommandClassName("LEACommonSC");
        event.setFormCommand(command);
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