/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchFixCostDistNewListVO.java
*@FileTitle : SearchFixCostDistNewListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.04  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchFixCostDistNewListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchFixCostDistNewListVO> models = new ArrayList<SearchFixCostDistNewListVO>();
	
	/* Column Info */
	private String dTsRto = null;
	/* Column Info */
	private String dBsaCmmtRto = null;
	/* Column Info */
	private String dRlaneCd = null;
	/* Column Info */
	private String dVvdCd = null;
	/* Column Info */
	private String adjTrdOtrFnlAmt = null;
	/* Column Info */
	private String toTrdOtrInitAmt = null;
	/* Column Info */
	private String dTrdCd = null;
	/* Column Info */
	private String mHulBndCd = null;
	/* Column Info */
	private String dIocCd = null;
	/* Column Info */
	private String mRlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ddTrdCd = null;
	/* Column Info */
	private String mTsUcAmt = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String dCmmtBseCostRto = null;
	/* Column Info */
	private String dTsQty = null;
	/* Column Info */
	private String dCostWk = null;
	/* Column Info */
	private String mHjsSlsAmt = null;
	/* Column Info */
	private String mVvdCd = null;
	/* Column Info */
	private String mIocCd = null;
	/* Column Info */
	private String dLoclTsStsCd = null;
	/* Column Info */
	private String dFxCostDtrbAmt = null;
	/* Column Info */
	private String dCmmtBseCostAmt = null;
	/* Column Info */
	private String dHulBndCd = null;
	/* Column Info */
	private String vvdTtlQty = null;
	/* Column Info */
	private String mTrdCd = null;
	/* Column Info */
	private String dCmmtAddCostAmt = null;
	/* Column Info */
	private String toInitTtlAmt = null;
	/* Column Info */
	private String dCostYrmon = null;
	/* Column Info */
	private String adjFnlAmt = null;
	/* Column Info */
	private String adjLaneFnlAmt = null;
	/* Column Info */
	private String dCmmtQty = null;
	/* Column Info */
	private String fnlHjsBsaCapa = null;
	/* Column Info */
	private String mCostWk = null;
	/* Column Info */
	private String adjRemark = null;
	/* Column Info */
	private String toLaneInitAmt = null;
	/* Column Info */
	private String mCostYrmon = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchFixCostDistNewListVO() {}

	public SearchFixCostDistNewListVO(String ibflag, String pagerows, String mCostYrmon, String mCostWk, String mTrdCd, String mRlaneCd, String mIocCd, String mHulBndCd, String mVvdCd, String rnum, String fnlHjsBsaCapa, String mTsUcAmt, String mHjsSlsAmt, String dCostYrmon, String dCostWk, String dTrdCd, String ddTrdCd, String dBsaCmmtRto, String dRlaneCd, String dIocCd, String dHulBndCd, String dVvdCd, String dLoclTsStsCd, String dTsQty, String vvdTtlQty, String dTsRto, String dFxCostDtrbAmt, String dCmmtQty, String dCmmtBseCostRto, String dCmmtBseCostAmt, String dCmmtAddCostAmt, String toLaneInitAmt, String toTrdOtrInitAmt, String toInitTtlAmt, String adjLaneFnlAmt, String adjTrdOtrFnlAmt, String adjFnlAmt, String adjRemark) {
		this.dTsRto = dTsRto;
		this.dBsaCmmtRto = dBsaCmmtRto;
		this.dRlaneCd = dRlaneCd;
		this.dVvdCd = dVvdCd;
		this.adjTrdOtrFnlAmt = adjTrdOtrFnlAmt;
		this.toTrdOtrInitAmt = toTrdOtrInitAmt;
		this.dTrdCd = dTrdCd;
		this.mHulBndCd = mHulBndCd;
		this.dIocCd = dIocCd;
		this.mRlaneCd = mRlaneCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.ddTrdCd = ddTrdCd;
		this.mTsUcAmt = mTsUcAmt;
		this.rnum = rnum;
		this.dCmmtBseCostRto = dCmmtBseCostRto;
		this.dTsQty = dTsQty;
		this.dCostWk = dCostWk;
		this.mHjsSlsAmt = mHjsSlsAmt;
		this.mVvdCd = mVvdCd;
		this.mIocCd = mIocCd;
		this.dLoclTsStsCd = dLoclTsStsCd;
		this.dFxCostDtrbAmt = dFxCostDtrbAmt;
		this.dCmmtBseCostAmt = dCmmtBseCostAmt;
		this.dHulBndCd = dHulBndCd;
		this.vvdTtlQty = vvdTtlQty;
		this.mTrdCd = mTrdCd;
		this.dCmmtAddCostAmt = dCmmtAddCostAmt;
		this.toInitTtlAmt = toInitTtlAmt;
		this.dCostYrmon = dCostYrmon;
		this.adjFnlAmt = adjFnlAmt;
		this.adjLaneFnlAmt = adjLaneFnlAmt;
		this.dCmmtQty = dCmmtQty;
		this.fnlHjsBsaCapa = fnlHjsBsaCapa;
		this.mCostWk = mCostWk;
		this.adjRemark = adjRemark;
		this.toLaneInitAmt = toLaneInitAmt;
		this.mCostYrmon = mCostYrmon;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("d_ts_rto", getDTsRto());
		this.hashColumns.put("d_bsa_cmmt_rto", getDBsaCmmtRto());
		this.hashColumns.put("d_rlane_cd", getDRlaneCd());
		this.hashColumns.put("d_vvd_cd", getDVvdCd());
		this.hashColumns.put("adj_trd_otr_fnl_amt", getAdjTrdOtrFnlAmt());
		this.hashColumns.put("to_trd_otr_init_amt", getToTrdOtrInitAmt());
		this.hashColumns.put("d_trd_cd", getDTrdCd());
		this.hashColumns.put("m_hul_bnd_cd", getMHulBndCd());
		this.hashColumns.put("d_ioc_cd", getDIocCd());
		this.hashColumns.put("m_rlane_cd", getMRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dd_trd_cd", getDdTrdCd());
		this.hashColumns.put("m_ts_uc_amt", getMTsUcAmt());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("d_cmmt_bse_cost_rto", getDCmmtBseCostRto());
		this.hashColumns.put("d_ts_qty", getDTsQty());
		this.hashColumns.put("d_cost_wk", getDCostWk());
		this.hashColumns.put("m_hjs_sls_amt", getMHjsSlsAmt());
		this.hashColumns.put("m_vvd_cd", getMVvdCd());
		this.hashColumns.put("m_ioc_cd", getMIocCd());
		this.hashColumns.put("d_locl_ts_sts_cd", getDLoclTsStsCd());
		this.hashColumns.put("d_fx_cost_dtrb_amt", getDFxCostDtrbAmt());
		this.hashColumns.put("d_cmmt_bse_cost_amt", getDCmmtBseCostAmt());
		this.hashColumns.put("d_hul_bnd_cd", getDHulBndCd());
		this.hashColumns.put("vvd_ttl_qty", getVvdTtlQty());
		this.hashColumns.put("m_trd_cd", getMTrdCd());
		this.hashColumns.put("d_cmmt_add_cost_amt", getDCmmtAddCostAmt());
		this.hashColumns.put("to_init_ttl_amt", getToInitTtlAmt());
		this.hashColumns.put("d_cost_yrmon", getDCostYrmon());
		this.hashColumns.put("adj_fnl_amt", getAdjFnlAmt());
		this.hashColumns.put("adj_lane_fnl_amt", getAdjLaneFnlAmt());
		this.hashColumns.put("d_cmmt_qty", getDCmmtQty());
		this.hashColumns.put("fnl_hjs_bsa_capa", getFnlHjsBsaCapa());
		this.hashColumns.put("m_cost_wk", getMCostWk());
		this.hashColumns.put("adj_remark", getAdjRemark());
		this.hashColumns.put("to_lane_init_amt", getToLaneInitAmt());
		this.hashColumns.put("m_cost_yrmon", getMCostYrmon());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("d_ts_rto", "dTsRto");
		this.hashFields.put("d_bsa_cmmt_rto", "dBsaCmmtRto");
		this.hashFields.put("d_rlane_cd", "dRlaneCd");
		this.hashFields.put("d_vvd_cd", "dVvdCd");
		this.hashFields.put("adj_trd_otr_fnl_amt", "adjTrdOtrFnlAmt");
		this.hashFields.put("to_trd_otr_init_amt", "toTrdOtrInitAmt");
		this.hashFields.put("d_trd_cd", "dTrdCd");
		this.hashFields.put("m_hul_bnd_cd", "mHulBndCd");
		this.hashFields.put("d_ioc_cd", "dIocCd");
		this.hashFields.put("m_rlane_cd", "mRlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dd_trd_cd", "ddTrdCd");
		this.hashFields.put("m_ts_uc_amt", "mTsUcAmt");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("d_cmmt_bse_cost_rto", "dCmmtBseCostRto");
		this.hashFields.put("d_ts_qty", "dTsQty");
		this.hashFields.put("d_cost_wk", "dCostWk");
		this.hashFields.put("m_hjs_sls_amt", "mHjsSlsAmt");
		this.hashFields.put("m_vvd_cd", "mVvdCd");
		this.hashFields.put("m_ioc_cd", "mIocCd");
		this.hashFields.put("d_locl_ts_sts_cd", "dLoclTsStsCd");
		this.hashFields.put("d_fx_cost_dtrb_amt", "dFxCostDtrbAmt");
		this.hashFields.put("d_cmmt_bse_cost_amt", "dCmmtBseCostAmt");
		this.hashFields.put("d_hul_bnd_cd", "dHulBndCd");
		this.hashFields.put("vvd_ttl_qty", "vvdTtlQty");
		this.hashFields.put("m_trd_cd", "mTrdCd");
		this.hashFields.put("d_cmmt_add_cost_amt", "dCmmtAddCostAmt");
		this.hashFields.put("to_init_ttl_amt", "toInitTtlAmt");
		this.hashFields.put("d_cost_yrmon", "dCostYrmon");
		this.hashFields.put("adj_fnl_amt", "adjFnlAmt");
		this.hashFields.put("adj_lane_fnl_amt", "adjLaneFnlAmt");
		this.hashFields.put("d_cmmt_qty", "dCmmtQty");
		this.hashFields.put("fnl_hjs_bsa_capa", "fnlHjsBsaCapa");
		this.hashFields.put("m_cost_wk", "mCostWk");
		this.hashFields.put("adj_remark", "adjRemark");
		this.hashFields.put("to_lane_init_amt", "toLaneInitAmt");
		this.hashFields.put("m_cost_yrmon", "mCostYrmon");
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
	 * @return dBsaCmmtRto
	 */
	public String getDBsaCmmtRto() {
		return this.dBsaCmmtRto;
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
	 * @return adjTrdOtrFnlAmt
	 */
	public String getAdjTrdOtrFnlAmt() {
		return this.adjTrdOtrFnlAmt;
	}
	
	/**
	 * Column Info
	 * @return toTrdOtrInitAmt
	 */
	public String getToTrdOtrInitAmt() {
		return this.toTrdOtrInitAmt;
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
	 * @return mHulBndCd
	 */
	public String getMHulBndCd() {
		return this.mHulBndCd;
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
	 * @return ddTrdCd
	 */
	public String getDdTrdCd() {
		return this.ddTrdCd;
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
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
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
	 * @return dCostWk
	 */
	public String getDCostWk() {
		return this.dCostWk;
	}
	
	/**
	 * Column Info
	 * @return mHjsSlsAmt
	 */
	public String getMHjsSlsAmt() {
		return this.mHjsSlsAmt;
	}
	
	/**
	 * Column Info
	 * @return mVvdCd
	 */
	public String getMVvdCd() {
		return this.mVvdCd;
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
	 * @return dHulBndCd
	 */
	public String getDHulBndCd() {
		return this.dHulBndCd;
	}
	
	/**
	 * Column Info
	 * @return vvdTtlQty
	 */
	public String getVvdTtlQty() {
		return this.vvdTtlQty;
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
	 * @return toInitTtlAmt
	 */
	public String getToInitTtlAmt() {
		return this.toInitTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return dCostYrmon
	 */
	public String getDCostYrmon() {
		return this.dCostYrmon;
	}
	
	/**
	 * Column Info
	 * @return adjFnlAmt
	 */
	public String getAdjFnlAmt() {
		return this.adjFnlAmt;
	}
	
	/**
	 * Column Info
	 * @return adjLaneFnlAmt
	 */
	public String getAdjLaneFnlAmt() {
		return this.adjLaneFnlAmt;
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
	 * @return fnlHjsBsaCapa
	 */
	public String getFnlHjsBsaCapa() {
		return this.fnlHjsBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return mCostWk
	 */
	public String getMCostWk() {
		return this.mCostWk;
	}
	
	/**
	 * Column Info
	 * @return adjRemark
	 */
	public String getAdjRemark() {
		return this.adjRemark;
	}
	
	/**
	 * Column Info
	 * @return toLaneInitAmt
	 */
	public String getToLaneInitAmt() {
		return this.toLaneInitAmt;
	}
	
	/**
	 * Column Info
	 * @return mCostYrmon
	 */
	public String getMCostYrmon() {
		return this.mCostYrmon;
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
	 * @param dBsaCmmtRto
	 */
	public void setDBsaCmmtRto(String dBsaCmmtRto) {
		this.dBsaCmmtRto = dBsaCmmtRto;
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
	 * @param adjTrdOtrFnlAmt
	 */
	public void setAdjTrdOtrFnlAmt(String adjTrdOtrFnlAmt) {
		this.adjTrdOtrFnlAmt = adjTrdOtrFnlAmt;
	}
	
	/**
	 * Column Info
	 * @param toTrdOtrInitAmt
	 */
	public void setToTrdOtrInitAmt(String toTrdOtrInitAmt) {
		this.toTrdOtrInitAmt = toTrdOtrInitAmt;
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
	 * @param mHulBndCd
	 */
	public void setMHulBndCd(String mHulBndCd) {
		this.mHulBndCd = mHulBndCd;
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
	 * @param ddTrdCd
	 */
	public void setDdTrdCd(String ddTrdCd) {
		this.ddTrdCd = ddTrdCd;
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
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
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
	 * @param dCostWk
	 */
	public void setDCostWk(String dCostWk) {
		this.dCostWk = dCostWk;
	}
	
	/**
	 * Column Info
	 * @param mHjsSlsAmt
	 */
	public void setMHjsSlsAmt(String mHjsSlsAmt) {
		this.mHjsSlsAmt = mHjsSlsAmt;
	}
	
	/**
	 * Column Info
	 * @param mVvdCd
	 */
	public void setMVvdCd(String mVvdCd) {
		this.mVvdCd = mVvdCd;
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
	 * @param dHulBndCd
	 */
	public void setDHulBndCd(String dHulBndCd) {
		this.dHulBndCd = dHulBndCd;
	}
	
	/**
	 * Column Info
	 * @param vvdTtlQty
	 */
	public void setVvdTtlQty(String vvdTtlQty) {
		this.vvdTtlQty = vvdTtlQty;
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
	 * @param toInitTtlAmt
	 */
	public void setToInitTtlAmt(String toInitTtlAmt) {
		this.toInitTtlAmt = toInitTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param dCostYrmon
	 */
	public void setDCostYrmon(String dCostYrmon) {
		this.dCostYrmon = dCostYrmon;
	}
	
	/**
	 * Column Info
	 * @param adjFnlAmt
	 */
	public void setAdjFnlAmt(String adjFnlAmt) {
		this.adjFnlAmt = adjFnlAmt;
	}
	
	/**
	 * Column Info
	 * @param adjLaneFnlAmt
	 */
	public void setAdjLaneFnlAmt(String adjLaneFnlAmt) {
		this.adjLaneFnlAmt = adjLaneFnlAmt;
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
	 * @param fnlHjsBsaCapa
	 */
	public void setFnlHjsBsaCapa(String fnlHjsBsaCapa) {
		this.fnlHjsBsaCapa = fnlHjsBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param mCostWk
	 */
	public void setMCostWk(String mCostWk) {
		this.mCostWk = mCostWk;
	}
	
	/**
	 * Column Info
	 * @param adjRemark
	 */
	public void setAdjRemark(String adjRemark) {
		this.adjRemark = adjRemark;
	}
	
	/**
	 * Column Info
	 * @param toLaneInitAmt
	 */
	public void setToLaneInitAmt(String toLaneInitAmt) {
		this.toLaneInitAmt = toLaneInitAmt;
	}
	
	/**
	 * Column Info
	 * @param mCostYrmon
	 */
	public void setMCostYrmon(String mCostYrmon) {
		this.mCostYrmon = mCostYrmon;
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
		setDBsaCmmtRto(JSPUtil.getParameter(request, prefix + "d_bsa_cmmt_rto", ""));
		setDRlaneCd(JSPUtil.getParameter(request, prefix + "d_rlane_cd", ""));
		setDVvdCd(JSPUtil.getParameter(request, prefix + "d_vvd_cd", ""));
		setAdjTrdOtrFnlAmt(JSPUtil.getParameter(request, prefix + "adj_trd_otr_fnl_amt", ""));
		setToTrdOtrInitAmt(JSPUtil.getParameter(request, prefix + "to_trd_otr_init_amt", ""));
		setDTrdCd(JSPUtil.getParameter(request, prefix + "d_trd_cd", ""));
		setMHulBndCd(JSPUtil.getParameter(request, prefix + "m_hul_bnd_cd", ""));
		setDIocCd(JSPUtil.getParameter(request, prefix + "d_ioc_cd", ""));
		setMRlaneCd(JSPUtil.getParameter(request, prefix + "m_rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDdTrdCd(JSPUtil.getParameter(request, prefix + "dd_trd_cd", ""));
		setMTsUcAmt(JSPUtil.getParameter(request, prefix + "m_ts_uc_amt", ""));
		setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
		setDCmmtBseCostRto(JSPUtil.getParameter(request, prefix + "d_cmmt_bse_cost_rto", ""));
		setDTsQty(JSPUtil.getParameter(request, prefix + "d_ts_qty", ""));
		setDCostWk(JSPUtil.getParameter(request, prefix + "d_cost_wk", ""));
		setMHjsSlsAmt(JSPUtil.getParameter(request, prefix + "m_hjs_sls_amt", ""));
		setMVvdCd(JSPUtil.getParameter(request, prefix + "m_vvd_cd", ""));
		setMIocCd(JSPUtil.getParameter(request, prefix + "m_ioc_cd", ""));
		setDLoclTsStsCd(JSPUtil.getParameter(request, prefix + "d_locl_ts_sts_cd", ""));
		setDFxCostDtrbAmt(JSPUtil.getParameter(request, prefix + "d_fx_cost_dtrb_amt", ""));
		setDCmmtBseCostAmt(JSPUtil.getParameter(request, prefix + "d_cmmt_bse_cost_amt", ""));
		setDHulBndCd(JSPUtil.getParameter(request, prefix + "d_hul_bnd_cd", ""));
		setVvdTtlQty(JSPUtil.getParameter(request, prefix + "vvd_ttl_qty", ""));
		setMTrdCd(JSPUtil.getParameter(request, prefix + "m_trd_cd", ""));
		setDCmmtAddCostAmt(JSPUtil.getParameter(request, prefix + "d_cmmt_add_cost_amt", ""));
		setToInitTtlAmt(JSPUtil.getParameter(request, prefix + "to_init_ttl_amt", ""));
		setDCostYrmon(JSPUtil.getParameter(request, prefix + "d_cost_yrmon", ""));
		setAdjFnlAmt(JSPUtil.getParameter(request, prefix + "adj_fnl_amt", ""));
		setAdjLaneFnlAmt(JSPUtil.getParameter(request, prefix + "adj_lane_fnl_amt", ""));
		setDCmmtQty(JSPUtil.getParameter(request, prefix + "d_cmmt_qty", ""));
		setFnlHjsBsaCapa(JSPUtil.getParameter(request, prefix + "fnl_hjs_bsa_capa", ""));
		setMCostWk(JSPUtil.getParameter(request, prefix + "m_cost_wk", ""));
		setAdjRemark(JSPUtil.getParameter(request, prefix + "adj_remark", ""));
		setToLaneInitAmt(JSPUtil.getParameter(request, prefix + "to_lane_init_amt", ""));
		setMCostYrmon(JSPUtil.getParameter(request, prefix + "m_cost_yrmon", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchFixCostDistNewListVO[]
	 */
	public SearchFixCostDistNewListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchFixCostDistNewListVO[]
	 */
	public SearchFixCostDistNewListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchFixCostDistNewListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dTsRto = (JSPUtil.getParameter(request, prefix	+ "d_ts_rto", length));
			String[] dBsaCmmtRto = (JSPUtil.getParameter(request, prefix	+ "d_bsa_cmmt_rto", length));
			String[] dRlaneCd = (JSPUtil.getParameter(request, prefix	+ "d_rlane_cd", length));
			String[] dVvdCd = (JSPUtil.getParameter(request, prefix	+ "d_vvd_cd", length));
			String[] adjTrdOtrFnlAmt = (JSPUtil.getParameter(request, prefix	+ "adj_trd_otr_fnl_amt", length));
			String[] toTrdOtrInitAmt = (JSPUtil.getParameter(request, prefix	+ "to_trd_otr_init_amt", length));
			String[] dTrdCd = (JSPUtil.getParameter(request, prefix	+ "d_trd_cd", length));
			String[] mHulBndCd = (JSPUtil.getParameter(request, prefix	+ "m_hul_bnd_cd", length));
			String[] dIocCd = (JSPUtil.getParameter(request, prefix	+ "d_ioc_cd", length));
			String[] mRlaneCd = (JSPUtil.getParameter(request, prefix	+ "m_rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ddTrdCd = (JSPUtil.getParameter(request, prefix	+ "dd_trd_cd", length));
			String[] mTsUcAmt = (JSPUtil.getParameter(request, prefix	+ "m_ts_uc_amt", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] dCmmtBseCostRto = (JSPUtil.getParameter(request, prefix	+ "d_cmmt_bse_cost_rto", length));
			String[] dTsQty = (JSPUtil.getParameter(request, prefix	+ "d_ts_qty", length));
			String[] dCostWk = (JSPUtil.getParameter(request, prefix	+ "d_cost_wk", length));
			String[] mHjsSlsAmt = (JSPUtil.getParameter(request, prefix	+ "m_hjs_sls_amt", length));
			String[] mVvdCd = (JSPUtil.getParameter(request, prefix	+ "m_vvd_cd", length));
			String[] mIocCd = (JSPUtil.getParameter(request, prefix	+ "m_ioc_cd", length));
			String[] dLoclTsStsCd = (JSPUtil.getParameter(request, prefix	+ "d_locl_ts_sts_cd", length));
			String[] dFxCostDtrbAmt = (JSPUtil.getParameter(request, prefix	+ "d_fx_cost_dtrb_amt", length));
			String[] dCmmtBseCostAmt = (JSPUtil.getParameter(request, prefix	+ "d_cmmt_bse_cost_amt", length));
			String[] dHulBndCd = (JSPUtil.getParameter(request, prefix	+ "d_hul_bnd_cd", length));
			String[] vvdTtlQty = (JSPUtil.getParameter(request, prefix	+ "vvd_ttl_qty", length));
			String[] mTrdCd = (JSPUtil.getParameter(request, prefix	+ "m_trd_cd", length));
			String[] dCmmtAddCostAmt = (JSPUtil.getParameter(request, prefix	+ "d_cmmt_add_cost_amt", length));
			String[] toInitTtlAmt = (JSPUtil.getParameter(request, prefix	+ "to_init_ttl_amt", length));
			String[] dCostYrmon = (JSPUtil.getParameter(request, prefix	+ "d_cost_yrmon", length));
			String[] adjFnlAmt = (JSPUtil.getParameter(request, prefix	+ "adj_fnl_amt", length));
			String[] adjLaneFnlAmt = (JSPUtil.getParameter(request, prefix	+ "adj_lane_fnl_amt", length));
			String[] dCmmtQty = (JSPUtil.getParameter(request, prefix	+ "d_cmmt_qty", length));
			String[] fnlHjsBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_hjs_bsa_capa", length));
			String[] mCostWk = (JSPUtil.getParameter(request, prefix	+ "m_cost_wk", length));
			String[] adjRemark = (JSPUtil.getParameter(request, prefix	+ "adj_remark", length));
			String[] toLaneInitAmt = (JSPUtil.getParameter(request, prefix	+ "to_lane_init_amt", length));
			String[] mCostYrmon = (JSPUtil.getParameter(request, prefix	+ "m_cost_yrmon", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchFixCostDistNewListVO();
				if (dTsRto[i] != null)
					model.setDTsRto(dTsRto[i]);
				if (dBsaCmmtRto[i] != null)
					model.setDBsaCmmtRto(dBsaCmmtRto[i]);
				if (dRlaneCd[i] != null)
					model.setDRlaneCd(dRlaneCd[i]);
				if (dVvdCd[i] != null)
					model.setDVvdCd(dVvdCd[i]);
				if (adjTrdOtrFnlAmt[i] != null)
					model.setAdjTrdOtrFnlAmt(adjTrdOtrFnlAmt[i]);
				if (toTrdOtrInitAmt[i] != null)
					model.setToTrdOtrInitAmt(toTrdOtrInitAmt[i]);
				if (dTrdCd[i] != null)
					model.setDTrdCd(dTrdCd[i]);
				if (mHulBndCd[i] != null)
					model.setMHulBndCd(mHulBndCd[i]);
				if (dIocCd[i] != null)
					model.setDIocCd(dIocCd[i]);
				if (mRlaneCd[i] != null)
					model.setMRlaneCd(mRlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ddTrdCd[i] != null)
					model.setDdTrdCd(ddTrdCd[i]);
				if (mTsUcAmt[i] != null)
					model.setMTsUcAmt(mTsUcAmt[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (dCmmtBseCostRto[i] != null)
					model.setDCmmtBseCostRto(dCmmtBseCostRto[i]);
				if (dTsQty[i] != null)
					model.setDTsQty(dTsQty[i]);
				if (dCostWk[i] != null)
					model.setDCostWk(dCostWk[i]);
				if (mHjsSlsAmt[i] != null)
					model.setMHjsSlsAmt(mHjsSlsAmt[i]);
				if (mVvdCd[i] != null)
					model.setMVvdCd(mVvdCd[i]);
				if (mIocCd[i] != null)
					model.setMIocCd(mIocCd[i]);
				if (dLoclTsStsCd[i] != null)
					model.setDLoclTsStsCd(dLoclTsStsCd[i]);
				if (dFxCostDtrbAmt[i] != null)
					model.setDFxCostDtrbAmt(dFxCostDtrbAmt[i]);
				if (dCmmtBseCostAmt[i] != null)
					model.setDCmmtBseCostAmt(dCmmtBseCostAmt[i]);
				if (dHulBndCd[i] != null)
					model.setDHulBndCd(dHulBndCd[i]);
				if (vvdTtlQty[i] != null)
					model.setVvdTtlQty(vvdTtlQty[i]);
				if (mTrdCd[i] != null)
					model.setMTrdCd(mTrdCd[i]);
				if (dCmmtAddCostAmt[i] != null)
					model.setDCmmtAddCostAmt(dCmmtAddCostAmt[i]);
				if (toInitTtlAmt[i] != null)
					model.setToInitTtlAmt(toInitTtlAmt[i]);
				if (dCostYrmon[i] != null)
					model.setDCostYrmon(dCostYrmon[i]);
				if (adjFnlAmt[i] != null)
					model.setAdjFnlAmt(adjFnlAmt[i]);
				if (adjLaneFnlAmt[i] != null)
					model.setAdjLaneFnlAmt(adjLaneFnlAmt[i]);
				if (dCmmtQty[i] != null)
					model.setDCmmtQty(dCmmtQty[i]);
				if (fnlHjsBsaCapa[i] != null)
					model.setFnlHjsBsaCapa(fnlHjsBsaCapa[i]);
				if (mCostWk[i] != null)
					model.setMCostWk(mCostWk[i]);
				if (adjRemark[i] != null)
					model.setAdjRemark(adjRemark[i]);
				if (toLaneInitAmt[i] != null)
					model.setToLaneInitAmt(toLaneInitAmt[i]);
				if (mCostYrmon[i] != null)
					model.setMCostYrmon(mCostYrmon[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFixCostDistNewListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchFixCostDistNewListVO[]
	 */
	public SearchFixCostDistNewListVO[] getSearchFixCostDistNewListVOs(){
		SearchFixCostDistNewListVO[] vos = (SearchFixCostDistNewListVO[])models.toArray(new SearchFixCostDistNewListVO[models.size()]);
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
		this.dBsaCmmtRto = this.dBsaCmmtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dRlaneCd = this.dRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dVvdCd = this.dVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjTrdOtrFnlAmt = this.adjTrdOtrFnlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTrdOtrInitAmt = this.toTrdOtrInitAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dTrdCd = this.dTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mHulBndCd = this.mHulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dIocCd = this.dIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mRlaneCd = this.mRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddTrdCd = this.ddTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mTsUcAmt = this.mTsUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCmmtBseCostRto = this.dCmmtBseCostRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dTsQty = this.dTsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCostWk = this.dCostWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mHjsSlsAmt = this.mHjsSlsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mVvdCd = this.mVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mIocCd = this.mIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dLoclTsStsCd = this.dLoclTsStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dFxCostDtrbAmt = this.dFxCostDtrbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCmmtBseCostAmt = this.dCmmtBseCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dHulBndCd = this.dHulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdTtlQty = this.vvdTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mTrdCd = this.mTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCmmtAddCostAmt = this.dCmmtAddCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toInitTtlAmt = this.toInitTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCostYrmon = this.dCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjFnlAmt = this.adjFnlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjLaneFnlAmt = this.adjLaneFnlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCmmtQty = this.dCmmtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlHjsBsaCapa = this.fnlHjsBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mCostWk = this.mCostWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjRemark = this.adjRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLaneInitAmt = this.toLaneInitAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mCostYrmon = this.mCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
