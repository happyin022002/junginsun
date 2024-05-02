/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingFullExcelResponse.java
*@FileTitle : Rail Billing Request Full Excel Info Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event;

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
public class RailBillingFullExcelResponse extends BasicResponse {
	/** (Header) */
	
	private String	id				= "RailBillingFullExcelResponse";
	private String	status			= null;
	
	/** (Param 객체) */
	private BookingDetail[] bookingDetailList;
	
	/**
	 * @return Returns the bookingDetailList.
	 */
	public BookingDetail[] getBookingDetailList() {
		BookingDetail[] rtnList = null;
		if(this.bookingDetailList != null){
			rtnList = Arrays.copyOf(bookingDetailList, bookingDetailList.length);
		}
		return rtnList;
	}
	/**
	 * @param bookingDetailList The bookingDetailList to set.
	 */
	public void setBookingDetailList(BookingDetail[] bookingDetailList) {
		if(bookingDetailList != null){
			BookingDetail[] tmpList = Arrays.copyOf(bookingDetailList, bookingDetailList.length);
			this.bookingDetailList = tmpList;
		}
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
