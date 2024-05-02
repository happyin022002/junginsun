/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LogisticsExpenseAccrualSC.java
*@FileTitle : Rev.VVD Inquiry (Pop-up)
*Open Issues :
*Change history : 2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.07.31
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.07.31 전재홍
* 1.0 Creation
* 
* 2011.10.31 [CHM-201114105] [LEA] ALPS UI에 조정계수 입력화면 Accrual Adjustment 추가
* 2011.12.26 [CHM-201115071] [LEA] Full Volume Incentive Auto 변환 관련 화면변경 요청
* 2012.02.23 황효근 [CHM-201216046] [LEA] ALPS 결산 Result 및 Expense Report 화면 조정관련3
* 2012.03.22 황효근 [CHM-201216821] [LEA] ALPS Accrual Result의 By Account Code (Final) 보완 : 조정계수 반영
* 2014.12.23 [CHM-201433314]CSR IF Inquiry 및 CSR Monitoring Inquiry 화면 보완
* 2015.04.10 KIM HYUN HWA/HYUN SUNG KIL[CHM-201534996]LEA_Expense Report 에 화면 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual;

import java.util.List;

import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.basic.AccrualBatchExecuteResultBC;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.basic.AccrualBatchExecuteResultBCImpl;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0002Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0003Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0004Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0005Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0006Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0007Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0008Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0010Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0014Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0015Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0016Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0021Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0901Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0902Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0022Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration.AccrualBatchExecuteResultDBDAO;
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
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.basic.AccrualBatchManageBC;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.basic.AccrualBatchManageBCImpl;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.event.EsdLea0001Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.vo.SearchAccrualBatchPreConditionVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualemailsetting.basic.AccrualEmailSettingBC;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualemailsetting.basic.AccrualEmailSettingBCImpl;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualemailsetting.event.EsdLea0009Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SearchAccrualEmailSettingVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SearchParameterAccrualEmailSettingVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.basic.ActualCostCSRManageBC;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.basic.ActualCostCSRManageBCImpl;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.event.EsdLea0011Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.event.EsdLea0012Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.event.EsdLea0013Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.event.EsdLea0017Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchActualCostCSRListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchActualCostCSRMonitoringListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchCsrListByGLMonthVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchRVVDChangeActualCostCSRListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

 
/**
 * ALPS-LogisticsExpenseAccrual Business Logic ServiceCommand - ALPS-LogisticsExpenseAccrual 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Jeon Jae Hong
 * @see AccrualBatchExecuteResultDBDAO
 * @since J2EE 1.6
 */

public class LogisticsExpenseAccrualSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * LogisticsExpenseAccrual system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("LogisticsExpenseAccrualSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * LogisticsExpenseAccrual system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("LogisticsExpenseAccrualSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-LogisticsExpenseAccrual system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *  
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdLea0010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCostCodeList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCostTypeCodeComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSubCostTypeCodeComboList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = getCodeComboList(e);					
			}
			
		}else if (e.getEventName().equalsIgnoreCase("EsdLea0901Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccrualAccountCodeList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdLea0902Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccrualRevenueVVDCodeList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdLea0004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccrualBatchResultBookingList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdLea0005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccrualBatchResultContainerTPSZList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdLea0008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccrualBatchExecuteResultHistoryList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdLea0012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchActualCostCSRList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdLea0013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchActualCostCSRMonitoringList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdLea0006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccrualBatchResultRevenueMonthList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)){
				eventResponse = searchOfficeTypeCheck(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)){
				eventResponse = searchRhqOffice(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdLea0007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccrualBatchResultExecuteMonthList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdLea0009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAccrualEmailSetting(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchParameterAccrualEmailSetting(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = sendTestAccrualEmailSetting(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyAccrualEmailSetting(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdLea0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccrualBatchResultOfficeList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)){
				eventResponse = searchOfficeTypeCheck(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)){
				eventResponse = searchRhqOffice(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdLea0015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccrualBatchResultInvoiceInquiry(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)){
				eventResponse = searchOfficeTypeCheck(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)){
				eventResponse = searchRhqOffice(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdLea0016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchACBMInquiry(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)){
				eventResponse = searchOfficeTypeCheck(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)){
				eventResponse = searchRhqOffice(e);
			}			
		}else if (e.getEventName().equalsIgnoreCase("EsdLea0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccrualBatchPreCondition(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = modifyAccrualBatchPreConditionConfirm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = executeAccrualBatch(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdLea0011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRVVDChangeActualCostCSRList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdLea0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//Pair = SEARCH:SEARCH01
				eventResponse = searchAccrualBatchResultAccountList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {		//Pair = SEARCH:SEARCH01
				eventResponse = searchAccrualBatchResultManualInputList(e);
				
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {		//ESD_LEA_0002."Confirm" Button
				eventResponse = modifyAccrualBatchResultAccountConfirm(e);
				
					
			//ESD_LEA_0002 Sheet#2번에 Data Loading (Hidden Sheet 아님, 전체3개 Sheet 존재)
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAccrualConditionItemFlags(e);
				
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		//ESD_LEA_0002."Save" Button
				eventResponse = modifyAccrualBatchResultManualInput(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsdLea0003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//Pair = SEARCH:SEARCH01
				eventResponse = searchAccrualBatchResultAccountFinalList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {		//Pair = SEARCH:SEARCH01
				eventResponse = searchAccrualBatchResultFinalManualInputList(e);
				
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {		//ESD_LEA_0002."Confirm" Button
				eventResponse = modifyAccrualBatchResultAccountConfirm(e);
				
					
			//ESD_LEA_0002 Sheet#2번에 Data Loading (Hidden Sheet 아님, 전체3개 Sheet 존재)
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAccrualBatchResultAccountFinalLastExeYrmon(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsdLea0021Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {	
				eventResponse = searchAccrualAdjustmentList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)){ 			
				eventResponse = manageAccrualAdjustment(e);			
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)){ 			
				eventResponse = manageAccrualApply(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)){
				eventResponse = executeAccrualApplyBatch(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI03)){
				eventResponse = manageAcclAdjFctrFnlFlg(e);					
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdLea0022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {	
				eventResponse = searchYearlyCostBudget(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)){ 			
				eventResponse = manageYearlyCostBudget(e);			
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)){ 			
				eventResponse = createYearlyBudgetCostCode(e);			
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)){ 			
				eventResponse = executeYearlyCostBudget(e);			
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI03)){ 			
				eventResponse = manageYearlyCostBudgetAlpsa(e);			
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI04)){ 			
				eventResponse = createYearlyBudgetCostCodeAlpsa(e);			
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdLea0017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchActualCostCsrListByGLMonth(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)){
				eventResponse = searchOfficeTypeCheck(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)){
				eventResponse = searchRhqOffice(e);
			}	
		}	
		return eventResponse;
	}
	
	/**
	 * ESD_LEA_0010 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */ 

	private EventResponse searchCostCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0010Event event = (EsdLea0010Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();

		try{
			List<SearchCostCodeListVO> list = command.searchCostCodeList(event.getSearchCostCodeListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	private EventResponse searchCostTypeCodeComboList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0010Event event = (EsdLea0010Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();

		try{
			List<SearchCostTypeCodeComboListVO> list = command.searchCostTypeCodeComboList(event.getSearchCostTypeCodeComboListVO());	
			eventResponse.setRsVoList(list);	
			eventResponse.setETCData("mainCostType" , list.get(0).getMnCostTpCd());
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	 
	private EventResponse searchSubCostTypeCodeComboList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0010Event event = (EsdLea0010Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();

		try{
			List<SearchSubCostTypeCodeComboListVO> list = command.searchSubCostTypeCodeComboList(event.getSearchSubCostTypeCodeComboListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * ESD_LEA_0010 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */ 
	private EventResponse getCodeComboList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		EsdLea0010Event 			event 			= (EsdLea0010Event)e;
		DBRowSet					rowSet			= null;
		
		String						sCostKind			= null;
		String						sMainCostTypeCode	= null;
		
		try{
			sCostKind			= event.getCostKind();
			sMainCostTypeCode	= event.getMainCostTypeCode();
			
			rowSet = com.hanjin.apps.alps.esd.lea.common.CodeComboUtil.getCodeComboList20(sCostKind, sMainCostTypeCode);
			eventResponse.setRs(rowSet);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}		
	
	
	
	
	/**
	 * ESD_LEA_0901 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccrualAccountCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0901Event event = (EsdLea0901Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();

		try{
			List<SearchAccrualAccountCodeVO> list = command.searchAccrualAccountCodeList(event.getSearchAccrualAccountCodeVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESD_LEA_0902 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccrualRevenueVVDCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0902Event event = (EsdLea0902Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();

		try{
			List<SearchAccrualRevenueVVDCodeListVO> list = command.searchAccrualRevenueVVDCodeList(event.getSearchAccrualRevenueVVDCodeListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESD_LEA_0004 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccrualBatchResultBookingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0004Event event = (EsdLea0004Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();

		try{
			List<SearchAccrualBatchResultBookingListVO> list = command.searchAccrualBatchResultBookingList(event.getSearchAccrualBatchResultBookingListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESD_LEA_0005 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccrualBatchResultContainerTPSZList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0005Event event = (EsdLea0005Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();

		try{
			List<SearchAccrualBatchResultContainerTPSZListVO> list = command.searchAccrualBatchResultContainerTPSZList(event.getSearchAccrualBatchResultContainerTPSZListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESD_LEA_0008 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccrualBatchExecuteResultHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0008Event event = (EsdLea0008Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();

		try{
			List<SearchAccrualBatchExecuteResultHistoryListVO> list = command.searchAccrualBatchExecuteResultHistoryList(event.getSearchAccrualBatchExecuteResultHistoryListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESD_LEA_0012 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActualCostCSRList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0012Event event = (EsdLea0012Event)e;
		ActualCostCSRManageBC command = new ActualCostCSRManageBCImpl();

		try{
			List<SearchActualCostCSRListVO> list = command.searchActualCostCSRList(event.getSearchActualCostCSRListVO());
			
			// 페이징에 관계없이 전체 건수 표현-------------------------------------------------이용준 추가 2014.12.17(paging을 위해추가)
			if(list!=null && list.size()>0){
				list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
			}
			
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESD_LEA_0013 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActualCostCSRMonitoringList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0013Event event = (EsdLea0013Event)e;
		ActualCostCSRManageBC command = new ActualCostCSRManageBCImpl();

		try{
			List<SearchActualCostCSRMonitoringListVO> list = command.searchActualCostCSRMonitoringList(event.getSearchActualCostCSRMonitoringListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESD_LEA_0006 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccrualBatchResultRevenueMonthList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsdLea0006Event event = (EsdLea0006Event)e;		
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();
		
		try{
			List<SearchAccrualBatchResultRevenueMonthListVO> list = command.searchAccrualBatchResultRevenueMonthList(event.getSearchAccrualBatchResultRevenueMonthListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESD_LEA_0007 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccrualBatchResultExecuteMonthList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0007Event event = (EsdLea0007Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();

		try{
			List<SearchAccrualBatchResultExecuteMonthListVO> list = command.searchAccrualBatchResultExecuteMonthList(event.getSearchAccrualBatchResultExecuteMonthListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESD_LEA_0009 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccrualEmailSetting(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0009Event event = (EsdLea0009Event)e;
		AccrualEmailSettingBC command = new AccrualEmailSettingBCImpl();

		try{
			List<SearchAccrualEmailSettingVO> list = command.searchAccrualEmailSetting(event.getSearchAccrualEmailSettingVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_LEA_0009 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchParameterAccrualEmailSetting(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0009Event event = (EsdLea0009Event)e;
		AccrualEmailSettingBC command = new AccrualEmailSettingBCImpl();

		try{
			List<SearchParameterAccrualEmailSettingVO> list = command.searchParameterAccrualEmailSetting(event.getSearchParameterAccrualEmailSettingVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_LEA_0009 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendTestAccrualEmailSetting(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0009Event event = (EsdLea0009Event)e;
		AccrualEmailSettingBC command = new AccrualEmailSettingBCImpl();

		try{
			//begin();
			command.sendTestAccrualEmailSetting(event.getSearchParameterAccrualEmailSettingVO());
//			eventResponse.setRsVoList(list);
//			List<SendTestAccrualEmailSetting> list
			//commit();
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			//rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
//	private EventResponse sendTestAccrualEmailSetting(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		ESD_LEA_009Event event = (ESD_LEA_009Event)e;
//		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
//		ESD_LEA_009EventResponse eventResponse = null;
//		
//		try {
//			begin();
//			AccrualEmailSettingBCImpl command = new AccrualEmailSettingBCImpl();
//			eventResponse = (ESD_LEA_009EventResponse)command.sendTestAccrualEmailSetting(event);
//			commit();
//		} catch (EventException de) {
//			rollback();
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
//		//return this.searchAccrualEmailSetting();
//	}
	
	/**
	 * ESD_LEA_0009 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyAccrualEmailSetting(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0009Event event = (EsdLea0009Event)e;
		AccrualEmailSettingBC command = new AccrualEmailSettingBCImpl();
		
				
		try{
			begin();
			command.modifyAccrualEmailSetting(event.getLeaEmlSetVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESD_LEA_0014 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccrualBatchResultOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0014Event event = (EsdLea0014Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();

		try{
			List<SearchAccrualBatchResultOfficeListVO> list = command.searchAccrualBatchResultOfficeList(event.getSearchAccrualBatchResultOfficeListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESD_LEA_0015 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccrualBatchResultInvoiceInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0015Event event = (EsdLea0015Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();

		try{
			List<SearchAccrualBatchResultInvoiceInquiryVO> list = command.searchAccrualBatchResultInvoiceInquiry(event.getSearchAccrualBatchResultInvoiceInquiryVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * ESD_LEA_0016 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchACBMInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0016Event event = (EsdLea0016Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();

		try{
			List<SearchACBMInquiryVO> list = command.searchACBMInquiry(event.getSearchACBMInquiryVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	
	
	
	/**
	 * ESD_LEA_0001 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccrualBatchPreCondition(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0001Event event = (EsdLea0001Event)e;
		AccrualBatchManageBC command = new AccrualBatchManageBCImpl();

		try{
			List<SearchAccrualBatchPreConditionVO> list = command.searchAccrualBatchPreCondition(event.getSearchAccrualBatchPreConditionVO(), account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESD_LEA_0001 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * @param frm_confirm_div 
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyAccrualBatchPreConditionConfirm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0001Event event = (EsdLea0001Event)e;
		AccrualBatchManageBC command = new AccrualBatchManageBCImpl();
	
		try{
			begin();
			command.modifyAccrualBatchPreConditionConfirm(event.getFrmExeYrmon() , event.getFrmConfirmDiv(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESD_LEA_0001 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * @param frm_confirm_div 
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse executeAccrualBatch(Event e) throws EventException {
		  // PDTO(Data Transfer Object including Parameters)
		  GeneralEventResponse eventResponse = new GeneralEventResponse();
		  EsdLea0001Event event = (EsdLea0001Event)e;
		  AccrualBatchManageBC command = new AccrualBatchManageBCImpl();
		  
		  String sBatchExeResult = null;
		 
		  try {
		   begin();  
		   sBatchExeResult = command.executeAccrualBatch(event.getFrmExeYrmon());
		   eventResponse.setETCData("BATCH_EXE_RESULT", sBatchExeResult);
		   commit();
		  } catch(EventException ex) {
		   rollback();
		   log.error("err " + ex.toString(), ex);
		   throw ex;
		  } catch(Exception ex) {
		   rollback();
		   log.error("err " + ex.toString(), ex);
		   throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		  } 
		  return eventResponse;
		 }

	
	
	/**
	 * ESD_LEA_0011 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRVVDChangeActualCostCSRList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0011Event event = (EsdLea0011Event)e;
		ActualCostCSRManageBC command = new ActualCostCSRManageBCImpl();

		try{
			List<SearchRVVDChangeActualCostCSRListVO> list = command.searchRVVDChangeActualCostCSRList(event.getSearchRVVDChangeActualCostCSRListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

//	/**
//	 * ESD_LEA_0011 : [이벤트]<br>
//	 * [비즈니스대상]을 [행위]합니다.<br>
//	 * 
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse newCSRCreation(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EsdLea0011Event event = (EsdLea0011Event)e;
//		
//		try {
//			
//			String inv_sys_id = event.getLeaRevVvdCngVO().getInvSysId();
//
//			if(inv_sys_id != null && inv_sys_id != ""){
//				if (inv_sys_id.equals("TRS")) {
//					//TRS - Method name change(08/02/25)
//					CSRIssueTransferSlipManageBC trs_command = new CSRIssueTransferSlipManageBCImpl();
//					trs_command.applyChgRevenueVVD(event.getLeaRevVvdCngVO(),event.getSignOnUserAccount());
//				} else if(inv_sys_id.equals("TES")) {
//					//TES		
//					CARIssueTransferSlipManageBC tes_command = new CARIssueTransferSlipManageBCImpl();
//					tes_command.chgLEARevVVD(event.getLeaRevVvdCngVO(),event.getSignOnUserAccount());
//				}
//			}
//			
//			ActualCostCSRManageBC command = new ActualCostCSRManageBCImpl();
//			List<SearchRVVDChangeActualCostCSRListVO> list = command.searchRVVDChangeActualCostCSRList(event.getSearchRVVDChangeActualCostCSRListVO());
//			eventResponse.setRsVoList(list);
//		
//			
//		} catch (EventException de) {
//			rollback();
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		} catch(Exception ex){
//			throw new EventException(ex.getMessage(), ex);
//		}		
//
//		return eventResponse;
//	}	
	
	
	/**
	 * AccrualBatchExecuteResultAccountList화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EsdLea0002EventResponse
	 * @exception EventException
	 */
	//ESD_LEA_0002.SEARCH
	private EventResponse searchAccrualBatchResultAccountList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdLea0002Event 		event 			= (EsdLea0002Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			//begin();
			AccrualBatchExecuteResultBCImpl command = new AccrualBatchExecuteResultBCImpl();
			eventResponse = (GeneralEventResponse)command.searchAccrualBatchResultAccountList(event);
			//commit();
		} catch (EventException de) {
			//rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * AccrualBatchExecuteResultManualInputg화면 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EsdLea0002EventResponse
	 * @exception EventException
	 */
	//ESD_LEA_0002.SEARCH01	
	private EventResponse searchAccrualBatchResultManualInputList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)

		EsdLea0002Event 		event 			= (EsdLea0002Event)e;
		
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			//begin();
			AccrualBatchExecuteResultBCImpl command = new AccrualBatchExecuteResultBCImpl();
			eventResponse = (GeneralEventResponse)command.searchAccrualBatchResultManualInputList(event);
			//commit();
		} catch (EventException de) {
			//rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * AccrualBatchResultFinalManualInputList 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccrualBatchResultFinalManualInputList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
//		EsdLea0003Event 		event 			= (EsdLea0003Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();
			eventResponse = (GeneralEventResponse)command.searchAccrualBatchResultFinalManualInputList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * AccrualBatchExecuteResultManualInputg화면 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EsdLea0002EventResponse
	 * @exception EventException
	 */
	//ESD_LEA_0002.SEARCH02
	private EventResponse searchAccrualConditionItemFlags(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdLea0002Event 		event 			= (EsdLea0002Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			begin();
			AccrualBatchExecuteResultBCImpl command = new AccrualBatchExecuteResultBCImpl();
			eventResponse = (GeneralEventResponse)command.searchAccrualConditionItemFlags(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * Confirm Modify  이벤트 처리<br>
	 * AccrualBatchExecuteResultAccountList화면에 대한 Confirm Modify 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EsdLea0002EventResponse
	 * @exception EventException
	 */
	//ESD_LEA_0002.MODIFY (Button.Confirm)
	private EventResponse modifyAccrualBatchResultAccountConfirm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdLea0002Event 		event 			= (EsdLea0002Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			begin();
			AccrualBatchExecuteResultBCImpl command = new AccrualBatchExecuteResultBCImpl();
			////eventResponse = (GeneralEventResponse)command.modifyAccrualBatchResultAccountConfirm(event.getSearchAccrualBatchResultAccountListVOs(), account);
			eventResponse = (GeneralEventResponse)command.modifyAccrualBatchResultAccountConfirm(event, account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
		
	}
	
		
	/**
	 * MULTI  이벤트 처리<br>
	 * AccrualBatchResultManualInput화면에 대한 MULTI  이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EsdLea0002EventResponse
	 * @exception EventException
	 */
	//ESD_LEA_0002.MULTI "TAB.Manual_Input" (Button.Save)
	private EventResponse modifyAccrualBatchResultManualInput(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdLea0002Event 		event 			= (EsdLea0002Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			begin();
			AccrualBatchExecuteResultBCImpl command = new AccrualBatchExecuteResultBCImpl();
			eventResponse = (GeneralEventResponse)command.modifyAccrualBatchResultManualInput(event, account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
		//return this.searchAccrualBatchResultManualInputList(e);
	}

	/**
	 * AccrualBatchExecuteResultAccountFinalList화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EsdLea0003EventResponse
	 * @exception EventException
	 */
	//ESD_LEA_0003.SEARCH
	private EventResponse searchAccrualBatchResultAccountFinalList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdLea0003Event 		event 			= (EsdLea0003Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			//begin();
			AccrualBatchExecuteResultBCImpl command = new AccrualBatchExecuteResultBCImpl();
			eventResponse = (GeneralEventResponse)command.searchAccrualBatchResultAccountFinalList(event);
			//commit();
		} catch (EventException de) {
			//rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	
	
	/**
	 * searchAccrualBatchResultAccountFinalLastExeYrmon 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EsdLea0003EventResponse
	 * @exception EventException
	 */
	//ESD_LEA_0003.SEARCH
	private EventResponse searchAccrualBatchResultAccountFinalLastExeYrmon(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
//		EsdLea0003Event 		event 			= (EsdLea0003Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		String max_exe_yrmon_month = null;
		try {
			//begin();
			AccrualBatchExecuteResultBCImpl command = new AccrualBatchExecuteResultBCImpl();
			max_exe_yrmon_month = command.searchAccrualBatchResultAccountFinalLastExeYrmon();
//			eventResponse = (GeneralEventResponse)command.searchAccrualBatchResultAccountFinalLastExeYrmon(event);
			eventResponse.setETCData("max_exe_yrmon_month", max_exe_yrmon_month);
			//commit();
		} catch (EventException de) {
			//rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESD_LEA_0021 : retrieve<br>
	 * 조정계수를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchAccrualAdjustmentList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0021Event event = (EsdLea0021Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();

		try{
			eventResponse.setRsVoList(command.searchAccrualAdjustmentList(event.getAccrualAdjustmentVO()));
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;			
	}	
	
	/**
	 * ESD_LEA_0021 : save<br>
	 * 조정계수를 저장한다.<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAccrualAdjustment(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0021Event event = (EsdLea0021Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();
		
		try{
			begin();			
			command.manageAccrualAdjustment(event.getAccrualAdjustmentVOS(),account);
// 			js에서 '저장메시지'를 보여준다.			
//			eventResponse.setUserMessage(new ErrorHandler("MST00003").getMessage());
			commit();			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * ESD_LEA_0021 : save<br>
	 * 조정계수 이력을 저장한다.<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAccrualApply(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0021Event event = (EsdLea0021Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();
		
		try{
			begin();			
			command.manageAccrualApply(event.getAccrualAdjustmentVO(),account);
// 			js에서 '저장메시지'를 보여준다.			
//			eventResponse.setUserMessage(new ErrorHandler("MST00003").getMessage());
			commit();			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}		
	
	/**
	 * ESD_LEA_0021 : batch<br>
	 * 조정계수 프로시져 실행한다.<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse executeAccrualApplyBatch(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0021Event event = (EsdLea0021Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();
		
		String sBatchExeResult = null;
		
		try{
			begin();			
			sBatchExeResult = command.executeAccrualApplyBatch(event.getAccrualAdjustmentVO());
			eventResponse.setETCData("BATCH_EXE_RESULT", sBatchExeResult);
			commit();			
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * Common : batch<br>
	 * Office Type Check<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeTypeCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();
		
		String result = null;
		String ofc_cd = null;
		
		try{
			ofc_cd = account.getOfc_cd();
			result = command.searchOfficeTypeCheck(ofc_cd);
			
			eventResponse.setETCData("OFC_TP_CD", result);
			
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	

	/**
	 * Common : batch<br>
	 * searchRhqOffice<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRhqOffice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();
		
		String knt = null;
		String ofc_cd = null;
		
		try{
			ofc_cd = account.getOfc_cd();
			knt = command.searchRhqOffice(ofc_cd);
			eventResponse.setETCData("Account_Rhq_Offiice", knt);
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESD_LEA_0021 : save<br>
	 * ACCL_ADJ_FCTR_FNL_FLG을 저장한다.<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAcclAdjFctrFnlFlg(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0021Event event = (EsdLea0021Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();
		
		try{
			begin();			
			command.manageAcclAdjFctrFnlFlg(event.getAccrualAdjustmentVO(),account);
			commit();			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESD_LEA_0022<br>
	 * 년도별 Cost budget을 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYearlyCostBudget(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0022Event event = (EsdLea0022Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();

		try{
			List<ActCostMonBudgetVO> list = command.searchYearlyCostBudget(event.getBseYr(), event.getRhqCd());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESD_LEA_0022<br>
	 * 년도별 Cost budget을 저장합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageYearlyCostBudget(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0022Event event = (EsdLea0022Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();

		try{
			String creUsrId = account.getUsr_id();
			begin();			
			command.modifyYearlyCostBudget(event.getActCostMonBudgetVOs(),creUsrId);
			commit();			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * ESD_LEA_0022<br>
	 * 년도별 Cost budget을 생성할 대상 Cost Code를 생성합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createYearlyBudgetCostCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0022Event event = (EsdLea0022Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();
		try {
			String creUsrId = account.getUsr_id();
			begin();
			//log.debug("createYearlyCostBudget  start=========================createYearlyCostBudget");
			command.createYearlyBudgetCostCode(event.getActCostMonBudgetVOs(),creUsrId);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_LEA_0022<br>
	 * 년도별 Cost budget을 생성합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse executeYearlyCostBudget(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0022Event event = (EsdLea0022Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();
		 String sBatchExeResult = null;
		try {
			sBatchExeResult = command.executeYearlyCostBudget(event.getBseYr());
		//	log.debug("batch===="+sBatchExeResult);
			eventResponse.setETCData("BATCH_EXE_RESULT", sBatchExeResult);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESD_LEA_0017<br>
	 * G/L month 별 CSR List를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActualCostCsrListByGLMonth(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0017Event event = (EsdLea0017Event)e;
		ActualCostCSRManageBC command = new ActualCostCSRManageBCImpl();

		try{
			List<SearchCsrListByGLMonthVO> list = command.searchActualCostCsrListByGLMonth(event.getSearchCsrListByGLMonthVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESD_LEA_0022<br>
	 * 년도별 Cost budget을 생성할 대상 Cost Code를 생성합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createYearlyBudgetCostCodeAlpsa(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0022Event event = (EsdLea0022Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();
		try {
			String creUsrId = account.getUsr_id();
			begin();
			//log.debug("createYearlyCostBudget  start=========================createYearlyCostBudgetALPS");

			command.createYearlyBudgetCostCodeAlpsa(event.getActCostMonBudgetVOs(),creUsrId);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESD_LEA_0022<br>
	 * 년도별 Cost budget을 저장합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageYearlyCostBudgetAlpsa(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdLea0022Event event = (EsdLea0022Event)e;
		AccrualBatchExecuteResultBC command = new AccrualBatchExecuteResultBCImpl();

		try{
			String creUsrId = account.getUsr_id();
			begin();			
			command.modifyYearlyCostBudgetAlpsa(event.getActCostMonBudgetVOs(),creUsrId);
			commit();			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
}