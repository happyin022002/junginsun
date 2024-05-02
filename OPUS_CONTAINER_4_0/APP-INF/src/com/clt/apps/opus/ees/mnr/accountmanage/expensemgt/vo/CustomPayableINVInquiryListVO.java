/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomPayableINVInquiryListVO.java
*@FileTitle : CustomPayableINVInquiryListVO
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

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;
import java.util.LinkedHashMap;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */ 

public class CustomPayableINVInquiryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomPayableINVInquiryListVO> models = new ArrayList<CustomPayableINVInquiryListVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String payInvSeq = null;
	/* Column Info */
	private String issOfcCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dpPrcsKnt = null;
	/* Column Info */
	private String mnrPrnrSeq = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mnrInvStsCd = null;
	/* Column Info */
	private String mnrInvStsNm = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String mnrWrkAmt = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String mnrInvRmk = null;
	/* Column Info */
	private String invRgstNo = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String payTermDys = null;
	/* Column Info */
	private String whldTaxAmt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String slsTaxAmt = null;
	/* Column Info */
	private String vatAmt = null;
	/* Column Info */
	private String woTypeCode = null;
	/* Column Info */
	private String woType = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String payVndrLglEngNm = null;
	/* Column Info */
	private String mnrInpTpCd = null;
	/* Column Info */
	private String invAdjBzcAmt = null;
	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String payAmt = null;
	/* Column Info */
	private String paySts = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomPayableINVInquiryListVO() {}

	public CustomPayableINVInquiryListVO(String ibflag, String pagerows, String currCd, String payInvSeq, String issOfcCd, String vndrLglEngNm, String creDt, String ttlAmt, String mnrPrnrSeq, String dpPrcsKnt, String issDt, String effDt, String mnrInvStsCd, String mnrInvStsNm, String rcvDt, String mnrWrkAmt, String woNo, String mnrInvRmk, String invRgstNo, String csrNo, String costOfcCd, String cfmDt, String payTermDys, String whldTaxAmt, String invNo, String vatAmt, String woType, String woTypeCode, String vndrSeq, String payVndrLglEngNm, String slsTaxAmt, String mnrInpTpCd, String invAdjBzcAmt, String payDt, String payAmt, String paySts) {
		this.currCd = currCd;
		this.payInvSeq = payInvSeq;
		this.issOfcCd = issOfcCd;
		this.creDt = creDt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.ttlAmt = ttlAmt;
		this.pagerows = pagerows;
		this.dpPrcsKnt = dpPrcsKnt;
		this.mnrPrnrSeq = mnrPrnrSeq;
		this.issDt = issDt;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.mnrInvStsCd = mnrInvStsCd;
		this.mnrInvStsNm = mnrInvStsNm;
		this.rcvDt = rcvDt;
		this.mnrWrkAmt = mnrWrkAmt;
		this.woNo = woNo;
		this.mnrInvRmk = mnrInvRmk;
		this.invRgstNo = invRgstNo;
		this.csrNo = csrNo;
		this.costOfcCd = costOfcCd;
		this.cfmDt = cfmDt;
		this.payTermDys = payTermDys;
		this.whldTaxAmt = whldTaxAmt;
		this.invNo = invNo;
		this.slsTaxAmt = slsTaxAmt;
		this.vatAmt = vatAmt;
		this.woTypeCode = woTypeCode;
		this.woType = woType;
		this.vndrSeq = vndrSeq;
		this.payVndrLglEngNm = payVndrLglEngNm;
		this.mnrInpTpCd = mnrInpTpCd;
		this.invAdjBzcAmt = invAdjBzcAmt;
		this.payAmt = payAmt;
		this.payDt = payDt;
		this.paySts = paySts;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("pay_inv_seq", getPayInvSeq());
		this.hashColumns.put("iss_ofc_cd", getIssOfcCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
		this.hashColumns.put("mnr_prnr_seq", getMnrPrnrSeq());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mnr_inv_sts_cd", getMnrInvStsCd());
		this.hashColumns.put("mnr_inv_sts_nm", getMnrInvStsNm());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("mnr_wrk_amt", getMnrWrkAmt());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("mnr_inv_rmk", getMnrInvRmk());
		this.hashColumns.put("inv_rgst_no", getInvRgstNo());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("pay_term_dys", getPayTermDys());
		this.hashColumns.put("whld_tax_amt", getWhldTaxAmt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("sls_tax_amt", getSlsTaxAmt());
		this.hashColumns.put("vat_amt", getVatAmt());
		this.hashColumns.put("wo_type_code", getWoTypeCode());
		this.hashColumns.put("wo_type", getWoType());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("pay_vndr_lgl_eng_nm", getPayVndrLglEngNm());
		this.hashColumns.put("mnr_inp_tp_cd", getMnrInpTpCd());
		this.hashColumns.put("inv_adj_bzc_amt", getInvAdjBzcAmt());
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("pay_amt", getPayAmt());
		this.hashColumns.put("pay_sts", getPaySts());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pay_inv_seq", "payInvSeq");
		this.hashFields.put("iss_ofc_cd", "issOfcCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("mnr_prnr_seq", "mnrPrnrSeq");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnr_inv_sts_cd", "mnrInvStsCd");
		this.hashFields.put("mnr_inv_sts_nm", "mnrInvStsNm");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("mnr_wrk_amt", "mnrWrkAmt");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("mnr_inv_rmk", "mnrInvRmk");
		this.hashFields.put("inv_rgst_no", "invRgstNo");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("pay_term_dys", "payTermDys");
		this.hashFields.put("whld_tax_amt", "whldTaxAmt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("sls_tax_amt", "slsTaxAmt");
		this.hashFields.put("vat_amt", "vatAmt");
		this.hashFields.put("wo_type_code", "woTypeCode");
		this.hashFields.put("wo_type", "woType");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("pay_vndr_lgl_eng_nm", "payVndrLglEngNm");
		this.hashFields.put("mnr_inp_tp_cd", "mnrInpTpCd");
		this.hashFields.put("inv_adj_bzc_amt", "invAdjBzcAmt");
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("pay_amt", "payAmt");
		this.hashFields.put("pay_sts", "paySts");
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
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
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
	 * @return mnrInvStsNm
	 */
	public String getMnrInvStsNm() {
		return this.mnrInvStsNm;
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
	 * @return mnrWrkAmt
	 */
	public String getMnrWrkAmt() {
		return this.mnrWrkAmt;
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
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
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
	 * @return payTermDys
	 */
	public String getPayTermDys() {
		return this.payTermDys;
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
	 * @return woTypeCode
	 */
	public String getWoTypeCode() {
		return this.woTypeCode;
	}
	
	/**
	 * Column Info
	 * @return woType
	 */
	public String getWoType() {
		return this.woType;
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
	 * @return payVndrLglEngNm
	 */
	public String getPayVndrLglEngNm() {
		return this.payVndrLglEngNm;
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
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
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
	 * @param mnrInvStsNm
	 */
	public void setMnrInvStsNm(String mnrInvStsNm) {
		this.mnrInvStsNm = mnrInvStsNm;
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
	 * @param mnrWrkAmt
	 */
	public void setMnrWrkAmt(String mnrWrkAmt) {
		this.mnrWrkAmt = mnrWrkAmt;
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
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
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
	 * @param payTermDys
	 */
	public void setPayTermDys(String payTermDys) {
		this.payTermDys = payTermDys;
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
	 * @param woTypeCode
	 */
	public void setWoTypeCode(String woTypeCode) {
		this.woTypeCode = woTypeCode;
	}
	
	/**
	 * Column Info
	 * @param woType
	 */
	public void setWoType(String woType) {
		this.woType = woType;
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
	 * @param payVndrLglEngNm
	 */
	public void setPayVndrLglEngNm(String payVndrLglEngNm) {
		this.payVndrLglEngNm = payVndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param mnrInpTpCd
	 */
	public void setMnrInpTpCd(String mnrInpTpCd) {
		this.mnrInpTpCd = mnrInpTpCd;
	}
	
	public String getInvAdjBzcAmt() {
		return invAdjBzcAmt;
	}

	public void setInvAdjBzcAmt(String invAdjBzcAmt) {
		this.invAdjBzcAmt = invAdjBzcAmt;
	}

	public String getPayDt() {
		return payDt;
	}

	public void setPayDt(String payDt) {
		this.payDt = payDt;
	}

	public String getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(String payAmt) {
		this.payAmt = payAmt;
	}

	public String getPaySts() {
		return paySts;
	}

	public void setPaySts(String paySts) {
		this.paySts = paySts;
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
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPayInvSeq(JSPUtil.getParameter(request, prefix + "pay_inv_seq", ""));
		setIssOfcCd(JSPUtil.getParameter(request, prefix + "iss_ofc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request, prefix + "dp_prcs_knt", ""));
		setMnrPrnrSeq(JSPUtil.getParameter(request, prefix + "mnr_prnr_seq", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMnrInvStsCd(JSPUtil.getParameter(request, prefix + "mnr_inv_sts_cd", ""));
		setMnrInvStsNm(JSPUtil.getParameter(request, prefix + "mnr_inv_sts_nm", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setMnrWrkAmt(JSPUtil.getParameter(request, prefix + "mnr_wrk_amt", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setMnrInvRmk(JSPUtil.getParameter(request, prefix + "mnr_inv_rmk", ""));
		setInvRgstNo(JSPUtil.getParameter(request, prefix + "inv_rgst_no", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setCfmDt(JSPUtil.getParameter(request, prefix + "cfm_dt", ""));
		setPayTermDys(JSPUtil.getParameter(request, prefix + "pay_term_dys", ""));
		setWhldTaxAmt(JSPUtil.getParameter(request, prefix + "whld_tax_amt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setSlsTaxAmt(JSPUtil.getParameter(request, prefix + "sls_tax_amt", ""));
		setVatAmt(JSPUtil.getParameter(request, prefix + "vat_amt", ""));
		setWoTypeCode(JSPUtil.getParameter(request, prefix + "wo_type_code", ""));
		setWoType(JSPUtil.getParameter(request, prefix + "wo_type", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setPayVndrLglEngNm(JSPUtil.getParameter(request, prefix + "pay_vndr_lgl_eng_nm", ""));
		setMnrInpTpCd(JSPUtil.getParameter(request, prefix + "mnr_inp_tp_cd", ""));
		setInvAdjBzcAmt(JSPUtil.getParameter(request, prefix + "inv_adj_bzc_amt", ""));
		setPayDt(JSPUtil.getParameter(request, prefix + "pay_dt", ""));
		setPayAmt(JSPUtil.getParameter(request, prefix + "pay_amt", ""));
		setPaySts(JSPUtil.getParameter(request, prefix + "pay_sts", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomPayableINVInquiryListVO[]
	 */
	public CustomPayableINVInquiryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomPayableINVInquiryListVO[]
	 */
	public CustomPayableINVInquiryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomPayableINVInquiryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] payInvSeq = (JSPUtil.getParameter(request, prefix	+ "pay_inv_seq", length));
			String[] issOfcCd = (JSPUtil.getParameter(request, prefix	+ "iss_ofc_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt", length));
			String[] mnrPrnrSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_seq", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mnrInvStsCd = (JSPUtil.getParameter(request, prefix	+ "mnr_inv_sts_cd", length));
			String[] mnrInvStsNm = (JSPUtil.getParameter(request, prefix	+ "mnr_inv_sts_nm", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] mnrWrkAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_wrk_amt", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] mnrInvRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_inv_rmk", length));
			String[] invRgstNo = (JSPUtil.getParameter(request, prefix	+ "inv_rgst_no", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] payTermDys = (JSPUtil.getParameter(request, prefix	+ "pay_term_dys", length));
			String[] whldTaxAmt = (JSPUtil.getParameter(request, prefix	+ "whld_tax_amt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] slsTaxAmt = (JSPUtil.getParameter(request, prefix	+ "sls_tax_amt", length));
			String[] vatAmt = (JSPUtil.getParameter(request, prefix	+ "vat_amt", length));
			String[] woTypeCode = (JSPUtil.getParameter(request, prefix	+ "wo_type_code", length));
			String[] woType = (JSPUtil.getParameter(request, prefix	+ "wo_type", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] payVndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "pay_vndr_lgl_eng_nm", length));
			String[] mnrInpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_inp_tp_cd", length));
			String[] invAdjBzcAmt = (JSPUtil.getParameter(request, prefix	+ "inv_adj_bzc_amt", length));
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] payAmt = (JSPUtil.getParameter(request, prefix	+ "pay_amt", length));
			String[] paySts = (JSPUtil.getParameter(request, prefix	+ "pay_sts", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomPayableINVInquiryListVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (payInvSeq[i] != null)
					model.setPayInvSeq(payInvSeq[i]);
				if (issOfcCd[i] != null)
					model.setIssOfcCd(issOfcCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dpPrcsKnt[i] != null)
					model.setDpPrcsKnt(dpPrcsKnt[i]);
				if (mnrPrnrSeq[i] != null)
					model.setMnrPrnrSeq(mnrPrnrSeq[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnrInvStsCd[i] != null)
					model.setMnrInvStsCd(mnrInvStsCd[i]);
				if (mnrInvStsNm[i] != null)
					model.setMnrInvStsNm(mnrInvStsNm[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (mnrWrkAmt[i] != null)
					model.setMnrWrkAmt(mnrWrkAmt[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (mnrInvRmk[i] != null)
					model.setMnrInvRmk(mnrInvRmk[i]);
				if (invRgstNo[i] != null)
					model.setInvRgstNo(invRgstNo[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (payTermDys[i] != null)
					model.setPayTermDys(payTermDys[i]);
				if (whldTaxAmt[i] != null)
					model.setWhldTaxAmt(whldTaxAmt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (slsTaxAmt[i] != null)
					model.setSlsTaxAmt(slsTaxAmt[i]);
				if (vatAmt[i] != null)
					model.setVatAmt(vatAmt[i]);
				if (woTypeCode[i] != null)
					model.setWoTypeCode(woTypeCode[i]);
				if (woType[i] != null)
					model.setWoType(woType[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (payVndrLglEngNm[i] != null)
					model.setPayVndrLglEngNm(payVndrLglEngNm[i]);
				if (mnrInpTpCd[i] != null)
					model.setMnrInpTpCd(mnrInpTpCd[i]);
				if (invAdjBzcAmt[i] != null)
					model.setInvAdjBzcAmt(invAdjBzcAmt[i]);
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (payAmt[i] != null)
					model.setPayAmt(payAmt[i]);
				if (paySts[i] != null)
					model.setPaySts(paySts[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomPayableINVInquiryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomPayableINVInquiryListVO[]
	 */
	public CustomPayableINVInquiryListVO[] getCustomPayableINVInquiryListVOs(){
		CustomPayableINVInquiryListVO[] vos = (CustomPayableINVInquiryListVO[])models.toArray(new CustomPayableINVInquiryListVO[models.size()]);
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
		this.issOfcCd = this.issOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt = this.dpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrSeq = this.mnrPrnrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvStsCd = this.mnrInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvStsNm = this.mnrInvStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrWrkAmt = this.mnrWrkAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvRmk = this.mnrInvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRgstNo = this.invRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermDys = this.payTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whldTaxAmt = this.whldTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsTaxAmt = this.slsTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatAmt = this.vatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woTypeCode = this.woTypeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woType = this.woType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payVndrLglEngNm = this.payVndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInpTpCd = this.mnrInpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAdjBzcAmt = this.invAdjBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDt = this.payDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAmt = this.payAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paySts = this.paySts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
