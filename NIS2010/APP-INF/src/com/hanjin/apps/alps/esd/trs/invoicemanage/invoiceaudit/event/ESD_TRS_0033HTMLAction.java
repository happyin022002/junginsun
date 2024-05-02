/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_033HTMLAction.java
*@FileTitle : Service provider로부터 접수한 Invoice를 Container 단위로 Audit하고 수정하여 Confirm하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-03
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2007-01-03 poong_yeon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.event;

import javax.servlet.http.HttpServletRequest;


import com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.vo.SurchargeVO;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.vo.InvoiceAuditVO;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.vo.SearchInvoiceAuditVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.TrsTrspWrkOrdVO;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;

  
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.invoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InvoiceManageSC로 실행요청<br>
 * - InvoiceManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author poong_yeon
 * @see EsdTrs0033Event , ESD_TRS_033EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0033HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_033HTMLAction 객체를 생성
	 */
	public ESD_TRS_0033HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_033Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		String prefix = "surcharge_" ;
		String prefixOpener = "opener_" ;
		EsdTrs0033Event event = new EsdTrs0033Event();
		
		String [] scibflag = request.getParameterValues(prefix+"ibflag");
		String [] opibflag = request.getParameterValues(prefixOpener+"ibflag");
	
		SearchInvoiceAuditVO siaVo = new SearchInvoiceAuditVO();
		siaVo.fromRequest(request);
		event.setSearchInvoiceAuditVO(siaVo);
		
		
		if(command.isCommand(FormCommand.SEARCH13)){
			event.setTrspSoOfcCtyCd(JSPUtil.getNull(request.getParameter("trsp_so_ofc_cty_cd")));
			event.setTrspSoSeq(JSPUtil.getNull(request.getParameter("trsp_so_seq")));
			event.setTrspInvCalcLgcTpCd(JSPUtil.getNull(request.getParameter("trsp_inv_calc_lgc_tp_cd")));
			event.setInvXchRt(JSPUtil.getNull(request.getParameter("inv_xch_rt")));
			
	  	}else{
	  		
			event.setTrsTrspWrkOrdVOS((TrsTrspWrkOrdVO[])getVOs(request, TrsTrspWrkOrdVO.class, ""));
			event.setTrsTrspSvcOrdVOS((TrsTrspSvcOrdVO[])getVOs(request, TrsTrspSvcOrdVO.class, ""));
			event.setInvoiceAuditVOs((InvoiceAuditVO[])getVOs(request, InvoiceAuditVO.class, ""));
	
			if (scibflag != null) 
			event.setSurchargeVOs((SurchargeVO[])getVOs(request, SurchargeVO.class, prefix));
			
	
			if (opibflag != null)
			event.setOPENER_TrsTrspSvcOrdVOS((TrsTrspSvcOrdVO[])getVOs(request, TrsTrspSvcOrdVO.class, prefixOpener));
					
			//NF 추가
	
			event.setCombo_svc_provider(JSPUtil.getNull(request.getParameter("combo_svc_provider")));
			event.setPayment_vndr_cd(JSPUtil.getNull(request.getParameter("payment_vndr_cd")));
			event.setFORM_USR_OFC_CD(JSPUtil.getNull(request.getParameter("FORM_USR_OFC_CD")));
			event.setWo_vndr_cd(JSPUtil.getNull(request.getParameter("wo_vndr_cd")));
			event.setApply_currency(JSPUtil.getNull(request.getParameter("apply_currency")));
			event.setSacNo(JSPUtil.getNull(request.getParameter("inp_hsn_sac")));
			event.setPaymentVndrSeq(JSPUtil.getNull(request.getParameter("paymt_sp_cd")));
			event.setIda_ofc_cd(JSPUtil.getNull(request.getParameter("ida_ofc_cd")));
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