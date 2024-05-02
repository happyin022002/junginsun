/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0948HTMLAction.java
*@FileTitle : Hold Mail/Alert Set-Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.BkgHldNtcUsrVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InboundBLMgtSC로 실행요청<br>
 * - InboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author
 * @see InboundBLMgtEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0948HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0948HTMLAction 객체를 생성
	 */
	public ESM_BKG_0948HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InboundBLMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0948Event event = new EsmBkg0948Event();
		
		/* 화면 조회하기 */
		if (command.isCommand(FormCommand.SEARCH)) 
		{
			event.setLocCd(JSPUtil.getParameter(request, "loc_cd"));
			event.setUserId(JSPUtil.getParameter(request, "user_id"));
		} 
		/* 저장하기 */
		else if (command.isCommand(FormCommand.MULTI)) {			
			event.setBkgHldNtcUsrVOS((BkgHldNtcUsrVO[])getVOs(request, BkgHldNtcUsrVO.class, "sheet1_"));
		} 
		/* Location Code 유효성 체크 */
		else if (command.isCommand(FormCommand.SEARCH01)) {
			event.setLocCd(JSPUtil.getParameter(request, "loc_cd"));
		} 
		/* Hold Code 조회하기 */
		else if (command.isCommand(FormCommand.SEARCH02)) {
			event.setCntCd(JSPUtil.getParameter(request, "cnt_cd"));
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