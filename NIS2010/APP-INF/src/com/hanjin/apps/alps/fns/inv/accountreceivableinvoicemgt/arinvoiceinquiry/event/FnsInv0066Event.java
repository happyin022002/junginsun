/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0066Event.java
*@FileTitle : Invoice Summary Inquiry by Date & Source
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.29 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceInquiryInPutVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceSummaryListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0066 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0066HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jin Park
 * @see FNS_INV_0066HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0066Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ARInvoiceInquiryInPutVO invoiceInquiryInPutVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvoiceSummaryListVO[] invoiceSummaryListVOs = null;
	
	private String pageType = null;	

	public FnsInv0066Event(){}
	
	public void setInvoiceSummaryListVOS(InvoiceSummaryListVO[] invoiceSummaryListVOs){
		this. invoiceSummaryListVOs = invoiceSummaryListVOs;
	}

	public InvoiceSummaryListVO[] getInvoiceSummaryListVOS(){
		return invoiceSummaryListVOs;
	}

	public ARInvoiceInquiryInPutVO getInvoiceInquiryInPutVO() {
		return invoiceInquiryInPutVO;
	}

	public void setInvoiceInquiryInPutVO(ARInvoiceInquiryInPutVO invoiceInquiryInPutVO) {
		this.invoiceInquiryInPutVO = invoiceInquiryInPutVO;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
}