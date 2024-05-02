/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmSap0510Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* Created by ORKIM
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event;

import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSap0510Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String ofcCd = "";
	private String ofcType = "";
	private String inactiveType = "";
	private String bankAcctNo = "";

    public StmSap0510Event() {}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getOfcType() {
		return ofcType;
	}

	public void setOfcType(String ofcType) {
		this.ofcType = ofcType;
	}

	public String getInactiveType() {
		return inactiveType;
	}

	public void setInactiveType(String inactiveType) {
		this.inactiveType = inactiveType;
	}

	public String getBankAcctNo() {
		return bankAcctNo;
	}

	public void setBankAcctNo(String bankAcctNo) {
		this.bankAcctNo = bankAcctNo;
	}
    


    

}