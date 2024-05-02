/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchOptionByFromToVO.java
*@FileTitle : SearchOptionByFromToVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.06.24 문중철 
* 1.0 Creation
* ========================================================
* 2010.08.20 남궁진호 Ticket ID :Ticket ID : CHM-201005533-01
*            조회 조건 추가에 따른 location2 Column 추가
=========================================================*/

package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchOptionByFromToVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOptionByFromToVO> models = new ArrayList<SearchOptionByFromToVO>();
	
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String location2 = null;
	/* Column Info */
	private String froms = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fromz = null;
	/* Column Info */
	private String tos = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toz = null;
	/* Column Info */
	private String end40 = null;
	/* Column Info */
	private String end20 = null;
	/* Column Info */
	private String rdtype = null;
	/* Column Info */
	private String end60 = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String locCnty = null;
	/* Column Info */
	private String country = null;
	/* Column Info */
	private String inquirylevel = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String company = null;
	/* Column Info */
	private String end12 = null;
	/* Column Info */
	private String end30 = null;
	/* Column Info */
	private String startz = null;
	/* Column Info */
	private String directionWise = null;
	/* Column Info */
	private String end50 = null;
	/* Column Info */
	private String inquiryWise2 = null;
	/* Column Info */
	private String inquiryWise1 = null;
	/* Column Info */
	private String soc = null;
	/* Column Info */
	private String end11 = null;
	/* Column Info */
	private String weekList = null;	
	/* Column Info */
	private String tpSzLoc = null;	
	/* Column Info */
	private String fromLoc = null;	
	/* Column Info */
	private String toLoc = null;	

	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchOptionByFromToVO() {}

	public SearchOptionByFromToVO(String ibflag, String pagerows, String period, String froms, String tos, String fromz, String toz, String inquirylevel, 
			                      String tpsz, String rdtype, String directionWise, String startz, String locCnty, String location, String country, 
			                      String end11, String end12, String end20, String end30, String end40, String end50, String end60, String soc, 
			                      String company, String inquiryWise2, String inquiryWise1,	String location2, String weekList
			                      ,String tpSzLoc, String fromLoc, String toLoc
			                      ) {
		this.location = location;
		this.location2 = location2;
		this.froms = froms;
		this.pagerows = pagerows;
		this.fromz = fromz;
		this.tos = tos;
		this.ibflag = ibflag;
		this.toz = toz;
		this.end40 = end40;
		this.end20 = end20;
		this.rdtype = rdtype;
		this.end60 = end60;
		this.period = period;
		this.locCnty = locCnty;
		this.country = country;
		this.inquirylevel = inquirylevel;
		this.tpsz = tpsz;
		this.company = company;
		this.end12 = end12;
		this.end30 = end30;
		this.startz = startz;
		this.directionWise = directionWise;
		this.end50 = end50;
		this.inquiryWise2 = inquiryWise2;
		this.inquiryWise1 = inquiryWise1;
		this.soc = soc;
		this.end11 = end11;
		this.weekList = weekList;
		this.tpSzLoc = tpSzLoc;
		this.fromLoc = fromLoc;
		this.toLoc = toLoc;		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("location2", getLocation2());
		this.hashColumns.put("froms", getFroms());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fromz", getFromz());
		this.hashColumns.put("tos", getTos());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("toz", getToz());
		this.hashColumns.put("end40", getEnd40());
		this.hashColumns.put("end20", getEnd20());
		this.hashColumns.put("rdtype", getRdtype());
		this.hashColumns.put("end60", getEnd60());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("locCnty", getLocCnty());
		this.hashColumns.put("country", getCountry());
		this.hashColumns.put("inquirylevel", getInquirylevel());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("company", getCompany());
		this.hashColumns.put("end12", getEnd12());
		this.hashColumns.put("end30", getEnd30());
		this.hashColumns.put("startz", getStartz());
		this.hashColumns.put("directionWise", getDirectionWise());
		this.hashColumns.put("end50", getEnd50());
		this.hashColumns.put("inquiryWise2", getInquiryWise2());
		this.hashColumns.put("inquiryWise1", getInquiryWise1());
		this.hashColumns.put("soc", getSoc());
		this.hashColumns.put("end11", getEnd11());
		this.hashColumns.put("week_list", getWeekList());
		this.hashColumns.put("tp_sz_loc", getTpSzLoc());
		this.hashColumns.put("from_loc", getFromLoc());
		this.hashColumns.put("to_loc", getToLoc());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */ 
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("location", "location");
		this.hashFields.put("location2", "location2");
		this.hashFields.put("froms", "froms");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fromz", "fromz");
		this.hashFields.put("tos", "tos");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("toz", "toz");
		this.hashFields.put("end40", "end40");
		this.hashFields.put("end20", "end20");
		this.hashFields.put("rdtype", "rdtype");
		this.hashFields.put("end60", "end60");
		this.hashFields.put("period", "period");
		this.hashFields.put("locCnty", "locCnty");
		this.hashFields.put("country", "country");
		this.hashFields.put("inquirylevel", "inquirylevel");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("company", "company");
		this.hashFields.put("end12", "end12");
		this.hashFields.put("end30", "end30");
		this.hashFields.put("startz", "startz");
		this.hashFields.put("directionWise", "directionWise");
		this.hashFields.put("end50", "end50");
		this.hashFields.put("inquiryWise2", "inquiryWise2");
		this.hashFields.put("inquiryWise1", "inquiryWise1");
		this.hashFields.put("soc", "soc");
		this.hashFields.put("end11", "end11");
		this.hashFields.put("week_list", "weekList");
		this.hashFields.put("tp_sz_loc", "tpSzLoc");
		this.hashFields.put("from_loc", "fromLoc");
		this.hashFields.put("to_loc", "toLoc");		
		return this.hashFields;
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
	 * @return location2
	 */
	public String getLocation2() {
		return this.location2;
	}
	
	/**
	 * Column Info
	 * @return froms
	 */
	public String getFroms() {
		return this.froms;
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
	 * @return fromz
	 */
	public String getFromz() {
		return this.fromz;
	}
	
	/**
	 * Column Info
	 * @return tos
	 */
	public String getTos() {
		return this.tos;
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
	 * @return toz
	 */
	public String getToz() {
		return this.toz;
	}
	
	/**
	 * Column Info
	 * @return end40
	 */
	public String getEnd40() {
		return this.end40;
	}
	
	/**
	 * Column Info
	 * @return end20
	 */
	public String getEnd20() {
		return this.end20;
	}
	
	/**
	 * Column Info
	 * @return rdtype
	 */
	public String getRdtype() {
		return this.rdtype;
	}
	
	/**
	 * Column Info
	 * @return end60
	 */
	public String getEnd60() {
		return this.end60;
	}
	
	/**
	 * Column Info
	 * @return period
	 */
	public String getPeriod() {
		return this.period;
	}
	
	/**
	 * Column Info
	 * @return locCnty
	 */
	public String getLocCnty() {
		return this.locCnty;
	}
	
	/**
	 * Column Info
	 * @return country
	 */
	public String getCountry() {
		return this.country;
	}
	
	/**
	 * Column Info
	 * @return inquirylevel
	 */
	public String getInquirylevel() {
		return this.inquirylevel;
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
	 * @return end12
	 */
	public String getEnd12() {
		return this.end12;
	}
	
	/**
	 * Column Info
	 * @return end30
	 */
	public String getEnd30() {
		return this.end30;
	}
	
	/**
	 * Column Info
	 * @return startz
	 */
	public String getStartz() {
		return this.startz;
	}
	
	/**
	 * Column Info
	 * @return directionWise
	 */
	public String getDirectionWise() {
		return this.directionWise;
	}
	
	/**
	 * Column Info
	 * @return end50
	 */
	public String getEnd50() {
		return this.end50;
	}
	
	/**
	 * Column Info
	 * @return inquiryWise2
	 */
	public String getInquiryWise2() {
		return this.inquiryWise2;
	}
	
	/**
	 * Column Info
	 * @return inquiryWise1
	 */
	public String getInquiryWise1() {
		return this.inquiryWise1;
	}
	
	/**
	 * Column Info
	 * @return soc
	 */
	public String getSoc() {
		return this.soc;
	}
	
	/**
	 * Column Info
	 * @return end11
	 */
	public String getEnd11() {
		return this.end11;
	}
	
	/**
	 * Column Info
	 * @return weekList
	 */
	public String getWeekList() {
		return this.weekList;
	}

	/**
	 * Column Info
	 * @return tpSzLoc
	 */
	public String getTpSzLoc() {
		return this.tpSzLoc;
	}
	
	/**
	 * Column Info
	 * @return fromLoc
	 */
	public String getFromLoc() {
		return this.fromLoc;
	}
	
	/**
	 * Column Info
	 * @return toLoc
	 */
	public String getToLoc() {
		return this.toLoc;
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
	 * @param location
	 */
	public void setLocation2(String location2) {
		this.location2 = location2;
	}
	
	/**
	 * Column Info
	 * @param froms
	 */
	public void setFroms(String froms) {
		this.froms = froms;
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
	 * @param fromz
	 */
	public void setFromz(String fromz) {
		this.fromz = fromz;
	}
	
	/**
	 * Column Info
	 * @param tos
	 */
	public void setTos(String tos) {
		this.tos = tos;
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
	 * @param toz
	 */
	public void setToz(String toz) {
		this.toz = toz;
	}
	
	/**
	 * Column Info
	 * @param end40
	 */
	public void setEnd40(String end40) {
		this.end40 = end40;
	}
	
	/**
	 * Column Info
	 * @param end20
	 */
	public void setEnd20(String end20) {
		this.end20 = end20;
	}
	
	/**
	 * Column Info
	 * @param rdtype
	 */
	public void setRdtype(String rdtype) {
		this.rdtype = rdtype;
	}
	
	/**
	 * Column Info
	 * @param end60
	 */
	public void setEnd60(String end60) {
		this.end60 = end60;
	}
	
	/**
	 * Column Info
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
	}
	
	/**
	 * Column Info
	 * @param locCnty
	 */
	public void setLocCnty(String locCnty) {
		this.locCnty = locCnty;
	}
	
	/**
	 * Column Info
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * Column Info
	 * @param inquirylevel
	 */
	public void setInquirylevel(String inquirylevel) {
		this.inquirylevel = inquirylevel;
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
	 * @param end12
	 */
	public void setEnd12(String end12) {
		this.end12 = end12;
	}
	
	/**
	 * Column Info
	 * @param end30
	 */
	public void setEnd30(String end30) {
		this.end30 = end30;
	}
	
	/**
	 * Column Info
	 * @param startz
	 */
	public void setStartz(String startz) {
		this.startz = startz;
	}
	
	/**
	 * Column Info
	 * @param directionWise
	 */
	public void setDirectionWise(String directionWise) {
		this.directionWise = directionWise;
	}
	
	/**
	 * Column Info
	 * @param end50
	 */
	public void setEnd50(String end50) {
		this.end50 = end50;
	}
	
	/**
	 * Column Info
	 * @param inquiryWise2
	 */
	public void setInquiryWise2(String inquiryWise2) {
		this.inquiryWise2 = inquiryWise2;
	}
	
	/**
	 * Column Info
	 * @param inquiryWise1
	 */
	public void setInquiryWise1(String inquiryWise1) {
		this.inquiryWise1 = inquiryWise1;
	}
	
	/**
	 * Column Info
	 * @param soc
	 */
	public void setSoc(String soc) {
		this.soc = soc;
	}
	
	/**
	 * Column Info
	 * @param end11
	 */
	public void setEnd11(String end11) {
		this.end11 = end11;
	}
	
	/**
	 * Column Info
	 * @param weekList
	 */
	public void setWeekList(String weekList) {
		this.weekList = weekList;
	}

	/**
	 * Column Info
	 * @param tpSzLoc
	 */
	public void setTpSzLoc(String tpSzLoc) {
		this.tpSzLoc = tpSzLoc;
	}

	/**
	 * Column Info
	 * @param weekList
	 */
	public void setFromLoc(String fromLoc) {
		this.fromLoc = fromLoc;
	}

	/**
	 * Column Info
	 * @param toLoc
	 */
	public void setToLoc(String toLoc) {
		this.toLoc = toLoc;
	}
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLocation(JSPUtil.getParameter(request, "location", ""));
		setLocation2(JSPUtil.getParameter(request, "location2", ""));
		setFroms(JSPUtil.getParameter(request, "froms", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFromz(JSPUtil.getParameter(request, "fromz", ""));
		setTos(JSPUtil.getParameter(request, "tos", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setToz(JSPUtil.getParameter(request, "toz", ""));
		setEnd40(JSPUtil.getParameter(request, "end40", ""));
		setEnd20(JSPUtil.getParameter(request, "end20", ""));
		setRdtype(JSPUtil.getParameter(request, "rdtype", ""));
		setEnd60(JSPUtil.getParameter(request, "end60", ""));
		setPeriod(JSPUtil.getParameter(request, "period", ""));
		setLocCnty(JSPUtil.getParameter(request, "locCnty", ""));
		setCountry(JSPUtil.getParameter(request, "country", ""));
		setInquirylevel(JSPUtil.getParameter(request, "inquirylevel", ""));
		setTpsz(JSPUtil.getParameter(request, "tpsz", ""));
		setCompany(JSPUtil.getParameter(request, "company", ""));
		setEnd12(JSPUtil.getParameter(request, "end12", ""));
		setEnd30(JSPUtil.getParameter(request, "end30", ""));
		setStartz(JSPUtil.getParameter(request, "startz", ""));
		setDirectionWise(JSPUtil.getParameter(request, "directionWise", ""));
		setEnd50(JSPUtil.getParameter(request, "end50", ""));
		setInquiryWise2(JSPUtil.getParameter(request, "inquiryWise2", ""));
		setInquiryWise1(JSPUtil.getParameter(request, "inquiryWise1", ""));
		setSoc(JSPUtil.getParameter(request, "soc", ""));
		setEnd11(JSPUtil.getParameter(request, "end11", ""));
		setWeekList(JSPUtil.getParameter(request, "week_list", ""));		
		setTpSzLoc(JSPUtil.getParameter(request, "tp_sz_loc", ""));
		setFromLoc(JSPUtil.getParameter(request, "from_loc", ""));
		setToLoc(JSPUtil.getParameter(request, "to_loc", ""));				
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOptionByFromToVO[]
	 */
	public SearchOptionByFromToVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOptionByFromToVO[]
	 */
	public SearchOptionByFromToVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOptionByFromToVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] location2 = (JSPUtil.getParameter(request, prefix	+ "location2", length));
			String[] froms = (JSPUtil.getParameter(request, prefix	+ "froms", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fromz = (JSPUtil.getParameter(request, prefix	+ "fromz", length));
			String[] tos = (JSPUtil.getParameter(request, prefix	+ "tos", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toz = (JSPUtil.getParameter(request, prefix	+ "toz", length));
			String[] end40 = (JSPUtil.getParameter(request, prefix	+ "end40", length));
			String[] end20 = (JSPUtil.getParameter(request, prefix	+ "end20", length));
			String[] rdtype = (JSPUtil.getParameter(request, prefix	+ "rdtype", length));
			String[] end60 = (JSPUtil.getParameter(request, prefix	+ "end60", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] locCnty = (JSPUtil.getParameter(request, prefix	+ "locCnty", length));
			String[] country = (JSPUtil.getParameter(request, prefix	+ "country", length));
			String[] inquirylevel = (JSPUtil.getParameter(request, prefix	+ "inquirylevel", length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz", length));
			String[] company = (JSPUtil.getParameter(request, prefix	+ "company", length));
			String[] end12 = (JSPUtil.getParameter(request, prefix	+ "end12", length));
			String[] end30 = (JSPUtil.getParameter(request, prefix	+ "end30", length));
			String[] startz = (JSPUtil.getParameter(request, prefix	+ "startz", length));
			String[] directionWise = (JSPUtil.getParameter(request, prefix	+ "directionWise", length));
			String[] end50 = (JSPUtil.getParameter(request, prefix	+ "end50", length));
			String[] inquiryWise2 = (JSPUtil.getParameter(request, prefix	+ "inquiryWise2", length));
			String[] inquiryWise1 = (JSPUtil.getParameter(request, prefix	+ "inquiryWise1", length));
			String[] soc = (JSPUtil.getParameter(request, prefix	+ "soc", length));
			String[] end11 = (JSPUtil.getParameter(request, prefix	+ "end11", length));
			String[] weekList = (JSPUtil.getParameter(request, prefix	+ "week_list", length));
			String[] tpSzLoc = (JSPUtil.getParameter(request, prefix	+ "tp_sz_loc", length));
			String[] fromLoc = (JSPUtil.getParameter(request, prefix	+ "from_loc", length));
			String[] toLoc = (JSPUtil.getParameter(request, prefix	+ "to_loc", length));			
			
			for (int i = 0; i < length; i++) {
				model = new SearchOptionByFromToVO();
				if (location[i] != null)
					model.setLocation(location[i]);
				if (location2[i] != null)
					model.setLocation2(location2[i]);
				if (froms[i] != null)
					model.setFroms(froms[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fromz[i] != null)
					model.setFromz(fromz[i]);
				if (tos[i] != null)
					model.setTos(tos[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toz[i] != null)
					model.setToz(toz[i]);
				if (end40[i] != null)
					model.setEnd40(end40[i]);
				if (end20[i] != null)
					model.setEnd20(end20[i]);
				if (rdtype[i] != null)
					model.setRdtype(rdtype[i]);
				if (end60[i] != null)
					model.setEnd60(end60[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (locCnty[i] != null)
					model.setLocCnty(locCnty[i]);
				if (country[i] != null)
					model.setCountry(country[i]);
				if (inquirylevel[i] != null)
					model.setInquirylevel(inquirylevel[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (company[i] != null)
					model.setCompany(company[i]);
				if (end12[i] != null)
					model.setEnd12(end12[i]);
				if (end30[i] != null)
					model.setEnd30(end30[i]);
				if (startz[i] != null)
					model.setStartz(startz[i]);
				if (directionWise[i] != null)
					model.setDirectionWise(directionWise[i]);
				if (end50[i] != null)
					model.setEnd50(end50[i]);
				if (inquiryWise2[i] != null)
					model.setInquiryWise2(inquiryWise2[i]);
				if (inquiryWise1[i] != null)
					model.setInquiryWise1(inquiryWise1[i]);
				if (soc[i] != null)
					model.setSoc(soc[i]);
				if (end11[i] != null)
					model.setEnd11(end11[i]);
				if (weekList[i] != null)
					model.setWeekList(weekList[i]);
				if (tpSzLoc[i] != null)
					model.setTpSzLoc(tpSzLoc[i]);
				if (fromLoc[i] != null)
					model.setFromLoc(fromLoc[i]);
				if (toLoc[i] != null)
					model.setToLoc(toLoc[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOptionByFromToVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOptionByFromToVO[]
	 */
	public SearchOptionByFromToVO[] getSearchOptionByFromToVOs(){
		SearchOptionByFromToVO[] vos = (SearchOptionByFromToVO[])models.toArray(new SearchOptionByFromToVO[models.size()]);
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
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location2 = this.location2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.froms = this.froms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromz = this.fromz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tos = this.tos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toz = this.toz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.end40 = this.end40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.end20 = this.end20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdtype = this.rdtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.end60 = this.end60 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCnty = this.locCnty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.country = this.country .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inquirylevel = this.inquirylevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company = this.company .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.end12 = this.end12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.end30 = this.end30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startz = this.startz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.directionWise = this.directionWise .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.end50 = this.end50 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inquiryWise2 = this.inquiryWise2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inquiryWise1 = this.inquiryWise1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soc = this.soc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.end11 = this.end11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weekList = this.weekList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.tpSzLoc = this.tpSzLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromLoc = this.fromLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLoc = this.toLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}
