/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0649HTMLAction.java
*@FileTitle : Cancel Issue Release
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.07.20 이진서
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 *Internet O.B/L Print Authorize[UC-BKG-009 B/L 발행 송부]
 *B/L Issue 화면(UI_BKG-0079-09) 의 Internet Auth 버튼에 연결된 팝업
 * @author Lee Jin Seo
 * @see OutboundBLMgtEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_1074HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_1074HTMLAction 객체를 생성
	 */
	public ESM_BKG_1074HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 OutboundBLMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	//FormCommand command = FormCommand.fromRequest(request);
    	EsmBkg1074Event event = new EsmBkg1074Event();
    	log.debug("START: perform=================  1074 ()");
		String bkg_no 			= JSPUtil.getParameter(request, "bkg_no");
		String bl_no 			= JSPUtil.getParameter(request, "bl_no");
		String shpr_cd 			= JSPUtil.getParameter(request, "shpr_cd");
		String shpr_nm 			= JSPUtil.getParameter(request, "shpr_nm");
		String fwdr_cd 			= JSPUtil.getParameter(request, "fwdr_cd");
		String fwdr_nm 			= JSPUtil.getParameter(request, "fwdr_nm");
		String email_to 		= JSPUtil.getParameter(request, "email_to");
		String email_subject 	= JSPUtil.getParameter(request, "email_subject");
		String email_contents 	= JSPUtil.getParameter(request, "email_contents");
		
		event.setBkgNo(bkg_no);
		event.setBlNo(bl_no);
		event.setShprCd(shpr_cd);
		event.setShprNm(shpr_nm);
		event.setFwdrCd(fwdr_cd);
		event.setFwdrNm(fwdr_nm);
		event.setEmailTo(email_to);
		event.setEmailSubject(email_subject);
		event.setEmailContents(email_contents);
		/*
		if(command.isCommand(FormCommand.SEARCH)) {
			//Search
			
		}else if(command.isCommand(FormCommand.MULTI01)) {
			//Authorize
			
		}else if(command.isCommand(FormCommand.MULTI02)) {
			//E-mail
			
		}
		 */
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