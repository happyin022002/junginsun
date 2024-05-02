/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchInvoiceAuditVO.java
*@FileTitle : SearchInvoiceAuditVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.08.27 손은주(TRS) 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 손은주(TRS)
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchInvoiceAuditVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchInvoiceAuditVO> models = new ArrayList<SearchInvoiceAuditVO>();
	
	/* Column Info */
	private String eqNoText = null;
	/* Column Info */
	private String totAmt = null;
	/* Column Info */
	private String applyCurrency = null;
	/* Column Info */
	private String trspInvActStsCdParam = null;
	/* Column Info */
	private String invVndrSeqParam = null;
	/* Column Info */
	private String invoiceNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String formUsrOfcCd = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String whtAmt = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String provUsrId = null;
	/* Column Info */
	private String formCreUsrId = null;
	/* Column Info */
	private String issueDt = null;
	/* Column Info */
	private String paymtSpCd = null;
	/* Column Info */
	private String trspInvAudStsCd = null;
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String modeParam = null;
	/* Column Info */
	private String bookingNo = null;
	/* Column Info */
	private String comboSvcProvider = null;
	/* Column Info */
	private String ifSysKndCdParam = null;
	/* Column Info */
	private String recieveDt = null;
	/* Column Info */
	private String vatAmt = null;
	/* Column Info */
	private String trspSoVndrNo = null;
	/* Column Info */
	private String invNoParam = null;
	/* Column Info */
	private String trspInvAudStsCdParam = null;
	/* Column Info */
	private String provPhnId = null;
	/* Column Info */
	private String ifSysKndCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchInvoiceAuditVO() {}

	public SearchInvoiceAuditVO(String ibflag, String pagerows, String ifSysKndCdParam, String ifSysKndCd, String trspInvActStsCdParam, String trspInvAudStsCdParam, String trspInvAudStsCd, String comboSvcProvider, String applyCurrency, String invAmt, String vatAmt, String whtAmt, String totAmt, String recieveDt, String issueDt, String trspSoVndrNo, String formCreUsrId, String provUsrId, String provPhnId, String formUsrOfcCd, String invoiceNo, String modeParam, String invNoParam, String invVndrSeqParam, String paymtSpCd, String woNo, String bookingNo, String blNo, String eqNoText, String soNo) {
		this.eqNoText = eqNoText;
		this.totAmt = totAmt;
		this.applyCurrency = applyCurrency;
		this.trspInvActStsCdParam = trspInvActStsCdParam;
		this.invVndrSeqParam = invVndrSeqParam;
		this.invoiceNo = invoiceNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.formUsrOfcCd = formUsrOfcCd;
		this.woNo = woNo;
		this.whtAmt = whtAmt;
		this.invAmt = invAmt;
		this.provUsrId = provUsrId;
		this.formCreUsrId = formCreUsrId;
		this.issueDt = issueDt;
		this.paymtSpCd = paymtSpCd;
		this.trspInvAudStsCd = trspInvAudStsCd;
		this.soNo = soNo;
		this.modeParam = modeParam;
		this.bookingNo = bookingNo;
		this.comboSvcProvider = comboSvcProvider;
		this.ifSysKndCdParam = ifSysKndCdParam;
		this.recieveDt = recieveDt;
		this.vatAmt = vatAmt;
		this.trspSoVndrNo = trspSoVndrNo;
		this.invNoParam = invNoParam;
		this.trspInvAudStsCdParam = trspInvAudStsCdParam;
		this.provPhnId = provPhnId;
		this.ifSysKndCd = ifSysKndCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eq_no_text", getEqNoText());
		this.hashColumns.put("tot_amt", getTotAmt());
		this.hashColumns.put("apply_currency", getApplyCurrency());
		this.hashColumns.put("trsp_inv_act_sts_cd_param", getTrspInvActStsCdParam());
		this.hashColumns.put("inv_vndr_seq_param", getInvVndrSeqParam());
		this.hashColumns.put("invoice_no", getInvoiceNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("FORM_USR_OFC_CD", getFormUsrOfcCd());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("wht_amt", getWhtAmt());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("prov_usr_id", getProvUsrId());
		this.hashColumns.put("FORM_CRE_USR_ID", getFormCreUsrId());
		this.hashColumns.put("issue_dt", getIssueDt());
		this.hashColumns.put("paymt_sp_cd", getPaymtSpCd());
		this.hashColumns.put("trsp_inv_aud_sts_cd", getTrspInvAudStsCd());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("mode_param", getModeParam());
		this.hashColumns.put("booking_no", getBookingNo());
		this.hashColumns.put("combo_svc_provider", getComboSvcProvider());
		this.hashColumns.put("if_sys_knd_cd_param", getIfSysKndCdParam());
		this.hashColumns.put("recieve_dt", getRecieveDt());
		this.hashColumns.put("vat_amt", getVatAmt());
		this.hashColumns.put("TRSP_SO_VNDR_NO", getTrspSoVndrNo());
		this.hashColumns.put("inv_no_param", getInvNoParam());
		this.hashColumns.put("trsp_inv_aud_sts_cd_param", getTrspInvAudStsCdParam());
		this.hashColumns.put("prov_phn_id", getProvPhnId());
		this.hashColumns.put("if_sys_knd_cd", getIfSysKndCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eq_no_text", "eqNoText");
		this.hashFields.put("tot_amt", "totAmt");
		this.hashFields.put("apply_currency", "applyCurrency");
		this.hashFields.put("trsp_inv_act_sts_cd_param", "trspInvActStsCdParam");
		this.hashFields.put("inv_vndr_seq_param", "invVndrSeqParam");
		this.hashFields.put("invoice_no", "invoiceNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("FORM_USR_OFC_CD", "formUsrOfcCd");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("wht_amt", "whtAmt");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("prov_usr_id", "provUsrId");
		this.hashFields.put("FORM_CRE_USR_ID", "formCreUsrId");
		this.hashFields.put("issue_dt", "issueDt");
		this.hashFields.put("paymt_sp_cd", "paymtSpCd");
		this.hashFields.put("trsp_inv_aud_sts_cd", "trspInvAudStsCd");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("mode_param", "modeParam");
		this.hashFields.put("booking_no", "bookingNo");
		this.hashFields.put("combo_svc_provider", "comboSvcProvider");
		this.hashFields.put("if_sys_knd_cd_param", "ifSysKndCdParam");
		this.hashFields.put("recieve_dt", "recieveDt");
		this.hashFields.put("vat_amt", "vatAmt");
		this.hashFields.put("TRSP_SO_VNDR_NO", "trspSoVndrNo");
		this.hashFields.put("inv_no_param", "invNoParam");
		this.hashFields.put("trsp_inv_aud_sts_cd_param", "trspInvAudStsCdParam");
		this.hashFields.put("prov_phn_id", "provPhnId");
		this.hashFields.put("if_sys_knd_cd", "ifSysKndCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eqNoText
	 */
	public String getEqNoText() {
		return this.eqNoText;
	}
	
	/**
	 * Column Info
	 * @return totAmt
	 */
	public String getTotAmt() {
		return this.totAmt;
	}
	
	/**
	 * Column Info
	 * @return applyCurrency
	 */
	public String getApplyCurrency() {
		return this.applyCurrency;
	}
	
	/**
	 * Column Info
	 * @return trspInvActStsCdParam
	 */
	public String getTrspInvActStsCdParam() {
		return this.trspInvActStsCdParam;
	}
	
	/**
	 * Column Info
	 * @return invVndrSeqParam
	 */
	public String getInvVndrSeqParam() {
		return this.invVndrSeqParam;
	}
	
	/**
	 * Column Info
	 * @return invoiceNo
	 */
	public String getInvoiceNo() {
		return this.invoiceNo;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return formUsrOfcCd
	 */
	public String getFormUsrOfcCd() {
		return this.formUsrOfcCd;
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
	 * @return whtAmt
	 */
	public String getWhtAmt() {
		return this.whtAmt;
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
	 * @return provUsrId
	 */
	public String getProvUsrId() {
		return this.provUsrId;
	}
	
	/**
	 * Column Info
	 * @return formCreUsrId
	 */
	public String getFormCreUsrId() {
		return this.formCreUsrId;
	}
	
	/**
	 * Column Info
	 * @return issueDt
	 */
	public String getIssueDt() {
		return this.issueDt;
	}
	
	/**
	 * Column Info
	 * @return paymtSpCd
	 */
	public String getPaymtSpCd() {
		return this.paymtSpCd;
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
	 * @return soNo
	 */
	public String getSoNo() {
		return this.soNo;
	}
	
	/**
	 * Column Info
	 * @return modeParam
	 */
	public String getModeParam() {
		return this.modeParam;
	}
	
	/**
	 * Column Info
	 * @return bookingNo
	 */
	public String getBookingNo() {
		return this.bookingNo;
	}
	
	/**
	 * Column Info
	 * @return comboSvcProvider
	 */
	public String getComboSvcProvider() {
		return this.comboSvcProvider;
	}
	
	/**
	 * Column Info
	 * @return ifSysKndCdParam
	 */
	public String getIfSysKndCdParam() {
		return this.ifSysKndCdParam;
	}
	
	/**
	 * Column Info
	 * @return recieveDt
	 */
	public String getRecieveDt() {
		return this.recieveDt;
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
	 * @return trspSoVndrNo
	 */
	public String getTrspSoVndrNo() {
		return this.trspSoVndrNo;
	}
	
	/**
	 * Column Info
	 * @return invNoParam
	 */
	public String getInvNoParam() {
		return this.invNoParam;
	}
	
	/**
	 * Column Info
	 * @return trspInvAudStsCdParam
	 */
	public String getTrspInvAudStsCdParam() {
		return this.trspInvAudStsCdParam;
	}
	
	/**
	 * Column Info
	 * @return provPhnId
	 */
	public String getProvPhnId() {
		return this.provPhnId;
	}
	
	/**
	 * Column Info
	 * @return ifSysKndCd
	 */
	public String getIfSysKndCd() {
		return this.ifSysKndCd;
	}
	

	/**
	 * Column Info
	 * @param eqNoText
	 */
	public void setEqNoText(String eqNoText) {
		this.eqNoText = eqNoText;
	}
	
	/**
	 * Column Info
	 * @param totAmt
	 */
	public void setTotAmt(String totAmt) {
		this.totAmt = totAmt;
	}
	
	/**
	 * Column Info
	 * @param applyCurrency
	 */
	public void setApplyCurrency(String applyCurrency) {
		this.applyCurrency = applyCurrency;
	}
	
	/**
	 * Column Info
	 * @param trspInvActStsCdParam
	 */
	public void setTrspInvActStsCdParam(String trspInvActStsCdParam) {
		this.trspInvActStsCdParam = trspInvActStsCdParam;
	}
	
	/**
	 * Column Info
	 * @param invVndrSeqParam
	 */
	public void setInvVndrSeqParam(String invVndrSeqParam) {
		this.invVndrSeqParam = invVndrSeqParam;
	}
	
	/**
	 * Column Info
	 * @param invoiceNo
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param formUsrOfcCd
	 */
	public void setFormUsrOfcCd(String formUsrOfcCd) {
		this.formUsrOfcCd = formUsrOfcCd;
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
	 * @param whtAmt
	 */
	public void setWhtAmt(String whtAmt) {
		this.whtAmt = whtAmt;
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
	 * @param provUsrId
	 */
	public void setProvUsrId(String provUsrId) {
		this.provUsrId = provUsrId;
	}
	
	/**
	 * Column Info
	 * @param formCreUsrId
	 */
	public void setFormCreUsrId(String formCreUsrId) {
		this.formCreUsrId = formCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param issueDt
	 */
	public void setIssueDt(String issueDt) {
		this.issueDt = issueDt;
	}
	
	/**
	 * Column Info
	 * @param paymtSpCd
	 */
	public void setPaymtSpCd(String paymtSpCd) {
		this.paymtSpCd = paymtSpCd;
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
	 * @param soNo
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}
	
	/**
	 * Column Info
	 * @param modeParam
	 */
	public void setModeParam(String modeParam) {
		this.modeParam = modeParam;
	}
	
	/**
	 * Column Info
	 * @param bookingNo
	 */
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}
	
	/**
	 * Column Info
	 * @param comboSvcProvider
	 */
	public void setComboSvcProvider(String comboSvcProvider) {
		this.comboSvcProvider = comboSvcProvider;
	}
	
	/**
	 * Column Info
	 * @param ifSysKndCdParam
	 */
	public void setIfSysKndCdParam(String ifSysKndCdParam) {
		this.ifSysKndCdParam = ifSysKndCdParam;
	}
	
	/**
	 * Column Info
	 * @param recieveDt
	 */
	public void setRecieveDt(String recieveDt) {
		this.recieveDt = recieveDt;
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
	 * @param trspSoVndrNo
	 */
	public void setTrspSoVndrNo(String trspSoVndrNo) {
		this.trspSoVndrNo = trspSoVndrNo;
	}
	
	/**
	 * Column Info
	 * @param invNoParam
	 */
	public void setInvNoParam(String invNoParam) {
		this.invNoParam = invNoParam;
	}
	
	/**
	 * Column Info
	 * @param trspInvAudStsCdParam
	 */
	public void setTrspInvAudStsCdParam(String trspInvAudStsCdParam) {
		this.trspInvAudStsCdParam = trspInvAudStsCdParam;
	}
	
	/**
	 * Column Info
	 * @param provPhnId
	 */
	public void setProvPhnId(String provPhnId) {
		this.provPhnId = provPhnId;
	}
	
	/**
	 * Column Info
	 * @param ifSysKndCd
	 */
	public void setIfSysKndCd(String ifSysKndCd) {
		this.ifSysKndCd = ifSysKndCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEqNoText(JSPUtil.getParameter(request, "eq_no_text", ""));
		setTotAmt(JSPUtil.getParameter(request, "tot_amt", ""));
		setApplyCurrency(JSPUtil.getParameter(request, "apply_currency", ""));
		setTrspInvActStsCdParam(JSPUtil.getParameter(request, "trsp_inv_act_sts_cd_param", ""));
		setInvVndrSeqParam(JSPUtil.getParameter(request, "inv_vndr_seq_param", ""));
		setInvoiceNo(JSPUtil.getParameter(request, "invoice_no", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFormUsrOfcCd(JSPUtil.getParameter(request, "FORM_USR_OFC_CD", ""));
		setWoNo(JSPUtil.getParameter(request, "wo_no", ""));
		setWhtAmt(JSPUtil.getParameter(request, "wht_amt", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setProvUsrId(JSPUtil.getParameter(request, "prov_usr_id", ""));
		setFormCreUsrId(JSPUtil.getParameter(request, "FORM_CRE_USR_ID", ""));
		setIssueDt(JSPUtil.getParameter(request, "issue_dt", ""));
		setPaymtSpCd(JSPUtil.getParameter(request, "paymt_sp_cd", ""));
		setTrspInvAudStsCd(JSPUtil.getParameter(request, "trsp_inv_aud_sts_cd", ""));
		setSoNo(JSPUtil.getParameter(request, "so_no", ""));
		setModeParam(JSPUtil.getParameter(request, "mode_param", ""));
		setBookingNo(JSPUtil.getParameter(request, "booking_no", ""));
		setComboSvcProvider(JSPUtil.getParameter(request, "combo_svc_provider", ""));
		setIfSysKndCdParam(JSPUtil.getParameter(request, "if_sys_knd_cd_param", ""));
		setRecieveDt(JSPUtil.getParameter(request, "recieve_dt", ""));
		setVatAmt(JSPUtil.getParameter(request, "vat_amt", ""));
		setTrspSoVndrNo(JSPUtil.getParameter(request, "TRSP_SO_VNDR_NO", ""));
		setInvNoParam(JSPUtil.getParameter(request, "inv_no_param", ""));
		setTrspInvAudStsCdParam(JSPUtil.getParameter(request, "trsp_inv_aud_sts_cd_param", ""));
		setProvPhnId(JSPUtil.getParameter(request, "prov_phn_id", ""));
		setIfSysKndCd(JSPUtil.getParameter(request, "if_sys_knd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchInvoiceAuditVO[]
	 */
	public SearchInvoiceAuditVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchInvoiceAuditVO[]
	 */
	public SearchInvoiceAuditVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchInvoiceAuditVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eqNoText = (JSPUtil.getParameter(request, prefix	+ "eq_no_text", length));
			String[] totAmt = (JSPUtil.getParameter(request, prefix	+ "tot_amt", length));
			String[] applyCurrency = (JSPUtil.getParameter(request, prefix	+ "apply_currency", length));
			String[] trspInvActStsCdParam = (JSPUtil.getParameter(request, prefix	+ "trsp_inv_act_sts_cd_param", length));
			String[] invVndrSeqParam = (JSPUtil.getParameter(request, prefix	+ "inv_vndr_seq_param", length));
			String[] invoiceNo = (JSPUtil.getParameter(request, prefix	+ "invoice_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] formUsrOfcCd = (JSPUtil.getParameter(request, prefix	+ "FORM_USR_OFC_CD", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] whtAmt = (JSPUtil.getParameter(request, prefix	+ "wht_amt", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] provUsrId = (JSPUtil.getParameter(request, prefix	+ "prov_usr_id", length));
			String[] formCreUsrId = (JSPUtil.getParameter(request, prefix	+ "FORM_CRE_USR_ID", length));
			String[] issueDt = (JSPUtil.getParameter(request, prefix	+ "issue_dt", length));
			String[] paymtSpCd = (JSPUtil.getParameter(request, prefix	+ "paymt_sp_cd", length));
			String[] trspInvAudStsCd = (JSPUtil.getParameter(request, prefix	+ "trsp_inv_aud_sts_cd", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] modeParam = (JSPUtil.getParameter(request, prefix	+ "mode_param", length));
			String[] bookingNo = (JSPUtil.getParameter(request, prefix	+ "booking_no", length));
			String[] comboSvcProvider = (JSPUtil.getParameter(request, prefix	+ "combo_svc_provider", length));
			String[] ifSysKndCdParam = (JSPUtil.getParameter(request, prefix	+ "if_sys_knd_cd_param", length));
			String[] recieveDt = (JSPUtil.getParameter(request, prefix	+ "recieve_dt", length));
			String[] vatAmt = (JSPUtil.getParameter(request, prefix	+ "vat_amt", length));
			String[] trspSoVndrNo = (JSPUtil.getParameter(request, prefix	+ "TRSP_SO_VNDR_NO", length));
			String[] invNoParam = (JSPUtil.getParameter(request, prefix	+ "inv_no_param", length));
			String[] trspInvAudStsCdParam = (JSPUtil.getParameter(request, prefix	+ "trsp_inv_aud_sts_cd_param", length));
			String[] provPhnId = (JSPUtil.getParameter(request, prefix	+ "prov_phn_id", length));
			String[] ifSysKndCd = (JSPUtil.getParameter(request, prefix	+ "if_sys_knd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchInvoiceAuditVO();
				if (eqNoText[i] != null)
					model.setEqNoText(eqNoText[i]);
				if (totAmt[i] != null)
					model.setTotAmt(totAmt[i]);
				if (applyCurrency[i] != null)
					model.setApplyCurrency(applyCurrency[i]);
				if (trspInvActStsCdParam[i] != null)
					model.setTrspInvActStsCdParam(trspInvActStsCdParam[i]);
				if (invVndrSeqParam[i] != null)
					model.setInvVndrSeqParam(invVndrSeqParam[i]);
				if (invoiceNo[i] != null)
					model.setInvoiceNo(invoiceNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (formUsrOfcCd[i] != null)
					model.setFormUsrOfcCd(formUsrOfcCd[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (whtAmt[i] != null)
					model.setWhtAmt(whtAmt[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (provUsrId[i] != null)
					model.setProvUsrId(provUsrId[i]);
				if (formCreUsrId[i] != null)
					model.setFormCreUsrId(formCreUsrId[i]);
				if (issueDt[i] != null)
					model.setIssueDt(issueDt[i]);
				if (paymtSpCd[i] != null)
					model.setPaymtSpCd(paymtSpCd[i]);
				if (trspInvAudStsCd[i] != null)
					model.setTrspInvAudStsCd(trspInvAudStsCd[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (modeParam[i] != null)
					model.setModeParam(modeParam[i]);
				if (bookingNo[i] != null)
					model.setBookingNo(bookingNo[i]);
				if (comboSvcProvider[i] != null)
					model.setComboSvcProvider(comboSvcProvider[i]);
				if (ifSysKndCdParam[i] != null)
					model.setIfSysKndCdParam(ifSysKndCdParam[i]);
				if (recieveDt[i] != null)
					model.setRecieveDt(recieveDt[i]);
				if (vatAmt[i] != null)
					model.setVatAmt(vatAmt[i]);
				if (trspSoVndrNo[i] != null)
					model.setTrspSoVndrNo(trspSoVndrNo[i]);
				if (invNoParam[i] != null)
					model.setInvNoParam(invNoParam[i]);
				if (trspInvAudStsCdParam[i] != null)
					model.setTrspInvAudStsCdParam(trspInvAudStsCdParam[i]);
				if (provPhnId[i] != null)
					model.setProvPhnId(provPhnId[i]);
				if (ifSysKndCd[i] != null)
					model.setIfSysKndCd(ifSysKndCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchInvoiceAuditVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchInvoiceAuditVO[]
	 */
	public SearchInvoiceAuditVO[] getSearchInvoiceAuditVOs(){
		SearchInvoiceAuditVO[] vos = (SearchInvoiceAuditVO[])models.toArray(new SearchInvoiceAuditVO[models.size()]);
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
		this.eqNoText = this.eqNoText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAmt = this.totAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.applyCurrency = this.applyCurrency .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspInvActStsCdParam = this.trspInvActStsCdParam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVndrSeqParam = this.invVndrSeqParam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceNo = this.invoiceNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formUsrOfcCd = this.formUsrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whtAmt = this.whtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.provUsrId = this.provUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formCreUsrId = this.formCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueDt = this.issueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paymtSpCd = this.paymtSpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspInvAudStsCd = this.trspInvAudStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modeParam = this.modeParam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookingNo = this.bookingNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comboSvcProvider = this.comboSvcProvider .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSysKndCdParam = this.ifSysKndCdParam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recieveDt = this.recieveDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatAmt = this.vatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoVndrNo = this.trspSoVndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNoParam = this.invNoParam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspInvAudStsCdParam = this.trspInvAudStsCdParam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.provPhnId = this.provPhnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSysKndCd = this.ifSysKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
