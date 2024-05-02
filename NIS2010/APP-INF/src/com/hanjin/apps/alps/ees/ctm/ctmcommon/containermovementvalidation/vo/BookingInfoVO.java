/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingInfoVO.java
*@FileTitle : BookingInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.05.06 우경민
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 우경민
 * @since J2EE 1.5
 */

public class BookingInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<BookingInfoVO> models = new ArrayList<BookingInfoVO>();

	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String textValue = null;
	/* Column Info */
	private String keyValue = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public BookingInfoVO() {}

	public BookingInfoVO(String ibflag, String pagerows, String keyValue, String textValue) {
		this.ibflag = ibflag;
		this.textValue = textValue;
		this.keyValue = keyValue;
		this.pagerows = pagerows;
	}

	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("text_value", getTextValue());
		this.hashColumns.put("key_value", getKeyValue());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("text_value", "textValue");
		this.hashFields.put("key_value", "keyValue");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	/* Column Info */
	public String getIbflag() {
		return this.ibflag;
	}
	/* Column Info */
	public String getTextValue() {
		return this.textValue;
	}
	/* Column Info */
	public String getKeyValue() {
		return this.keyValue;
	}
	/* Column Info */
	public String getPagerows() {
		return this.pagerows;
	}
	/* Column Info */

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	/* Column Info */
	public void setTextValue(String textValue) {
		this.textValue = textValue;
		//this.textValue=true;
	}
	/* Column Info */
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
		//this.keyValue=true;
	}
	/* Column Info */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	/* Column Info */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTextValue(JSPUtil.getParameter(request, "text_value", ""));
		setKeyValue(JSPUtil.getParameter(request, "key_value", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}
	/* Column Info */
	public BookingInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}
	/* Column Info */
	public BookingInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BookingInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] textValue = (JSPUtil.getParameter(request, prefix	+ "text_value".trim(), length));
			String[] keyValue = (JSPUtil.getParameter(request, prefix	+ "key_value".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new BookingInfoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (textValue[i] != null)
					model.setTextValue(textValue[i]);
				if (keyValue[i] != null)
					model.setKeyValue(keyValue[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBookingInfoVOs();
	}
	/* Column Info */
	public BookingInfoVO[] getBookingInfoVOs(){
		BookingInfoVO[] vos = (BookingInfoVO[])models.toArray(new BookingInfoVO[models.size()]);
		return vos;
	}
	/* Column Info */
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
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}

	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.textValue = this.textValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyValue = this.keyValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
