/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceivableRentalCostBC.java
*@FileTitle : EQ Receivable Charge Summary By Charge Type
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.basic;

import java.util.List;

import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableChargeVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceCostVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceInquiryVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.ReportSearchReceivableVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.SearchParamVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Containerrentalcost Business Logic Command Interface<br>
 *
 * @author 
 * @see Ees_lse_0074EventResponse 
 * @since J2EE 1.6
 */

public interface ReceivableRentalCostBC {

	/**
	 * retrieving for Receivable Invoice<br>
	 *
	 * @param  ReportSearchReceivableVO reportSearchReceivableVO
	 * @return List<ReportSearchReceivableVO>
	 * @exception EventException
	 */
	public List<ReportSearchReceivableVO> searchReceivableRentalReportBasic(ReportSearchReceivableVO reportSearchReceivableVO) throws EventException;

	/**
	 * checking Receivable Rental Charge execution<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isExecuteReceivableRentalChargeBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * retrieving for Receivable Rental Charge list<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableChargeVO>
	 * @exception EventException
	 */
	public List<ReceivableChargeVO> searchReceivableRentalChargeListBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * creating Receivable Rental Preparation list<br>
	 *
	 * @param SearchParamVO searchParamVO
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void createReceivableRentalPreparationListBasic(SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException;

	/**
	 * creating Receivable Rental Charge Creation list<br>
	 *
	 * @param ReceivableChargeVO[] receivableChargeVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void manageReceivableChargeCreationListBasic(ReceivableChargeVO[] receivableChargeVOs, SignOnUserAccount userAccount) throws EventException;

	/**
	 * creating Receivable Rental Charge Recreation list<br>
	 *
	 * @param ReceivableChargeVO[] receivableChargeVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void manageReceivableChargeRecreationListBasic(ReceivableChargeVO[] receivableChargeVOs, SignOnUserAccount userAccount) throws EventException;

	/**
	 * retrieving for Receivable Rental Charge (Re)Creation<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableChargeVO>
	 * @exception EventException
	 */
	public List<ReceivableChargeVO> searchReceivableRentalChargeInfoBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * retrieving for new Receivable Rental Invoice Number<br>
	 *
	 * @param  String qtyYrmon
	 * @return String
	 * @exception EventException
	 */
	public String searchNewReceivableInvoiceNumberBasic(String qtyYrmon) throws EventException;

	/**
	 * retrieving for Receivable Charge avail<br>
	 *
	 * @param  String agmtSeq
	 * @param  String qtyYrmon
	 * @return List<ReceivableChargeVO>
	 * @exception EventException
	 */
	public List<ReceivableChargeVO> searchReceivableAgreementAvailInfoBasic(String agmtSeq, String qtyYrmon) throws EventException;

	/**
	 * retrieving for Receivable Rental Invoice Summary <br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableInvoiceVO>
	 * @exception EventException
	 */
	public List<ReceivableInvoiceVO> searchReceivableInvoiceSummaryListBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * retrieving for Receivable Rental Invoice Amount <br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableInvoiceVO>
	 * @exception EventException
	 */
	public List<ReceivableInvoiceVO> searchReceivableInvoiceAmountInfoBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * creating Receivable Rental Invoice Confirm by agreement No.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ARInterfaceCreationVO>
	 * @exception EventException
	 */
	public List<ARInterfaceCreationVO> searchGeneralARInterfaceCreationBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * creating Receivable Rental Invoice Creation by agreement No.<br>
	 *
	 * @param  ReceivableInvoiceVO[] receivableInvoiceVOs
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void createReceivableInvoiceCreationListBasic(ReceivableInvoiceVO[] receivableInvoiceVOs, SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException;

	/**
	 * creating Receivable Rental Invoice Confirm by agreement No.<br>
	 *
	 * @param  ReceivableInvoiceVO[] receivableInvoiceVOs
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void createReceivableInvoiceConfirmListBasic(ReceivableInvoiceVO[] receivableInvoiceVOs, SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException;

	/**
	 * retrieving for Receivable Rental Invoice Cost<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableInvoiceCostVO>
	 * @exception EventException
	 */
	public List<ReceivableInvoiceCostVO> searchReceivableInvoiceCostListBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * saving Receivable Rental Invoice Cost<br>
	 *
	 * @param ReceivableInvoiceCostVO[] receivableInvoiceCostVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void manageReceivableInvoiceCostListBasic(ReceivableInvoiceCostVO[] receivableInvoiceCostVOs, SignOnUserAccount userAccount) throws EventException;

	/**
	 * retrieving for Receivable Rental Invoice Charge I/F<br>
	 *
	 * @param SearchParamVO searchParamVO
	 * @return List<ReceivableInvoiceInquiryVO>
	 * @exception EventException
	 */
	public List<ReceivableInvoiceInquiryVO> searchReceivableInvoiceInquiryListBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * retrieving for Invoice Cancel & trasnforming Account Receivable I/F <br>
	 *
	 * @param  ReceivableInvoiceInquiryVO receivableInvoiceInquiryVO
	 * @return List<ARInterfaceCreationVO>
	 * @exception EventException
	 */
	public List<ARInterfaceCreationVO> searchGeneralARInterfaceCancelBasic(ReceivableInvoiceInquiryVO receivableInvoiceInquiryVO) throws EventException;

	/**
	 * canceling Receivable Rental Invoice Charge I/F<br>
	 *
	 * @param ReceivableInvoiceInquiryVO receivableInvoiceInquiryVO
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void cancelReceivableInvoiceInquiryBasic(ReceivableInvoiceInquiryVO receivableInvoiceInquiryVO, SignOnUserAccount userAccount) throws EventException;
	
	
	/**
	 * 
	 * @param qtyYrMon
	 * @param userAccount
	 * @return String
	 * @throws EventException
	 */
	public String createReceivableInvoiceChargeCreationBatchService(String qtyYrMon, SignOnUserAccount userAccount) throws EventException;

}