/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderDetailUpdate
*@FileTitle	: WorkOrderDetailUpdate
*Open Issues :
*Change	history	:
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion :	1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package	com.clt.apps.opus.esd.trs.servicesio.common.document;

import java.util.Arrays;

/**
 * EXP_PAP_002 에 대한 WebService Document Object including	Parameters<br>
 * - TrsSppIWSProxy의 Input	Parameter<br>
 * - EXP_PAP_002Event로	변환하여 사용<br>
 *
 * @author doomi
 * @see	TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class WorkOrderDetailUpdate { 
	
	//private String id = "WorkOrderDetailUpdate";
	
	private String workOrderNo					= "";
	private String userID = "";
	private String vendorCode = "";
	private String submitMode = "";
	private WorkOrderDetailSubmitRejectList[] workOrderDetailSubmitRejectList = null;

	
	/**
	 * @return submitMode을 리턴합니다.
	 */
	public String getSubmitMode() {
		return submitMode;
	}
	/**
	 * @param submitMode 설정하려는 submitMode입니다.
	 */
	public void setSubmitMode(String submitMode) {
		this.submitMode = submitMode;
	}
	/**
	 * @return userID을 리턴합니다.
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * @param userID 설정하려는 userID입니다.
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	/**
	 * @return vendorCode을 리턴합니다.
	 */
	public String getVendorCode() {
		return vendorCode;
	}
	/**
	 * @param vendorCode 설정하려는 vendorCode입니다.
	 */
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	/**
	 * @return workOrderDetailSubmitRejectList을 리턴합니다.
	 */
	public WorkOrderDetailSubmitRejectList[] getWorkOrderDetailSubmitRejectList() {
		WorkOrderDetailSubmitRejectList[] rtnVOs = null;
		if (this.workOrderDetailSubmitRejectList != null) {
			rtnVOs = Arrays.copyOf(this.workOrderDetailSubmitRejectList, this.workOrderDetailSubmitRejectList.length);
		} // end if
		return rtnVOs;
	}
	/**
	 * @param workOrderDetailSubmitRejectList 설정하려는 workOrderDetailSubmitRejectList입니다.
	 */
	public void setWorkOrderDetailSubmitRejectList(
			WorkOrderDetailSubmitRejectList[] workOrderDetailSubmitRejectList) {
		if (workOrderDetailSubmitRejectList != null) {
			WorkOrderDetailSubmitRejectList[] tmpVOs = Arrays.copyOf(workOrderDetailSubmitRejectList, workOrderDetailSubmitRejectList.length);
			this.workOrderDetailSubmitRejectList = tmpVOs;
		} // end if
	}
	/**
	 * @return workOrderNo을 리턴합니다.
	 */
	public String getWorkOrderNo() {
		return workOrderNo;
	}
	/**
	 * @param workOrderNo 설정하려는 workOrderNo입니다.
	 */
	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}
	
}
