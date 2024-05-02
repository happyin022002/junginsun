/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0002HTMLAction.java
*@FileTitle : Service Provider Help
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.06.03 박명종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConForVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.vsm.pso.portsomasterdatamgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 portsomasterdatamgtSC로 실행요청<br>
 * - portsomasterdatamgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Park MyoungJong
 * @see portsomasterdatamgtEvent 참조
 * @since J2EE 1.4
 */

public class VOP_PSO_0209HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * UI_PSO_0205HTMLAction 객체를 생성
	 */
	public VOP_PSO_0209HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 portsomasterdatamgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopPso0209Event event = new VopPso0209Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setUseStatusConForVO((UseStatusConForVO)getVO(request,UseStatusConForVO.class));
		} else 	if(command.isCommand(FormCommand.COMMAND01 )) {
			event.setUseStatusConForVO((UseStatusConForVO)getVO(request,UseStatusConForVO.class));
		} else 	if(command.isCommand(FormCommand.COMMAND02 )) { // 2015.02.16 ADD popup Edit 
			event.setUseStatusConForVO((UseStatusConForVO)getVO(request,UseStatusConForVO.class));
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