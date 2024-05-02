/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1062HTMLAction.java
*@FileTitle : Forecast Accuracy Review (By Week)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.17
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.12.17 김종준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.ForecastAccuracyListVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.ForecastAccuracyOptionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.cim.mtyequipmentforecast 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 MTYEquipmentForecastSC로 실행<br>
 * - MTYEquipmentForecastSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author kim jong jun
 * @see MTYEquipmentForecastEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_1062HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CIM_1062HTMLAction 객체를 생성
	 */
	public EES_EQR_1062HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 MTYEquipmentForecastEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr1062Event event = new EesEqr1062Event();
		
		event.setAttribute("KEY", request.getParameter("backendjob_key"));
		event.setForecastAccuracyOptionVO((ForecastAccuracyOptionVO)getVO(request, ForecastAccuracyOptionVO .class));
		event.setForecastAccuracyListVO((ForecastAccuracyListVO)getVO(request, ForecastAccuracyListVO .class));
		if(command.isCommand(FormCommand.MULTI)) {
			event.setForecastAccuracyListVOS((ForecastAccuracyListVO[])getVOs(request, ForecastAccuracyListVO .class,""));
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