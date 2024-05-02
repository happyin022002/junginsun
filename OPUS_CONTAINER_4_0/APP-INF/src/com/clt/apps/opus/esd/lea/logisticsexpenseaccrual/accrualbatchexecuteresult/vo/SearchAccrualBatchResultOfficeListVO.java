/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchAccrualBatchResultOfficeListVO.java
*@FileTitle : SearchAccrualBatchResultOfficeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.22
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.11.22 전재홍 
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

public class SearchAccrualBatchResultOfficeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAccrualBatchResultOfficeListVO> models = new ArrayList<SearchAccrualBatchResultOfficeListVO>();
	
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String subOfcCd = null;
	/* Column Info */
	private String fCostTypeF = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String coaCostSrcCd = null;
	/* Column Info */
	private String n2ndNodCd = null;
	/* Column Info */
	private String acclCostAmt = null;
	/* Column Info */
	private String mnCostTpNm = null;
	/* Column Info */
	private String fRhqCd = null;
	/* Column Info */
	private String diffCostAmt = null;
	/* Column Info */
	private String estmCostAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String subCostTpNm = null;
	/* Column Info */
	private String fCostTypeV = null;
	/* Column Info */
	private String fCtrlOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String n4thNodCd = null;
	/* Column Info */
	private String n1stNodCd = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String fReport = null;
	/* Column Info */
	private String confirmedCostAmt = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String fCostTypeM = null;
	/* Column Info */
	private String actCostAmt = null;
	/* Column Info */
	private String n3rdNodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchAccrualBatchResultOfficeListVO() {}

	public SearchAccrualBatchResultOfficeListVO(String ibflag, String pagerows, String revYrmon, String rhqCd, String mnCostTpNm, String subCostTpNm, String coaCostSrcCd, String acctCd, String n1stNodCd, String n2ndNodCd, String n3rdNodCd, String n4thNodCd, String cntrQty, String estmCostAmt, String actCostAmt, String acclCostAmt, String confirmedCostAmt, String diffCostAmt, String fReport, String fCtrlOfcCd, String fRhqCd, String fCostTypeM, String fCostTypeF, String fCostTypeV) {
		this.rhqCd = rhqCd;
		this.ctrlOfcCd = ctrlOfcCd;
		this.subOfcCd = subOfcCd;
		this.fCostTypeF = fCostTypeF;
		this.revYrmon = revYrmon;
		this.coaCostSrcCd = coaCostSrcCd;
		this.n2ndNodCd = n2ndNodCd;
		this.acclCostAmt = acclCostAmt;
		this.mnCostTpNm = mnCostTpNm;
		this.fRhqCd = fRhqCd;
		this.diffCostAmt = diffCostAmt;
		this.estmCostAmt = estmCostAmt;
		this.pagerows = pagerows;
		this.subCostTpNm = subCostTpNm;
		this.fCostTypeV = fCostTypeV;
		this.fCtrlOfcCd = fCtrlOfcCd;
		this.ibflag = ibflag;
		this.n4thNodCd = n4thNodCd;
		this.n1stNodCd = n1stNodCd;
		this.acctCd = acctCd;
		this.fReport = fReport;
		this.confirmedCostAmt = confirmedCostAmt;
		this.cntrQty = cntrQty;
		this.fCostTypeM = fCostTypeM;
		this.actCostAmt = actCostAmt;
		this.n3rdNodCd = n3rdNodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("sub_ofc_cd", getSubOfcCd());
		this.hashColumns.put("f_cost_type_f", getFCostTypeF());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("coa_cost_src_cd", getCoaCostSrcCd());
		this.hashColumns.put("n2nd_nod_cd", getN2ndNodCd());
		this.hashColumns.put("accl_cost_amt", getAcclCostAmt());
		this.hashColumns.put("mn_cost_tp_nm", getMnCostTpNm());
		this.hashColumns.put("f_rhq_cd", getFRhqCd());
		this.hashColumns.put("diff_cost_amt", getDiffCostAmt());
		this.hashColumns.put("estm_cost_amt", getEstmCostAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sub_cost_tp_nm", getSubCostTpNm());
		this.hashColumns.put("f_cost_type_v", getFCostTypeV());
		this.hashColumns.put("f_ctrl_ofc_cd", getFCtrlOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n4th_nod_cd", getN4thNodCd());
		this.hashColumns.put("n1st_nod_cd", getN1stNodCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("f_report", getFReport());
		this.hashColumns.put("confirmed_cost_amt", getConfirmedCostAmt());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("f_cost_type_m", getFCostTypeM());
		this.hashColumns.put("act_cost_amt", getActCostAmt());
		this.hashColumns.put("n3rd_nod_cd", getN3rdNodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("sub_ofc_cd", "subOfcCd");
		this.hashFields.put("f_cost_type_f", "fCostTypeF");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("coa_cost_src_cd", "coaCostSrcCd");
		this.hashFields.put("n2nd_nod_cd", "n2ndNodCd");
		this.hashFields.put("accl_cost_amt", "acclCostAmt");
		this.hashFields.put("mn_cost_tp_nm", "mnCostTpNm");
		this.hashFields.put("f_rhq_cd", "fRhqCd");
		this.hashFields.put("diff_cost_amt", "diffCostAmt");
		this.hashFields.put("estm_cost_amt", "estmCostAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sub_cost_tp_nm", "subCostTpNm");
		this.hashFields.put("f_cost_type_v", "fCostTypeV");
		this.hashFields.put("f_ctrl_ofc_cd", "fCtrlOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n4th_nod_cd", "n4thNodCd");
		this.hashFields.put("n1st_nod_cd", "n1stNodCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("f_report", "fReport");
		this.hashFields.put("confirmed_cost_amt", "confirmedCostAmt");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("f_cost_type_m", "fCostTypeM");
		this.hashFields.put("act_cost_amt", "actCostAmt");
		this.hashFields.put("n3rd_nod_cd", "n3rdNodCd");
		return this.hashFields;
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
	 * @return rhqCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getSubOfcCd() {
		return this.subOfcCd;
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
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
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
	 * @return n2ndNodCd
	 */
	public String getN2ndNodCd() {
		return this.n2ndNodCd;
	}
	
	/**
	 * Column Info
	 * @return acclCostAmt
	 */
	public String getAcclCostAmt() {
		return this.acclCostAmt;
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
	 * @return fRhqCd
	 */
	public String getFRhqCd() {
		return this.fRhqCd;
	}
	
	/**
	 * Column Info
	 * @return diffCostAmt
	 */
	public String getDiffCostAmt() {
		return this.diffCostAmt;
	}
	
	/**
	 * Column Info
	 * @return estmCostAmt
	 */
	public String getEstmCostAmt() {
		return this.estmCostAmt;
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
	 * @return subCostTpNm
	 */
	public String getSubCostTpNm() {
		return this.subCostTpNm;
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
	 * @return fCtrlOfcCd
	 */
	public String getFCtrlOfcCd() {
		return this.fCtrlOfcCd;
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
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
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
	 * @return confirmedCostAmt
	 */
	public String getConfirmedCostAmt() {
		return this.confirmedCostAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
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
	 * @return actCostAmt
	 */
	public String getActCostAmt() {
		return this.actCostAmt;
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
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.rhqCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setSubOfcCd(String subOfcCd) {
		this.rhqCd = subOfcCd;
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
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
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
	 * @param n2ndNodCd
	 */
	public void setN2ndNodCd(String n2ndNodCd) {
		this.n2ndNodCd = n2ndNodCd;
	}
	
	/**
	 * Column Info
	 * @param acclCostAmt
	 */
	public void setAcclCostAmt(String acclCostAmt) {
		this.acclCostAmt = acclCostAmt;
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
	 * @param fRhqCd
	 */
	public void setFRhqCd(String fRhqCd) {
		this.fRhqCd = fRhqCd;
	}
	
	/**
	 * Column Info
	 * @param diffCostAmt
	 */
	public void setDiffCostAmt(String diffCostAmt) {
		this.diffCostAmt = diffCostAmt;
	}
	
	/**
	 * Column Info
	 * @param estmCostAmt
	 */
	public void setEstmCostAmt(String estmCostAmt) {
		this.estmCostAmt = estmCostAmt;
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
	 * @param subCostTpNm
	 */
	public void setSubCostTpNm(String subCostTpNm) {
		this.subCostTpNm = subCostTpNm;
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
	 * @param fCtrlOfcCd
	 */
	public void setFCtrlOfcCd(String fCtrlOfcCd) {
		this.fCtrlOfcCd = fCtrlOfcCd;
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
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
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
	 * @param confirmedCostAmt
	 */
	public void setConfirmedCostAmt(String confirmedCostAmt) {
		this.confirmedCostAmt = confirmedCostAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
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
	 * @param actCostAmt
	 */
	public void setActCostAmt(String actCostAmt) {
		this.actCostAmt = actCostAmt;
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
		setRhqCd(JSPUtil.getParameter(request, "rhq_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, "ctrl_ofc_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, "sub_ofc_cd", ""));
		setFCostTypeF(JSPUtil.getParameter(request, "f_cost_type_f", ""));
		setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));
		setCoaCostSrcCd(JSPUtil.getParameter(request, "coa_cost_src_cd", ""));
		setN2ndNodCd(JSPUtil.getParameter(request, "n2nd_nod_cd", ""));
		setAcclCostAmt(JSPUtil.getParameter(request, "accl_cost_amt", ""));
		setMnCostTpNm(JSPUtil.getParameter(request, "mn_cost_tp_nm", ""));
		setFRhqCd(JSPUtil.getParameter(request, "f_rhq_cd", ""));
		setDiffCostAmt(JSPUtil.getParameter(request, "diff_cost_amt", ""));
		setEstmCostAmt(JSPUtil.getParameter(request, "estm_cost_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSubCostTpNm(JSPUtil.getParameter(request, "sub_cost_tp_nm", ""));
		setFCostTypeV(JSPUtil.getParameter(request, "f_cost_type_v", ""));
		setFCtrlOfcCd(JSPUtil.getParameter(request, "f_ctrl_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setN4thNodCd(JSPUtil.getParameter(request, "n4th_nod_cd", ""));
		setN1stNodCd(JSPUtil.getParameter(request, "n1st_nod_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setFReport(JSPUtil.getParameter(request, "f_report", ""));
		setConfirmedCostAmt(JSPUtil.getParameter(request, "confirmed_cost_amt", ""));
		setCntrQty(JSPUtil.getParameter(request, "cntr_qty", ""));
		setFCostTypeM(JSPUtil.getParameter(request, "f_cost_type_m", ""));
		setActCostAmt(JSPUtil.getParameter(request, "act_cost_amt", ""));
		setN3rdNodCd(JSPUtil.getParameter(request, "n3rd_nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAccrualBatchResultOfficeListVO[]
	 */
	public SearchAccrualBatchResultOfficeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAccrualBatchResultOfficeListVO[]
	 */
	public SearchAccrualBatchResultOfficeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAccrualBatchResultOfficeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] subOfcCd = (JSPUtil.getParameter(request, prefix	+ "sub_ofc_cd", length));
			String[] fCostTypeF = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_f", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] coaCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "coa_cost_src_cd", length));
			String[] n2ndNodCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_nod_cd", length));
			String[] acclCostAmt = (JSPUtil.getParameter(request, prefix	+ "accl_cost_amt", length));
			String[] mnCostTpNm = (JSPUtil.getParameter(request, prefix	+ "mn_cost_tp_nm", length));
			String[] fRhqCd = (JSPUtil.getParameter(request, prefix	+ "f_rhq_cd", length));
			String[] diffCostAmt = (JSPUtil.getParameter(request, prefix	+ "diff_cost_amt", length));
			String[] estmCostAmt = (JSPUtil.getParameter(request, prefix	+ "estm_cost_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] subCostTpNm = (JSPUtil.getParameter(request, prefix	+ "sub_cost_tp_nm", length));
			String[] fCostTypeV = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_v", length));
			String[] fCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_ctrl_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] n4thNodCd = (JSPUtil.getParameter(request, prefix	+ "n4th_nod_cd", length));
			String[] n1stNodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_nod_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] fReport = (JSPUtil.getParameter(request, prefix	+ "f_report", length));
			String[] confirmedCostAmt = (JSPUtil.getParameter(request, prefix	+ "confirmed_cost_amt", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] fCostTypeM = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_m", length));
			String[] actCostAmt = (JSPUtil.getParameter(request, prefix	+ "act_cost_amt", length));
			String[] n3rdNodCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_nod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAccrualBatchResultOfficeListVO();
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (subOfcCd[i] != null)
					model.setSubOfcCd(subOfcCd[i]);
				if (fCostTypeF[i] != null)
					model.setFCostTypeF(fCostTypeF[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (coaCostSrcCd[i] != null)
					model.setCoaCostSrcCd(coaCostSrcCd[i]);
				if (n2ndNodCd[i] != null)
					model.setN2ndNodCd(n2ndNodCd[i]);
				if (acclCostAmt[i] != null)
					model.setAcclCostAmt(acclCostAmt[i]);
				if (mnCostTpNm[i] != null)
					model.setMnCostTpNm(mnCostTpNm[i]);
				if (fRhqCd[i] != null)
					model.setFRhqCd(fRhqCd[i]);
				if (diffCostAmt[i] != null)
					model.setDiffCostAmt(diffCostAmt[i]);
				if (estmCostAmt[i] != null)
					model.setEstmCostAmt(estmCostAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (subCostTpNm[i] != null)
					model.setSubCostTpNm(subCostTpNm[i]);
				if (fCostTypeV[i] != null)
					model.setFCostTypeV(fCostTypeV[i]);
				if (fCtrlOfcCd[i] != null)
					model.setFCtrlOfcCd(fCtrlOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (n4thNodCd[i] != null)
					model.setN4thNodCd(n4thNodCd[i]);
				if (n1stNodCd[i] != null)
					model.setN1stNodCd(n1stNodCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (fReport[i] != null)
					model.setFReport(fReport[i]);
				if (confirmedCostAmt[i] != null)
					model.setConfirmedCostAmt(confirmedCostAmt[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (fCostTypeM[i] != null)
					model.setFCostTypeM(fCostTypeM[i]);
				if (actCostAmt[i] != null)
					model.setActCostAmt(actCostAmt[i]);
				if (n3rdNodCd[i] != null)
					model.setN3rdNodCd(n3rdNodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAccrualBatchResultOfficeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAccrualBatchResultOfficeListVO[]
	 */
	public SearchAccrualBatchResultOfficeListVO[] getSearchAccrualBatchResultOfficeListVOs(){
		SearchAccrualBatchResultOfficeListVO[] vos = (SearchAccrualBatchResultOfficeListVO[])models.toArray(new SearchAccrualBatchResultOfficeListVO[models.size()]);
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
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subOfcCd = this.subOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostTypeF = this.fCostTypeF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaCostSrcCd = this.coaCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndNodCd = this.n2ndNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclCostAmt = this.acclCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnCostTpNm = this.mnCostTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRhqCd = this.fRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffCostAmt = this.diffCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCostAmt = this.estmCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subCostTpNm = this.subCostTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostTypeV = this.fCostTypeV .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCtrlOfcCd = this.fCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thNodCd = this.n4thNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stNodCd = this.n1stNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fReport = this.fReport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.confirmedCostAmt = this.confirmedCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostTypeM = this.fCostTypeM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostAmt = this.actCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdNodCd = this.n3rdNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
