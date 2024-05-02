/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchActualCostCSRMonitoringListVO.java
*@FileTitle : SearchActualCostCSRMonitoringListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.09.02 Jeon Jae Hong 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo;

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
 * @author Jeon Jae Hong
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchActualCostCSRMonitoringListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchActualCostCSRMonitoringListVO> models = new ArrayList<SearchActualCostCSRMonitoringListVO>();
	
	/* Column Info */
	private String alocCntrAmt = null;
	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String estmN3rdNodCd = null;
	/* Column Info */
	private String alocCntrQty = null;
	/* Column Info */
	private String invRvvd = null;
	/* Column Info */
	private String frmSrcCtnt = null;
	/* Column Info */
	private String estmCostActGrpCd = null;
	/* Column Info */
	private String invSysId = null;
	/* Column Info */
	private String estmN4thNodCd = null;
	/* Column Info */
	private String actMapgRsltCd = null;
	/* Column Info */
	private String estmCostAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String estmCntrTpszCd = null;
	/* Column Info */
	private String invCostActGrpCd = null;
	/* Column Info */
	private String frmOptStDt = null;
	/* Column Info */
	private String estmCoaCostSrcCd = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String estmCostActGrpSeq = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String frmOptEndDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String estmN1stNodCd = null;
	/* Column Info */
	private String frmRsltCd = null;
	/* Column Info */
	private String dtDiv = null;
	/* Column Info */
	private String frmCsrNo = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String invCostActGrpSeq = null;
	/* Column Info */
	private String estmN2ndNodCd = null;
	/* Column Info */
	private String invCostAmt = null;
	/* Column Info */
	private String invCntrTpszCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String invN1stNodCd = null;
	/* Column Info */
	private String invN4thNodCd = null;
	/* Column Info */
	private String estmRvvd = null;
	/* Column Info */
	private String frmInvOfcCd = null;
	/* Column Info */
	private String invCoaCostSrcCd = null;
	/* Column Info */
	private String invN2ndNodCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String invN3rdNodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchActualCostCSRMonitoringListVO() {}

	public SearchActualCostCSRMonitoringListVO(String ibflag, String pagerows, String invSysId, String invOfcCd, String csrNo, String invNo, String ifDt, String glDt, String revYrmon, String invRvvd, String estmRvvd, String booking, String cntrNo, String invCntrTpszCd, String estmCntrTpszCd, String invCostActGrpCd, String estmCostActGrpCd, String invCostActGrpSeq, String estmCostActGrpSeq, String invCoaCostSrcCd, String estmCoaCostSrcCd, String invN1stNodCd, String estmN1stNodCd, String invN2ndNodCd, String estmN2ndNodCd, String invN3rdNodCd, String estmN3rdNodCd, String invN4thNodCd, String estmN4thNodCd, String invCostAmt, String estmCostAmt, String alocCntrQty, String alocCntrAmt, String actMapgRsltCd, String frmInvOfcCd, String frmSrcCtnt, String frmCsrNo, String frmOptStDt, String frmOptEndDt, String dtDiv, String frmRsltCd) {
		this.alocCntrAmt = alocCntrAmt;
		this.ifDt = ifDt;
		this.glDt = glDt;
		this.estmN3rdNodCd = estmN3rdNodCd;
		this.alocCntrQty = alocCntrQty;
		this.invRvvd = invRvvd;
		this.frmSrcCtnt = frmSrcCtnt;
		this.estmCostActGrpCd = estmCostActGrpCd;
		this.invSysId = invSysId;
		this.estmN4thNodCd = estmN4thNodCd;
		this.actMapgRsltCd = actMapgRsltCd;
		this.estmCostAmt = estmCostAmt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.estmCntrTpszCd = estmCntrTpszCd;
		this.invCostActGrpCd = invCostActGrpCd;
		this.frmOptStDt = frmOptStDt;
		this.estmCoaCostSrcCd = estmCoaCostSrcCd;
		this.invOfcCd = invOfcCd;
		this.estmCostActGrpSeq = estmCostActGrpSeq;
		this.csrNo = csrNo;
		this.frmOptEndDt = frmOptEndDt;
		this.bkgNo = bkgNo;
		this.estmN1stNodCd = estmN1stNodCd;
		this.frmRsltCd = frmRsltCd;
		this.dtDiv = dtDiv;
		this.frmCsrNo = frmCsrNo;
		this.revYrmon = revYrmon;
		this.invCostActGrpSeq = invCostActGrpSeq;
		this.estmN2ndNodCd = estmN2ndNodCd;
		this.invCostAmt = invCostAmt;
		this.invCntrTpszCd = invCntrTpszCd;
		this.invNo = invNo;
		this.invN1stNodCd = invN1stNodCd;
		this.invN4thNodCd = invN4thNodCd;
		this.estmRvvd = estmRvvd;
		this.frmInvOfcCd = frmInvOfcCd;
		this.invCoaCostSrcCd = invCoaCostSrcCd;
		this.invN2ndNodCd = invN2ndNodCd;
		this.cntrNo = cntrNo;
		this.invN3rdNodCd = invN3rdNodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("aloc_cntr_amt", getAlocCntrAmt());
		this.hashColumns.put("if_dt", getIfDt());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("estm_n3rd_nod_cd", getEstmN3rdNodCd());
		this.hashColumns.put("aloc_cntr_qty", getAlocCntrQty());
		this.hashColumns.put("inv_rvvd", getInvRvvd());
		this.hashColumns.put("frm_src_ctnt", getFrmSrcCtnt());
		this.hashColumns.put("estm_cost_act_grp_cd", getEstmCostActGrpCd());
		this.hashColumns.put("inv_sys_id", getInvSysId());
		this.hashColumns.put("estm_n4th_nod_cd", getEstmN4thNodCd());
		this.hashColumns.put("act_mapg_rslt_cd", getActMapgRsltCd());
		this.hashColumns.put("estm_cost_amt", getEstmCostAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("estm_cntr_tpsz_cd", getEstmCntrTpszCd());
		this.hashColumns.put("inv_cost_act_grp_cd", getInvCostActGrpCd());
		this.hashColumns.put("frm_opt_st_dt", getFrmOptStDt());
		this.hashColumns.put("estm_coa_cost_src_cd", getEstmCoaCostSrcCd());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("estm_cost_act_grp_seq", getEstmCostActGrpSeq());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("frm_opt_end_dt", getFrmOptEndDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("estm_n1st_nod_cd", getEstmN1stNodCd());
		this.hashColumns.put("frm_rslt_cd", getFrmRsltCd());
		this.hashColumns.put("dt_div", getDtDiv());
		this.hashColumns.put("frm_csr_no", getFrmCsrNo());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("inv_cost_act_grp_seq", getInvCostActGrpSeq());
		this.hashColumns.put("estm_n2nd_nod_cd", getEstmN2ndNodCd());
		this.hashColumns.put("inv_cost_amt", getInvCostAmt());
		this.hashColumns.put("inv_cntr_tpsz_cd", getInvCntrTpszCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("inv_n1st_nod_cd", getInvN1stNodCd());
		this.hashColumns.put("inv_n4th_nod_cd", getInvN4thNodCd());
		this.hashColumns.put("estm_rvvd", getEstmRvvd());
		this.hashColumns.put("frm_inv_ofc_cd", getFrmInvOfcCd());
		this.hashColumns.put("inv_coa_cost_src_cd", getInvCoaCostSrcCd());
		this.hashColumns.put("inv_n2nd_nod_cd", getInvN2ndNodCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("inv_n3rd_nod_cd", getInvN3rdNodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("aloc_cntr_amt", "alocCntrAmt");
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("estm_n3rd_nod_cd", "estmN3rdNodCd");
		this.hashFields.put("aloc_cntr_qty", "alocCntrQty");
		this.hashFields.put("inv_rvvd", "invRvvd");
		this.hashFields.put("frm_src_ctnt", "frmSrcCtnt");
		this.hashFields.put("estm_cost_act_grp_cd", "estmCostActGrpCd");
		this.hashFields.put("inv_sys_id", "invSysId");
		this.hashFields.put("estm_n4th_nod_cd", "estmN4thNodCd");
		this.hashFields.put("act_mapg_rslt_cd", "actMapgRsltCd");
		this.hashFields.put("estm_cost_amt", "estmCostAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("estm_cntr_tpsz_cd", "estmCntrTpszCd");
		this.hashFields.put("inv_cost_act_grp_cd", "invCostActGrpCd");
		this.hashFields.put("frm_opt_st_dt", "frmOptStDt");
		this.hashFields.put("estm_coa_cost_src_cd", "estmCoaCostSrcCd");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("estm_cost_act_grp_seq", "estmCostActGrpSeq");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("frm_opt_end_dt", "frmOptEndDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("estm_n1st_nod_cd", "estmN1stNodCd");
		this.hashFields.put("frm_rslt_cd", "frmRsltCd");
		this.hashFields.put("dt_div", "dtDiv");
		this.hashFields.put("frm_csr_no", "frmCsrNo");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("inv_cost_act_grp_seq", "invCostActGrpSeq");
		this.hashFields.put("estm_n2nd_nod_cd", "estmN2ndNodCd");
		this.hashFields.put("inv_cost_amt", "invCostAmt");
		this.hashFields.put("inv_cntr_tpsz_cd", "invCntrTpszCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("inv_n1st_nod_cd", "invN1stNodCd");
		this.hashFields.put("inv_n4th_nod_cd", "invN4thNodCd");
		this.hashFields.put("estm_rvvd", "estmRvvd");
		this.hashFields.put("frm_inv_ofc_cd", "frmInvOfcCd");
		this.hashFields.put("inv_coa_cost_src_cd", "invCoaCostSrcCd");
		this.hashFields.put("inv_n2nd_nod_cd", "invN2ndNodCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("inv_n3rd_nod_cd", "invN3rdNodCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return alocCntrAmt
	 */
	public String getAlocCntrAmt() {
		return this.alocCntrAmt;
	}
	
	/**
	 * Column Info
	 * @return ifDt
	 */
	public String getIfDt() {
		return this.ifDt;
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
	 * @return estmN3rdNodCd
	 */
	public String getEstmN3rdNodCd() {
		return this.estmN3rdNodCd;
	}
	
	/**
	 * Column Info
	 * @return alocCntrQty
	 */
	public String getAlocCntrQty() {
		return this.alocCntrQty;
	}
	
	/**
	 * Column Info
	 * @return invRvvd
	 */
	public String getInvRvvd() {
		return this.invRvvd;
	}
	
	/**
	 * Column Info
	 * @return frmSrcCtnt
	 */
	public String getFrmSrcCtnt() {
		return this.frmSrcCtnt;
	}
	
	/**
	 * Column Info
	 * @return estmCostActGrpCd
	 */
	public String getEstmCostActGrpCd() {
		return this.estmCostActGrpCd;
	}
	
	/**
	 * Column Info
	 * @return invSysId
	 */
	public String getInvSysId() {
		return this.invSysId;
	}
	
	/**
	 * Column Info
	 * @return estmN4thNodCd
	 */
	public String getEstmN4thNodCd() {
		return this.estmN4thNodCd;
	}
	
	/**
	 * Column Info
	 * @return actMapgRsltCd
	 */
	public String getActMapgRsltCd() {
		return this.actMapgRsltCd;
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
	 * @return estmCntrTpszCd
	 */
	public String getEstmCntrTpszCd() {
		return this.estmCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return invCostActGrpCd
	 */
	public String getInvCostActGrpCd() {
		return this.invCostActGrpCd;
	}
	
	/**
	 * Column Info
	 * @return frmOptStDt
	 */
	public String getFrmOptStDt() {
		return this.frmOptStDt;
	}
	
	/**
	 * Column Info
	 * @return estmCoaCostSrcCd
	 */
	public String getEstmCoaCostSrcCd() {
		return this.estmCoaCostSrcCd;
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
	 * @return estmCostActGrpSeq
	 */
	public String getEstmCostActGrpSeq() {
		return this.estmCostActGrpSeq;
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
	 * @return frmOptEndDt
	 */
	public String getFrmOptEndDt() {
		return this.frmOptEndDt;
	}
	
	/**
	 * Column Info
	 * @return booking
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return estmN1stNodCd
	 */
	public String getEstmN1stNodCd() {
		return this.estmN1stNodCd;
	}
	
	/**
	 * Column Info
	 * @return frmRsltCd
	 */
	public String getFrmRsltCd() {
		return this.frmRsltCd;
	}
	
	/**
	 * Column Info
	 * @return dtDiv
	 */
	public String getDtDiv() {
		return this.dtDiv;
	}
	
	/**
	 * Column Info
	 * @return frmCsrNo
	 */
	public String getFrmCsrNo() {
		return this.frmCsrNo;
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
	 * @return invCostActGrpSeq
	 */
	public String getInvCostActGrpSeq() {
		return this.invCostActGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return estmN2ndNodCd
	 */
	public String getEstmN2ndNodCd() {
		return this.estmN2ndNodCd;
	}
	
	/**
	 * Column Info
	 * @return invCostAmt
	 */
	public String getInvCostAmt() {
		return this.invCostAmt;
	}
	
	/**
	 * Column Info
	 * @return invCntrTpszCd
	 */
	public String getInvCntrTpszCd() {
		return this.invCntrTpszCd;
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
	 * @return invN1stNodCd
	 */
	public String getInvN1stNodCd() {
		return this.invN1stNodCd;
	}
	
	/**
	 * Column Info
	 * @return invN4thNodCd
	 */
	public String getInvN4thNodCd() {
		return this.invN4thNodCd;
	}
	
	/**
	 * Column Info
	 * @return estmRvvd
	 */
	public String getEstmRvvd() {
		return this.estmRvvd;
	}
	
	/**
	 * Column Info
	 * @return frmInvOfcCd
	 */
	public String getFrmInvOfcCd() {
		return this.frmInvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return invCoaCostSrcCd
	 */
	public String getInvCoaCostSrcCd() {
		return this.invCoaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @return invN2ndNodCd
	 */
	public String getInvN2ndNodCd() {
		return this.invN2ndNodCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return invN3rdNodCd
	 */
	public String getInvN3rdNodCd() {
		return this.invN3rdNodCd;
	}
	

	/**
	 * Column Info
	 * @param alocCntrAmt
	 */
	public void setAlocCntrAmt(String alocCntrAmt) {
		this.alocCntrAmt = alocCntrAmt;
	}
	
	/**
	 * Column Info
	 * @param ifDt
	 */
	public void setIfDt(String ifDt) {
		this.ifDt = ifDt;
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
	 * @param estmN3rdNodCd
	 */
	public void setEstmN3rdNodCd(String estmN3rdNodCd) {
		this.estmN3rdNodCd = estmN3rdNodCd;
	}
	
	/**
	 * Column Info
	 * @param alocCntrQty
	 */
	public void setAlocCntrQty(String alocCntrQty) {
		this.alocCntrQty = alocCntrQty;
	}
	
	/**
	 * Column Info
	 * @param invRvvd
	 */
	public void setInvRvvd(String invRvvd) {
		this.invRvvd = invRvvd;
	}
	
	/**
	 * Column Info
	 * @param frmSrcCtnt
	 */
	public void setFrmSrcCtnt(String frmSrcCtnt) {
		this.frmSrcCtnt = frmSrcCtnt;
	}
	
	/**
	 * Column Info
	 * @param estmCostActGrpCd
	 */
	public void setEstmCostActGrpCd(String estmCostActGrpCd) {
		this.estmCostActGrpCd = estmCostActGrpCd;
	}
	
	/**
	 * Column Info
	 * @param invSysId
	 */
	public void setInvSysId(String invSysId) {
		this.invSysId = invSysId;
	}
	
	/**
	 * Column Info
	 * @param estmN4thNodCd
	 */
	public void setEstmN4thNodCd(String estmN4thNodCd) {
		this.estmN4thNodCd = estmN4thNodCd;
	}
	
	/**
	 * Column Info
	 * @param actMapgRsltCd
	 */
	public void setActMapgRsltCd(String actMapgRsltCd) {
		this.actMapgRsltCd = actMapgRsltCd;
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
	 * @param estmCntrTpszCd
	 */
	public void setEstmCntrTpszCd(String estmCntrTpszCd) {
		this.estmCntrTpszCd = estmCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param invCostActGrpCd
	 */
	public void setInvCostActGrpCd(String invCostActGrpCd) {
		this.invCostActGrpCd = invCostActGrpCd;
	}
	
	/**
	 * Column Info
	 * @param frmOptStDt
	 */
	public void setFrmOptStDt(String frmOptStDt) {
		this.frmOptStDt = frmOptStDt;
	}
	
	/**
	 * Column Info
	 * @param estmCoaCostSrcCd
	 */
	public void setEstmCoaCostSrcCd(String estmCoaCostSrcCd) {
		this.estmCoaCostSrcCd = estmCoaCostSrcCd;
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
	 * @param estmCostActGrpSeq
	 */
	public void setEstmCostActGrpSeq(String estmCostActGrpSeq) {
		this.estmCostActGrpSeq = estmCostActGrpSeq;
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
	 * @param frmOptEndDt
	 */
	public void setFrmOptEndDt(String frmOptEndDt) {
		this.frmOptEndDt = frmOptEndDt;
	}
	
	/**
	 * Column Info
	 * @param booking
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param estmN1stNodCd
	 */
	public void setEstmN1stNodCd(String estmN1stNodCd) {
		this.estmN1stNodCd = estmN1stNodCd;
	}
	
	/**
	 * Column Info
	 * @param frmRsltCd
	 */
	public void setFrmRsltCd(String frmRsltCd) {
		this.frmRsltCd = frmRsltCd;
	}
	
	/**
	 * Column Info
	 * @param dtDiv
	 */
	public void setDtDiv(String dtDiv) {
		this.dtDiv = dtDiv;
	}
	
	/**
	 * Column Info
	 * @param frmCsrNo
	 */
	public void setFrmCsrNo(String frmCsrNo) {
		this.frmCsrNo = frmCsrNo;
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
	 * @param invCostActGrpSeq
	 */
	public void setInvCostActGrpSeq(String invCostActGrpSeq) {
		this.invCostActGrpSeq = invCostActGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param estmN2ndNodCd
	 */
	public void setEstmN2ndNodCd(String estmN2ndNodCd) {
		this.estmN2ndNodCd = estmN2ndNodCd;
	}
	
	/**
	 * Column Info
	 * @param invCostAmt
	 */
	public void setInvCostAmt(String invCostAmt) {
		this.invCostAmt = invCostAmt;
	}
	
	/**
	 * Column Info
	 * @param invCntrTpszCd
	 */
	public void setInvCntrTpszCd(String invCntrTpszCd) {
		this.invCntrTpszCd = invCntrTpszCd;
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
	 * @param invN1stNodCd
	 */
	public void setInvN1stNodCd(String invN1stNodCd) {
		this.invN1stNodCd = invN1stNodCd;
	}
	
	/**
	 * Column Info
	 * @param invN4thNodCd
	 */
	public void setInvN4thNodCd(String invN4thNodCd) {
		this.invN4thNodCd = invN4thNodCd;
	}
	
	/**
	 * Column Info
	 * @param estmRvvd
	 */
	public void setEstmRvvd(String estmRvvd) {
		this.estmRvvd = estmRvvd;
	}
	
	/**
	 * Column Info
	 * @param frmInvOfcCd
	 */
	public void setFrmInvOfcCd(String frmInvOfcCd) {
		this.frmInvOfcCd = frmInvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param invCoaCostSrcCd
	 */
	public void setInvCoaCostSrcCd(String invCoaCostSrcCd) {
		this.invCoaCostSrcCd = invCoaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @param invN2ndNodCd
	 */
	public void setInvN2ndNodCd(String invN2ndNodCd) {
		this.invN2ndNodCd = invN2ndNodCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param invN3rdNodCd
	 */
	public void setInvN3rdNodCd(String invN3rdNodCd) {
		this.invN3rdNodCd = invN3rdNodCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAlocCntrAmt(JSPUtil.getParameter(request, "aloc_cntr_amt", ""));
		setIfDt(JSPUtil.getParameter(request, "if_dt", ""));
		setGlDt(JSPUtil.getParameter(request, "gl_dt", ""));
		setEstmN3rdNodCd(JSPUtil.getParameter(request, "estm_n3rd_nod_cd", ""));
		setAlocCntrQty(JSPUtil.getParameter(request, "aloc_cntr_qty", ""));
		setInvRvvd(JSPUtil.getParameter(request, "inv_rvvd", ""));
		setFrmSrcCtnt(JSPUtil.getParameter(request, "frm_src_ctnt", ""));
		setEstmCostActGrpCd(JSPUtil.getParameter(request, "estm_cost_act_grp_cd", ""));
		setInvSysId(JSPUtil.getParameter(request, "inv_sys_id", ""));
		setEstmN4thNodCd(JSPUtil.getParameter(request, "estm_n4th_nod_cd", ""));
		setActMapgRsltCd(JSPUtil.getParameter(request, "act_mapg_rslt_cd", ""));
		setEstmCostAmt(JSPUtil.getParameter(request, "estm_cost_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEstmCntrTpszCd(JSPUtil.getParameter(request, "estm_cntr_tpsz_cd", ""));
		setInvCostActGrpCd(JSPUtil.getParameter(request, "inv_cost_act_grp_cd", ""));
		setFrmOptStDt(JSPUtil.getParameter(request, "frm_opt_st_dt", ""));
		setEstmCoaCostSrcCd(JSPUtil.getParameter(request, "estm_coa_cost_src_cd", ""));
		setInvOfcCd(JSPUtil.getParameter(request, "inv_ofc_cd", ""));
		setEstmCostActGrpSeq(JSPUtil.getParameter(request, "estm_cost_act_grp_seq", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setFrmOptEndDt(JSPUtil.getParameter(request, "frm_opt_end_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setEstmN1stNodCd(JSPUtil.getParameter(request, "estm_n1st_nod_cd", ""));
		setFrmRsltCd(JSPUtil.getParameter(request, "frm_rslt_cd", ""));
		setDtDiv(JSPUtil.getParameter(request, "dt_div", ""));
		setFrmCsrNo(JSPUtil.getParameter(request, "frm_csr_no", ""));
		setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));
		setInvCostActGrpSeq(JSPUtil.getParameter(request, "inv_cost_act_grp_seq", ""));
		setEstmN2ndNodCd(JSPUtil.getParameter(request, "estm_n2nd_nod_cd", ""));
		setInvCostAmt(JSPUtil.getParameter(request, "inv_cost_amt", ""));
		setInvCntrTpszCd(JSPUtil.getParameter(request, "inv_cntr_tpsz_cd", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setInvN1stNodCd(JSPUtil.getParameter(request, "inv_n1st_nod_cd", ""));
		setInvN4thNodCd(JSPUtil.getParameter(request, "inv_n4th_nod_cd", ""));
		setEstmRvvd(JSPUtil.getParameter(request, "estm_rvvd", ""));
		setFrmInvOfcCd(JSPUtil.getParameter(request, "frm_inv_ofc_cd", ""));
		setInvCoaCostSrcCd(JSPUtil.getParameter(request, "inv_coa_cost_src_cd", ""));
		setInvN2ndNodCd(JSPUtil.getParameter(request, "inv_n2nd_nod_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setInvN3rdNodCd(JSPUtil.getParameter(request, "inv_n3rd_nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchActualCostCSRMonitoringListVO[]
	 */
	public SearchActualCostCSRMonitoringListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchActualCostCSRMonitoringListVO[]
	 */
	public SearchActualCostCSRMonitoringListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchActualCostCSRMonitoringListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] alocCntrAmt = (JSPUtil.getParameter(request, prefix	+ "aloc_cntr_amt", length));
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] estmN3rdNodCd = (JSPUtil.getParameter(request, prefix	+ "estm_n3rd_nod_cd", length));
			String[] alocCntrQty = (JSPUtil.getParameter(request, prefix	+ "aloc_cntr_qty", length));
			String[] invRvvd = (JSPUtil.getParameter(request, prefix	+ "inv_rvvd", length));
			String[] frmSrcCtnt = (JSPUtil.getParameter(request, prefix	+ "frm_src_ctnt", length));
			String[] estmCostActGrpCd = (JSPUtil.getParameter(request, prefix	+ "estm_cost_act_grp_cd", length));
			String[] invSysId = (JSPUtil.getParameter(request, prefix	+ "inv_sys_id", length));
			String[] estmN4thNodCd = (JSPUtil.getParameter(request, prefix	+ "estm_n4th_nod_cd", length));
			String[] actMapgRsltCd = (JSPUtil.getParameter(request, prefix	+ "act_mapg_rslt_cd", length));
			String[] estmCostAmt = (JSPUtil.getParameter(request, prefix	+ "estm_cost_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] estmCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "estm_cntr_tpsz_cd", length));
			String[] invCostActGrpCd = (JSPUtil.getParameter(request, prefix	+ "inv_cost_act_grp_cd", length));
			String[] frmOptStDt = (JSPUtil.getParameter(request, prefix	+ "frm_opt_st_dt", length));
			String[] estmCoaCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "estm_coa_cost_src_cd", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] estmCostActGrpSeq = (JSPUtil.getParameter(request, prefix	+ "estm_cost_act_grp_seq", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] frmOptEndDt = (JSPUtil.getParameter(request, prefix	+ "frm_opt_end_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] estmN1stNodCd = (JSPUtil.getParameter(request, prefix	+ "estm_n1st_nod_cd", length));
			String[] frmRsltCd = (JSPUtil.getParameter(request, prefix	+ "frm_rslt_cd", length));
			String[] dtDiv = (JSPUtil.getParameter(request, prefix	+ "dt_div", length));
			String[] frmCsrNo = (JSPUtil.getParameter(request, prefix	+ "frm_csr_no", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] invCostActGrpSeq = (JSPUtil.getParameter(request, prefix	+ "inv_cost_act_grp_seq", length));
			String[] estmN2ndNodCd = (JSPUtil.getParameter(request, prefix	+ "estm_n2nd_nod_cd", length));
			String[] invCostAmt = (JSPUtil.getParameter(request, prefix	+ "inv_cost_amt", length));
			String[] invCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "inv_cntr_tpsz_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] invN1stNodCd = (JSPUtil.getParameter(request, prefix	+ "inv_n1st_nod_cd", length));
			String[] invN4thNodCd = (JSPUtil.getParameter(request, prefix	+ "inv_n4th_nod_cd", length));
			String[] estmRvvd = (JSPUtil.getParameter(request, prefix	+ "estm_rvvd", length));
			String[] frmInvOfcCd = (JSPUtil.getParameter(request, prefix	+ "frm_inv_ofc_cd", length));
			String[] invCoaCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "inv_coa_cost_src_cd", length));
			String[] invN2ndNodCd = (JSPUtil.getParameter(request, prefix	+ "inv_n2nd_nod_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] invN3rdNodCd = (JSPUtil.getParameter(request, prefix	+ "inv_n3rd_nod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchActualCostCSRMonitoringListVO();
				if (alocCntrAmt[i] != null)
					model.setAlocCntrAmt(alocCntrAmt[i]);
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (estmN3rdNodCd[i] != null)
					model.setEstmN3rdNodCd(estmN3rdNodCd[i]);
				if (alocCntrQty[i] != null)
					model.setAlocCntrQty(alocCntrQty[i]);
				if (invRvvd[i] != null)
					model.setInvRvvd(invRvvd[i]);
				if (frmSrcCtnt[i] != null)
					model.setFrmSrcCtnt(frmSrcCtnt[i]);
				if (estmCostActGrpCd[i] != null)
					model.setEstmCostActGrpCd(estmCostActGrpCd[i]);
				if (invSysId[i] != null)
					model.setInvSysId(invSysId[i]);
				if (estmN4thNodCd[i] != null)
					model.setEstmN4thNodCd(estmN4thNodCd[i]);
				if (actMapgRsltCd[i] != null)
					model.setActMapgRsltCd(actMapgRsltCd[i]);
				if (estmCostAmt[i] != null)
					model.setEstmCostAmt(estmCostAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (estmCntrTpszCd[i] != null)
					model.setEstmCntrTpszCd(estmCntrTpszCd[i]);
				if (invCostActGrpCd[i] != null)
					model.setInvCostActGrpCd(invCostActGrpCd[i]);
				if (frmOptStDt[i] != null)
					model.setFrmOptStDt(frmOptStDt[i]);
				if (estmCoaCostSrcCd[i] != null)
					model.setEstmCoaCostSrcCd(estmCoaCostSrcCd[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (estmCostActGrpSeq[i] != null)
					model.setEstmCostActGrpSeq(estmCostActGrpSeq[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (frmOptEndDt[i] != null)
					model.setFrmOptEndDt(frmOptEndDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (estmN1stNodCd[i] != null)
					model.setEstmN1stNodCd(estmN1stNodCd[i]);
				if (frmRsltCd[i] != null)
					model.setFrmRsltCd(frmRsltCd[i]);
				if (dtDiv[i] != null)
					model.setDtDiv(dtDiv[i]);
				if (frmCsrNo[i] != null)
					model.setFrmCsrNo(frmCsrNo[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (invCostActGrpSeq[i] != null)
					model.setInvCostActGrpSeq(invCostActGrpSeq[i]);
				if (estmN2ndNodCd[i] != null)
					model.setEstmN2ndNodCd(estmN2ndNodCd[i]);
				if (invCostAmt[i] != null)
					model.setInvCostAmt(invCostAmt[i]);
				if (invCntrTpszCd[i] != null)
					model.setInvCntrTpszCd(invCntrTpszCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (invN1stNodCd[i] != null)
					model.setInvN1stNodCd(invN1stNodCd[i]);
				if (invN4thNodCd[i] != null)
					model.setInvN4thNodCd(invN4thNodCd[i]);
				if (estmRvvd[i] != null)
					model.setEstmRvvd(estmRvvd[i]);
				if (frmInvOfcCd[i] != null)
					model.setFrmInvOfcCd(frmInvOfcCd[i]);
				if (invCoaCostSrcCd[i] != null)
					model.setInvCoaCostSrcCd(invCoaCostSrcCd[i]);
				if (invN2ndNodCd[i] != null)
					model.setInvN2ndNodCd(invN2ndNodCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (invN3rdNodCd[i] != null)
					model.setInvN3rdNodCd(invN3rdNodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchActualCostCSRMonitoringListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchActualCostCSRMonitoringListVO[]
	 */
	public SearchActualCostCSRMonitoringListVO[] getSearchActualCostCSRMonitoringListVOs(){
		SearchActualCostCSRMonitoringListVO[] vos = (SearchActualCostCSRMonitoringListVO[])models.toArray(new SearchActualCostCSRMonitoringListVO[models.size()]);
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
		this.alocCntrAmt = this.alocCntrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifDt = this.ifDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmN3rdNodCd = this.estmN3rdNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocCntrQty = this.alocCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRvvd = this.invRvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmSrcCtnt = this.frmSrcCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCostActGrpCd = this.estmCostActGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSysId = this.invSysId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmN4thNodCd = this.estmN4thNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actMapgRsltCd = this.actMapgRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCostAmt = this.estmCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCntrTpszCd = this.estmCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCostActGrpCd = this.invCostActGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmOptStDt = this.frmOptStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCoaCostSrcCd = this.estmCoaCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCostActGrpSeq = this.estmCostActGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmOptEndDt = this.frmOptEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmN1stNodCd = this.estmN1stNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRsltCd = this.frmRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtDiv = this.dtDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCsrNo = this.frmCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCostActGrpSeq = this.invCostActGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmN2ndNodCd = this.estmN2ndNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCostAmt = this.invCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCntrTpszCd = this.invCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invN1stNodCd = this.invN1stNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invN4thNodCd = this.invN4thNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmRvvd = this.estmRvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmInvOfcCd = this.frmInvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCoaCostSrcCd = this.invCoaCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invN2ndNodCd = this.invN2ndNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invN3rdNodCd = this.invN3rdNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
