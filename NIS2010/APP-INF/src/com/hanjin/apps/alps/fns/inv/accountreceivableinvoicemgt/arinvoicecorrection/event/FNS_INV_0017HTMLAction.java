/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0017HTMLAction.java
*@FileTitle : Invoice Customer Correction by Date
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.08.11 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCustomerInputVO;
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

public class FNS_INV_0017HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0017HTMLAction 객체를 생성
	 */
	public FNS_INV_0017HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountReceivableInvoiceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0017Event event = new FnsInv0017Event();
		 
		if(command.isCommand(FormCommand.MULTI)) {
			InvArMnVO[] invArMnVO = (InvArMnVO[]) getVOs(request, InvArMnVO.class,"sheet1_");			
			event.setInvArMnVOs(invArMnVO);
			
			HashMap<String, Object> paramMap = new HashMap<String,Object>();
			paramMap.put("changed_cust_cd", request.getParameter("changed_cust_cd"));
			event.setEventParams(paramMap);
			
		}else if(command.isCommand(FormCommand.SEARCH)) {	//open
			
			ARInvoiceCustomerInputVO aRInvoiceCustomerInputVO = new ARInvoiceCustomerInputVO();
			
			aRInvoiceCustomerInputVO.setOfcCd(request.getParameter("ofc").trim());
//			aRInvoiceCustomerInputVO.setBlInvIfDt(request.getParameter("bl_inv_if_dt").trim());
			aRInvoiceCustomerInputVO.setIoBndCd(request.getParameter("io_bnd_cd").trim());
			aRInvoiceCustomerInputVO.setActCustCntCd(request.getParameter("act_cust_cnt_cd").trim());
			aRInvoiceCustomerInputVO.setActCustSeq(request.getParameter("act_cust_seq").trim());
			aRInvoiceCustomerInputVO.setPortCd(request.getParameter("port_cd").trim());			
			aRInvoiceCustomerInputVO.setFromDate(request.getParameter("from_date").trim());
			aRInvoiceCustomerInputVO.setToDate(request.getParameter("to_date").trim());
			
			event.setARInvoiceCustomerInputVO(aRInvoiceCustomerInputVO);
			
		}else if(command.isCommand(FormCommand.SEARCH01)) {	//open
			event.setOfcCd(request.getParameter("ofc").trim());
			event.setCustNm(request.getParameter("frm_cust_nm").trim());
			event.setShprCustCntCd(request.getParameter("frm_shpr_cust_cnt_cd").trim());
			event.setShprCustSeq(request.getParameter("frm_shpr_cust_seq").trim());
			event.setFwdrCustCntCd(request.getParameter("frm_fwdr_cust_cnt_cd").trim());
			event.setFwdrCustSeq(request.getParameter("frm_fwdr_cust_seq").trim());
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