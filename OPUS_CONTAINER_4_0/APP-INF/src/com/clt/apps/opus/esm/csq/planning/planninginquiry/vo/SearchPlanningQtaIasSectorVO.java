/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchPlanningQtaIasSectorVO.java
*@FileTitle : SearchPlanningQtaIasSectorVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.24
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2014.02.24 이혜민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.csq.planning.planninginquiry.vo;

import java.lang.reflect.Field;
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
 * @author 이혜민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchPlanningQtaIasSectorVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPlanningQtaIasSectorVO> models = new ArrayList<SearchPlanningQtaIasSectorVO>();
	
	/* Column Info */
	private String ofcVwCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String iasRgnCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String paCmCost = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseMon = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String paCm = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bseTpCd = null;
	/* Column Info */
	private String revRpb = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String lodQty = null;
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
	private String raCmcb = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String raCmCost = null;
	/* Column Info */
	private String grsRev = null;
	/* Column Info */
	private String totBsaCapa = null;
	/* Column Info */
	private String vvdCnt = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String raCm = null;
	/* Column Info */
	private String csqMnSctrFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchPlanningQtaIasSectorVO() {}

	public SearchPlanningQtaIasSectorVO(String ibflag, String pagerows, String bseTpCd, String bseYr, String bseQtrCd, String ofcVwCd, String trdCd, String subTrdCd, String rlaneCd, String dirCd, String iasRgnCd, String lodQty, String revRpb, String grsRev, String paCmCost, String raCmCost, String paCmcb, String raCmcb, String paCm, String raCm, String paCmpb, String raCmpb, String rhqCd, String rgnOfcCd, String polCd, String podCd, String vvdCnt, String totBsaCapa, String bseMon, String csqMnSctrFlg) {
		this.ofcVwCd = ofcVwCd;
		this.trdCd = trdCd;
		this.iasRgnCd = iasRgnCd;
		this.rlaneCd = rlaneCd;
		this.paCmCost = paCmCost;
		this.pagerows = pagerows;
		this.bseMon = bseMon;
		this.bseQtrCd = bseQtrCd;
		this.paCm = paCm;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.bseTpCd = bseTpCd;
		this.revRpb = revRpb;
		this.dirCd = dirCd;
		this.rgnOfcCd = rgnOfcCd;
		this.lodQty = lodQty;
		this.raCmpb = raCmpb;
		this.rhqCd = rhqCd;
		this.paCmcb = paCmcb;
		this.paCmpb = paCmpb;
		this.bseYr = bseYr;
		this.raCmcb = raCmcb;
		this.podCd = podCd;
		this.raCmCost = raCmCost;
		this.grsRev = grsRev;
		this.totBsaCapa = totBsaCapa;
		this.vvdCnt = vvdCnt;
		this.subTrdCd = subTrdCd;
		this.raCm = raCm;
		this.csqMnSctrFlg = csqMnSctrFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_vw_cd", getOfcVwCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("ias_rgn_cd", getIasRgnCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pa_cm_cost", getPaCmCost());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("pa_cm", getPaCm());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bse_tp_cd", getBseTpCd());
		this.hashColumns.put("rev_rpb", getRevRpb());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("ra_cmpb", getRaCmpb());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("pa_cmcb", getPaCmcb());
		this.hashColumns.put("pa_cmpb", getPaCmpb());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("ra_cmcb", getRaCmcb());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ra_cm_cost", getRaCmCost());
		this.hashColumns.put("grs_rev", getGrsRev());
		this.hashColumns.put("tot_bsa_capa", getTotBsaCapa());
		this.hashColumns.put("vvd_cnt", getVvdCnt());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("ra_cm", getRaCm());
		this.hashColumns.put("csq_mn_sctr_flg", getCsqMnSctrFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_vw_cd", "ofcVwCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("ias_rgn_cd", "iasRgnCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pa_cm_cost", "paCmCost");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("pa_cm", "paCm");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bse_tp_cd", "bseTpCd");
		this.hashFields.put("rev_rpb", "revRpb");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("ra_cmpb", "raCmpb");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("pa_cmcb", "paCmcb");
		this.hashFields.put("pa_cmpb", "paCmpb");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("ra_cmcb", "raCmcb");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ra_cm_cost", "raCmCost");
		this.hashFields.put("grs_rev", "grsRev");
		this.hashFields.put("tot_bsa_capa", "totBsaCapa");
		this.hashFields.put("vvd_cnt", "vvdCnt");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("ra_cm", "raCm");
		this.hashFields.put("csq_mn_sctr_flg", "csqMnSctrFlg");
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
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
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return bseTpCd
	 */
	public String getBseTpCd() {
		return this.bseTpCd;
	}
	
	/**
	 * Column Info
	 * @return revRpb
	 */
	public String getRevRpb() {
		return this.revRpb;
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
	 * @return raCmcb
	 */
	public String getRaCmcb() {
		return this.raCmcb;
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
	 * @return raCmCost
	 */
	public String getRaCmCost() {
		return this.raCmCost;
	}
	
	/**
	 * Column Info
	 * @return grsRev
	 */
	public String getGrsRev() {
		return this.grsRev;
	}
	
	/**
	 * Column Info
	 * @return totBsaCapa
	 */
	public String getTotBsaCapa() {
		return this.totBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return vvdCnt
	 */
	public String getVvdCnt() {
		return this.vvdCnt;
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
	 * @return csqMnSctrFlg
	 */
	public String getCsqMnSctrFlg() {
		return this.csqMnSctrFlg;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
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
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param bseTpCd
	 */
	public void setBseTpCd(String bseTpCd) {
		this.bseTpCd = bseTpCd;
	}
	
	/**
	 * Column Info
	 * @param revRpb
	 */
	public void setRevRpb(String revRpb) {
		this.revRpb = revRpb;
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
	 * @param raCmcb
	 */
	public void setRaCmcb(String raCmcb) {
		this.raCmcb = raCmcb;
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
	 * @param raCmCost
	 */
	public void setRaCmCost(String raCmCost) {
		this.raCmCost = raCmCost;
	}
	
	/**
	 * Column Info
	 * @param grsRev
	 */
	public void setGrsRev(String grsRev) {
		this.grsRev = grsRev;
	}
	
	/**
	 * Column Info
	 * @param totBsaCapa
	 */
	public void setTotBsaCapa(String totBsaCapa) {
		this.totBsaCapa = totBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param vvdCnt
	 */
	public void setVvdCnt(String vvdCnt) {
		this.vvdCnt = vvdCnt;
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
	 * @param csqMnSctrFlg
	 */
	public void setCsqMnSctrFlg(String csqMnSctrFlg) {
		this.csqMnSctrFlg = csqMnSctrFlg;
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
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setIasRgnCd(JSPUtil.getParameter(request, prefix + "ias_rgn_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPaCmCost(JSPUtil.getParameter(request, prefix + "pa_cm_cost", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBseMon(JSPUtil.getParameter(request, prefix + "bse_mon", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setPaCm(JSPUtil.getParameter(request, prefix + "pa_cm", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBseTpCd(JSPUtil.getParameter(request, prefix + "bse_tp_cd", ""));
		setRevRpb(JSPUtil.getParameter(request, prefix + "rev_rpb", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setLodQty(JSPUtil.getParameter(request, prefix + "lod_qty", ""));
		setRaCmpb(JSPUtil.getParameter(request, prefix + "ra_cmpb", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setPaCmcb(JSPUtil.getParameter(request, prefix + "pa_cmcb", ""));
		setPaCmpb(JSPUtil.getParameter(request, prefix + "pa_cmpb", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setRaCmcb(JSPUtil.getParameter(request, prefix + "ra_cmcb", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setRaCmCost(JSPUtil.getParameter(request, prefix + "ra_cm_cost", ""));
		setGrsRev(JSPUtil.getParameter(request, prefix + "grs_rev", ""));
		setTotBsaCapa(JSPUtil.getParameter(request, prefix + "tot_bsa_capa", ""));
		setVvdCnt(JSPUtil.getParameter(request, prefix + "vvd_cnt", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setRaCm(JSPUtil.getParameter(request, prefix + "ra_cm", ""));
		setCsqMnSctrFlg(JSPUtil.getParameter(request, prefix + "csq_mn_sctr_flg", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPlanningQtaIasSectorVO[]
	 */
	public SearchPlanningQtaIasSectorVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPlanningQtaIasSectorVO[]
	 */
	public SearchPlanningQtaIasSectorVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPlanningQtaIasSectorVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcVwCd = (JSPUtil.getParameter(request, prefix	+ "ofc_vw_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] iasRgnCd = (JSPUtil.getParameter(request, prefix	+ "ias_rgn_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] paCmCost = (JSPUtil.getParameter(request, prefix	+ "pa_cm_cost", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] paCm = (JSPUtil.getParameter(request, prefix	+ "pa_cm", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bseTpCd = (JSPUtil.getParameter(request, prefix	+ "bse_tp_cd", length));
			String[] revRpb = (JSPUtil.getParameter(request, prefix	+ "rev_rpb", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] raCmpb = (JSPUtil.getParameter(request, prefix	+ "ra_cmpb", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] paCmcb = (JSPUtil.getParameter(request, prefix	+ "pa_cmcb", length));
			String[] paCmpb = (JSPUtil.getParameter(request, prefix	+ "pa_cmpb", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] raCmcb = (JSPUtil.getParameter(request, prefix	+ "ra_cmcb", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] raCmCost = (JSPUtil.getParameter(request, prefix	+ "ra_cm_cost", length));
			String[] grsRev = (JSPUtil.getParameter(request, prefix	+ "grs_rev", length));
			String[] totBsaCapa = (JSPUtil.getParameter(request, prefix	+ "tot_bsa_capa", length));
			String[] vvdCnt = (JSPUtil.getParameter(request, prefix	+ "vvd_cnt", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] raCm = (JSPUtil.getParameter(request, prefix	+ "ra_cm", length));
			String[] csqMnSctrFlg = (JSPUtil.getParameter(request, prefix	+ "csq_mn_sctr_flg", length));

			for (int i = 0; i < length; i++) {
				model = new SearchPlanningQtaIasSectorVO();
				if (ofcVwCd[i] != null)
					model.setOfcVwCd(ofcVwCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (iasRgnCd[i] != null)
					model.setIasRgnCd(iasRgnCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (paCmCost[i] != null)
					model.setPaCmCost(paCmCost[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (paCm[i] != null)
					model.setPaCm(paCm[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bseTpCd[i] != null)
					model.setBseTpCd(bseTpCd[i]);
				if (revRpb[i] != null)
					model.setRevRpb(revRpb[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
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
				if (raCmcb[i] != null)
					model.setRaCmcb(raCmcb[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (raCmCost[i] != null)
					model.setRaCmCost(raCmCost[i]);
				if (grsRev[i] != null)
					model.setGrsRev(grsRev[i]);
				if (totBsaCapa[i] != null)
					model.setTotBsaCapa(totBsaCapa[i]);
				if (vvdCnt[i] != null)
					model.setVvdCnt(vvdCnt[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (raCm[i] != null)
					model.setRaCm(raCm[i]);
				if (csqMnSctrFlg[i] != null)
					model.setCsqMnSctrFlg(csqMnSctrFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPlanningQtaIasSectorVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPlanningQtaIasSectorVO[]
	 */
	public SearchPlanningQtaIasSectorVO[] getSearchPlanningQtaIasSectorVOs(){
		SearchPlanningQtaIasSectorVO[] vos = (SearchPlanningQtaIasSectorVO[])models.toArray(new SearchPlanningQtaIasSectorVO[models.size()]);
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
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iasRgnCd = this.iasRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCmCost = this.paCmCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCm = this.paCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseTpCd = this.bseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revRpb = this.revRpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmpb = this.raCmpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCmcb = this.paCmcb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCmpb = this.paCmpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmcb = this.raCmcb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmCost = this.raCmCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRev = this.grsRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBsaCapa = this.totBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCnt = this.vvdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCm = this.raCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csqMnSctrFlg = this.csqMnSctrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
