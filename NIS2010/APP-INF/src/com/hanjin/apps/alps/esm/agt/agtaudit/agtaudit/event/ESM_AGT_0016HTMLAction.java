/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESMAGT016HTMLAction.java
*@FileTitle : Agent Commission Audit Management Service Command
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.08.06 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.syscommon.common.table.AgtAgnCommDtlVO;
import com.hanjin.syscommon.common.table.AgtAgnCommVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.agt.agtaudit 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AGTAuditSC로 실행요청<br>
 * - AGTAuditSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Ho Jin
 * @see AGTAuditEvent 참조
 * @since J2EE 1.6
 */

public class ESM_AGT_0016HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESMAGT016HTMLAction 객체를 생성
	 */
	public ESM_AGT_0016HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AGTAuditEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmAgt0016Event event = new EsmAgt0016Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setAgtAgnCommVO((AgtAgnCommVO)getVO(request, AgtAgnCommVO .class));
		}
		
		if(command.isCommand(FormCommand.MULTI)){
//			log.info("\n    <<<<<<<<1>>>>>>>>>>>>>>>");
			event.setAgtAgnCommVOS((AgtAgnCommVO[])getVOs(request, AgtAgnCommVO .class, ""));
			event.setAgtAgnCommDtlVOS((AgtAgnCommDtlVO[])getVOs(request, AgtAgnCommDtlVO.class, ""));
		}
		
		if(command.isCommand(FormCommand.MODIFY)){
			event.setAgtAgnCommVO((AgtAgnCommVO)getVO(request, AgtAgnCommVO .class));
			event.setAgtAgnCommVOS((AgtAgnCommVO[])getVOs(request, AgtAgnCommVO .class, ""));
		}
		
		if(command.isCommand(FormCommand.REMOVE)){
			event.setAgtAgnCommVOS((AgtAgnCommVO[])getVOs(request, AgtAgnCommVO .class, ""));
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