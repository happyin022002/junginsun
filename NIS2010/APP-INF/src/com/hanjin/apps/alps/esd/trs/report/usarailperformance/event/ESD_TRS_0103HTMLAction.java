/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0103HTMLAction.java
*@FileTitle : USA Rail Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2011-06-10
*@LastModifier : 김종호
*@LastVersion : 1.2
* 2007-12-19 Jun Ho Kim
* 1.0 최초 생성
* 1.2 2011.06.10 김종호 [CHM-201110817][TRS] US Rail report 기능 보완
* 2013.05.15 조인영 [CHM-201324500] Rail performance report by SO (NYCNA) domestic data 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.usarailperformance.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.apps.alps.esd.trs.report.usarailperformance.vo.SearchRailPerformanceVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.report 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 USARailPerformanceSC로 실행요청<br>
 * - USARailPerformanceSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Jun Ho Kim
 * @see EsdTrs0103Event 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0103HTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_0103HTMLAction 객체를 생성
	 */
	public ESD_TRS_0103HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_102Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
        
		FormCommand   command = FormCommand.fromRequest(request);
		EsdTrs0103Event event = new EsdTrs0103Event();
        
        if (command.isCommand(FormCommand.SEARCH01) || 
        	command.isCommand(FormCommand.SEARCH02) ||
        	command.isCommand(FormCommand.SEARCH12) ||
		    command.isCommand(FormCommand.SEARCH03) ||
		    command.isCommand(FormCommand.SEARCH13) ||
		    command.isCommand(FormCommand.SEARCH04) || 
		    command.isCommand(FormCommand.SEARCH05) || 
		    command.isCommand(FormCommand.SEARCH06) || 
		    command.isCommand(FormCommand.SEARCH14) || 
		    command.isCommand(FormCommand.SEARCH15) || 
		    command.isCommand(FormCommand.SEARCH16) || 
		    command.isCommand(FormCommand.SEARCH17)) {
        	event.setSearchRailPerformanceVo((SearchRailPerformanceVO) getVO(request, SearchRailPerformanceVO.class));	
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