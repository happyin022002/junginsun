/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : HangerRackReportVO.java
*@FileTitle : HangerRackReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.04
*@LastModifier : 
*@LastVersion : 1.0
* 2012.01.04  
* 1.0 Creation
--------------------------------------------------------
* History
* 2011.12.20 김상수 [CHM-201115062-01] ALPS MNR-Hanger-hanger rack and Bar History에 Report 보턴 추가 및 처리
*                                      - [UI_MNR_0257] Hanger Rack/Bar Using Report 신규 개발
* 2012.01.04 신혜정 [CHM-201215407-01] Detail EQ no 내역 팝업 조회 추가                                     
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HangerRackReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HangerRackReportVO> models = new ArrayList<HangerRackReportVO>();
	
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String mnrHngrRckNm = null;
	/* Column Info */
	private String monthNm = null;
	/* Column Info */
	private String mnrHngrTrfNm = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String pLocCd = null;
	/* Column Info */
	private String sales20ft = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String pLocTp = null;
	/* Column Info */
	private String year = null;
	/* Column Info */
	private String salesTotal = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String collectDisposal = null;
	/* Column Info */
	private String collectSound = null;
	/* Column Info */
	private String collectTotal = null;
	/* Column Info */
	private String mnrFlgYdCd = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String collectRepair = null;
	/* Column Info */
	private String yearMonth = null;
	/* Column Info */
	private String fromDate = null;
	/* Column Info */
	private String ratio = null;
	/* Column Info */
	private String installQty = null;
	/* Column Info */
	private String mnrHngrRckCd = null;
	/* Column Info */
	private String collectMissing = null;
	/* Column Info */
	private String sales40ft = null;
	/* Column Info */
	private String mnrHngrTrfCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HangerRackReportVO() {}

	public HangerRackReportVO(String ibflag, String pagerows, String userOfcCd, String monthNm, String mnrHngrRckNm, String mnrHngrTrfNm, String collectTotal, String collectSound, String location, String pLocCd, String sales20ft, String toDate, String collectRepair, String fromDate, String ratio, String installQty, String mnrHngrRckCd, String collectMissing, String pLocTp, String sales40ft, String year, String salesTotal, String mnrHngrTrfCd, String collectDisposal, String yearMonth, String eqNo, String eqTpszCd, String lstmCd, String mnrFlgYdCd) {
		this.userOfcCd = userOfcCd;
		this.mnrHngrRckNm = mnrHngrRckNm;
		this.monthNm = monthNm;
		this.mnrHngrTrfNm = mnrHngrTrfNm;
		this.location = location;
		this.pLocCd = pLocCd;
		this.sales20ft = sales20ft;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.pLocTp = pLocTp;
		this.year = year;
		this.salesTotal = salesTotal;
		this.lstmCd = lstmCd;
		this.collectDisposal = collectDisposal;
		this.collectSound = collectSound;
		this.collectTotal = collectTotal;
		this.mnrFlgYdCd = mnrFlgYdCd;
		this.toDate = toDate;
		this.eqTpszCd = eqTpszCd;
		this.collectRepair = collectRepair;
		this.yearMonth = yearMonth;
		this.fromDate = fromDate;
		this.ratio = ratio;
		this.installQty = installQty;
		this.mnrHngrRckCd = mnrHngrRckCd;
		this.collectMissing = collectMissing;
		this.sales40ft = sales40ft;
		this.mnrHngrTrfCd = mnrHngrTrfCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("mnr_hngr_rck_nm", getMnrHngrRckNm());
		this.hashColumns.put("month_nm", getMonthNm());
		this.hashColumns.put("mnr_hngr_trf_nm", getMnrHngrTrfNm());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("p_loc_cd", getPLocCd());
		this.hashColumns.put("sales_20ft", getSales20ft());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("p_loc_tp", getPLocTp());
		this.hashColumns.put("year", getYear());
		this.hashColumns.put("sales_total", getSalesTotal());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("collect_disposal", getCollectDisposal());
		this.hashColumns.put("collect_sound", getCollectSound());
		this.hashColumns.put("collect_total", getCollectTotal());
		this.hashColumns.put("mnr_flg_yd_cd", getMnrFlgYdCd());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("collect_repair", getCollectRepair());
		this.hashColumns.put("year_month", getYearMonth());
		this.hashColumns.put("from_date", getFromDate());
		this.hashColumns.put("ratio", getRatio());
		this.hashColumns.put("install_qty", getInstallQty());
		this.hashColumns.put("mnr_hngr_rck_cd", getMnrHngrRckCd());
		this.hashColumns.put("collect_missing", getCollectMissing());
		this.hashColumns.put("sales_40ft", getSales40ft());
		this.hashColumns.put("mnr_hngr_trf_cd", getMnrHngrTrfCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("mnr_hngr_rck_nm", "mnrHngrRckNm");
		this.hashFields.put("month_nm", "monthNm");
		this.hashFields.put("mnr_hngr_trf_nm", "mnrHngrTrfNm");
		this.hashFields.put("location", "location");
		this.hashFields.put("p_loc_cd", "pLocCd");
		this.hashFields.put("sales_20ft", "sales20ft");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("p_loc_tp", "pLocTp");
		this.hashFields.put("year", "year");
		this.hashFields.put("sales_total", "salesTotal");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("collect_disposal", "collectDisposal");
		this.hashFields.put("collect_sound", "collectSound");
		this.hashFields.put("collect_total", "collectTotal");
		this.hashFields.put("mnr_flg_yd_cd", "mnrFlgYdCd");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("collect_repair", "collectRepair");
		this.hashFields.put("year_month", "yearMonth");
		this.hashFields.put("from_date", "fromDate");
		this.hashFields.put("ratio", "ratio");
		this.hashFields.put("install_qty", "installQty");
		this.hashFields.put("mnr_hngr_rck_cd", "mnrHngrRckCd");
		this.hashFields.put("collect_missing", "collectMissing");
		this.hashFields.put("sales_40ft", "sales40ft");
		this.hashFields.put("mnr_hngr_trf_cd", "mnrHngrTrfCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return userOfcCd
	 */
	public String getUserOfcCd() {
		return this.userOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mnrHngrRckNm
	 */
	public String getMnrHngrRckNm() {
		return this.mnrHngrRckNm;
	}
	
	/**
	 * Column Info
	 * @return monthNm
	 */
	public String getMonthNm() {
		return this.monthNm;
	}
	
	/**
	 * Column Info
	 * @return mnrHngrTrfNm
	 */
	public String getMnrHngrTrfNm() {
		return this.mnrHngrTrfNm;
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
	 * @return pLocCd
	 */
	public String getPLocCd() {
		return this.pLocCd;
	}
	
	/**
	 * Column Info
	 * @return sales20ft
	 */
	public String getSales20ft() {
		return this.sales20ft;
	}
	
	/**
	 * Column Info
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return pLocTp
	 */
	public String getPLocTp() {
		return this.pLocTp;
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
	 * @return salesTotal
	 */
	public String getSalesTotal() {
		return this.salesTotal;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return collectDisposal
	 */
	public String getCollectDisposal() {
		return this.collectDisposal;
	}
	
	/**
	 * Column Info
	 * @return collectSound
	 */
	public String getCollectSound() {
		return this.collectSound;
	}
	
	/**
	 * Column Info
	 * @return collectTotal
	 */
	public String getCollectTotal() {
		return this.collectTotal;
	}
	
	/**
	 * Column Info
	 * @return mnrFlgYdCd
	 */
	public String getMnrFlgYdCd() {
		return this.mnrFlgYdCd;
	}
	
	/**
	 * Column Info
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return collectRepair
	 */
	public String getCollectRepair() {
		return this.collectRepair;
	}
	
	/**
	 * Column Info
	 * @return yearMonth
	 */
	public String getYearMonth() {
		return this.yearMonth;
	}
	
	/**
	 * Column Info
	 * @return fromDate
	 */
	public String getFromDate() {
		return this.fromDate;
	}
	
	/**
	 * Column Info
	 * @return ratio
	 */
	public String getRatio() {
		return this.ratio;
	}
	
	/**
	 * Column Info
	 * @return installQty
	 */
	public String getInstallQty() {
		return this.installQty;
	}
	
	/**
	 * Column Info
	 * @return mnrHngrRckCd
	 */
	public String getMnrHngrRckCd() {
		return this.mnrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @return collectMissing
	 */
	public String getCollectMissing() {
		return this.collectMissing;
	}
	
	/**
	 * Column Info
	 * @return sales40ft
	 */
	public String getSales40ft() {
		return this.sales40ft;
	}
	
	/**
	 * Column Info
	 * @return mnrHngrTrfCd
	 */
	public String getMnrHngrTrfCd() {
		return this.mnrHngrTrfCd;
	}
	

	/**
	 * Column Info
	 * @param userOfcCd
	 */
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mnrHngrRckNm
	 */
	public void setMnrHngrRckNm(String mnrHngrRckNm) {
		this.mnrHngrRckNm = mnrHngrRckNm;
	}
	
	/**
	 * Column Info
	 * @param monthNm
	 */
	public void setMonthNm(String monthNm) {
		this.monthNm = monthNm;
	}
	
	/**
	 * Column Info
	 * @param mnrHngrTrfNm
	 */
	public void setMnrHngrTrfNm(String mnrHngrTrfNm) {
		this.mnrHngrTrfNm = mnrHngrTrfNm;
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
	 * @param pLocCd
	 */
	public void setPLocCd(String pLocCd) {
		this.pLocCd = pLocCd;
	}
	
	/**
	 * Column Info
	 * @param sales20ft
	 */
	public void setSales20ft(String sales20ft) {
		this.sales20ft = sales20ft;
	}
	
	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param pLocTp
	 */
	public void setPLocTp(String pLocTp) {
		this.pLocTp = pLocTp;
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
	 * @param salesTotal
	 */
	public void setSalesTotal(String salesTotal) {
		this.salesTotal = salesTotal;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param collectDisposal
	 */
	public void setCollectDisposal(String collectDisposal) {
		this.collectDisposal = collectDisposal;
	}
	
	/**
	 * Column Info
	 * @param collectSound
	 */
	public void setCollectSound(String collectSound) {
		this.collectSound = collectSound;
	}
	
	/**
	 * Column Info
	 * @param collectTotal
	 */
	public void setCollectTotal(String collectTotal) {
		this.collectTotal = collectTotal;
	}
	
	/**
	 * Column Info
	 * @param mnrFlgYdCd
	 */
	public void setMnrFlgYdCd(String mnrFlgYdCd) {
		this.mnrFlgYdCd = mnrFlgYdCd;
	}
	
	/**
	 * Column Info
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param collectRepair
	 */
	public void setCollectRepair(String collectRepair) {
		this.collectRepair = collectRepair;
	}
	
	/**
	 * Column Info
	 * @param yearMonth
	 */
	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}
	
	/**
	 * Column Info
	 * @param fromDate
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	/**
	 * Column Info
	 * @param ratio
	 */
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	
	/**
	 * Column Info
	 * @param installQty
	 */
	public void setInstallQty(String installQty) {
		this.installQty = installQty;
	}
	
	/**
	 * Column Info
	 * @param mnrHngrRckCd
	 */
	public void setMnrHngrRckCd(String mnrHngrRckCd) {
		this.mnrHngrRckCd = mnrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @param collectMissing
	 */
	public void setCollectMissing(String collectMissing) {
		this.collectMissing = collectMissing;
	}
	
	/**
	 * Column Info
	 * @param sales40ft
	 */
	public void setSales40ft(String sales40ft) {
		this.sales40ft = sales40ft;
	}
	
	/**
	 * Column Info
	 * @param mnrHngrTrfCd
	 */
	public void setMnrHngrTrfCd(String mnrHngrTrfCd) {
		this.mnrHngrTrfCd = mnrHngrTrfCd;
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
		setUserOfcCd(JSPUtil.getParameter(request, prefix + "user_ofc_cd", ""));
		setMnrHngrRckNm(JSPUtil.getParameter(request, prefix + "mnr_hngr_rck_nm", ""));
		setMonthNm(JSPUtil.getParameter(request, prefix + "month_nm", ""));
		setMnrHngrTrfNm(JSPUtil.getParameter(request, prefix + "mnr_hngr_trf_nm", ""));
		setLocation(JSPUtil.getParameter(request, prefix + "location", ""));
		setPLocCd(JSPUtil.getParameter(request, prefix + "p_loc_cd", ""));
		setSales20ft(JSPUtil.getParameter(request, prefix + "sales_20ft", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setPLocTp(JSPUtil.getParameter(request, prefix + "p_loc_tp", ""));
		setYear(JSPUtil.getParameter(request, prefix + "year", ""));
		setSalesTotal(JSPUtil.getParameter(request, prefix + "sales_total", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setCollectDisposal(JSPUtil.getParameter(request, prefix + "collect_disposal", ""));
		setCollectSound(JSPUtil.getParameter(request, prefix + "collect_sound", ""));
		setCollectTotal(JSPUtil.getParameter(request, prefix + "collect_total", ""));
		setMnrFlgYdCd(JSPUtil.getParameter(request, prefix + "mnr_flg_yd_cd", ""));
		setToDate(JSPUtil.getParameter(request, prefix + "to_date", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setCollectRepair(JSPUtil.getParameter(request, prefix + "collect_repair", ""));
		setYearMonth(JSPUtil.getParameter(request, prefix + "year_month", ""));
		setFromDate(JSPUtil.getParameter(request, prefix + "from_date", ""));
		setRatio(JSPUtil.getParameter(request, prefix + "ratio", ""));
		setInstallQty(JSPUtil.getParameter(request, prefix + "install_qty", ""));
		setMnrHngrRckCd(JSPUtil.getParameter(request, prefix + "mnr_hngr_rck_cd", ""));
		setCollectMissing(JSPUtil.getParameter(request, prefix + "collect_missing", ""));
		setSales40ft(JSPUtil.getParameter(request, prefix + "sales_40ft", ""));
		setMnrHngrTrfCd(JSPUtil.getParameter(request, prefix + "mnr_hngr_trf_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HangerRackReportVO[]
	 */
	public HangerRackReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HangerRackReportVO[]
	 */
	public HangerRackReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HangerRackReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] mnrHngrRckNm = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_rck_nm", length));
			String[] monthNm = (JSPUtil.getParameter(request, prefix	+ "month_nm", length));
			String[] mnrHngrTrfNm = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_trf_nm", length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] pLocCd = (JSPUtil.getParameter(request, prefix	+ "p_loc_cd", length));
			String[] sales20ft = (JSPUtil.getParameter(request, prefix	+ "sales_20ft", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] pLocTp = (JSPUtil.getParameter(request, prefix	+ "p_loc_tp", length));
			String[] year = (JSPUtil.getParameter(request, prefix	+ "year", length));
			String[] salesTotal = (JSPUtil.getParameter(request, prefix	+ "sales_total", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] collectDisposal = (JSPUtil.getParameter(request, prefix	+ "collect_disposal", length));
			String[] collectSound = (JSPUtil.getParameter(request, prefix	+ "collect_sound", length));
			String[] collectTotal = (JSPUtil.getParameter(request, prefix	+ "collect_total", length));
			String[] mnrFlgYdCd = (JSPUtil.getParameter(request, prefix	+ "mnr_flg_yd_cd", length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] collectRepair = (JSPUtil.getParameter(request, prefix	+ "collect_repair", length));
			String[] yearMonth = (JSPUtil.getParameter(request, prefix	+ "year_month", length));
			String[] fromDate = (JSPUtil.getParameter(request, prefix	+ "from_date", length));
			String[] ratio = (JSPUtil.getParameter(request, prefix	+ "ratio", length));
			String[] installQty = (JSPUtil.getParameter(request, prefix	+ "install_qty", length));
			String[] mnrHngrRckCd = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_rck_cd", length));
			String[] collectMissing = (JSPUtil.getParameter(request, prefix	+ "collect_missing", length));
			String[] sales40ft = (JSPUtil.getParameter(request, prefix	+ "sales_40ft", length));
			String[] mnrHngrTrfCd = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_trf_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new HangerRackReportVO();
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (mnrHngrRckNm[i] != null)
					model.setMnrHngrRckNm(mnrHngrRckNm[i]);
				if (monthNm[i] != null)
					model.setMonthNm(monthNm[i]);
				if (mnrHngrTrfNm[i] != null)
					model.setMnrHngrTrfNm(mnrHngrTrfNm[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (pLocCd[i] != null)
					model.setPLocCd(pLocCd[i]);
				if (sales20ft[i] != null)
					model.setSales20ft(sales20ft[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (pLocTp[i] != null)
					model.setPLocTp(pLocTp[i]);
				if (year[i] != null)
					model.setYear(year[i]);
				if (salesTotal[i] != null)
					model.setSalesTotal(salesTotal[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (collectDisposal[i] != null)
					model.setCollectDisposal(collectDisposal[i]);
				if (collectSound[i] != null)
					model.setCollectSound(collectSound[i]);
				if (collectTotal[i] != null)
					model.setCollectTotal(collectTotal[i]);
				if (mnrFlgYdCd[i] != null)
					model.setMnrFlgYdCd(mnrFlgYdCd[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (collectRepair[i] != null)
					model.setCollectRepair(collectRepair[i]);
				if (yearMonth[i] != null)
					model.setYearMonth(yearMonth[i]);
				if (fromDate[i] != null)
					model.setFromDate(fromDate[i]);
				if (ratio[i] != null)
					model.setRatio(ratio[i]);
				if (installQty[i] != null)
					model.setInstallQty(installQty[i]);
				if (mnrHngrRckCd[i] != null)
					model.setMnrHngrRckCd(mnrHngrRckCd[i]);
				if (collectMissing[i] != null)
					model.setCollectMissing(collectMissing[i]);
				if (sales40ft[i] != null)
					model.setSales40ft(sales40ft[i]);
				if (mnrHngrTrfCd[i] != null)
					model.setMnrHngrTrfCd(mnrHngrTrfCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHangerRackReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HangerRackReportVO[]
	 */
	public HangerRackReportVO[] getHangerRackReportVOs(){
		HangerRackReportVO[] vos = (HangerRackReportVO[])models.toArray(new HangerRackReportVO[models.size()]);
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
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrRckNm = this.mnrHngrRckNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monthNm = this.monthNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrTrfNm = this.mnrHngrTrfNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pLocCd = this.pLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sales20ft = this.sales20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pLocTp = this.pLocTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year = this.year .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesTotal = this.salesTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.collectDisposal = this.collectDisposal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.collectSound = this.collectSound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.collectTotal = this.collectTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrFlgYdCd = this.mnrFlgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.collectRepair = this.collectRepair .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yearMonth = this.yearMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDate = this.fromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratio = this.ratio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.installQty = this.installQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrRckCd = this.mnrHngrRckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.collectMissing = this.collectMissing .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sales40ft = this.sales40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrTrfCd = this.mnrHngrTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
