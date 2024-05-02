/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderSheetRetrive.java
*@FileTitle	: WorkOrderSheet
*Open Issues :
*Change	history	:
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion :	1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package	com.hanjin.apps.alps.esd.trs.servicesio.common.document;

/**
 * EXP_PAP_006 에 대한 WebService Document Object including	Parameters<br>
 * - TrsSppIWSProxy의 Input	Parameter<br>
 * - EXP_PAP_006Event로	변환하여 사용<br>
 *
 * @author doomi
 * @see	TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class WorkOrderSheetRetrive { 
	
	/* (Param 객체) */
	private String vendorCode 		= "";
	private String parentVendorCode = "";
	private	String woNo 			= "";
    private String woIssKnt 		= "";
    
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
	 * @return workOrderNo을 리턴합니다.
	 */
	public String getWorkOrderNo() {
		return woNo;
	}
	/**
	 * @param workOrderNo 설정하려는 workOrderNo입니다.
	 */
	public void setWorkOrderNo(String workOrderNo) {
		woNo = workOrderNo;
	}
	/**
	 * @return parentVendorCode을 리턴합니다.
	 */
	public String getParentVendorCode() {
		return parentVendorCode;
	}
	/**
	 * @param parentVendorCode 설정하려는 parentVendorCode입니다.
	 */
	public void setParentVendorCode(String parentVendorCode) {
		this.parentVendorCode = parentVendorCode;
	}
	/**
	 * @param vendorCode 설정하려는 vendorCode입니다.
	 */
	public void setWorkOrderIssueKnt(String WorkOrderIssueKnt) {
		this.woIssKnt = WorkOrderIssueKnt;
	}
	/**
	 * @return workOrderNo을 리턴합니다.
	 */
	public String getWorkOrderIssueKnt() {
		return woIssKnt;
	}
}
