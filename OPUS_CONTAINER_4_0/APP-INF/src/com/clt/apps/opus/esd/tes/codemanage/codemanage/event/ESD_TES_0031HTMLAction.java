/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_031HTMLAction.java
*@FileTitle : Carrier Code 생성/조회
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-05
*@LastModifier : Jin_seung_Kim
*@LastVersion : 1.0
* 2006-09-05 Jin_seung_Kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.codemanage.codemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.tes 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CodeManageSC로 실행요청<br>
 * - CodeManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Jin_seung_Kim
 * @see EsdTes0031Event , ESD_TES_031EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TES_0031HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TES_031HTMLAction 객체를 생성
	 */
	public ESD_TES_0031HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 UI_ESD_TES_031Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request  
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		EsdTes0031Event event = new EsdTes0031Event(); 
		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request  
	 * @param eventResponse 
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request  
	 * @param event 
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}