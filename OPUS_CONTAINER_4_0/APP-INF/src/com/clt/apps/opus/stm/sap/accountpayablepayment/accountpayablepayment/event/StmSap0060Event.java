/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSap0060Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SapCommonVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoicePrintVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentEntryLineVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentEntryVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CLT
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSap0060Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String paySeq = "";

	private PaymentEntryVO paymentEntryVO = null;

	private PaymentEntryVO[] paymentEntryVOs = null;
	
	private PaymentEntryLineVO paymentEntryLineVO = null;

	private PaymentEntryLineVO[] paymentEntryLineVOs = null;
	
	private SapCommonVO sapCommonVO = null;
	
	private SapCommonVO[] sapCommonVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvoicePrintVO[] invoicePrintVOs = null;	
			
	public String getPaySeq() {
		return paySeq;
	}

	public void setPaySeq(String paySeq) {
		this.paySeq = paySeq;
	}

	public PaymentEntryVO getPaymentEntryVO() {
		return paymentEntryVO;
	}

	public void setPaymentEntryVO(PaymentEntryVO paymentEntryVO) {
		this.paymentEntryVO = paymentEntryVO;
	}

	public PaymentEntryVO[] getPaymentEntryVOs() {
		PaymentEntryVO[] rtnVOs = null;
		if(this.paymentEntryVOs != null) {
			rtnVOs = new PaymentEntryVO[paymentEntryVOs.length];
			System.arraycopy(paymentEntryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPaymentEntryVOs(PaymentEntryVO[] paymentEntryVOs) {
		if(paymentEntryVOs != null) {
			PaymentEntryVO[] tmpVOs = new PaymentEntryVO[paymentEntryVOs.length];
			System.arraycopy(paymentEntryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.paymentEntryVOs = tmpVOs;
		}
	}

	public PaymentEntryLineVO getPaymentEntryLineVO() {
		return paymentEntryLineVO;
	}

	public void setPaymentEntryLineVO(PaymentEntryLineVO paymentEntryLineVO) {
		this.paymentEntryLineVO = paymentEntryLineVO;
	}

	public PaymentEntryLineVO[] getPaymentEntryLineVOs() {
		PaymentEntryLineVO[] rtnVOs = null;
		if(this.paymentEntryLineVOs != null) {
			rtnVOs = new PaymentEntryLineVO[paymentEntryLineVOs.length];
			System.arraycopy(paymentEntryLineVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPaymentEntryLineVOs(PaymentEntryLineVO[] paymentEntryLineVOs) {
		if(paymentEntryLineVOs != null) {
			PaymentEntryLineVO[] tmpVOs = new PaymentEntryLineVO[paymentEntryLineVOs.length];
			System.arraycopy(paymentEntryLineVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.paymentEntryLineVOs = tmpVOs;
		}
	}

	public SapCommonVO getSapCommonVO() {
		return sapCommonVO;
	}

	public void setSapCommonVO(SapCommonVO sapCommonVO) {
		this.sapCommonVO = sapCommonVO;
	}

	public SapCommonVO[] getSapCommonVOs() {
		SapCommonVO[] rtnVOs = null;
		if(this.sapCommonVOs != null) {
			rtnVOs = new SapCommonVO[sapCommonVOs.length];
			System.arraycopy(sapCommonVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSapCommonVOs(SapCommonVO[] sapCommonVOs) {
		if(sapCommonVOs != null) {
			SapCommonVO[] tmpVOs = new SapCommonVO[sapCommonVOs.length];
			System.arraycopy(sapCommonVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.sapCommonVOs = tmpVOs;
		}
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