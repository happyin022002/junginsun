/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualBatchExecuteResultBCImpl.java
*@FileTitle : Rev.VVD Inquiry (Pop-up)
*Open Issues :
*Change history : 2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.07.31
*@LastModifier : Jeon Jae Hong
**@LastVersion : 1.0
* 2009.07.31 Jeon Jae Hong
* 1.0 Creation
* 
* 2011.10.31 [CHM-201114105] 민정호 [LEA] ALPS UI에 조정계수 입력화면 Accrual Adjustment 추가
* 2011.12.26 [CHM-201115071] [LEA] Full Volume Incentive Auto 변환 관련 화면변경 요청
* 2012.03.22 황효근 [CHM-201216821] [LEA] ALPS Accrual Result의 By Account Code (Final) 보완 : 조정계수 반영
* 2013.03.18 황태진 [LEA] 2013.03.18 512073, 512361 저장 처리 루틴 제거
* 2015.04.10 KIM HYUN HWA/HYUN SUNG KIL[CHM-201534996]LEA_Expense Report 에 화면 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.basic;
 
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0002Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0003Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration.AccrualBatchExecuteResultDBDAO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.AccrualAdjustmentVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.ActCostMonBudgetVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchACBMInquiryVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualAccountCodeVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchExecuteResultHistoryListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultBookingListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultContainerTPSZListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultExecuteMonthListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultInvoiceInquiryVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultManualInputListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultOfficeListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultRevenueMonthListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualRevenueVVDCodeListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchCostCodeListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchCostTypeCodeComboListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchSubCostTypeCodeComboListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.LeaAcctCostAmtVO;



/**
 * ALPS-LogisticsExpenseAccrual Business Logic Basic Command implementation<br>
 * - ALPS-LogisticsExpenseAccrual에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jeon Jae Hong
 * @see ESD_LEA_0901EventResponse,AccrualBatchExecuteResultBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */ 
public class AccrualBatchExecuteResultBCImpl extends BasicCommandSupport implements AccrualBatchExecuteResultBC {

	// Database Access Object
	private transient AccrualBatchExecuteResultDBDAO dbDao = null;
//	private transient AccrualEmailSettingDBDAO dbDao2 = null;
//	private transient AccrualBatchManageDBDAO dbDao3 = null;

	/**
	 * AccrualBatchExecuteResultBCImpl 객체 생성<br>
	 * AccrualBatchExecuteResultDBDAO를 생성한다.<br>
	 */
	public AccrualBatchExecuteResultBCImpl() {
		dbDao = new AccrualBatchExecuteResultDBDAO();
//		dbDao2= new AccrualEmailSettingDBDAO();
//		dbDao3= new AccrualBatchManageDBDAO();
	}
	
