/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SalesProjectionHistVO.java
*@FileTitle : SalesProjectionHistVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class SalesProjectionHistVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SalesProjectionHistVO> models = new ArrayList<SalesProjectionHistVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String pfmcD4FcastQty = null;
	/* Column Info */
	private String fcstD5FcastQty = null;
	/* Column Info */
	private String d7FcastQty = null;
	/* Column Info */
	private String d5FcastQty = null;
	/* Column Info */
	private String locTpCdSecond = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fcstD7FcastQty = null;
	/* Column Info */
	private String df1D2 = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fcstD4FcastQty = null;
	/* Column Info */
	private String df1D4 = null;
	/* Column Info */
	private String toWeek = null;
	/* Column Info */
	private String pfmcD7FcastQty = null;
	/* Column Info */
	private String df2D7 = null;
	/* Column Info */
	private String df1Total = null;
	/* Column Info */
	private String df2Total = null;
	/* Column Info */
	private String df2D5 = null;
	/* Column Info */
	private String df2D4 = null;
	/* Column Info */
	private String locCdSecond = null;
	/* Column Info */
	private String d2FcastQty = null;
	/* Column Info */
	private String fmWeek = null;
	/* Column Info */
	private String pfmcD5FcastQty = null;
	/* Column Info */
	private String df2D2 = null;
	/* Column Info */
	private String pfmcD2FcastQty = null;
	/* Column Info */
	private String fcstTotal = null;
	/* Column Info */
	private String pfmcTotal = null;
	/* Column Info */
	private String df1D7 = null;
	/* Column Info */
	private String df1D5 = null;
	/* Column Info */
	private String divFlag = null;
	/* Column Info */
	private String d4FcastQty = null;
	/* Column Info */
	private String fcstD2FcastQty = null;
	/* Column Info */
	private String locTpCd = null;
	/* Column Info */
	private String week = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SalesProjectionHistVO() {}

	public SalesProjectionHistVO(String ibflag, String pagerows, String locCd, String week, String total, String d2FcastQty, String d4FcastQty, String d5FcastQty, String d7FcastQty, String fcstTotal, String fcstD2FcastQty, String fcstD4FcastQty, String fcstD5FcastQty, String fcstD7FcastQty, String df1Total, String df1D2, String df1D4, String df1D5, String df1D7, String pfmcTotal, String pfmcD2FcastQty, String pfmcD4FcastQty, String pfmcD5FcastQty, String pfmcD7FcastQty, String df2Total, String df2D2, String df2D4, String df2D5, String df2D7, String divFlag, String locTpCd, String locTpCdSecond, String locCdSecond, String fmWeek, String toWeek) {
		this.total = total;
		this.pfmcD4FcastQty = pfmcD4FcastQty;
		this.fcstD5FcastQty = fcstD5FcastQty;
		this.d7FcastQty = d7FcastQty;
		this.d5FcastQty = d5FcastQty;
		this.locTpCdSecond = locTpCdSecond;
		this.pagerows = pagerows;
		this.fcstD7FcastQty = fcstD7FcastQty;
		this.df1D2 = df1D2;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.fcstD4FcastQty = fcstD4FcastQty;
		this.df1D4 = df1D4;
		this.toWeek = toWeek;
		this.pfmcD7FcastQty = pfmcD7FcastQty;
		this.df2D7 = df2D7;
		this.df1Total = df1Total;
		this.df2Total = df2Total;
		this.df2D5 = df2D5;
		this.df2D4 = df2D4;
		this.locCdSecond = locCdSecond;
		this.d2FcastQty = d2FcastQty;
		this.fmWeek = fmWeek;
		this.pfmcD5FcastQty = pfmcD5FcastQty;
		this.df2D2 = df2D2;
		this.pfmcD2FcastQty = pfmcD2FcastQty;
		this.fcstTotal = fcstTotal;
		this.pfmcTotal = pfmcTotal;
		this.df1D7 = df1D7;
		this.df1D5 = df1D5;
		this.divFlag = divFlag;
		this.d4FcastQty = d4FcastQty;
		this.fcstD2FcastQty = fcstD2FcastQty;
		this.locTpCd = locTpCd;
		this.week = week;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("pfmc_d4_fcast_qty", getPfmcD4FcastQty());
		this.hashColumns.put("fcst_d5_fcast_qty", getFcstD5FcastQty());
		this.hashColumns.put("d7_fcast_qty", getD7FcastQty());
		this.hashColumns.put("d5_fcast_qty", getD5FcastQty());
		this.hashColumns.put("loc_tp_cd_second", getLocTpCdSecond());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fcst_d7_fcast_qty", getFcstD7FcastQty());
		this.hashColumns.put("df1_d2", getDf1D2());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fcst_d4_fcast_qty", getFcstD4FcastQty());
		this.hashColumns.put("df1_d4", getDf1D4());
		this.hashColumns.put("to_week", getToWeek());
		this.hashColumns.put("pfmc_d7_fcast_qty", getPfmcD7FcastQty());
		this.hashColumns.put("df2_d7", getDf2D7());
		this.hashColumns.put("df1_total", getDf1Total());
		this.hashColumns.put("df2_total", getDf2Total());
		this.hashColumns.put("df2_d5", getDf2D5());
		this.hashColumns.put("df2_d4", getDf2D4());
		this.hashColumns.put("loc_cd_second", getLocCdSecond());
		this.hashColumns.put("d2_fcast_qty", getD2FcastQty());
		this.hashColumns.put("fm_week", getFmWeek());
		this.hashColumns.put("pfmc_d5_fcast_qty", getPfmcD5FcastQty());
		this.hashColumns.put("df2_d2", getDf2D2());
		this.hashColumns.put("pfmc_d2_fcast_qty", getPfmcD2FcastQty());
		this.hashColumns.put("fcst_total", getFcstTotal());
		this.hashColumns.put("pfmc_total", getPfmcTotal());
		this.hashColumns.put("df1_d7", getDf1D7());
		this.hashColumns.put("df1_d5", getDf1D5());
		this.hashColumns.put("div_flag", getDivFlag());
		this.hashColumns.put("d4_fcast_qty", getD4FcastQty());
		this.hashColumns.put("fcst_d2_fcast_qty", getFcstD2FcastQty());
		this.hashColumns.put("loc_tp_cd", getLocTpCd());
		this.hashColumns.put("week", getWeek());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("pfmc_d4_fcast_qty", "pfmcD4FcastQty");
		this.hashFields.put("fcst_d5_fcast_qty", "fcstD5FcastQty");
		this.hashFields.put("d7_fcast_qty", "d7FcastQty");
		this.hashFields.put("d5_fcast_qty", "d5FcastQty");
		this.hashFields.put("loc_tp_cd_second", "locTpCdSecond");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fcst_d7_fcast_qty", "fcstD7FcastQty");
		this.hashFields.put("df1_d2", "df1D2");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fcst_d4_fcast_qty", "fcstD4FcastQty");
		this.hashFields.put("df1_d4", "df1D4");
		this.hashFields.put("to_week", "toWeek");
		this.hashFields.put("pfmc_d7_fcast_qty", "pfmcD7FcastQty");
		this.hashFields.put("df2_d7", "df2D7");
		this.hashFields.put("df1_total", "df1Total");
		this.hashFields.put("df2_total", "df2Total");
		this.hashFields.put("df2_d5", "df2D5");
		this.hashFields.put("df2_d4", "df2D4");
		this.hashFields.put("loc_cd_second", "locCdSecond");
		this.hashFields.put("d2_fcast_qty", "d2FcastQty");
		this.hashFields.put("fm_week", "fmWeek");
		this.hashFields.put("pfmc_d5_fcast_qty", "pfmcD5FcastQty");
		this.hashFields.put("df2_d2", "df2D2");
		this.hashFields.put("pfmc_d2_fcast_qty", "pfmcD2FcastQty");
		this.hashFields.put("fcst_total", "fcstTotal");
		this.hashFields.put("pfmc_total", "pfmcTotal");
		this.hashFields.put("df1_d7", "df1D7");
		this.hashFields.put("df1_d5", "df1D5");
		this.hashFields.put("div_flag", "divFlag");
		this.hashFields.put("d4_fcast_qty", "d4FcastQty");
		this.hashFields.put("fcst_d2_fcast_qty", "fcstD2FcastQty");
		this.hashFields.put("loc_tp_cd", "locTpCd");
		this.hashFields.put("week", "week");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Column Info
	 * @return pfmcD4FcastQty
	 */
	public String getPfmcD4FcastQty() {
		return this.pfmcD4FcastQty;
	}
	
	/**
	 * Column Info
	 * @return fcstD5FcastQty
	 */
	public String getFcstD5FcastQty() {
		return this.fcstD5FcastQty;
	}
	
	/**
	 * Column Info
	 * @return d7FcastQty
	 */
	public String getD7FcastQty() {
		return this.d7FcastQty;
	}
	
	/**
	 * Column Info
	 * @return d5FcastQty
	 */
	public String getD5FcastQty() {
		return this.d5FcastQty;
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
	 * @return fcstD7FcastQty
	 */
	public String getFcstD7FcastQty() {
		return this.fcstD7FcastQty;
	}
	
	/**
	 * Column Info
	 * @return df1D2
	 */
	public String getDf1D2() {
		return this.df1D2;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return fcstD4FcastQty
	 */
	public String getFcstD4FcastQty() {
		return this.fcstD4FcastQty;
	}
	
	/**
	 * Column Info
	 * @return df1D4
	 */
	public String getDf1D4() {
		return this.df1D4;
	}
	
	/**
	 * Column Info
	 * @return toWeek
	 */
	public String getToWeek() {
		return this.toWeek;
	}
	
	/**
	 * Column Info
	 * @return pfmcD7FcastQty
	 */
	public String getPfmcD7FcastQty() {
		return this.pfmcD7FcastQty;
	}
	
	/**
	 * Column Info
	 * @return df2D7
	 */
	public String getDf2D7() {
		return this.df2D7;
	}
	
	/**
	 * Column Info
	 * @return df1Total
	 */
	public String getDf1Total() {
		return this.df1Total;
	}
	
	/**
	 * Column Info
	 * @return df2Total
	 */
	public String getDf2Total() {
		return this.df2Total;
	}
	
	/**
	 * Column Info
	 * @return df2D5
	 */
	public String getDf2D5() {
		return this.df2D5;
	}
	
	/**
	 * Column Info
	 * @return df2D4
	 */
	public String getDf2D4() {
		return this.df2D4;
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
	 * @return d2FcastQty
	 */
	public String getD2FcastQty() {
		return this.d2FcastQty;
	}
	
	/**
	 * Column Info
	 * @return fmWeek
	 */
	public String getFmWeek() {
		return this.fmWeek;
	}
	
	/**
	 * Column Info
	 * @return pfmcD5FcastQty
	 */
	public String getPfmcD5FcastQty() {
		return this.pfmcD5FcastQty;
	}
	
	/**
	 * Column Info
	 * @return df2D2
	 */
	public String getDf2D2() {
		return this.df2D2;
	}
	
	/**
	 * Column Info
	 * @return pfmcD2FcastQty
	 */
	public String getPfmcD2FcastQty() {
		return this.pfmcD2FcastQty;
	}
	
	/**
	 * Column Info
	 * @return fcstTotal
	 */
	public String getFcstTotal() {
		return this.fcstTotal;
	}
	
	/**
	 * Column Info
	 * @return pfmcTotal
	 */
	public String getPfmcTotal() {
		return this.pfmcTotal;
	}
	
	/**
	 * Column Info
	 * @return df1D7
	 */
	public String getDf1D7() {
		return this.df1D7;
	}
	
	/**
	 * Column Info
	 * @return df1D5
	 */
	public String getDf1D5() {
		return this.df1D5;
	}
	
	/**
	 * Column Info
	 * @return divFlag
	 */
	public String getDivFlag() {
		return this.divFlag;
	}
	
	/**
	 * Column Info
	 * @return d4FcastQty
	 */
	public String getD4FcastQty() {
		return this.d4FcastQty;
	}
	
	/**
	 * Column Info
	 * @return fcstD2FcastQty
	 */
	public String getFcstD2FcastQty() {
		return this.fcstD2FcastQty;
	}
	
	/**
	 * Column Info
	 * @return locTpCd
	 */
	public String getLocTpCd() {
		return this.locTpCd;
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
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param pfmcD4FcastQty
	 */
	public void setPfmcD4FcastQty(String pfmcD4FcastQty) {
		this.pfmcD4FcastQty = pfmcD4FcastQty;
	}
	
	/**
	 * Column Info
	 * @param fcstD5FcastQty
	 */
	public void setFcstD5FcastQty(String fcstD5FcastQty) {
		this.fcstD5FcastQty = fcstD5FcastQty;
	}
	
	/**
	 * Column Info
	 * @param d7FcastQty
	 */
	public void setD7FcastQty(String d7FcastQty) {
		this.d7FcastQty = d7FcastQty;
	}
	
	/**
	 * Column Info
	 * @param d5FcastQty
	 */
	public void setD5FcastQty(String d5FcastQty) {
		this.d5FcastQty = d5FcastQty;
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
	 * @param fcstD7FcastQty
	 */
	public void setFcstD7FcastQty(String fcstD7FcastQty) {
		this.fcstD7FcastQty = fcstD7FcastQty;
	}
	
	/**
	 * Column Info
	 * @param df1D2
	 */
	public void setDf1D2(String df1D2) {
		this.df1D2 = df1D2;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param fcstD4FcastQty
	 */
	public void setFcstD4FcastQty(String fcstD4FcastQty) {
		this.fcstD4FcastQty = fcstD4FcastQty;
	}
	
	/**
	 * Column Info
	 * @param df1D4
	 */
	public void setDf1D4(String df1D4) {
		this.df1D4 = df1D4;
	}
	
	/**
	 * Column Info
	 * @param toWeek
	 */
	public void setToWeek(String toWeek) {
		this.toWeek = toWeek;
	}
	
	/**
	 * Column Info
	 * @param pfmcD7FcastQty
	 */
	public void setPfmcD7FcastQty(String pfmcD7FcastQty) {
		this.pfmcD7FcastQty = pfmcD7FcastQty;
	}
	
	/**
	 * Column Info
	 * @param df2D7
	 */
	public void setDf2D7(String df2D7) {
		this.df2D7 = df2D7;
	}
	
	/**
	 * Column Info
	 * @param df1Total
	 */
	public void setDf1Total(String df1Total) {
		this.df1Total = df1Total;
	}
	
	/**
	 * Column Info
	 * @param df2Total
	 */
	public void setDf2Total(String df2Total) {
		this.df2Total = df2Total;
	}
	
	/**
	 * Column Info
	 * @param df2D5
	 */
	public void setDf2D5(String df2D5) {
		this.df2D5 = df2D5;
	}
	
	/**
	 * Column Info
	 * @param df2D4
	 */
	public void setDf2D4(String df2D4) {
		this.df2D4 = df2D4;
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
	 * @param d2FcastQty
	 */
	public void setD2FcastQty(String d2FcastQty) {
		this.d2FcastQty = d2FcastQty;
	}
	
	/**
	 * Column Info
	 * @param fmWeek
	 */
	public void setFmWeek(String fmWeek) {
		this.fmWeek = fmWeek;
	}
	
	/**
	 * Column Info
	 * @param pfmcD5FcastQty
	 */
	public void setPfmcD5FcastQty(String pfmcD5FcastQty) {
		this.pfmcD5FcastQty = pfmcD5FcastQty;
	}
	
	/**
	 * Column Info
	 * @param df2D2
	 */
	public void setDf2D2(String df2D2) {
		this.df2D2 = df2D2;
	}
	
	/**
	 * Column Info
	 * @param pfmcD2FcastQty
	 */
	public void setPfmcD2FcastQty(String pfmcD2FcastQty) {
		this.pfmcD2FcastQty = pfmcD2FcastQty;
	}
	
	/**
	 * Column Info
	 * @param fcstTotal
	 */
	public void setFcstTotal(String fcstTotal) {
		this.fcstTotal = fcstTotal;
	}
	
	/**
	 * Column Info
	 * @param pfmcTotal
	 */
	public void setPfmcTotal(String pfmcTotal) {
		this.pfmcTotal = pfmcTotal;
	}
	
	/**
	 * Column Info
	 * @param df1D7
	 */
	public void setDf1D7(String df1D7) {
		this.df1D7 = df1D7;
	}
	
	/**
	 * Column Info
	 * @param df1D5
	 */
	public void setDf1D5(String df1D5) {
		this.df1D5 = df1D5;
	}
	
	/**
	 * Column Info
	 * @param divFlag
	 */
	public void setDivFlag(String divFlag) {
		this.divFlag = divFlag;
	}
	
	/**
	 * Column Info
	 * @param d4FcastQty
	 */
	public void setD4FcastQty(String d4FcastQty) {
		this.d4FcastQty = d4FcastQty;
	}
	
	/**
	 * Column Info
	 * @param fcstD2FcastQty
	 */
	public void setFcstD2FcastQty(String fcstD2FcastQty) {
		this.fcstD2FcastQty = fcstD2FcastQty;
	}
	
	/**
	 * Column Info
	 * @param locTpCd
	 */
	public void setLocTpCd(String locTpCd) {
		this.locTpCd = locTpCd;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
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
		setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
		setPfmcD4FcastQty(JSPUtil.getParameter(request, prefix + "pfmc_d4_fcast_qty", ""));
		setFcstD5FcastQty(JSPUtil.getParameter(request, prefix + "fcst_d5_fcast_qty", ""));
		setD7FcastQty(JSPUtil.getParameter(request, prefix + "d7_fcast_qty", ""));
		setD5FcastQty(JSPUtil.getParameter(request, prefix + "d5_fcast_qty", ""));
		setLocTpCdSecond(JSPUtil.getParameter(request, prefix + "loc_tp_cd_second", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFcstD7FcastQty(JSPUtil.getParameter(request, prefix + "fcst_d7_fcast_qty", ""));
		setDf1D2(JSPUtil.getParameter(request, prefix + "df1_d2", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFcstD4FcastQty(JSPUtil.getParameter(request, prefix + "fcst_d4_fcast_qty", ""));
		setDf1D4(JSPUtil.getParameter(request, prefix + "df1_d4", ""));
		setToWeek(JSPUtil.getParameter(request, prefix + "to_week", ""));
		setPfmcD7FcastQty(JSPUtil.getParameter(request, prefix + "pfmc_d7_fcast_qty", ""));
		setDf2D7(JSPUtil.getParameter(request, prefix + "df2_d7", ""));
		setDf1Total(JSPUtil.getParameter(request, prefix + "df1_total", ""));
		setDf2Total(JSPUtil.getParameter(request, prefix + "df2_total", ""));
		setDf2D5(JSPUtil.getParameter(request, prefix + "df2_d5", ""));
		setDf2D4(JSPUtil.getParameter(request, prefix + "df2_d4", ""));
		setLocCdSecond(JSPUtil.getParameter(request, prefix + "loc_cd_second", ""));
		setD2FcastQty(JSPUtil.getParameter(request, prefix + "d2_fcast_qty", ""));
		setFmWeek(JSPUtil.getParameter(request, prefix + "fm_week", ""));
		setPfmcD5FcastQty(JSPUtil.getParameter(request, prefix + "pfmc_d5_fcast_qty", ""));
		setDf2D2(JSPUtil.getParameter(request, prefix + "df2_d2", ""));
		setPfmcD2FcastQty(JSPUtil.getParameter(request, prefix + "pfmc_d2_fcast_qty", ""));
		setFcstTotal(JSPUtil.getParameter(request, prefix + "fcst_total", ""));
		setPfmcTotal(JSPUtil.getParameter(request, prefix + "pfmc_total", ""));
		setDf1D7(JSPUtil.getParameter(request, prefix + "df1_d7", ""));
		setDf1D5(JSPUtil.getParameter(request, prefix + "df1_d5", ""));
		setDivFlag(JSPUtil.getParameter(request, prefix + "div_flag", ""));
		setD4FcastQty(JSPUtil.getParameter(request, prefix + "d4_fcast_qty", ""));
		setFcstD2FcastQty(JSPUtil.getParameter(request, prefix + "fcst_d2_fcast_qty", ""));
		setLocTpCd(JSPUtil.getParameter(request, prefix + "loc_tp_cd", ""));
		setWeek(JSPUtil.getParameter(request, prefix + "week", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SalesProjectionHistVO[]
	 */
	public SalesProjectionHistVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SalesProjectionHistVO[]
	 */
	public SalesProjectionHistVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SalesProjectionHistVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] pfmcD4FcastQty = (JSPUtil.getParameter(request, prefix	+ "pfmc_d4_fcast_qty", length));
			String[] fcstD5FcastQty = (JSPUtil.getParameter(request, prefix	+ "fcst_d5_fcast_qty", length));
			String[] d7FcastQty = (JSPUtil.getParameter(request, prefix	+ "d7_fcast_qty", length));
			String[] d5FcastQty = (JSPUtil.getParameter(request, prefix	+ "d5_fcast_qty", length));
			String[] locTpCdSecond = (JSPUtil.getParameter(request, prefix	+ "loc_tp_cd_second", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fcstD7FcastQty = (JSPUtil.getParameter(request, prefix	+ "fcst_d7_fcast_qty", length));
			String[] df1D2 = (JSPUtil.getParameter(request, prefix	+ "df1_d2", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fcstD4FcastQty = (JSPUtil.getParameter(request, prefix	+ "fcst_d4_fcast_qty", length));
			String[] df1D4 = (JSPUtil.getParameter(request, prefix	+ "df1_d4", length));
			String[] toWeek = (JSPUtil.getParameter(request, prefix	+ "to_week", length));
			String[] pfmcD7FcastQty = (JSPUtil.getParameter(request, prefix	+ "pfmc_d7_fcast_qty", length));
			String[] df2D7 = (JSPUtil.getParameter(request, prefix	+ "df2_d7", length));
			String[] df1Total = (JSPUtil.getParameter(request, prefix	+ "df1_total", length));
			String[] df2Total = (JSPUtil.getParameter(request, prefix	+ "df2_total", length));
			String[] df2D5 = (JSPUtil.getParameter(request, prefix	+ "df2_d5", length));
			String[] df2D4 = (JSPUtil.getParameter(request, prefix	+ "df2_d4", length));
			String[] locCdSecond = (JSPUtil.getParameter(request, prefix	+ "loc_cd_second", length));
			String[] d2FcastQty = (JSPUtil.getParameter(request, prefix	+ "d2_fcast_qty", length));
			String[] fmWeek = (JSPUtil.getParameter(request, prefix	+ "fm_week", length));
			String[] pfmcD5FcastQty = (JSPUtil.getParameter(request, prefix	+ "pfmc_d5_fcast_qty", length));
			String[] df2D2 = (JSPUtil.getParameter(request, prefix	+ "df2_d2", length));
			String[] pfmcD2FcastQty = (JSPUtil.getParameter(request, prefix	+ "pfmc_d2_fcast_qty", length));
			String[] fcstTotal = (JSPUtil.getParameter(request, prefix	+ "fcst_total", length));
			String[] pfmcTotal = (JSPUtil.getParameter(request, prefix	+ "pfmc_total", length));
			String[] df1D7 = (JSPUtil.getParameter(request, prefix	+ "df1_d7", length));
			String[] df1D5 = (JSPUtil.getParameter(request, prefix	+ "df1_d5", length));
			String[] divFlag = (JSPUtil.getParameter(request, prefix	+ "div_flag", length));
			String[] d4FcastQty = (JSPUtil.getParameter(request, prefix	+ "d4_fcast_qty", length));
			String[] fcstD2FcastQty = (JSPUtil.getParameter(request, prefix	+ "fcst_d2_fcast_qty", length));
			String[] locTpCd = (JSPUtil.getParameter(request, prefix	+ "loc_tp_cd", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			
			for (int i = 0; i < length; i++) {
				model = new SalesProjectionHistVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (pfmcD4FcastQty[i] != null)
					model.setPfmcD4FcastQty(pfmcD4FcastQty[i]);
				if (fcstD5FcastQty[i] != null)
					model.setFcstD5FcastQty(fcstD5FcastQty[i]);
				if (d7FcastQty[i] != null)
					model.setD7FcastQty(d7FcastQty[i]);
				if (d5FcastQty[i] != null)
					model.setD5FcastQty(d5FcastQty[i]);
				if (locTpCdSecond[i] != null)
					model.setLocTpCdSecond(locTpCdSecond[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fcstD7FcastQty[i] != null)
					model.setFcstD7FcastQty(fcstD7FcastQty[i]);
				if (df1D2[i] != null)
					model.setDf1D2(df1D2[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fcstD4FcastQty[i] != null)
					model.setFcstD4FcastQty(fcstD4FcastQty[i]);
				if (df1D4[i] != null)
					model.setDf1D4(df1D4[i]);
				if (toWeek[i] != null)
					model.setToWeek(toWeek[i]);
				if (pfmcD7FcastQty[i] != null)
					model.setPfmcD7FcastQty(pfmcD7FcastQty[i]);
				if (df2D7[i] != null)
					model.setDf2D7(df2D7[i]);
				if (df1Total[i] != null)
					model.setDf1Total(df1Total[i]);
				if (df2Total[i] != null)
					model.setDf2Total(df2Total[i]);
				if (df2D5[i] != null)
					model.setDf2D5(df2D5[i]);
				if (df2D4[i] != null)
					model.setDf2D4(df2D4[i]);
				if (locCdSecond[i] != null)
					model.setLocCdSecond(locCdSecond[i]);
				if (d2FcastQty[i] != null)
					model.setD2FcastQty(d2FcastQty[i]);
				if (fmWeek[i] != null)
					model.setFmWeek(fmWeek[i]);
				if (pfmcD5FcastQty[i] != null)
					model.setPfmcD5FcastQty(pfmcD5FcastQty[i]);
				if (df2D2[i] != null)
					model.setDf2D2(df2D2[i]);
				if (pfmcD2FcastQty[i] != null)
					model.setPfmcD2FcastQty(pfmcD2FcastQty[i]);
				if (fcstTotal[i] != null)
					model.setFcstTotal(fcstTotal[i]);
				if (pfmcTotal[i] != null)
					model.setPfmcTotal(pfmcTotal[i]);
				if (df1D7[i] != null)
					model.setDf1D7(df1D7[i]);
				if (df1D5[i] != null)
					model.setDf1D5(df1D5[i]);
				if (divFlag[i] != null)
					model.setDivFlag(divFlag[i]);
				if (d4FcastQty[i] != null)
					model.setD4FcastQty(d4FcastQty[i]);
				if (fcstD2FcastQty[i] != null)
					model.setFcstD2FcastQty(fcstD2FcastQty[i]);
				if (locTpCd[i] != null)
					model.setLocTpCd(locTpCd[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSalesProjectionHistVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SalesProjectionHistVO[]
	 */
	public SalesProjectionHistVO[] getSalesProjectionHistVOs(){
		SalesProjectionHistVO[] vos = (SalesProjectionHistVO[])models.toArray(new SalesProjectionHistVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcD4FcastQty = this.pfmcD4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcstD5FcastQty = this.fcstD5FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7FcastQty = this.d7FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5FcastQty = this.d5FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTpCdSecond = this.locTpCdSecond .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcstD7FcastQty = this.fcstD7FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.df1D2 = this.df1D2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcstD4FcastQty = this.fcstD4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.df1D4 = this.df1D4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toWeek = this.toWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcD7FcastQty = this.pfmcD7FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.df2D7 = this.df2D7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.df1Total = this.df1Total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.df2Total = this.df2Total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.df2D5 = this.df2D5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.df2D4 = this.df2D4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCdSecond = this.locCdSecond .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2FcastQty = this.d2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmWeek = this.fmWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcD5FcastQty = this.pfmcD5FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.df2D2 = this.df2D2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcD2FcastQty = this.pfmcD2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcstTotal = this.fcstTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTotal = this.pfmcTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.df1D7 = this.df1D7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.df1D5 = this.df1D5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divFlag = this.divFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4FcastQty = this.d4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcstD2FcastQty = this.fcstD2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTpCd = this.locTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
