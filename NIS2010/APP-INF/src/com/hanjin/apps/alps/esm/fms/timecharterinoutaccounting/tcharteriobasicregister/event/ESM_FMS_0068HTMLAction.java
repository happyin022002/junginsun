/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0068HTMLAction.java
*@FileTitle : Revenue Port Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.07.15 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomBsePortVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - NIS2010.APP-INF.src.com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TimeCharterInOutAccountingSC로 실행요청<br>
 * - TimeCharterInOutAccountingSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author  Choi Woo-Seok
 * @see TimeCharterInOutAccountingEvent 참조
 * @since J2EE 1.5
 */

public class ESM_FMS_0068HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_FMS_0068HTMLAction 객체를 생성
	 */
	public ESM_FMS_0068HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TimeCharterInOutAccountingEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsmFms0068Event event = new EsmFms0068Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setSlanCd(request.getParameter("slan_cd"));
			event.setRLaneCd(request.getParameter("rlane_cd"));
		} else if(command.isCommand(FormCommand.MULTI)) {
			event.setSlanCd(request.getParameter("slan_cd"));
			event.setRLaneCd(request.getParameter("rlane_cd"));
			event.setSearchType(request.getParameter("search_type"));
			event.setCustomBsePortVOS((CustomBsePortVO[])getVOs(request, CustomBsePortVO .class, "sheet1_"));
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