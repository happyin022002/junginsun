/**
 * Copyright(c) 2012 CyberLogitec
 * @FileName : FnsInv0124Event.java
 * @FileTitle : EDI Submission(DHL)
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2012.04.25
 * @LastModifier : Sang-Hyun Kim
 * @LastVersion : 1.0
 * 1.0 Creation 2012.04.25 Sang-Hyun Kim.
 */
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLInvoiceEdiVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * DHL EDI에 대한 parameter value object.
 * 
 * @author Sang-Hyun Kim
 * @see 각 DAO Class 참조.
 * @since J2EE 1.4
 */
public class FnsInv0124Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private DHLInputVO dhlInputVO = null;
	private DHLInvoiceEdiVO dhlInvoiceEdiVOs[] = null;

	/**
	 * Creating FnsInv0124Event's object.
	 */
	public FnsInv0124Event() {}

	/**
	 * @return the dhlInputVO
	 */
	public DHLInputVO getDhlInputVO() {
		return dhlInputVO;
	}

	/**
	 * @param dhlInputVO the dhlInputVO to set
	 */
	public void setDhlInputVO(DHLInputVO dhlInputVO) {
		this.dhlInputVO = dhlInputVO;
	}

	/**
	 * @return the dhlInvoiceEdiVOs
	 */
	public DHLInvoiceEdiVO[] getDhlInvoiceEdiVOs() {
		return dhlInvoiceEdiVOs;
	}

	/**
	 * @param dhlInvoiceEdiVOs the dhlInvoiceEdiVOs to set
	 */
	public void setDhlInvoiceEdiVOs(DHLInvoiceEdiVO[] dhlInvoiceEdiVOs) {
		this.dhlInvoiceEdiVOs = dhlInvoiceEdiVOs;
	}
}
