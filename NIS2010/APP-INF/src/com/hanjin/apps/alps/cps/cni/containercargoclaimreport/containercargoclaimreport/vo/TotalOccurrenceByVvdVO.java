/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TotalOccurrenceByVvdVO.java
*@FileTitle : TotalOccurrenceByVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2010.02.04 박제성 
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

public class TotalOccurrenceByVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TotalOccurrenceByVvdVO> models = new ArrayList<TotalOccurrenceByVvdVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String trnkRefVvdNo = null;
	/* Column Info */
	private String vvdCase2 = null;
	/* Column Info */
	private String vvdCase3 = null;
	/* Column Info */
	private String vvdCase0 = null;
	/* Column Info */
	private String vvdCase1 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdPctCase5 = null;
	/* Column Info */
	private String vvdPctCase6 = null;
	/* Column Info */
	private String vvdPctCase0 = null;
	/* Column Info */
	private String vvdPctCase3 = null;
	/* Column Info */
	private String vvdPctCase4 = null;
	/* Column Info */
	private String vvdPctCase1 = null;
	/* Column Info */
	private String vvdPctCase2 = null;
	/* Column Info */
	private String vvdPctAmt6 = null;
	/* Column Info */
	private String vvdPctAmt5 = null;
	/* Column Info */
	private String vvdPctAmt4 = null;
	/* Column Info */
	private String vvdPctAmt3 = null;
	/* Column Info */
	private String vvdPctAmt2 = null;
	/* Column Info */
	private String vvdPctAmt1 = null;
	/* Column Info */
	private String vvdPctAmt0 = null;
	/* Column Info */
	private String vvdAmt2 = null;
	/* Column Info */
	private String vvdAmt3 = null;
	/* Column Info */
	private String vvdAmt0 = null;
	/* Column Info */
	private String vvdAmt1 = null;
	/* Column Info */
	private String vvdCase5 = null;
	/* Column Info */
	private String vvdAmt6 = null;
	/* Column Info */
	private String vvdCase4 = null;
	/* Column Info */
	private String vvdAmt5 = null;
	/* Column Info */
	private String vvdCase6 = null;
	/* Column Info */
	private String vvdAmt4 = null;
	/* Column Info */
	private String rowNum = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TotalOccurrenceByVvdVO() {}

	public TotalOccurrenceByVvdVO(String ibflag, String pagerows, String trnkRefVvdNo, String vvdCase0, String vvdPctCase0, String vvdAmt0, String vvdPctAmt0, String vvdCase1, String vvdPctCase1, String vvdAmt1, String vvdPctAmt1, String vvdCase2, String vvdPctCase2, String vvdAmt2, String vvdPctAmt2, String vvdCase3, String vvdPctCase3, String vvdAmt3, String vvdPctAmt3, String vvdCase4, String vvdPctCase4, String vvdAmt4, String vvdPctAmt4, String vvdCase5, String vvdPctCase5, String vvdAmt5, String vvdPctAmt5, String vvdCase6, String vvdPctCase6, String vvdAmt6, String vvdPctAmt6, String rowNum, String total) {
		this.total = total;
		this.trnkRefVvdNo = trnkRefVvdNo;
		this.vvdCase2 = vvdCase2;
		this.vvdCase3 = vvdCase3;
		this.vvdCase0 = vvdCase0;
		this.vvdCase1 = vvdCase1;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.vvdPctCase5 = vvdPctCase5;
		this.vvdPctCase6 = vvdPctCase6;
		this.vvdPctCase0 = vvdPctCase0;
		this.vvdPctCase3 = vvdPctCase3;
		this.vvdPctCase4 = vvdPctCase4;
		this.vvdPctCase1 = vvdPctCase1;
		this.vvdPctCase2 = vvdPctCase2;
		this.vvdPctAmt6 = vvdPctAmt6;
		this.vvdPctAmt5 = vvdPctAmt5;
		this.vvdPctAmt4 = vvdPctAmt4;
		this.vvdPctAmt3 = vvdPctAmt3;
		this.vvdPctAmt2 = vvdPctAmt2;
		this.vvdPctAmt1 = vvdPctAmt1;
		this.vvdPctAmt0 = vvdPctAmt0;
		this.vvdAmt2 = vvdAmt2;
		this.vvdAmt3 = vvdAmt3;
		this.vvdAmt0 = vvdAmt0;
		this.vvdAmt1 = vvdAmt1;
		this.vvdCase5 = vvdCase5;
		this.vvdAmt6 = vvdAmt6;
		this.vvdCase4 = vvdCase4;
		this.vvdAmt5 = vvdAmt5;
		this.vvdCase6 = vvdCase6;
		this.vvdAmt4 = vvdAmt4;
		this.rowNum = rowNum;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("trnk_ref_vvd_no", getTrnkRefVvdNo());
		this.hashColumns.put("vvd_case2", getVvdCase2());
		this.hashColumns.put("vvd_case3", getVvdCase3());
		this.hashColumns.put("vvd_case0", getVvdCase0());
		this.hashColumns.put("vvd_case1", getVvdCase1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_pct_case5", getVvdPctCase5());
		this.hashColumns.put("vvd_pct_case6", getVvdPctCase6());
		this.hashColumns.put("vvd_pct_case0", getVvdPctCase0());
		this.hashColumns.put("vvd_pct_case3", getVvdPctCase3());
		this.hashColumns.put("vvd_pct_case4", getVvdPctCase4());
		this.hashColumns.put("vvd_pct_case1", getVvdPctCase1());
		this.hashColumns.put("vvd_pct_case2", getVvdPctCase2());
		this.hashColumns.put("vvd_pct_amt6", getVvdPctAmt6());
		this.hashColumns.put("vvd_pct_amt5", getVvdPctAmt5());
		this.hashColumns.put("vvd_pct_amt4", getVvdPctAmt4());
		this.hashColumns.put("vvd_pct_amt3", getVvdPctAmt3());
		this.hashColumns.put("vvd_pct_amt2", getVvdPctAmt2());
		this.hashColumns.put("vvd_pct_amt1", getVvdPctAmt1());
		this.hashColumns.put("vvd_pct_amt0", getVvdPctAmt0());
		this.hashColumns.put("vvd_amt2", getVvdAmt2());
		this.hashColumns.put("vvd_amt3", getVvdAmt3());
		this.hashColumns.put("vvd_amt0", getVvdAmt0());
		this.hashColumns.put("vvd_amt1", getVvdAmt1());
		this.hashColumns.put("vvd_case5", getVvdCase5());
		this.hashColumns.put("vvd_amt6", getVvdAmt6());
		this.hashColumns.put("vvd_case4", getVvdCase4());
		this.hashColumns.put("vvd_amt5", getVvdAmt5());
		this.hashColumns.put("vvd_case6", getVvdCase6());
		this.hashColumns.put("vvd_amt4", getVvdAmt4());
		this.hashColumns.put("row_num", getRowNum());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("trnk_ref_vvd_no", "trnkRefVvdNo");
		this.hashFields.put("vvd_case2", "vvdCase2");
		this.hashFields.put("vvd_case3", "vvdCase3");
		this.hashFields.put("vvd_case0", "vvdCase0");
		this.hashFields.put("vvd_case1", "vvdCase1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_pct_case5", "vvdPctCase5");
		this.hashFields.put("vvd_pct_case6", "vvdPctCase6");
		this.hashFields.put("vvd_pct_case0", "vvdPctCase0");
		this.hashFields.put("vvd_pct_case3", "vvdPctCase3");
		this.hashFields.put("vvd_pct_case4", "vvdPctCase4");
		this.hashFields.put("vvd_pct_case1", "vvdPctCase1");
		this.hashFields.put("vvd_pct_case2", "vvdPctCase2");
		this.hashFields.put("vvd_pct_amt6", "vvdPctAmt6");
		this.hashFields.put("vvd_pct_amt5", "vvdPctAmt5");
		this.hashFields.put("vvd_pct_amt4", "vvdPctAmt4");
		this.hashFields.put("vvd_pct_amt3", "vvdPctAmt3");
		this.hashFields.put("vvd_pct_amt2", "vvdPctAmt2");
		this.hashFields.put("vvd_pct_amt1", "vvdPctAmt1");
		this.hashFields.put("vvd_pct_amt0", "vvdPctAmt0");
		this.hashFields.put("vvd_amt2", "vvdAmt2");
		this.hashFields.put("vvd_amt3", "vvdAmt3");
		this.hashFields.put("vvd_amt0", "vvdAmt0");
		this.hashFields.put("vvd_amt1", "vvdAmt1");
		this.hashFields.put("vvd_case5", "vvdCase5");
		this.hashFields.put("vvd_amt6", "vvdAmt6");
		this.hashFields.put("vvd_case4", "vvdCase4");
		this.hashFields.put("vvd_amt5", "vvdAmt5");
		this.hashFields.put("vvd_case6", "vvdCase6");
		this.hashFields.put("vvd_amt4", "vvdAmt4");
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
	 * @return trnkRefVvdNo
	 */
	public String getTrnkRefVvdNo() {
		return this.trnkRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @return vvdCase2
	 */
	public String getVvdCase2() {
		return this.vvdCase2;
	}
	
	/**
	 * Column Info
	 * @return vvdCase3
	 */
	public String getVvdCase3() {
		return this.vvdCase3;
	}
	
	/**
	 * Column Info
	 * @return vvdCase0
	 */
	public String getVvdCase0() {
		return this.vvdCase0;
	}
	
	/**
	 * Column Info
	 * @return vvdCase1
	 */
	public String getVvdCase1() {
		return this.vvdCase1;
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
	 * @return vvdPctCase5
	 */
	public String getVvdPctCase5() {
		return this.vvdPctCase5;
	}
	
	/**
	 * Column Info
	 * @return vvdPctCase6
	 */
	public String getVvdPctCase6() {
		return this.vvdPctCase6;
	}
	
	/**
	 * Column Info
	 * @return vvdPctCase0
	 */
	public String getVvdPctCase0() {
		return this.vvdPctCase0;
	}
	
	/**
	 * Column Info
	 * @return vvdPctCase3
	 */
	public String getVvdPctCase3() {
		return this.vvdPctCase3;
	}
	
	/**
	 * Column Info
	 * @return vvdPctCase4
	 */
	public String getVvdPctCase4() {
		return this.vvdPctCase4;
	}
	
	/**
	 * Column Info
	 * @return vvdPctCase1
	 */
	public String getVvdPctCase1() {
		return this.vvdPctCase1;
	}
	
	/**
	 * Column Info
	 * @return vvdPctCase2
	 */
	public String getVvdPctCase2() {
		return this.vvdPctCase2;
	}
	
	/**
	 * Column Info
	 * @return vvdPctAmt6
	 */
	public String getVvdPctAmt6() {
		return this.vvdPctAmt6;
	}
	
	/**
	 * Column Info
	 * @return vvdPctAmt5
	 */
	public String getVvdPctAmt5() {
		return this.vvdPctAmt5;
	}
	
	/**
	 * Column Info
	 * @return vvdPctAmt4
	 */
	public String getVvdPctAmt4() {
		return this.vvdPctAmt4;
	}
	
	/**
	 * Column Info
	 * @return vvdPctAmt3
	 */
	public String getVvdPctAmt3() {
		return this.vvdPctAmt3;
	}
	
	/**
	 * Column Info
	 * @return vvdPctAmt2
	 */
	public String getVvdPctAmt2() {
		return this.vvdPctAmt2;
	}
	
	/**
	 * Column Info
	 * @return vvdPctAmt1
	 */
	public String getVvdPctAmt1() {
		return this.vvdPctAmt1;
	}
	
	/**
	 * Column Info
	 * @return vvdPctAmt0
	 */
	public String getVvdPctAmt0() {
		return this.vvdPctAmt0;
	}
	
	/**
	 * Column Info
	 * @return vvdAmt2
	 */
	public String getVvdAmt2() {
		return this.vvdAmt2;
	}
	
	/**
	 * Column Info
	 * @return vvdAmt3
	 */
	public String getVvdAmt3() {
		return this.vvdAmt3;
	}
	
	/**
	 * Column Info
	 * @return vvdAmt0
	 */
	public String getVvdAmt0() {
		return this.vvdAmt0;
	}
	
	/**
	 * Column Info
	 * @return vvdAmt1
	 */
	public String getVvdAmt1() {
		return this.vvdAmt1;
	}
	
	/**
	 * Column Info
	 * @return vvdCase5
	 */
	public String getVvdCase5() {
		return this.vvdCase5;
	}
	
	/**
	 * Column Info
	 * @return vvdAmt6
	 */
	public String getVvdAmt6() {
		return this.vvdAmt6;
	}
	
	/**
	 * Column Info
	 * @return vvdCase4
	 */
	public String getVvdCase4() {
		return this.vvdCase4;
	}
	
	/**
	 * Column Info
	 * @return vvdAmt5
	 */
	public String getVvdAmt5() {
		return this.vvdAmt5;
	}
	
	/**
	 * Column Info
	 * @return vvdCase6
	 */
	public String getVvdCase6() {
		return this.vvdCase6;
	}
	
	/**
	 * Column Info
	 * @return vvdAmt4
	 */
	public String getVvdAmt4() {
		return this.vvdAmt4;
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
	 * @param trnkRefVvdNo
	 */
	public void setTrnkRefVvdNo(String trnkRefVvdNo) {
		this.trnkRefVvdNo = trnkRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @param vvdCase2
	 */
	public void setVvdCase2(String vvdCase2) {
		this.vvdCase2 = vvdCase2;
	}
	
	/**
	 * Column Info
	 * @param vvdCase3
	 */
	public void setVvdCase3(String vvdCase3) {
		this.vvdCase3 = vvdCase3;
	}
	
	/**
	 * Column Info
	 * @param vvdCase0
	 */
	public void setVvdCase0(String vvdCase0) {
		this.vvdCase0 = vvdCase0;
	}
	
	/**
	 * Column Info
	 * @param vvdCase1
	 */
	public void setVvdCase1(String vvdCase1) {
		this.vvdCase1 = vvdCase1;
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
	 * @param vvdPctCase5
	 */
	public void setVvdPctCase5(String vvdPctCase5) {
		this.vvdPctCase5 = vvdPctCase5;
	}
	
	/**
	 * Column Info
	 * @param vvdPctCase6
	 */
	public void setVvdPctCase6(String vvdPctCase6) {
		this.vvdPctCase6 = vvdPctCase6;
	}
	
	/**
	 * Column Info
	 * @param vvdPctCase0
	 */
	public void setVvdPctCase0(String vvdPctCase0) {
		this.vvdPctCase0 = vvdPctCase0;
	}
	
	/**
	 * Column Info
	 * @param vvdPctCase3
	 */
	public void setVvdPctCase3(String vvdPctCase3) {
		this.vvdPctCase3 = vvdPctCase3;
	}
	
	/**
	 * Column Info
	 * @param vvdPctCase4
	 */
	public void setVvdPctCase4(String vvdPctCase4) {
		this.vvdPctCase4 = vvdPctCase4;
	}
	
	/**
	 * Column Info
	 * @param vvdPctCase1
	 */
	public void setVvdPctCase1(String vvdPctCase1) {
		this.vvdPctCase1 = vvdPctCase1;
	}
	
	/**
	 * Column Info
	 * @param vvdPctCase2
	 */
	public void setVvdPctCase2(String vvdPctCase2) {
		this.vvdPctCase2 = vvdPctCase2;
	}
	
	/**
	 * Column Info
	 * @param vvdPctAmt6
	 */
	public void setVvdPctAmt6(String vvdPctAmt6) {
		this.vvdPctAmt6 = vvdPctAmt6;
	}
	
	/**
	 * Column Info
	 * @param vvdPctAmt5
	 */
	public void setVvdPctAmt5(String vvdPctAmt5) {
		this.vvdPctAmt5 = vvdPctAmt5;
	}
	
	/**
	 * Column Info
	 * @param vvdPctAmt4
	 */
	public void setVvdPctAmt4(String vvdPctAmt4) {
		this.vvdPctAmt4 = vvdPctAmt4;
	}
	
	/**
	 * Column Info
	 * @param vvdPctAmt3
	 */
	public void setVvdPctAmt3(String vvdPctAmt3) {
		this.vvdPctAmt3 = vvdPctAmt3;
	}
	
	/**
	 * Column Info
	 * @param vvdPctAmt2
	 */
	public void setVvdPctAmt2(String vvdPctAmt2) {
		this.vvdPctAmt2 = vvdPctAmt2;
	}
	
	/**
	 * Column Info
	 * @param vvdPctAmt1
	 */
	public void setVvdPctAmt1(String vvdPctAmt1) {
		this.vvdPctAmt1 = vvdPctAmt1;
	}
	
	/**
	 * Column Info
	 * @param vvdPctAmt0
	 */
	public void setVvdPctAmt0(String vvdPctAmt0) {
		this.vvdPctAmt0 = vvdPctAmt0;
	}
	
	/**
	 * Column Info
	 * @param vvdAmt2
	 */
	public void setVvdAmt2(String vvdAmt2) {
		this.vvdAmt2 = vvdAmt2;
	}
	
	/**
	 * Column Info
	 * @param vvdAmt3
	 */
	public void setVvdAmt3(String vvdAmt3) {
		this.vvdAmt3 = vvdAmt3;
	}
	
	/**
	 * Column Info
	 * @param vvdAmt0
	 */
	public void setVvdAmt0(String vvdAmt0) {
		this.vvdAmt0 = vvdAmt0;
	}
	
	/**
	 * Column Info
	 * @param vvdAmt1
	 */
	public void setVvdAmt1(String vvdAmt1) {
		this.vvdAmt1 = vvdAmt1;
	}
	
	/**
	 * Column Info
	 * @param vvdCase5
	 */
	public void setVvdCase5(String vvdCase5) {
		this.vvdCase5 = vvdCase5;
	}
	
	/**
	 * Column Info
	 * @param vvdAmt6
	 */
	public void setVvdAmt6(String vvdAmt6) {
		this.vvdAmt6 = vvdAmt6;
	}
	
	/**
	 * Column Info
	 * @param vvdCase4
	 */
	public void setVvdCase4(String vvdCase4) {
		this.vvdCase4 = vvdCase4;
	}
	
	/**
	 * Column Info
	 * @param vvdAmt5
	 */
	public void setVvdAmt5(String vvdAmt5) {
		this.vvdAmt5 = vvdAmt5;
	}
	
	/**
	 * Column Info
	 * @param vvdCase6
	 */
	public void setVvdCase6(String vvdCase6) {
		this.vvdCase6 = vvdCase6;
	}
	
	/**
	 * Column Info
	 * @param vvdAmt4
	 */
	public void setVvdAmt4(String vvdAmt4) {
		this.vvdAmt4 = vvdAmt4;
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
		setTrnkRefVvdNo(JSPUtil.getParameter(request, prefix + "trnk_ref_vvd_no", ""));
		setVvdCase2(JSPUtil.getParameter(request, prefix + "vvd_case2", ""));
		setVvdCase3(JSPUtil.getParameter(request, prefix + "vvd_case3", ""));
		setVvdCase0(JSPUtil.getParameter(request, prefix + "vvd_case0", ""));
		setVvdCase1(JSPUtil.getParameter(request, prefix + "vvd_case1", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdPctCase5(JSPUtil.getParameter(request, prefix + "vvd_pct_case5", ""));
		setVvdPctCase6(JSPUtil.getParameter(request, prefix + "vvd_pct_case6", ""));
		setVvdPctCase0(JSPUtil.getParameter(request, prefix + "vvd_pct_case0", ""));
		setVvdPctCase3(JSPUtil.getParameter(request, prefix + "vvd_pct_case3", ""));
		setVvdPctCase4(JSPUtil.getParameter(request, prefix + "vvd_pct_case4", ""));
		setVvdPctCase1(JSPUtil.getParameter(request, prefix + "vvd_pct_case1", ""));
		setVvdPctCase2(JSPUtil.getParameter(request, prefix + "vvd_pct_case2", ""));
		setVvdPctAmt6(JSPUtil.getParameter(request, prefix + "vvd_pct_amt6", ""));
		setVvdPctAmt5(JSPUtil.getParameter(request, prefix + "vvd_pct_amt5", ""));
		setVvdPctAmt4(JSPUtil.getParameter(request, prefix + "vvd_pct_amt4", ""));
		setVvdPctAmt3(JSPUtil.getParameter(request, prefix + "vvd_pct_amt3", ""));
		setVvdPctAmt2(JSPUtil.getParameter(request, prefix + "vvd_pct_amt2", ""));
		setVvdPctAmt1(JSPUtil.getParameter(request, prefix + "vvd_pct_amt1", ""));
		setVvdPctAmt0(JSPUtil.getParameter(request, prefix + "vvd_pct_amt0", ""));
		setVvdAmt2(JSPUtil.getParameter(request, prefix + "vvd_amt2", ""));
		setVvdAmt3(JSPUtil.getParameter(request, prefix + "vvd_amt3", ""));
		setVvdAmt0(JSPUtil.getParameter(request, prefix + "vvd_amt0", ""));
		setVvdAmt1(JSPUtil.getParameter(request, prefix + "vvd_amt1", ""));
		setVvdCase5(JSPUtil.getParameter(request, prefix + "vvd_case5", ""));
		setVvdAmt6(JSPUtil.getParameter(request, prefix + "vvd_amt6", ""));
		setVvdCase4(JSPUtil.getParameter(request, prefix + "vvd_case4", ""));
		setVvdAmt5(JSPUtil.getParameter(request, prefix + "vvd_amt5", ""));
		setVvdCase6(JSPUtil.getParameter(request, prefix + "vvd_case6", ""));
		setVvdAmt4(JSPUtil.getParameter(request, prefix + "vvd_amt4", ""));
		setRowNum(JSPUtil.getParameter(request, prefix + "row_num", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TotalOccurrenceByVvdVO[]
	 */
	public TotalOccurrenceByVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TotalOccurrenceByVvdVO[]
	 */
	public TotalOccurrenceByVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TotalOccurrenceByVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] trnkRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "trnk_ref_vvd_no", length));
			String[] vvdCase2 = (JSPUtil.getParameter(request, prefix	+ "vvd_case2", length));
			String[] vvdCase3 = (JSPUtil.getParameter(request, prefix	+ "vvd_case3", length));
			String[] vvdCase0 = (JSPUtil.getParameter(request, prefix	+ "vvd_case0", length));
			String[] vvdCase1 = (JSPUtil.getParameter(request, prefix	+ "vvd_case1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdPctCase5 = (JSPUtil.getParameter(request, prefix	+ "vvd_pct_case5", length));
			String[] vvdPctCase6 = (JSPUtil.getParameter(request, prefix	+ "vvd_pct_case6", length));
			String[] vvdPctCase0 = (JSPUtil.getParameter(request, prefix	+ "vvd_pct_case0", length));
			String[] vvdPctCase3 = (JSPUtil.getParameter(request, prefix	+ "vvd_pct_case3", length));
			String[] vvdPctCase4 = (JSPUtil.getParameter(request, prefix	+ "vvd_pct_case4", length));
			String[] vvdPctCase1 = (JSPUtil.getParameter(request, prefix	+ "vvd_pct_case1", length));
			String[] vvdPctCase2 = (JSPUtil.getParameter(request, prefix	+ "vvd_pct_case2", length));
			String[] vvdPctAmt6 = (JSPUtil.getParameter(request, prefix	+ "vvd_pct_amt6", length));
			String[] vvdPctAmt5 = (JSPUtil.getParameter(request, prefix	+ "vvd_pct_amt5", length));
			String[] vvdPctAmt4 = (JSPUtil.getParameter(request, prefix	+ "vvd_pct_amt4", length));
			String[] vvdPctAmt3 = (JSPUtil.getParameter(request, prefix	+ "vvd_pct_amt3", length));
			String[] vvdPctAmt2 = (JSPUtil.getParameter(request, prefix	+ "vvd_pct_amt2", length));
			String[] vvdPctAmt1 = (JSPUtil.getParameter(request, prefix	+ "vvd_pct_amt1", length));
			String[] vvdPctAmt0 = (JSPUtil.getParameter(request, prefix	+ "vvd_pct_amt0", length));
			String[] vvdAmt2 = (JSPUtil.getParameter(request, prefix	+ "vvd_amt2", length));
			String[] vvdAmt3 = (JSPUtil.getParameter(request, prefix	+ "vvd_amt3", length));
			String[] vvdAmt0 = (JSPUtil.getParameter(request, prefix	+ "vvd_amt0", length));
			String[] vvdAmt1 = (JSPUtil.getParameter(request, prefix	+ "vvd_amt1", length));
			String[] vvdCase5 = (JSPUtil.getParameter(request, prefix	+ "vvd_case5", length));
			String[] vvdAmt6 = (JSPUtil.getParameter(request, prefix	+ "vvd_amt6", length));
			String[] vvdCase4 = (JSPUtil.getParameter(request, prefix	+ "vvd_case4", length));
			String[] vvdAmt5 = (JSPUtil.getParameter(request, prefix	+ "vvd_amt5", length));
			String[] vvdCase6 = (JSPUtil.getParameter(request, prefix	+ "vvd_case6", length));
			String[] vvdAmt4 = (JSPUtil.getParameter(request, prefix	+ "vvd_amt4", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			
			for (int i = 0; i < length; i++) {
				model = new TotalOccurrenceByVvdVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (trnkRefVvdNo[i] != null)
					model.setTrnkRefVvdNo(trnkRefVvdNo[i]);
				if (vvdCase2[i] != null)
					model.setVvdCase2(vvdCase2[i]);
				if (vvdCase3[i] != null)
					model.setVvdCase3(vvdCase3[i]);
				if (vvdCase0[i] != null)
					model.setVvdCase0(vvdCase0[i]);
				if (vvdCase1[i] != null)
					model.setVvdCase1(vvdCase1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdPctCase5[i] != null)
					model.setVvdPctCase5(vvdPctCase5[i]);
				if (vvdPctCase6[i] != null)
					model.setVvdPctCase6(vvdPctCase6[i]);
				if (vvdPctCase0[i] != null)
					model.setVvdPctCase0(vvdPctCase0[i]);
				if (vvdPctCase3[i] != null)
					model.setVvdPctCase3(vvdPctCase3[i]);
				if (vvdPctCase4[i] != null)
					model.setVvdPctCase4(vvdPctCase4[i]);
				if (vvdPctCase1[i] != null)
					model.setVvdPctCase1(vvdPctCase1[i]);
				if (vvdPctCase2[i] != null)
					model.setVvdPctCase2(vvdPctCase2[i]);
				if (vvdPctAmt6[i] != null)
					model.setVvdPctAmt6(vvdPctAmt6[i]);
				if (vvdPctAmt5[i] != null)
					model.setVvdPctAmt5(vvdPctAmt5[i]);
				if (vvdPctAmt4[i] != null)
					model.setVvdPctAmt4(vvdPctAmt4[i]);
				if (vvdPctAmt3[i] != null)
					model.setVvdPctAmt3(vvdPctAmt3[i]);
				if (vvdPctAmt2[i] != null)
					model.setVvdPctAmt2(vvdPctAmt2[i]);
				if (vvdPctAmt1[i] != null)
					model.setVvdPctAmt1(vvdPctAmt1[i]);
				if (vvdPctAmt0[i] != null)
					model.setVvdPctAmt0(vvdPctAmt0[i]);
				if (vvdAmt2[i] != null)
					model.setVvdAmt2(vvdAmt2[i]);
				if (vvdAmt3[i] != null)
					model.setVvdAmt3(vvdAmt3[i]);
				if (vvdAmt0[i] != null)
					model.setVvdAmt0(vvdAmt0[i]);
				if (vvdAmt1[i] != null)
					model.setVvdAmt1(vvdAmt1[i]);
				if (vvdCase5[i] != null)
					model.setVvdCase5(vvdCase5[i]);
				if (vvdAmt6[i] != null)
					model.setVvdAmt6(vvdAmt6[i]);
				if (vvdCase4[i] != null)
					model.setVvdCase4(vvdCase4[i]);
				if (vvdAmt5[i] != null)
					model.setVvdAmt5(vvdAmt5[i]);
				if (vvdCase6[i] != null)
					model.setVvdCase6(vvdCase6[i]);
				if (vvdAmt4[i] != null)
					model.setVvdAmt4(vvdAmt4[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTotalOccurrenceByVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TotalOccurrenceByVvdVO[]
	 */
	public TotalOccurrenceByVvdVO[] getTotalOccurrenceByVvdVOs(){
		TotalOccurrenceByVvdVO[] vos = (TotalOccurrenceByVvdVO[])models.toArray(new TotalOccurrenceByVvdVO[models.size()]);
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
		this.trnkRefVvdNo = this.trnkRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCase2 = this.vvdCase2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCase3 = this.vvdCase3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCase0 = this.vvdCase0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCase1 = this.vvdCase1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPctCase5 = this.vvdPctCase5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPctCase6 = this.vvdPctCase6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPctCase0 = this.vvdPctCase0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPctCase3 = this.vvdPctCase3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPctCase4 = this.vvdPctCase4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPctCase1 = this.vvdPctCase1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPctCase2 = this.vvdPctCase2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPctAmt6 = this.vvdPctAmt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPctAmt5 = this.vvdPctAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPctAmt4 = this.vvdPctAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPctAmt3 = this.vvdPctAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPctAmt2 = this.vvdPctAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPctAmt1 = this.vvdPctAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPctAmt0 = this.vvdPctAmt0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdAmt2 = this.vvdAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdAmt3 = this.vvdAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdAmt0 = this.vvdAmt0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdAmt1 = this.vvdAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCase5 = this.vvdCase5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdAmt6 = this.vvdAmt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCase4 = this.vvdCase4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdAmt5 = this.vvdAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCase6 = this.vvdCase6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdAmt4 = this.vvdAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
