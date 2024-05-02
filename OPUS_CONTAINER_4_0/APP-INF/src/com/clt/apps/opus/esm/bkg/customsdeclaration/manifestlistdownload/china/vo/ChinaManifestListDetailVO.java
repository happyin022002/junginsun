/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChinaManifestListDetailVO.java
*@FileTitle : ChinaManifestListDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.vo;

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
 * @see com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO
 */

public class ChinaManifestListDetailVO extends com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChinaManifestListDetailVO> models = new ArrayList<ChinaManifestListDetailVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String cneeAddr = null;
	/* Column Info */
	private String tr = null;
	/* Column Info */
	private String sealerCdFlg = null;
	/* Column Info */
	private String dlFlg = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mfDlDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String trsmMsgTpId = null;
	/* Column Info */
	private String shprAddr = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String mfSndDt = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String oVvd = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String prePort = null;
	/* Column Info */
	private String ntfyAddr = null;
	/* Column Info */
	private String sealKndFlg = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cntrCnt = null;
	/* Column Info */
	private String dlChkFlg = null;
	/* Column Info */
	private String vvd2 = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String nxtPort = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String transMode = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String sealNoFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ChinaManifestListDetailVO() {}

	public ChinaManifestListDetailVO(String ibflag, String pagerows, String actWgt, String bkgCgoTpCd, String bkgNo, String blNo, String callSgnNo, String cneeAddr, String cneeNm, String cntrCnt, String cntrTpszCd, String dcgoFlg, String delCd, String dlChkFlg, String dlFlg, String locCd, String mfDlDt, String mfSndDt, String ntfyAddr, String ntfyNm, String nxtPort, String pckQty, String pckTpCd, String podCd, String polCd, String prePort, String rcFlg, String sealerCdFlg, String sealKndFlg, String sealNoFlg, String shprAddr, String shprNm, String total, String tr, String transMode, String trsmMsgTpId, String vpsEtaDt, String vpsEtbDt, String vpsEtdDt, String vslEngNm, String vvd, String vvd2, String oVvd, String wgtUtCd) {
		this.total = total;
		this.vpsEtbDt = vpsEtbDt;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.cneeAddr = cneeAddr;
		this.tr = tr;
		this.sealerCdFlg = sealerCdFlg;
		this.dlFlg = dlFlg;
		this.vpsEtaDt = vpsEtaDt;
		this.blNo = blNo;
		this.mfDlDt = mfDlDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.polCd = polCd;
		this.trsmMsgTpId = trsmMsgTpId;
		this.shprAddr = shprAddr;
		this.vslEngNm = vslEngNm;
		this.mfSndDt = mfSndDt;
		this.wgtUtCd = wgtUtCd;
		this.dcgoFlg = dcgoFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.pckQty = pckQty;
		this.oVvd = oVvd;
		this.shprNm = shprNm;
		this.pckTpCd = pckTpCd;
		this.prePort = prePort;
		this.ntfyAddr = ntfyAddr;
		this.sealKndFlg = sealKndFlg;
		this.vpsEtdDt = vpsEtdDt;
		this.callSgnNo = callSgnNo;
		this.delCd = delCd;
		this.cntrCnt = cntrCnt;
		this.dlChkFlg = dlChkFlg;
		this.vvd2 = vvd2;
		this.ntfyNm = ntfyNm;
		this.actWgt = actWgt;
		this.nxtPort = nxtPort;
		this.vvd = vvd;
		this.podCd = podCd;
		this.transMode = transMode;
		this.cneeNm = cneeNm;
		this.bkgNo = bkgNo;
		this.rcFlg = rcFlg;
		this.sealNoFlg = sealNoFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("cnee_addr", getCneeAddr());
		this.hashColumns.put("tr", getTr());
		this.hashColumns.put("sealer_cd_flg", getSealerCdFlg());
		this.hashColumns.put("dl_flg", getDlFlg());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mf_dl_dt", getMfDlDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("trsm_msg_tp_id", getTrsmMsgTpId());
		this.hashColumns.put("shpr_addr", getShprAddr());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("mf_snd_dt", getMfSndDt());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("o_vvd", getOVvd());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("pre_port", getPrePort());
		this.hashColumns.put("ntfy_addr", getNtfyAddr());
		this.hashColumns.put("seal_knd_flg", getSealKndFlg());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cntr_cnt", getCntrCnt());
		this.hashColumns.put("dl_chk_flg", getDlChkFlg());
		this.hashColumns.put("vvd2", getVvd2());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("nxt_port", getNxtPort());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("trans_mode", getTransMode());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("seal_no_flg", getSealNoFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("cnee_addr", "cneeAddr");
		this.hashFields.put("tr", "tr");
		this.hashFields.put("sealer_cd_flg", "sealerCdFlg");
		this.hashFields.put("dl_flg", "dlFlg");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mf_dl_dt", "mfDlDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("trsm_msg_tp_id", "trsmMsgTpId");
		this.hashFields.put("shpr_addr", "shprAddr");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("mf_snd_dt", "mfSndDt");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("o_vvd", "oVvd");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("pre_port", "prePort");
		this.hashFields.put("ntfy_addr", "ntfyAddr");
		this.hashFields.put("seal_knd_flg", "sealKndFlg");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cntr_cnt", "cntrCnt");
		this.hashFields.put("dl_chk_flg", "dlChkFlg");
		this.hashFields.put("vvd2", "vvd2");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("nxt_port", "nxtPort");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("trans_mode", "transMode");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("seal_no_flg", "sealNoFlg");
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
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
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
	 * @return sealerCdFlg
	 */
	public String getSealerCdFlg() {
		return this.sealerCdFlg;
	}
	
	/**
	 * Column Info
	 * @return dlFlg
	 */
	public String getDlFlg() {
		return this.dlFlg;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return mfDlDt
	 */
	public String getMfDlDt() {
		return this.mfDlDt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return trsmMsgTpId
	 */
	public String getTrsmMsgTpId() {
		return this.trsmMsgTpId;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return oVvd
	 */
	public String getOVvd() {
		return this.oVvd;
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
	 * @return sealKndFlg
	 */
	public String getSealKndFlg() {
		return this.sealKndFlg;
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
	 * @return dlChkFlg
	 */
	public String getDlChkFlg() {
		return this.dlChkFlg;
	}
	
	/**
	 * Column Info
	 * @return vvd2
	 */
	public String getVvd2() {
		return this.vvd2;
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
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
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
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
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
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
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
	 * @param sealerCdFlg
	 */
	public void setSealerCdFlg(String sealerCdFlg) {
		this.sealerCdFlg = sealerCdFlg;
	}
	
	/**
	 * Column Info
	 * @param dlFlg
	 */
	public void setDlFlg(String dlFlg) {
		this.dlFlg = dlFlg;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param mfDlDt
	 */
	public void setMfDlDt(String mfDlDt) {
		this.mfDlDt = mfDlDt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param trsmMsgTpId
	 */
	public void setTrsmMsgTpId(String trsmMsgTpId) {
		this.trsmMsgTpId = trsmMsgTpId;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param oVvd
	 */
	public void setOVvd(String oVvd) {
		this.oVvd = oVvd;
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
	 * @param sealKndFlg
	 */
	public void setSealKndFlg(String sealKndFlg) {
		this.sealKndFlg = sealKndFlg;
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
	 * @param dlChkFlg
	 */
	public void setDlChkFlg(String dlChkFlg) {
		this.dlChkFlg = dlChkFlg;
	}
	
	/**
	 * Column Info
	 * @param vvd2
	 */
	public void setVvd2(String vvd2) {
		this.vvd2 = vvd2;
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
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
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
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
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
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setCneeAddr(JSPUtil.getParameter(request, prefix + "cnee_addr", ""));
		setTr(JSPUtil.getParameter(request, prefix + "tr", ""));
		setSealerCdFlg(JSPUtil.getParameter(request, prefix + "sealer_cd_flg", ""));
		setDlFlg(JSPUtil.getParameter(request, prefix + "dl_flg", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setMfDlDt(JSPUtil.getParameter(request, prefix + "mf_dl_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setTrsmMsgTpId(JSPUtil.getParameter(request, prefix + "trsm_msg_tp_id", ""));
		setShprAddr(JSPUtil.getParameter(request, prefix + "shpr_addr", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setMfSndDt(JSPUtil.getParameter(request, prefix + "mf_snd_dt", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setOVvd(JSPUtil.getParameter(request, prefix + "o_vvd", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setPrePort(JSPUtil.getParameter(request, prefix + "pre_port", ""));
		setNtfyAddr(JSPUtil.getParameter(request, prefix + "ntfy_addr", ""));
		setSealKndFlg(JSPUtil.getParameter(request, prefix + "seal_knd_flg", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCntrCnt(JSPUtil.getParameter(request, prefix + "cntr_cnt", ""));
		setDlChkFlg(JSPUtil.getParameter(request, prefix + "dl_chk_flg", ""));
		setVvd2(JSPUtil.getParameter(request, prefix + "vvd2", ""));
		setNtfyNm(JSPUtil.getParameter(request, prefix + "ntfy_nm", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setNxtPort(JSPUtil.getParameter(request, prefix + "nxt_port", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setTransMode(JSPUtil.getParameter(request, prefix + "trans_mode", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setSealNoFlg(JSPUtil.getParameter(request, prefix + "seal_no_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaManifestListDetailVO[]
	 */
	public ChinaManifestListDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChinaManifestListDetailVO[]
	 */
	public ChinaManifestListDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChinaManifestListDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] cneeAddr = (JSPUtil.getParameter(request, prefix	+ "cnee_addr", length));
			String[] tr = (JSPUtil.getParameter(request, prefix	+ "tr", length));
			String[] sealerCdFlg = (JSPUtil.getParameter(request, prefix	+ "sealer_cd_flg", length));
			String[] dlFlg = (JSPUtil.getParameter(request, prefix	+ "dl_flg", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] mfDlDt = (JSPUtil.getParameter(request, prefix	+ "mf_dl_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] trsmMsgTpId = (JSPUtil.getParameter(request, prefix	+ "trsm_msg_tp_id", length));
			String[] shprAddr = (JSPUtil.getParameter(request, prefix	+ "shpr_addr", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] mfSndDt = (JSPUtil.getParameter(request, prefix	+ "mf_snd_dt", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] oVvd = (JSPUtil.getParameter(request, prefix	+ "o_vvd", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] prePort = (JSPUtil.getParameter(request, prefix	+ "pre_port", length));
			String[] ntfyAddr = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr", length));
			String[] sealKndFlg = (JSPUtil.getParameter(request, prefix	+ "seal_knd_flg", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cntrCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_cnt", length));
			String[] dlChkFlg = (JSPUtil.getParameter(request, prefix	+ "dl_chk_flg", length));
			String[] vvd2 = (JSPUtil.getParameter(request, prefix	+ "vvd2", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] nxtPort = (JSPUtil.getParameter(request, prefix	+ "nxt_port", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] transMode = (JSPUtil.getParameter(request, prefix	+ "trans_mode", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] sealNoFlg = (JSPUtil.getParameter(request, prefix	+ "seal_no_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChinaManifestListDetailVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (cneeAddr[i] != null)
					model.setCneeAddr(cneeAddr[i]);
				if (tr[i] != null)
					model.setTr(tr[i]);
				if (sealerCdFlg[i] != null)
					model.setSealerCdFlg(sealerCdFlg[i]);
				if (dlFlg[i] != null)
					model.setDlFlg(dlFlg[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mfDlDt[i] != null)
					model.setMfDlDt(mfDlDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (trsmMsgTpId[i] != null)
					model.setTrsmMsgTpId(trsmMsgTpId[i]);
				if (shprAddr[i] != null)
					model.setShprAddr(shprAddr[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (mfSndDt[i] != null)
					model.setMfSndDt(mfSndDt[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (oVvd[i] != null)
					model.setOVvd(oVvd[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (prePort[i] != null)
					model.setPrePort(prePort[i]);
				if (ntfyAddr[i] != null)
					model.setNtfyAddr(ntfyAddr[i]);
				if (sealKndFlg[i] != null)
					model.setSealKndFlg(sealKndFlg[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cntrCnt[i] != null)
					model.setCntrCnt(cntrCnt[i]);
				if (dlChkFlg[i] != null)
					model.setDlChkFlg(dlChkFlg[i]);
				if (vvd2[i] != null)
					model.setVvd2(vvd2[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (nxtPort[i] != null)
					model.setNxtPort(nxtPort[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (transMode[i] != null)
					model.setTransMode(transMode[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (sealNoFlg[i] != null)
					model.setSealNoFlg(sealNoFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChinaManifestListDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChinaManifestListDetailVO[]
	 */
	public ChinaManifestListDetailVO[] getChinaManifestListDetailVOs(){
		ChinaManifestListDetailVO[] vos = (ChinaManifestListDetailVO[])models.toArray(new ChinaManifestListDetailVO[models.size()]);
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
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr = this.cneeAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tr = this.tr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealerCdFlg = this.sealerCdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlFlg = this.dlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfDlDt = this.mfDlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmMsgTpId = this.trsmMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr = this.shprAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSndDt = this.mfSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oVvd = this.oVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePort = this.prePort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr = this.ntfyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealKndFlg = this.sealKndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCnt = this.cntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlChkFlg = this.dlChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2 = this.vvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPort = this.nxtPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transMode = this.transMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNoFlg = this.sealNoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
