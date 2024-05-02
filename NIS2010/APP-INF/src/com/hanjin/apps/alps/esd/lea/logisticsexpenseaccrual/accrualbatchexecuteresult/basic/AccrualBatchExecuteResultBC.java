/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualBatchExecuteResultBC.java
*@FileTitle : 결산 프로그램 결과 Reporting
*Open Issues :
*Change history : 2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.07.31
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.07.31 Jeon Jae Hong
* 1.0 Creation
* 
* 2011.10.31 [CHM-201114105] [LEA] ALPS UI에 조정계수 입력화면 Accrual Adjustment 추가
* 2011.12.26 [CHM-201115071] [LEA] Full Volume Incentive Auto 변환 관련 화면변경 요청
* 2012.03.22 황효근 [CHM-201216821] [LEA] ALPS Accrual Result의 By Account Code (Final) 보완 : 조정계수 반영
* 2015.04.10 KIM HYUN HWA/HYUN SUNG KIL[CHM-201534996]LEA_Expense Report 에 화면 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.AccrualAdjustmentVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.ActCostMonBudgetVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchACBMInquiryVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualAccountCodeVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchExecuteResultHistoryListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultBookingListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultContainerTPSZListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultExecuteMonthListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultInvoiceInquiryVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultOfficeListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultRevenueMonthListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualRevenueVVDCodeListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchCostCodeListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchCostTypeCodeComboListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchSubCostTypeCodeComboListVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-Logisticsexpenseaccrual Business Logic Command Interface<br>
 * - ALPS-Logisticsexpenseaccrual에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jeon Jae Hong
 * @see Esd_lea_0901EventResponse 참조
 * @since J2EE 1.6
 */
 
public interface AccrualBatchExecuteResultBC {
	/**
	 * Cost Code를 조회한다.<br>
	 * 
	 * @param SearchCostCodeListVO	searchCostCodeListVO
	 * @return List<SearchCostCodeListVO>
	 * @exception EventException
	 */
	public List<SearchCostCodeListVO> searchCostCodeList(SearchCostCodeListVO searchCostCodeListVO) throws EventException;
	
	/**
	 * Cost Code의 Main Cost Type을 조회한다.<br>
	 * 
	 * @param SearchCostTypeCodeComboListVO searchCostTypeCodeComboListVO
	 * @return List<SearchCostTypeCodeComboListVO>
	 * @exception EventException
	 */
	public List<SearchCostTypeCodeComboListVO> searchCostTypeCodeComboList(SearchCostTypeCodeComboListVO searchCostTypeCodeComboListVO) throws EventException;
	
	/**
	 * Cost Code의 Sub Cost Type 을 조회한다..<br>
	 * 
	 * @param SearchSubCostTypeCodeComboListVO searchSubCostTypeCodeComboListVO
	 * @return List<SearchSubCostTypeCodeComboListVO>
	 * @exception EventException
	 */
	public List<SearchSubCostTypeCodeComboListVO> searchSubCostTypeCodeComboList(SearchSubCostTypeCodeComboListVO searchSubCostTypeCodeComboListVO) throws EventException;
	
	/**
	 * Account Code List 를 조회한다.<br>
	 * 
	 * @param SearchAccrualAccountCodeVO	searchAccrualAccountCodeVO
	 * @return List<SearchAccrualAccountCodeVO>
	 * @exception EventException
	 */
	public List<SearchAccrualAccountCodeVO> searchAccrualAccountCodeList(SearchAccrualAccountCodeVO searchAccrualAccountCodeVO) throws EventException;
	
