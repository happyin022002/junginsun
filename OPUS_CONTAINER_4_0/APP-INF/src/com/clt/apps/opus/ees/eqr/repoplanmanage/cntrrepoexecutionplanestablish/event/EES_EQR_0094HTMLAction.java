/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0094HTMLAction.java
*@FileTitle : Inventory Container List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.20 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0094ConditionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
//import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.eqr.repoplanmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RepoPlanManageSC로 실행요청<br>
 * - RepoPlanManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author ChungEunHo
 * @see RepoPlanManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0094HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0094HTMLAction 객체를 생성
	 */
	public EES_EQR_0094HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RepoPlanManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr0094Event event = new EesEqr0094Event();
		event.setEesEqr0094ConditionVO((EesEqr0094ConditionVO)getVO(request, EesEqr0094ConditionVO .class));
		EesEqr0094ConditionVO conditionVO = event.getEesEqr0094ConditionVO();
		// EXE_PLN 호출시 조회없이 필수정보만 EVENT에 담습니다.
		// FormCommand.DEFAULT
		
		// Retrieve 버튼 클릭시
		// FormCommand.SEARCHLIST
		
		// cntr 입력 시 데이터 가져오기.
		// FormCommand.SEARCHLIST01
		
		// Excel Load시 cntr 데이터 가져오기.
		// FormCommand.SEARCHLIST03
		if (command.isCommand(FormCommand.SEARCHLIST03)) {
			conditionVO.setCntrNo(conditionVO.getCntrNoList());
		}
		
		// Apply 시 이미 Execuction 된 CNTR No.있는지 확인. - 중복등록 못하게 함.
		// FormCommand.SEARCHLIST04
		if (command.isCommand(FormCommand.SEARCHLIST04)) {
			conditionVO.setCntrNo(conditionVO.getCntrNoList());
		}
		
		// 이미 저장되있던 cntr 데이터 가져오기.
		// FormCommand.SEARCHLIST05
		if (command.isCommand(FormCommand.SEARCHLIST05)) {
			conditionVO.setCntrNo(conditionVO.getCntrNoList());
		}
		event.setEesEqr0094ConditionVO(conditionVO);
		
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