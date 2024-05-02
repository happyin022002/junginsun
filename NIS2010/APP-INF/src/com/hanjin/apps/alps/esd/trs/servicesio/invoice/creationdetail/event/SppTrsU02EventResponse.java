/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SppTrsU02EventResponse.java
*@FileTitle : SPP TRS Invoice Event Value Object
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
*@LastModifyDate : 2006-12-28
*@LastModifier : sunghwan cho
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventResponseSupport;

/**
 * SPP TRS Value Object<br>
 * - SPP TRS Invoice Event Value Object<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class SppTrsU02EventResponse extends EventResponseSupport {
	static final long serialVersionUID = 1L; 
	
	private String id = "SppTrsU02EventResponse";
	private int count = 0;
	private String errWorkOrderNo[] = null;
	private String errInvoiceNo[] = null;
	
	/**
	 * @return Returns the errInvoiceNo.
	 */
	public String[] getErrInvoiceNo() {
		String[] rtnList = null;
		if(this.errInvoiceNo != null){
			rtnList = Arrays.copyOf(errInvoiceNo, errInvoiceNo.length);
		}
		return rtnList;
	}
	/**
	 * @param errInvoiceNo The errInvoiceNo to set.
	 */
	public void setErrInvoiceNo(String[] errInvoiceNo) {
		if(errInvoiceNo != null){
			String[] tmpList = Arrays.copyOf(errInvoiceNo, errInvoiceNo.length);
			this.errInvoiceNo = tmpList;
		}
	}
	/**
	 * @return Returns the errWorkOrderNo.
	 */
	public String[] getErrWorkOrderNo() {
		String[] rtnList = null;
		if(this.errWorkOrderNo != null){
			rtnList = Arrays.copyOf(errWorkOrderNo, errWorkOrderNo.length);
		}
		return rtnList;
	}
	/**
	 * @param errWorkOrderNo The errWorkOrderNo to set.
	 */
	public void setErrWorkOrderNo(String[] errWorkOrderNo) {
		if(errWorkOrderNo != null){
			String[] tmpList = Arrays.copyOf(errWorkOrderNo, errWorkOrderNo.length);
			this.errWorkOrderNo = tmpList;
		}
	}
	/**
	 * 
	 *
	 */
	public SppTrsU02EventResponse() {
	}
	/**
	 * 
	 */
	public String toString() {
		return id;
	}
	/**
	 * 
	 */
	public String getEventName() {
		return id;
	}
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

}