/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_MAS_0162HTMLAction.java
*@FileTitle : Revenue Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2016-06-22
*@LastModifier : Young-Heon Lee
*@LastVersion :
*  2016-06-22 Young-Heon Lee
*  1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.event;


import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.vo.RevenueDetailCondVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WeeklyPFMCSC로 실행요청<br>
 * - NetworkCostSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Young-Heon Lee
 * @see EsmMas0162Event 참조
 * @since J2EE 1.6
 */
public class ESM_MAS_0162HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_MAS_0162HTMLAction 객체를 생성
	 */
	public ESM_MAS_0162HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmMas0251Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
    	EsmMas0162Event event = new EsmMas0162Event();  		
    	
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setRevenueDetailCondVO((RevenueDetailCondVO)getVO(request, RevenueDetailCondVO .class));
		}

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
