/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderDetailResponse.java
*@FileTitle : WorkOrderDetail 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.common.document;

import java.util.Arrays;


/**
 * EXP_PAP_001Response 에 대한 WebService Document Object including Parameters<br>
 * - TrsSppIWSProxy의 Output Parameter<br>
 * - EXP_PAP_001EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class WorkOrderDetailResponse {
	/** (Header) */
	private String	id				= "WorkOrderDetailResponse";
	private String	status			= "";
	private int		count			= 0;
	private WorkOrderDetailTitle	workOrderDetailTitle	= null;
	private WorkOrderDetail	workOrderDetail	= null;
	private WorkOrderDetailList[]	workOrderDetailList	= null;
	
	/**
	 * @return count을 리턴합니다.
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count 설정하려는 count입니다.
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return id을 리턴합니다.
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id 설정하려는 id입니다.
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return status을 리턴합니다.
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status 설정하려는 status입니다.
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return workOrderDetail을 리턴합니다.
	 */
	public WorkOrderDetail getWorkOrderDetail() {
		return workOrderDetail;
	}
	/**
	 * @param workOrderDetail 설정하려는 workOrderDetail입니다.
	 */
	public void setWorkOrderDetail(WorkOrderDetail workOrderDetail) {
		this.workOrderDetail = workOrderDetail;
	}
	/**
	 * @return workOrderDetailList을 리턴합니다.
	 */
	public WorkOrderDetailList[] getWorkOrderDetailList() {
		WorkOrderDetailList[] rtnVOs = null;
		if (this.workOrderDetailList != null) {
			rtnVOs = Arrays.copyOf(this.workOrderDetailList, this.workOrderDetailList.length);
		} // end if
		return rtnVOs;
	}
	/**
	 * @param workOrderDetailList 설정하려는 workOrderDetailList입니다.
	 */
	public void setWorkOrderDetailList(WorkOrderDetailList[] workOrderDetailList) {
		if (workOrderDetailList != null) {
			WorkOrderDetailList[] tmpVOs = Arrays.copyOf(workOrderDetailList, workOrderDetailList.length);
			this.workOrderDetailList = tmpVOs;
		} // end if
	}
	/**
	 * @return workOrderDetailTitle을 리턴합니다.
	 */
	public WorkOrderDetailTitle getWorkOrderDetailTitle() {
		return workOrderDetailTitle;
	}
	/**
	 * @param workOrderDetailTitle 설정하려는 workOrderDetailTitle입니다.
	 */
	public void setWorkOrderDetailTitle(WorkOrderDetailTitle workOrderDetailTitle) {
		this.workOrderDetailTitle = workOrderDetailTitle;
	}



}
