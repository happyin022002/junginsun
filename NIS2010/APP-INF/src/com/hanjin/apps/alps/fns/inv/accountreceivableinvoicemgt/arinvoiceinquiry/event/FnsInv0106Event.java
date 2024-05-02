/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0106Event.java
*@FileTitle : Invoice Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.08.10 정휘택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceIssueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueDateVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0106 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0106HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Hwi Taek
 * @see FNS_INV_0106HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0106Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceIssueDateVO invoiceIssueDateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ARInvoiceIssueDateVO[] invoiceIssueDateVOs = null;

	public FnsInv0106Event(){}
	
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