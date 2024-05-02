/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0065Event.java
*@FileTitle : (Vietnam) Invoice History Inquiry 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.10.26 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceListByIFDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIEActInvoiceVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0065 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0065HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jin Park
 * @see FNS_INV_0065HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0065Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceIssueDateVO invoiceIssueDateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ARInvoiceListByIFDateVO[] aRInvoiceListByIFDateVOs = null;

	/** Table Value Object Multi Data 처리 */
	private VIEActInvoiceVO[] vieActInvoiceVOs = null;
	
	public FnsInv0065Event(){}
	
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

	public VIEActInvoiceVO[] getVieActInvoiceVOs() {
		return vieActInvoiceVOs;
	}

	public void setVieActInvoiceVOs(VIEActInvoiceVO[] vieActInvoiceVOs) {
		this.vieActInvoiceVOs = vieActInvoiceVOs;
	}

}