/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EqYardOrzHTMLAction.java
*@FileTitle : EsdSce114
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2009.07.30 신한성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.common.popup.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.common.popup.vo.ComOfficeManagementVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.EQYARDManageConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.sce.common 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 commonSC로 실행요청<br>
 * - commonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Shin Han Sung
 * @see commonEvent 참조
 * @since J2EE 1.6
 */

public class EqYardOrzHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EqYardOrzHTMLAction 객체를 생성
	 */
	public EqYardOrzHTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 commonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EqYardOrzEvent event = new EqYardOrzEvent();
		
		if(command.isCommand(FormCommand.SEARCH03)) {
			event.setEqYARDManageConditionVO((EQYARDManageConditionVO)getVO(request, EQYARDManageConditionVO .class));
		}else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setComOfficeManagementVO((ComOfficeManagementVO)getVO(request, ComOfficeManagementVO .class));
		}else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setComOfficeManagementVO((ComOfficeManagementVO)getVO(request, ComOfficeManagementVO .class));
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