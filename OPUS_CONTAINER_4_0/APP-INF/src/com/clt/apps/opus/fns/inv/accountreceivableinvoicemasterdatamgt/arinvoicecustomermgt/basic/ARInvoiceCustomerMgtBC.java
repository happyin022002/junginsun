/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ARInvoiceCustomerMgtBC.java
 *@FileTitle : Customer Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.basic;

import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.PopCustomerListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.PriCustomerListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.SearchCustomerVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CreditCustomerVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * AccountReceivableInvoiceMasterDataMgt Business Logic Basic Command implementation<br>
 * - AccountReceivableInvoiceMasterDataMgt logic process<br>
 * 
 * @author saeil kim
 * @see FNS_INV_0014EventResponse,ARInvoiceCustomerMgtBC
 * @since J2EE 1.4
 */
public interface ARInvoiceCustomerMgtBC {

	/**
	 * Retrieve event process<br>
	 * ARInvoiceCustomerMgt screen retrieve event process<br>
	 * 
	 * @param SearchCustomerVO searchCustomerVO
	 * @return int
	 * @exception EventException
	 */
	public int searchCustomerListCnt(SearchCustomerVO searchCustomerVO) throws EventException;

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
	public CreditCustomerVO searchCreditCustomer(String country, String cust, String regNo) throws EventException;

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
	public List<PopCustomerListVO> searchPopCustomerList(String cntry, String custNm, String zipNo, String chkNm, String custRgstNo) throws EventException;

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
	public List<PriCustomerListVO> searchRFACustomerList(String rfaNo) throws EventException;

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
	public List<PriCustomerListVO> searchSCCustomerList(String scNo) throws EventException;
}