/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ContainerTypeSize.java
*@FileTitle : ContainerTypeSize Info
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
public class ContainerTypeSize implements java.io.Serializable {
	/** (Param 객체) */
	private String cntrNo = null;
	private String cntrTpszCd = null;
	private String cntrTpszNm = null;
	
	
	/**
	 * @return Returns the cntr_no.
	 */
	public String getCntr_no() {
		return cntrNo;
	} 

	/**
	 * @param cntr_no The cntr_no to set.
	 */
	public void setCntr_no(String cntr_no) {
		this.cntrNo = cntr_no;
	}

	/**
	 * @return Returns the cntr_tpsz_cd.
	 */
	public String getCntr_tpsz_cd() {
		return cntrTpszCd;
	}

	/**
	 * @param cntr_tpsz_cd The cntr_tpsz_cd to set.
	 */
	public void setCntr_tpsz_cd(String cntr_tpsz_cd) {
		this.cntrTpszCd = cntr_tpsz_cd;
	}

	/**
	 * @return Returns the cntr_tpsz_nm.
	 */
	public String getCntr_tpsz_nm() {
		return cntrTpszNm;
	}

	/**
	 * @param cntr_tpsz_nm The cntr_tpsz_nm to set.
	 */
	public void setCntr_tpsz_nm(String cntr_tpsz_nm) {
		this.cntrTpszNm = cntr_tpsz_nm;
	}

}
