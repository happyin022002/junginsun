/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MGSPayableInvoiceCreationMGTVO.java
*@FileTitle : MGSPayableInvoiceCreationMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.10.12 김창식 
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
 * @author 김창식
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MGSPayableInvoiceCreationMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MGSPayableInvoiceCreationMGTVO> models = new ArrayList<MGSPayableInvoiceCreationMGTVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String payInvSeq = null;
	/* Column Info */
	private String chgCreSeq = null;
	/* Column Info */
	private String invIssDt = null;
	/* Column Info */
	private String invRcvDt = null;
	/* Column Info */
	private String payLseChgAmt = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String revDirCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String chssMgstInvStsCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String invTaxRt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String invRgstNo = null;
	/* Column Info */
	private String invEffDt = null;
	/* Column Info */
	private String payTaxAmt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String chssMgstInvKndCd = null;
	/* Column Info */
	private String revSkdDirCd = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String genPayTermCd = null;
	/* Column Info */
	private String revSkdVoyNo = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String invCfmDt = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String chgSmryAmt = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String revVslCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String statusCd = null;
	/* Column Info */
	private String payCrAmt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String invSmryAmt = null;
	/* Column Info */
	private String invTaxCltTpCd = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String revVvd = null;
	/* Column Info */
	private String intgCdValCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MGSPayableInvoiceCreationMGTVO() {}

	public MGSPayableInvoiceCreationMGTVO(String ibflag, String pagerows, String eqKndCd, String intgCdValCtnt, String costOfcCd, String vndrSeq, String chssMgstInvKndCd, String chssMgstInvStsCd, String payInvSeq, String costYrmon, String revVvd, String invNo, String revVslCd, String revSkdVoyNo, String revSkdDirCd, String revDirCd, String chgSmryAmt, String invTaxCltTpCd, String invTaxRt, String csrNo, String invSmryAmt, String status, String statusCd, String chgCreSeq, String agmtOfcCtyCd, String agmtSeq, String agmtVerNo, String agmtNo, String eqNo, String eqTpszCd, String chgCd, String costCd, String acctCd, String currCd, String payTaxAmt, String payCrAmt, String payLseChgAmt, String creUsrId, String updUsrId, String invRcvDt, String invIssDt, String invEffDt, String invCfmDt, String genPayTermCd, String invAmt, String invRgstNo) {
		this.currCd = currCd;
		this.payInvSeq = payInvSeq;
		this.chgCreSeq = chgCreSeq;
		this.invIssDt = invIssDt;
		this.invRcvDt = invRcvDt;
		this.payLseChgAmt = payLseChgAmt;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.revDirCd = revDirCd;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.costYrmon = costYrmon;
		this.costCd = costCd;
		this.acctCd = acctCd;
		this.chssMgstInvStsCd = chssMgstInvStsCd;
		this.invAmt = invAmt;
		this.invTaxRt = invTaxRt;
		this.updUsrId = updUsrId;
		this.invRgstNo = invRgstNo;
		this.invEffDt = invEffDt;
		this.payTaxAmt = payTaxAmt;
		this.csrNo = csrNo;
		this.chssMgstInvKndCd = chssMgstInvKndCd;
		this.revSkdDirCd = revSkdDirCd;
		this.costOfcCd = costOfcCd;
		this.genPayTermCd = genPayTermCd;
		this.revSkdVoyNo = revSkdVoyNo;
		this.status = status;
		this.agmtSeq = agmtSeq;
		this.invCfmDt = invCfmDt;
		this.agmtNo = agmtNo;
		this.eqKndCd = eqKndCd;
		this.chgSmryAmt = chgSmryAmt;
		this.eqTpszCd = eqTpszCd;
		this.revVslCd = revVslCd;
		this.invNo = invNo;
		this.creUsrId = creUsrId;
		this.statusCd = statusCd;
		this.payCrAmt = payCrAmt;
		this.vndrSeq = vndrSeq;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.invSmryAmt = invSmryAmt;
		this.invTaxCltTpCd = invTaxCltTpCd;
		this.agmtVerNo = agmtVerNo;
		this.revVvd = revVvd;
		this.intgCdValCtnt = intgCdValCtnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("pay_inv_seq", getPayInvSeq());
		this.hashColumns.put("chg_cre_seq", getChgCreSeq());
		this.hashColumns.put("inv_iss_dt", getInvIssDt());
		this.hashColumns.put("inv_rcv_dt", getInvRcvDt());
		this.hashColumns.put("pay_lse_chg_amt", getPayLseChgAmt());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("chss_mgst_inv_sts_cd", getChssMgstInvStsCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("inv_tax_rt", getInvTaxRt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("inv_rgst_no", getInvRgstNo());
		this.hashColumns.put("inv_eff_dt", getInvEffDt());
		this.hashColumns.put("pay_tax_amt", getPayTaxAmt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("chss_mgst_inv_knd_cd", getChssMgstInvKndCd());
		this.hashColumns.put("rev_skd_dir_cd", getRevSkdDirCd());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("gen_pay_term_cd", getGenPayTermCd());
		this.hashColumns.put("rev_skd_voy_no", getRevSkdVoyNo());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("inv_cfm_dt", getInvCfmDt());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("chg_smry_amt", getChgSmryAmt());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("rev_vsl_cd", getRevVslCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("status_cd", getStatusCd());
		this.hashColumns.put("pay_cr_amt", getPayCrAmt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("inv_smry_amt", getInvSmryAmt());
		this.hashColumns.put("inv_tax_clt_tp_cd", getInvTaxCltTpCd());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("rev_vvd", getRevVvd());
		this.hashColumns.put("intg_cd_val_ctnt", getIntgCdValCtnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pay_inv_seq", "payInvSeq");
		this.hashFields.put("chg_cre_seq", "chgCreSeq");
		this.hashFields.put("inv_iss_dt", "invIssDt");
		this.hashFields.put("inv_rcv_dt", "invRcvDt");
		this.hashFields.put("pay_lse_chg_amt", "payLseChgAmt");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("chss_mgst_inv_sts_cd", "chssMgstInvStsCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("inv_tax_rt", "invTaxRt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_rgst_no", "invRgstNo");
		this.hashFields.put("inv_eff_dt", "invEffDt");
		this.hashFields.put("pay_tax_amt", "payTaxAmt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("chss_mgst_inv_knd_cd", "chssMgstInvKndCd");
		this.hashFields.put("rev_skd_dir_cd", "revSkdDirCd");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("gen_pay_term_cd", "genPayTermCd");
		this.hashFields.put("rev_skd_voy_no", "revSkdVoyNo");
		this.hashFields.put("status", "status");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("inv_cfm_dt", "invCfmDt");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("chg_smry_amt", "chgSmryAmt");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("rev_vsl_cd", "revVslCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("status_cd", "statusCd");
		this.hashFields.put("pay_cr_amt", "payCrAmt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("inv_smry_amt", "invSmryAmt");
		this.hashFields.put("inv_tax_clt_tp_cd", "invTaxCltTpCd");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("rev_vvd", "revVvd");
		this.hashFields.put("intg_cd_val_ctnt", "intgCdValCtnt");
		return this.hashFields;
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
	 * @return chgCreSeq
	 */
	public String getChgCreSeq() {
		return this.chgCreSeq;
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
	 * @return invRcvDt
	 */
	public String getInvRcvDt() {
		return this.invRcvDt;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
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
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
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
	 * @return chssMgstInvStsCd
	 */
	public String getChssMgstInvStsCd() {
		return this.chssMgstInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return invRgstNo
	 */
	public String getInvRgstNo() {
		return this.invRgstNo;
	}
	
	/**
	 * Column Info
	 * @return invEffDt
	 */
	public String getInvEffDt() {
		return this.invEffDt;
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
	 * @return chssMgstInvKndCd
	 */
	public String getChssMgstInvKndCd() {
		return this.chssMgstInvKndCd;
	}
	
	/**
	 * Column Info
	 * @return revSkdDirCd
	 */
	public String getRevSkdDirCd() {
		return this.revSkdDirCd;
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
	 * @return genPayTermCd
	 */
	public String getGenPayTermCd() {
		return this.genPayTermCd;
	}
	
	/**
	 * Column Info
	 * @return revSkdVoyNo
	 */
	public String getRevSkdVoyNo() {
		return this.revSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
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
	 * @return revVslCd
	 */
	public String getRevVslCd() {
		return this.revVslCd;
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
	 * @return statusCd
	 */
	public String getStatusCd() {
		return this.statusCd;
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
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
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
	 * @return invTaxCltTpCd
	 */
	public String getInvTaxCltTpCd() {
		return this.invTaxCltTpCd;
	}
	
	/**
	 * Column Info
	 * @return agmtVerNo
	 */
	public String getAgmtVerNo() {
		return this.agmtVerNo;
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
	 * @return intgCdValCtnt
	 */
	public String getIntgCdValCtnt() {
		return this.intgCdValCtnt;
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
	 * @param chgCreSeq
	 */
	public void setChgCreSeq(String chgCreSeq) {
		this.chgCreSeq = chgCreSeq;
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
	 * @param invRcvDt
	 */
	public void setInvRcvDt(String invRcvDt) {
		this.invRcvDt = invRcvDt;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
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
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
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
	 * @param chssMgstInvStsCd
	 */
	public void setChssMgstInvStsCd(String chssMgstInvStsCd) {
		this.chssMgstInvStsCd = chssMgstInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param invRgstNo
	 */
	public void setInvRgstNo(String invRgstNo) {
		this.invRgstNo = invRgstNo;
	}
	
	/**
	 * Column Info
	 * @param invEffDt
	 */
	public void setInvEffDt(String invEffDt) {
		this.invEffDt = invEffDt;
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
	 * @param chssMgstInvKndCd
	 */
	public void setChssMgstInvKndCd(String chssMgstInvKndCd) {
		this.chssMgstInvKndCd = chssMgstInvKndCd;
	}
	
	/**
	 * Column Info
	 * @param revSkdDirCd
	 */
	public void setRevSkdDirCd(String revSkdDirCd) {
		this.revSkdDirCd = revSkdDirCd;
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
	 * @param genPayTermCd
	 */
	public void setGenPayTermCd(String genPayTermCd) {
		this.genPayTermCd = genPayTermCd;
	}
	
	/**
	 * Column Info
	 * @param revSkdVoyNo
	 */
	public void setRevSkdVoyNo(String revSkdVoyNo) {
		this.revSkdVoyNo = revSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
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
	 * @param revVslCd
	 */
	public void setRevVslCd(String revVslCd) {
		this.revVslCd = revVslCd;
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
	 * @param statusCd
	 */
	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
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
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
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
	 * @param invTaxCltTpCd
	 */
	public void setInvTaxCltTpCd(String invTaxCltTpCd) {
		this.invTaxCltTpCd = invTaxCltTpCd;
	}
	
	/**
	 * Column Info
	 * @param agmtVerNo
	 */
	public void setAgmtVerNo(String agmtVerNo) {
		this.agmtVerNo = agmtVerNo;
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
	 * @param intgCdValCtnt
	 */
	public void setIntgCdValCtnt(String intgCdValCtnt) {
		this.intgCdValCtnt = intgCdValCtnt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setPayInvSeq(JSPUtil.getParameter(request, "pay_inv_seq", ""));
		setChgCreSeq(JSPUtil.getParameter(request, "chg_cre_seq", ""));
		setInvIssDt(JSPUtil.getParameter(request, "inv_iss_dt", ""));
		setInvRcvDt(JSPUtil.getParameter(request, "inv_rcv_dt", ""));
		setPayLseChgAmt(JSPUtil.getParameter(request, "pay_lse_chg_amt", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRevDirCd(JSPUtil.getParameter(request, "rev_dir_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setCostCd(JSPUtil.getParameter(request, "cost_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setChssMgstInvStsCd(JSPUtil.getParameter(request, "chss_mgst_inv_sts_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setInvTaxRt(JSPUtil.getParameter(request, "inv_tax_rt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setInvRgstNo(JSPUtil.getParameter(request, "inv_rgst_no", ""));
		setInvEffDt(JSPUtil.getParameter(request, "inv_eff_dt", ""));
		setPayTaxAmt(JSPUtil.getParameter(request, "pay_tax_amt", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setChssMgstInvKndCd(JSPUtil.getParameter(request, "chss_mgst_inv_knd_cd", ""));
		setRevSkdDirCd(JSPUtil.getParameter(request, "rev_skd_dir_cd", ""));
		setCostOfcCd(JSPUtil.getParameter(request, "cost_ofc_cd", ""));
		setGenPayTermCd(JSPUtil.getParameter(request, "gen_pay_term_cd", ""));
		setRevSkdVoyNo(JSPUtil.getParameter(request, "rev_skd_voy_no", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setInvCfmDt(JSPUtil.getParameter(request, "inv_cfm_dt", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setChgSmryAmt(JSPUtil.getParameter(request, "chg_smry_amt", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setRevVslCd(JSPUtil.getParameter(request, "rev_vsl_cd", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setStatusCd(JSPUtil.getParameter(request, "status_cd", ""));
		setPayCrAmt(JSPUtil.getParameter(request, "pay_cr_amt", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setInvSmryAmt(JSPUtil.getParameter(request, "inv_smry_amt", ""));
		setInvTaxCltTpCd(JSPUtil.getParameter(request, "inv_tax_clt_tp_cd", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, "agmt_ver_no", ""));
		setRevVvd(JSPUtil.getParameter(request, "rev_vvd", ""));
		setIntgCdValCtnt(JSPUtil.getParameter(request, "intg_cd_val_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MGSPayableInvoiceCreationMGTVO[]
	 */
	public MGSPayableInvoiceCreationMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MGSPayableInvoiceCreationMGTVO[]
	 */
	public MGSPayableInvoiceCreationMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MGSPayableInvoiceCreationMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] payInvSeq = (JSPUtil.getParameter(request, prefix	+ "pay_inv_seq", length));
			String[] chgCreSeq = (JSPUtil.getParameter(request, prefix	+ "chg_cre_seq", length));
			String[] invIssDt = (JSPUtil.getParameter(request, prefix	+ "inv_iss_dt", length));
			String[] invRcvDt = (JSPUtil.getParameter(request, prefix	+ "inv_rcv_dt", length));
			String[] payLseChgAmt = (JSPUtil.getParameter(request, prefix	+ "pay_lse_chg_amt", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] chssMgstInvStsCd = (JSPUtil.getParameter(request, prefix	+ "chss_mgst_inv_sts_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] invTaxRt = (JSPUtil.getParameter(request, prefix	+ "inv_tax_rt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] invRgstNo = (JSPUtil.getParameter(request, prefix	+ "inv_rgst_no", length));
			String[] invEffDt = (JSPUtil.getParameter(request, prefix	+ "inv_eff_dt", length));
			String[] payTaxAmt = (JSPUtil.getParameter(request, prefix	+ "pay_tax_amt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] chssMgstInvKndCd = (JSPUtil.getParameter(request, prefix	+ "chss_mgst_inv_knd_cd", length));
			String[] revSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_skd_dir_cd", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] genPayTermCd = (JSPUtil.getParameter(request, prefix	+ "gen_pay_term_cd", length));
			String[] revSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "rev_skd_voy_no", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] invCfmDt = (JSPUtil.getParameter(request, prefix	+ "inv_cfm_dt", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] chgSmryAmt = (JSPUtil.getParameter(request, prefix	+ "chg_smry_amt", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] revVslCd = (JSPUtil.getParameter(request, prefix	+ "rev_vsl_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] statusCd = (JSPUtil.getParameter(request, prefix	+ "status_cd", length));
			String[] payCrAmt = (JSPUtil.getParameter(request, prefix	+ "pay_cr_amt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] invSmryAmt = (JSPUtil.getParameter(request, prefix	+ "inv_smry_amt", length));
			String[] invTaxCltTpCd = (JSPUtil.getParameter(request, prefix	+ "inv_tax_clt_tp_cd", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] revVvd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd", length));
			String[] intgCdValCtnt = (JSPUtil.getParameter(request, prefix	+ "intg_cd_val_ctnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new MGSPayableInvoiceCreationMGTVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (payInvSeq[i] != null)
					model.setPayInvSeq(payInvSeq[i]);
				if (chgCreSeq[i] != null)
					model.setChgCreSeq(chgCreSeq[i]);
				if (invIssDt[i] != null)
					model.setInvIssDt(invIssDt[i]);
				if (invRcvDt[i] != null)
					model.setInvRcvDt(invRcvDt[i]);
				if (payLseChgAmt[i] != null)
					model.setPayLseChgAmt(payLseChgAmt[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (chssMgstInvStsCd[i] != null)
					model.setChssMgstInvStsCd(chssMgstInvStsCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (invTaxRt[i] != null)
					model.setInvTaxRt(invTaxRt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (invRgstNo[i] != null)
					model.setInvRgstNo(invRgstNo[i]);
				if (invEffDt[i] != null)
					model.setInvEffDt(invEffDt[i]);
				if (payTaxAmt[i] != null)
					model.setPayTaxAmt(payTaxAmt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (chssMgstInvKndCd[i] != null)
					model.setChssMgstInvKndCd(chssMgstInvKndCd[i]);
				if (revSkdDirCd[i] != null)
					model.setRevSkdDirCd(revSkdDirCd[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (genPayTermCd[i] != null)
					model.setGenPayTermCd(genPayTermCd[i]);
				if (revSkdVoyNo[i] != null)
					model.setRevSkdVoyNo(revSkdVoyNo[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (invCfmDt[i] != null)
					model.setInvCfmDt(invCfmDt[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (chgSmryAmt[i] != null)
					model.setChgSmryAmt(chgSmryAmt[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (revVslCd[i] != null)
					model.setRevVslCd(revVslCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (statusCd[i] != null)
					model.setStatusCd(statusCd[i]);
				if (payCrAmt[i] != null)
					model.setPayCrAmt(payCrAmt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (invSmryAmt[i] != null)
					model.setInvSmryAmt(invSmryAmt[i]);
				if (invTaxCltTpCd[i] != null)
					model.setInvTaxCltTpCd(invTaxCltTpCd[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (revVvd[i] != null)
					model.setRevVvd(revVvd[i]);
				if (intgCdValCtnt[i] != null)
					model.setIntgCdValCtnt(intgCdValCtnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMGSPayableInvoiceCreationMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MGSPayableInvoiceCreationMGTVO[]
	 */
	public MGSPayableInvoiceCreationMGTVO[] getMGSPayableInvoiceCreationMGTVOs(){
		MGSPayableInvoiceCreationMGTVO[] vos = (MGSPayableInvoiceCreationMGTVO[])models.toArray(new MGSPayableInvoiceCreationMGTVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payInvSeq = this.payInvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCreSeq = this.chgCreSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssDt = this.invIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRcvDt = this.invRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payLseChgAmt = this.payLseChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMgstInvStsCd = this.chssMgstInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTaxRt = this.invTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRgstNo = this.invRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEffDt = this.invEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTaxAmt = this.payTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMgstInvKndCd = this.chssMgstInvKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revSkdDirCd = this.revSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genPayTermCd = this.genPayTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revSkdVoyNo = this.revSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCfmDt = this.invCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSmryAmt = this.chgSmryAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVslCd = this.revVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusCd = this.statusCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payCrAmt = this.payCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSmryAmt = this.invSmryAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTaxCltTpCd = this.invTaxCltTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvd = this.revVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdValCtnt = this.intgCdValCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
