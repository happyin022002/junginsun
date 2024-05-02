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
package com.clt.apps.opus.esd.trs.servicesio.common.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.trs.servicesio.common.document.WorkOrderMainList;

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
	
	/**
	 * 
	 * @return
	 */
	public WorkOrderMainList[] getWorkOrderData() {
		WorkOrderMainList[] rtnVOs = null;
		if (this.workOrderData != null) {
			rtnVOs = Arrays.copyOf(this.workOrderData, this.workOrderData.length);
		} // end if
		return rtnVOs;
	}
	/**
	 * 
	 * @param workOrderData
	 */
	public void setWorkOrderData(WorkOrderMainList[] workOrderData) {
		if (workOrderData != null) {
			WorkOrderMainList[] tmpVOs = Arrays.copyOf(workOrderData, workOrderData.length);
			this.workOrderData = tmpVOs;
		} // end if
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

	
}
