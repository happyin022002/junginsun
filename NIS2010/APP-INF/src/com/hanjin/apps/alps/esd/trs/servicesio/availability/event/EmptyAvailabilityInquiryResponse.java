/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceNoticeInquiry.java
*@FileTitle : SPP TRS Response Value Object
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
*@LastModifyDate : 2006-12-28
*@LastModifier : sunghwan cho
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.availability.event;

import com.hanjin.apps.alps.esd.trs.servicesio.availability.event.EmptyAvailabilityInquiry;
import java.util.Arrays;

/**
 * Response Value Object<br>
 * - SPP TRS Response Value Object<br>
 * 
 * @author sunghwan cho
 * @see SPP_TRS_I10EventResponse,InvoiceNoticeBC 참조
 * @since J2EE 1.4
 */
public class EmptyAvailabilityInquiryResponse {
	private String id = "EmptyAvailabilityInquiryResponse";
	private String status = "";
	private int count = 0;
	private EmptyAvailabilityInquiry[] emptyAvailabilityInquiry = null;
	
	public EmptyAvailabilityInquiry[] getEmptyAvailabilityInquiry() {
		//return emptyAvailabilityInquiry;
		EmptyAvailabilityInquiry[] rtnList = null;
		if(this.emptyAvailabilityInquiry != null){
			rtnList = Arrays.copyOf(emptyAvailabilityInquiry, emptyAvailabilityInquiry.length);
		}
		return rtnList;	
	}
	public void setEmptyAvailabilityInquiry(EmptyAvailabilityInquiry[] emptyAvailabilityInquiry) {
		if(emptyAvailabilityInquiry != null){
			EmptyAvailabilityInquiry[] tmpList = Arrays.copyOf(emptyAvailabilityInquiry, emptyAvailabilityInquiry.length);
			this.emptyAvailabilityInquiry = tmpList;
		}
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
	
}
