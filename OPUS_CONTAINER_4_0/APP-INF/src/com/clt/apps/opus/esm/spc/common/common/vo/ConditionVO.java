/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ConditionVO.java
*@FileTitle : ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.09.01 최윤성 
* 1.0 Creation
* 2010.08.23 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 - Operator 변수 추가
* 2010.12.03 김종준 [CHM-201007116-01] Loading by POL/POD 화면 - 기능추가 - fullFlg 변수 추가
* 2010.12.29 김종준 [CHM-201007719-01] Loading by POL/POD 화면 - 기능추가 - polpodFlg 변수 추가
=========================================================*/

package com.clt.apps.opus.esm.spc.common.common.vo;

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
 * @author 최윤성
 * @since J2EE 1.6
 * @see AbstractValueObject 
 */

public class ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ConditionVO> models = new ArrayList<ConditionVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String subtrade = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String fcast = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String salesrep = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String year = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String repTrade = null;
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String suboffice = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String duration = null;
	/* Column Info */
	private String userOfc = null;
	/* Column Info */
	private String ioc = null;
	/* Column Info */
	private String salesoffice = null;
	/* Column Info */
	private String bound = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String week = null;
	/* Column Info */
	private String month   = null;
	/* Column Info */
	private String toTrade = null;
	/* Column Info */
	private String subTrade = null;
	/* Column Info */
	private String week1 = null;
	/* Column Info */
	private String week2 = null;
	/* Column Info */
	private String year1 = null;
	/* Column Info */
	private String year2 = null;
	
	private String qtyTp = null;
	private String rhq1 = null;
	private String rhq2 = null;
	
	private String rhq = null;
	private String type = null;
	
	private String sdate = null;
	private String edate = null;
	
	private String vvdList = null;
	private String salesRepCodeList = null;
	private String operator = null;

	private String fullFlg = null;
	private String polpodFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ConditionVO() {}

	public ConditionVO(String type, String rhq, String rhq1, String rhq2, String qtyTp, String ibflag, String pagerows, String bound, String dirCd, String duration,
			           String fcast, String ioc, String iocCd, String lane, String ofcCd, String office, String podCd, String polCd, String rlaneCd, String salesoffice,
			           String salesrep, String skdDirCd, String skdVoyNo, String suboffice, String subtrade, String subTrdCd, String trade, String trdCd, String userOfc,
			           String vslCd, String vvd, String week, String year, String repTrade, String month, String toTrade, String subTrade, String year1, String year2,
			           String week1, String week2,String sdate,String edate, String vvdList, String salesRepCodeList, String operator, String fullFlg, String polpodFlg) {
		this.type = type;
		this.rhq = rhq;
		this.rhq1 = rhq1;
		this.rhq2 = rhq2;
		this.qtyTp = qtyTp;
		this.vslCd = vslCd;
		this.subtrade = subtrade;
		this.trade = trade;
		this.fcast = fcast;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.salesrep = salesrep;
		this.lane = lane;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.year = year;
		this.dirCd = dirCd;
		this.repTrade = repTrade;
		this.office = office;
		this.iocCd = iocCd;
		this.suboffice = suboffice;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.vvd = vvd;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.duration = duration;
		this.userOfc = userOfc;
		this.ioc = ioc;
		this.salesoffice = salesoffice;
		this.bound = bound;
		this.subTrdCd = subTrdCd;
		this.week = week;
		this.month = month;
		this.toTrade = toTrade;
		this.subTrade = subTrade;
		this.year1 = year1;
		this.year2 = year2;
		this.week1 = week1;
		this.week2 = week2;
		this.sdate = sdate;
		this.edate = edate;
		this.vvdList = vvdList;
		this.salesRepCodeList = salesRepCodeList;
		this.operator = operator;
		this.fullFlg = fullFlg;
		this.polpodFlg = polpodFlg;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("type", getType());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("rhq1", getRhq1());
		this.hashColumns.put("rhq2", getRhq2());
		this.hashColumns.put("qty_tp", getQtyTp());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("subtrade", getSubtrade());
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("fcast", getFcast());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("salesrep", getSalesrep());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("year", getYear());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("rep_trade", getRepTrade());
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("suboffice", getSuboffice());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("duration", getDuration());
		this.hashColumns.put("user_ofc", getUserOfc());
		this.hashColumns.put("ioc", getIoc());
		this.hashColumns.put("salesoffice", getSalesoffice());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("week", getWeek());
		this.hashColumns.put("month", getMonth());
		this.hashColumns.put("toTrade", getToTrade());
		this.hashColumns.put("sub_trade", getSubTrade());
		this.hashColumns.put("year1", getYear1());
		this.hashColumns.put("year2", getYear2());
		this.hashColumns.put("week1", getWeek1());
		this.hashColumns.put("week2", getWeek2());
		this.hashColumns.put("sdate", getSdate());
		this.hashColumns.put("edate", getEdate());
		this.hashColumns.put("vvdList", getVvdList()); 
		this.hashColumns.put("salesRepCodeList", getSalesRepCodeList());
		this.hashColumns.put("operator", getOperator());
		this.hashColumns.put("full_flg", getFullFlg());
		this.hashColumns.put("polpod_flg", getPolpodFlg());
		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("type", "type");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("rhq1", "rhq1");
		this.hashFields.put("rhq2", "rhq2");
		this.hashFields.put("qty_tp", "qtyTp");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("subtrade", "subtrade");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("fcast", "fcast");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("salesrep", "salesrep");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("year", "year");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("rep_trade", "repTrade");
		this.hashFields.put("office", "office");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("suboffice", "suboffice");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("duration", "duration");
		this.hashFields.put("user_ofc", "userOfc");
		this.hashFields.put("ioc", "ioc");
		this.hashFields.put("salesoffice", "salesoffice");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("week", "week");
		this.hashFields.put("month", "month");
		this.hashFields.put("toTrade", "toTrade");
		this.hashFields.put("sub_trade", "subTrade");
		this.hashFields.put("year1", "year1");
		this.hashFields.put("year2", "year2");
		this.hashFields.put("week1", "week1");
		this.hashFields.put("week2", "week2");
		this.hashFields.put("sdate", "sdate");
		this.hashFields.put("edate", "edate");
		this.hashFields.put("vvdList", "vvdList"); 
		this.hashFields.put("salesRepCodeList", "salesRepCodeList");
		this.hashFields.put("operator", "operator");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("polpod_flg", "polpodFlg");
		
		
		return this.hashFields;
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
	 * @return fcast
	 */
	public String getFcast() {
		return this.fcast;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return salesrep
	 */
	public String getSalesrep() {
		return this.salesrep;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return year
	 */
	public String getYear() {
		return this.year;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return repTrade
	 */
	public String getRepTrade() {
		return this.repTrade;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return suboffice
	 */
	public String getSuboffice() {
		return this.suboffice;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return duration
	 */
	public String getDuration() {
		return this.duration;
	}
	
	/**
	 * Column Info
	 * @return userOfc
	 */
	public String getUserOfc() {
		return this.userOfc;
	}
	
	/**
	 * Column Info
	 * @return ioc
	 */
	public String getIoc() {
		return this.ioc;
	}
	
	/**
	 * Column Info
	 * @return salesoffice
	 */
	public String getSalesoffice() {
		return this.salesoffice;
	}
	
	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return week
	 */
	public String getWeek() {
		return this.week;
	}
	
	/**
	 * Column Info
	 * @return week1
	 */
	public String getWeek1() {
		return this.week1;
	}
	
	/**
	 * Column Info
	 * @return subTrade
	 */
	public String getSubTrade() {
		return this.subTrade;
	}
	
	/**
	 * Column Info
	 * @return week2
	 */
	public String getWeek2() {
		return this.week2;
	}
	
		
	/**
	 * Column Info
	 * @return year2
	 */
	public String getYear2() {
		return this.year2;
	}
	
	/**
	 * Column Info
	 * @return year1
	 */
	public String getYear1() {
		return this.year1;
	}
	
	/**
	 * Column Info
	 * @return vvdList
	 */
	public String getVvdList() {
		return this.vvdList;
	}
	
	/**
	 * Column Info
	 * @return salesRepCodeList
	 */
	public String getSalesRepCodeList() {
		return this.salesRepCodeList;
	}
	
	/**
	 * Column Info
	 * @return operator
	 */
	public String getOperator() {
		return this.operator;
	}

	/**
	 * Column Info
	 * @return fullFlg
	 */
	public String getFullFlg() {
		return this.fullFlg;
	}

	/**
	 * Column Info
	 * @return polpodFlg
	 */
	public String getPolpodFlg() {
		return this.polpodFlg;
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
	 * @param fcast
	 */
	public void setFcast(String fcast) {
		this.fcast = fcast;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param salesrep
	 */
	public void setSalesrep(String salesrep) {
		this.salesrep = salesrep;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param repTrade
	 */
	public void setRepTrade(String repTrade) {
		this.repTrade = repTrade;
	}
	
	/**
	 * Column Info
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param suboffice
	 */
	public void setSuboffice(String suboffice) {
		this.suboffice = suboffice;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param duration
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	/**
	 * Column Info
	 * @param userOfc
	 */
	public void setUserOfc(String userOfc) {
		this.userOfc = userOfc;
	}
	
	/**
	 * Column Info
	 * @param ioc
	 */
	public void setIoc(String ioc) {
		this.ioc = ioc;
	}
	
	/**
	 * Column Info
	 * @param salesoffice
	 */
	public void setSalesoffice(String salesoffice) {
		this.salesoffice = salesoffice;
	}
	
	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	
	/**
	 * Column Info
	 * @param vvdList
	 */
	public void setVvdList(String vvdList) {
		this.vvdList = vvdList;
	}
	
	/**
	 * Column Info
	 * @param salesRepCodeList
	 */
	public void setSalesRepCodeList(String salesRepCodeList) {
		this.salesRepCodeList = salesRepCodeList;
	}
	
	/**
	 * Column Info
	 * @param operator
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
	public String getToTrade() {
		return toTrade;
	}

	public void setToTrade(String toTrade) {
		this.toTrade = toTrade;
	}
		
	public void setSubTrade(String subTrade) {
		this.subTrade = subTrade;
	}	
	
	public void setWeek1(String week1) {
		this.week1 = week1;
	}
	
	public void setWeek2(String week2) {
		this.week2 = week2;
	}
			
	public void setYear2(String year2) {
		this.year2 = year2;
	}
	
	public void setYear1(String year1) {
		this.year1 = year1;
	}
	
	public String getQtyTp() {
		return qtyTp;
	}

	public void setQtyTp(String qtyTp) {
		this.qtyTp = qtyTp;
	}

	public String getRhq1() {
		return rhq1;
	}

	public void setRhq1(String rhq1) {
		this.rhq1 = rhq1;
	}

	public String getRhq2() {
		return rhq2;
	}

	public void setRhq2(String rhq2) {
		this.rhq2 = rhq2;
	}

	public String getRhq() {
		return rhq;
	}

	public void setRhq(String rhq) {
		this.rhq = rhq;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
  
	public void setFullFlg(String fullFlg) {
		this.fullFlg = fullFlg;
	}

	public void setPolpodFlg(String polpodFlg) {
		this.polpodFlg = polpodFlg;
	}

	
	/**
	 * Column Info
	 * @return sdate
	 */
	public String getSdate() {
		return sdate;
	}
	
	public void  setSdate(String sdate) {
		this.sdate =  sdate;
	}
	
	/**
	 * Column Info
	 * @return edate
	 */

	public String getEdate() {
		return this.edate;
	}	
	public void  setEdate(String edate) {
		this.edate =  edate;
	}	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setType(JSPUtil.getParameter(request, "type", ""));
		setRhq(JSPUtil.getParameter(request, "rhq", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSubtrade(JSPUtil.getParameter(request, "subtrade", ""));
		setTrade(JSPUtil.getParameter(request, "trade", ""));
		setFcast(JSPUtil.getParameter(request, "fcast", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setSalesrep(JSPUtil.getParameter(request, "salesRep", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYear(JSPUtil.getParameter(request, "year", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setRepTrade(JSPUtil.getParameter(request, "rep_trade", ""));
		setOffice(JSPUtil.getParameter(request, "office", ""));
		setIocCd(JSPUtil.getParameter(request, "ioc_cd", ""));
		setSuboffice(JSPUtil.getParameter(request, "subOffice", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setDuration(JSPUtil.getParameter(request, "duration", ""));
		setUserOfc(JSPUtil.getParameter(request, "user_ofc", ""));
		setIoc(JSPUtil.getParameter(request, "ioc", ""));
		setSalesoffice(JSPUtil.getParameter(request, "salesOffice", ""));
		setBound(JSPUtil.getParameter(request, "bound", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setWeek(JSPUtil.getParameter(request, "week", ""));
		setMonth(JSPUtil.getParameter(request, "month", ""));
		setToTrade(JSPUtil.getParameter(request, "toTrade", ""));
		setWeek1(JSPUtil.getParameter(request, "week1", ""));
		setSubTrade(JSPUtil.getParameter(request, "sub_trade", ""));
		setWeek2(JSPUtil.getParameter(request, "week2", ""));
		setYear2(JSPUtil.getParameter(request, "year2", ""));
		setYear1(JSPUtil.getParameter(request, "year1", ""));
		setSdate(JSPUtil.getParameter(request, "sDate", ""));
		setEdate(JSPUtil.getParameter(request, "eDate", ""));
		setVvdList(JSPUtil.getParameter(request, "vvdList", ""));
		setSalesRepCodeList(JSPUtil.getParameter(request, "salesRepCodeList", ""));
		setOperator(JSPUtil.getParameter(request, "operator", ""));
		setFullFlg(JSPUtil.getParameter(request, "full_flg", ""));
		setPolpodFlg(JSPUtil.getParameter(request, "polpod_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ConditionVO[]
	 */
	public ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ConditionVO[]
	 */
	public ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] subtrade = (JSPUtil.getParameter(request, prefix	+ "subtrade", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] fcast = (JSPUtil.getParameter(request, prefix	+ "fcast", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] salesrep = (JSPUtil.getParameter(request, prefix	+ "salesRep", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] year = (JSPUtil.getParameter(request, prefix	+ "year", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] repTrade = (JSPUtil.getParameter(request, prefix	+ "rep_trade", length));
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] suboffice = (JSPUtil.getParameter(request, prefix	+ "subOffice", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] duration = (JSPUtil.getParameter(request, prefix	+ "duration", length));
			String[] userOfc = (JSPUtil.getParameter(request, prefix	+ "user_ofc", length));
			String[] ioc = (JSPUtil.getParameter(request, prefix	+ "ioc", length));
			String[] salesoffice = (JSPUtil.getParameter(request, prefix	+ "salesOffice", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			String[] month = (JSPUtil.getParameter(request, prefix	+ "month", length));
			String[] toTrade = (JSPUtil.getParameter(request, prefix	+ "toTrade", length));
			String[] week1 = (JSPUtil.getParameter(request, prefix	+ "week1", length));
			String[] subTrade = (JSPUtil.getParameter(request, prefix	+ "sub_trade", length));
			String[] week2 = (JSPUtil.getParameter(request, prefix	+ "week2", length));
			String[] year2 = (JSPUtil.getParameter(request, prefix	+ "year2", length));
			String[] year1 = (JSPUtil.getParameter(request, prefix	+ "year1", length));
			String[] sdate = (JSPUtil.getParameter(request, prefix	+ "sDate", length));
			String[] edate = (JSPUtil.getParameter(request, prefix	+ "eDate", length));
			String[] vvdList = (JSPUtil.getParameter(request, prefix	+ "vvdList", length));
			String[] salesRepCodeList = (JSPUtil.getParameter(request, prefix	+ "salesRepCodeList", length));
			String[] operator = (JSPUtil.getParameter(request, prefix	+ "operator", length));
			String[] fullFlg = (JSPUtil.getParameter(request, prefix	+ "full_flg", length));
			String[] polpodFlg = (JSPUtil.getParameter(request, prefix	+ "polpod_flg", length));
			
			
			
			for (int i = 0; i < length; i++) {
				model = new ConditionVO();
				if (type[i] != null)
					model.setType(type[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (subtrade[i] != null)
					model.setSubtrade(subtrade[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (fcast[i] != null)
					model.setFcast(fcast[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (salesrep[i] != null)
					model.setSalesrep(salesrep[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (year[i] != null)
					model.setYear(year[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (repTrade[i] != null)
					model.setRepTrade(repTrade[i]);
				if (office[i] != null)
					model.setOffice(office[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (suboffice[i] != null)
					model.setSuboffice(suboffice[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (duration[i] != null)
					model.setDuration(duration[i]);
				if (userOfc[i] != null)
					model.setUserOfc(userOfc[i]);
				if (ioc[i] != null)
					model.setIoc(ioc[i]);
				if (salesoffice[i] != null)
					model.setSalesoffice(salesoffice[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				if (month[i] != null)
					model.setMonth(month[i]);
				if (toTrade[i] != null)
					model.setToTrade(toTrade[i]);
				if (week1[i] != null)
					model.setWeek1(week1[i]);
				if (subTrade[i] != null)
					model.setSubTrade(subTrade[i]);
				if (week2[i] != null)
					model.setWeek2(week2[i]);
				if (year2[i] != null)
					model.setYear2(year2[i]);
				if (year1[i] != null)
					model.setYear1(year1[i]);
				if (sdate[i] != null)
					model.setSdate(sdate[i]);
				if (edate[i] != null)
					model.setEdate(edate[i]);
				if (vvdList[i] != null)
					model.setVvdList(vvdList[i]);
				if (salesRepCodeList[i] != null)
					model.setSalesRepCodeList(salesRepCodeList[i]);
				if (operator[i] != null)
					model.setOperator(operator[i]);
				if (fullFlg[i] != null)
					model.setFullFlg(fullFlg[i]);
				if (polpodFlg[i] != null)
					model.setPolpodFlg(polpodFlg[i]);
				
				
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ConditionVO[]
	 */
	public ConditionVO[] getConditionVOs(){
		ConditionVO[] vos = (ConditionVO[])models.toArray(new ConditionVO[models.size()]);
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
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq1 = this.rhq1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq2 = this.rhq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyTp = this.qtyTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subtrade = this.subtrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast = this.fcast .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesrep = this.salesrep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year = this.year .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repTrade = this.repTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.suboffice = this.suboffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duration = this.duration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOfc = this.userOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioc = this.ioc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesoffice = this.salesoffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.month = this.month .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTrade = this.toTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week1 = this.week1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrade = this.subTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week2 = this.week2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year2 = this.year2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year1 = this.year1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sdate = this.sdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edate = this.edate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdList = this.vvdList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesRepCodeList = this.salesRepCodeList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.operator = this.operator .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg = this.fullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polpodFlg = this.polpodFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		
	}
}
