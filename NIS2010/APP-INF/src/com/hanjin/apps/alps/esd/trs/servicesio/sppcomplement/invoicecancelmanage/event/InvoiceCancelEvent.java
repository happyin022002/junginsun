/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCancelEvent.java
*@FileTitle : Invoice Cancel
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-06
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0 
* 2007-02-06 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.invoicecancelmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 *  PDTO(Data Transfer Object including Parameters)<br>
 * - HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Sang-Woo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class InvoiceCancelEvent extends EventSupport {
	
	private static final long serialVersionUID = 1L;

	private String userID = "";	
	private String[] invNo; 
	private String[] invVndrSeq;
	
	public void setInv_no(String[] invNo) {
		this.invNo = invNo;
	}
	
	public String[] getInv_no() {
		return this.invNo;
	}
	
	public void setInv_vndr_seq(String[] invVndrSeq) {
		this.invVndrSeq = invVndrSeq;
	}
	
	public String[] getInv_vndr_seq() {
		return this.invVndrSeq;
	}	   
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
		
    public String getEventName() {
        return "InvoiceCancelEvent";
    }

    public String toString() {
        return "InvoiceCancelEvent";
    }	

}
