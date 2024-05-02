/**
 * Copyright(c) 2012 CyberLogitec
 * @FileName : FNS_INV_0125HTMLAction.java
 * @FileTitle : EDI Submission (Honey Well)
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2012.05.15
 * @LastModifier : Sang-Hyun Kim
 * @LastVersion : 1.0
 * 1.0 Creation 2012.05.15 Sang-Hyun Kim.
 */
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HNWLInvoiceEdiVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * Honey Well EDI에 대한 logic 처리
 * 
 * @author Sang-Hyun Kim
 * @see 각 DAO Class 참조.
 * @since J2EE 1.4
 */
public class FNS_INV_0125HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Creating FNS_INV_0125HTMLAction's object
	 */
	public FNS_INV_0125HTMLAction() {}

	/**
	 * Get parameters from request.
	 * 
	 * @param request
	 * @return Event
	 * @exception HTMLActionException
	 */
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		FnsInv0125Event event = new FnsInv0125Event();

		DHLInputVO inputVo = new DHLInputVO();

		String retrOpt = request.getParameter("retr_opt") != null ? request.getParameter("retr_opt") : "" ;
		String retrInput = request.getParameter("retr_input") != null ? request.getParameter("retr_input") : "";
		String blSrcNo = "";
		String invNo = "";
		String vvd = "";
		String fmDt = "";
		String toDt = "";

		if (retrOpt.equals("B")) { 
			blSrcNo = retrInput;
		} else if(retrOpt.equals("N")) { 
			invNo = retrInput;
		} else if(retrOpt.equals("V")){
			vvd = retrInput;
		} else {
			fmDt = request.getParameter("fm_dt");
			toDt = request.getParameter("to_dt");
		}

		String actCustCntCd = request.getParameter("cust_cnt_cd");
		String actCustSeq = request.getParameter("cust_seq");
		String ofcCd = request.getParameter("ofc_cd");
		String sentStat = request.getParameter("sent_stat");

		inputVo.setRetrOpt(retrOpt);
		inputVo.setActCustCntCd(actCustCntCd);
		inputVo.setActCustSeq(actCustSeq);
		inputVo.setBlSrcNo(blSrcNo);
		inputVo.setVvd(vvd);
		inputVo.setFmDt(fmDt);
		inputVo.setToDt(toDt);
		inputVo.setOfcCd(ofcCd);
		inputVo.setSentStat(sentStat);
		inputVo.setInvNo(invNo);

		event.setInputVo(inputVo);

		if (command.isCommand(FormCommand.MULTI)) { // Sending EDI for Honey Well.
			HNWLInvoiceEdiVO invoiceEdiVos[] = (HNWLInvoiceEdiVO[])getVOs(request, HNWLInvoiceEdiVO.class, "sheet1_");
			for (int i=0; i<invoiceEdiVos.length; i++) {
				invoiceEdiVos[i].setUpdUsrId(request.getParameter("upd_usr_id"));
				invoiceEdiVos[i].setOfcCd(request.getParameter("ofc_cd"));
			}
			event.setInvoiceEdiVos(invoiceEdiVos);
		}

		return event;
	}

	/**
	 * Set logic process result to request.
	 * 
	 * @param request
	 * @param eventResponse
	 */
	@Override
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * Set value objects from request.
	 * 
	 * @param request
	 * @param event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}