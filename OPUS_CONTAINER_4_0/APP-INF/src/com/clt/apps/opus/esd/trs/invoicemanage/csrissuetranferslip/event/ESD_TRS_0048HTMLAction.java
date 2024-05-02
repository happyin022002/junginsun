/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_048HTMLAction.java
*@FileTitle : Invoice List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : kimjin
*@LastVersion : 1.0
* 2009-10-01 kimjin
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.invoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ESD_TRS_048SC로 실행요청<br>
 * - ESD_TRS_048SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author kimjin
 * @see EsdTrs0048Event , ESD_TRS_048EventResponse 참조
 * @since J2EE 1.6
 */
public class ESD_TRS_0048HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_048HTMLAction 객체를 생성
	 */
	public ESD_TRS_0048HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_048Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		EsdTrs0048Event event = new EsdTrs0048Event();
		
		String[] inv_no 		= request.getParameterValues("inv_no");
		String[] inv_vndr_seq 	= request.getParameterValues("inv_vndr_seq");
		String[] flag 			= request.getParameterValues("chk");
		
		event.setInv_no			(inv_no);
		event.setInv_vndr_seq	(inv_vndr_seq);
		event.setFlag			(flag);
		event.setCsrNo			(JSPUtil.getParameter(request, "csr_no", ""));
		event.setUsrId			(JSPUtil.getParameter(request, "usr_id", ""));
		event.setCostOfcCd		(JSPUtil.getParameter(request, "ofc_cd", ""));
		
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