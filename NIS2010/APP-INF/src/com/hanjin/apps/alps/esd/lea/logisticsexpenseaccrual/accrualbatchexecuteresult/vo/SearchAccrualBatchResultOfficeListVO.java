/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchAccrualBatchResultOfficeListVO.java
*@FileTitle : SearchAccrualBatchResultOfficeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.23  
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

public class SearchAccrualBatchResultOfficeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAccrualBatchResultOfficeListVO> models = new ArrayList<SearchAccrualBatchResultOfficeListVO>();
	
	/* Column Info */
	private String coaCostSrcCd = null;
	/* Column Info */
	private String fCostTypeEv = null;
	/* Column Info */
	private String preActCostAmt = null;
	/* Column Info */
	private String fRhqCd = null;
	/* Column Info */
	private String difCostAmt = null;
	/* Column Info */
	private String estmCostAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fCostTypeV = null;
	/* Column Info */
	private String fCostTypeU = null;
	/* Column Info */
	private String frmRevYrmonFrom = null;
	/* Column Info */
	private String cfmCostAmt = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String frmRevYrmonTo = null;
	/* Column Info */
	private String fCostTypeM = null;
	/* Column Info */
	private String bindSubOfcCd = null;
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
	private String n2ndNodCd = null;
	/* Column Info */
	private String subOfcCd = null;
	/* Column Info */
	private String fCostTypeC = null;
	/* Column Info */
	private String mnCostTpNm = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String pstActCostAmt = null;
	/* Column Info */
	private String fSubOfcCd = null;
	/* Column Info */
	private String subCostTpNm = null;
	/* Column Info */
	private String fCtrlOfcCd = null;
	/* Column Info */
	private String n4thNodCd = null;
	/* Column Info */
	private String adjAcclCostAmt = null;
	/* Column Info */
	private String actCostRatio = null;
	/* Column Info */
	private String n1stNodCd = null;
	/* Column Info */
	private String fReport = null;
	/* Column Info */
	private String bindOfcCd = null;
	/* Column Info */
	private String difActCostAmt = null;
	/* Column Info */
	private String actCostAmt = null;
	/* Column Info */
	private String n3rdNodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchAccrualBatchResultOfficeListVO() {}

	public SearchAccrualBatchResultOfficeListVO(String ibflag, String pagerows, String rhqCd, String ctrlOfcCd, String subOfcCd, String fCostTypeF, String revYrmon, String exeYrmon, String coaCostSrcCd, String n2ndNodCd, String adjAcclCostAmt, String mnCostTpNm, String fRhqCd, String difCostAmt, String estmCostAmt, String subCostTpNm, String fCostTypeV, String fCtrlOfcCd, String n4thNodCd, String n1stNodCd, String acctCd, String fReport, String cfmCostAmt, String cntrQty, String fCostTypeM, String preActCostAmt, String pstActCostAmt, String n3rdNodCd, String fCostTypeC, String fCostTypeU, String frmRevYrmonTo, String frmRevYrmonFrom, String fCostTypeFv, String fCostTypeEv, String fSubOfcCd, String actCostAmt, String difActCostAmt, String actCostRatio, String bindOfcCd, String bindSubOfcCd) {
		this.coaCostSrcCd = coaCostSrcCd;
		this.fCostTypeEv = fCostTypeEv;
		this.preActCostAmt = preActCostAmt;
		this.fRhqCd = fRhqCd;
		this.difCostAmt = difCostAmt;
		this.estmCostAmt = estmCostAmt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.fCostTypeV = fCostTypeV;
		this.fCostTypeU = fCostTypeU;
		this.frmRevYrmonFrom = frmRevYrmonFrom;
		this.cfmCostAmt = cfmCostAmt;
		this.acctCd = acctCd;
		this.cntrQty = cntrQty;
		this.frmRevYrmonTo = frmRevYrmonTo;
		this.fCostTypeM = fCostTypeM;
		this.bindSubOfcCd = bindSubOfcCd;
		this.fCostTypeFv = fCostTypeFv;
		this.rhqCd = rhqCd;
		this.revYrmon = revYrmon;
		this.fCostTypeF = fCostTypeF;
		this.exeYrmon = exeYrmon;
		this.n2ndNodCd = n2ndNodCd;
		this.subOfcCd = subOfcCd;
		this.fCostTypeC = fCostTypeC;
		this.mnCostTpNm = mnCostTpNm;
		this.ctrlOfcCd = ctrlOfcCd;
		this.pstActCostAmt = pstActCostAmt;
		this.fSubOfcCd = fSubOfcCd;
		this.subCostTpNm = subCostTpNm;
		this.fCtrlOfcCd = fCtrlOfcCd;
		this.n4thNodCd = n4thNodCd;
		this.adjAcclCostAmt = adjAcclCostAmt;
		this.actCostRatio = actCostRatio;
		this.n1stNodCd = n1stNodCd;
		this.fReport = fReport;
		this.bindOfcCd = bindOfcCd;
		this.difActCostAmt = difActCostAmt;
		this.actCostAmt = actCostAmt;
		this.n3rdNodCd = n3rdNodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("coa_cost_src_cd", getCoaCostSrcCd());
		this.hashColumns.put("f_cost_type_ev", getFCostTypeEv());
		this.hashColumns.put("pre_act_cost_amt", getPreActCostAmt());
		this.hashColumns.put("f_rhq_cd", getFRhqCd());
		this.hashColumns.put("dif_cost_amt", getDifCostAmt());
		this.hashColumns.put("estm_cost_amt", getEstmCostAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_cost_type_v", getFCostTypeV());
		this.hashColumns.put("f_cost_type_u", getFCostTypeU());
		this.hashColumns.put("frm_rev_yrmon_from", getFrmRevYrmonFrom());
		this.hashColumns.put("cfm_cost_amt", getCfmCostAmt());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("frm_rev_yrmon_to", getFrmRevYrmonTo());
		this.hashColumns.put("f_cost_type_m", getFCostTypeM());
		this.hashColumns.put("bind_sub_ofc_cd", getBindSubOfcCd());
		this.hashColumns.put("f_cost_type_fv", getFCostTypeFv());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("f_cost_type_f", getFCostTypeF());
		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("n2nd_nod_cd", getN2ndNodCd());
		this.hashColumns.put("sub_ofc_cd", getSubOfcCd());
		this.hashColumns.put("f_cost_type_c", getFCostTypeC());
		this.hashColumns.put("mn_cost_tp_nm", getMnCostTpNm());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("pst_act_cost_amt", getPstActCostAmt());
		this.hashColumns.put("f_sub_ofc_cd", getFSubOfcCd());
		this.hashColumns.put("sub_cost_tp_nm", getSubCostTpNm());
		this.hashColumns.put("f_ctrl_ofc_cd", getFCtrlOfcCd());
		this.hashColumns.put("n4th_nod_cd", getN4thNodCd());
		this.hashColumns.put("adj_accl_cost_amt", getAdjAcclCostAmt());
		this.hashColumns.put("act_cost_ratio", getActCostRatio());
		this.hashColumns.put("n1st_nod_cd", getN1stNodCd());
		this.hashColumns.put("f_report", getFReport());
		this.hashColumns.put("bind_ofc_cd", getBindOfcCd());
		this.hashColumns.put("dif_act_cost_amt", getDifActCostAmt());
		this.hashColumns.put("act_cost_amt", getActCostAmt());
		this.hashColumns.put("n3rd_nod_cd", getN3rdNodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("coa_cost_src_cd", "coaCostSrcCd");
		this.hashFields.put("f_cost_type_ev", "fCostTypeEv");
		this.hashFields.put("pre_act_cost_amt", "preActCostAmt");
		this.hashFields.put("f_rhq_cd", "fRhqCd");
		this.hashFields.put("dif_cost_amt", "difCostAmt");
		this.hashFields.put("estm_cost_amt", "estmCostAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_cost_type_v", "fCostTypeV");
		this.hashFields.put("f_cost_type_u", "fCostTypeU");
		this.hashFields.put("frm_rev_yrmon_from", "frmRevYrmonFrom");
		this.hashFields.put("cfm_cost_amt", "cfmCostAmt");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("frm_rev_yrmon_to", "frmRevYrmonTo");
		this.hashFields.put("f_cost_type_m", "fCostTypeM");
		this.hashFields.put("bind_sub_ofc_cd", "bindSubOfcCd");
		this.hashFields.put("f_cost_type_fv", "fCostTypeFv");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("f_cost_type_f", "fCostTypeF");
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("n2nd_nod_cd", "n2ndNodCd");
		this.hashFields.put("sub_ofc_cd", "subOfcCd");
		this.hashFields.put("f_cost_type_c", "fCostTypeC");
		this.hashFields.put("mn_cost_tp_nm", "mnCostTpNm");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("pst_act_cost_amt", "pstActCostAmt");
		this.hashFields.put("f_sub_ofc_cd", "fSubOfcCd");
		this.hashFields.put("sub_cost_tp_nm", "subCostTpNm");
		this.hashFields.put("f_ctrl_ofc_cd", "fCtrlOfcCd");
		this.hashFields.put("n4th_nod_cd", "n4thNodCd");
		this.hashFields.put("adj_accl_cost_amt", "adjAcclCostAmt");
		this.hashFields.put("act_cost_ratio", "actCostRatio");
		this.hashFields.put("n1st_nod_cd", "n1stNodCd");
		this.hashFields.put("f_report", "fReport");
		this.hashFields.put("bind_ofc_cd", "bindOfcCd");
		this.hashFields.put("dif_act_cost_amt", "difActCostAmt");
		this.hashFields.put("act_cost_amt", "actCostAmt");
		this.hashFields.put("n3rd_nod_cd", "n3rdNodCd");
		return this.hashFields;
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
	 * @return difCostAmt
	 */
	public String getDifCostAmt() {
		return this.difCostAmt;
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
	 * @return fCostTypeU
	 */
	public String getFCostTypeU() {
		return this.fCostTypeU;
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
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
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
	 * @return frmRevYrmonTo
	 */
	public String getFrmRevYrmonTo() {
		return this.frmRevYrmonTo;
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
	 * @return bindSubOfcCd
	 */
	public String getBindSubOfcCd() {
		return this.bindSubOfcCd;
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
	 * @return fCostTypeC
	 */
	public String getFCostTypeC() {
		return this.fCostTypeC;
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
	 * @return pstActCostAmt
	 */
	public String getPstActCostAmt() {
		return this.pstActCostAmt;
	}
	
	/**
	 * Column Info
	 * @return fSubOfcCd
	 */
	public String getFSubOfcCd() {
		return this.fSubOfcCd;
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
	 * @return n1stNodCd
	 */
	public String getN1stNodCd() {
		return this.n1stNodCd;
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
	 * @return bindOfcCd
	 */
	public String getBindOfcCd() {
		return this.bindOfcCd;
	}
	
	/**
	 * Column Info
	 * @return difActCostAmt
	 */
	public String getDifActCostAmt() {
		return this.difActCostAmt;
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
	 * @param coaCostSrcCd
	 */
	public void setCoaCostSrcCd(String coaCostSrcCd) {
		this.coaCostSrcCd = coaCostSrcCd;
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
	 * @param difCostAmt
	 */
	public void setDifCostAmt(String difCostAmt) {
		this.difCostAmt = difCostAmt;
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
	 * @param fCostTypeU
	 */
	public void setFCostTypeU(String fCostTypeU) {
		this.fCostTypeU = fCostTypeU;
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
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
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
	 * @param frmRevYrmonTo
	 */
	public void setFrmRevYrmonTo(String frmRevYrmonTo) {
		this.frmRevYrmonTo = frmRevYrmonTo;
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
	 * @param bindSubOfcCd
	 */
	public void setBindSubOfcCd(String bindSubOfcCd) {
		this.bindSubOfcCd = bindSubOfcCd;
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
	 * @param fCostTypeC
	 */
	public void setFCostTypeC(String fCostTypeC) {
		this.fCostTypeC = fCostTypeC;
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
	 * @param pstActCostAmt
	 */
	public void setPstActCostAmt(String pstActCostAmt) {
		this.pstActCostAmt = pstActCostAmt;
	}
	
	/**
	 * Column Info
	 * @param fSubOfcCd
	 */
	public void setFSubOfcCd(String fSubOfcCd) {
		this.fSubOfcCd = fSubOfcCd;
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
	 * @param n1stNodCd
	 */
	public void setN1stNodCd(String n1stNodCd) {
		this.n1stNodCd = n1stNodCd;
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
	 * @param bindOfcCd
	 */
	public void setBindOfcCd(String bindOfcCd) {
		this.bindOfcCd = bindOfcCd;
	}
	
	/**
	 * Column Info
	 * @param difActCostAmt
	 */
	public void setDifActCostAmt(String difActCostAmt) {
		this.difActCostAmt = difActCostAmt;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setCoaCostSrcCd(JSPUtil.getParameter(request, prefix + "coa_cost_src_cd", ""));
		setFCostTypeEv(JSPUtil.getParameter(request, prefix + "f_cost_type_ev", ""));
		setPreActCostAmt(JSPUtil.getParameter(request, prefix + "pre_act_cost_amt", ""));
		setFRhqCd(JSPUtil.getParameter(request, prefix + "f_rhq_cd", ""));
		setDifCostAmt(JSPUtil.getParameter(request, prefix + "dif_cost_amt", ""));
		setEstmCostAmt(JSPUtil.getParameter(request, prefix + "estm_cost_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFCostTypeV(JSPUtil.getParameter(request, prefix + "f_cost_type_v", ""));
		setFCostTypeU(JSPUtil.getParameter(request, prefix + "f_cost_type_u", ""));
		setFrmRevYrmonFrom(JSPUtil.getParameter(request, prefix + "frm_rev_yrmon_from", ""));
		setCfmCostAmt(JSPUtil.getParameter(request, prefix + "cfm_cost_amt", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
		setFrmRevYrmonTo(JSPUtil.getParameter(request, prefix + "frm_rev_yrmon_to", ""));
		setFCostTypeM(JSPUtil.getParameter(request, prefix + "f_cost_type_m", ""));
		setBindSubOfcCd(JSPUtil.getParameter(request, prefix + "bind_sub_ofc_cd", ""));
		setFCostTypeFv(JSPUtil.getParameter(request, prefix + "f_cost_type_fv", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setFCostTypeF(JSPUtil.getParameter(request, prefix + "f_cost_type_f", ""));
		setExeYrmon(JSPUtil.getParameter(request, prefix + "exe_yrmon", ""));
		setN2ndNodCd(JSPUtil.getParameter(request, prefix + "n2nd_nod_cd", ""));
		setSubOfcCd(JSPUtil.getParameter(request, prefix + "sub_ofc_cd", ""));
		setFCostTypeC(JSPUtil.getParameter(request, prefix + "f_cost_type_c", ""));
		setMnCostTpNm(JSPUtil.getParameter(request, prefix + "mn_cost_tp_nm", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd", ""));
		setPstActCostAmt(JSPUtil.getParameter(request, prefix + "pst_act_cost_amt", ""));
		setFSubOfcCd(JSPUtil.getParameter(request, prefix + "f_sub_ofc_cd", ""));
		setSubCostTpNm(JSPUtil.getParameter(request, prefix + "sub_cost_tp_nm", ""));
		setFCtrlOfcCd(JSPUtil.getParameter(request, prefix + "f_ctrl_ofc_cd", ""));
		setN4thNodCd(JSPUtil.getParameter(request, prefix + "n4th_nod_cd", ""));
		setAdjAcclCostAmt(JSPUtil.getParameter(request, prefix + "adj_accl_cost_amt", ""));
		setActCostRatio(JSPUtil.getParameter(request, prefix + "act_cost_ratio", ""));
		setN1stNodCd(JSPUtil.getParameter(request, prefix + "n1st_nod_cd", ""));
		setFReport(JSPUtil.getParameter(request, prefix + "f_report", ""));
		setBindOfcCd(JSPUtil.getParameter(request, prefix + "bind_ofc_cd", ""));
		setDifActCostAmt(JSPUtil.getParameter(request, prefix + "dif_act_cost_amt", ""));
		setActCostAmt(JSPUtil.getParameter(request, prefix + "act_cost_amt", ""));
		setN3rdNodCd(JSPUtil.getParameter(request, prefix + "n3rd_nod_cd", ""));
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
			String[] coaCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "coa_cost_src_cd", length));
			String[] fCostTypeEv = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_ev", length));
			String[] preActCostAmt = (JSPUtil.getParameter(request, prefix	+ "pre_act_cost_amt", length));
			String[] fRhqCd = (JSPUtil.getParameter(request, prefix	+ "f_rhq_cd", length));
			String[] difCostAmt = (JSPUtil.getParameter(request, prefix	+ "dif_cost_amt", length));
			String[] estmCostAmt = (JSPUtil.getParameter(request, prefix	+ "estm_cost_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fCostTypeV = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_v", length));
			String[] fCostTypeU = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_u", length));
			String[] frmRevYrmonFrom = (JSPUtil.getParameter(request, prefix	+ "frm_rev_yrmon_from", length));
			String[] cfmCostAmt = (JSPUtil.getParameter(request, prefix	+ "cfm_cost_amt", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] frmRevYrmonTo = (JSPUtil.getParameter(request, prefix	+ "frm_rev_yrmon_to", length));
			String[] fCostTypeM = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_m", length));
			String[] bindSubOfcCd = (JSPUtil.getParameter(request, prefix	+ "bind_sub_ofc_cd", length));
			String[] fCostTypeFv = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_fv", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] fCostTypeF = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_f", length));
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
			String[] n2ndNodCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_nod_cd", length));
			String[] subOfcCd = (JSPUtil.getParameter(request, prefix	+ "sub_ofc_cd", length));
			String[] fCostTypeC = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_c", length));
			String[] mnCostTpNm = (JSPUtil.getParameter(request, prefix	+ "mn_cost_tp_nm", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] pstActCostAmt = (JSPUtil.getParameter(request, prefix	+ "pst_act_cost_amt", length));
			String[] fSubOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_sub_ofc_cd", length));
			String[] subCostTpNm = (JSPUtil.getParameter(request, prefix	+ "sub_cost_tp_nm", length));
			String[] fCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_ctrl_ofc_cd", length));
			String[] n4thNodCd = (JSPUtil.getParameter(request, prefix	+ "n4th_nod_cd", length));
			String[] adjAcclCostAmt = (JSPUtil.getParameter(request, prefix	+ "adj_accl_cost_amt", length));
			String[] actCostRatio = (JSPUtil.getParameter(request, prefix	+ "act_cost_ratio", length));
			String[] n1stNodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_nod_cd", length));
			String[] fReport = (JSPUtil.getParameter(request, prefix	+ "f_report", length));
			String[] bindOfcCd = (JSPUtil.getParameter(request, prefix	+ "bind_ofc_cd", length));
			String[] difActCostAmt = (JSPUtil.getParameter(request, prefix	+ "dif_act_cost_amt", length));
			String[] actCostAmt = (JSPUtil.getParameter(request, prefix	+ "act_cost_amt", length));
			String[] n3rdNodCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_nod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAccrualBatchResultOfficeListVO();
				if (coaCostSrcCd[i] != null)
					model.setCoaCostSrcCd(coaCostSrcCd[i]);
				if (fCostTypeEv[i] != null)
					model.setFCostTypeEv(fCostTypeEv[i]);
				if (preActCostAmt[i] != null)
					model.setPreActCostAmt(preActCostAmt[i]);
				if (fRhqCd[i] != null)
					model.setFRhqCd(fRhqCd[i]);
				if (difCostAmt[i] != null)
					model.setDifCostAmt(difCostAmt[i]);
				if (estmCostAmt[i] != null)
					model.setEstmCostAmt(estmCostAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fCostTypeV[i] != null)
					model.setFCostTypeV(fCostTypeV[i]);
				if (fCostTypeU[i] != null)
					model.setFCostTypeU(fCostTypeU[i]);
				if (frmRevYrmonFrom[i] != null)
					model.setFrmRevYrmonFrom(frmRevYrmonFrom[i]);
				if (cfmCostAmt[i] != null)
					model.setCfmCostAmt(cfmCostAmt[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (frmRevYrmonTo[i] != null)
					model.setFrmRevYrmonTo(frmRevYrmonTo[i]);
				if (fCostTypeM[i] != null)
					model.setFCostTypeM(fCostTypeM[i]);
				if (bindSubOfcCd[i] != null)
					model.setBindSubOfcCd(bindSubOfcCd[i]);
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
				if (n2ndNodCd[i] != null)
					model.setN2ndNodCd(n2ndNodCd[i]);
				if (subOfcCd[i] != null)
					model.setSubOfcCd(subOfcCd[i]);
				if (fCostTypeC[i] != null)
					model.setFCostTypeC(fCostTypeC[i]);
				if (mnCostTpNm[i] != null)
					model.setMnCostTpNm(mnCostTpNm[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (pstActCostAmt[i] != null)
					model.setPstActCostAmt(pstActCostAmt[i]);
				if (fSubOfcCd[i] != null)
					model.setFSubOfcCd(fSubOfcCd[i]);
				if (subCostTpNm[i] != null)
					model.setSubCostTpNm(subCostTpNm[i]);
				if (fCtrlOfcCd[i] != null)
					model.setFCtrlOfcCd(fCtrlOfcCd[i]);
				if (n4thNodCd[i] != null)
					model.setN4thNodCd(n4thNodCd[i]);
				if (adjAcclCostAmt[i] != null)
					model.setAdjAcclCostAmt(adjAcclCostAmt[i]);
				if (actCostRatio[i] != null)
					model.setActCostRatio(actCostRatio[i]);
				if (n1stNodCd[i] != null)
					model.setN1stNodCd(n1stNodCd[i]);
				if (fReport[i] != null)
					model.setFReport(fReport[i]);
				if (bindOfcCd[i] != null)
					model.setBindOfcCd(bindOfcCd[i]);
				if (difActCostAmt[i] != null)
					model.setDifActCostAmt(difActCostAmt[i]);
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
		this.coaCostSrcCd = this.coaCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostTypeEv = this.fCostTypeEv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preActCostAmt = this.preActCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRhqCd = this.fRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.difCostAmt = this.difCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCostAmt = this.estmCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostTypeV = this.fCostTypeV .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostTypeU = this.fCostTypeU .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRevYrmonFrom = this.frmRevYrmonFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmCostAmt = this.cfmCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRevYrmonTo = this.frmRevYrmonTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostTypeM = this.fCostTypeM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bindSubOfcCd = this.bindSubOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostTypeFv = this.fCostTypeFv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostTypeF = this.fCostTypeF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndNodCd = this.n2ndNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subOfcCd = this.subOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostTypeC = this.fCostTypeC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnCostTpNm = this.mnCostTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstActCostAmt = this.pstActCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSubOfcCd = this.fSubOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subCostTpNm = this.subCostTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCtrlOfcCd = this.fCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thNodCd = this.n4thNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjAcclCostAmt = this.adjAcclCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostRatio = this.actCostRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stNodCd = this.n1stNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fReport = this.fReport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bindOfcCd = this.bindOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.difActCostAmt = this.difActCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostAmt = this.actCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdNodCd = this.n3rdNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
