/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProfitabilitySimulationSC.java
*@FileTitle : Revenue Lane Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.29 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.basic.CMPBGuidelineBC;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.basic.CMPBGuidelineBCImpl;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.event.EsmPri6001Event;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.event.EsmPri6002Event;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.event.EsmPri6003Event;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.event.EsmPri6036Event;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.event.EsmPri6039Event;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.CmpbGuidelineVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltCmpbGuidelineReportVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltOriDestLocationVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltPriCmpbGlineServiceLaneVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltRepCmdtAndCmdtVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltRtListVerticalExcelVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.basic.CMSummaryBC;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.basic.CMSummaryBCImpl;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event.EsmPri6024Event;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event.EsmPri6025Event;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event.EsmPri6026Event;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event.EsmPri6027Event;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event.EsmPri6029Event;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event.EsmPri6031Event;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event.EsmPri6032Event;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event.EsmPri6052Event;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event.EsmPri6053Event;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event.EsmPri6054Event;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event.EsmPri6055Event;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration.CMSummaryDBDAO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentCmSummaryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentSummarySimulationVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsProposalCmSummaryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InRevenueLaneVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltCoaWkPrdVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPriCMSummaryCustomerListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsCheckRegionCodeVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsCmSummaryHistoryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.groupcommoditycmpbguideline.basic.GroupCommodityCMPBGuidelineBC;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.groupcommoditycmpbguideline.basic.GroupCommodityCMPBGuidelineBCImpl;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.groupcommoditycmpbguideline.event.EsmPri6041Event;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.groupcommoditycmpbguideline.vo.RsltPriCmpbGrpCmdtDtlVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.grouplocationcmpbguideline.basic.GroupLocationCMPBGuidelineBC;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.grouplocationcmpbguideline.basic.GroupLocationCMPBGuidelineBCImpl;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.grouplocationcmpbguideline.event.EsmPri6042Event;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.grouplocationcmpbguideline.vo.RsltPriCmpbGrpLocDtlVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.mqcrangecmpbguideline.basic.MqcRangeCMPBGuidelineBC;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.mqcrangecmpbguideline.basic.MqcRangeCMPBGuidelineBCImpl;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.mqcrangecmpbguideline.event.EsmPri6004Event;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComUpldFileVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineMnVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineMqcRngVO;
import com.hanjin.syscommon.common.table.PriCmpbGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriCmpbGrpLocVO;
import com.hanjin.syscommon.common.table.PriPrsBatVO;


/**
 * NIS2010-ProfitabilitySimulation Business Logic ServiceCommand - NIS2010-ProfitabilitySimulation 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Seung-Jun,Lee
 * @see CMSummaryDBDAO
 * @since J2EE 1.6
 */

