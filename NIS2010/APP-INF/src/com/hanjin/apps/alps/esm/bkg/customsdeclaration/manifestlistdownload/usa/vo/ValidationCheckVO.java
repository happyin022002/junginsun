/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ValidationCheckVO.java
*@FileTitle : ValidationCheckVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.05.28 이수빈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

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
 * @author 이수빈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ValidationCheckVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ValidationCheckVO> models = new ArrayList<ValidationCheckVO>();
	
	/* Column Info */
	private String err6 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String err5 = null;
	/* Column Info */
	private String caErr = null;
	/* Column Info */
	private String err3 = null;
	/* Column Info */
	private String err4 = null;
	/* Column Info */
	private String err1 = null;
	/* Column Info */
	private String err2 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ValidationCheckVO() {}

	public ValidationCheckVO(String ibflag, String pagerows, String err1, String err2, String err3, String err4, String err5, String err6, String caErr) {
		this.err6 = err6;
		this.ibflag = ibflag;
		this.err5 = err5;
		this.caErr = caErr;
		this.err3 = err3;
		this.err4 = err4;
		this.err1 = err1;
		this.err2 = err2;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("err_6", getErr6());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("err_5", getErr5());
		this.hashColumns.put("ca_err", getCaErr());
		this.hashColumns.put("err_3", getErr3());
		this.hashColumns.put("err_4", getErr4());
		this.hashColumns.put("err_1", getErr1());
		this.hashColumns.put("err_2", getErr2());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("err_6", "err6");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("err_5", "err5");
		this.hashFields.put("ca_err", "caErr");
		this.hashFields.put("err_3", "err3");
		this.hashFields.put("err_4", "err4");
		this.hashFields.put("err_1", "err1");
		this.hashFields.put("err_2", "err2");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return err6
	 */
	public String getErr6() {
		return this.err6;
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
	 * @return err5
	 */
	public String getErr5() {
		return this.err5;
	}
	
	/**
	 * Column Info
	 * @return caErr
	 */
	public String getCaErr() {
		return this.caErr;
	}
	
	/**
	 * Column Info
	 * @return err3
	 */
	public String getErr3() {
		return this.err3;
	}
	
	/**
	 * Column Info
	 * @return err4
	 */
	public String getErr4() {
		return this.err4;
	}
	
	/**
	 * Column Info
	 * @return err1
	 */
	public String getErr1() {
		return this.err1;
	}
	
	/**
	 * Column Info
	 * @return err2
	 */
	public String getErr2() {
		return this.err2;
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
	 * @param err6
	 */
	public void setErr6(String err6) {
		this.err6 = err6;
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
	 * @param err5
	 */
	public void setErr5(String err5) {
		this.err5 = err5;
	}
	
	/**
	 * Column Info
	 * @param caErr
	 */
	public void setCaErr(String caErr) {
		this.caErr = caErr;
	}
	
	/**
	 * Column Info
	 * @param err3
	 */
	public void setErr3(String err3) {
		this.err3 = err3;
	}
	
	/**
	 * Column Info
	 * @param err4
	 */
	public void setErr4(String err4) {
		this.err4 = err4;
	}
	
	/**
	 * Column Info
	 * @param err1
	 */
	public void setErr1(String err1) {
		this.err1 = err1;
	}
	
	/**
	 * Column Info
	 * @param err2
	 */
	public void setErr2(String err2) {
		this.err2 = err2;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setErr6(JSPUtil.getParameter(request, "err_6", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setErr5(JSPUtil.getParameter(request, "err_5", ""));
		setCaErr(JSPUtil.getParameter(request, "ca_err", ""));
		setErr3(JSPUtil.getParameter(request, "err_3", ""));
		setErr4(JSPUtil.getParameter(request, "err_4", ""));
		setErr1(JSPUtil.getParameter(request, "err_1", ""));
		setErr2(JSPUtil.getParameter(request, "err_2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ValidationCheckVO[]
	 */
	public ValidationCheckVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ValidationCheckVO[]
	 */
	public ValidationCheckVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ValidationCheckVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] err6 = (JSPUtil.getParameter(request, prefix	+ "err_6".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] err5 = (JSPUtil.getParameter(request, prefix	+ "err_5".trim(), length));
			String[] caErr = (JSPUtil.getParameter(request, prefix	+ "ca_err".trim(), length));
			String[] err3 = (JSPUtil.getParameter(request, prefix	+ "err_3".trim(), length));
			String[] err4 = (JSPUtil.getParameter(request, prefix	+ "err_4".trim(), length));
			String[] err1 = (JSPUtil.getParameter(request, prefix	+ "err_1".trim(), length));
			String[] err2 = (JSPUtil.getParameter(request, prefix	+ "err_2".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ValidationCheckVO();
				if (err6[i] != null)
					model.setErr6(err6[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (err5[i] != null)
					model.setErr5(err5[i]);
				if (caErr[i] != null)
					model.setCaErr(caErr[i]);
				if (err3[i] != null)
					model.setErr3(err3[i]);
				if (err4[i] != null)
					model.setErr4(err4[i]);
				if (err1[i] != null)
					model.setErr1(err1[i]);
				if (err2[i] != null)
					model.setErr2(err2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getValidationCheckVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ValidationCheckVO[]
	 */
	public ValidationCheckVO[] getValidationCheckVOs(){
		ValidationCheckVO[] vos = (ValidationCheckVO[])models.toArray(new ValidationCheckVO[models.size()]);
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
		this.err6 = this.err6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.err5 = this.err5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caErr = this.caErr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.err3 = this.err3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.err4 = this.err4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.err1 = this.err1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.err2 = this.err2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
