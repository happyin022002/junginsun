/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCNOManagementVO.java
*@FileTitle : SCNOManagementVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2009.08.11 신한성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.common.popup.vo;

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
 * @author 신한성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SCNOManagementVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SCNOManagementVO> models = new ArrayList<SCNOManagementVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String customercode = null;
	/* Column Info */
	private String curPage = null;
	/* Column Info */
	private String scno = null;
	/* Column Info */
	private String rowSize = null;
	/* Column Info */
	private String soffice = null;
	/* Column Info */
	private String custCntSeq = null;
	/* Column Info */
	private String customername = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SCNOManagementVO() {}

	public SCNOManagementVO(String ibflag, String pagerows, String customercode, String customername, String scno, String soffice, String custCntSeq, String curPage, String rowSize) {
		this.ibflag = ibflag;
		this.customercode = customercode;
		this.curPage = curPage;
		this.scno = scno;
		this.rowSize = rowSize;
		this.soffice = soffice;
		this.custCntSeq = custCntSeq;
		this.customername = customername;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("customercode", getCustomercode());
		this.hashColumns.put("cur_page", getCurPage());
		this.hashColumns.put("scno", getScno());
		this.hashColumns.put("row_size", getRowSize());
		this.hashColumns.put("soffice", getSoffice());
		this.hashColumns.put("cust_cnt_seq", getCustCntSeq());
		this.hashColumns.put("customername", getCustomername());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("customercode", "customercode");
		this.hashFields.put("cur_page", "curPage");
		this.hashFields.put("scno", "scno");
		this.hashFields.put("row_size", "rowSize");
		this.hashFields.put("soffice", "soffice");
		this.hashFields.put("cust_cnt_seq", "custCntSeq");
		this.hashFields.put("customername", "customername");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return customercode
	 */
	public String getCustomercode() {
		return this.customercode;
	}
	
	/**
	 * Column Info
	 * @return curPage
	 */
	public String getCurPage() {
		return this.curPage;
	}
	
	/**
	 * Column Info
	 * @return scno
	 */
	public String getScno() {
		return this.scno;
	}
	
	/**
	 * Column Info
	 * @return rowSize
	 */
	public String getRowSize() {
		return this.rowSize;
	}
	
	/**
	 * Column Info
	 * @return soffice
	 */
	public String getSoffice() {
		return this.soffice;
	}
	
	/**
	 * Column Info
	 * @return custCntSeq
	 */
	public String getCustCntSeq() {
		return this.custCntSeq;
	}
	
	/**
	 * Column Info
	 * @return customername
	 */
	public String getCustomername() {
		return this.customername;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param customercode
	 */
	public void setCustomercode(String customercode) {
		this.customercode = customercode;
	}
	
	/**
	 * Column Info
	 * @param curPage
	 */
	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}
	
	/**
	 * Column Info
	 * @param scno
	 */
	public void setScno(String scno) {
		this.scno = scno;
	}
	
	/**
	 * Column Info
	 * @param rowSize
	 */
	public void setRowSize(String rowSize) {
		this.rowSize = rowSize;
	}
	
	/**
	 * Column Info
	 * @param soffice
	 */
	public void setSoffice(String soffice) {
		this.soffice = soffice;
	}
	
	/**
	 * Column Info
	 * @param custCntSeq
	 */
	public void setCustCntSeq(String custCntSeq) {
		this.custCntSeq = custCntSeq;
	}
	
	/**
	 * Column Info
	 * @param customername
	 */
	public void setCustomername(String customername) {
		this.customername = customername;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustomercode(JSPUtil.getParameter(request, "customercode", ""));
		setCurPage(JSPUtil.getParameter(request, "cur_page", ""));
		setScno(JSPUtil.getParameter(request, "scno", ""));
		setRowSize(JSPUtil.getParameter(request, "row_size", ""));
		setSoffice(JSPUtil.getParameter(request, "soffice", ""));
		setCustCntSeq(JSPUtil.getParameter(request, "cust_cnt_seq", ""));
		setCustomername(JSPUtil.getParameter(request, "customername", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SCNOManagementVO[]
	 */
	public SCNOManagementVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SCNOManagementVO[]
	 */
	public SCNOManagementVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SCNOManagementVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] customercode = (JSPUtil.getParameter(request, prefix	+ "customercode", length));
			String[] curPage = (JSPUtil.getParameter(request, prefix	+ "cur_page", length));
			String[] scno = (JSPUtil.getParameter(request, prefix	+ "scno", length));
			String[] rowSize = (JSPUtil.getParameter(request, prefix	+ "row_size", length));
			String[] soffice = (JSPUtil.getParameter(request, prefix	+ "soffice", length));
			String[] custCntSeq = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_seq", length));
			String[] customername = (JSPUtil.getParameter(request, prefix	+ "customername", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SCNOManagementVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (customercode[i] != null)
					model.setCustomercode(customercode[i]);
				if (curPage[i] != null)
					model.setCurPage(curPage[i]);
				if (scno[i] != null)
					model.setScno(scno[i]);
				if (rowSize[i] != null)
					model.setRowSize(rowSize[i]);
				if (soffice[i] != null)
					model.setSoffice(soffice[i]);
				if (custCntSeq[i] != null)
					model.setCustCntSeq(custCntSeq[i]);
				if (customername[i] != null)
					model.setCustomername(customername[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSCNOManagementVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SCNOManagementVO[]
	 */
	public SCNOManagementVO[] getSCNOManagementVOs(){
		SCNOManagementVO[] vos = (SCNOManagementVO[])models.toArray(new SCNOManagementVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customercode = this.customercode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curPage = this.curPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scno = this.scno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowSize = this.rowSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soffice = this.soffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntSeq = this.custCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customername = this.customername .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
