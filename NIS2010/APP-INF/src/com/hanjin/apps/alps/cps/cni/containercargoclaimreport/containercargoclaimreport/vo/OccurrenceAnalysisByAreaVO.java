/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OccurrenceAnalysisByAreaVO.java
*@FileTitle : OccurrenceAnalysisByAreaVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2009.12.28 박제성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo;

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
 * @author 박제성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OccurrenceAnalysisByAreaVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OccurrenceAnalysisByAreaVO> models = new ArrayList<OccurrenceAnalysisByAreaVO>();
	
	/* Column Info */
	private String areaPctAmt4 = null;
	/* Column Info */
	private String areaPctAmt5 = null;
	/* Column Info */
	private String areaPctAmt6 = null;
	/* Column Info */
	private String areaPctAmt7 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String areaAmt6 = null;
	/* Column Info */
	private String areaAmt7 = null;
	/* Column Info */
	private String areaPctCase4 = null;
	/* Column Info */
	private String areaAmt5 = null;
	/* Column Info */
	private String areaPctCase5 = null;
	/* Column Info */
	private String areaPctCase6 = null;
	/* Column Info */
	private String areaPctCase7 = null;
	/* Column Info */
	private String areaAmt4 = null;
	/* Column Info */
	private String areaAmt3 = null;
	/* Column Info */
	private String areaAmt2 = null;
	/* Column Info */
	private String areaAmt1 = null;
	/* Column Info */
	private String areaAmt0 = null;
	/* Column Info */
	private String areaCase2 = null;
	/* Column Info */
	private String areaCase1 = null;
	/* Column Info */
	private String areaReportByNm = null;
	/* Column Info */
	private String areaCase4 = null;
	/* Column Info */
	private String areaCase3 = null;
	/* Column Info */
	private String areaCase0 = null;
	/* Column Info */
	private String areaCase6 = null;
	/* Column Info */
	private String areaCase7 = null;
	/* Column Info */
	private String areaPctCase1 = null;
	/* Column Info */
	private String areaReportByCd = null;
	/* Column Info */
	private String areaPctAmt3 = null;
	/* Column Info */
	private String areaPctCase0 = null;
	/* Column Info */
	private String areaPctAmt2 = null;
	/* Column Info */
	private String areaCase5 = null;
	/* Column Info */
	private String areaPctAmt1 = null;
	/* Column Info */
	private String areaPctCase3 = null;
	/* Column Info */
	private String areaPctAmt0 = null;
	/* Column Info */
	private String areaPctCase2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OccurrenceAnalysisByAreaVO() {}

	public OccurrenceAnalysisByAreaVO(String ibflag, String pagerows, String areaReportByCd, String areaReportByNm, String areaCase0, String areaPctCase0, String areaAmt0, String areaPctAmt0, String areaCase1, String areaPctCase1, String areaAmt1, String areaPctAmt1, String areaCase2, String areaPctCase2, String areaAmt2, String areaPctAmt2, String areaCase3, String areaPctCase3, String areaAmt3, String areaPctAmt3, String areaCase4, String areaPctCase4, String areaAmt4, String areaPctAmt4, String areaCase5, String areaPctCase5, String areaAmt5, String areaPctAmt5, String areaCase6, String areaCase7, String areaPctCase6, String areaPctCase7, String areaAmt6, String areaAmt7, String areaPctAmt6, String areaPctAmt7) {
		this.areaPctAmt4 = areaPctAmt4;
		this.areaPctAmt5 = areaPctAmt5;
		this.areaPctAmt6 = areaPctAmt6;
		this.areaPctAmt7 = areaPctAmt7;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.areaAmt6 = areaAmt6;
		this.areaAmt7 = areaAmt7;
		this.areaPctCase4 = areaPctCase4;
		this.areaAmt5 = areaAmt5;
		this.areaPctCase5 = areaPctCase5;
		this.areaPctCase6 = areaPctCase6;
		this.areaPctCase7 = areaPctCase7;
		this.areaAmt4 = areaAmt4;
		this.areaAmt3 = areaAmt3;
		this.areaAmt2 = areaAmt2;
		this.areaAmt1 = areaAmt1;
		this.areaAmt0 = areaAmt0;
		this.areaCase2 = areaCase2;
		this.areaCase1 = areaCase1;
		this.areaReportByNm = areaReportByNm;
		this.areaCase4 = areaCase4;
		this.areaCase3 = areaCase3;
		this.areaCase0 = areaCase0;
		this.areaCase6 = areaCase6;
		this.areaCase7 = areaCase7;
		this.areaPctCase1 = areaPctCase1;
		this.areaReportByCd = areaReportByCd;
		this.areaPctAmt3 = areaPctAmt3;
		this.areaPctCase0 = areaPctCase0;
		this.areaPctAmt2 = areaPctAmt2;
		this.areaCase5 = areaCase5;
		this.areaPctAmt1 = areaPctAmt1;
		this.areaPctCase3 = areaPctCase3;
		this.areaPctAmt0 = areaPctAmt0;
		this.areaPctCase2 = areaPctCase2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("area_pct_amt4", getAreaPctAmt4());
		this.hashColumns.put("area_pct_amt5", getAreaPctAmt5());
		this.hashColumns.put("area_pct_amt6", getAreaPctAmt6());
		this.hashColumns.put("area_pct_amt7", getAreaPctAmt7());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("area_amt6", getAreaAmt6());
		this.hashColumns.put("area_amt7", getAreaAmt7());
		this.hashColumns.put("area_pct_case4", getAreaPctCase4());
		this.hashColumns.put("area_amt5", getAreaAmt5());
		this.hashColumns.put("area_pct_case5", getAreaPctCase5());
		this.hashColumns.put("area_pct_case6", getAreaPctCase6());
		this.hashColumns.put("area_pct_case7", getAreaPctCase7());
		this.hashColumns.put("area_amt4", getAreaAmt4());
		this.hashColumns.put("area_amt3", getAreaAmt3());
		this.hashColumns.put("area_amt2", getAreaAmt2());
		this.hashColumns.put("area_amt1", getAreaAmt1());
		this.hashColumns.put("area_amt0", getAreaAmt0());
		this.hashColumns.put("area_case2", getAreaCase2());
		this.hashColumns.put("area_case1", getAreaCase1());
		this.hashColumns.put("area_report_by_nm", getAreaReportByNm());
		this.hashColumns.put("area_case4", getAreaCase4());
		this.hashColumns.put("area_case3", getAreaCase3());
		this.hashColumns.put("area_case0", getAreaCase0());
		this.hashColumns.put("area_case6", getAreaCase6());
		this.hashColumns.put("area_case7", getAreaCase7());
		this.hashColumns.put("area_pct_case1", getAreaPctCase1());
		this.hashColumns.put("area_report_by_cd", getAreaReportByCd());
		this.hashColumns.put("area_pct_amt3", getAreaPctAmt3());
		this.hashColumns.put("area_pct_case0", getAreaPctCase0());
		this.hashColumns.put("area_pct_amt2", getAreaPctAmt2());
		this.hashColumns.put("area_case5", getAreaCase5());
		this.hashColumns.put("area_pct_amt1", getAreaPctAmt1());
		this.hashColumns.put("area_pct_case3", getAreaPctCase3());
		this.hashColumns.put("area_pct_amt0", getAreaPctAmt0());
		this.hashColumns.put("area_pct_case2", getAreaPctCase2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("area_pct_amt4", "areaPctAmt4");
		this.hashFields.put("area_pct_amt5", "areaPctAmt5");
		this.hashFields.put("area_pct_amt6", "areaPctAmt6");
		this.hashFields.put("area_pct_amt7", "areaPctAmt7");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("area_amt6", "areaAmt6");
		this.hashFields.put("area_amt7", "areaAmt7");
		this.hashFields.put("area_pct_case4", "areaPctCase4");
		this.hashFields.put("area_amt5", "areaAmt5");
		this.hashFields.put("area_pct_case5", "areaPctCase5");
		this.hashFields.put("area_pct_case6", "areaPctCase6");
		this.hashFields.put("area_pct_case7", "areaPctCase7");
		this.hashFields.put("area_amt4", "areaAmt4");
		this.hashFields.put("area_amt3", "areaAmt3");
		this.hashFields.put("area_amt2", "areaAmt2");
		this.hashFields.put("area_amt1", "areaAmt1");
		this.hashFields.put("area_amt0", "areaAmt0");
		this.hashFields.put("area_case2", "areaCase2");
		this.hashFields.put("area_case1", "areaCase1");
		this.hashFields.put("area_report_by_nm", "areaReportByNm");
		this.hashFields.put("area_case4", "areaCase4");
		this.hashFields.put("area_case3", "areaCase3");
		this.hashFields.put("area_case0", "areaCase0");
		this.hashFields.put("area_case6", "areaCase6");
		this.hashFields.put("area_case7", "areaCase7");
		this.hashFields.put("area_pct_case1", "areaPctCase1");
		this.hashFields.put("area_report_by_cd", "areaReportByCd");
		this.hashFields.put("area_pct_amt3", "areaPctAmt3");
		this.hashFields.put("area_pct_case0", "areaPctCase0");
		this.hashFields.put("area_pct_amt2", "areaPctAmt2");
		this.hashFields.put("area_case5", "areaCase5");
		this.hashFields.put("area_pct_amt1", "areaPctAmt1");
		this.hashFields.put("area_pct_case3", "areaPctCase3");
		this.hashFields.put("area_pct_amt0", "areaPctAmt0");
		this.hashFields.put("area_pct_case2", "areaPctCase2");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return areaPctAmt4
	 */
	public String getAreaPctAmt4() {
		return this.areaPctAmt4;
	}
	
	/**
	 * Column Info
	 * @return areaPctAmt5
	 */
	public String getAreaPctAmt5() {
		return this.areaPctAmt5;
	}
	
	/**
	 * Column Info
	 * @return areaPctAmt6
	 */
	public String getAreaPctAmt6() {
		return this.areaPctAmt6;
	}
	
	/**
	 * Column Info
	 * @return areaPctAmt7
	 */
	public String getAreaPctAmt7() {
		return this.areaPctAmt7;
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
	 * @return areaAmt6
	 */
	public String getAreaAmt6() {
		return this.areaAmt6;
	}
	
	/**
	 * Column Info
	 * @return areaAmt7
	 */
	public String getAreaAmt7() {
		return this.areaAmt7;
	}
	
	/**
	 * Column Info
	 * @return areaPctCase4
	 */
	public String getAreaPctCase4() {
		return this.areaPctCase4;
	}
	
	/**
	 * Column Info
	 * @return areaAmt5
	 */
	public String getAreaAmt5() {
		return this.areaAmt5;
	}
	
	/**
	 * Column Info
	 * @return areaPctCase5
	 */
	public String getAreaPctCase5() {
		return this.areaPctCase5;
	}
	
	/**
	 * Column Info
	 * @return areaPctCase6
	 */
	public String getAreaPctCase6() {
		return this.areaPctCase6;
	}
	
	/**
	 * Column Info
	 * @return areaPctCase7
	 */
	public String getAreaPctCase7() {
		return this.areaPctCase7;
	}
	/**
	 * Column Info
	 * @return areaAmt4
	 */
	public String getAreaAmt4() {
		return this.areaAmt4;
	}
	
	/**
	 * Column Info
	 * @return areaAmt3
	 */
	public String getAreaAmt3() {
		return this.areaAmt3;
	}
	
	/**
	 * Column Info
	 * @return areaAmt2
	 */
	public String getAreaAmt2() {
		return this.areaAmt2;
	}
	
	/**
	 * Column Info
	 * @return areaAmt1
	 */
	public String getAreaAmt1() {
		return this.areaAmt1;
	}
	
	/**
	 * Column Info
	 * @return areaAmt0
	 */
	public String getAreaAmt0() {
		return this.areaAmt0;
	}
	
	/**
	 * Column Info
	 * @return areaCase2
	 */
	public String getAreaCase2() {
		return this.areaCase2;
	}
	
	/**
	 * Column Info
	 * @return areaCase1
	 */
	public String getAreaCase1() {
		return this.areaCase1;
	}
	
	/**
	 * Column Info
	 * @return areaReportByNm
	 */
	public String getAreaReportByNm() {
		return this.areaReportByNm;
	}
	
	/**
	 * Column Info
	 * @return areaCase4
	 */
	public String getAreaCase4() {
		return this.areaCase4;
	}
	
	/**
	 * Column Info
	 * @return areaCase3
	 */
	public String getAreaCase3() {
		return this.areaCase3;
	}
	
	/**
	 * Column Info
	 * @return areaCase0
	 */
	public String getAreaCase0() {
		return this.areaCase0;
	}
	
	/**
	 * Column Info
	 * @return areaCase6
	 */
	public String getAreaCase6() {
		return this.areaCase6;
	}
	
	/**
	 * Column Info
	 * @return areaCase7
	 */
	public String getAreaCase7() {
		return this.areaCase7;
	}
	
	/**
	 * Column Info
	 * @return areaPctCase1
	 */
	public String getAreaPctCase1() {
		return this.areaPctCase1;
	}
	
	/**
	 * Column Info
	 * @return areaReportByCd
	 */
	public String getAreaReportByCd() {
		return this.areaReportByCd;
	}
	
	/**
	 * Column Info
	 * @return areaPctAmt3
	 */
	public String getAreaPctAmt3() {
		return this.areaPctAmt3;
	}
	
	/**
	 * Column Info
	 * @return areaPctCase0
	 */
	public String getAreaPctCase0() {
		return this.areaPctCase0;
	}
	
	/**
	 * Column Info
	 * @return areaPctAmt2
	 */
	public String getAreaPctAmt2() {
		return this.areaPctAmt2;
	}
	
	/**
	 * Column Info
	 * @return areaCase5
	 */
	public String getAreaCase5() {
		return this.areaCase5;
	}
	
	/**
	 * Column Info
	 * @return areaPctAmt1
	 */
	public String getAreaPctAmt1() {
		return this.areaPctAmt1;
	}
	
	/**
	 * Column Info
	 * @return areaPctCase3
	 */
	public String getAreaPctCase3() {
		return this.areaPctCase3;
	}
	
	/**
	 * Column Info
	 * @return areaPctAmt0
	 */
	public String getAreaPctAmt0() {
		return this.areaPctAmt0;
	}
	
	/**
	 * Column Info
	 * @return areaPctCase2
	 */
	public String getAreaPctCase2() {
		return this.areaPctCase2;
	}
	

	/**
	 * Column Info
	 * @param areaPctAmt4
	 */
	public void setAreaPctAmt4(String areaPctAmt4) {
		this.areaPctAmt4 = areaPctAmt4;
	}
	
	/**
	 * Column Info
	 * @param areaPctAmt5
	 */
	public void setAreaPctAmt5(String areaPctAmt5) {
		this.areaPctAmt5 = areaPctAmt5;
	}
	
	/**
	 * Column Info
	 * @param areaPctAmt6
	 */
	public void setAreaPctAmt6(String areaPctAmt6) {
		this.areaPctAmt6 = areaPctAmt6;
	}
	
	/**
	 * Column Info
	 * @param areaPctAmt7
	 */
	public void setAreaPctAmt7(String areaPctAmt7) {
		this.areaPctAmt7 = areaPctAmt7;
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
	 * @param areaAmt6
	 */
	public void setAreaAmt6(String areaAmt6) {
		this.areaAmt6 = areaAmt6;
	}
	
	/**
	 * Column Info
	 * @param areaAmt7
	 */
	public void setAreaAmt7(String areaAmt7) {
		this.areaAmt7 = areaAmt7;
	}
	
	/**
	 * Column Info
	 * @param areaPctCase4
	 */
	public void setAreaPctCase4(String areaPctCase4) {
		this.areaPctCase4 = areaPctCase4;
	}
	
	/**
	 * Column Info
	 * @param areaAmt5
	 */
	public void setAreaAmt5(String areaAmt5) {
		this.areaAmt5 = areaAmt5;
	}
	
	/**
	 * Column Info
	 * @param areaPctCase5
	 */
	public void setAreaPctCase5(String areaPctCase5) {
		this.areaPctCase5 = areaPctCase5;
	}
	
	/**
	 * Column Info
	 * @param areaPctCase6
	 */
	public void setAreaPctCase6(String areaPctCase6) {
		this.areaPctCase6 = areaPctCase6;
	}
	
	/**
	 * Column Info
	 * @param areaPctCase7
	 */
	public void setAreaPctCase7(String areaPctCase7) {
		this.areaPctCase7 = areaPctCase7;
	}
	
	/**
	 * Column Info
	 * @param areaAmt4
	 */
	public void setAreaAmt4(String areaAmt4) {
		this.areaAmt4 = areaAmt4;
	}
	
	/**
	 * Column Info
	 * @param areaAmt3
	 */
	public void setAreaAmt3(String areaAmt3) {
		this.areaAmt3 = areaAmt3;
	}
	
	/**
	 * Column Info
	 * @param areaAmt2
	 */
	public void setAreaAmt2(String areaAmt2) {
		this.areaAmt2 = areaAmt2;
	}
	
	/**
	 * Column Info
	 * @param areaAmt1
	 */
	public void setAreaAmt1(String areaAmt1) {
		this.areaAmt1 = areaAmt1;
	}
	
	/**
	 * Column Info
	 * @param areaAmt0
	 */
	public void setAreaAmt0(String areaAmt0) {
		this.areaAmt0 = areaAmt0;
	}
	
	/**
	 * Column Info
	 * @param areaCase2
	 */
	public void setAreaCase2(String areaCase2) {
		this.areaCase2 = areaCase2;
	}
	
	/**
	 * Column Info
	 * @param areaCase1
	 */
	public void setAreaCase1(String areaCase1) {
		this.areaCase1 = areaCase1;
	}
	
	/**
	 * Column Info
	 * @param areaReportByNm
	 */
	public void setAreaReportByNm(String areaReportByNm) {
		this.areaReportByNm = areaReportByNm;
	}
	
	/**
	 * Column Info
	 * @param areaCase4
	 */
	public void setAreaCase4(String areaCase4) {
		this.areaCase4 = areaCase4;
	}
	
	/**
	 * Column Info
	 * @param areaCase3
	 */
	public void setAreaCase3(String areaCase3) {
		this.areaCase3 = areaCase3;
	}
	
	/**
	 * Column Info
	 * @param areaCase0
	 */
	public void setAreaCase0(String areaCase0) {
		this.areaCase0 = areaCase0;
	}
	
	/**
	 * Column Info
	 * @param areaCase6
	 */
	public void setAreaCase6(String areaCase6) {
		this.areaCase6 = areaCase6;
	}
	
	/**
	 * Column Info
	 * @param areaCase7
	 */
	public void setAreaCase7(String areaCase7) {
		this.areaCase7 = areaCase7;
	}
	
	/**
	 * Column Info
	 * @param areaPctCase1
	 */
	public void setAreaPctCase1(String areaPctCase1) {
		this.areaPctCase1 = areaPctCase1;
	}
	
	/**
	 * Column Info
	 * @param areaReportByCd
	 */
	public void setAreaReportByCd(String areaReportByCd) {
		this.areaReportByCd = areaReportByCd;
	}
	
	/**
	 * Column Info
	 * @param areaPctAmt3
	 */
	public void setAreaPctAmt3(String areaPctAmt3) {
		this.areaPctAmt3 = areaPctAmt3;
	}
	
	/**
	 * Column Info
	 * @param areaPctCase0
	 */
	public void setAreaPctCase0(String areaPctCase0) {
		this.areaPctCase0 = areaPctCase0;
	}
	
	/**
	 * Column Info
	 * @param areaPctAmt2
	 */
	public void setAreaPctAmt2(String areaPctAmt2) {
		this.areaPctAmt2 = areaPctAmt2;
	}
	
	/**
	 * Column Info
	 * @param areaCase5
	 */
	public void setAreaCase5(String areaCase5) {
		this.areaCase5 = areaCase5;
	}
	
	/**
	 * Column Info
	 * @param areaPctAmt1
	 */
	public void setAreaPctAmt1(String areaPctAmt1) {
		this.areaPctAmt1 = areaPctAmt1;
	}
	
	/**
	 * Column Info
	 * @param areaPctCase3
	 */
	public void setAreaPctCase3(String areaPctCase3) {
		this.areaPctCase3 = areaPctCase3;
	}
	
	/**
	 * Column Info
	 * @param areaPctAmt0
	 */
	public void setAreaPctAmt0(String areaPctAmt0) {
		this.areaPctAmt0 = areaPctAmt0;
	}
	
	/**
	 * Column Info
	 * @param areaPctCase2
	 */
	public void setAreaPctCase2(String areaPctCase2) {
		this.areaPctCase2 = areaPctCase2;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAreaPctAmt4(JSPUtil.getParameter(request, "area_pct_amt4", ""));
		setAreaPctAmt5(JSPUtil.getParameter(request, "area_pct_amt5", ""));
		setAreaPctAmt6(JSPUtil.getParameter(request, "area_pct_amt6", ""));
		setAreaPctAmt7(JSPUtil.getParameter(request, "area_pct_amt7", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAreaAmt6(JSPUtil.getParameter(request, "area_amt6", ""));
		setAreaAmt7(JSPUtil.getParameter(request, "area_amt7", ""));
		setAreaPctCase4(JSPUtil.getParameter(request, "area_pct_case4", ""));
		setAreaAmt5(JSPUtil.getParameter(request, "area_amt5", ""));
		setAreaPctCase5(JSPUtil.getParameter(request, "area_pct_case5", ""));
		setAreaPctCase6(JSPUtil.getParameter(request, "area_pct_case6", ""));
		setAreaPctCase7(JSPUtil.getParameter(request, "area_pct_case7", ""));
		setAreaAmt4(JSPUtil.getParameter(request, "area_amt4", ""));
		setAreaAmt3(JSPUtil.getParameter(request, "area_amt3", ""));
		setAreaAmt2(JSPUtil.getParameter(request, "area_amt2", ""));
		setAreaAmt1(JSPUtil.getParameter(request, "area_amt1", ""));
		setAreaAmt0(JSPUtil.getParameter(request, "area_amt0", ""));
		setAreaCase2(JSPUtil.getParameter(request, "area_case2", ""));
		setAreaCase1(JSPUtil.getParameter(request, "area_case1", ""));
		setAreaReportByNm(JSPUtil.getParameter(request, "area_report_by_nm", ""));
		setAreaCase4(JSPUtil.getParameter(request, "area_case4", ""));
		setAreaCase3(JSPUtil.getParameter(request, "area_case3", ""));
		setAreaCase0(JSPUtil.getParameter(request, "area_case0", ""));
		setAreaCase6(JSPUtil.getParameter(request, "area_case6", ""));
		setAreaCase7(JSPUtil.getParameter(request, "area_case7", ""));
		setAreaPctCase1(JSPUtil.getParameter(request, "area_pct_case1", ""));
		setAreaReportByCd(JSPUtil.getParameter(request, "area_report_by_cd", ""));
		setAreaPctAmt3(JSPUtil.getParameter(request, "area_pct_amt3", ""));
		setAreaPctCase0(JSPUtil.getParameter(request, "area_pct_case0", ""));
		setAreaPctAmt2(JSPUtil.getParameter(request, "area_pct_amt2", ""));
		setAreaCase5(JSPUtil.getParameter(request, "area_case5", ""));
		setAreaPctAmt1(JSPUtil.getParameter(request, "area_pct_amt1", ""));
		setAreaPctCase3(JSPUtil.getParameter(request, "area_pct_case3", ""));
		setAreaPctAmt0(JSPUtil.getParameter(request, "area_pct_amt0", ""));
		setAreaPctCase2(JSPUtil.getParameter(request, "area_pct_case2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OccurrenceAnalysisByAreaVO[]
	 */
	public OccurrenceAnalysisByAreaVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OccurrenceAnalysisByAreaVO[]
	 */
	public OccurrenceAnalysisByAreaVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OccurrenceAnalysisByAreaVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] areaPctAmt4 = (JSPUtil.getParameter(request, prefix	+ "area_pct_amt4", length));
			String[] areaPctAmt5 = (JSPUtil.getParameter(request, prefix	+ "area_pct_amt5", length));
			String[] areaPctAmt6 = (JSPUtil.getParameter(request, prefix	+ "area_pct_amt6", length));
			String[] areaPctAmt7 = (JSPUtil.getParameter(request, prefix	+ "area_pct_amt7", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] areaAmt6 = (JSPUtil.getParameter(request, prefix	+ "area_amt6", length));
			String[] areaAmt7 = (JSPUtil.getParameter(request, prefix	+ "area_amt7", length));
			String[] areaPctCase4 = (JSPUtil.getParameter(request, prefix	+ "area_pct_case4", length));
			String[] areaAmt5 = (JSPUtil.getParameter(request, prefix	+ "area_amt5", length));
			String[] areaPctCase5 = (JSPUtil.getParameter(request, prefix	+ "area_pct_case5", length));
			String[] areaPctCase6 = (JSPUtil.getParameter(request, prefix	+ "area_pct_case6", length));
			String[] areaPctCase7 = (JSPUtil.getParameter(request, prefix	+ "area_pct_case7", length));
			String[] areaAmt4 = (JSPUtil.getParameter(request, prefix	+ "area_amt4", length));
			String[] areaAmt3 = (JSPUtil.getParameter(request, prefix	+ "area_amt3", length));
			String[] areaAmt2 = (JSPUtil.getParameter(request, prefix	+ "area_amt2", length));
			String[] areaAmt1 = (JSPUtil.getParameter(request, prefix	+ "area_amt1", length));
			String[] areaAmt0 = (JSPUtil.getParameter(request, prefix	+ "area_amt0", length));
			String[] areaCase2 = (JSPUtil.getParameter(request, prefix	+ "area_case2", length));
			String[] areaCase1 = (JSPUtil.getParameter(request, prefix	+ "area_case1", length));
			String[] areaReportByNm = (JSPUtil.getParameter(request, prefix	+ "area_report_by_nm", length));
			String[] areaCase4 = (JSPUtil.getParameter(request, prefix	+ "area_case4", length));
			String[] areaCase3 = (JSPUtil.getParameter(request, prefix	+ "area_case3", length));
			String[] areaCase0 = (JSPUtil.getParameter(request, prefix	+ "area_case0", length));
			String[] areaCase6 = (JSPUtil.getParameter(request, prefix	+ "area_case6", length));
			String[] areaCase7 = (JSPUtil.getParameter(request, prefix	+ "area_case7", length));
			String[] areaPctCase1 = (JSPUtil.getParameter(request, prefix	+ "area_pct_case1", length));
			String[] areaReportByCd = (JSPUtil.getParameter(request, prefix	+ "area_report_by_cd", length));
			String[] areaPctAmt3 = (JSPUtil.getParameter(request, prefix	+ "area_pct_amt3", length));
			String[] areaPctCase0 = (JSPUtil.getParameter(request, prefix	+ "area_pct_case0", length));
			String[] areaPctAmt2 = (JSPUtil.getParameter(request, prefix	+ "area_pct_amt2", length));
			String[] areaCase5 = (JSPUtil.getParameter(request, prefix	+ "area_case5", length));
			String[] areaPctAmt1 = (JSPUtil.getParameter(request, prefix	+ "area_pct_amt1", length));
			String[] areaPctCase3 = (JSPUtil.getParameter(request, prefix	+ "area_pct_case3", length));
			String[] areaPctAmt0 = (JSPUtil.getParameter(request, prefix	+ "area_pct_amt0", length));
			String[] areaPctCase2 = (JSPUtil.getParameter(request, prefix	+ "area_pct_case2", length));
			
			for (int i = 0; i < length; i++) {
				model = new OccurrenceAnalysisByAreaVO();
				if (areaPctAmt4[i] != null)
					model.setAreaPctAmt4(areaPctAmt4[i]);
				if (areaPctAmt5[i] != null)
					model.setAreaPctAmt5(areaPctAmt5[i]);
				if (areaPctAmt6[i] != null)
					model.setAreaPctAmt6(areaPctAmt6[i]);
				if (areaPctAmt7[i] != null)
					model.setAreaPctAmt7(areaPctAmt7[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (areaAmt6[i] != null)
					model.setAreaAmt6(areaAmt6[i]);
				if (areaAmt7[i] != null)
					model.setAreaAmt7(areaAmt7[i]);
				if (areaPctCase4[i] != null)
					model.setAreaPctCase4(areaPctCase4[i]);
				if (areaAmt5[i] != null)
					model.setAreaAmt5(areaAmt5[i]);
				if (areaPctCase5[i] != null)
					model.setAreaPctCase5(areaPctCase5[i]);
				if (areaPctCase6[i] != null)
					model.setAreaPctCase6(areaPctCase6[i]);
				if (areaPctCase7[i] != null)
					model.setAreaPctCase7(areaPctCase7[i]);
				if (areaAmt4[i] != null)
					model.setAreaAmt4(areaAmt4[i]);
				if (areaAmt3[i] != null)
					model.setAreaAmt3(areaAmt3[i]);
				if (areaAmt2[i] != null)
					model.setAreaAmt2(areaAmt2[i]);
				if (areaAmt1[i] != null)
					model.setAreaAmt1(areaAmt1[i]);
				if (areaAmt0[i] != null)
					model.setAreaAmt0(areaAmt0[i]);
				if (areaCase2[i] != null)
					model.setAreaCase2(areaCase2[i]);
				if (areaCase1[i] != null)
					model.setAreaCase1(areaCase1[i]);
				if (areaReportByNm[i] != null)
					model.setAreaReportByNm(areaReportByNm[i]);
				if (areaCase4[i] != null)
					model.setAreaCase4(areaCase4[i]);
				if (areaCase3[i] != null)
					model.setAreaCase3(areaCase3[i]);
				if (areaCase0[i] != null)
					model.setAreaCase0(areaCase0[i]);
				if (areaCase6[i] != null)
					model.setAreaCase6(areaCase6[i]);
				if (areaCase7[i] != null)
					model.setAreaCase7(areaCase7[i]);
				if (areaPctCase1[i] != null)
					model.setAreaPctCase1(areaPctCase1[i]);
				if (areaReportByCd[i] != null)
					model.setAreaReportByCd(areaReportByCd[i]);
				if (areaPctAmt3[i] != null)
					model.setAreaPctAmt3(areaPctAmt3[i]);
				if (areaPctCase0[i] != null)
					model.setAreaPctCase0(areaPctCase0[i]);
				if (areaPctAmt2[i] != null)
					model.setAreaPctAmt2(areaPctAmt2[i]);
				if (areaCase5[i] != null)
					model.setAreaCase5(areaCase5[i]);
				if (areaPctAmt1[i] != null)
					model.setAreaPctAmt1(areaPctAmt1[i]);
				if (areaPctCase3[i] != null)
					model.setAreaPctCase3(areaPctCase3[i]);
				if (areaPctAmt0[i] != null)
					model.setAreaPctAmt0(areaPctAmt0[i]);
				if (areaPctCase2[i] != null)
					model.setAreaPctCase2(areaPctCase2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOccurrenceAnalysisByAreaVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OccurrenceAnalysisByAreaVO[]
	 */
	public OccurrenceAnalysisByAreaVO[] getOccurrenceAnalysisByAreaVOs(){
		OccurrenceAnalysisByAreaVO[] vos = (OccurrenceAnalysisByAreaVO[])models.toArray(new OccurrenceAnalysisByAreaVO[models.size()]);
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
		this.areaPctAmt4 = this.areaPctAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaPctAmt5 = this.areaPctAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaPctAmt6 = this.areaPctAmt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaPctAmt7 = this.areaPctAmt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaAmt6 = this.areaAmt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaAmt7 = this.areaAmt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaPctCase4 = this.areaPctCase4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaAmt5 = this.areaAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaPctCase5 = this.areaPctCase5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaPctCase6 = this.areaPctCase6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaPctCase7 = this.areaPctCase7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaAmt4 = this.areaAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaAmt3 = this.areaAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaAmt2 = this.areaAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaAmt1 = this.areaAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaAmt0 = this.areaAmt0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaCase2 = this.areaCase2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaCase1 = this.areaCase1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaReportByNm = this.areaReportByNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaCase4 = this.areaCase4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaCase3 = this.areaCase3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaCase0 = this.areaCase0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaCase6 = this.areaCase6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaCase7 = this.areaCase7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaPctCase1 = this.areaPctCase1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaReportByCd = this.areaReportByCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaPctAmt3 = this.areaPctAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaPctCase0 = this.areaPctCase0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaPctAmt2 = this.areaPctAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaCase5 = this.areaCase5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaPctAmt1 = this.areaPctAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaPctCase3 = this.areaPctCase3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaPctAmt0 = this.areaPctAmt0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaPctCase2 = this.areaPctCase2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
