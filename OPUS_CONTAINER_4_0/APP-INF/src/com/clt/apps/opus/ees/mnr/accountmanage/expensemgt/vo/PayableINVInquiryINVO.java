/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PayableINVInquiryINVO.java
*@FileTitle : PayableINVInquiryINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.04.21 함형석 
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
 * @author 함형석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PayableINVInquiryINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PayableINVInquiryINVO> models = new ArrayList<PayableINVInquiryINVO>();
	
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String payInvSeq = null;
	/* Column Info */
	private String mnrGrpTpCd = null;
	/* Column Info */
	private String vat = null;
	/* Column Info */
	private String tmpSeq = null;
	/* Column Info */
	private String woOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mnrInvStsCd = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String inputDateTypeCode = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String saveVndrSeq = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String mnrInvRmk = null;
	/* Column Info */
	private String invRgstNo = null;
	/* Column Info */
	private String invWoNo = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String inputInvNo = null;
	/* Column Info */
	private String invSchTypeCode = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String inputTypeCode = null;
	/* Column Info */
	private String payTermDys = null;
	/* Column Info */
	private String trsmModCd = null;
	/* Column Info */
	private String gAmt = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String amt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String mnrOrdSeq = null;
	/* Column Info */
	private String wht = null;
	/* Column Info */
	private String ttlLssDivCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String targetCurrCd = null;
	/* Column Info */
	private String sel = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PayableINVInquiryINVO() {}

	public PayableINVInquiryINVO(String ibflag, String pagerows, String userOfcCd, String fromDt, String currCd, String payInvSeq, String mnrGrpTpCd, String vat, String tmpSeq, String woOfcCd, String issDt, String effDt, String mnrInvStsCd, String rcvDt, String inputDateTypeCode, String woNo, String saveVndrSeq, String mnrInvRmk, String invRgstNo, String invWoNo, String csrNo, String inputInvNo, String invSchTypeCode, String cfmDt, String inputTypeCode, String payTermDys, String gAmt, String trsmModCd, String invNo, String toDt, String amt, String creUsrId, String ttlLssDivCd, String wht, String mnrOrdSeq, String targetCurrCd, String vndrSeq, String sel, String costOfcCd, String invOfcCd) {
		this.userOfcCd = userOfcCd;
		this.fromDt = fromDt;
		this.currCd = currCd;
		this.payInvSeq = payInvSeq;
		this.mnrGrpTpCd = mnrGrpTpCd;
		this.vat = vat;
		this.tmpSeq = tmpSeq;
		this.woOfcCd = woOfcCd;
		this.pagerows = pagerows;
		this.issDt = issDt;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.mnrInvStsCd = mnrInvStsCd;
		this.rcvDt = rcvDt;
		this.inputDateTypeCode = inputDateTypeCode;
		this.woNo = woNo;
		this.saveVndrSeq = saveVndrSeq;
		this.invOfcCd = invOfcCd;
		this.mnrInvRmk = mnrInvRmk;
		this.invRgstNo = invRgstNo;
		this.invWoNo = invWoNo;
		this.csrNo = csrNo;
		this.inputInvNo = inputInvNo;
		this.invSchTypeCode = invSchTypeCode;
		this.costOfcCd = costOfcCd;
		this.cfmDt = cfmDt;
		this.inputTypeCode = inputTypeCode;
		this.payTermDys = payTermDys;
		this.trsmModCd = trsmModCd;
		this.gAmt = gAmt;
		this.toDt = toDt;
		this.invNo = invNo;
		this.amt = amt;
		this.creUsrId = creUsrId;
		this.mnrOrdSeq = mnrOrdSeq;
		this.wht = wht;
		this.ttlLssDivCd = ttlLssDivCd;
		this.vndrSeq = vndrSeq;
		this.targetCurrCd = targetCurrCd;
		this.sel = sel;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("pay_inv_seq", getPayInvSeq());
		this.hashColumns.put("mnr_grp_tp_cd", getMnrGrpTpCd());
		this.hashColumns.put("vat", getVat());
		this.hashColumns.put("tmp_seq", getTmpSeq());
		this.hashColumns.put("wo_ofc_cd", getWoOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mnr_inv_sts_cd", getMnrInvStsCd());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("input_date_type_code", getInputDateTypeCode());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("save_vndr_seq", getSaveVndrSeq());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("mnr_inv_rmk", getMnrInvRmk());
		this.hashColumns.put("inv_rgst_no", getInvRgstNo());
		this.hashColumns.put("inv_wo_no", getInvWoNo());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("input_inv_no", getInputInvNo());
		this.hashColumns.put("inv_sch_type_code", getInvSchTypeCode());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("input_type_code", getInputTypeCode());
		this.hashColumns.put("pay_term_dys", getPayTermDys());
		this.hashColumns.put("trsm_mod_cd", getTrsmModCd());
		this.hashColumns.put("g_amt", getGAmt());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("amt", getAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("mnr_ord_seq", getMnrOrdSeq());
		this.hashColumns.put("wht", getWht());
		this.hashColumns.put("ttl_lss_div_cd", getTtlLssDivCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("target_curr_cd", getTargetCurrCd());
		this.hashColumns.put("sel", getSel());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pay_inv_seq", "payInvSeq");
		this.hashFields.put("mnr_grp_tp_cd", "mnrGrpTpCd");
		this.hashFields.put("vat", "vat");
		this.hashFields.put("tmp_seq", "tmpSeq");
		this.hashFields.put("wo_ofc_cd", "woOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnr_inv_sts_cd", "mnrInvStsCd");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("input_date_type_code", "inputDateTypeCode");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("save_vndr_seq", "saveVndrSeq");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("mnr_inv_rmk", "mnrInvRmk");
		this.hashFields.put("inv_rgst_no", "invRgstNo");
		this.hashFields.put("inv_wo_no", "invWoNo");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("input_inv_no", "inputInvNo");
		this.hashFields.put("inv_sch_type_code", "invSchTypeCode");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("input_type_code", "inputTypeCode");
		this.hashFields.put("pay_term_dys", "payTermDys");
		this.hashFields.put("trsm_mod_cd", "trsmModCd");
		this.hashFields.put("g_amt", "gAmt");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("amt", "amt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mnr_ord_seq", "mnrOrdSeq");
		this.hashFields.put("wht", "wht");
		this.hashFields.put("ttl_lss_div_cd", "ttlLssDivCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("target_curr_cd", "targetCurrCd");
		this.hashFields.put("sel", "sel");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return userOfcCd
	 */
	public String getUserOfcCd() {
		return this.userOfcCd;
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
	 * @return vat
	 */
	public String getVat() {
		return this.vat;
	}
	
	/**
	 * Column Info
	 * @return tmpSeq
	 */
	public String getTmpSeq() {
		return this.tmpSeq;
	}
	
	/**
	 * Column Info
	 * @return woOfcCd
	 */
	public String getWoOfcCd() {
		return this.woOfcCd;
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
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return inputDateTypeCode
	 */
	public String getInputDateTypeCode() {
		return this.inputDateTypeCode;
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
	 * @return saveVndrSeq
	 */
	public String getSaveVndrSeq() {
		return this.saveVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
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
	 * @return invWoNo
	 */
	public String getInvWoNo() {
		return this.invWoNo;
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
	 * @return inputInvNo
	 */
	public String getInputInvNo() {
		return this.inputInvNo;
	}
	
	/**
	 * Column Info
	 * @return invSchTypeCode
	 */
	public String getInvSchTypeCode() {
		return this.invSchTypeCode;
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
	 * @return cfmDt
	 */
	public String getCfmDt() {
		return this.cfmDt;
	}
	
	/**
	 * Column Info
	 * @return inputTypeCode
	 */
	public String getInputTypeCode() {
		return this.inputTypeCode;
	}
	
	/**
	 * Column Info
	 * @return payTermDys
	 */
	public String getPayTermDys() {
		return this.payTermDys;
	}
	
	/**
	 * Column Info
	 * @return trsmModCd
	 */
	public String getTrsmModCd() {
		return this.trsmModCd;
	}
	
	/**
	 * Column Info
	 * @return gAmt
	 */
	public String getGAmt() {
		return this.gAmt;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return amt
	 */
	public String getAmt() {
		return this.amt;
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
	 * @return mnrOrdSeq
	 */
	public String getMnrOrdSeq() {
		return this.mnrOrdSeq;
	}
	
	/**
	 * Column Info
	 * @return wht
	 */
	public String getWht() {
		return this.wht;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return targetCurrCd
	 */
	public String getTargetCurrCd() {
		return this.targetCurrCd;
	}
	
	/**
	 * Column Info
	 * @return sel
	 */
	public String getSel() {
		return this.sel;
	}
	

	/**
	 * Column Info
	 * @param userOfcCd
	 */
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
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
	 * @param vat
	 */
	public void setVat(String vat) {
		this.vat = vat;
	}
	
	/**
	 * Column Info
	 * @param tmpSeq
	 */
	public void setTmpSeq(String tmpSeq) {
		this.tmpSeq = tmpSeq;
	}
	
	/**
	 * Column Info
	 * @param woOfcCd
	 */
	public void setWoOfcCd(String woOfcCd) {
		this.woOfcCd = woOfcCd;
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
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param inputDateTypeCode
	 */
	public void setInputDateTypeCode(String inputDateTypeCode) {
		this.inputDateTypeCode = inputDateTypeCode;
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
	 * @param saveVndrSeq
	 */
	public void setSaveVndrSeq(String saveVndrSeq) {
		this.saveVndrSeq = saveVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
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
	 * @param invWoNo
	 */
	public void setInvWoNo(String invWoNo) {
		this.invWoNo = invWoNo;
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
	 * @param inputInvNo
	 */
	public void setInputInvNo(String inputInvNo) {
		this.inputInvNo = inputInvNo;
	}
	
	/**
	 * Column Info
	 * @param invSchTypeCode
	 */
	public void setInvSchTypeCode(String invSchTypeCode) {
		this.invSchTypeCode = invSchTypeCode;
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
	 * @param cfmDt
	 */
	public void setCfmDt(String cfmDt) {
		this.cfmDt = cfmDt;
	}
	
	/**
	 * Column Info
	 * @param inputTypeCode
	 */
	public void setInputTypeCode(String inputTypeCode) {
		this.inputTypeCode = inputTypeCode;
	}
	
	/**
	 * Column Info
	 * @param payTermDys
	 */
	public void setPayTermDys(String payTermDys) {
		this.payTermDys = payTermDys;
	}
	
	/**
	 * Column Info
	 * @param trsmModCd
	 */
	public void setTrsmModCd(String trsmModCd) {
		this.trsmModCd = trsmModCd;
	}
	
	/**
	 * Column Info
	 * @param gAmt
	 */
	public void setGAmt(String gAmt) {
		this.gAmt = gAmt;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param amt
	 */
	public void setAmt(String amt) {
		this.amt = amt;
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
	 * @param mnrOrdSeq
	 */
	public void setMnrOrdSeq(String mnrOrdSeq) {
		this.mnrOrdSeq = mnrOrdSeq;
	}
	
	/**
	 * Column Info
	 * @param wht
	 */
	public void setWht(String wht) {
		this.wht = wht;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param targetCurrCd
	 */
	public void setTargetCurrCd(String targetCurrCd) {
		this.targetCurrCd = targetCurrCd;
	}
	
	/**
	 * Column Info
	 * @param sel
	 */
	public void setSel(String sel) {
		this.sel = sel;
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
		setUserOfcCd(JSPUtil.getParameter(request, prefix + "user_ofc_cd", ""));
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPayInvSeq(JSPUtil.getParameter(request, prefix + "pay_inv_seq", ""));
		setMnrGrpTpCd(JSPUtil.getParameter(request, prefix + "mnr_grp_tp_cd", ""));
		setVat(JSPUtil.getParameter(request, prefix + "vat", ""));
		setTmpSeq(JSPUtil.getParameter(request, prefix + "tmp_seq", ""));
		setWoOfcCd(JSPUtil.getParameter(request, prefix + "wo_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMnrInvStsCd(JSPUtil.getParameter(request, prefix + "mnr_inv_sts_cd", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setInputDateTypeCode(JSPUtil.getParameter(request, prefix + "input_date_type_code", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setSaveVndrSeq(JSPUtil.getParameter(request, prefix + "save_vndr_seq", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setMnrInvRmk(JSPUtil.getParameter(request, prefix + "mnr_inv_rmk", ""));
		setInvRgstNo(JSPUtil.getParameter(request, prefix + "inv_rgst_no", ""));
		setInvWoNo(JSPUtil.getParameter(request, prefix + "inv_wo_no", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setInputInvNo(JSPUtil.getParameter(request, prefix + "input_inv_no", ""));
		setInvSchTypeCode(JSPUtil.getParameter(request, prefix + "inv_sch_type_code", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setCfmDt(JSPUtil.getParameter(request, prefix + "cfm_dt", ""));
		setInputTypeCode(JSPUtil.getParameter(request, prefix + "input_type_code", ""));
		setPayTermDys(JSPUtil.getParameter(request, prefix + "pay_term_dys", ""));
		setTrsmModCd(JSPUtil.getParameter(request, prefix + "trsm_mod_cd", ""));
		setGAmt(JSPUtil.getParameter(request, prefix + "g_amt", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setAmt(JSPUtil.getParameter(request, prefix + "amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setMnrOrdSeq(JSPUtil.getParameter(request, prefix + "mnr_ord_seq", ""));
		setWht(JSPUtil.getParameter(request, prefix + "wht", ""));
		setTtlLssDivCd(JSPUtil.getParameter(request, prefix + "ttl_lss_div_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setTargetCurrCd(JSPUtil.getParameter(request, prefix + "target_curr_cd", ""));
		setSel(JSPUtil.getParameter(request, prefix + "sel", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PayableINVInquiryINVO[]
	 */
	public PayableINVInquiryINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PayableINVInquiryINVO[]
	 */
	public PayableINVInquiryINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PayableINVInquiryINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] payInvSeq = (JSPUtil.getParameter(request, prefix	+ "pay_inv_seq", length));
			String[] mnrGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_grp_tp_cd", length));
			String[] vat = (JSPUtil.getParameter(request, prefix	+ "vat", length));
			String[] tmpSeq = (JSPUtil.getParameter(request, prefix	+ "tmp_seq", length));
			String[] woOfcCd = (JSPUtil.getParameter(request, prefix	+ "wo_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mnrInvStsCd = (JSPUtil.getParameter(request, prefix	+ "mnr_inv_sts_cd", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] inputDateTypeCode = (JSPUtil.getParameter(request, prefix	+ "input_date_type_code", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] saveVndrSeq = (JSPUtil.getParameter(request, prefix	+ "save_vndr_seq", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] mnrInvRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_inv_rmk", length));
			String[] invRgstNo = (JSPUtil.getParameter(request, prefix	+ "inv_rgst_no", length));
			String[] invWoNo = (JSPUtil.getParameter(request, prefix	+ "inv_wo_no", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] inputInvNo = (JSPUtil.getParameter(request, prefix	+ "input_inv_no", length));
			String[] invSchTypeCode = (JSPUtil.getParameter(request, prefix	+ "inv_sch_type_code", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] inputTypeCode = (JSPUtil.getParameter(request, prefix	+ "input_type_code", length));
			String[] payTermDys = (JSPUtil.getParameter(request, prefix	+ "pay_term_dys", length));
			String[] trsmModCd = (JSPUtil.getParameter(request, prefix	+ "trsm_mod_cd", length));
			String[] gAmt = (JSPUtil.getParameter(request, prefix	+ "g_amt", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] amt = (JSPUtil.getParameter(request, prefix	+ "amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] mnrOrdSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_seq", length));
			String[] wht = (JSPUtil.getParameter(request, prefix	+ "wht", length));
			String[] ttlLssDivCd = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_div_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] targetCurrCd = (JSPUtil.getParameter(request, prefix	+ "target_curr_cd", length));
			String[] sel = (JSPUtil.getParameter(request, prefix	+ "sel", length));
			
			for (int i = 0; i < length; i++) {
				model = new PayableINVInquiryINVO();
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (payInvSeq[i] != null)
					model.setPayInvSeq(payInvSeq[i]);
				if (mnrGrpTpCd[i] != null)
					model.setMnrGrpTpCd(mnrGrpTpCd[i]);
				if (vat[i] != null)
					model.setVat(vat[i]);
				if (tmpSeq[i] != null)
					model.setTmpSeq(tmpSeq[i]);
				if (woOfcCd[i] != null)
					model.setWoOfcCd(woOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnrInvStsCd[i] != null)
					model.setMnrInvStsCd(mnrInvStsCd[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (inputDateTypeCode[i] != null)
					model.setInputDateTypeCode(inputDateTypeCode[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (saveVndrSeq[i] != null)
					model.setSaveVndrSeq(saveVndrSeq[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (mnrInvRmk[i] != null)
					model.setMnrInvRmk(mnrInvRmk[i]);
				if (invRgstNo[i] != null)
					model.setInvRgstNo(invRgstNo[i]);
				if (invWoNo[i] != null)
					model.setInvWoNo(invWoNo[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (inputInvNo[i] != null)
					model.setInputInvNo(inputInvNo[i]);
				if (invSchTypeCode[i] != null)
					model.setInvSchTypeCode(invSchTypeCode[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (inputTypeCode[i] != null)
					model.setInputTypeCode(inputTypeCode[i]);
				if (payTermDys[i] != null)
					model.setPayTermDys(payTermDys[i]);
				if (trsmModCd[i] != null)
					model.setTrsmModCd(trsmModCd[i]);
				if (gAmt[i] != null)
					model.setGAmt(gAmt[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (amt[i] != null)
					model.setAmt(amt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (mnrOrdSeq[i] != null)
					model.setMnrOrdSeq(mnrOrdSeq[i]);
				if (wht[i] != null)
					model.setWht(wht[i]);
				if (ttlLssDivCd[i] != null)
					model.setTtlLssDivCd(ttlLssDivCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (targetCurrCd[i] != null)
					model.setTargetCurrCd(targetCurrCd[i]);
				if (sel[i] != null)
					model.setSel(sel[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPayableINVInquiryINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PayableINVInquiryINVO[]
	 */
	public PayableINVInquiryINVO[] getPayableINVInquiryINVOs(){
		PayableINVInquiryINVO[] vos = (PayableINVInquiryINVO[])models.toArray(new PayableINVInquiryINVO[models.size()]);
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
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payInvSeq = this.payInvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrGrpTpCd = this.mnrGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vat = this.vat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpSeq = this.tmpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woOfcCd = this.woOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvStsCd = this.mnrInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputDateTypeCode = this.inputDateTypeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveVndrSeq = this.saveVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvRmk = this.mnrInvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRgstNo = this.invRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invWoNo = this.invWoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputInvNo = this.inputInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSchTypeCode = this.invSchTypeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputTypeCode = this.inputTypeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermDys = this.payTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmModCd = this.trsmModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gAmt = this.gAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt = this.amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSeq = this.mnrOrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wht = this.wht .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDivCd = this.ttlLssDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.targetCurrCd = this.targetCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sel = this.sel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
