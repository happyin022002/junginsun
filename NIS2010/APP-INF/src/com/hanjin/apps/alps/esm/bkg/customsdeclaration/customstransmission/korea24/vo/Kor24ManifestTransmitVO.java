/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileTitle : <Kor24ManifestTransmitVO.java
*@FileTitle : Kor24ManifestTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.09.30 박상훈
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see ManifestTransmitVO
 */

public class Kor24ManifestTransmitVO extends ManifestTransmitVO {

	private static final long serialVersionUID = 1L;

	private Collection<Kor24ManifestTransmitVO> models = new ArrayList<Kor24ManifestTransmitVO>();

	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String oldEtaDt = null;
	/* Column Info */
	private String ttlTsTeuQty = null;
	/* Column Info */
	private String mstBlKnt = null;
	/* Column Info */
	private String msnNo = null;
	/* Column Info */
	private String cstmsDchgCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String tmlCd = null;
	/* Column Info */
	private String loclCstmsPrtCd = null;
	/* Column Info */
	private String mrnNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inType = null;
	/* Column Info */
	private String noneBlInType = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ttlLcTeuQty = null;
	/* Column Info */
	private String cnslBlKnt = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String callKnt = null;
	/* Column Info */
	private String vslCallSgnCd = null;
	/* Column Info */
	private String inReceiver = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String vslCntCd = null;
	/* Column Info */
	private String vvdSeq = null;
	/* Column Info */
	private String joCrrKnt = null;
	/* Column Info */
	private String ioTmlLocCd = null;
	/* Column Info */
	private String loclCstmsCd = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String mtyBlKnt = null;
	/* Column Info */
	private String bdAreaCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String dchgMzdCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String ttlWgt = null;
	/* Column Info */
	private String ktPa = null;
	/* Column Info */
	private String podTml = null;
	/* Column Info */
	private String delCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public Kor24ManifestTransmitVO() {}

