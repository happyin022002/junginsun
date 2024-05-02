/*=========================================================
*Copyright(c) 2016 CyberLogitec 
*@FileName : UsaCstmsManifestAmendmentVO.java
*@FileTitle : UsaCstmsManifestAmendmentVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.30  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentVO
 */

public class UsaCstmsManifestAmendmentVO extends com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaCstmsManifestAmendmentVO> models = new ArrayList<UsaCstmsManifestAmendmentVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String cstmsFileTpCd = null;
	/* Column Info */
	private String aiType = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String bdrRnum = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mfStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String bkgPodCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String mh = null;
	/* Column Info */
	private String bVvdCd = null;
	/* Column Info */
	private String cstmsPortCd = null;
	/* Column Info */
	private String aiFlag = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String bMi = null;
	/* Column Info */
	private String error = null;
	/* Column Info */
	private String cstmsTrsmStsCd = null;
	/* Column Info */
	private String vMi = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String actionCode = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String miSndDt = null;
	/* Column Info */
	private String ibdLocGdsDesc = null;
	/* Column Info */
	private String tVvdCd = null;
	/* Column Info */
	private String caNo = null;
	/* Column Info */
	private String mblNo = null;
	/* Column Info */
	private String actionDesc = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String hubLocCd = null;
	/* Column Info */
	private String cstmsFileCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UsaCstmsManifestAmendmentVO() {}

	public UsaCstmsManifestAmendmentVO(String ibflag, String pagerows, String actionCode, String actionDesc, String aiFlag, String aiType, String bdrFlg, String bdrRnum, String bkgNo, String bkgPodCd, String bkgPolCd, String bkgStsCd, String blNo, String bMi, String bVvdCd, String caNo, String cstmsFileCd, String cstmsFileTpCd, String cstmsPortCd, String cstmsTrsmStsCd, String error, String fullMtyCd, String hubLocCd, String ibdLocGdsDesc, String mblNo, String mfStsCd, String mh, String miSndDt, String podCd, String polCd, String rnum, String total, String tVvdCd, String vMi) {
		this.total = total;
		this.cstmsFileTpCd = cstmsFileTpCd;
		this.aiType = aiType;
		this.bkgStsCd = bkgStsCd;
		this.bdrFlg = bdrFlg;
		this.bdrRnum = bdrRnum;
		this.blNo = blNo;
		this.mfStsCd = mfStsCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.bkgPodCd = bkgPodCd;
		this.ibflag = ibflag;
		this.rnum = rnum;
		this.mh = mh;
		this.bVvdCd = bVvdCd;
		this.cstmsPortCd = cstmsPortCd;
		this.aiFlag = aiFlag;
		this.bkgPolCd = bkgPolCd;
		this.bMi = bMi;
		this.error = error;
		this.cstmsTrsmStsCd = cstmsTrsmStsCd;
		this.vMi = vMi;
		this.podCd = podCd;
		this.actionCode = actionCode;
		this.bkgNo = bkgNo;
		this.miSndDt = miSndDt;
		this.ibdLocGdsDesc = ibdLocGdsDesc;
		this.tVvdCd = tVvdCd;
		this.caNo = caNo;
		this.mblNo = mblNo;
		this.actionDesc = actionDesc;
		this.fullMtyCd = fullMtyCd;
		this.hubLocCd = hubLocCd;
		this.cstmsFileCd = cstmsFileCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("cstms_file_tp_cd", getCstmsFileTpCd());
		this.hashColumns.put("ai_type", getAiType());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("bdr_rnum", getBdrRnum());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mf_sts_cd", getMfStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("mh", getMh());
		this.hashColumns.put("b_vvd_cd", getBVvdCd());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("ai_flag", getAiFlag());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("b_mi", getBMi());
		this.hashColumns.put("error", getError());
		this.hashColumns.put("cstms_trsm_sts_cd", getCstmsTrsmStsCd());
		this.hashColumns.put("v_mi", getVMi());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("action_code", getActionCode());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("mi_snd_dt", getMiSndDt());
		this.hashColumns.put("ibd_loc_gds_desc", getIbdLocGdsDesc());
		this.hashColumns.put("t_vvd_cd", getTVvdCd());
		this.hashColumns.put("ca_no", getCaNo());
		this.hashColumns.put("mbl_no", getMblNo());
		this.hashColumns.put("action_desc", getActionDesc());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		this.hashColumns.put("cstms_file_cd", getCstmsFileCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("cstms_file_tp_cd", "cstmsFileTpCd");
		this.hashFields.put("ai_type", "aiType");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("bdr_rnum", "bdrRnum");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mf_sts_cd", "mfStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("mh", "mh");
		this.hashFields.put("b_vvd_cd", "bVvdCd");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		this.hashFields.put("ai_flag", "aiFlag");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("b_mi", "bMi");
		this.hashFields.put("error", "error");
		this.hashFields.put("cstms_trsm_sts_cd", "cstmsTrsmStsCd");
		this.hashFields.put("v_mi", "vMi");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("action_code", "actionCode");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("mi_snd_dt", "miSndDt");
		this.hashFields.put("ibd_loc_gds_desc", "ibdLocGdsDesc");
		this.hashFields.put("t_vvd_cd", "tVvdCd");
		this.hashFields.put("ca_no", "caNo");
		this.hashFields.put("mbl_no", "mblNo");
		this.hashFields.put("action_desc", "actionDesc");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		this.hashFields.put("cstms_file_cd", "cstmsFileCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Column Info
	 * @return cstmsFileTpCd
	 */
	public String getCstmsFileTpCd() {
		return this.cstmsFileTpCd;
	}
	
	/**
	 * Column Info
	 * @return aiType
	 */
	public String getAiType() {
		return this.aiType;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return bdrRnum
	 */
	public String getBdrRnum() {
		return this.bdrRnum;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return mfStsCd
	 */
	public String getMfStsCd() {
		return this.mfStsCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPodCd
	 */
	public String getBkgPodCd() {
		return this.bkgPodCd;
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
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
	}
	
	/**
	 * Column Info
	 * @return mh
	 */
	public String getMh() {
		return this.mh;
	}
	
	/**
	 * Column Info
	 * @return bVvdCd
	 */
	public String getBVvdCd() {
		return this.bVvdCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsPortCd
	 */
	public String getCstmsPortCd() {
		return this.cstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @return aiFlag
	 */
	public String getAiFlag() {
		return this.aiFlag;
	}
	
	/**
	 * Column Info
	 * @return bkgPolCd
	 */
	public String getBkgPolCd() {
		return this.bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @return bMi
	 */
	public String getBMi() {
		return this.bMi;
	}
	
	/**
	 * Column Info
	 * @return error
	 */
	public String getError() {
		return this.error;
	}
	
	/**
	 * Column Info
	 * @return cstmsTrsmStsCd
	 */
	public String getCstmsTrsmStsCd() {
		return this.cstmsTrsmStsCd;
	}
	
	/**
	 * Column Info
	 * @return vMi
	 */
	public String getVMi() {
		return this.vMi;
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
	 * @return actionCode
	 */
	public String getActionCode() {
		return this.actionCode;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return miSndDt
	 */
	public String getMiSndDt() {
		return this.miSndDt;
	}
	
	/**
	 * Column Info
	 * @return ibdLocGdsDesc
	 */
	public String getIbdLocGdsDesc() {
		return this.ibdLocGdsDesc;
	}
	
	/**
	 * Column Info
	 * @return tVvdCd
	 */
	public String getTVvdCd() {
		return this.tVvdCd;
	}
	
	/**
	 * Column Info
	 * @return caNo
	 */
	public String getCaNo() {
		return this.caNo;
	}
	
	/**
	 * Column Info
	 * @return mblNo
	 */
	public String getMblNo() {
		return this.mblNo;
	}
	
	/**
	 * Column Info
	 * @return actionDesc
	 */
	public String getActionDesc() {
		return this.actionDesc;
	}
	
	/**
	 * Column Info
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @return hubLocCd
	 */
	public String getHubLocCd() {
		return this.hubLocCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsFileCd
	 */
	public String getCstmsFileCd() {
		return this.cstmsFileCd;
	}
	

	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param cstmsFileTpCd
	 */
	public void setCstmsFileTpCd(String cstmsFileTpCd) {
		this.cstmsFileTpCd = cstmsFileTpCd;
	}
	
	/**
	 * Column Info
	 * @param aiType
	 */
	public void setAiType(String aiType) {
		this.aiType = aiType;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param bdrRnum
	 */
	public void setBdrRnum(String bdrRnum) {
		this.bdrRnum = bdrRnum;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param mfStsCd
	 */
	public void setMfStsCd(String mfStsCd) {
		this.mfStsCd = mfStsCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPodCd
	 */
	public void setBkgPodCd(String bkgPodCd) {
		this.bkgPodCd = bkgPodCd;
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
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	/**
	 * Column Info
	 * @param mh
	 */
	public void setMh(String mh) {
		this.mh = mh;
	}
	
	/**
	 * Column Info
	 * @param bVvdCd
	 */
	public void setBVvdCd(String bVvdCd) {
		this.bVvdCd = bVvdCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsPortCd
	 */
	public void setCstmsPortCd(String cstmsPortCd) {
		this.cstmsPortCd = cstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @param aiFlag
	 */
	public void setAiFlag(String aiFlag) {
		this.aiFlag = aiFlag;
	}
	
	/**
	 * Column Info
	 * @param bkgPolCd
	 */
	public void setBkgPolCd(String bkgPolCd) {
		this.bkgPolCd = bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @param bMi
	 */
	public void setBMi(String bMi) {
		this.bMi = bMi;
	}
	
	/**
	 * Column Info
	 * @param error
	 */
	public void setError(String error) {
		this.error = error;
	}
	
	/**
	 * Column Info
	 * @param cstmsTrsmStsCd
	 */
	public void setCstmsTrsmStsCd(String cstmsTrsmStsCd) {
		this.cstmsTrsmStsCd = cstmsTrsmStsCd;
	}
	
	/**
	 * Column Info
	 * @param vMi
	 */
	public void setVMi(String vMi) {
		this.vMi = vMi;
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
	 * @param actionCode
	 */
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param miSndDt
	 */
	public void setMiSndDt(String miSndDt) {
		this.miSndDt = miSndDt;
	}
	
	/**
	 * Column Info
	 * @param ibdLocGdsDesc
	 */
	public void setIbdLocGdsDesc(String ibdLocGdsDesc) {
		this.ibdLocGdsDesc = ibdLocGdsDesc;
	}
	
	/**
	 * Column Info
	 * @param tVvdCd
	 */
	public void setTVvdCd(String tVvdCd) {
		this.tVvdCd = tVvdCd;
	}
	
	/**
	 * Column Info
	 * @param caNo
	 */
	public void setCaNo(String caNo) {
		this.caNo = caNo;
	}
	
	/**
	 * Column Info
	 * @param mblNo
	 */
	public void setMblNo(String mblNo) {
		this.mblNo = mblNo;
	}
	
	/**
	 * Column Info
	 * @param actionDesc
	 */
	public void setActionDesc(String actionDesc) {
		this.actionDesc = actionDesc;
	}
	
	/**
	 * Column Info
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsFileCd
	 */
	public void setCstmsFileCd(String cstmsFileCd) {
		this.cstmsFileCd = cstmsFileCd;
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
		setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
		setCstmsFileTpCd(JSPUtil.getParameter(request, prefix + "cstms_file_tp_cd", ""));
		setAiType(JSPUtil.getParameter(request, prefix + "ai_type", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setBdrRnum(JSPUtil.getParameter(request, prefix + "bdr_rnum", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setMfStsCd(JSPUtil.getParameter(request, prefix + "mf_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setBkgPodCd(JSPUtil.getParameter(request, prefix + "bkg_pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
		setMh(JSPUtil.getParameter(request, prefix + "mh", ""));
		setBVvdCd(JSPUtil.getParameter(request, prefix + "b_vvd_cd", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
		setAiFlag(JSPUtil.getParameter(request, prefix + "ai_flag", ""));
		setBkgPolCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cd", ""));
		setBMi(JSPUtil.getParameter(request, prefix + "b_mi", ""));
		setError(JSPUtil.getParameter(request, prefix + "error", ""));
		setCstmsTrsmStsCd(JSPUtil.getParameter(request, prefix + "cstms_trsm_sts_cd", ""));
		setVMi(JSPUtil.getParameter(request, prefix + "v_mi", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setActionCode(JSPUtil.getParameter(request, prefix + "action_code", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setMiSndDt(JSPUtil.getParameter(request, prefix + "mi_snd_dt", ""));
		setIbdLocGdsDesc(JSPUtil.getParameter(request, prefix + "ibd_loc_gds_desc", ""));
		setTVvdCd(JSPUtil.getParameter(request, prefix + "t_vvd_cd", ""));
		setCaNo(JSPUtil.getParameter(request, prefix + "ca_no", ""));
		setMblNo(JSPUtil.getParameter(request, prefix + "mbl_no", ""));
		setActionDesc(JSPUtil.getParameter(request, prefix + "action_desc", ""));
		setFullMtyCd(JSPUtil.getParameter(request, prefix + "full_mty_cd", ""));
		setHubLocCd(JSPUtil.getParameter(request, prefix + "hub_loc_cd", ""));
		setCstmsFileCd(JSPUtil.getParameter(request, prefix + "cstms_file_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaCstmsManifestAmendmentVO[]
	 */
	public UsaCstmsManifestAmendmentVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaCstmsManifestAmendmentVO[]
	 */
	public UsaCstmsManifestAmendmentVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaCstmsManifestAmendmentVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] cstmsFileTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_file_tp_cd", length));
			String[] aiType = (JSPUtil.getParameter(request, prefix	+ "ai_type", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] bdrRnum = (JSPUtil.getParameter(request, prefix	+ "bdr_rnum", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] mfStsCd = (JSPUtil.getParameter(request, prefix	+ "mf_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] bkgPodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] mh = (JSPUtil.getParameter(request, prefix	+ "mh", length));
			String[] bVvdCd = (JSPUtil.getParameter(request, prefix	+ "b_vvd_cd", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			String[] aiFlag = (JSPUtil.getParameter(request, prefix	+ "ai_flag", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] bMi = (JSPUtil.getParameter(request, prefix	+ "b_mi", length));
			String[] error = (JSPUtil.getParameter(request, prefix	+ "error", length));
			String[] cstmsTrsmStsCd = (JSPUtil.getParameter(request, prefix	+ "cstms_trsm_sts_cd", length));
			String[] vMi = (JSPUtil.getParameter(request, prefix	+ "v_mi", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] actionCode = (JSPUtil.getParameter(request, prefix	+ "action_code", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] miSndDt = (JSPUtil.getParameter(request, prefix	+ "mi_snd_dt", length));
			String[] ibdLocGdsDesc = (JSPUtil.getParameter(request, prefix	+ "ibd_loc_gds_desc", length));
			String[] tVvdCd = (JSPUtil.getParameter(request, prefix	+ "t_vvd_cd", length));
			String[] caNo = (JSPUtil.getParameter(request, prefix	+ "ca_no", length));
			String[] mblNo = (JSPUtil.getParameter(request, prefix	+ "mbl_no", length));
			String[] actionDesc = (JSPUtil.getParameter(request, prefix	+ "action_desc", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			String[] cstmsFileCd = (JSPUtil.getParameter(request, prefix	+ "cstms_file_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaCstmsManifestAmendmentVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (cstmsFileTpCd[i] != null)
					model.setCstmsFileTpCd(cstmsFileTpCd[i]);
				if (aiType[i] != null)
					model.setAiType(aiType[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (bdrRnum[i] != null)
					model.setBdrRnum(bdrRnum[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mfStsCd[i] != null)
					model.setMfStsCd(mfStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (bkgPodCd[i] != null)
					model.setBkgPodCd(bkgPodCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (mh[i] != null)
					model.setMh(mh[i]);
				if (bVvdCd[i] != null)
					model.setBVvdCd(bVvdCd[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (aiFlag[i] != null)
					model.setAiFlag(aiFlag[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (bMi[i] != null)
					model.setBMi(bMi[i]);
				if (error[i] != null)
					model.setError(error[i]);
				if (cstmsTrsmStsCd[i] != null)
					model.setCstmsTrsmStsCd(cstmsTrsmStsCd[i]);
				if (vMi[i] != null)
					model.setVMi(vMi[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (actionCode[i] != null)
					model.setActionCode(actionCode[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (miSndDt[i] != null)
					model.setMiSndDt(miSndDt[i]);
				if (ibdLocGdsDesc[i] != null)
					model.setIbdLocGdsDesc(ibdLocGdsDesc[i]);
				if (tVvdCd[i] != null)
					model.setTVvdCd(tVvdCd[i]);
				if (caNo[i] != null)
					model.setCaNo(caNo[i]);
				if (mblNo[i] != null)
					model.setMblNo(mblNo[i]);
				if (actionDesc[i] != null)
					model.setActionDesc(actionDesc[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				if (cstmsFileCd[i] != null)
					model.setCstmsFileCd(cstmsFileCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaCstmsManifestAmendmentVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaCstmsManifestAmendmentVO[]
	 */
	public UsaCstmsManifestAmendmentVO[] getUsaCstmsManifestAmendmentVOs(){
		UsaCstmsManifestAmendmentVO[] vos = (UsaCstmsManifestAmendmentVO[])models.toArray(new UsaCstmsManifestAmendmentVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsFileTpCd = this.cstmsFileTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aiType = this.aiType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrRnum = this.bdrRnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfStsCd = this.mfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd = this.bkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mh = this.mh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bVvdCd = this.bVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aiFlag = this.aiFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bMi = this.bMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.error = this.error .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsTrsmStsCd = this.cstmsTrsmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vMi = this.vMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actionCode = this.actionCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.miSndDt = this.miSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdLocGdsDesc = this.ibdLocGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvdCd = this.tVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caNo = this.caNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mblNo = this.mblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actionDesc = this.actionDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsFileCd = this.cstmsFileCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
