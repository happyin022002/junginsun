/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3001HTMLAction.java
*@FileTitle : Charge Calculation by Office & VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.05.22 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeByOfficeOrVVDVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.dmt.dmtclosing 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DMTClosingSC로 실행요청<br>
 * - DMTClosingSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see DMTClosingEvent 참조
 * @since J2EE 1.6
 */

public class EES_DMT_3001HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_DMT_3001HTMLAction 객체를 생성
	 */
	public EES_DMT_3001HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DMTClosingEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesDmt3001Event event = new EesDmt3001Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setChargeByOfficeOrVVDVO((ChargeByOfficeOrVVDVO)getVO(request, ChargeByOfficeOrVVDVO .class));
		} else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setChargeByOfficeOrVVDVO((ChargeByOfficeOrVVDVO)getVO(request, ChargeByOfficeOrVVDVO .class));
		} else if(command.isCommand(FormCommand.MULTI)) {
			event.setChargeCalculationContainerVOS((ChargeCalculationContainerVO[])getVOs(request, ChargeCalculationContainerVO .class, ""));
		} else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setChargeCalculationContainerVOS((ChargeCalculationContainerVO[])getVOs(request, ChargeCalculationContainerVO .class, ""));
		} else if(command.isCommand(FormCommand.COMMAND01)) {
			event.setChargeArgumentVO((ChargeArgumentVO)getVO(request, ChargeArgumentVO .class));
			event.setChargeCalculationContainerVOS((ChargeCalculationContainerVO[])getVOs(request, ChargeCalculationContainerVO .class, ""));
		} else if(command.isCommand(FormCommand.COMMAND02)) {
			event.setChargeArgumentVO((ChargeArgumentVO)getVO(request, ChargeArgumentVO .class));
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