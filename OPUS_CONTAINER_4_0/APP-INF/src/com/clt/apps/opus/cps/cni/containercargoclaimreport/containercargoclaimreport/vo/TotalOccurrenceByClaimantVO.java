/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TotalOccurrenceByClaimantVO.java
*@FileTitle : TotalOccurrenceByClaimantVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2010.02.04 박제성 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박제성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TotalOccurrenceByClaimantVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TotalOccurrenceByClaimantVO> models = new ArrayList<TotalOccurrenceByClaimantVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String claimantPctCase6 = null;
	/* Column Info */
	private String claimantCase2 = null;
	/* Column Info */
	private String claimantCase1 = null;
	/* Column Info */
	private String claimantCase0 = null;
	/* Column Info */
	private String claimantCase6 = null;
	/* Column Info */
	private String claimantCase5 = null;
	/* Column Info */
	private String claimantCase4 = null;
	/* Column Info */
	private String claimantCase3 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String claimantPctAmt6 = null;
	/* Column Info */
	private String claimantPctAmt5 = null;
	/* Column Info */
	private String claimantPctAmt4 = null;
	/* Column Info */
	private String claimantPctAmt3 = null;
	/* Column Info */
	private String claimantPctAmt2 = null;
	/* Column Info */
	private String claimantPctCase1 = null;
	/* Column Info */
	private String claimantPctCase0 = null;
	/* Column Info */
	private String clmPtyAbbrNm = null;
	/* Column Info */
	private String claimantPctCase5 = null;
	/* Column Info */
	private String claimantPctCase4 = null;
	/* Column Info */
	private String claimantPctCase3 = null;
	/* Column Info */
	private String claimantPctCase2 = null;
	/* Column Info */
	private String claimantAmt2 = null;
	/* Column Info */
	private String claimantAmt1 = null;
	/* Column Info */
	private String claimantAmt4 = null;
	/* Column Info */
	private String claimantAmt3 = null;
	/* Column Info */
	private String claimantAmt0 = null;
	/* Column Info */
	private String claimantAmt6 = null;
	/* Column Info */
	private String claimantAmt5 = null;
	/* Column Info */
	private String claimantPctAmt0 = null;
	/* Column Info */
	private String claimantPctAmt1 = null;
	/* Column Info */
	private String rowNum = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TotalOccurrenceByClaimantVO() {}

	public TotalOccurrenceByClaimantVO(String ibflag, String pagerows, String clmPtyAbbrNm, String claimantCase0, String claimantPctCase0, String claimantAmt0, String claimantPctAmt0, String claimantCase1, String claimantPctCase1, String claimantAmt1, String claimantPctAmt1, String claimantCase2, String claimantPctCase2, String claimantAmt2, String claimantPctAmt2, String claimantCase3, String claimantPctCase3, String claimantAmt3, String claimantPctAmt3, String claimantCase4, String claimantPctCase4, String claimantAmt4, String claimantPctAmt4, String claimantCase5, String claimantPctCase5, String claimantAmt5, String claimantPctAmt5, String claimantCase6, String claimantPctCase6, String claimantAmt6, String claimantPctAmt6, String rowNum, String total) {
		this.total = total;
		this.claimantPctCase6 = claimantPctCase6;
		this.claimantCase2 = claimantCase2;
		this.claimantCase1 = claimantCase1;
		this.claimantCase0 = claimantCase0;
		this.claimantCase6 = claimantCase6;
		this.claimantCase5 = claimantCase5;
		this.claimantCase4 = claimantCase4;
		this.claimantCase3 = claimantCase3;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.claimantPctAmt6 = claimantPctAmt6;
		this.claimantPctAmt5 = claimantPctAmt5;
		this.claimantPctAmt4 = claimantPctAmt4;
		this.claimantPctAmt3 = claimantPctAmt3;
		this.claimantPctAmt2 = claimantPctAmt2;
		this.claimantPctCase1 = claimantPctCase1;
		this.claimantPctCase0 = claimantPctCase0;
		this.clmPtyAbbrNm = clmPtyAbbrNm;
		this.claimantPctCase5 = claimantPctCase5;
		this.claimantPctCase4 = claimantPctCase4;
		this.claimantPctCase3 = claimantPctCase3;
		this.claimantPctCase2 = claimantPctCase2;
		this.claimantAmt2 = claimantAmt2;
		this.claimantAmt1 = claimantAmt1;
		this.claimantAmt4 = claimantAmt4;
		this.claimantAmt3 = claimantAmt3;
		this.claimantAmt0 = claimantAmt0;
		this.claimantAmt6 = claimantAmt6;
		this.claimantAmt5 = claimantAmt5;
		this.claimantPctAmt0 = claimantPctAmt0;
		this.claimantPctAmt1 = claimantPctAmt1;
		this.rowNum = rowNum;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("claimant_pct_case6", getClaimantPctCase6());
		this.hashColumns.put("claimant_case2", getClaimantCase2());
		this.hashColumns.put("claimant_case1", getClaimantCase1());
		this.hashColumns.put("claimant_case0", getClaimantCase0());
		this.hashColumns.put("claimant_case6", getClaimantCase6());
		this.hashColumns.put("claimant_case5", getClaimantCase5());
		this.hashColumns.put("claimant_case4", getClaimantCase4());
		this.hashColumns.put("claimant_case3", getClaimantCase3());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("claimant_pct_amt6", getClaimantPctAmt6());
		this.hashColumns.put("claimant_pct_amt5", getClaimantPctAmt5());
		this.hashColumns.put("claimant_pct_amt4", getClaimantPctAmt4());
		this.hashColumns.put("claimant_pct_amt3", getClaimantPctAmt3());
		this.hashColumns.put("claimant_pct_amt2", getClaimantPctAmt2());
		this.hashColumns.put("claimant_pct_case1", getClaimantPctCase1());
		this.hashColumns.put("claimant_pct_case0", getClaimantPctCase0());
		this.hashColumns.put("clm_pty_abbr_nm", getClmPtyAbbrNm());
		this.hashColumns.put("claimant_pct_case5", getClaimantPctCase5());
		this.hashColumns.put("claimant_pct_case4", getClaimantPctCase4());
		this.hashColumns.put("claimant_pct_case3", getClaimantPctCase3());
		this.hashColumns.put("claimant_pct_case2", getClaimantPctCase2());
		this.hashColumns.put("claimant_amt2", getClaimantAmt2());
		this.hashColumns.put("claimant_amt1", getClaimantAmt1());
		this.hashColumns.put("claimant_amt4", getClaimantAmt4());
		this.hashColumns.put("claimant_amt3", getClaimantAmt3());
		this.hashColumns.put("claimant_amt0", getClaimantAmt0());
		this.hashColumns.put("claimant_amt6", getClaimantAmt6());
		this.hashColumns.put("claimant_amt5", getClaimantAmt5());
		this.hashColumns.put("claimant_pct_amt0", getClaimantPctAmt0());
		this.hashColumns.put("claimant_pct_amt1", getClaimantPctAmt1());
		this.hashColumns.put("row_num", getRowNum());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("claimant_pct_case6", "claimantPctCase6");
		this.hashFields.put("claimant_case2", "claimantCase2");
		this.hashFields.put("claimant_case1", "claimantCase1");
		this.hashFields.put("claimant_case0", "claimantCase0");
		this.hashFields.put("claimant_case6", "claimantCase6");
		this.hashFields.put("claimant_case5", "claimantCase5");
		this.hashFields.put("claimant_case4", "claimantCase4");
		this.hashFields.put("claimant_case3", "claimantCase3");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("claimant_pct_amt6", "claimantPctAmt6");
		this.hashFields.put("claimant_pct_amt5", "claimantPctAmt5");
		this.hashFields.put("claimant_pct_amt4", "claimantPctAmt4");
		this.hashFields.put("claimant_pct_amt3", "claimantPctAmt3");
		this.hashFields.put("claimant_pct_amt2", "claimantPctAmt2");
		this.hashFields.put("claimant_pct_case1", "claimantPctCase1");
		this.hashFields.put("claimant_pct_case0", "claimantPctCase0");
		this.hashFields.put("clm_pty_abbr_nm", "clmPtyAbbrNm");
		this.hashFields.put("claimant_pct_case5", "claimantPctCase5");
		this.hashFields.put("claimant_pct_case4", "claimantPctCase4");
		this.hashFields.put("claimant_pct_case3", "claimantPctCase3");
		this.hashFields.put("claimant_pct_case2", "claimantPctCase2");
		this.hashFields.put("claimant_amt2", "claimantAmt2");
		this.hashFields.put("claimant_amt1", "claimantAmt1");
		this.hashFields.put("claimant_amt4", "claimantAmt4");
		this.hashFields.put("claimant_amt3", "claimantAmt3");
		this.hashFields.put("claimant_amt0", "claimantAmt0");
		this.hashFields.put("claimant_amt6", "claimantAmt6");
		this.hashFields.put("claimant_amt5", "claimantAmt5");
		this.hashFields.put("claimant_pct_amt0", "claimantPctAmt0");
		this.hashFields.put("claimant_pct_amt1", "claimantPctAmt1");
		this.hashFields.put("row_num", "rowNum");
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
	 * @return claimantPctCase6
	 */
	public String getClaimantPctCase6() {
		return this.claimantPctCase6;
	}
	
	/**
	 * Column Info
	 * @return claimantCase2
	 */
	public String getClaimantCase2() {
		return this.claimantCase2;
	}
	
	/**
	 * Column Info
	 * @return claimantCase1
	 */
	public String getClaimantCase1() {
		return this.claimantCase1;
	}
	
	/**
	 * Column Info
	 * @return claimantCase0
	 */
	public String getClaimantCase0() {
		return this.claimantCase0;
	}
	
	/**
	 * Column Info
	 * @return claimantCase6
	 */
	public String getClaimantCase6() {
		return this.claimantCase6;
	}
	
	/**
	 * Column Info
	 * @return claimantCase5
	 */
	public String getClaimantCase5() {
		return this.claimantCase5;
	}
	
	/**
	 * Column Info
	 * @return claimantCase4
	 */
	public String getClaimantCase4() {
		return this.claimantCase4;
	}
	
	/**
	 * Column Info
	 * @return claimantCase3
	 */
	public String getClaimantCase3() {
		return this.claimantCase3;
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
	 * @return claimantPctAmt6
	 */
	public String getClaimantPctAmt6() {
		return this.claimantPctAmt6;
	}
	
	/**
	 * Column Info
	 * @return claimantPctAmt5
	 */
	public String getClaimantPctAmt5() {
		return this.claimantPctAmt5;
	}
	
	/**
	 * Column Info
	 * @return claimantPctAmt4
	 */
	public String getClaimantPctAmt4() {
		return this.claimantPctAmt4;
	}
	
	/**
	 * Column Info
	 * @return claimantPctAmt3
	 */
	public String getClaimantPctAmt3() {
		return this.claimantPctAmt3;
	}
	
	/**
	 * Column Info
	 * @return claimantPctAmt2
	 */
	public String getClaimantPctAmt2() {
		return this.claimantPctAmt2;
	}
	
	/**
	 * Column Info
	 * @return claimantPctCase1
	 */
	public String getClaimantPctCase1() {
		return this.claimantPctCase1;
	}
	
	/**
	 * Column Info
	 * @return claimantPctCase0
	 */
	public String getClaimantPctCase0() {
		return this.claimantPctCase0;
	}
	
	/**
	 * Column Info
	 * @return clmPtyAbbrNm
	 */
	public String getClmPtyAbbrNm() {
		return this.clmPtyAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return claimantPctCase5
	 */
	public String getClaimantPctCase5() {
		return this.claimantPctCase5;
	}
	
	/**
	 * Column Info
	 * @return claimantPctCase4
	 */
	public String getClaimantPctCase4() {
		return this.claimantPctCase4;
	}
	
	/**
	 * Column Info
	 * @return claimantPctCase3
	 */
	public String getClaimantPctCase3() {
		return this.claimantPctCase3;
	}
	
	/**
	 * Column Info
	 * @return claimantPctCase2
	 */
	public String getClaimantPctCase2() {
		return this.claimantPctCase2;
	}
	
	/**
	 * Column Info
	 * @return claimantAmt2
	 */
	public String getClaimantAmt2() {
		return this.claimantAmt2;
	}
	
	/**
	 * Column Info
	 * @return claimantAmt1
	 */
	public String getClaimantAmt1() {
		return this.claimantAmt1;
	}
	
	/**
	 * Column Info
	 * @return claimantAmt4
	 */
	public String getClaimantAmt4() {
		return this.claimantAmt4;
	}
	
	/**
	 * Column Info
	 * @return claimantAmt3
	 */
	public String getClaimantAmt3() {
		return this.claimantAmt3;
	}
	
	/**
	 * Column Info
	 * @return claimantAmt0
	 */
	public String getClaimantAmt0() {
		return this.claimantAmt0;
	}
	
	/**
	 * Column Info
	 * @return claimantAmt6
	 */
	public String getClaimantAmt6() {
		return this.claimantAmt6;
	}
	
	/**
	 * Column Info
	 * @return claimantAmt5
	 */
	public String getClaimantAmt5() {
		return this.claimantAmt5;
	}
	
	/**
	 * Column Info
	 * @return claimantPctAmt0
	 */
	public String getClaimantPctAmt0() {
		return this.claimantPctAmt0;
	}
	
	/**
	 * Column Info
	 * @return claimantPctAmt1
	 */
	public String getClaimantPctAmt1() {
		return this.claimantPctAmt1;
	}
	
	/**
	 * Column Info
	 * @return rowNum
	 */
	public String getRowNum() {
		return this.rowNum;
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
	 * @param claimantPctCase6
	 */
	public void setClaimantPctCase6(String claimantPctCase6) {
		this.claimantPctCase6 = claimantPctCase6;
	}
	
	/**
	 * Column Info
	 * @param claimantCase2
	 */
	public void setClaimantCase2(String claimantCase2) {
		this.claimantCase2 = claimantCase2;
	}
	
	/**
	 * Column Info
	 * @param claimantCase1
	 */
	public void setClaimantCase1(String claimantCase1) {
		this.claimantCase1 = claimantCase1;
	}
	
	/**
	 * Column Info
	 * @param claimantCase0
	 */
	public void setClaimantCase0(String claimantCase0) {
		this.claimantCase0 = claimantCase0;
	}
	
	/**
	 * Column Info
	 * @param claimantCase6
	 */
	public void setClaimantCase6(String claimantCase6) {
		this.claimantCase6 = claimantCase6;
	}
	
	/**
	 * Column Info
	 * @param claimantCase5
	 */
	public void setClaimantCase5(String claimantCase5) {
		this.claimantCase5 = claimantCase5;
	}
	
	/**
	 * Column Info
	 * @param claimantCase4
	 */
	public void setClaimantCase4(String claimantCase4) {
		this.claimantCase4 = claimantCase4;
	}
	
	/**
	 * Column Info
	 * @param claimantCase3
	 */
	public void setClaimantCase3(String claimantCase3) {
		this.claimantCase3 = claimantCase3;
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
	 * @param claimantPctAmt6
	 */
	public void setClaimantPctAmt6(String claimantPctAmt6) {
		this.claimantPctAmt6 = claimantPctAmt6;
	}
	
	/**
	 * Column Info
	 * @param claimantPctAmt5
	 */
	public void setClaimantPctAmt5(String claimantPctAmt5) {
		this.claimantPctAmt5 = claimantPctAmt5;
	}
	
	/**
	 * Column Info
	 * @param claimantPctAmt4
	 */
	public void setClaimantPctAmt4(String claimantPctAmt4) {
		this.claimantPctAmt4 = claimantPctAmt4;
	}
	
	/**
	 * Column Info
	 * @param claimantPctAmt3
	 */
	public void setClaimantPctAmt3(String claimantPctAmt3) {
		this.claimantPctAmt3 = claimantPctAmt3;
	}
	
	/**
	 * Column Info
	 * @param claimantPctAmt2
	 */
	public void setClaimantPctAmt2(String claimantPctAmt2) {
		this.claimantPctAmt2 = claimantPctAmt2;
	}
	
	/**
	 * Column Info
	 * @param claimantPctCase1
	 */
	public void setClaimantPctCase1(String claimantPctCase1) {
		this.claimantPctCase1 = claimantPctCase1;
	}
	
	/**
	 * Column Info
	 * @param claimantPctCase0
	 */
	public void setClaimantPctCase0(String claimantPctCase0) {
		this.claimantPctCase0 = claimantPctCase0;
	}
	
	/**
	 * Column Info
	 * @param clmPtyAbbrNm
	 */
	public void setClmPtyAbbrNm(String clmPtyAbbrNm) {
		this.clmPtyAbbrNm = clmPtyAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param claimantPctCase5
	 */
	public void setClaimantPctCase5(String claimantPctCase5) {
		this.claimantPctCase5 = claimantPctCase5;
	}
	
	/**
	 * Column Info
	 * @param claimantPctCase4
	 */
	public void setClaimantPctCase4(String claimantPctCase4) {
		this.claimantPctCase4 = claimantPctCase4;
	}
	
	/**
	 * Column Info
	 * @param claimantPctCase3
	 */
	public void setClaimantPctCase3(String claimantPctCase3) {
		this.claimantPctCase3 = claimantPctCase3;
	}
	
	/**
	 * Column Info
	 * @param claimantPctCase2
	 */
	public void setClaimantPctCase2(String claimantPctCase2) {
		this.claimantPctCase2 = claimantPctCase2;
	}
	
	/**
	 * Column Info
	 * @param claimantAmt2
	 */
	public void setClaimantAmt2(String claimantAmt2) {
		this.claimantAmt2 = claimantAmt2;
	}
	
	/**
	 * Column Info
	 * @param claimantAmt1
	 */
	public void setClaimantAmt1(String claimantAmt1) {
		this.claimantAmt1 = claimantAmt1;
	}
	
	/**
	 * Column Info
	 * @param claimantAmt4
	 */
	public void setClaimantAmt4(String claimantAmt4) {
		this.claimantAmt4 = claimantAmt4;
	}
	
	/**
	 * Column Info
	 * @param claimantAmt3
	 */
	public void setClaimantAmt3(String claimantAmt3) {
		this.claimantAmt3 = claimantAmt3;
	}
	
	/**
	 * Column Info
	 * @param claimantAmt0
	 */
	public void setClaimantAmt0(String claimantAmt0) {
		this.claimantAmt0 = claimantAmt0;
	}
	
	/**
	 * Column Info
	 * @param claimantAmt6
	 */
	public void setClaimantAmt6(String claimantAmt6) {
		this.claimantAmt6 = claimantAmt6;
	}
	
	/**
	 * Column Info
	 * @param claimantAmt5
	 */
	public void setClaimantAmt5(String claimantAmt5) {
		this.claimantAmt5 = claimantAmt5;
	}
	
	/**
	 * Column Info
	 * @param claimantPctAmt0
	 */
	public void setClaimantPctAmt0(String claimantPctAmt0) {
		this.claimantPctAmt0 = claimantPctAmt0;
	}
	
	/**
	 * Column Info
	 * @param claimantPctAmt1
	 */
	public void setClaimantPctAmt1(String claimantPctAmt1) {
		this.claimantPctAmt1 = claimantPctAmt1;
	}
	
	/**
	 * Column Info
	 * @param rowNum
	 */
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
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
		setClaimantPctCase6(JSPUtil.getParameter(request, prefix + "claimant_pct_case6", ""));
		setClaimantCase2(JSPUtil.getParameter(request, prefix + "claimant_case2", ""));
		setClaimantCase1(JSPUtil.getParameter(request, prefix + "claimant_case1", ""));
		setClaimantCase0(JSPUtil.getParameter(request, prefix + "claimant_case0", ""));
		setClaimantCase6(JSPUtil.getParameter(request, prefix + "claimant_case6", ""));
		setClaimantCase5(JSPUtil.getParameter(request, prefix + "claimant_case5", ""));
		setClaimantCase4(JSPUtil.getParameter(request, prefix + "claimant_case4", ""));
		setClaimantCase3(JSPUtil.getParameter(request, prefix + "claimant_case3", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setClaimantPctAmt6(JSPUtil.getParameter(request, prefix + "claimant_pct_amt6", ""));
		setClaimantPctAmt5(JSPUtil.getParameter(request, prefix + "claimant_pct_amt5", ""));
		setClaimantPctAmt4(JSPUtil.getParameter(request, prefix + "claimant_pct_amt4", ""));
		setClaimantPctAmt3(JSPUtil.getParameter(request, prefix + "claimant_pct_amt3", ""));
		setClaimantPctAmt2(JSPUtil.getParameter(request, prefix + "claimant_pct_amt2", ""));
		setClaimantPctCase1(JSPUtil.getParameter(request, prefix + "claimant_pct_case1", ""));
		setClaimantPctCase0(JSPUtil.getParameter(request, prefix + "claimant_pct_case0", ""));
		setClmPtyAbbrNm(JSPUtil.getParameter(request, prefix + "clm_pty_abbr_nm", ""));
		setClaimantPctCase5(JSPUtil.getParameter(request, prefix + "claimant_pct_case5", ""));
		setClaimantPctCase4(JSPUtil.getParameter(request, prefix + "claimant_pct_case4", ""));
		setClaimantPctCase3(JSPUtil.getParameter(request, prefix + "claimant_pct_case3", ""));
		setClaimantPctCase2(JSPUtil.getParameter(request, prefix + "claimant_pct_case2", ""));
		setClaimantAmt2(JSPUtil.getParameter(request, prefix + "claimant_amt2", ""));
		setClaimantAmt1(JSPUtil.getParameter(request, prefix + "claimant_amt1", ""));
		setClaimantAmt4(JSPUtil.getParameter(request, prefix + "claimant_amt4", ""));
		setClaimantAmt3(JSPUtil.getParameter(request, prefix + "claimant_amt3", ""));
		setClaimantAmt0(JSPUtil.getParameter(request, prefix + "claimant_amt0", ""));
		setClaimantAmt6(JSPUtil.getParameter(request, prefix + "claimant_amt6", ""));
		setClaimantAmt5(JSPUtil.getParameter(request, prefix + "claimant_amt5", ""));
		setClaimantPctAmt0(JSPUtil.getParameter(request, prefix + "claimant_pct_amt0", ""));
		setClaimantPctAmt1(JSPUtil.getParameter(request, prefix + "claimant_pct_amt1", ""));
		setRowNum(JSPUtil.getParameter(request, prefix + "row_num", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TotalOccurrenceByClaimantVO[]
	 */
	public TotalOccurrenceByClaimantVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TotalOccurrenceByClaimantVO[]
	 */
	public TotalOccurrenceByClaimantVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TotalOccurrenceByClaimantVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] claimantPctCase6 = (JSPUtil.getParameter(request, prefix	+ "claimant_pct_case6", length));
			String[] claimantCase2 = (JSPUtil.getParameter(request, prefix	+ "claimant_case2", length));
			String[] claimantCase1 = (JSPUtil.getParameter(request, prefix	+ "claimant_case1", length));
			String[] claimantCase0 = (JSPUtil.getParameter(request, prefix	+ "claimant_case0", length));
			String[] claimantCase6 = (JSPUtil.getParameter(request, prefix	+ "claimant_case6", length));
			String[] claimantCase5 = (JSPUtil.getParameter(request, prefix	+ "claimant_case5", length));
			String[] claimantCase4 = (JSPUtil.getParameter(request, prefix	+ "claimant_case4", length));
			String[] claimantCase3 = (JSPUtil.getParameter(request, prefix	+ "claimant_case3", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] claimantPctAmt6 = (JSPUtil.getParameter(request, prefix	+ "claimant_pct_amt6", length));
			String[] claimantPctAmt5 = (JSPUtil.getParameter(request, prefix	+ "claimant_pct_amt5", length));
			String[] claimantPctAmt4 = (JSPUtil.getParameter(request, prefix	+ "claimant_pct_amt4", length));
			String[] claimantPctAmt3 = (JSPUtil.getParameter(request, prefix	+ "claimant_pct_amt3", length));
			String[] claimantPctAmt2 = (JSPUtil.getParameter(request, prefix	+ "claimant_pct_amt2", length));
			String[] claimantPctCase1 = (JSPUtil.getParameter(request, prefix	+ "claimant_pct_case1", length));
			String[] claimantPctCase0 = (JSPUtil.getParameter(request, prefix	+ "claimant_pct_case0", length));
			String[] clmPtyAbbrNm = (JSPUtil.getParameter(request, prefix	+ "clm_pty_abbr_nm", length));
			String[] claimantPctCase5 = (JSPUtil.getParameter(request, prefix	+ "claimant_pct_case5", length));
			String[] claimantPctCase4 = (JSPUtil.getParameter(request, prefix	+ "claimant_pct_case4", length));
			String[] claimantPctCase3 = (JSPUtil.getParameter(request, prefix	+ "claimant_pct_case3", length));
			String[] claimantPctCase2 = (JSPUtil.getParameter(request, prefix	+ "claimant_pct_case2", length));
			String[] claimantAmt2 = (JSPUtil.getParameter(request, prefix	+ "claimant_amt2", length));
			String[] claimantAmt1 = (JSPUtil.getParameter(request, prefix	+ "claimant_amt1", length));
			String[] claimantAmt4 = (JSPUtil.getParameter(request, prefix	+ "claimant_amt4", length));
			String[] claimantAmt3 = (JSPUtil.getParameter(request, prefix	+ "claimant_amt3", length));
			String[] claimantAmt0 = (JSPUtil.getParameter(request, prefix	+ "claimant_amt0", length));
			String[] claimantAmt6 = (JSPUtil.getParameter(request, prefix	+ "claimant_amt6", length));
			String[] claimantAmt5 = (JSPUtil.getParameter(request, prefix	+ "claimant_amt5", length));
			String[] claimantPctAmt0 = (JSPUtil.getParameter(request, prefix	+ "claimant_pct_amt0", length));
			String[] claimantPctAmt1 = (JSPUtil.getParameter(request, prefix	+ "claimant_pct_amt1", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			
			for (int i = 0; i < length; i++) {
				model = new TotalOccurrenceByClaimantVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (claimantPctCase6[i] != null)
					model.setClaimantPctCase6(claimantPctCase6[i]);
				if (claimantCase2[i] != null)
					model.setClaimantCase2(claimantCase2[i]);
				if (claimantCase1[i] != null)
					model.setClaimantCase1(claimantCase1[i]);
				if (claimantCase0[i] != null)
					model.setClaimantCase0(claimantCase0[i]);
				if (claimantCase6[i] != null)
					model.setClaimantCase6(claimantCase6[i]);
				if (claimantCase5[i] != null)
					model.setClaimantCase5(claimantCase5[i]);
				if (claimantCase4[i] != null)
					model.setClaimantCase4(claimantCase4[i]);
				if (claimantCase3[i] != null)
					model.setClaimantCase3(claimantCase3[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (claimantPctAmt6[i] != null)
					model.setClaimantPctAmt6(claimantPctAmt6[i]);
				if (claimantPctAmt5[i] != null)
					model.setClaimantPctAmt5(claimantPctAmt5[i]);
				if (claimantPctAmt4[i] != null)
					model.setClaimantPctAmt4(claimantPctAmt4[i]);
				if (claimantPctAmt3[i] != null)
					model.setClaimantPctAmt3(claimantPctAmt3[i]);
				if (claimantPctAmt2[i] != null)
					model.setClaimantPctAmt2(claimantPctAmt2[i]);
				if (claimantPctCase1[i] != null)
					model.setClaimantPctCase1(claimantPctCase1[i]);
				if (claimantPctCase0[i] != null)
					model.setClaimantPctCase0(claimantPctCase0[i]);
				if (clmPtyAbbrNm[i] != null)
					model.setClmPtyAbbrNm(clmPtyAbbrNm[i]);
				if (claimantPctCase5[i] != null)
					model.setClaimantPctCase5(claimantPctCase5[i]);
				if (claimantPctCase4[i] != null)
					model.setClaimantPctCase4(claimantPctCase4[i]);
				if (claimantPctCase3[i] != null)
					model.setClaimantPctCase3(claimantPctCase3[i]);
				if (claimantPctCase2[i] != null)
					model.setClaimantPctCase2(claimantPctCase2[i]);
				if (claimantAmt2[i] != null)
					model.setClaimantAmt2(claimantAmt2[i]);
				if (claimantAmt1[i] != null)
					model.setClaimantAmt1(claimantAmt1[i]);
				if (claimantAmt4[i] != null)
					model.setClaimantAmt4(claimantAmt4[i]);
				if (claimantAmt3[i] != null)
					model.setClaimantAmt3(claimantAmt3[i]);
				if (claimantAmt0[i] != null)
					model.setClaimantAmt0(claimantAmt0[i]);
				if (claimantAmt6[i] != null)
					model.setClaimantAmt6(claimantAmt6[i]);
				if (claimantAmt5[i] != null)
					model.setClaimantAmt5(claimantAmt5[i]);
				if (claimantPctAmt0[i] != null)
					model.setClaimantPctAmt0(claimantPctAmt0[i]);
				if (claimantPctAmt1[i] != null)
					model.setClaimantPctAmt1(claimantPctAmt1[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTotalOccurrenceByClaimantVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TotalOccurrenceByClaimantVO[]
	 */
	public TotalOccurrenceByClaimantVO[] getTotalOccurrenceByClaimantVOs(){
		TotalOccurrenceByClaimantVO[] vos = (TotalOccurrenceByClaimantVO[])models.toArray(new TotalOccurrenceByClaimantVO[models.size()]);
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
		this.claimantPctCase6 = this.claimantPctCase6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantCase2 = this.claimantCase2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantCase1 = this.claimantCase1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantCase0 = this.claimantCase0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantCase6 = this.claimantCase6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantCase5 = this.claimantCase5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantCase4 = this.claimantCase4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantCase3 = this.claimantCase3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantPctAmt6 = this.claimantPctAmt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantPctAmt5 = this.claimantPctAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantPctAmt4 = this.claimantPctAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantPctAmt3 = this.claimantPctAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantPctAmt2 = this.claimantPctAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantPctCase1 = this.claimantPctCase1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantPctCase0 = this.claimantPctCase0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyAbbrNm = this.clmPtyAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantPctCase5 = this.claimantPctCase5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantPctCase4 = this.claimantPctCase4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantPctCase3 = this.claimantPctCase3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantPctCase2 = this.claimantPctCase2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantAmt2 = this.claimantAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantAmt1 = this.claimantAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantAmt4 = this.claimantAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantAmt3 = this.claimantAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantAmt0 = this.claimantAmt0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantAmt6 = this.claimantAmt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantAmt5 = this.claimantAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantPctAmt0 = this.claimantPctAmt0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimantPctAmt1 = this.claimantPctAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