	public Kor24ManifestTransmitVO(String ibflag, String pagerows, String delCd, String userId, String podCd, String polCd, String ofcCd, String vvd, String ioBndCd, String inType, String noneBlInType, String portCd, String tmlCd, String podTml, String bdAreaCd, String callKnt, String vslNm, String vslCallSgnCd, String etaDt, String etdDt, String cstmsDchgCd, String dchgMzdCd, String ioTmlLocCd, String loclCstmsCd, String loclCstmsPrtCd, String vslCntCd, String mrnNo, String vvdSeq, String mstBlKnt, String inReceiver, String ktPa, String msnNo, String joCrrKnt, String blNo, String ttlLcTeuQty, String ttlTsTeuQty, String cnslBlKnt, String mtyBlKnt, String ttlWgt, String oldEtaDt) {
		this.oldEtaDt = oldEtaDt;
		this.etaDt = etaDt;
		this.ttlTsTeuQty = ttlTsTeuQty;
		this.mstBlKnt = mstBlKnt;
		this.msnNo = msnNo;
		this.cstmsDchgCd = cstmsDchgCd;
		this.blNo = blNo;
		this.tmlCd = tmlCd;
		this.loclCstmsPrtCd = loclCstmsPrtCd;
		this.mrnNo = mrnNo;
		this.pagerows = pagerows;
		this.inType = inType;
		this.noneBlInType = noneBlInType;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.ttlLcTeuQty = ttlLcTeuQty;
		this.cnslBlKnt = cnslBlKnt;
		this.userId = userId;
		this.callKnt = callKnt;
		this.vslCallSgnCd = vslCallSgnCd;
		this.inReceiver = inReceiver;
		this.portCd = portCd;
		this.vslCntCd = vslCntCd;
		this.vvdSeq = vvdSeq;
		this.joCrrKnt = joCrrKnt;
		this.ioTmlLocCd = ioTmlLocCd;
		this.loclCstmsCd = loclCstmsCd;
		this.vslNm = vslNm;
		this.etdDt = etdDt;
		this.mtyBlKnt = mtyBlKnt;
		this.bdAreaCd = bdAreaCd;
		this.ioBndCd = ioBndCd;
		this.dchgMzdCd = dchgMzdCd;
		this.vvd = vvd;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.ttlWgt = ttlWgt;
		this.ktPa = ktPa;
		this.podTml = podTml;
		this.delCd = delCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("old_eta_dt", getOldEtaDt());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("ttl_ts_teu_qty", getTtlTsTeuQty());
		this.hashColumns.put("mst_bl_knt", getMstBlKnt());
		this.hashColumns.put("msn_no", getMsnNo());
		this.hashColumns.put("cstms_dchg_cd", getCstmsDchgCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("locl_cstms_prt_cd", getLoclCstmsPrtCd());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("in_type", getInType());
		this.hashColumns.put("none_bl_in_type", getNoneBlInType());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ttl_lc_teu_qty", getTtlLcTeuQty());
		this.hashColumns.put("cnsl_bl_knt", getCnslBlKnt());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("call_knt", getCallKnt());
		this.hashColumns.put("vsl_call_sgn_cd", getVslCallSgnCd());
		this.hashColumns.put("in_receiver", getInReceiver());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("vsl_cnt_cd", getVslCntCd());
		this.hashColumns.put("vvd_seq", getVvdSeq());
		this.hashColumns.put("jo_crr_knt", getJoCrrKnt());
		this.hashColumns.put("io_tml_loc_cd", getIoTmlLocCd());
		this.hashColumns.put("locl_cstms_cd", getLoclCstmsCd());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("mty_bl_knt", getMtyBlKnt());
		this.hashColumns.put("bd_area_cd", getBdAreaCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("dchg_mzd_cd", getDchgMzdCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ttl_wgt", getTtlWgt());
		this.hashColumns.put("kt_pa", getKtPa());
		this.hashColumns.put("pod_tml", getPodTml());
		this.hashColumns.put("del_cd", getDelCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("old_eta_dt", "oldEtaDt");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("ttl_ts_teu_qty", "ttlTsTeuQty");
		this.hashFields.put("mst_bl_knt", "mstBlKnt");
		this.hashFields.put("msn_no", "msnNo");
		this.hashFields.put("cstms_dchg_cd", "cstmsDchgCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("locl_cstms_prt_cd", "loclCstmsPrtCd");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("in_type", "inType");
		this.hashFields.put("none_bl_in_type", "noneBlInType");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ttl_lc_teu_qty", "ttlLcTeuQty");
		this.hashFields.put("cnsl_bl_knt", "cnslBlKnt");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("call_knt", "callKnt");
		this.hashFields.put("vsl_call_sgn_cd", "vslCallSgnCd");
		this.hashFields.put("in_receiver", "inReceiver");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("vsl_cnt_cd", "vslCntCd");
		this.hashFields.put("vvd_seq", "vvdSeq");
		this.hashFields.put("jo_crr_knt", "joCrrKnt");
		this.hashFields.put("io_tml_loc_cd", "ioTmlLocCd");
		this.hashFields.put("locl_cstms_cd", "loclCstmsCd");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("mty_bl_knt", "mtyBlKnt");
		this.hashFields.put("bd_area_cd", "bdAreaCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("dchg_mzd_cd", "dchgMzdCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ttl_wgt", "ttlWgt");
		this.hashFields.put("kt_pa", "ktPa");
		this.hashFields.put("pod_tml", "podTml");
		this.hashFields.put("del_cd", "delCd");
		return this.hashFields;
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
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}

	/**
	 * Column Info
	 * @return ttlTsTeuQty
	 */
	public String getTtlTsTeuQty() {
		return this.ttlTsTeuQty;
	}

	/**
	 * Column Info
	 * @return mstBlKnt
	 */
	public String getMstBlKnt() {
		return this.mstBlKnt;
	}

	/**
	 * Column Info
	 * @return msnNo
	 */
	public String getMsnNo() {
		return this.msnNo;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}

	/**
	 * Column Info
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
	}

	/**
	 * Column Info
	 * @return loclCstmsPrtCd
	 */
	public String getLoclCstmsPrtCd() {
		return this.loclCstmsPrtCd;
	}

	/**
	 * Column Info
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
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
	 * @return inType
	 */
	public String getInType() {
		return this.inType;
	}

	/**
	 * Column Info
	 * @return
	 */
	public String getNoneBlInType() {
		return this.noneBlInType;
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
	 * @return ttlLcTeuQty
	 */
	public String getTtlLcTeuQty() {
		return this.ttlLcTeuQty;
	}

	/**
	 * Column Info
	 * @return cnslBlKnt
	 */
	public String getCnslBlKnt() {
		return this.cnslBlKnt;
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
	 * @return inReceiver
	 */
	public String getInReceiver() {
		return this.inReceiver;
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
	 * @return vslCntCd
	 */
	public String getVslCntCd() {
		return this.vslCntCd;
	}

	/**
	 * Column Info
	 * @return vvdSeq
	 */
	public String getVvdSeq() {
		return this.vvdSeq;
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
	 * @return ioTmlLocCd
	 */
	public String getIoTmlLocCd() {
		return this.ioTmlLocCd;
	}

	/**
	 * Column Info
	 * @return loclCstmsCd
	 */
	public String getLoclCstmsCd() {
		return this.loclCstmsCd;
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
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}

	/**
	 * Column Info
	 * @return mtyBlKnt
	 */
	public String getMtyBlKnt() {
		return this.mtyBlKnt;
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
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return ktPa
	 */
	public String getKtPa() {
		return this.ktPa;
	}

	/**
	 * Column Info
	 * @return podTml
	 */
	public String getPodTml() {
		return this.podTml;
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
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}

	/**
	 * Column Info
	 * @param ttlTsTeuQty
	 */
	public void setTtlTsTeuQty(String ttlTsTeuQty) {
		this.ttlTsTeuQty = ttlTsTeuQty;
	}

	/**
	 * Column Info
	 * @param mstBlKnt
	 */
	public void setMstBlKnt(String mstBlKnt) {
		this.mstBlKnt = mstBlKnt;
	}

	/**
	 * Column Info
	 * @param msnNo
	 */
	public void setMsnNo(String msnNo) {
		this.msnNo = msnNo;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Column Info
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
	}

	/**
	 * Column Info
	 * @param loclCstmsPrtCd
	 */
	public void setLoclCstmsPrtCd(String loclCstmsPrtCd) {
		this.loclCstmsPrtCd = loclCstmsPrtCd;
	}

	/**
	 * Column Info
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
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
	 * @param inType
	 */
	public void setInType(String inType) {
		this.inType = inType;
	}

	/**
	 * Column Info
	 * @param noneBlInType
	 */
	public void setNoneBlInType(String noneBlInType) {
		this.noneBlInType = noneBlInType;
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
	 * @param ttlLcTeuQty
	 */
	public void setTtlLcTeuQty(String ttlLcTeuQty) {
		this.ttlLcTeuQty = ttlLcTeuQty;
	}

	/**
	 * Column Info
	 * @param cnslBlKnt
	 */
	public void setCnslBlKnt(String cnslBlKnt) {
		this.cnslBlKnt = cnslBlKnt;
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
	 * @param inReceiver
	 */
	public void setInReceiver(String inReceiver) {
		this.inReceiver = inReceiver;
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
	 * @param vslCntCd
	 */
	public void setVslCntCd(String vslCntCd) {
		this.vslCntCd = vslCntCd;
	}

	/**
	 * Column Info
	 * @param vvdSeq
	 */
	public void setVvdSeq(String vvdSeq) {
		this.vvdSeq = vvdSeq;
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
	 * @param ioTmlLocCd
	 */
	public void setIoTmlLocCd(String ioTmlLocCd) {
		this.ioTmlLocCd = ioTmlLocCd;
	}

	/**
	 * Column Info
	 * @param loclCstmsCd
	 */
	public void setLoclCstmsCd(String loclCstmsCd) {
		this.loclCstmsCd = loclCstmsCd;
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
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}

	/**
	 * Column Info
	 * @param mtyBlKnt
	 */
	public void setMtyBlKnt(String mtyBlKnt) {
		this.mtyBlKnt = mtyBlKnt;
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
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param ktPa
	 */
	public void setKtPa(String ktPa) {
		this.ktPa = ktPa;
	}

	/**
	 * Column Info
	 * @param podTml
	 */
	public void setPodTml(String podTml) {
		this.podTml = podTml;
	}

	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOldEtaDt(JSPUtil.getParameter(request, "old_eta_dt", ""));
		setEtaDt(JSPUtil.getParameter(request, "eta_dt", ""));
		setTtlTsTeuQty(JSPUtil.getParameter(request, "ttl_ts_teu_qty", ""));
		setMstBlKnt(JSPUtil.getParameter(request, "mst_bl_knt", ""));
		setMsnNo(JSPUtil.getParameter(request, "msn_no", ""));
		setCstmsDchgCd(JSPUtil.getParameter(request, "cstms_dchg_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setTmlCd(JSPUtil.getParameter(request, "tml_cd", ""));
		setLoclCstmsPrtCd(JSPUtil.getParameter(request, "locl_cstms_prt_cd", ""));
		setMrnNo(JSPUtil.getParameter(request, "mrn_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInType(JSPUtil.getParameter(request, "in_type", ""));
		setNoneBlInType(JSPUtil.getParameter(request, "none_bl_in_type",""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTtlLcTeuQty(JSPUtil.getParameter(request, "ttl_lc_teu_qty", ""));
		setCnslBlKnt(JSPUtil.getParameter(request, "cnsl_bl_knt", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setCallKnt(JSPUtil.getParameter(request, "call_knt", ""));
		setVslCallSgnCd(JSPUtil.getParameter(request, "vsl_call_sgn_cd", ""));
		setInReceiver(JSPUtil.getParameter(request, "in_receiver", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setVslCntCd(JSPUtil.getParameter(request, "vsl_cnt_cd", ""));
		setVvdSeq(JSPUtil.getParameter(request, "vvd_seq", ""));
		setJoCrrKnt(JSPUtil.getParameter(request, "jo_crr_knt", ""));
		setIoTmlLocCd(JSPUtil.getParameter(request, "io_tml_loc_cd", ""));
		setLoclCstmsCd(JSPUtil.getParameter(request, "locl_cstms_cd", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setEtdDt(JSPUtil.getParameter(request, "etd_dt", ""));
		setMtyBlKnt(JSPUtil.getParameter(request, "mty_bl_knt", ""));
		setBdAreaCd(JSPUtil.getParameter(request, "bd_area_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setDchgMzdCd(JSPUtil.getParameter(request, "dchg_mzd_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setTtlWgt(JSPUtil.getParameter(request, "ttl_wgt", ""));
		setKtPa(JSPUtil.getParameter(request, "kt_pa", ""));
		setPodTml(JSPUtil.getParameter(request, "pod_tml", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Kor24ManifestTransmitVO[]
	 */
	public Kor24ManifestTransmitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return Kor24ManifestTransmitVO[]
	 */
	public Kor24ManifestTransmitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Kor24ManifestTransmitVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] oldEtaDt = (JSPUtil.getParameter(request, prefix	+ "old_eta_dt", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] ttlTsTeuQty = (JSPUtil.getParameter(request, prefix	+ "ttl_ts_teu_qty", length));
			String[] mstBlKnt = (JSPUtil.getParameter(request, prefix	+ "mst_bl_knt", length));
			String[] msnNo = (JSPUtil.getParameter(request, prefix	+ "msn_no", length));
			String[] cstmsDchgCd = (JSPUtil.getParameter(request, prefix	+ "cstms_dchg_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] loclCstmsPrtCd = (JSPUtil.getParameter(request, prefix	+ "locl_cstms_prt_cd", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inType = (JSPUtil.getParameter(request, prefix	+ "in_type", length));
			String[] noneBlInType = (JSPUtil.getParameter(request, prefix + "none_bl_in_type", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ttlLcTeuQty = (JSPUtil.getParameter(request, prefix	+ "ttl_lc_teu_qty", length));
			String[] cnslBlKnt = (JSPUtil.getParameter(request, prefix	+ "cnsl_bl_knt", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] callKnt = (JSPUtil.getParameter(request, prefix	+ "call_knt", length));
			String[] vslCallSgnCd = (JSPUtil.getParameter(request, prefix	+ "vsl_call_sgn_cd", length));
			String[] inReceiver = (JSPUtil.getParameter(request, prefix	+ "in_receiver", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] vslCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cnt_cd", length));
			String[] vvdSeq = (JSPUtil.getParameter(request, prefix	+ "vvd_seq", length));
			String[] joCrrKnt = (JSPUtil.getParameter(request, prefix	+ "jo_crr_knt", length));
			String[] ioTmlLocCd = (JSPUtil.getParameter(request, prefix	+ "io_tml_loc_cd", length));
			String[] loclCstmsCd = (JSPUtil.getParameter(request, prefix	+ "locl_cstms_cd", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] mtyBlKnt = (JSPUtil.getParameter(request, prefix	+ "mty_bl_knt", length));
			String[] bdAreaCd = (JSPUtil.getParameter(request, prefix	+ "bd_area_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] dchgMzdCd = (JSPUtil.getParameter(request, prefix	+ "dchg_mzd_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ttlWgt = (JSPUtil.getParameter(request, prefix	+ "ttl_wgt", length));
			String[] ktPa = (JSPUtil.getParameter(request, prefix	+ "kt_pa", length));
			String[] podTml = (JSPUtil.getParameter(request, prefix	+ "pod_tml", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));

			for (int i = 0; i < length; i++) {
				model = new Kor24ManifestTransmitVO();
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (oldEtaDt[i] != null)
					model.setOldEtaDt(oldEtaDt[i]);
				if (ttlTsTeuQty[i] != null)
					model.setTtlTsTeuQty(ttlTsTeuQty[i]);
				if (mstBlKnt[i] != null)
					model.setMstBlKnt(mstBlKnt[i]);
				if (msnNo[i] != null)
					model.setMsnNo(msnNo[i]);
				if (cstmsDchgCd[i] != null)
					model.setCstmsDchgCd(cstmsDchgCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (loclCstmsPrtCd[i] != null)
					model.setLoclCstmsPrtCd(loclCstmsPrtCd[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inType[i] != null)
					model.setInType(inType[i]);
				if (noneBlInType[i] != null)
					model.setNoneBlInType(noneBlInType[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ttlLcTeuQty[i] != null)
					model.setTtlLcTeuQty(ttlLcTeuQty[i]);
				if (cnslBlKnt[i] != null)
					model.setCnslBlKnt(cnslBlKnt[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (callKnt[i] != null)
					model.setCallKnt(callKnt[i]);
				if (vslCallSgnCd[i] != null)
					model.setVslCallSgnCd(vslCallSgnCd[i]);
				if (inReceiver[i] != null)
					model.setInReceiver(inReceiver[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (vslCntCd[i] != null)
					model.setVslCntCd(vslCntCd[i]);
				if (vvdSeq[i] != null)
					model.setVvdSeq(vvdSeq[i]);
				if (joCrrKnt[i] != null)
					model.setJoCrrKnt(joCrrKnt[i]);
				if (ioTmlLocCd[i] != null)
					model.setIoTmlLocCd(ioTmlLocCd[i]);
				if (loclCstmsCd[i] != null)
					model.setLoclCstmsCd(loclCstmsCd[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (mtyBlKnt[i] != null)
					model.setMtyBlKnt(mtyBlKnt[i]);
				if (bdAreaCd[i] != null)
					model.setBdAreaCd(bdAreaCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (dchgMzdCd[i] != null)
					model.setDchgMzdCd(dchgMzdCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ttlWgt[i] != null)
					model.setTtlWgt(ttlWgt[i]);
				if (ktPa[i] != null)
					model.setKtPa(ktPa[i]);
				if (podTml[i] != null)
					model.setPodTml(podTml[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKor24ManifestTransmitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Kor24ManifestTransmitVO[]
	 */
	public Kor24ManifestTransmitVO[] getKor24ManifestTransmitVOs(){
		Kor24ManifestTransmitVO[] vos = (Kor24ManifestTransmitVO[])models.toArray(new Kor24ManifestTransmitVO[models.size()]);
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
		this.oldEtaDt = this.oldEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTsTeuQty = this.ttlTsTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBlKnt = this.mstBlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msnNo = this.msnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDchgCd = this.cstmsDchgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCstmsPrtCd = this.loclCstmsPrtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inType = this.inType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noneBlInType = this.noneBlInType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLcTeuQty = this.ttlLcTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnslBlKnt = this.cnslBlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callKnt = this.callKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallSgnCd = this.vslCallSgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inReceiver = this.inReceiver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCntCd = this.vslCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSeq = this.vvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrKnt = this.joCrrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioTmlLocCd = this.ioTmlLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCstmsCd = this.loclCstmsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyBlKnt = this.mtyBlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdAreaCd = this.bdAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgMzdCd = this.dchgMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlWgt = this.ttlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktPa = this.ktPa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podTml = this.podTml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
