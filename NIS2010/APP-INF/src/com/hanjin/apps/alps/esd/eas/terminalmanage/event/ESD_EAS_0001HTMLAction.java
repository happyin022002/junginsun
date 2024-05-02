/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_001HTMLAction.java
*@FileTitle : Rehandling Expense & TPB Check
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-04
*@LastModifier : Jun Ho Kim
*@LastVersion : 1.0
* 2008-01-04 Jun Ho Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.terminalmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * @author Jun Ho Kim
 * @see EsdEas0001Event , ESD_EAS_001EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_EAS_0001HTMLAction extends HTMLActionSupport {

	/**
     * ESD_EAS_003HTMLAction 객체를 생성
     */
    public ESD_EAS_0001HTMLAction() {
    }

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_EAS_001Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsdEas0001Event event = null;
		
		if(command.isCommand(FormCommand.SEARCH)){
			event = new EsdEas0001Event();
			String port = JSPUtil.getParameter(request, "port", "");
			String fmMonth = JSPUtil.getParameter(request, "fmMonth", "");
			String toMonth = JSPUtil.getParameter(request, "toMonth", "");
			String office = JSPUtil.getParameter(request, "office", "");
			String vvd = JSPUtil.getParameter(request, "vvd", "");
			String cntrNo = JSPUtil.getParameter(request, "cntr_no", "");
			
			event.setPort(port);
			event.setFmMonth(fmMonth);
			event.setToMonth(toMonth);
			event.setOffice(office);
			event.setVvd(vvd);
			event.setCntr_no(cntrNo);
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