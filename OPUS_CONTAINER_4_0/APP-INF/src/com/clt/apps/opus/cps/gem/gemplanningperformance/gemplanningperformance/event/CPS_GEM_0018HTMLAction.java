/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_GEM_0018HTMLAction.java
*@FileTitle : Summary_After Closing
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.07.03 박창준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.RqstInfoVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * [CPS_GEM-0018] Summary_After Closing
 * HTTP Parser<br>
 * - com.clt.apps.nis2010.cps.gem.gemplanningperformance 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GEMPlanningPerformanceSC로 실행요청<br>
 * - GEMPlanningPerformanceSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Park Changjune
 * @see CpsGem0018Event 참조
 * @since J2EE 1.4
 */

public class CPS_GEM_0018HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_GEM_0018HTMLAction 객체를 생성
	 */
	public CPS_GEM_0018HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CpsGem0018Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		CpsGem0018Event event = new CpsGem0018Event();		
			
		//[Retrieve]
		if(command.isCommand(FormCommand.SEARCHLIST) || command.isCommand(FormCommand.SEARCHLIST04) 
				|| command.isCommand(FormCommand.SEARCHLIST05) || command.isCommand(FormCommand.SEARCHLIST06)
				|| command.isCommand(FormCommand.SEARCHLIST07) || command.isCommand(FormCommand.SEARCHLIST08) || command.isCommand(FormCommand.SEARCHLIST09)
				|| command.isCommand(FormCommand.SEARCHLIST10) || command.isCommand(FormCommand.SEARCHLIST11) || command.isCommand(FormCommand.SEARCHLIST12)) {	
			
			RqstInfoVO dto = (RqstInfoVO)getVO(request, RqstInfoVO .class);
			event.setRqstInfoVO(dto);
			
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