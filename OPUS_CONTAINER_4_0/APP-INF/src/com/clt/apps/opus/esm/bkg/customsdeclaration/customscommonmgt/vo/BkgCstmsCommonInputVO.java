/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BkgCstmsCommonInputVO.java
*@FileTitle : BkgCstmsCommonInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.14  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCstmsCommonInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCstmsCommonInputVO> models = new ArrayList<BkgCstmsCommonInputVO>();
	
	/* Column Info */
	private String tblNm9 = null;
	/* Column Info */
	private String tblNm6 = null;
	/* Column Info */
	private String tblNm5 = null;
	/* Column Info */
	private String tblNm8 = null;
	/* Column Info */
	private String tblNm7 = null;
	/* Column Info */
	private String tblNm2 = null;
	/* Column Info */
	private String tblNm1 = null;
	/* Column Info */
	private String tblNm4 = null;
	/* Column Info */
	private String tblNm3 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rtnCol9 = null;
	/* Column Info */
	private String rtnCol8 = null;
	/* Column Info */
	private String rtnCol7 = null;
	/* Column Info */
	private String rtnCol6 = null;
	/* Column Info */
	private String rtnCol5 = null;
	/* Column Info */
	private String rtnCol4 = null;
	/* Column Info */
	private String whrVal1 = null;
	/* Column Info */
	private String whrVal3 = null;
	/* Column Info */
	private String whrVal2 = null;
	/* Column Info */
	private String whrVal5 = null;
	/* Column Info */
	private String rtnCol1 = null;
	/* Column Info */
	private String whrVal4 = null;
	/* Column Info */
	private String whrVal7 = null;
	/* Column Info */
	private String rtnCol2 = null;
	/* Column Info */
	private String whrVal6 = null;
	/* Column Info */
	private String rtnCol3 = null;
	/* Column Info */
	private String whrVal9 = null;
	/* Column Info */
	private String whrVal8 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgCstmsCommonInputVO() {}

	public BkgCstmsCommonInputVO(String ibflag, String pagerows, String rtnCol1, String rtnCol2, String rtnCol3, String rtnCol4, String rtnCol5, String rtnCol6, String rtnCol7, String rtnCol8, String rtnCol9, String tblNm1, String tblNm2, String tblNm3, String tblNm4, String tblNm5, String tblNm6, String tblNm7, String tblNm8, String tblNm9, String whrVal1, String whrVal2, String whrVal3, String whrVal4, String whrVal5, String whrVal6, String whrVal7, String whrVal8, String whrVal9) {
		this.tblNm9 = tblNm9;
		this.tblNm6 = tblNm6;
		this.tblNm5 = tblNm5;
		this.tblNm8 = tblNm8;
		this.tblNm7 = tblNm7;
		this.tblNm2 = tblNm2;
		this.tblNm1 = tblNm1;
		this.tblNm4 = tblNm4;
		this.tblNm3 = tblNm3;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.rtnCol9 = rtnCol9;
		this.rtnCol8 = rtnCol8;
		this.rtnCol7 = rtnCol7;
		this.rtnCol6 = rtnCol6;
		this.rtnCol5 = rtnCol5;
		this.rtnCol4 = rtnCol4;
		this.whrVal1 = whrVal1;
		this.whrVal3 = whrVal3;
		this.whrVal2 = whrVal2;
		this.whrVal5 = whrVal5;
		this.rtnCol1 = rtnCol1;
		this.whrVal4 = whrVal4;
		this.whrVal7 = whrVal7;
		this.rtnCol2 = rtnCol2;
		this.whrVal6 = whrVal6;
		this.rtnCol3 = rtnCol3;
		this.whrVal9 = whrVal9;
		this.whrVal8 = whrVal8;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tbl_nm_9", getTblNm9());
		this.hashColumns.put("tbl_nm_6", getTblNm6());
		this.hashColumns.put("tbl_nm_5", getTblNm5());
		this.hashColumns.put("tbl_nm_8", getTblNm8());
		this.hashColumns.put("tbl_nm_7", getTblNm7());
		this.hashColumns.put("tbl_nm_2", getTblNm2());
		this.hashColumns.put("tbl_nm_1", getTblNm1());
		this.hashColumns.put("tbl_nm_4", getTblNm4());
		this.hashColumns.put("tbl_nm_3", getTblNm3());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rtn_col_9", getRtnCol9());
		this.hashColumns.put("rtn_col_8", getRtnCol8());
		this.hashColumns.put("rtn_col_7", getRtnCol7());
		this.hashColumns.put("rtn_col_6", getRtnCol6());
		this.hashColumns.put("rtn_col_5", getRtnCol5());
		this.hashColumns.put("rtn_col_4", getRtnCol4());
		this.hashColumns.put("whr_val_1", getWhrVal1());
		this.hashColumns.put("whr_val_3", getWhrVal3());
		this.hashColumns.put("whr_val_2", getWhrVal2());
		this.hashColumns.put("whr_val_5", getWhrVal5());
		this.hashColumns.put("rtn_col_1", getRtnCol1());
		this.hashColumns.put("whr_val_4", getWhrVal4());
		this.hashColumns.put("whr_val_7", getWhrVal7());
		this.hashColumns.put("rtn_col_2", getRtnCol2());
		this.hashColumns.put("whr_val_6", getWhrVal6());
		this.hashColumns.put("rtn_col_3", getRtnCol3());
		this.hashColumns.put("whr_val_9", getWhrVal9());
		this.hashColumns.put("whr_val_8", getWhrVal8());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tbl_nm_9", "tblNm9");
		this.hashFields.put("tbl_nm_6", "tblNm6");
		this.hashFields.put("tbl_nm_5", "tblNm5");
		this.hashFields.put("tbl_nm_8", "tblNm8");
		this.hashFields.put("tbl_nm_7", "tblNm7");
		this.hashFields.put("tbl_nm_2", "tblNm2");
		this.hashFields.put("tbl_nm_1", "tblNm1");
		this.hashFields.put("tbl_nm_4", "tblNm4");
		this.hashFields.put("tbl_nm_3", "tblNm3");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rtn_col_9", "rtnCol9");
		this.hashFields.put("rtn_col_8", "rtnCol8");
		this.hashFields.put("rtn_col_7", "rtnCol7");
		this.hashFields.put("rtn_col_6", "rtnCol6");
		this.hashFields.put("rtn_col_5", "rtnCol5");
		this.hashFields.put("rtn_col_4", "rtnCol4");
		this.hashFields.put("whr_val_1", "whrVal1");
		this.hashFields.put("whr_val_3", "whrVal3");
		this.hashFields.put("whr_val_2", "whrVal2");
		this.hashFields.put("whr_val_5", "whrVal5");
		this.hashFields.put("rtn_col_1", "rtnCol1");
		this.hashFields.put("whr_val_4", "whrVal4");
		this.hashFields.put("whr_val_7", "whrVal7");
		this.hashFields.put("rtn_col_2", "rtnCol2");
		this.hashFields.put("whr_val_6", "whrVal6");
		this.hashFields.put("rtn_col_3", "rtnCol3");
		this.hashFields.put("whr_val_9", "whrVal9");
		this.hashFields.put("whr_val_8", "whrVal8");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tblNm9
	 */
	public String getTblNm9() {
		return this.tblNm9;
	}
	
	/**
	 * Column Info
	 * @return tblNm6
	 */
	public String getTblNm6() {
		return this.tblNm6;
	}
	
	/**
	 * Column Info
	 * @return tblNm5
	 */
	public String getTblNm5() {
		return this.tblNm5;
	}
	
	/**
	 * Column Info
	 * @return tblNm8
	 */
	public String getTblNm8() {
		return this.tblNm8;
	}
	
	/**
	 * Column Info
	 * @return tblNm7
	 */
	public String getTblNm7() {
		return this.tblNm7;
	}
	
	/**
	 * Column Info
	 * @return tblNm2
	 */
	public String getTblNm2() {
		return this.tblNm2;
	}
	
	/**
	 * Column Info
	 * @return tblNm1
	 */
	public String getTblNm1() {
		return this.tblNm1;
	}
	
	/**
	 * Column Info
	 * @return tblNm4
	 */
	public String getTblNm4() {
		return this.tblNm4;
	}
	
	/**
	 * Column Info
	 * @return tblNm3
	 */
	public String getTblNm3() {
		return this.tblNm3;
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
	 * @return rtnCol9
	 */
	public String getRtnCol9() {
		return this.rtnCol9;
	}
	
	/**
	 * Column Info
	 * @return rtnCol8
	 */
	public String getRtnCol8() {
		return this.rtnCol8;
	}
	
	/**
	 * Column Info
	 * @return rtnCol7
	 */
	public String getRtnCol7() {
		return this.rtnCol7;
	}
	
	/**
	 * Column Info
	 * @return rtnCol6
	 */
	public String getRtnCol6() {
		return this.rtnCol6;
	}
	
	/**
	 * Column Info
	 * @return rtnCol5
	 */
	public String getRtnCol5() {
		return this.rtnCol5;
	}
	
	/**
	 * Column Info
	 * @return rtnCol4
	 */
	public String getRtnCol4() {
		return this.rtnCol4;
	}
	
	/**
	 * Column Info
	 * @return whrVal1
	 */
	public String getWhrVal1() {
		return this.whrVal1;
	}
	
	/**
	 * Column Info
	 * @return whrVal3
	 */
	public String getWhrVal3() {
		return this.whrVal3;
	}
	
	/**
	 * Column Info
	 * @return whrVal2
	 */
	public String getWhrVal2() {
		return this.whrVal2;
	}
	
	/**
	 * Column Info
	 * @return whrVal5
	 */
	public String getWhrVal5() {
		return this.whrVal5;
	}
	
	/**
	 * Column Info
	 * @return rtnCol1
	 */
	public String getRtnCol1() {
		return this.rtnCol1;
	}
	
	/**
	 * Column Info
	 * @return whrVal4
	 */
	public String getWhrVal4() {
		return this.whrVal4;
	}
	
	/**
	 * Column Info
	 * @return whrVal7
	 */
	public String getWhrVal7() {
		return this.whrVal7;
	}
	
	/**
	 * Column Info
	 * @return rtnCol2
	 */
	public String getRtnCol2() {
		return this.rtnCol2;
	}
	
	/**
	 * Column Info
	 * @return whrVal6
	 */
	public String getWhrVal6() {
		return this.whrVal6;
	}
	
	/**
	 * Column Info
	 * @return rtnCol3
	 */
	public String getRtnCol3() {
		return this.rtnCol3;
	}
	
	/**
	 * Column Info
	 * @return whrVal9
	 */
	public String getWhrVal9() {
		return this.whrVal9;
	}
	
	/**
	 * Column Info
	 * @return whrVal8
	 */
	public String getWhrVal8() {
		return this.whrVal8;
	}
	

	/**
	 * Column Info
	 * @param tblNm9
	 */
	public void setTblNm9(String tblNm9) {
		this.tblNm9 = tblNm9;
	}
	
	/**
	 * Column Info
	 * @param tblNm6
	 */
	public void setTblNm6(String tblNm6) {
		this.tblNm6 = tblNm6;
	}
	
	/**
	 * Column Info
	 * @param tblNm5
	 */
	public void setTblNm5(String tblNm5) {
		this.tblNm5 = tblNm5;
	}
	
	/**
	 * Column Info
	 * @param tblNm8
	 */
	public void setTblNm8(String tblNm8) {
		this.tblNm8 = tblNm8;
	}
	
	/**
	 * Column Info
	 * @param tblNm7
	 */
	public void setTblNm7(String tblNm7) {
		this.tblNm7 = tblNm7;
	}
	
	/**
	 * Column Info
	 * @param tblNm2
	 */
	public void setTblNm2(String tblNm2) {
		this.tblNm2 = tblNm2;
	}
	
	/**
	 * Column Info
	 * @param tblNm1
	 */
	public void setTblNm1(String tblNm1) {
		this.tblNm1 = tblNm1;
	}
	
	/**
	 * Column Info
	 * @param tblNm4
	 */
	public void setTblNm4(String tblNm4) {
		this.tblNm4 = tblNm4;
	}
	
	/**
	 * Column Info
	 * @param tblNm3
	 */
	public void setTblNm3(String tblNm3) {
		this.tblNm3 = tblNm3;
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
	 * @param rtnCol9
	 */
	public void setRtnCol9(String rtnCol9) {
		this.rtnCol9 = rtnCol9;
	}
	
	/**
	 * Column Info
	 * @param rtnCol8
	 */
	public void setRtnCol8(String rtnCol8) {
		this.rtnCol8 = rtnCol8;
	}
	
	/**
	 * Column Info
	 * @param rtnCol7
	 */
	public void setRtnCol7(String rtnCol7) {
		this.rtnCol7 = rtnCol7;
	}
	
	/**
	 * Column Info
	 * @param rtnCol6
	 */
	public void setRtnCol6(String rtnCol6) {
		this.rtnCol6 = rtnCol6;
	}
	
	/**
	 * Column Info
	 * @param rtnCol5
	 */
	public void setRtnCol5(String rtnCol5) {
		this.rtnCol5 = rtnCol5;
	}
	
	/**
	 * Column Info
	 * @param rtnCol4
	 */
	public void setRtnCol4(String rtnCol4) {
		this.rtnCol4 = rtnCol4;
	}
	
	/**
	 * Column Info
	 * @param whrVal1
	 */
	public void setWhrVal1(String whrVal1) {
		this.whrVal1 = whrVal1;
	}
	
	/**
	 * Column Info
	 * @param whrVal3
	 */
	public void setWhrVal3(String whrVal3) {
		this.whrVal3 = whrVal3;
	}
	
	/**
	 * Column Info
	 * @param whrVal2
	 */
	public void setWhrVal2(String whrVal2) {
		this.whrVal2 = whrVal2;
	}
	
	/**
	 * Column Info
	 * @param whrVal5
	 */
	public void setWhrVal5(String whrVal5) {
		this.whrVal5 = whrVal5;
	}
	
	/**
	 * Column Info
	 * @param rtnCol1
	 */
	public void setRtnCol1(String rtnCol1) {
		this.rtnCol1 = rtnCol1;
	}
	
	/**
	 * Column Info
	 * @param whrVal4
	 */
	public void setWhrVal4(String whrVal4) {
		this.whrVal4 = whrVal4;
	}
	
	/**
	 * Column Info
	 * @param whrVal7
	 */
	public void setWhrVal7(String whrVal7) {
		this.whrVal7 = whrVal7;
	}
	
	/**
	 * Column Info
	 * @param rtnCol2
	 */
	public void setRtnCol2(String rtnCol2) {
		this.rtnCol2 = rtnCol2;
	}
	
	/**
	 * Column Info
	 * @param whrVal6
	 */
	public void setWhrVal6(String whrVal6) {
		this.whrVal6 = whrVal6;
	}
	
	/**
	 * Column Info
	 * @param rtnCol3
	 */
	public void setRtnCol3(String rtnCol3) {
		this.rtnCol3 = rtnCol3;
	}
	
	/**
	 * Column Info
	 * @param whrVal9
	 */
	public void setWhrVal9(String whrVal9) {
		this.whrVal9 = whrVal9;
	}
	
	/**
	 * Column Info
	 * @param whrVal8
	 */
	public void setWhrVal8(String whrVal8) {
		this.whrVal8 = whrVal8;
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
		setTblNm9(JSPUtil.getParameter(request, prefix + "tbl_nm_9", ""));
		setTblNm6(JSPUtil.getParameter(request, prefix + "tbl_nm_6", ""));
		setTblNm5(JSPUtil.getParameter(request, prefix + "tbl_nm_5", ""));
		setTblNm8(JSPUtil.getParameter(request, prefix + "tbl_nm_8", ""));
		setTblNm7(JSPUtil.getParameter(request, prefix + "tbl_nm_7", ""));
		setTblNm2(JSPUtil.getParameter(request, prefix + "tbl_nm_2", ""));
		setTblNm1(JSPUtil.getParameter(request, prefix + "tbl_nm_1", ""));
		setTblNm4(JSPUtil.getParameter(request, prefix + "tbl_nm_4", ""));
		setTblNm3(JSPUtil.getParameter(request, prefix + "tbl_nm_3", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRtnCol9(JSPUtil.getParameter(request, prefix + "rtn_col_9", ""));
		setRtnCol8(JSPUtil.getParameter(request, prefix + "rtn_col_8", ""));
		setRtnCol7(JSPUtil.getParameter(request, prefix + "rtn_col_7", ""));
		setRtnCol6(JSPUtil.getParameter(request, prefix + "rtn_col_6", ""));
		setRtnCol5(JSPUtil.getParameter(request, prefix + "rtn_col_5", ""));
		setRtnCol4(JSPUtil.getParameter(request, prefix + "rtn_col_4", ""));
		setWhrVal1(JSPUtil.getParameter(request, prefix + "whr_val_1", ""));
		setWhrVal3(JSPUtil.getParameter(request, prefix + "whr_val_3", ""));
		setWhrVal2(JSPUtil.getParameter(request, prefix + "whr_val_2", ""));
		setWhrVal5(JSPUtil.getParameter(request, prefix + "whr_val_5", ""));
		setRtnCol1(JSPUtil.getParameter(request, prefix + "rtn_col_1", ""));
		setWhrVal4(JSPUtil.getParameter(request, prefix + "whr_val_4", ""));
		setWhrVal7(JSPUtil.getParameter(request, prefix + "whr_val_7", ""));
		setRtnCol2(JSPUtil.getParameter(request, prefix + "rtn_col_2", ""));
		setWhrVal6(JSPUtil.getParameter(request, prefix + "whr_val_6", ""));
		setRtnCol3(JSPUtil.getParameter(request, prefix + "rtn_col_3", ""));
		setWhrVal9(JSPUtil.getParameter(request, prefix + "whr_val_9", ""));
		setWhrVal8(JSPUtil.getParameter(request, prefix + "whr_val_8", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsCommonInputVO[]
	 */
	public BkgCstmsCommonInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsCommonInputVO[]
	 */
	public BkgCstmsCommonInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsCommonInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tblNm9 = (JSPUtil.getParameter(request, prefix	+ "tbl_nm_9", length));
			String[] tblNm6 = (JSPUtil.getParameter(request, prefix	+ "tbl_nm_6", length));
			String[] tblNm5 = (JSPUtil.getParameter(request, prefix	+ "tbl_nm_5", length));
			String[] tblNm8 = (JSPUtil.getParameter(request, prefix	+ "tbl_nm_8", length));
			String[] tblNm7 = (JSPUtil.getParameter(request, prefix	+ "tbl_nm_7", length));
			String[] tblNm2 = (JSPUtil.getParameter(request, prefix	+ "tbl_nm_2", length));
			String[] tblNm1 = (JSPUtil.getParameter(request, prefix	+ "tbl_nm_1", length));
			String[] tblNm4 = (JSPUtil.getParameter(request, prefix	+ "tbl_nm_4", length));
			String[] tblNm3 = (JSPUtil.getParameter(request, prefix	+ "tbl_nm_3", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rtnCol9 = (JSPUtil.getParameter(request, prefix	+ "rtn_col_9", length));
			String[] rtnCol8 = (JSPUtil.getParameter(request, prefix	+ "rtn_col_8", length));
			String[] rtnCol7 = (JSPUtil.getParameter(request, prefix	+ "rtn_col_7", length));
			String[] rtnCol6 = (JSPUtil.getParameter(request, prefix	+ "rtn_col_6", length));
			String[] rtnCol5 = (JSPUtil.getParameter(request, prefix	+ "rtn_col_5", length));
			String[] rtnCol4 = (JSPUtil.getParameter(request, prefix	+ "rtn_col_4", length));
			String[] whrVal1 = (JSPUtil.getParameter(request, prefix	+ "whr_val_1", length));
			String[] whrVal3 = (JSPUtil.getParameter(request, prefix	+ "whr_val_3", length));
			String[] whrVal2 = (JSPUtil.getParameter(request, prefix	+ "whr_val_2", length));
			String[] whrVal5 = (JSPUtil.getParameter(request, prefix	+ "whr_val_5", length));
			String[] rtnCol1 = (JSPUtil.getParameter(request, prefix	+ "rtn_col_1", length));
			String[] whrVal4 = (JSPUtil.getParameter(request, prefix	+ "whr_val_4", length));
			String[] whrVal7 = (JSPUtil.getParameter(request, prefix	+ "whr_val_7", length));
			String[] rtnCol2 = (JSPUtil.getParameter(request, prefix	+ "rtn_col_2", length));
			String[] whrVal6 = (JSPUtil.getParameter(request, prefix	+ "whr_val_6", length));
			String[] rtnCol3 = (JSPUtil.getParameter(request, prefix	+ "rtn_col_3", length));
			String[] whrVal9 = (JSPUtil.getParameter(request, prefix	+ "whr_val_9", length));
			String[] whrVal8 = (JSPUtil.getParameter(request, prefix	+ "whr_val_8", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCstmsCommonInputVO();
				if (tblNm9[i] != null)
					model.setTblNm9(tblNm9[i]);
				if (tblNm6[i] != null)
					model.setTblNm6(tblNm6[i]);
				if (tblNm5[i] != null)
					model.setTblNm5(tblNm5[i]);
				if (tblNm8[i] != null)
					model.setTblNm8(tblNm8[i]);
				if (tblNm7[i] != null)
					model.setTblNm7(tblNm7[i]);
				if (tblNm2[i] != null)
					model.setTblNm2(tblNm2[i]);
				if (tblNm1[i] != null)
					model.setTblNm1(tblNm1[i]);
				if (tblNm4[i] != null)
					model.setTblNm4(tblNm4[i]);
				if (tblNm3[i] != null)
					model.setTblNm3(tblNm3[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rtnCol9[i] != null)
					model.setRtnCol9(rtnCol9[i]);
				if (rtnCol8[i] != null)
					model.setRtnCol8(rtnCol8[i]);
				if (rtnCol7[i] != null)
					model.setRtnCol7(rtnCol7[i]);
				if (rtnCol6[i] != null)
					model.setRtnCol6(rtnCol6[i]);
				if (rtnCol5[i] != null)
					model.setRtnCol5(rtnCol5[i]);
				if (rtnCol4[i] != null)
					model.setRtnCol4(rtnCol4[i]);
				if (whrVal1[i] != null)
					model.setWhrVal1(whrVal1[i]);
				if (whrVal3[i] != null)
					model.setWhrVal3(whrVal3[i]);
				if (whrVal2[i] != null)
					model.setWhrVal2(whrVal2[i]);
				if (whrVal5[i] != null)
					model.setWhrVal5(whrVal5[i]);
				if (rtnCol1[i] != null)
					model.setRtnCol1(rtnCol1[i]);
				if (whrVal4[i] != null)
					model.setWhrVal4(whrVal4[i]);
				if (whrVal7[i] != null)
					model.setWhrVal7(whrVal7[i]);
				if (rtnCol2[i] != null)
					model.setRtnCol2(rtnCol2[i]);
				if (whrVal6[i] != null)
					model.setWhrVal6(whrVal6[i]);
				if (rtnCol3[i] != null)
					model.setRtnCol3(rtnCol3[i]);
				if (whrVal9[i] != null)
					model.setWhrVal9(whrVal9[i]);
				if (whrVal8[i] != null)
					model.setWhrVal8(whrVal8[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsCommonInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsCommonInputVO[]
	 */
	public BkgCstmsCommonInputVO[] getBkgCstmsCommonInputVOs(){
		BkgCstmsCommonInputVO[] vos = (BkgCstmsCommonInputVO[])models.toArray(new BkgCstmsCommonInputVO[models.size()]);
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
		this.tblNm9 = this.tblNm9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tblNm6 = this.tblNm6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tblNm5 = this.tblNm5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tblNm8 = this.tblNm8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tblNm7 = this.tblNm7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tblNm2 = this.tblNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tblNm1 = this.tblNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tblNm4 = this.tblNm4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tblNm3 = this.tblNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnCol9 = this.rtnCol9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnCol8 = this.rtnCol8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnCol7 = this.rtnCol7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnCol6 = this.rtnCol6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnCol5 = this.rtnCol5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnCol4 = this.rtnCol4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whrVal1 = this.whrVal1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whrVal3 = this.whrVal3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whrVal2 = this.whrVal2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whrVal5 = this.whrVal5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnCol1 = this.rtnCol1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whrVal4 = this.whrVal4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whrVal7 = this.whrVal7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnCol2 = this.rtnCol2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whrVal6 = this.whrVal6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnCol3 = this.rtnCol3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whrVal9 = this.whrVal9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whrVal8 = this.whrVal8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
