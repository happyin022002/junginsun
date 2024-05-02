/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FnsInv0120Event.java
 *@FileTitle : Report for Reverse Charge
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.04.18
 *@LastModifier : 최도순
 *@LastVersion : 1.0
 * 2010.12.28 최도순
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * FNS_INV_0120 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - FNS_INV_0120HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Choi Do Soon
 * @see FNS_INV_0120HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0120Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String arOfcCd = "";
	private String fmDt = "";
	private String toDt = "";
	
	
	
	public FnsInv0120Event() {
	}



	/**
	 * @return the arOfcCd
	 */
	public String getArOfcCd() {
		return arOfcCd;
	}



	/**
	 * @param arOfcCd the arOfcCd to set
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}



	/**
	 * @return the fmDt
	 */
	public String getFmDt() {
		return fmDt;
	}



	/**
	 * @param fmDt the fmDt to set
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}



	/**
	 * @return the toDt
	 */
	public String getToDt() {
		return toDt;
	}



	/**
	 * @param toDt the toDt to set
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}


	
	
	
}