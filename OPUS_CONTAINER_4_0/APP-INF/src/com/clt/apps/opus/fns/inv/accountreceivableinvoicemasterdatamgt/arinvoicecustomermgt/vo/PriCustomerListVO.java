/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PriCustomerListVO.java
*@FileTitle : PriCustomerListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.06.08 김세일 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo;

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
 * @author 김세일
 * @since J2EE 1.5
 */

public class PriCustomerListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriCustomerListVO> models = new ArrayList<PriCustomerListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String customerType = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriCustomerListVO() {}

	public PriCustomerListVO(String ibflag, String pagerows, String customerType, String custCd, String custSeq, String custNm) {
		this.ibflag = ibflag;
		this.customerType = customerType;
		this.custNm = custNm;
		this.custCd = custCd;
		this.custSeq = custSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("customer_type", getCustomerType());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("customer_type", "customerType");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getCustomerType() {
		return this.customerType;
	}
	public String getCustNm() {
		return this.custNm;
	}
	public String getCustCd() {
		return this.custCd;
	}
	public String getCustSeq() {
		return this.custSeq;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
		//this.customerType=true;
	}
	public void setCustNm(String custNm) {
		this.custNm = custNm;
		//this.custNm=true;
	}
	public void setCustCd(String custCd) {
		this.custCd = custCd;
		//this.custCd=true;
	}
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
		//this.custSeq=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustomerType(JSPUtil.getParameter(request, "customer_type", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public PriCustomerListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public PriCustomerListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriCustomerListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] customerType = (JSPUtil.getParameter(request, prefix	+ "customer_type".trim(), length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm".trim(), length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new PriCustomerListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (customerType[i] != null)
					model.setCustomerType(customerType[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getPriCustomerListVOs();
	}

	public PriCustomerListVO[] getPriCustomerListVOs(){
		PriCustomerListVO[] vos = (PriCustomerListVO[])models.toArray(new PriCustomerListVO[models.size()]);
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
	 * @exception IllegalAccessException
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
		this.customerType = this.customerType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
