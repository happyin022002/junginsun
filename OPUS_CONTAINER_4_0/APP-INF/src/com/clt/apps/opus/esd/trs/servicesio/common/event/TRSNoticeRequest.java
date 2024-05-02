/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TRSNoticeRequest.java
*@FileTitle : SPP TRS Request
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-04-10 subghwan cho : parentVendorCode 추가
*@LastModifyDate : 2007-04-10
*@LastModifier : sunghwan cho
*@LastVersion : 1.1
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.common.event;

/**
 * Request Value Object<br>
 * - SPP TRS Request<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class TRSNoticeRequest {
	private String userID = "";
	private String vendorCode = "";
	private String parentVendorCode = "";
	private String mainFlag = "";
	private String groupId = "";
	
	
	
	/**
	 * @return Returns the groupId.
	 */
	public String getGroupId() {
		return groupId;
	}
	/**
	 * @param groupId The groupId to set.
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	/**
	 * @return Returns the mainFlag.
	 */
	public String getMainFlag() {
		return mainFlag;
	}
	/**
	 * @param mainFlag The mainFlag to set.
	 */
	public void setMainFlag(String mainFlag) {
		this.mainFlag = mainFlag;
	}
	/**
	 * 
	 * @return
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * 
	 * @param userID
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	/**
	 * 
	 * @return
	 */
	public String getVendorCode() {
		return vendorCode;
	}
	/**
	 * 
	 * @param vendorCode
	 */
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	/**
	 * 
	 * @return
	 */
	public String getParentVendorCode() {
		return parentVendorCode;
	}
	/**
	 * 
	 * @param parentVendorCode
	 */
	public void setParentVendorCode(String parentVendorCode) {
		this.parentVendorCode = parentVendorCode;
	}
	
}
