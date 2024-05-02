/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0058Event.java
*@FileTitle : Invoice Issue Term Analysis
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceTermAnalysisInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceTermAnalysisVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0058 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0058HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0058HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0058Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private  InvoiceTermAnalysisInputVO  invoiceTermAnalysisInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private  InvoiceTermAnalysisVO[]  invoiceTermAnalysisVOs = null;

	public FnsInv0058Event(){}
	
	public void setInvoiceTermAnalysisVOS( InvoiceTermAnalysisVO[]  invoiceTermAnalysisVOs){
		this.  invoiceTermAnalysisVOs =  invoiceTermAnalysisVOs;
	}
	
	public  InvoiceTermAnalysisVO[] getInvoiceTermAnalysisVOS(){
		return  invoiceTermAnalysisVOs;
	}

	public InvoiceTermAnalysisInputVO getInvoiceTermAnalysisInputVO() {
		return invoiceTermAnalysisInputVO;
	}

	public void setInvoiceTermAnalysisInputVO(InvoiceTermAnalysisInputVO invoiceTermAnalysisInputVO) {
		this.invoiceTermAnalysisInputVO = invoiceTermAnalysisInputVO;
	}
}