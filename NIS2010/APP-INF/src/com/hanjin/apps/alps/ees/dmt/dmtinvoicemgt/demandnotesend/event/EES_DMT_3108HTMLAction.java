/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3108HTMLAction.java
*@FileTitle : Demand Note Issue - Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.10.05 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InvoiceMgtSC로 실행요청<br>
 * - InvoiceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Choi Sung Hwan
 * @see InvoiceMgtEvent 참조
 * @since J2EE 1.6
 */

public class EES_DMT_3108HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_DMT_3108HTMLAction 객체를 생성
	 */
	public EES_DMT_3108HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InvoiceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesDmt3108Event event = new EesDmt3108Event();
		
		log.debug("\n::CALL::> EES_DMT_3108HTMLAction - " + command.getCommand());
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setSheetOptionVO((SheetOptionVO)getVO(request, SheetOptionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setDemandNoteParmVO((DemandNoteParmVO)getVO(request, DemandNoteParmVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setChargeBookingInvoiceVO((ChargeBookingInvoiceVO)getVO(request, ChargeBookingInvoiceVO .class));
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