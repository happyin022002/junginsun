/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_047HTMLAction.java
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
 * - Parsing 한 정보를 Event로 변환, request에 담아 ESD_TRS_047SC로 실행요청<br>
 * - ESD_TRS_047SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Kildong_hong
 * @see EsdTrs0047Event , ESD_TRS_047EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0047HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_047HTMLAction 객체를 생성
	 */
	public ESD_TRS_0047HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_047Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		EsdTrs0047Event event = new EsdTrs0047Event();

		event.setCostOfcCd	(JSPUtil.getParameter(request, "cost_ofc_cd", 	""));
		event.setFmEffDt	(JSPUtil.getParameter(request, "fm_eff_dt", 	""));
		event.setToEffDt	(JSPUtil.getParameter(request, "to_eff_dt", 	""));
		event.setIfStatus	(JSPUtil.getParameter(request, "if_status", 	""));
		event.setDtStatus	(JSPUtil.getParameter(request, "dt_status", 	""));
		event.setMultCsrNo	(JSPUtil.getParameter(request, "mult_csr_no", 	""));
		event.setCsrNo		(JSPUtil.getParameter(request, "csr_no", 		""));
		event.setUsrId		(JSPUtil.getParameter(request, "usr_id", 		""));
				
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