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
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArAmtVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.fns.inv.accountreceivableinvoicemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
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
	 * HttpRequst의 정보를 AccountReceivableInvoiceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
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