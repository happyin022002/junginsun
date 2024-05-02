/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SppTrsI10Event.java
*@FileTitle : SPP TRS 메인화면 Invoice Request Event 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-28
*@LastModifier : sunghwan cho
*@LastVersion : 1.0
* 2006-12-28 sunghwan cho
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.event.InvoiceSurchargeInquiry;

/**
 * SPP TRS Value Object<br>
 * - SPP TRS 메인화면 Invoice Request Event<br>
 * 
 * @author sunghwan cho
 * @see SppTrsI10EventResponse,InvoiceNoticeBC 참조
 * @since J2EE 1.4
 */
public class InvoiceSurchargeInquiryResponse {
	private String id = "InvoiceSurchargeInquiryResponse";
	private String status = "";
	private int count = 0;
	private InvoiceSurchargeInquiry[] surchargeData = null;
	
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
	public InvoiceSurchargeInquiry[] getInvoiceData() {
		InvoiceSurchargeInquiry[] rtnList = null;
		if(this.surchargeData != null){
			rtnList = Arrays.copyOf(surchargeData, surchargeData.length);
		}
		return rtnList;
	}
	/**
	 * 
	 * @param surchargeData
	 */
	public void setInvoiceData(InvoiceSurchargeInquiry[] surchargeData) {
		if(surchargeData != null){
			InvoiceSurchargeInquiry[] tmpList = Arrays.copyOf(surchargeData, surchargeData.length);
			this.surchargeData = tmpList;
		}
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
}
