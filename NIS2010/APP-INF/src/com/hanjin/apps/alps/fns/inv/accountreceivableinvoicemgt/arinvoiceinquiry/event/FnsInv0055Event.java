/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0055Event.java
*@FileTitle : Invoice Issue Report by Date (for TVA)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.06.03 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueListInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueTVAListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0055 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0055HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jin Park
 * @see FNS_INV_0055HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0055Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceIssueListInputVO invoiceIssueListInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvoiceIssueTVAListVO[] invoiceIssueTVAListVOS = null;

	public FnsInv0055Event(){}
	
	public void setInvoiceIssueListInputVO(InvoiceIssueListInputVO invoiceIssueListInputVO){
		this. invoiceIssueListInputVO = invoiceIssueListInputVO;
	}

	public void setInvoiceIssueTVAListVOS(InvoiceIssueTVAListVO[] invoiceIssueTVAListVOS){
		this. invoiceIssueTVAListVOS = invoiceIssueTVAListVOS;
	}

	public InvoiceIssueListInputVO getInvoiceIssueListInputVO(){
		return invoiceIssueListInputVO;
	}

	public InvoiceIssueTVAListVO[] getInvoiceIssueTVAListVOS(){
		return invoiceIssueTVAListVOS;
	}

}