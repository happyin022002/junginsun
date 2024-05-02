/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0084Event.java
*@FileTitle : (Thailand) Freight and Charge List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.09 정휘택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0084 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0084HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Hwi Taek
 * @see FNS_INV_0084HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0084Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String vvd = "";
	
   	public FnsInv0084Event(){}

	public String getVvd() {
		return vvd;
	}
	
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
}