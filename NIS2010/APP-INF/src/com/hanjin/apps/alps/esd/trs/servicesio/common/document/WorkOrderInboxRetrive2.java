/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderInboxRetrive2.java
*@FileTitle	: WorkOrderInboxRetrive2
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
 * EXP_PAP_001 에 대한 WebService Document Object including	Parameters<br>
 * - TrsSppIWSProxy의 Input	Parameter<br>
 * - EXP_PAP_001Event로	변환하여 사용<br>
 *
 * @author doomi
 * @see	TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */

public class WorkOrderInboxRetrive2 { 
	
	
	/**	(Param 객체) */
	private String userID 			= "";	
	private String vendorCode 		= "";	
	private String parentVendorCode = "";	
	private	String trspWoNo 		= "";	
	private	String eqTpCd 			= "";	
	private	String eqNo 			= "";
	private String bidNo			= "";
	private	String bkgNo 			= "";	
	private	String blNo 			= "";
	
	/**
	 * @return bkg_no을 리턴합니다.
	 */
	public String getBkg_no() {
		return bkgNo;
	}
	/**
	 * @param bkg_no 설정하려는 bkg_no입니다.
	 */
	public void setBkg_no(String bkg_no) {
		this.bkgNo = bkg_no;
	}
	/**
	 * @return bl_no을 리턴합니다.
	 */
	public String getBl_no() {
		return blNo;
	}
	/**
	 * @param bl_no 설정하려는 bl_no입니다.
	 */
	public void setBl_no(String bl_no) {
		this.blNo = bl_no;
	}
	/**
	 * @return eq_no을 리턴합니다.
	 */
	public String getEq_no() {
		return eqNo;
	}
	/**
	 * @param eq_no 설정하려는 eq_no입니다.
	 */
	public void setEq_no(String eq_no) {
		this.eqNo = eq_no;
	}
	/**
	 * @return eq_no을 리턴합니다.
	 */
	public String getBid_no() {
		return bidNo;
	}
	/**
	 * @param eq_no 설정하려는 eq_no입니다.
	 */
	public void setBid_no(String bid_no) {
		this.bidNo = bid_no;
	}
	/**
	 * @return eq_tp_cd을 리턴합니다.
	 */
	public String getEq_tp_cd() {
		return eqTpCd;
	}
	/**
	 * @param eq_tp_cd 설정하려는 eq_tp_cd입니다.
	 */
	public void setEq_tp_cd(String eq_tp_cd) {
		this.eqTpCd = eq_tp_cd;
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

