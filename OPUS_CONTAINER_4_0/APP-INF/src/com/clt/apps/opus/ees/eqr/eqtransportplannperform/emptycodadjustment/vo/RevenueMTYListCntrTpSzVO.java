/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RevenueMTYListCntrTpSzVO.java
*@FileTitle : RevenueMTYListCntrTpSzVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.08.10 문중철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo;

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
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RevenueMTYListCntrTpSzVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RevenueMTYListCntrTpSzVO> models = new ArrayList<RevenueMTYListCntrTpSzVO>();
	
	/* Column Info */
	private String o2 = null;
	/* Column Info */
	private String s2 = null;
	/* Column Info */
	private String o4 = null;
	/* Column Info */
	private String d5 = null;
	/* Column Info */
	private String d4 = null;
	/* Column Info */
	private String d7 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String d2 = null;
	/* Column Info */
	private String a2 = null;
	/* Column Info */
	private String a4 = null;
	/* Column Info */
	private String r2 = null;
	/* Column Info */
	private String f2 = null;
	/* Column Info */
	private String f5 = null;
	/* Column Info */
	private String f4 = null;
	/* Column Info */
	private String r5 = null;
	/* Column Info */
	private String s4 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RevenueMTYListCntrTpSzVO() {}

	public RevenueMTYListCntrTpSzVO(String ibflag, String pagerows, String d2, String d4, String d5, String d7, String r2, String r5, String o2, String s2, String o4, String s4, String f2, String a2, String f4, String a4, String f5) {
		this.o2 = o2;
		this.s2 = s2;
		this.o4 = o4;
		this.d5 = d5;
		this.d4 = d4;
		this.d7 = d7;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.d2 = d2;
		this.a2 = a2;
		this.a4 = a4;
		this.r2 = r2;
		this.f2 = f2;
		this.f5 = f5;
		this.f4 = f4;
		this.r5 = r5;
		this.s4 = s4;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("o2", getO2());
		this.hashColumns.put("s2", getS2());
		this.hashColumns.put("o4", getO4());
		this.hashColumns.put("d5", getD5());
		this.hashColumns.put("d4", getD4());
		this.hashColumns.put("d7", getD7());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("d2", getD2());
		this.hashColumns.put("a2", getA2());
		this.hashColumns.put("a4", getA4());
		this.hashColumns.put("r2", getR2());
		this.hashColumns.put("f2", getF2());
		this.hashColumns.put("f5", getF5());
		this.hashColumns.put("f4", getF4());
		this.hashColumns.put("r5", getR5());
		this.hashColumns.put("s4", getS4());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("o2", "o2");
		this.hashFields.put("s2", "s2");
		this.hashFields.put("o4", "o4");
		this.hashFields.put("d5", "d5");
		this.hashFields.put("d4", "d4");
		this.hashFields.put("d7", "d7");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("d2", "d2");
		this.hashFields.put("a2", "a2");
		this.hashFields.put("a4", "a4");
		this.hashFields.put("r2", "r2");
		this.hashFields.put("f2", "f2");
		this.hashFields.put("f5", "f5");
		this.hashFields.put("f4", "f4");
		this.hashFields.put("r5", "r5");
		this.hashFields.put("s4", "s4");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return o2
	 */
	public String getO2() {
		return this.o2;
	}
	
	/**
	 * Column Info
	 * @return s2
	 */
	public String getS2() {
		return this.s2;
	}
	
	/**
	 * Column Info
	 * @return o4
	 */
	public String getO4() {
		return this.o4;
	}
	
	/**
	 * Column Info
	 * @return d5
	 */
	public String getD5() {
		return this.d5;
	}
	
	/**
	 * Column Info
	 * @return d4
	 */
	public String getD4() {
		return this.d4;
	}
	
	/**
	 * Column Info
	 * @return d7
	 */
	public String getD7() {
		return this.d7;
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
	 * @return d2
	 */
	public String getD2() {
		return this.d2;
	}
	
	/**
	 * Column Info
	 * @return a2
	 */
	public String getA2() {
		return this.a2;
	}
	
	/**
	 * Column Info
	 * @return a4
	 */
	public String getA4() {
		return this.a4;
	}
	
	/**
	 * Column Info
	 * @return r2
	 */
	public String getR2() {
		return this.r2;
	}
	
	/**
	 * Column Info
	 * @return f2
	 */
	public String getF2() {
		return this.f2;
	}
	
	/**
	 * Column Info
	 * @return f5
	 */
	public String getF5() {
		return this.f5;
	}
	
	/**
	 * Column Info
	 * @return f4
	 */
	public String getF4() {
		return this.f4;
	}
	
	/**
	 * Column Info
	 * @return r5
	 */
	public String getR5() {
		return this.r5;
	}
	
	/**
	 * Column Info
	 * @return s4
	 */
	public String getS4() {
		return this.s4;
	}
	

	/**
	 * Column Info
	 * @param o2
	 */
	public void setO2(String o2) {
		this.o2 = o2;
	}
	
	/**
	 * Column Info
	 * @param s2
	 */
	public void setS2(String s2) {
		this.s2 = s2;
	}
	
	/**
	 * Column Info
	 * @param o4
	 */
	public void setO4(String o4) {
		this.o4 = o4;
	}
	
	/**
	 * Column Info
	 * @param d5
	 */
	public void setD5(String d5) {
		this.d5 = d5;
	}
	
	/**
	 * Column Info
	 * @param d4
	 */
	public void setD4(String d4) {
		this.d4 = d4;
	}
	
	/**
	 * Column Info
	 * @param d7
	 */
	public void setD7(String d7) {
		this.d7 = d7;
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
	 * @param d2
	 */
	public void setD2(String d2) {
		this.d2 = d2;
	}
	
	/**
	 * Column Info
	 * @param a2
	 */
	public void setA2(String a2) {
		this.a2 = a2;
	}
	
	/**
	 * Column Info
	 * @param a4
	 */
	public void setA4(String a4) {
		this.a4 = a4;
	}
	
	/**
	 * Column Info
	 * @param r2
	 */
	public void setR2(String r2) {
		this.r2 = r2;
	}
	
	/**
	 * Column Info
	 * @param f2
	 */
	public void setF2(String f2) {
		this.f2 = f2;
	}
	
	/**
	 * Column Info
	 * @param f5
	 */
	public void setF5(String f5) {
		this.f5 = f5;
	}
	
	/**
	 * Column Info
	 * @param f4
	 */
	public void setF4(String f4) {
		this.f4 = f4;
	}
	
	/**
	 * Column Info
	 * @param r5
	 */
	public void setR5(String r5) {
		this.r5 = r5;
	}
	
	/**
	 * Column Info
	 * @param s4
	 */
	public void setS4(String s4) {
		this.s4 = s4;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setO2(JSPUtil.getParameter(request, "o2", ""));
		setS2(JSPUtil.getParameter(request, "s2", ""));
		setO4(JSPUtil.getParameter(request, "o4", ""));
		setD5(JSPUtil.getParameter(request, "d5", ""));
		setD4(JSPUtil.getParameter(request, "d4", ""));
		setD7(JSPUtil.getParameter(request, "d7", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setD2(JSPUtil.getParameter(request, "d2", ""));
		setA2(JSPUtil.getParameter(request, "a2", ""));
		setA4(JSPUtil.getParameter(request, "a4", ""));
		setR2(JSPUtil.getParameter(request, "r2", ""));
		setF2(JSPUtil.getParameter(request, "f2", ""));
		setF5(JSPUtil.getParameter(request, "f5", ""));
		setF4(JSPUtil.getParameter(request, "f4", ""));
		setR5(JSPUtil.getParameter(request, "r5", ""));
		setS4(JSPUtil.getParameter(request, "s4", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RevenueMTYListCntrTpSzVO[]
	 */
	public RevenueMTYListCntrTpSzVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RevenueMTYListCntrTpSzVO[]
	 */
	public RevenueMTYListCntrTpSzVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RevenueMTYListCntrTpSzVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] o2 = (JSPUtil.getParameter(request, prefix	+ "o2", length));
			String[] s2 = (JSPUtil.getParameter(request, prefix	+ "s2", length));
			String[] o4 = (JSPUtil.getParameter(request, prefix	+ "o4", length));
			String[] d5 = (JSPUtil.getParameter(request, prefix	+ "d5", length));
			String[] d4 = (JSPUtil.getParameter(request, prefix	+ "d4", length));
			String[] d7 = (JSPUtil.getParameter(request, prefix	+ "d7", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] d2 = (JSPUtil.getParameter(request, prefix	+ "d2", length));
			String[] a2 = (JSPUtil.getParameter(request, prefix	+ "a2", length));
			String[] a4 = (JSPUtil.getParameter(request, prefix	+ "a4", length));
			String[] r2 = (JSPUtil.getParameter(request, prefix	+ "r2", length));
			String[] f2 = (JSPUtil.getParameter(request, prefix	+ "f2", length));
			String[] f5 = (JSPUtil.getParameter(request, prefix	+ "f5", length));
			String[] f4 = (JSPUtil.getParameter(request, prefix	+ "f4", length));
			String[] r5 = (JSPUtil.getParameter(request, prefix	+ "r5", length));
			String[] s4 = (JSPUtil.getParameter(request, prefix	+ "s4", length));
			
			for (int i = 0; i < length; i++) {
				model = new RevenueMTYListCntrTpSzVO();
				if (o2[i] != null)
					model.setO2(o2[i]);
				if (s2[i] != null)
					model.setS2(s2[i]);
				if (o4[i] != null)
					model.setO4(o4[i]);
				if (d5[i] != null)
					model.setD5(d5[i]);
				if (d4[i] != null)
					model.setD4(d4[i]);
				if (d7[i] != null)
					model.setD7(d7[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (d2[i] != null)
					model.setD2(d2[i]);
				if (a2[i] != null)
					model.setA2(a2[i]);
				if (a4[i] != null)
					model.setA4(a4[i]);
				if (r2[i] != null)
					model.setR2(r2[i]);
				if (f2[i] != null)
					model.setF2(f2[i]);
				if (f5[i] != null)
					model.setF5(f5[i]);
				if (f4[i] != null)
					model.setF4(f4[i]);
				if (r5[i] != null)
					model.setR5(r5[i]);
				if (s4[i] != null)
					model.setS4(s4[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRevenueMTYListCntrTpSzVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RevenueMTYListCntrTpSzVO[]
	 */
	public RevenueMTYListCntrTpSzVO[] getRevenueMTYListCntrTpSzVOs(){
		RevenueMTYListCntrTpSzVO[] vos = (RevenueMTYListCntrTpSzVO[])models.toArray(new RevenueMTYListCntrTpSzVO[models.size()]);
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
		this.o2 = this.o2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2 = this.s2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4 = this.o4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5 = this.d5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4 = this.d4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7 = this.d7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2 = this.d2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2 = this.a2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4 = this.a4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2 = this.r2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2 = this.f2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5 = this.f5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4 = this.f4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5 = this.r5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4 = this.s4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
