/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_TRS_0027HTMLAction.java
*@FileTitle : Basic Cost for USA/CA Rail
*Open Issues :
*Change history :
*@LastModifyDate : 2015-08-21
*@LastModifier : SWKIM
*@LastVersion : 1.0
* 2015-08-21 SWKIM
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.invoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ESD_TRS_0027SC로 실행요청<br>
 * - ESD_TRS_0027SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Kildong_hong
 * @see EsdTrs0027Event , ESD_TRS_0027EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0027HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_0027HTMLAction 객체를 생성
	 */
	public ESD_TRS_0027HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_0027Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0027Event event = new EsdTrs0027Event();
	    if (command.isCommand(FormCommand.SEARCH)) {
			String  trspSoOfcCtyCd = request.getParameter("trsp_so_ofc_cty_cd"); //OK
			String  trspSoSeq = request.getParameter("trsp_so_seq"); //OK
			String  ctrlOfcCd = request.getParameter("ctrl_ofc_cd");
			String  vndrSeq = request.getParameter("vndr_seq"); //OK
			String  basisDt = request.getParameter("basis_dt"); //OK
			String  wayTpCd = request.getParameter("way_tp_cd");
			String  eqKndCd = request.getParameter("eq_knd_cd");
			String  eqTpSzCd = request.getParameter("eq_tp_sz_cd"); //OK
			String  cmbTpCd = request.getParameter("cmb_tp_cd");
			String  cgoTpCd = request.getParameter("cgo_tp_cd"); //OK
			String  boundCd = request.getParameter("bound_cd"); //OK
			String  crrModCd = request.getParameter("crr_mod_cd");
			String  costmodCd = request.getParameter("cost_mod_cd");
			String  custCntCd= request.getParameter("cust_cnt_cd");
			String  custSeq = request.getParameter("cust_seq");
			String  railSvcTpCd = request.getParameter("rail_svc_tp_cd");
			String  cmdtCd = request.getParameter("cmdt_cd");
			String  fromNodCd = request.getParameter("fm_nod_cd") + request.getParameter("fm_nod_yard"); //OK
			String  viaNodCd = request.getParameter("via_nod_cd");
			String  doorNodCd = request.getParameter("door_nod_cd");
			String  toNodCd = request.getParameter("to_nod_cd") + request.getParameter("to_nod_yard"); //OK
			String  bundleCnt = request.getParameter("bundle_cnt");
			String  wgtUom = request.getParameter("wgt_uom");
			String  wgtQty = request.getParameter("wgt_qty"); //OK
			String  woIssued = request.getParameter("wo_issued");
			String  fmVndrPrmrySeq = request.getParameter("fm_vndr_prmry_seq");
			String  spclCgoCntrTpCd = request.getParameter("spcl_cgo_cntr_tp_cd");
			
			String  agmtOfcCtyCd = request.getParameter("agmt_ofc_cty_cd"); //OK
			String  agmtSeq = request.getParameter("agmt_seq"); //OK
			String  currCd = request.getParameter("curr_cd"); //OK
							
			String  formUsrOfcCd = request.getParameter("form_usr_ofc_cd");
			
			event.setTrspSoOfcCtyCd(trspSoOfcCtyCd);
			event.setTrspSoSeq(trspSoSeq);
			event.setCtrlOfcCd(ctrlOfcCd);
			event.setVndrSeq(vndrSeq);
			event.setBasisDt(basisDt);
			event.setWayTpCd(wayTpCd);
			event.setEqKndCd(eqKndCd);
			event.setEqTpSzCd(eqTpSzCd);
			event.setCmbTpCd(cmbTpCd);
			event.setCgoTpCd(cgoTpCd);
			event.setBoundCd(boundCd);
			event.setCrrModCd(crrModCd);
			event.setCostmodCd(costmodCd);
			event.setCustCntCd(custCntCd);
			event.setCustSeq(custSeq);
			event.setRailSvcTpCd(railSvcTpCd);
			event.setCmdtCd(cmdtCd);
			event.setFromNodCd(fromNodCd);
			event.setViaNodCd(viaNodCd);
			event.setDoorNodCd(doorNodCd);
			event.setToNodCd(toNodCd);
			event.setBundleCnt(bundleCnt);
			event.setWgtUom(wgtUom);
			event.setWgtQty(wgtQty);
			event.setWoIssued(woIssued);
			event.setFmVndrPrmrySeq(fmVndrPrmrySeq);
			event.setSpclCgoCntrTpCd(spclCgoCntrTpCd);
			
			event.setAgmtOfcCtyCd(agmtOfcCtyCd);
			event.setAgmtSeq(agmtSeq);
			event.setCurrCd(currCd);

			event.setFormUsrOfcCd(formUsrOfcCd);
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