	/**
	 * Cost Code를 조회한다.<br>
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
	 * Cost Code의 Main Cost Type을 조회한다.<br>
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
	 * Cost Code의 Sub Cost Type 을 조회한다.<br>
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
	 * Account Code List 를 조회한다.<br>
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
	 * 수입대상항차 List 를 조회한다.<br>
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
	 * 결산 배치 결과 BKG LIST 를 조회한다.<br>
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
	 * 결산 배치 결과 CNTR List 를 조회한다.<br>
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
	 * 결산 배치 History 를 조회한다.<br>
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
	 * 결산 배치 결과를 Revenue Month 기준으로 조회한다.<br>
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
	 * 결산 배치 결과를 Execute Month 기준으로 조회한다.<br>
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
	 * 결산 배치 결과를 Office 기준으로 조회한다.<br>
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
	 * Invoice 정보를 조회한다.<br>
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
	 * ACBM 정보를 조회한다.<br>
	 * 
	 * @param SearchACBMInquiryVO searchACBMInquiryVO
	 * @return List<SearchACBMInquiryVO>
	 * @exception EventException
	 */
	public List<SearchACBMInquiryVO> searchACBMInquiry(SearchACBMInquiryVO searchACBMInquiryVO) throws EventException {
		try {
			return dbDao.searchACBMInquiry(searchACBMInquiryVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/** 
	 * AccrualBatchExecuteResultAccountList화면 조회<br>
	 * 
	 * @param e Event
	 * @return response ESD_LEA_002EventResponse
	 * @exception EventException
	 */

	public EventResponse searchAccrualBatchResultAccountList(Event e) throws EventException {
		EsdLea0002Event 		event			= (EsdLea0002Event)e;
		DBRowSet 				dbRowSet		= null; 				// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		if(log.isDebugEnabled())log.debug("[AccrualBatchExecuteResultBCImpl searchAccrualBatchResultAccountList	###]");
		
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
	 * AccrualBatchExecuteResultAccountList화면 조회<br>
	 * 
	 * @param e Event
	 * @return response ESD_LEA_003EventResponse
	 * @exception EventException
	 */

	public EventResponse searchAccrualBatchResultAccountFinalList(Event e) throws EventException {
		EsdLea0003Event 		event			= (EsdLea0003Event)e;
		DBRowSet 				dbRowSet		= null; 				// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		if(log.isDebugEnabled())log.debug("[AccrualBatchExecuteResultBCImpl searchAccrualBatchResultAccountFinalList	###]");
		
		try {
			dbRowSet	= dbDao.searchAccrualBatchResultAccountFinalList(event);
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
	 * AccrualBatchExecuteResultAccountList화면 조회<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchAccrualBatchResultAccountFinalLastExeYrmon() throws EventException {
		DBRowSet rowSet = null;							
        String retVal = "";
        
        try {
            rowSet=dbDao.searchAccrualBatchResultAccountFinalLastExeYrmon();
            
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;   
	}
	
	
	
	/**
	 * AccrualBatchExecuteResultManualInput화면 조회<br>
	 * 
	 * @param e Event
	 * @return response ESD_LEA_002EventResponse
	 * @exception EventException
	 */

	public EventResponse searchAccrualBatchResultManualInputList(Event e) throws EventException {
		EsdLea0002Event 		event			= (EsdLea0002Event)e;
		DBRowSet 				dbRowSet		= null; 				// 데이터 전송을 위해 DB ResultSet을 구현한 객체
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
	 * AccrualBatchExecuteResultFinalManualInput화면 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAccrualBatchResultFinalManualInputList(Event e) throws EventException {
		EsdLea0003Event 		event			= (EsdLea0003Event)e;
		DBRowSet 				dbRowSet		= null; 				// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			dbRowSet	= dbDao.searchAccrualBatchResultFinalManualInputList(event);
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
	 * 결산 사전 조건 조회<br>
	 * 
	 * @param e Event
	 * @return response ESD_LEA_002EventResponse
	 * @exception EventException
	 */

	public EventResponse searchAccrualConditionItemFlags(Event e) throws EventException {
		EsdLea0002Event 		event			= (EsdLea0002Event)e;
		DBRowSet 				dbRowSet		= null; 				// 데이터 전송을 위해 DB ResultSet을 구현한 객체
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
	 * AccrualBatchExecuteResultAccountList화면에 대한 Confirm Modify 이벤트 처리<br>
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
			
			////SearchAccrualBatchResultAccountListVO searchAccrualBatchResultAccountListVO	= new SearchAccrualBatchResultAccountListVO();
			
//			for(int i=0; i < searchAccrualBatchResultAccountListVOs.length; i++){
//				searchAccrualBatchResultAccountListVO	= searchAccrualBatchResultAccountListVOs[i];
//				
//				returnCnt = dbDao.modifyAccrualConditionItem(searchAccrualBatchResultAccountListVO, userId, userOfcCd);
//				
//				////if(returnCnt > 0)	return new EsdLea0002EventResponse(null, new ErrorHandler("LEA00002").getUserMessage());
//				////else 				return new EsdLea0002EventResponse(null, new ErrorHandler("LEA00003").getUserMessage());
//			}

			
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(new ErrorHandler("LEA00003").getUserMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Manual Input 대상 ACCT 에 대한 Modify<br>
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
			userId				= account.getUsr_id();
			userOfcCd			= account.getOfc_cd();
			
			SearchAccrualBatchResultManualInputListVO	searchAccrualBatchResultManualInputListVO	= new SearchAccrualBatchResultManualInputListVO();
			SearchAccrualBatchResultManualInputListVO[]	searchAccrualBatchResultManualInputListVOs	= event.getSearchAccrualBatchResultManualInputListVOs();
			
			
			/**
			 * =========== ACCOUNT LIST =================================================================
			 * [512073] : VOLUME DISCOUNT/REFUND FULL					<VOLUME DISCOUNT/REFUND FULL    >
			 * 				512075 - VOLUME DISCOUNT/REFUND T/S
			 * ------------------------------------------------------------------------------------------
			 * [512361]	: TRS VOLUME DISCOUNT/REFUND FULL				<TRS VOLUME DISCOUNT/REFUND FULL>
			 * ------------------------------------------------------------------------------------------
			 * [512074]	: VOLUME DISCOUNT/REFUND MT
			 * ------------------------------------------------------------------------------------------
			 * [512362]	: TRS VOLUME DISCOUNT/REFUND EMPTY	
			 * ------------------------------------------------------------------------------------------
			 * [512061]	: STEVEDORAGE BASIC FOR LOAD/DISCHARGE - M		<기본하역비-EMPTY               	>
			 * 				512062 - STEVEDORAGE BASIC FOR LOAD/DISCHARGE - T/S MT
			 * 				512063 - TERMINAL SECURITY SURCHARGE - MT
			 * 				512064 - TERMINAL SECURITY SURCHARGE - T/S MT
			 * 				512065 - TROUGHPUT RATE FOR ON-DOCK - MT
			 * 				512066 - TROUGHPUT RATE FOR ON-DOCK - T/S MT		
			 * ------------------------------------------------------------------------------------------
			 * [512151]	: BASIC TERMINAL CHRG FOR EMPTY	CY 				<기본조작료 - EMPTY             	>
			 * 				512144 - WHARFAGE FOR EMPTY
			 * 				512152 - EXTRA TERMINAL ON-DOCK CY EMPTY
			 * 				512153 - OFF-DOCK/INLAND EMPTY	
			 * 				512154 - OFF-DOCK/INLAND EMPTY EXTRA
			 * 				512155 - ON-DOCK RAIL CHARGE FOR EMPTY
			 * 				512133 - ASSESSMENT / LEVIES FOR EMPTY		
			 * ------------------------------------------------------------------------------------------
			 * [512221]	: STORAGE OFF-DOCK EMPTY						<STORAGE OFF-DOCK EMPTY         >
			 * 				512222 - STORAGE ON-DOCK EMPTY	
			 * ------------------------------------------------------------------------------------------
			 * [512341]	: EMPTY REPO-RAIL								<EMPTY REPO-RAIL                >
			 * 				512342 - EMPTY REPO-RAIL & TRUCK
			 * 				512343 - EMPTY REPO-TRUCK
			 * 				512344 - EMPTY REPO-FEEDER
			 * 				512345 - EMPTY REPO-FEEDER & RAIL
			 * 				512346 - EMPTY REPO-FEEDER & TRUCK
			 * 				512347 - OTHER TRS-SURCHARGE - EMPTY	
			 * ------------------------------------------------------------------------------------------
			 * [512171]	: CHASSIS BUNDLE CHARGE FOR OFF-DOCK
			 * 				512172 - CHASSIS BUNDLE CHARGE FOR ON-DOCK
			 * ------------------------------------------------------------------------------------------
			 * [512331]	: CHASSIS DRAYAGE-RAIL
			 * 				512332 - CHASSIS DRAYAGE-RAIL & TRUCK
			 * 				512333 - CHASSIS DRAYAGE-TRUCK
			 * 				512334 - CHASSIS DRAYAGE-FEEDER
			 * 				512335 - CHASSIS DRAYAGE-FEEDER & RAIL
			 * 				512336 - CHASSIS DRAYAGE-FEEDER & TRUCK	
			 * ------------------------------------------------------------------------------------------
			 * [512351]	: TRS DOMESTIC RAIL - RAIL						<TRS DOMESTIC RAIL - RAIL       >
			 * ------------------------------------------------------------------------------------------
			 * [512019]	: STEVEDORAGE - OTHER LINES - FULL				<타사하역비-FULL             		>
			 * 				512029 - STEVEDORAGE - OTHER LINES - FULL T/S
			 * 				512039 - STEVEDORAGE - OTHER LINES - OTHER
			 * 				512069 - STEVEDORAGE - OTHER LINES - MT
			 * 				512119 - STEVEDORAGE FOR CY - OTHER LINES
			 * 				512229 - STORAGE OTHER LINES
			 * 				512429 - CFS CHARGE - OTHER LINES　	
			 * ------------------------------------------------------------------------------------------
			 * [512181]	: 3rd PARTY COLLECTION STEVEDORAGE CHARGE		<3자 구상 하역비                			>
			 * ------------------------------------------------------------------------------------------
			 * [512381]	: 3rd PARTY COLLECTION TRANSPORTANTION CHA		<3자 구상 운반비                			>
			 * ==========================================================================================
			*/
			
			/* 2012-02-22 KIM.SM 과장요청 
			 * 	512073,512075,512361,512181,512381 5EA Account Code 에 대해서만 MNL_INP_FLG = 'Y'로 INS/UP하고
			 * 그이외의 Account Code에 대해서는 저장하지 않음.
			 */
			
//			String[]	strAccountCdArr	= {"512073", "512019", "512351", "512361", "512061", "512151", "512221", "512341", "512181", "512381"};
//			String		strAccountCd		= null;
			
			log.error("================ DBDAO.modifyAccrualBatchResultManualInput FOR LOOP START =======================================");
			
			LeaAcctCostAmtVO model 	= null;
			
			
			for(int i=0; i<searchAccrualBatchResultManualInputListVOs.length; i++){
				searchAccrualBatchResultManualInputListVO	= searchAccrualBatchResultManualInputListVOs[i];
				List<LeaAcctCostAmtVO> models = new ArrayList<LeaAcctCostAmtVO>();
				
//				strAccountCd	=  strAccountCdArr[i];
//				log.error("= strAccountCd order is ["+(i+1)+"]   value is ["+strAccountCd+"]");
				//searchAccrualBatchResultManualInputListVO.setAcctCd(strAccountCd);
				
				if(searchAccrualBatchResultManualInputListVO != null){
// 2013.03.18 512073, 512361 저장 처리 루틴 제거
/*
				     if(!searchAccrualBatchResultManualInputListVO.getRevYrmon().substring(0,4).equals("2012"))
				     {
				      model = new LeaAcctCostAmtVO();
				      model.setEstmCostAmt (searchAccrualBatchResultManualInputListVO.getEstmCostAmtA ());
				      model.setPreActCostAmt (searchAccrualBatchResultManualInputListVO.getActCostAmtA ());
				      model.setAcclCostAmt (searchAccrualBatchResultManualInputListVO.getAcclCostAmtA ());
				      model.setRevYrmon  (searchAccrualBatchResultManualInputListVO.getRevYrmon  ());
				      model.setExeYrmon  (searchAccrualBatchResultManualInputListVO.getExeYrmon  ());
				      model.setCreUsrId  (userId);
				      model.setUpdUsrId  (userId);
				      model.setAcctCd   ("512073");
				      models.add(model);
				     }
				     
				     if(!searchAccrualBatchResultManualInputListVO.getRevYrmon().substring(0,4).equals("2012"))
				     {
				      model = new LeaAcctCostAmtVO();
				      model.setEstmCostAmt (searchAccrualBatchResultManualInputListVO.getEstmCostAmtD ());
				      model.setPreActCostAmt (searchAccrualBatchResultManualInputListVO.getActCostAmtD ());
				      model.setAcclCostAmt (searchAccrualBatchResultManualInputListVO.getAcclCostAmtD ());
				      model.setRevYrmon  (searchAccrualBatchResultManualInputListVO.getRevYrmon  ());
				      model.setExeYrmon  (searchAccrualBatchResultManualInputListVO.getExeYrmon  ());
				      model.setCreUsrId  (userId);
				      model.setUpdUsrId  (userId);
				      model.setAcctCd   ("512361");
				      models.add(model);
				     }
*/
					
					model = new LeaAcctCostAmtVO();
					model.setEstmCostAmt	(searchAccrualBatchResultManualInputListVO.getEstmCostAmtAA	());
					model.setPreActCostAmt	(searchAccrualBatchResultManualInputListVO.getActCostAmtAA	());
					model.setAcclCostAmt	(searchAccrualBatchResultManualInputListVO.getAcclCostAmtAA	());
					model.setRevYrmon		(searchAccrualBatchResultManualInputListVO.getRevYrmon		());
					model.setExeYrmon		(searchAccrualBatchResultManualInputListVO.getExeYrmon		());
					model.setCreUsrId		(userId);
					model.setUpdUsrId		(userId);
					model.setAcctCd			("512074");
					models.add(model);
					
					model = new LeaAcctCostAmtVO();
					model.setEstmCostAmt	(searchAccrualBatchResultManualInputListVO.getEstmCostAmtDD	());
					model.setPreActCostAmt	(searchAccrualBatchResultManualInputListVO.getActCostAmtDD	());
					model.setAcclCostAmt	(searchAccrualBatchResultManualInputListVO.getAcclCostAmtDD	());
					model.setRevYrmon		(searchAccrualBatchResultManualInputListVO.getRevYrmon		());
					model.setExeYrmon		(searchAccrualBatchResultManualInputListVO.getExeYrmon		());
					model.setCreUsrId		(userId);
					model.setUpdUsrId		(userId);
					model.setAcctCd			("512362");
					models.add(model);
					
/*					model = new LeaAcctCostAmtVO();
					model.setEstmCostAmt(searchAccrualBatchResultManualInputListVO.getEstmCostAmtF	());
					model.setPreActCostAmt(searchAccrualBatchResultManualInputListVO.getActCostAmtF	());
					model.setAcclCostAmt(searchAccrualBatchResultManualInputListVO.getAcclCostAmtF	());
					model.setRevYrmon(searchAccrualBatchResultManualInputListVO.getRevYrmon			());
					model.setExeYrmon(searchAccrualBatchResultManualInputListVO.getExeYrmon			());
					model.setCreUsrId(userId);
					model.setUpdUsrId(userId);
					model.setAcctCd("512061");
					models.add(model);*/
					
/*					model = new LeaAcctCostAmtVO();
					model.setEstmCostAmt(searchAccrualBatchResultManualInputListVO.getEstmCostAmtG	());
					model.setPreActCostAmt(searchAccrualBatchResultManualInputListVO.getActCostAmtG	());
					model.setAcclCostAmt(searchAccrualBatchResultManualInputListVO.getAcclCostAmtG	());
					model.setRevYrmon(searchAccrualBatchResultManualInputListVO.getRevYrmon			());
					model.setExeYrmon(searchAccrualBatchResultManualInputListVO.getExeYrmon			());
					model.setCreUsrId(userId);
					model.setUpdUsrId(userId);
					model.setAcctCd("512151");
					models.add(model);*/
					
/*					model = new LeaAcctCostAmtVO();
					model.setEstmCostAmt(searchAccrualBatchResultManualInputListVO.getEstmCostAmtH	());
					model.setPreActCostAmt(searchAccrualBatchResultManualInputListVO.getActCostAmtH	());
					model.setAcclCostAmt(searchAccrualBatchResultManualInputListVO.getAcclCostAmtH	());
					model.setRevYrmon(searchAccrualBatchResultManualInputListVO.getRevYrmon			());
					model.setExeYrmon(searchAccrualBatchResultManualInputListVO.getExeYrmon			());
					model.setCreUsrId(userId);
					model.setUpdUsrId(userId);
					model.setAcctCd("512221");
					models.add(model);*/
					
/*					model = new LeaAcctCostAmtVO();
					model.setEstmCostAmt(searchAccrualBatchResultManualInputListVO.getEstmCostAmtI	());
					model.setPreActCostAmt(searchAccrualBatchResultManualInputListVO.getActCostAmtI	());
					model.setAcclCostAmt(searchAccrualBatchResultManualInputListVO.getAcclCostAmtI	());
					model.setRevYrmon(searchAccrualBatchResultManualInputListVO.getRevYrmon			());
					model.setExeYrmon(searchAccrualBatchResultManualInputListVO.getExeYrmon			());
					model.setCreUsrId(userId);
					model.setUpdUsrId(userId);
					model.setAcctCd("512341");
					models.add(model);*/
					
					//2011.04.25 박재흥[CHM-201110389] [ESD-LEA] Accrual Result by Account Code 변경수정 
/*					model = new LeaAcctCostAmtVO();
					model.setEstmCostAmt(searchAccrualBatchResultManualInputListVO.getEstmCostAmtK	());
					model.setPreActCostAmt(searchAccrualBatchResultManualInputListVO.getActCostAmtK	());
					model.setAcclCostAmt(searchAccrualBatchResultManualInputListVO.getAcclCostAmtK	());
					model.setRevYrmon(searchAccrualBatchResultManualInputListVO.getRevYrmon			());
					model.setExeYrmon(searchAccrualBatchResultManualInputListVO.getExeYrmon			());
					model.setCreUsrId(userId);
					model.setUpdUsrId(userId);
					model.setAcctCd("512171");
					models.add(model);*/
					
/*					model = new LeaAcctCostAmtVO();
					model.setEstmCostAmt(searchAccrualBatchResultManualInputListVO.getEstmCostAmtK	());
					model.setPreActCostAmt(searchAccrualBatchResultManualInputListVO.getActCostAmtK	());
					model.setAcclCostAmt(searchAccrualBatchResultManualInputListVO.getAcclCostAmtK	());
					model.setRevYrmon(searchAccrualBatchResultManualInputListVO.getRevYrmon			());
					model.setExeYrmon(searchAccrualBatchResultManualInputListVO.getExeYrmon			());
					model.setCreUsrId(userId);
					model.setUpdUsrId(userId);
					model.setAcctCd("512331");
					models.add(model);*/

/*					model = new LeaAcctCostAmtVO();
					model.setEstmCostAmt(searchAccrualBatchResultManualInputListVO.getEstmCostAmtC	());
					model.setPreActCostAmt(searchAccrualBatchResultManualInputListVO.getActCostAmtC	());
					model.setAcclCostAmt(searchAccrualBatchResultManualInputListVO.getAcclCostAmtC	());
					model.setRevYrmon(searchAccrualBatchResultManualInputListVO.getRevYrmon			());
					model.setExeYrmon(searchAccrualBatchResultManualInputListVO.getExeYrmon			());
					model.setCreUsrId(userId);
					model.setUpdUsrId(userId);
					model.setAcctCd("512351");
					models.add(model);*/
					
/*					model = new LeaAcctCostAmtVO();
					model.setEstmCostAmt(searchAccrualBatchResultManualInputListVO.getEstmCostAmtB	());
					model.setPreActCostAmt(searchAccrualBatchResultManualInputListVO.getActCostAmtB	());
					model.setAcclCostAmt(searchAccrualBatchResultManualInputListVO.getAcclCostAmtB	());
					model.setRevYrmon(searchAccrualBatchResultManualInputListVO.getRevYrmon			());
					model.setExeYrmon(searchAccrualBatchResultManualInputListVO.getExeYrmon			());
					model.setCreUsrId(userId);
					model.setUpdUsrId(userId);
					model.setAcctCd("512019");
					models.add(model);*/			

					model = new LeaAcctCostAmtVO();
					model.setEstmCostAmt(searchAccrualBatchResultManualInputListVO.getEstmCostAmtJ	());
					model.setPreActCostAmt(searchAccrualBatchResultManualInputListVO.getActCostAmtJ	());
					model.setAcclCostAmt(searchAccrualBatchResultManualInputListVO.getAcclCostAmtJ	());
					model.setRevYrmon(searchAccrualBatchResultManualInputListVO.getRevYrmon			());
					model.setExeYrmon(searchAccrualBatchResultManualInputListVO.getExeYrmon			());
					model.setCreUsrId(userId);
					model.setUpdUsrId(userId);
					model.setAcctCd("512181");
					models.add(model);
					
					model = new LeaAcctCostAmtVO();
					model.setEstmCostAmt(searchAccrualBatchResultManualInputListVO.getEstmCostAmtK	());
					model.setPreActCostAmt(searchAccrualBatchResultManualInputListVO.getActCostAmtK	());
					model.setAcclCostAmt(searchAccrualBatchResultManualInputListVO.getAcclCostAmtK	());
					model.setRevYrmon(searchAccrualBatchResultManualInputListVO.getRevYrmon			());
					model.setExeYrmon(searchAccrualBatchResultManualInputListVO.getExeYrmon			());
					model.setCreUsrId(userId);
					model.setUpdUsrId(userId);
					model.setAcctCd("512381");
					models.add(model);
										
					returnCnt = dbDao.modifyAccrualBatchResultManualInput(models);

				}
				
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

	
	/** ESD_LEA_0021 : retrieve<br>
	 * 조정계수를 조회한다.<br>
	 *  
	 * @param AccrualAdjustmentVO accrualAdjustmentVO 
	 * @return List<AccrualAdjustmentVO>
	 * @exception EventException
	 */		
	public List<AccrualAdjustmentVO> searchAccrualAdjustmentList(AccrualAdjustmentVO accrualAdjustmentVO) throws EventException {
		try {
			return dbDao.searchAccrualAdjustmentList(accrualAdjustmentVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}		
	}	
	
	/**
	 * 조정계수를 저장한다.<br>
	 * 
	 * @param AccrualAdjustmentVO[] accrualAdjustmentVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAccrualAdjustment(AccrualAdjustmentVO[] accrualAdjustmentVOs, SignOnUserAccount account) throws EventException {
		try {
			List<AccrualAdjustmentVO> insertVoList = new ArrayList<AccrualAdjustmentVO>();
			List<AccrualAdjustmentVO> updateVoList = new ArrayList<AccrualAdjustmentVO>();			

			for ( int i=0; i<accrualAdjustmentVOs.length; i++ ) {
				if ( accrualAdjustmentVOs[i].getIbflag().equals("U") ||
						accrualAdjustmentVOs[i].getIbflag().equals("D") ||
						accrualAdjustmentVOs[i].getIbflag().equals("I")
					){		
					
					accrualAdjustmentVOs[i].setCreUsrId(account.getUsr_id());					
					accrualAdjustmentVOs[i].setUpdUsrId(account.getUsr_id());										
					accrualAdjustmentVOs[i].setInputSw("S");
					
					if(dbDao.searchAccrualAdjustmentData(accrualAdjustmentVOs[i]).size() > 0){						
						updateVoList.add(accrualAdjustmentVOs[i]);						
					}else{						
						insertVoList.add(accrualAdjustmentVOs[i]);											
					}							
				} 
			}		
			
			if ( updateVoList.size() > 0) {
				dbDao.modifyAccrualAdjustment(updateVoList);
			}			
			if ( insertVoList.size() > 0) {
				dbDao.addAccrualAdjustment(insertVoList);							
			}						
			
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(new ErrorHandler("LEA00007").getUserMessage());		
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(new ErrorHandler("LEA00007").getUserMessage());		
		}	
	}		
	
	/** ESD_LEA_0021 : retrieve<br>
	 * 조정계수 이력을 조회한다.<br>
	 *  
	 * @param AccrualAdjustmentVO accrualAdjustmentVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
	public void manageAccrualApply(AccrualAdjustmentVO accrualAdjustmentVO, SignOnUserAccount account) throws EventException {
		try {
			accrualAdjustmentVO.setCreUsrId(account.getUsr_id());					
			accrualAdjustmentVO.setUpdUsrId(account.getUsr_id());										
								
			dbDao.addAccrualApply(accrualAdjustmentVO);
			
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(new ErrorHandler("LEA00007").getUserMessage());		
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(new ErrorHandler("LEA00007").getUserMessage());		
		}	
	}			
	
	/**
	 * 조정계수 이력 배치 프로그램을 실행한다.<br>
	 * @param AccrualAdjustmentVO accrualAdjustmentVO
	 * @return String
	 * @exception EventException
	 */
	public String executeAccrualApplyBatch(AccrualAdjustmentVO accrualAdjustmentVO) throws EventException{
		String	returnMsg = "";
		
		try {						
			returnMsg = dbDao.executeAccrualApplyBatch(accrualAdjustmentVO.getExeYrmon());								
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return returnMsg;
	}
	

	/**
	 * Office Type Check.<br>
	 * @param String ofc_cd
	 * @return String
	 * @exception EventException
	 */
	public String searchOfficeTypeCheck(String ofc_cd) throws EventException{
		String	knt = "";
		
		try {						
			knt = dbDao.searchOfficeTypeCheck(ofc_cd);								
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return knt;
	}
	
	/**
	 * searchRhqOffice.<br>
	 * @param String ofc_cd
	 * @return String
	 * @exception EventException
	 */
	public String searchRhqOffice(String ofc_cd) throws EventException{
		String	rhq = "";
		
		try {						
			rhq = dbDao.searchRhqOffice(ofc_cd);								
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return rhq;
	}

	/** ESD_LEA_0021 : save<br>
	 * ACCL_ADJ_FCTR_FNL_FLG을 저장한다.<br>
	 *  
	 * @param AccrualAdjustmentVO accrualAdjustmentVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
	public void manageAcclAdjFctrFnlFlg(AccrualAdjustmentVO accrualAdjustmentVO, SignOnUserAccount account) throws EventException {
		try {
			accrualAdjustmentVO.setCreUsrId(account.getUsr_id());					
			accrualAdjustmentVO.setUpdUsrId(account.getUsr_id());										
								
			dbDao.modifyAcclAdjFctrFnlFlg(accrualAdjustmentVO);
			
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(new ErrorHandler("LEA00007").getUserMessage());		
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(new ErrorHandler("LEA00007").getUserMessage());		
		}	
	}
	
/**
 * YearlyCostBudget 정보를 조회한다.<br>
 * 
 * @param String bseYr
 * @param String rhqCd
 * @return List<ActCostMonBudgetVO>
 * @exception EventException
 */
public List<ActCostMonBudgetVO> searchYearlyCostBudget(String bseYr, String rhqCd) throws EventException {
		try {
			return dbDao.searchYearlyCostBudget(bseYr, rhqCd);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
   }

/** ESD_LEA_0022 : save<br>
 * 년도별 Monthly Budget을 신규 생성한다.<br>
 *  
 * @param ActCostMonBudgetVO[] actCostMonBudgetVOs
 * @param String creUsrId
 * @exception EventException
 */		
public void createYearlyBudgetCostCode(ActCostMonBudgetVO[] actCostMonBudgetVOs, String creUsrId) throws EventException {
	List<ActCostMonBudgetVO> indateVoList = new ArrayList<ActCostMonBudgetVO>();
	try {
		for ( int i=0; i<actCostMonBudgetVOs.length; i++ ) {
			actCostMonBudgetVOs[i].setCreUsrId(creUsrId);										
			actCostMonBudgetVOs[i].setMnlFlg("N");
			indateVoList.add(actCostMonBudgetVOs[i]);
		}
		//log.debug("BCIMP=============================================");
		if ( indateVoList.size() > 0) {
			dbDao.removeYearlyCostCode(actCostMonBudgetVOs[0].getBseYr());
			dbDao.createYearlyBudgetCostCode(indateVoList);
		}
		
	} catch (DAOException ex) {
		log.error("err "+ex.toString(),ex);
		throw new EventException(new ErrorHandler("LEA00007").getUserMessage());		
	} catch (Exception ex) {
		log.error("err "+ex.toString(),ex);
		throw new EventException(new ErrorHandler("LEA00007").getUserMessage());		
	}	
 }

/** ESD_LEA_0022 : save<br>
 * 년도별 Monthly Budget을을 저장한다.<br>
 *  
 * @param ActCostMonBudgetVO[] actCostMonBudgetVOs
 * @param String creUsrId
 * @exception EventException
 */		
public void modifyYearlyCostBudget(ActCostMonBudgetVO[] actCostMonBudgetVOs, String creUsrId) throws EventException {
	List<ActCostMonBudgetVO> updateVoList = new ArrayList<ActCostMonBudgetVO>();
	List<ActCostMonBudgetVO> indateVoList = new ArrayList<ActCostMonBudgetVO>();
	
	try {
		
		for ( int i=0; i<actCostMonBudgetVOs.length; i++ ) {
			if (actCostMonBudgetVOs[i].getIbflag().equals("U")){		
			
				actCostMonBudgetVOs[i].setUpdUsrId(creUsrId);										
				actCostMonBudgetVOs[i].setMnlFlg("Y");
				updateVoList.add(actCostMonBudgetVOs[i]);
				
			}else if(actCostMonBudgetVOs[i].getIbflag().equals("I")){
				actCostMonBudgetVOs[i].setCreUsrId(creUsrId);										
				actCostMonBudgetVOs[i].setMnlFlg("Y");
				indateVoList.add(actCostMonBudgetVOs[i]);
			}
		}		
		
		if ( updateVoList.size() > 0) {
			dbDao.modifyYearlyCostBudget(updateVoList);
		}
		
		if ( indateVoList.size() > 0) {
			dbDao.createYearlyCostBudget(indateVoList);
		}
		
	} catch (DAOException ex) {
		log.error("err "+ex.toString(),ex);
		throw new EventException(new ErrorHandler("LEA00007").getUserMessage());		
	} catch (Exception ex) {
		log.error("err "+ex.toString(),ex);
		throw new EventException(new ErrorHandler("LEA00007").getUserMessage());		
	}	
 }

/**
 * Budget 생성 프로시저를 실행한다.<br>
 * @param String bseYr
 * @return String
 * @exception EventException
 */
public String executeYearlyCostBudget(String bseYr) throws EventException{
	String	returnMsg = "";
	
	try {						
		returnMsg = dbDao.executeYearlyCostBudget(bseYr);	
	} catch (DAOException ex) {
		throw new EventException(ex.getMessage(),ex);
	} catch (Exception ex) {
		throw new EventException(ex.getMessage(),ex);
	}
	return returnMsg;
}

/** ESD_LEA_0022 : save<br>
 * 년도별 Monthly Budget을 신규 생성한다.<br>
 *  
 * @param ActCostMonBudgetVO[] actCostMonBudgetVOs
 * @param String creUsrId
 * @exception EventException
 */		
public void createYearlyBudgetCostCodeAlpsa(ActCostMonBudgetVO[] actCostMonBudgetVOs, String creUsrId) throws EventException {
	List<ActCostMonBudgetVO> indateVoList = new ArrayList<ActCostMonBudgetVO>();
	try {
		//log.debug("BCIMP==createYearlyBudgetCostCodeAlpsa===actCostMonBudgetVOs.length====="+actCostMonBudgetVOs.length);
		
		for ( int i=0; i<actCostMonBudgetVOs.length; i++ ) {
			actCostMonBudgetVOs[i].setCreUsrId(creUsrId);										
			actCostMonBudgetVOs[i].setMnlFlg("N");
			indateVoList.add(actCostMonBudgetVOs[i]);
		}
		//log.debug("BCIMP==createYearlyBudgetCostCodeAlpsa================================indateVoList.size()========="+indateVoList.size());
		if ( indateVoList.size() > 0) {
			dbDao.removeYearlyCostCodeAlpsa(actCostMonBudgetVOs[0].getBseYr());
			dbDao.createYearlyBudgetCostCodeAlpsa(indateVoList);
		}
		
	} catch (DAOException ex) {
		log.error("err "+ex.toString(),ex);
		throw new EventException(new ErrorHandler("LEA00007").getUserMessage());		
	} catch (Exception ex) {
		log.error("err "+ex.toString(),ex);
		throw new EventException(new ErrorHandler("LEA00007").getUserMessage());		
	}	
 }

/** ESD_LEA_0022 : save<br>
 * 년도별 Monthly Budget을을 저장한다.HJSALPSA<br>
 *  
 * @param ActCostMonBudgetVO[] actCostMonBudgetVOs
 * @param String creUsrId
 * @exception EventException
 */		
public void modifyYearlyCostBudgetAlpsa(ActCostMonBudgetVO[] actCostMonBudgetVOs, String creUsrId) throws EventException {
	List<ActCostMonBudgetVO> updateVoList = new ArrayList<ActCostMonBudgetVO>();
	List<ActCostMonBudgetVO> indateVoList = new ArrayList<ActCostMonBudgetVO>();
	
	try {
		
		for ( int i=0; i<actCostMonBudgetVOs.length; i++ ) {
			if (actCostMonBudgetVOs[i].getIbflag().equals("U")){		
			
				actCostMonBudgetVOs[i].setUpdUsrId(creUsrId);										
				actCostMonBudgetVOs[i].setMnlFlg("Y");
				updateVoList.add(actCostMonBudgetVOs[i]);
				
			}else if(actCostMonBudgetVOs[i].getIbflag().equals("I")){
				actCostMonBudgetVOs[i].setCreUsrId(creUsrId);										
				actCostMonBudgetVOs[i].setMnlFlg("Y");
				indateVoList.add(actCostMonBudgetVOs[i]);
			}
		}		
		
		if ( updateVoList.size() > 0) {
			dbDao.modifyYearlyCostBudgetAlpsa(updateVoList);
		}
		
		if ( indateVoList.size() > 0) {
			dbDao.createYearlyCostBudgetAlpsa(indateVoList);
		}
		
	} catch (DAOException ex) {
		log.error("err "+ex.toString(),ex);
		throw new EventException(new ErrorHandler("LEA00007").getUserMessage());		
	} catch (Exception ex) {
		log.error("err "+ex.toString(),ex);
		throw new EventException(new ErrorHandler("LEA00007").getUserMessage());		
	}	
 }

}