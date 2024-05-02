/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_PRI_0141HTMLAction.java
*@FileTitle : MOT/SSE Tariff 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.25
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.04.25 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchMOTSSEFilingListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriMotTrfMnVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.screport 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCReportSC로 실행요청<br>
 * - SCReportSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SongHoJin
 * @see SCReportEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_0141HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_0141HTMLAction 객체를 생성
	 */
	public ESM_PRI_0141HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCReportEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri0141Event event = new EsmPri0141Event();
		
		if(command.isCommand(FormCommand.MULTI) ||command.isCommand(FormCommand.MULTI01) ) {
			event.setPriMotTrfMnVO((PriMotTrfMnVO)getVO(request, PriMotTrfMnVO .class));
			event.setRsltSearchMOTSSEFilingListVOS((RsltSearchMOTSSEFilingListVO[])getVOs(request, RsltSearchMOTSSEFilingListVO .class, "sheet1_"));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setRsltSearchMOTSSEFilingListVO((RsltSearchMOTSSEFilingListVO)getVO(request, RsltSearchMOTSSEFilingListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01) || command.isCommand(FormCommand.SEARCH02)) {
			event.setRsltSearchMOTSSEFilingListVO((RsltSearchMOTSSEFilingListVO)getVO(request, RsltSearchMOTSSEFilingListVO .class));
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