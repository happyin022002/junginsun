/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VOP_FCM_0002HTMLAction.java
*@FileTitle : Departure Report Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.07
*@LastModifier : 이병훈
*@LastVersion : 1.0
* 1.0 Creation
* 
* [CHM-201640787] 연료 소모 분석관련  Departure Report 신규 화면 개발 - 2016.04.07 이병훈
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslFcmDepRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslRptInqVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.vop.fcm.vesselreport 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 VesselReportSC로 실행요청<br>
 * - VesselReportSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author 이병훈
 * @see VesselReportEvent 참조
 * @since J2EE 1.4
 */
public class VOP_FCM_0002HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_FCM_0002HTMLAction 객체를 생성
	 */
	public VOP_FCM_0002HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 VSKCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		VopFcm0002Event event = new VopFcm0002Event();
		
		if (command.isCommand(FormCommand.SEARCH)){
			event.setVslRptInqVO((VslRptInqVO)getVO(request, VslRptInqVO.class));
			request.setAttribute("Event", event);
		} else if (command.isCommand(FormCommand.SEARCHLIST)) {
			event.setVslRptInqVO((VslRptInqVO)getVO(request, VslRptInqVO.class));
			request.setAttribute("Event", event);
		} else if (command.isCommand(FormCommand.MULTI)) {
			event.setVslFcmDepRptVOs((VslFcmDepRptVO[])getVOs(request, VslFcmDepRptVO.class));
			request.setAttribute("Event", event);
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