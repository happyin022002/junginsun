/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0052HTMLAction.java
*@FileTitle : 최적화된 REPO InOut 계획 수량 조회/수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		jungran yang					2006-10-19		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun				2009.08.17		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.08.17
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0052ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0052MultiVO;
import com.clt.framework.component.util.JSPUtil;
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
 * @author 
 * @see RepoPlanManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0052HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0052HTMLAction 객체를 생성
	 */
	public EES_EQR_0052HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RepoPlanManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr0052Event event = new EesEqr0052Event();
		
		String tpszType = JSPUtil.getParameter(request, "cntrTpszCd_2","");
		
		// Retrieve 버튼 클릭시
		if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setEesEqr0052ConditionVO((EesEqr0052ConditionVO)getVO(request, EesEqr0052ConditionVO .class));
		}
		
		// VVD조회 (ADD시 MOD가 VVD이고 Lane값이 변경되었을때)
		else if (command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setEesEqr0052ConditionVO((EesEqr0052ConditionVO)getVO(request, EesEqr0052ConditionVO .class));
		}
		
		// LOC조회 (ADD시 MOD가 VVD이고 VVD값이 변경되었을때)
		else if (command.isCommand(FormCommand.SEARCHLIST02)) {
			event.setEesEqr0052ConditionVO((EesEqr0052ConditionVO)getVO(request, EesEqr0052ConditionVO .class));
		}
		
		// Save 버튼 클릭시
		else if (command.isCommand(FormCommand.MULTI)) {
			event.setEesEqr0052ConditionVO((EesEqr0052ConditionVO)getVO(request, EesEqr0052ConditionVO .class));
			event.setEesEqr0052MultiVOS(new EesEqr0052MultiVO().fromRequestGridArrayList(request, tpszType));
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