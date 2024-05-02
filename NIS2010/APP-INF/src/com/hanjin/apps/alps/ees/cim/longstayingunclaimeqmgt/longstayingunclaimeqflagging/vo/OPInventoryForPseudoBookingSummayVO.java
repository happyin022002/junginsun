/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OPInventoryForPseudoBookingSummayVO.java
*@FileTitle : OPInventoryForPseudoBookingSummayVOVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.09
*@LastModifier : 이영두
*@LastVersion : 1.0
* 2013.07.09 이영두
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OPInventoryForPseudoBookingSummayVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OPInventoryForPseudoBookingSummayVO> models = new ArrayList<OPInventoryForPseudoBookingSummayVO>();
	
	/* Column Info */
	private String totalRate = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String totalAvg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String overAvg = null;
	/* Column Info */
	private String avg4 = null;
	/* Column Info */
	private String avg5 = null;
	/* Column Info */
	private String avg2 = null;
	/* Column Info */
	private String avg3 = null;
	/* Column Info */
	private String overRate = null;
	/* Column Info */
	private String avg8 = null;
	/* Column Info */
	private String avg9 = null;
	/* Column Info */
	private String avg6 = null;
	/* Column Info */
	private String avg7 = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String rate11 = null;
	/* Column Info */
	private String avg13 = null;
	/* Column Info */
	private String rate12 = null;
	/* Column Info */
	private String avg14 = null;
	/* Column Info */
	private String qty1 = null;
	/* Column Info */
	private String rate13 = null;
	/* Column Info */
	private String avg15 = null;
	/* Column Info */
	private String rate14 = null;
	/* Column Info */
	private String rate15 = null;
	/* Column Info */
	private String qty3 = null;
	/* Column Info */
	private String avg10 = null;
	/* Column Info */
	private String qty2 = null;
	/* Column Info */
	private String avg11 = null;
	/* Column Info */
	private String qty5 = null;
	/* Column Info */
	private String avg12 = null;
	/* Column Info */
	private String qty4 = null;
	/* Column Info */
	private String rate4 = null;
	/* Column Info */
	private String rate5 = null;
	/* Column Info */
	private String rate6 = null;
	/* Column Info */
	private String rate7 = null;
	/* Column Info */
	private String rate1 = null;
	/* Column Info */
	private String rate2 = null;
	/* Column Info */
	private String rate3 = null;
	/* Column Info */
	private String stayDays11 = null;
	/* Column Info */
	private String stayDays12 = null;
	/* Column Info */
	private String stayDays13 = null;
	/* Column Info */
	private String stayDays14 = null;
	/* Column Info */
	private String stayDays15 = null;
	/* Column Info */
	private String rate8 = null;
	/* Column Info */
	private String rate9 = null;
	/* Column Info */
	private String avg1 = null;
	/* Column Info */
	private String stayDays3 = null;
	/* Column Info */
	private String stayDays2 = null;
	/* Column Info */
	private String overStayDays = null;
	/* Column Info */
	private String stayDays1 = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String stayDays7 = null;
	/* Column Info */
	private String stayDays6 = null;
	/* Column Info */
	private String stayDays5 = null;
	/* Column Info */
	private String stayDays10 = null;
	/* Column Info */
	private String stayDays4 = null;
	/* Column Info */
	private String stayDays9 = null;
	/* Column Info */
	private String stayDays8 = null;
	/* Column Info */
	private String qty11 = null;
	/* Column Info */
	private String overQty = null;
	/* Column Info */
	private String qty12 = null;
	/* Column Info */
	private String qty10 = null;
	/* Column Info */
	private String totalQty = null;
	/* Column Info */
	private String qty15 = null;
	/* Column Info */
	private String dateStr = null;
	/* Column Info */
	private String qty13 = null;
	/* Column Info */
	private String qty14 = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String qty8 = null;
	/* Column Info */
	private String qty9 = null;
	/* Column Info */
	private String qty6 = null;
	/* Column Info */
	private String qty7 = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String actQty = null;
	/* Column Info */
	private String rate10 = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OPInventoryForPseudoBookingSummayVO() {}

	public OPInventoryForPseudoBookingSummayVO(String ibflag, String pagerows, String totalRate, String rhqCd, String totalAvg, String overAvg, String avg4, String avg5, String avg2, String avg3, String overRate, String avg8, String avg9, String avg6, String cntrTpszCd, String avg7, String avg13, String rate11, String avg14, String rate12, String avg15, String rate13, String qty1, String rate14, String rate15, String qty3, String avg10, String qty2, String avg11, String qty5, String avg12, String qty4, String rate4, String rate5, String rate6, String rate7, String rate1, String rate2, String rate3, String stayDays11, String stayDays12, String stayDays13, String stayDays14, String stayDays15, String rate8, String rate9, String avg1, String stayDays3, String stayDays2, String stayDays1, String overStayDays, String lvl, String stayDays7, String stayDays6, String stayDays10, String stayDays5, String stayDays4, String stayDays9, String stayDays8, String qty11, String qty12, String overQty, String qty10, String qty15, String totalQty, String qty13, String qty14, String qty8, String qty9, String qty6, String bkgOfcCd, String qty7, String obSrepCd, String custCd, String custNm, String actQty, String rate10, String dateStr) {
		this.totalRate = totalRate;
		this.rhqCd = rhqCd;
		this.totalAvg = totalAvg;
		this.pagerows = pagerows;
		this.overAvg = overAvg;
		this.avg4 = avg4;
		this.avg5 = avg5;
		this.avg2 = avg2;
		this.avg3 = avg3;
		this.overRate = overRate;
		this.avg8 = avg8;
		this.avg9 = avg9;
		this.avg6 = avg6;
		this.avg7 = avg7;
		this.cntrTpszCd = cntrTpszCd;
		this.rate11 = rate11;
		this.avg13 = avg13;
		this.rate12 = rate12;
		this.avg14 = avg14;
		this.qty1 = qty1;
		this.rate13 = rate13;
		this.avg15 = avg15;
		this.rate14 = rate14;
		this.rate15 = rate15;
		this.qty3 = qty3;
		this.avg10 = avg10;
		this.qty2 = qty2;
		this.avg11 = avg11;
		this.qty5 = qty5;
		this.avg12 = avg12;
		this.qty4 = qty4;
		this.rate4 = rate4;
		this.rate5 = rate5;
		this.rate6 = rate6;
		this.rate7 = rate7;
		this.rate1 = rate1;
		this.rate2 = rate2;
		this.rate3 = rate3;
		this.stayDays11 = stayDays11;
		this.stayDays12 = stayDays12;
		this.stayDays13 = stayDays13;
		this.stayDays14 = stayDays14;
		this.stayDays15 = stayDays15;
		this.rate8 = rate8;
		this.rate9 = rate9;
		this.avg1 = avg1;
		this.stayDays3 = stayDays3;
		this.stayDays2 = stayDays2;
		this.overStayDays = overStayDays;
		this.stayDays1 = stayDays1;
		this.lvl = lvl;
		this.stayDays7 = stayDays7;
		this.stayDays6 = stayDays6;
		this.stayDays5 = stayDays5;
		this.stayDays10 = stayDays10;
		this.stayDays4 = stayDays4;
		this.stayDays9 = stayDays9;
		this.stayDays8 = stayDays8;
		this.qty11 = qty11;
		this.overQty = overQty;
		this.qty12 = qty12;
		this.qty10 = qty10;
		this.totalQty = totalQty;
		this.qty15 = qty15;
		this.dateStr = dateStr;
		this.qty13 = qty13;
		this.qty14 = qty14;
		this.ibflag = ibflag;
		this.qty8 = qty8;
		this.qty9 = qty9;
		this.qty6 = qty6;
		this.qty7 = qty7;
		this.bkgOfcCd = bkgOfcCd;
		this.obSrepCd = obSrepCd;
		this.custCd = custCd;
		this.custNm = custNm;
		this.actQty = actQty;
		this.rate10 = rate10;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total_rate", getTotalRate());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("total_avg", getTotalAvg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("over_avg", getOverAvg());
		this.hashColumns.put("avg4", getAvg4());
		this.hashColumns.put("avg5", getAvg5());
		this.hashColumns.put("avg2", getAvg2());
		this.hashColumns.put("avg3", getAvg3());
		this.hashColumns.put("over_rate", getOverRate());
		this.hashColumns.put("avg8", getAvg8());
		this.hashColumns.put("avg9", getAvg9());
		this.hashColumns.put("avg6", getAvg6());
		this.hashColumns.put("avg7", getAvg7());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("rate11", getRate11());
		this.hashColumns.put("avg13", getAvg13());
		this.hashColumns.put("rate12", getRate12());
		this.hashColumns.put("avg14", getAvg14());
		this.hashColumns.put("qty1", getQty1());
		this.hashColumns.put("rate13", getRate13());
		this.hashColumns.put("avg15", getAvg15());
		this.hashColumns.put("rate14", getRate14());
		this.hashColumns.put("rate15", getRate15());
		this.hashColumns.put("qty3", getQty3());
		this.hashColumns.put("avg10", getAvg10());
		this.hashColumns.put("qty2", getQty2());
		this.hashColumns.put("avg11", getAvg11());
		this.hashColumns.put("qty5", getQty5());
		this.hashColumns.put("avg12", getAvg12());
		this.hashColumns.put("qty4", getQty4());
		this.hashColumns.put("rate4", getRate4());
		this.hashColumns.put("rate5", getRate5());
		this.hashColumns.put("rate6", getRate6());
		this.hashColumns.put("rate7", getRate7());
		this.hashColumns.put("rate1", getRate1());
		this.hashColumns.put("rate2", getRate2());
		this.hashColumns.put("rate3", getRate3());
		this.hashColumns.put("stay_days11", getStayDays11());
		this.hashColumns.put("stay_days12", getStayDays12());
		this.hashColumns.put("stay_days13", getStayDays13());
		this.hashColumns.put("stay_days14", getStayDays14());
		this.hashColumns.put("stay_days15", getStayDays15());
		this.hashColumns.put("rate8", getRate8());
		this.hashColumns.put("rate9", getRate9());
		this.hashColumns.put("avg1", getAvg1());
		this.hashColumns.put("stay_days3", getStayDays3());
		this.hashColumns.put("stay_days2", getStayDays2());
		this.hashColumns.put("over_stay_days", getOverStayDays());
		this.hashColumns.put("stay_days1", getStayDays1());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("stay_days7", getStayDays7());
		this.hashColumns.put("stay_days6", getStayDays6());
		this.hashColumns.put("stay_days5", getStayDays5());
		this.hashColumns.put("stay_days10", getStayDays10());
		this.hashColumns.put("stay_days4", getStayDays4());
		this.hashColumns.put("stay_days9", getStayDays9());
		this.hashColumns.put("stay_days8", getStayDays8());
		this.hashColumns.put("qty11", getQty11());
		this.hashColumns.put("over_qty", getOverQty());
		this.hashColumns.put("qty12", getQty12());
		this.hashColumns.put("qty10", getQty10());
		this.hashColumns.put("total_qty", getTotalQty());
		this.hashColumns.put("qty15", getQty15());
		this.hashColumns.put("date_str", getDateStr());
		this.hashColumns.put("qty13", getQty13());
		this.hashColumns.put("qty14", getQty14());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("qty8", getQty8());
		this.hashColumns.put("qty9", getQty9());
		this.hashColumns.put("qty6", getQty6());
		this.hashColumns.put("qty7", getQty7());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("act_qty", getActQty());
		this.hashColumns.put("rate10", getRate10());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total_rate", "totalRate");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("total_avg", "totalAvg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("over_avg", "overAvg");
		this.hashFields.put("avg4", "avg4");
		this.hashFields.put("avg5", "avg5");
		this.hashFields.put("avg2", "avg2");
		this.hashFields.put("avg3", "avg3");
		this.hashFields.put("over_rate", "overRate");
		this.hashFields.put("avg8", "avg8");
		this.hashFields.put("avg9", "avg9");
		this.hashFields.put("avg6", "avg6");
		this.hashFields.put("avg7", "avg7");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("rate11", "rate11");
		this.hashFields.put("avg13", "avg13");
		this.hashFields.put("rate12", "rate12");
		this.hashFields.put("avg14", "avg14");
		this.hashFields.put("qty1", "qty1");
		this.hashFields.put("rate13", "rate13");
		this.hashFields.put("avg15", "avg15");
		this.hashFields.put("rate14", "rate14");
		this.hashFields.put("rate15", "rate15");
		this.hashFields.put("qty3", "qty3");
		this.hashFields.put("avg10", "avg10");
		this.hashFields.put("qty2", "qty2");
		this.hashFields.put("avg11", "avg11");
		this.hashFields.put("qty5", "qty5");
		this.hashFields.put("avg12", "avg12");
		this.hashFields.put("qty4", "qty4");
		this.hashFields.put("rate4", "rate4");
		this.hashFields.put("rate5", "rate5");
		this.hashFields.put("rate6", "rate6");
		this.hashFields.put("rate7", "rate7");
		this.hashFields.put("rate1", "rate1");
		this.hashFields.put("rate2", "rate2");
		this.hashFields.put("rate3", "rate3");
		this.hashFields.put("stay_days11", "stayDays11");
		this.hashFields.put("stay_days12", "stayDays12");
		this.hashFields.put("stay_days13", "stayDays13");
		this.hashFields.put("stay_days14", "stayDays14");
		this.hashFields.put("stay_days15", "stayDays15");
		this.hashFields.put("rate8", "rate8");
		this.hashFields.put("rate9", "rate9");
		this.hashFields.put("avg1", "avg1");
		this.hashFields.put("stay_days3", "stayDays3");
		this.hashFields.put("stay_days2", "stayDays2");
		this.hashFields.put("over_stay_days", "overStayDays");
		this.hashFields.put("stay_days1", "stayDays1");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("stay_days7", "stayDays7");
		this.hashFields.put("stay_days6", "stayDays6");
		this.hashFields.put("stay_days5", "stayDays5");
		this.hashFields.put("stay_days10", "stayDays10");
		this.hashFields.put("stay_days4", "stayDays4");
		this.hashFields.put("stay_days9", "stayDays9");
		this.hashFields.put("stay_days8", "stayDays8");
		this.hashFields.put("qty11", "qty11");
		this.hashFields.put("over_qty", "overQty");
		this.hashFields.put("qty12", "qty12");
		this.hashFields.put("qty10", "qty10");
		this.hashFields.put("total_qty", "totalQty");
		this.hashFields.put("qty15", "qty15");
		this.hashFields.put("date_str", "dateStr");
		this.hashFields.put("qty13", "qty13");
		this.hashFields.put("qty14", "qty14");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("qty8", "qty8");
		this.hashFields.put("qty9", "qty9");
		this.hashFields.put("qty6", "qty6");
		this.hashFields.put("qty7", "qty7");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("act_qty", "actQty");
		this.hashFields.put("rate10", "rate10");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return totalRate
	 */
	public String getTotalRate() {
		return this.totalRate;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return totalAvg
	 */
	public String getTotalAvg() {
		return this.totalAvg;
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
	 * @return overAvg
	 */
	public String getOverAvg() {
		return this.overAvg;
	}
	
	/**
	 * Column Info
	 * @return avg4
	 */
	public String getAvg4() {
		return this.avg4;
	}
	
	/**
	 * Column Info
	 * @return avg5
	 */
	public String getAvg5() {
		return this.avg5;
	}
	
	/**
	 * Column Info
	 * @return avg2
	 */
	public String getAvg2() {
		return this.avg2;
	}

	/**
	 * Column Info
	 * @return avg3
	 */
	public String getAvg3() {
		return this.avg3;
	}
	
	/**
	 * Column Info
	 * @return overRate
	 */
	public String getOverRate() {
		return this.overRate;
	}
	
	/**
	 * Column Info
	 * @return avg8
	 */
	public String getAvg8() {
		return this.avg8;
	}
	
	/**
	 * Column Info
	 * @return avg9
	 */
	public String getAvg9() {
		return this.avg9;
	}
	
	/**
	 * Column Info
	 * @return avg6
	 */
	public String getAvg6() {
		return this.avg6;
	}
	
	/**
	 * Column Info
	 * @return avg7
	 */
	public String getAvg7() {
		return this.avg7;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return rate11
	 */
	public String getRate11() {
		return this.rate11;
	}
	
	/**
	 * Column Info
	 * @return avg13
	 */
	public String getAvg13() {
		return this.avg13;
	}
	
	/**
	 * Column Info
	 * @return rate12
	 */
	public String getRate12() {
		return this.rate12;
	}
	
	/**
	 * Column Info
	 * @return avg14
	 */
	public String getAvg14() {
		return this.avg14;
	}
	
	/**
	 * Column Info
	 * @return qty1
	 */
	public String getQty1() {
		return this.qty1;
	}
	
	/**
	 * Column Info
	 * @return rate13
	 */
	public String getRate13() {
		return this.rate13;
	}
	
	/**
	 * Column Info
	 * @return avg15
	 */
	public String getAvg15() {
		return this.avg15;
	}
	
	/**
	 * Column Info
	 * @return rate14
	 */
	public String getRate14() {
		return this.rate14;
	}
	
	/**
	 * Column Info
	 * @return rate15
	 */
	public String getRate15() {
		return this.rate15;
	}
	
	/**
	 * Column Info
	 * @return qty3
	 */
	public String getQty3() {
		return this.qty3;
	}
	
	/**
	 * Column Info
	 * @return avg10
	 */
	public String getAvg10() {
		return this.avg10;
	}
	
	/**
	 * Column Info
	 * @return qty2
	 */
	public String getQty2() {
		return this.qty2;
	}
	
	/**
	 * Column Info
	 * @return avg11
	 */
	public String getAvg11() {
		return this.avg11;
	}
	
	/**
	 * Column Info
	 * @return qty5
	 */
	public String getQty5() {
		return this.qty5;
	}
	
	/**
	 * Column Info
	 * @return avg12
	 */
	public String getAvg12() {
		return this.avg12;
	}
	
	/**
	 * Column Info
	 * @return qty4
	 */
	public String getQty4() {
		return this.qty4;
	}
	
	/**
	 * Column Info
	 * @return rate4
	 */
	public String getRate4() {
		return this.rate4;
	}
	
	/**
	 * Column Info
	 * @return rate5
	 */
	public String getRate5() {
		return this.rate5;
	}
	
	/**
	 * Column Info
	 * @return rate6
	 */
	public String getRate6() {
		return this.rate6;
	}
	
	/**
	 * Column Info
	 * @return rate7
	 */
	public String getRate7() {
		return this.rate7;
	}
	
	/**
	 * Column Info
	 * @return rate1
	 */
	public String getRate1() {
		return this.rate1;
	}
	
	/**
	 * Column Info
	 * @return rate2
	 */
	public String getRate2() {
		return this.rate2;
	}
	
	/**
	 * Column Info
	 * @return rate3
	 */
	public String getRate3() {
		return this.rate3;
	}
	
	/**
	 * Column Info
	 * @return stayDays11
	 */
	public String getStayDays11() {
		return this.stayDays11;
	}
	
	/**
	 * Column Info
	 * @return stayDays12
	 */
	public String getStayDays12() {
		return this.stayDays12;
	}
	
	/**
	 * Column Info
	 * @return stayDays13
	 */
	public String getStayDays13() {
		return this.stayDays13;
	}
	
	/**
	 * Column Info
	 * @return stayDays14
	 */
	public String getStayDays14() {
		return this.stayDays14;
	}
	
	/**
	 * Column Info
	 * @return stayDays15
	 */
	public String getStayDays15() {
		return this.stayDays15;
	}
	
	/**
	 * Column Info
	 * @return rate8
	 */
	public String getRate8() {
		return this.rate8;
	}
	
	/**
	 * Column Info
	 * @return rate9
	 */
	public String getRate9() {
		return this.rate9;
	}
	
	/**
	 * Column Info
	 * @return avg1
	 */
	public String getAvg1() {
		return this.avg1;
	}
	
	/**
	 * Column Info
	 * @return stayDays3
	 */
	public String getStayDays3() {
		return this.stayDays3;
	}
	
	/**
	 * Column Info
	 * @return stayDays2
	 */
	public String getStayDays2() {
		return this.stayDays2;
	}
	
	/**
	 * Column Info
	 * @return overStayDays
	 */
	public String getOverStayDays() {
		return this.overStayDays;
	}
	
	/**
	 * Column Info
	 * @return stayDays1
	 */
	public String getStayDays1() {
		return this.stayDays1;
	}
	
	/**
	 * Column Info
	 * @return lvl
	 */
	public String getLvl() {
		return this.lvl;
	}
	
	/**
	 * Column Info
	 * @return stayDays7
	 */
	public String getStayDays7() {
		return this.stayDays7;
	}
	
	/**
	 * Column Info
	 * @return stayDays6
	 */
	public String getStayDays6() {
		return this.stayDays6;
	}
	
	/**
	 * Column Info
	 * @return stayDays5
	 */
	public String getStayDays5() {
		return this.stayDays5;
	}
	
	/**
	 * Column Info
	 * @return stayDays10
	 */
	public String getStayDays10() {
		return this.stayDays10;
	}
	
	/**
	 * Column Info
	 * @return stayDays4
	 */
	public String getStayDays4() {
		return this.stayDays4;
	}
	
	/**
	 * Column Info
	 * @return stayDays9
	 */
	public String getStayDays9() {
		return this.stayDays9;
	}
	
	/**
	 * Column Info
	 * @return stayDays8
	 */
	public String getStayDays8() {
		return this.stayDays8;
	}
	
	/**
	 * Column Info
	 * @return qty11
	 */
	public String getQty11() {
		return this.qty11;
	}
	
	/**
	 * Column Info
	 * @return overQty
	 */
	public String getOverQty() {
		return this.overQty;
	}
	
	/**
	 * Column Info
	 * @return qty12
	 */
	public String getQty12() {
		return this.qty12;
	}
	
	/**
	 * Column Info
	 * @return qty10
	 */
	public String getQty10() {
		return this.qty10;
	}
	
	/**
	 * Column Info
	 * @return totalQty
	 */
	public String getTotalQty() {
		return this.totalQty;
	}
	
	/**
	 * Column Info
	 * @return qty15
	 */
	public String getQty15() {
		return this.qty15;
	}
	
	/**
	 * Column Info
	 * @return dateStr
	 */
	public String getDateStr() {
		return this.dateStr;
	}
	
	/**
	 * Column Info
	 * @return qty13
	 */
	public String getQty13() {
		return this.qty13;
	}
	
	/**
	 * Column Info
	 * @return qty14
	 */
	public String getQty14() {
		return this.qty14;
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
	 * @return qty8
	 */
	public String getQty8() {
		return this.qty8;
	}
	
	/**
	 * Column Info
	 * @return qty9
	 */
	public String getQty9() {
		return this.qty9;
	}
	
	/**
	 * Column Info
	 * @return qty6
	 */
	public String getQty6() {
		return this.qty6;
	}
	
	/**
	 * Column Info
	 * @return qty7
	 */
	public String getQty7() {
		return this.qty7;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return actQty
	 */
	public String getActQty() {
		return this.actQty;
	}
	
	/**
	 * Column Info
	 * @return rate10
	 */
	public String getRate10() {
		return this.rate10;
	}
	

	/**
	 * Column Info
	 * @param totalRate
	 */
	public void setTotalRate(String totalRate) {
		this.totalRate = totalRate;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param totalAvg
	 */
	public void setTotalAvg(String totalAvg) {
		this.totalAvg = totalAvg;
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
	 * @param overAvg
	 */
	public void setOverAvg(String overAvg) {
		this.overAvg = overAvg;
	}
	
	/**
	 * Column Info
	 * @param avg4
	 */
	public void setAvg4(String avg4) {
		this.avg4 = avg4;
	}
	
	/**
	 * Column Info
	 * @param avg5
	 */
	public void setAvg5(String avg5) {
		this.avg5 = avg5;
	}
	
	/**
	 * Column Info
	 * @param avg2
	 */
	public void setAvg2(String avg2) {
		this.avg2 = avg2;
	}
	
	/**
	 * Column Info
	 * @param avg3
	 */
	public void setAvg3(String avg3) {
		this.avg3 = avg3;
	}
	
	/**
	 * Column Info
	 * @param overRate
	 */
	public void setOverRate(String overRate) {
		this.overRate = overRate;
	}
	
	/**
	 * Column Info
	 * @param avg8
	 */
	public void setAvg8(String avg8) {
		this.avg8 = avg8;
	}
	
	/**
	 * Column Info
	 * @param avg9
	 */
	public void setAvg9(String avg9) {
		this.avg9 = avg9;
	}
	
	/**
	 * Column Info
	 * @param avg6
	 */
	public void setAvg6(String avg6) {
		this.avg6 = avg6;
	}
	
	/**
	 * Column Info
	 * @param avg7
	 */
	public void setAvg7(String avg7) {
		this.avg7 = avg7;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param rate11
	 */
	public void setRate11(String rate11) {
		this.rate11 = rate11;
	}
	
	/**
	 * Column Info
	 * @param avg13
	 */
	public void setAvg13(String avg13) {
		this.avg13 = avg13;
	}
	
	/**
	 * Column Info
	 * @param rate12
	 */
	public void setRate12(String rate12) {
		this.rate12 = rate12;
	}
	
	/**
	 * Column Info
	 * @param avg14
	 */
	public void setAvg14(String avg14) {
		this.avg14 = avg14;
	}
	
	/**
	 * Column Info
	 * @param qty1
	 */
	public void setQty1(String qty1) {
		this.qty1 = qty1;
	}
	
	/**
	 * Column Info
	 * @param rate13
	 */
	public void setRate13(String rate13) {
		this.rate13 = rate13;
	}
	
	/**
	 * Column Info
	 * @param avg15
	 */
	public void setAvg15(String avg15) {
		this.avg15 = avg15;
	}
	
	/**
	 * Column Info
	 * @param rate14
	 */
	public void setRate14(String rate14) {
		this.rate14 = rate14;
	}
	
	/**
	 * Column Info
	 * @param rate15
	 */
	public void setRate15(String rate15) {
		this.rate15 = rate15;
	}
	
	/**
	 * Column Info
	 * @param qty3
	 */
	public void setQty3(String qty3) {
		this.qty3 = qty3;
	}
	
	/**
	 * Column Info
	 * @param avg10
	 */
	public void setAvg10(String avg10) {
		this.avg10 = avg10;
	}
	
	/**
	 * Column Info
	 * @param qty2
	 */
	public void setQty2(String qty2) {
		this.qty2 = qty2;
	}
	
	/**
	 * Column Info
	 * @param avg11
	 */
	public void setAvg11(String avg11) {
		this.avg11 = avg11;
	}
	
	/**
	 * Column Info
	 * @param qty5
	 */
	public void setQty5(String qty5) {
		this.qty5 = qty5;
	}
	
	/**
	 * Column Info
	 * @param avg12
	 */
	public void setAvg12(String avg12) {
		this.avg12 = avg12;
	}
	
	/**
	 * Column Info
	 * @param qty4
	 */
	public void setQty4(String qty4) {
		this.qty4 = qty4;
	}
	
	/**
	 * Column Info
	 * @param rate4
	 */
	public void setRate4(String rate4) {
		this.rate4 = rate4;
	}
	
	/**
	 * Column Info
	 * @param rate5
	 */
	public void setRate5(String rate5) {
		this.rate5 = rate5;
	}
	
	/**
	 * Column Info
	 * @param rate6
	 */
	public void setRate6(String rate6) {
		this.rate6 = rate6;
	}
	
	/**
	 * Column Info
	 * @param rate7
	 */
	public void setRate7(String rate7) {
		this.rate7 = rate7;
	}
	
	/**
	 * Column Info
	 * @param rate1
	 */
	public void setRate1(String rate1) {
		this.rate1 = rate1;
	}
	
	/**
	 * Column Info
	 * @param rate2
	 */
	public void setRate2(String rate2) {
		this.rate2 = rate2;
	}
	
	/**
	 * Column Info
	 * @param rate3
	 */
	public void setRate3(String rate3) {
		this.rate3 = rate3;
	}
	
	/**
	 * Column Info
	 * @param stayDays11
	 */
	public void setStayDays11(String stayDays11) {
		this.stayDays11 = stayDays11;
	}
	
	/**
	 * Column Info
	 * @param stayDays12
	 */
	public void setStayDays12(String stayDays12) {
		this.stayDays12 = stayDays12;
	}
	
	/**
	 * Column Info
	 * @param stayDays13
	 */
	public void setStayDays13(String stayDays13) {
		this.stayDays13 = stayDays13;
	}
	
	/**
	 * Column Info
	 * @param stayDays14
	 */
	public void setStayDays14(String stayDays14) {
		this.stayDays14 = stayDays14;
	}
	
	/**
	 * Column Info
	 * @param stayDays15
	 */
	public void setStayDays15(String stayDays15) {
		this.stayDays15 = stayDays15;
	}
	
	/**
	 * Column Info
	 * @param rate8
	 */
	public void setRate8(String rate8) {
		this.rate8 = rate8;
	}
	
	/**
	 * Column Info
	 * @param rate9
	 */
	public void setRate9(String rate9) {
		this.rate9 = rate9;
	}
	
	/**
	 * Column Info
	 * @param avg1
	 */
	public void setAvg1(String avg1) {
		this.avg1 = avg1;
	}
	
	/**
	 * Column Info
	 * @param stayDays3
	 */
	public void setStayDays3(String stayDays3) {
		this.stayDays3 = stayDays3;
	}
	
	/**
	 * Column Info
	 * @param stayDays2
	 */
	public void setStayDays2(String stayDays2) {
		this.stayDays2 = stayDays2;
	}
	
	/**
	 * Column Info
	 * @param overStayDays
	 */
	public void setOverStayDays(String overStayDays) {
		this.overStayDays = overStayDays;
	}
	
	/**
	 * Column Info
	 * @param stayDays1
	 */
	public void setStayDays1(String stayDays1) {
		this.stayDays1 = stayDays1;
	}
	
	/**
	 * Column Info
	 * @param lvl
	 */
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	
	/**
	 * Column Info
	 * @param stayDays7
	 */
	public void setStayDays7(String stayDays7) {
		this.stayDays7 = stayDays7;
	}
	
	/**
	 * Column Info
	 * @param stayDays6
	 */
	public void setStayDays6(String stayDays6) {
		this.stayDays6 = stayDays6;
	}
	
	/**
	 * Column Info
	 * @param stayDays5
	 */
	public void setStayDays5(String stayDays5) {
		this.stayDays5 = stayDays5;
	}
	
	/**
	 * Column Info
	 * @param stayDays10
	 */
	public void setStayDays10(String stayDays10) {
		this.stayDays10 = stayDays10;
	}
	
	/**
	 * Column Info
	 * @param stayDays4
	 */
	public void setStayDays4(String stayDays4) {
		this.stayDays4 = stayDays4;
	}
	
	/**
	 * Column Info
	 * @param stayDays9
	 */
	public void setStayDays9(String stayDays9) {
		this.stayDays9 = stayDays9;
	}
	
	/**
	 * Column Info
	 * @param stayDays8
	 */
	public void setStayDays8(String stayDays8) {
		this.stayDays8 = stayDays8;
	}
	
	/**
	 * Column Info
	 * @param qty11
	 */
	public void setQty11(String qty11) {
		this.qty11 = qty11;
	}
	
	/**
	 * Column Info
	 * @param overQty
	 */
	public void setOverQty(String overQty) {
		this.overQty = overQty;
	}
	
	/**
	 * Column Info
	 * @param qty12
	 */
	public void setQty12(String qty12) {
		this.qty12 = qty12;
	}
	
	/**
	 * Column Info
	 * @param qty10
	 */
	public void setQty10(String qty10) {
		this.qty10 = qty10;
	}
	
	/**
	 * Column Info
	 * @param totalQty
	 */
	public void setTotalQty(String totalQty) {
		this.totalQty = totalQty;
	}
	
	/**
	 * Column Info
	 * @param qty15
	 */
	public void setQty15(String qty15) {
		this.qty15 = qty15;
	}
	
	/**
	 * Column Info
	 * @param dateStr
	 */
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	
	/**
	 * Column Info
	 * @param qty13
	 */
	public void setQty13(String qty13) {
		this.qty13 = qty13;
	}
	
	/**
	 * Column Info
	 * @param qty14
	 */
	public void setQty14(String qty14) {
		this.qty14 = qty14;
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
	 * @param qty8
	 */
	public void setQty8(String qty8) {
		this.qty8 = qty8;
	}
	
	/**
	 * Column Info
	 * @param qty9
	 */
	public void setQty9(String qty9) {
		this.qty9 = qty9;
	}
	
	/**
	 * Column Info
	 * @param qty6
	 */
	public void setQty6(String qty6) {
		this.qty6 = qty6;
	}
	
	/**
	 * Column Info
	 * @param qty7
	 */
	public void setQty7(String qty7) {
		this.qty7 = qty7;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param actQty
	 */
	public void setActQty(String actQty) {
		this.actQty = actQty;
	}
	
	/**
	 * Column Info
	 * @param rate10
	 */
	public void setRate10(String rate10) {
		this.rate10 = rate10;
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
		setTotalRate(JSPUtil.getParameter(request, prefix + "total_rate", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setTotalAvg(JSPUtil.getParameter(request, prefix + "total_avg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOverAvg(JSPUtil.getParameter(request, prefix + "over_avg", ""));
		setAvg4(JSPUtil.getParameter(request, prefix + "avg4", ""));
		setAvg5(JSPUtil.getParameter(request, prefix + "avg5", ""));
		setAvg2(JSPUtil.getParameter(request, prefix + "avg2", ""));
		setAvg3(JSPUtil.getParameter(request, prefix + "avg3", ""));
		setOverRate(JSPUtil.getParameter(request, prefix + "over_rate", ""));
		setAvg8(JSPUtil.getParameter(request, prefix + "avg8", ""));
		setAvg9(JSPUtil.getParameter(request, prefix + "avg9", ""));
		setAvg6(JSPUtil.getParameter(request, prefix + "avg6", ""));
		setAvg7(JSPUtil.getParameter(request, prefix + "avg7", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setRate11(JSPUtil.getParameter(request, prefix + "rate11", ""));
		setAvg13(JSPUtil.getParameter(request, prefix + "avg13", ""));
		setRate12(JSPUtil.getParameter(request, prefix + "rate12", ""));
		setAvg14(JSPUtil.getParameter(request, prefix + "avg14", ""));
		setQty1(JSPUtil.getParameter(request, prefix + "qty1", ""));
		setRate13(JSPUtil.getParameter(request, prefix + "rate13", ""));
		setAvg15(JSPUtil.getParameter(request, prefix + "avg15", ""));
		setRate14(JSPUtil.getParameter(request, prefix + "rate14", ""));
		setRate15(JSPUtil.getParameter(request, prefix + "rate15", ""));
		setQty3(JSPUtil.getParameter(request, prefix + "qty3", ""));
		setAvg10(JSPUtil.getParameter(request, prefix + "avg10", ""));
		setQty2(JSPUtil.getParameter(request, prefix + "qty2", ""));
		setAvg11(JSPUtil.getParameter(request, prefix + "avg11", ""));
		setQty5(JSPUtil.getParameter(request, prefix + "qty5", ""));
		setAvg12(JSPUtil.getParameter(request, prefix + "avg12", ""));
		setQty4(JSPUtil.getParameter(request, prefix + "qty4", ""));
		setRate4(JSPUtil.getParameter(request, prefix + "rate4", ""));
		setRate5(JSPUtil.getParameter(request, prefix + "rate5", ""));
		setRate6(JSPUtil.getParameter(request, prefix + "rate6", ""));
		setRate7(JSPUtil.getParameter(request, prefix + "rate7", ""));
		setRate1(JSPUtil.getParameter(request, prefix + "rate1", ""));
		setRate2(JSPUtil.getParameter(request, prefix + "rate2", ""));
		setRate3(JSPUtil.getParameter(request, prefix + "rate3", ""));
		setStayDays11(JSPUtil.getParameter(request, prefix + "stay_days11", ""));
		setStayDays12(JSPUtil.getParameter(request, prefix + "stay_days12", ""));
		setStayDays13(JSPUtil.getParameter(request, prefix + "stay_days13", ""));
		setStayDays14(JSPUtil.getParameter(request, prefix + "stay_days14", ""));
		setStayDays15(JSPUtil.getParameter(request, prefix + "stay_days15", ""));
		setRate8(JSPUtil.getParameter(request, prefix + "rate8", ""));
		setRate9(JSPUtil.getParameter(request, prefix + "rate9", ""));
		setAvg1(JSPUtil.getParameter(request, prefix + "avg1", ""));
		setStayDays3(JSPUtil.getParameter(request, prefix + "stay_days3", ""));
		setStayDays2(JSPUtil.getParameter(request, prefix + "stay_days2", ""));
		setOverStayDays(JSPUtil.getParameter(request, prefix + "over_stay_days", ""));
		setStayDays1(JSPUtil.getParameter(request, prefix + "stay_days1", ""));
		setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
		setStayDays7(JSPUtil.getParameter(request, prefix + "stay_days7", ""));
		setStayDays6(JSPUtil.getParameter(request, prefix + "stay_days6", ""));
		setStayDays5(JSPUtil.getParameter(request, prefix + "stay_days5", ""));
		setStayDays10(JSPUtil.getParameter(request, prefix + "stay_days10", ""));
		setStayDays4(JSPUtil.getParameter(request, prefix + "stay_days4", ""));
		setStayDays9(JSPUtil.getParameter(request, prefix + "stay_days9", ""));
		setStayDays8(JSPUtil.getParameter(request, prefix + "stay_days8", ""));
		setQty11(JSPUtil.getParameter(request, prefix + "qty11", ""));
		setOverQty(JSPUtil.getParameter(request, prefix + "over_qty", ""));
		setQty12(JSPUtil.getParameter(request, prefix + "qty12", ""));
		setQty10(JSPUtil.getParameter(request, prefix + "qty10", ""));
		setTotalQty(JSPUtil.getParameter(request, prefix + "total_qty", ""));
		setQty15(JSPUtil.getParameter(request, prefix + "qty15", ""));
		setDateStr(JSPUtil.getParameter(request, prefix + "date_str", ""));
		setQty13(JSPUtil.getParameter(request, prefix + "qty13", ""));
		setQty14(JSPUtil.getParameter(request, prefix + "qty14", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setQty8(JSPUtil.getParameter(request, prefix + "qty8", ""));
		setQty9(JSPUtil.getParameter(request, prefix + "qty9", ""));
		setQty6(JSPUtil.getParameter(request, prefix + "qty6", ""));
		setQty7(JSPUtil.getParameter(request, prefix + "qty7", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setActQty(JSPUtil.getParameter(request, prefix + "act_qty", ""));
		setRate10(JSPUtil.getParameter(request, prefix + "rate10", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OPInventoryForPseudoBookingSummayVO[]
	 */
	public OPInventoryForPseudoBookingSummayVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OPInventoryForPseudoBookingSummayVO[]
	 */
	public OPInventoryForPseudoBookingSummayVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OPInventoryForPseudoBookingSummayVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] totalRate = (JSPUtil.getParameter(request, prefix	+ "total_rate", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] totalAvg = (JSPUtil.getParameter(request, prefix	+ "total_avg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] overAvg = (JSPUtil.getParameter(request, prefix	+ "over_avg", length));
			String[] avg4 = (JSPUtil.getParameter(request, prefix	+ "avg4", length));
			String[] avg5 = (JSPUtil.getParameter(request, prefix	+ "avg5", length));
			String[] avg2 = (JSPUtil.getParameter(request, prefix	+ "avg2", length));
			String[] avg3 = (JSPUtil.getParameter(request, prefix	+ "avg3", length));
			String[] overRate = (JSPUtil.getParameter(request, prefix	+ "over_rate", length));
			String[] avg8 = (JSPUtil.getParameter(request, prefix	+ "avg8", length));
			String[] avg9 = (JSPUtil.getParameter(request, prefix	+ "avg9", length));
			String[] avg6 = (JSPUtil.getParameter(request, prefix	+ "avg6", length));
			String[] avg7 = (JSPUtil.getParameter(request, prefix	+ "avg7", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] rate11 = (JSPUtil.getParameter(request, prefix	+ "rate11", length));
			String[] avg13 = (JSPUtil.getParameter(request, prefix	+ "avg13", length));
			String[] rate12 = (JSPUtil.getParameter(request, prefix	+ "rate12", length));
			String[] avg14 = (JSPUtil.getParameter(request, prefix	+ "avg14", length));
			String[] qty1 = (JSPUtil.getParameter(request, prefix	+ "qty1", length));
			String[] rate13 = (JSPUtil.getParameter(request, prefix	+ "rate13", length));
			String[] avg15 = (JSPUtil.getParameter(request, prefix	+ "avg15", length));
			String[] rate14 = (JSPUtil.getParameter(request, prefix	+ "rate14", length));
			String[] rate15 = (JSPUtil.getParameter(request, prefix	+ "rate15", length));
			String[] qty3 = (JSPUtil.getParameter(request, prefix	+ "qty3", length));
			String[] avg10 = (JSPUtil.getParameter(request, prefix	+ "avg10", length));
			String[] qty2 = (JSPUtil.getParameter(request, prefix	+ "qty2", length));
			String[] avg11 = (JSPUtil.getParameter(request, prefix	+ "avg11", length));
			String[] qty5 = (JSPUtil.getParameter(request, prefix	+ "qty5", length));
			String[] avg12 = (JSPUtil.getParameter(request, prefix	+ "avg12", length));
			String[] qty4 = (JSPUtil.getParameter(request, prefix	+ "qty4", length));
			String[] rate4 = (JSPUtil.getParameter(request, prefix	+ "rate4", length));
			String[] rate5 = (JSPUtil.getParameter(request, prefix	+ "rate5", length));
			String[] rate6 = (JSPUtil.getParameter(request, prefix	+ "rate6", length));
			String[] rate7 = (JSPUtil.getParameter(request, prefix	+ "rate7", length));
			String[] rate1 = (JSPUtil.getParameter(request, prefix	+ "rate1", length));
			String[] rate2 = (JSPUtil.getParameter(request, prefix	+ "rate2", length));
			String[] rate3 = (JSPUtil.getParameter(request, prefix	+ "rate3", length));
			String[] stayDays11 = (JSPUtil.getParameter(request, prefix	+ "stay_days11", length));
			String[] stayDays12 = (JSPUtil.getParameter(request, prefix	+ "stay_days12", length));
			String[] stayDays13 = (JSPUtil.getParameter(request, prefix	+ "stay_days13", length));
			String[] stayDays14 = (JSPUtil.getParameter(request, prefix	+ "stay_days14", length));
			String[] stayDays15 = (JSPUtil.getParameter(request, prefix	+ "stay_days15", length));
			String[] rate8 = (JSPUtil.getParameter(request, prefix	+ "rate8", length));
			String[] rate9 = (JSPUtil.getParameter(request, prefix	+ "rate9", length));
			String[] avg1 = (JSPUtil.getParameter(request, prefix	+ "avg1", length));
			String[] stayDays3 = (JSPUtil.getParameter(request, prefix	+ "stay_days3", length));
			String[] stayDays2 = (JSPUtil.getParameter(request, prefix	+ "stay_days2", length));
			String[] overStayDays = (JSPUtil.getParameter(request, prefix	+ "over_stay_days", length));
			String[] stayDays1 = (JSPUtil.getParameter(request, prefix	+ "stay_days1", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] stayDays7 = (JSPUtil.getParameter(request, prefix	+ "stay_days7", length));
			String[] stayDays6 = (JSPUtil.getParameter(request, prefix	+ "stay_days6", length));
			String[] stayDays5 = (JSPUtil.getParameter(request, prefix	+ "stay_days5", length));
			String[] stayDays10 = (JSPUtil.getParameter(request, prefix	+ "stay_days10", length));
			String[] stayDays4 = (JSPUtil.getParameter(request, prefix	+ "stay_days4", length));
			String[] stayDays9 = (JSPUtil.getParameter(request, prefix	+ "stay_days9", length));
			String[] stayDays8 = (JSPUtil.getParameter(request, prefix	+ "stay_days8", length));
			String[] qty11 = (JSPUtil.getParameter(request, prefix	+ "qty11", length));
			String[] overQty = (JSPUtil.getParameter(request, prefix	+ "over_qty", length));
			String[] qty12 = (JSPUtil.getParameter(request, prefix	+ "qty12", length));
			String[] qty10 = (JSPUtil.getParameter(request, prefix	+ "qty10", length));
			String[] totalQty = (JSPUtil.getParameter(request, prefix	+ "total_qty", length));
			String[] qty15 = (JSPUtil.getParameter(request, prefix	+ "qty15", length));
			String[] dateStr = (JSPUtil.getParameter(request, prefix	+ "date_str", length));
			String[] qty13 = (JSPUtil.getParameter(request, prefix	+ "qty13", length));
			String[] qty14 = (JSPUtil.getParameter(request, prefix	+ "qty14", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] qty8 = (JSPUtil.getParameter(request, prefix	+ "qty8", length));
			String[] qty9 = (JSPUtil.getParameter(request, prefix	+ "qty9", length));
			String[] qty6 = (JSPUtil.getParameter(request, prefix	+ "qty6", length));
			String[] qty7 = (JSPUtil.getParameter(request, prefix	+ "qty7", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] actQty = (JSPUtil.getParameter(request, prefix	+ "act_qty", length));
			String[] rate10 = (JSPUtil.getParameter(request, prefix	+ "rate10", length));
			
			for (int i = 0; i < length; i++) {
				model = new OPInventoryForPseudoBookingSummayVO();
				if (totalRate[i] != null)
					model.setTotalRate(totalRate[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (totalAvg[i] != null)
					model.setTotalAvg(totalAvg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (overAvg[i] != null)
					model.setOverAvg(overAvg[i]);
				if (avg4[i] != null)
					model.setAvg4(avg4[i]);
				if (avg5[i] != null)
					model.setAvg5(avg5[i]);
				if (avg2[i] != null)
					model.setAvg2(avg2[i]);
				if (avg3[i] != null)
					model.setAvg3(avg3[i]);
				if (overRate[i] != null)
					model.setOverRate(overRate[i]);
				if (avg8[i] != null)
					model.setAvg8(avg8[i]);
				if (avg9[i] != null)
					model.setAvg9(avg9[i]);
				if (avg6[i] != null)
					model.setAvg6(avg6[i]);
				if (avg7[i] != null)
					model.setAvg7(avg7[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (rate11[i] != null)
					model.setRate11(rate11[i]);
				if (avg13[i] != null)
					model.setAvg13(avg13[i]);
				if (rate12[i] != null)
					model.setRate12(rate12[i]);
				if (avg14[i] != null)
					model.setAvg14(avg14[i]);
				if (qty1[i] != null)
					model.setQty1(qty1[i]);
				if (rate13[i] != null)
					model.setRate13(rate13[i]);
				if (avg15[i] != null)
					model.setAvg15(avg15[i]);
				if (rate14[i] != null)
					model.setRate14(rate14[i]);
				if (rate15[i] != null)
					model.setRate15(rate15[i]);
				if (qty3[i] != null)
					model.setQty3(qty3[i]);
				if (avg10[i] != null)
					model.setAvg10(avg10[i]);
				if (qty2[i] != null)
					model.setQty2(qty2[i]);
				if (avg11[i] != null)
					model.setAvg11(avg11[i]);
				if (qty5[i] != null)
					model.setQty5(qty5[i]);
				if (avg12[i] != null)
					model.setAvg12(avg12[i]);
				if (qty4[i] != null)
					model.setQty4(qty4[i]);
				if (rate4[i] != null)
					model.setRate4(rate4[i]);
				if (rate5[i] != null)
					model.setRate5(rate5[i]);
				if (rate6[i] != null)
					model.setRate6(rate6[i]);
				if (rate7[i] != null)
					model.setRate7(rate7[i]);
				if (rate1[i] != null)
					model.setRate1(rate1[i]);
				if (rate2[i] != null)
					model.setRate2(rate2[i]);
				if (rate3[i] != null)
					model.setRate3(rate3[i]);
				if (stayDays11[i] != null)
					model.setStayDays11(stayDays11[i]);
				if (stayDays12[i] != null)
					model.setStayDays12(stayDays12[i]);
				if (stayDays13[i] != null)
					model.setStayDays13(stayDays13[i]);
				if (stayDays14[i] != null)
					model.setStayDays14(stayDays14[i]);
				if (stayDays15[i] != null)
					model.setStayDays15(stayDays15[i]);
				if (rate8[i] != null)
					model.setRate8(rate8[i]);
				if (rate9[i] != null)
					model.setRate9(rate9[i]);
				if (avg1[i] != null)
					model.setAvg1(avg1[i]);
				if (stayDays3[i] != null)
					model.setStayDays3(stayDays3[i]);
				if (stayDays2[i] != null)
					model.setStayDays2(stayDays2[i]);
				if (overStayDays[i] != null)
					model.setOverStayDays(overStayDays[i]);
				if (stayDays1[i] != null)
					model.setStayDays1(stayDays1[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (stayDays7[i] != null)
					model.setStayDays7(stayDays7[i]);
				if (stayDays6[i] != null)
					model.setStayDays6(stayDays6[i]);
				if (stayDays5[i] != null)
					model.setStayDays5(stayDays5[i]);
				if (stayDays10[i] != null)
					model.setStayDays10(stayDays10[i]);
				if (stayDays4[i] != null)
					model.setStayDays4(stayDays4[i]);
				if (stayDays9[i] != null)
					model.setStayDays9(stayDays9[i]);
				if (stayDays8[i] != null)
					model.setStayDays8(stayDays8[i]);
				if (qty11[i] != null)
					model.setQty11(qty11[i]);
				if (overQty[i] != null)
					model.setOverQty(overQty[i]);
				if (qty12[i] != null)
					model.setQty12(qty12[i]);
				if (qty10[i] != null)
					model.setQty10(qty10[i]);
				if (totalQty[i] != null)
					model.setTotalQty(totalQty[i]);
				if (qty15[i] != null)
					model.setQty15(qty15[i]);
				if (dateStr[i] != null)
					model.setDateStr(dateStr[i]);
				if (qty13[i] != null)
					model.setQty13(qty13[i]);
				if (qty14[i] != null)
					model.setQty14(qty14[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (qty8[i] != null)
					model.setQty8(qty8[i]);
				if (qty9[i] != null)
					model.setQty9(qty9[i]);
				if (qty6[i] != null)
					model.setQty6(qty6[i]);
				if (qty7[i] != null)
					model.setQty7(qty7[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (actQty[i] != null)
					model.setActQty(actQty[i]);
				if (rate10[i] != null)
					model.setRate10(rate10[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOPInventoryForPseudoBookingSummayVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OPInventoryForPseudoBookingSummayVO[]
	 */
	public OPInventoryForPseudoBookingSummayVO[] getOPInventoryForPseudoBookingSummayVOs(){
		OPInventoryForPseudoBookingSummayVO[] vos = (OPInventoryForPseudoBookingSummayVO[])models.toArray(new OPInventoryForPseudoBookingSummayVO[models.size()]);
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
		this.totalRate = this.totalRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalAvg = this.totalAvg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overAvg = this.overAvg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avg4 = this.avg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avg5 = this.avg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avg2 = this.avg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avg3 = this.avg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overRate = this.overRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avg8 = this.avg8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avg9 = this.avg9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avg6 = this.avg6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avg7 = this.avg7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate11 = this.rate11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avg13 = this.avg13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate12 = this.rate12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avg14 = this.avg14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty1 = this.qty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate13 = this.rate13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avg15 = this.avg15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate14 = this.rate14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate15 = this.rate15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty3 = this.qty3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avg10 = this.avg10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty2 = this.qty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avg11 = this.avg11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty5 = this.qty5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avg12 = this.avg12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty4 = this.qty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate4 = this.rate4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate5 = this.rate5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate6 = this.rate6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate7 = this.rate7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate1 = this.rate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate2 = this.rate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate3 = this.rate3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays11 = this.stayDays11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays12 = this.stayDays12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays13 = this.stayDays13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays14 = this.stayDays14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays15 = this.stayDays15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate8 = this.rate8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate9 = this.rate9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avg1 = this.avg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays3 = this.stayDays3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays2 = this.stayDays2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overStayDays = this.overStayDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays1 = this.stayDays1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays7 = this.stayDays7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays6 = this.stayDays6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays5 = this.stayDays5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays10 = this.stayDays10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays4 = this.stayDays4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays9 = this.stayDays9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays8 = this.stayDays8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty11 = this.qty11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overQty = this.overQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty12 = this.qty12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty10 = this.qty10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalQty = this.totalQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty15 = this.qty15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateStr = this.dateStr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty13 = this.qty13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty14 = this.qty14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty8 = this.qty8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty9 = this.qty9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty6 = this.qty6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty7 = this.qty7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actQty = this.actQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate10 = this.rate10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
