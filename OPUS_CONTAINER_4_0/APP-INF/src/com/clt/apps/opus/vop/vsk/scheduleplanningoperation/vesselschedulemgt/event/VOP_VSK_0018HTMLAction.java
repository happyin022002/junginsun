/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0018HTMLAction.java
*@FileTitle : VSL SKD Delete & Closing
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.08
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.08.07 유혁
* 1.0 Creation
* 
* History
* 2010.12.08 진마리아  CHM-201007135-01 Actaul Carrier update 로직 변경 요청건
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActivationVvdVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.nis2010.vms.vsk.scheduleplanningoperation 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SchedulePlanningOperationSC로 실행요청<br>
 * - SchedulePlanningOperationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SEO CHANG YUL
 * @see SchedulePlanningOperationEvent 참조
 * @since J2EE 1.4
 */

public class VOP_VSK_0018HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_VSK_0018HTMLAction 객체를 생성
	 */
	public VOP_VSK_0018HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SchedulePlanningOperationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopVsk0018Event event = new VopVsk0018Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setActivationVvdVOS((ActivationVvdVO[])getVOs(request, ActivationVvdVO.class,"sheet1_"));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setActivationVvdVO((ActivationVvdVO)getVO(request, ActivationVvdVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setActivationVvdVO((ActivationVvdVO)getVO(request, ActivationVvdVO.class));
		}
		else if(command.isCommand(FormCommand.MULTI01)) {
			event.setActivationVvdVOS((ActivationVvdVO[])getVOs(request, ActivationVvdVO.class, "sheet1_"));
		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			event.setActivationVvdVOS((ActivationVvdVO[])getVOs(request, ActivationVvdVO.class, "sheet1_"));
		}
		else if(command.isCommand(FormCommand.MULTI03)) {
			event.setActivationVvdVO((ActivationVvdVO)getVO(request, ActivationVvdVO.class, "sheet1_"));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setCrrCd(request.getParameter("crrCd"));
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