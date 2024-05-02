/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : IsraelManifestTransmitVO.java
*@FileTitle : IsraelManifestTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.20
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.08.20 김보배 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김보배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IsraelManifestTransmitVO extends ManifestTransmitVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<IsraelManifestTransmitVO> models = new ArrayList<IsraelManifestTransmitVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String dtSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cmHts = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cmMs = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String pBlNo = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cntrMs = null;
	/* Column Info */
	private String cmMk = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String cntrWt = null;
	/* Column Info */
	private String blWt = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String cntrCntrNo = null;
	/* Column Info */
	private String cmWt = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String bpolCd = null;
	/* Column Info */
	private String dtCheck = null;
	/* Column Info */
	private String ediTime = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ediSent = null;
	/* Column Info */
	private String ntfyAd = null;
	/* Column Info */
	private String ct = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String cneeAd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String blMs = null;
	/* Column Info */
	private String cmDs = null;
	/* Column Info */
	private String cntrSeal = null;
	/* Column Info */
	private String pOriAmdCd = null;
	/* Column Info */
	private String ediMrn = null;
	/* Column Info */
	private String cntrList = null;
	/* Column Info */
	private String blPk = null;
	/* Column Info */
	private String shAd = null;
	/* Column Info */
	private String lt = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String cmPk = null;
	/* Column Info */
	private String bpodCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String ttlCntr = null;
	/* Column Info */
	private String shNm = null;
	/* Column Info */
	private String pSendYn = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String ttlErrBl = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String bpol = null;
	/* Column Info */
	private String ttlBl = null;
	/* Column Info */
	private String ediRefNo = null;
	/* Column Info */
	private String cntrPk = null;
	/* Column Info */
	private String bpod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IsraelManifestTransmitVO() {}

	public IsraelManifestTransmitVO(String ibflag, String pagerows, String blNo, String vvdCd, String dtSeq, String dtCheck, String pol, String pod, String polCd, String podCd, String bpol, String bpod, String bpolCd, String bpodCd, String del, String ct, String lt, String shNm, String shAd, String cneeNm, String cneeAd, String ntfyNm, String ntfyAd, String blPk, String blWt, String blMs, String cntrCntrNo, String cntrSeal, String cntrPk, String cntrWt, String cntrMs, String cmPk, String cmWt, String cmMs, String cmDs, String cmMk, String cmHts, String ediSent, String ediTime, String ediMrn, String ediRefNo, String vpsEtdDt, String vpsEtaDt, String ttlBl, String ttlErrBl, String ttlCntr, String vslCd, String skdVoyNo, String skdDirCd, String cntrList, String creUsrId, String pOriAmdCd, String pBlNo, String pSendYn) {
		this.vslCd = vslCd;
		this.dtSeq = dtSeq;
		this.blNo = blNo;
		this.cmHts = cmHts;
		this.pagerows = pagerows;
		this.cmMs = cmMs;
		this.polCd = polCd;
		this.pBlNo = pBlNo;
		this.vvdCd = vvdCd;
		this.cntrMs = cntrMs;
		this.cmMk = cmMk;
		this.pol = pol;
		this.cntrWt = cntrWt;
		this.blWt = blWt;
		this.pod = pod;
		this.cntrCntrNo = cntrCntrNo;
		this.cmWt = cmWt;
		this.vpsEtdDt = vpsEtdDt;
		this.bpolCd = bpolCd;
		this.dtCheck = dtCheck;
		this.ediTime = ediTime;
		this.skdVoyNo = skdVoyNo;
		this.ediSent = ediSent;
		this.ntfyAd = ntfyAd;
		this.ct = ct;
		this.podCd = podCd;
		this.cneeAd = cneeAd;
		this.creUsrId = creUsrId;
		this.blMs = blMs;
		this.cmDs = cmDs;
		this.cntrSeal = cntrSeal;
		this.pOriAmdCd = pOriAmdCd;
		this.ediMrn = ediMrn;
		this.cntrList = cntrList;
		this.blPk = blPk;
		this.shAd = shAd;
		this.lt = lt;
		this.vpsEtaDt = vpsEtaDt;
		this.cmPk = cmPk;
		this.bpodCd = bpodCd;
		this.ibflag = ibflag;
		this.del = del;
		this.ttlCntr = ttlCntr;
		this.shNm = shNm;
		this.pSendYn = pSendYn;
		this.ntfyNm = ntfyNm;
		this.skdDirCd = skdDirCd;
		this.ttlErrBl = ttlErrBl;
		this.cneeNm = cneeNm;
		this.bpol = bpol;
		this.ttlBl = ttlBl;
		this.ediRefNo = ediRefNo;
		this.cntrPk = cntrPk;
		this.bpod = bpod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("dt_seq", getDtSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cm_hts", getCmHts());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cm_ms", getCmMs());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("p_bl_no", getPBlNo());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cntr_ms", getCntrMs());
		this.hashColumns.put("cm_mk", getCmMk());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("cntr_wt", getCntrWt());
		this.hashColumns.put("bl_wt", getBlWt());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("cntr_cntr_no", getCntrCntrNo());
		this.hashColumns.put("cm_wt", getCmWt());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("bpol_cd", getBpolCd());
		this.hashColumns.put("dt_check", getDtCheck());
		this.hashColumns.put("edi_time", getEdiTime());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("edi_sent", getEdiSent());
		this.hashColumns.put("ntfy_ad", getNtfyAd());
		this.hashColumns.put("ct", getCt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cnee_ad", getCneeAd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bl_ms", getBlMs());
		this.hashColumns.put("cm_ds", getCmDs());
		this.hashColumns.put("cntr_seal", getCntrSeal());
		this.hashColumns.put("p_ori_amd_cd", getPOriAmdCd());
		this.hashColumns.put("edi_mrn", getEdiMrn());
		this.hashColumns.put("cntr_list", getCntrList());
		this.hashColumns.put("bl_pk", getBlPk());
		this.hashColumns.put("sh_ad", getShAd());
		this.hashColumns.put("lt", getLt());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("cm_pk", getCmPk());
		this.hashColumns.put("bpod_cd", getBpodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("ttl_cntr", getTtlCntr());
		this.hashColumns.put("sh_nm", getShNm());
		this.hashColumns.put("p_send_yn", getPSendYn());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("ttl_err_bl", getTtlErrBl());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("bpol", getBpol());
		this.hashColumns.put("ttl_bl", getTtlBl());
		this.hashColumns.put("edi_ref_no", getEdiRefNo());
		this.hashColumns.put("cntr_pk", getCntrPk());
		this.hashColumns.put("bpod", getBpod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("dt_seq", "dtSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cm_hts", "cmHts");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cm_ms", "cmMs");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("p_bl_no", "pBlNo");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cntr_ms", "cntrMs");
		this.hashFields.put("cm_mk", "cmMk");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("cntr_wt", "cntrWt");
		this.hashFields.put("bl_wt", "blWt");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("cntr_cntr_no", "cntrCntrNo");
		this.hashFields.put("cm_wt", "cmWt");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("bpol_cd", "bpolCd");
		this.hashFields.put("dt_check", "dtCheck");
		this.hashFields.put("edi_time", "ediTime");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("edi_sent", "ediSent");
		this.hashFields.put("ntfy_ad", "ntfyAd");
		this.hashFields.put("ct", "ct");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cnee_ad", "cneeAd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bl_ms", "blMs");
		this.hashFields.put("cm_ds", "cmDs");
		this.hashFields.put("cntr_seal", "cntrSeal");
		this.hashFields.put("p_ori_amd_cd", "pOriAmdCd");
		this.hashFields.put("edi_mrn", "ediMrn");
		this.hashFields.put("cntr_list", "cntrList");
		this.hashFields.put("bl_pk", "blPk");
		this.hashFields.put("sh_ad", "shAd");
		this.hashFields.put("lt", "lt");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("cm_pk", "cmPk");
		this.hashFields.put("bpod_cd", "bpodCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("del", "del");
		this.hashFields.put("ttl_cntr", "ttlCntr");
		this.hashFields.put("sh_nm", "shNm");
		this.hashFields.put("p_send_yn", "pSendYn");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("ttl_err_bl", "ttlErrBl");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("bpol", "bpol");
		this.hashFields.put("ttl_bl", "ttlBl");
		this.hashFields.put("edi_ref_no", "ediRefNo");
		this.hashFields.put("cntr_pk", "cntrPk");
		this.hashFields.put("bpod", "bpod");
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
	 * @return dtSeq
	 */
	public String getDtSeq() {
		return this.dtSeq;
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
	 * @return cmHts
	 */
	public String getCmHts() {
		return this.cmHts;
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
	 * @return cmMs
	 */
	public String getCmMs() {
		return this.cmMs;
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
	 * @return pBlNo
	 */
	public String getPBlNo() {
		return this.pBlNo;
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
	 * @return cntrMs
	 */
	public String getCntrMs() {
		return this.cntrMs;
	}
	
	/**
	 * Column Info
	 * @return cmMk
	 */
	public String getCmMk() {
		return this.cmMk;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return cntrWt
	 */
	public String getCntrWt() {
		return this.cntrWt;
	}
	
	/**
	 * Column Info
	 * @return blWt
	 */
	public String getBlWt() {
		return this.blWt;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return cntrCntrNo
	 */
	public String getCntrCntrNo() {
		return this.cntrCntrNo;
	}
	
	/**
	 * Column Info
	 * @return cmWt
	 */
	public String getCmWt() {
		return this.cmWt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return bpolCd
	 */
	public String getBpolCd() {
		return this.bpolCd;
	}
	
	/**
	 * Column Info
	 * @return dtCheck
	 */
	public String getDtCheck() {
		return this.dtCheck;
	}
	
	/**
	 * Column Info
	 * @return ediTime
	 */
	public String getEdiTime() {
		return this.ediTime;
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
	 * @return ediSent
	 */
	public String getEdiSent() {
		return this.ediSent;
	}
	
	/**
	 * Column Info
	 * @return ntfyAd
	 */
	public String getNtfyAd() {
		return this.ntfyAd;
	}
	
	/**
	 * Column Info
	 * @return ct
	 */
	public String getCt() {
		return this.ct;
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
	 * @return cneeAd
	 */
	public String getCneeAd() {
		return this.cneeAd;
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
	 * @return blMs
	 */
	public String getBlMs() {
		return this.blMs;
	}
	
	/**
	 * Column Info
	 * @return cmDs
	 */
	public String getCmDs() {
		return this.cmDs;
	}
	
	/**
	 * Column Info
	 * @return cntrSeal
	 */
	public String getCntrSeal() {
		return this.cntrSeal;
	}
	
	/**
	 * Column Info
	 * @return pOriAmdCd
	 */
	public String getPOriAmdCd() {
		return this.pOriAmdCd;
	}
	
	/**
	 * Column Info
	 * @return ediMrn
	 */
	public String getEdiMrn() {
		return this.ediMrn;
	}
	
	/**
	 * Column Info
	 * @return cntrList
	 */
	public String getCntrList() {
		return this.cntrList;
	}
	
	/**
	 * Column Info
	 * @return blPk
	 */
	public String getBlPk() {
		return this.blPk;
	}
	
	/**
	 * Column Info
	 * @return shAd
	 */
	public String getShAd() {
		return this.shAd;
	}
	
	/**
	 * Column Info
	 * @return lt
	 */
	public String getLt() {
		return this.lt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return cmPk
	 */
	public String getCmPk() {
		return this.cmPk;
	}
	
	/**
	 * Column Info
	 * @return bpodCd
	 */
	public String getBpodCd() {
		return this.bpodCd;
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
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return ttlCntr
	 */
	public String getTtlCntr() {
		return this.ttlCntr;
	}
	
	/**
	 * Column Info
	 * @return shNm
	 */
	public String getShNm() {
		return this.shNm;
	}
	
	/**
	 * Column Info
	 * @return pSendYn
	 */
	public String getPSendYn() {
		return this.pSendYn;
	}
	
	/**
	 * Column Info
	 * @return ntfyNm
	 */
	public String getNtfyNm() {
		return this.ntfyNm;
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
	 * @return ttlErrBl
	 */
	public String getTtlErrBl() {
		return this.ttlErrBl;
	}
	
	/**
	 * Column Info
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return bpol
	 */
	public String getBpol() {
		return this.bpol;
	}
	
	/**
	 * Column Info
	 * @return ttlBl
	 */
	public String getTtlBl() {
		return this.ttlBl;
	}
	
	/**
	 * Column Info
	 * @return ediRefNo
	 */
	public String getEdiRefNo() {
		return this.ediRefNo;
	}
	
	/**
	 * Column Info
	 * @return cntrPk
	 */
	public String getCntrPk() {
		return this.cntrPk;
	}
	
	/**
	 * Column Info
	 * @return bpod
	 */
	public String getBpod() {
		return this.bpod;
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
	 * @param dtSeq
	 */
	public void setDtSeq(String dtSeq) {
		this.dtSeq = dtSeq;
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
	 * @param cmHts
	 */
	public void setCmHts(String cmHts) {
		this.cmHts = cmHts;
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
	 * @param cmMs
	 */
	public void setCmMs(String cmMs) {
		this.cmMs = cmMs;
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
	 * @param pBlNo
	 */
	public void setPBlNo(String pBlNo) {
		this.pBlNo = pBlNo;
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
	 * @param cntrMs
	 */
	public void setCntrMs(String cntrMs) {
		this.cntrMs = cntrMs;
	}
	
	/**
	 * Column Info
	 * @param cmMk
	 */
	public void setCmMk(String cmMk) {
		this.cmMk = cmMk;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param cntrWt
	 */
	public void setCntrWt(String cntrWt) {
		this.cntrWt = cntrWt;
	}
	
	/**
	 * Column Info
	 * @param blWt
	 */
	public void setBlWt(String blWt) {
		this.blWt = blWt;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param cntrCntrNo
	 */
	public void setCntrCntrNo(String cntrCntrNo) {
		this.cntrCntrNo = cntrCntrNo;
	}
	
	/**
	 * Column Info
	 * @param cmWt
	 */
	public void setCmWt(String cmWt) {
		this.cmWt = cmWt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param bpolCd
	 */
	public void setBpolCd(String bpolCd) {
		this.bpolCd = bpolCd;
	}
	
	/**
	 * Column Info
	 * @param dtCheck
	 */
	public void setDtCheck(String dtCheck) {
		this.dtCheck = dtCheck;
	}
	
	/**
	 * Column Info
	 * @param ediTime
	 */
	public void setEdiTime(String ediTime) {
		this.ediTime = ediTime;
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
	 * @param ediSent
	 */
	public void setEdiSent(String ediSent) {
		this.ediSent = ediSent;
	}
	
	/**
	 * Column Info
	 * @param ntfyAd
	 */
	public void setNtfyAd(String ntfyAd) {
		this.ntfyAd = ntfyAd;
	}
	
	/**
	 * Column Info
	 * @param ct
	 */
	public void setCt(String ct) {
		this.ct = ct;
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
	 * @param cneeAd
	 */
	public void setCneeAd(String cneeAd) {
		this.cneeAd = cneeAd;
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
	 * @param blMs
	 */
	public void setBlMs(String blMs) {
		this.blMs = blMs;
	}
	
	/**
	 * Column Info
	 * @param cmDs
	 */
	public void setCmDs(String cmDs) {
		this.cmDs = cmDs;
	}
	
	/**
	 * Column Info
	 * @param cntrSeal
	 */
	public void setCntrSeal(String cntrSeal) {
		this.cntrSeal = cntrSeal;
	}
	
	/**
	 * Column Info
	 * @param pOriAmdCd
	 */
	public void setPOriAmdCd(String pOriAmdCd) {
		this.pOriAmdCd = pOriAmdCd;
	}
	
	/**
	 * Column Info
	 * @param ediMrn
	 */
	public void setEdiMrn(String ediMrn) {
		this.ediMrn = ediMrn;
	}
	
	/**
	 * Column Info
	 * @param cntrList
	 */
	public void setCntrList(String cntrList) {
		this.cntrList = cntrList;
	}
	
	/**
	 * Column Info
	 * @param blPk
	 */
	public void setBlPk(String blPk) {
		this.blPk = blPk;
	}
	
	/**
	 * Column Info
	 * @param shAd
	 */
	public void setShAd(String shAd) {
		this.shAd = shAd;
	}
	
	/**
	 * Column Info
	 * @param lt
	 */
	public void setLt(String lt) {
		this.lt = lt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param cmPk
	 */
	public void setCmPk(String cmPk) {
		this.cmPk = cmPk;
	}
	
	/**
	 * Column Info
	 * @param bpodCd
	 */
	public void setBpodCd(String bpodCd) {
		this.bpodCd = bpodCd;
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
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param ttlCntr
	 */
	public void setTtlCntr(String ttlCntr) {
		this.ttlCntr = ttlCntr;
	}
	
	/**
	 * Column Info
	 * @param shNm
	 */
	public void setShNm(String shNm) {
		this.shNm = shNm;
	}
	
	/**
	 * Column Info
	 * @param pSendYn
	 */
	public void setPSendYn(String pSendYn) {
		this.pSendYn = pSendYn;
	}
	
	/**
	 * Column Info
	 * @param ntfyNm
	 */
	public void setNtfyNm(String ntfyNm) {
		this.ntfyNm = ntfyNm;
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
	 * @param ttlErrBl
	 */
	public void setTtlErrBl(String ttlErrBl) {
		this.ttlErrBl = ttlErrBl;
	}
	
	/**
	 * Column Info
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param bpol
	 */
	public void setBpol(String bpol) {
		this.bpol = bpol;
	}
	
	/**
	 * Column Info
	 * @param ttlBl
	 */
	public void setTtlBl(String ttlBl) {
		this.ttlBl = ttlBl;
	}
	
	/**
	 * Column Info
	 * @param ediRefNo
	 */
	public void setEdiRefNo(String ediRefNo) {
		this.ediRefNo = ediRefNo;
	}
	
	/**
	 * Column Info
	 * @param cntrPk
	 */
	public void setCntrPk(String cntrPk) {
		this.cntrPk = cntrPk;
	}
	
	/**
	 * Column Info
	 * @param bpod
	 */
	public void setBpod(String bpod) {
		this.bpod = bpod;
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
		setDtSeq(JSPUtil.getParameter(request, prefix + "dt_seq", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCmHts(JSPUtil.getParameter(request, prefix + "cm_hts", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCmMs(JSPUtil.getParameter(request, prefix + "cm_ms", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPBlNo(JSPUtil.getParameter(request, prefix + "p_bl_no", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setCntrMs(JSPUtil.getParameter(request, prefix + "cntr_ms", ""));
		setCmMk(JSPUtil.getParameter(request, prefix + "cm_mk", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setCntrWt(JSPUtil.getParameter(request, prefix + "cntr_wt", ""));
		setBlWt(JSPUtil.getParameter(request, prefix + "bl_wt", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setCntrCntrNo(JSPUtil.getParameter(request, prefix + "cntr_cntr_no", ""));
		setCmWt(JSPUtil.getParameter(request, prefix + "cm_wt", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setBpolCd(JSPUtil.getParameter(request, prefix + "bpol_cd", ""));
		setDtCheck(JSPUtil.getParameter(request, prefix + "dt_check", ""));
		setEdiTime(JSPUtil.getParameter(request, prefix + "edi_time", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setEdiSent(JSPUtil.getParameter(request, prefix + "edi_sent", ""));
		setNtfyAd(JSPUtil.getParameter(request, prefix + "ntfy_ad", ""));
		setCt(JSPUtil.getParameter(request, prefix + "ct", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCneeAd(JSPUtil.getParameter(request, prefix + "cnee_ad", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBlMs(JSPUtil.getParameter(request, prefix + "bl_ms", ""));
		setCmDs(JSPUtil.getParameter(request, prefix + "cm_ds", ""));
		setCntrSeal(JSPUtil.getParameter(request, prefix + "cntr_seal", ""));
		setPOriAmdCd(JSPUtil.getParameter(request, prefix + "p_ori_amd_cd", ""));
		setEdiMrn(JSPUtil.getParameter(request, prefix + "edi_mrn", ""));
		setCntrList(JSPUtil.getParameter(request, prefix + "cntr_list", ""));
		setBlPk(JSPUtil.getParameter(request, prefix + "bl_pk", ""));
		setShAd(JSPUtil.getParameter(request, prefix + "sh_ad", ""));
		setLt(JSPUtil.getParameter(request, prefix + "lt", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setCmPk(JSPUtil.getParameter(request, prefix + "cm_pk", ""));
		setBpodCd(JSPUtil.getParameter(request, prefix + "bpod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDel(JSPUtil.getParameter(request, prefix + "del", ""));
		setTtlCntr(JSPUtil.getParameter(request, prefix + "ttl_cntr", ""));
		setShNm(JSPUtil.getParameter(request, prefix + "sh_nm", ""));
		setPSendYn(JSPUtil.getParameter(request, prefix + "p_send_yn", ""));
		setNtfyNm(JSPUtil.getParameter(request, prefix + "ntfy_nm", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setTtlErrBl(JSPUtil.getParameter(request, prefix + "ttl_err_bl", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setBpol(JSPUtil.getParameter(request, prefix + "bpol", ""));
		setTtlBl(JSPUtil.getParameter(request, prefix + "ttl_bl", ""));
		setEdiRefNo(JSPUtil.getParameter(request, prefix + "edi_ref_no", ""));
		setCntrPk(JSPUtil.getParameter(request, prefix + "cntr_pk", ""));
		setBpod(JSPUtil.getParameter(request, prefix + "bpod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IsraelManifestTransmitVO[]
	 */
	public IsraelManifestTransmitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IsraelManifestTransmitVO[]
	 */
	public IsraelManifestTransmitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IsraelManifestTransmitVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] dtSeq = (JSPUtil.getParameter(request, prefix	+ "dt_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cmHts = (JSPUtil.getParameter(request, prefix	+ "cm_hts", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cmMs = (JSPUtil.getParameter(request, prefix	+ "cm_ms", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] pBlNo = (JSPUtil.getParameter(request, prefix	+ "p_bl_no", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cntrMs = (JSPUtil.getParameter(request, prefix	+ "cntr_ms", length));
			String[] cmMk = (JSPUtil.getParameter(request, prefix	+ "cm_mk", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] cntrWt = (JSPUtil.getParameter(request, prefix	+ "cntr_wt", length));
			String[] blWt = (JSPUtil.getParameter(request, prefix	+ "bl_wt", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] cntrCntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cntr_no", length));
			String[] cmWt = (JSPUtil.getParameter(request, prefix	+ "cm_wt", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] bpolCd = (JSPUtil.getParameter(request, prefix	+ "bpol_cd", length));
			String[] dtCheck = (JSPUtil.getParameter(request, prefix	+ "dt_check", length));
			String[] ediTime = (JSPUtil.getParameter(request, prefix	+ "edi_time", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] ediSent = (JSPUtil.getParameter(request, prefix	+ "edi_sent", length));
			String[] ntfyAd = (JSPUtil.getParameter(request, prefix	+ "ntfy_ad", length));
			String[] ct = (JSPUtil.getParameter(request, prefix	+ "ct", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cneeAd = (JSPUtil.getParameter(request, prefix	+ "cnee_ad", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] blMs = (JSPUtil.getParameter(request, prefix	+ "bl_ms", length));
			String[] cmDs = (JSPUtil.getParameter(request, prefix	+ "cm_ds", length));
			String[] cntrSeal = (JSPUtil.getParameter(request, prefix	+ "cntr_seal", length));
			String[] pOriAmdCd = (JSPUtil.getParameter(request, prefix	+ "p_ori_amd_cd", length));
			String[] ediMrn = (JSPUtil.getParameter(request, prefix	+ "edi_mrn", length));
			String[] cntrList = (JSPUtil.getParameter(request, prefix	+ "cntr_list", length));
			String[] blPk = (JSPUtil.getParameter(request, prefix	+ "bl_pk", length));
			String[] shAd = (JSPUtil.getParameter(request, prefix	+ "sh_ad", length));
			String[] lt = (JSPUtil.getParameter(request, prefix	+ "lt", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] cmPk = (JSPUtil.getParameter(request, prefix	+ "cm_pk", length));
			String[] bpodCd = (JSPUtil.getParameter(request, prefix	+ "bpod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] ttlCntr = (JSPUtil.getParameter(request, prefix	+ "ttl_cntr", length));
			String[] shNm = (JSPUtil.getParameter(request, prefix	+ "sh_nm", length));
			String[] pSendYn = (JSPUtil.getParameter(request, prefix	+ "p_send_yn", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] ttlErrBl = (JSPUtil.getParameter(request, prefix	+ "ttl_err_bl", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] bpol = (JSPUtil.getParameter(request, prefix	+ "bpol", length));
			String[] ttlBl = (JSPUtil.getParameter(request, prefix	+ "ttl_bl", length));
			String[] ediRefNo = (JSPUtil.getParameter(request, prefix	+ "edi_ref_no", length));
			String[] cntrPk = (JSPUtil.getParameter(request, prefix	+ "cntr_pk", length));
			String[] bpod = (JSPUtil.getParameter(request, prefix	+ "bpod", length));
			
			for (int i = 0; i < length; i++) {
				model = new IsraelManifestTransmitVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (dtSeq[i] != null)
					model.setDtSeq(dtSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cmHts[i] != null)
					model.setCmHts(cmHts[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cmMs[i] != null)
					model.setCmMs(cmMs[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (pBlNo[i] != null)
					model.setPBlNo(pBlNo[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cntrMs[i] != null)
					model.setCntrMs(cntrMs[i]);
				if (cmMk[i] != null)
					model.setCmMk(cmMk[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (cntrWt[i] != null)
					model.setCntrWt(cntrWt[i]);
				if (blWt[i] != null)
					model.setBlWt(blWt[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (cntrCntrNo[i] != null)
					model.setCntrCntrNo(cntrCntrNo[i]);
				if (cmWt[i] != null)
					model.setCmWt(cmWt[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (bpolCd[i] != null)
					model.setBpolCd(bpolCd[i]);
				if (dtCheck[i] != null)
					model.setDtCheck(dtCheck[i]);
				if (ediTime[i] != null)
					model.setEdiTime(ediTime[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ediSent[i] != null)
					model.setEdiSent(ediSent[i]);
				if (ntfyAd[i] != null)
					model.setNtfyAd(ntfyAd[i]);
				if (ct[i] != null)
					model.setCt(ct[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cneeAd[i] != null)
					model.setCneeAd(cneeAd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (blMs[i] != null)
					model.setBlMs(blMs[i]);
				if (cmDs[i] != null)
					model.setCmDs(cmDs[i]);
				if (cntrSeal[i] != null)
					model.setCntrSeal(cntrSeal[i]);
				if (pOriAmdCd[i] != null)
					model.setPOriAmdCd(pOriAmdCd[i]);
				if (ediMrn[i] != null)
					model.setEdiMrn(ediMrn[i]);
				if (cntrList[i] != null)
					model.setCntrList(cntrList[i]);
				if (blPk[i] != null)
					model.setBlPk(blPk[i]);
				if (shAd[i] != null)
					model.setShAd(shAd[i]);
				if (lt[i] != null)
					model.setLt(lt[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (cmPk[i] != null)
					model.setCmPk(cmPk[i]);
				if (bpodCd[i] != null)
					model.setBpodCd(bpodCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (ttlCntr[i] != null)
					model.setTtlCntr(ttlCntr[i]);
				if (shNm[i] != null)
					model.setShNm(shNm[i]);
				if (pSendYn[i] != null)
					model.setPSendYn(pSendYn[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (ttlErrBl[i] != null)
					model.setTtlErrBl(ttlErrBl[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (bpol[i] != null)
					model.setBpol(bpol[i]);
				if (ttlBl[i] != null)
					model.setTtlBl(ttlBl[i]);
				if (ediRefNo[i] != null)
					model.setEdiRefNo(ediRefNo[i]);
				if (cntrPk[i] != null)
					model.setCntrPk(cntrPk[i]);
				if (bpod[i] != null)
					model.setBpod(bpod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIsraelManifestTransmitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IsraelManifestTransmitVO[]
	 */
	public IsraelManifestTransmitVO[] getIsraelManifestTransmitVOs(){
		IsraelManifestTransmitVO[] vos = (IsraelManifestTransmitVO[])models.toArray(new IsraelManifestTransmitVO[models.size()]);
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
		this.dtSeq = this.dtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmHts = this.cmHts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmMs = this.cmMs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBlNo = this.pBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMs = this.cntrMs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmMk = this.cmMk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWt = this.cntrWt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blWt = this.blWt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCntrNo = this.cntrCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmWt = this.cmWt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bpolCd = this.bpolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtCheck = this.dtCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediTime = this.ediTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSent = this.ediSent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAd = this.ntfyAd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ct = this.ct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAd = this.cneeAd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blMs = this.blMs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmDs = this.cmDs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSeal = this.cntrSeal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pOriAmdCd = this.pOriAmdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMrn = this.ediMrn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrList = this.cntrList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPk = this.blPk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shAd = this.shAd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lt = this.lt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPk = this.cmPk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bpodCd = this.bpodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCntr = this.ttlCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shNm = this.shNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pSendYn = this.pSendYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlErrBl = this.ttlErrBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bpol = this.bpol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlBl = this.ttlBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRefNo = this.ediRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPk = this.cntrPk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bpod = this.bpod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
