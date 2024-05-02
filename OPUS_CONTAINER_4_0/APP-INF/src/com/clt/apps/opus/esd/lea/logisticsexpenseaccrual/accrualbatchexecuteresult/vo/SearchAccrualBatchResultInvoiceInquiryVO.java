/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchAccrualBatchResultInvoiceInquiryVO.java
*@FileTitle : SearchAccrualBatchResultInvoiceInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.11.20 전재홍 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo;

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
 * @author 전재홍
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAccrualBatchResultInvoiceInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAccrualBatchResultInvoiceInquiryVO> models = new ArrayList<SearchAccrualBatchResultInvoiceInquiryVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String coaCostSrcCd = null;
	/* Column Info */
	private String usdCostAmt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String fRhqCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fCostTypeV = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String fVndr = null;
	/* Column Info */
	private String fCostTypeM = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String fCostTypeF = null;
	/* Column Info */
	private String exeYrmon = null;
	/* Column Info */
	private String n2ndNodCd = null;
	/* Column Info */
	private String subOfcCd = null;
	/* Column Info */
	private String mnCostTpNm = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String subCostTpNm = null;
	/* Column Info */
	private String fCtrlOfcCd = null;
	/* Column Info */
	private String n4thNodCd = null;
	/* Column Info */
	private String n1stNodCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String loclCostAmt = null;
	/* Column Info */
	private String fReport = null;
	/* Column Info */
	private String n3rdNodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchAccrualBatchResultInvoiceInquiryVO() {}

	public SearchAccrualBatchResultInvoiceInquiryVO(String ibflag, String pagerows, String exeYrmon, String revYrmon, String rhqCd, String mnCostTpNm, String subCostTpNm, String coaCostSrcCd, String acctCd, String n1stNodCd, String n2ndNodCd, String n3rdNodCd, String n4thNodCd, String currCd, String loclCostAmt, String usdCostAmt, String fVndr, String fReport, String fRhqCd, String fCtrlOfcCd, String fCostTypeF, String fCostTypeM, String fCostTypeV, String vndrSeq, String ctrlOfcCd, String vndrLglEngNm, String subOfcCd) {
		this.currCd = currCd;
		this.coaCostSrcCd = coaCostSrcCd;
		this.usdCostAmt = usdCostAmt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.fRhqCd = fRhqCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.fCostTypeV = fCostTypeV;
		this.acctCd = acctCd;
		this.fVndr = fVndr;
		this.fCostTypeM = fCostTypeM;
		this.rhqCd = rhqCd;
		this.revYrmon = revYrmon;
		this.fCostTypeF = fCostTypeF;
		this.exeYrmon = exeYrmon;
		this.n2ndNodCd = n2ndNodCd;
		this.subOfcCd = subOfcCd;
		this.mnCostTpNm = mnCostTpNm;
		this.ctrlOfcCd = ctrlOfcCd;
		this.subCostTpNm = subCostTpNm;
		this.fCtrlOfcCd = fCtrlOfcCd;
		this.n4thNodCd = n4thNodCd;
		this.n1stNodCd = n1stNodCd;
		this.vndrSeq = vndrSeq;
		this.loclCostAmt = loclCostAmt;
		this.fReport = fReport;
		this.n3rdNodCd = n3rdNodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("coa_cost_src_cd", getCoaCostSrcCd());
		this.hashColumns.put("usd_cost_amt", getUsdCostAmt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("f_rhq_cd", getFRhqCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_cost_type_v", getFCostTypeV());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("f_vndr", getFVndr());
		this.hashColumns.put("f_cost_type_m", getFCostTypeM());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("f_cost_type_f", getFCostTypeF());
		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("n2nd_nod_cd", getN2ndNodCd());
		this.hashColumns.put("sub_ofc_cd", getSubOfcCd());
		this.hashColumns.put("mn_cost_tp_nm", getMnCostTpNm());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("sub_cost_tp_nm", getSubCostTpNm());
		this.hashColumns.put("f_ctrl_ofc_cd", getFCtrlOfcCd());
		this.hashColumns.put("n4th_nod_cd", getN4thNodCd());
		this.hashColumns.put("n1st_nod_cd", getN1stNodCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("locl_cost_amt", getLoclCostAmt());
		this.hashColumns.put("f_report", getFReport());
		this.hashColumns.put("n3rd_nod_cd", getN3rdNodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("coa_cost_src_cd", "coaCostSrcCd");
		this.hashFields.put("usd_cost_amt", "usdCostAmt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("f_rhq_cd", "fRhqCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_cost_type_v", "fCostTypeV");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("f_vndr", "fVndr");
		this.hashFields.put("f_cost_type_m", "fCostTypeM");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("f_cost_type_f", "fCostTypeF");
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("n2nd_nod_cd", "n2ndNodCd");
		this.hashFields.put("sub_ofc_cd", "subOfcCd");
		this.hashFields.put("mn_cost_tp_nm", "mnCostTpNm");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("sub_cost_tp_nm", "subCostTpNm");
		this.hashFields.put("f_ctrl_ofc_cd", "fCtrlOfcCd");
		this.hashFields.put("n4th_nod_cd", "n4thNodCd");
		this.hashFields.put("n1st_nod_cd", "n1stNodCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("locl_cost_amt", "loclCostAmt");
		this.hashFields.put("f_report", "fReport");
		this.hashFields.put("n3rd_nod_cd", "n3rdNodCd");
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
	 * @return coaCostSrcCd
	 */
	public String getCoaCostSrcCd() {
		return this.coaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @return usdCostAmt
	 */
	public String getUsdCostAmt() {
		return this.usdCostAmt;
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
	 * @return fRhqCd
	 */
	public String getFRhqCd() {
		return this.fRhqCd;
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
	 * @return fCostTypeV
	 */
	public String getFCostTypeV() {
		return this.fCostTypeV;
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
	 * @return fVndr
	 */
	public String getFVndr() {
		return this.fVndr;
	}
	
	/**
	 * Column Info
	 * @return fCostTypeM
	 */
	public String getFCostTypeM() {
		return this.fCostTypeM;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return fCostTypeF
	 */
	public String getFCostTypeF() {
		return this.fCostTypeF;
	}
	
	/**
	 * Column Info
	 * @return exeYrmon
	 */
	public String getExeYrmon() {
		return this.exeYrmon;
	}
	
	/**
	 * Column Info
	 * @return n2ndNodCd
	 */
	public String getN2ndNodCd() {
		return this.n2ndNodCd;
	}
	
	/**
	 * Column Info
	 * @return subOfcCd
	 */
	public String getSubOfcCd() {
		return this.subOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mnCostTpNm
	 */
	public String getMnCostTpNm() {
		return this.mnCostTpNm;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return subCostTpNm
	 */
	public String getSubCostTpNm() {
		return this.subCostTpNm;
	}
	
	/**
	 * Column Info
	 * @return fCtrlOfcCd
	 */
	public String getFCtrlOfcCd() {
		return this.fCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n4thNodCd
	 */
	public String getN4thNodCd() {
		return this.n4thNodCd;
	}
	
	/**
	 * Column Info
	 * @return n1stNodCd
	 */
	public String getN1stNodCd() {
		return this.n1stNodCd;
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
	 * @return loclCostAmt
	 */
	public String getLoclCostAmt() {
		return this.loclCostAmt;
	}
	
	/**
	 * Column Info
	 * @return fReport
	 */
	public String getFReport() {
		return this.fReport;
	}
	
	/**
	 * Column Info
	 * @return n3rdNodCd
	 */
	public String getN3rdNodCd() {
		return this.n3rdNodCd;
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
	 * @param coaCostSrcCd
	 */
	public void setCoaCostSrcCd(String coaCostSrcCd) {
		this.coaCostSrcCd = coaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @param usdCostAmt
	 */
	public void setUsdCostAmt(String usdCostAmt) {
		this.usdCostAmt = usdCostAmt;
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
	 * @param fRhqCd
	 */
	public void setFRhqCd(String fRhqCd) {
		this.fRhqCd = fRhqCd;
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
	 * @param fCostTypeV
	 */
	public void setFCostTypeV(String fCostTypeV) {
		this.fCostTypeV = fCostTypeV;
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
	 * @param fVndr
	 */
	public void setFVndr(String fVndr) {
		this.fVndr = fVndr;
	}
	
	/**
	 * Column Info
	 * @param fCostTypeM
	 */
	public void setFCostTypeM(String fCostTypeM) {
		this.fCostTypeM = fCostTypeM;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param fCostTypeF
	 */
	public void setFCostTypeF(String fCostTypeF) {
		this.fCostTypeF = fCostTypeF;
	}
	
	/**
	 * Column Info
	 * @param exeYrmon
	 */
	public void setExeYrmon(String exeYrmon) {
		this.exeYrmon = exeYrmon;
	}
	
	/**
	 * Column Info
	 * @param n2ndNodCd
	 */
	public void setN2ndNodCd(String n2ndNodCd) {
		this.n2ndNodCd = n2ndNodCd;
	}
	
	/**
	 * Column Info
	 * @param subOfcCd
	 */
	public void setSubOfcCd(String subOfcCd) {
		this.subOfcCd = subOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mnCostTpNm
	 */
	public void setMnCostTpNm(String mnCostTpNm) {
		this.mnCostTpNm = mnCostTpNm;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param subCostTpNm
	 */
	public void setSubCostTpNm(String subCostTpNm) {
		this.subCostTpNm = subCostTpNm;
	}
	
	/**
	 * Column Info
	 * @param fCtrlOfcCd
	 */
	public void setFCtrlOfcCd(String fCtrlOfcCd) {
		this.fCtrlOfcCd = fCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n4thNodCd
	 */
	public void setN4thNodCd(String n4thNodCd) {
		this.n4thNodCd = n4thNodCd;
	}
	
	/**
	 * Column Info
	 * @param n1stNodCd
	 */
	public void setN1stNodCd(String n1stNodCd) {
		this.n1stNodCd = n1stNodCd;
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
	 * @param loclCostAmt
	 */
	public void setLoclCostAmt(String loclCostAmt) {
		this.loclCostAmt = loclCostAmt;
	}
	
	/**
	 * Column Info
	 * @param fReport
	 */
	public void setFReport(String fReport) {
		this.fReport = fReport;
	}
	
	/**
	 * Column Info
	 * @param n3rdNodCd
	 */
	public void setN3rdNodCd(String n3rdNodCd) {
		this.n3rdNodCd = n3rdNodCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setCoaCostSrcCd(JSPUtil.getParameter(request, "coa_cost_src_cd", ""));
		setUsdCostAmt(JSPUtil.getParameter(request, "usd_cost_amt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setFRhqCd(JSPUtil.getParameter(request, "f_rhq_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFCostTypeV(JSPUtil.getParameter(request, "f_cost_type_v", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setFVndr(JSPUtil.getParameter(request, "f_vndr", ""));
		setFCostTypeM(JSPUtil.getParameter(request, "f_cost_type_m", ""));
		setRhqCd(JSPUtil.getParameter(request, "rhq_cd", ""));
		setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));
		setFCostTypeF(JSPUtil.getParameter(request, "f_cost_type_f", ""));
		setExeYrmon(JSPUtil.getParameter(request, "exe_yrmon", ""));
		setN2ndNodCd(JSPUtil.getParameter(request, "n2nd_nod_cd", ""));
		setSubOfcCd(JSPUtil.getParameter(request, "sub_ofc_cd", ""));
		setMnCostTpNm(JSPUtil.getParameter(request, "mn_cost_tp_nm", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, "ctrl_ofc_cd", ""));
		setSubCostTpNm(JSPUtil.getParameter(request, "sub_cost_tp_nm", ""));
		setFCtrlOfcCd(JSPUtil.getParameter(request, "f_ctrl_ofc_cd", ""));
		setN4thNodCd(JSPUtil.getParameter(request, "n4th_nod_cd", ""));
		setN1stNodCd(JSPUtil.getParameter(request, "n1st_nod_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setLoclCostAmt(JSPUtil.getParameter(request, "locl_cost_amt", ""));
		setFReport(JSPUtil.getParameter(request, "f_report", ""));
		setN3rdNodCd(JSPUtil.getParameter(request, "n3rd_nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAccrualBatchResultInvoiceInquiryVO[]
	 */
	public SearchAccrualBatchResultInvoiceInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAccrualBatchResultInvoiceInquiryVO[]
	 */
	public SearchAccrualBatchResultInvoiceInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAccrualBatchResultInvoiceInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] coaCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "coa_cost_src_cd", length));
			String[] usdCostAmt = (JSPUtil.getParameter(request, prefix	+ "usd_cost_amt", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] fRhqCd = (JSPUtil.getParameter(request, prefix	+ "f_rhq_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fCostTypeV = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_v", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] fVndr = (JSPUtil.getParameter(request, prefix	+ "f_vndr", length));
			String[] fCostTypeM = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_m", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] fCostTypeF = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_f", length));
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
			String[] n2ndNodCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_nod_cd", length));
			String[] subOfcCd = (JSPUtil.getParameter(request, prefix	+ "sub_ofc_cd", length));
			String[] mnCostTpNm = (JSPUtil.getParameter(request, prefix	+ "mn_cost_tp_nm", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] subCostTpNm = (JSPUtil.getParameter(request, prefix	+ "sub_cost_tp_nm", length));
			String[] fCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_ctrl_ofc_cd", length));
			String[] n4thNodCd = (JSPUtil.getParameter(request, prefix	+ "n4th_nod_cd", length));
			String[] n1stNodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_nod_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] loclCostAmt = (JSPUtil.getParameter(request, prefix	+ "locl_cost_amt", length));
			String[] fReport = (JSPUtil.getParameter(request, prefix	+ "f_report", length));
			String[] n3rdNodCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_nod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAccrualBatchResultInvoiceInquiryVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (coaCostSrcCd[i] != null)
					model.setCoaCostSrcCd(coaCostSrcCd[i]);
				if (usdCostAmt[i] != null)
					model.setUsdCostAmt(usdCostAmt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (fRhqCd[i] != null)
					model.setFRhqCd(fRhqCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fCostTypeV[i] != null)
					model.setFCostTypeV(fCostTypeV[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (fVndr[i] != null)
					model.setFVndr(fVndr[i]);
				if (fCostTypeM[i] != null)
					model.setFCostTypeM(fCostTypeM[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (fCostTypeF[i] != null)
					model.setFCostTypeF(fCostTypeF[i]);
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
				if (n2ndNodCd[i] != null)
					model.setN2ndNodCd(n2ndNodCd[i]);
				if (subOfcCd[i] != null)
					model.setSubOfcCd(subOfcCd[i]);
				if (mnCostTpNm[i] != null)
					model.setMnCostTpNm(mnCostTpNm[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (subCostTpNm[i] != null)
					model.setSubCostTpNm(subCostTpNm[i]);
				if (fCtrlOfcCd[i] != null)
					model.setFCtrlOfcCd(fCtrlOfcCd[i]);
				if (n4thNodCd[i] != null)
					model.setN4thNodCd(n4thNodCd[i]);
				if (n1stNodCd[i] != null)
					model.setN1stNodCd(n1stNodCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (loclCostAmt[i] != null)
					model.setLoclCostAmt(loclCostAmt[i]);
				if (fReport[i] != null)
					model.setFReport(fReport[i]);
				if (n3rdNodCd[i] != null)
					model.setN3rdNodCd(n3rdNodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAccrualBatchResultInvoiceInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAccrualBatchResultInvoiceInquiryVO[]
	 */
	public SearchAccrualBatchResultInvoiceInquiryVO[] getSearchAccrualBatchResultInvoiceInquiryVOs(){
		SearchAccrualBatchResultInvoiceInquiryVO[] vos = (SearchAccrualBatchResultInvoiceInquiryVO[])models.toArray(new SearchAccrualBatchResultInvoiceInquiryVO[models.size()]);
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
		this.coaCostSrcCd = this.coaCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdCostAmt = this.usdCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRhqCd = this.fRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostTypeV = this.fCostTypeV .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVndr = this.fVndr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostTypeM = this.fCostTypeM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostTypeF = this.fCostTypeF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndNodCd = this.n2ndNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subOfcCd = this.subOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnCostTpNm = this.mnCostTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subCostTpNm = this.subCostTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCtrlOfcCd = this.fCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thNodCd = this.n4thNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stNodCd = this.n1stNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCostAmt = this.loclCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fReport = this.fReport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdNodCd = this.n3rdNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
