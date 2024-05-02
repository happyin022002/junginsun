/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_COA_9000HTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.18 SJH
* 1.0 Creation 
=========================================================*/
package com.clt.apps.opus.esm.coa.common.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.coa.common.vo.BkgSokeupVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * @author Chan Min Park
 * @see EsmCoa9000Event 참조
 * @since J2EE 1.6
 */

public class ESM_COA_9000HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_COA_0016HTMLAction 객체를 생성
	 */
	public ESM_COA_9000HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EQBalanceEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EsmCoa9000Event event = new EsmCoa9000Event();
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setBkgSokeupVOS((BkgSokeupVO[])getVOs(request, BkgSokeupVO .class,""));
			event.setBkgSokeupVO((BkgSokeupVO)getVO(request, BkgSokeupVO .class));
		}else if(command.isCommand(FormCommand.MULTI01)) {
			event.setBkgSokeupVOS((BkgSokeupVO[])getVOs(request, BkgSokeupVO .class,""));
			event.setBkgSokeupVO((BkgSokeupVO)getVO(request, BkgSokeupVO .class));
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