public class ProfitabilitySimulationSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ProfitabilitySimulation system 업무 시나리오 선행작업<br>
	 * ESM_PRI_6055업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ProfitabilitySimulationSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ProfitabilitySimulation system 업무 시나리오 마감작업<br>
	 * ESM_PRI_6055 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ProfitabilitySimulationSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-ProfitabilitySimulation system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		//ESM_PRI_6055 Revenue Lane Code Inquiry start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6055Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRevenueLaneList(e);
			}
		}
		//ESM_PRI_6055 Revenue Lane Code Inquiry end
		//////////////////////////////////////////////////////////////////////////////////
		
		//ESM_PRI_6001 CMPB Guideline Creation start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6001Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCmpbGuidelineMain(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCmpbGuidelineRouteList(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCmpbGuidelineRateList(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchDurationCreationOfficeList(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchRateListVerticalExcel(e);
			}
			//all save
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageBaseCmpbGuideline(e);
			}
			//rate save
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageRateCmpbGuideline(e);
			}
			//all delete
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = removeCmpbGuideline(e);
			}
			//confirm
			else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = confirmCmpbGuideline(e);
			}
			//confirm calcel
			else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = confirmCancelCmpbGuideline(e);
			}
			//Main save
			else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
				eventResponse = manageMainCmpbGuideline(e);
			}
		}
		//ESM_PRI_6001 CMPB Guideline Creation end
		//////////////////////////////////////////////////////////////////////////////////
		
		//ESM_PRI_6039 CMPB Guideline- SVC Lane start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6039Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchServiceLaneList(e);
			}
		}
		//ESM_PRI_6039 CMPB Guideline- SVC Lane end
		//////////////////////////////////////////////////////////////////////////////////
		
		
		//CMPB Guideline Creation - Commodity Group start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6041Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCmpbGroupCommodityList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCmpbGroupCommodityDetailList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkGroupCommodityInUse(e);
			}
			//all save
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageGroupCommodityCmpbGuideline(e);
			}
			
		}
		//CMPB Guideline Creation - Commodity Group end
		//////////////////////////////////////////////////////////////////////////////////
		
		
		//CMPB Guideline Creation - Location Group start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6042Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCmpbGlineGroupLocationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCmpbGlineGroupLocationDetailList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkGroupLocationInUse(e);
			}
			//all save
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageGroupLocationCmpbGuideline(e);
			}
			
		}
		//CMPB Guideline Creation - Location Group end
		//////////////////////////////////////////////////////////////////////////////////
		
		
		//ESM_PRI_6004 CMPB Guideline- MQC Setting start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6004Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCmpbGlineMqcRangeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageMqcRangeCmpbGuideline(e);
			}
		}
		//ESM_PRI_6004 CMPB Guideline- MQC Setting end
		//////////////////////////////////////////////////////////////////////////////////
		
		
		//ESM_PRI_6036 CMPB Guideline Copy start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6036Event")) {
			//copy
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = copyCmpbGuideline(e);
			}
			
		}
		//ESM_PRI_6036 CMPB Guideline Copy end
		//////////////////////////////////////////////////////////////////////////////////


		
		//ESM_PRI_6003 CMPB Guideline Inquiry start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCmpbGuidelineReportList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchReportCreationOfficeList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { //commodity code가 존재 하는지 확인한다.
				eventResponse = searchCommodityList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { //origin 또는 dest code가 존재 하는지 확인한다.
				eventResponse = searchLocationList(e);
			}			
		}
		//ESM_PRI_6003 CMPB Guideline Inquiry end
		//////////////////////////////////////////////////////////////////////////////////
		
		
		//ESM_PRI_6024 
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchProposalCmSummaryList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = comBackEndJobVOs( e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = comBackEndJobSearchListGetResult( e);						
			}else{
				eventResponse = searchInitComboDataForProposalCmSummary(e);
			}
		}
		//ESM_PRI_6024   end
		//////////////////////////////////////////////////////////////////////////////////
		
		//ESM_PRI_6054 
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6054Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCmSummaryHistoryList(e);			
			}else{
				eventResponse = searchInitComboDataForCmSummaryHistory(e);
			}
		}
		//ESM_PRI_6054   end
		//////////////////////////////////////////////////////////////////////////////////
		
		
		
		//ESM_PRI_6026 
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6026Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAmendmentCmSummaryList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCoaWkPrdList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAmendmentCmSummaryExcelList(e);		
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = comBackEndJobVOs( e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = comBackEndJobSearchListGetResult( e);						
			}else{
				eventResponse = searchInitComboDataForAmendmentCmSummary(e);
			}
		}
		//ESM_PRI_6026   end
		//////////////////////////////////////////////////////////////////////////////////
		
		
		//ESM_PRI_6029 
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6029Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCustomerList (e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCustomerSelectedList (e);
			} 
		}
		//ESM_PRI_6029   end
		//////////////////////////////////////////////////////////////////////////////////
		
		//ESM_PRI_6032
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchProposalSummarySimulationList (e);
			}else if( e.getFormCommand().isCommand(FormCommand.SEARCH02) ){
				eventResponse = searchSummaryServiceScopeResionCode(e);
			}else{
				eventResponse = searchInitProposalSummarySimulation(e);
			}
		}
		//ESM_PRI_6032   end
		//////////////////////////////////////////////////////////////////////////////////
		
		//ESM_PRI_6031
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6031Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAmendmentSummarySimulationStart (e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = comBackEndJobVOs( e);
			}else if( e.getFormCommand().isCommand(FormCommand.SEARCH02) ){
				eventResponse = searchSummaryResionCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = comBackEndJobSearchListGetResult( e);				
			}else{
				eventResponse = searchInitAmendmentSummarySimulation(e);
			}
		}
		//ESM_PRI_6031   end
		//////////////////////////////////////////////////////////////////////////////////		
		
		//ESM_PRI_6052
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6052Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchProposalRevenueDetailList (e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = comBackEndJobVOs( e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = comBackEndJobSearchListGetResult( e);							
			}
		}
		//ESM_PRI_6052   end
		//////////////////////////////////////////////////////////////////////////////////
		//ESM_PRI_6053
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAmendmentRevenueDetailList (e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = comBackEndJobVOs( e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = comBackEndJobSearchListGetResult( e);							
			}
		}
		//ESM_PRI_6053   end
		//////////////////////////////////////////////////////////////////////////////////
		
		//ESM_PRI_6025
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6025Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchProposalChartList (e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = comBackEndJobVOs( e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = comBackEndJobSearchListGetResult( e);							
			}
		}
		//ESM_PRI_6025  end
		//////////////////////////////////////////////////////////////////////////////////
		//ESM_PRI_6027
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6027Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAmendmentChartList (e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = comBackEndJobVOs( e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = comBackEndJobSearchListGetResult( e);							
			}
		}
		//ESM_PRI_6027  end
		//////////////////////////////////////////////////////////////////////////////////
		
		//ESM_PRI_6002 CMPBGuideline Creation - Excel Import(Vertical) start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6002Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkRateExcelVertical(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = uploadRateExcelVertical(e);
			} else {
				eventResponse = initRateExcelVertical(e);
			}
		}
		//ESM_PRI_6002 CMPBGuideline Creation - Excel Import(Vertical) end
		//////////////////////////////////////////////////////////////////////////////////
 
        
		return eventResponse;
	}
	
	//ESM_PRI_6055 Revenue Lane Code Inquiry start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6055 :  Retrieve <BR>
	 * REV_LANE 의 코드, destription list를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRevenueLaneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6055Event event = (EsmPri6055Event)e;
		CMSummaryBC command = new CMSummaryBCImpl();

		try{
			List<InRevenueLaneVO> list = command.searchRevenueLaneList(event.getInRevenueLaneVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	//ESM_PRI_6055 Revenue Lane Code Inquiry end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	//ESM_PRI_6001 CMPB Guideline Creation start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6001 :  Retrieve <BR>
	 * CMPB Guideline Main을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCmpbGuidelineMain(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6001Event event = (EsmPri6001Event)e;
		CMPBGuidelineBC command = new CMPBGuidelineBCImpl();
		
		//컨테이너 vo
		CmpbGuidelineVO cmpbGuidelineVO = new CmpbGuidelineVO();

		try{
			cmpbGuidelineVO = command.searchCmpbGuidelineMain(event.getCmpbGuidelineVO().getRsltDurationCreationOfficeVO());
			eventResponse.setRsVoList(cmpbGuidelineVO.getRsltDurationCreationOfficeVOList());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6001 :  Retrieve <BR>
	 * CMPB Guideline Creation 메인 화면을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCmpbGuidelineRouteList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6001Event event = (EsmPri6001Event)e;
		CMPBGuidelineBC command = new CMPBGuidelineBCImpl();
		
		//컨테이너 vo
		CmpbGuidelineVO cmpbGuidelineVO = new CmpbGuidelineVO();

		try{
			cmpbGuidelineVO = command.searchCmpbGuidelineRouteList(event.getCmpbGuidelineVO().getPriCmpbGlineBseVO());
			eventResponse.setRsVoList(cmpbGuidelineVO.getRsltPriCmpbGlineBaseList());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6001 :  Retrieve <BR>
	 * CMPB Guideline Creation Rate 관련 정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCmpbGuidelineRateList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6001Event event = (EsmPri6001Event)e;
		CMPBGuidelineBC command = new CMPBGuidelineBCImpl();
		
		//컨테이너 vo
		CmpbGuidelineVO cmpbGuidelineVO = new CmpbGuidelineVO();

		try{
			cmpbGuidelineVO = command.searchCmpbGuidelineRateList(event.getCmpbGuidelineVO().getPriCmpbGlineBseVO());
			
			eventResponse.setRsVoList(cmpbGuidelineVO.getPriCmpbGlineAmtVOList());
			eventResponse.setRsVoList(cmpbGuidelineVO.getPriCmpbGlineSvcLaneVOList());
			eventResponse.setRsVoList(cmpbGuidelineVO.getPriCmpbGlineCmdtVOList());
			eventResponse.setRsVoList(cmpbGuidelineVO.getPriOrgCmpbGlineRoutPntVOList());
			eventResponse.setRsVoList(cmpbGuidelineVO.getPriOrgCmpbGlineRoutViaVOList());
			eventResponse.setRsVoList(cmpbGuidelineVO.getPriDestCmpbGlineRoutViaVOList());
			eventResponse.setRsVoList(cmpbGuidelineVO.getPriDestCmpbGlineRoutPntVOList());
			
			
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6001 :  Select SVC Scope Combo <BR>
	 * CMPB Guideline Creation 듀레이션 콤보 List를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDurationCreationOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6001Event event = (EsmPri6001Event)e;
		CMPBGuidelineBC command = new CMPBGuidelineBCImpl();

		//컨테이너 vo
		CmpbGuidelineVO cmpbGuidelineVO = new CmpbGuidelineVO();
		
		try{
			cmpbGuidelineVO = command.searchDurationCreationOfficeList(event.getCmpbGuidelineVO().getPriCmpbGlineBseVO());
			eventResponse.setRsVoList(cmpbGuidelineVO.getRsltDurationCreationOfficeVOList());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6001 :  Down Excel <BR>
	 * CMPB Guideline EXCEL DOWN(ESM_PRI_6001) 화면을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateListVerticalExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6001Event event = (EsmPri6001Event)e;
		CMPBGuidelineBC command = new CMPBGuidelineBCImpl();

		try{
			List<RsltRtListVerticalExcelVO> list = command.searchRateListVerticalExcel(event.getCmpbGuidelineVO().getRsltDurationCreationOfficeVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6001 :  Save <BR>
	 * CMPB Guideline Creation 메인 관련 정보를 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMainCmpbGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6001Event event = (EsmPri6001Event)e;
		CMPBGuidelineBC command = new CMPBGuidelineBCImpl();
		
		try{
			begin();
			command.manageMainCmpbGuideline(event.getCmpbGuidelineVO(),account);
//			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6001 :  Save <BR>
	 * CMPB Guideline Creation Route Base 관련 정보를 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBaseCmpbGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6001Event event = (EsmPri6001Event)e;
		CMPBGuidelineBC command = new CMPBGuidelineBCImpl();
		
		try{
			begin();
			command.manageBaseCmpbGuideline(event.getCmpbGuidelineVO(),account);
//			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_6001 :  Save <BR>
	 * CMPB Guideline Creation  RATE 관련 테이블 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRateCmpbGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6001Event event = (EsmPri6001Event)e;
		CMPBGuidelineBC command = new CMPBGuidelineBCImpl();
		
		try{
			begin();
			command.manageRateCmpbGuideline(event.getCmpbGuidelineVO(),account);
//			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_6001 :  Delete <BR>
	 * PRI_CMPB_GLINE 헤더 별 전체 삭제<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeCmpbGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6001Event event = (EsmPri6001Event)e;
		
		CMPBGuidelineBC command1 = new CMPBGuidelineBCImpl();
		GroupCommodityCMPBGuidelineBC command2 = new GroupCommodityCMPBGuidelineBCImpl();
		GroupLocationCMPBGuidelineBC  command3 = new GroupLocationCMPBGuidelineBCImpl();
		MqcRangeCMPBGuidelineBC  command4 = new MqcRangeCMPBGuidelineBCImpl();
		
		
		try{
			begin();
			command4.removeMqcRangeCmpbGuideline(event.getCmpbGuidelineVO().getPriCmpbGlineMnVO(),account);
			command3.removeGroupLocationCmpbGuideline(event.getCmpbGuidelineVO().getPriCmpbGlineMnVO(),account);
			command2.removeGroupCommodityCmpbGuideline(event.getCmpbGuidelineVO().getPriCmpbGlineMnVO(),account);
			command1.removeCmpbGuideline(event.getCmpbGuidelineVO().getPriCmpbGlineBseVO());
//			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_6001 :  Confirm <BR>
	 * 사용자가 Guideline을 컨폼한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmCmpbGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6001Event event = (EsmPri6001Event)e;
		CMPBGuidelineBC command = new CMPBGuidelineBCImpl();
		
		try{
			begin();
			command.confirmCmpbGuideline(event.getCmpbGuidelineVO().getPriCmpbGlineMnVO(),account);
//			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6001 :  Confirm Cancel <BR>
	 * 사용자가 Guideline을 컨폼 cancel한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmCancelCmpbGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6001Event event = (EsmPri6001Event)e;
		CMPBGuidelineBC command = new CMPBGuidelineBCImpl();
		
		try{
			begin();
			command.confirmCancelCmpbGuideline(event.getCmpbGuidelineVO().getPriCmpbGlineMnVO(),account);
//			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}
	//ESM_PRI_6001 CMPB Guideline Creation end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	//ESM_PRI_6039 Revenue Lane Code Inquiry start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6039 :  Retrieve <BR>
	 * CMPB Guideline- SVC Lane(ESM_PRI_6039) 을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceLaneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6039Event event = (EsmPri6039Event)e;
		CMPBGuidelineBC command = new CMPBGuidelineBCImpl();

		try{
			List<RsltPriCmpbGlineServiceLaneVO> list = command.searchServiceLaneList(event.getPriCmpbGlineBseVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }		
		return eventResponse;
	}
	//ESM_PRI_6039 Revenue Lane Code Inquiry end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	//ESM_PRI_6041 CMPB Guideline Creation - Commodity Group start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6041 :  Retrieve <BR>
	 * PRI_CMPB_GRP_CMDT 테이블을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCmpbGroupCommodityList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6041Event event = (EsmPri6041Event)e;
		GroupCommodityCMPBGuidelineBC command = new GroupCommodityCMPBGuidelineBCImpl();
		
		try{
			List<PriCmpbGrpCmdtVO> list = command.searchCmpbGroupCommodityList(event.getGroupCommodityCmpbGuidelineVO().getPriCmpbGrpCmdtVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6041 :  Retrieve <BR>
	 * PRI_CMPB_GRP_CMDT_DTL 테이블을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCmpbGroupCommodityDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6041Event event = (EsmPri6041Event)e;
		GroupCommodityCMPBGuidelineBC command = new GroupCommodityCMPBGuidelineBCImpl();
		
		try{
			List<RsltPriCmpbGrpCmdtDtlVO> list = command.searchCmpbGroupCommodityDetailList(event.getGroupCommodityCmpbGuidelineVO().getPriCmpbGrpCmdtVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6041 : Delete<br>
	 * Group cmdt 삭제시, Rate에서 사용하고 있는 코드인지 확인한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse checkGroupCommodityInUse(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri6041Event event = (EsmPri6041Event) e;
		GroupCommodityCMPBGuidelineBC command = new GroupCommodityCMPBGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<RsltCdListVO> vos = command.checkGroupCommodityInUse(event.getGroupCommodityCmpbGuidelineVO());
			eventResponse.setRsVoList(vos);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6041 :  Save <BR>
	 * PRI_CMPB_GRP_CMDT, PRI_CMPB_GRP_CMDT_DTL을 입력 수정 삭제한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGroupCommodityCmpbGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6041Event event = (EsmPri6041Event)e;
		GroupCommodityCMPBGuidelineBC command = new GroupCommodityCMPBGuidelineBCImpl();
		
		try{
			begin();
			command.manageGroupCommodityCmpbGuideline(event.getGroupCommodityCmpbGuidelineVO(),account);
//			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	//ESM_PRI_6041 CMPB Guideline Creation - Commodity Group end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	//ESM_PRI_6042 CMPB Guideline Creation - Location Group start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6042 :  Retrieve <BR>
	 * PRI_CMPB_GRP_LOC_DTL 테이블을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCmpbGlineGroupLocationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6042Event event = (EsmPri6042Event)e;
		GroupLocationCMPBGuidelineBC command = new GroupLocationCMPBGuidelineBCImpl();
		
		try{
			List<PriCmpbGrpLocVO> list = 
				command.searchCmpbGlineGroupLocationList(event.getGroupLocationCmpbGuidelineVO().getPriCmpbGrpLocVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6042 :  Retrieve <BR>
	 * PRI_CMPB_GRP_LOC_DTL 테이블을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCmpbGlineGroupLocationDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6042Event event = (EsmPri6042Event)e;
		GroupLocationCMPBGuidelineBC command = new GroupLocationCMPBGuidelineBCImpl();
		
		try{
			List<RsltPriCmpbGrpLocDtlVO> list = 
				command.searchCmpbGlineGroupLocationDetailList(event.getGroupLocationCmpbGuidelineVO().getPriCmpbGrpLocVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6042 : Delete<br>
	 * Group loc 삭제시, Rate에서 사용하고 있는 코드인지 확인한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse checkGroupLocationInUse(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri6042Event event = (EsmPri6042Event) e;
		GroupLocationCMPBGuidelineBC command = new GroupLocationCMPBGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<RsltCdListVO> vos = command.checkGroupLocationInUse(event.getGroupLocationCmpbGuidelineVO());
			eventResponse.setRsVoList(vos);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6042 :  Save <BR>
	 * PRI_CMPB_GRP_LOC, PRI_CMPB_GRP_LOC_DTL을 입력 수정 삭제한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGroupLocationCmpbGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6042Event event = (EsmPri6042Event)e;
		GroupLocationCMPBGuidelineBC command = new GroupLocationCMPBGuidelineBCImpl();
		
		try{
			begin();
			command.manageGroupLocationCmpbGuideline(event.getGroupLocationCmpbGuidelineVO(),account);
//			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	//ESM_PRI_6042 CMPB Guideline Creation - Location Group end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	
	//ESM_PRI_6004 CMPB Guideline- MQC Setting start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6004 :  Retrieve <BR>
	 * MQC RNG를 조회한다.(PRI_CMPB_GLINE_MQC_RNG)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCmpbGlineMqcRangeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6004Event event = (EsmPri6004Event)e;
		MqcRangeCMPBGuidelineBC command = new MqcRangeCMPBGuidelineBCImpl();
		
		try{
			List<PriCmpbGlineMqcRngVO> list = 
				command.searchCmpbGlineMqcRangeList(event.getPriCmpbGlineMqcRngVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6004 :  Save <BR>
	 * MQC RNG를 등록 수정 삭제 한다.(PRI_CMPB_GLINE_MQC_RNG)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMqcRangeCmpbGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6004Event event = (EsmPri6004Event)e;
		MqcRangeCMPBGuidelineBC command = new MqcRangeCMPBGuidelineBCImpl();
		
		try{
			begin();
			command.manageMqcRangeCmpbGuideline(event.getPriCmpbGlineMqcRngVOS(),account);
//			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	//ESM_PRI_6004 CMPB Guideline- MQC Setting end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	//ESM_PRI_6036 CMPB Guideline Copy start
	//////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * ESM_PRI_6036 :  OK <BR>
	 * 신규로 선택된 Guide Line을 copy하여 등록한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */ 
	private EventResponse copyCmpbGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6036Event event = (EsmPri6036Event)e;
		
		CMPBGuidelineBC 			  command1 = new CMPBGuidelineBCImpl();
		GroupCommodityCMPBGuidelineBC command2 = new GroupCommodityCMPBGuidelineBCImpl();
		GroupLocationCMPBGuidelineBC  command3 = new GroupLocationCMPBGuidelineBCImpl();
		MqcRangeCMPBGuidelineBC  command4 = new MqcRangeCMPBGuidelineBCImpl();
		
		int max_gline_seq = -1;
		
		try{
			begin();
			//max gline_seq search
			max_gline_seq = command1.searchCmpbGuidelineMaxGlineSeq(event.getPriCmpbGlineMnVO());
			
			//max gline seq를 세팅
			event.getRsltDurationCreationOfficeVO().setMaxGlineSeq(String.valueOf(max_gline_seq));
			
			command1.copyCmpbGuideline(event.getRsltDurationCreationOfficeVO(),account);
			command2.copyGroupCommodityCmpbGuideline(event.getRsltDurationCreationOfficeVO(),account);
			command3.copyGroupLocationCmpbGuideline(event.getRsltDurationCreationOfficeVO(),account);
			command4.copyMqcRangeCmpbGuideline(event.getRsltDurationCreationOfficeVO(),account);
			
//			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	//ESM_PRI_6042 CMPB Guideline Creation - Location Group end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	
	//////////////////////////////////////////////////////////////////////////////////
	// SP, RP, SQ, RQ에 대한 구현 시작
	
		
	// SP, RP, SQ, RQ에 대한 구현 끝
	//////////////////////////////////////////////////////////////////////////////////
	
	
	//ESM_PRI_6003 CMPB Guideline Inquiry start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6003 :  Retrieve <BR>
	 * CMPB Guideline Inquiry(ESM_PRI_6003)을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCmpbGuidelineReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6003Event event = (EsmPri6003Event)e;
		CMPBGuidelineBC command = new CMPBGuidelineBCImpl();
				
		try{
			List<RsltCmpbGuidelineReportVO> list = command.searchCmpbGuidelineReportList(event.getRsltCmpbGuidelineVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6003 :  Select SVC Scope Combo  <BR>
	 * CMPB Guideline Inquiry(ESM_PRI_6003) OFFICE COMBO LIST를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportCreationOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6003Event event = (EsmPri6003Event)e;
		CMPBGuidelineBC command = new CMPBGuidelineBCImpl();
				
		try{
			List<PriCmpbGlineMnVO> list = command.searchReportCreationOfficeList(event.getRsltCmpbGuidelineVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6003 :  Commodity deactivate  <BR>
	 * Commodity List를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommodityList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6003Event event = (EsmPri6003Event)e;
		CMPBGuidelineBC command = new CMPBGuidelineBCImpl();
				
		try{
			List<RsltRepCmdtAndCmdtVO> list = command.searchCommodityList(event.getRsltCmpbGuidelineVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }		
		return eventResponse;
	}	
	
	
	/**
	 * ESM_PRI_6003 :  Origin, Dest. deactivate  <BR>
	 *  Origin, Dest.  List를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6003Event event = (EsmPri6003Event)e;
		CMPBGuidelineBC command = new CMPBGuidelineBCImpl();
				
		try{

			List<RsltOriDestLocationVO> list = command.searchLocationList(event.getRsltCmpbGuidelineVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }		
		return eventResponse;
	}		
	
	//ESM_PRI_6003 CMPB Guideline Inquiry end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * ESM_PRI_6024 :  Retrieve <BR>
	 * CM/OP Summary & Simulation , Contract Proposal 리스트 를 조회 합니다.<br>
     * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalCmSummaryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6024Event event = (EsmPri6024Event)e;
		CMSummaryBC command = new CMSummaryBCImpl();
		try{
			String key = command.searchProposalCmSummaryList(event.getInPrsProposalCmSummaryVO(),account);

			eventResponse.setETCData("BackEndJobKey", key);
			
	    }catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }
		return eventResponse;
	}
	
	/**
     * ESM_PRI_6024 :  OnLoad  <BR>
     * 초기 Combo에 setting할 초기값를 조회 합니다.<br>
     * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInitComboDataForProposalCmSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();
		CMSummaryBC command2 = new CMSummaryBCImpl();
		RsltCdListVO rsltcdlistvo = new RsltCdListVO();
		List<RsltCdListVO> customData = null; 
		RsltCdListVO authData = null;
		try{
			// Service Scope Code List
			customData = command.searchServiceScopeCodeList(rsltcdlistvo);
			eventResponse.setCustomData("SvcScpCombo", customData);
			
			// Approval Office Code List ( IN 조건으로 8건만 가져온다. )
			customData = command.searchApprovalOfficeList(rsltcdlistvo);
			eventResponse.setCustomData("AppOfcCombo", customData);
	
			//Status
			rsltcdlistvo.setCd("CD02144");
			customData = command.searchComCodeList(rsltcdlistvo);
			eventResponse.setCustomData("StatusCombo", customData);
			// Profit View
			rsltcdlistvo.setCd("CD00939");
			customData = command.searchComCodeList(rsltcdlistvo);
			eventResponse.setCustomData("ProfitViewCombo", customData);
			// CM/OP
			rsltcdlistvo.setCd("CD00941");
			customData = command.searchComCodeList(rsltcdlistvo);
			eventResponse.setCustomData("CmOpCombo", customData);	
			
			// Summary Items
			rsltcdlistvo.setCd("CD02145");
			customData = command.searchComCodeList(rsltcdlistvo);
			eventResponse.setCustomData("SummaryItemsCombo", customData);			
			// Customer Type
			rsltcdlistvo.setCd("CD02085");
			customData = command.searchComCodeList(rsltcdlistvo);
			eventResponse.setCustomData("CustomerTypeCombo", customData);		
			//조회권한을 조회한다.
			authData = command2.searchAuthorizationOffice( e.getSignOnUserAccount());
			eventResponse.setCustomData("AuthData", authData);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		
		return eventResponse;
	}	
	
	

	
	/**
	 * ESM_PRI_6054 :  Retrieve <BR>
	 * CM/OP Summary & Simulation 의 Quotation, Proposal, Amendment의 CM값 History 를 조회 합니다..<br>
     * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCmSummaryHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6054Event event = (EsmPri6054Event)e;
		try{
			CMSummaryBC command = new CMSummaryBCImpl();
			List<RsltPrsCmSummaryHistoryVO> list = command.searchCmSummaryHistoryList(event.getInPrsProposalCmSummaryVO());
			eventResponse.setRsVoList(list);		
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	/**
     * ESM_PRI_6054 :  OnLoad  <BR>
     * 초기 Combo에 setting할 초기값를 조회 합니다.<br>
     * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInitComboDataForCmSummaryHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();
		CMSummaryBC command2 = new CMSummaryBCImpl();
		RsltCdListVO rsltcdlistvo = new RsltCdListVO();
		List<RsltCdListVO> customData = null; 
		RsltCdListVO authData = null;
		try{
			// Service Scope Code List
			customData = command.searchServiceScopeCodeList(rsltcdlistvo);

			eventResponse.setCustomData("SvcScpCombo", customData);
			
			// Approval Office Code List ( IN 조건으로 8건만 가져온다. )
			customData = command.searchApprovalOfficeList(rsltcdlistvo);
			eventResponse.setCustomData("AppOfcCombo", customData);
	
			//Status
			rsltcdlistvo.setCd("CD02144");
			customData = command.searchComCodeList(rsltcdlistvo);
			eventResponse.setCustomData("StatusCombo", customData);
			// Profit View
			rsltcdlistvo.setCd("CD00939");
			customData = command.searchComCodeList(rsltcdlistvo);
			eventResponse.setCustomData("ProfitViewCombo", customData);
			// CM/OP
			rsltcdlistvo.setCd("CD00941");
			customData = command.searchComCodeList(rsltcdlistvo);
			eventResponse.setCustomData("CmOpCombo", customData);	
			
			// Summary Items
			rsltcdlistvo.setCd("CD02145");
			customData = command.searchComCodeList(rsltcdlistvo);
			eventResponse.setCustomData("SummaryItemsCombo", customData);			
			// Customer Type
			rsltcdlistvo.setCd("CD02085");
			customData = command.searchComCodeList(rsltcdlistvo);
			eventResponse.setCustomData("CustomerTypeCombo", customData);		
			//조회권한을 조회한다.
			authData = command2.searchAuthorizationOffice( e.getSignOnUserAccount());
			eventResponse.setCustomData("AuthData", authData);
		
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}	
	

	/**
     * ESM_PRI_6026 :  Retrieve <BR>
	 * CM/OP Summary & Simulation , Contract Approval 리스트 를 조회 합니다.<br>
     * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAmendmentCmSummaryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6026Event event = (EsmPri6026Event)e;
		try{
			CMSummaryBC command = new CMSummaryBCImpl();
			

			String key = command.searchAmendmentCmSummaryList(event.getInPrsAmendmentCmSummaryVO(),account);
			eventResponse.setETCData("BackEndJobKey", key);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
     * ESM_PRI_6026 :  Down Excel <BR>
	 * CM/OP Summary & Simulation , Contract Approval Excel용 리스트 를 조회 합니다.<br>
     * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAmendmentCmSummaryExcelList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6026Event event = (EsmPri6026Event)e;
		try{
			CMSummaryBC command = new CMSummaryBCImpl();
		
			String key = command.searchAmendmentCmSummaryExcelList(event.getInPrsAmendmentCmSummaryDownExcelVO(),account);
			eventResponse.setETCData("BackEndJobKey", key);
			eventResponse.setETCData("excel_tp", event.getInPrsAmendmentCmSummaryDownExcelVO().getExcelTp());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}	
	/**
	 * ESM_PRI_6026 :  OnLoad <BR>
	 * 
	 * 화면에서 사용할 주차와 그 날짜를 조회 합니다..<br>
     * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCoaWkPrdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6026Event event = (EsmPri6026Event)e;
		CMSummaryBC command = new CMSummaryBCImpl();
		try{
			List<RsltCoaWkPrdVO> list = command.searchCoaWkPrdList(event.getInPrsAmendmentCmSummaryVO());
			eventResponse.setRsVoList(list);	
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	
	/**
     * ESM_PRI_6026 :  OnLoad  <BR>
     * 초기 Combo에 setting할 초기값를 조회 합니다.<br>
     * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInitComboDataForAmendmentCmSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PRICommonBC command = new PRICommonBCImpl();
		CMSummaryBC command2 = new CMSummaryBCImpl();
		RsltCdListVO rsltcdlistvo = new RsltCdListVO();
		List<RsltCdListVO> customData = null; 
		RsltCdListVO authData = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
			// Service Scope Code List
			customData = command.searchServiceScopeCodeList(rsltcdlistvo);
			
			eventResponse.setCustomData("SvcScpCombo", customData);
			
			// Approval Office Code List ( IN 조건으로 8건만 가져온다. )
			customData = command.searchApprovalOfficeList(rsltcdlistvo);
			eventResponse.setCustomData("AppOfcCombo", customData);
	
			//Status
			rsltcdlistvo.setCd("CD02144");
			customData = command.searchComCodeList(rsltcdlistvo);
			eventResponse.setCustomData("StatusCombo", customData);
			// Profit View
			rsltcdlistvo.setCd("CD00939");
			customData = command.searchComCodeList(rsltcdlistvo);
			eventResponse.setCustomData("ProfitViewCombo", customData);
			// CM/OP
			rsltcdlistvo.setCd("CD00941");
			customData = command.searchComCodeList(rsltcdlistvo);
			eventResponse.setCustomData("CmOpCombo", customData);	
			
			// Summary Items
			rsltcdlistvo.setCd("CD02145");
			customData = command.searchComCodeList(rsltcdlistvo);
			eventResponse.setCustomData("SummaryItemsCombo", customData);			
			// Customer Type
			rsltcdlistvo.setCd("CD02085");
			customData = command.searchComCodeList(rsltcdlistvo);
			eventResponse.setCustomData("CustomerTypeCombo", customData);
			
			// Trade Code List
			rsltcdlistvo.setEtc1("C");
			customData = command.searchTradeCodeList(rsltcdlistvo);
			eventResponse.setCustomData("TradeCodeCombo", customData);
			
			// Bound Code List
			rsltcdlistvo.setCd("CD00714");
			customData = command.searchComCodeList(rsltcdlistvo);
			eventResponse.setCustomData("BoundCodeCombo", customData);
			
			//오늘날짜.
			eventResponse.setCustomData("TodayData", DateTime.getShortDateString());
			
			
			//조회권한을 조회한다.
			authData = command2.searchAuthorizationOffice( e.getSignOnUserAccount());
			eventResponse.setCustomData("AuthData", authData);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		
		
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_6029 : Retrieve
	 * CM/OP Summary & Simulation Multi Customer 를 조회 합니다.<br>
     * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerList (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6029Event event = (EsmPri6029Event)e;
		CMSummaryBC command = new CMSummaryBCImpl();
		try{
			List<RsltPriCMSummaryCustomerListVO> list = command.searchCustomerList (event.getRsltPriCMSummaryCustomerListVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * ESM_PRI_6029 : Select Grid1
	 * 
	 * CM/OP Summary & Simulation Multi Customer에서 하나의 customer 선택시 그 group에 포함된 데이터 를 조회 합니다.<br>
     * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerSelectedList (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6029Event event = (EsmPri6029Event)e;
		CMSummaryBC command = new CMSummaryBCImpl();
		try{
			List<RsltPriCMSummaryCustomerListVO> list = command.searchCustomerSelectedList (event.getRsltPriCMSummaryCustomerListVO());
			eventResponse.setRsVoList(list);	
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
     * ESM_PRI_6032 :  Retrieve <BR>
     * CM/OP Summary & Simulation Proposal의 CM 값을 Simulation해 조회 합니다.<br>
     * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalSummarySimulationList (Event e) throws EventException {
		
		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6032Event event = (EsmPri6032Event)e;
		CMSummaryBC command = new CMSummaryBCImpl();
 
 
		try{
			begin();
			eventResponse.setETCData("BackEndJobKey", command.searchProposalSummarySimulationList (event.getInPrsProposalCmSummaryVO(),event.getInPrsProposalSummarySimulationSetVO(),account));
			commit();
        }catch(EventException ex){
        	rollback();
            throw ex;
        }catch(Exception ex){
        	rollback();
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
			
		return eventResponse;
	}
	
	/**
     * ESM_PRI_6032 :  OnLoad  <BR>
     * 초기 Combo에 setting할 초기값를 조회 합니다.<br>
     * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInitProposalSummarySimulation(Event e) throws EventException {
        EsmPri6032Event event = (EsmPri6032Event) e;
        
		PRICommonBC command = new PRICommonBCImpl();
 

		RsltCdListVO rsltcdlistvo = new RsltCdListVO();
 
		List<RsltCdListVO> customData = null; 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	 
		try{
			// Customer Type
			rsltcdlistvo.setCd("CD02085");
			customData = command.searchComCodeList(rsltcdlistvo);
			eventResponse.setCustomData("CustomerTypeCombo", customData);		
			
			
			
			// CD01706 GRI APPLICATION DIVISION CODE
			rsltcdlistvo = new RsltCdListVO();
			rsltcdlistvo.setCd("CD01706");
			customData = command.searchComCodeList(rsltcdlistvo);
			eventResponse.setCustomData("ApplicationCombo", customData);	
			 
			
			// Approval Office Code List ( IN 조건으로 8건만 가져온다. )
			customData = command.searchApprovalOfficeList(rsltcdlistvo);
			eventResponse.setCustomData("AppOfcCombo", customData);
	
			//Surcharge Code
			rsltcdlistvo = new RsltCdListVO();
			String svcScpCd = event.getInPrsProposalSummarySimulationVO().getSvcScpCd();
			rsltcdlistvo.setEtc1(svcScpCd);
			customData = command.searchPRSScopeChargeCodeList(rsltcdlistvo);
			eventResponse.setCustomData("ChgCdCombo", customData);	
			
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		
		return eventResponse;
		
	}	
	
	
	//////////////////////

	/**
     * ESM_PRI_6031 :  Retrieve <BR>
     * CM/OP Summary & Simulation 를 조회를 위해 BackEndJob을 실행 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAmendmentSummarySimulationStart(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6031Event event = (EsmPri6031Event)e;
		CMSummaryBC command = new CMSummaryBCImpl();
		try{
			begin();
			eventResponse.setETCData("BackEndJobKey", command.searchAmendmentSummarySimulationStart(event.getInPrsAmendmentCmSummaryVO(),event.getInPrsAmendmentSummarySimulationSetVO(),account));
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * BackEndJob : interval <br>
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse comBackEndJobVOs(Event e) throws EventException {
		String key = (String)e.getAttribute("KEY");
		String status = null;
		CMSummaryBC command = new CMSummaryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			status = command.comBackEndJobVOs(key);			
			eventResponse.setETCData("jb_sts_flg", status);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * BackEndJob : search <br>
	 * BackEndJob 결과 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse comBackEndJobSearchListGetResult(Event e) throws EventException {
		String key = (String)e.getAttribute("KEY");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<DBRowSet> rowSets = new ArrayList<DBRowSet>();
		try {
			rowSets.add((DBRowSet)BackEndJobResult.loadFromFile(key));
			//eventResponse.setETCData("RESULT",(String)BackEndJobResult.loadFromFile(key));
			eventResponse.setRsVoList(rowSets);		
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	
	/**
	 * ESM_PRI_6031 :  sheet changed <br>
	 * sheet의 route값이 변경 됐을때 정확한 값인지 체크 한다..<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSummaryResionCode(Event e) throws EventException {
		EsmPri6031Event event = (EsmPri6031Event)e;
		CMSummaryBC command = new CMSummaryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<RsltPrsCheckRegionCodeVO> vo = command.searchSummaryResionCode(event.getInPrsAmendmentCmSummaryVO());		
			if( vo != null && vo.size() > 0 ){
				eventResponse.setETCData("IS_SUCCESS", "T");
			}else{
				eventResponse.setETCData("IS_SUCCESS", "F");
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_6032 :  sheet changed <br>
	 * sheet의 route값이 변경 됐을때 정확한 값인지 체크 한다..<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSummaryServiceScopeResionCode(Event e) throws EventException {
		EsmPri6032Event event = (EsmPri6032Event)e;
//		CMSummaryBC command = new CMSummaryBCImpl();
		PRICommonBC comCommand = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
//			InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO = new InPrsAmendmentCmSummaryVO();
			RsltCdListVO rsltCdlistVo = new RsltCdListVO();
			InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO = event.getInPrsProposalCmSummaryVO();
 
			rsltCdlistVo.setEtc1(inPrsProposalCmSummaryVO.getLocTpCd());
			if( "C".equals(inPrsProposalCmSummaryVO.getLocTpCd()) ){
				rsltCdlistVo.setCd(inPrsProposalCmSummaryVO.getCntCd());
			}else{
				rsltCdlistVo.setCd(inPrsProposalCmSummaryVO.getRgnCd());
			}
			rsltCdlistVo.setSvcScpCd(inPrsProposalCmSummaryVO.getSvcScpCd());
			rsltCdlistVo.setEtc2(inPrsProposalCmSummaryVO.getOriDestCd());
			
			//Service Scope 에서 선택 가능한 origin or dest. 인지 확인한다.
			List<RsltCdListVO> comVO  = comCommand.searchCheckServiceScopeOriginDestRegionList(rsltCdlistVo);
			
			if( comVO != null && comVO.size() > 0 ){
				eventResponse.setETCData("IS_SCOPE_SUCCESS", "T");
				
//				inPrsAmendmentCmSummaryVO.setCntCd( inPrsProposalCmSummaryVO.getCntCd());
//				inPrsAmendmentCmSummaryVO.setRgnCd( inPrsProposalCmSummaryVO.getRgnCd());
//				List<RsltPrsCheckRegionCodeVO> vo = command.searchSummaryResionCode(inPrsAmendmentCmSummaryVO);	
//				
//				if( vo != null && vo.size() > 0 ){
//					eventResponse.setETCData("IS_SUCCESS", "T");
//				}else{
//					eventResponse.setETCData("IS_SUCCESS", "F");
//				}
			}else{
				eventResponse.setETCData("IS_SCOPE_SUCCESS", "F");
			}
			
			

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	
//	/////////////////////
//	/**
//     * ESM_PRI_6031 :  Retrieve <BR>
//     * CM/OP Summary & Simulation 를 조회 합니다.<br>
//     * 
//	 * @param e Event
//	 * @return response EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse searchAmendmentSummarySimulationList (Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EsmPri6031Event event = (EsmPri6031Event)e;
//		CMSummaryBC command = new CMSummaryBCImpl();
// 
//		try{
//			begin();
//			
//			List<RsltPrsAmendmentSummarySimulationListVO> list = command.searchAmendmentSummarySimulationList (event.getInPrsAmendmentCmSummaryVO(),event.getInPrsAmendmentSummarySimulationSetVO(),account);
//			 
//			eventResponse.setRsVoList(list);	
//			commit();
//        }catch(EventException ex){
//        	rollback();
//            throw ex;
//        }catch(Exception ex){
//        	rollback();
//            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
//        }
//			
//		return eventResponse;
//	}

	/**
     * ESM_PRI_6031 :  OnLoad  <BR>
     * 초기 Combo에 setting할 초기값를 조회 합니다.<br>
     * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInitAmendmentSummarySimulation(Event e) throws EventException {
        EsmPri6031Event event = (EsmPri6031Event) e;
        InPrsAmendmentSummarySimulationVO inVO = event.getInPrsAmendmentSummarySimulationVO();
        
		PRICommonBC command = new PRICommonBCImpl();
 

		RsltCdListVO rsltcdlistvo = new RsltCdListVO();
 
		List<RsltCdListVO> customData = null; 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	 
		try{
			// Customer Type
			rsltcdlistvo.setCd("CD02085");
			customData = command.searchComCodeList(rsltcdlistvo);
			eventResponse.setCustomData("CustomerTypeCombo", customData);		
			
			
			
			// CD01706 GRI APPLICATION DIVISION CODE
			rsltcdlistvo = new RsltCdListVO();
			rsltcdlistvo.setCd("CD01706");
			customData = command.searchComCodeList(rsltcdlistvo);
			eventResponse.setCustomData("ApplicationCombo", customData);	
			 
			
			// Approval Office Code List ( IN 조건으로 8건만 가져온다. )
			customData = command.searchApprovalOfficeList(rsltcdlistvo);
			eventResponse.setCustomData("AppOfcCombo", customData);
	
			//Surcharge Code
			rsltcdlistvo = new RsltCdListVO();
			customData = command.searchPRSScopeChargeCodeList(rsltcdlistvo);
			eventResponse.setCustomData("ChgCdCombo", customData);	
			
			String subTrdCd = inVO.getTrdCd();
			rsltcdlistvo = new RsltCdListVO();
			rsltcdlistvo.setEtc1(subTrdCd);
			customData = command.searchSubTrdCdList(rsltcdlistvo);
			eventResponse.setCustomData("SubTrdCdCombo", customData);	
			
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
			
		return eventResponse;
		
	}		
	
	
	
	/**
     * ESM_PRI_6052 :  OnLoad <BR>
     * CM/OP Summary & Simulation의 Revenue값의 Detail 정보 를 조회 합니다.<br>
     * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalRevenueDetailList (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6052Event event = (EsmPri6052Event)e;
		CMSummaryBC command = new CMSummaryBCImpl();
		try{
			String key = command.searchProposalRevenueDetailList (event.getInPrsProposalCmSummaryVO(),account);
			eventResponse.setETCData("BackEndJobKey", key);
			
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
     * ESM_PRI_6025 :  OnLoad <BR>
     *  CM/OP Summary & Simulation의 Chart 정보 를 조회 합니다.<br>
     * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalChartList (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6025Event event = (EsmPri6025Event)e;
		CMSummaryBC command = new CMSummaryBCImpl();
		try{
			begin();
			String key = command.searchProposalChartList (event.getInPrsProposalCmSummaryVO(),account);

			eventResponse.setETCData("BackEndJobKey", key);
			
			commit();
			//eventResponse.setRsVoList(list);	
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
     * ESM_PRI_6027 :  OnLoad,Retrieve <BR>
     *  CM/OP Summary & Simulation의 Chart 정보 를 조회 합니다.<br>
     * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAmendmentChartList (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6027Event event = (EsmPri6027Event)e;
		CMSummaryBC command = new CMSummaryBCImpl();
 
		try{
			
			String key =  command.searchAmendmentChartList (event.getInPrsAmendmentCmSummaryVO(),account);
			eventResponse.setETCData("BackEndJobKey", key);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
			
		return eventResponse;
	}	
	

	/**
     * ESM_PRI_6053 :  OnLoad <BR>
     * CM/OP Summary & Simulation의 Revenue값의 Detail 정보 를 조회 합니다.<br>
     * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAmendmentRevenueDetailList (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6053Event event = (EsmPri6053Event)e;
		CMSummaryBC command = new CMSummaryBCImpl();
 
		try{

			String key = command.searchAmendmentRevenueDetailList (event.getInPrsAmendmentCmSummaryVO(),account);
			eventResponse.setETCData("BackEndJobKey", key);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	//ESM_PRI_6002 CMPBGuideline Creation - Excel Import(Vertical) start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6002 :  Down Excel<BR>
	 * CMPB Guideline LOAD EXCEL(ESM_PRI_6001)을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRateExcelVertical(Event e) throws EventException {
        EsmPri6002Event event = (EsmPri6002Event) e;
        CMPBGuidelineBC command = new CMPBGuidelineBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
        	List<RsltCdListVO> vos = command.checkRateExcelVertical(event.getPriCmpbGlineBseVO(), event.getRsltRtListVerticalExcelVOS());
	        eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_6002 :  Save <BR>
     * CMPB Guideline LOAD EXCEL(ESM_PRI_6001)을 저장한다.<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse uploadRateExcelVertical(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmPri6002Event event = (EsmPri6002Event) e;
        CMPBGuidelineBC command = new CMPBGuidelineBCImpl();
      
        try {
            begin();
            command.uploadRateExcelVertical(event.getPriCmpbGlineBseVO(), event.getRsltRtListVerticalExcelVOS(), account);
//            eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
        return eventResponse;
    }
	
	/**
	 * ESM_PRI_6002 : Open<br>
	 * 엑셀 템플릿 다운 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse initRateExcelVertical(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			comUpldFileVO.setFileUpldNm("CMPBGuideline_Templet_V.xls");
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("TEMPLATE_KEY", fileKey);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
    //ESM_PRI_6002 CMPBGuideline Creation - Excel Import(Vertical) end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	
	 
}