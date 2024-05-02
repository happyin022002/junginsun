/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmSap0150Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event;

import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceAccrualCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceAccrualVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Han Dong Hoon
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSap0150Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceAccrualCondVO invoiceAccrualCondVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceAccrualVO invoiceAccrualVO = null;
	/** Table Value Object Multi Data 처리 */
	private InvoiceAccrualVO[] invoiceAccrualVOs = null;
	
	public InvoiceAccrualCondVO getInvoiceAccrualCondVO() {
		return invoiceAccrualCondVO;
	}
	public void setInvoiceAccrualCondVO(InvoiceAccrualCondVO invoiceAccrualCondVO) {
		this.invoiceAccrualCondVO = invoiceAccrualCondVO;
	}
	public InvoiceAccrualVO getInvoiceAccrualVO() {
		return invoiceAccrualVO;
	}
	public void setInvoiceAccrualVO(InvoiceAccrualVO invoiceAccrualVO) {
		this.invoiceAccrualVO = invoiceAccrualVO;
	}
	public InvoiceAccrualVO[] getInvoiceAccrualVOs() {
		InvoiceAccrualVO[] rtnVOs = null;
		if(this.invoiceAccrualVOs != null) {
			rtnVOs = new InvoiceAccrualVO[invoiceAccrualVOs.length];
			System.arraycopy(invoiceAccrualVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;

	}
	public void setInvoiceAccrualVOs(InvoiceAccrualVO[] invoiceAccrualVOs) {
		if(invoiceAccrualVOs != null) {
			InvoiceAccrualVO[] tmpVOs = new InvoiceAccrualVO[invoiceAccrualVOs.length];
			System.arraycopy(invoiceAccrualVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invoiceAccrualVOs = tmpVOs;
		}

	}
	

	
}