/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchVesselStatusListVO.java
*@FileTitle : SearchVesselStatusListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2010.03.16 양정란 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.insurance.vesselstatus.vo;

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
 * @author 양정란
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchVesselStatusListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchVesselStatusListVO> models = new ArrayList<SearchVesselStatusListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String dwtWgt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslRgstCntCd = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String insurRmk = null;
	/* Column Info */
	private String insurPlcyYr = null;
	/* Column Info */
	private String insurExpDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vslBldYr = null;
	/* Column Info */
	private String insurVslClssNm = null;
	/* Column Info */
	private String insurTpCd = null;
	/* Column Info */
	private String ddctCgoAmt = null;
	/* Column Info */
	private String ddctOtrAmt = null;
	/* Column Info */
	private String ddctCrwAmt = null;
	/* Column Info */
	private String grsRgstTongWgt = null;
	/* Column Info */
	private String ddctDmgHlAmt = null;
	/* Column Info */
	private String insurVslTpCd = null;
	/* Column Info */
	private String vslOshpExpDt = null;
	/* Column Info */
	private String vslOshpEffDt = null;
	/* Column Info */
	private String insurVslOshpCd = null;
	/* Column Info */
	private String insurEffDt = null;
	/* Column Info */
	private String insurCvrgCd = null;
	/* Column Info */
	private String insurClmPtyNo = null;
	/* Column Info */
	private String insurClmPtyNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchVesselStatusListVO() {}

	public SearchVesselStatusListVO(String ibflag, String pagerows, String vslCd, String vslEngNm, String insurClmPtyNo, String insurClmPtyNm, String insurEffDt, String insurExpDt, String insurVslTpCd, String vslBldYr, String vslRgstCntCd, String cntNm, String insurVslClssNm, String grsRgstTongWgt, String dwtWgt, String insurVslOshpCd, String vslOshpEffDt, String vslOshpExpDt, String insurCvrgCd, String insurTpCd, String insurPlcyYr, String ddctCgoAmt, String ddctCrwAmt, String ddctDmgHlAmt, String ddctOtrAmt, String insurRmk, String updUsrId, String updDt) {
		this.vslCd = vslCd;
		this.dwtWgt = dwtWgt;
		this.pagerows = pagerows;
		this.cntNm = cntNm;
		this.ibflag = ibflag;
		this.vslRgstCntCd = vslRgstCntCd;
		this.vslEngNm = vslEngNm;
		this.insurRmk = insurRmk;
		this.insurPlcyYr = insurPlcyYr;
		this.insurExpDt = insurExpDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.vslBldYr = vslBldYr;
		this.insurVslClssNm = insurVslClssNm;
		this.insurTpCd = insurTpCd;
		this.ddctCgoAmt = ddctCgoAmt;
		this.ddctOtrAmt = ddctOtrAmt;
		this.ddctCrwAmt = ddctCrwAmt;
		this.grsRgstTongWgt = grsRgstTongWgt;
		this.ddctDmgHlAmt = ddctDmgHlAmt;
		this.insurVslTpCd = insurVslTpCd;
		this.vslOshpExpDt = vslOshpExpDt;
		this.vslOshpEffDt = vslOshpEffDt;
		this.insurVslOshpCd = insurVslOshpCd;
		this.insurEffDt = insurEffDt;
		this.insurCvrgCd = insurCvrgCd;
		this.insurClmPtyNo = insurClmPtyNo;
		this.insurClmPtyNm = insurClmPtyNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("dwt_wgt", getDwtWgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_rgst_cnt_cd", getVslRgstCntCd());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("insur_rmk", getInsurRmk());
		this.hashColumns.put("insur_plcy_yr", getInsurPlcyYr());
		this.hashColumns.put("insur_exp_dt", getInsurExpDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vsl_bld_yr", getVslBldYr());
		this.hashColumns.put("insur_vsl_clss_nm", getInsurVslClssNm());
		this.hashColumns.put("insur_tp_cd", getInsurTpCd());
		this.hashColumns.put("ddct_cgo_amt", getDdctCgoAmt());
		this.hashColumns.put("ddct_otr_amt", getDdctOtrAmt());
		this.hashColumns.put("ddct_crw_amt", getDdctCrwAmt());
		this.hashColumns.put("grs_rgst_tong_wgt", getGrsRgstTongWgt());
		this.hashColumns.put("ddct_dmg_hl_amt", getDdctDmgHlAmt());
		this.hashColumns.put("insur_vsl_tp_cd", getInsurVslTpCd());
		this.hashColumns.put("vsl_oshp_exp_dt", getVslOshpExpDt());
		this.hashColumns.put("vsl_oshp_eff_dt", getVslOshpEffDt());
		this.hashColumns.put("insur_vsl_oshp_cd", getInsurVslOshpCd());
		this.hashColumns.put("insur_eff_dt", getInsurEffDt());
		this.hashColumns.put("insur_cvrg_cd", getInsurCvrgCd());
		this.hashColumns.put("insur_clm_pty_no", getInsurClmPtyNo());
		this.hashColumns.put("insur_clm_pty_nm", getInsurClmPtyNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("dwt_wgt", "dwtWgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_rgst_cnt_cd", "vslRgstCntCd");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("insur_rmk", "insurRmk");
		this.hashFields.put("insur_plcy_yr", "insurPlcyYr");
		this.hashFields.put("insur_exp_dt", "insurExpDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vsl_bld_yr", "vslBldYr");
		this.hashFields.put("insur_vsl_clss_nm", "insurVslClssNm");
		this.hashFields.put("insur_tp_cd", "insurTpCd");
		this.hashFields.put("ddct_cgo_amt", "ddctCgoAmt");
		this.hashFields.put("ddct_otr_amt", "ddctOtrAmt");
		this.hashFields.put("ddct_crw_amt", "ddctCrwAmt");
		this.hashFields.put("grs_rgst_tong_wgt", "grsRgstTongWgt");
		this.hashFields.put("ddct_dmg_hl_amt", "ddctDmgHlAmt");
		this.hashFields.put("insur_vsl_tp_cd", "insurVslTpCd");
		this.hashFields.put("vsl_oshp_exp_dt", "vslOshpExpDt");
		this.hashFields.put("vsl_oshp_eff_dt", "vslOshpEffDt");
		this.hashFields.put("insur_vsl_oshp_cd", "insurVslOshpCd");
		this.hashFields.put("insur_eff_dt", "insurEffDt");
		this.hashFields.put("insur_cvrg_cd", "insurCvrgCd");
		this.hashFields.put("insur_clm_pty_no", "insurClmPtyNo");
		this.hashFields.put("insur_clm_pty_nm", "insurClmPtyNm");
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
	 * @return dwtWgt
	 */
	public String getDwtWgt() {
		return this.dwtWgt;
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
	 * @return cntNm
	 */
	public String getCntNm() {
		return this.cntNm;
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
	 * @return vslRgstCntCd
	 */
	public String getVslRgstCntCd() {
		return this.vslRgstCntCd;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return insurRmk
	 */
	public String getInsurRmk() {
		return this.insurRmk;
	}
	
	/**
	 * Column Info
	 * @return insurPlcyYr
	 */
	public String getInsurPlcyYr() {
		return this.insurPlcyYr;
	}
	
	/**
	 * Column Info
	 * @return insurExpDt
	 */
	public String getInsurExpDt() {
		return this.insurExpDt;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return vslBldYr
	 */
	public String getVslBldYr() {
		return this.vslBldYr;
	}
	
	/**
	 * Column Info
	 * @return insurVslClssNm
	 */
	public String getInsurVslClssNm() {
		return this.insurVslClssNm;
	}
	
	/**
	 * Column Info
	 * @return insurTpCd
	 */
	public String getInsurTpCd() {
		return this.insurTpCd;
	}
	
	/**
	 * Column Info
	 * @return ddctCgoAmt
	 */
	public String getDdctCgoAmt() {
		return this.ddctCgoAmt;
	}
	
	/**
	 * Column Info
	 * @return ddctOtrAmt
	 */
	public String getDdctOtrAmt() {
		return this.ddctOtrAmt;
	}
	
	/**
	 * Column Info
	 * @return ddctCrwAmt
	 */
	public String getDdctCrwAmt() {
		return this.ddctCrwAmt;
	}
	
	/**
	 * Column Info
	 * @return grsRgstTongWgt
	 */
	public String getGrsRgstTongWgt() {
		return this.grsRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @return ddctDmgHlAmt
	 */
	public String getDdctDmgHlAmt() {
		return this.ddctDmgHlAmt;
	}
	
	/**
	 * Column Info
	 * @return insurVslTpCd
	 */
	public String getInsurVslTpCd() {
		return this.insurVslTpCd;
	}
	
	/**
	 * Column Info
	 * @return vslOshpExpDt
	 */
	public String getVslOshpExpDt() {
		return this.vslOshpExpDt;
	}
	
	/**
	 * Column Info
	 * @return vslOshpEffDt
	 */
	public String getVslOshpEffDt() {
		return this.vslOshpEffDt;
	}
	
	/**
	 * Column Info
	 * @return insurVslOshpCd
	 */
	public String getInsurVslOshpCd() {
		return this.insurVslOshpCd;
	}
	
	/**
	 * Column Info
	 * @return insurEffDt
	 */
	public String getInsurEffDt() {
		return this.insurEffDt;
	}
	
	/**
	 * Column Info
	 * @return insurCvrgCd
	 */
	public String getInsurCvrgCd() {
		return this.insurCvrgCd;
	}
	
	/**
	 * Column Info
	 * @return insurClmPtyNo
	 */
	public String getInsurClmPtyNo() {
		return this.insurClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return insurClmPtyNm
	 */
	public String getInsurClmPtyNm() {
		return this.insurClmPtyNm;
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
	 * @param dwtWgt
	 */
	public void setDwtWgt(String dwtWgt) {
		this.dwtWgt = dwtWgt;
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
	 * @param cntNm
	 */
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
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
	 * @param vslRgstCntCd
	 */
	public void setVslRgstCntCd(String vslRgstCntCd) {
		this.vslRgstCntCd = vslRgstCntCd;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param insurRmk
	 */
	public void setInsurRmk(String insurRmk) {
		this.insurRmk = insurRmk;
	}
	
	/**
	 * Column Info
	 * @param insurPlcyYr
	 */
	public void setInsurPlcyYr(String insurPlcyYr) {
		this.insurPlcyYr = insurPlcyYr;
	}
	
	/**
	 * Column Info
	 * @param insurExpDt
	 */
	public void setInsurExpDt(String insurExpDt) {
		this.insurExpDt = insurExpDt;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param vslBldYr
	 */
	public void setVslBldYr(String vslBldYr) {
		this.vslBldYr = vslBldYr;
	}
	
	/**
	 * Column Info
	 * @param insurVslClssNm
	 */
	public void setInsurVslClssNm(String insurVslClssNm) {
		this.insurVslClssNm = insurVslClssNm;
	}
	
	/**
	 * Column Info
	 * @param insurTpCd
	 */
	public void setInsurTpCd(String insurTpCd) {
		this.insurTpCd = insurTpCd;
	}
	
	/**
	 * Column Info
	 * @param ddctCgoAmt
	 */
	public void setDdctCgoAmt(String ddctCgoAmt) {
		this.ddctCgoAmt = ddctCgoAmt;
	}
	
	/**
	 * Column Info
	 * @param ddctOtrAmt
	 */
	public void setDdctOtrAmt(String ddctOtrAmt) {
		this.ddctOtrAmt = ddctOtrAmt;
	}
	
	/**
	 * Column Info
	 * @param ddctCrwAmt
	 */
	public void setDdctCrwAmt(String ddctCrwAmt) {
		this.ddctCrwAmt = ddctCrwAmt;
	}
	
	/**
	 * Column Info
	 * @param grsRgstTongWgt
	 */
	public void setGrsRgstTongWgt(String grsRgstTongWgt) {
		this.grsRgstTongWgt = grsRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @param ddctDmgHlAmt
	 */
	public void setDdctDmgHlAmt(String ddctDmgHlAmt) {
		this.ddctDmgHlAmt = ddctDmgHlAmt;
	}
	
	/**
	 * Column Info
	 * @param insurVslTpCd
	 */
	public void setInsurVslTpCd(String insurVslTpCd) {
		this.insurVslTpCd = insurVslTpCd;
	}
	
	/**
	 * Column Info
	 * @param vslOshpExpDt
	 */
	public void setVslOshpExpDt(String vslOshpExpDt) {
		this.vslOshpExpDt = vslOshpExpDt;
	}
	
	/**
	 * Column Info
	 * @param vslOshpEffDt
	 */
	public void setVslOshpEffDt(String vslOshpEffDt) {
		this.vslOshpEffDt = vslOshpEffDt;
	}
	
	/**
	 * Column Info
	 * @param insurVslOshpCd
	 */
	public void setInsurVslOshpCd(String insurVslOshpCd) {
		this.insurVslOshpCd = insurVslOshpCd;
	}
	
	/**
	 * Column Info
	 * @param insurEffDt
	 */
	public void setInsurEffDt(String insurEffDt) {
		this.insurEffDt = insurEffDt;
	}
	
	/**
	 * Column Info
	 * @param insurCvrgCd
	 */
	public void setInsurCvrgCd(String insurCvrgCd) {
		this.insurCvrgCd = insurCvrgCd;
	}
	
	/**
	 * Column Info
	 * @param insurClmPtyNo
	 */
	public void setInsurClmPtyNo(String insurClmPtyNo) {
		this.insurClmPtyNo = insurClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param insurClmPtyNm
	 */
	public void setInsurClmPtyNm(String insurClmPtyNm) {
		this.insurClmPtyNm = insurClmPtyNm;
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
		setDwtWgt(JSPUtil.getParameter(request, prefix + "dwt_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCntNm(JSPUtil.getParameter(request, prefix + "cnt_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslRgstCntCd(JSPUtil.getParameter(request, prefix + "vsl_rgst_cnt_cd", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setInsurRmk(JSPUtil.getParameter(request, prefix + "insur_rmk", ""));
		setInsurPlcyYr(JSPUtil.getParameter(request, prefix + "insur_plcy_yr", ""));
		setInsurExpDt(JSPUtil.getParameter(request, prefix + "insur_exp_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setVslBldYr(JSPUtil.getParameter(request, prefix + "vsl_bld_yr", ""));
		setInsurVslClssNm(JSPUtil.getParameter(request, prefix + "insur_vsl_clss_nm", ""));
		setInsurTpCd(JSPUtil.getParameter(request, prefix + "insur_tp_cd", ""));
		setDdctCgoAmt(JSPUtil.getParameter(request, prefix + "ddct_cgo_amt", ""));
		setDdctOtrAmt(JSPUtil.getParameter(request, prefix + "ddct_otr_amt", ""));
		setDdctCrwAmt(JSPUtil.getParameter(request, prefix + "ddct_crw_amt", ""));
		setGrsRgstTongWgt(JSPUtil.getParameter(request, prefix + "grs_rgst_tong_wgt", ""));
		setDdctDmgHlAmt(JSPUtil.getParameter(request, prefix + "ddct_dmg_hl_amt", ""));
		setInsurVslTpCd(JSPUtil.getParameter(request, prefix + "insur_vsl_tp_cd", ""));
		setVslOshpExpDt(JSPUtil.getParameter(request, prefix + "vsl_oshp_exp_dt", ""));
		setVslOshpEffDt(JSPUtil.getParameter(request, prefix + "vsl_oshp_eff_dt", ""));
		setInsurVslOshpCd(JSPUtil.getParameter(request, prefix + "insur_vsl_oshp_cd", ""));
		setInsurEffDt(JSPUtil.getParameter(request, prefix + "insur_eff_dt", ""));
		setInsurCvrgCd(JSPUtil.getParameter(request, prefix + "insur_cvrg_cd", ""));
		setInsurClmPtyNo(JSPUtil.getParameter(request, prefix + "insur_clm_pty_no", ""));
		setInsurClmPtyNm(JSPUtil.getParameter(request, prefix + "insur_clm_pty_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchVesselStatusListVO[]
	 */
	public SearchVesselStatusListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchVesselStatusListVO[]
	 */
	public SearchVesselStatusListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchVesselStatusListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] dwtWgt = (JSPUtil.getParameter(request, prefix	+ "dwt_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslRgstCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_cnt_cd", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] insurRmk = (JSPUtil.getParameter(request, prefix	+ "insur_rmk", length));
			String[] insurPlcyYr = (JSPUtil.getParameter(request, prefix	+ "insur_plcy_yr", length));
			String[] insurExpDt = (JSPUtil.getParameter(request, prefix	+ "insur_exp_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vslBldYr = (JSPUtil.getParameter(request, prefix	+ "vsl_bld_yr", length));
			String[] insurVslClssNm = (JSPUtil.getParameter(request, prefix	+ "insur_vsl_clss_nm", length));
			String[] insurTpCd = (JSPUtil.getParameter(request, prefix	+ "insur_tp_cd", length));
			String[] ddctCgoAmt = (JSPUtil.getParameter(request, prefix	+ "ddct_cgo_amt", length));
			String[] ddctOtrAmt = (JSPUtil.getParameter(request, prefix	+ "ddct_otr_amt", length));
			String[] ddctCrwAmt = (JSPUtil.getParameter(request, prefix	+ "ddct_crw_amt", length));
			String[] grsRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "grs_rgst_tong_wgt", length));
			String[] ddctDmgHlAmt = (JSPUtil.getParameter(request, prefix	+ "ddct_dmg_hl_amt", length));
			String[] insurVslTpCd = (JSPUtil.getParameter(request, prefix	+ "insur_vsl_tp_cd", length));
			String[] vslOshpExpDt = (JSPUtil.getParameter(request, prefix	+ "vsl_oshp_exp_dt", length));
			String[] vslOshpEffDt = (JSPUtil.getParameter(request, prefix	+ "vsl_oshp_eff_dt", length));
			String[] insurVslOshpCd = (JSPUtil.getParameter(request, prefix	+ "insur_vsl_oshp_cd", length));
			String[] insurEffDt = (JSPUtil.getParameter(request, prefix	+ "insur_eff_dt", length));
			String[] insurCvrgCd = (JSPUtil.getParameter(request, prefix	+ "insur_cvrg_cd", length));
			String[] insurClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "insur_clm_pty_no", length));
			String[] insurClmPtyNm = (JSPUtil.getParameter(request, prefix	+ "insur_clm_pty_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchVesselStatusListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (dwtWgt[i] != null)
					model.setDwtWgt(dwtWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslRgstCntCd[i] != null)
					model.setVslRgstCntCd(vslRgstCntCd[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (insurRmk[i] != null)
					model.setInsurRmk(insurRmk[i]);
				if (insurPlcyYr[i] != null)
					model.setInsurPlcyYr(insurPlcyYr[i]);
				if (insurExpDt[i] != null)
					model.setInsurExpDt(insurExpDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vslBldYr[i] != null)
					model.setVslBldYr(vslBldYr[i]);
				if (insurVslClssNm[i] != null)
					model.setInsurVslClssNm(insurVslClssNm[i]);
				if (insurTpCd[i] != null)
					model.setInsurTpCd(insurTpCd[i]);
				if (ddctCgoAmt[i] != null)
					model.setDdctCgoAmt(ddctCgoAmt[i]);
				if (ddctOtrAmt[i] != null)
					model.setDdctOtrAmt(ddctOtrAmt[i]);
				if (ddctCrwAmt[i] != null)
					model.setDdctCrwAmt(ddctCrwAmt[i]);
				if (grsRgstTongWgt[i] != null)
					model.setGrsRgstTongWgt(grsRgstTongWgt[i]);
				if (ddctDmgHlAmt[i] != null)
					model.setDdctDmgHlAmt(ddctDmgHlAmt[i]);
				if (insurVslTpCd[i] != null)
					model.setInsurVslTpCd(insurVslTpCd[i]);
				if (vslOshpExpDt[i] != null)
					model.setVslOshpExpDt(vslOshpExpDt[i]);
				if (vslOshpEffDt[i] != null)
					model.setVslOshpEffDt(vslOshpEffDt[i]);
				if (insurVslOshpCd[i] != null)
					model.setInsurVslOshpCd(insurVslOshpCd[i]);
				if (insurEffDt[i] != null)
					model.setInsurEffDt(insurEffDt[i]);
				if (insurCvrgCd[i] != null)
					model.setInsurCvrgCd(insurCvrgCd[i]);
				if (insurClmPtyNo[i] != null)
					model.setInsurClmPtyNo(insurClmPtyNo[i]);
				if (insurClmPtyNm[i] != null)
					model.setInsurClmPtyNm(insurClmPtyNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchVesselStatusListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchVesselStatusListVO[]
	 */
	public SearchVesselStatusListVO[] getSearchVesselStatusListVOs(){
		SearchVesselStatusListVO[] vos = (SearchVesselStatusListVO[])models.toArray(new SearchVesselStatusListVO[models.size()]);
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
		this.dwtWgt = this.dwtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRgstCntCd = this.vslRgstCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRmk = this.insurRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurPlcyYr = this.insurPlcyYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurExpDt = this.insurExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslBldYr = this.vslBldYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurVslClssNm = this.insurVslClssNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurTpCd = this.insurTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctCgoAmt = this.ddctCgoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctOtrAmt = this.ddctOtrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctCrwAmt = this.ddctCrwAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRgstTongWgt = this.grsRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctDmgHlAmt = this.ddctDmgHlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurVslTpCd = this.insurVslTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOshpExpDt = this.vslOshpExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOshpEffDt = this.vslOshpEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurVslOshpCd = this.insurVslOshpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurEffDt = this.insurEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurCvrgCd = this.insurCvrgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurClmPtyNo = this.insurClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurClmPtyNm = this.insurClmPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
