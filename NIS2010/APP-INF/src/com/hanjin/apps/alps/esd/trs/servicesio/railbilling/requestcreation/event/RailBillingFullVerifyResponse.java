/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingFullVerifyResponse.java
*@FileTitle : Rail Billing Request Full Verify Info Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event;

import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.RailBillingIWSProxy;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.common.BasicResponse;

/**
 * WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy의 Output Parameter<br>
 * - EventResponse에서 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class RailBillingFullVerifyResponse extends BasicResponse {
	/** (Header) */
	private String	id				= "RailBillingFullVerifyResponse";
	private String	status			= null;
	
	/** (Param 객체) */
	private BookingDetail[] bookingDetailList;

	/**
	 * @return Returns the bookingDetailList.
	 */
	public BookingDetail[] getBookingDetailList() {
		return bookingDetailList;
	}

	/**
	 * @param bookingDetailList The bookingDetailList to set.
	 */
	public void setBookingDetailList(BookingDetail[] bookingDetailList) {
		this.bookingDetailList = bookingDetailList;
	}

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
