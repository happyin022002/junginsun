/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CNTROperatioNPerformanceMgtSC.java
 *@FileTitle : Turn Time by Port
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.basic.CIMCommonBC;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.basic.CIMCommonBCImpl;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.CommonComboSetVO;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.TypeSizeSequenceVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.basic.EQMatchBackNLoadFactorMgtBC;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.basic.EQMatchBackNLoadFactorMgtBCImpl;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1018Event;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1020Event;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1023Event;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1027Event;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1029Event;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1032Event;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1049Event;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1050Event;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1053Event;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.LoadFactorByTradeLaneVvdVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBMonthlyWeeklyPeriodVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBSearchOptionInGereralVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MatchBackByMonthlyWeeklyTrendSetVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.QuantityByTypeSizeVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchBatchJobStatusVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchMBByVesselVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.basic.MTYRepositionPerformanceAnalysisBC;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.basic.MTYRepositionPerformanceAnalysisBCImpl;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.event.EesCim1033Event;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.event.EesCim1034Event;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.event.EesCim1051Event;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYCNTRPERFInDetailVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYCNTRPERFSummaryVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYMonthlyWeeklyPeriodVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYMonthlyWeeklyTrendSetVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.REPOResultInGeneralVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.basic.TurnTimePerformanceMgtBC;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.basic.TurnTimePerformanceMgtBCImpl;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event.EesCim1001Event;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event.EesCim1007Event;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event.EesCim1011Event;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event.EesCim1014Event;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event.EesCim1016Event;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.integration.TurnTimePerformanceMgtDBDAO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TTMonthlyWeeklyPeriodVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnAroundTimeInGeneralVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByMonthlyWeeklyTrendSetVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByMonthlyWeeklyTrendVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByTypeSizeVO;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CNTROperatioNPerformanceMgt Business Logic ServiceCommand -
 * OPUS-CNTROperatioNPerformanceMgt handling business transaction
 * 
 * @author 
 * @see TurnTimePerformanceMgtDBDAO
 * @since J2EE 1.4
 */

public class CNTROperatioNPerformanceMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * preceding biz scenario process for CNTROperatioNPerformanceMgt system 
	 * EES_CIM_1001 related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CNTROperatioNPerformanceMgt system biz scenario closing<br>
	 * EES_CIM_1001 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("CNTROperatioNPerformanceMgtSC End");
	}

	/**
	 * OPUS-CNTROperatioNPerformanceMgt system <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EesCim1001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPortTurnTimeListByPortDetail(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTPSZSequenceList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkLocation(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchPortTurnTimeListByPortSummary(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchTPSZSequenceList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesCim1007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPortTurnTimeListByLaneVVDSummary(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPortTurnTimeListByLaneVVDDetail(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchPortTurnTimeVVDList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchPortTurnTimeLaneList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchPortTurnTimeCombo(e);
			}

		}
		else if (e.getEventName().equalsIgnoreCase("EesCim1016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLocationTurnTimeSummary(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchLocationTurnTimeDetail(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkLocation(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchCntrTypeSizeList(e);
			}

		}
		else if (e.getEventName().equalsIgnoreCase("EesCim1014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTurnAroundTimeByTradeLane(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTurnAroundTimeByTPSZTrade(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchTurnAroundTimeByLocation(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchLaneList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchAroundTurnTimeCombo(e);
			}

		}
		else if (e.getEventName().equalsIgnoreCase("EesCim1023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTMLMBByLogisticWiseSummary(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTMLMBByLogisticWiseDetail(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchLaneMBByLogisticWise(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchTPSZSequenceList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesCim1020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLaneMBByLogisticWise(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPortMBVVDList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchPortTurnTimeCombo(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesCim1033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchREPOResultByPort(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkVVD(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchREPOResultByPortCombo(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesCim1034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchREPOResultByLocation(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchREPOResultByPortCombo(e);
			}
		}		
		else if (e.getEventName().equalsIgnoreCase("EesCim1051Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchMTYCNTRPERFByMovementSMRY(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = searchMTYCNTRPERFByMovementDTL(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse = searchMTYCNTRPERFByMovementTrend(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = loadFileBackEndJobResultService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchCntrTypeSizeList(e);
			}
		}		
		else if (e.getEventName().equalsIgnoreCase("EesCim1049Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLoadFactorByTrade(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkLane(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchLoadFactorByTrade(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = loadFileBackEndJobResultService(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesCim1018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLocationMBByLogisticWiseInSummary(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLocationMBByLogisticWiseInDetail(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchLocationMBByLogisticWiseByTrend(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchTPSZSequenceList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesCim1032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMBByServiceMode(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchTPSZSequenceList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesCim1027Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLocationMBByBKGWiseInSummary(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLocationMBByBKGWiseInDetail(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchLocationMBByBKGWiseByTrend(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchTPSZSequenceList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesCim1029Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCargoFlowMap(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchTPSZSequenceList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesCim1053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPreviousWeeks(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBatchJobStatus(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesCim1050Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMBByVessel(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLaneList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkLane(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkVVD(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchMBByVesselLaneListByTrade(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchMBByVesselVvdListByTradeLane(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchMBByVessel(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = loadFileBackEndJobResultService(e);
			}

		}
		else if (e.getEventName().equalsIgnoreCase("EesCim1011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTurnTimeByMovement(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTurnTimeByMovementDetail(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchTPSZSequenceList(e);
			}
		}

		return eventResponse;
	}

	/**
	 * UI : BackEndJob<br>
	 * retrieving status value for BackEndJob result<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchComBackEndJobStatusService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();

		String status = "";
		String key = "";

		if (e.getEventName().equalsIgnoreCase("EesCim1049Event")) {
			EesCim1049Event event = (EesCim1049Event) e;
			key = (String) event.getAttribute("KEY");
		}
		else if (e.getEventName().equalsIgnoreCase("EesCim1050Event")) {
			EesCim1050Event event = (EesCim1050Event) e;
			key = (String) event.getAttribute("KEY");
		}
		else if (e.getEventName().equalsIgnoreCase("EesCim1051Event")) {
			EesCim1051Event event = (EesCim1051Event) e;
			key = (String) event.getAttribute("KEY");
		}
		status = command.searchComBackEndJobStatusBasic(key);
		eventResponse.setETCData("jb_sts_flg", status);

		return eventResponse;
	}

	/**
	 * UI : BackEndJob<br>
	 * downloading result file of BackEndJob <br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse loadFileBackEndJobResultService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String key = "";
		List list = null;

		try {
			if (e.getEventName().equalsIgnoreCase("EesCim1049Event")) {
				EesCim1049Event event = (EesCim1049Event) e;
				key = (String) event.getAttribute("KEY");
				list = (List<LoadFactorByTradeLaneVvdVO>) BackEndJobResult.loadFromFile(key);
				eventResponse.setRsVoList(list);
			}
			else if (e.getEventName().equalsIgnoreCase("EesCim1050Event")) {
				EesCim1050Event event = (EesCim1050Event) e;
				key = (String) event.getAttribute("KEY");
				list = (List<SearchMBByVesselVO>) BackEndJobResult.loadFromFile(key);
				eventResponse.setRsVoList(list);
			}
			else if (e.getEventName().equalsIgnoreCase("EesCim1051Event")) {
				EesCim1051Event event = (EesCim1051Event) e;
				key = (String) event.getAttribute("KEY");
				String gubun = (String) event.getAttribute("GUBUN");
				if ("S".equals(gubun)) { // SUMMARY TAB
					list = (List<MTYCNTRPERFSummaryVO>) BackEndJobResult.loadFromFile(key);
					eventResponse.setRsVoList(list);
				}
				else if ("D".equals(gubun)) { // DETAIL TAB
					list = (List<MTYCNTRPERFInDetailVO>) BackEndJobResult.loadFromFile(key);
					eventResponse.setRsVoList(list);
				}
				else { // TREND TAB
					List<MTYMonthlyWeeklyTrendSetVO> setVo = (List<MTYMonthlyWeeklyTrendSetVO>) BackEndJobResult
							.loadFromFile(key);

					List<MTYCNTRPERFSummaryVO> list1 = setVo.get(0).getMtycntrperfsummaryvo();
					List<MTYMonthlyWeeklyPeriodVO> list2 = setVo.get(0).getMtymonthlyweeklyperiodvo();

					StringBuilder sb = new StringBuilder();
					if (list2.size() > 0) {
						for (int i = 0; i < list2.size() - 1; i++) {
							sb.append(list2.get(i).getPeriod());
							sb.append("|");
						}
						sb.append(list2.get(list2.size() - 1).getPeriod());
					}

					Map<String, String> etcData = new HashMap<String, String>();
					etcData.put("head", sb.toString());

					eventResponse.setETCData(etcData);
					eventResponse.setRsVoList(list1);

				}
			}

		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_CIM_1011 : Retrieve <br>
	 * Retrieving TurnTimeByMovement <br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTurnTimeByMovement(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1011Event event = (EesCim1011Event) e;
		TurnTimePerformanceMgtBC command = new TurnTimePerformanceMgtBCImpl();
		List<TurnTimeByTypeSizeVO> list = command.searchTurnTimeByMovement(event.getTTSearchOptionInGereralVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * EES_CIM_1011 : Retrieve <br>
	 * Retrieving TurnTimeByMovement Detail Tab <br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTurnTimeByMovementDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1011Event event = (EesCim1011Event) e;
		TurnTimePerformanceMgtBC command = new TurnTimePerformanceMgtBCImpl();
		List<TurnTimeByTypeSizeVO> list = command.searchTurnTimeByMovementDetail(event.getTTSearchOptionInGereralVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * EES_CIM_1001 : Retrieve <br>
	 * Retrieving PortTurnTimeListByPort Detail <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortTurnTimeListByPortDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1001Event event = (EesCim1001Event) e;
		TurnTimePerformanceMgtBC command = new TurnTimePerformanceMgtBCImpl();
		List<TurnTimeByTypeSizeVO> list = command.searchPortTurnTimeListByPortDetail(event
				.getTTSearchOptionInGereralVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * EES_CIM_1001 : Retrieve <br>
	 * Retrieving PortTurnTimeListByPort Summary <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortTurnTimeListByPortSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1001Event event = (EesCim1001Event) e;
		TurnTimePerformanceMgtBC command = new TurnTimePerformanceMgtBCImpl();
		List<TurnTimeByTypeSizeVO> list = command.searchPortTurnTimeListByPortSummary(event
				.getTTSearchOptionInGereralVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * EES_CIM_1007 : Retrieve <br>
	 * Retrieving PortTurnTimeListByLaneVVD Summary <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortTurnTimeListByLaneVVDSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1007Event event = (EesCim1007Event) e;
		TurnTimePerformanceMgtBC command = new TurnTimePerformanceMgtBCImpl();
		List<TurnTimeByTypeSizeVO> list = command.searchPortTurnTimeListByLaneVVDSummary(event
				.getTTSearchOptionInGereralVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * EES_CIM_1007 : Retrieve <br>
	 * Retrieving PortTurnTimeListByLaneVVD Detail <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortTurnTimeListByLaneVVDDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1007Event event = (EesCim1007Event) e;
		TurnTimePerformanceMgtBC command = new TurnTimePerformanceMgtBCImpl();
		List<TurnTimeByTypeSizeVO> list = command.searchPortTurnTimeListByLaneVVDDetail(event
				.getTTSearchOptionInGereralVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * PortTurnTimeCombo : OPEN<br>
	 * Retrieving Port,Lane Code COMBO List <br>
	 * 
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortTurnTimeCombo(Event e) throws EventException {

		CIMCommonBC command = new CIMCommonBCImpl();

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			CommonComboSetVO commonComboSetVO = command.searchPortTurnTimeCombo();
			String[] arrPort = commonComboSetVO.getSPort();
			String[] arrLane = commonComboSetVO.getSLane();
			List<TypeSizeSequenceVO> list = commonComboSetVO.getTypeSizeSequenceVO();

			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			StringBuilder sb3 = new StringBuilder();

			if (arrPort.length > 0) {
				for (int i = 0; i < arrPort.length - 1; i++) {
					sb1.append(arrPort[i]);
					sb1.append("|");
				}
				sb1.append(arrPort[arrPort.length - 1]);
			}

			if (arrLane.length > 0) {
				for (int i = 0; i < arrLane.length - 1; i++) {
					sb2.append(arrLane[i]);
					sb2.append(",");
				}
				sb2.append(arrLane[arrLane.length - 1]);
			}

			if (list.size() > 0) {
				for (int i = 0; i < list.size() - 1; i++) {
					sb3.append(list.get(i).getCntrTpszCd());
					sb3.append(",");
				}
				sb3.append(list.get(list.size() - 1).getCntrTpszCd());
			}
			Map<String, String> etcData = new HashMap<String, String>();

			etcData.put("sPort", sb1.toString());
			etcData.put("sLane", sb2.toString());
			etcData.put("cntrTypeSize", sb3.toString());

			eventResponse.setETCData(etcData);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * TPSZSequence : OPEN<br>
	 * Retrieving container type code name information <br>
	 * 
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPSZSequenceList(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		CIMCommonBC command = new CIMCommonBCImpl();

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {

			List<TypeSizeSequenceVO> typesizesequencevo = command.searchTPSZSequenceList();

			StringBuilder sb = new StringBuilder();
			if (typesizesequencevo.size() > 0) {
				for (int i = 0; i < typesizesequencevo.size() - 1; i++) {
					sb.append(typesizesequencevo.get(i).getCntrTpszCd());
					sb.append(",");
				}
				sb.append(typesizesequencevo.get(typesizesequencevo.size() - 1).getCntrTpszCd());
			}

			Map<String, String> etcData = new HashMap<String, String>();

			etcData.put("cntrTypeSize", sb.toString());

			eventResponse.setETCData(etcData);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Location : FOCUS OUT<br>
	 * Location check validate<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// EesCim1001Event event = (EesCim1001Event)e;
		CIMCommonBC command = new CIMCommonBCImpl();

		String locLevel = (String) e.getAttribute("inquirylevel");
		String locCD = (String) e.getAttribute("location");
		String check = command.checkLocation(locLevel, locCD);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Map<String, String> etcData = new HashMap<String, String>();
		etcData.put("check", check);

		eventResponse.setETCData(etcData);
		return eventResponse;
	}

	/**
	 * VVD : FOCUS OUT<br>
	 * VVD validate check<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVVD(Event e) throws EventException {
		CIMCommonBC command = new CIMCommonBCImpl();

		String vvd = (String) e.getAttribute("vvd");
		String check = command.checkVVD(vvd);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Map<String, String> etcData = new HashMap<String, String>();
		etcData.put("check", check);

		eventResponse.setETCData(etcData);
		return eventResponse;
	}

	/**
	 * Lane : FOCUS OUT<br>
	 * Lane validate check<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLane(Event e) throws EventException {
		CIMCommonBC command = new CIMCommonBCImpl();

		String lane = (String) e.getAttribute("lane");
		String check = command.checkLane(lane);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Map<String, String> etcData = new HashMap<String, String>();
		etcData.put("check", check);

		eventResponse.setETCData(etcData);
		return eventResponse;
	}

	/**
	 * Retrieving Lane List <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortTurnTimeLaneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1007Event event = (EesCim1007Event) e;
		TurnTimePerformanceMgtBC command = new TurnTimePerformanceMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String period = (String) event.getAttribute("period");
		String from = (String) event.getAttribute("from");
		String to = (String) event.getAttribute("to");
		String pol = (String) event.getAttribute("pol");
		// String lane = (String)event.getAttribute("lane");

		String[] arrLane = command.searchPortTurnTimeLaneList(period, from, to, pol);
		StringBuilder sb = new StringBuilder();
		if (arrLane.length > 0) {
			for (int i = 0; i < arrLane.length - 1; i++) {
				sb.append(arrLane[i]);
				sb.append(",");
			}
			sb.append(arrLane[arrLane.length - 1]);
		}

		Map<String, String> etcData = new HashMap<String, String>();

		etcData.put("sLane", sb.toString());

		eventResponse.setETCData(etcData);

		return eventResponse;
	}

	/**
	 * Retrieving VVD List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortTurnTimeVVDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1007Event event = (EesCim1007Event) e;
		TurnTimePerformanceMgtBC command = new TurnTimePerformanceMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String period = (String) event.getAttribute("period");
		String from = (String) event.getAttribute("from");
		String to = (String) event.getAttribute("to");
		String pol = (String) event.getAttribute("pol");
		String lane = (String) event.getAttribute("lane");

		String[] arrVVD = command.searchPortTurnTimeVVDList(period, from, to, pol, lane);
		StringBuilder sb = new StringBuilder();
		if (arrVVD.length > 0) {
			for (int i = 0; i < arrVVD.length - 1; i++) {
				sb.append(arrVVD[i]);
				sb.append("|");
			}
			sb.append(arrVVD[arrVVD.length - 1]);
		}

		Map<String, String> etcData = new HashMap<String, String>();

		etcData.put("sVvd", sb.toString());

		eventResponse.setETCData(etcData);

		return eventResponse;
	}

	/**
	 * Retrieving MB VVD List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortMBVVDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1020Event event = (EesCim1020Event) e;
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String period = (String) event.getAttribute("period");
		String from = (String) event.getAttribute("from");
		String to = (String) event.getAttribute("to");
		String pol = (String) event.getAttribute("pol");
		String lane = (String) event.getAttribute("lane");

		String[] arrVVD = command.searchPortMBVVDList(period, from, to, pol, lane);
		StringBuilder sb = new StringBuilder();
		if (arrVVD.length > 0) {
			for (int i = 0; i < arrVVD.length - 1; i++) {
				sb.append(arrVVD[i]);
				sb.append("|");
			}
			sb.append(arrVVD[arrVVD.length - 1]);
		}

		Map<String, String> etcData = new HashMap<String, String>();

		etcData.put("sVvd", sb.toString());

		eventResponse.setETCData(etcData);

		return eventResponse;
	}

	/**
	 * EES_CIM_1016 : Retrieve <br>
	 * Retrieving LocationTurnTime Summary Tab <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationTurnTimeSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1016Event event = (EesCim1016Event) e;
		TurnTimePerformanceMgtBC command = new TurnTimePerformanceMgtBCImpl();
		TurnTimeByMonthlyWeeklyTrendSetVO list = command.searchLocationTurnTimeSummary(event
				.getTTSearchOptionInGereralVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		List<TurnTimeByMonthlyWeeklyTrendVO> list1 = list.getTurntimebymonthlyweeklytrendvo();
		List<TTMonthlyWeeklyPeriodVO> list2 = list.getTtmonthlyweeklyperiodvo();

		StringBuilder sb = new StringBuilder();
		if (list2.size() > 0) {
			for (int i = 0; i < list2.size() - 1; i++) {
				sb.append(list2.get(i).getPeriod());
				sb.append("|");
			}
			sb.append(list2.get(list2.size() - 1).getPeriod());
		}

		Map<String, String> etcData = new HashMap<String, String>();
		etcData.put("head", sb.toString());

		eventResponse.setETCData(etcData);
		eventResponse.setRsVoList(list1);
		return eventResponse;
	}

	/**
	 * EES_CIM_1016 : Retrieve <br>
	 * Retrieving LocationTurnTime Detail Tab <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationTurnTimeDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1016Event event = (EesCim1016Event) e;
		TurnTimePerformanceMgtBC command = new TurnTimePerformanceMgtBCImpl();
		TurnTimeByMonthlyWeeklyTrendSetVO list = command.searchLocationTurnTimeDetail(event
				.getTTSearchOptionInGereralVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		List<TurnTimeByMonthlyWeeklyTrendVO> list1 = list.getTurntimebymonthlyweeklytrendvo();
		List<TTMonthlyWeeklyPeriodVO> list2 = list.getTtmonthlyweeklyperiodvo();

		StringBuilder sb = new StringBuilder();
		if (list2.size() > 0) {
			for (int i = 0; i < list2.size() - 1; i++) {
				sb.append(list2.get(i).getPeriod());
				sb.append("|");
			}
			sb.append(list2.get(list2.size() - 1).getPeriod());
		}

		Map<String, String> etcData = new HashMap<String, String>();
		etcData.put("head", sb.toString());

		eventResponse.setETCData(etcData);
		eventResponse.setRsVoList(list1);
		return eventResponse;
	}

	/**
	 * Retrieving CntrTypeSize List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrTypeSizeList(Event e) throws EventException {
		CIMCommonBC command = new CIMCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String[] arrTpsz = null;
		arrTpsz = command.searchCntrTypeSizeList();

		StringBuilder sb1 = new StringBuilder();

		if (arrTpsz.length > 0) {
			for (int i = 0; i < arrTpsz.length - 1; i++) {
				sb1.append(arrTpsz[i]);
				sb1.append("|");
			}
			sb1.append(arrTpsz[arrTpsz.length - 1]);
		}

		List<TypeSizeSequenceVO> typesizesequencevo = command.searchTPSZSequenceList();

		StringBuilder sb = new StringBuilder();
		if (typesizesequencevo.size() > 0) {
			for (int i = 0; i < typesizesequencevo.size() - 1; i++) {
				sb.append(typesizesequencevo.get(i).getCntrTpszCd());
				sb.append(",");
			}
			sb.append(typesizesequencevo.get(typesizesequencevo.size() - 1).getCntrTpszCd());
		}

		Map<String, String> etcData = new HashMap<String, String>();
		etcData.put("cntr_tpsz_cd", sb1.toString());
		etcData.put("cntrTypeSize", sb.toString());

		eventResponse.setETCData(etcData);

		return eventResponse;
	}

	/**
	 * EES_CIM_1014 : Retrieve <br>
	 * Retrieving TurnAroundTimeByTradeLane Tab <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTurnAroundTimeByTradeLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1014Event event = (EesCim1014Event) e;
		TurnTimePerformanceMgtBC command = new TurnTimePerformanceMgtBCImpl();
		List<TurnAroundTimeInGeneralVO> list = command.searchTurnAroundTimeByTradeLane(event
				.getTurnAroundTimeSearchOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * EES_CIM_1014 : Retrieve <br>
	 * Retrieving TurnAroundTimeByTPSZTrade Tab <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTurnAroundTimeByTPSZTrade(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1014Event event = (EesCim1014Event) e;
		TurnTimePerformanceMgtBC command = new TurnTimePerformanceMgtBCImpl();
		List<TurnAroundTimeInGeneralVO> list = command.searchTurnAroundTimeByTPSZTrade(event
				.getTurnAroundTimeSearchOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * EES_CIM_1014 : Retrieve <br>
	 * Retrieving TurnAroundTimeByLocation Tab <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTurnAroundTimeByLocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1014Event event = (EesCim1014Event) e;
		TurnTimePerformanceMgtBC command = new TurnTimePerformanceMgtBCImpl();
		List<TurnAroundTimeInGeneralVO> list = command.searchTurnAroundTimeByLocation(event
				.getTurnAroundTimeSearchOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * Retrieving AroundTurnTimeCombo List(Trade,Lane,Tpsz Code) <br>
	 * 
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAroundTurnTimeCombo(Event e) throws EventException {

		CIMCommonBC command = new CIMCommonBCImpl();

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			CommonComboSetVO commonComboSetVO = command.searchAroundTurnTimeCombo();
			String[] arrTrade = commonComboSetVO.getSTrade();
			// String[] arrLane = (String[])map.get("sLane");
			String[] arrTpsz = commonComboSetVO.getSTpsz();

			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb3 = new StringBuilder();

			if (arrTrade.length > 0) {
				for (int i = 0; i < arrTrade.length - 1; i++) {
					sb1.append(arrTrade[i]);
					sb1.append(",");
				}
				sb1.append(arrTrade[arrTrade.length - 1]);
			}
			/*
			 * if(arrLane.length > 0) { for(int i = 0 ; i < arrLane.length-1 ;
			 * i++){ sb2.append(arrLane[i]); sb2.append("|"); }
			 * sb2.append(arrLane[arrLane.length-1]); }
			 */
			if (arrTpsz.length > 0) {
				for (int i = 0; i < arrTpsz.length - 1; i++) {
					sb3.append(arrTpsz[i]);
					sb3.append("|");
				}
				sb3.append(arrTpsz[arrTpsz.length - 1]);
			}

			Map<String, String> etcData = new HashMap<String, String>();

			etcData.put("sTrade", sb1.toString());
			// etcData.put("sLane",sb2.toString());
			etcData.put("sTpsz", sb3.toString());

			eventResponse.setETCData(etcData);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Retrieving Lane List combo <br>
	 * 
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneList(Event e) throws EventException {

		CIMCommonBC command = new CIMCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {

			String[] arrLane = command.searchLaneList((String) e.getAttribute("trade"));

			StringBuilder sb1 = new StringBuilder();

			if (arrLane.length > 0) {
				for (int i = 0; i < arrLane.length - 1; i++) {
					sb1.append(arrLane[i]);
					sb1.append(",");
				}
				sb1.append(arrLane[arrLane.length - 1]);
			}

			Map<String, String> etcData = new HashMap<String, String>();
			etcData.put("sLane", sb1.toString());

			eventResponse.setETCData(etcData);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CIM_1023 : Retrieve <br>
	 * Retrieving TMLMBByLogisticWise Summary Tab <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTMLMBByLogisticWiseSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1023Event event = (EesCim1023Event) e;
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		CIMCommonBC command1 = new CIMCommonBCImpl();
		List<QuantityByTypeSizeVO> list = command
				.searchTMLMBByLogisticWiseSummary(event.getMBSearchOptionInGereralVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<TypeSizeSequenceVO> typeSizeSequenceVO = command1.searchTPSZSequenceList();
			// String cntr_tpsz_cd = "";

			StringBuilder sb = new StringBuilder();
			if (typeSizeSequenceVO.size() > 0) {
				for (int i = 0; i < typeSizeSequenceVO.size() - 1; i++) {
					sb.append(typeSizeSequenceVO.get(i).getCntrTpszCd());
					sb.append("|");
				}
				sb.append(typeSizeSequenceVO.get(typeSizeSequenceVO.size() - 1).getCntrTpszCd());
			}
			//			
			// if(typeSizeSequenceVO.size() > 0) {
			// for(int i=0; i<typeSizeSequenceVO.size(); i++) {
			// cntr_tpsz_cd += typeSizeSequenceVO.get(i).getCntrTpszCd()+"|";
			// }
			// }
			//			
			Map<String, String> etcData = new HashMap<String, String>();

			etcData.put("cntr_tpsz_cd", sb.toString());

			eventResponse.setETCData(etcData);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CIM_1023 : Retrieve <br>
	 * Retrieving TMLMBByLogisticWise Detail Tab <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTMLMBByLogisticWiseDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1023Event event = (EesCim1023Event) e;
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		CIMCommonBC command1 = new CIMCommonBCImpl();
		List<QuantityByTypeSizeVO> list = command.searchTMLMBByLogisticWiseDetail(event.getMBSearchOptionInGereralVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<TypeSizeSequenceVO> typeSizeSequenceVO = command1.searchTPSZSequenceList();

			StringBuilder sb = new StringBuilder();
			if (typeSizeSequenceVO.size() > 0) {
				for (int i = 0; i < typeSizeSequenceVO.size() - 1; i++) {
					sb.append(typeSizeSequenceVO.get(i).getCntrTpszCd());
					sb.append("|");
				}
				sb.append(typeSizeSequenceVO.get(typeSizeSequenceVO.size() - 1).getCntrTpszCd());
			}

			Map<String, String> etcData = new HashMap<String, String>();

			etcData.put("cntr_tpsz_cd", sb.toString());

			eventResponse.setETCData(etcData);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CIM_1020 : Retrieve <br>
	 * Retrieving LaneMBByLogisticWise <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneMBByLogisticWise(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1020Event event = (EesCim1020Event) e;
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		// CIMCommonBC command1 = new CIMCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<QuantityByTypeSizeVO> list = command.searchLaneMBByLogisticWise(event.getMBSearchOptionInGereralVO());
			/*
			 * List<TypeSizeSequenceVO> typeSizeSequenceVO =
			 * command1.searchTPSZSequenceList();
			 * 
			 * StringBuilder sb = new StringBuilder();
			 * if(typeSizeSequenceVO.size() > 0) { for(int i = 0 ; i <
			 * typeSizeSequenceVO.size()-1 ; i++){
			 * sb.append(typeSizeSequenceVO.get(i).getCntrTpszCd());
			 * sb.append("|"); }
			 * sb.append(typeSizeSequenceVO.get(typeSizeSequenceVO
			 * .size()-1).getCntrTpszCd()); } // // String cntr_tpsz_cd = ""; //
			 * // if(typeSizeSequenceVO.size() > 0) { // for(int i=0;
			 * i<typeSizeSequenceVO.size(); i++) { // cntr_tpsz_cd +=
			 * typeSizeSequenceVO.get(i).getCntrTpszCd()+"|"; // } // } //
			 * Map<String,String> etcData = new HashMap<String,String>();
			 * 
			 * etcData.put("cntr_tpsz_cd",sb.toString());
			 * 
			 * eventResponse.setETCData(etcData);
			 */
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Retrieving port,Lane,rcc Code,head List combo <br>
	 * 
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchREPOResultByPortCombo(Event e) throws EventException {

		CIMCommonBC command = new CIMCommonBCImpl();

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			CommonComboSetVO commonComboSetVO = command.searchREPOResultByPortCombo();
			String[] arrPort = commonComboSetVO.getSPort();
			String[] arrLane = commonComboSetVO.getSLane();
			String[] arrRcc = commonComboSetVO.getSRcc();
			List<TypeSizeSequenceVO> list = commonComboSetVO.getTypeSizeSequenceVO();

			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			StringBuilder sb3 = new StringBuilder();
			StringBuilder sb4 = new StringBuilder();

			if (arrPort.length > 0) {
				for (int i = 0; i < arrPort.length - 1; i++) {
					sb1.append(arrPort[i]);
					sb1.append("|");
				}
				sb1.append(arrPort[arrPort.length - 1]);
			}

			if (arrLane.length > 0) {
				for (int i = 0; i < arrLane.length - 1; i++) {
					sb2.append(arrLane[i]);
					sb2.append(",");
				}
				sb2.append(arrLane[arrLane.length - 1]);
			}

			if (arrRcc.length > 0) {
				for (int i = 0; i < arrRcc.length - 1; i++) {
					sb3.append(arrRcc[i]);
					sb3.append("|");
				}
				sb3.append(arrRcc[arrRcc.length - 1]);
			}

			if (list.size() > 0) {
				for (int i = 0; i < list.size() - 1; i++) {
					sb4.append(list.get(i).getCntrTpszCd());
					sb4.append(",");
				}
				sb4.append(list.get(list.size() - 1).getCntrTpszCd());
			}

			Map<String, String> etcData = new HashMap<String, String>();

			etcData.put("sPort", sb1.toString());
			etcData.put("sLane", sb2.toString());
			etcData.put("sRcc", sb3.toString());
			etcData.put("cntrTypeSize", sb4.toString());

			eventResponse.setETCData(etcData);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CIM_1033 : Retrieve <br>
	 * Retrieving REPOResultByPort <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchREPOResultByPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1033Event event = (EesCim1033Event) e;
		MTYRepositionPerformanceAnalysisBC command = new MTYRepositionPerformanceAnalysisBCImpl();
		List<REPOResultInGeneralVO> list = command.searchREPOResultByPort(event.getREPOResultSearchOptionByPortVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * EES_CIM_1034 : Retrieve <br>
	 * Retrieving REPOResultByLocation <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchREPOResultByLocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1034Event event = (EesCim1034Event) e;
		MTYRepositionPerformanceAnalysisBC command = new MTYRepositionPerformanceAnalysisBCImpl();
		List<REPOResultInGeneralVO> list = command.searchREPOResultByLocation(event
				.getREPOResultSearchOptionByLocation());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * EES_CIM_1051 : Retrieve <br>
	 * Retrieving MTYCNTRPERFByMovementSMRY Tab <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTYCNTRPERFByMovementSMRY(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1051Event event = (EesCim1051Event) e;
		MTYRepositionPerformanceAnalysisBC command = new MTYRepositionPerformanceAnalysisBCImpl();
		String status = command.searchMTYCNTRPERFByMovementSMRY(event.getMTYCNTRPERFSearchOptionVO(), account);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("BackEndJobKey", status);
		return eventResponse;
	}

	/**
	 * EES_CIM_1051 : Retrieve <br>
	 * Retrieving MTYCNTRPERFByMovementDTL Tab <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTYCNTRPERFByMovementDTL(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1051Event event = (EesCim1051Event) e;
		MTYRepositionPerformanceAnalysisBC command = new MTYRepositionPerformanceAnalysisBCImpl();
		String status = command.searchMTYCNTRPERFByMovementDTL(event.getMTYCNTRPERFSearchOptionVO(), account);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("BackEndJobKey", status);
		return eventResponse;
	}

	/**
	 * EES_CIM_1051 : Retrieve <br>
	 * Retrieving MTYCNTRPERFByMovementTrend Tab <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTYCNTRPERFByMovementTrend(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1051Event event = (EesCim1051Event) e;
		MTYRepositionPerformanceAnalysisBC command = new MTYRepositionPerformanceAnalysisBCImpl();
		String status = command.searchMTYCNTRPERFByMovementTrend(event.getMTYCNTRPERFSearchOptionVO(), account);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("BackEndJobKey", status);
		return eventResponse;

		/*
		 * EesCim1051Event event = (EesCim1051Event)e;
		 * MTYRepositionPerformanceAnalysisBC command = new
		 * MTYRepositionPerformanceAnalysisBCImpl(); MTYMonthlyWeeklyTrendSetVO
		 * list =command.searchMTYCNTRPERFByMovementTrend(event.
		 * getMTYCNTRPERFSearchOptionVO()); GeneralEventResponse eventResponse =
		 * new GeneralEventResponse(); List<MTYCNTRPERFSummaryVO> list1 =
		 * list.getMtycntrperfsummaryvo(); List<MTYMonthlyWeeklyPeriodVO> list2
		 * = list.getMtymonthlyweeklyperiodvo();
		 * 
		 * StringBuilder sb = new StringBuilder(); if(list2.size() > 0) {
		 * for(int i = 0 ; i < list2.size()-1 ; i++){
		 * sb.append(list2.get(i).getPeriod()); sb.append("|"); }
		 * sb.append(list2.get(list2.size()-1).getPeriod()); }
		 * 
		 * 
		 * Map<String,String> etcData = new HashMap<String,String>();
		 * etcData.put("head", sb.toString());
		 * 
		 * eventResponse.setETCData(etcData); eventResponse.setRsVoList(list1);
		 * 
		 * return eventResponse;
		 */
	}

	/**
	 * EES_CIM_1018 : Retrieve <br>
	 * Retrieving LocationMBByLogisticWise Summary Tab <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationMBByLogisticWiseInSummary(Event e) throws EventException {

		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		// CIMCommonBC command1 = new CIMCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<QuantityByTypeSizeVO> list = command
					.searchLocationMBByLogisticWiseInSummary((MBSearchOptionInGereralVO) e
							.getAttribute("MBSearchOptionInGereralVO"));
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CIM_1018 : Retrieve <br>
	 * Retrieving LocationMBByLogisticWise Detail Tab <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationMBByLogisticWiseInDetail(Event e) throws EventException {

		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			List<QuantityByTypeSizeVO> list = command
					.searchLocationMBByLogisticWiseInDetail((MBSearchOptionInGereralVO) e
							.getAttribute("MBSearchOptionInGereralVO"));

			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CIM_1049 : Retrieve <br>
	 * Retrieving LoadFactorByTrade <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLoadFactorByTrade(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1049Event event = (EesCim1049Event) e;
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String status = command.searchLoadFactorByTrade(event.getSearchOptionByTradeLaneVvdVO(), account);
		eventResponse.setETCData("BackEndJobKey", status);

		// eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * EES_CIM_1018 : Retrieve <br>
	 * Retrieving LocationMBByLogisticWise Trend Tab <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationMBByLogisticWiseByTrend(Event e) throws EventException {
		log.debug("####### CNTROperatioNPerformanceMgtSC.searchLocationMBByLogisticWiseByTrend start");
		// PDTO(Data Transfer Object including Parameters)
		EesCim1018Event event = (EesCim1018Event) e;

		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();

		MatchBackByMonthlyWeeklyTrendSetVO list = command.searchLocationMBByLogisticWiseByTrend(event
				.getMBSearchOptionInGereralVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<QuantityByTypeSizeVO> list1 = list.getQuantitybytypesizevo();
		List<MBMonthlyWeeklyPeriodVO> list2 = list.getMbmonthlyweeklyperiodvo();
		log.debug("####### CNTROperatioNPerformanceMgtSC.searchTPSZSequenceList");

		StringBuilder sb = new StringBuilder();
		if (list2.size() > 0) {
			for (int i = 0; i < list2.size() - 1; i++) {
				sb.append(list2.get(i).getPeriod());
				sb.append("|");
			}
			sb.append(list2.get(list2.size() - 1).getPeriod());
		}

		Map<String, String> etcData = new HashMap<String, String>();
		etcData.put("head", sb.toString());

		eventResponse.setETCData(etcData);
		eventResponse.setRsVoList(list1);
		log.debug("@@@@@@@ CNTROperatioNPerformanceMgtSC.searchLocationMBByLogisticWiseInSummary end");
		return eventResponse;
	}

	/**
	 * EES_CIM_1032 : Retrieve <br>
	 * Retrieving MBByServiceMode List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMBByServiceMode(Event e) throws EventException {
		EesCim1032Event event = (EesCim1032Event) e;



		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<QuantityByTypeSizeVO> list = command.searchMBByServiceMode(event.getMBSearchOptionInGereralVO());
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CIM_1027 : Retrieve <br>
	 * Retrieving Location M/B by BKG-Wise Summary Tab <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationMBByBKGWiseInSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1027Event event = (EesCim1027Event) e;



		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<QuantityByTypeSizeVO> list = command.searchLocationMBByBKGWiseInSummary(event
					.getMBSearchOptionInGereralVO());

			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CIM_1027 : Retrieve <br>
	 * Retrieving Location M/B by BKG-Wise Detail Tab <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationMBByBKGWiseInDetail(Event e) throws EventException {
		log.debug("####### CNTROperatioNPerformanceMgtSC.searchLocationMBByBKGWiseInDetail 1027 Start");
		// PDTO(Data Transfer Object including Parameters)
		EesCim1027Event event = (EesCim1027Event) e;

		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		// CIMCommonBC command1 = new CIMCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<QuantityByTypeSizeVO> list = command.searchLocationMBByBKGWiseInDetail(event
					.getMBSearchOptionInGereralVO());

			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CIM_1027 : Retrieve <br>
	 * Retrieving Location M/B by BKG-Wise Trend Tab <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationMBByBKGWiseByTrend(Event e) throws EventException {
		log.debug("####### CNTROperatioNPerformanceMgtSC.searchLocationMBByBKGWiseByTrend 1027 Start");
		// PDTO(Data Transfer Object including Parameters)
		EesCim1027Event event = (EesCim1027Event) e;

		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		// CIMCommonBC command1 = new CIMCommonBCImpl();
		MatchBackByMonthlyWeeklyTrendSetVO list = command.searchLocationMBByBKGWiseByTrend(event
				.getMBSearchOptionInGereralVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<QuantityByTypeSizeVO> list1 = list.getQuantitybytypesizevo();
		List<MBMonthlyWeeklyPeriodVO> list2 = list.getMbmonthlyweeklyperiodvo();
		log.debug("####### CNTROperatioNPerformanceMgtSC.searchTPSZSequenceList");

		StringBuilder sb = new StringBuilder();
		if (list2.size() > 0) {
			for (int i = 0; i < list2.size() - 1; i++) {
				sb.append(list2.get(i).getPeriod());
				sb.append("|");
			}
			sb.append(list2.get(list2.size() - 1).getPeriod());

			Map<String, String> etcData = new HashMap<String, String>();
			etcData.put("head", sb.toString());

			eventResponse.setETCData(etcData);

		}

		eventResponse.setRsVoList(list1);
		log.debug("@@@@@@@ CNTROperatioNPerformanceMgtSC.searchLocationMBByBKGWiseByTrend 1027 End");
		return eventResponse;
	}

	/**
	 * EES_CIM_1029 : Retrieve <br>
	 * Retrieving  CargoFlowMap <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCargoFlowMap(Event e) throws EventException {
		log.debug("####### CNTROperatioNPerformanceMgtSC.searchCargoFlowMap 1029 Start");
		// PDTO(Data Transfer Object including Parameters)
		EesCim1029Event event = (EesCim1029Event) e;

		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<QuantityByTypeSizeVO> list = command.searchCargoFlowMap(event.getSearchOptionByFromToVO());
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("@@@@@@@ CNTROperatioNPerformanceMgtSC.searchCargoFlowMap 1029 End");
		return eventResponse;
	}

	/**
	 * EES_CIM_1053 : OPEN <br>
	 * Retrieving PreviousWeeks <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreviousWeeks(Event e) throws EventException {
		log.debug("####### CNTROperatioNPerformanceMgtSC.searchPreviousWeeks 1053 Start");
		// PDTO(Data Transfer Object including Parameters)
		EesCim1053Event event = (EesCim1053Event) e;
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		
		List<SearchBatchJobStatusVO> list = command.searchPreviousWeeks(event.getSearchOptionByFromToVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Map<String, String> etcData = new HashMap<String, String>();
		log.debug("####### wf    : [" + list.get(0).getWf() + "]");
		log.debug("####### wt    : [" + list.get(0).getWt() + "]");
		etcData.put("wf", list.get(0).getWf());
		etcData.put("wt", list.get(0).getWt());
		eventResponse.setETCData(etcData);
		log.debug("@@@@@@@ CNTROperatioNPerformanceMgtSC.searchPreviousWeeks 1053 End");
		return eventResponse;
	}

	/**
	 * EES_CIM_1053 : Retrieve <br>
	 * Retrieving BatchJobStatus <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBatchJobStatus(Event e) throws EventException {
		log.debug("####### CNTROperatioNPerformanceMgtSC.searchBatchJobStatus 1053 Start");
		// PDTO(Data Transfer Object including Parameters)
		EesCim1053Event event = (EesCim1053Event) e;
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		
		List<SearchBatchJobStatusVO> list = command.searchBatchJobStatus(event.getSearchOptionByFromToVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		log.debug("@@@@@@@ CNTROperatioNPerformanceMgtSC.searchBatchJobStatus 1053 End");
		return eventResponse;
	}

	/**
	 * EES_CIM_1050 : Retrieve <br>
	 * Retrieving MBByVessel <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMBByVessel(Event e) throws EventException {
		log.debug("####### CNTROperatioNPerformanceMgtSC.searchMBByVessel 1050 Start");
		EesCim1050Event event = (EesCim1050Event) e;
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		
		String status = command.searchMBByVessel(event.getSearchOptionByTradeLaneVvdVO(), account);

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("BackEndJobKey", status);
		// eventResponse.setRsVoList(list);
		log.debug("@@@@@@@ CNTROperatioNPerformanceMgtSC.searchMBByVessel 1050 End");
		return eventResponse;
	}

	/**
	 * EES_CIM_1050 : [SEARCH]<br>
	 * Retrieving [MatchBakc By Vessel Lane List] <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMBByVesselLaneListByTrade(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1050Event event = (EesCim1050Event) e;
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		String[] arrLANE = command.searchMBByVesselLaneListByTrade(event.getSearchOptionByTradeLaneVvdVO());
		StringBuilder sb = new StringBuilder();
		if (arrLANE.length > 0) {
			for (int i = 0; i < arrLANE.length - 1; i++) {
				sb.append(arrLANE[i]);
				sb.append(",");
			}
			sb.append(arrLANE[arrLANE.length - 1]);
		}
		Map<String, String> etcData = new HashMap<String, String>();
		etcData.put("sLane", sb.toString());
		eventResponse.setETCData(etcData);
		return eventResponse;
	}

	/**
	 * EES_CIM_1050 : [SEARCH]<br>
	 * retrieving [MatchBakc By Vessel VVD List] By Trade,Lane
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMBByVesselVvdListByTradeLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1050Event event = (EesCim1050Event) e;
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		String[] arrVVD = command.searchMBByVesselVvdListByTradeLane(event.getSearchOptionByTradeLaneVvdVO());
		StringBuilder sb = new StringBuilder();
		if (arrVVD.length > 0) {
			for (int i = 0; i < arrVVD.length - 1; i++) {
				sb.append(arrVVD[i]);
				sb.append(",");
			}
			sb.append(arrVVD[arrVVD.length - 1]);
		}
		Map<String, String> etcData = new HashMap<String, String>();
		etcData.put("sVvd", sb.toString());
		eventResponse.setETCData(etcData);
		return eventResponse;
	}
	
}