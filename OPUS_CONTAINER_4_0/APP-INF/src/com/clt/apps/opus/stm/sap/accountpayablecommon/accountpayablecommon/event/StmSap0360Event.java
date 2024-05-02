/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSap0360Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event;

import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CLT
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSap0360Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String ofcCd = "";  
	private String str_security_flag = "";

	public String getOfccd() {
		return ofcCd;
	}
	
	public String getStr_security_flag() {
		return str_security_flag;
	}

	public void setOfccd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	public void setStr_security_flag(String str_security_flag) {
		this.str_security_flag = str_security_flag;
	}

}