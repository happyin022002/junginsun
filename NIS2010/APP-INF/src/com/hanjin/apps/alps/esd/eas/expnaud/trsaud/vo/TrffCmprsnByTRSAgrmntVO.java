/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrffCmprsnByTRSAgrmntVO.java
*@FileTitle : TrffCmprsnByTRSAgrmntVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.27
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.04.27 최종혁 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo;

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
 * @author 최종혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TrffCmprsnByTRSAgrmntVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TrffCmprsnByTRSAgrmntVO> models = new ArrayList<TrffCmprsnByTRSAgrmntVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String woCurrCd = null;
	/* Column Info */
	private String so20ftVolKnt = null;
	/* Column Info */
	private String sWoOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String wo45ftDryAvgAmt = null;
	/* Column Info */
	private String agmt20ftDryUsdAmt = null;
	/* Column Info */
	private String trspAvg20ftRfUsdAmt = null;
	/* Column Info */
	private String trspCostDtlModCd = null;
	/* Column Info */
	private String agmtCurrCd = null;
	/* Column Info */
	private String wo20ftDryAvgAmt = null;
	/* Column Info */
	private String trspSoTpCd = null;
	/* Column Info */
	private String trspAvg40ftDryUsdAmt = null;
	/* Column Info */
	private String sToNodCd = null;
	/* Column Info */
	private String sToYrmon = null;
	/* Column Info */
	private String wo20ftAwkAvgAmt = null;
	/* Column Info */
	private String agmt20ftRfUsdAmt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String sTrspBndCd = null;
	/* Column Info */
	private String trspAvg20ftDryUsdAmt = null;
	/* Column Info */
	private String sTrspCrrModCd = null;
	/* Column Info */
	private String agmt20ftDryAmt = null;
	/* Column Info */
	private String agmt20ftRfAmt = null;
	/* Column Info */
	private String woRhqCd = null;
	/* Column Info */
	private String sRhqOfcCd = null;
	/* Column Info */
	private String wo40ftAwkAvgAmt = null;
	/* Column Info */
	private String wo20ftDgAvgAmt = null;
	/* Column Info */
	private String sDorNodCd = null;
	/* Column Info */
	private String trspAvg40ftRfUsdAmt = null;
	/* Column Info */
	private String wo20ftRfAvgAmt = null;
	/* Column Info */
	private String woOfcCd = null;
	/* Column Info */
	private String agmt40ftRfUsdAmt = null;
	/* Column Info */
	private String sFmYrmon = null;
	/* Column Info */
	private String wo40ftRfAvgAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sSoTpCd = null;
	/* Column Info */
	private String agmt40ftDryAmt = null;
	/* Column Info */
	private String agmt40ftDryUsdAmt = null;
	/* Column Info */
	private String so40ftVolKnt = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String sTrspCostDtlModCd = null;
	/* Column Info */
	private String sViaNodCd = null;
	/* Column Info */
	private String soBxQty = null;
	/* Column Info */
	private String inlndCostYrmon = null;
	/* Column Info */
	private String soTeuQty = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String wo40ftDgAvgAmt = null;
	/* Column Info */
	private String agmt40ftRfAmt = null;
	/* Column Info */
	private String wo40ftDryAvgAmt = null;
	/* Column Info */
	private String viaNodCd = null;
	/* Column Info */
	private String sFmNodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TrffCmprsnByTRSAgrmntVO() {}

	public TrffCmprsnByTRSAgrmntVO(String ibflag, String pagerows, String sRhqOfcCd, String sWoOfcCd, String sFmYrmon, String sToYrmon, String sSoTpCd, String sTrspCostDtlModCd, String sTrspCrrModCd, String sTrspBndCd, String sFmNodCd, String sViaNodCd, String sToNodCd, String sDorNodCd, String woRhqCd, String woOfcCd, String inlndCostYrmon, String trspSoTpCd, String trspCostDtlModCd, String trspCrrModCd, String trspBndCd, String fmNodCd, String viaNodCd, String toNodCd, String dorNodCd, String vndrSeq, String vndrNm, String agmtCurrCd, String agmt20ftDryAmt, String agmt40ftDryAmt, String agmt20ftRfAmt, String agmt40ftRfAmt, String agmt20ftDryUsdAmt, String agmt40ftDryUsdAmt, String agmt20ftRfUsdAmt, String agmt40ftRfUsdAmt, String trspAvg20ftDryUsdAmt, String trspAvg40ftDryUsdAmt, String trspAvg20ftRfUsdAmt, String trspAvg40ftRfUsdAmt, String so20ftVolKnt, String so40ftVolKnt, String soTeuQty, String soBxQty, String woCurrCd, String wo20ftDryAvgAmt, String wo40ftDryAvgAmt, String wo45ftDryAvgAmt, String wo20ftRfAvgAmt, String wo40ftRfAvgAmt, String wo20ftDgAvgAmt, String wo40ftDgAvgAmt, String wo20ftAwkAvgAmt, String wo40ftAwkAvgAmt) {
		this.toNodCd = toNodCd;
		this.woCurrCd = woCurrCd;
		this.so20ftVolKnt = so20ftVolKnt;
		this.sWoOfcCd = sWoOfcCd;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.wo45ftDryAvgAmt = wo45ftDryAvgAmt;
		this.agmt20ftDryUsdAmt = agmt20ftDryUsdAmt;
		this.trspAvg20ftRfUsdAmt = trspAvg20ftRfUsdAmt;
		this.trspCostDtlModCd = trspCostDtlModCd;
		this.agmtCurrCd = agmtCurrCd;
		this.wo20ftDryAvgAmt = wo20ftDryAvgAmt;
		this.trspSoTpCd = trspSoTpCd;
		this.trspAvg40ftDryUsdAmt = trspAvg40ftDryUsdAmt;
		this.sToNodCd = sToNodCd;
		this.sToYrmon = sToYrmon;
		this.wo20ftAwkAvgAmt = wo20ftAwkAvgAmt;
		this.agmt20ftRfUsdAmt = agmt20ftRfUsdAmt;
		this.vndrSeq = vndrSeq;
		this.sTrspBndCd = sTrspBndCd;
		this.trspAvg20ftDryUsdAmt = trspAvg20ftDryUsdAmt;
		this.sTrspCrrModCd = sTrspCrrModCd;
		this.agmt20ftDryAmt = agmt20ftDryAmt;
		this.agmt20ftRfAmt = agmt20ftRfAmt;
		this.woRhqCd = woRhqCd;
		this.sRhqOfcCd = sRhqOfcCd;
		this.wo40ftAwkAvgAmt = wo40ftAwkAvgAmt;
		this.wo20ftDgAvgAmt = wo20ftDgAvgAmt;
		this.sDorNodCd = sDorNodCd;
		this.trspAvg40ftRfUsdAmt = trspAvg40ftRfUsdAmt;
		this.wo20ftRfAvgAmt = wo20ftRfAvgAmt;
		this.woOfcCd = woOfcCd;
		this.agmt40ftRfUsdAmt = agmt40ftRfUsdAmt;
		this.sFmYrmon = sFmYrmon;
		this.wo40ftRfAvgAmt = wo40ftRfAvgAmt;
		this.ibflag = ibflag;
		this.sSoTpCd = sSoTpCd;
		this.agmt40ftDryAmt = agmt40ftDryAmt;
		this.agmt40ftDryUsdAmt = agmt40ftDryUsdAmt;
		this.so40ftVolKnt = so40ftVolKnt;
		this.dorNodCd = dorNodCd;
		this.trspCrrModCd = trspCrrModCd;
		this.trspBndCd = trspBndCd;
		this.sTrspCostDtlModCd = sTrspCostDtlModCd;
		this.sViaNodCd = sViaNodCd;
		this.soBxQty = soBxQty;
		this.inlndCostYrmon = inlndCostYrmon;
		this.soTeuQty = soTeuQty;
		this.fmNodCd = fmNodCd;
		this.wo40ftDgAvgAmt = wo40ftDgAvgAmt;
		this.agmt40ftRfAmt = agmt40ftRfAmt;
		this.wo40ftDryAvgAmt = wo40ftDryAvgAmt;
		this.viaNodCd = viaNodCd;
		this.sFmNodCd = sFmNodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("wo_curr_cd", getWoCurrCd());
		this.hashColumns.put("so_20ft_vol_knt", getSo20ftVolKnt());
		this.hashColumns.put("s_wo_ofc_cd", getSWoOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("wo_45ft_dry_avg_amt", getWo45ftDryAvgAmt());
		this.hashColumns.put("agmt_20ft_dry_usd_amt", getAgmt20ftDryUsdAmt());
		this.hashColumns.put("trsp_avg_20ft_rf_usd_amt", getTrspAvg20ftRfUsdAmt());
		this.hashColumns.put("trsp_cost_dtl_mod_cd", getTrspCostDtlModCd());
		this.hashColumns.put("agmt_curr_cd", getAgmtCurrCd());
		this.hashColumns.put("wo_20ft_dry_avg_amt", getWo20ftDryAvgAmt());
		this.hashColumns.put("trsp_so_tp_cd", getTrspSoTpCd());
		this.hashColumns.put("trsp_avg_40ft_dry_usd_amt", getTrspAvg40ftDryUsdAmt());
		this.hashColumns.put("s_to_nod_cd", getSToNodCd());
		this.hashColumns.put("s_to_yrmon", getSToYrmon());
		this.hashColumns.put("wo_20ft_awk_avg_amt", getWo20ftAwkAvgAmt());
		this.hashColumns.put("agmt_20ft_rf_usd_amt", getAgmt20ftRfUsdAmt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("s_trsp_bnd_cd", getSTrspBndCd());
		this.hashColumns.put("trsp_avg_20ft_dry_usd_amt", getTrspAvg20ftDryUsdAmt());
		this.hashColumns.put("s_trsp_crr_mod_cd", getSTrspCrrModCd());
		this.hashColumns.put("agmt_20ft_dry_amt", getAgmt20ftDryAmt());
		this.hashColumns.put("agmt_20ft_rf_amt", getAgmt20ftRfAmt());
		this.hashColumns.put("wo_rhq_cd", getWoRhqCd());
		this.hashColumns.put("s_rhq_ofc_cd", getSRhqOfcCd());
		this.hashColumns.put("wo_40ft_awk_avg_amt", getWo40ftAwkAvgAmt());
		this.hashColumns.put("wo_20ft_dg_avg_amt", getWo20ftDgAvgAmt());
		this.hashColumns.put("s_dor_nod_cd", getSDorNodCd());
		this.hashColumns.put("trsp_avg_40ft_rf_usd_amt", getTrspAvg40ftRfUsdAmt());
		this.hashColumns.put("wo_20ft_rf_avg_amt", getWo20ftRfAvgAmt());
		this.hashColumns.put("wo_ofc_cd", getWoOfcCd());
		this.hashColumns.put("agmt_40ft_rf_usd_amt", getAgmt40ftRfUsdAmt());
		this.hashColumns.put("s_fm_yrmon", getSFmYrmon());
		this.hashColumns.put("wo_40ft_rf_avg_amt", getWo40ftRfAvgAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_so_tp_cd", getSSoTpCd());
		this.hashColumns.put("agmt_40ft_dry_amt", getAgmt40ftDryAmt());
		this.hashColumns.put("agmt_40ft_dry_usd_amt", getAgmt40ftDryUsdAmt());
		this.hashColumns.put("so_40ft_vol_knt", getSo40ftVolKnt());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("s_trsp_cost_dtl_mod_cd", getSTrspCostDtlModCd());
		this.hashColumns.put("s_via_nod_cd", getSViaNodCd());
		this.hashColumns.put("so_bx_qty", getSoBxQty());
		this.hashColumns.put("inlnd_cost_yrmon", getInlndCostYrmon());
		this.hashColumns.put("so_teu_qty", getSoTeuQty());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("wo_40ft_dg_avg_amt", getWo40ftDgAvgAmt());
		this.hashColumns.put("agmt_40ft_rf_amt", getAgmt40ftRfAmt());
		this.hashColumns.put("wo_40ft_dry_avg_amt", getWo40ftDryAvgAmt());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("s_fm_nod_cd", getSFmNodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("wo_curr_cd", "woCurrCd");
		this.hashFields.put("so_20ft_vol_knt", "so20ftVolKnt");
		this.hashFields.put("s_wo_ofc_cd", "sWoOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("wo_45ft_dry_avg_amt", "wo45ftDryAvgAmt");
		this.hashFields.put("agmt_20ft_dry_usd_amt", "agmt20ftDryUsdAmt");
		this.hashFields.put("trsp_avg_20ft_rf_usd_amt", "trspAvg20ftRfUsdAmt");
		this.hashFields.put("trsp_cost_dtl_mod_cd", "trspCostDtlModCd");
		this.hashFields.put("agmt_curr_cd", "agmtCurrCd");
		this.hashFields.put("wo_20ft_dry_avg_amt", "wo20ftDryAvgAmt");
		this.hashFields.put("trsp_so_tp_cd", "trspSoTpCd");
		this.hashFields.put("trsp_avg_40ft_dry_usd_amt", "trspAvg40ftDryUsdAmt");
		this.hashFields.put("s_to_nod_cd", "sToNodCd");
		this.hashFields.put("s_to_yrmon", "sToYrmon");
		this.hashFields.put("wo_20ft_awk_avg_amt", "wo20ftAwkAvgAmt");
		this.hashFields.put("agmt_20ft_rf_usd_amt", "agmt20ftRfUsdAmt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("s_trsp_bnd_cd", "sTrspBndCd");
		this.hashFields.put("trsp_avg_20ft_dry_usd_amt", "trspAvg20ftDryUsdAmt");
		this.hashFields.put("s_trsp_crr_mod_cd", "sTrspCrrModCd");
		this.hashFields.put("agmt_20ft_dry_amt", "agmt20ftDryAmt");
		this.hashFields.put("agmt_20ft_rf_amt", "agmt20ftRfAmt");
		this.hashFields.put("wo_rhq_cd", "woRhqCd");
		this.hashFields.put("s_rhq_ofc_cd", "sRhqOfcCd");
		this.hashFields.put("wo_40ft_awk_avg_amt", "wo40ftAwkAvgAmt");
		this.hashFields.put("wo_20ft_dg_avg_amt", "wo20ftDgAvgAmt");
		this.hashFields.put("s_dor_nod_cd", "sDorNodCd");
		this.hashFields.put("trsp_avg_40ft_rf_usd_amt", "trspAvg40ftRfUsdAmt");
		this.hashFields.put("wo_20ft_rf_avg_amt", "wo20ftRfAvgAmt");
		this.hashFields.put("wo_ofc_cd", "woOfcCd");
		this.hashFields.put("agmt_40ft_rf_usd_amt", "agmt40ftRfUsdAmt");
		this.hashFields.put("s_fm_yrmon", "sFmYrmon");
		this.hashFields.put("wo_40ft_rf_avg_amt", "wo40ftRfAvgAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_so_tp_cd", "sSoTpCd");
		this.hashFields.put("agmt_40ft_dry_amt", "agmt40ftDryAmt");
		this.hashFields.put("agmt_40ft_dry_usd_amt", "agmt40ftDryUsdAmt");
		this.hashFields.put("so_40ft_vol_knt", "so40ftVolKnt");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("s_trsp_cost_dtl_mod_cd", "sTrspCostDtlModCd");
		this.hashFields.put("s_via_nod_cd", "sViaNodCd");
		this.hashFields.put("so_bx_qty", "soBxQty");
		this.hashFields.put("inlnd_cost_yrmon", "inlndCostYrmon");
		this.hashFields.put("so_teu_qty", "soTeuQty");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("wo_40ft_dg_avg_amt", "wo40ftDgAvgAmt");
		this.hashFields.put("agmt_40ft_rf_amt", "agmt40ftRfAmt");
		this.hashFields.put("wo_40ft_dry_avg_amt", "wo40ftDryAvgAmt");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("s_fm_nod_cd", "sFmNodCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return woCurrCd
	 */
	public String getWoCurrCd() {
		return this.woCurrCd;
	}
	
	/**
	 * Column Info
	 * @return so20ftVolKnt
	 */
	public String getSo20ftVolKnt() {
		return this.so20ftVolKnt;
	}
	
	/**
	 * Column Info
	 * @return sWoOfcCd
	 */
	public String getSWoOfcCd() {
		return this.sWoOfcCd;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return wo45ftDryAvgAmt
	 */
	public String getWo45ftDryAvgAmt() {
		return this.wo45ftDryAvgAmt;
	}
	
	/**
	 * Column Info
	 * @return agmt20ftDryUsdAmt
	 */
	public String getAgmt20ftDryUsdAmt() {
		return this.agmt20ftDryUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return trspAvg20ftRfUsdAmt
	 */
	public String getTrspAvg20ftRfUsdAmt() {
		return this.trspAvg20ftRfUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return trspCostDtlModCd
	 */
	public String getTrspCostDtlModCd() {
		return this.trspCostDtlModCd;
	}
	
	/**
	 * Column Info
	 * @return agmtCurrCd
	 */
	public String getAgmtCurrCd() {
		return this.agmtCurrCd;
	}
	
	/**
	 * Column Info
	 * @return wo20ftDryAvgAmt
	 */
	public String getWo20ftDryAvgAmt() {
		return this.wo20ftDryAvgAmt;
	}
	
	/**
	 * Column Info
	 * @return trspSoTpCd
	 */
	public String getTrspSoTpCd() {
		return this.trspSoTpCd;
	}
	
	/**
	 * Column Info
	 * @return trspAvg40ftDryUsdAmt
	 */
	public String getTrspAvg40ftDryUsdAmt() {
		return this.trspAvg40ftDryUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return sToNodCd
	 */
	public String getSToNodCd() {
		return this.sToNodCd;
	}
	
	/**
	 * Column Info
	 * @return sToYrmon
	 */
	public String getSToYrmon() {
		return this.sToYrmon;
	}
	
	/**
	 * Column Info
	 * @return wo20ftAwkAvgAmt
	 */
	public String getWo20ftAwkAvgAmt() {
		return this.wo20ftAwkAvgAmt;
	}
	
	/**
	 * Column Info
	 * @return agmt20ftRfUsdAmt
	 */
	public String getAgmt20ftRfUsdAmt() {
		return this.agmt20ftRfUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return sTrspBndCd
	 */
	public String getSTrspBndCd() {
		return this.sTrspBndCd;
	}
	
	/**
	 * Column Info
	 * @return trspAvg20ftDryUsdAmt
	 */
	public String getTrspAvg20ftDryUsdAmt() {
		return this.trspAvg20ftDryUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return sTrspCrrModCd
	 */
	public String getSTrspCrrModCd() {
		return this.sTrspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @return agmt20ftDryAmt
	 */
	public String getAgmt20ftDryAmt() {
		return this.agmt20ftDryAmt;
	}
	
	/**
	 * Column Info
	 * @return agmt20ftRfAmt
	 */
	public String getAgmt20ftRfAmt() {
		return this.agmt20ftRfAmt;
	}
	
	/**
	 * Column Info
	 * @return woRhqCd
	 */
	public String getWoRhqCd() {
		return this.woRhqCd;
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
	 * @return wo40ftAwkAvgAmt
	 */
	public String getWo40ftAwkAvgAmt() {
		return this.wo40ftAwkAvgAmt;
	}
	
	/**
	 * Column Info
	 * @return wo20ftDgAvgAmt
	 */
	public String getWo20ftDgAvgAmt() {
		return this.wo20ftDgAvgAmt;
	}
	
	/**
	 * Column Info
	 * @return sDorNodCd
	 */
	public String getSDorNodCd() {
		return this.sDorNodCd;
	}
	
	/**
	 * Column Info
	 * @return trspAvg40ftRfUsdAmt
	 */
	public String getTrspAvg40ftRfUsdAmt() {
		return this.trspAvg40ftRfUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return wo20ftRfAvgAmt
	 */
	public String getWo20ftRfAvgAmt() {
		return this.wo20ftRfAvgAmt;
	}
	
	/**
	 * Column Info
	 * @return woOfcCd
	 */
	public String getWoOfcCd() {
		return this.woOfcCd;
	}
	
	/**
	 * Column Info
	 * @return agmt40ftRfUsdAmt
	 */
	public String getAgmt40ftRfUsdAmt() {
		return this.agmt40ftRfUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return sFmYrmon
	 */
	public String getSFmYrmon() {
		return this.sFmYrmon;
	}
	
	/**
	 * Column Info
	 * @return wo40ftRfAvgAmt
	 */
	public String getWo40ftRfAvgAmt() {
		return this.wo40ftRfAvgAmt;
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
	 * @return sSoTpCd
	 */
	public String getSSoTpCd() {
		return this.sSoTpCd;
	}
	
	/**
	 * Column Info
	 * @return agmt40ftDryAmt
	 */
	public String getAgmt40ftDryAmt() {
		return this.agmt40ftDryAmt;
	}
	
	/**
	 * Column Info
	 * @return agmt40ftDryUsdAmt
	 */
	public String getAgmt40ftDryUsdAmt() {
		return this.agmt40ftDryUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return so40ftVolKnt
	 */
	public String getSo40ftVolKnt() {
		return this.so40ftVolKnt;
	}
	
	/**
	 * Column Info
	 * @return dorNodCd
	 */
	public String getDorNodCd() {
		return this.dorNodCd;
	}
	
	/**
	 * Column Info
	 * @return trspCrrModCd
	 */
	public String getTrspCrrModCd() {
		return this.trspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @return trspBndCd
	 */
	public String getTrspBndCd() {
		return this.trspBndCd;
	}
	
	/**
	 * Column Info
	 * @return sTrspCostDtlModCd
	 */
	public String getSTrspCostDtlModCd() {
		return this.sTrspCostDtlModCd;
	}
	
	/**
	 * Column Info
	 * @return sViaNodCd
	 */
	public String getSViaNodCd() {
		return this.sViaNodCd;
	}
	
	/**
	 * Column Info
	 * @return soBxQty
	 */
	public String getSoBxQty() {
		return this.soBxQty;
	}
	
	/**
	 * Column Info
	 * @return inlndCostYrmon
	 */
	public String getInlndCostYrmon() {
		return this.inlndCostYrmon;
	}
	
	/**
	 * Column Info
	 * @return soTeuQty
	 */
	public String getSoTeuQty() {
		return this.soTeuQty;
	}
	
	/**
	 * Column Info
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}
	
	/**
	 * Column Info
	 * @return wo40ftDgAvgAmt
	 */
	public String getWo40ftDgAvgAmt() {
		return this.wo40ftDgAvgAmt;
	}
	
	/**
	 * Column Info
	 * @return agmt40ftRfAmt
	 */
	public String getAgmt40ftRfAmt() {
		return this.agmt40ftRfAmt;
	}
	
	/**
	 * Column Info
	 * @return wo40ftDryAvgAmt
	 */
	public String getWo40ftDryAvgAmt() {
		return this.wo40ftDryAvgAmt;
	}
	
	/**
	 * Column Info
	 * @return viaNodCd
	 */
	public String getViaNodCd() {
		return this.viaNodCd;
	}
	
	/**
	 * Column Info
	 * @return sFmNodCd
	 */
	public String getSFmNodCd() {
		return this.sFmNodCd;
	}
	

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param woCurrCd
	 */
	public void setWoCurrCd(String woCurrCd) {
		this.woCurrCd = woCurrCd;
	}
	
	/**
	 * Column Info
	 * @param so20ftVolKnt
	 */
	public void setSo20ftVolKnt(String so20ftVolKnt) {
		this.so20ftVolKnt = so20ftVolKnt;
	}
	
	/**
	 * Column Info
	 * @param sWoOfcCd
	 */
	public void setSWoOfcCd(String sWoOfcCd) {
		this.sWoOfcCd = sWoOfcCd;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param wo45ftDryAvgAmt
	 */
	public void setWo45ftDryAvgAmt(String wo45ftDryAvgAmt) {
		this.wo45ftDryAvgAmt = wo45ftDryAvgAmt;
	}
	
	/**
	 * Column Info
	 * @param agmt20ftDryUsdAmt
	 */
	public void setAgmt20ftDryUsdAmt(String agmt20ftDryUsdAmt) {
		this.agmt20ftDryUsdAmt = agmt20ftDryUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param trspAvg20ftRfUsdAmt
	 */
	public void setTrspAvg20ftRfUsdAmt(String trspAvg20ftRfUsdAmt) {
		this.trspAvg20ftRfUsdAmt = trspAvg20ftRfUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param trspCostDtlModCd
	 */
	public void setTrspCostDtlModCd(String trspCostDtlModCd) {
		this.trspCostDtlModCd = trspCostDtlModCd;
	}
	
	/**
	 * Column Info
	 * @param agmtCurrCd
	 */
	public void setAgmtCurrCd(String agmtCurrCd) {
		this.agmtCurrCd = agmtCurrCd;
	}
	
	/**
	 * Column Info
	 * @param wo20ftDryAvgAmt
	 */
	public void setWo20ftDryAvgAmt(String wo20ftDryAvgAmt) {
		this.wo20ftDryAvgAmt = wo20ftDryAvgAmt;
	}
	
	/**
	 * Column Info
	 * @param trspSoTpCd
	 */
	public void setTrspSoTpCd(String trspSoTpCd) {
		this.trspSoTpCd = trspSoTpCd;
	}
	
	/**
	 * Column Info
	 * @param trspAvg40ftDryUsdAmt
	 */
	public void setTrspAvg40ftDryUsdAmt(String trspAvg40ftDryUsdAmt) {
		this.trspAvg40ftDryUsdAmt = trspAvg40ftDryUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param sToNodCd
	 */
	public void setSToNodCd(String sToNodCd) {
		this.sToNodCd = sToNodCd;
	}
	
	/**
	 * Column Info
	 * @param sToYrmon
	 */
	public void setSToYrmon(String sToYrmon) {
		this.sToYrmon = sToYrmon;
	}
	
	/**
	 * Column Info
	 * @param wo20ftAwkAvgAmt
	 */
	public void setWo20ftAwkAvgAmt(String wo20ftAwkAvgAmt) {
		this.wo20ftAwkAvgAmt = wo20ftAwkAvgAmt;
	}
	
	/**
	 * Column Info
	 * @param agmt20ftRfUsdAmt
	 */
	public void setAgmt20ftRfUsdAmt(String agmt20ftRfUsdAmt) {
		this.agmt20ftRfUsdAmt = agmt20ftRfUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param sTrspBndCd
	 */
	public void setSTrspBndCd(String sTrspBndCd) {
		this.sTrspBndCd = sTrspBndCd;
	}
	
	/**
	 * Column Info
	 * @param trspAvg20ftDryUsdAmt
	 */
	public void setTrspAvg20ftDryUsdAmt(String trspAvg20ftDryUsdAmt) {
		this.trspAvg20ftDryUsdAmt = trspAvg20ftDryUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param sTrspCrrModCd
	 */
	public void setSTrspCrrModCd(String sTrspCrrModCd) {
		this.sTrspCrrModCd = sTrspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @param agmt20ftDryAmt
	 */
	public void setAgmt20ftDryAmt(String agmt20ftDryAmt) {
		this.agmt20ftDryAmt = agmt20ftDryAmt;
	}
	
	/**
	 * Column Info
	 * @param agmt20ftRfAmt
	 */
	public void setAgmt20ftRfAmt(String agmt20ftRfAmt) {
		this.agmt20ftRfAmt = agmt20ftRfAmt;
	}
	
	/**
	 * Column Info
	 * @param woRhqCd
	 */
	public void setWoRhqCd(String woRhqCd) {
		this.woRhqCd = woRhqCd;
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
	 * @param wo40ftAwkAvgAmt
	 */
	public void setWo40ftAwkAvgAmt(String wo40ftAwkAvgAmt) {
		this.wo40ftAwkAvgAmt = wo40ftAwkAvgAmt;
	}
	
	/**
	 * Column Info
	 * @param wo20ftDgAvgAmt
	 */
	public void setWo20ftDgAvgAmt(String wo20ftDgAvgAmt) {
		this.wo20ftDgAvgAmt = wo20ftDgAvgAmt;
	}
	
	/**
	 * Column Info
	 * @param sDorNodCd
	 */
	public void setSDorNodCd(String sDorNodCd) {
		this.sDorNodCd = sDorNodCd;
	}
	
	/**
	 * Column Info
	 * @param trspAvg40ftRfUsdAmt
	 */
	public void setTrspAvg40ftRfUsdAmt(String trspAvg40ftRfUsdAmt) {
		this.trspAvg40ftRfUsdAmt = trspAvg40ftRfUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param wo20ftRfAvgAmt
	 */
	public void setWo20ftRfAvgAmt(String wo20ftRfAvgAmt) {
		this.wo20ftRfAvgAmt = wo20ftRfAvgAmt;
	}
	
	/**
	 * Column Info
	 * @param woOfcCd
	 */
	public void setWoOfcCd(String woOfcCd) {
		this.woOfcCd = woOfcCd;
	}
	
	/**
	 * Column Info
	 * @param agmt40ftRfUsdAmt
	 */
	public void setAgmt40ftRfUsdAmt(String agmt40ftRfUsdAmt) {
		this.agmt40ftRfUsdAmt = agmt40ftRfUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param sFmYrmon
	 */
	public void setSFmYrmon(String sFmYrmon) {
		this.sFmYrmon = sFmYrmon;
	}
	
	/**
	 * Column Info
	 * @param wo40ftRfAvgAmt
	 */
	public void setWo40ftRfAvgAmt(String wo40ftRfAvgAmt) {
		this.wo40ftRfAvgAmt = wo40ftRfAvgAmt;
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
	 * @param sSoTpCd
	 */
	public void setSSoTpCd(String sSoTpCd) {
		this.sSoTpCd = sSoTpCd;
	}
	
	/**
	 * Column Info
	 * @param agmt40ftDryAmt
	 */
	public void setAgmt40ftDryAmt(String agmt40ftDryAmt) {
		this.agmt40ftDryAmt = agmt40ftDryAmt;
	}
	
	/**
	 * Column Info
	 * @param agmt40ftDryUsdAmt
	 */
	public void setAgmt40ftDryUsdAmt(String agmt40ftDryUsdAmt) {
		this.agmt40ftDryUsdAmt = agmt40ftDryUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param so40ftVolKnt
	 */
	public void setSo40ftVolKnt(String so40ftVolKnt) {
		this.so40ftVolKnt = so40ftVolKnt;
	}
	
	/**
	 * Column Info
	 * @param dorNodCd
	 */
	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}
	
	/**
	 * Column Info
	 * @param trspCrrModCd
	 */
	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @param trspBndCd
	 */
	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}
	
	/**
	 * Column Info
	 * @param sTrspCostDtlModCd
	 */
	public void setSTrspCostDtlModCd(String sTrspCostDtlModCd) {
		this.sTrspCostDtlModCd = sTrspCostDtlModCd;
	}
	
	/**
	 * Column Info
	 * @param sViaNodCd
	 */
	public void setSViaNodCd(String sViaNodCd) {
		this.sViaNodCd = sViaNodCd;
	}
	
	/**
	 * Column Info
	 * @param soBxQty
	 */
	public void setSoBxQty(String soBxQty) {
		this.soBxQty = soBxQty;
	}
	
	/**
	 * Column Info
	 * @param inlndCostYrmon
	 */
	public void setInlndCostYrmon(String inlndCostYrmon) {
		this.inlndCostYrmon = inlndCostYrmon;
	}
	
	/**
	 * Column Info
	 * @param soTeuQty
	 */
	public void setSoTeuQty(String soTeuQty) {
		this.soTeuQty = soTeuQty;
	}
	
	/**
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	/**
	 * Column Info
	 * @param wo40ftDgAvgAmt
	 */
	public void setWo40ftDgAvgAmt(String wo40ftDgAvgAmt) {
		this.wo40ftDgAvgAmt = wo40ftDgAvgAmt;
	}
	
	/**
	 * Column Info
	 * @param agmt40ftRfAmt
	 */
	public void setAgmt40ftRfAmt(String agmt40ftRfAmt) {
		this.agmt40ftRfAmt = agmt40ftRfAmt;
	}
	
	/**
	 * Column Info
	 * @param wo40ftDryAvgAmt
	 */
	public void setWo40ftDryAvgAmt(String wo40ftDryAvgAmt) {
		this.wo40ftDryAvgAmt = wo40ftDryAvgAmt;
	}
	
	/**
	 * Column Info
	 * @param viaNodCd
	 */
	public void setViaNodCd(String viaNodCd) {
		this.viaNodCd = viaNodCd;
	}
	
	/**
	 * Column Info
	 * @param sFmNodCd
	 */
	public void setSFmNodCd(String sFmNodCd) {
		this.sFmNodCd = sFmNodCd;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setWoCurrCd(JSPUtil.getParameter(request, prefix + "wo_curr_cd", ""));
		setSo20ftVolKnt(JSPUtil.getParameter(request, prefix + "so_20ft_vol_knt", ""));
		setSWoOfcCd(JSPUtil.getParameter(request, prefix + "s_wo_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setWo45ftDryAvgAmt(JSPUtil.getParameter(request, prefix + "wo_45ft_dry_avg_amt", ""));
		setAgmt20ftDryUsdAmt(JSPUtil.getParameter(request, prefix + "agmt_20ft_dry_usd_amt", ""));
		setTrspAvg20ftRfUsdAmt(JSPUtil.getParameter(request, prefix + "trsp_avg_20ft_rf_usd_amt", ""));
		setTrspCostDtlModCd(JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_cd", ""));
		setAgmtCurrCd(JSPUtil.getParameter(request, prefix + "agmt_curr_cd", ""));
		setWo20ftDryAvgAmt(JSPUtil.getParameter(request, prefix + "wo_20ft_dry_avg_amt", ""));
		setTrspSoTpCd(JSPUtil.getParameter(request, prefix + "trsp_so_tp_cd", ""));
		setTrspAvg40ftDryUsdAmt(JSPUtil.getParameter(request, prefix + "trsp_avg_40ft_dry_usd_amt", ""));
		setSToNodCd(JSPUtil.getParameter(request, prefix + "s_to_nod_cd", ""));
		setSToYrmon(JSPUtil.getParameter(request, prefix + "s_to_yrmon", ""));
		setWo20ftAwkAvgAmt(JSPUtil.getParameter(request, prefix + "wo_20ft_awk_avg_amt", ""));
		setAgmt20ftRfUsdAmt(JSPUtil.getParameter(request, prefix + "agmt_20ft_rf_usd_amt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setSTrspBndCd(JSPUtil.getParameter(request, prefix + "s_trsp_bnd_cd", ""));
		setTrspAvg20ftDryUsdAmt(JSPUtil.getParameter(request, prefix + "trsp_avg_20ft_dry_usd_amt", ""));
		setSTrspCrrModCd(JSPUtil.getParameter(request, prefix + "s_trsp_crr_mod_cd", ""));
		setAgmt20ftDryAmt(JSPUtil.getParameter(request, prefix + "agmt_20ft_dry_amt", ""));
		setAgmt20ftRfAmt(JSPUtil.getParameter(request, prefix + "agmt_20ft_rf_amt", ""));
		setWoRhqCd(JSPUtil.getParameter(request, prefix + "wo_rhq_cd", ""));
		setSRhqOfcCd(JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", ""));
		setWo40ftAwkAvgAmt(JSPUtil.getParameter(request, prefix + "wo_40ft_awk_avg_amt", ""));
		setWo20ftDgAvgAmt(JSPUtil.getParameter(request, prefix + "wo_20ft_dg_avg_amt", ""));
		setSDorNodCd(JSPUtil.getParameter(request, prefix + "s_dor_nod_cd", ""));
		setTrspAvg40ftRfUsdAmt(JSPUtil.getParameter(request, prefix + "trsp_avg_40ft_rf_usd_amt", ""));
		setWo20ftRfAvgAmt(JSPUtil.getParameter(request, prefix + "wo_20ft_rf_avg_amt", ""));
		setWoOfcCd(JSPUtil.getParameter(request, prefix + "wo_ofc_cd", ""));
		setAgmt40ftRfUsdAmt(JSPUtil.getParameter(request, prefix + "agmt_40ft_rf_usd_amt", ""));
		setSFmYrmon(JSPUtil.getParameter(request, prefix + "s_fm_yrmon", ""));
		setWo40ftRfAvgAmt(JSPUtil.getParameter(request, prefix + "wo_40ft_rf_avg_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSSoTpCd(JSPUtil.getParameter(request, prefix + "s_so_tp_cd", ""));
		setAgmt40ftDryAmt(JSPUtil.getParameter(request, prefix + "agmt_40ft_dry_amt", ""));
		setAgmt40ftDryUsdAmt(JSPUtil.getParameter(request, prefix + "agmt_40ft_dry_usd_amt", ""));
		setSo40ftVolKnt(JSPUtil.getParameter(request, prefix + "so_40ft_vol_knt", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setTrspBndCd(JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", ""));
		setSTrspCostDtlModCd(JSPUtil.getParameter(request, prefix + "s_trsp_cost_dtl_mod_cd", ""));
		setSViaNodCd(JSPUtil.getParameter(request, prefix + "s_via_nod_cd", ""));
		setSoBxQty(JSPUtil.getParameter(request, prefix + "so_bx_qty", ""));
		setInlndCostYrmon(JSPUtil.getParameter(request, prefix + "inlnd_cost_yrmon", ""));
		setSoTeuQty(JSPUtil.getParameter(request, prefix + "so_teu_qty", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setWo40ftDgAvgAmt(JSPUtil.getParameter(request, prefix + "wo_40ft_dg_avg_amt", ""));
		setAgmt40ftRfAmt(JSPUtil.getParameter(request, prefix + "agmt_40ft_rf_amt", ""));
		setWo40ftDryAvgAmt(JSPUtil.getParameter(request, prefix + "wo_40ft_dry_avg_amt", ""));
		setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
		setSFmNodCd(JSPUtil.getParameter(request, prefix + "s_fm_nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TrffCmprsnByTRSAgrmntVO[]
	 */
	public TrffCmprsnByTRSAgrmntVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TrffCmprsnByTRSAgrmntVO[]
	 */
	public TrffCmprsnByTRSAgrmntVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TrffCmprsnByTRSAgrmntVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] woCurrCd = (JSPUtil.getParameter(request, prefix	+ "wo_curr_cd", length));
			String[] so20ftVolKnt = (JSPUtil.getParameter(request, prefix	+ "so_20ft_vol_knt", length));
			String[] sWoOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_wo_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] wo45ftDryAvgAmt = (JSPUtil.getParameter(request, prefix	+ "wo_45ft_dry_avg_amt", length));
			String[] agmt20ftDryUsdAmt = (JSPUtil.getParameter(request, prefix	+ "agmt_20ft_dry_usd_amt", length));
			String[] trspAvg20ftRfUsdAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_avg_20ft_rf_usd_amt", length));
			String[] trspCostDtlModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_dtl_mod_cd", length));
			String[] agmtCurrCd = (JSPUtil.getParameter(request, prefix	+ "agmt_curr_cd", length));
			String[] wo20ftDryAvgAmt = (JSPUtil.getParameter(request, prefix	+ "wo_20ft_dry_avg_amt", length));
			String[] trspSoTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_tp_cd", length));
			String[] trspAvg40ftDryUsdAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_avg_40ft_dry_usd_amt", length));
			String[] sToNodCd = (JSPUtil.getParameter(request, prefix	+ "s_to_nod_cd", length));
			String[] sToYrmon = (JSPUtil.getParameter(request, prefix	+ "s_to_yrmon", length));
			String[] wo20ftAwkAvgAmt = (JSPUtil.getParameter(request, prefix	+ "wo_20ft_awk_avg_amt", length));
			String[] agmt20ftRfUsdAmt = (JSPUtil.getParameter(request, prefix	+ "agmt_20ft_rf_usd_amt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] sTrspBndCd = (JSPUtil.getParameter(request, prefix	+ "s_trsp_bnd_cd", length));
			String[] trspAvg20ftDryUsdAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_avg_20ft_dry_usd_amt", length));
			String[] sTrspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "s_trsp_crr_mod_cd", length));
			String[] agmt20ftDryAmt = (JSPUtil.getParameter(request, prefix	+ "agmt_20ft_dry_amt", length));
			String[] agmt20ftRfAmt = (JSPUtil.getParameter(request, prefix	+ "agmt_20ft_rf_amt", length));
			String[] woRhqCd = (JSPUtil.getParameter(request, prefix	+ "wo_rhq_cd", length));
			String[] sRhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_rhq_ofc_cd", length));
			String[] wo40ftAwkAvgAmt = (JSPUtil.getParameter(request, prefix	+ "wo_40ft_awk_avg_amt", length));
			String[] wo20ftDgAvgAmt = (JSPUtil.getParameter(request, prefix	+ "wo_20ft_dg_avg_amt", length));
			String[] sDorNodCd = (JSPUtil.getParameter(request, prefix	+ "s_dor_nod_cd", length));
			String[] trspAvg40ftRfUsdAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_avg_40ft_rf_usd_amt", length));
			String[] wo20ftRfAvgAmt = (JSPUtil.getParameter(request, prefix	+ "wo_20ft_rf_avg_amt", length));
			String[] woOfcCd = (JSPUtil.getParameter(request, prefix	+ "wo_ofc_cd", length));
			String[] agmt40ftRfUsdAmt = (JSPUtil.getParameter(request, prefix	+ "agmt_40ft_rf_usd_amt", length));
			String[] sFmYrmon = (JSPUtil.getParameter(request, prefix	+ "s_fm_yrmon", length));
			String[] wo40ftRfAvgAmt = (JSPUtil.getParameter(request, prefix	+ "wo_40ft_rf_avg_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sSoTpCd = (JSPUtil.getParameter(request, prefix	+ "s_so_tp_cd", length));
			String[] agmt40ftDryAmt = (JSPUtil.getParameter(request, prefix	+ "agmt_40ft_dry_amt", length));
			String[] agmt40ftDryUsdAmt = (JSPUtil.getParameter(request, prefix	+ "agmt_40ft_dry_usd_amt", length));
			String[] so40ftVolKnt = (JSPUtil.getParameter(request, prefix	+ "so_40ft_vol_knt", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_bnd_cd", length));
			String[] sTrspCostDtlModCd = (JSPUtil.getParameter(request, prefix	+ "s_trsp_cost_dtl_mod_cd", length));
			String[] sViaNodCd = (JSPUtil.getParameter(request, prefix	+ "s_via_nod_cd", length));
			String[] soBxQty = (JSPUtil.getParameter(request, prefix	+ "so_bx_qty", length));
			String[] inlndCostYrmon = (JSPUtil.getParameter(request, prefix	+ "inlnd_cost_yrmon", length));
			String[] soTeuQty = (JSPUtil.getParameter(request, prefix	+ "so_teu_qty", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] wo40ftDgAvgAmt = (JSPUtil.getParameter(request, prefix	+ "wo_40ft_dg_avg_amt", length));
			String[] agmt40ftRfAmt = (JSPUtil.getParameter(request, prefix	+ "agmt_40ft_rf_amt", length));
			String[] wo40ftDryAvgAmt = (JSPUtil.getParameter(request, prefix	+ "wo_40ft_dry_avg_amt", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			String[] sFmNodCd = (JSPUtil.getParameter(request, prefix	+ "s_fm_nod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new TrffCmprsnByTRSAgrmntVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (woCurrCd[i] != null)
					model.setWoCurrCd(woCurrCd[i]);
				if (so20ftVolKnt[i] != null)
					model.setSo20ftVolKnt(so20ftVolKnt[i]);
				if (sWoOfcCd[i] != null)
					model.setSWoOfcCd(sWoOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (wo45ftDryAvgAmt[i] != null)
					model.setWo45ftDryAvgAmt(wo45ftDryAvgAmt[i]);
				if (agmt20ftDryUsdAmt[i] != null)
					model.setAgmt20ftDryUsdAmt(agmt20ftDryUsdAmt[i]);
				if (trspAvg20ftRfUsdAmt[i] != null)
					model.setTrspAvg20ftRfUsdAmt(trspAvg20ftRfUsdAmt[i]);
				if (trspCostDtlModCd[i] != null)
					model.setTrspCostDtlModCd(trspCostDtlModCd[i]);
				if (agmtCurrCd[i] != null)
					model.setAgmtCurrCd(agmtCurrCd[i]);
				if (wo20ftDryAvgAmt[i] != null)
					model.setWo20ftDryAvgAmt(wo20ftDryAvgAmt[i]);
				if (trspSoTpCd[i] != null)
					model.setTrspSoTpCd(trspSoTpCd[i]);
				if (trspAvg40ftDryUsdAmt[i] != null)
					model.setTrspAvg40ftDryUsdAmt(trspAvg40ftDryUsdAmt[i]);
				if (sToNodCd[i] != null)
					model.setSToNodCd(sToNodCd[i]);
				if (sToYrmon[i] != null)
					model.setSToYrmon(sToYrmon[i]);
				if (wo20ftAwkAvgAmt[i] != null)
					model.setWo20ftAwkAvgAmt(wo20ftAwkAvgAmt[i]);
				if (agmt20ftRfUsdAmt[i] != null)
					model.setAgmt20ftRfUsdAmt(agmt20ftRfUsdAmt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (sTrspBndCd[i] != null)
					model.setSTrspBndCd(sTrspBndCd[i]);
				if (trspAvg20ftDryUsdAmt[i] != null)
					model.setTrspAvg20ftDryUsdAmt(trspAvg20ftDryUsdAmt[i]);
				if (sTrspCrrModCd[i] != null)
					model.setSTrspCrrModCd(sTrspCrrModCd[i]);
				if (agmt20ftDryAmt[i] != null)
					model.setAgmt20ftDryAmt(agmt20ftDryAmt[i]);
				if (agmt20ftRfAmt[i] != null)
					model.setAgmt20ftRfAmt(agmt20ftRfAmt[i]);
				if (woRhqCd[i] != null)
					model.setWoRhqCd(woRhqCd[i]);
				if (sRhqOfcCd[i] != null)
					model.setSRhqOfcCd(sRhqOfcCd[i]);
				if (wo40ftAwkAvgAmt[i] != null)
					model.setWo40ftAwkAvgAmt(wo40ftAwkAvgAmt[i]);
				if (wo20ftDgAvgAmt[i] != null)
					model.setWo20ftDgAvgAmt(wo20ftDgAvgAmt[i]);
				if (sDorNodCd[i] != null)
					model.setSDorNodCd(sDorNodCd[i]);
				if (trspAvg40ftRfUsdAmt[i] != null)
					model.setTrspAvg40ftRfUsdAmt(trspAvg40ftRfUsdAmt[i]);
				if (wo20ftRfAvgAmt[i] != null)
					model.setWo20ftRfAvgAmt(wo20ftRfAvgAmt[i]);
				if (woOfcCd[i] != null)
					model.setWoOfcCd(woOfcCd[i]);
				if (agmt40ftRfUsdAmt[i] != null)
					model.setAgmt40ftRfUsdAmt(agmt40ftRfUsdAmt[i]);
				if (sFmYrmon[i] != null)
					model.setSFmYrmon(sFmYrmon[i]);
				if (wo40ftRfAvgAmt[i] != null)
					model.setWo40ftRfAvgAmt(wo40ftRfAvgAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sSoTpCd[i] != null)
					model.setSSoTpCd(sSoTpCd[i]);
				if (agmt40ftDryAmt[i] != null)
					model.setAgmt40ftDryAmt(agmt40ftDryAmt[i]);
				if (agmt40ftDryUsdAmt[i] != null)
					model.setAgmt40ftDryUsdAmt(agmt40ftDryUsdAmt[i]);
				if (so40ftVolKnt[i] != null)
					model.setSo40ftVolKnt(so40ftVolKnt[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (sTrspCostDtlModCd[i] != null)
					model.setSTrspCostDtlModCd(sTrspCostDtlModCd[i]);
				if (sViaNodCd[i] != null)
					model.setSViaNodCd(sViaNodCd[i]);
				if (soBxQty[i] != null)
					model.setSoBxQty(soBxQty[i]);
				if (inlndCostYrmon[i] != null)
					model.setInlndCostYrmon(inlndCostYrmon[i]);
				if (soTeuQty[i] != null)
					model.setSoTeuQty(soTeuQty[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (wo40ftDgAvgAmt[i] != null)
					model.setWo40ftDgAvgAmt(wo40ftDgAvgAmt[i]);
				if (agmt40ftRfAmt[i] != null)
					model.setAgmt40ftRfAmt(agmt40ftRfAmt[i]);
				if (wo40ftDryAvgAmt[i] != null)
					model.setWo40ftDryAvgAmt(wo40ftDryAvgAmt[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (sFmNodCd[i] != null)
					model.setSFmNodCd(sFmNodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTrffCmprsnByTRSAgrmntVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TrffCmprsnByTRSAgrmntVO[]
	 */
	public TrffCmprsnByTRSAgrmntVO[] getTrffCmprsnByTRSAgrmntVOs(){
		TrffCmprsnByTRSAgrmntVO[] vos = (TrffCmprsnByTRSAgrmntVO[])models.toArray(new TrffCmprsnByTRSAgrmntVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woCurrCd = this.woCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.so20ftVolKnt = this.so20ftVolKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sWoOfcCd = this.sWoOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wo45ftDryAvgAmt = this.wo45ftDryAvgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmt20ftDryUsdAmt = this.agmt20ftDryUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAvg20ftRfUsdAmt = this.trspAvg20ftRfUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModCd = this.trspCostDtlModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCurrCd = this.agmtCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wo20ftDryAvgAmt = this.wo20ftDryAvgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoTpCd = this.trspSoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAvg40ftDryUsdAmt = this.trspAvg40ftDryUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sToNodCd = this.sToNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sToYrmon = this.sToYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wo20ftAwkAvgAmt = this.wo20ftAwkAvgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmt20ftRfUsdAmt = this.agmt20ftRfUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrspBndCd = this.sTrspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAvg20ftDryUsdAmt = this.trspAvg20ftDryUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrspCrrModCd = this.sTrspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmt20ftDryAmt = this.agmt20ftDryAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmt20ftRfAmt = this.agmt20ftRfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woRhqCd = this.woRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqOfcCd = this.sRhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wo40ftAwkAvgAmt = this.wo40ftAwkAvgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wo20ftDgAvgAmt = this.wo20ftDgAvgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDorNodCd = this.sDorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAvg40ftRfUsdAmt = this.trspAvg40ftRfUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wo20ftRfAvgAmt = this.wo20ftRfAvgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woOfcCd = this.woOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmt40ftRfUsdAmt = this.agmt40ftRfUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFmYrmon = this.sFmYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wo40ftRfAvgAmt = this.wo40ftRfAvgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSoTpCd = this.sSoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmt40ftDryAmt = this.agmt40ftDryAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmt40ftDryUsdAmt = this.agmt40ftDryUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.so40ftVolKnt = this.so40ftVolKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrspCostDtlModCd = this.sTrspCostDtlModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sViaNodCd = this.sViaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soBxQty = this.soBxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndCostYrmon = this.inlndCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soTeuQty = this.soTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wo40ftDgAvgAmt = this.wo40ftDgAvgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmt40ftRfAmt = this.agmt40ftRfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wo40ftDryAvgAmt = this.wo40ftDryAvgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFmNodCd = this.sFmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
