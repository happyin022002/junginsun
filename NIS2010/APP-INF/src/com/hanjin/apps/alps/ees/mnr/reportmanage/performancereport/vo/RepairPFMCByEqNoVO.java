/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RepairPFMCByEqNoVO.java
*@FileTitle : RepairPFMCByEqNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.18
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2011.04.18 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RepairPFMCByEqNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RepairPFMCByEqNoVO> models = new ArrayList<RepairPFMCByEqNoVO>();
	
	/* Column Info */
	private String eqRfMkrNm = null;
	/* Column Info */
	private String manuDt = null;
	/* Column Info */
	private String eqLocCd = null;
	/* Column Info */
	private String mnrRtTpCd = null;
	/* Column Info */
	private String repairYard = null;
	/* Column Info */
	private String verifyResult = null;
	/* Column Info */
	private String currency = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnrOrdOfcCtyCd = null;
	/* Column Info */
	private String lbrCostAmt = null;
	/* Column Info */
	private String eqCmpoNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String eqDmgCd = null;
	/* Column Info */
	private String rhqNm = null;
	/* Column Info */
	private String qtySize = null;
	/* Column Info */
	private String trfDivNm = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String eTotalAmt = null;
	/* Column Info */
	private String manudacturerName = null;
	/* Column Info */
	private String eqRprNm = null;
	/* Column Info */
	private String eqDmgNm = null;
	/* Column Info */
	private String eqRfMkrSeq = null;
	/* Column Info */
	private String woAmt = null;
	/* Column Info */
	private String eqCmpoCd = null;
	/* Column Info */
	private String trfDivCd = null;
	/* Column Info */
	private String eqRprCd = null;
	/* Column Info */
	private String woDate = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String eqMkrSeq = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String gTotalAmt = null;
	/* Column Info */
	private String term = null;
	/* Column Info */
	private String mnrOrdSeq = null;
	/* Column Info */
	private String mtrlCostAmt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String woCurrency = null;
	/* Column Info */
	private String rprLbrHrs = null;
	/* Column Info */
	private String vndrSeqNm = null;
	/* Column Info */
	private String eqLocNm = null;
	/* Column Info */
	private String eqMkrNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RepairPFMCByEqNoVO() {}

	public RepairPFMCByEqNoVO(String ibflag, String pagerows, String eqRfMkrNm, String eqLocCd, String manuDt, String mnrRtTpCd, String repairYard, String currency, String mnrOrdOfcCtyCd, String eqCmpoNm, String lbrCostAmt, String eqDmgCd, String eqNo, String rhqNm, String qtySize, String trfDivNm, String acctCd, String woNo, String eTotalAmt, String manudacturerName, String eqRprNm, String eqDmgNm, String eqRfMkrSeq, String woAmt, String eqCmpoCd, String trfDivCd, String eqRprCd, String woDate, String eqMkrSeq, String eqTpszCd, String ofcCd, String mtrlCostAmt, String mnrOrdSeq, String term, String gTotalAmt, String vndrSeq, String woCurrency, String vndrSeqNm, String rprLbrHrs, String eqMkrNm, String eqLocNm, String verifyResult) {
		this.eqRfMkrNm = eqRfMkrNm;
		this.manuDt = manuDt;
		this.eqLocCd = eqLocCd;
		this.mnrRtTpCd = mnrRtTpCd;
		this.repairYard = repairYard;
		this.verifyResult = verifyResult;
		this.currency = currency;
		this.pagerows = pagerows;
		this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
		this.lbrCostAmt = lbrCostAmt;
		this.eqCmpoNm = eqCmpoNm;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.eqDmgCd = eqDmgCd;
		this.rhqNm = rhqNm;
		this.qtySize = qtySize;
		this.trfDivNm = trfDivNm;
		this.acctCd = acctCd;
		this.woNo = woNo;
		this.eTotalAmt = eTotalAmt;
		this.manudacturerName = manudacturerName;
		this.eqRprNm = eqRprNm;
		this.eqDmgNm = eqDmgNm;
		this.eqRfMkrSeq = eqRfMkrSeq;
		this.woAmt = woAmt;
		this.eqCmpoCd = eqCmpoCd;
		this.trfDivCd = trfDivCd;
		this.eqRprCd = eqRprCd;
		this.woDate = woDate;
		this.eqTpszCd = eqTpszCd;
		this.eqMkrSeq = eqMkrSeq;
		this.ofcCd = ofcCd;
		this.gTotalAmt = gTotalAmt;
		this.term = term;
		this.mnrOrdSeq = mnrOrdSeq;
		this.mtrlCostAmt = mtrlCostAmt;
		this.vndrSeq = vndrSeq;
		this.woCurrency = woCurrency;
		this.rprLbrHrs = rprLbrHrs;
		this.vndrSeqNm = vndrSeqNm;
		this.eqLocNm = eqLocNm;
		this.eqMkrNm = eqMkrNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eq_rf_mkr_nm", getEqRfMkrNm());
		this.hashColumns.put("manu_dt", getManuDt());
		this.hashColumns.put("eq_loc_cd", getEqLocCd());
		this.hashColumns.put("mnr_rt_tp_cd", getMnrRtTpCd());
		this.hashColumns.put("repair_yard", getRepairYard());
		this.hashColumns.put("verify_result", getVerifyResult());
		this.hashColumns.put("currency", getCurrency());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_ord_ofc_cty_cd", getMnrOrdOfcCtyCd());
		this.hashColumns.put("lbr_cost_amt", getLbrCostAmt());
		this.hashColumns.put("eq_cmpo_nm", getEqCmpoNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("eq_dmg_cd", getEqDmgCd());
		this.hashColumns.put("rhq_nm", getRhqNm());
		this.hashColumns.put("qty_size", getQtySize());
		this.hashColumns.put("trf_div_nm", getTrfDivNm());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("e_total_amt", getETotalAmt());
		this.hashColumns.put("manudacturer_name", getManudacturerName());
		this.hashColumns.put("eq_rpr_nm", getEqRprNm());
		this.hashColumns.put("eq_dmg_nm", getEqDmgNm());
		this.hashColumns.put("eq_rf_mkr_seq", getEqRfMkrSeq());
		this.hashColumns.put("wo_amt", getWoAmt());
		this.hashColumns.put("eq_cmpo_cd", getEqCmpoCd());
		this.hashColumns.put("trf_div_cd", getTrfDivCd());
		this.hashColumns.put("eq_rpr_cd", getEqRprCd());
		this.hashColumns.put("wo_date", getWoDate());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("eq_mkr_seq", getEqMkrSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("g_total_amt", getGTotalAmt());
		this.hashColumns.put("term", getTerm());
		this.hashColumns.put("mnr_ord_seq", getMnrOrdSeq());
		this.hashColumns.put("mtrl_cost_amt", getMtrlCostAmt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("wo_currency", getWoCurrency());
		this.hashColumns.put("rpr_lbr_hrs", getRprLbrHrs());
		this.hashColumns.put("vndr_seq_nm", getVndrSeqNm());
		this.hashColumns.put("eq_loc_nm", getEqLocNm());
		this.hashColumns.put("eq_mkr_nm", getEqMkrNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eq_rf_mkr_nm", "eqRfMkrNm");
		this.hashFields.put("manu_dt", "manuDt");
		this.hashFields.put("eq_loc_cd", "eqLocCd");
		this.hashFields.put("mnr_rt_tp_cd", "mnrRtTpCd");
		this.hashFields.put("repair_yard", "repairYard");
		this.hashFields.put("verify_result", "verifyResult");
		this.hashFields.put("currency", "currency");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_ord_ofc_cty_cd", "mnrOrdOfcCtyCd");
		this.hashFields.put("lbr_cost_amt", "lbrCostAmt");
		this.hashFields.put("eq_cmpo_nm", "eqCmpoNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("eq_dmg_cd", "eqDmgCd");
		this.hashFields.put("rhq_nm", "rhqNm");
		this.hashFields.put("qty_size", "qtySize");
		this.hashFields.put("trf_div_nm", "trfDivNm");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("e_total_amt", "eTotalAmt");
		this.hashFields.put("manudacturer_name", "manudacturerName");
		this.hashFields.put("eq_rpr_nm", "eqRprNm");
		this.hashFields.put("eq_dmg_nm", "eqDmgNm");
		this.hashFields.put("eq_rf_mkr_seq", "eqRfMkrSeq");
		this.hashFields.put("wo_amt", "woAmt");
		this.hashFields.put("eq_cmpo_cd", "eqCmpoCd");
		this.hashFields.put("trf_div_cd", "trfDivCd");
		this.hashFields.put("eq_rpr_cd", "eqRprCd");
		this.hashFields.put("wo_date", "woDate");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("eq_mkr_seq", "eqMkrSeq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("g_total_amt", "gTotalAmt");
		this.hashFields.put("term", "term");
		this.hashFields.put("mnr_ord_seq", "mnrOrdSeq");
		this.hashFields.put("mtrl_cost_amt", "mtrlCostAmt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("wo_currency", "woCurrency");
		this.hashFields.put("rpr_lbr_hrs", "rprLbrHrs");
		this.hashFields.put("vndr_seq_nm", "vndrSeqNm");
		this.hashFields.put("eq_loc_nm", "eqLocNm");
		this.hashFields.put("eq_mkr_nm", "eqMkrNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eqRfMkrNm
	 */
	public String getEqRfMkrNm() {
		return this.eqRfMkrNm;
	}
	
	/**
	 * Column Info
	 * @return manuDt
	 */
	public String getManuDt() {
		return this.manuDt;
	}
	
	/**
	 * Column Info
	 * @return eqLocCd
	 */
	public String getEqLocCd() {
		return this.eqLocCd;
	}
	
	/**
	 * Column Info
	 * @return mnrRtTpCd
	 */
	public String getMnrRtTpCd() {
		return this.mnrRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return repairYard
	 */
	public String getRepairYard() {
		return this.repairYard;
	}
	
	/**
	 * Column Info
	 * @return verifyResult
	 */
	public String getVerifyResult() {
		return this.verifyResult;
	}
	
	/**
	 * Column Info
	 * @return currency
	 */
	public String getCurrency() {
		return this.currency;
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
	 * @return mnrOrdOfcCtyCd
	 */
	public String getMnrOrdOfcCtyCd() {
		return this.mnrOrdOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return lbrCostAmt
	 */
	public String getLbrCostAmt() {
		return this.lbrCostAmt;
	}
	
	/**
	 * Column Info
	 * @return eqCmpoNm
	 */
	public String getEqCmpoNm() {
		return this.eqCmpoNm;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return eqDmgCd
	 */
	public String getEqDmgCd() {
		return this.eqDmgCd;
	}
	
	/**
	 * Column Info
	 * @return rhqNm
	 */
	public String getRhqNm() {
		return this.rhqNm;
	}
	
	/**
	 * Column Info
	 * @return qtySize
	 */
	public String getQtySize() {
		return this.qtySize;
	}
	
	/**
	 * Column Info
	 * @return trfDivNm
	 */
	public String getTrfDivNm() {
		return this.trfDivNm;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
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
	 * @return eTotalAmt
	 */
	public String getETotalAmt() {
		return this.eTotalAmt;
	}
	
	/**
	 * Column Info
	 * @return manudacturerName
	 */
	public String getManudacturerName() {
		return this.manudacturerName;
	}
	
	/**
	 * Column Info
	 * @return eqRprNm
	 */
	public String getEqRprNm() {
		return this.eqRprNm;
	}
	
	/**
	 * Column Info
	 * @return eqDmgNm
	 */
	public String getEqDmgNm() {
		return this.eqDmgNm;
	}
	
	/**
	 * Column Info
	 * @return eqRfMkrSeq
	 */
	public String getEqRfMkrSeq() {
		return this.eqRfMkrSeq;
	}
	
	/**
	 * Column Info
	 * @return woAmt
	 */
	public String getWoAmt() {
		return this.woAmt;
	}
	
	/**
	 * Column Info
	 * @return eqCmpoCd
	 */
	public String getEqCmpoCd() {
		return this.eqCmpoCd;
	}
	
	/**
	 * Column Info
	 * @return trfDivCd
	 */
	public String getTrfDivCd() {
		return this.trfDivCd;
	}
	
	/**
	 * Column Info
	 * @return eqRprCd
	 */
	public String getEqRprCd() {
		return this.eqRprCd;
	}
	
	/**
	 * Column Info
	 * @return woDate
	 */
	public String getWoDate() {
		return this.woDate;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return eqMkrSeq
	 */
	public String getEqMkrSeq() {
		return this.eqMkrSeq;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return gTotalAmt
	 */
	public String getGTotalAmt() {
		return this.gTotalAmt;
	}
	
	/**
	 * Column Info
	 * @return term
	 */
	public String getTerm() {
		return this.term;
	}
	
	/**
	 * Column Info
	 * @return mnrOrdSeq
	 */
	public String getMnrOrdSeq() {
		return this.mnrOrdSeq;
	}
	
	/**
	 * Column Info
	 * @return mtrlCostAmt
	 */
	public String getMtrlCostAmt() {
		return this.mtrlCostAmt;
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
	 * @return woCurrency
	 */
	public String getWoCurrency() {
		return this.woCurrency;
	}
	
	/**
	 * Column Info
	 * @return rprLbrHrs
	 */
	public String getRprLbrHrs() {
		return this.rprLbrHrs;
	}
	
	/**
	 * Column Info
	 * @return vndrSeqNm
	 */
	public String getVndrSeqNm() {
		return this.vndrSeqNm;
	}
	
	/**
	 * Column Info
	 * @return eqLocNm
	 */
	public String getEqLocNm() {
		return this.eqLocNm;
	}
	
	/**
	 * Column Info
	 * @return eqMkrNm
	 */
	public String getEqMkrNm() {
		return this.eqMkrNm;
	}
	

	/**
	 * Column Info
	 * @param eqRfMkrNm
	 */
	public void setEqRfMkrNm(String eqRfMkrNm) {
		this.eqRfMkrNm = eqRfMkrNm;
	}
	
	/**
	 * Column Info
	 * @param manuDt
	 */
	public void setManuDt(String manuDt) {
		this.manuDt = manuDt;
	}
	
	/**
	 * Column Info
	 * @param eqLocCd
	 */
	public void setEqLocCd(String eqLocCd) {
		this.eqLocCd = eqLocCd;
	}
	
	/**
	 * Column Info
	 * @param mnrRtTpCd
	 */
	public void setMnrRtTpCd(String mnrRtTpCd) {
		this.mnrRtTpCd = mnrRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param repairYard
	 */
	public void setRepairYard(String repairYard) {
		this.repairYard = repairYard;
	}
	
	/**
	 * Column Info
	 * @param verifyResult
	 */
	public void setVerifyResult(String verifyResult) {
		this.verifyResult = verifyResult;
	}
	
	/**
	 * Column Info
	 * @param currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
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
	 * @param mnrOrdOfcCtyCd
	 */
	public void setMnrOrdOfcCtyCd(String mnrOrdOfcCtyCd) {
		this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param lbrCostAmt
	 */
	public void setLbrCostAmt(String lbrCostAmt) {
		this.lbrCostAmt = lbrCostAmt;
	}
	
	/**
	 * Column Info
	 * @param eqCmpoNm
	 */
	public void setEqCmpoNm(String eqCmpoNm) {
		this.eqCmpoNm = eqCmpoNm;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param eqDmgCd
	 */
	public void setEqDmgCd(String eqDmgCd) {
		this.eqDmgCd = eqDmgCd;
	}
	
	/**
	 * Column Info
	 * @param rhqNm
	 */
	public void setRhqNm(String rhqNm) {
		this.rhqNm = rhqNm;
	}
	
	/**
	 * Column Info
	 * @param qtySize
	 */
	public void setQtySize(String qtySize) {
		this.qtySize = qtySize;
	}
	
	/**
	 * Column Info
	 * @param trfDivNm
	 */
	public void setTrfDivNm(String trfDivNm) {
		this.trfDivNm = trfDivNm;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
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
	 * @param eTotalAmt
	 */
	public void setETotalAmt(String eTotalAmt) {
		this.eTotalAmt = eTotalAmt;
	}
	
	/**
	 * Column Info
	 * @param manudacturerName
	 */
	public void setManudacturerName(String manudacturerName) {
		this.manudacturerName = manudacturerName;
	}
	
	/**
	 * Column Info
	 * @param eqRprNm
	 */
	public void setEqRprNm(String eqRprNm) {
		this.eqRprNm = eqRprNm;
	}
	
	/**
	 * Column Info
	 * @param eqDmgNm
	 */
	public void setEqDmgNm(String eqDmgNm) {
		this.eqDmgNm = eqDmgNm;
	}
	
	/**
	 * Column Info
	 * @param eqRfMkrSeq
	 */
	public void setEqRfMkrSeq(String eqRfMkrSeq) {
		this.eqRfMkrSeq = eqRfMkrSeq;
	}
	
	/**
	 * Column Info
	 * @param woAmt
	 */
	public void setWoAmt(String woAmt) {
		this.woAmt = woAmt;
	}
	
	/**
	 * Column Info
	 * @param eqCmpoCd
	 */
	public void setEqCmpoCd(String eqCmpoCd) {
		this.eqCmpoCd = eqCmpoCd;
	}
	
	/**
	 * Column Info
	 * @param trfDivCd
	 */
	public void setTrfDivCd(String trfDivCd) {
		this.trfDivCd = trfDivCd;
	}
	
	/**
	 * Column Info
	 * @param eqRprCd
	 */
	public void setEqRprCd(String eqRprCd) {
		this.eqRprCd = eqRprCd;
	}
	
	/**
	 * Column Info
	 * @param woDate
	 */
	public void setWoDate(String woDate) {
		this.woDate = woDate;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param eqMkrSeq
	 */
	public void setEqMkrSeq(String eqMkrSeq) {
		this.eqMkrSeq = eqMkrSeq;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param gTotalAmt
	 */
	public void setGTotalAmt(String gTotalAmt) {
		this.gTotalAmt = gTotalAmt;
	}
	
	/**
	 * Column Info
	 * @param term
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	
	/**
	 * Column Info
	 * @param mnrOrdSeq
	 */
	public void setMnrOrdSeq(String mnrOrdSeq) {
		this.mnrOrdSeq = mnrOrdSeq;
	}
	
	/**
	 * Column Info
	 * @param mtrlCostAmt
	 */
	public void setMtrlCostAmt(String mtrlCostAmt) {
		this.mtrlCostAmt = mtrlCostAmt;
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
	 * @param woCurrency
	 */
	public void setWoCurrency(String woCurrency) {
		this.woCurrency = woCurrency;
	}
	
	/**
	 * Column Info
	 * @param rprLbrHrs
	 */
	public void setRprLbrHrs(String rprLbrHrs) {
		this.rprLbrHrs = rprLbrHrs;
	}
	
	/**
	 * Column Info
	 * @param vndrSeqNm
	 */
	public void setVndrSeqNm(String vndrSeqNm) {
		this.vndrSeqNm = vndrSeqNm;
	}
	
	/**
	 * Column Info
	 * @param eqLocNm
	 */
	public void setEqLocNm(String eqLocNm) {
		this.eqLocNm = eqLocNm;
	}
	
	/**
	 * Column Info
	 * @param eqMkrNm
	 */
	public void setEqMkrNm(String eqMkrNm) {
		this.eqMkrNm = eqMkrNm;
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
		setEqRfMkrNm(JSPUtil.getParameter(request, prefix + "eq_rf_mkr_nm", ""));
		setManuDt(JSPUtil.getParameter(request, prefix + "manu_dt", ""));
		setEqLocCd(JSPUtil.getParameter(request, prefix + "eq_loc_cd", ""));
		setMnrRtTpCd(JSPUtil.getParameter(request, prefix + "mnr_rt_tp_cd", ""));
		setRepairYard(JSPUtil.getParameter(request, prefix + "repair_yard", ""));
		setVerifyResult(JSPUtil.getParameter(request, prefix + "verify_result", ""));
		setCurrency(JSPUtil.getParameter(request, prefix + "currency", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMnrOrdOfcCtyCd(JSPUtil.getParameter(request, prefix + "mnr_ord_ofc_cty_cd", ""));
		setLbrCostAmt(JSPUtil.getParameter(request, prefix + "lbr_cost_amt", ""));
		setEqCmpoNm(JSPUtil.getParameter(request, prefix + "eq_cmpo_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setEqDmgCd(JSPUtil.getParameter(request, prefix + "eq_dmg_cd", ""));
		setRhqNm(JSPUtil.getParameter(request, prefix + "rhq_nm", ""));
		setQtySize(JSPUtil.getParameter(request, prefix + "qty_size", ""));
		setTrfDivNm(JSPUtil.getParameter(request, prefix + "trf_div_nm", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setETotalAmt(JSPUtil.getParameter(request, prefix + "e_total_amt", ""));
		setManudacturerName(JSPUtil.getParameter(request, prefix + "manudacturer_name", ""));
		setEqRprNm(JSPUtil.getParameter(request, prefix + "eq_rpr_nm", ""));
		setEqDmgNm(JSPUtil.getParameter(request, prefix + "eq_dmg_nm", ""));
		setEqRfMkrSeq(JSPUtil.getParameter(request, prefix + "eq_rf_mkr_seq", ""));
		setWoAmt(JSPUtil.getParameter(request, prefix + "wo_amt", ""));
		setEqCmpoCd(JSPUtil.getParameter(request, prefix + "eq_cmpo_cd", ""));
		setTrfDivCd(JSPUtil.getParameter(request, prefix + "trf_div_cd", ""));
		setEqRprCd(JSPUtil.getParameter(request, prefix + "eq_rpr_cd", ""));
		setWoDate(JSPUtil.getParameter(request, prefix + "wo_date", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setEqMkrSeq(JSPUtil.getParameter(request, prefix + "eq_mkr_seq", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setGTotalAmt(JSPUtil.getParameter(request, prefix + "g_total_amt", ""));
		setTerm(JSPUtil.getParameter(request, prefix + "term", ""));
		setMnrOrdSeq(JSPUtil.getParameter(request, prefix + "mnr_ord_seq", ""));
		setMtrlCostAmt(JSPUtil.getParameter(request, prefix + "mtrl_cost_amt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setWoCurrency(JSPUtil.getParameter(request, prefix + "wo_currency", ""));
		setRprLbrHrs(JSPUtil.getParameter(request, prefix + "rpr_lbr_hrs", ""));
		setVndrSeqNm(JSPUtil.getParameter(request, prefix + "vndr_seq_nm", ""));
		setEqLocNm(JSPUtil.getParameter(request, prefix + "eq_loc_nm", ""));
		setEqMkrNm(JSPUtil.getParameter(request, prefix + "eq_mkr_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RepairPFMCByEqNoVO[]
	 */
	public RepairPFMCByEqNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RepairPFMCByEqNoVO[]
	 */
	public RepairPFMCByEqNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RepairPFMCByEqNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eqRfMkrNm = (JSPUtil.getParameter(request, prefix	+ "eq_rf_mkr_nm", length));
			String[] manuDt = (JSPUtil.getParameter(request, prefix	+ "manu_dt", length));
			String[] eqLocCd = (JSPUtil.getParameter(request, prefix	+ "eq_loc_cd", length));
			String[] mnrRtTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_rt_tp_cd", length));
			String[] repairYard = (JSPUtil.getParameter(request, prefix	+ "repair_yard", length));
			String[] verifyResult = (JSPUtil.getParameter(request, prefix	+ "verify_result", length));
			String[] currency = (JSPUtil.getParameter(request, prefix	+ "currency", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrOrdOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_ofc_cty_cd", length));
			String[] lbrCostAmt = (JSPUtil.getParameter(request, prefix	+ "lbr_cost_amt", length));
			String[] eqCmpoNm = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] eqDmgCd = (JSPUtil.getParameter(request, prefix	+ "eq_dmg_cd", length));
			String[] rhqNm = (JSPUtil.getParameter(request, prefix	+ "rhq_nm", length));
			String[] qtySize = (JSPUtil.getParameter(request, prefix	+ "qty_size", length));
			String[] trfDivNm = (JSPUtil.getParameter(request, prefix	+ "trf_div_nm", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] eTotalAmt = (JSPUtil.getParameter(request, prefix	+ "e_total_amt", length));
			String[] manudacturerName = (JSPUtil.getParameter(request, prefix	+ "manudacturer_name", length));
			String[] eqRprNm = (JSPUtil.getParameter(request, prefix	+ "eq_rpr_nm", length));
			String[] eqDmgNm = (JSPUtil.getParameter(request, prefix	+ "eq_dmg_nm", length));
			String[] eqRfMkrSeq = (JSPUtil.getParameter(request, prefix	+ "eq_rf_mkr_seq", length));
			String[] woAmt = (JSPUtil.getParameter(request, prefix	+ "wo_amt", length));
			String[] eqCmpoCd = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_cd", length));
			String[] trfDivCd = (JSPUtil.getParameter(request, prefix	+ "trf_div_cd", length));
			String[] eqRprCd = (JSPUtil.getParameter(request, prefix	+ "eq_rpr_cd", length));
			String[] woDate = (JSPUtil.getParameter(request, prefix	+ "wo_date", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] eqMkrSeq = (JSPUtil.getParameter(request, prefix	+ "eq_mkr_seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] gTotalAmt = (JSPUtil.getParameter(request, prefix	+ "g_total_amt", length));
			String[] term = (JSPUtil.getParameter(request, prefix	+ "term", length));
			String[] mnrOrdSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_seq", length));
			String[] mtrlCostAmt = (JSPUtil.getParameter(request, prefix	+ "mtrl_cost_amt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] woCurrency = (JSPUtil.getParameter(request, prefix	+ "wo_currency", length));
			String[] rprLbrHrs = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_hrs", length));
			String[] vndrSeqNm = (JSPUtil.getParameter(request, prefix	+ "vndr_seq_nm", length));
			String[] eqLocNm = (JSPUtil.getParameter(request, prefix	+ "eq_loc_nm", length));
			String[] eqMkrNm = (JSPUtil.getParameter(request, prefix	+ "eq_mkr_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new RepairPFMCByEqNoVO();
				if (eqRfMkrNm[i] != null)
					model.setEqRfMkrNm(eqRfMkrNm[i]);
				if (manuDt[i] != null)
					model.setManuDt(manuDt[i]);
				if (eqLocCd[i] != null)
					model.setEqLocCd(eqLocCd[i]);
				if (mnrRtTpCd[i] != null)
					model.setMnrRtTpCd(mnrRtTpCd[i]);
				if (repairYard[i] != null)
					model.setRepairYard(repairYard[i]);
				if (verifyResult[i] != null)
					model.setVerifyResult(verifyResult[i]);
				if (currency[i] != null)
					model.setCurrency(currency[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrOrdOfcCtyCd[i] != null)
					model.setMnrOrdOfcCtyCd(mnrOrdOfcCtyCd[i]);
				if (lbrCostAmt[i] != null)
					model.setLbrCostAmt(lbrCostAmt[i]);
				if (eqCmpoNm[i] != null)
					model.setEqCmpoNm(eqCmpoNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (eqDmgCd[i] != null)
					model.setEqDmgCd(eqDmgCd[i]);
				if (rhqNm[i] != null)
					model.setRhqNm(rhqNm[i]);
				if (qtySize[i] != null)
					model.setQtySize(qtySize[i]);
				if (trfDivNm[i] != null)
					model.setTrfDivNm(trfDivNm[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (eTotalAmt[i] != null)
					model.setETotalAmt(eTotalAmt[i]);
				if (manudacturerName[i] != null)
					model.setManudacturerName(manudacturerName[i]);
				if (eqRprNm[i] != null)
					model.setEqRprNm(eqRprNm[i]);
				if (eqDmgNm[i] != null)
					model.setEqDmgNm(eqDmgNm[i]);
				if (eqRfMkrSeq[i] != null)
					model.setEqRfMkrSeq(eqRfMkrSeq[i]);
				if (woAmt[i] != null)
					model.setWoAmt(woAmt[i]);
				if (eqCmpoCd[i] != null)
					model.setEqCmpoCd(eqCmpoCd[i]);
				if (trfDivCd[i] != null)
					model.setTrfDivCd(trfDivCd[i]);
				if (eqRprCd[i] != null)
					model.setEqRprCd(eqRprCd[i]);
				if (woDate[i] != null)
					model.setWoDate(woDate[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (eqMkrSeq[i] != null)
					model.setEqMkrSeq(eqMkrSeq[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (gTotalAmt[i] != null)
					model.setGTotalAmt(gTotalAmt[i]);
				if (term[i] != null)
					model.setTerm(term[i]);
				if (mnrOrdSeq[i] != null)
					model.setMnrOrdSeq(mnrOrdSeq[i]);
				if (mtrlCostAmt[i] != null)
					model.setMtrlCostAmt(mtrlCostAmt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (woCurrency[i] != null)
					model.setWoCurrency(woCurrency[i]);
				if (rprLbrHrs[i] != null)
					model.setRprLbrHrs(rprLbrHrs[i]);
				if (vndrSeqNm[i] != null)
					model.setVndrSeqNm(vndrSeqNm[i]);
				if (eqLocNm[i] != null)
					model.setEqLocNm(eqLocNm[i]);
				if (eqMkrNm[i] != null)
					model.setEqMkrNm(eqMkrNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRepairPFMCByEqNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RepairPFMCByEqNoVO[]
	 */
	public RepairPFMCByEqNoVO[] getRepairPFMCByEqNoVOs(){
		RepairPFMCByEqNoVO[] vos = (RepairPFMCByEqNoVO[])models.toArray(new RepairPFMCByEqNoVO[models.size()]);
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
		this.eqRfMkrNm = this.eqRfMkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manuDt = this.manuDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLocCd = this.eqLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrRtTpCd = this.mnrRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repairYard = this.repairYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verifyResult = this.verifyResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currency = this.currency .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdOfcCtyCd = this.mnrOrdOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbrCostAmt = this.lbrCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoNm = this.eqCmpoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDmgCd = this.eqDmgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqNm = this.rhqNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtySize = this.qtySize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfDivNm = this.trfDivNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eTotalAmt = this.eTotalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manudacturerName = this.manudacturerName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRprNm = this.eqRprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDmgNm = this.eqDmgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRfMkrSeq = this.eqRfMkrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woAmt = this.woAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoCd = this.eqCmpoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfDivCd = this.trfDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRprCd = this.eqRprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woDate = this.woDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqMkrSeq = this.eqMkrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gTotalAmt = this.gTotalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.term = this.term .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSeq = this.mnrOrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlCostAmt = this.mtrlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woCurrency = this.woCurrency .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLbrHrs = this.rprLbrHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeqNm = this.vndrSeqNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLocNm = this.eqLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqMkrNm = this.eqMkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
