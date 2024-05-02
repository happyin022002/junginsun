/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingEmptyInsertRetrive.JAVA
*@FileTitle : Rail Billing Request Empty Creation Info Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event;

/**
 * WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy의 Input Parameter<br>
 * - Event로 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class RailBillingEmptyInsertRetrive {
	/** (Param 객체) */
	private String userId   = null;
	private String venderCd   = null;
	private String locCd   = null;
	private String ydCd   = null;
	private VndrUserDetail vndrUserDetailInfo = null;
	private EmptyContainer[] emptyContainerList = null;
	
	/**
	 * @return Returns the emptyContainerList.
	 */
	public EmptyContainer[] getEmptyContainerList() {
		return emptyContainerList;
	}
	/**
	 * @param emptyContainerList The emptyContainerList to set.
	 */
	public void setEmptyContainerList(EmptyContainer[] emptyContainerList) {
		this.emptyContainerList = emptyContainerList;
	}
	/**
	 * @return Returns the loc_cd.
	 */
	public String getLoc_cd() {
		return locCd;
	}
	/**
	 * @param loc_cd The loc_cd to set.
	 */
	public void setLoc_cd(String loc_cd) {
		this.locCd = loc_cd;
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
	 * @return Returns the vndrUserDetailInfo.
	 */
	public VndrUserDetail getVndrUserDetailInfo() {
		return vndrUserDetailInfo;
	}
	/**
	 * @param vndrUserDetailInfo The vndrUserDetailInfo to set.
	 */
	public void setVndrUserDetailInfo(VndrUserDetail vndrUserDetailInfo) {
		this.vndrUserDetailInfo = vndrUserDetailInfo;
	}
	/**
	 * @return Returns the yd_cd.
	 */
	public String getYd_cd() {
		return ydCd;
	}
	/**
	 * @param yd_cd The yd_cd to set.
	 */
	public void setYd_cd(String yd_cd) {
		this.ydCd = yd_cd;
	}
}
