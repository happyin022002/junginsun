/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0034_01HTMLAction.java
*@FileTitle : AccountReceivableInvoiceMgt
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.17 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.GeneralInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CustomerListForIssueVO;
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
 * @author Jung Hwi Taek
 * @see AccountReceivableInvoiceMgtEvent 참조
 * @since J2EE 1.6
 */

public class FNS_INV_0034_01HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0034_01HTMLAction 객체를 생성
	 */
	public FNS_INV_0034_01HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv003401Event event = new FnsInv003401Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			//event.setInvArStupOfcVO((InvArStupOfcVO)getVO(request, InvArStupOfcVO .class));
			String pageType = request.getParameter("pagetype");
			String ofcCd = request.getParameter("ar_ofc_cd2");
			event.setPageType(pageType);
			event.setOfcCd(ofcCd);
		} else if(command.isCommand(FormCommand.SEARCH02)) {		
		
			event.setBackEndJobKey(request.getParameter("backendjob_key"));
		
		} else if(command.isCommand(FormCommand.SEARCH03)) {		
			
			event.setBackEndJobKey(request.getParameter("backendjob_key"));
		
		}else if(command.isCommand(FormCommand.MULTI)) {		
			log.debug("===================================MULTI");
			String sheetId = request.getParameter("custListsheetId");
			event.setGenInvVo((GeneralInvoiceVO)getVO(request, GeneralInvoiceVO .class));
			event.setCustomerListForIssueVOs((CustomerListForIssueVO[])getVOs(request, CustomerListForIssueVO.class, sheetId));
			log.debug(sheetId);
			log.debug(event.getCustomerListForIssueVOs().length);

		} else if(command.isCommand(FormCommand.MULTI02)) {		
			
			event.setGenInvVo((GeneralInvoiceVO)getVO(request, GeneralInvoiceVO .class));
			event.setCustomerListForIssueVOs((CustomerListForIssueVO[])getVOs(request, CustomerListForIssueVO.class, "sheet2_"));
		
		} else if(command.isCommand(FormCommand.SEARCH04)) {		
			
			event.setGenInvVo((GeneralInvoiceVO)getVO(request, GeneralInvoiceVO .class));
		
		} else if(command.isCommand(FormCommand.SEARCH05)) {	// Customer List Search	
			log.debug("===================================SEARCH05");
			event.setGenInvVo((GeneralInvoiceVO)getVO(request, GeneralInvoiceVO .class));
		
		} else if(command.isCommand(FormCommand.SEARCH06)) {	
			event.setBlNos(request.getParameter("chk_bl_nos"));
		
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