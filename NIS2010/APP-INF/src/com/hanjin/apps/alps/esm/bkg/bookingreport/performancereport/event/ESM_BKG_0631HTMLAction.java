/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0631HTMLAction.java
*@FileTitle : RBC Vessel Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.08.26 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.RbcvesselVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingreport 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BookingReportSC로 실행요청<br>
 * - BookingReportSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author kim tae kyoung
 * @see BookingReportEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0631HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0631HTMLAction 객체를 생성
	 */
	public ESM_BKG_0631HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BookingReportEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0631Event event = new EsmBkg0631Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			String fromDt = JSPUtil.getParameter(request,"from_dt");
			String toDt   = JSPUtil.getParameter(request,"to_dt");
			
			event.setFromDt(fromDt);
            event.setToDt(toDt);
			
			event.setRbcvesselVO((RbcvesselVO)getVO(request, RbcvesselVO .class));
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