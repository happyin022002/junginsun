/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MultiCustomerVO.java
*@FileTitle : MultiCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.06.03 김세일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo;

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
 * @author 김세일
 * @since J2EE 1.5
 */

public class MultiCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MultiCustomerVO> models = new ArrayList<MultiCustomerVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String confirmFlag = null;
	/* Column Info */
	private String custCntCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MultiCustomerVO() {}

	public MultiCustomerVO(String ibflag, String pagerows, String custCntCd, String custSeq, String confirmFlag) {
		this.ibflag = ibflag;
		this.custSeq = custSeq;
		this.confirmFlag = confirmFlag;
		this.custCntCd = custCntCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("confirm_flag", getConfirmFlag());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("confirm_flag", "confirmFlag");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getCustSeq() {
		return this.custSeq;
	}
	public String getConfirmFlag() {
		return this.confirmFlag;
	}
	public String getCustCntCd() {
		return this.custCntCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
		//this.custSeq=true;
	}
	public void setConfirmFlag(String confirmFlag) {
		this.confirmFlag = confirmFlag;
		//this.confirmFlag=true;
	}
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
		//this.custCntCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setConfirmFlag(JSPUtil.getParameter(request, "confirm_flag", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public MultiCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public MultiCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MultiCustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] confirmFlag = (JSPUtil.getParameter(request, prefix	+ "confirm_flag".trim(), length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new MultiCustomerVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (confirmFlag[i] != null)
					model.setConfirmFlag(confirmFlag[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getMultiCustomerVOs();
	}

	public MultiCustomerVO[] getMultiCustomerVOs(){
		MultiCustomerVO[] vos = (MultiCustomerVO[])models.toArray(new MultiCustomerVO[models.size()]);
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
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.confirmFlag = this.confirmFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
