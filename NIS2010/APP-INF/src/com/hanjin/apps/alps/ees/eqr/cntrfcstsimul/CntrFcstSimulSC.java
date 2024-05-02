/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrFcstSimulSC.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.24 문동선
* 1.0 Creation 
* =========================================================
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.basic.CIMCommonBC;
import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.basic.CIMCommonBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.basic.CommonBC;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.basic.CommonBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.eqcorgchart.basic.EQCOrgChartBC;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.eqcorgchart.basic.EQCOrgChartBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.eqcorgchart.event.EesEqr1007Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.eqcorgchart.vo.EQCOrgChartListVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.basic.ForecastReportBC;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.basic.ForecastReportBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.event.EesEqr1002Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.event.EesEqr1003Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.event.EesEqr1040Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.event.EesEqr1048Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.event.EesEqr1049Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.event.EesEqr1081Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.event.EesEqr1082Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.event.EesEqr1083Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.EesEqr1048ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportCommonListVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportListVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.PlannedRepoInVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.basic.ForecastSummaryBC;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.basic.ForecastSummaryBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.event.EesEqr1101Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.event.EesEqr1102Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.vo.EQBalanceSheetListVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.vo.EQForecastSummaryListVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.basic.MTYEquipmentForecastBC;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.basic.MTYEquipmentForecastBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1001Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1004Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1043Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1044Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1045Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1046Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1047Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1062Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1063Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.ForecastAccuracyListVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalRptOtrVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceListVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceOptionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceRepoListVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.OpmgFcst3AvgVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.OpmgFcstInputVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.SalesFcstDtlVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.SalesProjectionHistVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.basic.OnhireBalanceBC;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.basic.OnhireBalanceBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.event.EesEqr1006Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.event.EesEqr1041Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.vo.OnhireStatusVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.vo.PlanAndApprovalVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.basic.SurplusAreaBC;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.basic.SurplusAreaBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.event.EesEqr1012Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.event.EesEqr1070Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.event.EesEqr1073Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.event.EesEqr1074Event;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.vo.PortSurplusAreaConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.vo.SurplusAreaConditionVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.basic.AvailableOffHireBC;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.basic.AvailableOffHireBCImpl;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-RepoPlanManage Business Logic ServiceCommand - ALPS-RepoPlanManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Haeng-ji,Lee
 * @see CntrRepoExecutionPlanEstablishDBDAO
 * @since J2EE 1.6
 */

