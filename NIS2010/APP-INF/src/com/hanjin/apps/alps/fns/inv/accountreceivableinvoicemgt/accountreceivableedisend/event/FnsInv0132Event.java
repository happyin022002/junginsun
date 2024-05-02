/**
 * Copyright(c) 2012 CyberLogitec
 * @FileName : FnsInv0132Event.java
 * @FileTitle : EDI Submission(Philips)
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2012.12.02
 * @LastModifier : 9011620
 * @LastVersion : 1.0
 * 1.0 Creation 2012.12.02 9011620.
 */
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.PHILSInvoiceEdiVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * DHL EDI에 대한 parameter value object.
 * 
 * @author 9011620
 * @see 각 DAO Class 참조.
 * @since J2EE 1.4
 */
public class FnsInv0132Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private DHLInputVO inputVo = null;

	private PHILSInvoiceEdiVO philipsVo[] = null;

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
	 * @return the philipsVo
	 */
	public PHILSInvoiceEdiVO[] getPhilipsVo() {
		return philipsVo;
	}
	
	/**
	 * @param philipsVo the philipsVo to set
	 */
	public void setPhilipsVo(PHILSInvoiceEdiVO[] philipsVo) {
		this.philipsVo = philipsVo;
	}
}
