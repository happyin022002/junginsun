/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0094_01HTMLAction.java
*@FileTitle : Invoice Customer Change(Single)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.08.20 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import javax.servlet.http.HttpServletRequest;

//import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateInputVO;
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

public class FNS_INV_0094_01HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0094_01HTMLAction 객체를 생성
	 */
	public FNS_INV_0094_01HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv009401Event event = new FnsInv009401Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			//DueDateInputVO[] dueDateInputVO = (DueDateInputVO[]) getVOs(request,DueDateInputVO.class,"sheet2_");			
			//event.setDueDateInputVOs(dueDateInputVO);
			event.setActCustCntCd(request.getParameter("act_cust_cnt_cd").trim());
			event.setActCustSeq(request.getParameter("act_cust_seq").trim());
			event.setInvCustCntCd(request.getParameter("inv_cust_cnt_cd").trim());
			event.setInvCustSeq(request.getParameter("inv_cust_seq").trim());
			event.setArIfNo(request.getParameter("frm_ar_if_no").trim());
			event.setInvNo(request.getParameter("frm_inv_no").trim());
			event.setRevTpCd(request.getParameter("frm_rev_tp_cd").trim());
			event.setRevSrcCd(request.getParameter("frm_rev_src_cd").trim());
			event.setBkgNo(request.getParameter("frm_bkg_no").trim());
			event.setOfcCd(request.getParameter("ofc").trim());
			event.setInvCurrCd(request.getParameter("inv_curr_cd").trim());
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setOfcCd(request.getParameter("ofc").trim());
			event.setInvNo(request.getParameter("inv_no").trim());
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