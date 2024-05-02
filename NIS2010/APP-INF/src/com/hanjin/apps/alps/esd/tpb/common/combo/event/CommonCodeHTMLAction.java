/*=========================================================
*Copyright(c) 2006~2010 CyberLogitec
*@FileName : CommonCodeHTMLAction.java
*@FileTitle : 3자구상 유형등록
*Open Issues :
*Change history :
*@LastModifyDate : 2009-12-07
*@LastModifier : Sun, CHOI
*@LastVersion : 1.3
* 2006-10-09 Youngchang_Kim 1.0 최초 생성
* 2009-09-07 O Wan-Ki       1.1 ITM-200900076, getThirdPartyBillingCaseHorizontally 에 의한 보완
* 2009-11-19 Sun, CHOI      1.2 ALPS Migration
* 2009-12-07 Sun, CHOI      1.3 func parameter 추가
* 2010-10-22 손은주 [CHM-201006504-01] [TPB] Currency Change Validation 보완 -  event의 attribute setting command로 구분 
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.combo.event;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.tpb.common.TPBUtils;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.tpb.codemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CodeManageSC로 실행요청<br>
 * - CodeManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Youngchang_Kim
 * @see EsdTpb0001Event , EsdTpb0001EventResponse 참조
 * @since J2EE 1.4
 */
public class CommonCodeHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EsdTpb001HTMLAction 객체를 생성 
	 */
	public CommonCodeHTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdTpb001Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings("unchecked")
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		CommonCodeEvent event = new CommonCodeEvent();
		
		HashMap params =  TPBUtils.getParams(request);
		
		
		if(command.isCommand(FormCommand.SEARCH01)) {
			log.debug("=================SEARCH01========="+params);
			event.setAttribute("id", JSPUtil.getParameter(request, "id"));
			event.setAttribute("mode", JSPUtil.getParameter(request, "mode"));
			event.setAttribute("obj", JSPUtil.getParameter(request, "obj"));
			event.setAttribute("all", JSPUtil.getParameter(request, "all"));
			event.setAttribute("method", JSPUtil.getParameter(request, "method"));
			
		}else{
		
		log.debug("=========================="+params);
		event.setAttribute("id", JSPUtil.getParameter(request, "id"));
		event.setAttribute("mode", JSPUtil.getParameter(request, "mode"));
		event.setAttribute("obj", JSPUtil.getParameter(request, "obj"));
		event.setAttribute("all", JSPUtil.getParameter(request, "all"));
		event.setAttribute("otherObjs", JSPUtil.getParameter(request, "otherObjs"));
		event.setAttribute("callback", JSPUtil.getParameter(request, "callback"));
		
		//2009-09-07 ITM-200900076, getThirdPartyBillingCaseHorizontally 에 의한 보완
		//getThirdPartyBillingCaseHorizontally(div,ord,met,rec_obj)
		event.setAttribute("hdiv", JSPUtil.getParameter(request, "hdiv"));
		//2009-12-07 func parameter 추가
		event.setAttribute("func", JSPUtil.getParameter(request, "func"));
		event.setAttribute("ord", JSPUtil.getParameter(request, "ord"));
		event.setAttribute("rec_obj", JSPUtil.getParameter(request, "rec_obj"));
		}
		event.setEventParams(params);
		request.setAttribute("Event", event);

		return event;
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