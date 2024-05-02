/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0651HTMLAction.java
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.08.24 강동윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.bookingreport 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BookingReportSC로 실행요청<br>
 * - BookingReportSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author kang dong yun
 * @see BookingReportEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0651HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0651HTMLAction 객체를 생성
	 */
	public ESM_BKG_0651HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BookingReportEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0651Event event = new EsmBkg0651Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			
			String blNo 	= JSPUtil.getParameter(request, "bl_no");
			String bkgNo	= JSPUtil.getParameter(request, "bkg_no");
			String caNo		= JSPUtil.getParameter(request, "corr_no");
			
			event.setBlNo(blNo);
			event.setBkgNo(bkgNo);
			event.setCaNo(caNo);
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			
			String bkgNo	= JSPUtil.getParameter(request, "bkg_no");
			String caNo		= JSPUtil.getParameter(request, "corr_no");
			event.setCaNo(caNo);
			event.setBkgNo(bkgNo);
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