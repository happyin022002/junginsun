/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TRSNoticeResponse.java
*@FileTitle : SPP TRS Response
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
*@LastModifyDate : 2006-12-28
*@LastModifier : sunghwan cho
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.common.event;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.event.InvoiceNoticeInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderMainList;
import java.util.Arrays;

/**
 * Response Value Object<br>
 * - SPP TRS Response<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class TRSNoticeResponse {
	private String status = "";
	private int count = 0;
	private int newWorkOrderCount = 0;
	private int pendingInvoiceCount = 0;
	private int railBilingAckCount = 0;
	private WorkOrderMainList[] workOrderData = null;
	private InvoiceNoticeInquiry[] noticeData = null;
	
	/**
	 * 
	 * @return
	 */
	public WorkOrderMainList[] getWorkOrderData() {
		WorkOrderMainList[] rtnList = null;
		if(this.workOrderData != null){
			rtnList = Arrays.copyOf(workOrderData, workOrderData.length);
		}
		return rtnList;
	}
	/**
	 * 
	 * @param workOrderData
	 */
	public void setWorkOrderData(WorkOrderMainList[] workOrderData) {
		if(workOrderData != null){
			WorkOrderMainList[] tmpList = Arrays.copyOf(workOrderData, workOrderData.length);
			this.workOrderData = tmpList;
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
	public int getNewWorkOrderCount() {
		return newWorkOrderCount;
	}
	/**
	 * 
	 * @param newWorkOrderCount
	 */
	public void setNewWorkOrderCount(int newWorkOrderCount) {
		this.newWorkOrderCount = newWorkOrderCount;
	}
	/**
	 * 
	 * @return
	 */
	public int getPendingInvoiceCount() {
		return pendingInvoiceCount;
	}
	/**
	 * 
	 * @param pendingInvoiceCount
	 */
	public void setPendingInvoiceCount(int pendingInvoiceCount) {
		this.pendingInvoiceCount = pendingInvoiceCount;
	}
	/**
	 * 
	 * @return
	 */
	public int getRailBilingAckCount() {
		return railBilingAckCount;
	}
	/**
	 * 
	 * @param railBilingAckCount
	 */
	public void setRailBilingAckCount(int railBilingAckCount) {
		this.railBilingAckCount = railBilingAckCount;
	}
	/**
	 * 
	 * @return
	 */
	public InvoiceNoticeInquiry[] getNoticeData() {
		InvoiceNoticeInquiry[] rtnList = null;
		if(this.noticeData != null){
			rtnList = Arrays.copyOf(noticeData, noticeData.length);
		}
		return rtnList;
	}
	/**
	 * 
	 * @param noticeData
	 */
	public void setNoticeData(InvoiceNoticeInquiry[] noticeData) {
		if(noticeData != null){
			InvoiceNoticeInquiry[] tmpList = Arrays.copyOf(noticeData, noticeData.length);
			this.noticeData = tmpList;
		}
	}
	
}
