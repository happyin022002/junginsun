/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchUsRailInvoiceInquirySecondExcelFormVO.java
*@FileTitle : SearchUsRailInvoiceInquirySecondExcelFormVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.20  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceinquirycorrection.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchUsRailInvoiceInquirySecondExcelFormVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchUsRailInvoiceInquirySecondExcelFormVO> models = new ArrayList<SearchUsRailInvoiceInquirySecondExcelFormVO>();
	
	/* Column Info */
	private String invTtlAmt = null;
	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String invVndrSeq = null;
	/* Column Info */
	private String invPayMzdCd = null;
	/* Column Info */
	private String invRemark = null;
	/* Column Info */
	private String invIssDt = null;
	/* Column Info */
	private String woVndrSeq = null;
	/* Column Info */
	private String invRcvDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invHldFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String trspInvAudStsNm = null;
	/* Column Info */
	private String invVndrNm = null;
	/* Column Info */
	private String woVndrNm = null;
	/* Column Info */
	private String ovrWgtScgAmt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String etcAddAmt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String trspInvAudStsCd = null;
	/* Column Info */
	private String bzcAmt = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String fuelScgAmt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String woTtlAmt = null;
	/* Column Info */
	private String invChkTrnsNo = null;
	/* Column Info */
	private String invBzcAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchUsRailInvoiceInquirySecondExcelFormVO() {}

	public SearchUsRailInvoiceInquirySecondExcelFormVO(String ibflag, String pagerows, String trspInvAudStsCd, String trspInvAudStsNm, String invHldFlg, String invNo, String invVndrSeq, String invVndrNm, String woVndrSeq, String woVndrNm, String eqNo, String eqTpszCd, String currCd, String bzcAmt, String fuelScgAmt, String ovrWgtScgAmt, String etcAddAmt, String woTtlAmt, String invCurrCd, String invBzcAmt, String invTtlAmt, String invIssDt, String invRcvDt, String payDt, String glDt, String updDt, String csrNo, String invPayMzdCd, String invChkTrnsNo, String invRemark, String creOfcCd, String creUsrId) {
		this.invTtlAmt = invTtlAmt;
		this.payDt = payDt;
		this.glDt = glDt;
		this.currCd = currCd;
		this.invVndrSeq = invVndrSeq;
		this.invPayMzdCd = invPayMzdCd;
		this.invRemark = invRemark;
		this.invIssDt = invIssDt;
		this.woVndrSeq = woVndrSeq;
		this.invRcvDt = invRcvDt;
		this.pagerows = pagerows;
		this.invHldFlg = invHldFlg;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.creOfcCd = creOfcCd;
		this.trspInvAudStsNm = trspInvAudStsNm;
		this.invVndrNm = invVndrNm;
		this.woVndrNm = woVndrNm;
		this.ovrWgtScgAmt = ovrWgtScgAmt;
		this.updDt = updDt;
		this.etcAddAmt = etcAddAmt;
		this.csrNo = csrNo;
		this.trspInvAudStsCd = trspInvAudStsCd;
		this.bzcAmt = bzcAmt;
		this.invCurrCd = invCurrCd;
		this.eqTpszCd = eqTpszCd;
		this.fuelScgAmt = fuelScgAmt;
		this.invNo = invNo;
		this.creUsrId = creUsrId;
		this.woTtlAmt = woTtlAmt;
		this.invChkTrnsNo = invChkTrnsNo;
		this.invBzcAmt = invBzcAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_ttl_amt", getInvTtlAmt());
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("inv_vndr_seq", getInvVndrSeq());
		this.hashColumns.put("inv_pay_mzd_cd", getInvPayMzdCd());
		this.hashColumns.put("inv_remark", getInvRemark());
		this.hashColumns.put("inv_iss_dt", getInvIssDt());
		this.hashColumns.put("wo_vndr_seq", getWoVndrSeq());
		this.hashColumns.put("inv_rcv_dt", getInvRcvDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_hld_flg", getInvHldFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("trsp_inv_aud_sts_nm", getTrspInvAudStsNm());
		this.hashColumns.put("inv_vndr_nm", getInvVndrNm());
		this.hashColumns.put("wo_vndr_nm", getWoVndrNm());
		this.hashColumns.put("ovr_wgt_scg_amt", getOvrWgtScgAmt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("etc_add_amt", getEtcAddAmt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("trsp_inv_aud_sts_cd", getTrspInvAudStsCd());
		this.hashColumns.put("bzc_amt", getBzcAmt());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("fuel_scg_amt", getFuelScgAmt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("wo_ttl_amt", getWoTtlAmt());
		this.hashColumns.put("inv_chk_trns_no", getInvChkTrnsNo());
		this.hashColumns.put("inv_bzc_amt", getInvBzcAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_ttl_amt", "invTtlAmt");
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("inv_vndr_seq", "invVndrSeq");
		this.hashFields.put("inv_pay_mzd_cd", "invPayMzdCd");
		this.hashFields.put("inv_remark", "invRemark");
		this.hashFields.put("inv_iss_dt", "invIssDt");
		this.hashFields.put("wo_vndr_seq", "woVndrSeq");
		this.hashFields.put("inv_rcv_dt", "invRcvDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_hld_flg", "invHldFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("trsp_inv_aud_sts_nm", "trspInvAudStsNm");
		this.hashFields.put("inv_vndr_nm", "invVndrNm");
		this.hashFields.put("wo_vndr_nm", "woVndrNm");
		this.hashFields.put("ovr_wgt_scg_amt", "ovrWgtScgAmt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("etc_add_amt", "etcAddAmt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("trsp_inv_aud_sts_cd", "trspInvAudStsCd");
		this.hashFields.put("bzc_amt", "bzcAmt");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("fuel_scg_amt", "fuelScgAmt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("wo_ttl_amt", "woTtlAmt");
		this.hashFields.put("inv_chk_trns_no", "invChkTrnsNo");
		this.hashFields.put("inv_bzc_amt", "invBzcAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return invTtlAmt
	 */
	public String getInvTtlAmt() {
		return this.invTtlAmt;
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
	 * @return invVndrSeq
	 */
	public String getInvVndrSeq() {
		return this.invVndrSeq;
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
	 * @return invRemark
	 */
	public String getInvRemark() {
		return this.invRemark;
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
	 * @return woVndrSeq
	 */
	public String getWoVndrSeq() {
		return this.woVndrSeq;
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
	 * @return invHldFlg
	 */
	public String getInvHldFlg() {
		return this.invHldFlg;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return trspInvAudStsNm
	 */
	public String getTrspInvAudStsNm() {
		return this.trspInvAudStsNm;
	}
	
	/**
	 * Column Info
	 * @return invVndrNm
	 */
	public String getInvVndrNm() {
		return this.invVndrNm;
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
	 * @return ovrWgtScgAmt
	 */
	public String getOvrWgtScgAmt() {
		return this.ovrWgtScgAmt;
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
	 * @return etcAddAmt
	 */
	public String getEtcAddAmt() {
		return this.etcAddAmt;
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
	 * @return trspInvAudStsCd
	 */
	public String getTrspInvAudStsCd() {
		return this.trspInvAudStsCd;
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
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
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
	 * @return fuelScgAmt
	 */
	public String getFuelScgAmt() {
		return this.fuelScgAmt;
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
	 * @return woTtlAmt
	 */
	public String getWoTtlAmt() {
		return this.woTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return invChkTrnsNo
	 */
	public String getInvChkTrnsNo() {
		return this.invChkTrnsNo;
	}
	
	/**
	 * Column Info
	 * @return invBzcAmt
	 */
	public String getInvBzcAmt() {
		return this.invBzcAmt;
	}
	

	/**
	 * Column Info
	 * @param invTtlAmt
	 */
	public void setInvTtlAmt(String invTtlAmt) {
		this.invTtlAmt = invTtlAmt;
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
	 * @param invVndrSeq
	 */
	public void setInvVndrSeq(String invVndrSeq) {
		this.invVndrSeq = invVndrSeq;
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
	 * @param invRemark
	 */
	public void setInvRemark(String invRemark) {
		this.invRemark = invRemark;
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
	 * @param woVndrSeq
	 */
	public void setWoVndrSeq(String woVndrSeq) {
		this.woVndrSeq = woVndrSeq;
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
	 * @param invHldFlg
	 */
	public void setInvHldFlg(String invHldFlg) {
		this.invHldFlg = invHldFlg;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param trspInvAudStsNm
	 */
	public void setTrspInvAudStsNm(String trspInvAudStsNm) {
		this.trspInvAudStsNm = trspInvAudStsNm;
	}
	
	/**
	 * Column Info
	 * @param invVndrNm
	 */
	public void setInvVndrNm(String invVndrNm) {
		this.invVndrNm = invVndrNm;
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
	 * @param ovrWgtScgAmt
	 */
	public void setOvrWgtScgAmt(String ovrWgtScgAmt) {
		this.ovrWgtScgAmt = ovrWgtScgAmt;
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
	 * @param etcAddAmt
	 */
	public void setEtcAddAmt(String etcAddAmt) {
		this.etcAddAmt = etcAddAmt;
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
	 * @param trspInvAudStsCd
	 */
	public void setTrspInvAudStsCd(String trspInvAudStsCd) {
		this.trspInvAudStsCd = trspInvAudStsCd;
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
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
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
	 * @param fuelScgAmt
	 */
	public void setFuelScgAmt(String fuelScgAmt) {
		this.fuelScgAmt = fuelScgAmt;
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
	 * @param woTtlAmt
	 */
	public void setWoTtlAmt(String woTtlAmt) {
		this.woTtlAmt = woTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param invChkTrnsNo
	 */
	public void setInvChkTrnsNo(String invChkTrnsNo) {
		this.invChkTrnsNo = invChkTrnsNo;
	}
	
	/**
	 * Column Info
	 * @param invBzcAmt
	 */
	public void setInvBzcAmt(String invBzcAmt) {
		this.invBzcAmt = invBzcAmt;
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
		setInvTtlAmt(JSPUtil.getParameter(request, prefix + "inv_ttl_amt", ""));
		setPayDt(JSPUtil.getParameter(request, prefix + "pay_dt", ""));
		setGlDt(JSPUtil.getParameter(request, prefix + "gl_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setInvVndrSeq(JSPUtil.getParameter(request, prefix + "inv_vndr_seq", ""));
		setInvPayMzdCd(JSPUtil.getParameter(request, prefix + "inv_pay_mzd_cd", ""));
		setInvRemark(JSPUtil.getParameter(request, prefix + "inv_remark", ""));
		setInvIssDt(JSPUtil.getParameter(request, prefix + "inv_iss_dt", ""));
		setWoVndrSeq(JSPUtil.getParameter(request, prefix + "wo_vndr_seq", ""));
		setInvRcvDt(JSPUtil.getParameter(request, prefix + "inv_rcv_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvHldFlg(JSPUtil.getParameter(request, prefix + "inv_hld_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setTrspInvAudStsNm(JSPUtil.getParameter(request, prefix + "trsp_inv_aud_sts_nm", ""));
		setInvVndrNm(JSPUtil.getParameter(request, prefix + "inv_vndr_nm", ""));
		setWoVndrNm(JSPUtil.getParameter(request, prefix + "wo_vndr_nm", ""));
		setOvrWgtScgAmt(JSPUtil.getParameter(request, prefix + "ovr_wgt_scg_amt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setEtcAddAmt(JSPUtil.getParameter(request, prefix + "etc_add_amt", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setTrspInvAudStsCd(JSPUtil.getParameter(request, prefix + "trsp_inv_aud_sts_cd", ""));
		setBzcAmt(JSPUtil.getParameter(request, prefix + "bzc_amt", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setFuelScgAmt(JSPUtil.getParameter(request, prefix + "fuel_scg_amt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setWoTtlAmt(JSPUtil.getParameter(request, prefix + "wo_ttl_amt", ""));
		setInvChkTrnsNo(JSPUtil.getParameter(request, prefix + "inv_chk_trns_no", ""));
		setInvBzcAmt(JSPUtil.getParameter(request, prefix + "inv_bzc_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchUsRailInvoiceInquirySecondExcelFormVO[]
	 */
	public SearchUsRailInvoiceInquirySecondExcelFormVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchUsRailInvoiceInquirySecondExcelFormVO[]
	 */
	public SearchUsRailInvoiceInquirySecondExcelFormVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchUsRailInvoiceInquirySecondExcelFormVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invTtlAmt = (JSPUtil.getParameter(request, prefix	+ "inv_ttl_amt", length));
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] invVndrSeq = (JSPUtil.getParameter(request, prefix	+ "inv_vndr_seq", length));
			String[] invPayMzdCd = (JSPUtil.getParameter(request, prefix	+ "inv_pay_mzd_cd", length));
			String[] invRemark = (JSPUtil.getParameter(request, prefix	+ "inv_remark", length));
			String[] invIssDt = (JSPUtil.getParameter(request, prefix	+ "inv_iss_dt", length));
			String[] woVndrSeq = (JSPUtil.getParameter(request, prefix	+ "wo_vndr_seq", length));
			String[] invRcvDt = (JSPUtil.getParameter(request, prefix	+ "inv_rcv_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invHldFlg = (JSPUtil.getParameter(request, prefix	+ "inv_hld_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] trspInvAudStsNm = (JSPUtil.getParameter(request, prefix	+ "trsp_inv_aud_sts_nm", length));
			String[] invVndrNm = (JSPUtil.getParameter(request, prefix	+ "inv_vndr_nm", length));
			String[] woVndrNm = (JSPUtil.getParameter(request, prefix	+ "wo_vndr_nm", length));
			String[] ovrWgtScgAmt = (JSPUtil.getParameter(request, prefix	+ "ovr_wgt_scg_amt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] etcAddAmt = (JSPUtil.getParameter(request, prefix	+ "etc_add_amt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] trspInvAudStsCd = (JSPUtil.getParameter(request, prefix	+ "trsp_inv_aud_sts_cd", length));
			String[] bzcAmt = (JSPUtil.getParameter(request, prefix	+ "bzc_amt", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] fuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "fuel_scg_amt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] woTtlAmt = (JSPUtil.getParameter(request, prefix	+ "wo_ttl_amt", length));
			String[] invChkTrnsNo = (JSPUtil.getParameter(request, prefix	+ "inv_chk_trns_no", length));
			String[] invBzcAmt = (JSPUtil.getParameter(request, prefix	+ "inv_bzc_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchUsRailInvoiceInquirySecondExcelFormVO();
				if (invTtlAmt[i] != null)
					model.setInvTtlAmt(invTtlAmt[i]);
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (invVndrSeq[i] != null)
					model.setInvVndrSeq(invVndrSeq[i]);
				if (invPayMzdCd[i] != null)
					model.setInvPayMzdCd(invPayMzdCd[i]);
				if (invRemark[i] != null)
					model.setInvRemark(invRemark[i]);
				if (invIssDt[i] != null)
					model.setInvIssDt(invIssDt[i]);
				if (woVndrSeq[i] != null)
					model.setWoVndrSeq(woVndrSeq[i]);
				if (invRcvDt[i] != null)
					model.setInvRcvDt(invRcvDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invHldFlg[i] != null)
					model.setInvHldFlg(invHldFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (trspInvAudStsNm[i] != null)
					model.setTrspInvAudStsNm(trspInvAudStsNm[i]);
				if (invVndrNm[i] != null)
					model.setInvVndrNm(invVndrNm[i]);
				if (woVndrNm[i] != null)
					model.setWoVndrNm(woVndrNm[i]);
				if (ovrWgtScgAmt[i] != null)
					model.setOvrWgtScgAmt(ovrWgtScgAmt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (etcAddAmt[i] != null)
					model.setEtcAddAmt(etcAddAmt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (trspInvAudStsCd[i] != null)
					model.setTrspInvAudStsCd(trspInvAudStsCd[i]);
				if (bzcAmt[i] != null)
					model.setBzcAmt(bzcAmt[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (fuelScgAmt[i] != null)
					model.setFuelScgAmt(fuelScgAmt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (woTtlAmt[i] != null)
					model.setWoTtlAmt(woTtlAmt[i]);
				if (invChkTrnsNo[i] != null)
					model.setInvChkTrnsNo(invChkTrnsNo[i]);
				if (invBzcAmt[i] != null)
					model.setInvBzcAmt(invBzcAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchUsRailInvoiceInquirySecondExcelFormVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchUsRailInvoiceInquirySecondExcelFormVO[]
	 */
	public SearchUsRailInvoiceInquirySecondExcelFormVO[] getSearchUsRailInvoiceInquirySecondExcelFormVOs(){
		SearchUsRailInvoiceInquirySecondExcelFormVO[] vos = (SearchUsRailInvoiceInquirySecondExcelFormVO[])models.toArray(new SearchUsRailInvoiceInquirySecondExcelFormVO[models.size()]);
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
		this.invTtlAmt = this.invTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDt = this.payDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVndrSeq = this.invVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPayMzdCd = this.invPayMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRemark = this.invRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssDt = this.invIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woVndrSeq = this.woVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRcvDt = this.invRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invHldFlg = this.invHldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspInvAudStsNm = this.trspInvAudStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVndrNm = this.invVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woVndrNm = this.woVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrWgtScgAmt = this.ovrWgtScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etcAddAmt = this.etcAddAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspInvAudStsCd = this.trspInvAudStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAmt = this.bzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fuelScgAmt = this.fuelScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woTtlAmt = this.woTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invChkTrnsNo = this.invChkTrnsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invBzcAmt = this.invBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
