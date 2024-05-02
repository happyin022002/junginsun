/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VoyagePerformanceVO.java
*@FileTitle : VoyagePerformanceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.09
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.09  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class VoyagePerformanceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VoyagePerformanceVO> models = new ArrayList<VoyagePerformanceVO>();
	
	/* Column Info */
	private String csmDailyFocStd = null;
	/* Column Info */
	private String cgoOnboardWgt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cgoBsaAllianceQty = null;
	/* Column Info */
	private String fmYdCd = null;
	/* Column Info */
	private String toYdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cgoBsaHjsQty = null;
	/* Column Info */
	private String csmDailyFocTLine = null;
	/* Column Info */
	private String vslSts = null;
	/* Column Info */
	private String optFwdTrim = null;
	/* Column Info */
	private String cgoOnboardTeuQty = null;
	/* Column Info */
	private String currDt = null;
	/* Column Info */
	private String optAftTrim = null;
	/* Column Info */
	private String signalSkedIdx = null;
	/* Column Info */
	private String optTrmImg = null;
	/* Column Info */
	private String naviNoonDist = null;
	/* Column Info */
	private String cgoVolLdbQty = null;
	/* Column Info */
	private String signalNaviIdx = null;
	/* Column Info */
	private String naviNoonSlip = null;
	/* Column Info */
	private String optTrsmHgt = null;
	/* Column Info */
	private String naviPpsSpd = null;
	/* Column Info */
	private String csmDailyFocNoon = null;
	/* Column Info */
	private String csmFromAchPercentage = null;
	/* Column Info */
	private String cgoLfAllianceQty = null;
	/* Column Info */
	private String cgoTotalLfRatio = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String txtIdx = null;
	/* Column Info */
	private String cgoToGrossProd = null;
	/* Column Info */
	private String cntrDznCapa = null;
	/* Column Info */
	private String cgoBbQty = null;
	/* Column Info */
	private String csmDailyFocPps = null;
	/* Column Info */
	private String csmFocRpt = null;
	/* Column Info */
	private String csmFromFocStd = null;
	/* Column Info */
	private String toPortCd = null;
	/* Column Info */
	private String cgoToObTeuQty = null;
	/* Column Info */
	private String skdDelayHrs = null;
	/* Column Info */
	private String actBrthDt = null;
	/* Column Info */
	private String cgoRhdlQty = null;
	/* Column Info */
	private String skdDelayColorFlag = null;
	/* Column Info */
	private String skdLocEtaDt = null;
	/* Column Info */
	private String cgoLfHjsQty = null;
	/* Column Info */
	private String vslClass = null;
	/* Column Info */
	private String pfSkdTpCd = null;
	/* Column Info */
	private String optBowHgt = null;
	/* Column Info */
	private String cgoFromGrossProd = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String cgoVolWgt = null;
	/* Column Info */
	private String naviOptDist = null;
	/* Column Info */
	private String naviAvgSlip = null;
	/* Column Info */
	private String vvdRtn = null;
	/* Column Info */
	private String signalIdx = null;
	/* Column Info */
	private String cgoRfQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String naviNoonSpd = null;
	/* Column Info */
	private String naviSpdColorFlag = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String naviDrDist = null;
	/* Column Info */
	private String cgoVolTeuQty = null;
	/* Column Info */
	private String naviRunHrs = null;
	/* Column Info */
	private String skdPfEtaDt = null;
	/* Column Info */
	private String cgoNetProd = null;
	/* Column Info */
	private String skdRptEtaDt = null;
	/* Column Info */
	private String cgoFromAvgArrangement = null;
	/* Column Info */
	private String cgoFromStwgArrangement = null;
	/* Column Info */
	private String signalFocIdx = null;
	/* Column Info */
	private String vslPort = null;
	/* Column Info */
	private String cgoFromUsedArrangement = null;
	/* Column Info */
	private String optTrm = null;
	/* Column Info */
	private String csmFromAvgStd = null;
	/* Column Info */
	private String csmFromAvgFoc = null;
	
	/* Column Info */
	private String naviEtaSpd = null;
	/* Column Info */
	private String csmDailyFocColorFlag = null;
	/* Column Info */
	private String cstNxtPortEtdDt = null;
	/* Column Info */
	private String cgoToIbTeuQty = null;
	/* Column Info */
	private String pairPortCd = null;
	/* Column Info */
	private String cgoToAvgArrangement = null;
	/* Column Info */
	private String actDepDt = null;
	/* Column Info */
	private String csmDailyFocDiff = null;
	/* Column Info */
	private String cgoAkQty = null;
	/* Column Info */
	private String naviRpm = null;
	/* Column Info */
	private String csmFromBalanceFoc = null;
	/* Column Info */
	private String fromPortCd = null;
	
	/* Column Info */
	private String signalIndex = null;
	/* Column Info */
	private String signalIdxRed = null;
	/* Column Info */
	private String signalIdxYellow = null;
	/* Column Info */
	private String signalIdxGreen = null;
	
	/* Column Info */
	private String noonRptExistFlg = null;
	
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String toClptIndSeq = null;
	
	/* Column Info */
	private String noonAvgSpd = null;
	/* Column Info */
	private String noonSailDist = null;
	/* Column Info */
	private String ppsAvgSpd = null;
	/* Column Info */
	private String ppsSailDist = null;
	/* Column Info */
	private String remainDaysToPort = null;	
	/* Column Info */
	private String noonRptDt = null;		
	/* Column Info */
	private String tztmHrs = null;	
	
	/* Column Info */
	private String selSchedule = null;	
	/* Column Info */
	private String selNavi = null;	
	/* Column Info */
	private String selConsum = null;	
	/* Column Info */
	private String selDraft = null;	
	/* Column Info */
	private String selCargo = null;	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VoyagePerformanceVO() {}

	public VoyagePerformanceVO(String ibflag, String pagerows, String signalSkedIdx, String signalNaviIdx, String signalFocIdx, String vslSlanCd, String pfSkdTpCd, String vvd, String vslSts, String actDepDt, String actBrthDt, String fromPortCd, String toPortCd, String fmYdCd, String toYdCd, String cstNxtPortEtdDt, String cntrDznCapa, String skdPfEtaDt, String skdLocEtaDt, String skdRptEtaDt, String skdDelayHrs, String skdDelayColorFlag, String naviRunHrs, String naviOptDist, String naviDrDist, String naviNoonDist, String naviEtaSpd, String naviPpsSpd, String naviNoonSpd, String naviSpdColorFlag, String naviRpm, String naviAvgSlip, String naviNoonSlip, String csmDailyFocStd, String csmDailyFocTLine, String csmDailyFocPps, String csmDailyFocNoon, String csmDailyFocColorFlag, String csmDailyFocDiff, String csmFocRpt, String csmFromFocStd, String csmFromAvgStd, String csmFromBalanceFoc, String csmFromAchPercentage, String optFwdTrim, String optAftTrim, String optTrm, String optTrmImg, String optBowHgt, String optTrsmHgt, String cgoFromGrossProd, String cgoToGrossProd, String cgoNetProd, String cgoFromStwgArrangement, String cgoFromAvgArrangement, String cgoFromUsedArrangement, String cgoToAvgArrangement, String cgoVolLdbQty, String cgoVolTeuQty, String cgoVolWgt, String cgoLfHjsQty, String cgoLfAllianceQty, String cgoBsaHjsQty, String cgoBsaAllianceQty, String cgoTotalLfRatio, String cgoToIbTeuQty, String cgoToObTeuQty, String cgoRhdlQty, String cgoRfQty, String cgoAkQty, String cgoBbQty, String currDt, String vslCd, String vslClass, String signalIdx, String txtIdx, String vslEngNm, String cgoOnboardTeuQty, String cgoOnboardWgt, String vvdRtn, String pairPortCd, String vslPort) {
		this.csmDailyFocStd = csmDailyFocStd;
		this.cgoOnboardWgt = cgoOnboardWgt;
		this.vslCd = vslCd;
		this.cgoBsaAllianceQty = cgoBsaAllianceQty;
		this.fmYdCd = fmYdCd;
		this.toYdCd = toYdCd;
		this.pagerows = pagerows;
		this.cgoBsaHjsQty = cgoBsaHjsQty;
		this.csmDailyFocTLine = csmDailyFocTLine;
		this.vslSts = vslSts;
		this.optFwdTrim = optFwdTrim;
		this.cgoOnboardTeuQty = cgoOnboardTeuQty;
		this.currDt = currDt;
		this.optAftTrim = optAftTrim;
		this.signalSkedIdx = signalSkedIdx;
		this.optTrmImg = optTrmImg;
		this.naviNoonDist = naviNoonDist;
		this.cgoVolLdbQty = cgoVolLdbQty;
		this.signalNaviIdx = signalNaviIdx;
		this.naviNoonSlip = naviNoonSlip;
		this.optTrsmHgt = optTrsmHgt;
		this.naviPpsSpd = naviPpsSpd;
		this.csmDailyFocNoon = csmDailyFocNoon;
		this.csmFromAchPercentage = csmFromAchPercentage;
		this.cgoLfAllianceQty = cgoLfAllianceQty;
		this.cgoTotalLfRatio = cgoTotalLfRatio;
		this.vvd = vvd;
		this.txtIdx = txtIdx;
		this.cgoToGrossProd = cgoToGrossProd;
		this.cntrDznCapa = cntrDznCapa;
		this.cgoBbQty = cgoBbQty;
		this.csmDailyFocPps = csmDailyFocPps;
		this.csmFocRpt = csmFocRpt;
		this.csmFromFocStd = csmFromFocStd;
		this.toPortCd = toPortCd;
		this.cgoToObTeuQty = cgoToObTeuQty;
		this.skdDelayHrs = skdDelayHrs;
		this.actBrthDt = actBrthDt;
		this.cgoRhdlQty = cgoRhdlQty;
		this.skdDelayColorFlag = skdDelayColorFlag;
		this.skdLocEtaDt = skdLocEtaDt;
		this.cgoLfHjsQty = cgoLfHjsQty;
		this.vslClass = vslClass;
		this.pfSkdTpCd = pfSkdTpCd;
		this.optBowHgt = optBowHgt;
		this.cgoFromGrossProd = cgoFromGrossProd;
		this.vslSlanCd = vslSlanCd;
		this.cgoVolWgt = cgoVolWgt;
		this.naviOptDist = naviOptDist;
		this.naviAvgSlip = naviAvgSlip;
		this.vvdRtn = vvdRtn;
		this.signalIdx = signalIdx;
		this.cgoRfQty = cgoRfQty;
		this.ibflag = ibflag;
		this.naviNoonSpd = naviNoonSpd;
		this.naviSpdColorFlag = naviSpdColorFlag;
		this.vslEngNm = vslEngNm;
		this.naviDrDist = naviDrDist;
		this.cgoVolTeuQty = cgoVolTeuQty;
		this.naviRunHrs = naviRunHrs;
		this.skdPfEtaDt = skdPfEtaDt;
		this.cgoNetProd = cgoNetProd;
		this.skdRptEtaDt = skdRptEtaDt;
		this.cgoFromAvgArrangement = cgoFromAvgArrangement;
		this.cgoFromStwgArrangement = cgoFromStwgArrangement;
		this.signalFocIdx = signalFocIdx;
		this.vslPort = vslPort;
		this.cgoFromUsedArrangement = cgoFromUsedArrangement;
		this.optTrm = optTrm;
		this.csmFromAvgStd = csmFromAvgStd;
		this.naviEtaSpd = naviEtaSpd;
		this.csmDailyFocColorFlag = csmDailyFocColorFlag;
		this.cstNxtPortEtdDt = cstNxtPortEtdDt;
		this.cgoToIbTeuQty = cgoToIbTeuQty;
		this.pairPortCd = pairPortCd;
		this.cgoToAvgArrangement = cgoToAvgArrangement;
		this.actDepDt = actDepDt;
		this.csmDailyFocDiff = csmDailyFocDiff;
		this.cgoAkQty = cgoAkQty;
		this.naviRpm = naviRpm;
		this.csmFromBalanceFoc = csmFromBalanceFoc;
		this.fromPortCd = fromPortCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("csm_daily_foc_std", getCsmDailyFocStd());
		this.hashColumns.put("cgo_onboard_wgt", getCgoOnboardWgt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cgo_bsa_alliance_qty", getCgoBsaAllianceQty());
		this.hashColumns.put("fm_yd_cd", getFmYdCd());
		this.hashColumns.put("to_yd_cd", getToYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cgo_bsa_hjs_qty", getCgoBsaHjsQty());
		this.hashColumns.put("csm_daily_foc_t_line", getCsmDailyFocTLine());
		this.hashColumns.put("vsl_sts", getVslSts());
		this.hashColumns.put("opt_fwd_trim", getOptFwdTrim());
		this.hashColumns.put("cgo_onboard_teu_qty", getCgoOnboardTeuQty());
		this.hashColumns.put("curr_dt", getCurrDt());
		this.hashColumns.put("opt_aft_trim", getOptAftTrim());
		this.hashColumns.put("signal_sked_idx", getSignalSkedIdx());
		this.hashColumns.put("opt_trm_img", getOptTrmImg());
		this.hashColumns.put("navi_noon_dist", getNaviNoonDist());
		this.hashColumns.put("cgo_vol_ldb_qty", getCgoVolLdbQty());
		this.hashColumns.put("signal_navi_idx", getSignalNaviIdx());
		this.hashColumns.put("navi_noon_slip", getNaviNoonSlip());
		this.hashColumns.put("opt_trsm_hgt", getOptTrsmHgt());
		this.hashColumns.put("navi_pps_spd", getNaviPpsSpd());
		this.hashColumns.put("csm_daily_foc_noon", getCsmDailyFocNoon());
		this.hashColumns.put("csm_from_ach_percentage", getCsmFromAchPercentage());
		this.hashColumns.put("cgo_lf_alliance_qty", getCgoLfAllianceQty());
		this.hashColumns.put("cgo_total_lf_ratio", getCgoTotalLfRatio());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("txt_idx", getTxtIdx());
		this.hashColumns.put("cgo_to_gross_prod", getCgoToGrossProd());
		this.hashColumns.put("cntr_dzn_capa", getCntrDznCapa());
		this.hashColumns.put("cgo_bb_qty", getCgoBbQty());
		this.hashColumns.put("csm_daily_foc_pps", getCsmDailyFocPps());
		this.hashColumns.put("csm_foc_rpt", getCsmFocRpt());
		this.hashColumns.put("csm_from_foc_std", getCsmFromFocStd());
		this.hashColumns.put("to_port_cd", getToPortCd());
		this.hashColumns.put("cgo_to_ob_teu_qty", getCgoToObTeuQty());
		this.hashColumns.put("skd_delay_hrs", getSkdDelayHrs());
		this.hashColumns.put("act_brth_dt", getActBrthDt());
		this.hashColumns.put("cgo_rhdl_qty", getCgoRhdlQty());
		this.hashColumns.put("skd_delay_color_flag", getSkdDelayColorFlag());
		this.hashColumns.put("skd_loc_eta_dt", getSkdLocEtaDt());
		this.hashColumns.put("cgo_lf_hjs_qty", getCgoLfHjsQty());
		this.hashColumns.put("vsl_class", getVslClass());
		this.hashColumns.put("pf_skd_tp_cd", getPfSkdTpCd());
		this.hashColumns.put("opt_bow_hgt", getOptBowHgt());
		this.hashColumns.put("cgo_from_gross_prod", getCgoFromGrossProd());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("cgo_vol_wgt", getCgoVolWgt());
		this.hashColumns.put("navi_opt_dist", getNaviOptDist());
		this.hashColumns.put("navi_avg_slip", getNaviAvgSlip());
		this.hashColumns.put("vvd_rtn", getVvdRtn());
		this.hashColumns.put("signal_idx", getSignalIdx());
		this.hashColumns.put("cgo_rf_qty", getCgoRfQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("navi_noon_spd", getNaviNoonSpd());
		this.hashColumns.put("navi_spd_color_flag", getNaviSpdColorFlag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("navi_dr_dist", getNaviDrDist());
		this.hashColumns.put("cgo_vol_teu_qty", getCgoVolTeuQty());
		this.hashColumns.put("navi_run_hrs", getNaviRunHrs());
		this.hashColumns.put("skd_pf_eta_dt", getSkdPfEtaDt());
		this.hashColumns.put("cgo_net_prod", getCgoNetProd());
		this.hashColumns.put("skd_rpt_eta_dt", getSkdRptEtaDt());
		this.hashColumns.put("cgo_from_avg_arrangement", getCgoFromAvgArrangement());
		this.hashColumns.put("cgo_from_stwg_arrangement", getCgoFromStwgArrangement());
		this.hashColumns.put("signal_foc_idx", getSignalFocIdx());
		this.hashColumns.put("vsl_port", getVslPort());
		this.hashColumns.put("cgo_from_used_arrangement", getCgoFromUsedArrangement());
		this.hashColumns.put("opt_trm", getOptTrm());
		this.hashColumns.put("csm_from_avg_std", getCsmFromAvgStd());
		this.hashColumns.put("csm_from_avg_foc", getCsmFromAvgFoc());
		
		this.hashColumns.put("navi_eta_spd", getNaviEtaSpd());
		this.hashColumns.put("csm_daily_foc_color_flag", getCsmDailyFocColorFlag());
		this.hashColumns.put("cst_nxt_port_etd_dt", getCstNxtPortEtdDt());
		this.hashColumns.put("cgo_to_ib_teu_qty", getCgoToIbTeuQty());
		this.hashColumns.put("pair_port_cd", getPairPortCd());
		this.hashColumns.put("cgo_to_avg_arrangement", getCgoToAvgArrangement());
		this.hashColumns.put("act_dep_dt", getActDepDt());
		this.hashColumns.put("csm_daily_foc_diff", getCsmDailyFocDiff());
		this.hashColumns.put("cgo_ak_qty", getCgoAkQty());
		this.hashColumns.put("navi_rpm", getNaviRpm());
		this.hashColumns.put("csm_from_balance_foc", getCsmFromBalanceFoc());
		this.hashColumns.put("from_port_cd", getFromPortCd());
		
		this.hashColumns.put("signal_index"		, getSignalIndex	());
		this.hashColumns.put("signal_idx_red"	, getSignalIdxRed	());
		this.hashColumns.put("signal_idx_yellow", getSignalIdxYellow());
		this.hashColumns.put("signal_idx_green"	, getSignalIdxGreen	());
		
		this.hashColumns.put("noon_rpt_exist_flg"	, getNoonRptExistFlg	());
		
		this.hashColumns.put("skd_voy_no"			, getSkdVoyNo			());
		this.hashColumns.put("skd_dir_cd"			, getSkdDirCd			());
		this.hashColumns.put("clpt_ind_seq"			, getClptIndSeq			());
		this.hashColumns.put("to_clpt_ind_seq"		, getToClptIndSeq		());
		
		this.hashColumns.put("noon_avg_spd"			, getNoonAvgSpd			());
		this.hashColumns.put("noon_sail_dist"		, getNoonSailDist		());

		this.hashColumns.put("pps_avg_spd"			, getPpsAvgSpd			());
		this.hashColumns.put("pps_sail_dist"		, getPpsSailDist		());
		
		this.hashColumns.put("remain_days_to_port"	, getRemainDaysToPort	());
		
		this.hashColumns.put("noon_rpt_dt"			, getNoonRptDt			());
		
		this.hashColumns.put("tztm_hrs"				, getTztmHrs			());
		
		this.hashColumns.put("sel_schedule"			, getSelSchedule		());
		this.hashColumns.put("sel_navi"				, getSelNavi			());
		this.hashColumns.put("sel_consum"			, getSelConsum			());
		this.hashColumns.put("sel_draft"			, getSelDraft			());
		this.hashColumns.put("sel_cargo"			, getSelCargo			());
		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("csm_daily_foc_std", "csmDailyFocStd");
		this.hashFields.put("cgo_onboard_wgt", "cgoOnboardWgt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cgo_bsa_alliance_qty", "cgoBsaAllianceQty");
		this.hashFields.put("fm_yd_cd", "fmYdCd");
		this.hashFields.put("to_yd_cd", "toYdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cgo_bsa_hjs_qty", "cgoBsaHjsQty");
		this.hashFields.put("csm_daily_foc_t_line", "csmDailyFocTLine");
		this.hashFields.put("vsl_sts", "vslSts");
		this.hashFields.put("opt_fwd_trim", "optFwdTrim");
		this.hashFields.put("cgo_onboard_teu_qty", "cgoOnboardTeuQty");
		this.hashFields.put("curr_dt", "currDt");
		this.hashFields.put("opt_aft_trim", "optAftTrim");
		this.hashFields.put("signal_sked_idx", "signalSkedIdx");
		this.hashFields.put("opt_trm_img", "optTrmImg");
		this.hashFields.put("navi_noon_dist", "naviNoonDist");
		this.hashFields.put("cgo_vol_ldb_qty", "cgoVolLdbQty");
		this.hashFields.put("signal_navi_idx", "signalNaviIdx");
		this.hashFields.put("navi_noon_slip", "naviNoonSlip");
		this.hashFields.put("opt_trsm_hgt", "optTrsmHgt");
		this.hashFields.put("navi_pps_spd", "naviPpsSpd");
		this.hashFields.put("csm_daily_foc_noon", "csmDailyFocNoon");
		this.hashFields.put("csm_from_ach_percentage", "csmFromAchPercentage");
		this.hashFields.put("cgo_lf_alliance_qty", "cgoLfAllianceQty");
		this.hashFields.put("cgo_total_lf_ratio", "cgoTotalLfRatio");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("txt_idx", "txtIdx");
		this.hashFields.put("cgo_to_gross_prod", "cgoToGrossProd");
		this.hashFields.put("cntr_dzn_capa", "cntrDznCapa");
		this.hashFields.put("cgo_bb_qty", "cgoBbQty");
		this.hashFields.put("csm_daily_foc_pps", "csmDailyFocPps");
		this.hashFields.put("csm_foc_rpt", "csmFocRpt");
		this.hashFields.put("csm_from_foc_std", "csmFromFocStd");
		this.hashFields.put("to_port_cd", "toPortCd");
		this.hashFields.put("cgo_to_ob_teu_qty", "cgoToObTeuQty");
		this.hashFields.put("skd_delay_hrs", "skdDelayHrs");
		this.hashFields.put("act_brth_dt", "actBrthDt");
		this.hashFields.put("cgo_rhdl_qty", "cgoRhdlQty");
		this.hashFields.put("skd_delay_color_flag", "skdDelayColorFlag");
		this.hashFields.put("skd_loc_eta_dt", "skdLocEtaDt");
		this.hashFields.put("cgo_lf_hjs_qty", "cgoLfHjsQty");
		this.hashFields.put("vsl_class", "vslClass");
		this.hashFields.put("pf_skd_tp_cd", "pfSkdTpCd");
		this.hashFields.put("opt_bow_hgt", "optBowHgt");
		this.hashFields.put("cgo_from_gross_prod", "cgoFromGrossProd");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("cgo_vol_wgt", "cgoVolWgt");
		this.hashFields.put("navi_opt_dist", "naviOptDist");
		this.hashFields.put("navi_avg_slip", "naviAvgSlip");
		this.hashFields.put("vvd_rtn", "vvdRtn");
		this.hashFields.put("signal_idx", "signalIdx");
		this.hashFields.put("cgo_rf_qty", "cgoRfQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("navi_noon_spd", "naviNoonSpd");
		this.hashFields.put("navi_spd_color_flag", "naviSpdColorFlag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("navi_dr_dist", "naviDrDist");
		this.hashFields.put("cgo_vol_teu_qty", "cgoVolTeuQty");
		this.hashFields.put("navi_run_hrs", "naviRunHrs");
		this.hashFields.put("skd_pf_eta_dt", "skdPfEtaDt");
		this.hashFields.put("cgo_net_prod", "cgoNetProd");
		this.hashFields.put("skd_rpt_eta_dt", "skdRptEtaDt");
		this.hashFields.put("cgo_from_avg_arrangement", "cgoFromAvgArrangement");
		this.hashFields.put("cgo_from_stwg_arrangement", "cgoFromStwgArrangement");
		this.hashFields.put("signal_foc_idx", "signalFocIdx");
		this.hashFields.put("vsl_port", "vslPort");
		this.hashFields.put("cgo_from_used_arrangement", "cgoFromUsedArrangement");
		this.hashFields.put("opt_trm", "optTrm");
		this.hashFields.put("csm_from_avg_std", "csmFromAvgStd");
		this.hashFields.put("csm_from_avg_foc", "csmFromAvgFoc");
		
		this.hashFields.put("navi_eta_spd", "naviEtaSpd");
		this.hashFields.put("csm_daily_foc_color_flag", "csmDailyFocColorFlag");
		this.hashFields.put("cst_nxt_port_etd_dt", "cstNxtPortEtdDt");
		this.hashFields.put("cgo_to_ib_teu_qty", "cgoToIbTeuQty");
		this.hashFields.put("pair_port_cd", "pairPortCd");
		this.hashFields.put("cgo_to_avg_arrangement", "cgoToAvgArrangement");
		this.hashFields.put("act_dep_dt", "actDepDt");
		this.hashFields.put("csm_daily_foc_diff", "csmDailyFocDiff");
		this.hashFields.put("cgo_ak_qty", "cgoAkQty");
		this.hashFields.put("navi_rpm", "naviRpm");
		this.hashFields.put("csm_from_balance_foc", "csmFromBalanceFoc");
		this.hashFields.put("from_port_cd", "fromPortCd");
		
		this.hashFields.put("signal_index"		, "signalIndex");
		this.hashFields.put("signal_idx_red"	, "signalIdxRed");
		this.hashFields.put("signal_idx_yellow"	, "signalIdxYellow");
		this.hashFields.put("signal_idx_green"	, "signalIdxGreen");
		
		this.hashFields.put("noon_rpt_exist_flg"	, "noonRptExistFlg");
		
		this.hashFields.put("skd_voy_no"			, "skdVoyNo");
		this.hashFields.put("skd_dir_cd"			, "skdDirCd");
		this.hashFields.put("clpt_ind_seq"			, "clptIndSeq");
		this.hashFields.put("to_clpt_ind_seq"		, "toClptIndSeq");
		
		this.hashFields.put("noon_avg_spd"			, "noonAvgSpd"	);
		this.hashFields.put("noon_sail_dist"		, "noonSailDist");
		
		this.hashFields.put("pps_avg_spd"			, "ppsAvgSpd");
		this.hashFields.put("pps_sail_dist"			, "ppsSailDist");
		
		this.hashFields.put("remain_days_to_port"	, "remainDaysToPort");
		
		this.hashFields.put("noon_rpt_dt"			, "noonRptDt");
		
		this.hashFields.put("tztm_hrs"				, "tztmHrs");
		
		this.hashFields.put("sel_schedule"			, "selSchedule"	);
		this.hashFields.put("sel_navi"				, "selNavi"		);
		this.hashFields.put("sel_consum"			, "selConsum"	);
		this.hashFields.put("sel_draft"				, "selDraft"	);
		this.hashFields.put("sel_cargo"				, "selCargo"	);
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return csmDailyFocStd
	 */
	public String getCsmDailyFocStd() {
		return this.csmDailyFocStd;
	}
	
	/**
	 * Column Info
	 * @return cgoOnboardWgt
	 */
	public String getCgoOnboardWgt() {
		return this.cgoOnboardWgt;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return cgoBsaAllianceQty
	 */
	public String getCgoBsaAllianceQty() {
		return this.cgoBsaAllianceQty;
	}
	
	/**
	 * Column Info
	 * @return fmYdCd
	 */
	public String getFmYdCd() {
		return this.fmYdCd;
	}
	
	/**
	 * Column Info
	 * @return toYdCd
	 */
	public String getToYdCd() {
		return this.toYdCd;
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
	 * @return cgoBsaHjsQty
	 */
	public String getCgoBsaHjsQty() {
		return this.cgoBsaHjsQty;
	}
	
	/**
	 * Column Info
	 * @return csmDailyFocTLine
	 */
	public String getCsmDailyFocTLine() {
		return this.csmDailyFocTLine;
	}
	
	/**
	 * Column Info
	 * @return vslSts
	 */
	public String getVslSts() {
		return this.vslSts;
	}
	
	/**
	 * Column Info
	 * @return optFwdTrim
	 */
	public String getOptFwdTrim() {
		return this.optFwdTrim;
	}
	
	/**
	 * Column Info
	 * @return cgoOnboardTeuQty
	 */
	public String getCgoOnboardTeuQty() {
		return this.cgoOnboardTeuQty;
	}
	
	/**
	 * Column Info
	 * @return currDt
	 */
	public String getCurrDt() {
		return this.currDt;
	}
	
	/**
	 * Column Info
	 * @return optAftTrim
	 */
	public String getOptAftTrim() {
		return this.optAftTrim;
	}
	
	/**
	 * Column Info
	 * @return signalSkedIdx
	 */
	public String getSignalSkedIdx() {
		return this.signalSkedIdx;
	}
	
	/**
	 * Column Info
	 * @return optTrmImg
	 */
	public String getOptTrmImg() {
		return this.optTrmImg;
	}
	
	/**
	 * Column Info
	 * @return naviNoonDist
	 */
	public String getNaviNoonDist() {
		return this.naviNoonDist;
	}
	
	/**
	 * Column Info
	 * @return cgoVolLdbQty
	 */
	public String getCgoVolLdbQty() {
		return this.cgoVolLdbQty;
	}
	
	/**
	 * Column Info
	 * @return signalNaviIdx
	 */
	public String getSignalNaviIdx() {
		return this.signalNaviIdx;
	}
	
	/**
	 * Column Info
	 * @return naviNoonSlip
	 */
	public String getNaviNoonSlip() {
		return this.naviNoonSlip;
	}
	
	/**
	 * Column Info
	 * @return optTrsmHgt
	 */
	public String getOptTrsmHgt() {
		return this.optTrsmHgt;
	}
	
	/**
	 * Column Info
	 * @return naviPpsSpd
	 */
	public String getNaviPpsSpd() {
		return this.naviPpsSpd;
	}
	
	/**
	 * Column Info
	 * @return csmDailyFocNoon
	 */
	public String getCsmDailyFocNoon() {
		return this.csmDailyFocNoon;
	}
	
	/**
	 * Column Info
	 * @return csmFromAchPercentage
	 */
	public String getCsmFromAchPercentage() {
		return this.csmFromAchPercentage;
	}
	
	/**
	 * Column Info
	 * @return cgoLfAllianceQty
	 */
	public String getCgoLfAllianceQty() {
		return this.cgoLfAllianceQty;
	}
	
	/**
	 * Column Info
	 * @return cgoTotalLfRatio
	 */
	public String getCgoTotalLfRatio() {
		return this.cgoTotalLfRatio;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return txtIdx
	 */
	public String getTxtIdx() {
		return this.txtIdx;
	}
	
	/**
	 * Column Info
	 * @return cgoToGrossProd
	 */
	public String getCgoToGrossProd() {
		return this.cgoToGrossProd;
	}
	
	/**
	 * Column Info
	 * @return cntrDznCapa
	 */
	public String getCntrDznCapa() {
		return this.cntrDznCapa;
	}
	
	/**
	 * Column Info
	 * @return cgoBbQty
	 */
	public String getCgoBbQty() {
		return this.cgoBbQty;
	}
	
	/**
	 * Column Info
	 * @return csmDailyFocPps
	 */
	public String getCsmDailyFocPps() {
		return this.csmDailyFocPps;
	}
	
	/**
	 * Column Info
	 * @return csmFocRpt
	 */
	public String getCsmFocRpt() {
		return this.csmFocRpt;
	}
	
	/**
	 * Column Info
	 * @return csmFromFocStd
	 */
	public String getCsmFromFocStd() {
		return this.csmFromFocStd;
	}
	
	/**
	 * Column Info
	 * @return toPortCd
	 */
	public String getToPortCd() {
		return this.toPortCd;
	}
	
	/**
	 * Column Info
	 * @return cgoToObTeuQty
	 */
	public String getCgoToObTeuQty() {
		return this.cgoToObTeuQty;
	}
	
	/**
	 * Column Info
	 * @return skdDelayHrs
	 */
	public String getSkdDelayHrs() {
		return this.skdDelayHrs;
	}
	
	/**
	 * Column Info
	 * @return actBrthDt
	 */
	public String getActBrthDt() {
		return this.actBrthDt;
	}
	
	/**
	 * Column Info
	 * @return cgoRhdlQty
	 */
	public String getCgoRhdlQty() {
		return this.cgoRhdlQty;
	}
	
	/**
	 * Column Info
	 * @return skdDelayColorFlag
	 */
	public String getSkdDelayColorFlag() {
		return this.skdDelayColorFlag;
	}
	
	/**
	 * Column Info
	 * @return skdLocEtaDt
	 */
	public String getSkdLocEtaDt() {
		return this.skdLocEtaDt;
	}
	
	/**
	 * Column Info
	 * @return cgoLfHjsQty
	 */
	public String getCgoLfHjsQty() {
		return this.cgoLfHjsQty;
	}
	
	/**
	 * Column Info
	 * @return vslClass
	 */
	public String getVslClass() {
		return this.vslClass;
	}
	
	/**
	 * Column Info
	 * @return pfSkdTpCd
	 */
	public String getPfSkdTpCd() {
		return this.pfSkdTpCd;
	}
	
	/**
	 * Column Info
	 * @return optBowHgt
	 */
	public String getOptBowHgt() {
		return this.optBowHgt;
	}
	
	/**
	 * Column Info
	 * @return cgoFromGrossProd
	 */
	public String getCgoFromGrossProd() {
		return this.cgoFromGrossProd;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return cgoVolWgt
	 */
	public String getCgoVolWgt() {
		return this.cgoVolWgt;
	}
	
	/**
	 * Column Info
	 * @return naviOptDist
	 */
	public String getNaviOptDist() {
		return this.naviOptDist;
	}
	
	/**
	 * Column Info
	 * @return naviAvgSlip
	 */
	public String getNaviAvgSlip() {
		return this.naviAvgSlip;
	}
	
	/**
	 * Column Info
	 * @return vvdRtn
	 */
	public String getVvdRtn() {
		return this.vvdRtn;
	}
	
	/**
	 * Column Info
	 * @return signalIdx
	 */
	public String getSignalIdx() {
		return this.signalIdx;
	}
	
	/**
	 * Column Info
	 * @return cgoRfQty
	 */
	public String getCgoRfQty() {
		return this.cgoRfQty;
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
	 * @return naviNoonSpd
	 */
	public String getNaviNoonSpd() {
		return this.naviNoonSpd;
	}
	
	/**
	 * Column Info
	 * @return naviSpdColorFlag
	 */
	public String getNaviSpdColorFlag() {
		return this.naviSpdColorFlag;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return naviDrDist
	 */
	public String getNaviDrDist() {
		return this.naviDrDist;
	}
	
	/**
	 * Column Info
	 * @return cgoVolTeuQty
	 */
	public String getCgoVolTeuQty() {
		return this.cgoVolTeuQty;
	}
	
	/**
	 * Column Info
	 * @return naviRunHrs
	 */
	public String getNaviRunHrs() {
		return this.naviRunHrs;
	}
	
	/**
	 * Column Info
	 * @return skdPfEtaDt
	 */
	public String getSkdPfEtaDt() {
		return this.skdPfEtaDt;
	}
	
	/**
	 * Column Info
	 * @return cgoNetProd
	 */
	public String getCgoNetProd() {
		return this.cgoNetProd;
	}
	
	/**
	 * Column Info
	 * @return skdRptEtaDt
	 */
	public String getSkdRptEtaDt() {
		return this.skdRptEtaDt;
	}
	
	/**
	 * Column Info
	 * @return cgoFromAvgArrangement
	 */
	public String getCgoFromAvgArrangement() {
		return this.cgoFromAvgArrangement;
	}
	
	/**
	 * Column Info
	 * @return cgoFromStwgArrangement
	 */
	public String getCgoFromStwgArrangement() {
		return this.cgoFromStwgArrangement;
	}
	
	/**
	 * Column Info
	 * @return signalFocIdx
	 */
	public String getSignalFocIdx() {
		return this.signalFocIdx;
	}
	
	/**
	 * Column Info
	 * @return vslPort
	 */
	public String getVslPort() {
		return this.vslPort;
	}
	
	/**
	 * Column Info
	 * @return cgoFromUsedArrangement
	 */
	public String getCgoFromUsedArrangement() {
		return this.cgoFromUsedArrangement;
	}
	
	/**
	 * Column Info
	 * @return optTrm
	 */
	public String getOptTrm() {
		return this.optTrm;
	}
	
	/**
	 * Column Info
	 * @return csmFromAvgStd
	 */
	public String getCsmFromAvgStd() {
		return this.csmFromAvgStd;
	}
	/**
	 * Column Info
	 * @return csmFromAvgFoc
	 */
	public String getCsmFromAvgFoc() {
		return this.csmFromAvgFoc;
	}
	
	/**
	 * Column Info
	 * @return naviEtaSpd
	 */
	public String getNaviEtaSpd() {
		return this.naviEtaSpd;
	}
	
	/**
	 * Column Info
	 * @return csmDailyFocColorFlag
	 */
	public String getCsmDailyFocColorFlag() {
		return this.csmDailyFocColorFlag;
	}
	
	/**
	 * Column Info
	 * @return cstNxtPortEtdDt
	 */
	public String getCstNxtPortEtdDt() {
		return this.cstNxtPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @return cgoToIbTeuQty
	 */
	public String getCgoToIbTeuQty() {
		return this.cgoToIbTeuQty;
	}
	
	/**
	 * Column Info
	 * @return pairPortCd
	 */
	public String getPairPortCd() {
		return this.pairPortCd;
	}
	
	/**
	 * Column Info
	 * @return cgoToAvgArrangement
	 */
	public String getCgoToAvgArrangement() {
		return this.cgoToAvgArrangement;
	}
	
	/**
	 * Column Info
	 * @return actDepDt
	 */
	public String getActDepDt() {
		return this.actDepDt;
	}
	
	/**
	 * Column Info
	 * @return csmDailyFocDiff
	 */
	public String getCsmDailyFocDiff() {
		return this.csmDailyFocDiff;
	}
	
	/**
	 * Column Info
	 * @return cgoAkQty
	 */
	public String getCgoAkQty() {
		return this.cgoAkQty;
	}
	
	/**
	 * Column Info
	 * @return naviRpm
	 */
	public String getNaviRpm() {
		return this.naviRpm;
	}
	
	/**
	 * Column Info
	 * @return csmFromBalanceFoc
	 */
	public String getCsmFromBalanceFoc() {
		return this.csmFromBalanceFoc;
	}
	
	/**
	 * Column Info
	 * @return fromPortCd
	 */
	public String getFromPortCd() {
		return this.fromPortCd;
	}
	
	/**
	 * Column Info
	 * @return signalIndex
	 */
	public String getSignalIndex() {
		return this.signalIndex;
	}
	/**
	 * Column Info
	 * @return signalIdxRed
	 */
	public String getSignalIdxRed() {
		return this.signalIdxRed;
	}
	/**
	 * Column Info
	 * @return signalIdxYellow
	 */
	public String getSignalIdxYellow() {
		return this.signalIdxYellow;
	}
	/**
	 * Column Info
	 * @return signalIdxGreen
	 */
	public String getSignalIdxGreen() {
		return this.signalIdxGreen;
	}
	/**
	 * Column Info
	 * @return noonRptExistFlg
	 */
	public String getNoonRptExistFlg() {
		return this.noonRptExistFlg;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	/**
	 * Column Info
	 * @return toClptIndSeq
	 */
	public String getToClptIndSeq() {
		return this.toClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return noonAvgSpd
	 */
	public String getNoonAvgSpd() {
		return this.noonAvgSpd;
	}
	/**
	 * Column Info
	 * @return noonSailDist
	 */
	public String getNoonSailDist() {
		return this.noonSailDist;
	}
	
	/**
	 * Column Info
	 * @return ppsAvgSpd
	 */
	public String getPpsAvgSpd() {
		return this.ppsAvgSpd;
	}
	/**
	 * Column Info
	 * @return ppsSailDist
	 */
	public String getPpsSailDist() {
		return this.ppsSailDist;
	}
	/**
	 * Column Info
	 * @return remainDaysToPort
	 */
	public String getRemainDaysToPort() {
		return this.remainDaysToPort;
	}
	/**
	 * Column Info
	 * @return noonRptDt
	 */
	public String getNoonRptDt() {
		return this.noonRptDt;
	}
	/**
	 * Column Info
	 * @return tztmHrs
	 */
	public String getTztmHrs() {
		return this.tztmHrs;
	}

	/**
	 * Column Info
	 * @return selSchedule
	 */
	public String getSelSchedule() {
		return this.selSchedule;
	}	/**
	 * Column Info
	 * @return selNavi
	 */
	public String getSelNavi() {
		return this.selNavi;
	}	/**
	 * Column Info
	 * @return selConsum
	 */
	public String getSelConsum() {
		return this.selConsum;
	}	/**
	 * Column Info
	 * @return selDraft
	 */
	public String getSelDraft() {
		return this.selDraft;
	}	/**
	 * Column Info
	 * @return selCargo
	 */
	public String getSelCargo() {
		return this.selCargo;
	}
	
	
	
	
	
	
	
	
	/**
	 * Column Info
	 * @param selSchedule
	 */
	public void setSelSchedule(String selSchedule) {
		this.selSchedule = selSchedule;
	}	/**
	 * Column Info
	 * @param selNavi
	 */
	public void setSelNavi(String selNavi) {
		this.selNavi = selNavi;
	}	/**
	 * Column Info
	 * @param selConsum
	 */
	public void setSelConsum(String selConsum) {
		this.selConsum = selConsum;
	}	/**
	 * Column Info
	 * @param selDraft
	 */
	public void setSelDraft(String selDraft) {
		this.selDraft = selDraft;
	}	/**
	 * Column Info
	 * @param selCargo
	 */
	public void setSelCargo(String selCargo) {
		this.selCargo = selCargo;
	}
	
	/**
	 * Column Info
	 * @param tztmHrs
	 */
	public void setTztmHrs(String tztmHrs) {
		this.tztmHrs = tztmHrs;
	}
	/**
	 * Column Info
	 * @param noonRptDt
	 */
	public void setNoonRptDt(String noonRptDt) {
		this.noonRptDt = noonRptDt;
	}	
	/**
	 * Column Info
	 * @param remainDaysToPort
	 */
	public void setRemainDaysToPort(String remainDaysToPort) {
		this.remainDaysToPort = remainDaysToPort;
	}	
	/**
	 * Column Info
	 * @param ppsAvgSpd
	 */
	public void setPpsAvgSpd(String ppsAvgSpd) {
		this.ppsAvgSpd = ppsAvgSpd;
	}
	/**
	 * Column Info
	 * @param ppsSailDist
	 */
	public void setPpsSailDist(String ppsSailDist) {
		this.ppsSailDist = ppsSailDist;
	}
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	/**
	 * Column Info
	 * @param noonAvgSpd
	 */
	public void setNoonAvgSpd(String noonAvgSpd) {
		this.noonAvgSpd = noonAvgSpd;
	}
	
	/**
	 * Column Info
	 * @param noonSailDist
	 */
	public void setNoonSailDist(String noonSailDist) {
		this.noonSailDist = noonSailDist;
	}
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	/**
	 * Column Info
	 * @param toClptIndSeq
	 */
	public void setToClptIndSeq(String toClptIndSeq) {
		this.toClptIndSeq = toClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param noonRptExistFlg
	 */
	public void setNoonRptExistFlg(String noonRptExistFlg) {
		this.noonRptExistFlg = noonRptExistFlg;
	}
	/**
	 * Column Info
	 * @param signalIndex
	 */
	public void setSignalIndex(String signalIndex) {
		this.signalIndex = signalIndex;
	}
	/**
	 * Column Info
	 * @param signalIdxRed
	 */
	public void setSignalIdxRed(String signalIdxRed) {
		this.signalIdxRed = signalIdxRed;
	}
	/**
	 * Column Info
	 * @param signalIdxYellow
	 */
	public void setSignalIdxYellow(String signalIdxYellow) {
		this.signalIdxYellow = signalIdxYellow;
	}
	/**
	 * Column Info
	 * @param signalIdxGreen
	 */
	public void setSignalIdxGreen(String signalIdxGreen) {
		this.signalIdxGreen = signalIdxGreen;
	}
	

	/**
	 * Column Info
	 * @param csmDailyFocStd
	 */
	public void setCsmDailyFocStd(String csmDailyFocStd) {
		this.csmDailyFocStd = csmDailyFocStd;
	}
	
	/**
	 * Column Info
	 * @param cgoOnboardWgt
	 */
	public void setCgoOnboardWgt(String cgoOnboardWgt) {
		this.cgoOnboardWgt = cgoOnboardWgt;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param cgoBsaAllianceQty
	 */
	public void setCgoBsaAllianceQty(String cgoBsaAllianceQty) {
		this.cgoBsaAllianceQty = cgoBsaAllianceQty;
	}
	
	/**
	 * Column Info
	 * @param fmYdCd
	 */
	public void setFmYdCd(String fmYdCd) {
		this.fmYdCd = fmYdCd;
	}
	
	/**
	 * Column Info
	 * @param toYdCd
	 */
	public void setToYdCd(String toYdCd) {
		this.toYdCd = toYdCd;
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
	 * @param cgoBsaHjsQty
	 */
	public void setCgoBsaHjsQty(String cgoBsaHjsQty) {
		this.cgoBsaHjsQty = cgoBsaHjsQty;
	}
	
	/**
	 * Column Info
	 * @param csmDailyFocTLine
	 */
	public void setCsmDailyFocTLine(String csmDailyFocTLine) {
		this.csmDailyFocTLine = csmDailyFocTLine;
	}
	
	/**
	 * Column Info
	 * @param vslSts
	 */
	public void setVslSts(String vslSts) {
		this.vslSts = vslSts;
	}
	
	/**
	 * Column Info
	 * @param optFwdTrim
	 */
	public void setOptFwdTrim(String optFwdTrim) {
		this.optFwdTrim = optFwdTrim;
	}
	
	/**
	 * Column Info
	 * @param cgoOnboardTeuQty
	 */
	public void setCgoOnboardTeuQty(String cgoOnboardTeuQty) {
		this.cgoOnboardTeuQty = cgoOnboardTeuQty;
	}
	
	/**
	 * Column Info
	 * @param currDt
	 */
	public void setCurrDt(String currDt) {
		this.currDt = currDt;
	}
	
	/**
	 * Column Info
	 * @param optAftTrim
	 */
	public void setOptAftTrim(String optAftTrim) {
		this.optAftTrim = optAftTrim;
	}
	
	/**
	 * Column Info
	 * @param signalSkedIdx
	 */
	public void setSignalSkedIdx(String signalSkedIdx) {
		this.signalSkedIdx = signalSkedIdx;
	}
	
	/**
	 * Column Info
	 * @param optTrmImg
	 */
	public void setOptTrmImg(String optTrmImg) {
		this.optTrmImg = optTrmImg;
	}
	
	/**
	 * Column Info
	 * @param naviNoonDist
	 */
	public void setNaviNoonDist(String naviNoonDist) {
		this.naviNoonDist = naviNoonDist;
	}
	
	/**
	 * Column Info
	 * @param cgoVolLdbQty
	 */
	public void setCgoVolLdbQty(String cgoVolLdbQty) {
		this.cgoVolLdbQty = cgoVolLdbQty;
	}
	
	/**
	 * Column Info
	 * @param signalNaviIdx
	 */
	public void setSignalNaviIdx(String signalNaviIdx) {
		this.signalNaviIdx = signalNaviIdx;
	}
	
	/**
	 * Column Info
	 * @param naviNoonSlip
	 */
	public void setNaviNoonSlip(String naviNoonSlip) {
		this.naviNoonSlip = naviNoonSlip;
	}
	
	/**
	 * Column Info
	 * @param optTrsmHgt
	 */
	public void setOptTrsmHgt(String optTrsmHgt) {
		this.optTrsmHgt = optTrsmHgt;
	}
	
	/**
	 * Column Info
	 * @param naviPpsSpd
	 */
	public void setNaviPpsSpd(String naviPpsSpd) {
		this.naviPpsSpd = naviPpsSpd;
	}
	
	/**
	 * Column Info
	 * @param csmDailyFocNoon
	 */
	public void setCsmDailyFocNoon(String csmDailyFocNoon) {
		this.csmDailyFocNoon = csmDailyFocNoon;
	}
	
	/**
	 * Column Info
	 * @param csmFromAchPercentage
	 */
	public void setCsmFromAchPercentage(String csmFromAchPercentage) {
		this.csmFromAchPercentage = csmFromAchPercentage;
	}
	
	/**
	 * Column Info
	 * @param cgoLfAllianceQty
	 */
	public void setCgoLfAllianceQty(String cgoLfAllianceQty) {
		this.cgoLfAllianceQty = cgoLfAllianceQty;
	}
	
	/**
	 * Column Info
	 * @param cgoTotalLfRatio
	 */
	public void setCgoTotalLfRatio(String cgoTotalLfRatio) {
		this.cgoTotalLfRatio = cgoTotalLfRatio;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param txtIdx
	 */
	public void setTxtIdx(String txtIdx) {
		this.txtIdx = txtIdx;
	}
	
	/**
	 * Column Info
	 * @param cgoToGrossProd
	 */
	public void setCgoToGrossProd(String cgoToGrossProd) {
		this.cgoToGrossProd = cgoToGrossProd;
	}
	
	/**
	 * Column Info
	 * @param cntrDznCapa
	 */
	public void setCntrDznCapa(String cntrDznCapa) {
		this.cntrDznCapa = cntrDznCapa;
	}
	
	/**
	 * Column Info
	 * @param cgoBbQty
	 */
	public void setCgoBbQty(String cgoBbQty) {
		this.cgoBbQty = cgoBbQty;
	}
	
	/**
	 * Column Info
	 * @param csmDailyFocPps
	 */
	public void setCsmDailyFocPps(String csmDailyFocPps) {
		this.csmDailyFocPps = csmDailyFocPps;
	}
	
	/**
	 * Column Info
	 * @param csmFocRpt
	 */
	public void setCsmFocRpt(String csmFocRpt) {
		this.csmFocRpt = csmFocRpt;
	}
	
	/**
	 * Column Info
	 * @param csmFromFocStd
	 */
	public void setCsmFromFocStd(String csmFromFocStd) {
		this.csmFromFocStd = csmFromFocStd;
	}
	
	/**
	 * Column Info
	 * @param toPortCd
	 */
	public void setToPortCd(String toPortCd) {
		this.toPortCd = toPortCd;
	}
	
	/**
	 * Column Info
	 * @param cgoToObTeuQty
	 */
	public void setCgoToObTeuQty(String cgoToObTeuQty) {
		this.cgoToObTeuQty = cgoToObTeuQty;
	}
	
	/**
	 * Column Info
	 * @param skdDelayHrs
	 */
	public void setSkdDelayHrs(String skdDelayHrs) {
		this.skdDelayHrs = skdDelayHrs;
	}
	
	/**
	 * Column Info
	 * @param actBrthDt
	 */
	public void setActBrthDt(String actBrthDt) {
		this.actBrthDt = actBrthDt;
	}
	
	/**
	 * Column Info
	 * @param cgoRhdlQty
	 */
	public void setCgoRhdlQty(String cgoRhdlQty) {
		this.cgoRhdlQty = cgoRhdlQty;
	}
	
	/**
	 * Column Info
	 * @param skdDelayColorFlag
	 */
	public void setSkdDelayColorFlag(String skdDelayColorFlag) {
		this.skdDelayColorFlag = skdDelayColorFlag;
	}
	
	/**
	 * Column Info
	 * @param skdLocEtaDt
	 */
	public void setSkdLocEtaDt(String skdLocEtaDt) {
		this.skdLocEtaDt = skdLocEtaDt;
	}
	
	/**
	 * Column Info
	 * @param cgoLfHjsQty
	 */
	public void setCgoLfHjsQty(String cgoLfHjsQty) {
		this.cgoLfHjsQty = cgoLfHjsQty;
	}
	
	/**
	 * Column Info
	 * @param vslClass
	 */
	public void setVslClass(String vslClass) {
		this.vslClass = vslClass;
	}
	
	/**
	 * Column Info
	 * @param pfSkdTpCd
	 */
	public void setPfSkdTpCd(String pfSkdTpCd) {
		this.pfSkdTpCd = pfSkdTpCd;
	}
	
	/**
	 * Column Info
	 * @param optBowHgt
	 */
	public void setOptBowHgt(String optBowHgt) {
		this.optBowHgt = optBowHgt;
	}
	
	/**
	 * Column Info
	 * @param cgoFromGrossProd
	 */
	public void setCgoFromGrossProd(String cgoFromGrossProd) {
		this.cgoFromGrossProd = cgoFromGrossProd;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param cgoVolWgt
	 */
	public void setCgoVolWgt(String cgoVolWgt) {
		this.cgoVolWgt = cgoVolWgt;
	}
	
	/**
	 * Column Info
	 * @param naviOptDist
	 */
	public void setNaviOptDist(String naviOptDist) {
		this.naviOptDist = naviOptDist;
	}
	
	/**
	 * Column Info
	 * @param naviAvgSlip
	 */
	public void setNaviAvgSlip(String naviAvgSlip) {
		this.naviAvgSlip = naviAvgSlip;
	}
	
	/**
	 * Column Info
	 * @param vvdRtn
	 */
	public void setVvdRtn(String vvdRtn) {
		this.vvdRtn = vvdRtn;
	}
	
	/**
	 * Column Info
	 * @param signalIdx
	 */
	public void setSignalIdx(String signalIdx) {
		this.signalIdx = signalIdx;
	}
	
	/**
	 * Column Info
	 * @param cgoRfQty
	 */
	public void setCgoRfQty(String cgoRfQty) {
		this.cgoRfQty = cgoRfQty;
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
	 * @param naviNoonSpd
	 */
	public void setNaviNoonSpd(String naviNoonSpd) {
		this.naviNoonSpd = naviNoonSpd;
	}
	
	/**
	 * Column Info
	 * @param naviSpdColorFlag
	 */
	public void setNaviSpdColorFlag(String naviSpdColorFlag) {
		this.naviSpdColorFlag = naviSpdColorFlag;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param naviDrDist
	 */
	public void setNaviDrDist(String naviDrDist) {
		this.naviDrDist = naviDrDist;
	}
	
	/**
	 * Column Info
	 * @param cgoVolTeuQty
	 */
	public void setCgoVolTeuQty(String cgoVolTeuQty) {
		this.cgoVolTeuQty = cgoVolTeuQty;
	}
	
	/**
	 * Column Info
	 * @param naviRunHrs
	 */
	public void setNaviRunHrs(String naviRunHrs) {
		this.naviRunHrs = naviRunHrs;
	}
	
	/**
	 * Column Info
	 * @param skdPfEtaDt
	 */
	public void setSkdPfEtaDt(String skdPfEtaDt) {
		this.skdPfEtaDt = skdPfEtaDt;
	}
	
	/**
	 * Column Info
	 * @param cgoNetProd
	 */
	public void setCgoNetProd(String cgoNetProd) {
		this.cgoNetProd = cgoNetProd;
	}
	
	/**
	 * Column Info
	 * @param skdRptEtaDt
	 */
	public void setSkdRptEtaDt(String skdRptEtaDt) {
		this.skdRptEtaDt = skdRptEtaDt;
	}
	
	/**
	 * Column Info
	 * @param cgoFromAvgArrangement
	 */
	public void setCgoFromAvgArrangement(String cgoFromAvgArrangement) {
		this.cgoFromAvgArrangement = cgoFromAvgArrangement;
	}
	
	/**
	 * Column Info
	 * @param cgoFromStwgArrangement
	 */
	public void setCgoFromStwgArrangement(String cgoFromStwgArrangement) {
		this.cgoFromStwgArrangement = cgoFromStwgArrangement;
	}
	
	/**
	 * Column Info
	 * @param signalFocIdx
	 */
	public void setSignalFocIdx(String signalFocIdx) {
		this.signalFocIdx = signalFocIdx;
	}
	
	/**
	 * Column Info
	 * @param vslPort
	 */
	public void setVslPort(String vslPort) {
		this.vslPort = vslPort;
	}
	
	/**
	 * Column Info
	 * @param cgoFromUsedArrangement
	 */
	public void setCgoFromUsedArrangement(String cgoFromUsedArrangement) {
		this.cgoFromUsedArrangement = cgoFromUsedArrangement;
	}
	
	/**
	 * Column Info
	 * @param optTrm
	 */
	public void setOptTrm(String optTrm) {
		this.optTrm = optTrm;
	}
	
	/**
	 * Column Info
	 * @param csmFromAvgStd
	 */
	public void setCsmFromAvgStd(String csmFromAvgStd) {
		this.csmFromAvgStd = csmFromAvgStd;
	}
	/**
	 * Column Info
	 * @param csmFromAvgFoc
	 */
	public void setCsmFromAvgFoc(String csmFromAvgFoc) {
		this.csmFromAvgFoc = csmFromAvgFoc;
	}
	
	/**
	 * Column Info
	 * @param naviEtaSpd
	 */
	public void setNaviEtaSpd(String naviEtaSpd) {
		this.naviEtaSpd = naviEtaSpd;
	}
	
	/**
	 * Column Info
	 * @param csmDailyFocColorFlag
	 */
	public void setCsmDailyFocColorFlag(String csmDailyFocColorFlag) {
		this.csmDailyFocColorFlag = csmDailyFocColorFlag;
	}
	
	/**
	 * Column Info
	 * @param cstNxtPortEtdDt
	 */
	public void setCstNxtPortEtdDt(String cstNxtPortEtdDt) {
		this.cstNxtPortEtdDt = cstNxtPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @param cgoToIbTeuQty
	 */
	public void setCgoToIbTeuQty(String cgoToIbTeuQty) {
		this.cgoToIbTeuQty = cgoToIbTeuQty;
	}
	
	/**
	 * Column Info
	 * @param pairPortCd
	 */
	public void setPairPortCd(String pairPortCd) {
		this.pairPortCd = pairPortCd;
	}
	
	/**
	 * Column Info
	 * @param cgoToAvgArrangement
	 */
	public void setCgoToAvgArrangement(String cgoToAvgArrangement) {
		this.cgoToAvgArrangement = cgoToAvgArrangement;
	}
	
	/**
	 * Column Info
	 * @param actDepDt
	 */
	public void setActDepDt(String actDepDt) {
		this.actDepDt = actDepDt;
	}
	
	/**
	 * Column Info
	 * @param csmDailyFocDiff
	 */
	public void setCsmDailyFocDiff(String csmDailyFocDiff) {
		this.csmDailyFocDiff = csmDailyFocDiff;
	}
	
	/**
	 * Column Info
	 * @param cgoAkQty
	 */
	public void setCgoAkQty(String cgoAkQty) {
		this.cgoAkQty = cgoAkQty;
	}
	
	/**
	 * Column Info
	 * @param naviRpm
	 */
	public void setNaviRpm(String naviRpm) {
		this.naviRpm = naviRpm;
	}
	
	/**
	 * Column Info
	 * @param csmFromBalanceFoc
	 */
	public void setCsmFromBalanceFoc(String csmFromBalanceFoc) {
		this.csmFromBalanceFoc = csmFromBalanceFoc;
	}
	
	/**
	 * Column Info
	 * @param fromPortCd
	 */
	public void setFromPortCd(String fromPortCd) {
		this.fromPortCd = fromPortCd;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setCsmDailyFocStd(JSPUtil.getParameter(request, prefix + "csm_daily_foc_std", ""));
		setCgoOnboardWgt(JSPUtil.getParameter(request, prefix + "cgo_onboard_wgt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCgoBsaAllianceQty(JSPUtil.getParameter(request, prefix + "cgo_bsa_alliance_qty", ""));
		setFmYdCd(JSPUtil.getParameter(request, prefix + "fm_yd_cd", ""));
		setToYdCd(JSPUtil.getParameter(request, prefix + "to_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCgoBsaHjsQty(JSPUtil.getParameter(request, prefix + "cgo_bsa_hjs_qty", ""));
		setCsmDailyFocTLine(JSPUtil.getParameter(request, prefix + "csm_daily_foc_t_line", ""));
		setVslSts(JSPUtil.getParameter(request, prefix + "vsl_sts", ""));
		setOptFwdTrim(JSPUtil.getParameter(request, prefix + "opt_fwd_trim", ""));
		setCgoOnboardTeuQty(JSPUtil.getParameter(request, prefix + "cgo_onboard_teu_qty", ""));
		setCurrDt(JSPUtil.getParameter(request, prefix + "curr_dt", ""));
		setOptAftTrim(JSPUtil.getParameter(request, prefix + "opt_aft_trim", ""));
		setSignalSkedIdx(JSPUtil.getParameter(request, prefix + "signal_sked_idx", ""));
		setOptTrmImg(JSPUtil.getParameter(request, prefix + "opt_trm_img", ""));
		setNaviNoonDist(JSPUtil.getParameter(request, prefix + "navi_noon_dist", ""));
		setCgoVolLdbQty(JSPUtil.getParameter(request, prefix + "cgo_vol_ldb_qty", ""));
		setSignalNaviIdx(JSPUtil.getParameter(request, prefix + "signal_navi_idx", ""));
		setNaviNoonSlip(JSPUtil.getParameter(request, prefix + "navi_noon_slip", ""));
		setOptTrsmHgt(JSPUtil.getParameter(request, prefix + "opt_trsm_hgt", ""));
		setNaviPpsSpd(JSPUtil.getParameter(request, prefix + "navi_pps_spd", ""));
		setCsmDailyFocNoon(JSPUtil.getParameter(request, prefix + "csm_daily_foc_noon", ""));
		setCsmFromAchPercentage(JSPUtil.getParameter(request, prefix + "csm_from_ach_percentage", ""));
		setCgoLfAllianceQty(JSPUtil.getParameter(request, prefix + "cgo_lf_alliance_qty", ""));
		setCgoTotalLfRatio(JSPUtil.getParameter(request, prefix + "cgo_total_lf_ratio", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setTxtIdx(JSPUtil.getParameter(request, prefix + "txt_idx", ""));
		setCgoToGrossProd(JSPUtil.getParameter(request, prefix + "cgo_to_gross_prod", ""));
		setCntrDznCapa(JSPUtil.getParameter(request, prefix + "cntr_dzn_capa", ""));
		setCgoBbQty(JSPUtil.getParameter(request, prefix + "cgo_bb_qty", ""));
		setCsmDailyFocPps(JSPUtil.getParameter(request, prefix + "csm_daily_foc_pps", ""));
		setCsmFocRpt(JSPUtil.getParameter(request, prefix + "csm_foc_rpt", ""));
		setCsmFromFocStd(JSPUtil.getParameter(request, prefix + "csm_from_foc_std", ""));
		setToPortCd(JSPUtil.getParameter(request, prefix + "to_port_cd", ""));
		setCgoToObTeuQty(JSPUtil.getParameter(request, prefix + "cgo_to_ob_teu_qty", ""));
		setSkdDelayHrs(JSPUtil.getParameter(request, prefix + "skd_delay_hrs", ""));
		setActBrthDt(JSPUtil.getParameter(request, prefix + "act_brth_dt", ""));
		setCgoRhdlQty(JSPUtil.getParameter(request, prefix + "cgo_rhdl_qty", ""));
		setSkdDelayColorFlag(JSPUtil.getParameter(request, prefix + "skd_delay_color_flag", ""));
		setSkdLocEtaDt(JSPUtil.getParameter(request, prefix + "skd_loc_eta_dt", ""));
		setCgoLfHjsQty(JSPUtil.getParameter(request, prefix + "cgo_lf_hjs_qty", ""));
		setVslClass(JSPUtil.getParameter(request, prefix + "vsl_class", ""));
		setPfSkdTpCd(JSPUtil.getParameter(request, prefix + "pf_skd_tp_cd", ""));
		setOptBowHgt(JSPUtil.getParameter(request, prefix + "opt_bow_hgt", ""));
		setCgoFromGrossProd(JSPUtil.getParameter(request, prefix + "cgo_from_gross_prod", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setCgoVolWgt(JSPUtil.getParameter(request, prefix + "cgo_vol_wgt", ""));
		setNaviOptDist(JSPUtil.getParameter(request, prefix + "navi_opt_dist", ""));
		setNaviAvgSlip(JSPUtil.getParameter(request, prefix + "navi_avg_slip", ""));
		setVvdRtn(JSPUtil.getParameter(request, prefix + "vvd_rtn", ""));
		setSignalIdx(JSPUtil.getParameter(request, prefix + "signal_idx", ""));
		setCgoRfQty(JSPUtil.getParameter(request, prefix + "cgo_rf_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNaviNoonSpd(JSPUtil.getParameter(request, prefix + "navi_noon_spd", ""));
		setNaviSpdColorFlag(JSPUtil.getParameter(request, prefix + "navi_spd_color_flag", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setNaviDrDist(JSPUtil.getParameter(request, prefix + "navi_dr_dist", ""));
		setCgoVolTeuQty(JSPUtil.getParameter(request, prefix + "cgo_vol_teu_qty", ""));
		setNaviRunHrs(JSPUtil.getParameter(request, prefix + "navi_run_hrs", ""));
		setSkdPfEtaDt(JSPUtil.getParameter(request, prefix + "skd_pf_eta_dt", ""));
		setCgoNetProd(JSPUtil.getParameter(request, prefix + "cgo_net_prod", ""));
		setSkdRptEtaDt(JSPUtil.getParameter(request, prefix + "skd_rpt_eta_dt", ""));
		setCgoFromAvgArrangement(JSPUtil.getParameter(request, prefix + "cgo_from_avg_arrangement", ""));
		setCgoFromStwgArrangement(JSPUtil.getParameter(request, prefix + "cgo_from_stwg_arrangement", ""));
		setSignalFocIdx(JSPUtil.getParameter(request, prefix + "signal_foc_idx", ""));
		setVslPort(JSPUtil.getParameter(request, prefix + "vsl_port", ""));
		setCgoFromUsedArrangement(JSPUtil.getParameter(request, prefix + "cgo_from_used_arrangement", ""));
		setOptTrm(JSPUtil.getParameter(request, prefix + "opt_trm", ""));
		setCsmFromAvgStd(JSPUtil.getParameter(request, prefix + "csm_from_avg_std", ""));
		setCsmFromAvgFoc(JSPUtil.getParameter(request, prefix + "csm_from_avg_foc", ""));
		
		setNaviEtaSpd(JSPUtil.getParameter(request, prefix + "navi_eta_spd", ""));
		setCsmDailyFocColorFlag(JSPUtil.getParameter(request, prefix + "csm_daily_foc_color_flag", ""));
		setCstNxtPortEtdDt(JSPUtil.getParameter(request, prefix + "cst_nxt_port_etd_dt", ""));
		setCgoToIbTeuQty(JSPUtil.getParameter(request, prefix + "cgo_to_ib_teu_qty", ""));
		setPairPortCd(JSPUtil.getParameter(request, prefix + "pair_port_cd", ""));
		setCgoToAvgArrangement(JSPUtil.getParameter(request, prefix + "cgo_to_avg_arrangement", ""));
		setActDepDt(JSPUtil.getParameter(request, prefix + "act_dep_dt", ""));
		setCsmDailyFocDiff(JSPUtil.getParameter(request, prefix + "csm_daily_foc_diff", ""));
		setCgoAkQty(JSPUtil.getParameter(request, prefix + "cgo_ak_qty", ""));
		setNaviRpm(JSPUtil.getParameter(request, prefix + "navi_rpm", ""));
		setCsmFromBalanceFoc(JSPUtil.getParameter(request, prefix + "csm_from_balance_foc", ""));
		setFromPortCd(JSPUtil.getParameter(request, prefix + "from_port_cd", ""));
		
		setSignalIndex		(JSPUtil.getParameter(request, prefix + "signal_index"		, ""));
		setSignalIdxGreen	(JSPUtil.getParameter(request, prefix + "signal_idx_green"	, ""));
		setSignalIdxYellow	(JSPUtil.getParameter(request, prefix + "signal_idx_yellow"	, ""));
		setSignalIdxRed		(JSPUtil.getParameter(request, prefix + "signal_idx_red"	, ""));
		
		setNoonRptExistFlg	(JSPUtil.getParameter(request, prefix + "noon_rpt_exist_flg", ""));
		
		setSkdVoyNo			(JSPUtil.getParameter(request, prefix + "skd_voy_no"		, ""));
		setSkdDirCd			(JSPUtil.getParameter(request, prefix + "skd_dir_cd"		, ""));
		setClptIndSeq		(JSPUtil.getParameter(request, prefix + "clpt_ind_seq"		, ""));
		setToClptIndSeq		(JSPUtil.getParameter(request, prefix + "to_clpt_ind_seq"	, ""));
		
		setSelSchedule		(JSPUtil.getParameter(request, prefix + "sel_schedule"		, ""));
		setSelNavi			(JSPUtil.getParameter(request, prefix + "sel_navi"			, ""));
		setSelConsum		(JSPUtil.getParameter(request, prefix + "sel_consum"		, ""));
		setSelDraft			(JSPUtil.getParameter(request, prefix + "sel_draft"			, ""));
		setSelCargo			(JSPUtil.getParameter(request, prefix + "sel_cargo"			, ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VoyagePerformanceVO[]
	 */
	public VoyagePerformanceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VoyagePerformanceVO[]
	 */
	public VoyagePerformanceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VoyagePerformanceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] csmDailyFocStd = (JSPUtil.getParameter(request, prefix	+ "csm_daily_foc_std", length));
			String[] cgoOnboardWgt = (JSPUtil.getParameter(request, prefix	+ "cgo_onboard_wgt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cgoBsaAllianceQty = (JSPUtil.getParameter(request, prefix	+ "cgo_bsa_alliance_qty", length));
			String[] fmYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_yd_cd", length));
			String[] toYdCd = (JSPUtil.getParameter(request, prefix	+ "to_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cgoBsaHjsQty = (JSPUtil.getParameter(request, prefix	+ "cgo_bsa_hjs_qty", length));
			String[] csmDailyFocTLine = (JSPUtil.getParameter(request, prefix	+ "csm_daily_foc_t_line", length));
			String[] vslSts = (JSPUtil.getParameter(request, prefix	+ "vsl_sts", length));
			String[] optFwdTrim = (JSPUtil.getParameter(request, prefix	+ "opt_fwd_trim", length));
			String[] cgoOnboardTeuQty = (JSPUtil.getParameter(request, prefix	+ "cgo_onboard_teu_qty", length));
			String[] currDt = (JSPUtil.getParameter(request, prefix	+ "curr_dt", length));
			String[] optAftTrim = (JSPUtil.getParameter(request, prefix	+ "opt_aft_trim", length));
			String[] signalSkedIdx = (JSPUtil.getParameter(request, prefix	+ "signal_sked_idx", length));
			String[] optTrmImg = (JSPUtil.getParameter(request, prefix	+ "opt_trm_img", length));
			String[] naviNoonDist = (JSPUtil.getParameter(request, prefix	+ "navi_noon_dist", length));
			String[] cgoVolLdbQty = (JSPUtil.getParameter(request, prefix	+ "cgo_vol_ldb_qty", length));
			String[] signalNaviIdx = (JSPUtil.getParameter(request, prefix	+ "signal_navi_idx", length));
			String[] naviNoonSlip = (JSPUtil.getParameter(request, prefix	+ "navi_noon_slip", length));
			String[] optTrsmHgt = (JSPUtil.getParameter(request, prefix	+ "opt_trsm_hgt", length));
			String[] naviPpsSpd = (JSPUtil.getParameter(request, prefix	+ "navi_pps_spd", length));
			String[] csmDailyFocNoon = (JSPUtil.getParameter(request, prefix	+ "csm_daily_foc_noon", length));
			String[] csmFromAchPercentage = (JSPUtil.getParameter(request, prefix	+ "csm_from_ach_percentage", length));
			String[] cgoLfAllianceQty = (JSPUtil.getParameter(request, prefix	+ "cgo_lf_alliance_qty", length));
			String[] cgoTotalLfRatio = (JSPUtil.getParameter(request, prefix	+ "cgo_total_lf_ratio", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] txtIdx = (JSPUtil.getParameter(request, prefix	+ "txt_idx", length));
			String[] cgoToGrossProd = (JSPUtil.getParameter(request, prefix	+ "cgo_to_gross_prod", length));
			String[] cntrDznCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_dzn_capa", length));
			String[] cgoBbQty = (JSPUtil.getParameter(request, prefix	+ "cgo_bb_qty", length));
			String[] csmDailyFocPps = (JSPUtil.getParameter(request, prefix	+ "csm_daily_foc_pps", length));
			String[] csmFocRpt = (JSPUtil.getParameter(request, prefix	+ "csm_foc_rpt", length));
			String[] csmFromFocStd = (JSPUtil.getParameter(request, prefix	+ "csm_from_foc_std", length));
			String[] toPortCd = (JSPUtil.getParameter(request, prefix	+ "to_port_cd", length));
			String[] cgoToObTeuQty = (JSPUtil.getParameter(request, prefix	+ "cgo_to_ob_teu_qty", length));
			String[] skdDelayHrs = (JSPUtil.getParameter(request, prefix	+ "skd_delay_hrs", length));
			String[] actBrthDt = (JSPUtil.getParameter(request, prefix	+ "act_brth_dt", length));
			String[] cgoRhdlQty = (JSPUtil.getParameter(request, prefix	+ "cgo_rhdl_qty", length));
			String[] skdDelayColorFlag = (JSPUtil.getParameter(request, prefix	+ "skd_delay_color_flag", length));
			String[] skdLocEtaDt = (JSPUtil.getParameter(request, prefix	+ "skd_loc_eta_dt", length));
			String[] cgoLfHjsQty = (JSPUtil.getParameter(request, prefix	+ "cgo_lf_hjs_qty", length));
			String[] vslClass = (JSPUtil.getParameter(request, prefix	+ "vsl_class", length));
			String[] pfSkdTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_skd_tp_cd", length));
			String[] optBowHgt = (JSPUtil.getParameter(request, prefix	+ "opt_bow_hgt", length));
			String[] cgoFromGrossProd = (JSPUtil.getParameter(request, prefix	+ "cgo_from_gross_prod", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] cgoVolWgt = (JSPUtil.getParameter(request, prefix	+ "cgo_vol_wgt", length));
			String[] naviOptDist = (JSPUtil.getParameter(request, prefix	+ "navi_opt_dist", length));
			String[] naviAvgSlip = (JSPUtil.getParameter(request, prefix	+ "navi_avg_slip", length));
			String[] vvdRtn = (JSPUtil.getParameter(request, prefix	+ "vvd_rtn", length));
			String[] signalIdx = (JSPUtil.getParameter(request, prefix	+ "signal_idx", length));
			String[] cgoRfQty = (JSPUtil.getParameter(request, prefix	+ "cgo_rf_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] naviNoonSpd = (JSPUtil.getParameter(request, prefix	+ "navi_noon_spd", length));
			String[] naviSpdColorFlag = (JSPUtil.getParameter(request, prefix	+ "navi_spd_color_flag", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] naviDrDist = (JSPUtil.getParameter(request, prefix	+ "navi_dr_dist", length));
			String[] cgoVolTeuQty = (JSPUtil.getParameter(request, prefix	+ "cgo_vol_teu_qty", length));
			String[] naviRunHrs = (JSPUtil.getParameter(request, prefix	+ "navi_run_hrs", length));
			String[] skdPfEtaDt = (JSPUtil.getParameter(request, prefix	+ "skd_pf_eta_dt", length));
			String[] cgoNetProd = (JSPUtil.getParameter(request, prefix	+ "cgo_net_prod", length));
			String[] skdRptEtaDt = (JSPUtil.getParameter(request, prefix	+ "skd_rpt_eta_dt", length));
			String[] cgoFromAvgArrangement = (JSPUtil.getParameter(request, prefix	+ "cgo_from_avg_arrangement", length));
			String[] cgoFromStwgArrangement = (JSPUtil.getParameter(request, prefix	+ "cgo_from_stwg_arrangement", length));
			String[] signalFocIdx = (JSPUtil.getParameter(request, prefix	+ "signal_foc_idx", length));
			String[] vslPort = (JSPUtil.getParameter(request, prefix	+ "vsl_port", length));
			String[] cgoFromUsedArrangement = (JSPUtil.getParameter(request, prefix	+ "cgo_from_used_arrangement", length));
			String[] optTrm = (JSPUtil.getParameter(request, prefix	+ "opt_trm", length));
			String[] csmFromAvgStd = (JSPUtil.getParameter(request, prefix	+ "csm_from_avg_std", length));
			String[] csmFromAvgFoc = (JSPUtil.getParameter(request, prefix	+ "csm_from_avg_foc", length));
			
			String[] naviEtaSpd = (JSPUtil.getParameter(request, prefix	+ "navi_eta_spd", length));
			String[] csmDailyFocColorFlag = (JSPUtil.getParameter(request, prefix	+ "csm_daily_foc_color_flag", length));
			String[] cstNxtPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "cst_nxt_port_etd_dt", length));
			String[] cgoToIbTeuQty = (JSPUtil.getParameter(request, prefix	+ "cgo_to_ib_teu_qty", length));
			String[] pairPortCd = (JSPUtil.getParameter(request, prefix	+ "pair_port_cd", length));
			String[] cgoToAvgArrangement = (JSPUtil.getParameter(request, prefix	+ "cgo_to_avg_arrangement", length));
			String[] actDepDt = (JSPUtil.getParameter(request, prefix	+ "act_dep_dt", length));
			String[] csmDailyFocDiff = (JSPUtil.getParameter(request, prefix	+ "csm_daily_foc_diff", length));
			String[] cgoAkQty = (JSPUtil.getParameter(request, prefix	+ "cgo_ak_qty", length));
			String[] naviRpm = (JSPUtil.getParameter(request, prefix	+ "navi_rpm", length));
			String[] csmFromBalanceFoc = (JSPUtil.getParameter(request, prefix	+ "csm_from_balance_foc", length));
			String[] fromPortCd = (JSPUtil.getParameter(request, prefix	+ "from_port_cd", length));
			
			String[] signalIndex 	= (JSPUtil.getParameter(request, prefix	+ "signal_index"		, length));
			String[] signalIdxGreen = (JSPUtil.getParameter(request, prefix	+ "signal_idx_green"	, length));
			String[] signalIdxYellow= (JSPUtil.getParameter(request, prefix	+ "signal_idx_yellow"	, length));
			String[] signalIdxRed 	= (JSPUtil.getParameter(request, prefix	+ "signal_idx_red"		, length));
			
			String[] noonRptExistFlg= (JSPUtil.getParameter(request, prefix	+ "noon_rpt_exist_flg"	, length));
			
			String[] skdVoyNo		= (JSPUtil.getParameter(request, prefix	+ "skd_voy_no"			, length));
			String[] skdDirCd		= (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd"			, length));
			String[] clptIndSeq		= (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq"		, length));
			String[] toClptIndSeq	= (JSPUtil.getParameter(request, prefix	+ "to_clpt_ind_seq"		, length));
			
			String[] selSchedule	= (JSPUtil.getParameter(request, prefix	+ "sel_schedule"		, length));
			String[] selNavi		= (JSPUtil.getParameter(request, prefix	+ "sel_navi"			, length));
			String[] selConsum		= (JSPUtil.getParameter(request, prefix	+ "sel_consum"			, length));
			String[] selDraft		= (JSPUtil.getParameter(request, prefix	+ "sel_draft"			, length));
			String[] selCargo		= (JSPUtil.getParameter(request, prefix	+ "sel_cargo"			, length));
			
			for (int i = 0; i < length; i++) {
				model = new VoyagePerformanceVO();
				if (csmDailyFocStd[i] != null)
					model.setCsmDailyFocStd(csmDailyFocStd[i]);
				if (cgoOnboardWgt[i] != null)
					model.setCgoOnboardWgt(cgoOnboardWgt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cgoBsaAllianceQty[i] != null)
					model.setCgoBsaAllianceQty(cgoBsaAllianceQty[i]);
				if (fmYdCd[i] != null)
					model.setFmYdCd(fmYdCd[i]);
				if (toYdCd[i] != null)
					model.setToYdCd(toYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cgoBsaHjsQty[i] != null)
					model.setCgoBsaHjsQty(cgoBsaHjsQty[i]);
				if (csmDailyFocTLine[i] != null)
					model.setCsmDailyFocTLine(csmDailyFocTLine[i]);
				if (vslSts[i] != null)
					model.setVslSts(vslSts[i]);
				if (optFwdTrim[i] != null)
					model.setOptFwdTrim(optFwdTrim[i]);
				if (cgoOnboardTeuQty[i] != null)
					model.setCgoOnboardTeuQty(cgoOnboardTeuQty[i]);
				if (currDt[i] != null)
					model.setCurrDt(currDt[i]);
				if (optAftTrim[i] != null)
					model.setOptAftTrim(optAftTrim[i]);
				if (signalSkedIdx[i] != null)
					model.setSignalSkedIdx(signalSkedIdx[i]);
				if (optTrmImg[i] != null)
					model.setOptTrmImg(optTrmImg[i]);
				if (naviNoonDist[i] != null)
					model.setNaviNoonDist(naviNoonDist[i]);
				if (cgoVolLdbQty[i] != null)
					model.setCgoVolLdbQty(cgoVolLdbQty[i]);
				if (signalNaviIdx[i] != null)
					model.setSignalNaviIdx(signalNaviIdx[i]);
				if (naviNoonSlip[i] != null)
					model.setNaviNoonSlip(naviNoonSlip[i]);
				if (optTrsmHgt[i] != null)
					model.setOptTrsmHgt(optTrsmHgt[i]);
				if (naviPpsSpd[i] != null)
					model.setNaviPpsSpd(naviPpsSpd[i]);
				if (csmDailyFocNoon[i] != null)
					model.setCsmDailyFocNoon(csmDailyFocNoon[i]);
				if (csmFromAchPercentage[i] != null)
					model.setCsmFromAchPercentage(csmFromAchPercentage[i]);
				if (cgoLfAllianceQty[i] != null)
					model.setCgoLfAllianceQty(cgoLfAllianceQty[i]);
				if (cgoTotalLfRatio[i] != null)
					model.setCgoTotalLfRatio(cgoTotalLfRatio[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (txtIdx[i] != null)
					model.setTxtIdx(txtIdx[i]);
				if (cgoToGrossProd[i] != null)
					model.setCgoToGrossProd(cgoToGrossProd[i]);
				if (cntrDznCapa[i] != null)
					model.setCntrDznCapa(cntrDznCapa[i]);
				if (cgoBbQty[i] != null)
					model.setCgoBbQty(cgoBbQty[i]);
				if (csmDailyFocPps[i] != null)
					model.setCsmDailyFocPps(csmDailyFocPps[i]);
				if (csmFocRpt[i] != null)
					model.setCsmFocRpt(csmFocRpt[i]);
				if (csmFromFocStd[i] != null)
					model.setCsmFromFocStd(csmFromFocStd[i]);
				if (toPortCd[i] != null)
					model.setToPortCd(toPortCd[i]);
				if (cgoToObTeuQty[i] != null)
					model.setCgoToObTeuQty(cgoToObTeuQty[i]);
				if (skdDelayHrs[i] != null)
					model.setSkdDelayHrs(skdDelayHrs[i]);
				if (actBrthDt[i] != null)
					model.setActBrthDt(actBrthDt[i]);
				if (cgoRhdlQty[i] != null)
					model.setCgoRhdlQty(cgoRhdlQty[i]);
				if (skdDelayColorFlag[i] != null)
					model.setSkdDelayColorFlag(skdDelayColorFlag[i]);
				if (skdLocEtaDt[i] != null)
					model.setSkdLocEtaDt(skdLocEtaDt[i]);
				if (cgoLfHjsQty[i] != null)
					model.setCgoLfHjsQty(cgoLfHjsQty[i]);
				if (vslClass[i] != null)
					model.setVslClass(vslClass[i]);
				if (pfSkdTpCd[i] != null)
					model.setPfSkdTpCd(pfSkdTpCd[i]);
				if (optBowHgt[i] != null)
					model.setOptBowHgt(optBowHgt[i]);
				if (cgoFromGrossProd[i] != null)
					model.setCgoFromGrossProd(cgoFromGrossProd[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (cgoVolWgt[i] != null)
					model.setCgoVolWgt(cgoVolWgt[i]);
				if (naviOptDist[i] != null)
					model.setNaviOptDist(naviOptDist[i]);
				if (naviAvgSlip[i] != null)
					model.setNaviAvgSlip(naviAvgSlip[i]);
				if (vvdRtn[i] != null)
					model.setVvdRtn(vvdRtn[i]);
				if (signalIdx[i] != null)
					model.setSignalIdx(signalIdx[i]);
				if (cgoRfQty[i] != null)
					model.setCgoRfQty(cgoRfQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (naviNoonSpd[i] != null)
					model.setNaviNoonSpd(naviNoonSpd[i]);
				if (naviSpdColorFlag[i] != null)
					model.setNaviSpdColorFlag(naviSpdColorFlag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (naviDrDist[i] != null)
					model.setNaviDrDist(naviDrDist[i]);
				if (cgoVolTeuQty[i] != null)
					model.setCgoVolTeuQty(cgoVolTeuQty[i]);
				if (naviRunHrs[i] != null)
					model.setNaviRunHrs(naviRunHrs[i]);
				if (skdPfEtaDt[i] != null)
					model.setSkdPfEtaDt(skdPfEtaDt[i]);
				if (cgoNetProd[i] != null)
					model.setCgoNetProd(cgoNetProd[i]);
				if (skdRptEtaDt[i] != null)
					model.setSkdRptEtaDt(skdRptEtaDt[i]);
				if (cgoFromAvgArrangement[i] != null)
					model.setCgoFromAvgArrangement(cgoFromAvgArrangement[i]);
				if (cgoFromStwgArrangement[i] != null)
					model.setCgoFromStwgArrangement(cgoFromStwgArrangement[i]);
				if (signalFocIdx[i] != null)
					model.setSignalFocIdx(signalFocIdx[i]);
				if (vslPort[i] != null)
					model.setVslPort(vslPort[i]);
				if (cgoFromUsedArrangement[i] != null)
					model.setCgoFromUsedArrangement(cgoFromUsedArrangement[i]);
				if (optTrm[i] != null)
					model.setOptTrm(optTrm[i]);
				if (csmFromAvgStd[i] != null)
					model.setCsmFromAvgStd(csmFromAvgStd[i]);
				if (csmFromAvgFoc[i] != null)
					model.setCsmFromAvgFoc(csmFromAvgFoc[i]);
				
				if (naviEtaSpd[i] != null)
					model.setNaviEtaSpd(naviEtaSpd[i]);
				if (csmDailyFocColorFlag[i] != null)
					model.setCsmDailyFocColorFlag(csmDailyFocColorFlag[i]);
				if (cstNxtPortEtdDt[i] != null)
					model.setCstNxtPortEtdDt(cstNxtPortEtdDt[i]);
				if (cgoToIbTeuQty[i] != null)
					model.setCgoToIbTeuQty(cgoToIbTeuQty[i]);
				if (pairPortCd[i] != null)
					model.setPairPortCd(pairPortCd[i]);
				if (cgoToAvgArrangement[i] != null)
					model.setCgoToAvgArrangement(cgoToAvgArrangement[i]);
				if (actDepDt[i] != null)
					model.setActDepDt(actDepDt[i]);
				if (csmDailyFocDiff[i] != null)
					model.setCsmDailyFocDiff(csmDailyFocDiff[i]);
				if (cgoAkQty[i] != null)
					model.setCgoAkQty(cgoAkQty[i]);
				if (naviRpm[i] != null)
					model.setNaviRpm(naviRpm[i]);
				if (csmFromBalanceFoc[i] != null)
					model.setCsmFromBalanceFoc(csmFromBalanceFoc[i]);
				if (fromPortCd[i] != null)
					model.setFromPortCd(fromPortCd[i]);
				
				if (signalIndex[i] != null)
					model.setSignalIndex(signalIndex[i]);
				if (signalIdxGreen[i] != null)
					model.setSignalIdxGreen(signalIdxGreen[i]);
				if (signalIdxYellow[i] != null)
					model.setSignalIdxYellow(signalIdxYellow[i]);
				if (signalIdxRed[i] != null)
					model.setSignalIdxRed(signalIdxRed[i]);
				
				if (noonRptExistFlg[i] != null)
					model.setNoonRptExistFlg(noonRptExistFlg[i]);
				
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (toClptIndSeq[i] != null)
					model.setToClptIndSeq(toClptIndSeq[i]);

				if (selSchedule[i] != null)
					model.setSelSchedule(selSchedule[i]);
				if (selNavi[i] != null)
					model.setSelNavi(selNavi[i]);
				if (selConsum[i] != null)
					model.setSelConsum(selConsum[i]);
				if (selDraft[i] != null)
					model.setSelDraft(selDraft[i]);
				if (selCargo[i] != null)
					model.setSelCargo(selCargo[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVoyagePerformanceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VoyagePerformanceVO[]
	 */
	public VoyagePerformanceVO[] getVoyagePerformanceVOs(){
		VoyagePerformanceVO[] vos = (VoyagePerformanceVO[])models.toArray(new VoyagePerformanceVO[models.size()]);
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
		this.csmDailyFocStd = this.csmDailyFocStd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoOnboardWgt = this.cgoOnboardWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoBsaAllianceQty = this.cgoBsaAllianceQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYdCd = this.fmYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYdCd = this.toYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoBsaHjsQty = this.cgoBsaHjsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csmDailyFocTLine = this.csmDailyFocTLine .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSts = this.vslSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optFwdTrim = this.optFwdTrim .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoOnboardTeuQty = this.cgoOnboardTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currDt = this.currDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optAftTrim = this.optAftTrim .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.signalSkedIdx = this.signalSkedIdx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optTrmImg = this.optTrmImg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.naviNoonDist = this.naviNoonDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoVolLdbQty = this.cgoVolLdbQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.signalNaviIdx = this.signalNaviIdx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.naviNoonSlip = this.naviNoonSlip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optTrsmHgt = this.optTrsmHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.naviPpsSpd = this.naviPpsSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csmDailyFocNoon = this.csmDailyFocNoon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csmFromAchPercentage = this.csmFromAchPercentage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoLfAllianceQty = this.cgoLfAllianceQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTotalLfRatio = this.cgoTotalLfRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtIdx = this.txtIdx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoToGrossProd = this.cgoToGrossProd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDznCapa = this.cntrDznCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoBbQty = this.cgoBbQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csmDailyFocPps = this.csmDailyFocPps .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csmFocRpt = this.csmFocRpt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csmFromFocStd = this.csmFromFocStd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPortCd = this.toPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoToObTeuQty = this.cgoToObTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDelayHrs = this.skdDelayHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actBrthDt = this.actBrthDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoRhdlQty = this.cgoRhdlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDelayColorFlag = this.skdDelayColorFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdLocEtaDt = this.skdLocEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoLfHjsQty = this.cgoLfHjsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClass = this.vslClass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSkdTpCd = this.pfSkdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optBowHgt = this.optBowHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoFromGrossProd = this.cgoFromGrossProd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoVolWgt = this.cgoVolWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.naviOptDist = this.naviOptDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.naviAvgSlip = this.naviAvgSlip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdRtn = this.vvdRtn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.signalIdx = this.signalIdx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoRfQty = this.cgoRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.naviNoonSpd = this.naviNoonSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.naviSpdColorFlag = this.naviSpdColorFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.naviDrDist = this.naviDrDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoVolTeuQty = this.cgoVolTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.naviRunHrs = this.naviRunHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdPfEtaDt = this.skdPfEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoNetProd = this.cgoNetProd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdRptEtaDt = this.skdRptEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoFromAvgArrangement = this.cgoFromAvgArrangement .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoFromStwgArrangement = this.cgoFromStwgArrangement .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.signalFocIdx = this.signalFocIdx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPort = this.vslPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoFromUsedArrangement = this.cgoFromUsedArrangement .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optTrm = this.optTrm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csmFromAvgStd = this.csmFromAvgStd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.naviEtaSpd = this.naviEtaSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csmDailyFocColorFlag = this.csmDailyFocColorFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstNxtPortEtdDt = this.cstNxtPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoToIbTeuQty = this.cgoToIbTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pairPortCd = this.pairPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoToAvgArrangement = this.cgoToAvgArrangement .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDepDt = this.actDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csmDailyFocDiff = this.csmDailyFocDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoAkQty = this.cgoAkQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.naviRpm = this.naviRpm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csmFromBalanceFoc = this.csmFromBalanceFoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromPortCd = this.fromPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
