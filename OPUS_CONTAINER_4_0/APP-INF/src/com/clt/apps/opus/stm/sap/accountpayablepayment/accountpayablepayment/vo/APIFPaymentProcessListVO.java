/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : APIFPaymentProcessListVO.java
*@FileTitle : APIFPaymentProcessListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.21  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class APIFPaymentProcessListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<APIFPaymentProcessListVO> models = new ArrayList<APIFPaymentProcessListVO>();
	
	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String csrNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String functionalCurrency = null;
	/* Column Info */
	private String payIfSeq = null;
	/* Column Info */
	private String datRsltFlg = null;
	/* Column Info */
	private String vendorInvNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public APIFPaymentProcessListVO() {}

	public APIFPaymentProcessListVO(String ibflag, String pagerows, String csrNo, String vendorInvNo, String payDt, String payIfSeq, String functionalCurrency, String datRsltFlg) {
		this.payDt = payDt;
		this.csrNo = csrNo;
		this.ibflag = ibflag;
		this.functionalCurrency = functionalCurrency;
		this.payIfSeq = payIfSeq;
		this.datRsltFlg = datRsltFlg;
		this.vendorInvNo = vendorInvNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("functional_currency", getFunctionalCurrency());
		this.hashColumns.put("pay_if_seq", getPayIfSeq());
		this.hashColumns.put("dat_rslt_flg", getDatRsltFlg());
		this.hashColumns.put("vendor_inv_no", getVendorInvNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("functional_currency", "functionalCurrency");
		this.hashFields.put("pay_if_seq", "payIfSeq");
		this.hashFields.put("dat_rslt_flg", "datRsltFlg");
		this.hashFields.put("vendor_inv_no", "vendorInvNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return payDt
	 */
	public String getPayDt() {
		return this.payDt;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
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
	 * @return functionalCurrency
	 */
	public String getFunctionalCurrency() {
		return this.functionalCurrency;
	}
	
	/**
	 * Column Info
	 * @return payIfSeq
	 */
	public String getPayIfSeq() {
		return this.payIfSeq;
	}
	
	/**
	 * Column Info
	 * @return datRsltFlg
	 */
	public String getDatRsltFlg() {
		return this.datRsltFlg;
	}
	
	/**
	 * Column Info
	 * @return vendorInvNo
	 */
	public String getVendorInvNo() {
		return this.vendorInvNo;
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
	 * @param payDt
	 */
	public void setPayDt(String payDt) {
		this.payDt = payDt;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
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
	 * @param functionalCurrency
	 */
	public void setFunctionalCurrency(String functionalCurrency) {
		this.functionalCurrency = functionalCurrency;
	}
	
	/**
	 * Column Info
	 * @param payIfSeq
	 */
	public void setPayIfSeq(String payIfSeq) {
		this.payIfSeq = payIfSeq;
	}
	
	/**
	 * Column Info
	 * @param datRsltFlg
	 */
	public void setDatRsltFlg(String datRsltFlg) {
		this.datRsltFlg = datRsltFlg;
	}
	
	/**
	 * Column Info
	 * @param vendorInvNo
	 */
	public void setVendorInvNo(String vendorInvNo) {
		this.vendorInvNo = vendorInvNo;
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
		setPayDt(JSPUtil.getParameter(request, prefix + "pay_dt", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFunctionalCurrency(JSPUtil.getParameter(request, prefix + "functional_currency", ""));
		setPayIfSeq(JSPUtil.getParameter(request, prefix + "pay_if_seq", ""));
		setDatRsltFlg(JSPUtil.getParameter(request, prefix + "dat_rslt_flg", ""));
		setVendorInvNo(JSPUtil.getParameter(request, prefix + "vendor_inv_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return APIFPaymentProcessListVO[]
	 */
	public APIFPaymentProcessListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return APIFPaymentProcessListVO[]
	 */
	public APIFPaymentProcessListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		APIFPaymentProcessListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] functionalCurrency = (JSPUtil.getParameter(request, prefix	+ "functional_currency", length));
			String[] payIfSeq = (JSPUtil.getParameter(request, prefix	+ "pay_if_seq", length));
			String[] datRsltFlg = (JSPUtil.getParameter(request, prefix	+ "dat_rslt_flg", length));
			String[] vendorInvNo = (JSPUtil.getParameter(request, prefix	+ "vendor_inv_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new APIFPaymentProcessListVO();
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (functionalCurrency[i] != null)
					model.setFunctionalCurrency(functionalCurrency[i]);
				if (payIfSeq[i] != null)
					model.setPayIfSeq(payIfSeq[i]);
				if (datRsltFlg[i] != null)
					model.setDatRsltFlg(datRsltFlg[i]);
				if (vendorInvNo[i] != null)
					model.setVendorInvNo(vendorInvNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAPIFPaymentProcessListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return APIFPaymentProcessListVO[]
	 */
	public APIFPaymentProcessListVO[] getAPIFPaymentProcessListVOs(){
		APIFPaymentProcessListVO[] vos = (APIFPaymentProcessListVO[])models.toArray(new APIFPaymentProcessListVO[models.size()]);
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
		this.payDt = this.payDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.functionalCurrency = this.functionalCurrency .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payIfSeq = this.payIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.datRsltFlg = this.datRsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vendorInvNo = this.vendorInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
