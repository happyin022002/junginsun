/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0118HTMLAction.java
*@FileTitle : TPB Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-14
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.2
* 2008-09-10 O Wan-Ki 			1.0	최초 생성
* 2009-04-30 O Wan-Ki 			1.1 JDK 1.5 반영에 의한 수정. (enum -> enu)
* 2009-10-19 Jong-Geon Byeon	1.2 Renewal Migration
=========================================================*/
package com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBInvoiceListVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.tpb.candidatemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 StatusInquiryManageSC로 실행요청<br>
 * - StatusInquiryManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author GUN-HA HWANG
 * @see StatusInquiryManageEvent 참조
 * @since J2EE 1.6
 */

public class ESD_TPB_0118HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_TPB_0118HTMLAction 객체를 생성
	 */
	public ESD_TPB_0118HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 StatusInquiryManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsdTpb0118Event event = new EsdTpb0118Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setSearchTpbInvoiceListVOS((SearchTPBInvoiceListVO[])getVOs(request, SearchTPBInvoiceListVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setSearchTpbInvoiceListVO((SearchTPBInvoiceListVO)getVO(request, SearchTPBInvoiceListVO .class));
		}

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