public class CntrFcstSimulSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * RepoPlanManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("CntrFcstSimulSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * RepoPlanManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CntrFcstSimulSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-RepoPlanManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		
	    // EQC Organization Chart (EES_EQR_1007) 
        if (e.getEventName().equalsIgnoreCase("EesEqr1007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEQCOrgChartList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiEqrCtrlFcastLocService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	//Location 코드 체크
				eventResponse = checkLocation(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // OP/MG FCST Input 메인 sheet 조회
				eventResponse = searchOpmgFcstInputService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { // Reference1 조회
				eventResponse = searchOpmgFcst3AvgService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) { // Reference2 조회
				eventResponse = searchOpmgFcstReference2Service(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) { // 직전 주차 조회
				eventResponse = searchBeforeWeekService(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // OP/MG FCST Input 메인 sheet 저장
				eventResponse = manageOpmgFcstInputService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1004Event")) {  // Sales Projection Detail 조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEqFcstDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	//Location 코드 체크
				eventResponse = checkLocation(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1063Event")) {  // Sales Projection History 조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEqFcstHist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//Location 코드 체크
				eventResponse = checkLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = loadFileBackEndJobResultService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1046Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyBalanceOtherList(e,"1046");
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMtyBalanceOther(e,"1046");
			}
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1044Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyBalanceRepoList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1062Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searcForecastAccuracyList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//Location 코드 체크
				eventResponse = checkLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = loadFileBackEndJobResultService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1047Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyBalanceRepoOut(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMtyBalanceRepoOut(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMtyBalanceRepoOutVvdYardList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkMtyBalanceRepoOutYard(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1043Event")) {  // LOG 조회					
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyBalanceListLog(e);
			} 				
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1003Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = searchMtyWeeklySimulation(e);			
//			} 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMtyWeeklySimulationOrigin(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageMtyWeeklySimulation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkSubLocCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchForecastReportService(e);
			} else {
				eventResponse = searchCurrentWeek(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyWeeklySimulationReport(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkSubLocCd(e);
			} else {
				eventResponse = searchCurrentWeek(e);
			}	
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1048Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyRepoInDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMtyRepoInDetailVvdPortList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	
				eventResponse = searchLocationDatePeriod(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMtyRepoInDetailList(e);
			}   
			
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1049Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyRepoOutDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMtyRepoOutDetailVvdPortList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	
				eventResponse = searchLocationDatePeriod(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMtyRepoOutDetailList(e);
			}  			
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1040Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPlannedRepoInService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	// ETB 콤보 조회
				eventResponse = searchLocationDatePeriod2(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // return 값 조회	
				eventResponse = searchPlannedRepoInOriginService(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { // Yard Validation	
				eventResponse = checkPlannedRepoInYardService(e);		
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePlannedRepoInService(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOnhireStatusService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRccLccCd(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageOnhireStatusService(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1041Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPlanAndApprovalService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePlanAndApprovalService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = managePlanAndApprovalRequestService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRccLccCd(e);		
			} else {
				eventResponse = searchPlanAndApprovalCurrentWeek(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1070Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // 조회
				eventResponse = searchSurplusAreaService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // loc_cd 조회 
				eventResponse = checkRccCodeIs(e);
			} else {
				eventResponse = searchOfcLvl(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1073Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // 조회
				eventResponse = searchYardSurplusAreaService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // loc_cd 조회 
				eventResponse = checkRccCodeIs(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // MANUAL 데이터 저장
				eventResponse = manageYardSurplusAreaService(e);
			} else {
				eventResponse = searchOfcLvl(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1074Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // 조회
				eventResponse = searchBkgSurplusAreaService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // 조회
				eventResponse = searchPortSurplusAreaService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { // Sub-Conti 콤보 조회 
				eventResponse = searchSubcontiListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // MANUAL 데이터 저장
				eventResponse = managePortSurplusAreaService(e);
			} else {
				eventResponse = searchOfcLvl(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1081Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyRepoInDetailPastList(e);
			} 			
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1082Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyRepoOutDetailPastList(e);
			} 			
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1083Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyRepoOtherDetailPastList(e);
			} 			
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEQBalanceSheetList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEQForecastSummaryFilter(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkLocationByGroupCode(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1102Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEQForecastSummaryList(e);
			} else {
				eventResponse = searchCurrentWeek(e);
			}
		}
        
		return eventResponse;
	}


	/**
     * EES_EQR_1007Event 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchEQCOrgChartList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        List<EQCOrgChartListVO> list = new ArrayList<EQCOrgChartListVO>();
        try {
        	EesEqr1007Event event=(EesEqr1007Event)e;
            EQCOrgChartBC command = new EQCOrgChartBCImpl();
            
            String depth = event.getDepth();
            String chkDepth = event.getChkDepth();
            
            list = command.searchEQCOrgChartList(depth, chkDepth, account);
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }	
    
	/**
     * EES_EQR_1007Event 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse multiEqrCtrlFcastLocService(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        List<EQCOrgChartListVO> list = new ArrayList<EQCOrgChartListVO>();
        try {
        	EesEqr1007Event event=(EesEqr1007Event)e;
            EQCOrgChartBC command = new EQCOrgChartBCImpl();
            
            begin();
			command.multiEqrCtrlFcastLocBasic(event.getEQCOrgChartListVOs(),account);
			commit();

            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }	
	
	/**
	 * EES_EQR_1001 : [이벤트]<br>
	 * 과거 3주 분 실적과 향후 3주 까지의 OPMG Forecast Input data 를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOpmgFcstInputService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1001Event event 				= (EesEqr1001Event)e;
		MTYEquipmentForecastBC command 		= new MTYEquipmentForecastBCImpl();
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		Map<String,String> etcData 			= new HashMap<String,String>();
		
		event.getMtyBalanceOptionVO().setFcastYrwk(event.getMtyBalanceOptionVO().getFcastYrwk().replace("-", ""));
		List<OpmgFcstInputVO> list 			= command.searchOpmgFcstInputBasic(event.getMtyBalanceOptionVO());
		
		// LCC QTY를 먼저 입력하지 않으면, ECC/SCC 를 입력하지 못하도록 SAVE버튼, GRID 를 비활성화
		// 2013년, 송현애 과장 요청으로 기능 제거
		//String saveFlag = command.checkMtyBalanceLCCSave(event.getMtyBalanceOptionVO()); 
		
		// OP/MG FCST 화면의 OP/MG/RO/OTHER 항목수정 가능여부 확인
		String saveFlag = command.checkMtyBalanceSaveAvailable(event.getMtyBalanceOptionVO(), account); 
		
		eventResponse.setETCData(etcData);
		eventResponse.setRsVoList(list);
		eventResponse.setETCData("save_flag", saveFlag);
		
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1001 : [이벤트]<br>
	 * 과거 3주 분 실적과 향후 3주 까지의 OPMG Forecast Input data 를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOpmgFcst3AvgService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1001Event event = (EesEqr1001Event)e;
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		event.getMtyBalanceOptionVO().setFcastYrwk(event.getMtyBalanceOptionVO().getFcastYrwk().replace("-", ""));
		List<OpmgFcst3AvgVO> list = command.searchOpmgFcst3AvgBasic(event.getMtyBalanceOptionVO());
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		eventResponse.setRsVoList(list);
		return eventResponse;		
	}
    
	/**
	 * EES_EQR_1001 : [이벤트]<br>
	 * 지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력한 내용을 생성,수정<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOpmgFcstInputService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1001Event event = (EesEqr1001Event)e;
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		try{
			begin();
			command.manageOpmgFcstInputBasic(event.getOpmgFcstInputVOS(),account);
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
	 * EES_EQR_1004 : [이벤트]<br>
	 * Sales Projection Detail 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqFcstDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1004Event event = (EesEqr1004Event)e;
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		
		// 검색 입력값
		log.debug(">>>>>> 1004 loc_grp_cd   	    : " +event.getSalesFcstDtlVO().getLocGrpCd());
		log.debug(">>>>>> 1004 loc_cd       	        : " +event.getSalesFcstDtlVO().getLocCd());
		log.debug(">>>>>> 1004 fm_week       	    : " +event.getSalesFcstDtlVO().getFmWeek());
		log.debug(">>>>>> 1004 to_week       	    : " +event.getSalesFcstDtlVO().getToWeek());
		log.debug(">>>>>> 1004 rlane_cd       	    : " +event.getSalesFcstDtlVO().getRlaneCd());
		log.debug(">>>>>> 1004 create_chk_box 	: " +event.getSalesFcstDtlVO().getCreateChkBox());
		log.debug(">>>>>> 1004 fm_date       	    : " +event.getSalesFcstDtlVO().getFmDate());
		log.debug(">>>>>> 1004 to_date       	    : " +event.getSalesFcstDtlVO().getToDate());
		
		event.getSalesFcstDtlVO().setFmWeek(event.getSalesFcstDtlVO().getFmWeek().replace("-", ""));
		event.getSalesFcstDtlVO().setToWeek(event.getSalesFcstDtlVO().getToWeek().replace("-", ""));
		
		List<SalesFcstDtlVO> list = command.searchEqFcstDetail(event.getSalesFcstDtlVO());
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1063 : [이벤트]<br>
	 * Sales Projection History 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqFcstHist(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1063Event event = (EesEqr1063Event)e;
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		
		// 검색 입력값
		log.debug(">>>>>> 1004 div_flag   	    		    : " +event.getSalesProjectionHistVO().getDivFlag());
		log.debug(">>>>>> 1004 loc_tp_cd       	        : " +event.getSalesProjectionHistVO().getLocTpCd());
		log.debug(">>>>>> 1004 loc_tp_cd_second     	: " +event.getSalesProjectionHistVO().getLocTpCdSecond());
		log.debug(">>>>>> 1004 loc_cd   	    	    : " +event.getSalesProjectionHistVO().getLocCd());
		log.debug(">>>>>> 1004 loc_cd_second   	: " +event.getSalesProjectionHistVO().getLocCdSecond());
		log.debug(">>>>>> 1004 fm_week       	    : " +event.getSalesProjectionHistVO().getFmWeek());
		log.debug(">>>>>> 1004 to_week       	    : " +event.getSalesProjectionHistVO().getToWeek());
		
		event.getSalesProjectionHistVO().setFmWeek(event.getSalesProjectionHistVO().getFmWeek().replace("-", ""));
		event.getSalesProjectionHistVO().setToWeek(event.getSalesProjectionHistVO().getToWeek().replace("-", ""));
		
		String status = command.searchEqFcstHist(event.getSalesProjectionHistVO(), account);
		eventResponse.setETCData("BackEndJobKey", status);
		
		return eventResponse;	
	}
	
	/**
	 * EES_EQR_1001 : [이벤트]<br>
	 * 해당 주차의 직전 주차 번호를 가져옴<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBeforeWeekService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1001Event event = (EesEqr1001Event)e;
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		String val = command.searchBeforeWeekBasic((String)event.getAttribute("week"));
		eventResponse.setETCData("beforeweek", val);
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1001 : [이벤트]<br>
	 * OP Forecast, MG Forecast 의 Log를 조회..<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyBalanceListLog(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1043Event event = (EesEqr1043Event)e;
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		
		// Repo Plan ID 주차정보
		log.debug(">>>>>> 1043 loc_cd       	: " +event.getMtyBalanceOptionVO().getLocCd());
		log.debug(">>>>>> 1043 inp_yrwk     	: " +event.getMtyBalanceOptionVO().getInpYrwk());
		log.debug(">>>>>> 1043 fcast_yrwk   	: " +event.getMtyBalanceOptionVO().getFcastYrwk());
		log.debug(">>>>>> 1043 repo_pln_yrwk   	: " +event.getMtyBalanceOptionVO().getRepoPlnYrwk());
		log.debug(">>>>>> 1043 loc_grp_cd   	: " +event.getMtyBalanceOptionVO().getLocGrpCd());
		log.debug(">>>>>> 1043 tp_cd   			: " +event.getMtyBalanceOptionVO().getTpCd());
		
		
		event.getMtyBalanceOptionVO().setFcastYrwk(event.getMtyBalanceOptionVO().getFcastYrwk().replace("-", ""));	
		
		List<MtyBalanceListVO> list = command.searchMtyBalanceListLog(event.getMtyBalanceOptionVO());

		eventResponse.setRsVoList(list);

		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1001 : [이벤트]<br>
	 * OPMG Forecast 화면의 Reference 2 데이터를 조회한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOpmgFcstReference2Service(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1001Event event = (EesEqr1001Event)e;
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		event.getMtyBalanceOptionVO().setRepoPlnYrwk(event.getMtyBalanceOptionVO().getFcastYrwk().replace("-", ""));
		CommonRsVO commonRsVO = command.searchOpmgFcstReference2Basic(event.getMtyBalanceOptionVO(), (String)event.getAttribute("kind"));
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRs(commonRsVO.getDbRowset());
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1046,EES_EQR_1045 : [이벤트]<br>
	 * 해당 Yard 의 장비인수 및 임차계획 수량,장비수급에 영향을 미치는 EQ Demand & Supply의 기타항목들을 Manual로 입력한 내용을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyBalanceOtherList(Event e,String searchFlag) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		List<MtyBalRptOtrVO> list = new ArrayList<MtyBalRptOtrVO>();
		if ( searchFlag.equals("1045") ) {
			EesEqr1045Event event = (EesEqr1045Event)e;
			event.getMtyBalanceOptionVO().setFcastYrwk(event.getMtyBalanceOptionVO().getFcastYrwk().replace("-", ""));
			list = command.searchMtyBalanceOtherList(event.getMtyBalanceOptionVO());
		} else if ( searchFlag.equals("1046") ) {
			EesEqr1046Event event = (EesEqr1046Event)e;
			event.getMtyBalanceOptionVO().setFcastYrwk(event.getMtyBalanceOptionVO().getFcastYrwk().replace("-", ""));
			list = command.searchMtyBalanceOtherList(event.getMtyBalanceOptionVO());
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1046,EES_EQR_1045 : [이벤트]<br>
	 * 해당 Yard 의 장비인수 및 임차계획 수량,장비수급에 영향을 미치는 EQ Demand & Supply의 기타항목들을 Manual로 입력한 내용을 조회한다.<br>
	 * 
	 * @param Event e
	 * @param String searchFlag
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse manageMtyBalanceOther(Event e,String searchFlag) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// 2015.02.25 CHM-201534210 EQR 소스 보안
		EesEqr1045Event event1 = new EesEqr1045Event();
		EesEqr1046Event event2 = new EesEqr1046Event();
		
		if ( searchFlag.equals("1045") ) {
			event1 = (EesEqr1045Event)e;
		} else if ( searchFlag.equals("1046") ) {
			event2 = (EesEqr1046Event)e;
		}
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		try{
			begin();
			if ( searchFlag.equals("1045") ) {
				command.manageMtyBalanceOther(event1.getMtyBalRptOtrVOS(),account);
			} else if ( searchFlag.equals("1046") ) {
				command.manageMtyBalanceOther(event2.getMtyBalRptOtrVOS(),account);
			}
			commit();
		}catch(EventException ex){
			eventResponse.setUserMessage(new ErrorHandler("CIM00004").getUserMessage());
			rollback();
			throw ex;
		}
		return eventResponse;
	}	

	/**
	 * EES_EQR_1044 : [이벤트]<br>
	 *  EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyBalanceRepoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1044Event event = (EesEqr1044Event)e;
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		event.getMtyBalanceOptionVO().setFcastYrwk(event.getMtyBalanceOptionVO().getFcastYrwk().replace("-", ""));

		List<MtyBalanceRepoListVO> list = command.searchMtyBalanceRepoList(event.getMtyBalanceOptionVO());
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		event.setMtyBalanceRepoListVO(list.get(0));
		
		if(list.get(0).getCurrFlag().equals("T")){
			MtyBalanceOptionVO mtyBalanceOptionVO = event.getMtyBalanceOptionVO();
			mtyBalanceOptionVO.setWkStDt(list.get(0).getWkStDt());
			mtyBalanceOptionVO.setWkEndDt(list.get(0).getWkEndDt());
			List<MtyBalanceRepoListVO> list2 = command.searchMtyBalanceDischargedList(event.getMtyBalanceOptionVO());
			eventResponse.setRsVoList(list2);
		}
		return eventResponse;		
	}

	/**
	 * EES_EQR_1062 : [이벤트]<br>
	 *  MTY Balance Report의 In&Out Bound FCST Data의 정확도를 WEEK별로 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searcForecastAccuracyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1062Event event = (EesEqr1062Event)e;
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		event.getForecastAccuracyOptionVO().setFmWeek(event.getForecastAccuracyOptionVO().getFmWeek().replace("-", ""));
		event.getForecastAccuracyOptionVO().setToWeek(event.getForecastAccuracyOptionVO().getToWeek().replace("-", ""));

		String status = command.searchForecastAccuracyList(event.getForecastAccuracyOptionVO(), account);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("BackEndJobKey", status);
		return eventResponse;		
	}
	
	/**
	 * 화면별 Location 이벤트 체크로직<br>
	 * Location check validate<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CIMCommonBC command = new CIMCommonBCImpl();

		String locLevel = (String)e.getAttribute("inquirylevel");
		String locCD = (String)e.getAttribute("location");
		String check = command.checkLocation(locLevel,locCD);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Map<String,String> etcData = new HashMap<String,String>();
		etcData.put("check",check);
		
		eventResponse.setETCData(etcData);
		return eventResponse;
	}
	
	/**
	 * EES_EQR_1062 : BackEndJob<br>
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchComBackEndJobStatusService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			String key = (String)e.getAttribute("KEY");

			String status = command.searchComBackEndJobStatusBasic(key);
			eventResponse.setETCData("jb_sts_flg", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_EQR_1062 : BackEndJob<br>
	 * BackEndJob의 실행결과로 생성된 파일을 로드합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse loadFileBackEndJobResultService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String key = (String)e.getAttribute("KEY");
		// 2015.02.25 CHM-201534210 EQR 소스 보안
		List list = new ArrayList();

		try {
			if(e.getEventName().equalsIgnoreCase("EesEqr1062Event")) {
				list = (List<ForecastAccuracyListVO>)BackEndJobResult.loadFromFile(key);
			} else if(e.getEventName().equalsIgnoreCase("EesEqr1063Event")) {
				list = (List<SalesProjectionHistVO>)BackEndJobResult.loadFromFile(key);
			}

			eventResponse.setRsVoList(list);
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * EES_EQR_1047 : [이벤트]<br>
	 * EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyBalanceRepoOut(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		List<MtyBalanceRepoListVO> list = null;
		EesEqr1047Event event = (EesEqr1047Event)e;
		event.getMtyBalanceRepoListVO().setInpYrwk(event.getMtyBalanceRepoListVO().getInpYrwk().replace("-", ""));
		event.getMtyBalanceRepoListVO().setFcastYrwk(event.getMtyBalanceRepoListVO().getFcastYrwk().replace("-", ""));
		list = command.searchMtyBalanceRepoOut(event.getMtyBalanceRepoListVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1047 : [이벤트]<br>
	 * VVD를 이용하여 slan cd, from/to yard, etd, eta를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyBalanceRepoOutVvdYardList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		String slanCd = "";
		List<MtyBalanceRepoListVO> fmYdList = null;
		List<MtyBalanceRepoListVO> toYdList = null;
		EesEqr1047Event event = (EesEqr1047Event)e;
		slanCd = command.searchMtyBalanceRepoOutSlanCd(event.getMtyBalanceRepoListVO());
		fmYdList = command.searchMtyBalanceRepoOutFrYdList(event.getMtyBalanceRepoListVO());
		toYdList = command.searchMtyBalanceRepoOutToYdList(event.getMtyBalanceRepoListVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(fmYdList);
		eventResponse.setRsVoList(toYdList);
		eventResponse.setETCData("slan_cd", slanCd);
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1047 : [이벤트]<br>
	 * T/D VVD가 아닌 경우 입력된 yard cd가 해당 ecc/lcc/scc에 속하는지 체크
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkMtyBalanceRepoOutYard(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		String ydCd = "";
		EesEqr1047Event event = (EesEqr1047Event)e;
		ydCd = command.checkMtyBalanceRepoOutYard(event.getMtyBalanceRepoListVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("yd_cd", ydCd);
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1062 : [이벤트]<br>
	 * EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 수정한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMtyBalanceRepoOut(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1047Event event = (EesEqr1047Event)e;
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		try{
			begin();
			command.manageMtyBalanceRepoOut(event.getMtyBalanceRepoListVOS(),account);
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
	 * EES_EQR_1003 : [이벤트]<br>
	 * 지점별로 향후 -2~+7 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchForecastReportService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1003Event event = (EesEqr1003Event)e;
		ForecastReportBC command = new ForecastReportBCImpl();
		event.getForecastReportOptionVO().setFcastYrwk(event.getForecastReportOptionVO().getFcastYrwk().replace("-", ""));
		CommonRsVO commonRsVO = command.searchForecastReportBasic(event.getForecastReportOptionVO(), account);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRs(commonRsVO.getDbRowset());
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1003 : [이벤트]<br>
	 * 지점별로 향후 -1~+4 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
//	private EventResponse searchMtyWeeklySimulation(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		EesEqr1003Event event = (EesEqr1003Event)e;
//		ForecastReportBC command = new ForecastReportBCImpl();
//		List<ForecastReportVO> list = command.searchMtyWeeklySimulation(event.getForecastReportOptionVO());
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		eventResponse.setRsVoList(list);
//		
//		return eventResponse;		
//	}
	
	/**
	 * EES_EQR_1003 : [이벤트]<br>
	 * 해당 셀의 원래 값을 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyWeeklySimulationOrigin(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ForecastReportBC command = new ForecastReportBCImpl();
		String cntrQty = "";
		EesEqr1003Event event = (EesEqr1003Event)e;
		cntrQty = command.searchMtyWeeklySimulationOrigin(event.getForecastReportOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("cntr_qty", cntrQty);
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1003 : [이벤트]<br>
	 * 지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력한 내용을 생성,수정<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMtyWeeklySimulation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1003Event event = (EesEqr1003Event)e;
		ForecastReportBC command = new ForecastReportBCImpl();
		try{
			begin();
			command.manageMtyWeeklySimulation(event.getForecastReportOptionVOS(),account);
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
	 * EES_EQR_1003 : [이벤트]<br>
	 * 현재 주차를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrentWeek(Event e) throws EventException { // 현재 개발중
		// PDTO(Data Transfer Object including Parameters)
		CommonBC common = new CommonBCImpl(); // 따로 만들든지 하자 
		ForecastReportBC command = new ForecastReportBCImpl();
		CommonVO commonVO = null;
		String fcastYrwk = "";
		String levelCd = "";
		commonVO = common.getCurrentWeek();
		fcastYrwk = commonVO.getResultString().substring(0, 4) + "-" + commonVO.getResultString().substring(4);
		levelCd = command.checkMtyBalanceRepoOutYard(account.getOfc_cd());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("fcast_yrwk", fcastYrwk);
		eventResponse.setETCData("level_cd", levelCd);
		return eventResponse;		
	}	
	
	/**
	 * EES_EQR_1003, 1002: [이벤트]<br>
	 * 입력 받은 rcc/lcc/ecc가 해당 rcc에 속하는지 체크
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkSubLocCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ForecastReportBC command = new ForecastReportBCImpl();
		String check = "";
		if (e.getEventName().equalsIgnoreCase("EesEqr1003Event")) {
			EesEqr1003Event event = (EesEqr1003Event)e;
			check = command.checkSubLocCd(event.getForecastReportOptionVO());
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("check", check);
		return eventResponse;		
	}	
	
	/**
	 * EES_EQR_1002 : [이벤트]<br>
	 * 지점별로 이전 수 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyWeeklySimulationReport(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters) 
		EesEqr1002Event event = (EesEqr1002Event)e;
		ForecastReportBC command = new ForecastReportBCImpl();
		String rptTtl = command.searchMtyWeeklySimulationReportTitle(event.getForecastReportOptionVO());
		CommonRsVO commonRsVO = command.searchMtyWeeklySimulationReport(event.getForecastReportOptionVO(), rptTtl);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRs(commonRsVO.getDbRowset());
		eventResponse.setETCData("rpt_ttl", rptTtl);
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1048 : [이벤트]<br>
	 * 1048화면에서 입력된 수기정보+REPO IN 데이터를 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyRepoInDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1048Event event = (EesEqr1048Event)e;
		ForecastReportBC command = new ForecastReportBCImpl();
		event.getEesEqr1048ConditionVO().setFcastYrwk(event.getEesEqr1048ConditionVO().getFcastYrwk().replace("-", ""));
		
		List<ForecastReportListVO> list = command.searchMtyRepoInDetailList(event.getEesEqr1048ConditionVO());
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		event.setForecastReportListVO(list.get(0));
		
		if(list.get(0).getCurrFlag().equals("T")){
			EesEqr1048ConditionVO eesEqr1048ConditionVO = event.getEesEqr1048ConditionVO();
			eesEqr1048ConditionVO.setWkStDt(list.get(0).getWkStDt());
			eesEqr1048ConditionVO.setWkEndDt(list.get(0).getWkEndDt());
			
			log.debug(">>>>>>>>>>>>>>> getCurrFlag 1");
			List<ForecastReportListVO> list2 = command.searchMtyBalanceDischargedList(event.getEesEqr1048ConditionVO());
			
			log.debug(">>>>>>>>>>>>>>> getCurrFlag 2");
			eventResponse.setRsVoList(list2);
		}
		return eventResponse;		
	}	

	/**
	 * EES_EQR_1048 : [이벤트]<br> // 1040 도 같이쓸수 있을까..?? MDS
	 * VVD를 이용하여 slan cd, PORT, ETB를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyRepoInDetailVvdPortList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ForecastReportBC command = new ForecastReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String slanCd = "";
		
		EesEqr1048Event event = (EesEqr1048Event)e;
		slanCd   = command.searchMtyBalanceRepoOutSlanCd(event.getForecastReportListVO());
		
		eventResponse.setETCData("slan_cd", slanCd);
		
		return eventResponse;		
	}	
	
	/**
	 * EES_EQR_1048 : [이벤트]<br> // 1040 같이쓸수 있으려나 ?? MDS
	 * LCC/ECC/SCC 내 소속 LOCATION,ETB DATE<br>
	 * 
	 * @param e 이벤트
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationDatePeriod(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		Map<String,String> etcData = new HashMap<String,String>();
		
		GeneralEventResponse yardEtcData = (GeneralEventResponse)searchLocationList(e);
		etcData.put("to_yd_cd",yardEtcData.getETCData("to_yd_cd").toString());
		etcData.put("to_yd_nm",yardEtcData.getETCData("to_yd_nm").toString());

		GeneralEventResponse dateEtcData = (GeneralEventResponse)searchLocationDateList(e);
		etcData.put("to_etb_dt", dateEtcData.getETCData("to_etb_dt").toString());

		
		eventResponse.setETCData(etcData);
		return eventResponse;
	}		
	
	/**
	 * EES_EQR_1048 : [이벤트]<br>
	 * LCC/ECC/SCC 에 속한 LOCATION<br>
	 * 
	 * @param e 이벤트
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationList(Event e) throws EventException {
		String locCd    = (String)e.getAttribute("loc_cd");
		String locGrpCd = (String)e.getAttribute("loc_grp_cd");
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ForecastReportBC command = new ForecastReportBCImpl();
		
		List<ForecastReportCommonListVO> forecastReportCommonListVO = command.searchLocationList( locGrpCd, locCd );
		StringBuilder ydCdSb = new StringBuilder();
		StringBuilder ydNmSb = new StringBuilder();
		if(forecastReportCommonListVO.size() > 0) {
			for(int i = 0 ; i < forecastReportCommonListVO.size()-1 ; i++){
				ydCdSb.append(forecastReportCommonListVO.get(i).getYdCd());
				ydCdSb.append("|");
				ydNmSb.append(forecastReportCommonListVO.get(i).getYdNm());
				ydNmSb.append("|");
			}
			ydCdSb.append(forecastReportCommonListVO.get(forecastReportCommonListVO.size()-1).getYdCd());
			ydNmSb.append(forecastReportCommonListVO.get(forecastReportCommonListVO.size()-1).getYdNm());
		}

		Map<String,String> etcData = new HashMap<String,String>();
		
		etcData.put("to_yd_cd",ydCdSb.toString());
		etcData.put("to_yd_nm",ydNmSb.toString());
		
		eventResponse.setETCData(etcData);
		return eventResponse;
	}	
	
	/**
	 * EES_EQR_1048 : [이벤트]<br>
	 * 특정 주차내의 일자 목록을 조회한다.<br>
	 * 
	 * @param e 이벤트
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationDateList(Event e) throws EventException {
		log.debug("--------------searchLocationDateList START ");
		String wk_st_dt = ((String)e.getAttribute("wk_st_dt")).replace("/", "");
		log.debug("--------------searchLocationDateList SC wk_st_dt : " +wk_st_dt);
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ForecastReportBC command = new ForecastReportBCImpl();
		List<ForecastReportCommonListVO> forecastReportCommonListVO = command.searchLocationDateList( wk_st_dt  );
		StringBuilder ydCdSb = new StringBuilder();
		
		if(forecastReportCommonListVO.size() > 0) {
			for(int i = 0 ; i < forecastReportCommonListVO.size()-1 ; i++){
				ydCdSb.append(forecastReportCommonListVO.get(i).getDateListByWeek());
				ydCdSb.append("|");
			}
			ydCdSb.append(forecastReportCommonListVO.get(forecastReportCommonListVO.size()-1).getDateListByWeek());
		}

		Map<String,String> etcData = new HashMap<String,String>();
		
		etcData.put("to_etb_dt", ydCdSb.toString());
		
		eventResponse.setETCData(etcData);
		return eventResponse;
	}			

	/**
	 * EES_EQR_1048 : [이벤트]<br>
	 * REPO IN 데이터를 수기로 관리하는 기능 처리.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMtyRepoInDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1048Event event = (EesEqr1048Event)e;
		ForecastReportBC command = new ForecastReportBCImpl();
		
		log.debug(">>>>>>>>>>>>>>>> event.getMtyBalanceRepoListVOS().length : "+event.getForecastReportListVOS().length);
		try{
			begin();
			command.manageMtyRepoInDetailList(event.getForecastReportListVOS(),account);
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
	 * EES_EQR_1040 : [이벤트]<br>
	 * 1040화면에서 입력된 수기정보 + PLANNED REPO IN 데이터를 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPlannedRepoInService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1040Event event = (EesEqr1040Event)e;
		ForecastReportBC command = new ForecastReportBCImpl();
		event.getEesEqr1048ConditionVO().setFcastYrwk(event.getEesEqr1048ConditionVO().getFcastYrwk().replace("-", ""));
		
		List<PlannedRepoInVO> list = command.searchPlannedRepoInBasic(event.getEesEqr1048ConditionVO());
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		event.setPlannedRepoInVO(list.get(0));

		return eventResponse;		
	}	
	
	/**
	 * EES_EQR_1040 : [이벤트]<br>
	 * REPO IN 데이터를 수기로 관리하는 기능 처리.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePlannedRepoInService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1040Event event = (EesEqr1040Event)e;
		ForecastReportBC command = new ForecastReportBCImpl();
		
		try{
			begin();
			command.managePlannedRepoInBasic(event.getPlannedRepoInVOS(),account);
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
	 * EES_EQR_1040 
	 * LCC/ECC/SCC 내 ETB DATE<br>
	 * 
	 * @param e 이벤트
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationDatePeriod2(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		Map<String,String> etcData = new HashMap<String,String>();

		GeneralEventResponse dateEtcData = (GeneralEventResponse)searchLocationDateList(e);
		etcData.put("to_etb_dt", dateEtcData.getETCData("to_etb_dt").toString());
		
		eventResponse.setETCData(etcData);
		return eventResponse;
	}
	
	/**
	 * EES_EQR_1040 : [이벤트]<br>
	 * 해당 셀의 원래 값을 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPlannedRepoInOriginService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ForecastReportBC command = new ForecastReportBCImpl();
		String rst = "";
		EesEqr1040Event event = (EesEqr1040Event)e;
		rst = command.searchPlannedRepoInOriginBasic(event.getPlannedRepoInVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("cntr_qty", rst);
		return eventResponse;		
	}	
	
	/**
	 * EES_EQR_1040 : [이벤트]<br>
	 * Yard 유효성 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPlannedRepoInYardService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ForecastReportBC command = new ForecastReportBCImpl();
		String rst = "";
		EesEqr1040Event event = (EesEqr1040Event)e;
		rst = command.checkPlannedRepoInYardBasic(event.getEesEqr1048ConditionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("yard_chk", rst);
		return eventResponse;		
	}	

	/**
	 * EES_EQR_1006 : [이벤트]<br>
	 * 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOnhireStatusService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1006Event event = (EesEqr1006Event)e;
		OnhireBalanceBC command = new OnhireBalanceBCImpl();
		List<OnhireStatusVO> list = null;
		
		list = command.searchOnhireStatusBasic(event.getOnhireStatusVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		
		return eventResponse;		
	}	
	
	/**
	 * EES_EQR_1006 : [이벤트]<br>
	 * 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOnhireStatusService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1006Event event = (EesEqr1006Event)e;
		OnhireBalanceBC command = new OnhireBalanceBCImpl();
		
		try{
			begin();
			command.manageOnhireStatusBasic(event.getOnhireStatusVOS(),account);
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
	 * RCC_CD, LCC_CD 리스트 조회<br>
	 * 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRccLccCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		OnhireBalanceBC command = new OnhireBalanceBCImpl();
		
		CommonRsVO commonRsVO = command.searchRccLccCd((String)e.getAttribute("loc_grp_cd"),(String)e.getAttribute("loc_cd"));
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRs(commonRsVO.getDbRowset());
		return eventResponse;				
	}			
	
	/**
	 * EES_EQR_1040 : [이벤트]<br>
	 * 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPlanAndApprovalService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1041Event event = (EesEqr1041Event)e;
		OnhireBalanceBC command = new OnhireBalanceBCImpl();
		List<PlanAndApprovalVO> list = null;
		
		list = command.searchPlanAndApprovalBasic(event.getPlanAndApprovalConditionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		
		return eventResponse;		
	}	
	
	/**
	 * EES_EQR_1040 : [이벤트]<br>
	 * 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePlanAndApprovalService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1041Event event = (EesEqr1041Event)e;
		OnhireBalanceBC command = new OnhireBalanceBCImpl();
		
		try{
			String newLsePlnSeqStr = "";
			begin();
			newLsePlnSeqStr = command.managePlanAndApprovalBasic(event.getPlanAndApprovalVOS(),account);
			commit();
			eventResponse.setETCData("new_lse_pln_seq_str",newLsePlnSeqStr); // Insert 하면서 채번한 lse_pln_seq 를 , 로 이은 String
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}		
	
	/**
	 * EES_EQR_1040 : [이벤트]<br>
	 * Request/Request Cancel 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePlanAndApprovalRequestService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1041Event event = (EesEqr1041Event)e;
		OnhireBalanceBC command = new OnhireBalanceBCImpl();
		
		try{
			String newLseRqstNoStr = "";
			begin();
			newLseRqstNoStr = command.managePlanAndApprovalRequestBasic(event.getPlanAndApprovalVOS(),account);
			commit();
			eventResponse.setETCData("new_lse_rqst_no_str",newLseRqstNoStr); // Insert 하면서 채번한 lse_pln_seq 를 , 로 이은 String
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_EQR_1070 : 조회 이벤트<br>
	 * Surplus Area 시트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurplusAreaService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters) 
		EesEqr1070Event event = (EesEqr1070Event)e;
		SurplusAreaBC command = new SurplusAreaBCImpl();
		if (event!=null && event.getSurplusAreaConditionVO()!=null){
			event.getSurplusAreaConditionVO().setOfcCd(JSPUtil.getNull(event.getSignOnUserAccount().getOfc_cd()));	
		}
		String rptTtl = command.searchSurplusAreaTitleBasic(event.getSurplusAreaConditionVO());
		CommonRsVO commonRsVO = command.searchSurplusAreaBasic(event.getSurplusAreaConditionVO(), rptTtl);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRs(commonRsVO.getDbRowset());
		eventResponse.setETCData("rpt_ttl", rptTtl);
		return eventResponse;		
	}	

	/**
	 * LOC Code 유효성 조회 이벤트 처리 (RCC_CD 반환)<br>
	 * CommonEvent 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/ 
	private EventResponse checkRccCodeIs(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		String locChk = "";
		try {
			SurplusAreaBC command = new SurplusAreaBCImpl();
			String locGrpCd = (String)e.getAttribute("loc_grp_cd");
			String locCd    = (String)e.getAttribute("loc_cd");
			
			locChk = command.checkRccCodeIs(locGrpCd, locCd);
			eventResponse.setETCData("rcc_chk", locChk);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * EES_EQR_1073 : 조회 이벤트<br>
	 * Surplus Area 시트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardSurplusAreaService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters) 
		EesEqr1073Event event = (EesEqr1073Event)e;
		SurplusAreaBC command = new SurplusAreaBCImpl();
		
		String authChk = command.checkYardSurplusAreaAuthBasic(account); // 로그인 office 가 수정 권한이 있는지 조회

		String rptTtl = command.searchCurrSevenWeeksBasic(); // 현재시각 기준으로 기본 7 주차 가져오기
		String rptTtlArr[] = rptTtl.split(",");
		SurplusAreaConditionVO surplusAreaConditionVO = event.getSurplusAreaConditionVO();
		surplusAreaConditionVO.setFmYrwk(rptTtlArr[0]);                  // 시작 주차 (과거 3주)
		surplusAreaConditionVO.setCurrYrwk(rptTtlArr[3]);                // 현재주차			
		surplusAreaConditionVO.setToYrwk(rptTtlArr[rptTtlArr.length-1]); // 끝 주차    (미래 3주)
		surplusAreaConditionVO.setOfcCd(JSPUtil.getNull(event.getSignOnUserAccount().getOfc_cd()));
		
		CommonRsVO commonRsVO = command.searchYardSurplusAreaBasic(surplusAreaConditionVO, rptTtl);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRs(commonRsVO.getDbRowset());
		eventResponse.setETCData("rpt_ttl", rptTtl);
		eventResponse.setETCData("auth_chk", authChk);
		return eventResponse;		
	}	

	/**
	 * EES_EQR_1073 : [이벤트]<br>
	 * Surplus Area 메뉴얼 내용을 생성,수정<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageYardSurplusAreaService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1073Event event = (EesEqr1073Event)e;
		SurplusAreaBC command = new SurplusAreaBCImpl();
		try{
			begin();
			command.manageYardSurplusAreaBasic(event.getSurplusAreaVOS(),account);
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
	 * EES_EQR_1074 : 조회 이벤트<br>
	 * Surplus Area - Yard 의 BKG for OP Ref 팝업 데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgSurplusAreaService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters) 
		EesEqr1074Event event = (EesEqr1074Event)e;
		SurplusAreaBC command = new SurplusAreaBCImpl();

		String rptTtl = command.searchCurrSevenWeeksBasic(); // 현재시각 기준으로 기본 7 주차 가져오기
		String rptTtlArr[] = rptTtl.split(",");
		SurplusAreaConditionVO surplusAreaConditionVO = event.getSurplusAreaConditionVO();
		surplusAreaConditionVO.setFmYrwk(rptTtlArr[0]);                  // 시작 주차 (과거 3주)
		surplusAreaConditionVO.setCurrYrwk(rptTtlArr[3]);                // 현재주차	
		surplusAreaConditionVO.setToYrwk(rptTtlArr[rptTtlArr.length-1]); // 끝 주차     (미래 3주)

		
		CommonRsVO commonRsVO = command.searchBkgSurplusAreaBasic(surplusAreaConditionVO, rptTtl);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRs(commonRsVO.getDbRowset());
		eventResponse.setETCData("rpt_ttl", rptTtl);
		return eventResponse;		
	}		

	/**
	 * 권한 정의를 위한 ofc level 조회하기
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchOfcLvl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SurplusAreaBC command = new SurplusAreaBCImpl();
		String levelCd = command.searchOfcLvl(account.getOfc_cd());
		eventResponse.setETCData("level_cd",JSPUtil.getNull(levelCd));
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1012 : 조회 이벤트<br>
	 * Surplus Area - Port 시트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortSurplusAreaService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters) 
		EesEqr1012Event event = (EesEqr1012Event)e;
		SurplusAreaBC command = new SurplusAreaBCImpl();
		
		String authChk = command.checkPortSurplusAreaAuthBasic(account); // 로그인 office 가 수정 권한이 있는지 조회
	
		String rptTtl = command.searchCurrSevenWeeksBasic(); // 현재시각 기준으로 기본 7 주차 가져오기
		String rptTtlArr[] = rptTtl.split(",");
		PortSurplusAreaConditionVO portSurplusAreaConditionVO = event.getPortSurplusAreaConditionVO();
		portSurplusAreaConditionVO.setFmYrwk(rptTtlArr[0]);                  // 시작 주차 (과거 3주)
		portSurplusAreaConditionVO.setCurrYrwk(rptTtlArr[3]);                // 현재주차	
		portSurplusAreaConditionVO.setToYrwk(rptTtlArr[rptTtlArr.length-1]); // 끝 주차    (미래 3주)
		
		//CommonRsVO commonRsVO = command.searchPortSurplusAreaBasic(portSurplusAreaConditionVO, rptTtl);
		List<CommonRsVO> commonRsVOs = command.searchPortSurplusAreaBasic(portSurplusAreaConditionVO, rptTtl);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		if(commonRsVOs.size() > 1){
			eventResponse.setRs(commonRsVOs.get(0).getDbRowset());
			eventResponse.setRs(commonRsVOs.get(1).getDbRowset());
			eventResponse.setETCData("rpt_ttl", rptTtl);
			eventResponse.setETCData("auth_chk", authChk);
		}
		return eventResponse;		
	}	
	
	/**
	 * EES_EQR_1012 : [이벤트]<br>
	 * Surplus Area - Port 메뉴얼 내용을 생성,수정<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePortSurplusAreaService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1012Event event = (EesEqr1012Event)e;
		SurplusAreaBC command = new SurplusAreaBCImpl();
		try{
			begin();
			command.managePortSurplusAreaBasic(event.getSurplusAreaVOS(),account);
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
	 * Sub-Conti 콤보 리스트 조회<br>
	 * 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubcontiListService(Event e) throws EventException {
		
		EesEqr1012Event event = (EesEqr1012Event)e;
		PortSurplusAreaConditionVO portSurplusAreaConditionVO = event.getPortSurplusAreaConditionVO();
		
		// PDTO(Data Transfer Object including Parameters)
		SurplusAreaBC command = new SurplusAreaBCImpl();
		
		CommonRsVO commonRsVO = command.searchSubcontiListBasic(portSurplusAreaConditionVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRs(commonRsVO.getDbRowset());
		
		return eventResponse;				
	}	
	
	/**
	 * EES_EQR_1003 : [이벤트]<br>
	 * 현재 주차를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPlanAndApprovalCurrentWeek(Event e) throws EventException { // 현재 개발중
		// PDTO(Data Transfer Object including Parameters)
		CommonBC common = new CommonBCImpl(); // 따로 만들든지 하자 
		ForecastReportBC command = new ForecastReportBCImpl();
		CommonVO commonVO = null;
		
		String fcastYrwk = "";
		String levelCd   = "";
		
		commonVO = common.getCurrentWeek();
		fcastYrwk = commonVO.getResultString();
		levelCd = command.checkMtyBalanceRepoOutYard(account.getOfc_cd());
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("fcast_yrwk", fcastYrwk);
		eventResponse.setETCData("level_cd", levelCd);
		
		return eventResponse;		
	}		
	
	/**
	 * EES_EQR_1049 : [이벤트]<br>
	 * 1049화면에서 입력된 수기정보+REPO Out 데이터를 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyRepoOutDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1049Event event = (EesEqr1049Event)e;
		ForecastReportBC command = new ForecastReportBCImpl();
		event.getEesEqr1049ConditionVO().setFcastYrwk(event.getEesEqr1049ConditionVO().getFcastYrwk().replace("-", ""));
		
		List<ForecastReportListVO> list = command.searchMtyRepoOutDetailList(event.getEesEqr1049ConditionVO());
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		event.setForecastReportListVO(list.get(0));

		return eventResponse;		
	}	
	
	/**
	 * EES_EQR_1049 : [이벤트]<br> 
	 * VVD를 이용하여 slan cd, PORT, ETB를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyRepoOutDetailVvdPortList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ForecastReportBC command = new ForecastReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String slanCd = "";
		
		EesEqr1049Event event = (EesEqr1049Event)e;
		slanCd   = command.searchMtyBalanceRepoOutSlanCd(event.getForecastReportListVO());
		
		eventResponse.setETCData("slan_cd", slanCd);
		
		return eventResponse;		
	}		
	
	/**
	 * EES_EQR_1049 : [이벤트]<br>
	 * REPO OUT 데이터를 수기로 관리하는 기능 처리.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMtyRepoOutDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1049Event event = (EesEqr1049Event)e;
		ForecastReportBC command = new ForecastReportBCImpl();
		
		log.debug(">>>>>>>>>>>>>>>> event.getMtyBalanceRepoListVOS().length : "+event.getForecastReportListVOS().length);
		try{
			begin();
			command.manageMtyRepoOutDetailList(event.getForecastReportListVOS(),account);
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
	 * EES_EQR_1081 : [이벤트]<br>
	 * Reposition In Detail 과거실적 조회 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyRepoInDetailPastList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1081Event event = (EesEqr1081Event)e;
		ForecastReportBC command = new ForecastReportBCImpl();
		event.getEesEqr1081ConditionVO().setFcastYrwk(event.getEesEqr1081ConditionVO().getFcastYrwk().replace("-", ""));
		
		List<ForecastReportListVO> list = command.searchMtyRepoInDetailPastList(event.getEesEqr1081ConditionVO());
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		event.setForecastReportListVO(list.get(0));
		
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1082 : [이벤트]<br>
	 * Reposition Out Detail 과거실적 조회 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyRepoOutDetailPastList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1082Event event = (EesEqr1082Event)e;
		ForecastReportBC command = new ForecastReportBCImpl();
		event.getEesEqr1082ConditionVO().setFcastYrwk(event.getEesEqr1082ConditionVO().getFcastYrwk().replace("-", ""));
		
		List<ForecastReportListVO> list = command.searchMtyRepoOutDetailPastList(event.getEesEqr1082ConditionVO());
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		event.setForecastReportListVO(list.get(0));
		
		return eventResponse;		
	}		
	
	/**
	 * EES_EQR_1083 : [이벤트]<br>
	 * Reposition Other Detail 과거실적 조회 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyRepoOtherDetailPastList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1083Event event = (EesEqr1083Event)e;
		ForecastReportBC command = new ForecastReportBCImpl();
		event.getEesEqr1083ConditionVO().setFcastYrwk(event.getEesEqr1083ConditionVO().getFcastYrwk().replace("-", ""));
		
		List<ForecastReportListVO> list = command.searchMtyRepoOtherDetailPastList(event.getEesEqr1083ConditionVO());
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		event.setForecastReportListVO(list.get(0));
		
		return eventResponse;		
	}
	
	
	/**
	 * EES_EQR_1101 : [이벤트]<br>
	 * EQ Forecast Summary Filter 조회 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQBalanceSheetList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1101Event event = (EesEqr1101Event)e;
		ForecastSummaryBC command = new ForecastSummaryBCImpl();

		List<EQBalanceSheetListVO> list = command.searchEQBalanceSheetList(event.getEQForecastSummaryINVO());
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1101 : [이벤트]<br>
	 * EQ Forecast Summary Filter 데이터 입력 수정<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEQForecastSummaryFilter(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1101Event event = (EesEqr1101Event)e;
		ForecastSummaryBC command = new ForecastSummaryBCImpl();
		try{
			begin();
			command.manageEQForecastSummaryFilter(event.getEQBalanceSheetListVOS(),account);
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
	 * EES_EQR_1101 : [이벤트]<br>
	 * RCC_CD, LOC_GRP_CD에 따른 LOCATION코드 조회 <br>
	 * GRID COMBO에 사용
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocationByGroupCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1101Event event = (EesEqr1101Event)e;
		ForecastSummaryBC command = new ForecastSummaryBCImpl();

		int count = command.checkLocationByGroupCode(event.getEQForecastSummaryINVO());
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("count", count+"");
		
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1102 : [이벤트]<br>
	 * EQ Forecast Summary 조회 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQForecastSummaryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1102Event event = (EesEqr1102Event)e;
		ForecastSummaryBC command = new ForecastSummaryBCImpl();
		
		List<EQForecastSummaryListVO> list = command.searchEQForecastSummaryList(event.getEQForecastSummaryINVO());
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		
		return eventResponse;		
	}		
	
}