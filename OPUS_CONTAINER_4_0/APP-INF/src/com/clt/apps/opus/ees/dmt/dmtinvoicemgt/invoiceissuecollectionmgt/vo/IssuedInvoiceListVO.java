/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : IssuedInvoiceListVO.java
*@FileTitle : IssuedInvoiceListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.27  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IssuedInvoiceListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IssuedInvoiceListVO> models = new ArrayList<IssuedInvoiceListVO>();
	
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String invPrtFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String issueId = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String bilAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chgCurrCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dcAmt = null;
	/* Column Info */
	private String taxAmt = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String dmdtExptAmt = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String actPayrCd = null;
	/* Column Info */
	private String arIfDt = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String crInvNo = null;
	/* Column Info */
	private String actPayrNm = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String arIfUsrNm = null;
	/* Column Info */
	private String issueNm = null;
	/* Column Info */
	private String invOver = null;
	/* Column Info */
	private String ctrtOfc = null;
	/* Column Info */
	private String dmdtInvStsCd = null;
	/* Column Info */
	private String invChgAmt = null;
	/* Column Info */
	private String dmdtInvNo = null;
	/* Column Info */
	private String actDeltFlg = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String arIfOfcCd = null;
	/* Column Info */
	private String arIfUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String dmdtArIfCd = null;
	/* Column Info */
	private String orgChgAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IssuedInvoiceListVO() {}

	public IssuedInvoiceListVO(String ibflag, String pagerows, String dmdtInvNo, String invPrtFlg, String dmdtArIfCd, String dmdtInvStsCd, String dmdtTrfCd, String bkgNo, String blNo, String cntrNo, String scNo, String rfaNo, String chgCurrCd, String orgChgAmt, String dmdtExptAmt, String dcAmt, String bilAmt, String invCurrCd, String invChgAmt, String taxAmt, String invAmt, String port, String creDt, String creOfcCd, String issueId, String issueNm, String arIfDt, String arIfOfcCd, String arIfUsrId, String arIfUsrNm, String invOver, String actPayrCd, String actPayrNm, String crInvNo, String ctrtOfc, String actDeltFlg, String arIfNo) {
		this.port = port;
		this.invPrtFlg = invPrtFlg;
		this.creDt = creDt;
		this.issueId = issueId;
		this.blNo = blNo;
		this.bilAmt = bilAmt;
		this.pagerows = pagerows;
		this.chgCurrCd = chgCurrCd;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.dcAmt = dcAmt;
		this.taxAmt = taxAmt;
		this.arIfNo = arIfNo;
		this.scNo = scNo;
		this.dmdtExptAmt = dmdtExptAmt;
		this.creOfcCd = creOfcCd;
		this.actPayrCd = actPayrCd;
		this.arIfDt = arIfDt;
		this.invAmt = invAmt;
		this.crInvNo = crInvNo;
		this.actPayrNm = actPayrNm;
		this.dmdtTrfCd = dmdtTrfCd;
		this.arIfUsrNm = arIfUsrNm;
		this.issueNm = issueNm;
		this.invOver = invOver;
		this.ctrtOfc = ctrtOfc;
		this.dmdtInvStsCd = dmdtInvStsCd;
		this.invChgAmt = invChgAmt;
		this.dmdtInvNo = dmdtInvNo;
		this.actDeltFlg = actDeltFlg;
		this.invCurrCd = invCurrCd;
		this.arIfOfcCd = arIfOfcCd;
		this.arIfUsrId = arIfUsrId;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.dmdtArIfCd = dmdtArIfCd;
		this.orgChgAmt = orgChgAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("inv_prt_flg", getInvPrtFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("issue_id", getIssueId());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bil_amt", getBilAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chg_curr_cd", getChgCurrCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dc_amt", getDcAmt());
		this.hashColumns.put("tax_amt", getTaxAmt());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("dmdt_expt_amt", getDmdtExptAmt());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("act_payr_cd", getActPayrCd());
		this.hashColumns.put("ar_if_dt", getArIfDt());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("cr_inv_no", getCrInvNo());
		this.hashColumns.put("act_payr_nm", getActPayrNm());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("ar_if_usr_nm", getArIfUsrNm());
		this.hashColumns.put("issue_nm", getIssueNm());
		this.hashColumns.put("inv_over", getInvOver());
		this.hashColumns.put("ctrt_ofc", getCtrtOfc());
		this.hashColumns.put("dmdt_inv_sts_cd", getDmdtInvStsCd());
		this.hashColumns.put("inv_chg_amt", getInvChgAmt());
		this.hashColumns.put("dmdt_inv_no", getDmdtInvNo());
		this.hashColumns.put("act_delt_flg", getActDeltFlg());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("ar_if_ofc_cd", getArIfOfcCd());
		this.hashColumns.put("ar_if_usr_id", getArIfUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("dmdt_ar_if_cd", getDmdtArIfCd());
		this.hashColumns.put("org_chg_amt", getOrgChgAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port", "port");
		this.hashFields.put("inv_prt_flg", "invPrtFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("issue_id", "issueId");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bil_amt", "bilAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chg_curr_cd", "chgCurrCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dc_amt", "dcAmt");
		this.hashFields.put("tax_amt", "taxAmt");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("dmdt_expt_amt", "dmdtExptAmt");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("act_payr_cd", "actPayrCd");
		this.hashFields.put("ar_if_dt", "arIfDt");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("cr_inv_no", "crInvNo");
		this.hashFields.put("act_payr_nm", "actPayrNm");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("ar_if_usr_nm", "arIfUsrNm");
		this.hashFields.put("issue_nm", "issueNm");
		this.hashFields.put("inv_over", "invOver");
		this.hashFields.put("ctrt_ofc", "ctrtOfc");
		this.hashFields.put("dmdt_inv_sts_cd", "dmdtInvStsCd");
		this.hashFields.put("inv_chg_amt", "invChgAmt");
		this.hashFields.put("dmdt_inv_no", "dmdtInvNo");
		this.hashFields.put("act_delt_flg", "actDeltFlg");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("ar_if_ofc_cd", "arIfOfcCd");
		this.hashFields.put("ar_if_usr_id", "arIfUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("dmdt_ar_if_cd", "dmdtArIfCd");
		this.hashFields.put("org_chg_amt", "orgChgAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return invPrtFlg
	 */
	public String getInvPrtFlg() {
		return this.invPrtFlg;
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
	 * @return issueId
	 */
	public String getIssueId() {
		return this.issueId;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return bilAmt
	 */
	public String getBilAmt() {
		return this.bilAmt;
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
	 * @return chgCurrCd
	 */
	public String getChgCurrCd() {
		return this.chgCurrCd;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return dcAmt
	 */
	public String getDcAmt() {
		return this.dcAmt;
	}
	
	/**
	 * Column Info
	 * @return taxAmt
	 */
	public String getTaxAmt() {
		return this.taxAmt;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return dmdtExptAmt
	 */
	public String getDmdtExptAmt() {
		return this.dmdtExptAmt;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return actPayrCd
	 */
	public String getActPayrCd() {
		return this.actPayrCd;
	}
	
	/**
	 * Column Info
	 * @return arIfDt
	 */
	public String getArIfDt() {
		return this.arIfDt;
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
	 * @return crInvNo
	 */
	public String getCrInvNo() {
		return this.crInvNo;
	}
	
	/**
	 * Column Info
	 * @return actPayrNm
	 */
	public String getActPayrNm() {
		return this.actPayrNm;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return arIfUsrNm
	 */
	public String getArIfUsrNm() {
		return this.arIfUsrNm;
	}
	
	/**
	 * Column Info
	 * @return issueNm
	 */
	public String getIssueNm() {
		return this.issueNm;
	}
	
	/**
	 * Column Info
	 * @return invOver
	 */
	public String getInvOver() {
		return this.invOver;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfc
	 */
	public String getCtrtOfc() {
		return this.ctrtOfc;
	}
	
	/**
	 * Column Info
	 * @return dmdtInvStsCd
	 */
	public String getDmdtInvStsCd() {
		return this.dmdtInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return invChgAmt
	 */
	public String getInvChgAmt() {
		return this.invChgAmt;
	}
	
	/**
	 * Column Info
	 * @return dmdtInvNo
	 */
	public String getDmdtInvNo() {
		return this.dmdtInvNo;
	}
	
	/**
	 * Column Info
	 * @return actDeltFlg
	 */
	public String getActDeltFlg() {
		return this.actDeltFlg;
	}
	
	/**
	 * Column Info
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
	}
	
	/**
	 * Column Info
	 * @return arIfOfcCd
	 */
	public String getArIfOfcCd() {
		return this.arIfOfcCd;
	}
	
	/**
	 * Column Info
	 * @return arIfUsrId
	 */
	public String getArIfUsrId() {
		return this.arIfUsrId;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return dmdtArIfCd
	 */
	public String getDmdtArIfCd() {
		return this.dmdtArIfCd;
	}
	
	/**
	 * Column Info
	 * @return orgChgAmt
	 */
	public String getOrgChgAmt() {
		return this.orgChgAmt;
	}
	

	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param invPrtFlg
	 */
	public void setInvPrtFlg(String invPrtFlg) {
		this.invPrtFlg = invPrtFlg;
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
	 * @param issueId
	 */
	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param bilAmt
	 */
	public void setBilAmt(String bilAmt) {
		this.bilAmt = bilAmt;
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
	 * @param chgCurrCd
	 */
	public void setChgCurrCd(String chgCurrCd) {
		this.chgCurrCd = chgCurrCd;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param dcAmt
	 */
	public void setDcAmt(String dcAmt) {
		this.dcAmt = dcAmt;
	}
	
	/**
	 * Column Info
	 * @param taxAmt
	 */
	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param dmdtExptAmt
	 */
	public void setDmdtExptAmt(String dmdtExptAmt) {
		this.dmdtExptAmt = dmdtExptAmt;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param actPayrCd
	 */
	public void setActPayrCd(String actPayrCd) {
		this.actPayrCd = actPayrCd;
	}
	
	/**
	 * Column Info
	 * @param arIfDt
	 */
	public void setArIfDt(String arIfDt) {
		this.arIfDt = arIfDt;
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
	 * @param crInvNo
	 */
	public void setCrInvNo(String crInvNo) {
		this.crInvNo = crInvNo;
	}
	
	/**
	 * Column Info
	 * @param actPayrNm
	 */
	public void setActPayrNm(String actPayrNm) {
		this.actPayrNm = actPayrNm;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param arIfUsrNm
	 */
	public void setArIfUsrNm(String arIfUsrNm) {
		this.arIfUsrNm = arIfUsrNm;
	}
	
	/**
	 * Column Info
	 * @param issueNm
	 */
	public void setIssueNm(String issueNm) {
		this.issueNm = issueNm;
	}
	
	/**
	 * Column Info
	 * @param invOver
	 */
	public void setInvOver(String invOver) {
		this.invOver = invOver;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfc
	 */
	public void setCtrtOfc(String ctrtOfc) {
		this.ctrtOfc = ctrtOfc;
	}
	
	/**
	 * Column Info
	 * @param dmdtInvStsCd
	 */
	public void setDmdtInvStsCd(String dmdtInvStsCd) {
		this.dmdtInvStsCd = dmdtInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param invChgAmt
	 */
	public void setInvChgAmt(String invChgAmt) {
		this.invChgAmt = invChgAmt;
	}
	
	/**
	 * Column Info
	 * @param dmdtInvNo
	 */
	public void setDmdtInvNo(String dmdtInvNo) {
		this.dmdtInvNo = dmdtInvNo;
	}
	
	/**
	 * Column Info
	 * @param actDeltFlg
	 */
	public void setActDeltFlg(String actDeltFlg) {
		this.actDeltFlg = actDeltFlg;
	}
	
	/**
	 * Column Info
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
	}
	
	/**
	 * Column Info
	 * @param arIfOfcCd
	 */
	public void setArIfOfcCd(String arIfOfcCd) {
		this.arIfOfcCd = arIfOfcCd;
	}
	
	/**
	 * Column Info
	 * @param arIfUsrId
	 */
	public void setArIfUsrId(String arIfUsrId) {
		this.arIfUsrId = arIfUsrId;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param dmdtArIfCd
	 */
	public void setDmdtArIfCd(String dmdtArIfCd) {
		this.dmdtArIfCd = dmdtArIfCd;
	}
	
	/**
	 * Column Info
	 * @param orgChgAmt
	 */
	public void setOrgChgAmt(String orgChgAmt) {
		this.orgChgAmt = orgChgAmt;
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
		setPort(JSPUtil.getParameter(request, prefix + "port", ""));
		setInvPrtFlg(JSPUtil.getParameter(request, prefix + "inv_prt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setIssueId(JSPUtil.getParameter(request, prefix + "issue_id", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setBilAmt(JSPUtil.getParameter(request, prefix + "bil_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setChgCurrCd(JSPUtil.getParameter(request, prefix + "chg_curr_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDcAmt(JSPUtil.getParameter(request, prefix + "dc_amt", ""));
		setTaxAmt(JSPUtil.getParameter(request, prefix + "tax_amt", ""));
		setArIfNo(JSPUtil.getParameter(request, prefix + "ar_if_no", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setDmdtExptAmt(JSPUtil.getParameter(request, prefix + "dmdt_expt_amt", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setActPayrCd(JSPUtil.getParameter(request, prefix + "act_payr_cd", ""));
		setArIfDt(JSPUtil.getParameter(request, prefix + "ar_if_dt", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setCrInvNo(JSPUtil.getParameter(request, prefix + "cr_inv_no", ""));
		setActPayrNm(JSPUtil.getParameter(request, prefix + "act_payr_nm", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setArIfUsrNm(JSPUtil.getParameter(request, prefix + "ar_if_usr_nm", ""));
		setIssueNm(JSPUtil.getParameter(request, prefix + "issue_nm", ""));
		setInvOver(JSPUtil.getParameter(request, prefix + "inv_over", ""));
		setCtrtOfc(JSPUtil.getParameter(request, prefix + "ctrt_ofc", ""));
		setDmdtInvStsCd(JSPUtil.getParameter(request, prefix + "dmdt_inv_sts_cd", ""));
		setInvChgAmt(JSPUtil.getParameter(request, prefix + "inv_chg_amt", ""));
		setDmdtInvNo(JSPUtil.getParameter(request, prefix + "dmdt_inv_no", ""));
		setActDeltFlg(JSPUtil.getParameter(request, prefix + "act_delt_flg", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setArIfOfcCd(JSPUtil.getParameter(request, prefix + "ar_if_ofc_cd", ""));
		setArIfUsrId(JSPUtil.getParameter(request, prefix + "ar_if_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setDmdtArIfCd(JSPUtil.getParameter(request, prefix + "dmdt_ar_if_cd", ""));
		setOrgChgAmt(JSPUtil.getParameter(request, prefix + "org_chg_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IssuedInvoiceListVO[]
	 */
	public IssuedInvoiceListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IssuedInvoiceListVO[]
	 */
	public IssuedInvoiceListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IssuedInvoiceListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] invPrtFlg = (JSPUtil.getParameter(request, prefix	+ "inv_prt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] issueId = (JSPUtil.getParameter(request, prefix	+ "issue_id", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] bilAmt = (JSPUtil.getParameter(request, prefix	+ "bil_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chgCurrCd = (JSPUtil.getParameter(request, prefix	+ "chg_curr_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dcAmt = (JSPUtil.getParameter(request, prefix	+ "dc_amt", length));
			String[] taxAmt = (JSPUtil.getParameter(request, prefix	+ "tax_amt", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] dmdtExptAmt = (JSPUtil.getParameter(request, prefix	+ "dmdt_expt_amt", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] actPayrCd = (JSPUtil.getParameter(request, prefix	+ "act_payr_cd", length));
			String[] arIfDt = (JSPUtil.getParameter(request, prefix	+ "ar_if_dt", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] crInvNo = (JSPUtil.getParameter(request, prefix	+ "cr_inv_no", length));
			String[] actPayrNm = (JSPUtil.getParameter(request, prefix	+ "act_payr_nm", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] arIfUsrNm = (JSPUtil.getParameter(request, prefix	+ "ar_if_usr_nm", length));
			String[] issueNm = (JSPUtil.getParameter(request, prefix	+ "issue_nm", length));
			String[] invOver = (JSPUtil.getParameter(request, prefix	+ "inv_over", length));
			String[] ctrtOfc = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc", length));
			String[] dmdtInvStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_inv_sts_cd", length));
			String[] invChgAmt = (JSPUtil.getParameter(request, prefix	+ "inv_chg_amt", length));
			String[] dmdtInvNo = (JSPUtil.getParameter(request, prefix	+ "dmdt_inv_no", length));
			String[] actDeltFlg = (JSPUtil.getParameter(request, prefix	+ "act_delt_flg", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] arIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_if_ofc_cd", length));
			String[] arIfUsrId = (JSPUtil.getParameter(request, prefix	+ "ar_if_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] dmdtArIfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_ar_if_cd", length));
			String[] orgChgAmt = (JSPUtil.getParameter(request, prefix	+ "org_chg_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new IssuedInvoiceListVO();
				if (port[i] != null)
					model.setPort(port[i]);
				if (invPrtFlg[i] != null)
					model.setInvPrtFlg(invPrtFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (issueId[i] != null)
					model.setIssueId(issueId[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (bilAmt[i] != null)
					model.setBilAmt(bilAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chgCurrCd[i] != null)
					model.setChgCurrCd(chgCurrCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dcAmt[i] != null)
					model.setDcAmt(dcAmt[i]);
				if (taxAmt[i] != null)
					model.setTaxAmt(taxAmt[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (dmdtExptAmt[i] != null)
					model.setDmdtExptAmt(dmdtExptAmt[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (actPayrCd[i] != null)
					model.setActPayrCd(actPayrCd[i]);
				if (arIfDt[i] != null)
					model.setArIfDt(arIfDt[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (crInvNo[i] != null)
					model.setCrInvNo(crInvNo[i]);
				if (actPayrNm[i] != null)
					model.setActPayrNm(actPayrNm[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (arIfUsrNm[i] != null)
					model.setArIfUsrNm(arIfUsrNm[i]);
				if (issueNm[i] != null)
					model.setIssueNm(issueNm[i]);
				if (invOver[i] != null)
					model.setInvOver(invOver[i]);
				if (ctrtOfc[i] != null)
					model.setCtrtOfc(ctrtOfc[i]);
				if (dmdtInvStsCd[i] != null)
					model.setDmdtInvStsCd(dmdtInvStsCd[i]);
				if (invChgAmt[i] != null)
					model.setInvChgAmt(invChgAmt[i]);
				if (dmdtInvNo[i] != null)
					model.setDmdtInvNo(dmdtInvNo[i]);
				if (actDeltFlg[i] != null)
					model.setActDeltFlg(actDeltFlg[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (arIfOfcCd[i] != null)
					model.setArIfOfcCd(arIfOfcCd[i]);
				if (arIfUsrId[i] != null)
					model.setArIfUsrId(arIfUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (dmdtArIfCd[i] != null)
					model.setDmdtArIfCd(dmdtArIfCd[i]);
				if (orgChgAmt[i] != null)
					model.setOrgChgAmt(orgChgAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIssuedInvoiceListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IssuedInvoiceListVO[]
	 */
	public IssuedInvoiceListVO[] getIssuedInvoiceListVOs(){
		IssuedInvoiceListVO[] vos = (IssuedInvoiceListVO[])models.toArray(new IssuedInvoiceListVO[models.size()]);
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
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPrtFlg = this.invPrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueId = this.issueId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilAmt = this.bilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCurrCd = this.chgCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcAmt = this.dcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmt = this.taxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtExptAmt = this.dmdtExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPayrCd = this.actPayrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfDt = this.arIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crInvNo = this.crInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPayrNm = this.actPayrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfUsrNm = this.arIfUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueNm = this.issueNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOver = this.invOver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfc = this.ctrtOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtInvStsCd = this.dmdtInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invChgAmt = this.invChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtInvNo = this.dmdtInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDeltFlg = this.actDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfOfcCd = this.arIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfUsrId = this.arIfUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtArIfCd = this.dmdtArIfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgChgAmt = this.orgChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
