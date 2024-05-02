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
import com.hanjin.framework.support.layer.event.EventResponseSupport;

/**
 * SPP TRS Value Object<br>
 * - SPP TRS 메인화면 Invoice Request Event<br>
 * 
 * @author sunghwan cho
 * @see SppTrsI10EventResponse,InvoiceNoticeBC 참조
 * @since J2EE 1.4
 */
public class SppTrsI04EventResponse extends EventResponseSupport {
	private static final long serialVersionUID = 1L;

	private String id = "SPP_TRS_I04EventResponse";
	private InvoiceSurchargeInquiry[] surchargeData = null;

	/**
	 * 
	 *
	 */
	public SppTrsI04EventResponse() {
	}
	/**
	 * 
	 * @param surchargeData
	 */
	public SppTrsI04EventResponse(InvoiceSurchargeInquiry[] surchargeData) {
		this.surchargeData = surchargeData;
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
	public InvoiceSurchargeInquiry[] getSurchargeData() {
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
	public void setSurchargeData(InvoiceSurchargeInquiry[] surchargeData) {
		if(surchargeData != null){
			InvoiceSurchargeInquiry[] tmpList = Arrays.copyOf(surchargeData, surchargeData.length);
			this.surchargeData = tmpList;
		}
	}

}