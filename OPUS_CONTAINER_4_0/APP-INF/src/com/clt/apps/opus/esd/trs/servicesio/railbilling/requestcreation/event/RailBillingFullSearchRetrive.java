/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingFullSearchRetrive.java
*@FileTitle : Rail Billing Request Full Search Info Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event;

/**
 * EXP_PAP_010 에 대한 WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy의 Input Parameter<br>
 * - EXP_PAP_010Event로 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class RailBillingFullSearchRetrive {
	/** (Param 객체) */
	private String userId   = null;
	private String venderCd   = null;
	private String bkgNo   = null;
	
	/**
	 * @return Returns the bkg_no.
	 */
	public String getBkg_no() {
		return bkgNo;
	}
	/**
	 * @param bkg_no The bkg_no to set.
	 */
	public void setBkg_no(String bkg_no) {
		this.bkgNo = bkg_no;
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
