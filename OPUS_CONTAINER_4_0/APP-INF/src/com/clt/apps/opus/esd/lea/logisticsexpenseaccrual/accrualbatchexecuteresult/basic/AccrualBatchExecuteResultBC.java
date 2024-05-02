/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualBatchExecuteResultBC.java
*@FileTitle : Rev.VVD Inquiry (Pop-up)
*Open Issues :
*Change history : 
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.basic;

import java.util.List;

import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualAccountCodeVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchExecuteResultHistoryListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultAccountListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultBookingListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultContainerTPSZListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultExecuteMonthListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultInvoiceInquiryVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultOfficeListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultRevenueMonthListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualRevenueVVDCodeListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchCostCodeListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchCostTypeCodeComboListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchSubCostTypeCodeComboListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SearchParameterAccrualEmailSettingVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;



/**
 * ALPS-LogisticsExpenseAccrual Business Logic Command Interface<br>
 * - The interface of the business logic about ALPS-LogisticsExpenseAccrual<br>
 *
 * @author 
 * @see Esd_lea_0901EventResponse 
 * @since J2EE 1.6
 */
 
public interface AccrualBatchExecuteResultBC {
	
	/**
	 * Inquiring the list of the cost code<br>
	 * 
	 * @param SearchCostCodeListVO	searchCostCodeListVO
	 * @return List<SearchCostCodeListVO>
	 * @exception EventException
	 */
	public List<SearchCostCodeListVO> searchCostCodeList(SearchCostCodeListVO searchCostCodeListVO) throws EventException;
	
	/**
	 * Inquiring the list of the cost type code to make the combo box.<br>
	 * 
	 * @param SearchCostTypeCodeComboListVO searchCostTypeCodeComboListVO
	 * @return List<SearchCostTypeCodeComboListVO>
	 * @exception EventException
	 */
	public List<SearchCostTypeCodeComboListVO> searchCostTypeCodeComboList(SearchCostTypeCodeComboListVO searchCostTypeCodeComboListVO) throws EventException;
	
	/**
	 * Inquiring the list of the sub-cost type code to make the combo box.<br>
	 * 
	 * @param SearchSubCostTypeCodeComboListVO searchSubCostTypeCodeComboListVO
	 * @return List<SearchSubCostTypeCodeComboListVO>
	 * @exception EventException
	 */
	public List<SearchSubCostTypeCodeComboListVO> searchSubCostTypeCodeComboList(SearchSubCostTypeCodeComboListVO searchSubCostTypeCodeComboListVO) throws EventException;
	
	/**
	 * Inquiring the list of the Account Code.<br>
	 * 
	 * @param SearchAccrualAccountCodeVO	searchAccrualAccountCodeVO
	 * @return List<SearchAccrualAccountCodeVO>
	 * @exception EventException
	 */
	public List<SearchAccrualAccountCodeVO> searchAccrualAccountCodeList(SearchAccrualAccountCodeVO searchAccrualAccountCodeVO) throws EventException;
	
