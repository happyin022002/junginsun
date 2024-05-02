/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchQtaLoadRevForSectorListVO.java
*@FileTitle : SearchQtaLoadRevForSectorListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.28
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.01.28 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.sqm.planning.planning.vo;

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

public class SearchQtaLoadRevForSectorListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchQtaLoadRevForSectorListVO> models = new ArrayList<SearchQtaLoadRevForSectorListVO>();
	
	/* Column Info */
	private String rlaneCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String sqmMnSctrFlg = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String ofcVwNm = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String gidLodQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fnlBsaCapa = null;
	/* Column Info */
	private String lodQty = null;
	/* Column Info */
	private String grsRpbRev = null;
	/* Column Info */
	private String gidGrsRpbRev = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String useFlg = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String ofcVwCd = null;
	/* Column Info */
	private String iasRgnCd = null;
	/* Column Info */
	private String pfGrpCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String preGrsRpbRev = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String preLodQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchQtaLoadRevForSectorListVO() {}

	public SearchQtaLoadRevForSectorListVO(String ibflag, String pagerows, String bseYr, String bseQtrCd, String ofcVwNm, String ofcVwCd, String trdCd, String subTrdCd, String iasRgnCd, String rlaneCd, String dirCd, String hulBndCd, String pfGrpCd, String fnlBsaCapa, String rhqCd, String rgnOfcCd, String polCd, String podCd, String sqmMnSctrFlg, String preLodQty, String preGrsRpbRev, String lodQty, String grsRpbRev, String gidLodQty, String gidGrsRpbRev, String useFlg) {
		this.rlaneCd = rlaneCd;
		this.ibflag = ibflag;
		this.rhqCd = rhqCd;
		this.sqmMnSctrFlg = sqmMnSctrFlg;
		this.hulBndCd = hulBndCd;
		this.polCd = polCd;
		this.ofcVwNm = ofcVwNm;
		this.podCd = podCd;
		this.gidLodQty = gidLodQty;
		this.pagerows = pagerows;
		this.fnlBsaCapa = fnlBsaCapa;
		this.lodQty = lodQty;
		this.grsRpbRev = grsRpbRev;
		this.gidGrsRpbRev = gidGrsRpbRev;
		this.trdCd = trdCd;
		this.useFlg = useFlg;
		this.rgnOfcCd = rgnOfcCd;
		this.ofcVwCd = ofcVwCd;
		this.iasRgnCd = iasRgnCd;
		this.pfGrpCd = pfGrpCd;
		this.bseYr = bseYr;
		this.subTrdCd = subTrdCd;
		this.preGrsRpbRev = preGrsRpbRev;
		this.bseQtrCd = bseQtrCd;
		this.dirCd = dirCd;
		this.preLodQty = preLodQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("sqm_mn_sctr_flg", getSqmMnSctrFlg());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ofc_vw_nm", getOfcVwNm());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("gid_lod_qty", getGidLodQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fnl_bsa_capa", getFnlBsaCapa());
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("grs_rpb_rev", getGrsRpbRev());
		this.hashColumns.put("gid_grs_rpb_rev", getGidGrsRpbRev());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("use_flg", getUseFlg());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("ofc_vw_cd", getOfcVwCd());
		this.hashColumns.put("ias_rgn_cd", getIasRgnCd());
		this.hashColumns.put("pf_grp_cd", getPfGrpCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("pre_grs_rpb_rev", getPreGrsRpbRev());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("pre_lod_qty", getPreLodQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("sqm_mn_sctr_flg", "sqmMnSctrFlg");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ofc_vw_nm", "ofcVwNm");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("gid_lod_qty", "gidLodQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fnl_bsa_capa", "fnlBsaCapa");
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("grs_rpb_rev", "grsRpbRev");
		this.hashFields.put("gid_grs_rpb_rev", "gidGrsRpbRev");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("use_flg", "useFlg");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("ofc_vw_cd", "ofcVwCd");
		this.hashFields.put("ias_rgn_cd", "iasRgnCd");
		this.hashFields.put("pf_grp_cd", "pfGrpCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("pre_grs_rpb_rev", "preGrsRpbRev");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("pre_lod_qty", "preLodQty");
		return this.hashFields;
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
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return sqmMnSctrFlg
	 */
	public String getSqmMnSctrFlg() {
		return this.sqmMnSctrFlg;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return ofcVwNm
	 */
	public String getOfcVwNm() {
		return this.ofcVwNm;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return gidLodQty
	 */
	public String getGidLodQty() {
		return this.gidLodQty;
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
	 * @return lodQty
	 */
	public String getLodQty() {
		return this.lodQty;
	}
	
	/**
	 * Column Info
	 * @return grsRpbRev
	 */
	public String getGrsRpbRev() {
		return this.grsRpbRev;
	}
	
	/**
	 * Column Info
	 * @return gidGrsRpbRev
	 */
	public String getGidGrsRpbRev() {
		return this.gidGrsRpbRev;
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
	 * @return useFlg
	 */
	public String getUseFlg() {
		return this.useFlg;
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
	 * @return ofcVwCd
	 */
	public String getOfcVwCd() {
		return this.ofcVwCd;
	}
	
	/**
	 * Column Info
	 * @return iasRgnCd
	 */
	public String getIasRgnCd() {
		return this.iasRgnCd;
	}
	
	/**
	 * Column Info
	 * @return pfGrpCd
	 */
	public String getPfGrpCd() {
		return this.pfGrpCd;
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
	 * @return preGrsRpbRev
	 */
	public String getPreGrsRpbRev() {
		return this.preGrsRpbRev;
	}
	
	/**
	 * Column Info
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
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
	 * @return preLodQty
	 */
	public String getPreLodQty() {
		return this.preLodQty;
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
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param sqmMnSctrFlg
	 */
	public void setSqmMnSctrFlg(String sqmMnSctrFlg) {
		this.sqmMnSctrFlg = sqmMnSctrFlg;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param ofcVwNm
	 */
	public void setOfcVwNm(String ofcVwNm) {
		this.ofcVwNm = ofcVwNm;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param gidLodQty
	 */
	public void setGidLodQty(String gidLodQty) {
		this.gidLodQty = gidLodQty;
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
	 * @param lodQty
	 */
	public void setLodQty(String lodQty) {
		this.lodQty = lodQty;
	}
	
	/**
	 * Column Info
	 * @param grsRpbRev
	 */
	public void setGrsRpbRev(String grsRpbRev) {
		this.grsRpbRev = grsRpbRev;
	}
	
	/**
	 * Column Info
	 * @param gidGrsRpbRev
	 */
	public void setGidGrsRpbRev(String gidGrsRpbRev) {
		this.gidGrsRpbRev = gidGrsRpbRev;
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
	 * @param useFlg
	 */
	public void setUseFlg(String useFlg) {
		this.useFlg = useFlg;
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
	 * @param ofcVwCd
	 */
	public void setOfcVwCd(String ofcVwCd) {
		this.ofcVwCd = ofcVwCd;
	}
	
	/**
	 * Column Info
	 * @param iasRgnCd
	 */
	public void setIasRgnCd(String iasRgnCd) {
		this.iasRgnCd = iasRgnCd;
	}
	
	/**
	 * Column Info
	 * @param pfGrpCd
	 */
	public void setPfGrpCd(String pfGrpCd) {
		this.pfGrpCd = pfGrpCd;
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
	 * @param preGrsRpbRev
	 */
	public void setPreGrsRpbRev(String preGrsRpbRev) {
		this.preGrsRpbRev = preGrsRpbRev;
	}
	
	/**
	 * Column Info
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
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
	 * @param preLodQty
	 */
	public void setPreLodQty(String preLodQty) {
		this.preLodQty = preLodQty;
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
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setSqmMnSctrFlg(JSPUtil.getParameter(request, prefix + "sqm_mn_sctr_flg", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setOfcVwNm(JSPUtil.getParameter(request, prefix + "ofc_vw_nm", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setGidLodQty(JSPUtil.getParameter(request, prefix + "gid_lod_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFnlBsaCapa(JSPUtil.getParameter(request, prefix + "fnl_bsa_capa", ""));
		setLodQty(JSPUtil.getParameter(request, prefix + "lod_qty", ""));
		setGrsRpbRev(JSPUtil.getParameter(request, prefix + "grs_rpb_rev", ""));
		setGidGrsRpbRev(JSPUtil.getParameter(request, prefix + "gid_grs_rpb_rev", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setUseFlg(JSPUtil.getParameter(request, prefix + "use_flg", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setOfcVwCd(JSPUtil.getParameter(request, prefix + "ofc_vw_cd", ""));
		setIasRgnCd(JSPUtil.getParameter(request, prefix + "ias_rgn_cd", ""));
		setPfGrpCd(JSPUtil.getParameter(request, prefix + "pf_grp_cd", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setPreGrsRpbRev(JSPUtil.getParameter(request, prefix + "pre_grs_rpb_rev", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setPreLodQty(JSPUtil.getParameter(request, prefix + "pre_lod_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchQtaLoadRevForSectorListVO[]
	 */
	public SearchQtaLoadRevForSectorListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchQtaLoadRevForSectorListVO[]
	 */
	public SearchQtaLoadRevForSectorListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchQtaLoadRevForSectorListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] sqmMnSctrFlg = (JSPUtil.getParameter(request, prefix	+ "sqm_mn_sctr_flg", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ofcVwNm = (JSPUtil.getParameter(request, prefix	+ "ofc_vw_nm", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] gidLodQty = (JSPUtil.getParameter(request, prefix	+ "gid_lod_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_bsa_capa", length));
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] grsRpbRev = (JSPUtil.getParameter(request, prefix	+ "grs_rpb_rev", length));
			String[] gidGrsRpbRev = (JSPUtil.getParameter(request, prefix	+ "gid_grs_rpb_rev", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] useFlg = (JSPUtil.getParameter(request, prefix	+ "use_flg", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] ofcVwCd = (JSPUtil.getParameter(request, prefix	+ "ofc_vw_cd", length));
			String[] iasRgnCd = (JSPUtil.getParameter(request, prefix	+ "ias_rgn_cd", length));
			String[] pfGrpCd = (JSPUtil.getParameter(request, prefix	+ "pf_grp_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] preGrsRpbRev = (JSPUtil.getParameter(request, prefix	+ "pre_grs_rpb_rev", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] preLodQty = (JSPUtil.getParameter(request, prefix	+ "pre_lod_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchQtaLoadRevForSectorListVO();
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (sqmMnSctrFlg[i] != null)
					model.setSqmMnSctrFlg(sqmMnSctrFlg[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ofcVwNm[i] != null)
					model.setOfcVwNm(ofcVwNm[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (gidLodQty[i] != null)
					model.setGidLodQty(gidLodQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fnlBsaCapa[i] != null)
					model.setFnlBsaCapa(fnlBsaCapa[i]);
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (grsRpbRev[i] != null)
					model.setGrsRpbRev(grsRpbRev[i]);
				if (gidGrsRpbRev[i] != null)
					model.setGidGrsRpbRev(gidGrsRpbRev[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (useFlg[i] != null)
					model.setUseFlg(useFlg[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (ofcVwCd[i] != null)
					model.setOfcVwCd(ofcVwCd[i]);
				if (iasRgnCd[i] != null)
					model.setIasRgnCd(iasRgnCd[i]);
				if (pfGrpCd[i] != null)
					model.setPfGrpCd(pfGrpCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (preGrsRpbRev[i] != null)
					model.setPreGrsRpbRev(preGrsRpbRev[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (preLodQty[i] != null)
					model.setPreLodQty(preLodQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchQtaLoadRevForSectorListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchQtaLoadRevForSectorListVO[]
	 */
	public SearchQtaLoadRevForSectorListVO[] getSearchQtaLoadRevForSectorListVOs(){
		SearchQtaLoadRevForSectorListVO[] vos = (SearchQtaLoadRevForSectorListVO[])models.toArray(new SearchQtaLoadRevForSectorListVO[models.size()]);
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
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sqmMnSctrFlg = this.sqmMnSctrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcVwNm = this.ofcVwNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gidLodQty = this.gidLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBsaCapa = this.fnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRpbRev = this.grsRpbRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gidGrsRpbRev = this.gidGrsRpbRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.useFlg = this.useFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcVwCd = this.ofcVwCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iasRgnCd = this.iasRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfGrpCd = this.pfGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preGrsRpbRev = this.preGrsRpbRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preLodQty = this.preLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
