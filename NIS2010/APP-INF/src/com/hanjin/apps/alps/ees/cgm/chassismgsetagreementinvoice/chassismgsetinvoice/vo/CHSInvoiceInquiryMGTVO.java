/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSInvoiceInquiryMGTVO.java
*@FileTitle : CHSInvoiceInquiryMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.24
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.12.24 조재성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo;

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
 * @author 조재성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSInvoiceInquiryMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSInvoiceInquiryMGTVO> models = new ArrayList<CHSInvoiceInquiryMGTVO>();
	
	/* Column Info */
	private String invoiceDate = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String payInvSeq = null;
	/* Column Info */
	private String invIssDt = null;
	/* Column Info */
	private String invToDate = null;
	/* Column Info */
	private String payLseChgAmt = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String invRcvDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String apIfDt = null;
	/* Column Info */
	private String invStsCd = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String invCsrNo = null;
	/* Column Info */
	private String chssMgstInvStsCd = null;
	/* Column Info */
	private String invFmDate = null;
	/* Column Info */
	private String invTaxRt = null;
	/* Column Info */
	private String invStsNm = null;
	/* Column Info */
	private String payTaxAmt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String chssMsstInvKndCd = null;
	/* Column Info */
	private String chssMgstInvKndCd = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String invCfmDt = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String chgSmryAmt = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String payCrAmt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String invCsrNoChk = null;
	/* Column Info */
	private String invSmryAmt = null;
	/* Column Info */
	private String invStatus = null;
	/* Column Info */
	private String invTaxCltTpCd = null;
	/* Column Info */
	private String revVvd = null;
	/* Column Info */
	private String chssPoolCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSInvoiceInquiryMGTVO() {}

	public CHSInvoiceInquiryMGTVO(String ibflag, String pagerows, String payInvSeq, String costYrmon, String invIssDt, String invRcvDt, String invCfmDt, String apIfDt, String invoiceDate, String costOfcCd, String creUsrId, String vndrSeq, String vndrNm, String chssMgstInvKndCd, String invNo, String csrNo, String invCsrNoChk, String invCsrNo, String chssMgstInvStsCd, String invStsCd, String invStsNm, String chssMsstInvKndCd, String revVvd, String chssPoolCd, String chgSmryAmt, String invTaxCltTpCd, String invTaxRt, String invSmryAmt, String usrNm, String invFmDate, String invToDate, String invStatus, String agmtNo, String agmtLstmCd, String acctCd, String eqNo, String eqTpszCd, String currCd, String chgCd, String payTaxAmt, String payCrAmt, String payLseChgAmt, String eqKndCd) {
		this.invoiceDate = invoiceDate;
		this.currCd = currCd;
		this.payInvSeq = payInvSeq;
		this.invIssDt = invIssDt;
		this.invToDate = invToDate;
		this.payLseChgAmt = payLseChgAmt;
		this.chgCd = chgCd;
		this.invRcvDt = invRcvDt;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.costYrmon = costYrmon;
		this.apIfDt = apIfDt;
		this.invStsCd = invStsCd;
		this.usrNm = usrNm;
		this.acctCd = acctCd;
		this.invCsrNo = invCsrNo;
		this.chssMgstInvStsCd = chssMgstInvStsCd;
		this.invFmDate = invFmDate;
		this.invTaxRt = invTaxRt;
		this.invStsNm = invStsNm;
		this.payTaxAmt = payTaxAmt;
		this.csrNo = csrNo;
		this.chssMsstInvKndCd = chssMsstInvKndCd;
		this.chssMgstInvKndCd = chssMgstInvKndCd;
		this.costOfcCd = costOfcCd;
		this.invCfmDt = invCfmDt;
		this.agmtNo = agmtNo;
		this.agmtLstmCd = agmtLstmCd;
		this.eqKndCd = eqKndCd;
		this.chgSmryAmt = chgSmryAmt;
		this.eqTpszCd = eqTpszCd;
		this.invNo = invNo;
		this.creUsrId = creUsrId;
		this.payCrAmt = payCrAmt;
		this.vndrSeq = vndrSeq;
		this.invCsrNoChk = invCsrNoChk;
		this.invSmryAmt = invSmryAmt;
		this.invStatus = invStatus;
		this.invTaxCltTpCd = invTaxCltTpCd;
		this.revVvd = revVvd;
		this.chssPoolCd = chssPoolCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("invoice_date", getInvoiceDate());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("pay_inv_seq", getPayInvSeq());
		this.hashColumns.put("inv_iss_dt", getInvIssDt());
		this.hashColumns.put("inv_to_date", getInvToDate());
		this.hashColumns.put("pay_lse_chg_amt", getPayLseChgAmt());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("inv_rcv_dt", getInvRcvDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("ap_if_dt", getApIfDt());
		this.hashColumns.put("inv_sts_cd", getInvStsCd());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("inv_csr_no", getInvCsrNo());
		this.hashColumns.put("chss_mgst_inv_sts_cd", getChssMgstInvStsCd());
		this.hashColumns.put("inv_fm_date", getInvFmDate());
		this.hashColumns.put("inv_tax_rt", getInvTaxRt());
		this.hashColumns.put("inv_sts_nm", getInvStsNm());
		this.hashColumns.put("pay_tax_amt", getPayTaxAmt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("chss_msst_inv_knd_cd", getChssMsstInvKndCd());
		this.hashColumns.put("chss_mgst_inv_knd_cd", getChssMgstInvKndCd());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("inv_cfm_dt", getInvCfmDt());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("chg_smry_amt", getChgSmryAmt());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pay_cr_amt", getPayCrAmt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("inv_csr_no_chk", getInvCsrNoChk());
		this.hashColumns.put("inv_smry_amt", getInvSmryAmt());
		this.hashColumns.put("inv_status", getInvStatus());
		this.hashColumns.put("inv_tax_clt_tp_cd", getInvTaxCltTpCd());
		this.hashColumns.put("rev_vvd", getRevVvd());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("invoice_date", "invoiceDate");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pay_inv_seq", "payInvSeq");
		this.hashFields.put("inv_iss_dt", "invIssDt");
		this.hashFields.put("inv_to_date", "invToDate");
		this.hashFields.put("pay_lse_chg_amt", "payLseChgAmt");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("inv_rcv_dt", "invRcvDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("ap_if_dt", "apIfDt");
		this.hashFields.put("inv_sts_cd", "invStsCd");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("inv_csr_no", "invCsrNo");
		this.hashFields.put("chss_mgst_inv_sts_cd", "chssMgstInvStsCd");
		this.hashFields.put("inv_fm_date", "invFmDate");
		this.hashFields.put("inv_tax_rt", "invTaxRt");
		this.hashFields.put("inv_sts_nm", "invStsNm");
		this.hashFields.put("pay_tax_amt", "payTaxAmt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("chss_msst_inv_knd_cd", "chssMsstInvKndCd");
		this.hashFields.put("chss_mgst_inv_knd_cd", "chssMgstInvKndCd");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("inv_cfm_dt", "invCfmDt");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("chg_smry_amt", "chgSmryAmt");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pay_cr_amt", "payCrAmt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("inv_csr_no_chk", "invCsrNoChk");
		this.hashFields.put("inv_smry_amt", "invSmryAmt");
		this.hashFields.put("inv_status", "invStatus");
		this.hashFields.put("inv_tax_clt_tp_cd", "invTaxCltTpCd");
		this.hashFields.put("rev_vvd", "revVvd");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return invoiceDate
	 */
	public String getInvoiceDate() {
		return this.invoiceDate;
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
	 * @return payInvSeq
	 */
	public String getPayInvSeq() {
		return this.payInvSeq;
	}
	
	/**
	 * Column Info
	 * @return invIssDt
	 */
	public String getInvIssDt() {
		return this.invIssDt;
	}
	
	/**
	 * Column Info
	 * @return invToDate
	 */
	public String getInvToDate() {
		return this.invToDate;
	}
	
	/**
	 * Column Info
	 * @return payLseChgAmt
	 */
	public String getPayLseChgAmt() {
		return this.payLseChgAmt;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Column Info
	 * @return invRcvDt
	 */
	public String getInvRcvDt() {
		return this.invRcvDt;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return apIfDt
	 */
	public String getApIfDt() {
		return this.apIfDt;
	}
	
	/**
	 * Column Info
	 * @return invStsCd
	 */
	public String getInvStsCd() {
		return this.invStsCd;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
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
	 * @return invCsrNo
	 */
	public String getInvCsrNo() {
		return this.invCsrNo;
	}
	
	/**
	 * Column Info
	 * @return chssMgstInvStsCd
	 */
	public String getChssMgstInvStsCd() {
		return this.chssMgstInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return invFmDate
	 */
	public String getInvFmDate() {
		return this.invFmDate;
	}
	
	/**
	 * Column Info
	 * @return invTaxRt
	 */
	public String getInvTaxRt() {
		return this.invTaxRt;
	}
	
	/**
	 * Column Info
	 * @return invStsNm
	 */
	public String getInvStsNm() {
		return this.invStsNm;
	}
	
	/**
	 * Column Info
	 * @return payTaxAmt
	 */
	public String getPayTaxAmt() {
		return this.payTaxAmt;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return chssMsstInvKndCd
	 */
	public String getChssMsstInvKndCd() {
		return this.chssMsstInvKndCd;
	}
	
	/**
	 * Column Info
	 * @return chssMgstInvKndCd
	 */
	public String getChssMgstInvKndCd() {
		return this.chssMgstInvKndCd;
	}
	
	/**
	 * Column Info
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}
	
	/**
	 * Column Info
	 * @return invCfmDt
	 */
	public String getInvCfmDt() {
		return this.invCfmDt;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return agmtLstmCd
	 */
	public String getAgmtLstmCd() {
		return this.agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return chgSmryAmt
	 */
	public String getChgSmryAmt() {
		return this.chgSmryAmt;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return payCrAmt
	 */
	public String getPayCrAmt() {
		return this.payCrAmt;
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
	 * @return invCsrNoChk
	 */
	public String getInvCsrNoChk() {
		return this.invCsrNoChk;
	}
	
	/**
	 * Column Info
	 * @return invSmryAmt
	 */
	public String getInvSmryAmt() {
		return this.invSmryAmt;
	}
	
	/**
	 * Column Info
	 * @return invStatus
	 */
	public String getInvStatus() {
		return this.invStatus;
	}
	
	/**
	 * Column Info
	 * @return invTaxCltTpCd
	 */
	public String getInvTaxCltTpCd() {
		return this.invTaxCltTpCd;
	}
	
	/**
	 * Column Info
	 * @return revVvd
	 */
	public String getRevVvd() {
		return this.revVvd;
	}
	
	/**
	 * Column Info
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
	}

	/**
	 * Column Info
	 * @param invoiceDate
	 */
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
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
	 * @param payInvSeq
	 */
	public void setPayInvSeq(String payInvSeq) {
		this.payInvSeq = payInvSeq;
	}
	
	/**
	 * Column Info
	 * @param invIssDt
	 */
	public void setInvIssDt(String invIssDt) {
		this.invIssDt = invIssDt;
	}
	
	/**
	 * Column Info
	 * @param invToDate
	 */
	public void setInvToDate(String invToDate) {
		this.invToDate = invToDate;
	}
	
	/**
	 * Column Info
	 * @param payLseChgAmt
	 */
	public void setPayLseChgAmt(String payLseChgAmt) {
		this.payLseChgAmt = payLseChgAmt;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Column Info
	 * @param invRcvDt
	 */
	public void setInvRcvDt(String invRcvDt) {
		this.invRcvDt = invRcvDt;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param apIfDt
	 */
	public void setApIfDt(String apIfDt) {
		this.apIfDt = apIfDt;
	}
	
	/**
	 * Column Info
	 * @param invStsCd
	 */
	public void setInvStsCd(String invStsCd) {
		this.invStsCd = invStsCd;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
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
	 * @param invCsrNo
	 */
	public void setInvCsrNo(String invCsrNo) {
		this.invCsrNo = invCsrNo;
	}
	
	/**
	 * Column Info
	 * @param chssMgstInvStsCd
	 */
	public void setChssMgstInvStsCd(String chssMgstInvStsCd) {
		this.chssMgstInvStsCd = chssMgstInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param invFmDate
	 */
	public void setInvFmDate(String invFmDate) {
		this.invFmDate = invFmDate;
	}
	
	/**
	 * Column Info
	 * @param invTaxRt
	 */
	public void setInvTaxRt(String invTaxRt) {
		this.invTaxRt = invTaxRt;
	}
	
	/**
	 * Column Info
	 * @param invStsNm
	 */
	public void setInvStsNm(String invStsNm) {
		this.invStsNm = invStsNm;
	}
	
	/**
	 * Column Info
	 * @param payTaxAmt
	 */
	public void setPayTaxAmt(String payTaxAmt) {
		this.payTaxAmt = payTaxAmt;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param chssMsstInvKndCd
	 */
	public void setChssMsstInvKndCd(String chssMsstInvKndCd) {
		this.chssMsstInvKndCd = chssMsstInvKndCd;
	}
	
	/**
	 * Column Info
	 * @param chssMgstInvKndCd
	 */
	public void setChssMgstInvKndCd(String chssMgstInvKndCd) {
		this.chssMgstInvKndCd = chssMgstInvKndCd;
	}
	
	/**
	 * Column Info
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}
	
	/**
	 * Column Info
	 * @param invCfmDt
	 */
	public void setInvCfmDt(String invCfmDt) {
		this.invCfmDt = invCfmDt;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param agmtLstmCd
	 */
	public void setAgmtLstmCd(String agmtLstmCd) {
		this.agmtLstmCd = agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param chgSmryAmt
	 */
	public void setChgSmryAmt(String chgSmryAmt) {
		this.chgSmryAmt = chgSmryAmt;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param payCrAmt
	 */
	public void setPayCrAmt(String payCrAmt) {
		this.payCrAmt = payCrAmt;
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
	 * @param invCsrNoChk
	 */
	public void setInvCsrNoChk(String invCsrNoChk) {
		this.invCsrNoChk = invCsrNoChk;
	}
	
	/**
	 * Column Info
	 * @param invSmryAmt
	 */
	public void setInvSmryAmt(String invSmryAmt) {
		this.invSmryAmt = invSmryAmt;
	}
	
	/**
	 * Column Info
	 * @param invStatus
	 */
	public void setInvStatus(String invStatus) {
		this.invStatus = invStatus;
	}
	
	/**
	 * Column Info
	 * @param invTaxCltTpCd
	 */
	public void setInvTaxCltTpCd(String invTaxCltTpCd) {
		this.invTaxCltTpCd = invTaxCltTpCd;
	}
	
	/**
	 * Column Info
	 * @param revVvd
	 */
	public void setRevVvd(String revVvd) {
		this.revVvd = revVvd;
	}
	
	/**
	 * Column Info
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInvoiceDate(JSPUtil.getParameter(request, "invoice_date", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setPayInvSeq(JSPUtil.getParameter(request, "pay_inv_seq", ""));
		setInvIssDt(JSPUtil.getParameter(request, "inv_iss_dt", ""));
		setInvToDate(JSPUtil.getParameter(request, "inv_to_date", ""));
		setPayLseChgAmt(JSPUtil.getParameter(request, "pay_lse_chg_amt", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setInvRcvDt(JSPUtil.getParameter(request, "inv_rcv_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, "vndr_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setApIfDt(JSPUtil.getParameter(request, "ap_if_dt", ""));
		setInvStsCd(JSPUtil.getParameter(request, "inv_sts_cd", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setInvCsrNo(JSPUtil.getParameter(request, "inv_csr_no", ""));
		setChssMgstInvStsCd(JSPUtil.getParameter(request, "chss_mgst_inv_sts_cd", ""));
		setInvFmDate(JSPUtil.getParameter(request, "inv_fm_date", ""));
		setInvTaxRt(JSPUtil.getParameter(request, "inv_tax_rt", ""));
		setInvStsNm(JSPUtil.getParameter(request, "inv_sts_nm", ""));
		setPayTaxAmt(JSPUtil.getParameter(request, "pay_tax_amt", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setChssMsstInvKndCd(JSPUtil.getParameter(request, "chss_msst_inv_knd_cd", ""));
		setChssMgstInvKndCd(JSPUtil.getParameter(request, "chss_mgst_inv_knd_cd", ""));
		setCostOfcCd(JSPUtil.getParameter(request, "cost_ofc_cd", ""));
		setInvCfmDt(JSPUtil.getParameter(request, "inv_cfm_dt", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, "agmt_lstm_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setChgSmryAmt(JSPUtil.getParameter(request, "chg_smry_amt", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setPayCrAmt(JSPUtil.getParameter(request, "pay_cr_amt", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setInvCsrNoChk(JSPUtil.getParameter(request, "inv_csr_no_chk", ""));
		setInvSmryAmt(JSPUtil.getParameter(request, "inv_smry_amt", ""));
		setInvStatus(JSPUtil.getParameter(request, "inv_status", ""));
		setInvTaxCltTpCd(JSPUtil.getParameter(request, "inv_tax_clt_tp_cd", ""));
		setRevVvd(JSPUtil.getParameter(request, "rev_vvd", ""));
		setChssPoolCd(JSPUtil.getParameter(request, "chss_pool_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSInvoiceInquiryMGTVO[]
	 */
	public CHSInvoiceInquiryMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSInvoiceInquiryMGTVO[]
	 */
	public CHSInvoiceInquiryMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSInvoiceInquiryMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invoiceDate = (JSPUtil.getParameter(request, prefix	+ "invoice_date", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] payInvSeq = (JSPUtil.getParameter(request, prefix	+ "pay_inv_seq", length));
			String[] invIssDt = (JSPUtil.getParameter(request, prefix	+ "inv_iss_dt", length));
			String[] invToDate = (JSPUtil.getParameter(request, prefix	+ "inv_to_date", length));
			String[] payLseChgAmt = (JSPUtil.getParameter(request, prefix	+ "pay_lse_chg_amt", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] invRcvDt = (JSPUtil.getParameter(request, prefix	+ "inv_rcv_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] apIfDt = (JSPUtil.getParameter(request, prefix	+ "ap_if_dt", length));
			String[] invStsCd = (JSPUtil.getParameter(request, prefix	+ "inv_sts_cd", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] invCsrNo = (JSPUtil.getParameter(request, prefix	+ "inv_csr_no", length));
			String[] chssMgstInvStsCd = (JSPUtil.getParameter(request, prefix	+ "chss_mgst_inv_sts_cd", length));
			String[] invFmDate = (JSPUtil.getParameter(request, prefix	+ "inv_fm_date", length));
			String[] invTaxRt = (JSPUtil.getParameter(request, prefix	+ "inv_tax_rt", length));
			String[] invStsNm = (JSPUtil.getParameter(request, prefix	+ "inv_sts_nm", length));
			String[] payTaxAmt = (JSPUtil.getParameter(request, prefix	+ "pay_tax_amt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] chssMsstInvKndCd = (JSPUtil.getParameter(request, prefix	+ "chss_msst_inv_knd_cd", length));
			String[] chssMgstInvKndCd = (JSPUtil.getParameter(request, prefix	+ "chss_mgst_inv_knd_cd", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] invCfmDt = (JSPUtil.getParameter(request, prefix	+ "inv_cfm_dt", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] chgSmryAmt = (JSPUtil.getParameter(request, prefix	+ "chg_smry_amt", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] payCrAmt = (JSPUtil.getParameter(request, prefix	+ "pay_cr_amt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] invCsrNoChk = (JSPUtil.getParameter(request, prefix	+ "inv_csr_no_chk", length));
			String[] invSmryAmt = (JSPUtil.getParameter(request, prefix	+ "inv_smry_amt", length));
			String[] invStatus = (JSPUtil.getParameter(request, prefix	+ "inv_status", length));
			String[] invTaxCltTpCd = (JSPUtil.getParameter(request, prefix	+ "inv_tax_clt_tp_cd", length));
			String[] revVvd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSInvoiceInquiryMGTVO();
				if (invoiceDate[i] != null)
					model.setInvoiceDate(invoiceDate[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (payInvSeq[i] != null)
					model.setPayInvSeq(payInvSeq[i]);
				if (invIssDt[i] != null)
					model.setInvIssDt(invIssDt[i]);
				if (invToDate[i] != null)
					model.setInvToDate(invToDate[i]);
				if (payLseChgAmt[i] != null)
					model.setPayLseChgAmt(payLseChgAmt[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (invRcvDt[i] != null)
					model.setInvRcvDt(invRcvDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (apIfDt[i] != null)
					model.setApIfDt(apIfDt[i]);
				if (invStsCd[i] != null)
					model.setInvStsCd(invStsCd[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (invCsrNo[i] != null)
					model.setInvCsrNo(invCsrNo[i]);
				if (chssMgstInvStsCd[i] != null)
					model.setChssMgstInvStsCd(chssMgstInvStsCd[i]);
				if (invFmDate[i] != null)
					model.setInvFmDate(invFmDate[i]);
				if (invTaxRt[i] != null)
					model.setInvTaxRt(invTaxRt[i]);
				if (invStsNm[i] != null)
					model.setInvStsNm(invStsNm[i]);
				if (payTaxAmt[i] != null)
					model.setPayTaxAmt(payTaxAmt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (chssMsstInvKndCd[i] != null)
					model.setChssMsstInvKndCd(chssMsstInvKndCd[i]);
				if (chssMgstInvKndCd[i] != null)
					model.setChssMgstInvKndCd(chssMgstInvKndCd[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (invCfmDt[i] != null)
					model.setInvCfmDt(invCfmDt[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (chgSmryAmt[i] != null)
					model.setChgSmryAmt(chgSmryAmt[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (payCrAmt[i] != null)
					model.setPayCrAmt(payCrAmt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (invCsrNoChk[i] != null)
					model.setInvCsrNoChk(invCsrNoChk[i]);
				if (invSmryAmt[i] != null)
					model.setInvSmryAmt(invSmryAmt[i]);
				if (invStatus[i] != null)
					model.setInvStatus(invStatus[i]);
				if (invTaxCltTpCd[i] != null)
					model.setInvTaxCltTpCd(invTaxCltTpCd[i]);
				if (revVvd[i] != null)
					model.setRevVvd(revVvd[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSInvoiceInquiryMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSInvoiceInquiryMGTVO[]
	 */
	public CHSInvoiceInquiryMGTVO[] getCHSInvoiceInquiryMGTVOs(){
		CHSInvoiceInquiryMGTVO[] vos = (CHSInvoiceInquiryMGTVO[])models.toArray(new CHSInvoiceInquiryMGTVO[models.size()]);
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
		this.invoiceDate = this.invoiceDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payInvSeq = this.payInvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssDt = this.invIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invToDate = this.invToDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payLseChgAmt = this.payLseChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRcvDt = this.invRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apIfDt = this.apIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invStsCd = this.invStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCsrNo = this.invCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMgstInvStsCd = this.chssMgstInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invFmDate = this.invFmDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTaxRt = this.invTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invStsNm = this.invStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTaxAmt = this.payTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMsstInvKndCd = this.chssMsstInvKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMgstInvKndCd = this.chssMgstInvKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCfmDt = this.invCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSmryAmt = this.chgSmryAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payCrAmt = this.payCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCsrNoChk = this.invCsrNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSmryAmt = this.invSmryAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invStatus = this.invStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTaxCltTpCd = this.invTaxCltTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvd = this.revVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
