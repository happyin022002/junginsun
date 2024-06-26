/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RussiaBlInfoListVO.java
*@FileTitle : RussiaBlInfoListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RussiaBlInfoListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RussiaBlInfoListVO> models = new ArrayList<RussiaBlInfoListVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String cneeAddr = null;
	/* Column Info */
	private String tr = null;
	/* Column Info */
	private String cmPckQty = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String bkgPodCd = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cntrCnt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String transMode = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String sealNoFlg = null;
	/* Column Info */
	private String etdFlg = null;
	/* Column Info */
	private String etaFlg = null;
	/* Column Info */
	private String sndDate = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String sealerCdFlg = null;
	/* Column Info */
	private String meaQty = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String shprAddr = null;
	/* Column Info */
	private String trsmMsgTpId = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String mfSndDt = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String prePort = null;
	/* Column Info */
	private String ntfyAddr = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String sealKndFlg = null;
	/* Column Info */
	private String cntcPsonTelcmNo = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String nxtPort = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String cmPckTpCd = null;
	/* Column Info */
	private String cmCntrMfWgt = null;
	/* Column Info */
	private String blMkDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RussiaBlInfoListVO() {}

	public RussiaBlInfoListVO(String ibflag, String pagerows, String total, String etaFlg, String sndDate, String vpsEtbDt, String bkgCgoTpCd, String cneeAddr, String tr, String sealerCdFlg, String vpsEtaDt, String blNo, String locCd, String bkgPodCd, String polCd, String trsmMsgTpId, String shprAddr, String vslEngNm, String mfSndDt, String wgtUtCd, String dcgoFlg, String pckQty, String shprNm, String pckTpCd, String prePort, String ntfyAddr, String bkgPolCd, String vpsEtdDt, String callSgnNo, String delCd, String cntrCnt, String ntfyNm, String nxtPort, String actWgt, String vvd, String podCd, String transMode, String bkgNo, String cneeNm, String rcFlg, String sealNoFlg, String sealKndFlg, String etdFlg, String meaQty, String cntcPsonNm, String cntcPsonTelcmNo, String imdgUnNo, String frtTermCd, String rcvTermCd, String deTermCd, String blMkDesc, String cmPckQty, String cmPckTpCd, String cmCntrMfWgt) {
		this.total = total;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.cneeAddr = cneeAddr;
		this.tr = tr;
		this.cmPckQty = cmPckQty;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.bkgPodCd = bkgPodCd;
		this.locCd = locCd;
		this.wgtUtCd = wgtUtCd;
		this.imdgUnNo = imdgUnNo;
		this.vpsEtdDt = vpsEtdDt;
		this.callSgnNo = callSgnNo;
		this.frtTermCd = frtTermCd;
		this.delCd = delCd;
		this.cntrCnt = cntrCnt;
		this.vvd = vvd;
		this.podCd = podCd;
		this.transMode = transMode;
		this.bkgNo = bkgNo;
		this.rcFlg = rcFlg;
		this.sealNoFlg = sealNoFlg;
		this.etdFlg = etdFlg;
		this.etaFlg = etaFlg;
		this.sndDate = sndDate;
		this.vpsEtbDt = vpsEtbDt;
		this.sealerCdFlg = sealerCdFlg;
		this.meaQty = meaQty;
		this.vpsEtaDt = vpsEtaDt;
		this.ibflag = ibflag;
		this.shprAddr = shprAddr;
		this.trsmMsgTpId = trsmMsgTpId;
		this.vslEngNm = vslEngNm;
		this.mfSndDt = mfSndDt;
		this.cntcPsonNm = cntcPsonNm;
		this.dcgoFlg = dcgoFlg;
		this.pckQty = pckQty;
		this.rcvTermCd = rcvTermCd;
		this.shprNm = shprNm;
		this.pckTpCd = pckTpCd;
		this.prePort = prePort;
		this.ntfyAddr = ntfyAddr;
		this.bkgPolCd = bkgPolCd;
		this.sealKndFlg = sealKndFlg;
		this.cntcPsonTelcmNo = cntcPsonTelcmNo;
		this.ntfyNm = ntfyNm;
		this.nxtPort = nxtPort;
		this.actWgt = actWgt;
		this.deTermCd = deTermCd;
		this.cneeNm = cneeNm;
		this.cmPckTpCd = cmPckTpCd;
		this.cmCntrMfWgt = cmCntrMfWgt;
		this.blMkDesc = blMkDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("cnee_addr", getCneeAddr());
		this.hashColumns.put("tr", getTr());
		this.hashColumns.put("cm_pck_qty", getCmPckQty());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cntr_cnt", getCntrCnt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("trans_mode", getTransMode());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("seal_no_flg", getSealNoFlg());
		this.hashColumns.put("etd_flg", getEtdFlg());
		this.hashColumns.put("eta_flg", getEtaFlg());
		this.hashColumns.put("snd_date", getSndDate());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("sealer_cd_flg", getSealerCdFlg());
		this.hashColumns.put("mea_qty", getMeaQty());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("shpr_addr", getShprAddr());
		this.hashColumns.put("trsm_msg_tp_id", getTrsmMsgTpId());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("mf_snd_dt", getMfSndDt());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("pre_port", getPrePort());
		this.hashColumns.put("ntfy_addr", getNtfyAddr());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("seal_knd_flg", getSealKndFlg());
		this.hashColumns.put("cntc_pson_telcm_no", getCntcPsonTelcmNo());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("nxt_port", getNxtPort());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("cm_pck_tp_cd", getCmPckTpCd());
		this.hashColumns.put("cm_cntr_mf_wgt", getCmCntrMfWgt());
		this.hashColumns.put("bl_mk_desc", getBlMkDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("cnee_addr", "cneeAddr");
		this.hashFields.put("tr", "tr");
		this.hashFields.put("cm_pck_qty", "cmPckQty");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cntr_cnt", "cntrCnt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("trans_mode", "transMode");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("seal_no_flg", "sealNoFlg");
		this.hashFields.put("etd_flg", "etdFlg");
		this.hashFields.put("eta_flg", "etaFlg");
		this.hashFields.put("snd_date", "sndDate");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("sealer_cd_flg", "sealerCdFlg");
		this.hashFields.put("mea_qty", "meaQty");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("shpr_addr", "shprAddr");
		this.hashFields.put("trsm_msg_tp_id", "trsmMsgTpId");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("mf_snd_dt", "mfSndDt");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("pre_port", "prePort");
		this.hashFields.put("ntfy_addr", "ntfyAddr");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("seal_knd_flg", "sealKndFlg");
		this.hashFields.put("cntc_pson_telcm_no", "cntcPsonTelcmNo");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("nxt_port", "nxtPort");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("cm_pck_tp_cd", "cmPckTpCd");
		this.hashFields.put("cm_cntr_mf_wgt", "cmCntrMfWgt");
		this.hashFields.put("bl_mk_desc", "blMkDesc");
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
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return cneeAddr
	 */
	public String getCneeAddr() {
		return this.cneeAddr;
	}
	
	/**
	 * Column Info
	 * @return tr
	 */
	public String getTr() {
		return this.tr;
	}
	
	/**
	 * Column Info
	 * @return cmPckQty
	 */
	public String getCmPckQty() {
		return this.cmPckQty;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
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
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
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
	 * @return cntrCnt
	 */
	public String getCntrCnt() {
		return this.cntrCnt;
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
	 * @return transMode
	 */
	public String getTransMode() {
		return this.transMode;
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
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return sealNoFlg
	 */
	public String getSealNoFlg() {
		return this.sealNoFlg;
	}
	
	/**
	 * Column Info
	 * @return etdFlg
	 */
	public String getEtdFlg() {
		return this.etdFlg;
	}
	
	/**
	 * Column Info
	 * @return etaFlg
	 */
	public String getEtaFlg() {
		return this.etaFlg;
	}
	
	/**
	 * Column Info
	 * @return sndDate
	 */
	public String getSndDate() {
		return this.sndDate;
	}
	
	/**
	 * Column Info
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return sealerCdFlg
	 */
	public String getSealerCdFlg() {
		return this.sealerCdFlg;
	}
	
	/**
	 * Column Info
	 * @return meaQty
	 */
	public String getMeaQty() {
		return this.meaQty;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
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
	 * @return shprAddr
	 */
	public String getShprAddr() {
		return this.shprAddr;
	}
	
	/**
	 * Column Info
	 * @return trsmMsgTpId
	 */
	public String getTrsmMsgTpId() {
		return this.trsmMsgTpId;
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
	 * @return mfSndDt
	 */
	public String getMfSndDt() {
		return this.mfSndDt;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
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
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
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
	 * @return prePort
	 */
	public String getPrePort() {
		return this.prePort;
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
	 * @return bkgPolCd
	 */
	public String getBkgPolCd() {
		return this.bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @return sealKndFlg
	 */
	public String getSealKndFlg() {
		return this.sealKndFlg;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonTelcmNo
	 */
	public String getCntcPsonTelcmNo() {
		return this.cntcPsonTelcmNo;
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
	 * @return nxtPort
	 */
	public String getNxtPort() {
		return this.nxtPort;
	}
	
	/**
	 * Column Info
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return cmPckTpCd
	 */
	public String getCmPckTpCd() {
		return this.cmPckTpCd;
	}
	
	/**
	 * Column Info
	 * @return cmCntrMfWgt
	 */
	public String getCmCntrMfWgt() {
		return this.cmCntrMfWgt;
	}
	
	/**
	 * Column Info
	 * @return blMkDesc
	 */
	public String getBlMkDesc() {
		return this.blMkDesc;
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
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param cneeAddr
	 */
	public void setCneeAddr(String cneeAddr) {
		this.cneeAddr = cneeAddr;
	}
	
	/**
	 * Column Info
	 * @param tr
	 */
	public void setTr(String tr) {
		this.tr = tr;
	}
	
	/**
	 * Column Info
	 * @param cmPckQty
	 */
	public void setCmPckQty(String cmPckQty) {
		this.cmPckQty = cmPckQty;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
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
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
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
	 * @param cntrCnt
	 */
	public void setCntrCnt(String cntrCnt) {
		this.cntrCnt = cntrCnt;
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
	 * @param transMode
	 */
	public void setTransMode(String transMode) {
		this.transMode = transMode;
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
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param sealNoFlg
	 */
	public void setSealNoFlg(String sealNoFlg) {
		this.sealNoFlg = sealNoFlg;
	}
	
	/**
	 * Column Info
	 * @param etdFlg
	 */
	public void setEtdFlg(String etdFlg) {
		this.etdFlg = etdFlg;
	}
	
	/**
	 * Column Info
	 * @param etaFlg
	 */
	public void setEtaFlg(String etaFlg) {
		this.etaFlg = etaFlg;
	}
	
	/**
	 * Column Info
	 * @param sndDate
	 */
	public void setSndDate(String sndDate) {
		this.sndDate = sndDate;
	}
	
	/**
	 * Column Info
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param sealerCdFlg
	 */
	public void setSealerCdFlg(String sealerCdFlg) {
		this.sealerCdFlg = sealerCdFlg;
	}
	
	/**
	 * Column Info
	 * @param meaQty
	 */
	public void setMeaQty(String meaQty) {
		this.meaQty = meaQty;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
	 * @param shprAddr
	 */
	public void setShprAddr(String shprAddr) {
		this.shprAddr = shprAddr;
	}
	
	/**
	 * Column Info
	 * @param trsmMsgTpId
	 */
	public void setTrsmMsgTpId(String trsmMsgTpId) {
		this.trsmMsgTpId = trsmMsgTpId;
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
	 * @param mfSndDt
	 */
	public void setMfSndDt(String mfSndDt) {
		this.mfSndDt = mfSndDt;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
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
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
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
	 * @param prePort
	 */
	public void setPrePort(String prePort) {
		this.prePort = prePort;
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
	 * @param bkgPolCd
	 */
	public void setBkgPolCd(String bkgPolCd) {
		this.bkgPolCd = bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @param sealKndFlg
	 */
	public void setSealKndFlg(String sealKndFlg) {
		this.sealKndFlg = sealKndFlg;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonTelcmNo
	 */
	public void setCntcPsonTelcmNo(String cntcPsonTelcmNo) {
		this.cntcPsonTelcmNo = cntcPsonTelcmNo;
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
	 * @param nxtPort
	 */
	public void setNxtPort(String nxtPort) {
		this.nxtPort = nxtPort;
	}
	
	/**
	 * Column Info
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param cmPckTpCd
	 */
	public void setCmPckTpCd(String cmPckTpCd) {
		this.cmPckTpCd = cmPckTpCd;
	}
	
	/**
	 * Column Info
	 * @param cmCntrMfWgt
	 */
	public void setCmCntrMfWgt(String cmCntrMfWgt) {
		this.cmCntrMfWgt = cmCntrMfWgt;
	}
	
	/**
	 * Column Info
	 * @param blMkDesc
	 */
	public void setBlMkDesc(String blMkDesc) {
		this.blMkDesc = blMkDesc;
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
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setCneeAddr(JSPUtil.getParameter(request, prefix + "cnee_addr", ""));
		setTr(JSPUtil.getParameter(request, prefix + "tr", ""));
		setCmPckQty(JSPUtil.getParameter(request, prefix + "cm_pck_qty", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setBkgPodCd(JSPUtil.getParameter(request, prefix + "bkg_pod_cd", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCntrCnt(JSPUtil.getParameter(request, prefix + "cntr_cnt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setTransMode(JSPUtil.getParameter(request, prefix + "trans_mode", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setSealNoFlg(JSPUtil.getParameter(request, prefix + "seal_no_flg", ""));
		setEtdFlg(JSPUtil.getParameter(request, prefix + "etd_flg", ""));
		setEtaFlg(JSPUtil.getParameter(request, prefix + "eta_flg", ""));
		setSndDate(JSPUtil.getParameter(request, prefix + "snd_date", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setSealerCdFlg(JSPUtil.getParameter(request, prefix + "sealer_cd_flg", ""));
		setMeaQty(JSPUtil.getParameter(request, prefix + "mea_qty", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setShprAddr(JSPUtil.getParameter(request, prefix + "shpr_addr", ""));
		setTrsmMsgTpId(JSPUtil.getParameter(request, prefix + "trsm_msg_tp_id", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setMfSndDt(JSPUtil.getParameter(request, prefix + "mf_snd_dt", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, prefix + "cntc_pson_nm", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setPrePort(JSPUtil.getParameter(request, prefix + "pre_port", ""));
		setNtfyAddr(JSPUtil.getParameter(request, prefix + "ntfy_addr", ""));
		setBkgPolCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cd", ""));
		setSealKndFlg(JSPUtil.getParameter(request, prefix + "seal_knd_flg", ""));
		setCntcPsonTelcmNo(JSPUtil.getParameter(request, prefix + "cntc_pson_telcm_no", ""));
		setNtfyNm(JSPUtil.getParameter(request, prefix + "ntfy_nm", ""));
		setNxtPort(JSPUtil.getParameter(request, prefix + "nxt_port", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setCmPckTpCd(JSPUtil.getParameter(request, prefix + "cm_pck_tp_cd", ""));
		setCmCntrMfWgt(JSPUtil.getParameter(request, prefix + "cm_cntr_mf_wgt", ""));
		setBlMkDesc(JSPUtil.getParameter(request, prefix + "bl_mk_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RussiaBlInfoListVO[]
	 */
	public RussiaBlInfoListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RussiaBlInfoListVO[]
	 */
	public RussiaBlInfoListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RussiaBlInfoListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] cneeAddr = (JSPUtil.getParameter(request, prefix	+ "cnee_addr", length));
			String[] tr = (JSPUtil.getParameter(request, prefix	+ "tr", length));
			String[] cmPckQty = (JSPUtil.getParameter(request, prefix	+ "cm_pck_qty", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] bkgPodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cntrCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_cnt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] transMode = (JSPUtil.getParameter(request, prefix	+ "trans_mode", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] sealNoFlg = (JSPUtil.getParameter(request, prefix	+ "seal_no_flg", length));
			String[] etdFlg = (JSPUtil.getParameter(request, prefix	+ "etd_flg", length));
			String[] etaFlg = (JSPUtil.getParameter(request, prefix	+ "eta_flg", length));
			String[] sndDate = (JSPUtil.getParameter(request, prefix	+ "snd_date", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] sealerCdFlg = (JSPUtil.getParameter(request, prefix	+ "sealer_cd_flg", length));
			String[] meaQty = (JSPUtil.getParameter(request, prefix	+ "mea_qty", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] shprAddr = (JSPUtil.getParameter(request, prefix	+ "shpr_addr", length));
			String[] trsmMsgTpId = (JSPUtil.getParameter(request, prefix	+ "trsm_msg_tp_id", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] mfSndDt = (JSPUtil.getParameter(request, prefix	+ "mf_snd_dt", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] prePort = (JSPUtil.getParameter(request, prefix	+ "pre_port", length));
			String[] ntfyAddr = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] sealKndFlg = (JSPUtil.getParameter(request, prefix	+ "seal_knd_flg", length));
			String[] cntcPsonTelcmNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_telcm_no", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] nxtPort = (JSPUtil.getParameter(request, prefix	+ "nxt_port", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] cmPckTpCd = (JSPUtil.getParameter(request, prefix	+ "cm_pck_tp_cd", length));
			String[] cmCntrMfWgt = (JSPUtil.getParameter(request, prefix	+ "cm_cntr_mf_wgt", length));
			String[] blMkDesc = (JSPUtil.getParameter(request, prefix	+ "bl_mk_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new RussiaBlInfoListVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (cneeAddr[i] != null)
					model.setCneeAddr(cneeAddr[i]);
				if (tr[i] != null)
					model.setTr(tr[i]);
				if (cmPckQty[i] != null)
					model.setCmPckQty(cmPckQty[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (bkgPodCd[i] != null)
					model.setBkgPodCd(bkgPodCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cntrCnt[i] != null)
					model.setCntrCnt(cntrCnt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (transMode[i] != null)
					model.setTransMode(transMode[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (sealNoFlg[i] != null)
					model.setSealNoFlg(sealNoFlg[i]);
				if (etdFlg[i] != null)
					model.setEtdFlg(etdFlg[i]);
				if (etaFlg[i] != null)
					model.setEtaFlg(etaFlg[i]);
				if (sndDate[i] != null)
					model.setSndDate(sndDate[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (sealerCdFlg[i] != null)
					model.setSealerCdFlg(sealerCdFlg[i]);
				if (meaQty[i] != null)
					model.setMeaQty(meaQty[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (shprAddr[i] != null)
					model.setShprAddr(shprAddr[i]);
				if (trsmMsgTpId[i] != null)
					model.setTrsmMsgTpId(trsmMsgTpId[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (mfSndDt[i] != null)
					model.setMfSndDt(mfSndDt[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (prePort[i] != null)
					model.setPrePort(prePort[i]);
				if (ntfyAddr[i] != null)
					model.setNtfyAddr(ntfyAddr[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (sealKndFlg[i] != null)
					model.setSealKndFlg(sealKndFlg[i]);
				if (cntcPsonTelcmNo[i] != null)
					model.setCntcPsonTelcmNo(cntcPsonTelcmNo[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (nxtPort[i] != null)
					model.setNxtPort(nxtPort[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (cmPckTpCd[i] != null)
					model.setCmPckTpCd(cmPckTpCd[i]);
				if (cmCntrMfWgt[i] != null)
					model.setCmCntrMfWgt(cmCntrMfWgt[i]);
				if (blMkDesc[i] != null)
					model.setBlMkDesc(blMkDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRussiaBlInfoListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RussiaBlInfoListVO[]
	 */
	public RussiaBlInfoListVO[] getRussiaBlInfoListVOs(){
		RussiaBlInfoListVO[] vos = (RussiaBlInfoListVO[])models.toArray(new RussiaBlInfoListVO[models.size()]);
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
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr = this.cneeAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tr = this.tr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPckQty = this.cmPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd = this.bkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCnt = this.cntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transMode = this.transMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNoFlg = this.sealNoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdFlg = this.etdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaFlg = this.etaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDate = this.sndDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealerCdFlg = this.sealerCdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.meaQty = this.meaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr = this.shprAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmMsgTpId = this.trsmMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSndDt = this.mfSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePort = this.prePort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr = this.ntfyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealKndFlg = this.sealKndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonTelcmNo = this.cntcPsonTelcmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPort = this.nxtPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPckTpCd = this.cmPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmCntrMfWgt = this.cmCntrMfWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blMkDesc = this.blMkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
