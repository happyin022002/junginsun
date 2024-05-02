/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSoCodeVO.java
*@FileTitle : SearchSoCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 박상희
*@LastVersion : 1.0
* 2009.08.11 박상희 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo;

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
 * @author 박상희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSoCodeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSoCodeVO> models = new ArrayList<SearchSoCodeVO>();
	
	/* Column Info */
	private String masCostSrcCdNm = null;
	/* Column Info */
	private String bkgFullSocCgoFlg = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String costAssBseCd = null;
	/* Column Info */
	private String spclCgoAwkFlg = null;
	/* Column Info */
	private String bkgMcgoFlg = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String masCostSrcCd = null;
	/* Column Info */
	private String sgrpCostCd = null;
	/* Column Info */
	private String masCostSrcPrtCd = null;
	/* Column Info */
	private String costVolCd = null;
	/* Column Info */
	private String stndCostNm = null;
	/* Column Info */
	private String costUtAmtCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String costSrcSysCd = null;
	/* Column Info */
	private String costSrcMon = null;
	/* Column Info */
	private String costVolCd1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spclCgoDgFlg = null;
	/* Column Info */
	private String spclCgoRfFlg = null;
	/* Column Info */
	private String spclCgoBbFlg = null;
	/* Column Info */
	private String bkgRevMcgoFlg = null;
	/* Column Info */
	private String sgrpCostCdDesc = null;
	/* Column Info */
	private String stndCostCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSoCodeVO() {}

	public SearchSoCodeVO(String ibflag, String pagerows, String deltFlg, String sgrpCostCdDesc, String sgrpCostCd, String stndCostNm, String stndCostCd, String masCostSrcPrtCd, String costSrcSysCd, String costSrcMon, String masCostSrcCd, String masCostSrcCdNm, String costAssBseCd, String costUtAmtCd, String spclCgoDgFlg, String spclCgoRfFlg, String spclCgoAwkFlg, String costVolCd, String costVolCd1, String bkgCgoTpCd, String bkgFullSocCgoFlg, String bkgRevMcgoFlg, String spclCgoBbFlg, String bkgMcgoFlg) {
		this.masCostSrcCdNm = masCostSrcCdNm;
		this.bkgFullSocCgoFlg = bkgFullSocCgoFlg;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.costAssBseCd = costAssBseCd;
		this.spclCgoAwkFlg = spclCgoAwkFlg;
		this.bkgMcgoFlg = bkgMcgoFlg;
		this.deltFlg = deltFlg;
		this.masCostSrcCd = masCostSrcCd;
		this.sgrpCostCd = sgrpCostCd;
		this.masCostSrcPrtCd = masCostSrcPrtCd;
		this.costVolCd = costVolCd;
		this.stndCostNm = stndCostNm;
		this.costUtAmtCd = costUtAmtCd;
		this.pagerows = pagerows;
		this.costSrcSysCd = costSrcSysCd;
		this.costSrcMon = costSrcMon;
		this.costVolCd1 = costVolCd1;
		this.ibflag = ibflag;
		this.spclCgoDgFlg = spclCgoDgFlg;
		this.spclCgoRfFlg = spclCgoRfFlg;
		this.spclCgoBbFlg = spclCgoBbFlg;
		this.bkgRevMcgoFlg = bkgRevMcgoFlg;
		this.sgrpCostCdDesc = sgrpCostCdDesc;
		this.stndCostCd = stndCostCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mas_cost_src_cd_nm", getMasCostSrcCdNm());
		this.hashColumns.put("bkg_full_soc_cgo_flg", getBkgFullSocCgoFlg());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("cost_ass_bse_cd", getCostAssBseCd());
		this.hashColumns.put("spcl_cgo_awk_flg", getSpclCgoAwkFlg());
		this.hashColumns.put("bkg_mcgo_flg", getBkgMcgoFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("mas_cost_src_cd", getMasCostSrcCd());
		this.hashColumns.put("sgrp_cost_cd", getSgrpCostCd());
		this.hashColumns.put("mas_cost_src_prt_cd", getMasCostSrcPrtCd());
		this.hashColumns.put("cost_vol_cd", getCostVolCd());
		this.hashColumns.put("stnd_cost_nm", getStndCostNm());
		this.hashColumns.put("cost_ut_amt_cd", getCostUtAmtCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cost_src_sys_cd", getCostSrcSysCd());
		this.hashColumns.put("cost_src_mon", getCostSrcMon());
		this.hashColumns.put("cost_vol_cd1", getCostVolCd1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("spcl_cgo_dg_flg", getSpclCgoDgFlg());
		this.hashColumns.put("spcl_cgo_rf_flg", getSpclCgoRfFlg());
		this.hashColumns.put("spcl_cgo_bb_flg", getSpclCgoBbFlg());
		this.hashColumns.put("bkg_rev_mcgo_flg", getBkgRevMcgoFlg());
		this.hashColumns.put("sgrp_cost_cd_desc", getSgrpCostCdDesc());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mas_cost_src_cd_nm", "masCostSrcCdNm");
		this.hashFields.put("bkg_full_soc_cgo_flg", "bkgFullSocCgoFlg");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("cost_ass_bse_cd", "costAssBseCd");
		this.hashFields.put("spcl_cgo_awk_flg", "spclCgoAwkFlg");
		this.hashFields.put("bkg_mcgo_flg", "bkgMcgoFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("mas_cost_src_cd", "masCostSrcCd");
		this.hashFields.put("sgrp_cost_cd", "sgrpCostCd");
		this.hashFields.put("mas_cost_src_prt_cd", "masCostSrcPrtCd");
		this.hashFields.put("cost_vol_cd", "costVolCd");
		this.hashFields.put("stnd_cost_nm", "stndCostNm");
		this.hashFields.put("cost_ut_amt_cd", "costUtAmtCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cost_src_sys_cd", "costSrcSysCd");
		this.hashFields.put("cost_src_mon", "costSrcMon");
		this.hashFields.put("cost_vol_cd1", "costVolCd1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("spcl_cgo_dg_flg", "spclCgoDgFlg");
		this.hashFields.put("spcl_cgo_rf_flg", "spclCgoRfFlg");
		this.hashFields.put("spcl_cgo_bb_flg", "spclCgoBbFlg");
		this.hashFields.put("bkg_rev_mcgo_flg", "bkgRevMcgoFlg");
		this.hashFields.put("sgrp_cost_cd_desc", "sgrpCostCdDesc");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return masCostSrcCdNm
	 */
	public String getMasCostSrcCdNm() {
		return this.masCostSrcCdNm;
	}
	
	/**
	 * Column Info
	 * @return bkgFullSocCgoFlg
	 */
	public String getBkgFullSocCgoFlg() {
		return this.bkgFullSocCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return costAssBseCd
	 */
	public String getCostAssBseCd() {
		return this.costAssBseCd;
	}
	
	/**
	 * Column Info
	 * @return spclCgoAwkFlg
	 */
	public String getSpclCgoAwkFlg() {
		return this.spclCgoAwkFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgMcgoFlg
	 */
	public String getBkgMcgoFlg() {
		return this.bkgMcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return masCostSrcCd
	 */
	public String getMasCostSrcCd() {
		return this.masCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @return sgrpCostCd
	 */
	public String getSgrpCostCd() {
		return this.sgrpCostCd;
	}
	
	/**
	 * Column Info
	 * @return masCostSrcPrtCd
	 */
	public String getMasCostSrcPrtCd() {
		return this.masCostSrcPrtCd;
	}
	
	/**
	 * Column Info
	 * @return costVolCd
	 */
	public String getCostVolCd() {
		return this.costVolCd;
	}
	
	/**
	 * Column Info
	 * @return stndCostNm
	 */
	public String getStndCostNm() {
		return this.stndCostNm;
	}
	
	/**
	 * Column Info
	 * @return costUtAmtCd
	 */
	public String getCostUtAmtCd() {
		return this.costUtAmtCd;
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
	 * @return costSrcSysCd
	 */
	public String getCostSrcSysCd() {
		return this.costSrcSysCd;
	}
	
	/**
	 * Column Info
	 * @return costSrcMon
	 */
	public String getCostSrcMon() {
		return this.costSrcMon;
	}
	
	/**
	 * Column Info
	 * @return costVolCd1
	 */
	public String getCostVolCd1() {
		return this.costVolCd1;
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
	 * @return spclCgoDgFlg
	 */
	public String getSpclCgoDgFlg() {
		return this.spclCgoDgFlg;
	}
	
	/**
	 * Column Info
	 * @return spclCgoRfFlg
	 */
	public String getSpclCgoRfFlg() {
		return this.spclCgoRfFlg;
	}
	
	/**
	 * Column Info
	 * @return spclCgoBbFlg
	 */
	public String getSpclCgoBbFlg() {
		return this.spclCgoBbFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgRevMcgoFlg
	 */
	public String getBkgRevMcgoFlg() {
		return this.bkgRevMcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return sgrpCostCdDesc
	 */
	public String getSgrpCostCdDesc() {
		return this.sgrpCostCdDesc;
	}
	
	/**
	 * Column Info
	 * @return stndCostCd
	 */
	public String getStndCostCd() {
		return this.stndCostCd;
	}
	

	/**
	 * Column Info
	 * @param masCostSrcCdNm
	 */
	public void setMasCostSrcCdNm(String masCostSrcCdNm) {
		this.masCostSrcCdNm = masCostSrcCdNm;
	}
	
	/**
	 * Column Info
	 * @param bkgFullSocCgoFlg
	 */
	public void setBkgFullSocCgoFlg(String bkgFullSocCgoFlg) {
		this.bkgFullSocCgoFlg = bkgFullSocCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param costAssBseCd
	 */
	public void setCostAssBseCd(String costAssBseCd) {
		this.costAssBseCd = costAssBseCd;
	}
	
	/**
	 * Column Info
	 * @param spclCgoAwkFlg
	 */
	public void setSpclCgoAwkFlg(String spclCgoAwkFlg) {
		this.spclCgoAwkFlg = spclCgoAwkFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgMcgoFlg
	 */
	public void setBkgMcgoFlg(String bkgMcgoFlg) {
		this.bkgMcgoFlg = bkgMcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param masCostSrcCd
	 */
	public void setMasCostSrcCd(String masCostSrcCd) {
		this.masCostSrcCd = masCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @param sgrpCostCd
	 */
	public void setSgrpCostCd(String sgrpCostCd) {
		this.sgrpCostCd = sgrpCostCd;
	}
	
	/**
	 * Column Info
	 * @param masCostSrcPrtCd
	 */
	public void setMasCostSrcPrtCd(String masCostSrcPrtCd) {
		this.masCostSrcPrtCd = masCostSrcPrtCd;
	}
	
	/**
	 * Column Info
	 * @param costVolCd
	 */
	public void setCostVolCd(String costVolCd) {
		this.costVolCd = costVolCd;
	}
	
	/**
	 * Column Info
	 * @param stndCostNm
	 */
	public void setStndCostNm(String stndCostNm) {
		this.stndCostNm = stndCostNm;
	}
	
	/**
	 * Column Info
	 * @param costUtAmtCd
	 */
	public void setCostUtAmtCd(String costUtAmtCd) {
		this.costUtAmtCd = costUtAmtCd;
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
	 * @param costSrcSysCd
	 */
	public void setCostSrcSysCd(String costSrcSysCd) {
		this.costSrcSysCd = costSrcSysCd;
	}
	
	/**
	 * Column Info
	 * @param costSrcMon
	 */
	public void setCostSrcMon(String costSrcMon) {
		this.costSrcMon = costSrcMon;
	}
	
	/**
	 * Column Info
	 * @param costVolCd1
	 */
	public void setCostVolCd1(String costVolCd1) {
		this.costVolCd1 = costVolCd1;
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
	 * @param spclCgoDgFlg
	 */
	public void setSpclCgoDgFlg(String spclCgoDgFlg) {
		this.spclCgoDgFlg = spclCgoDgFlg;
	}
	
	/**
	 * Column Info
	 * @param spclCgoRfFlg
	 */
	public void setSpclCgoRfFlg(String spclCgoRfFlg) {
		this.spclCgoRfFlg = spclCgoRfFlg;
	}
	
	/**
	 * Column Info
	 * @param spclCgoBbFlg
	 */
	public void setSpclCgoBbFlg(String spclCgoBbFlg) {
		this.spclCgoBbFlg = spclCgoBbFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgRevMcgoFlg
	 */
	public void setBkgRevMcgoFlg(String bkgRevMcgoFlg) {
		this.bkgRevMcgoFlg = bkgRevMcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param sgrpCostCdDesc
	 */
	public void setSgrpCostCdDesc(String sgrpCostCdDesc) {
		this.sgrpCostCdDesc = sgrpCostCdDesc;
	}
	
	/**
	 * Column Info
	 * @param stndCostCd
	 */
	public void setStndCostCd(String stndCostCd) {
		this.stndCostCd = stndCostCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMasCostSrcCdNm(JSPUtil.getParameter(request, "mas_cost_src_cd_nm", ""));
		setBkgFullSocCgoFlg(JSPUtil.getParameter(request, "bkg_full_soc_cgo_flg", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setCostAssBseCd(JSPUtil.getParameter(request, "cost_ass_bse_cd", ""));
		setSpclCgoAwkFlg(JSPUtil.getParameter(request, "spcl_cgo_awk_flg", ""));
		setBkgMcgoFlg(JSPUtil.getParameter(request, "bkg_mcgo_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setMasCostSrcCd(JSPUtil.getParameter(request, "mas_cost_src_cd", ""));
		setSgrpCostCd(JSPUtil.getParameter(request, "sgrp_cost_cd", ""));
		setMasCostSrcPrtCd(JSPUtil.getParameter(request, "mas_cost_src_prt_cd", ""));
		setCostVolCd(JSPUtil.getParameter(request, "cost_vol_cd", ""));
		setStndCostNm(JSPUtil.getParameter(request, "stnd_cost_nm", ""));
		setCostUtAmtCd(JSPUtil.getParameter(request, "cost_ut_amt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCostSrcSysCd(JSPUtil.getParameter(request, "cost_src_sys_cd", ""));
		setCostSrcMon(JSPUtil.getParameter(request, "cost_src_mon", ""));
		setCostVolCd1(JSPUtil.getParameter(request, "cost_vol_cd1", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSpclCgoDgFlg(JSPUtil.getParameter(request, "spcl_cgo_dg_flg", ""));
		setSpclCgoRfFlg(JSPUtil.getParameter(request, "spcl_cgo_rf_flg", ""));
		setSpclCgoBbFlg(JSPUtil.getParameter(request, "spcl_cgo_bb_flg", ""));
		setBkgRevMcgoFlg(JSPUtil.getParameter(request, "bkg_rev_mcgo_flg", ""));
		setSgrpCostCdDesc(JSPUtil.getParameter(request, "sgrp_cost_cd_desc", ""));
		setStndCostCd(JSPUtil.getParameter(request, "stnd_cost_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSoCodeVO[]
	 */
	public SearchSoCodeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSoCodeVO[]
	 */
	public SearchSoCodeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSoCodeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] masCostSrcCdNm = (JSPUtil.getParameter(request, prefix	+ "mas_cost_src_cd_nm", length));
			String[] bkgFullSocCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_full_soc_cgo_flg", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] costAssBseCd = (JSPUtil.getParameter(request, prefix	+ "cost_ass_bse_cd", length));
			String[] spclCgoAwkFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_awk_flg", length));
			String[] bkgMcgoFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_mcgo_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] masCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "mas_cost_src_cd", length));
			String[] sgrpCostCd = (JSPUtil.getParameter(request, prefix	+ "sgrp_cost_cd", length));
			String[] masCostSrcPrtCd = (JSPUtil.getParameter(request, prefix	+ "mas_cost_src_prt_cd", length));
			String[] costVolCd = (JSPUtil.getParameter(request, prefix	+ "cost_vol_cd", length));
			String[] stndCostNm = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_nm", length));
			String[] costUtAmtCd = (JSPUtil.getParameter(request, prefix	+ "cost_ut_amt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] costSrcSysCd = (JSPUtil.getParameter(request, prefix	+ "cost_src_sys_cd", length));
			String[] costSrcMon = (JSPUtil.getParameter(request, prefix	+ "cost_src_mon", length));
			String[] costVolCd1 = (JSPUtil.getParameter(request, prefix	+ "cost_vol_cd1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] spclCgoDgFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_dg_flg", length));
			String[] spclCgoRfFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_rf_flg", length));
			String[] spclCgoBbFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_bb_flg", length));
			String[] bkgRevMcgoFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_rev_mcgo_flg", length));
			String[] sgrpCostCdDesc = (JSPUtil.getParameter(request, prefix	+ "sgrp_cost_cd_desc", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSoCodeVO();
				if (masCostSrcCdNm[i] != null)
					model.setMasCostSrcCdNm(masCostSrcCdNm[i]);
				if (bkgFullSocCgoFlg[i] != null)
					model.setBkgFullSocCgoFlg(bkgFullSocCgoFlg[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (costAssBseCd[i] != null)
					model.setCostAssBseCd(costAssBseCd[i]);
				if (spclCgoAwkFlg[i] != null)
					model.setSpclCgoAwkFlg(spclCgoAwkFlg[i]);
				if (bkgMcgoFlg[i] != null)
					model.setBkgMcgoFlg(bkgMcgoFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (masCostSrcCd[i] != null)
					model.setMasCostSrcCd(masCostSrcCd[i]);
				if (sgrpCostCd[i] != null)
					model.setSgrpCostCd(sgrpCostCd[i]);
				if (masCostSrcPrtCd[i] != null)
					model.setMasCostSrcPrtCd(masCostSrcPrtCd[i]);
				if (costVolCd[i] != null)
					model.setCostVolCd(costVolCd[i]);
				if (stndCostNm[i] != null)
					model.setStndCostNm(stndCostNm[i]);
				if (costUtAmtCd[i] != null)
					model.setCostUtAmtCd(costUtAmtCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (costSrcSysCd[i] != null)
					model.setCostSrcSysCd(costSrcSysCd[i]);
				if (costSrcMon[i] != null)
					model.setCostSrcMon(costSrcMon[i]);
				if (costVolCd1[i] != null)
					model.setCostVolCd1(costVolCd1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (spclCgoDgFlg[i] != null)
					model.setSpclCgoDgFlg(spclCgoDgFlg[i]);
				if (spclCgoRfFlg[i] != null)
					model.setSpclCgoRfFlg(spclCgoRfFlg[i]);
				if (spclCgoBbFlg[i] != null)
					model.setSpclCgoBbFlg(spclCgoBbFlg[i]);
				if (bkgRevMcgoFlg[i] != null)
					model.setBkgRevMcgoFlg(bkgRevMcgoFlg[i]);
				if (sgrpCostCdDesc[i] != null)
					model.setSgrpCostCdDesc(sgrpCostCdDesc[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSoCodeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSoCodeVO[]
	 */
	public SearchSoCodeVO[] getSearchSoCodeVOs(){
		SearchSoCodeVO[] vos = (SearchSoCodeVO[])models.toArray(new SearchSoCodeVO[models.size()]);
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
		this.masCostSrcCdNm = this.masCostSrcCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFullSocCgoFlg = this.bkgFullSocCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAssBseCd = this.costAssBseCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAwkFlg = this.spclCgoAwkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMcgoFlg = this.bkgMcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masCostSrcCd = this.masCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgrpCostCd = this.sgrpCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masCostSrcPrtCd = this.masCostSrcPrtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costVolCd = this.costVolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostNm = this.stndCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costUtAmtCd = this.costUtAmtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costSrcSysCd = this.costSrcSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costSrcMon = this.costSrcMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costVolCd1 = this.costVolCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoDgFlg = this.spclCgoDgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoRfFlg = this.spclCgoRfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoBbFlg = this.spclCgoBbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRevMcgoFlg = this.bkgRevMcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgrpCostCdDesc = this.sgrpCostCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
