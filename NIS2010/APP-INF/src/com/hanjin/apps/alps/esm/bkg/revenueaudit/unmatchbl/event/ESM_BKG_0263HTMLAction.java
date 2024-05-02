/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0263HTMLAction.java
*@FileTitle : Freight & Charge Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.10.29 김대호
* 1.0 Creation
===============================================================================
* History
* 2011.05.12 이일민 [CHM-201109862-01] [BKG/DOC] BKG Creation Charge화면의 Self Audit기능 Transaction Time 변경 요청
* 2012.10.05 조정민 [CHM-201219854] [BKG] BKG 생성시 S/C 에 운임 조회 후 부재시 G/W 메일 SALES REP/PRICING STAFF 전송 기능 추가 
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.bkg.revenueaudit 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RevenueAuditSC로 실행요청<br>
 * - RevenueAuditSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Day-Hoh, Kim
 * @see RevenueAuditEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0263HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0263HTMLAction 객체를 생성
	 */
	public ESM_BKG_0263HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RevenueAuditEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0263Event event = new EsmBkg0263Event();
		if (command.isCommand(FormCommand.SEARCH)) {
			event.setAttribute("bl_no", request.getParameter("bl_no"));
			event.setAttribute("ca_flg", request.getParameter("ca_flg"));
		} else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setAttribute("key", request.getParameter("key"));
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
