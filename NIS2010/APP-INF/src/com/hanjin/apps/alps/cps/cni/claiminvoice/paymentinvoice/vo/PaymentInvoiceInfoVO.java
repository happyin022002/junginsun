/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PaymentInvoiceInfoVO.java
*@FileTitle : PaymentInvoiceInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.07
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.04.07 진윤오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.claiminvoice.paymentinvoice.vo;

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
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PaymentInvoiceInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PaymentInvoiceInfoVO> models = new ArrayList<PaymentInvoiceInfoVO>();
	
	/* Column Info */
	private String apCtrlOfcCd = null;
	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String trnkRefVvdNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String ptyNm = null;
	/* Column Info */
	private String invNetAmt = null;
	/* Column Info */
	private String costDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invRgstSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invStsCd = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String clmCostTpNm = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String clmPtyAbbrNm = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String invEffDt = null;
	/* Column Info */
	private String invRgstNo = null;
	/* Column Info */
	private String invDt = null;
	/* Column Info */
	private String vndrTermNm = null;
	/* Column Info */
	private String invVatAmt = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String whldTaxAmt = null;
	/* Column Info */
	private String clmCostTpCd = null;
	/* Column Info */
	private String cgoClmPayNo = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String vndrSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PaymentInvoiceInfoVO() {}

	public PaymentInvoiceInfoVO(String ibflag, String pagerows, String cgoClmPayNo, String cgoClmNo, String invNo, String invDt, String clmCostTpCd, String clmCostTpNm, String acctCd, String invOfcCd, String clmPtyAbbrNm, String ptyNm, String costOfcCd, String trnkRefVvdNo, String slanCd, String payDt, String vndrSeq, String vndrLglEngNm, String apCtrlOfcCd, String costDesc, String loclCurrCd, String invAmt, String invNetAmt, String invVatAmt, String whldTaxAmt, String invRgstNo, String creDt, String invEffDt, String vndrTermNm, String invRgstSeq, String invStsCd) {
		this.apCtrlOfcCd = apCtrlOfcCd;
		this.payDt = payDt;
		this.trnkRefVvdNo = trnkRefVvdNo;
		this.creDt = creDt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.ptyNm = ptyNm;
		this.invNetAmt = invNetAmt;
		this.costDesc = costDesc;
		this.pagerows = pagerows;
		this.invRgstSeq = invRgstSeq;
		this.ibflag = ibflag;
		this.invStsCd = invStsCd;
		this.acctCd = acctCd;
		this.clmCostTpNm = clmCostTpNm;
		this.invAmt = invAmt;
		this.cgoClmNo = cgoClmNo;
		this.clmPtyAbbrNm = clmPtyAbbrNm;
		this.invOfcCd = invOfcCd;
		this.invEffDt = invEffDt;
		this.invRgstNo = invRgstNo;
		this.invDt = invDt;
		this.vndrTermNm = vndrTermNm;
		this.invVatAmt = invVatAmt;
		this.costOfcCd = costOfcCd;
		this.loclCurrCd = loclCurrCd;
		this.whldTaxAmt = whldTaxAmt;
		this.clmCostTpCd = clmCostTpCd;
		this.cgoClmPayNo = cgoClmPayNo;
		this.invNo = invNo;
		this.slanCd = slanCd;
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ap_ctrl_ofc_cd", getApCtrlOfcCd());
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("trnk_ref_vvd_no", getTrnkRefVvdNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("pty_nm", getPtyNm());
		this.hashColumns.put("inv_net_amt", getInvNetAmt());
		this.hashColumns.put("cost_desc", getCostDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_rgst_seq", getInvRgstSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_sts_cd", getInvStsCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("clm_cost_tp_nm", getClmCostTpNm());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("clm_pty_abbr_nm", getClmPtyAbbrNm());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("inv_eff_dt", getInvEffDt());
		this.hashColumns.put("inv_rgst_no", getInvRgstNo());
		this.hashColumns.put("inv_dt", getInvDt());
		this.hashColumns.put("vndr_term_nm", getVndrTermNm());
		this.hashColumns.put("inv_vat_amt", getInvVatAmt());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("whld_tax_amt", getWhldTaxAmt());
		this.hashColumns.put("clm_cost_tp_cd", getClmCostTpCd());
		this.hashColumns.put("cgo_clm_pay_no", getCgoClmPayNo());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ap_ctrl_ofc_cd", "apCtrlOfcCd");
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("trnk_ref_vvd_no", "trnkRefVvdNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("pty_nm", "ptyNm");
		this.hashFields.put("inv_net_amt", "invNetAmt");
		this.hashFields.put("cost_desc", "costDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_rgst_seq", "invRgstSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_sts_cd", "invStsCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("clm_cost_tp_nm", "clmCostTpNm");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("clm_pty_abbr_nm", "clmPtyAbbrNm");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("inv_eff_dt", "invEffDt");
		this.hashFields.put("inv_rgst_no", "invRgstNo");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("vndr_term_nm", "vndrTermNm");
		this.hashFields.put("inv_vat_amt", "invVatAmt");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("whld_tax_amt", "whldTaxAmt");
		this.hashFields.put("clm_cost_tp_cd", "clmCostTpCd");
		this.hashFields.put("cgo_clm_pay_no", "cgoClmPayNo");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return apCtrlOfcCd
	 */
	public String getApCtrlOfcCd() {
		return this.apCtrlOfcCd;
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
	 * @return trnkRefVvdNo
	 */
	public String getTrnkRefVvdNo() {
		return this.trnkRefVvdNo;
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
	 * @return ptyNm
	 */
	public String getPtyNm() {
		return this.ptyNm;
	}
	
	/**
	 * Column Info
	 * @return invNetAmt
	 */
	public String getInvNetAmt() {
		return this.invNetAmt;
	}
	
	/**
	 * Column Info
	 * @return costDesc
	 */
	public String getCostDesc() {
		return this.costDesc;
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
	 * @return invRgstSeq
	 */
	public String getInvRgstSeq() {
		return this.invRgstSeq;
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
	 * @return invStsCd
	 */
	public String getInvStsCd() {
		return this.invStsCd;
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
	 * @return clmCostTpNm
	 */
	public String getClmCostTpNm() {
		return this.clmCostTpNm;
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
	 * @return cgoClmNo
	 */
	public String getCgoClmNo() {
		return this.cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @return clmPtyAbbrNm
	 */
	public String getClmPtyAbbrNm() {
		return this.clmPtyAbbrNm;
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
	 * @return invEffDt
	 */
	public String getInvEffDt() {
		return this.invEffDt;
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
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
	}
	
	/**
	 * Column Info
	 * @return vndrTermNm
	 */
	public String getVndrTermNm() {
		return this.vndrTermNm;
	}
	
	/**
	 * Column Info
	 * @return invVatAmt
	 */
	public String getInvVatAmt() {
		return this.invVatAmt;
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
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
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
	 * @return clmCostTpCd
	 */
	public String getClmCostTpCd() {
		return this.clmCostTpCd;
	}
	
	/**
	 * Column Info
	 * @return cgoClmPayNo
	 */
	public String getCgoClmPayNo() {
		return this.cgoClmPayNo;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
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
	 * @param apCtrlOfcCd
	 */
	public void setApCtrlOfcCd(String apCtrlOfcCd) {
		this.apCtrlOfcCd = apCtrlOfcCd;
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
	 * @param trnkRefVvdNo
	 */
	public void setTrnkRefVvdNo(String trnkRefVvdNo) {
		this.trnkRefVvdNo = trnkRefVvdNo;
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
	 * @param ptyNm
	 */
	public void setPtyNm(String ptyNm) {
		this.ptyNm = ptyNm;
	}
	
	/**
	 * Column Info
	 * @param invNetAmt
	 */
	public void setInvNetAmt(String invNetAmt) {
		this.invNetAmt = invNetAmt;
	}
	
	/**
	 * Column Info
	 * @param costDesc
	 */
	public void setCostDesc(String costDesc) {
		this.costDesc = costDesc;
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
	 * @param invRgstSeq
	 */
	public void setInvRgstSeq(String invRgstSeq) {
		this.invRgstSeq = invRgstSeq;
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
	 * @param invStsCd
	 */
	public void setInvStsCd(String invStsCd) {
		this.invStsCd = invStsCd;
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
	 * @param clmCostTpNm
	 */
	public void setClmCostTpNm(String clmCostTpNm) {
		this.clmCostTpNm = clmCostTpNm;
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
	 * @param cgoClmNo
	 */
	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @param clmPtyAbbrNm
	 */
	public void setClmPtyAbbrNm(String clmPtyAbbrNm) {
		this.clmPtyAbbrNm = clmPtyAbbrNm;
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
	 * @param invEffDt
	 */
	public void setInvEffDt(String invEffDt) {
		this.invEffDt = invEffDt;
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
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
	}
	
	/**
	 * Column Info
	 * @param vndrTermNm
	 */
	public void setVndrTermNm(String vndrTermNm) {
		this.vndrTermNm = vndrTermNm;
	}
	
	/**
	 * Column Info
	 * @param invVatAmt
	 */
	public void setInvVatAmt(String invVatAmt) {
		this.invVatAmt = invVatAmt;
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
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
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
	 * @param clmCostTpCd
	 */
	public void setClmCostTpCd(String clmCostTpCd) {
		this.clmCostTpCd = clmCostTpCd;
	}
	
	/**
	 * Column Info
	 * @param cgoClmPayNo
	 */
	public void setCgoClmPayNo(String cgoClmPayNo) {
		this.cgoClmPayNo = cgoClmPayNo;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
		setApCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ap_ctrl_ofc_cd", ""));
		setPayDt(JSPUtil.getParameter(request, prefix + "pay_dt", ""));
		setTrnkRefVvdNo(JSPUtil.getParameter(request, prefix + "trnk_ref_vvd_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setPtyNm(JSPUtil.getParameter(request, prefix + "pty_nm", ""));
		setInvNetAmt(JSPUtil.getParameter(request, prefix + "inv_net_amt", ""));
		setCostDesc(JSPUtil.getParameter(request, prefix + "cost_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvRgstSeq(JSPUtil.getParameter(request, prefix + "inv_rgst_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInvStsCd(JSPUtil.getParameter(request, prefix + "inv_sts_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setClmCostTpNm(JSPUtil.getParameter(request, prefix + "clm_cost_tp_nm", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setCgoClmNo(JSPUtil.getParameter(request, prefix + "cgo_clm_no", ""));
		setClmPtyAbbrNm(JSPUtil.getParameter(request, prefix + "clm_pty_abbr_nm", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setInvEffDt(JSPUtil.getParameter(request, prefix + "inv_eff_dt", ""));
		setInvRgstNo(JSPUtil.getParameter(request, prefix + "inv_rgst_no", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
		setVndrTermNm(JSPUtil.getParameter(request, prefix + "vndr_term_nm", ""));
		setInvVatAmt(JSPUtil.getParameter(request, prefix + "inv_vat_amt", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setWhldTaxAmt(JSPUtil.getParameter(request, prefix + "whld_tax_amt", ""));
		setClmCostTpCd(JSPUtil.getParameter(request, prefix + "clm_cost_tp_cd", ""));
		setCgoClmPayNo(JSPUtil.getParameter(request, prefix + "cgo_clm_pay_no", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PaymentInvoiceInfoVO[]
	 */
	public PaymentInvoiceInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PaymentInvoiceInfoVO[]
	 */
	public PaymentInvoiceInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PaymentInvoiceInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] apCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_ctrl_ofc_cd", length));
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] trnkRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "trnk_ref_vvd_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] ptyNm = (JSPUtil.getParameter(request, prefix	+ "pty_nm", length));
			String[] invNetAmt = (JSPUtil.getParameter(request, prefix	+ "inv_net_amt", length));
			String[] costDesc = (JSPUtil.getParameter(request, prefix	+ "cost_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invRgstSeq = (JSPUtil.getParameter(request, prefix	+ "inv_rgst_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invStsCd = (JSPUtil.getParameter(request, prefix	+ "inv_sts_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] clmCostTpNm = (JSPUtil.getParameter(request, prefix	+ "clm_cost_tp_nm", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] clmPtyAbbrNm = (JSPUtil.getParameter(request, prefix	+ "clm_pty_abbr_nm", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] invEffDt = (JSPUtil.getParameter(request, prefix	+ "inv_eff_dt", length));
			String[] invRgstNo = (JSPUtil.getParameter(request, prefix	+ "inv_rgst_no", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			String[] vndrTermNm = (JSPUtil.getParameter(request, prefix	+ "vndr_term_nm", length));
			String[] invVatAmt = (JSPUtil.getParameter(request, prefix	+ "inv_vat_amt", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] whldTaxAmt = (JSPUtil.getParameter(request, prefix	+ "whld_tax_amt", length));
			String[] clmCostTpCd = (JSPUtil.getParameter(request, prefix	+ "clm_cost_tp_cd", length));
			String[] cgoClmPayNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_pay_no", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new PaymentInvoiceInfoVO();
				if (apCtrlOfcCd[i] != null)
					model.setApCtrlOfcCd(apCtrlOfcCd[i]);
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (trnkRefVvdNo[i] != null)
					model.setTrnkRefVvdNo(trnkRefVvdNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (ptyNm[i] != null)
					model.setPtyNm(ptyNm[i]);
				if (invNetAmt[i] != null)
					model.setInvNetAmt(invNetAmt[i]);
				if (costDesc[i] != null)
					model.setCostDesc(costDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invRgstSeq[i] != null)
					model.setInvRgstSeq(invRgstSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invStsCd[i] != null)
					model.setInvStsCd(invStsCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (clmCostTpNm[i] != null)
					model.setClmCostTpNm(clmCostTpNm[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (clmPtyAbbrNm[i] != null)
					model.setClmPtyAbbrNm(clmPtyAbbrNm[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (invEffDt[i] != null)
					model.setInvEffDt(invEffDt[i]);
				if (invRgstNo[i] != null)
					model.setInvRgstNo(invRgstNo[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				if (vndrTermNm[i] != null)
					model.setVndrTermNm(vndrTermNm[i]);
				if (invVatAmt[i] != null)
					model.setInvVatAmt(invVatAmt[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (whldTaxAmt[i] != null)
					model.setWhldTaxAmt(whldTaxAmt[i]);
				if (clmCostTpCd[i] != null)
					model.setClmCostTpCd(clmCostTpCd[i]);
				if (cgoClmPayNo[i] != null)
					model.setCgoClmPayNo(cgoClmPayNo[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPaymentInvoiceInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PaymentInvoiceInfoVO[]
	 */
	public PaymentInvoiceInfoVO[] getPaymentInvoiceInfoVOs(){
		PaymentInvoiceInfoVO[] vos = (PaymentInvoiceInfoVO[])models.toArray(new PaymentInvoiceInfoVO[models.size()]);
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
		this.apCtrlOfcCd = this.apCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDt = this.payDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkRefVvdNo = this.trnkRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyNm = this.ptyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNetAmt = this.invNetAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDesc = this.costDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRgstSeq = this.invRgstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invStsCd = this.invStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmCostTpNm = this.clmCostTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyAbbrNm = this.clmPtyAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEffDt = this.invEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRgstNo = this.invRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrTermNm = this.vndrTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVatAmt = this.invVatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whldTaxAmt = this.whldTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmCostTpCd = this.clmCostTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmPayNo = this.cgoClmPayNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
