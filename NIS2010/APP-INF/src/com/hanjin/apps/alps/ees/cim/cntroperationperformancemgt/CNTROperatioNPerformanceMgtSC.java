/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CNTROperatioNPerformanceMgtSC.java
 *@FileTitle : Turn Time by Port
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.24
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.04.24 박광석
 * 1.0 Creation
 * ------------------------------------------------------------
 * History
 * 2011.01.20 [CHM-201108210-01] 불필요한 log.debug()로직 제거
 *                     searchLocationMBByLogisticWiseInSummary
 *                     searchLocationMBByLogisticWiseInDetail
 *                     searchLocationMBByLogisticWiseByTrend
 * 2011.10.26 신자영 [CHM-201113916-01] [CIM] Load factor by cy의 sub-trade 검색 기능 추가
 * 2012.03.26 신자영 [CHM-201216788-01] M/B 기능 보완 요청
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.basic.CIMCommonBC;
import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.basic.CIMCommonBCImpl;
import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.vo.CommonComboSetVO;
import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.vo.SearchDayListVO;
import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.vo.TypeSizeSequenceVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.basic.EQMatchBackNLoadFactorMgtBC;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.basic.EQMatchBackNLoadFactorMgtBCImpl;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1018Event;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1020Event;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1023Event;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1027Event;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1029Event;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1030Event;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1032Event;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1049Event;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1050Event;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1053Event;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1061Event;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1062Event;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.LoadFactorByTradeLaneVvdVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBDResultCOABKGVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBMonthlyWeeklyPeriodVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBSearchOptionInGereralVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBTResultCOABKGVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MatchBackByMonthlyWeeklyTrendSetVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.QuantityByTypeSizeVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.ResultByLocationVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchBatchJobStatusVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchCargoFlowMapDetailVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchMBByVesselVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByOTRVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.basic.MTYRepositionPerformanceAnalysisBC;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.basic.MTYRepositionPerformanceAnalysisBCImpl;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.event.EesCim1033Event;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.event.EesCim1034Event;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.event.EesCim1051Event;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYCNTRPERFInDailyTrendVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYCNTRPERFInDetailVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYCNTRPERFSummaryVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYMonthlyWeeklyPeriodVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYMonthlyWeeklyTrendSetVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.REPOResultInGeneralVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.basic.TurnTimePerformanceMgtBC;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.basic.TurnTimePerformanceMgtBCImpl;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event.EesCim1001Event;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event.EesCim1007Event;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event.EesCim1011Event;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event.EesCim1014Event;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event.EesCim1016Event;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event.EesCim1952Event;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.integration.TurnTimePerformanceMgtDBDAO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TTMonthlyWeeklyPeriodVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnAroundTimeInGeneralVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByMonthlyWeeklyTrendSetVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByMonthlyWeeklyTrendVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByMvmtCntrListVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByTypeSizeVO;
import com.hanjin.apps.alps.ees.lse.lsecommon.leaseterm.basic.LeaseTermBC;
import com.hanjin.apps.alps.ees.lse.lsecommon.leaseterm.basic.LeaseTermBCImpl;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MstLseTermVO;

/**
 * ALPS-CNTROperatioNPerformanceMgt Business Logic ServiceCommand -
 * ALPS-CNTROperatioNPerformanceMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Prak Kwang Seok
 * @see TurnTimePerformanceMgtDBDAO
 * @since J2EE 1.4
 */

public class CNTROperatioNPerformanceMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
 
	/**
	 * CNTROperatioNPerformanceMgt system 업무 시나리오 선행작업<br>
	 * EES_CIM_1001업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * CNTROperatioNPerformanceMgt system 업무 시나리오 마감작업<br>
	 * EES_CIM_1001 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CNTROperatioNPerformanceMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-CNTROperatioNPerformanceMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
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
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchYardList(e);
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
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchTmnlMBByLogiticWiseByTrend(e);
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
		else if (e.getEventName().equalsIgnoreCase("EesCim1036Event")) {
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
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND06)) {
				eventResponse = searchMTYCNTRPERFByMovementDailyTrend(e);
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
		else if (e.getEventName().equalsIgnoreCase("EesCim1025Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLocationMBByLogisticWiseInSummary(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLocationMBByLogisticWiseInDetail(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchTPSZSequenceList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesCim1049Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLoadFactorByTrade(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkLane(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSubTradeList(e);
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
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {	// Summary 탭 조회
				eventResponse = searchCargoFlowMap(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchTPSZSequenceList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	// Trend 탭 조회
				eventResponse = searchCargoFlowMapTrend(e);				
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
		else if (e.getEventName().equalsIgnoreCase("EesCim1952Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTurnTimeByMvmtCntrList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesCim1061Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLocationMBByCOABKGService(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchMBTPeriodListService(e);			
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = clearLocationPOPService(e);										
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = checkLocationPOPService(e);														
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = manageFormatMBByCOABKGService(e);																
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse = searchFormatMBByCOABKGService(e);											
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLocationMBTByCOABKGService(e);			
			}			 			
		}	
		else if (e.getEventName().equalsIgnoreCase("EesCim1062Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLocationPOPService(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageLocationPOPService(e);	
			}			 			
		}	
		else if (e.getEventName().equalsIgnoreCase("EesCim1030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCargoFlowMapDetail(e);
			}
		}
		
		return eventResponse;
	}

	/**
	 * UI 공통 : BackEndJob<br>
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
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
	 * UI 공통 : BackEndJob<br>
	 * BackEndJob의 실행결과로 생성된 파일을 로드합니다.<br>
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
				if ("S".equals(gubun)) { // 화면 SUMMARY TAB
					list = (List<MTYCNTRPERFSummaryVO>) BackEndJobResult.loadFromFile(key);
					eventResponse.setRsVoList(list);
				}
				else if ("D".equals(gubun)) { // 화면 DETAIL TAB
					list = (List<MTYCNTRPERFInDetailVO>) BackEndJobResult.loadFromFile(key);
					eventResponse.setRsVoList(list);
				}
				else if ("DT".equals(gubun)) { // 화면 Daily Trend TAB
					list = (List<MTYCNTRPERFInDailyTrendVO>) BackEndJobResult.loadFromFile(key);
					eventResponse.setRsVoList(list);
				}
				else { // 화면 TREND TAB
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
	 * TurnTimeByMovement 를 조회 합니다. <br>
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
	 * TurnTimeByMovement Detail Tab을 조회 합니다. <br>
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
	 * EES_CIM_1952 : Retrieve <br>
	 * TurnTimeByMovement Detail Tab을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTurnTimeByMvmtCntrList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1952Event event = (EesCim1952Event) e;
		TurnTimePerformanceMgtBC command = new TurnTimePerformanceMgtBCImpl();
		List<TurnTimeByMvmtCntrListVO> list = command.searchTurnTimeByMvmtCntrList(event.getTTSearchOptionInGereralVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	/**
	 * EES_CIM_1001 : Retrieve <br>
	 * PortTurnTimeListByPort Detail 을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortTurnTimeListByPortDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1001Event event = (EesCim1001Event) e;
		TurnTimePerformanceMgtBC command = new TurnTimePerformanceMgtBCImpl();
		List<TurnTimeByTypeSizeVO> list = command.searchPortTurnTimeListByPortDetail(event.getTTSearchOptionInGereralVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * EES_CIM_1001 : Retrieve <br>
	 * PortTurnTimeListByPort Summary 을 조회 합니다. <br>
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
	 * PortTurnTimeListByLaneVVD Summary 을 조회 합니다. <br>
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
	 * PortTurnTimeListByLaneVVD Detail 을 조회 합니다. <br>
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
	 * 화면별 PortTurnTimeCombo : OPEN<br>
	 * Port,Lane Code COMBO List 조회<br>
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
	 * 화면별 TPSZSequence : OPEN<br>
	 * 컨테이너 타입 코드에 해당하는 Name 정보 조회<br>
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
	 * 화면별 Location : FOCUS OUT<br>
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
	 * 화면별 VVD : FOCUS OUT<br>
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
	 * 화면별 Lane : FOCUS OUT<br>
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
	 * 공통 : OPEN<br>
	 * Lane List를 조회한다<br>
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
	 * 공통 : OPEN<br>
	 * Yard List를 조회한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1007Event event = (EesCim1007Event) e;
		TurnTimePerformanceMgtBC command = new TurnTimePerformanceMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String pol = (String) event.getAttribute("pol");

		String[] arrYard = command.searchYardList(pol);
		StringBuilder sb = new StringBuilder();
		if (arrYard.length > 0) {
			for (int i = 0; i < arrYard.length - 1; i++) {
				sb.append(arrYard[i]);
				sb.append(",");
			}
			sb.append(arrYard[arrYard.length - 1]);
		}

		Map<String, String> etcData = new HashMap<String, String>();

		etcData.put("sLane", sb.toString());

		eventResponse.setETCData(etcData);

		return eventResponse;
	}
	/**
	 * 공통 : FOCUS OUT<br>
	 * VVD List를 조회한다<br>
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
	 * 공통 : FOCUS OUT<br>
	 * MB VVD List를 조회한다<br>
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
	 * LocationTurnTime Summary Tab 을 조회 합니다. <br>
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
	 * LocationTurnTime Detail Tab 을 조회 합니다. <br>
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
	 * 공통 : OPEN<br>
	 * CntrTypeSize List를 조회한다<br>
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

		List<SearchDayListVO> searchdaylistvo = command.searchDayList();

		StringBuilder sb2 = new StringBuilder();
		if (searchdaylistvo.size() > 0) {
			for (int i = 0; i < searchdaylistvo.size() - 1; i++) {
				sb2.append(searchdaylistvo.get(i).getDay());
				sb2.append(",");
			}
			sb2.append(searchdaylistvo.get(searchdaylistvo.size() - 1).getDay());
		}

		//Lease Term Combo Object Item
		LeaseTermBC leaseCommand = new LeaseTermBCImpl();
		List<MstLseTermVO> leaseTermList = leaseCommand.searchLeaseTermComboItemBasic();
		StringBuffer sLeaseTermNm = new StringBuffer();
		StringBuffer sLeaseTermCd = new StringBuffer();

		for ( int i = 0 ; i < leaseTermList.size() ; i++ ) {
			if ( sLeaseTermNm.toString().equals("") ) {
				sLeaseTermNm.append(leaseTermList.get(i).getLstmCd());
				sLeaseTermCd.append(leaseTermList.get(i).getLstmCd());
			} else {
				sLeaseTermNm.append("|").append(leaseTermList.get(i).getLstmCd());
				sLeaseTermCd.append("|").append(leaseTermList.get(i).getLstmCd());
			}
		}

		
		Map<String, String> etcData = new HashMap<String, String>();
		
		etcData.put("cntr_tpsz_cd", sb1.toString());
		etcData.put("cntrTypeSize", sb.toString());
		etcData.put("dayList", sb2.toString());
		etcData.put("lease_term_nm", sLeaseTermNm.toString());
		etcData.put("lease_term_cd", sLeaseTermCd.toString());

		eventResponse.setETCData(etcData);

		return eventResponse;
	}

	/**
	 * EES_CIM_1014 : Retrieve <br>
	 * TurnAroundTimeByTradeLane Tab 을 조회 합니다. <br>
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
	 * TurnAroundTimeByTPSZTrade Tab 을 조회 합니다. <br>
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
	 * TurnAroundTimeByLocation Tab 을 조회 합니다. <br>
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
	 * 공통 : OPEN<br>
	 * AroundTurnTimeCombo List(Trade,Lane,Tpsz Code)를 조회한다<br>
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
	 * 공통 : OPEN<br>
	 * Sub trade List combo를 조회한다<br>
	 * 
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubTradeList(Event e) throws EventException {

		CIMCommonBC command = new CIMCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {

			String[] arrLane = command.searchSubTradeList((String) e.getAttribute("trade"));

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
	 * 공통 : OPEN<br>
	 * Lane List combo를 조회한다<br>
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
	 * TMLMBByLogisticWise Summary Tab 을 조회 합니다. <br>
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
	 * TMLMBByLogisticWise Detail Tab 을 조회 합니다. <br>
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
	 * EES_CIM_1023 : Retrieve <br>
	 * TMLMBByLogisticWise Trend Tab 을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTmnlMBByLogiticWiseByTrend(Event e) throws EventException {

		log.debug("####### CNTROperatioNPerformanceMgtSC.searchTmnlMBByLogiticWiseByTrend 시작");
		// PDTO(Data Transfer Object including Parameters)
		EesCim1023Event event = (EesCim1023Event) e;

		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();

		MatchBackByMonthlyWeeklyTrendSetVO list = command.searchTmnlMBByLogiticWiseByTrend(event
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
		log.debug("@@@@@@@ CNTROperatioNPerformanceMgtSC.searchTmnlMBByLogiticWiseByTrend 끝");
		return eventResponse;
	}

	/**
	 * EES_CIM_1020 : Retrieve <br>
	 * LaneMBByLogisticWise 을 조회 합니다. <br>
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
	 * 공통 : OPEN<br>
	 * port,Lane,rcc Code,head List combo를 조회한다<br>
	 * 
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
	 * REPOResultByPort 을 조회 합니다. <br>
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
	 * REPOResultByLocation 을 조회 합니다. <br>
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
	 * MTYCNTRPERFByMovementSMRY Tab 을 조회 합니다. <br>
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
	 * MTYCNTRPERFByMovementDTL Tab 을 조회 합니다. <br>
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
	 * MTYCNTRPERFByMovementTrend Tab 을 조회 합니다. <br>
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
	 * EES_CIM_1051 : Retrieve <br>
	 * MTYCNTRPERFByMovementDailyTrend Tab 을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTYCNTRPERFByMovementDailyTrend(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim1051Event event = (EesCim1051Event) e;
		MTYRepositionPerformanceAnalysisBC command = new MTYRepositionPerformanceAnalysisBCImpl();
		String status = command.searchMTYCNTRPERFByMovementDailyTrend(event.getMTYCNTRPERFSearchOptionVO(), account);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("BackEndJobKey", status);
		return eventResponse;
	}
	
	/**
	 * EES_CIM_1018 : Retrieve <br>
	 * LocationMBByLogisticWise Summary Tab 을 조회 합니다. <br>
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
	 * LocationMBByLogisticWise Detail Tab 을 조회 합니다. <br>
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
	 * LoadFactorByTrade 을 조회 합니다. <br>
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
	 * LocationMBByLogisticWise Trend Tab 을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationMBByLogisticWiseByTrend(Event e) throws EventException {
		log.debug("####### CNTROperatioNPerformanceMgtSC.searchLocationMBByLogisticWiseByTrend 시작");
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
		log.debug("@@@@@@@ CNTROperatioNPerformanceMgtSC.searchLocationMBByLogisticWiseInSummary 끝");
		return eventResponse;
	}

	/**
	 * EES_CIM_1032 : Retrieve <br>
	 * MBByServiceMode Lsit 을 조회 합니다. <br>
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
	 * Location M/B by BKG-Wise Summary Tab 을 조회 합니다. <br>
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
	 * Location M/B by BKG-Wise Detail Tab 을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationMBByBKGWiseInDetail(Event e) throws EventException {
		log.debug("####### CNTROperatioNPerformanceMgtSC.searchLocationMBByBKGWiseInDetail 1027 시작");
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
	 * Location M/B by BKG-Wise Trend Tab 을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationMBByBKGWiseByTrend(Event e) throws EventException {
		log.debug("####### CNTROperatioNPerformanceMgtSC.searchLocationMBByBKGWiseByTrend 1027 시작");
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
		log.debug("@@@@@@@ CNTROperatioNPerformanceMgtSC.searchLocationMBByBKGWiseByTrend 1027 끝");
		return eventResponse;
	}

	/**
	 * EES_CIM_1029 : Retrieve <br>
	 * CargoFlowMapTrend 을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCargoFlowMapTrend(Event e) throws EventException {
		log.debug("####### CNTROperatioNPerformanceMgtSC.searchCargoFlowMapTrend 1029 시작");
		// PDTO(Data Transfer Object including Parameters)
		EesCim1029Event event = (EesCim1029Event) e;

		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<QuantityByTypeSizeVO> list = command.searchCargoFlowMapTrend(event.getSearchOptionByFromToVO());
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("@@@@@@@ CNTROperatioNPerformanceMgtSC.searchCargoFlowMapTrend 1029 끝");
		return eventResponse;
	}
	
	/**
	 * EES_CIM_1029 : Retrieve <br>
	 * CargoFlowMap 을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCargoFlowMap(Event e) throws EventException {
		log.debug("####### CNTROperatioNPerformanceMgtSC.searchCargoFlowMap 1029 시작");
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
		log.debug("@@@@@@@ CNTROperatioNPerformanceMgtSC.searchCargoFlowMap 1029 끝");
		return eventResponse;
	}	

	/**
	 * EES_CIM_1053 : OPEN <br>
	 * PreviousWeeks 을 [조회] 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreviousWeeks(Event e) throws EventException {
		log.debug("####### CNTROperatioNPerformanceMgtSC.searchPreviousWeeks 1053 시작");
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
		log.debug("@@@@@@@ CNTROperatioNPerformanceMgtSC.searchPreviousWeeks 1053 끝");
		return eventResponse;
	}

	/**
	 * EES_CIM_1053 : Retrieve <br>
	 * BatchJobStatus 을 [조회] 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBatchJobStatus(Event e) throws EventException {
		log.debug("####### CNTROperatioNPerformanceMgtSC.searchBatchJobStatus 1053 시작");
		// PDTO(Data Transfer Object including Parameters)
		EesCim1053Event event = (EesCim1053Event) e;
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		
		List<SearchBatchJobStatusVO> list = command.searchBatchJobStatus(event.getSearchOptionByFromToVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		log.debug("@@@@@@@ CNTROperatioNPerformanceMgtSC.searchBatchJobStatus 1053 끝");
		return eventResponse;
	}

	/**
	 * EES_CIM_1050 : Retrieve <br>
	 * MBByVessel 을 [조회] 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMBByVessel(Event e) throws EventException {
		log.debug("####### CNTROperatioNPerformanceMgtSC.searchMBByVessel 1050 시작");
		EesCim1050Event event = (EesCim1050Event) e;
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		
		String status = command.searchMBByVessel(event.getSearchOptionByTradeLaneVvdVO(), account);

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("BackEndJobKey", status);
		// eventResponse.setRsVoList(list);
		log.debug("@@@@@@@ CNTROperatioNPerformanceMgtSC.searchMBByVessel 1050 끝");
		return eventResponse;
	}

	/**
	 * EES_CIM_1050 : [SEARCH]<br>
	 * [MatchBakc By Vessel Lane List]을 [SEARCH By Trade]합니다.<br>
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
	 * [MatchBakc By Vessel VVD List]을 [SEARCH By Trade,Lane]합니다.<br>
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
	
	/**
	 * EES_CIM_1061 : Retrieve <br>
	 * Location M/B by COA-BKG 을 조회 합니다. MB탭 <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationMBByCOABKGService(Event e) throws EventException {	
		// PDTO(Data Transfer Object including Parameters)			
		EesCim1061Event event = (EesCim1061Event)e;	
			 
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {	
			List<MBDResultCOABKGVO> list = command.searchLocationMBByCOABKGBasic(event.getMBSearchOptionCOABKGVO());
			
			eventResponse.setRsVoList(list);	
				
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_CIM_1061 : COMMAND01 <br>
	 * Location M/B by COA-BKG <br>
	 * 탭별 헤더리스트 조회
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMBTPeriodListService(Event e) throws EventException {	
		// PDTO(Data Transfer Object including Parameters)			
		EesCim1061Event event = (EesCim1061Event)e;	
		
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {	
			String resString = command.searchMBTPeriodListBasic(event.getMBSearchOptionCOABKGVO());
			
			eventResponse.setETCData("PERIOD_LIST",resString);	
			
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_CIM_1061 : COMMAND02(IBCLEAR) <br>
	 * Location M/B by COA-BKG <br>
	 * Location POP을 초기화 함 New 버튼				
	 * @param e Event								
	 * @return response EventResponse	
	 * @exception EventException		
	 */
	private EventResponse clearLocationPOPService(Event e) throws EventException {	
		// PDTO(Data Transfer Object including Parameters)			
		EesCim1061Event event = (EesCim1061Event)e;			
			
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{				
			begin();							
			command.clearLocationPOPBasic(event.getMBSearchOptionCOABKGVO());
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
	 * EES_CIM_1061 : Retrieve <br>
	 * Location M/B by COA-BKG 을 조회 합니다. MBT탭 <br>
	 * 	
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationMBTByCOABKGService(Event e) throws EventException {	
		// PDTO(Data Transfer Object including Parameters)			
		EesCim1061Event event = (EesCim1061Event)e;	
			
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {	
			List<MBTResultCOABKGVO> list = command.searchLocationMBTByCOABKGBasic(event.getMBSearchOptionCOABKGVO());
				
			eventResponse.setRsVoList(list);	
			
		} catch (EventException ex) {	
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_CIM_1062 : Retrieve <br>
	 * Location POP 을 조회 합니다. <br>
	 * 	
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationPOPService(Event e) throws EventException {	
		// PDTO(Data Transfer Object including Parameters)			
		EesCim1062Event event = (EesCim1062Event)e;	
			
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {	
			List<ResultByLocationVO> list = command.searchLocationPOPBasic(event.getSearchOptionByLocationVO());
			eventResponse.setRsVoList(list);	
		} catch (EventException ex) {	
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_CIM_1062 : Close <br>
	 * USR_ID별로 로케이션 정보를 저장한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageLocationPOPService(Event e) throws EventException {
		EesCim1062Event event = (EesCim1062Event)e;	
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{			
			begin();					
			command.manageLocationPOPBasic(event.getResultByLocationVOS());
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
	 * EES_CIM_1061 : COMMAND03 <br>
	 * Location M/B by COA-BKG <br>
	 * Location 선택 여부를 체크하기 위한 Count 조회
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocationPOPService(Event e) throws EventException {	
		// PDTO(Data Transfer Object including Parameters)			
		EesCim1061Event event = (EesCim1061Event)e;	
			
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {	
			String resString = command.checkLocationPOPBasic(event.getMBSearchOptionCOABKGVO());
				
			eventResponse.setETCData("LOCATION_CNT",resString);			
			
		} catch (EventException ex) {	
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_CIM_1061 : COMMAND04,SaveFormat <br>
	 * 사용자별 조회 옵션을 저장한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFormatMBByCOABKGService(Event e) throws EventException {
		EesCim1061Event event = (EesCim1061Event)e;	
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{			
			begin();				
			command.manageFormatMBByCOABKGBasic(event.getMBSearchOptionCOABKGVO());
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
	 * EES_CIM_1061 : COMMAND05,RecallFormat <br>
	 * Location M/B by COA-BKG <br>
	 * FORMAT SAVE한 데이타를 조회해온다.
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFormatMBByCOABKGService(Event e) throws EventException {	
		// PDTO(Data Transfer Object including Parameters)			
		EesCim1061Event event = (EesCim1061Event)e;	
			
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {			
			SearchOptionByOTRVO searchOptionByOTRVO = command.searchFormatMBByCOABKGBasic(event.getMBSearchOptionCOABKGVO());
			
			if(searchOptionByOTRVO == null){
				searchOptionByOTRVO = new SearchOptionByOTRVO();	
			}	 				
			
			eventResponse.setETCData("CNTR_TPSZ_LVL",searchOptionByOTRVO.getCntrTpszLvl());		
			eventResponse.setETCData("RF_LVL",searchOptionByOTRVO.getRfLvl());		
			eventResponse.setETCData("TRD_NM",searchOptionByOTRVO.getTrdNm());		
			eventResponse.setETCData("SOC_LVL",searchOptionByOTRVO.getSocLvl());
		} catch (EventException ex) {	
			throw new EventException(new ErrorHandler(ex).getMessage());	
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_CIM_1030 (Cargo Flow Map Detail)
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCargoFlowMapDetail(Event e) throws EventException {
		EesCim1030Event event = (EesCim1030Event)e;
		EQMatchBackNLoadFactorMgtBC command = new EQMatchBackNLoadFactorMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<SearchCargoFlowMapDetailVO> list = command.searchCargoFlowMapDetail(event.getSearchOptionByFromToVO());
			eventResponse.setRsVoList(list);	
		} catch (EventException ex) {	
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;
	}
}