/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_SAM_0008HTMLAction.java
*@FileTitle : Sales Activity Report
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.05.09 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo.SRepInfoVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.SamSlsActVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.sam.salesactivitymanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SalesActivityManageSC로 실행요청<br>
 * - SalesActivityManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author NAMKOONGJINHO
 * @see SalesActivityManageEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SAM_0008HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SAM_0008HTMLAction 객체를 생성
	 */
	public ESM_SAM_0008HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SalesActivityManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSam0008Event event = new EsmSam0008Event();
		

		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setSRepInfoVO((SRepInfoVO)getVO(request, SRepInfoVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setSRepInfoVO((SRepInfoVO)getVO(request, SRepInfoVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setSRepInfoVO((SRepInfoVO)getVO(request, SRepInfoVO .class));
		}
		else if (command.isCommand(FormCommand.SEARCH04)){
			event.setSRepInfoVO((SRepInfoVO)getVO(request, SRepInfoVO .class));
		}
		else if (command.isCommand(FormCommand.SEARCH05)){
			event.setSamSlsActVO((SamSlsActVO)getVO(request, SamSlsActVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI01)) {	
			event.setSRepInfoVOS((SRepInfoVO[])getVOs(request, SRepInfoVO.class,""));		
		}
		else if(command.isCommand(FormCommand.MULTI02)) {	
			event.setSRepInfoVOS((SRepInfoVO[])getVOs(request, SRepInfoVO.class,""));		
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