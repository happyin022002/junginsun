/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0109Event.java
*@FileTitle : Invoice Search (Pop-Up) _Vietnam
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.10.27 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceListByIFDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueDateVO;


/**
 * FNS_INV_0109 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0109HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jin Park
 * @see FNS_INV_0109HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0109Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceIssueDateVO invoiceIssueDateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ARInvoiceListByIFDateVO[] aRInvoiceListByIFDateVOs = null;

	public FnsInv0109Event(){}
	
	public void setARInvoiceListByIFDateVOS(ARInvoiceListByIFDateVO[] aRInvoiceListByIFDateVOs){
		this. aRInvoiceListByIFDateVOs = aRInvoiceListByIFDateVOs;
	}

	public ARInvoiceListByIFDateVO[] getARInvoiceListByIFDateVOS(){
		return aRInvoiceListByIFDateVOs;
	}

	public InvoiceIssueDateVO getInvoiceIssueDateVO() {
		return invoiceIssueDateVO;
	}

	public void setInvoiceIssueDateVO(InvoiceIssueDateVO invoiceIssueDateVO) {
		this.invoiceIssueDateVO = invoiceIssueDateVO;
	}

}