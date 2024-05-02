/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_TRS_0023HTMLAction.java
 *@FileTitle : W/O 발행화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.10.08
 *@LastModifier : 최 선
 *@LastVersion : 1.1
 * 2006.11.21 조풍연
 * 1.0 최초 생성
 *----------------------------------------------------------
 * History
 * 2010.10.08 최 선     1.1 [CHM-201006411] S/O DOOR NODE 팝업창의 RETURN VALUE 오류 수정
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderissue.event;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.event.SurchargeVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.WoIssueListVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.StringUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.utility.CheckUtilities;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.workordermanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WorkOrderIssueSC로 실행요청<br>
 * - WorkOrderIssueSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 조풍연
 * @see EsdTrs0023Event , ESD_TRS_0023EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0023HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1730451260841961863L;

	/**
	 * ESD_TRS_023HTMLAction 객체를 생성
	 */
	public ESD_TRS_0023HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_023Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		EsdTrs0023Event event = new EsdTrs0023Event();
		String prefix = "surcharge_";
		String[] scibflag = request.getParameterValues(prefix + "ibflag");

		TrsTrspSvcOrdVO[] trsTrspSvcOrdVOs = (new TrsTrspSvcOrdVO()).fromRequestGrid(request);
		WoIssueListVO[] woIssueListVOs = (new WoIssueListVO()).fromRequestGrid(request);

		event.setTrsTrspSvcOrdVOs(trsTrspSvcOrdVOs);
		event.setWoIssueListVOs(woIssueListVOs);
		event.setTrsTrspSvcOrd((TrsTrspSvcOrdVO) getVO(request, TrsTrspSvcOrdVO.class));
		String localTotAmt = request.getParameter("LOCAL_TOT_AMT");
		String localCurrCd = request.getParameter("CURR_CD");
		String formUsrOfcCd = request.getParameter("FORM_USR_OFC_CD");
		String formCreUsrId = request.getParameter("FORM_CRE_USR_ID");
		String trspSoOfcCtyCd = request.getParameter("trsp_so_ofc_cty_cd");
		String trspSoSeq = request.getParameter("trsp_so_seq");
		String vndrCd = request.getParameter("VNDR_CD");
		String spTpCd = request.getParameter("SP_TP_CD");
		String wyTpCd = request.getParameter("WY_TP_CD");
		String wtrRcvTerm = request.getParameter("WTR_RCV_TERM");
		String wtrDeTerm = request.getParameter("WTR_DE_TERM");
		String custCntCd = request.getParameter("CUST_CNT_CD");
		String custSeq = request.getParameter("CUST_SEQ");
		String basisDt = request.getParameter("BASIS_DT");

		String woRadio = request.getParameter("wo_radio");
		String dtRadio = request.getParameter("dt_radio");
		String fmdate = request.getParameter("fmdate");
		String todate = request.getParameter("todate");
		String comboSvcProvider = request.getParameter("combo_svc_provider");
		String woNo = request.getParameter("wo_no");
		String trsBndCd = request.getParameter("trs_bnd_cd");
		String trsCostMdCd = request.getParameter("trs_cost_md_cd");
		String trsMdCd = request.getParameter("trs_md_cd");
		String defalutCurr = request.getParameter("defalutCurr");
		String trsSoTpCd = request.getParameter("trs_so_tp_cd");
		String fm_yard = request.getParameter("search_fm_yard");
		String via_yard = request.getParameter("search_via_yard");
		String to_yard = request.getParameter("search_to_yard");
		String door_yard = request.getParameter("search_door_yard");
		if (fm_yard == null) {
			fm_yard = "";
		}
		if (via_yard == null) {
			via_yard = "";
		}
		if (to_yard == null) {
			to_yard = "";
		}
		if (door_yard == null) {
			door_yard = "";
		}
		String fmNod = request.getParameter("search_fm_loc") + fm_yard;
		String viaNod = request.getParameter("search_via_loc") + via_yard;
		String toNod = request.getParameter("search_to_loc") + to_yard;
		String dorNod = request.getParameter("search_door_loc") + door_yard;
		String tvvdNo = request.getParameter("tvvd_no");
		String fvvdNo = request.getParameter("fvvd_no");
		String fVvdRadio = request.getParameter("f_vvd_radio");
		String bkgNo = request.getParameter("bkg_no");
		String blNo = request.getParameter("bl_no");
		String eqRadio = request.getParameter("eq_radio");
		String eqNo = request.getParameter("eq_no");
		String soNo = request.getParameter("so_no");
		String mtyRfrnNo = request.getParameter("mty_rfrn_no");

		String woPrvGrpSeq = request.getParameter("wo_prv_grp_seq");
		String woIssNo = request.getParameter("wo_iss_no");
		String initTrspSoOfcCtyCd = request.getParameter("init_trsp_so_ofc_cty_cd");
		String initTrspSoSeq = request.getParameter("init_trsp_so_seq");

		String trsSubStsCdN = request.getParameter("trs_sub_sts_cd_n");
		String trsSubStsCd = request.getParameter("trs_sub_sts_cd");
		if (trsSubStsCd == null) {
			trsSubStsCd = "";
		}
		event.setTrsSubStsCd(trsSubStsCd);
		event.setTrsSubStsCdN(trsSubStsCdN);

		String woIssStsCd = request.getParameter("wo_iss_sts_cd");
		String dorArrDt = request.getParameter("dor_arr_dt");
		String dorArrTm = request.getParameter("dor_arr_tm");
		String dorPstCd = request.getParameter("dor_pst_cd");
		String fmLccCd = request.getParameter("fm_lcc_cd");
		String toLccCd = request.getParameter("to_lcc_cd");
		String eccCd = request.getParameter("ecc_cd");
		String inputOffice = request.getParameter("input_office");
		String copNo = request.getParameter("cop_no");
		String ruoh = request.getParameter("ruoh");
		String cgoTpCd = request.getParameter("cgo_tp_cd");
		String eqTpszCd = request.getParameter("eq_tpsz_cd");
		String cntrSltNo = request.getParameter("cntr_slt_no");
		String cnmvStsCd = request.getParameter("cnmv_sts_cd");
		String crntYdCd = request.getParameter("crnt_yd_cd");

		event.setWoIssStsCd(woIssStsCd);
		event.setDorArrDt(dorArrDt);
		event.setDorArrTm(dorArrTm);
		event.setDorPstCd(dorPstCd);
		event.setFmLccCd(fmLccCd);
		event.setToLccCd(toLccCd);
		event.setEccCd(eccCd);
		event.setInputOffice(inputOffice);
		event.setCopNo(copNo);
		event.setRuoh(ruoh);
		event.setCgoTpCd(cgoTpCd);
		event.setEqTpszCd(eqTpszCd);

		String spclCgCntrTpCd = request.getParameter("spcl_cgo_cntr_tp_cd");
		event.setSpclCgCntrTpCd(spclCgCntrTpCd);

		event.setLocalTotAmt(localTotAmt);
		event.setLocalCurrCd(localCurrCd);

		event.setWoPrvGrpSeq(woPrvGrpSeq);
		event.setWoIssNo(woIssNo);
		event.setWoPrvGrpSeq(woPrvGrpSeq);
		event.setWoIssNo(woIssNo);

		event.setFormUsrOfcCd(formUsrOfcCd);
		event.setFormCreUsrId(formCreUsrId);
		event.setTrspSoOfcCtyCd(trspSoOfcCtyCd);
		event.setTrspSoSeq(trspSoSeq);
		event.setVndrCd(vndrCd);
		event.setSpTpCd(spTpCd);
		event.setWyTpCd(wyTpCd);
		event.setWtrRcvTerm(wtrRcvTerm);
		event.setWtrDeTerm(wtrDeTerm);
		event.setCustCntCd(custCntCd);
		event.setCustSeq(custSeq);
		event.setBasisDt(basisDt);

		event.setWoRadio(woRadio);
		event.setDtRadio(dtRadio);
		event.setFmdate(fmdate);
		event.setTodate(todate);
		event.setComboSvcProvider(comboSvcProvider);
		event.setWoNo(woNo);
		event.setTrsBndCd(trsBndCd);
		event.setTrsCostMdCd(trsCostMdCd);
		event.setTrsMdCd(trsMdCd);
		event.setDefalutCurr(defalutCurr);
		event.setTrsSoTpCd(trsSoTpCd);
		event.setFmNod(fmNod);
		event.setToNod(toNod);
		event.setDorNod(dorNod);
		event.setViaNod(viaNod);
		event.setTvvdNo(tvvdNo);
		event.setFvvdNo(fvvdNo);
		event.setFVvdRadio(fVvdRadio);
		event.setBkgNo(bkgNo);
		event.setBlNo(blNo);
		event.setEqRadio(eqRadio);
		event.setEqNo(eqNo);
		event.setSoNo(soNo);
		event.setMtyRfrnNo(mtyRfrnNo);
		event.setInitTrspSoOfcCtyCd(initTrspSoOfcCtyCd);
		event.setInitTrspSoSeq(initTrspSoSeq);
		event.setTrsChgTpCd(StringUtil.xssFilter(request.getParameter("trs_chg_tp_cd")));
		event.setUserId(StringUtil.xssFilter(request.getParameter("user_id")));
		event.setCopFlg(StringUtil.xssFilter(request.getParameter("cop_flg")));
		event.setCntrSltNo(cntrSltNo);
		event.setSrcKeepFlg(CheckUtilities.isNullOrNullStringReplacement(request.getParameter("src_keep_flg"), "N"));
		event.setKeepSoNos(CheckUtilities.isNullOrNullStringReplacement(request.getParameter("keep_so_no"), ""));

		if (scibflag != null) {
			event.setSurchargeVOs(SurchargeVO.fromRequestGrid(request, prefix));
		}
		event.setCnmvStsCd(cnmvStsCd);
		event.setCrntYdCd(crntYdCd);

		HashMap param = event.getHashParam();
		Enumeration em = (Enumeration) request.getParameterNames();
		while (em.hasMoreElements()) {
			String keyName = (String) em.nextElement();
			if (keyName != null && !keyName.equals("")) {
				param.put(keyName, JSPUtil.getParameter(request, keyName, ""));
			}
		}
		event.setHashParam(param);
		request.setAttribute("Event", event);
		return event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}