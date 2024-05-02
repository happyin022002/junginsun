/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualBatchExecuteResultBCImpl.java
*@FileTitle : Rev.VVD Inquiry (Pop-up)
*Open Issues :
*Change history : 
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.basic;
 
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0002Event;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration.AccrualBatchExecuteResultDBDAO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualAccountCodeVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchExecuteResultHistoryListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultBookingListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultContainerTPSZListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultExecuteMonthListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultInvoiceInquiryVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultManualInputListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultOfficeListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultRevenueMonthListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualRevenueVVDCodeListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchCostCodeListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchCostTypeCodeComboListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchSubCostTypeCodeComboListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-LogisticsExpenseAccrual Business Logic Basic Command implementation<br>
 * - Handling the business logic about ALPS-LogisticsExpenseAccrual<br>
 *
 * @author
 * @see ESD_LEA_0901EventResponse,AccrualBatchExecuteResultBC
 * @since J2EE 1.6
 */ 
public class AccrualBatchExecuteResultBCImpl extends BasicCommandSupport implements AccrualBatchExecuteResultBC {

	// Database Access Object
	private transient AccrualBatchExecuteResultDBDAO dbDao = null;

	/**
	 * Creating AccrualBatchExecuteResultBCImpl class<br>
	 * Creating AccrualBatchExecuteResultDBDAO class<br>
	 */
	public AccrualBatchExecuteResultBCImpl() {
		dbDao = new AccrualBatchExecuteResultDBDAO();
	}
	
