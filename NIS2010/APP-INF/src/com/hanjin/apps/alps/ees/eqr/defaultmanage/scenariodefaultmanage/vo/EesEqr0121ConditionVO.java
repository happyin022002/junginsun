/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0121ConditionVO.java
*@FileTitle : 연간 신조 계획 조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009-07-02
*@LastModifier : chung eun ho
*@LastVersion : 1.0
* 2009-07-02 chung eun ho
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * @author 9009627
 *
 */
public class EesEqr0121ConditionVO {
	private String status;
	private String location; 
	private String tpsz;	// tpsz 형식
	private String tpsztype; // tpsz value
	private String company;  
	private String leaseterm;
	private String year;
	
	// DAO에서 사용될 정보
	private String monthSaveInfo;
	private String weekSaveInfo;	
	private String[] monthArr;
	private String[] weekArr;
	private List<String> eccArr;
	private String monthInfo;
	private String weekInfo;
	private String weekTitleInfo;

	/* common */
	private String maxUpdate = "";
	private String maxUserid = "";
	
	/* 동적 파라메타 정의 */

	private List<String[]> MmonthSaveInfo;
	private List<String[]> FlagmonthSaveInfo;
	private List<String[]> MweekSaveInfo;
	private List<String[]> FlagweekSaveInfo;
	

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setYear(JSPUtil.getParameter(request, "year".trim(), ""));                          
		setStatus(JSPUtil.getParameter(request, "status".trim(), ""));                        
		setLocation(JSPUtil.getParameter(request, "location".trim(),""));    	             
		setTpsz(JSPUtil.getParameter(request, "tpsz".trim(), ""));      // tpsz 형식
		setTpsztype(JSPUtil.getParameter(request, "tpsztype".trim(), ""));  // tpsz value       
		setCompany(JSPUtil.getParameter(request, "company".trim(),""));                        
		setLeaseterm(JSPUtil.getParameter(request, "leaseterm".trim(),""));
		setMonthSaveInfo(JSPUtil.getParameter(request, "monthSaveInfo".trim(),"")); 	
    	setWeekSaveInfo(JSPUtil.getParameter(request, "weekSaveInfo".trim(),""));

    	if(!this.monthSaveInfo.equals(""))
    		this.monthArr   = this.monthSaveInfo.split(",");
    	if(!this.weekSaveInfo.equals(""))
    		this.weekArr   = this.weekSaveInfo.split(",");
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the tpsz
	 */
	public String getTpsz() {
		return tpsz;
	}
	/**
	 * @param tpsz the tpsz to set
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}
	/**
	 * @return the tpsztype
	 */
	public String getTpsztype() {
		return tpsztype;
	}
	/**
	 * @param tpsztype the tpsztype to set
	 */
	public void setTpsztype(String tpsztype) {
		this.tpsztype = tpsztype;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @return the leaseterm
	 */
	public String getLeaseterm() {
		return leaseterm;
	}
	/**
	 * @param leaseterm the leaseterm to set
	 */
	public void setLeaseterm(String leaseterm) {
		this.leaseterm = leaseterm;
	}
	/**
	 * @return the year
	 */
	public String getYear() {
		if(year.equals("") || year==null) {
    		year = Integer.toString(DateTime.getYear());
    	}
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * @return the monthSaveInfo
	 */
	public String getMonthSaveInfo() {
		return monthSaveInfo;
	}
	/**
	 * @param monthSaveInfo the monthSaveInfo to set
	 */
	public void setMonthSaveInfo(String monthSaveInfo) {
		this.monthSaveInfo = monthSaveInfo;
	}
	/**
	 * @return the weekSaveInfo
	 */
	public String getWeekSaveInfo() {
		return weekSaveInfo;
	}
	/**
	 * @param weekSaveInfo the weekSaveInfo to set
	 */
	public void setWeekSaveInfo(String weekSaveInfo) {
		this.weekSaveInfo = weekSaveInfo;
	}
	/**
	 * @return the monthArr
	 */
	public String[] getMonthArr() {
		if(monthSaveInfo != null){
			monthArr = monthSaveInfo.split(",");
		}
		return monthArr;
	}
	/**
	 * @param monthArr the monthArr to set
	 */
	public void setMonthArr(String[] monthArr) {
		this.monthArr = monthArr;
	}
	/**
	 * @return the weekArr
	 */
	public String[] getWeekArr() {
		if(weekSaveInfo != null){
			weekArr = weekSaveInfo.split(",");
		}
		return weekArr;
	}
	/**
	 * @param weekArr the weekArr to set
	 */
	public void setWeekArr(String[] weekArr) {
		this.weekArr = weekArr;
	}

	/**
	 * @return the eccArr
	 */
	public List<String> getEccArr() {
		return eccArr;
	}

	/**
	 * @param eccArr the eccArr to set
	 */
	public void setEccArr(List<String> eccArr) {
		this.eccArr = eccArr;
	}

	/**
	 * @return the monthInfo
	 */
	public String getMonthInfo() {
		return monthInfo;
	}

	/**
	 * @param monthInfo the monthInfo to set
	 */
	public void setMonthInfo(String monthInfo) {
		this.monthInfo = monthInfo;
	}

	/**
	 * @return the weekInfo
	 */
	public String getWeekInfo() {
		return weekInfo;
	}

	/**
	 * @param weekInfo the weekInfo to set
	 */
	public void setWeekInfo(String weekInfo) {
		this.weekInfo = weekInfo;
	}
	

	/**
	 * @return the weekTitleInfo
	 */
	public String getWeekTitleInfo() {
		return weekTitleInfo;
	}

	/**
	 * @param weekTitleInfo the weekTitleInfo to set
	 */
	public void setWeekTitleInfo(String weekTitleInfo) {
		this.weekTitleInfo = weekTitleInfo;
	}

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
	 * @return the mmonthSaveInfo
	 */
	public List<String[]> getMmonthSaveInfo() {
		return MmonthSaveInfo;
	}

	/**
	 * @param mmonthSaveInfo the mmonthSaveInfo to set
	 */
	public void setMmonthSaveInfo(List<String[]> mmonthSaveInfo) {
		MmonthSaveInfo = mmonthSaveInfo;
	}

	/**
	 * @return the flagmonthSaveInfo
	 */
	public List<String[]> getFlagmonthSaveInfo() {
		return FlagmonthSaveInfo;
	}

	/**
	 * @param flagmonthSaveInfo the flagmonthSaveInfo to set
	 */
	public void setFlagmonthSaveInfo(List<String[]> flagmonthSaveInfo) {
		FlagmonthSaveInfo = flagmonthSaveInfo;
	}

	/**
	 * @return the mweekSaveInfo
	 */
	public List<String[]> getMweekSaveInfo() {
		return MweekSaveInfo;
	}

	/**
	 * @param mweekSaveInfo the mweekSaveInfo to set
	 */
	public void setMweekSaveInfo(List<String[]> mweekSaveInfo) {
		MweekSaveInfo = mweekSaveInfo;
	}

	/**
	 * @return the flagweekSaveInfo
	 */
	public List<String[]> getFlagweekSaveInfo() {
		return FlagweekSaveInfo;
	}

	/**
	 * @param flagweekSaveInfo the flagweekSaveInfo to set
	 */
	public void setFlagweekSaveInfo(List<String[]> flagweekSaveInfo) {
		FlagweekSaveInfo = flagweekSaveInfo;
	}
	
}
