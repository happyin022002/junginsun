/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CsrManagerListCondVO.java
*@FileTitle : CsrManagerListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.28
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.05.28 진윤오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.claiminvoice.paymentinvoice.vo;

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
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CsrManagerListCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CsrManagerListCondVO> models = new ArrayList<CsrManagerListCondVO>();
	
	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String aftActFlg = null;
	/* Column Info */
	private String csrCurrCd = null;
	/* Column Info */
	private String invIssDt = null;
	/* Column Info */
	private String noOfInv = null;
	/* Column Info */
	private String ifErrRsn = null;
	/* Column Info */
	private String invRcvDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invDesc = null;
	/* Column Info */
	private String attrCtnt2 = null;
	/* Column Info */
	private String vndrNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invStsCd = null;
	/* Column Info */
	private String searchCsrNo = null;
	/* Column Info */
	private String fmEffDt = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String rcvErrFlg = null;
	/* Column Info */
	private String vndrTermNm = null;
	/* Column Info */
	private String payGrpLuCd = null;
	/* Column Info */
	private String ifStatus = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String ifFlg = null;
	/* Column Info */
	private String toEffDt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String aproRqstNo = null;
	/* Column Info */
	private String dtStatus = null;
	/* Column Info */
	private String invSubSysCd = null;
	/* Column Info */
	private String csrAmt = null;
	/* Column Info */
	private String clmAreaCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CsrManagerListCondVO() {}

	public CsrManagerListCondVO(String ibflag, String pagerows, String ifDt, String aftActFlg, String csrCurrCd, String invIssDt, String ifErrRsn, String noOfInv, String invRcvDt, String vndrNo, String attrCtnt2, String invDesc, String invStsCd, String searchCsrNo, String fmEffDt, String dueDt, String updUsrId, String csrNo, String rcvErrFlg, String vndrTermNm, String payGrpLuCd, String ifStatus, String costOfcCd, String ifFlg, String toEffDt, String ofcCd, String aproRqstNo, String invSubSysCd, String dtStatus, String csrAmt, String clmAreaCd) {
		this.ifDt = ifDt;
		this.aftActFlg = aftActFlg;
		this.csrCurrCd = csrCurrCd;
		this.invIssDt = invIssDt;
		this.noOfInv = noOfInv;
		this.ifErrRsn = ifErrRsn;
		this.invRcvDt = invRcvDt;
		this.pagerows = pagerows;
		this.invDesc = invDesc;
		this.attrCtnt2 = attrCtnt2;
		this.vndrNo = vndrNo;
		this.ibflag = ibflag;
		this.invStsCd = invStsCd;
		this.searchCsrNo = searchCsrNo;
		this.fmEffDt = fmEffDt;
		this.dueDt = dueDt;
		this.updUsrId = updUsrId;
		this.csrNo = csrNo;
		this.rcvErrFlg = rcvErrFlg;
		this.vndrTermNm = vndrTermNm;
		this.payGrpLuCd = payGrpLuCd;
		this.ifStatus = ifStatus;
		this.costOfcCd = costOfcCd;
		this.ifFlg = ifFlg;
		this.toEffDt = toEffDt;
		this.ofcCd = ofcCd;
		this.aproRqstNo = aproRqstNo;
		this.dtStatus = dtStatus;
		this.invSubSysCd = invSubSysCd;
		this.csrAmt = csrAmt;
		this.clmAreaCd = clmAreaCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("if_dt", getIfDt());
		this.hashColumns.put("aft_act_flg", getAftActFlg());
		this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
		this.hashColumns.put("inv_iss_dt", getInvIssDt());
		this.hashColumns.put("no_of_inv", getNoOfInv());
		this.hashColumns.put("if_err_rsn", getIfErrRsn());
		this.hashColumns.put("inv_rcv_dt", getInvRcvDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_desc", getInvDesc());
		this.hashColumns.put("attr_ctnt2", getAttrCtnt2());
		this.hashColumns.put("vndr_no", getVndrNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_sts_cd", getInvStsCd());
		this.hashColumns.put("search_csr_no", getSearchCsrNo());
		this.hashColumns.put("fm_eff_dt", getFmEffDt());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("rcv_err_flg", getRcvErrFlg());
		this.hashColumns.put("vndr_term_nm", getVndrTermNm());
		this.hashColumns.put("pay_grp_lu_cd", getPayGrpLuCd());
		this.hashColumns.put("if_status", getIfStatus());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("if_flg", getIfFlg());
		this.hashColumns.put("to_eff_dt", getToEffDt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("apro_rqst_no", getAproRqstNo());
		this.hashColumns.put("dt_status", getDtStatus());
		this.hashColumns.put("inv_sub_sys_cd", getInvSubSysCd());
		this.hashColumns.put("csr_amt", getCsrAmt());
		this.hashColumns.put("clm_area_cd", getClmAreaCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("aft_act_flg", "aftActFlg");
		this.hashFields.put("csr_curr_cd", "csrCurrCd");
		this.hashFields.put("inv_iss_dt", "invIssDt");
		this.hashFields.put("no_of_inv", "noOfInv");
		this.hashFields.put("if_err_rsn", "ifErrRsn");
		this.hashFields.put("inv_rcv_dt", "invRcvDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("attr_ctnt2", "attrCtnt2");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_sts_cd", "invStsCd");
		this.hashFields.put("search_csr_no", "searchCsrNo");
		this.hashFields.put("fm_eff_dt", "fmEffDt");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("rcv_err_flg", "rcvErrFlg");
		this.hashFields.put("vndr_term_nm", "vndrTermNm");
		this.hashFields.put("pay_grp_lu_cd", "payGrpLuCd");
		this.hashFields.put("if_status", "ifStatus");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("if_flg", "ifFlg");
		this.hashFields.put("to_eff_dt", "toEffDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("apro_rqst_no", "aproRqstNo");
		this.hashFields.put("dt_status", "dtStatus");
		this.hashFields.put("inv_sub_sys_cd", "invSubSysCd");
		this.hashFields.put("csr_amt", "csrAmt");
		this.hashFields.put("clm_area_cd", "clmAreaCd");
		return this.hashFields;
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
	 * @return aftActFlg
	 */
	public String getAftActFlg() {
		return this.aftActFlg;
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
	 * @return invIssDt
	 */
	public String getInvIssDt() {
		return this.invIssDt;
	}
	
	/**
	 * Column Info
	 * @return noOfInv
	 */
	public String getNoOfInv() {
		return this.noOfInv;
	}
	
	/**
	 * Column Info
	 * @return ifErrRsn
	 */
	public String getIfErrRsn() {
		return this.ifErrRsn;
	}
	
	/**
	 * Column Info
	 * @return invRcvDt
	 */
	public String getInvRcvDt() {
		return this.invRcvDt;
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
	 * @return invDesc
	 */
	public String getInvDesc() {
		return this.invDesc;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt2
	 */
	public String getAttrCtnt2() {
		return this.attrCtnt2;
	}
	
	/**
	 * Column Info
	 * @return vndrNo
	 */
	public String getVndrNo() {
		return this.vndrNo;
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
	 * @return invStsCd
	 */
	public String getInvStsCd() {
		return this.invStsCd;
	}
	
	/**
	 * Column Info
	 * @return searchCsrNo
	 */
	public String getSearchCsrNo() {
		return this.searchCsrNo;
	}
	
	/**
	 * Column Info
	 * @return fmEffDt
	 */
	public String getFmEffDt() {
		return this.fmEffDt;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return rcvErrFlg
	 */
	public String getRcvErrFlg() {
		return this.rcvErrFlg;
	}
	
	/**
	 * Column Info
	 * @return vndrTermNm
	 */
	public String getVndrTermNm() {
		return this.vndrTermNm;
	}
	
	/**
	 * Column Info
	 * @return payGrpLuCd
	 */
	public String getPayGrpLuCd() {
		return this.payGrpLuCd;
	}
	
	/**
	 * Column Info
	 * @return ifStatus
	 */
	public String getIfStatus() {
		return this.ifStatus;
	}
	
	/**
	 * Column Info
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ifFlg
	 */
	public String getIfFlg() {
		return this.ifFlg;
	}
	
	/**
	 * Column Info
	 * @return toEffDt
	 */
	public String getToEffDt() {
		return this.toEffDt;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return aproRqstNo
	 */
	public String getAproRqstNo() {
		return this.aproRqstNo;
	}
	
	/**
	 * Column Info
	 * @return dtStatus
	 */
	public String getDtStatus() {
		return this.dtStatus;
	}
	
	/**
	 * Column Info
	 * @return invSubSysCd
	 */
	public String getInvSubSysCd() {
		return this.invSubSysCd;
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
	 * @return clmAreaCd
	 */
	public String getClmAreaCd() {
		return this.clmAreaCd;
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
	 * @param aftActFlg
	 */
	public void setAftActFlg(String aftActFlg) {
		this.aftActFlg = aftActFlg;
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
	 * @param invIssDt
	 */
	public void setInvIssDt(String invIssDt) {
		this.invIssDt = invIssDt;
	}
	
	/**
	 * Column Info
	 * @param noOfInv
	 */
	public void setNoOfInv(String noOfInv) {
		this.noOfInv = noOfInv;
	}
	
	/**
	 * Column Info
	 * @param ifErrRsn
	 */
	public void setIfErrRsn(String ifErrRsn) {
		this.ifErrRsn = ifErrRsn;
	}
	
	/**
	 * Column Info
	 * @param invRcvDt
	 */
	public void setInvRcvDt(String invRcvDt) {
		this.invRcvDt = invRcvDt;
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
	 * @param invDesc
	 */
	public void setInvDesc(String invDesc) {
		this.invDesc = invDesc;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt2
	 */
	public void setAttrCtnt2(String attrCtnt2) {
		this.attrCtnt2 = attrCtnt2;
	}
	
	/**
	 * Column Info
	 * @param vndrNo
	 */
	public void setVndrNo(String vndrNo) {
		this.vndrNo = vndrNo;
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
	 * @param invStsCd
	 */
	public void setInvStsCd(String invStsCd) {
		this.invStsCd = invStsCd;
	}
	
	/**
	 * Column Info
	 * @param searchCsrNo
	 */
	public void setSearchCsrNo(String searchCsrNo) {
		this.searchCsrNo = searchCsrNo;
	}
	
	/**
	 * Column Info
	 * @param fmEffDt
	 */
	public void setFmEffDt(String fmEffDt) {
		this.fmEffDt = fmEffDt;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param rcvErrFlg
	 */
	public void setRcvErrFlg(String rcvErrFlg) {
		this.rcvErrFlg = rcvErrFlg;
	}
	
	/**
	 * Column Info
	 * @param vndrTermNm
	 */
	public void setVndrTermNm(String vndrTermNm) {
		this.vndrTermNm = vndrTermNm;
	}
	
	/**
	 * Column Info
	 * @param payGrpLuCd
	 */
	public void setPayGrpLuCd(String payGrpLuCd) {
		this.payGrpLuCd = payGrpLuCd;
	}
	
	/**
	 * Column Info
	 * @param ifStatus
	 */
	public void setIfStatus(String ifStatus) {
		this.ifStatus = ifStatus;
	}
	
	/**
	 * Column Info
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ifFlg
	 */
	public void setIfFlg(String ifFlg) {
		this.ifFlg = ifFlg;
	}
	
	/**
	 * Column Info
	 * @param toEffDt
	 */
	public void setToEffDt(String toEffDt) {
		this.toEffDt = toEffDt;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param aproRqstNo
	 */
	public void setAproRqstNo(String aproRqstNo) {
		this.aproRqstNo = aproRqstNo;
	}
	
	/**
	 * Column Info
	 * @param dtStatus
	 */
	public void setDtStatus(String dtStatus) {
		this.dtStatus = dtStatus;
	}
	
	/**
	 * Column Info
	 * @param invSubSysCd
	 */
	public void setInvSubSysCd(String invSubSysCd) {
		this.invSubSysCd = invSubSysCd;
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
	 * @param clmAreaCd
	 */
	public void setClmAreaCd(String clmAreaCd) {
		this.clmAreaCd = clmAreaCd;
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
		setIfDt(JSPUtil.getParameter(request, prefix + "if_dt", ""));
		setAftActFlg(JSPUtil.getParameter(request, prefix + "aft_act_flg", ""));
		setCsrCurrCd(JSPUtil.getParameter(request, prefix + "csr_curr_cd", ""));
		setInvIssDt(JSPUtil.getParameter(request, prefix + "inv_iss_dt", ""));
		setNoOfInv(JSPUtil.getParameter(request, prefix + "no_of_inv", ""));
		setIfErrRsn(JSPUtil.getParameter(request, prefix + "if_err_rsn", ""));
		setInvRcvDt(JSPUtil.getParameter(request, prefix + "inv_rcv_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvDesc(JSPUtil.getParameter(request, prefix + "inv_desc", ""));
		setAttrCtnt2(JSPUtil.getParameter(request, prefix + "attr_ctnt2", ""));
		setVndrNo(JSPUtil.getParameter(request, prefix + "vndr_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInvStsCd(JSPUtil.getParameter(request, prefix + "inv_sts_cd", ""));
		setSearchCsrNo(JSPUtil.getParameter(request, prefix + "search_csr_no", ""));
		setFmEffDt(JSPUtil.getParameter(request, prefix + "fm_eff_dt", ""));
		setDueDt(JSPUtil.getParameter(request, prefix + "due_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setRcvErrFlg(JSPUtil.getParameter(request, prefix + "rcv_err_flg", ""));
		setVndrTermNm(JSPUtil.getParameter(request, prefix + "vndr_term_nm", ""));
		setPayGrpLuCd(JSPUtil.getParameter(request, prefix + "pay_grp_lu_cd", ""));
		setIfStatus(JSPUtil.getParameter(request, prefix + "if_status", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setIfFlg(JSPUtil.getParameter(request, prefix + "if_flg", ""));
		setToEffDt(JSPUtil.getParameter(request, prefix + "to_eff_dt", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setAproRqstNo(JSPUtil.getParameter(request, prefix + "apro_rqst_no", ""));
		setDtStatus(JSPUtil.getParameter(request, prefix + "dt_status", ""));
		setInvSubSysCd(JSPUtil.getParameter(request, prefix + "inv_sub_sys_cd", ""));
		setCsrAmt(JSPUtil.getParameter(request, prefix + "csr_amt", ""));
		setClmAreaCd(JSPUtil.getParameter(request, prefix + "clm_area_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CsrManagerListCondVO[]
	 */
	public CsrManagerListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CsrManagerListCondVO[]
	 */
	public CsrManagerListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CsrManagerListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] aftActFlg = (JSPUtil.getParameter(request, prefix	+ "aft_act_flg", length));
			String[] csrCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_curr_cd", length));
			String[] invIssDt = (JSPUtil.getParameter(request, prefix	+ "inv_iss_dt", length));
			String[] noOfInv = (JSPUtil.getParameter(request, prefix	+ "no_of_inv", length));
			String[] ifErrRsn = (JSPUtil.getParameter(request, prefix	+ "if_err_rsn", length));
			String[] invRcvDt = (JSPUtil.getParameter(request, prefix	+ "inv_rcv_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc", length));
			String[] attrCtnt2 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt2", length));
			String[] vndrNo = (JSPUtil.getParameter(request, prefix	+ "vndr_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invStsCd = (JSPUtil.getParameter(request, prefix	+ "inv_sts_cd", length));
			String[] searchCsrNo = (JSPUtil.getParameter(request, prefix	+ "search_csr_no", length));
			String[] fmEffDt = (JSPUtil.getParameter(request, prefix	+ "fm_eff_dt", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] rcvErrFlg = (JSPUtil.getParameter(request, prefix	+ "rcv_err_flg", length));
			String[] vndrTermNm = (JSPUtil.getParameter(request, prefix	+ "vndr_term_nm", length));
			String[] payGrpLuCd = (JSPUtil.getParameter(request, prefix	+ "pay_grp_lu_cd", length));
			String[] ifStatus = (JSPUtil.getParameter(request, prefix	+ "if_status", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] ifFlg = (JSPUtil.getParameter(request, prefix	+ "if_flg", length));
			String[] toEffDt = (JSPUtil.getParameter(request, prefix	+ "to_eff_dt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] aproRqstNo = (JSPUtil.getParameter(request, prefix	+ "apro_rqst_no", length));
			String[] dtStatus = (JSPUtil.getParameter(request, prefix	+ "dt_status", length));
			String[] invSubSysCd = (JSPUtil.getParameter(request, prefix	+ "inv_sub_sys_cd", length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt", length));
			String[] clmAreaCd = (JSPUtil.getParameter(request, prefix	+ "clm_area_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CsrManagerListCondVO();
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (aftActFlg[i] != null)
					model.setAftActFlg(aftActFlg[i]);
				if (csrCurrCd[i] != null)
					model.setCsrCurrCd(csrCurrCd[i]);
				if (invIssDt[i] != null)
					model.setInvIssDt(invIssDt[i]);
				if (noOfInv[i] != null)
					model.setNoOfInv(noOfInv[i]);
				if (ifErrRsn[i] != null)
					model.setIfErrRsn(ifErrRsn[i]);
				if (invRcvDt[i] != null)
					model.setInvRcvDt(invRcvDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invDesc[i] != null)
					model.setInvDesc(invDesc[i]);
				if (attrCtnt2[i] != null)
					model.setAttrCtnt2(attrCtnt2[i]);
				if (vndrNo[i] != null)
					model.setVndrNo(vndrNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invStsCd[i] != null)
					model.setInvStsCd(invStsCd[i]);
				if (searchCsrNo[i] != null)
					model.setSearchCsrNo(searchCsrNo[i]);
				if (fmEffDt[i] != null)
					model.setFmEffDt(fmEffDt[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (rcvErrFlg[i] != null)
					model.setRcvErrFlg(rcvErrFlg[i]);
				if (vndrTermNm[i] != null)
					model.setVndrTermNm(vndrTermNm[i]);
				if (payGrpLuCd[i] != null)
					model.setPayGrpLuCd(payGrpLuCd[i]);
				if (ifStatus[i] != null)
					model.setIfStatus(ifStatus[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (ifFlg[i] != null)
					model.setIfFlg(ifFlg[i]);
				if (toEffDt[i] != null)
					model.setToEffDt(toEffDt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (aproRqstNo[i] != null)
					model.setAproRqstNo(aproRqstNo[i]);
				if (dtStatus[i] != null)
					model.setDtStatus(dtStatus[i]);
				if (invSubSysCd[i] != null)
					model.setInvSubSysCd(invSubSysCd[i]);
				if (csrAmt[i] != null)
					model.setCsrAmt(csrAmt[i]);
				if (clmAreaCd[i] != null)
					model.setClmAreaCd(clmAreaCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCsrManagerListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CsrManagerListCondVO[]
	 */
	public CsrManagerListCondVO[] getCsrManagerListCondVOs(){
		CsrManagerListCondVO[] vos = (CsrManagerListCondVO[])models.toArray(new CsrManagerListCondVO[models.size()]);
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
		this.ifDt = this.ifDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftActFlg = this.aftActFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCurrCd = this.csrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssDt = this.invIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noOfInv = this.noOfInv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifErrRsn = this.ifErrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRcvDt = this.invRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc = this.invDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt2 = this.attrCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo = this.vndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invStsCd = this.invStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchCsrNo = this.searchCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEffDt = this.fmEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvErrFlg = this.rcvErrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrTermNm = this.vndrTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payGrpLuCd = this.payGrpLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifStatus = this.ifStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlg = this.ifFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEffDt = this.toEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRqstNo = this.aproRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtStatus = this.dtStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSubSysCd = this.invSubSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAreaCd = this.clmAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
