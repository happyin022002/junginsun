/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1001HTMLAction.java
*@FileTitle : MTY Balance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.07.23 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceListVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceOptionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.OpmgFcstInputVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.cim.mtyequipmentforecast 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 MTYEquipmentForecastSC로 실행요청<br>
 * - MTYEquipmentForecastSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author kim jong jun
 * @see MTYEquipmentForecastEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_1001HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CIM_1001HTMLAction 객체를 생성
	 */
	public EES_EQR_1001HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 MTYEquipmentForecastEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr1001Event event = new EesEqr1001Event();
		
		if(command.isCommand(FormCommand.SEARCH03)) { // main sheet 조회
			event.setMtyBalanceOptionVO((MtyBalanceOptionVO)getVO(request, MtyBalanceOptionVO .class));
		}else if(command.isCommand(FormCommand.SEARCH04)) { // Reference 1
			event.setMtyBalanceOptionVO((MtyBalanceOptionVO)getVO(request, MtyBalanceOptionVO .class));
		}else if(command.isCommand(FormCommand.SEARCH05)) { // Reference 2
			event.setMtyBalanceOptionVO((MtyBalanceOptionVO)getVO(request, MtyBalanceOptionVO .class));
			String kind = request.getParameter("kind");
			event.setAttribute("kind", kind);// BKG query 와 COP query 실행 구분을 위함
		}else if(command.isCommand(FormCommand.SEARCH06)) { // 바로 앞 주차 반환
			event.setAttribute("week", request.getParameter("week"));
		}else if(command.isCommand(FormCommand.MULTI01)) {
			event.setOpmgFcstInputVOS((OpmgFcstInputVO[])getVOs(request, OpmgFcstInputVO .class,""));
		}
		
		String inquirylevel = request.getParameter("inquiryLevel");
		String location = request.getParameter("location");		
		event.setAttribute("inquirylevel", inquirylevel);
		event.setAttribute("location", location);
		
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