/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomMnrRcvInvWrkVO.java
*@FileTitle : CustomMnrRcvInvWrkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.01.04 함형석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo;

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
 * @author 함형석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrRcvInvWrkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrRcvInvWrkVO> models = new ArrayList<CustomMnrRcvInvWrkVO>();
	
	/* Column Info */
	private String bankAcctNo = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String mnrGrpTpCd = null;
	/* Column Info */
	private String invPayMzdCd = null;
	/* Column Info */
	private String issOfcCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mnrPrnrCntCd = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String invDueDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dpPrcsKnt = null;
	/* Column Info */
	private String mnrPrnrSeq = null;
	/* Column Info */
	private String issDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mnrInvStsCd = null;
	/* Column Info */
	private String invStlStsCd = null;
	/* Column Info */
	private String bankNm = null;
	/* Column Info */
	private String rcvInvSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mnrInvRmk = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String mnrPrnrLglEngNm = null;
	/* Column Info */
	private String mnrPrnrTpCd = null;
	/* Column Info */
	private String mnrInvRefNo = null;
	/* Column Info */
	private String whldTaxAmt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vatAmt = null;
	/* Column Info */
	private String cltStlFlg = null;
	/* Column Info */
	private String chkTrnsNo = null;
	/* Column Info */
	private String mnrBilToNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomMnrRcvInvWrkVO() {}

	public CustomMnrRcvInvWrkVO(String ibflag, String pagerows, String bankAcctNo, String glDt, String currCd, String mnrGrpTpCd, String issOfcCd, String invPayMzdCd, String mnrPrnrCntCd, String creDt, String ttlAmt, String invDueDt, String dpPrcsKnt, String mnrPrnrSeq, String issDt, String mnrInvStsCd, String bankNm, String rcvInvSeq, String updUsrId, String mnrInvRmk, String updDt, String cfmDt, String mnrPrnrLglEngNm, String mnrPrnrTpCd, String mnrInvRefNo, String whldTaxAmt, String invNo, String vatAmt, String creUsrId, String cltStlFlg, String chkTrnsNo, String mnrBilToNm, String invStlStsCd) {
		this.bankAcctNo = bankAcctNo;
		this.glDt = glDt;
		this.currCd = currCd;
		this.mnrGrpTpCd = mnrGrpTpCd;
		this.invPayMzdCd = invPayMzdCd;
		this.issOfcCd = issOfcCd;
		this.creDt = creDt;
		this.mnrPrnrCntCd = mnrPrnrCntCd;
		this.ttlAmt = ttlAmt;
		this.invDueDt = invDueDt;
		this.pagerows = pagerows;
		this.dpPrcsKnt = dpPrcsKnt;
		this.mnrPrnrSeq = mnrPrnrSeq;
		this.issDt = issDt;
		this.ibflag = ibflag;
		this.mnrInvStsCd = mnrInvStsCd;
		this.invStlStsCd = invStlStsCd;
		this.bankNm = bankNm;
		this.rcvInvSeq = rcvInvSeq;
		this.updUsrId = updUsrId;
		this.mnrInvRmk = mnrInvRmk;
		this.updDt = updDt;
		this.cfmDt = cfmDt;
		this.mnrPrnrLglEngNm = mnrPrnrLglEngNm;
		this.mnrPrnrTpCd = mnrPrnrTpCd;
		this.mnrInvRefNo = mnrInvRefNo;
		this.whldTaxAmt = whldTaxAmt;
		this.invNo = invNo;
		this.creUsrId = creUsrId;
		this.vatAmt = vatAmt;
		this.cltStlFlg = cltStlFlg;
		this.chkTrnsNo = chkTrnsNo;
		this.mnrBilToNm = mnrBilToNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bank_acct_no", getBankAcctNo());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("mnr_grp_tp_cd", getMnrGrpTpCd());
		this.hashColumns.put("inv_pay_mzd_cd", getInvPayMzdCd());
		this.hashColumns.put("iss_ofc_cd", getIssOfcCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mnr_prnr_cnt_cd", getMnrPrnrCntCd());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("inv_due_dt", getInvDueDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
		this.hashColumns.put("mnr_prnr_seq", getMnrPrnrSeq());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mnr_inv_sts_cd", getMnrInvStsCd());
		this.hashColumns.put("inv_stl_sts_cd", getInvStlStsCd());
		this.hashColumns.put("bank_nm", getBankNm());
		this.hashColumns.put("rcv_inv_seq", getRcvInvSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mnr_inv_rmk", getMnrInvRmk());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("mnr_prnr_lgl_eng_nm", getMnrPrnrLglEngNm());
		this.hashColumns.put("mnr_prnr_tp_cd", getMnrPrnrTpCd());
		this.hashColumns.put("mnr_inv_ref_no", getMnrInvRefNo());
		this.hashColumns.put("whld_tax_amt", getWhldTaxAmt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vat_amt", getVatAmt());
		this.hashColumns.put("clt_stl_flg", getCltStlFlg());
		this.hashColumns.put("chk_trns_no", getChkTrnsNo());
		this.hashColumns.put("mnr_bil_to_nm", getMnrBilToNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("mnr_grp_tp_cd", "mnrGrpTpCd");
		this.hashFields.put("inv_pay_mzd_cd", "invPayMzdCd");
		this.hashFields.put("iss_ofc_cd", "issOfcCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mnr_prnr_cnt_cd", "mnrPrnrCntCd");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("inv_due_dt", "invDueDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("mnr_prnr_seq", "mnrPrnrSeq");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnr_inv_sts_cd", "mnrInvStsCd");
		this.hashFields.put("inv_stl_sts_cd", "invStlStsCd");
		this.hashFields.put("bank_nm", "bankNm");
		this.hashFields.put("rcv_inv_seq", "rcvInvSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mnr_inv_rmk", "mnrInvRmk");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("mnr_prnr_lgl_eng_nm", "mnrPrnrLglEngNm");
		this.hashFields.put("mnr_prnr_tp_cd", "mnrPrnrTpCd");
		this.hashFields.put("mnr_inv_ref_no", "mnrInvRefNo");
		this.hashFields.put("whld_tax_amt", "whldTaxAmt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vat_amt", "vatAmt");
		this.hashFields.put("clt_stl_flg", "cltStlFlg");
		this.hashFields.put("chk_trns_no", "chkTrnsNo");
		this.hashFields.put("mnr_bil_to_nm", "mnrBilToNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bankAcctNo
	 */
	public String getBankAcctNo() {
		return this.bankAcctNo;
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
	 * @return issOfcCd
	 */
	public String getIssOfcCd() {
		return this.issOfcCd;
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
	 * @return mnrPrnrCntCd
	 */
	public String getMnrPrnrCntCd() {
		return this.mnrPrnrCntCd;
	}
	
	/**
	 * Column Info
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
	}
	
	/**
	 * Column Info
	 * @return invDueDt
	 */
	public String getInvDueDt() {
		return this.invDueDt;
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
	 * @return dpPrcsKnt
	 */
	public String getDpPrcsKnt() {
		return this.dpPrcsKnt;
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
	 * @return mnrInvStsCd
	 */
	public String getMnrInvStsCd() {
		return this.mnrInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return invStlStsCd
	 */
	public String getInvStlStsCd() {
		return this.invStlStsCd;
	}
	
	/**
	 * Column Info
	 * @return bankNm
	 */
	public String getBankNm() {
		return this.bankNm;
	}
	
	/**
	 * Column Info
	 * @return rcvInvSeq
	 */
	public String getRcvInvSeq() {
		return this.rcvInvSeq;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return mnrPrnrLglEngNm
	 */
	public String getMnrPrnrLglEngNm() {
		return this.mnrPrnrLglEngNm;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return cltStlFlg
	 */
	public String getCltStlFlg() {
		return this.cltStlFlg;
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
	 * @return mnrBilToNm
	 */
	public String getMnrBilToNm() {
		return this.mnrBilToNm;
	}
	

	/**
	 * Column Info
	 * @param bankAcctNo
	 */
	public void setBankAcctNo(String bankAcctNo) {
		this.bankAcctNo = bankAcctNo;
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
	 * @param issOfcCd
	 */
	public void setIssOfcCd(String issOfcCd) {
		this.issOfcCd = issOfcCd;
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
	 * @param mnrPrnrCntCd
	 */
	public void setMnrPrnrCntCd(String mnrPrnrCntCd) {
		this.mnrPrnrCntCd = mnrPrnrCntCd;
	}
	
	/**
	 * Column Info
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}
	
	/**
	 * Column Info
	 * @param invDueDt
	 */
	public void setInvDueDt(String invDueDt) {
		this.invDueDt = invDueDt;
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
	 * @param dpPrcsKnt
	 */
	public void setDpPrcsKnt(String dpPrcsKnt) {
		this.dpPrcsKnt = dpPrcsKnt;
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
	 * @param mnrInvStsCd
	 */
	public void setMnrInvStsCd(String mnrInvStsCd) {
		this.mnrInvStsCd = mnrInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param invStlStsCd
	 */
	public void setInvStlStsCd(String invStlStsCd) {
		this.invStlStsCd = invStlStsCd;
	}
	
	/**
	 * Column Info
	 * @param bankNm
	 */
	public void setBankNm(String bankNm) {
		this.bankNm = bankNm;
	}
	
	/**
	 * Column Info
	 * @param rcvInvSeq
	 */
	public void setRcvInvSeq(String rcvInvSeq) {
		this.rcvInvSeq = rcvInvSeq;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param mnrPrnrLglEngNm
	 */
	public void setMnrPrnrLglEngNm(String mnrPrnrLglEngNm) {
		this.mnrPrnrLglEngNm = mnrPrnrLglEngNm;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param cltStlFlg
	 */
	public void setCltStlFlg(String cltStlFlg) {
		this.cltStlFlg = cltStlFlg;
	}
	
	/**
	 * Column Info
	 * @param chkTrnsNo
	 */
	public void setChkTrnsNo(String chkTrnsNo) {
		this.chkTrnsNo = chkTrnsNo;
	}
	
	/**
	 * Column Info
	 * @param mnrBilToNm
	 */
	public void setMnrBilToNm(String mnrBilToNm) {
		this.mnrBilToNm = mnrBilToNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBankAcctNo(JSPUtil.getParameter(request, "bank_acct_no", ""));
		setGlDt(JSPUtil.getParameter(request, "gl_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setMnrGrpTpCd(JSPUtil.getParameter(request, "mnr_grp_tp_cd", ""));
		setInvPayMzdCd(JSPUtil.getParameter(request, "inv_pay_mzd_cd", ""));
		setIssOfcCd(JSPUtil.getParameter(request, "iss_ofc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setMnrPrnrCntCd(JSPUtil.getParameter(request, "mnr_prnr_cnt_cd", ""));
		setTtlAmt(JSPUtil.getParameter(request, "ttl_amt", ""));
		setInvDueDt(JSPUtil.getParameter(request, "inv_due_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request, "dp_prcs_knt", ""));
		setMnrPrnrSeq(JSPUtil.getParameter(request, "mnr_prnr_seq", ""));
		setIssDt(JSPUtil.getParameter(request, "iss_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMnrInvStsCd(JSPUtil.getParameter(request, "mnr_inv_sts_cd", ""));
		setInvStlStsCd(JSPUtil.getParameter(request, "inv_stl_sts_cd", ""));
		setBankNm(JSPUtil.getParameter(request, "bank_nm", ""));
		setRcvInvSeq(JSPUtil.getParameter(request, "rcv_inv_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setMnrInvRmk(JSPUtil.getParameter(request, "mnr_inv_rmk", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCfmDt(JSPUtil.getParameter(request, "cfm_dt", ""));
		setMnrPrnrLglEngNm(JSPUtil.getParameter(request, "mnr_prnr_lgl_eng_nm", ""));
		setMnrPrnrTpCd(JSPUtil.getParameter(request, "mnr_prnr_tp_cd", ""));
		setMnrInvRefNo(JSPUtil.getParameter(request, "mnr_inv_ref_no", ""));
		setWhldTaxAmt(JSPUtil.getParameter(request, "whld_tax_amt", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setVatAmt(JSPUtil.getParameter(request, "vat_amt", ""));
		setCltStlFlg(JSPUtil.getParameter(request, "clt_stl_flg", ""));
		setChkTrnsNo(JSPUtil.getParameter(request, "chk_trns_no", ""));
		setMnrBilToNm(JSPUtil.getParameter(request, "mnr_bil_to_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrRcvInvWrkVO[]
	 */
	public CustomMnrRcvInvWrkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrRcvInvWrkVO[]
	 */
	public CustomMnrRcvInvWrkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrRcvInvWrkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bankAcctNo = (JSPUtil.getParameter(request, prefix	+ "bank_acct_no", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] mnrGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_grp_tp_cd", length));
			String[] invPayMzdCd = (JSPUtil.getParameter(request, prefix	+ "inv_pay_mzd_cd", length));
			String[] issOfcCd = (JSPUtil.getParameter(request, prefix	+ "iss_ofc_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mnrPrnrCntCd = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_cnt_cd", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] invDueDt = (JSPUtil.getParameter(request, prefix	+ "inv_due_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt", length));
			String[] mnrPrnrSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_seq", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mnrInvStsCd = (JSPUtil.getParameter(request, prefix	+ "mnr_inv_sts_cd", length));
			String[] invStlStsCd = (JSPUtil.getParameter(request, prefix	+ "inv_stl_sts_cd", length));
			String[] bankNm = (JSPUtil.getParameter(request, prefix	+ "bank_nm", length));
			String[] rcvInvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_inv_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mnrInvRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_inv_rmk", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] mnrPrnrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_lgl_eng_nm", length));
			String[] mnrPrnrTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_tp_cd", length));
			String[] mnrInvRefNo = (JSPUtil.getParameter(request, prefix	+ "mnr_inv_ref_no", length));
			String[] whldTaxAmt = (JSPUtil.getParameter(request, prefix	+ "whld_tax_amt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] vatAmt = (JSPUtil.getParameter(request, prefix	+ "vat_amt", length));
			String[] cltStlFlg = (JSPUtil.getParameter(request, prefix	+ "clt_stl_flg", length));
			String[] chkTrnsNo = (JSPUtil.getParameter(request, prefix	+ "chk_trns_no", length));
			String[] mnrBilToNm = (JSPUtil.getParameter(request, prefix	+ "mnr_bil_to_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrRcvInvWrkVO();
				if (bankAcctNo[i] != null)
					model.setBankAcctNo(bankAcctNo[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (mnrGrpTpCd[i] != null)
					model.setMnrGrpTpCd(mnrGrpTpCd[i]);
				if (invPayMzdCd[i] != null)
					model.setInvPayMzdCd(invPayMzdCd[i]);
				if (issOfcCd[i] != null)
					model.setIssOfcCd(issOfcCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mnrPrnrCntCd[i] != null)
					model.setMnrPrnrCntCd(mnrPrnrCntCd[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (invDueDt[i] != null)
					model.setInvDueDt(invDueDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dpPrcsKnt[i] != null)
					model.setDpPrcsKnt(dpPrcsKnt[i]);
				if (mnrPrnrSeq[i] != null)
					model.setMnrPrnrSeq(mnrPrnrSeq[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnrInvStsCd[i] != null)
					model.setMnrInvStsCd(mnrInvStsCd[i]);
				if (invStlStsCd[i] != null)
					model.setInvStlStsCd(invStlStsCd[i]);
				if (bankNm[i] != null)
					model.setBankNm(bankNm[i]);
				if (rcvInvSeq[i] != null)
					model.setRcvInvSeq(rcvInvSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mnrInvRmk[i] != null)
					model.setMnrInvRmk(mnrInvRmk[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (mnrPrnrLglEngNm[i] != null)
					model.setMnrPrnrLglEngNm(mnrPrnrLglEngNm[i]);
				if (mnrPrnrTpCd[i] != null)
					model.setMnrPrnrTpCd(mnrPrnrTpCd[i]);
				if (mnrInvRefNo[i] != null)
					model.setMnrInvRefNo(mnrInvRefNo[i]);
				if (whldTaxAmt[i] != null)
					model.setWhldTaxAmt(whldTaxAmt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vatAmt[i] != null)
					model.setVatAmt(vatAmt[i]);
				if (cltStlFlg[i] != null)
					model.setCltStlFlg(cltStlFlg[i]);
				if (chkTrnsNo[i] != null)
					model.setChkTrnsNo(chkTrnsNo[i]);
				if (mnrBilToNm[i] != null)
					model.setMnrBilToNm(mnrBilToNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrRcvInvWrkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrRcvInvWrkVO[]
	 */
	public CustomMnrRcvInvWrkVO[] getCustomMnrRcvInvWrkVOs(){
		CustomMnrRcvInvWrkVO[] vos = (CustomMnrRcvInvWrkVO[])models.toArray(new CustomMnrRcvInvWrkVO[models.size()]);
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
		this.bankAcctNo = this.bankAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrGrpTpCd = this.mnrGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPayMzdCd = this.invPayMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcCd = this.issOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrCntCd = this.mnrPrnrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDueDt = this.invDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt = this.dpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrSeq = this.mnrPrnrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvStsCd = this.mnrInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invStlStsCd = this.invStlStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankNm = this.bankNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvInvSeq = this.rcvInvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvRmk = this.mnrInvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrLglEngNm = this.mnrPrnrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrTpCd = this.mnrPrnrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvRefNo = this.mnrInvRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whldTaxAmt = this.whldTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatAmt = this.vatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltStlFlg = this.cltStlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkTrnsNo = this.chkTrnsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrBilToNm = this.mnrBilToNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
