/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrFcstSimulSC.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.basic.CIMCommonBC;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.basic.CIMCommonBCImpl;
import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.basic.CommonBC;
import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.basic.CommonBCImpl;
import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.eqcorgchart.basic.EQCOrgChartBC;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.eqcorgchart.basic.EQCOrgChartBCImpl;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.eqcorgchart.event.EesEqr1007Event;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.eqcorgchart.vo.EQCOrgChartListVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.basic.ForecastReportBC;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.basic.ForecastReportBCImpl;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.event.EesEqr1002Event;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.event.EesEqr1003Event;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.event.EesEqr1040Event;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.event.EesEqr1048Event;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.vo.EesEqr1048ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportCommonListVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportListVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.vo.PlannedRepoInVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.basic.MTYEquipmentForecastBC;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.basic.MTYEquipmentForecastBCImpl;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1001Event;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1043Event;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1044Event;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1045Event;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1046Event;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1047Event;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1062Event;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.ForecastAccuracyListVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalRptOtrVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceListVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceOptionVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceRepoListVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.OpmgFcst3AvgVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.OpmgFcstInputVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.basic.OnhireBalanceBC;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.basic.OnhireBalanceBCImpl;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.event.EesEqr1006Event;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.event.EesEqr1041Event;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.vo.OnhireStatusVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.vo.PlanAndApprovalVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.basic.SurplusAreaBC;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.basic.SurplusAreaBCImpl;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.event.EesEqr1012Event;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.event.EesEqr1070Event;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.event.EesEqr1073Event;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.event.EesEqr1074Event;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.vo.PortSurplusAreaConditionVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.vo.SurplusAreaConditionVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.basic.AvailableOffHireBC;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.basic.AvailableOffHireBCImpl;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-RepoPlanManage Business Logic ServiceCommand - OPUS-RepoPlanManage 
 * 
 * @author 
 * @see CntrRepoExecutionPlanEstablishDBDAO
 * @since J2EE 1.6
 */

