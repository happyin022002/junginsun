/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0888HTMLAction.java
*@FileTitle : Special Cargo Available S/P
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-30
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2014-12-30 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.codemanage.usaactualcustomercodemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CodeManageSC로 실행요청<br>
 * - CodeManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author SHIN DONG IL
 * @see EsdTrs00888Event , ESD_TRS_0888EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0888HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_0888HTMLAction 객체를 생성 
	 */
	public ESD_TRS_0888HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_088Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
//		FormCommand command = FormCommand.fromRequest(request);
		RcvInvEdiHitEvent event = new RcvInvEdiHitEvent();

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