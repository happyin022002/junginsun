/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0080HTMLAction.java
*@FileTitle : 컨테이너 이송 실행 계획 조회/수정 Truck/Rail/Barge
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.24 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0080MultiVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.eqr.repoplanmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RepoPlanManageSC로 실행요청<br>
 * - RepoPlanManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author ChungEunHo
 * @see RepoPlanManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0080HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0080HTMLAction 객체를 생성
	 */
	public EES_EQR_0080HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RepoPlanManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr0080Event event = new EesEqr0080Event();
		event.setEesEqr0059ConditionVO((EesEqr0059ConditionVO)getVO(request, EesEqr0059ConditionVO .class));
		
		// Sheet1 update, insert, delete 정보를 받기
    	if(command.isCommand(FormCommand.MULTI)   || command.isCommand(FormCommand.MULTI01) ||
    			command.isCommand(FormCommand.MULTI02) || command.isCommand(FormCommand.MULTI03)
    	) {
    		
    		event.setEesEqr0080MultiVOS((EesEqr0080MultiVO[])getVOs(request , EesEqr0080MultiVO.class , "t2_"));
    	}else if( command.isCommand(FormCommand.SEARCHLIST01)) {
    		event.setEesEqr0080MultiVOS((EesEqr0080MultiVO[])getVOs(request , EesEqr0080MultiVO.class , "t2_"));
    	}else if( command.isCommand(FormCommand.SEARCHLIST02)) {
    		event.setEesEqr0080MultiVOS((EesEqr0080MultiVO[])getVOs(request , EesEqr0080MultiVO.class , "t1_"));
    	}else if( command.isCommand(FormCommand.SEARCHLIST03) || command.isCommand(FormCommand.SEARCHLIST04) || command.isCommand(FormCommand.SEARCHLIST05)) {
    		event.setEesEqr0080MultiVOS((EesEqr0080MultiVO[])getVOs(request , EesEqr0080MultiVO.class , ""));
    	}
    	
    	if(command.isCommand(FormCommand.MULTI04) || command.isCommand(FormCommand.MULTI05) || command.isCommand(FormCommand.MULTI06)
    			 || command.isCommand(FormCommand.MULTI07)|| command.isCommand(FormCommand.MULTI08)) {
    		event.setEesEqr0080MultiVOS((EesEqr0080MultiVO[])getVOs(request , EesEqr0080MultiVO.class , ""));
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