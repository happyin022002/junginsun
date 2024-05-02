/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TimeClockChargeListVO.java
*@FileTitle : TimeClockChargeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2010.01.14 최성환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TimeClockChargeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TimeClockChargeListVO> models = new ArrayList<TimeClockChargeListVO>();
	
	/* Column Info */
	private String corrRmk = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String dulTpExptFlg = null;
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String ofcTrnsFlg = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String svrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dmdtChgStsCd = null;
	/* Column Info */
	private String actCntCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String toMvmtDt = null;
	/* Column Info */
	private String ofcRhqCd = null;
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String fmMvmtYdCd = null;
	/* Column Info */
	private String toMvmtStsCd = null;
	/* Column Info */
	private String fmMvmtStsCd = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String webMtyDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String fmMvmtDt = null;
	/* Column Info */
	private String cxlBkgChgFlg = null;
	/* Column Info */
	private String toMvmtYdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TimeClockChargeListVO() {}

	public TimeClockChargeListVO(String ibflag, String pagerows, String svrId, String cntrNo, String cntrCycNo, String dmdtTrfCd, String dmdtChgLocDivCd, String chgSeq, String bkgNo, String blNo, String vslCd, String skdVoyNo, String skdDirCd, String custCntCd, String custSeq, String actCntCd, String actCustSeq, String ioBndCd, String cntrTpszCd, String fmMvmtDt, String fmMvmtYdCd, String fmMvmtStsCd, String toMvmtDt, String toMvmtYdCd, String toMvmtStsCd, String dmdtChgStsCd, String ofcCd, String ofcRhqCd, String ofcTrnsFlg, String dulTpExptFlg, String corrRmk, String webMtyDt, String cxlBkgChgFlg) {
		this.corrRmk = corrRmk;
		this.vslCd = vslCd;
		this.dulTpExptFlg = dulTpExptFlg;
		this.cntrCycNo = cntrCycNo;
		this.ofcTrnsFlg = ofcTrnsFlg;
		this.chgSeq = chgSeq;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.svrId = svrId;
		this.ibflag = ibflag;
		this.dmdtChgStsCd = dmdtChgStsCd;
		this.actCntCd = actCntCd;
		this.cntrTpszCd = cntrTpszCd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.custCntCd = custCntCd;
		this.toMvmtDt = toMvmtDt;
		this.ofcRhqCd = ofcRhqCd;
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.fmMvmtYdCd = fmMvmtYdCd;
		this.toMvmtStsCd = toMvmtStsCd;
		this.fmMvmtStsCd = fmMvmtStsCd;
		this.actCustSeq = actCustSeq;
		this.skdVoyNo = skdVoyNo;
		this.custSeq = custSeq;
		this.ioBndCd = ioBndCd;
		this.skdDirCd = skdDirCd;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.webMtyDt = webMtyDt;
		this.cntrNo = cntrNo;
		this.fmMvmtDt = fmMvmtDt;
		this.cxlBkgChgFlg = cxlBkgChgFlg;
		this.toMvmtYdCd = toMvmtYdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("corr_rmk", getCorrRmk());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("dul_tp_expt_flg", getDulTpExptFlg());
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("ofc_trns_flg", getOfcTrnsFlg());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dmdt_chg_sts_cd", getDmdtChgStsCd());
		this.hashColumns.put("act_cnt_cd", getActCntCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("to_mvmt_dt", getToMvmtDt());
		this.hashColumns.put("ofc_rhq_cd", getOfcRhqCd());
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("fm_mvmt_yd_cd", getFmMvmtYdCd());
		this.hashColumns.put("to_mvmt_sts_cd", getToMvmtStsCd());
		this.hashColumns.put("fm_mvmt_sts_cd", getFmMvmtStsCd());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("web_mty_dt", getWebMtyDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("fm_mvmt_dt", getFmMvmtDt());
		this.hashColumns.put("cxl_bkg_chg_flg", getCxlBkgChgFlg());
		this.hashColumns.put("to_mvmt_yd_cd", getToMvmtYdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("corr_rmk", "corrRmk");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("dul_tp_expt_flg", "dulTpExptFlg");
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("ofc_trns_flg", "ofcTrnsFlg");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dmdt_chg_sts_cd", "dmdtChgStsCd");
		this.hashFields.put("act_cnt_cd", "actCntCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("to_mvmt_dt", "toMvmtDt");
		this.hashFields.put("ofc_rhq_cd", "ofcRhqCd");
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("fm_mvmt_yd_cd", "fmMvmtYdCd");
		this.hashFields.put("to_mvmt_sts_cd", "toMvmtStsCd");
		this.hashFields.put("fm_mvmt_sts_cd", "fmMvmtStsCd");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("web_mty_dt", "webMtyDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("fm_mvmt_dt", "fmMvmtDt");
		this.hashFields.put("cxl_bkg_chg_flg", "cxlBkgChgFlg");
		this.hashFields.put("to_mvmt_yd_cd", "toMvmtYdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return corrRmk
	 */
	public String getCorrRmk() {
		return this.corrRmk;
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
	 * @return dulTpExptFlg
	 */
	public String getDulTpExptFlg() {
		return this.dulTpExptFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrCycNo
	 */
	public String getCntrCycNo() {
		return this.cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @return ofcTrnsFlg
	 */
	public String getOfcTrnsFlg() {
		return this.ofcTrnsFlg;
	}
	
	/**
	 * Column Info
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
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
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
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
	 * @return dmdtChgStsCd
	 */
	public String getDmdtChgStsCd() {
		return this.dmdtChgStsCd;
	}
	
	/**
	 * Column Info
	 * @return actCntCd
	 */
	public String getActCntCd() {
		return this.actCntCd;
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
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return toMvmtDt
	 */
	public String getToMvmtDt() {
		return this.toMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return ofcRhqCd
	 */
	public String getOfcRhqCd() {
		return this.ofcRhqCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgLocDivCd
	 */
	public String getDmdtChgLocDivCd() {
		return this.dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtYdCd
	 */
	public String getFmMvmtYdCd() {
		return this.fmMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @return toMvmtStsCd
	 */
	public String getToMvmtStsCd() {
		return this.toMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtStsCd
	 */
	public String getFmMvmtStsCd() {
		return this.fmMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return webMtyDt
	 */
	public String getWebMtyDt() {
		return this.webMtyDt;
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
	 * @return fmMvmtDt
	 */
	public String getFmMvmtDt() {
		return this.fmMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return cxlBkgChgFlg
	 */
	public String getCxlBkgChgFlg() {
		return this.cxlBkgChgFlg;
	}
	
	/**
	 * Column Info
	 * @return toMvmtYdCd
	 */
	public String getToMvmtYdCd() {
		return this.toMvmtYdCd;
	}
	

	/**
	 * Column Info
	 * @param corrRmk
	 */
	public void setCorrRmk(String corrRmk) {
		this.corrRmk = corrRmk;
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
	 * @param dulTpExptFlg
	 */
	public void setDulTpExptFlg(String dulTpExptFlg) {
		this.dulTpExptFlg = dulTpExptFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrCycNo
	 */
	public void setCntrCycNo(String cntrCycNo) {
		this.cntrCycNo = cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @param ofcTrnsFlg
	 */
	public void setOfcTrnsFlg(String ofcTrnsFlg) {
		this.ofcTrnsFlg = ofcTrnsFlg;
	}
	
	/**
	 * Column Info
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
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
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
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
	 * @param dmdtChgStsCd
	 */
	public void setDmdtChgStsCd(String dmdtChgStsCd) {
		this.dmdtChgStsCd = dmdtChgStsCd;
	}
	
	/**
	 * Column Info
	 * @param actCntCd
	 */
	public void setActCntCd(String actCntCd) {
		this.actCntCd = actCntCd;
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
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param toMvmtDt
	 */
	public void setToMvmtDt(String toMvmtDt) {
		this.toMvmtDt = toMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param ofcRhqCd
	 */
	public void setOfcRhqCd(String ofcRhqCd) {
		this.ofcRhqCd = ofcRhqCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgLocDivCd
	 */
	public void setDmdtChgLocDivCd(String dmdtChgLocDivCd) {
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtYdCd
	 */
	public void setFmMvmtYdCd(String fmMvmtYdCd) {
		this.fmMvmtYdCd = fmMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @param toMvmtStsCd
	 */
	public void setToMvmtStsCd(String toMvmtStsCd) {
		this.toMvmtStsCd = toMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtStsCd
	 */
	public void setFmMvmtStsCd(String fmMvmtStsCd) {
		this.fmMvmtStsCd = fmMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param webMtyDt
	 */
	public void setWebMtyDt(String webMtyDt) {
		this.webMtyDt = webMtyDt;
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
	 * @param fmMvmtDt
	 */
	public void setFmMvmtDt(String fmMvmtDt) {
		this.fmMvmtDt = fmMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param cxlBkgChgFlg
	 */
	public void setCxlBkgChgFlg(String cxlBkgChgFlg) {
		this.cxlBkgChgFlg = cxlBkgChgFlg;
	}
	
	/**
	 * Column Info
	 * @param toMvmtYdCd
	 */
	public void setToMvmtYdCd(String toMvmtYdCd) {
		this.toMvmtYdCd = toMvmtYdCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCorrRmk(JSPUtil.getParameter(request, "corr_rmk", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setDulTpExptFlg(JSPUtil.getParameter(request, "dul_tp_expt_flg", ""));
		setCntrCycNo(JSPUtil.getParameter(request, "cntr_cyc_no", ""));
		setOfcTrnsFlg(JSPUtil.getParameter(request, "ofc_trns_flg", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDmdtChgStsCd(JSPUtil.getParameter(request, "dmdt_chg_sts_cd", ""));
		setActCntCd(JSPUtil.getParameter(request, "act_cnt_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setToMvmtDt(JSPUtil.getParameter(request, "to_mvmt_dt", ""));
		setOfcRhqCd(JSPUtil.getParameter(request, "ofc_rhq_cd", ""));
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, "dmdt_chg_loc_div_cd", ""));
		setFmMvmtYdCd(JSPUtil.getParameter(request, "fm_mvmt_yd_cd", ""));
		setToMvmtStsCd(JSPUtil.getParameter(request, "to_mvmt_sts_cd", ""));
		setFmMvmtStsCd(JSPUtil.getParameter(request, "fm_mvmt_sts_cd", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setWebMtyDt(JSPUtil.getParameter(request, "web_mty_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setFmMvmtDt(JSPUtil.getParameter(request, "fm_mvmt_dt", ""));
		setCxlBkgChgFlg(JSPUtil.getParameter(request, "cxl_bkg_chg_flg", ""));
		setToMvmtYdCd(JSPUtil.getParameter(request, "to_mvmt_yd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TimeClockChargeListVO[]
	 */
	public TimeClockChargeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TimeClockChargeListVO[]
	 */
	public TimeClockChargeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TimeClockChargeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] corrRmk = (JSPUtil.getParameter(request, prefix	+ "corr_rmk", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] dulTpExptFlg = (JSPUtil.getParameter(request, prefix	+ "dul_tp_expt_flg", length));
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] ofcTrnsFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_trns_flg", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dmdtChgStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_sts_cd", length));
			String[] actCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cnt_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] toMvmtDt = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt", length));
			String[] ofcRhqCd = (JSPUtil.getParameter(request, prefix	+ "ofc_rhq_cd", length));
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] fmMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_yd_cd", length));
			String[] toMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_sts_cd", length));
			String[] fmMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_sts_cd", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] webMtyDt = (JSPUtil.getParameter(request, prefix	+ "web_mty_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] fmMvmtDt = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_dt", length));
			String[] cxlBkgChgFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_bkg_chg_flg", length));
			String[] toMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_yd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new TimeClockChargeListVO();
				if (corrRmk[i] != null)
					model.setCorrRmk(corrRmk[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (dulTpExptFlg[i] != null)
					model.setDulTpExptFlg(dulTpExptFlg[i]);
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);
				if (ofcTrnsFlg[i] != null)
					model.setOfcTrnsFlg(ofcTrnsFlg[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dmdtChgStsCd[i] != null)
					model.setDmdtChgStsCd(dmdtChgStsCd[i]);
				if (actCntCd[i] != null)
					model.setActCntCd(actCntCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (toMvmtDt[i] != null)
					model.setToMvmtDt(toMvmtDt[i]);
				if (ofcRhqCd[i] != null)
					model.setOfcRhqCd(ofcRhqCd[i]);
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (fmMvmtYdCd[i] != null)
					model.setFmMvmtYdCd(fmMvmtYdCd[i]);
				if (toMvmtStsCd[i] != null)
					model.setToMvmtStsCd(toMvmtStsCd[i]);
				if (fmMvmtStsCd[i] != null)
					model.setFmMvmtStsCd(fmMvmtStsCd[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (webMtyDt[i] != null)
					model.setWebMtyDt(webMtyDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (fmMvmtDt[i] != null)
					model.setFmMvmtDt(fmMvmtDt[i]);
				if (cxlBkgChgFlg[i] != null)
					model.setCxlBkgChgFlg(cxlBkgChgFlg[i]);
				if (toMvmtYdCd[i] != null)
					model.setToMvmtYdCd(toMvmtYdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTimeClockChargeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TimeClockChargeListVO[]
	 */
	public TimeClockChargeListVO[] getTimeClockChargeListVOs(){
		TimeClockChargeListVO[] vos = (TimeClockChargeListVO[])models.toArray(new TimeClockChargeListVO[models.size()]);
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
		this.corrRmk = this.corrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dulTpExptFlg = this.dulTpExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTrnsFlg = this.ofcTrnsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgStsCd = this.dmdtChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCntCd = this.actCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDt = this.toMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcRhqCd = this.ofcRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtYdCd = this.fmMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtStsCd = this.toMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtStsCd = this.fmMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webMtyDt = this.webMtyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtDt = this.fmMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlBkgChgFlg = this.cxlBkgChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtYdCd = this.toMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
