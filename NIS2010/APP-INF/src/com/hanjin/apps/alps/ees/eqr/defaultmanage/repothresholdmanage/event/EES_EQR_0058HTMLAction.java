/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0058HTMLAction.java
*@FileTitle : 실행 계획 Feedback 기준 설정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	jungran yang		2006-10-16		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun	2009.07.16		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.07.16
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.EqrRepoExePlnFbExptVO;
import com.hanjin.syscommon.common.table.EqrRepoExePlnFbVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.defaultmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DefaultManageSC로 실행요청<br>
 * - DefaultManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see DefaultManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0058HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_058HTMLAction 객체를 생성
	 */
	public EES_EQR_0058HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DefaultManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr0058Event event = new EesEqr0058Event();
		
		String tpszall   = JSPUtil.getParameter(request, "tpszall", "");	
		
		// Retrieve 버튼 클릭시
		if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setTpszall(tpszall);
		}
		
		// Save 버튼 클릭시 (Basic 시트 내용)
		else if(command.isCommand(FormCommand.MULTI)) {
			event.setEqrRepoExePlnFbVOS(new EqrRepoExePlnFbVO().fromRequestGridArrayList(request, ""));
		}
		
		// Save 버튼 클릭시 (Exceptional 시트 내용)
		if (command.isCommand(FormCommand.MULTI01)){
			event.setEqrRepoExePlnFbExptVOS(new EqrRepoExePlnFbExptVO().fromRequestGridArrayList(request, ""));
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