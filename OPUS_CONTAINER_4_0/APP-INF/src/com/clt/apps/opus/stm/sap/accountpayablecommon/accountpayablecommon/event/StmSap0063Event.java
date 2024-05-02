/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSap0063Event.java
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

public class StmSap0063Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String bankAcctNm = "";
	private String bankAcctNo = "";
	private String ofcCd = "";
	private String bankAcctTpNm = "";
	private String acctTpCd = "";
	
	public String getBankAcctNm() {
		return bankAcctNm;
	}
	public void setBankAcctNm(String bankAcctNm) {
		this.bankAcctNm = bankAcctNm;
	}
	public String getBankAcctNo() {
		return bankAcctNo;
	}
	public void setBankAcctNo(String bankAcctNo) {
		this.bankAcctNo = bankAcctNo;
	}
	public String getOfcCd() {
		return ofcCd;
	}
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	public String getBankAcctTpNm() {
		return bankAcctTpNm;
	}
	public void setBankAcctTpNm(String bankAcctTpNm) {
		this.bankAcctTpNm = bankAcctTpNm;
	}
	public String getAcctTpCd() {
		return acctTpCd;
	}
	public void setAcctTpCd(String acctTpCd) {
		this.acctTpCd = acctTpCd;
	}
}