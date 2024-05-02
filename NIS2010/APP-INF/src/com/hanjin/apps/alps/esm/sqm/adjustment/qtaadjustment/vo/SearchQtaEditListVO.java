/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchQtaEditListVO.java
*@FileTitle : SearchQtaEditListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.28
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.01.28 최성민 
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

public class SearchQtaEditListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchQtaEditListVO> models = new ArrayList<SearchQtaEditListVO>();
	
	/* Column Info */
	private String rlaneCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bseTpCd = null;
	/* Column Info */
	private String bseMon = null;
	/* Column Info */
	private String raCmUcAmt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String sqmMnSctrFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String raCmCost = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String slsYrmon = null;
	/* Column Info */
	private String podCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String qtaRlseVerNo = null;
	/* Column Info */
	private String fnlBsaCapa = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String lodQty = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String grsRpbRev = null;
	/* Column Info */
	private String convDirCd = null;
	/* Column Info */
	private String qtaTgtCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String bseWk = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String ofcVwCd = null;
	/* Column Info */
	private String sqmCngTpCd = null;
	/* Column Info */
	private String pfGrpCd = null;
	/* Column Info */
	private String iasRgnCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String paCmUcAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchQtaEditListVO() {}

	public SearchQtaEditListVO(String ibflag, String pagerows, String qtaRlseVerNo, String bseTpCd, String bseYr, String bseQtrCd, String ofcVwCd, String qtaTgtCd, String trdCd, String dirCd, String subTrdCd, String rlaneCd, String slsYrmon, String bseWk, String rhqCd, String rgnOfcCd, String vvd, String vslCd, String skdVoyNo, String skdDirCd, String convDirCd, String lodQty, String grsRpbRev, String paCmUcAmt, String raCmUcAmt, String bseMon, String fnlBsaCapa, String sqmCngTpCd, String hulBndCd, String pfGrpCd, String updUsrId, String iasRgnCd, String podCd, String polCd, String raCmCost, String sqmMnSctrFlg) {
		this.rlaneCd = rlaneCd;
		this.ibflag = ibflag;
		this.bseTpCd = bseTpCd;
		this.bseMon = bseMon;
		this.raCmUcAmt = raCmUcAmt;
		this.rhqCd = rhqCd;
		this.sqmMnSctrFlg = sqmMnSctrFlg;
		this.updUsrId = updUsrId;
		this.hulBndCd = hulBndCd;
		this.polCd = polCd;
		this.raCmCost = raCmCost;
		this.skdDirCd = skdDirCd;
		this.slsYrmon = slsYrmon;
		this.podCd = podCd;
		this.pagerows = pagerows;
		this.qtaRlseVerNo = qtaRlseVerNo;
		this.fnlBsaCapa = fnlBsaCapa;
		this.skdVoyNo = skdVoyNo;
		this.lodQty = lodQty;
		this.vslCd = vslCd;
		this.vvd = vvd;
		this.grsRpbRev = grsRpbRev;
		this.convDirCd = convDirCd;
		this.qtaTgtCd = qtaTgtCd;
		this.trdCd = trdCd;
		this.bseWk = bseWk;
		this.rgnOfcCd = rgnOfcCd;
		this.ofcVwCd = ofcVwCd;
		this.sqmCngTpCd = sqmCngTpCd;
		this.pfGrpCd = pfGrpCd;
		this.iasRgnCd = iasRgnCd;
		this.bseYr = bseYr;
		this.subTrdCd = subTrdCd;
		this.bseQtrCd = bseQtrCd;
		this.dirCd = dirCd;
		this.paCmUcAmt = paCmUcAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bse_tp_cd", getBseTpCd());
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("ra_cm_uc_amt", getRaCmUcAmt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("sqm_mn_sctr_flg", getSqmMnSctrFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ra_cm_cost", getRaCmCost());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("sls_yrmon", getSlsYrmon());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("qta_rlse_ver_no", getQtaRlseVerNo());
		this.hashColumns.put("fnl_bsa_capa", getFnlBsaCapa());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("grs_rpb_rev", getGrsRpbRev());
		this.hashColumns.put("conv_dir_cd", getConvDirCd());
		this.hashColumns.put("qta_tgt_cd", getQtaTgtCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("ofc_vw_cd", getOfcVwCd());
		this.hashColumns.put("sqm_cng_tp_cd", getSqmCngTpCd());
		this.hashColumns.put("pf_grp_cd", getPfGrpCd());
		this.hashColumns.put("ias_rgn_cd", getIasRgnCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("pa_cm_uc_amt", getPaCmUcAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bse_tp_cd", "bseTpCd");
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("ra_cm_uc_amt", "raCmUcAmt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("sqm_mn_sctr_flg", "sqmMnSctrFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ra_cm_cost", "raCmCost");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("sls_yrmon", "slsYrmon");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("qta_rlse_ver_no", "qtaRlseVerNo");
		this.hashFields.put("fnl_bsa_capa", "fnlBsaCapa");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("grs_rpb_rev", "grsRpbRev");
		this.hashFields.put("conv_dir_cd", "convDirCd");
		this.hashFields.put("qta_tgt_cd", "qtaTgtCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("ofc_vw_cd", "ofcVwCd");
		this.hashFields.put("sqm_cng_tp_cd", "sqmCngTpCd");
		this.hashFields.put("pf_grp_cd", "pfGrpCd");
		this.hashFields.put("ias_rgn_cd", "iasRgnCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("pa_cm_uc_amt", "paCmUcAmt");
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
	 * @return bseTpCd
	 */
	public String getBseTpCd() {
		return this.bseTpCd;
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
	 * @return raCmUcAmt
	 */
	public String getRaCmUcAmt() {
		return this.raCmUcAmt;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return raCmCost
	 */
	public String getRaCmCost() {
		return this.raCmCost;
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
	 * @return slsYrmon
	 */
	public String getSlsYrmon() {
		return this.slsYrmon;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return qtaRlseVerNo
	 */
	public String getQtaRlseVerNo() {
		return this.qtaRlseVerNo;
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
	 * @return grsRpbRev
	 */
	public String getGrsRpbRev() {
		return this.grsRpbRev;
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
	 * @return qtaTgtCd
	 */
	public String getQtaTgtCd() {
		return this.qtaTgtCd;
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
	 * @return ofcVwCd
	 */
	public String getOfcVwCd() {
		return this.ofcVwCd;
	}
	
	/**
	 * Column Info
	 * @return sqmCngTpCd
	 */
	public String getSqmCngTpCd() {
		return this.sqmCngTpCd;
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
	 * @return iasRgnCd
	 */
	public String getIasRgnCd() {
		return this.iasRgnCd;
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
	 * @return paCmUcAmt
	 */
	public String getPaCmUcAmt() {
		return this.paCmUcAmt;
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
	 * @param bseTpCd
	 */
	public void setBseTpCd(String bseTpCd) {
		this.bseTpCd = bseTpCd;
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
	 * @param raCmUcAmt
	 */
	public void setRaCmUcAmt(String raCmUcAmt) {
		this.raCmUcAmt = raCmUcAmt;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param raCmCost
	 */
	public void setRaCmCost(String raCmCost) {
		this.raCmCost = raCmCost;
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
	 * @param slsYrmon
	 */
	public void setSlsYrmon(String slsYrmon) {
		this.slsYrmon = slsYrmon;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param qtaRlseVerNo
	 */
	public void setQtaRlseVerNo(String qtaRlseVerNo) {
		this.qtaRlseVerNo = qtaRlseVerNo;
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
	 * @param grsRpbRev
	 */
	public void setGrsRpbRev(String grsRpbRev) {
		this.grsRpbRev = grsRpbRev;
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
	 * @param qtaTgtCd
	 */
	public void setQtaTgtCd(String qtaTgtCd) {
		this.qtaTgtCd = qtaTgtCd;
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
	 * @param ofcVwCd
	 */
	public void setOfcVwCd(String ofcVwCd) {
		this.ofcVwCd = ofcVwCd;
	}
	
	/**
	 * Column Info
	 * @param sqmCngTpCd
	 */
	public void setSqmCngTpCd(String sqmCngTpCd) {
		this.sqmCngTpCd = sqmCngTpCd;
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
	 * @param iasRgnCd
	 */
	public void setIasRgnCd(String iasRgnCd) {
		this.iasRgnCd = iasRgnCd;
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
	 * @param paCmUcAmt
	 */
	public void setPaCmUcAmt(String paCmUcAmt) {
		this.paCmUcAmt = paCmUcAmt;
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
		setBseTpCd(JSPUtil.getParameter(request, prefix + "bse_tp_cd", ""));
		setBseMon(JSPUtil.getParameter(request, prefix + "bse_mon", ""));
		setRaCmUcAmt(JSPUtil.getParameter(request, prefix + "ra_cm_uc_amt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setSqmMnSctrFlg(JSPUtil.getParameter(request, prefix + "sqm_mn_sctr_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setRaCmCost(JSPUtil.getParameter(request, prefix + "ra_cm_cost", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setSlsYrmon(JSPUtil.getParameter(request, prefix + "sls_yrmon", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setQtaRlseVerNo(JSPUtil.getParameter(request, prefix + "qta_rlse_ver_no", ""));
		setFnlBsaCapa(JSPUtil.getParameter(request, prefix + "fnl_bsa_capa", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setLodQty(JSPUtil.getParameter(request, prefix + "lod_qty", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setGrsRpbRev(JSPUtil.getParameter(request, prefix + "grs_rpb_rev", ""));
		setConvDirCd(JSPUtil.getParameter(request, prefix + "conv_dir_cd", ""));
		setQtaTgtCd(JSPUtil.getParameter(request, prefix + "qta_tgt_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setBseWk(JSPUtil.getParameter(request, prefix + "bse_wk", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setOfcVwCd(JSPUtil.getParameter(request, prefix + "ofc_vw_cd", ""));
		setSqmCngTpCd(JSPUtil.getParameter(request, prefix + "sqm_cng_tp_cd", ""));
		setPfGrpCd(JSPUtil.getParameter(request, prefix + "pf_grp_cd", ""));
		setIasRgnCd(JSPUtil.getParameter(request, prefix + "ias_rgn_cd", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setPaCmUcAmt(JSPUtil.getParameter(request, prefix + "pa_cm_uc_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchQtaEditListVO[]
	 */
	public SearchQtaEditListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchQtaEditListVO[]
	 */
	public SearchQtaEditListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchQtaEditListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bseTpCd = (JSPUtil.getParameter(request, prefix	+ "bse_tp_cd", length));
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] raCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "ra_cm_uc_amt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] sqmMnSctrFlg = (JSPUtil.getParameter(request, prefix	+ "sqm_mn_sctr_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] raCmCost = (JSPUtil.getParameter(request, prefix	+ "ra_cm_cost", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] slsYrmon = (JSPUtil.getParameter(request, prefix	+ "sls_yrmon", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] qtaRlseVerNo = (JSPUtil.getParameter(request, prefix	+ "qta_rlse_ver_no", length));
			String[] fnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_bsa_capa", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] grsRpbRev = (JSPUtil.getParameter(request, prefix	+ "grs_rpb_rev", length));
			String[] convDirCd = (JSPUtil.getParameter(request, prefix	+ "conv_dir_cd", length));
			String[] qtaTgtCd = (JSPUtil.getParameter(request, prefix	+ "qta_tgt_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] ofcVwCd = (JSPUtil.getParameter(request, prefix	+ "ofc_vw_cd", length));
			String[] sqmCngTpCd = (JSPUtil.getParameter(request, prefix	+ "sqm_cng_tp_cd", length));
			String[] pfGrpCd = (JSPUtil.getParameter(request, prefix	+ "pf_grp_cd", length));
			String[] iasRgnCd = (JSPUtil.getParameter(request, prefix	+ "ias_rgn_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] paCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "pa_cm_uc_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchQtaEditListVO();
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bseTpCd[i] != null)
					model.setBseTpCd(bseTpCd[i]);
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (raCmUcAmt[i] != null)
					model.setRaCmUcAmt(raCmUcAmt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (sqmMnSctrFlg[i] != null)
					model.setSqmMnSctrFlg(sqmMnSctrFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (raCmCost[i] != null)
					model.setRaCmCost(raCmCost[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (slsYrmon[i] != null)
					model.setSlsYrmon(slsYrmon[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (qtaRlseVerNo[i] != null)
					model.setQtaRlseVerNo(qtaRlseVerNo[i]);
				if (fnlBsaCapa[i] != null)
					model.setFnlBsaCapa(fnlBsaCapa[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (grsRpbRev[i] != null)
					model.setGrsRpbRev(grsRpbRev[i]);
				if (convDirCd[i] != null)
					model.setConvDirCd(convDirCd[i]);
				if (qtaTgtCd[i] != null)
					model.setQtaTgtCd(qtaTgtCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (bseWk[i] != null)
					model.setBseWk(bseWk[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (ofcVwCd[i] != null)
					model.setOfcVwCd(ofcVwCd[i]);
				if (sqmCngTpCd[i] != null)
					model.setSqmCngTpCd(sqmCngTpCd[i]);
				if (pfGrpCd[i] != null)
					model.setPfGrpCd(pfGrpCd[i]);
				if (iasRgnCd[i] != null)
					model.setIasRgnCd(iasRgnCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (paCmUcAmt[i] != null)
					model.setPaCmUcAmt(paCmUcAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchQtaEditListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchQtaEditListVO[]
	 */
	public SearchQtaEditListVO[] getSearchQtaEditListVOs(){
		SearchQtaEditListVO[] vos = (SearchQtaEditListVO[])models.toArray(new SearchQtaEditListVO[models.size()]);
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
		this.bseTpCd = this.bseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmUcAmt = this.raCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sqmMnSctrFlg = this.sqmMnSctrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmCost = this.raCmCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsYrmon = this.slsYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaRlseVerNo = this.qtaRlseVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBsaCapa = this.fnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRpbRev = this.grsRpbRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDirCd = this.convDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaTgtCd = this.qtaTgtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcVwCd = this.ofcVwCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sqmCngTpCd = this.sqmCngTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfGrpCd = this.pfGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iasRgnCd = this.iasRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCmUcAmt = this.paCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
