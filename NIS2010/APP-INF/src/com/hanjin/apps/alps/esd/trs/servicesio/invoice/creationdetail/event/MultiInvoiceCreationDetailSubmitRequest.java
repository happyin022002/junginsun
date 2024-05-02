/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCreationDetailSubmitRequest.java
*@FileTitle : SPP TRS Invoice Creation Submit Request Value Object
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-02-05 sunghwan cho : vendorPhoneNo 추가
* 2007-04-10 subghwan cho : parentVendorCode 추가
*@LastModifyDate : 2007-04-10
*@LastModifier : sunghwan cho
*@LastVersion : 1.2
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event;

import java.util.Arrays;


/**
 * Request Value Object<br>
 * - SPP TRS Invoice Creation Submit Request Value Object<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class MultiInvoiceCreationDetailSubmitRequest {
	private String id = "MultiInvoiceCreationDetailSubmitRequest";
	private String userID = "";
	private String vendorCode = "";
	private String vendorPhoneNo = "";
	private String parentVendorCode = "";
	private String invCode[] = null;
	MultiInvoiceCreationDetailList multiInvoiceCreationDetailList[] = null;
	
	/**
	 * 
	 */
	public String toString() {
		return id;
	}
	
	/**
	 * @return Returns the multiInvoiceCreationDetailList.
	 */
	public MultiInvoiceCreationDetailList[] getMultiInvoiceCreationDetailList() {
		return multiInvoiceCreationDetailList;
	}
	/**
	 * @param multiInvoiceCreationDetailList The multiInvoiceCreationDetailList to set.
	 */
	public void setMultiInvoiceCreationDetailList(MultiInvoiceCreationDetailList[] multiInvoiceCreationDetailList) {
		this.multiInvoiceCreationDetailList = multiInvoiceCreationDetailList;
	}
	/**
	 * @return Returns the parentVendorCode.
	 */
	public String getParentVendorCode() {
		return parentVendorCode;
	}
	/**
	 * @param parentVendorCode The parentVendorCode to set.
	 */
	public void setParentVendorCode(String parentVendorCode) {
		this.parentVendorCode = parentVendorCode;
	}
	/**
	 * @return Returns the userID.
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * @param userID The userID to set.
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	/**
	 * @return Returns the vendorCode.
	 */
	public String getVendorCode() {
		return vendorCode;
	}
	/**
	 * @param vendorCode The vendorCode to set.
	 */
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	/**
	 * @return Returns the vendorPhoneNo.
	 */
	public String getVendorPhoneNo() {
		return vendorPhoneNo;
	}
	/**
	 * @param vendorPhoneNo The vendorPhoneNo to set.
	 */
	public void setVendorPhoneNo(String vendorPhoneNo) {
		this.vendorPhoneNo = vendorPhoneNo;
	}
	/**
	 * @return Returns the id.
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return Returns the invCode.
	 */
	public String[] getInvCode() {
		String[] rtnList = null;
		if(this.invCode != null){
			rtnList = Arrays.copyOf(invCode, invCode.length);
		}
		return rtnList;
	}

	/**
	 * @param invCode The invCode to set.
	 */
	public void setInvCode(String[] invCode) {
		if(invCode != null){
			String[] tmpList = Arrays.copyOf(invCode, invCode.length);
			this.invCode = tmpList;
		}
	}

	/**
	 * @param id The id to set.
	 */
	public void setId(String id) {
		this.id = id;
	}
}
