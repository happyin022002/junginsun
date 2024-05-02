/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv001101Event.java
*@FileTitle : Invoice Inquiry by I/F No - General
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceCorrectionVO;


/**
 * FNS_INV_0011_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0011_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0011_01HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv001101Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private  ARInvoiceCorrectionVO  invoiceCorrectionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private  ARInvoiceCorrectionVO[]  invoiceCorrectionVOs = null;

	public FnsInv001101Event(){}
	
	public void setARInvoiceCorrectionVO( ARInvoiceCorrectionVO  invoiceCorrectionVO){
		this.  invoiceCorrectionVO =  invoiceCorrectionVO;
	}

	public void setARInvoiceCorrectionVOS( ARInvoiceCorrectionVO[]  invoiceCorrectionVOs){
		this.  invoiceCorrectionVOs =  invoiceCorrectionVOs;
	}

	public  ARInvoiceCorrectionVO getARInvoiceCorrectionVO(){
		return  invoiceCorrectionVO;
	}

	public  ARInvoiceCorrectionVO[] getARInvoiceCorrectionVOS(){
		return  invoiceCorrectionVOs;
	}

}