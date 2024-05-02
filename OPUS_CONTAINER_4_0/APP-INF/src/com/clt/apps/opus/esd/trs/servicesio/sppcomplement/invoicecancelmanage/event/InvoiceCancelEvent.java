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
package com.clt.apps.opus.esd.trs.servicesio.sppcomplement.invoicecancelmanage.event;

import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;
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
	
//	public void setInv_no(String[] invNo) {
//		this.invNo = invNo;
//	}
	public void setInv_no(String[] invNo) {
		if(invNo != null){
			String[] tmpArr = Arrays.copyOf(invNo,invNo.length);
			this.invNo = tmpArr;
		}
	}
	
//	public String[] getInv_no() {
//		return this.invNo;
//	}
	public String[] getInv_no() {
		String[] rtnArr = null;
		if(this.invNo != null){
			rtnArr = Arrays.copyOf(invNo,invNo.length);
		}
		return rtnArr;
	}
	
//	public void setInv_vndr_seq(String[] invVndrSeq) {
//		this.invVndrSeq = invVndrSeq;
//	}
	
	public void setInv_vndr_seq(String[] invVndrSeq) {
		if(invVndrSeq!=null){
			String[] tmpArr = Arrays.copyOf(invVndrSeq,invVndrSeq.length);
			this.invVndrSeq = tmpArr;			
		}
	}
	
//	public String[] getInv_vndr_seq() {
//		return this.invVndrSeq;
//	}	   
	public String[] getInv_vndr_seq() {
		String[] rtnArr = null;
		if(this.invVndrSeq != null){
			rtnArr = Arrays.copyOf(invVndrSeq,invVndrSeq.length);
		}
		return rtnArr;
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
