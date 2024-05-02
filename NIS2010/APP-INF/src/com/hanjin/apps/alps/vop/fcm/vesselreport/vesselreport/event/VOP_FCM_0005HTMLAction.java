/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VOP_FCM_0004HTMLAction.java
*@FileTitle : Departure Report Item Error Correction (Pop-Up)
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* 
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmDepRptErrClsVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


public class VOP_FCM_0005HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_FCM_0005HTMLAction 객체를 생성
	 */
	public VOP_FCM_0005HTMLAction() {}


	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		VopFcm0005Event event = new VopFcm0005Event();
		
		if (command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.SEARCH01) || command.isCommand(FormCommand.SEARCH02)){
			event.setFcmDepRptErrClsVO((FcmDepRptErrClsVO)getVO(request, FcmDepRptErrClsVO.class));
		}else if (command.isCommand(FormCommand.MULTI)){
			event.setFcmDepRptErrClsVO((FcmDepRptErrClsVO)getVO(request, FcmDepRptErrClsVO.class));
		}else if (command.isCommand(FormCommand.REMOVE)){
			event.setFcmDepRptErrClsVO((FcmDepRptErrClsVO)getVO(request, FcmDepRptErrClsVO.class));
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