/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0022HTMLAction.java
*@FileTitle : Monthly Budget Creation
*Open Issues :
*Change history : 
*@LastModifyDate : 2015.04.08
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2015.04.08 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.ActCostMonBudgetVO;


/**
 * @author KIM HYUN HWA
 * @see EsdLea0022Event 참조
 * @since J2EE 1.6
 */

public class ESD_LEA_0022HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_LEA_0022HTMLAction 객체를 생성
	 */
	public ESD_LEA_0022HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 LogisticsExpenseAccrualEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsdLea0022Event event = new EsdLea0022Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setBseYr(request.getParameter("bse_yr"));
			event.setRhqCd(request.getParameter("rhq_cd"));
		}else if(command.isCommand(FormCommand.MULTI)) {
			//event.setBseYr(request.getParameter("bse_yr"));
			event.setActCostMonBudgetVOs((ActCostMonBudgetVO[])getVOs(request, ActCostMonBudgetVO.class,""));
		}else if(command.isCommand(FormCommand.MULTI01)) {
			//event.setBseYr(request.getParameter("bse_yr"));
			event.setActCostMonBudgetVOs((ActCostMonBudgetVO[])getVOs(request, ActCostMonBudgetVO.class,""));
		}else if(command.isCommand(FormCommand.MULTI02)) {
			event.setBseYr(request.getParameter("bse_yr"));
		}else if(command.isCommand(FormCommand.MULTI03)) {
			event.setActCostMonBudgetVOs((ActCostMonBudgetVO[])getVOs(request, ActCostMonBudgetVO.class,""));
		}else if(command.isCommand(FormCommand.MULTI04)) {
			event.setActCostMonBudgetVOs((ActCostMonBudgetVO[])getVOs(request, ActCostMonBudgetVO.class,""));
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