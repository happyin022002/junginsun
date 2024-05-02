/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0124HTMLAction.java
*@FileTitle : Container Type/Size
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.29 
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.29 
* 1.0 Creation
* 
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event;


import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.spc.basicdatamanage.BasicDataManageSC;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;


/**
 * HTTP Parser<br>
 * - com/hanjin/apps/alps/esm/spc/basicdatamanage/BasicDataManageSC 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BasicDataManageSC로 실행요청<br>
 * - GeneralBookingConductS에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Yang Dong Hun
 * @see BasicDataManageSC 참조
 * @since J2EE 1.6
 */

public class ESM_SPC_0124HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_1183HTMLAction 객체를 생성
	 */
	public ESM_SPC_0124HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		log.debug("[START::  ESM_SPC_0124HTMLAction  ]==========");
		EsmSpc0124Event event = new EsmSpc0124Event();
		event.setBkgNo(request.getParameter("bkg_no"));
		log.debug("[END:: perform ESM_SPC_0124HTMLAction  ]==========");
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