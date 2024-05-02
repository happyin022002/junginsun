/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : ESD_TRS_0201HTMLAction.java
 *@FileTitle : USA Rail Billing S/O를 생성
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.02.16
 *@LastModifier : 김종호
 *@LastVersion : 1.1
 * 2006-11-23 kim_sang_geun
 * 1.0 최초 생성 
 * 1.1 2011.02.16 김종호 : ALPS 고도화 작업
=========================================================*/
package com.clt.apps.opus.esd.trs.railsomanage.railsomanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.trs.railsomanage.railsomanage.event.EsdTrs0201Event;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.TrsTrspRailBilOrdVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.railsomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RailSoManageSC로 실행요청<br>
 * - RailSoManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author kim_sang_geun
 * @see EsdTrs0201Event 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0201HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_0201HTMLAction 객체를 생성
	 */
	public ESD_TRS_0201HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_201Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0201Event event = new EsdTrs0201Event();

		// JSP PARAMETERS VALUES Getting ----------------------------------
		// irg adjust popup
		String sHidParameter = JSPUtil.getNull(request.getParameter("hid_parameter"));
		String sEmptyYn = JSPUtil.getNull(request.getParameter("empty_yn"));

		// s/o correction
		String sdateSep = JSPUtil.getNull(request.getParameter("date_sep"));
		String splanFromDate = JSPUtil.getNull(request.getParameter("hid_frmdate"));
		String splanToDate = JSPUtil.getNull(request.getParameter("hid_todate"));
		String sselStatus = JSPUtil.getNull(request.getParameter("sel_status"));
		String sselEdikind = JSPUtil.getNull(request.getParameter("sel_edikind"));
		String sselBnd = JSPUtil.getNull(request.getParameter("sel_bnd"));
		String sselThrough = JSPUtil.getNull(request.getParameter("sel_through"));
		String sselLimtinq = JSPUtil.getNull(request.getParameter("sel_limtinq"));
		String sfromLocationCd = JSPUtil.getNull(request.getParameter("frm_node")) + JSPUtil.getNull(request.getParameter("frm_yard"));
		String stoLocationCd = JSPUtil.getNull(request.getParameter("to_node")) + JSPUtil.getNull(request.getParameter("to_yard"));
		String sselUnmatch = JSPUtil.getNull(request.getParameter("sel_unmatch"));
		String strunkVvd = JSPUtil.getNull(request.getParameter("trunk_vvd"));
		String sbkgNo = JSPUtil.getNull(request.getParameter("bkg_no"));
		String sbilNo = JSPUtil.getNull(request.getParameter("bill_no"));
		String scntrNo = JSPUtil.getNull(request.getParameter("cntr_no"));
		String sctrlOfcCd = JSPUtil.getNull(request.getParameter("ctrl_ofc_cd"));
		// sctrlOfcCd = "NYCNOG".equals(sctrlOfcCd) ? "PHXSC" : sctrlOfcCd;
		String sctrlUserId = JSPUtil.getNull(request.getParameter("ctrl_user_id"));
		String radVendor = JSPUtil.getNull(request.getParameter("rad_vendor"));
		String selRailRoad = JSPUtil.getNull(request.getParameter("sel_railroad"));
		String comboSvcProvider = JSPUtil.getNull(request.getParameter("combo_svc_provider"));

		// empty s/o creation
		String selKind = JSPUtil.getNull(request.getParameter("sel_kind"));
		String cntrType = JSPUtil.getNull(request.getParameter("cntr_type"));
		String cntrSize = JSPUtil.getNull(request.getParameter("cntr_size"));
		String referNo = JSPUtil.getNull(request.getParameter("refer_no"));
		String hidRefId = JSPUtil.getNull(request.getParameter("hid_ref_id"));
		String hidFmNodCd = JSPUtil.getNull(request.getParameter("hid_fm_nod_cd"));
		String hidToNodCd = JSPUtil.getNull(request.getParameter("hid_to_nod_cd"));
		String hidEqTpszCd = JSPUtil.getNull(request.getParameter("hid_eq_tpsz_cd"));
		String hidMoreQty = JSPUtil.getNull(request.getParameter("hid_more_qty"));
		String hidCurrDt = JSPUtil.getNull(request.getParameter("hid_curr_dt"));
		String eqNoVerify = JSPUtil.getNull(request.getParameter("eq_no_verify"));
		String frmNodeVerify = JSPUtil.getNull(request.getParameter("frm_node_verify"));
		String hidCntrNo = JSPUtil.getNull(request.getParameter("hid_cntr_no"));
		String hidCntrTpszCd = JSPUtil.getNull(request.getParameter("hid_cntr_tpsz_cd"));
		String toNodVerify = JSPUtil.getNull(request.getParameter("to_nod_verify"));

		String stopOffFlg = JSPUtil.getNull(request.getParameter("stop_off_flg"));
		String ovrWgtFlg = JSPUtil.getNull(request.getParameter("ovr_wgt_flg"));
		String restFlg = JSPUtil.getNull(request.getParameter("rest_flg"));
		String bkgSpe = JSPUtil.getNull(request.getParameter("bkg_spe"));

		// s/o i/b search
		String sdelNode = JSPUtil.getNull(request.getParameter("del_node")) + JSPUtil.getNull(request.getParameter("del_yard"));
		String podNode = JSPUtil.getNull(request.getParameter("pod_node")) + JSPUtil.getNull(request.getParameter("pod_yard"));
		String scNo = JSPUtil.getNull(request.getParameter("sc_no"));
		String selCustoms = JSPUtil.getNull(request.getParameter("sel_customs"));

		// s/o o/b search
		String sporNode = JSPUtil.getNull(request.getParameter("por_node")) + JSPUtil.getNull(request.getParameter("por_yard"));
		String spolNode = JSPUtil.getNull(request.getParameter("pol_node")) + JSPUtil.getNull(request.getParameter("pol_yard"));
		String unplanned = JSPUtil.getNull(request.getParameter("unplanned"));
		String cnmvStsCd = JSPUtil.getNull(request.getParameter("cnmv_sts_cd"));
		String rvisIndFlg = JSPUtil.getNull(request.getParameter("rvis_ind_flg"));

		// Operation Call --------------------------------------------------
		if (command.isCommand(FormCommand.SEARCH04)) {
			// IRG ADJUST
			event.setHid_parameter(sHidParameter);
			event.setEmpty_yn(sEmptyYn);
		} else if (command.isCommand(FormCommand.SEARCH13)) {
			// Request Service Provider Inquiry Popup
			String f_trsp_so_ofc_cd = JSPUtil.getNull(request.getParameter("f_trsp_so_ofc_cd"));
			String f_trsp_so_seq = JSPUtil.getNull(request.getParameter("f_trsp_so_seq"));
			String f_prov_vndr_seq = JSPUtil.getNull(request.getParameter("f_prov_vndr_seq"));
			event.setFTrspSoOfcCd(f_trsp_so_ofc_cd);
			event.setFTrspSoSeq(f_trsp_so_seq);
			event.setFProvVndrSeq(f_prov_vndr_seq);
		} else if (command.isCommand(FormCommand.SEARCH15)) {
			// CANDIDATE ADJUST
			String[] seq = request.getParameterValues("seq");
			String[] bkg_rcvde_term_cd = request.getParameterValues("bkg_rcvde_term_cd");
			String[] trsp_bnd_cd = request.getParameterValues("trsp_bnd_cd");
			String[] cgo_tp_cd = request.getParameterValues("cgo_tp_cd");
			String[] key_org = request.getParameterValues("key_org");
			String[] key_dest = request.getParameterValues("key_dest");
			event.setArrSeq(seq);
			event.setArrBkgRcvdeTermCd(bkg_rcvde_term_cd);
			event.setArrTrspBndCd(trsp_bnd_cd);
			event.setArrCgoTpCd(cgo_tp_cd);
			event.setArrKeyOrg(key_org);
			event.setArrKeyDest(key_dest);
		} else if (command.isCommand(FormCommand.SEARCH03) || command.isCommand(FormCommand.REMOVE) || command.isCommand(FormCommand.MODIFY)) {
			// Rail S/O Correction
			event.setTrsTrspRailBilOrdVos((TrsTrspRailBilOrdVO[]) getVOs(request, TrsTrspRailBilOrdVO.class, ""));
			event.setSdateSep(sdateSep);
			event.setSplanFromDate(splanFromDate);
			event.setSplanToDate(splanToDate);
			event.setSselStatus(sselStatus);
			event.setSselEdikind(sselEdikind);
			event.setSselBnd(sselBnd);
			event.setSselThrough(sselThrough);
			event.setSselLimtinq(sselLimtinq);
			event.setSfromLocationCd(sfromLocationCd);
			event.setStoLocationCd(stoLocationCd);
			event.setSselUnmatch(sselUnmatch);
			event.setStrunkVvd(strunkVvd);
			event.setSbkgNo(sbkgNo);
			event.setSbilNo(sbilNo);
			event.setScntrNo(scntrNo);
			event.setSctrlOfcCd(sctrlOfcCd);
			event.setUserid(sctrlUserId);
			event.setRadVendor(radVendor);
			event.setSelRailRoad(selRailRoad);
			event.setComboSvcProvider(comboSvcProvider);
			event.setReferNo(referNo); // ESD_TRS_0204 : SEARCH CONDITION
			event.setUnplanned(unplanned);
			event.setCnmvStsCd(cnmvStsCd);
			event.setRvisIndFlg(rvisIndFlg);
		} else if (command.isCommand(FormCommand.SEARCH08) || command.isCommand(FormCommand.SEARCH11) || command.isCommand(FormCommand.MULTI02) || command.isCommand(FormCommand.SEARCH09)) {
			event.setTrsTrspRailBilOrdVos((TrsTrspRailBilOrdVO[]) getVOs(request, TrsTrspRailBilOrdVO.class, ""));
			event.setSplanFromDate(splanFromDate);
			event.setSplanToDate(splanToDate);
			event.setSfromLocationCd(sfromLocationCd);
			event.setStoLocationCd(stoLocationCd);
			event.setSelKind(selKind);
			event.setScntrNo(scntrNo);
			event.setCntrSize(cntrSize);
			event.setCntrType(cntrType);
			event.setReferNo(referNo);
			event.setSctrlOfcCd(sctrlOfcCd);
			event.setHidRefId(hidRefId);
			event.setHidFmNodCd(hidFmNodCd);
			event.setHidToNodCd(hidToNodCd);
			event.setHidEqTpszCd(hidEqTpszCd);
			event.setHidMoreQty(hidMoreQty);
			event.setHidCurrDt(hidCurrDt);
			event.setUserid(sctrlUserId);
			event.setEqNoVerify(eqNoVerify);
			event.setFrmNodeVerify(frmNodeVerify);
			event.setToNodVerify(toNodVerify);
			event.setStopOffFlg(stopOffFlg);
		} else if (command.isCommand(FormCommand.SEARCH14)) {
			event.setHidCntrNo(hidCntrNo);
			event.setHidCntrTpszCd(hidCntrTpszCd);
		} else if (command.isCommand(FormCommand.MULTI01)) {
			// Rail Billing Cancel Request Reject 959
			event.setTrsTrspRailBilOrdVos((TrsTrspRailBilOrdVO[]) getVOs(request, TrsTrspRailBilOrdVO.class, ""));
		} else if (command.isCommand(FormCommand.SEARCH02) || command.isCommand(FormCommand.SEARCH07)) {
			event.setEqNoVerify(eqNoVerify);
			event.setToNodVerify(toNodVerify);
			event.setStopOffFlg(stopOffFlg);
			event.setUnplanned(unplanned);
			event.setRvisIndFlg(rvisIndFlg);
		} else if (command.isCommand(FormCommand.MULTI)) {
			event.setTrsTrspRailBilOrdVos((TrsTrspRailBilOrdVO[]) getVOs(request, TrsTrspRailBilOrdVO.class, ""));
			event.setSctrlOfcCd(sctrlOfcCd);
			event.setUnplanned(unplanned);
			event.setRvisIndFlg(rvisIndFlg);
		} else if (command.isCommand(FormCommand.SEARCH16)) {
			event.setSbkgNo(sbkgNo);
			event.setScntrNo(scntrNo);
		} else if (command.isCommand(FormCommand.SEARCH01)) {
			event.setSplanFromDate(splanFromDate);
			event.setSplanToDate(splanToDate);
			event.setSfromLocationCd(sfromLocationCd);
			event.setStoLocationCd(stoLocationCd);
			event.setSdelNode(sdelNode);
			event.setPodNode(podNode);
			event.setStrunkVvd(strunkVvd);
			event.setSbilNo(sbilNo);
			event.setSctrlOfcCd(sctrlOfcCd);
			event.setSbkgNo(sbkgNo);
			event.setSbilNo(sbilNo);
			event.setScntrNo(scntrNo);
			event.setScNo(scNo);
			event.setSelCustoms(selCustoms);
			event.setUserid(sctrlUserId);
			event.setBkgSpe(bkgSpe);
			event.setUnplanned(unplanned);
			event.setCnmvStsCd(cnmvStsCd);
			event.setRvisIndFlg(rvisIndFlg);
		} else if (command.isCommand(FormCommand.SEARCH06)) {
			event.setSplanFromDate(splanFromDate);
			event.setSplanToDate(splanToDate);
			event.setSfromLocationCd(sfromLocationCd);
			event.setStoLocationCd(stoLocationCd);
			event.setSporNode(sporNode);
			event.setSpolNode(spolNode);
			event.setSctrlOfcCd(sctrlOfcCd);
			event.setStrunkVvd(strunkVvd);
			event.setSbkgNo(sbkgNo);
			event.setScntrNo(scntrNo);
			event.setUserid(sctrlUserId);
			event.setStopOffFlg(stopOffFlg);
			event.setOvrWgtFlg(ovrWgtFlg);
			event.setRestFlg(restFlg);
			event.setBkgSpe(bkgSpe);
			event.setUnplanned(unplanned);
			event.setCnmvStsCd(cnmvStsCd);
			event.setRvisIndFlg(rvisIndFlg);
		}
		request.setAttribute("Event", event);
		return event;
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