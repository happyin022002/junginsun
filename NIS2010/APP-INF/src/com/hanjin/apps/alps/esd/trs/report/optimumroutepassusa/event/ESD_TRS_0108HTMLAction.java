/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0108HTMLAction.java
*@FileTitle : Optimum Route Pass
*Open Issues :
*Change history :
*@LastModifyDate : 2013-06-17
*@LastModifier : 조인영
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.vo.OptmRoutPassCondVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TRSReportSC로 실행요청<br>
 * - TRSReportSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 조인영
 * @see EsdTrs0108Event 참조
 * @since J2EE 1.6
 */
public class ESD_TRS_0108HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_SCE_0170HTMLAction 객체를 생성
	 */
	public ESD_TRS_0108HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CostManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EsdTrs0108Event event = new EsdTrs0108Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setOptmRoutPassCondVO((OptmRoutPassCondVO)getVO(request, OptmRoutPassCondVO .class));
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setOptmRoutPassCondVO((OptmRoutPassCondVO)getVO(request, OptmRoutPassCondVO .class));
		}
		
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