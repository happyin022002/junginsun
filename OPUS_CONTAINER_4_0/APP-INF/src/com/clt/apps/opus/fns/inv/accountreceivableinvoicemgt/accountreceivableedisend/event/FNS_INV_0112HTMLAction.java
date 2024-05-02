/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0112HTMLAction.java
*@FileTitle : EDI Submission
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.14
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.12.14 [CHM-201006644] 최도순 NIKE, Invoice EDI 신규 개발 요청
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.EDI310InputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.EDI310InvoiceVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ApplyDetailVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ApplyHeaderVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ApplyListCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptMainVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Choi Do Soon
 * @see AccountReceivableInvoiceMgtEvent 참조
 * @since J2EE 1.6
 */
 
public class FNS_INV_0112HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0112HTMLAction 객체를 생성
	 */
	public FNS_INV_0112HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0112Event event = new FnsInv0112Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setEDI310InputVO((EDI310InputVO)getVO(request, EDI310InputVO .class));
		} 
		else if(command.isCommand(FormCommand.SEARCH01)) {		
			event.setCntcTpCd(request.getParameter("cntc_tp_cd"));
			event.setScRfaNo(request.getParameter("sc_rfa_no"));
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			event.setEDI310InvoiceVOs((EDI310InvoiceVO[])getVOs(request, EDI310InvoiceVO .class, "sheet1_"));
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