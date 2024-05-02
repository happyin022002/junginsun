/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpSpp0302Event.java
*@FileTitle : Rental payable invoice inquiry by Lessee via SPP
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.08.18 김성광
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.exp.spp.plseinvoiceinquiry.invoiceinquiry.event;

import com.hanjin.apps.alps.exp.spp.plseinvoiceinquiry.invoiceinquiry.vo.PayableInvoiceDataVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EXP_SPP_0302 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EXP_SPP_0302HTMLAction 에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Seong Kwang
 * @see EXP_SPP_0302HTMLAction 참조
 * @since J2EE 1.6 
 */

public class ExpSpp0302Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PayableInvoiceDataVO payableInvoiceDataVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PayableInvoiceDataVO[] payableInvoiceDataVOs = null;		
	
	public ExpSpp0302Event(){}
	
	public void setPayableInvoiceDataVO(PayableInvoiceDataVO payableInvoiceDataVO){
		this. payableInvoiceDataVO = payableInvoiceDataVO;
	}

	public void setPayableInvoiceDataVOS(PayableInvoiceDataVO[] payableInvoiceDataVOs){
		this. payableInvoiceDataVOs = payableInvoiceDataVOs;
	}	

	public PayableInvoiceDataVO getPayableInvoiceDataVO(){
		return payableInvoiceDataVO;
	}

	public PayableInvoiceDataVO[] getPayableInvoiceDataVOS(){
		return payableInvoiceDataVOs;
	}

}