/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchYearlyCurrnetQtaListVO.java
*@FileTitle : SearchYearlyCurrnetQtaListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.15  
* 1.0 Creation
* 2015.07.21 김용습 [CHM-201537066] 조회된 데이터가 quarterly 수립 데이터인지, yearly 수립 데이터인지 알 수 있도록 QTR CD 컬럼 추가
=========================================================*/

package com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchYearlyCurrnetQtaListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchYearlyCurrnetQtaListVO> models = new ArrayList<SearchYearlyCurrnetQtaListVO>();
	
	/* Column Info */
	private String ofcVwCd = null;
	/* Column Info */
	private String gRev = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String fnlBsaCapa = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseMon = null;
	/* Column Info */
	private String paCm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String lodQty = null;
	/* Column Info */
	private String raCmpb = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String paCmC = null;
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
	private String grpb = null;
	/* Column Info */
	private String raCmC = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String raCm = null;
	/* Column Info */
	private String bseQtrCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchYearlyCurrnetQtaListVO() {}

	public SearchYearlyCurrnetQtaListVO(String ibflag, String pagerows, String bseYr, String ofcVwCd, String rhqCd, String rgnOfcCd, String trdCd, String subTrdCd, String rlaneCd, String dirCd, String hulBndCd, String bseMon, String bseWk, String vvd, String fnlBsaCapa, String lodQty, String gRev, String grpb, String grpbDecimal, String paCmC, String raCmC, String paCm, String raCm, String paCmcb, String raCmcb, String paCmpb, String raCmpb, String bseQtrCd) {
		this.ofcVwCd = ofcVwCd;
		this.gRev = gRev;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.fnlBsaCapa = fnlBsaCapa;
		this.pagerows = pagerows;
		this.bseMon = bseMon;
		this.paCm = paCm;
		this.ibflag = ibflag;
		this.dirCd = dirCd;
		this.rgnOfcCd = rgnOfcCd;
		this.lodQty = lodQty;
		this.raCmpb = raCmpb;
		this.hulBndCd = hulBndCd;
		this.rhqCd = rhqCd;
		this.paCmC = paCmC;
		this.paCmcb = paCmcb;
		this.paCmpb = paCmpb;
		this.bseYr = bseYr;
		this.bseWk = bseWk;
		this.raCmcb = raCmcb;
		this.vvd = vvd;
		this.grpbDecimal = grpbDecimal;
		this.grpb = grpb;
		this.raCmC = raCmC;
		this.subTrdCd = subTrdCd;
		this.raCm = raCm;
		this.bseQtrCd = bseQtrCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_vw_cd", getOfcVwCd());
		this.hashColumns.put("g_rev", getGRev());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("fnl_bsa_capa", getFnlBsaCapa());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("pa_cm", getPaCm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("ra_cmpb", getRaCmpb());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("pa_cm_c", getPaCmC());
		this.hashColumns.put("pa_cmcb", getPaCmcb());
		this.hashColumns.put("pa_cmpb", getPaCmpb());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("ra_cmcb", getRaCmcb());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("grpb_decimal", getGrpbDecimal());
		this.hashColumns.put("grpb", getGrpb());
		this.hashColumns.put("ra_cm_c", getRaCmC());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("ra_cm", getRaCm());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_vw_cd", "ofcVwCd");
		this.hashFields.put("g_rev", "gRev");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("fnl_bsa_capa", "fnlBsaCapa");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("pa_cm", "paCm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("ra_cmpb", "raCmpb");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("pa_cm_c", "paCmC");
		this.hashFields.put("pa_cmcb", "paCmcb");
		this.hashFields.put("pa_cmpb", "paCmpb");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("ra_cmcb", "raCmcb");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("grpb_decimal", "grpbDecimal");
		this.hashFields.put("grpb", "grpb");
		this.hashFields.put("ra_cm_c", "raCmC");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("ra_cm", "raCm");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		return this.hashFields;
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
	 * @return gRev
	 */
	public String getGRev() {
		return this.gRev;
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
	 * @return bseMon
	 */
	public String getBseMon() {
		return this.bseMon;
	}
	
	/**
	 * Column Info
	 * @return paCm
	 */
	public String getPaCm() {
		return this.paCm;
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
	 * @return raCmpb
	 */
	public String getRaCmpb() {
		return this.raCmpb;
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
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return paCmC
	 */
	public String getPaCmC() {
		return this.paCmC;
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
	 * @return grpb
	 */
	public String getGrpb() {
		return this.grpb;
	}
	
	/**
	 * Column Info
	 * @return raCmC
	 */
	public String getRaCmC() {
		return this.raCmC;
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
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
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
	 * @param gRev
	 */
	public void setGRev(String gRev) {
		this.gRev = gRev;
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
	 * @param bseMon
	 */
	public void setBseMon(String bseMon) {
		this.bseMon = bseMon;
	}
	
	/**
	 * Column Info
	 * @param paCm
	 */
	public void setPaCm(String paCm) {
		this.paCm = paCm;
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
	 * @param raCmpb
	 */
	public void setRaCmpb(String raCmpb) {
		this.raCmpb = raCmpb;
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
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param paCmC
	 */
	public void setPaCmC(String paCmC) {
		this.paCmC = paCmC;
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
	 * @param grpb
	 */
	public void setGrpb(String grpb) {
		this.grpb = grpb;
	}
	
	/**
	 * Column Info
	 * @param raCmC
	 */
	public void setRaCmC(String raCmC) {
		this.raCmC = raCmC;
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
	 * Column Info
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
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
		setOfcVwCd(JSPUtil.getParameter(request, prefix + "ofc_vw_cd", ""));
		setGRev(JSPUtil.getParameter(request, prefix + "g_rev", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setFnlBsaCapa(JSPUtil.getParameter(request, prefix + "fnl_bsa_capa", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBseMon(JSPUtil.getParameter(request, prefix + "bse_mon", ""));
		setPaCm(JSPUtil.getParameter(request, prefix + "pa_cm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setLodQty(JSPUtil.getParameter(request, prefix + "lod_qty", ""));
		setRaCmpb(JSPUtil.getParameter(request, prefix + "ra_cmpb", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setPaCmC(JSPUtil.getParameter(request, prefix + "pa_cm_c", ""));
		setPaCmcb(JSPUtil.getParameter(request, prefix + "pa_cmcb", ""));
		setPaCmpb(JSPUtil.getParameter(request, prefix + "pa_cmpb", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setBseWk(JSPUtil.getParameter(request, prefix + "bse_wk", ""));
		setRaCmcb(JSPUtil.getParameter(request, prefix + "ra_cmcb", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setGrpbDecimal(JSPUtil.getParameter(request, prefix + "grpb_decimal", ""));
		setGrpb(JSPUtil.getParameter(request, prefix + "grpb", ""));
		setRaCmC(JSPUtil.getParameter(request, prefix + "ra_cm_c", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setRaCm(JSPUtil.getParameter(request, prefix + "ra_cm", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchYearlyCurrnetQtaListVO[]
	 */
	public SearchYearlyCurrnetQtaListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchYearlyCurrnetQtaListVO[]
	 */
	public SearchYearlyCurrnetQtaListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchYearlyCurrnetQtaListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcVwCd = (JSPUtil.getParameter(request, prefix	+ "ofc_vw_cd", length));
			String[] gRev = (JSPUtil.getParameter(request, prefix	+ "g_rev", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] fnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_bsa_capa", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] paCm = (JSPUtil.getParameter(request, prefix	+ "pa_cm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] raCmpb = (JSPUtil.getParameter(request, prefix	+ "ra_cmpb", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] paCmC = (JSPUtil.getParameter(request, prefix	+ "pa_cm_c", length));
			String[] paCmcb = (JSPUtil.getParameter(request, prefix	+ "pa_cmcb", length));
			String[] paCmpb = (JSPUtil.getParameter(request, prefix	+ "pa_cmpb", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] raCmcb = (JSPUtil.getParameter(request, prefix	+ "ra_cmcb", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] grpbDecimal = (JSPUtil.getParameter(request, prefix	+ "grpb_decimal", length));
			String[] grpb = (JSPUtil.getParameter(request, prefix	+ "grpb", length));
			String[] raCmC = (JSPUtil.getParameter(request, prefix	+ "ra_cm_c", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] raCm = (JSPUtil.getParameter(request, prefix	+ "ra_cm", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchYearlyCurrnetQtaListVO();
				if (ofcVwCd[i] != null)
					model.setOfcVwCd(ofcVwCd[i]);
				if (gRev[i] != null)
					model.setGRev(gRev[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (fnlBsaCapa[i] != null)
					model.setFnlBsaCapa(fnlBsaCapa[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (paCm[i] != null)
					model.setPaCm(paCm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (raCmpb[i] != null)
					model.setRaCmpb(raCmpb[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (paCmC[i] != null)
					model.setPaCmC(paCmC[i]);
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
				if (grpb[i] != null)
					model.setGrpb(grpb[i]);
				if (raCmC[i] != null)
					model.setRaCmC(raCmC[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (raCm[i] != null)
					model.setRaCm(raCm[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchYearlyCurrnetQtaListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchYearlyCurrnetQtaListVO[]
	 */
	public SearchYearlyCurrnetQtaListVO[] getSearchYearlyCurrnetQtaListVOs(){
		SearchYearlyCurrnetQtaListVO[] vos = (SearchYearlyCurrnetQtaListVO[])models.toArray(new SearchYearlyCurrnetQtaListVO[models.size()]);
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
		this.ofcVwCd = this.ofcVwCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gRev = this.gRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBsaCapa = this.fnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCm = this.paCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmpb = this.raCmpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCmC = this.paCmC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCmcb = this.paCmcb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCmpb = this.paCmpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmcb = this.raCmcb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpbDecimal = this.grpbDecimal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpb = this.grpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmC = this.raCmC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCm = this.raCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
