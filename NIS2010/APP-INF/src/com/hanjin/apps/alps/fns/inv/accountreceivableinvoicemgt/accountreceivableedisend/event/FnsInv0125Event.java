/**
 * Copyright(c) 2012 CyberLogitec
 * @FileName : FnsInv0125Event.java
 * @FileTitle : EDI Submission(Honey Well)
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2012.05.17
 * @LastModifier : Sang-Hyun Kim
 * @LastVersion : 1.0
 * 1.0 Creation 2012.05.17 Sang-Hyun Kim.
 */
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HNWLInvoiceEdiVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * DHL EDI에 대한 parameter value object.
 * 
 * @author Sang-Hyun Kim
 * @see 각 DAO Class 참조.
 * @since J2EE 1.4
 */
public class FnsInv0125Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private DHLInputVO inputVo = null;
	private HNWLInvoiceEdiVO invoiceEdiVos[] = null;

	/**
	 * @return the inputVo
	 */
	public DHLInputVO getInputVo() {
		return inputVo;
	}
	/**
	 * @param inputVo the inputVo to set
	 */
	public void setInputVo(DHLInputVO inputVo) {
		this.inputVo = inputVo;
	}
	/**
	 * @return the invoiceEdiVos
	 */
	public HNWLInvoiceEdiVO[] getInvoiceEdiVos() {
		return invoiceEdiVos;
	}
	/**
	 * @param invoiceEdiVos the invoiceEdiVos to set
	 */
	public void setInvoiceEdiVos(HNWLInvoiceEdiVO[] invoiceEdiVos) {
		this.invoiceEdiVos = invoiceEdiVos;
	}
}
