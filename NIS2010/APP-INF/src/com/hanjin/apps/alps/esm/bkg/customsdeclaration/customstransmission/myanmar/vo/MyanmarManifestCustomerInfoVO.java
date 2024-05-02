/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MyanmarManifestCustomerInfoVO.java
*@FileTitle : MyanmarManifestCustomerInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.15  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.myanmar.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

public class MyanmarManifestCustomerInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MyanmarManifestCustomerInfoVO> models = new ArrayList<MyanmarManifestCustomerInfoVO>();
	
	/* Column Info */
	private String customerAddr3 = null;
	/* Column Info */
	private String customerType = null;
	/* Column Info */
	private String customerCd = null;
	/* Column Info */
	private String customerAddr1 = null;
	/* Column Info */
	private String customerAddr2 = null;
	/* Column Info */
	private String contactEmail = null;
	/* Column Info */
	private String contactFax = null;
	/* Column Info */
	private String contactTel = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String customerNm2 = null;
	/* Column Info */
	private String customerNm1 = null;
	/* Column Info */
	private String contactNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MyanmarManifestCustomerInfoVO() {}

	public MyanmarManifestCustomerInfoVO(String ibflag, String pagerows, String customerType, String customerCd, String customerNm1, String customerNm2, String customerAddr1, String customerAddr2, String customerAddr3, String contactNm, String contactTel, String contactFax, String contactEmail) {
		this.customerAddr3 = customerAddr3;
		this.customerType = customerType;
		this.customerCd = customerCd;
		this.customerAddr1 = customerAddr1;
		this.customerAddr2 = customerAddr2;
		this.contactEmail = contactEmail;
		this.contactFax = contactFax;
		this.contactTel = contactTel;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.customerNm2 = customerNm2;
		this.customerNm1 = customerNm1;
		this.contactNm = contactNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("customer_addr3", getCustomerAddr3());
		this.hashColumns.put("customer_type", getCustomerType());
		this.hashColumns.put("customer_cd", getCustomerCd());
		this.hashColumns.put("customer_addr1", getCustomerAddr1());
		this.hashColumns.put("customer_addr2", getCustomerAddr2());
		this.hashColumns.put("contact_email", getContactEmail());
		this.hashColumns.put("contact_fax", getContactFax());
		this.hashColumns.put("contact_tel", getContactTel());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("customer_nm2", getCustomerNm2());
		this.hashColumns.put("customer_nm1", getCustomerNm1());
		this.hashColumns.put("contact_nm", getContactNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("customer_addr3", "customerAddr3");
		this.hashFields.put("customer_type", "customerType");
		this.hashFields.put("customer_cd", "customerCd");
		this.hashFields.put("customer_addr1", "customerAddr1");
		this.hashFields.put("customer_addr2", "customerAddr2");
		this.hashFields.put("contact_email", "contactEmail");
		this.hashFields.put("contact_fax", "contactFax");
		this.hashFields.put("contact_tel", "contactTel");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("customer_nm2", "customerNm2");
		this.hashFields.put("customer_nm1", "customerNm1");
		this.hashFields.put("contact_nm", "contactNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return customerAddr3
	 */
	public String getCustomerAddr3() {
		return this.customerAddr3;
	}
	
	/**
	 * Column Info
	 * @return customerType
	 */
	public String getCustomerType() {
		return this.customerType;
	}
	
	/**
	 * Column Info
	 * @return customerCd
	 */
	public String getCustomerCd() {
		return this.customerCd;
	}
	
	/**
	 * Column Info
	 * @return customerAddr1
	 */
	public String getCustomerAddr1() {
		return this.customerAddr1;
	}
	
	/**
	 * Column Info
	 * @return customerAddr2
	 */
	public String getCustomerAddr2() {
		return this.customerAddr2;
	}
	
	/**
	 * Column Info
	 * @return contactEmail
	 */
	public String getContactEmail() {
		return this.contactEmail;
	}
	
	/**
	 * Column Info
	 * @return contactFax
	 */
	public String getContactFax() {
		return this.contactFax;
	}
	
	/**
	 * Column Info
	 * @return contactTel
	 */
	public String getContactTel() {
		return this.contactTel;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return customerNm2
	 */
	public String getCustomerNm2() {
		return this.customerNm2;
	}
	
	/**
	 * Column Info
	 * @return customerNm1
	 */
	public String getCustomerNm1() {
		return this.customerNm1;
	}
	
	/**
	 * Column Info
	 * @return contactNm
	 */
	public String getContactNm() {
		return this.contactNm;
	}
	

	/**
	 * Column Info
	 * @param customerAddr3
	 */
	public void setCustomerAddr3(String customerAddr3) {
		this.customerAddr3 = customerAddr3;
	}
	
	/**
	 * Column Info
	 * @param customerType
	 */
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	
	/**
	 * Column Info
	 * @param customerCd
	 */
	public void setCustomerCd(String customerCd) {
		this.customerCd = customerCd;
	}
	
	/**
	 * Column Info
	 * @param customerAddr1
	 */
	public void setCustomerAddr1(String customerAddr1) {
		this.customerAddr1 = customerAddr1;
	}
	
	/**
	 * Column Info
	 * @param customerAddr2
	 */
	public void setCustomerAddr2(String customerAddr2) {
		this.customerAddr2 = customerAddr2;
	}
	
	/**
	 * Column Info
	 * @param contactEmail
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	
	/**
	 * Column Info
	 * @param contactFax
	 */
	public void setContactFax(String contactFax) {
		this.contactFax = contactFax;
	}
	
	/**
	 * Column Info
	 * @param contactTel
	 */
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param customerNm2
	 */
	public void setCustomerNm2(String customerNm2) {
		this.customerNm2 = customerNm2;
	}
	
	/**
	 * Column Info
	 * @param customerNm1
	 */
	public void setCustomerNm1(String customerNm1) {
		this.customerNm1 = customerNm1;
	}
	
	/**
	 * Column Info
	 * @param contactNm
	 */
	public void setContactNm(String contactNm) {
		this.contactNm = contactNm;
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
		setCustomerAddr3(JSPUtil.getParameter(request, prefix + "customer_addr3", ""));
		setCustomerType(JSPUtil.getParameter(request, prefix + "customer_type", ""));
		setCustomerCd(JSPUtil.getParameter(request, prefix + "customer_cd", ""));
		setCustomerAddr1(JSPUtil.getParameter(request, prefix + "customer_addr1", ""));
		setCustomerAddr2(JSPUtil.getParameter(request, prefix + "customer_addr2", ""));
		setContactEmail(JSPUtil.getParameter(request, prefix + "contact_email", ""));
		setContactFax(JSPUtil.getParameter(request, prefix + "contact_fax", ""));
		setContactTel(JSPUtil.getParameter(request, prefix + "contact_tel", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCustomerNm2(JSPUtil.getParameter(request, prefix + "customer_nm2", ""));
		setCustomerNm1(JSPUtil.getParameter(request, prefix + "customer_nm1", ""));
		setContactNm(JSPUtil.getParameter(request, prefix + "contact_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MyanmarManifestCustomerInfoVO[]
	 */
	public MyanmarManifestCustomerInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MyanmarManifestCustomerInfoVO[]
	 */
	public MyanmarManifestCustomerInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MyanmarManifestCustomerInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] customerAddr3 = (JSPUtil.getParameter(request, prefix	+ "customer_addr3", length));
			String[] customerType = (JSPUtil.getParameter(request, prefix	+ "customer_type", length));
			String[] customerCd = (JSPUtil.getParameter(request, prefix	+ "customer_cd", length));
			String[] customerAddr1 = (JSPUtil.getParameter(request, prefix	+ "customer_addr1", length));
			String[] customerAddr2 = (JSPUtil.getParameter(request, prefix	+ "customer_addr2", length));
			String[] contactEmail = (JSPUtil.getParameter(request, prefix	+ "contact_email", length));
			String[] contactFax = (JSPUtil.getParameter(request, prefix	+ "contact_fax", length));
			String[] contactTel = (JSPUtil.getParameter(request, prefix	+ "contact_tel", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] customerNm2 = (JSPUtil.getParameter(request, prefix	+ "customer_nm2", length));
			String[] customerNm1 = (JSPUtil.getParameter(request, prefix	+ "customer_nm1", length));
			String[] contactNm = (JSPUtil.getParameter(request, prefix	+ "contact_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new MyanmarManifestCustomerInfoVO();
				if (customerAddr3[i] != null)
					model.setCustomerAddr3(customerAddr3[i]);
				if (customerType[i] != null)
					model.setCustomerType(customerType[i]);
				if (customerCd[i] != null)
					model.setCustomerCd(customerCd[i]);
				if (customerAddr1[i] != null)
					model.setCustomerAddr1(customerAddr1[i]);
				if (customerAddr2[i] != null)
					model.setCustomerAddr2(customerAddr2[i]);
				if (contactEmail[i] != null)
					model.setContactEmail(contactEmail[i]);
				if (contactFax[i] != null)
					model.setContactFax(contactFax[i]);
				if (contactTel[i] != null)
					model.setContactTel(contactTel[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (customerNm2[i] != null)
					model.setCustomerNm2(customerNm2[i]);
				if (customerNm1[i] != null)
					model.setCustomerNm1(customerNm1[i]);
				if (contactNm[i] != null)
					model.setContactNm(contactNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMyanmarManifestCustomerInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MyanmarManifestCustomerInfoVO[]
	 */
	public MyanmarManifestCustomerInfoVO[] getMyanmarManifestCustomerInfoVOs(){
		MyanmarManifestCustomerInfoVO[] vos = (MyanmarManifestCustomerInfoVO[])models.toArray(new MyanmarManifestCustomerInfoVO[models.size()]);
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
		this.customerAddr3 = this.customerAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerType = this.customerType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerCd = this.customerCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerAddr1 = this.customerAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerAddr2 = this.customerAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contactEmail = this.contactEmail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contactFax = this.contactFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contactTel = this.contactTel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerNm2 = this.customerNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerNm1 = this.customerNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contactNm = this.contactNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
