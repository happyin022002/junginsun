/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0011HTMLAction.java
*@FileTitle : Vessel Schedule 변경 Simulation 조회/수정 
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-04
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009-08-04 정은호
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.vo.EesEqr0011ConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.EqrScnrVslSkdVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.enis.ees.eqr.simulationmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SimulationManageSC로 실행요청<br>
 * - SimulationManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author sangyool pak
 * @see EesEqr0011Event , EES_EQR_011EventResponse 참조
 * @since J2EE 1.4
 */
public class EES_EQR_0011HTMLAction extends HTMLActionSupport {

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EES_EQR_011Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * EES_EQR_011HTMLAction 객체를 생성
	 */
	public EES_EQR_0011HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SimulationManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand f_cmd  = FormCommand.fromRequest(request);		
		
		EesEqr0011Event event = new EesEqr0011Event( );
		
		// 모든 이벤트
		event.setConditionVO((EesEqr0011ConditionVO)getVO(request, EesEqr0011ConditionVO .class));
		
		// Save 버튼 클릭시 
		if(f_cmd.isCommand(FormCommand.MULTI)) {
			event.setEqrScnrVslSkdVOS((EqrScnrVslSkdVO[])getVOs(request,EqrScnrVslSkdVO.class , ""));
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