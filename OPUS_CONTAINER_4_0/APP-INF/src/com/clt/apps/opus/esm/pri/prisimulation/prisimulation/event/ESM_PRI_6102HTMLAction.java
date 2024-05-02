/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_6102HTMLAction.java
*@FileTitle : Revenue Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.12
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.AplyRtInVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.pri.pricommondata 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 PRICommonDataSC로 실행요청<br>
 * - PRICommonDataSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Dong-Sun Moon
 * @see PRICommonDataEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_6102HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_6102HTMLAction 객체를 생성
	 */
	public ESM_PRI_6102HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 PRICommonDataEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri6102Event event = new EsmPri6102Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setAplyRtInVO((AplyRtInVO)getVO(request, AplyRtInVO.class ));
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