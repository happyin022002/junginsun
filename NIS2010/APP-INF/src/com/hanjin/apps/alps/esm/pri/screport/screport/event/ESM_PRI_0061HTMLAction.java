/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0061HTMLAction.java
*@FileTitle : S/C Retrieval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.06.30 변영주
* 1.0 Creation
* =========================================================
* History
* 2015.09.25 최성환 [CHM-201537788] SC 다운로드 보안 강화_2차 개발
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropMnDlRecVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.syscommon.common.table.PriSpMnVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.screport 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCReportSC로 실행요청<br>
 * - SCReportSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Byeon Young Joo
 * @see SCReportEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_0061HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_0061HTMLAction 객체를 생성
	 */
	public ESM_PRI_0061HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCReportEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri0061Event event = new EsmPri0061Event();
		

		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setPriSpMnVO((PriSpMnVO)getVO(request, PriSpMnVO .class));
		} else if(command.isCommand(FormCommand.COMMAND01)) {
			event.setRsltPropMnDlRecVO((RsltPropMnDlRecVO)getVO(request, RsltPropMnDlRecVO .class));
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