/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0063ConditionVO.java
*@FileTitle : EesEqr0063ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.23  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0063ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0063ConditionVO> models = new ArrayList<EesEqr0063ConditionVO>();
	
	/* Column Info */
	private String ratiovol = null;
	/* Column Info */
	private String reason = null;
	/* Column Info */
	private String fmsyrwk = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Column Info */
	private String fmtypeby = null;
	/* Column Info */
	private String ratiovolnum = null;
	/* Column Info */
	private String frequency = null;
	/* Column Info */
	private String fmplneyr = null;
	/* Column Info */
	private String toplnswk = null;
	/* Column Info */
	private String cntrtpszcd = null;
	/* Column Info */
	private String toplnsyr = null;
	/* Column Info */
	private String weeklymonthlyflag = null;
	/* Column Info */
	private String ratiovolflag = null;
	/* Column Info */
	private String itemcd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String feedback = null;
	/* Column Info */
	private String frequencycd = null;
	/* Column Info */
	private String orgviewby = null;
	/* Column Info */
	private String weeklytype = null;
	/* Column Info */
	private String fmecccd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String adherence = null;
	/* Column Info */
	private String fmplnsyr = null;
	/* Column Info */
	private String fmplnewk = null;
	/* Column Info */
	private String ratiovoltype = null;
	/* Column Info */
	private String headtitle = null;
	/* Column Info */
	private String oddtpsz = null;
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String orgcd = null;
	/* Column Info */
	private String weekmonth = null;
	/* Column Info */
	private String toecccd = null;
	/* Column Info */
	private String toeyrwk = null;
	/* Column Info */
	private String dstviewby = null;
	/* Column Info */
	private String fmtype = null;
	/* Column Info */
	private String dstcd = null;
	/* Column Info */
	private String weeklymonthly = null;
	/* Column Info */
	private String fmeyrwk = null;
	/* Column Info */
	private String totype = null;
	/* Column Info */
	private String fmplnswk = null;
	/* Column Info */
	private String totypeby = null;
	/* Column Info */
	private String adherencecd = null;
	/* Column Info */
	private String company = null;
	/* Column Info */
	private String item = null;
	/* Column Info */
	private String tosyrwk = null;
	/* Column Info */
	private String toplneyr = null;
	/* Column Info */
	private String toplnewk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0063ConditionVO() {}

	public EesEqr0063ConditionVO(String ibflag, String pagerows, String fmtype, String fmecccd, String fmtypeby, String fmplnsyr, String fmplnswk, String fmplneyr, String fmplnewk, String totype, String toecccd, String totypeby, String toplnsyr, String toplnswk, String toplneyr, String toplnewk, String cntrtpszcd, String oddtpsz, String company, String item, String lane, String adherence, String reason, String ratiovol, String ratiovolnum, String ratiovoltype, String weeklymonthly, String weeklytype, String frequency, String feedback, String headtitle, String plnYrwk, String coCd, String orgcd, String dstcd, String itemcd, String orgviewby, String dstviewby, String ratiovolflag, String weeklymonthlyflag, String fmsyrwk, String fmeyrwk, String tosyrwk, String toeyrwk, String adherencecd, String weekmonth, String frequencycd) {
		this.ratiovol = ratiovol;
		this.reason = reason;
		this.fmsyrwk = fmsyrwk;
		this.plnYrwk = plnYrwk;
		this.fmtypeby = fmtypeby;
		this.ratiovolnum = ratiovolnum;
		this.frequency = frequency;
		this.fmplneyr = fmplneyr;
		this.toplnswk = toplnswk;
		this.cntrtpszcd = cntrtpszcd;
		this.toplnsyr = toplnsyr;
		this.weeklymonthlyflag = weeklymonthlyflag;
		this.ratiovolflag = ratiovolflag;
		this.itemcd = itemcd;
		this.pagerows = pagerows;
		this.lane = lane;
		this.feedback = feedback;
		this.frequencycd = frequencycd;
		this.orgviewby = orgviewby;
		this.weeklytype = weeklytype;
		this.fmecccd = fmecccd;
		this.ibflag = ibflag;
		this.adherence = adherence;
		this.fmplnsyr = fmplnsyr;
		this.fmplnewk = fmplnewk;
		this.ratiovoltype = ratiovoltype;
		this.headtitle = headtitle;
		this.oddtpsz = oddtpsz;
		this.coCd = coCd;
		this.orgcd = orgcd;
		this.weekmonth = weekmonth;
		this.toecccd = toecccd;
		this.toeyrwk = toeyrwk;
		this.dstviewby = dstviewby;
		this.fmtype = fmtype;
		this.dstcd = dstcd;
		this.weeklymonthly = weeklymonthly;
		this.fmeyrwk = fmeyrwk;
		this.totype = totype;
		this.fmplnswk = fmplnswk;
		this.totypeby = totypeby;
		this.adherencecd = adherencecd;
		this.company = company;
		this.item = item;
		this.tosyrwk = tosyrwk;
		this.toplneyr = toplneyr;
		this.toplnewk = toplnewk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ratiovol", getRatiovol());
		this.hashColumns.put("reason", getReason());
		this.hashColumns.put("fmsyrwk", getFmsyrwk());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("fmtypeby", getFmtypeby());
		this.hashColumns.put("ratiovolnum", getRatiovolnum());
		this.hashColumns.put("frequency", getFrequency());
		this.hashColumns.put("fmplneyr", getFmplneyr());
		this.hashColumns.put("toplnswk", getToplnswk());
		this.hashColumns.put("cntrtpszcd", getCntrtpszcd());
		this.hashColumns.put("toplnsyr", getToplnsyr());
		this.hashColumns.put("weeklymonthlyflag", getWeeklymonthlyflag());
		this.hashColumns.put("ratiovolflag", getRatiovolflag());
		this.hashColumns.put("itemcd", getItemcd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("feedback", getFeedback());
		this.hashColumns.put("frequencycd", getFrequencycd());
		this.hashColumns.put("orgviewby", getOrgviewby());
		this.hashColumns.put("weeklytype", getWeeklytype());
		this.hashColumns.put("fmecccd", getFmecccd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("adherence", getAdherence());
		this.hashColumns.put("fmplnsyr", getFmplnsyr());
		this.hashColumns.put("fmplnewk", getFmplnewk());
		this.hashColumns.put("ratiovoltype", getRatiovoltype());
		this.hashColumns.put("headtitle", getHeadtitle());
		this.hashColumns.put("oddtpsz", getOddtpsz());
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("orgcd", getOrgcd());
		this.hashColumns.put("weekmonth", getWeekmonth());
		this.hashColumns.put("toecccd", getToecccd());
		this.hashColumns.put("toeyrwk", getToeyrwk());
		this.hashColumns.put("dstviewby", getDstviewby());
		this.hashColumns.put("fmtype", getFmtype());
		this.hashColumns.put("dstcd", getDstcd());
		this.hashColumns.put("weeklymonthly", getWeeklymonthly());
		this.hashColumns.put("fmeyrwk", getFmeyrwk());
		this.hashColumns.put("totype", getTotype());
		this.hashColumns.put("fmplnswk", getFmplnswk());
		this.hashColumns.put("totypeby", getTotypeby());
		this.hashColumns.put("adherencecd", getAdherencecd());
		this.hashColumns.put("company", getCompany());
		this.hashColumns.put("item", getItem());
		this.hashColumns.put("tosyrwk", getTosyrwk());
		this.hashColumns.put("toplneyr", getToplneyr());
		this.hashColumns.put("toplnewk", getToplnewk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ratiovol", "ratiovol");
		this.hashFields.put("reason", "reason");
		this.hashFields.put("fmsyrwk", "fmsyrwk");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("fmtypeby", "fmtypeby");
		this.hashFields.put("ratiovolnum", "ratiovolnum");
		this.hashFields.put("frequency", "frequency");
		this.hashFields.put("fmplneyr", "fmplneyr");
		this.hashFields.put("toplnswk", "toplnswk");
		this.hashFields.put("cntrtpszcd", "cntrtpszcd");
		this.hashFields.put("toplnsyr", "toplnsyr");
		this.hashFields.put("weeklymonthlyflag", "weeklymonthlyflag");
		this.hashFields.put("ratiovolflag", "ratiovolflag");
		this.hashFields.put("itemcd", "itemcd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("feedback", "feedback");
		this.hashFields.put("frequencycd", "frequencycd");
		this.hashFields.put("orgviewby", "orgviewby");
		this.hashFields.put("weeklytype", "weeklytype");
		this.hashFields.put("fmecccd", "fmecccd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("adherence", "adherence");
		this.hashFields.put("fmplnsyr", "fmplnsyr");
		this.hashFields.put("fmplnewk", "fmplnewk");
		this.hashFields.put("ratiovoltype", "ratiovoltype");
		this.hashFields.put("headtitle", "headtitle");
		this.hashFields.put("oddtpsz", "oddtpsz");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("orgcd", "orgcd");
		this.hashFields.put("weekmonth", "weekmonth");
		this.hashFields.put("toecccd", "toecccd");
		this.hashFields.put("toeyrwk", "toeyrwk");
		this.hashFields.put("dstviewby", "dstviewby");
		this.hashFields.put("fmtype", "fmtype");
		this.hashFields.put("dstcd", "dstcd");
		this.hashFields.put("weeklymonthly", "weeklymonthly");
		this.hashFields.put("fmeyrwk", "fmeyrwk");
		this.hashFields.put("totype", "totype");
		this.hashFields.put("fmplnswk", "fmplnswk");
		this.hashFields.put("totypeby", "totypeby");
		this.hashFields.put("adherencecd", "adherencecd");
		this.hashFields.put("company", "company");
		this.hashFields.put("item", "item");
		this.hashFields.put("tosyrwk", "tosyrwk");
		this.hashFields.put("toplneyr", "toplneyr");
		this.hashFields.put("toplnewk", "toplnewk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ratiovol
	 */
	public String getRatiovol() {
		return this.ratiovol;
	}
	
	/**
	 * Column Info
	 * @return reason
	 */
	public String getReason() {
		return this.reason;
	}
	
	/**
	 * Column Info
	 * @return fmsyrwk
	 */
	public String getFmsyrwk() {
		return this.fmsyrwk;
	}
	
	/**
	 * Column Info
	 * @return plnYrwk
	 */
	public String getPlnYrwk() {
		return this.plnYrwk;
	}
	
	/**
	 * Column Info
	 * @return fmtypeby
	 */
	public String getFmtypeby() {
		return this.fmtypeby;
	}
	
	/**
	 * Column Info
	 * @return ratiovolnum
	 */
	public String getRatiovolnum() {
		return this.ratiovolnum;
	}
	
	/**
	 * Column Info
	 * @return frequency
	 */
	public String getFrequency() {
		return this.frequency;
	}
	
	/**
	 * Column Info
	 * @return fmplneyr
	 */
	public String getFmplneyr() {
		return this.fmplneyr;
	}
	
	/**
	 * Column Info
	 * @return toplnswk
	 */
	public String getToplnswk() {
		return this.toplnswk;
	}
	
	/**
	 * Column Info
	 * @return cntrtpszcd
	 */
	public String getCntrtpszcd() {
		return this.cntrtpszcd;
	}
	
	/**
	 * Column Info
	 * @return toplnsyr
	 */
	public String getToplnsyr() {
		return this.toplnsyr;
	}
	
	/**
	 * Column Info
	 * @return weeklymonthlyflag
	 */
	public String getWeeklymonthlyflag() {
		return this.weeklymonthlyflag;
	}
	
	/**
	 * Column Info
	 * @return ratiovolflag
	 */
	public String getRatiovolflag() {
		return this.ratiovolflag;
	}
	
	/**
	 * Column Info
	 * @return itemcd
	 */
	public String getItemcd() {
		return this.itemcd;
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
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}
	
	/**
	 * Column Info
	 * @return feedback
	 */
	public String getFeedback() {
		return this.feedback;
	}
	
	/**
	 * Column Info
	 * @return frequencycd
	 */
	public String getFrequencycd() {
		return this.frequencycd;
	}
	
	/**
	 * Column Info
	 * @return orgviewby
	 */
	public String getOrgviewby() {
		return this.orgviewby;
	}
	
	/**
	 * Column Info
	 * @return weeklytype
	 */
	public String getWeeklytype() {
		return this.weeklytype;
	}
	
	/**
	 * Column Info
	 * @return fmecccd
	 */
	public String getFmecccd() {
		return this.fmecccd;
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
	 * @return adherence
	 */
	public String getAdherence() {
		return this.adherence;
	}
	
	/**
	 * Column Info
	 * @return fmplnsyr
	 */
	public String getFmplnsyr() {
		return this.fmplnsyr;
	}
	
	/**
	 * Column Info
	 * @return fmplnewk
	 */
	public String getFmplnewk() {
		return this.fmplnewk;
	}
	
	/**
	 * Column Info
	 * @return ratiovoltype
	 */
	public String getRatiovoltype() {
		return this.ratiovoltype;
	}
	
	/**
	 * Column Info
	 * @return headtitle
	 */
	public String getHeadtitle() {
		return this.headtitle;
	}
	
	/**
	 * Column Info
	 * @return oddtpsz
	 */
	public String getOddtpsz() {
		return this.oddtpsz;
	}
	
	/**
	 * Column Info
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
	}
	
	/**
	 * Column Info
	 * @return orgcd
	 */
	public String getOrgcd() {
		return this.orgcd;
	}
	
	/**
	 * Column Info
	 * @return weekmonth
	 */
	public String getWeekmonth() {
		return this.weekmonth;
	}
	
	/**
	 * Column Info
	 * @return toecccd
	 */
	public String getToecccd() {
		return this.toecccd;
	}
	
	/**
	 * Column Info
	 * @return toeyrwk
	 */
	public String getToeyrwk() {
		return this.toeyrwk;
	}
	
	/**
	 * Column Info
	 * @return dstviewby
	 */
	public String getDstviewby() {
		return this.dstviewby;
	}
	
	/**
	 * Column Info
	 * @return fmtype
	 */
	public String getFmtype() {
		return this.fmtype;
	}
	
	/**
	 * Column Info
	 * @return dstcd
	 */
	public String getDstcd() {
		return this.dstcd;
	}
	
	/**
	 * Column Info
	 * @return weeklymonthly
	 */
	public String getWeeklymonthly() {
		return this.weeklymonthly;
	}
	
	/**
	 * Column Info
	 * @return fmeyrwk
	 */
	public String getFmeyrwk() {
		return this.fmeyrwk;
	}
	
	/**
	 * Column Info
	 * @return totype
	 */
	public String getTotype() {
		return this.totype;
	}
	
	/**
	 * Column Info
	 * @return fmplnswk
	 */
	public String getFmplnswk() {
		return this.fmplnswk;
	}
	
	/**
	 * Column Info
	 * @return totypeby
	 */
	public String getTotypeby() {
		return this.totypeby;
	}
	
	/**
	 * Column Info
	 * @return adherencecd
	 */
	public String getAdherencecd() {
		return this.adherencecd;
	}
	
	/**
	 * Column Info
	 * @return company
	 */
	public String getCompany() {
		return this.company;
	}
	
	/**
	 * Column Info
	 * @return item
	 */
	public String getItem() {
		return this.item;
	}
	
	/**
	 * Column Info
	 * @return tosyrwk
	 */
	public String getTosyrwk() {
		return this.tosyrwk;
	}
	
	/**
	 * Column Info
	 * @return toplneyr
	 */
	public String getToplneyr() {
		return this.toplneyr;
	}
	
	/**
	 * Column Info
	 * @return toplnewk
	 */
	public String getToplnewk() {
		return this.toplnewk;
	}
	

	/**
	 * Column Info
	 * @param ratiovol
	 */
	public void setRatiovol(String ratiovol) {
		this.ratiovol = ratiovol;
	}
	
	/**
	 * Column Info
	 * @param reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	/**
	 * Column Info
	 * @param fmsyrwk
	 */
	public void setFmsyrwk(String fmsyrwk) {
		this.fmsyrwk = fmsyrwk;
	}
	
	/**
	 * Column Info
	 * @param plnYrwk
	 */
	public void setPlnYrwk(String plnYrwk) {
		this.plnYrwk = plnYrwk;
	}
	
	/**
	 * Column Info
	 * @param fmtypeby
	 */
	public void setFmtypeby(String fmtypeby) {
		this.fmtypeby = fmtypeby;
	}
	
	/**
	 * Column Info
	 * @param ratiovolnum
	 */
	public void setRatiovolnum(String ratiovolnum) {
		this.ratiovolnum = ratiovolnum;
	}
	
	/**
	 * Column Info
	 * @param frequency
	 */
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	
	/**
	 * Column Info
	 * @param fmplneyr
	 */
	public void setFmplneyr(String fmplneyr) {
		this.fmplneyr = fmplneyr;
	}
	
	/**
	 * Column Info
	 * @param toplnswk
	 */
	public void setToplnswk(String toplnswk) {
		this.toplnswk = toplnswk;
	}
	
	/**
	 * Column Info
	 * @param cntrtpszcd
	 */
	public void setCntrtpszcd(String cntrtpszcd) {
		this.cntrtpszcd = cntrtpszcd;
	}
	
	/**
	 * Column Info
	 * @param toplnsyr
	 */
	public void setToplnsyr(String toplnsyr) {
		this.toplnsyr = toplnsyr;
	}
	
	/**
	 * Column Info
	 * @param weeklymonthlyflag
	 */
	public void setWeeklymonthlyflag(String weeklymonthlyflag) {
		this.weeklymonthlyflag = weeklymonthlyflag;
	}
	
	/**
	 * Column Info
	 * @param ratiovolflag
	 */
	public void setRatiovolflag(String ratiovolflag) {
		this.ratiovolflag = ratiovolflag;
	}
	
	/**
	 * Column Info
	 * @param itemcd
	 */
	public void setItemcd(String itemcd) {
		this.itemcd = itemcd;
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
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Column Info
	 * @param feedback
	 */
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	/**
	 * Column Info
	 * @param frequencycd
	 */
	public void setFrequencycd(String frequencycd) {
		this.frequencycd = frequencycd;
	}
	
	/**
	 * Column Info
	 * @param orgviewby
	 */
	public void setOrgviewby(String orgviewby) {
		this.orgviewby = orgviewby;
	}
	
	/**
	 * Column Info
	 * @param weeklytype
	 */
	public void setWeeklytype(String weeklytype) {
		this.weeklytype = weeklytype;
	}
	
	/**
	 * Column Info
	 * @param fmecccd
	 */
	public void setFmecccd(String fmecccd) {
		this.fmecccd = fmecccd;
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
	 * @param adherence
	 */
	public void setAdherence(String adherence) {
		this.adherence = adherence;
	}
	
	/**
	 * Column Info
	 * @param fmplnsyr
	 */
	public void setFmplnsyr(String fmplnsyr) {
		this.fmplnsyr = fmplnsyr;
	}
	
	/**
	 * Column Info
	 * @param fmplnewk
	 */
	public void setFmplnewk(String fmplnewk) {
		this.fmplnewk = fmplnewk;
	}
	
	/**
	 * Column Info
	 * @param ratiovoltype
	 */
	public void setRatiovoltype(String ratiovoltype) {
		this.ratiovoltype = ratiovoltype;
	}
	
	/**
	 * Column Info
	 * @param headtitle
	 */
	public void setHeadtitle(String headtitle) {
		this.headtitle = headtitle;
	}
	
	/**
	 * Column Info
	 * @param oddtpsz
	 */
	public void setOddtpsz(String oddtpsz) {
		this.oddtpsz = oddtpsz;
	}
	
	/**
	 * Column Info
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}
	
	/**
	 * Column Info
	 * @param orgcd
	 */
	public void setOrgcd(String orgcd) {
		this.orgcd = orgcd;
	}
	
	/**
	 * Column Info
	 * @param weekmonth
	 */
	public void setWeekmonth(String weekmonth) {
		this.weekmonth = weekmonth;
	}
	
	/**
	 * Column Info
	 * @param toecccd
	 */
	public void setToecccd(String toecccd) {
		this.toecccd = toecccd;
	}
	
	/**
	 * Column Info
	 * @param toeyrwk
	 */
	public void setToeyrwk(String toeyrwk) {
		this.toeyrwk = toeyrwk;
	}
	
	/**
	 * Column Info
	 * @param dstviewby
	 */
	public void setDstviewby(String dstviewby) {
		this.dstviewby = dstviewby;
	}
	
	/**
	 * Column Info
	 * @param fmtype
	 */
	public void setFmtype(String fmtype) {
		this.fmtype = fmtype;
	}
	
	/**
	 * Column Info
	 * @param dstcd
	 */
	public void setDstcd(String dstcd) {
		this.dstcd = dstcd;
	}
	
	/**
	 * Column Info
	 * @param weeklymonthly
	 */
	public void setWeeklymonthly(String weeklymonthly) {
		this.weeklymonthly = weeklymonthly;
	}
	
	/**
	 * Column Info
	 * @param fmeyrwk
	 */
	public void setFmeyrwk(String fmeyrwk) {
		this.fmeyrwk = fmeyrwk;
	}
	
	/**
	 * Column Info
	 * @param totype
	 */
	public void setTotype(String totype) {
		this.totype = totype;
	}
	
	/**
	 * Column Info
	 * @param fmplnswk
	 */
	public void setFmplnswk(String fmplnswk) {
		this.fmplnswk = fmplnswk;
	}
	
	/**
	 * Column Info
	 * @param totypeby
	 */
	public void setTotypeby(String totypeby) {
		this.totypeby = totypeby;
	}
	
	/**
	 * Column Info
	 * @param adherencecd
	 */
	public void setAdherencecd(String adherencecd) {
		this.adherencecd = adherencecd;
	}
	
	/**
	 * Column Info
	 * @param company
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	/**
	 * Column Info
	 * @param item
	 */
	public void setItem(String item) {
		this.item = item;
	}
	
	/**
	 * Column Info
	 * @param tosyrwk
	 */
	public void setTosyrwk(String tosyrwk) {
		this.tosyrwk = tosyrwk;
	}
	
	/**
	 * Column Info
	 * @param toplneyr
	 */
	public void setToplneyr(String toplneyr) {
		this.toplneyr = toplneyr;
	}
	
	/**
	 * Column Info
	 * @param toplnewk
	 */
	public void setToplnewk(String toplnewk) {
		this.toplnewk = toplnewk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRatiovol(JSPUtil.getParameter(request, "ratioVol", ""));
		setReason(JSPUtil.getParameter(request, "reason", ""));
		setFmsyrwk(JSPUtil.getParameter(request, "fmSYrWk", ""));
		setPlnYrwk(JSPUtil.getParameter(request, "pln_yrwk", ""));
		setFmtypeby(JSPUtil.getParameter(request, "fmTypeBy", ""));
		setRatiovolnum(JSPUtil.getParameter(request, "ratioVolNum", ""));
		setFrequency(JSPUtil.getParameter(request, "frequency", ""));
		setFmplneyr(JSPUtil.getParameter(request, "fmPlnEYr", ""));
		setToplnswk(JSPUtil.getParameter(request, "toPlnSWk", ""));
		setCntrtpszcd(JSPUtil.getParameter(request, "cntrTpszCd", ""));
		setToplnsyr(JSPUtil.getParameter(request, "toPlnSYr", ""));
		setWeeklymonthlyflag(JSPUtil.getParameter(request, "weeklyMonthlyFlag", ""));
		setRatiovolflag(JSPUtil.getParameter(request, "ratioVolFlag", ""));
		setItemcd(JSPUtil.getParameter(request, "itemCd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setFeedback(JSPUtil.getParameter(request, "feedback", "").toLowerCase()); // 주의
		setFrequencycd(JSPUtil.getParameter(request, "frequencyCd", ""));
		setOrgviewby(JSPUtil.getParameter(request, "orgViewBy", ""));
		setWeeklytype(JSPUtil.getParameter(request, "weeklyType", ""));
		setFmecccd(JSPUtil.getParameter(request, "fmEccCd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAdherence(JSPUtil.getParameter(request, "adherence", ""));
		setFmplnsyr(JSPUtil.getParameter(request, "fmPlnSYr", ""));
		setFmplnewk(JSPUtil.getParameter(request, "fmPlnEWk", ""));
		setRatiovoltype(JSPUtil.getParameter(request, "ratioVolType", ""));
		setHeadtitle(JSPUtil.getParameter(request, "headTitle", ""));
		setOddtpsz(JSPUtil.getParameter(request, "oddtpsz", ""));
		setCoCd(JSPUtil.getParameter(request, "co_cd", ""));
		setOrgcd(JSPUtil.getParameter(request, "orgCd", ""));
		setWeekmonth(JSPUtil.getParameter(request, "weekMonth", ""));
		setToecccd(JSPUtil.getParameter(request, "toEccCd", ""));
		setToeyrwk(JSPUtil.getParameter(request, "toEYrWk", ""));
		setDstviewby(JSPUtil.getParameter(request, "dstViewBy", ""));
		setFmtype(JSPUtil.getParameter(request, "fmType", ""));
		setDstcd(JSPUtil.getParameter(request, "dstCd", ""));
		setWeeklymonthly(JSPUtil.getParameter(request, "weeklyMonthly", ""));
		setFmeyrwk(JSPUtil.getParameter(request, "fmEYrWk", ""));
		setTotype(JSPUtil.getParameter(request, "toType", ""));
		setFmplnswk(JSPUtil.getParameter(request, "fmPlnSWk", ""));
		setTotypeby(JSPUtil.getParameter(request, "toTypeBy", ""));
		setAdherencecd(JSPUtil.getParameter(request, "adherenceCd", ""));
		setCompany(JSPUtil.getParameter(request, "company", ""));
		setItem(JSPUtil.getParameter(request, "item", ""));
		setTosyrwk(JSPUtil.getParameter(request, "toSYrWk", ""));
		setToplneyr(JSPUtil.getParameter(request, "toPlnEYr", ""));
		setToplnewk(JSPUtil.getParameter(request, "toPlnEWk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0063ConditionVO[]
	 */
	public EesEqr0063ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0063ConditionVO[]
	 */
	public EesEqr0063ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0063ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ratiovol = (JSPUtil.getParameter(request, prefix	+ "ratiovol", length));
			String[] reason = (JSPUtil.getParameter(request, prefix	+ "reason", length));
			String[] fmsyrwk = (JSPUtil.getParameter(request, prefix	+ "fmsyrwk", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] fmtypeby = (JSPUtil.getParameter(request, prefix	+ "fmtypeby", length));
			String[] ratiovolnum = (JSPUtil.getParameter(request, prefix	+ "ratiovolnum", length));
			String[] frequency = (JSPUtil.getParameter(request, prefix	+ "frequency", length));
			String[] fmplneyr = (JSPUtil.getParameter(request, prefix	+ "fmplneyr", length));
			String[] toplnswk = (JSPUtil.getParameter(request, prefix	+ "toplnswk", length));
			String[] cntrtpszcd = (JSPUtil.getParameter(request, prefix	+ "cntrtpszcd", length));
			String[] toplnsyr = (JSPUtil.getParameter(request, prefix	+ "toplnsyr", length));
			String[] weeklymonthlyflag = (JSPUtil.getParameter(request, prefix	+ "weeklymonthlyflag", length));
			String[] ratiovolflag = (JSPUtil.getParameter(request, prefix	+ "ratiovolflag", length));
			String[] itemcd = (JSPUtil.getParameter(request, prefix	+ "itemcd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] feedback = (JSPUtil.getParameter(request, prefix	+ "feedback", length));
			String[] frequencycd = (JSPUtil.getParameter(request, prefix	+ "frequencycd", length));
			String[] orgviewby = (JSPUtil.getParameter(request, prefix	+ "orgviewby", length));
			String[] weeklytype = (JSPUtil.getParameter(request, prefix	+ "weeklytype", length));
			String[] fmecccd = (JSPUtil.getParameter(request, prefix	+ "fmecccd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] adherence = (JSPUtil.getParameter(request, prefix	+ "adherence", length));
			String[] fmplnsyr = (JSPUtil.getParameter(request, prefix	+ "fmplnsyr", length));
			String[] fmplnewk = (JSPUtil.getParameter(request, prefix	+ "fmplnewk", length));
			String[] ratiovoltype = (JSPUtil.getParameter(request, prefix	+ "ratiovoltype", length));
			String[] headtitle = (JSPUtil.getParameter(request, prefix	+ "headtitle", length));
			String[] oddtpsz = (JSPUtil.getParameter(request, prefix	+ "oddtpsz", length));
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] orgcd = (JSPUtil.getParameter(request, prefix	+ "orgcd", length));
			String[] weekmonth = (JSPUtil.getParameter(request, prefix	+ "weekmonth", length));
			String[] toecccd = (JSPUtil.getParameter(request, prefix	+ "toecccd", length));
			String[] toeyrwk = (JSPUtil.getParameter(request, prefix	+ "toeyrwk", length));
			String[] dstviewby = (JSPUtil.getParameter(request, prefix	+ "dstviewby", length));
			String[] fmtype = (JSPUtil.getParameter(request, prefix	+ "fmtype", length));
			String[] dstcd = (JSPUtil.getParameter(request, prefix	+ "dstcd", length));
			String[] weeklymonthly = (JSPUtil.getParameter(request, prefix	+ "weeklymonthly", length));
			String[] fmeyrwk = (JSPUtil.getParameter(request, prefix	+ "fmeyrwk", length));
			String[] totype = (JSPUtil.getParameter(request, prefix	+ "totype", length));
			String[] fmplnswk = (JSPUtil.getParameter(request, prefix	+ "fmplnswk", length));
			String[] totypeby = (JSPUtil.getParameter(request, prefix	+ "totypeby", length));
			String[] adherencecd = (JSPUtil.getParameter(request, prefix	+ "adherencecd", length));
			String[] company = (JSPUtil.getParameter(request, prefix	+ "company", length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item", length));
			String[] tosyrwk = (JSPUtil.getParameter(request, prefix	+ "tosyrwk", length));
			String[] toplneyr = (JSPUtil.getParameter(request, prefix	+ "toplneyr", length));
			String[] toplnewk = (JSPUtil.getParameter(request, prefix	+ "toplnewk", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0063ConditionVO();
				if (ratiovol[i] != null)
					model.setRatiovol(ratiovol[i]);
				if (reason[i] != null)
					model.setReason(reason[i]);
				if (fmsyrwk[i] != null)
					model.setFmsyrwk(fmsyrwk[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (fmtypeby[i] != null)
					model.setFmtypeby(fmtypeby[i]);
				if (ratiovolnum[i] != null)
					model.setRatiovolnum(ratiovolnum[i]);
				if (frequency[i] != null)
					model.setFrequency(frequency[i]);
				if (fmplneyr[i] != null)
					model.setFmplneyr(fmplneyr[i]);
				if (toplnswk[i] != null)
					model.setToplnswk(toplnswk[i]);
				if (cntrtpszcd[i] != null)
					model.setCntrtpszcd(cntrtpszcd[i]);
				if (toplnsyr[i] != null)
					model.setToplnsyr(toplnsyr[i]);
				if (weeklymonthlyflag[i] != null)
					model.setWeeklymonthlyflag(weeklymonthlyflag[i]);
				if (ratiovolflag[i] != null)
					model.setRatiovolflag(ratiovolflag[i]);
				if (itemcd[i] != null)
					model.setItemcd(itemcd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (feedback[i] != null)
					model.setFeedback(feedback[i]);
				if (frequencycd[i] != null)
					model.setFrequencycd(frequencycd[i]);
				if (orgviewby[i] != null)
					model.setOrgviewby(orgviewby[i]);
				if (weeklytype[i] != null)
					model.setWeeklytype(weeklytype[i]);
				if (fmecccd[i] != null)
					model.setFmecccd(fmecccd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (adherence[i] != null)
					model.setAdherence(adherence[i]);
				if (fmplnsyr[i] != null)
					model.setFmplnsyr(fmplnsyr[i]);
				if (fmplnewk[i] != null)
					model.setFmplnewk(fmplnewk[i]);
				if (ratiovoltype[i] != null)
					model.setRatiovoltype(ratiovoltype[i]);
				if (headtitle[i] != null)
					model.setHeadtitle(headtitle[i]);
				if (oddtpsz[i] != null)
					model.setOddtpsz(oddtpsz[i]);
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (orgcd[i] != null)
					model.setOrgcd(orgcd[i]);
				if (weekmonth[i] != null)
					model.setWeekmonth(weekmonth[i]);
				if (toecccd[i] != null)
					model.setToecccd(toecccd[i]);
				if (toeyrwk[i] != null)
					model.setToeyrwk(toeyrwk[i]);
				if (dstviewby[i] != null)
					model.setDstviewby(dstviewby[i]);
				if (fmtype[i] != null)
					model.setFmtype(fmtype[i]);
				if (dstcd[i] != null)
					model.setDstcd(dstcd[i]);
				if (weeklymonthly[i] != null)
					model.setWeeklymonthly(weeklymonthly[i]);
				if (fmeyrwk[i] != null)
					model.setFmeyrwk(fmeyrwk[i]);
				if (totype[i] != null)
					model.setTotype(totype[i]);
				if (fmplnswk[i] != null)
					model.setFmplnswk(fmplnswk[i]);
				if (totypeby[i] != null)
					model.setTotypeby(totypeby[i]);
				if (adherencecd[i] != null)
					model.setAdherencecd(adherencecd[i]);
				if (company[i] != null)
					model.setCompany(company[i]);
				if (item[i] != null)
					model.setItem(item[i]);
				if (tosyrwk[i] != null)
					model.setTosyrwk(tosyrwk[i]);
				if (toplneyr[i] != null)
					model.setToplneyr(toplneyr[i]);
				if (toplnewk[i] != null)
					model.setToplnewk(toplnewk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0063ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0063ConditionVO[]
	 */
	public EesEqr0063ConditionVO[] getEesEqr0063ConditionVOs(){
		EesEqr0063ConditionVO[] vos = (EesEqr0063ConditionVO[])models.toArray(new EesEqr0063ConditionVO[models.size()]);
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
		this.ratiovol = this.ratiovol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reason = this.reason .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmsyrwk = this.fmsyrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtypeby = this.fmtypeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratiovolnum = this.ratiovolnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frequency = this.frequency .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplneyr = this.fmplneyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnswk = this.toplnswk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtpszcd = this.cntrtpszcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnsyr = this.toplnsyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weeklymonthlyflag = this.weeklymonthlyflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratiovolflag = this.ratiovolflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemcd = this.itemcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feedback = this.feedback .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frequencycd = this.frequencycd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgviewby = this.orgviewby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weeklytype = this.weeklytype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmecccd = this.fmecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adherence = this.adherence .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnsyr = this.fmplnsyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnewk = this.fmplnewk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratiovoltype = this.ratiovoltype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.headtitle = this.headtitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oddtpsz = this.oddtpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgcd = this.orgcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weekmonth = this.weekmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toecccd = this.toecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toeyrwk = this.toeyrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dstviewby = this.dstviewby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtype = this.fmtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dstcd = this.dstcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weeklymonthly = this.weeklymonthly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmeyrwk = this.fmeyrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totype = this.totype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnswk = this.fmplnswk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totypeby = this.totypeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adherencecd = this.adherencecd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company = this.company .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tosyrwk = this.tosyrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplneyr = this.toplneyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnewk = this.toplnewk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
