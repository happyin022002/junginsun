/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmSap0130Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* Created by Hannah Lee
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event;

import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.BankBalanceByOfficeCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountPayablePaymentSC로 실행요청<br>
 * - AccountPayablePaymentSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author hannah lee
 * @see StmSap0130Event 참조
 * @since J2EE 1.4
 */

public class StmSap0130Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object Search Parameter VO*/
	private BankBalanceByOfficeCondVO bankBalanceByOfficeCondVO = null;
	
	public StmSap0130Event() {}

	public BankBalanceByOfficeCondVO getBankBalanceByOfficeCondVO() {
		return bankBalanceByOfficeCondVO;
	}

	public void setBankBalanceByOfficeCondVO(
			BankBalanceByOfficeCondVO bankBalanceByOfficeCondVO) {
		this.bankBalanceByOfficeCondVO = bankBalanceByOfficeCondVO;
	}
	
	

}