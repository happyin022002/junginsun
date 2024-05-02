/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0141Event.java
*@FileTitle : (NYCRA)Invoice Inquiry by Issue Date/E-mail sent result
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.03
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.06.01 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NYCInvoiceIssueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueDateVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0054 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0054HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jin Park
 * @see FNS_INV_0054HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0141Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceIssueDateVO invoiceIssueDateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private NYCInvoiceIssueDateVO[] invoiceIssueDateVOs = null;

	public FnsInv0141Event(){}
	
	public void setInvoiceIssueDateVO(InvoiceIssueDateVO invoiceIssueDateVO){
		this. invoiceIssueDateVO = invoiceIssueDateVO;
	}

	public void setInvoiceIssueDateVOS(NYCInvoiceIssueDateVO[] invoiceIssueDateVOs){
		if(invoiceIssueDateVOs != null){
			NYCInvoiceIssueDateVO[] tmpVOs = new NYCInvoiceIssueDateVO[invoiceIssueDateVOs.length];
			System.arraycopy(invoiceIssueDateVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invoiceIssueDateVOs = tmpVOs;
		}
	}

	public InvoiceIssueDateVO getInvoiceIssueDateVO(){
		return invoiceIssueDateVO;
	}

	public NYCInvoiceIssueDateVO[] getInvoiceIssueDateVOS(){
		NYCInvoiceIssueDateVO[] rtnVOs = null;
		if (this.invoiceIssueDateVOs != null) {
			rtnVOs = new NYCInvoiceIssueDateVO[invoiceIssueDateVOs.length];
			System.arraycopy(invoiceIssueDateVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}