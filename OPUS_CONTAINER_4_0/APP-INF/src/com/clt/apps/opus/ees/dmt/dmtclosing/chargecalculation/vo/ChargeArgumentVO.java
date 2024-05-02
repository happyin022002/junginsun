/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeArgumentVO.java
*@FileTitle : ChargeArgumentVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.01
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.11.01 황효근 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo;

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
 * @author 황효근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChargeArgumentVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChargeArgumentVO> models = new ArrayList<ChargeArgumentVO>();
	
	/* Column Info */
	private String corrRmk = null;
	/* Column Info */
	private String dulTpExptFlg = null;
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String backendjobKey = null;
	/* Column Info */
	private String callFlag = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String schChgSts = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String fxFtOvrDys = null;
	/* Column Info */
	private String svrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dmdtChgStsCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String crInvNo = null;
	/* Column Info */
	private String webIndFlg = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String toMvmtDt = null;
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String ofcRhqCd = null;
	/* Column Info */
	private String fmMvmtYdCd = null;
	/* Column Info */
	private String chgType = null;
	/* Column Info */
	private String truckerCd = null;
	/* Column Info */
	private String bypodeta = null;
	/* Column Info */
	private String bydr = null;
	/* Column Info */
	private String dmdtInvNo = null;
	/* Column Info */
	private String errCode = null;
	/* Column Info */
	private String drDt = null;
	/* Column Info */
	private String rhqOfcCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String backendjobId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String errMsg = null;
	/* Column Info */
	private String fmMvmtDt = null;
	/* Column Info */
	private String estMk = null;
	/* Column Info */
	private String deltSeq = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String uclmFlg = null;
	/* Column Info */
	private String fmMvmtDtTime = null;
	/* Column Info */
	private String toMvmtDtTime = null;
	/* Column Info */
	private String batchCntr = null;
	/*	Column Info	*/
	private String today   =  null;
	/*	Column Info	*/
	private String usrOfcCd   =  null;
	/*	Column Info	*/
	private String batRunTmId   =  null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChargeArgumentVO() {}

	public ChargeArgumentVO(String ibflag, String pagerows, String callFlag, String estMk, String schChgSts, String svrId, String bkgNo, String blNo, String dmdtTrfCd, String dmdtChgStsCd, String bypodeta, String cntrNo, String cntrCycNo, String dmdtChgLocDivCd, String chgType, String chgSeq, String cntCd, String fmMvmtDt, String toMvmtDt, String webIndFlg, String bydr, String ofcCd, String ofcRhqCd, String rhqOfcCd, String dmdtInvNo, String drDt, String crInvNo, String errCode, String errMsg, String truckerCd, String dulTpExptFlg, String corrRmk, String backendjobKey, String backendjobId, String fxFtOvrDys, String stsCd, String fmMvmtYdCd, String deltSeq, String updUsrId, String updOfcCd, String uclmFlg, String fmMvmtDtTime, String toMvmtDtTime, String batchCntr, String today, String usrOfcCd, String batRunTmId) {
		this.corrRmk = corrRmk;
		this.dulTpExptFlg = dulTpExptFlg;
		this.cntrCycNo = cntrCycNo;
		this.backendjobKey = backendjobKey;
		this.callFlag = callFlag;
		this.chgSeq = chgSeq;
		this.blNo = blNo;
		this.schChgSts = schChgSts;
		this.pagerows = pagerows;
		this.stsCd = stsCd;
		this.fxFtOvrDys = fxFtOvrDys;
		this.svrId = svrId;
		this.ibflag = ibflag;
		this.dmdtChgStsCd = dmdtChgStsCd;
		this.cntCd = cntCd;
		this.crInvNo = crInvNo;
		this.webIndFlg = webIndFlg;
		this.dmdtTrfCd = dmdtTrfCd;
		this.toMvmtDt = toMvmtDt;
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.ofcRhqCd = ofcRhqCd;
		this.fmMvmtYdCd = fmMvmtYdCd;
		this.chgType = chgType;
		this.truckerCd = truckerCd;
		this.bypodeta = bypodeta;
		this.bydr = bydr;
		this.dmdtInvNo = dmdtInvNo;
		this.errCode = errCode;
		this.drDt = drDt;
		this.rhqOfcCd = rhqOfcCd;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.backendjobId = backendjobId;
		this.cntrNo = cntrNo;
		this.errMsg = errMsg;
		this.fmMvmtDt = fmMvmtDt;
		this.estMk = estMk;
		this.deltSeq = deltSeq; 
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.uclmFlg = uclmFlg;
		this.fmMvmtDtTime = fmMvmtDtTime;
		this.toMvmtDtTime = toMvmtDtTime;
		this.batchCntr = batchCntr;
		this.today  = today ;
		this.usrOfcCd  = usrOfcCd ;
		this.batRunTmId = batRunTmId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("corr_rmk", getCorrRmk());
		this.hashColumns.put("dul_tp_expt_flg", getDulTpExptFlg());
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("backendjob_key", getBackendjobKey());
		this.hashColumns.put("call_flag", getCallFlag());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("sch_chg_sts", getSchChgSts());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("fx_ft_ovr_dys", getFxFtOvrDys());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dmdt_chg_sts_cd", getDmdtChgStsCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("cr_inv_no", getCrInvNo());
		this.hashColumns.put("web_ind_flg", getWebIndFlg());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("to_mvmt_dt", getToMvmtDt());
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("ofc_rhq_cd", getOfcRhqCd());
		this.hashColumns.put("fm_mvmt_yd_cd", getFmMvmtYdCd());
		this.hashColumns.put("chg_type", getChgType());
		this.hashColumns.put("trucker_cd", getTruckerCd());
		this.hashColumns.put("bypodeta", getBypodeta());
		this.hashColumns.put("bydr", getBydr());
		this.hashColumns.put("dmdt_inv_no", getDmdtInvNo());
		this.hashColumns.put("err_code", getErrCode());
		this.hashColumns.put("dr_dt", getDrDt());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("backendjob_id", getBackendjobId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("err_msg", getErrMsg());
		this.hashColumns.put("fm_mvmt_dt", getFmMvmtDt());
		this.hashColumns.put("est_mk", getEstMk());
		this.hashColumns.put("delt_seq", getDeltSeq());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("uclm_flg", getUclmFlg());
		this.hashColumns.put("fm_mvmt_dt_time", getFmMvmtDtTime());
		this.hashColumns.put("to_mvmt_dt_time", getToMvmtDtTime());
		this.hashColumns.put("batch_cntr", getBatchCntr());	
		this.hashColumns.put("today", getToday());		
		this.hashColumns.put("usr_ofc_cd", getUsrOfcCd());		
		this.hashColumns.put("bat_run_tm_id", getBatRunTmId());		

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("corr_rmk", "corrRmk");
		this.hashFields.put("dul_tp_expt_flg", "dulTpExptFlg");
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("backendjob_key", "backendjobKey");
		this.hashFields.put("call_flag", "callFlag");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("sch_chg_sts", "schChgSts");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("fx_ft_ovr_dys", "fxFtOvrDys");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dmdt_chg_sts_cd", "dmdtChgStsCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("cr_inv_no", "crInvNo");
		this.hashFields.put("web_ind_flg", "webIndFlg");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("to_mvmt_dt", "toMvmtDt");
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("ofc_rhq_cd", "ofcRhqCd");
		this.hashFields.put("fm_mvmt_yd_cd", "fmMvmtYdCd");
		this.hashFields.put("chg_type", "chgType");
		this.hashFields.put("trucker_cd", "truckerCd");
		this.hashFields.put("bypodeta", "bypodeta");
		this.hashFields.put("bydr", "bydr");
		this.hashFields.put("dmdt_inv_no", "dmdtInvNo");
		this.hashFields.put("err_code", "errCode");
		this.hashFields.put("dr_dt", "drDt");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("backendjob_id", "backendjobId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("err_msg", "errMsg");
		this.hashFields.put("fm_mvmt_dt", "fmMvmtDt");
		this.hashFields.put("est_mk", "estMk");
		this.hashFields.put("delt_seq", "deltSeq");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("uclm_flg", "uclmFlg");
		this.hashFields.put("fm_mvmt_dt_time", "fmMvmtDtTime");
		this.hashFields.put("to_mvmt_dt_time", "toMvmtDtTime");
		this.hashFields.put("batch_cntr", "batchCntr");
		this.hashFields.put("today", "today");
		this.hashFields.put("usr_ofc_cd", "usrOfcCd");
		this.hashFields.put("bat_run_tm_id", "batRunTmId");

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
	 * @return backendjobKey
	 */
	public String getBackendjobKey() {
		return this.backendjobKey;
	}
	
	/**
	 * Column Info
	 * @return callFlag
	 */
	public String getCallFlag() {
		return this.callFlag;
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
	 * Column Info
	 * @return schChgSts
	 */
	public String getSchChgSts() {
		return this.schChgSts;
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
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
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
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return crInvNo
	 */
	public String getCrInvNo() {
		return this.crInvNo;
	}
	
	/**
	 * Column Info
	 * @return webIndFlg
	 */
	public String getWebIndFlg() {
		return this.webIndFlg;
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
	 * @return toMvmtDt
	 */
	public String getToMvmtDt() {
		return this.toMvmtDt;
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
	 * @return ofcRhqCd
	 */
	public String getOfcRhqCd() {
		return this.ofcRhqCd;
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
	 * @return chgType
	 */
	public String getChgType() {
		return this.chgType;
	}
	
	/**
	 * Column Info
	 * @return truckerCd
	 */
	public String getTruckerCd() {
		return this.truckerCd;
	}
	
	/**
	 * Column Info
	 * @return bypodeta
	 */
	public String getBypodeta() {
		return this.bypodeta;
	}
	
	/**
	 * Column Info
	 * @return bydr
	 */
	public String getBydr() {
		return this.bydr;
	}
	
	/**
	 * Column Info
	 * @return dmdtInvNo
	 */
	public String getDmdtInvNo() {
		return this.dmdtInvNo;
	}
	
	/**
	 * Column Info
	 * @return errCode
	 */
	public String getErrCode() {
		return this.errCode;
	}
	
	/**
	 * Column Info
	 * @return drDt
	 */
	public String getDrDt() {
		return this.drDt;
	}
	
	/**
	 * Column Info
	 * @return rhqOfcCd
	 */
	public String getRhqOfcCd() {
		return this.rhqOfcCd;
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
	 * @return backendjobId
	 */
	public String getBackendjobId() {
		return this.backendjobId;
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
	 * @return errMsg
	 */
	public String getErrMsg() {
		return this.errMsg;
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
	 * @return estMk
	 */
	public String getEstMk() {
		return this.estMk;
	}
	
	/**
	 * Column Info
	 * @return deltSeq
	 */	
	public String getDeltSeq() {
		return deltSeq;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */	
	public String getUpdOfcCd() {
		return updOfcCd;
	}

	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}
	
	/**
	 * Column Info
	 * @return uclmFlg
	 */
	public String getUclmFlg() {
		return uclmFlg;
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
	 * @param backendjobKey
	 */
	public void setBackendjobKey(String backendjobKey) {
		this.backendjobKey = backendjobKey;
	}
	
	/**
	 * Column Info
	 * @param callFlag
	 */
	public void setCallFlag(String callFlag) {
		this.callFlag = callFlag;
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
	 * Column Info
	 * @param schChgSts
	 */
	public void setSchChgSts(String schChgSts) {
		this.schChgSts = schChgSts;
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
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
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
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param crInvNo
	 */
	public void setCrInvNo(String crInvNo) {
		this.crInvNo = crInvNo;
	}
	
	/**
	 * Column Info
	 * @param webIndFlg
	 */
	public void setWebIndFlg(String webIndFlg) {
		this.webIndFlg = webIndFlg;
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
	 * @param toMvmtDt
	 */
	public void setToMvmtDt(String toMvmtDt) {
		this.toMvmtDt = toMvmtDt;
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
	 * @param ofcRhqCd
	 */
	public void setOfcRhqCd(String ofcRhqCd) {
		this.ofcRhqCd = ofcRhqCd;
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
	 * @param chgType
	 */
	public void setChgType(String chgType) {
		this.chgType = chgType;
	}
	
	/**
	 * Column Info
	 * @param truckerCd
	 */
	public void setTruckerCd(String truckerCd) {
		this.truckerCd = truckerCd;
	}
	
	/**
	 * Column Info
	 * @param bypodeta
	 */
	public void setBypodeta(String bypodeta) {
		this.bypodeta = bypodeta;
	}
	
	/**
	 * Column Info
	 * @param bydr
	 */
	public void setBydr(String bydr) {
		this.bydr = bydr;
	}
	
	/**
	 * Column Info
	 * @param dmdtInvNo
	 */
	public void setDmdtInvNo(String dmdtInvNo) {
		this.dmdtInvNo = dmdtInvNo;
	}
	
	/**
	 * Column Info
	 * @param errCode
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	
	/**
	 * Column Info
	 * @param drDt
	 */
	public void setDrDt(String drDt) {
		this.drDt = drDt;
	}
	
	/**
	 * Column Info
	 * @param rhqOfcCd
	 */
	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
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
	 * @param backendjobId
	 */
	public void setBackendjobId(String backendjobId) {
		this.backendjobId = backendjobId;
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
	 * @param errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
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
	 * @param estMk
	 */
	public void setEstMk(String estMk) {
		this.estMk = estMk;
	}
	
	/**
	 * Column Info
	 * @return deltSeq
	 */	
	public void setDeltSeq(String deltSeq) {
		this.deltSeq = deltSeq;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */	
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @return uclmFlg
	 */
	public void setUclmFlg(String uclmFlg) {
		this.uclmFlg = uclmFlg;
	}
	
	public String getFmMvmtDtTime() {
		return fmMvmtDtTime;
	}

	public void setFmMvmtDtTime(String fmMvmtDtTime) {
		this.fmMvmtDtTime = fmMvmtDtTime;
	}

	public String getToMvmtDtTime() {
		return toMvmtDtTime;
	}

	public void setToMvmtDtTime(String toMvmtDtTime) {
		this.toMvmtDtTime = toMvmtDtTime;
	}

	public String getBatchCntr() {
		return batchCntr;
	}

	public void setBatchCntr(String batchCntr) {
		this.batchCntr = batchCntr;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public String getUsrOfcCd() {
		return usrOfcCd;
	}

	public void setUsrOfcCd(String usrOfcCd) {
		this.usrOfcCd = usrOfcCd;
	}

	public String getBatRunTmId() {
		return batRunTmId;
	}

	public void setBatRunTmId(String batRunTmId) {
		this.batRunTmId = batRunTmId;
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
		setCorrRmk(JSPUtil.getParameter(request, prefix + "corr_rmk", ""));
		setDulTpExptFlg(JSPUtil.getParameter(request, prefix + "dul_tp_expt_flg", ""));
		setCntrCycNo(JSPUtil.getParameter(request, prefix + "cntr_cyc_no", ""));
		setBackendjobKey(JSPUtil.getParameter(request, prefix + "backendjob_key", ""));
		setCallFlag(JSPUtil.getParameter(request, prefix + "call_flag", ""));
		setChgSeq(JSPUtil.getParameter(request, prefix + "chg_seq", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setSchChgSts(JSPUtil.getParameter(request, prefix + "sch_chg_sts", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setStsCd(JSPUtil.getParameter(request, prefix + "sts_cd", ""));
		setFxFtOvrDys(JSPUtil.getParameter(request, prefix + "fx_ft_ovr_dys", ""));
		setSvrId(JSPUtil.getParameter(request, prefix + "svr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDmdtChgStsCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_sts_cd", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setCrInvNo(JSPUtil.getParameter(request, prefix + "cr_inv_no", ""));
		setWebIndFlg(JSPUtil.getParameter(request, prefix + "web_ind_flg", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setToMvmtDt(JSPUtil.getParameter(request, prefix + "to_mvmt_dt", ""));
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_loc_div_cd", ""));
		setOfcRhqCd(JSPUtil.getParameter(request, prefix + "ofc_rhq_cd", ""));
		setFmMvmtYdCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_yd_cd", ""));
		setChgType(JSPUtil.getParameter(request, prefix + "chg_type", ""));
		setTruckerCd(JSPUtil.getParameter(request, prefix + "trucker_cd", ""));
		setBypodeta(JSPUtil.getParameter(request, prefix + "bypodeta", ""));
		setBydr(JSPUtil.getParameter(request, prefix + "bydr", ""));
		setDmdtInvNo(JSPUtil.getParameter(request, prefix + "dmdt_inv_no", ""));
		setErrCode(JSPUtil.getParameter(request, prefix + "err_code", ""));
		setDrDt(JSPUtil.getParameter(request, prefix + "dr_dt", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setBackendjobId(JSPUtil.getParameter(request, prefix + "backendjob_id", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setErrMsg(JSPUtil.getParameter(request, prefix + "err_msg", ""));
		setFmMvmtDt(JSPUtil.getParameter(request, prefix + "fm_mvmt_dt", ""));
		setEstMk(JSPUtil.getParameter(request, prefix + "est_mk", ""));
		setDeltSeq(JSPUtil.getParameter(request, prefix + "delt_seq", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUclmFlg(JSPUtil.getParameter(request, "uclm_flg", ""));
		setFmMvmtDtTime(JSPUtil.getParameter(request, "fm_mvmt_dt_time", ""));
		setToMvmtDtTime(JSPUtil.getParameter(request, "to_mvmt_dt_time", ""));
		setBatchCntr(JSPUtil.getParameter(request,	prefix + "batch_cntr", ""));
		setToday(JSPUtil.getParameter(request,	prefix + "today", ""));
		setUsrOfcCd(JSPUtil.getParameter(request,	prefix + "usr_ofc_cd", ""));
		setBatRunTmId(JSPUtil.getParameter(request,	prefix + "bat_run_tm_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeArgumentVO[]
	 */
	public ChargeArgumentVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeArgumentVO[]
	 */
	public ChargeArgumentVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChargeArgumentVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] corrRmk = (JSPUtil.getParameter(request, prefix	+ "corr_rmk", length));
			String[] dulTpExptFlg = (JSPUtil.getParameter(request, prefix	+ "dul_tp_expt_flg", length));
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] backendjobKey = (JSPUtil.getParameter(request, prefix	+ "backendjob_key", length));
			String[] callFlag = (JSPUtil.getParameter(request, prefix	+ "call_flag", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] schChgSts = (JSPUtil.getParameter(request, prefix	+ "sch_chg_sts", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] fxFtOvrDys = (JSPUtil.getParameter(request, prefix	+ "fx_ft_ovr_dys", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dmdtChgStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_sts_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] crInvNo = (JSPUtil.getParameter(request, prefix	+ "cr_inv_no", length));
			String[] webIndFlg = (JSPUtil.getParameter(request, prefix	+ "web_ind_flg", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] toMvmtDt = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt", length));
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] ofcRhqCd = (JSPUtil.getParameter(request, prefix	+ "ofc_rhq_cd", length));
			String[] fmMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_yd_cd", length));
			String[] chgType = (JSPUtil.getParameter(request, prefix	+ "chg_type", length));
			String[] truckerCd = (JSPUtil.getParameter(request, prefix	+ "trucker_cd", length));
			String[] bypodeta = (JSPUtil.getParameter(request, prefix	+ "bypodeta", length));
			String[] bydr = (JSPUtil.getParameter(request, prefix	+ "bydr", length));
			String[] dmdtInvNo = (JSPUtil.getParameter(request, prefix	+ "dmdt_inv_no", length));
			String[] errCode = (JSPUtil.getParameter(request, prefix	+ "err_code", length));
			String[] drDt = (JSPUtil.getParameter(request, prefix	+ "dr_dt", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] backendjobId = (JSPUtil.getParameter(request, prefix	+ "backendjob_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] errMsg = (JSPUtil.getParameter(request, prefix	+ "err_msg", length));
			String[] fmMvmtDt = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_dt", length));
			String[] estMk = (JSPUtil.getParameter(request, prefix	+ "est_mk", length));
			String[] deltSeq = (JSPUtil.getParameter(request, prefix	+ "delt_seq", length));	
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] uclmFlg = (JSPUtil.getParameter(request, prefix	+ "uclm_flg", length));
			String[] fmMvmtDtTime = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_dt_time", length));
			String[] toMvmtDtTime = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt_time", length));
			String[] batchCntr =	(JSPUtil.getParameter(request, prefix +	"batch_cntr".trim(),	length));
			String[] today =	(JSPUtil.getParameter(request, prefix +	"today".trim(),	length));
			String[] usrOfcCd =	(JSPUtil.getParameter(request, prefix +	"usr_ofc_cd".trim(),	length));
			String[] batRunTmId =	(JSPUtil.getParameter(request, prefix +	"bat_run_tm_id".trim(),	length));
			
			for (int i = 0; i < length; i++) {
				model = new ChargeArgumentVO();
				if (corrRmk[i] != null)
					model.setCorrRmk(corrRmk[i]);
				if (dulTpExptFlg[i] != null)
					model.setDulTpExptFlg(dulTpExptFlg[i]);
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);
				if (backendjobKey[i] != null)
					model.setBackendjobKey(backendjobKey[i]);
				if (callFlag[i] != null)
					model.setCallFlag(callFlag[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (schChgSts[i] != null)
					model.setSchChgSts(schChgSts[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (fxFtOvrDys[i] != null)
					model.setFxFtOvrDys(fxFtOvrDys[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dmdtChgStsCd[i] != null)
					model.setDmdtChgStsCd(dmdtChgStsCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (crInvNo[i] != null)
					model.setCrInvNo(crInvNo[i]);
				if (webIndFlg[i] != null)
					model.setWebIndFlg(webIndFlg[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (toMvmtDt[i] != null)
					model.setToMvmtDt(toMvmtDt[i]);
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (ofcRhqCd[i] != null)
					model.setOfcRhqCd(ofcRhqCd[i]);
				if (fmMvmtYdCd[i] != null)
					model.setFmMvmtYdCd(fmMvmtYdCd[i]);
				if (chgType[i] != null)
					model.setChgType(chgType[i]);
				if (truckerCd[i] != null)
					model.setTruckerCd(truckerCd[i]);
				if (bypodeta[i] != null)
					model.setBypodeta(bypodeta[i]);
				if (bydr[i] != null)
					model.setBydr(bydr[i]);
				if (dmdtInvNo[i] != null)
					model.setDmdtInvNo(dmdtInvNo[i]);
				if (errCode[i] != null)
					model.setErrCode(errCode[i]);
				if (drDt[i] != null)
					model.setDrDt(drDt[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (backendjobId[i] != null)
					model.setBackendjobId(backendjobId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (errMsg[i] != null)
					model.setErrMsg(errMsg[i]);
				if (fmMvmtDt[i] != null)
					model.setFmMvmtDt(fmMvmtDt[i]);
				if (estMk[i] != null)
					model.setEstMk(estMk[i]);
				if (deltSeq[i] != null)
					model.setDeltSeq(deltSeq[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (uclmFlg[i] != null)
					model.setUclmFlg(uclmFlg[i]);
				if (fmMvmtDtTime[i] != null)
					model.setFmMvmtDtTime(fmMvmtDtTime[i]);
				if (toMvmtDtTime[i] != null)
					model.setToMvmtDtTime(toMvmtDtTime[i]);
				if ( batchCntr[i] !=	null)
					model.setBatchCntr( batchCntr[i]);
				if ( today[i] !=	null)
					model.setToday( today[i]);
				if ( usrOfcCd[i] !=	null)
					model.setUsrOfcCd( usrOfcCd[i]);
				if ( batRunTmId[i] !=	null)
					model.setBatRunTmId( batRunTmId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChargeArgumentVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChargeArgumentVO[]
	 */
	public ChargeArgumentVO[] getChargeArgumentVOs(){
		ChargeArgumentVO[] vos = (ChargeArgumentVO[])models.toArray(new ChargeArgumentVO[models.size()]);
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
		this.dulTpExptFlg = this.dulTpExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.backendjobKey = this.backendjobKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callFlag = this.callFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schChgSts = this.schChgSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxFtOvrDys = this.fxFtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgStsCd = this.dmdtChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crInvNo = this.crInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webIndFlg = this.webIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDt = this.toMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcRhqCd = this.ofcRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtYdCd = this.fmMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgType = this.chgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.truckerCd = this.truckerCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bypodeta = this.bypodeta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bydr = this.bydr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtInvNo = this.dmdtInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCode = this.errCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drDt = this.drDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.backendjobId = this.backendjobId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsg = this.errMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtDt = this.fmMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estMk = this.estMk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltSeq = this.deltSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmFlg = this.uclmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtDtTime = this.fmMvmtDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDtTime = this.toMvmtDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batchCntr =	this.batchCntr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.today =	this.today.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfcCd =	this.usrOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batRunTmId =	this.batRunTmId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
