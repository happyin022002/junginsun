/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BasicTariffVO.java
*@FileTitle : BasicTariffVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.08  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo;

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

public class BasicTariffVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BasicTariffVO> models = new ArrayList<BasicTariffVO>();
	
	/* Column Info */
	private String grpCfmFlg = null;
	/* Column Info */
	private String xcldSunFlg = null;
	/* Column Info */
	private String xcldSatFlg = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String dmdtChgCmncTpCd = null;
	/* Column Info */
	private String crntCfmFlg = null;
	/* Column Info */
	private String dmdtTrfGrpTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String dmdtBzcTrfGrpNm = null;
	/* Column Info */
	private String buttonMode = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rgnCfmFlg = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String dmdtBzcTrfGrpNm2 = null;
	/* Column Info */
	private String dmdtCgoTpCd = null;
	/* Column Info */
	private String effDay = null;
	/* Column Info */
	private String userOffice = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String dmdtCntrTpNm = null;
	/* Column Info */
	private String cmncHr = null;
	/* Column Info */
	private String dmdtCntrTpCd = null;
	/* Column Info */
	private String dmdtCgoTpNm = null;
	/* Column Info */
	private String rgnCfmSeq = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String wknd2 = null;
	/* Column Info */
	private String dmdtChgCmncTpNm = null;
	/* Column Info */
	private String xcldHolFlg = null;
	/* Column Info */
	private String wknd1 = null;
	/* Column Info */
	private String trfGrpSeq = null;
	/* Column Info */
	private String trfSeq = null;
	/* Column Info */
	private String dmdtDeTermCd = null;
	/* Column Info */
	private String dmdtDeTermNm = null;
	/* Column Info */
	private String currFlg = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BasicTariffVO() {}

	public BasicTariffVO(String ibflag, String pagerows, String xcldSatFlg, String xcldSunFlg, String grpCfmFlg, String crntCfmFlg, String dmdtChgCmncTpCd, String currCd, String dmdtTrfGrpTpCd, String buttonMode, String dmdtBzcTrfGrpNm, String svrId, String effDt, String rgnCfmFlg, String usrId, String expDt, String dmdtBzcTrfGrpNm2, String dmdtCgoTpCd, String effDay, String userOffice, String dmdtTrfCd, String dmdtCntrTpNm, String cmncHr, String dmdtCntrTpCd, String rgnCfmSeq, String dmdtCgoTpNm, String ofcCd, String wknd2, String wknd1, String xcldHolFlg, String dmdtChgCmncTpNm, String trfGrpSeq, String trfSeq, String dmdtDeTermCd
						, String dmdtDeTermNm, String currFlg) {
		this.grpCfmFlg = grpCfmFlg;
		this.xcldSunFlg = xcldSunFlg;
		this.xcldSatFlg = xcldSatFlg;
		this.currCd = currCd;
		this.dmdtChgCmncTpCd = dmdtChgCmncTpCd;
		this.crntCfmFlg = crntCfmFlg;
		this.dmdtTrfGrpTpCd = dmdtTrfGrpTpCd;
		this.pagerows = pagerows;
		this.svrId = svrId;
		this.dmdtBzcTrfGrpNm = dmdtBzcTrfGrpNm;
		this.buttonMode = buttonMode;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.rgnCfmFlg = rgnCfmFlg;
		this.usrId = usrId;
		this.expDt = expDt;
		this.dmdtBzcTrfGrpNm2 = dmdtBzcTrfGrpNm2;
		this.dmdtCgoTpCd = dmdtCgoTpCd;
		this.effDay = effDay;
		this.userOffice = userOffice;
		this.dmdtTrfCd = dmdtTrfCd;
		this.dmdtCntrTpNm = dmdtCntrTpNm;
		this.cmncHr = cmncHr;
		this.dmdtCntrTpCd = dmdtCntrTpCd;
		this.dmdtCgoTpNm = dmdtCgoTpNm;
		this.rgnCfmSeq = rgnCfmSeq;
		this.ofcCd = ofcCd;
		this.wknd2 = wknd2;
		this.dmdtChgCmncTpNm = dmdtChgCmncTpNm;
		this.xcldHolFlg = xcldHolFlg;
		this.wknd1 = wknd1;
		this.trfGrpSeq = trfGrpSeq;
		this.trfSeq = trfSeq;
		this.dmdtDeTermCd = dmdtDeTermCd;
		this.dmdtDeTermNm = dmdtDeTermNm;
		this.currFlg = currFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("grp_cfm_flg", getGrpCfmFlg());
		this.hashColumns.put("xcld_sun_flg", getXcldSunFlg());
		this.hashColumns.put("xcld_sat_flg", getXcldSatFlg());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("dmdt_chg_cmnc_tp_cd", getDmdtChgCmncTpCd());
		this.hashColumns.put("crnt_cfm_flg", getCrntCfmFlg());
		this.hashColumns.put("dmdt_trf_grp_tp_cd", getDmdtTrfGrpTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("dmdt_bzc_trf_grp_nm", getDmdtBzcTrfGrpNm());
		this.hashColumns.put("button_mode", getButtonMode());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rgn_cfm_flg", getRgnCfmFlg());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("dmdt_bzc_trf_grp_nm2", getDmdtBzcTrfGrpNm2());
		this.hashColumns.put("dmdt_cgo_tp_cd", getDmdtCgoTpCd());
		this.hashColumns.put("eff_day", getEffDay());
		this.hashColumns.put("user_office", getUserOffice());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("dmdt_cntr_tp_nm", getDmdtCntrTpNm());
		this.hashColumns.put("cmnc_hr", getCmncHr());
		this.hashColumns.put("dmdt_cntr_tp_cd", getDmdtCntrTpCd());
		this.hashColumns.put("dmdt_cgo_tp_nm", getDmdtCgoTpNm());
		this.hashColumns.put("rgn_cfm_seq", getRgnCfmSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("wknd2", getWknd2());
		this.hashColumns.put("dmdt_chg_cmnc_tp_nm", getDmdtChgCmncTpNm());
		this.hashColumns.put("xcld_hol_flg", getXcldHolFlg());
		this.hashColumns.put("wknd1", getWknd1());
		this.hashColumns.put("trf_grp_seq", getTrfGrpSeq());
		this.hashColumns.put("trf_seq", getTrfSeq());
		this.hashColumns.put("dmdt_de_term_cd", getDmdtDeTermCd());
		this.hashColumns.put("dmdt_de_term_nm", getDmdtDeTermNm());
		this.hashColumns.put("curr_flg", getCurrFlg());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("grp_cfm_flg", "grpCfmFlg");
		this.hashFields.put("xcld_sun_flg", "xcldSunFlg");
		this.hashFields.put("xcld_sat_flg", "xcldSatFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("dmdt_chg_cmnc_tp_cd", "dmdtChgCmncTpCd");
		this.hashFields.put("crnt_cfm_flg", "crntCfmFlg");
		this.hashFields.put("dmdt_trf_grp_tp_cd", "dmdtTrfGrpTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("dmdt_bzc_trf_grp_nm", "dmdtBzcTrfGrpNm");
		this.hashFields.put("button_mode", "buttonMode");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rgn_cfm_flg", "rgnCfmFlg");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("dmdt_bzc_trf_grp_nm2", "dmdtBzcTrfGrpNm2");
		this.hashFields.put("dmdt_cgo_tp_cd", "dmdtCgoTpCd");
		this.hashFields.put("eff_day", "effDay");
		this.hashFields.put("user_office", "userOffice");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("dmdt_cntr_tp_nm", "dmdtCntrTpNm");
		this.hashFields.put("cmnc_hr", "cmncHr");
		this.hashFields.put("dmdt_cntr_tp_cd", "dmdtCntrTpCd");
		this.hashFields.put("dmdt_cgo_tp_nm", "dmdtCgoTpNm");
		this.hashFields.put("rgn_cfm_seq", "rgnCfmSeq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("wknd2", "wknd2");
		this.hashFields.put("dmdt_chg_cmnc_tp_nm", "dmdtChgCmncTpNm");
		this.hashFields.put("xcld_hol_flg", "xcldHolFlg");
		this.hashFields.put("wknd1", "wknd1");
		this.hashFields.put("trf_grp_seq", "trfGrpSeq");
		this.hashFields.put("trf_seq", "trfSeq");
		this.hashFields.put("dmdt_de_term_cd", "dmdtDeTermCd");
		this.hashFields.put("dmdt_de_term_nm", "dmdtDeTermNm");
		this.hashFields.put("curr_flg", "currFlg");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return grpCfmFlg
	 */
	public String getGrpCfmFlg() {
		return this.grpCfmFlg;
	}
	
	/**
	 * Column Info
	 * @return xcldSunFlg
	 */
	public String getXcldSunFlg() {
		return this.xcldSunFlg;
	}
	
	/**
	 * Column Info
	 * @return xcldSatFlg
	 */
	public String getXcldSatFlg() {
		return this.xcldSatFlg;
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
	 * @return dmdtChgCmncTpCd
	 */
	public String getDmdtChgCmncTpCd() {
		return this.dmdtChgCmncTpCd;
	}
	
	/**
	 * Column Info
	 * @return crntCfmFlg
	 */
	public String getCrntCfmFlg() {
		return this.crntCfmFlg;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfGrpTpCd
	 */
	public String getDmdtTrfGrpTpCd() {
		return this.dmdtTrfGrpTpCd;
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
	 * @return dmdtBzcTrfGrpNm
	 */
	public String getDmdtBzcTrfGrpNm() {
		return this.dmdtBzcTrfGrpNm;
	}
	
	/**
	 * Column Info
	 * @return buttonMode
	 */
	public String getButtonMode() {
		return this.buttonMode;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return rgnCfmFlg
	 */
	public String getRgnCfmFlg() {
		return this.rgnCfmFlg;
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
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return dmdtBzcTrfGrpNm2
	 */
	public String getDmdtBzcTrfGrpNm2() {
		return this.dmdtBzcTrfGrpNm2;
	}
	
	/**
	 * Column Info
	 * @return dmdtCgoTpCd
	 */
	public String getDmdtCgoTpCd() {
		return this.dmdtCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return effDay
	 */
	public String getEffDay() {
		return this.effDay;
	}
	
	/**
	 * Column Info
	 * @return userOffice
	 */
	public String getUserOffice() {
		return this.userOffice;
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
	 * @return dmdtCntrTpNm
	 */
	public String getDmdtCntrTpNm() {
		return this.dmdtCntrTpNm;
	}
	
	/**
	 * Column Info
	 * @return cmncHr
	 */
	public String getCmncHr() {
		return this.cmncHr;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrTpCd
	 */
	public String getDmdtCntrTpCd() {
		return this.dmdtCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtCgoTpNm
	 */
	public String getDmdtCgoTpNm() {
		return this.dmdtCgoTpNm;
	}
	
	/**
	 * Column Info
	 * @return rgnCfmSeq
	 */
	public String getRgnCfmSeq() {
		return this.rgnCfmSeq;
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
	 * @return wknd2
	 */
	public String getWknd2() {
		return this.wknd2;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgCmncTpNm
	 */
	public String getDmdtChgCmncTpNm() {
		return this.dmdtChgCmncTpNm;
	}
	
	/**
	 * Column Info
	 * @return xcldHolFlg
	 */
	public String getXcldHolFlg() {
		return this.xcldHolFlg;
	}
	
	/**
	 * Column Info
	 * @return wknd1
	 */
	public String getWknd1() {
		return this.wknd1;
	}
	
	/**
	 * Column Info
	 * @return trfGrpSeq
	 */
	public String getTrfGrpSeq() {
		return this.trfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return trfSeq
	 */
	public String getTrfSeq() {
		return this.trfSeq;
	}
	
	/**
	 * Column Info
	 * @return dmdtDeTermCd
	 */
	public String getDmdtDeTermCd() {
		return this.dmdtDeTermCd;
	}

	/**
	 * Column Info
	 * @return dmdtDeTermNm
	 */
	public String getDmdtDeTermNm() {
		return this.dmdtDeTermNm;
	}
	
	/**
	 * Column Info
	 * @return currFlg
	 */
	public String getCurrFlg() {
		return this.currFlg;
	}
	
	/**
	 * Column Info
	 * @param grpCfmFlg
	 */
	public void setGrpCfmFlg(String grpCfmFlg) {
		this.grpCfmFlg = grpCfmFlg;
	}
	
	/**
	 * Column Info
	 * @param xcldSunFlg
	 */
	public void setXcldSunFlg(String xcldSunFlg) {
		this.xcldSunFlg = xcldSunFlg;
	}
	
	/**
	 * Column Info
	 * @param xcldSatFlg
	 */
	public void setXcldSatFlg(String xcldSatFlg) {
		this.xcldSatFlg = xcldSatFlg;
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
	 * @param dmdtChgCmncTpCd
	 */
	public void setDmdtChgCmncTpCd(String dmdtChgCmncTpCd) {
		this.dmdtChgCmncTpCd = dmdtChgCmncTpCd;
	}
	
	/**
	 * Column Info
	 * @param crntCfmFlg
	 */
	public void setCrntCfmFlg(String crntCfmFlg) {
		this.crntCfmFlg = crntCfmFlg;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfGrpTpCd
	 */
	public void setDmdtTrfGrpTpCd(String dmdtTrfGrpTpCd) {
		this.dmdtTrfGrpTpCd = dmdtTrfGrpTpCd;
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
	 * @param dmdtBzcTrfGrpNm
	 */
	public void setDmdtBzcTrfGrpNm(String dmdtBzcTrfGrpNm) {
		this.dmdtBzcTrfGrpNm = dmdtBzcTrfGrpNm;
	}
	
	/**
	 * Column Info
	 * @param buttonMode
	 */
	public void setButtonMode(String buttonMode) {
		this.buttonMode = buttonMode;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param rgnCfmFlg
	 */
	public void setRgnCfmFlg(String rgnCfmFlg) {
		this.rgnCfmFlg = rgnCfmFlg;
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
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param dmdtBzcTrfGrpNm2
	 */
	public void setDmdtBzcTrfGrpNm2(String dmdtBzcTrfGrpNm2) {
		this.dmdtBzcTrfGrpNm2 = dmdtBzcTrfGrpNm2;
	}
	
	/**
	 * Column Info
	 * @param dmdtCgoTpCd
	 */
	public void setDmdtCgoTpCd(String dmdtCgoTpCd) {
		this.dmdtCgoTpCd = dmdtCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param effDay
	 */
	public void setEffDay(String effDay) {
		this.effDay = effDay;
	}
	
	/**
	 * Column Info
	 * @param userOffice
	 */
	public void setUserOffice(String userOffice) {
		this.userOffice = userOffice;
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
	 * @param dmdtCntrTpNm
	 */
	public void setDmdtCntrTpNm(String dmdtCntrTpNm) {
		this.dmdtCntrTpNm = dmdtCntrTpNm;
	}
	
	/**
	 * Column Info
	 * @param cmncHr
	 */
	public void setCmncHr(String cmncHr) {
		this.cmncHr = cmncHr;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrTpCd
	 */
	public void setDmdtCntrTpCd(String dmdtCntrTpCd) {
		this.dmdtCntrTpCd = dmdtCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtCgoTpNm
	 */
	public void setDmdtCgoTpNm(String dmdtCgoTpNm) {
		this.dmdtCgoTpNm = dmdtCgoTpNm;
	}
	
	/**
	 * Column Info
	 * @param rgnCfmSeq
	 */
	public void setRgnCfmSeq(String rgnCfmSeq) {
		this.rgnCfmSeq = rgnCfmSeq;
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
	 * @param wknd2
	 */
	public void setWknd2(String wknd2) {
		this.wknd2 = wknd2;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgCmncTpNm
	 */
	public void setDmdtChgCmncTpNm(String dmdtChgCmncTpNm) {
		this.dmdtChgCmncTpNm = dmdtChgCmncTpNm;
	}
	
	/**
	 * Column Info
	 * @param xcldHolFlg
	 */
	public void setXcldHolFlg(String xcldHolFlg) {
		this.xcldHolFlg = xcldHolFlg;
	}
	
	/**
	 * Column Info
	 * @param wknd1
	 */
	public void setWknd1(String wknd1) {
		this.wknd1 = wknd1;
	}
	
	/**
	 * Column Info
	 * @param trfGrpSeq
	 */
	public void setTrfGrpSeq(String trfGrpSeq) {
		this.trfGrpSeq = trfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param trfSeq
	 */
	public void setTrfSeq(String trfSeq) {
		this.trfSeq = trfSeq;
	}
	
	/**
	 * Column Info
	 * @param dmdtDeTermCd
	 */
	public void setDmdtDeTermCd(String dmdtDeTermCd) {
		this.dmdtDeTermCd = dmdtDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtDeTermNm
	 */
	public void setDmdtDeTermNm(String dmdtDeTermNm) {
		this.dmdtDeTermNm = dmdtDeTermNm;
	}
	
	/**
	 * Column Info
	 * @param currFlg
	 */
	public void setCurrFlg(String currFlg) {
		this.currFlg = currFlg;
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
		setGrpCfmFlg(JSPUtil.getParameter(request, prefix + "grp_cfm_flg", ""));
		setXcldSunFlg(JSPUtil.getParameter(request, prefix + "xcld_sun_flg", ""));
		setXcldSatFlg(JSPUtil.getParameter(request, prefix + "xcld_sat_flg", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setDmdtChgCmncTpCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_cmnc_tp_cd", ""));
		setCrntCfmFlg(JSPUtil.getParameter(request, prefix + "crnt_cfm_flg", ""));
		setDmdtTrfGrpTpCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_grp_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSvrId(JSPUtil.getParameter(request, prefix + "svr_id", ""));
		setDmdtBzcTrfGrpNm(JSPUtil.getParameter(request, prefix + "dmdt_bzc_trf_grp_nm", ""));
		setButtonMode(JSPUtil.getParameter(request, prefix + "button_mode", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRgnCfmFlg(JSPUtil.getParameter(request, prefix + "rgn_cfm_flg", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setDmdtBzcTrfGrpNm2(JSPUtil.getParameter(request, prefix + "dmdt_bzc_trf_grp_nm2", ""));
		setDmdtCgoTpCd(JSPUtil.getParameter(request, prefix + "dmdt_cgo_tp_cd", ""));
		setEffDay(JSPUtil.getParameter(request, prefix + "eff_day", ""));
		setUserOffice(JSPUtil.getParameter(request, prefix + "user_office", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setDmdtCntrTpNm(JSPUtil.getParameter(request, prefix + "dmdt_cntr_tp_nm", ""));
		setCmncHr(JSPUtil.getParameter(request, prefix + "cmnc_hr", ""));
		setDmdtCntrTpCd(JSPUtil.getParameter(request, prefix + "dmdt_cntr_tp_cd", ""));
		setDmdtCgoTpNm(JSPUtil.getParameter(request, prefix + "dmdt_cgo_tp_nm", ""));
		setRgnCfmSeq(JSPUtil.getParameter(request, prefix + "rgn_cfm_seq", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setWknd2(JSPUtil.getParameter(request, prefix + "wknd2", ""));
		setDmdtChgCmncTpNm(JSPUtil.getParameter(request, prefix + "dmdt_chg_cmnc_tp_nm", ""));
		setXcldHolFlg(JSPUtil.getParameter(request, prefix + "xcld_hol_flg", ""));
		setWknd1(JSPUtil.getParameter(request, prefix + "wknd1", ""));
		setTrfGrpSeq(JSPUtil.getParameter(request, prefix + "trf_grp_seq", ""));
		setTrfSeq(JSPUtil.getParameter(request, prefix + "trf_seq", ""));
		setDmdtDeTermCd(JSPUtil.getParameter(request, prefix + "dmdt_de_term_cd", ""));
		setDmdtDeTermNm(JSPUtil.getParameter(request, prefix + "dmdt_de_term_nm", ""));
		setCurrFlg(JSPUtil.getParameter(request, prefix + "curr_flg", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BasicTariffVO[]
	 */
	public BasicTariffVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BasicTariffVO[]
	 */
	public BasicTariffVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BasicTariffVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] grpCfmFlg = (JSPUtil.getParameter(request, prefix	+ "grp_cfm_flg", length));
			String[] xcldSunFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sun_flg", length));
			String[] xcldSatFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sat_flg", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] dmdtChgCmncTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_cmnc_tp_cd", length));
			String[] crntCfmFlg = (JSPUtil.getParameter(request, prefix	+ "crnt_cfm_flg", length));
			String[] dmdtTrfGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_grp_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] dmdtBzcTrfGrpNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_bzc_trf_grp_nm", length));
			String[] buttonMode = (JSPUtil.getParameter(request, prefix	+ "button_mode", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rgnCfmFlg = (JSPUtil.getParameter(request, prefix	+ "rgn_cfm_flg", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] dmdtBzcTrfGrpNm2 = (JSPUtil.getParameter(request, prefix	+ "dmdt_bzc_trf_grp_nm2", length));
			String[] dmdtCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cgo_tp_cd", length));
			String[] effDay = (JSPUtil.getParameter(request, prefix	+ "eff_day", length));
			String[] userOffice = (JSPUtil.getParameter(request, prefix	+ "user_office", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] dmdtCntrTpNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_tp_nm", length));
			String[] cmncHr = (JSPUtil.getParameter(request, prefix	+ "cmnc_hr", length));
			String[] dmdtCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_tp_cd", length));
			String[] dmdtCgoTpNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_cgo_tp_nm", length));
			String[] rgnCfmSeq = (JSPUtil.getParameter(request, prefix	+ "rgn_cfm_seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] wknd2 = (JSPUtil.getParameter(request, prefix	+ "wknd2", length));
			String[] dmdtChgCmncTpNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_cmnc_tp_nm", length));
			String[] xcldHolFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_hol_flg", length));
			String[] wknd1 = (JSPUtil.getParameter(request, prefix	+ "wknd1", length));
			String[] trfGrpSeq = (JSPUtil.getParameter(request, prefix	+ "trf_grp_seq", length));
			String[] trfSeq = (JSPUtil.getParameter(request, prefix	+ "trf_seq", length));
			String[] dmdtDeTermCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_de_term_cd", length));
			String[] dmdtDeTermNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_de_term_nm", length));
			String[] currFlg = (JSPUtil.getParameter(request, prefix	+ "curr_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new BasicTariffVO();
				if (grpCfmFlg[i] != null)
					model.setGrpCfmFlg(grpCfmFlg[i]);
				if (xcldSunFlg[i] != null)
					model.setXcldSunFlg(xcldSunFlg[i]);
				if (xcldSatFlg[i] != null)
					model.setXcldSatFlg(xcldSatFlg[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (dmdtChgCmncTpCd[i] != null)
					model.setDmdtChgCmncTpCd(dmdtChgCmncTpCd[i]);
				if (crntCfmFlg[i] != null)
					model.setCrntCfmFlg(crntCfmFlg[i]);
				if (dmdtTrfGrpTpCd[i] != null)
					model.setDmdtTrfGrpTpCd(dmdtTrfGrpTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (dmdtBzcTrfGrpNm[i] != null)
					model.setDmdtBzcTrfGrpNm(dmdtBzcTrfGrpNm[i]);
				if (buttonMode[i] != null)
					model.setButtonMode(buttonMode[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rgnCfmFlg[i] != null)
					model.setRgnCfmFlg(rgnCfmFlg[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (dmdtBzcTrfGrpNm2[i] != null)
					model.setDmdtBzcTrfGrpNm2(dmdtBzcTrfGrpNm2[i]);
				if (dmdtCgoTpCd[i] != null)
					model.setDmdtCgoTpCd(dmdtCgoTpCd[i]);
				if (effDay[i] != null)
					model.setEffDay(effDay[i]);
				if (userOffice[i] != null)
					model.setUserOffice(userOffice[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (dmdtCntrTpNm[i] != null)
					model.setDmdtCntrTpNm(dmdtCntrTpNm[i]);
				if (cmncHr[i] != null)
					model.setCmncHr(cmncHr[i]);
				if (dmdtCntrTpCd[i] != null)
					model.setDmdtCntrTpCd(dmdtCntrTpCd[i]);
				if (dmdtCgoTpNm[i] != null)
					model.setDmdtCgoTpNm(dmdtCgoTpNm[i]);
				if (rgnCfmSeq[i] != null)
					model.setRgnCfmSeq(rgnCfmSeq[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (wknd2[i] != null)
					model.setWknd2(wknd2[i]);
				if (dmdtChgCmncTpNm[i] != null)
					model.setDmdtChgCmncTpNm(dmdtChgCmncTpNm[i]);
				if (xcldHolFlg[i] != null)
					model.setXcldHolFlg(xcldHolFlg[i]);
				if (wknd1[i] != null)
					model.setWknd1(wknd1[i]);
				if (trfGrpSeq[i] != null)
					model.setTrfGrpSeq(trfGrpSeq[i]);
				if (trfSeq[i] != null)
					model.setTrfSeq(trfSeq[i]);
				if (dmdtDeTermCd[i] != null)
					model.setDmdtDeTermCd(dmdtDeTermCd[i]);
				if (dmdtDeTermNm[i] != null)
					model.setDmdtDeTermNm(dmdtDeTermNm[i]);
				if (currFlg[i] != null)
					model.setCurrFlg(currFlg[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBasicTariffVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BasicTariffVO[]
	 */
	public BasicTariffVO[] getBasicTariffVOs(){
		BasicTariffVO[] vos = (BasicTariffVO[])models.toArray(new BasicTariffVO[models.size()]);
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
		this.grpCfmFlg = this.grpCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldSunFlg = this.xcldSunFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldSatFlg = this.xcldSatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgCmncTpCd = this.dmdtChgCmncTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCfmFlg = this.crntCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfGrpTpCd = this.dmdtTrfGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtBzcTrfGrpNm = this.dmdtBzcTrfGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buttonMode = this.buttonMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnCfmFlg = this.rgnCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtBzcTrfGrpNm2 = this.dmdtBzcTrfGrpNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCgoTpCd = this.dmdtCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDay = this.effDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOffice = this.userOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrTpNm = this.dmdtCntrTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmncHr = this.cmncHr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrTpCd = this.dmdtCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCgoTpNm = this.dmdtCgoTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnCfmSeq = this.rgnCfmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wknd2 = this.wknd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgCmncTpNm = this.dmdtChgCmncTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldHolFlg = this.xcldHolFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wknd1 = this.wknd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfGrpSeq = this.trfGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfSeq = this.trfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtDeTermCd = this.dmdtDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtDeTermNm = this.dmdtDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currFlg = this.currFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
