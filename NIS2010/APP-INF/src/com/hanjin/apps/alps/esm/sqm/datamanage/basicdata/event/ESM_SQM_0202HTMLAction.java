/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0202HTMLAction.java
*@FileTitle      : POL-POD Management for IAS Sector
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.07
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.07 SQM USER
* 1.0 Creation
* History
* 2014.06.20 이혜민 [CHM-201430168] IAS Sector Sales - Main, Sector 구분자 추가를 위한 화면 변경
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.SqmSctrPairMgmtVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.sqm.datamenage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DataManageSC로 실행요청<br>
 * - DataManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SQM USER
 * @see EsmSqm0202Event 참조
 * @since J2EE 1.6
 */

public class ESM_SQM_0202HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_SQM_0202HTMLAction 객체를 생성
	 */
	public ESM_SQM_0202HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmSqm0202Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSqm0202Event event = new EsmSqm0202Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setAttribute("KEY", request.getParameter("backendjob_key"));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
			event.setSqmSctrPairMgmtVOS((SqmSctrPairMgmtVO[])getVOs(request, SqmSctrPairMgmtVO .class));
		}else if(command.isCommand(FormCommand.MULTI01)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
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