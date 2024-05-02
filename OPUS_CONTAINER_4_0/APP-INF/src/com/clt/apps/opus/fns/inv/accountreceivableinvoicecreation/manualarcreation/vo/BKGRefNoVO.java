/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BKGRefNoVO.java
*@FileTitle : BKGRefNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.05.22 정휘택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo;

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
 * @author 정휘택
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class BKGRefNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BKGRefNoVO> models = new ArrayList<BKGRefNoVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String custRefNo1 = null;
	/* Column Info */
	private String custRefNo2 = null;
	/* Column Info */
	private String custRefNo3 = null;
	/* Page Number */
	private String pagerows = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BKGRefNoVO() {}

	public BKGRefNoVO(String ibflag, String pagerows, String custRefNo1, String custRefNo2, String custRefNo3) {
		this.ibflag = ibflag;
		this.custRefNo1 = custRefNo1;
		this.custRefNo2 = custRefNo2;
		this.custRefNo3 = custRefNo3;
		this.pagerows = pagerows;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_ref_no1", getCustRefNo1());
		this.hashColumns.put("cust_ref_no2", getCustRefNo2());
		this.hashColumns.put("cust_ref_no3", getCustRefNo3());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_ref_no1", "custRefNo1");
		this.hashFields.put("cust_ref_no2", "custRefNo2");
		this.hashFields.put("cust_ref_no3", "custRefNo3");
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
	 * @return custRefNo1
	 */
	public String getCustRefNo1() {
		return this.custRefNo1;
	}
	
	/**
	 * Column Info
	 * @return custRefNo2
	 */
	public String getCustRefNo2() {
		return this.custRefNo2;
	}
	
	/**
	 * Column Info
	 * @return custRefNo3
	 */
	public String getCustRefNo3() {
		return this.custRefNo3;
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
	 * @param custRefNo1
	 */
	public void setCustRefNo1(String custRefNo1) {
		this.custRefNo1 = custRefNo1;
	}
	
	/**
	 * Column Info
	 * @param custRefNo2
	 */
	public void setCustRefNo2(String custRefNo2) {
		this.custRefNo2 = custRefNo2;
	}
	
	/**
	 * Column Info
	 * @param custRefNo3
	 */
	public void setCustRefNo3(String custRefNo3) {
		this.custRefNo3 = custRefNo3;
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
		setCustRefNo1(JSPUtil.getParameter(request, "cust_ref_no1", ""));
		setCustRefNo2(JSPUtil.getParameter(request, "cust_ref_no2", ""));
		setCustRefNo3(JSPUtil.getParameter(request, "cust_ref_no3", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return BKGRefNoVO[]
	 */
	public BKGRefNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BKGRefNoVO[]
	 */
	public BKGRefNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BKGRefNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] custRefNo1 = (JSPUtil.getParameter(request, prefix	+ "cust_ref_no1".trim(), length));
			String[] custRefNo2 = (JSPUtil.getParameter(request, prefix	+ "cust_ref_no2".trim(), length));
			String[] custRefNo3 = (JSPUtil.getParameter(request, prefix	+ "cust_ref_no3".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new BKGRefNoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custRefNo1[i] != null)
					model.setCustRefNo1(custRefNo1[i]);
				if (custRefNo2[i] != null)
					model.setCustRefNo2(custRefNo2[i]);
				if (custRefNo3[i] != null)
					model.setCustRefNo3(custRefNo3[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBKGRefNoVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return BKGRefNoVO[]
	 */
	public BKGRefNoVO[] getBKGRefNoVOs(){
		BKGRefNoVO[] vos = (BKGRefNoVO[])models.toArray(new BKGRefNoVO[models.size()]);
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
		this.custRefNo1 = this.custRefNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefNo2 = this.custRefNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefNo3 = this.custRefNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
