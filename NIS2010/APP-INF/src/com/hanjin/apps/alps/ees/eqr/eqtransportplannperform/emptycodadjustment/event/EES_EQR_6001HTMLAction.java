/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1038HTMLAction.java
*@FileTitle : MTY COD Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.07.31 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.EmptyCODVVDPortVO;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.EmptyCODVVDVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.cim.eqtransportplannperform 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EQTransportPlanNPerformSC로 실행요청<br>
 * - EQTransportPlanNPerformSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Prak Kwang Seok
 * @see EQTransportPlanNPerformEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_6001HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CIM_1038HTMLAction 객체를 생성
	 */
	public EES_EQR_6001HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EQTransportPlanNPerformEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr6001Event event = new EesEqr6001Event();
		EmptyCODVVDVO emptyCODVVDVO = new EmptyCODVVDVO();
		if(command.isCommand(FormCommand.MULTI)) {
			event.setEmptyCODVVDPortVOs((EmptyCODVVDPortVO[])getVOs(request, EmptyCODVVDPortVO .class,""));
	//		event.setEmptyCODVVDVOs((EmptyCODVVDVO[])getVOs(request, EmptyCODVVDVO .class,""));
			event.setEmptyCODVVDVOs(emptyCODVVDVO.fromRequestGrid(request,"sub"));
			

		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			String week = request.getParameter("week");
			String vvd = request.getParameter("vvd");		
			event.setAttribute("week", week);
			event.setAttribute("vvd", vvd);
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			String week = request.getParameter("week");
			String trade = request.getParameter("trade");		
			event.setAttribute("week", week);
			event.setAttribute("trade", trade);
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