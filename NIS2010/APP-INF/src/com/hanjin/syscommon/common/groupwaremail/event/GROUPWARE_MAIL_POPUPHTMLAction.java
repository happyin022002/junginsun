/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : GROUPWARE_MAIL_POPUPHTMLAction.java
*@FileTitle : Groupware_Mail_Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김정훈
*@LastVersion : 1.0
* 2009.05.26 김정훈
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.common.groupwaremail.event;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.io.FileUtils;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;

/**
 * HTTP Parser<br>
 * - com.hanjin.sample.webservice 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WebServiceSC로 실행요청<br>
 * - WebServiceSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jeong-Hoon, Kim
 * @see WebServiceEvent 참조
 * @since J2EE 1.6
 */

public class GROUPWARE_MAIL_POPUPHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * GROUPWARE_MAIL_POPUPHTMLAction 객체를 생성
	 */
	public GROUPWARE_MAIL_POPUPHTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 WebServiceEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		GroupwareMailPopupEvent event = new GroupwareMailPopupEvent();
		event.setGwSubject(request.getParameter("gw_subject"));
		if(null==request.getParameter("gw_to")){
			event.setGwTo("");
		}else{
			event.setGwTo(request.getParameter("gw_to"));
		}
		if(null==request.getParameter("gw_cc")){
			event.setGwCc("");
		}else{
			event.setGwCc(request.getParameter("gw_cc"));
		}
		String template = request.getParameter("gw_template");
		String[] args = request.getParameterValues("gw_args");
		if(template != null && !"".equals(template.trim())){
			event.setGwContents(useTemplate(template, args));
		}else{
			event.setGwContents(request.getParameter("gw_contents"));
		}
		request.setAttribute("Event", event);

		return  event;
	}

	/**This method gets a template.
	 * @author Jeong-Hoon, KIM
	 * @param template
	 * @param args 
	 * @return
	 * @throws HTMLActionException 
	 */
	private String useTemplate(String template, String[] args) throws HTMLActionException {		
		try {
			return FileUtils.fileReader(SiteConfigFactory.get("COM.HANJIN.JAF.MAIL.TEMPLATE.DIR"), template, args);
		} catch (IOException e) {
			log.error("[IOException]The "+template+" which is template File doesn't exist.\n"+e.getMessage());
			throw new HTMLActionException("[IOException]The "+template+" which is template File doesn't exist.\n"+e.getMessage());
		}
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