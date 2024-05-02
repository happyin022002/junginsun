/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1023HTMLAction.java
*@FileTitle : Location M/B by Logistics-Wise
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.05.20 박광석
* 1.0 Creation
* ------------------------------------------------------------
* History
* 2012.03.26 신자영 [CHM-201216788-01] M/B 기능 보완 요청
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBSearchOptionInGereralVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.es.cim.cntroperationperformancemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CNTROperatioNPerformanceMgtSC로 실행요청<br>
 * - CNTROperatioNPerformanceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Myeong Jong Beum
 * @see CNTROperatioNPerformanceMgtEvent 참조
 * @since J2EE 1.4
 */

public class EES_CIM_1023HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CIM_1023HTMLAction 객체를 생성
	 */
	public EES_CIM_1023HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CNTROperatioNPerformanceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		String locLevel = JSPUtil.getParameter(request, "locLevel".trim(), "");
		String locCD =  JSPUtil.getParameter(request, "locCD".trim(), "");
		EesCim1023Event event = new EesCim1023Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setMBSearchOptionInGereralVO((MBSearchOptionInGereralVO)getVO(request, MBSearchOptionInGereralVO .class));
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setMBSearchOptionInGereralVO((MBSearchOptionInGereralVO)getVO(request, MBSearchOptionInGereralVO .class));
		}else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setMBSearchOptionInGereralVO((MBSearchOptionInGereralVO)getVO(request, MBSearchOptionInGereralVO .class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setLocLevel(locLevel);
			event.setLocCD(locCD);
		}else if(command.isCommand(FormCommand.SEARCH03)){
			event.setMBSearchOptionInGereralVO((MBSearchOptionInGereralVO)getVO(request, MBSearchOptionInGereralVO .class));
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