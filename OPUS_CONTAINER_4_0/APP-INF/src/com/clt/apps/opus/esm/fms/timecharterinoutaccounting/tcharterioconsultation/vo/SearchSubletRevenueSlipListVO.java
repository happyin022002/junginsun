/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSubletRevenueSlipListVO.java
*@FileTitle : SearchSubletRevenueSlipListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.07.02 최우석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo;

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
 * @author 최우석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSubletRevenueSlipListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSubletRevenueSlipListVO> models = new ArrayList<SearchSubletRevenueSlipListVO>();
	
	/* Column Info */
	private String slpFuncCd = null;
	/* Column Info */
	private String trnsCurrCd = null;
	/* Column Info */
	private String csrCurrCd = null;
	/* Column Info */
	private String csrDesc = null;
	/* Column Info */
	private String invSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvdEffDt = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String csrDesc1 = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String csrDesc2 = null;
	/* Column Info */
	private String slpTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String trnsAmt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String vvdExpDt = null;
	/* Column Info */
	private String slpSeqNo = null;
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
	private String creUsrId = null;
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
	
	public SearchSubletRevenueSlipListVO() {}

	public SearchSubletRevenueSlipListVO(String ibflag, String pagerows, String acctCd, String custCntCd, String custSeq, String ctrCd, String slpLocCd, String effDt, String csrAmt, String slpTpCd, String slpFuncCd, String slpOfcCd, String slpSeqNo, String csrCurrCd, String trnsCurrCd, String trnsAmt, String invSeq, String slpIssDt, String csrDesc, String csrDesc1, String csrDesc2, String csrDesc3, String vvdCd, String toInvNo, String toInvNo1, String vvdEffDt, String vvdExpDt, String csrNo, String creUsrId, String updUsrId) {
		this.slpFuncCd = slpFuncCd;
		this.trnsCurrCd = trnsCurrCd;
		this.csrCurrCd = csrCurrCd;
		this.csrDesc = csrDesc;
		this.invSeq = invSeq;
		this.pagerows = pagerows;
		this.vvdEffDt = vvdEffDt;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.ctrCd = ctrCd;
		this.vvdCd = vvdCd;
		this.csrDesc1 = csrDesc1;
		this.acctCd = acctCd;
		this.csrDesc2 = csrDesc2;
		this.slpTpCd = slpTpCd;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.trnsAmt = trnsAmt;
		this.csrNo = csrNo;
		this.vvdExpDt = vvdExpDt;
		this.slpSeqNo = slpSeqNo;
		this.csrDesc3 = csrDesc3;
		this.custSeq = custSeq;
		this.slpOfcCd = slpOfcCd;
		this.slpIssDt = slpIssDt;
		this.toInvNo1 = toInvNo1;
		this.creUsrId = creUsrId;
		this.csrAmt = csrAmt;
		this.toInvNo = toInvNo;
		this.slpLocCd = slpLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("slp_func_cd", getSlpFuncCd());
		this.hashColumns.put("trns_curr_cd", getTrnsCurrCd());
		this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
		this.hashColumns.put("csr_desc", getCsrDesc());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd_eff_dt", getVvdEffDt());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctr_cd", getCtrCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("csr_desc1", getCsrDesc1());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("csr_desc2", getCsrDesc2());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("trns_amt", getTrnsAmt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("vvd_exp_dt", getVvdExpDt());
		this.hashColumns.put("slp_seq_no", getSlpSeqNo());
		this.hashColumns.put("csr_desc3", getCsrDesc3());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
		this.hashColumns.put("slp_iss_dt", getSlpIssDt());
		this.hashColumns.put("to_inv_no1", getToInvNo1());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
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
		this.hashFields.put("slp_func_cd", "slpFuncCd");
		this.hashFields.put("trns_curr_cd", "trnsCurrCd");
		this.hashFields.put("csr_curr_cd", "csrCurrCd");
		this.hashFields.put("csr_desc", "csrDesc");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd_eff_dt", "vvdEffDt");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("csr_desc1", "csrDesc1");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("csr_desc2", "csrDesc2");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("trns_amt", "trnsAmt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("vvd_exp_dt", "vvdExpDt");
		this.hashFields.put("slp_seq_no", "slpSeqNo");
		this.hashFields.put("csr_desc3", "csrDesc3");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("slp_ofc_cd", "slpOfcCd");
		this.hashFields.put("slp_iss_dt", "slpIssDt");
		this.hashFields.put("to_inv_no1", "toInvNo1");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("csr_amt", "csrAmt");
		this.hashFields.put("to_inv_no", "toInvNo");
		this.hashFields.put("slp_loc_cd", "slpLocCd");
		return this.hashFields;
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
	 * @return trnsCurrCd
	 */
	public String getTrnsCurrCd() {
		return this.trnsCurrCd;
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
	 * @return csrDesc
	 */
	public String getCsrDesc() {
		return this.csrDesc;
	}
	
	/**
	 * Column Info
	 * @return invSeq
	 */
	public String getInvSeq() {
		return this.invSeq;
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
	 * @return vvdEffDt
	 */
	public String getVvdEffDt() {
		return this.vvdEffDt;
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
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
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
	 * @return slpTpCd
	 */
	public String getSlpTpCd() {
		return this.slpTpCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return trnsAmt
	 */
	public String getTrnsAmt() {
		return this.trnsAmt;
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
	 * @return slpSeqNo
	 */
	public String getSlpSeqNo() {
		return this.slpSeqNo;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @param slpFuncCd
	 */
	public void setSlpFuncCd(String slpFuncCd) {
		this.slpFuncCd = slpFuncCd;
	}
	
	/**
	 * Column Info
	 * @param trnsCurrCd
	 */
	public void setTrnsCurrCd(String trnsCurrCd) {
		this.trnsCurrCd = trnsCurrCd;
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
	 * @param csrDesc
	 */
	public void setCsrDesc(String csrDesc) {
		this.csrDesc = csrDesc;
	}
	
	/**
	 * Column Info
	 * @param invSeq
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
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
	 * @param vvdEffDt
	 */
	public void setVvdEffDt(String vvdEffDt) {
		this.vvdEffDt = vvdEffDt;
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
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
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
	 * @param slpTpCd
	 */
	public void setSlpTpCd(String slpTpCd) {
		this.slpTpCd = slpTpCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param trnsAmt
	 */
	public void setTrnsAmt(String trnsAmt) {
		this.trnsAmt = trnsAmt;
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
	 * @param slpSeqNo
	 */
	public void setSlpSeqNo(String slpSeqNo) {
		this.slpSeqNo = slpSeqNo;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
		setSlpFuncCd(JSPUtil.getParameter(request, "slp_func_cd", ""));
		setTrnsCurrCd(JSPUtil.getParameter(request, "trns_curr_cd", ""));
		setCsrCurrCd(JSPUtil.getParameter(request, "csr_curr_cd", ""));
		setCsrDesc(JSPUtil.getParameter(request, "csr_desc", ""));
		setInvSeq(JSPUtil.getParameter(request, "inv_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvdEffDt(JSPUtil.getParameter(request, "vvd_eff_dt", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCtrCd(JSPUtil.getParameter(request, "ctr_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setCsrDesc1(JSPUtil.getParameter(request, "csr_desc1", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setCsrDesc2(JSPUtil.getParameter(request, "csr_desc2", ""));
		setSlpTpCd(JSPUtil.getParameter(request, "slp_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setTrnsAmt(JSPUtil.getParameter(request, "trns_amt", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setVvdExpDt(JSPUtil.getParameter(request, "vvd_exp_dt", ""));
		setSlpSeqNo(JSPUtil.getParameter(request, "slp_seq_no", ""));
		setCsrDesc3(JSPUtil.getParameter(request, "csr_desc3", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setSlpOfcCd(JSPUtil.getParameter(request, "slp_ofc_cd", ""));
		setSlpIssDt(JSPUtil.getParameter(request, "slp_iss_dt", ""));
		setToInvNo1(JSPUtil.getParameter(request, "to_inv_no1", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCsrAmt(JSPUtil.getParameter(request, "csr_amt", ""));
		setToInvNo(JSPUtil.getParameter(request, "to_inv_no", ""));
		setSlpLocCd(JSPUtil.getParameter(request, "slp_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSubletRevenueSlipListVO[]
	 */
	public SearchSubletRevenueSlipListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSubletRevenueSlipListVO[]
	 */
	public SearchSubletRevenueSlipListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSubletRevenueSlipListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] slpFuncCd = (JSPUtil.getParameter(request, prefix	+ "slp_func_cd", length));
			String[] trnsCurrCd = (JSPUtil.getParameter(request, prefix	+ "trns_curr_cd", length));
			String[] csrCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_curr_cd", length));
			String[] csrDesc = (JSPUtil.getParameter(request, prefix	+ "csr_desc", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvdEffDt = (JSPUtil.getParameter(request, prefix	+ "vvd_eff_dt", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrCd = (JSPUtil.getParameter(request, prefix	+ "ctr_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] csrDesc1 = (JSPUtil.getParameter(request, prefix	+ "csr_desc1", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] csrDesc2 = (JSPUtil.getParameter(request, prefix	+ "csr_desc2", length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] trnsAmt = (JSPUtil.getParameter(request, prefix	+ "trns_amt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] vvdExpDt = (JSPUtil.getParameter(request, prefix	+ "vvd_exp_dt", length));
			String[] slpSeqNo = (JSPUtil.getParameter(request, prefix	+ "slp_seq_no", length));
			String[] csrDesc3 = (JSPUtil.getParameter(request, prefix	+ "csr_desc3", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] slpOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_ofc_cd", length));
			String[] slpIssDt = (JSPUtil.getParameter(request, prefix	+ "slp_iss_dt", length));
			String[] toInvNo1 = (JSPUtil.getParameter(request, prefix	+ "to_inv_no1", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt", length));
			String[] toInvNo = (JSPUtil.getParameter(request, prefix	+ "to_inv_no", length));
			String[] slpLocCd = (JSPUtil.getParameter(request, prefix	+ "slp_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSubletRevenueSlipListVO();
				if (slpFuncCd[i] != null)
					model.setSlpFuncCd(slpFuncCd[i]);
				if (trnsCurrCd[i] != null)
					model.setTrnsCurrCd(trnsCurrCd[i]);
				if (csrCurrCd[i] != null)
					model.setCsrCurrCd(csrCurrCd[i]);
				if (csrDesc[i] != null)
					model.setCsrDesc(csrDesc[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvdEffDt[i] != null)
					model.setVvdEffDt(vvdEffDt[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrCd[i] != null)
					model.setCtrCd(ctrCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (csrDesc1[i] != null)
					model.setCsrDesc1(csrDesc1[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (csrDesc2[i] != null)
					model.setCsrDesc2(csrDesc2[i]);
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (trnsAmt[i] != null)
					model.setTrnsAmt(trnsAmt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (vvdExpDt[i] != null)
					model.setVvdExpDt(vvdExpDt[i]);
				if (slpSeqNo[i] != null)
					model.setSlpSeqNo(slpSeqNo[i]);
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
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
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
		return getSearchSubletRevenueSlipListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSubletRevenueSlipListVO[]
	 */
	public SearchSubletRevenueSlipListVO[] getSearchSubletRevenueSlipListVOs(){
		SearchSubletRevenueSlipListVO[] vos = (SearchSubletRevenueSlipListVO[])models.toArray(new SearchSubletRevenueSlipListVO[models.size()]);
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
		this.slpFuncCd = this.slpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsCurrCd = this.trnsCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCurrCd = this.csrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc = this.csrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdEffDt = this.vvdEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd = this.ctrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc1 = this.csrDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc2 = this.csrDesc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsAmt = this.trnsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdExpDt = this.vvdExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSeqNo = this.slpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc3 = this.csrDesc3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpOfcCd = this.slpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssDt = this.slpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toInvNo1 = this.toInvNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toInvNo = this.toInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpLocCd = this.slpLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
