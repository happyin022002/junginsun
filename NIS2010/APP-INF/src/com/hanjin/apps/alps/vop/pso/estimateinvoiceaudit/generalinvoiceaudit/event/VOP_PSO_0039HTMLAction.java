/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_PSO_0039HTMLAction.java
*@FileTitle : Tariff Simulation by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.15
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.06.10 진마리아
* 1.0 Creation
* 
* History
* 2011.06.15 진마리아 CHM-201111910-01 [PSO] Tariff Simulation By VVD 신규화면 생성
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffSimByVvdVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EstimateInvoiceAuditSC로 실행요청<br>
 * - EstimateInvoiceAuditSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jeong Myounghun
 * @see EstimateInvoiceAuditEvent 참조
 * @since J2EE 1.6
 */

public class VOP_PSO_0039HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_PSO_0039HTMLAction 객체를 생성
	 */
	public VOP_PSO_0039HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EstimateInvoiceAuditEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopPso0039Event event = new VopPso0039Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {		//Calculation
			event.setTariffSimByVvdVO((TariffSimByVvdVO)getVO(request, TariffSimByVvdVO .class));
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