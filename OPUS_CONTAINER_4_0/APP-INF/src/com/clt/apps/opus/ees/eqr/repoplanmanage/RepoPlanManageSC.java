/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoPlanManageSC.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.basic.CntrAccuracyTrendBC;
import com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.basic.CntrAccuracyTrendBCImpl;
import com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.event.EesEqr1025Event;
import com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1025ConditionVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBCImpl;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EqrCommonVO;
import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.basic.CntrRepoExecutionFeedbackExamineBC;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.basic.CntrRepoExecutionFeedbackExamineBCImpl;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.event.EesEqr0063Event;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.vo.EesEqr0063ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic.CntrRepoExecutionPlanEstablishBC;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic.CntrRepoExecutionPlanEstablishBCImpl;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0059Event;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0080Event;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0081Event;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0083Event;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0092Event;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0094Event;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0108Event;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0130Event;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0131Event;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0132Event;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EtsEqr0001Event;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration.CntrRepoExecutionPlanEstablishDBDAO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0080MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0083MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0094ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0131ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.ModifyFromTrsOffHireReturnVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.MtyBkgVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchBeforeCntrInfoVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchCheckCntrInfoVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchEqrOrganizationVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanBkgNoVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrInfoExcelVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrInfoVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrListVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanSplitCntrVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchInlandRouteVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchSendHistoryVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.basic.CntrRepoPlanManageBC;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.basic.CntrRepoPlanManageBCImpl;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.event.EesEqr0045Event;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.GetRepoPlanListVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrreporesult.basic.CntrRepoResultManageBC;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrreporesult.basic.CntrRepoResultManageBCImpl;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrreporesult.event.EesEqr0144Event;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrreporesult.vo.EmptyRepoResultOptionVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingCreateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.NewBkgSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.basic.GeneralBookingSplitCombineBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.basic.GeneralBookingSplitCombineBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBCImpl;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -RepoPlanManage Business Logic ServiceCommand - -handling business transaction RepoPlanManage
 * 
 * @author 
 * @see CntrRepoExecutionPlanEstablishDBDAO
 * @since J2EE 1.6
 */

