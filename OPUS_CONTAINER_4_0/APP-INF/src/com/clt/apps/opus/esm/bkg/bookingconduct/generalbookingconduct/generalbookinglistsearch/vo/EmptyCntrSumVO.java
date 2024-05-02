/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyCntrSumVO.java
*@FileTitle : EmptyCntrSumVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.10.01 김병규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EmptyCntrSumVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EmptyCntrSumVO> models = new ArrayList<EmptyCntrSumVO>();
	
	/* Column Info */
	private String sumO4 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sumR2 = null;
	/* Column Info */
	private String sumS4 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sumR5 = null;
	/* Column Info */
	private String sumR4 = null;
	/* Column Info */
	private String sumF2 = null;
	/* Column Info */
	private String sumS2 = null;
	/* Column Info */
	private String sumD2 = null;
	/* Column Info */
	private String sumF4 = null;
	/* Column Info */
	private String sumA4 = null;
	/* Column Info */
	private String sumD4 = null;
	/* Column Info */
	private String sumO2 = null;
	/* Column Info */
	private String sumA2 = null;
	/* Column Info */
	private String sumF5 = null;
	/* Column Info */
	private String sumD5 = null;
	/* Column Info */
	private String sumD7 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EmptyCntrSumVO() {}

	public EmptyCntrSumVO(String ibflag, String pagerows, String sumD2, String sumD4, String sumD5, String sumD7, String sumR2, String sumR4, String sumR5, String sumF2, String sumF4, String sumF5, String sumO2, String sumO4, String sumA2, String sumA4, String sumS2, String sumS4) {
		this.sumO4 = sumO4;
		this.pagerows = pagerows;
		this.sumR2 = sumR2;
		this.sumS4 = sumS4;
		this.ibflag = ibflag;
		this.sumR5 = sumR5;
		this.sumR4 = sumR4;
		this.sumF2 = sumF2;
		this.sumS2 = sumS2;
		this.sumD2 = sumD2;
		this.sumF4 = sumF4;
		this.sumA4 = sumA4;
		this.sumD4 = sumD4;
		this.sumO2 = sumO2;
		this.sumA2 = sumA2;
		this.sumF5 = sumF5;
		this.sumD5 = sumD5;
		this.sumD7 = sumD7;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sum_o4", getSumO4());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sum_r2", getSumR2());
		this.hashColumns.put("sum_s4", getSumS4());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sum_r5", getSumR5());
		this.hashColumns.put("sum_r4", getSumR4());
		this.hashColumns.put("sum_f2", getSumF2());
		this.hashColumns.put("sum_s2", getSumS2());
		this.hashColumns.put("sum_d2", getSumD2());
		this.hashColumns.put("sum_f4", getSumF4());
		this.hashColumns.put("sum_a4", getSumA4());
		this.hashColumns.put("sum_d4", getSumD4());
		this.hashColumns.put("sum_o2", getSumO2());
		this.hashColumns.put("sum_a2", getSumA2());
		this.hashColumns.put("sum_f5", getSumF5());
		this.hashColumns.put("sum_d5", getSumD5());
		this.hashColumns.put("sum_d7", getSumD7());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sum_o4", "sumO4");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sum_r2", "sumR2");
		this.hashFields.put("sum_s4", "sumS4");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sum_r5", "sumR5");
		this.hashFields.put("sum_r4", "sumR4");
		this.hashFields.put("sum_f2", "sumF2");
		this.hashFields.put("sum_s2", "sumS2");
		this.hashFields.put("sum_d2", "sumD2");
		this.hashFields.put("sum_f4", "sumF4");
		this.hashFields.put("sum_a4", "sumA4");
		this.hashFields.put("sum_d4", "sumD4");
		this.hashFields.put("sum_o2", "sumO2");
		this.hashFields.put("sum_a2", "sumA2");
		this.hashFields.put("sum_f5", "sumF5");
		this.hashFields.put("sum_d5", "sumD5");
		this.hashFields.put("sum_d7", "sumD7");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sumO4
	 */
	public String getSumO4() {
		return this.sumO4;
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
	 * @return sumR2
	 */
	public String getSumR2() {
		return this.sumR2;
	}
	
	/**
	 * Column Info
	 * @return sumS4
	 */
	public String getSumS4() {
		return this.sumS4;
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
	 * @return sumR5
	 */
	public String getSumR5() {
		return this.sumR5;
	}
	
	/**
	 * Column Info
	 * @return sumR4
	 */
	public String getSumR4() {
		return this.sumR4;
	}
	
	/**
	 * Column Info
	 * @return sumF2
	 */
	public String getSumF2() {
		return this.sumF2;
	}
	
	/**
	 * Column Info
	 * @return sumS2
	 */
	public String getSumS2() {
		return this.sumS2;
	}
	
	/**
	 * Column Info
	 * @return sumD2
	 */
	public String getSumD2() {
		return this.sumD2;
	}
	
	/**
	 * Column Info
	 * @return sumF4
	 */
	public String getSumF4() {
		return this.sumF4;
	}
	
	/**
	 * Column Info
	 * @return sumA4
	 */
	public String getSumA4() {
		return this.sumA4;
	}
	
	/**
	 * Column Info
	 * @return sumD4
	 */
	public String getSumD4() {
		return this.sumD4;
	}
	
	/**
	 * Column Info
	 * @return sumO2
	 */
	public String getSumO2() {
		return this.sumO2;
	}
	
	/**
	 * Column Info
	 * @return sumA2
	 */
	public String getSumA2() {
		return this.sumA2;
	}
	
	/**
	 * Column Info
	 * @return sumF5
	 */
	public String getSumF5() {
		return this.sumF5;
	}
	
	/**
	 * Column Info
	 * @return sumD5
	 */
	public String getSumD5() {
		return this.sumD5;
	}
	
	/**
	 * Column Info
	 * @return sumD7
	 */
	public String getSumD7() {
		return this.sumD7;
	}
	

	/**
	 * Column Info
	 * @param sumO4
	 */
	public void setSumO4(String sumO4) {
		this.sumO4 = sumO4;
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
	 * @param sumR2
	 */
	public void setSumR2(String sumR2) {
		this.sumR2 = sumR2;
	}
	
	/**
	 * Column Info
	 * @param sumS4
	 */
	public void setSumS4(String sumS4) {
		this.sumS4 = sumS4;
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
	 * @param sumR5
	 */
	public void setSumR5(String sumR5) {
		this.sumR5 = sumR5;
	}
	
	/**
	 * Column Info
	 * @param sumR4
	 */
	public void setSumR4(String sumR4) {
		this.sumR4 = sumR4;
	}
	
	/**
	 * Column Info
	 * @param sumF2
	 */
	public void setSumF2(String sumF2) {
		this.sumF2 = sumF2;
	}
	
	/**
	 * Column Info
	 * @param sumS2
	 */
	public void setSumS2(String sumS2) {
		this.sumS2 = sumS2;
	}
	
	/**
	 * Column Info
	 * @param sumD2
	 */
	public void setSumD2(String sumD2) {
		this.sumD2 = sumD2;
	}
	
	/**
	 * Column Info
	 * @param sumF4
	 */
	public void setSumF4(String sumF4) {
		this.sumF4 = sumF4;
	}
	
	/**
	 * Column Info
	 * @param sumA4
	 */
	public void setSumA4(String sumA4) {
		this.sumA4 = sumA4;
	}
	
	/**
	 * Column Info
	 * @param sumD4
	 */
	public void setSumD4(String sumD4) {
		this.sumD4 = sumD4;
	}
	
	/**
	 * Column Info
	 * @param sumO2
	 */
	public void setSumO2(String sumO2) {
		this.sumO2 = sumO2;
	}
	
	/**
	 * Column Info
	 * @param sumA2
	 */
	public void setSumA2(String sumA2) {
		this.sumA2 = sumA2;
	}
	
	/**
	 * Column Info
	 * @param sumF5
	 */
	public void setSumF5(String sumF5) {
		this.sumF5 = sumF5;
	}
	
	/**
	 * Column Info
	 * @param sumD5
	 */
	public void setSumD5(String sumD5) {
		this.sumD5 = sumD5;
	}
	
	/**
	 * Column Info
	 * @param sumD7
	 */
	public void setSumD7(String sumD7) {
		this.sumD7 = sumD7;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSumO4(JSPUtil.getParameter(request, "sum_o4", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSumR2(JSPUtil.getParameter(request, "sum_r2", ""));
		setSumS4(JSPUtil.getParameter(request, "sum_s4", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSumR5(JSPUtil.getParameter(request, "sum_r5", ""));
		setSumR4(JSPUtil.getParameter(request, "sum_r4", ""));
		setSumF2(JSPUtil.getParameter(request, "sum_f2", ""));
		setSumS2(JSPUtil.getParameter(request, "sum_s2", ""));
		setSumD2(JSPUtil.getParameter(request, "sum_d2", ""));
		setSumF4(JSPUtil.getParameter(request, "sum_f4", ""));
		setSumA4(JSPUtil.getParameter(request, "sum_a4", ""));
		setSumD4(JSPUtil.getParameter(request, "sum_d4", ""));
		setSumO2(JSPUtil.getParameter(request, "sum_o2", ""));
		setSumA2(JSPUtil.getParameter(request, "sum_a2", ""));
		setSumF5(JSPUtil.getParameter(request, "sum_f5", ""));
		setSumD5(JSPUtil.getParameter(request, "sum_d5", ""));
		setSumD7(JSPUtil.getParameter(request, "sum_d7", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EmptyCntrSumVO[]
	 */
	public EmptyCntrSumVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EmptyCntrSumVO[]
	 */
	public EmptyCntrSumVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EmptyCntrSumVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sumO4 = (JSPUtil.getParameter(request, prefix	+ "sum_o4", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sumR2 = (JSPUtil.getParameter(request, prefix	+ "sum_r2", length));
			String[] sumS4 = (JSPUtil.getParameter(request, prefix	+ "sum_s4", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sumR5 = (JSPUtil.getParameter(request, prefix	+ "sum_r5", length));
			String[] sumR4 = (JSPUtil.getParameter(request, prefix	+ "sum_r4", length));
			String[] sumF2 = (JSPUtil.getParameter(request, prefix	+ "sum_f2", length));
			String[] sumS2 = (JSPUtil.getParameter(request, prefix	+ "sum_s2", length));
			String[] sumD2 = (JSPUtil.getParameter(request, prefix	+ "sum_d2", length));
			String[] sumF4 = (JSPUtil.getParameter(request, prefix	+ "sum_f4", length));
			String[] sumA4 = (JSPUtil.getParameter(request, prefix	+ "sum_a4", length));
			String[] sumD4 = (JSPUtil.getParameter(request, prefix	+ "sum_d4", length));
			String[] sumO2 = (JSPUtil.getParameter(request, prefix	+ "sum_o2", length));
			String[] sumA2 = (JSPUtil.getParameter(request, prefix	+ "sum_a2", length));
			String[] sumF5 = (JSPUtil.getParameter(request, prefix	+ "sum_f5", length));
			String[] sumD5 = (JSPUtil.getParameter(request, prefix	+ "sum_d5", length));
			String[] sumD7 = (JSPUtil.getParameter(request, prefix	+ "sum_d7", length));
			
			for (int i = 0; i < length; i++) {
				model = new EmptyCntrSumVO();
				if (sumO4[i] != null)
					model.setSumO4(sumO4[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sumR2[i] != null)
					model.setSumR2(sumR2[i]);
				if (sumS4[i] != null)
					model.setSumS4(sumS4[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sumR5[i] != null)
					model.setSumR5(sumR5[i]);
				if (sumR4[i] != null)
					model.setSumR4(sumR4[i]);
				if (sumF2[i] != null)
					model.setSumF2(sumF2[i]);
				if (sumS2[i] != null)
					model.setSumS2(sumS2[i]);
				if (sumD2[i] != null)
					model.setSumD2(sumD2[i]);
				if (sumF4[i] != null)
					model.setSumF4(sumF4[i]);
				if (sumA4[i] != null)
					model.setSumA4(sumA4[i]);
				if (sumD4[i] != null)
					model.setSumD4(sumD4[i]);
				if (sumO2[i] != null)
					model.setSumO2(sumO2[i]);
				if (sumA2[i] != null)
					model.setSumA2(sumA2[i]);
				if (sumF5[i] != null)
					model.setSumF5(sumF5[i]);
				if (sumD5[i] != null)
					model.setSumD5(sumD5[i]);
				if (sumD7[i] != null)
					model.setSumD7(sumD7[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEmptyCntrSumVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EmptyCntrSumVO[]
	 */
	public EmptyCntrSumVO[] getEmptyCntrSumVOs(){
		EmptyCntrSumVO[] vos = (EmptyCntrSumVO[])models.toArray(new EmptyCntrSumVO[models.size()]);
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
		this.sumO4 = this.sumO4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumR2 = this.sumR2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumS4 = this.sumS4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumR5 = this.sumR5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumR4 = this.sumR4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumF2 = this.sumF2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumS2 = this.sumS2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumD2 = this.sumD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumF4 = this.sumF4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumA4 = this.sumA4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumD4 = this.sumD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumO2 = this.sumO2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumA2 = this.sumA2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumF5 = this.sumF5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumD5 = this.sumD5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumD7 = this.sumD7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
