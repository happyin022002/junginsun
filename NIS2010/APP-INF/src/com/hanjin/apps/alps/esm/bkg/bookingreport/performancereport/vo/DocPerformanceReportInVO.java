/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DocPerformanceReportInVO.java
*@FileTitle : DocPerformanceReportInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.11
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.08.11 김기종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DocPerformanceReportInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocPerformanceReportInVO> models = new ArrayList<DocPerformanceReportInVO>();
	
	/* Column Info */
	private String blAudFlg = null;
	/* Column Info */
	private String via = null;
	/* Column Info */
	private String originalTotalSs = null;
	/* Column Info */
	private String totalActualMi = null;
	/* Column Info */
	private String blRtFlg = null;
	/* Column Info */
	private String siRec = null;
	/* Column Info */
	private String originalTotalDd = null;
	/* Column Info */
	private String inputElapsedSs = null;
	/* Column Info */
	private String amendIdleMi = null;
	/* Column Info */
	private String totalTotalSs = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgOfcCdD = null;
	/* Column Info */
	private String srCrntInfoCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String rgnCdD = null;
	/* Column Info */
	private String rateElapsedMi = null;
	/* Column Info */
	private String icEnd = null;
	/* Column Info */
	private String totalTotalHh = null;
	/* Column Info */
	private String totalIdleMi = null;
	/* Column Info */
	private String originalActualHh = null;
	/* Column Info */
	private String amendIdleHh = null;
	/* Column Info */
	private String addVal = null;
	/* Column Info */
	private String totalTotalDd = null;
	/* Column Info */
	private String amendTotalSs = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String rsStart = null;
	/* Column Info */
	private String amendTotalMi = null;
	/* Column Info */
	private String totalActualHh = null;
	/* Column Info */
	private String blDocInpFlg = null;
	/* Column Info */
	private String rateElapsedDd = null;
	/* Column Info */
	private String hbl = null;
	/* Column Info */
	private String amendIdleDd = null;
	/* Column Info */
	private String totalActualDd = null;
	/* Column Info */
	private String rateElapsedHh = null;
	/* Column Info */
	private String siElapsedMi = null;
	/* Column Info */
	private String amendActualDd = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String amendActualSs = null;
	/* Column Info */
	private String originalIdleMi = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String qcEnd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String amendActualHh = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String rgnCdCd = null;
	/* Column Info */
	private String inputElapsedMi = null;
	/* Column Info */
	private String cm = null;
	/* Column Info */
	private String qaElapsedSs = null;
	/* Column Info */
	private String originalActualMi = null;
	/* Column Info */
	private String rgn = null;
	/* Column Info */
	private String totalIdleHh = null;
	/* Column Info */
	private String srCrntStsCd = null;
	/* Column Info */
	private String pndFlg = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String totalIdleSs = null;
	/* Column Info */
	private String isStart = null;
	/* Column Info */
	private String originalIdleHh = null;
	/* Column Info */
	private String amd = null;
	/* Column Info */
	private String originalTotalMi = null;
	/* Column Info */
	private String qaElapsedDd = null;
	/* Column Info */
	private String amendTotalHh = null;
	/* Column Info */
	private String amendTotalDd = null;
	/* Column Info */
	private String srKndCd = null;
	/* Column Info */
	private String qaElapsedHh = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String srWrkStsCd = null;
	/* Column Info */
	private String inputElapsedDd = null;
	/* Column Info */
	private String totalActualSs = null;
	/* Column Info */
	private String totalIdleDd = null;
	/* Column Info */
	private String srAmdTpCd = null;
	/* Column Info */
	private String inputElapsedHh = null;
	/* Column Info */
	private String srTrans = null;
	/* Column Info */
	private String originalIdleSs = null;
	/* Column Info */
	private String originalIdleDd = null;
	/* Column Info */
	private String blDrftFaxOutFlg = null;
	/* Column Info */
	private String srNo = null;
	/* Column Info */
	private String rateElapsedSs = null;
	/* Column Info */
	private String srAmdTd = null;
	/* Column Info */
	private String amendActualMi = null;
	/* Column Info */
	private String rcEnd = null;
	/* Column Info */
	private String qsStart = null;
	/* Column Info */
	private String divide = null;
	/* Column Info */
	private String originalActualSs = null;
	/* Column Info */
	private String amendIdleSs = null;
	/* Column Info */
	private String originalActualDd = null;
	/* Column Info */
	private String siElapsedSs = null;
	/* Column Info */
	private String imgPgNo = null;
	/* Column Info */
	private String siElapsedDd = null;
	/* Column Info */
	private String totalTotalMi = null;
	/* Column Info */
	private String siElapsedHh = null;
	/* Column Info */
	private String originalTotalHh = null;
	/* Column Info */
	private String qaElapsedMi = null;
	/* Column Info */
	private String dpcsOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocPerformanceReportInVO() {}

	public DocPerformanceReportInVO(String ibflag, String pagerows, String bkgNo, String srAmdTd, String vvdCd, String bkgOfcCd, String polCd, String podCd, String via, String cm, String hbl, String amd, String addVal, String rgn, String originalActualDd, String originalActualHh, String originalActualMi, String originalActualSs, String originalIdleDd, String originalIdleHh, String originalIdleMi, String originalIdleSs, String originalTotalDd, String originalTotalHh, String originalTotalMi, String originalTotalSs, String amendActualDd, String amendActualHh, String amendActualMi, String amendActualSs, String amendIdleDd, String amendIdleHh, String amendIdleMi, String amendIdleSs, String amendTotalDd, String amendTotalHh, String amendTotalMi, String amendTotalSs, String totalActualDd, String totalActualHh, String totalActualMi, String totalActualSs, String totalIdleDd, String totalIdleHh, String totalIdleMi, String totalIdleSs, String totalTotalDd, String totalTotalHh, String totalTotalMi, String totalTotalSs, String srTrans, String siRec, String siElapsedDd, String siElapsedHh, String siElapsedMi, String siElapsedSs, String isStart, String icEnd, String inputElapsedDd, String inputElapsedHh, String inputElapsedMi, String inputElapsedSs, String rsStart, String rcEnd, String rateElapsedDd, String rateElapsedHh, String rateElapsedMi, String rateElapsedSs, String qsStart, String qcEnd, String qaElapsedDd, String qaElapsedHh, String qaElapsedMi, String dpcsOfcCd, String qaElapsedSs, String srAmdTpCd, String srNo, String pndFlg, String srKndCd, String srCrntInfoCd, String blDocInpFlg, String blRtFlg, String blAudFlg, String blDrftFaxOutFlg, String srWrkStsCd, String bkgOfcCdD, String rgnCdCd, String period, String toDt, String srCrntStsCd, String fromDt, String divide, String imgPgNo, String rgnCdD) {
		this.blAudFlg = blAudFlg;
		this.via = via;
		this.originalTotalSs = originalTotalSs;
		this.totalActualMi = totalActualMi;
		this.blRtFlg = blRtFlg;
		this.siRec = siRec;
		this.originalTotalDd = originalTotalDd;
		this.inputElapsedSs = inputElapsedSs;
		this.amendIdleMi = amendIdleMi;
		this.totalTotalSs = totalTotalSs;
		this.pagerows = pagerows;
		this.bkgOfcCdD = bkgOfcCdD;
		this.srCrntInfoCd = srCrntInfoCd;
		this.polCd = polCd;
		this.vvdCd = vvdCd;
		this.rgnCdD = rgnCdD;
		this.rateElapsedMi = rateElapsedMi;
		this.icEnd = icEnd;
		this.totalTotalHh = totalTotalHh;
		this.totalIdleMi = totalIdleMi;
		this.originalActualHh = originalActualHh;
		this.amendIdleHh = amendIdleHh;
		this.addVal = addVal;
		this.totalTotalDd = totalTotalDd;
		this.amendTotalSs = amendTotalSs;
		this.bkgOfcCd = bkgOfcCd;
		this.rsStart = rsStart;
		this.amendTotalMi = amendTotalMi;
		this.totalActualHh = totalActualHh;
		this.blDocInpFlg = blDocInpFlg;
		this.rateElapsedDd = rateElapsedDd;
		this.hbl = hbl;
		this.amendIdleDd = amendIdleDd;
		this.totalActualDd = totalActualDd;
		this.rateElapsedHh = rateElapsedHh;
		this.siElapsedMi = siElapsedMi;
		this.amendActualDd = amendActualDd;
		this.period = period;
		this.amendActualSs = amendActualSs;
		this.originalIdleMi = originalIdleMi;
		this.toDt = toDt;
		this.qcEnd = qcEnd;
		this.podCd = podCd;
		this.amendActualHh = amendActualHh;
		this.bkgNo = bkgNo;
		this.rgnCdCd = rgnCdCd;
		this.inputElapsedMi = inputElapsedMi;
		this.cm = cm;
		this.qaElapsedSs = qaElapsedSs;
		this.originalActualMi = originalActualMi;
		this.rgn = rgn;
		this.totalIdleHh = totalIdleHh;
		this.srCrntStsCd = srCrntStsCd;
		this.pndFlg = pndFlg;
		this.fromDt = fromDt;
		this.totalIdleSs = totalIdleSs;
		this.isStart = isStart;
		this.originalIdleHh = originalIdleHh;
		this.amd = amd;
		this.originalTotalMi = originalTotalMi;
		this.qaElapsedDd = qaElapsedDd;
		this.amendTotalHh = amendTotalHh;
		this.amendTotalDd = amendTotalDd;
		this.srKndCd = srKndCd;
		this.qaElapsedHh = qaElapsedHh;
		this.ibflag = ibflag;
		this.srWrkStsCd = srWrkStsCd;
		this.inputElapsedDd = inputElapsedDd;
		this.totalActualSs = totalActualSs;
		this.totalIdleDd = totalIdleDd;
		this.srAmdTpCd = srAmdTpCd;
		this.inputElapsedHh = inputElapsedHh;
		this.srTrans = srTrans;
		this.originalIdleSs = originalIdleSs;
		this.originalIdleDd = originalIdleDd;
		this.blDrftFaxOutFlg = blDrftFaxOutFlg;
		this.srNo = srNo;
		this.rateElapsedSs = rateElapsedSs;
		this.srAmdTd = srAmdTd;
		this.amendActualMi = amendActualMi;
		this.rcEnd = rcEnd;
		this.qsStart = qsStart;
		this.divide = divide;
		this.originalActualSs = originalActualSs;
		this.amendIdleSs = amendIdleSs;
		this.originalActualDd = originalActualDd;
		this.siElapsedSs = siElapsedSs;
		this.imgPgNo = imgPgNo;
		this.siElapsedDd = siElapsedDd;
		this.totalTotalMi = totalTotalMi;
		this.siElapsedHh = siElapsedHh;
		this.originalTotalHh = originalTotalHh;
		this.qaElapsedMi = qaElapsedMi;
		this.dpcsOfcCd = dpcsOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_aud_flg", getBlAudFlg());
		this.hashColumns.put("via", getVia());
		this.hashColumns.put("original_total_ss", getOriginalTotalSs());
		this.hashColumns.put("total_actual_mi", getTotalActualMi());
		this.hashColumns.put("bl_rt_flg", getBlRtFlg());
		this.hashColumns.put("si_rec", getSiRec());
		this.hashColumns.put("original_total_dd", getOriginalTotalDd());
		this.hashColumns.put("input_elapsed_ss", getInputElapsedSs());
		this.hashColumns.put("amend_idle_mi", getAmendIdleMi());
		this.hashColumns.put("total_total_ss", getTotalTotalSs());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_ofc_cd_d", getBkgOfcCdD());
		this.hashColumns.put("sr_crnt_info_cd", getSrCrntInfoCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("rgn_cd_d", getRgnCdD());
		this.hashColumns.put("rate_elapsed_mi", getRateElapsedMi());
		this.hashColumns.put("ic_end", getIcEnd());
		this.hashColumns.put("total_total_hh", getTotalTotalHh());
		this.hashColumns.put("total_idle_mi", getTotalIdleMi());
		this.hashColumns.put("original_actual_hh", getOriginalActualHh());
		this.hashColumns.put("amend_idle_hh", getAmendIdleHh());
		this.hashColumns.put("add_val", getAddVal());
		this.hashColumns.put("total_total_dd", getTotalTotalDd());
		this.hashColumns.put("amend_total_ss", getAmendTotalSs());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("rs_start", getRsStart());
		this.hashColumns.put("amend_total_mi", getAmendTotalMi());
		this.hashColumns.put("total_actual_hh", getTotalActualHh());
		this.hashColumns.put("bl_doc_inp_flg", getBlDocInpFlg());
		this.hashColumns.put("rate_elapsed_dd", getRateElapsedDd());
		this.hashColumns.put("hbl", getHbl());
		this.hashColumns.put("amend_idle_dd", getAmendIdleDd());
		this.hashColumns.put("total_actual_dd", getTotalActualDd());
		this.hashColumns.put("rate_elapsed_hh", getRateElapsedHh());
		this.hashColumns.put("si_elapsed_mi", getSiElapsedMi());
		this.hashColumns.put("amend_actual_dd", getAmendActualDd());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("amend_actual_ss", getAmendActualSs());
		this.hashColumns.put("original_idle_mi", getOriginalIdleMi());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("qc_end", getQcEnd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("amend_actual_hh", getAmendActualHh());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rgn_cd_cd", getRgnCdCd());
		this.hashColumns.put("input_elapsed_mi", getInputElapsedMi());
		this.hashColumns.put("cm", getCm());
		this.hashColumns.put("qa_elapsed_ss", getQaElapsedSs());
		this.hashColumns.put("original_actual_mi", getOriginalActualMi());
		this.hashColumns.put("rgn", getRgn());
		this.hashColumns.put("total_idle_hh", getTotalIdleHh());
		this.hashColumns.put("sr_crnt_sts_cd", getSrCrntStsCd());
		this.hashColumns.put("pnd_flg", getPndFlg());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("total_idle_ss", getTotalIdleSs());
		this.hashColumns.put("is_start", getIsStart());
		this.hashColumns.put("original_idle_hh", getOriginalIdleHh());
		this.hashColumns.put("amd", getAmd());
		this.hashColumns.put("original_total_mi", getOriginalTotalMi());
		this.hashColumns.put("qa_elapsed_dd", getQaElapsedDd());
		this.hashColumns.put("amend_total_hh", getAmendTotalHh());
		this.hashColumns.put("amend_total_dd", getAmendTotalDd());
		this.hashColumns.put("sr_knd_cd", getSrKndCd());
		this.hashColumns.put("qa_elapsed_hh", getQaElapsedHh());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sr_wrk_sts_cd", getSrWrkStsCd());
		this.hashColumns.put("input_elapsed_dd", getInputElapsedDd());
		this.hashColumns.put("total_actual_ss", getTotalActualSs());
		this.hashColumns.put("total_idle_dd", getTotalIdleDd());
		this.hashColumns.put("sr_amd_tp_cd", getSrAmdTpCd());
		this.hashColumns.put("input_elapsed_hh", getInputElapsedHh());
		this.hashColumns.put("sr_trans", getSrTrans());
		this.hashColumns.put("original_idle_ss", getOriginalIdleSs());
		this.hashColumns.put("original_idle_dd", getOriginalIdleDd());
		this.hashColumns.put("bl_drft_fax_out_flg", getBlDrftFaxOutFlg());
		this.hashColumns.put("sr_no", getSrNo());
		this.hashColumns.put("rate_elapsed_ss", getRateElapsedSs());
		this.hashColumns.put("sr_amd_td", getSrAmdTd());
		this.hashColumns.put("amend_actual_mi", getAmendActualMi());
		this.hashColumns.put("rc_end", getRcEnd());
		this.hashColumns.put("qs_start", getQsStart());
		this.hashColumns.put("divide", getDivide());
		this.hashColumns.put("original_actual_ss", getOriginalActualSs());
		this.hashColumns.put("amend_idle_ss", getAmendIdleSs());
		this.hashColumns.put("original_actual_dd", getOriginalActualDd());
		this.hashColumns.put("si_elapsed_ss", getSiElapsedSs());
		this.hashColumns.put("img_pg_no", getImgPgNo());
		this.hashColumns.put("si_elapsed_dd", getSiElapsedDd());
		this.hashColumns.put("total_total_mi", getTotalTotalMi());
		this.hashColumns.put("si_elapsed_hh", getSiElapsedHh());
		this.hashColumns.put("original_total_hh", getOriginalTotalHh());
		this.hashColumns.put("qa_elapsed_mi", getQaElapsedMi());
		this.hashColumns.put("dpcs_ofc_cd", getDpcsOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_aud_flg", "blAudFlg");
		this.hashFields.put("via", "via");
		this.hashFields.put("original_total_ss", "originalTotalSs");
		this.hashFields.put("total_actual_mi", "totalActualMi");
		this.hashFields.put("bl_rt_flg", "blRtFlg");
		this.hashFields.put("si_rec", "siRec");
		this.hashFields.put("original_total_dd", "originalTotalDd");
		this.hashFields.put("input_elapsed_ss", "inputElapsedSs");
		this.hashFields.put("amend_idle_mi", "amendIdleMi");
		this.hashFields.put("total_total_ss", "totalTotalSs");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_ofc_cd_d", "bkgOfcCdD");
		this.hashFields.put("sr_crnt_info_cd", "srCrntInfoCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("rgn_cd_d", "rgnCdD");
		this.hashFields.put("rate_elapsed_mi", "rateElapsedMi");
		this.hashFields.put("ic_end", "icEnd");
		this.hashFields.put("total_total_hh", "totalTotalHh");
		this.hashFields.put("total_idle_mi", "totalIdleMi");
		this.hashFields.put("original_actual_hh", "originalActualHh");
		this.hashFields.put("amend_idle_hh", "amendIdleHh");
		this.hashFields.put("add_val", "addVal");
		this.hashFields.put("total_total_dd", "totalTotalDd");
		this.hashFields.put("amend_total_ss", "amendTotalSs");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("rs_start", "rsStart");
		this.hashFields.put("amend_total_mi", "amendTotalMi");
		this.hashFields.put("total_actual_hh", "totalActualHh");
		this.hashFields.put("bl_doc_inp_flg", "blDocInpFlg");
		this.hashFields.put("rate_elapsed_dd", "rateElapsedDd");
		this.hashFields.put("hbl", "hbl");
		this.hashFields.put("amend_idle_dd", "amendIdleDd");
		this.hashFields.put("total_actual_dd", "totalActualDd");
		this.hashFields.put("rate_elapsed_hh", "rateElapsedHh");
		this.hashFields.put("si_elapsed_mi", "siElapsedMi");
		this.hashFields.put("amend_actual_dd", "amendActualDd");
		this.hashFields.put("period", "period");
		this.hashFields.put("amend_actual_ss", "amendActualSs");
		this.hashFields.put("original_idle_mi", "originalIdleMi");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("qc_end", "qcEnd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("amend_actual_hh", "amendActualHh");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rgn_cd_cd", "rgnCdCd");
		this.hashFields.put("input_elapsed_mi", "inputElapsedMi");
		this.hashFields.put("cm", "cm");
		this.hashFields.put("qa_elapsed_ss", "qaElapsedSs");
		this.hashFields.put("original_actual_mi", "originalActualMi");
		this.hashFields.put("rgn", "rgn");
		this.hashFields.put("total_idle_hh", "totalIdleHh");
		this.hashFields.put("sr_crnt_sts_cd", "srCrntStsCd");
		this.hashFields.put("pnd_flg", "pndFlg");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("total_idle_ss", "totalIdleSs");
		this.hashFields.put("is_start", "isStart");
		this.hashFields.put("original_idle_hh", "originalIdleHh");
		this.hashFields.put("amd", "amd");
		this.hashFields.put("original_total_mi", "originalTotalMi");
		this.hashFields.put("qa_elapsed_dd", "qaElapsedDd");
		this.hashFields.put("amend_total_hh", "amendTotalHh");
		this.hashFields.put("amend_total_dd", "amendTotalDd");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("qa_elapsed_hh", "qaElapsedHh");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sr_wrk_sts_cd", "srWrkStsCd");
		this.hashFields.put("input_elapsed_dd", "inputElapsedDd");
		this.hashFields.put("total_actual_ss", "totalActualSs");
		this.hashFields.put("total_idle_dd", "totalIdleDd");
		this.hashFields.put("sr_amd_tp_cd", "srAmdTpCd");
		this.hashFields.put("input_elapsed_hh", "inputElapsedHh");
		this.hashFields.put("sr_trans", "srTrans");
		this.hashFields.put("original_idle_ss", "originalIdleSs");
		this.hashFields.put("original_idle_dd", "originalIdleDd");
		this.hashFields.put("bl_drft_fax_out_flg", "blDrftFaxOutFlg");
		this.hashFields.put("sr_no", "srNo");
		this.hashFields.put("rate_elapsed_ss", "rateElapsedSs");
		this.hashFields.put("sr_amd_td", "srAmdTd");
		this.hashFields.put("amend_actual_mi", "amendActualMi");
		this.hashFields.put("rc_end", "rcEnd");
		this.hashFields.put("qs_start", "qsStart");
		this.hashFields.put("divide", "divide");
		this.hashFields.put("original_actual_ss", "originalActualSs");
		this.hashFields.put("amend_idle_ss", "amendIdleSs");
		this.hashFields.put("original_actual_dd", "originalActualDd");
		this.hashFields.put("si_elapsed_ss", "siElapsedSs");
		this.hashFields.put("img_pg_no", "imgPgNo");
		this.hashFields.put("si_elapsed_dd", "siElapsedDd");
		this.hashFields.put("total_total_mi", "totalTotalMi");
		this.hashFields.put("si_elapsed_hh", "siElapsedHh");
		this.hashFields.put("original_total_hh", "originalTotalHh");
		this.hashFields.put("qa_elapsed_mi", "qaElapsedMi");
		this.hashFields.put("dpcs_ofc_cd", "dpcsOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blAudFlg
	 */
	public String getBlAudFlg() {
		return this.blAudFlg;
	}
	
	/**
	 * Column Info
	 * @return via
	 */
	public String getVia() {
		return this.via;
	}
	
	/**
	 * Column Info
	 * @return originalTotalSs
	 */
	public String getOriginalTotalSs() {
		return this.originalTotalSs;
	}
	
	/**
	 * Column Info
	 * @return totalActualMi
	 */
	public String getTotalActualMi() {
		return this.totalActualMi;
	}
	
	/**
	 * Column Info
	 * @return blRtFlg
	 */
	public String getBlRtFlg() {
		return this.blRtFlg;
	}
	
	/**
	 * Column Info
	 * @return siRec
	 */
	public String getSiRec() {
		return this.siRec;
	}
	
	/**
	 * Column Info
	 * @return originalTotalDd
	 */
	public String getOriginalTotalDd() {
		return this.originalTotalDd;
	}
	
	/**
	 * Column Info
	 * @return inputElapsedSs
	 */
	public String getInputElapsedSs() {
		return this.inputElapsedSs;
	}
	
	/**
	 * Column Info
	 * @return amendIdleMi
	 */
	public String getAmendIdleMi() {
		return this.amendIdleMi;
	}
	
	/**
	 * Column Info
	 * @return totalTotalSs
	 */
	public String getTotalTotalSs() {
		return this.totalTotalSs;
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
	 * @return bkgOfcCdD
	 */
	public String getBkgOfcCdD() {
		return this.bkgOfcCdD;
	}
	
	/**
	 * Column Info
	 * @return srCrntInfoCd
	 */
	public String getSrCrntInfoCd() {
		return this.srCrntInfoCd;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return rgnCdD
	 */
	public String getRgnCdD() {
		return this.rgnCdD;
	}
	
	/**
	 * Column Info
	 * @return rateElapsedMi
	 */
	public String getRateElapsedMi() {
		return this.rateElapsedMi;
	}
	
	/**
	 * Column Info
	 * @return icEnd
	 */
	public String getIcEnd() {
		return this.icEnd;
	}
	
	/**
	 * Column Info
	 * @return totalTotalHh
	 */
	public String getTotalTotalHh() {
		return this.totalTotalHh;
	}
	
	/**
	 * Column Info
	 * @return totalIdleMi
	 */
	public String getTotalIdleMi() {
		return this.totalIdleMi;
	}
	
	/**
	 * Column Info
	 * @return originalActualHh
	 */
	public String getOriginalActualHh() {
		return this.originalActualHh;
	}
	
	/**
	 * Column Info
	 * @return amendIdleHh
	 */
	public String getAmendIdleHh() {
		return this.amendIdleHh;
	}
	
	/**
	 * Column Info
	 * @return addVal
	 */
	public String getAddVal() {
		return this.addVal;
	}
	
	/**
	 * Column Info
	 * @return totalTotalDd
	 */
	public String getTotalTotalDd() {
		return this.totalTotalDd;
	}
	
	/**
	 * Column Info
	 * @return amendTotalSs
	 */
	public String getAmendTotalSs() {
		return this.amendTotalSs;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rsStart
	 */
	public String getRsStart() {
		return this.rsStart;
	}
	
	/**
	 * Column Info
	 * @return amendTotalMi
	 */
	public String getAmendTotalMi() {
		return this.amendTotalMi;
	}
	
	/**
	 * Column Info
	 * @return totalActualHh
	 */
	public String getTotalActualHh() {
		return this.totalActualHh;
	}
	
	/**
	 * Column Info
	 * @return blDocInpFlg
	 */
	public String getBlDocInpFlg() {
		return this.blDocInpFlg;
	}
	
	/**
	 * Column Info
	 * @return rateElapsedDd
	 */
	public String getRateElapsedDd() {
		return this.rateElapsedDd;
	}
	
	/**
	 * Column Info
	 * @return hbl
	 */
	public String getHbl() {
		return this.hbl;
	}
	
	/**
	 * Column Info
	 * @return amendIdleDd
	 */
	public String getAmendIdleDd() {
		return this.amendIdleDd;
	}
	
	/**
	 * Column Info
	 * @return totalActualDd
	 */
	public String getTotalActualDd() {
		return this.totalActualDd;
	}
	
	/**
	 * Column Info
	 * @return rateElapsedHh
	 */
	public String getRateElapsedHh() {
		return this.rateElapsedHh;
	}
	
	/**
	 * Column Info
	 * @return siElapsedMi
	 */
	public String getSiElapsedMi() {
		return this.siElapsedMi;
	}
	
	/**
	 * Column Info
	 * @return amendActualDd
	 */
	public String getAmendActualDd() {
		return this.amendActualDd;
	}
	
	/**
	 * Column Info
	 * @return period
	 */
	public String getPeriod() {
		return this.period;
	}
	
	/**
	 * Column Info
	 * @return amendActualSs
	 */
	public String getAmendActualSs() {
		return this.amendActualSs;
	}
	
	/**
	 * Column Info
	 * @return originalIdleMi
	 */
	public String getOriginalIdleMi() {
		return this.originalIdleMi;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return qcEnd
	 */
	public String getQcEnd() {
		return this.qcEnd;
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
	 * @return amendActualHh
	 */
	public String getAmendActualHh() {
		return this.amendActualHh;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return rgnCdCd
	 */
	public String getRgnCdCd() {
		return this.rgnCdCd;
	}
	
	/**
	 * Column Info
	 * @return inputElapsedMi
	 */
	public String getInputElapsedMi() {
		return this.inputElapsedMi;
	}
	
	/**
	 * Column Info
	 * @return cm
	 */
	public String getCm() {
		return this.cm;
	}
	
	/**
	 * Column Info
	 * @return qaElapsedSs
	 */
	public String getQaElapsedSs() {
		return this.qaElapsedSs;
	}
	
	/**
	 * Column Info
	 * @return originalActualMi
	 */
	public String getOriginalActualMi() {
		return this.originalActualMi;
	}
	
	/**
	 * Column Info
	 * @return rgn
	 */
	public String getRgn() {
		return this.rgn;
	}
	
	/**
	 * Column Info
	 * @return totalIdleHh
	 */
	public String getTotalIdleHh() {
		return this.totalIdleHh;
	}
	
	/**
	 * Column Info
	 * @return srCrntStsCd
	 */
	public String getSrCrntStsCd() {
		return this.srCrntStsCd;
	}
	
	/**
	 * Column Info
	 * @return pndFlg
	 */
	public String getPndFlg() {
		return this.pndFlg;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return totalIdleSs
	 */
	public String getTotalIdleSs() {
		return this.totalIdleSs;
	}
	
	/**
	 * Column Info
	 * @return isStart
	 */
	public String getIsStart() {
		return this.isStart;
	}
	
	/**
	 * Column Info
	 * @return originalIdleHh
	 */
	public String getOriginalIdleHh() {
		return this.originalIdleHh;
	}
	
	/**
	 * Column Info
	 * @return amd
	 */
	public String getAmd() {
		return this.amd;
	}
	
	/**
	 * Column Info
	 * @return originalTotalMi
	 */
	public String getOriginalTotalMi() {
		return this.originalTotalMi;
	}
	
	/**
	 * Column Info
	 * @return qaElapsedDd
	 */
	public String getQaElapsedDd() {
		return this.qaElapsedDd;
	}
	
	/**
	 * Column Info
	 * @return amendTotalHh
	 */
	public String getAmendTotalHh() {
		return this.amendTotalHh;
	}
	
	/**
	 * Column Info
	 * @return amendTotalDd
	 */
	public String getAmendTotalDd() {
		return this.amendTotalDd;
	}
	
	/**
	 * Column Info
	 * @return srKndCd
	 */
	public String getSrKndCd() {
		return this.srKndCd;
	}
	
	/**
	 * Column Info
	 * @return qaElapsedHh
	 */
	public String getQaElapsedHh() {
		return this.qaElapsedHh;
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
	 * @return srWrkStsCd
	 */
	public String getSrWrkStsCd() {
		return this.srWrkStsCd;
	}
	
	/**
	 * Column Info
	 * @return inputElapsedDd
	 */
	public String getInputElapsedDd() {
		return this.inputElapsedDd;
	}
	
	/**
	 * Column Info
	 * @return totalActualSs
	 */
	public String getTotalActualSs() {
		return this.totalActualSs;
	}
	
	/**
	 * Column Info
	 * @return totalIdleDd
	 */
	public String getTotalIdleDd() {
		return this.totalIdleDd;
	}
	
	/**
	 * Column Info
	 * @return srAmdTpCd
	 */
	public String getSrAmdTpCd() {
		return this.srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @return inputElapsedHh
	 */
	public String getInputElapsedHh() {
		return this.inputElapsedHh;
	}
	
	/**
	 * Column Info
	 * @return srTrans
	 */
	public String getSrTrans() {
		return this.srTrans;
	}
	
	/**
	 * Column Info
	 * @return originalIdleSs
	 */
	public String getOriginalIdleSs() {
		return this.originalIdleSs;
	}
	
	/**
	 * Column Info
	 * @return originalIdleDd
	 */
	public String getOriginalIdleDd() {
		return this.originalIdleDd;
	}
	
	/**
	 * Column Info
	 * @return blDrftFaxOutFlg
	 */
	public String getBlDrftFaxOutFlg() {
		return this.blDrftFaxOutFlg;
	}
	
	/**
	 * Column Info
	 * @return srNo
	 */
	public String getSrNo() {
		return this.srNo;
	}
	
	/**
	 * Column Info
	 * @return rateElapsedSs
	 */
	public String getRateElapsedSs() {
		return this.rateElapsedSs;
	}
	
	/**
	 * Column Info
	 * @return srAmdTd
	 */
	public String getSrAmdTd() {
		return this.srAmdTd;
	}
	
	/**
	 * Column Info
	 * @return amendActualMi
	 */
	public String getAmendActualMi() {
		return this.amendActualMi;
	}
	
	/**
	 * Column Info
	 * @return rcEnd
	 */
	public String getRcEnd() {
		return this.rcEnd;
	}
	
	/**
	 * Column Info
	 * @return qsStart
	 */
	public String getQsStart() {
		return this.qsStart;
	}
	
	/**
	 * Column Info
	 * @return divide
	 */
	public String getDivide() {
		return this.divide;
	}
	
	/**
	 * Column Info
	 * @return originalActualSs
	 */
	public String getOriginalActualSs() {
		return this.originalActualSs;
	}
	
	/**
	 * Column Info
	 * @return amendIdleSs
	 */
	public String getAmendIdleSs() {
		return this.amendIdleSs;
	}
	
	/**
	 * Column Info
	 * @return originalActualDd
	 */
	public String getOriginalActualDd() {
		return this.originalActualDd;
	}
	
	/**
	 * Column Info
	 * @return siElapsedSs
	 */
	public String getSiElapsedSs() {
		return this.siElapsedSs;
	}
	
	/**
	 * Column Info
	 * @return imgPgNo
	 */
	public String getImgPgNo() {
		return this.imgPgNo;
	}
	
	/**
	 * Column Info
	 * @return siElapsedDd
	 */
	public String getSiElapsedDd() {
		return this.siElapsedDd;
	}
	
	/**
	 * Column Info
	 * @return totalTotalMi
	 */
	public String getTotalTotalMi() {
		return this.totalTotalMi;
	}
	
	/**
	 * Column Info
	 * @return siElapsedHh
	 */
	public String getSiElapsedHh() {
		return this.siElapsedHh;
	}
	
	/**
	 * Column Info
	 * @return originalTotalHh
	 */
	public String getOriginalTotalHh() {
		return this.originalTotalHh;
	}
	
	/**
	 * Column Info
	 * @return qaElapsedMi
	 */
	public String getQaElapsedMi() {
		return this.qaElapsedMi;
	}
	
	/**
	 * Column Info
	 * @return dpcsOfcCd
	 */
	public String getDpcsOfcCd() {
		return this.dpcsOfcCd;
	}
	

	/**
	 * Column Info
	 * @param blAudFlg
	 */
	public void setBlAudFlg(String blAudFlg) {
		this.blAudFlg = blAudFlg;
	}
	
	/**
	 * Column Info
	 * @param via
	 */
	public void setVia(String via) {
		this.via = via;
	}
	
	/**
	 * Column Info
	 * @param originalTotalSs
	 */
	public void setOriginalTotalSs(String originalTotalSs) {
		this.originalTotalSs = originalTotalSs;
	}
	
	/**
	 * Column Info
	 * @param totalActualMi
	 */
	public void setTotalActualMi(String totalActualMi) {
		this.totalActualMi = totalActualMi;
	}
	
	/**
	 * Column Info
	 * @param blRtFlg
	 */
	public void setBlRtFlg(String blRtFlg) {
		this.blRtFlg = blRtFlg;
	}
	
	/**
	 * Column Info
	 * @param siRec
	 */
	public void setSiRec(String siRec) {
		this.siRec = siRec;
	}
	
	/**
	 * Column Info
	 * @param originalTotalDd
	 */
	public void setOriginalTotalDd(String originalTotalDd) {
		this.originalTotalDd = originalTotalDd;
	}
	
	/**
	 * Column Info
	 * @param inputElapsedSs
	 */
	public void setInputElapsedSs(String inputElapsedSs) {
		this.inputElapsedSs = inputElapsedSs;
	}
	
	/**
	 * Column Info
	 * @param amendIdleMi
	 */
	public void setAmendIdleMi(String amendIdleMi) {
		this.amendIdleMi = amendIdleMi;
	}
	
	/**
	 * Column Info
	 * @param totalTotalSs
	 */
	public void setTotalTotalSs(String totalTotalSs) {
		this.totalTotalSs = totalTotalSs;
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
	 * @param bkgOfcCdD
	 */
	public void setBkgOfcCdD(String bkgOfcCdD) {
		this.bkgOfcCdD = bkgOfcCdD;
	}
	
	/**
	 * Column Info
	 * @param srCrntInfoCd
	 */
	public void setSrCrntInfoCd(String srCrntInfoCd) {
		this.srCrntInfoCd = srCrntInfoCd;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param rgnCdD
	 */
	public void setRgnCdD(String rgnCdD) {
		this.rgnCdD = rgnCdD;
	}
	
	/**
	 * Column Info
	 * @param rateElapsedMi
	 */
	public void setRateElapsedMi(String rateElapsedMi) {
		this.rateElapsedMi = rateElapsedMi;
	}
	
	/**
	 * Column Info
	 * @param icEnd
	 */
	public void setIcEnd(String icEnd) {
		this.icEnd = icEnd;
	}
	
	/**
	 * Column Info
	 * @param totalTotalHh
	 */
	public void setTotalTotalHh(String totalTotalHh) {
		this.totalTotalHh = totalTotalHh;
	}
	
	/**
	 * Column Info
	 * @param totalIdleMi
	 */
	public void setTotalIdleMi(String totalIdleMi) {
		this.totalIdleMi = totalIdleMi;
	}
	
	/**
	 * Column Info
	 * @param originalActualHh
	 */
	public void setOriginalActualHh(String originalActualHh) {
		this.originalActualHh = originalActualHh;
	}
	
	/**
	 * Column Info
	 * @param amendIdleHh
	 */
	public void setAmendIdleHh(String amendIdleHh) {
		this.amendIdleHh = amendIdleHh;
	}
	
	/**
	 * Column Info
	 * @param addVal
	 */
	public void setAddVal(String addVal) {
		this.addVal = addVal;
	}
	
	/**
	 * Column Info
	 * @param totalTotalDd
	 */
	public void setTotalTotalDd(String totalTotalDd) {
		this.totalTotalDd = totalTotalDd;
	}
	
	/**
	 * Column Info
	 * @param amendTotalSs
	 */
	public void setAmendTotalSs(String amendTotalSs) {
		this.amendTotalSs = amendTotalSs;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rsStart
	 */
	public void setRsStart(String rsStart) {
		this.rsStart = rsStart;
	}
	
	/**
	 * Column Info
	 * @param amendTotalMi
	 */
	public void setAmendTotalMi(String amendTotalMi) {
		this.amendTotalMi = amendTotalMi;
	}
	
	/**
	 * Column Info
	 * @param totalActualHh
	 */
	public void setTotalActualHh(String totalActualHh) {
		this.totalActualHh = totalActualHh;
	}
	
	/**
	 * Column Info
	 * @param blDocInpFlg
	 */
	public void setBlDocInpFlg(String blDocInpFlg) {
		this.blDocInpFlg = blDocInpFlg;
	}
	
	/**
	 * Column Info
	 * @param rateElapsedDd
	 */
	public void setRateElapsedDd(String rateElapsedDd) {
		this.rateElapsedDd = rateElapsedDd;
	}
	
	/**
	 * Column Info
	 * @param hbl
	 */
	public void setHbl(String hbl) {
		this.hbl = hbl;
	}
	
	/**
	 * Column Info
	 * @param amendIdleDd
	 */
	public void setAmendIdleDd(String amendIdleDd) {
		this.amendIdleDd = amendIdleDd;
	}
	
	/**
	 * Column Info
	 * @param totalActualDd
	 */
	public void setTotalActualDd(String totalActualDd) {
		this.totalActualDd = totalActualDd;
	}
	
	/**
	 * Column Info
	 * @param rateElapsedHh
	 */
	public void setRateElapsedHh(String rateElapsedHh) {
		this.rateElapsedHh = rateElapsedHh;
	}
	
	/**
	 * Column Info
	 * @param siElapsedMi
	 */
	public void setSiElapsedMi(String siElapsedMi) {
		this.siElapsedMi = siElapsedMi;
	}
	
	/**
	 * Column Info
	 * @param amendActualDd
	 */
	public void setAmendActualDd(String amendActualDd) {
		this.amendActualDd = amendActualDd;
	}
	
	/**
	 * Column Info
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
	}
	
	/**
	 * Column Info
	 * @param amendActualSs
	 */
	public void setAmendActualSs(String amendActualSs) {
		this.amendActualSs = amendActualSs;
	}
	
	/**
	 * Column Info
	 * @param originalIdleMi
	 */
	public void setOriginalIdleMi(String originalIdleMi) {
		this.originalIdleMi = originalIdleMi;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param qcEnd
	 */
	public void setQcEnd(String qcEnd) {
		this.qcEnd = qcEnd;
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
	 * @param amendActualHh
	 */
	public void setAmendActualHh(String amendActualHh) {
		this.amendActualHh = amendActualHh;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param rgnCdCd
	 */
	public void setRgnCdCd(String rgnCdCd) {
		this.rgnCdCd = rgnCdCd;
	}
	
	/**
	 * Column Info
	 * @param inputElapsedMi
	 */
	public void setInputElapsedMi(String inputElapsedMi) {
		this.inputElapsedMi = inputElapsedMi;
	}
	
	/**
	 * Column Info
	 * @param cm
	 */
	public void setCm(String cm) {
		this.cm = cm;
	}
	
	/**
	 * Column Info
	 * @param qaElapsedSs
	 */
	public void setQaElapsedSs(String qaElapsedSs) {
		this.qaElapsedSs = qaElapsedSs;
	}
	
	/**
	 * Column Info
	 * @param originalActualMi
	 */
	public void setOriginalActualMi(String originalActualMi) {
		this.originalActualMi = originalActualMi;
	}
	
	/**
	 * Column Info
	 * @param rgn
	 */
	public void setRgn(String rgn) {
		this.rgn = rgn;
	}
	
	/**
	 * Column Info
	 * @param totalIdleHh
	 */
	public void setTotalIdleHh(String totalIdleHh) {
		this.totalIdleHh = totalIdleHh;
	}
	
	/**
	 * Column Info
	 * @param srCrntStsCd
	 */
	public void setSrCrntStsCd(String srCrntStsCd) {
		this.srCrntStsCd = srCrntStsCd;
	}
	
	/**
	 * Column Info
	 * @param pndFlg
	 */
	public void setPndFlg(String pndFlg) {
		this.pndFlg = pndFlg;
	}
	
	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param totalIdleSs
	 */
	public void setTotalIdleSs(String totalIdleSs) {
		this.totalIdleSs = totalIdleSs;
	}
	
	/**
	 * Column Info
	 * @param isStart
	 */
	public void setIsStart(String isStart) {
		this.isStart = isStart;
	}
	
	/**
	 * Column Info
	 * @param originalIdleHh
	 */
	public void setOriginalIdleHh(String originalIdleHh) {
		this.originalIdleHh = originalIdleHh;
	}
	
	/**
	 * Column Info
	 * @param amd
	 */
	public void setAmd(String amd) {
		this.amd = amd;
	}
	
	/**
	 * Column Info
	 * @param originalTotalMi
	 */
	public void setOriginalTotalMi(String originalTotalMi) {
		this.originalTotalMi = originalTotalMi;
	}
	
	/**
	 * Column Info
	 * @param qaElapsedDd
	 */
	public void setQaElapsedDd(String qaElapsedDd) {
		this.qaElapsedDd = qaElapsedDd;
	}
	
	/**
	 * Column Info
	 * @param amendTotalHh
	 */
	public void setAmendTotalHh(String amendTotalHh) {
		this.amendTotalHh = amendTotalHh;
	}
	
	/**
	 * Column Info
	 * @param amendTotalDd
	 */
	public void setAmendTotalDd(String amendTotalDd) {
		this.amendTotalDd = amendTotalDd;
	}
	
	/**
	 * Column Info
	 * @param srKndCd
	 */
	public void setSrKndCd(String srKndCd) {
		this.srKndCd = srKndCd;
	}
	
	/**
	 * Column Info
	 * @param qaElapsedHh
	 */
	public void setQaElapsedHh(String qaElapsedHh) {
		this.qaElapsedHh = qaElapsedHh;
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
	 * @param srWrkStsCd
	 */
	public void setSrWrkStsCd(String srWrkStsCd) {
		this.srWrkStsCd = srWrkStsCd;
	}
	
	/**
	 * Column Info
	 * @param inputElapsedDd
	 */
	public void setInputElapsedDd(String inputElapsedDd) {
		this.inputElapsedDd = inputElapsedDd;
	}
	
	/**
	 * Column Info
	 * @param totalActualSs
	 */
	public void setTotalActualSs(String totalActualSs) {
		this.totalActualSs = totalActualSs;
	}
	
	/**
	 * Column Info
	 * @param totalIdleDd
	 */
	public void setTotalIdleDd(String totalIdleDd) {
		this.totalIdleDd = totalIdleDd;
	}
	
	/**
	 * Column Info
	 * @param srAmdTpCd
	 */
	public void setSrAmdTpCd(String srAmdTpCd) {
		this.srAmdTpCd = srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @param inputElapsedHh
	 */
	public void setInputElapsedHh(String inputElapsedHh) {
		this.inputElapsedHh = inputElapsedHh;
	}
	
	/**
	 * Column Info
	 * @param srTrans
	 */
	public void setSrTrans(String srTrans) {
		this.srTrans = srTrans;
	}
	
	/**
	 * Column Info
	 * @param originalIdleSs
	 */
	public void setOriginalIdleSs(String originalIdleSs) {
		this.originalIdleSs = originalIdleSs;
	}
	
	/**
	 * Column Info
	 * @param originalIdleDd
	 */
	public void setOriginalIdleDd(String originalIdleDd) {
		this.originalIdleDd = originalIdleDd;
	}
	
	/**
	 * Column Info
	 * @param blDrftFaxOutFlg
	 */
	public void setBlDrftFaxOutFlg(String blDrftFaxOutFlg) {
		this.blDrftFaxOutFlg = blDrftFaxOutFlg;
	}
	
	/**
	 * Column Info
	 * @param srNo
	 */
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	
	/**
	 * Column Info
	 * @param rateElapsedSs
	 */
	public void setRateElapsedSs(String rateElapsedSs) {
		this.rateElapsedSs = rateElapsedSs;
	}
	
	/**
	 * Column Info
	 * @param srAmdTd
	 */
	public void setSrAmdTd(String srAmdTd) {
		this.srAmdTd = srAmdTd;
	}
	
	/**
	 * Column Info
	 * @param amendActualMi
	 */
	public void setAmendActualMi(String amendActualMi) {
		this.amendActualMi = amendActualMi;
	}
	
	/**
	 * Column Info
	 * @param rcEnd
	 */
	public void setRcEnd(String rcEnd) {
		this.rcEnd = rcEnd;
	}
	
	/**
	 * Column Info
	 * @param qsStart
	 */
	public void setQsStart(String qsStart) {
		this.qsStart = qsStart;
	}
	
	/**
	 * Column Info
	 * @param divide
	 */
	public void setDivide(String divide) {
		this.divide = divide;
	}
	
	/**
	 * Column Info
	 * @param originalActualSs
	 */
	public void setOriginalActualSs(String originalActualSs) {
		this.originalActualSs = originalActualSs;
	}
	
	/**
	 * Column Info
	 * @param amendIdleSs
	 */
	public void setAmendIdleSs(String amendIdleSs) {
		this.amendIdleSs = amendIdleSs;
	}
	
	/**
	 * Column Info
	 * @param originalActualDd
	 */
	public void setOriginalActualDd(String originalActualDd) {
		this.originalActualDd = originalActualDd;
	}
	
	/**
	 * Column Info
	 * @param siElapsedSs
	 */
	public void setSiElapsedSs(String siElapsedSs) {
		this.siElapsedSs = siElapsedSs;
	}
	
	/**
	 * Column Info
	 * @param imgPgNo
	 */
	public void setImgPgNo(String imgPgNo) {
		this.imgPgNo = imgPgNo;
	}
	
	/**
	 * Column Info
	 * @param siElapsedDd
	 */
	public void setSiElapsedDd(String siElapsedDd) {
		this.siElapsedDd = siElapsedDd;
	}
	
	/**
	 * Column Info
	 * @param totalTotalMi
	 */
	public void setTotalTotalMi(String totalTotalMi) {
		this.totalTotalMi = totalTotalMi;
	}
	
	/**
	 * Column Info
	 * @param siElapsedHh
	 */
	public void setSiElapsedHh(String siElapsedHh) {
		this.siElapsedHh = siElapsedHh;
	}
	
	/**
	 * Column Info
	 * @param originalTotalHh
	 */
	public void setOriginalTotalHh(String originalTotalHh) {
		this.originalTotalHh = originalTotalHh;
	}
	
	/**
	 * Column Info
	 * @param qaElapsedMi
	 */
	public void setQaElapsedMi(String qaElapsedMi) {
		this.qaElapsedMi = qaElapsedMi;
	}
	
	/**
	 * Column Info
	 * @param dpcsOfcCd
	 */
	public void setDpcsOfcCd(String dpcsOfcCd) {
		this.dpcsOfcCd = dpcsOfcCd;
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
		setBlAudFlg(JSPUtil.getParameter(request, prefix + "bl_aud_flg", ""));
		setVia(JSPUtil.getParameter(request, prefix + "via", ""));
		setOriginalTotalSs(JSPUtil.getParameter(request, prefix + "original_total_ss", ""));
		setTotalActualMi(JSPUtil.getParameter(request, prefix + "total_actual_mi", ""));
		setBlRtFlg(JSPUtil.getParameter(request, prefix + "bl_rt_flg", ""));
		setSiRec(JSPUtil.getParameter(request, prefix + "si_rec", ""));
		setOriginalTotalDd(JSPUtil.getParameter(request, prefix + "original_total_dd", ""));
		setInputElapsedSs(JSPUtil.getParameter(request, prefix + "input_elapsed_ss", ""));
		setAmendIdleMi(JSPUtil.getParameter(request, prefix + "amend_idle_mi", ""));
		setTotalTotalSs(JSPUtil.getParameter(request, prefix + "total_total_ss", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgOfcCdD(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd_d", ""));
		setSrCrntInfoCd(JSPUtil.getParameter(request, prefix + "sr_crnt_info_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setRgnCdD(JSPUtil.getParameter(request, prefix + "rgn_cd_d", ""));
		setRateElapsedMi(JSPUtil.getParameter(request, prefix + "rate_elapsed_mi", ""));
		setIcEnd(JSPUtil.getParameter(request, prefix + "ic_end", ""));
		setTotalTotalHh(JSPUtil.getParameter(request, prefix + "total_total_hh", ""));
		setTotalIdleMi(JSPUtil.getParameter(request, prefix + "total_idle_mi", ""));
		setOriginalActualHh(JSPUtil.getParameter(request, prefix + "original_actual_hh", ""));
		setAmendIdleHh(JSPUtil.getParameter(request, prefix + "amend_idle_hh", ""));
		setAddVal(JSPUtil.getParameter(request, prefix + "add_val", ""));
		setTotalTotalDd(JSPUtil.getParameter(request, prefix + "total_total_dd", ""));
		setAmendTotalSs(JSPUtil.getParameter(request, prefix + "amend_total_ss", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setRsStart(JSPUtil.getParameter(request, prefix + "rs_start", ""));
		setAmendTotalMi(JSPUtil.getParameter(request, prefix + "amend_total_mi", ""));
		setTotalActualHh(JSPUtil.getParameter(request, prefix + "total_actual_hh", ""));
		setBlDocInpFlg(JSPUtil.getParameter(request, prefix + "bl_doc_inp_flg", ""));
		setRateElapsedDd(JSPUtil.getParameter(request, prefix + "rate_elapsed_dd", ""));
		setHbl(JSPUtil.getParameter(request, prefix + "hbl", ""));
		setAmendIdleDd(JSPUtil.getParameter(request, prefix + "amend_idle_dd", ""));
		setTotalActualDd(JSPUtil.getParameter(request, prefix + "total_actual_dd", ""));
		setRateElapsedHh(JSPUtil.getParameter(request, prefix + "rate_elapsed_hh", ""));
		setSiElapsedMi(JSPUtil.getParameter(request, prefix + "si_elapsed_mi", ""));
		setAmendActualDd(JSPUtil.getParameter(request, prefix + "amend_actual_dd", ""));
		setPeriod(JSPUtil.getParameter(request, prefix + "period", ""));
		setAmendActualSs(JSPUtil.getParameter(request, prefix + "amend_actual_ss", ""));
		setOriginalIdleMi(JSPUtil.getParameter(request, prefix + "original_idle_mi", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setQcEnd(JSPUtil.getParameter(request, prefix + "qc_end", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setAmendActualHh(JSPUtil.getParameter(request, prefix + "amend_actual_hh", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setRgnCdCd(JSPUtil.getParameter(request, prefix + "rgn_cd_cd", ""));
		setInputElapsedMi(JSPUtil.getParameter(request, prefix + "input_elapsed_mi", ""));
		setCm(JSPUtil.getParameter(request, prefix + "cm", ""));
		setQaElapsedSs(JSPUtil.getParameter(request, prefix + "qa_elapsed_ss", ""));
		setOriginalActualMi(JSPUtil.getParameter(request, prefix + "original_actual_mi", ""));
		setRgn(JSPUtil.getParameter(request, prefix + "rgn", ""));
		setTotalIdleHh(JSPUtil.getParameter(request, prefix + "total_idle_hh", ""));
		setSrCrntStsCd(JSPUtil.getParameter(request, prefix + "sr_crnt_sts_cd", ""));
		setPndFlg(JSPUtil.getParameter(request, prefix + "pnd_flg", ""));
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setTotalIdleSs(JSPUtil.getParameter(request, prefix + "total_idle_ss", ""));
		setIsStart(JSPUtil.getParameter(request, prefix + "is_start", ""));
		setOriginalIdleHh(JSPUtil.getParameter(request, prefix + "original_idle_hh", ""));
		setAmd(JSPUtil.getParameter(request, prefix + "amd", ""));
		setOriginalTotalMi(JSPUtil.getParameter(request, prefix + "original_total_mi", ""));
		setQaElapsedDd(JSPUtil.getParameter(request, prefix + "qa_elapsed_dd", ""));
		setAmendTotalHh(JSPUtil.getParameter(request, prefix + "amend_total_hh", ""));
		setAmendTotalDd(JSPUtil.getParameter(request, prefix + "amend_total_dd", ""));
		setSrKndCd(JSPUtil.getParameter(request, prefix + "sr_knd_cd", ""));
		setQaElapsedHh(JSPUtil.getParameter(request, prefix + "qa_elapsed_hh", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSrWrkStsCd(JSPUtil.getParameter(request, prefix + "sr_wrk_sts_cd", ""));
		setInputElapsedDd(JSPUtil.getParameter(request, prefix + "input_elapsed_dd", ""));
		setTotalActualSs(JSPUtil.getParameter(request, prefix + "total_actual_ss", ""));
		setTotalIdleDd(JSPUtil.getParameter(request, prefix + "total_idle_dd", ""));
		setSrAmdTpCd(JSPUtil.getParameter(request, prefix + "sr_amd_tp_cd", ""));
		setInputElapsedHh(JSPUtil.getParameter(request, prefix + "input_elapsed_hh", ""));
		setSrTrans(JSPUtil.getParameter(request, prefix + "sr_trans", ""));
		setOriginalIdleSs(JSPUtil.getParameter(request, prefix + "original_idle_ss", ""));
		setOriginalIdleDd(JSPUtil.getParameter(request, prefix + "original_idle_dd", ""));
		setBlDrftFaxOutFlg(JSPUtil.getParameter(request, prefix + "bl_drft_fax_out_flg", ""));
		setSrNo(JSPUtil.getParameter(request, prefix + "sr_no", ""));
		setRateElapsedSs(JSPUtil.getParameter(request, prefix + "rate_elapsed_ss", ""));
		setSrAmdTd(JSPUtil.getParameter(request, prefix + "sr_amd_td", ""));
		setAmendActualMi(JSPUtil.getParameter(request, prefix + "amend_actual_mi", ""));
		setRcEnd(JSPUtil.getParameter(request, prefix + "rc_end", ""));
		setQsStart(JSPUtil.getParameter(request, prefix + "qs_start", ""));
		setDivide(JSPUtil.getParameter(request, prefix + "divide", ""));
		setOriginalActualSs(JSPUtil.getParameter(request, prefix + "original_actual_ss", ""));
		setAmendIdleSs(JSPUtil.getParameter(request, prefix + "amend_idle_ss", ""));
		setOriginalActualDd(JSPUtil.getParameter(request, prefix + "original_actual_dd", ""));
		setSiElapsedSs(JSPUtil.getParameter(request, prefix + "si_elapsed_ss", ""));
		setImgPgNo(JSPUtil.getParameter(request, prefix + "img_pg_no", ""));
		setSiElapsedDd(JSPUtil.getParameter(request, prefix + "si_elapsed_dd", ""));
		setTotalTotalMi(JSPUtil.getParameter(request, prefix + "total_total_mi", ""));
		setSiElapsedHh(JSPUtil.getParameter(request, prefix + "si_elapsed_hh", ""));
		setOriginalTotalHh(JSPUtil.getParameter(request, prefix + "original_total_hh", ""));
		setQaElapsedMi(JSPUtil.getParameter(request, prefix + "qa_elapsed_mi", ""));
		setDpcsOfcCd(JSPUtil.getParameter(request, prefix + "dpcs_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocPerformanceReportInVO[]
	 */
	public DocPerformanceReportInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocPerformanceReportInVO[]
	 */
	public DocPerformanceReportInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocPerformanceReportInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blAudFlg = (JSPUtil.getParameter(request, prefix	+ "bl_aud_flg", length));
			String[] via = (JSPUtil.getParameter(request, prefix	+ "via", length));
			String[] originalTotalSs = (JSPUtil.getParameter(request, prefix	+ "original_total_ss", length));
			String[] totalActualMi = (JSPUtil.getParameter(request, prefix	+ "total_actual_mi", length));
			String[] blRtFlg = (JSPUtil.getParameter(request, prefix	+ "bl_rt_flg", length));
			String[] siRec = (JSPUtil.getParameter(request, prefix	+ "si_rec", length));
			String[] originalTotalDd = (JSPUtil.getParameter(request, prefix	+ "original_total_dd", length));
			String[] inputElapsedSs = (JSPUtil.getParameter(request, prefix	+ "input_elapsed_ss", length));
			String[] amendIdleMi = (JSPUtil.getParameter(request, prefix	+ "amend_idle_mi", length));
			String[] totalTotalSs = (JSPUtil.getParameter(request, prefix	+ "total_total_ss", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgOfcCdD = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd_d", length));
			String[] srCrntInfoCd = (JSPUtil.getParameter(request, prefix	+ "sr_crnt_info_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] rgnCdD = (JSPUtil.getParameter(request, prefix	+ "rgn_cd_d", length));
			String[] rateElapsedMi = (JSPUtil.getParameter(request, prefix	+ "rate_elapsed_mi", length));
			String[] icEnd = (JSPUtil.getParameter(request, prefix	+ "ic_end", length));
			String[] totalTotalHh = (JSPUtil.getParameter(request, prefix	+ "total_total_hh", length));
			String[] totalIdleMi = (JSPUtil.getParameter(request, prefix	+ "total_idle_mi", length));
			String[] originalActualHh = (JSPUtil.getParameter(request, prefix	+ "original_actual_hh", length));
			String[] amendIdleHh = (JSPUtil.getParameter(request, prefix	+ "amend_idle_hh", length));
			String[] addVal = (JSPUtil.getParameter(request, prefix	+ "add_val", length));
			String[] totalTotalDd = (JSPUtil.getParameter(request, prefix	+ "total_total_dd", length));
			String[] amendTotalSs = (JSPUtil.getParameter(request, prefix	+ "amend_total_ss", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] rsStart = (JSPUtil.getParameter(request, prefix	+ "rs_start", length));
			String[] amendTotalMi = (JSPUtil.getParameter(request, prefix	+ "amend_total_mi", length));
			String[] totalActualHh = (JSPUtil.getParameter(request, prefix	+ "total_actual_hh", length));
			String[] blDocInpFlg = (JSPUtil.getParameter(request, prefix	+ "bl_doc_inp_flg", length));
			String[] rateElapsedDd = (JSPUtil.getParameter(request, prefix	+ "rate_elapsed_dd", length));
			String[] hbl = (JSPUtil.getParameter(request, prefix	+ "hbl", length));
			String[] amendIdleDd = (JSPUtil.getParameter(request, prefix	+ "amend_idle_dd", length));
			String[] totalActualDd = (JSPUtil.getParameter(request, prefix	+ "total_actual_dd", length));
			String[] rateElapsedHh = (JSPUtil.getParameter(request, prefix	+ "rate_elapsed_hh", length));
			String[] siElapsedMi = (JSPUtil.getParameter(request, prefix	+ "si_elapsed_mi", length));
			String[] amendActualDd = (JSPUtil.getParameter(request, prefix	+ "amend_actual_dd", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] amendActualSs = (JSPUtil.getParameter(request, prefix	+ "amend_actual_ss", length));
			String[] originalIdleMi = (JSPUtil.getParameter(request, prefix	+ "original_idle_mi", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] qcEnd = (JSPUtil.getParameter(request, prefix	+ "qc_end", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] amendActualHh = (JSPUtil.getParameter(request, prefix	+ "amend_actual_hh", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] rgnCdCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd_cd", length));
			String[] inputElapsedMi = (JSPUtil.getParameter(request, prefix	+ "input_elapsed_mi", length));
			String[] cm = (JSPUtil.getParameter(request, prefix	+ "cm", length));
			String[] qaElapsedSs = (JSPUtil.getParameter(request, prefix	+ "qa_elapsed_ss", length));
			String[] originalActualMi = (JSPUtil.getParameter(request, prefix	+ "original_actual_mi", length));
			String[] rgn = (JSPUtil.getParameter(request, prefix	+ "rgn", length));
			String[] totalIdleHh = (JSPUtil.getParameter(request, prefix	+ "total_idle_hh", length));
			String[] srCrntStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_crnt_sts_cd", length));
			String[] pndFlg = (JSPUtil.getParameter(request, prefix	+ "pnd_flg", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] totalIdleSs = (JSPUtil.getParameter(request, prefix	+ "total_idle_ss", length));
			String[] isStart = (JSPUtil.getParameter(request, prefix	+ "is_start", length));
			String[] originalIdleHh = (JSPUtil.getParameter(request, prefix	+ "original_idle_hh", length));
			String[] amd = (JSPUtil.getParameter(request, prefix	+ "amd", length));
			String[] originalTotalMi = (JSPUtil.getParameter(request, prefix	+ "original_total_mi", length));
			String[] qaElapsedDd = (JSPUtil.getParameter(request, prefix	+ "qa_elapsed_dd", length));
			String[] amendTotalHh = (JSPUtil.getParameter(request, prefix	+ "amend_total_hh", length));
			String[] amendTotalDd = (JSPUtil.getParameter(request, prefix	+ "amend_total_dd", length));
			String[] srKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_knd_cd", length));
			String[] qaElapsedHh = (JSPUtil.getParameter(request, prefix	+ "qa_elapsed_hh", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srWrkStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_wrk_sts_cd", length));
			String[] inputElapsedDd = (JSPUtil.getParameter(request, prefix	+ "input_elapsed_dd", length));
			String[] totalActualSs = (JSPUtil.getParameter(request, prefix	+ "total_actual_ss", length));
			String[] totalIdleDd = (JSPUtil.getParameter(request, prefix	+ "total_idle_dd", length));
			String[] srAmdTpCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_tp_cd", length));
			String[] inputElapsedHh = (JSPUtil.getParameter(request, prefix	+ "input_elapsed_hh", length));
			String[] srTrans = (JSPUtil.getParameter(request, prefix	+ "sr_trans", length));
			String[] originalIdleSs = (JSPUtil.getParameter(request, prefix	+ "original_idle_ss", length));
			String[] originalIdleDd = (JSPUtil.getParameter(request, prefix	+ "original_idle_dd", length));
			String[] blDrftFaxOutFlg = (JSPUtil.getParameter(request, prefix	+ "bl_drft_fax_out_flg", length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no", length));
			String[] rateElapsedSs = (JSPUtil.getParameter(request, prefix	+ "rate_elapsed_ss", length));
			String[] srAmdTd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_td", length));
			String[] amendActualMi = (JSPUtil.getParameter(request, prefix	+ "amend_actual_mi", length));
			String[] rcEnd = (JSPUtil.getParameter(request, prefix	+ "rc_end", length));
			String[] qsStart = (JSPUtil.getParameter(request, prefix	+ "qs_start", length));
			String[] divide = (JSPUtil.getParameter(request, prefix	+ "divide", length));
			String[] originalActualSs = (JSPUtil.getParameter(request, prefix	+ "original_actual_ss", length));
			String[] amendIdleSs = (JSPUtil.getParameter(request, prefix	+ "amend_idle_ss", length));
			String[] originalActualDd = (JSPUtil.getParameter(request, prefix	+ "original_actual_dd", length));
			String[] siElapsedSs = (JSPUtil.getParameter(request, prefix	+ "si_elapsed_ss", length));
			String[] imgPgNo = (JSPUtil.getParameter(request, prefix	+ "img_pg_no", length));
			String[] siElapsedDd = (JSPUtil.getParameter(request, prefix	+ "si_elapsed_dd", length));
			String[] totalTotalMi = (JSPUtil.getParameter(request, prefix	+ "total_total_mi", length));
			String[] siElapsedHh = (JSPUtil.getParameter(request, prefix	+ "si_elapsed_hh", length));
			String[] originalTotalHh = (JSPUtil.getParameter(request, prefix	+ "original_total_hh", length));
			String[] qaElapsedMi = (JSPUtil.getParameter(request, prefix	+ "qa_elapsed_mi", length));
			String[] dpcsOfcCd = (JSPUtil.getParameter(request, prefix	+ "dpcs_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocPerformanceReportInVO();
				if (blAudFlg[i] != null)
					model.setBlAudFlg(blAudFlg[i]);
				if (via[i] != null)
					model.setVia(via[i]);
				if (originalTotalSs[i] != null)
					model.setOriginalTotalSs(originalTotalSs[i]);
				if (totalActualMi[i] != null)
					model.setTotalActualMi(totalActualMi[i]);
				if (blRtFlg[i] != null)
					model.setBlRtFlg(blRtFlg[i]);
				if (siRec[i] != null)
					model.setSiRec(siRec[i]);
				if (originalTotalDd[i] != null)
					model.setOriginalTotalDd(originalTotalDd[i]);
				if (inputElapsedSs[i] != null)
					model.setInputElapsedSs(inputElapsedSs[i]);
				if (amendIdleMi[i] != null)
					model.setAmendIdleMi(amendIdleMi[i]);
				if (totalTotalSs[i] != null)
					model.setTotalTotalSs(totalTotalSs[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgOfcCdD[i] != null)
					model.setBkgOfcCdD(bkgOfcCdD[i]);
				if (srCrntInfoCd[i] != null)
					model.setSrCrntInfoCd(srCrntInfoCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (rgnCdD[i] != null)
					model.setRgnCdD(rgnCdD[i]);
				if (rateElapsedMi[i] != null)
					model.setRateElapsedMi(rateElapsedMi[i]);
				if (icEnd[i] != null)
					model.setIcEnd(icEnd[i]);
				if (totalTotalHh[i] != null)
					model.setTotalTotalHh(totalTotalHh[i]);
				if (totalIdleMi[i] != null)
					model.setTotalIdleMi(totalIdleMi[i]);
				if (originalActualHh[i] != null)
					model.setOriginalActualHh(originalActualHh[i]);
				if (amendIdleHh[i] != null)
					model.setAmendIdleHh(amendIdleHh[i]);
				if (addVal[i] != null)
					model.setAddVal(addVal[i]);
				if (totalTotalDd[i] != null)
					model.setTotalTotalDd(totalTotalDd[i]);
				if (amendTotalSs[i] != null)
					model.setAmendTotalSs(amendTotalSs[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (rsStart[i] != null)
					model.setRsStart(rsStart[i]);
				if (amendTotalMi[i] != null)
					model.setAmendTotalMi(amendTotalMi[i]);
				if (totalActualHh[i] != null)
					model.setTotalActualHh(totalActualHh[i]);
				if (blDocInpFlg[i] != null)
					model.setBlDocInpFlg(blDocInpFlg[i]);
				if (rateElapsedDd[i] != null)
					model.setRateElapsedDd(rateElapsedDd[i]);
				if (hbl[i] != null)
					model.setHbl(hbl[i]);
				if (amendIdleDd[i] != null)
					model.setAmendIdleDd(amendIdleDd[i]);
				if (totalActualDd[i] != null)
					model.setTotalActualDd(totalActualDd[i]);
				if (rateElapsedHh[i] != null)
					model.setRateElapsedHh(rateElapsedHh[i]);
				if (siElapsedMi[i] != null)
					model.setSiElapsedMi(siElapsedMi[i]);
				if (amendActualDd[i] != null)
					model.setAmendActualDd(amendActualDd[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (amendActualSs[i] != null)
					model.setAmendActualSs(amendActualSs[i]);
				if (originalIdleMi[i] != null)
					model.setOriginalIdleMi(originalIdleMi[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (qcEnd[i] != null)
					model.setQcEnd(qcEnd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (amendActualHh[i] != null)
					model.setAmendActualHh(amendActualHh[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (rgnCdCd[i] != null)
					model.setRgnCdCd(rgnCdCd[i]);
				if (inputElapsedMi[i] != null)
					model.setInputElapsedMi(inputElapsedMi[i]);
				if (cm[i] != null)
					model.setCm(cm[i]);
				if (qaElapsedSs[i] != null)
					model.setQaElapsedSs(qaElapsedSs[i]);
				if (originalActualMi[i] != null)
					model.setOriginalActualMi(originalActualMi[i]);
				if (rgn[i] != null)
					model.setRgn(rgn[i]);
				if (totalIdleHh[i] != null)
					model.setTotalIdleHh(totalIdleHh[i]);
				if (srCrntStsCd[i] != null)
					model.setSrCrntStsCd(srCrntStsCd[i]);
				if (pndFlg[i] != null)
					model.setPndFlg(pndFlg[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (totalIdleSs[i] != null)
					model.setTotalIdleSs(totalIdleSs[i]);
				if (isStart[i] != null)
					model.setIsStart(isStart[i]);
				if (originalIdleHh[i] != null)
					model.setOriginalIdleHh(originalIdleHh[i]);
				if (amd[i] != null)
					model.setAmd(amd[i]);
				if (originalTotalMi[i] != null)
					model.setOriginalTotalMi(originalTotalMi[i]);
				if (qaElapsedDd[i] != null)
					model.setQaElapsedDd(qaElapsedDd[i]);
				if (amendTotalHh[i] != null)
					model.setAmendTotalHh(amendTotalHh[i]);
				if (amendTotalDd[i] != null)
					model.setAmendTotalDd(amendTotalDd[i]);
				if (srKndCd[i] != null)
					model.setSrKndCd(srKndCd[i]);
				if (qaElapsedHh[i] != null)
					model.setQaElapsedHh(qaElapsedHh[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srWrkStsCd[i] != null)
					model.setSrWrkStsCd(srWrkStsCd[i]);
				if (inputElapsedDd[i] != null)
					model.setInputElapsedDd(inputElapsedDd[i]);
				if (totalActualSs[i] != null)
					model.setTotalActualSs(totalActualSs[i]);
				if (totalIdleDd[i] != null)
					model.setTotalIdleDd(totalIdleDd[i]);
				if (srAmdTpCd[i] != null)
					model.setSrAmdTpCd(srAmdTpCd[i]);
				if (inputElapsedHh[i] != null)
					model.setInputElapsedHh(inputElapsedHh[i]);
				if (srTrans[i] != null)
					model.setSrTrans(srTrans[i]);
				if (originalIdleSs[i] != null)
					model.setOriginalIdleSs(originalIdleSs[i]);
				if (originalIdleDd[i] != null)
					model.setOriginalIdleDd(originalIdleDd[i]);
				if (blDrftFaxOutFlg[i] != null)
					model.setBlDrftFaxOutFlg(blDrftFaxOutFlg[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				if (rateElapsedSs[i] != null)
					model.setRateElapsedSs(rateElapsedSs[i]);
				if (srAmdTd[i] != null)
					model.setSrAmdTd(srAmdTd[i]);
				if (amendActualMi[i] != null)
					model.setAmendActualMi(amendActualMi[i]);
				if (rcEnd[i] != null)
					model.setRcEnd(rcEnd[i]);
				if (qsStart[i] != null)
					model.setQsStart(qsStart[i]);
				if (divide[i] != null)
					model.setDivide(divide[i]);
				if (originalActualSs[i] != null)
					model.setOriginalActualSs(originalActualSs[i]);
				if (amendIdleSs[i] != null)
					model.setAmendIdleSs(amendIdleSs[i]);
				if (originalActualDd[i] != null)
					model.setOriginalActualDd(originalActualDd[i]);
				if (siElapsedSs[i] != null)
					model.setSiElapsedSs(siElapsedSs[i]);
				if (imgPgNo[i] != null)
					model.setImgPgNo(imgPgNo[i]);
				if (siElapsedDd[i] != null)
					model.setSiElapsedDd(siElapsedDd[i]);
				if (totalTotalMi[i] != null)
					model.setTotalTotalMi(totalTotalMi[i]);
				if (siElapsedHh[i] != null)
					model.setSiElapsedHh(siElapsedHh[i]);
				if (originalTotalHh[i] != null)
					model.setOriginalTotalHh(originalTotalHh[i]);
				if (qaElapsedMi[i] != null)
					model.setQaElapsedMi(qaElapsedMi[i]);
				if (dpcsOfcCd[i] != null)
					model.setDpcsOfcCd(dpcsOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocPerformanceReportInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocPerformanceReportInVO[]
	 */
	public DocPerformanceReportInVO[] getDocPerformanceReportInVOs(){
		DocPerformanceReportInVO[] vos = (DocPerformanceReportInVO[])models.toArray(new DocPerformanceReportInVO[models.size()]);
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
		this.blAudFlg = this.blAudFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.via = this.via .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originalTotalSs = this.originalTotalSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalActualMi = this.totalActualMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRtFlg = this.blRtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siRec = this.siRec .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originalTotalDd = this.originalTotalDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputElapsedSs = this.inputElapsedSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendIdleMi = this.amendIdleMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalTotalSs = this.totalTotalSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCdD = this.bkgOfcCdD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srCrntInfoCd = this.srCrntInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnCdD = this.rgnCdD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateElapsedMi = this.rateElapsedMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.icEnd = this.icEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalTotalHh = this.totalTotalHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalIdleMi = this.totalIdleMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originalActualHh = this.originalActualHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendIdleHh = this.amendIdleHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addVal = this.addVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalTotalDd = this.totalTotalDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendTotalSs = this.amendTotalSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsStart = this.rsStart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendTotalMi = this.amendTotalMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalActualHh = this.totalActualHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDocInpFlg = this.blDocInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateElapsedDd = this.rateElapsedDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hbl = this.hbl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendIdleDd = this.amendIdleDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalActualDd = this.totalActualDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateElapsedHh = this.rateElapsedHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siElapsedMi = this.siElapsedMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendActualDd = this.amendActualDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendActualSs = this.amendActualSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originalIdleMi = this.originalIdleMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qcEnd = this.qcEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendActualHh = this.amendActualHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnCdCd = this.rgnCdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputElapsedMi = this.inputElapsedMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm = this.cm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qaElapsedSs = this.qaElapsedSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originalActualMi = this.originalActualMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgn = this.rgn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalIdleHh = this.totalIdleHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srCrntStsCd = this.srCrntStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pndFlg = this.pndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalIdleSs = this.totalIdleSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isStart = this.isStart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originalIdleHh = this.originalIdleHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amd = this.amd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originalTotalMi = this.originalTotalMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qaElapsedDd = this.qaElapsedDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendTotalHh = this.amendTotalHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendTotalDd = this.amendTotalDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd = this.srKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qaElapsedHh = this.qaElapsedHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srWrkStsCd = this.srWrkStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputElapsedDd = this.inputElapsedDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalActualSs = this.totalActualSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalIdleDd = this.totalIdleDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdTpCd = this.srAmdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputElapsedHh = this.inputElapsedHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srTrans = this.srTrans .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originalIdleSs = this.originalIdleSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originalIdleDd = this.originalIdleDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDrftFaxOutFlg = this.blDrftFaxOutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateElapsedSs = this.rateElapsedSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdTd = this.srAmdTd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendActualMi = this.amendActualMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcEnd = this.rcEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qsStart = this.qsStart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divide = this.divide .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originalActualSs = this.originalActualSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendIdleSs = this.amendIdleSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originalActualDd = this.originalActualDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siElapsedSs = this.siElapsedSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgPgNo = this.imgPgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siElapsedDd = this.siElapsedDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalTotalMi = this.totalTotalMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siElapsedHh = this.siElapsedHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originalTotalHh = this.originalTotalHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qaElapsedMi = this.qaElapsedMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsOfcCd = this.dpcsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
