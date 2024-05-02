/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : StmSar1005Event.java
 *@FileTitle : Outstanding Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event;

import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableOutstandingSC로 실행요청<br>
 * - AccountReceivableOutstandingSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를
 * request에 셋팅<br>
 * 
 * @author
 * @see StmSar1005Event 참조
 * @since J2EE 1.4
 */

public class StmSar1005Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String kind2 = ""; // 오른쪽 마우스 source-Generate Getters and Setters

	public String getKind2() {
		return kind2;
	}

	public void setKind2(String kind2) {
		this.kind2 = kind2;
	}

	private PaymentRequestLetterVO[] paymentRequestLetterVOs = null;

	public PaymentRequestLetterVO[] getPaymentRequestLetterVOs() {
		PaymentRequestLetterVO[] rtnVOs = null;
		if (this.paymentRequestLetterVOs != null) {
			rtnVOs = new PaymentRequestLetterVO[paymentRequestLetterVOs.length];
			System.arraycopy(paymentRequestLetterVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPaymentRequestLetterVOs(PaymentRequestLetterVO[] paymentRequestLetterVOs) {
		if (paymentRequestLetterVOs != null) {
			PaymentRequestLetterVO[] tmpVOs = new PaymentRequestLetterVO[paymentRequestLetterVOs.length];
			System.arraycopy(paymentRequestLetterVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.paymentRequestLetterVOs = tmpVOs;
		}
	}

	private PaymentRequestLetterVO paymentRequestLetterVO = null;

	public StmSar1005Event() {
	}

	public PaymentRequestLetterVO getPaymentRequestLetterVO() {
		return paymentRequestLetterVO;
	}

	public void setPaymentRequestLetterVO(PaymentRequestLetterVO paymentRequestLetterVO) {
		this.paymentRequestLetterVO = paymentRequestLetterVO;
	}

}