/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderInboxRetrive.java
*@FileTitle	: WorkOrderInbox
*Open Issues :
*Change	history	:
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion :	1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package	com.clt.apps.opus.esd.trs.servicesio.common.document;

/**
 * EXP_PAP_001 에 대한 WebService Document Object including	Parameters<br>
 * - TrsSppIWSProxy의 Input	Parameter<br>
 * - EXP_PAP_001Event로	변환하여 사용<br>
 *
 * @author doomi
 * @see	TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */


public class WorkOrderInboxExcelPrint { 
	
	/**	(Param 객체) */
	private String workOrderNo = "";
	private String vendorCode = "";
	
	public String getWorkOrderNo() {
		return workOrderNo;
	}

	public void setWorkOrderNo(String WorkOrderNo) {
		this.workOrderNo = WorkOrderNo;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String VendorCode) {
		this.vendorCode = VendorCode;
	}

}
