/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : YardDetail.java
*@FileTitle : YardDetail Info
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
 * WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy Output Parameter<br>
 * - EventResponse에서 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class YardDetail implements java.io.Serializable {
	/** (Param 객체) */
	private String ydCd = null;
	private String ydNm = null;
	private String ydAddr = null;
	private String d2Flg = null;
	private String d4Flg = null;
	private String d5Flg = null;
	private String d7Flg = null;
	private String o2Flg = null;
	private String o4Flg = null;
	private String a2Flg = null;
	private String a4Flg = null;
	private String a5Flg = null;
	private String r5Flg = null;
	private String r2Flg = null;
	private String o5Flg = null;
	 
	/**
	 * @return Returns the yd_addr.
	 */
	public String getYd_addr() {
		return ydAddr;
	}
	/**
	 * @param yd_addr The yd_addr to set.
	 */
	public void setYd_addr(String yd_addr) {
		this.ydAddr = yd_addr;
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
	/**
	 * @return Returns the yd_nm.
	 */
	public String getYd_nm() {
		return ydNm;
	}
	/**
	 * @param yd_nm The yd_nm to set.
	 */
	public void setYd_nm(String yd_nm) {
		this.ydNm = yd_nm;
	}
	/**
	 * @return Returns the a2_flg.
	 */
	public String getA2_flg() {
		return a2Flg;
	}
	/**
	 * @param a2_flg The a2_flg to set.
	 */
	public void setA2_flg(String a2_flg) {
		this.a2Flg = a2_flg;
	}
	/**
	 * @return Returns the a4_flg.
	 */
	public String getA4_flg() {
		return a4Flg;
	}
	/**
	 * @param a4_flg The a4_flg to set.
	 */
	public void setA4_flg(String a4_flg) {
		this.a4Flg = a4_flg;
	}
	/**
	 * @return Returns the a5_flg.
	 */
	public String getA5_flg() {
		return a5Flg;
	}
	/**
	 * @param a5_flg The a5_flg to set.
	 */
	public void setA5_flg(String a5_flg) {
		this.a5Flg = a5_flg;
	}
	/**
	 * @return Returns the d2_flg.
	 */
	public String getD2_flg() {
		return d2Flg;
	}
	/**
	 * @param d2_flg The d2_flg to set.
	 */
	public void setD2_flg(String d2_flg) {
		this.d2Flg = d2_flg;
	}
	/**
	 * @return Returns the d4_flg.
	 */
	public String getD4_flg() {
		return d4Flg;
	}
	/**
	 * @param d4_flg The d4_flg to set.
	 */
	public void setD4_flg(String d4_flg) {
		this.d4Flg = d4_flg;
	}
	/**
	 * @return Returns the d5_flg.
	 */
	public String getD5_flg() {
		return d5Flg;
	}
	/**
	 * @param d5_flg The d5_flg to set.
	 */
	public void setD5_flg(String d5_flg) {
		this.d5Flg = d5_flg;
	}
	/**
	 * @return Returns the d7_flg.
	 */
	public String getD7_flg() {
		return d7Flg;
	}
	/**
	 * @param d7_flg The d7_flg to set.
	 */
	public void setD7_flg(String d7_flg) {
		this.d7Flg = d7_flg;
	}
	/**
	 * @return Returns the o2_flg.
	 */
	public String getO2_flg() {
		return o2Flg;
	}
	/**
	 * @param o2_flg The o2_flg to set.
	 */
	public void setO2_flg(String o2_flg) {
		this.o2Flg = o2_flg;
	}
	/**
	 * @return Returns the o4_flg.
	 */
	public String getO4_flg() {
		return o4Flg;
	}
	/**
	 * @param o4_flg The o4_flg to set.
	 */
	public void setO4_flg(String o4_flg) {
		this.o4Flg = o4_flg;
	}
	/**
	 * @return Returns the r5_flg.
	 */
	public String getR5_flg() {
		return r5Flg;
	}
	/**
	 * @param r5_flg The r5_flg to set.
	 */
	public void setR5_flg(String r5_flg) {
		this.r5Flg = r5_flg;
	}
	/**
	 * @return Returns the r2_flg.
	 */
	public String getR2_flg() {
		return r2Flg;
	}
	/**
	 * @param r2_flg The r2_flg to set.
	 */
	public void setR2_flg(String r2_flg) {
		this.r2Flg = r2_flg;
	}
	/**
	 * @return Returns the o5_flg.
	 */
	public String getO5_flg() {
		return o5Flg;
	}
	/**
	 * @param o5_flg The o5_flg to set.
	 */
	public void setO5_flg(String o5_flg) {
		this.o5Flg = o5_flg;
	}
	
}
