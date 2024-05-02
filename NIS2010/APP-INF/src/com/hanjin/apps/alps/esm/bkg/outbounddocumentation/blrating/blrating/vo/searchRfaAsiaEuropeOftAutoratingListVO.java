/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : searchRfaAsiaEuropeOftAutoratingListVO.java
*@FileTitle : searchRfaAsiaEuropeOftAutoratingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.10  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class searchRfaAsiaEuropeOftAutoratingListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<searchRfaAsiaEuropeOftAutoratingListVO> models = new ArrayList<searchRfaAsiaEuropeOftAutoratingListVO>();
	
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String oaPrcTrspModCd = null;
	/* Column Info */
	private String daAddChgSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String oaRcvDeTermCd = null;
	/* Column Info */
	private String oaPrcCgoTpCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String ovRoutViaPortDefCd = null;
	/* Column Info */
	private String oaCurrCd = null;
	/* Column Info */
	private String oihFlg = null;
	/* Column Info */
	private String daFnlFrtRtAmt = null;
	/* Column Info */
	private String bqPodApplFlg = null;
	/* Column Info */
	private String bqSeq = null;
	/* Column Info */
	private String dpPrcTrspModCd = null;
	/* Column Info */
	private String rtAppBkgConvTpCd = null;
	/* Column Info */
	private String opPrcTrspModCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String oaFnlFrtRtAmt = null;
	/* Column Info */
	private String daRatUtCd = null;
	/* Column Info */
	private String cmPrcCmdtTpCd = null;
	/* Column Info */
	private String prcRtSeq = null;
	/* Column Info */
	private String rtAppNoteConvMapgId = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String rtRasBkgConvTpCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String daPrcCgoTpCd = null;
	/* Column Info */
	private String prcCmdtHdrSeq = null;
	/* Column Info */
	private String fnlFrtRtAmt = null;
	/* Column Info */
	private String rtRasNoteConvRuleCd = null;
	/* Column Info */
	private String rtRasCurrCd = null;
	/* Column Info */
	private String rtAppNoteConvSeq = null;
	/* Column Info */
	private String rtRasNoteConvTpCd = null;
	/* Column Info */
	private String rtPrcCgoTpCd = null;
	/* Column Info */
	private String oaAddChgSeq = null;
	/* Column Info */
	private String note = null;
	/* Column Info */
	private String bqDelApplFlg = null;
	/* Column Info */
	private String daRcvDeTermCd = null;
	/* Column Info */
	private String bqPorRlyPortApplFlg = null;
	/* Column Info */
	private String daRoutPntLocDefCd = null;
	/* Column Info */
	private String rtCurrCd = null;
	/* Column Info */
	private String oaBsePortDefCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String cmPrcCmdtDefCd = null;
	/* Column Info */
	private String dryCgoFlg = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String bqPorApplFlg = null;
	/* Column Info */
	private String orgTrspModCd = null;
	/* Column Info */
	private String porMtchFlg = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String dtl = null;
	/* Column Info */
	private String bqPolApplFlg = null;
	/* Column Info */
	private String cgoCateCd = null;
	/* Column Info */
	private String destTrspModCd = null;
	/* Column Info */
	private String rtRasRtOpCd = null;
	/* Column Info */
	private String rtMtchPattCd = null;
	/* Column Info */
	private String daCurrCd = null;
	/* Column Info */
	private String rtAppNoteConvRuleCd = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String prcRtMtchPattCd = null;
	/* Column Info */
	private String bqPstRlyPortApplFlg = null;
	/* Column Info */
	private String dpRoutPntLocDefCd = null;
	/* Column Info */
	private String daPrcTrspModCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String dihFlg = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String rtAppCurrCd = null;
	/* Column Info */
	private String rtRasNoteConvSeq = null;
	/* Column Info */
	private String oaRoutPntLocDefCd = null;
	/* Column Info */
	private String noteCtnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oaRatUtCd = null;
	/* Column Info */
	private String rtFnlFrtRtAmt = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String dvRoutViaPortDefCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String rtRasFrtRtAmt = null;
	/* Column Info */
	private String rtRasNoteConvMapgId = null;
	/* Column Info */
	private String daBsePortDefCd = null;
	/* Column Info */
	private String ctrtCntrTpszCd = null;
	/* Column Info */
	private String prcRoutSeq = null;
	/* Column Info */
	private String rtAppNoteConvTpCd = null;
	/* Column Info */
	private String delMtchFlg = null;
	/* Column Info */
	private String opRoutPntLocDefCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String trnsModCd = null;
	/* Column Info */
	private String bkgBqSeq = null;
	/* Column Info */
	private String rtRatUtCd = null;
	/* Column Info */
	private String rtAppFrtRtAmt = null;
	/* Column Info */
	private String rtAppRtOpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public searchRfaAsiaEuropeOftAutoratingListVO() {}

	public searchRfaAsiaEuropeOftAutoratingListVO(String ibflag, String pagerows, String ctrtNo, String prcRtMtchPattCd, String propNo, String amdtSeq, String svcScpCd, String bqSeq, String bkgBqSeq, String cntrTpszCd, String ctrtCntrTpszCd, String rcvTermCd, String deTermCd, String dryCgoFlg, String awkCgoFlg, String dcgoFlg, String rcFlg, String bbCgoFlg, String socFlg, String imdgClssCd, String prcCmdtHdrSeq, String prcRoutSeq, String prcRtSeq, String rtMtchPattCd, String cmdtNm, String porCd, String polCd, String podCd, String delCd, String rcvDeTermCd, String ratUtCd, String prcCgoTpCd, String currCd, String orgTrspModCd, String destTrspModCd, String fnlFrtRtAmt, String trnsModCd, String opCntrQty, String noteCtnt, String note, String dtl, String cgoCateCd, String bqPorApplFlg, String bqPolApplFlg, String bqPodApplFlg, String bqDelApplFlg, String bqPorRlyPortApplFlg, String bqPstRlyPortApplFlg, String oaAddChgSeq, String daAddChgSeq, String cmPrcCmdtTpCd, String cmPrcCmdtDefCd, String opRoutPntLocDefCd, String ovRoutViaPortDefCd, String dvRoutViaPortDefCd, String dpRoutPntLocDefCd, String opPrcTrspModCd, String dpPrcTrspModCd, String rtRatUtCd, String rtPrcCgoTpCd, String rtCurrCd, String rtFnlFrtRtAmt, String oaRoutPntLocDefCd, String oaBsePortDefCd, String oaRatUtCd, String oaPrcCgoTpCd, String oaPrcTrspModCd, String oaRcvDeTermCd, String oaCurrCd, String oaFnlFrtRtAmt, String daRoutPntLocDefCd, String daBsePortDefCd, String daRatUtCd, String daPrcCgoTpCd, String daPrcTrspModCd, String daRcvDeTermCd, String daCurrCd, String daFnlFrtRtAmt, String rtAppBkgConvTpCd, String rtAppNoteConvMapgId, String rtAppNoteConvSeq, String rtAppNoteConvRuleCd, String rtAppNoteConvTpCd, String rtAppRtOpCd, String rtAppCurrCd, String rtAppFrtRtAmt, String rtRasBkgConvTpCd, String rtRasNoteConvMapgId, String rtRasNoteConvSeq, String rtRasNoteConvRuleCd, String rtRasNoteConvTpCd, String rtRasRtOpCd, String rtRasCurrCd, String rtRasFrtRtAmt, String porMtchFlg, String delMtchFlg, String oihFlg, String dihFlg) {
		this.svcScpCd = svcScpCd;
		this.oaPrcTrspModCd = oaPrcTrspModCd;
		this.daAddChgSeq = daAddChgSeq;
		this.pagerows = pagerows;
		this.oaRcvDeTermCd = oaRcvDeTermCd;
		this.oaPrcCgoTpCd = oaPrcCgoTpCd;
		this.cntrTpszCd = cntrTpszCd;
		this.rcvDeTermCd = rcvDeTermCd;
		this.ovRoutViaPortDefCd = ovRoutViaPortDefCd;
		this.oaCurrCd = oaCurrCd;
		this.oihFlg = oihFlg;
		this.daFnlFrtRtAmt = daFnlFrtRtAmt;
		this.bqPodApplFlg = bqPodApplFlg;
		this.bqSeq = bqSeq;
		this.dpPrcTrspModCd = dpPrcTrspModCd;
		this.rtAppBkgConvTpCd = rtAppBkgConvTpCd;
		this.opPrcTrspModCd = opPrcTrspModCd;
		this.ratUtCd = ratUtCd;
		this.podCd = podCd;
		this.oaFnlFrtRtAmt = oaFnlFrtRtAmt;
		this.daRatUtCd = daRatUtCd;
		this.cmPrcCmdtTpCd = cmPrcCmdtTpCd;
		this.prcRtSeq = prcRtSeq;
		this.rtAppNoteConvMapgId = rtAppNoteConvMapgId;
		this.opCntrQty = opCntrQty;
		this.rcFlg = rcFlg;
		this.imdgClssCd = imdgClssCd;
		this.rtRasBkgConvTpCd = rtRasBkgConvTpCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.daPrcCgoTpCd = daPrcCgoTpCd;
		this.prcCmdtHdrSeq = prcCmdtHdrSeq;
		this.fnlFrtRtAmt = fnlFrtRtAmt;
		this.rtRasNoteConvRuleCd = rtRasNoteConvRuleCd;
		this.rtRasCurrCd = rtRasCurrCd;
		this.rtAppNoteConvSeq = rtAppNoteConvSeq;
		this.rtRasNoteConvTpCd = rtRasNoteConvTpCd;
		this.rtPrcCgoTpCd = rtPrcCgoTpCd;
		this.oaAddChgSeq = oaAddChgSeq;
		this.note = note;
		this.bqDelApplFlg = bqDelApplFlg;
		this.daRcvDeTermCd = daRcvDeTermCd;
		this.bqPorRlyPortApplFlg = bqPorRlyPortApplFlg;
		this.daRoutPntLocDefCd = daRoutPntLocDefCd;
		this.rtCurrCd = rtCurrCd;
		this.oaBsePortDefCd = oaBsePortDefCd;
		this.propNo = propNo;
		this.cmPrcCmdtDefCd = cmPrcCmdtDefCd;
		this.dryCgoFlg = dryCgoFlg;
		this.amdtSeq = amdtSeq;
		this.bqPorApplFlg = bqPorApplFlg;
		this.orgTrspModCd = orgTrspModCd;
		this.porMtchFlg = porMtchFlg;
		this.ctrtNo = ctrtNo;
		this.polCd = polCd;
		this.dtl = dtl;
		this.bqPolApplFlg = bqPolApplFlg;
		this.cgoCateCd = cgoCateCd;
		this.destTrspModCd = destTrspModCd;
		this.rtRasRtOpCd = rtRasRtOpCd;
		this.rtMtchPattCd = rtMtchPattCd;
		this.daCurrCd = daCurrCd;
		this.rtAppNoteConvRuleCd = rtAppNoteConvRuleCd;
		this.awkCgoFlg = awkCgoFlg;
		this.delCd = delCd;
		this.prcRtMtchPattCd = prcRtMtchPattCd;
		this.bqPstRlyPortApplFlg = bqPstRlyPortApplFlg;
		this.dpRoutPntLocDefCd = dpRoutPntLocDefCd;
		this.daPrcTrspModCd = daPrcTrspModCd;
		this.porCd = porCd;
		this.dihFlg = dihFlg;
		this.currCd = currCd;
		this.rtAppCurrCd = rtAppCurrCd;
		this.rtRasNoteConvSeq = rtRasNoteConvSeq;
		this.oaRoutPntLocDefCd = oaRoutPntLocDefCd;
		this.noteCtnt = noteCtnt;
		this.ibflag = ibflag;
		this.oaRatUtCd = oaRatUtCd;
		this.rtFnlFrtRtAmt = rtFnlFrtRtAmt;
		this.bbCgoFlg = bbCgoFlg;
		this.dvRoutViaPortDefCd = dvRoutViaPortDefCd;
		this.dcgoFlg = dcgoFlg;
		this.rcvTermCd = rcvTermCd;
		this.rtRasFrtRtAmt = rtRasFrtRtAmt;
		this.rtRasNoteConvMapgId = rtRasNoteConvMapgId;
		this.daBsePortDefCd = daBsePortDefCd;
		this.ctrtCntrTpszCd = ctrtCntrTpszCd;
		this.prcRoutSeq = prcRoutSeq;
		this.rtAppNoteConvTpCd = rtAppNoteConvTpCd;
		this.delMtchFlg = delMtchFlg;
		this.opRoutPntLocDefCd = opRoutPntLocDefCd;
		this.cmdtNm = cmdtNm;
		this.socFlg = socFlg;
		this.deTermCd = deTermCd;
		this.trnsModCd = trnsModCd;
		this.bkgBqSeq = bkgBqSeq;
		this.rtRatUtCd = rtRatUtCd;
		this.rtAppFrtRtAmt = rtAppFrtRtAmt;
		this.rtAppRtOpCd = rtAppRtOpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("oa_prc_trsp_mod_cd", getOaPrcTrspModCd());
		this.hashColumns.put("da_add_chg_seq", getDaAddChgSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("oa_rcv_de_term_cd", getOaRcvDeTermCd());
		this.hashColumns.put("oa_prc_cgo_tp_cd", getOaPrcCgoTpCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("ov_rout_via_port_def_cd", getOvRoutViaPortDefCd());
		this.hashColumns.put("oa_curr_cd", getOaCurrCd());
		this.hashColumns.put("oih_flg", getOihFlg());
		this.hashColumns.put("da_fnl_frt_rt_amt", getDaFnlFrtRtAmt());
		this.hashColumns.put("bq_pod_appl_flg", getBqPodApplFlg());
		this.hashColumns.put("bq_seq", getBqSeq());
		this.hashColumns.put("dp_prc_trsp_mod_cd", getDpPrcTrspModCd());
		this.hashColumns.put("rt_app_bkg_conv_tp_cd", getRtAppBkgConvTpCd());
		this.hashColumns.put("op_prc_trsp_mod_cd", getOpPrcTrspModCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("oa_fnl_frt_rt_amt", getOaFnlFrtRtAmt());
		this.hashColumns.put("da_rat_ut_cd", getDaRatUtCd());
		this.hashColumns.put("cm_prc_cmdt_tp_cd", getCmPrcCmdtTpCd());
		this.hashColumns.put("prc_rt_seq", getPrcRtSeq());
		this.hashColumns.put("rt_app_note_conv_mapg_id", getRtAppNoteConvMapgId());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("rt_ras_bkg_conv_tp_cd", getRtRasBkgConvTpCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("da_prc_cgo_tp_cd", getDaPrcCgoTpCd());
		this.hashColumns.put("prc_cmdt_hdr_seq", getPrcCmdtHdrSeq());
		this.hashColumns.put("fnl_frt_rt_amt", getFnlFrtRtAmt());
		this.hashColumns.put("rt_ras_note_conv_rule_cd", getRtRasNoteConvRuleCd());
		this.hashColumns.put("rt_ras_curr_cd", getRtRasCurrCd());
		this.hashColumns.put("rt_app_note_conv_seq", getRtAppNoteConvSeq());
		this.hashColumns.put("rt_ras_note_conv_tp_cd", getRtRasNoteConvTpCd());
		this.hashColumns.put("rt_prc_cgo_tp_cd", getRtPrcCgoTpCd());
		this.hashColumns.put("oa_add_chg_seq", getOaAddChgSeq());
		this.hashColumns.put("note", getNote());
		this.hashColumns.put("bq_del_appl_flg", getBqDelApplFlg());
		this.hashColumns.put("da_rcv_de_term_cd", getDaRcvDeTermCd());
		this.hashColumns.put("bq_por_rly_port_appl_flg", getBqPorRlyPortApplFlg());
		this.hashColumns.put("da_rout_pnt_loc_def_cd", getDaRoutPntLocDefCd());
		this.hashColumns.put("rt_curr_cd", getRtCurrCd());
		this.hashColumns.put("oa_bse_port_def_cd", getOaBsePortDefCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("cm_prc_cmdt_def_cd", getCmPrcCmdtDefCd());
		this.hashColumns.put("dry_cgo_flg", getDryCgoFlg());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("bq_por_appl_flg", getBqPorApplFlg());
		this.hashColumns.put("org_trsp_mod_cd", getOrgTrspModCd());
		this.hashColumns.put("por_mtch_flg", getPorMtchFlg());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("dtl", getDtl());
		this.hashColumns.put("bq_pol_appl_flg", getBqPolApplFlg());
		this.hashColumns.put("cgo_cate_cd", getCgoCateCd());
		this.hashColumns.put("dest_trsp_mod_cd", getDestTrspModCd());
		this.hashColumns.put("rt_ras_rt_op_cd", getRtRasRtOpCd());
		this.hashColumns.put("rt_mtch_patt_cd", getRtMtchPattCd());
		this.hashColumns.put("da_curr_cd", getDaCurrCd());
		this.hashColumns.put("rt_app_note_conv_rule_cd", getRtAppNoteConvRuleCd());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("prc_rt_mtch_patt_cd", getPrcRtMtchPattCd());
		this.hashColumns.put("bq_pst_rly_port_appl_flg", getBqPstRlyPortApplFlg());
		this.hashColumns.put("dp_rout_pnt_loc_def_cd", getDpRoutPntLocDefCd());
		this.hashColumns.put("da_prc_trsp_mod_cd", getDaPrcTrspModCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("dih_flg", getDihFlg());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("rt_app_curr_cd", getRtAppCurrCd());
		this.hashColumns.put("rt_ras_note_conv_seq", getRtRasNoteConvSeq());
		this.hashColumns.put("oa_rout_pnt_loc_def_cd", getOaRoutPntLocDefCd());
		this.hashColumns.put("note_ctnt", getNoteCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("oa_rat_ut_cd", getOaRatUtCd());
		this.hashColumns.put("rt_fnl_frt_rt_amt", getRtFnlFrtRtAmt());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("dv_rout_via_port_def_cd", getDvRoutViaPortDefCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("rt_ras_frt_rt_amt", getRtRasFrtRtAmt());
		this.hashColumns.put("rt_ras_note_conv_mapg_id", getRtRasNoteConvMapgId());
		this.hashColumns.put("da_bse_port_def_cd", getDaBsePortDefCd());
		this.hashColumns.put("ctrt_cntr_tpsz_cd", getCtrtCntrTpszCd());
		this.hashColumns.put("prc_rout_seq", getPrcRoutSeq());
		this.hashColumns.put("rt_app_note_conv_tp_cd", getRtAppNoteConvTpCd());
		this.hashColumns.put("del_mtch_flg", getDelMtchFlg());
		this.hashColumns.put("op_rout_pnt_loc_def_cd", getOpRoutPntLocDefCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("trns_mod_cd", getTrnsModCd());
		this.hashColumns.put("bkg_bq_seq", getBkgBqSeq());
		this.hashColumns.put("rt_rat_ut_cd", getRtRatUtCd());
		this.hashColumns.put("rt_app_frt_rt_amt", getRtAppFrtRtAmt());
		this.hashColumns.put("rt_app_rt_op_cd", getRtAppRtOpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("oa_prc_trsp_mod_cd", "oaPrcTrspModCd");
		this.hashFields.put("da_add_chg_seq", "daAddChgSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("oa_rcv_de_term_cd", "oaRcvDeTermCd");
		this.hashFields.put("oa_prc_cgo_tp_cd", "oaPrcCgoTpCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("ov_rout_via_port_def_cd", "ovRoutViaPortDefCd");
		this.hashFields.put("oa_curr_cd", "oaCurrCd");
		this.hashFields.put("oih_flg", "oihFlg");
		this.hashFields.put("da_fnl_frt_rt_amt", "daFnlFrtRtAmt");
		this.hashFields.put("bq_pod_appl_flg", "bqPodApplFlg");
		this.hashFields.put("bq_seq", "bqSeq");
		this.hashFields.put("dp_prc_trsp_mod_cd", "dpPrcTrspModCd");
		this.hashFields.put("rt_app_bkg_conv_tp_cd", "rtAppBkgConvTpCd");
		this.hashFields.put("op_prc_trsp_mod_cd", "opPrcTrspModCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("oa_fnl_frt_rt_amt", "oaFnlFrtRtAmt");
		this.hashFields.put("da_rat_ut_cd", "daRatUtCd");
		this.hashFields.put("cm_prc_cmdt_tp_cd", "cmPrcCmdtTpCd");
		this.hashFields.put("prc_rt_seq", "prcRtSeq");
		this.hashFields.put("rt_app_note_conv_mapg_id", "rtAppNoteConvMapgId");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("rt_ras_bkg_conv_tp_cd", "rtRasBkgConvTpCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("da_prc_cgo_tp_cd", "daPrcCgoTpCd");
		this.hashFields.put("prc_cmdt_hdr_seq", "prcCmdtHdrSeq");
		this.hashFields.put("fnl_frt_rt_amt", "fnlFrtRtAmt");
		this.hashFields.put("rt_ras_note_conv_rule_cd", "rtRasNoteConvRuleCd");
		this.hashFields.put("rt_ras_curr_cd", "rtRasCurrCd");
		this.hashFields.put("rt_app_note_conv_seq", "rtAppNoteConvSeq");
		this.hashFields.put("rt_ras_note_conv_tp_cd", "rtRasNoteConvTpCd");
		this.hashFields.put("rt_prc_cgo_tp_cd", "rtPrcCgoTpCd");
		this.hashFields.put("oa_add_chg_seq", "oaAddChgSeq");
		this.hashFields.put("note", "note");
		this.hashFields.put("bq_del_appl_flg", "bqDelApplFlg");
		this.hashFields.put("da_rcv_de_term_cd", "daRcvDeTermCd");
		this.hashFields.put("bq_por_rly_port_appl_flg", "bqPorRlyPortApplFlg");
		this.hashFields.put("da_rout_pnt_loc_def_cd", "daRoutPntLocDefCd");
		this.hashFields.put("rt_curr_cd", "rtCurrCd");
		this.hashFields.put("oa_bse_port_def_cd", "oaBsePortDefCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("cm_prc_cmdt_def_cd", "cmPrcCmdtDefCd");
		this.hashFields.put("dry_cgo_flg", "dryCgoFlg");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("bq_por_appl_flg", "bqPorApplFlg");
		this.hashFields.put("org_trsp_mod_cd", "orgTrspModCd");
		this.hashFields.put("por_mtch_flg", "porMtchFlg");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("dtl", "dtl");
		this.hashFields.put("bq_pol_appl_flg", "bqPolApplFlg");
		this.hashFields.put("cgo_cate_cd", "cgoCateCd");
		this.hashFields.put("dest_trsp_mod_cd", "destTrspModCd");
		this.hashFields.put("rt_ras_rt_op_cd", "rtRasRtOpCd");
		this.hashFields.put("rt_mtch_patt_cd", "rtMtchPattCd");
		this.hashFields.put("da_curr_cd", "daCurrCd");
		this.hashFields.put("rt_app_note_conv_rule_cd", "rtAppNoteConvRuleCd");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("prc_rt_mtch_patt_cd", "prcRtMtchPattCd");
		this.hashFields.put("bq_pst_rly_port_appl_flg", "bqPstRlyPortApplFlg");
		this.hashFields.put("dp_rout_pnt_loc_def_cd", "dpRoutPntLocDefCd");
		this.hashFields.put("da_prc_trsp_mod_cd", "daPrcTrspModCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("dih_flg", "dihFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("rt_app_curr_cd", "rtAppCurrCd");
		this.hashFields.put("rt_ras_note_conv_seq", "rtRasNoteConvSeq");
		this.hashFields.put("oa_rout_pnt_loc_def_cd", "oaRoutPntLocDefCd");
		this.hashFields.put("note_ctnt", "noteCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("oa_rat_ut_cd", "oaRatUtCd");
		this.hashFields.put("rt_fnl_frt_rt_amt", "rtFnlFrtRtAmt");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("dv_rout_via_port_def_cd", "dvRoutViaPortDefCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("rt_ras_frt_rt_amt", "rtRasFrtRtAmt");
		this.hashFields.put("rt_ras_note_conv_mapg_id", "rtRasNoteConvMapgId");
		this.hashFields.put("da_bse_port_def_cd", "daBsePortDefCd");
		this.hashFields.put("ctrt_cntr_tpsz_cd", "ctrtCntrTpszCd");
		this.hashFields.put("prc_rout_seq", "prcRoutSeq");
		this.hashFields.put("rt_app_note_conv_tp_cd", "rtAppNoteConvTpCd");
		this.hashFields.put("del_mtch_flg", "delMtchFlg");
		this.hashFields.put("op_rout_pnt_loc_def_cd", "opRoutPntLocDefCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("trns_mod_cd", "trnsModCd");
		this.hashFields.put("bkg_bq_seq", "bkgBqSeq");
		this.hashFields.put("rt_rat_ut_cd", "rtRatUtCd");
		this.hashFields.put("rt_app_frt_rt_amt", "rtAppFrtRtAmt");
		this.hashFields.put("rt_app_rt_op_cd", "rtAppRtOpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return oaPrcTrspModCd
	 */
	public String getOaPrcTrspModCd() {
		return this.oaPrcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return daAddChgSeq
	 */
	public String getDaAddChgSeq() {
		return this.daAddChgSeq;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return oaRcvDeTermCd
	 */
	public String getOaRcvDeTermCd() {
		return this.oaRcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return oaPrcCgoTpCd
	 */
	public String getOaPrcCgoTpCd() {
		return this.oaPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return ovRoutViaPortDefCd
	 */
	public String getOvRoutViaPortDefCd() {
		return this.ovRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return oaCurrCd
	 */
	public String getOaCurrCd() {
		return this.oaCurrCd;
	}
	
	/**
	 * Column Info
	 * @return oihFlg
	 */
	public String getOihFlg() {
		return this.oihFlg;
	}
	
	/**
	 * Column Info
	 * @return daFnlFrtRtAmt
	 */
	public String getDaFnlFrtRtAmt() {
		return this.daFnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return bqPodApplFlg
	 */
	public String getBqPodApplFlg() {
		return this.bqPodApplFlg;
	}
	
	/**
	 * Column Info
	 * @return bqSeq
	 */
	public String getBqSeq() {
		return this.bqSeq;
	}
	
	/**
	 * Column Info
	 * @return dpPrcTrspModCd
	 */
	public String getDpPrcTrspModCd() {
		return this.dpPrcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return rtAppBkgConvTpCd
	 */
	public String getRtAppBkgConvTpCd() {
		return this.rtAppBkgConvTpCd;
	}
	
	/**
	 * Column Info
	 * @return opPrcTrspModCd
	 */
	public String getOpPrcTrspModCd() {
		return this.opPrcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return oaFnlFrtRtAmt
	 */
	public String getOaFnlFrtRtAmt() {
		return this.oaFnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return daRatUtCd
	 */
	public String getDaRatUtCd() {
		return this.daRatUtCd;
	}
	
	/**
	 * Column Info
	 * @return cmPrcCmdtTpCd
	 */
	public String getCmPrcCmdtTpCd() {
		return this.cmPrcCmdtTpCd;
	}
	
	/**
	 * Column Info
	 * @return prcRtSeq
	 */
	public String getPrcRtSeq() {
		return this.prcRtSeq;
	}
	
	/**
	 * Column Info
	 * @return rtAppNoteConvMapgId
	 */
	public String getRtAppNoteConvMapgId() {
		return this.rtAppNoteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @return opCntrQty
	 */
	public String getOpCntrQty() {
		return this.opCntrQty;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return rtRasBkgConvTpCd
	 */
	public String getRtRasBkgConvTpCd() {
		return this.rtRasBkgConvTpCd;
	}
	
	/**
	 * Column Info
	 * @return prcCgoTpCd
	 */
	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return daPrcCgoTpCd
	 */
	public String getDaPrcCgoTpCd() {
		return this.daPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return prcCmdtHdrSeq
	 */
	public String getPrcCmdtHdrSeq() {
		return this.prcCmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return fnlFrtRtAmt
	 */
	public String getFnlFrtRtAmt() {
		return this.fnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return rtRasNoteConvRuleCd
	 */
	public String getRtRasNoteConvRuleCd() {
		return this.rtRasNoteConvRuleCd;
	}
	
	/**
	 * Column Info
	 * @return rtRasCurrCd
	 */
	public String getRtRasCurrCd() {
		return this.rtRasCurrCd;
	}
	
	/**
	 * Column Info
	 * @return rtAppNoteConvSeq
	 */
	public String getRtAppNoteConvSeq() {
		return this.rtAppNoteConvSeq;
	}
	
	/**
	 * Column Info
	 * @return rtRasNoteConvTpCd
	 */
	public String getRtRasNoteConvTpCd() {
		return this.rtRasNoteConvTpCd;
	}
	
	/**
	 * Column Info
	 * @return rtPrcCgoTpCd
	 */
	public String getRtPrcCgoTpCd() {
		return this.rtPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return oaAddChgSeq
	 */
	public String getOaAddChgSeq() {
		return this.oaAddChgSeq;
	}
	
	/**
	 * Column Info
	 * @return note
	 */
	public String getNote() {
		return this.note;
	}
	
	/**
	 * Column Info
	 * @return bqDelApplFlg
	 */
	public String getBqDelApplFlg() {
		return this.bqDelApplFlg;
	}
	
	/**
	 * Column Info
	 * @return daRcvDeTermCd
	 */
	public String getDaRcvDeTermCd() {
		return this.daRcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return bqPorRlyPortApplFlg
	 */
	public String getBqPorRlyPortApplFlg() {
		return this.bqPorRlyPortApplFlg;
	}
	
	/**
	 * Column Info
	 * @return daRoutPntLocDefCd
	 */
	public String getDaRoutPntLocDefCd() {
		return this.daRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return rtCurrCd
	 */
	public String getRtCurrCd() {
		return this.rtCurrCd;
	}
	
	/**
	 * Column Info
	 * @return oaBsePortDefCd
	 */
	public String getOaBsePortDefCd() {
		return this.oaBsePortDefCd;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return cmPrcCmdtDefCd
	 */
	public String getCmPrcCmdtDefCd() {
		return this.cmPrcCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @return dryCgoFlg
	 */
	public String getDryCgoFlg() {
		return this.dryCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return bqPorApplFlg
	 */
	public String getBqPorApplFlg() {
		return this.bqPorApplFlg;
	}
	
	/**
	 * Column Info
	 * @return orgTrspModCd
	 */
	public String getOrgTrspModCd() {
		return this.orgTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return porMtchFlg
	 */
	public String getPorMtchFlg() {
		return this.porMtchFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return dtl
	 */
	public String getDtl() {
		return this.dtl;
	}
	
	/**
	 * Column Info
	 * @return bqPolApplFlg
	 */
	public String getBqPolApplFlg() {
		return this.bqPolApplFlg;
	}
	
	/**
	 * Column Info
	 * @return cgoCateCd
	 */
	public String getCgoCateCd() {
		return this.cgoCateCd;
	}
	
	/**
	 * Column Info
	 * @return destTrspModCd
	 */
	public String getDestTrspModCd() {
		return this.destTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return rtRasRtOpCd
	 */
	public String getRtRasRtOpCd() {
		return this.rtRasRtOpCd;
	}
	
	/**
	 * Column Info
	 * @return rtMtchPattCd
	 */
	public String getRtMtchPattCd() {
		return this.rtMtchPattCd;
	}
	
	/**
	 * Column Info
	 * @return daCurrCd
	 */
	public String getDaCurrCd() {
		return this.daCurrCd;
	}
	
	/**
	 * Column Info
	 * @return rtAppNoteConvRuleCd
	 */
	public String getRtAppNoteConvRuleCd() {
		return this.rtAppNoteConvRuleCd;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return prcRtMtchPattCd
	 */
	public String getPrcRtMtchPattCd() {
		return this.prcRtMtchPattCd;
	}
	
	/**
	 * Column Info
	 * @return bqPstRlyPortApplFlg
	 */
	public String getBqPstRlyPortApplFlg() {
		return this.bqPstRlyPortApplFlg;
	}
	
	/**
	 * Column Info
	 * @return dpRoutPntLocDefCd
	 */
	public String getDpRoutPntLocDefCd() {
		return this.dpRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return daPrcTrspModCd
	 */
	public String getDaPrcTrspModCd() {
		return this.daPrcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return dihFlg
	 */
	public String getDihFlg() {
		return this.dihFlg;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return rtAppCurrCd
	 */
	public String getRtAppCurrCd() {
		return this.rtAppCurrCd;
	}
	
	/**
	 * Column Info
	 * @return rtRasNoteConvSeq
	 */
	public String getRtRasNoteConvSeq() {
		return this.rtRasNoteConvSeq;
	}
	
	/**
	 * Column Info
	 * @return oaRoutPntLocDefCd
	 */
	public String getOaRoutPntLocDefCd() {
		return this.oaRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return noteCtnt
	 */
	public String getNoteCtnt() {
		return this.noteCtnt;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return oaRatUtCd
	 */
	public String getOaRatUtCd() {
		return this.oaRatUtCd;
	}
	
	/**
	 * Column Info
	 * @return rtFnlFrtRtAmt
	 */
	public String getRtFnlFrtRtAmt() {
		return this.rtFnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return dvRoutViaPortDefCd
	 */
	public String getDvRoutViaPortDefCd() {
		return this.dvRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return rtRasFrtRtAmt
	 */
	public String getRtRasFrtRtAmt() {
		return this.rtRasFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return rtRasNoteConvMapgId
	 */
	public String getRtRasNoteConvMapgId() {
		return this.rtRasNoteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @return daBsePortDefCd
	 */
	public String getDaBsePortDefCd() {
		return this.daBsePortDefCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtCntrTpszCd
	 */
	public String getCtrtCntrTpszCd() {
		return this.ctrtCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return prcRoutSeq
	 */
	public String getPrcRoutSeq() {
		return this.prcRoutSeq;
	}
	
	/**
	 * Column Info
	 * @return rtAppNoteConvTpCd
	 */
	public String getRtAppNoteConvTpCd() {
		return this.rtAppNoteConvTpCd;
	}
	
	/**
	 * Column Info
	 * @return delMtchFlg
	 */
	public String getDelMtchFlg() {
		return this.delMtchFlg;
	}
	
	/**
	 * Column Info
	 * @return opRoutPntLocDefCd
	 */
	public String getOpRoutPntLocDefCd() {
		return this.opRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return trnsModCd
	 */
	public String getTrnsModCd() {
		return this.trnsModCd;
	}
	
	/**
	 * Column Info
	 * @return bkgBqSeq
	 */
	public String getBkgBqSeq() {
		return this.bkgBqSeq;
	}
	
	/**
	 * Column Info
	 * @return rtRatUtCd
	 */
	public String getRtRatUtCd() {
		return this.rtRatUtCd;
	}
	
	/**
	 * Column Info
	 * @return rtAppFrtRtAmt
	 */
	public String getRtAppFrtRtAmt() {
		return this.rtAppFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return rtAppRtOpCd
	 */
	public String getRtAppRtOpCd() {
		return this.rtAppRtOpCd;
	}
	

	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param oaPrcTrspModCd
	 */
	public void setOaPrcTrspModCd(String oaPrcTrspModCd) {
		this.oaPrcTrspModCd = oaPrcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param daAddChgSeq
	 */
	public void setDaAddChgSeq(String daAddChgSeq) {
		this.daAddChgSeq = daAddChgSeq;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param oaRcvDeTermCd
	 */
	public void setOaRcvDeTermCd(String oaRcvDeTermCd) {
		this.oaRcvDeTermCd = oaRcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param oaPrcCgoTpCd
	 */
	public void setOaPrcCgoTpCd(String oaPrcCgoTpCd) {
		this.oaPrcCgoTpCd = oaPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param ovRoutViaPortDefCd
	 */
	public void setOvRoutViaPortDefCd(String ovRoutViaPortDefCd) {
		this.ovRoutViaPortDefCd = ovRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param oaCurrCd
	 */
	public void setOaCurrCd(String oaCurrCd) {
		this.oaCurrCd = oaCurrCd;
	}
	
	/**
	 * Column Info
	 * @param oihFlg
	 */
	public void setOihFlg(String oihFlg) {
		this.oihFlg = oihFlg;
	}
	
	/**
	 * Column Info
	 * @param daFnlFrtRtAmt
	 */
	public void setDaFnlFrtRtAmt(String daFnlFrtRtAmt) {
		this.daFnlFrtRtAmt = daFnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param bqPodApplFlg
	 */
	public void setBqPodApplFlg(String bqPodApplFlg) {
		this.bqPodApplFlg = bqPodApplFlg;
	}
	
	/**
	 * Column Info
	 * @param bqSeq
	 */
	public void setBqSeq(String bqSeq) {
		this.bqSeq = bqSeq;
	}
	
	/**
	 * Column Info
	 * @param dpPrcTrspModCd
	 */
	public void setDpPrcTrspModCd(String dpPrcTrspModCd) {
		this.dpPrcTrspModCd = dpPrcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param rtAppBkgConvTpCd
	 */
	public void setRtAppBkgConvTpCd(String rtAppBkgConvTpCd) {
		this.rtAppBkgConvTpCd = rtAppBkgConvTpCd;
	}
	
	/**
	 * Column Info
	 * @param opPrcTrspModCd
	 */
	public void setOpPrcTrspModCd(String opPrcTrspModCd) {
		this.opPrcTrspModCd = opPrcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param oaFnlFrtRtAmt
	 */
	public void setOaFnlFrtRtAmt(String oaFnlFrtRtAmt) {
		this.oaFnlFrtRtAmt = oaFnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param daRatUtCd
	 */
	public void setDaRatUtCd(String daRatUtCd) {
		this.daRatUtCd = daRatUtCd;
	}
	
	/**
	 * Column Info
	 * @param cmPrcCmdtTpCd
	 */
	public void setCmPrcCmdtTpCd(String cmPrcCmdtTpCd) {
		this.cmPrcCmdtTpCd = cmPrcCmdtTpCd;
	}
	
	/**
	 * Column Info
	 * @param prcRtSeq
	 */
	public void setPrcRtSeq(String prcRtSeq) {
		this.prcRtSeq = prcRtSeq;
	}
	
	/**
	 * Column Info
	 * @param rtAppNoteConvMapgId
	 */
	public void setRtAppNoteConvMapgId(String rtAppNoteConvMapgId) {
		this.rtAppNoteConvMapgId = rtAppNoteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @param opCntrQty
	 */
	public void setOpCntrQty(String opCntrQty) {
		this.opCntrQty = opCntrQty;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param rtRasBkgConvTpCd
	 */
	public void setRtRasBkgConvTpCd(String rtRasBkgConvTpCd) {
		this.rtRasBkgConvTpCd = rtRasBkgConvTpCd;
	}
	
	/**
	 * Column Info
	 * @param prcCgoTpCd
	 */
	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param daPrcCgoTpCd
	 */
	public void setDaPrcCgoTpCd(String daPrcCgoTpCd) {
		this.daPrcCgoTpCd = daPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtHdrSeq
	 */
	public void setPrcCmdtHdrSeq(String prcCmdtHdrSeq) {
		this.prcCmdtHdrSeq = prcCmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param fnlFrtRtAmt
	 */
	public void setFnlFrtRtAmt(String fnlFrtRtAmt) {
		this.fnlFrtRtAmt = fnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param rtRasNoteConvRuleCd
	 */
	public void setRtRasNoteConvRuleCd(String rtRasNoteConvRuleCd) {
		this.rtRasNoteConvRuleCd = rtRasNoteConvRuleCd;
	}
	
	/**
	 * Column Info
	 * @param rtRasCurrCd
	 */
	public void setRtRasCurrCd(String rtRasCurrCd) {
		this.rtRasCurrCd = rtRasCurrCd;
	}
	
	/**
	 * Column Info
	 * @param rtAppNoteConvSeq
	 */
	public void setRtAppNoteConvSeq(String rtAppNoteConvSeq) {
		this.rtAppNoteConvSeq = rtAppNoteConvSeq;
	}
	
	/**
	 * Column Info
	 * @param rtRasNoteConvTpCd
	 */
	public void setRtRasNoteConvTpCd(String rtRasNoteConvTpCd) {
		this.rtRasNoteConvTpCd = rtRasNoteConvTpCd;
	}
	
	/**
	 * Column Info
	 * @param rtPrcCgoTpCd
	 */
	public void setRtPrcCgoTpCd(String rtPrcCgoTpCd) {
		this.rtPrcCgoTpCd = rtPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param oaAddChgSeq
	 */
	public void setOaAddChgSeq(String oaAddChgSeq) {
		this.oaAddChgSeq = oaAddChgSeq;
	}
	
	/**
	 * Column Info
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note;
	}
	
	/**
	 * Column Info
	 * @param bqDelApplFlg
	 */
	public void setBqDelApplFlg(String bqDelApplFlg) {
		this.bqDelApplFlg = bqDelApplFlg;
	}
	
	/**
	 * Column Info
	 * @param daRcvDeTermCd
	 */
	public void setDaRcvDeTermCd(String daRcvDeTermCd) {
		this.daRcvDeTermCd = daRcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param bqPorRlyPortApplFlg
	 */
	public void setBqPorRlyPortApplFlg(String bqPorRlyPortApplFlg) {
		this.bqPorRlyPortApplFlg = bqPorRlyPortApplFlg;
	}
	
	/**
	 * Column Info
	 * @param daRoutPntLocDefCd
	 */
	public void setDaRoutPntLocDefCd(String daRoutPntLocDefCd) {
		this.daRoutPntLocDefCd = daRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param rtCurrCd
	 */
	public void setRtCurrCd(String rtCurrCd) {
		this.rtCurrCd = rtCurrCd;
	}
	
	/**
	 * Column Info
	 * @param oaBsePortDefCd
	 */
	public void setOaBsePortDefCd(String oaBsePortDefCd) {
		this.oaBsePortDefCd = oaBsePortDefCd;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param cmPrcCmdtDefCd
	 */
	public void setCmPrcCmdtDefCd(String cmPrcCmdtDefCd) {
		this.cmPrcCmdtDefCd = cmPrcCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @param dryCgoFlg
	 */
	public void setDryCgoFlg(String dryCgoFlg) {
		this.dryCgoFlg = dryCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param bqPorApplFlg
	 */
	public void setBqPorApplFlg(String bqPorApplFlg) {
		this.bqPorApplFlg = bqPorApplFlg;
	}
	
	/**
	 * Column Info
	 * @param orgTrspModCd
	 */
	public void setOrgTrspModCd(String orgTrspModCd) {
		this.orgTrspModCd = orgTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param porMtchFlg
	 */
	public void setPorMtchFlg(String porMtchFlg) {
		this.porMtchFlg = porMtchFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param dtl
	 */
	public void setDtl(String dtl) {
		this.dtl = dtl;
	}
	
	/**
	 * Column Info
	 * @param bqPolApplFlg
	 */
	public void setBqPolApplFlg(String bqPolApplFlg) {
		this.bqPolApplFlg = bqPolApplFlg;
	}
	
	/**
	 * Column Info
	 * @param cgoCateCd
	 */
	public void setCgoCateCd(String cgoCateCd) {
		this.cgoCateCd = cgoCateCd;
	}
	
	/**
	 * Column Info
	 * @param destTrspModCd
	 */
	public void setDestTrspModCd(String destTrspModCd) {
		this.destTrspModCd = destTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param rtRasRtOpCd
	 */
	public void setRtRasRtOpCd(String rtRasRtOpCd) {
		this.rtRasRtOpCd = rtRasRtOpCd;
	}
	
	/**
	 * Column Info
	 * @param rtMtchPattCd
	 */
	public void setRtMtchPattCd(String rtMtchPattCd) {
		this.rtMtchPattCd = rtMtchPattCd;
	}
	
	/**
	 * Column Info
	 * @param daCurrCd
	 */
	public void setDaCurrCd(String daCurrCd) {
		this.daCurrCd = daCurrCd;
	}
	
	/**
	 * Column Info
	 * @param rtAppNoteConvRuleCd
	 */
	public void setRtAppNoteConvRuleCd(String rtAppNoteConvRuleCd) {
		this.rtAppNoteConvRuleCd = rtAppNoteConvRuleCd;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param prcRtMtchPattCd
	 */
	public void setPrcRtMtchPattCd(String prcRtMtchPattCd) {
		this.prcRtMtchPattCd = prcRtMtchPattCd;
	}
	
	/**
	 * Column Info
	 * @param bqPstRlyPortApplFlg
	 */
	public void setBqPstRlyPortApplFlg(String bqPstRlyPortApplFlg) {
		this.bqPstRlyPortApplFlg = bqPstRlyPortApplFlg;
	}
	
	/**
	 * Column Info
	 * @param dpRoutPntLocDefCd
	 */
	public void setDpRoutPntLocDefCd(String dpRoutPntLocDefCd) {
		this.dpRoutPntLocDefCd = dpRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param daPrcTrspModCd
	 */
	public void setDaPrcTrspModCd(String daPrcTrspModCd) {
		this.daPrcTrspModCd = daPrcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param dihFlg
	 */
	public void setDihFlg(String dihFlg) {
		this.dihFlg = dihFlg;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param rtAppCurrCd
	 */
	public void setRtAppCurrCd(String rtAppCurrCd) {
		this.rtAppCurrCd = rtAppCurrCd;
	}
	
	/**
	 * Column Info
	 * @param rtRasNoteConvSeq
	 */
	public void setRtRasNoteConvSeq(String rtRasNoteConvSeq) {
		this.rtRasNoteConvSeq = rtRasNoteConvSeq;
	}
	
	/**
	 * Column Info
	 * @param oaRoutPntLocDefCd
	 */
	public void setOaRoutPntLocDefCd(String oaRoutPntLocDefCd) {
		this.oaRoutPntLocDefCd = oaRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param noteCtnt
	 */
	public void setNoteCtnt(String noteCtnt) {
		this.noteCtnt = noteCtnt;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param oaRatUtCd
	 */
	public void setOaRatUtCd(String oaRatUtCd) {
		this.oaRatUtCd = oaRatUtCd;
	}
	
	/**
	 * Column Info
	 * @param rtFnlFrtRtAmt
	 */
	public void setRtFnlFrtRtAmt(String rtFnlFrtRtAmt) {
		this.rtFnlFrtRtAmt = rtFnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param dvRoutViaPortDefCd
	 */
	public void setDvRoutViaPortDefCd(String dvRoutViaPortDefCd) {
		this.dvRoutViaPortDefCd = dvRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param rtRasFrtRtAmt
	 */
	public void setRtRasFrtRtAmt(String rtRasFrtRtAmt) {
		this.rtRasFrtRtAmt = rtRasFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param rtRasNoteConvMapgId
	 */
	public void setRtRasNoteConvMapgId(String rtRasNoteConvMapgId) {
		this.rtRasNoteConvMapgId = rtRasNoteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @param daBsePortDefCd
	 */
	public void setDaBsePortDefCd(String daBsePortDefCd) {
		this.daBsePortDefCd = daBsePortDefCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtCntrTpszCd
	 */
	public void setCtrtCntrTpszCd(String ctrtCntrTpszCd) {
		this.ctrtCntrTpszCd = ctrtCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param prcRoutSeq
	 */
	public void setPrcRoutSeq(String prcRoutSeq) {
		this.prcRoutSeq = prcRoutSeq;
	}
	
	/**
	 * Column Info
	 * @param rtAppNoteConvTpCd
	 */
	public void setRtAppNoteConvTpCd(String rtAppNoteConvTpCd) {
		this.rtAppNoteConvTpCd = rtAppNoteConvTpCd;
	}
	
	/**
	 * Column Info
	 * @param delMtchFlg
	 */
	public void setDelMtchFlg(String delMtchFlg) {
		this.delMtchFlg = delMtchFlg;
	}
	
	/**
	 * Column Info
	 * @param opRoutPntLocDefCd
	 */
	public void setOpRoutPntLocDefCd(String opRoutPntLocDefCd) {
		this.opRoutPntLocDefCd = opRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param trnsModCd
	 */
	public void setTrnsModCd(String trnsModCd) {
		this.trnsModCd = trnsModCd;
	}
	
	/**
	 * Column Info
	 * @param bkgBqSeq
	 */
	public void setBkgBqSeq(String bkgBqSeq) {
		this.bkgBqSeq = bkgBqSeq;
	}
	
	/**
	 * Column Info
	 * @param rtRatUtCd
	 */
	public void setRtRatUtCd(String rtRatUtCd) {
		this.rtRatUtCd = rtRatUtCd;
	}
	
	/**
	 * Column Info
	 * @param rtAppFrtRtAmt
	 */
	public void setRtAppFrtRtAmt(String rtAppFrtRtAmt) {
		this.rtAppFrtRtAmt = rtAppFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param rtAppRtOpCd
	 */
	public void setRtAppRtOpCd(String rtAppRtOpCd) {
		this.rtAppRtOpCd = rtAppRtOpCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setOaPrcTrspModCd(JSPUtil.getParameter(request, "oa_prc_trsp_mod_cd", ""));
		setDaAddChgSeq(JSPUtil.getParameter(request, "da_add_chg_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOaRcvDeTermCd(JSPUtil.getParameter(request, "oa_rcv_de_term_cd", ""));
		setOaPrcCgoTpCd(JSPUtil.getParameter(request, "oa_prc_cgo_tp_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, "rcv_de_term_cd", ""));
		setOvRoutViaPortDefCd(JSPUtil.getParameter(request, "ov_rout_via_port_def_cd", ""));
		setOaCurrCd(JSPUtil.getParameter(request, "oa_curr_cd", ""));
		setOihFlg(JSPUtil.getParameter(request, "oih_flg", ""));
		setDaFnlFrtRtAmt(JSPUtil.getParameter(request, "da_fnl_frt_rt_amt", ""));
		setBqPodApplFlg(JSPUtil.getParameter(request, "bq_pod_appl_flg", ""));
		setBqSeq(JSPUtil.getParameter(request, "bq_seq", ""));
		setDpPrcTrspModCd(JSPUtil.getParameter(request, "dp_prc_trsp_mod_cd", ""));
		setRtAppBkgConvTpCd(JSPUtil.getParameter(request, "rt_app_bkg_conv_tp_cd", ""));
		setOpPrcTrspModCd(JSPUtil.getParameter(request, "op_prc_trsp_mod_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, "rat_ut_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setOaFnlFrtRtAmt(JSPUtil.getParameter(request, "oa_fnl_frt_rt_amt", ""));
		setDaRatUtCd(JSPUtil.getParameter(request, "da_rat_ut_cd", ""));
		setCmPrcCmdtTpCd(JSPUtil.getParameter(request, "cm_prc_cmdt_tp_cd", ""));
		setPrcRtSeq(JSPUtil.getParameter(request, "prc_rt_seq", ""));
		setRtAppNoteConvMapgId(JSPUtil.getParameter(request, "rt_app_note_conv_mapg_id", ""));
		setOpCntrQty(JSPUtil.getParameter(request, "op_cntr_qty", ""));
		setRcFlg(JSPUtil.getParameter(request, "rc_flg", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
		setRtRasBkgConvTpCd(JSPUtil.getParameter(request, "rt_ras_bkg_conv_tp_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, "prc_cgo_tp_cd", ""));
		setDaPrcCgoTpCd(JSPUtil.getParameter(request, "da_prc_cgo_tp_cd", ""));
		setPrcCmdtHdrSeq(JSPUtil.getParameter(request, "prc_cmdt_hdr_seq", ""));
		setFnlFrtRtAmt(JSPUtil.getParameter(request, "fnl_frt_rt_amt", ""));
		setRtRasNoteConvRuleCd(JSPUtil.getParameter(request, "rt_ras_note_conv_rule_cd", ""));
		setRtRasCurrCd(JSPUtil.getParameter(request, "rt_ras_curr_cd", ""));
		setRtAppNoteConvSeq(JSPUtil.getParameter(request, "rt_app_note_conv_seq", ""));
		setRtRasNoteConvTpCd(JSPUtil.getParameter(request, "rt_ras_note_conv_tp_cd", ""));
		setRtPrcCgoTpCd(JSPUtil.getParameter(request, "rt_prc_cgo_tp_cd", ""));
		setOaAddChgSeq(JSPUtil.getParameter(request, "oa_add_chg_seq", ""));
		setNote(JSPUtil.getParameter(request, "note", ""));
		setBqDelApplFlg(JSPUtil.getParameter(request, "bq_del_appl_flg", ""));
		setDaRcvDeTermCd(JSPUtil.getParameter(request, "da_rcv_de_term_cd", ""));
		setBqPorRlyPortApplFlg(JSPUtil.getParameter(request, "bq_por_rly_port_appl_flg", ""));
		setDaRoutPntLocDefCd(JSPUtil.getParameter(request, "da_rout_pnt_loc_def_cd", ""));
		setRtCurrCd(JSPUtil.getParameter(request, "rt_curr_cd", ""));
		setOaBsePortDefCd(JSPUtil.getParameter(request, "oa_bse_port_def_cd", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setCmPrcCmdtDefCd(JSPUtil.getParameter(request, "cm_prc_cmdt_def_cd", ""));
		setDryCgoFlg(JSPUtil.getParameter(request, "dry_cgo_flg", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setBqPorApplFlg(JSPUtil.getParameter(request, "bq_por_appl_flg", ""));
		setOrgTrspModCd(JSPUtil.getParameter(request, "org_trsp_mod_cd", ""));
		setPorMtchFlg(JSPUtil.getParameter(request, "por_mtch_flg", ""));
		setCtrtNo(JSPUtil.getParameter(request, "ctrt_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setDtl(JSPUtil.getParameter(request, "dtl", ""));
		setBqPolApplFlg(JSPUtil.getParameter(request, "bq_pol_appl_flg", ""));
		setCgoCateCd(JSPUtil.getParameter(request, "cgo_cate_cd", ""));
		setDestTrspModCd(JSPUtil.getParameter(request, "dest_trsp_mod_cd", ""));
		setRtRasRtOpCd(JSPUtil.getParameter(request, "rt_ras_rt_op_cd", ""));
		setRtMtchPattCd(JSPUtil.getParameter(request, "rt_mtch_patt_cd", ""));
		setDaCurrCd(JSPUtil.getParameter(request, "da_curr_cd", ""));
		setRtAppNoteConvRuleCd(JSPUtil.getParameter(request, "rt_app_note_conv_rule_cd", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, "awk_cgo_flg", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setPrcRtMtchPattCd(JSPUtil.getParameter(request, "prc_rt_mtch_patt_cd", ""));
		setBqPstRlyPortApplFlg(JSPUtil.getParameter(request, "bq_pst_rly_port_appl_flg", ""));
		setDpRoutPntLocDefCd(JSPUtil.getParameter(request, "dp_rout_pnt_loc_def_cd", ""));
		setDaPrcTrspModCd(JSPUtil.getParameter(request, "da_prc_trsp_mod_cd", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setDihFlg(JSPUtil.getParameter(request, "dih_flg", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setRtAppCurrCd(JSPUtil.getParameter(request, "rt_app_curr_cd", ""));
		setRtRasNoteConvSeq(JSPUtil.getParameter(request, "rt_ras_note_conv_seq", ""));
		setOaRoutPntLocDefCd(JSPUtil.getParameter(request, "oa_rout_pnt_loc_def_cd", ""));
		setNoteCtnt(JSPUtil.getParameter(request, "note_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOaRatUtCd(JSPUtil.getParameter(request, "oa_rat_ut_cd", ""));
		setRtFnlFrtRtAmt(JSPUtil.getParameter(request, "rt_fnl_frt_rt_amt", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, "bb_cgo_flg", ""));
		setDvRoutViaPortDefCd(JSPUtil.getParameter(request, "dv_rout_via_port_def_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, "dcgo_flg", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setRtRasFrtRtAmt(JSPUtil.getParameter(request, "rt_ras_frt_rt_amt", ""));
		setRtRasNoteConvMapgId(JSPUtil.getParameter(request, "rt_ras_note_conv_mapg_id", ""));
		setDaBsePortDefCd(JSPUtil.getParameter(request, "da_bse_port_def_cd", ""));
		setCtrtCntrTpszCd(JSPUtil.getParameter(request, "ctrt_cntr_tpsz_cd", ""));
		setPrcRoutSeq(JSPUtil.getParameter(request, "prc_rout_seq", ""));
		setRtAppNoteConvTpCd(JSPUtil.getParameter(request, "rt_app_note_conv_tp_cd", ""));
		setDelMtchFlg(JSPUtil.getParameter(request, "del_mtch_flg", ""));
		setOpRoutPntLocDefCd(JSPUtil.getParameter(request, "op_rout_pnt_loc_def_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setSocFlg(JSPUtil.getParameter(request, "soc_flg", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setTrnsModCd(JSPUtil.getParameter(request, "trns_mod_cd", ""));
		setBkgBqSeq(JSPUtil.getParameter(request, "bkg_bq_seq", ""));
		setRtRatUtCd(JSPUtil.getParameter(request, "rt_rat_ut_cd", ""));
		setRtAppFrtRtAmt(JSPUtil.getParameter(request, "rt_app_frt_rt_amt", ""));
		setRtAppRtOpCd(JSPUtil.getParameter(request, "rt_app_rt_op_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchRfaAsiaEuropeOftAutoratingListVO[]
	 */
	public searchRfaAsiaEuropeOftAutoratingListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchRfaAsiaEuropeOftAutoratingListVO[]
	 */
	public searchRfaAsiaEuropeOftAutoratingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		searchRfaAsiaEuropeOftAutoratingListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] oaPrcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "oa_prc_trsp_mod_cd", length));
			String[] daAddChgSeq = (JSPUtil.getParameter(request, prefix	+ "da_add_chg_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] oaRcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "oa_rcv_de_term_cd", length));
			String[] oaPrcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "oa_prc_cgo_tp_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] ovRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "ov_rout_via_port_def_cd", length));
			String[] oaCurrCd = (JSPUtil.getParameter(request, prefix	+ "oa_curr_cd", length));
			String[] oihFlg = (JSPUtil.getParameter(request, prefix	+ "oih_flg", length));
			String[] daFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "da_fnl_frt_rt_amt", length));
			String[] bqPodApplFlg = (JSPUtil.getParameter(request, prefix	+ "bq_pod_appl_flg", length));
			String[] bqSeq = (JSPUtil.getParameter(request, prefix	+ "bq_seq", length));
			String[] dpPrcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "dp_prc_trsp_mod_cd", length));
			String[] rtAppBkgConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_app_bkg_conv_tp_cd", length));
			String[] opPrcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "op_prc_trsp_mod_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] oaFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "oa_fnl_frt_rt_amt", length));
			String[] daRatUtCd = (JSPUtil.getParameter(request, prefix	+ "da_rat_ut_cd", length));
			String[] cmPrcCmdtTpCd = (JSPUtil.getParameter(request, prefix	+ "cm_prc_cmdt_tp_cd", length));
			String[] prcRtSeq = (JSPUtil.getParameter(request, prefix	+ "prc_rt_seq", length));
			String[] rtAppNoteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "rt_app_note_conv_mapg_id", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] rtRasBkgConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_ras_bkg_conv_tp_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] daPrcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "da_prc_cgo_tp_cd", length));
			String[] prcCmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_hdr_seq", length));
			String[] fnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_frt_rt_amt", length));
			String[] rtRasNoteConvRuleCd = (JSPUtil.getParameter(request, prefix	+ "rt_ras_note_conv_rule_cd", length));
			String[] rtRasCurrCd = (JSPUtil.getParameter(request, prefix	+ "rt_ras_curr_cd", length));
			String[] rtAppNoteConvSeq = (JSPUtil.getParameter(request, prefix	+ "rt_app_note_conv_seq", length));
			String[] rtRasNoteConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_ras_note_conv_tp_cd", length));
			String[] rtPrcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_prc_cgo_tp_cd", length));
			String[] oaAddChgSeq = (JSPUtil.getParameter(request, prefix	+ "oa_add_chg_seq", length));
			String[] note = (JSPUtil.getParameter(request, prefix	+ "note", length));
			String[] bqDelApplFlg = (JSPUtil.getParameter(request, prefix	+ "bq_del_appl_flg", length));
			String[] daRcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "da_rcv_de_term_cd", length));
			String[] bqPorRlyPortApplFlg = (JSPUtil.getParameter(request, prefix	+ "bq_por_rly_port_appl_flg", length));
			String[] daRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "da_rout_pnt_loc_def_cd", length));
			String[] rtCurrCd = (JSPUtil.getParameter(request, prefix	+ "rt_curr_cd", length));
			String[] oaBsePortDefCd = (JSPUtil.getParameter(request, prefix	+ "oa_bse_port_def_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] cmPrcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "cm_prc_cmdt_def_cd", length));
			String[] dryCgoFlg = (JSPUtil.getParameter(request, prefix	+ "dry_cgo_flg", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] bqPorApplFlg = (JSPUtil.getParameter(request, prefix	+ "bq_por_appl_flg", length));
			String[] orgTrspModCd = (JSPUtil.getParameter(request, prefix	+ "org_trsp_mod_cd", length));
			String[] porMtchFlg = (JSPUtil.getParameter(request, prefix	+ "por_mtch_flg", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] dtl = (JSPUtil.getParameter(request, prefix	+ "dtl", length));
			String[] bqPolApplFlg = (JSPUtil.getParameter(request, prefix	+ "bq_pol_appl_flg", length));
			String[] cgoCateCd = (JSPUtil.getParameter(request, prefix	+ "cgo_cate_cd", length));
			String[] destTrspModCd = (JSPUtil.getParameter(request, prefix	+ "dest_trsp_mod_cd", length));
			String[] rtRasRtOpCd = (JSPUtil.getParameter(request, prefix	+ "rt_ras_rt_op_cd", length));
			String[] rtMtchPattCd = (JSPUtil.getParameter(request, prefix	+ "rt_mtch_patt_cd", length));
			String[] daCurrCd = (JSPUtil.getParameter(request, prefix	+ "da_curr_cd", length));
			String[] rtAppNoteConvRuleCd = (JSPUtil.getParameter(request, prefix	+ "rt_app_note_conv_rule_cd", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] prcRtMtchPattCd = (JSPUtil.getParameter(request, prefix	+ "prc_rt_mtch_patt_cd", length));
			String[] bqPstRlyPortApplFlg = (JSPUtil.getParameter(request, prefix	+ "bq_pst_rly_port_appl_flg", length));
			String[] dpRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dp_rout_pnt_loc_def_cd", length));
			String[] daPrcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "da_prc_trsp_mod_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] dihFlg = (JSPUtil.getParameter(request, prefix	+ "dih_flg", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] rtAppCurrCd = (JSPUtil.getParameter(request, prefix	+ "rt_app_curr_cd", length));
			String[] rtRasNoteConvSeq = (JSPUtil.getParameter(request, prefix	+ "rt_ras_note_conv_seq", length));
			String[] oaRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "oa_rout_pnt_loc_def_cd", length));
			String[] noteCtnt = (JSPUtil.getParameter(request, prefix	+ "note_ctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oaRatUtCd = (JSPUtil.getParameter(request, prefix	+ "oa_rat_ut_cd", length));
			String[] rtFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_fnl_frt_rt_amt", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] dvRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dv_rout_via_port_def_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] rtRasFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_ras_frt_rt_amt", length));
			String[] rtRasNoteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "rt_ras_note_conv_mapg_id", length));
			String[] daBsePortDefCd = (JSPUtil.getParameter(request, prefix	+ "da_bse_port_def_cd", length));
			String[] ctrtCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cntr_tpsz_cd", length));
			String[] prcRoutSeq = (JSPUtil.getParameter(request, prefix	+ "prc_rout_seq", length));
			String[] rtAppNoteConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_app_note_conv_tp_cd", length));
			String[] delMtchFlg = (JSPUtil.getParameter(request, prefix	+ "del_mtch_flg", length));
			String[] opRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "op_rout_pnt_loc_def_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] trnsModCd = (JSPUtil.getParameter(request, prefix	+ "trns_mod_cd", length));
			String[] bkgBqSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_bq_seq", length));
			String[] rtRatUtCd = (JSPUtil.getParameter(request, prefix	+ "rt_rat_ut_cd", length));
			String[] rtAppFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_app_frt_rt_amt", length));
			String[] rtAppRtOpCd = (JSPUtil.getParameter(request, prefix	+ "rt_app_rt_op_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new searchRfaAsiaEuropeOftAutoratingListVO();
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (oaPrcTrspModCd[i] != null)
					model.setOaPrcTrspModCd(oaPrcTrspModCd[i]);
				if (daAddChgSeq[i] != null)
					model.setDaAddChgSeq(daAddChgSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (oaRcvDeTermCd[i] != null)
					model.setOaRcvDeTermCd(oaRcvDeTermCd[i]);
				if (oaPrcCgoTpCd[i] != null)
					model.setOaPrcCgoTpCd(oaPrcCgoTpCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (ovRoutViaPortDefCd[i] != null)
					model.setOvRoutViaPortDefCd(ovRoutViaPortDefCd[i]);
				if (oaCurrCd[i] != null)
					model.setOaCurrCd(oaCurrCd[i]);
				if (oihFlg[i] != null)
					model.setOihFlg(oihFlg[i]);
				if (daFnlFrtRtAmt[i] != null)
					model.setDaFnlFrtRtAmt(daFnlFrtRtAmt[i]);
				if (bqPodApplFlg[i] != null)
					model.setBqPodApplFlg(bqPodApplFlg[i]);
				if (bqSeq[i] != null)
					model.setBqSeq(bqSeq[i]);
				if (dpPrcTrspModCd[i] != null)
					model.setDpPrcTrspModCd(dpPrcTrspModCd[i]);
				if (rtAppBkgConvTpCd[i] != null)
					model.setRtAppBkgConvTpCd(rtAppBkgConvTpCd[i]);
				if (opPrcTrspModCd[i] != null)
					model.setOpPrcTrspModCd(opPrcTrspModCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (oaFnlFrtRtAmt[i] != null)
					model.setOaFnlFrtRtAmt(oaFnlFrtRtAmt[i]);
				if (daRatUtCd[i] != null)
					model.setDaRatUtCd(daRatUtCd[i]);
				if (cmPrcCmdtTpCd[i] != null)
					model.setCmPrcCmdtTpCd(cmPrcCmdtTpCd[i]);
				if (prcRtSeq[i] != null)
					model.setPrcRtSeq(prcRtSeq[i]);
				if (rtAppNoteConvMapgId[i] != null)
					model.setRtAppNoteConvMapgId(rtAppNoteConvMapgId[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (rtRasBkgConvTpCd[i] != null)
					model.setRtRasBkgConvTpCd(rtRasBkgConvTpCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (daPrcCgoTpCd[i] != null)
					model.setDaPrcCgoTpCd(daPrcCgoTpCd[i]);
				if (prcCmdtHdrSeq[i] != null)
					model.setPrcCmdtHdrSeq(prcCmdtHdrSeq[i]);
				if (fnlFrtRtAmt[i] != null)
					model.setFnlFrtRtAmt(fnlFrtRtAmt[i]);
				if (rtRasNoteConvRuleCd[i] != null)
					model.setRtRasNoteConvRuleCd(rtRasNoteConvRuleCd[i]);
				if (rtRasCurrCd[i] != null)
					model.setRtRasCurrCd(rtRasCurrCd[i]);
				if (rtAppNoteConvSeq[i] != null)
					model.setRtAppNoteConvSeq(rtAppNoteConvSeq[i]);
				if (rtRasNoteConvTpCd[i] != null)
					model.setRtRasNoteConvTpCd(rtRasNoteConvTpCd[i]);
				if (rtPrcCgoTpCd[i] != null)
					model.setRtPrcCgoTpCd(rtPrcCgoTpCd[i]);
				if (oaAddChgSeq[i] != null)
					model.setOaAddChgSeq(oaAddChgSeq[i]);
				if (note[i] != null)
					model.setNote(note[i]);
				if (bqDelApplFlg[i] != null)
					model.setBqDelApplFlg(bqDelApplFlg[i]);
				if (daRcvDeTermCd[i] != null)
					model.setDaRcvDeTermCd(daRcvDeTermCd[i]);
				if (bqPorRlyPortApplFlg[i] != null)
					model.setBqPorRlyPortApplFlg(bqPorRlyPortApplFlg[i]);
				if (daRoutPntLocDefCd[i] != null)
					model.setDaRoutPntLocDefCd(daRoutPntLocDefCd[i]);
				if (rtCurrCd[i] != null)
					model.setRtCurrCd(rtCurrCd[i]);
				if (oaBsePortDefCd[i] != null)
					model.setOaBsePortDefCd(oaBsePortDefCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (cmPrcCmdtDefCd[i] != null)
					model.setCmPrcCmdtDefCd(cmPrcCmdtDefCd[i]);
				if (dryCgoFlg[i] != null)
					model.setDryCgoFlg(dryCgoFlg[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (bqPorApplFlg[i] != null)
					model.setBqPorApplFlg(bqPorApplFlg[i]);
				if (orgTrspModCd[i] != null)
					model.setOrgTrspModCd(orgTrspModCd[i]);
				if (porMtchFlg[i] != null)
					model.setPorMtchFlg(porMtchFlg[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (dtl[i] != null)
					model.setDtl(dtl[i]);
				if (bqPolApplFlg[i] != null)
					model.setBqPolApplFlg(bqPolApplFlg[i]);
				if (cgoCateCd[i] != null)
					model.setCgoCateCd(cgoCateCd[i]);
				if (destTrspModCd[i] != null)
					model.setDestTrspModCd(destTrspModCd[i]);
				if (rtRasRtOpCd[i] != null)
					model.setRtRasRtOpCd(rtRasRtOpCd[i]);
				if (rtMtchPattCd[i] != null)
					model.setRtMtchPattCd(rtMtchPattCd[i]);
				if (daCurrCd[i] != null)
					model.setDaCurrCd(daCurrCd[i]);
				if (rtAppNoteConvRuleCd[i] != null)
					model.setRtAppNoteConvRuleCd(rtAppNoteConvRuleCd[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (prcRtMtchPattCd[i] != null)
					model.setPrcRtMtchPattCd(prcRtMtchPattCd[i]);
				if (bqPstRlyPortApplFlg[i] != null)
					model.setBqPstRlyPortApplFlg(bqPstRlyPortApplFlg[i]);
				if (dpRoutPntLocDefCd[i] != null)
					model.setDpRoutPntLocDefCd(dpRoutPntLocDefCd[i]);
				if (daPrcTrspModCd[i] != null)
					model.setDaPrcTrspModCd(daPrcTrspModCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (dihFlg[i] != null)
					model.setDihFlg(dihFlg[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (rtAppCurrCd[i] != null)
					model.setRtAppCurrCd(rtAppCurrCd[i]);
				if (rtRasNoteConvSeq[i] != null)
					model.setRtRasNoteConvSeq(rtRasNoteConvSeq[i]);
				if (oaRoutPntLocDefCd[i] != null)
					model.setOaRoutPntLocDefCd(oaRoutPntLocDefCd[i]);
				if (noteCtnt[i] != null)
					model.setNoteCtnt(noteCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oaRatUtCd[i] != null)
					model.setOaRatUtCd(oaRatUtCd[i]);
				if (rtFnlFrtRtAmt[i] != null)
					model.setRtFnlFrtRtAmt(rtFnlFrtRtAmt[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (dvRoutViaPortDefCd[i] != null)
					model.setDvRoutViaPortDefCd(dvRoutViaPortDefCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (rtRasFrtRtAmt[i] != null)
					model.setRtRasFrtRtAmt(rtRasFrtRtAmt[i]);
				if (rtRasNoteConvMapgId[i] != null)
					model.setRtRasNoteConvMapgId(rtRasNoteConvMapgId[i]);
				if (daBsePortDefCd[i] != null)
					model.setDaBsePortDefCd(daBsePortDefCd[i]);
				if (ctrtCntrTpszCd[i] != null)
					model.setCtrtCntrTpszCd(ctrtCntrTpszCd[i]);
				if (prcRoutSeq[i] != null)
					model.setPrcRoutSeq(prcRoutSeq[i]);
				if (rtAppNoteConvTpCd[i] != null)
					model.setRtAppNoteConvTpCd(rtAppNoteConvTpCd[i]);
				if (delMtchFlg[i] != null)
					model.setDelMtchFlg(delMtchFlg[i]);
				if (opRoutPntLocDefCd[i] != null)
					model.setOpRoutPntLocDefCd(opRoutPntLocDefCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (trnsModCd[i] != null)
					model.setTrnsModCd(trnsModCd[i]);
				if (bkgBqSeq[i] != null)
					model.setBkgBqSeq(bkgBqSeq[i]);
				if (rtRatUtCd[i] != null)
					model.setRtRatUtCd(rtRatUtCd[i]);
				if (rtAppFrtRtAmt[i] != null)
					model.setRtAppFrtRtAmt(rtAppFrtRtAmt[i]);
				if (rtAppRtOpCd[i] != null)
					model.setRtAppRtOpCd(rtAppRtOpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchRfaAsiaEuropeOftAutoratingListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchRfaAsiaEuropeOftAutoratingListVO[]
	 */
	public searchRfaAsiaEuropeOftAutoratingListVO[] getsearchRfaAsiaEuropeOftAutoratingListVOs(){
		searchRfaAsiaEuropeOftAutoratingListVO[] vos = (searchRfaAsiaEuropeOftAutoratingListVO[])models.toArray(new searchRfaAsiaEuropeOftAutoratingListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaPrcTrspModCd = this.oaPrcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daAddChgSeq = this.daAddChgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRcvDeTermCd = this.oaRcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaPrcCgoTpCd = this.oaPrcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovRoutViaPortDefCd = this.ovRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaCurrCd = this.oaCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oihFlg = this.oihFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daFnlFrtRtAmt = this.daFnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqPodApplFlg = this.bqPodApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqSeq = this.bqSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcTrspModCd = this.dpPrcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppBkgConvTpCd = this.rtAppBkgConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opPrcTrspModCd = this.opPrcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaFnlFrtRtAmt = this.oaFnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daRatUtCd = this.daRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPrcCmdtTpCd = this.cmPrcCmdtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRtSeq = this.prcRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppNoteConvMapgId = this.rtAppNoteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasBkgConvTpCd = this.rtRasBkgConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daPrcCgoTpCd = this.daPrcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtHdrSeq = this.prcCmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlFrtRtAmt = this.fnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasNoteConvRuleCd = this.rtRasNoteConvRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasCurrCd = this.rtRasCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppNoteConvSeq = this.rtAppNoteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasNoteConvTpCd = this.rtRasNoteConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtPrcCgoTpCd = this.rtPrcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaAddChgSeq = this.oaAddChgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.note = this.note .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqDelApplFlg = this.bqDelApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daRcvDeTermCd = this.daRcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqPorRlyPortApplFlg = this.bqPorRlyPortApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daRoutPntLocDefCd = this.daRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtCurrCd = this.rtCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaBsePortDefCd = this.oaBsePortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPrcCmdtDefCd = this.cmPrcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dryCgoFlg = this.dryCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqPorApplFlg = this.bqPorApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTrspModCd = this.orgTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porMtchFlg = this.porMtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtl = this.dtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqPolApplFlg = this.bqPolApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoCateCd = this.cgoCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrspModCd = this.destTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasRtOpCd = this.rtRasRtOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtMtchPattCd = this.rtMtchPattCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daCurrCd = this.daCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppNoteConvRuleCd = this.rtAppNoteConvRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRtMtchPattCd = this.prcRtMtchPattCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqPstRlyPortApplFlg = this.bqPstRlyPortApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpRoutPntLocDefCd = this.dpRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daPrcTrspModCd = this.daPrcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dihFlg = this.dihFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppCurrCd = this.rtAppCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasNoteConvSeq = this.rtRasNoteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRoutPntLocDefCd = this.oaRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtnt = this.noteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRatUtCd = this.oaRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtFnlFrtRtAmt = this.rtFnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvRoutViaPortDefCd = this.dvRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasFrtRtAmt = this.rtRasFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasNoteConvMapgId = this.rtRasNoteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daBsePortDefCd = this.daBsePortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCntrTpszCd = this.ctrtCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRoutSeq = this.prcRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppNoteConvTpCd = this.rtAppNoteConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delMtchFlg = this.delMtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opRoutPntLocDefCd = this.opRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsModCd = this.trnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBqSeq = this.bkgBqSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRatUtCd = this.rtRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppFrtRtAmt = this.rtAppFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppRtOpCd = this.rtAppRtOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
