/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeForAuditVO.java
*@FileTitle : ChargeForAuditVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.09.02 최성환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.usdemurrageaudit.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChargeForAuditVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChargeForAuditVO> models = new ArrayList<ChargeForAuditVO>();
	
	/* Column Info */
	private String tFromDt = null;
	/* Column Info */
	private String tOver = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String calFromDt = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String tCollection = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String calToDt = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dmdtChgStsCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String calOver = null;
	/* Column Info */
	private String aftExptAmt = null;
	/* Column Info */
	private String tFtEnd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String fmMvmtYdCd = null;
	/* Column Info */
	private String vessel = null;
	/* Column Info */
	private String calCollection = null;
	/* Column Info */
	private String auditResult = null;
	/* Column Info */
	private String ftCmncDt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String loadOption = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ftDys = null;
	/* Column Info */
	private String voyage = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String calFtEnd = null;
	/* Column Info */
	private String tToDt = null;
	/* Column Info */
	private String exceptionAmt = null;
	/* Column Info */
	private String dmdtDeltRqstStsCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChargeForAuditVO() {}

	public ChargeForAuditVO(String ibflag, String pagerows, String loadOption, String ofcCd, String dmdtTrfCd, String fmMvmtYdCd, String auditResult, String cntrNo, String cntrTpszCd, String tFromDt, String calFromDt, String tToDt, String calToDt, String tFtEnd, String calFtEnd, String tOver, String calOver, String tCollection, String calCollection, String currCd, String ftCmncDt, String ftDys, String scNo, String rfaNo, String exceptionAmt, String aftExptAmt, String vvd, String vessel, String voyage, String bkgNo, String blNo, String dmdtChgStsCd, String svrId, String cntrCycNo, String dmdtChgLocDivCd, String chgSeq, String dmdtDeltRqstStsCd) {
		this.tFromDt = tFromDt;
		this.tOver = tOver;
		this.currCd = currCd;
		this.cntrCycNo = cntrCycNo;
		this.calFromDt = calFromDt;
		this.chgSeq = chgSeq;
		this.tCollection = tCollection;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.svrId = svrId;
		this.calToDt = calToDt;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.dmdtChgStsCd = dmdtChgStsCd;
		this.scNo = scNo;
		this.cntrTpszCd = cntrTpszCd;
		this.calOver = calOver;
		this.aftExptAmt = aftExptAmt;
		this.tFtEnd = tFtEnd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.fmMvmtYdCd = fmMvmtYdCd;
		this.vessel = vessel;
		this.calCollection = calCollection;
		this.auditResult = auditResult;
		this.ftCmncDt = ftCmncDt;
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.loadOption = loadOption;
		this.bkgNo = bkgNo;
		this.ftDys = ftDys;
		this.voyage = voyage;
		this.cntrNo = cntrNo;
		this.calFtEnd = calFtEnd;
		this.tToDt = tToDt;
		this.exceptionAmt = exceptionAmt;
		this.dmdtDeltRqstStsCd = dmdtDeltRqstStsCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("t_from_dt", getTFromDt());
		this.hashColumns.put("t_over", getTOver());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("cal_from_dt", getCalFromDt());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("t_collection", getTCollection());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("cal_to_dt", getCalToDt());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dmdt_chg_sts_cd", getDmdtChgStsCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cal_over", getCalOver());
		this.hashColumns.put("aft_expt_amt", getAftExptAmt());
		this.hashColumns.put("t_ft_end", getTFtEnd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("fm_mvmt_yd_cd", getFmMvmtYdCd());
		this.hashColumns.put("vessel", getVessel());
		this.hashColumns.put("cal_collection", getCalCollection());
		this.hashColumns.put("audit_result", getAuditResult());
		this.hashColumns.put("ft_cmnc_dt", getFtCmncDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("load_option", getLoadOption());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ft_dys", getFtDys());
		this.hashColumns.put("voyage", getVoyage());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cal_ft_end", getCalFtEnd());
		this.hashColumns.put("t_to_dt", getTToDt());
		this.hashColumns.put("exception_amt", getExceptionAmt());
		this.hashColumns.put("dmdt_delt_rqst_sts_cd", getDmdtDeltRqstStsCd());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("t_from_dt", "tFromDt");
		this.hashFields.put("t_over", "tOver");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("cal_from_dt", "calFromDt");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("t_collection", "tCollection");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("cal_to_dt", "calToDt");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dmdt_chg_sts_cd", "dmdtChgStsCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cal_over", "calOver");
		this.hashFields.put("aft_expt_amt", "aftExptAmt");
		this.hashFields.put("t_ft_end", "tFtEnd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("fm_mvmt_yd_cd", "fmMvmtYdCd");
		this.hashFields.put("vessel", "vessel");
		this.hashFields.put("cal_collection", "calCollection");
		this.hashFields.put("audit_result", "auditResult");
		this.hashFields.put("ft_cmnc_dt", "ftCmncDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("load_option", "loadOption");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ft_dys", "ftDys");
		this.hashFields.put("voyage", "voyage");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cal_ft_end", "calFtEnd");
		this.hashFields.put("t_to_dt", "tToDt");
		this.hashFields.put("exception_amt", "exceptionAmt");
		this.hashFields.put("dmdt_delt_rqst_sts_cd", "dmdtDeltRqstStsCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tFromDt
	 */
	public String getTFromDt() {
		return this.tFromDt;
	}
	
	/**
	 * Column Info
	 * @return tOver
	 */
	public String getTOver() {
		return this.tOver;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * @return calFromDt
	 */
	public String getCalFromDt() {
		return this.calFromDt;
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
	 * @return tCollection
	 */
	public String getTCollection() {
		return this.tCollection;
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
	 * Column Info
	 * @return calToDt
	 */
	public String getCalToDt() {
		return this.calToDt;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
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
	 * @return calOver
	 */
	public String getCalOver() {
		return this.calOver;
	}
	
	/**
	 * Column Info
	 * @return aftExptAmt
	 */
	public String getAftExptAmt() {
		return this.aftExptAmt;
	}
	
	/**
	 * Column Info
	 * @return tFtEnd
	 */
	public String getTFtEnd() {
		return this.tFtEnd;
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
	 * @return vessel
	 */
	public String getVessel() {
		return this.vessel;
	}
	
	/**
	 * Column Info
	 * @return calCollection
	 */
	public String getCalCollection() {
		return this.calCollection;
	}
	
	/**
	 * Column Info
	 * @return auditResult
	 */
	public String getAuditResult() {
		return this.auditResult;
	}
	
	/**
	 * Column Info
	 * @return ftCmncDt
	 */
	public String getFtCmncDt() {
		return this.ftCmncDt;
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
	 * @return loadOption
	 */
	public String getLoadOption() {
		return this.loadOption;
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
	 * @return ftDys
	 */
	public String getFtDys() {
		return this.ftDys;
	}
	
	/**
	 * Column Info
	 * @return voyage
	 */
	public String getVoyage() {
		return this.voyage;
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
	 * @return calFtEnd
	 */
	public String getCalFtEnd() {
		return this.calFtEnd;
	}
	
	/**
	 * Column Info
	 * @return tToDt
	 */
	public String getTToDt() {
		return this.tToDt;
	}
	
	/**
	 * Column Info
	 * @return exceptionAmt
	 */
	public String getExceptionAmt() {
		return this.exceptionAmt;
	}
	

	/**
	 * Column Info
	 * @param tFromDt
	 */
	public void setTFromDt(String tFromDt) {
		this.tFromDt = tFromDt;
	}
	
	/**
	 * Column Info
	 * @param tOver
	 */
	public void setTOver(String tOver) {
		this.tOver = tOver;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * @param calFromDt
	 */
	public void setCalFromDt(String calFromDt) {
		this.calFromDt = calFromDt;
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
	 * @param tCollection
	 */
	public void setTCollection(String tCollection) {
		this.tCollection = tCollection;
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
	 * Column Info
	 * @param calToDt
	 */
	public void setCalToDt(String calToDt) {
		this.calToDt = calToDt;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
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
	 * @param calOver
	 */
	public void setCalOver(String calOver) {
		this.calOver = calOver;
	}
	
	/**
	 * Column Info
	 * @param aftExptAmt
	 */
	public void setAftExptAmt(String aftExptAmt) {
		this.aftExptAmt = aftExptAmt;
	}
	
	/**
	 * Column Info
	 * @param tFtEnd
	 */
	public void setTFtEnd(String tFtEnd) {
		this.tFtEnd = tFtEnd;
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
	 * @param vessel
	 */
	public void setVessel(String vessel) {
		this.vessel = vessel;
	}
	
	/**
	 * Column Info
	 * @param calCollection
	 */
	public void setCalCollection(String calCollection) {
		this.calCollection = calCollection;
	}
	
	/**
	 * Column Info
	 * @param auditResult
	 */
	public void setAuditResult(String auditResult) {
		this.auditResult = auditResult;
	}
	
	/**
	 * Column Info
	 * @param ftCmncDt
	 */
	public void setFtCmncDt(String ftCmncDt) {
		this.ftCmncDt = ftCmncDt;
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
	 * @param loadOption
	 */
	public void setLoadOption(String loadOption) {
		this.loadOption = loadOption;
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
	 * @param ftDys
	 */
	public void setFtDys(String ftDys) {
		this.ftDys = ftDys;
	}
	
	/**
	 * Column Info
	 * @param voyage
	 */
	public void setVoyage(String voyage) {
		this.voyage = voyage;
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
	 * @param calFtEnd
	 */
	public void setCalFtEnd(String calFtEnd) {
		this.calFtEnd = calFtEnd;
	}
	
	/**
	 * Column Info
	 * @param tToDt
	 */
	public void setTToDt(String tToDt) {
		this.tToDt = tToDt;
	}
	
	public String getDmdtDeltRqstStsCd() {
		return dmdtDeltRqstStsCd;
	}

	public void setDmdtDeltRqstStsCd(String dmdtDeltRqstStsCd) {
		this.dmdtDeltRqstStsCd = dmdtDeltRqstStsCd;
	}

	/**
	 * Column Info
	 * @param exceptionAmt
	 */
	public void setExceptionAmt(String exceptionAmt) {
		this.exceptionAmt = exceptionAmt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTFromDt(JSPUtil.getParameter(request, "t_from_dt", ""));
		setTOver(JSPUtil.getParameter(request, "t_over", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setCntrCycNo(JSPUtil.getParameter(request, "cntr_cyc_no", ""));
		setCalFromDt(JSPUtil.getParameter(request, "cal_from_dt", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setTCollection(JSPUtil.getParameter(request, "t_collection", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setCalToDt(JSPUtil.getParameter(request, "cal_to_dt", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDmdtChgStsCd(JSPUtil.getParameter(request, "dmdt_chg_sts_cd", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCalOver(JSPUtil.getParameter(request, "cal_over", ""));
		setAftExptAmt(JSPUtil.getParameter(request, "aft_expt_amt", ""));
		setTFtEnd(JSPUtil.getParameter(request, "t_ft_end", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, "dmdt_chg_loc_div_cd", ""));
		setFmMvmtYdCd(JSPUtil.getParameter(request, "fm_mvmt_yd_cd", ""));
		setVessel(JSPUtil.getParameter(request, "vessel", ""));
		setCalCollection(JSPUtil.getParameter(request, "cal_collection", ""));
		setAuditResult(JSPUtil.getParameter(request, "audit_result", ""));
		setFtCmncDt(JSPUtil.getParameter(request, "ft_cmnc_dt", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setLoadOption(JSPUtil.getParameter(request, "load_option", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setFtDys(JSPUtil.getParameter(request, "ft_dys", ""));
		setVoyage(JSPUtil.getParameter(request, "voyage", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCalFtEnd(JSPUtil.getParameter(request, "cal_ft_end", ""));
		setTToDt(JSPUtil.getParameter(request, "t_to_dt", ""));
		setExceptionAmt(JSPUtil.getParameter(request, "exception_amt", ""));
		setDmdtDeltRqstStsCd(JSPUtil.getParameter(request, "dmdt_delt_rqst_sts_cd", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeForAuditVO[]
	 */
	public ChargeForAuditVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeForAuditVO[]
	 */
	public ChargeForAuditVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChargeForAuditVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tFromDt = (JSPUtil.getParameter(request, prefix	+ "t_from_dt", length));
			String[] tOver = (JSPUtil.getParameter(request, prefix	+ "t_over", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] calFromDt = (JSPUtil.getParameter(request, prefix	+ "cal_from_dt", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] tCollection = (JSPUtil.getParameter(request, prefix	+ "t_collection", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] calToDt = (JSPUtil.getParameter(request, prefix	+ "cal_to_dt", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dmdtChgStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_sts_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] calOver = (JSPUtil.getParameter(request, prefix	+ "cal_over", length));
			String[] aftExptAmt = (JSPUtil.getParameter(request, prefix	+ "aft_expt_amt", length));
			String[] tFtEnd = (JSPUtil.getParameter(request, prefix	+ "t_ft_end", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] fmMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_yd_cd", length));
			String[] vessel = (JSPUtil.getParameter(request, prefix	+ "vessel", length));
			String[] calCollection = (JSPUtil.getParameter(request, prefix	+ "cal_collection", length));
			String[] auditResult = (JSPUtil.getParameter(request, prefix	+ "audit_result", length));
			String[] ftCmncDt = (JSPUtil.getParameter(request, prefix	+ "ft_cmnc_dt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] loadOption = (JSPUtil.getParameter(request, prefix	+ "load_option", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ftDys = (JSPUtil.getParameter(request, prefix	+ "ft_dys", length));
			String[] voyage = (JSPUtil.getParameter(request, prefix	+ "voyage", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] calFtEnd = (JSPUtil.getParameter(request, prefix	+ "cal_ft_end", length));
			String[] tToDt = (JSPUtil.getParameter(request, prefix	+ "t_to_dt", length));
			String[] exceptionAmt = (JSPUtil.getParameter(request, prefix	+ "exception_amt", length));
			String[] dmdtDeltRqstStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_delt_rqst_sts_cd", length));

			
			for (int i = 0; i < length; i++) {
				model = new ChargeForAuditVO();
				if (tFromDt[i] != null)
					model.setTFromDt(tFromDt[i]);
				if (tOver[i] != null)
					model.setTOver(tOver[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);
				if (calFromDt[i] != null)
					model.setCalFromDt(calFromDt[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (tCollection[i] != null)
					model.setTCollection(tCollection[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (calToDt[i] != null)
					model.setCalToDt(calToDt[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dmdtChgStsCd[i] != null)
					model.setDmdtChgStsCd(dmdtChgStsCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (calOver[i] != null)
					model.setCalOver(calOver[i]);
				if (aftExptAmt[i] != null)
					model.setAftExptAmt(aftExptAmt[i]);
				if (tFtEnd[i] != null)
					model.setTFtEnd(tFtEnd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (fmMvmtYdCd[i] != null)
					model.setFmMvmtYdCd(fmMvmtYdCd[i]);
				if (vessel[i] != null)
					model.setVessel(vessel[i]);
				if (calCollection[i] != null)
					model.setCalCollection(calCollection[i]);
				if (auditResult[i] != null)
					model.setAuditResult(auditResult[i]);
				if (ftCmncDt[i] != null)
					model.setFtCmncDt(ftCmncDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (loadOption[i] != null)
					model.setLoadOption(loadOption[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ftDys[i] != null)
					model.setFtDys(ftDys[i]);
				if (voyage[i] != null)
					model.setVoyage(voyage[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (calFtEnd[i] != null)
					model.setCalFtEnd(calFtEnd[i]);
				if (tToDt[i] != null)
					model.setTToDt(tToDt[i]);
				if (exceptionAmt[i] != null)
					model.setExceptionAmt(exceptionAmt[i]);
				if (dmdtDeltRqstStsCd[i] != null)
					model.setDmdtDeltRqstStsCd(dmdtDeltRqstStsCd[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChargeForAuditVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChargeForAuditVO[]
	 */
	public ChargeForAuditVO[] getChargeForAuditVOs(){
		ChargeForAuditVO[] vos = (ChargeForAuditVO[])models.toArray(new ChargeForAuditVO[models.size()]);
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
		this.tFromDt = this.tFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tOver = this.tOver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calFromDt = this.calFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tCollection = this.tCollection .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calToDt = this.calToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgStsCd = this.dmdtChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calOver = this.calOver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptAmt = this.aftExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tFtEnd = this.tFtEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtYdCd = this.fmMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vessel = this.vessel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calCollection = this.calCollection .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.auditResult = this.auditResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftCmncDt = this.ftCmncDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadOption = this.loadOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftDys = this.ftDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyage = this.voyage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calFtEnd = this.calFtEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tToDt = this.tToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exceptionAmt = this.exceptionAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtDeltRqstStsCd = this.dmdtDeltRqstStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
