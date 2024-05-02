/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmSap0050Event.java
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

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentScheduleCondVO;


/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountPayablePaymentSC로 실행요청<br>
 * - AccountPayablePaymentSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Hannah Lee
 * @see StmSap0050Event 참조
 * @since J2EE 1.4
 */

public class StmSap0050Event extends EventSupport {
    
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object Search Parameter VO*/
	private PaymentScheduleCondVO paymentScheduleCondVO = null;
    
	public StmSap0050Event() {}
	
	public PaymentScheduleCondVO getPaymentScheduleCondVO() {
		return paymentScheduleCondVO;
	}

	public void setPaymentScheduleCondVO(PaymentScheduleCondVO paymentScheduleCondVO) {
		this.paymentScheduleCondVO = paymentScheduleCondVO;
	}

}