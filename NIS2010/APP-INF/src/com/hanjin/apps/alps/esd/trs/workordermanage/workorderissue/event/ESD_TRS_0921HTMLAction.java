/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_921HTMLAction.java
*@FileTitle : Rail Invoice Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-10
*@LastModifier : chkong
*@LastVersion : 1.0
* 2007-01-10 chkong
* 1.0 최초 생성
* 1.7 2010.09.09 이재위 [SRM-201008617] [TRS] More candidate 조회 조건 수정 / (2) S/P select default 값 정정 요청 CSR
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.invoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ESD_TRS_921SC로 실행요청<br>
 * - ESD_TRS_921SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Kildong_hong
 * @see EsdTrs0921Event , ESD_TRS_921EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0921HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_921HTMLAction 객체를 생성
	 */
	public ESD_TRS_0921HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_921Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		EsdTrs0921Event event = new EsdTrs0921Event();

		String  trspSoOfcCtyCd = request.getParameter("trsp_so_ofc_cty_cd");
		String  trspSoSeq = request.getParameter("trsp_so_seq");
		String  ctrlOfcCd = request.getParameter("ctrl_ofc_cd");
		String  vndrSeq = request.getParameter("vndr_seq");
		String  basisDt = request.getParameter("basis_dt");
		String  wayTpCd = request.getParameter("way_tp_cd");
		String  eqKndCd = request.getParameter("eq_knd_cd");
		String  eqTpSzCd = request.getParameter("eq_tp_sz_cd");
		String  cmbTpCd = request.getParameter("cmb_tp_cd");
		String  cgoTpCd = request.getParameter("cgo_tp_cd");
		String  boundCd = request.getParameter("bound_cd");
		String  crrModCd = request.getParameter("crr_mod_cd");
		String  costmodCd = request.getParameter("cost_mod_cd");
		String  custCntCd= request.getParameter("cust_cnt_cd");
		String  custSeq = request.getParameter("cust_seq");
		String  railSvcTpCd = request.getParameter("rail_svc_tp_cd");
		String  cmdtCd = request.getParameter("cmdt_cd");
		String  fromNodCd = request.getParameter("from_nod_cd");
		String  viaNodCd = request.getParameter("via_nod_cd");
		String  doorNodCd = request.getParameter("door_nod_cd");
		String  toNodCd = request.getParameter("to_nod_cd");
		String  bundleCnt = request.getParameter("bundle_cnt");
		String  wgtUom = request.getParameter("wgt_uom");
		String  wgtQty = request.getParameter("wgt_qty");
		
		String  formUsrOfcCd = request.getParameter("form_usr_ofc_cd");
		String  mltMorOnyFlg = request.getParameter("mlt_mor_ony_flg");
		
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

		event.setFormUsrOfcCd(formUsrOfcCd);
		event.setMltMorOnyFlg(mltMorOnyFlg);
		
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