/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemandNoteRDListVO.java
*@FileTitle : DemandNoteRDListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.18
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.12.18 최성환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo;

import java.lang.reflect.Field;
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

public class DemandNoteRDListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DemandNoteRDListVO> models = new ArrayList<DemandNoteRDListVO>();
	
	/* Column Info */
	private String bzcTrfCurrCd = null;
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String scExptVerSeq = null;
	/* Column Info */
	private String dmdtTrfAplyTpCd = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String rtDay = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rtChrgAmt = null;
	/* Column Info */
	private String fxFtOvrDys = null;
	/* Column Info */
	private String svrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dmdtChgStsCd = null;
	/* Column Info */
	private String rfaExptMapgSeq = null;
	/* Column Info */
	private String rfaExptDarNo = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String rfaExptVerSeq = null;
	/* Column Info */
	private String rfaRqstDtlSeq = null;
	/* Column Info */
	private String bzcTrfGrpSeq = null;
	/* Column Info */
	private String ftEndDt = null;
	/* Column Info */
	private String rtAmt = null;
	/* Column Info */
	private String toMvmtDt = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String ftOver = null;
	/* Column Info */
	private String scExptGrpSeq = null;
	/* Column Info */
	private String ftCmncDt = null;
	/* Column Info */
	private String ftUnder = null;
	/* Column Info */
	private String rtCurrCd = null;
	/* Column Info */
	private String ftDys = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String fmMvmtDt = null;
	/* Column Info */
	private String bzcTrfSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DemandNoteRDListVO() {}

	public DemandNoteRDListVO(String ibflag, String pagerows, String cntrNo, String cntrTpszCd, String fmMvmtDt, String toMvmtDt, String ftCmncDt, String ftEndDt, String ftDys, String fxFtOvrDys, String bzcTrfCurrCd, String svrId, String cntrCycNo, String dmdtTrfCd, String dmdtChgLocDivCd, String chgSeq, String bzcTrfSeq, String bzcTrfGrpSeq, String dmdtChgStsCd, String rfaExptDarNo, String rfaExptMapgSeq, String rfaExptVerSeq, String rfaRqstDtlSeq, String scNo, String scExptVerSeq, String scExptGrpSeq, String dmdtTrfAplyTpCd, String ftOver, String ftUnder, String rtAmt, String rtDay, String rtChrgAmt, String rtCurrCd) {
		this.bzcTrfCurrCd = bzcTrfCurrCd;
		this.cntrCycNo = cntrCycNo;
		this.scExptVerSeq = scExptVerSeq;
		this.dmdtTrfAplyTpCd = dmdtTrfAplyTpCd;
		this.chgSeq = chgSeq;
		this.rtDay = rtDay;
		this.pagerows = pagerows;
		this.rtChrgAmt = rtChrgAmt;
		this.fxFtOvrDys = fxFtOvrDys;
		this.svrId = svrId;
		this.ibflag = ibflag;
		this.dmdtChgStsCd = dmdtChgStsCd;
		this.rfaExptMapgSeq = rfaExptMapgSeq;
		this.rfaExptDarNo = rfaExptDarNo;
		this.scNo = scNo;
		this.cntrTpszCd = cntrTpszCd;
		this.rfaExptVerSeq = rfaExptVerSeq;
		this.rfaRqstDtlSeq = rfaRqstDtlSeq;
		this.bzcTrfGrpSeq = bzcTrfGrpSeq;
		this.ftEndDt = ftEndDt;
		this.rtAmt = rtAmt;
		this.toMvmtDt = toMvmtDt;
		this.dmdtTrfCd = dmdtTrfCd;
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.ftOver = ftOver;
		this.scExptGrpSeq = scExptGrpSeq;
		this.ftCmncDt = ftCmncDt;
		this.ftUnder = ftUnder;
		this.rtCurrCd = rtCurrCd;
		this.ftDys = ftDys;
		this.cntrNo = cntrNo;
		this.fmMvmtDt = fmMvmtDt;
		this.bzcTrfSeq = bzcTrfSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bzc_trf_curr_cd", getBzcTrfCurrCd());
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("sc_expt_ver_seq", getScExptVerSeq());
		this.hashColumns.put("dmdt_trf_aply_tp_cd", getDmdtTrfAplyTpCd());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("rt_day", getRtDay());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rt_chrg_amt", getRtChrgAmt());
		this.hashColumns.put("fx_ft_ovr_dys", getFxFtOvrDys());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dmdt_chg_sts_cd", getDmdtChgStsCd());
		this.hashColumns.put("rfa_expt_mapg_seq", getRfaExptMapgSeq());
		this.hashColumns.put("rfa_expt_dar_no", getRfaExptDarNo());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("rfa_expt_ver_seq", getRfaExptVerSeq());
		this.hashColumns.put("rfa_rqst_dtl_seq", getRfaRqstDtlSeq());
		this.hashColumns.put("bzc_trf_grp_seq", getBzcTrfGrpSeq());
		this.hashColumns.put("ft_end_dt", getFtEndDt());
		this.hashColumns.put("rt_amt", getRtAmt());
		this.hashColumns.put("to_mvmt_dt", getToMvmtDt());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("ft_over", getFtOver());
		this.hashColumns.put("sc_expt_grp_seq", getScExptGrpSeq());
		this.hashColumns.put("ft_cmnc_dt", getFtCmncDt());
		this.hashColumns.put("ft_under", getFtUnder());
		this.hashColumns.put("rt_curr_cd", getRtCurrCd());
		this.hashColumns.put("ft_dys", getFtDys());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("fm_mvmt_dt", getFmMvmtDt());
		this.hashColumns.put("bzc_trf_seq", getBzcTrfSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bzc_trf_curr_cd", "bzcTrfCurrCd");
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("sc_expt_ver_seq", "scExptVerSeq");
		this.hashFields.put("dmdt_trf_aply_tp_cd", "dmdtTrfAplyTpCd");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("rt_day", "rtDay");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rt_chrg_amt", "rtChrgAmt");
		this.hashFields.put("fx_ft_ovr_dys", "fxFtOvrDys");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dmdt_chg_sts_cd", "dmdtChgStsCd");
		this.hashFields.put("rfa_expt_mapg_seq", "rfaExptMapgSeq");
		this.hashFields.put("rfa_expt_dar_no", "rfaExptDarNo");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("rfa_expt_ver_seq", "rfaExptVerSeq");
		this.hashFields.put("rfa_rqst_dtl_seq", "rfaRqstDtlSeq");
		this.hashFields.put("bzc_trf_grp_seq", "bzcTrfGrpSeq");
		this.hashFields.put("ft_end_dt", "ftEndDt");
		this.hashFields.put("rt_amt", "rtAmt");
		this.hashFields.put("to_mvmt_dt", "toMvmtDt");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("ft_over", "ftOver");
		this.hashFields.put("sc_expt_grp_seq", "scExptGrpSeq");
		this.hashFields.put("ft_cmnc_dt", "ftCmncDt");
		this.hashFields.put("ft_under", "ftUnder");
		this.hashFields.put("rt_curr_cd", "rtCurrCd");
		this.hashFields.put("ft_dys", "ftDys");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("fm_mvmt_dt", "fmMvmtDt");
		this.hashFields.put("bzc_trf_seq", "bzcTrfSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bzcTrfCurrCd
	 */
	public String getBzcTrfCurrCd() {
		return this.bzcTrfCurrCd;
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
	 * @return scExptVerSeq
	 */
	public String getScExptVerSeq() {
		return this.scExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfAplyTpCd
	 */
	public String getDmdtTrfAplyTpCd() {
		return this.dmdtTrfAplyTpCd;
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
	 * @return rtDay
	 */
	public String getRtDay() {
		return this.rtDay;
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
	 * @return rtChrgAmt
	 */
	public String getRtChrgAmt() {
		return this.rtChrgAmt;
	}
	
	/**
	 * Column Info
	 * @return fxFtOvrDys
	 */
	public String getFxFtOvrDys() {
		return this.fxFtOvrDys;
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
	 * @return rfaExptMapgSeq
	 */
	public String getRfaExptMapgSeq() {
		return this.rfaExptMapgSeq;
	}
	
	/**
	 * Column Info
	 * @return rfaExptDarNo
	 */
	public String getRfaExptDarNo() {
		return this.rfaExptDarNo;
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
	 * @return rfaExptVerSeq
	 */
	public String getRfaExptVerSeq() {
		return this.rfaExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @return rfaRqstDtlSeq
	 */
	public String getRfaRqstDtlSeq() {
		return this.rfaRqstDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return bzcTrfGrpSeq
	 */
	public String getBzcTrfGrpSeq() {
		return this.bzcTrfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return ftEndDt
	 */
	public String getFtEndDt() {
		return this.ftEndDt;
	}
	
	/**
	 * Column Info
	 * @return rtAmt
	 */
	public String getRtAmt() {
		return this.rtAmt;
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
	 * @return ftOver
	 */
	public String getFtOver() {
		return this.ftOver;
	}
	
	/**
	 * Column Info
	 * @return scExptGrpSeq
	 */
	public String getScExptGrpSeq() {
		return this.scExptGrpSeq;
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
	 * @return ftUnder
	 */
	public String getFtUnder() {
		return this.ftUnder;
	}
	
	/**
	 * Column Info
	 * @return rtCurrCd
	 */
	public String getRtCurrCd() {
		return this.rtCurrCd;
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
	 * @return bzcTrfSeq
	 */
	public String getBzcTrfSeq() {
		return this.bzcTrfSeq;
	}
	

	/**
	 * Column Info
	 * @param bzcTrfCurrCd
	 */
	public void setBzcTrfCurrCd(String bzcTrfCurrCd) {
		this.bzcTrfCurrCd = bzcTrfCurrCd;
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
	 * @param scExptVerSeq
	 */
	public void setScExptVerSeq(String scExptVerSeq) {
		this.scExptVerSeq = scExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfAplyTpCd
	 */
	public void setDmdtTrfAplyTpCd(String dmdtTrfAplyTpCd) {
		this.dmdtTrfAplyTpCd = dmdtTrfAplyTpCd;
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
	 * @param rtDay
	 */
	public void setRtDay(String rtDay) {
		this.rtDay = rtDay;
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
	 * @param rtChrgAmt
	 */
	public void setRtChrgAmt(String rtChrgAmt) {
		this.rtChrgAmt = rtChrgAmt;
	}
	
	/**
	 * Column Info
	 * @param fxFtOvrDys
	 */
	public void setFxFtOvrDys(String fxFtOvrDys) {
		this.fxFtOvrDys = fxFtOvrDys;
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
	 * @param rfaExptMapgSeq
	 */
	public void setRfaExptMapgSeq(String rfaExptMapgSeq) {
		this.rfaExptMapgSeq = rfaExptMapgSeq;
	}
	
	/**
	 * Column Info
	 * @param rfaExptDarNo
	 */
	public void setRfaExptDarNo(String rfaExptDarNo) {
		this.rfaExptDarNo = rfaExptDarNo;
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
	 * @param rfaExptVerSeq
	 */
	public void setRfaExptVerSeq(String rfaExptVerSeq) {
		this.rfaExptVerSeq = rfaExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @param rfaRqstDtlSeq
	 */
	public void setRfaRqstDtlSeq(String rfaRqstDtlSeq) {
		this.rfaRqstDtlSeq = rfaRqstDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param bzcTrfGrpSeq
	 */
	public void setBzcTrfGrpSeq(String bzcTrfGrpSeq) {
		this.bzcTrfGrpSeq = bzcTrfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param ftEndDt
	 */
	public void setFtEndDt(String ftEndDt) {
		this.ftEndDt = ftEndDt;
	}
	
	/**
	 * Column Info
	 * @param rtAmt
	 */
	public void setRtAmt(String rtAmt) {
		this.rtAmt = rtAmt;
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
	 * @param ftOver
	 */
	public void setFtOver(String ftOver) {
		this.ftOver = ftOver;
	}
	
	/**
	 * Column Info
	 * @param scExptGrpSeq
	 */
	public void setScExptGrpSeq(String scExptGrpSeq) {
		this.scExptGrpSeq = scExptGrpSeq;
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
	 * @param ftUnder
	 */
	public void setFtUnder(String ftUnder) {
		this.ftUnder = ftUnder;
	}
	
	/**
	 * Column Info
	 * @param rtCurrCd
	 */
	public void setRtCurrCd(String rtCurrCd) {
		this.rtCurrCd = rtCurrCd;
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
	 * @param bzcTrfSeq
	 */
	public void setBzcTrfSeq(String bzcTrfSeq) {
		this.bzcTrfSeq = bzcTrfSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBzcTrfCurrCd(JSPUtil.getParameter(request, "bzc_trf_curr_cd", ""));
		setCntrCycNo(JSPUtil.getParameter(request, "cntr_cyc_no", ""));
		setScExptVerSeq(JSPUtil.getParameter(request, "sc_expt_ver_seq", ""));
		setDmdtTrfAplyTpCd(JSPUtil.getParameter(request, "dmdt_trf_aply_tp_cd", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setRtDay(JSPUtil.getParameter(request, "rt_day", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRtChrgAmt(JSPUtil.getParameter(request, "rt_chrg_amt", ""));
		setFxFtOvrDys(JSPUtil.getParameter(request, "fx_ft_ovr_dys", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDmdtChgStsCd(JSPUtil.getParameter(request, "dmdt_chg_sts_cd", ""));
		setRfaExptMapgSeq(JSPUtil.getParameter(request, "rfa_expt_mapg_seq", ""));
		setRfaExptDarNo(JSPUtil.getParameter(request, "rfa_expt_dar_no", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setRfaExptVerSeq(JSPUtil.getParameter(request, "rfa_expt_ver_seq", ""));
		setRfaRqstDtlSeq(JSPUtil.getParameter(request, "rfa_rqst_dtl_seq", ""));
		setBzcTrfGrpSeq(JSPUtil.getParameter(request, "bzc_trf_grp_seq", ""));
		setFtEndDt(JSPUtil.getParameter(request, "ft_end_dt", ""));
		setRtAmt(JSPUtil.getParameter(request, "rt_amt", ""));
		setToMvmtDt(JSPUtil.getParameter(request, "to_mvmt_dt", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, "dmdt_chg_loc_div_cd", ""));
		setFtOver(JSPUtil.getParameter(request, "ft_over", ""));
		setScExptGrpSeq(JSPUtil.getParameter(request, "sc_expt_grp_seq", ""));
		setFtCmncDt(JSPUtil.getParameter(request, "ft_cmnc_dt", ""));
		setFtUnder(JSPUtil.getParameter(request, "ft_under", ""));
		setRtCurrCd(JSPUtil.getParameter(request, "rt_curr_cd", ""));
		setFtDys(JSPUtil.getParameter(request, "ft_dys", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setFmMvmtDt(JSPUtil.getParameter(request, "fm_mvmt_dt", ""));
		setBzcTrfSeq(JSPUtil.getParameter(request, "bzc_trf_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DemandNoteRDListVO[]
	 */
	public DemandNoteRDListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DemandNoteRDListVO[]
	 */
	public DemandNoteRDListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DemandNoteRDListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bzcTrfCurrCd = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_curr_cd", length));
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] scExptVerSeq = (JSPUtil.getParameter(request, prefix	+ "sc_expt_ver_seq", length));
			String[] dmdtTrfAplyTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_aply_tp_cd", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] rtDay = (JSPUtil.getParameter(request, prefix	+ "rt_day", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rtChrgAmt = (JSPUtil.getParameter(request, prefix	+ "rt_chrg_amt", length));
			String[] fxFtOvrDys = (JSPUtil.getParameter(request, prefix	+ "fx_ft_ovr_dys", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dmdtChgStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_sts_cd", length));
			String[] rfaExptMapgSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_mapg_seq", length));
			String[] rfaExptDarNo = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_dar_no", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] rfaExptVerSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_ver_seq", length));
			String[] rfaRqstDtlSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_rqst_dtl_seq", length));
			String[] bzcTrfGrpSeq = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_grp_seq", length));
			String[] ftEndDt = (JSPUtil.getParameter(request, prefix	+ "ft_end_dt", length));
			String[] rtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_amt", length));
			String[] toMvmtDt = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] ftOver = (JSPUtil.getParameter(request, prefix	+ "ft_over", length));
			String[] scExptGrpSeq = (JSPUtil.getParameter(request, prefix	+ "sc_expt_grp_seq", length));
			String[] ftCmncDt = (JSPUtil.getParameter(request, prefix	+ "ft_cmnc_dt", length));
			String[] ftUnder = (JSPUtil.getParameter(request, prefix	+ "ft_under", length));
			String[] rtCurrCd = (JSPUtil.getParameter(request, prefix	+ "rt_curr_cd", length));
			String[] ftDys = (JSPUtil.getParameter(request, prefix	+ "ft_dys", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] fmMvmtDt = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_dt", length));
			String[] bzcTrfSeq = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new DemandNoteRDListVO();
				if (bzcTrfCurrCd[i] != null)
					model.setBzcTrfCurrCd(bzcTrfCurrCd[i]);
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);
				if (scExptVerSeq[i] != null)
					model.setScExptVerSeq(scExptVerSeq[i]);
				if (dmdtTrfAplyTpCd[i] != null)
					model.setDmdtTrfAplyTpCd(dmdtTrfAplyTpCd[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (rtDay[i] != null)
					model.setRtDay(rtDay[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rtChrgAmt[i] != null)
					model.setRtChrgAmt(rtChrgAmt[i]);
				if (fxFtOvrDys[i] != null)
					model.setFxFtOvrDys(fxFtOvrDys[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dmdtChgStsCd[i] != null)
					model.setDmdtChgStsCd(dmdtChgStsCd[i]);
				if (rfaExptMapgSeq[i] != null)
					model.setRfaExptMapgSeq(rfaExptMapgSeq[i]);
				if (rfaExptDarNo[i] != null)
					model.setRfaExptDarNo(rfaExptDarNo[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (rfaExptVerSeq[i] != null)
					model.setRfaExptVerSeq(rfaExptVerSeq[i]);
				if (rfaRqstDtlSeq[i] != null)
					model.setRfaRqstDtlSeq(rfaRqstDtlSeq[i]);
				if (bzcTrfGrpSeq[i] != null)
					model.setBzcTrfGrpSeq(bzcTrfGrpSeq[i]);
				if (ftEndDt[i] != null)
					model.setFtEndDt(ftEndDt[i]);
				if (rtAmt[i] != null)
					model.setRtAmt(rtAmt[i]);
				if (toMvmtDt[i] != null)
					model.setToMvmtDt(toMvmtDt[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (ftOver[i] != null)
					model.setFtOver(ftOver[i]);
				if (scExptGrpSeq[i] != null)
					model.setScExptGrpSeq(scExptGrpSeq[i]);
				if (ftCmncDt[i] != null)
					model.setFtCmncDt(ftCmncDt[i]);
				if (ftUnder[i] != null)
					model.setFtUnder(ftUnder[i]);
				if (rtCurrCd[i] != null)
					model.setRtCurrCd(rtCurrCd[i]);
				if (ftDys[i] != null)
					model.setFtDys(ftDys[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (fmMvmtDt[i] != null)
					model.setFmMvmtDt(fmMvmtDt[i]);
				if (bzcTrfSeq[i] != null)
					model.setBzcTrfSeq(bzcTrfSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDemandNoteRDListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DemandNoteRDListVO[]
	 */
	public DemandNoteRDListVO[] getDemandNoteRDListVOs(){
		DemandNoteRDListVO[] vos = (DemandNoteRDListVO[])models.toArray(new DemandNoteRDListVO[models.size()]);
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
		this.bzcTrfCurrCd = this.bzcTrfCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptVerSeq = this.scExptVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfAplyTpCd = this.dmdtTrfAplyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtDay = this.rtDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtChrgAmt = this.rtChrgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxFtOvrDys = this.fxFtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgStsCd = this.dmdtChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptMapgSeq = this.rfaExptMapgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptDarNo = this.rfaExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptVerSeq = this.rfaExptVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaRqstDtlSeq = this.rfaRqstDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfGrpSeq = this.bzcTrfGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftEndDt = this.ftEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAmt = this.rtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDt = this.toMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftOver = this.ftOver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptGrpSeq = this.scExptGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftCmncDt = this.ftCmncDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftUnder = this.ftUnder .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtCurrCd = this.rtCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftDys = this.ftDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtDt = this.fmMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfSeq = this.bzcTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
