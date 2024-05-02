/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchQtaEditListVO.java
*@FileTitle : SearchQtaEditListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.31
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2014.03.31 이혜민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo;

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

public class SearchQtaEditListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchQtaEditListVO> models = new ArrayList<SearchQtaEditListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String qtaTgtCd = null;
	/* Column Info */
	private String ofcVwCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String iasRgnCd = null;
	/* Column Info */
	private String paCmCost = null;
	/* Column Info */
	private String fnlBsaCapa = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseMon = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String convDirCd = null;
	/* Column Info */
	private String grsRpbRev = null;
	/* Column Info */
	private String bseTpCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String paCmUcAmt = null;
	/* Column Info */
	private String qtaRlseVerNo = null;
	/* Column Info */
	private String lodQty = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String bseWk = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String csqCngTpCd = null;
	/* Column Info */
	private String raCmCost = null;
	/* Column Info */
	private String raCmUcAmt = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String csqMnSctrFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchQtaEditListVO() {}

	public SearchQtaEditListVO(String ibflag, String pagerows, String vslCd, String qtaTgtCd, String ofcVwCd, String trdCd, String iasRgnCd, String rlaneCd, String fnlBsaCapa, String bseQtrCd, String bseMon, String polCd, String convDirCd, String grsRpbRev, String bseTpCd, String dirCd, String rgnOfcCd, String paCmUcAmt, String qtaRlseVerNo, String lodQty, String rhqCd, String skdVoyNo, String bseYr, String bseWk, String skdDirCd, String podCd, String vvd, String csqCngTpCd, String raCmUcAmt, String subTrdCd, String paCmCost, String raCmCost, String updUsrId, String csqMnSctrFlg) {
		this.vslCd = vslCd;
		this.qtaTgtCd = qtaTgtCd;
		this.ofcVwCd = ofcVwCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.iasRgnCd = iasRgnCd;
		this.paCmCost = paCmCost;
		this.fnlBsaCapa = fnlBsaCapa;
		this.pagerows = pagerows;
		this.bseMon = bseMon;
		this.bseQtrCd = bseQtrCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.convDirCd = convDirCd;
		this.grsRpbRev = grsRpbRev;
		this.bseTpCd = bseTpCd;
		this.dirCd = dirCd;
		this.rgnOfcCd = rgnOfcCd;
		this.updUsrId = updUsrId;
		this.paCmUcAmt = paCmUcAmt;
		this.qtaRlseVerNo = qtaRlseVerNo;
		this.lodQty = lodQty;
		this.rhqCd = rhqCd;
		this.skdVoyNo = skdVoyNo;
		this.bseYr = bseYr;
		this.bseWk = bseWk;
		this.skdDirCd = skdDirCd;
		this.vvd = vvd;
		this.podCd = podCd;
		this.csqCngTpCd = csqCngTpCd;
		this.raCmCost = raCmCost;
		this.raCmUcAmt = raCmUcAmt;
		this.subTrdCd = subTrdCd;
		this.csqMnSctrFlg = csqMnSctrFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("qta_tgt_cd", getQtaTgtCd());
		this.hashColumns.put("ofc_vw_cd", getOfcVwCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("ias_rgn_cd", getIasRgnCd());
		this.hashColumns.put("pa_cm_cost", getPaCmCost());
		this.hashColumns.put("fnl_bsa_capa", getFnlBsaCapa());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("conv_dir_cd", getConvDirCd());
		this.hashColumns.put("grs_rpb_rev", getGrsRpbRev());
		this.hashColumns.put("bse_tp_cd", getBseTpCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pa_cm_uc_amt", getPaCmUcAmt());
		this.hashColumns.put("qta_rlse_ver_no", getQtaRlseVerNo());
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("csq_cng_tp_cd", getCsqCngTpCd());
		this.hashColumns.put("ra_cm_cost", getRaCmCost());
		this.hashColumns.put("ra_cm_uc_amt", getRaCmUcAmt());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("csq_mn_sctr_flg", getCsqMnSctrFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("qta_tgt_cd", "qtaTgtCd");
		this.hashFields.put("ofc_vw_cd", "ofcVwCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("ias_rgn_cd", "iasRgnCd");
		this.hashFields.put("pa_cm_cost", "paCmCost");
		this.hashFields.put("fnl_bsa_capa", "fnlBsaCapa");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("conv_dir_cd", "convDirCd");
		this.hashFields.put("grs_rpb_rev", "grsRpbRev");
		this.hashFields.put("bse_tp_cd", "bseTpCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pa_cm_uc_amt", "paCmUcAmt");
		this.hashFields.put("qta_rlse_ver_no", "qtaRlseVerNo");
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("csq_cng_tp_cd", "csqCngTpCd");
		this.hashFields.put("ra_cm_cost", "raCmCost");
		this.hashFields.put("ra_cm_uc_amt", "raCmUcAmt");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("csq_mn_sctr_flg", "csqMnSctrFlg");
		return this.hashFields;
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
	 * @return qtaTgtCd
	 */
	public String getQtaTgtCd() {
		return this.qtaTgtCd;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return convDirCd
	 */
	public String getConvDirCd() {
		return this.convDirCd;
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
	 * @return bseTpCd
	 */
	public String getBseTpCd() {
		return this.bseTpCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return qtaRlseVerNo
	 */
	public String getQtaRlseVerNo() {
		return this.qtaRlseVerNo;
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
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return csqCngTpCd
	 */
	public String getCsqCngTpCd() {
		return this.csqCngTpCd;
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
	 * @return raCmUcAmt
	 */
	public String getRaCmUcAmt() {
		return this.raCmUcAmt;
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
	 * @return csqMnSctrFlg
	 */
	public String getCsqMnSctrFlg() {
		return this.csqMnSctrFlg;
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
	 * @param qtaTgtCd
	 */
	public void setQtaTgtCd(String qtaTgtCd) {
		this.qtaTgtCd = qtaTgtCd;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param convDirCd
	 */
	public void setConvDirCd(String convDirCd) {
		this.convDirCd = convDirCd;
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
	 * @param bseTpCd
	 */
	public void setBseTpCd(String bseTpCd) {
		this.bseTpCd = bseTpCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param paCmUcAmt
	 */
	public void setPaCmUcAmt(String paCmUcAmt) {
		this.paCmUcAmt = paCmUcAmt;
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
	 * @param lodQty
	 */
	public void setLodQty(String lodQty) {
		this.lodQty = lodQty;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param csqCngTpCd
	 */
	public void setCsqCngTpCd(String csqCngTpCd) {
		this.csqCngTpCd = csqCngTpCd;
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
	 * @param raCmUcAmt
	 */
	public void setRaCmUcAmt(String raCmUcAmt) {
		this.raCmUcAmt = raCmUcAmt;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setQtaTgtCd(JSPUtil.getParameter(request, prefix + "qta_tgt_cd", ""));
		setOfcVwCd(JSPUtil.getParameter(request, prefix + "ofc_vw_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setIasRgnCd(JSPUtil.getParameter(request, prefix + "ias_rgn_cd", ""));
		setPaCmCost(JSPUtil.getParameter(request, prefix + "pa_cm_cost", ""));
		setFnlBsaCapa(JSPUtil.getParameter(request, prefix + "fnl_bsa_capa", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBseMon(JSPUtil.getParameter(request, prefix + "bse_mon", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setConvDirCd(JSPUtil.getParameter(request, prefix + "conv_dir_cd", ""));
		setGrsRpbRev(JSPUtil.getParameter(request, prefix + "grs_rpb_rev", ""));
		setBseTpCd(JSPUtil.getParameter(request, prefix + "bse_tp_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPaCmUcAmt(JSPUtil.getParameter(request, prefix + "pa_cm_uc_amt", ""));
		setQtaRlseVerNo(JSPUtil.getParameter(request, prefix + "qta_rlse_ver_no", ""));
		setLodQty(JSPUtil.getParameter(request, prefix + "lod_qty", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setBseWk(JSPUtil.getParameter(request, prefix + "bse_wk", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCsqCngTpCd(JSPUtil.getParameter(request, prefix + "csq_cng_tp_cd", ""));
		setRaCmCost(JSPUtil.getParameter(request, prefix + "ra_cm_cost", ""));
		setRaCmUcAmt(JSPUtil.getParameter(request, prefix + "ra_cm_uc_amt", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setCsqMnSctrFlg(JSPUtil.getParameter(request, prefix + "csq_mn_sctr_flg", ""));

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
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] qtaTgtCd = (JSPUtil.getParameter(request, prefix	+ "qta_tgt_cd", length));
			String[] ofcVwCd = (JSPUtil.getParameter(request, prefix	+ "ofc_vw_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] iasRgnCd = (JSPUtil.getParameter(request, prefix	+ "ias_rgn_cd", length));
			String[] paCmCost = (JSPUtil.getParameter(request, prefix	+ "pa_cm_cost", length));
			String[] fnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_bsa_capa", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] convDirCd = (JSPUtil.getParameter(request, prefix	+ "conv_dir_cd", length));
			String[] grsRpbRev = (JSPUtil.getParameter(request, prefix	+ "grs_rpb_rev", length));
			String[] bseTpCd = (JSPUtil.getParameter(request, prefix	+ "bse_tp_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] paCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "pa_cm_uc_amt", length));
			String[] qtaRlseVerNo = (JSPUtil.getParameter(request, prefix	+ "qta_rlse_ver_no", length));
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] csqCngTpCd = (JSPUtil.getParameter(request, prefix	+ "csq_cng_tp_cd", length));
			String[] raCmCost = (JSPUtil.getParameter(request, prefix	+ "ra_cm_cost", length));
			String[] raCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "ra_cm_uc_amt", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] csqMnSctrFlg = (JSPUtil.getParameter(request, prefix	+ "csq_mn_sctr_flg", length));

			for (int i = 0; i < length; i++) {
				model = new SearchQtaEditListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (qtaTgtCd[i] != null)
					model.setQtaTgtCd(qtaTgtCd[i]);
				if (ofcVwCd[i] != null)
					model.setOfcVwCd(ofcVwCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (iasRgnCd[i] != null)
					model.setIasRgnCd(iasRgnCd[i]);
				if (paCmCost[i] != null)
					model.setPaCmCost(paCmCost[i]);
				if (fnlBsaCapa[i] != null)
					model.setFnlBsaCapa(fnlBsaCapa[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (convDirCd[i] != null)
					model.setConvDirCd(convDirCd[i]);
				if (grsRpbRev[i] != null)
					model.setGrsRpbRev(grsRpbRev[i]);
				if (bseTpCd[i] != null)
					model.setBseTpCd(bseTpCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (paCmUcAmt[i] != null)
					model.setPaCmUcAmt(paCmUcAmt[i]);
				if (qtaRlseVerNo[i] != null)
					model.setQtaRlseVerNo(qtaRlseVerNo[i]);
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (bseWk[i] != null)
					model.setBseWk(bseWk[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (csqCngTpCd[i] != null)
					model.setCsqCngTpCd(csqCngTpCd[i]);
				if (raCmCost[i] != null)
					model.setRaCmCost(raCmCost[i]);
				if (raCmUcAmt[i] != null)
					model.setRaCmUcAmt(raCmUcAmt[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (csqMnSctrFlg[i] != null)
					model.setCsqMnSctrFlg(csqMnSctrFlg[i]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaTgtCd = this.qtaTgtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcVwCd = this.ofcVwCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iasRgnCd = this.iasRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCmCost = this.paCmCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBsaCapa = this.fnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDirCd = this.convDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRpbRev = this.grsRpbRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseTpCd = this.bseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCmUcAmt = this.paCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaRlseVerNo = this.qtaRlseVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csqCngTpCd = this.csqCngTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmCost = this.raCmCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmUcAmt = this.raCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csqMnSctrFlg = this.csqMnSctrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
