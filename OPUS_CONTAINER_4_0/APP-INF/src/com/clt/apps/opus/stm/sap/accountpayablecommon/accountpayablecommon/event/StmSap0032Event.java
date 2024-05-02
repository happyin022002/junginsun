/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmSap0032Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : Hannah Lee
*@LastVersion : 1.0
* Hannah Lee, 2014.04.02
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

public class StmSap0032Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	
	private String vndr_seq ="";
	private String curr_cd ="";
	private String bankAcctTpNm = "";
	private String callFlag = "";
	private String vndr_name = "";
	
	public String getVndr_seq() {
		return vndr_seq;
	}
	public void setVndr_seq(String vndr_seq) {
		this.vndr_seq = vndr_seq;
	}
	public String getCurr_cd() {
		return curr_cd;
	}
	public void setCurr_cd(String curr_cd) {
		this.curr_cd = curr_cd;
	}
	public String getBankAcctTpNm() {
		return bankAcctTpNm;
	}
	public void setBankAcctTpNm(String bankAcctTpNm) {
		this.bankAcctTpNm = bankAcctTpNm;
	}
	public String getCallFlag() {
		return callFlag;
	}
	public void setCallFlag(String callFlag) {
		this.callFlag = callFlag;
	}
	public String getVndr_name() {
		return vndr_name;
	}
	public void setVndr_name(String vndr_name) {
		this.vndr_name = vndr_name;
	}	

}