/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TesAuditConditionVO.java
*@FileTitle : TesAuditConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.12  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo;

import java.lang.reflect.Field;
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

public class TesAuditConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesAuditConditionVO> models = new ArrayList<TesAuditConditionVO>();
	
	/* Column Info */
	private String sLgsCostSubjCd = null;
	/* Column Info */
	private String sToDt = null;
	/* Column Info */
	private String sEacFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sVvd = null;
	/* Column Info */
	private String sRhqOfcCd = null;
	/* Column Info */
	private String sInvOfcCd = null;
	/* Column Info */
	private String sAutoExpnAudStsCd = null;
	/* Column Info */
	private String sCalcTpCd = null;
	/* Column Info */
	private String sExpnAudStsCd = null;
	/* Column Info */
	private String sCsrStsCd = null;
	/* Column Info */
	private String sLgsCostDtlCd = null;
	/* Column Info */
	private String sCsrNo = null;
	/* Column Info */
	private String sToPrdDt = null;
	/* Column Info */
	private String sToday = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sFmPrdDt = null;
	/* Column Info */
	private String sAudOfcCd = null;
	/* Column Info */
	private String sYdCd = null;
	/* Column Info */
	private String sInvCfmDt = null;
	/* Column Info */
	private String toDatetime = null;
	/* Column Info */
	private String sCntrTpszCd = null;
	/* Column Info */
	private String sSkdVoyNo = null;
	/* Column Info */
	private String sLaneCd = null;
	/* Column Info */
	private String sFromInvCfmDt = null;
	/* Column Info */
	private String sCntrVslClssCapa = null;
	/* Column Info */
	private String sExpnAudTgtFlg = null;
	/* Column Info */
	private String sDiffSgn = null;
	/* Column Info */
	private String sInvNo = null;
	/* Column Info */
	private String sVndrSeq = null;
	/* Column Info */
	private String sNodCd = null;
	/* Column Info */
	private String sIoBndCd = null;
	/* Column Info */
	private String sLocCd = null;
	/* Column Info */
	private String sBatRsltCd = null;
	/* Column Info */
	private String sVslCd = null;
	/* Column Info */
	private String sTmlInvTpCd = null;
	/* Column Info */
	private String sToInvCfmDt = null;
	/* Column Info */
	private String sCalcCostGrpCd = null;
	/* Column Info */
	private String sPrdYm = null;
	/* Column Info */
	private String sCostCalcMzdCd = null;
	/* Column Info */
	private String sSkdDirCd = null;
	/* Column Info */
	private String sFmDt = null;
	/* Column Info */
	private String sDiffRto = null;
	/* Column Info */
	private String batchTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TesAuditConditionVO() {}

	public TesAuditConditionVO(String ibflag, String pagerows, String sLaneCd, String sSkdVoyNo, String sRhqOfcCd, String sVslCd, String sAudOfcCd, String sLgsCostSubjCd, String sDiffSgn, String sExpnAudTgtFlg, String sFmPrdDt, String sToInvCfmDt, String sInvOfcCd, String sPrdYm, String sToDt, String sCostCalcMzdCd, String sCntrTpszCd, String sFmDt, String sYdCd, String sCalcCostGrpCd, String sCsrStsCd, String sEacFlg, String sExpnAudStsCd, String sInvCfmDt, String sTmlInvTpCd, String sNodCd, String sLocCd, String sAutoExpnAudStsCd, String toDatetime, String sVndrSeq, String sIoBndCd, String sFromInvCfmDt, String sVvd, String sCalcTpCd, String sSkdDirCd, String batchTpCd, String sToPrdDt, String sInvNo, String sBatRsltCd, String sLgsCostDtlCd, String sCntrVslClssCapa, String sCsrNo, String sDiffRto, String sToday) {
		this.sLgsCostSubjCd = sLgsCostSubjCd;
		this.sToDt = sToDt;
		this.sEacFlg = sEacFlg;
		this.ibflag = ibflag;
		this.sVvd = sVvd;
		this.sRhqOfcCd = sRhqOfcCd;
		this.sInvOfcCd = sInvOfcCd;
		this.sAutoExpnAudStsCd = sAutoExpnAudStsCd;
		this.sCalcTpCd = sCalcTpCd;
		this.sExpnAudStsCd = sExpnAudStsCd;
		this.sCsrStsCd = sCsrStsCd;
		this.sLgsCostDtlCd = sLgsCostDtlCd;
		this.sCsrNo = sCsrNo;
		this.sToPrdDt = sToPrdDt;
		this.sToday = sToday;
		this.pagerows = pagerows;
		this.sFmPrdDt = sFmPrdDt;
		this.sAudOfcCd = sAudOfcCd;
		this.sYdCd = sYdCd;
		this.sInvCfmDt = sInvCfmDt;
		this.toDatetime = toDatetime;
		this.sCntrTpszCd = sCntrTpszCd;
		this.sSkdVoyNo = sSkdVoyNo;
		this.sLaneCd = sLaneCd;
		this.sFromInvCfmDt = sFromInvCfmDt;
		this.sCntrVslClssCapa = sCntrVslClssCapa;
		this.sExpnAudTgtFlg = sExpnAudTgtFlg;
		this.sDiffSgn = sDiffSgn;
		this.sInvNo = sInvNo;
		this.sVndrSeq = sVndrSeq;
		this.sNodCd = sNodCd;
		this.sIoBndCd = sIoBndCd;
		this.sLocCd = sLocCd;
		this.sBatRsltCd = sBatRsltCd;
		this.sVslCd = sVslCd;
		this.sTmlInvTpCd = sTmlInvTpCd;
		this.sToInvCfmDt = sToInvCfmDt;
		this.sCalcCostGrpCd = sCalcCostGrpCd;
		this.sPrdYm = sPrdYm;
		this.sCostCalcMzdCd = sCostCalcMzdCd;
		this.sSkdDirCd = sSkdDirCd;
		this.sFmDt = sFmDt;
		this.sDiffRto = sDiffRto;
		this.batchTpCd = batchTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_lgs_cost_subj_cd", getSLgsCostSubjCd());
		this.hashColumns.put("s_to_dt", getSToDt());
		this.hashColumns.put("s_eac_flg", getSEacFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_vvd", getSVvd());
		this.hashColumns.put("s_rhq_ofc_cd", getSRhqOfcCd());
		this.hashColumns.put("s_inv_ofc_cd", getSInvOfcCd());
		this.hashColumns.put("s_auto_expn_aud_sts_cd", getSAutoExpnAudStsCd());
		this.hashColumns.put("s_calc_tp_cd", getSCalcTpCd());
		this.hashColumns.put("s_expn_aud_sts_cd", getSExpnAudStsCd());
		this.hashColumns.put("s_csr_sts_cd", getSCsrStsCd());
		this.hashColumns.put("s_lgs_cost_dtl_cd", getSLgsCostDtlCd());
		this.hashColumns.put("s_csr_no", getSCsrNo());
		this.hashColumns.put("s_to_prd_dt", getSToPrdDt());
		this.hashColumns.put("s_today", getSToday());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s_fm_prd_dt", getSFmPrdDt());
		this.hashColumns.put("s_aud_ofc_cd", getSAudOfcCd());
		this.hashColumns.put("s_yd_cd", getSYdCd());
		this.hashColumns.put("s_inv_cfm_dt", getSInvCfmDt());
		this.hashColumns.put("to_datetime", getToDatetime());
		this.hashColumns.put("s_cntr_tpsz_cd", getSCntrTpszCd());
		this.hashColumns.put("s_skd_voy_no", getSSkdVoyNo());
		this.hashColumns.put("s_lane_cd", getSLaneCd());
		this.hashColumns.put("s_from_inv_cfm_dt", getSFromInvCfmDt());
		this.hashColumns.put("s_cntr_vsl_clss_capa", getSCntrVslClssCapa());
		this.hashColumns.put("s_expn_aud_tgt_flg", getSExpnAudTgtFlg());
		this.hashColumns.put("s_diff_sgn", getSDiffSgn());
		this.hashColumns.put("s_inv_no", getSInvNo());
		this.hashColumns.put("s_vndr_seq", getSVndrSeq());
		this.hashColumns.put("s_nod_cd", getSNodCd());
		this.hashColumns.put("s_io_bnd_cd", getSIoBndCd());
		this.hashColumns.put("s_loc_cd", getSLocCd());
		this.hashColumns.put("s_bat_rslt_cd", getSBatRsltCd());
		this.hashColumns.put("s_vsl_cd", getSVslCd());
		this.hashColumns.put("s_tml_inv_tp_cd", getSTmlInvTpCd());
		this.hashColumns.put("s_to_inv_cfm_dt", getSToInvCfmDt());
		this.hashColumns.put("s_calc_cost_grp_cd", getSCalcCostGrpCd());
		this.hashColumns.put("s_prd_ym", getSPrdYm());
		this.hashColumns.put("s_cost_calc_mzd_cd", getSCostCalcMzdCd());
		this.hashColumns.put("s_skd_dir_cd", getSSkdDirCd());
		this.hashColumns.put("s_fm_dt", getSFmDt());
		this.hashColumns.put("s_diff_rto", getSDiffRto());
		this.hashColumns.put("batch_tp_cd", getBatchTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_lgs_cost_subj_cd", "sLgsCostSubjCd");
		this.hashFields.put("s_to_dt", "sToDt");
		this.hashFields.put("s_eac_flg", "sEacFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_vvd", "sVvd");
		this.hashFields.put("s_rhq_ofc_cd", "sRhqOfcCd");
		this.hashFields.put("s_inv_ofc_cd", "sInvOfcCd");
		this.hashFields.put("s_auto_expn_aud_sts_cd", "sAutoExpnAudStsCd");
		this.hashFields.put("s_calc_tp_cd", "sCalcTpCd");
		this.hashFields.put("s_expn_aud_sts_cd", "sExpnAudStsCd");
		this.hashFields.put("s_csr_sts_cd", "sCsrStsCd");
		this.hashFields.put("s_lgs_cost_dtl_cd", "sLgsCostDtlCd");
		this.hashFields.put("s_csr_no", "sCsrNo");
		this.hashFields.put("s_to_prd_dt", "sToPrdDt");
		this.hashFields.put("s_today", "sToday");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_fm_prd_dt", "sFmPrdDt");
		this.hashFields.put("s_aud_ofc_cd", "sAudOfcCd");
		this.hashFields.put("s_yd_cd", "sYdCd");
		this.hashFields.put("s_inv_cfm_dt", "sInvCfmDt");
		this.hashFields.put("to_datetime", "toDatetime");
		this.hashFields.put("s_cntr_tpsz_cd", "sCntrTpszCd");
		this.hashFields.put("s_skd_voy_no", "sSkdVoyNo");
		this.hashFields.put("s_lane_cd", "sLaneCd");
		this.hashFields.put("s_from_inv_cfm_dt", "sFromInvCfmDt");
		this.hashFields.put("s_cntr_vsl_clss_capa", "sCntrVslClssCapa");
		this.hashFields.put("s_expn_aud_tgt_flg", "sExpnAudTgtFlg");
		this.hashFields.put("s_diff_sgn", "sDiffSgn");
		this.hashFields.put("s_inv_no", "sInvNo");
		this.hashFields.put("s_vndr_seq", "sVndrSeq");
		this.hashFields.put("s_nod_cd", "sNodCd");
		this.hashFields.put("s_io_bnd_cd", "sIoBndCd");
		this.hashFields.put("s_loc_cd", "sLocCd");
		this.hashFields.put("s_bat_rslt_cd", "sBatRsltCd");
		this.hashFields.put("s_vsl_cd", "sVslCd");
		this.hashFields.put("s_tml_inv_tp_cd", "sTmlInvTpCd");
		this.hashFields.put("s_to_inv_cfm_dt", "sToInvCfmDt");
		this.hashFields.put("s_calc_cost_grp_cd", "sCalcCostGrpCd");
		this.hashFields.put("s_prd_ym", "sPrdYm");
		this.hashFields.put("s_cost_calc_mzd_cd", "sCostCalcMzdCd");
		this.hashFields.put("s_skd_dir_cd", "sSkdDirCd");
		this.hashFields.put("s_fm_dt", "sFmDt");
		this.hashFields.put("s_diff_rto", "sDiffRto");
		this.hashFields.put("batch_tp_cd", "batchTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sLgsCostSubjCd
	 */
	public String getSLgsCostSubjCd() {
		return this.sLgsCostSubjCd;
	}
	
	/**
	 * Column Info
	 * @return sToDt
	 */
	public String getSToDt() {
		return this.sToDt;
	}
	
	/**
	 * Column Info
	 * @return sEacFlg
	 */
	public String getSEacFlg() {
		return this.sEacFlg;
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
	 * @return sVvd
	 */
	public String getSVvd() {
		return this.sVvd;
	}
	
	/**
	 * Column Info
	 * @return sRhqOfcCd
	 */
	public String getSRhqOfcCd() {
		return this.sRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sInvOfcCd
	 */
	public String getSInvOfcCd() {
		return this.sInvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sAutoExpnAudStsCd
	 */
	public String getSAutoExpnAudStsCd() {
		return this.sAutoExpnAudStsCd;
	}
	
	/**
	 * Column Info
	 * @return sCalcTpCd
	 */
	public String getSCalcTpCd() {
		return this.sCalcTpCd;
	}
	
	/**
	 * Column Info
	 * @return sExpnAudStsCd
	 */
	public String getSExpnAudStsCd() {
		return this.sExpnAudStsCd;
	}
	
	/**
	 * Column Info
	 * @return sCsrStsCd
	 */
	public String getSCsrStsCd() {
		return this.sCsrStsCd;
	}
	
	/**
	 * Column Info
	 * @return sLgsCostDtlCd
	 */
	public String getSLgsCostDtlCd() {
		return this.sLgsCostDtlCd;
	}
	
	/**
	 * Column Info
	 * @return sCsrNo
	 */
	public String getSCsrNo() {
		return this.sCsrNo;
	}
	
	/**
	 * Column Info
	 * @return sToPrdDt
	 */
	public String getSToPrdDt() {
		return this.sToPrdDt;
	}
	
	/**
	 * Column Info
	 * @return sToday
	 */
	public String getSToday() {
		return this.sToday;
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
	 * @return sFmPrdDt
	 */
	public String getSFmPrdDt() {
		return this.sFmPrdDt;
	}
	
	/**
	 * Column Info
	 * @return sAudOfcCd
	 */
	public String getSAudOfcCd() {
		return this.sAudOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sYdCd
	 */
	public String getSYdCd() {
		return this.sYdCd;
	}
	
	/**
	 * Column Info
	 * @return sInvCfmDt
	 */
	public String getSInvCfmDt() {
		return this.sInvCfmDt;
	}
	
	/**
	 * Column Info
	 * @return toDatetime
	 */
	public String getToDatetime() {
		return this.toDatetime;
	}
	
	/**
	 * Column Info
	 * @return sCntrTpszCd
	 */
	public String getSCntrTpszCd() {
		return this.sCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return sSkdVoyNo
	 */
	public String getSSkdVoyNo() {
		return this.sSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return sLaneCd
	 */
	public String getSLaneCd() {
		return this.sLaneCd;
	}
	
	/**
	 * Column Info
	 * @return sFromInvCfmDt
	 */
	public String getSFromInvCfmDt() {
		return this.sFromInvCfmDt;
	}
	
	/**
	 * Column Info
	 * @return sCntrVslClssCapa
	 */
	public String getSCntrVslClssCapa() {
		return this.sCntrVslClssCapa;
	}
	
	/**
	 * Column Info
	 * @return sExpnAudTgtFlg
	 */
	public String getSExpnAudTgtFlg() {
		return this.sExpnAudTgtFlg;
	}
	
	/**
	 * Column Info
	 * @return sDiffSgn
	 */
	public String getSDiffSgn() {
		return this.sDiffSgn;
	}
	
	/**
	 * Column Info
	 * @return sInvNo
	 */
	public String getSInvNo() {
		return this.sInvNo;
	}
	
	/**
	 * Column Info
	 * @return sVndrSeq
	 */
	public String getSVndrSeq() {
		return this.sVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return sNodCd
	 */
	public String getSNodCd() {
		return this.sNodCd;
	}
	
	/**
	 * Column Info
	 * @return sIoBndCd
	 */
	public String getSIoBndCd() {
		return this.sIoBndCd;
	}
	
	/**
	 * Column Info
	 * @return sLocCd
	 */
	public String getSLocCd() {
		return this.sLocCd;
	}
	
	/**
	 * Column Info
	 * @return sBatRsltCd
	 */
	public String getSBatRsltCd() {
		return this.sBatRsltCd;
	}
	
	/**
	 * Column Info
	 * @return sVslCd
	 */
	public String getSVslCd() {
		return this.sVslCd;
	}
	
	/**
	 * Column Info
	 * @return sTmlInvTpCd
	 */
	public String getSTmlInvTpCd() {
		return this.sTmlInvTpCd;
	}
	
	/**
	 * Column Info
	 * @return sToInvCfmDt
	 */
	public String getSToInvCfmDt() {
		return this.sToInvCfmDt;
	}
	
	/**
	 * Column Info
	 * @return sCalcCostGrpCd
	 */
	public String getSCalcCostGrpCd() {
		return this.sCalcCostGrpCd;
	}
	
	/**
	 * Column Info
	 * @return sPrdYm
	 */
	public String getSPrdYm() {
		return this.sPrdYm;
	}
	
	/**
	 * Column Info
	 * @return sCostCalcMzdCd
	 */
	public String getSCostCalcMzdCd() {
		return this.sCostCalcMzdCd;
	}
	
	/**
	 * Column Info
	 * @return sSkdDirCd
	 */
	public String getSSkdDirCd() {
		return this.sSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return sFmDt
	 */
	public String getSFmDt() {
		return this.sFmDt;
	}
	
	/**
	 * Column Info
	 * @return sDiffRto
	 */
	public String getSDiffRto() {
		return this.sDiffRto;
	}
	
	/**
	 * Column Info
	 * @return batchTpCd
	 */
	public String getBatchTpCd() {
		return this.batchTpCd;
	}
	

	/**
	 * Column Info
	 * @param sLgsCostSubjCd
	 */
	public void setSLgsCostSubjCd(String sLgsCostSubjCd) {
		this.sLgsCostSubjCd = sLgsCostSubjCd;
	}
	
	/**
	 * Column Info
	 * @param sToDt
	 */
	public void setSToDt(String sToDt) {
		this.sToDt = sToDt;
	}
	
	/**
	 * Column Info
	 * @param sEacFlg
	 */
	public void setSEacFlg(String sEacFlg) {
		this.sEacFlg = sEacFlg;
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
	 * @param sVvd
	 */
	public void setSVvd(String sVvd) {
		this.sVvd = sVvd;
	}
	
	/**
	 * Column Info
	 * @param sRhqOfcCd
	 */
	public void setSRhqOfcCd(String sRhqOfcCd) {
		this.sRhqOfcCd = sRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sInvOfcCd
	 */
	public void setSInvOfcCd(String sInvOfcCd) {
		this.sInvOfcCd = sInvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sAutoExpnAudStsCd
	 */
	public void setSAutoExpnAudStsCd(String sAutoExpnAudStsCd) {
		this.sAutoExpnAudStsCd = sAutoExpnAudStsCd;
	}
	
	/**
	 * Column Info
	 * @param sCalcTpCd
	 */
	public void setSCalcTpCd(String sCalcTpCd) {
		this.sCalcTpCd = sCalcTpCd;
	}
	
	/**
	 * Column Info
	 * @param sExpnAudStsCd
	 */
	public void setSExpnAudStsCd(String sExpnAudStsCd) {
		this.sExpnAudStsCd = sExpnAudStsCd;
	}
	
	/**
	 * Column Info
	 * @param sCsrStsCd
	 */
	public void setSCsrStsCd(String sCsrStsCd) {
		this.sCsrStsCd = sCsrStsCd;
	}
	
	/**
	 * Column Info
	 * @param sLgsCostDtlCd
	 */
	public void setSLgsCostDtlCd(String sLgsCostDtlCd) {
		this.sLgsCostDtlCd = sLgsCostDtlCd;
	}
	
	/**
	 * Column Info
	 * @param sCsrNo
	 */
	public void setSCsrNo(String sCsrNo) {
		this.sCsrNo = sCsrNo;
	}
	
	/**
	 * Column Info
	 * @param sToPrdDt
	 */
	public void setSToPrdDt(String sToPrdDt) {
		this.sToPrdDt = sToPrdDt;
	}
	
	/**
	 * Column Info
	 * @param sToday
	 */
	public void setSToday(String sToday) {
		this.sToday = sToday;
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
	 * @param sFmPrdDt
	 */
	public void setSFmPrdDt(String sFmPrdDt) {
		this.sFmPrdDt = sFmPrdDt;
	}
	
	/**
	 * Column Info
	 * @param sAudOfcCd
	 */
	public void setSAudOfcCd(String sAudOfcCd) {
		this.sAudOfcCd = sAudOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sYdCd
	 */
	public void setSYdCd(String sYdCd) {
		this.sYdCd = sYdCd;
	}
	
	/**
	 * Column Info
	 * @param sInvCfmDt
	 */
	public void setSInvCfmDt(String sInvCfmDt) {
		this.sInvCfmDt = sInvCfmDt;
	}
	
	/**
	 * Column Info
	 * @param toDatetime
	 */
	public void setToDatetime(String toDatetime) {
		this.toDatetime = toDatetime;
	}
	
	/**
	 * Column Info
	 * @param sCntrTpszCd
	 */
	public void setSCntrTpszCd(String sCntrTpszCd) {
		this.sCntrTpszCd = sCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param sSkdVoyNo
	 */
	public void setSSkdVoyNo(String sSkdVoyNo) {
		this.sSkdVoyNo = sSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param sLaneCd
	 */
	public void setSLaneCd(String sLaneCd) {
		this.sLaneCd = sLaneCd;
	}
	
	/**
	 * Column Info
	 * @param sFromInvCfmDt
	 */
	public void setSFromInvCfmDt(String sFromInvCfmDt) {
		this.sFromInvCfmDt = sFromInvCfmDt;
	}
	
	/**
	 * Column Info
	 * @param sCntrVslClssCapa
	 */
	public void setSCntrVslClssCapa(String sCntrVslClssCapa) {
		this.sCntrVslClssCapa = sCntrVslClssCapa;
	}
	
	/**
	 * Column Info
	 * @param sExpnAudTgtFlg
	 */
	public void setSExpnAudTgtFlg(String sExpnAudTgtFlg) {
		this.sExpnAudTgtFlg = sExpnAudTgtFlg;
	}
	
	/**
	 * Column Info
	 * @param sDiffSgn
	 */
	public void setSDiffSgn(String sDiffSgn) {
		this.sDiffSgn = sDiffSgn;
	}
	
	/**
	 * Column Info
	 * @param sInvNo
	 */
	public void setSInvNo(String sInvNo) {
		this.sInvNo = sInvNo;
	}
	
	/**
	 * Column Info
	 * @param sVndrSeq
	 */
	public void setSVndrSeq(String sVndrSeq) {
		this.sVndrSeq = sVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param sNodCd
	 */
	public void setSNodCd(String sNodCd) {
		this.sNodCd = sNodCd;
	}
	
	/**
	 * Column Info
	 * @param sIoBndCd
	 */
	public void setSIoBndCd(String sIoBndCd) {
		this.sIoBndCd = sIoBndCd;
	}
	
	/**
	 * Column Info
	 * @param sLocCd
	 */
	public void setSLocCd(String sLocCd) {
		this.sLocCd = sLocCd;
	}
	
	/**
	 * Column Info
	 * @param sBatRsltCd
	 */
	public void setSBatRsltCd(String sBatRsltCd) {
		this.sBatRsltCd = sBatRsltCd;
	}
	
	/**
	 * Column Info
	 * @param sVslCd
	 */
	public void setSVslCd(String sVslCd) {
		this.sVslCd = sVslCd;
	}
	
	/**
	 * Column Info
	 * @param sTmlInvTpCd
	 */
	public void setSTmlInvTpCd(String sTmlInvTpCd) {
		this.sTmlInvTpCd = sTmlInvTpCd;
	}
	
	/**
	 * Column Info
	 * @param sToInvCfmDt
	 */
	public void setSToInvCfmDt(String sToInvCfmDt) {
		this.sToInvCfmDt = sToInvCfmDt;
	}
	
	/**
	 * Column Info
	 * @param sCalcCostGrpCd
	 */
	public void setSCalcCostGrpCd(String sCalcCostGrpCd) {
		this.sCalcCostGrpCd = sCalcCostGrpCd;
	}
	
	/**
	 * Column Info
	 * @param sPrdYm
	 */
	public void setSPrdYm(String sPrdYm) {
		this.sPrdYm = sPrdYm;
	}
	
	/**
	 * Column Info
	 * @param sCostCalcMzdCd
	 */
	public void setSCostCalcMzdCd(String sCostCalcMzdCd) {
		this.sCostCalcMzdCd = sCostCalcMzdCd;
	}
	
	/**
	 * Column Info
	 * @param sSkdDirCd
	 */
	public void setSSkdDirCd(String sSkdDirCd) {
		this.sSkdDirCd = sSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param sFmDt
	 */
	public void setSFmDt(String sFmDt) {
		this.sFmDt = sFmDt;
	}
	
	/**
	 * Column Info
	 * @param sDiffRto
	 */
	public void setSDiffRto(String sDiffRto) {
		this.sDiffRto = sDiffRto;
	}
	
	/**
	 * Column Info
	 * @param batchTpCd
	 */
	public void setBatchTpCd(String batchTpCd) {
		this.batchTpCd = batchTpCd;
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
		setSLgsCostSubjCd(JSPUtil.getParameter(request, prefix + "s_lgs_cost_subj_cd", ""));
		setSToDt(JSPUtil.getParameter(request, prefix + "s_to_dt", ""));
		setSEacFlg(JSPUtil.getParameter(request, prefix + "s_eac_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSVvd(JSPUtil.getParameter(request, prefix + "s_vvd", ""));
		setSRhqOfcCd(JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", ""));
		setSInvOfcCd(JSPUtil.getParameter(request, prefix + "s_inv_ofc_cd", ""));
		setSAutoExpnAudStsCd(JSPUtil.getParameter(request, prefix + "s_auto_expn_aud_sts_cd", ""));
		setSCalcTpCd(JSPUtil.getParameter(request, prefix + "s_calc_tp_cd", ""));
		setSExpnAudStsCd(JSPUtil.getParameter(request, prefix + "s_expn_aud_sts_cd", ""));
		setSCsrStsCd(JSPUtil.getParameter(request, prefix + "s_csr_sts_cd", ""));
		setSLgsCostDtlCd(JSPUtil.getParameter(request, prefix + "s_lgs_cost_dtl_cd", ""));
		setSCsrNo(JSPUtil.getParameter(request, prefix + "s_csr_no", ""));
		setSToPrdDt(JSPUtil.getParameter(request, prefix + "s_to_prd_dt", ""));
		setSToday(JSPUtil.getParameter(request, prefix + "s_today", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSFmPrdDt(JSPUtil.getParameter(request, prefix + "s_fm_prd_dt", ""));
		setSAudOfcCd(JSPUtil.getParameter(request, prefix + "s_aud_ofc_cd", ""));
		setSYdCd(JSPUtil.getParameter(request, prefix + "s_yd_cd", ""));
		setSInvCfmDt(JSPUtil.getParameter(request, prefix + "s_inv_cfm_dt", ""));
		setToDatetime(JSPUtil.getParameter(request, prefix + "to_datetime", ""));
		setSCntrTpszCd(JSPUtil.getParameter(request, prefix + "s_cntr_tpsz_cd", ""));
		setSSkdVoyNo(JSPUtil.getParameter(request, prefix + "s_skd_voy_no", ""));
		setSLaneCd(JSPUtil.getParameter(request, prefix + "s_lane_cd", ""));
		setSFromInvCfmDt(JSPUtil.getParameter(request, prefix + "s_from_inv_cfm_dt", ""));
		setSCntrVslClssCapa(JSPUtil.getParameter(request, prefix + "s_cntr_vsl_clss_capa", ""));
		setSExpnAudTgtFlg(JSPUtil.getParameter(request, prefix + "s_expn_aud_tgt_flg", ""));
		setSDiffSgn(JSPUtil.getParameter(request, prefix + "s_diff_sgn", ""));
		setSInvNo(JSPUtil.getParameter(request, prefix + "s_inv_no", ""));
		setSVndrSeq(JSPUtil.getParameter(request, prefix + "s_vndr_seq", ""));
		setSNodCd(JSPUtil.getParameter(request, prefix + "s_nod_cd", ""));
		setSIoBndCd(JSPUtil.getParameter(request, prefix + "s_io_bnd_cd", ""));
		setSLocCd(JSPUtil.getParameter(request, prefix + "s_loc_cd", ""));
		setSBatRsltCd(JSPUtil.getParameter(request, prefix + "s_bat_rslt_cd", ""));
		setSVslCd(JSPUtil.getParameter(request, prefix + "s_vsl_cd", ""));
		setSTmlInvTpCd(JSPUtil.getParameter(request, prefix + "s_tml_inv_tp_cd", ""));
		setSToInvCfmDt(JSPUtil.getParameter(request, prefix + "s_to_inv_cfm_dt", ""));
		setSCalcCostGrpCd(JSPUtil.getParameter(request, prefix + "s_calc_cost_grp_cd", ""));
		setSPrdYm(JSPUtil.getParameter(request, prefix + "s_prd_ym", ""));
		setSCostCalcMzdCd(JSPUtil.getParameter(request, prefix + "s_cost_calc_mzd_cd", ""));
		setSSkdDirCd(JSPUtil.getParameter(request, prefix + "s_skd_dir_cd", ""));
		setSFmDt(JSPUtil.getParameter(request, prefix + "s_fm_dt", ""));
		setSDiffRto(JSPUtil.getParameter(request, prefix + "s_diff_rto", ""));
		setBatchTpCd(JSPUtil.getParameter(request, prefix + "batch_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesAuditConditionVO[]
	 */
	public TesAuditConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesAuditConditionVO[]
	 */
	public TesAuditConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesAuditConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sLgsCostSubjCd = (JSPUtil.getParameter(request, prefix	+ "s_lgs_cost_subj_cd", length));
			String[] sToDt = (JSPUtil.getParameter(request, prefix	+ "s_to_dt", length));
			String[] sEacFlg = (JSPUtil.getParameter(request, prefix	+ "s_eac_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sVvd = (JSPUtil.getParameter(request, prefix	+ "s_vvd", length));
			String[] sRhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_rhq_ofc_cd", length));
			String[] sInvOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_inv_ofc_cd", length));
			String[] sAutoExpnAudStsCd = (JSPUtil.getParameter(request, prefix	+ "s_auto_expn_aud_sts_cd", length));
			String[] sCalcTpCd = (JSPUtil.getParameter(request, prefix	+ "s_calc_tp_cd", length));
			String[] sExpnAudStsCd = (JSPUtil.getParameter(request, prefix	+ "s_expn_aud_sts_cd", length));
			String[] sCsrStsCd = (JSPUtil.getParameter(request, prefix	+ "s_csr_sts_cd", length));
			String[] sLgsCostDtlCd = (JSPUtil.getParameter(request, prefix	+ "s_lgs_cost_dtl_cd", length));
			String[] sCsrNo = (JSPUtil.getParameter(request, prefix	+ "s_csr_no", length));
			String[] sToPrdDt = (JSPUtil.getParameter(request, prefix	+ "s_to_prd_dt", length));
			String[] sToday = (JSPUtil.getParameter(request, prefix	+ "s_today", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sFmPrdDt = (JSPUtil.getParameter(request, prefix	+ "s_fm_prd_dt", length));
			String[] sAudOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_aud_ofc_cd", length));
			String[] sYdCd = (JSPUtil.getParameter(request, prefix	+ "s_yd_cd", length));
			String[] sInvCfmDt = (JSPUtil.getParameter(request, prefix	+ "s_inv_cfm_dt", length));
			String[] toDatetime = (JSPUtil.getParameter(request, prefix	+ "to_datetime", length));
			String[] sCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "s_cntr_tpsz_cd", length));
			String[] sSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "s_skd_voy_no", length));
			String[] sLaneCd = (JSPUtil.getParameter(request, prefix	+ "s_lane_cd", length));
			String[] sFromInvCfmDt = (JSPUtil.getParameter(request, prefix	+ "s_from_inv_cfm_dt", length));
			String[] sCntrVslClssCapa = (JSPUtil.getParameter(request, prefix	+ "s_cntr_vsl_clss_capa", length));
			String[] sExpnAudTgtFlg = (JSPUtil.getParameter(request, prefix	+ "s_expn_aud_tgt_flg", length));
			String[] sDiffSgn = (JSPUtil.getParameter(request, prefix	+ "s_diff_sgn", length));
			String[] sInvNo = (JSPUtil.getParameter(request, prefix	+ "s_inv_no", length));
			String[] sVndrSeq = (JSPUtil.getParameter(request, prefix	+ "s_vndr_seq", length));
			String[] sNodCd = (JSPUtil.getParameter(request, prefix	+ "s_nod_cd", length));
			String[] sIoBndCd = (JSPUtil.getParameter(request, prefix	+ "s_io_bnd_cd", length));
			String[] sLocCd = (JSPUtil.getParameter(request, prefix	+ "s_loc_cd", length));
			String[] sBatRsltCd = (JSPUtil.getParameter(request, prefix	+ "s_bat_rslt_cd", length));
			String[] sVslCd = (JSPUtil.getParameter(request, prefix	+ "s_vsl_cd", length));
			String[] sTmlInvTpCd = (JSPUtil.getParameter(request, prefix	+ "s_tml_inv_tp_cd", length));
			String[] sToInvCfmDt = (JSPUtil.getParameter(request, prefix	+ "s_to_inv_cfm_dt", length));
			String[] sCalcCostGrpCd = (JSPUtil.getParameter(request, prefix	+ "s_calc_cost_grp_cd", length));
			String[] sPrdYm = (JSPUtil.getParameter(request, prefix	+ "s_prd_ym", length));
			String[] sCostCalcMzdCd = (JSPUtil.getParameter(request, prefix	+ "s_cost_calc_mzd_cd", length));
			String[] sSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "s_skd_dir_cd", length));
			String[] sFmDt = (JSPUtil.getParameter(request, prefix	+ "s_fm_dt", length));
			String[] sDiffRto = (JSPUtil.getParameter(request, prefix	+ "s_diff_rto", length));
			String[] batchTpCd = (JSPUtil.getParameter(request, prefix	+ "batch_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesAuditConditionVO();
				if (sLgsCostSubjCd[i] != null)
					model.setSLgsCostSubjCd(sLgsCostSubjCd[i]);
				if (sToDt[i] != null)
					model.setSToDt(sToDt[i]);
				if (sEacFlg[i] != null)
					model.setSEacFlg(sEacFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sVvd[i] != null)
					model.setSVvd(sVvd[i]);
				if (sRhqOfcCd[i] != null)
					model.setSRhqOfcCd(sRhqOfcCd[i]);
				if (sInvOfcCd[i] != null)
					model.setSInvOfcCd(sInvOfcCd[i]);
				if (sAutoExpnAudStsCd[i] != null)
					model.setSAutoExpnAudStsCd(sAutoExpnAudStsCd[i]);
				if (sCalcTpCd[i] != null)
					model.setSCalcTpCd(sCalcTpCd[i]);
				if (sExpnAudStsCd[i] != null)
					model.setSExpnAudStsCd(sExpnAudStsCd[i]);
				if (sCsrStsCd[i] != null)
					model.setSCsrStsCd(sCsrStsCd[i]);
				if (sLgsCostDtlCd[i] != null)
					model.setSLgsCostDtlCd(sLgsCostDtlCd[i]);
				if (sCsrNo[i] != null)
					model.setSCsrNo(sCsrNo[i]);
				if (sToPrdDt[i] != null)
					model.setSToPrdDt(sToPrdDt[i]);
				if (sToday[i] != null)
					model.setSToday(sToday[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sFmPrdDt[i] != null)
					model.setSFmPrdDt(sFmPrdDt[i]);
				if (sAudOfcCd[i] != null)
					model.setSAudOfcCd(sAudOfcCd[i]);
				if (sYdCd[i] != null)
					model.setSYdCd(sYdCd[i]);
				if (sInvCfmDt[i] != null)
					model.setSInvCfmDt(sInvCfmDt[i]);
				if (toDatetime[i] != null)
					model.setToDatetime(toDatetime[i]);
				if (sCntrTpszCd[i] != null)
					model.setSCntrTpszCd(sCntrTpszCd[i]);
				if (sSkdVoyNo[i] != null)
					model.setSSkdVoyNo(sSkdVoyNo[i]);
				if (sLaneCd[i] != null)
					model.setSLaneCd(sLaneCd[i]);
				if (sFromInvCfmDt[i] != null)
					model.setSFromInvCfmDt(sFromInvCfmDt[i]);
				if (sCntrVslClssCapa[i] != null)
					model.setSCntrVslClssCapa(sCntrVslClssCapa[i]);
				if (sExpnAudTgtFlg[i] != null)
					model.setSExpnAudTgtFlg(sExpnAudTgtFlg[i]);
				if (sDiffSgn[i] != null)
					model.setSDiffSgn(sDiffSgn[i]);
				if (sInvNo[i] != null)
					model.setSInvNo(sInvNo[i]);
				if (sVndrSeq[i] != null)
					model.setSVndrSeq(sVndrSeq[i]);
				if (sNodCd[i] != null)
					model.setSNodCd(sNodCd[i]);
				if (sIoBndCd[i] != null)
					model.setSIoBndCd(sIoBndCd[i]);
				if (sLocCd[i] != null)
					model.setSLocCd(sLocCd[i]);
				if (sBatRsltCd[i] != null)
					model.setSBatRsltCd(sBatRsltCd[i]);
				if (sVslCd[i] != null)
					model.setSVslCd(sVslCd[i]);
				if (sTmlInvTpCd[i] != null)
					model.setSTmlInvTpCd(sTmlInvTpCd[i]);
				if (sToInvCfmDt[i] != null)
					model.setSToInvCfmDt(sToInvCfmDt[i]);
				if (sCalcCostGrpCd[i] != null)
					model.setSCalcCostGrpCd(sCalcCostGrpCd[i]);
				if (sPrdYm[i] != null)
					model.setSPrdYm(sPrdYm[i]);
				if (sCostCalcMzdCd[i] != null)
					model.setSCostCalcMzdCd(sCostCalcMzdCd[i]);
				if (sSkdDirCd[i] != null)
					model.setSSkdDirCd(sSkdDirCd[i]);
				if (sFmDt[i] != null)
					model.setSFmDt(sFmDt[i]);
				if (sDiffRto[i] != null)
					model.setSDiffRto(sDiffRto[i]);
				if (batchTpCd[i] != null)
					model.setBatchTpCd(batchTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesAuditConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesAuditConditionVO[]
	 */
	public TesAuditConditionVO[] getTesAuditConditionVOs(){
		TesAuditConditionVO[] vos = (TesAuditConditionVO[])models.toArray(new TesAuditConditionVO[models.size()]);
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
		this.sLgsCostSubjCd = this.sLgsCostSubjCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sToDt = this.sToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacFlg = this.sEacFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVvd = this.sVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqOfcCd = this.sRhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvOfcCd = this.sInvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAutoExpnAudStsCd = this.sAutoExpnAudStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCalcTpCd = this.sCalcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sExpnAudStsCd = this.sExpnAudStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCsrStsCd = this.sCsrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLgsCostDtlCd = this.sLgsCostDtlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCsrNo = this.sCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sToPrdDt = this.sToPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sToday = this.sToday .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFmPrdDt = this.sFmPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAudOfcCd = this.sAudOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sYdCd = this.sYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvCfmDt = this.sInvCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDatetime = this.toDatetime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntrTpszCd = this.sCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSkdVoyNo = this.sSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLaneCd = this.sLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFromInvCfmDt = this.sFromInvCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntrVslClssCapa = this.sCntrVslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sExpnAudTgtFlg = this.sExpnAudTgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDiffSgn = this.sDiffSgn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvNo = this.sInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrSeq = this.sVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sNodCd = this.sNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIoBndCd = this.sIoBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLocCd = this.sLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBatRsltCd = this.sBatRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVslCd = this.sVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTmlInvTpCd = this.sTmlInvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sToInvCfmDt = this.sToInvCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCalcCostGrpCd = this.sCalcCostGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPrdYm = this.sPrdYm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCostCalcMzdCd = this.sCostCalcMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSkdDirCd = this.sSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFmDt = this.sFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDiffRto = this.sDiffRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batchTpCd = this.batchTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
