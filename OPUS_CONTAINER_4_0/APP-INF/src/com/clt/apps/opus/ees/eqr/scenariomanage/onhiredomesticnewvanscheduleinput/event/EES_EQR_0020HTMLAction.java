/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0020HTMLAction.java
*@FileTitle : 연간신조 및 L/T 계획 조회 / 수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	ChangHoChae		2006-09-15		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun	2009.07.29		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.07.29
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.EesEqr0020ConditionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.EqrScnrNewVanLongTermVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.eqr.scenariomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ScenarioManageSC로 실행요청<br>
 * - ScenarioManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see ScenarioManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0020HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0020HTMLAction 객체를 생성
	 */
	public EES_EQR_0020HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ScenarioManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr0020Event event = new EesEqr0020Event();
		
		// Retrieve 버튼 클릭시 (상단 Sheet 조회)
		if(command.isCommand(FormCommand.SEARCHLIST05)) {
			event.setEesEqr0020ConditionVO((EesEqr0020ConditionVO)getVO(request, EesEqr0020ConditionVO .class));
		}
		
		// Retrieve 버튼 클릭시 (하단 Sheet 조회)
		else if (command.isCommand(FormCommand.SEARCHLIST)) {
			event.setEesEqr0020ConditionVO((EesEqr0020ConditionVO)getVO(request, EesEqr0020ConditionVO .class));
		}
		
		// Save 버튼 클릭시
		else if (command.isCommand(FormCommand.MULTI)) {
			event.setEesEqr0020ConditionVO((EesEqr0020ConditionVO)getVO(request, EesEqr0020ConditionVO .class));
			event.setEqrScnrNewVanLongTermVOS(new EqrScnrNewVanLongTermVO().fromRequestGridArrayList1(request, ""));
		}
		
		// Row Add 시 RCC 조회(LOC 항목의 값이 변한 경우)
		else if (command.isCommand(FormCommand.SEARCHLIST02)) {
			event.setEesEqr0020ConditionVO((EesEqr0020ConditionVO)getVO(request, EesEqr0020ConditionVO .class));
		}

		// Row Add 시 RCC 조회(LOC 항목의 값이 변한 경우)
		else if (command.isCommand(FormCommand.SEARCHLIST03)) {
			event.setEesEqr0020ConditionVO((EesEqr0020ConditionVO)getVO(request, EesEqr0020ConditionVO .class));
		}
		
		else if (command.isCommand(FormCommand.SEARCHLIST04)) {
			event.setEesEqr0020ConditionVO((EesEqr0020ConditionVO)getVO(request, EesEqr0020ConditionVO .class));
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