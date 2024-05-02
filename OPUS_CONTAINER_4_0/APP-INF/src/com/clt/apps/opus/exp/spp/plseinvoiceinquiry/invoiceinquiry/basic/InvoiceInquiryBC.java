/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceInquiryBC.java
*@FileTitle : Rental payable invoice inquiry by Lessee via SPP
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.exp.spp.plseinvoiceinquiry.invoiceinquiry.basic;

import java.util.List;

import com.clt.apps.opus.exp.spp.plseinvoiceinquiry.invoiceinquiry.vo.PayableInvoiceDataVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * ALPS-PLSEInvoiceInquiry Business Logic Command Interface<br>
 * - The interface of the business logic about ALPS-PLSEInvoiceInquiry<br>
 *
 * @author 
 * @see Exp_Spp_0302EventResponse 
 * @since J2EE 1.6
 */

public interface InvoiceInquiryBC {
	
	/**
	 * Retrieving Rental payable invoice inquiry by Lessee via SPP<br>
	 * 
	 * @param PayableInvoiceDataVO payableInvoiceDataVO
	 * @return List<PayableInvoiceDataVO>
	 * @exception EventException
	 */
	public List<PayableInvoiceDataVO> searchPayableInvoiceBasic(PayableInvoiceDataVO payableInvoiceDataVO) throws EventException;	

}