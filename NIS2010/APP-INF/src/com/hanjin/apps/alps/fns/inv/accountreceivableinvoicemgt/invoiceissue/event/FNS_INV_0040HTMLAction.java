/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0040HTMLAction.java
*@FileTitle : (China) Tax Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArTaxChgVO;
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

public class FNS_INV_0040HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0040HTMLAction 객체를 생성
	 */
	public FNS_INV_0040HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountReceivableInvoiceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0040Event event = new FnsInv0040Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			//event.setInvArTaxMnVOS((InvArTaxMnVO[])getVOs(request, InvArTaxMnVO .class,""));
			//event.setInvArTaxMnVOS((InvArTaxMnVO[])getVOs(request, InvArTaxMnVO .class,""));
			event.setTaxInvNo  		(request.getParameter("tax_inv_no"));
			event.setPorCd          (request.getParameter("por_cd"));			
			event.setBankAcctNo     (request.getParameter("bank_acct_no"));
			event.setCreDt          (request.getParameter(""));
			event.setTaxInvCxlFlg   (request.getParameter(""));
			event.setTaxRgstNo      (request.getParameter(""));
			event.setSailArrDt      (request.getParameter("sail_arr_dt"));
			event.setIssUsrId       (request.getParameter(""));
			event.setIssDt          (request.getParameter("iss_dt"));
			event.setPolCd          (request.getParameter("pol_cd"));
			event.setDeptNm         (request.getParameter(""));
			event.setPrnKnt         (request.getParameter("prn_knt"));
			event.setBankNm         (request.getParameter(""));
			event.setTtlLoclCurrAmt (request.getParameter("ttl_locl_curr_amt"));
			event.setActCustCntCd   (request.getParameter("act_cust_cnt_cd"));
			event.setVvdPrnFlg      (request.getParameter("vvd_prn_flg"));
			event.setLoclNmPrnFlg   (request.getParameter("locl_nm_prn_flg"));
			if(request.getParameter("locl_nm_prn_flg").equals("Y")){
				event.setCustLoclLangNm (request.getParameter("cust_locl_lang_nm"));
			}else{
				event.setCustLoclLangNm (request.getParameter("cust_lgl_eng_nm"));
			}
			event.setUpdUsrId       (request.getParameter(""));
			event.setInvXchRt       (request.getParameter("ex_rate"));
			event.setUpdDt          (request.getParameter(""));
			event.setBlSrcNo        (request.getParameter("bl_src_no"));
			event.setPortPrnFlg     (request.getParameter("port_prn_flg"));
			event.setActCustSeq     (request.getParameter("act_cust_seq"));
			event.setSailArrPrnFlg  (request.getParameter("sail_arr_prn_flg"));
			event.setDelCd          (request.getParameter("del_cd"));
			event.setTaxInvCxlRmk   (request.getParameter("tax_inv_cxl_rmk"));
			event.setCoNm           (request.getParameter(""));
			event.setTaxInvRmk      (request.getParameter(""));
			event.setIoBndCd        (request.getParameter(""));
			event.setArOfcCd        (request.getParameter("ofc_cd"));
			event.setIssCurrCd      (request.getParameter("curr_cd"));
			event.setCustLglEngNm   (request.getParameter("cust_lgl_eng_nm"));
			event.setPodCd          (request.getParameter("pod_cd"));
			event.setVvd            (request.getParameter("vvd"));
			event.setTaxInvCxlDt    (request.getParameter(""));
			event.setCreUsrId       (request.getParameter(""));
			event.setBkgNo          (request.getParameter("bkg_no"));
			event.setBizRgstNo      (request.getParameter(""));
			event.setTaxInvSeq      (request.getParameter(""));
			event.setTaxInvCxlUsrId (request.getParameter(""));
			event.setIssueGb 		(request.getParameter("issue_gb"));
			event.setTaxInvRmk 		(request.getParameter("tax_inv_rmk"));
			
			event.setInvArTaxChgVOs((InvArTaxChgVO[])getVOs(request, InvArTaxChgVO .class,""));
			
		}else if(command.isCommand(FormCommand.SEARCH)) {
			event.setTaxInvNo(request.getParameter("tax_inv_no"));
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setOfcCd(request.getParameter("ofc_cd"));
			event.setCurrCd(request.getParameter("curr_cd"));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setOfcCd(request.getParameter("ofc_cd"));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setBlNo(request.getParameter("bl_src_no"));
			event.setOfcCd(request.getParameter("ofc_cd"));
		}else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setOfcCd(request.getParameter("ofc_cd"));
			event.setCurrCd(request.getParameter("curr_cd"));
			event.setBlSrcNo(request.getParameter("bl_src_no"));
			event.setSailArrDt(request.getParameter("sail_arr_dt"));
		}else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setChgSeq(request.getParameter("chg_seq"));
			event.setOfcCd(request.getParameter("ofc_cd"));
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