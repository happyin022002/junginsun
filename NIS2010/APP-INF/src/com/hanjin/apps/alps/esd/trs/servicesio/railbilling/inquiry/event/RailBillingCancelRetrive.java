/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingCancelRetrive.java
*@FileTitle : Rail Billing Cancel Retrive
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.event;

/**
 * WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy의 Input Parameter<br>
 * - Event로 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class RailBillingCancelRetrive {
	/** (Param 객체) */
	private String userId   = null;
	private String venderCd   = null;
	private RailBillingInquiry[] railBillingInquiryList   = null;
	
	/**
	 * @return Returns the railBillingInquiryList.
	 */
	public RailBillingInquiry[] getRailBillingInquiryList() {
		return railBillingInquiryList;
	}
	/**
	 * @param railBillingInquiryList The railBillingInquiryList to set.
	 */
	public void setRailBillingInquiryList(RailBillingInquiry[] railBillingInquiryList) {
		this.railBillingInquiryList = railBillingInquiryList;
	}
	/**
	 * @return Returns the user_id.
	 */
	public String getUser_id() {
		return userId;
	}
	/**
	 * @param user_id The user_id to set.
	 */
	public void setUser_id(String user_id) {
		this.userId = user_id;
	}
	/**
	 * @return Returns the vender_cd.
	 */
	public String getVender_cd() {
		return venderCd;
	}
	/**
	 * @param vender_cd The vender_cd to set.
	 */
	public void setVender_cd(String vender_cd) {
		this.venderCd = vender_cd;
	}

	
}
