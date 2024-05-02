/*=========================================================
*Copyright(c) 2016 CyberLogitec 
*@FileName : EDS_EAS_0369HTMLAction.java
*@FileTitle : Futile Trip Container
*Open Issues :
*Change history :
*@LastModifyDate : 2016-03-29
*@LastModifier : Seong-Pill hong
*@LastVersion : 1.0
* 2016-03-29 Seong-Pill hong
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrMovementVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrReportINVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EDS_EAS_0369HTMLAction PDTO(Data Transfer Object including Parameters)<br>
 * @author Seong-Pill hong
 * @see EventSupport 참조
 * @since J2EE 1.4 
 */
public class ESD_EAS_0369HTMLAction extends HTMLActionSupport {
	
	private static final long serialVersionUID = 1L;

	/**
     * EDS_EAS_0367HTMLAction 객체를 생성
     */
	public ESD_EAS_0369HTMLAction() {
	}
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdEas0369Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsdEas0369Event event = new EsdEas0369Event();
		event.setAttribute("KEY", request.getParameter("backendjob_key"));

		if(command.isCommand(FormCommand.SEARCH)){ 
			event.setMnrMovementVO((MnrMovementVO)getVO(request, MnrMovementVO.class));
		} else if(command.isCommand(FormCommand.SEARCH01)){
			event.setMnrMovementVO((MnrMovementVO)getVO(request, MnrMovementVO.class));
 		} else if(command.isCommand(FormCommand.SEARCH02)){
			event.setMnrMovementVO((MnrMovementVO)getVO(request, MnrMovementVO.class));
 		} else if(command.isCommand(FormCommand.SEARCH03)){
			event.setMnrMovementVO((MnrMovementVO)getVO(request, MnrMovementVO.class));
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