public class RepoPlanManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * preceding process for biz scenario RepoPlanManage system 
	 * related objects creation<br>
	 */
	public void doStart() {
		log.debug("RepoPlanManageSC start");
		try {

			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * RepoPlanManage system biz scenario closing<br>
	 */
	public void doEnd() {
		log.debug("RepoPlanManageSC end");
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

		if (e.getEventName().equalsIgnoreCase("EesEqr0059Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {     
				eventResponse = configUserAuthLocation(e);						
				//eventResponse = searchMaxRepoPlanId(e);							
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {  
				eventResponse = configUserAuthLocation(e);						
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchTrunkVesselAndFeederCntrRepoPlan(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchLocYardInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	
				eventResponse = searchTrunkVesselAndFeederCntrRepoPlanBKGNO(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	
				eventResponse = searchTrunkVesselAndFeederCntrRepoPlanBKGNOInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {	
				eventResponse = searchToEta(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {	
				eventResponse = searchNowWeek(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		
				eventResponse = modifyTrunkVesselAndFeederCntrRepoPlan(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		
				eventResponse = createRepoBKG(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {		
				eventResponse = createRepoBKGSplit(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {		
				eventResponse = searchInlandRoute(e);
			}
		}
		
		
		
		if (e.getEventName().equalsIgnoreCase("EesEqr0069Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {      
				eventResponse = configUserAuthLocation(e);						
				//eventResponse = searchMaxRepoPlanId(e);							
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {  
				eventResponse = configUserAuthLocation(e);						
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchTrunkVesselAndFeederCntrRepoPlan(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchLocYardInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	
				eventResponse = searchTrunkVesselAndFeederCntrRepoPlanBKGNO(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	
				eventResponse = searchTrunkVesselAndFeederCntrRepoPlanBKGNOInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {	
				eventResponse = searchToEta(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {	
				eventResponse = searchNowWeek(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		
				eventResponse = modifyTrunkVesselAndFeederCntrRepoPlan(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		
				eventResponse = createRepoBKG(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {		
				eventResponse = createRepoBKGSplit(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {		
				eventResponse = searchInlandRoute(e);
			}
		}
		
		// Execution Perform AND Feedback
		if (e.getEventName().equalsIgnoreCase("EesEqr0063Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { 
				eventResponse = searchCntrRepoExecutionFeedback(e);					                 
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {  
				eventResponse = searchCntrRepoExecutionFeedbcakExamine(e);	
			}
		}
		
		// Inventory Container List [ EES_EQR_0094 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0094Event")) {	
	
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {  
				eventResponse = searchCntrRepoExecutionPlanCntrList(e);					                 
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {  
				eventResponse = searchCntrRepoExecutionPlanCntrInfo(e);	
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {  
				eventResponse = searchCntrRepoExecutionPlanCntrInfoExcel(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) { 
				//log.debug("SC START");
				eventResponse = searchCheckCntrInfo(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) { 
				eventResponse = searchBeforeCntrInfo(e);
			}
		}	
		//컨테이너 이송 실행 계획 조회/수정 Truck/Rail/Barge [ EES_EQR_0080 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0080Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchTruckAndRailAndBargeCntrRepoPlan(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyTruckAndRailAndBargeCntrRepoPlan(e);
			
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = soSendTruckAndRailAndBargeCntrRepoPlan(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = soCancelTruckAndRailAndBargeCntrRepoPlan(e);
			
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = createRepoBKG(e);	
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchTruckAndRailAndBargeVvdCntrRepoPlan(e);	
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchTruckAndRailAndBargeVvdCntrRepoPlan(e);	
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchTruckAndRailAndBargeVvdCntrDupRepoPlan(e);	
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = createRepoExePlan(e);	
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = createRepoPlanBKG(e);	
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI06)) {
				eventResponse = soSendCntrRepoExePlan(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI07)) {
				eventResponse = soCancelSendCntrRepoExePlan(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI08)) {
				eventResponse = deleteRepoExePlan(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchRepoExePlanList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				eventResponse = searchRepoExePlanTypeSizeList(e);
			}
		}		
		
		//On-Hire & Off-Hire [ EES_EQR_0081 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0081Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOnHireAndOffHireCntrRepoPlan(e);			
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyOnHireAndOffHireCntrRepoPlan(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = soSendOnHireAndOffHireCntrRepoPlan(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = soCancelOnHireAndOffHireCntrRepoPlan(e);
			}	
			
		}
		// COMBINE [ EES_EQR_0108 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0108Event")) {
			if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = modifyCombineExecution(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EesEqr0130Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {			
				eventResponse = searchCntrRepoExecutionPlanBkgNoInfo(e);					                 
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {	
				eventResponse = searchCntrRepoExecutionPlanSplitCntrList(e);					                 
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { 
				eventResponse = searchCntrRepoExecutionPlanSplitCntrList(e);					                 
			}	
		}
		
		// EQR Organization Chart [ EES_EQR_0139 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0139Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchEqrOrganizationChartCount();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchEqrOrganizationChart();
			}
		}
		
		// Send FAX or e-mail from 0059 [ EES_EQR_0131 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0131Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {   
				String send_mode = ((EesEqr0131Event)e).getEesEqr0131ConditionVO().getSendMode();
				if ( send_mode.equals("E")){	
					eventResponse = sendEmail(e);
				}
				else if( send_mode.equals("F")){	
					eventResponse = sendFax(e);
				}
				else if( send_mode.equals("A")){
					eventResponse = sendEmail(e);
					eventResponse = sendFax(e);
				}
			}	
			
		}
		// Seach Send History email / fax [ EES_EQR_0132 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0132Event")) {	
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { 
				eventResponse = searchSenderHistory(e);					                 
			}			
		}
		
		// SHUTTLE [ EES_EQR_0083 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0083Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchShuttleCntrRepoPlan(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyShuttleCntrRepoPlan(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = soSendShuttleCntrRepoPlan(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = soCancelShuttleCntrRepoPlan(e);
			}
			
		}
		// [ EES_EQR_0092 : Total ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0092Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchTotalCntrRepoPlan(e);					                 
			}
		}
	    // Empty Repo Result (EES_EQR_0144) 
        if (e.getEventName().equalsIgnoreCase("EesEqr0144Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchEmptyRepoResult(e);
			}
		}
        
		// 컨테이너 이송 계획 목록 조회
		if (e.getEventName().equalsIgnoreCase("EesEqr0045Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {			// Retrieve 버튼 클릭시
				eventResponse = searchRepoPlanDtInfo(e);
			}			
		}


		return eventResponse;
	}
	
	/**
	 * Row add버튼 클릭후 주차 계산처리<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchToEta(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr0059Event event = (EesEqr0059Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrRepoPlanManageBC command = new CntrRepoPlanManageBCImpl();
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		String strToEta = "";
		
		strToEta = command.searchToEta(conditionVO);
		
		eventResponse.setETCData("strToEta", strToEta);
		return eventResponse;		
	}
	
	
	/**
	 * 현재 주차 확인처리<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNowWeek(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr0059Event event = (EesEqr0059Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrRepoPlanManageBC command = new CntrRepoPlanManageBCImpl();
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		String strNowWeek = "";
		
		strNowWeek = command.searchNowWeek(conditionVO);
		
		eventResponse.setETCData("strNowWeek", strNowWeek);
		return eventResponse;		
	}
	
	/**
	 * 컨테이너 이송 계획 목록 조회 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchRepoPlanDtInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0045Event event = (EesEqr0045Event)e;
		CntrRepoPlanManageBC command = new CntrRepoPlanManageBCImpl();

		try{
			List<GetRepoPlanListVO> list = command.searchRepoPlanList(event.getEesEqr0045ConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}	
	
	/**
	 * [EES_EQR_0059 : ]<br>
	 * checking User authority, location
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse configUserAuthLocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0059Event event = (EesEqr0059Event)e;
		EesEqr0059ConditionVO conditionVO = new EesEqr0059ConditionVO();
		conditionVO = event.getEesEqr0059ConditionVO();
		CommonBCImpl commonImpl = new CommonBCImpl();
		
		String office_code = event.getSignOnUserAccount().getOfc_cd();
		String user_id     = event.getSignOnUserAccount().getUsr_id();
		
		String[] eqr_auth 		= new String[9];
		
		String user_level       	= null; // USER LEVEL 1, 2, 3, 4, 5
        String user_search_div  	= null; // ALL, RCC, LCC
        String user_modify_div  	= null; // ALL, RCC, LCC
        String user_search_location = null; // "", RCC, LCC
        String user_modify_location = null; // "", RCC, LCC
        
        String user_access          = null; // checking user access authority (TRUE - available, FALSE - unavailable)

		try{			
			eqr_auth[0] = Boolean.toString(event.getSignOnUserAccount().isUserAuth("EQR01"));
	        eqr_auth[1] = Boolean.toString(event.getSignOnUserAccount().isUserAuth("EQR02"));
	        eqr_auth[2] = Boolean.toString(event.getSignOnUserAccount().isUserAuth("EQR03"));
	        eqr_auth[3] = Boolean.toString(event.getSignOnUserAccount().isUserAuth("EQR04"));
	        eqr_auth[4] = Boolean.toString(event.getSignOnUserAccount().isUserAuth("EQR05"));
	        eqr_auth[5] = Boolean.toString(event.getSignOnUserAccount().isUserAuth("EQR06"));
	        eqr_auth[6] = Boolean.toString(event.getSignOnUserAccount().isUserAuth("EQR07"));
	        eqr_auth[7] = Boolean.toString(event.getSignOnUserAccount().isUserAuth("EQR08"));
	        
	        /*
	        EQR09          - only accessable Execution Plan 
	                       - authority about bkg / s/o cre for all location
	                       - for SENCO office user
	        */                
	        eqr_auth[8] = Boolean.toString(event.getSignOnUserAccount().isUserAuth("EQR09"));
	        
	        /*
	          EQR09        - only accessable Execution Plan 
	                       - authority about bkg / s/o cre for all location
	                       - for SENCO office user     * 
	         * eqr_auth[0]==true || eqr_auth[6]==true || eqr_auth[8]==true	----> LEVEL 1  retreive, modify  [all location retrieve, all location modify  ]
	         * eqr_auth[7]==true                         					----> LEVEL 2  retreive, modify  [the RCC retreive, the RCC modify ]
	         * eqr_auth[4]==true                         					----> LEVEL 3  retreive        [the RCC retreive ]
	         * eqr_auth[3]==true                         					----> LEVEL 4  retreive        [all location retreive  ]                                                                                                   
	         * eqr_auth[1]==true || eqr_auth[2]==true || eqr_auth[5]==true  ----> LEVEL 5  retreive, modify  [the RCC retreive, the LCC modify ]                                                                                                   
	         */	              
	        if(eqr_auth[0].equals("true") || eqr_auth[6].equals("true") || eqr_auth[8].equals("true") ) {
	        	user_level        		= "1";   
	        	user_search_div 		= "ALL"; // ALL
	        	user_search_location    = "";	 // ALL    
	        	user_modify_div 		= "ALL"; // ALL
	        	user_modify_location    = "ALL";	 // ALL

	        }else if(eqr_auth[7].equals("true")) {
	        	user_level        		= "2";   
	        	user_search_div 		= "RCC"; // RCC
	        	user_search_location    = commonImpl.getUserLocInfo(office_code, "R").getResultString();	// RCC of user's office code
	        	user_modify_div 		= "RCC"; // RCC
	        	user_modify_location    = commonImpl.getUserLocInfo(office_code, "R").getResultString();	// RCC of user's office code
	        	
	        }else if(eqr_auth[4].equals("true")) {
	        	user_level        		= "3";   
	        	user_search_div 		= "RCC"; // ALL
	        	user_search_location    = commonImpl.getUserLocInfo(office_code, "R").getResultString();	// RCC of user's office code
	        	user_modify_div 		= ""; // unavailable
	        	user_modify_location    = ""; // unavailable
	        }else if(eqr_auth[3].equals("true")) {
	        	user_level        		= "4";   
	        	user_search_div 		= "ALL"; // ALL
	        	user_search_location    = "";    // ALL
	        	user_modify_div 		= "";    // unavailable
	        	user_modify_location    = "";    // unavailable
	        }else {      // else user,  eqr_auth[1]==true || eqr_auth[2]==true || eqr_auth[5]==true
	        	user_level        		= "5";   
	        	user_search_div 		= "RCC"; // RCC
	        	user_search_location    = commonImpl.getUserLocInfo(office_code, "R").getResultString();	// RCC of user's office code 
	        	user_modify_div 		= "LCC"; // LCC
	        	user_modify_location    = commonImpl.getUserLocInfo(office_code, "L").getResultString();	// RCC of user's office code
			}
	        
	        user_access = commonImpl.checkFullAccessUser(user_id).getResultString();	// checking user has authority in 059,080,081,083
	        	        
	        conditionVO.setUserLevel(user_level);
	        conditionVO.setUserModifyDiv(user_modify_div);
	        conditionVO.setUserModifyLocation(user_modify_location);
	        conditionVO.setUserSearchDiv(user_search_div);
	        conditionVO.setUserSearchLocation(user_search_location);
	        conditionVO.setUserFullAccess(user_access);  // checking user aurthority to access
	        
	        event.setEesEqr0059ConditionVO(conditionVO);
	        
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * EES_EQR_0059 : []<br>
	 * retrieving for Max repo plan id<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*private EventResponse searchMaxRepoPlanId(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0059Event event = (EesEqr0059Event)e;
		CommonBCImpl commonImpl = new CommonBCImpl();
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		
		try{
			String[] result = commonImpl.searchMaxRepoPlanId().getResultStrArray();
			
			conditionVO.setYyyyww(result[0]);
			conditionVO.setSeq(result[1]);
			
			event.setEesEqr0059ConditionVO(conditionVO);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}*/
	
	/**
	 * EES_EQR_0059 : []<br>
	 * retrieving for Trunk vessel and feeder CNTR repo plan<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTrunkVesselAndFeederCntrRepoPlan(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0059Event event = (EesEqr0059Event)e;
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
		CommonBCImpl commonImpl = new CommonBCImpl();
		EesEqr0059ConditionVO conditionVO = new EesEqr0059ConditionVO();
		conditionVO = event.getEesEqr0059ConditionVO();
		List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();
		
		String userEcc	= "";
		String fromEcc	= "";
		String toEcc	= "";
		
		// 2 weeks can execute
		String repoPlnWeek = "";
		repoPlnWeek = conditionVO.getRepoPlnId().toString();
		repoPlnWeek = (!repoPlnWeek.equals("")) ? repoPlnWeek.substring(4,10) : "";
		String repoPlnNextWeek = "";

		try{
			// retrieving for USER ECC(very important) 
	        userEcc = getUserEccWhere(conditionVO.getUserLevel(), conditionVO.getUserSearchLocation());
	        
	        if(conditionVO.getFmtoat().equals("1")) {  // FM TO
				fromEcc = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEcc   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();
	        // Fm ETD, To ETA 
			} else if (conditionVO.getFmtoat().equals("3")){  //Fm ETD 
				fromEcc = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEcc   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();		
	        } else if (conditionVO.getFmtoat().equals("4")){  //To ETA
				fromEcc = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEcc   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();
	        } else {                               // AT
				fromEcc = commonImpl.convertECCInfoString(conditionVO.getAtstatus(), conditionVO.getAtlocation()).getResultString();
			}
	        
	        conditionVO.setUserEcc(userEcc);
	        conditionVO.setFromEcc(fromEcc);
	        conditionVO.setToEcc(toEcc);
	        
	        //20141013 Park Young Jin
			CommonRsVO commonRsVO = command.searchTrunkVesselAndFeederCntrRepoPlan(conditionVO, account);
			CommonRsVO resultVO = new CommonRsVO();
			resultVO.setConditionVO(conditionVO);
			resultVO.setDbRowset( commonRsVO.getDbRowset() );
			
			rsVoList.add(resultVO);
			eventResponse.setRsVoList(rsVoList);
			
			repoPlnNextWeek = commonImpl.getNextPrevWeek(repoPlnWeek, 1, "NEXT").getResultString();  // repoPlnWeek + 1
			
			//  repo plan week,  next week
			conditionVO.setRepoPlnWeek(repoPlnWeek);
			conditionVO.setRepoPlnNextWeek(repoPlnNextWeek);
			
			eventResponse.setETCData("t1_plnWeek", repoPlnWeek);
			eventResponse.setETCData("t1_plnNextWeek",repoPlnNextWeek);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * EES_EQR_0059 : []<br>
	 * retrieving for Bkg No., when adding VD
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTrunkVesselAndFeederCntrRepoPlanBKGNO(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0059Event event = (EesEqr0059Event)e;
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
		EesEqr0059ConditionVO conditionVO = new EesEqr0059ConditionVO();
		conditionVO = event.getEesEqr0059ConditionVO();
		
		List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();
		CommonRsVO commonRsVO = new CommonRsVO();
		
		String currentWeek	= "";
		String prevWeek		= "";
		
		try{
			CommonBCImpl commonImpl = new CommonBCImpl();

			currentWeek		= conditionVO.getRepoPlnWeek();
			
			//prevWeek = commonImpl.getNextPrevWeek(currentWeek, 9, "PREV");  // last 10th week
			//prevWeek = commonImpl.getNextPrevWeek(currentWeek, 14, "PREV");  // last 15th week
			prevWeek = commonImpl.getNextPrevWeek(currentWeek, 19, "PREV").getResultString();  // last 20th week
			
			conditionVO.setCurrentWeek(currentWeek);
			conditionVO.setPrevWeek(prevWeek);
			
			event.setEesEqr0059ConditionVO(conditionVO);
			
			commonRsVO	= command.searchTrunkVesselAndFeederCntrRepoPlanBKGNO(event.getEesEqr0059ConditionVO());
			CommonRsVO resultVO = new CommonRsVO();
			resultVO.setConditionVO(conditionVO);
			resultVO.setDbRowset( commonRsVO.getDbRowset() );
			
			rsVoList.add(resultVO);
			eventResponse.setRsVoList(rsVoList);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	
	/**
	 * EES_EQR_0059 : retrieve<br>
	 * retrieving<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRoute(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		EesEqr0059Event event = (EesEqr0059Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
		EesEqr0059ConditionVO conditionVO = new EesEqr0059ConditionVO();
		conditionVO = event.getEesEqr0059ConditionVO();
		try{		
			List<SearchInlandRouteVO> list = command.searchInlandRouteListBasic(event.getSearchInlandRouteVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}		
		return eventResponse;
	}
	
	
	
	/**
	 * EES_EQR_0059 : []<br>
	 * retrieving for Bkg No., when adding VD
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTrunkVesselAndFeederCntrRepoPlanBKGNOInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0059Event event = (EesEqr0059Event)e;
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
		EesEqr0059ConditionVO conditionVO = new EesEqr0059ConditionVO();
		conditionVO = event.getEesEqr0059ConditionVO();
		
		List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();
		CommonRsVO commonRsVO = new CommonRsVO();
		
		try{
			commonRsVO	= command.searchTrunkVesselAndFeederCntrRepoPlanBKGNOInfo(event.getEesEqr0059ConditionVO());
			CommonRsVO resultVO = new CommonRsVO();
			resultVO.setConditionVO(conditionVO);
			resultVO.setDbRowset( commonRsVO.getDbRowset() );
			
			rsVoList.add(resultVO);
			eventResponse.setRsVoList(rsVoList);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * [ EES_EQR_0059 & EES_EQR_0080 : MTY BKG Create ]<br>
	 * creating repo BKG
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createRepoBKG(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();

		BookingUtil bookingUtil = new BookingUtil();
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		CommonVO commonVO = new CommonVO();
		MtyBookingCreateVO mtyBookingCreateVO = new MtyBookingCreateVO();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		EesEqr0059ConditionVO eesEqr0059ConditionVO = null;
		
		String[] table_name = new String[1];
		String gubun	= null;
		
		if ( e.getEventName().equals("EesEqr0059Event") ) 		gubun = "V";	// Vessel
		else if ( e.getEventName().equals("EesEqr0080Event") )	gubun = "W";	// Water
		
		if(gubun != null) commonVO.setGubun(gubun);
		
		try {
			begin();
			
			if(gubun != null) {
				if ( gubun.equals("V") ){
					EesEqr0059Event event = (EesEqr0059Event)e;
					commonVO.setResultVo(event.getEesEqr0059MultiVOs());				
					command.modifyTrunkVesselAndFeederCntrRepoPlan((EesEqr0059MultiVO[]) commonVO.getResultVo(), account);
					table_name[0]	= "EQR_VSL_LODG_DCHG_EXE_PLN";
				} else if ( gubun.equals("W") ){
					EesEqr0080Event event = (EesEqr0080Event)e;
					commonVO.setResultVo(event.getEesEqr0080MultiVOS());
					eesEqr0059ConditionVO = event.getEesEqr0059ConditionVO();
					command.modifyTruckAndRailAndBargeCntrRepoPlan(eesEqr0059ConditionVO, (EesEqr0080MultiVO[]) commonVO.getResultVo(), account);
					table_name[0]	= "EQR_INLND_TRSP_EXE_PLN";
				}
			}
			
			// creating BKG NO logic start
			// 1. creating BKG No. 
			mtyBookingCreateVO = command.createRepoBKG(commonVO, account);    // setting BKG VO with BKG/DOC data
			BkgBlNoVO newBkgNoVO = bookingUtil.manageBkgNumberGeneration("BKG", account.getOfc_cd(), account.getUsr_id());

			String mtyBkgNo = newBkgNoVO.getBkgNo();

			if(mtyBkgNo == null || mtyBkgNo.equals("")) {
				throw new DAOException(new ErrorHandler("EQR10028", "bkg_no is empty").getMessage());
			} else {
				mtyBkgNo	= mtyBkgNo+"00";
			}
			
			bkgBlNoVO.setBkgNo(mtyBkgNo);
			bkgBlNoVO.setBlNo(mtyBkgNo);
			
			mtyBookingCreateVO.setBkgBlNoVO(bkgBlNoVO);
			
			// 2. creating Mty Booking Data 
			receiptBC.createMtyRepoBooking(mtyBookingCreateVO, account);
	
			// 3. creating Cntr, B/L Data of Mty Booking
			BLDocumentationBLBC blDocBC = new BLDocumentationBLBCImpl();
			blDocBC.createMtyRepoBlCntr(mtyBookingCreateVO, account);
	        
			// Booking Split
			MtyBkgVO mtyBkgVO = new MtyBkgVO();
			mtyBkgVO.setMtyBkgNo(mtyBkgNo);
			mtyBkgVO.setUsrId(account.getUsr_id());
			if(gubun != null) mtyBkgVO.setGubun(gubun);
			mtyBkgVO.setTableName(table_name);
			
			command.modifyMtyBkgNo(mtyBkgVO, commonVO);  // updating EQR BKG no with BKGDOC's
			
	        commit();
		} catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		if(gubun != null) {
			if ( gubun.equals("V") ){
				return this.searchTrunkVesselAndFeederCntrRepoPlan(e);
			} else if ( gubun.equals("W") ){
				// call retrieve logic after saving
				return this.searchTruckAndRailAndBargeCntrRepoPlan(e);
			}
		}
		return eventResponse;
	}
	/**
	 * [ EES_EQR_0059 : MTY BKG Split Create ]<br>
	 * creating BKG Split No. 
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createRepoBKGSplit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
		EesEqr0059Event event = (EesEqr0059Event)e;
		
		GeneralBookingSplitCombineBC generalBookingSplitCombineBC = new GeneralBookingSplitCombineBCImpl();
		GeneralBookingReceiptBC	generalBookingReceiptBC = new GeneralBookingReceiptBCImpl();
		BLDocumentationBLBC	bLDocumentationBLBC = new BLDocumentationBLBCImpl();
		
		try {
			begin();
			// use only first of MultiVO cause Split can be only one row(important)
			EesEqr0059MultiVO eesEqr0059MultiVO = ( (EesEqr0059MultiVO[]) event.getEesEqr0059MultiVOs() )[0];
			
			MtyBookingSplitVO mtyBookingSplitVO = new MtyBookingSplitVO();
			BkgBlNoVO orgBkgBlNoVO = new BkgBlNoVO();
			BkgBlNoVO splitBkgBlNoVO = new BkgBlNoVO();
			NewBkgSplitVO newBkgBlNoVO = new NewBkgSplitVO();
			
			
			// Setting Original Bkg No. 
			orgBkgBlNoVO.setBkgNo(eesEqr0059MultiVO.getMtyBkgNo());
			orgBkgBlNoVO.setBkgNo(eesEqr0059MultiVO.getMtyBkgNo());
			
			
			// ----- call BKG/DOC method start ------
			// retrieving for Split No. with Original Bkg No.
			splitBkgBlNoVO = generalBookingSplitCombineBC.searchMtySplitBkgNo(orgBkgBlNoVO, account);
			newBkgBlNoVO.setNewBkgNo(splitBkgBlNoVO.getBkgNo());
			newBkgBlNoVO.setNewBlNo(splitBkgBlNoVO.getBkgNo());
			
			eesEqr0059MultiVO.setOldBkgGrpNo(eesEqr0059MultiVO.getMtyBkgNo());
			eesEqr0059MultiVO.setMtyBkgNo(splitBkgBlNoVO.getBkgNo());
	
			mtyBookingSplitVO = command.createRepoBKGSplit(eesEqr0059MultiVO, account);  // setting VO to BKG/DOC data
			mtyBookingSplitVO.setBkgBlNoVO(orgBkgBlNoVO);
			mtyBookingSplitVO.setNewBkgSplitVO(newBkgBlNoVO);

			// Split Mty Booking
			generalBookingReceiptBC.splitMtyRepoBooking(mtyBookingSplitVO, account);
				
			// Split Cntr, B/L of Mty Booking
			bLDocumentationBLBC.splitMtyRepoBlCntr(mtyBookingSplitVO, account);
				
			// counting added Cntr quantity, in case of detaching all CNTR, cancel.
			generalBookingReceiptBC.completeMtyRepoBkgSplit(mtyBookingSplitVO, account);
			// ----- call BKG/DOC method end	---		
			
			// call EQR VOLUME EQR directly(important)
			// in other case, (BKG CREATE, VOLUME CHANGE are called by BKG/DOC)
			// modifying Orginal MTY BKG Volume
			MtyBkgVO mtyBkgVO = new MtyBkgVO();
			mtyBkgVO.setMtyBkgNo(orgBkgBlNoVO.getBkgNo());
			mtyBkgVO.setSplitFlg("N");
			mtyBkgVO.setUsrId(account.getUsr_id());
			mtyBkgVO.setEesEqr0059MultiVO(eesEqr0059MultiVO);
			
			// modifying OGR BKG VOLUME, FIXED PLAN VOLUME 
			command.modifyMtyBkgVolChange(mtyBkgVO);  

			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	

		//  call retrieve logic after saving
		return this.searchTrunkVesselAndFeederCntrRepoPlan(e);
	}
	
	/**
	 * [ EES_EQR_0059 : Save ]<br>
	 * saving trunk vessel and feeder cntr repo plan
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse modifyTrunkVesselAndFeederCntrRepoPlan(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
		EesEqr0059Event event = (EesEqr0059Event)e;
		
		try{
			begin();
			command.modifyTrunkVesselAndFeederCntrRepoPlan(event.getEesEqr0059MultiVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return this.searchTrunkVesselAndFeederCntrRepoPlan(event);
	}
	
	/**
	 * retrieving USER's ECC
	 * 
	 * @param user_level
	 * @param user_search_location
	 * @return String
	 * @exception EventException
	 */
	public String getUserEccWhere(String user_level, String user_search_location) throws EventException {
        String userEccWhere = "";
        
		try {			
			CommonBCImpl commonImpl = new CommonBCImpl();
	        /*
	         * eqr_auth[0]==true || eqr_auth[6]==true    ----> retrieve, modify  [retrieve all location ]
	         * eqr_auth[7]==true                         ----> retrieve, modify  [retrieve the RCC ]
	         * eqr_auth[4]==true                         ----> retrieve          [retrieve the RCC ]
	         * eqr_auth[3]==true                         ----> retrieve          [retrieve all location ]                                                                                                   
	         */	              
	        if(user_level.equals("1")) {
				userEccWhere = "";	  // retrieve all location       	

	        }else if(user_level.equals("2")) {
				userEccWhere = commonImpl.convertECCInfoString("R", user_search_location).getResultString();	  // retrieve the RCC
				
				// LOCATION CODE doesn't exist, the user can't retrieve any data
				if(userEccWhere==null || userEccWhere.equals("")) userEccWhere = "NOT EXIST LOCATION";			
	        	
	        }else if(user_level.equals("3")) {
				userEccWhere = commonImpl.convertECCInfoString("R", user_search_location).getResultString();  // retrieve the RCC
				
				// LOCATION CODE doesn't exist, the user can't retrieve any data
				if(userEccWhere==null || userEccWhere.equals("")) userEccWhere = "NOT EXIST LOCATION";			
	        	
	        }else if(user_level.equals("4")) {
				userEccWhere = "";	        	
	        	
	        }else {      //user_level.equals("5")
				userEccWhere = commonImpl.convertECCInfoString("R", user_search_location).getResultString();	  // retrieve the RCC
				// LOCATION CODE doesn't exist, the user can't retrieve any data
				if(userEccWhere==null || userEccWhere.equals("")) userEccWhere = "NOT EXIST LOCATION";			
				
	        }
	        
	        return userEccWhere;

		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
	}
	/**
	 * retrieving for repo execution and Feedback(Sheet1)<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchCntrRepoExecutionFeedback(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0063Event event = (EesEqr0063Event)e;
		CntrRepoExecutionFeedbackExamineBC command = new CntrRepoExecutionFeedbackExamineBCImpl();
		EesEqr0063ConditionVO conditionVO = event.getEesEqr0063ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try{
			CommonRsVO rsVO = command.searchCntrRepoExecutionFeedback(conditionVO);
			
			if (rsVO.getDbRowset().getRowCount() != 0) {
				rsVO.setResultString("Sheet1");
				returnVOList.add(rsVO);
			}
			
			eventResponse.setRsVoList(returnVOList);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * retrieving for repo execution and Feedback (Sheet2)<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchCntrRepoExecutionFeedbcakExamine(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0063Event event = (EesEqr0063Event)e;
		CntrRepoExecutionFeedbackExamineBC command = new CntrRepoExecutionFeedbackExamineBCImpl();
		EesEqr0063ConditionVO conditionVO = event.getEesEqr0063ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try{
			CommonRsVO rsVO = command.searchCntrRepoExecutionFeedbcakExamine(conditionVO);
			
			if (rsVO.getDbRowset().getRowCount() != 0) {
				rsVO.setResultString("Sheet2");
				returnVOList.add(rsVO);
			}
			
			eventResponse.setRsVoList(returnVOList);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * EES_EQR_094Event<br>
	 * retrieving for CNTR repo excecution plan CNTR list
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrRepoExecutionPlanCntrList(Event e) throws EventException {		
		EesEqr0094Event event = (EesEqr0094Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();           
		CommonBCImpl commonImpl = new CommonBCImpl();
		EesEqr0094ConditionVO conditionVO = event.getEesEqr0094ConditionVO();
		try {
			String location_code = commonImpl.getUserLocInfo(event.getSignOnUserAccount().getOfc_cd(), "L").getResultString();	
			conditionVO.setUserLcc(location_code);
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			List<SearchExecutionPlanCntrListVO> list = command.searchCntrRepoExecutionPlanCntrList(conditionVO);
			eventResponse.setRsVoList(list);
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * EES_EQR_094Event <br>
	 * retrieving for CNTR repo execution plan CNTR info
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrRepoExecutionPlanCntrInfo(Event e) throws EventException {		
		EesEqr0094Event event = (EesEqr0094Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();           
		CommonBCImpl commonImpl = new CommonBCImpl();
		EesEqr0094ConditionVO conditionVO = event.getEesEqr0094ConditionVO();
		try {
			String location_code = commonImpl.getUserLocInfo(event.getSignOnUserAccount().getOfc_cd(), "L").getResultString();	
			conditionVO.setUserLcc(location_code);
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			List<SearchExecutionPlanCntrInfoVO> list = command.searchCntrRepoExecutionPlanCntrInfo(conditionVO);
			List<CommonRsVO> retList = new ArrayList<CommonRsVO>();
			CommonRsVO commonRsVO = new CommonRsVO();
			commonRsVO.setResultVOList(list);
			commonRsVO.setConditionVO(conditionVO);
			retList.add(commonRsVO);
			eventResponse.setRsVoList(retList);
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * EES_EQR_094Event <br>
	 * retrieving for CNTR repo execution plan CNTR info excel
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrRepoExecutionPlanCntrInfoExcel(Event e) throws EventException {		
		EesEqr0094Event event = (EesEqr0094Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();           
		CommonBCImpl commonImpl = new CommonBCImpl();
		EesEqr0094ConditionVO conditionVO = event.getEesEqr0094ConditionVO();
		try {
			String location_code = commonImpl.getUserLocInfo(event.getSignOnUserAccount().getOfc_cd(), "L").getResultString();	
			conditionVO.setUserLcc(location_code);
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			List<SearchExecutionPlanCntrInfoExcelVO> list = command.searchCntrRepoExecutionPlanCntrInfoExcel(conditionVO);
			eventResponse.setRsVoList(list);
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * EES_EQR_094Event <br>
	 * retrieving for check CNTR info
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCheckCntrInfo(Event e) throws EventException {		
		EesEqr0094Event event = (EesEqr0094Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();           
		
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			List<SearchCheckCntrInfoVO> list = command.searchCheckCntrInfo(event.getEesEqr0094ConditionVO());
			eventResponse.setRsVoList(list);
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * EES_EQR_094Event <br>
	 * retrieving for before CNTR info
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBeforeCntrInfo(Event e) throws EventException {		
		EesEqr0094Event event = (EesEqr0094Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();           
		CommonBCImpl commonImpl = new CommonBCImpl();
		EesEqr0094ConditionVO conditionVO = event.getEesEqr0094ConditionVO();
		try {
			String location_code = commonImpl.getUserLocInfo(account.getOfc_cd(), "L").getResultString();	
			conditionVO.setUserLcc(location_code);
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			List<SearchBeforeCntrInfoVO> list = command.searchBeforeCntrInfo(conditionVO);
			eventResponse.setRsVoList(list);
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * EES_EQR_080Event <br>
	 * retrieving for truck and rail and barge CNTR repo plan
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTruckAndRailAndBargeCntrRepoPlan(Event e) throws EventException {		
		EesEqr0080Event event = (EesEqr0080Event)e;        // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();                  
		CommonRsVO rsVO = null;
		String fromEccWhere = "";
		String toEccWhere = "";
		String userEccWhere     = ""; 
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		// execute available 2 weeks
		String repoPlnWeek = conditionVO.getRepoPlnId();
		repoPlnWeek = repoPlnWeek.substring(4,10);
		String repoPlnNextWeek = "";
		try {
			
			CommonBCImpl commonImpl = new CommonBCImpl();

	        userEccWhere = getUserEccWhere(conditionVO.getUserLevel(), conditionVO.getUserSearchLocation());
	        conditionVO.setUserEcc(userEccWhere);
	        if(conditionVO.getFmtoat().equals("1")) {  // FM TO
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEccWhere   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();
				
				//Fm ETD, To ETA 
			}else if (conditionVO.getFmtoat().equals("3")){ //Fm ETD
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEccWhere   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();
			}else if (conditionVO.getFmtoat().equals("4")){ //To ETA
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEccWhere   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();

				
			}else {                               // AT
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getAtstatus(), conditionVO.getAtlocation()).getResultString();
			}
	        conditionVO.setFromEcc(fromEccWhere);
	        conditionVO.setToEcc(toEccWhere);
	        
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			rsVO = command.searchTruckAndRailAndBargeCntrRepoPlan(event.getEesEqr0059ConditionVO(),account);
			repoPlnNextWeek = commonImpl.getNextPrevWeek(repoPlnWeek, 1, "NEXT").getResultString();  // repoPlnWeek의 + 1 
			
			//eventResponse.setRs(commonRsVO.getDbRowset());
			List<CommonRsVO> retList = new ArrayList<CommonRsVO>();
			CommonRsVO commonRsVO = new CommonRsVO();
			commonRsVO.setDbRowset(rsVO.getDbRowset());
			commonRsVO.setConditionVO(conditionVO);
			retList.add(commonRsVO);
			eventResponse.setRsVoList(retList);
			eventResponse.setETCData("t2_plnWeek",repoPlnWeek);
			eventResponse.setETCData("t2_plnNextWeek",repoPlnNextWeek);
			
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * EES_EQR_080Event <br>
	 * VVD , From Yard, To yARD 체크
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTruckAndRailAndBargeVvdCntrRepoPlan(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();       
		EesEqr0080Event event = (EesEqr0080Event) e;  // PDTO(Data Transfer Object including Parameters)
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();		
			String dataYN = command.searchCheckVvdLocationInfo( conditionVO, event.getEesEqr0080MultiVOS(), account);
				
			eventResponse.setETCData("dataYN",dataYN);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		//  call retrieve logic after saving
		return eventResponse;
	}
	
	
	/**
	 * EES_EQR_080Event <br>
	 * saving for truck and rail and barge CNTR repo plan
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyTruckAndRailAndBargeCntrRepoPlan(Event e) throws EventException {
		EesEqr0080Event event = (EesEqr0080Event) e;  // PDTO(Data Transfer Object including Parameters)
		String tpszInitial = "";
		String tpszDefault = "";
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();			
			CommonBCImpl commonImpl = new CommonBCImpl();
			tpszInitial = commonImpl.getTpszInitial().getResultString();
			tpszDefault = commonImpl.getTpszDefault().getResultString();
			conditionVO.setTpszInitial(tpszInitial);
			conditionVO.setTpszDefault(tpszDefault);
			begin();
			command.modifyTruckAndRailAndBargeCntrRepoPlan(conditionVO,event.getEesEqr0080MultiVOS(),account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		//  call retrieve logic after saving
		return this.searchTruckAndRailAndBargeCntrRepoPlan(event);
	}

	/**
	 * EES_EQR_080Event <br>
	 * sending truck and rail and barge CNTR repo plan
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse soSendTruckAndRailAndBargeCntrRepoPlan(Event e) throws EventException {

		EesEqr0080Event event = (EesEqr0080Event) e;  // PDTO(Data Transfer Object including Parameters)
		String tpszInitial = "";
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			conditionVO.setTpszInitial(tpszInitial);
			begin();

			command.modifyTruckAndRailAndBargeCntrRepoPlan(conditionVO,event.getEesEqr0080MultiVOS(),account);
			
			command.soSendTruckAndRailAndBargeCntrRepoPlan(conditionVO,event.getEesEqr0080MultiVOS(),account);  // EAI SEND
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		//  call retrieve logic after saving
		return this.searchTruckAndRailAndBargeCntrRepoPlan(event);
	}	

	/**
	 * EES_EQR_080Event <br>
	 * canceling sending truck and rail and barge CNTR repo plan
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse soCancelTruckAndRailAndBargeCntrRepoPlan(Event e) throws EventException {

		EesEqr0080Event event = (EesEqr0080Event) e;  // PDTO(Data Transfer Object including Parameters)
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			
			begin();
			command.modifyTruckAndRailAndBargeCntrRepoPlan(conditionVO,event.getEesEqr0080MultiVOS(),account);

			// -- START --		
			command.soCancelTruckAndRailAndBargeCntrRepoPlan(conditionVO,event.getEesEqr0080MultiVOS(),account);  // EAI
			// -- END --
			
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		// call retrieve logic after saving
		return this.searchTruckAndRailAndBargeCntrRepoPlan(event);
	}		
	/**
	 * EES_EQR_108Event <br>
	 * saving combin execution
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyCombineExecution(Event e) throws EventException {

		EesEqr0108Event event = (EesEqr0108Event) e;  // PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 			
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			
			begin();
			command.modifyCombineExecution(event.getConditionVO() , event.getEesEqr0108MultiVOS() , account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}
	
	/**
	 * EES_EQR_0130 : []<br>
	 * retrieving for CNTR repo exection plan bkg no. info.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrRepoExecutionPlanBkgNoInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0130Event event = (EesEqr0130Event)e;
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
		
		SearchExecutionPlanBkgNoVO searchExecutionPlanBkgNoVO = null;
		String bkg_no = event.getConditionVO().getBkgNo();

		try{
			List<SearchExecutionPlanBkgNoVO> list = command.searchCntrRepoExecutionPlanBkgNoInfo(bkg_no);
			if ( list != null && !list.isEmpty()){
				searchExecutionPlanBkgNoVO = list.get(0);
			}
			if(searchExecutionPlanBkgNoVO != null) {
				event.setSearchExecutionPlanBkgNoVO(searchExecutionPlanBkgNoVO);
				eventResponse.setRsVo(searchExecutionPlanBkgNoVO);
			}
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * EES_EQR_0130 : []<br>
	 * retrieving for CNTR repo exection plan aplit CNTR list<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrRepoExecutionPlanSplitCntrList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0130Event event = (EesEqr0130Event)e;
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();

		try{
			List<SearchExecutionPlanSplitCntrVO> list = command.searchCntrRepoExecutionPlanSplitCntrList(event.getConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * [ EES_EQR_0139 : EQR Organization Chart - Default ]<br>
	 * retrieving for EQR Oragnization cart count
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqrOrganizationChartCount() throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();

		try{
			SearchEqrOrganizationVO rsVo = command.searchEqrOrganizationChartCount();
			eventResponse.setRsVo(rsVo);			
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * [ EES_EQR_0139 : EQR Organization Chart - List ]<br>
	 * retrieving for EQR organization chart
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqrOrganizationChart() throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();

		try{
			List<SearchEqrOrganizationVO> list = command.searchEqrOrganizationChart();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * EES_EQR_081Event<br>
	 * retrieving for on hire and off hire CNTR repo plan
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOnHireAndOffHireCntrRepoPlan(Event e) throws EventException {		
		EesEqr0081Event event = (EesEqr0081Event)e;        					// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();    
		String fromEccWhere = "";
		//String toEccWhere = "";
		String userEccWhere     = ""; 
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		CommonRsVO rsVO = null;
		// execute available 2 weeks
		String repoPlnWeek = conditionVO.getRepoPlnId();
		String repoPlnNextWeek = "";
		try {
			repoPlnWeek = repoPlnWeek.substring(4,10);
			
			CommonBCImpl commonImpl = new CommonBCImpl();

	        userEccWhere = getUserEccWhere(conditionVO.getUserLevel(), conditionVO.getUserSearchLocation());
	        if(conditionVO.getFmtoat().equals("1")) {  // FM TO TOECC
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				//toEccWhere   = commonImpl.convertECCInfoString(event.getToStatus(),   event.getToLocation());
				
			// Fm ETD, To ETA
			}else if (conditionVO.getFmtoat().equals("3")){  //Fm ETD 
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				
			}else if (conditionVO.getFmtoat().equals("4")){  //To ETA
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
			// CSR No: N200906040080 end
				
			}else {                               // AT 
				//fromEccWhere = commonImpl.convertECCInfoString(event.getAtStatus(), event.getAtLocation());
			}
	        conditionVO.setFromEcc(fromEccWhere);
	        conditionVO.setUserEcc(userEccWhere);
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			rsVO = command.searchOnHireAndOffHireCntrRepoPlan(conditionVO,account);
			
			List<CommonRsVO> retList = new ArrayList<CommonRsVO>();
			CommonRsVO commonRsVO = new CommonRsVO();
			commonRsVO.setDbRowset(rsVO.getDbRowset());
			commonRsVO.setConditionVO(conditionVO);
			retList.add(commonRsVO);
			eventResponse.setRsVoList(retList);
			
			repoPlnNextWeek = commonImpl.getNextPrevWeek(repoPlnWeek, 1, "NEXT").getResultString();  // repoPlnWeek + 1
			eventResponse.setETCData("t3_plnWeek",repoPlnWeek);
			eventResponse.setETCData("t3_plnNextWeek",repoPlnNextWeek);					
			
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	} 
	
	/**
	 * EES_EQR_081Event <br>
	 * saving for on hire and off hire CNTR repo plan
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOnHireAndOffHireCntrRepoPlan(Event e) throws EventException {

		EesEqr0081Event event = (EesEqr0081Event) e;  // PDTO(Data Transfer Object including Parameters)
		String tpszInitial = "";
		String tpszDefault = "";
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			// TPSZ INITIAL 
			CommonBCImpl commonImpl = new CommonBCImpl();
			tpszInitial = commonImpl.getTpszInitial().getResultString();
			tpszDefault = commonImpl.getTpszDefault().getResultString();
			conditionVO.setTpszInitial(tpszInitial);
			conditionVO.setTpszDefault(tpszDefault);
			begin();
			command.modifyOnHireAndOffHireCntrRepoPlan(conditionVO,event.getEesEqr0081MultiVOS(),account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		//  call retrieve logic after saving	
		return this.searchOnHireAndOffHireCntrRepoPlan(event);
	}			

	/**
	 * EES_EQR_081Event <br>
	 * sending on hire and off hire CNTR repo plan
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse soSendOnHireAndOffHireCntrRepoPlan(Event e) throws EventException {

		EesEqr0081Event event = (EesEqr0081Event) e;  // PDTO(Data Transfer Object including Parameters)
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			
			begin();
		
			conditionVO.setTpszInitial("");
			command.modifyOnHireAndOffHireCntrRepoPlan(conditionVO,event.getEesEqr0081MultiVOS(),account);
			command.soSendOnHireAndOffHireCntrRepoPlan(conditionVO,event.getEesEqr0081MultiVOS(),account); 
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		//  call retrieve logic after saving
		return this.searchOnHireAndOffHireCntrRepoPlan(event);
	}				

	/**
	 * EES_EQR_081Event <br>
	 * Canceling sending on hire and off hire CNTR repo plan
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse soCancelOnHireAndOffHireCntrRepoPlan(Event e) throws EventException {

		EesEqr0081Event event = (EesEqr0081Event) e;  // PDTO(Data Transfer Object including Parameters)
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			
			begin();

			conditionVO.setTpszInitial("");
			command.modifyOnHireAndOffHireCntrRepoPlan(conditionVO,event.getEesEqr0081MultiVOS(),account);
			command.soCancelOnHireAndOffHireCntrRepoPlan(conditionVO,event.getEesEqr0081MultiVOS(),account);  // EQR_REPO_EXE_SO_IF
			// -- END --
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		//  call retrieve logic after saving	
		return this.searchOnHireAndOffHireCntrRepoPlan(event);
	}				

	/**
	 * EES_EQR_081Event <br>
	 * saving off hire return from ETS
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOffHireReturnFromETS(Event e) throws EventException {

		EtsEqr0001Event event = (EtsEqr0001Event) e;  // PDTO(Data Transfer Object including Parameters)
		ModifyFromTrsOffHireReturnVO offHireReturnModify = event.getModifyFromTrsOffHireReturnVO();
		ModifyFromTrsOffHireReturnVO retVal = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			
			begin();
			retVal = command.modifyFromTrsOffHireReturn(offHireReturnModify, account);
			eventResponse.setRsVo(retVal);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}				
	
	
	/**
	 * EES_EQR_131Event<br>
	 * sending email
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse sendEmail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0131Event event = (EesEqr0131Event) e;
		EesEqr0131ConditionVO conditionVO = event.getEesEqr0131ConditionVO();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			
			begin();
			command.sendEmail(conditionVO, account);
			eventResponse.setCustomData("sendMode", "email");
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * EES_EQR_131Event  <br>
	 * sending fax
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse sendFax(Event e) throws EventException {	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0131Event event = (EesEqr0131Event) e;
		EesEqr0131ConditionVO conditionVO = event.getEesEqr0131ConditionVO();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			
			begin();
			command.sendFax(conditionVO, account);
			eventResponse.setCustomData("sendMode", "fax");
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_EQR_132Event<br>
	 * retrieving for sender history
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSenderHistory(Event e) throws EventException {		
		EesEqr0132Event event = (EesEqr0132Event) e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();           
		List<SearchSendHistoryVO> list = null;
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			list = command.searchSenderHistory(event.getTarget() , event.getJobCd() , account.getUsr_id());
			eventResponse.setRsVoList(list);
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	

	/**
	 * EES_EQR_083Event<br>
	 * retrieving for shuttle CNTR repo plan
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchShuttleCntrRepoPlan(Event e) throws EventException {		
		EesEqr0083Event event = (EesEqr0083Event)e;        // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();                 
		CommonRsVO rsVO = null;
		String fromEccWhere = "";
		String toEccWhere = "";
		String userEccWhere     = ""; 
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		try {			
			CommonBCImpl commonImpl = new CommonBCImpl();

	        userEccWhere = getUserEccWhere(conditionVO.getUserLevel(), conditionVO.getUserSearchLocation());
			
			if(conditionVO.getFmtoat().equals("1")) {  // FM TO
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEccWhere   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();
				
//				 Fm ETD 
			}else if (conditionVO.getFmtoat().equals("3")){
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEccWhere   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();
            // To ETA 
			}else if (conditionVO.getFmtoat().equals("4")){
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEccWhere   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();
		    // end 	
				
			}else {                               // AT
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getAtstatus(), conditionVO.getAtlocation()).getResultString();
			}
			conditionVO.setFromEcc(fromEccWhere);
			conditionVO.setToEcc(toEccWhere);
			conditionVO.setUserEcc(userEccWhere);
			
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			rsVO = command.searchShuttleCntrRepoPlan(conditionVO, account);
			
			List<CommonRsVO> retList = new ArrayList<CommonRsVO>();
			CommonRsVO commonRsVO = new CommonRsVO();
			commonRsVO.setDbRowset(rsVO.getDbRowset());
			commonRsVO.setConditionVO(conditionVO);
			retList.add(commonRsVO);
			eventResponse.setRsVoList(retList);
			
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	} 

	/**
	 * EES_EQR_083Event <br>
	 * saving suttle CNTR repo plan
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyShuttleCntrRepoPlan(Event e) throws EventException {

		EesEqr0083Event event = (EesEqr0083Event)e;        // PDTO(Data Transfer Object including Parameters)		
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		EesEqr0083MultiVO[] vos = event.getEesEqr0083MultiVOS();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			
			begin();
			command.modifyShuttleCntrRepoPlan(conditionVO , vos , account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		//  call retrieve logic after saving	
		return this.searchShuttleCntrRepoPlan(event);
	}	

	/**
	 * EES_EQR_083Event <br>
	 * sending shuttle CNTR repo plan
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse soSendShuttleCntrRepoPlan(Event e) throws EventException {

		EesEqr0083Event event = (EesEqr0083Event) e;  // PDTO(Data Transfer Object including Parameters)
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		EesEqr0083MultiVO[] vos = event.getEesEqr0083MultiVOS();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			
			begin();
			
					
			//eventResponse = command.modifyShuttleCntrRepoPlan(event);  // EQR_ECC_INTER_EXE_PLN
			//eventResponse = command.soSendShuttleCntrRepoPlan(event);  // EQR_REPO_EXE_SO_IF 
			
			command.modifyShuttleCntrRepoPlan(conditionVO , vos , account);
			command.soSendShuttleCntrRepoPlan(conditionVO , vos , account);  // EAI 
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		//  call retrieve logic after saving
		//return eventResponse;
		return this.searchShuttleCntrRepoPlan(event);
	}			

	/**
	 * EES_EQR_083Event <br>
	 * canceling sending shuttle CNTR repo plan
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse soCancelShuttleCntrRepoPlan(Event e) throws EventException {

		EesEqr0083Event event = (EesEqr0083Event) e;  // PDTO(Data Transfer Object including Parameters)
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		EesEqr0083MultiVO[] vos = event.getEesEqr0083MultiVOS();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			
			begin();

			command.modifyShuttleCntrRepoPlan(conditionVO , vos , account);
			command.soCancelShuttleCntrRepoPlan(conditionVO , vos , account);  // EAI
			// -- END --
			
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		//  call retrieve logic after saving	
		return this.searchShuttleCntrRepoPlan(event);
	}
	/**
	 * EES_EQR_0092 : []<br>
	 * retrieving for tatal CNTR repo plan
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTotalCntrRepoPlan(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0092Event event = (EesEqr0092Event)e;
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
		CommonBCImpl commonImpl = new CommonBCImpl();
		List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();
		
		String userEcc	= "";
		String fromEcc	= "";
		String toEcc	= "";
		
		try{
			EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();			


	        userEcc = getUserEccWhere(conditionVO.getUserLevel(), conditionVO.getUserSearchLocation());
	        
	        if(conditionVO.getFmtoat().equals("1")) {  // FM TO
				fromEcc = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEcc   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();
			} else if (conditionVO.getFmtoat().equals("3")){  //Fm ETD 
				fromEcc = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEcc   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();		
	        } else if (conditionVO.getFmtoat().equals("4")){  //To ETA
				fromEcc = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEcc   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();
	        } else {                               // AT
				fromEcc = commonImpl.convertECCInfoString(conditionVO.getAtstatus(), conditionVO.getAtlocation()).getResultString();
			}
	        
	        conditionVO.setUserEcc(userEcc);
	        conditionVO.setFromEcc(fromEcc);
	        conditionVO.setToEcc(toEcc);
			
			CommonRsVO commonRsVO = command.searchTotalCntrRepoPlan(conditionVO);
			CommonRsVO resultVO = new CommonRsVO();
			resultVO.setConditionVO(conditionVO);
			resultVO.setDbRowset( commonRsVO.getDbRowset() );
			
			rsVoList.add(resultVO);
			eventResponse.setRsVoList(rsVoList);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
     * EES_EQR_0144Event <br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse searchEmptyRepoResult(Event e) throws EventException {

		EesEqr0144Event event = (EesEqr0144Event) e; 	// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 			
		EmptyRepoResultOptionVO emptyRepoResultOptionVO = event.getEmptyRepoResultOptionVO();
		try {
			
			
			CntrRepoResultManageBC  command = new CntrRepoResultManageBCImpl();
			CommonRsVO commonRsVO = command.searchEmptyRepoResult(emptyRepoResultOptionVO);
			eventResponse.setRs(commonRsVO.getDbRowset());
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * retrieving for LOC YARD <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchLocYardInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesEqr0059Event event = (EesEqr0059Event)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			retVO = command.searchLocYardInfo(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * EES_EQR_080Event <br>
	 * VVD , From Yard, To yARD 체크
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTruckAndRailAndBargeVvdCntrDupRepoPlan(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();       
		EesEqr0080Event event = (EesEqr0080Event) e;  // PDTO(Data Transfer Object including Parameters)
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();		
			String dataYN = command.searchDupCheckVvdLocationInfo( conditionVO, event.getEesEqr0080MultiVOS(), account);
				
			eventResponse.setETCData("dataYN",dataYN);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		//  call retrieve logic after saving
		return eventResponse;
	}
	
	
	/**
	 * [ EES_EQR_0059 & EES_EQR_0080 : MTY BKG Create ]<br>
	 * creating repo BKG
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createRepoExePlan(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();

		//BookingUtil bookingUtil = new BookingUtil();
		//GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		CommonVO commonVO = new CommonVO();
		//MtyBookingCreateVO mtyBookingCreateVO = new MtyBookingCreateVO();
		//BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		EesEqr0059ConditionVO eesEqr0059ConditionVO = null;
		
		String[] table_name = new String[1];
		String gubun	= null;
		
		//if ( e.getEventName().equals("EesEqr0059Event") ) 		gubun = "V";	// Vessel
		//else if ( e.getEventName().equals("EesEqr0080Event") )	gubun = "W";	// Water
		
		gubun = "W";
		if(gubun != null) commonVO.setGubun(gubun);
		
		try {
			begin();
			
			if(gubun != null) {
				EesEqr0080Event event = (EesEqr0080Event)e;
				commonVO.setResultVo(event.getEesEqr0080MultiVOS());
				eesEqr0059ConditionVO = event.getEesEqr0059ConditionVO();
				command.modifyCntrRepoExePlan(eesEqr0059ConditionVO, (EesEqr0080MultiVO[]) commonVO.getResultVo(), account);
				
			}
			
			// creating BKG NO logic start
			// 1. creating BKG No. 
			/*mtyBookingCreateVO = command.createRepoBKG(commonVO, account);    // setting BKG VO with BKG/DOC data
			BkgBlNoVO newBkgNoVO = bookingUtil.manageBkgNumberGeneration("BKG", account.getOfc_cd(), account.getUsr_id());

			String mtyBkgNo = newBkgNoVO.getBkgNo();

			if(mtyBkgNo == null || mtyBkgNo.equals("")) {
				throw new DAOException(new ErrorHandler("EQR10028", "bkg_no is empty").getMessage());
			} else {
				mtyBkgNo	= mtyBkgNo+"00";
			}
			
			bkgBlNoVO.setBkgNo(mtyBkgNo);
			bkgBlNoVO.setBlNo(mtyBkgNo);
			
			mtyBookingCreateVO.setBkgBlNoVO(bkgBlNoVO);*/
			
			// 2. creating Mty Booking Data 
			//receiptBC.createMtyRepoBooking(mtyBookingCreateVO, account);
	
			// 3. creating Cntr, B/L Data of Mty Booking
			//BLDocumentationBLBC blDocBC = new BLDocumentationBLBCImpl();
			//blDocBC.createMtyRepoBlCntr(mtyBookingCreateVO, account);
	        
			// Booking Split
			/*MtyBkgVO mtyBkgVO = new MtyBkgVO();
			mtyBkgVO.setMtyBkgNo(mtyBkgNo);
			mtyBkgVO.setUsrId(account.getUsr_id());
			if(gubun != null) mtyBkgVO.setGubun(gubun);
			mtyBkgVO.setTableName(table_name);
			
			command.modifyMtyBkgNo(mtyBkgVO, commonVO);  // updating EQR BKG no with BKGDOC's
*/			
	        commit();
		} catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		/*if(gubun != null) {
			if ( gubun.equals("V") ){
				return this.searchTrunkVesselAndFeederCntrRepoPlan(e);
			} else if ( gubun.equals("W") ){
				// call retrieve logic after saving
				return this.searchTruckAndRailAndBargeCntrRepoPlan(e);
			}
		}*/
		return eventResponse;
	}
	
	
	/**
	 *  조회 이벤트 처리<br>
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRepoExePlanTypeSizeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0080Event event = (EesEqr0080Event)e;        // PDTO(Data Transfer Object including Parameters)	   
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		try {
			
			String repoPlnId = event.getEesEqr0059ConditionVO().getYyyyww() + "_" + event.getEesEqr0059ConditionVO().getExectype() + 
								"_"+event.getEesEqr0059ConditionVO().getFmContiCd() + "_" + event.getEesEqr0059ConditionVO().getToContiCd() + 
								"_"+event.getEesEqr0059ConditionVO().getSeq();
			conditionVO.setRepoPlanId(repoPlnId);
			CommonBCImpl commonImpl = new CommonBCImpl();
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			List<EqrCommonVO> list = command.searchRepoExePlanTypeSizeList(conditionVO,account);
			StringBuffer typesize = new StringBuffer();
			
			if (list != null && list.size() > 0) {
				//insert blank in the select box
				
				for (int i = 0 ; i < list.size() ; i++) {
					typesize.append(list.get(i).getTypeSize());
					if (i < list.size() - 1) typesize.append("|");
				}
			}
			eventResponse.setETCData("repo_type_size", typesize.toString());
			
			
		} catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	
	/**
	 * [ EES_EQR_0059 & EES_EQR_0080 : MTY BKG Create ]<br>
	 * creating repo BKG
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createRepoPlanBKG(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
		BookingUtil bookingUtil = new BookingUtil();
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		CommonVO commonVO = new CommonVO();
		MtyBookingCreateVO mtyBookingCreateVO = new MtyBookingCreateVO();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		EesEqr0059ConditionVO eesEqr0059ConditionVO = null;
		
		String[] table_name = new String[1];
		String gubun	= null;
		
		gubun = "W";	// Water
		
		if(gubun != null) commonVO.setGubun(gubun);
		
		try {
			begin();
			
			
			EesEqr0080Event event = (EesEqr0080Event)e;
			commonVO.setResultVo(event.getEesEqr0080MultiVOS());
			eesEqr0059ConditionVO = event.getEesEqr0059ConditionVO();
			command.modifyCntrRepoExePlan(eesEqr0059ConditionVO, (EesEqr0080MultiVO[]) commonVO.getResultVo(), account);
			table_name[0]	= "EQR_REPO_EXE_PLN";
				
		    
			// creating BKG NO logic start
			// 1. creating BKG No. 
			mtyBookingCreateVO = command.createRepoBKG(commonVO, account);    // setting BKG VO with BKG/DOC data
			BkgBlNoVO newBkgNoVO = bookingUtil.manageBkgNumberGeneration("BKG", account.getOfc_cd(), account.getUsr_id());

			String mtyBkgNo = newBkgNoVO.getBkgNo();

			if(mtyBkgNo == null || mtyBkgNo.equals("")) {
				throw new DAOException(new ErrorHandler("EQR10028", "bkg_no is empty").getMessage());
			} else {
				mtyBkgNo	= mtyBkgNo+"00";
			}
			
			bkgBlNoVO.setBkgNo(mtyBkgNo);
			bkgBlNoVO.setBlNo(mtyBkgNo);
			
			mtyBookingCreateVO.setBkgBlNoVO(bkgBlNoVO);
			// 2. creating Mty Booking Data 
			receiptBC.createMtyRepoBooking(mtyBookingCreateVO, account);
			// 3. creating Cntr, B/L Data of Mty Booking
			BLDocumentationBLBC blDocBC = new BLDocumentationBLBCImpl();
			blDocBC.createMtyRepoBlCntr(mtyBookingCreateVO, account);
			// Booking Split
			MtyBkgVO mtyBkgVO = new MtyBkgVO();
			mtyBkgVO.setMtyBkgNo(mtyBkgNo);
			mtyBkgVO.setUsrId(account.getUsr_id());
			if(gubun != null) mtyBkgVO.setGubun(gubun);
			mtyBkgVO.setTableName(table_name);
			command.modifyMtyBkgNo(mtyBkgVO, commonVO);  // updating EQR BKG no with BKGDOC's
	        commit();
		} catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	
	/**
	 * EES_EQR_080Event <br>
	 * sending truck and rail and barge CNTR repo plan
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse soSendCntrRepoExePlan(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0080Event event = (EesEqr0080Event) e;  // PDTO(Data Transfer Object including Parameters)
		String tpszInitial = "";
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			conditionVO.setTpszInitial(tpszInitial);
			begin();

			//command.modifyTruckAndRailAndBargeCntrRepoPlan(conditionVO,event.getEesEqr0080MultiVOS(),account);
			command.modifyCntrRepoExePlan(conditionVO,event.getEesEqr0080MultiVOS(),account);
			command.soSendCntrRepoExePlan(conditionVO,event.getEesEqr0080MultiVOS(),account);  // EAI SEND
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
		//  call retrieve logic after saving
		//return this.searchRepoExePlanList(event);
	}	
	
	/**
	 * EES_EQR_080Event <br>
	 * canceling sending truck and rail and barge CNTR repo plan
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse soCancelSendCntrRepoExePlan(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0080Event event = (EesEqr0080Event) e;  // PDTO(Data Transfer Object including Parameters)
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			
			begin();
			command.modifyCntrRepoExePlan(conditionVO,event.getEesEqr0080MultiVOS(),account);

			// -- START --		
			command.soCancelSendCntrRepoExePlan(conditionVO,event.getEesEqr0080MultiVOS(),account);  // EAI
			// -- END --
			
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		// call retrieve logic after saving
		return eventResponse;
		//return this.searchRepoExePlanList(event);
	}		
	
	
	/**
	 * EES_EQR_0012Event Confirm 하기전 Repo Plan Id 삭제 <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	public EventResponse deleteRepoExePlan(Event e) throws EventException {
		EesEqr0080Event event = (EesEqr0080Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();

		try {
			begin();
			String delYN = command.deleteRepoExePlanId( event.getEesEqr0059ConditionVO(), account);
			commit();
			eventResponse.setETCData("delYN", delYN);

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 *  조회 이벤트 처리<br>
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unused")
	public EventResponse searchRepoExePlanList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0080Event event = (EesEqr0080Event)e;        // PDTO(Data Transfer Object including Parameters)	               
		CommonRsVO rsVO = null;
		String fromEccWhere = "";
		String toEccWhere = "";
		String userEccWhere     = ""; 
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		// execute available 2 weeks
		String repoPlnWeek = conditionVO.getRepoPlnId();
		repoPlnWeek = repoPlnWeek.substring(4,10);
		String repoPlnNextWeek = "";
		try {
			
			String repoPlnId = event.getEesEqr0059ConditionVO().getYyyyww() + "_" + event.getEesEqr0059ConditionVO().getExectype() + 
								"_"+event.getEesEqr0059ConditionVO().getFmContiCd() + "_" + event.getEesEqr0059ConditionVO().getToContiCd() + 
								"_"+event.getEesEqr0059ConditionVO().getSeq();
			conditionVO.setRepoPlanId(repoPlnId);
			CommonBCImpl commonImpl = new CommonBCImpl();
			

	        userEccWhere = getUserEccWhere(conditionVO.getUserLevel(), conditionVO.getUserSearchLocation());
	        conditionVO.setUserEcc(userEccWhere);
	        /*if(conditionVO.getFmtoat().equals("1")) {  // FM TO
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEccWhere   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();
				
				//Fm ETD, To ETA 
			}else if (conditionVO.getFmtoat().equals("3")){ //Fm ETD
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEccWhere   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();
			}else if (conditionVO.getFmtoat().equals("4")){ //To ETA
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEccWhere   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();

				
			}else {                               // AT
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getAtstatus(), conditionVO.getAtlocation()).getResultString();
			}
	        conditionVO.setFromEcc(fromEccWhere);
	        conditionVO.setToEcc(toEccWhere);
	        */
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			rsVO = command.searchRepoExePlanList(conditionVO,account);
			
			//rsVO = command.searchRepoExePlanList(event.getEesEqr0059ConditionVO(),account);
			//repoPlnNextWeek = commonImpl.getNextPrevWeek(repoPlnWeek, 1, "NEXT").getResultString();  // repoPlnWeek의 + 1 
			
			//eventResponse.setRs(commonRsVO.getDbRowset());
			List<CommonRsVO> retList = new ArrayList<CommonRsVO>();
			CommonRsVO commonRsVO = new CommonRsVO();
			commonRsVO.setDbRowset(rsVO.getDbRowset());
			commonRsVO.setConditionVO(conditionVO);
			retList.add(commonRsVO);
			eventResponse.setRsVoList(retList);
			
		} catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
}