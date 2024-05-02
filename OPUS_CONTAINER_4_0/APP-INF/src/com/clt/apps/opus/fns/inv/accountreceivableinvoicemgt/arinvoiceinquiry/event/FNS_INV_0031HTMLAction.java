/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0031HTMLAction.java
*@FileTitle : Invoice Inquiry by Good Date
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceInquiryInPutVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author saeil kim
 * @see AccountReceivableInvoiceMgtEvent 참조
 * @since J2EE 1.4
 */

public class FNS_INV_0031HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0031HTMLAction 객체를 생성
	 */
	public FNS_INV_0031HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0031Event event = new FnsInv0031Event();
		
		ARInvoiceInquiryInPutVO invoiceInquiryInPutVO = new ARInvoiceInquiryInPutVO();

		if(command.isCommand(FormCommand.SEARCH)) {
			// rev_tp_cd
			/*
			String arrRevTpCd[] = request.getParameterValues("rev_tp_cd");
			String revTpCd = "";
			
			if(arrRevTpCd == null) {
				arrRevTpCd = new String[1];
				arrRevTpCd[0] = request.getParameter("rev_tp_cd");
			}
			
			if(arrRevTpCd.length > 0) {
				for(int i=0; i<arrRevTpCd.length; i++) {
					if(i==0) revTpCd = revTpCd + arrRevTpCd[i];
					else revTpCd = revTpCd +","+ arrRevTpCd[i];
				}
			}
			*/
			
			invoiceInquiryInPutVO = (ARInvoiceInquiryInPutVO)getVO(request, ARInvoiceInquiryInPutVO .class);
			
			//invoiceInquiryInPutVO.setRevTpCd(revTpCd);
			
			event.setInvByGoodVO(invoiceInquiryInPutVO);
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