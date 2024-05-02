/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0108Event.java
*@FileTitle : INVOICE Printer Set up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.24
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.10.24 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0108 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0108HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see FNS_INV_0108HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0108Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	private String invPrnDvcNm = "";
	private String arOfcCd = "";
	private String ofcCd = "";
	private String usrId = "";
	
	public void setInvPrnDvcNm(String invPrnDvcNm) {
		this.invPrnDvcNm = invPrnDvcNm;
	}

	public String getInvPrnDvcNm() {
		return invPrnDvcNm;
	}
	
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}

	public String getArOfcCd() {
		return arOfcCd;
	}
	
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getOfcCd() {
		return ofcCd;
	}
	
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getUsrId() {
		return usrId;
	}
}