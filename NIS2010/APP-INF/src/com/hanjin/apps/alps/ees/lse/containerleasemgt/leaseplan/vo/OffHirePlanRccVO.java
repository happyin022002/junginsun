/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OffHirePlanRccVO.java
*@FileTitle : OffHirePlanRccVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.07.13 노정용 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo;

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
 * @author 노정용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OffHirePlanRccVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OffHirePlanRccVO> models = new ArrayList<OffHirePlanRccVO>();
	
	/* Column Info */
	private String offhLocCd = null;
	/* Column Info */
	private String cntr12Qty = null;
	/* Column Info */
	private String cntr3Qty = null;
	/* Column Info */
	private String cntr22Qty = null;
	/* Column Info */
	private String cntr18Qty = null;
	/* Column Info */
	private String cntr25Qty = null;
	/* Column Info */
	private String cntr9Qty = null;
	/* Column Info */
	private String cntr13Qty = null;
	/* Column Info */
	private String cntr8Qty = null;
	/* Column Info */
	private String cntr20Qty = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntr14Qty = null;
	/* Column Info */
	private String cntr26Qty = null;
	/* Column Info */
	private String cntr19Qty = null;
	/* Column Info */
	private String plnYr = null;
	/* Column Info */
	private String cntr15Qty = null;
	/* Column Info */
	private String cntr17Qty = null;
	/* Column Info */
	private String cntr2Qty = null;
	/* Column Info */
	private String offhLocTpCd = null;
	/* Column Info */
	private String cntr16Qty = null;
	/* Column Info */
	private String cntr29Qty = null;
	/* Column Info */
	private String offhRgnLocCd = null;
	/* Column Info */
	private String cntr10Qty = null;
	/* Column Info */
	private String cntr5Qty = null;
	/* Column Info */
	private String cntr4Qty = null;
	/* Column Info */
	private String cntr30Qty = null;
	/* Column Info */
	private String cntr23Qty = null;
	/* Column Info */
	private String cntr24Qty = null;
	/* Column Info */
	private String offhYrmon = null;
	/* Column Info */
	private String cntr11Qty = null;
	/* Column Info */
	private String cntr6Qty = null;
	/* Column Info */
	private String cntr1Qty = null;
	/* Column Info */
	private String cntr28Qty = null;
	/* Column Info */
	private String cntr21Qty = null;
	/* Column Info */
	private String cntr7Qty = null;
	/* Column Info */
	private String cntr27Qty = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String levelNo = null;
	/* Column Info */
	private String level = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OffHirePlanRccVO() {}

	public OffHirePlanRccVO(String ibflag, String pagerows, String plnYr, String offhRgnLocCd, String offhLocTpCd, String offhLocCd, 
			                String offhYrmon, String cntr1Qty, String cntr2Qty, String cntr3Qty, String cntr4Qty, String cntr5Qty, 
			                String cntr6Qty, String cntr7Qty, String cntr8Qty, String cntr9Qty, String cntr10Qty, String cntr11Qty, 
			                String cntr12Qty, String cntr13Qty, String cntr14Qty, String cntr15Qty, String cntr16Qty, String cntr17Qty, 
			                String cntr18Qty, String cntr19Qty, String cntr20Qty, String cntr21Qty, String cntr22Qty, String cntr23Qty, 
			                String cntr24Qty, String cntr25Qty, String cntr26Qty, String cntr27Qty, String cntr28Qty, String cntr29Qty, 
			                String cntr30Qty, String agmtNo, String levelNo, String level) {
		this.offhLocCd = offhLocCd;
		this.cntr12Qty = cntr12Qty;
		this.cntr3Qty = cntr3Qty;
		this.cntr22Qty = cntr22Qty;
		this.cntr18Qty = cntr18Qty;
		this.cntr25Qty = cntr25Qty;
		this.cntr9Qty = cntr9Qty;
		this.cntr13Qty = cntr13Qty;
		this.cntr8Qty = cntr8Qty;
		this.cntr20Qty = cntr20Qty;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cntr14Qty = cntr14Qty;
		this.cntr26Qty = cntr26Qty;
		this.cntr19Qty = cntr19Qty;
		this.plnYr = plnYr;
		this.cntr15Qty = cntr15Qty;
		this.cntr17Qty = cntr17Qty;
		this.cntr2Qty = cntr2Qty;
		this.offhLocTpCd = offhLocTpCd;
		this.cntr16Qty = cntr16Qty;
		this.cntr29Qty = cntr29Qty;
		this.offhRgnLocCd = offhRgnLocCd;
		this.cntr10Qty = cntr10Qty;
		this.cntr5Qty = cntr5Qty;
		this.cntr4Qty = cntr4Qty;
		this.cntr30Qty = cntr30Qty;
		this.cntr23Qty = cntr23Qty;
		this.cntr24Qty = cntr24Qty;
		this.offhYrmon = offhYrmon;
		this.cntr11Qty = cntr11Qty;
		this.cntr6Qty = cntr6Qty;
		this.cntr1Qty = cntr1Qty;
		this.cntr28Qty = cntr28Qty;
		this.cntr21Qty = cntr21Qty;
		this.cntr7Qty = cntr7Qty;
		this.cntr27Qty = cntr27Qty;
		this.agmtNo = agmtNo;
		this.levelNo = levelNo;
		this.level = level;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("offh_loc_cd", getOffhLocCd());
		this.hashColumns.put("cntr12_qty", getCntr12Qty());
		this.hashColumns.put("cntr3_qty", getCntr3Qty());
		this.hashColumns.put("cntr22_qty", getCntr22Qty());
		this.hashColumns.put("cntr18_qty", getCntr18Qty());
		this.hashColumns.put("cntr25_qty", getCntr25Qty());
		this.hashColumns.put("cntr9_qty", getCntr9Qty());
		this.hashColumns.put("cntr13_qty", getCntr13Qty());
		this.hashColumns.put("cntr8_qty", getCntr8Qty());
		this.hashColumns.put("cntr20_qty", getCntr20Qty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr14_qty", getCntr14Qty());
		this.hashColumns.put("cntr26_qty", getCntr26Qty());
		this.hashColumns.put("cntr19_qty", getCntr19Qty());
		this.hashColumns.put("pln_yr", getPlnYr());
		this.hashColumns.put("cntr15_qty", getCntr15Qty());
		this.hashColumns.put("cntr17_qty", getCntr17Qty());
		this.hashColumns.put("cntr2_qty", getCntr2Qty());
		this.hashColumns.put("offh_loc_tp_cd", getOffhLocTpCd());
		this.hashColumns.put("cntr16_qty", getCntr16Qty());
		this.hashColumns.put("cntr29_qty", getCntr29Qty());
		this.hashColumns.put("offh_rgn_loc_cd", getOffhRgnLocCd());
		this.hashColumns.put("cntr10_qty", getCntr10Qty());
		this.hashColumns.put("cntr5_qty", getCntr5Qty());
		this.hashColumns.put("cntr4_qty", getCntr4Qty());
		this.hashColumns.put("cntr30_qty", getCntr30Qty());
		this.hashColumns.put("cntr23_qty", getCntr23Qty());
		this.hashColumns.put("cntr24_qty", getCntr24Qty());
		this.hashColumns.put("offh_yrmon", getOffhYrmon());
		this.hashColumns.put("cntr11_qty", getCntr11Qty());
		this.hashColumns.put("cntr6_qty", getCntr6Qty());
		this.hashColumns.put("cntr1_qty", getCntr1Qty());
		this.hashColumns.put("cntr28_qty", getCntr28Qty());
		this.hashColumns.put("cntr21_qty", getCntr21Qty());
		this.hashColumns.put("cntr7_qty", getCntr7Qty());
		this.hashColumns.put("cntr27_qty", getCntr27Qty());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("level_no", getLevelNo());
		this.hashColumns.put("level", getLevel());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("offh_loc_cd", "offhLocCd");
		this.hashFields.put("cntr12_qty", "cntr12Qty");
		this.hashFields.put("cntr3_qty", "cntr3Qty");
		this.hashFields.put("cntr22_qty", "cntr22Qty");
		this.hashFields.put("cntr18_qty", "cntr18Qty");
		this.hashFields.put("cntr25_qty", "cntr25Qty");
		this.hashFields.put("cntr9_qty", "cntr9Qty");
		this.hashFields.put("cntr13_qty", "cntr13Qty");
		this.hashFields.put("cntr8_qty", "cntr8Qty");
		this.hashFields.put("cntr20_qty", "cntr20Qty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr14_qty", "cntr14Qty");
		this.hashFields.put("cntr26_qty", "cntr26Qty");
		this.hashFields.put("cntr19_qty", "cntr19Qty");
		this.hashFields.put("pln_yr", "plnYr");
		this.hashFields.put("cntr15_qty", "cntr15Qty");
		this.hashFields.put("cntr17_qty", "cntr17Qty");
		this.hashFields.put("cntr2_qty", "cntr2Qty");
		this.hashFields.put("offh_loc_tp_cd", "offhLocTpCd");
		this.hashFields.put("cntr16_qty", "cntr16Qty");
		this.hashFields.put("cntr29_qty", "cntr29Qty");
		this.hashFields.put("offh_rgn_loc_cd", "offhRgnLocCd");
		this.hashFields.put("cntr10_qty", "cntr10Qty");
		this.hashFields.put("cntr5_qty", "cntr5Qty");
		this.hashFields.put("cntr4_qty", "cntr4Qty");
		this.hashFields.put("cntr30_qty", "cntr30Qty");
		this.hashFields.put("cntr23_qty", "cntr23Qty");
		this.hashFields.put("cntr24_qty", "cntr24Qty");
		this.hashFields.put("offh_yrmon", "offhYrmon");
		this.hashFields.put("cntr11_qty", "cntr11Qty");
		this.hashFields.put("cntr6_qty", "cntr6Qty");
		this.hashFields.put("cntr1_qty", "cntr1Qty");
		this.hashFields.put("cntr28_qty", "cntr28Qty");
		this.hashFields.put("cntr21_qty", "cntr21Qty");
		this.hashFields.put("cntr7_qty", "cntr7Qty");
		this.hashFields.put("cntr27_qty", "cntr27Qty");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("level_no", "levelNo");
		this.hashFields.put("level", "level");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return offhLocCd
	 */
	public String getOffhLocCd() {
		return this.offhLocCd;
	}
	
	/**
	 * Column Info
	 * @return cntr12Qty
	 */
	public String getCntr12Qty() {
		return this.cntr12Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr3Qty
	 */
	public String getCntr3Qty() {
		return this.cntr3Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr22Qty
	 */
	public String getCntr22Qty() {
		return this.cntr22Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr18Qty
	 */
	public String getCntr18Qty() {
		return this.cntr18Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr25Qty
	 */
	public String getCntr25Qty() {
		return this.cntr25Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr9Qty
	 */
	public String getCntr9Qty() {
		return this.cntr9Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr13Qty
	 */
	public String getCntr13Qty() {
		return this.cntr13Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr8Qty
	 */
	public String getCntr8Qty() {
		return this.cntr8Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr20Qty
	 */
	public String getCntr20Qty() {
		return this.cntr20Qty;
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
	 * @return cntr14Qty
	 */
	public String getCntr14Qty() {
		return this.cntr14Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr26Qty
	 */
	public String getCntr26Qty() {
		return this.cntr26Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr19Qty
	 */
	public String getCntr19Qty() {
		return this.cntr19Qty;
	}
	
	/**
	 * Column Info
	 * @return plnYr
	 */
	public String getPlnYr() {
		return this.plnYr;
	}
	
	/**
	 * Column Info
	 * @return cntr15Qty
	 */
	public String getCntr15Qty() {
		return this.cntr15Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr17Qty
	 */
	public String getCntr17Qty() {
		return this.cntr17Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr2Qty
	 */
	public String getCntr2Qty() {
		return this.cntr2Qty;
	}
	
	/**
	 * Column Info
	 * @return offhLocTpCd
	 */
	public String getOffhLocTpCd() {
		return this.offhLocTpCd;
	}
	
	/**
	 * Column Info
	 * @return cntr16Qty
	 */
	public String getCntr16Qty() {
		return this.cntr16Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr29Qty
	 */
	public String getCntr29Qty() {
		return this.cntr29Qty;
	}
	
	/**
	 * Column Info
	 * @return offhRgnLocCd
	 */
	public String getOffhRgnLocCd() {
		return this.offhRgnLocCd;
	}
	
	/**
	 * Column Info
	 * @return cntr10Qty
	 */
	public String getCntr10Qty() {
		return this.cntr10Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr5Qty
	 */
	public String getCntr5Qty() {
		return this.cntr5Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr4Qty
	 */
	public String getCntr4Qty() {
		return this.cntr4Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr30Qty
	 */
	public String getCntr30Qty() {
		return this.cntr30Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr23Qty
	 */
	public String getCntr23Qty() {
		return this.cntr23Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr24Qty
	 */
	public String getCntr24Qty() {
		return this.cntr24Qty;
	}
	
	/**
	 * Column Info
	 * @return offhYrmon
	 */
	public String getOffhYrmon() {
		return this.offhYrmon;
	}
	
	/**
	 * Column Info
	 * @return cntr11Qty
	 */
	public String getCntr11Qty() {
		return this.cntr11Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr6Qty
	 */
	public String getCntr6Qty() {
		return this.cntr6Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr1Qty
	 */
	public String getCntr1Qty() {
		return this.cntr1Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr28Qty
	 */
	public String getCntr28Qty() {
		return this.cntr28Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr21Qty
	 */
	public String getCntr21Qty() {
		return this.cntr21Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr7Qty
	 */
	public String getCntr7Qty() {
		return this.cntr7Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr27Qty
	 */
	public String getCntr27Qty() {
		return this.cntr27Qty;
	}
	

	/**
	 * Column Info
	 * @param offhLocCd
	 */
	public void setOffhLocCd(String offhLocCd) {
		this.offhLocCd = offhLocCd;
	}
	
	/**
	 * Column Info
	 * @param cntr12Qty
	 */
	public void setCntr12Qty(String cntr12Qty) {
		this.cntr12Qty = cntr12Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr3Qty
	 */
	public void setCntr3Qty(String cntr3Qty) {
		this.cntr3Qty = cntr3Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr22Qty
	 */
	public void setCntr22Qty(String cntr22Qty) {
		this.cntr22Qty = cntr22Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr18Qty
	 */
	public void setCntr18Qty(String cntr18Qty) {
		this.cntr18Qty = cntr18Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr25Qty
	 */
	public void setCntr25Qty(String cntr25Qty) {
		this.cntr25Qty = cntr25Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr9Qty
	 */
	public void setCntr9Qty(String cntr9Qty) {
		this.cntr9Qty = cntr9Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr13Qty
	 */
	public void setCntr13Qty(String cntr13Qty) {
		this.cntr13Qty = cntr13Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr8Qty
	 */
	public void setCntr8Qty(String cntr8Qty) {
		this.cntr8Qty = cntr8Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr20Qty
	 */
	public void setCntr20Qty(String cntr20Qty) {
		this.cntr20Qty = cntr20Qty;
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
	 * @param cntr14Qty
	 */
	public void setCntr14Qty(String cntr14Qty) {
		this.cntr14Qty = cntr14Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr26Qty
	 */
	public void setCntr26Qty(String cntr26Qty) {
		this.cntr26Qty = cntr26Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr19Qty
	 */
	public void setCntr19Qty(String cntr19Qty) {
		this.cntr19Qty = cntr19Qty;
	}
	
	/**
	 * Column Info
	 * @param plnYr
	 */
	public void setPlnYr(String plnYr) {
		this.plnYr = plnYr;
	}
	
	/**
	 * Column Info
	 * @param cntr15Qty
	 */
	public void setCntr15Qty(String cntr15Qty) {
		this.cntr15Qty = cntr15Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr17Qty
	 */
	public void setCntr17Qty(String cntr17Qty) {
		this.cntr17Qty = cntr17Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr2Qty
	 */
	public void setCntr2Qty(String cntr2Qty) {
		this.cntr2Qty = cntr2Qty;
	}
	
	/**
	 * Column Info
	 * @param offhLocTpCd
	 */
	public void setOffhLocTpCd(String offhLocTpCd) {
		this.offhLocTpCd = offhLocTpCd;
	}
	
	/**
	 * Column Info
	 * @param cntr16Qty
	 */
	public void setCntr16Qty(String cntr16Qty) {
		this.cntr16Qty = cntr16Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr29Qty
	 */
	public void setCntr29Qty(String cntr29Qty) {
		this.cntr29Qty = cntr29Qty;
	}
	
	/**
	 * Column Info
	 * @param offhRgnLocCd
	 */
	public void setOffhRgnLocCd(String offhRgnLocCd) {
		this.offhRgnLocCd = offhRgnLocCd;
	}
	
	/**
	 * Column Info
	 * @param cntr10Qty
	 */
	public void setCntr10Qty(String cntr10Qty) {
		this.cntr10Qty = cntr10Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr5Qty
	 */
	public void setCntr5Qty(String cntr5Qty) {
		this.cntr5Qty = cntr5Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr4Qty
	 */
	public void setCntr4Qty(String cntr4Qty) {
		this.cntr4Qty = cntr4Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr30Qty
	 */
	public void setCntr30Qty(String cntr30Qty) {
		this.cntr30Qty = cntr30Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr23Qty
	 */
	public void setCntr23Qty(String cntr23Qty) {
		this.cntr23Qty = cntr23Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr24Qty
	 */
	public void setCntr24Qty(String cntr24Qty) {
		this.cntr24Qty = cntr24Qty;
	}
	
	/**
	 * Column Info
	 * @param offhYrmon
	 */
	public void setOffhYrmon(String offhYrmon) {
		this.offhYrmon = offhYrmon;
	}
	
	/**
	 * Column Info
	 * @param cntr11Qty
	 */
	public void setCntr11Qty(String cntr11Qty) {
		this.cntr11Qty = cntr11Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr6Qty
	 */
	public void setCntr6Qty(String cntr6Qty) {
		this.cntr6Qty = cntr6Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr1Qty
	 */
	public void setCntr1Qty(String cntr1Qty) {
		this.cntr1Qty = cntr1Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr28Qty
	 */
	public void setCntr28Qty(String cntr28Qty) {
		this.cntr28Qty = cntr28Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr21Qty
	 */
	public void setCntr21Qty(String cntr21Qty) {
		this.cntr21Qty = cntr21Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr7Qty
	 */
	public void setCntr7Qty(String cntr7Qty) {
		this.cntr7Qty = cntr7Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr27Qty
	 */
	public void setCntr27Qty(String cntr27Qty) {
		this.cntr27Qty = cntr27Qty;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOffhLocCd(JSPUtil.getParameter(request, "offh_loc_cd", ""));
		setCntr12Qty(JSPUtil.getParameter(request, "cntr12_qty", ""));
		setCntr3Qty(JSPUtil.getParameter(request, "cntr3_qty", ""));
		setCntr22Qty(JSPUtil.getParameter(request, "cntr22_qty", ""));
		setCntr18Qty(JSPUtil.getParameter(request, "cntr18_qty", ""));
		setCntr25Qty(JSPUtil.getParameter(request, "cntr25_qty", ""));
		setCntr9Qty(JSPUtil.getParameter(request, "cntr9_qty", ""));
		setCntr13Qty(JSPUtil.getParameter(request, "cntr13_qty", ""));
		setCntr8Qty(JSPUtil.getParameter(request, "cntr8_qty", ""));
		setCntr20Qty(JSPUtil.getParameter(request, "cntr20_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntr14Qty(JSPUtil.getParameter(request, "cntr14_qty", ""));
		setCntr26Qty(JSPUtil.getParameter(request, "cntr26_qty", ""));
		setCntr19Qty(JSPUtil.getParameter(request, "cntr19_qty", ""));
		setPlnYr(JSPUtil.getParameter(request, "pln_yr", ""));
		setCntr15Qty(JSPUtil.getParameter(request, "cntr15_qty", ""));
		setCntr17Qty(JSPUtil.getParameter(request, "cntr17_qty", ""));
		setCntr2Qty(JSPUtil.getParameter(request, "cntr2_qty", ""));
		setOffhLocTpCd(JSPUtil.getParameter(request, "offh_loc_tp_cd", ""));
		setCntr16Qty(JSPUtil.getParameter(request, "cntr16_qty", ""));
		setCntr29Qty(JSPUtil.getParameter(request, "cntr29_qty", ""));
		setOffhRgnLocCd(JSPUtil.getParameter(request, "offh_rgn_loc_cd", ""));
		setCntr10Qty(JSPUtil.getParameter(request, "cntr10_qty", ""));
		setCntr5Qty(JSPUtil.getParameter(request, "cntr5_qty", ""));
		setCntr4Qty(JSPUtil.getParameter(request, "cntr4_qty", ""));
		setCntr30Qty(JSPUtil.getParameter(request, "cntr30_qty", ""));
		setCntr23Qty(JSPUtil.getParameter(request, "cntr23_qty", ""));
		setCntr24Qty(JSPUtil.getParameter(request, "cntr24_qty", ""));
		setOffhYrmon(JSPUtil.getParameter(request, "offh_yrmon", ""));
		setCntr11Qty(JSPUtil.getParameter(request, "cntr11_qty", ""));
		setCntr6Qty(JSPUtil.getParameter(request, "cntr6_qty", ""));
		setCntr1Qty(JSPUtil.getParameter(request, "cntr1_qty", ""));
		setCntr28Qty(JSPUtil.getParameter(request, "cntr28_qty", ""));
		setCntr21Qty(JSPUtil.getParameter(request, "cntr21_qty", ""));
		setCntr7Qty(JSPUtil.getParameter(request, "cntr7_qty", ""));
		setCntr27Qty(JSPUtil.getParameter(request, "cntr27_qty", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setLevelNo(JSPUtil.getParameter(request, "level_no", ""));
		setLevel(JSPUtil.getParameter(request, "level", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OffHirePlanRccVO[]
	 */
	public OffHirePlanRccVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OffHirePlanRccVO[]
	 */
	public OffHirePlanRccVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OffHirePlanRccVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] offhLocCd = (JSPUtil.getParameter(request, prefix	+ "offh_loc_cd", length));
			String[] cntr12Qty = (JSPUtil.getParameter(request, prefix	+ "cntr12_qty", length));
			String[] cntr3Qty = (JSPUtil.getParameter(request, prefix	+ "cntr3_qty", length));
			String[] cntr22Qty = (JSPUtil.getParameter(request, prefix	+ "cntr22_qty", length));
			String[] cntr18Qty = (JSPUtil.getParameter(request, prefix	+ "cntr18_qty", length));
			String[] cntr25Qty = (JSPUtil.getParameter(request, prefix	+ "cntr25_qty", length));
			String[] cntr9Qty = (JSPUtil.getParameter(request, prefix	+ "cntr9_qty", length));
			String[] cntr13Qty = (JSPUtil.getParameter(request, prefix	+ "cntr13_qty", length));
			String[] cntr8Qty = (JSPUtil.getParameter(request, prefix	+ "cntr8_qty", length));
			String[] cntr20Qty = (JSPUtil.getParameter(request, prefix	+ "cntr20_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntr14Qty = (JSPUtil.getParameter(request, prefix	+ "cntr14_qty", length));
			String[] cntr26Qty = (JSPUtil.getParameter(request, prefix	+ "cntr26_qty", length));
			String[] cntr19Qty = (JSPUtil.getParameter(request, prefix	+ "cntr19_qty", length));
			String[] plnYr = (JSPUtil.getParameter(request, prefix	+ "pln_yr", length));
			String[] cntr15Qty = (JSPUtil.getParameter(request, prefix	+ "cntr15_qty", length));
			String[] cntr17Qty = (JSPUtil.getParameter(request, prefix	+ "cntr17_qty", length));
			String[] cntr2Qty = (JSPUtil.getParameter(request, prefix	+ "cntr2_qty", length));
			String[] offhLocTpCd = (JSPUtil.getParameter(request, prefix	+ "offh_loc_tp_cd", length));
			String[] cntr16Qty = (JSPUtil.getParameter(request, prefix	+ "cntr16_qty", length));
			String[] cntr29Qty = (JSPUtil.getParameter(request, prefix	+ "cntr29_qty", length));
			String[] offhRgnLocCd = (JSPUtil.getParameter(request, prefix	+ "offh_rgn_loc_cd", length));
			String[] cntr10Qty = (JSPUtil.getParameter(request, prefix	+ "cntr10_qty", length));
			String[] cntr5Qty = (JSPUtil.getParameter(request, prefix	+ "cntr5_qty", length));
			String[] cntr4Qty = (JSPUtil.getParameter(request, prefix	+ "cntr4_qty", length));
			String[] cntr30Qty = (JSPUtil.getParameter(request, prefix	+ "cntr30_qty", length));
			String[] cntr23Qty = (JSPUtil.getParameter(request, prefix	+ "cntr23_qty", length));
			String[] cntr24Qty = (JSPUtil.getParameter(request, prefix	+ "cntr24_qty", length));
			String[] offhYrmon = (JSPUtil.getParameter(request, prefix	+ "offh_yrmon", length));
			String[] cntr11Qty = (JSPUtil.getParameter(request, prefix	+ "cntr11_qty", length));
			String[] cntr6Qty = (JSPUtil.getParameter(request, prefix	+ "cntr6_qty", length));
			String[] cntr1Qty = (JSPUtil.getParameter(request, prefix	+ "cntr1_qty", length));
			String[] cntr28Qty = (JSPUtil.getParameter(request, prefix	+ "cntr28_qty", length));
			String[] cntr21Qty = (JSPUtil.getParameter(request, prefix	+ "cntr21_qty", length));
			String[] cntr7Qty = (JSPUtil.getParameter(request, prefix	+ "cntr7_qty", length));
			String[] cntr27Qty = (JSPUtil.getParameter(request, prefix	+ "cntr27_qty", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] levelNo = (JSPUtil.getParameter(request, prefix	+ "level_no", length));
			String[] level = (JSPUtil.getParameter(request, prefix	+ "level", length));
			
			for (int i = 0; i < length; i++) {
				model = new OffHirePlanRccVO();
				if (offhLocCd[i] != null)
					model.setOffhLocCd(offhLocCd[i]);
				if (cntr12Qty[i] != null)
					model.setCntr12Qty(cntr12Qty[i]);
				if (cntr3Qty[i] != null)
					model.setCntr3Qty(cntr3Qty[i]);
				if (cntr22Qty[i] != null)
					model.setCntr22Qty(cntr22Qty[i]);
				if (cntr18Qty[i] != null)
					model.setCntr18Qty(cntr18Qty[i]);
				if (cntr25Qty[i] != null)
					model.setCntr25Qty(cntr25Qty[i]);
				if (cntr9Qty[i] != null)
					model.setCntr9Qty(cntr9Qty[i]);
				if (cntr13Qty[i] != null)
					model.setCntr13Qty(cntr13Qty[i]);
				if (cntr8Qty[i] != null)
					model.setCntr8Qty(cntr8Qty[i]);
				if (cntr20Qty[i] != null)
					model.setCntr20Qty(cntr20Qty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntr14Qty[i] != null)
					model.setCntr14Qty(cntr14Qty[i]);
				if (cntr26Qty[i] != null)
					model.setCntr26Qty(cntr26Qty[i]);
				if (cntr19Qty[i] != null)
					model.setCntr19Qty(cntr19Qty[i]);
				if (plnYr[i] != null)
					model.setPlnYr(plnYr[i]);
				if (cntr15Qty[i] != null)
					model.setCntr15Qty(cntr15Qty[i]);
				if (cntr17Qty[i] != null)
					model.setCntr17Qty(cntr17Qty[i]);
				if (cntr2Qty[i] != null)
					model.setCntr2Qty(cntr2Qty[i]);
				if (offhLocTpCd[i] != null)
					model.setOffhLocTpCd(offhLocTpCd[i]);
				if (cntr16Qty[i] != null)
					model.setCntr16Qty(cntr16Qty[i]);
				if (cntr29Qty[i] != null)
					model.setCntr29Qty(cntr29Qty[i]);
				if (offhRgnLocCd[i] != null)
					model.setOffhRgnLocCd(offhRgnLocCd[i]);
				if (cntr10Qty[i] != null)
					model.setCntr10Qty(cntr10Qty[i]);
				if (cntr5Qty[i] != null)
					model.setCntr5Qty(cntr5Qty[i]);
				if (cntr4Qty[i] != null)
					model.setCntr4Qty(cntr4Qty[i]);
				if (cntr30Qty[i] != null)
					model.setCntr30Qty(cntr30Qty[i]);
				if (cntr23Qty[i] != null)
					model.setCntr23Qty(cntr23Qty[i]);
				if (cntr24Qty[i] != null)
					model.setCntr24Qty(cntr24Qty[i]);
				if (offhYrmon[i] != null)
					model.setOffhYrmon(offhYrmon[i]);
				if (cntr11Qty[i] != null)
					model.setCntr11Qty(cntr11Qty[i]);
				if (cntr6Qty[i] != null)
					model.setCntr6Qty(cntr6Qty[i]);
				if (cntr1Qty[i] != null)
					model.setCntr1Qty(cntr1Qty[i]);
				if (cntr28Qty[i] != null)
					model.setCntr28Qty(cntr28Qty[i]);
				if (cntr21Qty[i] != null)
					model.setCntr21Qty(cntr21Qty[i]);
				if (cntr7Qty[i] != null)
					model.setCntr7Qty(cntr7Qty[i]);
				if (cntr27Qty[i] != null)
					model.setCntr27Qty(cntr27Qty[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (levelNo[i] != null)
					model.setLevelNo(levelNo[i]);
				if (level[i] != null)
					model.setLevel(level[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOffHirePlanRccVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OffHirePlanRccVO[]
	 */
	public OffHirePlanRccVO[] getOffHirePlanRccVOs(){
		OffHirePlanRccVO[] vos = (OffHirePlanRccVO[])models.toArray(new OffHirePlanRccVO[models.size()]);
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
		this.offhLocCd = this.offhLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr12Qty = this.cntr12Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr3Qty = this.cntr3Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr22Qty = this.cntr22Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr18Qty = this.cntr18Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr25Qty = this.cntr25Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr9Qty = this.cntr9Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr13Qty = this.cntr13Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr8Qty = this.cntr8Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr20Qty = this.cntr20Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr14Qty = this.cntr14Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr26Qty = this.cntr26Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr19Qty = this.cntr19Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYr = this.plnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr15Qty = this.cntr15Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr17Qty = this.cntr17Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr2Qty = this.cntr2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhLocTpCd = this.offhLocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr16Qty = this.cntr16Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr29Qty = this.cntr29Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhRgnLocCd = this.offhRgnLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr10Qty = this.cntr10Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr5Qty = this.cntr5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr4Qty = this.cntr4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr30Qty = this.cntr30Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr23Qty = this.cntr23Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr24Qty = this.cntr24Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhYrmon = this.offhYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr11Qty = this.cntr11Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr6Qty = this.cntr6Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr1Qty = this.cntr1Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr28Qty = this.cntr28Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr21Qty = this.cntr21Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr7Qty = this.cntr7Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr27Qty = this.cntr27Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.levelNo = this.levelNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.level = this.level .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}

	public String getAgmtNo() {
		return agmtNo;
	}

	public void setLevelNo(String levelNo) {
		this.level = levelNo;
		this.levelNo = levelNo;
	}

	public String getLevelNo() {
		return levelNo;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLevel() {
		return levelNo;
	}
}