public class CntrFcstSimulSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * RepoPlanManage system <br>
	 */
	public void doStart() {
		log.debug("CntrFcstSimulSC");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * RepoPlanManage system <br>
	 */
	public void doEnd() {
		log.debug("CntrFcstSimulSC ");
	}

	/**
	 * OPUS-RepoPlanManage system<br>
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
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	//Location 
				eventResponse = checkLocation(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // OP/MG FCST Input - sheet 
				eventResponse = searchOpmgFcstInputService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { // Reference1 
				eventResponse = searchOpmgFcst3AvgService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) { // Reference2 
				eventResponse = searchOpmgFcstReference2Service(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) { //
				eventResponse = searchBeforeWeekService(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // OP/MG FCST Input - sheet 
				eventResponse = manageOpmgFcstInputService(e);
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
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//Location 
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
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1043Event")) {  // LOG 					
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyBalanceListLog(e);
			} 				
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyWeeklySimulation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
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
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1040Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPlannedRepoInService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	// ETB 
				eventResponse = searchLocationDatePeriod2(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // return 	
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
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // 
				eventResponse = searchSurplusAreaService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // loc_cd  
				eventResponse = checkRccCodeIs(e);
			} else {
				eventResponse = searchOfcLvl(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1073Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // 
				eventResponse = searchYardSurplusAreaService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // loc_cd  
				eventResponse = checkRccCodeIs(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // MANUAL  
				eventResponse = manageYardSurplusAreaService(e);
			} else {
				eventResponse = searchOfcLvl(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1074Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // 
				eventResponse = searchBkgSurplusAreaService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesEqr1012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // 
				eventResponse = searchPortSurplusAreaService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { // Sub-Conti 
				eventResponse = searchSubcontiListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // MANUAL 
				eventResponse = managePortSurplusAreaService(e);
			} else {
				eventResponse = searchOfcLvl(e);
			}
		}
		return eventResponse;
	}


	/**
     * EES_EQR_1007Event <br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchEQCOrgChartList(Event e) throws EventException {
        // DB Result Set
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
     * EES_EQR_1007Event <br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse multiEqrCtrlFcastLocService(Event e) throws EventException {

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
	 * EES_EQR_1001 <br>
	 * OPMG Forecast Input data <br>
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
		
		// if LCC QTY not input, false SAVE button / GRID 
		//String saveFlag = command.checkMtyBalanceLCCSave(event.getMtyBalanceOptionVO()); 
		
		// OP/MG FCST - OP/MG/RO/OTHER 
		String saveFlag = command.checkMtyBalanceSaveAvailable(event.getMtyBalanceOptionVO(), account); 
		
		eventResponse.setETCData(etcData);
		eventResponse.setRsVoList(list);
		eventResponse.setETCData("save_flag", saveFlag);
		
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1001 <br>
	 * OPMG Forecast Input data<br>
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
	 * EES_EQR_1001 - Supply & Demand<br>
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
	 * EES_EQR_1001<br>
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
	 * EES_EQR_1001 : OP Forecast, MG Forecast - Log<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyBalanceListLog(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1043Event event = (EesEqr1043Event)e;
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		
		// Repo Plan ID 
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
	 * EES_EQR_1001 : OPMG Forecast - Reference 2 <br>
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
	 * EES_EQR_1046,EES_EQR_1045 : EQ Demand & Supply<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyBalanceOtherList(Event e,String searchFlag) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		List<MtyBalRptOtrVO> list = null;
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
		if(list != null) {
			eventResponse.setRsVoList(list);
		}
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1046,EES_EQR_1045 : EQ Demand & Supply.<br>
	 * 
	 * @param Event e
	 * @param String searchFlag
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse manageMtyBalanceOther(Event e,String searchFlag) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1045Event event1 = null;
		EesEqr1046Event event2 = null;
		if ( searchFlag.equals("1045") ) {
			event1 = (EesEqr1045Event)e;
		} else if ( searchFlag.equals("1046") ) {
			event2 = (EesEqr1046Event)e;
		}
		MTYEquipmentForecastBC command = new MTYEquipmentForecastBCImpl();
		try{
			begin();
			if ( searchFlag.equals("1045") ) {
				if(event1 != null) {
					command.manageMtyBalanceOther(event1.getMtyBalRptOtrVOS(),account);
				}
			} else if ( searchFlag.equals("1046") ) {
				if(event2 != null) {
					command.manageMtyBalanceOther(event2.getMtyBalRptOtrVOS(),account);
				}
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
	 * EES_EQR_1044 : Execution Plan<br>
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
	 * EES_EQR_1062 : <br>
	 *  MTY Balance Report - In&Out Bound FCST Data's accruracy<br>
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
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse loadFileBackEndJobResultService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String key = (String)e.getAttribute("KEY");
		List list = null;

		try {
			if(e.getEventName().equalsIgnoreCase("EesEqr1062Event")) {
				list = (List<ForecastAccuracyListVO>)BackEndJobResult.loadFromFile(key);
			}
			
			if(list != null) {
				eventResponse.setRsVoList(list);
			}
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * EES_EQR_1047<br>
	 * EQR의 Execution Plan -  ECC MTY <br>
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
	 * EES_EQR_1047 <br>
	 * slan cd, from/to yard, etd, eta (by vvd) <br>
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
	 * EES_EQR_1047 <br>
	 * Check yard code's location validation
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
	 * EES_EQR_1062<br>
	 * Manage mty balance repo out volume
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
	 * EES_EQR_1003 <br>
	 * Search weekly simulation<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyWeeklySimulation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1003Event event = (EesEqr1003Event)e;
		ForecastReportBC command = new ForecastReportBCImpl();
		List<ForecastReportVO> list = command.searchMtyWeeklySimulation(event.getForecastReportOptionVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1003 <br>
	 * Search weekly simulation (cell origin value)<br>
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
	 * EES_EQR_1003 <br>
	 * Manage weekly simulation<br>
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
	 * EES_EQR_1003<br>
	 * Search current week<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrentWeek(Event e) throws EventException { 
		// PDTO(Data Transfer Object including Parameters)
		CommonBC common = new CommonBCImpl(); 
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
	 * EES_EQR_1003, 1002<br>
	 * Check location code within rcc area<br>
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
	 * EES_EQR_1002 <br>
	 * Search simulation report (past week)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyWeeklySimulationReport(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters) 
		EesEqr1002Event event = (EesEqr1002Event)e;
		ForecastReportBC command = new ForecastReportBCImpl();
		String rptTtl = command.searchMtyWeeklySimulationReportTitle(event.getForecastReportOptionVO());  // search report title
		CommonRsVO commonRsVO = command.searchMtyWeeklySimulationReport(event.getForecastReportOptionVO(), rptTtl);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRs(commonRsVO.getDbRowset());
		eventResponse.setETCData("rpt_ttl", rptTtl);
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1048<br>
	 * Search reposition in list<br>
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
	 * EES_EQR_1048 <br> 
	 * Search slan cd, PORT, ETB (in reposition in detail)<br>
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
	 * EES_EQR_1048<br> 
	 * Search LOCATION,ETB DATE (in LCC/ECC/SCC)<br>
	 * 
	 * @param e 
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
	 * EES_EQR_1048<br>
	 * Search location (in LCC/ECC/SCC)<br>
	 * 
	 * @param e 
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
	 * EES_EQR_1048 <br>
	 * Search location date<br>
	 * 
	 * @param e 
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationDateList(Event e) throws EventException {

		String wk_st_dt = ((String)e.getAttribute("wk_st_dt")).replace("/", "");
		
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
	 * EES_EQR_1048 <br>
	 * Manage reposition in data by manual input<br>
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
	 * EES_EQR_1040<br>
	 * PLANNED REPO IN<br>
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
	 * EES_EQR_1040 <br>
	 * Manage repo in data <br>
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
	 * LCC/ECC/SCC - ETB DATE<br>
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
	 * EES_EQR_1040 <br>
	 * Search origin value of repo in
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
	 * EES_EQR_1040 <br>
	 * Check validation of yard 
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
	 * EES_EQR_1006 <br>
	 * Search on-hire status<br>
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
	 * EES_EQR_1006 <br>
	 * Manage on-hire status<br>
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
	 * RCC_CD, LCC_CD <br>
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
	 * EES_EQR_1040<br>
	 * Search on-hire plan & approval<br>
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
	 * EES_EQR_1040 <br>
	 * Manage on-hire plan & approval<br>
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
			eventResponse.setETCData("new_lse_pln_seq_str",newLsePlnSeqStr); 
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}		
	
	/**
	 * EES_EQR_1040 <br>
	 * Manage on-hire plan & approval Request<br>
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
			eventResponse.setETCData("new_lse_rqst_no_str",newLseRqstNoStr); 
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_EQR_1070 <br>
	 * Surplus Area <br>
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
	 * LOC Code  (RCC_CD )<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/ 
	private EventResponse checkRccCodeIs(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
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
	 * EES_EQR_1073<br>
	 * Surplus Area <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardSurplusAreaService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters) 
		EesEqr1073Event event = (EesEqr1073Event)e;
		SurplusAreaBC command = new SurplusAreaBCImpl();
		
		String authChk = command.checkYardSurplusAreaAuthBasic(account); 

		String rptTtl = command.searchCurrSevenWeeksBasic(); 
		String rptTtlArr[] = rptTtl.split(",");
		SurplusAreaConditionVO surplusAreaConditionVO = event.getSurplusAreaConditionVO();
		surplusAreaConditionVO.setFmYrwk(rptTtlArr[0]);                  
		surplusAreaConditionVO.setCurrYrwk(rptTtlArr[3]);                		
		surplusAreaConditionVO.setToYrwk(rptTtlArr[rptTtlArr.length-1]); 
		surplusAreaConditionVO.setOfcCd(JSPUtil.getNull(event.getSignOnUserAccount().getOfc_cd()));
		
		CommonRsVO commonRsVO = command.searchYardSurplusAreaBasic(surplusAreaConditionVO, rptTtl);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRs(commonRsVO.getDbRowset());
		eventResponse.setETCData("rpt_ttl", rptTtl);
		eventResponse.setETCData("auth_chk", authChk);
		return eventResponse;		
	}	

	/**
	 * EES_EQR_1073 <br>
	 * Surplus Area <br>
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
	 * EES_EQR_1074 <br>
	 * Surplus Area - Yard's BKG for OP Ref <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgSurplusAreaService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters) 
		EesEqr1074Event event = (EesEqr1074Event)e;
		SurplusAreaBC command = new SurplusAreaBCImpl();

		String rptTtl = command.searchCurrSevenWeeksBasic(); 
		String rptTtlArr[] = rptTtl.split(",");
		SurplusAreaConditionVO surplusAreaConditionVO = event.getSurplusAreaConditionVO();
		surplusAreaConditionVO.setFmYrwk(rptTtlArr[0]);                  
		surplusAreaConditionVO.setCurrYrwk(rptTtlArr[3]);                
		surplusAreaConditionVO.setToYrwk(rptTtlArr[rptTtlArr.length-1]); 

		
		CommonRsVO commonRsVO = command.searchBkgSurplusAreaBasic(surplusAreaConditionVO, rptTtl);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRs(commonRsVO.getDbRowset());
		eventResponse.setETCData("rpt_ttl", rptTtl);
		return eventResponse;		
	}		

	/**
	 * ofc level 
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
	 * EES_EQR_1012<br>
	 * Surplus Area - Port <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortSurplusAreaService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters) 
		EesEqr1012Event event = (EesEqr1012Event)e;
		SurplusAreaBC command = new SurplusAreaBCImpl();
		
		String authChk = "Y"; // All user gain authority (2014-04-02) 
		//String authChk = command.checkPortSurplusAreaAuthBasic(account); 
	
		String rptTtl = command.searchCurrSevenWeeksBasic(); 
		String rptTtlArr[] = rptTtl.split(",");
		PortSurplusAreaConditionVO portSurplusAreaConditionVO = event.getPortSurplusAreaConditionVO();
		portSurplusAreaConditionVO.setFmYrwk(rptTtlArr[0]);                  
		portSurplusAreaConditionVO.setCurrYrwk(rptTtlArr[3]);                
		portSurplusAreaConditionVO.setToYrwk(rptTtlArr[rptTtlArr.length-1]); 
		
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
	 * EES_EQR_1012 <br>
	 * Surplus Area - Port<br>
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
	 * Sub-Conti <br>
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
	 * EES_EQR_1003 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPlanAndApprovalCurrentWeek(Event e) throws EventException { 
		// PDTO(Data Transfer Object including Parameters)
		CommonBC common = new CommonBCImpl(); 
		//ForecastReportBC command = new ForecastReportBCImpl();
		CommonVO commonVO = null;
		
		String fcastYrwk = "";
		String levelCd   = "1";  // SETTING LEVEL =1
		
		commonVO = common.getCurrentWeek();
		fcastYrwk = commonVO.getResultString();
		//levelCd = command.checkMtyBalanceRepoOutYard(account.getOfc_cd());  // Because using HARD CODING 
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("fcast_yrwk", fcastYrwk);
		eventResponse.setETCData("level_cd", levelCd);
		
		return eventResponse;		
	}		
}