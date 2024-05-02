/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0021HTMLAction.java
*@FileTitle : US Domestic 물량 조회/수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1		1.0		jungran yang		2006-09-20		1.0 최초 생성
* 2		1.0		Lee Byoung Hun	2009.08.04		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.08.04
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.eqr.common.Utils;
import com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.EesEqr0021ConditionVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.EqrScnrDmstVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.eqr.scenariomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ScenarioManageSC로 실행요청<br>
 * - ScenarioManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see ScenarioManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0021HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0021HTMLAction 객체를 생성
	 */
	public EES_EQR_0021HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ScenarioManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings("unchecked")
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr0021Event event = new EesEqr0021Event();
		
		//ECC_COMMON
		String  perfix_month   = JSPUtil.getParameter(request, "perfix_month", "");//200609,200610,200611,200612
		String  perfix_weekly  = JSPUtil.getParameter(request, "perfix_weekly", "");//200636,200637,200638,200639
		String  monthly_count  = JSPUtil.getParameter(request, "monthly_count", "");//4,4,5,3
		
		String newTitle = JSPUtil.getParameter(request, "title_weekly","");
		newTitle = Utils.replaceStringAll(newTitle,"|",",");
		
		// Retrieve 버튼 클릭시
		if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setEesEqr0021ConditionVO((EesEqr0021ConditionVO)getVO(request, EesEqr0021ConditionVO .class));
		}
		
		// Share 버튼 클릭시
		else if (command.isCommand(FormCommand.MULTI)) {
			EesEqr0021ConditionVO conditionVO = (EesEqr0021ConditionVO)getVO(request, EesEqr0021ConditionVO .class);
			
			List month = new EqrScnrDmstVO().fromRequestPerfixMonth(request, "s1_", perfix_month);
			List week = new EqrScnrDmstVO().fromRequestPerfixWeek(request, perfix_weekly);
			List monthWeekCnt = new EqrScnrDmstVO().fromRequestPerfixMonthWeekCnt(request, monthly_count);
			
			conditionVO.setMonth(month);
			conditionVO.setWeek(week);
			conditionVO.setMonthWeekCnt(monthWeekCnt);
			
			event.setEesEqr0021ConditionVO(conditionVO);
		}
		
		// Save 버튼 클릭시
		else if (command.isCommand(FormCommand.MULTI01)) {
			event.setEesEqr0021ConditionVO((EesEqr0021ConditionVO)getVO(request, EesEqr0021ConditionVO .class));
			event.setEqrScnrDmstVOS(new EqrScnrDmstVO().fromRequestGridArrayList(request, newTitle));
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