/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ARInvoiceCustomerMgtBCImpl.java
 *@FileTitle : Customer Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.basic;

import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration.ARInvoiceCustomerMgtDBDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.PopCustomerListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.PriCustomerListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.SearchCustomerVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CreditCustomerVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * AccountReceivableInvoiceMasterDataMgt Business Logic Basic Command implementation<br>
 * - AccountReceivableInvoiceMasterDataMgt logic process<br>
 * 
 * @author saeil kim
 * @see FNS_INV_0014EventResponse,ARInvoiceCustomerMgtBC
 * @since J2EE 1.4
 */
public class ARInvoiceCustomerMgtBCImpl extends BasicCommandSupport implements ARInvoiceCustomerMgtBC {

	// Database Access Object
	private transient ARInvoiceCustomerMgtDBDAO dbDao = null;

	/**
	 * ARInvoiceCustomerMgtBCImpl object creation.<br>
	 * ARInvoiceCustomerMgtDBDAO creation.<br>
	 */
	public ARInvoiceCustomerMgtBCImpl() {
		dbDao = new ARInvoiceCustomerMgtDBDAO();
	}

	/**
	 * Retrieve event process<br>
	 * ARInvoiceCustomerMgt screen retrieve event process<br>
	 * 
	 * @param SearchCustomerVO searchCustomerVO
	 * @return int
	 * @exception EventException
	 */
	public int searchCustomerListCnt(SearchCustomerVO searchCustomerVO) throws EventException {
		int cnt = 0;
		try {
			cnt = dbDao.searchCustomerListCnt(searchCustomerVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

		return cnt;
	}

	/**
	 * Retrieve event process<br>
	 * Basic information and credit information retrieve.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String country
	 * @param String cust
	 * @param String regNo
	 * @return CreditCustomerVO
	 * @exception EventException
	 */
	public CreditCustomerVO searchCreditCustomer(String country, String cust, String regNo) throws EventException {

		CreditCustomerVO creditCustomerVO = null;
		try {
			creditCustomerVO = dbDao.searchCreditCustomer(country, cust, regNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

		return creditCustomerVO;
	}

	/**
	 * Retrieve event process<br>
	 * Customer information retrieve.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String cntry
	 * @param String custNm
	 * @param String zipNo
	 * @param String chkNm
	 * @param String custRgstNo
	 * @return List<PopCustomerListVO>
	 * @exception EventException
	 */
	public List<PopCustomerListVO> searchPopCustomerList(String cntry, String custNm, String zipNo, String chkNm, String custRgstNo) throws EventException {
		int cnt = 0;
		List<PopCustomerListVO> resultVOs = null;
		try {
			resultVOs = dbDao.searchPopCustomerList(cntry, custNm, zipNo, chkNm, custRgstNo);
			if (resultVOs.size() > 0) {
				resultVOs.get(0).setMaxRows(cnt);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return resultVOs;
	}

	/**
	 * Retrieve event process<br>
	 * ARInvoiceCustomerMgt screen retrieve event process<br>
	 * FNS_INV_0090
	 * 
	 * @author saeil
	 * @param String rfaNo
	 * @return List<PriCustomerListVO>
	 * @exception EventException
	 */
	public List<PriCustomerListVO> searchRFACustomerList(String rfaNo) throws EventException {
		int cnt = 0;
		List<PriCustomerListVO> resultVOs = null;
		try {
			resultVOs = dbDao.searchRFACustomerList(rfaNo);
			if (resultVOs.size() > 0) {
				resultVOs.get(0).setMaxRows(cnt);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

		return resultVOs;
	}

	/**
	 * Retrieve event process<br>
	 * ARInvoiceCustomerMgt screen retrieve event process<br>
	 * FNS_INV_0091
	 * 
	 * @author saeil
	 * @param String scNo
	 * @return List<PriCustomerListVO>
	 * @exception EventException
	 */
	public List<PriCustomerListVO> searchSCCustomerList(String scNo) throws EventException {
		int cnt = 0;
		List<PriCustomerListVO> resultVOs = null;
		try {
			resultVOs = dbDao.searchSCCustomerList(scNo);
			if (resultVOs.size() > 0) {
				resultVOs.get(0).setMaxRows(cnt);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

		return resultVOs;
	}

	
}