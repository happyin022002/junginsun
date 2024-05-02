/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchCurrentKpiReportVO.java
*@FileTitle : SearchCurrentKpiReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.05  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo;

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

public class SearchCurrentKpiReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCurrentKpiReportVO> models = new ArrayList<SearchCurrentKpiReportVO>();
	
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String paCmCost = null;
	/* Column Info */
	private String fnlBsaCapa = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String paCm = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String bseMon = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String convDirCd = null;
	/* Column Info */
	private String bseTpCd = null;
	/* Column Info */
	private String grev = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String lodQty = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String raCmpb = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String paCmcb = null;
	/* Column Info */
	private String paCmpb = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String bseWk = null;
	/* Column Info */
	private String raCmcb = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String grpbDecimal = null;
	/* Column Info */
	private String raCmCost = null;
	/* Column Info */
	private String grpb = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String raCm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchCurrentKpiReportVO() {}

	public SearchCurrentKpiReportVO(String ibflag, String pagerows, String trdCd, String rlaneCd, String paCmCost, String fnlBsaCapa, String hulBndCd, String bseMon, String bseQtrCd, String paCm, String convDirCd, String bseTpCd, String grev, String dirCd, String rgnOfcCd, String lodQty, String raCmpb, String rhqCd, String paCmcb, String paCmpb, String bseYr, String bseWk, String raCmcb, String vvd, String grpbDecimal, String raCmCost, String grpb, String subTrdCd, String raCm) {
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.paCmCost = paCmCost;
		this.fnlBsaCapa = fnlBsaCapa;
		this.pagerows = pagerows;
		this.paCm = paCm;
		this.bseQtrCd = bseQtrCd;
		this.bseMon = bseMon;
		this.ibflag = ibflag;
		this.convDirCd = convDirCd;
		this.bseTpCd = bseTpCd;
		this.grev = grev;
		this.dirCd = dirCd;
		this.rgnOfcCd = rgnOfcCd;
		this.lodQty = lodQty;
		this.hulBndCd = hulBndCd;
		this.raCmpb = raCmpb;
		this.rhqCd = rhqCd;
		this.paCmcb = paCmcb;
		this.paCmpb = paCmpb;
		this.bseYr = bseYr;
		this.bseWk = bseWk;
		this.raCmcb = raCmcb;
		this.vvd = vvd;
		this.grpbDecimal = grpbDecimal;
		this.raCmCost = raCmCost;
		this.grpb = grpb;
		this.subTrdCd = subTrdCd;
		this.raCm = raCm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pa_cm_cost", getPaCmCost());
		this.hashColumns.put("fnl_bsa_capa", getFnlBsaCapa());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pa_cm", getPaCm());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("conv_dir_cd", getConvDirCd());
		this.hashColumns.put("bse_tp_cd", getBseTpCd());
		this.hashColumns.put("grev", getGrev());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("ra_cmpb", getRaCmpb());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("pa_cmcb", getPaCmcb());
		this.hashColumns.put("pa_cmpb", getPaCmpb());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("ra_cmcb", getRaCmcb());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("grpb_decimal", getGrpbDecimal());
		this.hashColumns.put("ra_cm_cost", getRaCmCost());
		this.hashColumns.put("grpb", getGrpb());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("ra_cm", getRaCm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pa_cm_cost", "paCmCost");
		this.hashFields.put("fnl_bsa_capa", "fnlBsaCapa");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pa_cm", "paCm");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("conv_dir_cd", "convDirCd");
		this.hashFields.put("bse_tp_cd", "bseTpCd");
		this.hashFields.put("grev", "grev");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("ra_cmpb", "raCmpb");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("pa_cmcb", "paCmcb");
		this.hashFields.put("pa_cmpb", "paCmpb");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("ra_cmcb", "raCmcb");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("grpb_decimal", "grpbDecimal");
		this.hashFields.put("ra_cm_cost", "raCmCost");
		this.hashFields.put("grpb", "grpb");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("ra_cm", "raCm");
		return this.hashFields;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return paCmCost
	 */
	public String getPaCmCost() {
		return this.paCmCost;
	}
	
	/**
	 * Column Info
	 * @return fnlBsaCapa
	 */
	public String getFnlBsaCapa() {
		return this.fnlBsaCapa;
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
	 * @return paCm
	 */
	public String getPaCm() {
		return this.paCm;
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
	 * @return bseMon
	 */
	public String getBseMon() {
		return this.bseMon;
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
	 * @return convDirCd
	 */
	public String getConvDirCd() {
		return this.convDirCd;
	}
	
	/**
	 * Column Info
	 * @return bseTpCd
	 */
	public String getBseTpCd() {
		return this.bseTpCd;
	}
	
	/**
	 * Column Info
	 * @return grev
	 */
	public String getGrev() {
		return this.grev;
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
	 * @return rgnOfcCd
	 */
	public String getRgnOfcCd() {
		return this.rgnOfcCd;
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
	 * @return hulBndCd
	 */
	public String getHulBndCd() {
		return this.hulBndCd;
	}
	
	/**
	 * Column Info
	 * @return raCmpb
	 */
	public String getRaCmpb() {
		return this.raCmpb;
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
	 * @return paCmcb
	 */
	public String getPaCmcb() {
		return this.paCmcb;
	}
	
	/**
	 * Column Info
	 * @return paCmpb
	 */
	public String getPaCmpb() {
		return this.paCmpb;
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
	 * @return bseWk
	 */
	public String getBseWk() {
		return this.bseWk;
	}
	
	/**
	 * Column Info
	 * @return raCmcb
	 */
	public String getRaCmcb() {
		return this.raCmcb;
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
	 * @return grpbDecimal
	 */
	public String getGrpbDecimal() {
		return this.grpbDecimal;
	}
	
	/**
	 * Column Info
	 * @return raCmCost
	 */
	public String getRaCmCost() {
		return this.raCmCost;
	}
	
	/**
	 * Column Info
	 * @return grpb
	 */
	public String getGrpb() {
		return this.grpb;
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
	 * @return raCm
	 */
	public String getRaCm() {
		return this.raCm;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param paCmCost
	 */
	public void setPaCmCost(String paCmCost) {
		this.paCmCost = paCmCost;
	}
	
	/**
	 * Column Info
	 * @param fnlBsaCapa
	 */
	public void setFnlBsaCapa(String fnlBsaCapa) {
		this.fnlBsaCapa = fnlBsaCapa;
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
	 * @param paCm
	 */
	public void setPaCm(String paCm) {
		this.paCm = paCm;
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
	 * @param bseMon
	 */
	public void setBseMon(String bseMon) {
		this.bseMon = bseMon;
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
	 * @param convDirCd
	 */
	public void setConvDirCd(String convDirCd) {
		this.convDirCd = convDirCd;
	}
	
	/**
	 * Column Info
	 * @param bseTpCd
	 */
	public void setBseTpCd(String bseTpCd) {
		this.bseTpCd = bseTpCd;
	}
	
	/**
	 * Column Info
	 * @param grev
	 */
	public void setGrev(String grev) {
		this.grev = grev;
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
	 * @param rgnOfcCd
	 */
	public void setRgnOfcCd(String rgnOfcCd) {
		this.rgnOfcCd = rgnOfcCd;
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
	 * @param hulBndCd
	 */
	public void setHulBndCd(String hulBndCd) {
		this.hulBndCd = hulBndCd;
	}
	
	/**
	 * Column Info
	 * @param raCmpb
	 */
	public void setRaCmpb(String raCmpb) {
		this.raCmpb = raCmpb;
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
	 * @param paCmcb
	 */
	public void setPaCmcb(String paCmcb) {
		this.paCmcb = paCmcb;
	}
	
	/**
	 * Column Info
	 * @param paCmpb
	 */
	public void setPaCmpb(String paCmpb) {
		this.paCmpb = paCmpb;
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
	 * @param bseWk
	 */
	public void setBseWk(String bseWk) {
		this.bseWk = bseWk;
	}
	
	/**
	 * Column Info
	 * @param raCmcb
	 */
	public void setRaCmcb(String raCmcb) {
		this.raCmcb = raCmcb;
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
	 * @param grpbDecimal
	 */
	public void setGrpbDecimal(String grpbDecimal) {
		this.grpbDecimal = grpbDecimal;
	}
	
	/**
	 * Column Info
	 * @param raCmCost
	 */
	public void setRaCmCost(String raCmCost) {
		this.raCmCost = raCmCost;
	}
	
	/**
	 * Column Info
	 * @param grpb
	 */
	public void setGrpb(String grpb) {
		this.grpb = grpb;
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
	 * @param raCm
	 */
	public void setRaCm(String raCm) {
		this.raCm = raCm;
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
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPaCmCost(JSPUtil.getParameter(request, prefix + "pa_cm_cost", ""));
		setFnlBsaCapa(JSPUtil.getParameter(request, prefix + "fnl_bsa_capa", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPaCm(JSPUtil.getParameter(request, prefix + "pa_cm", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setBseMon(JSPUtil.getParameter(request, prefix + "bse_mon", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setConvDirCd(JSPUtil.getParameter(request, prefix + "conv_dir_cd", ""));
		setBseTpCd(JSPUtil.getParameter(request, prefix + "bse_tp_cd", ""));
		setGrev(JSPUtil.getParameter(request, prefix + "grev", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setLodQty(JSPUtil.getParameter(request, prefix + "lod_qty", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setRaCmpb(JSPUtil.getParameter(request, prefix + "ra_cmpb", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setPaCmcb(JSPUtil.getParameter(request, prefix + "pa_cmcb", ""));
		setPaCmpb(JSPUtil.getParameter(request, prefix + "pa_cmpb", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setBseWk(JSPUtil.getParameter(request, prefix + "bse_wk", ""));
		setRaCmcb(JSPUtil.getParameter(request, prefix + "ra_cmcb", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setGrpbDecimal(JSPUtil.getParameter(request, prefix + "grpb_decimal", ""));
		setRaCmCost(JSPUtil.getParameter(request, prefix + "ra_cm_cost", ""));
		setGrpb(JSPUtil.getParameter(request, prefix + "grpb", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setRaCm(JSPUtil.getParameter(request, prefix + "ra_cm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCurrentKpiReportVO[]
	 */
	public SearchCurrentKpiReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCurrentKpiReportVO[]
	 */
	public SearchCurrentKpiReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCurrentKpiReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] paCmCost = (JSPUtil.getParameter(request, prefix	+ "pa_cm_cost", length));
			String[] fnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_bsa_capa", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] paCm = (JSPUtil.getParameter(request, prefix	+ "pa_cm", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] convDirCd = (JSPUtil.getParameter(request, prefix	+ "conv_dir_cd", length));
			String[] bseTpCd = (JSPUtil.getParameter(request, prefix	+ "bse_tp_cd", length));
			String[] grev = (JSPUtil.getParameter(request, prefix	+ "grev", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] raCmpb = (JSPUtil.getParameter(request, prefix	+ "ra_cmpb", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] paCmcb = (JSPUtil.getParameter(request, prefix	+ "pa_cmcb", length));
			String[] paCmpb = (JSPUtil.getParameter(request, prefix	+ "pa_cmpb", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] raCmcb = (JSPUtil.getParameter(request, prefix	+ "ra_cmcb", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] grpbDecimal = (JSPUtil.getParameter(request, prefix	+ "grpb_decimal", length));
			String[] raCmCost = (JSPUtil.getParameter(request, prefix	+ "ra_cm_cost", length));
			String[] grpb = (JSPUtil.getParameter(request, prefix	+ "grpb", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] raCm = (JSPUtil.getParameter(request, prefix	+ "ra_cm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCurrentKpiReportVO();
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (paCmCost[i] != null)
					model.setPaCmCost(paCmCost[i]);
				if (fnlBsaCapa[i] != null)
					model.setFnlBsaCapa(fnlBsaCapa[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (paCm[i] != null)
					model.setPaCm(paCm[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (convDirCd[i] != null)
					model.setConvDirCd(convDirCd[i]);
				if (bseTpCd[i] != null)
					model.setBseTpCd(bseTpCd[i]);
				if (grev[i] != null)
					model.setGrev(grev[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (raCmpb[i] != null)
					model.setRaCmpb(raCmpb[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (paCmcb[i] != null)
					model.setPaCmcb(paCmcb[i]);
				if (paCmpb[i] != null)
					model.setPaCmpb(paCmpb[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (bseWk[i] != null)
					model.setBseWk(bseWk[i]);
				if (raCmcb[i] != null)
					model.setRaCmcb(raCmcb[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (grpbDecimal[i] != null)
					model.setGrpbDecimal(grpbDecimal[i]);
				if (raCmCost[i] != null)
					model.setRaCmCost(raCmCost[i]);
				if (grpb[i] != null)
					model.setGrpb(grpb[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (raCm[i] != null)
					model.setRaCm(raCm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCurrentKpiReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCurrentKpiReportVO[]
	 */
	public SearchCurrentKpiReportVO[] getSearchCurrentKpiReportVOs(){
		SearchCurrentKpiReportVO[] vos = (SearchCurrentKpiReportVO[])models.toArray(new SearchCurrentKpiReportVO[models.size()]);
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
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCmCost = this.paCmCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBsaCapa = this.fnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCm = this.paCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDirCd = this.convDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseTpCd = this.bseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grev = this.grev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmpb = this.raCmpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCmcb = this.paCmcb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCmpb = this.paCmpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmcb = this.raCmcb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpbDecimal = this.grpbDecimal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmCost = this.raCmCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpb = this.grpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCm = this.raCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
