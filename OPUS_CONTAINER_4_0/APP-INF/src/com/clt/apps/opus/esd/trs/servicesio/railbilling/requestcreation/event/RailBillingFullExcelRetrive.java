/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingFullExcelRetrive.java
*@FileTitle : Rail Billing Request Full Excel Info Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event;

import java.util.Arrays;

/**
 * WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy의 Input Parameter<br>
 * - Event로 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class RailBillingFullExcelRetrive {
	/** (Param 객체) */
	private String userId   = null;
	private String venderCd   = null;
	private TrsRailOrderKey[] trsRailOrderKeyList = null;
	
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
	 * @return Returns the trsRailOrderKeyList.
	 */
	public TrsRailOrderKey[] getTrsRailOrderKeyList() {
		TrsRailOrderKey[] rtnList = null;
		if(this.trsRailOrderKeyList != null){
			rtnList = Arrays.copyOf(trsRailOrderKeyList, trsRailOrderKeyList.length);
		}
		return rtnList;
	}
	/**
	 * @param trsRailOrderKeyList The trsRailOrderKeyList to set.
	 */
	public void setTrsRailOrderKeyList(TrsRailOrderKey[] trsRailOrderKeyList) {
		if(trsRailOrderKeyList != null){
			TrsRailOrderKey[] tmpList = Arrays.copyOf(trsRailOrderKeyList, trsRailOrderKeyList.length);
			this.trsRailOrderKeyList = tmpList;
		}
	}

}
