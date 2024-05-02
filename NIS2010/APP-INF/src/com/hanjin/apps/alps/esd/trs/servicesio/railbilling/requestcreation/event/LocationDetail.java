/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : LocationDetail.java 
*@FileTitle : LocationDetail Info
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
 * - RailBillingIWSProxy Output Parameter<br>
 * - EventResponse에서 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class LocationDetail implements java.io.Serializable {
	/** (Param 객체) */
	private String locCd = null;
	private String locNm = null;
	private YardDetail[]  yardDetailList;
	
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
	 * @return Returns the loc_nm.
	 */
	public String getLoc_nm() {
		return locNm;
	}
	/**
	 * @param loc_nm The loc_nm to set.
	 */
	public void setLoc_nm(String loc_nm) {
		this.locNm = loc_nm;
	}
	/**
	 * @return Returns the yardDetailList.
	 */
	public YardDetail[] getYardDetailList() {
		return yardDetailList;
	}
	/**
	 * @param yardDetailList The yardDetailList to set.
	 */
	public void setYardDetailList(YardDetail[] yardDetailList) {
		this.yardDetailList = yardDetailList;
	}
	
	
	
}