	/**
	 * 수입대상항차 List 를 조회한다.<br>
	 * 
	 * @param SearchAccrualRevenueVVDCodeListVO	searchAccrualRevenueVVDCodeListVO
	 * @return List<SearchAccrualRevenueVVDCodeListVO>
	 * @exception EventException
	 */
	public List<SearchAccrualRevenueVVDCodeListVO> searchAccrualRevenueVVDCodeList(SearchAccrualRevenueVVDCodeListVO searchAccrualRevenueVVDCodeListVO) throws EventException;
	
	
	/**
	 * 결산 배치 결과 BKG LIST 를 조회한다.<br>
	 * 
	 * @param SearchAccrualBatchResultBookingListVO	searchAccrualBatchResultBookingListVO
	 * @return List<SearchAccrualBatchResultBookingListVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchResultBookingListVO> searchAccrualBatchResultBookingList(SearchAccrualBatchResultBookingListVO searchAccrualBatchResultBookingListVO) throws EventException;
	
	/**
	 * 결산 배치 결과 CNTR List 를 조회한다.<br>
	 * 
	 * @param SearchAccrualBatchResultContainerTPSZListVO	searchAccrualBatchResultContainerTPSZListVO
	 * @return List<SearchAccrualBatchResultContainerTPSZListVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchResultContainerTPSZListVO> searchAccrualBatchResultContainerTPSZList(SearchAccrualBatchResultContainerTPSZListVO searchAccrualBatchResultContainerTPSZListVO) throws EventException;
	
	/**
	 * 결산 배치 History 를 조회한다.<br>
	 * 
	 * @param SearchAccrualBatchExecuteResultHistoryListVO searchAccrualBatchExecuteResultHistoryListVO
	 * @return List<SearchAccrualBatchExecuteResultHistoryListVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchExecuteResultHistoryListVO> searchAccrualBatchExecuteResultHistoryList(SearchAccrualBatchExecuteResultHistoryListVO searchAccrualBatchExecuteResultHistoryListVO) throws EventException;
	
	
	/**
	 * 결산 배치 결과를 Revenue Month 기준으로 조회한다.<br>
	 * 
	 * @param SearchAccrualBatchResultRevenueMonthListVO	searchAccrualBatchResultRevenueMonthListVO
	 * @return List<SearchAccrualBatchResultRevenueMonthListVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchResultRevenueMonthListVO> searchAccrualBatchResultRevenueMonthList(SearchAccrualBatchResultRevenueMonthListVO searchAccrualBatchResultRevenueMonthListVO) throws EventException;
	
	
	/**
	 * 결산 배치 결과를 Execute Month 기준으로 조회한다.<br>
	 * 
	 * @param SearchAccrualBatchResultExecuteMonthListVO	searchAccrualBatchResultExecuteMonthListVO
	 * @return List<SearchAccrualBatchResultExecuteMonthListVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchResultExecuteMonthListVO> searchAccrualBatchResultExecuteMonthList(SearchAccrualBatchResultExecuteMonthListVO searchAccrualBatchResultExecuteMonthListVO) throws EventException;
	
	
	/**
	 * 결산 배치 결과를 Office 기준으로 조회한다.<br>
	 * 
	 * @param SearchAccrualBatchResultOfficeListVO	searchAccrualBatchResultOfficeListVO
	 * @return List<SearchAccrualBatchResultOfficeListVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchResultOfficeListVO> searchAccrualBatchResultOfficeList(SearchAccrualBatchResultOfficeListVO searchAccrualBatchResultOfficeListVO) throws EventException;
	
	
	/**
	 * Invoice 정보를 조회한다.<br>
	 * 
	 * @param SearchAccrualBatchResultInvoiceInquiryVO searchAccrualBatchResultInvoiceInquiryVO
	 * @return List<SearchAccrualBatchResultInvoiceInquiryVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchResultInvoiceInquiryVO> searchAccrualBatchResultInvoiceInquiry(SearchAccrualBatchResultInvoiceInquiryVO searchAccrualBatchResultInvoiceInquiryVO) throws EventException;
	
	/** 
	 * ACBM Report 에대한 조회<br>
	 * @param SearchACBMInquiryVO searchACBMInquiryVO
	 * @return List<SearchACBMInquiryVO>
	 * @exception EventException
	 */
	public List<SearchACBMInquiryVO> searchACBMInquiry(SearchACBMInquiryVO searchACBMInquiryVO) throws EventException;
	

