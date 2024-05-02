/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceInquiryBCImpl.java
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

import com.hanjin.apps.alps.exp.spp.plseinvoiceinquiry.invoiceinquiry.integration.InvoiceInquiryDBDAO;
import com.hanjin.apps.alps.exp.spp.plseinvoiceinquiry.invoiceinquiry.vo.PayableInvoiceDataVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-PLSEInvoiceInquiry Business Logic Basic Command implementation<br>
 * - ALPS-PLSEInvoiceInquiry 에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Seong Kwang
 * @see EXP_SPP_0302 EventResponse, InvoiceInquiryBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class InvoiceInquiryBCImpl extends BasicCommandSupport implements InvoiceInquiryBC {

	// Database Access Object
	private transient InvoiceInquiryDBDAO dbDao = null;

	/**
	 * InvoiceInquiryBCImpl 객체 생성<br>
	 * InvoiceInquiryDBDAO 를 생성한다.<br>
	 */
	public InvoiceInquiryBCImpl() {
		dbDao = new InvoiceInquiryDBDAO();
	}

	/**
	 * Rental payable invoice inquiry by Lessee via SPP 조회 <br>
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