/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomMnrPayInvWrkVO.java
*@FileTitle : CustomMnrPayInvWrkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.24
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.09.24 박명신 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;
	
/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrPayInvWrkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	 
	private Collection<CustomMnrPayInvWrkVO> models = new ArrayList<CustomMnrPayInvWrkVO>();
	
	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String mnrInvRjctFlg = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String payInvSeq = null;
	/* Column Info */
	private String mnrGrpTpCd = null;
	/* Column Info */
	private String invPayMzdCd = null;
	/* Column Info */
	private String mnrInpTpCd = null;
	/* Column Info */
	private String issOfcCd = null;
	/* Column Info */
	private String mnrPrnrCntCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnrPrnrSeq = null;
	/* Column Info */
	private String issDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String mnrInvStsCd = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String mnrInvRjctDt = null;
	/* Column Info */
	private String provUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mnrInvRmk = null;
	/* Column Info */
	private String invRgstNo = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String genPayTermCd = null;
	/* Column Info */
	private String invCfmDt = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String mnrPrnrTpCd = null;
	/* Column Info */
	private String bzcAmt = null;
	/* Column Info */
	private String mnrInvRefNo = null;
	/* Column Info */
	private String whldTaxAmt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String slsTaxAmt = null;
	/* Column Info */
	private String vatAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ttlLssDivCd = null;
	/* Column Info */
	private String hldFlg = null;
	/* Column Info */
	private String ordVndrSeq = null;
	/* Column Info */
	private String chkTrnsNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomMnrPayInvWrkVO() {}

	public CustomMnrPayInvWrkVO(String ibflag, String pagerows, String mnrInvRjctFlg, String payDt, String glDt, String currCd, String payInvSeq, String mnrGrpTpCd, String issOfcCd, String mnrInpTpCd, String invPayMzdCd, String creDt, String mnrPrnrCntCd, String ttlAmt, String mnrPrnrSeq, String issDt, String effDt, String mnrInvStsCd, String rcvDt, String mnrInvRjctDt, String provUsrId, String updUsrId, String mnrInvRmk, String invRgstNo, String updDt, String csrNo, String genPayTermCd, String cfmDt, String invCfmDt, String mnrPrnrTpCd, String mnrInvRefNo, String bzcAmt, String whldTaxAmt, String invNo, String creUsrId, String vatAmt, String ttlLssDivCd, String hldFlg, String ordVndrSeq, String chkTrnsNo, String slsTaxAmt) {
		this.payDt = payDt;
		this.mnrInvRjctFlg = mnrInvRjctFlg;
		this.glDt = glDt;
		this.currCd = currCd;
		this.payInvSeq = payInvSeq;
		this.mnrGrpTpCd = mnrGrpTpCd;
		this.invPayMzdCd = invPayMzdCd;
		this.mnrInpTpCd = mnrInpTpCd;
		this.issOfcCd = issOfcCd;
		this.mnrPrnrCntCd = mnrPrnrCntCd;
		this.creDt = creDt;
		this.ttlAmt = ttlAmt;
		this.pagerows = pagerows;
		this.mnrPrnrSeq = mnrPrnrSeq;
		this.issDt = issDt;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.mnrInvStsCd = mnrInvStsCd;
		this.rcvDt = rcvDt;
		this.mnrInvRjctDt = mnrInvRjctDt;
		this.provUsrId = provUsrId;
		this.updUsrId = updUsrId;
		this.mnrInvRmk = mnrInvRmk;
		this.invRgstNo = invRgstNo;
		this.updDt = updDt;
		this.csrNo = csrNo;
		this.genPayTermCd = genPayTermCd;
		this.invCfmDt = invCfmDt;
		this.cfmDt = cfmDt;
		this.mnrPrnrTpCd = mnrPrnrTpCd;
		this.bzcAmt = bzcAmt;
		this.mnrInvRefNo = mnrInvRefNo;
		this.whldTaxAmt = whldTaxAmt;
		this.invNo = invNo;
		this.slsTaxAmt = slsTaxAmt;
		this.vatAmt = vatAmt;
		this.creUsrId = creUsrId;
		this.ttlLssDivCd = ttlLssDivCd;
		this.hldFlg = hldFlg;
		this.ordVndrSeq = ordVndrSeq;
		this.chkTrnsNo = chkTrnsNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("mnr_inv_rjct_flg", getMnrInvRjctFlg());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("pay_inv_seq", getPayInvSeq());
		this.hashColumns.put("mnr_grp_tp_cd", getMnrGrpTpCd());
		this.hashColumns.put("inv_pay_mzd_cd", getInvPayMzdCd());
		this.hashColumns.put("mnr_inp_tp_cd", getMnrInpTpCd());
		this.hashColumns.put("iss_ofc_cd", getIssOfcCd());
		this.hashColumns.put("mnr_prnr_cnt_cd", getMnrPrnrCntCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_prnr_seq", getMnrPrnrSeq());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("mnr_inv_sts_cd", getMnrInvStsCd());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("mnr_inv_rjct_dt", getMnrInvRjctDt());
		this.hashColumns.put("prov_usr_id", getProvUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mnr_inv_rmk", getMnrInvRmk());
		this.hashColumns.put("inv_rgst_no", getInvRgstNo());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("gen_pay_term_cd", getGenPayTermCd());
		this.hashColumns.put("inv_cfm_dt", getInvCfmDt());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("mnr_prnr_tp_cd", getMnrPrnrTpCd());
		this.hashColumns.put("bzc_amt", getBzcAmt());
		this.hashColumns.put("mnr_inv_ref_no", getMnrInvRefNo());
		this.hashColumns.put("whld_tax_amt", getWhldTaxAmt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("sls_tax_amt", getSlsTaxAmt());
		this.hashColumns.put("vat_amt", getVatAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ttl_lss_div_cd", getTtlLssDivCd());
		this.hashColumns.put("hld_flg", getHldFlg());
		this.hashColumns.put("ord_vndr_seq", getOrdVndrSeq());
		this.hashColumns.put("chk_trns_no", getChkTrnsNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("mnr_inv_rjct_flg", "mnrInvRjctFlg");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pay_inv_seq", "payInvSeq");
		this.hashFields.put("mnr_grp_tp_cd", "mnrGrpTpCd");
		this.hashFields.put("inv_pay_mzd_cd", "invPayMzdCd");
		this.hashFields.put("mnr_inp_tp_cd", "mnrInpTpCd");
		this.hashFields.put("iss_ofc_cd", "issOfcCd");
		this.hashFields.put("mnr_prnr_cnt_cd", "mnrPrnrCntCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_prnr_seq", "mnrPrnrSeq");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("mnr_inv_sts_cd", "mnrInvStsCd");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("mnr_inv_rjct_dt", "mnrInvRjctDt");
		this.hashFields.put("prov_usr_id", "provUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mnr_inv_rmk", "mnrInvRmk");
		this.hashFields.put("inv_rgst_no", "invRgstNo");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("gen_pay_term_cd", "genPayTermCd");
		this.hashFields.put("inv_cfm_dt", "invCfmDt");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("mnr_prnr_tp_cd", "mnrPrnrTpCd");
		this.hashFields.put("bzc_amt", "bzcAmt");
		this.hashFields.put("mnr_inv_ref_no", "mnrInvRefNo");
		this.hashFields.put("whld_tax_amt", "whldTaxAmt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("sls_tax_amt", "slsTaxAmt");
		this.hashFields.put("vat_amt", "vatAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ttl_lss_div_cd", "ttlLssDivCd");
		this.hashFields.put("hld_flg", "hldFlg");
		this.hashFields.put("ord_vndr_seq", "ordVndrSeq");
		this.hashFields.put("chk_trns_no", "chkTrnsNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return payDt
	 */
	public String getPayDt() {
		return this.payDt;
	}
	
	/**
	 * Column Info
	 * @return mnrInvRjctFlg
	 */
	public String getMnrInvRjctFlg() {
		return this.mnrInvRjctFlg;
	}
	
	/**
	 * Column Info
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
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
	 * @return mnrGrpTpCd
	 */
	public String getMnrGrpTpCd() {
		return this.mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return invPayMzdCd
	 */
	public String getInvPayMzdCd() {
		return this.invPayMzdCd;
	}
	
	/**
	 * Column Info
	 * @return mnrInpTpCd
	 */
	public String getMnrInpTpCd() {
		return this.mnrInpTpCd;
	}
	
	/**
	 * Column Info
	 * @return issOfcCd
	 */
	public String getIssOfcCd() {
		return this.issOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrCntCd
	 */
	public String getMnrPrnrCntCd() {
		return this.mnrPrnrCntCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
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
	 * @return mnrPrnrSeq
	 */
	public String getMnrPrnrSeq() {
		return this.mnrPrnrSeq;
	}
	
	/**
	 * Column Info
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return mnrInvStsCd
	 */
	public String getMnrInvStsCd() {
		return this.mnrInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return mnrInvRjctDt
	 */
	public String getMnrInvRjctDt() {
		return this.mnrInvRjctDt;
	}
	
	/**
	 * Column Info
	 * @return provUsrId
	 */
	public String getProvUsrId() {
		return this.provUsrId;
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
	 * @return mnrInvRmk
	 */
	public String getMnrInvRmk() {
		return this.mnrInvRmk;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return genPayTermCd
	 */
	public String getGenPayTermCd() {
		return this.genPayTermCd;
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
	 * @return cfmDt
	 */
	public String getCfmDt() {
		return this.cfmDt;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrTpCd
	 */
	public String getMnrPrnrTpCd() {
		return this.mnrPrnrTpCd;
	}
	
	/**
	 * Column Info
	 * @return bzcAmt
	 */
	public String getBzcAmt() {
		return this.bzcAmt;
	}
	
	/**
	 * Column Info
	 * @return mnrInvRefNo
	 */
	public String getMnrInvRefNo() {
		return this.mnrInvRefNo;
	}
	
	/**
	 * Column Info
	 * @return whldTaxAmt
	 */
	public String getWhldTaxAmt() {
		return this.whldTaxAmt;
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
	 * @return slsTaxAmt
	 */
	public String getSlsTaxAmt() {
		return this.slsTaxAmt;
	}
	
	/**
	 * Column Info
	 * @return vatAmt
	 */
	public String getVatAmt() {
		return this.vatAmt;
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
	 * @return ttlLssDivCd
	 */
	public String getTtlLssDivCd() {
		return this.ttlLssDivCd;
	}
	
	/**
	 * Column Info
	 * @return hldFlg
	 */
	public String getHldFlg() {
		return this.hldFlg;
	}
	
	/**
	 * Column Info
	 * @return ordVndrSeq
	 */
	public String getOrdVndrSeq() {
		return this.ordVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return chkTrnsNo
	 */
	public String getChkTrnsNo() {
		return this.chkTrnsNo;
	}
	

	/**
	 * Column Info
	 * @param payDt
	 */
	public void setPayDt(String payDt) {
		this.payDt = payDt;
	}
	
	/**
	 * Column Info
	 * @param mnrInvRjctFlg
	 */
	public void setMnrInvRjctFlg(String mnrInvRjctFlg) {
		this.mnrInvRjctFlg = mnrInvRjctFlg;
	}
	
	/**
	 * Column Info
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
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
	 * @param mnrGrpTpCd
	 */
	public void setMnrGrpTpCd(String mnrGrpTpCd) {
		this.mnrGrpTpCd = mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param invPayMzdCd
	 */
	public void setInvPayMzdCd(String invPayMzdCd) {
		this.invPayMzdCd = invPayMzdCd;
	}
	
	/**
	 * Column Info
	 * @param mnrInpTpCd
	 */
	public void setMnrInpTpCd(String mnrInpTpCd) {
		this.mnrInpTpCd = mnrInpTpCd;
	}
	
	/**
	 * Column Info
	 * @param issOfcCd
	 */
	public void setIssOfcCd(String issOfcCd) {
		this.issOfcCd = issOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrCntCd
	 */
	public void setMnrPrnrCntCd(String mnrPrnrCntCd) {
		this.mnrPrnrCntCd = mnrPrnrCntCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
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
	 * @param mnrPrnrSeq
	 */
	public void setMnrPrnrSeq(String mnrPrnrSeq) {
		this.mnrPrnrSeq = mnrPrnrSeq;
	}
	
	/**
	 * Column Info
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param mnrInvStsCd
	 */
	public void setMnrInvStsCd(String mnrInvStsCd) {
		this.mnrInvStsCd = mnrInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param mnrInvRjctDt
	 */
	public void setMnrInvRjctDt(String mnrInvRjctDt) {
		this.mnrInvRjctDt = mnrInvRjctDt;
	}
	
	/**
	 * Column Info
	 * @param provUsrId
	 */
	public void setProvUsrId(String provUsrId) {
		this.provUsrId = provUsrId;
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
	 * @param mnrInvRmk
	 */
	public void setMnrInvRmk(String mnrInvRmk) {
		this.mnrInvRmk = mnrInvRmk;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param genPayTermCd
	 */
	public void setGenPayTermCd(String genPayTermCd) {
		this.genPayTermCd = genPayTermCd;
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
	 * @param cfmDt
	 */
	public void setCfmDt(String cfmDt) {
		this.cfmDt = cfmDt;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrTpCd
	 */
	public void setMnrPrnrTpCd(String mnrPrnrTpCd) {
		this.mnrPrnrTpCd = mnrPrnrTpCd;
	}
	
	/**
	 * Column Info
	 * @param bzcAmt
	 */
	public void setBzcAmt(String bzcAmt) {
		this.bzcAmt = bzcAmt;
	}
	
	/**
	 * Column Info
	 * @param mnrInvRefNo
	 */
	public void setMnrInvRefNo(String mnrInvRefNo) {
		this.mnrInvRefNo = mnrInvRefNo;
	}
	
	/**
	 * Column Info
	 * @param whldTaxAmt
	 */
	public void setWhldTaxAmt(String whldTaxAmt) {
		this.whldTaxAmt = whldTaxAmt;
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
	 * @param slsTaxAmt
	 */
	public void setSlsTaxAmt(String slsTaxAmt) {
		this.slsTaxAmt = slsTaxAmt;
	}
	
	/**
	 * Column Info
	 * @param vatAmt
	 */
	public void setVatAmt(String vatAmt) {
		this.vatAmt = vatAmt;
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
	 * @param ttlLssDivCd
	 */
	public void setTtlLssDivCd(String ttlLssDivCd) {
		this.ttlLssDivCd = ttlLssDivCd;
	}
	
	/**
	 * Column Info
	 * @param hldFlg
	 */
	public void setHldFlg(String hldFlg) {
		this.hldFlg = hldFlg;
	}
	
	/**
	 * Column Info
	 * @param ordVndrSeq
	 */
	public void setOrdVndrSeq(String ordVndrSeq) {
		this.ordVndrSeq = ordVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param chkTrnsNo
	 */
	public void setChkTrnsNo(String chkTrnsNo) {
		this.chkTrnsNo = chkTrnsNo;
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
		setPayDt(JSPUtil.getParameter(request, prefix + "pay_dt", ""));
		setMnrInvRjctFlg(JSPUtil.getParameter(request, prefix + "mnr_inv_rjct_flg", ""));
		setGlDt(JSPUtil.getParameter(request, prefix + "gl_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPayInvSeq(JSPUtil.getParameter(request, prefix + "pay_inv_seq", ""));
		setMnrGrpTpCd(JSPUtil.getParameter(request, prefix + "mnr_grp_tp_cd", ""));
		setInvPayMzdCd(JSPUtil.getParameter(request, prefix + "inv_pay_mzd_cd", ""));
		setMnrInpTpCd(JSPUtil.getParameter(request, prefix + "mnr_inp_tp_cd", ""));
		setIssOfcCd(JSPUtil.getParameter(request, prefix + "iss_ofc_cd", ""));
		setMnrPrnrCntCd(JSPUtil.getParameter(request, prefix + "mnr_prnr_cnt_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMnrPrnrSeq(JSPUtil.getParameter(request, prefix + "mnr_prnr_seq", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setMnrInvStsCd(JSPUtil.getParameter(request, prefix + "mnr_inv_sts_cd", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setMnrInvRjctDt(JSPUtil.getParameter(request, prefix + "mnr_inv_rjct_dt", ""));
		setProvUsrId(JSPUtil.getParameter(request, prefix + "prov_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setMnrInvRmk(JSPUtil.getParameter(request, prefix + "mnr_inv_rmk", ""));
		setInvRgstNo(JSPUtil.getParameter(request, prefix + "inv_rgst_no", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setGenPayTermCd(JSPUtil.getParameter(request, prefix + "gen_pay_term_cd", ""));
		setInvCfmDt(JSPUtil.getParameter(request, prefix + "inv_cfm_dt", ""));
		setCfmDt(JSPUtil.getParameter(request, prefix + "cfm_dt", ""));
		setMnrPrnrTpCd(JSPUtil.getParameter(request, prefix + "mnr_prnr_tp_cd", ""));
		setBzcAmt(JSPUtil.getParameter(request, prefix + "bzc_amt", ""));
		setMnrInvRefNo(JSPUtil.getParameter(request, prefix + "mnr_inv_ref_no", ""));
		setWhldTaxAmt(JSPUtil.getParameter(request, prefix + "whld_tax_amt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setSlsTaxAmt(JSPUtil.getParameter(request, prefix + "sls_tax_amt", ""));
		setVatAmt(JSPUtil.getParameter(request, prefix + "vat_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setTtlLssDivCd(JSPUtil.getParameter(request, prefix + "ttl_lss_div_cd", ""));
		setHldFlg(JSPUtil.getParameter(request, prefix + "hld_flg", ""));
		setOrdVndrSeq(JSPUtil.getParameter(request, prefix + "ord_vndr_seq", ""));
		setChkTrnsNo(JSPUtil.getParameter(request, prefix + "chk_trns_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrPayInvWrkVO[]
	 */
	public CustomMnrPayInvWrkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrPayInvWrkVO[]
	 */
	public CustomMnrPayInvWrkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrPayInvWrkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] mnrInvRjctFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_inv_rjct_flg", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] payInvSeq = (JSPUtil.getParameter(request, prefix	+ "pay_inv_seq", length));
			String[] mnrGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_grp_tp_cd", length));
			String[] invPayMzdCd = (JSPUtil.getParameter(request, prefix	+ "inv_pay_mzd_cd", length));
			String[] mnrInpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_inp_tp_cd", length));
			String[] issOfcCd = (JSPUtil.getParameter(request, prefix	+ "iss_ofc_cd", length));
			String[] mnrPrnrCntCd = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_cnt_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrPrnrSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_seq", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] mnrInvStsCd = (JSPUtil.getParameter(request, prefix	+ "mnr_inv_sts_cd", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] mnrInvRjctDt = (JSPUtil.getParameter(request, prefix	+ "mnr_inv_rjct_dt", length));
			String[] provUsrId = (JSPUtil.getParameter(request, prefix	+ "prov_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mnrInvRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_inv_rmk", length));
			String[] invRgstNo = (JSPUtil.getParameter(request, prefix	+ "inv_rgst_no", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] genPayTermCd = (JSPUtil.getParameter(request, prefix	+ "gen_pay_term_cd", length));
			String[] invCfmDt = (JSPUtil.getParameter(request, prefix	+ "inv_cfm_dt", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] mnrPrnrTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_tp_cd", length));
			String[] bzcAmt = (JSPUtil.getParameter(request, prefix	+ "bzc_amt", length));
			String[] mnrInvRefNo = (JSPUtil.getParameter(request, prefix	+ "mnr_inv_ref_no", length));
			String[] whldTaxAmt = (JSPUtil.getParameter(request, prefix	+ "whld_tax_amt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] slsTaxAmt = (JSPUtil.getParameter(request, prefix	+ "sls_tax_amt", length));
			String[] vatAmt = (JSPUtil.getParameter(request, prefix	+ "vat_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ttlLssDivCd = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_div_cd", length));
			String[] hldFlg = (JSPUtil.getParameter(request, prefix	+ "hld_flg", length));
			String[] ordVndrSeq = (JSPUtil.getParameter(request, prefix	+ "ord_vndr_seq", length));
			String[] chkTrnsNo = (JSPUtil.getParameter(request, prefix	+ "chk_trns_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrPayInvWrkVO();
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (mnrInvRjctFlg[i] != null)
					model.setMnrInvRjctFlg(mnrInvRjctFlg[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (payInvSeq[i] != null)
					model.setPayInvSeq(payInvSeq[i]);
				if (mnrGrpTpCd[i] != null)
					model.setMnrGrpTpCd(mnrGrpTpCd[i]);
				if (invPayMzdCd[i] != null)
					model.setInvPayMzdCd(invPayMzdCd[i]);
				if (mnrInpTpCd[i] != null)
					model.setMnrInpTpCd(mnrInpTpCd[i]);
				if (issOfcCd[i] != null)
					model.setIssOfcCd(issOfcCd[i]);
				if (mnrPrnrCntCd[i] != null)
					model.setMnrPrnrCntCd(mnrPrnrCntCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrPrnrSeq[i] != null)
					model.setMnrPrnrSeq(mnrPrnrSeq[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (mnrInvStsCd[i] != null)
					model.setMnrInvStsCd(mnrInvStsCd[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (mnrInvRjctDt[i] != null)
					model.setMnrInvRjctDt(mnrInvRjctDt[i]);
				if (provUsrId[i] != null)
					model.setProvUsrId(provUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mnrInvRmk[i] != null)
					model.setMnrInvRmk(mnrInvRmk[i]);
				if (invRgstNo[i] != null)
					model.setInvRgstNo(invRgstNo[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (genPayTermCd[i] != null)
					model.setGenPayTermCd(genPayTermCd[i]);
				if (invCfmDt[i] != null)
					model.setInvCfmDt(invCfmDt[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (mnrPrnrTpCd[i] != null)
					model.setMnrPrnrTpCd(mnrPrnrTpCd[i]);
				if (bzcAmt[i] != null)
					model.setBzcAmt(bzcAmt[i]);
				if (mnrInvRefNo[i] != null)
					model.setMnrInvRefNo(mnrInvRefNo[i]);
				if (whldTaxAmt[i] != null)
					model.setWhldTaxAmt(whldTaxAmt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (slsTaxAmt[i] != null)
					model.setSlsTaxAmt(slsTaxAmt[i]);
				if (vatAmt[i] != null)
					model.setVatAmt(vatAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ttlLssDivCd[i] != null)
					model.setTtlLssDivCd(ttlLssDivCd[i]);
				if (hldFlg[i] != null)
					model.setHldFlg(hldFlg[i]);
				if (ordVndrSeq[i] != null)
					model.setOrdVndrSeq(ordVndrSeq[i]);
				if (chkTrnsNo[i] != null)
					model.setChkTrnsNo(chkTrnsNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrPayInvWrkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrPayInvWrkVO[]
	 */
	public CustomMnrPayInvWrkVO[] getCustomMnrPayInvWrkVOs(){
		CustomMnrPayInvWrkVO[] vos = (CustomMnrPayInvWrkVO[])models.toArray(new CustomMnrPayInvWrkVO[models.size()]);
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
		this.payDt = this.payDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvRjctFlg = this.mnrInvRjctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payInvSeq = this.payInvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrGrpTpCd = this.mnrGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPayMzdCd = this.invPayMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInpTpCd = this.mnrInpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcCd = this.issOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrCntCd = this.mnrPrnrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrSeq = this.mnrPrnrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvStsCd = this.mnrInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvRjctDt = this.mnrInvRjctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.provUsrId = this.provUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvRmk = this.mnrInvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRgstNo = this.invRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genPayTermCd = this.genPayTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCfmDt = this.invCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrTpCd = this.mnrPrnrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAmt = this.bzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvRefNo = this.mnrInvRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whldTaxAmt = this.whldTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsTaxAmt = this.slsTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatAmt = this.vatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDivCd = this.ttlLssDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldFlg = this.hldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordVndrSeq = this.ordVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkTrnsNo = this.chkTrnsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
