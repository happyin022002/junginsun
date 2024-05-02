/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCalOffhireInvoiceListSumVO.java
*@FileTitle : SearchCalOffhireInvoiceListSumVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.05.08 정윤태 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

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
 * @author 정윤태
 * @since J2EE 1.5
 * @see ESM_FMS_0014HTMLAction
 */

public class SearchCalOffhireInvoiceListSumVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCalOffhireInvoiceListSumVO> models = new ArrayList<SearchCalOffhireInvoiceListSumVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String currCd2 = null;
	/* Column Info */
	private String invAmt2 = null;
	/* Column Info */
	private String invAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public SearchCalOffhireInvoiceListSumVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String currCd, String invAmt, String currCd2, String invAmt2
	 * @return 
	 */
	public SearchCalOffhireInvoiceListSumVO(String ibflag, String pagerows, String currCd, String invAmt, String currCd2, String invAmt2) {
		this.ibflag = ibflag;
		this.currCd = currCd;
		this.currCd2 = currCd2;
		this.invAmt2 = invAmt2;
		this.invAmt = invAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("curr_cd2", getCurrCd2());
		this.hashColumns.put("inv_amt2", getInvAmt2());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("curr_cd2", "currCd2");
		this.hashFields.put("inv_amt2", "invAmt2");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getCurrCd() {
		return this.currCd;
	}
	public String getCurrCd2() {
		return this.currCd2;
	}
	public String getInvAmt2() {
		return this.invAmt2;
	}
	public String getInvAmt() {
		return this.invAmt;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
		//this.currCd=true;
	}
	public void setCurrCd2(String currCd2) {
		this.currCd2 = currCd2;
		//this.currCd2=true;
	}
	public void setInvAmt2(String invAmt2) {
		this.invAmt2 = invAmt2;
		//this.invAmt2=true;
	}
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
		//this.invAmt=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setCurrCd2(JSPUtil.getParameter(request, "curr_cd2", ""));
		setInvAmt2(JSPUtil.getParameter(request, "inv_amt2", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public SearchCalOffhireInvoiceListSumVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchCalOffhireInvoiceListSumVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCalOffhireInvoiceListSumVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd".trim(), length));
			String[] currCd2 = (JSPUtil.getParameter(request, prefix	+ "curr_cd2".trim(), length));
			String[] invAmt2 = (JSPUtil.getParameter(request, prefix	+ "inv_amt2".trim(), length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCalOffhireInvoiceListSumVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (currCd2[i] != null)
					model.setCurrCd2(currCd2[i]);
				if (invAmt2[i] != null)
					model.setInvAmt2(invAmt2[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchCalOffhireInvoiceListSumVOs();
	}

	public SearchCalOffhireInvoiceListSumVO[] getSearchCalOffhireInvoiceListSumVOs(){
		SearchCalOffhireInvoiceListSumVO[] vos = (SearchCalOffhireInvoiceListSumVO[])models.toArray(new SearchCalOffhireInvoiceListSumVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd2 = this.currCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt2 = this.invAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
