/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SendInvoiceEdiVO.java
*@FileTitle : SendInvoiceEdiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.15
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.04.15 조정민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo;

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
 * @author 조정민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SendInvoiceEdiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SendInvoiceEdiVO> models = new ArrayList<SendInvoiceEdiVO>();
	
	/* Column Info */
	private String amtTotal = null;
	/* Column Info */
	private String refRemark = null;
	/* Column Info */
	private String tel = null;
	/* Column Info */
	private String amtVat = null;
	/* Column Info */
	private String purpose = null;
	/* Column Info */
	private String remark1 = null;
	/* Column Info */
	private String btZip = null;
	/* Column Info */
	private String remark2 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sysDate = null;
	/* Column Info */
	private String amtNet = null;
	/* Column Info */
	private String description = null;
	/* Column Info */
	private String btName = null;
	/* Column Info */
	private String invno = null;
	/* Column Info */
	private String btState = null;
	/* Column Info */
	private String dueDate = null;
	/* Column Info */
	private String btCity = null;
	/* Column Info */
	private String fax = null;
	/* Column Info */
	private String btUsr1 = null;
	/* Column Info */
	private String issueDate = null;
	/* Column Info */
	private String issueOffice = null;
	/* Column Info */
	private String amtDeduct = null;
	/* Column Info */
	private String address = null;
	/* Column Info */
	private String btUsr2 = null;
	/* Column Info */
	private String company = null;
	/* Column Info */
	private String custCode = null;
	/* Column Info */
	private String cur = null;
	/* Column Info */
	private String tpbno = null;
	/* Column Info */
	private String amtAdmin = null;
	/* Column Info */
	private String btAddress = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SendInvoiceEdiVO() {}

	public SendInvoiceEdiVO(String ibflag, String pagerows, String sysDate, String purpose, String tpbno, String invno, String company, String address, String tel, String fax, String btUsr1, String btName, String btAddress, String btCity, String btState, String btZip, String btUsr2, String issueDate, String issueOffice, String dueDate, String custCode, String refRemark, String cur, String amtNet, String amtAdmin, String amtDeduct, String amtVat, String amtTotal, String description, String remark1, String remark2) {
		this.amtTotal = amtTotal;
		this.refRemark = refRemark;
		this.tel = tel;
		this.amtVat = amtVat;
		this.purpose = purpose;
		this.remark1 = remark1;
		this.btZip = btZip;
		this.remark2 = remark2;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.sysDate = sysDate;
		this.amtNet = amtNet;
		this.description = description;
		this.btName = btName;
		this.invno = invno;
		this.btState = btState;
		this.dueDate = dueDate;
		this.btCity = btCity;
		this.fax = fax;
		this.btUsr1 = btUsr1;
		this.issueDate = issueDate;
		this.issueOffice = issueOffice;
		this.amtDeduct = amtDeduct;
		this.address = address;
		this.btUsr2 = btUsr2;
		this.company = company;
		this.custCode = custCode;
		this.cur = cur;
		this.tpbno = tpbno;
		this.amtAdmin = amtAdmin;
		this.btAddress = btAddress;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("amt_total", getAmtTotal());
		this.hashColumns.put("ref_remark", getRefRemark());
		this.hashColumns.put("tel", getTel());
		this.hashColumns.put("amt_vat", getAmtVat());
		this.hashColumns.put("purpose", getPurpose());
		this.hashColumns.put("remark1", getRemark1());
		this.hashColumns.put("bt_zip", getBtZip());
		this.hashColumns.put("remark2", getRemark2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sys_date", getSysDate());
		this.hashColumns.put("amt_net", getAmtNet());
		this.hashColumns.put("description", getDescription());
		this.hashColumns.put("bt_name", getBtName());
		this.hashColumns.put("invno", getInvno());
		this.hashColumns.put("bt_state", getBtState());
		this.hashColumns.put("due_date", getDueDate());
		this.hashColumns.put("bt_city", getBtCity());
		this.hashColumns.put("fax", getFax());
		this.hashColumns.put("bt_usr1", getBtUsr1());
		this.hashColumns.put("issue_date", getIssueDate());
		this.hashColumns.put("issue_office", getIssueOffice());
		this.hashColumns.put("amt_deduct", getAmtDeduct());
		this.hashColumns.put("address", getAddress());
		this.hashColumns.put("bt_usr2", getBtUsr2());
		this.hashColumns.put("company", getCompany());
		this.hashColumns.put("cust_code", getCustCode());
		this.hashColumns.put("cur", getCur());
		this.hashColumns.put("tpbno", getTpbno());
		this.hashColumns.put("amt_admin", getAmtAdmin());
		this.hashColumns.put("bt_address", getBtAddress());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("amt_total", "amtTotal");
		this.hashFields.put("ref_remark", "refRemark");
		this.hashFields.put("tel", "tel");
		this.hashFields.put("amt_vat", "amtVat");
		this.hashFields.put("purpose", "purpose");
		this.hashFields.put("remark1", "remark1");
		this.hashFields.put("bt_zip", "btZip");
		this.hashFields.put("remark2", "remark2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sys_date", "sysDate");
		this.hashFields.put("amt_net", "amtNet");
		this.hashFields.put("description", "description");
		this.hashFields.put("bt_name", "btName");
		this.hashFields.put("invno", "invno");
		this.hashFields.put("bt_state", "btState");
		this.hashFields.put("due_date", "dueDate");
		this.hashFields.put("bt_city", "btCity");
		this.hashFields.put("fax", "fax");
		this.hashFields.put("bt_usr1", "btUsr1");
		this.hashFields.put("issue_date", "issueDate");
		this.hashFields.put("issue_office", "issueOffice");
		this.hashFields.put("amt_deduct", "amtDeduct");
		this.hashFields.put("address", "address");
		this.hashFields.put("bt_usr2", "btUsr2");
		this.hashFields.put("company", "company");
		this.hashFields.put("cust_code", "custCode");
		this.hashFields.put("cur", "cur");
		this.hashFields.put("tpbno", "tpbno");
		this.hashFields.put("amt_admin", "amtAdmin");
		this.hashFields.put("bt_address", "btAddress");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return amtTotal
	 */
	public String getAmtTotal() {
		return this.amtTotal;
	}
	
	/**
	 * Column Info
	 * @return refRemark
	 */
	public String getRefRemark() {
		return this.refRemark;
	}
	
	/**
	 * Column Info
	 * @return tel
	 */
	public String getTel() {
		return this.tel;
	}
	
	/**
	 * Column Info
	 * @return amtVat
	 */
	public String getAmtVat() {
		return this.amtVat;
	}
	
	/**
	 * Column Info
	 * @return purpose
	 */
	public String getPurpose() {
		return this.purpose;
	}
	
	/**
	 * Column Info
	 * @return remark1
	 */
	public String getRemark1() {
		return this.remark1;
	}
	
	/**
	 * Column Info
	 * @return btZip
	 */
	public String getBtZip() {
		return this.btZip;
	}
	
	/**
	 * Column Info
	 * @return remark2
	 */
	public String getRemark2() {
		return this.remark2;
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
	 * @return sysDate
	 */
	public String getSysDate() {
		return this.sysDate;
	}
	
	/**
	 * Column Info
	 * @return amtNet
	 */
	public String getAmtNet() {
		return this.amtNet;
	}
	
	/**
	 * Column Info
	 * @return description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Column Info
	 * @return btName
	 */
	public String getBtName() {
		return this.btName;
	}
	
	/**
	 * Column Info
	 * @return invno
	 */
	public String getInvno() {
		return this.invno;
	}
	
	/**
	 * Column Info
	 * @return btState
	 */
	public String getBtState() {
		return this.btState;
	}
	
	/**
	 * Column Info
	 * @return dueDate
	 */
	public String getDueDate() {
		return this.dueDate;
	}
	
	/**
	 * Column Info
	 * @return btCity
	 */
	public String getBtCity() {
		return this.btCity;
	}
	
	/**
	 * Column Info
	 * @return fax
	 */
	public String getFax() {
		return this.fax;
	}
	
	/**
	 * Column Info
	 * @return btUsr1
	 */
	public String getBtUsr1() {
		return this.btUsr1;
	}
	
	/**
	 * Column Info
	 * @return issueDate
	 */
	public String getIssueDate() {
		return this.issueDate;
	}
	
	/**
	 * Column Info
	 * @return issueOffice
	 */
	public String getIssueOffice() {
		return this.issueOffice;
	}
	
	/**
	 * Column Info
	 * @return amtDeduct
	 */
	public String getAmtDeduct() {
		return this.amtDeduct;
	}
	
	/**
	 * Column Info
	 * @return address
	 */
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * Column Info
	 * @return btUsr2
	 */
	public String getBtUsr2() {
		return this.btUsr2;
	}
	
	/**
	 * Column Info
	 * @return company
	 */
	public String getCompany() {
		return this.company;
	}
	
	/**
	 * Column Info
	 * @return custCode
	 */
	public String getCustCode() {
		return this.custCode;
	}
	
	/**
	 * Column Info
	 * @return cur
	 */
	public String getCur() {
		return this.cur;
	}
	
	/**
	 * Column Info
	 * @return tpbno
	 */
	public String getTpbno() {
		return this.tpbno;
	}
	
	/**
	 * Column Info
	 * @return amtAdmin
	 */
	public String getAmtAdmin() {
		return this.amtAdmin;
	}
	
	/**
	 * Column Info
	 * @return btAddress
	 */
	public String getBtAddress() {
		return this.btAddress;
	}
	

	/**
	 * Column Info
	 * @param amtTotal
	 */
	public void setAmtTotal(String amtTotal) {
		this.amtTotal = amtTotal;
	}
	
	/**
	 * Column Info
	 * @param refRemark
	 */
	public void setRefRemark(String refRemark) {
		this.refRemark = refRemark;
	}
	
	/**
	 * Column Info
	 * @param tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	/**
	 * Column Info
	 * @param amtVat
	 */
	public void setAmtVat(String amtVat) {
		this.amtVat = amtVat;
	}
	
	/**
	 * Column Info
	 * @param purpose
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	/**
	 * Column Info
	 * @param remark1
	 */
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	
	/**
	 * Column Info
	 * @param btZip
	 */
	public void setBtZip(String btZip) {
		this.btZip = btZip;
	}
	
	/**
	 * Column Info
	 * @param remark2
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
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
	 * @param sysDate
	 */
	public void setSysDate(String sysDate) {
		this.sysDate = sysDate;
	}
	
	/**
	 * Column Info
	 * @param amtNet
	 */
	public void setAmtNet(String amtNet) {
		this.amtNet = amtNet;
	}
	
	/**
	 * Column Info
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Column Info
	 * @param btName
	 */
	public void setBtName(String btName) {
		this.btName = btName;
	}
	
	/**
	 * Column Info
	 * @param invno
	 */
	public void setInvno(String invno) {
		this.invno = invno;
	}
	
	/**
	 * Column Info
	 * @param btState
	 */
	public void setBtState(String btState) {
		this.btState = btState;
	}
	
	/**
	 * Column Info
	 * @param dueDate
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	/**
	 * Column Info
	 * @param btCity
	 */
	public void setBtCity(String btCity) {
		this.btCity = btCity;
	}
	
	/**
	 * Column Info
	 * @param fax
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	/**
	 * Column Info
	 * @param btUsr1
	 */
	public void setBtUsr1(String btUsr1) {
		this.btUsr1 = btUsr1;
	}
	
	/**
	 * Column Info
	 * @param issueDate
	 */
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	
	/**
	 * Column Info
	 * @param issueOffice
	 */
	public void setIssueOffice(String issueOffice) {
		this.issueOffice = issueOffice;
	}
	
	/**
	 * Column Info
	 * @param amtDeduct
	 */
	public void setAmtDeduct(String amtDeduct) {
		this.amtDeduct = amtDeduct;
	}
	
	/**
	 * Column Info
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Column Info
	 * @param btUsr2
	 */
	public void setBtUsr2(String btUsr2) {
		this.btUsr2 = btUsr2;
	}
	
	/**
	 * Column Info
	 * @param company
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	/**
	 * Column Info
	 * @param custCode
	 */
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	
	/**
	 * Column Info
	 * @param cur
	 */
	public void setCur(String cur) {
		this.cur = cur;
	}
	
	/**
	 * Column Info
	 * @param tpbno
	 */
	public void setTpbno(String tpbno) {
		this.tpbno = tpbno;
	}
	
	/**
	 * Column Info
	 * @param amtAdmin
	 */
	public void setAmtAdmin(String amtAdmin) {
		this.amtAdmin = amtAdmin;
	}
	
	/**
	 * Column Info
	 * @param btAddress
	 */
	public void setBtAddress(String btAddress) {
		this.btAddress = btAddress;
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
		setAmtTotal(JSPUtil.getParameter(request, prefix + "amt_total", ""));
		setRefRemark(JSPUtil.getParameter(request, prefix + "ref_remark", ""));
		setTel(JSPUtil.getParameter(request, prefix + "tel", ""));
		setAmtVat(JSPUtil.getParameter(request, prefix + "amt_vat", ""));
		setPurpose(JSPUtil.getParameter(request, prefix + "purpose", ""));
		setRemark1(JSPUtil.getParameter(request, prefix + "remark1", ""));
		setBtZip(JSPUtil.getParameter(request, prefix + "bt_zip", ""));
		setRemark2(JSPUtil.getParameter(request, prefix + "remark2", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSysDate(JSPUtil.getParameter(request, prefix + "sys_date", ""));
		setAmtNet(JSPUtil.getParameter(request, prefix + "amt_net", ""));
		setDescription(JSPUtil.getParameter(request, prefix + "description", ""));
		setBtName(JSPUtil.getParameter(request, prefix + "bt_name", ""));
		setInvno(JSPUtil.getParameter(request, prefix + "invno", ""));
		setBtState(JSPUtil.getParameter(request, prefix + "bt_state", ""));
		setDueDate(JSPUtil.getParameter(request, prefix + "due_date", ""));
		setBtCity(JSPUtil.getParameter(request, prefix + "bt_city", ""));
		setFax(JSPUtil.getParameter(request, prefix + "fax", ""));
		setBtUsr1(JSPUtil.getParameter(request, prefix + "bt_usr1", ""));
		setIssueDate(JSPUtil.getParameter(request, prefix + "issue_date", ""));
		setIssueOffice(JSPUtil.getParameter(request, prefix + "issue_office", ""));
		setAmtDeduct(JSPUtil.getParameter(request, prefix + "amt_deduct", ""));
		setAddress(JSPUtil.getParameter(request, prefix + "address", ""));
		setBtUsr2(JSPUtil.getParameter(request, prefix + "bt_usr2", ""));
		setCompany(JSPUtil.getParameter(request, prefix + "company", ""));
		setCustCode(JSPUtil.getParameter(request, prefix + "cust_code", ""));
		setCur(JSPUtil.getParameter(request, prefix + "cur", ""));
		setTpbno(JSPUtil.getParameter(request, prefix + "tpbno", ""));
		setAmtAdmin(JSPUtil.getParameter(request, prefix + "amt_admin", ""));
		setBtAddress(JSPUtil.getParameter(request, prefix + "bt_address", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SendInvoiceEdiVO[]
	 */
	public SendInvoiceEdiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SendInvoiceEdiVO[]
	 */
	public SendInvoiceEdiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SendInvoiceEdiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] amtTotal = (JSPUtil.getParameter(request, prefix	+ "amt_total", length));
			String[] refRemark = (JSPUtil.getParameter(request, prefix	+ "ref_remark", length));
			String[] tel = (JSPUtil.getParameter(request, prefix	+ "tel", length));
			String[] amtVat = (JSPUtil.getParameter(request, prefix	+ "amt_vat", length));
			String[] purpose = (JSPUtil.getParameter(request, prefix	+ "purpose", length));
			String[] remark1 = (JSPUtil.getParameter(request, prefix	+ "remark1", length));
			String[] btZip = (JSPUtil.getParameter(request, prefix	+ "bt_zip", length));
			String[] remark2 = (JSPUtil.getParameter(request, prefix	+ "remark2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sysDate = (JSPUtil.getParameter(request, prefix	+ "sys_date", length));
			String[] amtNet = (JSPUtil.getParameter(request, prefix	+ "amt_net", length));
			String[] description = (JSPUtil.getParameter(request, prefix	+ "description", length));
			String[] btName = (JSPUtil.getParameter(request, prefix	+ "bt_name", length));
			String[] invno = (JSPUtil.getParameter(request, prefix	+ "invno", length));
			String[] btState = (JSPUtil.getParameter(request, prefix	+ "bt_state", length));
			String[] dueDate = (JSPUtil.getParameter(request, prefix	+ "due_date", length));
			String[] btCity = (JSPUtil.getParameter(request, prefix	+ "bt_city", length));
			String[] fax = (JSPUtil.getParameter(request, prefix	+ "fax", length));
			String[] btUsr1 = (JSPUtil.getParameter(request, prefix	+ "bt_usr1", length));
			String[] issueDate = (JSPUtil.getParameter(request, prefix	+ "issue_date", length));
			String[] issueOffice = (JSPUtil.getParameter(request, prefix	+ "issue_office", length));
			String[] amtDeduct = (JSPUtil.getParameter(request, prefix	+ "amt_deduct", length));
			String[] address = (JSPUtil.getParameter(request, prefix	+ "address", length));
			String[] btUsr2 = (JSPUtil.getParameter(request, prefix	+ "bt_usr2", length));
			String[] company = (JSPUtil.getParameter(request, prefix	+ "company", length));
			String[] custCode = (JSPUtil.getParameter(request, prefix	+ "cust_code", length));
			String[] cur = (JSPUtil.getParameter(request, prefix	+ "cur", length));
			String[] tpbno = (JSPUtil.getParameter(request, prefix	+ "tpbno", length));
			String[] amtAdmin = (JSPUtil.getParameter(request, prefix	+ "amt_admin", length));
			String[] btAddress = (JSPUtil.getParameter(request, prefix	+ "bt_address", length));
			
			for (int i = 0; i < length; i++) {
				model = new SendInvoiceEdiVO();
				if (amtTotal[i] != null)
					model.setAmtTotal(amtTotal[i]);
				if (refRemark[i] != null)
					model.setRefRemark(refRemark[i]);
				if (tel[i] != null)
					model.setTel(tel[i]);
				if (amtVat[i] != null)
					model.setAmtVat(amtVat[i]);
				if (purpose[i] != null)
					model.setPurpose(purpose[i]);
				if (remark1[i] != null)
					model.setRemark1(remark1[i]);
				if (btZip[i] != null)
					model.setBtZip(btZip[i]);
				if (remark2[i] != null)
					model.setRemark2(remark2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sysDate[i] != null)
					model.setSysDate(sysDate[i]);
				if (amtNet[i] != null)
					model.setAmtNet(amtNet[i]);
				if (description[i] != null)
					model.setDescription(description[i]);
				if (btName[i] != null)
					model.setBtName(btName[i]);
				if (invno[i] != null)
					model.setInvno(invno[i]);
				if (btState[i] != null)
					model.setBtState(btState[i]);
				if (dueDate[i] != null)
					model.setDueDate(dueDate[i]);
				if (btCity[i] != null)
					model.setBtCity(btCity[i]);
				if (fax[i] != null)
					model.setFax(fax[i]);
				if (btUsr1[i] != null)
					model.setBtUsr1(btUsr1[i]);
				if (issueDate[i] != null)
					model.setIssueDate(issueDate[i]);
				if (issueOffice[i] != null)
					model.setIssueOffice(issueOffice[i]);
				if (amtDeduct[i] != null)
					model.setAmtDeduct(amtDeduct[i]);
				if (address[i] != null)
					model.setAddress(address[i]);
				if (btUsr2[i] != null)
					model.setBtUsr2(btUsr2[i]);
				if (company[i] != null)
					model.setCompany(company[i]);
				if (custCode[i] != null)
					model.setCustCode(custCode[i]);
				if (cur[i] != null)
					model.setCur(cur[i]);
				if (tpbno[i] != null)
					model.setTpbno(tpbno[i]);
				if (amtAdmin[i] != null)
					model.setAmtAdmin(amtAdmin[i]);
				if (btAddress[i] != null)
					model.setBtAddress(btAddress[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSendInvoiceEdiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SendInvoiceEdiVO[]
	 */
	public SendInvoiceEdiVO[] getSendInvoiceEdiVOs(){
		SendInvoiceEdiVO[] vos = (SendInvoiceEdiVO[])models.toArray(new SendInvoiceEdiVO[models.size()]);
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
		this.amtTotal = this.amtTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refRemark = this.refRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tel = this.tel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtVat = this.amtVat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.purpose = this.purpose .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark1 = this.remark1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btZip = this.btZip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark2 = this.remark2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysDate = this.sysDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtNet = this.amtNet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.description = this.description .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btName = this.btName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invno = this.invno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btState = this.btState .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDate = this.dueDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btCity = this.btCity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fax = this.fax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btUsr1 = this.btUsr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueDate = this.issueDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueOffice = this.issueOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtDeduct = this.amtDeduct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.address = this.address .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.btUsr2 = this.btUsr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company = this.company .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCode = this.custCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cur = this.cur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbno = this.tpbno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtAdmin = this.amtAdmin .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btAddress = this.btAddress .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
