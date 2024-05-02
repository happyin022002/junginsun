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
package com.hanjin.apps.alps.esd.trs.servicesio.common.document;


import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetailExcelUploadList;
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
		WorkOrderDetailExcelUploadList[] rtnList = null;
		if(this.workOrderDetailExcelUploadList != null){
			rtnList = Arrays.copyOf(workOrderDetailExcelUploadList, workOrderDetailExcelUploadList.length);
		}
		return rtnList;
	}
	/**
	 * @param WorkOrderDetailExcelUploadList 설정하려는 WorkOrderDetailExcelUploadList입니다.
	 */
	public void setWorkOrderDetailExcelUploadList(WorkOrderDetailExcelUploadList[] workOrderDetailExcelUploadList) {
		if(workOrderDetailExcelUploadList != null){
			WorkOrderDetailExcelUploadList[] tmpList = Arrays.copyOf(workOrderDetailExcelUploadList, workOrderDetailExcelUploadList.length);
			this.workOrderDetailExcelUploadList = tmpList;
		}
	}
	
	

}
