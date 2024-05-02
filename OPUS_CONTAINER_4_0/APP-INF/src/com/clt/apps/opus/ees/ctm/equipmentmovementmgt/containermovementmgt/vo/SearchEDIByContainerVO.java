/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchEDIByContainerVO.java
*@FileTitle : SearchEDIByContainerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.03
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.11.03 김상수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEDIByContainerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEDIByContainerVO> models = new ArrayList<SearchEDIByContainerVO>();
	
	/* Column Info */
	private String tmlNm = null;
	/* Column Info */
	private String mvmtEdiMsgTpId = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String ediGateIoCd = null;
	/* Column Info */
	private String mvmtTrspModCd = null;
	/* Column Info */
	private String mvmtEdiMsgSeq = null;
	/* Column Info */
	private String destYdCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrDmgFlg = null;
	/* Column Info */
	private String bkgPodCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String evntYdCd = null;
	/* Column Info */
	private String bkgKnt = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String mvmtEdiTpCd = null;
	/* Column Info */
	private String evntDt = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String mvmtEdiMsgAreaCd = null;
	/* Column Info */
	private String ediMvmtStsCd = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String mvmtEdiRsltCd = null;
	/* Column Info */
	private String wblNo = null;
	/* Column Info */
	private String mgstNo = null;
	/* Column Info */
	private String muid = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ediRtyKnt = null;
	/* Column Info */
	private String mvmtEdiMsgYrmondy = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrFullStsCd = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String cnmvCoCd = null;
	/* Column Info */
	private String pkupNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEDIByContainerVO() {}

	public SearchEDIByContainerVO(String ibflag, String pagerows, String bkgKnt, String bkgNo, String bkgPodCd, String bkgPolCd, String blNo, String callSgnNo, String chssNo, String cnmvCoCd, String cntrDmgFlg, String cntrFullStsCd, String cntrNo, String cntrSealNo, String vvdCd, String destYdCd, String ediGateIoCd, String ediMvmtStsCd, String evntDt, String evntYdCd, String mgstNo, String muid, String mvmtEdiMsgTpId, String mvmtEdiTpCd, String mvmtEdiRsltCd, String mvmtTrspModCd, String pkupNo, String ediRtyKnt, String tmlNm, String vndrSeq, String wblNo, String mvmtEdiMsgAreaCd, String mvmtEdiMsgSeq, String mvmtEdiMsgYrmondy) {
		this.tmlNm = tmlNm;
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
		this.chssNo = chssNo;
		this.ediGateIoCd = ediGateIoCd;
		this.mvmtTrspModCd = mvmtTrspModCd;
		this.mvmtEdiMsgSeq = mvmtEdiMsgSeq;
		this.destYdCd = destYdCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.cntrDmgFlg = cntrDmgFlg;
		this.bkgPodCd = bkgPodCd;
		this.ibflag = ibflag;
		this.evntYdCd = evntYdCd;
		this.bkgKnt = bkgKnt;
		this.vvdCd = vvdCd;
		this.mvmtEdiTpCd = mvmtEdiTpCd;
		this.evntDt = evntDt;
		this.bkgPolCd = bkgPolCd;
		this.mvmtEdiMsgAreaCd = mvmtEdiMsgAreaCd;
		this.ediMvmtStsCd = ediMvmtStsCd;
		this.callSgnNo = callSgnNo;
		this.mvmtEdiRsltCd = mvmtEdiRsltCd;
		this.wblNo = wblNo;
		this.mgstNo = mgstNo;
		this.muid = muid;
		this.bkgNo = bkgNo;
		this.ediRtyKnt = ediRtyKnt;
		this.mvmtEdiMsgYrmondy = mvmtEdiMsgYrmondy;
		this.vndrSeq = vndrSeq;
		this.cntrNo = cntrNo;
		this.cntrFullStsCd = cntrFullStsCd;
		this.cntrSealNo = cntrSealNo;
		this.cnmvCoCd = cnmvCoCd;
		this.pkupNo = pkupNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tml_nm", getTmlNm());
		this.hashColumns.put("mvmt_edi_msg_tp_id", getMvmtEdiMsgTpId());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("edi_gate_io_cd", getEdiGateIoCd());
		this.hashColumns.put("mvmt_trsp_mod_cd", getMvmtTrspModCd());
		this.hashColumns.put("mvmt_edi_msg_seq", getMvmtEdiMsgSeq());
		this.hashColumns.put("dest_yd_cd", getDestYdCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_dmg_flg", getCntrDmgFlg());
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("evnt_yd_cd", getEvntYdCd());
		this.hashColumns.put("bkg_knt", getBkgKnt());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("mvmt_edi_tp_cd", getMvmtEdiTpCd());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("mvmt_edi_msg_area_cd", getMvmtEdiMsgAreaCd());
		this.hashColumns.put("edi_mvmt_sts_cd", getEdiMvmtStsCd());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("mvmt_edi_rslt_cd", getMvmtEdiRsltCd());
		this.hashColumns.put("wbl_no", getWblNo());
		this.hashColumns.put("mgst_no", getMgstNo());
		this.hashColumns.put("muid", getMuid());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("edi_rty_knt", getEdiRtyKnt());
		this.hashColumns.put("mvmt_edi_msg_yrmondy", getMvmtEdiMsgYrmondy());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_full_sts_cd", getCntrFullStsCd());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("cnmv_co_cd", getCnmvCoCd());
		this.hashColumns.put("pkup_no", getPkupNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tml_nm", "tmlNm");
		this.hashFields.put("mvmt_edi_msg_tp_id", "mvmtEdiMsgTpId");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("edi_gate_io_cd", "ediGateIoCd");
		this.hashFields.put("mvmt_trsp_mod_cd", "mvmtTrspModCd");
		this.hashFields.put("mvmt_edi_msg_seq", "mvmtEdiMsgSeq");
		this.hashFields.put("dest_yd_cd", "destYdCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_dmg_flg", "cntrDmgFlg");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("evnt_yd_cd", "evntYdCd");
		this.hashFields.put("bkg_knt", "bkgKnt");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("mvmt_edi_tp_cd", "mvmtEdiTpCd");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("mvmt_edi_msg_area_cd", "mvmtEdiMsgAreaCd");
		this.hashFields.put("edi_mvmt_sts_cd", "ediMvmtStsCd");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("mvmt_edi_rslt_cd", "mvmtEdiRsltCd");
		this.hashFields.put("wbl_no", "wblNo");
		this.hashFields.put("mgst_no", "mgstNo");
		this.hashFields.put("muid", "muid");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("edi_rty_knt", "ediRtyKnt");
		this.hashFields.put("mvmt_edi_msg_yrmondy", "mvmtEdiMsgYrmondy");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_full_sts_cd", "cntrFullStsCd");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("cnmv_co_cd", "cnmvCoCd");
		this.hashFields.put("pkup_no", "pkupNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tmlNm
	 */
	public String getTmlNm() {
		return this.tmlNm;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiMsgTpId
	 */
	public String getMvmtEdiMsgTpId() {
		return this.mvmtEdiMsgTpId;
	}
	
	/**
	 * Column Info
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
	}
	
	/**
	 * Column Info
	 * @return ediGateIoCd
	 */
	public String getEdiGateIoCd() {
		return this.ediGateIoCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtTrspModCd
	 */
	public String getMvmtTrspModCd() {
		return this.mvmtTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiMsgSeq
	 */
	public String getMvmtEdiMsgSeq() {
		return this.mvmtEdiMsgSeq;
	}
	
	/**
	 * Column Info
	 * @return destYdCd
	 */
	public String getDestYdCd() {
		return this.destYdCd;
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
	 * @return cntrDmgFlg
	 */
	public String getCntrDmgFlg() {
		return this.cntrDmgFlg;
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
	 * @return evntYdCd
	 */
	public String getEvntYdCd() {
		return this.evntYdCd;
	}
	
	/**
	 * Column Info
	 * @return bkgKnt
	 */
	public String getBkgKnt() {
		return this.bkgKnt;
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
	 * @return mvmtEdiTpCd
	 */
	public String getMvmtEdiTpCd() {
		return this.mvmtEdiTpCd;
	}
	
	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
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
	 * @return mvmtEdiMsgAreaCd
	 */
	public String getMvmtEdiMsgAreaCd() {
		return this.mvmtEdiMsgAreaCd;
	}
	
	/**
	 * Column Info
	 * @return ediMvmtStsCd
	 */
	public String getEdiMvmtStsCd() {
		return this.ediMvmtStsCd;
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
	 * @return mvmtEdiRsltCd
	 */
	public String getMvmtEdiRsltCd() {
		return this.mvmtEdiRsltCd;
	}
	
	/**
	 * Column Info
	 * @return wblNo
	 */
	public String getWblNo() {
		return this.wblNo;
	}
	
	/**
	 * Column Info
	 * @return mgstNo
	 */
	public String getMgstNo() {
		return this.mgstNo;
	}
	
	/**
	 * Column Info
	 * @return muid
	 */
	public String getMuid() {
		return this.muid;
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
	 * @return ediRtyKnt
	 */
	public String getEdiRtyKnt() {
		return this.ediRtyKnt;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiMsgYrmondy
	 */
	public String getMvmtEdiMsgYrmondy() {
		return this.mvmtEdiMsgYrmondy;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return cntrFullStsCd
	 */
	public String getCntrFullStsCd() {
		return this.cntrFullStsCd;
	}
	
	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return cnmvCoCd
	 */
	public String getCnmvCoCd() {
		return this.cnmvCoCd;
	}
	
	/**
	 * Column Info
	 * @return pkupNo
	 */
	public String getPkupNo() {
		return this.pkupNo;
	}
	

	/**
	 * Column Info
	 * @param tmlNm
	 */
	public void setTmlNm(String tmlNm) {
		this.tmlNm = tmlNm;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiMsgTpId
	 */
	public void setMvmtEdiMsgTpId(String mvmtEdiMsgTpId) {
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
	}
	
	/**
	 * Column Info
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
	}
	
	/**
	 * Column Info
	 * @param ediGateIoCd
	 */
	public void setEdiGateIoCd(String ediGateIoCd) {
		this.ediGateIoCd = ediGateIoCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtTrspModCd
	 */
	public void setMvmtTrspModCd(String mvmtTrspModCd) {
		this.mvmtTrspModCd = mvmtTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiMsgSeq
	 */
	public void setMvmtEdiMsgSeq(String mvmtEdiMsgSeq) {
		this.mvmtEdiMsgSeq = mvmtEdiMsgSeq;
	}
	
	/**
	 * Column Info
	 * @param destYdCd
	 */
	public void setDestYdCd(String destYdCd) {
		this.destYdCd = destYdCd;
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
	 * @param cntrDmgFlg
	 */
	public void setCntrDmgFlg(String cntrDmgFlg) {
		this.cntrDmgFlg = cntrDmgFlg;
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
	 * @param evntYdCd
	 */
	public void setEvntYdCd(String evntYdCd) {
		this.evntYdCd = evntYdCd;
	}
	
	/**
	 * Column Info
	 * @param bkgKnt
	 */
	public void setBkgKnt(String bkgKnt) {
		this.bkgKnt = bkgKnt;
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
	 * @param mvmtEdiTpCd
	 */
	public void setMvmtEdiTpCd(String mvmtEdiTpCd) {
		this.mvmtEdiTpCd = mvmtEdiTpCd;
	}
	
	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
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
	 * @param mvmtEdiMsgAreaCd
	 */
	public void setMvmtEdiMsgAreaCd(String mvmtEdiMsgAreaCd) {
		this.mvmtEdiMsgAreaCd = mvmtEdiMsgAreaCd;
	}
	
	/**
	 * Column Info
	 * @param ediMvmtStsCd
	 */
	public void setEdiMvmtStsCd(String ediMvmtStsCd) {
		this.ediMvmtStsCd = ediMvmtStsCd;
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
	 * @param mvmtEdiRsltCd
	 */
	public void setMvmtEdiRsltCd(String mvmtEdiRsltCd) {
		this.mvmtEdiRsltCd = mvmtEdiRsltCd;
	}
	
	/**
	 * Column Info
	 * @param wblNo
	 */
	public void setWblNo(String wblNo) {
		this.wblNo = wblNo;
	}
	
	/**
	 * Column Info
	 * @param mgstNo
	 */
	public void setMgstNo(String mgstNo) {
		this.mgstNo = mgstNo;
	}
	
	/**
	 * Column Info
	 * @param muid
	 */
	public void setMuid(String muid) {
		this.muid = muid;
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
	 * @param ediRtyKnt
	 */
	public void setEdiRtyKnt(String ediRtyKnt) {
		this.ediRtyKnt = ediRtyKnt;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiMsgYrmondy
	 */
	public void setMvmtEdiMsgYrmondy(String mvmtEdiMsgYrmondy) {
		this.mvmtEdiMsgYrmondy = mvmtEdiMsgYrmondy;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param cntrFullStsCd
	 */
	public void setCntrFullStsCd(String cntrFullStsCd) {
		this.cntrFullStsCd = cntrFullStsCd;
	}
	
	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param cnmvCoCd
	 */
	public void setCnmvCoCd(String cnmvCoCd) {
		this.cnmvCoCd = cnmvCoCd;
	}
	
	/**
	 * Column Info
	 * @param pkupNo
	 */
	public void setPkupNo(String pkupNo) {
		this.pkupNo = pkupNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTmlNm(JSPUtil.getParameter(request, "tml_nm", ""));
		setMvmtEdiMsgTpId(JSPUtil.getParameter(request, "mvmt_edi_msg_tp_id", ""));
		setChssNo(JSPUtil.getParameter(request, "chss_no", ""));
		setEdiGateIoCd(JSPUtil.getParameter(request, "edi_gate_io_cd", ""));
		setMvmtTrspModCd(JSPUtil.getParameter(request, "mvmt_trsp_mod_cd", ""));
		setMvmtEdiMsgSeq(JSPUtil.getParameter(request, "mvmt_edi_msg_seq", ""));
		setDestYdCd(JSPUtil.getParameter(request, "dest_yd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntrDmgFlg(JSPUtil.getParameter(request, "cntr_dmg_flg", ""));
		setBkgPodCd(JSPUtil.getParameter(request, "bkg_pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEvntYdCd(JSPUtil.getParameter(request, "evnt_yd_cd", ""));
		setBkgKnt(JSPUtil.getParameter(request, "bkg_knt", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setMvmtEdiTpCd(JSPUtil.getParameter(request, "mvmt_edi_tp_cd", ""));
		setEvntDt(JSPUtil.getParameter(request, "evnt_dt", ""));
		setBkgPolCd(JSPUtil.getParameter(request, "bkg_pol_cd", ""));
		setMvmtEdiMsgAreaCd(JSPUtil.getParameter(request, "mvmt_edi_msg_area_cd", ""));
		setEdiMvmtStsCd(JSPUtil.getParameter(request, "edi_mvmt_sts_cd", ""));
		setCallSgnNo(JSPUtil.getParameter(request, "call_sgn_no", ""));
		setMvmtEdiRsltCd(JSPUtil.getParameter(request, "mvmt_edi_rslt_cd", ""));
		setWblNo(JSPUtil.getParameter(request, "wbl_no", ""));
		setMgstNo(JSPUtil.getParameter(request, "mgst_no", ""));
		setMuid(JSPUtil.getParameter(request, "muid", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setEdiRtyKnt(JSPUtil.getParameter(request, "edi_rty_knt", ""));
		setMvmtEdiMsgYrmondy(JSPUtil.getParameter(request, "mvmt_edi_msg_yrmondy", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrFullStsCd(JSPUtil.getParameter(request, "cntr_full_sts_cd", ""));
		setCntrSealNo(JSPUtil.getParameter(request, "cntr_seal_no", ""));
		setCnmvCoCd(JSPUtil.getParameter(request, "cnmv_co_cd", ""));
		setPkupNo(JSPUtil.getParameter(request, "pkup_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEDIByContainerVO[]
	 */
	public SearchEDIByContainerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEDIByContainerVO[]
	 */
	public SearchEDIByContainerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEDIByContainerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tmlNm = (JSPUtil.getParameter(request, prefix	+ "tml_nm", length));
			String[] mvmtEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_tp_id", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] ediGateIoCd = (JSPUtil.getParameter(request, prefix	+ "edi_gate_io_cd", length));
			String[] mvmtTrspModCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_trsp_mod_cd", length));
			String[] mvmtEdiMsgSeq = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_seq", length));
			String[] destYdCd = (JSPUtil.getParameter(request, prefix	+ "dest_yd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrDmgFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_dmg_flg", length));
			String[] bkgPodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] evntYdCd = (JSPUtil.getParameter(request, prefix	+ "evnt_yd_cd", length));
			String[] bkgKnt = (JSPUtil.getParameter(request, prefix	+ "bkg_knt", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] mvmtEdiTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_tp_cd", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] mvmtEdiMsgAreaCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_area_cd", length));
			String[] ediMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_mvmt_sts_cd", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] mvmtEdiRsltCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_rslt_cd", length));
			String[] wblNo = (JSPUtil.getParameter(request, prefix	+ "wbl_no", length));
			String[] mgstNo = (JSPUtil.getParameter(request, prefix	+ "mgst_no", length));
			String[] muid = (JSPUtil.getParameter(request, prefix	+ "muid", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ediRtyKnt = (JSPUtil.getParameter(request, prefix	+ "edi_rty_knt", length));
			String[] mvmtEdiMsgYrmondy = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_yrmondy", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrFullStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_full_sts_cd", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] cnmvCoCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_co_cd", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEDIByContainerVO();
				if (tmlNm[i] != null)
					model.setTmlNm(tmlNm[i]);
				if (mvmtEdiMsgTpId[i] != null)
					model.setMvmtEdiMsgTpId(mvmtEdiMsgTpId[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (ediGateIoCd[i] != null)
					model.setEdiGateIoCd(ediGateIoCd[i]);
				if (mvmtTrspModCd[i] != null)
					model.setMvmtTrspModCd(mvmtTrspModCd[i]);
				if (mvmtEdiMsgSeq[i] != null)
					model.setMvmtEdiMsgSeq(mvmtEdiMsgSeq[i]);
				if (destYdCd[i] != null)
					model.setDestYdCd(destYdCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrDmgFlg[i] != null)
					model.setCntrDmgFlg(cntrDmgFlg[i]);
				if (bkgPodCd[i] != null)
					model.setBkgPodCd(bkgPodCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (evntYdCd[i] != null)
					model.setEvntYdCd(evntYdCd[i]);
				if (bkgKnt[i] != null)
					model.setBkgKnt(bkgKnt[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (mvmtEdiTpCd[i] != null)
					model.setMvmtEdiTpCd(mvmtEdiTpCd[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (mvmtEdiMsgAreaCd[i] != null)
					model.setMvmtEdiMsgAreaCd(mvmtEdiMsgAreaCd[i]);
				if (ediMvmtStsCd[i] != null)
					model.setEdiMvmtStsCd(ediMvmtStsCd[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (mvmtEdiRsltCd[i] != null)
					model.setMvmtEdiRsltCd(mvmtEdiRsltCd[i]);
				if (wblNo[i] != null)
					model.setWblNo(wblNo[i]);
				if (mgstNo[i] != null)
					model.setMgstNo(mgstNo[i]);
				if (muid[i] != null)
					model.setMuid(muid[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ediRtyKnt[i] != null)
					model.setEdiRtyKnt(ediRtyKnt[i]);
				if (mvmtEdiMsgYrmondy[i] != null)
					model.setMvmtEdiMsgYrmondy(mvmtEdiMsgYrmondy[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrFullStsCd[i] != null)
					model.setCntrFullStsCd(cntrFullStsCd[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (cnmvCoCd[i] != null)
					model.setCnmvCoCd(cnmvCoCd[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEDIByContainerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEDIByContainerVO[]
	 */
	public SearchEDIByContainerVO[] getSearchEDIByContainerVOs(){
		SearchEDIByContainerVO[] vos = (SearchEDIByContainerVO[])models.toArray(new SearchEDIByContainerVO[models.size()]);
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
		this.tmlNm = this.tmlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgTpId = this.mvmtEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGateIoCd = this.ediGateIoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtTrspModCd = this.mvmtTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgSeq = this.mvmtEdiMsgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destYdCd = this.destYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDmgFlg = this.cntrDmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd = this.bkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntYdCd = this.evntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgKnt = this.bkgKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiTpCd = this.mvmtEdiTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgAreaCd = this.mvmtEdiMsgAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMvmtStsCd = this.ediMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiRsltCd = this.mvmtEdiRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblNo = this.wblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstNo = this.mgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.muid = this.muid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRtyKnt = this.ediRtyKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgYrmondy = this.mvmtEdiMsgYrmondy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFullStsCd = this.cntrFullStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCoCd = this.cnmvCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
