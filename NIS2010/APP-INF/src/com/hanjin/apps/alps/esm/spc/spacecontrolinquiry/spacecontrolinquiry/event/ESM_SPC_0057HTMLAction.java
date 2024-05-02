/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0057HTMLAction.java
*@FileTitle : Space Utilization Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.30
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* 2013.10.30 최윤성 [CHM-201327083-01] IPC Sector 판매 활성화 Tool 개발 - Space Utilization 화면 신규 개발
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.spc.spacecontrolinquiry 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SpacecontrolinquirySC로 실행요청<br>
 * - SpacecontrolinquirySC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SHIN JA YOUNG
 * @see SpacecontrolinquiryEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SPC_0057HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SPC_0057HTMLAction 객체를 생성
	 */
	public ESM_SPC_0057HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SpacecontrolinquiryEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSpc0057Event event = new EsmSpc0057Event();
		
		if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setSearchSpaceControlInquiryConditionVO((SearchSpaceControlInquiryConditionVO)getVO(request, SearchSpaceControlInquiryConditionVO .class));
		} else if(command.isCommand(FormCommand.COMMAND01)) {
			event.setSearchSpaceControlInquiryConditionVO((SearchSpaceControlInquiryConditionVO)getVO(request, SearchSpaceControlInquiryConditionVO .class));
		} else if(command.isCommand(FormCommand.COMMAND02)) {
			event.setSearchSpaceControlInquiryConditionVO((SearchSpaceControlInquiryConditionVO)getVO(request, SearchSpaceControlInquiryConditionVO .class));
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