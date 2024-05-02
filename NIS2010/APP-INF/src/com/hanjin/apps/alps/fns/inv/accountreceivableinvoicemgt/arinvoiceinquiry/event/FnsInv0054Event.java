/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0054Event.java
*@FileTitle : Invoice Inquiry by Issue Date
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.06.01 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceIssueDateVO;
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

public class FnsInv0054Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceIssueDateVO invoiceIssueDateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ARInvoiceIssueDateVO[] invoiceIssueDateVOs = null;

	public FnsInv0054Event(){}
	
	public void setInvoiceIssueDateVO(InvoiceIssueDateVO invoiceIssueDateVO){
		this. invoiceIssueDateVO = invoiceIssueDateVO;
	}

	public void setInvoiceIssueDateVOS(ARInvoiceIssueDateVO[] invoiceIssueDateVOs){
		this. invoiceIssueDateVOs = invoiceIssueDateVOs;
	}

	public InvoiceIssueDateVO getInvoiceIssueDateVO(){
		return invoiceIssueDateVO;
	}

	public ARInvoiceIssueDateVO[] getInvoiceIssueDateVOS(){
		return invoiceIssueDateVOs;
	}

}