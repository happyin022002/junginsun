/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0067Event.java
*@FileTitle : Invoice Detail Inquiry by Date & Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.07.16 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceInquiryInPutVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceDetailListVO;


/**
 * FNS_INV_0067 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0067HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Dong Hoon
 * @see FNS_INV_0067HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0067Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceDetailListVO invoiceDetailListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvoiceDetailListVO[] invoiceDetailListVOs = null;
	
	private String pageType = null;	
	
	private ARInvoiceInquiryInPutVO aRInvoiceInquiryInPutVO = null;

	public FnsInv0067Event(){}
	
	public void setInvoiceDetailListVO(InvoiceDetailListVO invoiceDetailListVO){
		this. invoiceDetailListVO = invoiceDetailListVO;
	}

	public void setInvoiceDetailListVOS(InvoiceDetailListVO[] invoiceDetailListVOs){
		this. invoiceDetailListVOs = invoiceDetailListVOs;
	}

	public InvoiceDetailListVO getInvoiceDetailListVO(){
		return invoiceDetailListVO;
	}

	public InvoiceDetailListVO[] getInvoiceDetailListVOS(){
		return invoiceDetailListVOs;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	public ARInvoiceInquiryInPutVO getARInvoiceInquiryInPutVO() {
		return aRInvoiceInquiryInPutVO;
	}

	public void setARInvoiceInquiryInPutVO(
			ARInvoiceInquiryInPutVO invoiceInquiryInPutVO) {
		aRInvoiceInquiryInPutVO = invoiceInquiryInPutVO;
	}

}