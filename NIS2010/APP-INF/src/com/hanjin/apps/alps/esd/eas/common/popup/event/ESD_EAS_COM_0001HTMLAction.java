/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_COM_0001HTMLAction.java
*@FileTitle : Common Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-27
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-27 yujin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.common.popup.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;


/**
 * HTTP Parser<br>
 * - ESD_EAS_COM_0001 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CommonPopUpManagSC로 실행요청<br>
 * - CommonPopUpManagSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author yujin
 * @see EsdEasCom0001Event 참조
 * @since J2EE 1.4
 */
public class ESD_EAS_COM_0001HTMLAction extends HTMLActionSupport {


	/**
	 * ESD_EAS_COM_0001HTMLAction 객체를 생성
	 */
	public ESD_EAS_COM_0001HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_920Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		EsdEasCom0001Event event = new EsdEasCom0001Event();
		
		String ctrl_ofc_cd = JSPUtil.getNull(request.getParameter("ctrl_ofc_cd"));
		String sel_ofc_cd  = JSPUtil.getNull(request.getParameter("sel_ofc_cd"));
		event.setCtrl_ofc_cd(ctrl_ofc_cd);
		event.setSel_ofc_cd(sel_ofc_cd);
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