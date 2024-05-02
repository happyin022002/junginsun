/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSap0211Event.java
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

public class StmSap0211Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String payBatNm = "";
	private String payFromDate = "";
	private String payToDate = "";

	public String getPayBatNm() {
		return payBatNm;
	}

	public void setPayBatNm(String payBatNm) {
		this.payBatNm = payBatNm;
	}

	public String getPayFromDate() {
		return payFromDate;
	}

	public void setPayFromDate(String payFromDate) {
		this.payFromDate = payFromDate;
	}

	public String getPayToDate() {
		return payToDate;
	}

	public void setPayToDate(String payToDate) {
		this.payToDate = payToDate;
	}


}