/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchReverseCsrForSubletListVO.java
*@FileTitle : SearchReverseCsrForSubletListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.08.13 최우석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최우석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchReverseCsrForSubletListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchReverseCsrForSubletListVO> models = new ArrayList<SearchReverseCsrForSubletListVO>();
	
	/* Column Info */
	private String orgSlpFuncCd = null;
	/* Column Info */
	private String fletSrcTpCd = null;
	/* Column Info */
	private String slpFuncCd = null;
	/* Column Info */
	private String csrDesc = null;
	/* Column Info */
	private String csrCurrCd = null;
	/* Column Info */
	private String orgIssDt = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdEffDt = null;
	/* Column Info */
	private String ctrCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String csrDesc1 = null;
	/* Column Info */
	private String orgSlpSerNo = null;
	/* Column Info */
	private String csrDesc2 = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String slpTpCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String orgSlpTpCd = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String vvdExpDt = null;
	/* Column Info */
	private String csrDesc4 = null;
	/* Column Info */
	private String csrDesc3 = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String slpOfcCd = null;
	/* Column Info */
	private String slpIssDt = null;
	/* Column Info */
	private String toInvNo1 = null;
	/* Column Info */
	private String revAmt = null;
	/* Column Info */
	private String orgSlpOfcCd = null;
	/* Column Info */
	private String csrAmt = null;
	/* Column Info */
	private String toInvNo = null;
	/* Column Info */
	private String slpLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchReverseCsrForSubletListVO() {}

	public SearchReverseCsrForSubletListVO(String ibflag, String pagerows, String acctCd, String custCntCd, String custSeq, String ctrCd, String slpLocCd, String effDt, String csrAmt, String revAmt, String csrDesc, String csrDesc1, String csrDesc2, String csrDesc3, String csrDesc4, String vvdCd, String toInvNo, String toInvNo1, String slpTpCd, String slpFuncCd, String slpOfcCd, String slpIssDt, String csrCurrCd, String invSeq, String vvdEffDt, String vvdExpDt, String fletSrcTpCd, String orgSlpTpCd, String orgSlpFuncCd, String orgSlpOfcCd, String orgIssDt, String orgSlpSerNo, String fletCtrtNo, String csrNo) {
		this.orgSlpFuncCd = orgSlpFuncCd;
		this.fletSrcTpCd = fletSrcTpCd;
		this.slpFuncCd = slpFuncCd;
		this.csrDesc = csrDesc;
		this.csrCurrCd = csrCurrCd;
		this.orgIssDt = orgIssDt;
		this.invSeq = invSeq;
		this.fletCtrtNo = fletCtrtNo;
		this.pagerows = pagerows;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.vvdEffDt = vvdEffDt;
		this.ctrCd = ctrCd;
		this.vvdCd = vvdCd;
		this.csrDesc1 = csrDesc1;
		this.orgSlpSerNo = orgSlpSerNo;
		this.csrDesc2 = csrDesc2;
		this.acctCd = acctCd;
		this.slpTpCd = slpTpCd;
		this.custCntCd = custCntCd;
		this.orgSlpTpCd = orgSlpTpCd;
		this.csrNo = csrNo;
		this.vvdExpDt = vvdExpDt;
		this.csrDesc4 = csrDesc4;
		this.csrDesc3 = csrDesc3;
		this.custSeq = custSeq;
		this.slpOfcCd = slpOfcCd;
		this.slpIssDt = slpIssDt;
		this.toInvNo1 = toInvNo1;
		this.revAmt = revAmt;
		this.orgSlpOfcCd = orgSlpOfcCd;
		this.csrAmt = csrAmt;
		this.toInvNo = toInvNo;
		this.slpLocCd = slpLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("org_slp_func_cd", getOrgSlpFuncCd());
		this.hashColumns.put("flet_src_tp_cd", getFletSrcTpCd());
		this.hashColumns.put("slp_func_cd", getSlpFuncCd());
		this.hashColumns.put("csr_desc", getCsrDesc());
		this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
		this.hashColumns.put("org_iss_dt", getOrgIssDt());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_eff_dt", getVvdEffDt());
		this.hashColumns.put("ctr_cd", getCtrCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("csr_desc1", getCsrDesc1());
		this.hashColumns.put("org_slp_ser_no", getOrgSlpSerNo());
		this.hashColumns.put("csr_desc2", getCsrDesc2());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("org_slp_tp_cd", getOrgSlpTpCd());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("vvd_exp_dt", getVvdExpDt());
		this.hashColumns.put("csr_desc4", getCsrDesc4());
		this.hashColumns.put("csr_desc3", getCsrDesc3());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
		this.hashColumns.put("slp_iss_dt", getSlpIssDt());
		this.hashColumns.put("to_inv_no1", getToInvNo1());
		this.hashColumns.put("rev_amt", getRevAmt());
		this.hashColumns.put("org_slp_ofc_cd", getOrgSlpOfcCd());
		this.hashColumns.put("csr_amt", getCsrAmt());
		this.hashColumns.put("to_inv_no", getToInvNo());
		this.hashColumns.put("slp_loc_cd", getSlpLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("org_slp_func_cd", "orgSlpFuncCd");
		this.hashFields.put("flet_src_tp_cd", "fletSrcTpCd");
		this.hashFields.put("slp_func_cd", "slpFuncCd");
		this.hashFields.put("csr_desc", "csrDesc");
		this.hashFields.put("csr_curr_cd", "csrCurrCd");
		this.hashFields.put("org_iss_dt", "orgIssDt");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_eff_dt", "vvdEffDt");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("csr_desc1", "csrDesc1");
		this.hashFields.put("org_slp_ser_no", "orgSlpSerNo");
		this.hashFields.put("csr_desc2", "csrDesc2");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("org_slp_tp_cd", "orgSlpTpCd");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("vvd_exp_dt", "vvdExpDt");
		this.hashFields.put("csr_desc4", "csrDesc4");
		this.hashFields.put("csr_desc3", "csrDesc3");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("slp_ofc_cd", "slpOfcCd");
		this.hashFields.put("slp_iss_dt", "slpIssDt");
		this.hashFields.put("to_inv_no1", "toInvNo1");
		this.hashFields.put("rev_amt", "revAmt");
		this.hashFields.put("org_slp_ofc_cd", "orgSlpOfcCd");
		this.hashFields.put("csr_amt", "csrAmt");
		this.hashFields.put("to_inv_no", "toInvNo");
		this.hashFields.put("slp_loc_cd", "slpLocCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return orgSlpFuncCd
	 */
	public String getOrgSlpFuncCd() {
		return this.orgSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @return fletSrcTpCd
	 */
	public String getFletSrcTpCd() {
		return this.fletSrcTpCd;
	}
	
	/**
	 * Column Info
	 * @return slpFuncCd
	 */
	public String getSlpFuncCd() {
		return this.slpFuncCd;
	}
	
	/**
	 * Column Info
	 * @return csrDesc
	 */
	public String getCsrDesc() {
		return this.csrDesc;
	}
	
	/**
	 * Column Info
	 * @return csrCurrCd
	 */
	public String getCsrCurrCd() {
		return this.csrCurrCd;
	}
	
	/**
	 * Column Info
	 * @return orgIssDt
	 */
	public String getOrgIssDt() {
		return this.orgIssDt;
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
	 * @return fletCtrtNo
	 */
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return vvdEffDt
	 */
	public String getVvdEffDt() {
		return this.vvdEffDt;
	}
	
	/**
	 * Column Info
	 * @return ctrCd
	 */
	public String getCtrCd() {
		return this.ctrCd;
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
	 * @return csrDesc1
	 */
	public String getCsrDesc1() {
		return this.csrDesc1;
	}
	
	/**
	 * Column Info
	 * @return orgSlpSerNo
	 */
	public String getOrgSlpSerNo() {
		return this.orgSlpSerNo;
	}
	
	/**
	 * Column Info
	 * @return csrDesc2
	 */
	public String getCsrDesc2() {
		return this.csrDesc2;
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
	 * @return slpTpCd
	 */
	public String getSlpTpCd() {
		return this.slpTpCd;
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
	 * @return orgSlpTpCd
	 */
	public String getOrgSlpTpCd() {
		return this.orgSlpTpCd;
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
	 * @return vvdExpDt
	 */
	public String getVvdExpDt() {
		return this.vvdExpDt;
	}
	
	/**
	 * Column Info
	 * @return csrDesc4
	 */
	public String getCsrDesc4() {
		return this.csrDesc4;
	}
	
	/**
	 * Column Info
	 * @return csrDesc3
	 */
	public String getCsrDesc3() {
		return this.csrDesc3;
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
	 * @return slpOfcCd
	 */
	public String getSlpOfcCd() {
		return this.slpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return slpIssDt
	 */
	public String getSlpIssDt() {
		return this.slpIssDt;
	}
	
	/**
	 * Column Info
	 * @return toInvNo1
	 */
	public String getToInvNo1() {
		return this.toInvNo1;
	}
	
	/**
	 * Column Info
	 * @return revAmt
	 */
	public String getRevAmt() {
		return this.revAmt;
	}
	
	/**
	 * Column Info
	 * @return orgSlpOfcCd
	 */
	public String getOrgSlpOfcCd() {
		return this.orgSlpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return csrAmt
	 */
	public String getCsrAmt() {
		return this.csrAmt;
	}
	
	/**
	 * Column Info
	 * @return toInvNo
	 */
	public String getToInvNo() {
		return this.toInvNo;
	}
	
	/**
	 * Column Info
	 * @return slpLocCd
	 */
	public String getSlpLocCd() {
		return this.slpLocCd;
	}
	

	/**
	 * Column Info
	 * @param orgSlpFuncCd
	 */
	public void setOrgSlpFuncCd(String orgSlpFuncCd) {
		this.orgSlpFuncCd = orgSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @param fletSrcTpCd
	 */
	public void setFletSrcTpCd(String fletSrcTpCd) {
		this.fletSrcTpCd = fletSrcTpCd;
	}
	
	/**
	 * Column Info
	 * @param slpFuncCd
	 */
	public void setSlpFuncCd(String slpFuncCd) {
		this.slpFuncCd = slpFuncCd;
	}
	
	/**
	 * Column Info
	 * @param csrDesc
	 */
	public void setCsrDesc(String csrDesc) {
		this.csrDesc = csrDesc;
	}
	
	/**
	 * Column Info
	 * @param csrCurrCd
	 */
	public void setCsrCurrCd(String csrCurrCd) {
		this.csrCurrCd = csrCurrCd;
	}
	
	/**
	 * Column Info
	 * @param orgIssDt
	 */
	public void setOrgIssDt(String orgIssDt) {
		this.orgIssDt = orgIssDt;
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
	 * @param fletCtrtNo
	 */
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param vvdEffDt
	 */
	public void setVvdEffDt(String vvdEffDt) {
		this.vvdEffDt = vvdEffDt;
	}
	
	/**
	 * Column Info
	 * @param ctrCd
	 */
	public void setCtrCd(String ctrCd) {
		this.ctrCd = ctrCd;
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
	 * @param csrDesc1
	 */
	public void setCsrDesc1(String csrDesc1) {
		this.csrDesc1 = csrDesc1;
	}
	
	/**
	 * Column Info
	 * @param orgSlpSerNo
	 */
	public void setOrgSlpSerNo(String orgSlpSerNo) {
		this.orgSlpSerNo = orgSlpSerNo;
	}
	
	/**
	 * Column Info
	 * @param csrDesc2
	 */
	public void setCsrDesc2(String csrDesc2) {
		this.csrDesc2 = csrDesc2;
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
	 * @param slpTpCd
	 */
	public void setSlpTpCd(String slpTpCd) {
		this.slpTpCd = slpTpCd;
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
	 * @param orgSlpTpCd
	 */
	public void setOrgSlpTpCd(String orgSlpTpCd) {
		this.orgSlpTpCd = orgSlpTpCd;
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
	 * @param vvdExpDt
	 */
	public void setVvdExpDt(String vvdExpDt) {
		this.vvdExpDt = vvdExpDt;
	}
	
	/**
	 * Column Info
	 * @param csrDesc4
	 */
	public void setCsrDesc4(String csrDesc4) {
		this.csrDesc4 = csrDesc4;
	}
	
	/**
	 * Column Info
	 * @param csrDesc3
	 */
	public void setCsrDesc3(String csrDesc3) {
		this.csrDesc3 = csrDesc3;
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
	 * @param slpOfcCd
	 */
	public void setSlpOfcCd(String slpOfcCd) {
		this.slpOfcCd = slpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param slpIssDt
	 */
	public void setSlpIssDt(String slpIssDt) {
		this.slpIssDt = slpIssDt;
	}
	
	/**
	 * Column Info
	 * @param toInvNo1
	 */
	public void setToInvNo1(String toInvNo1) {
		this.toInvNo1 = toInvNo1;
	}
	
	/**
	 * Column Info
	 * @param revAmt
	 */
	public void setRevAmt(String revAmt) {
		this.revAmt = revAmt;
	}
	
	/**
	 * Column Info
	 * @param orgSlpOfcCd
	 */
	public void setOrgSlpOfcCd(String orgSlpOfcCd) {
		this.orgSlpOfcCd = orgSlpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param csrAmt
	 */
	public void setCsrAmt(String csrAmt) {
		this.csrAmt = csrAmt;
	}
	
	/**
	 * Column Info
	 * @param toInvNo
	 */
	public void setToInvNo(String toInvNo) {
		this.toInvNo = toInvNo;
	}
	
	/**
	 * Column Info
	 * @param slpLocCd
	 */
	public void setSlpLocCd(String slpLocCd) {
		this.slpLocCd = slpLocCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOrgSlpFuncCd(JSPUtil.getParameter(request, "org_slp_func_cd", ""));
		setFletSrcTpCd(JSPUtil.getParameter(request, "flet_src_tp_cd", ""));
		setSlpFuncCd(JSPUtil.getParameter(request, "slp_func_cd", ""));
		setCsrDesc(JSPUtil.getParameter(request, "csr_desc", ""));
		setCsrCurrCd(JSPUtil.getParameter(request, "csr_curr_cd", ""));
		setOrgIssDt(JSPUtil.getParameter(request, "org_iss_dt", ""));
		setInvSeq(JSPUtil.getParameter(request, "inv_seq", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVvdEffDt(JSPUtil.getParameter(request, "vvd_eff_dt", ""));
		setCtrCd(JSPUtil.getParameter(request, "ctr_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setCsrDesc1(JSPUtil.getParameter(request, "csr_desc1", ""));
		setOrgSlpSerNo(JSPUtil.getParameter(request, "org_slp_ser_no", ""));
		setCsrDesc2(JSPUtil.getParameter(request, "csr_desc2", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setSlpTpCd(JSPUtil.getParameter(request, "slp_tp_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setOrgSlpTpCd(JSPUtil.getParameter(request, "org_slp_tp_cd", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setVvdExpDt(JSPUtil.getParameter(request, "vvd_exp_dt", ""));
		setCsrDesc4(JSPUtil.getParameter(request, "csr_desc4", ""));
		setCsrDesc3(JSPUtil.getParameter(request, "csr_desc3", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setSlpOfcCd(JSPUtil.getParameter(request, "slp_ofc_cd", ""));
		setSlpIssDt(JSPUtil.getParameter(request, "slp_iss_dt", ""));
		setToInvNo1(JSPUtil.getParameter(request, "to_inv_no1", ""));
		setRevAmt(JSPUtil.getParameter(request, "rev_amt", ""));
		setOrgSlpOfcCd(JSPUtil.getParameter(request, "org_slp_ofc_cd", ""));
		setCsrAmt(JSPUtil.getParameter(request, "csr_amt", ""));
		setToInvNo(JSPUtil.getParameter(request, "to_inv_no", ""));
		setSlpLocCd(JSPUtil.getParameter(request, "slp_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchReverseCsrForSubletListVO[]
	 */
	public SearchReverseCsrForSubletListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchReverseCsrForSubletListVO[]
	 */
	public SearchReverseCsrForSubletListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchReverseCsrForSubletListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] orgSlpFuncCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_func_cd", length));
			String[] fletSrcTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_src_tp_cd", length));
			String[] slpFuncCd = (JSPUtil.getParameter(request, prefix	+ "slp_func_cd", length));
			String[] csrDesc = (JSPUtil.getParameter(request, prefix	+ "csr_desc", length));
			String[] csrCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_curr_cd", length));
			String[] orgIssDt = (JSPUtil.getParameter(request, prefix	+ "org_iss_dt", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdEffDt = (JSPUtil.getParameter(request, prefix	+ "vvd_eff_dt", length));
			String[] ctrCd = (JSPUtil.getParameter(request, prefix	+ "ctr_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] csrDesc1 = (JSPUtil.getParameter(request, prefix	+ "csr_desc1", length));
			String[] orgSlpSerNo = (JSPUtil.getParameter(request, prefix	+ "org_slp_ser_no", length));
			String[] csrDesc2 = (JSPUtil.getParameter(request, prefix	+ "csr_desc2", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] orgSlpTpCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_tp_cd", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] vvdExpDt = (JSPUtil.getParameter(request, prefix	+ "vvd_exp_dt", length));
			String[] csrDesc4 = (JSPUtil.getParameter(request, prefix	+ "csr_desc4", length));
			String[] csrDesc3 = (JSPUtil.getParameter(request, prefix	+ "csr_desc3", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] slpOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_ofc_cd", length));
			String[] slpIssDt = (JSPUtil.getParameter(request, prefix	+ "slp_iss_dt", length));
			String[] toInvNo1 = (JSPUtil.getParameter(request, prefix	+ "to_inv_no1", length));
			String[] revAmt = (JSPUtil.getParameter(request, prefix	+ "rev_amt", length));
			String[] orgSlpOfcCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_ofc_cd", length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt", length));
			String[] toInvNo = (JSPUtil.getParameter(request, prefix	+ "to_inv_no", length));
			String[] slpLocCd = (JSPUtil.getParameter(request, prefix	+ "slp_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchReverseCsrForSubletListVO();
				if (orgSlpFuncCd[i] != null)
					model.setOrgSlpFuncCd(orgSlpFuncCd[i]);
				if (fletSrcTpCd[i] != null)
					model.setFletSrcTpCd(fletSrcTpCd[i]);
				if (slpFuncCd[i] != null)
					model.setSlpFuncCd(slpFuncCd[i]);
				if (csrDesc[i] != null)
					model.setCsrDesc(csrDesc[i]);
				if (csrCurrCd[i] != null)
					model.setCsrCurrCd(csrCurrCd[i]);
				if (orgIssDt[i] != null)
					model.setOrgIssDt(orgIssDt[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdEffDt[i] != null)
					model.setVvdEffDt(vvdEffDt[i]);
				if (ctrCd[i] != null)
					model.setCtrCd(ctrCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (csrDesc1[i] != null)
					model.setCsrDesc1(csrDesc1[i]);
				if (orgSlpSerNo[i] != null)
					model.setOrgSlpSerNo(orgSlpSerNo[i]);
				if (csrDesc2[i] != null)
					model.setCsrDesc2(csrDesc2[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (orgSlpTpCd[i] != null)
					model.setOrgSlpTpCd(orgSlpTpCd[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (vvdExpDt[i] != null)
					model.setVvdExpDt(vvdExpDt[i]);
				if (csrDesc4[i] != null)
					model.setCsrDesc4(csrDesc4[i]);
				if (csrDesc3[i] != null)
					model.setCsrDesc3(csrDesc3[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (slpOfcCd[i] != null)
					model.setSlpOfcCd(slpOfcCd[i]);
				if (slpIssDt[i] != null)
					model.setSlpIssDt(slpIssDt[i]);
				if (toInvNo1[i] != null)
					model.setToInvNo1(toInvNo1[i]);
				if (revAmt[i] != null)
					model.setRevAmt(revAmt[i]);
				if (orgSlpOfcCd[i] != null)
					model.setOrgSlpOfcCd(orgSlpOfcCd[i]);
				if (csrAmt[i] != null)
					model.setCsrAmt(csrAmt[i]);
				if (toInvNo[i] != null)
					model.setToInvNo(toInvNo[i]);
				if (slpLocCd[i] != null)
					model.setSlpLocCd(slpLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchReverseCsrForSubletListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchReverseCsrForSubletListVO[]
	 */
	public SearchReverseCsrForSubletListVO[] getSearchReverseCsrForSubletListVOs(){
		SearchReverseCsrForSubletListVO[] vos = (SearchReverseCsrForSubletListVO[])models.toArray(new SearchReverseCsrForSubletListVO[models.size()]);
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
		this.orgSlpFuncCd = this.orgSlpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletSrcTpCd = this.fletSrcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpFuncCd = this.slpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc = this.csrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCurrCd = this.csrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgIssDt = this.orgIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdEffDt = this.vvdEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd = this.ctrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc1 = this.csrDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpSerNo = this.orgSlpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc2 = this.csrDesc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpTpCd = this.orgSlpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdExpDt = this.vvdExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc4 = this.csrDesc4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc3 = this.csrDesc3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpOfcCd = this.slpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssDt = this.slpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toInvNo1 = this.toInvNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAmt = this.revAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpOfcCd = this.orgSlpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toInvNo = this.toInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpLocCd = this.slpLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
