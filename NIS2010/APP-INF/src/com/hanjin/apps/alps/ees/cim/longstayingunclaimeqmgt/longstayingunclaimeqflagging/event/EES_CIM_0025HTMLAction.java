/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_0025HTMLAction.java
*@FileTitle : CNTR Free day Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.10
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2010.07.27 신자영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCntrListVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtOptionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.cim.containersupplydemandforecast 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ContainerSupplyDemandForecastSC로 실행요청<br>
 * - ContainerSupplyDemandForecastSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author kim jong jun
 * @see ContainerSupplyDemandForecastEvent 참조
 * @since J2EE 1.4
 */
 
public class EES_CIM_0025HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CIM_0025HTMLAction 객체를 생성
	 */
	public EES_CIM_0025HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ContainerSupplyDemandForecastEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		EesCim0025Event event = new EesCim0025Event();
		

		event.setInvtCntrListVO((InvtCntrListVO)getVO(request, InvtCntrListVO .class));
		event.setInvtOptionVO((InvtOptionVO)getVO(request, InvtOptionVO .class));

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