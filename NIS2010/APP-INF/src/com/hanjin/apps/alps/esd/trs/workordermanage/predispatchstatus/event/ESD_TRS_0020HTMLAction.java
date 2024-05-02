/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0020HTMLAction.java
*@FileTitle : Pre-Dispatch Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-13
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-12-13 kim_sang_geun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.predispatchstatus.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.workordermanage.predispatchstatus.vo.SearchPreDispatchStatusVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.workordermanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WorkOrderManageSC로 실행요청<br>
 * - WorkOrderManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author kim_sang_geun
 * @see EsdTrs0020Event 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0020HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_0020HTMLAction 객체를 생성
	 */
	public ESD_TRS_0020HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdTrs0020Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand   command = FormCommand.fromRequest(request);
		EsdTrs0020Event event = new EsdTrs0020Event();
		
		if (command.isCommand(FormCommand.SEARCH)) {
			event.setSearchPreDispatchStatusVo((SearchPreDispatchStatusVO) getVO(request,SearchPreDispatchStatusVO.class));
		}else if (command.isCommand(FormCommand.SEARCH01)) {
			event.setSearchPreDispatchStatusVo((SearchPreDispatchStatusVO) getVO(request,SearchPreDispatchStatusVO.class));
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