	/**
	 * Inquiring the list of the revenue VVD code.<br>
	 * 
	 * @param SearchAccrualRevenueVVDCodeListVO	searchAccrualRevenueVVDCodeListVO
	 * @return List<SearchAccrualRevenueVVDCodeListVO>
	 * @exception EventException
	 */
	public List<SearchAccrualRevenueVVDCodeListVO> searchAccrualRevenueVVDCodeList(SearchAccrualRevenueVVDCodeListVO searchAccrualRevenueVVDCodeListVO) throws EventException;
	
	
	/**
	 * Inquiring the booking list of the accrual batch result.<br>
	 * 
	 * @param SearchAccrualBatchResultBookingListVO	searchAccrualBatchResultBookingListVO
	 * @return List<SearchAccrualBatchResultBookingListVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchResultBookingListVO> searchAccrualBatchResultBookingList(SearchAccrualBatchResultBookingListVO searchAccrualBatchResultBookingListVO) throws EventException;
	
	/**
	 * Inquiring the container list of the accrual batch result.<br>
	 * 
	 * @param SearchAccrualBatchResultContainerTPSZListVO	searchAccrualBatchResultContainerTPSZListVO
	 * @return List<SearchAccrualBatchResultContainerTPSZListVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchResultContainerTPSZListVO> searchAccrualBatchResultContainerTPSZList(SearchAccrualBatchResultContainerTPSZListVO searchAccrualBatchResultContainerTPSZListVO) throws EventException;
	
	/**
	 * Inquiring the history list of the accrual batch result.<br>
	 * 
	 * @param SearchAccrualBatchExecuteResultHistoryListVO searchAccrualBatchExecuteResultHistoryListVO
	 * @return List<SearchAccrualBatchExecuteResultHistoryListVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchExecuteResultHistoryListVO> searchAccrualBatchExecuteResultHistoryList(SearchAccrualBatchExecuteResultHistoryListVO searchAccrualBatchExecuteResultHistoryListVO) throws EventException;
	
	
	/**
	 * Inquiring the accrual batch result by the revenue month.<br>
	 * 
	 * @param SearchAccrualBatchResultRevenueMonthListVO	searchAccrualBatchResultRevenueMonthListVO
	 * @return List<SearchAccrualBatchResultRevenueMonthListVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchResultRevenueMonthListVO> searchAccrualBatchResultRevenueMonthList(SearchAccrualBatchResultRevenueMonthListVO searchAccrualBatchResultRevenueMonthListVO) throws EventException;
	
	
	/**
	 * Inquiring the result of the accrual batch by the executing month.<br>
	 * 
	 * @param SearchAccrualBatchResultExecuteMonthListVO	searchAccrualBatchResultExecuteMonthListVO
	 * @return List<SearchAccrualBatchResultExecuteMonthListVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchResultExecuteMonthListVO> searchAccrualBatchResultExecuteMonthList(SearchAccrualBatchResultExecuteMonthListVO searchAccrualBatchResultExecuteMonthListVO) throws EventException;
	
	
	/**
	 * Inquiring the result of the accrual batch by the office.<br>
	 * 
	 * @param SearchAccrualBatchResultOfficeListVO	searchAccrualBatchResultOfficeListVO
	 * @return List<SearchAccrualBatchResultOfficeListVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchResultOfficeListVO> searchAccrualBatchResultOfficeList(SearchAccrualBatchResultOfficeListVO searchAccrualBatchResultOfficeListVO) throws EventException;
	
	
	/**
	 * Inquiring the invoice information.<br>
	 * 
	 * @param SearchAccrualBatchResultInvoiceInquiryVO searchAccrualBatchResultInvoiceInquiryVO
	 * @return List<SearchAccrualBatchResultInvoiceInquiryVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchResultInvoiceInquiryVO> searchAccrualBatchResultInvoiceInquiry(SearchAccrualBatchResultInvoiceInquiryVO searchAccrualBatchResultInvoiceInquiryVO) throws EventException;
	

	/** 
	 * Inquiring the account list of the accrual batch result<br>
	 * 
	 * @param e Event
	 * @return response ESD_LEA_002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAccrualBatchResultAccountList(Event e) throws EventException;
	
	
	/**
	 * Inquiring the manual input list of the accrual batch result.<br>
	 * 
	 * @param e Event
	 * @return response ESD_LEA_002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAccrualBatchResultManualInputList(Event e) throws EventException;
	
	
	/**
	 * Modifying the account confirm of the accrual batch result.<br>
	 * 
	 * @param Event e
	 * @param SignOnUserAccount account
	 * @return response ESD_LEA_002EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyAccrualBatchResultAccountConfirm(Event e, SignOnUserAccount account) throws EventException;
	
	
	
	//public EventResponse getAccrualBatchExecuteSearchMonth() throws EventException;
	
	/**
	 * Modifying the manual input of the accrual batch result.<br>
	 * 
	 * @param Event e
	 * @param SignOnUserAccount account
	 * @return response ESD_LEA_002EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyAccrualBatchResultManualInput(Event e, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Inquiring Accrual Condition Item Flags<br>
	 * 
	 * @param e Event
	 * @return response ESD_LEA_002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAccrualConditionItemFlags(Event e) throws EventException;
}

