/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LogisticsExpenseAccrualSC.java
*@FileTitle : Rev.VVD Inquiry (Pop-up)
*Open Issues :
*Change history : 
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual;

import java.util.List;

import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.basic.AccrualBatchExecuteResultBC;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.basic.AccrualBatchExecuteResultBCImpl;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0002Event;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0004Event;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0005Event;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0006Event;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0007Event;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0008Event;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0010Event;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0014Event;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0015Event;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0901Event;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0902Event;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration.AccrualBatchExecuteResultDBDAO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualAccountCodeVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchExecuteResultHistoryListVO;
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
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.basic.AccrualBatchManageBC;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.basic.AccrualBatchManageBCImpl;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.event.EsdLea0001Event;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.vo.SearchAccrualBatchPreConditionVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.basic.AccrualEmailSettingBC;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.basic.AccrualEmailSettingBCImpl;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.event.EsdLea0009Event;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SearchAccrualEmailSettingVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SearchParameterAccrualEmailSettingVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.basic.ActualCostCSRManageBC;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.basic.ActualCostCSRManageBCImpl;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.event.EsdLea0011Event;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.event.EsdLea0012Event;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.event.EsdLea0013Event;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchActualCostCSRListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchActualCostCSRMonitoringListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchRVVDChangeActualCostCSRListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
 
/**
 * ALPS-LogisticsExpenseAccrual Business Logic ServiceCommand - Handling the business transaction about ALPS-LogisticsExpenseAccrual
 * 
 * @author
 * @see AccrualBatchExecuteResultDBDAO
 * @since J2EE 1.6
 */

public class LogisticsExpenseAccrualSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Preceding process for the business scenario of LogisticsExpenseAccrual system<br>
	 * Related objects creation.<br>
	 */
	public void doStart() {
		log.debug("LogisticsExpenseAccrualSC starts");
		try {
			// Checking log-in
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Finish the business scenario of LogisticsExpenseAccrual system<br>
	 * Clearing the related objects.<br>
	 */
	public void doEnd() {
		log.debug("LogisticsExpenseAccrualSC ends");
	}

	/**
	 *  
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		

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
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdLea0015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccrualBatchResultInvoiceInquiry(e);
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
				
					
			//Loading data to ESD_LEA_0002's sheet2. (This is not the hidden sheet, This page consists of 3 sheets.)
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAccrualConditionItemFlags(e);
				
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		//ESD_LEA_0002."Save" Button
				eventResponse = modifyAccrualBatchResultManualInput(e);
			}
		}
	
		return eventResponse;
	}
	
	/**
	 * ESD_LEA_0010 : [Event]<br>
	 * Inquiring the list of the cost code./<br>
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
	
	
	/**
	 * ESD_LEA_0010 : [Event]<br>
	 * Inquiring the list of the cost type code to make the combo box./<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
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
	
	/**
	 * ESD_LEA_0010 : [Event]<br>
	 * Inquiring the list of the sub cost type code to make the combo box./<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
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
	 * Inquiring the code to make the combo box.<br>
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
			
			rowSet = com.clt.apps.opus.esd.lea.common.CodeComboUtil.getCodeComboList20(sCostKind, sMainCostTypeCode);
			eventResponse.setRs(rowSet);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}		
	
	
	/**
	 * Inquiring the list of the accrual account code.<br>
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
	 * Inquiring the list of the accrual revenue VVD code.<br>
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
	 * Inquiring the list of the accrual batch result booking.<br>
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
	 * Inquiring the list of the accrual batch result container TPSZ code.<br>
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
	 * Inquiring the list of the accrual batch execute result history.<br>
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
	 * Inquiring the list of the actual cost CSR.<br>
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
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * Inquiring the list of the actual cost CSR monitoring.<br>
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
	 * Inquiring the list of the accrual batch result revenue month.<br>
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
	 * Inquiring the list of the accrual batch result execute month.<br>
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
	 * Inquiring the accrual email setting.<br>
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
	 * Inquiring the accrual email setting<br>
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
	 * Sending the test accrual email setting.<br>
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
			command.sendTestAccrualEmailSetting(event.getSearchParameterAccrualEmailSettingVO());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * Modifying the accrual email setting
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
	 * Inquiring the list of the accrual batch result office.<br>
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
	 * Inquiring the accrual batch result invoice.<br>
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
	 * Inquiring the accrual batch pre-condition.<br>
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
	 * Modifying the confirm of the accrual batch pre-condition.
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
	 * Executing the accrual batch.
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
	 * Inquiring the list of the RVVD change actual cost CSR
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

	/**
	 * Inquiring the list of the accrual batch result account.<br>
	 * 
	 * @param e Event
	 * @return response EsdLea0002EventResponse
	 * @exception EventException
	 */
	//ESD_LEA_0002.SEARCH
	private EventResponse searchAccrualBatchResultAccountList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdLea0002Event 		event 			= (EsdLea0002Event)e;
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
	 * Inquiring the list of the accrual batch result manual input.<br>
	 * 
	 * @param e Event
	 * @return response EsdLea0002EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccrualBatchResultManualInputList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdLea0002Event 		event 			= (EsdLea0002Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			AccrualBatchExecuteResultBCImpl command = new AccrualBatchExecuteResultBCImpl();
			eventResponse = (GeneralEventResponse)command.searchAccrualBatchResultManualInputList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * Inquiring the flags of the accural condition item.<br>
	 * 
	 * @param e Event
	 * @return response EsdLea0002EventResponse
	 * @exception EventException
	 */
	//ESD_LEA_0002.SEARCH02
	private EventResponse searchAccrualConditionItemFlags(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdLea0002Event 		event 			= (EsdLea0002Event)e;
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
	 * Modifying the confirm of the accural batch result account<br>
	 * 
	 * @param e Event
	 * @return response EsdLea0002EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyAccrualBatchResultAccountConfirm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdLea0002Event 		event 			= (EsdLea0002Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			begin();
			AccrualBatchExecuteResultBCImpl command = new AccrualBatchExecuteResultBCImpl();
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
	 * Modifying the manual input of the accrual batch result.
	 * 
	 * @param e Event
	 * @return response EsdLea0002EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyAccrualBatchResultManualInput(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdLea0002Event 		event 			= (EsdLea0002Event)e;
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
	}

	
	
}