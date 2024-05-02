/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1033HTMLAction.java
*@FileTitle : Repo Result by Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.05.26 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.REPOResultSearchOptionByPortVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.cim.cntroperationperformancemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CNTROperatioNPerformanceMgtSC로 실행요청<br>
 * - CNTROperatioNPerformanceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Prak Kwang Seok
 * @see CNTROperatioNPerformanceMgtEvent 참조
 * @since J2EE 1.6
 */

public class EES_CIM_1033HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CIM_1033HTMLAction 객체를 생성
	 */
	public EES_CIM_1033HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CNTROperatioNPerformanceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesCim1033Event event = new EesCim1033Event();
		

		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setREPOResultSearchOptionByPortVO((REPOResultSearchOptionByPortVO)getVO(request, REPOResultSearchOptionByPortVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			String vvd = request.getParameter("vvd");
			event.setAttribute("vvd", vvd);
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