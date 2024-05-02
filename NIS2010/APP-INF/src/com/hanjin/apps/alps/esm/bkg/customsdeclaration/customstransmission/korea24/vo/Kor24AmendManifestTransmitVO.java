/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileTitle : <Kor24AmendManifestTransmitVO.java
*@FileTitle : Kor24AmendManifestTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.10
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.12.10 박상훈
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.AmendManifestTransmitVO;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see AmendManifestTransmitVO
 */

public class Kor24AmendManifestTransmitVO extends AmendManifestTransmitVO {

	private static final long serialVersionUID = 1L;

	private Collection<Kor24AmendManifestTransmitVO> models = new ArrayList<Kor24AmendManifestTransmitVO>();

	/* Column Info */
	private String cancelFlg = null;
	/* Column Info */
	private String oldEtaDt = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String ttlMeasUtCd = null;
	/* Column Info */
	private String cstmsDchgCd = null;
	/* Column Info */
	private String mrnNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String callYear = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String callKnt = null;
	/* Column Info */
	private String vslCallSgnCd = null;
	/* Column Info */
	private String ttlPckQty = null;
	/* Column Info */
	private String inChgEta = null;
	/* Column Info */
	private String vslCntCd = null;
	/* Column Info */
	private String inChgPort = null;
	/* Column Info */
	private String joCrrKnt = null;
	/* Column Info */
	private String inChgComp = null;
	/* Column Info */
	private String ioTmlLocCd = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String bdAreaCd = null;
	/* Column Info */
	private String dchgMzdCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String inChgMeth = null;
	/* Column Info */
	private String ttlWgt = null;
	/* Column Info */
	private String ttlMeasQty = null;
	/* Column Info */
	private String ttlPckUtCd = null;
	/* Column Info */
	private String ktPa = null;
	private String loclCstmsCd = null;
	private String receiver = null;
	private String noneBlInType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public Kor24AmendManifestTransmitVO() {}

