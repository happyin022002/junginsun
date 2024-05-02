/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6024HTMLAction.java
*@FileTitle : CM/OP Summary & Simulation - Contract Proposal Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.13 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsProposalCmSummaryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsProposalCmSummaryVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.profitabilitysimulation 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ProfitabilitySimulationSC로 실행요청<br>
 * - ProfitabilitySimulationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SONG MIN SEOK
 * @see ProfitabilitySimulationEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_6024HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_6024HTMLAction 객체를 생성
	 */
	public ESM_PRI_6024HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ProfitabilitySimulationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri6024Event event = new EsmPri6024Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setInPrsProposalCmSummaryVO((InPrsProposalCmSummaryVO)getVO(request, InPrsProposalCmSummaryVO .class));
		}
		event.setAttribute("KEY", request.getParameter("backendjob_key"));
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