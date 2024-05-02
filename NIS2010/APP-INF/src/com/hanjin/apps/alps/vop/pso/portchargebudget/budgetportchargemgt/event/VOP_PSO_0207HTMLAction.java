/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0207HTMLAction.java
*@FileTitle : Interface to ERP (Detail)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.07.07 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.ErpDtlVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vop.pso.portchargebudget 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 PortChargeBudgetSC로 실행요청<br>
 * - PortChargeBudgetSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Jin Ihl
 * @see PortChargeBudgetEvent 참조
 * @since J2EE 1.6
 */

public class VOP_PSO_0207HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_PSO_0207HTMLAction 객체를 생성
	 */
	public VOP_PSO_0207HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 PortChargeBudgetEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopPso0207Event event = new VopPso0207Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setErpDtlVO((ErpDtlVO)getVO(request, ErpDtlVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI)) {//Save Button Click 시 
			event.setErpDtlVOs((ErpDtlVO[])getVOs(request, ErpDtlVO .class, "sheet1_"));
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