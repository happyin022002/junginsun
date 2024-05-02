/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnerAccountByPaymentSlipVO.java
*@FileTitle : OwnerAccountByPaymentSlipVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2016.03.22 민정호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 민정호 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OwnerAccountByPaymentSlipVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OwnerAccountByPaymentSlipVO> models = new ArrayList<OwnerAccountByPaymentSlipVO>();
	
	/* Column Info */
	private String fletSrcTpCd = null;
	/* Column Info */
	private String slpFuncCd = null;
	/* Column Info */
	private String vvdYn = null;
	/* Column Info */
	private String refundAddComm = null;
	/* Column Info */
	private String initialAmtUsd = null;
	/* Column Info */
	private String exDiffUsd = null;
	/* Column Info */
	private String initialDesc = null;
	/* Column Info */
	private String oaStlStsCd = null;
	/* Column Info */
	private String orgSlpNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrCd = null;
	/* Column Info */
	private String n1stAmt = null;
	/* Column Info */
	private String vvdBunker = null;
	/* Column Info */
	private String slpTpCd = null;
	/* Column Info */
	private String acctItmNm = null;
	/* Column Info */
	private String slpSeqNo = null;
	/* Column Info */
	private String apDesc = null;
	/* Column Info */
	private String fletOlayCommRtAmt = null;
	/* Column Info */
	private String slpOfcCd = null;
	/* Column Info */
	private String slpIssDt = null;
	/* Column Info */
	private String locCurrCd = null;
	/* Column Info */
	private String matchingSlipNo = null;
	/* Column Info */
	private String oaCommFlag = null;
	/* Column Info */
	private String locAmt = null;
	/* Column Info */
	private String slpSerNo = null;
	/* Column Info */
	private String slpLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OwnerAccountByPaymentSlipVO() {}

	public OwnerAccountByPaymentSlipVO(String ibflag, String pagerows, String acctItmNm, String apDesc, String vvdBunker, String oaCommFlag, String oaStlStsCd, String orgSlpNo, String n1stAmt, String matchingSlipNo, String locCurrCd, String locAmt, String initialAmtUsd, String ctrCd, String slpLocCd, String fletSrcTpCd, String fletOlayCommRtAmt, String slpTpCd, String slpFuncCd, String slpOfcCd, String slpIssDt, String slpSerNo, String slpSeqNo, String vvdYn, String initialDesc, String exDiffUsd, String refundAddComm) {
		this.fletSrcTpCd = fletSrcTpCd;
		this.slpFuncCd = slpFuncCd;
		this.vvdYn = vvdYn;
		this.refundAddComm = refundAddComm;
		this.initialAmtUsd = initialAmtUsd;
		this.exDiffUsd = exDiffUsd;
		this.initialDesc = initialDesc;
		this.oaStlStsCd = oaStlStsCd;
		this.orgSlpNo = orgSlpNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.ctrCd = ctrCd;
		this.n1stAmt = n1stAmt;
		this.vvdBunker = vvdBunker;
		this.slpTpCd = slpTpCd;
		this.acctItmNm = acctItmNm;
		this.slpSeqNo = slpSeqNo;
		this.apDesc = apDesc;
		this.fletOlayCommRtAmt = fletOlayCommRtAmt;
		this.slpOfcCd = slpOfcCd;
		this.slpIssDt = slpIssDt;
		this.locCurrCd = locCurrCd;
		this.matchingSlipNo = matchingSlipNo;
		this.oaCommFlag = oaCommFlag;
		this.locAmt = locAmt;
		this.slpSerNo = slpSerNo;
		this.slpLocCd = slpLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("flet_src_tp_cd", getFletSrcTpCd());
		this.hashColumns.put("slp_func_cd", getSlpFuncCd());
		this.hashColumns.put("vvd_yn", getVvdYn());
		this.hashColumns.put("refund_add_comm", getRefundAddComm());
		this.hashColumns.put("initial_amt_usd", getInitialAmtUsd());
		this.hashColumns.put("ex_diff_usd", getExDiffUsd());
		this.hashColumns.put("initial_desc", getInitialDesc());
		this.hashColumns.put("oa_stl_sts_cd", getOaStlStsCd());
		this.hashColumns.put("org_slp_no", getOrgSlpNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctr_cd", getCtrCd());
		this.hashColumns.put("n1st_amt", getN1stAmt());
		this.hashColumns.put("vvd_bunker", getVvdBunker());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("acct_itm_nm", getAcctItmNm());
		this.hashColumns.put("slp_seq_no", getSlpSeqNo());
		this.hashColumns.put("ap_desc", getApDesc());
		this.hashColumns.put("flet_olay_comm_rt_amt", getFletOlayCommRtAmt());
		this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
		this.hashColumns.put("slp_iss_dt", getSlpIssDt());
		this.hashColumns.put("loc_curr_cd", getLocCurrCd());
		this.hashColumns.put("matching_slip_no", getMatchingSlipNo());
		this.hashColumns.put("oa_comm_flag", getOaCommFlag());
		this.hashColumns.put("loc_amt", getLocAmt());
		this.hashColumns.put("slp_ser_no", getSlpSerNo());
		this.hashColumns.put("slp_loc_cd", getSlpLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("flet_src_tp_cd", "fletSrcTpCd");
		this.hashFields.put("slp_func_cd", "slpFuncCd");
		this.hashFields.put("vvd_yn", "vvdYn");
		this.hashFields.put("refund_add_comm", "refundAddComm");
		this.hashFields.put("initial_amt_usd", "initialAmtUsd");
		this.hashFields.put("ex_diff_usd", "exDiffUsd");
		this.hashFields.put("initial_desc", "initialDesc");
		this.hashFields.put("oa_stl_sts_cd", "oaStlStsCd");
		this.hashFields.put("org_slp_no", "orgSlpNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("n1st_amt", "n1stAmt");
		this.hashFields.put("vvd_bunker", "vvdBunker");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("acct_itm_nm", "acctItmNm");
		this.hashFields.put("slp_seq_no", "slpSeqNo");
		this.hashFields.put("ap_desc", "apDesc");
		this.hashFields.put("flet_olay_comm_rt_amt", "fletOlayCommRtAmt");
		this.hashFields.put("slp_ofc_cd", "slpOfcCd");
		this.hashFields.put("slp_iss_dt", "slpIssDt");
		this.hashFields.put("loc_curr_cd", "locCurrCd");
		this.hashFields.put("matching_slip_no", "matchingSlipNo");
		this.hashFields.put("oa_comm_flag", "oaCommFlag");
		this.hashFields.put("loc_amt", "locAmt");
		this.hashFields.put("slp_ser_no", "slpSerNo");
		this.hashFields.put("slp_loc_cd", "slpLocCd");
		return this.hashFields;
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
	 * @return vvdYn
	 */
	public String getVvdYn() {
		return this.vvdYn;
	}
	
	/**
	 * Column Info
	 * @return refundAddComm
	 */
	public String getRefundAddComm() {
		return this.refundAddComm;
	}
	
	/**
	 * Column Info
	 * @return initialAmtUsd
	 */
	public String getInitialAmtUsd() {
		return this.initialAmtUsd;
	}
	
	/**
	 * Column Info
	 * @return exDiffUsd
	 */
	public String getExDiffUsd() {
		return this.exDiffUsd;
	}
	
	/**
	 * Column Info
	 * @return initialDesc
	 */
	public String getInitialDesc() {
		return this.initialDesc;
	}
	
	/**
	 * Column Info
	 * @return oaStlStsCd
	 */
	public String getOaStlStsCd() {
		return this.oaStlStsCd;
	}
	
	/**
	 * Column Info
	 * @return orgSlpNo
	 */
	public String getOrgSlpNo() {
		return this.orgSlpNo;
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
	 * @return ctrCd
	 */
	public String getCtrCd() {
		return this.ctrCd;
	}
	
	/**
	 * Column Info
	 * @return n1stAmt
	 */
	public String getN1stAmt() {
		return this.n1stAmt;
	}
	
	/**
	 * Column Info
	 * @return vvdBunker
	 */
	public String getVvdBunker() {
		return this.vvdBunker;
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
	 * @return acctItmNm
	 */
	public String getAcctItmNm() {
		return this.acctItmNm;
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
	 * @return apDesc
	 */
	public String getApDesc() {
		return this.apDesc;
	}
	
	/**
	 * Column Info
	 * @return fletOlayCommRtAmt
	 */
	public String getFletOlayCommRtAmt() {
		return this.fletOlayCommRtAmt;
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
	 * @return locCurrCd
	 */
	public String getLocCurrCd() {
		return this.locCurrCd;
	}
	
	/**
	 * Column Info
	 * @return matchingSlipNo
	 */
	public String getMatchingSlipNo() {
		return this.matchingSlipNo;
	}
	
	/**
	 * Column Info
	 * @return oaCommFlag
	 */
	public String getOaCommFlag() {
		return this.oaCommFlag;
	}
	
	/**
	 * Column Info
	 * @return locAmt
	 */
	public String getLocAmt() {
		return this.locAmt;
	}
	
	/**
	 * Column Info
	 * @return slpSerNo
	 */
	public String getSlpSerNo() {
		return this.slpSerNo;
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
	 * @param vvdYn
	 */
	public void setVvdYn(String vvdYn) {
		this.vvdYn = vvdYn;
	}
	
	/**
	 * Column Info
	 * @param refundAddComm
	 */
	public void setRefundAddComm(String refundAddComm) {
		this.refundAddComm = refundAddComm;
	}
	
	/**
	 * Column Info
	 * @param initialAmtUsd
	 */
	public void setInitialAmtUsd(String initialAmtUsd) {
		this.initialAmtUsd = initialAmtUsd;
	}
	
	/**
	 * Column Info
	 * @param exDiffUsd
	 */
	public void setExDiffUsd(String exDiffUsd) {
		this.exDiffUsd = exDiffUsd;
	}
	
	/**
	 * Column Info
	 * @param initialDesc
	 */
	public void setInitialDesc(String initialDesc) {
		this.initialDesc = initialDesc;
	}
	
	/**
	 * Column Info
	 * @param oaStlStsCd
	 */
	public void setOaStlStsCd(String oaStlStsCd) {
		this.oaStlStsCd = oaStlStsCd;
	}
	
	/**
	 * Column Info
	 * @param orgSlpNo
	 */
	public void setOrgSlpNo(String orgSlpNo) {
		this.orgSlpNo = orgSlpNo;
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
	 * @param ctrCd
	 */
	public void setCtrCd(String ctrCd) {
		this.ctrCd = ctrCd;
	}
	
	/**
	 * Column Info
	 * @param n1stAmt
	 */
	public void setN1stAmt(String n1stAmt) {
		this.n1stAmt = n1stAmt;
	}
	
	/**
	 * Column Info
	 * @param vvdBunker
	 */
	public void setVvdBunker(String vvdBunker) {
		this.vvdBunker = vvdBunker;
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
	 * @param acctItmNm
	 */
	public void setAcctItmNm(String acctItmNm) {
		this.acctItmNm = acctItmNm;
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
	 * @param apDesc
	 */
	public void setApDesc(String apDesc) {
		this.apDesc = apDesc;
	}
	
	/**
	 * Column Info
	 * @param fletOlayCommRtAmt
	 */
	public void setFletOlayCommRtAmt(String fletOlayCommRtAmt) {
		this.fletOlayCommRtAmt = fletOlayCommRtAmt;
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
	 * @param locCurrCd
	 */
	public void setLocCurrCd(String locCurrCd) {
		this.locCurrCd = locCurrCd;
	}
	
	/**
	 * Column Info
	 * @param matchingSlipNo
	 */
	public void setMatchingSlipNo(String matchingSlipNo) {
		this.matchingSlipNo = matchingSlipNo;
	}
	
	/**
	 * Column Info
	 * @param oaCommFlag
	 */
	public void setOaCommFlag(String oaCommFlag) {
		this.oaCommFlag = oaCommFlag;
	}
	
	/**
	 * Column Info
	 * @param locAmt
	 */
	public void setLocAmt(String locAmt) {
		this.locAmt = locAmt;
	}
	
	/**
	 * Column Info
	 * @param slpSerNo
	 */
	public void setSlpSerNo(String slpSerNo) {
		this.slpSerNo = slpSerNo;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setFletSrcTpCd(JSPUtil.getParameter(request, prefix + "flet_src_tp_cd", ""));
		setSlpFuncCd(JSPUtil.getParameter(request, prefix + "slp_func_cd", ""));
		setVvdYn(JSPUtil.getParameter(request, prefix + "vvd_yn", ""));
		setRefundAddComm(JSPUtil.getParameter(request, prefix + "refund_add_comm", ""));
		setInitialAmtUsd(JSPUtil.getParameter(request, prefix + "initial_amt_usd", ""));
		setExDiffUsd(JSPUtil.getParameter(request, prefix + "ex_diff_usd", ""));
		setInitialDesc(JSPUtil.getParameter(request, prefix + "initial_desc", ""));
		setOaStlStsCd(JSPUtil.getParameter(request, prefix + "oa_stl_sts_cd", ""));
		setOrgSlpNo(JSPUtil.getParameter(request, prefix + "org_slp_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrCd(JSPUtil.getParameter(request, prefix + "ctr_cd", ""));
		setN1stAmt(JSPUtil.getParameter(request, prefix + "n1st_amt", ""));
		setVvdBunker(JSPUtil.getParameter(request, prefix + "vvd_bunker", ""));
		setSlpTpCd(JSPUtil.getParameter(request, prefix + "slp_tp_cd", ""));
		setAcctItmNm(JSPUtil.getParameter(request, prefix + "acct_itm_nm", ""));
		setSlpSeqNo(JSPUtil.getParameter(request, prefix + "slp_seq_no", ""));
		setApDesc(JSPUtil.getParameter(request, prefix + "ap_desc", ""));
		setFletOlayCommRtAmt(JSPUtil.getParameter(request, prefix + "flet_olay_comm_rt_amt", ""));
		setSlpOfcCd(JSPUtil.getParameter(request, prefix + "slp_ofc_cd", ""));
		setSlpIssDt(JSPUtil.getParameter(request, prefix + "slp_iss_dt", ""));
		setLocCurrCd(JSPUtil.getParameter(request, prefix + "loc_curr_cd", ""));
		setMatchingSlipNo(JSPUtil.getParameter(request, prefix + "matching_slip_no", ""));
		setOaCommFlag(JSPUtil.getParameter(request, prefix + "oa_comm_flag", ""));
		setLocAmt(JSPUtil.getParameter(request, prefix + "loc_amt", ""));
		setSlpSerNo(JSPUtil.getParameter(request, prefix + "slp_ser_no", ""));
		setSlpLocCd(JSPUtil.getParameter(request, prefix + "slp_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OwnerAccountByPaymentSlipVO[]
	 */
	public OwnerAccountByPaymentSlipVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OwnerAccountByPaymentSlipVO[]
	 */
	public OwnerAccountByPaymentSlipVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OwnerAccountByPaymentSlipVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fletSrcTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_src_tp_cd", length));
			String[] slpFuncCd = (JSPUtil.getParameter(request, prefix	+ "slp_func_cd", length));
			String[] vvdYn = (JSPUtil.getParameter(request, prefix	+ "vvd_yn", length));
			String[] refundAddComm = (JSPUtil.getParameter(request, prefix	+ "refund_add_comm", length));
			String[] initialAmtUsd = (JSPUtil.getParameter(request, prefix	+ "initial_amt_usd", length));
			String[] exDiffUsd = (JSPUtil.getParameter(request, prefix	+ "ex_diff_usd", length));
			String[] initialDesc = (JSPUtil.getParameter(request, prefix	+ "initial_desc", length));
			String[] oaStlStsCd = (JSPUtil.getParameter(request, prefix	+ "oa_stl_sts_cd", length));
			String[] orgSlpNo = (JSPUtil.getParameter(request, prefix	+ "org_slp_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrCd = (JSPUtil.getParameter(request, prefix	+ "ctr_cd", length));
			String[] n1stAmt = (JSPUtil.getParameter(request, prefix	+ "n1st_amt", length));
			String[] vvdBunker = (JSPUtil.getParameter(request, prefix	+ "vvd_bunker", length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd", length));
			String[] acctItmNm = (JSPUtil.getParameter(request, prefix	+ "acct_itm_nm", length));
			String[] slpSeqNo = (JSPUtil.getParameter(request, prefix	+ "slp_seq_no", length));
			String[] apDesc = (JSPUtil.getParameter(request, prefix	+ "ap_desc", length));
			String[] fletOlayCommRtAmt = (JSPUtil.getParameter(request, prefix	+ "flet_olay_comm_rt_amt", length));
			String[] slpOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_ofc_cd", length));
			String[] slpIssDt = (JSPUtil.getParameter(request, prefix	+ "slp_iss_dt", length));
			String[] locCurrCd = (JSPUtil.getParameter(request, prefix	+ "loc_curr_cd", length));
			String[] matchingSlipNo = (JSPUtil.getParameter(request, prefix	+ "matching_slip_no", length));
			String[] oaCommFlag = (JSPUtil.getParameter(request, prefix	+ "oa_comm_flag", length));
			String[] locAmt = (JSPUtil.getParameter(request, prefix	+ "loc_amt", length));
			String[] slpSerNo = (JSPUtil.getParameter(request, prefix	+ "slp_ser_no", length));
			String[] slpLocCd = (JSPUtil.getParameter(request, prefix	+ "slp_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new OwnerAccountByPaymentSlipVO();
				if (fletSrcTpCd[i] != null)
					model.setFletSrcTpCd(fletSrcTpCd[i]);
				if (slpFuncCd[i] != null)
					model.setSlpFuncCd(slpFuncCd[i]);
				if (vvdYn[i] != null)
					model.setVvdYn(vvdYn[i]);
				if (refundAddComm[i] != null)
					model.setRefundAddComm(refundAddComm[i]);
				if (initialAmtUsd[i] != null)
					model.setInitialAmtUsd(initialAmtUsd[i]);
				if (exDiffUsd[i] != null)
					model.setExDiffUsd(exDiffUsd[i]);
				if (initialDesc[i] != null)
					model.setInitialDesc(initialDesc[i]);
				if (oaStlStsCd[i] != null)
					model.setOaStlStsCd(oaStlStsCd[i]);
				if (orgSlpNo[i] != null)
					model.setOrgSlpNo(orgSlpNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrCd[i] != null)
					model.setCtrCd(ctrCd[i]);
				if (n1stAmt[i] != null)
					model.setN1stAmt(n1stAmt[i]);
				if (vvdBunker[i] != null)
					model.setVvdBunker(vvdBunker[i]);
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (acctItmNm[i] != null)
					model.setAcctItmNm(acctItmNm[i]);
				if (slpSeqNo[i] != null)
					model.setSlpSeqNo(slpSeqNo[i]);
				if (apDesc[i] != null)
					model.setApDesc(apDesc[i]);
				if (fletOlayCommRtAmt[i] != null)
					model.setFletOlayCommRtAmt(fletOlayCommRtAmt[i]);
				if (slpOfcCd[i] != null)
					model.setSlpOfcCd(slpOfcCd[i]);
				if (slpIssDt[i] != null)
					model.setSlpIssDt(slpIssDt[i]);
				if (locCurrCd[i] != null)
					model.setLocCurrCd(locCurrCd[i]);
				if (matchingSlipNo[i] != null)
					model.setMatchingSlipNo(matchingSlipNo[i]);
				if (oaCommFlag[i] != null)
					model.setOaCommFlag(oaCommFlag[i]);
				if (locAmt[i] != null)
					model.setLocAmt(locAmt[i]);
				if (slpSerNo[i] != null)
					model.setSlpSerNo(slpSerNo[i]);
				if (slpLocCd[i] != null)
					model.setSlpLocCd(slpLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOwnerAccountByPaymentSlipVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OwnerAccountByPaymentSlipVO[]
	 */
	public OwnerAccountByPaymentSlipVO[] getOwnerAccountByPaymentSlipVOs(){
		OwnerAccountByPaymentSlipVO[] vos = (OwnerAccountByPaymentSlipVO[])models.toArray(new OwnerAccountByPaymentSlipVO[models.size()]);
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
		this.fletSrcTpCd = this.fletSrcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpFuncCd = this.slpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdYn = this.vvdYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refundAddComm = this.refundAddComm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initialAmtUsd = this.initialAmtUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exDiffUsd = this.exDiffUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initialDesc = this.initialDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaStlStsCd = this.oaStlStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpNo = this.orgSlpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd = this.ctrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stAmt = this.n1stAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdBunker = this.vvdBunker .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctItmNm = this.acctItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSeqNo = this.slpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apDesc = this.apDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletOlayCommRtAmt = this.fletOlayCommRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpOfcCd = this.slpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssDt = this.slpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCurrCd = this.locCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.matchingSlipNo = this.matchingSlipNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaCommFlag = this.oaCommFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locAmt = this.locAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSerNo = this.slpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpLocCd = this.slpLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
