/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_PRI_0150HTMLAction.java
*@FileTitle : Korea MOF Filing (by Upload)
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.27
*@LastModifier : 전지예
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchKoreaMOTListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchMOTSSEFilingListVO;

public class ESM_PRI_0150HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_0150HTMLAction 객체를 생성
	 */
	public ESM_PRI_0150HTMLAction() {}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCReportEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri0150Event event = new EsmPri0150Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setRsltSearchKoreaMOTListVO((RsltSearchKoreaMOTListVO)getVO(request, RsltSearchKoreaMOTListVO .class));
			
		} else if(command.isCommand(FormCommand.MULTI)) {
			event.setRsltSearchKoreaMOTListVO((RsltSearchKoreaMOTListVO)getVO(request, RsltSearchKoreaMOTListVO .class));
			event.setRsltSearchKoreaMOTListVOS((RsltSearchKoreaMOTListVO[])getVOs(request, RsltSearchKoreaMOTListVO.class, "sheet1_"));
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