	public Kor24AmendManifestTransmitVO(String ibflag, String pagerows, String userId, String cancelFlg, String inChgMeth, String inChgPort, String inChgComp, String ofcCd, String podCd, String polCd, String ioBndCd, String ktPa, String callKnt, String vslCallSgnCd, String mrnNo, String vvd, String vslNm, String vslCntCd, String dchgMzdCd, String ioTmlLocCd, String blNo, String callYear, String ttlWgt, String ttlMeasQty, String bdAreaCd, String joCrrKnt, String ttlMeasUtCd, String ttlPckUtCd, String ttlPckQty, String cstmsDchgCd, String etaDt, String inChgEta, String oldEtaDt, String loclCstmsCd, String receiver, String noneBlInType) {
		this.cancelFlg = cancelFlg;
		this.etaDt = etaDt;
		this.oldEtaDt = oldEtaDt;
		this.ttlMeasUtCd = ttlMeasUtCd;
		this.cstmsDchgCd = cstmsDchgCd;
		this.mrnNo = mrnNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.callYear = callYear;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.userId = userId;
		this.callKnt = callKnt;
		this.vslCallSgnCd = vslCallSgnCd;
		this.ttlPckQty = ttlPckQty;
		this.inChgEta = inChgEta;
		this.vslCntCd = vslCntCd;
		this.inChgPort = inChgPort;
		this.joCrrKnt = joCrrKnt;
		this.inChgComp = inChgComp;
		this.ioTmlLocCd = ioTmlLocCd;
		this.vslNm = vslNm;
		this.ioBndCd = ioBndCd;
		this.bdAreaCd = bdAreaCd;
		this.dchgMzdCd = dchgMzdCd;
		this.podCd = podCd;
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.inChgMeth = inChgMeth;
		this.ttlWgt = ttlWgt;
		this.ttlMeasQty = ttlMeasQty;
		this.ttlPckUtCd = ttlPckUtCd;
		this.ktPa = ktPa;
		this.loclCstmsCd = loclCstmsCd;
		this.receiver = receiver;
		this.noneBlInType = noneBlInType;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cancel_flg", getCancelFlg());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("old_eta_dt", getOldEtaDt());
		this.hashColumns.put("ttl_meas_ut_cd", getTtlMeasUtCd());
		this.hashColumns.put("cstms_dchg_cd", getCstmsDchgCd());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("call_year", getCallYear());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("call_knt", getCallKnt());
		this.hashColumns.put("vsl_call_sgn_cd", getVslCallSgnCd());
		this.hashColumns.put("ttl_pck_qty", getTtlPckQty());
		this.hashColumns.put("in_chg_eta", getInChgEta());
		this.hashColumns.put("vsl_cnt_cd", getVslCntCd());
		this.hashColumns.put("in_chg_port", getInChgPort());
		this.hashColumns.put("jo_crr_knt", getJoCrrKnt());
		this.hashColumns.put("in_chg_comp", getInChgComp());
		this.hashColumns.put("io_tml_loc_cd", getIoTmlLocCd());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("bd_area_cd", getBdAreaCd());
		this.hashColumns.put("dchg_mzd_cd", getDchgMzdCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("in_chg_meth", getInChgMeth());
		this.hashColumns.put("ttl_wgt", getTtlWgt());
		this.hashColumns.put("ttl_meas_qty", getTtlMeasQty());
		this.hashColumns.put("ttl_pck_ut_cd", getTtlPckUtCd());
		this.hashColumns.put("locl_cstms_cd", getLoclCstmsCd());
		this.hashColumns.put("kt_pa", getKtPa());
		this.hashColumns.put("receiver", getReceiver());
		this.hashColumns.put("none_bl_in_type", getNoneBlInType());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cancel_flg", "cancelFlg");
		this.hashFields.put("old_eta_dt", "oldEtaDt");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("ttl_meas_ut_cd", "ttlMeasUtCd");
		this.hashFields.put("cstms_dchg_cd", "cstmsDchgCd");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("call_year", "callYear");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("call_knt", "callKnt");
		this.hashFields.put("vsl_call_sgn_cd", "vslCallSgnCd");
		this.hashFields.put("ttl_pck_qty", "ttlPckQty");
		this.hashFields.put("in_chg_eta", "inChgEta");
		this.hashFields.put("vsl_cnt_cd", "vslCntCd");
		this.hashFields.put("in_chg_port", "inChgPort");
		this.hashFields.put("jo_crr_knt", "joCrrKnt");
		this.hashFields.put("in_chg_comp", "inChgComp");
		this.hashFields.put("io_tml_loc_cd", "ioTmlLocCd");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("bd_area_cd", "bdAreaCd");
		this.hashFields.put("dchg_mzd_cd", "dchgMzdCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("in_chg_meth", "inChgMeth");
		this.hashFields.put("ttl_wgt", "ttlWgt");
		this.hashFields.put("ttl_meas_qty", "ttlMeasQty");
		this.hashFields.put("ttl_pck_ut_cd", "ttlPckUtCd");
		this.hashFields.put("kt_pa", "ktPa");
		this.hashFields.put("locl_cstms_cd", loclCstmsCd);
		this.hashFields.put("receiver", receiver);
		this.hashFields.put("none_bl_in_type", "noneBlInType");
		return this.hashFields;
	}

	/**
	 * @return the receiver
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	/**
	 * @return the loclCstmsCd
	 */
	public String getLoclCstmsCd() {
		return loclCstmsCd;
	}

	/**
	 * @param loclCstmsCd the loclCstmsCd to set
	 */
	public void setLoclCstmsCd(String loclCstmsCd) {
		this.loclCstmsCd = loclCstmsCd;
	}

	/**
	 * @return the oldEtaDt
	 */
	public String getOldEtaDt() {
		return oldEtaDt;
	}

	/**
	 * @param oldEtaDt the oldEtaDt to set
	 */
	public void setOldEtaDt(String oldEtaDt) {
		this.oldEtaDt = oldEtaDt;
	}

	/**
	 * Column Info
	 * @return cancelFlg
	 */
	public String getCancelFlg() {
		return this.cancelFlg;
	}

	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}

	/**
	 * Column Info
	 * @return ttlMeasUtCd
	 */
	public String getTtlMeasUtCd() {
		return this.ttlMeasUtCd;
	}

	/**
	 * Column Info
	 * @return cstmsDchgCd
	 */
	public String getCstmsDchgCd() {
		return this.cstmsDchgCd;
	}

	/**
	 * Column Info
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
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
	 * @return callYear
	 */
	public String getCallYear() {
		return this.callYear;
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
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * Column Info
	 * @return callKnt
	 */
	public String getCallKnt() {
		return this.callKnt;
	}

	/**
	 * Column Info
	 * @return vslCallSgnCd
	 */
	public String getVslCallSgnCd() {
		return this.vslCallSgnCd;
	}

	/**
	 * Column Info
	 * @return ttlPckQty
	 */
	public String getTtlPckQty() {
		return this.ttlPckQty;
	}

	/**
	 * Column Info
	 * @return inChgEta
	 */
	public String getInChgEta() {
		return this.inChgEta;
	}

	/**
	 * Column Info
	 * @return vslCntCd
	 */
	public String getVslCntCd() {
		return this.vslCntCd;
	}

	/**
	 * Column Info
	 * @return inChgPort
	 */
	public String getInChgPort() {
		return this.inChgPort;
	}

	/**
	 * Column Info
	 * @return joCrrKnt
	 */
	public String getJoCrrKnt() {
		return this.joCrrKnt;
	}

	/**
	 * Column Info
	 * @return inChgComp
	 */
	public String getInChgComp() {
		return this.inChgComp;
	}

	/**
	 * Column Info
	 * @return ioTmlLocCd
	 */
	public String getIoTmlLocCd() {
		return this.ioTmlLocCd;
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
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}

	/**
	 * Column Info
	 * @return bdAreaCd
	 */
	public String getBdAreaCd() {
		return this.bdAreaCd;
	}

	/**
	 * Column Info
	 * @return dchgMzdCd
	 */
	public String getDchgMzdCd() {
		return this.dchgMzdCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}

	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}

	/**
	 * Column Info
	 * @return inChgMeth
	 */
	public String getInChgMeth() {
		return this.inChgMeth;
	}

	/**
	 * Column Info
	 * @return ttlWgt
	 */
	public String getTtlWgt() {
		return this.ttlWgt;
	}

	/**
	 * Column Info
	 * @return ttlMeasQty
	 */
	public String getTtlMeasQty() {
		return this.ttlMeasQty;
	}

	/**
	 * Column Info
	 * @return ttlPckUtCd
	 */
	public String getTtlPckUtCd() {
		return this.ttlPckUtCd;
	}

	/**
	 * Column Info
	 * @return ktPa
	 */
	public String getKtPa() {
		return this.ktPa;
	}

	/**
	 * Column Info
	 * @return noneBlInType
	 */
	public String getNoneBlInType() {
		return this.noneBlInType;
	}

	/**
	 * Column Info
	 * @param cancelFlg
	 */
	public void setCancelFlg(String cancelFlg) {
		this.cancelFlg = cancelFlg;
	}

	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}

