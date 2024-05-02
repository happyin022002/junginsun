/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_COA_2002HTMLAction.java
*@FileTitle : Register Sub Group Cost Code
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2012.04.05 문동선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SubGrpCostCodeVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 STDUnitCostSC로 실행요청<br>
 * - STDUnitCostSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Dongsun Moon
 * @see STDUnitCostEvent 참조
 * @since J2EE 1.6
 */

public class ESM_COA_2002HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_COA_2002HTMLAction 객체를 생성
	 */
	public ESM_COA_2002HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 STDUnitCostEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmCoa2002Event event = new EsmCoa2002Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setSubGrpCostCodeVOS((SubGrpCostCodeVO[])getVOs(request, SubGrpCostCodeVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setStndCostTpCd(request.getParameter("f_profitLevelCombo"));
			event.setMainGroupCostCd(request.getParameter("f_mainGroupCombo"));
			//event.setSubGrpCostCodeVO((SubGrpCostCodeVO[])getVOs(request, SubGrpCostCodeVO .class));
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