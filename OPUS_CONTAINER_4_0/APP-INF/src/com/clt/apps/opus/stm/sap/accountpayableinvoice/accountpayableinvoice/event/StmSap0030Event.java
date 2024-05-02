/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmSap0030Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* Created by Hannah Lee
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event;

import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceSlipCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceSlipDetailListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceSlipListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceSlipPaymentListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoicePrintVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CLT
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSap0030Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object Search Parameter VO*/
	private String invSeq    = "";
	private String invCurrCd = "";
	
	private InvoiceSlipCondVO invoiceSlipCondVO = null;
	
	private InvoiceSlipListVO invoiceSlipListVO = null;
	
	private InvoiceSlipDetailListVO invoiceSlipDetailListVO = null;
	
	private InvoiceSlipPaymentListVO invoiceSlipPaymentListVO = null;
	
	private InvoiceSlipListVO[] invoiceSlipListVOs = null;
	
	private InvoicePrintVO[] invoicePrintVOs = null;
	
	public StmSap0030Event() {}
	
	
	public String getInvSeq() {
		return invSeq;
	}

	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}

	public String getInvCurrCd() {
		return invCurrCd;
	}

	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
	}

	public InvoiceSlipCondVO getInvoiceSlipCondVO() {
		return invoiceSlipCondVO;
	}

	public void setInvoiceSlipCondVO(InvoiceSlipCondVO invoiceSlipCondVO) {
		this.invoiceSlipCondVO = invoiceSlipCondVO;
	}

	public InvoiceSlipListVO getInvoiceSlipListVO() {
		return invoiceSlipListVO;
	}

	public void setInvoiceSlipListVO(InvoiceSlipListVO invoiceSlipListVO) {
		this.invoiceSlipListVO = invoiceSlipListVO;
	}

	public InvoiceSlipDetailListVO getInvoiceSlipDetailListVO() {
		return invoiceSlipDetailListVO;
	}

	public void setInvoiceSlipDetailListVO(
			InvoiceSlipDetailListVO invoiceSlipDetailListVO) {
		this.invoiceSlipDetailListVO = invoiceSlipDetailListVO;
	}

	public InvoiceSlipPaymentListVO getInvoiceSlipPaymentListVO() {
		return invoiceSlipPaymentListVO;
	}

	public void setInvoiceSlipPaymentListVO(
			InvoiceSlipPaymentListVO invoiceSlipPaymentListVO) {
		this.invoiceSlipPaymentListVO = invoiceSlipPaymentListVO;
	}


	public InvoiceSlipListVO[] getInvoiceSlipListVOs() {
		InvoiceSlipListVO[] rtnVOs = null;
		if(this.invoiceSlipListVOs != null) {
			rtnVOs = new InvoiceSlipListVO[invoiceSlipListVOs.length];
			System.arraycopy(invoiceSlipListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;

	}


	public void setInvoiceSlipListVOs(InvoiceSlipListVO[] invoiceSlipListVOs) {
		if(invoiceSlipListVOs != null) {
			InvoiceSlipListVO[] tmpVOs = new InvoiceSlipListVO[invoiceSlipListVOs.length];
			System.arraycopy(invoiceSlipListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invoiceSlipListVOs = tmpVOs;
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