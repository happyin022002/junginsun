/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTPerformanceAnalysisSC.java
*@FileTitle : Daily Batch Job Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 최성환
*				   황효근 (2009.05.17)
*@LastVersion : 1.0
* 2009.05.12 최성환
* 1.0 Creation
* 2011.05.12. 김태균 [] 소스원복요청으로 인하여 원복 - [CHM-201110406-01][DMT] Monthly invoiced & collection by office 의 생성결과물 Local 통화 통일 요청
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DeleteReasonListVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBC;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.UserRoleVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.batchhistoryreport.basic.BatchHistoryReportBC;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.batchhistoryreport.basic.BatchHistoryReportBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.batchhistoryreport.event.EesDmt7007Event;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.batchhistoryreport.integration.BatchHistoryReportDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.batchhistoryreport.vo.DmtBatHisVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.basic.ChargeCalculationReportBC;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.basic.ChargeCalculationReportBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.event.EesDmt3010Event;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.event.EesDmt3011Event;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.event.EesDmt6005Event;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.event.EesDmt6006Event;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.event.EesDmt7016Event;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryByOfficeDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryByOfficeVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.UsLfdEdiAudidtListVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.basic.ChargeCollectionReportBC;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.basic.ChargeCollectionReportBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.event.EesDmt6001Event;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.event.EesDmt6002Event;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.event.EesDmt6003Event;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.event.EesDmt6011Event;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.event.EesDmt6012Event;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.event.EesDmt6013Event;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.CollectionDetailReportByOfficeVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.CollectionSummaryReportByOfficeVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.MonthlyCollectionByOfficeVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.TmnlContainerExceptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.TmnlVvdLfdVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.UnissuedInvoiceDetailByAgingVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.YearlyCollectionByRHQVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.basic.DMTCalculationTypeMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.basic.DMTCalculationTypeMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.event.EesDmt7001Event;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.event.EesDmt7003Event;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.event.EesDmt7005Event;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.CalculationTypeParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtTrfTpVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.basic.DMTCollectionOfficeMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.basic.DMTCollectionOfficeMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.event.EesDmt7002Event;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.event.EesDmt7009Event;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.DmtYdExptCostVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.OfficeYardListVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.basic.WaiveReportBC;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.basic.WaiveReportBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.event.EesDmt6009Event;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.event.EesDmt6010Event;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.event.EesDmt6014Event;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo.AfterBookingFileLetterVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportSummaryVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * NIS2010-DMTPerformanceAnalysis Business Logic ServiceCommand - NIS2010-DMTPerformanceAnalysis 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Choi Sung Hwan
 * @see BatchHistoryReportDBDAO
 * @since J2EE 1.4
 */

public class DMTPerformanceAnalysisSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * DMTPerformanceAnalysis system 업무 시나리오 선행작업<br>
	 * ees_dmt_7007업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * DMTPerformanceAnalysis system 업무 시나리오 마감작업<br>
	 * ees_dmt_7007 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("DMTPerformanceAnalysisSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-DMTPerformanceAnalysis system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
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
		} else if (e.getEventName().equalsIgnoreCase("EesDmt3010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDeleteChargeListByOffice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchDeleteReason(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDeleteSpecificReason(e);
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
        } else if (e.getEventName().equalsIgnoreCase("EesDmt7009Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchYardExceptionCost(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkCostDup(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = modifyYardExceptionCost(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = confirmYardExceptionCost(e);
			}
        } else if (e.getEventName().equalsIgnoreCase("EesDmt6011Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
            	eventResponse = searchYearlyCollectionByRHQOffice(e);
            } else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {	// BackEndJob Start
				eventResponse = doBackEndJob(e);
            } else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {	// BackEndJob Status Check
				eventResponse = checkBackEndJob(e);
			}
        } else if (e.getEventName().equalsIgnoreCase("EesDmt7016Event")) {
	        if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchUsLfdEdiAudidtList(e);
	        }
        } else if (e.getEventName().equalsIgnoreCase("EesDmt6012Event")) {
	        if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchTmnlVvdLfd(e);
	        } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTmnlContainerException(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EesDmt6013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUnissuedInvoiceDetailByAging(e);
			}
        } else if (e.getEventName().equalsIgnoreCase("EesDmt6014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAfterBookingFileLetterList(e);
			}
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
	
	/**
	 * 조회 이벤트 처리<br>
	 * DMTCalculationTypeMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
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
	 * 조회 이벤트 처리<br>
	 * DMTCalculationTypeMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
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
	 * EES_DMT_7005 : Save<br>
	 * Tariff Type Setup 정보의 존재여부를 조회한 후, 존재시 해당 정보를 수정하고 비존재시 생성한다.
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
	 * Office별 Charge Delete 사유에 따른 CNTR 개수를 조회한다.<br>
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
	 * Delete Reason Type List를 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDeleteReason(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationReportBC command = new ChargeCalculationReportBCImpl();
		
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
	 * Delete Inquiry by Office의 상세내역을 조회한다.<br>
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
				
				//로그인 User의  해당 페이지(EES_DMT_3002) Access 권한 정보를 조회한다.
				CommonFinderBC command2 = new CommonFinderBCImpl();
				UserRoleVO roleVO = command2.hasRoleAuth(paramRoleVO);
	
				eventResponse.setETCData("ROLE_PERMIT",	roleVO.getIsAuthorized());
				eventResponse.setETCData("ROLE_AUTH",	roleVO.getUsrRoleCd());
			}
			
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_6001 : Retrieve<br>
	 * Collection Status Report by Office의 상세 내역을 조회한다.<br>
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
	 * 해당기간에 발생한 Charge를 기준으로 하여 조회시점까지 관련 Charge Detail 정보를 조회한다.<br>
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
				
				//로그인 User의  해당 페이지(EES_DMT_3002) Access 권한 정보를 조회한다.
				CommonFinderBC command2 = new CommonFinderBCImpl();
				UserRoleVO roleVO = command2.hasRoleAuth(paramRoleVO);
	
				eventResponse.setETCData("ROLE_PERMIT",	roleVO.getIsAuthorized());
				eventResponse.setETCData("ROLE_AUTH",	roleVO.getUsrRoleCd());
			}
			
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_6003 : Retrieve<br>
	 * 월별 Billable/Invoiced/Collection 된 금액 정보를 조회한다.<br>
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
	 * Customer별 발생 Charge정보의 Summary조회한다.<br>
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
	 * Customer별 발생 Charge의 Detail 정보를 조회한다.<br>
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
				
				//로그인 User의  해당 페이지(EES_DMT_3002) Access 권한 정보를 조회한다.
				CommonFinderBC command2 = new CommonFinderBCImpl();
				UserRoleVO roleVO = command2.hasRoleAuth(paramRoleVO);
	
				eventResponse.setETCData("ROLE_PERMIT",	roleVO.getIsAuthorized());
				eventResponse.setETCData("ROLE_AUTH",	roleVO.getUsrRoleCd());
			}
			
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	
    /**
    * EES_DMT_7002 : [SEARCH]<br>
    * [DEM/DET Office Inquiry by Yard]을 [SEARCH]합니다.<br>
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
    * [Waive Report by Office]을 [SEARCH]합니다.<br>
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
    * [Waive Report by Office Detail(s)]을 [SEARCH]합니다.<br>
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
            
            //로그인 User의  해당 페이지(EES_DMT_3002) Access 권한 정보를 조회한다.
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
 * EES_DMT_7009 : [SEARCH]<br>
 * [Exception Cost by Yard]을 [SEARCH]합니다.<br>
 * 
 * @param Event e
 * @return EventResponse
 * @exception EventException
 */
     private EventResponse searchYardExceptionCost (Event e) throws EventException {
     	GeneralEventResponse eventResponse = new GeneralEventResponse();
     	EesDmt7009Event event = (EesDmt7009Event)e;
         DMTCollectionOfficeMgtBC command = new DMTCollectionOfficeMgtBCImpl();
         
         try {
 	        List<DmtYdExptCostVO> list = command.searchYardExceptionCost(event.getDmtYdExptCostParmVO() );
 	        eventResponse.setRsVoList(list);
         } catch(EventException ex) {
 			throw ex;
 		} catch(Exception ex) {
 			throw new EventException(ex.getMessage(), ex);
 		}
         return eventResponse;
     }
     /**
      * EES_DMT_7009 : [SEARCH01]<br>
      * [Exception Cost by Yard]을 [Duplication check]합니다.<br>
      * 
      * @param Event e
      * @return EventResponse
      * @exception EventException
      */
          private EventResponse checkCostDup (Event e) throws EventException {
          	GeneralEventResponse eventResponse = new GeneralEventResponse();
          	EesDmt7009Event event = (EesDmt7009Event)e;
              DMTCollectionOfficeMgtBC command = new DMTCollectionOfficeMgtBCImpl();
              
              try {
            	  String ydCd = (String)event.getAttribute("yd_cd");
            	  String effDdt = (String)event.getAttribute("eff_dt");
            	  String expDt = (String)event.getAttribute("exp_dt");
            	  String ydExptCost = command.checkCostDup(ydCd, effDdt, expDt );
            	  Map<String,String> etcData = new HashMap<String,String>();
      	          etcData.put("chk_period",ydExptCost);
      	          eventResponse.setETCData(etcData);
              } catch(EventException ex) {
      			throw ex;
      		} catch(Exception ex) {
      			throw new EventException(ex.getMessage(), ex);
      		}
              return eventResponse;
          }     
     
     
     /**
      * EES_DMT_7009 : [COMMAND01]<br>
      * [Exception Cost by Yard] Save <br>
      * 
      * @param Event e
      * @return EventResponse
      * @exception EventException
      */
      private EventResponse modifyYardExceptionCost (Event e) throws EventException {
        	GeneralEventResponse eventResponse = new GeneralEventResponse();
         	EesDmt7009Event event = (EesDmt7009Event)e;
            DMTCollectionOfficeMgtBC command = new DMTCollectionOfficeMgtBCImpl();
            //eventResponse = null;         
          try {
        	   begin();
        	   log.debug("save======================================");
  	           command.modifyYardExceptionCost ( event.getDmtYdExptCostVOs() );
			   commit();
  		   }catch(EventException ex) {
  			   log.error(ex.getMessage(),ex);
  			   rollback();
  			throw ex;
  			
  		   }catch (Exception ex) {
  			   log.error("err " + ex.toString(), ex);
  			   rollback();
   			   throw new EventException(ex.getMessage(),ex);
   		   }

  		return eventResponse;
      }
      /**
       * EES_DMT_7009 : [COMMAND02]<br>
       * [Exception Cost by Yard] Confirm.<br>
       * 
       * @param Event e
       * @return EventResponse
       * @exception EventException
       */
       private EventResponse confirmYardExceptionCost(Event e) throws EventException {
          	GeneralEventResponse eventResponse = new GeneralEventResponse();
         	EesDmt7009Event event = (EesDmt7009Event)e;
            DMTCollectionOfficeMgtBC command = new DMTCollectionOfficeMgtBCImpl();
           // eventResponse = null;  
          try {
        	   begin();
        	   log.debug("confirm==============================================");
        	   log.debug("event.getDmtYdExptCostVOs()==="+event.getDmtYdExptCostVOs());
        	   String cfmCancel = (String)event.getAttribute("cfm_cancel");
  	           command.confirmYardExceptionCost( event.getDmtYdExptCostVOs(), cfmCancel );
			   commit();
  		   }catch(EventException ex) {
  			   log.error(ex.getMessage(),ex);
  			   rollback();
  			throw ex;
  			
  		   }catch (Exception ex) {
  			   log.error("err " + ex.toString(), ex);
  			   rollback();
   			   throw new EventException(ex.getMessage(),ex);
   		   }
  		 return eventResponse;
        }   
       
   	/**
	 * EES_DMT_6011 : btn_retrieve<br>
	 * Long Tx 결과 조회<br>
	 * 
   	 * @param Event e
   	 * @return EventResponse
   	 * @throws Exception 
   	 */
   	private EventResponse doBackEndJob(Event e) throws EventException {
   		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
   		ChargeCollectionReportBC		command				= new ChargeCollectionReportBCImpl();
	  		
   		try {
   	   		 YearlyCollectionByRHQVO parmVO = null;
 			 String backEndJobKey = null;
 			 
   	   		 parmVO = ((EesDmt6011Event)e).getYearlyCollectionByRHQVO();

			//BackEndJob 모듈을 호출한다.
			backEndJobKey = command.doBackEndJob(parmVO, account);
			eventResponse.setETCData("BackEndJobKey", backEndJobKey);
	
   		} catch(EventException ex) {
			throw ex;
   		}
   		return eventResponse;
   	}
   	
   	/**
	 * EES_DMT_6011 : btn_retrieve<br>
	 * Long Tx 결과 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse checkBackEndJob(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		ChargeCollectionReportBC		command				= new ChargeCollectionReportBCImpl();
		
		try {
			YearlyCollectionByRHQVO	parmVO = null;
			parmVO = ((EesDmt6011Event)e).getYearlyCollectionByRHQVO();

			//BackEndJob 모듈의 현재 작업상태와  오류 발생시 오류 메세지를 조회한다.
			String[] result = command.checkBackEndJob(parmVO.getBackendjobKey());
			eventResponse.setETCData("jb_sts_flg",		result[0]);
			eventResponse.setETCData("jb_usr_err_msg",	result[1]);
		
		} catch(EventException ex) {
			rollback();
			throw ex;
		}		
		
		return eventResponse;
	}
	
	
	
	/**
	 * EES_DMT_6011 : [SEARCH]<br>
	 * [YearlyCollectionByRHQOffice]을 [SEARCH]합니다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	     private EventResponse searchYearlyCollectionByRHQOffice (Event e) throws EventException {
	     	GeneralEventResponse eventResponse = new GeneralEventResponse();
	     	EesDmt6011Event event = (EesDmt6011Event)e;
	     	ChargeCollectionReportBC command = new ChargeCollectionReportBCImpl();
	         
	         try {
	 	        List<YearlyCollectionByRHQVO> list = command.searchYearlyCollectionByRHQOffice(event.getYearlyCollectionByRHQVO() );
	 	        eventResponse.setRsVoList(list);
	         } catch(EventException ex) {
	 			throw ex;
	 		} catch(Exception ex) {
	 			throw new EventException(ex.getMessage(), ex);
	 		}
	         return eventResponse;
	     }
	

	 	
	 	/**
	 	 * EES_DMT_7016 : [SEARCH]<br>
	 	 * [YearlyCollectionByRHQOffice]을 [SEARCH]합니다.<br>
	 	 * @param Event e
	 	 * @return EventResponse
	 	 * @exception EventException
	 	 */
	 	     private EventResponse searchUsLfdEdiAudidtList (Event e) throws EventException {
	 	     	GeneralEventResponse eventResponse = new GeneralEventResponse();
	 	     	EesDmt7016Event event = (EesDmt7016Event)e;
	 	     	ChargeCalculationReportBC command = new ChargeCalculationReportBCImpl();
	 	         
	 	         try {
	 	 	        List<UsLfdEdiAudidtListVO> list = command.searchUsLfdEdiAudidtList(event.getUsLfdEdiAudidtParmVO() );
	 	 	        eventResponse.setRsVoList(list);
	 	 	        if ( list.size() > 0 ){
	 	 	        	eventResponse.setETCData("gnd_total",		String.valueOf(list.get(0).getGndTotal()));
//	 					eventResponse.setETCData("rtv_total",		String.valueOf(list.size()));
	 	 	        } else {
	 	 	        	eventResponse.setETCData("gnd_total",		"0");
	 	 	        }
	 	         } catch(EventException ex) {
	 	 			throw ex;
	 	 		} catch(Exception ex) {
	 	 			throw new EventException(ex.getMessage(), ex);
	 	 		}
	 	         return eventResponse;
	 	     }
	
	
	
	/**
	 * EES_DMT_6012 : [SEARCH]<br>
	 * [Terminal LFD Report]을 [SEARCH]합니다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
     private EventResponse searchTmnlVvdLfd (Event e) throws EventException {
     	GeneralEventResponse eventResponse = new GeneralEventResponse();
     	EesDmt6012Event event = (EesDmt6012Event)e;
     	ChargeCollectionReportBC command = new ChargeCollectionReportBCImpl();
         
         try {
 	        List<TmnlVvdLfdVO> list = command.searchTmnlVvdLfd(event.getTmnlVvdLfdVO() );
 	        eventResponse.setRsVoList(list);
         } catch(EventException ex) {
 			throw ex;
 		} catch(Exception ex) {
 			throw new EventException(ex.getMessage(), ex);
 		}
         return eventResponse;
     }
	 		
     /**
 	 * EES_DMT_6012 : [SEARCH]<br>
 	 * [Terminal LFD Report]을 [SEARCH]합니다.<br>
 	 * @param Event e
 	 * @return EventResponse
 	 * @exception EventException
 	 */
      private EventResponse searchTmnlContainerException (Event e) throws EventException {
      	GeneralEventResponse eventResponse = new GeneralEventResponse();
      	EesDmt6012Event event = (EesDmt6012Event)e;
      	ChargeCollectionReportBC command = new ChargeCollectionReportBCImpl();
          
          try {
  	        List<TmnlContainerExceptionVO> list = command.searchTmnlContainerException(event.getTmnlVvdLfdVO());
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
  	 * Delete Reason Type List를 조회한다.<br>
  	 * 
  	 * @param Event e 
  	 * @return EventResponse
  	 * @exception EventException
  	 */
  	private EventResponse searchDeleteSpecificReason(Event e) throws EventException {
  		EesDmt3010Event event = (EesDmt3010Event)e;
  		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    ChargeCalculationReportBC command = new ChargeCalculationReportBCImpl();
  		
  		try{

  			List<DeleteReasonListVO> list = command.searchDeleteSpecificReasonList(event.getDeleteInquiryParmVO().getDelCd());
  			
  			if (list != null && list.size() > 0) {			
  				StringBuffer deltRsn = new StringBuffer();
  				
  				for (int i = 0 ; i < list.size() ; i++) {
  					DeleteReasonListVO vo = list.get(i);
  					deltRsn.append(vo.getIntgCdValCtnt()).append("=").append(vo.getIntgCdValDpDesc()).append("|");
  				}
  				
  				deltRsn.deleteCharAt(deltRsn.length()-1);
  				eventResponse.setETCData("DELT_SPEC_RSN", deltRsn.toString());
  			}
  			
  		}catch(EventException ex){
  			throw ex;
  		}catch(Exception ex){
  			throw new EventException(ex.getMessage(), ex);
  		}
  		return eventResponse;
  	} 
  	
  	/**
	 * EES_DMT_6013 : Open<br>
	 * 해당기간에 발생한 Charge를 기준으로 하여 조회시점까지 관련 Charge Detail 정보를 조회한다.(EES_DMT_6002 동일 로직)<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUnissuedInvoiceDetailByAging(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt6013Event event = (EesDmt6013Event)e;
		ChargeCollectionReportBC command = new ChargeCollectionReportBCImpl();
		
		try {
			List<UnissuedInvoiceDetailByAgingVO> list = command.searchUnissuedInvoiceDetailByAging(event.getUnissuedInvoiceByAgingParmVO());
			
			if(list != null) {
				HashMap<String, String> cntrInfo = new HashMap<String, String>();
				
				for(int i=0; i < list.size(); i++) {
					UnissuedInvoiceDetailByAgingVO vo = list.get(i);
					
					if(!cntrInfo.containsKey(vo.getCntrNo())) {
						cntrInfo.put(vo.getCntrNo(), "");
					}
				}
				eventResponse.setETCData("cntr_qty", String.valueOf(cntrInfo.size()));
				
				UserRoleVO paramRoleVO = new UserRoleVO();
				paramRoleVO.setUsrId(account.getUsr_id());
				paramRoleVO.setPgmNo("EES_DMT_3002");
				paramRoleVO.setUsrRoleCd("DMT01,DMT02,DMT03,DMT04");
				
				//로그인 User의  해당 페이지(EES_DMT_3002) Access 권한 정보를 조회한다.
				CommonFinderBC command2 = new CommonFinderBCImpl();
				UserRoleVO roleVO = command2.hasRoleAuth(paramRoleVO);
	
				eventResponse.setETCData("ROLE_PERMIT",	roleVO.getIsAuthorized());
				eventResponse.setETCData("ROLE_AUTH",	roleVO.getUsrRoleCd());
			}
			
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	

    /**
	 * EES_DMT_6012 : [SEARCH]<br>
	 * [Terminal LFD Report]을 [SEARCH]합니다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
     private EventResponse searchAfterBookingFileLetterList (Event e) throws EventException {
     	GeneralEventResponse eventResponse = new GeneralEventResponse();
     	EesDmt6014Event event = (EesDmt6014Event)e;
     	WaiveReportBC command = new WaiveReportBCImpl();
         
         try {
 	        List<AfterBookingFileLetterVO> list = command.searchAfterBookingFileLetterList(event.getAfterBookingFileLetterVO());
 	        eventResponse.setRsVoList(list);
         } catch(EventException ex) {
 			throw ex;
 		} catch(Exception ex) {
 			throw new EventException(ex.getMessage(), ex);
 		}
         return eventResponse;
     }
}