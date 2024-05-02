/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortSOMasterDataConditionVO.java
*@FileTitle : PortSOMasterDataConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.05.20 박명종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo;

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
 * @author 박명종
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class PortSOMasterDataConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PortSOMasterDataConditionVO> models = new ArrayList<PortSOMasterDataConditionVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String fromDate = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */
	private String srhCnd = null;
	/* Page Number */
	private String pagerows = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PortSOMasterDataConditionVO() {}

	public PortSOMasterDataConditionVO(String ibflag, String pagerows, String toDate, String fromDate, String srhCnd) {
		this.ibflag = ibflag;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.srhCnd = srhCnd;
		this.pagerows = pagerows;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("from_date", getFromDate());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("srh_cnd", getSrhCnd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("from_date", "fromDate");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("srh_cnd", "srhCnd");
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
	 * @return fromDate
	 */
	public String getFromDate() {
		return this.fromDate;
	}
	
	/**
	 * Column Info
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
	}
	
	/**
	 * Column Info
	 * @return srhCnd
	 */
	public String getSrhCnd() {
		return this.srhCnd;
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
	 * @param fromDate
	 */
	public void setFromDate(String fromDate) {
		if( fromDate.length() > 6 )
			fromDate = fromDate.substring(0, 4) + fromDate.substring(5);
		this.fromDate = fromDate;
	}
	
	/**
	 * Column Info
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		if( toDate.length() > 6 )
			toDate = toDate.substring(0, 4) + toDate.substring(5);
		this.toDate = toDate;
	}
	
	/**
	 * Column Info
	 * @param srhCnd
	 */
	public void setSrhCnd(String srhCnd) {
		this.srhCnd = srhCnd;
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
		setFromDate(JSPUtil.getParameter(request, "from_date", ""));
		setToDate(JSPUtil.getParameter(request, "to_date", ""));
		setSrhCnd(JSPUtil.getParameter(request, "srh_cnd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return PortSOMasterDataConditionVO[]
	 */
	public PortSOMasterDataConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortSOMasterDataConditionVO[]
	 */
	public PortSOMasterDataConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PortSOMasterDataConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] fromDate = (JSPUtil.getParameter(request, prefix	+ "from_date".trim(), length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date".trim(), length));
			String[] srhCnd = (JSPUtil.getParameter(request, prefix	+ "srh_cnd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new PortSOMasterDataConditionVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fromDate[i] != null)
					model.setFromDate(fromDate[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (srhCnd[i] != null)
					model.setSrhCnd(srhCnd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPortSOMasterDataConditionVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return PortSOMasterDataConditionVO[]
	 */
	public PortSOMasterDataConditionVO[] getPortSOMasterDataConditionVOs(){
		PortSOMasterDataConditionVO[] vos = (PortSOMasterDataConditionVO[])models.toArray(new PortSOMasterDataConditionVO[models.size()]);
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
		this.fromDate = this.fromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srhCnd = this.srhCnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
