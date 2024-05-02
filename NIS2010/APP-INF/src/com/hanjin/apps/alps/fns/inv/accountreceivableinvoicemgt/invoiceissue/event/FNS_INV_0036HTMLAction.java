/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0036HTMLAction.java
*@FileTitle : (Vietnam) Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.10.29 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.GeneralInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIEDailyExrateVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author saeil kim
 * @see AccountReceivableInvoiceMgtEvent 참조
 * @since J2EE 1.4
 */

public class FNS_INV_0036HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0036HTMLAction 객체를 생성
	 */
	public FNS_INV_0036HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountReceivableInvoiceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		FnsInv0036Event event = new FnsInv0036Event();

		if(command.isCommand(FormCommand.MULTI)) {
			event.setGeneralInvoiceVO((GeneralInvoiceVO)getVO(request, GeneralInvoiceVO .class));
		} else if(command.isCommand(FormCommand.SEARCH)) {
			event.setVIEDailyExrateVO((VIEDailyExrateVO)getVO(request, VIEDailyExrateVO .class));
			event.setEventType(request.getParameter("event_type"));
			event.setPageType(request.getParameter("pagetype"));
			event.setEventOfc(request.getParameter("event_ofc"));
		} else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setGeneralInvoiceVO((GeneralInvoiceVO)getVO(request, GeneralInvoiceVO .class));
		} else if(command.isCommand(FormCommand.SEARCH02)) {
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("iss_type",request.getParameter("iss_type"));
			hm.put("inv_no_list",request.getParameter("inv_no_list"));
			event.setEventParams(hm);
			event.setGeneralInvoiceVO((GeneralInvoiceVO)getVO(request, GeneralInvoiceVO .class));
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