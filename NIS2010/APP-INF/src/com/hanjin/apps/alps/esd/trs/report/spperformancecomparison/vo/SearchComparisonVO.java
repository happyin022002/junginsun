/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchComparisonVO.java
*@FileTitle : SearchComparisonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.02
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2016.06.02 최종혁 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.vo;

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

public class SearchComparisonVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchComparisonVO> models = new ArrayList<SearchComparisonVO>();
	
	/* Column Info */
	private String trspSpCngRsnNm = null;
	/* Column Info */
	private String woCustNomiTrkrIndCd = null;
	/* Column Info */
	private String woCurrCd = null;
	/* Column Info */
	private String dfltEtcCompAmt = null;
	/* Column Info */
	private String lowUsdVndrWoQty = null;
	/* Column Info */
	private String lowVatCompAmt = null;
	/* Column Info */
	private String lowFuelScgAmt = null;
	/* Column Info */
	private String dfltFuelScgAmt = null;
	/* Column Info */
	private String lowTollFeeAmt = null;
	/* Column Info */
	private String dfltToWgt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String usdLowCustNomiTrkrIndCd = null;
	/* Column Info */
	private String woFuelScgAmt = null;
	/* Column Info */
	private String woTollFeeAmt = null;
	/* Column Info */
	private String usdLowTrspAgmtUpdDt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String dfltTtlUsdCompAmt = null;
	/* Column Info */
	private String usdLowVndrSeq = null;
	/* Column Info */
	private String lowTtlAmt = null;
	/* Column Info */
	private String dfltNegoCompAmt = null;
	/* Column Info */
	private String usdLowTtlUsdAmt = null;
	/* Column Info */
	private String dfltCmdtGrpCd = null;
	/* Column Info */
	private String usdLowFuelCompAmt = null;
	/* Column Info */
	private String dfltVndrNm = null;
	/* Column Info */
	private String lowVndrSeq = null;
	/* Column Info */
	private String lowCmdtGrpCd = null;
	/* Column Info */
	private String lowCurrCd = null;
	/* Column Info */
	private String usdLowTtlUsdCompAmt = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String woTtlUsdAmt = null;
	/* Column Info */
	private String usdLowEtcCompAmt = null;
	/* Column Info */
	private String woOfcCd = null;
	/* Column Info */
	private String woVndrSeq = null;
	/* Column Info */
	private String usdLowBzcAmt = null;
	/* Column Info */
	private String usdLowTollCompAmt = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String woEtcAddAmt = null;
	/* Column Info */
	private String usdLowVatCompAmt = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String lowBzcCompAmt = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String dfltCustNomiTrkrIndCd = null;
	/* Column Info */
	private String usdLowVndrNm = null;
	/* Column Info */
	private String lowBzcAmt = null;
	/* Column Info */
	private String usdLowFuelScgAmt = null;
	/* Column Info */
	private String usdLowBzcCompAmt = null;
	/* Column Info */
	private String lowFuelCompAmt = null;
	/* Column Info */
	private String usdLowTtlCompAmt = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String viaNodCd = null;
	/* Column Info */
	private String dfltUsdVndrWoQty = null;
	/* Column Info */
	private String dfltTollFeeAmt = null;
	/* Column Info */
	private String usdLowTtlAmt = null;
	/* Column Info */
	private String lowEtcCompAmt = null;
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String usdLowCurrCd = null;
	/* Column Info */
	private String dfltTrspAgmtUpdDt = null;
	/* Column Info */
	private String woAgmtNo = null;
	/* Column Info */
	private String dfltTtlCompAmt = null;
	/* Column Info */
	private String dfltTtlUsdAmt = null;
	/* Column Info */
	private String lowTtlUsdCompAmt = null;
	/* Column Info */
	private String trspCostDtlModCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String usdLowScgVatAmt = null;
	/* Column Info */
	private String lowTtlCompAmt = null;
	/* Column Info */
	private String dfltScgVatAmt = null;
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String usdLowToWgt = null;
	/* Column Info */
	private String usdLowCmdtGrpCd = null;
	/* Column Info */
	private String lowTollCompAmt = null;
	/* Column Info */
	private String usdLowNegoCompAmt = null;
	/* Column Info */
	private String lowToWgt = null;
	/* Column Info */
	private String lowAgmtMorCnddtQty = null;
	/* Column Info */
	private String usdLowVndrWoQty = null;
	/* Column Info */
	private String lowNegoCompAmt = null;
	/* Column Info */
	private String dfltBzcAmt = null;
	/* Column Info */
	private String dfltAgmtNo = null;
	/* Column Info */
	private String lowScgVatAmt = null;
	/* Column Info */
	private String lowAgmtNo = null;
	/* Column Info */
	private String lowTtlUsdAmt = null;
	/* Column Info */
	private String dfltCurrCd = null;
	/* Column Info */
	private String usdLowAgmtNo = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dfltVatCompAmt = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String woNegoAmt = null;
	/* Column Info */
	private String dfltTtlAmt = null;
	/* Column Info */
	private String lowTrspAgmtUpdDt = null;
	/* Column Info */
	private String lowCustNomiTrkrIndCd = null;
	/* Column Info */
	private String lowVndrNm = null;
	/* Column Info */
	private String woVndrNm = null;
	/* Column Info */
	private String dfltVndrSeq = null;
	/* Column Info */
	private String woBzcAmt = null;
	/* Column Info */
	private String woScgVatAmt = null;
	/* Column Info */
	private String dfltBzcCompAmt = null;
	/* Column Info */
	private String dfltFuelCompAmt = null;
	/* Column Info */
	private String usdLowTollFeeAmt = null;
	/* Column Info */
	private String woTtlAmt = null;
	/* Column Info */
	private String dfltTollCompAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchComparisonVO() {}

	public SearchComparisonVO(String ibflag, String pagerows, String rhqCd, String woOfcCd, String woNo, String soNo, String eqNo, String trspSpCngRsnNm, String trspCostDtlModCd, String trspCrrModCd, String scNo, String rfaNo, String custNm, String fmNodCd, String viaNodCd, String toNodCd, String dorNodCd, String dfltVndrSeq, String dfltVndrNm, String dfltCustNomiTrkrIndCd, String dfltAgmtNo, String dfltUsdVndrWoQty, String dfltTrspAgmtUpdDt, String dfltToWgt, String dfltCmdtGrpCd, String dfltCurrCd, String dfltBzcAmt, String dfltFuelScgAmt, String dfltScgVatAmt, String dfltTollFeeAmt, String dfltTtlAmt, String dfltTtlUsdAmt, String lowVndrSeq, String lowVndrNm, String lowCustNomiTrkrIndCd, String lowAgmtNo, String lowUsdVndrWoQty, String lowTrspAgmtUpdDt, String lowToWgt, String lowCmdtGrpCd, String lowCurrCd, String lowBzcAmt, String lowFuelScgAmt, String lowScgVatAmt, String lowTollFeeAmt, String lowTtlAmt, String lowTtlUsdAmt, String lowAgmtMorCnddtQty, String usdLowVndrSeq, String usdLowVndrNm, String usdLowCustNomiTrkrIndCd, String usdLowAgmtNo, String usdLowVndrWoQty, String usdLowTrspAgmtUpdDt, String usdLowToWgt, String usdLowCmdtGrpCd, String usdLowCurrCd, String usdLowBzcAmt, String usdLowFuelScgAmt, String usdLowScgVatAmt, String usdLowTollFeeAmt, String usdLowTtlAmt, String usdLowTtlUsdAmt, String woVndrSeq, String woVndrNm, String woCustNomiTrkrIndCd, String woAgmtNo, String woCurrCd, String woBzcAmt, String woNegoAmt, String woFuelScgAmt, String woScgVatAmt, String woTollFeeAmt, String woEtcAddAmt, String woTtlAmt, String woTtlUsdAmt, String dfltBzcCompAmt, String dfltNegoCompAmt, String dfltFuelCompAmt, String dfltVatCompAmt, String dfltTollCompAmt, String dfltEtcCompAmt, String dfltTtlCompAmt, String dfltTtlUsdCompAmt, String lowBzcCompAmt, String lowNegoCompAmt, String lowFuelCompAmt, String lowVatCompAmt, String lowTollCompAmt, String lowEtcCompAmt, String lowTtlCompAmt, String lowTtlUsdCompAmt, String usdLowBzcCompAmt, String usdLowNegoCompAmt, String usdLowFuelCompAmt, String usdLowVatCompAmt, String usdLowTollCompAmt, String usdLowEtcCompAmt, String usdLowTtlCompAmt, String usdLowTtlUsdCompAmt) {
		this.trspSpCngRsnNm = trspSpCngRsnNm;
		this.woCustNomiTrkrIndCd = woCustNomiTrkrIndCd;
		this.woCurrCd = woCurrCd;
		this.dfltEtcCompAmt = dfltEtcCompAmt;
		this.lowUsdVndrWoQty = lowUsdVndrWoQty;
		this.lowVatCompAmt = lowVatCompAmt;
		this.lowFuelScgAmt = lowFuelScgAmt;
		this.dfltFuelScgAmt = dfltFuelScgAmt;
		this.lowTollFeeAmt = lowTollFeeAmt;
		this.dfltToWgt = dfltToWgt;
		this.pagerows = pagerows;
		this.usdLowCustNomiTrkrIndCd = usdLowCustNomiTrkrIndCd;
		this.woFuelScgAmt = woFuelScgAmt;
		this.woTollFeeAmt = woTollFeeAmt;
		this.usdLowTrspAgmtUpdDt = usdLowTrspAgmtUpdDt;
		this.rhqCd = rhqCd;
		this.dfltTtlUsdCompAmt = dfltTtlUsdCompAmt;
		this.usdLowVndrSeq = usdLowVndrSeq;
		this.lowTtlAmt = lowTtlAmt;
		this.dfltNegoCompAmt = dfltNegoCompAmt;
		this.usdLowTtlUsdAmt = usdLowTtlUsdAmt;
		this.dfltCmdtGrpCd = dfltCmdtGrpCd;
		this.usdLowFuelCompAmt = usdLowFuelCompAmt;
		this.dfltVndrNm = dfltVndrNm;
		this.lowVndrSeq = lowVndrSeq;
		this.lowCmdtGrpCd = lowCmdtGrpCd;
		this.lowCurrCd = lowCurrCd;
		this.usdLowTtlUsdCompAmt = usdLowTtlUsdCompAmt;
		this.custNm = custNm;
		this.woTtlUsdAmt = woTtlUsdAmt;
		this.usdLowEtcCompAmt = usdLowEtcCompAmt;
		this.woOfcCd = woOfcCd;
		this.woVndrSeq = woVndrSeq;
		this.usdLowBzcAmt = usdLowBzcAmt;
		this.usdLowTollCompAmt = usdLowTollCompAmt;
		this.dorNodCd = dorNodCd;
		this.woEtcAddAmt = woEtcAddAmt;
		this.usdLowVatCompAmt = usdLowVatCompAmt;
		this.woNo = woNo;
		this.lowBzcCompAmt = lowBzcCompAmt;
		this.trspCrrModCd = trspCrrModCd;
		this.dfltCustNomiTrkrIndCd = dfltCustNomiTrkrIndCd;
		this.usdLowVndrNm = usdLowVndrNm;
		this.lowBzcAmt = lowBzcAmt;
		this.usdLowFuelScgAmt = usdLowFuelScgAmt;
		this.usdLowBzcCompAmt = usdLowBzcCompAmt;
		this.lowFuelCompAmt = lowFuelCompAmt;
		this.usdLowTtlCompAmt = usdLowTtlCompAmt;
		this.fmNodCd = fmNodCd;
		this.viaNodCd = viaNodCd;
		this.dfltUsdVndrWoQty = dfltUsdVndrWoQty;
		this.dfltTollFeeAmt = dfltTollFeeAmt;
		this.usdLowTtlAmt = usdLowTtlAmt;
		this.lowEtcCompAmt = lowEtcCompAmt;
		this.toNodCd = toNodCd;
		this.usdLowCurrCd = usdLowCurrCd;
		this.dfltTrspAgmtUpdDt = dfltTrspAgmtUpdDt;
		this.woAgmtNo = woAgmtNo;
		this.dfltTtlCompAmt = dfltTtlCompAmt;
		this.dfltTtlUsdAmt = dfltTtlUsdAmt;
		this.lowTtlUsdCompAmt = lowTtlUsdCompAmt;
		this.trspCostDtlModCd = trspCostDtlModCd;
		this.scNo = scNo;
		this.usdLowScgVatAmt = usdLowScgVatAmt;
		this.lowTtlCompAmt = lowTtlCompAmt;
		this.dfltScgVatAmt = dfltScgVatAmt;
		this.soNo = soNo;
		this.usdLowToWgt = usdLowToWgt;
		this.usdLowCmdtGrpCd = usdLowCmdtGrpCd;
		this.lowTollCompAmt = lowTollCompAmt;
		this.usdLowNegoCompAmt = usdLowNegoCompAmt;
		this.lowToWgt = lowToWgt;
		this.lowAgmtMorCnddtQty = lowAgmtMorCnddtQty;
		this.usdLowVndrWoQty = usdLowVndrWoQty;
		this.lowNegoCompAmt = lowNegoCompAmt;
		this.dfltBzcAmt = dfltBzcAmt;
		this.dfltAgmtNo = dfltAgmtNo;
		this.lowScgVatAmt = lowScgVatAmt;
		this.lowAgmtNo = lowAgmtNo;
		this.lowTtlUsdAmt = lowTtlUsdAmt;
		this.dfltCurrCd = dfltCurrCd;
		this.usdLowAgmtNo = usdLowAgmtNo;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.dfltVatCompAmt = dfltVatCompAmt;
		this.eqNo = eqNo;
		this.woNegoAmt = woNegoAmt;
		this.dfltTtlAmt = dfltTtlAmt;
		this.lowTrspAgmtUpdDt = lowTrspAgmtUpdDt;
		this.lowCustNomiTrkrIndCd = lowCustNomiTrkrIndCd;
		this.lowVndrNm = lowVndrNm;
		this.woVndrNm = woVndrNm;
		this.dfltVndrSeq = dfltVndrSeq;
		this.woBzcAmt = woBzcAmt;
		this.woScgVatAmt = woScgVatAmt;
		this.dfltBzcCompAmt = dfltBzcCompAmt;
		this.dfltFuelCompAmt = dfltFuelCompAmt;
		this.usdLowTollFeeAmt = usdLowTollFeeAmt;
		this.woTtlAmt = woTtlAmt;
		this.dfltTollCompAmt = dfltTollCompAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trsp_sp_cng_rsn_nm", getTrspSpCngRsnNm());
		this.hashColumns.put("wo_cust_nomi_trkr_ind_cd", getWoCustNomiTrkrIndCd());
		this.hashColumns.put("wo_curr_cd", getWoCurrCd());
		this.hashColumns.put("dflt_etc_comp_amt", getDfltEtcCompAmt());
		this.hashColumns.put("low_usd_vndr_wo_qty", getLowUsdVndrWoQty());
		this.hashColumns.put("low_vat_comp_amt", getLowVatCompAmt());
		this.hashColumns.put("low_fuel_scg_amt", getLowFuelScgAmt());
		this.hashColumns.put("dflt_fuel_scg_amt", getDfltFuelScgAmt());
		this.hashColumns.put("low_toll_fee_amt", getLowTollFeeAmt());
		this.hashColumns.put("dflt_to_wgt", getDfltToWgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("usd_low_cust_nomi_trkr_ind_cd", getUsdLowCustNomiTrkrIndCd());
		this.hashColumns.put("wo_fuel_scg_amt", getWoFuelScgAmt());
		this.hashColumns.put("wo_toll_fee_amt", getWoTollFeeAmt());
		this.hashColumns.put("usd_low_trsp_agmt_upd_dt", getUsdLowTrspAgmtUpdDt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("dflt_ttl_usd_comp_amt", getDfltTtlUsdCompAmt());
		this.hashColumns.put("usd_low_vndr_seq", getUsdLowVndrSeq());
		this.hashColumns.put("low_ttl_amt", getLowTtlAmt());
		this.hashColumns.put("dflt_nego_comp_amt", getDfltNegoCompAmt());
		this.hashColumns.put("usd_low_ttl_usd_amt", getUsdLowTtlUsdAmt());
		this.hashColumns.put("dflt_cmdt_grp_cd", getDfltCmdtGrpCd());
		this.hashColumns.put("usd_low_fuel_comp_amt", getUsdLowFuelCompAmt());
		this.hashColumns.put("dflt_vndr_nm", getDfltVndrNm());
		this.hashColumns.put("low_vndr_seq", getLowVndrSeq());
		this.hashColumns.put("low_cmdt_grp_cd", getLowCmdtGrpCd());
		this.hashColumns.put("low_curr_cd", getLowCurrCd());
		this.hashColumns.put("usd_low_ttl_usd_comp_amt", getUsdLowTtlUsdCompAmt());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("wo_ttl_usd_amt", getWoTtlUsdAmt());
		this.hashColumns.put("usd_low_etc_comp_amt", getUsdLowEtcCompAmt());
		this.hashColumns.put("wo_ofc_cd", getWoOfcCd());
		this.hashColumns.put("wo_vndr_seq", getWoVndrSeq());
		this.hashColumns.put("usd_low_bzc_amt", getUsdLowBzcAmt());
		this.hashColumns.put("usd_low_toll_comp_amt", getUsdLowTollCompAmt());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("wo_etc_add_amt", getWoEtcAddAmt());
		this.hashColumns.put("usd_low_vat_comp_amt", getUsdLowVatCompAmt());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("low_bzc_comp_amt", getLowBzcCompAmt());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("dflt_cust_nomi_trkr_ind_cd", getDfltCustNomiTrkrIndCd());
		this.hashColumns.put("usd_low_vndr_nm", getUsdLowVndrNm());
		this.hashColumns.put("low_bzc_amt", getLowBzcAmt());
		this.hashColumns.put("usd_low_fuel_scg_amt", getUsdLowFuelScgAmt());
		this.hashColumns.put("usd_low_bzc_comp_amt", getUsdLowBzcCompAmt());
		this.hashColumns.put("low_fuel_comp_amt", getLowFuelCompAmt());
		this.hashColumns.put("usd_low_ttl_comp_amt", getUsdLowTtlCompAmt());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("dflt_usd_vndr_wo_qty", getDfltUsdVndrWoQty());
		this.hashColumns.put("dflt_toll_fee_amt", getDfltTollFeeAmt());
		this.hashColumns.put("usd_low_ttl_amt", getUsdLowTtlAmt());
		this.hashColumns.put("low_etc_comp_amt", getLowEtcCompAmt());
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("usd_low_curr_cd", getUsdLowCurrCd());
		this.hashColumns.put("dflt_trsp_agmt_upd_dt", getDfltTrspAgmtUpdDt());
		this.hashColumns.put("wo_agmt_no", getWoAgmtNo());
		this.hashColumns.put("dflt_ttl_comp_amt", getDfltTtlCompAmt());
		this.hashColumns.put("dflt_ttl_usd_amt", getDfltTtlUsdAmt());
		this.hashColumns.put("low_ttl_usd_comp_amt", getLowTtlUsdCompAmt());
		this.hashColumns.put("trsp_cost_dtl_mod_cd", getTrspCostDtlModCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("usd_low_scg_vat_amt", getUsdLowScgVatAmt());
		this.hashColumns.put("low_ttl_comp_amt", getLowTtlCompAmt());
		this.hashColumns.put("dflt_scg_vat_amt", getDfltScgVatAmt());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("usd_low_to_wgt", getUsdLowToWgt());
		this.hashColumns.put("usd_low_cmdt_grp_cd", getUsdLowCmdtGrpCd());
		this.hashColumns.put("low_toll_comp_amt", getLowTollCompAmt());
		this.hashColumns.put("usd_low_nego_comp_amt", getUsdLowNegoCompAmt());
		this.hashColumns.put("low_to_wgt", getLowToWgt());
		this.hashColumns.put("low_agmt_mor_cnddt_qty", getLowAgmtMorCnddtQty());
		this.hashColumns.put("usd_low_vndr_wo_qty", getUsdLowVndrWoQty());
		this.hashColumns.put("low_nego_comp_amt", getLowNegoCompAmt());
		this.hashColumns.put("dflt_bzc_amt", getDfltBzcAmt());
		this.hashColumns.put("dflt_agmt_no", getDfltAgmtNo());
		this.hashColumns.put("low_scg_vat_amt", getLowScgVatAmt());
		this.hashColumns.put("low_agmt_no", getLowAgmtNo());
		this.hashColumns.put("low_ttl_usd_amt", getLowTtlUsdAmt());
		this.hashColumns.put("dflt_curr_cd", getDfltCurrCd());
		this.hashColumns.put("usd_low_agmt_no", getUsdLowAgmtNo());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dflt_vat_comp_amt", getDfltVatCompAmt());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("wo_nego_amt", getWoNegoAmt());
		this.hashColumns.put("dflt_ttl_amt", getDfltTtlAmt());
		this.hashColumns.put("low_trsp_agmt_upd_dt", getLowTrspAgmtUpdDt());
		this.hashColumns.put("low_cust_nomi_trkr_ind_cd", getLowCustNomiTrkrIndCd());
		this.hashColumns.put("low_vndr_nm", getLowVndrNm());
		this.hashColumns.put("wo_vndr_nm", getWoVndrNm());
		this.hashColumns.put("dflt_vndr_seq", getDfltVndrSeq());
		this.hashColumns.put("wo_bzc_amt", getWoBzcAmt());
		this.hashColumns.put("wo_scg_vat_amt", getWoScgVatAmt());
		this.hashColumns.put("dflt_bzc_comp_amt", getDfltBzcCompAmt());
		this.hashColumns.put("dflt_fuel_comp_amt", getDfltFuelCompAmt());
		this.hashColumns.put("usd_low_toll_fee_amt", getUsdLowTollFeeAmt());
		this.hashColumns.put("wo_ttl_amt", getWoTtlAmt());
		this.hashColumns.put("dflt_toll_comp_amt", getDfltTollCompAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trsp_sp_cng_rsn_nm", "trspSpCngRsnNm");
		this.hashFields.put("wo_cust_nomi_trkr_ind_cd", "woCustNomiTrkrIndCd");
		this.hashFields.put("wo_curr_cd", "woCurrCd");
		this.hashFields.put("dflt_etc_comp_amt", "dfltEtcCompAmt");
		this.hashFields.put("low_usd_vndr_wo_qty", "lowUsdVndrWoQty");
		this.hashFields.put("low_vat_comp_amt", "lowVatCompAmt");
		this.hashFields.put("low_fuel_scg_amt", "lowFuelScgAmt");
		this.hashFields.put("dflt_fuel_scg_amt", "dfltFuelScgAmt");
		this.hashFields.put("low_toll_fee_amt", "lowTollFeeAmt");
		this.hashFields.put("dflt_to_wgt", "dfltToWgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("usd_low_cust_nomi_trkr_ind_cd", "usdLowCustNomiTrkrIndCd");
		this.hashFields.put("wo_fuel_scg_amt", "woFuelScgAmt");
		this.hashFields.put("wo_toll_fee_amt", "woTollFeeAmt");
		this.hashFields.put("usd_low_trsp_agmt_upd_dt", "usdLowTrspAgmtUpdDt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("dflt_ttl_usd_comp_amt", "dfltTtlUsdCompAmt");
		this.hashFields.put("usd_low_vndr_seq", "usdLowVndrSeq");
		this.hashFields.put("low_ttl_amt", "lowTtlAmt");
		this.hashFields.put("dflt_nego_comp_amt", "dfltNegoCompAmt");
		this.hashFields.put("usd_low_ttl_usd_amt", "usdLowTtlUsdAmt");
		this.hashFields.put("dflt_cmdt_grp_cd", "dfltCmdtGrpCd");
		this.hashFields.put("usd_low_fuel_comp_amt", "usdLowFuelCompAmt");
		this.hashFields.put("dflt_vndr_nm", "dfltVndrNm");
		this.hashFields.put("low_vndr_seq", "lowVndrSeq");
		this.hashFields.put("low_cmdt_grp_cd", "lowCmdtGrpCd");
		this.hashFields.put("low_curr_cd", "lowCurrCd");
		this.hashFields.put("usd_low_ttl_usd_comp_amt", "usdLowTtlUsdCompAmt");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("wo_ttl_usd_amt", "woTtlUsdAmt");
		this.hashFields.put("usd_low_etc_comp_amt", "usdLowEtcCompAmt");
		this.hashFields.put("wo_ofc_cd", "woOfcCd");
		this.hashFields.put("wo_vndr_seq", "woVndrSeq");
		this.hashFields.put("usd_low_bzc_amt", "usdLowBzcAmt");
		this.hashFields.put("usd_low_toll_comp_amt", "usdLowTollCompAmt");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("wo_etc_add_amt", "woEtcAddAmt");
		this.hashFields.put("usd_low_vat_comp_amt", "usdLowVatCompAmt");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("low_bzc_comp_amt", "lowBzcCompAmt");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("dflt_cust_nomi_trkr_ind_cd", "dfltCustNomiTrkrIndCd");
		this.hashFields.put("usd_low_vndr_nm", "usdLowVndrNm");
		this.hashFields.put("low_bzc_amt", "lowBzcAmt");
		this.hashFields.put("usd_low_fuel_scg_amt", "usdLowFuelScgAmt");
		this.hashFields.put("usd_low_bzc_comp_amt", "usdLowBzcCompAmt");
		this.hashFields.put("low_fuel_comp_amt", "lowFuelCompAmt");
		this.hashFields.put("usd_low_ttl_comp_amt", "usdLowTtlCompAmt");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("dflt_usd_vndr_wo_qty", "dfltUsdVndrWoQty");
		this.hashFields.put("dflt_toll_fee_amt", "dfltTollFeeAmt");
		this.hashFields.put("usd_low_ttl_amt", "usdLowTtlAmt");
		this.hashFields.put("low_etc_comp_amt", "lowEtcCompAmt");
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("usd_low_curr_cd", "usdLowCurrCd");
		this.hashFields.put("dflt_trsp_agmt_upd_dt", "dfltTrspAgmtUpdDt");
		this.hashFields.put("wo_agmt_no", "woAgmtNo");
		this.hashFields.put("dflt_ttl_comp_amt", "dfltTtlCompAmt");
		this.hashFields.put("dflt_ttl_usd_amt", "dfltTtlUsdAmt");
		this.hashFields.put("low_ttl_usd_comp_amt", "lowTtlUsdCompAmt");
		this.hashFields.put("trsp_cost_dtl_mod_cd", "trspCostDtlModCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("usd_low_scg_vat_amt", "usdLowScgVatAmt");
		this.hashFields.put("low_ttl_comp_amt", "lowTtlCompAmt");
		this.hashFields.put("dflt_scg_vat_amt", "dfltScgVatAmt");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("usd_low_to_wgt", "usdLowToWgt");
		this.hashFields.put("usd_low_cmdt_grp_cd", "usdLowCmdtGrpCd");
		this.hashFields.put("low_toll_comp_amt", "lowTollCompAmt");
		this.hashFields.put("usd_low_nego_comp_amt", "usdLowNegoCompAmt");
		this.hashFields.put("low_to_wgt", "lowToWgt");
		this.hashFields.put("low_agmt_mor_cnddt_qty", "lowAgmtMorCnddtQty");
		this.hashFields.put("usd_low_vndr_wo_qty", "usdLowVndrWoQty");
		this.hashFields.put("low_nego_comp_amt", "lowNegoCompAmt");
		this.hashFields.put("dflt_bzc_amt", "dfltBzcAmt");
		this.hashFields.put("dflt_agmt_no", "dfltAgmtNo");
		this.hashFields.put("low_scg_vat_amt", "lowScgVatAmt");
		this.hashFields.put("low_agmt_no", "lowAgmtNo");
		this.hashFields.put("low_ttl_usd_amt", "lowTtlUsdAmt");
		this.hashFields.put("dflt_curr_cd", "dfltCurrCd");
		this.hashFields.put("usd_low_agmt_no", "usdLowAgmtNo");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dflt_vat_comp_amt", "dfltVatCompAmt");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("wo_nego_amt", "woNegoAmt");
		this.hashFields.put("dflt_ttl_amt", "dfltTtlAmt");
		this.hashFields.put("low_trsp_agmt_upd_dt", "lowTrspAgmtUpdDt");
		this.hashFields.put("low_cust_nomi_trkr_ind_cd", "lowCustNomiTrkrIndCd");
		this.hashFields.put("low_vndr_nm", "lowVndrNm");
		this.hashFields.put("wo_vndr_nm", "woVndrNm");
		this.hashFields.put("dflt_vndr_seq", "dfltVndrSeq");
		this.hashFields.put("wo_bzc_amt", "woBzcAmt");
		this.hashFields.put("wo_scg_vat_amt", "woScgVatAmt");
		this.hashFields.put("dflt_bzc_comp_amt", "dfltBzcCompAmt");
		this.hashFields.put("dflt_fuel_comp_amt", "dfltFuelCompAmt");
		this.hashFields.put("usd_low_toll_fee_amt", "usdLowTollFeeAmt");
		this.hashFields.put("wo_ttl_amt", "woTtlAmt");
		this.hashFields.put("dflt_toll_comp_amt", "dfltTollCompAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return trspSpCngRsnNm
	 */
	public String getTrspSpCngRsnNm() {
		return this.trspSpCngRsnNm;
	}
	
	/**
	 * Column Info
	 * @return woCustNomiTrkrIndCd
	 */
	public String getWoCustNomiTrkrIndCd() {
		return this.woCustNomiTrkrIndCd;
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
	 * @return dfltEtcCompAmt
	 */
	public String getDfltEtcCompAmt() {
		return this.dfltEtcCompAmt;
	}
	
	/**
	 * Column Info
	 * @return lowUsdVndrWoQty
	 */
	public String getLowUsdVndrWoQty() {
		return this.lowUsdVndrWoQty;
	}
	
	/**
	 * Column Info
	 * @return lowVatCompAmt
	 */
	public String getLowVatCompAmt() {
		return this.lowVatCompAmt;
	}
	
	/**
	 * Column Info
	 * @return lowFuelScgAmt
	 */
	public String getLowFuelScgAmt() {
		return this.lowFuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @return dfltFuelScgAmt
	 */
	public String getDfltFuelScgAmt() {
		return this.dfltFuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @return lowTollFeeAmt
	 */
	public String getLowTollFeeAmt() {
		return this.lowTollFeeAmt;
	}
	
	/**
	 * Column Info
	 * @return dfltToWgt
	 */
	public String getDfltToWgt() {
		return this.dfltToWgt;
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
	 * @return usdLowCustNomiTrkrIndCd
	 */
	public String getUsdLowCustNomiTrkrIndCd() {
		return this.usdLowCustNomiTrkrIndCd;
	}
	
	/**
	 * Column Info
	 * @return woFuelScgAmt
	 */
	public String getWoFuelScgAmt() {
		return this.woFuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @return woTollFeeAmt
	 */
	public String getWoTollFeeAmt() {
		return this.woTollFeeAmt;
	}
	
	/**
	 * Column Info
	 * @return usdLowTrspAgmtUpdDt
	 */
	public String getUsdLowTrspAgmtUpdDt() {
		return this.usdLowTrspAgmtUpdDt;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return dfltTtlUsdCompAmt
	 */
	public String getDfltTtlUsdCompAmt() {
		return this.dfltTtlUsdCompAmt;
	}
	
	/**
	 * Column Info
	 * @return usdLowVndrSeq
	 */
	public String getUsdLowVndrSeq() {
		return this.usdLowVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return lowTtlAmt
	 */
	public String getLowTtlAmt() {
		return this.lowTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return dfltNegoCompAmt
	 */
	public String getDfltNegoCompAmt() {
		return this.dfltNegoCompAmt;
	}
	
	/**
	 * Column Info
	 * @return usdLowTtlUsdAmt
	 */
	public String getUsdLowTtlUsdAmt() {
		return this.usdLowTtlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return dfltCmdtGrpCd
	 */
	public String getDfltCmdtGrpCd() {
		return this.dfltCmdtGrpCd;
	}
	
	/**
	 * Column Info
	 * @return usdLowFuelCompAmt
	 */
	public String getUsdLowFuelCompAmt() {
		return this.usdLowFuelCompAmt;
	}
	
	/**
	 * Column Info
	 * @return dfltVndrNm
	 */
	public String getDfltVndrNm() {
		return this.dfltVndrNm;
	}
	
	/**
	 * Column Info
	 * @return lowVndrSeq
	 */
	public String getLowVndrSeq() {
		return this.lowVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return lowCmdtGrpCd
	 */
	public String getLowCmdtGrpCd() {
		return this.lowCmdtGrpCd;
	}
	
	/**
	 * Column Info
	 * @return lowCurrCd
	 */
	public String getLowCurrCd() {
		return this.lowCurrCd;
	}
	
	/**
	 * Column Info
	 * @return usdLowTtlUsdCompAmt
	 */
	public String getUsdLowTtlUsdCompAmt() {
		return this.usdLowTtlUsdCompAmt;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return woTtlUsdAmt
	 */
	public String getWoTtlUsdAmt() {
		return this.woTtlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return usdLowEtcCompAmt
	 */
	public String getUsdLowEtcCompAmt() {
		return this.usdLowEtcCompAmt;
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
	 * @return woVndrSeq
	 */
	public String getWoVndrSeq() {
		return this.woVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return usdLowBzcAmt
	 */
	public String getUsdLowBzcAmt() {
		return this.usdLowBzcAmt;
	}
	
	/**
	 * Column Info
	 * @return usdLowTollCompAmt
	 */
	public String getUsdLowTollCompAmt() {
		return this.usdLowTollCompAmt;
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
	 * @return woEtcAddAmt
	 */
	public String getWoEtcAddAmt() {
		return this.woEtcAddAmt;
	}
	
	/**
	 * Column Info
	 * @return usdLowVatCompAmt
	 */
	public String getUsdLowVatCompAmt() {
		return this.usdLowVatCompAmt;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return lowBzcCompAmt
	 */
	public String getLowBzcCompAmt() {
		return this.lowBzcCompAmt;
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
	 * @return dfltCustNomiTrkrIndCd
	 */
	public String getDfltCustNomiTrkrIndCd() {
		return this.dfltCustNomiTrkrIndCd;
	}
	
	/**
	 * Column Info
	 * @return usdLowVndrNm
	 */
	public String getUsdLowVndrNm() {
		return this.usdLowVndrNm;
	}
	
	/**
	 * Column Info
	 * @return lowBzcAmt
	 */
	public String getLowBzcAmt() {
		return this.lowBzcAmt;
	}
	
	/**
	 * Column Info
	 * @return usdLowFuelScgAmt
	 */
	public String getUsdLowFuelScgAmt() {
		return this.usdLowFuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @return usdLowBzcCompAmt
	 */
	public String getUsdLowBzcCompAmt() {
		return this.usdLowBzcCompAmt;
	}
	
	/**
	 * Column Info
	 * @return lowFuelCompAmt
	 */
	public String getLowFuelCompAmt() {
		return this.lowFuelCompAmt;
	}
	
	/**
	 * Column Info
	 * @return usdLowTtlCompAmt
	 */
	public String getUsdLowTtlCompAmt() {
		return this.usdLowTtlCompAmt;
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
	 * @return viaNodCd
	 */
	public String getViaNodCd() {
		return this.viaNodCd;
	}
	
	/**
	 * Column Info
	 * @return dfltUsdVndrWoQty
	 */
	public String getDfltUsdVndrWoQty() {
		return this.dfltUsdVndrWoQty;
	}
	
	/**
	 * Column Info
	 * @return dfltTollFeeAmt
	 */
	public String getDfltTollFeeAmt() {
		return this.dfltTollFeeAmt;
	}
	
	/**
	 * Column Info
	 * @return usdLowTtlAmt
	 */
	public String getUsdLowTtlAmt() {
		return this.usdLowTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return lowEtcCompAmt
	 */
	public String getLowEtcCompAmt() {
		return this.lowEtcCompAmt;
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
	 * @return usdLowCurrCd
	 */
	public String getUsdLowCurrCd() {
		return this.usdLowCurrCd;
	}
	
	/**
	 * Column Info
	 * @return dfltTrspAgmtUpdDt
	 */
	public String getDfltTrspAgmtUpdDt() {
		return this.dfltTrspAgmtUpdDt;
	}
	
	/**
	 * Column Info
	 * @return woAgmtNo
	 */
	public String getWoAgmtNo() {
		return this.woAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return dfltTtlCompAmt
	 */
	public String getDfltTtlCompAmt() {
		return this.dfltTtlCompAmt;
	}
	
	/**
	 * Column Info
	 * @return dfltTtlUsdAmt
	 */
	public String getDfltTtlUsdAmt() {
		return this.dfltTtlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return lowTtlUsdCompAmt
	 */
	public String getLowTtlUsdCompAmt() {
		return this.lowTtlUsdCompAmt;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return usdLowScgVatAmt
	 */
	public String getUsdLowScgVatAmt() {
		return this.usdLowScgVatAmt;
	}
	
	/**
	 * Column Info
	 * @return lowTtlCompAmt
	 */
	public String getLowTtlCompAmt() {
		return this.lowTtlCompAmt;
	}
	
	/**
	 * Column Info
	 * @return dfltScgVatAmt
	 */
	public String getDfltScgVatAmt() {
		return this.dfltScgVatAmt;
	}
	
	/**
	 * Column Info
	 * @return soNo
	 */
	public String getSoNo() {
		return this.soNo;
	}
	
	/**
	 * Column Info
	 * @return usdLowToWgt
	 */
	public String getUsdLowToWgt() {
		return this.usdLowToWgt;
	}
	
	/**
	 * Column Info
	 * @return usdLowCmdtGrpCd
	 */
	public String getUsdLowCmdtGrpCd() {
		return this.usdLowCmdtGrpCd;
	}
	
	/**
	 * Column Info
	 * @return lowTollCompAmt
	 */
	public String getLowTollCompAmt() {
		return this.lowTollCompAmt;
	}
	
	/**
	 * Column Info
	 * @return usdLowNegoCompAmt
	 */
	public String getUsdLowNegoCompAmt() {
		return this.usdLowNegoCompAmt;
	}
	
	/**
	 * Column Info
	 * @return lowToWgt
	 */
	public String getLowToWgt() {
		return this.lowToWgt;
	}
	
	/**
	 * Column Info
	 * @return lowAgmtMorCnddtQty
	 */
	public String getLowAgmtMorCnddtQty() {
		return this.lowAgmtMorCnddtQty;
	}
	
	/**
	 * Column Info
	 * @return usdLowVndrWoQty
	 */
	public String getUsdLowVndrWoQty() {
		return this.usdLowVndrWoQty;
	}
	
	/**
	 * Column Info
	 * @return lowNegoCompAmt
	 */
	public String getLowNegoCompAmt() {
		return this.lowNegoCompAmt;
	}
	
	/**
	 * Column Info
	 * @return dfltBzcAmt
	 */
	public String getDfltBzcAmt() {
		return this.dfltBzcAmt;
	}
	
	/**
	 * Column Info
	 * @return dfltAgmtNo
	 */
	public String getDfltAgmtNo() {
		return this.dfltAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return lowScgVatAmt
	 */
	public String getLowScgVatAmt() {
		return this.lowScgVatAmt;
	}
	
	/**
	 * Column Info
	 * @return lowAgmtNo
	 */
	public String getLowAgmtNo() {
		return this.lowAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return lowTtlUsdAmt
	 */
	public String getLowTtlUsdAmt() {
		return this.lowTtlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return dfltCurrCd
	 */
	public String getDfltCurrCd() {
		return this.dfltCurrCd;
	}
	
	/**
	 * Column Info
	 * @return usdLowAgmtNo
	 */
	public String getUsdLowAgmtNo() {
		return this.usdLowAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return dfltVatCompAmt
	 */
	public String getDfltVatCompAmt() {
		return this.dfltVatCompAmt;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return woNegoAmt
	 */
	public String getWoNegoAmt() {
		return this.woNegoAmt;
	}
	
	/**
	 * Column Info
	 * @return dfltTtlAmt
	 */
	public String getDfltTtlAmt() {
		return this.dfltTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return lowTrspAgmtUpdDt
	 */
	public String getLowTrspAgmtUpdDt() {
		return this.lowTrspAgmtUpdDt;
	}
	
	/**
	 * Column Info
	 * @return lowCustNomiTrkrIndCd
	 */
	public String getLowCustNomiTrkrIndCd() {
		return this.lowCustNomiTrkrIndCd;
	}
	
	/**
	 * Column Info
	 * @return lowVndrNm
	 */
	public String getLowVndrNm() {
		return this.lowVndrNm;
	}
	
	/**
	 * Column Info
	 * @return woVndrNm
	 */
	public String getWoVndrNm() {
		return this.woVndrNm;
	}
	
	/**
	 * Column Info
	 * @return dfltVndrSeq
	 */
	public String getDfltVndrSeq() {
		return this.dfltVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return woBzcAmt
	 */
	public String getWoBzcAmt() {
		return this.woBzcAmt;
	}
	
	/**
	 * Column Info
	 * @return woScgVatAmt
	 */
	public String getWoScgVatAmt() {
		return this.woScgVatAmt;
	}
	
	/**
	 * Column Info
	 * @return dfltBzcCompAmt
	 */
	public String getDfltBzcCompAmt() {
		return this.dfltBzcCompAmt;
	}
	
	/**
	 * Column Info
	 * @return dfltFuelCompAmt
	 */
	public String getDfltFuelCompAmt() {
		return this.dfltFuelCompAmt;
	}
	
	/**
	 * Column Info
	 * @return usdLowTollFeeAmt
	 */
	public String getUsdLowTollFeeAmt() {
		return this.usdLowTollFeeAmt;
	}
	
	/**
	 * Column Info
	 * @return woTtlAmt
	 */
	public String getWoTtlAmt() {
		return this.woTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return dfltTollCompAmt
	 */
	public String getDfltTollCompAmt() {
		return this.dfltTollCompAmt;
	}
	

	/**
	 * Column Info
	 * @param trspSpCngRsnNm
	 */
	public void setTrspSpCngRsnNm(String trspSpCngRsnNm) {
		this.trspSpCngRsnNm = trspSpCngRsnNm;
	}
	
	/**
	 * Column Info
	 * @param woCustNomiTrkrIndCd
	 */
	public void setWoCustNomiTrkrIndCd(String woCustNomiTrkrIndCd) {
		this.woCustNomiTrkrIndCd = woCustNomiTrkrIndCd;
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
	 * @param dfltEtcCompAmt
	 */
	public void setDfltEtcCompAmt(String dfltEtcCompAmt) {
		this.dfltEtcCompAmt = dfltEtcCompAmt;
	}
	
	/**
	 * Column Info
	 * @param lowUsdVndrWoQty
	 */
	public void setLowUsdVndrWoQty(String lowUsdVndrWoQty) {
		this.lowUsdVndrWoQty = lowUsdVndrWoQty;
	}
	
	/**
	 * Column Info
	 * @param lowVatCompAmt
	 */
	public void setLowVatCompAmt(String lowVatCompAmt) {
		this.lowVatCompAmt = lowVatCompAmt;
	}
	
	/**
	 * Column Info
	 * @param lowFuelScgAmt
	 */
	public void setLowFuelScgAmt(String lowFuelScgAmt) {
		this.lowFuelScgAmt = lowFuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @param dfltFuelScgAmt
	 */
	public void setDfltFuelScgAmt(String dfltFuelScgAmt) {
		this.dfltFuelScgAmt = dfltFuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @param lowTollFeeAmt
	 */
	public void setLowTollFeeAmt(String lowTollFeeAmt) {
		this.lowTollFeeAmt = lowTollFeeAmt;
	}
	
	/**
	 * Column Info
	 * @param dfltToWgt
	 */
	public void setDfltToWgt(String dfltToWgt) {
		this.dfltToWgt = dfltToWgt;
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
	 * @param usdLowCustNomiTrkrIndCd
	 */
	public void setUsdLowCustNomiTrkrIndCd(String usdLowCustNomiTrkrIndCd) {
		this.usdLowCustNomiTrkrIndCd = usdLowCustNomiTrkrIndCd;
	}
	
	/**
	 * Column Info
	 * @param woFuelScgAmt
	 */
	public void setWoFuelScgAmt(String woFuelScgAmt) {
		this.woFuelScgAmt = woFuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @param woTollFeeAmt
	 */
	public void setWoTollFeeAmt(String woTollFeeAmt) {
		this.woTollFeeAmt = woTollFeeAmt;
	}
	
	/**
	 * Column Info
	 * @param usdLowTrspAgmtUpdDt
	 */
	public void setUsdLowTrspAgmtUpdDt(String usdLowTrspAgmtUpdDt) {
		this.usdLowTrspAgmtUpdDt = usdLowTrspAgmtUpdDt;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param dfltTtlUsdCompAmt
	 */
	public void setDfltTtlUsdCompAmt(String dfltTtlUsdCompAmt) {
		this.dfltTtlUsdCompAmt = dfltTtlUsdCompAmt;
	}
	
	/**
	 * Column Info
	 * @param usdLowVndrSeq
	 */
	public void setUsdLowVndrSeq(String usdLowVndrSeq) {
		this.usdLowVndrSeq = usdLowVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param lowTtlAmt
	 */
	public void setLowTtlAmt(String lowTtlAmt) {
		this.lowTtlAmt = lowTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param dfltNegoCompAmt
	 */
	public void setDfltNegoCompAmt(String dfltNegoCompAmt) {
		this.dfltNegoCompAmt = dfltNegoCompAmt;
	}
	
	/**
	 * Column Info
	 * @param usdLowTtlUsdAmt
	 */
	public void setUsdLowTtlUsdAmt(String usdLowTtlUsdAmt) {
		this.usdLowTtlUsdAmt = usdLowTtlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param dfltCmdtGrpCd
	 */
	public void setDfltCmdtGrpCd(String dfltCmdtGrpCd) {
		this.dfltCmdtGrpCd = dfltCmdtGrpCd;
	}
	
	/**
	 * Column Info
	 * @param usdLowFuelCompAmt
	 */
	public void setUsdLowFuelCompAmt(String usdLowFuelCompAmt) {
		this.usdLowFuelCompAmt = usdLowFuelCompAmt;
	}
	
	/**
	 * Column Info
	 * @param dfltVndrNm
	 */
	public void setDfltVndrNm(String dfltVndrNm) {
		this.dfltVndrNm = dfltVndrNm;
	}
	
	/**
	 * Column Info
	 * @param lowVndrSeq
	 */
	public void setLowVndrSeq(String lowVndrSeq) {
		this.lowVndrSeq = lowVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param lowCmdtGrpCd
	 */
	public void setLowCmdtGrpCd(String lowCmdtGrpCd) {
		this.lowCmdtGrpCd = lowCmdtGrpCd;
	}
	
	/**
	 * Column Info
	 * @param lowCurrCd
	 */
	public void setLowCurrCd(String lowCurrCd) {
		this.lowCurrCd = lowCurrCd;
	}
	
	/**
	 * Column Info
	 * @param usdLowTtlUsdCompAmt
	 */
	public void setUsdLowTtlUsdCompAmt(String usdLowTtlUsdCompAmt) {
		this.usdLowTtlUsdCompAmt = usdLowTtlUsdCompAmt;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param woTtlUsdAmt
	 */
	public void setWoTtlUsdAmt(String woTtlUsdAmt) {
		this.woTtlUsdAmt = woTtlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param usdLowEtcCompAmt
	 */
	public void setUsdLowEtcCompAmt(String usdLowEtcCompAmt) {
		this.usdLowEtcCompAmt = usdLowEtcCompAmt;
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
	 * @param woVndrSeq
	 */
	public void setWoVndrSeq(String woVndrSeq) {
		this.woVndrSeq = woVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param usdLowBzcAmt
	 */
	public void setUsdLowBzcAmt(String usdLowBzcAmt) {
		this.usdLowBzcAmt = usdLowBzcAmt;
	}
	
	/**
	 * Column Info
	 * @param usdLowTollCompAmt
	 */
	public void setUsdLowTollCompAmt(String usdLowTollCompAmt) {
		this.usdLowTollCompAmt = usdLowTollCompAmt;
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
	 * @param woEtcAddAmt
	 */
	public void setWoEtcAddAmt(String woEtcAddAmt) {
		this.woEtcAddAmt = woEtcAddAmt;
	}
	
	/**
	 * Column Info
	 * @param usdLowVatCompAmt
	 */
	public void setUsdLowVatCompAmt(String usdLowVatCompAmt) {
		this.usdLowVatCompAmt = usdLowVatCompAmt;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param lowBzcCompAmt
	 */
	public void setLowBzcCompAmt(String lowBzcCompAmt) {
		this.lowBzcCompAmt = lowBzcCompAmt;
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
	 * @param dfltCustNomiTrkrIndCd
	 */
	public void setDfltCustNomiTrkrIndCd(String dfltCustNomiTrkrIndCd) {
		this.dfltCustNomiTrkrIndCd = dfltCustNomiTrkrIndCd;
	}
	
	/**
	 * Column Info
	 * @param usdLowVndrNm
	 */
	public void setUsdLowVndrNm(String usdLowVndrNm) {
		this.usdLowVndrNm = usdLowVndrNm;
	}
	
	/**
	 * Column Info
	 * @param lowBzcAmt
	 */
	public void setLowBzcAmt(String lowBzcAmt) {
		this.lowBzcAmt = lowBzcAmt;
	}
	
	/**
	 * Column Info
	 * @param usdLowFuelScgAmt
	 */
	public void setUsdLowFuelScgAmt(String usdLowFuelScgAmt) {
		this.usdLowFuelScgAmt = usdLowFuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @param usdLowBzcCompAmt
	 */
	public void setUsdLowBzcCompAmt(String usdLowBzcCompAmt) {
		this.usdLowBzcCompAmt = usdLowBzcCompAmt;
	}
	
	/**
	 * Column Info
	 * @param lowFuelCompAmt
	 */
	public void setLowFuelCompAmt(String lowFuelCompAmt) {
		this.lowFuelCompAmt = lowFuelCompAmt;
	}
	
	/**
	 * Column Info
	 * @param usdLowTtlCompAmt
	 */
	public void setUsdLowTtlCompAmt(String usdLowTtlCompAmt) {
		this.usdLowTtlCompAmt = usdLowTtlCompAmt;
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
	 * @param viaNodCd
	 */
	public void setViaNodCd(String viaNodCd) {
		this.viaNodCd = viaNodCd;
	}
	
	/**
	 * Column Info
	 * @param dfltUsdVndrWoQty
	 */
	public void setDfltUsdVndrWoQty(String dfltUsdVndrWoQty) {
		this.dfltUsdVndrWoQty = dfltUsdVndrWoQty;
	}
	
	/**
	 * Column Info
	 * @param dfltTollFeeAmt
	 */
	public void setDfltTollFeeAmt(String dfltTollFeeAmt) {
		this.dfltTollFeeAmt = dfltTollFeeAmt;
	}
	
	/**
	 * Column Info
	 * @param usdLowTtlAmt
	 */
	public void setUsdLowTtlAmt(String usdLowTtlAmt) {
		this.usdLowTtlAmt = usdLowTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param lowEtcCompAmt
	 */
	public void setLowEtcCompAmt(String lowEtcCompAmt) {
		this.lowEtcCompAmt = lowEtcCompAmt;
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
	 * @param usdLowCurrCd
	 */
	public void setUsdLowCurrCd(String usdLowCurrCd) {
		this.usdLowCurrCd = usdLowCurrCd;
	}
	
	/**
	 * Column Info
	 * @param dfltTrspAgmtUpdDt
	 */
	public void setDfltTrspAgmtUpdDt(String dfltTrspAgmtUpdDt) {
		this.dfltTrspAgmtUpdDt = dfltTrspAgmtUpdDt;
	}
	
	/**
	 * Column Info
	 * @param woAgmtNo
	 */
	public void setWoAgmtNo(String woAgmtNo) {
		this.woAgmtNo = woAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param dfltTtlCompAmt
	 */
	public void setDfltTtlCompAmt(String dfltTtlCompAmt) {
		this.dfltTtlCompAmt = dfltTtlCompAmt;
	}
	
	/**
	 * Column Info
	 * @param dfltTtlUsdAmt
	 */
	public void setDfltTtlUsdAmt(String dfltTtlUsdAmt) {
		this.dfltTtlUsdAmt = dfltTtlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param lowTtlUsdCompAmt
	 */
	public void setLowTtlUsdCompAmt(String lowTtlUsdCompAmt) {
		this.lowTtlUsdCompAmt = lowTtlUsdCompAmt;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param usdLowScgVatAmt
	 */
	public void setUsdLowScgVatAmt(String usdLowScgVatAmt) {
		this.usdLowScgVatAmt = usdLowScgVatAmt;
	}
	
	/**
	 * Column Info
	 * @param lowTtlCompAmt
	 */
	public void setLowTtlCompAmt(String lowTtlCompAmt) {
		this.lowTtlCompAmt = lowTtlCompAmt;
	}
	
	/**
	 * Column Info
	 * @param dfltScgVatAmt
	 */
	public void setDfltScgVatAmt(String dfltScgVatAmt) {
		this.dfltScgVatAmt = dfltScgVatAmt;
	}
	
	/**
	 * Column Info
	 * @param soNo
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}
	
	/**
	 * Column Info
	 * @param usdLowToWgt
	 */
	public void setUsdLowToWgt(String usdLowToWgt) {
		this.usdLowToWgt = usdLowToWgt;
	}
	
	/**
	 * Column Info
	 * @param usdLowCmdtGrpCd
	 */
	public void setUsdLowCmdtGrpCd(String usdLowCmdtGrpCd) {
		this.usdLowCmdtGrpCd = usdLowCmdtGrpCd;
	}
	
	/**
	 * Column Info
	 * @param lowTollCompAmt
	 */
	public void setLowTollCompAmt(String lowTollCompAmt) {
		this.lowTollCompAmt = lowTollCompAmt;
	}
	
	/**
	 * Column Info
	 * @param usdLowNegoCompAmt
	 */
	public void setUsdLowNegoCompAmt(String usdLowNegoCompAmt) {
		this.usdLowNegoCompAmt = usdLowNegoCompAmt;
	}
	
	/**
	 * Column Info
	 * @param lowToWgt
	 */
	public void setLowToWgt(String lowToWgt) {
		this.lowToWgt = lowToWgt;
	}
	
	/**
	 * Column Info
	 * @param lowAgmtMorCnddtQty
	 */
	public void setLowAgmtMorCnddtQty(String lowAgmtMorCnddtQty) {
		this.lowAgmtMorCnddtQty = lowAgmtMorCnddtQty;
	}
	
	/**
	 * Column Info
	 * @param usdLowVndrWoQty
	 */
	public void setUsdLowVndrWoQty(String usdLowVndrWoQty) {
		this.usdLowVndrWoQty = usdLowVndrWoQty;
	}
	
	/**
	 * Column Info
	 * @param lowNegoCompAmt
	 */
	public void setLowNegoCompAmt(String lowNegoCompAmt) {
		this.lowNegoCompAmt = lowNegoCompAmt;
	}
	
	/**
	 * Column Info
	 * @param dfltBzcAmt
	 */
	public void setDfltBzcAmt(String dfltBzcAmt) {
		this.dfltBzcAmt = dfltBzcAmt;
	}
	
	/**
	 * Column Info
	 * @param dfltAgmtNo
	 */
	public void setDfltAgmtNo(String dfltAgmtNo) {
		this.dfltAgmtNo = dfltAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param lowScgVatAmt
	 */
	public void setLowScgVatAmt(String lowScgVatAmt) {
		this.lowScgVatAmt = lowScgVatAmt;
	}
	
	/**
	 * Column Info
	 * @param lowAgmtNo
	 */
	public void setLowAgmtNo(String lowAgmtNo) {
		this.lowAgmtNo = lowAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param lowTtlUsdAmt
	 */
	public void setLowTtlUsdAmt(String lowTtlUsdAmt) {
		this.lowTtlUsdAmt = lowTtlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param dfltCurrCd
	 */
	public void setDfltCurrCd(String dfltCurrCd) {
		this.dfltCurrCd = dfltCurrCd;
	}
	
	/**
	 * Column Info
	 * @param usdLowAgmtNo
	 */
	public void setUsdLowAgmtNo(String usdLowAgmtNo) {
		this.usdLowAgmtNo = usdLowAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param dfltVatCompAmt
	 */
	public void setDfltVatCompAmt(String dfltVatCompAmt) {
		this.dfltVatCompAmt = dfltVatCompAmt;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param woNegoAmt
	 */
	public void setWoNegoAmt(String woNegoAmt) {
		this.woNegoAmt = woNegoAmt;
	}
	
	/**
	 * Column Info
	 * @param dfltTtlAmt
	 */
	public void setDfltTtlAmt(String dfltTtlAmt) {
		this.dfltTtlAmt = dfltTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param lowTrspAgmtUpdDt
	 */
	public void setLowTrspAgmtUpdDt(String lowTrspAgmtUpdDt) {
		this.lowTrspAgmtUpdDt = lowTrspAgmtUpdDt;
	}
	
	/**
	 * Column Info
	 * @param lowCustNomiTrkrIndCd
	 */
	public void setLowCustNomiTrkrIndCd(String lowCustNomiTrkrIndCd) {
		this.lowCustNomiTrkrIndCd = lowCustNomiTrkrIndCd;
	}
	
	/**
	 * Column Info
	 * @param lowVndrNm
	 */
	public void setLowVndrNm(String lowVndrNm) {
		this.lowVndrNm = lowVndrNm;
	}
	
	/**
	 * Column Info
	 * @param woVndrNm
	 */
	public void setWoVndrNm(String woVndrNm) {
		this.woVndrNm = woVndrNm;
	}
	
	/**
	 * Column Info
	 * @param dfltVndrSeq
	 */
	public void setDfltVndrSeq(String dfltVndrSeq) {
		this.dfltVndrSeq = dfltVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param woBzcAmt
	 */
	public void setWoBzcAmt(String woBzcAmt) {
		this.woBzcAmt = woBzcAmt;
	}
	
	/**
	 * Column Info
	 * @param woScgVatAmt
	 */
	public void setWoScgVatAmt(String woScgVatAmt) {
		this.woScgVatAmt = woScgVatAmt;
	}
	
	/**
	 * Column Info
	 * @param dfltBzcCompAmt
	 */
	public void setDfltBzcCompAmt(String dfltBzcCompAmt) {
		this.dfltBzcCompAmt = dfltBzcCompAmt;
	}
	
	/**
	 * Column Info
	 * @param dfltFuelCompAmt
	 */
	public void setDfltFuelCompAmt(String dfltFuelCompAmt) {
		this.dfltFuelCompAmt = dfltFuelCompAmt;
	}
	
	/**
	 * Column Info
	 * @param usdLowTollFeeAmt
	 */
	public void setUsdLowTollFeeAmt(String usdLowTollFeeAmt) {
		this.usdLowTollFeeAmt = usdLowTollFeeAmt;
	}
	
	/**
	 * Column Info
	 * @param woTtlAmt
	 */
	public void setWoTtlAmt(String woTtlAmt) {
		this.woTtlAmt = woTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param dfltTollCompAmt
	 */
	public void setDfltTollCompAmt(String dfltTollCompAmt) {
		this.dfltTollCompAmt = dfltTollCompAmt;
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
		setTrspSpCngRsnNm(JSPUtil.getParameter(request, prefix + "trsp_sp_cng_rsn_nm", ""));
		setWoCustNomiTrkrIndCd(JSPUtil.getParameter(request, prefix + "wo_cust_nomi_trkr_ind_cd", ""));
		setWoCurrCd(JSPUtil.getParameter(request, prefix + "wo_curr_cd", ""));
		setDfltEtcCompAmt(JSPUtil.getParameter(request, prefix + "dflt_etc_comp_amt", ""));
		setLowUsdVndrWoQty(JSPUtil.getParameter(request, prefix + "low_usd_vndr_wo_qty", ""));
		setLowVatCompAmt(JSPUtil.getParameter(request, prefix + "low_vat_comp_amt", ""));
		setLowFuelScgAmt(JSPUtil.getParameter(request, prefix + "low_fuel_scg_amt", ""));
		setDfltFuelScgAmt(JSPUtil.getParameter(request, prefix + "dflt_fuel_scg_amt", ""));
		setLowTollFeeAmt(JSPUtil.getParameter(request, prefix + "low_toll_fee_amt", ""));
		setDfltToWgt(JSPUtil.getParameter(request, prefix + "dflt_to_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setUsdLowCustNomiTrkrIndCd(JSPUtil.getParameter(request, prefix + "usd_low_cust_nomi_trkr_ind_cd", ""));
		setWoFuelScgAmt(JSPUtil.getParameter(request, prefix + "wo_fuel_scg_amt", ""));
		setWoTollFeeAmt(JSPUtil.getParameter(request, prefix + "wo_toll_fee_amt", ""));
		setUsdLowTrspAgmtUpdDt(JSPUtil.getParameter(request, prefix + "usd_low_trsp_agmt_upd_dt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setDfltTtlUsdCompAmt(JSPUtil.getParameter(request, prefix + "dflt_ttl_usd_comp_amt", ""));
		setUsdLowVndrSeq(JSPUtil.getParameter(request, prefix + "usd_low_vndr_seq", ""));
		setLowTtlAmt(JSPUtil.getParameter(request, prefix + "low_ttl_amt", ""));
		setDfltNegoCompAmt(JSPUtil.getParameter(request, prefix + "dflt_nego_comp_amt", ""));
		setUsdLowTtlUsdAmt(JSPUtil.getParameter(request, prefix + "usd_low_ttl_usd_amt", ""));
		setDfltCmdtGrpCd(JSPUtil.getParameter(request, prefix + "dflt_cmdt_grp_cd", ""));
		setUsdLowFuelCompAmt(JSPUtil.getParameter(request, prefix + "usd_low_fuel_comp_amt", ""));
		setDfltVndrNm(JSPUtil.getParameter(request, prefix + "dflt_vndr_nm", ""));
		setLowVndrSeq(JSPUtil.getParameter(request, prefix + "low_vndr_seq", ""));
		setLowCmdtGrpCd(JSPUtil.getParameter(request, prefix + "low_cmdt_grp_cd", ""));
		setLowCurrCd(JSPUtil.getParameter(request, prefix + "low_curr_cd", ""));
		setUsdLowTtlUsdCompAmt(JSPUtil.getParameter(request, prefix + "usd_low_ttl_usd_comp_amt", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setWoTtlUsdAmt(JSPUtil.getParameter(request, prefix + "wo_ttl_usd_amt", ""));
		setUsdLowEtcCompAmt(JSPUtil.getParameter(request, prefix + "usd_low_etc_comp_amt", ""));
		setWoOfcCd(JSPUtil.getParameter(request, prefix + "wo_ofc_cd", ""));
		setWoVndrSeq(JSPUtil.getParameter(request, prefix + "wo_vndr_seq", ""));
		setUsdLowBzcAmt(JSPUtil.getParameter(request, prefix + "usd_low_bzc_amt", ""));
		setUsdLowTollCompAmt(JSPUtil.getParameter(request, prefix + "usd_low_toll_comp_amt", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setWoEtcAddAmt(JSPUtil.getParameter(request, prefix + "wo_etc_add_amt", ""));
		setUsdLowVatCompAmt(JSPUtil.getParameter(request, prefix + "usd_low_vat_comp_amt", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setLowBzcCompAmt(JSPUtil.getParameter(request, prefix + "low_bzc_comp_amt", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setDfltCustNomiTrkrIndCd(JSPUtil.getParameter(request, prefix + "dflt_cust_nomi_trkr_ind_cd", ""));
		setUsdLowVndrNm(JSPUtil.getParameter(request, prefix + "usd_low_vndr_nm", ""));
		setLowBzcAmt(JSPUtil.getParameter(request, prefix + "low_bzc_amt", ""));
		setUsdLowFuelScgAmt(JSPUtil.getParameter(request, prefix + "usd_low_fuel_scg_amt", ""));
		setUsdLowBzcCompAmt(JSPUtil.getParameter(request, prefix + "usd_low_bzc_comp_amt", ""));
		setLowFuelCompAmt(JSPUtil.getParameter(request, prefix + "low_fuel_comp_amt", ""));
		setUsdLowTtlCompAmt(JSPUtil.getParameter(request, prefix + "usd_low_ttl_comp_amt", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
		setDfltUsdVndrWoQty(JSPUtil.getParameter(request, prefix + "dflt_usd_vndr_wo_qty", ""));
		setDfltTollFeeAmt(JSPUtil.getParameter(request, prefix + "dflt_toll_fee_amt", ""));
		setUsdLowTtlAmt(JSPUtil.getParameter(request, prefix + "usd_low_ttl_amt", ""));
		setLowEtcCompAmt(JSPUtil.getParameter(request, prefix + "low_etc_comp_amt", ""));
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setUsdLowCurrCd(JSPUtil.getParameter(request, prefix + "usd_low_curr_cd", ""));
		setDfltTrspAgmtUpdDt(JSPUtil.getParameter(request, prefix + "dflt_trsp_agmt_upd_dt", ""));
		setWoAgmtNo(JSPUtil.getParameter(request, prefix + "wo_agmt_no", ""));
		setDfltTtlCompAmt(JSPUtil.getParameter(request, prefix + "dflt_ttl_comp_amt", ""));
		setDfltTtlUsdAmt(JSPUtil.getParameter(request, prefix + "dflt_ttl_usd_amt", ""));
		setLowTtlUsdCompAmt(JSPUtil.getParameter(request, prefix + "low_ttl_usd_comp_amt", ""));
		setTrspCostDtlModCd(JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setUsdLowScgVatAmt(JSPUtil.getParameter(request, prefix + "usd_low_scg_vat_amt", ""));
		setLowTtlCompAmt(JSPUtil.getParameter(request, prefix + "low_ttl_comp_amt", ""));
		setDfltScgVatAmt(JSPUtil.getParameter(request, prefix + "dflt_scg_vat_amt", ""));
		setSoNo(JSPUtil.getParameter(request, prefix + "so_no", ""));
		setUsdLowToWgt(JSPUtil.getParameter(request, prefix + "usd_low_to_wgt", ""));
		setUsdLowCmdtGrpCd(JSPUtil.getParameter(request, prefix + "usd_low_cmdt_grp_cd", ""));
		setLowTollCompAmt(JSPUtil.getParameter(request, prefix + "low_toll_comp_amt", ""));
		setUsdLowNegoCompAmt(JSPUtil.getParameter(request, prefix + "usd_low_nego_comp_amt", ""));
		setLowToWgt(JSPUtil.getParameter(request, prefix + "low_to_wgt", ""));
		setLowAgmtMorCnddtQty(JSPUtil.getParameter(request, prefix + "low_agmt_mor_cnddt_qty", ""));
		setUsdLowVndrWoQty(JSPUtil.getParameter(request, prefix + "usd_low_vndr_wo_qty", ""));
		setLowNegoCompAmt(JSPUtil.getParameter(request, prefix + "low_nego_comp_amt", ""));
		setDfltBzcAmt(JSPUtil.getParameter(request, prefix + "dflt_bzc_amt", ""));
		setDfltAgmtNo(JSPUtil.getParameter(request, prefix + "dflt_agmt_no", ""));
		setLowScgVatAmt(JSPUtil.getParameter(request, prefix + "low_scg_vat_amt", ""));
		setLowAgmtNo(JSPUtil.getParameter(request, prefix + "low_agmt_no", ""));
		setLowTtlUsdAmt(JSPUtil.getParameter(request, prefix + "low_ttl_usd_amt", ""));
		setDfltCurrCd(JSPUtil.getParameter(request, prefix + "dflt_curr_cd", ""));
		setUsdLowAgmtNo(JSPUtil.getParameter(request, prefix + "usd_low_agmt_no", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDfltVatCompAmt(JSPUtil.getParameter(request, prefix + "dflt_vat_comp_amt", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setWoNegoAmt(JSPUtil.getParameter(request, prefix + "wo_nego_amt", ""));
		setDfltTtlAmt(JSPUtil.getParameter(request, prefix + "dflt_ttl_amt", ""));
		setLowTrspAgmtUpdDt(JSPUtil.getParameter(request, prefix + "low_trsp_agmt_upd_dt", ""));
		setLowCustNomiTrkrIndCd(JSPUtil.getParameter(request, prefix + "low_cust_nomi_trkr_ind_cd", ""));
		setLowVndrNm(JSPUtil.getParameter(request, prefix + "low_vndr_nm", ""));
		setWoVndrNm(JSPUtil.getParameter(request, prefix + "wo_vndr_nm", ""));
		setDfltVndrSeq(JSPUtil.getParameter(request, prefix + "dflt_vndr_seq", ""));
		setWoBzcAmt(JSPUtil.getParameter(request, prefix + "wo_bzc_amt", ""));
		setWoScgVatAmt(JSPUtil.getParameter(request, prefix + "wo_scg_vat_amt", ""));
		setDfltBzcCompAmt(JSPUtil.getParameter(request, prefix + "dflt_bzc_comp_amt", ""));
		setDfltFuelCompAmt(JSPUtil.getParameter(request, prefix + "dflt_fuel_comp_amt", ""));
		setUsdLowTollFeeAmt(JSPUtil.getParameter(request, prefix + "usd_low_toll_fee_amt", ""));
		setWoTtlAmt(JSPUtil.getParameter(request, prefix + "wo_ttl_amt", ""));
		setDfltTollCompAmt(JSPUtil.getParameter(request, prefix + "dflt_toll_comp_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchComparisonVO[]
	 */
	public SearchComparisonVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchComparisonVO[]
	 */
	public SearchComparisonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchComparisonVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trspSpCngRsnNm = (JSPUtil.getParameter(request, prefix	+ "trsp_sp_cng_rsn_nm", length));
			String[] woCustNomiTrkrIndCd = (JSPUtil.getParameter(request, prefix	+ "wo_cust_nomi_trkr_ind_cd", length));
			String[] woCurrCd = (JSPUtil.getParameter(request, prefix	+ "wo_curr_cd", length));
			String[] dfltEtcCompAmt = (JSPUtil.getParameter(request, prefix	+ "dflt_etc_comp_amt", length));
			String[] lowUsdVndrWoQty = (JSPUtil.getParameter(request, prefix	+ "low_usd_vndr_wo_qty", length));
			String[] lowVatCompAmt = (JSPUtil.getParameter(request, prefix	+ "low_vat_comp_amt", length));
			String[] lowFuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "low_fuel_scg_amt", length));
			String[] dfltFuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "dflt_fuel_scg_amt", length));
			String[] lowTollFeeAmt = (JSPUtil.getParameter(request, prefix	+ "low_toll_fee_amt", length));
			String[] dfltToWgt = (JSPUtil.getParameter(request, prefix	+ "dflt_to_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] usdLowCustNomiTrkrIndCd = (JSPUtil.getParameter(request, prefix	+ "usd_low_cust_nomi_trkr_ind_cd", length));
			String[] woFuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "wo_fuel_scg_amt", length));
			String[] woTollFeeAmt = (JSPUtil.getParameter(request, prefix	+ "wo_toll_fee_amt", length));
			String[] usdLowTrspAgmtUpdDt = (JSPUtil.getParameter(request, prefix	+ "usd_low_trsp_agmt_upd_dt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] dfltTtlUsdCompAmt = (JSPUtil.getParameter(request, prefix	+ "dflt_ttl_usd_comp_amt", length));
			String[] usdLowVndrSeq = (JSPUtil.getParameter(request, prefix	+ "usd_low_vndr_seq", length));
			String[] lowTtlAmt = (JSPUtil.getParameter(request, prefix	+ "low_ttl_amt", length));
			String[] dfltNegoCompAmt = (JSPUtil.getParameter(request, prefix	+ "dflt_nego_comp_amt", length));
			String[] usdLowTtlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_low_ttl_usd_amt", length));
			String[] dfltCmdtGrpCd = (JSPUtil.getParameter(request, prefix	+ "dflt_cmdt_grp_cd", length));
			String[] usdLowFuelCompAmt = (JSPUtil.getParameter(request, prefix	+ "usd_low_fuel_comp_amt", length));
			String[] dfltVndrNm = (JSPUtil.getParameter(request, prefix	+ "dflt_vndr_nm", length));
			String[] lowVndrSeq = (JSPUtil.getParameter(request, prefix	+ "low_vndr_seq", length));
			String[] lowCmdtGrpCd = (JSPUtil.getParameter(request, prefix	+ "low_cmdt_grp_cd", length));
			String[] lowCurrCd = (JSPUtil.getParameter(request, prefix	+ "low_curr_cd", length));
			String[] usdLowTtlUsdCompAmt = (JSPUtil.getParameter(request, prefix	+ "usd_low_ttl_usd_comp_amt", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] woTtlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "wo_ttl_usd_amt", length));
			String[] usdLowEtcCompAmt = (JSPUtil.getParameter(request, prefix	+ "usd_low_etc_comp_amt", length));
			String[] woOfcCd = (JSPUtil.getParameter(request, prefix	+ "wo_ofc_cd", length));
			String[] woVndrSeq = (JSPUtil.getParameter(request, prefix	+ "wo_vndr_seq", length));
			String[] usdLowBzcAmt = (JSPUtil.getParameter(request, prefix	+ "usd_low_bzc_amt", length));
			String[] usdLowTollCompAmt = (JSPUtil.getParameter(request, prefix	+ "usd_low_toll_comp_amt", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] woEtcAddAmt = (JSPUtil.getParameter(request, prefix	+ "wo_etc_add_amt", length));
			String[] usdLowVatCompAmt = (JSPUtil.getParameter(request, prefix	+ "usd_low_vat_comp_amt", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] lowBzcCompAmt = (JSPUtil.getParameter(request, prefix	+ "low_bzc_comp_amt", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] dfltCustNomiTrkrIndCd = (JSPUtil.getParameter(request, prefix	+ "dflt_cust_nomi_trkr_ind_cd", length));
			String[] usdLowVndrNm = (JSPUtil.getParameter(request, prefix	+ "usd_low_vndr_nm", length));
			String[] lowBzcAmt = (JSPUtil.getParameter(request, prefix	+ "low_bzc_amt", length));
			String[] usdLowFuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "usd_low_fuel_scg_amt", length));
			String[] usdLowBzcCompAmt = (JSPUtil.getParameter(request, prefix	+ "usd_low_bzc_comp_amt", length));
			String[] lowFuelCompAmt = (JSPUtil.getParameter(request, prefix	+ "low_fuel_comp_amt", length));
			String[] usdLowTtlCompAmt = (JSPUtil.getParameter(request, prefix	+ "usd_low_ttl_comp_amt", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			String[] dfltUsdVndrWoQty = (JSPUtil.getParameter(request, prefix	+ "dflt_usd_vndr_wo_qty", length));
			String[] dfltTollFeeAmt = (JSPUtil.getParameter(request, prefix	+ "dflt_toll_fee_amt", length));
			String[] usdLowTtlAmt = (JSPUtil.getParameter(request, prefix	+ "usd_low_ttl_amt", length));
			String[] lowEtcCompAmt = (JSPUtil.getParameter(request, prefix	+ "low_etc_comp_amt", length));
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] usdLowCurrCd = (JSPUtil.getParameter(request, prefix	+ "usd_low_curr_cd", length));
			String[] dfltTrspAgmtUpdDt = (JSPUtil.getParameter(request, prefix	+ "dflt_trsp_agmt_upd_dt", length));
			String[] woAgmtNo = (JSPUtil.getParameter(request, prefix	+ "wo_agmt_no", length));
			String[] dfltTtlCompAmt = (JSPUtil.getParameter(request, prefix	+ "dflt_ttl_comp_amt", length));
			String[] dfltTtlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "dflt_ttl_usd_amt", length));
			String[] lowTtlUsdCompAmt = (JSPUtil.getParameter(request, prefix	+ "low_ttl_usd_comp_amt", length));
			String[] trspCostDtlModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_dtl_mod_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] usdLowScgVatAmt = (JSPUtil.getParameter(request, prefix	+ "usd_low_scg_vat_amt", length));
			String[] lowTtlCompAmt = (JSPUtil.getParameter(request, prefix	+ "low_ttl_comp_amt", length));
			String[] dfltScgVatAmt = (JSPUtil.getParameter(request, prefix	+ "dflt_scg_vat_amt", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] usdLowToWgt = (JSPUtil.getParameter(request, prefix	+ "usd_low_to_wgt", length));
			String[] usdLowCmdtGrpCd = (JSPUtil.getParameter(request, prefix	+ "usd_low_cmdt_grp_cd", length));
			String[] lowTollCompAmt = (JSPUtil.getParameter(request, prefix	+ "low_toll_comp_amt", length));
			String[] usdLowNegoCompAmt = (JSPUtil.getParameter(request, prefix	+ "usd_low_nego_comp_amt", length));
			String[] lowToWgt = (JSPUtil.getParameter(request, prefix	+ "low_to_wgt", length));
			String[] lowAgmtMorCnddtQty = (JSPUtil.getParameter(request, prefix	+ "low_agmt_mor_cnddt_qty", length));
			String[] usdLowVndrWoQty = (JSPUtil.getParameter(request, prefix	+ "usd_low_vndr_wo_qty", length));
			String[] lowNegoCompAmt = (JSPUtil.getParameter(request, prefix	+ "low_nego_comp_amt", length));
			String[] dfltBzcAmt = (JSPUtil.getParameter(request, prefix	+ "dflt_bzc_amt", length));
			String[] dfltAgmtNo = (JSPUtil.getParameter(request, prefix	+ "dflt_agmt_no", length));
			String[] lowScgVatAmt = (JSPUtil.getParameter(request, prefix	+ "low_scg_vat_amt", length));
			String[] lowAgmtNo = (JSPUtil.getParameter(request, prefix	+ "low_agmt_no", length));
			String[] lowTtlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "low_ttl_usd_amt", length));
			String[] dfltCurrCd = (JSPUtil.getParameter(request, prefix	+ "dflt_curr_cd", length));
			String[] usdLowAgmtNo = (JSPUtil.getParameter(request, prefix	+ "usd_low_agmt_no", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dfltVatCompAmt = (JSPUtil.getParameter(request, prefix	+ "dflt_vat_comp_amt", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] woNegoAmt = (JSPUtil.getParameter(request, prefix	+ "wo_nego_amt", length));
			String[] dfltTtlAmt = (JSPUtil.getParameter(request, prefix	+ "dflt_ttl_amt", length));
			String[] lowTrspAgmtUpdDt = (JSPUtil.getParameter(request, prefix	+ "low_trsp_agmt_upd_dt", length));
			String[] lowCustNomiTrkrIndCd = (JSPUtil.getParameter(request, prefix	+ "low_cust_nomi_trkr_ind_cd", length));
			String[] lowVndrNm = (JSPUtil.getParameter(request, prefix	+ "low_vndr_nm", length));
			String[] woVndrNm = (JSPUtil.getParameter(request, prefix	+ "wo_vndr_nm", length));
			String[] dfltVndrSeq = (JSPUtil.getParameter(request, prefix	+ "dflt_vndr_seq", length));
			String[] woBzcAmt = (JSPUtil.getParameter(request, prefix	+ "wo_bzc_amt", length));
			String[] woScgVatAmt = (JSPUtil.getParameter(request, prefix	+ "wo_scg_vat_amt", length));
			String[] dfltBzcCompAmt = (JSPUtil.getParameter(request, prefix	+ "dflt_bzc_comp_amt", length));
			String[] dfltFuelCompAmt = (JSPUtil.getParameter(request, prefix	+ "dflt_fuel_comp_amt", length));
			String[] usdLowTollFeeAmt = (JSPUtil.getParameter(request, prefix	+ "usd_low_toll_fee_amt", length));
			String[] woTtlAmt = (JSPUtil.getParameter(request, prefix	+ "wo_ttl_amt", length));
			String[] dfltTollCompAmt = (JSPUtil.getParameter(request, prefix	+ "dflt_toll_comp_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchComparisonVO();
				if (trspSpCngRsnNm[i] != null)
					model.setTrspSpCngRsnNm(trspSpCngRsnNm[i]);
				if (woCustNomiTrkrIndCd[i] != null)
					model.setWoCustNomiTrkrIndCd(woCustNomiTrkrIndCd[i]);
				if (woCurrCd[i] != null)
					model.setWoCurrCd(woCurrCd[i]);
				if (dfltEtcCompAmt[i] != null)
					model.setDfltEtcCompAmt(dfltEtcCompAmt[i]);
				if (lowUsdVndrWoQty[i] != null)
					model.setLowUsdVndrWoQty(lowUsdVndrWoQty[i]);
				if (lowVatCompAmt[i] != null)
					model.setLowVatCompAmt(lowVatCompAmt[i]);
				if (lowFuelScgAmt[i] != null)
					model.setLowFuelScgAmt(lowFuelScgAmt[i]);
				if (dfltFuelScgAmt[i] != null)
					model.setDfltFuelScgAmt(dfltFuelScgAmt[i]);
				if (lowTollFeeAmt[i] != null)
					model.setLowTollFeeAmt(lowTollFeeAmt[i]);
				if (dfltToWgt[i] != null)
					model.setDfltToWgt(dfltToWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (usdLowCustNomiTrkrIndCd[i] != null)
					model.setUsdLowCustNomiTrkrIndCd(usdLowCustNomiTrkrIndCd[i]);
				if (woFuelScgAmt[i] != null)
					model.setWoFuelScgAmt(woFuelScgAmt[i]);
				if (woTollFeeAmt[i] != null)
					model.setWoTollFeeAmt(woTollFeeAmt[i]);
				if (usdLowTrspAgmtUpdDt[i] != null)
					model.setUsdLowTrspAgmtUpdDt(usdLowTrspAgmtUpdDt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (dfltTtlUsdCompAmt[i] != null)
					model.setDfltTtlUsdCompAmt(dfltTtlUsdCompAmt[i]);
				if (usdLowVndrSeq[i] != null)
					model.setUsdLowVndrSeq(usdLowVndrSeq[i]);
				if (lowTtlAmt[i] != null)
					model.setLowTtlAmt(lowTtlAmt[i]);
				if (dfltNegoCompAmt[i] != null)
					model.setDfltNegoCompAmt(dfltNegoCompAmt[i]);
				if (usdLowTtlUsdAmt[i] != null)
					model.setUsdLowTtlUsdAmt(usdLowTtlUsdAmt[i]);
				if (dfltCmdtGrpCd[i] != null)
					model.setDfltCmdtGrpCd(dfltCmdtGrpCd[i]);
				if (usdLowFuelCompAmt[i] != null)
					model.setUsdLowFuelCompAmt(usdLowFuelCompAmt[i]);
				if (dfltVndrNm[i] != null)
					model.setDfltVndrNm(dfltVndrNm[i]);
				if (lowVndrSeq[i] != null)
					model.setLowVndrSeq(lowVndrSeq[i]);
				if (lowCmdtGrpCd[i] != null)
					model.setLowCmdtGrpCd(lowCmdtGrpCd[i]);
				if (lowCurrCd[i] != null)
					model.setLowCurrCd(lowCurrCd[i]);
				if (usdLowTtlUsdCompAmt[i] != null)
					model.setUsdLowTtlUsdCompAmt(usdLowTtlUsdCompAmt[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (woTtlUsdAmt[i] != null)
					model.setWoTtlUsdAmt(woTtlUsdAmt[i]);
				if (usdLowEtcCompAmt[i] != null)
					model.setUsdLowEtcCompAmt(usdLowEtcCompAmt[i]);
				if (woOfcCd[i] != null)
					model.setWoOfcCd(woOfcCd[i]);
				if (woVndrSeq[i] != null)
					model.setWoVndrSeq(woVndrSeq[i]);
				if (usdLowBzcAmt[i] != null)
					model.setUsdLowBzcAmt(usdLowBzcAmt[i]);
				if (usdLowTollCompAmt[i] != null)
					model.setUsdLowTollCompAmt(usdLowTollCompAmt[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (woEtcAddAmt[i] != null)
					model.setWoEtcAddAmt(woEtcAddAmt[i]);
				if (usdLowVatCompAmt[i] != null)
					model.setUsdLowVatCompAmt(usdLowVatCompAmt[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (lowBzcCompAmt[i] != null)
					model.setLowBzcCompAmt(lowBzcCompAmt[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (dfltCustNomiTrkrIndCd[i] != null)
					model.setDfltCustNomiTrkrIndCd(dfltCustNomiTrkrIndCd[i]);
				if (usdLowVndrNm[i] != null)
					model.setUsdLowVndrNm(usdLowVndrNm[i]);
				if (lowBzcAmt[i] != null)
					model.setLowBzcAmt(lowBzcAmt[i]);
				if (usdLowFuelScgAmt[i] != null)
					model.setUsdLowFuelScgAmt(usdLowFuelScgAmt[i]);
				if (usdLowBzcCompAmt[i] != null)
					model.setUsdLowBzcCompAmt(usdLowBzcCompAmt[i]);
				if (lowFuelCompAmt[i] != null)
					model.setLowFuelCompAmt(lowFuelCompAmt[i]);
				if (usdLowTtlCompAmt[i] != null)
					model.setUsdLowTtlCompAmt(usdLowTtlCompAmt[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (dfltUsdVndrWoQty[i] != null)
					model.setDfltUsdVndrWoQty(dfltUsdVndrWoQty[i]);
				if (dfltTollFeeAmt[i] != null)
					model.setDfltTollFeeAmt(dfltTollFeeAmt[i]);
				if (usdLowTtlAmt[i] != null)
					model.setUsdLowTtlAmt(usdLowTtlAmt[i]);
				if (lowEtcCompAmt[i] != null)
					model.setLowEtcCompAmt(lowEtcCompAmt[i]);
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (usdLowCurrCd[i] != null)
					model.setUsdLowCurrCd(usdLowCurrCd[i]);
				if (dfltTrspAgmtUpdDt[i] != null)
					model.setDfltTrspAgmtUpdDt(dfltTrspAgmtUpdDt[i]);
				if (woAgmtNo[i] != null)
					model.setWoAgmtNo(woAgmtNo[i]);
				if (dfltTtlCompAmt[i] != null)
					model.setDfltTtlCompAmt(dfltTtlCompAmt[i]);
				if (dfltTtlUsdAmt[i] != null)
					model.setDfltTtlUsdAmt(dfltTtlUsdAmt[i]);
				if (lowTtlUsdCompAmt[i] != null)
					model.setLowTtlUsdCompAmt(lowTtlUsdCompAmt[i]);
				if (trspCostDtlModCd[i] != null)
					model.setTrspCostDtlModCd(trspCostDtlModCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (usdLowScgVatAmt[i] != null)
					model.setUsdLowScgVatAmt(usdLowScgVatAmt[i]);
				if (lowTtlCompAmt[i] != null)
					model.setLowTtlCompAmt(lowTtlCompAmt[i]);
				if (dfltScgVatAmt[i] != null)
					model.setDfltScgVatAmt(dfltScgVatAmt[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (usdLowToWgt[i] != null)
					model.setUsdLowToWgt(usdLowToWgt[i]);
				if (usdLowCmdtGrpCd[i] != null)
					model.setUsdLowCmdtGrpCd(usdLowCmdtGrpCd[i]);
				if (lowTollCompAmt[i] != null)
					model.setLowTollCompAmt(lowTollCompAmt[i]);
				if (usdLowNegoCompAmt[i] != null)
					model.setUsdLowNegoCompAmt(usdLowNegoCompAmt[i]);
				if (lowToWgt[i] != null)
					model.setLowToWgt(lowToWgt[i]);
				if (lowAgmtMorCnddtQty[i] != null)
					model.setLowAgmtMorCnddtQty(lowAgmtMorCnddtQty[i]);
				if (usdLowVndrWoQty[i] != null)
					model.setUsdLowVndrWoQty(usdLowVndrWoQty[i]);
				if (lowNegoCompAmt[i] != null)
					model.setLowNegoCompAmt(lowNegoCompAmt[i]);
				if (dfltBzcAmt[i] != null)
					model.setDfltBzcAmt(dfltBzcAmt[i]);
				if (dfltAgmtNo[i] != null)
					model.setDfltAgmtNo(dfltAgmtNo[i]);
				if (lowScgVatAmt[i] != null)
					model.setLowScgVatAmt(lowScgVatAmt[i]);
				if (lowAgmtNo[i] != null)
					model.setLowAgmtNo(lowAgmtNo[i]);
				if (lowTtlUsdAmt[i] != null)
					model.setLowTtlUsdAmt(lowTtlUsdAmt[i]);
				if (dfltCurrCd[i] != null)
					model.setDfltCurrCd(dfltCurrCd[i]);
				if (usdLowAgmtNo[i] != null)
					model.setUsdLowAgmtNo(usdLowAgmtNo[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dfltVatCompAmt[i] != null)
					model.setDfltVatCompAmt(dfltVatCompAmt[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (woNegoAmt[i] != null)
					model.setWoNegoAmt(woNegoAmt[i]);
				if (dfltTtlAmt[i] != null)
					model.setDfltTtlAmt(dfltTtlAmt[i]);
				if (lowTrspAgmtUpdDt[i] != null)
					model.setLowTrspAgmtUpdDt(lowTrspAgmtUpdDt[i]);
				if (lowCustNomiTrkrIndCd[i] != null)
					model.setLowCustNomiTrkrIndCd(lowCustNomiTrkrIndCd[i]);
				if (lowVndrNm[i] != null)
					model.setLowVndrNm(lowVndrNm[i]);
				if (woVndrNm[i] != null)
					model.setWoVndrNm(woVndrNm[i]);
				if (dfltVndrSeq[i] != null)
					model.setDfltVndrSeq(dfltVndrSeq[i]);
				if (woBzcAmt[i] != null)
					model.setWoBzcAmt(woBzcAmt[i]);
				if (woScgVatAmt[i] != null)
					model.setWoScgVatAmt(woScgVatAmt[i]);
				if (dfltBzcCompAmt[i] != null)
					model.setDfltBzcCompAmt(dfltBzcCompAmt[i]);
				if (dfltFuelCompAmt[i] != null)
					model.setDfltFuelCompAmt(dfltFuelCompAmt[i]);
				if (usdLowTollFeeAmt[i] != null)
					model.setUsdLowTollFeeAmt(usdLowTollFeeAmt[i]);
				if (woTtlAmt[i] != null)
					model.setWoTtlAmt(woTtlAmt[i]);
				if (dfltTollCompAmt[i] != null)
					model.setDfltTollCompAmt(dfltTollCompAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchComparisonVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchComparisonVO[]
	 */
	public SearchComparisonVO[] getSearchComparisonVOs(){
		SearchComparisonVO[] vos = (SearchComparisonVO[])models.toArray(new SearchComparisonVO[models.size()]);
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
		this.trspSpCngRsnNm = this.trspSpCngRsnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woCustNomiTrkrIndCd = this.woCustNomiTrkrIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woCurrCd = this.woCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltEtcCompAmt = this.dfltEtcCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowUsdVndrWoQty = this.lowUsdVndrWoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowVatCompAmt = this.lowVatCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowFuelScgAmt = this.lowFuelScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltFuelScgAmt = this.dfltFuelScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowTollFeeAmt = this.lowTollFeeAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltToWgt = this.dfltToWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowCustNomiTrkrIndCd = this.usdLowCustNomiTrkrIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woFuelScgAmt = this.woFuelScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woTollFeeAmt = this.woTollFeeAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowTrspAgmtUpdDt = this.usdLowTrspAgmtUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltTtlUsdCompAmt = this.dfltTtlUsdCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowVndrSeq = this.usdLowVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowTtlAmt = this.lowTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltNegoCompAmt = this.dfltNegoCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowTtlUsdAmt = this.usdLowTtlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltCmdtGrpCd = this.dfltCmdtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowFuelCompAmt = this.usdLowFuelCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltVndrNm = this.dfltVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowVndrSeq = this.lowVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowCmdtGrpCd = this.lowCmdtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowCurrCd = this.lowCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowTtlUsdCompAmt = this.usdLowTtlUsdCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woTtlUsdAmt = this.woTtlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowEtcCompAmt = this.usdLowEtcCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woOfcCd = this.woOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woVndrSeq = this.woVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowBzcAmt = this.usdLowBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowTollCompAmt = this.usdLowTollCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woEtcAddAmt = this.woEtcAddAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowVatCompAmt = this.usdLowVatCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowBzcCompAmt = this.lowBzcCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltCustNomiTrkrIndCd = this.dfltCustNomiTrkrIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowVndrNm = this.usdLowVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowBzcAmt = this.lowBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowFuelScgAmt = this.usdLowFuelScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowBzcCompAmt = this.usdLowBzcCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowFuelCompAmt = this.lowFuelCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowTtlCompAmt = this.usdLowTtlCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltUsdVndrWoQty = this.dfltUsdVndrWoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltTollFeeAmt = this.dfltTollFeeAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowTtlAmt = this.usdLowTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowEtcCompAmt = this.lowEtcCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowCurrCd = this.usdLowCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltTrspAgmtUpdDt = this.dfltTrspAgmtUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woAgmtNo = this.woAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltTtlCompAmt = this.dfltTtlCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltTtlUsdAmt = this.dfltTtlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowTtlUsdCompAmt = this.lowTtlUsdCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModCd = this.trspCostDtlModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowScgVatAmt = this.usdLowScgVatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowTtlCompAmt = this.lowTtlCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltScgVatAmt = this.dfltScgVatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowToWgt = this.usdLowToWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowCmdtGrpCd = this.usdLowCmdtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowTollCompAmt = this.lowTollCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowNegoCompAmt = this.usdLowNegoCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowToWgt = this.lowToWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowAgmtMorCnddtQty = this.lowAgmtMorCnddtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowVndrWoQty = this.usdLowVndrWoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowNegoCompAmt = this.lowNegoCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltBzcAmt = this.dfltBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltAgmtNo = this.dfltAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowScgVatAmt = this.lowScgVatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowAgmtNo = this.lowAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowTtlUsdAmt = this.lowTtlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltCurrCd = this.dfltCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowAgmtNo = this.usdLowAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltVatCompAmt = this.dfltVatCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNegoAmt = this.woNegoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltTtlAmt = this.dfltTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowTrspAgmtUpdDt = this.lowTrspAgmtUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowCustNomiTrkrIndCd = this.lowCustNomiTrkrIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowVndrNm = this.lowVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woVndrNm = this.woVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltVndrSeq = this.dfltVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woBzcAmt = this.woBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woScgVatAmt = this.woScgVatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltBzcCompAmt = this.dfltBzcCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltFuelCompAmt = this.dfltFuelCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLowTollFeeAmt = this.usdLowTollFeeAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woTtlAmt = this.woTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltTollCompAmt = this.dfltTollCompAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
