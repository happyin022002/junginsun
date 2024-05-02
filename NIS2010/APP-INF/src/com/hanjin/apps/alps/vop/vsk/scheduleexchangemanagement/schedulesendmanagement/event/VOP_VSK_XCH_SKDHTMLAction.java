/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_XCH_SKDHTMLAction.java
*@FileTitle : Coastal SKD Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : Jung Jinwoo
*@LastVersion : 1.0
* 2009.06.11 Jung Jinwoo
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.event;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SwapCstSkdSimVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.vop.vsk.scheduleplanningoperation.vesselschedulemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SchedulePlanningOperationSC로 실행요청<br>
 * - SchedulePlanningOperationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jung Jinwoo
 * @see VopVskXchSkdEvent 참조
 * @since J2EE 1.5
 */

public class VOP_VSK_XCH_SKDHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_VSK_XCH_SKDHTMLAction 객체를 생성
	 */
	public VOP_VSK_XCH_SKDHTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SchedulePlanningOperationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand 		command = FormCommand.fromRequest(request);
		VopVskXchSkdEvent 	event 	= new VopVskXchSkdEvent();
		
		if (command.isCommand(FormCommand.COMMAND01)){	//::jsk::2014-03-21:://SEND EDI "CKYH"//
			event.setSwapCstSkdSimVO((SwapCstSkdSimVO)getVO(request, SwapCstSkdSimVO .class));
			//event.setSwapCstSkdSimVOs((SwapCstSkdSimVO[])getVOs(request, SwapCstSkdSimVO.class, "sheet1_"));

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