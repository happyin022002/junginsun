/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FormulaVO.java
*@FileTitle : FormulaVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.08.13 김진일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

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
 * @author 김진일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FormulaVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FormulaVO> models = new ArrayList<FormulaVO>();
	
	/* Column Info */
	private String col5 = null;
	/* Column Info */
	private String col4 = null;
	/* Column Info */
	private String col7 = null;
	/* Column Info */
	private String col6 = null;
	/* Column Info */
	private String col1 = null;
	/* Column Info */
	private String col3 = null;
	/* Column Info */
	private String col2 = null;
	/* Column Info */
	private String col13 = null;
	/* Column Info */
	private String col12 = null;
	/* Column Info */
	private String col11 = null;
	/* Column Info */
	private String col9 = null;
	/* Column Info */
	private String col8 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String col10 = null;
	/* Column Info */
	private String rwgrp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FormulaVO() {}

	public FormulaVO(String ibflag, String pagerows, String rwgrp, String col1, String col2, String col3, String col4, String col5, String col6, String col7, String col8, String col9, String col10, String col11, String col12, String col13) {
		this.col5 = col5;
		this.col4 = col4;
		this.col7 = col7;
		this.col6 = col6;
		this.col1 = col1;
		this.col3 = col3;
		this.col2 = col2;
		this.col13 = col13;
		this.col12 = col12;
		this.col11 = col11;
		this.col9 = col9;
		this.col8 = col8;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.col10 = col10;
		this.rwgrp = rwgrp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("col5", getCol5());
		this.hashColumns.put("col4", getCol4());
		this.hashColumns.put("col7", getCol7());
		this.hashColumns.put("col6", getCol6());
		this.hashColumns.put("col1", getCol1());
		this.hashColumns.put("col3", getCol3());
		this.hashColumns.put("col2", getCol2());
		this.hashColumns.put("col13", getCol13());
		this.hashColumns.put("col12", getCol12());
		this.hashColumns.put("col11", getCol11());
		this.hashColumns.put("col9", getCol9());
		this.hashColumns.put("col8", getCol8());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("col10", getCol10());
		this.hashColumns.put("rwgrp", getRwgrp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("col5", "col5");
		this.hashFields.put("col4", "col4");
		this.hashFields.put("col7", "col7");
		this.hashFields.put("col6", "col6");
		this.hashFields.put("col1", "col1");
		this.hashFields.put("col3", "col3");
		this.hashFields.put("col2", "col2");
		this.hashFields.put("col13", "col13");
		this.hashFields.put("col12", "col12");
		this.hashFields.put("col11", "col11");
		this.hashFields.put("col9", "col9");
		this.hashFields.put("col8", "col8");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("col10", "col10");
		this.hashFields.put("rwgrp", "rwgrp");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return col5
	 */
	public String getCol5() {
		return this.col5;
	}
	
	/**
	 * Column Info
	 * @return col4
	 */
	public String getCol4() {
		return this.col4;
	}
	
	/**
	 * Column Info
	 * @return col7
	 */
	public String getCol7() {
		return this.col7;
	}
	
	/**
	 * Column Info
	 * @return col6
	 */
	public String getCol6() {
		return this.col6;
	}
	
	/**
	 * Column Info
	 * @return col1
	 */
	public String getCol1() {
		return this.col1;
	}
	
	/**
	 * Column Info
	 * @return col3
	 */
	public String getCol3() {
		return this.col3;
	}
	
	/**
	 * Column Info
	 * @return col2
	 */
	public String getCol2() {
		return this.col2;
	}
	
	/**
	 * Column Info
	 * @return col13
	 */
	public String getCol13() {
		return this.col13;
	}
	
	/**
	 * Column Info
	 * @return col12
	 */
	public String getCol12() {
		return this.col12;
	}
	
	/**
	 * Column Info
	 * @return col11
	 */
	public String getCol11() {
		return this.col11;
	}
	
	/**
	 * Column Info
	 * @return col9
	 */
	public String getCol9() {
		return this.col9;
	}
	
	/**
	 * Column Info
	 * @return col8
	 */
	public String getCol8() {
		return this.col8;
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
	 * @return col10
	 */
	public String getCol10() {
		return this.col10;
	}
	
	/**
	 * Column Info
	 * @return rwgrp
	 */
	public String getRwgrp() {
		return this.rwgrp;
	}
	

	/**
	 * Column Info
	 * @param col5
	 */
	public void setCol5(String col5) {
		this.col5 = col5;
	}
	
	/**
	 * Column Info
	 * @param col4
	 */
	public void setCol4(String col4) {
		this.col4 = col4;
	}
	
	/**
	 * Column Info
	 * @param col7
	 */
	public void setCol7(String col7) {
		this.col7 = col7;
	}
	
	/**
	 * Column Info
	 * @param col6
	 */
	public void setCol6(String col6) {
		this.col6 = col6;
	}
	
	/**
	 * Column Info
	 * @param col1
	 */
	public void setCol1(String col1) {
		this.col1 = col1;
	}
	
	/**
	 * Column Info
	 * @param col3
	 */
	public void setCol3(String col3) {
		this.col3 = col3;
	}
	
	/**
	 * Column Info
	 * @param col2
	 */
	public void setCol2(String col2) {
		this.col2 = col2;
	}
	
	/**
	 * Column Info
	 * @param col13
	 */
	public void setCol13(String col13) {
		this.col13 = col13;
	}
	
	/**
	 * Column Info
	 * @param col12
	 */
	public void setCol12(String col12) {
		this.col12 = col12;
	}
	
	/**
	 * Column Info
	 * @param col11
	 */
	public void setCol11(String col11) {
		this.col11 = col11;
	}
	
	/**
	 * Column Info
	 * @param col9
	 */
	public void setCol9(String col9) {
		this.col9 = col9;
	}
	
	/**
	 * Column Info
	 * @param col8
	 */
	public void setCol8(String col8) {
		this.col8 = col8;
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
	 * @param col10
	 */
	public void setCol10(String col10) {
		this.col10 = col10;
	}
	
	/**
	 * Column Info
	 * @param rwgrp
	 */
	public void setRwgrp(String rwgrp) {
		this.rwgrp = rwgrp;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCol5(JSPUtil.getParameter(request, "col5", ""));
		setCol4(JSPUtil.getParameter(request, "col4", ""));
		setCol7(JSPUtil.getParameter(request, "col7", ""));
		setCol6(JSPUtil.getParameter(request, "col6", ""));
		setCol1(JSPUtil.getParameter(request, "col1", ""));
		setCol3(JSPUtil.getParameter(request, "col3", ""));
		setCol2(JSPUtil.getParameter(request, "col2", ""));
		setCol13(JSPUtil.getParameter(request, "col13", ""));
		setCol12(JSPUtil.getParameter(request, "col12", ""));
		setCol11(JSPUtil.getParameter(request, "col11", ""));
		setCol9(JSPUtil.getParameter(request, "col9", ""));
		setCol8(JSPUtil.getParameter(request, "col8", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCol10(JSPUtil.getParameter(request, "col10", ""));
		setRwgrp(JSPUtil.getParameter(request, "rwgrp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FormulaVO[]
	 */
	public FormulaVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FormulaVO[]
	 */
	public FormulaVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FormulaVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] col5 = (JSPUtil.getParameter(request, prefix	+ "col5", length));
			String[] col4 = (JSPUtil.getParameter(request, prefix	+ "col4", length));
			String[] col7 = (JSPUtil.getParameter(request, prefix	+ "col7", length));
			String[] col6 = (JSPUtil.getParameter(request, prefix	+ "col6", length));
			String[] col1 = (JSPUtil.getParameter(request, prefix	+ "col1", length));
			String[] col3 = (JSPUtil.getParameter(request, prefix	+ "col3", length));
			String[] col2 = (JSPUtil.getParameter(request, prefix	+ "col2", length));
			String[] col13 = (JSPUtil.getParameter(request, prefix	+ "col13", length));
			String[] col12 = (JSPUtil.getParameter(request, prefix	+ "col12", length));
			String[] col11 = (JSPUtil.getParameter(request, prefix	+ "col11", length));
			String[] col9 = (JSPUtil.getParameter(request, prefix	+ "col9", length));
			String[] col8 = (JSPUtil.getParameter(request, prefix	+ "col8", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] col10 = (JSPUtil.getParameter(request, prefix	+ "col10", length));
			String[] rwgrp = (JSPUtil.getParameter(request, prefix	+ "rwgrp", length));
			
			for (int i = 0; i < length; i++) {
				model = new FormulaVO();
				if (col5[i] != null)
					model.setCol5(col5[i]);
				if (col4[i] != null)
					model.setCol4(col4[i]);
				if (col7[i] != null)
					model.setCol7(col7[i]);
				if (col6[i] != null)
					model.setCol6(col6[i]);
				if (col1[i] != null)
					model.setCol1(col1[i]);
				if (col3[i] != null)
					model.setCol3(col3[i]);
				if (col2[i] != null)
					model.setCol2(col2[i]);
				if (col13[i] != null)
					model.setCol13(col13[i]);
				if (col12[i] != null)
					model.setCol12(col12[i]);
				if (col11[i] != null)
					model.setCol11(col11[i]);
				if (col9[i] != null)
					model.setCol9(col9[i]);
				if (col8[i] != null)
					model.setCol8(col8[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (col10[i] != null)
					model.setCol10(col10[i]);
				if (rwgrp[i] != null)
					model.setRwgrp(rwgrp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFormulaVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FormulaVO[]
	 */
	public FormulaVO[] getFormulaVOs(){
		FormulaVO[] vos = (FormulaVO[])models.toArray(new FormulaVO[models.size()]);
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
		this.col5 = this.col5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col4 = this.col4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col7 = this.col7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col6 = this.col6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col1 = this.col1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col3 = this.col3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col2 = this.col2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col13 = this.col13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col12 = this.col12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col11 = this.col11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col9 = this.col9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col8 = this.col8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col10 = this.col10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rwgrp = this.rwgrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
