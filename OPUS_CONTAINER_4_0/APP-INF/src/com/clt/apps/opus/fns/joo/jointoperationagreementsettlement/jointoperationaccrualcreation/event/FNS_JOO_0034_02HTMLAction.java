/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0034_02HTMLAction.java
*@FileTitle : Estimate Code Check - VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.06 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.ActRsltRVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstdVvdVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.fns.joo.jointoperationagreementsettlement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 JointOperationAgreementSettlementSC로 실행요청<br>
 * - JointOperationAgreementSettlementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author jang kang cheol
 * @see JointOperationAgreementSettlementEvent 참조
 * @since J2EE 1.6
 */

public class FNS_JOO_0034_02HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_JOO_0034_02HTMLAction 객체를 생성
	 */
	public FNS_JOO_0034_02HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 JointOperationAgreementSettlementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsJoo003402Event event = new FnsJoo003402Event();
		

		if(command.isCommand(FormCommand.SEARCHLIST01)) {
            event.setEstdVvdVO(  (EstdVvdVO)getVO(request, EstdVvdVO .class)  );
 
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