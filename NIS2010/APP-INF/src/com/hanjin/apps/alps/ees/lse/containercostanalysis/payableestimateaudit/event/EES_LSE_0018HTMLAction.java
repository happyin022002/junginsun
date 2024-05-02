/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0018HTMLAction.java
*@FileTitle : Estimate expense
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.10.06 진준성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis.payableestimateaudit.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.lse.containercostanalysis.payableestimateaudit.vo.EstimatedAuditVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.lse.containercostanalysis 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ContainerCostAnalysisSC로 실행요청<br>
 * - ContainerCostAnalysisSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jin Jun Sung
 * @see ContainerCostAnalysisEvent 참조
 * @since J2EE 1.6
 */

public class EES_LSE_0018HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_LSE_0018HTMLAction 객체를 생성
	 */
	public EES_LSE_0018HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ContainerCostAnalysisEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesLse0018Event event = new EesLse0018Event();
		
        String strYearMonth = request.getParameter("period_eddt");
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setEstimatedAuditVO((EstimatedAuditVO)getVO(request, EstimatedAuditVO.class));
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setEstimatedAuditVO((EstimatedAuditVO)getVO(request, EstimatedAuditVO.class));
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setYearMonth(strYearMonth);
			event.setEstimatedAuditVOS((EstimatedAuditVO[])getVOs(request, EstimatedAuditVO.class , ""));
		}else if(command.isCommand(FormCommand.COMMAND01)){    	//BackEndJob - 작업요청
			event.setAttribute("KEY", request.getParameter("backendjob_key"));
			event.setEstimatedAuditVO((EstimatedAuditVO)getVO(request, EstimatedAuditVO.class));
		}else if(command.isCommand(FormCommand.COMMAND02)){    	//BackEndJob - 상태조회
			event.setAttribute("KEY", request.getParameter("backendjob_key"));
			event.setEstimatedAuditVO((EstimatedAuditVO)getVO(request, EstimatedAuditVO.class));
		}else if(command.isCommand(FormCommand.COMMAND03)){    	//BackEndJob - 결과로드
			event.setAttribute("KEY", request.getParameter("backendjob_key"));
			event.setEstimatedAuditVO((EstimatedAuditVO)getVO(request, EstimatedAuditVO.class));
			
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
	@Override
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