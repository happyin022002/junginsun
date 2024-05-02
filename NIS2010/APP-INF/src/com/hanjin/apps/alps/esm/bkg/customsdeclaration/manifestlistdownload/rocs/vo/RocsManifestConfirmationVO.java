/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsManifestConfirmationVO.java
*@FileTitle : RocsManifestConfirmationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.24 임재택 
* 1.0 Creation
* -------------------------------------------------------
* History
* 2013.10.21 김보배 [CHM-201327005] Split 02-[ALPS 데이터품질 - BKG validation 로직보완] 9월 대상 건에 대한 진행 요청 건
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestConfirmationVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RocsManifestConfirmationVO extends ManifestConfirmationVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<RocsManifestConfirmationVO> models = new ArrayList<RocsManifestConfirmationVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String frmCrnNumber = null;
	/* Column Info */
	private String crnNumber = null;
	/* Column Info */
	private String bigoKind = null;
	/* Column Info */
	private String datCfmFlg = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String cntrMfWgt = null;
	/* Column Info */
	private String reMsgDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String kind = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrMfDesc = null;
	/* Column Info */
	private String ediSndStsCd = null;
	/* Column Info */
	private String mfSndDt = null;
	/* Column Info */
	private String cntrWgtUtCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String ntfyAddr = null;
	/* Column Info */
	private String preRlyPortCd = null;
	/* Column Info */
	private String blNo2 = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String blDatCfmDt = null;
	/* Column Info */
	private String rtmReMsgStsCd = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String cstmsDeclUsrId = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String sndUsrId = null;
	/* Column Info */
	private String t1DocCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String pstRlyPortCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String mtFlag = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String rtmSndStsCd = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RocsManifestConfirmationVO() {}

	public RocsManifestConfirmationVO(String ibflag, String pagerows, String kind, String blNo,
			String blNo2, String cntrNo, String bkgCgoTpCd, String porCd, String polCd,
			String podCd, String delCd, String preRlyPortCd, String pstRlyPortCd, String pckQty,
			String pckTpCd, String cntrMfWgt, String cntrWgtUtCd, String t1DocCd, String bdrFlg,
			String cntrMfDesc, String ntfyAddr, String ediSndStsCd, String sndUsrId, String mfSndDt,
			String rtmReMsgStsCd, String reMsgDt, String datCfmFlg, String cstmsDeclUsrId, 
			String blDatCfmDt, String bkgNo, String frmCrnNumber, String blTpCd,String seq,
			String mtFlag,String crnNumber,String bigoKind,String userId, String rtmSndStsCd) {
		this.porCd = porCd;
		this.seq   = seq;
		this.frmCrnNumber = frmCrnNumber;
		this.userId = userId;
		this.bigoKind = bigoKind;
		this.crnNumber = crnNumber;
		this.datCfmFlg = datCfmFlg;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.bdrFlg = bdrFlg;
		this.cntrMfWgt = cntrMfWgt;
		this.reMsgDt = reMsgDt;
		this.blNo = blNo;
		this.kind = kind;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cntrMfDesc = cntrMfDesc;
		this.ediSndStsCd = ediSndStsCd;
		this.mfSndDt = mfSndDt;
		this.cntrWgtUtCd = cntrWgtUtCd;
		this.pckQty = pckQty;
		this.pckTpCd = pckTpCd;
		this.ntfyAddr = ntfyAddr;
		this.preRlyPortCd = preRlyPortCd;
		this.blNo2 = blNo2;
		this.delCd = delCd;
		this.blDatCfmDt = blDatCfmDt;
		this.rtmReMsgStsCd = rtmReMsgStsCd;
		this.blTpCd = blTpCd;
		this.cstmsDeclUsrId = cstmsDeclUsrId;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.sndUsrId = sndUsrId;
		this.t1DocCd = t1DocCd;
		this.cntrNo = cntrNo;
		this.pstRlyPortCd = pstRlyPortCd;
		this.mtFlag = mtFlag;
		this.rtmSndStsCd = rtmSndStsCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("frm_crn_number", getFrmCrnNumber());
		this.hashColumns.put("bigo_kind", getBigoKind());
		this.hashColumns.put("crn_number", getCrnNumber());
		this.hashColumns.put("dat_cfm_flg", getDatCfmFlg());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("cntr_mf_wgt", getCntrMfWgt());
		this.hashColumns.put("re_msg_dt", getReMsgDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("kind", getKind());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_mf_desc", getCntrMfDesc());
		this.hashColumns.put("edi_snd_sts_cd", getEdiSndStsCd());
		this.hashColumns.put("mf_snd_dt", getMfSndDt());
		this.hashColumns.put("cntr_wgt_ut_cd", getCntrWgtUtCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("ntfy_addr", getNtfyAddr());
		this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
		this.hashColumns.put("bl_no2", getBlNo2());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bl_dat_cfm_dt", getBlDatCfmDt());
		this.hashColumns.put("rtm_re_msg_sts_cd", getRtmReMsgStsCd());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("cstms_decl_usr_id", getCstmsDeclUsrId());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("t1_doc_cd", getT1DocCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("mt_flag", getMtFlag());
		this.hashColumns.put("pst_rly_port_cd", getPstRlyPortCd());
		this.hashColumns.put("rtm_snd_sts_cd", getRtmSndStsCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("frm_crn_number", "frmCrnNumber");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("bigo_kind", "bigoKind");
		this.hashFields.put("crn_number", "crnNumber");
		this.hashFields.put("dat_cfm_flg", "datCfmFlg");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("cntr_mf_wgt", "cntrMfWgt");
		this.hashFields.put("re_msg_dt", "reMsgDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("kind", "kind");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_mf_desc", "cntrMfDesc");
		this.hashFields.put("edi_snd_sts_cd", "ediSndStsCd");
		this.hashFields.put("mf_snd_dt", "mfSndDt");
		this.hashFields.put("cntr_wgt_ut_cd", "cntrWgtUtCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("ntfy_addr", "ntfyAddr");
		this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
		this.hashFields.put("bl_no2", "blNo2");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bl_dat_cfm_dt", "blDatCfmDt");
		this.hashFields.put("rtm_re_msg_sts_cd", "rtmReMsgStsCd");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("cstms_decl_usr_id", "cstmsDeclUsrId");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("t1_doc_cd", "t1DocCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("mt_flag", "mtFlag");
		this.hashFields.put("pst_rly_port_cd", "pstRlyPortCd");
		this.hashFields.put("rtm_snd_sts_cd", "rtmSndStsCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	public String getSeq() {
		return this.seq;
	}
	public String getBigoKind() {
		return this.bigoKind;
	}
	public String getMtFlag() {
		return this.mtFlag;
	}
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return frmCrnNumber
	 */
	public String getFrmCrnNumber() {
		return this.frmCrnNumber;
	}
	
	public String getCrnNumber() {
		return this.crnNumber;
	}
	
	/**
	 * Column Info
	 * @return datCfmFlg
	 */
	public String getDatCfmFlg() {
		return this.datCfmFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
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
	 * @return cntrMfWgt
	 */
	public String getCntrMfWgt() {
		return this.cntrMfWgt;
	}
	
	/**
	 * Column Info
	 * @return reMsgDt
	 */
	public String getReMsgDt() {
		return this.reMsgDt;
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
	 * @return kind
	 */
	public String getKind() {
		return this.kind;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return cntrMfDesc
	 */
	public String getCntrMfDesc() {
		return this.cntrMfDesc;
	}
	
	/**
	 * Column Info
	 * @return ediSndStsCd
	 */
	public String getEdiSndStsCd() {
		return this.ediSndStsCd;
	}
	
	/**
	 * Column Info
	 * @return mfSndDt
	 */
	public String getMfSndDt() {
		return this.mfSndDt;
	}
	
	/**
	 * Column Info
	 * @return cntrWgtUtCd
	 */
	public String getCntrWgtUtCd() {
		return this.cntrWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return ntfyAddr
	 */
	public String getNtfyAddr() {
		return this.ntfyAddr;
	}
	
	/**
	 * Column Info
	 * @return preRlyPortCd
	 */
	public String getPreRlyPortCd() {
		return this.preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return blNo2
	 */
	public String getBlNo2() {
		return this.blNo2;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return blDatCfmDt
	 */
	public String getBlDatCfmDt() {
		return this.blDatCfmDt;
	}
	
	/**
	 * Column Info
	 * @return rtmReMsgStsCd
	 */
	public String getRtmReMsgStsCd() {
		return this.rtmReMsgStsCd;
	}
	
	/**
	 * Column Info
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsDeclUsrId
	 */
	public String getCstmsDeclUsrId() {
		return this.cstmsDeclUsrId;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
	}
	
	/**
	 * Column Info
	 * @return t1DocCd
	 */
	public String getT1DocCd() {
		return this.t1DocCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return pstRlyPortCd
	 */
	public String getPstRlyPortCd() {
		return this.pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return rtmSndStsCd
	 */
	public String getRtmSndStsCd(){
		return this.rtmSndStsCd;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public void setMtFlag(String mtFlag) {
		this.mtFlag = mtFlag;
	}
	public void setBigoKind(String bigoKind) {
		this.bigoKind = bigoKind;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param frmCrnNumber
	 */
	public void setFrmCrnNumber(String frmCrnNumber) {
		this.frmCrnNumber = frmCrnNumber;
	}
	public void setCrnNumber(String crnNumber) {
		this.crnNumber = crnNumber;
	}
	
	/**
	 * Column Info
	 * @param datCfmFlg
	 */
	public void setDatCfmFlg(String datCfmFlg) {
		this.datCfmFlg = datCfmFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
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
	 * @param cntrMfWgt
	 */
	public void setCntrMfWgt(String cntrMfWgt) {
		this.cntrMfWgt = cntrMfWgt;
	}
	
	/**
	 * Column Info
	 * @param reMsgDt
	 */
	public void setReMsgDt(String reMsgDt) {
		this.reMsgDt = reMsgDt;
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
	 * @param kind
	 */
	public void setKind(String kind) {
		this.kind = kind;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param cntrMfDesc
	 */
	public void setCntrMfDesc(String cntrMfDesc) {
		this.cntrMfDesc = cntrMfDesc;
	}
	
	/**
	 * Column Info
	 * @param ediSndStsCd
	 */
	public void setEdiSndStsCd(String ediSndStsCd) {
		this.ediSndStsCd = ediSndStsCd;
	}
	
	/**
	 * Column Info
	 * @param mfSndDt
	 */
	public void setMfSndDt(String mfSndDt) {
		this.mfSndDt = mfSndDt;
	}
	
	/**
	 * Column Info
	 * @param cntrWgtUtCd
	 */
	public void setCntrWgtUtCd(String cntrWgtUtCd) {
		this.cntrWgtUtCd = cntrWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param ntfyAddr
	 */
	public void setNtfyAddr(String ntfyAddr) {
		this.ntfyAddr = ntfyAddr;
	}
	
	/**
	 * Column Info
	 * @param preRlyPortCd
	 */
	public void setPreRlyPortCd(String preRlyPortCd) {
		this.preRlyPortCd = preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param blNo2
	 */
	public void setBlNo2(String blNo2) {
		this.blNo2 = blNo2;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param blDatCfmDt
	 */
	public void setBlDatCfmDt(String blDatCfmDt) {
		this.blDatCfmDt = blDatCfmDt;
	}
	
	/**
	 * Column Info
	 * @param rtmReMsgStsCd
	 */
	public void setRtmReMsgStsCd(String rtmReMsgStsCd) {
		this.rtmReMsgStsCd = rtmReMsgStsCd;
	}
	
	/**
	 * Column Info
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsDeclUsrId
	 */
	public void setCstmsDeclUsrId(String cstmsDeclUsrId) {
		this.cstmsDeclUsrId = cstmsDeclUsrId;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
	}
	
	/**
	 * Column Info
	 * @param t1DocCd
	 */
	public void setT1DocCd(String t1DocCd) {
		this.t1DocCd = t1DocCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param pstRlyPortCd
	 */
	public void setPstRlyPortCd(String pstRlyPortCd) {
		this.pstRlyPortCd = pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param rtmSndStsCd
	 */
	public void setRtmSndStsCd(String rtmSndStsCd){
		this.rtmSndStsCd = rtmSndStsCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setFrmCrnNumber(JSPUtil.getParameter(request, "frm_crn_number", ""));
		setBigoKind(JSPUtil.getParameter(request, "bigo_kind", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setCrnNumber(JSPUtil.getParameter(request, "crn_number", ""));
		setDatCfmFlg(JSPUtil.getParameter(request, "dat_cfm_flg", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setBdrFlg(JSPUtil.getParameter(request, "bdr_flg", ""));
		setCntrMfWgt(JSPUtil.getParameter(request, "cntr_mf_wgt", ""));
		setReMsgDt(JSPUtil.getParameter(request, "re_msg_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setKind(JSPUtil.getParameter(request, "kind", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrMfDesc(JSPUtil.getParameter(request, "cntr_mf_desc", ""));
		setEdiSndStsCd(JSPUtil.getParameter(request, "edi_snd_sts_cd", ""));
		setMfSndDt(JSPUtil.getParameter(request, "mf_snd_dt", ""));
		setCntrWgtUtCd(JSPUtil.getParameter(request, "cntr_wgt_ut_cd", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setNtfyAddr(JSPUtil.getParameter(request, "ntfy_addr", ""));
		setPreRlyPortCd(JSPUtil.getParameter(request, "pre_rly_port_cd", ""));
		setBlNo2(JSPUtil.getParameter(request, "bl_no2", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setBlDatCfmDt(JSPUtil.getParameter(request, "bl_dat_cfm_dt", ""));
		setRtmReMsgStsCd(JSPUtil.getParameter(request, "rtm_re_msg_sts_cd", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setCstmsDeclUsrId(JSPUtil.getParameter(request, "cstms_decl_usr_id", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setSndUsrId(JSPUtil.getParameter(request, "snd_usr_id", ""));
		setT1DocCd(JSPUtil.getParameter(request, "t1_doc_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setMtFlag(JSPUtil.getParameter(request, "mt_flag", ""));
		setPstRlyPortCd(JSPUtil.getParameter(request, "pst_rly_port_cd", ""));
		setRtmSndStsCd(JSPUtil.getParameter(request, "rtm_snd_sts_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RocsSearchBlListVO[]
	 */
	public RocsManifestConfirmationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RocsSearchBlListVO[]
	 */
	public RocsManifestConfirmationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RocsManifestConfirmationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] frmCrnNumber = (JSPUtil.getParameter(request, prefix	+ "frm_crn_number", length));
			String[] bigoKind = (JSPUtil.getParameter(request, prefix	+ "bigo_kind", length));
			String[] crnNumber = (JSPUtil.getParameter(request, prefix	+ "crn_number", length));
			String[] datCfmFlg = (JSPUtil.getParameter(request, prefix	+ "dat_cfm_flg", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] cntrMfWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_wgt", length));
			String[] reMsgDt = (JSPUtil.getParameter(request, prefix	+ "re_msg_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] kind = (JSPUtil.getParameter(request, prefix	+ "kind", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrMfDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_desc", length));
			String[] ediSndStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_snd_sts_cd", length));
			String[] mfSndDt = (JSPUtil.getParameter(request, prefix	+ "mf_snd_dt", length));
			String[] cntrWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt_ut_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] ntfyAddr = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr", length));
			String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_cd", length));
			String[] blNo2 = (JSPUtil.getParameter(request, prefix	+ "bl_no2", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] blDatCfmDt = (JSPUtil.getParameter(request, prefix	+ "bl_dat_cfm_dt", length));
			String[] rtmReMsgStsCd = (JSPUtil.getParameter(request, prefix	+ "rtm_re_msg_sts_cd", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] cstmsDeclUsrId = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_usr_id", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] t1DocCd = (JSPUtil.getParameter(request, prefix	+ "t1_doc_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] mtFlag = (JSPUtil.getParameter(request, prefix	+ "mt_flag", length));
			String[] pstRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_port_cd", length));
			String[] rtmSndStsCd = (JSPUtil.getParameter(request, prefix	+ "rtm_snd_sts_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RocsManifestConfirmationVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (mtFlag[i] != null)
					model.setMtFlag(mtFlag[i]);
				if (bigoKind[i] != null)
					model.setBigoKind(bigoKind[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (frmCrnNumber[i] != null)
					model.setFrmCrnNumber(frmCrnNumber[i]);
				if (crnNumber[i] != null)
					model.setCrnNumber(crnNumber[i]);
				if (datCfmFlg[i] != null)
					model.setDatCfmFlg(datCfmFlg[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (cntrMfWgt[i] != null)
					model.setCntrMfWgt(cntrMfWgt[i]);
				if (reMsgDt[i] != null)
					model.setReMsgDt(reMsgDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (kind[i] != null)
					model.setKind(kind[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrMfDesc[i] != null)
					model.setCntrMfDesc(cntrMfDesc[i]);
				if (ediSndStsCd[i] != null)
					model.setEdiSndStsCd(ediSndStsCd[i]);
				if (mfSndDt[i] != null)
					model.setMfSndDt(mfSndDt[i]);
				if (cntrWgtUtCd[i] != null)
					model.setCntrWgtUtCd(cntrWgtUtCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (ntfyAddr[i] != null)
					model.setNtfyAddr(ntfyAddr[i]);
				if (preRlyPortCd[i] != null)
					model.setPreRlyPortCd(preRlyPortCd[i]);
				if (blNo2[i] != null)
					model.setBlNo2(blNo2[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (blDatCfmDt[i] != null)
					model.setBlDatCfmDt(blDatCfmDt[i]);
				if (rtmReMsgStsCd[i] != null)
					model.setRtmReMsgStsCd(rtmReMsgStsCd[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (cstmsDeclUsrId[i] != null)
					model.setCstmsDeclUsrId(cstmsDeclUsrId[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (t1DocCd[i] != null)
					model.setT1DocCd(t1DocCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (pstRlyPortCd[i] != null)
					model.setPstRlyPortCd(pstRlyPortCd[i]);
				if (rtmSndStsCd[i] != null)
					model.setRtmSndStsCd(rtmSndStsCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRocsManifestConfirmationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RocsSearchBlListVO[]
	 */
	public RocsManifestConfirmationVO[] getRocsManifestConfirmationVOs(){
		RocsManifestConfirmationVO[] vos = (RocsManifestConfirmationVO[])models.toArray(new RocsManifestConfirmationVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtFlag = this.mtFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bigoKind = this.bigoKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCrnNumber = this.frmCrnNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crnNumber = this.crnNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.datCfmFlg = this.datCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfWgt = this.cntrMfWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reMsgDt = this.reMsgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kind = this.kind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfDesc = this.cntrMfDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndStsCd = this.ediSndStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSndDt = this.mfSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgtUtCd = this.cntrWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr = this.ntfyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortCd = this.preRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo2 = this.blNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDatCfmDt = this.blDatCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtmReMsgStsCd = this.rtmReMsgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclUsrId = this.cstmsDeclUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t1DocCd = this.t1DocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPortCd = this.pstRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtmSndStsCd = this.rtmSndStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
