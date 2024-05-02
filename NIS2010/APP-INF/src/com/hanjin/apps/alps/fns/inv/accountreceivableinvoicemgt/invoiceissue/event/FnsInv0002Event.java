/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0002Event.java
*@FileTitle : (China) Tax Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.08.18 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.TaxInquiryVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.TaxInvoiceVO;


/**
 * FNS_INV_0002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Dong Hoon
 * @see FNS_INV_0002HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TaxInvoiceVO taxInvoiceVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TaxInvoiceVO[] taxInvoiceVOs = null;

	private TaxInquiryVO taxInquiryVO = null;
	
	public FnsInv0002Event(){}
	
	public void setTaxInvoiceVO(TaxInvoiceVO taxInvoiceVO){
		this. taxInvoiceVO = taxInvoiceVO;
	}

	public void setTaxInvoiceVOS(TaxInvoiceVO[] taxInvoiceVOs){
		this. taxInvoiceVOs = taxInvoiceVOs;
	}

	public TaxInvoiceVO getTaxInvoiceVO(){
		return taxInvoiceVO;
	}

	public TaxInvoiceVO[] getTaxInvoiceVOS(){
		return taxInvoiceVOs;
	}

	public TaxInquiryVO getTaxInquiryVO() {
		return taxInquiryVO;
	}

	public void setTaxInquiryVO(TaxInquiryVO taxInquiryVO) {
		this.taxInquiryVO = taxInquiryVO;
	}

}