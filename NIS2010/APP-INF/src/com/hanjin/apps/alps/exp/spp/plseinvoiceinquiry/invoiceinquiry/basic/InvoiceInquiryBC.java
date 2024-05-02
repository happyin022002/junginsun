/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceInquiryBC.java
*@FileTitle : Rental payable invoice inquiry by Lessee via SPP
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.08.18 김성광
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.exp.spp.plseinvoiceinquiry.invoiceinquiry.basic;

import java.util.List;

import com.hanjin.apps.alps.exp.spp.plseinvoiceinquiry.invoiceinquiry.vo.PayableInvoiceDataVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-PLSEInvoiceInquiry Business Logic Command Interface<br>
 * - ALPS-PLSEInvoiceInquiry 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Seong Kwang
 * @see Exp_Spp_0302EventResponse 참조
 * @since J2EE 1.6
 */

public interface InvoiceInquiryBC {
	
	/**
	 * Rental payable invoice inquiry by Lessee via SPP 조회<br>
	 * 
	 * @param PayableInvoiceDataVO payableInvoiceDataVO
	 * @return List<PayableInvoiceDataVO>
	 * @exception EventException
	 */
	public List<PayableInvoiceDataVO> searchPayableInvoiceBasic(PayableInvoiceDataVO payableInvoiceDataVO) throws EventException;	

}