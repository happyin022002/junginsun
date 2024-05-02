/*=========================================================
*Copyright(c) 2015 CyberLogitec 
*@FileName : ESD_EAS_0227HTMLAction.java
*@FileTitle : Performance For Logistics Expense
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-02
*@LastModifier : 9014613
*@LastVersion : 1.0
* 2015-02-02 9014613
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.vo.SearchAutoAuditChangeHistoryVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * @author 9014613
 * @see EsdEas0227Event , ESD_EAS_0227EventResponse 참조
 * @since J2EE 1.6
 */
public class ESD_EAS_0227HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_EAS_0227HTMLAction 객체를 생성
	 */
	public ESD_EAS_0227HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 PsoAdvanceAuditEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsdEas0227Event event = new EsdEas0227Event();
		
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setSearchAutoAuditChangeHistoryVO((SearchAutoAuditChangeHistoryVO)getVO(request, SearchAutoAuditChangeHistoryVO .class));
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