/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchAccrualBatchResultRevenueMonthListVO.java
*@FileTitle : SearchAccrualBatchResultRevenueMonthListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.26
*@LastModifier : 
*@LastVersion : 1.0
* 2012.01.26  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAccrualBatchResultRevenueMonthListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAccrualBatchResultRevenueMonthListVO> models = new ArrayList<SearchAccrualBatchResultRevenueMonthListVO>();
	
	/* Column Info */
	private String fCostTypeEv = null;
	/* Column Info */
	private String preActCostAmt = null;
	/* Column Info */
	private String fRhqCd = null;
	/* Column Info */
	private String estmCostAmt = null;
	/* Column Info */
	private String difCostAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnCostTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fCostTypeV = null;
	/* Column Info */
	private String frmRevYrmonFrom = null;
	/* Column Info */
	private String cfmCostAmt = null;
	/* Column Info */
	private String subCostTpCd = null;
	/* Column Info */
	private String fCostTypeM = null;
	/* Column Info */
	private String frmRevYrmonTo = null;
	/* Column Info */
	private String maxExeYrmonMonth = null;
	/* Column Info */
	private String fCostTypeFv = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String fCostTypeF = null;
	/* Column Info */
	private String exeYrmon = null;
	/* Column Info */
	private String acclCostAmt = null;
	/* Column Info */
	private String fCostTypeC = null;
	/* Column Info */
	private String pstActCostAmt = null;
	/* Column Info */
	private String frmExeYrmon = null;
	/* Column Info */
	private String subCostTpNm = null;
	/* Column Info */
	private String adjAcclCostAmt = null;
	/* Column Info */
	private String actCostRatio = null;
	/* Column Info */
	private String diffActCostAmt = null;
	/* Column Info */
	private String actCostAmt = null;
	/* Column Info */
	private String frmRetrievediv = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchAccrualBatchResultRevenueMonthListVO() {}

	public SearchAccrualBatchResultRevenueMonthListVO(String ibflag, String pagerows, String fCostTypeF, String revYrmon, String exeYrmon, String acclCostAmt, String preActCostAmt, String actCostAmt, String frmExeYrmon, String pstActCostAmt, String difCostAmt, String estmCostAmt, String subCostTpNm, String mnCostTpCd, String frmRevYrmonFrom, String actCostRatio, String diffActCostAmt, String cfmCostAmt, String subCostTpCd, String fCostTypeM, String frmRevYrmonTo, String frmRetrievediv, String fCostTypeC, String fCostTypeV, String fRhqCd, String rhqCd, String fCostTypeFv, String fCostTypeEv, String adjAcclCostAmt, String maxExeYrmonMonth) {
		this.fCostTypeEv = fCostTypeEv;
		this.preActCostAmt = preActCostAmt;
		this.fRhqCd = fRhqCd;
		this.estmCostAmt = estmCostAmt;
		this.difCostAmt = difCostAmt;
		this.pagerows = pagerows;
		this.mnCostTpCd = mnCostTpCd;
		this.ibflag = ibflag;
		this.fCostTypeV = fCostTypeV;
		this.frmRevYrmonFrom = frmRevYrmonFrom;
		this.cfmCostAmt = cfmCostAmt;
		this.subCostTpCd = subCostTpCd;
		this.fCostTypeM = fCostTypeM;
		this.frmRevYrmonTo = frmRevYrmonTo;
		this.maxExeYrmonMonth = maxExeYrmonMonth;
		this.fCostTypeFv = fCostTypeFv;
		this.rhqCd = rhqCd;
		this.revYrmon = revYrmon;
		this.fCostTypeF = fCostTypeF;
		this.exeYrmon = exeYrmon;
		this.acclCostAmt = acclCostAmt;
		this.fCostTypeC = fCostTypeC;
		this.pstActCostAmt = pstActCostAmt;
		this.frmExeYrmon = frmExeYrmon;
		this.subCostTpNm = subCostTpNm;
		this.adjAcclCostAmt = adjAcclCostAmt;
		this.actCostRatio = actCostRatio;
		this.diffActCostAmt = diffActCostAmt;
		this.actCostAmt = actCostAmt;
		this.frmRetrievediv = frmRetrievediv;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_cost_type_ev", getFCostTypeEv());
		this.hashColumns.put("pre_act_cost_amt", getPreActCostAmt());
		this.hashColumns.put("f_rhq_cd", getFRhqCd());
		this.hashColumns.put("estm_cost_amt", getEstmCostAmt());
		this.hashColumns.put("dif_cost_amt", getDifCostAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mn_cost_tp_cd", getMnCostTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_cost_type_v", getFCostTypeV());
		this.hashColumns.put("frm_rev_yrmon_from", getFrmRevYrmonFrom());
		this.hashColumns.put("cfm_cost_amt", getCfmCostAmt());
		this.hashColumns.put("sub_cost_tp_cd", getSubCostTpCd());
		this.hashColumns.put("f_cost_type_m", getFCostTypeM());
		this.hashColumns.put("frm_rev_yrmon_to", getFrmRevYrmonTo());
		this.hashColumns.put("max_exe_yrmon_month", getMaxExeYrmonMonth());
		this.hashColumns.put("f_cost_type_fv", getFCostTypeFv());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("f_cost_type_f", getFCostTypeF());
		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("accl_cost_amt", getAcclCostAmt());
		this.hashColumns.put("f_cost_type_c", getFCostTypeC());
		this.hashColumns.put("pst_act_cost_amt", getPstActCostAmt());
		this.hashColumns.put("frm_exe_yrmon", getFrmExeYrmon());
		this.hashColumns.put("sub_cost_tp_nm", getSubCostTpNm());
		this.hashColumns.put("adj_accl_cost_amt", getAdjAcclCostAmt());
		this.hashColumns.put("act_cost_ratio", getActCostRatio());
		this.hashColumns.put("diff_act_cost_amt", getDiffActCostAmt());
		this.hashColumns.put("act_cost_amt", getActCostAmt());
		this.hashColumns.put("frm_retrievediv", getFrmRetrievediv());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_cost_type_ev", "fCostTypeEv");
		this.hashFields.put("pre_act_cost_amt", "preActCostAmt");
		this.hashFields.put("f_rhq_cd", "fRhqCd");
		this.hashFields.put("estm_cost_amt", "estmCostAmt");
		this.hashFields.put("dif_cost_amt", "difCostAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mn_cost_tp_cd", "mnCostTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_cost_type_v", "fCostTypeV");
		this.hashFields.put("frm_rev_yrmon_from", "frmRevYrmonFrom");
		this.hashFields.put("cfm_cost_amt", "cfmCostAmt");
		this.hashFields.put("sub_cost_tp_cd", "subCostTpCd");
		this.hashFields.put("f_cost_type_m", "fCostTypeM");
		this.hashFields.put("frm_rev_yrmon_to", "frmRevYrmonTo");
		this.hashFields.put("max_exe_yrmon_month", "maxExeYrmonMonth");
		this.hashFields.put("f_cost_type_fv", "fCostTypeFv");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("f_cost_type_f", "fCostTypeF");
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("accl_cost_amt", "acclCostAmt");
		this.hashFields.put("f_cost_type_c", "fCostTypeC");
		this.hashFields.put("pst_act_cost_amt", "pstActCostAmt");
		this.hashFields.put("frm_exe_yrmon", "frmExeYrmon");
		this.hashFields.put("sub_cost_tp_nm", "subCostTpNm");
		this.hashFields.put("adj_accl_cost_amt", "adjAcclCostAmt");
		this.hashFields.put("act_cost_ratio", "actCostRatio");
		this.hashFields.put("diff_act_cost_amt", "diffActCostAmt");
		this.hashFields.put("act_cost_amt", "actCostAmt");
		this.hashFields.put("frm_retrievediv", "frmRetrievediv");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fCostTypeEv
	 */
	public String getFCostTypeEv() {
		return this.fCostTypeEv;
	}
	
	/**
	 * Column Info
	 * @return preActCostAmt
	 */
	public String getPreActCostAmt() {
		return this.preActCostAmt;
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
	 * @return estmCostAmt
	 */
	public String getEstmCostAmt() {
		return this.estmCostAmt;
	}
	
	/**
	 * Column Info
	 * @return difCostAmt
	 */
	public String getDifCostAmt() {
		return this.difCostAmt;
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
	 * @return mnCostTpCd
	 */
	public String getMnCostTpCd() {
		return this.mnCostTpCd;
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
	 * @return frmRevYrmonFrom
	 */
	public String getFrmRevYrmonFrom() {
		return this.frmRevYrmonFrom;
	}
	
	/**
	 * Column Info
	 * @return cfmCostAmt
	 */
	public String getCfmCostAmt() {
		return this.cfmCostAmt;
	}
	
	/**
	 * Column Info
	 * @return subCostTpCd
	 */
	public String getSubCostTpCd() {
		return this.subCostTpCd;
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
	 * @return frmRevYrmonTo
	 */
	public String getFrmRevYrmonTo() {
		return this.frmRevYrmonTo;
	}
	
	/**
	 * Column Info
	 * @return maxExeYrmonMonth
	 */
	public String getMaxExeYrmonMonth() {
		return this.maxExeYrmonMonth;
	}
	
	/**
	 * Column Info
	 * @return fCostTypeFv
	 */
	public String getFCostTypeFv() {
		return this.fCostTypeFv;
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
	 * @return acclCostAmt
	 */
	public String getAcclCostAmt() {
		return this.acclCostAmt;
	}
	
	/**
	 * Column Info
	 * @return fCostTypeC
	 */
	public String getFCostTypeC() {
		return this.fCostTypeC;
	}
	
	/**
	 * Column Info
	 * @return pstActCostAmt
	 */
	public String getPstActCostAmt() {
		return this.pstActCostAmt;
	}
	
	/**
	 * Column Info
	 * @return frmExeYrmon
	 */
	public String getFrmExeYrmon() {
		return this.frmExeYrmon;
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
	 * @return adjAcclCostAmt
	 */
	public String getAdjAcclCostAmt() {
		return this.adjAcclCostAmt;
	}
	
	/**
	 * Column Info
	 * @return actCostRatio
	 */
	public String getActCostRatio() {
		return this.actCostRatio;
	}
	
	/**
	 * Column Info
	 * @return diffActCostAmt
	 */
	public String getDiffActCostAmt() {
		return this.diffActCostAmt;
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
	 * @return frmRetrievediv
	 */
	public String getFrmRetrievediv() {
		return this.frmRetrievediv;
	}
	

	/**
	 * Column Info
	 * @param fCostTypeEv
	 */
	public void setFCostTypeEv(String fCostTypeEv) {
		this.fCostTypeEv = fCostTypeEv;
	}
	
	/**
	 * Column Info
	 * @param preActCostAmt
	 */
	public void setPreActCostAmt(String preActCostAmt) {
		this.preActCostAmt = preActCostAmt;
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
	 * @param estmCostAmt
	 */
	public void setEstmCostAmt(String estmCostAmt) {
		this.estmCostAmt = estmCostAmt;
	}
	
	/**
	 * Column Info
	 * @param difCostAmt
	 */
	public void setDifCostAmt(String difCostAmt) {
		this.difCostAmt = difCostAmt;
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
	 * @param mnCostTpCd
	 */
	public void setMnCostTpCd(String mnCostTpCd) {
		this.mnCostTpCd = mnCostTpCd;
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
	 * @param frmRevYrmonFrom
	 */
	public void setFrmRevYrmonFrom(String frmRevYrmonFrom) {
		this.frmRevYrmonFrom = frmRevYrmonFrom;
	}
	
	/**
	 * Column Info
	 * @param cfmCostAmt
	 */
	public void setCfmCostAmt(String cfmCostAmt) {
		this.cfmCostAmt = cfmCostAmt;
	}
	
	/**
	 * Column Info
	 * @param subCostTpCd
	 */
	public void setSubCostTpCd(String subCostTpCd) {
		this.subCostTpCd = subCostTpCd;
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
	 * @param frmRevYrmonTo
	 */
	public void setFrmRevYrmonTo(String frmRevYrmonTo) {
		this.frmRevYrmonTo = frmRevYrmonTo;
	}
	
	/**
	 * Column Info
	 * @param maxExeYrmonMonth
	 */
	public void setMaxExeYrmonMonth(String maxExeYrmonMonth) {
		this.maxExeYrmonMonth = maxExeYrmonMonth;
	}
	
	/**
	 * Column Info
	 * @param fCostTypeFv
	 */
	public void setFCostTypeFv(String fCostTypeFv) {
		this.fCostTypeFv = fCostTypeFv;
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
	 * @param acclCostAmt
	 */
	public void setAcclCostAmt(String acclCostAmt) {
		this.acclCostAmt = acclCostAmt;
	}
	
	/**
	 * Column Info
	 * @param fCostTypeC
	 */
	public void setFCostTypeC(String fCostTypeC) {
		this.fCostTypeC = fCostTypeC;
	}
	
	/**
	 * Column Info
	 * @param pstActCostAmt
	 */
	public void setPstActCostAmt(String pstActCostAmt) {
		this.pstActCostAmt = pstActCostAmt;
	}
	
	/**
	 * Column Info
	 * @param frmExeYrmon
	 */
	public void setFrmExeYrmon(String frmExeYrmon) {
		this.frmExeYrmon = frmExeYrmon;
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
	 * @param adjAcclCostAmt
	 */
	public void setAdjAcclCostAmt(String adjAcclCostAmt) {
		this.adjAcclCostAmt = adjAcclCostAmt;
	}
	
	/**
	 * Column Info
	 * @param actCostRatio
	 */
	public void setActCostRatio(String actCostRatio) {
		this.actCostRatio = actCostRatio;
	}
	
	/**
	 * Column Info
	 * @param diffActCostAmt
	 */
	public void setDiffActCostAmt(String diffActCostAmt) {
		this.diffActCostAmt = diffActCostAmt;
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
	 * @param frmRetrievediv
	 */
	public void setFrmRetrievediv(String frmRetrievediv) {
		this.frmRetrievediv = frmRetrievediv;
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
		setFCostTypeEv(JSPUtil.getParameter(request, prefix + "f_cost_type_ev", ""));
		setPreActCostAmt(JSPUtil.getParameter(request, prefix + "pre_act_cost_amt", ""));
		setFRhqCd(JSPUtil.getParameter(request, prefix + "f_rhq_cd", ""));
		setEstmCostAmt(JSPUtil.getParameter(request, prefix + "estm_cost_amt", ""));
		setDifCostAmt(JSPUtil.getParameter(request, prefix + "dif_cost_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMnCostTpCd(JSPUtil.getParameter(request, prefix + "mn_cost_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFCostTypeV(JSPUtil.getParameter(request, prefix + "f_cost_type_v", ""));
		setFrmRevYrmonFrom(JSPUtil.getParameter(request, prefix + "frm_rev_yrmon_from", ""));
		setCfmCostAmt(JSPUtil.getParameter(request, prefix + "cfm_cost_amt", ""));
		setSubCostTpCd(JSPUtil.getParameter(request, prefix + "sub_cost_tp_cd", ""));
		setFCostTypeM(JSPUtil.getParameter(request, prefix + "f_cost_type_m", ""));
		setFrmRevYrmonTo(JSPUtil.getParameter(request, prefix + "frm_rev_yrmon_to", ""));
		setMaxExeYrmonMonth(JSPUtil.getParameter(request, prefix + "max_exe_yrmon_month", ""));
		setFCostTypeFv(JSPUtil.getParameter(request, prefix + "f_cost_type_fv", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setFCostTypeF(JSPUtil.getParameter(request, prefix + "f_cost_type_f", ""));
		setExeYrmon(JSPUtil.getParameter(request, prefix + "exe_yrmon", ""));
		setAcclCostAmt(JSPUtil.getParameter(request, prefix + "accl_cost_amt", ""));
		setFCostTypeC(JSPUtil.getParameter(request, prefix + "f_cost_type_c", ""));
		setPstActCostAmt(JSPUtil.getParameter(request, prefix + "pst_act_cost_amt", ""));
		setFrmExeYrmon(JSPUtil.getParameter(request, prefix + "frm_exe_yrmon", ""));
		setSubCostTpNm(JSPUtil.getParameter(request, prefix + "sub_cost_tp_nm", ""));
		setAdjAcclCostAmt(JSPUtil.getParameter(request, prefix + "adj_accl_cost_amt", ""));
		setActCostRatio(JSPUtil.getParameter(request, prefix + "act_cost_ratio", ""));
		setDiffActCostAmt(JSPUtil.getParameter(request, prefix + "diff_act_cost_amt", ""));
		setActCostAmt(JSPUtil.getParameter(request, prefix + "act_cost_amt", ""));
		setFrmRetrievediv(JSPUtil.getParameter(request, prefix + "frm_retrievediv", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAccrualBatchResultRevenueMonthListVO[]
	 */
	public SearchAccrualBatchResultRevenueMonthListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAccrualBatchResultRevenueMonthListVO[]
	 */
	public SearchAccrualBatchResultRevenueMonthListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAccrualBatchResultRevenueMonthListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fCostTypeEv = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_ev", length));
			String[] preActCostAmt = (JSPUtil.getParameter(request, prefix	+ "pre_act_cost_amt", length));
			String[] fRhqCd = (JSPUtil.getParameter(request, prefix	+ "f_rhq_cd", length));
			String[] estmCostAmt = (JSPUtil.getParameter(request, prefix	+ "estm_cost_amt", length));
			String[] difCostAmt = (JSPUtil.getParameter(request, prefix	+ "dif_cost_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnCostTpCd = (JSPUtil.getParameter(request, prefix	+ "mn_cost_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fCostTypeV = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_v", length));
			String[] frmRevYrmonFrom = (JSPUtil.getParameter(request, prefix	+ "frm_rev_yrmon_from", length));
			String[] cfmCostAmt = (JSPUtil.getParameter(request, prefix	+ "cfm_cost_amt", length));
			String[] subCostTpCd = (JSPUtil.getParameter(request, prefix	+ "sub_cost_tp_cd", length));
			String[] fCostTypeM = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_m", length));
			String[] frmRevYrmonTo = (JSPUtil.getParameter(request, prefix	+ "frm_rev_yrmon_to", length));
			String[] maxExeYrmonMonth = (JSPUtil.getParameter(request, prefix	+ "max_exe_yrmon_month", length));
			String[] fCostTypeFv = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_fv", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] fCostTypeF = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_f", length));
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
			String[] acclCostAmt = (JSPUtil.getParameter(request, prefix	+ "accl_cost_amt", length));
			String[] fCostTypeC = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_c", length));
			String[] pstActCostAmt = (JSPUtil.getParameter(request, prefix	+ "pst_act_cost_amt", length));
			String[] frmExeYrmon = (JSPUtil.getParameter(request, prefix	+ "frm_exe_yrmon", length));
			String[] subCostTpNm = (JSPUtil.getParameter(request, prefix	+ "sub_cost_tp_nm", length));
			String[] adjAcclCostAmt = (JSPUtil.getParameter(request, prefix	+ "adj_accl_cost_amt", length));
			String[] actCostRatio = (JSPUtil.getParameter(request, prefix	+ "act_cost_ratio", length));
			String[] diffActCostAmt = (JSPUtil.getParameter(request, prefix	+ "diff_act_cost_amt", length));
			String[] actCostAmt = (JSPUtil.getParameter(request, prefix	+ "act_cost_amt", length));
			String[] frmRetrievediv = (JSPUtil.getParameter(request, prefix	+ "frm_retrievediv", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAccrualBatchResultRevenueMonthListVO();
				if (fCostTypeEv[i] != null)
					model.setFCostTypeEv(fCostTypeEv[i]);
				if (preActCostAmt[i] != null)
					model.setPreActCostAmt(preActCostAmt[i]);
				if (fRhqCd[i] != null)
					model.setFRhqCd(fRhqCd[i]);
				if (estmCostAmt[i] != null)
					model.setEstmCostAmt(estmCostAmt[i]);
				if (difCostAmt[i] != null)
					model.setDifCostAmt(difCostAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnCostTpCd[i] != null)
					model.setMnCostTpCd(mnCostTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fCostTypeV[i] != null)
					model.setFCostTypeV(fCostTypeV[i]);
				if (frmRevYrmonFrom[i] != null)
					model.setFrmRevYrmonFrom(frmRevYrmonFrom[i]);
				if (cfmCostAmt[i] != null)
					model.setCfmCostAmt(cfmCostAmt[i]);
				if (subCostTpCd[i] != null)
					model.setSubCostTpCd(subCostTpCd[i]);
				if (fCostTypeM[i] != null)
					model.setFCostTypeM(fCostTypeM[i]);
				if (frmRevYrmonTo[i] != null)
					model.setFrmRevYrmonTo(frmRevYrmonTo[i]);
				if (maxExeYrmonMonth[i] != null)
					model.setMaxExeYrmonMonth(maxExeYrmonMonth[i]);
				if (fCostTypeFv[i] != null)
					model.setFCostTypeFv(fCostTypeFv[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (fCostTypeF[i] != null)
					model.setFCostTypeF(fCostTypeF[i]);
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
				if (acclCostAmt[i] != null)
					model.setAcclCostAmt(acclCostAmt[i]);
				if (fCostTypeC[i] != null)
					model.setFCostTypeC(fCostTypeC[i]);
				if (pstActCostAmt[i] != null)
					model.setPstActCostAmt(pstActCostAmt[i]);
				if (frmExeYrmon[i] != null)
					model.setFrmExeYrmon(frmExeYrmon[i]);
				if (subCostTpNm[i] != null)
					model.setSubCostTpNm(subCostTpNm[i]);
				if (adjAcclCostAmt[i] != null)
					model.setAdjAcclCostAmt(adjAcclCostAmt[i]);
				if (actCostRatio[i] != null)
					model.setActCostRatio(actCostRatio[i]);
				if (diffActCostAmt[i] != null)
					model.setDiffActCostAmt(diffActCostAmt[i]);
				if (actCostAmt[i] != null)
					model.setActCostAmt(actCostAmt[i]);
				if (frmRetrievediv[i] != null)
					model.setFrmRetrievediv(frmRetrievediv[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAccrualBatchResultRevenueMonthListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAccrualBatchResultRevenueMonthListVO[]
	 */
	public SearchAccrualBatchResultRevenueMonthListVO[] getSearchAccrualBatchResultRevenueMonthListVOs(){
		SearchAccrualBatchResultRevenueMonthListVO[] vos = (SearchAccrualBatchResultRevenueMonthListVO[])models.toArray(new SearchAccrualBatchResultRevenueMonthListVO[models.size()]);
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
		this.fCostTypeEv = this.fCostTypeEv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preActCostAmt = this.preActCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRhqCd = this.fRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCostAmt = this.estmCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.difCostAmt = this.difCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnCostTpCd = this.mnCostTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostTypeV = this.fCostTypeV .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRevYrmonFrom = this.frmRevYrmonFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmCostAmt = this.cfmCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subCostTpCd = this.subCostTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostTypeM = this.fCostTypeM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRevYrmonTo = this.frmRevYrmonTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxExeYrmonMonth = this.maxExeYrmonMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostTypeFv = this.fCostTypeFv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostTypeF = this.fCostTypeF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclCostAmt = this.acclCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostTypeC = this.fCostTypeC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstActCostAmt = this.pstActCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmExeYrmon = this.frmExeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subCostTpNm = this.subCostTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjAcclCostAmt = this.adjAcclCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostRatio = this.actCostRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffActCostAmt = this.diffActCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostAmt = this.actCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRetrievediv = this.frmRetrievediv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
