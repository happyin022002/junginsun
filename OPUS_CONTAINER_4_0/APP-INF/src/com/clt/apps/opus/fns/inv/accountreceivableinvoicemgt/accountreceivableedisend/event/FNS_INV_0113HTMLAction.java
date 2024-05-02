/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FNS_INV_0113HTMLAction.java
*@FileTitle : APC Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.14
*@LastModifier : myoungsin park
*@LastVersion : 1.0
* 2014.12.14 myoungsin park
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.APCInvoiceVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * @author myoungsin park
 * @see FnsInv0113Event 참조
 * @since J2EE 1.6
 */

public class FNS_INV_0113HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0119HTMLAction 객체를 생성
	 */
	public FNS_INV_0113HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0113Event event = new FnsInv0113Event();
			
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setaPCInvoiceVO((APCInvoiceVO)getVO(request, APCInvoiceVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			event.setaPCInvoiceVOs((APCInvoiceVO[])getVOs(request, APCInvoiceVO .class, "sheet1_"));
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
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param Event event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}