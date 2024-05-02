/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmSap0070Event.java
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

import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentSlipCondVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentSlipLineListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentSlipListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoicePrintVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountPayablePaymentSC로 실행요청<br>
 * - AccountPayablePaymentSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author hannah lee
 * @see StmSap0070Event 참조
 * @since J2EE 1.4
 */

public class StmSap0070Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object Search Parameter VO*/
	private String paySeq = "";
	
	private PaymentSlipCondVO paymentSlipCondVO = null;
	
	private PaymentSlipListVO paymentSlipListVO = null;
		
	private PaymentSlipLineListVO paymentSlipLineListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvoicePrintVO[] invoicePrintVOs = null;	
		
	
	public StmSap0070Event() {}

	
	public String getPaySeq() {
		return paySeq;
	}

	public void setPaySeq(String paySeq) {
		this.paySeq = paySeq;
	}
	
	public PaymentSlipCondVO getPaymentSlipCondVO() {
		return paymentSlipCondVO;
	}

	public void setPaymentSlipCondVO(PaymentSlipCondVO paymentSlipCondVO) {
		this.paymentSlipCondVO = paymentSlipCondVO;
	}

	public PaymentSlipListVO getPaymentSlipListVO() {
		return paymentSlipListVO;
	}

	public void setPaymentSlipListVO(PaymentSlipListVO paymentSlipListVO) {
		this.paymentSlipListVO = paymentSlipListVO;
	}

	public PaymentSlipLineListVO getPaymentSlipLineListVO() {
		return paymentSlipLineListVO;
	}

	public void setPaymentSlipLineListVO(PaymentSlipLineListVO paymentSlipLineListVO) {
		this.paymentSlipLineListVO = paymentSlipLineListVO;
	}


	public InvoicePrintVO[] getInvoicePrintVOs() {
		InvoicePrintVO[] rtnVOs = null;
		if(this.invoicePrintVOs != null) {
			rtnVOs = new InvoicePrintVO[invoicePrintVOs.length];
			System.arraycopy(invoicePrintVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}


	public void setInvoicePrintVOs(InvoicePrintVO[] invoicePrintVOs) {
		if(invoicePrintVOs != null) {
			InvoicePrintVO[] tmpVOs = new InvoicePrintVO[invoicePrintVOs.length];
			System.arraycopy(invoicePrintVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invoicePrintVOs = tmpVOs;
		}
	}

}