	/**
	 * Column Info
	 * @param ttlMeasUtCd
	 */
	public void setTtlMeasUtCd(String ttlMeasUtCd) {
		this.ttlMeasUtCd = ttlMeasUtCd;
	}

	/**
	 * Column Info
	 * @param cstmsDchgCd
	 */
	public void setCstmsDchgCd(String cstmsDchgCd) {
		this.cstmsDchgCd = cstmsDchgCd;
	}

	/**
	 * Column Info
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
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
	 * @param callYear
	 */
	public void setCallYear(String callYear) {
		this.callYear = callYear;
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Column Info
	 * @param callKnt
	 */
	public void setCallKnt(String callKnt) {
		this.callKnt = callKnt;
	}

	/**
	 * Column Info
	 * @param vslCallSgnCd
	 */
	public void setVslCallSgnCd(String vslCallSgnCd) {
		this.vslCallSgnCd = vslCallSgnCd;
	}

	/**
	 * Column Info
	 * @param ttlPckQty
	 */
	public void setTtlPckQty(String ttlPckQty) {
		this.ttlPckQty = ttlPckQty;
	}

	/**
	 * Column Info
	 * @param inChgEta
	 */
	public void setInChgEta(String inChgEta) {
		this.inChgEta = inChgEta;
	}

	/**
	 * Column Info
	 * @param vslCntCd
	 */
	public void setVslCntCd(String vslCntCd) {
		this.vslCntCd = vslCntCd;
	}

	/**
	 * Column Info
	 * @param inChgPort
	 */
	public void setInChgPort(String inChgPort) {
		this.inChgPort = inChgPort;
	}

	/**
	 * Column Info
	 * @param joCrrKnt
	 */
	public void setJoCrrKnt(String joCrrKnt) {
		this.joCrrKnt = joCrrKnt;
	}

	/**
	 * Column Info
	 * @param inChgComp
	 */
	public void setInChgComp(String inChgComp) {
		this.inChgComp = inChgComp;
	}

	/**
	 * Column Info
	 * @param ioTmlLocCd
	 */
	public void setIoTmlLocCd(String ioTmlLocCd) {
		this.ioTmlLocCd = ioTmlLocCd;
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
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}

	/**
	 * Column Info
	 * @param bdAreaCd
	 */
	public void setBdAreaCd(String bdAreaCd) {
		this.bdAreaCd = bdAreaCd;
	}

	/**
	 * Column Info
	 * @param dchgMzdCd
	 */
	public void setDchgMzdCd(String dchgMzdCd) {
		this.dchgMzdCd = dchgMzdCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * Column Info
	 * @param inChgMeth
	 */
	public void setInChgMeth(String inChgMeth) {
		this.inChgMeth = inChgMeth;
	}

	/**
	 * Column Info
	 * @param ttlWgt
	 */
	public void setTtlWgt(String ttlWgt) {
		this.ttlWgt = ttlWgt;
	}

	/**
	 * Column Info
	 * @param ttlMeasQty
	 */
	public void setTtlMeasQty(String ttlMeasQty) {
		this.ttlMeasQty = ttlMeasQty;
	}

	/**
	 * Column Info
	 * @param ttlPckUtCd
	 */
	public void setTtlPckUtCd(String ttlPckUtCd) {
		this.ttlPckUtCd = ttlPckUtCd;
	}

	/**
	 * Column Info
	 * @param ktPa
	 */
	public void setKtPa(String ktPa) {
		this.ktPa = ktPa;
	}

	/**
	 * Column Info
	 * @param noneBlInType
	 */
	public void setNoneBlInType(String noneBlInType) {
		this.noneBlInType = noneBlInType;
	}
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCancelFlg(JSPUtil.getParameter(request, "cancel_flg", ""));
		setEtaDt(JSPUtil.getParameter(request, "eta_dt", ""));
		setOldEtaDt(JSPUtil.getParameter(request, "old_eta_dt", ""));
		setTtlMeasUtCd(JSPUtil.getParameter(request, "ttl_meas_ut_cd", ""));
		setCstmsDchgCd(JSPUtil.getParameter(request, "cstms_dchg_cd", ""));
		setMrnNo(JSPUtil.getParameter(request, "mrn_no", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCallYear(JSPUtil.getParameter(request, "call_year", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setCallKnt(JSPUtil.getParameter(request, "call_knt", ""));
		setVslCallSgnCd(JSPUtil.getParameter(request, "vsl_call_sgn_cd", ""));
		setTtlPckQty(JSPUtil.getParameter(request, "ttl_pck_qty", ""));
		setInChgEta(JSPUtil.getParameter(request, "in_chg_eta", ""));
		setVslCntCd(JSPUtil.getParameter(request, "vsl_cnt_cd", ""));
		setInChgPort(JSPUtil.getParameter(request, "in_chg_port", ""));
		setJoCrrKnt(JSPUtil.getParameter(request, "jo_crr_knt", ""));
		setInChgComp(JSPUtil.getParameter(request, "in_chg_comp", ""));
		setIoTmlLocCd(JSPUtil.getParameter(request, "io_tml_loc_cd", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setBdAreaCd(JSPUtil.getParameter(request, "bd_area_cd", ""));
		setDchgMzdCd(JSPUtil.getParameter(request, "dchg_mzd_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setInChgMeth(JSPUtil.getParameter(request, "in_chg_meth", ""));
		setTtlWgt(JSPUtil.getParameter(request, "ttl_wgt", ""));
		setTtlMeasQty(JSPUtil.getParameter(request, "ttl_meas_qty", ""));
		setTtlPckUtCd(JSPUtil.getParameter(request, "ttl_pck_ut_cd", ""));
		setKtPa(JSPUtil.getParameter(request, "kt_pa", ""));
		setLoclCstmsCd(JSPUtil.getParameter(request, "locl_cstms_cd", ""));
		setReceiver(JSPUtil.getParameter(request, "receiver", ""));
		setNoneBlInType(JSPUtil.getParameter(request, "none_bl_in_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Kor24AmendManifestTransmitVO[]
	 */
	public Kor24AmendManifestTransmitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return Kor24AmendManifestTransmitVO[]
	 */
	public Kor24AmendManifestTransmitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Kor24AmendManifestTransmitVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cancelFlg = (JSPUtil.getParameter(request, prefix	+ "cancel_flg", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] oldEtaDt = (JSPUtil.getParameter(request, prefix	+ "old_eta_dt", length));
			String[] ttlMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "ttl_meas_ut_cd", length));
			String[] cstmsDchgCd = (JSPUtil.getParameter(request, prefix	+ "cstms_dchg_cd", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] callYear = (JSPUtil.getParameter(request, prefix	+ "call_year", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] callKnt = (JSPUtil.getParameter(request, prefix	+ "call_knt", length));
			String[] vslCallSgnCd = (JSPUtil.getParameter(request, prefix	+ "vsl_call_sgn_cd", length));
			String[] ttlPckQty = (JSPUtil.getParameter(request, prefix	+ "ttl_pck_qty", length));
			String[] inChgEta = (JSPUtil.getParameter(request, prefix	+ "in_chg_eta", length));
			String[] vslCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cnt_cd", length));
			String[] inChgPort = (JSPUtil.getParameter(request, prefix	+ "in_chg_port", length));
			String[] joCrrKnt = (JSPUtil.getParameter(request, prefix	+ "jo_crr_knt", length));
			String[] inChgComp = (JSPUtil.getParameter(request, prefix	+ "in_chg_comp", length));
			String[] ioTmlLocCd = (JSPUtil.getParameter(request, prefix	+ "io_tml_loc_cd", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] bdAreaCd = (JSPUtil.getParameter(request, prefix	+ "bd_area_cd", length));
			String[] dchgMzdCd = (JSPUtil.getParameter(request, prefix	+ "dchg_mzd_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] inChgMeth = (JSPUtil.getParameter(request, prefix	+ "in_chg_meth", length));
			String[] ttlWgt = (JSPUtil.getParameter(request, prefix	+ "ttl_wgt", length));
			String[] ttlMeasQty = (JSPUtil.getParameter(request, prefix	+ "ttl_meas_qty", length));
			String[] ttlPckUtCd = (JSPUtil.getParameter(request, prefix	+ "ttl_pck_ut_cd", length));
			String[] ktPa = (JSPUtil.getParameter(request, prefix	+ "kt_pa", length));
			String[] loclCstmsCd = (JSPUtil.getParameter(request, prefix+"locl_cstms_cd", length));
			String[] receiver = (JSPUtil.getParameter(request, prefix+"receiver", length));
			String[] noneBlInType = (JSPUtil.getParameter(request, prefix+"none_bl_in_type", length));

			for (int i = 0; i < length; i++) {
				model = new Kor24AmendManifestTransmitVO();
				if (cancelFlg[i] != null)
					model.setCancelFlg(cancelFlg[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (oldEtaDt[i] != null)
					model.setOldEtaDt(oldEtaDt[i]);
				if (ttlMeasUtCd[i] != null)
					model.setTtlMeasUtCd(ttlMeasUtCd[i]);
				if (cstmsDchgCd[i] != null)
					model.setCstmsDchgCd(cstmsDchgCd[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (callYear[i] != null)
					model.setCallYear(callYear[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (callKnt[i] != null)
					model.setCallKnt(callKnt[i]);
				if (vslCallSgnCd[i] != null)
					model.setVslCallSgnCd(vslCallSgnCd[i]);
				if (ttlPckQty[i] != null)
					model.setTtlPckQty(ttlPckQty[i]);
				if (inChgEta[i] != null)
					model.setInChgEta(inChgEta[i]);
				if (vslCntCd[i] != null)
					model.setVslCntCd(vslCntCd[i]);
				if (inChgPort[i] != null)
					model.setInChgPort(inChgPort[i]);
				if (joCrrKnt[i] != null)
					model.setJoCrrKnt(joCrrKnt[i]);
				if (inChgComp[i] != null)
					model.setInChgComp(inChgComp[i]);
				if (ioTmlLocCd[i] != null)
					model.setIoTmlLocCd(ioTmlLocCd[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (bdAreaCd[i] != null)
					model.setBdAreaCd(bdAreaCd[i]);
				if (dchgMzdCd[i] != null)
					model.setDchgMzdCd(dchgMzdCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (inChgMeth[i] != null)
					model.setInChgMeth(inChgMeth[i]);
				if (ttlWgt[i] != null)
					model.setTtlWgt(ttlWgt[i]);
				if (ttlMeasQty[i] != null)
					model.setTtlMeasQty(ttlMeasQty[i]);
				if (ttlPckUtCd[i] != null)
					model.setTtlPckUtCd(ttlPckUtCd[i]);
				if (ktPa[i] != null)
					model.setKtPa(ktPa[i]);
				if (loclCstmsCd[i] !=null)
					model.setLoclCstmsCd(loclCstmsCd[i]);
				if (receiver[i] !=null)
					model.setReceiver(receiver[i]);
				if (noneBlInType[i] !=null)
					model.setNoneBlInType(noneBlInType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKor24AmendManifestTransmitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Kor24AmendManifestTransmitVO[]
	 */
	public Kor24AmendManifestTransmitVO[] getKor24AmendManifestTransmitVOs(){
		Kor24AmendManifestTransmitVO[] vos = (Kor24AmendManifestTransmitVO[])models.toArray(new Kor24AmendManifestTransmitVO[models.size()]);
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
		this.cancelFlg = this.cancelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldEtaDt = this.oldEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlMeasUtCd = this.ttlMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDchgCd = this.cstmsDchgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callYear = this.callYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callKnt = this.callKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallSgnCd = this.vslCallSgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPckQty = this.ttlPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inChgEta = this.inChgEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCntCd = this.vslCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inChgPort = this.inChgPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrKnt = this.joCrrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inChgComp = this.inChgComp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioTmlLocCd = this.ioTmlLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdAreaCd = this.bdAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgMzdCd = this.dchgMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inChgMeth = this.inChgMeth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlWgt = this.ttlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlMeasQty = this.ttlMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPckUtCd = this.ttlPckUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktPa = this.ktPa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCstmsCd = this.loclCstmsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiver = this.receiver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noneBlInType = this.noneBlInType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
