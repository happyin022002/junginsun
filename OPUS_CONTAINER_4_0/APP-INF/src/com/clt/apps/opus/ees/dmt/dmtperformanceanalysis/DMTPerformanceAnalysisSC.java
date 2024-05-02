/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTPerformanceAnalysisSC.java
*@FileTitle : Daily Batch Job Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis;

import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DeleteReasonListVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBC;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBCImpl;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.UserRoleVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.batchhistoryreport.basic.BatchHistoryReportBC;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.batchhistoryreport.basic.BatchHistoryReportBCImpl;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.batchhistoryreport.event.EesDmt7007Event;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.batchhistoryreport.vo.DmtBatHisVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.basic.ChargeCalculationReportBC;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.basic.ChargeCalculationReportBCImpl;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.event.EesDmt3010Event;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.event.EesDmt3011Event;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.event.EesDmt6005Event;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.event.EesDmt6006Event;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryByOfficeDetailVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryByOfficeVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerDetailVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.basic.ChargeCollectionReportBC;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.basic.ChargeCollectionReportBCImpl;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.event.EesDmt6001Event;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.event.EesDmt6002Event;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.event.EesDmt6003Event;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.CollectionDetailReportByOfficeVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.CollectionSummaryReportByOfficeVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.MonthlyCollectionByOfficeVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.basic.DMTCalculationTypeMgtBC;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.basic.DMTCalculationTypeMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.event.EesDmt7001Event;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.event.EesDmt7003Event;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.event.EesDmt7005Event;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.event.EesDmt7010Event;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.event.EesDmt7011Event;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.event.EesDmt7012Event;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.event.EesDmt7013Event;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.event.EesDmt7014Event;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.CalculationTypeParmVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtCmbSetVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtSkpLocVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtTrfTpVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.WeekendVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.basic.DMTCollectionOfficeMgtBC;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.basic.DMTCollectionOfficeMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.event.EesDmt7002Event;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.OfficeYardListVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.waivereport.basic.WaiveReportBC;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.waivereport.basic.WaiveReportBCImpl;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.waivereport.event.EesDmt6009Event;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.waivereport.event.EesDmt6010Event;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportDetailVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportSummaryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * DMTPerformanceAnalysis Business Logic ServiceCommand - DMTPerformanceAnalysis handling business transaction.
 * 
 * @author
 * @see DMTCollectionOfficeMgtDBDAO class reference
 * @since J2EE 1.6
 */

public class DMTPerformanceAnalysisSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * DMTPerformanceAnalysis system preceding process for biz scenario<br>
	 * ees_dmt_7007 related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * DMTPerformanceAnalysis system biz scenario closing<br>
	 * ees_dmt_7007 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("DMTPerformanceAnalysisSC 종료");
	}

	/**
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EesDmt7007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBatchHistory(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt7001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTariffTypeList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt7003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCalculationTypeList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt7005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyTariffTypeSetup(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt7010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCalculationTypeEntryList(e);
			} if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkDuplicateCalculationTypeEntry(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageCalculationTypeEntry(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt3010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDeleteChargeListByOffice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchDeleteReason(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt3011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDeleteChargeDetailListByOffice(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt6001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCollectionSummaryReportByOffice(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt6002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCollectionDetailReportByOffice(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt6003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMonthlyCollectionByOffice(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt6005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSummaryReportByCustomerList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt6006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSummaryReportByCustomerDetailList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt7002Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCollectionOfficeList(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EesDmt6009Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchWaiveReportByOfficeList(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EesDmt6010Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchWaiveReportByOfficeDetailList(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EesDmt7011Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchCombinationSet(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
        		eventResponse = manageCombinationSet(e);
        	}
        } else if (e.getEventName().equalsIgnoreCase("EesDmt7012Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchSkipLocation(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
        		eventResponse = manageSkipLocation(e);
        	}
        } else if (e.getEventName().equalsIgnoreCase("EesDmt7013Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchTariffTypeAllList(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
        		eventResponse = manageTariffType(e);
        	}
        } else if (e.getEventName().equalsIgnoreCase("EesDmt7014Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchWeekendList(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
        		eventResponse = manageWeekend(e);
        	}
        }
		
		return eventResponse;
	}
	
	/**
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffTypeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt7001Event event = (EesDmt7001Event)e;
		DMTCalculationTypeMgtBC command = new DMTCalculationTypeMgtBCImpl();
		
		try {
			List<DmtTrfTpVO> list = command.searchTariffTypeList(event.getDmtTrfTpVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCalculationTypeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt7003Event event = (EesDmt7003Event)e;
		DMTCalculationTypeMgtBC command = new DMTCalculationTypeMgtBCImpl();
		
		try {
			List<CalculationTypeParmVO> list = command.searchCalculationTypeList(event.getCalculationTypeParmVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_7010 : Retrieve<br>
	 * Retrieving Calculation Type Entry List.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCalculationTypeEntryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt7010Event event = (EesDmt7010Event)e;
		DMTCalculationTypeMgtBC command = new DMTCalculationTypeMgtBCImpl();
		
		try {
			List<CalculationTypeParmVO> list = command.searchCalculationTypeList(event.getCalculationTypeParmVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_7010 : Save<br>
	 * Modifying Calculation Type Entry<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCalculationTypeEntry(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt7010Event event = (EesDmt7010Event)e;
		DMTCalculationTypeMgtBC command = new DMTCalculationTypeMgtBCImpl();
		try{
			begin();
			command.manageCalculationTypeEntry(event.getCalculationTypeParmVOS(),account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	 /**
	 * EES_DMT_7010<br>
	 * Checking The Duplicate Calculation Type Entry.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDuplicateCalculationTypeEntry(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt7010Event event = (EesDmt7010Event)e;
		DMTCalculationTypeMgtBC command = new DMTCalculationTypeMgtBCImpl();
		CalculationTypeParmVO 		calculationTypeParmVO 	= event.getCalculationTypeParmVO();
		
		try{
			CalculationTypeParmVO 		calculationTypeVO 			= command.checkDuplicateCalculationTypeEntry(calculationTypeParmVO);
			
			if (calculationTypeVO != null) {
				eventResponse.setETCData("RESULT", "Y");
			}
			else {
				eventResponse.setETCData("RESULT", "N");
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_7005 : Save<br>
	 * After retrieving that Tariff Type Setup is or not, when it is existed, it is updated or is created.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyTariffTypeSetup(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt7005Event event = (EesDmt7005Event)e;
		DMTCalculationTypeMgtBC command = new DMTCalculationTypeMgtBCImpl();
		try{
			begin();
			command.modifyTariffTypeSetup(event.getDmtOfcUsrTrfOptVO(),account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3010 : Retrieve<br>
	 * Retrieving count of CNTR by Office according to Charge Delete reason.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDeleteChargeListByOffice(Event e) throws EventException {
		EesDmt3010Event event = (EesDmt3010Event)e;
		ChargeCalculationReportBC command = new ChargeCalculationReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<DeleteInquiryByOfficeVO> list = command.searchDeletedChargeListByOffice(event.getDeleteInquiryParmVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3010 : Delete Charge Report by Office<br>
	 * Retrieving Delete Reason Type List.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDeleteReason(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		
		try{
			List<DeleteReasonListVO> list = command.searchDeleteReasonList();
			
			if (list != null && list.size() > 0) {			
				StringBuffer deltRsn = new StringBuffer();
				
				for (int i = 0 ; i < list.size() ; i++) {
					DeleteReasonListVO vo = list.get(i);
					deltRsn.append(vo.getIntgCdValCtnt()).append("=").append(vo.getIntgCdValDpDesc()).append("|");
				}
				
				deltRsn.deleteCharAt(deltRsn.length()-1);
				eventResponse.setETCData("DELT_RSN", deltRsn.toString());
			}
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3011 : Detail<br>
	 * Retrieving Delete Inquiry by Office details.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDeleteChargeDetailListByOffice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3011Event event = (EesDmt3011Event)e;
		ChargeCalculationReportBC command = new ChargeCalculationReportBCImpl();
		
		try {
			List<DeleteInquiryByOfficeDetailVO> list = command.searchDeletedChargeDetailListByOffice(event.getDeleteInquiryParmVO());
				
			if(list != null) {
				HashMap<String, String> cntrInfo = new HashMap<String, String>();
				
				for(int i=0; i < list.size(); i++) {
					DeleteInquiryByOfficeDetailVO vo = list.get(i);
					
					if(!cntrInfo.containsKey(vo.getCntrNo())) {
						cntrInfo.put(vo.getCntrNo(), "");
					}
				}
				eventResponse.setETCData("cntr_qty", String.valueOf(cntrInfo.size()));
				
				UserRoleVO paramRoleVO = new UserRoleVO();
				paramRoleVO.setUsrId(account.getUsr_id());
				paramRoleVO.setPgmNo("EES_DMT_3002");
				paramRoleVO.setUsrRoleCd("DMT01,DMT02,DMT03,DMT04");
				
				CommonFinderBC command2 = new CommonFinderBCImpl();
				UserRoleVO roleVO = command2.hasRoleAuth(paramRoleVO);
	
				eventResponse.setETCData("ROLE_PERMIT",	roleVO.getIsAuthorized());
				eventResponse.setETCData("ROLE_AUTH",	roleVO.getUsrRoleCd());
			}
			
			if(list != null) eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_6001 : Retrieve<br>
	 * Retrieving Collection Status Report by Office details.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCollectionSummaryReportByOffice(Event e) throws EventException {
		EesDmt6001Event event = (EesDmt6001Event)e;
		ChargeCollectionReportBC command = new ChargeCollectionReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<CollectionSummaryReportByOfficeVO> list = command.searchCollectionSummaryReportByOffice(event.getCollectionReportParmVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_6002 : Open<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCollectionDetailReportByOffice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt6002Event event = (EesDmt6002Event)e;
		ChargeCollectionReportBC command = new ChargeCollectionReportBCImpl();
		
		try {
			List<CollectionDetailReportByOfficeVO> list = command.searchCollectionDetailReportByOffice(event.getCollectionReportParmVO());
			
			if(list != null) {
				HashMap<String, String> cntrInfo = new HashMap<String, String>();
				
				for(int i=0; i < list.size(); i++) {
					CollectionDetailReportByOfficeVO vo = list.get(i);
					
					if(!cntrInfo.containsKey(vo.getCntrNo())) {
						cntrInfo.put(vo.getCntrNo(), "");
					}
				}
				eventResponse.setETCData("cntr_qty", String.valueOf(cntrInfo.size()));
				
				UserRoleVO paramRoleVO = new UserRoleVO();
				paramRoleVO.setUsrId(account.getUsr_id());
				paramRoleVO.setPgmNo("EES_DMT_3002");
				paramRoleVO.setUsrRoleCd("DMT01,DMT02,DMT03,DMT04");
				
				CommonFinderBC command2 = new CommonFinderBCImpl();
				UserRoleVO roleVO = command2.hasRoleAuth(paramRoleVO);
	
				eventResponse.setETCData("ROLE_PERMIT",	roleVO.getIsAuthorized());
				eventResponse.setETCData("ROLE_AUTH",	roleVO.getUsrRoleCd());
			}
			
			if(list != null) eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_6003 : Retrieve<br>
	 * Retrieving monthly Billable/Invoiced/Collection sum Info.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyCollectionByOffice(Event e) throws EventException {
		EesDmt6003Event event = (EesDmt6003Event)e;
		ChargeCollectionReportBC command = new ChargeCollectionReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<MonthlyCollectionByOfficeVO> list = command.searchMonthlyCollectionByOffice(event.getCollectionReportParmVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_6005 : Retrieve<br>
	 * Retrieving Summary of Charge occurred by Customer.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSummaryReportByCustomerList(Event e) throws EventException {
		EesDmt6005Event event = (EesDmt6005Event)e;
		ChargeCalculationReportBC command = new ChargeCalculationReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<SummaryReportByCustomerVO> list = command.searchSummaryReportByCustomer(event.getSummaryReportByCustomerParmVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_6006 : Open<br>
	 * Retrieving Detail of Charge occurred by Customer.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSummaryReportByCustomerDetailList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt6006Event event = (EesDmt6006Event)e;
		ChargeCalculationReportBC command = new ChargeCalculationReportBCImpl();
		
		try {
			List<SummaryReportByCustomerDetailVO> list = command.searchSummaryReportDetailByCustomer(event.getSummaryReportByCustomerParmVO());
			
			if(list != null) {
				HashMap<String, String> cntrInfo = new HashMap<String, String>();
			
				for(int i=0; i < list.size(); i++) {
					SummaryReportByCustomerDetailVO vo = list.get(i);
					
					if(!cntrInfo.containsKey(vo.getCntrNo())) {
						cntrInfo.put(vo.getCntrNo(), "");
					}
				}
				eventResponse.setETCData("cntr_qty", String.valueOf(cntrInfo.size()));
				
				UserRoleVO paramRoleVO = new UserRoleVO();
				paramRoleVO.setUsrId(account.getUsr_id());
				paramRoleVO.setPgmNo("EES_DMT_3002");
				paramRoleVO.setUsrRoleCd("DMT01,DMT02,DMT03,DMT04");
				
				CommonFinderBC command2 = new CommonFinderBCImpl();
				UserRoleVO roleVO = command2.hasRoleAuth(paramRoleVO);
	
				eventResponse.setETCData("ROLE_PERMIT",	roleVO.getIsAuthorized());
				eventResponse.setETCData("ROLE_AUTH",	roleVO.getUsrRoleCd());
			}
			
			if(list != null) eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	
    /**
    * EES_DMT_7002 : [SEARCH]<br>
    * Retrieving DEM/DET Office Inquiry by Yard.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchCollectionOfficeList (Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EesDmt7002Event event = (EesDmt7002Event)e;
        DMTCollectionOfficeMgtBC command = new DMTCollectionOfficeMgtBCImpl();
        
        try {
	        List<OfficeYardListVO> list = command.searchCollectionOfficeList ( event.getCollectionOfficeFinderVO() );
	        eventResponse.setRsVoList(list);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
        return eventResponse;
    }
    
    
    
    /**
    * EES_DMT_6009 : [SEARCH]<br>
    * Retrieving Waive Report by Office.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchWaiveReportByOfficeList (Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EesDmt6009Event event = (EesDmt6009Event)e;
    	WaiveReportBC command = new WaiveReportBCImpl();
    	
    	try {
	        List<WaiveReportSummaryVO> list = command.searchWaiveReportByOfficeList ( event.getWaiveReportParmVO () );
	        eventResponse.setRsVoList(list);
    	} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
    * EES_DMT_6010 : [SEARCH]<br>
    * Retrieving Waive Report by Office Detail(s).<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchWaiveReportByOfficeDetailList (Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EesDmt6010Event event = (EesDmt6010Event)e;
        WaiveReportBC command = new WaiveReportBCImpl();
        
        try {
	        List<WaiveReportDetailVO> list = command.searchWaiveReportByOfficeDetailList ( event.getWaiveReportParmVO () );
	        
            UserRoleVO paramRoleVO = new UserRoleVO();
            paramRoleVO.setUsrId(account.getUsr_id());
            paramRoleVO.setPgmNo("EES_DMT_3003");
            paramRoleVO.setUsrRoleCd("DMT01,DMT02,DMT03,DMT04");
            
            CommonFinderBC command2 = new CommonFinderBCImpl();
            UserRoleVO roleVO = command2.hasRoleAuth(paramRoleVO);

            eventResponse.setETCData("ROLE_PERMIT", roleVO.getIsAuthorized());
            eventResponse.setETCData("ROLE_AUTH",   roleVO.getUsrRoleCd());
	            
	        eventResponse.setRsVoList(list);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
        
		return eventResponse;
    }    
    
    
    /**
     * EES_DMT_7011 : [SEARCH]<br>
     * Retrieving Combination Set Information.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCombinationSet(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	DMTCalculationTypeMgtBC command = new DMTCalculationTypeMgtBCImpl();
    	
    	try {
    		List<DmtCmbSetVO> list = command.searchCombinationSet();
    		eventResponse.setRsVoList(list);
    	} catch(EventException ex) {
    		throw ex;
    	} catch(Exception ex) {
    		throw new EventException(ex.getMessage(), ex);
    	}
    	return eventResponse;
    }
    
    /**
     * EES_DMT_7011 : [MANAGE]<br>
     * Modifying Combination Set Information.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageCombinationSet(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		DMTCalculationTypeMgtBC	command 		= new DMTCalculationTypeMgtBCImpl();
		EesDmt7011Event 		event 			= (EesDmt7011Event)e;

		try{
			begin();
			command.manageCombinationSet(event.getDmtCmbSetVOs(),account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("DMT00003").getMessage(), ex);
		}
		return eventResponse;
    }    
    
    /**
     * EES_DMT_7012 : [SEARCH]<br>
     * Retrieving Skip Location.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSkipLocation(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	DMTCalculationTypeMgtBC command = new DMTCalculationTypeMgtBCImpl();
    	
    	try {
    		List<DmtSkpLocVO> list = command.searchSkipLocation();
    		eventResponse.setRsVoList(list);
    	} catch(EventException ex) {
    		throw ex;
    	} catch(Exception ex) {
    		throw new EventException(ex.getMessage(), ex);
    	}
    	return eventResponse;
    }
    
    /**
     * EES_DMT_7012 : [MANAGE]<br>
     * Modifying Skip Location<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageSkipLocation(Event e) throws EventException {
    	GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
    	DMTCalculationTypeMgtBC	command 		= new DMTCalculationTypeMgtBCImpl();
    	EesDmt7012Event 		event 			= (EesDmt7012Event)e;
    	
    	try{
    		begin();
    		command.manageSkipLocation(event.getDmtSkpLocVOs(),account);
    		commit();
    	}catch(EventException ex){
    		rollback();
    		throw ex;
    	}catch(Exception ex){
    		rollback();
    		throw new EventException(ex.getMessage(), ex);
    	}
    	return eventResponse;
    }
    
    /**
     * EES_DMT_7013 : [SEARCH]<br>
     * Retrieving Tariff Type.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchTariffTypeAllList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	DMTCalculationTypeMgtBC command 	= new DMTCalculationTypeMgtBCImpl();
    	EesDmt7013Event 		event 		= (EesDmt7013Event)e;
    	try {
    		List<DmtTrfTpVO> list = command.searchTariffTypeList(event.getDmtTrfTpVO());
    		eventResponse.setRsVoList(list);
    	} catch(EventException ex) {
    		throw ex;
    	} catch(Exception ex) {
    		throw new EventException(ex.getMessage(), ex);
    	}
    	return eventResponse;
    }
    
    /**
     * EES_DMT_7013 : [MANAGE]<br>
     * Modifying Tariff Type<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageTariffType(Event e) throws EventException {
    	GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
    	DMTCalculationTypeMgtBC	command 		= new DMTCalculationTypeMgtBCImpl();
    	EesDmt7013Event 		event 			= (EesDmt7013Event)e;
    	
    	try{
    		begin();
    		command.manageTariffType(event.getDmtTrfTpVOs(),account);
    		commit();
    	}catch(EventException ex){
    		rollback();
    		throw ex;
    	}catch(Exception ex){
    		rollback();
    		throw new EventException(ex.getMessage(), ex);
    	}
    	return eventResponse;
    }
    
    /**
     * EES_DMT_7014 : [SEARCH]<br>
     * Retrieving Weekend.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchWeekendList (Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EesDmt7014Event event = (EesDmt7014Event)e;
    	DMTCalculationTypeMgtBC command = new DMTCalculationTypeMgtBCImpl();
    	
    	try {
    		List<WeekendVO> list = command.searchWeekendList ( event.getWeekendVO());
    		eventResponse.setRsVoList(list);
    	} catch(EventException ex) {
    		throw ex;
    	} catch(Exception ex) {
    		throw new EventException(ex.getMessage(), ex);
    	}
    	
    	return eventResponse;
    }    
    
    
    /**
	 * EES_DMT_7014 : Modify<br>
	 * Modifying Weekend <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageWeekend(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		EesDmt7014Event event = (EesDmt7014Event)e;
    	DMTCalculationTypeMgtBC command = new DMTCalculationTypeMgtBCImpl();

		try{
			begin();
			command.manageWeekend(event.getweekendVOS(),account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}    
	
	/**
     * [BatchHistoryReport]을 [SEARCH]합니다.<br>
     * EES_DMT_7007 : [SEARCH]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBatchHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt7007Event event = (EesDmt7007Event)e;
		BatchHistoryReportBC command = new BatchHistoryReportBCImpl();
		
		try {
			List<DmtBatHisVO> list = command.searchBatchHistory(event.getBatHistParmVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
}