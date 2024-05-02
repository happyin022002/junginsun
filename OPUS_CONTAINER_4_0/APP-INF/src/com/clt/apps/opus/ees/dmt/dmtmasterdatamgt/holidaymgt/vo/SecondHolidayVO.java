/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SecondHolidayVO.java
*@FileTitle : SecondHolidayVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.01.21
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.01.21 이성훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 이성훈
 * @since J2EE 1.5
 */

public class SecondHolidayVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SecondHolidayVO> models = new ArrayList<SecondHolidayVO>();
	
	/* 而щ읆 �ㅻ챸 */
	private String secondholiday = null;
	/* �곹깭 */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SecondHolidayVO() {}

	public SecondHolidayVO(String ibflag, String pagerows, String secondholiday) {
		this.secondholiday = secondholiday;
		this.ibflag = ibflag;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("secondholiday", getSecondholiday());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("secondholiday", "secondholiday");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getSecondholiday() {
		return this.secondholiday;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setSecondholiday(String secondholiday) {
		this.secondholiday = secondholiday;
		//this.secondholiday=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setSecondholiday(JSPUtil.getParameter(request, "secondholiday", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public SecondHolidayVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SecondHolidayVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SecondHolidayVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] secondholiday = (JSPUtil.getParameter(request, prefix	+ "secondholiday".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SecondHolidayVO();
				if (secondholiday[i] != null)
					model.setSecondholiday(secondholiday[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSecondHolidayVOs();
	}

	public SecondHolidayVO[] getSecondHolidayVOs(){
		SecondHolidayVO[] vos = (SecondHolidayVO[])models.toArray(new SecondHolidayVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
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
		this.secondholiday = this.secondholiday .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
