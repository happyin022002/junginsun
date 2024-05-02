/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AsaClearingVO.java
*@FileTitle : AsaClearingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.01  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class AsaClearingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AsaClearingVO> models = new ArrayList<AsaClearingVO>();
	
	/* Column Info */
	private String asaLocationCode = null;
	/* Column Info */
	private String chgTpCd = null;
	/* Column Info */
	private String invDtrbSeq = null;
	/* Column Info */
	private String sourceCode = null;
	/* Column Info */
	private String asaOfficeCode = null;
	/* Column Info */
	private String repTpSrcCd = null;
	/* Column Info */
	private String asaExpenseType = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String rowId = null;
	/* Column Info */
	private String dtrbLineNo = null;
	/* Column Info */
	private String asaArHqOffice = null;
	/* Column Info */
	private String financeRegionCd = null;
	/* Column Info */
	private String glCenterCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String asaCreditTerm = null;
	/* Column Info */
	private String dtrbCdCmbSeq = null;
	/* Column Info */
	private String apOfficeCode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String asaCurrencyCode = null;
	/* Column Info */
	private String liabCdCmbSeq = null;
	/* Column Info */
	private String accountingDate = null;
	/* Column Info */
	private String dueDate = null;
	/* Column Info */
	private String asaCustSeq = null;
	/* Column Info */
	private String ifNo = null;
	/* Column Info */
	private String arCurrCd = null;
	/* Column Info */
	private String asaAgentCode = null;
	/* Column Info */
	private String asaPeriodTo = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String bkgIoFlag = null;
	/* Column Info */
	private String dtrbAmt = null;
	/* Column Info */
	private String revTpSrcCd = null;
	/* Column Info */
	private String asaNo = null;
	/* Column Info */
	private String asaCustCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AsaClearingVO() {}

	public AsaClearingVO(String ibflag, String pagerows, String rowId, String invSeq, String invNo, String dtrbLineNo, String asaNo, String invCurrCd, String apOfficeCode, String liabCdCmbSeq, String asaOfficeCode, String asaAgentCode, String asaPeriodTo, String asaCustCntCd, String asaCustSeq, String asaCreditTerm, String asaCurrencyCode, String asaLocationCode, String asaArHqOffice, String invDtrbSeq, String dtrbAmt, String accountingDate, String dtrbCdCmbSeq, String sourceCode, String financeRegionCd, String glCenterCd, String arCurrCd, String asaExpenseType, String repTpSrcCd, String chgTpCd, String dueDate, String bkgIoFlag, String ifNo, String revTpSrcCd, String usrId) {
		this.asaLocationCode = asaLocationCode;
		this.chgTpCd = chgTpCd;
		this.invDtrbSeq = invDtrbSeq;
		this.sourceCode = sourceCode;
		this.asaOfficeCode = asaOfficeCode;
		this.repTpSrcCd = repTpSrcCd;
		this.asaExpenseType = asaExpenseType;
		this.invSeq = invSeq;
		this.rowId = rowId;
		this.dtrbLineNo = dtrbLineNo;
		this.asaArHqOffice = asaArHqOffice;
		this.financeRegionCd = financeRegionCd;
		this.glCenterCd = glCenterCd;
		this.pagerows = pagerows;
		this.asaCreditTerm = asaCreditTerm;
		this.dtrbCdCmbSeq = dtrbCdCmbSeq;
		this.apOfficeCode = apOfficeCode;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.asaCurrencyCode = asaCurrencyCode;
		this.liabCdCmbSeq = liabCdCmbSeq;
		this.accountingDate = accountingDate;
		this.dueDate = dueDate;
		this.asaCustSeq = asaCustSeq;
		this.ifNo = ifNo;
		this.arCurrCd = arCurrCd;
		this.asaAgentCode = asaAgentCode;
		this.asaPeriodTo = asaPeriodTo;
		this.invCurrCd = invCurrCd;
		this.invNo = invNo;
		this.bkgIoFlag = bkgIoFlag;
		this.dtrbAmt = dtrbAmt;
		this.revTpSrcCd = revTpSrcCd;
		this.asaNo = asaNo;
		this.asaCustCntCd = asaCustCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("asa_location_code", getAsaLocationCode());
		this.hashColumns.put("chg_tp_cd", getChgTpCd());
		this.hashColumns.put("inv_dtrb_seq", getInvDtrbSeq());
		this.hashColumns.put("source_code", getSourceCode());
		this.hashColumns.put("asa_office_code", getAsaOfficeCode());
		this.hashColumns.put("rep_tp_src_cd", getRepTpSrcCd());
		this.hashColumns.put("asa_expense_type", getAsaExpenseType());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("row_id", getRowId());
		this.hashColumns.put("dtrb_line_no", getDtrbLineNo());
		this.hashColumns.put("asa_ar_hq_office", getAsaArHqOffice());
		this.hashColumns.put("finance_region_cd", getFinanceRegionCd());
		this.hashColumns.put("gl_center_cd", getGlCenterCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("asa_credit_term", getAsaCreditTerm());
		this.hashColumns.put("dtrb_cd_cmb_seq", getDtrbCdCmbSeq());
		this.hashColumns.put("ap_office_code", getApOfficeCode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("asa_currency_code", getAsaCurrencyCode());
		this.hashColumns.put("liab_cd_cmb_seq", getLiabCdCmbSeq());
		this.hashColumns.put("accounting_date", getAccountingDate());
		this.hashColumns.put("due_date", getDueDate());
		this.hashColumns.put("asa_cust_seq", getAsaCustSeq());
		this.hashColumns.put("if_no", getIfNo());
		this.hashColumns.put("ar_curr_cd", getArCurrCd());
		this.hashColumns.put("asa_agent_code", getAsaAgentCode());
		this.hashColumns.put("asa_period_to", getAsaPeriodTo());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("bkg_io_flag", getBkgIoFlag());
		this.hashColumns.put("dtrb_amt", getDtrbAmt());
		this.hashColumns.put("rev_tp_src_cd", getRevTpSrcCd());
		this.hashColumns.put("asa_no", getAsaNo());
		this.hashColumns.put("asa_cust_cnt_cd", getAsaCustCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("asa_location_code", "asaLocationCode");
		this.hashFields.put("chg_tp_cd", "chgTpCd");
		this.hashFields.put("inv_dtrb_seq", "invDtrbSeq");
		this.hashFields.put("source_code", "sourceCode");
		this.hashFields.put("asa_office_code", "asaOfficeCode");
		this.hashFields.put("rep_tp_src_cd", "repTpSrcCd");
		this.hashFields.put("asa_expense_type", "asaExpenseType");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("row_id", "rowId");
		this.hashFields.put("dtrb_line_no", "dtrbLineNo");
		this.hashFields.put("asa_ar_hq_office", "asaArHqOffice");
		this.hashFields.put("finance_region_cd", "financeRegionCd");
		this.hashFields.put("gl_center_cd", "glCenterCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("asa_credit_term", "asaCreditTerm");
		this.hashFields.put("dtrb_cd_cmb_seq", "dtrbCdCmbSeq");
		this.hashFields.put("ap_office_code", "apOfficeCode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("asa_currency_code", "asaCurrencyCode");
		this.hashFields.put("liab_cd_cmb_seq", "liabCdCmbSeq");
		this.hashFields.put("accounting_date", "accountingDate");
		this.hashFields.put("due_date", "dueDate");
		this.hashFields.put("asa_cust_seq", "asaCustSeq");
		this.hashFields.put("if_no", "ifNo");
		this.hashFields.put("ar_curr_cd", "arCurrCd");
		this.hashFields.put("asa_agent_code", "asaAgentCode");
		this.hashFields.put("asa_period_to", "asaPeriodTo");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("bkg_io_flag", "bkgIoFlag");
		this.hashFields.put("dtrb_amt", "dtrbAmt");
		this.hashFields.put("rev_tp_src_cd", "revTpSrcCd");
		this.hashFields.put("asa_no", "asaNo");
		this.hashFields.put("asa_cust_cnt_cd", "asaCustCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return asaLocationCode
	 */
	public String getAsaLocationCode() {
		return this.asaLocationCode;
	}
	
	/**
	 * Column Info
	 * @return chgTpCd
	 */
	public String getChgTpCd() {
		return this.chgTpCd;
	}
	
	/**
	 * Column Info
	 * @return invDtrbSeq
	 */
	public String getInvDtrbSeq() {
		return this.invDtrbSeq;
	}
	
	/**
	 * Column Info
	 * @return sourceCode
	 */
	public String getSourceCode() {
		return this.sourceCode;
	}
	
	/**
	 * Column Info
	 * @return asaOfficeCode
	 */
	public String getAsaOfficeCode() {
		return this.asaOfficeCode;
	}
	
	/**
	 * Column Info
	 * @return repTpSrcCd
	 */
	public String getRepTpSrcCd() {
		return this.repTpSrcCd;
	}
	
	/**
	 * Column Info
	 * @return asaExpenseType
	 */
	public String getAsaExpenseType() {
		return this.asaExpenseType;
	}
	
	/**
	 * Column Info
	 * @return invSeq
	 */
	public String getInvSeq() {
		return this.invSeq;
	}
	
	/**
	 * Column Info
	 * @return rowId
	 */
	public String getRowId() {
		return this.rowId;
	}
	
	/**
	 * Column Info
	 * @return dtrbLineNo
	 */
	public String getDtrbLineNo() {
		return this.dtrbLineNo;
	}
	
	/**
	 * Column Info
	 * @return asaArHqOffice
	 */
	public String getAsaArHqOffice() {
		return this.asaArHqOffice;
	}
	
	/**
	 * Column Info
	 * @return financeRegionCd
	 */
	public String getFinanceRegionCd() {
		return this.financeRegionCd;
	}
	
	/**
	 * Column Info
	 * @return glCenterCd
	 */
	public String getGlCenterCd() {
		return this.glCenterCd;
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
	 * @return asaCreditTerm
	 */
	public String getAsaCreditTerm() {
		return this.asaCreditTerm;
	}
	
	/**
	 * Column Info
	 * @return dtrbCdCmbSeq
	 */
	public String getDtrbCdCmbSeq() {
		return this.dtrbCdCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return apOfficeCode
	 */
	public String getApOfficeCode() {
		return this.apOfficeCode;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return asaCurrencyCode
	 */
	public String getAsaCurrencyCode() {
		return this.asaCurrencyCode;
	}
	
	/**
	 * Column Info
	 * @return liabCdCmbSeq
	 */
	public String getLiabCdCmbSeq() {
		return this.liabCdCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return accountingDate
	 */
	public String getAccountingDate() {
		return this.accountingDate;
	}
	
	/**
	 * Column Info
	 * @return dueDate
	 */
	public String getDueDate() {
		return this.dueDate;
	}
	
	/**
	 * Column Info
	 * @return asaCustSeq
	 */
	public String getAsaCustSeq() {
		return this.asaCustSeq;
	}
	
	/**
	 * Column Info
	 * @return ifNo
	 */
	public String getIfNo() {
		return this.ifNo;
	}
	
	/**
	 * Column Info
	 * @return arCurrCd
	 */
	public String getArCurrCd() {
		return this.arCurrCd;
	}
	
	/**
	 * Column Info
	 * @return asaAgentCode
	 */
	public String getAsaAgentCode() {
		return this.asaAgentCode;
	}
	
	/**
	 * Column Info
	 * @return asaPeriodTo
	 */
	public String getAsaPeriodTo() {
		return this.asaPeriodTo;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return bkgIoFlag
	 */
	public String getBkgIoFlag() {
		return this.bkgIoFlag;
	}
	
	/**
	 * Column Info
	 * @return dtrbAmt
	 */
	public String getDtrbAmt() {
		return this.dtrbAmt;
	}
	
	/**
	 * Column Info
	 * @return revTpSrcCd
	 */
	public String getRevTpSrcCd() {
		return this.revTpSrcCd;
	}
	
	/**
	 * Column Info
	 * @return asaNo
	 */
	public String getAsaNo() {
		return this.asaNo;
	}
	
	/**
	 * Column Info
	 * @return asaCustCntCd
	 */
	public String getAsaCustCntCd() {
		return this.asaCustCntCd;
	}
	

	/**
	 * Column Info
	 * @param asaLocationCode
	 */
	public void setAsaLocationCode(String asaLocationCode) {
		this.asaLocationCode = asaLocationCode;
	}
	
	/**
	 * Column Info
	 * @param chgTpCd
	 */
	public void setChgTpCd(String chgTpCd) {
		this.chgTpCd = chgTpCd;
	}
	
	/**
	 * Column Info
	 * @param invDtrbSeq
	 */
	public void setInvDtrbSeq(String invDtrbSeq) {
		this.invDtrbSeq = invDtrbSeq;
	}
	
	/**
	 * Column Info
	 * @param sourceCode
	 */
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	
	/**
	 * Column Info
	 * @param asaOfficeCode
	 */
	public void setAsaOfficeCode(String asaOfficeCode) {
		this.asaOfficeCode = asaOfficeCode;
	}
	
	/**
	 * Column Info
	 * @param repTpSrcCd
	 */
	public void setRepTpSrcCd(String repTpSrcCd) {
		this.repTpSrcCd = repTpSrcCd;
	}
	
	/**
	 * Column Info
	 * @param asaExpenseType
	 */
	public void setAsaExpenseType(String asaExpenseType) {
		this.asaExpenseType = asaExpenseType;
	}
	
	/**
	 * Column Info
	 * @param invSeq
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}
	
	/**
	 * Column Info
	 * @param rowId
	 */
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	/**
	 * Column Info
	 * @param dtrbLineNo
	 */
	public void setDtrbLineNo(String dtrbLineNo) {
		this.dtrbLineNo = dtrbLineNo;
	}
	
	/**
	 * Column Info
	 * @param asaArHqOffice
	 */
	public void setAsaArHqOffice(String asaArHqOffice) {
		this.asaArHqOffice = asaArHqOffice;
	}
	
	/**
	 * Column Info
	 * @param financeRegionCd
	 */
	public void setFinanceRegionCd(String financeRegionCd) {
		this.financeRegionCd = financeRegionCd;
	}
	
	/**
	 * Column Info
	 * @param glCenterCd
	 */
	public void setGlCenterCd(String glCenterCd) {
		this.glCenterCd = glCenterCd;
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
	 * @param asaCreditTerm
	 */
	public void setAsaCreditTerm(String asaCreditTerm) {
		this.asaCreditTerm = asaCreditTerm;
	}
	
	/**
	 * Column Info
	 * @param dtrbCdCmbSeq
	 */
	public void setDtrbCdCmbSeq(String dtrbCdCmbSeq) {
		this.dtrbCdCmbSeq = dtrbCdCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param apOfficeCode
	 */
	public void setApOfficeCode(String apOfficeCode) {
		this.apOfficeCode = apOfficeCode;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param asaCurrencyCode
	 */
	public void setAsaCurrencyCode(String asaCurrencyCode) {
		this.asaCurrencyCode = asaCurrencyCode;
	}
	
	/**
	 * Column Info
	 * @param liabCdCmbSeq
	 */
	public void setLiabCdCmbSeq(String liabCdCmbSeq) {
		this.liabCdCmbSeq = liabCdCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param accountingDate
	 */
	public void setAccountingDate(String accountingDate) {
		this.accountingDate = accountingDate;
	}
	
	/**
	 * Column Info
	 * @param dueDate
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	/**
	 * Column Info
	 * @param asaCustSeq
	 */
	public void setAsaCustSeq(String asaCustSeq) {
		this.asaCustSeq = asaCustSeq;
	}
	
	/**
	 * Column Info
	 * @param ifNo
	 */
	public void setIfNo(String ifNo) {
		this.ifNo = ifNo;
	}
	
	/**
	 * Column Info
	 * @param arCurrCd
	 */
	public void setArCurrCd(String arCurrCd) {
		this.arCurrCd = arCurrCd;
	}
	
	/**
	 * Column Info
	 * @param asaAgentCode
	 */
	public void setAsaAgentCode(String asaAgentCode) {
		this.asaAgentCode = asaAgentCode;
	}
	
	/**
	 * Column Info
	 * @param asaPeriodTo
	 */
	public void setAsaPeriodTo(String asaPeriodTo) {
		this.asaPeriodTo = asaPeriodTo;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param bkgIoFlag
	 */
	public void setBkgIoFlag(String bkgIoFlag) {
		this.bkgIoFlag = bkgIoFlag;
	}
	
	/**
	 * Column Info
	 * @param dtrbAmt
	 */
	public void setDtrbAmt(String dtrbAmt) {
		this.dtrbAmt = dtrbAmt;
	}
	
	/**
	 * Column Info
	 * @param revTpSrcCd
	 */
	public void setRevTpSrcCd(String revTpSrcCd) {
		this.revTpSrcCd = revTpSrcCd;
	}
	
	/**
	 * Column Info
	 * @param asaNo
	 */
	public void setAsaNo(String asaNo) {
		this.asaNo = asaNo;
	}
	
	/**
	 * Column Info
	 * @param asaCustCntCd
	 */
	public void setAsaCustCntCd(String asaCustCntCd) {
		this.asaCustCntCd = asaCustCntCd;
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
		setAsaLocationCode(JSPUtil.getParameter(request, prefix + "asa_location_code", ""));
		setChgTpCd(JSPUtil.getParameter(request, prefix + "chg_tp_cd", ""));
		setInvDtrbSeq(JSPUtil.getParameter(request, prefix + "inv_dtrb_seq", ""));
		setSourceCode(JSPUtil.getParameter(request, prefix + "source_code", ""));
		setAsaOfficeCode(JSPUtil.getParameter(request, prefix + "asa_office_code", ""));
		setRepTpSrcCd(JSPUtil.getParameter(request, prefix + "rep_tp_src_cd", ""));
		setAsaExpenseType(JSPUtil.getParameter(request, prefix + "asa_expense_type", ""));
		setInvSeq(JSPUtil.getParameter(request, prefix + "inv_seq", ""));
		setRowId(JSPUtil.getParameter(request, prefix + "row_id", ""));
		setDtrbLineNo(JSPUtil.getParameter(request, prefix + "dtrb_line_no", ""));
		setAsaArHqOffice(JSPUtil.getParameter(request, prefix + "asa_ar_hq_office", ""));
		setFinanceRegionCd(JSPUtil.getParameter(request, prefix + "finance_region_cd", ""));
		setGlCenterCd(JSPUtil.getParameter(request, prefix + "gl_center_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAsaCreditTerm(JSPUtil.getParameter(request, prefix + "asa_credit_term", ""));
		setDtrbCdCmbSeq(JSPUtil.getParameter(request, prefix + "dtrb_cd_cmb_seq", ""));
		setApOfficeCode(JSPUtil.getParameter(request, prefix + "ap_office_code", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setAsaCurrencyCode(JSPUtil.getParameter(request, prefix + "asa_currency_code", ""));
		setLiabCdCmbSeq(JSPUtil.getParameter(request, prefix + "liab_cd_cmb_seq", ""));
		setAccountingDate(JSPUtil.getParameter(request, prefix + "accounting_date", ""));
		setDueDate(JSPUtil.getParameter(request, prefix + "due_date", ""));
		setAsaCustSeq(JSPUtil.getParameter(request, prefix + "asa_cust_seq", ""));
		setIfNo(JSPUtil.getParameter(request, prefix + "if_no", ""));
		setArCurrCd(JSPUtil.getParameter(request, prefix + "ar_curr_cd", ""));
		setAsaAgentCode(JSPUtil.getParameter(request, prefix + "asa_agent_code", ""));
		setAsaPeriodTo(JSPUtil.getParameter(request, prefix + "asa_period_to", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setBkgIoFlag(JSPUtil.getParameter(request, prefix + "bkg_io_flag", ""));
		setDtrbAmt(JSPUtil.getParameter(request, prefix + "dtrb_amt", ""));
		setRevTpSrcCd(JSPUtil.getParameter(request, prefix + "rev_tp_src_cd", ""));
		setAsaNo(JSPUtil.getParameter(request, prefix + "asa_no", ""));
		setAsaCustCntCd(JSPUtil.getParameter(request, prefix + "asa_cust_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AsaClearingVO[]
	 */
	public AsaClearingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AsaClearingVO[]
	 */
	public AsaClearingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AsaClearingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] asaLocationCode = (JSPUtil.getParameter(request, prefix	+ "asa_location_code", length));
			String[] chgTpCd = (JSPUtil.getParameter(request, prefix	+ "chg_tp_cd", length));
			String[] invDtrbSeq = (JSPUtil.getParameter(request, prefix	+ "inv_dtrb_seq", length));
			String[] sourceCode = (JSPUtil.getParameter(request, prefix	+ "source_code", length));
			String[] asaOfficeCode = (JSPUtil.getParameter(request, prefix	+ "asa_office_code", length));
			String[] repTpSrcCd = (JSPUtil.getParameter(request, prefix	+ "rep_tp_src_cd", length));
			String[] asaExpenseType = (JSPUtil.getParameter(request, prefix	+ "asa_expense_type", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] rowId = (JSPUtil.getParameter(request, prefix	+ "row_id", length));
			String[] dtrbLineNo = (JSPUtil.getParameter(request, prefix	+ "dtrb_line_no", length));
			String[] asaArHqOffice = (JSPUtil.getParameter(request, prefix	+ "asa_ar_hq_office", length));
			String[] financeRegionCd = (JSPUtil.getParameter(request, prefix	+ "finance_region_cd", length));
			String[] glCenterCd = (JSPUtil.getParameter(request, prefix	+ "gl_center_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] asaCreditTerm = (JSPUtil.getParameter(request, prefix	+ "asa_credit_term", length));
			String[] dtrbCdCmbSeq = (JSPUtil.getParameter(request, prefix	+ "dtrb_cd_cmb_seq", length));
			String[] apOfficeCode = (JSPUtil.getParameter(request, prefix	+ "ap_office_code", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] asaCurrencyCode = (JSPUtil.getParameter(request, prefix	+ "asa_currency_code", length));
			String[] liabCdCmbSeq = (JSPUtil.getParameter(request, prefix	+ "liab_cd_cmb_seq", length));
			String[] accountingDate = (JSPUtil.getParameter(request, prefix	+ "accounting_date", length));
			String[] dueDate = (JSPUtil.getParameter(request, prefix	+ "due_date", length));
			String[] asaCustSeq = (JSPUtil.getParameter(request, prefix	+ "asa_cust_seq", length));
			String[] ifNo = (JSPUtil.getParameter(request, prefix	+ "if_no", length));
			String[] arCurrCd = (JSPUtil.getParameter(request, prefix	+ "ar_curr_cd", length));
			String[] asaAgentCode = (JSPUtil.getParameter(request, prefix	+ "asa_agent_code", length));
			String[] asaPeriodTo = (JSPUtil.getParameter(request, prefix	+ "asa_period_to", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] bkgIoFlag = (JSPUtil.getParameter(request, prefix	+ "bkg_io_flag", length));
			String[] dtrbAmt = (JSPUtil.getParameter(request, prefix	+ "dtrb_amt", length));
			String[] revTpSrcCd = (JSPUtil.getParameter(request, prefix	+ "rev_tp_src_cd", length));
			String[] asaNo = (JSPUtil.getParameter(request, prefix	+ "asa_no", length));
			String[] asaCustCntCd = (JSPUtil.getParameter(request, prefix	+ "asa_cust_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AsaClearingVO();
				if (asaLocationCode[i] != null)
					model.setAsaLocationCode(asaLocationCode[i]);
				if (chgTpCd[i] != null)
					model.setChgTpCd(chgTpCd[i]);
				if (invDtrbSeq[i] != null)
					model.setInvDtrbSeq(invDtrbSeq[i]);
				if (sourceCode[i] != null)
					model.setSourceCode(sourceCode[i]);
				if (asaOfficeCode[i] != null)
					model.setAsaOfficeCode(asaOfficeCode[i]);
				if (repTpSrcCd[i] != null)
					model.setRepTpSrcCd(repTpSrcCd[i]);
				if (asaExpenseType[i] != null)
					model.setAsaExpenseType(asaExpenseType[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (rowId[i] != null)
					model.setRowId(rowId[i]);
				if (dtrbLineNo[i] != null)
					model.setDtrbLineNo(dtrbLineNo[i]);
				if (asaArHqOffice[i] != null)
					model.setAsaArHqOffice(asaArHqOffice[i]);
				if (financeRegionCd[i] != null)
					model.setFinanceRegionCd(financeRegionCd[i]);
				if (glCenterCd[i] != null)
					model.setGlCenterCd(glCenterCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (asaCreditTerm[i] != null)
					model.setAsaCreditTerm(asaCreditTerm[i]);
				if (dtrbCdCmbSeq[i] != null)
					model.setDtrbCdCmbSeq(dtrbCdCmbSeq[i]);
				if (apOfficeCode[i] != null)
					model.setApOfficeCode(apOfficeCode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (asaCurrencyCode[i] != null)
					model.setAsaCurrencyCode(asaCurrencyCode[i]);
				if (liabCdCmbSeq[i] != null)
					model.setLiabCdCmbSeq(liabCdCmbSeq[i]);
				if (accountingDate[i] != null)
					model.setAccountingDate(accountingDate[i]);
				if (dueDate[i] != null)
					model.setDueDate(dueDate[i]);
				if (asaCustSeq[i] != null)
					model.setAsaCustSeq(asaCustSeq[i]);
				if (ifNo[i] != null)
					model.setIfNo(ifNo[i]);
				if (arCurrCd[i] != null)
					model.setArCurrCd(arCurrCd[i]);
				if (asaAgentCode[i] != null)
					model.setAsaAgentCode(asaAgentCode[i]);
				if (asaPeriodTo[i] != null)
					model.setAsaPeriodTo(asaPeriodTo[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (bkgIoFlag[i] != null)
					model.setBkgIoFlag(bkgIoFlag[i]);
				if (dtrbAmt[i] != null)
					model.setDtrbAmt(dtrbAmt[i]);
				if (revTpSrcCd[i] != null)
					model.setRevTpSrcCd(revTpSrcCd[i]);
				if (asaNo[i] != null)
					model.setAsaNo(asaNo[i]);
				if (asaCustCntCd[i] != null)
					model.setAsaCustCntCd(asaCustCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAsaClearingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AsaClearingVO[]
	 */
	public AsaClearingVO[] getAsaClearingVOs(){
		AsaClearingVO[] vos = (AsaClearingVO[])models.toArray(new AsaClearingVO[models.size()]);
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
		this.asaLocationCode = this.asaLocationCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgTpCd = this.chgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDtrbSeq = this.invDtrbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sourceCode = this.sourceCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaOfficeCode = this.asaOfficeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repTpSrcCd = this.repTpSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaExpenseType = this.asaExpenseType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowId = this.rowId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbLineNo = this.dtrbLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaArHqOffice = this.asaArHqOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.financeRegionCd = this.financeRegionCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glCenterCd = this.glCenterCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaCreditTerm = this.asaCreditTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCdCmbSeq = this.dtrbCdCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apOfficeCode = this.apOfficeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaCurrencyCode = this.asaCurrencyCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liabCdCmbSeq = this.liabCdCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accountingDate = this.accountingDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDate = this.dueDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaCustSeq = this.asaCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifNo = this.ifNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arCurrCd = this.arCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaAgentCode = this.asaAgentCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaPeriodTo = this.asaPeriodTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgIoFlag = this.bkgIoFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbAmt = this.dtrbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpSrcCd = this.revTpSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo = this.asaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaCustCntCd = this.asaCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
