/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BCM_CCD_2001HTMLAction.java
*@FileTitle : BCM_CCD_2001
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.event;
 
import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.SearchMdmHistoryListVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.bcm.ccd.commoncode 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CommonCodeSC로 실행요청<br>
 * - CommonCodeSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author  
 * @see CommonCodeEvent 참조
 * @since J2EE 1.6
 */

public class BCM_CCD_2003HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * BCM_CCD_2001HTMLAction 객체를 생성
	 */
	public BCM_CCD_2003HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CommonCodeEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		BcmCcd2003Event event = new BcmCcd2003Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setSearchMdmHistoryListVO((SearchMdmHistoryListVO)getVO(request, SearchMdmHistoryListVO .class,""));
		} else if(command.isCommand(FormCommand.SEARCH01)) {	
			event.setSearchMdmHistoryListVO((SearchMdmHistoryListVO)getVO(request, SearchMdmHistoryListVO .class,""));
		} else if(command.isCommand(FormCommand.SEARCH02)) {	
			event.setSearchMdmHistoryListVO((SearchMdmHistoryListVO)getVO(request, SearchMdmHistoryListVO .class,""));	
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