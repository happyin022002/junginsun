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
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.saveequipment.event;

import com.hanjin.framework.support.layer.event.EventResponseSupport;

/**
 * SPP TRS Value Object<br>
 * - SPP TRS 메인화면 Invoice Request Event<br>
 * 
 * @author sunghwan cho
 * @see SppTrsI10EventResponse,InvoiceNoticeBC 참조
 * @since J2EE 1.4
 */
public class SppTrsI03EventResponse extends EventResponseSupport {
	private static final long serialVersionUID = 1L;
	
	private String id = "SppTrsI03EventResponse";
	private String status = "";
	private int count = 0;
	
	/**
	 * 
	 *
	 */
	public SppTrsI03EventResponse() {
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