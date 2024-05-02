/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqr1013ConditionVO.java
*@FileTitle : EesEqr1013ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

public class EesEqr1013ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr1013ConditionVO> models = new ArrayList<EesEqr1013ConditionVO>();
	
	/* Column Info */
	private String subtrade = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String plnRsnHdrCode = null;
	/* Column Info */
	private String ofcTpCd = null;
	/* Column Info */
	private String sSubLocCd = null;
	/* Column Info */
	private String lclDt = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String locTpCdSecond = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fmWk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sEffStDt = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String sVvdCd = null;
	/* Column Info */
	private String plnRsnHdrText = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String sPolCd = null;
	/* Column Info */
	private String vvdRslt = null;
	/* Column Info */
	private String loginOfcConticCd = null;
	/* Column Info */
	private String tpsztype = null;
	/* Column Info */
	private String locCdSecond = null;
	/* Column Info */
	private String toWk = null;
	/* Column Info */
	private String sCfmFlg = null;
	/* Column Info */
	private String rlane = null;
	/* Column Info */
	private String eqGlineSeq = null;
	/* Column Info */
	private String sEtaDt = null;
	/* Column Info */
	private String sFcbfEndDt = null;
	/* Column Info */
	private String sLocCd = null;
	/* Column Info */
	private String plnRsnHdrCodeNText = null;
	/* Column Info */
	private String vvdRetrieveVal = null;
	/* Column Info */
	private String plnRsnHdrCd = null;
	/* Column Info */
	private String mainPage = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String plnRsnSubCode = null;
	/* Column Info */
	private String plnRsnSubText = null;
	/* Column Info */
	private String etaToDt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String sDtTpCd = null;
	/* Column Info */
	private String sFcbfStDt = null;
	/* Column Info */
	private String plnRsnSubCodeNText = null;
	/* Column Info */
	private String sEffEndDt = null;
	/* Column Info */
	private String etaFmDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr1013ConditionVO() {}

	public EesEqr1013ConditionVO(String ibflag, String pagerows, String plnRsnHdrCd, String subtrade, String trade, String ofcTpCd, String lclDt, String sSubLocCd, String locTpCdSecond, String lane, String rlane, String fmWk, String sEffStDt, String usrId, String sVvdCd, String cntrTpszCd, String sPolCd, String vvdRslt, String tpsztype, String locCdSecond, String toWk, String sCfmFlg, String eqGlineSeq, String sEtaDt, String sFcbfEndDt, String sLocCd, String vvdRetrieveVal, String mainPage, String rccCd, String etaToDt, String ofcCd, String tpsz, String sDtTpCd, String sFcbfStDt, String sEffEndDt, String etaFmDt, String plnRsnHdrCodeNText, String plnRsnSubCodeNText, String plnRsnHdrCode, String plnRsnHdrText, String plnRsnSubCode, String plnRsnSubText, String loginOfcConticCd) {
		this.subtrade = subtrade;
		this.trade = trade;
		this.plnRsnHdrCode = plnRsnHdrCode;
		this.ofcTpCd = ofcTpCd;
		this.sSubLocCd = sSubLocCd;
		this.lclDt = lclDt;
		this.lane = lane;
		this.locTpCdSecond = locTpCdSecond;
		this.pagerows = pagerows;
		this.fmWk = fmWk;
		this.ibflag = ibflag;
		this.sEffStDt = sEffStDt;
		this.usrId = usrId;
		this.sVvdCd = sVvdCd;
		this.plnRsnHdrText = plnRsnHdrText;
		this.cntrTpszCd = cntrTpszCd;
		this.sPolCd = sPolCd;
		this.vvdRslt = vvdRslt;
		this.loginOfcConticCd = loginOfcConticCd;
		this.tpsztype = tpsztype;
		this.locCdSecond = locCdSecond;
		this.toWk = toWk;
		this.sCfmFlg = sCfmFlg;
		this.rlane = rlane;
		this.eqGlineSeq = eqGlineSeq;
		this.sEtaDt = sEtaDt;
		this.sFcbfEndDt = sFcbfEndDt;
		this.sLocCd = sLocCd;
		this.plnRsnHdrCodeNText = plnRsnHdrCodeNText;
		this.vvdRetrieveVal = vvdRetrieveVal;
		this.plnRsnHdrCd = plnRsnHdrCd;
		this.mainPage = mainPage;
		this.rccCd = rccCd;
		this.plnRsnSubCode = plnRsnSubCode;
		this.plnRsnSubText = plnRsnSubText;
		this.etaToDt = etaToDt;
		this.ofcCd = ofcCd;
		this.tpsz = tpsz;
		this.sDtTpCd = sDtTpCd;
		this.sFcbfStDt = sFcbfStDt;
		this.plnRsnSubCodeNText = plnRsnSubCodeNText;
		this.sEffEndDt = sEffEndDt;
		this.etaFmDt = etaFmDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("subtrade", getSubtrade());
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("pln_rsn_hdr_code", getPlnRsnHdrCode());
		this.hashColumns.put("ofc_tp_cd", getOfcTpCd());
		this.hashColumns.put("s_sub_loc_cd", getSSubLocCd());
		this.hashColumns.put("lcl_dt", getLclDt());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("loc_tp_cd_second", getLocTpCdSecond());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fm_wk", getFmWk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_eff_st_dt", getSEffStDt());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("s_vvd_cd", getSVvdCd());
		this.hashColumns.put("pln_rsn_hdr_text", getPlnRsnHdrText());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("s_pol_cd", getSPolCd());
		this.hashColumns.put("vvd_rslt", getVvdRslt());
		this.hashColumns.put("login_ofc_contic_cd", getLoginOfcConticCd());
		this.hashColumns.put("tpsztype", getTpsztype());
		this.hashColumns.put("loc_cd_second", getLocCdSecond());
		this.hashColumns.put("to_wk", getToWk());
		this.hashColumns.put("s_cfm_flg", getSCfmFlg());
		this.hashColumns.put("rlane", getRlane());
		this.hashColumns.put("eq_gline_seq", getEqGlineSeq());
		this.hashColumns.put("s_eta_dt", getSEtaDt());
		this.hashColumns.put("s_fcbf_end_dt", getSFcbfEndDt());
		this.hashColumns.put("s_loc_cd", getSLocCd());
		this.hashColumns.put("pln_rsn_hdr_code_n_text", getPlnRsnHdrCodeNText());
		this.hashColumns.put("vvd_retrieve_val", getVvdRetrieveVal());
		this.hashColumns.put("pln_rsn_hdr_cd", getPlnRsnHdrCd());
		this.hashColumns.put("main_page", getMainPage());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("pln_rsn_sub_code", getPlnRsnSubCode());
		this.hashColumns.put("pln_rsn_sub_text", getPlnRsnSubText());
		this.hashColumns.put("eta_to_dt", getEtaToDt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("s_dt_tp_cd", getSDtTpCd());
		this.hashColumns.put("s_fcbf_st_dt", getSFcbfStDt());
		this.hashColumns.put("pln_rsn_sub_code_n_text", getPlnRsnSubCodeNText());
		this.hashColumns.put("s_eff_end_dt", getSEffEndDt());
		this.hashColumns.put("eta_fm_dt", getEtaFmDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("subtrade", "subtrade");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("pln_rsn_hdr_code", "plnRsnHdrCode");
		this.hashFields.put("ofc_tp_cd", "ofcTpCd");
		this.hashFields.put("s_sub_loc_cd", "sSubLocCd");
		this.hashFields.put("lcl_dt", "lclDt");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("loc_tp_cd_second", "locTpCdSecond");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fm_wk", "fmWk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_eff_st_dt", "sEffStDt");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("s_vvd_cd", "sVvdCd");
		this.hashFields.put("pln_rsn_hdr_text", "plnRsnHdrText");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("s_pol_cd", "sPolCd");
		this.hashFields.put("vvd_rslt", "vvdRslt");
		this.hashFields.put("login_ofc_contic_cd", "loginOfcConticCd");
		this.hashFields.put("tpsztype", "tpsztype");
		this.hashFields.put("loc_cd_second", "locCdSecond");
		this.hashFields.put("to_wk", "toWk");
		this.hashFields.put("s_cfm_flg", "sCfmFlg");
		this.hashFields.put("rlane", "rlane");
		this.hashFields.put("eq_gline_seq", "eqGlineSeq");
		this.hashFields.put("s_eta_dt", "sEtaDt");
		this.hashFields.put("s_fcbf_end_dt", "sFcbfEndDt");
		this.hashFields.put("s_loc_cd", "sLocCd");
		this.hashFields.put("pln_rsn_hdr_code_n_text", "plnRsnHdrCodeNText");
		this.hashFields.put("vvd_retrieve_val", "vvdRetrieveVal");
		this.hashFields.put("pln_rsn_hdr_cd", "plnRsnHdrCd");
		this.hashFields.put("main_page", "mainPage");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("pln_rsn_sub_code", "plnRsnSubCode");
		this.hashFields.put("pln_rsn_sub_text", "plnRsnSubText");
		this.hashFields.put("eta_to_dt", "etaToDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("s_dt_tp_cd", "sDtTpCd");
		this.hashFields.put("s_fcbf_st_dt", "sFcbfStDt");
		this.hashFields.put("pln_rsn_sub_code_n_text", "plnRsnSubCodeNText");
		this.hashFields.put("s_eff_end_dt", "sEffEndDt");
		this.hashFields.put("eta_fm_dt", "etaFmDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return subtrade
	 */
	public String getSubtrade() {
		return this.subtrade;
	}
	
	/**
	 * Column Info
	 * @return trade
	 */
	public String getTrade() {
		return this.trade;
	}
	
	/**
	 * Column Info
	 * @return plnRsnHdrCode
	 */
	public String getPlnRsnHdrCode() {
		return this.plnRsnHdrCode;
	}
	
	/**
	 * Column Info
	 * @return ofcTpCd
	 */
	public String getOfcTpCd() {
		return this.ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @return sSubLocCd
	 */
	public String getSSubLocCd() {
		return this.sSubLocCd;
	}
	
	/**
	 * Column Info
	 * @return lclDt
	 */
	public String getLclDt() {
		return this.lclDt;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}
	
	/**
	 * Column Info
	 * @return locTpCdSecond
	 */
	public String getLocTpCdSecond() {
		return this.locTpCdSecond;
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
	 * @return fmWk
	 */
	public String getFmWk() {
		return this.fmWk;
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
	 * @return sEffStDt
	 */
	public String getSEffStDt() {
		return this.sEffStDt;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return sVvdCd
	 */
	public String getSVvdCd() {
		return this.sVvdCd;
	}
	
	/**
	 * Column Info
	 * @return plnRsnHdrText
	 */
	public String getPlnRsnHdrText() {
		return this.plnRsnHdrText;
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
	 * @return sPolCd
	 */
	public String getSPolCd() {
		return this.sPolCd;
	}
	
	/**
	 * Column Info
	 * @return vvdRslt
	 */
	public String getVvdRslt() {
		return this.vvdRslt;
	}
	
	/**
	 * Column Info
	 * @return loginOfcConticCd
	 */
	public String getLoginOfcConticCd() {
		return this.loginOfcConticCd;
	}
	
	/**
	 * Column Info
	 * @return tpsztype
	 */
	public String getTpsztype() {
		return this.tpsztype;
	}
	
	/**
	 * Column Info
	 * @return locCdSecond
	 */
	public String getLocCdSecond() {
		return this.locCdSecond;
	}
	
	/**
	 * Column Info
	 * @return toWk
	 */
	public String getToWk() {
		return this.toWk;
	}
	
	/**
	 * Column Info
	 * @return sCfmFlg
	 */
	public String getSCfmFlg() {
		return this.sCfmFlg;
	}
	
	/**
	 * Column Info
	 * @return rlane
	 */
	public String getRlane() {
		return this.rlane;
	}
	
	/**
	 * Column Info
	 * @return eqGlineSeq
	 */
	public String getEqGlineSeq() {
		return this.eqGlineSeq;
	}
	
	/**
	 * Column Info
	 * @return sEtaDt
	 */
	public String getSEtaDt() {
		return this.sEtaDt;
	}
	
	/**
	 * Column Info
	 * @return sFcbfEndDt
	 */
	public String getSFcbfEndDt() {
		return this.sFcbfEndDt;
	}
	
	/**
	 * Column Info
	 * @return sLocCd
	 */
	public String getSLocCd() {
		return this.sLocCd;
	}
	
	/**
	 * Column Info
	 * @return plnRsnHdrCodeNText
	 */
	public String getPlnRsnHdrCodeNText() {
		return this.plnRsnHdrCodeNText;
	}
	
	/**
	 * Column Info
	 * @return vvdRetrieveVal
	 */
	public String getVvdRetrieveVal() {
		return this.vvdRetrieveVal;
	}
	
	/**
	 * Column Info
	 * @return plnRsnHdrCd
	 */
	public String getPlnRsnHdrCd() {
		return this.plnRsnHdrCd;
	}
	
	/**
	 * Column Info
	 * @return mainPage
	 */
	public String getMainPage() {
		return this.mainPage;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return plnRsnSubCode
	 */
	public String getPlnRsnSubCode() {
		return this.plnRsnSubCode;
	}
	
	/**
	 * Column Info
	 * @return plnRsnSubText
	 */
	public String getPlnRsnSubText() {
		return this.plnRsnSubText;
	}
	
	/**
	 * Column Info
	 * @return etaToDt
	 */
	public String getEtaToDt() {
		return this.etaToDt;
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
	 * @return tpsz
	 */
	public String getTpsz() {
		return this.tpsz;
	}
	
	/**
	 * Column Info
	 * @return sDtTpCd
	 */
	public String getSDtTpCd() {
		return this.sDtTpCd;
	}
	
	/**
	 * Column Info
	 * @return sFcbfStDt
	 */
	public String getSFcbfStDt() {
		return this.sFcbfStDt;
	}
	
	/**
	 * Column Info
	 * @return plnRsnSubCodeNText
	 */
	public String getPlnRsnSubCodeNText() {
		return this.plnRsnSubCodeNText;
	}
	
	/**
	 * Column Info
	 * @return sEffEndDt
	 */
	public String getSEffEndDt() {
		return this.sEffEndDt;
	}
	
	/**
	 * Column Info
	 * @return etaFmDt
	 */
	public String getEtaFmDt() {
		return this.etaFmDt;
	}
	

	/**
	 * Column Info
	 * @param subtrade
	 */
	public void setSubtrade(String subtrade) {
		this.subtrade = subtrade;
	}
	
	/**
	 * Column Info
	 * @param trade
	 */
	public void setTrade(String trade) {
		this.trade = trade;
	}
	
	/**
	 * Column Info
	 * @param plnRsnHdrCode
	 */
	public void setPlnRsnHdrCode(String plnRsnHdrCode) {
		this.plnRsnHdrCode = plnRsnHdrCode;
	}
	
	/**
	 * Column Info
	 * @param ofcTpCd
	 */
	public void setOfcTpCd(String ofcTpCd) {
		this.ofcTpCd = ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @param sSubLocCd
	 */
	public void setSSubLocCd(String sSubLocCd) {
		this.sSubLocCd = sSubLocCd;
	}
	
	/**
	 * Column Info
	 * @param lclDt
	 */
	public void setLclDt(String lclDt) {
		this.lclDt = lclDt;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Column Info
	 * @param locTpCdSecond
	 */
	public void setLocTpCdSecond(String locTpCdSecond) {
		this.locTpCdSecond = locTpCdSecond;
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
	 * @param fmWk
	 */
	public void setFmWk(String fmWk) {
		this.fmWk = fmWk;
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
	 * @param sEffStDt
	 */
	public void setSEffStDt(String sEffStDt) {
		this.sEffStDt = sEffStDt;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param sVvdCd
	 */
	public void setSVvdCd(String sVvdCd) {
		this.sVvdCd = sVvdCd;
	}
	
	/**
	 * Column Info
	 * @param plnRsnHdrText
	 */
	public void setPlnRsnHdrText(String plnRsnHdrText) {
		this.plnRsnHdrText = plnRsnHdrText;
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
	 * @param sPolCd
	 */
	public void setSPolCd(String sPolCd) {
		this.sPolCd = sPolCd;
	}
	
	/**
	 * Column Info
	 * @param vvdRslt
	 */
	public void setVvdRslt(String vvdRslt) {
		this.vvdRslt = vvdRslt;
	}
	
	/**
	 * Column Info
	 * @param loginOfcConticCd
	 */
	public void setLoginOfcConticCd(String loginOfcConticCd) {
		this.loginOfcConticCd = loginOfcConticCd;
	}
	
	/**
	 * Column Info
	 * @param tpsztype
	 */
	public void setTpsztype(String tpsztype) {
		this.tpsztype = tpsztype;
	}
	
	/**
	 * Column Info
	 * @param locCdSecond
	 */
	public void setLocCdSecond(String locCdSecond) {
		this.locCdSecond = locCdSecond;
	}
	
	/**
	 * Column Info
	 * @param toWk
	 */
	public void setToWk(String toWk) {
		this.toWk = toWk;
	}
	
	/**
	 * Column Info
	 * @param sCfmFlg
	 */
	public void setSCfmFlg(String sCfmFlg) {
		this.sCfmFlg = sCfmFlg;
	}
	
	/**
	 * Column Info
	 * @param rlane
	 */
	public void setRlane(String rlane) {
		this.rlane = rlane;
	}
	
	/**
	 * Column Info
	 * @param eqGlineSeq
	 */
	public void setEqGlineSeq(String eqGlineSeq) {
		this.eqGlineSeq = eqGlineSeq;
	}
	
	/**
	 * Column Info
	 * @param sEtaDt
	 */
	public void setSEtaDt(String sEtaDt) {
		this.sEtaDt = sEtaDt;
	}
	
	/**
	 * Column Info
	 * @param sFcbfEndDt
	 */
	public void setSFcbfEndDt(String sFcbfEndDt) {
		this.sFcbfEndDt = sFcbfEndDt;
	}
	
	/**
	 * Column Info
	 * @param sLocCd
	 */
	public void setSLocCd(String sLocCd) {
		this.sLocCd = sLocCd;
	}
	
	/**
	 * Column Info
	 * @param plnRsnHdrCodeNText
	 */
	public void setPlnRsnHdrCodeNText(String plnRsnHdrCodeNText) {
		this.plnRsnHdrCodeNText = plnRsnHdrCodeNText;
	}
	
	/**
	 * Column Info
	 * @param vvdRetrieveVal
	 */
	public void setVvdRetrieveVal(String vvdRetrieveVal) {
		this.vvdRetrieveVal = vvdRetrieveVal;
	}
	
	/**
	 * Column Info
	 * @param plnRsnHdrCd
	 */
	public void setPlnRsnHdrCd(String plnRsnHdrCd) {
		this.plnRsnHdrCd = plnRsnHdrCd;
	}
	
	/**
	 * Column Info
	 * @param mainPage
	 */
	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param plnRsnSubCode
	 */
	public void setPlnRsnSubCode(String plnRsnSubCode) {
		this.plnRsnSubCode = plnRsnSubCode;
	}
	
	/**
	 * Column Info
	 * @param plnRsnSubText
	 */
	public void setPlnRsnSubText(String plnRsnSubText) {
		this.plnRsnSubText = plnRsnSubText;
	}
	
	/**
	 * Column Info
	 * @param etaToDt
	 */
	public void setEtaToDt(String etaToDt) {
		this.etaToDt = etaToDt;
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
	 * @param tpsz
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}
	
	/**
	 * Column Info
	 * @param sDtTpCd
	 */
	public void setSDtTpCd(String sDtTpCd) {
		this.sDtTpCd = sDtTpCd;
	}
	
	/**
	 * Column Info
	 * @param sFcbfStDt
	 */
	public void setSFcbfStDt(String sFcbfStDt) {
		this.sFcbfStDt = sFcbfStDt;
	}
	
	/**
	 * Column Info
	 * @param plnRsnSubCodeNText
	 */
	public void setPlnRsnSubCodeNText(String plnRsnSubCodeNText) {
		this.plnRsnSubCodeNText = plnRsnSubCodeNText;
	}
	
	/**
	 * Column Info
	 * @param sEffEndDt
	 */
	public void setSEffEndDt(String sEffEndDt) {
		this.sEffEndDt = sEffEndDt;
	}
	
	/**
	 * Column Info
	 * @param etaFmDt
	 */
	public void setEtaFmDt(String etaFmDt) {
		this.etaFmDt = etaFmDt;
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
		setSubtrade(JSPUtil.getParameter(request, prefix + "subtrade", ""));
		setTrade(JSPUtil.getParameter(request, prefix + "trade", ""));
		setPlnRsnHdrCode(JSPUtil.getParameter(request, prefix + "pln_rsn_hdr_code", ""));
		setOfcTpCd(JSPUtil.getParameter(request, prefix + "ofc_tp_cd", ""));
		setSSubLocCd(JSPUtil.getParameter(request, prefix + "s_sub_loc_cd", ""));
		setLclDt(JSPUtil.getParameter(request, prefix + "lcl_dt", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setLocTpCdSecond(JSPUtil.getParameter(request, prefix + "loc_tp_cd_second", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFmWk(JSPUtil.getParameter(request, prefix + "fm_wk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSEffStDt(JSPUtil.getParameter(request, prefix + "s_eff_st_dt", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setSVvdCd(JSPUtil.getParameter(request, prefix + "s_vvd_cd", ""));
		setPlnRsnHdrText(JSPUtil.getParameter(request, prefix + "pln_rsn_hdr_text", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setSPolCd(JSPUtil.getParameter(request, prefix + "s_pol_cd", ""));
		setVvdRslt(JSPUtil.getParameter(request, prefix + "vvd_rslt", ""));
		setLoginOfcConticCd(JSPUtil.getParameter(request, prefix + "login_ofc_contic_cd", ""));
		setTpsztype(JSPUtil.getParameter(request, prefix + "tpsztype", ""));
		setLocCdSecond(JSPUtil.getParameter(request, prefix + "loc_cd_second", ""));
		setToWk(JSPUtil.getParameter(request, prefix + "to_wk", ""));
		setSCfmFlg(JSPUtil.getParameter(request, prefix + "s_cfm_flg", ""));
		setRlane(JSPUtil.getParameter(request, prefix + "rlane", ""));
		setEqGlineSeq(JSPUtil.getParameter(request, prefix + "eq_gline_seq", ""));
		setSEtaDt(JSPUtil.getParameter(request, prefix + "s_eta_dt", ""));
		setSFcbfEndDt(JSPUtil.getParameter(request, prefix + "s_fcbf_end_dt", ""));
		setSLocCd(JSPUtil.getParameter(request, prefix + "s_loc_cd", ""));
		setPlnRsnHdrCodeNText(JSPUtil.getParameter(request, prefix + "pln_rsn_hdr_code_n_text", ""));
		setVvdRetrieveVal(JSPUtil.getParameter(request, prefix + "vvd_retrieve_val", ""));
		setPlnRsnHdrCd(JSPUtil.getParameter(request, prefix + "pln_rsn_hdr_cd", ""));
		setMainPage(JSPUtil.getParameter(request, prefix + "main_page", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setPlnRsnSubCode(JSPUtil.getParameter(request, prefix + "pln_rsn_sub_code", ""));
		setPlnRsnSubText(JSPUtil.getParameter(request, prefix + "pln_rsn_sub_text", ""));
		setEtaToDt(JSPUtil.getParameter(request, prefix + "eta_to_dt", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setTpsz(JSPUtil.getParameter(request, prefix + "tpsz", ""));
		setSDtTpCd(JSPUtil.getParameter(request, prefix + "s_dt_tp_cd", ""));
		setSFcbfStDt(JSPUtil.getParameter(request, prefix + "s_fcbf_st_dt", ""));
		setPlnRsnSubCodeNText(JSPUtil.getParameter(request, prefix + "pln_rsn_sub_code_n_text", ""));
		setSEffEndDt(JSPUtil.getParameter(request, prefix + "s_eff_end_dt", ""));
		setEtaFmDt(JSPUtil.getParameter(request, prefix + "eta_fm_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr1013ConditionVO[]
	 */
	public EesEqr1013ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr1013ConditionVO[]
	 */
	public EesEqr1013ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr1013ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] subtrade = (JSPUtil.getParameter(request, prefix	+ "subtrade", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] plnRsnHdrCode = (JSPUtil.getParameter(request, prefix	+ "pln_rsn_hdr_code", length));
			String[] ofcTpCd = (JSPUtil.getParameter(request, prefix	+ "ofc_tp_cd", length));
			String[] sSubLocCd = (JSPUtil.getParameter(request, prefix	+ "s_sub_loc_cd", length));
			String[] lclDt = (JSPUtil.getParameter(request, prefix	+ "lcl_dt", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] locTpCdSecond = (JSPUtil.getParameter(request, prefix	+ "loc_tp_cd_second", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fmWk = (JSPUtil.getParameter(request, prefix	+ "fm_wk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sEffStDt = (JSPUtil.getParameter(request, prefix	+ "s_eff_st_dt", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] sVvdCd = (JSPUtil.getParameter(request, prefix	+ "s_vvd_cd", length));
			String[] plnRsnHdrText = (JSPUtil.getParameter(request, prefix	+ "pln_rsn_hdr_text", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] sPolCd = (JSPUtil.getParameter(request, prefix	+ "s_pol_cd", length));
			String[] vvdRslt = (JSPUtil.getParameter(request, prefix	+ "vvd_rslt", length));
			String[] loginOfcConticCd = (JSPUtil.getParameter(request, prefix	+ "login_ofc_contic_cd", length));
			String[] tpsztype = (JSPUtil.getParameter(request, prefix	+ "tpsztype", length));
			String[] locCdSecond = (JSPUtil.getParameter(request, prefix	+ "loc_cd_second", length));
			String[] toWk = (JSPUtil.getParameter(request, prefix	+ "to_wk", length));
			String[] sCfmFlg = (JSPUtil.getParameter(request, prefix	+ "s_cfm_flg", length));
			String[] rlane = (JSPUtil.getParameter(request, prefix	+ "rlane", length));
			String[] eqGlineSeq = (JSPUtil.getParameter(request, prefix	+ "eq_gline_seq", length));
			String[] sEtaDt = (JSPUtil.getParameter(request, prefix	+ "s_eta_dt", length));
			String[] sFcbfEndDt = (JSPUtil.getParameter(request, prefix	+ "s_fcbf_end_dt", length));
			String[] sLocCd = (JSPUtil.getParameter(request, prefix	+ "s_loc_cd", length));
			String[] plnRsnHdrCodeNText = (JSPUtil.getParameter(request, prefix	+ "pln_rsn_hdr_code_n_text", length));
			String[] vvdRetrieveVal = (JSPUtil.getParameter(request, prefix	+ "vvd_retrieve_val", length));
			String[] plnRsnHdrCd = (JSPUtil.getParameter(request, prefix	+ "pln_rsn_hdr_cd", length));
			String[] mainPage = (JSPUtil.getParameter(request, prefix	+ "main_page", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] plnRsnSubCode = (JSPUtil.getParameter(request, prefix	+ "pln_rsn_sub_code", length));
			String[] plnRsnSubText = (JSPUtil.getParameter(request, prefix	+ "pln_rsn_sub_text", length));
			String[] etaToDt = (JSPUtil.getParameter(request, prefix	+ "eta_to_dt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz", length));
			String[] sDtTpCd = (JSPUtil.getParameter(request, prefix	+ "s_dt_tp_cd", length));
			String[] sFcbfStDt = (JSPUtil.getParameter(request, prefix	+ "s_fcbf_st_dt", length));
			String[] plnRsnSubCodeNText = (JSPUtil.getParameter(request, prefix	+ "pln_rsn_sub_code_n_text", length));
			String[] sEffEndDt = (JSPUtil.getParameter(request, prefix	+ "s_eff_end_dt", length));
			String[] etaFmDt = (JSPUtil.getParameter(request, prefix	+ "eta_fm_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr1013ConditionVO();
				if (subtrade[i] != null)
					model.setSubtrade(subtrade[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (plnRsnHdrCode[i] != null)
					model.setPlnRsnHdrCode(plnRsnHdrCode[i]);
				if (ofcTpCd[i] != null)
					model.setOfcTpCd(ofcTpCd[i]);
				if (sSubLocCd[i] != null)
					model.setSSubLocCd(sSubLocCd[i]);
				if (lclDt[i] != null)
					model.setLclDt(lclDt[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (locTpCdSecond[i] != null)
					model.setLocTpCdSecond(locTpCdSecond[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fmWk[i] != null)
					model.setFmWk(fmWk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sEffStDt[i] != null)
					model.setSEffStDt(sEffStDt[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (sVvdCd[i] != null)
					model.setSVvdCd(sVvdCd[i]);
				if (plnRsnHdrText[i] != null)
					model.setPlnRsnHdrText(plnRsnHdrText[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (sPolCd[i] != null)
					model.setSPolCd(sPolCd[i]);
				if (vvdRslt[i] != null)
					model.setVvdRslt(vvdRslt[i]);
				if (loginOfcConticCd[i] != null)
					model.setLoginOfcConticCd(loginOfcConticCd[i]);
				if (tpsztype[i] != null)
					model.setTpsztype(tpsztype[i]);
				if (locCdSecond[i] != null)
					model.setLocCdSecond(locCdSecond[i]);
				if (toWk[i] != null)
					model.setToWk(toWk[i]);
				if (sCfmFlg[i] != null)
					model.setSCfmFlg(sCfmFlg[i]);
				if (rlane[i] != null)
					model.setRlane(rlane[i]);
				if (eqGlineSeq[i] != null)
					model.setEqGlineSeq(eqGlineSeq[i]);
				if (sEtaDt[i] != null)
					model.setSEtaDt(sEtaDt[i]);
				if (sFcbfEndDt[i] != null)
					model.setSFcbfEndDt(sFcbfEndDt[i]);
				if (sLocCd[i] != null)
					model.setSLocCd(sLocCd[i]);
				if (plnRsnHdrCodeNText[i] != null)
					model.setPlnRsnHdrCodeNText(plnRsnHdrCodeNText[i]);
				if (vvdRetrieveVal[i] != null)
					model.setVvdRetrieveVal(vvdRetrieveVal[i]);
				if (plnRsnHdrCd[i] != null)
					model.setPlnRsnHdrCd(plnRsnHdrCd[i]);
				if (mainPage[i] != null)
					model.setMainPage(mainPage[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (plnRsnSubCode[i] != null)
					model.setPlnRsnSubCode(plnRsnSubCode[i]);
				if (plnRsnSubText[i] != null)
					model.setPlnRsnSubText(plnRsnSubText[i]);
				if (etaToDt[i] != null)
					model.setEtaToDt(etaToDt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (sDtTpCd[i] != null)
					model.setSDtTpCd(sDtTpCd[i]);
				if (sFcbfStDt[i] != null)
					model.setSFcbfStDt(sFcbfStDt[i]);
				if (plnRsnSubCodeNText[i] != null)
					model.setPlnRsnSubCodeNText(plnRsnSubCodeNText[i]);
				if (sEffEndDt[i] != null)
					model.setSEffEndDt(sEffEndDt[i]);
				if (etaFmDt[i] != null)
					model.setEtaFmDt(etaFmDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr1013ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr1013ConditionVO[]
	 */
	public EesEqr1013ConditionVO[] getEesEqr1013ConditionVOs(){
		EesEqr1013ConditionVO[] vos = (EesEqr1013ConditionVO[])models.toArray(new EesEqr1013ConditionVO[models.size()]);
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
		this.subtrade = this.subtrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnRsnHdrCode = this.plnRsnHdrCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTpCd = this.ofcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSubLocCd = this.sSubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclDt = this.lclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTpCdSecond = this.locTpCdSecond .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmWk = this.fmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEffStDt = this.sEffStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVvdCd = this.sVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnRsnHdrText = this.plnRsnHdrText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPolCd = this.sPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdRslt = this.vvdRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginOfcConticCd = this.loginOfcConticCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsztype = this.tpsztype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCdSecond = this.locCdSecond .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toWk = this.toWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCfmFlg = this.sCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlane = this.rlane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqGlineSeq = this.eqGlineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEtaDt = this.sEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFcbfEndDt = this.sFcbfEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLocCd = this.sLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnRsnHdrCodeNText = this.plnRsnHdrCodeNText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdRetrieveVal = this.vvdRetrieveVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnRsnHdrCd = this.plnRsnHdrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mainPage = this.mainPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnRsnSubCode = this.plnRsnSubCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnRsnSubText = this.plnRsnSubText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaToDt = this.etaToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDtTpCd = this.sDtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFcbfStDt = this.sFcbfStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnRsnSubCodeNText = this.plnRsnSubCodeNText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEffEndDt = this.sEffEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaFmDt = this.etaFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
