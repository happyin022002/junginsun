/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0059HTMLAction.java
*@FileTitle : MCS Letter Information Text Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.24 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.JoTmpltNoVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.syscommon.common.table.JooLtrTmpltVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 JointOperationAgreementSettlementSC로 실행요청<br>
 * - JointOperationAgreementSettlementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author HAM DAE SUNG
 * @see JointOperationAgreementSettlementEvent 참조
 * @since J2EE 1.6
 */

public class FNS_JOO_0059HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_JOO_0059HTMLAction 객체를 생성
	 */
	public FNS_JOO_0059HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 JointOperationAgreementSettlementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsJoo0059Event event = new FnsJoo0059Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setCopy(request.getParameter("copy"));
			event.setJooLtrTmpltVO((JooLtrTmpltVO)getVO(request, JooLtrTmpltVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			//event.setJoLtrTpCd(request.getParameter("jo_ltr_tp_cd"));
			//event.setOfcCd(request.getParameter("ofc_cd"));
			event.setJooLtrTmpltVO((JooLtrTmpltVO)getVO(request, JooLtrTmpltVO .class));
		}
		else if(command.isCommand(FormCommand.REMOVE)) {
			event.setJooLtrTmpltVO((JooLtrTmpltVO)getVO(request, JooLtrTmpltVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setJooLtrTmpltVO((JooLtrTmpltVO)getVO(request, JooLtrTmpltVO .class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
            event.setJooLtrTmpltVO((JooLtrTmpltVO)getVO(request, JooLtrTmpltVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setJoTmpltNoVO((JoTmpltNoVO)getVO(request, JoTmpltNoVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST02)) {
			event.setJoTmpltNoVO((JoTmpltNoVO)getVO(request, JoTmpltNoVO .class));
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