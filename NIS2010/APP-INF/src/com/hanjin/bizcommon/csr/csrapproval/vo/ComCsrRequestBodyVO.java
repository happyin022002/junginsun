/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ComCsrRequestBodyVO.java
*@FileTitle : ComCsrRequestBodyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.08  
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.csr.csrapproval.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ComCsrRequestBodyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComCsrRequestBodyVO> models = new ArrayList<ComCsrRequestBodyVO>();
	
	/* Column Info */
	private String lAccountName = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lCreditAmt = null;
	/* Column Info */
	private String lCoa = null;
	/* Column Info */
	private String lDescription = null;
	/* Column Info */
	private String lCity = null;
	/* Column Info */
	private String lSeq = null;
	/* Column Info */
	private String lVendorInvNo = null;
	/* Column Info */
	private String lGlDate = null;
	/* Column Info */
	private String lDebitAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ComCsrRequestBodyVO() {}

	public ComCsrRequestBodyVO(String ibflag, String pagerows, String lSeq, String lCoa, String lAccountName, String lGlDate, String lCity, String lVendorInvNo, String lDescription, String lDebitAmt, String lCreditAmt) {
		this.lAccountName = lAccountName;
		this.ibflag = ibflag;
		this.lCreditAmt = lCreditAmt;
		this.lCoa = lCoa;
		this.lDescription = lDescription;
		this.lCity = lCity;
		this.lSeq = lSeq;
		this.lVendorInvNo = lVendorInvNo;
		this.lGlDate = lGlDate;
		this.lDebitAmt = lDebitAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("l_account_name", getLAccountName());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("l_credit_amt", getLCreditAmt());
		this.hashColumns.put("l_coa", getLCoa());
		this.hashColumns.put("l_description", getLDescription());
		this.hashColumns.put("l_city", getLCity());
		this.hashColumns.put("l_seq", getLSeq());
		this.hashColumns.put("l_vendor_inv_no", getLVendorInvNo());
		this.hashColumns.put("l_gl_date", getLGlDate());
		this.hashColumns.put("l_debit_amt", getLDebitAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("l_account_name", "lAccountName");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("l_credit_amt", "lCreditAmt");
		this.hashFields.put("l_coa", "lCoa");
		this.hashFields.put("l_description", "lDescription");
		this.hashFields.put("l_city", "lCity");
		this.hashFields.put("l_seq", "lSeq");
		this.hashFields.put("l_vendor_inv_no", "lVendorInvNo");
		this.hashFields.put("l_gl_date", "lGlDate");
		this.hashFields.put("l_debit_amt", "lDebitAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lAccountName
	 */
	public String getLAccountName() {
		return this.lAccountName;
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
	 * @return lCreditAmt
	 */
	public String getLCreditAmt() {
		return this.lCreditAmt;
	}
	
	/**
	 * Column Info
	 * @return lCoa
	 */
	public String getLCoa() {
		return this.lCoa;
	}
	
	/**
	 * Column Info
	 * @return lDescription
	 */
	public String getLDescription() {
		return this.lDescription;
	}
	
	/**
	 * Column Info
	 * @return lCity
	 */
	public String getLCity() {
		return this.lCity;
	}
	
	/**
	 * Column Info
	 * @return lSeq
	 */
	public String getLSeq() {
		return this.lSeq;
	}
	
	/**
	 * Column Info
	 * @return lVendorInvNo
	 */
	public String getLVendorInvNo() {
		return this.lVendorInvNo;
	}
	
	/**
	 * Column Info
	 * @return lGlDate
	 */
	public String getLGlDate() {
		return this.lGlDate;
	}
	
	/**
	 * Column Info
	 * @return lDebitAmt
	 */
	public String getLDebitAmt() {
		return this.lDebitAmt;
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
	 * @param lAccountName
	 */
	public void setLAccountName(String lAccountName) {
		this.lAccountName = lAccountName;
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
	 * @param lCreditAmt
	 */
	public void setLCreditAmt(String lCreditAmt) {
		this.lCreditAmt = lCreditAmt;
	}
	
	/**
	 * Column Info
	 * @param lCoa
	 */
	public void setLCoa(String lCoa) {
		this.lCoa = lCoa;
	}
	
	/**
	 * Column Info
	 * @param lDescription
	 */
	public void setLDescription(String lDescription) {
		this.lDescription = lDescription;
	}
	
	/**
	 * Column Info
	 * @param lCity
	 */
	public void setLCity(String lCity) {
		this.lCity = lCity;
	}
	
	/**
	 * Column Info
	 * @param lSeq
	 */
	public void setLSeq(String lSeq) {
		this.lSeq = lSeq;
	}
	
	/**
	 * Column Info
	 * @param lVendorInvNo
	 */
	public void setLVendorInvNo(String lVendorInvNo) {
		this.lVendorInvNo = lVendorInvNo;
	}
	
	/**
	 * Column Info
	 * @param lGlDate
	 */
	public void setLGlDate(String lGlDate) {
		this.lGlDate = lGlDate;
	}
	
	/**
	 * Column Info
	 * @param lDebitAmt
	 */
	public void setLDebitAmt(String lDebitAmt) {
		this.lDebitAmt = lDebitAmt;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setLAccountName(JSPUtil.getParameter(request, prefix + "l_account_name", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLCreditAmt(JSPUtil.getParameter(request, prefix + "l_credit_amt", ""));
		setLCoa(JSPUtil.getParameter(request, prefix + "l_coa", ""));
		setLDescription(JSPUtil.getParameter(request, prefix + "l_description", ""));
		setLCity(JSPUtil.getParameter(request, prefix + "l_city", ""));
		setLSeq(JSPUtil.getParameter(request, prefix + "l_seq", ""));
		setLVendorInvNo(JSPUtil.getParameter(request, prefix + "l_vendor_inv_no", ""));
		setLGlDate(JSPUtil.getParameter(request, prefix + "l_gl_date", ""));
		setLDebitAmt(JSPUtil.getParameter(request, prefix + "l_debit_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ComCsrRequestBodyVO[]
	 */
	public ComCsrRequestBodyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ComCsrRequestBodyVO[]
	 */
	public ComCsrRequestBodyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComCsrRequestBodyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lAccountName = (JSPUtil.getParameter(request, prefix	+ "l_account_name", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lCreditAmt = (JSPUtil.getParameter(request, prefix	+ "l_credit_amt", length));
			String[] lCoa = (JSPUtil.getParameter(request, prefix	+ "l_coa", length));
			String[] lDescription = (JSPUtil.getParameter(request, prefix	+ "l_description", length));
			String[] lCity = (JSPUtil.getParameter(request, prefix	+ "l_city", length));
			String[] lSeq = (JSPUtil.getParameter(request, prefix	+ "l_seq", length));
			String[] lVendorInvNo = (JSPUtil.getParameter(request, prefix	+ "l_vendor_inv_no", length));
			String[] lGlDate = (JSPUtil.getParameter(request, prefix	+ "l_gl_date", length));
			String[] lDebitAmt = (JSPUtil.getParameter(request, prefix	+ "l_debit_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComCsrRequestBodyVO();
				if (lAccountName[i] != null)
					model.setLAccountName(lAccountName[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lCreditAmt[i] != null)
					model.setLCreditAmt(lCreditAmt[i]);
				if (lCoa[i] != null)
					model.setLCoa(lCoa[i]);
				if (lDescription[i] != null)
					model.setLDescription(lDescription[i]);
				if (lCity[i] != null)
					model.setLCity(lCity[i]);
				if (lSeq[i] != null)
					model.setLSeq(lSeq[i]);
				if (lVendorInvNo[i] != null)
					model.setLVendorInvNo(lVendorInvNo[i]);
				if (lGlDate[i] != null)
					model.setLGlDate(lGlDate[i]);
				if (lDebitAmt[i] != null)
					model.setLDebitAmt(lDebitAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getComCsrRequestBodyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ComCsrRequestBodyVO[]
	 */
	public ComCsrRequestBodyVO[] getComCsrRequestBodyVOs(){
		ComCsrRequestBodyVO[] vos = (ComCsrRequestBodyVO[])models.toArray(new ComCsrRequestBodyVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.lAccountName = this.lAccountName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lCreditAmt = this.lCreditAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lCoa = this.lCoa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lDescription = this.lDescription .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lCity = this.lCity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lSeq = this.lSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lVendorInvNo = this.lVendorInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lGlDate = this.lGlDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lDebitAmt = this.lDebitAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
