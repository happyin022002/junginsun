/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0023HTMLAction.java
*@FileTitle : Other Revenue Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.04.27 김세일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingInputVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceCreationSC로 실행요청<br>
 * - AccountReceivableInvoiceCreationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author saeil kim
 * @see AccountReceivableInvoiceCreationEvent 참조
 * @since J2EE 1.4
 */

public class FNS_INV_0023HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0023HTMLAction 객체를 생성
	 */
	public FNS_INV_0023HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0023Event event = new FnsInv0023Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setNonShippingInputVO((NonShippingInputVO)getVO(request, NonShippingInputVO .class));
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