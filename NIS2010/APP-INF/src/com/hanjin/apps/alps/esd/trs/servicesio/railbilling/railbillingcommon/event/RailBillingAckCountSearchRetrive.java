/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingAckCountSearchRetrive.java
*@FileTitle : Rail Billing AckCount Search Retrive
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.railbillingcommon.event;

/**
 * EXP_PAP_019 에 대한 WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy의 Input Parameter<br>
 * - EXP_PAP_019Event로 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class RailBillingAckCountSearchRetrive {
	/** (Param 객체) */
	private String userId   = null;
	private String venderCd   = null;
	private String mainFlag = null; //2007-09-10 main 화면 조회 구분 추가
	
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
	
	

}
