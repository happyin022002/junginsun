/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt5002Event.java
*@FileTitle : Invoice Interface to A/R 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.10.09 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARParmVO;


/**
 * EES_DMT_5002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_5002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Sung Hwan
 * @see EES_DMT_5002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt5002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceInterfaceARParmVO invoiceInterfaceARParmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvoiceInterfaceARParmVO[] invoiceInterfaceARParmVOs = null;

	public EesDmt5002Event(){}
	
	public void setInvoiceInterfaceARParmVO(InvoiceInterfaceARParmVO invoiceInterfaceARParmVO){
		this. invoiceInterfaceARParmVO = invoiceInterfaceARParmVO;
	}

	public void setInvoiceInterfaceARParmVOS(InvoiceInterfaceARParmVO[] invoiceInterfaceARParmVOs){
		this. invoiceInterfaceARParmVOs = invoiceInterfaceARParmVOs;
	}

	public InvoiceInterfaceARParmVO getInvoiceInterfaceARParmVO(){
		return invoiceInterfaceARParmVO;
	}

	public InvoiceInterfaceARParmVO[] getInvoiceInterfaceARParmVOS(){
		return invoiceInterfaceARParmVOs;
	}

}