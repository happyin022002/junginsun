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
 * EXP_PAP_007Response 에 대한 WebService Document Object including Parameters<br>
 * - TrsSppIWSProxy의 Output Parameter<br>
 * - EXP_PAP_007EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class WorkOrderDetailExcelUploadResponse {
	/** (Header) */
	private String	id				= "WorkOrderDetailExcelUploadResponse";
	private String	status			= "";
	private int		count			= 0;
	private WorkOrderDetailExcelUploadList[]	workOrderDetailExcelUploadList	= null;
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
	 * @return WorkOrderDetailExcelUploadList을 리턴합니다.
	 */
	public WorkOrderDetailExcelUploadList[] getWorkOrderDetailExcelUploadList() {
		WorkOrderDetailExcelUploadList[] rtnVOs = null;
		if (this.workOrderDetailExcelUploadList != null) {
			rtnVOs = Arrays.copyOf(this.workOrderDetailExcelUploadList, this.workOrderDetailExcelUploadList.length);
		} // end if
		return rtnVOs;
	}
	/**
	 * @param WorkOrderDetailExcelUploadList 설정하려는 WorkOrderDetailExcelUploadList입니다.
	 */
	public void setWorkOrderDetailExcelUploadList(
			WorkOrderDetailExcelUploadList[] WorkOrderDetailExcelUploadList) {
		if (WorkOrderDetailExcelUploadList != null) {
			WorkOrderDetailExcelUploadList[] tmpVOs = Arrays.copyOf(WorkOrderDetailExcelUploadList, WorkOrderDetailExcelUploadList.length);
			this.workOrderDetailExcelUploadList = tmpVOs;
		} // end if
	}
	
	

}
