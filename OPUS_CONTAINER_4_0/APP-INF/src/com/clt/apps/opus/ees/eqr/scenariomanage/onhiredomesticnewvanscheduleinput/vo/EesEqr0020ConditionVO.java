/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0020ConditionVO.java
*@FileTitle : EesEqr0020ConditionVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.08.03		1.0 최초 생성
*
*@LastModifyDate : 2009.08.03
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.03  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0020ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0020ConditionVO> models = new ArrayList<EesEqr0020ConditionVO>();
	
	/* Column Info */
	private String endWeekly = null;
	/* Column Info */
	private String sheetNum = null;
	/* Column Info */
	private String col1 = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String statusType = null;
	/* Column Info */
	private String fCmd = null;
	/* Column Info */
	private String stYear = null;
	/* Column Info */
	private String titleMonth = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String maxPlnyrwk = null;
	/* Column Info */
	private String stWeekly = null;
	/* Column Info */
	private String loctype = null;
	/* Column Info */
	private String tpsztype = null;
	/* Column Info */
	private String perfixMonth = null;
	/* Column Info */
	private String monthlyCount = null;
	/* Column Info */
	private String perfixWeekly = null;
	/* Column Info */
	private String endYear = null;
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String titleWeekly = null;
	/* Column Info */
	private String searchword = null;
	/* Column Info */
	private String maxWeekly = null;
	/* Column Info */
	private String row = null;
	/* Column Info */
	private String stMonth = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String company = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String endMonth = null;
	/* Column Info */
	private String leaseterm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0020ConditionVO() {}

	public EesEqr0020ConditionVO(String ibflag, String pagerows, String scnrId, String fCmd, String titleMonth, String titleWeekly, String statusType, String maxWeekly, String maxPlnyrwk, String yyyyww, String seq, String location, String tpsz, String leaseterm, String loctype, String tpsztype, String company, String stYear, String stMonth, String stWeekly, String endYear, String endMonth, String endWeekly, String perfixMonth, String perfixWeekly, String monthlyCount, String sheetNum, String row, String col1, String searchword) {
		this.endWeekly = endWeekly;
		this.sheetNum = sheetNum;
		this.col1 = col1;
		this.location = location;
		this.statusType = statusType;
		this.fCmd = fCmd;
		this.stYear = stYear;
		this.titleMonth = titleMonth;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.maxPlnyrwk = maxPlnyrwk;
		this.stWeekly = stWeekly;
		this.loctype = loctype;
		this.tpsztype = tpsztype;
		this.perfixMonth = perfixMonth;
		this.monthlyCount = monthlyCount;
		this.perfixWeekly = perfixWeekly;
		this.endYear = endYear;
		this.scnrId = scnrId;
		this.titleWeekly = titleWeekly;
		this.searchword = searchword;
		this.maxWeekly = maxWeekly;
		this.row = row;
		this.stMonth = stMonth;
		this.yyyyww = yyyyww;
		this.tpsz = tpsz;
		this.company = company;
		this.seq = seq;
		this.endMonth = endMonth;
		this.leaseterm = leaseterm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("end_weekly", getEndWeekly());
		this.hashColumns.put("sheet_num", getSheetNum());
		this.hashColumns.put("col1", getCol1());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("status_type", getStatusType());
		this.hashColumns.put("f_cmd", getFCmd());
		this.hashColumns.put("st_year", getStYear());
		this.hashColumns.put("title_month", getTitleMonth());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("max_plnyrwk", getMaxPlnyrwk());
		this.hashColumns.put("st_weekly", getStWeekly());
		this.hashColumns.put("loctype", getLoctype());
		this.hashColumns.put("tpsztype", getTpsztype());
		this.hashColumns.put("perfix_month", getPerfixMonth());
		this.hashColumns.put("monthly_count", getMonthlyCount());
		this.hashColumns.put("perfix_weekly", getPerfixWeekly());
		this.hashColumns.put("end_year", getEndYear());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("title_weekly", getTitleWeekly());
		this.hashColumns.put("searchword", getSearchword());
		this.hashColumns.put("max_weekly", getMaxWeekly());
		this.hashColumns.put("row", getRow());
		this.hashColumns.put("st_month", getStMonth());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("company", getCompany());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("end_month", getEndMonth());
		this.hashColumns.put("leaseterm", getLeaseterm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("end_weekly", "endWeekly");
		this.hashFields.put("sheet_num", "sheetNum");
		this.hashFields.put("col1", "col1");
		this.hashFields.put("location", "location");
		this.hashFields.put("status_type", "statusType");
		this.hashFields.put("f_cmd", "fCmd");
		this.hashFields.put("st_year", "stYear");
		this.hashFields.put("title_month", "titleMonth");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("max_plnyrwk", "maxPlnyrwk");
		this.hashFields.put("st_weekly", "stWeekly");
		this.hashFields.put("loctype", "loctype");
		this.hashFields.put("tpsztype", "tpsztype");
		this.hashFields.put("perfix_month", "perfixMonth");
		this.hashFields.put("monthly_count", "monthlyCount");
		this.hashFields.put("perfix_weekly", "perfixWeekly");
		this.hashFields.put("end_year", "endYear");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("title_weekly", "titleWeekly");
		this.hashFields.put("searchword", "searchword");
		this.hashFields.put("max_weekly", "maxWeekly");
		this.hashFields.put("row", "row");
		this.hashFields.put("st_month", "stMonth");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("company", "company");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("end_month", "endMonth");
		this.hashFields.put("leaseterm", "leaseterm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return endWeekly
	 */
	public String getEndWeekly() {
		return this.endWeekly;
	}
	
	/**
	 * Column Info
	 * @return sheetNum
	 */
	public String getSheetNum() {
		return this.sheetNum;
	}
	
	/**
	 * Column Info
	 * @return col1
	 */
	public String getCol1() {
		return this.col1;
	}
	
	/**
	 * Column Info
	 * @return location
	 */
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * Column Info
	 * @return statusType
	 */
	public String getStatusType() {
		return this.statusType;
	}
	
	/**
	 * Column Info
	 * @return fCmd
	 */
	public String getFCmd() {
		return this.fCmd;
	}
	
	/**
	 * Column Info
	 * @return stYear
	 */
	public String getStYear() {
		return this.stYear;
	}
	
	/**
	 * Column Info
	 * @return titleMonth
	 */
	public String getTitleMonth() {
		return this.titleMonth;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return maxPlnyrwk
	 */
	public String getMaxPlnyrwk() {
		return this.maxPlnyrwk;
	}
	
	/**
	 * Column Info
	 * @return stWeekly
	 */
	public String getStWeekly() {
		return this.stWeekly;
	}
	
	/**
	 * Column Info
	 * @return loctype
	 */
	public String getLoctype() {
		return this.loctype;
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
	 * @return perfixMonth
	 */
	public String getPerfixMonth() {
		return this.perfixMonth;
	}
	
	/**
	 * Column Info
	 * @return monthlyCount
	 */
	public String getMonthlyCount() {
		return this.monthlyCount;
	}
	
	/**
	 * Column Info
	 * @return perfixWeekly
	 */
	public String getPerfixWeekly() {
		return this.perfixWeekly;
	}
	
	/**
	 * Column Info
	 * @return endYear
	 */
	public String getEndYear() {
		return this.endYear;
	}
	
	/**
	 * Column Info
	 * @return scnrId
	 */
	public String getScnrId() {
		return this.scnrId;
	}
	
	/**
	 * Column Info
	 * @return titleWeekly
	 */
	public String getTitleWeekly() {
		return this.titleWeekly;
	}
	
	/**
	 * Column Info
	 * @return searchword
	 */
	public String getSearchword() {
		return this.searchword;
	}
	
	/**
	 * Column Info
	 * @return maxWeekly
	 */
	public String getMaxWeekly() {
		return this.maxWeekly;
	}
	
	/**
	 * Column Info
	 * @return row
	 */
	public String getRow() {
		return this.row;
	}
	
	/**
	 * Column Info
	 * @return stMonth
	 */
	public String getStMonth() {
		return this.stMonth;
	}
	
	/**
	 * Column Info
	 * @return yyyyww
	 */
	public String getYyyyww() {
		return this.yyyyww;
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
	 * @return company
	 */
	public String getCompany() {
		return this.company;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return endMonth
	 */
	public String getEndMonth() {
		return this.endMonth;
	}
	
	/**
	 * Column Info
	 * @return leaseterm
	 */
	public String getLeaseterm() {
		return this.leaseterm;
	}
	

	/**
	 * Column Info
	 * @param endWeekly
	 */
	public void setEndWeekly(String endWeekly) {
		this.endWeekly = endWeekly;
	}
	
	/**
	 * Column Info
	 * @param sheetNum
	 */
	public void setSheetNum(String sheetNum) {
		this.sheetNum = sheetNum;
	}
	
	/**
	 * Column Info
	 * @param col1
	 */
	public void setCol1(String col1) {
		this.col1 = col1;
	}
	
	/**
	 * Column Info
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Column Info
	 * @param statusType
	 */
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	
	/**
	 * Column Info
	 * @param fCmd
	 */
	public void setFCmd(String fCmd) {
		this.fCmd = fCmd;
	}
	
	/**
	 * Column Info
	 * @param stYear
	 */
	public void setStYear(String stYear) {
		this.stYear = stYear;
	}
	
	/**
	 * Column Info
	 * @param titleMonth
	 */
	public void setTitleMonth(String titleMonth) {
		this.titleMonth = titleMonth;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param maxPlnyrwk
	 */
	public void setMaxPlnyrwk(String maxPlnyrwk) {
		this.maxPlnyrwk = maxPlnyrwk;
	}
	
	/**
	 * Column Info
	 * @param stWeekly
	 */
	public void setStWeekly(String stWeekly) {
		this.stWeekly = stWeekly;
	}
	
	/**
	 * Column Info
	 * @param loctype
	 */
	public void setLoctype(String loctype) {
		this.loctype = loctype;
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
	 * @param perfixMonth
	 */
	public void setPerfixMonth(String perfixMonth) {
		this.perfixMonth = perfixMonth;
	}
	
	/**
	 * Column Info
	 * @param monthlyCount
	 */
	public void setMonthlyCount(String monthlyCount) {
		this.monthlyCount = monthlyCount;
	}
	
	/**
	 * Column Info
	 * @param perfixWeekly
	 */
	public void setPerfixWeekly(String perfixWeekly) {
		this.perfixWeekly = perfixWeekly;
	}
	
	/**
	 * Column Info
	 * @param endYear
	 */
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	
	/**
	 * Column Info
	 * @param scnrId
	 */
	public void setScnrId(String scnrId) {
		this.scnrId = scnrId;
	}
	
	/**
	 * Column Info
	 * @param titleWeekly
	 */
	public void setTitleWeekly(String titleWeekly) {
		this.titleWeekly = titleWeekly;
	}
	
	/**
	 * Column Info
	 * @param searchword
	 */
	public void setSearchword(String searchword) {
		this.searchword = searchword;
	}
	
	/**
	 * Column Info
	 * @param maxWeekly
	 */
	public void setMaxWeekly(String maxWeekly) {
		this.maxWeekly = maxWeekly;
	}
	
	/**
	 * Column Info
	 * @param row
	 */
	public void setRow(String row) {
		this.row = row;
	}
	
	/**
	 * Column Info
	 * @param stMonth
	 */
	public void setStMonth(String stMonth) {
		this.stMonth = stMonth;
	}
	
	/**
	 * Column Info
	 * @param yyyyww
	 */
	public void setYyyyww(String yyyyww) {
		this.yyyyww = yyyyww;
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
	 * @param company
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param endMonth
	 */
	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}
	
	/**
	 * Column Info
	 * @param leaseterm
	 */
	public void setLeaseterm(String leaseterm) {
		this.leaseterm = leaseterm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEndWeekly(JSPUtil.getParameter(request, "end_weekly", ""));
		setSheetNum(JSPUtil.getParameter(request, "sheet_num", ""));
		setCol1(JSPUtil.getParameter(request, "Col1", ""));
		setLocation(JSPUtil.getParameter(request, "location", ""));
		setStatusType(JSPUtil.getParameter(request, "status_type", ""));
		setFCmd(JSPUtil.getParameter(request, "f_cmd", ""));
		setStYear(JSPUtil.getParameter(request, "st_year", ""));
		setTitleMonth(JSPUtil.getParameter(request, "title_month", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMaxPlnyrwk(JSPUtil.getParameter(request, "max_plnyrwk", ""));
		setStWeekly(JSPUtil.getParameter(request, "st_weekly", ""));
		setLoctype(JSPUtil.getParameter(request, "loctype", ""));
		setTpsztype(JSPUtil.getParameter(request, "tpsztype", ""));
		setPerfixMonth(JSPUtil.getParameter(request, "perfix_month", ""));
		setMonthlyCount(JSPUtil.getParameter(request, "monthly_count", ""));
		setPerfixWeekly(JSPUtil.getParameter(request, "perfix_weekly", ""));
		setEndYear(JSPUtil.getParameter(request, "end_year", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setTitleWeekly(JSPUtil.getParameter(request, "title_weekly", ""));
		setSearchword(JSPUtil.getParameter(request, "searchword", ""));
		setMaxWeekly(JSPUtil.getParameter(request, "max_weekly", ""));
		setRow(JSPUtil.getParameter(request, "Row", ""));
		setStMonth(JSPUtil.getParameter(request, "st_month", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setTpsz(JSPUtil.getParameter(request, "tpsz", ""));
		setCompany(JSPUtil.getParameter(request, "company", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setEndMonth(JSPUtil.getParameter(request, "end_month", ""));
		setLeaseterm(JSPUtil.getParameter(request, "leaseterm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0020ConditionVO[]
	 */
	public EesEqr0020ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0020ConditionVO[]
	 */
	public EesEqr0020ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0020ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] endWeekly = (JSPUtil.getParameter(request, prefix	+ "end_weekly", length));
			String[] sheetNum = (JSPUtil.getParameter(request, prefix	+ "sheet_num", length));
			String[] col1 = (JSPUtil.getParameter(request, prefix	+ "col1", length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] statusType = (JSPUtil.getParameter(request, prefix	+ "status_type", length));
			String[] fCmd = (JSPUtil.getParameter(request, prefix	+ "f_cmd", length));
			String[] stYear = (JSPUtil.getParameter(request, prefix	+ "st_year", length));
			String[] titleMonth = (JSPUtil.getParameter(request, prefix	+ "title_month", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] maxPlnyrwk = (JSPUtil.getParameter(request, prefix	+ "max_plnyrwk", length));
			String[] stWeekly = (JSPUtil.getParameter(request, prefix	+ "st_weekly", length));
			String[] loctype = (JSPUtil.getParameter(request, prefix	+ "loctype", length));
			String[] tpsztype = (JSPUtil.getParameter(request, prefix	+ "tpsztype", length));
			String[] perfixMonth = (JSPUtil.getParameter(request, prefix	+ "perfix_month", length));
			String[] monthlyCount = (JSPUtil.getParameter(request, prefix	+ "monthly_count", length));
			String[] perfixWeekly = (JSPUtil.getParameter(request, prefix	+ "perfix_weekly", length));
			String[] endYear = (JSPUtil.getParameter(request, prefix	+ "end_year", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] titleWeekly = (JSPUtil.getParameter(request, prefix	+ "title_weekly", length));
			String[] searchword = (JSPUtil.getParameter(request, prefix	+ "searchword", length));
			String[] maxWeekly = (JSPUtil.getParameter(request, prefix	+ "max_weekly", length));
			String[] row = (JSPUtil.getParameter(request, prefix	+ "row", length));
			String[] stMonth = (JSPUtil.getParameter(request, prefix	+ "st_month", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz", length));
			String[] company = (JSPUtil.getParameter(request, prefix	+ "company", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] endMonth = (JSPUtil.getParameter(request, prefix	+ "end_month", length));
			String[] leaseterm = (JSPUtil.getParameter(request, prefix	+ "leaseterm", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0020ConditionVO();
				if (endWeekly[i] != null)
					model.setEndWeekly(endWeekly[i]);
				if (sheetNum[i] != null)
					model.setSheetNum(sheetNum[i]);
				if (col1[i] != null)
					model.setCol1(col1[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (statusType[i] != null)
					model.setStatusType(statusType[i]);
				if (fCmd[i] != null)
					model.setFCmd(fCmd[i]);
				if (stYear[i] != null)
					model.setStYear(stYear[i]);
				if (titleMonth[i] != null)
					model.setTitleMonth(titleMonth[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (maxPlnyrwk[i] != null)
					model.setMaxPlnyrwk(maxPlnyrwk[i]);
				if (stWeekly[i] != null)
					model.setStWeekly(stWeekly[i]);
				if (loctype[i] != null)
					model.setLoctype(loctype[i]);
				if (tpsztype[i] != null)
					model.setTpsztype(tpsztype[i]);
				if (perfixMonth[i] != null)
					model.setPerfixMonth(perfixMonth[i]);
				if (monthlyCount[i] != null)
					model.setMonthlyCount(monthlyCount[i]);
				if (perfixWeekly[i] != null)
					model.setPerfixWeekly(perfixWeekly[i]);
				if (endYear[i] != null)
					model.setEndYear(endYear[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (titleWeekly[i] != null)
					model.setTitleWeekly(titleWeekly[i]);
				if (searchword[i] != null)
					model.setSearchword(searchword[i]);
				if (maxWeekly[i] != null)
					model.setMaxWeekly(maxWeekly[i]);
				if (row[i] != null)
					model.setRow(row[i]);
				if (stMonth[i] != null)
					model.setStMonth(stMonth[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (company[i] != null)
					model.setCompany(company[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (endMonth[i] != null)
					model.setEndMonth(endMonth[i]);
				if (leaseterm[i] != null)
					model.setLeaseterm(leaseterm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0020ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0020ConditionVO[]
	 */
	public EesEqr0020ConditionVO[] getEesEqr0020ConditionVOs(){
		EesEqr0020ConditionVO[] vos = (EesEqr0020ConditionVO[])models.toArray(new EesEqr0020ConditionVO[models.size()]);
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
		this.endWeekly = this.endWeekly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetNum = this.sheetNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col1 = this.col1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusType = this.statusType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmd = this.fCmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stYear = this.stYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.titleMonth = this.titleMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxPlnyrwk = this.maxPlnyrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stWeekly = this.stWeekly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loctype = this.loctype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsztype = this.tpsztype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfixMonth = this.perfixMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monthlyCount = this.monthlyCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfixWeekly = this.perfixWeekly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endYear = this.endYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.titleWeekly = this.titleWeekly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchword = this.searchword .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxWeekly = this.maxWeekly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.row = this.row .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stMonth = this.stMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company = this.company .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endMonth = this.endMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.leaseterm = this.leaseterm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
