/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PaymentInvoiceVO.java
*@FileTitle : PaymentInvoiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.04
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.03.04 진윤오 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PaymentInvoiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PaymentInvoiceVO> models = new ArrayList<PaymentInvoiceVO>();
	
	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String cgoClmStsNm = null;
	/* Column Info */
	private String costDesc = null;
	/* Column Info */
	private String apPayFlg = null;
	/* Column Info */
	private String apPayDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invStsCd = null;
	/* Column Info */
	private String cgoClmDivNm = null;
	/* Column Info */
	private String clmCostTpNm = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String invDt = null;
	/* Column Info */
	private String invRgstNo = null;
	/* Column Info */
	private String invEffDt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String invUsdAmt = null;
	/* Column Info */
	private String apCxlDt = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String apPayAmt = null;
	/* Column Info */
	private String cgoClmPayNo = null;
	/* Column Info */
	private String hdlrUsrId = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String clmPtyNm = null;
	/* Column Info */
	private String invRmk = null;
	/* Column Info */
	private String clmAreaCd = null;
	/* Column Info */
	private String hdlrOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PaymentInvoiceVO() {}

	public PaymentInvoiceVO(String ibflag, String pagerows, String invRgstNo, String cgoClmPayNo, String cgoClmNo, String clmCostTpNm, String clmPtyNm, String invNo, String invDt, String loclCurrCd, String invAmt, String csrNo, String invStsCd, String apCxlDt, String apPayFlg, String apPayDt, String apPayAmt, String costDesc, String payDt, String invEffDt, String invXchRt, String invUsdAmt, String invRmk, String clmAreaCd, String hdlrOfcCd, String hdlrUsrId, String cgoClmStsNm, String cgoClmDivNm) {
		this.payDt = payDt;
		this.cgoClmStsNm = cgoClmStsNm;
		this.costDesc = costDesc;
		this.apPayFlg = apPayFlg;
		this.apPayDt = apPayDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.invStsCd = invStsCd;
		this.cgoClmDivNm = cgoClmDivNm;
		this.clmCostTpNm = clmCostTpNm;
		this.invAmt = invAmt;
		this.cgoClmNo = cgoClmNo;
		this.invXchRt = invXchRt;
		this.invDt = invDt;
		this.invRgstNo = invRgstNo;
		this.invEffDt = invEffDt;
		this.csrNo = csrNo;
		this.invUsdAmt = invUsdAmt;
		this.apCxlDt = apCxlDt;
		this.loclCurrCd = loclCurrCd;
		this.apPayAmt = apPayAmt;
		this.cgoClmPayNo = cgoClmPayNo;
		this.hdlrUsrId = hdlrUsrId;
		this.invNo = invNo;
		this.clmPtyNm = clmPtyNm;
		this.invRmk = invRmk;
		this.clmAreaCd = clmAreaCd;
		this.hdlrOfcCd = hdlrOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("cgo_clm_sts_nm", getCgoClmStsNm());
		this.hashColumns.put("cost_desc", getCostDesc());
		this.hashColumns.put("ap_pay_flg", getApPayFlg());
		this.hashColumns.put("ap_pay_dt", getApPayDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_sts_cd", getInvStsCd());
		this.hashColumns.put("cgo_clm_div_nm", getCgoClmDivNm());
		this.hashColumns.put("clm_cost_tp_nm", getClmCostTpNm());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("inv_dt", getInvDt());
		this.hashColumns.put("inv_rgst_no", getInvRgstNo());
		this.hashColumns.put("inv_eff_dt", getInvEffDt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("inv_usd_amt", getInvUsdAmt());
		this.hashColumns.put("ap_cxl_dt", getApCxlDt());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("ap_pay_amt", getApPayAmt());
		this.hashColumns.put("cgo_clm_pay_no", getCgoClmPayNo());
		this.hashColumns.put("hdlr_usr_id", getHdlrUsrId());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("clm_pty_nm", getClmPtyNm());
		this.hashColumns.put("inv_rmk", getInvRmk());
		this.hashColumns.put("clm_area_cd", getClmAreaCd());
		this.hashColumns.put("hdlr_ofc_cd", getHdlrOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("cgo_clm_sts_nm", "cgoClmStsNm");
		this.hashFields.put("cost_desc", "costDesc");
		this.hashFields.put("ap_pay_flg", "apPayFlg");
		this.hashFields.put("ap_pay_dt", "apPayDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_sts_cd", "invStsCd");
		this.hashFields.put("cgo_clm_div_nm", "cgoClmDivNm");
		this.hashFields.put("clm_cost_tp_nm", "clmCostTpNm");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("inv_rgst_no", "invRgstNo");
		this.hashFields.put("inv_eff_dt", "invEffDt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("inv_usd_amt", "invUsdAmt");
		this.hashFields.put("ap_cxl_dt", "apCxlDt");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("ap_pay_amt", "apPayAmt");
		this.hashFields.put("cgo_clm_pay_no", "cgoClmPayNo");
		this.hashFields.put("hdlr_usr_id", "hdlrUsrId");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("clm_pty_nm", "clmPtyNm");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("clm_area_cd", "clmAreaCd");
		this.hashFields.put("hdlr_ofc_cd", "hdlrOfcCd");
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
	 * @return cgoClmStsNm
	 */
	public String getCgoClmStsNm() {
		return this.cgoClmStsNm;
	}
	
	/**
	 * Column Info
	 * @return costDesc
	 */
	public String getCostDesc() {
		return this.costDesc;
	}
	
	/**
	 * Column Info
	 * @return apPayFlg
	 */
	public String getApPayFlg() {
		return this.apPayFlg;
	}
	
	/**
	 * Column Info
	 * @return apPayDt
	 */
	public String getApPayDt() {
		return this.apPayDt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return cgoClmDivNm
	 */
	public String getCgoClmDivNm() {
		return this.cgoClmDivNm;
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
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
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
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return invUsdAmt
	 */
	public String getInvUsdAmt() {
		return this.invUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return apCxlDt
	 */
	public String getApCxlDt() {
		return this.apCxlDt;
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
	 * @return apPayAmt
	 */
	public String getApPayAmt() {
		return this.apPayAmt;
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
	 * @return hdlrUsrId
	 */
	public String getHdlrUsrId() {
		return this.hdlrUsrId;
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
	 * @return clmPtyNm
	 */
	public String getClmPtyNm() {
		return this.clmPtyNm;
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
	 * @return clmAreaCd
	 */
	public String getClmAreaCd() {
		return this.clmAreaCd;
	}
	
	/**
	 * Column Info
	 * @return hdlrOfcCd
	 */
	public String getHdlrOfcCd() {
		return this.hdlrOfcCd;
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
	 * @param cgoClmStsNm
	 */
	public void setCgoClmStsNm(String cgoClmStsNm) {
		this.cgoClmStsNm = cgoClmStsNm;
	}
	
	/**
	 * Column Info
	 * @param costDesc
	 */
	public void setCostDesc(String costDesc) {
		this.costDesc = costDesc;
	}
	
	/**
	 * Column Info
	 * @param apPayFlg
	 */
	public void setApPayFlg(String apPayFlg) {
		this.apPayFlg = apPayFlg;
	}
	
	/**
	 * Column Info
	 * @param apPayDt
	 */
	public void setApPayDt(String apPayDt) {
		this.apPayDt = apPayDt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param cgoClmDivNm
	 */
	public void setCgoClmDivNm(String cgoClmDivNm) {
		this.cgoClmDivNm = cgoClmDivNm;
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
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
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
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param invUsdAmt
	 */
	public void setInvUsdAmt(String invUsdAmt) {
		this.invUsdAmt = invUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param apCxlDt
	 */
	public void setApCxlDt(String apCxlDt) {
		this.apCxlDt = apCxlDt;
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
	 * @param apPayAmt
	 */
	public void setApPayAmt(String apPayAmt) {
		this.apPayAmt = apPayAmt;
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
	 * @param hdlrUsrId
	 */
	public void setHdlrUsrId(String hdlrUsrId) {
		this.hdlrUsrId = hdlrUsrId;
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
	 * @param clmPtyNm
	 */
	public void setClmPtyNm(String clmPtyNm) {
		this.clmPtyNm = clmPtyNm;
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
	 * @param clmAreaCd
	 */
	public void setClmAreaCd(String clmAreaCd) {
		this.clmAreaCd = clmAreaCd;
	}
	
	/**
	 * Column Info
	 * @param hdlrOfcCd
	 */
	public void setHdlrOfcCd(String hdlrOfcCd) {
		this.hdlrOfcCd = hdlrOfcCd;
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
		setCgoClmStsNm(JSPUtil.getParameter(request, prefix + "cgo_clm_sts_nm", ""));
		setCostDesc(JSPUtil.getParameter(request, prefix + "cost_desc", ""));
		setApPayFlg(JSPUtil.getParameter(request, prefix + "ap_pay_flg", ""));
		setApPayDt(JSPUtil.getParameter(request, prefix + "ap_pay_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInvStsCd(JSPUtil.getParameter(request, prefix + "inv_sts_cd", ""));
		setCgoClmDivNm(JSPUtil.getParameter(request, prefix + "cgo_clm_div_nm", ""));
		setClmCostTpNm(JSPUtil.getParameter(request, prefix + "clm_cost_tp_nm", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setCgoClmNo(JSPUtil.getParameter(request, prefix + "cgo_clm_no", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
		setInvRgstNo(JSPUtil.getParameter(request, prefix + "inv_rgst_no", ""));
		setInvEffDt(JSPUtil.getParameter(request, prefix + "inv_eff_dt", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setInvUsdAmt(JSPUtil.getParameter(request, prefix + "inv_usd_amt", ""));
		setApCxlDt(JSPUtil.getParameter(request, prefix + "ap_cxl_dt", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setApPayAmt(JSPUtil.getParameter(request, prefix + "ap_pay_amt", ""));
		setCgoClmPayNo(JSPUtil.getParameter(request, prefix + "cgo_clm_pay_no", ""));
		setHdlrUsrId(JSPUtil.getParameter(request, prefix + "hdlr_usr_id", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setClmPtyNm(JSPUtil.getParameter(request, prefix + "clm_pty_nm", ""));
		setInvRmk(JSPUtil.getParameter(request, prefix + "inv_rmk", ""));
		setClmAreaCd(JSPUtil.getParameter(request, prefix + "clm_area_cd", ""));
		setHdlrOfcCd(JSPUtil.getParameter(request, prefix + "hdlr_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PaymentInvoiceVO[]
	 */
	public PaymentInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PaymentInvoiceVO[]
	 */
	public PaymentInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PaymentInvoiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] cgoClmStsNm = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_sts_nm", length));
			String[] costDesc = (JSPUtil.getParameter(request, prefix	+ "cost_desc", length));
			String[] apPayFlg = (JSPUtil.getParameter(request, prefix	+ "ap_pay_flg", length));
			String[] apPayDt = (JSPUtil.getParameter(request, prefix	+ "ap_pay_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invStsCd = (JSPUtil.getParameter(request, prefix	+ "inv_sts_cd", length));
			String[] cgoClmDivNm = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_div_nm", length));
			String[] clmCostTpNm = (JSPUtil.getParameter(request, prefix	+ "clm_cost_tp_nm", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			String[] invRgstNo = (JSPUtil.getParameter(request, prefix	+ "inv_rgst_no", length));
			String[] invEffDt = (JSPUtil.getParameter(request, prefix	+ "inv_eff_dt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] invUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inv_usd_amt", length));
			String[] apCxlDt = (JSPUtil.getParameter(request, prefix	+ "ap_cxl_dt", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] apPayAmt = (JSPUtil.getParameter(request, prefix	+ "ap_pay_amt", length));
			String[] cgoClmPayNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_pay_no", length));
			String[] hdlrUsrId = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_id", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] clmPtyNm = (JSPUtil.getParameter(request, prefix	+ "clm_pty_nm", length));
			String[] invRmk = (JSPUtil.getParameter(request, prefix	+ "inv_rmk", length));
			String[] clmAreaCd = (JSPUtil.getParameter(request, prefix	+ "clm_area_cd", length));
			String[] hdlrOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdlr_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PaymentInvoiceVO();
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (cgoClmStsNm[i] != null)
					model.setCgoClmStsNm(cgoClmStsNm[i]);
				if (costDesc[i] != null)
					model.setCostDesc(costDesc[i]);
				if (apPayFlg[i] != null)
					model.setApPayFlg(apPayFlg[i]);
				if (apPayDt[i] != null)
					model.setApPayDt(apPayDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invStsCd[i] != null)
					model.setInvStsCd(invStsCd[i]);
				if (cgoClmDivNm[i] != null)
					model.setCgoClmDivNm(cgoClmDivNm[i]);
				if (clmCostTpNm[i] != null)
					model.setClmCostTpNm(clmCostTpNm[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				if (invRgstNo[i] != null)
					model.setInvRgstNo(invRgstNo[i]);
				if (invEffDt[i] != null)
					model.setInvEffDt(invEffDt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (invUsdAmt[i] != null)
					model.setInvUsdAmt(invUsdAmt[i]);
				if (apCxlDt[i] != null)
					model.setApCxlDt(apCxlDt[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (apPayAmt[i] != null)
					model.setApPayAmt(apPayAmt[i]);
				if (cgoClmPayNo[i] != null)
					model.setCgoClmPayNo(cgoClmPayNo[i]);
				if (hdlrUsrId[i] != null)
					model.setHdlrUsrId(hdlrUsrId[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (clmPtyNm[i] != null)
					model.setClmPtyNm(clmPtyNm[i]);
				if (invRmk[i] != null)
					model.setInvRmk(invRmk[i]);
				if (clmAreaCd[i] != null)
					model.setClmAreaCd(clmAreaCd[i]);
				if (hdlrOfcCd[i] != null)
					model.setHdlrOfcCd(hdlrOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPaymentInvoiceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PaymentInvoiceVO[]
	 */
	public PaymentInvoiceVO[] getPaymentInvoiceVOs(){
		PaymentInvoiceVO[] vos = (PaymentInvoiceVO[])models.toArray(new PaymentInvoiceVO[models.size()]);
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
		this.cgoClmStsNm = this.cgoClmStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDesc = this.costDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apPayFlg = this.apPayFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apPayDt = this.apPayDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invStsCd = this.invStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmDivNm = this.cgoClmDivNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmCostTpNm = this.clmCostTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRgstNo = this.invRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEffDt = this.invEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdAmt = this.invUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCxlDt = this.apCxlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apPayAmt = this.apPayAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmPayNo = this.cgoClmPayNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrId = this.hdlrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyNm = this.clmPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk = this.invRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAreaCd = this.clmAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrOfcCd = this.hdlrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
