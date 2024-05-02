/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_SCE_0154HTMLAction.java
*@FileTitle : SCE
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.07
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2011.07.07 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwllNtfcSrchVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.sce.dwellnotification 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DwellNotificationSC로 실행요청<br>
 * - DwellNotificationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Chae Change Ho
 * @see DwellNotificationEvent 참조
 * @since J2EE 1.6
 */

public class ESD_SCE_0163HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_SCE_0154HTMLAction 객체를 생성
	 */
	public ESD_SCE_0163HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DwellNotificationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsdSce0163Event event = new EsdSce0163Event();
		DwllNtfcSrchVO dellvo = new DwllNtfcSrchVO();
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setDwllNtfcSrchVO((DwllNtfcSrchVO)getVO(request, DwllNtfcSrchVO .class));
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setDwllNtfcSrchVOS(dellvo.fromRequestGrid(request, ""));
		}else if(command.isCommand(FormCommand.MULTI01)) {
			event.setDwllNtfcSrchVOS(dellvo.fromRequestGrid(request, ""));
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