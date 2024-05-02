/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_EQR_1063HTMLAction.java
*@FileTitle : Sales Projection History
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 전지예
*@LastVersion : 1.0
* 2014.11.27 전지예 [CHM-201432889]    Sales Projection History 화면 생성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.SalesProjectionHistVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.cim.mtyequipmentforecast 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 MTYEquipmentForecastSC로 실행요청<br>
 * - MTYEquipmentForecastSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author jeon jee ye
 * @see MTYEquipmentForecastEvent 참조
 * @since J2EE 1.6
 */
public class EES_EQR_1063HTMLAction extends HTMLActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 MTYEquipmentForecastEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		EesEqr1063Event event = new EesEqr1063Event();
		event.setAttribute("KEY", request.getParameter("backendjob_key"));
		
		String div_flag		= request.getParameter("div_flag");
		String loc_tp_cd	= request.getParameter("loc_tp_cd");
		String loc_tp_cd_second	= request.getParameter("loc_tp_cd_second");
		String loc_cd 		 = request.getParameter("loc_cd");
		String loc_cd_second	= request.getParameter("loc_cd_second");
		String fm_week 	 = request.getParameter("fm_week");
		String to_week 	 = request.getParameter("to_week");
		
		event.setAttribute("div_flag",		div_flag);
		event.setAttribute("loc_tp_cd",		loc_tp_cd);
		event.setAttribute("loc_tp_cd_second",		loc_tp_cd_second);
		event.setAttribute("loc_cd",			loc_cd);
		event.setAttribute("loc_cd_second",	loc_cd_second);
		event.setAttribute("fm_week",		fm_week);
		event.setAttribute("to_week",		to_week);
		
		event.setSalesProjectionHistVO((SalesProjectionHistVO)getVO(request, SalesProjectionHistVO .class));
		
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