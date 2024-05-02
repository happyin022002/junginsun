/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_9251HTMLAction.java
*@FileTitle : 3rd Party Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2007-09-28
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2007-09-28 kimjinjoo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.syscommon.common.table.TesN3rdPtyIfVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 serviceproviderinvoicemanageSC로 실행요청<br>
 * - serviceproviderinvoicemanageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author kimjinjoo
 * @see EsdTes9251Event , ESD_TES_9251EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TES_9251HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TES_9251HTMLAction 객체를 생성
	 */
	public ESD_TES_9251HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TES_9251Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		/*
         ibSheet 사용시 fromRequestGrid를 사용하는데
         prefix는 주로 멀티 Sheet 처리시에 사용하게 된다. (  sheet ID 형태의 prefix 구분자 )
         String prefix = "" ;
         TES_N3RD_PTY_IF tes_n3rd_pty_if = TES_N3RD_PTY_IF.fromRequestGrid(request, prefix);
        */

		EsdTes9251Event event 	= new EsdTes9251Event(); // table value object
		event.setTesN3rdPtyIfVO((TesN3rdPtyIfVO)getVO(request, TesN3rdPtyIfVO.class));    		
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