/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManilaSearchCheckVvdVO.java
*@FileTitle : ManilaSearchCheckVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.21 임재택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo;

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
 * @author 임재택
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class ManilaSearchCheckVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ManilaSearchCheckVvdVO> models = new ArrayList<ManilaSearchCheckVvdVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String okFlag = null;
	/* Page Number */
	private String pagerows = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ManilaSearchCheckVvdVO() {}

	public ManilaSearchCheckVvdVO(String ibflag, String pagerows, String okFlag) {
		this.ibflag = ibflag;
		this.okFlag = okFlag;
		this.pagerows = pagerows;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ok_flag", getOkFlag());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ok_flag", "okFlag");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return okFlag
	 */
	public String getOkFlag() {
		return this.okFlag;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param okFlag
	 */
	public void setOkFlag(String okFlag) {
		this.okFlag = okFlag;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOkFlag(JSPUtil.getParameter(request, "ok_flag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return searchCheckVvdVO[]
	 */
	public ManilaSearchCheckVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchCheckVvdVO[]
	 */
	public ManilaSearchCheckVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ManilaSearchCheckVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] okFlag = (JSPUtil.getParameter(request, prefix	+ "ok_flag".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ManilaSearchCheckVvdVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (okFlag[i] != null)
					model.setOkFlag(okFlag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchCheckVvdVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return searchCheckVvdVO[]
	 */
	public ManilaSearchCheckVvdVO[] getsearchCheckVvdVOs(){
		ManilaSearchCheckVvdVO[] vos = (ManilaSearchCheckVvdVO[])models.toArray(new ManilaSearchCheckVvdVO[models.size()]);
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
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}
	
	/**
	 * getField 에서 catch문에 대한 로직
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void unDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.okFlag = this.okFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
