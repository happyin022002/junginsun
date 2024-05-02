/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0140HTMLAction.java
*@FileTitle : Bay PLAN
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.04 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


import com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0140ConditionVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.simulationmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SimulationManageSC로 실행요청<br>
 * - SimulationManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Chae Change Ho
 * @see SimulationManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0140HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0140HTMLAction 객체를 생성
	 */
	public EES_EQR_0140HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SimulationManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr0140Event event = new EesEqr0140Event();
		EesEqr0140ConditionVO conditionVO        = new EesEqr0140ConditionVO();
	        
		String tpszAll = (JSPUtil.getParameter(request, "tpszallTypeAll".trim(), ""));
		conditionVO.setTpsztypeall(tpszAll);
	    
        // html input 값을 넘겨준다. 
		// SEARCHLIST 할당값을 넘겨줌
		conditionVO.setVvd(JSPUtil.getParameter(request, "vvd".trim(), ""));
		conditionVO.setBasisPort(JSPUtil.getParameter(request, "basis_port".trim(), ""));
		conditionVO.setBayport(JSPUtil.getParameter(request, "bayport".trim(), ""));
		event.setEesEqr0140ConditionVO(conditionVO);
		request.setAttribute("Event", event);
		event.setCommandClassName("SimulationManageSC");
        event.setFormCommand(command);
		
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