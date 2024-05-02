/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0032HTMLAction.java
*@FileTitle : Transportation invoice CSR Creation - Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.26
*@LastModifier : 최 선
*@LastVersion :  1.2
* 2009.10.01 김 진
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2010.10.04 최 선     1.1 [CHM-201006130] AP Cycle 보완 요청
* 2010.12.26 최 선     1.2 [CHM-201115241] [TRS] Hold invoice 관련 메세지 추가요청
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event;

import javax.servlet.http.HttpServletRequest;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.opus.esd.tes.serviceproviderinvoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ServiceProviderInvoiceManageSC로 실행요청<br>
 * - ServiceProviderInvoiceManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author 김 진
 * @see EsdTrs0032Event , ESD_TRS_0032EventResponse 참조
 * @since J2EE 1.6
 */
public class ESD_TRS_0032HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_032HTMLAction 객체를 생성
	 */
	public ESD_TRS_0032HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_032Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		EsdTrs0032Event event 	= new EsdTrs0032Event();
		FormCommand command 	= FormCommand.fromRequest(request);
		
		String[] inv_no 		= request.getParameterValues("inv_no");
		String[] inv_vndr_seq 	= request.getParameterValues("inv_vndr_seq");
		String[] inv_amt 		= request.getParameterValues("ttl_inv_amt");
		String[] vat_amt 		= request.getParameterValues("vat_amt");
		String[] total_amt 		= request.getParameterValues("total_amt");
		
		event.setInv_no			(inv_no);
		event.setInv_vndr_seq	(inv_vndr_seq);
		event.setInv_amt		(inv_amt);
		event.setVat_amt		(vat_amt);
		event.setTotal_amt		(total_amt);

		event.setCsr_no		(JSPUtil.getParameter(request, "csr_no", ""));
		event.setInvCfmDt	(JSPUtil.getParameter(request, "cfm_dt", ""));
		event.setVndrSeq	(JSPUtil.getParameter(request, "vndr_seq", ""));		
		event.setCurrCd		(JSPUtil.getParameter(request, "curr_cd", ""));
		event.setInvOfcCd	(JSPUtil.getParameter(request, "inv_ofc_cd", ""));
		event.setCostOfcCd	(JSPUtil.getParameter(request, "cost_ofc_cd", ""));	
		event.setContiCd	(JSPUtil.getParameter(request, "conti_cd", ""));
		event.setCntCd		(JSPUtil.getParameter(request, "cnt_cd", ""));
		event.setAsaNo		(JSPUtil.getParameter(request, "asa_no", ""));
		event.setEviGb		(JSPUtil.getParameter(request, "evi_gb", ""));
		event.setPaymentType(JSPUtil.getParameter(request, "paymenttype", ""));
		event.setApOfcCd	(JSPUtil.getParameter(request, "ap_ofc_cd", ""));
		event.setUsrEml		(JSPUtil.getParameter(request, "usr_eml", ""));
		event.setUsrNm		(JSPUtil.getParameter(request, "usr_nm", ""));
		event.setCsrTpCd	(JSPUtil.getParameter(request, "csr_tp_cd", ""));
		event.setMaxIssDt	(JSPUtil.getParameter(request, "max_iss_dt", ""));
		event.setMaxRcvDt	(JSPUtil.getParameter(request, "max_rcv_dt", ""));
		event.setEviInvDt	(JSPUtil.getParameter(request, "evi_inv_dt", ""));
		event.setEviCompNo	(JSPUtil.getParameter(request, "evi_comp_no", ""));
		event.setEviTaxNo2	(JSPUtil.getParameter(request, "evi_tax_no2", ""));
		event.setEviCtnt1	(JSPUtil.getParameter(request, "evi_ctnt1", ""));
		event.setEviCtnt2	(JSPUtil.getParameter(request, "evi_ctnt2", ""));
		event.setEviCtnt3	(JSPUtil.getParameter(request, "evi_ctnt3", ""));
		event.setEviCtnt4	(JSPUtil.getParameter(request, "evi_ctnt4", ""));
		event.setEviCtnt5	(JSPUtil.getParameter(request, "evi_ctnt5", ""));
		event.setEviCtnt6	(JSPUtil.getParameter(request, "evi_ctnt6", ""));
		event.setEviCtnt7	(JSPUtil.getParameter(request, "evi_ctnt7", ""));
		event.setEviCtnt8	(JSPUtil.getParameter(request, "evi_ctnt8", ""));
		event.setEviCtnt9	(JSPUtil.getParameter(request, "evi_ctnt9", ""));
		event.setEviCtnt10	(JSPUtil.getParameter(request, "evi_ctnt10", ""));
		event.setEviCtnt11	(JSPUtil.getParameter(request, "evi_ctnt11", ""));
		event.setEviCtnt12	(JSPUtil.getParameter(request, "evi_ctnt12", ""));
		event.setEviTaxNo   (JSPUtil.getParameter(request, "evi_tax_no", ""));
		event.setEviTaxCode	(JSPUtil.getParameter(request, "evi_tax_code", ""));

		event.setAproStep	(JSPUtil.getParameter(request, "apro_step", ""));
		event.setOfcNm		(JSPUtil.getParameter(request, "ofc_nm", ""));
		event.setCntInv		(JSPUtil.getParameter(request, "cnt_inv", ""));
		event.setPaymentDueDt(JSPUtil.getParameter(request, "payment_due_dt", ""));
		
		event.setType(JSPUtil.getParameter(request, "type", ""));

		event.setPaymentDueDtView	(JSPUtil.getParameter(request, "payment_due_dt_view", ""));		
		event.setEviTotalNetAmt		(JSPUtil.getNull(JSPUtil.getParameter(request, "evi_total_net_amt", "").replaceAll(",", "")));
		event.setEviTotalTaxAmt		(JSPUtil.getNull(JSPUtil.getParameter(request, "evi_total_tax_amt", "").replaceAll(",", "")));
		
		event.setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		
		String  sTotal_amt  = (JSPUtil.getParameter(request, "total_amt", ""));
		event.setTotalAmt(sTotal_amt.replaceAll(",", ""));
		
		event.setInvNo			(JSPUtil.getParameter(request, "r_inv_no", ""));
		event.setInvVndrSeq		(JSPUtil.getParameter(request, "r_inv_vndr_seq", ""));
		
		if(command.isCommand(FormCommand.SEARCH01)){
			event.setCsrType("S");
			event.setPreviewIndicator("PREVIEW");
		}else if(command.isCommand(FormCommand.MULTI)){
			if ( Float.parseFloat(sTotal_amt) < 0 )	event.setCsrType("C");
			else event.setCsrType("S");
			
			event.setPreviewIndicator("");			
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