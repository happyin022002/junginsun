/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EXP_SPP_0302HTMLAction.java
*@FileTitle : Rental payable invoice inquiry by Lessee via SPP
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.08.18 김성광
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.exp.spp.plseinvoiceinquiry.invoiceinquiry.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.exp.spp.plseinvoiceinquiry.invoiceinquiry.vo.PayableInvoiceDataVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.exp.pap.plseinvoiceinquiry 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 PLSEInvoiceInquirySC로 실행요청<br>
 * - PLSEInvoiceInquirySC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Seong Kwang
 * @see ExpSpp0302Event 참조
 * @since J2EE 1.6
 */

public class EXP_SPP_0302HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EXP_SPP_0302HTMLAction 객체를 생성
	 */
	public EXP_SPP_0302HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ExpSpp0302Event 파싱하여 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	ExpSpp0302Event event = new ExpSpp0302Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {//Retrieve Button Click
			event.setPayableInvoiceDataVO((PayableInvoiceDataVO)getVO(request, PayableInvoiceDataVO .class));
		}

		request.setAttribute("Event", event);

		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param EventResponse eventResponse
	 * @exception
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param Event event
	 * @exception 
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}