/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0033HTMLAction.java
*@FileTitle : View Claim Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2009.10.29 정행룡
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * CPS_CNI_0033 View Claim Main
 * HTTP Parser<br>
 * @author 정행룡
 * @see CpsCni0033Event 참조
 * @since J2EE 1.4
 */

public class CPS_CNI_0033HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_CNI_0033HTMLAction 객체를 생성
	 */
	public CPS_CNI_0033HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CpsCni0033Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		
		//이벤트 객체 생성 
		CpsCni0033Event event = new CpsCni0033Event();
		
		// ----------------------------------------------------
		// 이벤트 처리 
		// ----------------------------------------------------		
		// [open , retrieve] Cargo Claim No가 존재하는경우 open시 retrive
		if(command.isCommand(FormCommand.SEARCH)) {
			// Cargo Claim No
			String cgoClmNo = JSPUtil.getParameter(request, "cgo_clm_no","");
			
			event.setCgoClmNo(cgoClmNo);
			
		} else if(command.isCommand(FormCommand.SEARCH10)) {
			
			// Office Cd
			String ofcCd = JSPUtil.getParameter(request, "ofc_cd","");
			
			event.setOfcCd(ofcCd);
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