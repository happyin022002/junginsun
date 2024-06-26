/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingInquiryExcelResponse.java
*@FileTitle : Rail Billing Inquiry Excel Response
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.inquiry.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.trs.servicesio.railbilling.RailBillingIWSProxy;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.common.BasicResponse;

/**
 * WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy의 Output Parameter<br>
 * - EventResponse에서 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class RailBillingInquiryExcelResponse extends BasicResponse {
	/** (Header) */
	private String	id				= "RailBillingInquiryExcelResponse";
	private String	status			= null;
	
	/** (Param 객체) */
	private RailBillingInquiry[] railBillingInquiryList;

	/**
	 * @return Returns the id.
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id The id to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return Returns the railBillingInquiryList.
	 */
	public RailBillingInquiry[] getRailBillingInquiryList() {
		RailBillingInquiry[] rtnList = null;
		if(this.railBillingInquiryList != null){
			rtnList = Arrays.copyOf(railBillingInquiryList, railBillingInquiryList.length);
		}
		return rtnList;
	}

	/**
	 * @param railBillingInquiryList The railBillingInquiryList to set.
	 */
	public void setRailBillingInquiryList(RailBillingInquiry[] railBillingInquiryList) {
		if(railBillingInquiryList != null){
			RailBillingInquiry[] tmpList = Arrays.copyOf(railBillingInquiryList, railBillingInquiryList.length);
			this.railBillingInquiryList = tmpList;
		}
	}

	/**
	 * @return Returns the status.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status The status to set.
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
