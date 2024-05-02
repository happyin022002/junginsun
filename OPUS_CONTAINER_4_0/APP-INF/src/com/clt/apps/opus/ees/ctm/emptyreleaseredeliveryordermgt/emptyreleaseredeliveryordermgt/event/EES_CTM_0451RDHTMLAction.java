/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EES_CTM_0451RDHTMLAction.java
*@FileTitle : Release/Re-delivery Order
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.04.23 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EmptyReleaseRedeliveryOrderMgtSC로 실행요청<br>
 * - EmptyReleaseRedeliveryOrderMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM, Sang Soo
 * @see EmptyReleaseRedeliveryOrderMgtEvent 참조
 * @since J2EE 1.6
 */
public class EES_CTM_0451RDHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * EES_CTM_0451HTMLAction 객체를 생성
	 */
	public EES_CTM_0451RDHTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EmptyReleaseRedeliveryOrderMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		EesCtm0451RdEvent event = new EesCtm0451RdEvent();
		event.setStkFaxSndNo(request.getParameter("stk_fax_snd_no"));

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