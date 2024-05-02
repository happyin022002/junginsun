/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCreationDetailSubmitResponse.java
*@FileTitle : SPP TRS Invoice Creation Detail Response Value Object
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
*@LastModifyDate : 2006-12-28
*@LastModifier : sunghwan cho
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event;

import java.util.Arrays;

/**
 * SPP TRS Value Object<br>
 * - SPP TRS Invoice Creation Detail Response Value Object<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class MultiInvoiceCreationDetailSubmitResponse {
	private String id = "MultiInvoiceCreationDetailSubmitResponse";
	private String status = "";
	private String dlngDvsn = "";
	private String errInvNo[] = null;
	private String errWoNo[] = null;
	private int count = 0;
	
	/**
	 * 
	 * @return
	 */
	public int getCount() {
		return count;
	}
	/**
	 * 
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 
	 * @return
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return Returns the errInvNo.
	 */
	public String[] getErrInvNo() {
		String[] rtnList = null;
		if(this.errInvNo != null){
			rtnList = Arrays.copyOf(errInvNo, errInvNo.length);
		}
		return rtnList;
	}
	/**
	 * @param errInvNo The errInvNo to set.
	 */
	public void setErrInvNo(String[] errInvNo) {
		if(errInvNo != null){
			String[] tmpList = Arrays.copyOf(errInvNo, errInvNo.length);
			this.errInvNo = tmpList;
		}
	}
	/**
	 * @return Returns the errWoNo.
	 */
	public String[] getErrWoNo() {
		String[] rtnList = null;
		if(this.errWoNo != null){
			rtnList = Arrays.copyOf(errWoNo, errWoNo.length);
		}
		return rtnList;
	}
	/**
	 * @param errWoNo The errWoNo to set.
	 */
	public void setErrWoNo(String[] errWoNo) {
		if(errWoNo != null){
			String[] tmpList = Arrays.copyOf(errWoNo, errWoNo.length);
			this.errWoNo = tmpList;
		}
	}
	/**
	 * @return Returns the dlngDvsn.
	 */
	public String getDlngDvsn() {
		return dlngDvsn;
	}
	/**
	 * @param dlngDvsn The dlngDvsn to set.
	 */
	public void setDlngDvsn(String dlngDvsn) {
		this.dlngDvsn = dlngDvsn;
	}
}
