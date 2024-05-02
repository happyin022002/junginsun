/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EqAverageUsingDayVO.java
*@FileTitle : EqAverageUsingDayVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.09.23 이호선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo;

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
 * @author 이호선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EqAverageUsingDayVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EqAverageUsingDayVO> models = new ArrayList<EqAverageUsingDayVO>();
	
	/* Column Info */
	private String cntrTpszCd14 = null;
	/* Column Info */
	private String cntrTpszCd15 = null;
	/* Column Info */
	private String cntrTpszCd16 = null;
	/* Column Info */
	private String cntrTpszCd17 = null;
	/* Column Info */
	private String reportType = null;
	/* Column Info */
	private String cntrTpszCd18 = null;
	/* Column Info */
	private String cntrTpszCd19 = null;
	/* Column Info */
	private String qty30 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String qty1 = null;
	/* Column Info */
	private String qty0 = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String qty3 = null;
	/* Column Info */
	private String cntrTpszCd11 = null;
	/* Column Info */
	private String totalCnt = null;
	/* Column Info */
	private String qty2 = null;
	/* Column Info */
	private String cntrTpszCd10 = null;
	/* Column Info */
	private String qty5 = null;
	/* Column Info */
	private String cntrTpszCd13 = null;
	/* Column Info */
	private String qty4 = null;
	/* Column Info */
	private String cntrTpszCd12 = null;
	/* Column Info */
	private String cntrTpszCd27 = null;
	/* Column Info */
	private String cntrTpszCd28 = null;
	/* Column Info */
	private String cntrTpszCd25 = null;
	/* Column Info */
	private String cntrTpszCd26 = null;
	/* Column Info */
	private String cntrTpszCd29 = null;
	/* Column Info */
	private String manYear = null;
	/* Column Info */
	private String cntrTpszCd20 = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String cntrTpszCd24 = null;
	/* Column Info */
	private String cntrTpszCd23 = null;
	/* Column Info */
	private String cntrTpszCd22 = null;
	/* Column Info */
	private String cntrTpszCd21 = null;
	/* Column Info */
	private String qty11 = null;
	/* Column Info */
	private String qty12 = null;
	/* Column Info */
	private String headCntrTpszCd = null;
	/* Column Info */
	private String qty10 = null;
	/* Column Info */
	private String div = null;
	/* Column Info */
	private String qty19 = null;
	/* Column Info */
	private String qty17 = null;
	/* Column Info */
	private String qty18 = null;
	/* Column Info */
	private String qty15 = null;
	/* Column Info */
	private String qty16 = null;
	/* Column Info */
	private String qty13 = null;
	/* Column Info */
	private String qty14 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String qtycnt = null;
	/* Column Info */
	private String man = null;
	/* Column Info */
	private String cntrTpszCd30 = null;
	/* Column Info */
	private String qty20 = null;
	/* Column Info */
	private String qty21 = null;
	/* Column Info */
	private String qty22 = null;
	/* Column Info */
	private String qty23 = null;
	/* Column Info */
	private String manNm = null;
	/* Column Info */
	private String qty8 = null;
	/* Column Info */
	private String qty9 = null;
	/* Column Info */
	private String qty6 = null;
	/* Column Info */
	private String qty7 = null;
	/* Column Info */
	private String qty28 = null;
	/* Column Info */
	private String qty29 = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String qty24 = null;
	/* Column Info */
	private String qty25 = null;
	/* Column Info */
	private String qty26 = null;
	/* Column Info */
	private String qty27 = null;
	/* Column Info */
	private String cntrTpszCd6 = null;
	/* Column Info */
	private String cntrTpszCd5 = null;
	/* Column Info */
	private String cntrTpszCd8 = null;
	/* Column Info */
	private String cntrTpszCd7 = null;
	/* Column Info */
	private String cntrTpszCd9 = null;
	/* Column Info */
	private String cntrTpszCd2 = null;
	/* Column Info */
	private String cntrTpszCd1 = null;
	/* Column Info */
	private String cntrTpszCd4 = null;
	/* Column Info */
	private String cntrTpszCd3 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EqAverageUsingDayVO() {}

	public EqAverageUsingDayVO(String ibflag, String pagerows, String cntrTpszCd14, String cntrTpszCd15, String cntrTpszCd16, String cntrTpszCd17, String reportType, String cntrTpszCd18, String cntrTpszCd19, String qty30, String cntrTpszCd, String qty1, String cntrTpszCd11, String qty3, String lstmCd, String cntrTpszCd10, String qty2, String totalCnt, String cntrTpszCd13, String qty5, String cntrTpszCd12, String qty4, String cntrTpszCd27, String cntrTpszCd28, String cntrTpszCd25, String cntrTpszCd26, String cntrTpszCd29, String manYear, String cntrTpszCd20, String vndrAbbrNm, String cntrTpszCd24, String cntrTpszCd23, String cntrTpszCd22, String cntrTpszCd21, String qty11, String qty12, String headCntrTpszCd, String qty10, String div, String qty19, String qty17, String qty18, String qty15, String qty16, String qty13, String qty14, String qtycnt, String man, String manNm, String cntrTpszCd30, String qty20, String qty21, String qty22, String qty23, String qty8, String qty9, String qty6, String qty7, String qty28, String qty29, String eqKndCd, String qty24, String qty25, String qty26, String qty27, String cntrTpszCd6, String cntrTpszCd5, String cntrTpszCd8, String cntrTpszCd7, String cntrTpszCd9, String cntrTpszCd2, String cntrTpszCd1, String cntrTpszCd4, String cntrTpszCd3, String qty0) {
		this.cntrTpszCd14 = cntrTpszCd14;
		this.cntrTpszCd15 = cntrTpszCd15;
		this.cntrTpszCd16 = cntrTpszCd16;
		this.cntrTpszCd17 = cntrTpszCd17;
		this.reportType = reportType;
		this.cntrTpszCd18 = cntrTpszCd18;
		this.cntrTpszCd19 = cntrTpszCd19;
		this.qty30 = qty30;
		this.pagerows = pagerows;
		this.cntrTpszCd = cntrTpszCd;
		this.qty1 = qty1;
		this.qty0 = qty0;
		this.lstmCd = lstmCd;
		this.qty3 = qty3;
		this.cntrTpszCd11 = cntrTpszCd11;
		this.totalCnt = totalCnt;
		this.qty2 = qty2;
		this.cntrTpszCd10 = cntrTpszCd10;
		this.qty5 = qty5;
		this.cntrTpszCd13 = cntrTpszCd13;
		this.qty4 = qty4;
		this.cntrTpszCd12 = cntrTpszCd12;
		this.cntrTpszCd27 = cntrTpszCd27;
		this.cntrTpszCd28 = cntrTpszCd28;
		this.cntrTpszCd25 = cntrTpszCd25;
		this.cntrTpszCd26 = cntrTpszCd26;
		this.cntrTpszCd29 = cntrTpszCd29;
		this.manYear = manYear;
		this.cntrTpszCd20 = cntrTpszCd20;
		this.vndrAbbrNm = vndrAbbrNm;
		this.cntrTpszCd24 = cntrTpszCd24;
		this.cntrTpszCd23 = cntrTpszCd23;
		this.cntrTpszCd22 = cntrTpszCd22;
		this.cntrTpszCd21 = cntrTpszCd21;
		this.qty11 = qty11;
		this.qty12 = qty12;
		this.headCntrTpszCd = headCntrTpszCd;
		this.qty10 = qty10;
		this.div = div;
		this.qty19 = qty19;
		this.qty17 = qty17;
		this.qty18 = qty18;
		this.qty15 = qty15;
		this.qty16 = qty16;
		this.qty13 = qty13;
		this.qty14 = qty14;
		this.ibflag = ibflag;
		this.qtycnt = qtycnt;
		this.man = man;
		this.cntrTpszCd30 = cntrTpszCd30;
		this.qty20 = qty20;
		this.qty21 = qty21;
		this.qty22 = qty22;
		this.qty23 = qty23;
		this.manNm = manNm;
		this.qty8 = qty8;
		this.qty9 = qty9;
		this.qty6 = qty6;
		this.qty7 = qty7;
		this.qty28 = qty28;
		this.qty29 = qty29;
		this.eqKndCd = eqKndCd;
		this.qty24 = qty24;
		this.qty25 = qty25;
		this.qty26 = qty26;
		this.qty27 = qty27;
		this.cntrTpszCd6 = cntrTpszCd6;
		this.cntrTpszCd5 = cntrTpszCd5;
		this.cntrTpszCd8 = cntrTpszCd8;
		this.cntrTpszCd7 = cntrTpszCd7;
		this.cntrTpszCd9 = cntrTpszCd9;
		this.cntrTpszCd2 = cntrTpszCd2;
		this.cntrTpszCd1 = cntrTpszCd1;
		this.cntrTpszCd4 = cntrTpszCd4;
		this.cntrTpszCd3 = cntrTpszCd3;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_tpsz_cd14", getCntrTpszCd14());
		this.hashColumns.put("cntr_tpsz_cd15", getCntrTpszCd15());
		this.hashColumns.put("cntr_tpsz_cd16", getCntrTpszCd16());
		this.hashColumns.put("cntr_tpsz_cd17", getCntrTpszCd17());
		this.hashColumns.put("report_type", getReportType());
		this.hashColumns.put("cntr_tpsz_cd18", getCntrTpszCd18());
		this.hashColumns.put("cntr_tpsz_cd19", getCntrTpszCd19());
		this.hashColumns.put("qty30", getQty30());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("qty1", getQty1());
		this.hashColumns.put("qty0", getQty0());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("qty3", getQty3());
		this.hashColumns.put("cntr_tpsz_cd11", getCntrTpszCd11());
		this.hashColumns.put("total_cnt", getTotalCnt());
		this.hashColumns.put("qty2", getQty2());
		this.hashColumns.put("cntr_tpsz_cd10", getCntrTpszCd10());
		this.hashColumns.put("qty5", getQty5());
		this.hashColumns.put("cntr_tpsz_cd13", getCntrTpszCd13());
		this.hashColumns.put("qty4", getQty4());
		this.hashColumns.put("cntr_tpsz_cd12", getCntrTpszCd12());
		this.hashColumns.put("cntr_tpsz_cd27", getCntrTpszCd27());
		this.hashColumns.put("cntr_tpsz_cd28", getCntrTpszCd28());
		this.hashColumns.put("cntr_tpsz_cd25", getCntrTpszCd25());
		this.hashColumns.put("cntr_tpsz_cd26", getCntrTpszCd26());
		this.hashColumns.put("cntr_tpsz_cd29", getCntrTpszCd29());
		this.hashColumns.put("man_year", getManYear());
		this.hashColumns.put("cntr_tpsz_cd20", getCntrTpszCd20());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("cntr_tpsz_cd24", getCntrTpszCd24());
		this.hashColumns.put("cntr_tpsz_cd23", getCntrTpszCd23());
		this.hashColumns.put("cntr_tpsz_cd22", getCntrTpszCd22());
		this.hashColumns.put("cntr_tpsz_cd21", getCntrTpszCd21());
		this.hashColumns.put("qty11", getQty11());
		this.hashColumns.put("qty12", getQty12());
		this.hashColumns.put("head_cntr_tpsz_cd", getHeadCntrTpszCd());
		this.hashColumns.put("qty10", getQty10());
		this.hashColumns.put("div", getDiv());
		this.hashColumns.put("qty19", getQty19());
		this.hashColumns.put("qty17", getQty17());
		this.hashColumns.put("qty18", getQty18());
		this.hashColumns.put("qty15", getQty15());
		this.hashColumns.put("qty16", getQty16());
		this.hashColumns.put("qty13", getQty13());
		this.hashColumns.put("qty14", getQty14());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("qtycnt", getQtycnt());
		this.hashColumns.put("man", getMan());
		this.hashColumns.put("cntr_tpsz_cd30", getCntrTpszCd30());
		this.hashColumns.put("qty20", getQty20());
		this.hashColumns.put("qty21", getQty21());
		this.hashColumns.put("qty22", getQty22());
		this.hashColumns.put("qty23", getQty23());
		this.hashColumns.put("man_nm", getManNm());
		this.hashColumns.put("qty8", getQty8());
		this.hashColumns.put("qty9", getQty9());
		this.hashColumns.put("qty6", getQty6());
		this.hashColumns.put("qty7", getQty7());
		this.hashColumns.put("qty28", getQty28());
		this.hashColumns.put("qty29", getQty29());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("qty24", getQty24());
		this.hashColumns.put("qty25", getQty25());
		this.hashColumns.put("qty26", getQty26());
		this.hashColumns.put("qty27", getQty27());
		this.hashColumns.put("cntr_tpsz_cd6", getCntrTpszCd6());
		this.hashColumns.put("cntr_tpsz_cd5", getCntrTpszCd5());
		this.hashColumns.put("cntr_tpsz_cd8", getCntrTpszCd8());
		this.hashColumns.put("cntr_tpsz_cd7", getCntrTpszCd7());
		this.hashColumns.put("cntr_tpsz_cd9", getCntrTpszCd9());
		this.hashColumns.put("cntr_tpsz_cd2", getCntrTpszCd2());
		this.hashColumns.put("cntr_tpsz_cd1", getCntrTpszCd1());
		this.hashColumns.put("cntr_tpsz_cd4", getCntrTpszCd4());
		this.hashColumns.put("cntr_tpsz_cd3", getCntrTpszCd3());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_tpsz_cd14", "cntrTpszCd14");
		this.hashFields.put("cntr_tpsz_cd15", "cntrTpszCd15");
		this.hashFields.put("cntr_tpsz_cd16", "cntrTpszCd16");
		this.hashFields.put("cntr_tpsz_cd17", "cntrTpszCd17");
		this.hashFields.put("report_type", "reportType");
		this.hashFields.put("cntr_tpsz_cd18", "cntrTpszCd18");
		this.hashFields.put("cntr_tpsz_cd19", "cntrTpszCd19");
		this.hashFields.put("qty30", "qty30");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("qty1", "qty1");
		this.hashFields.put("qty0", "qty0");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("qty3", "qty3");
		this.hashFields.put("cntr_tpsz_cd11", "cntrTpszCd11");
		this.hashFields.put("total_cnt", "totalCnt");
		this.hashFields.put("qty2", "qty2");
		this.hashFields.put("cntr_tpsz_cd10", "cntrTpszCd10");
		this.hashFields.put("qty5", "qty5");
		this.hashFields.put("cntr_tpsz_cd13", "cntrTpszCd13");
		this.hashFields.put("qty4", "qty4");
		this.hashFields.put("cntr_tpsz_cd12", "cntrTpszCd12");
		this.hashFields.put("cntr_tpsz_cd27", "cntrTpszCd27");
		this.hashFields.put("cntr_tpsz_cd28", "cntrTpszCd28");
		this.hashFields.put("cntr_tpsz_cd25", "cntrTpszCd25");
		this.hashFields.put("cntr_tpsz_cd26", "cntrTpszCd26");
		this.hashFields.put("cntr_tpsz_cd29", "cntrTpszCd29");
		this.hashFields.put("man_year", "manYear");
		this.hashFields.put("cntr_tpsz_cd20", "cntrTpszCd20");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("cntr_tpsz_cd24", "cntrTpszCd24");
		this.hashFields.put("cntr_tpsz_cd23", "cntrTpszCd23");
		this.hashFields.put("cntr_tpsz_cd22", "cntrTpszCd22");
		this.hashFields.put("cntr_tpsz_cd21", "cntrTpszCd21");
		this.hashFields.put("qty11", "qty11");
		this.hashFields.put("qty12", "qty12");
		this.hashFields.put("head_cntr_tpsz_cd", "headCntrTpszCd");
		this.hashFields.put("qty10", "qty10");
		this.hashFields.put("div", "div");
		this.hashFields.put("qty19", "qty19");
		this.hashFields.put("qty17", "qty17");
		this.hashFields.put("qty18", "qty18");
		this.hashFields.put("qty15", "qty15");
		this.hashFields.put("qty16", "qty16");
		this.hashFields.put("qty13", "qty13");
		this.hashFields.put("qty14", "qty14");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("qtycnt", "qtycnt");
		this.hashFields.put("man", "man");
		this.hashFields.put("cntr_tpsz_cd30", "cntrTpszCd30");
		this.hashFields.put("qty20", "qty20");
		this.hashFields.put("qty21", "qty21");
		this.hashFields.put("qty22", "qty22");
		this.hashFields.put("qty23", "qty23");
		this.hashFields.put("man_nm", "manNm");
		this.hashFields.put("qty8", "qty8");
		this.hashFields.put("qty9", "qty9");
		this.hashFields.put("qty6", "qty6");
		this.hashFields.put("qty7", "qty7");
		this.hashFields.put("qty28", "qty28");
		this.hashFields.put("qty29", "qty29");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("qty24", "qty24");
		this.hashFields.put("qty25", "qty25");
		this.hashFields.put("qty26", "qty26");
		this.hashFields.put("qty27", "qty27");
		this.hashFields.put("cntr_tpsz_cd6", "cntrTpszCd6");
		this.hashFields.put("cntr_tpsz_cd5", "cntrTpszCd5");
		this.hashFields.put("cntr_tpsz_cd8", "cntrTpszCd8");
		this.hashFields.put("cntr_tpsz_cd7", "cntrTpszCd7");
		this.hashFields.put("cntr_tpsz_cd9", "cntrTpszCd9");
		this.hashFields.put("cntr_tpsz_cd2", "cntrTpszCd2");
		this.hashFields.put("cntr_tpsz_cd1", "cntrTpszCd1");
		this.hashFields.put("cntr_tpsz_cd4", "cntrTpszCd4");
		this.hashFields.put("cntr_tpsz_cd3", "cntrTpszCd3");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd14
	 */
	public String getCntrTpszCd14() {
		return this.cntrTpszCd14;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd15
	 */
	public String getCntrTpszCd15() {
		return this.cntrTpszCd15;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd16
	 */
	public String getCntrTpszCd16() {
		return this.cntrTpszCd16;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd17
	 */
	public String getCntrTpszCd17() {
		return this.cntrTpszCd17;
	}
	
	/**
	 * Column Info
	 * @return reportType
	 */
	public String getReportType() {
		return this.reportType;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd18
	 */
	public String getCntrTpszCd18() {
		return this.cntrTpszCd18;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd19
	 */
	public String getCntrTpszCd19() {
		return this.cntrTpszCd19;
	}
	
	/**
	 * Column Info
	 * @return qty30
	 */
	public String getQty30() {
		return this.qty30;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return qty0
	 */
	public String getQty0() {
		return this.qty0;
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
	 * @return qty3
	 */
	public String getQty3() {
		return this.qty3;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd11
	 */
	public String getCntrTpszCd11() {
		return this.cntrTpszCd11;
	}
	
	/**
	 * Column Info
	 * @return totalCnt
	 */
	public String getTotalCnt() {
		return this.totalCnt;
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
	 * @return cntrTpszCd10
	 */
	public String getCntrTpszCd10() {
		return this.cntrTpszCd10;
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
	 * @return cntrTpszCd13
	 */
	public String getCntrTpszCd13() {
		return this.cntrTpszCd13;
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
	 * @return cntrTpszCd12
	 */
	public String getCntrTpszCd12() {
		return this.cntrTpszCd12;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd27
	 */
	public String getCntrTpszCd27() {
		return this.cntrTpszCd27;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd28
	 */
	public String getCntrTpszCd28() {
		return this.cntrTpszCd28;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd25
	 */
	public String getCntrTpszCd25() {
		return this.cntrTpszCd25;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd26
	 */
	public String getCntrTpszCd26() {
		return this.cntrTpszCd26;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd29
	 */
	public String getCntrTpszCd29() {
		return this.cntrTpszCd29;
	}
	
	/**
	 * Column Info
	 * @return manYear
	 */
	public String getManYear() {
		return this.manYear;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd20
	 */
	public String getCntrTpszCd20() {
		return this.cntrTpszCd20;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd24
	 */
	public String getCntrTpszCd24() {
		return this.cntrTpszCd24;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd23
	 */
	public String getCntrTpszCd23() {
		return this.cntrTpszCd23;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd22
	 */
	public String getCntrTpszCd22() {
		return this.cntrTpszCd22;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd21
	 */
	public String getCntrTpszCd21() {
		return this.cntrTpszCd21;
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
	 * @return qty12
	 */
	public String getQty12() {
		return this.qty12;
	}
	
	/**
	 * Column Info
	 * @return headCntrTpszCd
	 */
	public String getHeadCntrTpszCd() {
		return this.headCntrTpszCd;
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
	 * @return div
	 */
	public String getDiv() {
		return this.div;
	}
	
	/**
	 * Column Info
	 * @return qty19
	 */
	public String getQty19() {
		return this.qty19;
	}
	
	/**
	 * Column Info
	 * @return qty17
	 */
	public String getQty17() {
		return this.qty17;
	}
	
	/**
	 * Column Info
	 * @return qty18
	 */
	public String getQty18() {
		return this.qty18;
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
	 * @return qty16
	 */
	public String getQty16() {
		return this.qty16;
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
	 * @return qtycnt
	 */
	public String getQtycnt() {
		return this.qtycnt;
	}
	
	/**
	 * Column Info
	 * @return man
	 */
	public String getMan() {
		return this.man;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd30
	 */
	public String getCntrTpszCd30() {
		return this.cntrTpszCd30;
	}
	
	/**
	 * Column Info
	 * @return qty20
	 */
	public String getQty20() {
		return this.qty20;
	}
	
	/**
	 * Column Info
	 * @return qty21
	 */
	public String getQty21() {
		return this.qty21;
	}
	
	/**
	 * Column Info
	 * @return qty22
	 */
	public String getQty22() {
		return this.qty22;
	}
	
	/**
	 * Column Info
	 * @return qty23
	 */
	public String getQty23() {
		return this.qty23;
	}
	
	/**
	 * Column Info
	 * @return manNm
	 */
	public String getManNm() {
		return this.manNm;
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
	 * @return qty28
	 */
	public String getQty28() {
		return this.qty28;
	}
	
	/**
	 * Column Info
	 * @return qty29
	 */
	public String getQty29() {
		return this.qty29;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return qty24
	 */
	public String getQty24() {
		return this.qty24;
	}
	
	/**
	 * Column Info
	 * @return qty25
	 */
	public String getQty25() {
		return this.qty25;
	}
	
	/**
	 * Column Info
	 * @return qty26
	 */
	public String getQty26() {
		return this.qty26;
	}
	
	/**
	 * Column Info
	 * @return qty27
	 */
	public String getQty27() {
		return this.qty27;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd6
	 */
	public String getCntrTpszCd6() {
		return this.cntrTpszCd6;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd5
	 */
	public String getCntrTpszCd5() {
		return this.cntrTpszCd5;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd8
	 */
	public String getCntrTpszCd8() {
		return this.cntrTpszCd8;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd7
	 */
	public String getCntrTpszCd7() {
		return this.cntrTpszCd7;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd9
	 */
	public String getCntrTpszCd9() {
		return this.cntrTpszCd9;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd2
	 */
	public String getCntrTpszCd2() {
		return this.cntrTpszCd2;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd1
	 */
	public String getCntrTpszCd1() {
		return this.cntrTpszCd1;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd4
	 */
	public String getCntrTpszCd4() {
		return this.cntrTpszCd4;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd3
	 */
	public String getCntrTpszCd3() {
		return this.cntrTpszCd3;
	}
	

	/**
	 * Column Info
	 * @param cntrTpszCd14
	 */
	public void setCntrTpszCd14(String cntrTpszCd14) {
		this.cntrTpszCd14 = cntrTpszCd14;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd15
	 */
	public void setCntrTpszCd15(String cntrTpszCd15) {
		this.cntrTpszCd15 = cntrTpszCd15;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd16
	 */
	public void setCntrTpszCd16(String cntrTpszCd16) {
		this.cntrTpszCd16 = cntrTpszCd16;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd17
	 */
	public void setCntrTpszCd17(String cntrTpszCd17) {
		this.cntrTpszCd17 = cntrTpszCd17;
	}
	
	/**
	 * Column Info
	 * @param reportType
	 */
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd18
	 */
	public void setCntrTpszCd18(String cntrTpszCd18) {
		this.cntrTpszCd18 = cntrTpszCd18;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd19
	 */
	public void setCntrTpszCd19(String cntrTpszCd19) {
		this.cntrTpszCd19 = cntrTpszCd19;
	}
	
	/**
	 * Column Info
	 * @param qty30
	 */
	public void setQty30(String qty30) {
		this.qty30 = qty30;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param qty0
	 */
	public void setQty0(String qty0) {
		this.qty0 = qty0;
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
	 * @param qty3
	 */
	public void setQty3(String qty3) {
		this.qty3 = qty3;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd11
	 */
	public void setCntrTpszCd11(String cntrTpszCd11) {
		this.cntrTpszCd11 = cntrTpszCd11;
	}
	
	/**
	 * Column Info
	 * @param totalCnt
	 */
	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
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
	 * @param cntrTpszCd10
	 */
	public void setCntrTpszCd10(String cntrTpszCd10) {
		this.cntrTpszCd10 = cntrTpszCd10;
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
	 * @param cntrTpszCd13
	 */
	public void setCntrTpszCd13(String cntrTpszCd13) {
		this.cntrTpszCd13 = cntrTpszCd13;
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
	 * @param cntrTpszCd12
	 */
	public void setCntrTpszCd12(String cntrTpszCd12) {
		this.cntrTpszCd12 = cntrTpszCd12;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd27
	 */
	public void setCntrTpszCd27(String cntrTpszCd27) {
		this.cntrTpszCd27 = cntrTpszCd27;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd28
	 */
	public void setCntrTpszCd28(String cntrTpszCd28) {
		this.cntrTpszCd28 = cntrTpszCd28;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd25
	 */
	public void setCntrTpszCd25(String cntrTpszCd25) {
		this.cntrTpszCd25 = cntrTpszCd25;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd26
	 */
	public void setCntrTpszCd26(String cntrTpszCd26) {
		this.cntrTpszCd26 = cntrTpszCd26;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd29
	 */
	public void setCntrTpszCd29(String cntrTpszCd29) {
		this.cntrTpszCd29 = cntrTpszCd29;
	}
	
	/**
	 * Column Info
	 * @param manYear
	 */
	public void setManYear(String manYear) {
		this.manYear = manYear;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd20
	 */
	public void setCntrTpszCd20(String cntrTpszCd20) {
		this.cntrTpszCd20 = cntrTpszCd20;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd24
	 */
	public void setCntrTpszCd24(String cntrTpszCd24) {
		this.cntrTpszCd24 = cntrTpszCd24;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd23
	 */
	public void setCntrTpszCd23(String cntrTpszCd23) {
		this.cntrTpszCd23 = cntrTpszCd23;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd22
	 */
	public void setCntrTpszCd22(String cntrTpszCd22) {
		this.cntrTpszCd22 = cntrTpszCd22;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd21
	 */
	public void setCntrTpszCd21(String cntrTpszCd21) {
		this.cntrTpszCd21 = cntrTpszCd21;
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
	 * @param qty12
	 */
	public void setQty12(String qty12) {
		this.qty12 = qty12;
	}
	
	/**
	 * Column Info
	 * @param headCntrTpszCd
	 */
	public void setHeadCntrTpszCd(String headCntrTpszCd) {
		this.headCntrTpszCd = headCntrTpszCd;
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
	 * @param div
	 */
	public void setDiv(String div) {
		this.div = div;
	}
	
	/**
	 * Column Info
	 * @param qty19
	 */
	public void setQty19(String qty19) {
		this.qty19 = qty19;
	}
	
	/**
	 * Column Info
	 * @param qty17
	 */
	public void setQty17(String qty17) {
		this.qty17 = qty17;
	}
	
	/**
	 * Column Info
	 * @param qty18
	 */
	public void setQty18(String qty18) {
		this.qty18 = qty18;
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
	 * @param qty16
	 */
	public void setQty16(String qty16) {
		this.qty16 = qty16;
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
	 * @param qtycnt
	 */
	public void setQtycnt(String qtycnt) {
		this.qtycnt = qtycnt;
	}
	
	/**
	 * Column Info
	 * @param man
	 */
	public void setMan(String man) {
		this.man = man;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd30
	 */
	public void setCntrTpszCd30(String cntrTpszCd30) {
		this.cntrTpszCd30 = cntrTpszCd30;
	}
	
	/**
	 * Column Info
	 * @param qty20
	 */
	public void setQty20(String qty20) {
		this.qty20 = qty20;
	}
	
	/**
	 * Column Info
	 * @param qty21
	 */
	public void setQty21(String qty21) {
		this.qty21 = qty21;
	}
	
	/**
	 * Column Info
	 * @param qty22
	 */
	public void setQty22(String qty22) {
		this.qty22 = qty22;
	}
	
	/**
	 * Column Info
	 * @param qty23
	 */
	public void setQty23(String qty23) {
		this.qty23 = qty23;
	}
	
	/**
	 * Column Info
	 * @param manNm
	 */
	public void setManNm(String manNm) {
		this.manNm = manNm;
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
	 * @param qty28
	 */
	public void setQty28(String qty28) {
		this.qty28 = qty28;
	}
	
	/**
	 * Column Info
	 * @param qty29
	 */
	public void setQty29(String qty29) {
		this.qty29 = qty29;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param qty24
	 */
	public void setQty24(String qty24) {
		this.qty24 = qty24;
	}
	
	/**
	 * Column Info
	 * @param qty25
	 */
	public void setQty25(String qty25) {
		this.qty25 = qty25;
	}
	
	/**
	 * Column Info
	 * @param qty26
	 */
	public void setQty26(String qty26) {
		this.qty26 = qty26;
	}
	
	/**
	 * Column Info
	 * @param qty27
	 */
	public void setQty27(String qty27) {
		this.qty27 = qty27;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd6
	 */
	public void setCntrTpszCd6(String cntrTpszCd6) {
		this.cntrTpszCd6 = cntrTpszCd6;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd5
	 */
	public void setCntrTpszCd5(String cntrTpszCd5) {
		this.cntrTpszCd5 = cntrTpszCd5;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd8
	 */
	public void setCntrTpszCd8(String cntrTpszCd8) {
		this.cntrTpszCd8 = cntrTpszCd8;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd7
	 */
	public void setCntrTpszCd7(String cntrTpszCd7) {
		this.cntrTpszCd7 = cntrTpszCd7;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd9
	 */
	public void setCntrTpszCd9(String cntrTpszCd9) {
		this.cntrTpszCd9 = cntrTpszCd9;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd2
	 */
	public void setCntrTpszCd2(String cntrTpszCd2) {
		this.cntrTpszCd2 = cntrTpszCd2;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd1
	 */
	public void setCntrTpszCd1(String cntrTpszCd1) {
		this.cntrTpszCd1 = cntrTpszCd1;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd4
	 */
	public void setCntrTpszCd4(String cntrTpszCd4) {
		this.cntrTpszCd4 = cntrTpszCd4;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd3
	 */
	public void setCntrTpszCd3(String cntrTpszCd3) {
		this.cntrTpszCd3 = cntrTpszCd3;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrTpszCd14(JSPUtil.getParameter(request, "cntr_tpsz_cd14", ""));
		setCntrTpszCd15(JSPUtil.getParameter(request, "cntr_tpsz_cd15", ""));
		setCntrTpszCd16(JSPUtil.getParameter(request, "cntr_tpsz_cd16", ""));
		setCntrTpszCd17(JSPUtil.getParameter(request, "cntr_tpsz_cd17", ""));
		setReportType(JSPUtil.getParameter(request, "report_type", ""));
		setCntrTpszCd18(JSPUtil.getParameter(request, "cntr_tpsz_cd18", ""));
		setCntrTpszCd19(JSPUtil.getParameter(request, "cntr_tpsz_cd19", ""));
		setQty30(JSPUtil.getParameter(request, "qty30", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setQty1(JSPUtil.getParameter(request, "qty1", ""));
		setQty0(JSPUtil.getParameter(request, "qty0", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setQty3(JSPUtil.getParameter(request, "qty3", ""));
		setCntrTpszCd11(JSPUtil.getParameter(request, "cntr_tpsz_cd11", ""));
		setTotalCnt(JSPUtil.getParameter(request, "total_cnt", ""));
		setQty2(JSPUtil.getParameter(request, "qty2", ""));
		setCntrTpszCd10(JSPUtil.getParameter(request, "cntr_tpsz_cd10", ""));
		setQty5(JSPUtil.getParameter(request, "qty5", ""));
		setCntrTpszCd13(JSPUtil.getParameter(request, "cntr_tpsz_cd13", ""));
		setQty4(JSPUtil.getParameter(request, "qty4", ""));
		setCntrTpszCd12(JSPUtil.getParameter(request, "cntr_tpsz_cd12", ""));
		setCntrTpszCd27(JSPUtil.getParameter(request, "cntr_tpsz_cd27", ""));
		setCntrTpszCd28(JSPUtil.getParameter(request, "cntr_tpsz_cd28", ""));
		setCntrTpszCd25(JSPUtil.getParameter(request, "cntr_tpsz_cd25", ""));
		setCntrTpszCd26(JSPUtil.getParameter(request, "cntr_tpsz_cd26", ""));
		setCntrTpszCd29(JSPUtil.getParameter(request, "cntr_tpsz_cd29", ""));
		setManYear(JSPUtil.getParameter(request, "man_year", ""));
		setCntrTpszCd20(JSPUtil.getParameter(request, "cntr_tpsz_cd20", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setCntrTpszCd24(JSPUtil.getParameter(request, "cntr_tpsz_cd24", ""));
		setCntrTpszCd23(JSPUtil.getParameter(request, "cntr_tpsz_cd23", ""));
		setCntrTpszCd22(JSPUtil.getParameter(request, "cntr_tpsz_cd22", ""));
		setCntrTpszCd21(JSPUtil.getParameter(request, "cntr_tpsz_cd21", ""));
		setQty11(JSPUtil.getParameter(request, "qty11", ""));
		setQty12(JSPUtil.getParameter(request, "qty12", ""));
		setHeadCntrTpszCd(JSPUtil.getParameter(request, "head_cntr_tpsz_cd", ""));
		setQty10(JSPUtil.getParameter(request, "qty10", ""));
		setDiv(JSPUtil.getParameter(request, "div", ""));
		setQty19(JSPUtil.getParameter(request, "qty19", ""));
		setQty17(JSPUtil.getParameter(request, "qty17", ""));
		setQty18(JSPUtil.getParameter(request, "qty18", ""));
		setQty15(JSPUtil.getParameter(request, "qty15", ""));
		setQty16(JSPUtil.getParameter(request, "qty16", ""));
		setQty13(JSPUtil.getParameter(request, "qty13", ""));
		setQty14(JSPUtil.getParameter(request, "qty14", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setQtycnt(JSPUtil.getParameter(request, "qtycnt", ""));
		setMan(JSPUtil.getParameter(request, "man", ""));
		setCntrTpszCd30(JSPUtil.getParameter(request, "cntr_tpsz_cd30", ""));
		setQty20(JSPUtil.getParameter(request, "qty20", ""));
		setQty21(JSPUtil.getParameter(request, "qty21", ""));
		setQty22(JSPUtil.getParameter(request, "qty22", ""));
		setQty23(JSPUtil.getParameter(request, "qty23", ""));
		setManNm(JSPUtil.getParameter(request, "man_nm", ""));
		setQty8(JSPUtil.getParameter(request, "qty8", ""));
		setQty9(JSPUtil.getParameter(request, "qty9", ""));
		setQty6(JSPUtil.getParameter(request, "qty6", ""));
		setQty7(JSPUtil.getParameter(request, "qty7", ""));
		setQty28(JSPUtil.getParameter(request, "qty28", ""));
		setQty29(JSPUtil.getParameter(request, "qty29", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setQty24(JSPUtil.getParameter(request, "qty24", ""));
		setQty25(JSPUtil.getParameter(request, "qty25", ""));
		setQty26(JSPUtil.getParameter(request, "qty26", ""));
		setQty27(JSPUtil.getParameter(request, "qty27", ""));
		setCntrTpszCd6(JSPUtil.getParameter(request, "cntr_tpsz_cd6", ""));
		setCntrTpszCd5(JSPUtil.getParameter(request, "cntr_tpsz_cd5", ""));
		setCntrTpszCd8(JSPUtil.getParameter(request, "cntr_tpsz_cd8", ""));
		setCntrTpszCd7(JSPUtil.getParameter(request, "cntr_tpsz_cd7", ""));
		setCntrTpszCd9(JSPUtil.getParameter(request, "cntr_tpsz_cd9", ""));
		setCntrTpszCd2(JSPUtil.getParameter(request, "cntr_tpsz_cd2", ""));
		setCntrTpszCd1(JSPUtil.getParameter(request, "cntr_tpsz_cd1", ""));
		setCntrTpszCd4(JSPUtil.getParameter(request, "cntr_tpsz_cd4", ""));
		setCntrTpszCd3(JSPUtil.getParameter(request, "cntr_tpsz_cd3", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EqAverageUsingDayVO[]
	 */
	public EqAverageUsingDayVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EqAverageUsingDayVO[]
	 */
	public EqAverageUsingDayVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqAverageUsingDayVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrTpszCd14 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd14", length));
			String[] cntrTpszCd15 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd15", length));
			String[] cntrTpszCd16 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd16", length));
			String[] cntrTpszCd17 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd17", length));
			String[] reportType = (JSPUtil.getParameter(request, prefix	+ "report_type", length));
			String[] cntrTpszCd18 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd18", length));
			String[] cntrTpszCd19 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd19", length));
			String[] qty30 = (JSPUtil.getParameter(request, prefix	+ "qty30", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] qty1 = (JSPUtil.getParameter(request, prefix	+ "qty1", length));
			String[] qty0 = (JSPUtil.getParameter(request, prefix	+ "qty0", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] qty3 = (JSPUtil.getParameter(request, prefix	+ "qty3", length));
			String[] cntrTpszCd11 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd11", length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt", length));
			String[] qty2 = (JSPUtil.getParameter(request, prefix	+ "qty2", length));
			String[] cntrTpszCd10 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd10", length));
			String[] qty5 = (JSPUtil.getParameter(request, prefix	+ "qty5", length));
			String[] cntrTpszCd13 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd13", length));
			String[] qty4 = (JSPUtil.getParameter(request, prefix	+ "qty4", length));
			String[] cntrTpszCd12 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd12", length));
			String[] cntrTpszCd27 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd27", length));
			String[] cntrTpszCd28 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd28", length));
			String[] cntrTpszCd25 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd25", length));
			String[] cntrTpszCd26 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd26", length));
			String[] cntrTpszCd29 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd29", length));
			String[] manYear = (JSPUtil.getParameter(request, prefix	+ "man_year", length));
			String[] cntrTpszCd20 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd20", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] cntrTpszCd24 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd24", length));
			String[] cntrTpszCd23 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd23", length));
			String[] cntrTpszCd22 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd22", length));
			String[] cntrTpszCd21 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd21", length));
			String[] qty11 = (JSPUtil.getParameter(request, prefix	+ "qty11", length));
			String[] qty12 = (JSPUtil.getParameter(request, prefix	+ "qty12", length));
			String[] headCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "head_cntr_tpsz_cd", length));
			String[] qty10 = (JSPUtil.getParameter(request, prefix	+ "qty10", length));
			String[] div = (JSPUtil.getParameter(request, prefix	+ "div", length));
			String[] qty19 = (JSPUtil.getParameter(request, prefix	+ "qty19", length));
			String[] qty17 = (JSPUtil.getParameter(request, prefix	+ "qty17", length));
			String[] qty18 = (JSPUtil.getParameter(request, prefix	+ "qty18", length));
			String[] qty15 = (JSPUtil.getParameter(request, prefix	+ "qty15", length));
			String[] qty16 = (JSPUtil.getParameter(request, prefix	+ "qty16", length));
			String[] qty13 = (JSPUtil.getParameter(request, prefix	+ "qty13", length));
			String[] qty14 = (JSPUtil.getParameter(request, prefix	+ "qty14", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] qtycnt = (JSPUtil.getParameter(request, prefix	+ "qtycnt", length));
			String[] man = (JSPUtil.getParameter(request, prefix	+ "man", length));
			String[] cntrTpszCd30 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd30", length));
			String[] qty20 = (JSPUtil.getParameter(request, prefix	+ "qty20", length));
			String[] qty21 = (JSPUtil.getParameter(request, prefix	+ "qty21", length));
			String[] qty22 = (JSPUtil.getParameter(request, prefix	+ "qty22", length));
			String[] qty23 = (JSPUtil.getParameter(request, prefix	+ "qty23", length));
			String[] manNm = (JSPUtil.getParameter(request, prefix	+ "man_nm", length));
			String[] qty8 = (JSPUtil.getParameter(request, prefix	+ "qty8", length));
			String[] qty9 = (JSPUtil.getParameter(request, prefix	+ "qty9", length));
			String[] qty6 = (JSPUtil.getParameter(request, prefix	+ "qty6", length));
			String[] qty7 = (JSPUtil.getParameter(request, prefix	+ "qty7", length));
			String[] qty28 = (JSPUtil.getParameter(request, prefix	+ "qty28", length));
			String[] qty29 = (JSPUtil.getParameter(request, prefix	+ "qty29", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] qty24 = (JSPUtil.getParameter(request, prefix	+ "qty24", length));
			String[] qty25 = (JSPUtil.getParameter(request, prefix	+ "qty25", length));
			String[] qty26 = (JSPUtil.getParameter(request, prefix	+ "qty26", length));
			String[] qty27 = (JSPUtil.getParameter(request, prefix	+ "qty27", length));
			String[] cntrTpszCd6 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd6", length));
			String[] cntrTpszCd5 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd5", length));
			String[] cntrTpszCd8 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd8", length));
			String[] cntrTpszCd7 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd7", length));
			String[] cntrTpszCd9 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd9", length));
			String[] cntrTpszCd2 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd2", length));
			String[] cntrTpszCd1 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd1", length));
			String[] cntrTpszCd4 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd4", length));
			String[] cntrTpszCd3 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd3", length));
			
			for (int i = 0; i < length; i++) {
				model = new EqAverageUsingDayVO();
				if (cntrTpszCd14[i] != null)
					model.setCntrTpszCd14(cntrTpszCd14[i]);
				if (cntrTpszCd15[i] != null)
					model.setCntrTpszCd15(cntrTpszCd15[i]);
				if (cntrTpszCd16[i] != null)
					model.setCntrTpszCd16(cntrTpszCd16[i]);
				if (cntrTpszCd17[i] != null)
					model.setCntrTpszCd17(cntrTpszCd17[i]);
				if (reportType[i] != null)
					model.setReportType(reportType[i]);
				if (cntrTpszCd18[i] != null)
					model.setCntrTpszCd18(cntrTpszCd18[i]);
				if (cntrTpszCd19[i] != null)
					model.setCntrTpszCd19(cntrTpszCd19[i]);
				if (qty30[i] != null)
					model.setQty30(qty30[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (qty1[i] != null)
					model.setQty1(qty1[i]);
				if (qty0[i] != null)
					model.setQty0(qty0[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (qty3[i] != null)
					model.setQty3(qty3[i]);
				if (cntrTpszCd11[i] != null)
					model.setCntrTpszCd11(cntrTpszCd11[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				if (qty2[i] != null)
					model.setQty2(qty2[i]);
				if (cntrTpszCd10[i] != null)
					model.setCntrTpszCd10(cntrTpszCd10[i]);
				if (qty5[i] != null)
					model.setQty5(qty5[i]);
				if (cntrTpszCd13[i] != null)
					model.setCntrTpszCd13(cntrTpszCd13[i]);
				if (qty4[i] != null)
					model.setQty4(qty4[i]);
				if (cntrTpszCd12[i] != null)
					model.setCntrTpszCd12(cntrTpszCd12[i]);
				if (cntrTpszCd27[i] != null)
					model.setCntrTpszCd27(cntrTpszCd27[i]);
				if (cntrTpszCd28[i] != null)
					model.setCntrTpszCd28(cntrTpszCd28[i]);
				if (cntrTpszCd25[i] != null)
					model.setCntrTpszCd25(cntrTpszCd25[i]);
				if (cntrTpszCd26[i] != null)
					model.setCntrTpszCd26(cntrTpszCd26[i]);
				if (cntrTpszCd29[i] != null)
					model.setCntrTpszCd29(cntrTpszCd29[i]);
				if (manYear[i] != null)
					model.setManYear(manYear[i]);
				if (cntrTpszCd20[i] != null)
					model.setCntrTpszCd20(cntrTpszCd20[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (cntrTpszCd24[i] != null)
					model.setCntrTpszCd24(cntrTpszCd24[i]);
				if (cntrTpszCd23[i] != null)
					model.setCntrTpszCd23(cntrTpszCd23[i]);
				if (cntrTpszCd22[i] != null)
					model.setCntrTpszCd22(cntrTpszCd22[i]);
				if (cntrTpszCd21[i] != null)
					model.setCntrTpszCd21(cntrTpszCd21[i]);
				if (qty11[i] != null)
					model.setQty11(qty11[i]);
				if (qty12[i] != null)
					model.setQty12(qty12[i]);
				if (headCntrTpszCd[i] != null)
					model.setHeadCntrTpszCd(headCntrTpszCd[i]);
				if (qty10[i] != null)
					model.setQty10(qty10[i]);
				if (div[i] != null)
					model.setDiv(div[i]);
				if (qty19[i] != null)
					model.setQty19(qty19[i]);
				if (qty17[i] != null)
					model.setQty17(qty17[i]);
				if (qty18[i] != null)
					model.setQty18(qty18[i]);
				if (qty15[i] != null)
					model.setQty15(qty15[i]);
				if (qty16[i] != null)
					model.setQty16(qty16[i]);
				if (qty13[i] != null)
					model.setQty13(qty13[i]);
				if (qty14[i] != null)
					model.setQty14(qty14[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (qtycnt[i] != null)
					model.setQtycnt(qtycnt[i]);
				if (man[i] != null)
					model.setMan(man[i]);
				if (cntrTpszCd30[i] != null)
					model.setCntrTpszCd30(cntrTpszCd30[i]);
				if (qty20[i] != null)
					model.setQty20(qty20[i]);
				if (qty21[i] != null)
					model.setQty21(qty21[i]);
				if (qty22[i] != null)
					model.setQty22(qty22[i]);
				if (qty23[i] != null)
					model.setQty23(qty23[i]);
				if (manNm[i] != null)
					model.setManNm(manNm[i]);
				if (qty8[i] != null)
					model.setQty8(qty8[i]);
				if (qty9[i] != null)
					model.setQty9(qty9[i]);
				if (qty6[i] != null)
					model.setQty6(qty6[i]);
				if (qty7[i] != null)
					model.setQty7(qty7[i]);
				if (qty28[i] != null)
					model.setQty28(qty28[i]);
				if (qty29[i] != null)
					model.setQty29(qty29[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (qty24[i] != null)
					model.setQty24(qty24[i]);
				if (qty25[i] != null)
					model.setQty25(qty25[i]);
				if (qty26[i] != null)
					model.setQty26(qty26[i]);
				if (qty27[i] != null)
					model.setQty27(qty27[i]);
				if (cntrTpszCd6[i] != null)
					model.setCntrTpszCd6(cntrTpszCd6[i]);
				if (cntrTpszCd5[i] != null)
					model.setCntrTpszCd5(cntrTpszCd5[i]);
				if (cntrTpszCd8[i] != null)
					model.setCntrTpszCd8(cntrTpszCd8[i]);
				if (cntrTpszCd7[i] != null)
					model.setCntrTpszCd7(cntrTpszCd7[i]);
				if (cntrTpszCd9[i] != null)
					model.setCntrTpszCd9(cntrTpszCd9[i]);
				if (cntrTpszCd2[i] != null)
					model.setCntrTpszCd2(cntrTpszCd2[i]);
				if (cntrTpszCd1[i] != null)
					model.setCntrTpszCd1(cntrTpszCd1[i]);
				if (cntrTpszCd4[i] != null)
					model.setCntrTpszCd4(cntrTpszCd4[i]);
				if (cntrTpszCd3[i] != null)
					model.setCntrTpszCd3(cntrTpszCd3[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEqAverageUsingDayVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EqAverageUsingDayVO[]
	 */
	public EqAverageUsingDayVO[] getEqAverageUsingDayVOs(){
		EqAverageUsingDayVO[] vos = (EqAverageUsingDayVO[])models.toArray(new EqAverageUsingDayVO[models.size()]);
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
		this.cntrTpszCd14 = this.cntrTpszCd14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd15 = this.cntrTpszCd15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd16 = this.cntrTpszCd16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd17 = this.cntrTpszCd17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reportType = this.reportType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd18 = this.cntrTpszCd18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd19 = this.cntrTpszCd19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty30 = this.qty30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty1 = this.qty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty0 = this.qty0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty3 = this.qty3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd11 = this.cntrTpszCd11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty2 = this.qty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd10 = this.cntrTpszCd10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty5 = this.qty5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd13 = this.cntrTpszCd13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty4 = this.qty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd12 = this.cntrTpszCd12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd27 = this.cntrTpszCd27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd28 = this.cntrTpszCd28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd25 = this.cntrTpszCd25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd26 = this.cntrTpszCd26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd29 = this.cntrTpszCd29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manYear = this.manYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd20 = this.cntrTpszCd20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd24 = this.cntrTpszCd24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd23 = this.cntrTpszCd23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd22 = this.cntrTpszCd22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd21 = this.cntrTpszCd21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty11 = this.qty11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty12 = this.qty12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.headCntrTpszCd = this.headCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty10 = this.qty10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.div = this.div .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty19 = this.qty19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty17 = this.qty17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty18 = this.qty18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty15 = this.qty15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty16 = this.qty16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty13 = this.qty13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty14 = this.qty14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtycnt = this.qtycnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.man = this.man .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd30 = this.cntrTpszCd30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty20 = this.qty20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty21 = this.qty21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty22 = this.qty22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty23 = this.qty23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manNm = this.manNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty8 = this.qty8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty9 = this.qty9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty6 = this.qty6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty7 = this.qty7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty28 = this.qty28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty29 = this.qty29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty24 = this.qty24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty25 = this.qty25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty26 = this.qty26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty27 = this.qty27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd6 = this.cntrTpszCd6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd5 = this.cntrTpszCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd8 = this.cntrTpszCd8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd7 = this.cntrTpszCd7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd9 = this.cntrTpszCd9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd2 = this.cntrTpszCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd1 = this.cntrTpszCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd4 = this.cntrTpszCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd3 = this.cntrTpszCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
