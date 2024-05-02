/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSap0330Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.29
*@LastModifier : sangyoung cha
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event;

import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentDetailCurrSumListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentDetailListVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CLT
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSap0330Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	
	private PaymentDetailListVO paymentDetailListVO = null;

	private PaymentDetailListVO[] paymentDetailListVOs = null;

	private PaymentDetailCurrSumListVO paymentDetailCurrSumListVO = null;

	private PaymentDetailCurrSumListVO[] paymentDetailCurrSumListVOs = null;
	
	public PaymentDetailListVO getPaymentDetailListVO() {
		return paymentDetailListVO;
	}

	public void setPaymentDetailListVO(PaymentDetailListVO paymentDetailListVO) {
		this.paymentDetailListVO = paymentDetailListVO;
	}

	public PaymentDetailListVO[] getPaymentDetailListVOs() {
		PaymentDetailListVO[] rtnVOs = null;
		if(this.paymentDetailListVOs != null) {
			rtnVOs = new PaymentDetailListVO[paymentDetailListVOs.length];
			System.arraycopy(paymentDetailListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPaymentDetailListVOs(PaymentDetailListVO[] paymentDetailListVOs) {
		if(paymentDetailListVOs != null) {
			PaymentDetailListVO[] tmpVOs = new PaymentDetailListVO[paymentDetailListVOs.length];
			System.arraycopy(paymentDetailListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.paymentDetailListVOs = tmpVOs;
		}
	}

	public PaymentDetailCurrSumListVO getPaymentDetailCurrSumListVO() {
		return paymentDetailCurrSumListVO;
	}

	public void setPaymentDetailCurrSumListVO(PaymentDetailCurrSumListVO paymentDetailCurrSumListVO) {
		this.paymentDetailCurrSumListVO = paymentDetailCurrSumListVO;
	}

	public PaymentDetailCurrSumListVO[] getPaymentDetailCurrSumListVOs() {
		PaymentDetailCurrSumListVO[] rtnVOs = null;
		if(this.paymentDetailCurrSumListVOs != null) {
			rtnVOs = new PaymentDetailCurrSumListVO[paymentDetailCurrSumListVOs.length];
			System.arraycopy(paymentDetailCurrSumListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPaymentDetailCurrSumListVOs(PaymentDetailCurrSumListVO[] paymentDetailCurrSumListVOs) {
		if(paymentDetailCurrSumListVOs != null) {
			PaymentDetailCurrSumListVO[] tmpVOs = new PaymentDetailCurrSumListVO[paymentDetailCurrSumListVOs.length];
			System.arraycopy(paymentDetailCurrSumListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.paymentDetailCurrSumListVOs = tmpVOs;
		}
	}
	
}