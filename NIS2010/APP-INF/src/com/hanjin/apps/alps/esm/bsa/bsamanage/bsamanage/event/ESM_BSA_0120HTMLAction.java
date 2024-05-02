/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BSA_0120HTMLAction.java
*@FileTitle : Carrier's Infomation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.09.29 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchBsaConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bsa.bsamanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BSAManageSC로 실행요청<br>
 * - BSAManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author NAMKOONG Jin Ho
 * @see BSAManageEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BSA_0120HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BSA_0120HTMLAction 객체를 생성
	 */
	public ESM_BSA_0120HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BSAManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		log.debug("################# ESM_BSA_0120HTMLAction.perform() ############################[START]");
		EsmBsa0120Event event = new EsmBsa0120Event();
    	FormCommand command = FormCommand.fromRequest(request);
		
		if(command.isCommand(FormCommand.MULTI02)) {
			event.setSearchBsaConditionVO((SearchBsaConditionVO)getVO(request, SearchBsaConditionVO .class));
		}
		log.debug("################# ESM_BSA_0120HTMLAction.perform() ############################[end]");
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