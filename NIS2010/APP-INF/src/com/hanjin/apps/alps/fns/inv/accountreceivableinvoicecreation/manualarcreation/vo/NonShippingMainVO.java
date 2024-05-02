/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NonShippingMainVO.java
*@FileTitle : NonShippingMainVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.08.19 박정진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class NonShippingMainVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NonShippingMainVO> models = new ArrayList<NonShippingMainVO>();
	
	/* Column Info */
	private String custLoclLangNm = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String arTaxIndCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String lclVvd = null;
	/* Column Info */
	private String taxXchRt = null;
	/* Column Info */
	private String custRgstNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dpPrcsKnt = null;
	/* Column Info */
	private String amount = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String totalCurrCd = null;
	/* Column Info */
	private String lclCurr = null;
	/* Column Info */
	private String slpNo = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String taxAmount = null;
	/* Column Info */
	private String taxCurrCd = null;
	/* Column Info */
	private String invRmk = null;
	/* Column Info */
	private String totalLocalAmt = null;
	/* Column Info */
	private String dpPrcsKntLocal = null;
	/* Column Info */
	private String localAmount = null;
	/* Column Info */
	private String invNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public NonShippingMainVO() {}

	public NonShippingMainVO(String ibflag, String pagerows, String blSrcNo, String arIfNo, String arOfcCd, String effDt, String custCntCd, String custSeq, String custNm, String custLoclLangNm, String custRgstNo, String currCd, String amount, String lclCurr, String localAmount, String taxCurrCd, String taxXchRt, String arTaxIndCd, String taxAmount, String totalCurrCd, String totalLocalAmt, String invXchRt, String lclVvd, String polCd, String acctCd, String invRmk, String slpNo, String dpPrcsKnt, String dpPrcsKntLocal, String invNo) {
		this.custLoclLangNm = custLoclLangNm;
		this.currCd = currCd;
		this.arTaxIndCd = arTaxIndCd;
		this.custNm = custNm;
		this.lclVvd = lclVvd;
		this.taxXchRt = taxXchRt;
		this.custRgstNo = custRgstNo;
		this.pagerows = pagerows;
		this.dpPrcsKnt = dpPrcsKnt;
		this.amount = amount;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.arIfNo = arIfNo;
		this.acctCd = acctCd;
		this.custCntCd = custCntCd;
		this.invXchRt = invXchRt;
		this.blSrcNo = blSrcNo;
		this.totalCurrCd = totalCurrCd;
		this.lclCurr = lclCurr;
		this.slpNo = slpNo;
		this.custSeq = custSeq;
		this.arOfcCd = arOfcCd;
		this.taxAmount = taxAmount;
		this.taxCurrCd = taxCurrCd;
		this.invRmk = invRmk;
		this.totalLocalAmt = totalLocalAmt;
		this.dpPrcsKntLocal = dpPrcsKntLocal;
		this.localAmount = localAmount;
		this.invNo = invNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_locl_lang_nm", getCustLoclLangNm());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("ar_tax_ind_cd", getArTaxIndCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("lcl_vvd", getLclVvd());
		this.hashColumns.put("tax_xch_rt", getTaxXchRt());
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
		this.hashColumns.put("amount", getAmount());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("total_curr_cd", getTotalCurrCd());
		this.hashColumns.put("lcl_curr", getLclCurr());
		this.hashColumns.put("slp_no", getSlpNo());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("tax_amount", getTaxAmount());
		this.hashColumns.put("tax_curr_cd", getTaxCurrCd());
		this.hashColumns.put("inv_rmk", getInvRmk());
		this.hashColumns.put("total_local_amt", getTotalLocalAmt());
		this.hashColumns.put("dp_prcs_knt_local", getDpPrcsKntLocal());
		this.hashColumns.put("local_amount", getLocalAmount());
		this.hashColumns.put("inv_no", getInvNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_locl_lang_nm", "custLoclLangNm");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("ar_tax_ind_cd", "arTaxIndCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("lcl_vvd", "lclVvd");
		this.hashFields.put("tax_xch_rt", "taxXchRt");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("amount", "amount");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("total_curr_cd", "totalCurrCd");
		this.hashFields.put("lcl_curr", "lclCurr");
		this.hashFields.put("slp_no", "slpNo");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("tax_amount", "taxAmount");
		this.hashFields.put("tax_curr_cd", "taxCurrCd");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("total_local_amt", "totalLocalAmt");
		this.hashFields.put("dp_prcs_knt_local", "dpPrcsKntLocal");
		this.hashFields.put("local_amount", "localAmount");
		this.hashFields.put("inv_no", "invNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custLoclLangNm
	 */
	public String getCustLoclLangNm() {
		return this.custLoclLangNm;
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
	 * @return arTaxIndCd
	 */
	public String getArTaxIndCd() {
		return this.arTaxIndCd;
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
	 * @return lclVvd
	 */
	public String getLclVvd() {
		return this.lclVvd;
	}
	
	/**
	 * Column Info
	 * @return taxXchRt
	 */
	public String getTaxXchRt() {
		return this.taxXchRt;
	}
	
	/**
	 * Column Info
	 * @return custRgstNo
	 */
	public String getCustRgstNo() {
		return this.custRgstNo;
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
	 * @return amount
	 */
	public String getAmount() {
		return this.amount;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return totalCurrCd
	 */
	public String getTotalCurrCd() {
		return this.totalCurrCd;
	}
	
	/**
	 * Column Info
	 * @return lclCurr
	 */
	public String getLclCurr() {
		return this.lclCurr;
	}
	
	/**
	 * Column Info
	 * @return slpNo
	 */
	public String getSlpNo() {
		return this.slpNo;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}
	
	/**
	 * Column Info
	 * @return taxAmount
	 */
	public String getTaxAmount() {
		return this.taxAmount;
	}
	
	/**
	 * Column Info
	 * @return taxCurrCd
	 */
	public String getTaxCurrCd() {
		return this.taxCurrCd;
	}
	
	/**
	 * Column Info
	 * @return invRmk
	 */
	public String getInvRmk() {
		return this.invRmk;
	}
	
	/**
	 * Column Info
	 * @return totalLocalAmt
	 */
	public String getTotalLocalAmt() {
		return this.totalLocalAmt;
	}
	
	/**
	 * Column Info
	 * @return dpPrcsKntLocal
	 */
	public String getDpPrcsKntLocal() {
		return this.dpPrcsKntLocal;
	}
	
	/**
	 * Column Info
	 * @return localAmount
	 */
	public String getLocalAmount() {
		return this.localAmount;
	}
	

	/**
	 * Column Info
	 * @param custLoclLangNm
	 */
	public void setCustLoclLangNm(String custLoclLangNm) {
		this.custLoclLangNm = custLoclLangNm;
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
	 * @param arTaxIndCd
	 */
	public void setArTaxIndCd(String arTaxIndCd) {
		this.arTaxIndCd = arTaxIndCd;
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
	 * @param lclVvd
	 */
	public void setLclVvd(String lclVvd) {
		this.lclVvd = lclVvd;
	}
	
	/**
	 * Column Info
	 * @param taxXchRt
	 */
	public void setTaxXchRt(String taxXchRt) {
		this.taxXchRt = taxXchRt;
	}
	
	/**
	 * Column Info
	 * @param custRgstNo
	 */
	public void setCustRgstNo(String custRgstNo) {
		this.custRgstNo = custRgstNo;
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
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}
	
	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param totalCurrCd
	 */
	public void setTotalCurrCd(String totalCurrCd) {
		this.totalCurrCd = totalCurrCd;
	}
	
	/**
	 * Column Info
	 * @param lclCurr
	 */
	public void setLclCurr(String lclCurr) {
		this.lclCurr = lclCurr;
	}
	
	/**
	 * Column Info
	 * @param slpNo
	 */
	public void setSlpNo(String slpNo) {
		this.slpNo = slpNo;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Column Info
	 * @param taxAmount
	 */
	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}
	
	/**
	 * Column Info
	 * @param taxCurrCd
	 */
	public void setTaxCurrCd(String taxCurrCd) {
		this.taxCurrCd = taxCurrCd;
	}
	
	/**
	 * Column Info
	 * @param invRmk
	 */
	public void setInvRmk(String invRmk) {
		this.invRmk = invRmk;
	}
	
	/**
	 * Column Info
	 * @param totalLocalAmt
	 */
	public void setTotalLocalAmt(String totalLocalAmt) {
		this.totalLocalAmt = totalLocalAmt;
	}
	
	/**
	 * Column Info
	 * @param dpPrcsKntLocal
	 */
	public void setDpPrcsKntLocal(String dpPrcsKntLocal) {
		this.dpPrcsKntLocal = dpPrcsKntLocal;
	}
	
	/**
	 * Column Info
	 * @param localAmount
	 */
	public void setLocalAmount(String localAmount) {
		this.localAmount = localAmount;
	}
	
	public String getInvNo() {
		return invNo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCustLoclLangNm(JSPUtil.getParameter(request, "cust_locl_lang_nm", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setArTaxIndCd(JSPUtil.getParameter(request, "ar_tax_ind_cd", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setLclVvd(JSPUtil.getParameter(request, "lcl_vvd", ""));
		setTaxXchRt(JSPUtil.getParameter(request, "tax_xch_rt", ""));
		setCustRgstNo(JSPUtil.getParameter(request, "cust_rgst_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request, "dp_prcs_knt", ""));
		setAmount(JSPUtil.getParameter(request, "amount", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setInvXchRt(JSPUtil.getParameter(request, "inv_xch_rt", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setTotalCurrCd(JSPUtil.getParameter(request, "total_curr_cd", ""));
		setLclCurr(JSPUtil.getParameter(request, "lcl_curr", ""));
		setSlpNo(JSPUtil.getParameter(request, "slp_no", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setTaxAmount(JSPUtil.getParameter(request, "tax_amount", ""));
		setTaxCurrCd(JSPUtil.getParameter(request, "tax_curr_cd", ""));
		setInvRmk(JSPUtil.getParameter(request, "inv_rmk", ""));
		setTotalLocalAmt(JSPUtil.getParameter(request, "total_local_amt", ""));
		setDpPrcsKntLocal(JSPUtil.getParameter(request, "dp_prcs_knt_local", ""));
		setLocalAmount(JSPUtil.getParameter(request, "local_amount", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NonShippingMainVO[]
	 */
	public NonShippingMainVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NonShippingMainVO[]
	 */
	public NonShippingMainVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NonShippingMainVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custLoclLangNm = (JSPUtil.getParameter(request, prefix	+ "cust_locl_lang_nm", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] arTaxIndCd = (JSPUtil.getParameter(request, prefix	+ "ar_tax_ind_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] lclVvd = (JSPUtil.getParameter(request, prefix	+ "lcl_vvd", length));
			String[] taxXchRt = (JSPUtil.getParameter(request, prefix	+ "tax_xch_rt", length));
			String[] custRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt", length));
			String[] amount = (JSPUtil.getParameter(request, prefix	+ "amount", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] totalCurrCd = (JSPUtil.getParameter(request, prefix	+ "total_curr_cd", length));
			String[] lclCurr = (JSPUtil.getParameter(request, prefix	+ "lcl_curr", length));
			String[] slpNo = (JSPUtil.getParameter(request, prefix	+ "slp_no", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] taxAmount = (JSPUtil.getParameter(request, prefix	+ "tax_amount", length));
			String[] taxCurrCd = (JSPUtil.getParameter(request, prefix	+ "tax_curr_cd", length));
			String[] invRmk = (JSPUtil.getParameter(request, prefix	+ "inv_rmk", length));
			String[] totalLocalAmt = (JSPUtil.getParameter(request, prefix	+ "total_local_amt", length));
			String[] dpPrcsKntLocal = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt_local", length));
			String[] localAmount = (JSPUtil.getParameter(request, prefix	+ "local_amount", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new NonShippingMainVO();
				if (custLoclLangNm[i] != null)
					model.setCustLoclLangNm(custLoclLangNm[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (arTaxIndCd[i] != null)
					model.setArTaxIndCd(arTaxIndCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (lclVvd[i] != null)
					model.setLclVvd(lclVvd[i]);
				if (taxXchRt[i] != null)
					model.setTaxXchRt(taxXchRt[i]);
				if (custRgstNo[i] != null)
					model.setCustRgstNo(custRgstNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dpPrcsKnt[i] != null)
					model.setDpPrcsKnt(dpPrcsKnt[i]);
				if (amount[i] != null)
					model.setAmount(amount[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (totalCurrCd[i] != null)
					model.setTotalCurrCd(totalCurrCd[i]);
				if (lclCurr[i] != null)
					model.setLclCurr(lclCurr[i]);
				if (slpNo[i] != null)
					model.setSlpNo(slpNo[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (taxAmount[i] != null)
					model.setTaxAmount(taxAmount[i]);
				if (taxCurrCd[i] != null)
					model.setTaxCurrCd(taxCurrCd[i]);
				if (invRmk[i] != null)
					model.setInvRmk(invRmk[i]);
				if (totalLocalAmt[i] != null)
					model.setTotalLocalAmt(totalLocalAmt[i]);
				if (dpPrcsKntLocal[i] != null)
					model.setDpPrcsKntLocal(dpPrcsKntLocal[i]);
				if (localAmount[i] != null)
					model.setLocalAmount(localAmount[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNonShippingMainVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NonShippingMainVO[]
	 */
	public NonShippingMainVO[] getNonShippingMainVOs(){
		NonShippingMainVO[] vos = (NonShippingMainVO[])models.toArray(new NonShippingMainVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.custLoclLangNm = this.custLoclLangNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arTaxIndCd = this.arTaxIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclVvd = this.lclVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxXchRt = this.taxXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo = this.custRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt = this.dpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amount = this.amount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCurrCd = this.totalCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclCurr = this.lclCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpNo = this.slpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmount = this.taxAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxCurrCd = this.taxCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk = this.invRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalLocalAmt = this.totalLocalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKntLocal = this.dpPrcsKntLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localAmount = this.localAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
