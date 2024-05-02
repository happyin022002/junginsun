/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltRtListHorizontalExcelVO.java
*@FileTitle : RsltRtListHorizontalExcelVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.14
*@LastModifier : 박근환
*@LastVersion : 1.1
* 2009.08.19 박성수 
* 1.0 Creation
* 1.1 [CHM-201640671] RFA 효율화를 위한 요청 (1차)
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박성수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltRtListHorizontalExcelVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltRtListHorizontalExcelVO> models = new ArrayList<RsltRtListHorizontalExcelVO>();
	
	/* Column Info */
	private String bucDry40 = null;
	/* Column Info */
	private String destRoutViaPortDefCd = null;
	/* Column Info */
	private String pscDry45 = null;
	/* Column Info */
	private String rateRd40hc = null;
	/* Column Info */
	private String ifcDry45 = null;
	/* Column Info */
	private String bucDry20 = null;
	/* Column Info */
	private String bucDry45 = null;
	/* Column Info */
	private String bucDry40hc = null;
	/* Column Info */
	private String pscDry20 = null;
	/* Column Info */
	private String pscDry40 = null;
	/* Column Info */
	private String pscRd40hc = null;
	/* Column Info */
	private String ifcDry40 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String orgPrcTrspModNm = null;
	/* Column Info */
	private String rateDry20 = null;
	/* Column Info */
	private String rateDry45 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ifcDry40hc = null;
	/* Column Info */
	private String ifcRf40hc = null;
	/* Column Info */
	private String bucRd40hc = null;
	/* Column Info */
	private String orgRoutViaPortDefCd = null;
	/* Column Info */
	private String rateDry40 = null;
	/* Column Info */
	private String prcCmdtDefNm = null;
	/* Column Info */
	private String prcCmdtDefCd = null;
	/* Column Info */
	private String bucRf40hc = null;
	/* Column Info */
	private String ifcRd40hc = null;
	/* Column Info */
	private String pscRf40hc = null;
	/* Column Info */
	private String orgRoutPntLocDefCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String rateDry40hc = null;
	/* Column Info */
	private String orgRoutPntLocDefNm = null;
	/* Column Info */
	private String routDpSeq = null;
	/* Column Info */
	private String cmdtDpSeq = null;
	/* Column Info */
	private String rateRf40hc = null;
	/* Column Info */
	private String pscDry40hc = null;
	/* Column Info */
	private String ifcDry20 = null;
	/* Column Info */
	private String destPrcTrspModNm = null;
	/* Column Info */
	private String destRoutPntLocDefCd = null;
	/* Column Info */
	private String destRoutPntLocDefNm = null;
	/* Column Info */
	private String orgRcvDeTermNm = null;
	/* Column Info */
	private String destRcvDeTermNm = null;
	
	/* 추가 항목 */
	/* Column Info */
	private String appBkgDirCallFlg = null;
	/* Column Info */
	private String appBkgTsPortDefCd = null;
	/* Column Info */
	private String appBkgSlanCd = null;
	/* Column Info */
	private String appBkgVvdCd = null;
	/* Column Info */
	private String chgRuleDefCd = null;
	/* Column Info */
	private String rtApplTpCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String bkgRatUtCdBl = null;
	/* Column Info */
	private String bkgRatUtCdCm = null;
	/* Column Info */
	private String bkgRatUtCdBx = null;
	/* Column Info */
	private String convBkgDirCallFlg = null;
	/* Column Info */
	private String convBkgTsPortDefCd = null;
	/* Column Info */
	private String convBkgSlanCd = null;
	/* Column Info */
	private String convBkgVvdCd = null;
	/* Column Info */
	private String payTermCd = null;
	/* Column Info */
	private String bkgYdCd = null;
	/* Column Info */
	private String bkgMinCgoWgt = null;
	/* Column Info */
	private String bkgMaxCgoWgt = null;
	/* Column Info */					
	private String noteConvMapgId = null;
	/* Column Info */
	private String noteConvSeq = null;
	/* Column Info */
	private String noteConvTpCd = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String n1stCmncAmdtSeq = null;		            
	/* Column Info */
	private String chgRuleTpCd = null;
	/* Column Info */
	private String noteConvChgCd = null;
	/* Column Info */
	private String noteConvRuleCd = null;		            
	/* Column Info */
	private String appBkgVslCd = null;
	/* Column Info */
	private String appBkgSkdVoyNo = null;
	/* Column Info */
	private String appBkgSkdDirCd = null;
	/* Column Info */
	private String appBkgTsPortTpCd = null;
	/* Column Info */
	private String convBkgVslCd = null;
	/* Column Info */
	private String convBkgSkdVoyNo = null;
	/* Column Info */
	private String convBkgSkdDirCd = null;
	/* Column Info */
	private String convBkgTsPortTpCd = null;
	/* Column Info */
	private String mstRfaRoutId = null;
	/* Column Info */
	private String srcInfoCd = null;
	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltRtListHorizontalExcelVO() {}

	public RsltRtListHorizontalExcelVO(String ibflag, String pagerows, String cmdtDpSeq, String prcCmdtDefCd, String prcCmdtDefNm, String custSeq, String custLglEngNm, String routDpSeq, String orgRoutPntLocDefCd, String orgRoutPntLocDefNm, String orgRcvDeTermNm, String orgPrcTrspModNm, String orgRoutViaPortDefCd, String destRoutViaPortDefCd, String destRoutPntLocDefCd, String destRoutPntLocDefNm, String destRcvDeTermNm, String destPrcTrspModNm, String rateDry20, String rateDry40, String rateDry40hc, String rateDry45, String rateRf40hc, String rateRd40hc, String bucDry20, String bucDry40, String bucDry40hc, String bucDry45, String bucRf40hc, String bucRd40hc, String ifcDry20, String ifcDry40, String ifcDry40hc, String ifcDry45, String ifcRf40hc, String ifcRd40hc, String pscDry20, String pscDry40, String pscDry40hc, String pscDry45, String pscRf40hc, String pscRd40hc, String appBkgDirCallFlg, String appBkgTsPortDefCd, String appBkgSlanCd, String appBkgVvdCd, String chgRuleDefCd, String rtApplTpCd, String currCd, String bkgRatUtCdBl, String bkgRatUtCdCm, String bkgRatUtCdBx, String convBkgDirCallFlg, String convBkgTsPortDefCd, String convBkgSlanCd, String convBkgVvdCd, String payTermCd, String bkgYdCd, String bkgMinCgoWgt, String bkgMaxCgoWgt, String noteConvMapgId, String noteConvSeq, String noteConvTpCd, String effDt, String expDt, String n1stCmncAmdtSeq, String chgRuleTpCd, String noteConvChgCd, String noteConvRuleCd, String appBkgVslCd, String appBkgSkdVoyNo, String appBkgSkdDirCd, String appBkgTsPortTpCd, String convBkgVslCd, String convBkgSkdVoyNo, String convBkgSkdDirCd, String convBkgTsPortTpCd, String mstRfaRoutId, String srcInfoCd) {
		this.bucDry40 = bucDry40;
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
		this.pscDry45 = pscDry45;
		this.rateRd40hc = rateRd40hc;
		this.ifcDry45 = ifcDry45;
		this.bucDry20 = bucDry20;
		this.bucDry45 = bucDry45;
		this.bucDry40hc = bucDry40hc;
		this.pscDry20 = pscDry20;
		this.pscDry40 = pscDry40;
		this.pscRd40hc = pscRd40hc;
		this.ifcDry40 = ifcDry40;
		this.pagerows = pagerows;
		this.orgPrcTrspModNm = orgPrcTrspModNm;
		this.rateDry20 = rateDry20;
		this.rateDry45 = rateDry45;
		this.ibflag = ibflag;
		this.ifcDry40hc = ifcDry40hc;
		this.ifcRf40hc = ifcRf40hc;
		this.bucRd40hc = bucRd40hc;
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
		this.rateDry40 = rateDry40;
		this.prcCmdtDefNm = prcCmdtDefNm;
		this.prcCmdtDefCd = prcCmdtDefCd;
		this.bucRf40hc = bucRf40hc;
		this.ifcRd40hc = ifcRd40hc;
		this.pscRf40hc = pscRf40hc;
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
		this.custSeq = custSeq;
		this.custLglEngNm = custLglEngNm;
		this.rateDry40hc = rateDry40hc;
		this.orgRoutPntLocDefNm = orgRoutPntLocDefNm;
		this.routDpSeq = routDpSeq;
		this.cmdtDpSeq = cmdtDpSeq;
		this.rateRf40hc = rateRf40hc;
		this.pscDry40hc = pscDry40hc;
		this.ifcDry20 = ifcDry20;
		this.destPrcTrspModNm = destPrcTrspModNm;
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
		this.destRoutPntLocDefNm = destRoutPntLocDefNm;
		this.orgRcvDeTermNm = orgRcvDeTermNm;
		this.destRcvDeTermNm = destRcvDeTermNm;
		this.appBkgDirCallFlg = appBkgDirCallFlg;
	    this.appBkgTsPortDefCd = appBkgTsPortDefCd;
	    this.appBkgSlanCd = appBkgSlanCd;
	    this.appBkgVvdCd = appBkgVvdCd;
	    this.chgRuleDefCd = chgRuleDefCd;
	    this.rtApplTpCd = rtApplTpCd;
	    this.currCd = currCd;
	    this.bkgRatUtCdBl = bkgRatUtCdBl;
	    this.bkgRatUtCdCm = bkgRatUtCdCm;
	    this.bkgRatUtCdBx = bkgRatUtCdBx;
	    this.convBkgDirCallFlg = convBkgDirCallFlg;
	    this.convBkgTsPortDefCd = convBkgTsPortDefCd;
	    this.convBkgSlanCd = convBkgSlanCd;
	    this.convBkgVvdCd = convBkgVvdCd;
	    this.payTermCd = payTermCd;
	    this.bkgYdCd = bkgYdCd;
	    this.bkgMinCgoWgt = bkgMinCgoWgt;
	    this.bkgMaxCgoWgt = bkgMaxCgoWgt;
	    this.noteConvMapgId = noteConvMapgId;
	    this.noteConvSeq = noteConvSeq;
	    this.noteConvTpCd = noteConvTpCd;
	    this.effDt = effDt;
	    this.expDt = expDt;
	    this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
	    this.chgRuleTpCd = chgRuleTpCd;
	    this.noteConvChgCd = noteConvChgCd;
	    this.noteConvRuleCd = noteConvRuleCd;
	    this.appBkgVslCd = appBkgVslCd;
	    this.appBkgSkdVoyNo = appBkgSkdVoyNo;
	    this.appBkgSkdDirCd = appBkgSkdDirCd;
	    this.appBkgTsPortTpCd = appBkgTsPortTpCd;
	    this.convBkgVslCd = convBkgVslCd;
	    this.convBkgSkdVoyNo = convBkgSkdVoyNo;
	    this.convBkgSkdDirCd = convBkgSkdDirCd;
	    this.convBkgTsPortTpCd = convBkgTsPortTpCd;
	    this.mstRfaRoutId = mstRfaRoutId;
	    this.srcInfoCd = srcInfoCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("buc_dry40", getBucDry40());
		this.hashColumns.put("dest_rout_via_port_def_cd", getDestRoutViaPortDefCd());
		this.hashColumns.put("psc_dry45", getPscDry45());
		this.hashColumns.put("rate_rd40hc", getRateRd40hc());
		this.hashColumns.put("ifc_dry45", getIfcDry45());
		this.hashColumns.put("buc_dry20", getBucDry20());
		this.hashColumns.put("buc_dry45", getBucDry45());
		this.hashColumns.put("buc_dry40hc", getBucDry40hc());
		this.hashColumns.put("psc_dry20", getPscDry20());
		this.hashColumns.put("psc_dry40", getPscDry40());
		this.hashColumns.put("psc_rd40hc", getPscRd40hc());
		this.hashColumns.put("ifc_dry40", getIfcDry40());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("org_prc_trsp_mod_nm", getOrgPrcTrspModNm());
		this.hashColumns.put("rate_dry20", getRateDry20());
		this.hashColumns.put("rate_dry45", getRateDry45());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ifc_dry40hc", getIfcDry40hc());
		this.hashColumns.put("ifc_rf40hc", getIfcRf40hc());
		this.hashColumns.put("buc_rd40hc", getBucRd40hc());
		this.hashColumns.put("org_rout_via_port_def_cd", getOrgRoutViaPortDefCd());
		this.hashColumns.put("rate_dry40", getRateDry40());
		this.hashColumns.put("prc_cmdt_def_nm", getPrcCmdtDefNm());
		this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
		this.hashColumns.put("buc_rf40hc", getBucRf40hc());
		this.hashColumns.put("ifc_rd40hc", getIfcRd40hc());
		this.hashColumns.put("psc_rf40hc", getPscRf40hc());
		this.hashColumns.put("org_rout_pnt_loc_def_cd", getOrgRoutPntLocDefCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("rate_dry40hc", getRateDry40hc());
		this.hashColumns.put("org_rout_pnt_loc_def_nm", getOrgRoutPntLocDefNm());
		this.hashColumns.put("rout_dp_seq", getRoutDpSeq());
		this.hashColumns.put("cmdt_dp_seq", getCmdtDpSeq());
		this.hashColumns.put("rate_rf40hc", getRateRf40hc());
		this.hashColumns.put("psc_dry40hc", getPscDry40hc());
		this.hashColumns.put("ifc_dry20", getIfcDry20());
		this.hashColumns.put("dest_prc_trsp_mod_nm", getDestPrcTrspModNm());
		this.hashColumns.put("dest_rout_pnt_loc_def_cd", getDestRoutPntLocDefCd());
		this.hashColumns.put("dest_rout_pnt_loc_def_nm", getDestRoutPntLocDefNm());
		this.hashColumns.put("org_rcv_de_term_nm", getOrgRcvDeTermNm());
		this.hashColumns.put("dest_rcv_de_term_nm", getDestRcvDeTermNm());
		this.hashColumns.put("app_bkg_dir_call_flg", getAppBkgDirCallFlg());
	    this.hashColumns.put("app_bkg_ts_port_def_cd", getAppBkgTsPortDefCd());
	    this.hashColumns.put("app_bkg_slan_cd", getAppBkgSlanCd());
	    this.hashColumns.put("app_bkg_vvd_cd", getAppBkgVvdCd());
	    this.hashColumns.put("chg_rule_def_cd", getChgRuleDefCd());
	    this.hashColumns.put("rt_appl_tp_cd", getRtApplTpCd());
	    this.hashColumns.put("curr_cd", getCurrCd());
	    this.hashColumns.put("bkg_rat_ut_cd_bl", getBkgRatUtCdBl());
	    this.hashColumns.put("bkg_rat_ut_cd_cm", getBkgRatUtCdCm());
	    this.hashColumns.put("bkg_rat_ut_cd_bx", getBkgRatUtCdBx());
	    this.hashColumns.put("conv_bkg_dir_call_flg", getConvBkgDirCallFlg());
	    this.hashColumns.put("conv_bkg_ts_port_def_cd", getConvBkgTsPortDefCd());
	    this.hashColumns.put("conv_bkg_slan_cd", getConvBkgSlanCd());
	    this.hashColumns.put("conv_bkg_vvd_cd", getConvBkgVvdCd());
	    this.hashColumns.put("pay_term_cd", getPayTermCd());
	    this.hashColumns.put("bkg_yd_cd", getBkgYdCd());
	    this.hashColumns.put("bkg_min_cgo_wgt", getBkgMinCgoWgt());
	    this.hashColumns.put("bkg_max_cgo_wgt", getBkgMaxCgoWgt());
	    this.hashColumns.put("note_conv_mapg_id", getNoteConvMapgId());
	    this.hashColumns.put("note_conv_seq", getNoteConvSeq());
	    this.hashColumns.put("note_conv_tp_cd", getNoteConvTpCd());
	    this.hashColumns.put("eff_dt", getEffDt());
	    this.hashColumns.put("exp_dt", getExpDt());
	    this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
	    this.hashColumns.put("chg_rule_tp_cd", getChgRuleTpCd());
	    this.hashColumns.put("note_conv_chg_cd", getNoteConvChgCd());
	    this.hashColumns.put("note_conv_rule_cd", getNoteConvRuleCd());
	    this.hashColumns.put("app_bkg_vsl_cd", getAppBkgVslCd());
	    this.hashColumns.put("app_bkg_skd_voy_no", getAppBkgSkdVoyNo());
	    this.hashColumns.put("app_bkg_skd_dir_cd", getAppBkgSkdDirCd());
	    this.hashColumns.put("app_bkg_ts_port_tp_cd", getAppBkgTsPortTpCd());
	    this.hashColumns.put("conv_bkg_vsl_cd", getConvBkgVslCd());
	    this.hashColumns.put("conv_bkg_skd_voy_no", getConvBkgSkdVoyNo());
	    this.hashColumns.put("conv_bkg_skd_dir_cd", getConvBkgSkdDirCd());
	    this.hashColumns.put("conv_bkg_ts_port_tp_cd", getConvBkgTsPortTpCd());
	    this.hashColumns.put("mst_rfa_rout_id", getMstRfaRoutId());
	    this.hashColumns.put("src_info_cd", getSrcInfoCd());
	    
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("buc_dry40", "bucDry40");
		this.hashFields.put("dest_rout_via_port_def_cd", "destRoutViaPortDefCd");
		this.hashFields.put("psc_dry45", "pscDry45");
		this.hashFields.put("rate_rd40hc", "rateRd40hc");
		this.hashFields.put("ifc_dry45", "ifcDry45");
		this.hashFields.put("buc_dry20", "bucDry20");
		this.hashFields.put("buc_dry45", "bucDry45");
		this.hashFields.put("buc_dry40hc", "bucDry40hc");
		this.hashFields.put("psc_dry20", "pscDry20");
		this.hashFields.put("psc_dry40", "pscDry40");
		this.hashFields.put("psc_rd40hc", "pscRd40hc");
		this.hashFields.put("ifc_dry40", "ifcDry40");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("org_prc_trsp_mod_nm", "orgPrcTrspModNm");
		this.hashFields.put("rate_dry20", "rateDry20");
		this.hashFields.put("rate_dry45", "rateDry45");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ifc_dry40hc", "ifcDry40hc");
		this.hashFields.put("ifc_rf40hc", "ifcRf40hc");
		this.hashFields.put("buc_rd40hc", "bucRd40hc");
		this.hashFields.put("org_rout_via_port_def_cd", "orgRoutViaPortDefCd");
		this.hashFields.put("rate_dry40", "rateDry40");
		this.hashFields.put("prc_cmdt_def_nm", "prcCmdtDefNm");
		this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
		this.hashFields.put("buc_rf40hc", "bucRf40hc");
		this.hashFields.put("ifc_rd40hc", "ifcRd40hc");
		this.hashFields.put("psc_rf40hc", "pscRf40hc");
		this.hashFields.put("org_rout_pnt_loc_def_cd", "orgRoutPntLocDefCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("rate_dry40hc", "rateDry40hc");
		this.hashFields.put("org_rout_pnt_loc_def_nm", "orgRoutPntLocDefNm");
		this.hashFields.put("rout_dp_seq", "routDpSeq");
		this.hashFields.put("cmdt_dp_seq", "cmdtDpSeq");
		this.hashFields.put("rate_rf40hc", "rateRf40hc");
		this.hashFields.put("psc_dry40hc", "pscDry40hc");
		this.hashFields.put("ifc_dry20", "ifcDry20");
		this.hashFields.put("dest_prc_trsp_mod_nm", "destPrcTrspModNm");
		this.hashFields.put("dest_rout_pnt_loc_def_cd", "destRoutPntLocDefCd");
		this.hashFields.put("dest_rout_pnt_loc_def_nm", "destRoutPntLocDefNm");
		this.hashFields.put("org_rcv_de_term_nm", "orgRcvDeTermNm");
		this.hashFields.put("dest_rcv_de_term_nm", "destRcvDeTermNm");
		this.hashFields.put("app_bkg_dir_call_flg", "appBkgDirCallFlg");
		this.hashFields.put("app_bkg_ts_port_def_cd", "appBkgTsPortDefCd");
		this.hashFields.put("app_bkg_slan_cd", "appBkgSlanCd");
		this.hashFields.put("app_bkg_vvd_cd", "appBkgVvdCd");
		this.hashFields.put("chg_rule_def_cd", "chgRuleDefCd");
		this.hashFields.put("rt_appl_tp_cd", "rtApplTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("bkg_rat_ut_cd_bl", "bkgRatUtCdBl");
		this.hashFields.put("bkg_rat_ut_cd_cm", "bkgRatUtCdCm");
		this.hashFields.put("bkg_rat_ut_cd_bx", "bkgRatUtCdBx");		
		this.hashFields.put("conv_bkg_dir_call_flg", "convBkgDirCallFlg");
		this.hashFields.put("conv_bkg_ts_port_def_cd", "convBkgTsPortDefCd");
		this.hashFields.put("conv_bkg_slan_cd", "convBkgSlanCd");
		this.hashFields.put("conv_bkg_vvd_cd", "convBkgVvdCd");
		this.hashFields.put("pay_term_cd", "payTermCd");
		this.hashFields.put("bkg_yd_cd", "bkgYdCd");
		this.hashFields.put("bkg_min_cgo_wgt", "bkgMinCgoWgt");
		this.hashFields.put("bkg_max_cgo_wgt", "bkgMaxCgoWgt");
		this.hashFields.put("mst_rfa_rout_id", "mstRfaRoutId");
		this.hashFields.put("src_info_cd", "srcInfoCd");
				
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bucDry40
	 */
	public String getBucDry40() {
		return this.bucDry40;
	}
	
	/**
	 * Column Info
	 * @return destRoutViaPortDefCd
	 */
	public String getDestRoutViaPortDefCd() {
		return this.destRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return pscDry45
	 */
	public String getPscDry45() {
		return this.pscDry45;
	}
	
	/**
	 * Column Info
	 * @return rateRd40hc
	 */
	public String getRateRd40hc() {
		return this.rateRd40hc;
	}
	
	/**
	 * Column Info
	 * @return ifcDry45
	 */
	public String getIfcDry45() {
		return this.ifcDry45;
	}
	
	/**
	 * Column Info
	 * @return bucDry20
	 */
	public String getBucDry20() {
		return this.bucDry20;
	}
	
	/**
	 * Column Info
	 * @return bucDry45
	 */
	public String getBucDry45() {
		return this.bucDry45;
	}
	
	/**
	 * Column Info
	 * @return bucDry40hc
	 */
	public String getBucDry40hc() {
		return this.bucDry40hc;
	}
	
	/**
	 * Column Info
	 * @return pscDry20
	 */
	public String getPscDry20() {
		return this.pscDry20;
	}
	
	/**
	 * Column Info
	 * @return pscDry40
	 */
	public String getPscDry40() {
		return this.pscDry40;
	}
	
	/**
	 * Column Info
	 * @return pscRd40hc
	 */
	public String getPscRd40hc() {
		return this.pscRd40hc;
	}
	
	/**
	 * Column Info
	 * @return ifcDry40
	 */
	public String getIfcDry40() {
		return this.ifcDry40;
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
	 * @return orgPrcTrspModNm
	 */
	public String getOrgPrcTrspModNm() {
		return this.orgPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @return rateDry20
	 */
	public String getRateDry20() {
		return this.rateDry20;
	}
	
	/**
	 * Column Info
	 * @return rateDry45
	 */
	public String getRateDry45() {
		return this.rateDry45;
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
	 * @return ifcDry40hc
	 */
	public String getIfcDry40hc() {
		return this.ifcDry40hc;
	}
	
	/**
	 * Column Info
	 * @return ifcRf40hc
	 */
	public String getIfcRf40hc() {
		return this.ifcRf40hc;
	}
	
	/**
	 * Column Info
	 * @return bucRd40hc
	 */
	public String getBucRd40hc() {
		return this.bucRd40hc;
	}
	
	/**
	 * Column Info
	 * @return orgRoutViaPortDefCd
	 */
	public String getOrgRoutViaPortDefCd() {
		return this.orgRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return rateDry40
	 */
	public String getRateDry40() {
		return this.rateDry40;
	}
	
	/**
	 * Column Info
	 * @return prcCmdtDefNm
	 */
	public String getPrcCmdtDefNm() {
		return this.prcCmdtDefNm;
	}
	
	/**
	 * Column Info
	 * @return prcCmdtDefCd
	 */
	public String getPrcCmdtDefCd() {
		return this.prcCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @return bucRf40hc
	 */
	public String getBucRf40hc() {
		return this.bucRf40hc;
	}
	
	/**
	 * Column Info
	 * @return ifcRd40hc
	 */
	public String getIfcRd40hc() {
		return this.ifcRd40hc;
	}
	
	/**
	 * Column Info
	 * @return pscRf40hc
	 */
	public String getPscRf40hc() {
		return this.pscRf40hc;
	}
	
	/**
	 * Column Info
	 * @return orgRoutPntLocDefCd
	 */
	public String getOrgRoutPntLocDefCd() {
		return this.orgRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return rateDry40hc
	 */
	public String getRateDry40hc() {
		return this.rateDry40hc;
	}
	
	/**
	 * Column Info
	 * @return orgRoutPntLocDefNm
	 */
	public String getOrgRoutPntLocDefNm() {
		return this.orgRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @return routDpSeq
	 */
	public String getRoutDpSeq() {
		return this.routDpSeq;
	}
	
	/**
	 * Column Info
	 * @return cmdtDpSeq
	 */
	public String getCmdtDpSeq() {
		return this.cmdtDpSeq;
	}
	
	/**
	 * Column Info
	 * @return rateRf40hc
	 */
	public String getRateRf40hc() {
		return this.rateRf40hc;
	}
	
	/**
	 * Column Info
	 * @return pscDry40hc
	 */
	public String getPscDry40hc() {
		return this.pscDry40hc;
	}
	
	/**
	 * Column Info
	 * @return ifcDry20
	 */
	public String getIfcDry20() {
		return this.ifcDry20;
	}
	
	/**
	 * Column Info
	 * @return destPrcTrspModNm
	 */
	public String getDestPrcTrspModNm() {
		return this.destPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @return destRoutPntLocDefCd
	 */
	public String getDestRoutPntLocDefCd() {
		return this.destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return destRoutPntLocDefNm
	 */
	public String getDestRoutPntLocDefNm() {
		return this.destRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @return orgRcvDeTermNm
	 */
	public String getOrgRcvDeTermNm() {
		return this.orgRcvDeTermNm;
	}
	
	/**
	 * Column Info
	 * @return destRcvDeTermNm
	 */
	public String getDestRcvDeTermNm() {
		return this.destRcvDeTermNm;
	}
	

	/**
	 * Column Info
	 * @param bucDry40
	 */
	public void setBucDry40(String bucDry40) {
		this.bucDry40 = bucDry40;
	}
	
	/**
	 * Column Info
	 * @param destRoutViaPortDefCd
	 */
	public void setDestRoutViaPortDefCd(String destRoutViaPortDefCd) {
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param pscDry45
	 */
	public void setPscDry45(String pscDry45) {
		this.pscDry45 = pscDry45;
	}
	
	/**
	 * Column Info
	 * @param rateRd40hc
	 */
	public void setRateRd40hc(String rateRd40hc) {
		this.rateRd40hc = rateRd40hc;
	}
	
	/**
	 * Column Info
	 * @param ifcDry45
	 */
	public void setIfcDry45(String ifcDry45) {
		this.ifcDry45 = ifcDry45;
	}
	
	/**
	 * Column Info
	 * @param bucDry20
	 */
	public void setBucDry20(String bucDry20) {
		this.bucDry20 = bucDry20;
	}
	
	/**
	 * Column Info
	 * @param bucDry45
	 */
	public void setBucDry45(String bucDry45) {
		this.bucDry45 = bucDry45;
	}
	
	/**
	 * Column Info
	 * @param bucDry40hc
	 */
	public void setBucDry40hc(String bucDry40hc) {
		this.bucDry40hc = bucDry40hc;
	}
	
	/**
	 * Column Info
	 * @param pscDry20
	 */
	public void setPscDry20(String pscDry20) {
		this.pscDry20 = pscDry20;
	}
	
	/**
	 * Column Info
	 * @param pscDry40
	 */
	public void setPscDry40(String pscDry40) {
		this.pscDry40 = pscDry40;
	}
	
	/**
	 * Column Info
	 * @param pscRd40hc
	 */
	public void setPscRd40hc(String pscRd40hc) {
		this.pscRd40hc = pscRd40hc;
	}
	
	/**
	 * Column Info
	 * @param ifcDry40
	 */
	public void setIfcDry40(String ifcDry40) {
		this.ifcDry40 = ifcDry40;
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
	 * @param orgPrcTrspModNm
	 */
	public void setOrgPrcTrspModNm(String orgPrcTrspModNm) {
		this.orgPrcTrspModNm = orgPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @param rateDry20
	 */
	public void setRateDry20(String rateDry20) {
		this.rateDry20 = rateDry20;
	}
	
	/**
	 * Column Info
	 * @param rateDry45
	 */
	public void setRateDry45(String rateDry45) {
		this.rateDry45 = rateDry45;
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
	 * @param ifcDry40hc
	 */
	public void setIfcDry40hc(String ifcDry40hc) {
		this.ifcDry40hc = ifcDry40hc;
	}
	
	/**
	 * Column Info
	 * @param ifcRf40hc
	 */
	public void setIfcRf40hc(String ifcRf40hc) {
		this.ifcRf40hc = ifcRf40hc;
	}
	
	/**
	 * Column Info
	 * @param bucRd40hc
	 */
	public void setBucRd40hc(String bucRd40hc) {
		this.bucRd40hc = bucRd40hc;
	}
	
	/**
	 * Column Info
	 * @param orgRoutViaPortDefCd
	 */
	public void setOrgRoutViaPortDefCd(String orgRoutViaPortDefCd) {
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param rateDry40
	 */
	public void setRateDry40(String rateDry40) {
		this.rateDry40 = rateDry40;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtDefNm
	 */
	public void setPrcCmdtDefNm(String prcCmdtDefNm) {
		this.prcCmdtDefNm = prcCmdtDefNm;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtDefCd
	 */
	public void setPrcCmdtDefCd(String prcCmdtDefCd) {
		this.prcCmdtDefCd = prcCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @param bucRf40hc
	 */
	public void setBucRf40hc(String bucRf40hc) {
		this.bucRf40hc = bucRf40hc;
	}
	
	/**
	 * Column Info
	 * @param ifcRd40hc
	 */
	public void setIfcRd40hc(String ifcRd40hc) {
		this.ifcRd40hc = ifcRd40hc;
	}
	
	/**
	 * Column Info
	 * @param pscRf40hc
	 */
	public void setPscRf40hc(String pscRf40hc) {
		this.pscRf40hc = pscRf40hc;
	}
	
	/**
	 * Column Info
	 * @param orgRoutPntLocDefCd
	 */
	public void setOrgRoutPntLocDefCd(String orgRoutPntLocDefCd) {
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param rateDry40hc
	 */
	public void setRateDry40hc(String rateDry40hc) {
		this.rateDry40hc = rateDry40hc;
	}
	
	/**
	 * Column Info
	 * @param orgRoutPntLocDefNm
	 */
	public void setOrgRoutPntLocDefNm(String orgRoutPntLocDefNm) {
		this.orgRoutPntLocDefNm = orgRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @param routDpSeq
	 */
	public void setRoutDpSeq(String routDpSeq) {
		this.routDpSeq = routDpSeq;
	}
	
	/**
	 * Column Info
	 * @param cmdtDpSeq
	 */
	public void setCmdtDpSeq(String cmdtDpSeq) {
		this.cmdtDpSeq = cmdtDpSeq;
	}
	
	/**
	 * Column Info
	 * @param rateRf40hc
	 */
	public void setRateRf40hc(String rateRf40hc) {
		this.rateRf40hc = rateRf40hc;
	}
	
	/**
	 * Column Info
	 * @param pscDry40hc
	 */
	public void setPscDry40hc(String pscDry40hc) {
		this.pscDry40hc = pscDry40hc;
	}
	
	/**
	 * Column Info
	 * @param ifcDry20
	 */
	public void setIfcDry20(String ifcDry20) {
		this.ifcDry20 = ifcDry20;
	}
	
	/**
	 * Column Info
	 * @param destPrcTrspModNm
	 */
	public void setDestPrcTrspModNm(String destPrcTrspModNm) {
		this.destPrcTrspModNm = destPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @param destRoutPntLocDefCd
	 */
	public void setDestRoutPntLocDefCd(String destRoutPntLocDefCd) {
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param destRoutPntLocDefNm
	 */
	public void setDestRoutPntLocDefNm(String destRoutPntLocDefNm) {
		this.destRoutPntLocDefNm = destRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @param orgRcvDeTermNm
	 */
	public void setOrgRcvDeTermNm(String orgRcvDeTermNm) {
		this.orgRcvDeTermNm = orgRcvDeTermNm;
	}
	
	/**
	 * Column Info
	 * @param destRcvDeTermNm
	 */
	public void setDestRcvDeTermNm(String destRcvDeTermNm) {
		this.destRcvDeTermNm = destRcvDeTermNm;
	}
	
	/**
	 * Column Info
	 * @return appBkgDirCallFlg
	 */
	public String getAppBkgDirCallFlg() {
		return appBkgDirCallFlg;
	}

	/**
	 * Column Info
	 * @param appBkgDirCallFlg
	 */
	public void setAppBkgDirCallFlg(String appBkgDirCallFlg) {
		this.appBkgDirCallFlg = appBkgDirCallFlg;
	}

	/**
	 * Column Info
	 * @return appBkgTsPortDefCd
	 */
	public String getAppBkgTsPortDefCd() {
		return appBkgTsPortDefCd;
	}

	/**
	 * Column Info
	 * @param appBkgTsPortDefCd
	 */
	public void setAppBkgTsPortDefCd(String appBkgTsPortDefCd) {
		this.appBkgTsPortDefCd = appBkgTsPortDefCd;
	}

	/**
	 * Column Info
	 * @return appBkgSlanCd
	 */
	public String getAppBkgSlanCd() {
		return appBkgSlanCd;
	}

	/**
	 * Column Info
	 * @param appBkgSlanCd
	 */
	public void setAppBkgSlanCd(String appBkgSlanCd) {
		this.appBkgSlanCd = appBkgSlanCd;
	}

	/**
	 * Column Info
	 * @return appBkgVvdCd
	 */
	public String getAppBkgVvdCd() {
		return appBkgVvdCd;
	}

	/**
	 * Column Info
	 * @param appBkgVvdCd
	 */
	public void setAppBkgVvdCd(String appBkgVvdCd) {
		this.appBkgVvdCd = appBkgVvdCd;
	}

	/**
	 * Column Info
	 * @return chgRuleDefCd
	 */
	public String getChgRuleDefCd() {
		return chgRuleDefCd;
	}

	/**
	 * Column Info
	 * @param chgRuleDefCd
	 */
	public void setChgRuleDefCd(String chgRuleDefCd) {
		this.chgRuleDefCd = chgRuleDefCd;
	}

	/**
	 * Column Info
	 * @return rtApplTpCd
	 */
	public String getRtApplTpCd() {
		return rtApplTpCd;
	}

	/**
	 * Column Info
	 * @param rtApplTpCd
	 */
	public void setRtApplTpCd(String rtApplTpCd) {
		this.rtApplTpCd = rtApplTpCd;
	}

	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return currCd;
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
	 * @return bkgRatUtCdBl
	 */
	public String getBkgRatUtCdBl() {
		return bkgRatUtCdBl;
	}

	/**
	 * Column Info
	 * @param bkgRatUtCdBl
	 */
	public void setBkgRatUtCdBl(String bkgRatUtCdBl) {
		this.bkgRatUtCdBl = bkgRatUtCdBl;
	}

	/**
	 * Column Info
	 * @return bkgRatUtCdCm
	 */
	public String getBkgRatUtCdCm() {
		return bkgRatUtCdCm;
	}

	/**
	 * Column Info
	 * @param bkgRatUtCdCm
	 */
	public void setBkgRatUtCdCm(String bkgRatUtCdCm) {
		this.bkgRatUtCdCm = bkgRatUtCdCm;
	}

	/**
	 * Column Info
	 * @return bkgRatUtCdBx
	 */
	public String getBkgRatUtCdBx() {
		return bkgRatUtCdBx;
	}

	/**
	 * Column Info
	 * @param bkgRatUtCdBx
	 */
	public void setBkgRatUtCdBx(String bkgRatUtCdBx) {
		this.bkgRatUtCdBx = bkgRatUtCdBx;
	}

	/**
	 * Column Info
	 * @return convBkgDirCallFlg
	 */
	public String getConvBkgDirCallFlg() {
		return convBkgDirCallFlg;
	}

	/**
	 * Column Info
	 * @param convBkgDirCallFlg
	 */
	public void setConvBkgDirCallFlg(String convBkgDirCallFlg) {
		this.convBkgDirCallFlg = convBkgDirCallFlg;
	}

	/**
	 * Column Info
	 * @return convBkgTsPortDefCd
	 */
	public String getConvBkgTsPortDefCd() {
		return convBkgTsPortDefCd;
	}

	/**
	 * Column Info
	 * @param convBkgTsPortDefCd
	 */
	public void setConvBkgTsPortDefCd(String convBkgTsPortDefCd) {
		this.convBkgTsPortDefCd = convBkgTsPortDefCd;
	}

	/**
	 * Column Info
	 * @return convBkgSlanCd
	 */
	public String getConvBkgSlanCd() {
		return convBkgSlanCd;
	}

	/**
	 * Column Info
	 * @param convBkgSlanCd
	 */
	public void setConvBkgSlanCd(String convBkgSlanCd) {
		this.convBkgSlanCd = convBkgSlanCd;
	}

	/**
	 * Column Info
	 * @return convBkgVvdCd
	 */
	public String getConvBkgVvdCd() {
		return convBkgVvdCd;
	}

	/**
	 * Column Info
	 * @param convBkgVvdCd
	 */
	public void setConvBkgVvdCd(String convBkgVvdCd) {
		this.convBkgVvdCd = convBkgVvdCd;
	}

	/**
	 * Column Info
	 * @return payTermCd
	 */
	public String getPayTermCd() {
		return payTermCd;
	}

	/**
	 * Column Info
	 * @param payTermCd
	 */
	public void setPayTermCd(String payTermCd) {
		this.payTermCd = payTermCd;
	}

	/**
	 * Column Info
	 * @return bkgYdCd
	 */
	public String getBkgYdCd() {
		return bkgYdCd;
	}

	/**
	 * Column Info
	 * @param bkgYdCd
	 */
	public void setBkgYdCd(String bkgYdCd) {
		this.bkgYdCd = bkgYdCd;
	}

	/**
	 * Column Info
	 * @return bkgMinCgoWgt
	 */
	public String getBkgMinCgoWgt() {
		return bkgMinCgoWgt;
	}

	/**
	 * Column Info
	 * @param bkgMinCgoWgt
	 */
	public void setBkgMinCgoWgt(String bkgMinCgoWgt) {
		this.bkgMinCgoWgt = bkgMinCgoWgt;
	}

	/**
	 * Column Info
	 * @return bkgMaxCgoWgt
	 */
	public String getBkgMaxCgoWgt() {
		return bkgMaxCgoWgt;
	}

	/**
	 * Column Info
	 * @param bkgMaxCgoWgt
	 */
	public void setBkgMaxCgoWgt(String bkgMaxCgoWgt) {
		this.bkgMaxCgoWgt = bkgMaxCgoWgt;
	}
	
	/**
	 * Column Info
	 * @return noteConvMapgId
	 */
	public String getNoteConvMapgId() {
		return noteConvMapgId;
	}

	/**
	 * Column Info
	 * @param noteConvMapgId
	 */
	public void setNoteConvMapgId(String noteConvMapgId) {
		this.noteConvMapgId = noteConvMapgId;
	}

	/**
	 * Column Info
	 * @return noteConvSeq
	 */
	public String getNoteConvSeq() {
		return noteConvSeq;
	}

	/**
	 * Column Info
	 * @param noteConvSeq
	 */
	public void setNoteConvSeq(String noteConvSeq) {
		this.noteConvSeq = noteConvSeq;
	}

	/**
	 * Column Info
	 * @return noteConvTpCd
	 */
	public String getNoteConvTpCd() {
		return noteConvTpCd;
	}

	/**
	 * Column Info
	 * @param noteConvTpCd
	 */
	public void setNoteConvTpCd(String noteConvTpCd) {
		this.noteConvTpCd = noteConvTpCd;
	}

	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return effDt;
	}

	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}

	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return expDt;
	}

	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}

	/**
	 * Column Info
	 * @return n1stCmncAmdtSeq
	 */
	public String getN1stCmncAmdtSeq() {
		return n1stCmncAmdtSeq;
	}

	/**
	 * Column Info
	 * @param n1stCmncAmdtSeq
	 */
	public void setN1stCmncAmdtSeq(String n1stCmncAmdtSeq) {
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
	}

	/**
	 * Column Info
	 * @return chgRuleTpCd
	 */
	public String getChgRuleTpCd() {
		return chgRuleTpCd;
	}

	/**
	 * Column Info
	 * @param chgRuleTpCd
	 */
	public void setChgRuleTpCd(String chgRuleTpCd) {
		this.chgRuleTpCd = chgRuleTpCd;
	}

	/**
	 * Column Info
	 * @return noteConvChgCd
	 */
	public String getNoteConvChgCd() {
		return noteConvChgCd;
	}

	/**
	 * Column Info
	 * @param noteConvChgCd
	 */
	public void setNoteConvChgCd(String noteConvChgCd) {
		this.noteConvChgCd = noteConvChgCd;
	}

	/**
	 * Column Info
	 * @return noteConvRuleCd
	 */
	public String getNoteConvRuleCd() {
		return noteConvRuleCd;
	}

	/**
	 * Column Info
	 * @param noteConvRuleCd
	 */
	public void setNoteConvRuleCd(String noteConvRuleCd) {
		this.noteConvRuleCd = noteConvRuleCd;
	}

	/**
	 * Column Info
	 * @return appBkgVslCd
	 */
	public String getAppBkgVslCd() {
		return appBkgVslCd;
	}

	/**
	 * Column Info
	 * @param appBkgVslCd
	 */
	public void setAppBkgVslCd(String appBkgVslCd) {
		this.appBkgVslCd = appBkgVslCd;
	}

	/**
	 * Column Info
	 * @return appBkgSkdVoyNo
	 */
	public String getAppBkgSkdVoyNo() {
		return appBkgSkdVoyNo;
	}

	/**
	 * Column Info
	 * @param appBkgSkdVoyNo
	 */
	public void setAppBkgSkdVoyNo(String appBkgSkdVoyNo) {
		this.appBkgSkdVoyNo = appBkgSkdVoyNo;
	}

	/**
	 * Column Info
	 * @return appBkgSkdDirCd
	 */
	public String getAppBkgSkdDirCd() {
		return appBkgSkdDirCd;
	}

	/**
	 * Column Info
	 * @param appBkgSkdDirCd
	 */
	public void setAppBkgSkdDirCd(String appBkgSkdDirCd) {
		this.appBkgSkdDirCd = appBkgSkdDirCd;
	}

	/**
	 * Column Info
	 * @return appBkgTsPortTpCd
	 */
	public String getAppBkgTsPortTpCd() {
		return appBkgTsPortTpCd;
	}

	/**
	 * Column Info
	 * @param appBkgTsPortTpCd
	 */
	public void setAppBkgTsPortTpCd(String appBkgTsPortTpCd) {
		this.appBkgTsPortTpCd = appBkgTsPortTpCd;
	}

	/**
	 * Column Info
	 * @return convBkgVslCd
	 */
	public String getConvBkgVslCd() {
		return convBkgVslCd;
	}

	/**
	 * Column Info
	 * @param convBkgVslCd
	 */
	public void setConvBkgVslCd(String convBkgVslCd) {
		this.convBkgVslCd = convBkgVslCd;
	}

	/**
	 * Column Info
	 * @return convBkgSkdVoyNo
	 */
	public String getConvBkgSkdVoyNo() {
		return convBkgSkdVoyNo;
	}

	/**
	 * Column Info
	 * @param convBkgSkdVoyNo
	 */
	public void setConvBkgSkdVoyNo(String convBkgSkdVoyNo) {
		this.convBkgSkdVoyNo = convBkgSkdVoyNo;
	}

	/**
	 * Column Info
	 * @return convBkgSkdDirCd
	 */
	public String getConvBkgSkdDirCd() {
		return convBkgSkdDirCd;
	}

	/**
	 * Column Info
	 * @param convBkgSkdDirCd
	 */
	public void setConvBkgSkdDirCd(String convBkgSkdDirCd) {
		this.convBkgSkdDirCd = convBkgSkdDirCd;
	}

	/**
	 * Column Info
	 * @return convBkgTsPortTpCd
	 */
	public String getConvBkgTsPortTpCd() {
		return convBkgTsPortTpCd;
	}

	/**
	 * Column Info
	 * @param convBkgTsPortTpCd
	 */
	public void setConvBkgTsPortTpCd(String convBkgTsPortTpCd) {
		this.convBkgTsPortTpCd = convBkgTsPortTpCd;
	}
	
	/**
	 * Column Info
	 * @return mstRfaRoutId
	 */
	public String getMstRfaRoutId() {
		return mstRfaRoutId;
	}

	/**
	 * Column Info
	 * @param mstRfaRoutId
	 */
	public void setMstRfaRoutId(String mstRfaRoutId) {
		this.mstRfaRoutId = mstRfaRoutId;
	}

	/**
	 * Column Info
	 * @return srcInfoCd
	 */
	public String getSrcInfoCd() {
		return srcInfoCd;
	}

	/**
	 * Column Info
	 * @param srcInfoCd
	 */
	public void setSrcInfoCd(String srcInfoCd) {
		this.srcInfoCd = srcInfoCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBucDry40(JSPUtil.getParameter(request, "buc_dry40", ""));
		setDestRoutViaPortDefCd(JSPUtil.getParameter(request, "dest_rout_via_port_def_cd", ""));
		setPscDry45(JSPUtil.getParameter(request, "psc_dry45", ""));
		setRateRd40hc(JSPUtil.getParameter(request, "rate_rd40hc", ""));
		setIfcDry45(JSPUtil.getParameter(request, "ifc_dry45", ""));
		setBucDry20(JSPUtil.getParameter(request, "buc_dry20", ""));
		setBucDry45(JSPUtil.getParameter(request, "buc_dry45", ""));
		setBucDry40hc(JSPUtil.getParameter(request, "buc_dry40hc", ""));
		setPscDry20(JSPUtil.getParameter(request, "psc_dry20", ""));
		setPscDry40(JSPUtil.getParameter(request, "psc_dry40", ""));
		setPscRd40hc(JSPUtil.getParameter(request, "psc_rd40hc", ""));
		setIfcDry40(JSPUtil.getParameter(request, "ifc_dry40", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOrgPrcTrspModNm(JSPUtil.getParameter(request, "org_prc_trsp_mod_nm", ""));
		setRateDry20(JSPUtil.getParameter(request, "rate_dry20", ""));
		setRateDry45(JSPUtil.getParameter(request, "rate_dry45", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIfcDry40hc(JSPUtil.getParameter(request, "ifc_dry40hc", ""));
		setIfcRf40hc(JSPUtil.getParameter(request, "ifc_rf40hc", ""));
		setBucRd40hc(JSPUtil.getParameter(request, "buc_rd40hc", ""));
		setOrgRoutViaPortDefCd(JSPUtil.getParameter(request, "org_rout_via_port_def_cd", ""));
		setRateDry40(JSPUtil.getParameter(request, "rate_dry40", ""));
		setPrcCmdtDefNm(JSPUtil.getParameter(request, "prc_cmdt_def_nm", ""));
		setPrcCmdtDefCd(JSPUtil.getParameter(request, "prc_cmdt_def_cd", ""));
		setBucRf40hc(JSPUtil.getParameter(request, "buc_rf40hc", ""));
		setIfcRd40hc(JSPUtil.getParameter(request, "ifc_rd40hc", ""));
		setPscRf40hc(JSPUtil.getParameter(request, "psc_rf40hc", ""));
		setOrgRoutPntLocDefCd(JSPUtil.getParameter(request, "org_rout_pnt_loc_def_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, "cust_lgl_eng_nm", ""));
		setRateDry40hc(JSPUtil.getParameter(request, "rate_dry40hc", ""));
		setOrgRoutPntLocDefNm(JSPUtil.getParameter(request, "org_rout_pnt_loc_def_nm", ""));
		setRoutDpSeq(JSPUtil.getParameter(request, "rout_dp_seq", ""));
		setCmdtDpSeq(JSPUtil.getParameter(request, "cmdt_dp_seq", ""));
		setRateRf40hc(JSPUtil.getParameter(request, "rate_rf40hc", ""));
		setPscDry40hc(JSPUtil.getParameter(request, "psc_dry40hc", ""));
		setIfcDry20(JSPUtil.getParameter(request, "ifc_dry20", ""));
		setDestPrcTrspModNm(JSPUtil.getParameter(request, "dest_prc_trsp_mod_nm", ""));
		setDestRoutPntLocDefCd(JSPUtil.getParameter(request, "dest_rout_pnt_loc_def_cd", ""));
		setDestRoutPntLocDefNm(JSPUtil.getParameter(request, "dest_rout_pnt_loc_def_nm", ""));
		setOrgRcvDeTermNm(JSPUtil.getParameter(request, "org_rcv_de_term_nm", ""));
		setDestRcvDeTermNm(JSPUtil.getParameter(request, "dest_rcv_de_term_nm", ""));
		setAppBkgDirCallFlg(JSPUtil.getParameter(request, "app_bkg_dir_call_flg", ""));
	    setAppBkgTsPortDefCd(JSPUtil.getParameter(request, "app_bkg_ts_port_def_cd", ""));
	    setAppBkgSlanCd(JSPUtil.getParameter(request, "app_bkg_slan_cd", ""));
	    setAppBkgVvdCd(JSPUtil.getParameter(request, "app_bkg_vvd_cd", ""));
	    setChgRuleDefCd(JSPUtil.getParameter(request, "chg_rule_def_cd", ""));
	    setRtApplTpCd(JSPUtil.getParameter(request, "rt_appl_tp_cd", ""));
	    setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
	    setBkgRatUtCdBl(JSPUtil.getParameter(request, "bkg_rat_ut_cd_bl", ""));
	    setBkgRatUtCdCm(JSPUtil.getParameter(request, "bkg_rat_ut_cd_cm", ""));
	    setBkgRatUtCdBx(JSPUtil.getParameter(request, "bkg_rat_ut_cd_bx", ""));
	    setConvBkgDirCallFlg(JSPUtil.getParameter(request, "conv_bkg_dir_call_flg", ""));
	    setConvBkgTsPortDefCd(JSPUtil.getParameter(request, "conv_bkg_ts_port_def_cd", ""));
	    setConvBkgSlanCd(JSPUtil.getParameter(request, "conv_bkg_slan_cd", ""));
	    setConvBkgVvdCd(JSPUtil.getParameter(request, "conv_bkg_vvd_cd", ""));
	    setPayTermCd(JSPUtil.getParameter(request, "pay_term_cd", ""));
	    setBkgYdCd(JSPUtil.getParameter(request, "bkg_yd_cd", ""));
	    setBkgMinCgoWgt(JSPUtil.getParameter(request, "bkg_min_cgo_wgt", ""));
	    setBkgMaxCgoWgt(JSPUtil.getParameter(request, "bkg_max_cgo_wgt", ""));
		setNoteConvMapgId(JSPUtil.getParameter(request, "note_conv_mapg_id", ""));
	    setNoteConvSeq(JSPUtil.getParameter(request, "note_conv_seq", ""));
	    setNoteConvTpCd(JSPUtil.getParameter(request, "note_conv_tp_cd", ""));
	    setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
	    setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
	    setN1stCmncAmdtSeq(JSPUtil.getParameter(request, "n1st_cmnc_amdt_seq", ""));
	    setChgRuleTpCd(JSPUtil.getParameter(request, "chg_rule_tp_cd", ""));
	    setNoteConvChgCd(JSPUtil.getParameter(request, "note_conv_chg_cd", ""));
	    setNoteConvRuleCd(JSPUtil.getParameter(request, "note_conv_rule_cd", ""));
	    setAppBkgVslCd(JSPUtil.getParameter(request, "app_bkg_vsl_cd", ""));
	    setAppBkgSkdVoyNo(JSPUtil.getParameter(request, "app_bkg_skd_voy_no", ""));
	    setAppBkgSkdDirCd(JSPUtil.getParameter(request, "app_bkg_skd_dir_cd", ""));
	    setAppBkgTsPortTpCd(JSPUtil.getParameter(request, "app_bkg_ts_port_tp_cd", ""));
	    setConvBkgVslCd(JSPUtil.getParameter(request, "conv_bkg_vsl_cd", ""));
	    setConvBkgSkdVoyNo(JSPUtil.getParameter(request, "conv_bkg_skd_voy_no", ""));
	    setConvBkgSkdDirCd(JSPUtil.getParameter(request, "conv_bkg_skd_dir_cd", ""));
	    setConvBkgTsPortTpCd(JSPUtil.getParameter(request, "conv_bkg_ts_port_tp_cd", ""));
	    setMstRfaRoutId(JSPUtil.getParameter(request, "mst_rfa_rout_id", ""));
	    setSrcInfoCd(JSPUtil.getParameter(request, "src_info_cd", ""));	    
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltRtListHorizontalExcelVO[]
	 */
	public RsltRtListHorizontalExcelVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltRtListHorizontalExcelVO[]
	 */
	public RsltRtListHorizontalExcelVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRtListHorizontalExcelVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bucDry40 = (JSPUtil.getParameter(request, prefix	+ "buc_dry40", length));
			String[] destRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_via_port_def_cd", length));
			String[] pscDry45 = (JSPUtil.getParameter(request, prefix	+ "psc_dry45", length));
			String[] rateRd40hc = (JSPUtil.getParameter(request, prefix	+ "rate_rd40hc", length));
			String[] ifcDry45 = (JSPUtil.getParameter(request, prefix	+ "ifc_dry45", length));
			String[] bucDry20 = (JSPUtil.getParameter(request, prefix	+ "buc_dry20", length));
			String[] bucDry45 = (JSPUtil.getParameter(request, prefix	+ "buc_dry45", length));
			String[] bucDry40hc = (JSPUtil.getParameter(request, prefix	+ "buc_dry40hc", length));
			String[] pscDry20 = (JSPUtil.getParameter(request, prefix	+ "psc_dry20", length));
			String[] pscDry40 = (JSPUtil.getParameter(request, prefix	+ "psc_dry40", length));
			String[] pscRd40hc = (JSPUtil.getParameter(request, prefix	+ "psc_rd40hc", length));
			String[] ifcDry40 = (JSPUtil.getParameter(request, prefix	+ "ifc_dry40", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] orgPrcTrspModNm = (JSPUtil.getParameter(request, prefix	+ "org_prc_trsp_mod_nm", length));
			String[] rateDry20 = (JSPUtil.getParameter(request, prefix	+ "rate_dry20", length));
			String[] rateDry45 = (JSPUtil.getParameter(request, prefix	+ "rate_dry45", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ifcDry40hc = (JSPUtil.getParameter(request, prefix	+ "ifc_dry40hc", length));
			String[] ifcRf40hc = (JSPUtil.getParameter(request, prefix	+ "ifc_rf40hc", length));
			String[] bucRd40hc = (JSPUtil.getParameter(request, prefix	+ "buc_rd40hc", length));
			String[] orgRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_via_port_def_cd", length));
			String[] rateDry40 = (JSPUtil.getParameter(request, prefix	+ "rate_dry40", length));
			String[] prcCmdtDefNm = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_nm", length));
			String[] prcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_cd", length));
			String[] bucRf40hc = (JSPUtil.getParameter(request, prefix	+ "buc_rf40hc", length));
			String[] ifcRd40hc = (JSPUtil.getParameter(request, prefix	+ "ifc_rd40hc", length));
			String[] pscRf40hc = (JSPUtil.getParameter(request, prefix	+ "psc_rf40hc", length));
			String[] orgRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] rateDry40hc = (JSPUtil.getParameter(request, prefix	+ "rate_dry40hc", length));
			String[] orgRoutPntLocDefNm = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_nm", length));
			String[] routDpSeq = (JSPUtil.getParameter(request, prefix	+ "rout_dp_seq", length));
			String[] cmdtDpSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_dp_seq", length));
			String[] rateRf40hc = (JSPUtil.getParameter(request, prefix	+ "rate_rf40hc", length));
			String[] pscDry40hc = (JSPUtil.getParameter(request, prefix	+ "psc_dry40hc", length));
			String[] ifcDry20 = (JSPUtil.getParameter(request, prefix	+ "ifc_dry20", length));
			String[] destPrcTrspModNm = (JSPUtil.getParameter(request, prefix	+ "dest_prc_trsp_mod_nm", length));
			String[] destRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_cd", length));
			String[] destRoutPntLocDefNm = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_nm", length));
			String[] orgRcvDeTermNm = (JSPUtil.getParameter(request, prefix	+ "org_rcv_de_term_nm", length));
			String[] destRcvDeTermNm = (JSPUtil.getParameter(request, prefix	+ "dest_rcv_de_term_nm", length));
			String[] appBkgDirCallFlg = (JSPUtil.getParameter(request, prefix	+ "app_bkg_dir_call_flg", length));
		    String[] appBkgTsPortDefCd = (JSPUtil.getParameter(request, prefix	+ "app_bkg_ts_port_def_cd", length));
		    String[] appBkgSlanCd = (JSPUtil.getParameter(request, prefix	+ "app_bkg_slan_cd", length));
		    String[] appBkgVvdCd = (JSPUtil.getParameter(request, prefix	+ "app_bkg_vvd_cd", length));
		    String[] chgRuleDefCd = (JSPUtil.getParameter(request, prefix	+ "chg_rule_def_cd", length));
		    String[] rtApplTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_appl_tp_cd", length));
		    String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
		    String[] bkgRatUtCdBl = (JSPUtil.getParameter(request, prefix	+ "bkg_rat_ut_cd_bl", length));
		    String[] bkgRatUtCdCm = (JSPUtil.getParameter(request, prefix	+ "bkg_rat_ut_cd_cm", length));
		    String[] bkgRatUtCdBx = (JSPUtil.getParameter(request, prefix	+ "bkg_rat_ut_cd_bx", length));
		    String[] convBkgDirCallFlg = (JSPUtil.getParameter(request, prefix	+ "conv_bkg_dir_call_flg", length));
		    String[] convBkgTsPortDefCd = (JSPUtil.getParameter(request, prefix	+ "conv_bkg_ts_port_def_cd", length));
		    String[] convBkgSlanCd = (JSPUtil.getParameter(request, prefix	+ "conv_bkg_slan_cd", length));
		    String[] convBkgVvdCd = (JSPUtil.getParameter(request, prefix	+ "conv_bkg_vvd_cd", length));
		    String[] payTermCd = (JSPUtil.getParameter(request, prefix	+ "pay_term_cd", length));
		    String[] bkgYdCd = (JSPUtil.getParameter(request, prefix	+ "bkg_yd_cd", length));
		    String[] bkgMinCgoWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_min_cgo_wgt", length));
		    String[] bkgMaxCgoWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_max_cgo_wgt", length));
		    String[] noteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "note_conv_mapg_id", length));
		    String[] noteConvSeq = (JSPUtil.getParameter(request, prefix	+ "note_conv_seq", length));
		    String[] noteConvTpCd = (JSPUtil.getParameter(request, prefix	+ "note_conv_tp_cd", length));
		    String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));	
		    String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));	
		    String[] n1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_amdt_seq", length));
		    String[] chgRuleTpCd = (JSPUtil.getParameter(request, prefix	+ "chg_rule_tp_cd", length));
		    String[] noteConvChgCd = (JSPUtil.getParameter(request, prefix	+ "note_conv_chg_cd", length));
		    String[] noteConvRuleCd = (JSPUtil.getParameter(request, prefix	+ "note_conv_rule_cd", length));
		    String[] appBkgVslCd = (JSPUtil.getParameter(request, prefix	+ "app_bkg_vsl_cd", length));
		    String[] appBkgSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "app_bkg_skd_voy_no", length));
		    String[] appBkgSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "app_bkg_skd_dir_cd", length));
		    String[] appBkgTsPortTpCd = (JSPUtil.getParameter(request, prefix	+ "app_bkg_ts_port_tp_cd", length));
		    String[] convBkgVslCd = (JSPUtil.getParameter(request, prefix	+ "conv_bkg_vsl_cd", length));
		    String[] convBkgSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "conv_bkg_skd_voy_no", length));
		    String[] convBkgSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "conv_bkg_skd_dir_cd", length));
		    String[] convBkgTsPortTpCd = (JSPUtil.getParameter(request, prefix	+ "conv_bkg_ts_port_tp_cd", length));
		    String[] mstRfaRoutId = (JSPUtil.getParameter(request, prefix	+ "mst_rfa_rout_id", length));
		    String[] srcInfoCd = (JSPUtil.getParameter(request, prefix	+ "src_info_cd", length));
		    		    
			for (int i = 0; i < length; i++) {
				model = new RsltRtListHorizontalExcelVO();
				if (bucDry40[i] != null)
					model.setBucDry40(bucDry40[i]);
				if (destRoutViaPortDefCd[i] != null)
					model.setDestRoutViaPortDefCd(destRoutViaPortDefCd[i]);
				if (pscDry45[i] != null)
					model.setPscDry45(pscDry45[i]);
				if (rateRd40hc[i] != null)
					model.setRateRd40hc(rateRd40hc[i]);
				if (ifcDry45[i] != null)
					model.setIfcDry45(ifcDry45[i]);
				if (bucDry20[i] != null)
					model.setBucDry20(bucDry20[i]);
				if (bucDry45[i] != null)
					model.setBucDry45(bucDry45[i]);
				if (bucDry40hc[i] != null)
					model.setBucDry40hc(bucDry40hc[i]);
				if (pscDry20[i] != null)
					model.setPscDry20(pscDry20[i]);
				if (pscDry40[i] != null)
					model.setPscDry40(pscDry40[i]);
				if (pscRd40hc[i] != null)
					model.setPscRd40hc(pscRd40hc[i]);
				if (ifcDry40[i] != null)
					model.setIfcDry40(ifcDry40[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (orgPrcTrspModNm[i] != null)
					model.setOrgPrcTrspModNm(orgPrcTrspModNm[i]);
				if (rateDry20[i] != null)
					model.setRateDry20(rateDry20[i]);
				if (rateDry45[i] != null)
					model.setRateDry45(rateDry45[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ifcDry40hc[i] != null)
					model.setIfcDry40hc(ifcDry40hc[i]);
				if (ifcRf40hc[i] != null)
					model.setIfcRf40hc(ifcRf40hc[i]);
				if (bucRd40hc[i] != null)
					model.setBucRd40hc(bucRd40hc[i]);
				if (orgRoutViaPortDefCd[i] != null)
					model.setOrgRoutViaPortDefCd(orgRoutViaPortDefCd[i]);
				if (rateDry40[i] != null)
					model.setRateDry40(rateDry40[i]);
				if (prcCmdtDefNm[i] != null)
					model.setPrcCmdtDefNm(prcCmdtDefNm[i]);
				if (prcCmdtDefCd[i] != null)
					model.setPrcCmdtDefCd(prcCmdtDefCd[i]);
				if (bucRf40hc[i] != null)
					model.setBucRf40hc(bucRf40hc[i]);
				if (ifcRd40hc[i] != null)
					model.setIfcRd40hc(ifcRd40hc[i]);
				if (pscRf40hc[i] != null)
					model.setPscRf40hc(pscRf40hc[i]);
				if (orgRoutPntLocDefCd[i] != null)
					model.setOrgRoutPntLocDefCd(orgRoutPntLocDefCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (rateDry40hc[i] != null)
					model.setRateDry40hc(rateDry40hc[i]);
				if (orgRoutPntLocDefNm[i] != null)
					model.setOrgRoutPntLocDefNm(orgRoutPntLocDefNm[i]);
				if (routDpSeq[i] != null)
					model.setRoutDpSeq(routDpSeq[i]);
				if (cmdtDpSeq[i] != null)
					model.setCmdtDpSeq(cmdtDpSeq[i]);
				if (rateRf40hc[i] != null)
					model.setRateRf40hc(rateRf40hc[i]);
				if (pscDry40hc[i] != null)
					model.setPscDry40hc(pscDry40hc[i]);
				if (ifcDry20[i] != null)
					model.setIfcDry20(ifcDry20[i]);
				if (destPrcTrspModNm[i] != null)
					model.setDestPrcTrspModNm(destPrcTrspModNm[i]);
				if (destRoutPntLocDefCd[i] != null)
					model.setDestRoutPntLocDefCd(destRoutPntLocDefCd[i]);
				if (destRoutPntLocDefNm[i] != null)
					model.setDestRoutPntLocDefNm(destRoutPntLocDefNm[i]);
				if (orgRcvDeTermNm[i] != null)
					model.setOrgRcvDeTermNm(orgRcvDeTermNm[i]);
				if (destRcvDeTermNm[i] != null)
					model.setDestRcvDeTermNm(destRcvDeTermNm[i]);
				if (appBkgDirCallFlg[i] != null)
					model.setAppBkgDirCallFlg(appBkgDirCallFlg[i]);
				if (appBkgTsPortDefCd[i] != null)
					model.setAppBkgTsPortDefCd(appBkgTsPortDefCd[i]);	
				if (appBkgSlanCd[i] != null)
					model.setAppBkgSlanCd(appBkgSlanCd[i]);
				if (appBkgVvdCd[i] != null)
					model.setAppBkgVvdCd(appBkgVvdCd[i]);
				if (chgRuleDefCd[i] != null)
					model.setChgRuleDefCd(chgRuleDefCd[i]);
				if (rtApplTpCd[i] != null)
					model.setRtApplTpCd(rtApplTpCd[i]);	
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (bkgRatUtCdBl[i] != null)
					model.setBkgRatUtCdBl(bkgRatUtCdBl[i]);
				if (bkgRatUtCdCm[i] != null)
					model.setBkgRatUtCdCm(bkgRatUtCdCm[i]);
				if (bkgRatUtCdBx[i] != null)
					model.setBkgRatUtCdBx(bkgRatUtCdBx[i]);	
				if (convBkgDirCallFlg[i] != null)
					model.setConvBkgDirCallFlg(convBkgDirCallFlg[i]);
				if (convBkgTsPortDefCd[i] != null)
					model.setConvBkgTsPortDefCd(convBkgTsPortDefCd[i]);
				if (convBkgSlanCd[i] != null)
					model.setConvBkgSlanCd(convBkgSlanCd[i]);
				if (convBkgVvdCd[i] != null)
					model.setConvBkgVvdCd(convBkgVvdCd[i]);	
				if (payTermCd[i] != null)
					model.setPayTermCd(payTermCd[i]);
				if (bkgYdCd[i] != null)
					model.setBkgYdCd(bkgYdCd[i]);	
				if (bkgMinCgoWgt[i] != null)
					model.setBkgMinCgoWgt(bkgMinCgoWgt[i]);
				if (bkgMaxCgoWgt[i] != null)
					model.setBkgMaxCgoWgt(bkgMaxCgoWgt[i]);
				if (noteConvMapgId[i] != null)
					model.setNoteConvMapgId(noteConvMapgId[i]);
				if (noteConvSeq[i] != null)
					model.setNoteConvSeq(noteConvSeq[i]);
				if (noteConvTpCd[i] != null)
					model.setNoteConvTpCd(noteConvTpCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (n1stCmncAmdtSeq[i] != null)
					model.setN1stCmncAmdtSeq(n1stCmncAmdtSeq[i]);
				if (chgRuleTpCd[i] != null)
					model.setChgRuleTpCd(chgRuleTpCd[i]);
				if (noteConvChgCd[i] != null)
					model.setNoteConvChgCd(noteConvChgCd[i]);
				if (noteConvRuleCd[i] != null)
					model.setNoteConvRuleCd(noteConvRuleCd[i]);
				if (appBkgVslCd[i] != null)
					model.setAppBkgVslCd(appBkgVslCd[i]);
				if (appBkgSkdVoyNo[i] != null)
					model.setAppBkgSkdVoyNo(appBkgSkdVoyNo[i]);
				if (appBkgSkdDirCd[i] != null)
					model.setAppBkgSkdDirCd(appBkgSkdDirCd[i]);
				if (appBkgTsPortTpCd[i] != null)
					model.setAppBkgTsPortTpCd(appBkgTsPortTpCd[i]);
				if (convBkgVslCd[i] != null)
					model.setConvBkgVslCd(convBkgVslCd[i]);
				if (convBkgSkdVoyNo[i] != null)
					model.setConvBkgSkdVoyNo(convBkgSkdVoyNo[i]);
				if (convBkgSkdDirCd[i] != null)
					model.setConvBkgSkdDirCd(convBkgSkdDirCd[i]);
				if (convBkgTsPortTpCd[i] != null)
					model.setConvBkgTsPortTpCd(convBkgTsPortTpCd[i]);
				if (mstRfaRoutId[i] != null)
					model.setMstRfaRoutId(mstRfaRoutId[i]);
				if (srcInfoCd[i] != null)
					model.setSrcInfoCd(srcInfoCd[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltRtListHorizontalExcelVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltRtListHorizontalExcelVO[]
	 */
	public RsltRtListHorizontalExcelVO[] getRsltRtListHorizontalExcelVOs(){
		RsltRtListHorizontalExcelVO[] vos = (RsltRtListHorizontalExcelVO[])models.toArray(new RsltRtListHorizontalExcelVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.bucDry40 = this.bucDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutViaPortDefCd = this.destRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pscDry45 = this.pscDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateRd40hc = this.rateRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifcDry45 = this.ifcDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bucDry20 = this.bucDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bucDry45 = this.bucDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bucDry40hc = this.bucDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pscDry20 = this.pscDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pscDry40 = this.pscDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pscRd40hc = this.pscRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifcDry40 = this.ifcDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPrcTrspModNm = this.orgPrcTrspModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateDry20 = this.rateDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateDry45 = this.rateDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifcDry40hc = this.ifcDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifcRf40hc = this.ifcRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bucRd40hc = this.bucRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortDefCd = this.orgRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateDry40 = this.rateDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefNm = this.prcCmdtDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefCd = this.prcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bucRf40hc = this.bucRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifcRd40hc = this.ifcRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pscRf40hc = this.pscRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefCd = this.orgRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateDry40hc = this.rateDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefNm = this.orgRoutPntLocDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDpSeq = this.routDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDpSeq = this.cmdtDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateRf40hc = this.rateRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pscDry40hc = this.pscDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifcDry20 = this.ifcDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destPrcTrspModNm = this.destPrcTrspModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefCd = this.destRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefNm = this.destRoutPntLocDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRcvDeTermNm = this.orgRcvDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRcvDeTermNm = this.destRcvDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.appBkgDirCallFlg = this.appBkgDirCallFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.appBkgTsPortDefCd = this.appBkgTsPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.appBkgSlanCd = this.appBkgSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.appBkgVvdCd = this.appBkgVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.chgRuleDefCd = this.chgRuleDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.rtApplTpCd = this.rtApplTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.bkgRatUtCdBl = this.bkgRatUtCdBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.bkgRatUtCdCm = this.bkgRatUtCdCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.bkgRatUtCdBx = this.bkgRatUtCdBx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.convBkgDirCallFlg = this.convBkgDirCallFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.convBkgTsPortDefCd = this.convBkgTsPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.convBkgSlanCd = this.convBkgSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.convBkgVvdCd = this.convBkgVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.payTermCd = this.payTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.bkgYdCd = this.bkgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.bkgMinCgoWgt = this.bkgMinCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.bkgMaxCgoWgt = this.bkgMaxCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.noteConvMapgId = this.noteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.noteConvSeq = this.noteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.noteConvTpCd = this.noteConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
	    this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
	    this.n1stCmncAmdtSeq = this.n1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.chgRuleTpCd = this.chgRuleTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.noteConvChgCd = this.noteConvChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.noteConvRuleCd = this.noteConvRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.appBkgVslCd = this.appBkgVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.appBkgSkdVoyNo = this.appBkgSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.appBkgSkdDirCd = this.appBkgSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.appBkgTsPortTpCd = this.appBkgTsPortTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.convBkgVslCd = this.convBkgVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.convBkgSkdVoyNo = this.convBkgSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.convBkgSkdDirCd = this.convBkgSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.convBkgTsPortTpCd = this.convBkgTsPortTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.mstRfaRoutId = this.mstRfaRoutId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.srcInfoCd = this.srcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	    
	}
}
