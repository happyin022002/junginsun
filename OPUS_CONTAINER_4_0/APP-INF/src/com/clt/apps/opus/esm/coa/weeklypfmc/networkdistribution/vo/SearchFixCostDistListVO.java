/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchFixCostDistListVO.java
*@FileTitle : SearchFixCostDistListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.06
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.10.06 김기종 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchFixCostDistListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchFixCostDistListVO> models = new ArrayList<SearchFixCostDistListVO>();
	
	/* Column Info */
	private String dTsRto = null;
	/* Column Info */
	private String dRlaneCd = null;
	/* Column Info */
	private String dVvdCd = null;
	/* Column Info */
	private String dTrdCd = null;
	/* Column Info */
	private String dIocCd = null;
	/* Column Info */
	private String mRlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mTsUcAmt = null;
	/* Column Info */
	private String dTsCtrbBseCostAmt = null;
	/* Column Info */
	private String mSkdVoyNo = null;
	/* Column Info */
	private String dCmmtBseCostRto = null;
	/* Column Info */
	private String dTsQty = null;
	/* Column Info */
	private String dCmmtDiffCostAmt = null;
	/* Column Info */
	private String mCoSlsAmt = null;
	/* Column Info */
	private String dBsaBseCostAmt = null;
	/* Column Info */
	private String mIocCd = null;
	/* Column Info */
	private String dLoclTsStsCd = null;
	/* Column Info */
	private String dFxCostDtrbAmt = null;
	/* Column Info */
	private String dCmmtBseCostAmt = null;
	/* Column Info */
	private String mTrdCd = null;
	/* Column Info */
	private String dCmmtAddCostAmt = null;
	/* Column Info */
	private String mVslCd = null;
	/* Column Info */
	private String dCmlBseCostAmt = null;
	/* Column Info */
	private String dCmmtQty = null;
	/* Column Info */
	private String mDirCd = null;
	/* Column Info */
	private String dCmmtFnlCostAmt = null;
	
	//SJH.20141028.ADD
	/* Column Info */
	private String orgCoSlsAmt = null;	
	/* Column Info */
	private String sltInterPrcAmt = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchFixCostDistListVO() {}

	public SearchFixCostDistListVO(String ibflag, String pagerows, String mTrdCd, String mRlaneCd, String mIocCd, String mVslCd, String mSkdVoyNo, String mDirCd, String mTsUcAmt, String mCoSlsAmt, String dTrdCd, String dRlaneCd, String dIocCd, String dVvdCd, String dLoclTsStsCd, String dTsQty, String dTsRto, String dFxCostDtrbAmt, String dCmlBseCostAmt, String dBsaBseCostAmt, String dTsCtrbBseCostAmt, String dCmmtQty, String dCmmtBseCostRto, String dCmmtBseCostAmt, String dCmmtAddCostAmt, String dCmmtDiffCostAmt, String dCmmtFnlCostAmt, String orgCoSlsAmt, String sltInterPrcAmt) {
		this.dTsRto = dTsRto;
		this.dRlaneCd = dRlaneCd;
		this.dVvdCd = dVvdCd;
		this.dTrdCd = dTrdCd;
		this.dIocCd = dIocCd;
		this.mRlaneCd = mRlaneCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.mTsUcAmt = mTsUcAmt;
		this.dTsCtrbBseCostAmt = dTsCtrbBseCostAmt;
		this.mSkdVoyNo = mSkdVoyNo;
		this.dCmmtBseCostRto = dCmmtBseCostRto;
		this.dTsQty = dTsQty;
		this.dCmmtDiffCostAmt = dCmmtDiffCostAmt;
		this.mCoSlsAmt = mCoSlsAmt;
		this.dBsaBseCostAmt = dBsaBseCostAmt;
		this.mIocCd = mIocCd;
		this.dLoclTsStsCd = dLoclTsStsCd;
		this.dFxCostDtrbAmt = dFxCostDtrbAmt;
		this.dCmmtBseCostAmt = dCmmtBseCostAmt;
		this.mTrdCd = mTrdCd;
		this.dCmmtAddCostAmt = dCmmtAddCostAmt;
		this.mVslCd = mVslCd;
		this.dCmlBseCostAmt = dCmlBseCostAmt;
		this.dCmmtQty = dCmmtQty;
		this.mDirCd = mDirCd;
		this.dCmmtFnlCostAmt = dCmmtFnlCostAmt;
		//SJH.20141028.ADD
		this.orgCoSlsAmt = orgCoSlsAmt;
		this.sltInterPrcAmt = sltInterPrcAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("d_ts_rto", getDTsRto());
		this.hashColumns.put("d_rlane_cd", getDRlaneCd());
		this.hashColumns.put("d_vvd_cd", getDVvdCd());
		this.hashColumns.put("d_trd_cd", getDTrdCd());
		this.hashColumns.put("d_ioc_cd", getDIocCd());
		this.hashColumns.put("m_rlane_cd", getMRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("m_ts_uc_amt", getMTsUcAmt());
		this.hashColumns.put("d_ts_ctrb_bse_cost_amt", getDTsCtrbBseCostAmt());
		this.hashColumns.put("m_skd_voy_no", getMSkdVoyNo());
		this.hashColumns.put("d_cmmt_bse_cost_rto", getDCmmtBseCostRto());
		this.hashColumns.put("d_ts_qty", getDTsQty());
		this.hashColumns.put("d_cmmt_diff_cost_amt", getDCmmtDiffCostAmt());
		this.hashColumns.put("m_co_sls_amt", getMCoSlsAmt());
		this.hashColumns.put("d_bsa_bse_cost_amt", getDBsaBseCostAmt());
		this.hashColumns.put("m_ioc_cd", getMIocCd());
		this.hashColumns.put("d_locl_ts_sts_cd", getDLoclTsStsCd());
		this.hashColumns.put("d_fx_cost_dtrb_amt", getDFxCostDtrbAmt());
		this.hashColumns.put("d_cmmt_bse_cost_amt", getDCmmtBseCostAmt());
		this.hashColumns.put("m_trd_cd", getMTrdCd());
		this.hashColumns.put("d_cmmt_add_cost_amt", getDCmmtAddCostAmt());
		this.hashColumns.put("m_vsl_cd", getMVslCd());
		this.hashColumns.put("d_cml_bse_cost_amt", getDCmlBseCostAmt());
		this.hashColumns.put("d_cmmt_qty", getDCmmtQty());
		this.hashColumns.put("m_dir_cd", getMDirCd());
		this.hashColumns.put("d_cmmt_fnl_cost_amt", getDCmmtFnlCostAmt());
		//SJH.20141028.ADD
		this.hashColumns.put("org_co_sls_amt", getOrgCoSlsAmt());
		this.hashColumns.put("slt_inter_prc_amt", getSltInterPrcAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("d_ts_rto", "dTsRto");
		this.hashFields.put("d_rlane_cd", "dRlaneCd");
		this.hashFields.put("d_vvd_cd", "dVvdCd");
		this.hashFields.put("d_trd_cd", "dTrdCd");
		this.hashFields.put("d_ioc_cd", "dIocCd");
		this.hashFields.put("m_rlane_cd", "mRlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("m_ts_uc_amt", "mTsUcAmt");
		this.hashFields.put("d_ts_ctrb_bse_cost_amt", "dTsCtrbBseCostAmt");
		this.hashFields.put("m_skd_voy_no", "mSkdVoyNo");
		this.hashFields.put("d_cmmt_bse_cost_rto", "dCmmtBseCostRto");
		this.hashFields.put("d_ts_qty", "dTsQty");
		this.hashFields.put("d_cmmt_diff_cost_amt", "dCmmtDiffCostAmt");
		this.hashFields.put("m_co_sls_amt", "mCoSlsAmt");
		this.hashFields.put("d_bsa_bse_cost_amt", "dBsaBseCostAmt");
		this.hashFields.put("m_ioc_cd", "mIocCd");
		this.hashFields.put("d_locl_ts_sts_cd", "dLoclTsStsCd");
		this.hashFields.put("d_fx_cost_dtrb_amt", "dFxCostDtrbAmt");
		this.hashFields.put("d_cmmt_bse_cost_amt", "dCmmtBseCostAmt");
		this.hashFields.put("m_trd_cd", "mTrdCd");
		this.hashFields.put("d_cmmt_add_cost_amt", "dCmmtAddCostAmt");
		this.hashFields.put("m_vsl_cd", "mVslCd");
		this.hashFields.put("d_cml_bse_cost_amt", "dCmlBseCostAmt");
		this.hashFields.put("d_cmmt_qty", "dCmmtQty");
		this.hashFields.put("m_dir_cd", "mDirCd");
		this.hashFields.put("d_cmmt_fnl_cost_amt", "dCmmtFnlCostAmt");
		//SJH.20141028.ADD
		this.hashFields.put("org_co_sls_amt", "orgCoSlsAmt");
		this.hashFields.put("slt_inter_prc_amt", "sltInterPrcAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dTsRto
	 */
	public String getDTsRto() {
		return this.dTsRto;
	}
	
	/**
	 * Column Info
	 * @return dRlaneCd
	 */
	public String getDRlaneCd() {
		return this.dRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return dVvdCd
	 */
	public String getDVvdCd() {
		return this.dVvdCd;
	}
	
	/**
	 * Column Info
	 * @return dTrdCd
	 */
	public String getDTrdCd() {
		return this.dTrdCd;
	}
	
	/**
	 * Column Info
	 * @return dIocCd
	 */
	public String getDIocCd() {
		return this.dIocCd;
	}
	
	/**
	 * Column Info
	 * @return mRlaneCd
	 */
	public String getMRlaneCd() {
		return this.mRlaneCd;
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
	 * @return mTsUcAmt
	 */
	public String getMTsUcAmt() {
		return this.mTsUcAmt;
	}
	
	/**
	 * Column Info
	 * @return dTsCtrbBseCostAmt
	 */
	public String getDTsCtrbBseCostAmt() {
		return this.dTsCtrbBseCostAmt;
	}
	
	/**
	 * Column Info
	 * @return mSkdVoyNo
	 */
	public String getMSkdVoyNo() {
		return this.mSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return dCmmtBseCostRto
	 */
	public String getDCmmtBseCostRto() {
		return this.dCmmtBseCostRto;
	}
	
	/**
	 * Column Info
	 * @return dTsQty
	 */
	public String getDTsQty() {
		return this.dTsQty;
	}
	
	/**
	 * Column Info
	 * @return dCmmtDiffCostAmt
	 */
	public String getDCmmtDiffCostAmt() {
		return this.dCmmtDiffCostAmt;
	}
	
	/**
	 * Column Info
	 * @return mCoSlsAmt
	 */
	public String getMCoSlsAmt() {
		return this.mCoSlsAmt;
	}
	
	/**
	 * Column Info
	 * @return dBsaBseCostAmt
	 */
	public String getDBsaBseCostAmt() {
		return this.dBsaBseCostAmt;
	}
	
	/**
	 * Column Info
	 * @return mIocCd
	 */
	public String getMIocCd() {
		return this.mIocCd;
	}
	
	/**
	 * Column Info
	 * @return dLoclTsStsCd
	 */
	public String getDLoclTsStsCd() {
		return this.dLoclTsStsCd;
	}
	
	/**
	 * Column Info
	 * @return dFxCostDtrbAmt
	 */
	public String getDFxCostDtrbAmt() {
		return this.dFxCostDtrbAmt;
	}
	
	/**
	 * Column Info
	 * @return dCmmtBseCostAmt
	 */
	public String getDCmmtBseCostAmt() {
		return this.dCmmtBseCostAmt;
	}
	
	/**
	 * Column Info
	 * @return mTrdCd
	 */
	public String getMTrdCd() {
		return this.mTrdCd;
	}
	
	/**
	 * Column Info
	 * @return dCmmtAddCostAmt
	 */
	public String getDCmmtAddCostAmt() {
		return this.dCmmtAddCostAmt;
	}
	
	/**
	 * Column Info
	 * @return mVslCd
	 */
	public String getMVslCd() {
		return this.mVslCd;
	}
	
	/**
	 * Column Info
	 * @return dCmlBseCostAmt
	 */
	public String getDCmlBseCostAmt() {
		return this.dCmlBseCostAmt;
	}
	
	/**
	 * Column Info
	 * @return dCmmtQty
	 */
	public String getDCmmtQty() {
		return this.dCmmtQty;
	}
	
	/**
	 * Column Info
	 * @return mDirCd
	 */
	public String getMDirCd() {
		return this.mDirCd;
	}
	
	/**
	 * Column Info
	 * @return dCmmtFnlCostAmt
	 */
	public String getDCmmtFnlCostAmt() {
		return this.dCmmtFnlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return orgCoSlsAmt
	 * @author SJH.20141028
	 */
	public String getOrgCoSlsAmt() {
		return this.orgCoSlsAmt;
	}
	
	/**
	 * Column Info
	 * @return sltInterPrcAmt
	 * @author SJH.20141028
	 */
	public String getSltInterPrcAmt() {
		return this.sltInterPrcAmt;
	}	
	

	/**
	 * Column Info
	 * @param dTsRto
	 */
	public void setDTsRto(String dTsRto) {
		this.dTsRto = dTsRto;
	}
	
	/**
	 * Column Info
	 * @param dRlaneCd
	 */
	public void setDRlaneCd(String dRlaneCd) {
		this.dRlaneCd = dRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param dVvdCd
	 */
	public void setDVvdCd(String dVvdCd) {
		this.dVvdCd = dVvdCd;
	}
	
	/**
	 * Column Info
	 * @param dTrdCd
	 */
	public void setDTrdCd(String dTrdCd) {
		this.dTrdCd = dTrdCd;
	}
	
	/**
	 * Column Info
	 * @param dIocCd
	 */
	public void setDIocCd(String dIocCd) {
		this.dIocCd = dIocCd;
	}
	
	/**
	 * Column Info
	 * @param mRlaneCd
	 */
	public void setMRlaneCd(String mRlaneCd) {
		this.mRlaneCd = mRlaneCd;
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
	 * @param mTsUcAmt
	 */
	public void setMTsUcAmt(String mTsUcAmt) {
		this.mTsUcAmt = mTsUcAmt;
	}
	
	/**
	 * Column Info
	 * @param dTsCtrbBseCostAmt
	 */
	public void setDTsCtrbBseCostAmt(String dTsCtrbBseCostAmt) {
		this.dTsCtrbBseCostAmt = dTsCtrbBseCostAmt;
	}
	
	/**
	 * Column Info
	 * @param mSkdVoyNo
	 */
	public void setMSkdVoyNo(String mSkdVoyNo) {
		this.mSkdVoyNo = mSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param dCmmtBseCostRto
	 */
	public void setDCmmtBseCostRto(String dCmmtBseCostRto) {
		this.dCmmtBseCostRto = dCmmtBseCostRto;
	}
	
	/**
	 * Column Info
	 * @param dTsQty
	 */
	public void setDTsQty(String dTsQty) {
		this.dTsQty = dTsQty;
	}
	
	/**
	 * Column Info
	 * @param dCmmtDiffCostAmt
	 */
	public void setDCmmtDiffCostAmt(String dCmmtDiffCostAmt) {
		this.dCmmtDiffCostAmt = dCmmtDiffCostAmt;
	}
	
	/**
	 * Column Info
	 * @param mCoSlsAmt
	 */
	public void setMCoSlsAmt(String mCoSlsAmt) {
		this.mCoSlsAmt = mCoSlsAmt;
	}
	
	/**
	 * Column Info
	 * @param dBsaBseCostAmt
	 */
	public void setDBsaBseCostAmt(String dBsaBseCostAmt) {
		this.dBsaBseCostAmt = dBsaBseCostAmt;
	}
	
	/**
	 * Column Info
	 * @param mIocCd
	 */
	public void setMIocCd(String mIocCd) {
		this.mIocCd = mIocCd;
	}
	
	/**
	 * Column Info
	 * @param dLoclTsStsCd
	 */
	public void setDLoclTsStsCd(String dLoclTsStsCd) {
		this.dLoclTsStsCd = dLoclTsStsCd;
	}
	
	/**
	 * Column Info
	 * @param dFxCostDtrbAmt
	 */
	public void setDFxCostDtrbAmt(String dFxCostDtrbAmt) {
		this.dFxCostDtrbAmt = dFxCostDtrbAmt;
	}
	
	/**
	 * Column Info
	 * @param dCmmtBseCostAmt
	 */
	public void setDCmmtBseCostAmt(String dCmmtBseCostAmt) {
		this.dCmmtBseCostAmt = dCmmtBseCostAmt;
	}
	
	/**
	 * Column Info
	 * @param mTrdCd
	 */
	public void setMTrdCd(String mTrdCd) {
		this.mTrdCd = mTrdCd;
	}
	
	/**
	 * Column Info
	 * @param dCmmtAddCostAmt
	 */
	public void setDCmmtAddCostAmt(String dCmmtAddCostAmt) {
		this.dCmmtAddCostAmt = dCmmtAddCostAmt;
	}
	
	/**
	 * Column Info
	 * @param mVslCd
	 */
	public void setMVslCd(String mVslCd) {
		this.mVslCd = mVslCd;
	}
	
	/**
	 * Column Info
	 * @param dCmlBseCostAmt
	 */
	public void setDCmlBseCostAmt(String dCmlBseCostAmt) {
		this.dCmlBseCostAmt = dCmlBseCostAmt;
	}
	
	/**
	 * Column Info
	 * @param dCmmtQty
	 */
	public void setDCmmtQty(String dCmmtQty) {
		this.dCmmtQty = dCmmtQty;
	}
	
	/**
	 * Column Info
	 * @param mDirCd
	 */
	public void setMDirCd(String mDirCd) {
		this.mDirCd = mDirCd;
	}
	
	/**
	 * Column Info
	 * @param dCmmtFnlCostAmt
	 */
	public void setDCmmtFnlCostAmt(String dCmmtFnlCostAmt) {
		this.dCmmtFnlCostAmt = dCmmtFnlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param orgCoSlsAmt
	 * @author SJH.20141028
	 */
	public void setOrgCoSlsAmt(String orgCoSlsAmt) {
		this.orgCoSlsAmt = orgCoSlsAmt;
	}
	
	/**
	 * Column Info
	 * @param sltInterPrcAmt
	 * @author SJH.20141028
	 */
	public void setSltInterPrcAmt(String sltInterPrcAmt) {
		this.sltInterPrcAmt = sltInterPrcAmt;
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
		setDTsRto(JSPUtil.getParameter(request, prefix + "d_ts_rto", ""));
		setDRlaneCd(JSPUtil.getParameter(request, prefix + "d_rlane_cd", ""));
		setDVvdCd(JSPUtil.getParameter(request, prefix + "d_vvd_cd", ""));
		setDTrdCd(JSPUtil.getParameter(request, prefix + "d_trd_cd", ""));
		setDIocCd(JSPUtil.getParameter(request, prefix + "d_ioc_cd", ""));
		setMRlaneCd(JSPUtil.getParameter(request, prefix + "m_rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMTsUcAmt(JSPUtil.getParameter(request, prefix + "m_ts_uc_amt", ""));
		setDTsCtrbBseCostAmt(JSPUtil.getParameter(request, prefix + "d_ts_ctrb_bse_cost_amt", ""));
		setMSkdVoyNo(JSPUtil.getParameter(request, prefix + "m_skd_voy_no", ""));
		setDCmmtBseCostRto(JSPUtil.getParameter(request, prefix + "d_cmmt_bse_cost_rto", ""));
		setDTsQty(JSPUtil.getParameter(request, prefix + "d_ts_qty", ""));
		setDCmmtDiffCostAmt(JSPUtil.getParameter(request, prefix + "d_cmmt_diff_cost_amt", ""));
		setMCoSlsAmt(JSPUtil.getParameter(request, prefix + "m_co_sls_amt", ""));
		setDBsaBseCostAmt(JSPUtil.getParameter(request, prefix + "d_bsa_bse_cost_amt", ""));
		setMIocCd(JSPUtil.getParameter(request, prefix + "m_ioc_cd", ""));
		setDLoclTsStsCd(JSPUtil.getParameter(request, prefix + "d_locl_ts_sts_cd", ""));
		setDFxCostDtrbAmt(JSPUtil.getParameter(request, prefix + "d_fx_cost_dtrb_amt", ""));
		setDCmmtBseCostAmt(JSPUtil.getParameter(request, prefix + "d_cmmt_bse_cost_amt", ""));
		setMTrdCd(JSPUtil.getParameter(request, prefix + "m_trd_cd", ""));
		setDCmmtAddCostAmt(JSPUtil.getParameter(request, prefix + "d_cmmt_add_cost_amt", ""));
		setMVslCd(JSPUtil.getParameter(request, prefix + "m_vsl_cd", ""));
		setDCmlBseCostAmt(JSPUtil.getParameter(request, prefix + "d_cml_bse_cost_amt", ""));
		setDCmmtQty(JSPUtil.getParameter(request, prefix + "d_cmmt_qty", ""));
		setMDirCd(JSPUtil.getParameter(request, prefix + "m_dir_cd", ""));
		setDCmmtFnlCostAmt(JSPUtil.getParameter(request, prefix + "d_cmmt_fnl_cost_amt", ""));
		//SJH.20141028.ADD
		setOrgCoSlsAmt(JSPUtil.getParameter(request, prefix + "org_co_sls_amt", ""));
		setSltInterPrcAmt(JSPUtil.getParameter(request, prefix + "slt_inter_prc_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchFixCostDistListVO[]
	 */
	public SearchFixCostDistListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchFixCostDistListVO[]
	 */
	public SearchFixCostDistListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchFixCostDistListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dTsRto = (JSPUtil.getParameter(request, prefix	+ "d_ts_rto", length));
			String[] dRlaneCd = (JSPUtil.getParameter(request, prefix	+ "d_rlane_cd", length));
			String[] dVvdCd = (JSPUtil.getParameter(request, prefix	+ "d_vvd_cd", length));
			String[] dTrdCd = (JSPUtil.getParameter(request, prefix	+ "d_trd_cd", length));
			String[] dIocCd = (JSPUtil.getParameter(request, prefix	+ "d_ioc_cd", length));
			String[] mRlaneCd = (JSPUtil.getParameter(request, prefix	+ "m_rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mTsUcAmt = (JSPUtil.getParameter(request, prefix	+ "m_ts_uc_amt", length));
			String[] dTsCtrbBseCostAmt = (JSPUtil.getParameter(request, prefix	+ "d_ts_ctrb_bse_cost_amt", length));
			String[] mSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "m_skd_voy_no", length));
			String[] dCmmtBseCostRto = (JSPUtil.getParameter(request, prefix	+ "d_cmmt_bse_cost_rto", length));
			String[] dTsQty = (JSPUtil.getParameter(request, prefix	+ "d_ts_qty", length));
			String[] dCmmtDiffCostAmt = (JSPUtil.getParameter(request, prefix	+ "d_cmmt_diff_cost_amt", length));
			String[] mCoSlsAmt = (JSPUtil.getParameter(request, prefix	+ "m_co_sls_amt", length));
			String[] dBsaBseCostAmt = (JSPUtil.getParameter(request, prefix	+ "d_bsa_bse_cost_amt", length));
			String[] mIocCd = (JSPUtil.getParameter(request, prefix	+ "m_ioc_cd", length));
			String[] dLoclTsStsCd = (JSPUtil.getParameter(request, prefix	+ "d_locl_ts_sts_cd", length));
			String[] dFxCostDtrbAmt = (JSPUtil.getParameter(request, prefix	+ "d_fx_cost_dtrb_amt", length));
			String[] dCmmtBseCostAmt = (JSPUtil.getParameter(request, prefix	+ "d_cmmt_bse_cost_amt", length));
			String[] mTrdCd = (JSPUtil.getParameter(request, prefix	+ "m_trd_cd", length));
			String[] dCmmtAddCostAmt = (JSPUtil.getParameter(request, prefix	+ "d_cmmt_add_cost_amt", length));
			String[] mVslCd = (JSPUtil.getParameter(request, prefix	+ "m_vsl_cd", length));
			String[] dCmlBseCostAmt = (JSPUtil.getParameter(request, prefix	+ "d_cml_bse_cost_amt", length));
			String[] dCmmtQty = (JSPUtil.getParameter(request, prefix	+ "d_cmmt_qty", length));
			String[] mDirCd = (JSPUtil.getParameter(request, prefix	+ "m_dir_cd", length));
			String[] dCmmtFnlCostAmt = (JSPUtil.getParameter(request, prefix	+ "d_cmmt_fnl_cost_amt", length));
			//SJH.20141028.ADD
			String[] orgCoSlsAmt = (JSPUtil.getParameter(request, prefix	+ "org_co_sls_amt", length));
			String[] sltInterPrcAmt = (JSPUtil.getParameter(request, prefix	+ "slt_inter_prc_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchFixCostDistListVO();
				if (dTsRto[i] != null)
					model.setDTsRto(dTsRto[i]);
				if (dRlaneCd[i] != null)
					model.setDRlaneCd(dRlaneCd[i]);
				if (dVvdCd[i] != null)
					model.setDVvdCd(dVvdCd[i]);
				if (dTrdCd[i] != null)
					model.setDTrdCd(dTrdCd[i]);
				if (dIocCd[i] != null)
					model.setDIocCd(dIocCd[i]);
				if (mRlaneCd[i] != null)
					model.setMRlaneCd(mRlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mTsUcAmt[i] != null)
					model.setMTsUcAmt(mTsUcAmt[i]);
				if (dTsCtrbBseCostAmt[i] != null)
					model.setDTsCtrbBseCostAmt(dTsCtrbBseCostAmt[i]);
				if (mSkdVoyNo[i] != null)
					model.setMSkdVoyNo(mSkdVoyNo[i]);
				if (dCmmtBseCostRto[i] != null)
					model.setDCmmtBseCostRto(dCmmtBseCostRto[i]);
				if (dTsQty[i] != null)
					model.setDTsQty(dTsQty[i]);
				if (dCmmtDiffCostAmt[i] != null)
					model.setDCmmtDiffCostAmt(dCmmtDiffCostAmt[i]);
				if (mCoSlsAmt[i] != null)
					model.setMCoSlsAmt(mCoSlsAmt[i]);
				if (dBsaBseCostAmt[i] != null)
					model.setDBsaBseCostAmt(dBsaBseCostAmt[i]);
				if (mIocCd[i] != null)
					model.setMIocCd(mIocCd[i]);
				if (dLoclTsStsCd[i] != null)
					model.setDLoclTsStsCd(dLoclTsStsCd[i]);
				if (dFxCostDtrbAmt[i] != null)
					model.setDFxCostDtrbAmt(dFxCostDtrbAmt[i]);
				if (dCmmtBseCostAmt[i] != null)
					model.setDCmmtBseCostAmt(dCmmtBseCostAmt[i]);
				if (mTrdCd[i] != null)
					model.setMTrdCd(mTrdCd[i]);
				if (dCmmtAddCostAmt[i] != null)
					model.setDCmmtAddCostAmt(dCmmtAddCostAmt[i]);
				if (mVslCd[i] != null)
					model.setMVslCd(mVslCd[i]);
				if (dCmlBseCostAmt[i] != null)
					model.setDCmlBseCostAmt(dCmlBseCostAmt[i]);
				if (dCmmtQty[i] != null)
					model.setDCmmtQty(dCmmtQty[i]);
				if (mDirCd[i] != null)
					model.setMDirCd(mDirCd[i]);
				if (dCmmtFnlCostAmt[i] != null)
					model.setDCmmtFnlCostAmt(dCmmtFnlCostAmt[i]);
				//SJH.20141028.ADD
				if (orgCoSlsAmt[i] != null)
					model.setOrgCoSlsAmt(orgCoSlsAmt[i]);
				if (sltInterPrcAmt[i] != null)
					model.setSltInterPrcAmt(sltInterPrcAmt[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFixCostDistListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchFixCostDistListVO[]
	 */
	public SearchFixCostDistListVO[] getSearchFixCostDistListVOs(){
		SearchFixCostDistListVO[] vos = (SearchFixCostDistListVO[])models.toArray(new SearchFixCostDistListVO[models.size()]);
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
		this.dTsRto = this.dTsRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dRlaneCd = this.dRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dVvdCd = this.dVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dTrdCd = this.dTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dIocCd = this.dIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mRlaneCd = this.mRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mTsUcAmt = this.mTsUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dTsCtrbBseCostAmt = this.dTsCtrbBseCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mSkdVoyNo = this.mSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCmmtBseCostRto = this.dCmmtBseCostRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dTsQty = this.dTsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCmmtDiffCostAmt = this.dCmmtDiffCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mCoSlsAmt = this.mCoSlsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dBsaBseCostAmt = this.dBsaBseCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mIocCd = this.mIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dLoclTsStsCd = this.dLoclTsStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dFxCostDtrbAmt = this.dFxCostDtrbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCmmtBseCostAmt = this.dCmmtBseCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mTrdCd = this.mTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCmmtAddCostAmt = this.dCmmtAddCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mVslCd = this.mVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCmlBseCostAmt = this.dCmlBseCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCmmtQty = this.dCmmtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mDirCd = this.mDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCmmtFnlCostAmt = this.dCmmtFnlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		//SJH.20141028.ADD
		this.orgCoSlsAmt = this.orgCoSlsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sltInterPrcAmt = this.sltInterPrcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
