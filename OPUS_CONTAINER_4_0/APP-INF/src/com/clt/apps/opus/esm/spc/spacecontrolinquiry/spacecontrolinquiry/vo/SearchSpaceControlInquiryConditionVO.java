/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSpaceControlInquiryConditionVO.java
*@FileTitle : SearchSpaceControlInquiryConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.12 한상훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

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
 * @author 한상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceControlInquiryConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceControlInquiryConditionVO> models = new ArrayList<SearchSpaceControlInquiryConditionVO>();
	
	/* Column Info */
	private String subtrade3 = null;
	/* Column Info */
	private String subtrade2 = null;
	/* Column Info */
	private String subtrade1 = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String salesOffice = null;
	/* Column Info */
	private String chkview = null;
	/* Column Info */
	private String week1 = null;
	private String week2 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String duration = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String area = null;
	/* Column Info */
	private String year1 = null;
	private String year2 = null;
	/* Column Info */
	private String bound = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String rhq2 = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String month = null;
	/* Column Info */
	private String week = null;
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String vvd = null;
	
	private String userOfc = null;
	private String subTrade = null;
	private String oncIpc = null;
	private String onlyVvd = null;
	private String rhqTxt = null;
	
	private String rhqGso = null;
	
	private String polPod = null;

	private String vslCd = null;
	private String skdVoyNo = null;
	private String skdDirCd = null;
	
	private String sDate = null;
	private String eDate = null;
	private String port = null;
	private String ioc = null;
	private String org = null;

	private String subOffice = null ;
	private String ofcCd = null ;
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpaceControlInquiryConditionVO() {}

	public SearchSpaceControlInquiryConditionVO(String sDate,String eDate,String port,String ioc,String org,String vslCd,String skdVoyNo,String skdDirCd,String polPod,String rhqGso,String rhqTxt,String onlyVvd,String oncIpc,String subTrade,String userOfc,String ibflag,String pagerows,String year1,String year2,String week1,String week2,String duration,String trade,String bound,String rhq,String rhq2,String area,String salesOffice,String polCd,String subtrade1,String subtrade2,String subtrade3,String chkview,String type,String month,String week,String office,String lane,String vvd, String ofcCd) {
		
		this.sDate = sDate;
		this.eDate = eDate;
		this.port = port;
		this.ioc = ioc;
		this.org = org;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.vslCd = vslCd;
		this.polPod = polPod;
		this.rhqGso = rhqGso;
		this.rhqTxt = rhqTxt;
		this.userOfc = userOfc;
		this.subTrade = subTrade;
		this.oncIpc = oncIpc;
		this.onlyVvd = onlyVvd;
		this.subtrade3 = subtrade3;
		this.subtrade2 = subtrade2;
		this.subtrade1 = subtrade1;
		this.trade = trade;
		this.salesOffice = salesOffice;
		this.chkview = chkview;
		this.week1 = week1;
		this.week2 = week2;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.duration = duration;
		this.polCd = polCd;
		this.area = area;
		this.year1 = year1;
		this.year2 = year2;
		this.bound = bound;
		this.rhq = rhq;
		this.rhq2 = rhq2;
		this.type = type;
		this.month = month;
		this.week = week;
		this.office = office;
		this.lane = lane;
		this.vvd = vvd;
		this.subOffice = subOffice;
		this.ofcCd =ofcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		
		this.hashColumns.put("sDate", getSDate());
		this.hashColumns.put("eDate", getEDate());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("ioc", getIoc());
		this.hashColumns.put("org", getOrg());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pol_pod", getPolPod());
		this.hashColumns.put("rhq_gso", getRhqGso());
		this.hashColumns.put("rhq_txt", getRhqTxt());
		this.hashColumns.put("user_ofc", getUserOfc());
		this.hashColumns.put("subtrade", getSubTrade());
		this.hashColumns.put("onc_ipc", getOncIpc());
		this.hashColumns.put("only_vvd", getOnlyVvd());
		this.hashColumns.put("subtrade3", getSubtrade3());
		this.hashColumns.put("subtrade2", getSubtrade2());
		this.hashColumns.put("subtrade1", getSubtrade1());
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("sales_office", getSalesOffice());
		this.hashColumns.put("chkview", getChkview());
		if(getWeek1().equals("")){
			this.hashColumns.put("week", getWeek());
		}
		else{
			this.hashColumns.put("week", getWeek1());
		}		
		this.hashColumns.put("week2", getWeek2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("duration", getDuration());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("area", getArea());
		this.hashColumns.put("year", getYear1());
		this.hashColumns.put("year2", getYear2());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("rhq2", getRhq2());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("month", getMonth());
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("sub_office", getSubOffice());
		this.hashColumns.put("ofc_cd", getOfcCd());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		
		this.hashFields.put("sDate", "sDate");
		this.hashFields.put("eDate", "eDate");
		this.hashFields.put("port", "port");
		this.hashFields.put("ioc", "ioc");
		this.hashFields.put("org", "org");
		this.hashFields.put("subtrade3", "subtrade3");
		this.hashFields.put("subtrade2", "subtrade2");
		this.hashFields.put("subtrade1", "subtrade1");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("sales_office", "salesOffice");
		this.hashFields.put("chkview", "chkview");
		this.hashFields.put("week", "week");
		this.hashFields.put("week2", "week2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("duration", "duration");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("area", "area");
		this.hashFields.put("year", "year");
		this.hashFields.put("year2", "year2");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("rhq2", "rhq2");
		this.hashFields.put("type", "type");
		this.hashFields.put("month", "month");
		this.hashFields.put("office", "office");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("sub_offcie", "sub_offcie");
		this.hashFields.put("ofc_cd", "ofcCd");
		return this.hashFields;
	}
	
	
	
	public String getSubOffice() {
		return subOffice;
	}

	public void setSubOffice(String subOffice) {
		this.subOffice = subOffice;
	}
	
	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @return subtrade3
	 */
	public String getSubtrade3() {
		return this.subtrade3;
	}

	/**
	 * Column Info
	 * @return subtrade2
	 */
	public String getSubtrade2() {
		return this.subtrade2;
	}
	
	/**
	 * Column Info
	 * @return subtrade1
	 */
	public String getSubtrade1() {
		return this.subtrade1;
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
	 * @return salesOffice
	 */
	public String getSalesOffice() {
		return this.salesOffice;
	}
	
	/**
	 * Column Info
	 * @return chkview
	 */
	public String getChkview() {
		return this.chkview;
	}
	
	/**
	 * Column Info
	 * @return week1
	 */
	public String getWeek1() {
		return this.week1;
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
	 * @return duration
	 */
	public String getDuration() {
		return this.duration;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return area
	 */
	public String getArea() {
		return this.area;
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
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	

	public String getRhq2() {
		return rhq2;
	}

	public void setRhq2(String rhq2) {
		this.rhq2 = rhq2;
	}
	
	/**
	 * Column Info
	 * @param subtrade3
	 */
	public void setSubtrade3(String subtrade3) {
		this.subtrade3 = subtrade3;
	}

	/**
	 * Column Info
	 * @param subtrade2
	 */
	public void setSubtrade2(String subtrade2) {
		this.subtrade2 = subtrade2;
	}
	
	/**
	 * Column Info
	 * @param subtrade1
	 */
	public void setSubtrade1(String subtrade1) {
		this.subtrade1 = subtrade1;
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
	 * @param salesOffice
	 */
	public void setSalesOffice(String salesOffice) {
		this.salesOffice = salesOffice;
	}
	
	/**
	 * Column Info
	 * @param chkview
	 */
	public void setChkview(String chkview) {
		this.chkview = chkview;
	}
	
	/**
	 * Column Info
	 * @param week1
	 */
	public void setWeek1(String week1) {
		this.week1 = week1;
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
	 * @param duration
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param area
	 */
	public void setArea(String area) {
		this.area = area;
	}
	
	/**
	 * Column Info
	 * @param year1
	 */
	public void setYear1(String year1) {
		this.year1 = year1;
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
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	public String getWeek2() {
		return week2;
	}

	public void setWeek2(String week2) {
		this.week2 = week2;
	}

	public String getYear2() {
		return year2;
	}

	public void setYear2(String year2) {
		this.year2 = year2;
	}

	public String getUserOfc() {
		return userOfc;
	}

	public void setUserOfc(String userOfc) {
		this.userOfc = userOfc;
	}

	public String getSubTrade() {
		return subTrade;
	}

	public void setSubTrade(String subTrade) {
		this.subTrade = subTrade;
	}

	public String getOncIpc() {
		return oncIpc;
	}

	public void setOncIpc(String oncIpc) {
		this.oncIpc = oncIpc;
	}

	public String getOnlyVvd() {
		return onlyVvd;
	}

	public void setOnlyVvd(String onlyVvd) {
		this.onlyVvd = onlyVvd;
	}

	public String getRhqTxt() {
		return rhqTxt;
	}

	public void setRhqTxt(String rhqTxt) {
		this.rhqTxt = rhqTxt;
	}

	public String getRhqGso() {
		return rhqGso;
	}

	public void setRhqGso(String rhqGso) {
		this.rhqGso = rhqGso;
	}

	public String getPolPod() {
		return polPod;
	}

	public void setPolPod(String polPod) {
		this.polPod = polPod;
	}

	public String getVslCd() {
		return vslCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	public String getSkdVoyNo() {
		return skdVoyNo;
	}

	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	public String getSkdDirCd() {
		return skdDirCd;
	}

	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}

	public String getSDate() {
		return sDate;
	}

	public void setSDate(String date) {
		sDate = date;
	}

	public String getEDate() {
		return eDate;
	}

	public void setEDate(String date) {
		eDate = date;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getIoc() {
		return ioc;
	}

	public void setIoc(String ioc) {
		this.ioc = ioc;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSubtrade3(JSPUtil.getParameter(request, "subtrade3", ""));
		setSubtrade2(JSPUtil.getParameter(request, "subtrade2", ""));
		setSubtrade1(JSPUtil.getParameter(request, "subtrade1", ""));
		setTrade(JSPUtil.getParameter(request, "trade", ""));
		setSalesOffice(JSPUtil.getParameter(request, "sales_office", ""));
		setChkview(JSPUtil.getParameter(request, "chkview", ""));
		setWeek1(JSPUtil.getParameter(request, "week1", ""));
		setWeek2(JSPUtil.getParameter(request, "week2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDuration(JSPUtil.getParameter(request, "duration", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setArea(JSPUtil.getParameter(request, "area", ""));
		setYear1(JSPUtil.getParameter(request, "year", ""));
		if(JSPUtil.getParameter(request, "year1", "") != "") 
			setYear1(JSPUtil.getParameter(request, "year1", ""));
		setYear2(JSPUtil.getParameter(request, "year2", ""));
		setBound(JSPUtil.getParameter(request, "bound", ""));
		setRhq(JSPUtil.getParameter(request, "rhq", ""));
		setRhq2(JSPUtil.getParameter(request, "rhq2", ""));
		setType(JSPUtil.getParameter(request, "type", ""));
		setMonth(JSPUtil.getParameter(request, "month", ""));
		setWeek(JSPUtil.getParameter(request, "week", ""));
		setOffice(JSPUtil.getParameter(request, "office", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		
		setSubTrade(JSPUtil.getParameter(request, "subtrade", ""));
		setOncIpc(JSPUtil.getParameter(request, "onc_ipc", ""));
		setOnlyVvd(JSPUtil.getParameter(request, "only_vvd", ""));
		setRhqTxt(JSPUtil.getParameter(request, "rhq_txt", ""));
		setRhqGso(JSPUtil.getParameter(request, "rhq_gso", ""));
		setPolPod(JSPUtil.getParameter(request, "pol_pod", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		
		setSDate(JSPUtil.getParameter(request, "sDate", ""));
		setEDate(JSPUtil.getParameter(request, "eDate", ""));
		setPort(JSPUtil.getParameter(request, "port", ""));
		setIoc(JSPUtil.getParameter(request, "ioc", ""));
		setOrg(JSPUtil.getParameter(request, "org", ""));
		setSubOffice(JSPUtil.getParameter(request, "sub_office", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceControlInquiryConditionVO[]
	 */
	public SearchSpaceControlInquiryConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceControlInquiryConditionVO[]
	 */
	public SearchSpaceControlInquiryConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceControlInquiryConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] subtrade3 = (JSPUtil.getParameter(request, prefix	+ "subtrade3", length));
			String[] subtrade2 = (JSPUtil.getParameter(request, prefix	+ "subtrade2", length));
			String[] subtrade1 = (JSPUtil.getParameter(request, prefix	+ "subtrade1", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] salesOffice = (JSPUtil.getParameter(request, prefix	+ "sales_office", length));
			String[] chkview = (JSPUtil.getParameter(request, prefix	+ "chkview", length));
			String[] week1 = (JSPUtil.getParameter(request, prefix	+ "week1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] duration = (JSPUtil.getParameter(request, prefix	+ "duration", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] area = (JSPUtil.getParameter(request, prefix	+ "area", length));
			String[] year1 = (JSPUtil.getParameter(request, prefix	+ "year1", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] rhq2 = (JSPUtil.getParameter(request, prefix	+ "rhq2", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] month = (JSPUtil.getParameter(request, prefix	+ "month", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] subOffice = (JSPUtil.getParameter(request, prefix	+ "sub_office", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceControlInquiryConditionVO();
				if (subtrade3[i] != null)
					model.setSubtrade3(subtrade3[i]);
				if (subtrade2[i] != null)
					model.setSubtrade2(subtrade2[i]);
				if (subtrade1[i] != null)
					model.setSubtrade1(subtrade1[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (salesOffice[i] != null)
					model.setSalesOffice(salesOffice[i]);
				if (chkview[i] != null)
					model.setChkview(chkview[i]);
				if (week1[i] != null)
					model.setWeek1(week1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (duration[i] != null)
					model.setDuration(duration[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (area[i] != null)
					model.setArea(area[i]);
				if (year1[i] != null)
					model.setYear1(year1[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (rhq2[i] != null)
					model.setRhq2(rhq2[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (month[i] != null)
					model.setMonth(month[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				if (office[i] != null)
					model.setOffice(office[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (subOffice[i] != null)
					model.setSubOffice(subOffice[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceControlInquiryConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceControlInquiryConditionVO[]
	 */
	public SearchSpaceControlInquiryConditionVO[] getSearchSpaceControlInquiryConditionVOs(){
		SearchSpaceControlInquiryConditionVO[] vos = (SearchSpaceControlInquiryConditionVO[])models.toArray(new SearchSpaceControlInquiryConditionVO[models.size()]);
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
		this.subtrade3 = this.subtrade3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subtrade2 = this.subtrade2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subtrade1 = this.subtrade1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesOffice = this.salesOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkview = this.chkview .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week1 = this.week1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week2 = this.week2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duration = this.duration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.area = this.area .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year1 = this.year1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year2 = this.year2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq2 = this.rhq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.month = this.month .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.userOfc = this.userOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrade = this.subTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oncIpc = this.oncIpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onlyVvd = this.onlyVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqTxt = this.rhqTxt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqGso = this.rhqGso .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPod = this.polPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.sDate = this.sDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eDate = this.eDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioc = this.ioc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.org = this.org .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subOffice = this.subOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
