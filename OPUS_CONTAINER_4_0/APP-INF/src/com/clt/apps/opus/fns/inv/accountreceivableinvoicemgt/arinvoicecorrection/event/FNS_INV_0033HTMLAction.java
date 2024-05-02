/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0033HTMLAction.java
*@FileTitle : Invoice Split After Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.09.22 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArAmtVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
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
 * @author Choi Do Soon
 * @see AccountReceivableInvoiceMgtEvent 참조
 * @since J2EE 1.4
 */

public class FNS_INV_0033HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0033HTMLAction 객체를 생성
	 */
	public FNS_INV_0033HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0033Event event = new FnsInv0033Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setOfcCd(request.getParameter("ofc_cd").trim());
			event.setSplitCnt(request.getParameter("split_cnt").trim());
			event.setBkgNo(request.getParameter("frm_bkg_no").trim());
			event.setSailDt(request.getParameter("frm_sail_dt").trim());
			event.setIfNo(request.getParameter("if_no").trim());
			event.setInvNo(request.getParameter("inv_no").trim());
			event.setCancelIfNo(request.getParameter("cancel_if_no").trim());
			event.setInvCurrCd(request.getParameter("inv_curr_cd").trim());
			
			event.setInvArMnVOs((InvArMnVO[])getVOs(request, InvArMnVO .class,"s0sheet1_"));
			event.setInvArChgVOs((InvArChgVO[])getVOs(request, InvArChgVO .class,"s0sheet2_"));
			event.setInvArAmtVOs((InvArAmtVO[])getVOs(request, InvArAmtVO .class,"s0sheet3_"));
			event.setInvArCntrVOs((InvArCntrVO[])getVOs(request, InvArCntrVO .class,"s0sheet4_"));
			event.setInvArIfNoVOs((InvArIfNoVO[])getVOs(request, InvArIfNoVO .class,"s0sheet5_"));			
			
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setInvNo(request.getParameter("inv_no").trim());
			event.setOfcCd(request.getParameter("ofc_cd").trim());
			event.setSplitCnt(request.getParameter("split_cnt").trim());
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