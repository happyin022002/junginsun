/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingInquirySearchRetrive.java
*@FileTitle : Rail Billing Inquiry Search Retrive
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
public class RailBillingInquirySearchRetrive {
	/** (Param 객체) */
	private String userId   = null;
	private String venderCd   = null;
	private String userRoleCd = null; // 2007-10-26 almighty 계정 구분 추가
	private RailBillingInquiryCond railBillingInquiryCond   = null;
	
	/**
	 * @return Returns the railBillingInquiryCond.
	 */
	public RailBillingInquiryCond getRailBillingInquiryCond() {
		return railBillingInquiryCond;
	}
	/**
	 * @param railBillingInquiryCond The railBillingInquiryCond to set.
	 */
	public void setRailBillingInquiryCond(RailBillingInquiryCond railBillingInquiryCond) {
		this.railBillingInquiryCond = railBillingInquiryCond;
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
	/**
	 * @return Returns the user_role_cd.
	 */
	public String getUser_role_cd() {
		return userRoleCd;
	}
	/**
	 * @param user_role_cd The user_role_cd to set.
	 */
	public void setUser_role_cd(String user_role_cd) {
		this.userRoleCd = user_role_cd;
	}
	

}
