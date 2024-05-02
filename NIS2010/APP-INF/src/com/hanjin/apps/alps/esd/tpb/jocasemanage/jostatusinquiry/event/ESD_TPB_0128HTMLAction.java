/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0128HTMLAction.java
*@FileTitle : JOStatusInquiryConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-02
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.0
* 2008-09-16 O Wan-Ki 			1.0	 최초 생성
* 2009-11-02 Jong-Geon Byeon	1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchJOTPBDetailInfoVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchJOTPBDetailListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.enis.esd.tpb.candidatemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 JOStatusInquiryManageSC로 실행요청<br>
 * - JOStatusInquiryManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author GUN-HA HWANG
 * @see JOStatusInquiryManageEvent 참조
 * @since J2EE 1.6
 */

public class ESD_TPB_0128HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_TPB_0128HTMLAction 객체를 생성
	 */
	public ESD_TPB_0128HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 JOStatusInquiryManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsdTpb0128Event event = new EsdTpb0128Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setSearchJOTpbDetailInfoVO((SearchJOTPBDetailInfoVO)getVO(request, SearchJOTPBDetailInfoVO .class));
		} else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setSearchJOTpbDetailListVO((SearchJOTPBDetailListVO)getVO(request, SearchJOTPBDetailListVO .class));
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