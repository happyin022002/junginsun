/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0143HTMLAction.java
*@FileTitle : EQR All-Weeks' Plan Access Grant
*Open Issues :
*	신규프로젝트 CSRNO : CHM-201003779
*	EQR VL-VD 전주차 접근권한 유저 신규메뉴 생성
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1      	1.0      	Lee Byoung Hun				2010.05.11		1.0 최초 생성
*
*@LastModifyDate : 2010.05.11
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2010.05.11
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0143ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0143MultiVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.repoplanmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RepoPlanManageSC로 실행요청<br>
 * - RepoPlanManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see RepoPlanManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0143HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0143HTMLAction 객체를 생성
	 */
	public EES_EQR_0143HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RepoPlanManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr0143Event event = new EesEqr0143Event();
		
		// Retrieve 버튼 클릭시
		// 화면에 검색조건이 없어서 Event에 셋팅해줄 값이 없으므로 PASS
		
		// Save 버튼 클릭시
		if(command.isCommand(FormCommand.MULTI)) {
			event.setEesEqr0143MultiVOS((EesEqr0143MultiVO[])getVOs(request, EesEqr0143MultiVO .class));
		}
		
		// User ID 입력시 (OnChange)
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setEesEqr0143ConditionVO((EesEqr0143ConditionVO)getVO(request, EesEqr0143ConditionVO .class));
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