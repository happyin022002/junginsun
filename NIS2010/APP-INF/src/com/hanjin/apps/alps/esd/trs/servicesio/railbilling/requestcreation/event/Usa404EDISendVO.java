/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : Usa404EDISendVO.java
*@FileTitle : Usa404EDISendVO Info
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event;

import java.util.Collection;

/**
 * WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy Output Parameter<br>
 * - EventResponse에서 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class Usa404EDISendVO implements java.io.Serializable {
	/** (Param 객체) */
	private String cntr_ofc_cd = null;
	private String user_id = null;
	private Collection edi_send_list = null;
	
	/**
	 * @return Returns the cntr_ofc_cd.
	 */
	public String getCntr_ofc_cd() {
		return cntr_ofc_cd;
	}
	/**
	 * @param cntr_ofc_cd The cntr_ofc_cd to set.
	 */
	public void setCntr_ofc_cd(String cntr_ofc_cd) {
		this.cntr_ofc_cd = cntr_ofc_cd;
	}
	/**
	 * @return Returns the edi_send_list.
	 */
	public Collection getEdi_send_list() {
		return edi_send_list;
	}
	/**
	 * @param edi_send_list The edi_send_list to set.
	 */
	public void setEdi_send_list(Collection edi_send_list) {
		this.edi_send_list = edi_send_list;
	}
	/**
	 * @return Returns the user_id.
	 */
	public String getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id The user_id to set.
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	
}
