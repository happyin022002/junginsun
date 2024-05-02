/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceInquiryBCImpl.java
*@FileTitle : Rental payable invoice inquiry by Lessee via SPP
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.exp.spp.plseinvoiceinquiry.invoiceinquiry.basic;

import java.util.List;

import com.clt.apps.opus.exp.spp.plseinvoiceinquiry.invoiceinquiry.integration.InvoiceInquiryDBDAO;
import com.clt.apps.opus.exp.spp.plseinvoiceinquiry.invoiceinquiry.vo.PayableInvoiceDataVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-PLSEInvoiceInquiry Business Logic Basic Command implementation<br>
 * - Handling the business logic of ALPS-PLSEInvoiceInquiry<br>
 *
 * @author
 * @see EXP_SPP_0302 EventResponse, InvoiceInquiryBC, refers DAO classes
 * @since J2EE 1.6
 */
public class InvoiceInquiryBCImpl extends BasicCommandSupport implements InvoiceInquiryBC {

	// Database Access Object
	private transient InvoiceInquiryDBDAO dbDao = null;

	/**
	 * The constructor of this class<br>
	 * Creating InvoiceInquiryDBDAO class<br>
	 */
	public InvoiceInquiryBCImpl() {
		dbDao = new InvoiceInquiryDBDAO();
	}

	/**
	 * Retrieving Rental payable invoice inquiry by Lessee via SPP <br>
	 * 
	 * @param PayableInvoiceDataVO payableInvoiceDataVO
	 * @return List<PayableInvoiceDataVO>
	 * @exception EventException
	 */	
	@Override
	public List<PayableInvoiceDataVO> searchPayableInvoiceBasic(
			PayableInvoiceDataVO payableInvoiceDataVO) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchPayableInvoiceData(payableInvoiceDataVO); 
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	
	
	
}