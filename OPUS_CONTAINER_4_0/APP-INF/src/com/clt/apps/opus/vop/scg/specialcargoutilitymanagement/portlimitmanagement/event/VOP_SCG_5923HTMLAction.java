/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VOP_SCG_5923HTMLAction.java
*@FileTitle : Port Limits DG Total Weight Check
*Open Issues :
*Change history : 2014.11.21
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLmtSubsRskVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLimitsUnNoVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.opus.vop.scg.PortLimitManagement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SpecialCargoUtilityManagementSC 실행요청<br>
 * - SpecialCargoUtilityManagementSC View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Un Jeong
 * @see 
 * @since J2EE 1.6
 */

public class VOP_SCG_5923HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_SCG_5923HTMLAction 객체를 생성
	 */
	public VOP_SCG_5923HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EquipmentManagementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopScg5923Event event = new VopScg5923Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setPortLmtSubsRskVO((PortLmtSubsRskVO)getVO(request, PortLmtSubsRskVO .class,""));
		} else if (command.isCommand(FormCommand.MULTI)){
			event.setPortLmtSubsRskVO((PortLmtSubsRskVO)getVO(request, PortLmtSubsRskVO .class,""));
			event.setPortLmtSubsRskVOs((PortLmtSubsRskVO[])getVOs(request, PortLmtSubsRskVO .class,"sheet1_"));
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