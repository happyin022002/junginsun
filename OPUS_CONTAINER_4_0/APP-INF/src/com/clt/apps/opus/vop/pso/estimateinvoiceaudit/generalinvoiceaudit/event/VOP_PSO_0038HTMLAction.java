/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_PSO_0038HTMLAction.java
*@FileTitle : Port Charge Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2010.01.14 정명훈
* 1.0 Creation
* 
* History
* 2010.11.22 진마리아 CHM-201006692-01 Port charge simulation 이 터미널별로 한번에 계산이 될수 있도록 멀티 기능 추가
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationConditionVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationObjectListVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.vop.pso.estimateinvoiceaudit 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EstimateInvoiceAuditSC로 실행요청<br>
 * - EstimateInvoiceAuditSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jeong Myounghun
 * @see EstimateInvoiceAuditEvent 참조
 * @since J2EE 1.6
 */

public class VOP_PSO_0038HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_PSO_0038HTMLAction 객체를 생성
	 */
	public VOP_PSO_0038HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EstimateInvoiceAuditEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopPso0038Event event = new VopPso0038Event();
		

		if(command.isCommand(FormCommand.COMMAND01)) {		//Search Tariff
			event.setSimulationConditionVO((SimulationConditionVO)getVO(request, SimulationConditionVO .class));
		} else if(command.isCommand(FormCommand.SEARCH)) {		//Retrieve
			event.setSimulationConditionVO((SimulationConditionVO)getVO(request, SimulationConditionVO .class));
			event.setSimulationConditionVOs((SimulationConditionVO[])getVOs(request, SimulationConditionVO.class,"sheet6_"));
		} else if(command.isCommand(FormCommand.COMMAND02)) {		//Calculation Button Click
			event.setSimulationConditionVO((SimulationConditionVO)getVO(request, SimulationConditionVO .class));
			event.setSimulationObjectListVOs((SimulationObjectListVO[])getVOs(request, SimulationObjectListVO.class,"sheet1_"));
			event.setMenualObjectVOs((SimulationObjectListVO[])getVOs(request, SimulationObjectListVO.class,"sheet2_"));
			event.setSimulationConditionVOs((SimulationConditionVO[])getVOs(request, SimulationConditionVO.class,"sheet6_"));
		} else if(command.isCommand(FormCommand.COMMAND03)) {		//Search Service Providers By Tariff
			event.setSimulationConditionVO((SimulationConditionVO)getVO(request, SimulationConditionVO .class));		
		} else if(command.isCommand(FormCommand.COMMAND04)) {		//Check VVD
			event.setSimulationConditionVO((SimulationConditionVO)getVO(request, SimulationConditionVO .class));		
		} else if(command.isCommand(FormCommand.COMMAND05)) {		//Search Account
			event.setSimulationConditionVO((SimulationConditionVO)getVO(request, SimulationConditionVO .class));		
		} else if(command.isCommand(FormCommand.SEARCH01)) {		//Search Yard Code
			String portCd = (String) request.getParameter("port_cd");
			String issueDate = (String) request.getParameter("issue_date");
			//parameter로 넘어온 vndrSeq를 event객체에 set한다.
			event.setPortCd(portCd);
			if(issueDate !=null)
				event.setIssueDate(issueDate);
		} else if(command.isCommand(FormCommand.SEARCH02)) {		//Search Yard Code
			event.setSimulationConditionVO((SimulationConditionVO)getVO(request, SimulationConditionVO .class));
		} else if(command.isCommand(FormCommand.SEARCH04)) {		//Search Clpt_ind_seq 
			event.setSimulationConditionVO((SimulationConditionVO)getVO(request, SimulationConditionVO .class));
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