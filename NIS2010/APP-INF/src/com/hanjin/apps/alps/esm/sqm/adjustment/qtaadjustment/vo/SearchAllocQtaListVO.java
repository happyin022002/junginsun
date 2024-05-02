/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchAllocQtaListVO.java
*@FileTitle : SearchAllocQtaListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.13
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.07.13 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAllocQtaListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAllocQtaListVO> models = new ArrayList<SearchAllocQtaListVO>();
	
	/* Column Info */
	private String aplyFlg = null;
	/* Column Info */
	private String rlaneCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bseMon = null;
	/* Column Info */
	private String aplyCnt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String cfmLodQty = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String pairCheck = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fnlBsaCapa = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String lodQty = null;
	/* Column Info */
	private String sqmActFlg = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String dMinusOneDate = null;
	/* Column Info */
	private String bseWk = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String orgLodQty = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String quarter = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchAllocQtaListVO() {}

	public SearchAllocQtaListVO(String ibflag, String pagerows, String bseYr, String bseMon, String bseWk, String trdCd, String rlaneCd, String dirCd, String hulBndCd, String vslCd, String skdVoyNo, String skdDirCd, String vvd, String rgnOfcCd, String rhqCd, String aplyCnt, String cfmLodQty, String orgLodQty, String lodQty, String fnlBsaCapa, String subTrdCd, String aplyFlg, String dMinusOneDate, String sqmActFlg, String quarter, String pairCheck) {
		this.aplyFlg = aplyFlg;
		this.rlaneCd = rlaneCd;
		this.ibflag = ibflag;
		this.bseMon = bseMon;
		this.aplyCnt = aplyCnt;
		this.rhqCd = rhqCd;
		this.hulBndCd = hulBndCd;
		this.cfmLodQty = cfmLodQty;
		this.skdDirCd = skdDirCd;
		this.pairCheck = pairCheck;
		this.pagerows = pagerows;
		this.fnlBsaCapa = fnlBsaCapa;
		this.skdVoyNo = skdVoyNo;
		this.lodQty = lodQty;
		this.sqmActFlg = sqmActFlg;
		this.vslCd = vslCd;
		this.vvd = vvd;
		this.trdCd = trdCd;
		this.dMinusOneDate = dMinusOneDate;
		this.bseWk = bseWk;
		this.rgnOfcCd = rgnOfcCd;
		this.orgLodQty = orgLodQty;
		this.bseYr = bseYr;
		this.subTrdCd = subTrdCd;
		this.dirCd = dirCd;
		this.quarter = quarter;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("aply_flg", getAplyFlg());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("aply_cnt", getAplyCnt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("cfm_lod_qty", getCfmLodQty());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pair_check", getPairCheck());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fnl_bsa_capa", getFnlBsaCapa());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("sqm_act_flg", getSqmActFlg());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("d_minus_one_date", getDMinusOneDate());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("org_lod_qty", getOrgLodQty());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("quarter", getQuarter());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("aply_flg", "aplyFlg");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("aply_cnt", "aplyCnt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("cfm_lod_qty", "cfmLodQty");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pair_check", "pairCheck");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fnl_bsa_capa", "fnlBsaCapa");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("sqm_act_flg", "sqmActFlg");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("d_minus_one_date", "dMinusOneDate");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("org_lod_qty", "orgLodQty");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("quarter", "quarter");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aplyFlg
	 */
	public String getAplyFlg() {
		return this.aplyFlg;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return bseMon
	 */
	public String getBseMon() {
		return this.bseMon;
	}
	
	/**
	 * Column Info
	 * @return aplyCnt
	 */
	public String getAplyCnt() {
		return this.aplyCnt;
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
	 * @return hulBndCd
	 */
	public String getHulBndCd() {
		return this.hulBndCd;
	}
	
	/**
	 * Column Info
	 * @return cfmLodQty
	 */
	public String getCfmLodQty() {
		return this.cfmLodQty;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return pairCheck
	 */
	public String getPairCheck() {
		return this.pairCheck;
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
	 * @return fnlBsaCapa
	 */
	public String getFnlBsaCapa() {
		return this.fnlBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return lodQty
	 */
	public String getLodQty() {
		return this.lodQty;
	}
	
	/**
	 * Column Info
	 * @return sqmActFlg
	 */
	public String getSqmActFlg() {
		return this.sqmActFlg;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return dMinusOneDate
	 */
	public String getDMinusOneDate() {
		return this.dMinusOneDate;
	}
	
	/**
	 * Column Info
	 * @return bseWk
	 */
	public String getBseWk() {
		return this.bseWk;
	}
	
	/**
	 * Column Info
	 * @return rgnOfcCd
	 */
	public String getRgnOfcCd() {
		return this.rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return orgLodQty
	 */
	public String getOrgLodQty() {
		return this.orgLodQty;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return quarter
	 */
	public String getQuarter() {
		return this.quarter;
	}
	

	/**
	 * Column Info
	 * @param aplyFlg
	 */
	public void setAplyFlg(String aplyFlg) {
		this.aplyFlg = aplyFlg;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param bseMon
	 */
	public void setBseMon(String bseMon) {
		this.bseMon = bseMon;
	}
	
	/**
	 * Column Info
	 * @param aplyCnt
	 */
	public void setAplyCnt(String aplyCnt) {
		this.aplyCnt = aplyCnt;
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
	 * @param hulBndCd
	 */
	public void setHulBndCd(String hulBndCd) {
		this.hulBndCd = hulBndCd;
	}
	
	/**
	 * Column Info
	 * @param cfmLodQty
	 */
	public void setCfmLodQty(String cfmLodQty) {
		this.cfmLodQty = cfmLodQty;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param pairCheck
	 */
	public void setPairCheck(String pairCheck) {
		this.pairCheck = pairCheck;
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
	 * @param fnlBsaCapa
	 */
	public void setFnlBsaCapa(String fnlBsaCapa) {
		this.fnlBsaCapa = fnlBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param lodQty
	 */
	public void setLodQty(String lodQty) {
		this.lodQty = lodQty;
	}
	
	/**
	 * Column Info
	 * @param sqmActFlg
	 */
	public void setSqmActFlg(String sqmActFlg) {
		this.sqmActFlg = sqmActFlg;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param dMinusOneDate
	 */
	public void setDMinusOneDate(String dMinusOneDate) {
		this.dMinusOneDate = dMinusOneDate;
	}
	
	/**
	 * Column Info
	 * @param bseWk
	 */
	public void setBseWk(String bseWk) {
		this.bseWk = bseWk;
	}
	
	/**
	 * Column Info
	 * @param rgnOfcCd
	 */
	public void setRgnOfcCd(String rgnOfcCd) {
		this.rgnOfcCd = rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param orgLodQty
	 */
	public void setOrgLodQty(String orgLodQty) {
		this.orgLodQty = orgLodQty;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param quarter
	 */
	public void setQuarter(String quarter) {
		this.quarter = quarter;
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
		setAplyFlg(JSPUtil.getParameter(request, prefix + "aply_flg", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBseMon(JSPUtil.getParameter(request, prefix + "bse_mon", ""));
		setAplyCnt(JSPUtil.getParameter(request, prefix + "aply_cnt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setCfmLodQty(JSPUtil.getParameter(request, prefix + "cfm_lod_qty", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPairCheck(JSPUtil.getParameter(request, prefix + "pair_check", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFnlBsaCapa(JSPUtil.getParameter(request, prefix + "fnl_bsa_capa", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setLodQty(JSPUtil.getParameter(request, prefix + "lod_qty", ""));
		setSqmActFlg(JSPUtil.getParameter(request, prefix + "sqm_act_flg", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setDMinusOneDate(JSPUtil.getParameter(request, prefix + "d_minus_one_date", ""));
		setBseWk(JSPUtil.getParameter(request, prefix + "bse_wk", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setOrgLodQty(JSPUtil.getParameter(request, prefix + "org_lod_qty", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setQuarter(JSPUtil.getParameter(request, prefix + "quarter", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAllocQtaListVO[]
	 */
	public SearchAllocQtaListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAllocQtaListVO[]
	 */
	public SearchAllocQtaListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAllocQtaListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aplyFlg = (JSPUtil.getParameter(request, prefix	+ "aply_flg", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] aplyCnt = (JSPUtil.getParameter(request, prefix	+ "aply_cnt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] cfmLodQty = (JSPUtil.getParameter(request, prefix	+ "cfm_lod_qty", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pairCheck = (JSPUtil.getParameter(request, prefix	+ "pair_check", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_bsa_capa", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] sqmActFlg = (JSPUtil.getParameter(request, prefix	+ "sqm_act_flg", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] dMinusOneDate = (JSPUtil.getParameter(request, prefix	+ "d_minus_one_date", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] orgLodQty = (JSPUtil.getParameter(request, prefix	+ "org_lod_qty", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] quarter = (JSPUtil.getParameter(request, prefix	+ "quarter", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAllocQtaListVO();
				if (aplyFlg[i] != null)
					model.setAplyFlg(aplyFlg[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (aplyCnt[i] != null)
					model.setAplyCnt(aplyCnt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (cfmLodQty[i] != null)
					model.setCfmLodQty(cfmLodQty[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pairCheck[i] != null)
					model.setPairCheck(pairCheck[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fnlBsaCapa[i] != null)
					model.setFnlBsaCapa(fnlBsaCapa[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (sqmActFlg[i] != null)
					model.setSqmActFlg(sqmActFlg[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (dMinusOneDate[i] != null)
					model.setDMinusOneDate(dMinusOneDate[i]);
				if (bseWk[i] != null)
					model.setBseWk(bseWk[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (orgLodQty[i] != null)
					model.setOrgLodQty(orgLodQty[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (quarter[i] != null)
					model.setQuarter(quarter[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAllocQtaListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAllocQtaListVO[]
	 */
	public SearchAllocQtaListVO[] getSearchAllocQtaListVOs(){
		SearchAllocQtaListVO[] vos = (SearchAllocQtaListVO[])models.toArray(new SearchAllocQtaListVO[models.size()]);
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
		this.aplyFlg = this.aplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyCnt = this.aplyCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmLodQty = this.cfmLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pairCheck = this.pairCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBsaCapa = this.fnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sqmActFlg = this.sqmActFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dMinusOneDate = this.dMinusOneDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLodQty = this.orgLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.quarter = this.quarter .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
