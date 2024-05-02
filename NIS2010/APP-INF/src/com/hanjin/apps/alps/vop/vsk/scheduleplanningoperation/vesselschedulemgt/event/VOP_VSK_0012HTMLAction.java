/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0012HTMLAction.java
*@FileTitle : Long Range SKD Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.07.01 유혁
* 1.0 Creation
* 
* History
* 2015.09.04 이병훈 [CHM-201537542] Yarc Code 말풍선 도움말 기능 지원
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PortSkdOnLongRangeVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.vop.vsk.scheduleplanningoperation 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SchedulePlanningOperationSC로 실행요청<br>
 * - SchedulePlanningOperationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Ryu Hyuk
 * @see SchedulePlanningOperationEvent 참조
 * @since J2EE 1.4
 */

public class VOP_VSK_0012HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * UI_VSK_0012HTMLAction 객체를 생성
	 */
	public VOP_VSK_0012HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 VopVsk0012Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
//		사용하지 않는 지역 변수를 점검한다.
//    	FormCommand command = FormCommand.fromRequest(request);
		VopVsk0012Event event = new VopVsk0012Event();
		
		event.setPortSkdOnLongRangeVO((PortSkdOnLongRangeVO)getVO(request, PortSkdOnLongRangeVO.class));
		event.setYdCd((String) request.getParameter("yd_cd"));
		
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