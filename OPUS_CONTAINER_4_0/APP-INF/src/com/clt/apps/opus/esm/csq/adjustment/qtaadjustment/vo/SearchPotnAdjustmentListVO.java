/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchPotnAdjustmentListVO.java
*@FileTitle : SearchPotnAdjustmentListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.19  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchPotnAdjustmentListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPotnAdjustmentListVO> models = new ArrayList<SearchPotnAdjustmentListVO>();
	
	/* Column Info */
	private String toVvdCd = null;
	/* Column Info */
	private String obDivCd = null;
	/* Column Info */
	private String ofcVwCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String orgFmYrwk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String convDirCd = null;
	/* Column Info */
	private String revPotnRto = null;
	/* Column Info */
	private String bseTpCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String aplyToYrwk = null;
	/* Column Info */
	private String lodPotnRto = null;
	/* Column Info */
	private String qtaRlseVerNo = null;
	/* Column Info */
	private String qtaStepCd = null;
	/* Column Info */
	private String fmVvdCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String aplyFmYrwk = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String csqCngTpCd = null;
	/* Column Info */
	private String gidRevPotnRto = null;
	/* Column Info */
	private String gidLodPotnRto = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String orgToYrwk = null;
	/* Column Info */
	private String grpNo = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchPotnAdjustmentListVO() {}

	public SearchPotnAdjustmentListVO(String ibflag, String pagerows, String obDivCd, String toVvdCd, String ofcVwCd, String trdCd, String rlaneCd, String bseQtrCd, String orgFmYrwk, String convDirCd, String revPotnRto, String bseTpCd, String dirCd, String rgnOfcCd, String updUsrId, String aplyToYrwk, String lodPotnRto, String qtaRlseVerNo, String qtaStepCd, String fmVvdCd, String rhqCd, String aplyFmYrwk, String bseYr, String gidLodPotnRto, String gidRevPotnRto, String creUsrId, String orgToYrwk, String grpNo, String subTrdCd, String vvdCd, String csqCngTpCd) {
		this.toVvdCd = toVvdCd;
		this.obDivCd = obDivCd;
		this.ofcVwCd = ofcVwCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.bseQtrCd = bseQtrCd;
		this.orgFmYrwk = orgFmYrwk;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.convDirCd = convDirCd;
		this.revPotnRto = revPotnRto;
		this.bseTpCd = bseTpCd;
		this.dirCd = dirCd;
		this.rgnOfcCd = rgnOfcCd;
		this.updUsrId = updUsrId;
		this.aplyToYrwk = aplyToYrwk;
		this.lodPotnRto = lodPotnRto;
		this.qtaRlseVerNo = qtaRlseVerNo;
		this.qtaStepCd = qtaStepCd;
		this.fmVvdCd = fmVvdCd;
		this.rhqCd = rhqCd;
		this.aplyFmYrwk = aplyFmYrwk;
		this.bseYr = bseYr;
		this.csqCngTpCd = csqCngTpCd;
		this.gidRevPotnRto = gidRevPotnRto;
		this.gidLodPotnRto = gidLodPotnRto;
		this.creUsrId = creUsrId;
		this.orgToYrwk = orgToYrwk;
		this.grpNo = grpNo;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_vvd_cd", getToVvdCd());
		this.hashColumns.put("ob_div_cd", getObDivCd());
		this.hashColumns.put("ofc_vw_cd", getOfcVwCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("org_fm_yrwk", getOrgFmYrwk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("conv_dir_cd", getConvDirCd());
		this.hashColumns.put("rev_potn_rto", getRevPotnRto());
		this.hashColumns.put("bse_tp_cd", getBseTpCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("aply_to_yrwk", getAplyToYrwk());
		this.hashColumns.put("lod_potn_rto", getLodPotnRto());
		this.hashColumns.put("qta_rlse_ver_no", getQtaRlseVerNo());
		this.hashColumns.put("qta_step_cd", getQtaStepCd());
		this.hashColumns.put("fm_vvd_cd", getFmVvdCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("aply_fm_yrwk", getAplyFmYrwk());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("csq_cng_tp_cd", getCsqCngTpCd());
		this.hashColumns.put("gid_rev_potn_rto", getGidRevPotnRto());
		this.hashColumns.put("gid_lod_potn_rto", getGidLodPotnRto());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("org_to_yrwk", getOrgToYrwk());
		this.hashColumns.put("grp_no", getGrpNo());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_vvd_cd", "toVvdCd");
		this.hashFields.put("ob_div_cd", "obDivCd");
		this.hashFields.put("ofc_vw_cd", "ofcVwCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("org_fm_yrwk", "orgFmYrwk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("conv_dir_cd", "convDirCd");
		this.hashFields.put("rev_potn_rto", "revPotnRto");
		this.hashFields.put("bse_tp_cd", "bseTpCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("aply_to_yrwk", "aplyToYrwk");
		this.hashFields.put("lod_potn_rto", "lodPotnRto");
		this.hashFields.put("qta_rlse_ver_no", "qtaRlseVerNo");
		this.hashFields.put("qta_step_cd", "qtaStepCd");
		this.hashFields.put("fm_vvd_cd", "fmVvdCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("aply_fm_yrwk", "aplyFmYrwk");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("csq_cng_tp_cd", "csqCngTpCd");
		this.hashFields.put("gid_rev_potn_rto", "gidRevPotnRto");
		this.hashFields.put("gid_lod_potn_rto", "gidLodPotnRto");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("org_to_yrwk", "orgToYrwk");
		this.hashFields.put("grp_no", "grpNo");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toVvdCd
	 */
	public String getToVvdCd() {
		return this.toVvdCd;
	}
	
	/**
	 * Column Info
	 * @return obDivCd
	 */
	public String getObDivCd() {
		return this.obDivCd;
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
	 * @return orgFmYrwk
	 */
	public String getOrgFmYrwk() {
		return this.orgFmYrwk;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return revPotnRto
	 */
	public String getRevPotnRto() {
		return this.revPotnRto;
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
	 * @return aplyToYrwk
	 */
	public String getAplyToYrwk() {
		return this.aplyToYrwk;
	}
	
	/**
	 * Column Info
	 * @return lodPotnRto
	 */
	public String getLodPotnRto() {
		return this.lodPotnRto;
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
	 * @return qtaStepCd
	 */
	public String getQtaStepCd() {
		return this.qtaStepCd;
	}
	
	/**
	 * Column Info
	 * @return fmVvdCd
	 */
	public String getFmVvdCd() {
		return this.fmVvdCd;
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
	 * @return aplyFmYrwk
	 */
	public String getAplyFmYrwk() {
		return this.aplyFmYrwk;
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
	 * @return csqCngTpCd
	 */
	public String getCsqCngTpCd() {
		return this.csqCngTpCd;
	}
	
	/**
	 * Column Info
	 * @return gidRevPotnRto
	 */
	public String getGidRevPotnRto() {
		return this.gidRevPotnRto;
	}
	
	/**
	 * Column Info
	 * @return gidLodPotnRto
	 */
	public String getGidLodPotnRto() {
		return this.gidLodPotnRto;
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
	 * @return orgToYrwk
	 */
	public String getOrgToYrwk() {
		return this.orgToYrwk;
	}
	
	/**
	 * Column Info
	 * @return grpNo
	 */
	public String getGrpNo() {
		return this.grpNo;
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
	 * @param toVvdCd
	 */
	public void setToVvdCd(String toVvdCd) {
		this.toVvdCd = toVvdCd;
	}
	
	/**
	 * Column Info
	 * @param obDivCd
	 */
	public void setObDivCd(String obDivCd) {
		this.obDivCd = obDivCd;
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
	 * @param orgFmYrwk
	 */
	public void setOrgFmYrwk(String orgFmYrwk) {
		this.orgFmYrwk = orgFmYrwk;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
	 * @param revPotnRto
	 */
	public void setRevPotnRto(String revPotnRto) {
		this.revPotnRto = revPotnRto;
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
	 * @param aplyToYrwk
	 */
	public void setAplyToYrwk(String aplyToYrwk) {
		this.aplyToYrwk = aplyToYrwk;
	}
	
	/**
	 * Column Info
	 * @param lodPotnRto
	 */
	public void setLodPotnRto(String lodPotnRto) {
		this.lodPotnRto = lodPotnRto;
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
	 * @param qtaStepCd
	 */
	public void setQtaStepCd(String qtaStepCd) {
		this.qtaStepCd = qtaStepCd;
	}
	
	/**
	 * Column Info
	 * @param fmVvdCd
	 */
	public void setFmVvdCd(String fmVvdCd) {
		this.fmVvdCd = fmVvdCd;
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
	 * @param aplyFmYrwk
	 */
	public void setAplyFmYrwk(String aplyFmYrwk) {
		this.aplyFmYrwk = aplyFmYrwk;
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
	 * @param csqCngTpCd
	 */
	public void setCsqCngTpCd(String csqCngTpCd) {
		this.csqCngTpCd = csqCngTpCd;
	}
	
	/**
	 * Column Info
	 * @param gidRevPotnRto
	 */
	public void setGidRevPotnRto(String gidRevPotnRto) {
		this.gidRevPotnRto = gidRevPotnRto;
	}
	
	/**
	 * Column Info
	 * @param gidLodPotnRto
	 */
	public void setGidLodPotnRto(String gidLodPotnRto) {
		this.gidLodPotnRto = gidLodPotnRto;
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
	 * @param orgToYrwk
	 */
	public void setOrgToYrwk(String orgToYrwk) {
		this.orgToYrwk = orgToYrwk;
	}
	
	/**
	 * Column Info
	 * @param grpNo
	 */
	public void setGrpNo(String grpNo) {
		this.grpNo = grpNo;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
		setToVvdCd(JSPUtil.getParameter(request, prefix + "to_vvd_cd", ""));
		setObDivCd(JSPUtil.getParameter(request, prefix + "ob_div_cd", ""));
		setOfcVwCd(JSPUtil.getParameter(request, prefix + "ofc_vw_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setOrgFmYrwk(JSPUtil.getParameter(request, prefix + "org_fm_yrwk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setConvDirCd(JSPUtil.getParameter(request, prefix + "conv_dir_cd", ""));
		setRevPotnRto(JSPUtil.getParameter(request, prefix + "rev_potn_rto", ""));
		setBseTpCd(JSPUtil.getParameter(request, prefix + "bse_tp_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setAplyToYrwk(JSPUtil.getParameter(request, prefix + "aply_to_yrwk", ""));
		setLodPotnRto(JSPUtil.getParameter(request, prefix + "lod_potn_rto", ""));
		setQtaRlseVerNo(JSPUtil.getParameter(request, prefix + "qta_rlse_ver_no", ""));
		setQtaStepCd(JSPUtil.getParameter(request, prefix + "qta_step_cd", ""));
		setFmVvdCd(JSPUtil.getParameter(request, prefix + "fm_vvd_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setAplyFmYrwk(JSPUtil.getParameter(request, prefix + "aply_fm_yrwk", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setCsqCngTpCd(JSPUtil.getParameter(request, prefix + "csq_cng_tp_cd", ""));
		setGidRevPotnRto(JSPUtil.getParameter(request, prefix + "gid_rev_potn_rto", ""));
		setGidLodPotnRto(JSPUtil.getParameter(request, prefix + "gid_lod_potn_rto", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setOrgToYrwk(JSPUtil.getParameter(request, prefix + "org_to_yrwk", ""));
		setGrpNo(JSPUtil.getParameter(request, prefix + "grp_no", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPotnAdjustmentListVO[]
	 */
	public SearchPotnAdjustmentListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPotnAdjustmentListVO[]
	 */
	public SearchPotnAdjustmentListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPotnAdjustmentListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toVvdCd = (JSPUtil.getParameter(request, prefix	+ "to_vvd_cd", length));
			String[] obDivCd = (JSPUtil.getParameter(request, prefix	+ "ob_div_cd", length));
			String[] ofcVwCd = (JSPUtil.getParameter(request, prefix	+ "ofc_vw_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] orgFmYrwk = (JSPUtil.getParameter(request, prefix	+ "org_fm_yrwk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] convDirCd = (JSPUtil.getParameter(request, prefix	+ "conv_dir_cd", length));
			String[] revPotnRto = (JSPUtil.getParameter(request, prefix	+ "rev_potn_rto", length));
			String[] bseTpCd = (JSPUtil.getParameter(request, prefix	+ "bse_tp_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] aplyToYrwk = (JSPUtil.getParameter(request, prefix	+ "aply_to_yrwk", length));
			String[] lodPotnRto = (JSPUtil.getParameter(request, prefix	+ "lod_potn_rto", length));
			String[] qtaRlseVerNo = (JSPUtil.getParameter(request, prefix	+ "qta_rlse_ver_no", length));
			String[] qtaStepCd = (JSPUtil.getParameter(request, prefix	+ "qta_step_cd", length));
			String[] fmVvdCd = (JSPUtil.getParameter(request, prefix	+ "fm_vvd_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] aplyFmYrwk = (JSPUtil.getParameter(request, prefix	+ "aply_fm_yrwk", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] csqCngTpCd = (JSPUtil.getParameter(request, prefix	+ "csq_cng_tp_cd", length));
			String[] gidRevPotnRto = (JSPUtil.getParameter(request, prefix	+ "gid_rev_potn_rto", length));
			String[] gidLodPotnRto = (JSPUtil.getParameter(request, prefix	+ "gid_lod_potn_rto", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] orgToYrwk = (JSPUtil.getParameter(request, prefix	+ "org_to_yrwk", length));
			String[] grpNo = (JSPUtil.getParameter(request, prefix	+ "grp_no", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPotnAdjustmentListVO();
				if (toVvdCd[i] != null)
					model.setToVvdCd(toVvdCd[i]);
				if (obDivCd[i] != null)
					model.setObDivCd(obDivCd[i]);
				if (ofcVwCd[i] != null)
					model.setOfcVwCd(ofcVwCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (orgFmYrwk[i] != null)
					model.setOrgFmYrwk(orgFmYrwk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (convDirCd[i] != null)
					model.setConvDirCd(convDirCd[i]);
				if (revPotnRto[i] != null)
					model.setRevPotnRto(revPotnRto[i]);
				if (bseTpCd[i] != null)
					model.setBseTpCd(bseTpCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (aplyToYrwk[i] != null)
					model.setAplyToYrwk(aplyToYrwk[i]);
				if (lodPotnRto[i] != null)
					model.setLodPotnRto(lodPotnRto[i]);
				if (qtaRlseVerNo[i] != null)
					model.setQtaRlseVerNo(qtaRlseVerNo[i]);
				if (qtaStepCd[i] != null)
					model.setQtaStepCd(qtaStepCd[i]);
				if (fmVvdCd[i] != null)
					model.setFmVvdCd(fmVvdCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (aplyFmYrwk[i] != null)
					model.setAplyFmYrwk(aplyFmYrwk[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (csqCngTpCd[i] != null)
					model.setCsqCngTpCd(csqCngTpCd[i]);
				if (gidRevPotnRto[i] != null)
					model.setGidRevPotnRto(gidRevPotnRto[i]);
				if (gidLodPotnRto[i] != null)
					model.setGidLodPotnRto(gidLodPotnRto[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (orgToYrwk[i] != null)
					model.setOrgToYrwk(orgToYrwk[i]);
				if (grpNo[i] != null)
					model.setGrpNo(grpNo[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPotnAdjustmentListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPotnAdjustmentListVO[]
	 */
	public SearchPotnAdjustmentListVO[] getSearchPotnAdjustmentListVOs(){
		SearchPotnAdjustmentListVO[] vos = (SearchPotnAdjustmentListVO[])models.toArray(new SearchPotnAdjustmentListVO[models.size()]);
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
		this.toVvdCd = this.toVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obDivCd = this.obDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcVwCd = this.ofcVwCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgFmYrwk = this.orgFmYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDirCd = this.convDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revPotnRto = this.revPotnRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseTpCd = this.bseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyToYrwk = this.aplyToYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodPotnRto = this.lodPotnRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaRlseVerNo = this.qtaRlseVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaStepCd = this.qtaStepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmVvdCd = this.fmVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyFmYrwk = this.aplyFmYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csqCngTpCd = this.csqCngTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gidRevPotnRto = this.gidRevPotnRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gidLodPotnRto = this.gidLodPotnRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgToYrwk = this.orgToYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpNo = this.grpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
