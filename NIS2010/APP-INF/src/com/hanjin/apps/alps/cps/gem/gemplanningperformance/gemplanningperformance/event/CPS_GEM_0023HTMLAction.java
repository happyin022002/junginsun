/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_GEM_0023HTMLAction.java
*@FileTitle : Request / Initial _ Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.04.21 최정미
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;

/**
 * [CPS_GEM_0023] Request / Initial _ Print
 * HTTP Parser<br> 
 * @author choijungmi
 * @see 
 * @since J2EE 1.4
 */
public class CPS_GEM_0023HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_GEM_0003HTMLAction 객체를 생성
	 */
	public CPS_GEM_0023HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>	
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		//FormCommand command = FormCommand.fromRequest(request);
		CpsGem0023Event event = new CpsGem0023Event();		
		// RequestNo 
		String genExpnRqstNo = JSPUtil.getParameter(request, "gen_expn_rqst_no" , "");
		event.setGenExpnRqstNo(genExpnRqstNo);
		// 언어 구분 
		String langDiv = JSPUtil.getParameter(request, "lang_div" , "");
		event.setLangDiv(langDiv);
		//예산 년도
		String plnYrmon = JSPUtil.getParameter(request, "pln_yrmon" , "");
		event.setPlnYrmon(plnYrmon);
		//시퀀스번호
		String genExpnRqstSeq = JSPUtil.getParameter(request, "gen_expn_rqst_seq" , "");
		event.setGenExpnRqstSeq(genExpnRqstSeq);
		
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