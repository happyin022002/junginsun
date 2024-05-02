/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PaymentRequestLetterVO.java
*@FileTitle : PaymentRequestLetterVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.09  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo;

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

public class PaymentRequestLetterVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PaymentRequestLetterVO> models = new ArrayList<PaymentRequestLetterVO>();
	
	/* Column Info */
	private String totLcl = null;
	/* Column Info */
	private String invInvAmt = null;
	/* Column Info */
	private String invBalAmt = null;
	/* Column Info */
	private String otsTpCd = null;
	/* Column Info */
	private String arEmlSeq = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String invRctAmt = null;
	/* Column Info */
	private String cnsdCustSeq = null;
	/* Column Info */
	private String xcldOtsTpCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String invDt = null;
	/* Column Info */
	private String fax = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String rctAmt = null;
	/* Column Info */
	private String adjAmt = null;
	/* Column Info */
	private String bnd = null;
	/* Column Info */
	private String stmtHisSeq = null;
	/* Column Info */
	private String overdueFrom = null;
	/* Column Info */
	private String email = null;
	/* Column Info */
	private String cnsdCustCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String ctrlOfcCdText = null;
	/* Column Info */
	private String overDue = null;
	/* Column Info */
	private String otsOpy = null;
	/* Column Info */
	private String agnOfcCdText = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String otsSmryCd = null;
	/* Column Info */
	private String balAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String exRate = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String accountUsrEml = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String invCurrExRate = null;
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String accountUsrId = null;
	/* Column Info */
	private String overdueTo = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String accountOfcCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String invAdjAmt = null;
	/* Column Info */
	private String accountUsrNm = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String cnsdCustCntCd = null;
	/* Column Info */
	private String cnsdCustFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PaymentRequestLetterVO() {}

	public PaymentRequestLetterVO(String ibflag, String pagerows, String totLcl, String invInvAmt, String invBalAmt, String otsTpCd, String arEmlSeq, String type, String blNo, String sailArrDt, String vvdCd, String invRctAmt, String cnsdCustSeq, String xcldOtsTpCd, String custCntCd, String invDt, String fax, String rhqCd, String rctAmt, String adjAmt, String bnd, String overdueFrom, String cnsdCustCd, String email, String custCd, String ctrlOfcCdText, String overDue, String otsOpy, String agnOfcCdText, String currCd, String custNm, String otsSmryCd, String balAmt, String exRate, String invAmt, String accountUsrEml, String dueDt, String invCurrExRate, String office, String accountUsrId, String overdueTo, String invCurrCd, String custSeq, String arOfcCd, String accountOfcCd, String invNo, String invAdjAmt, String accountUsrNm, String cnsdCustCntCd, String refNo, String cnsdCustFlg, String stmtHisSeq) {
		this.totLcl = totLcl;
		this.invInvAmt = invInvAmt;
		this.invBalAmt = invBalAmt;
		this.otsTpCd = otsTpCd;
		this.arEmlSeq = arEmlSeq;
		this.type = type;
		this.blNo = blNo;
		this.sailArrDt = sailArrDt;
		this.pagerows = pagerows;
		this.vvdCd = vvdCd;
		this.invRctAmt = invRctAmt;
		this.cnsdCustSeq = cnsdCustSeq;
		this.xcldOtsTpCd = xcldOtsTpCd;
		this.custCntCd = custCntCd;
		this.invDt = invDt;
		this.fax = fax;
		this.rhqCd = rhqCd;
		this.rctAmt = rctAmt;
		this.adjAmt = adjAmt;
		this.bnd = bnd;
		this.stmtHisSeq = stmtHisSeq;
		this.overdueFrom = overdueFrom;
		this.email = email;
		this.cnsdCustCd = cnsdCustCd;
		this.custCd = custCd;
		this.ctrlOfcCdText = ctrlOfcCdText;
		this.overDue = overDue;
		this.otsOpy = otsOpy;
		this.agnOfcCdText = agnOfcCdText;
		this.currCd = currCd;
		this.custNm = custNm;
		this.otsSmryCd = otsSmryCd;
		this.balAmt = balAmt;
		this.ibflag = ibflag;
		this.exRate = exRate;
		this.invAmt = invAmt;
		this.accountUsrEml = accountUsrEml;
		this.dueDt = dueDt;
		this.invCurrExRate = invCurrExRate;
		this.office = office;
		this.accountUsrId = accountUsrId;
		this.overdueTo = overdueTo;
		this.invCurrCd = invCurrCd;
		this.custSeq = custSeq;
		this.arOfcCd = arOfcCd;
		this.accountOfcCd = accountOfcCd;
		this.invNo = invNo;
		this.invAdjAmt = invAdjAmt;
		this.accountUsrNm = accountUsrNm;
		this.refNo = refNo;
		this.cnsdCustCntCd = cnsdCustCntCd;
		this.cnsdCustFlg = cnsdCustFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tot_lcl", getTotLcl());
		this.hashColumns.put("inv_inv_amt", getInvInvAmt());
		this.hashColumns.put("inv_bal_amt", getInvBalAmt());
		this.hashColumns.put("ots_tp_cd", getOtsTpCd());
		this.hashColumns.put("ar_eml_seq", getArEmlSeq());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("inv_rct_amt", getInvRctAmt());
		this.hashColumns.put("cnsd_cust_seq", getCnsdCustSeq());
		this.hashColumns.put("xcld_ots_tp_cd", getXcldOtsTpCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("inv_dt", getInvDt());
		this.hashColumns.put("fax", getFax());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("rct_amt", getRctAmt());
		this.hashColumns.put("adj_amt", getAdjAmt());
		this.hashColumns.put("bnd", getBnd());
		this.hashColumns.put("stmt_his_seq", getStmtHisSeq());
		this.hashColumns.put("overdue_from", getOverdueFrom());
		this.hashColumns.put("email", getEmail());
		this.hashColumns.put("cnsd_cust_cd", getCnsdCustCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("ctrl_ofc_cd_text", getCtrlOfcCdText());
		this.hashColumns.put("over_due", getOverDue());
		this.hashColumns.put("ots_opy", getOtsOpy());
		this.hashColumns.put("agn_ofc_cd_text", getAgnOfcCdText());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("ots_smry_cd", getOtsSmryCd());
		this.hashColumns.put("bal_amt", getBalAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ex_rate", getExRate());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("account_usr_eml", getAccountUsrEml());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("inv_curr_ex_rate", getInvCurrExRate());
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("account_usr_id", getAccountUsrId());
		this.hashColumns.put("overdue_to", getOverdueTo());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("account_ofc_cd", getAccountOfcCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("inv_adj_amt", getInvAdjAmt());
		this.hashColumns.put("account_usr_nm", getAccountUsrNm());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("cnsd_cust_cnt_cd", getCnsdCustCntCd());
		this.hashColumns.put("cnsd_cust_flg", getCnsdCustFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tot_lcl", "totLcl");
		this.hashFields.put("inv_inv_amt", "invInvAmt");
		this.hashFields.put("inv_bal_amt", "invBalAmt");
		this.hashFields.put("ots_tp_cd", "otsTpCd");
		this.hashFields.put("ar_eml_seq", "arEmlSeq");
		this.hashFields.put("type", "type");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("inv_rct_amt", "invRctAmt");
		this.hashFields.put("cnsd_cust_seq", "cnsdCustSeq");
		this.hashFields.put("xcld_ots_tp_cd", "xcldOtsTpCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("fax", "fax");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("rct_amt", "rctAmt");
		this.hashFields.put("adj_amt", "adjAmt");
		this.hashFields.put("bnd", "bnd");
		this.hashFields.put("stmt_his_seq", "stmtHisSeq");
		this.hashFields.put("overdue_from", "overdueFrom");
		this.hashFields.put("email", "email");
		this.hashFields.put("cnsd_cust_cd", "cnsdCustCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("ctrl_ofc_cd_text", "ctrlOfcCdText");
		this.hashFields.put("over_due", "overDue");
		this.hashFields.put("ots_opy", "otsOpy");
		this.hashFields.put("agn_ofc_cd_text", "agnOfcCdText");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("ots_smry_cd", "otsSmryCd");
		this.hashFields.put("bal_amt", "balAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ex_rate", "exRate");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("account_usr_eml", "accountUsrEml");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("inv_curr_ex_rate", "invCurrExRate");
		this.hashFields.put("office", "office");
		this.hashFields.put("account_usr_id", "accountUsrId");
		this.hashFields.put("overdue_to", "overdueTo");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("account_ofc_cd", "accountOfcCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("inv_adj_amt", "invAdjAmt");
		this.hashFields.put("account_usr_nm", "accountUsrNm");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("cnsd_cust_cnt_cd", "cnsdCustCntCd");
		this.hashFields.put("cnsd_cust_flg", "cnsdCustFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return totLcl
	 */
	public String getTotLcl() {
		return this.totLcl;
	}
	
	/**
	 * Column Info
	 * @return invInvAmt
	 */
	public String getInvInvAmt() {
		return this.invInvAmt;
	}
	
	/**
	 * Column Info
	 * @return invBalAmt
	 */
	public String getInvBalAmt() {
		return this.invBalAmt;
	}
	
	/**
	 * Column Info
	 * @return otsTpCd
	 */
	public String getOtsTpCd() {
		return this.otsTpCd;
	}
	
	/**
	 * Column Info
	 * @return arEmlSeq
	 */
	public String getArEmlSeq() {
		return this.arEmlSeq;
	}
	
	/**
	 * Column Info
	 * @return type
	 */
	public String getType() {
		return this.type;
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
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return invRctAmt
	 */
	public String getInvRctAmt() {
		return this.invRctAmt;
	}
	
	/**
	 * Column Info
	 * @return cnsdCustSeq
	 */
	public String getCnsdCustSeq() {
		return this.cnsdCustSeq;
	}
	
	/**
	 * Column Info
	 * @return xcldOtsTpCd
	 */
	public String getXcldOtsTpCd() {
		return this.xcldOtsTpCd;
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
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
	}
	
	/**
	 * Column Info
	 * @return fax
	 */
	public String getFax() {
		return this.fax;
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
	 * @return rctAmt
	 */
	public String getRctAmt() {
		return this.rctAmt;
	}
	
	/**
	 * Column Info
	 * @return adjAmt
	 */
	public String getAdjAmt() {
		return this.adjAmt;
	}
	
	/**
	 * Column Info
	 * @return bnd
	 */
	public String getBnd() {
		return this.bnd;
	}
	
	/**
	 * Column Info
	 * @return stmtHisSeq
	 */
	public String getStmtHisSeq() {
		return this.stmtHisSeq;
	}
	
	/**
	 * Column Info
	 * @return overdueFrom
	 */
	public String getOverdueFrom() {
		return this.overdueFrom;
	}
	
	/**
	 * Column Info
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Column Info
	 * @return cnsdCustCd
	 */
	public String getCnsdCustCd() {
		return this.cnsdCustCd;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCdText
	 */
	public String getCtrlOfcCdText() {
		return this.ctrlOfcCdText;
	}
	
	/**
	 * Column Info
	 * @return overDue
	 */
	public String getOverDue() {
		return this.overDue;
	}
	
	/**
	 * Column Info
	 * @return otsOpy
	 */
	public String getOtsOpy() {
		return this.otsOpy;
	}
	
	/**
	 * Column Info
	 * @return agnOfcCdText
	 */
	public String getAgnOfcCdText() {
		return this.agnOfcCdText;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return otsSmryCd
	 */
	public String getOtsSmryCd() {
		return this.otsSmryCd;
	}
	
	/**
	 * Column Info
	 * @return balAmt
	 */
	public String getBalAmt() {
		return this.balAmt;
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
	 * @return exRate
	 */
	public String getExRate() {
		return this.exRate;
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
	 * @return accountUsrEml
	 */
	public String getAccountUsrEml() {
		return this.accountUsrEml;
	}
	
	/**
	 * Column Info
	 * @return dueDt
	 */
	public String getDueDt() {
		return this.dueDt;
	}
	
	/**
	 * Column Info
	 * @return invCurrExRate
	 */
	public String getInvCurrExRate() {
		return this.invCurrExRate;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
	}
	
	/**
	 * Column Info
	 * @return accountUsrId
	 */
	public String getAccountUsrId() {
		return this.accountUsrId;
	}
	
	/**
	 * Column Info
	 * @return overdueTo
	 */
	public String getOverdueTo() {
		return this.overdueTo;
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
	 * @return accountOfcCd
	 */
	public String getAccountOfcCd() {
		return this.accountOfcCd;
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
	 * @return invAdjAmt
	 */
	public String getInvAdjAmt() {
		return this.invAdjAmt;
	}
	
	/**
	 * Column Info
	 * @return accountUsrNm
	 */
	public String getAccountUsrNm() {
		return this.accountUsrNm;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return cnsdCustCntCd
	 */
	public String getCnsdCustCntCd() {
		return this.cnsdCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return cnsdCustFlg
	 */
	public String getCnsdCustFlg() {
		return this.cnsdCustFlg;
	}
	

	/**
	 * Column Info
	 * @param totLcl
	 */
	public void setTotLcl(String totLcl) {
		this.totLcl = totLcl;
	}
	
	/**
	 * Column Info
	 * @param invInvAmt
	 */
	public void setInvInvAmt(String invInvAmt) {
		this.invInvAmt = invInvAmt;
	}
	
	/**
	 * Column Info
	 * @param invBalAmt
	 */
	public void setInvBalAmt(String invBalAmt) {
		this.invBalAmt = invBalAmt;
	}
	
	/**
	 * Column Info
	 * @param otsTpCd
	 */
	public void setOtsTpCd(String otsTpCd) {
		this.otsTpCd = otsTpCd;
	}
	
	/**
	 * Column Info
	 * @param arEmlSeq
	 */
	public void setArEmlSeq(String arEmlSeq) {
		this.arEmlSeq = arEmlSeq;
	}
	
	/**
	 * Column Info
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
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
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param invRctAmt
	 */
	public void setInvRctAmt(String invRctAmt) {
		this.invRctAmt = invRctAmt;
	}
	
	/**
	 * Column Info
	 * @param cnsdCustSeq
	 */
	public void setCnsdCustSeq(String cnsdCustSeq) {
		this.cnsdCustSeq = cnsdCustSeq;
	}
	
	/**
	 * Column Info
	 * @param xcldOtsTpCd
	 */
	public void setXcldOtsTpCd(String xcldOtsTpCd) {
		this.xcldOtsTpCd = xcldOtsTpCd;
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
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
	}
	
	/**
	 * Column Info
	 * @param fax
	 */
	public void setFax(String fax) {
		this.fax = fax;
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
	 * @param rctAmt
	 */
	public void setRctAmt(String rctAmt) {
		this.rctAmt = rctAmt;
	}
	
	/**
	 * Column Info
	 * @param adjAmt
	 */
	public void setAdjAmt(String adjAmt) {
		this.adjAmt = adjAmt;
	}
	
	/**
	 * Column Info
	 * @param bnd
	 */
	public void setBnd(String bnd) {
		this.bnd = bnd;
	}
	
	/**
	 * Column Info
	 * @param stmtHisSeq
	 */
	public void setStmtHisSeq(String stmtHisSeq) {
		this.stmtHisSeq = stmtHisSeq;
	}
	
	/**
	 * Column Info
	 * @param overdueFrom
	 */
	public void setOverdueFrom(String overdueFrom) {
		this.overdueFrom = overdueFrom;
	}
	
	/**
	 * Column Info
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Column Info
	 * @param cnsdCustCd
	 */
	public void setCnsdCustCd(String cnsdCustCd) {
		this.cnsdCustCd = cnsdCustCd;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCdText
	 */
	public void setCtrlOfcCdText(String ctrlOfcCdText) {
		this.ctrlOfcCdText = ctrlOfcCdText;
	}
	
	/**
	 * Column Info
	 * @param overDue
	 */
	public void setOverDue(String overDue) {
		this.overDue = overDue;
	}
	
	/**
	 * Column Info
	 * @param otsOpy
	 */
	public void setOtsOpy(String otsOpy) {
		this.otsOpy = otsOpy;
	}
	
	/**
	 * Column Info
	 * @param agnOfcCdText
	 */
	public void setAgnOfcCdText(String agnOfcCdText) {
		this.agnOfcCdText = agnOfcCdText;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param otsSmryCd
	 */
	public void setOtsSmryCd(String otsSmryCd) {
		this.otsSmryCd = otsSmryCd;
	}
	
	/**
	 * Column Info
	 * @param balAmt
	 */
	public void setBalAmt(String balAmt) {
		this.balAmt = balAmt;
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
	 * @param exRate
	 */
	public void setExRate(String exRate) {
		this.exRate = exRate;
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
	 * @param accountUsrEml
	 */
	public void setAccountUsrEml(String accountUsrEml) {
		this.accountUsrEml = accountUsrEml;
	}
	
	/**
	 * Column Info
	 * @param dueDt
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}
	
	/**
	 * Column Info
	 * @param invCurrExRate
	 */
	public void setInvCurrExRate(String invCurrExRate) {
		this.invCurrExRate = invCurrExRate;
	}
	
	/**
	 * Column Info
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	/**
	 * Column Info
	 * @param accountUsrId
	 */
	public void setAccountUsrId(String accountUsrId) {
		this.accountUsrId = accountUsrId;
	}
	
	/**
	 * Column Info
	 * @param overdueTo
	 */
	public void setOverdueTo(String overdueTo) {
		this.overdueTo = overdueTo;
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
	 * @param accountOfcCd
	 */
	public void setAccountOfcCd(String accountOfcCd) {
		this.accountOfcCd = accountOfcCd;
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
	 * @param invAdjAmt
	 */
	public void setInvAdjAmt(String invAdjAmt) {
		this.invAdjAmt = invAdjAmt;
	}
	
	/**
	 * Column Info
	 * @param accountUsrNm
	 */
	public void setAccountUsrNm(String accountUsrNm) {
		this.accountUsrNm = accountUsrNm;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param cnsdCustCntCd
	 */
	public void setCnsdCustCntCd(String cnsdCustCntCd) {
		this.cnsdCustCntCd = cnsdCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param cnsdCustFlg
	 */
	public void setCnsdCustFlg(String cnsdCustFlg) {
		this.cnsdCustFlg = cnsdCustFlg;
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
		setTotLcl(JSPUtil.getParameter(request, prefix + "tot_lcl", ""));
		setInvInvAmt(JSPUtil.getParameter(request, prefix + "inv_inv_amt", ""));
		setInvBalAmt(JSPUtil.getParameter(request, prefix + "inv_bal_amt", ""));
		setOtsTpCd(JSPUtil.getParameter(request, prefix + "ots_tp_cd", ""));
		setArEmlSeq(JSPUtil.getParameter(request, prefix + "ar_eml_seq", ""));
		setType(JSPUtil.getParameter(request, prefix + "type", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setSailArrDt(JSPUtil.getParameter(request, prefix + "sail_arr_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setInvRctAmt(JSPUtil.getParameter(request, prefix + "inv_rct_amt", ""));
		setCnsdCustSeq(JSPUtil.getParameter(request, prefix + "cnsd_cust_seq", ""));
		setXcldOtsTpCd(JSPUtil.getParameter(request, prefix + "xcld_ots_tp_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
		setFax(JSPUtil.getParameter(request, prefix + "fax", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setRctAmt(JSPUtil.getParameter(request, prefix + "rct_amt", ""));
		setAdjAmt(JSPUtil.getParameter(request, prefix + "adj_amt", ""));
		setBnd(JSPUtil.getParameter(request, prefix + "bnd", ""));
		setStmtHisSeq(JSPUtil.getParameter(request, prefix + "stmt_his_seq", ""));
		setOverdueFrom(JSPUtil.getParameter(request, prefix + "overdue_from", ""));
		setEmail(JSPUtil.getParameter(request, prefix + "email", ""));
		setCnsdCustCd(JSPUtil.getParameter(request, prefix + "cnsd_cust_cd", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setCtrlOfcCdText(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_text", ""));
		setOverDue(JSPUtil.getParameter(request, prefix + "over_due", ""));
		setOtsOpy(JSPUtil.getParameter(request, prefix + "ots_opy", ""));
		setAgnOfcCdText(JSPUtil.getParameter(request, prefix + "agn_ofc_cd_text", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setOtsSmryCd(JSPUtil.getParameter(request, prefix + "ots_smry_cd", ""));
		setBalAmt(JSPUtil.getParameter(request, prefix + "bal_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setExRate(JSPUtil.getParameter(request, prefix + "ex_rate", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setAccountUsrEml(JSPUtil.getParameter(request, prefix + "account_usr_eml", ""));
		setDueDt(JSPUtil.getParameter(request, prefix + "due_dt", ""));
		setInvCurrExRate(JSPUtil.getParameter(request, prefix + "inv_curr_ex_rate", ""));
		setOffice(JSPUtil.getParameter(request, prefix + "office", ""));
		setAccountUsrId(JSPUtil.getParameter(request, prefix + "account_usr_id", ""));
		setOverdueTo(JSPUtil.getParameter(request, prefix + "overdue_to", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setAccountOfcCd(JSPUtil.getParameter(request, prefix + "account_ofc_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setInvAdjAmt(JSPUtil.getParameter(request, prefix + "inv_adj_amt", ""));
		setAccountUsrNm(JSPUtil.getParameter(request, prefix + "account_usr_nm", ""));
		setRefNo(JSPUtil.getParameter(request, prefix + "ref_no", ""));
		setCnsdCustCntCd(JSPUtil.getParameter(request, prefix + "cnsd_cust_cnt_cd", ""));
		setCnsdCustFlg(JSPUtil.getParameter(request, prefix + "cnsd_cust_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PaymentRequestLetterVO[]
	 */
	public PaymentRequestLetterVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PaymentRequestLetterVO[]
	 */
	public PaymentRequestLetterVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PaymentRequestLetterVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] totLcl = (JSPUtil.getParameter(request, prefix	+ "tot_lcl", length));
			String[] invInvAmt = (JSPUtil.getParameter(request, prefix	+ "inv_inv_amt", length));
			String[] invBalAmt = (JSPUtil.getParameter(request, prefix	+ "inv_bal_amt", length));
			String[] otsTpCd = (JSPUtil.getParameter(request, prefix	+ "ots_tp_cd", length));
			String[] arEmlSeq = (JSPUtil.getParameter(request, prefix	+ "ar_eml_seq", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] invRctAmt = (JSPUtil.getParameter(request, prefix	+ "inv_rct_amt", length));
			String[] cnsdCustSeq = (JSPUtil.getParameter(request, prefix	+ "cnsd_cust_seq", length));
			String[] xcldOtsTpCd = (JSPUtil.getParameter(request, prefix	+ "xcld_ots_tp_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			String[] fax = (JSPUtil.getParameter(request, prefix	+ "fax", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] rctAmt = (JSPUtil.getParameter(request, prefix	+ "rct_amt", length));
			String[] adjAmt = (JSPUtil.getParameter(request, prefix	+ "adj_amt", length));
			String[] bnd = (JSPUtil.getParameter(request, prefix	+ "bnd", length));
			String[] stmtHisSeq = (JSPUtil.getParameter(request, prefix	+ "stmt_his_seq", length));
			String[] overdueFrom = (JSPUtil.getParameter(request, prefix	+ "overdue_from", length));
			String[] email = (JSPUtil.getParameter(request, prefix	+ "email", length));
			String[] cnsdCustCd = (JSPUtil.getParameter(request, prefix	+ "cnsd_cust_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] ctrlOfcCdText = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_text", length));
			String[] overDue = (JSPUtil.getParameter(request, prefix	+ "over_due", length));
			String[] otsOpy = (JSPUtil.getParameter(request, prefix	+ "ots_opy", length));
			String[] agnOfcCdText = (JSPUtil.getParameter(request, prefix	+ "agn_ofc_cd_text", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] otsSmryCd = (JSPUtil.getParameter(request, prefix	+ "ots_smry_cd", length));
			String[] balAmt = (JSPUtil.getParameter(request, prefix	+ "bal_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] exRate = (JSPUtil.getParameter(request, prefix	+ "ex_rate", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] accountUsrEml = (JSPUtil.getParameter(request, prefix	+ "account_usr_eml", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] invCurrExRate = (JSPUtil.getParameter(request, prefix	+ "inv_curr_ex_rate", length));
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] accountUsrId = (JSPUtil.getParameter(request, prefix	+ "account_usr_id", length));
			String[] overdueTo = (JSPUtil.getParameter(request, prefix	+ "overdue_to", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] accountOfcCd = (JSPUtil.getParameter(request, prefix	+ "account_ofc_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] invAdjAmt = (JSPUtil.getParameter(request, prefix	+ "inv_adj_amt", length));
			String[] accountUsrNm = (JSPUtil.getParameter(request, prefix	+ "account_usr_nm", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] cnsdCustCntCd = (JSPUtil.getParameter(request, prefix	+ "cnsd_cust_cnt_cd", length));
			String[] cnsdCustFlg = (JSPUtil.getParameter(request, prefix	+ "cnsd_cust_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new PaymentRequestLetterVO();
				if (totLcl[i] != null)
					model.setTotLcl(totLcl[i]);
				if (invInvAmt[i] != null)
					model.setInvInvAmt(invInvAmt[i]);
				if (invBalAmt[i] != null)
					model.setInvBalAmt(invBalAmt[i]);
				if (otsTpCd[i] != null)
					model.setOtsTpCd(otsTpCd[i]);
				if (arEmlSeq[i] != null)
					model.setArEmlSeq(arEmlSeq[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (invRctAmt[i] != null)
					model.setInvRctAmt(invRctAmt[i]);
				if (cnsdCustSeq[i] != null)
					model.setCnsdCustSeq(cnsdCustSeq[i]);
				if (xcldOtsTpCd[i] != null)
					model.setXcldOtsTpCd(xcldOtsTpCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				if (fax[i] != null)
					model.setFax(fax[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (rctAmt[i] != null)
					model.setRctAmt(rctAmt[i]);
				if (adjAmt[i] != null)
					model.setAdjAmt(adjAmt[i]);
				if (bnd[i] != null)
					model.setBnd(bnd[i]);
				if (stmtHisSeq[i] != null)
					model.setStmtHisSeq(stmtHisSeq[i]);
				if (overdueFrom[i] != null)
					model.setOverdueFrom(overdueFrom[i]);
				if (email[i] != null)
					model.setEmail(email[i]);
				if (cnsdCustCd[i] != null)
					model.setCnsdCustCd(cnsdCustCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (ctrlOfcCdText[i] != null)
					model.setCtrlOfcCdText(ctrlOfcCdText[i]);
				if (overDue[i] != null)
					model.setOverDue(overDue[i]);
				if (otsOpy[i] != null)
					model.setOtsOpy(otsOpy[i]);
				if (agnOfcCdText[i] != null)
					model.setAgnOfcCdText(agnOfcCdText[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (otsSmryCd[i] != null)
					model.setOtsSmryCd(otsSmryCd[i]);
				if (balAmt[i] != null)
					model.setBalAmt(balAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (exRate[i] != null)
					model.setExRate(exRate[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (accountUsrEml[i] != null)
					model.setAccountUsrEml(accountUsrEml[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (invCurrExRate[i] != null)
					model.setInvCurrExRate(invCurrExRate[i]);
				if (office[i] != null)
					model.setOffice(office[i]);
				if (accountUsrId[i] != null)
					model.setAccountUsrId(accountUsrId[i]);
				if (overdueTo[i] != null)
					model.setOverdueTo(overdueTo[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (accountOfcCd[i] != null)
					model.setAccountOfcCd(accountOfcCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (invAdjAmt[i] != null)
					model.setInvAdjAmt(invAdjAmt[i]);
				if (accountUsrNm[i] != null)
					model.setAccountUsrNm(accountUsrNm[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (cnsdCustCntCd[i] != null)
					model.setCnsdCustCntCd(cnsdCustCntCd[i]);
				if (cnsdCustFlg[i] != null)
					model.setCnsdCustFlg(cnsdCustFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPaymentRequestLetterVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PaymentRequestLetterVO[]
	 */
	public PaymentRequestLetterVO[] getPaymentRequestLetterVOs(){
		PaymentRequestLetterVO[] vos = (PaymentRequestLetterVO[])models.toArray(new PaymentRequestLetterVO[models.size()]);
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
		this.totLcl = this.totLcl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invInvAmt = this.invInvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invBalAmt = this.invBalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsTpCd = this.otsTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arEmlSeq = this.arEmlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRctAmt = this.invRctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnsdCustSeq = this.cnsdCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldOtsTpCd = this.xcldOtsTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fax = this.fax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAmt = this.rctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjAmt = this.adjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnd = this.bnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stmtHisSeq = this.stmtHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overdueFrom = this.overdueFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.email = this.email .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnsdCustCd = this.cnsdCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCdText = this.ctrlOfcCdText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overDue = this.overDue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOpy = this.otsOpy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnOfcCdText = this.agnOfcCdText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSmryCd = this.otsSmryCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balAmt = this.balAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exRate = this.exRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accountUsrEml = this.accountUsrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrExRate = this.invCurrExRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accountUsrId = this.accountUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overdueTo = this.overdueTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accountOfcCd = this.accountOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAdjAmt = this.invAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accountUsrNm = this.accountUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnsdCustCntCd = this.cnsdCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnsdCustFlg = this.cnsdCustFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
