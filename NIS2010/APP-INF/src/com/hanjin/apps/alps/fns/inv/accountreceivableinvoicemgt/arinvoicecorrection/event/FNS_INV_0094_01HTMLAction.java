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
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import javax.servlet.http.HttpServletRequest;

//import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateInputVO;
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
	 * HttpRequst의 정보를 AccountReceivableInvoiceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
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