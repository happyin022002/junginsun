/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_1030HTMLAction.java
*@FileTitle : ManualRegister
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.vo.CreateTPBCandidateVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
 
/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.tpb.candidatemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ManualRegisterManageSC로 실행요청<br>
 * - ManualRegisterManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author GUN-HA HWANG
 * @see ManualRegisterManageEvent 참조
 * @since J2EE 1.6
 */

public class ESD_TPB_0103HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_TPB_103HTMLAction 객체를 생성
	 */
	public ESD_TPB_0103HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ManualRegisterManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsdTpb0103Event event = new EsdTpb0103Event();
		
		if(command.isCommand(FormCommand.MULTI) || command.isCommand(FormCommand.ADD) ) {
			event.setCreateTPBCandidateVOs((CreateTPBCandidateVO[])getVOs(request, CreateTPBCandidateVO .class,""));
		} else if(command.isCommand(FormCommand.SEARCH)) {
			event.setCreateTPBCandidateVO((CreateTPBCandidateVO)getVO(request, CreateTPBCandidateVO .class));
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