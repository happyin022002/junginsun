/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SdmsStepHistoryVO.java
*@FileTitle : SdmsStepHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.06.23 이선영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이선영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SdmsStepHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SdmsStepHistoryVO> models = new ArrayList<SdmsStepHistoryVO>();
	
	/* Column Info */
	private String cmpnStsCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String rprStsCd = null;
	/* Column Info */
	private String stvDmgStepHisSeq = null;
	/* Column Info */
	private String vslOshpCntrBlkTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Column Info */
	private String creTime = null;
	/* Column Info */
	private String stlStsCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String stvDmgRefNo = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String creUsrOfcCd = null;
	/* Column Info */
	private String clmHndlOfcCd = null;
	/* Column Info */
	private String stvDmgProcCd = null;
	/* Column Info */
	private String stvDmgEvntDt = null;
	/* Column Info */
	private String stvDmgNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SdmsStepHistoryVO() {}

	public SdmsStepHistoryVO(String ibflag, String pagerows, String stvDmgNo, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String slanCd, String stvDmgEvntDt, String vslOshpCntrBlkTpCd, String stvDmgRefNo, String clmHndlOfcCd, String stvDmgProcCd, String stvDmgStepHisSeq, String rprStsCd, String cmpnStsCd, String stlStsCd, String creUsrOfcCd, String creUsrNm, String creUsrId, String creDt, String creTime) {
		this.cmpnStsCd = cmpnStsCd;
		this.vslCd = vslCd;
		this.rprStsCd = rprStsCd;
		this.stvDmgStepHisSeq = stvDmgStepHisSeq;
		this.vslOshpCntrBlkTpCd = vslOshpCntrBlkTpCd;
		this.creDt = creDt;
		this.skdVoyNo = skdVoyNo;
		this.creUsrNm = creUsrNm;
		this.creTime = creTime;
		this.stlStsCd = stlStsCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.stvDmgRefNo = stvDmgRefNo;
		this.vpsPortCd = vpsPortCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.creUsrOfcCd = creUsrOfcCd;
		this.clmHndlOfcCd = clmHndlOfcCd;
		this.stvDmgProcCd = stvDmgProcCd;
		this.stvDmgEvntDt = stvDmgEvntDt;
		this.stvDmgNo = stvDmgNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cmpn_sts_cd", getCmpnStsCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("rpr_sts_cd", getRprStsCd());
		this.hashColumns.put("stv_dmg_step_his_seq", getStvDmgStepHisSeq());
		this.hashColumns.put("vsl_oshp_cntr_blk_tp_cd", getVslOshpCntrBlkTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("cre_time", getCreTime());
		this.hashColumns.put("stl_sts_cd", getStlStsCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("stv_dmg_ref_no", getStvDmgRefNo());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cre_usr_ofc_cd", getCreUsrOfcCd());
		this.hashColumns.put("clm_hndl_ofc_cd", getClmHndlOfcCd());
		this.hashColumns.put("stv_dmg_proc_cd", getStvDmgProcCd());
		this.hashColumns.put("stv_dmg_evnt_dt", getStvDmgEvntDt());
		this.hashColumns.put("stv_dmg_no", getStvDmgNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cmpn_sts_cd", "cmpnStsCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("rpr_sts_cd", "rprStsCd");
		this.hashFields.put("stv_dmg_step_his_seq", "stvDmgStepHisSeq");
		this.hashFields.put("vsl_oshp_cntr_blk_tp_cd", "vslOshpCntrBlkTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("cre_time", "creTime");
		this.hashFields.put("stl_sts_cd", "stlStsCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("stv_dmg_ref_no", "stvDmgRefNo");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cre_usr_ofc_cd", "creUsrOfcCd");
		this.hashFields.put("clm_hndl_ofc_cd", "clmHndlOfcCd");
		this.hashFields.put("stv_dmg_proc_cd", "stvDmgProcCd");
		this.hashFields.put("stv_dmg_evnt_dt", "stvDmgEvntDt");
		this.hashFields.put("stv_dmg_no", "stvDmgNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cmpnStsCd
	 */
	public String getCmpnStsCd() {
		return this.cmpnStsCd;
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
	 * @return rprStsCd
	 */
	public String getRprStsCd() {
		return this.rprStsCd;
	}
	
	/**
	 * Column Info
	 * @return stvDmgStepHisSeq
	 */
	public String getStvDmgStepHisSeq() {
		return this.stvDmgStepHisSeq;
	}
	
	/**
	 * Column Info
	 * @return vslOshpCntrBlkTpCd
	 */
	public String getVslOshpCntrBlkTpCd() {
		return this.vslOshpCntrBlkTpCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
	}
	
	/**
	 * Column Info
	 * @return creTime
	 */
	public String getCreTime() {
		return this.creTime;
	}
	
	/**
	 * Column Info
	 * @return stlStsCd
	 */
	public String getStlStsCd() {
		return this.stlStsCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return stvDmgRefNo
	 */
	public String getStvDmgRefNo() {
		return this.stvDmgRefNo;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrOfcCd
	 */
	public String getCreUsrOfcCd() {
		return this.creUsrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return clmHndlOfcCd
	 */
	public String getClmHndlOfcCd() {
		return this.clmHndlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return stvDmgProcCd
	 */
	public String getStvDmgProcCd() {
		return this.stvDmgProcCd;
	}
	
	/**
	 * Column Info
	 * @return stvDmgEvntDt
	 */
	public String getStvDmgEvntDt() {
		return this.stvDmgEvntDt;
	}
	
	/**
	 * Column Info
	 * @return stvDmgNo
	 */
	public String getStvDmgNo() {
		return this.stvDmgNo;
	}
	

	/**
	 * Column Info
	 * @param cmpnStsCd
	 */
	public void setCmpnStsCd(String cmpnStsCd) {
		this.cmpnStsCd = cmpnStsCd;
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
	 * @param rprStsCd
	 */
	public void setRprStsCd(String rprStsCd) {
		this.rprStsCd = rprStsCd;
	}
	
	/**
	 * Column Info
	 * @param stvDmgStepHisSeq
	 */
	public void setStvDmgStepHisSeq(String stvDmgStepHisSeq) {
		this.stvDmgStepHisSeq = stvDmgStepHisSeq;
	}
	
	/**
	 * Column Info
	 * @param vslOshpCntrBlkTpCd
	 */
	public void setVslOshpCntrBlkTpCd(String vslOshpCntrBlkTpCd) {
		this.vslOshpCntrBlkTpCd = vslOshpCntrBlkTpCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
	}
	
	/**
	 * Column Info
	 * @param creTime
	 */
	public void setCreTime(String creTime) {
		this.creTime = creTime;
	}
	
	/**
	 * Column Info
	 * @param stlStsCd
	 */
	public void setStlStsCd(String stlStsCd) {
		this.stlStsCd = stlStsCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param stvDmgRefNo
	 */
	public void setStvDmgRefNo(String stvDmgRefNo) {
		this.stvDmgRefNo = stvDmgRefNo;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrOfcCd
	 */
	public void setCreUsrOfcCd(String creUsrOfcCd) {
		this.creUsrOfcCd = creUsrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param clmHndlOfcCd
	 */
	public void setClmHndlOfcCd(String clmHndlOfcCd) {
		this.clmHndlOfcCd = clmHndlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param stvDmgProcCd
	 */
	public void setStvDmgProcCd(String stvDmgProcCd) {
		this.stvDmgProcCd = stvDmgProcCd;
	}
	
	/**
	 * Column Info
	 * @param stvDmgEvntDt
	 */
	public void setStvDmgEvntDt(String stvDmgEvntDt) {
		this.stvDmgEvntDt = stvDmgEvntDt;
	}
	
	/**
	 * Column Info
	 * @param stvDmgNo
	 */
	public void setStvDmgNo(String stvDmgNo) {
		this.stvDmgNo = stvDmgNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCmpnStsCd(JSPUtil.getParameter(request, "cmpn_sts_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setRprStsCd(JSPUtil.getParameter(request, "rpr_sts_cd", ""));
		setStvDmgStepHisSeq(JSPUtil.getParameter(request, "stv_dmg_step_his_seq", ""));
		setVslOshpCntrBlkTpCd(JSPUtil.getParameter(request, "vsl_oshp_cntr_blk_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setCreUsrNm(JSPUtil.getParameter(request, "cre_usr_nm", ""));
		setCreTime(JSPUtil.getParameter(request, "cre_time", ""));
		setStlStsCd(JSPUtil.getParameter(request, "stl_sts_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setStvDmgRefNo(JSPUtil.getParameter(request, "stv_dmg_ref_no", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setCreUsrOfcCd(JSPUtil.getParameter(request, "cre_usr_ofc_cd", ""));
		setClmHndlOfcCd(JSPUtil.getParameter(request, "clm_hndl_ofc_cd", ""));
		setStvDmgProcCd(JSPUtil.getParameter(request, "stv_dmg_proc_cd", ""));
		setStvDmgEvntDt(JSPUtil.getParameter(request, "stv_dmg_evnt_dt", ""));
		setStvDmgNo(JSPUtil.getParameter(request, "stv_dmg_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SdmsStepHistoryVO[]
	 */
	public SdmsStepHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SdmsStepHistoryVO[]
	 */
	public SdmsStepHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SdmsStepHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cmpnStsCd = (JSPUtil.getParameter(request, prefix	+ "cmpn_sts_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] rprStsCd = (JSPUtil.getParameter(request, prefix	+ "rpr_sts_cd", length));
			String[] stvDmgStepHisSeq = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_step_his_seq", length));
			String[] vslOshpCntrBlkTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_oshp_cntr_blk_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] creTime = (JSPUtil.getParameter(request, prefix	+ "cre_time", length));
			String[] stlStsCd = (JSPUtil.getParameter(request, prefix	+ "stl_sts_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] stvDmgRefNo = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_ref_no", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] creUsrOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_usr_ofc_cd", length));
			String[] clmHndlOfcCd = (JSPUtil.getParameter(request, prefix	+ "clm_hndl_ofc_cd", length));
			String[] stvDmgProcCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_proc_cd", length));
			String[] stvDmgEvntDt = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_evnt_dt", length));
			String[] stvDmgNo = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SdmsStepHistoryVO();
				if (cmpnStsCd[i] != null)
					model.setCmpnStsCd(cmpnStsCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (rprStsCd[i] != null)
					model.setRprStsCd(rprStsCd[i]);
				if (stvDmgStepHisSeq[i] != null)
					model.setStvDmgStepHisSeq(stvDmgStepHisSeq[i]);
				if (vslOshpCntrBlkTpCd[i] != null)
					model.setVslOshpCntrBlkTpCd(vslOshpCntrBlkTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (creTime[i] != null)
					model.setCreTime(creTime[i]);
				if (stlStsCd[i] != null)
					model.setStlStsCd(stlStsCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (stvDmgRefNo[i] != null)
					model.setStvDmgRefNo(stvDmgRefNo[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (creUsrOfcCd[i] != null)
					model.setCreUsrOfcCd(creUsrOfcCd[i]);
				if (clmHndlOfcCd[i] != null)
					model.setClmHndlOfcCd(clmHndlOfcCd[i]);
				if (stvDmgProcCd[i] != null)
					model.setStvDmgProcCd(stvDmgProcCd[i]);
				if (stvDmgEvntDt[i] != null)
					model.setStvDmgEvntDt(stvDmgEvntDt[i]);
				if (stvDmgNo[i] != null)
					model.setStvDmgNo(stvDmgNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSdmsStepHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SdmsStepHistoryVO[]
	 */
	public SdmsStepHistoryVO[] getSdmsStepHistoryVOs(){
		SdmsStepHistoryVO[] vos = (SdmsStepHistoryVO[])models.toArray(new SdmsStepHistoryVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.cmpnStsCd = this.cmpnStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprStsCd = this.rprStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgStepHisSeq = this.stvDmgStepHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOshpCntrBlkTpCd = this.vslOshpCntrBlkTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creTime = this.creTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlStsCd = this.stlStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgRefNo = this.stvDmgRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrOfcCd = this.creUsrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmHndlOfcCd = this.clmHndlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgProcCd = this.stvDmgProcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgEvntDt = this.stvDmgEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgNo = this.stvDmgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
