/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0079HTMLAction.java
*@FileTitle : 컨테이너 수요 예측(I/B)
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	sangyool pak		2006-10-18		1.0 최초 생성
* 2		1.0		Lee Byoung Hun	2009.08.06		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.08.06
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.EesEqr0079ConditionVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.EqrIbBkgFcastVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.scenariomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ScenarioManageSC로 실행요청<br>
 * - ScenarioManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see ScenarioManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0079HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0079HTMLAction 객체를 생성
	 */
	public EES_EQR_0079HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ScenarioManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr0079Event event = new EesEqr0079Event();
		
		// Retrieve 버튼 클릭시
		if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setEesEqr0079ConditionVO((EesEqr0079ConditionVO)getVO(request, EesEqr0079ConditionVO .class));
		}
		
		// Save 버튼 클릭시
		else if(command.isCommand(FormCommand.MULTI)) {
			String tpszOrg = JSPUtil.getParameter(request, "tpszOrg", "");
			event.setEqrIbBkgFcastVOS(new EqrIbBkgFcastVO().fromRequestGridList(request, tpszOrg));
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