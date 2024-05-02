/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CondSearchPrepaymentSettleListVO.java
*@FileTitle : CondSearchPrepaymentSettleListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.07.22 윤세영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo;

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
 * @author 윤세영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CondSearchPrepaymentSettleListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CondSearchPrepaymentSettleListVO> models = new ArrayList<CondSearchPrepaymentSettleListVO>();
	
	// Retrieve Param
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String payDate = null;
	/* Column Info */
	private String effDate = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String effDateFrom = null;
	/* Column Info */
	private String effDateTo = null;
	/* Page Number */
	private String pagerows = null;

	// Creation Param
	
	/* Column Info */
	private String orgSlipNo = null;
	/* Column Info */
	private String newCsrNo = null;
	/* Column Info */
	private String rsRemark = null;
	/* Column Info */
	private String slpDesc = null;
	/* Column Info */
	private String orgSlpTpCd = null;
	/* Column Info */
	private String orgSlpFuncCd = null;
	/* Column Info */
	private String orgSlpOfcCd = null;
	/* Column Info */
	private String orgSlpIssDt = null;
	/* Column Info */
	private String orgSlpSerNo = null;
	/* Column Info */
	private String orgSlpSeqNo = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String csrCurrCd = null;
	/* Column Info */
	private String slpAmt = null;
	/* Column Info */
	private String ctrCd = null;
	/* Column Info */
	private String slpLocCd = null;
	/* Column Info */
	private String vvdEffDt = null;
	/* Column Info */
	private String vvdExpDt = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String ppayHirNo = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CondSearchPrepaymentSettleListVO() {}

	public CondSearchPrepaymentSettleListVO(String ibflag, String pagerows, String payDate, String effDate, String vslCd, String effDateFrom, String effDateTo, String orgSlipNo, String newCsrNo, String rsRemark
			, String slpDesc, String orgSlpTpCd, String orgSlpFuncCd, String orgSlpOfcCd, String orgSlpIssDt, String orgSlpSerNo, String orgSlpSeqNo, String acctCd, String csrCurrCd, String slpAmt, String ctrCd, String slpLocCd
			, String vvdEffDt, String vvdExpDt, String invSeq, String vvdCd, String fletCtrtNo, String vndrSeq, String effDt, String ppayHirNo) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.payDate = payDate;
		this.effDate = effDate;
		this.vslCd = vslCd;
		this.effDateFrom = effDateFrom;
		this.effDateTo = effDateTo;
		
		this.orgSlipNo = orgSlipNo;
		this.newCsrNo = newCsrNo;
		this.rsRemark = rsRemark;
		this.slpDesc = slpDesc;
		this.orgSlpTpCd = orgSlpTpCd;
		this.orgSlpFuncCd = orgSlpFuncCd;
		this.orgSlpOfcCd = orgSlpOfcCd;
		this.orgSlpIssDt = orgSlpIssDt;
		this.orgSlpSerNo = orgSlpSerNo;
		this.orgSlpSeqNo = orgSlpSeqNo;
		this.acctCd = acctCd;
		this.csrCurrCd = csrCurrCd;
		this.slpAmt = slpAmt;
		this.ctrCd = ctrCd;
		this.slpLocCd = slpLocCd;
		this.vvdEffDt = vvdEffDt;
		this.vvdExpDt = vvdExpDt;
		this.invSeq = invSeq;
		this.vvdCd = vvdCd;
		this.fletCtrtNo = fletCtrtNo;
		this.vndrSeq = vndrSeq;
		this.effDt = effDt;
		this.ppayHirNo = ppayHirNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pay_date", getPayDate());
		this.hashColumns.put("eff_date", getEffDate());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("eff_date_from", getEffDateFrom());
		this.hashColumns.put("eff_date_to", getEffDateTo());
		
		this.hashColumns.put("org_slip_no", getOrgSlipNo() );
		this.hashColumns.put("new_csr_no", getNewCsrNo() );
		this.hashColumns.put("rs_remark", getRsRemark() );
		this.hashColumns.put("slp_desc", getSlpDesc() );
		this.hashColumns.put("org_slp_tp_cd", getOrgSlpTpCd() );
		this.hashColumns.put("org_slp_func_cd", getOrgSlpFuncCd() );
		this.hashColumns.put("org_slp_ofc_cd", getOrgSlpOfcCd() );
		this.hashColumns.put("org_slp_iss_dt", getOrgSlpIssDt() );
		this.hashColumns.put("org_slp_ser_no", getOrgSlpSerNo() );
		this.hashColumns.put("org_slp_seq_no", getOrgSlpSeqNo() );
		this.hashColumns.put("acct_cd", getAcctCd() );
		this.hashColumns.put("csr_curr_cd", getCsrCurrCd() );
		this.hashColumns.put("slp_amt", getSlpAmt() );
		this.hashColumns.put("ctr_cd", getCtrCd() );
		this.hashColumns.put("slp_loc_cd", getSlpLocCd() );
		this.hashColumns.put("vvd_eff_dt", getVvdEffDt() );
		this.hashColumns.put("vvd_exp_dt", getVvdExpDt() );
		this.hashColumns.put("inv_seq", getInvSeq() );
		this.hashColumns.put("vvd_cd", getVvdCd() );
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo() );
		this.hashColumns.put("vndr_seq", getVndrSeq() );
		this.hashColumns.put("eff_dt", getEffDt() );
		this.hashColumns.put("ppay_hir_no", getPpayHirNo() );
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pay_date", "payDate");
		this.hashFields.put("eff_date", "effDate");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("eff_date_from", "effDateFrom");
		this.hashFields.put("eff_date_to", "effDateTo");

		this.hashFields.put("org_slip_no", "orgSlipNo");
		this.hashFields.put("new_csr_no", "newCsrNo");
		this.hashFields.put("rs_remark", "rsRemark");
		this.hashFields.put("slp_desc", "slpDesc");
		this.hashFields.put("org_slp_tp_cd", "orgSlpTpCd");
		this.hashFields.put("org_slp_func_cd", "orgSlpFuncCd");
		this.hashFields.put("org_slp_ofc_cd", "orgSlpOfcCd");
		this.hashFields.put("org_slp_iss_dt", "orgSlpIssDt");
		this.hashFields.put("org_slp_ser_no", "orgSlpSerNo");
		this.hashFields.put("org_slp_seq_no", "orgSlpSeqNo");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("csr_curr_cd", "csrCurrCd");
		this.hashFields.put("slp_amt", "slpAmt");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("slp_loc_cd", "slpLocCd");
		this.hashFields.put("vvd_eff_dt", "vvdEffDt");
		this.hashFields.put("vvd_exp_dt", "vvdExpDt");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo" );
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ppay_hir_no", "ppayHirNo");
		return this.hashFields;
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
	 * @return payDate
	 */
	public String getPayDate() {
		return this.payDate;
	}
	
	/**
	 * Column Info
	 * @return effDate
	 */
	public String getEffDate() {
		return this.effDate;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return effDateFrom
	 */
	public String getEffDateFrom() {
		return this.effDateFrom;
	}
	
	/**
	 * Column Info
	 * @return effDateTo
	 */
	public String getEffDateTo() {
		return this.effDateTo;
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
	 * @return orgSlipNo
	 */
	public String getOrgSlipNo() {
		return orgSlipNo;
	}
	
	/**
	 * Column Info
	 * @return newCsrNo
	 */
	public String getNewCsrNo() {
		return newCsrNo;
	}

	/**
	 * Column Info
	 * @return rsRemark
	 */
	public String getRsRemark() {
		return rsRemark;
	}

	/**
	 * Column Info
	 * @return slpDesc
	 */
	public String getSlpDesc() {
		return slpDesc;
	}

	/**
	 * Column Info
	 * @return orgSlpTpCd
	 */
	public String getOrgSlpTpCd() {
		return orgSlpTpCd;
	}

	/**
	 * Column Info
	 * @return orgSlpFuncCd
	 */
	public String getOrgSlpFuncCd() {
		return orgSlpFuncCd;
	}

	/**
	 * Column Info
	 * @return orgSlpOfcCd
	 */
	public String getOrgSlpOfcCd() {
		return orgSlpOfcCd;
	}

	/**
	 * Column Info
	 * @return orgSlpIssDt
	 */
	public String getOrgSlpIssDt() {
		return orgSlpIssDt;
	}

	/**
	 * Column Info
	 * @return orgSlpSerNo
	 */
	public String getOrgSlpSerNo() {
		return orgSlpSerNo;
	}

	/**
	 * Column Info
	 * @return orgSlpSeqNo
	 */
	public String getOrgSlpSeqNo() {
		return orgSlpSeqNo;
	}

	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return acctCd;
	}

	/**
	 * Column Info
	 * @return csrCurrCd
	 */
	public String getCsrCurrCd() {
		return csrCurrCd;
	}

	/**
	 * Column Info
	 * @return slpAmt
	 */
	public String getSlpAmt() {
		return slpAmt;
	}

	/**
	 * Column Info
	 * @return ctrCd
	 */
	public String getCtrCd() {
		return ctrCd;
	}

	/**
	 * Column Info
	 * @return slpLocCd
	 */
	public String getSlpLocCd() {
		return slpLocCd;
	}

	/**
	 * Column Info
	 * @return vvdEffDt
	 */
	public String getVvdEffDt() {
		return vvdEffDt;
	}

	/**
	 * Column Info
	 * @return vvdExpDt
	 */
	public String getVvdExpDt() {
		return vvdExpDt;
	}

	/**
	 * Column Info
	 * @return invSeq
	 */
	public String getInvSeq() {
		return invSeq;
	}

	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return vvdCd;
	}

	/**
	 * Column Info
	 * @return fletCtrtNo
	 */
	public String getFletCtrtNo() {
		return fletCtrtNo;
	}

	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return vndrSeq;
	}

	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return effDt;
	}

	/**
	 * Column Info
	 * @return ppayHirNo
	 */
	public String getPpayHirNo() {
		return ppayHirNo;
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
	 * @param payDate
	 */
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	
	/**
	 * Column Info
	 * @param effDate
	 */
	public void setEffDate(String effDate) {
		this.effDate = effDate;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param effDateFrom
	 */
	public void setEffDateFrom(String effDateFrom) {
		this.effDateFrom = effDateFrom;
	}
	
	/**
	 * Column Info
	 * @param effDateTo
	 */
	public void setEffDateTo(String effDateTo) {
		this.effDateTo = effDateTo;
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
	 * @param orgSlipNo
	 */
	public void setOrgSlipNo(String orgSlipNo) {
		this.orgSlipNo = orgSlipNo;
	}

	/**
	 * Column Info
	 * @param newCsrNo
	 */
	public void setNewCsrNo(String newCsrNo) {
		this.newCsrNo = newCsrNo;
	}

	/**
	 * Column Info
	 * @param rsRemark
	 */
	public void setRsRemark(String rsRemark) {
		this.rsRemark = rsRemark;
	}

	/**
	 * Column Info
	 * @param slpDesc
	 */
	public void setSlpDesc(String slpDesc) {
		this.slpDesc = slpDesc;
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
	 * @param orgSlpFuncCd
	 */
	public void setOrgSlpFuncCd(String orgSlpFuncCd) {
		this.orgSlpFuncCd = orgSlpFuncCd;
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
	 * @param orgSlpIssDt
	 */
	public void setOrgSlpIssDt(String orgSlpIssDt) {
		this.orgSlpIssDt = orgSlpIssDt;
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
	 * @param orgSlpSeqNo
	 */
	public void setOrgSlpSeqNo(String orgSlpSeqNo) {
		this.orgSlpSeqNo = orgSlpSeqNo;
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
	 * @param csrCurrCd
	 */
	public void setCsrCurrCd(String csrCurrCd) {
		this.csrCurrCd = csrCurrCd;
	}

	/**
	 * Column Info
	 * @param slpAmt
	 */
	public void setSlpAmt(String slpAmt) {
		this.slpAmt = slpAmt;
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
	 * @param slpLocCd
	 */
	public void setSlpLocCd(String slpLocCd) {
		this.slpLocCd = slpLocCd;
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
	 * @param vvdExpDt
	 */
	public void setVvdExpDt(String vvdExpDt) {
		this.vvdExpDt = vvdExpDt;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}

	/**
	 * Column Info
	 * @param fletCtrtNo
	 */
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}

	/**
	 * Column Info
	 * @param ppayHirNo
	 */
	public void setPpayHirNo(String ppayHirNo) {
		this.ppayHirNo = ppayHirNo;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPayDate(JSPUtil.getParameter(request, "pay_date", ""));
		setEffDate(JSPUtil.getParameter(request, "eff_date", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setEffDateFrom(JSPUtil.getParameter(request, "eff_date_from", ""));
		setEffDateTo(JSPUtil.getParameter(request, "eff_date_to", ""));
		
		setOrgSlipNo(JSPUtil.getParameter(request, "org_slip_no", ""));
		setNewCsrNo(JSPUtil.getParameter(request, "new_csr_no", ""));
		setRsRemark(JSPUtil.getParameter(request, "rs_remark", ""));
		setSlpDesc(JSPUtil.getParameter(request, "slp_desc", ""));
		setOrgSlpTpCd(JSPUtil.getParameter(request, "org_slp_tp_cd", ""));
		setOrgSlpFuncCd(JSPUtil.getParameter(request, "org_slp_func_cd", ""));
		setOrgSlpOfcCd(JSPUtil.getParameter(request, "org_slp_ofc_cd", ""));
		setOrgSlpIssDt(JSPUtil.getParameter(request, "org_slp_iss_dt", ""));
		setOrgSlpSerNo(JSPUtil.getParameter(request, "org_slp_ser_no", ""));
		setOrgSlpSeqNo(JSPUtil.getParameter(request, "org_slp_seq_no", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setCsrCurrCd(JSPUtil.getParameter(request, "csr_curr_cd", ""));
		setSlpAmt(JSPUtil.getParameter(request, "slp_amt", ""));
		setCtrCd(JSPUtil.getParameter(request, "ctr_cd", ""));
		setSlpLocCd(JSPUtil.getParameter(request, "slp_loc_cd", ""));
		setVvdEffDt(JSPUtil.getParameter(request, "vvd_eff_dt", ""));
		setVvdExpDt(JSPUtil.getParameter(request, "vvd_exp_dt", ""));
		setInvSeq(JSPUtil.getParameter(request, "inv_seq", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setPpayHirNo(JSPUtil.getParameter(request, "ppay_hir_no", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CondSearchPrepaymentSettleListVO[]
	 */
	public CondSearchPrepaymentSettleListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CondSearchPrepaymentSettleListVO[]
	 */
	public CondSearchPrepaymentSettleListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CondSearchPrepaymentSettleListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] payDate = (JSPUtil.getParameter(request, prefix	+ "pay_date", length));
			String[] effDate = (JSPUtil.getParameter(request, prefix	+ "eff_date", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] effDateFrom = (JSPUtil.getParameter(request, prefix	+ "eff_date_from", length));
			String[] effDateTo = (JSPUtil.getParameter(request, prefix	+ "eff_date_to", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			String[] orgSlipNo = (JSPUtil.getParameter(request, prefix	+ "org_slip_no", length));
			String[] newCsrNo = (JSPUtil.getParameter(request, prefix	+ "new_csr_no", length));
			String[] rsRemark = (JSPUtil.getParameter(request, prefix	+ "rs_remark", length));
			String[] slpDesc = (JSPUtil.getParameter(request, prefix	+ "slp_desc", length));
			String[] orgSlpTpCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_tp_cd", length));
			String[] orgSlpFuncCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_func_cd", length));
			String[] orgSlpOfcCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_ofc_cd", length));
			String[] orgSlpIssDt = (JSPUtil.getParameter(request, prefix	+ "org_slp_iss_dt", length));
			String[] orgSlpSerNo = (JSPUtil.getParameter(request, prefix	+ "org_slp_ser_no", length));
			String[] orgSlpSeqNo = (JSPUtil.getParameter(request, prefix	+ "org_slp_seq_no", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] csrCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_curr_cd", length));
			String[] slpAmt = (JSPUtil.getParameter(request, prefix	+ "slp_amt", length));
			String[] ctrCd = (JSPUtil.getParameter(request, prefix	+ "ctr_cd", length));
			String[] slpLocCd = (JSPUtil.getParameter(request, prefix	+ "slp_loc_cd", length));
			String[] vvdEffDt = (JSPUtil.getParameter(request, prefix	+ "vvd_eff_dt", length));
			String[] vvdExpDt = (JSPUtil.getParameter(request, prefix	+ "vvd_exp_dt", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ppayHirNo = (JSPUtil.getParameter(request, prefix	+ "ppay_hir_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CondSearchPrepaymentSettleListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (payDate[i] != null)
					model.setPayDate(payDate[i]);
				if (effDate[i] != null)
					model.setEffDate(effDate[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (effDateFrom[i] != null)
					model.setEffDateFrom(effDateFrom[i]);
				if (effDateTo[i] != null)
					model.setEffDateTo(effDateTo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				
				if (orgSlipNo[i] != null)
					model.setOrgSlipNo(orgSlipNo[i]);
				if (newCsrNo[i] != null)
					model.setNewCsrNo(newCsrNo[i]);
				if (rsRemark[i] != null)
					model.setRsRemark(rsRemark[i]);
				if (slpDesc[i] != null)
					model.setSlpDesc(slpDesc[i]);
				if (orgSlpTpCd[i] != null)
					model.setOrgSlpTpCd(orgSlpTpCd[i]);
				if (orgSlpFuncCd[i] != null)
					model.setOrgSlpFuncCd(orgSlpFuncCd[i]);
				if (orgSlpOfcCd[i] != null)
					model.setOrgSlpOfcCd(orgSlpOfcCd[i]);
				if (orgSlpIssDt[i] != null)
					model.setOrgSlpIssDt(orgSlpIssDt[i]);
				if (orgSlpSerNo[i] != null)
					model.setOrgSlpSerNo(orgSlpSerNo[i]);
				if (orgSlpSeqNo[i] != null)
					model.setOrgSlpSeqNo(orgSlpSeqNo[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (csrCurrCd[i] != null)
					model.setCsrCurrCd(csrCurrCd[i]);
				if (slpAmt[i] != null)
					model.setSlpAmt(slpAmt[i]);
				if (ctrCd[i] != null)
					model.setCtrCd(ctrCd[i]);
				if (slpLocCd[i] != null)
					model.setSlpLocCd(slpLocCd[i]);
				if (vvdEffDt[i] != null)
					model.setVvdEffDt(vvdEffDt[i]);
				if (vvdExpDt[i] != null)
					model.setVvdExpDt(vvdExpDt[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ppayHirNo[i] != null)
					model.setPpayHirNo(ppayHirNo[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCondSearchPrepaymentSettleListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CondSearchPrepaymentSettleListVO[]
	 */
	public CondSearchPrepaymentSettleListVO[] getCondSearchPrepaymentSettleListVOs(){
		CondSearchPrepaymentSettleListVO[] vos = (CondSearchPrepaymentSettleListVO[])models.toArray(new CondSearchPrepaymentSettleListVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDate = this.payDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDate = this.effDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDateFrom = this.effDateFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDateTo = this.effDateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.orgSlipNo = this.orgSlipNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCsrNo = this.newCsrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsRemark = this.rsRemark.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpDesc = this.slpDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpTpCd = this.orgSlpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpFuncCd = this.orgSlpFuncCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpOfcCd = this.orgSlpOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpIssDt = this.orgSlpIssDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpSerNo = this.orgSlpSerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpSeqNo = this.orgSlpSeqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCurrCd = this.csrCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpAmt = this.slpAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd = this.ctrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpLocCd = this.slpLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdEffDt = this.vvdEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdExpDt = this.vvdExpDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppayHirNo = this.ppayHirNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
