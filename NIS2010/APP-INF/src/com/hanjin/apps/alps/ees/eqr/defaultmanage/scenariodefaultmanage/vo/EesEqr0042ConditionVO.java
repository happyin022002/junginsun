/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0042ConditionVO.java
*@FileTitle : Holiday Effect 조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009-07-15
*@LastModifier : chung eun ho
*@LastVersion : 1.0
* 2009-07-15 chung eun ho
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;


/**
 * @author 9009627
 *
 */
public class EesEqr0042ConditionVO {
	private String stPlnYr = "";
	private String stPlnWk = "";
	private String endPlnYr = "";
	private String endPlnWk = "";
	private String cntCd = "";
	private String holidays = "";
	private String rcc_div_flg = "";
	private String stHolWk = "";
	private String endHolWk = "";
	private String stHolYr = "";
	private String endHolYr = "";
	private String stDt = "";
	private String Usr_id = "";
	private String[] wkInfo = null;
	@SuppressWarnings("unused")
	private String country = "";
	private String country1 = "";
	
	private String upd_usr_id = "";
	private String upd_dt = "";
    
    private String gubun = "";
    
    private String hol_eff_yrwk = "";
    
    private String newHolidayTitle = "";
    
   

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setStPlnYr(JSPUtil.getParameter(request, "stPlnYr", ""));
		setStPlnWk(JSPUtil.getParameter(request, "stPlnWk", ""));
		setEndPlnYr(JSPUtil.getParameter(request, "endPlnYr", ""));
		setStPlnYr(JSPUtil.getParameter(request, "stPlnYr", ""));
		setEndPlnWk(JSPUtil.getParameter(request, "endPlnWk", ""));
		setHol_eff_yrwk(JSPUtil.getParameter(request, "hol_eff_yrwk", ""));
		setUpd_usr_id(JSPUtil.getParameter(request, "upd_usr_id".trim(),""));
		setUpd_dt(JSPUtil.getParameter(request, "upd_dt".trim(),""));
		setCountry1(JSPUtil.getParameter(request, "country1".trim(),""));;
		setCountry(JSPUtil.getParameter(request, "country1".trim(),""));; // getCountry 메소드에서 country1 값을 가져 오도록 함 09.07.10
		setStHolWk(JSPUtil.getParameter(request, "stHolWk".trim(),""));
		setEndHolWk(JSPUtil.getParameter(request, "endHolWk".trim(),""));
		setStHolYr(JSPUtil.getParameter(request, "stHolYr".trim(),""));
		setEndHolYr(JSPUtil.getParameter(request, "endHolYr".trim(),""));
		setStDt(JSPUtil.getParameter(request, "stDt".trim(),""));
		setCntCd(JSPUtil.getParameter(request, "cntCd".trim(),""));
		setHolidays(JSPUtil.getParameter(request, "holidays".trim(),""));
		setRcc_div_flg(JSPUtil.getParameter(request, "rcc_div_flg".trim(),""));		
	}
    

	/* common */
	private String maxUpdate = "";
	private String maxUserid = "";

	/**
	 * @return the maxUpdate
	 */
	public String getMaxUpdate() {
		return maxUpdate;
	}

	/**
	 * @param maxUpdate the maxUpdate to set
	 */
	public void setMaxUpdate(String maxUpdate) {
		this.maxUpdate = maxUpdate;
	}

	/**
	 * @return the maxUserid
	 */
	public String getMaxUserid() {
		return maxUserid;
	}

	/**
	 * @param maxUserid the maxUserid to set
	 */
	public void setMaxUserid(String maxUserid) {
		this.maxUserid = maxUserid;
	}

	/**
	 * @return the stPlnYr
	 */
	public String getStPlnYr() {
		return stPlnYr;
	}

	/**
	 * @param stPlnYr the stPlnYr to set
	 */
	public void setStPlnYr(String stPlnYr) {
		this.stPlnYr = stPlnYr;
	}

	/**
	 * @return the stPlnWk
	 */
	public String getStPlnWk() {
		return stPlnWk;
	}

	/**
	 * @param stPlnWk the stPlnWk to set
	 */
	public void setStPlnWk(String stPlnWk) {
		this.stPlnWk = stPlnWk;
	}

	/**
	 * @return the endPlnYr
	 */
	public String getEndPlnYr() {
		return endPlnYr;
	}

	/**
	 * @param endPlnYr the endPlnYr to set
	 */
	public void setEndPlnYr(String endPlnYr) {
		this.endPlnYr = endPlnYr;
	}

	/**
	 * @return the endPlnWk
	 */
	public String getEndPlnWk() {
		return endPlnWk;
	}

	/**
	 * @param endPlnWk the endPlnWk to set
	 */
	public void setEndPlnWk(String endPlnWk) {
		this.endPlnWk = endPlnWk;
	}

	/**
	 * @return the cntCd
	 */
	public String getCntCd() {
		return cntCd;
	}

	/**
	 * @param cntCd the cntCd to set
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}

	/**
	 * @return the holidays
	 */
	public String getHolidays() {
		return holidays;
	}

	/**
	 * @param holidays the holidays to set
	 */
	public void setHolidays(String holidays) {
		this.holidays = holidays;
	}

	/**
	 * @return the rcc_div_flg
	 */
	public String getRcc_div_flg() {
		return rcc_div_flg;
	}

	/**
	 * @param rcc_div_flg the rcc_div_flg to set
	 */
	public void setRcc_div_flg(String rcc_div_flg) {
		this.rcc_div_flg = rcc_div_flg;
	}

	/**
	 * @return the stHolWk
	 */
	public String getStHolWk() {
		return stHolWk;
	}

	/**
	 * @param stHolWk the stHolWk to set
	 */
	public void setStHolWk(String stHolWk) {
		this.stHolWk = stHolWk;
	}

	/**
	 * @return the endHolWk
	 */
	public String getEndHolWk() {
		return endHolWk;
	}

	/**
	 * @param endHolWk the endHolWk to set
	 */
	public void setEndHolWk(String endHolWk) {
		this.endHolWk = endHolWk;
	}

	/**
	 * @return the stHolYr
	 */
	public String getStHolYr() {
		return stHolYr;
	}

	/**
	 * @param stHolYr the stHolYr to set
	 */
	public void setStHolYr(String stHolYr) {
		this.stHolYr = stHolYr;
	}

	/**
	 * @return the endHolYr
	 */
	public String getEndHolYr() {
		return endHolYr;
	}

	/**
	 * @param endHolYr the endHolYr to set
	 */
	public void setEndHolYr(String endHolYr) {
		this.endHolYr = endHolYr;
	}

	/**
	 * @return the stDt
	 */
	public String getStDt() {
		return stDt;
	}

	/**
	 * @param stDt the stDt to set
	 */
	public void setStDt(String stDt) {
		this.stDt = stDt;
	}

	/**
	 * @return the usr_id
	 */
	public String getUsr_id() {
		return Usr_id;
	}

	/**
	 * @param usr_id the usr_id to set
	 */
	public void setUsr_id(String usr_id) {
		Usr_id = usr_id;
	}

	/**
	 * @return the wkInfo
	 */
	public String[] getWkInfo() {
		return wkInfo;
	}

	/**
	 * @param wkInfo the wkInfo to set
	 */
	public void setWkInfo(String[] wkInfo) {
		this.wkInfo = wkInfo;
	}

	/**
	 * @return the country
	 */
	public String getCountry() { // IBSheet combo object 명과  DB 입력값일 일치하기 위해 country1 의 값을 country 으로 설정한다.
		return country1;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the upd_usr_id
	 */
	public String getUpd_usr_id() {
		return upd_usr_id;
	}

	/**
	 * @param upd_usr_id the upd_usr_id to set
	 */
	public void setUpd_usr_id(String upd_usr_id) {
		this.upd_usr_id = upd_usr_id;
	}

	/**
	 * @return the upd_dt
	 */
	public String getUpd_dt() {
		return upd_dt;
	}

	/**
	 * @param upd_dt the upd_dt to set
	 */
	public void setUpd_dt(String upd_dt) {
		this.upd_dt = upd_dt;
	}

	/**
	 * @return the gubun
	 */
	public String getGubun() {
		return gubun;
	}

	/**
	 * @param gubun the gubun to set
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	/**
	 * @return the hol_eff_wk
	 */
	public String getHol_eff_yrwk() {
		return hol_eff_yrwk;
	}

	/**
	 * @param hol_eff_wk the hol_eff_wk to set
	 */
	public void setHol_eff_yrwk(String hol_eff_yrwk) {
		this.hol_eff_yrwk = hol_eff_yrwk;
	}

	/**
	 * @return the country1
	 */
	public String getCountry1() {
		return country1;
	}

	/**
	 * @param country1 the country1 to set
	 */
	public void setCountry1(String country1) {
		this.country1 = country1;
	}
	 /**
	 * @return the newHolidayTitle
	 */
	public String getNewHolidayTitle() {
		return newHolidayTitle;
	}

	/**
	 * @param newHolidayTitle the newHolidayTitle to set
	 */
	public void setNewHolidayTitle(String newHolidayTitle) {
		this.newHolidayTitle = newHolidayTitle;
	}
    
}
