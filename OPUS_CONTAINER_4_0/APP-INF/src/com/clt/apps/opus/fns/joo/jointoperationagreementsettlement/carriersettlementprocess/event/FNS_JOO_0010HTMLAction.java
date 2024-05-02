/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0010HTMLAction.java
*@FileTitle : Over Used Slot Hire for TDR
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.07.01 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
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
 * @author Park Hee Dong
 * @see JointOperationAgreementSettlementEvent 참조
 * @since J2EE 1.6
 */

public class FNS_JOO_0010HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_JOO_0010HTMLAction 객체를 생성
	 */
	public FNS_JOO_0010HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 JointOperationAgreementSettlementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsJoo0010Event event = new FnsJoo0010Event();

		if(command.isCommand(FormCommand.MULTI)||command.isCommand(FormCommand.MULTI01)) {
			event.setProcSettlementVOS((ProcSettlementVO[])getVOs(request, ProcSettlementVO .class,"sheet1_"));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setProcSettlementVO((ProcSettlementVO)getVO(request, ProcSettlementVO .class));
		}
		else if(command.isCommand(FormCommand.REMOVE01)) {
			event.setProcSettlementVO((ProcSettlementVO)getVO(request, ProcSettlementVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST)) {
			String curRow = request.getParameter("cur_row");
			if (curRow == null || "".equals(curRow)){
				return event;
			}
			ProcSettlementVO[] vos = (ProcSettlementVO[])getVOs(request, ProcSettlementVO .class,"sheet1_");
			//변경된 row를 넘긴다.
			event.setProcSettlementVO((ProcSettlementVO)vos[Integer.parseInt(curRow)]);
		}
		else if(command.isCommand(FormCommand.SEARCHLIST01) || command.isCommand(FormCommand.SEARCHLIST02) || command.isCommand(FormCommand.SEARCHLIST03) ) {
			String curRow = request.getParameter("cur_row");
			if (curRow == null || "".equals(curRow)){
				return event;
			}
			ProcSettlementVO[] vos = (ProcSettlementVO[])getVOs(request, ProcSettlementVO .class,"sheet1_");
			ProcSettlementVO vo1 = (ProcSettlementVO)vos[Integer.parseInt(curRow)];
			//변경된 row를 넘긴다.
			event.setProcSettlementVO(vo1);
			event.setJooCodeParamVO((JooCodeParamVO)getVO(request, JooCodeParamVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH01) || command.isCommand(FormCommand.SEARCH10)) {
			event.setProcSettlementVO((ProcSettlementVO)getVO(request, ProcSettlementVO .class));
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