/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChinaBlGeneralListVO.java
*@FileTitle : ChinaBlGeneralListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.27
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.09.27 박성진
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo;

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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChinaBlGeneralListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ChinaBlGeneralListVO> models = new ArrayList<ChinaBlGeneralListVO>();

	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String etb = null;
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String rfSeqNo = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trspModId = null;
	/* Column Info */
	private String blIssDt = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String bkgPodCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trsmMsgTpId = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String mfSndDt = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String tempUnit = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cmdtDesc2 = null;
	/* Column Info */
	private String blObrdDt = null;
	/* Column Info */
	private String temp = null;
	/* Column Info */
	private String blMkDesc = null;
	/* Column Info */
	private String chnMfSndIndCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ChinaBlGeneralListVO() {}

	public ChinaBlGeneralListVO(String ibflag, String pagerows, String etb, String porCd, String eta, String rfSeqNo, String etd, String blNo, String bkgPodCd, String locCd, String polCd, String blIssDt, String trspModId, String trsmMsgTpId, String cstmsDesc, String mfSndDt, String measQty, String wgtUtCd, String pckQty, String portCd, String rcvTermCd, String measUtCd, String pckTpCd, String bkgPolCd, String frtTermCd, String delCd, String vslNm, String tempUnit, String actWgt, String podCd, String vvd, String deTermCd, String bkgNo, String cmdtDesc2, String blObrdDt, String temp, String blMkDesc, String chnMfSndIndCd, String bkgCgoTpCd) {
		this.porCd = porCd;
		this.etb = etb;
		this.eta = eta;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.rfSeqNo = rfSeqNo;
		this.etd = etd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.trspModId = trspModId;
		this.blIssDt = blIssDt;
		this.polCd = polCd;
		this.locCd = locCd;
		this.bkgPodCd = bkgPodCd;
		this.ibflag = ibflag;
		this.trsmMsgTpId = trsmMsgTpId;
		this.cstmsDesc = cstmsDesc;
		this.mfSndDt = mfSndDt;
		this.measQty = measQty;
		this.wgtUtCd = wgtUtCd;
		this.pckQty = pckQty;
		this.portCd = portCd;
		this.rcvTermCd = rcvTermCd;
		this.measUtCd = measUtCd;
		this.pckTpCd = pckTpCd;
		this.bkgPolCd = bkgPolCd;
		this.frtTermCd = frtTermCd;
		this.delCd = delCd;
		this.vslNm = vslNm;
		this.tempUnit = tempUnit;
		this.actWgt = actWgt;
		this.vvd = vvd;
		this.podCd = podCd;
		this.deTermCd = deTermCd;
		this.bkgNo = bkgNo;
		this.cmdtDesc2 = cmdtDesc2;
		this.blObrdDt = blObrdDt;
		this.temp = temp;
		this.blMkDesc = blMkDesc;
		this.chnMfSndIndCd = chnMfSndIndCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("etb", getEtb());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("rf_seq_no", getRfSeqNo());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trsp_mod_id", getTrspModId());
		this.hashColumns.put("bl_iss_dt", getBlIssDt());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trsm_msg_tp_id", getTrsmMsgTpId());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("mf_snd_dt", getMfSndDt());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("temp_unit", getTempUnit());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cmdt_desc2", getCmdtDesc2());
		this.hashColumns.put("bl_obrd_dt", getBlObrdDt());
		this.hashColumns.put("temp", getTemp());
		this.hashColumns.put("bl_mk_desc", getBlMkDesc());
		this.hashColumns.put("chn_mf_snd_ind_cd", getChnMfSndIndCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("etb", "etb");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("rf_seq_no", "rfSeqNo");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trsp_mod_id", "trspModId");
		this.hashFields.put("bl_iss_dt", "blIssDt");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trsm_msg_tp_id", "trsmMsgTpId");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("mf_snd_dt", "mfSndDt");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("temp_unit", "tempUnit");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cmdt_desc2", "cmdtDesc2");
		this.hashFields.put("bl_obrd_dt", "blObrdDt");
		this.hashFields.put("temp", "temp");
		this.hashFields.put("bl_mk_desc", "blMkDesc");
		this.hashFields.put("chn_mf_snd_ind_cd", "chnMfSndIndCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}

	/**
	 * Column Info
	 * @return etb
	 */
	public String getEtb() {
		return this.etb;
	}

	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
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
	 * @return rfSeqNo
	 */
	public String getRfSeqNo() {
		return this.rfSeqNo;
	}

	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
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
	 * @return trspModId
	 */
	public String getTrspModId() {
		return this.trspModId;
	}

	/**
	 * Column Info
	 * @return blIssDt
	 */
	public String getBlIssDt() {
		return this.blIssDt;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return trsmMsgTpId
	 */
	public String getTrsmMsgTpId() {
		return this.trsmMsgTpId;
	}

	/**
	 * Column Info
	 * @return cstmsDesc
	 */
	public String getCstmsDesc() {
		return this.cstmsDesc;
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
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
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
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}

	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
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
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
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
	 * @return bkgPolCd
	 */
	public String getBkgPolCd() {
		return this.bkgPolCd;
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
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}

	/**
	 * Column Info
	 * @return tempUnit
	 */
	public String getTempUnit() {
		return this.tempUnit;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return cmdtDesc2
	 */
	public String getCmdtDesc2() {
		return this.cmdtDesc2;
	}

	/**
	 * Column Info
	 * @return blObrdDt
	 */
	public String getBlObrdDt() {
		return this.blObrdDt;
	}

	/**
	 * Column Info
	 * @return temp
	 */
	public String getTemp() {
		return this.temp;
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
	 * @return chnMfSndIndCd
	 */
	public String getChnMfSndIndCd() {
		return this.chnMfSndIndCd;
	}


	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}

	/**
	 * Column Info
	 * @param etb
	 */
	public void setEtb(String etb) {
		this.etb = etb;
	}

	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
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
	 * @param rfSeqNo
	 */
	public void setRfSeqNo(String rfSeqNo) {
		this.rfSeqNo = rfSeqNo;
	}

	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
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
	 * @param trspModId
	 */
	public void setTrspModId(String trspModId) {
		this.trspModId = trspModId;
	}

	/**
	 * Column Info
	 * @param blIssDt
	 */
	public void setBlIssDt(String blIssDt) {
		this.blIssDt = blIssDt;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param trsmMsgTpId
	 */
	public void setTrsmMsgTpId(String trsmMsgTpId) {
		this.trsmMsgTpId = trsmMsgTpId;
	}

	/**
	 * Column Info
	 * @param cstmsDesc
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
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
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
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
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}

	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
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
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
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
	 * @param bkgPolCd
	 */
	public void setBkgPolCd(String bkgPolCd) {
		this.bkgPolCd = bkgPolCd;
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
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}

	/**
	 * Column Info
	 * @param tempUnit
	 */
	public void setTempUnit(String tempUnit) {
		this.tempUnit = tempUnit;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param cmdtDesc2
	 */
	public void setCmdtDesc2(String cmdtDesc2) {
		this.cmdtDesc2 = cmdtDesc2;
	}

	/**
	 * Column Info
	 * @param blObrdDt
	 */
	public void setBlObrdDt(String blObrdDt) {
		this.blObrdDt = blObrdDt;
	}

	/**
	 * Column Info
	 * @param temp
	 */
	public void setTemp(String temp) {
		this.temp = temp;
	}

	/**
	 * Column Info
	 * @param blMkDesc
	 */
	public void setBlMkDesc(String blMkDesc) {
		this.blMkDesc = blMkDesc;
	}

	/**
	 * Column Info
	 * @param chnMfSndIndCd
	 */
	public void setChnMfSndIndCd(String chnMfSndIndCd) {
		this.chnMfSndIndCd = chnMfSndIndCd;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setEtb(JSPUtil.getParameter(request, prefix + "etb", ""));
		setEta(JSPUtil.getParameter(request, prefix + "eta", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setRfSeqNo(JSPUtil.getParameter(request, prefix + "rf_seq_no", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTrspModId(JSPUtil.getParameter(request, prefix + "trsp_mod_id", ""));
		setBlIssDt(JSPUtil.getParameter(request, prefix + "bl_iss_dt", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setBkgPodCd(JSPUtil.getParameter(request, prefix + "bkg_pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTrsmMsgTpId(JSPUtil.getParameter(request, prefix + "trsm_msg_tp_id", ""));
		setCstmsDesc(JSPUtil.getParameter(request, prefix + "cstms_desc", ""));
		setMfSndDt(JSPUtil.getParameter(request, prefix + "mf_snd_dt", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setBkgPolCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cd", ""));
		setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setTempUnit(JSPUtil.getParameter(request, prefix + "temp_unit", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCmdtDesc2(JSPUtil.getParameter(request, prefix + "cmdt_desc2", ""));
		setBlObrdDt(JSPUtil.getParameter(request, prefix + "bl_obrd_dt", ""));
		setTemp(JSPUtil.getParameter(request, prefix + "temp", ""));
		setBlMkDesc(JSPUtil.getParameter(request, prefix + "bl_mk_desc", ""));
		setChnMfSndIndCd(JSPUtil.getParameter(request, prefix + "chn_mf_snd_ind_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaBlGeneralListVO[]
	 */
	public ChinaBlGeneralListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ChinaBlGeneralListVO[]
	 */
	public ChinaBlGeneralListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChinaBlGeneralListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] etb = (JSPUtil.getParameter(request, prefix	+ "etb", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] rfSeqNo = (JSPUtil.getParameter(request, prefix	+ "rf_seq_no", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trspModId = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_id", length));
			String[] blIssDt = (JSPUtil.getParameter(request, prefix	+ "bl_iss_dt", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] bkgPodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trsmMsgTpId = (JSPUtil.getParameter(request, prefix	+ "trsm_msg_tp_id", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] mfSndDt = (JSPUtil.getParameter(request, prefix	+ "mf_snd_dt", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] tempUnit = (JSPUtil.getParameter(request, prefix	+ "temp_unit", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cmdtDesc2 = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc2", length));
			String[] blObrdDt = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt", length));
			String[] temp = (JSPUtil.getParameter(request, prefix	+ "temp", length));
			String[] blMkDesc = (JSPUtil.getParameter(request, prefix	+ "bl_mk_desc", length));
			String[] chnMfSndIndCd = (JSPUtil.getParameter(request, prefix	+ "chn_mf_snd_ind_cd", length));

			for (int i = 0; i < length; i++) {
				model = new ChinaBlGeneralListVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (etb[i] != null)
					model.setEtb(etb[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (rfSeqNo[i] != null)
					model.setRfSeqNo(rfSeqNo[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trspModId[i] != null)
					model.setTrspModId(trspModId[i]);
				if (blIssDt[i] != null)
					model.setBlIssDt(blIssDt[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (bkgPodCd[i] != null)
					model.setBkgPodCd(bkgPodCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trsmMsgTpId[i] != null)
					model.setTrsmMsgTpId(trsmMsgTpId[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (mfSndDt[i] != null)
					model.setMfSndDt(mfSndDt[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (tempUnit[i] != null)
					model.setTempUnit(tempUnit[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cmdtDesc2[i] != null)
					model.setCmdtDesc2(cmdtDesc2[i]);
				if (blObrdDt[i] != null)
					model.setBlObrdDt(blObrdDt[i]);
				if (temp[i] != null)
					model.setTemp(temp[i]);
				if (blMkDesc[i] != null)
					model.setBlMkDesc(blMkDesc[i]);
				if (chnMfSndIndCd[i] != null)
					model.setChnMfSndIndCd(chnMfSndIndCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChinaBlGeneralListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChinaBlGeneralListVO[]
	 */
	public ChinaBlGeneralListVO[] getChinaBlGeneralListVOs(){
		ChinaBlGeneralListVO[] vos = (ChinaBlGeneralListVO[])models.toArray(new ChinaBlGeneralListVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etb = this.etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfSeqNo = this.rfSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModId = this.trspModId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssDt = this.blIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd = this.bkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmMsgTpId = this.trsmMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSndDt = this.mfSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempUnit = this.tempUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc2 = this.cmdtDesc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDt = this.blObrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.temp = this.temp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blMkDesc = this.blMkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnMfSndIndCd = this.chnMfSndIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
