/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchNewLaneSecCmcbListVO.java
*@FileTitle : SearchNewLaneSecCmcbListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.03
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2014.02.03 이혜민 
* 1.0 Creation
* 2015.09.14 김용습 [CHM-201537774] Basic CMCB (CM Cost Per Box)와 Basic CMCB for IAS Sector 두 화면 내 신규 칼럼 추가 (sector lane-office에서 active된 사항을 보여주는 컬럼 추가)
* 2015.10.19 김용습 [CHM-201538305] Basic CMCB (CM Cost Per Box) / Basic CMCB for IAS Sector 화면 내 신규 칼럼 추가
=========================================================*/

package com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo;

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
 * @author 이혜민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchNewLaneSecCmcbListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchNewLaneSecCmcbListVO> models = new ArrayList<SearchNewLaneSecCmcbListVO>();
	
	/* Column Info */
	private String srcDirCd = null;
	/* Column Info */
	private String cmDiff = null;
	/* Column Info */
	private String srcTrdCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String iasRgnCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bseTpCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String selFlg = null;
	/* Column Info */
	private String srcRlaneCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String paCmUcAmt = null;
	/* Column Info */
	private String gidPaCmUcAmt = null;
	/* Column Info */
	private String creFlg = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String actFlgCnt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String saveFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String gidRaCmUcAmt = null;
	/* Column Info */
	private String raCmUcAmt = null;
	/* Column Info */
	private String gidDiff = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String sqmActFlg = null;
	/* Column Info */
	private String initialRpb = null;
	/* Column Info */
	private String initialCmpbRa = null;
	/* Column Info */
	private String currentRpb = null;
	/* Column Info */
	private String currentCmpbRa = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchNewLaneSecCmcbListVO() {}

	public SearchNewLaneSecCmcbListVO(String ibflag, String pagerows, String bseTpCd, String bseYr, String bseQtrCd, String trdCd, String subTrdCd, String iasRgnCd, String rlaneCd, String dirCd, String polCd, String podCd, String gidPaCmUcAmt, String gidRaCmUcAmt, String gidDiff, String paCmUcAmt, String raCmUcAmt, String cmDiff, String srcDirCd, String srcTrdCd, String srcRlaneCd, String creFlg, String saveFlg, String updUsrId, String creUsrId, String selFlg, String actFlgCnt, String sqmActFlg, String initialRpb, String initialCmpbRa, String currentRpb, String currentCmpbRa) {
		this.srcDirCd = srcDirCd;
		this.cmDiff = cmDiff;
		this.srcTrdCd = srcTrdCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.iasRgnCd = iasRgnCd;
		this.pagerows = pagerows;
		this.bseQtrCd = bseQtrCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.bseTpCd = bseTpCd;
		this.dirCd = dirCd;
		this.selFlg = selFlg;
		this.srcRlaneCd = srcRlaneCd;
		this.updUsrId = updUsrId;
		this.paCmUcAmt = paCmUcAmt;
		this.gidPaCmUcAmt = gidPaCmUcAmt;
		this.creFlg = creFlg;
		this.bseYr = bseYr;
		this.actFlgCnt = actFlgCnt;
		this.podCd = podCd;
		this.saveFlg = saveFlg;
		this.creUsrId = creUsrId;
		this.gidRaCmUcAmt = gidRaCmUcAmt;
		this.raCmUcAmt = raCmUcAmt;
		this.gidDiff = gidDiff;
		this.subTrdCd = subTrdCd;
		this.sqmActFlg = sqmActFlg;
		this.initialRpb = initialRpb;
		this.initialCmpbRa = initialCmpbRa;
		this.currentRpb = currentRpb;
		this.currentCmpbRa = currentCmpbRa;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("src_dir_cd", getSrcDirCd());
		this.hashColumns.put("cm_diff", getCmDiff());
		this.hashColumns.put("src_trd_cd", getSrcTrdCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("ias_rgn_cd", getIasRgnCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bse_tp_cd", getBseTpCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("sel_flg", getSelFlg());
		this.hashColumns.put("src_rlane_cd", getSrcRlaneCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pa_cm_uc_amt", getPaCmUcAmt());
		this.hashColumns.put("gid_pa_cm_uc_amt", getGidPaCmUcAmt());
		this.hashColumns.put("cre_flg", getCreFlg());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("act_flg_cnt", getActFlgCnt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("save_flg", getSaveFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("gid_ra_cm_uc_amt", getGidRaCmUcAmt());
		this.hashColumns.put("ra_cm_uc_amt", getRaCmUcAmt());
		this.hashColumns.put("gid_diff", getGidDiff());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("sqm_act_flg", getSqmActFlg());
		this.hashColumns.put("initial_rpb", getInitialRpb());
		this.hashColumns.put("initial_cmpb_ra", getInitialCmpbRa());
		this.hashColumns.put("current_rpb", getCurrentRpb());
		this.hashColumns.put("current_cmpb_ra", getCurrentCmpbRa());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("src_dir_cd", "srcDirCd");
		this.hashFields.put("cm_diff", "cmDiff");
		this.hashFields.put("src_trd_cd", "srcTrdCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("ias_rgn_cd", "iasRgnCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bse_tp_cd", "bseTpCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("sel_flg", "selFlg");
		this.hashFields.put("src_rlane_cd", "srcRlaneCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pa_cm_uc_amt", "paCmUcAmt");
		this.hashFields.put("gid_pa_cm_uc_amt", "gidPaCmUcAmt");
		this.hashFields.put("cre_flg", "creFlg");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("act_flg_cnt", "actFlgCnt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("save_flg", "saveFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("gid_ra_cm_uc_amt", "gidRaCmUcAmt");
		this.hashFields.put("ra_cm_uc_amt", "raCmUcAmt");
		this.hashFields.put("gid_diff", "gidDiff");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("sqm_act_flg", "sqmActFlg");
		this.hashFields.put("initial_rpb", "initialRpb");
		this.hashFields.put("initial_cmpb_ra", "initialCmpbRa");
		this.hashFields.put("current_rpb", "currentRpb");
		this.hashFields.put("current_cmpb_ra", "currentCmpbRa");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return srcDirCd
	 */
	public String getSrcDirCd() {
		return this.srcDirCd;
	}
	
	/**
	 * Column Info
	 * @return cmDiff
	 */
	public String getCmDiff() {
		return this.cmDiff;
	}
	
	/**
	 * Column Info
	 * @return srcTrdCd
	 */
	public String getSrcTrdCd() {
		return this.srcTrdCd;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return selFlg
	 */
	public String getSelFlg() {
		return this.selFlg;
	}
	
	/**
	 * Column Info
	 * @return srcRlaneCd
	 */
	public String getSrcRlaneCd() {
		return this.srcRlaneCd;
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
	 * @return gidPaCmUcAmt
	 */
	public String getGidPaCmUcAmt() {
		return this.gidPaCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @return creFlg
	 */
	public String getCreFlg() {
		return this.creFlg;
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
	 * @return actFlgCnt
	 */
	public String getActFlgCnt() {
		return this.actFlgCnt;
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
	 * @return saveFlg
	 */
	public String getSaveFlg() {
		return this.saveFlg;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return gidRaCmUcAmt
	 */
	public String getGidRaCmUcAmt() {
		return this.gidRaCmUcAmt;
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
	 * @return gidDiff
	 */
	public String getGidDiff() {
		return this.gidDiff;
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
	 * @return sqmActFlg
	 */
	public String getSqmActFlg() {
		return this.sqmActFlg;
	}
	
	/**
	 * Column Info
	 * @return initialRpb
	 */
	public String getInitialRpb() {
		return this.initialRpb;
	}
	
	/**
	 * Column Info
	 * @return initialCmpbRa
	 */
	public String getInitialCmpbRa() {
		return this.initialCmpbRa;
	}
	
	/**
	 * Column Info
	 * @return currentRpb
	 */
	public String getCurrentRpb() {
		return this.currentRpb;
	}
	
	/**
	 * Column Info
	 * @return currentCmpbRa
	 */
	public String getCurrentCmpbRa() {
		return this.currentCmpbRa;
	}
	

	/**
	 * Column Info
	 * @param srcDirCd
	 */
	public void setSrcDirCd(String srcDirCd) {
		this.srcDirCd = srcDirCd;
	}
	
	/**
	 * Column Info
	 * @param cmDiff
	 */
	public void setCmDiff(String cmDiff) {
		this.cmDiff = cmDiff;
	}
	
	/**
	 * Column Info
	 * @param srcTrdCd
	 */
	public void setSrcTrdCd(String srcTrdCd) {
		this.srcTrdCd = srcTrdCd;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param selFlg
	 */
	public void setSelFlg(String selFlg) {
		this.selFlg = selFlg;
	}
	
	/**
	 * Column Info
	 * @param srcRlaneCd
	 */
	public void setSrcRlaneCd(String srcRlaneCd) {
		this.srcRlaneCd = srcRlaneCd;
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
	 * @param gidPaCmUcAmt
	 */
	public void setGidPaCmUcAmt(String gidPaCmUcAmt) {
		this.gidPaCmUcAmt = gidPaCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @param creFlg
	 */
	public void setCreFlg(String creFlg) {
		this.creFlg = creFlg;
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
	 * @param actFlgCnt
	 */
	public void setActFlgCnt(String actFlgCnt) {
		this.actFlgCnt = actFlgCnt;
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
	 * @param saveFlg
	 */
	public void setSaveFlg(String saveFlg) {
		this.saveFlg = saveFlg;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param gidRaCmUcAmt
	 */
	public void setGidRaCmUcAmt(String gidRaCmUcAmt) {
		this.gidRaCmUcAmt = gidRaCmUcAmt;
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
	 * @param gidDiff
	 */
	public void setGidDiff(String gidDiff) {
		this.gidDiff = gidDiff;
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
	 * @param subTrdCd
	 */
	public void setSqmActFlg(String sqmActFlg) {
		this.sqmActFlg = sqmActFlg;
	}
	
	/**
	 * Column Info
	 * @param initialRpb
	 */
	public void setInitialRpb(String initialRpb) {
		this.initialRpb = initialRpb;
	}
	
	/**
	 * Column Info
	 * @param initialRpb
	 */
	public void setInitialCmpbRa(String initialCmpbRa) {
		this.initialCmpbRa = initialCmpbRa;
	}
	
	/**
	 * Column Info
	 * @param currentRpb
	 */
	public void setCurrentRpb(String currentRpb) {
		this.currentRpb = currentRpb;
	}
	
	/**
	 * Column Info
	 * @param currentCmpbRa
	 */
	public void setCurrentCmpbRa(String currentCmpbRa) {
		this.currentCmpbRa = currentCmpbRa;
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
		setSrcDirCd(JSPUtil.getParameter(request, prefix + "src_dir_cd", ""));
		setCmDiff(JSPUtil.getParameter(request, prefix + "cm_diff", ""));
		setSrcTrdCd(JSPUtil.getParameter(request, prefix + "src_trd_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setIasRgnCd(JSPUtil.getParameter(request, prefix + "ias_rgn_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBseTpCd(JSPUtil.getParameter(request, prefix + "bse_tp_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setSelFlg(JSPUtil.getParameter(request, prefix + "sel_flg", ""));
		setSrcRlaneCd(JSPUtil.getParameter(request, prefix + "src_rlane_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPaCmUcAmt(JSPUtil.getParameter(request, prefix + "pa_cm_uc_amt", ""));
		setGidPaCmUcAmt(JSPUtil.getParameter(request, prefix + "gid_pa_cm_uc_amt", ""));
		setCreFlg(JSPUtil.getParameter(request, prefix + "cre_flg", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setActFlgCnt(JSPUtil.getParameter(request, prefix + "act_flg_cnt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setSaveFlg(JSPUtil.getParameter(request, prefix + "save_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setGidRaCmUcAmt(JSPUtil.getParameter(request, prefix + "gid_ra_cm_uc_amt", ""));
		setRaCmUcAmt(JSPUtil.getParameter(request, prefix + "ra_cm_uc_amt", ""));
		setGidDiff(JSPUtil.getParameter(request, prefix + "gid_diff", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setSqmActFlg(JSPUtil.getParameter(request, prefix + "sqm_act_flg", ""));
		setInitialRpb(JSPUtil.getParameter(request, prefix + "initial_rpb", ""));
		setInitialCmpbRa(JSPUtil.getParameter(request, prefix + "initial_cmpb_ra", ""));
		setCurrentRpb(JSPUtil.getParameter(request, prefix + "current_rpb", ""));
		setCurrentCmpbRa(JSPUtil.getParameter(request, prefix + "current_cmpb_ra", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchNewLaneSecCmcbListVO[]
	 */
	public SearchNewLaneSecCmcbListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchNewLaneSecCmcbListVO[]
	 */
	public SearchNewLaneSecCmcbListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchNewLaneSecCmcbListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] srcDirCd = (JSPUtil.getParameter(request, prefix	+ "src_dir_cd", length));
			String[] cmDiff = (JSPUtil.getParameter(request, prefix	+ "cm_diff", length));
			String[] srcTrdCd = (JSPUtil.getParameter(request, prefix	+ "src_trd_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] iasRgnCd = (JSPUtil.getParameter(request, prefix	+ "ias_rgn_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bseTpCd = (JSPUtil.getParameter(request, prefix	+ "bse_tp_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] selFlg = (JSPUtil.getParameter(request, prefix	+ "sel_flg", length));
			String[] srcRlaneCd = (JSPUtil.getParameter(request, prefix	+ "src_rlane_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] paCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "pa_cm_uc_amt", length));
			String[] gidPaCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "gid_pa_cm_uc_amt", length));
			String[] creFlg = (JSPUtil.getParameter(request, prefix	+ "cre_flg", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] actFlgCnt = (JSPUtil.getParameter(request, prefix	+ "act_flg_cnt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] saveFlg = (JSPUtil.getParameter(request, prefix	+ "save_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] gidRaCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "gid_ra_cm_uc_amt", length));
			String[] raCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "ra_cm_uc_amt", length));
			String[] gidDiff = (JSPUtil.getParameter(request, prefix	+ "gid_diff", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] sqmActFlg = (JSPUtil.getParameter(request, prefix	+ "sqm_act_flg", length));
			String[] initialRpb = (JSPUtil.getParameter(request, prefix	+ "initial_rpb", length));
			String[] initialCmpbRa = (JSPUtil.getParameter(request, prefix	+ "initial_cmpb_ra", length));
			String[] currentRpb = (JSPUtil.getParameter(request, prefix	+ "current_rpb", length));
			String[] currentCmpbRa = (JSPUtil.getParameter(request, prefix	+ "current_cmpb_ra", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchNewLaneSecCmcbListVO();
				if (srcDirCd[i] != null)
					model.setSrcDirCd(srcDirCd[i]);
				if (cmDiff[i] != null)
					model.setCmDiff(cmDiff[i]);
				if (srcTrdCd[i] != null)
					model.setSrcTrdCd(srcTrdCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (iasRgnCd[i] != null)
					model.setIasRgnCd(iasRgnCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bseTpCd[i] != null)
					model.setBseTpCd(bseTpCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (selFlg[i] != null)
					model.setSelFlg(selFlg[i]);
				if (srcRlaneCd[i] != null)
					model.setSrcRlaneCd(srcRlaneCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (paCmUcAmt[i] != null)
					model.setPaCmUcAmt(paCmUcAmt[i]);
				if (gidPaCmUcAmt[i] != null)
					model.setGidPaCmUcAmt(gidPaCmUcAmt[i]);
				if (creFlg[i] != null)
					model.setCreFlg(creFlg[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (actFlgCnt[i] != null)
					model.setActFlgCnt(actFlgCnt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (saveFlg[i] != null)
					model.setSaveFlg(saveFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (gidRaCmUcAmt[i] != null)
					model.setGidRaCmUcAmt(gidRaCmUcAmt[i]);
				if (raCmUcAmt[i] != null)
					model.setRaCmUcAmt(raCmUcAmt[i]);
				if (gidDiff[i] != null)
					model.setGidDiff(gidDiff[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (sqmActFlg[i] != null)
					model.setSqmActFlg(sqmActFlg[i]);
				if (initialRpb[i] != null)
					model.setInitialRpb(initialRpb[i]);
				if (initialCmpbRa[i] != null)
					model.setInitialCmpbRa(initialCmpbRa[i]);
				if (currentRpb[i] != null)
					model.setCurrentRpb(currentRpb[i]);
				if (currentCmpbRa[i] != null)
					model.setCurrentCmpbRa(currentCmpbRa[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchNewLaneSecCmcbListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchNewLaneSecCmcbListVO[]
	 */
	public SearchNewLaneSecCmcbListVO[] getSearchNewLaneSecCmcbListVOs(){
		SearchNewLaneSecCmcbListVO[] vos = (SearchNewLaneSecCmcbListVO[])models.toArray(new SearchNewLaneSecCmcbListVO[models.size()]);
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
		this.srcDirCd = this.srcDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmDiff = this.cmDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcTrdCd = this.srcTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iasRgnCd = this.iasRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseTpCd = this.bseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selFlg = this.selFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcRlaneCd = this.srcRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCmUcAmt = this.paCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gidPaCmUcAmt = this.gidPaCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creFlg = this.creFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFlgCnt = this.actFlgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveFlg = this.saveFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gidRaCmUcAmt = this.gidRaCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmUcAmt = this.raCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gidDiff = this.gidDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sqmActFlg = this.sqmActFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initialRpb = this.initialRpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initialCmpbRa = this.initialCmpbRa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currentRpb = this.currentRpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currentCmpbRa = this.currentCmpbRa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
