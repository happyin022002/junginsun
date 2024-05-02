/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TrsRailOrderKey.java
*@FileTitle : Trs Rail Billing Order Key Info
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
 * - EventRequest에서 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class TrsRailOrderKey implements java.io.Serializable {
	/** (Param 객체) */
	private String soOfcCity = null;
	private String soSeq = null;
	
	/**
	 * @return Returns the so_ofc_city.
	 */
	public String getSo_ofc_city() {
		return soOfcCity;
	}
	/**
	 * @param so_ofc_city The so_ofc_city to set.
	 */
	public void setSo_ofc_city(String so_ofc_city) {
		this.soOfcCity = so_ofc_city;
	}
	/**
	 * @return Returns the so_seq.
	 */
	public String getSo_seq() {
		return soSeq;
	}
	/**
	 * @param so_seq The so_seq to set.
	 */
	public void setSo_seq(String so_seq) {
		this.soSeq = so_seq;
	}
	
	
}