	/**
	 * Inquiring the list of the cost code<br>
	 * 
	 * @param SearchCostCodeListVO searchCostCodeListVO
	 * @return List<SearchCostCodeListVO>
	 * @exception EventException
	 */
	public List<SearchCostCodeListVO> searchCostCodeList(SearchCostCodeListVO searchCostCodeListVO) throws EventException {
		try {
			return dbDao.searchCostCodeList(searchCostCodeListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	
	/**
	 * Inquiring the list of the cost type code to make the combo box.<br>
	 * 
	 * @param SearchCostTypeCodeComboListVO searchCostTypeCodeComboListVO
	 * @return List<SearchCostTypeCodeComboListVO>
	 * @exception EventException
	 */
	public List<SearchCostTypeCodeComboListVO> searchCostTypeCodeComboList(SearchCostTypeCodeComboListVO searchCostTypeCodeComboListVO) throws EventException {
		try {
			return dbDao.searchCostTypeCodeComboList(searchCostTypeCodeComboListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * Inquiring the list of the sub-cost type code to make the combo box.<br>
	 * 
	 * @param SearchSubCostTypeCodeComboListVO searchSubCostTypeCodeComboListVO
	 * @return List<SearchSubCostTypeCodeComboListVO>
	 * @exception EventException
	 */
	public List<SearchSubCostTypeCodeComboListVO> searchSubCostTypeCodeComboList(SearchSubCostTypeCodeComboListVO searchSubCostTypeCodeComboListVO) throws EventException {
		try {
			return dbDao.searchSubCostTypeCodeComboList(searchSubCostTypeCodeComboListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * Inquiring the list of the Account Code.<br>
	 * 
	 * @param SearchAccrualAccountCodeVO searchAccrualAccountCodeVO
	 * @return List<SearchAccrualAccountCodeVO>
	 * @exception EventException
	 */
	public List<SearchAccrualAccountCodeVO> searchAccrualAccountCodeList(SearchAccrualAccountCodeVO searchAccrualAccountCodeVO) throws EventException {
		try {
			return dbDao.searchAccrualAccountCodeList(searchAccrualAccountCodeVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * Inquiring the list of the revenue VVD code.<br>
	 * 
	 * @param SearchAccrualRevenueVVDCodeListVO searchAccrualRevenueVVDCodeListVO
	 * @return List<SearchAccrualRevenueVVDCodeListVO>
	 * @exception EventException
	 */
	public List<SearchAccrualRevenueVVDCodeListVO> searchAccrualRevenueVVDCodeList(SearchAccrualRevenueVVDCodeListVO searchAccrualRevenueVVDCodeListVO) throws EventException {
		try {
			return dbDao.searchAccrualRevenueVVDCodeList(searchAccrualRevenueVVDCodeListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	
	/**
	 * Inquiring the booking list of the accrual batch result.<br>
	 * 
	 * @param SearchAccrualBatchResultBookingListVO searchAccrualBatchResultBookingListVO
	 * @return List<SearchAccrualBatchResultBookingListVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchResultBookingListVO> searchAccrualBatchResultBookingList(SearchAccrualBatchResultBookingListVO searchAccrualBatchResultBookingListVO) throws EventException {
		try {
			return dbDao.searchAccrualBatchResultBookingList(searchAccrualBatchResultBookingListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * Inquiring the container list of the accrual batch result.<br>
	 * 
	 * @param SearchAccrualBatchResultContainerTPSZListVO searchAccrualBatchResultContainerTPSZListVO
	 * @return List<SearchAccrualBatchResultContainerTPSZListVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchResultContainerTPSZListVO> searchAccrualBatchResultContainerTPSZList(SearchAccrualBatchResultContainerTPSZListVO searchAccrualBatchResultContainerTPSZListVO) throws EventException {
		try {
			return dbDao.searchAccrualBatchResultContainerTPSZList(searchAccrualBatchResultContainerTPSZListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * Inquiring the history list of the accrual batch result.<br>
	 * 
	 * @param SearchAccrualBatchExecuteResultHistoryListVO searchAccrualBatchExecuteResultHistoryListVO
	 * @return List<SearchAccrualBatchExecuteResultHistoryListVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchExecuteResultHistoryListVO> searchAccrualBatchExecuteResultHistoryList(SearchAccrualBatchExecuteResultHistoryListVO searchAccrualBatchExecuteResultHistoryListVO) throws EventException {
		try {
			return dbDao.searchAccrualBatchExecuteResultHistoryList(searchAccrualBatchExecuteResultHistoryListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * Inquiring the result of the accrual batch by the revenue month.<br>
	 * 
	 * @param SearchAccrualBatchResultRevenueMonthListVO searchAccrualBatchResultRevenueMonthListVO
	 * @return List<SearchAccrualBatchResultRevenueMonthListVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchResultRevenueMonthListVO> searchAccrualBatchResultRevenueMonthList(SearchAccrualBatchResultRevenueMonthListVO searchAccrualBatchResultRevenueMonthListVO) throws EventException {
		try {
			return dbDao.searchAccrualBatchResultRevenueMonthList(searchAccrualBatchResultRevenueMonthListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * Inquiring the result of the accrual batch by the executing month.<br>
	 * 
	 * @param SearchAccrualBatchResultExecuteMonthListVO searchAccrualBatchResultExecuteMonthListVO
	 * @return List<SearchAccrualBatchResultExecuteMonthListVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchResultExecuteMonthListVO> searchAccrualBatchResultExecuteMonthList(SearchAccrualBatchResultExecuteMonthListVO searchAccrualBatchResultExecuteMonthListVO) throws EventException {
		try {
			return dbDao.searchAccrualBatchResultExecuteMonthList(searchAccrualBatchResultExecuteMonthListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * Inquiring the result of the accrual batch by the office.<br>
	 * 
	 * @param SearchAccrualBatchResultOfficeListVO searchAccrualBatchResultOfficeListVO
	 * @return List<SearchAccrualBatchResultOfficeListVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchResultOfficeListVO> searchAccrualBatchResultOfficeList(SearchAccrualBatchResultOfficeListVO searchAccrualBatchResultOfficeListVO) throws EventException {
		try {
			return dbDao.searchAccrualBatchResultOfficeList(searchAccrualBatchResultOfficeListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * Inquiring the invoice information.<br>
	 * 
	 * @param SearchAccrualBatchResultInvoiceInquiryVO searchAccrualBatchResultInvoiceInquiryVO
	 * @return List<SearchAccrualBatchResultInvoiceInquiryVO>
	 * @exception EventException 
	 */
	public List<SearchAccrualBatchResultInvoiceInquiryVO> searchAccrualBatchResultInvoiceInquiry(SearchAccrualBatchResultInvoiceInquiryVO searchAccrualBatchResultInvoiceInquiryVO) throws EventException {
		try {
			return dbDao.searchAccrualBatchResultInvoiceInquiry(searchAccrualBatchResultInvoiceInquiryVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/** 
	 * Inquiring the account list of the accrual batch result<br>
	 * 
	 * @param e Event
	 * @return response ESD_LEA_002EventResponse
	 * @exception EventException
	 */

	public EventResponse searchAccrualBatchResultAccountList(Event e) throws EventException {
		EsdLea0002Event 		event			= (EsdLea0002Event)e;
		DBRowSet 				dbRowSet		= null; 				
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		if(log.isDebugEnabled()){
			log.debug("[AccrualBatchExecuteResultBCImpl searchAccrualBatchResultAccountList	###]");
		}
		
		try {
			dbRowSet	= dbDao.searchAccrualBatchResultAccountList(event);
			eventResponse.setRsVo( dbRowSet );
			
			return eventResponse;
			
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * Inquiring the manual input list of the accrual batch result.<br>
	 * 
	 * @param e Event
	 * @return response ESD_LEA_002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAccrualBatchResultManualInputList(Event e) throws EventException {
		EsdLea0002Event 		event			= (EsdLea0002Event)e;
		DBRowSet 				dbRowSet		= null; 				
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		if(log.isDebugEnabled())log.debug("[AccrualBatchExecuteResultBCImpl searchAccrualBatchResultManualInputList	]");
		
		try {
			dbRowSet	= dbDao.searchAccrualBatchResultManualInputList(event);
			eventResponse.setRsVo( dbRowSet );
			
			return eventResponse;

		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Inquiring Accrual Condition Item Flags<br>
	 * 
	 * @param e Event
	 * @return response ESD_LEA_002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAccrualConditionItemFlags(Event e) throws EventException {
		EsdLea0002Event 		event			= (EsdLea0002Event)e;
		DBRowSet 				dbRowSet		= null; 				
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			dbRowSet	= dbDao.searchAccrualConditionItemFlags(event);
			eventResponse.setRsVo( dbRowSet );
			
			return eventResponse;
			
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * 
	 * Modifying the account confirm of the accrual batch result.<br>
	 * 
	 * @param Event e
	 * @param SignOnUserAccount account
	 * @return response ESD_LEA_002EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyAccrualBatchResultAccountConfirm(Event e, SignOnUserAccount account) throws EventException {
		
		log.error("====================================================================");
		log.error("====================== BC Impl =====================================");
		log.error("====================================================================");
		
		int 			upCnt 		= 0;
		int				delCnt		= 0;
		int				insCnt		= 0;
		
		String			userId		= null;
		String			userOfcCd	= null;
		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		EsdLea0002Event 		event			= (EsdLea0002Event)e;
		
		if(log.isDebugEnabled())log.debug("[AccrualBatchExecuteResultBCImpl searchAccrualBatchResultAccountList	]");
		
		try {
			
			userId		= account.getUsr_id();
			userOfcCd	= account.getOfc_cd();
			
			upCnt	= dbDao.modifyAccrualConditionItem	(event, userId, userOfcCd);
			delCnt	= dbDao.removeGlAcclIfExeYrmon		(event, userId, userOfcCd);
			insCnt	= dbDao.createGlAcclIfExeYrmon		(event, userId, userOfcCd);
			
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(new ErrorHandler("LEA00003").getUserMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * Modifying the manual input of the accrual batch result.<br>
	 * 
	 * Database Error Message List
	 * -----------------------------------------------
	 * LEA00001	: No data found.	
	 * LEA00002	: Confirmed.	
	 * LEA00003	: Confirmation has failed.	
	 * LEA00004	: Batch has been completed.	
	 * LEA00005	: Batch has been failed.	
	 * LEA00006	: Saving has been completed.	
	 * LEA00007	: Saving has been failed.	
	 * LEA00008	: Mail has been sent.	
	 * LEA00009	: Mail has not been sent.
	 * ----------------------------------------------	
	 * 
	 * @param Event e
	 * @param SignOnUserAccount account
	 * @return response ESD_LEA_002EventResponse
	 * @exception EventException
	 **/

	public EventResponse modifyAccrualBatchResultManualInput(Event e, SignOnUserAccount account) throws EventException {
		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		EsdLea0002Event 		event			= (EsdLea0002Event)e;
		
		int						returnCnt		= 0;
		String					userId			= null;
		String					userOfcCd		= null;	
		
		try {
			userId		= account.getUsr_id();
			userOfcCd	= account.getOfc_cd();
			
			SearchAccrualBatchResultManualInputListVO	searchAccrualBatchResultManualInputListVO	= new SearchAccrualBatchResultManualInputListVO();
			SearchAccrualBatchResultManualInputListVO[]	searchAccrualBatchResultManualInputListVOs	= event.getSearchAccrualBatchResultManualInputListVOs();
			
			log.error("================ DBDAO.modifyAccrualBatchResultManualInput FOR LOOP START =======================================");
			
			for(int i=0; i<searchAccrualBatchResultManualInputListVOs.length; i++){
				searchAccrualBatchResultManualInputListVO	= searchAccrualBatchResultManualInputListVOs[i];
				returnCnt = dbDao.modifyAccrualBatchResultManualInput(searchAccrualBatchResultManualInputListVO, userId, userOfcCd);

			}	
			
			dbDao.modifyAccrualConditionItem	(event, userId, userOfcCd);

			
			log.error("================ DBDAO.modifyAccrualBatchResultManualInput FOR LOOP END =======================================");

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler("LEA00007").getUserMessage());
		} catch (Exception e1) {
			log.error("err "+e1.toString(),e1);
			throw new EventException(new ErrorHandler("LEA00007").getUserMessage()); 
		}
		return eventResponse;
	}

}