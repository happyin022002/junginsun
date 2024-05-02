/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_GEM_0001HTMLAction.java
*@FileTitle : Expense Tab parnet 창 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.04.21 최정미
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * [UI_GEM-0001] Authorized Expense Code
 * HTTP Parser<br>
 * @author choijungmi
 * @see CpsGem0001Event 참조
 * @since J2EE 1.4
 */

public class CPS_GEM_0001HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_GEM_0001HTMLAction 객체를 생성
	 */
	public CPS_GEM_0001HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GEMCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		CpsGem0001Event event = new CpsGem0001Event();		
		// RequestNo 
		String authFlg = JSPUtil.getParameter(request, "auth_flg" , "");
		event.setAuthFlg(authFlg);
				
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