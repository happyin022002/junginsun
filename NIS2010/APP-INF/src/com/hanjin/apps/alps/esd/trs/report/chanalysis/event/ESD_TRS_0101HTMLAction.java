/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_001HTMLAction.java
*@FileTitle : Pending List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : kimjin
*@LastVersion : 1.0
* 2009-10-01 kimjin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.chanalysis.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.soinquiry.pendinglist.event.EsdTrs0001Event;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.soinquiry 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ESD_TRS_001SC로 실행요청<br>
 * - ESD_TRS_001SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author kimjin
 * @see EsdTrs0001Event , ESD_TRS_001EventResponse 참조
 * @since J2EE 1.6
 */
public class ESD_TRS_0101HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_001HTMLAction 객체를 생성
	 */
	public ESD_TRS_0101HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_001Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
	  	  int codeLength = 0;
	  	  String [] cargo = request.getParameterValues("cargo");
	  	  if (cargo != null) codeLength = cargo.length;
	  	  
	  	  EsdTrs0101Event event = new EsdTrs0101Event();
	  	
		  event.setSoFmdt		(JSPUtil.getParameter(request, "hid_fmdt", ""));
		  event.setSoTodt		(JSPUtil.getParameter(request, "hid_todt", ""));
		  event.setInputOffice	(JSPUtil.getParameter(request, "input_office", ""));
		  event.setHidBoundmode	(JSPUtil.getParameter(request, "hid_boundmode", ""));
		  event.setHidBkgterm	(JSPUtil.getParameter(request, "hid_bkgterm", ""));
		  event.setHidTrosts	(JSPUtil.getParameter(request, "hid_trosts", ""));
		  event.setHidInclmty	(JSPUtil.getParameter(request, "hid_inclmty", ""));
		  event.setFrmNode		(JSPUtil.getParameter(request, "frm_node", ""));
		  event.setToNode		(JSPUtil.getParameter(request, "to_node", ""));
		  event.setFrmYard		(JSPUtil.getParameter(request, "frm_yard", ""));
		  event.setToYard		(JSPUtil.getParameter(request, "to_yard", ""));
		  event.setHidWeek		(JSPUtil.getParameter(request, "hid_week", ""));
		  event.setHidPeriod	(JSPUtil.getParameter(request, "hid_period", ""));
		  event.setHidRhq		(JSPUtil.getParameter(request, "hid_rhq", ""));
		  event.setTrunkVvd		(JSPUtil.getParameter(request, "trunk_vvd", ""));
		  
		  request.setAttribute("Event", event);

		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값  저장<br>
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