	/** 
	 * AccrualBatchExecuteResultAccountList화면에 대한 조회<br>
	 * 
	 * @param e Event
	 * @return response ESD_LEA_002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAccrualBatchResultAccountList(Event e) throws EventException;
	
	/** 
	 * AccrualBatchExecuteResultAccountFinalList화면에 대한 조회<br>
	 * 
	 * @param e Event
	 * @return response ESD_LEA_003EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAccrualBatchResultAccountFinalList(Event e) throws EventException;
	
	/** 
	 * searchAccrualBatchResultAccountFinalLastExeYrmon 화면에 대한 조회<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchAccrualBatchResultAccountFinalLastExeYrmon() throws EventException;
	
	/**
	 * Manual Input 화면의 List 를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response ESD_LEA_002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAccrualBatchResultManualInputList(Event e) throws EventException;
	
	/**
	 * AccrualBatchExecuteResultFinalManualInput화면 조회<br>
	 * 
	 * @param e Event
	 * @return response ESD_LEA_002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAccrualBatchResultFinalManualInputList(Event e) throws EventException;
	
	/**
	 * AccrualBatchExecuteResultAccountList화면에 대한 Confirm Modify <br>
	 * 
	 * @param Event e
	 * @param SignOnUserAccount account
	 * @return response ESD_LEA_002EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyAccrualBatchResultAccountConfirm(Event e, SignOnUserAccount account) throws EventException;
	
	
	
	//public EventResponse getAccrualBatchExecuteSearchMonth() throws EventException;
	
	/**
	 * Manual Input 대상 ACCT 에 대한 Modify <br>
	 * 
	 * @param Event e
	 * @param SignOnUserAccount account
	 * @return response ESD_LEA_002EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyAccrualBatchResultManualInput(Event e, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * AccrualBatchExecuteResultManualInput화면에 대한 Condition 조회 <br>
	 * 
	 * @param e Event
	 * @return response ESD_LEA_002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAccrualConditionItemFlags(Event e) throws EventException;
	
	
	/**
	 * 조정계수를 조회한다.<br>
	 * 
	 * @param AccrualAdjustmentVO accrualAdjustmentVO
	 * @return List<AccrualAdjustmentVO>
	 * @exception EventException
	 */			
	public List<AccrualAdjustmentVO> searchAccrualAdjustmentList(AccrualAdjustmentVO accrualAdjustmentVO) throws EventException;	
	
	
	/**
	 * 조정계수를 저장한다.<br>
	 * 
	 * @param AccrualAdjustmentVO[] accrualAdjustmentVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAccrualAdjustment(AccrualAdjustmentVO[] accrualAdjustmentVOs, SignOnUserAccount account) throws EventException;	
	

	/**
	 * 조정계수 이력을 저장한다.<br>
	 * 
	 * @param AccrualAdjustmentVO accrualAdjustmentVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAccrualApply(AccrualAdjustmentVO accrualAdjustmentVO, SignOnUserAccount account) throws EventException;	
	
	
	/**
	 * 조정계수 이력 배치를 실행한다.<br>
	 * 
	 * @param AccrualAdjustmentVO accrualAdjustmentVO
	 * @return String 
	 * @exception EventException
	 */
	public String executeAccrualApplyBatch(AccrualAdjustmentVO accrualAdjustmentVO) throws EventException;	

	
	/**
	 * Office Type Check.<br>
	 * 
	 * @param String ofc_cd
	 * @return String 
	 * @exception EventException
	 */
	public String searchOfficeTypeCheck(String ofc_cd) throws EventException;
	
	/**
	 * searchRhqOffice<br>
	 * 
	 * @param String ofc_cd
	 * @return String 
	 * @exception EventException
	 */
	public String searchRhqOffice(String ofc_cd) throws EventException;	
	
	/**
	 * ESD_LEA_0021 : save<br>
	 * ACCL_ADJ_FCTR_FNL_FLG을 저장한다.<br>
	 * 
	 * @param AccrualAdjustmentVO accrualAdjustmentVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAcclAdjFctrFnlFlg(AccrualAdjustmentVO accrualAdjustmentVO, SignOnUserAccount account) throws EventException;

	/**
	 * YearlyCostBudget 정보를 조회한다.<br>
	 * 
	 * @param String bseYr
	 * @param String rhqCd
	 * @return List<ActCostMonBudgetVO>
	 * @exception EventException
	 */
	public List<ActCostMonBudgetVO> searchYearlyCostBudget(String bseYr, String rhqCd) throws EventException;
	
	/**
	 * ESD_LEA_0022 : save<br>
	 * 년도별 Monthly Budget 을 신규생성한다.<br>
	 * 
     * @param ActCostMonBudgetVO[] actCostMonBudgetVOs
     * @param String creUsrId
	 * @exception EventException
	 */
	public void createYearlyBudgetCostCode(ActCostMonBudgetVO[] actCostMonBudgetVOs, String creUsrId) throws EventException;
	
	/**
	 * ESD_LEA_0022 : save<br>
	 * 년도별 Monthly Budget 을 수정한다.<br>
	 * 
	 * @param ActCostMonBudgetVO[] actCostMonBudgetVOs
	 * @param creUsrId
	 * @exception EventException
	 */
	public void modifyYearlyCostBudget(ActCostMonBudgetVO[] actCostMonBudgetVOs, String creUsrId) throws EventException;
	
	
	/**
	 * BudGet 생성 프로시저를 실행한다<br>
	 * 
	 * @param String bseYr
	 * @return String 
	 * @exception EventException
	 */
	public String executeYearlyCostBudget(String bseYr) throws EventException;	
	
	/**
	 * ESD_LEA_0022 : save<br>
	 * 년도별 Monthly Budget 을 신규생성한다.<br>
	 * 
     * @param ActCostMonBudgetVO[] actCostMonBudgetVOs
     * @param String creUsrId
	 * @exception EventException
	 */
	public void createYearlyBudgetCostCodeAlpsa(ActCostMonBudgetVO[] actCostMonBudgetVOs, String creUsrId) throws EventException;

	/**
	 * ESD_LEA_0022 : save<br>
	 * 년도별 Monthly Budget 을 수정한다.<br>
	 * 
	 * @param ActCostMonBudgetVO[] actCostMonBudgetVOs
	 * @param creUsrId
	 * @exception EventException
	 */
	public void modifyYearlyCostBudgetAlpsa(ActCostMonBudgetVO[] actCostMonBudgetVOs, String creUsrId) throws EventException;
	



}

