/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OccurrenceAnalysisByHofcVO.java
*@FileTitle : OccurrenceAnalysisByHofcVO
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

public class OccurrenceAnalysisByHofcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OccurrenceAnalysisByHofcVO> models = new ArrayList<OccurrenceAnalysisByHofcVO>();
	
	/* Column Info */
	private String hofcPctAmt0 = null;
	/* Column Info */
	private String hofcPctAmt2 = null;
	/* Column Info */
	private String hofcPctAmt1 = null;
	/* Column Info */
	private String hofcPctAmt4 = null;
	/* Column Info */
	private String hofcPctAmt3 = null;
	/* Column Info */
	private String hofcPctAmt6 = null;
	/* Column Info */
	private String hofcPctAmt7 = null;
	/* Column Info */
	private String hofcPctAmt5 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hofcReportByCd = null;
	/* Column Info */
	private String hofc = null;
	/* Column Info */
	private String hofcCase3 = null;
	/* Column Info */
	private String hofcCase2 = null;
	/* Column Info */
	private String hofcCase1 = null;
	/* Column Info */
	private String hofcCase0 = null;
	/* Column Info */
	private String hofcReportByNm = null;
	/* Column Info */
	private String hofcAmt2 = null;
	/* Column Info */
	private String hofcCase4 = null;
	/* Column Info */
	private String hofcCase5 = null;
	/* Column Info */
	private String hofcAmt3 = null;
	/* Column Info */
	private String hofcCase6 = null;
	/* Column Info */
	private String hofcCase7 = null;
	/* Column Info */
	private String hofcPctCase5 = null;
	/* Column Info */
	private String hofcAmt0 = null;
	/* Column Info */
	private String hofcPctCase6 = null;
	/* Column Info */
	private String hofcPctCase7 = null;
	/* Column Info */
	private String hofcAmt1 = null;
	/* Column Info */
	private String hofcPctCase3 = null;
	/* Column Info */
	private String hofcPctCase4 = null;
	/* Column Info */
	private String hofcPctCase1 = null;
	/* Column Info */
	private String hofcPctCase2 = null;
	/* Column Info */
	private String hofcPctCase0 = null;
	/* Column Info */
	private String hofcAmt6 = null;
	/* Column Info */
	private String hofcAmt7 = null;
	/* Column Info */
	private String hofcAmt5 = null;
	/* Column Info */
	private String hofcAmt4 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OccurrenceAnalysisByHofcVO() {}

	public OccurrenceAnalysisByHofcVO(String ibflag, String pagerows, String hofcReportByCd, String hofcReportByNm, String hofc, String hofcCase0, String hofcPctCase0, String hofcAmt0, String hofcPctAmt0, String hofcCase1, String hofcPctCase1, String hofcAmt1, String hofcPctAmt1, String hofcCase2, String hofcPctCase2, String hofcAmt2, String hofcPctAmt2, String hofcCase3, String hofcPctCase3, String hofcAmt3, String hofcPctAmt3, String hofcCase4, String hofcPctCase4, String hofcAmt4, String hofcPctAmt4, String hofcCase5, String hofcPctCase5, String hofcAmt5, String hofcPctAmt5, String hofcCase6, String hofcCase7, String hofcPctCase6, String hofcPctCase7, String hofcAmt6, String hofcAmt7, String hofcPctAmt6, String hofcPctAmt7) {
		this.hofcPctAmt0 = hofcPctAmt0;
		this.hofcPctAmt2 = hofcPctAmt2;
		this.hofcPctAmt1 = hofcPctAmt1;
		this.hofcPctAmt4 = hofcPctAmt4;
		this.hofcPctAmt3 = hofcPctAmt3;
		this.hofcPctAmt6 = hofcPctAmt6;
		this.hofcPctAmt7 = hofcPctAmt7;
		this.hofcPctAmt5 = hofcPctAmt5;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.hofcReportByCd = hofcReportByCd;
		this.hofc = hofc;
		this.hofcCase3 = hofcCase3;
		this.hofcCase2 = hofcCase2;
		this.hofcCase1 = hofcCase1;
		this.hofcCase0 = hofcCase0;
		this.hofcReportByNm = hofcReportByNm;
		this.hofcAmt2 = hofcAmt2;
		this.hofcCase4 = hofcCase4;
		this.hofcCase5 = hofcCase5;
		this.hofcAmt3 = hofcAmt3;
		this.hofcCase6 = hofcCase6;
		this.hofcCase7 = hofcCase7;
		this.hofcPctCase5 = hofcPctCase5;
		this.hofcAmt0 = hofcAmt0;
		this.hofcPctCase6 = hofcPctCase6;
		this.hofcPctCase7 = hofcPctCase7;
		this.hofcAmt1 = hofcAmt1;
		this.hofcPctCase3 = hofcPctCase3;
		this.hofcPctCase4 = hofcPctCase4;
		this.hofcPctCase1 = hofcPctCase1;
		this.hofcPctCase2 = hofcPctCase2;
		this.hofcPctCase0 = hofcPctCase0;
		this.hofcAmt6 = hofcAmt6;
		this.hofcAmt7 = hofcAmt7;
		this.hofcAmt5 = hofcAmt5;
		this.hofcAmt4 = hofcAmt4;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hofc_pct_amt0", getHofcPctAmt0());
		this.hashColumns.put("hofc_pct_amt2", getHofcPctAmt2());
		this.hashColumns.put("hofc_pct_amt1", getHofcPctAmt1());
		this.hashColumns.put("hofc_pct_amt4", getHofcPctAmt4());
		this.hashColumns.put("hofc_pct_amt3", getHofcPctAmt3());
		this.hashColumns.put("hofc_pct_amt6", getHofcPctAmt6());
		this.hashColumns.put("hofc_pct_amt7", getHofcPctAmt7());
		this.hashColumns.put("hofc_pct_amt5", getHofcPctAmt5());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hofc_report_by_cd", getHofcReportByCd());
		this.hashColumns.put("hofc", getHofc());
		this.hashColumns.put("hofc_case3", getHofcCase3());
		this.hashColumns.put("hofc_case2", getHofcCase2());
		this.hashColumns.put("hofc_case1", getHofcCase1());
		this.hashColumns.put("hofc_case0", getHofcCase0());
		this.hashColumns.put("hofc_report_by_nm", getHofcReportByNm());
		this.hashColumns.put("hofc_amt2", getHofcAmt2());
		this.hashColumns.put("hofc_case4", getHofcCase4());
		this.hashColumns.put("hofc_case5", getHofcCase5());
		this.hashColumns.put("hofc_amt3", getHofcAmt3());
		this.hashColumns.put("hofc_case6", getHofcCase6());
		this.hashColumns.put("hofc_case7", getHofcCase7());
		this.hashColumns.put("hofc_pct_case5", getHofcPctCase5());
		this.hashColumns.put("hofc_amt0", getHofcAmt0());
		this.hashColumns.put("hofc_pct_case6", getHofcPctCase6());
		this.hashColumns.put("hofc_pct_case7", getHofcPctCase7());
		this.hashColumns.put("hofc_amt1", getHofcAmt1());
		this.hashColumns.put("hofc_pct_case3", getHofcPctCase3());
		this.hashColumns.put("hofc_pct_case4", getHofcPctCase4());
		this.hashColumns.put("hofc_pct_case1", getHofcPctCase1());
		this.hashColumns.put("hofc_pct_case2", getHofcPctCase2());
		this.hashColumns.put("hofc_pct_case0", getHofcPctCase0());
		this.hashColumns.put("hofc_amt6", getHofcAmt6());
		this.hashColumns.put("hofc_amt7", getHofcAmt7());
		this.hashColumns.put("hofc_amt5", getHofcAmt5());
		this.hashColumns.put("hofc_amt4", getHofcAmt4());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hofc_pct_amt0", "hofcPctAmt0");
		this.hashFields.put("hofc_pct_amt2", "hofcPctAmt2");
		this.hashFields.put("hofc_pct_amt1", "hofcPctAmt1");
		this.hashFields.put("hofc_pct_amt4", "hofcPctAmt4");
		this.hashFields.put("hofc_pct_amt3", "hofcPctAmt3");
		this.hashFields.put("hofc_pct_amt6", "hofcPctAmt6");
		this.hashFields.put("hofc_pct_amt7", "hofcPctAmt7");
		this.hashFields.put("hofc_pct_amt5", "hofcPctAmt5");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hofc_report_by_cd", "hofcReportByCd");
		this.hashFields.put("hofc", "hofc");
		this.hashFields.put("hofc_case3", "hofcCase3");
		this.hashFields.put("hofc_case2", "hofcCase2");
		this.hashFields.put("hofc_case1", "hofcCase1");
		this.hashFields.put("hofc_case0", "hofcCase0");
		this.hashFields.put("hofc_report_by_nm", "hofcReportByNm");
		this.hashFields.put("hofc_amt2", "hofcAmt2");
		this.hashFields.put("hofc_case4", "hofcCase4");
		this.hashFields.put("hofc_case5", "hofcCase5");
		this.hashFields.put("hofc_amt3", "hofcAmt3");
		this.hashFields.put("hofc_case6", "hofcCase6");
		this.hashFields.put("hofc_case7", "hofcCase7");
		this.hashFields.put("hofc_pct_case5", "hofcPctCase5");
		this.hashFields.put("hofc_amt0", "hofcAmt0");
		this.hashFields.put("hofc_pct_case6", "hofcPctCase6");
		this.hashFields.put("hofc_pct_case7", "hofcPctCase7");
		this.hashFields.put("hofc_amt1", "hofcAmt1");
		this.hashFields.put("hofc_pct_case3", "hofcPctCase3");
		this.hashFields.put("hofc_pct_case4", "hofcPctCase4");
		this.hashFields.put("hofc_pct_case1", "hofcPctCase1");
		this.hashFields.put("hofc_pct_case2", "hofcPctCase2");
		this.hashFields.put("hofc_pct_case0", "hofcPctCase0");
		this.hashFields.put("hofc_amt6", "hofcAmt6");
		this.hashFields.put("hofc_amt7", "hofcAmt7");
		this.hashFields.put("hofc_amt5", "hofcAmt5");
		this.hashFields.put("hofc_amt4", "hofcAmt4");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hofcPctAmt0
	 */
	public String getHofcPctAmt0() {
		return this.hofcPctAmt0;
	}
	
	/**
	 * Column Info
	 * @return hofcPctAmt2
	 */
	public String getHofcPctAmt2() {
		return this.hofcPctAmt2;
	}
	
	/**
	 * Column Info
	 * @return hofcPctAmt1
	 */
	public String getHofcPctAmt1() {
		return this.hofcPctAmt1;
	}
	
	/**
	 * Column Info
	 * @return hofcPctAmt4
	 */
	public String getHofcPctAmt4() {
		return this.hofcPctAmt4;
	}
	
	/**
	 * Column Info
	 * @return hofcPctAmt3
	 */
	public String getHofcPctAmt3() {
		return this.hofcPctAmt3;
	}
	
	/**
	 * Column Info
	 * @return hofcPctAmt6
	 */
	public String getHofcPctAmt6() {
		return this.hofcPctAmt6;
	}
	
	/**
	 * Column Info
	 * @return hofcPctAmt7
	 */
	public String getHofcPctAmt7() {
		return this.hofcPctAmt7;
	}
	
	/**
	 * Column Info
	 * @return hofcPctAmt5
	 */
	public String getHofcPctAmt5() {
		return this.hofcPctAmt5;
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
	 * @return hofcReportByCd
	 */
	public String getHofcReportByCd() {
		return this.hofcReportByCd;
	}
	
	/**
	 * Column Info
	 * @return hofc
	 */
	public String getHofc() {
		return this.hofc;
	}
	
	/**
	 * Column Info
	 * @return hofcCase3
	 */
	public String getHofcCase3() {
		return this.hofcCase3;
	}
	
	/**
	 * Column Info
	 * @return hofcCase2
	 */
	public String getHofcCase2() {
		return this.hofcCase2;
	}
	
	/**
	 * Column Info
	 * @return hofcCase1
	 */
	public String getHofcCase1() {
		return this.hofcCase1;
	}
	
	/**
	 * Column Info
	 * @return hofcCase0
	 */
	public String getHofcCase0() {
		return this.hofcCase0;
	}
	
	/**
	 * Column Info
	 * @return hofcReportByNm
	 */
	public String getHofcReportByNm() {
		return this.hofcReportByNm;
	}
	
	/**
	 * Column Info
	 * @return hofcAmt2
	 */
	public String getHofcAmt2() {
		return this.hofcAmt2;
	}
	
	/**
	 * Column Info
	 * @return hofcCase4
	 */
	public String getHofcCase4() {
		return this.hofcCase4;
	}
	
	/**
	 * Column Info
	 * @return hofcCase5
	 */
	public String getHofcCase5() {
		return this.hofcCase5;
	}
	
	/**
	 * Column Info
	 * @return hofcAmt3
	 */
	public String getHofcAmt3() {
		return this.hofcAmt3;
	}
	
	/**
	 * Column Info
	 * @return hofcCase6
	 */
	public String getHofcCase6() {
		return this.hofcCase6;
	}
	
	/**
	 * Column Info
	 * @return hofcCase7
	 */
	public String getHofcCase7() {
		return this.hofcCase7;
	}
	
	/**
	 * Column Info
	 * @return hofcPctCase5
	 */
	public String getHofcPctCase5() {
		return this.hofcPctCase5;
	}
	
	/**
	 * Column Info
	 * @return hofcAmt0
	 */
	public String getHofcAmt0() {
		return this.hofcAmt0;
	}
	
	/**
	 * Column Info
	 * @return hofcPctCase6
	 */
	public String getHofcPctCase6() {
		return this.hofcPctCase6;
	}
	
	/**
	 * Column Info
	 * @return hofcPctCase7
	 */
	public String getHofcPctCase7() {
		return this.hofcPctCase7;
	}
	
	/**
	 * Column Info
	 * @return hofcAmt1
	 */
	public String getHofcAmt1() {
		return this.hofcAmt1;
	}
	
	/**
	 * Column Info
	 * @return hofcPctCase3
	 */
	public String getHofcPctCase3() {
		return this.hofcPctCase3;
	}
	
	/**
	 * Column Info
	 * @return hofcPctCase4
	 */
	public String getHofcPctCase4() {
		return this.hofcPctCase4;
	}
	
	/**
	 * Column Info
	 * @return hofcPctCase1
	 */
	public String getHofcPctCase1() {
		return this.hofcPctCase1;
	}
	
	/**
	 * Column Info
	 * @return hofcPctCase2
	 */
	public String getHofcPctCase2() {
		return this.hofcPctCase2;
	}
	
	/**
	 * Column Info
	 * @return hofcPctCase0
	 */
	public String getHofcPctCase0() {
		return this.hofcPctCase0;
	}
	
	/**
	 * Column Info
	 * @return hofcAmt6
	 */
	public String getHofcAmt6() {
		return this.hofcAmt6;
	}
	
	/**
	 * Column Info
	 * @return hofcAmt7
	 */
	public String getHofcAmt7() {
		return this.hofcAmt7;
	}
	
	/**
	 * Column Info
	 * @return hofcAmt5
	 */
	public String getHofcAmt5() {
		return this.hofcAmt5;
	}
	
	/**
	 * Column Info
	 * @return hofcAmt4
	 */
	public String getHofcAmt4() {
		return this.hofcAmt4;
	}

	/**
	 * Column Info
	 * @param hofcPctAmt0
	 */
	public void setHofcPctAmt0(String hofcPctAmt0) {
		this.hofcPctAmt0 = hofcPctAmt0;
	}
	
	/**
	 * Column Info
	 * @param hofcPctAmt2
	 */
	public void setHofcPctAmt2(String hofcPctAmt2) {
		this.hofcPctAmt2 = hofcPctAmt2;
	}
	
	/**
	 * Column Info
	 * @param hofcPctAmt1
	 */
	public void setHofcPctAmt1(String hofcPctAmt1) {
		this.hofcPctAmt1 = hofcPctAmt1;
	}
	
	/**
	 * Column Info
	 * @param hofcPctAmt4
	 */
	public void setHofcPctAmt4(String hofcPctAmt4) {
		this.hofcPctAmt4 = hofcPctAmt4;
	}
	
	/**
	 * Column Info
	 * @param hofcPctAmt3
	 */
	public void setHofcPctAmt3(String hofcPctAmt3) {
		this.hofcPctAmt3 = hofcPctAmt3;
	}
	
	/**
	 * Column Info
	 * @param hofcPctAmt6
	 */
	public void setHofcPctAmt6(String hofcPctAmt6) {
		this.hofcPctAmt6 = hofcPctAmt6;
	}
	
	/**
	 * Column Info
	 * @param hofcPctAmt7
	 */
	public void setHofcPctAmt7(String hofcPctAmt7) {
		this.hofcPctAmt7 = hofcPctAmt7;
	}
	
	/**
	 * Column Info
	 * @param hofcPctAmt5
	 */
	public void setHofcPctAmt5(String hofcPctAmt5) {
		this.hofcPctAmt5 = hofcPctAmt5;
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
	 * @param hofcReportByCd
	 */
	public void setHofcReportByCd(String hofcReportByCd) {
		this.hofcReportByCd = hofcReportByCd;
	}
	
	/**
	 * Column Info
	 * @param hofc
	 */
	public void setHofc(String hofc) {
		this.hofc = hofc;
	}
	
	/**
	 * Column Info
	 * @param hofcCase3
	 */
	public void setHofcCase3(String hofcCase3) {
		this.hofcCase3 = hofcCase3;
	}
	
	/**
	 * Column Info
	 * @param hofcCase2
	 */
	public void setHofcCase2(String hofcCase2) {
		this.hofcCase2 = hofcCase2;
	}
	
	/**
	 * Column Info
	 * @param hofcCase1
	 */
	public void setHofcCase1(String hofcCase1) {
		this.hofcCase1 = hofcCase1;
	}
	
	/**
	 * Column Info
	 * @param hofcCase0
	 */
	public void setHofcCase0(String hofcCase0) {
		this.hofcCase0 = hofcCase0;
	}
	
	/**
	 * Column Info
	 * @param hofcReportByNm
	 */
	public void setHofcReportByNm(String hofcReportByNm) {
		this.hofcReportByNm = hofcReportByNm;
	}
	
	/**
	 * Column Info
	 * @param hofcAmt2
	 */
	public void setHofcAmt2(String hofcAmt2) {
		this.hofcAmt2 = hofcAmt2;
	}
	
	/**
	 * Column Info
	 * @param hofcCase4
	 */
	public void setHofcCase4(String hofcCase4) {
		this.hofcCase4 = hofcCase4;
	}
	
	/**
	 * Column Info
	 * @param hofcCase5
	 */
	public void setHofcCase5(String hofcCase5) {
		this.hofcCase5 = hofcCase5;
	}
	
	/**
	 * Column Info
	 * @param hofcAmt3
	 */
	public void setHofcAmt3(String hofcAmt3) {
		this.hofcAmt3 = hofcAmt3;
	}
	
	/**
	 * Column Info
	 * @param hofcCase6
	 */
	public void setHofcCase6(String hofcCase6) {
		this.hofcCase6 = hofcCase6;
	}
	
	/**
	 * Column Info
	 * @param hofcCase7
	 */
	public void setHofcCase7(String hofcCase7) {
		this.hofcCase7 = hofcCase7;
	}
	
	/**
	 * Column Info
	 * @param hofcPctCase5
	 */
	public void setHofcPctCase5(String hofcPctCase5) {
		this.hofcPctCase5 = hofcPctCase5;
	}
	
	/**
	 * Column Info
	 * @param hofcAmt0
	 */
	public void setHofcAmt0(String hofcAmt0) {
		this.hofcAmt0 = hofcAmt0;
	}
	
	/**
	 * Column Info
	 * @param hofcPctCase6
	 */
	public void setHofcPctCase6(String hofcPctCase6) {
		this.hofcPctCase6 = hofcPctCase6;
	}
	
	/**
	 * Column Info
	 * @param hofcPctCase7
	 */
	public void setHofcPctCase7(String hofcPctCase7) {
		this.hofcPctCase7 = hofcPctCase7;
	}
	
	/**
	 * Column Info
	 * @param hofcAmt1
	 */
	public void setHofcAmt1(String hofcAmt1) {
		this.hofcAmt1 = hofcAmt1;
	}
	
	/**
	 * Column Info
	 * @param hofcPctCase3
	 */
	public void setHofcPctCase3(String hofcPctCase3) {
		this.hofcPctCase3 = hofcPctCase3;
	}
	
	/**
	 * Column Info
	 * @param hofcPctCase4
	 */
	public void setHofcPctCase4(String hofcPctCase4) {
		this.hofcPctCase4 = hofcPctCase4;
	}
	
	/**
	 * Column Info
	 * @param hofcPctCase1
	 */
	public void setHofcPctCase1(String hofcPctCase1) {
		this.hofcPctCase1 = hofcPctCase1;
	}
	
	/**
	 * Column Info
	 * @param hofcPctCase2
	 */
	public void setHofcPctCase2(String hofcPctCase2) {
		this.hofcPctCase2 = hofcPctCase2;
	}
	
	/**
	 * Column Info
	 * @param hofcPctCase0
	 */
	public void setHofcPctCase0(String hofcPctCase0) {
		this.hofcPctCase0 = hofcPctCase0;
	}
	
	/**
	 * Column Info
	 * @param hofcAmt6
	 */
	public void setHofcAmt6(String hofcAmt6) {
		this.hofcAmt6 = hofcAmt6;
	}
	
	/**
	 * Column Info
	 * @param hofcAmt7
	 */
	public void setHofcAmt7(String hofcAmt7) {
		this.hofcAmt7 = hofcAmt7;
	}
		
	/**
	 * Column Info
	 * @param hofcAmt5
	 */
	public void setHofcAmt5(String hofcAmt5) {
		this.hofcAmt5 = hofcAmt5;
	}
	
	/**
	 * Column Info
	 * @param hofcAmt4
	 */
	public void setHofcAmt4(String hofcAmt4) {
		this.hofcAmt4 = hofcAmt4;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setHofcPctAmt0(JSPUtil.getParameter(request, "hofc_pct_amt0", ""));
		setHofcPctAmt2(JSPUtil.getParameter(request, "hofc_pct_amt2", ""));
		setHofcPctAmt1(JSPUtil.getParameter(request, "hofc_pct_amt1", ""));
		setHofcPctAmt4(JSPUtil.getParameter(request, "hofc_pct_amt4", ""));
		setHofcPctAmt3(JSPUtil.getParameter(request, "hofc_pct_amt3", ""));
		setHofcPctAmt6(JSPUtil.getParameter(request, "hofc_pct_amt6", ""));
		setHofcPctAmt7(JSPUtil.getParameter(request, "hofc_pct_amt7", ""));
		setHofcPctAmt5(JSPUtil.getParameter(request, "hofc_pct_amt5", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setHofcReportByCd(JSPUtil.getParameter(request, "hofc_report_by_cd", ""));
		setHofc(JSPUtil.getParameter(request, "hofc", ""));
		setHofcCase3(JSPUtil.getParameter(request, "hofc_case3", ""));
		setHofcCase2(JSPUtil.getParameter(request, "hofc_case2", ""));
		setHofcCase1(JSPUtil.getParameter(request, "hofc_case1", ""));
		setHofcCase0(JSPUtil.getParameter(request, "hofc_case0", ""));
		setHofcReportByNm(JSPUtil.getParameter(request, "hofc_report_by_nm", ""));
		setHofcAmt2(JSPUtil.getParameter(request, "hofc_amt2", ""));
		setHofcCase4(JSPUtil.getParameter(request, "hofc_case4", ""));
		setHofcCase5(JSPUtil.getParameter(request, "hofc_case5", ""));
		setHofcAmt3(JSPUtil.getParameter(request, "hofc_amt3", ""));
		setHofcCase6(JSPUtil.getParameter(request, "hofc_case6", ""));
		setHofcCase7(JSPUtil.getParameter(request, "hofc_case7", ""));
		setHofcPctCase5(JSPUtil.getParameter(request, "hofc_pct_case5", ""));
		setHofcAmt0(JSPUtil.getParameter(request, "hofc_amt0", ""));
		setHofcPctCase6(JSPUtil.getParameter(request, "hofc_pct_case6", ""));
		setHofcPctCase7(JSPUtil.getParameter(request, "hofc_pct_case7", ""));
		setHofcAmt1(JSPUtil.getParameter(request, "hofc_amt1", ""));
		setHofcPctCase3(JSPUtil.getParameter(request, "hofc_pct_case3", ""));
		setHofcPctCase4(JSPUtil.getParameter(request, "hofc_pct_case4", ""));
		setHofcPctCase1(JSPUtil.getParameter(request, "hofc_pct_case1", ""));
		setHofcPctCase2(JSPUtil.getParameter(request, "hofc_pct_case2", ""));
		setHofcPctCase0(JSPUtil.getParameter(request, "hofc_pct_case0", ""));
		setHofcAmt6(JSPUtil.getParameter(request, "hofc_amt6", ""));
		setHofcAmt7(JSPUtil.getParameter(request, "hofc_amt7", ""));
		setHofcAmt5(JSPUtil.getParameter(request, "hofc_amt5", ""));
		setHofcAmt4(JSPUtil.getParameter(request, "hofc_amt4", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OccurrenceAnalysisByHofcVO[]
	 */
	public OccurrenceAnalysisByHofcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OccurrenceAnalysisByHofcVO[]
	 */
	public OccurrenceAnalysisByHofcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OccurrenceAnalysisByHofcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hofcPctAmt0 = (JSPUtil.getParameter(request, prefix	+ "hofc_pct_amt0", length));
			String[] hofcPctAmt2 = (JSPUtil.getParameter(request, prefix	+ "hofc_pct_amt2", length));
			String[] hofcPctAmt1 = (JSPUtil.getParameter(request, prefix	+ "hofc_pct_amt1", length));
			String[] hofcPctAmt4 = (JSPUtil.getParameter(request, prefix	+ "hofc_pct_amt4", length));
			String[] hofcPctAmt3 = (JSPUtil.getParameter(request, prefix	+ "hofc_pct_amt3", length));
			String[] hofcPctAmt6 = (JSPUtil.getParameter(request, prefix	+ "hofc_pct_amt6", length));
			String[] hofcPctAmt7 = (JSPUtil.getParameter(request, prefix	+ "hofc_pct_amt7", length));
			String[] hofcPctAmt5 = (JSPUtil.getParameter(request, prefix	+ "hofc_pct_amt5", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hofcReportByCd = (JSPUtil.getParameter(request, prefix	+ "hofc_report_by_cd", length));
			String[] hofc = (JSPUtil.getParameter(request, prefix	+ "hofc", length));
			String[] hofcCase3 = (JSPUtil.getParameter(request, prefix	+ "hofc_case3", length));
			String[] hofcCase2 = (JSPUtil.getParameter(request, prefix	+ "hofc_case2", length));
			String[] hofcCase1 = (JSPUtil.getParameter(request, prefix	+ "hofc_case1", length));
			String[] hofcCase0 = (JSPUtil.getParameter(request, prefix	+ "hofc_case0", length));
			String[] hofcReportByNm = (JSPUtil.getParameter(request, prefix	+ "hofc_report_by_nm", length));
			String[] hofcAmt2 = (JSPUtil.getParameter(request, prefix	+ "hofc_amt2", length));
			String[] hofcCase4 = (JSPUtil.getParameter(request, prefix	+ "hofc_case4", length));
			String[] hofcCase5 = (JSPUtil.getParameter(request, prefix	+ "hofc_case5", length));
			String[] hofcAmt3 = (JSPUtil.getParameter(request, prefix	+ "hofc_amt3", length));
			String[] hofcCase6 = (JSPUtil.getParameter(request, prefix	+ "hofc_case6", length));
			String[] hofcCase7 = (JSPUtil.getParameter(request, prefix	+ "hofc_case7", length));
			String[] hofcPctCase5 = (JSPUtil.getParameter(request, prefix	+ "hofc_pct_case5", length));
			String[] hofcAmt0 = (JSPUtil.getParameter(request, prefix	+ "hofc_amt0", length));
			String[] hofcPctCase6 = (JSPUtil.getParameter(request, prefix	+ "hofc_pct_case6", length));
			String[] hofcPctCase7 = (JSPUtil.getParameter(request, prefix	+ "hofc_pct_case7", length));
			String[] hofcAmt1 = (JSPUtil.getParameter(request, prefix	+ "hofc_amt1", length));
			String[] hofcPctCase3 = (JSPUtil.getParameter(request, prefix	+ "hofc_pct_case3", length));
			String[] hofcPctCase4 = (JSPUtil.getParameter(request, prefix	+ "hofc_pct_case4", length));
			String[] hofcPctCase1 = (JSPUtil.getParameter(request, prefix	+ "hofc_pct_case1", length));
			String[] hofcPctCase2 = (JSPUtil.getParameter(request, prefix	+ "hofc_pct_case2", length));
			String[] hofcPctCase0 = (JSPUtil.getParameter(request, prefix	+ "hofc_pct_case0", length));
			String[] hofcAmt6 = (JSPUtil.getParameter(request, prefix	+ "hofc_amt6", length));
			String[] hofcAmt7 = (JSPUtil.getParameter(request, prefix	+ "hofc_amt7", length));
			String[] hofcAmt5 = (JSPUtil.getParameter(request, prefix	+ "hofc_amt5", length));
			String[] hofcAmt4 = (JSPUtil.getParameter(request, prefix	+ "hofc_amt4", length));
			
			for (int i = 0; i < length; i++) {
				model = new OccurrenceAnalysisByHofcVO();
				if (hofcPctAmt0[i] != null)
					model.setHofcPctAmt0(hofcPctAmt0[i]);
				if (hofcPctAmt2[i] != null)
					model.setHofcPctAmt2(hofcPctAmt2[i]);
				if (hofcPctAmt1[i] != null)
					model.setHofcPctAmt1(hofcPctAmt1[i]);
				if (hofcPctAmt4[i] != null)
					model.setHofcPctAmt4(hofcPctAmt4[i]);
				if (hofcPctAmt3[i] != null)
					model.setHofcPctAmt3(hofcPctAmt3[i]);
				if (hofcPctAmt6[i] != null)
					model.setHofcPctAmt6(hofcPctAmt6[i]);
				if (hofcPctAmt7[i] != null)
					model.setHofcPctAmt7(hofcPctAmt7[i]);
				if (hofcPctAmt5[i] != null)
					model.setHofcPctAmt5(hofcPctAmt5[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hofcReportByCd[i] != null)
					model.setHofcReportByCd(hofcReportByCd[i]);
				if (hofc[i] != null)
					model.setHofc(hofc[i]);
				if (hofcCase3[i] != null)
					model.setHofcCase3(hofcCase3[i]);
				if (hofcCase2[i] != null)
					model.setHofcCase2(hofcCase2[i]);
				if (hofcCase1[i] != null)
					model.setHofcCase1(hofcCase1[i]);
				if (hofcCase0[i] != null)
					model.setHofcCase0(hofcCase0[i]);
				if (hofcReportByNm[i] != null)
					model.setHofcReportByNm(hofcReportByNm[i]);
				if (hofcAmt2[i] != null)
					model.setHofcAmt2(hofcAmt2[i]);
				if (hofcCase4[i] != null)
					model.setHofcCase4(hofcCase4[i]);
				if (hofcCase5[i] != null)
					model.setHofcCase5(hofcCase5[i]);
				if (hofcAmt3[i] != null)
					model.setHofcAmt3(hofcAmt3[i]);
				if (hofcCase6[i] != null)
					model.setHofcCase6(hofcCase6[i]);
				if (hofcCase7[i] != null)
					model.setHofcCase7(hofcCase7[i]);
				if (hofcPctCase5[i] != null)
					model.setHofcPctCase5(hofcPctCase5[i]);
				if (hofcAmt0[i] != null)
					model.setHofcAmt0(hofcAmt0[i]);
				if (hofcPctCase6[i] != null)
					model.setHofcPctCase6(hofcPctCase6[i]);
				if (hofcPctCase7[i] != null)
					model.setHofcPctCase7(hofcPctCase7[i]);
				if (hofcAmt1[i] != null)
					model.setHofcAmt1(hofcAmt1[i]);
				if (hofcPctCase3[i] != null)
					model.setHofcPctCase3(hofcPctCase3[i]);
				if (hofcPctCase4[i] != null)
					model.setHofcPctCase4(hofcPctCase4[i]);
				if (hofcPctCase1[i] != null)
					model.setHofcPctCase1(hofcPctCase1[i]);
				if (hofcPctCase2[i] != null)
					model.setHofcPctCase2(hofcPctCase2[i]);
				if (hofcPctCase0[i] != null)
					model.setHofcPctCase0(hofcPctCase0[i]);
				if (hofcAmt6[i] != null)
					model.setHofcAmt6(hofcAmt6[i]);
				if (hofcAmt7[i] != null)
					model.setHofcAmt7(hofcAmt7[i]);
				if (hofcAmt5[i] != null)
					model.setHofcAmt5(hofcAmt5[i]);
				if (hofcAmt4[i] != null)
					model.setHofcAmt4(hofcAmt4[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOccurrenceAnalysisByHofcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OccurrenceAnalysisByHofcVO[]
	 */
	public OccurrenceAnalysisByHofcVO[] getOccurrenceAnalysisByHofcVOs(){
		OccurrenceAnalysisByHofcVO[] vos = (OccurrenceAnalysisByHofcVO[])models.toArray(new OccurrenceAnalysisByHofcVO[models.size()]);
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
		this.hofcPctAmt0 = this.hofcPctAmt0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcPctAmt2 = this.hofcPctAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcPctAmt1 = this.hofcPctAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcPctAmt4 = this.hofcPctAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcPctAmt3 = this.hofcPctAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcPctAmt6 = this.hofcPctAmt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcPctAmt7 = this.hofcPctAmt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcPctAmt5 = this.hofcPctAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcReportByCd = this.hofcReportByCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofc = this.hofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcCase3 = this.hofcCase3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcCase2 = this.hofcCase2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcCase1 = this.hofcCase1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcCase0 = this.hofcCase0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcReportByNm = this.hofcReportByNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcAmt2 = this.hofcAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcCase4 = this.hofcCase4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcCase5 = this.hofcCase5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcAmt3 = this.hofcAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcCase6 = this.hofcCase6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcCase7 = this.hofcCase7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcPctCase5 = this.hofcPctCase5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcAmt0 = this.hofcAmt0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcPctCase6 = this.hofcPctCase6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcPctCase7 = this.hofcPctCase7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcAmt1 = this.hofcAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcPctCase3 = this.hofcPctCase3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcPctCase4 = this.hofcPctCase4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcPctCase1 = this.hofcPctCase1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcPctCase2 = this.hofcPctCase2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcPctCase0 = this.hofcPctCase0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcAmt6 = this.hofcAmt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcAmt7 = this.hofcAmt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcAmt5 = this.hofcAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hofcAmt4 = this.hofcAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

}
