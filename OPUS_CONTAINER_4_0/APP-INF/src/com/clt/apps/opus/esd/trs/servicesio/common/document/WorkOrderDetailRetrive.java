/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderDetailRetrive.java
*@FileTitle	: WorkOrderDetail
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
 * EXP_PAP_002 에 대한 WebService Document Object including	Parameters<br>
 * - TrsSppIWSProxy의 Input	Parameter<br>
 * - EXP_PAP_002Event로	변환하여 사용<br>
 *
 * @author doomi
 * @see	TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class WorkOrderDetailRetrive { 
	

	/**	(Param 객체) */
	private String vendorCode = "";
	private String parentVendorCode = "";
	private	String trspWoNo =	 "";		
	private	String trspSoNo  = "";
	/**
	 * @return trsp_so_no을 리턴합니다.
	 */
	public String getTrsp_so_no() {
		return trspSoNo;
	}
	/**
	 * @param trsp_so_no 설정하려는 trsp_so_no입니다.
	 */
	public void setTrsp_so_no(String trsp_so_no) {
		this.trspSoNo = trsp_so_no;
	}
	/**
	 * @return trsp_wo_no을 리턴합니다.
	 */
	public String getTrsp_wo_no() {
		return trspWoNo;
	}
	/**
	 * @param trsp_wo_no 설정하려는 trsp_wo_no입니다.
	 */
	public void setTrsp_wo_no(String trsp_wo_no) {
		this.trspWoNo = trsp_wo_no;
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



	
}
