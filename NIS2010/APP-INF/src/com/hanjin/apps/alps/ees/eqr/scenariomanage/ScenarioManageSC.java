/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioManageSC.java
*@FileTitle : Inquire Scenario ID List
*Open Issues :
*Change history :
* No.    Ver.     Modifier         modifier date   explanation
* 1      1.0      yongchan shin    2006-09-13      최초 생성
* 2      1.49     chae chang ho    2008-01-24      CSR No : N200801164892 - Booked 물량의 경우는 user 수정 가능하도록 Forecasted 물량은 수정 불가
* 3      1.51     chae chang ho    2008-11-12      CSR No : N200811110008 - User 가 Vessel SKD 업데이트 할 수 있도록 시스템 보완.
* 4      1.53     HaengJi, Lee     2009-04-22      CSR No - N200904200110 : VVD Add 추가기능으로 인해 SEARCH10에 해당하는 로직 추가
* 5		 2.0	  HaengJi, Lee	   2009.07.22                프레임워크 변경
*@LastModifyDate : 2009.07.22
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.07.22 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.basic.CommonBC;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.basic.CommonBCImpl;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.basic.CntrForecastManageBC;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.basic.CntrForecastManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.event.EesEqr0025Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.event.EesEqr0079Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.event.EesEqr0114Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.event.EesEqr0126Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.EesEqr0025ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.EesEqr0079ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.EesEqr0114ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.EesEqr0126ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.SearchEqrHolidayListVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.basic.CntrRepoPlanOptiExecuteBC;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.basic.CntrRepoPlanOptiExecuteBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.event.EesEqr0049Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.event.EesEqr0050Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.event.EesEqr0127Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.vo.CntrRepoPlanOptiExecuteRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.vo.EesEqr0049ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.basic.CntrSafetyStockManageBC;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.basic.CntrSafetyStockManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.event.EesEqr0026Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.vo.EesEqr0026ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.basic.EccInfoManageBC;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.basic.EccInfoManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.event.EesEqr0007Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.vo.EesEqr0007ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.vo.SearchEccInfoVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.vo.SearchEccTSTMLInfoVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.ecclinkinfomanage.basic.EccLinkInfoManageBC;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.ecclinkinfomanage.basic.EccLinkInfoManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.ecclinkinfomanage.event.EesEqr0009Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.ecclinkinfomanage.vo.EesEqr0009ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.ecclinkinfomanage.vo.SearchEccLinkInfoVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.basic.InputDataRlaExamineBC;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.basic.InputDataRlaExamineBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.event.EesEqr0003Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.vo.EesEqr0003ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.vo.InputDataRLAExamineRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.basic.LeaseInfoManageBC;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.basic.LeaseInfoManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.event.EesEqr0017Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.event.EesEqr0085Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.event.EesEqr0086Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.vo.EesEqr0017ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.vo.EesEqr0085ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.basic.OnhireDomesticNewvanScheduleInputBC;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.basic.OnhireDomesticNewvanScheduleInputBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.event.EesEqr0020Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.event.EesEqr0021Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.event.EesEqr0090Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.EesEqr0020ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.EesEqr0021ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.basic.RepoConstraintBC;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.basic.RepoConstraintBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.event.EesEqr0022Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.event.EesEqr0138Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.vo.EesEqr0138ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.basic.ScenarioManageBC;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.basic.ScenarioManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.event.EesEqr0002Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.event.EesEqr0111Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.integration.ScenarioManageDBDAO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.vo.SearchScenarioIDListVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.vo.SearchVesselScheduleInfoVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.basic.VslResidualSpaceManageBC;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.basic.VslResidualSpaceManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.event.EesEqr0014Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.event.EesEqr0060Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.EesEqr0014ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.EesEqr0060ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.SearchBSInfoVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.SearchBSPortInfoVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.SearchVslRsdlSpaceVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrScnrVslSkdVO;


/**
 * ALPS-ScenarioManage Business Logic ServiceCommand - ALPS-ScenarioManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Haeng-ji,Lee
 * @see ScenarioManageDBDAO
 * @since J2EE 1.6
 */

public class ScenarioManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ScenarioManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ScenarioManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ScenarioManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ScenarioManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-ScenarioManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesEqr0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){		// Retrieve
				eventResponse = searchScenarioIDList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {		// Copy
				eventResponse = createNewScenarioID(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {	// Delete
				eventResponse = removeScenarioID(e);
			}
		}
		
		// S/T On Hire 조회/수정
		if(e.getEventName().equalsIgnoreCase("EesEqr0017Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){		// Retrieve
				eventResponse = searchSTOnHireInfo(e);				
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){			// Save		
				eventResponse = modifySTOnHireinfo(e);
			}
		}
			
		// SCNR ECC 정보 조회/수정
		if (e.getEventName().equalsIgnoreCase("EesEqr0007Event")) {		
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {		// Retrieve 버튼 클릭시
				eventResponse = searchECCInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){	    // TS Column을 클릭시
				eventResponse = searchTSTMLInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {			// Save 버튼 클릭시
				eventResponse = modifyECCInfo(e);
			}
		}
		
		// SCNR ECC LINK 정보 조회/수정
		if (e.getEventName().equalsIgnoreCase("EesEqr0009Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {  // Retrieve 버튼 클릭시
				eventResponse = searchECCLinkInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) { // SAVE 버튼 클릭시
				eventResponse = modifyECCLinkInfo(e);
			} 		
		}
		
		// 연간신조 및 L/T 계획 조회 / 수정
		if (e.getEventName().equalsIgnoreCase("EesEqr0020Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)){	// Retrieve 버튼 클릭시 (상단 Sheet 조회)
				eventResponse = searchWeeklyNewvanPlan(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){	// Retrieve 버튼 클릭시 (하단 Sheet 조회)
				eventResponse = searchYearNewvanPlan(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){		// Save 버튼 클릭시
				eventResponse = modifyYearNewvanPlan(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)){	// RCC 조회
				eventResponse = codeLocsearch(e);
			}
		}
		
		// Us Domestic	    
		if (e.getEventName().equalsIgnoreCase("EesEqr0021Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {		// Retrieve 버튼 클릭시
				eventResponse = searchYearDomesticPlan(e);//
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {			// Share 버튼 클릭시 
				eventResponse = searchDomesticPerformance(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {	   // Save 버튼 클릭시
				eventResponse = modifyYearDomesticPlan(e);//
			}
		}
		
		// O/B Forecast
		if (e.getEventName().equalsIgnoreCase("EesEqr0025Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){
				eventResponse = searchCntrForecastInfo(e);
			}
			if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = modifyCntrForecastInfo(e);
			}
		}	
		
		// I/B Forecast
		if (e.getEventName().equalsIgnoreCase("EesEqr0079Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){
				eventResponse = searchCntrGeneration(e);
			}
			
			/*
	    	 *  CSRNO : N200801164892
	    	 *  CSR NAME : Split 01-EQ Forecast 
	    	 *  Change history : Booked 물량의 경우는 user 수정 가능하도록 Forecasted 물량은 수정 불가
	    	 *  LastModifier : chae chang ho
	    	 *  LastModifyDate : 2008.01.24
	    	 */
			if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = modifyCntrGeneration(e);
			}
		}
		
		//Constraint by Lane/ECC
		if (e.getEventName().equalsIgnoreCase("EesEqr0138Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {  // Retrieve 버튼 클릭시
				eventResponse = searchConstraintLaneEccInfo(e);

			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) { // SAVE 버튼 클릭시
				eventResponse = modifyConstraintLaneEccInfo(e);
				
			} 		
		}	
		
		// Trunk Vessel and Feeder
		if (e.getEventName().equalsIgnoreCase("EesEqr0003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchInputDataRLAList(e);
							
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyInputDataRLAList(e);
				
			}
		}
			
		if (e.getEventName().equalsIgnoreCase("EesEqr0049Event")) {
				eventResponse = searchScenarioList(e);
			if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = addRepoPlanID(e);
				}
		}
		
		if (e.getEventName().equalsIgnoreCase("EesEqr0050Event")) {
			eventResponse = searchMonitor(e);
		}	
		
		// LT Off-Hire [ EES_EQR_0086 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0086Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){
				eventResponse = searchLTOffHireInfo(e);
			}
			if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = modifyLTOffHireInfo(e);
				}
		}		
		// Vessel SKD
		if (e.getEventName().equalsIgnoreCase("EesEqr0111Event")) {
				
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {		// Retrieve 버튼 클릭시 
				eventResponse = searchVesselScheduleInfo(e);
			}			
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {	// Co,Lane,VVD 버튼 클릭시 
				eventResponse = searchVesselSchedulePortInfo(e);
			}
			//CSRNO : N200811110008 로 추가 		
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {	       // SKD이 변경되어 Save버튼 클릭시 
				eventResponse = modifyVesselSchedulePortInfo(e);
			}
			if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {	       // SKD이  NIS와  싱크 클릭시 
				eventResponse = modifyNisCurrentVesselSchedulePortInfo(e);
			}	
			//	CSRNO : N200811110008 로 끝	
			// CSR No : N200904200110, VVD Add기능추가 modified by Haeng-ji, Lee
			if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {	       // VVD ADD 
				eventResponse = modifyVesselSchedulePortInfoAdd(e);
			}
		}
		
		// Holiday Effect PopUp [ EES_EQR_0114 ]
		if(e.getEventName().equalsIgnoreCase("EesEqr0114Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){		// Retrieve
				eventResponse = searchHolidayEffectInfo(e);				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){		// Detail Button
				eventResponse = searchHolidayEffectDetailInfo(e);				
			}
		}
		
		// ST Off-Hire [ EES_EQR_0085 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0085Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){
				eventResponse = searchSTOffHireInfo(e);
		
			}
			if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = modifySTOffHireinfo(e);
			}
		}
		
		// Vessel R.Capa. [ EES_EQR_0060 ]
		if(e.getEventName().equalsIgnoreCase("EesEqr0060Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {  		// Retrieve 버튼 클릭시
				eventResponse = searchVslResidualSpaceManage(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) { 		// SAVE 버튼 클릭시
				eventResponse = modifyVslResidualSpaceManage(e); 	
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // Lane 체크
				eventResponse = searchVslResidualSpaceLaneInfo(e); 	
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // VVD 체크
				eventResponse = searchVslResidualSpaceVvdInfo(e); 	
			} 	else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) { // ECC 체크
				eventResponse = searchVslResidualSpaceEccInfo(e); 		
			} 
		}
		
		// Safty Stock [ EES_EQR_0026 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0026Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCntrSafetyStock(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchCntrSafetyStockQty(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiCntrSafetyStock(e);
			}
		}

		// Sublease out [ EES_EQR_0090 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0090Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {		// Retrieve 버튼 클릭시
				eventResponse = searchYearSubleasePlan(e);//
			} 
			
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {			// Share 버튼 클릭시 
				eventResponse = searchSubleasePerformance(e);
			}
			
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {	   // Save 버튼 클릭시
				eventResponse = modifyYearSubleasePlan(e);//
			}
		}

		// BSA [ EES_EQR_0014 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0014Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {  // Retrieve 버튼 클릭시
				eventResponse = searchBSInfo(e);

			}else if( e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {  // Retrieve 버튼 클릭시
				eventResponse = searchBSPortInfo(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)) { // SAVE 버튼 클릭시
				eventResponse = modifyBSAInfo(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) { // SAVE 버튼 클릭시
				eventResponse = modifyBSAPortInfo(e);
				
			} 		
		}
		// Turn Time popup [ EES_EQR_0126 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0126Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {  // Retrieve 버튼 클릭시
				eventResponse = searchCntrTurnTimeInfo(e);

			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) { // SAVE 버튼 클릭시
				eventResponse = modifyCntrTurnTimeInfo(e);
				
			} 		
		}	
		// Empty Repo Constraint [ EES_EQR_0022 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0022Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {  // Retrieve 버튼 클릭시
				eventResponse = searchEmptyRepoConstraintInfo(e);

			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) { // SAVE 버튼 클릭시
				eventResponse = modifyEmptyRepoConstraintInfo(e);
				
			} 		
		}	
		
		// Scenario Copy Monitoring
		if (e.getEventName().equalsIgnoreCase("EesEqr0127Event")) {
			eventResponse = scnrCopysearchMonitor (e);
		}
		return eventResponse;
	}
	
	/**
	 * [EES_EQR_0002 : Scenario - Create/Update 조회 ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScenarioIDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0002Event event = (EesEqr0002Event)e;
		ScenarioManageBC command = new ScenarioManageBCImpl();

		try{
			List<SearchScenarioIDListVO> list = command.searchScenarioIDList(event.getEesEqr0002ConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * [EES_EQR_0002 : Scenario - Create/Update - 시나리오 Copy ]<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createNewScenarioID(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0002Event event = (EesEqr0002Event)e;
		ScenarioManageBC command = new ScenarioManageBCImpl();
		CommonBCImpl commonImpl = new CommonBCImpl();
		
		
		try{
			begin();
			command.createNewScenarioID(event.getEesEqr0002ConditionVO(),account);		
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			// New Scenario ID
			String new_scnr_id = commonImpl.createNewScnarioId(event.getEesEqr0002ConditionVO().getScnrid()).getResultString();
			eventResponse.setETCData("scnr_id_no", new_scnr_id);
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
	 * [EES_EQR_0002 : Scenario - Create/Update 삭제 ]<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeScenarioID(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0002Event event = (EesEqr0002Event)e;
		ScenarioManageBC command = new ScenarioManageBCImpl();
		try{
			begin();
			command.removeScenarioID(event.getEqrScnrMstVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * [EES_EQR_0017 : Scenario - Create/Update 조회 ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSTOnHireInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		LeaseInfoManageBC command = new LeaseInfoManageBCImpl();
		EesEqr0017Event event = (EesEqr0017Event)e;
		CommonBCImpl commonImpl = new CommonBCImpl();
		
		EesEqr0017ConditionVO eesEqr0017ConditionVO = event.getEesEqr0017ConditionVO();
		
		String status = eesEqr0017ConditionVO.getStatus();
		String location = eesEqr0017ConditionVO.getLocation();
		String eccWhereCondition = "";
		
		// 검색조건의 location을 ECC로 변환하여 가져오기.
		if(!status.equals("")) {
			eccWhereCondition = commonImpl.convertECCInfo(status, location).getResultString();
		}
		// ECC로 변환된 location을 검색조건VO에 다시 Setting..
		eesEqr0017ConditionVO.setLocation(eccWhereCondition);
		try{
			
			CommonRsVO commonRsVO = command.searchSTOnHireInfo(eesEqr0017ConditionVO);
			eventResponse.setRsVo(commonRsVO.getDbRowset());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * [EES_EQR_0017 : Scenario - Create/Update 수정,삭제 ]<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifySTOnHireinfo(Event e) throws EventException {

		EesEqr0017Event event = (EesEqr0017Event) e;  // PDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = new GeneralEventResponse(); 			// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			LeaseInfoManageBC command = new LeaseInfoManageBCImpl();
			
			begin();
			command.modifySTOnHireinfo(event.getEqrScnrShrtTermOnhCondVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}
	/**
	 * EES_EQR_003Event 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EES_EQR_003EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInputDataRLAList(Event e) throws EventException {		
		EesEqr0003Event event = (EesEqr0003Event)e;        // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();                  // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체

		String fromEccWhere = "";
		String toEccWhere 	= "";
		try {			
			EesEqr0003ConditionVO vo = event.getConditionVO();
			CommonBCImpl commonImpl = new CommonBCImpl();
			
			if(vo.getFmtoat().equals("1")) {  // FM TO
				fromEccWhere = commonImpl.convertECCInfoString(vo.getFromStatus(), vo.getFromLocation()).getResultString();
				toEccWhere   = commonImpl.convertECCInfoString(vo.getToStatus(),   vo.getToLocation()).getResultString();
			}else {                               // AT
				fromEccWhere = commonImpl.convertECCInfoString(vo.getAtStatus(), vo.getAtLocation()).getResultString();
			}
			InputDataRlaExamineBC command = new InputDataRlaExamineBCImpl();
			
			InputDataRLAExamineRsVO retVo = command.searchInputDataRLAList(vo,fromEccWhere,toEccWhere);
			retVo.setConditionVo(event.getConditionVO());
			List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();
			rsVoList.add(retVo);
			eventResponse.setRsVoList(rsVoList);
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * EES_EQR_003Event 수정 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyInputDataRLAList(Event e) throws EventException {

		EesEqr0003Event event = (EesEqr0003Event) e;  // PDTO(Data Transfer Object including Parameters)
		
		try {
			InputDataRlaExamineBC command = new InputDataRlaExamineBCImpl();
			
			begin();
			command.modifyInputDataRLAList(event.getConditionVO(),event.getEqrScnrEccVOS(),account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		// 저장후 조회로직 호출	
		return this.searchInputDataRLAList(event);
	}		
	
	/**
	 * SCNR ECC 정보 조회/수정 조회 이벤트 처리<br>
	 * ScenarioDefaultManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchECCInfo(Event e) throws EventException {		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0007Event event = (EesEqr0007Event)e;
		EccInfoManageBC command = new EccInfoManageBCImpl();
		CommonBCImpl commonImpl = new CommonBCImpl();
		EesEqr0007ConditionVO conditionVO = event.getEesEqr007ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();
		
		try{
			String scnrId = Constants.SCNR_WORD + conditionVO.getYyyyww() + Constants.SCNR_WEEK + conditionVO.getSeq();
			String statusType = commonImpl.searchADRflg(scnrId).getResultString();
			
			conditionVO.setStatusType(statusType);
			conditionVO.setScnrId(scnrId);
			
			List<SearchEccInfoVO> resultVOList = command.searchECCInfo(conditionVO);
			
			if (resultVOList.size() != 0) {
				CommonRsVO commonRsVO = new CommonRsVO();
				commonRsVO.setConditionVO(conditionVO);
				commonRsVO.setResultVOList(resultVOList);
				
				returnVOList.add(commonRsVO);
			}
			
			eventResponse.setRsVoList(returnVOList);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * SCNR ECC 정보 조회/수정 조회 이벤트 처리<br>
	 * ScenarioDefaultManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchTSTMLInfo(Event e) throws EventException {		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0007Event event = (EesEqr0007Event)e;
		EccInfoManageBC command = new EccInfoManageBCImpl();
		CommonBCImpl commonImpl = new CommonBCImpl();
		EesEqr0007ConditionVO conditionVO = event.getEesEqr007ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();
		
		try{
			String scnrId = conditionVO.getScnrId();
			String statusType = commonImpl.searchADRflg(scnrId).getResultString();
			
			conditionVO.setStatusType(statusType);
			
			List<SearchEccTSTMLInfoVO> resultVOList = command.searchTSTMLInfo(conditionVO);
			
			if (resultVOList.size() != 0) {
				CommonRsVO commonRsVO = new CommonRsVO();
				commonRsVO.setConditionVO(conditionVO);
				commonRsVO.setResultVOList(resultVOList);
				
				returnVOList.add(commonRsVO);
			}
			
			eventResponse.setRsVoList(returnVOList);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * SCNR ECC 정보 조회/수정의 멀티 이벤트 처리<br>
	 * Update의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyECCInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0007Event event = (EesEqr0007Event)e;
		EccInfoManageBC command = new EccInfoManageBCImpl();
		CommonBCImpl commonImpl = new CommonBCImpl();
		
		String scnrId = event.getEesEqr007ConditionVO().getScnrId();
		String scnrRmk = event.getEesEqr007ConditionVO().getScnrRmk();
		
		try{
			begin();
			commonImpl.modifyScnrRmk(scnrId, scnrRmk, account.getUsr_id());
			
			command.modifyECCInfo(event.getEqrScnrEccVOS(), account);   // EQR_ECC_MST table modify
			command.modifyTSTMLInfo(event.getEqrScnrTsTmlVOS(), account);   // EQR_TS_TML table modify
			
			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
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
	 * SCNR ECC LINK 정보 조회/수정 조회 이벤트 처리<br>
	 * ScenarioDefaultManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchECCLinkInfo(Event e) throws EventException {		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0009Event event = (EesEqr0009Event)e;
		EccLinkInfoManageBC command = new EccLinkInfoManageBCImpl();
		CommonBCImpl commonImpl = new CommonBCImpl();
		EesEqr0009ConditionVO conditionVO = event.getEesEqr009ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();
		
		try{
			String scnrId = Constants.SCNR_WORD + conditionVO.getYyyyww() + Constants.SCNR_WEEK + conditionVO.getSeq();
			String statusType = commonImpl.searchADRflg(scnrId).getResultString();
			String fromLocation = "";
			String toLocation = "";
			
			if(!conditionVO.getFromStatus().equals("")) {
				fromLocation = commonImpl.convertECCInfoString(conditionVO.getFromStatus(), conditionVO.getFromLocation()).getResultSB().toString();
			}
			if(!conditionVO.getToStatus().equals("")) {
				toLocation = commonImpl.convertECCInfoString(conditionVO.getToStatus(), conditionVO.getToLocation()).getResultSB().toString();
			}		
			
			conditionVO.setStatusType(statusType);
			conditionVO.setScnrId(scnrId);
			conditionVO.setFromLocation(fromLocation);
			conditionVO.setToLocation(toLocation);
			
			List<SearchEccLinkInfoVO> resultVOList = command.searchECCLinkInfo(conditionVO);
			
			if (resultVOList.size() != 0) {
				CommonRsVO commonRsVO = new CommonRsVO();
				commonRsVO.setConditionVO(conditionVO);
				commonRsVO.setResultVOList(resultVOList);
				
				returnVOList.add(commonRsVO);
			}
			
			eventResponse.setRsVoList(returnVOList);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * SCNR ECC LINK 정보 조회/수정 멀티 이벤트 처리<br>
	 * Update의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyECCLinkInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0009Event event = (EesEqr0009Event)e;
		EccLinkInfoManageBC command = new EccLinkInfoManageBCImpl();
		CommonBCImpl commonImpl = new CommonBCImpl();
		EesEqr0009ConditionVO conditionVO = event.getEesEqr009ConditionVO();
		
		String scnrId = Constants.SCNR_WORD + conditionVO.getYyyyww() + Constants.SCNR_WEEK + conditionVO.getSeq();
		String scnrRmk = conditionVO.getScnrRmk();
		
		try{
			begin();
			commonImpl.modifyScnrRmk(scnrId, scnrRmk, account.getUsr_id());
			
			command.modifyECCLinkInfo(event.getEqrScnrEccLnkVOS(), scnrId, account);
			
			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
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
	 * 연간신조 및 L/T 계획 조회 / 수정 조회 이벤트 처리 (상단 Sheet 조회)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchWeeklyNewvanPlan(Event e) throws EventException {		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0020Event event = (EesEqr0020Event)e;
		OnhireDomesticNewvanScheduleInputBC command = new OnhireDomesticNewvanScheduleInputBCImpl();
		EesEqr0020ConditionVO conditionVO = event.getEesEqr0020ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();
		
		try{
			String scnrId = Constants.SCNR_WORD + conditionVO.getYyyyww() + Constants.SCNR_WEEK + conditionVO.getSeq();
			
			conditionVO.setScnrId(scnrId);
			conditionVO.setSheetNum("1"); // sheet1 에 대한 조회
			
			CommonRsVO rsVO = command.searchWeeklyNewvanPlan(conditionVO);
			
			if (rsVO.getDbRowset().getRowCount() != 0) {
				CommonRsVO commonRsVO = new CommonRsVO();
				commonRsVO.setConditionVO(conditionVO);
				commonRsVO.setDbRowset(rsVO.getDbRowset());
				
				returnVOList.add(commonRsVO);
			}
			
			eventResponse.setRsVoList(returnVOList);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * 연간신조 및 L/T 계획 조회 / 수정 조회 이벤트 처리 (하단 Sheet 조회)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchYearNewvanPlan(Event e) throws EventException {		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0020Event event = (EesEqr0020Event)e;
		OnhireDomesticNewvanScheduleInputBC command = new OnhireDomesticNewvanScheduleInputBCImpl();
		EesEqr0020ConditionVO conditionVO = event.getEesEqr0020ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();
		
		try{
			String scnrId = Constants.SCNR_WORD + conditionVO.getYyyyww() + Constants.SCNR_WEEK + conditionVO.getSeq();
			
			conditionVO.setScnrId(scnrId);
			conditionVO.setSheetNum("2"); // sheet2 에 대한 조회
			
			CommonRsVO rsVO = command.searchYearNewvanPlan(conditionVO);
			
			if (rsVO.getDbRowset().getRowCount() != 0) {
				CommonRsVO commonRsVO = new CommonRsVO();
				commonRsVO.setConditionVO(conditionVO);
				commonRsVO.setDbRowset(rsVO.getDbRowset());
				
				returnVOList.add(commonRsVO);
			}
			
			eventResponse.setRsVoList(returnVOList);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * 연간신조 및 L/T 계획 조회 / 수정 조회 이벤트 처리 (코드 조회)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse codeLocsearch(Event e) throws EventException {		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0020Event event = (EesEqr0020Event)e;
		OnhireDomesticNewvanScheduleInputBC command = new OnhireDomesticNewvanScheduleInputBCImpl();
		EesEqr0020ConditionVO conditionVO = event.getEesEqr0020ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();
		
		try{
			CommonRsVO rsVO = command.codeLocsearch(conditionVO.getSearchword());
			
			CommonRsVO commonRsVO = new CommonRsVO();
			commonRsVO.setConditionVO(conditionVO);
			commonRsVO.setDbRowset(rsVO.getDbRowset());
			
			returnVOList.add(commonRsVO);
			
			eventResponse.setRsVoList(returnVOList);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * 연간신조 및 L/T 계획 조회 / 수정 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse modifyYearNewvanPlan(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0020Event event = (EesEqr0020Event)e;
		OnhireDomesticNewvanScheduleInputBC command = new OnhireDomesticNewvanScheduleInputBCImpl();
		EesEqr0020ConditionVO conditionVO = event.getEesEqr0020ConditionVO();
		
		try{
			String scnrId = Constants.SCNR_WORD + conditionVO.getYyyyww() + Constants.SCNR_WEEK + conditionVO.getSeq();
			
			begin();
			command.modifyYearNewvanPlan(event.getEqrScnrNewVanLongTermVOS(), scnrId, account);
			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
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
	 * [EES_EQR_0021 : US Domestic 물량 조회/수정]<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchYearDomesticPlan(Event e) throws EventException {		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0021Event event = (EesEqr0021Event)e;
		OnhireDomesticNewvanScheduleInputBC command = new OnhireDomesticNewvanScheduleInputBCImpl();
		EesEqr0021ConditionVO conditionVO = event.getEesEqr0021ConditionVO();
		List<AbstractValueObject> returnVOList1 = new ArrayList<AbstractValueObject>();
		List<AbstractValueObject> returnVOList2 = new ArrayList<AbstractValueObject>();
		
		try{
			String scnrId = Constants.SCNR_WORD + conditionVO.getYyyyww() + Constants.SCNR_WEEK + conditionVO.getSeq();
			
			conditionVO.setScnrId(scnrId);
			
			CommonRsVO rsVO = command.searchYearDomesticPlan(conditionVO);
			
			// 상단Sheet 조회 결과 세팅
			CommonRsVO commonRsVO1 = new CommonRsVO();
			commonRsVO1.setConditionVO(conditionVO);
			commonRsVO1.setResultVOList(rsVO.getResultVOList());
			returnVOList1.add(commonRsVO1);
			
			// 하단Sheet 조회 결과 세팅
			CommonRsVO commonRsVO2 = new CommonRsVO();
			commonRsVO2.setConditionVO(conditionVO);
			commonRsVO2.setDbRowset(rsVO.getDbRowset());
			returnVOList2.add(commonRsVO2);
			
			eventResponse.setRsVoList(returnVOList1);
			eventResponse.setRsVoList(returnVOList2);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * US Domestic 물량 조회/수정 Share 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchDomesticPerformance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0021Event event = (EesEqr0021Event)e;
		OnhireDomesticNewvanScheduleInputBC command = new OnhireDomesticNewvanScheduleInputBCImpl();
		EesEqr0021ConditionVO conditionVO = event.getEesEqr0021ConditionVO();
		
		try{
			String scnrId = Constants.SCNR_WORD + conditionVO.getYyyyww() + Constants.SCNR_WEEK + conditionVO.getSeq();
			
			conditionVO.setScnrId(scnrId);
			
			begin();
			command.searchDomesticPerformance(conditionVO, account);
			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
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
	 * US Domestic 물량 조회/수정 Save 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse modifyYearDomesticPlan(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0021Event event = (EesEqr0021Event)e;
		OnhireDomesticNewvanScheduleInputBC command = new OnhireDomesticNewvanScheduleInputBCImpl();
		CommonBCImpl commonImpl = new CommonBCImpl();
		EesEqr0021ConditionVO conditionVO = event.getEesEqr0021ConditionVO();
		
		try{
			String scnrId = Constants.SCNR_WORD + conditionVO.getYyyyww() + Constants.SCNR_WEEK + conditionVO.getSeq();
			
			conditionVO.setScnrId(scnrId);
			
			begin();
			commonImpl.modifyScnrRmk(conditionVO.getScnrId(), conditionVO.getScnrRmk(), account.getUsr_id());
			command.modifyYearDomesticPlan(event.getEqrScnrDmstVOS(), account);
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
	 * 컨테이너 수요 예측(O/B) 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchCntrForecastInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0025Event event = (EesEqr0025Event)e;
		CntrForecastManageBC command = new CntrForecastManageBCImpl();
		EesEqr0025ConditionVO conditionVO = event.getEesEqr0025ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try{
			CommonRsVO commonRsVO = command.searchCntrForecastInfo(conditionVO);
			commonRsVO.setConditionVO(conditionVO);
			returnVOList.add(commonRsVO);
			
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
	 * 컨테이너 수요 예측(O/B) 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse modifyCntrForecastInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0025Event event = (EesEqr0025Event)e;
		CntrForecastManageBC command = new CntrForecastManageBCImpl();
		CommonBCImpl commonImpl = new CommonBCImpl();
		
		try{
			begin();
			command.modifyCntrForecastInfo(event.getEqrObFcastVOS(), event.getScnrId(), account);
			commonImpl.modifyScnrRmk(event.getScnrId(), event.getScnrRmk(), account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
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
	 * 컨테이너 수요 예측(I/B) 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchCntrGeneration(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0079Event event = (EesEqr0079Event)e;
		CntrForecastManageBC command = new CntrForecastManageBCImpl();
		EesEqr0079ConditionVO conditionVO = event.getEesEqr0079ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try{
			CommonRsVO commonRsVO = command.searchCntrGeneration(event.getEesEqr0079ConditionVO());
			commonRsVO.setConditionVO(conditionVO);
			returnVOList.add(commonRsVO);
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
	 * 컨테이너 수요 예측(I/B) 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse modifyCntrGeneration(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0079Event event = (EesEqr0079Event)e;
		CntrForecastManageBC command = new CntrForecastManageBCImpl();
		
		try{
			begin();
			command.modifyCntrGeneration(event.getEqrIbBkgFcastVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
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
	 * Constraint by Lane/ECC 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchConstraintLaneEccInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0138Event event = (EesEqr0138Event)e;
		RepoConstraintBC command = new RepoConstraintBCImpl();
		EesEqr0138ConditionVO conditionVO = event.getEesEqr0138ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try{
			CommonRsVO commonRsVO = command.searchConstraintLaneEccInfo(conditionVO);
			commonRsVO.setConditionVO(conditionVO);
			returnVOList.add(commonRsVO);
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
	 * Constraint by Lane/ECC 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse modifyConstraintLaneEccInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0138Event event = (EesEqr0138Event)e;
		RepoConstraintBC command = new RepoConstraintBCImpl();
		
		try{
			begin();
			command.modifyConstraintLaneEccInfo(event.getEqrScnrPortDchgCnstVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
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
	 * EES_EQR_0049 : 시나리오 리스트 정보를 가져온다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScenarioList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0049Event event = (EesEqr0049Event)e;
		CntrRepoPlanOptiExecuteBC command = new CntrRepoPlanOptiExecuteBCImpl();
        
		try{
			CntrRepoPlanOptiExecuteRsVO rsVO = command.searchScenarioList(event.getEesEqr0049ConditionVO());
			eventResponse.setRsVo(rsVO);
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
	 * EES_EQR_0049 : 0049화면에서 버튼 클릭시 엔진환경을 셋팅을 하는 메소드.<br>
	 * jms 를 사용하여 long time transaction 을 피함.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse addRepoPlanID(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0049Event event = (EesEqr0049Event)e;
		CntrRepoPlanOptiExecuteBC command = new CntrRepoPlanOptiExecuteBCImpl();
		
		EesEqr0049ConditionVO eesEqr0049ConditionVO = event.getEesEqr0049ConditionVO();
				
		//int repoPlanMaxSeq  = 0;  
		String weekStdt     = "";		    
		String userId       = account.getUsr_id(); // user id information	
		String repoPlanIdInit = ""; // repo plan 생성을 위한 입력값
		String repoPlanId   = "";   // 실제로 사용될 repo plan id
		String runIdNo      = "";
		String repo_auto_gen_flg = "";
		String scnrId       = "";
			
		//CommonRsVO  rsVO1 = new CommonRsVO();
		CommonBCImpl commonImpl = new CommonBCImpl();
		
		try {
			scnrId  		  = Constants.SCNR_WORD + eesEqr0049ConditionVO.getScnrYrWk() + Constants.SCNR_WEEK + eesEqr0049ConditionVO.getScnrSeq();
			repoPlanIdInit    = Constants.REPO_WORD + eesEqr0049ConditionVO.getScnrYrWk() + Constants.REPO_WEEK + "000";
			repo_auto_gen_flg = eesEqr0049ConditionVO.getRepo_auto_gen_flg();    // Cron Job으로 엔진 돌릴것인지 아닌지 판단하는 flg
			
			repoPlanId   	  = commonImpl.createNewRepoPlanId(repoPlanIdInit).getResultString(); // REPO201025W000 정도의 입력을 받아서 실제 사용할 REPO PLAN ID 생성
			runIdNo      	  = repoPlanId.substring(4,10) + repoPlanId.substring(11,14);
			
			eesEqr0049ConditionVO.setScnrid(scnrId);		
			eesEqr0049ConditionVO.setRepo_pln_rmk("R"); // 일반적인 repo_pln을 만들기 위한 구분자 코드
			eesEqr0049ConditionVO.setRepo_plan_id(repoPlanId); //  생성 되어질 REPO_PLN_ID를 변수에 저장 
						
	        if(!repo_auto_gen_flg.equals("on")) { // 현재주차로 엔진을 실행할 때, 바로 실행됨.
	        	
	            // 현재 Running 되고 있는 엔진 개수를 체크를 하는 메소드 
	            // 2개 이상이면 엔진 가동 안되게 강제적으로 Exception 을 발생 시킴 
	        	command.selectEnginCheck();					
	        	
	        	if(repo_auto_gen_flg.equals("")) {
	        	    repo_auto_gen_flg = "N";
	        	}else {
	        	    repo_auto_gen_flg = "Y";
	        	}
	        		
	        	CommonVO  rsVO   = commonImpl.searchWeekToDate(eesEqr0049ConditionVO.getScnrYrWk());
	          	weekStdt        = rsVO.getResultString();			
		        	 
		        // 앞으로 생성 되어질 REPO_PLN_ID를 셋팅 
		        //repo_plan_id     = Constants.REPO_WORD + eesEqr0049ConditionVO.getScnrYrWk() + Constants.REPO_WEEK + Utils.fill(String.valueOf(repoPlanMaxSeq), 3, "0", "left");
		        //repo_plan_id     = commonImpl.createNewRepoPlanId(scnr_id).getResultString();
		        //eesEqr0049ConditionVO.setRepo_plan_id(repo_plan_id); //  생성 되어질 REPO_PLN_ID를 변수에 저장 
		        
	            //	 eqr_eq_repo_pln, eqr_eng_inp_opmz_run 테이블에 환경 값을 insert
		        command.createRepoPlanRunOptimizer(eesEqr0049ConditionVO, weekStdt, userId);
		        
		        //repo_auto_gen_flg 'Y' 를 체크했을때는 배치 프로세스로 돌아가기 위해서 
		        //실시간 엔진을 안돌아가게 한다. 
		        if (repo_auto_gen_flg.equals("N")){
		        	// EQR_ENG_INP_OPMZ_RUN 저장된 RUN_ID을 변수에 저장을 한다.
		        	// sample : 2010000
		            eesEqr0049ConditionVO.setRun_id_no( runIdNo ); 

		            // 엔진 RUNNING을 시킬려면 TIME OUT이 발생하므로  JMS으로 트랜잭션을 넘겨준다. 
		            command.send0049ReRunSteve(eesEqr0049ConditionVO ,userId);
		        }
		        
		        eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
				eventResponse.setCustomData("run_id_no", runIdNo );
				eventResponse.setETCData("run_id_no", runIdNo);
										
	        }else if(repo_auto_gen_flg.equals("on")) { // 일요일에 엔진이 가동되도록 
	            // week의 start date 조회
	        	CommonVO  rsVO   = commonImpl.searchWeekToDate(eesEqr0049ConditionVO.getScnrYrWk());
	          	weekStdt        = rsVO.getResultString();
		        //repo_plan_id     = Constants.REPO_WORD + eesEqr0049ConditionVO.getScnrYrWk() + Constants.REPO_WEEK + "000";
	          	
		        repo_auto_gen_flg = "Y";
		        
		        eesEqr0049ConditionVO.setRepo_auto_gen_flg(repo_auto_gen_flg);  	
		        eesEqr0049ConditionVO.setRepo_plan_id(repoPlanId);
		        
//		        eqr_eq_repo_pln, eqr_eng_inp_opmz_run delete
                command.deleteRepoPlanRunOptimizer(eesEqr0049ConditionVO);	 				// eqr_eq_repo_pln, eqr_eng_inp_opmz_run delete
		        command.createRepoPlanRunOptimizer(eesEqr0049ConditionVO, weekStdt, userId);// eqr_eq_repo_pln, eqr_eng_inp_opmz_run insert

		        eesEqr0049ConditionVO.setRun_id_no("RUN_OK");
		        
		        eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
				eventResponse.setCustomData("run_id_no","RUN_OK");
				eventResponse.setETCData("run_id_no","RUN_OK");										
	        }
	        	
			eventResponse.setRsVo(command.searchScenarioList(event.getEesEqr0049ConditionVO()));
			
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
	 * 조회 이벤트 처리<br>
	 * scenariodefaultmanage의 event에 대한 특정 리스트 조회 이벤트 처리(0086화면)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLTOffHireInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0086Event event = (EesEqr0086Event)e;
	    //SearchSafetyStockVO SearchSafetyStockVO = null;
	    String eccInfo = "";
	    LeaseInfoManageBC command = new LeaseInfoManageBCImpl();
		CommonBC  commonCommand = new CommonBCImpl();
		try{
			if (!event.getEesEqr0086ConditionVO().getLoctype().equals("")){
				eccInfo = commonCommand.convertECCInfo(event.getEesEqr0086ConditionVO().getLoc(),event.getEesEqr0086ConditionVO().getLoctype()).getResultString();
			}
			log.debug("===================>" + eccInfo);
			CommonRsVO	rsVO = command.searchLTOffHireInfo(event.getEesEqr0086ConditionVO() , eccInfo);
		//	String[] maxArr = commonCommand.searchMaxInfo(event.getMaxInfoTable() ,"").getResultStrArray();
			eventResponse.setRsVo(rsVO.getDbRowset());
		//	eventResponse.setETCData("upd_usr_id",maxArr[0]);
		//	eventResponse.setETCData("upd_dt",maxArr[1]);  
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_EQR_086Event 수정 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyLTOffHireInfo(Event e) throws EventException {

		EesEqr0086Event event = (EesEqr0086Event) e;  // PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();			// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			LeaseInfoManageBC command = new LeaseInfoManageBCImpl();
			
			begin();
			command.modifyLTOffHireInfo(event.getEqrScnrLongTermOffhCondVOs(),account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
			
		return eventResponse;
	}	
    /**
     * 조회 이벤트 처리<br>
     * ScenarioManage 화면에 대한 조회 이벤트 처리<br>
     * 
     * @return response EES_EQR_111EventResponse
     * @exception EventException
     */ 
    private EventResponse searchVesselScheduleInfo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	EesEqr0111Event event = (EesEqr0111Event)e;
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try {
        	ScenarioManageBC command = new ScenarioManageBCImpl();
        	List<SearchVesselScheduleInfoVO> list = command.searchVesselScheduleInfo(event.getConditionVO());
        	eventResponse.setRsVoList(list);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    
    
    /**
     * 조회 이벤트 처리<br>
     * ScenarioManage 화면에 대한 조회 이벤트 처리<br>
     * 
     * @return response EES_EQR_111EventResponse
     * @exception EventException
     */ 
    private EventResponse searchVesselSchedulePortInfo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	EesEqr0111Event event = (EesEqr0111Event)e;
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try {
        	ScenarioManageBC command = new ScenarioManageBCImpl();
        	List<EqrScnrVslSkdVO> list = command.searchVesselSchedulePortInfo(event.getConditionVO());
        	List<CommonRsVO> retList = new ArrayList<CommonRsVO>();
        	CommonRsVO retVO = new CommonRsVO();     
        	
        	if (list.size() != 0) {
            	retVO.setResultVOList(list);
            	retVO.setConditionVO(event.getConditionVO());
            	retList.add(retVO);
        	}
        	
        	eventResponse.setRsVoList(retList);
        	
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }    
  
//    CSRNO : N200811110008로 추가 
    /**
     * 멀티 이벤트 처리<br>
     * ScenarioManage 화면에 대한 조회 이벤트 처리<br>
     * 
     * @return response EesEqr0111EventResponse
     * @exception EventException
     */ 
    private EventResponse modifyVesselSchedulePortInfo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	EesEqr0111Event event = (EesEqr0111Event)e;
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try {
        	ScenarioManageBC command = new ScenarioManageBCImpl();
        	List<EqrScnrVslSkdVO> list  = command.modifyVesselSchedulePortInfo(event.getConditionVO() , event.getEqrScnrVslSkdVOS() , account);
        	List<CommonRsVO> retList = new ArrayList<CommonRsVO>();
        	CommonRsVO retVO = new CommonRsVO();        	
        	
        	if (list.size() != 0) {
            	retVO.setResultVOList(list);
            	retVO.setConditionVO(event.getConditionVO());
            	retList.add(retVO);
        	}

        	eventResponse.setRsVoList(retList);
        	
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    } 

    /**
     * 멀티 이벤트 처리<br>
     * ScenarioManage 화면에 대한 조회 이벤트 처리<br>
     * 
     * @return response EES_EQR_111EventResponse
     * @exception EventException
     */ 
    private EventResponse modifyNisCurrentVesselSchedulePortInfo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	EesEqr0111Event event = (EesEqr0111Event)e;
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try {
        	ScenarioManageBC command = new ScenarioManageBCImpl();
        	List<EqrScnrVslSkdVO> list = command.modifyNisCurrentVesselSchedulePortInfo(event.getConditionVO(),event.getEqrScnrVslSkdVOS(),account);
        	//eventResponse.setRsVoList(list);
        	
        	List<CommonRsVO> retList = new ArrayList<CommonRsVO>();
        	CommonRsVO retVO = new CommonRsVO();        	
        	retVO.setResultVOList(list);
        	retVO.setConditionVO(event.getConditionVO());
        	retList.add(retVO);
        	eventResponse.setRsVoList(retList);
        	
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }  

	/**
     * CSR No : N200904200110 - VVD Add 기능 추가에 따른 멀티 이벤트 처리<br>
     * ScenarioManage 화면에 대한 저장 이벤트 처리<br>
     * 
     * @return response EesEqr0111EventResponse
     * @exception EventException
     */ 
    private EventResponse modifyVesselSchedulePortInfoAdd(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	EesEqr0111Event event = (EesEqr0111Event)e;
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try {
        	ScenarioManageBC command = new ScenarioManageBCImpl();
        	/*
        	 * 리턴값을 사용하지 않고 javascript 에서 제호출함 modify By ChungEunHo 09.11.06
        	 */
        	command.modifyVesselSchedulePortInfoAdd(event.getConditionVO(),event.getEqrScnrVslSkdVOS(),account);
        	
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }  
	
	/**
	 * Holiday Effect - Detail PopUp [ EES_EQR_0114 ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHolidayEffectDetailInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0114Event event = (EesEqr0114Event)e;
		EesEqr0114ConditionVO conditionVO = event.getEesEqr0114ConditionVO();
		String[] yrwkArr = null;
		String newHolidayTitle = "";

		try{
			CntrForecastManageBC command = new CntrForecastManageBCImpl();
			String stHolYr	= conditionVO.getStholyr();
			String endHolYr	= conditionVO.getEndholyr();
			String stHolWk	= conditionVO.getStholwk();
			String endHolWk = conditionVO.getEndholwk();
			
			CommonBCImpl commonImpl = new CommonBCImpl();
			yrwkArr = commonImpl.newHolidaySelect(stHolYr, endHolYr, stHolWk, endHolWk).getResultStrArray();			
			newHolidayTitle = commonImpl.getNewHolidayTitle();			
			
			// etc DATA setting
			conditionVO.setWkInfo(yrwkArr);	
			conditionVO.setNewHolidayTitle(newHolidayTitle);
			CommonRsVO obRsVO = command.searchHolidayEffectDetailInfo(conditionVO, "O");
			CommonRsVO ibRsVO = command.searchHolidayEffectDetailInfo(conditionVO, "I");
			List<DBRowSet> rsVoList = new ArrayList<DBRowSet>();
			rsVoList.add(obRsVO.getDbRowset());
			rsVoList.add(ibRsVO.getDbRowset());
			eventResponse.setETCData("title", event.getEesEqr0114ConditionVO().getNewHolidayTitle());
			eventResponse.setRsList(rsVoList);
			
			return eventResponse;
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * Holiday Effect PopUp [ EES_EQR_0114 ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHolidayEffectInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0114Event event = (EesEqr0114Event)e;
		CntrForecastManageBC command = new CntrForecastManageBCImpl();

		try{
			List<SearchEqrHolidayListVO> list = command.searchHolidayEffectInfo(event.getEesEqr0114ConditionVO());
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
	 * [ EES_EQR_0060 : Vessel R.Capa. 조회]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslResidualSpaceManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0060Event event = (EesEqr0060Event)e;
		VslResidualSpaceManageBC command = new VslResidualSpaceManageBCImpl();

		try{
			List<SearchVslRsdlSpaceVO> list = command.searchVslResidualSpaceManage(event.getEesEqr0060ConditionVO());
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
	 * [ EES_EQR_0060 : Vessel R.Capa. 삽입, 수정, 삭제]<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyVslResidualSpaceManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0060Event event = (EesEqr0060Event)e;
		VslResidualSpaceManageBC command = new VslResidualSpaceManageBCImpl();
		try{
			begin();
			command.modifyVslResidualSpaceManage(event.getEqrScnrVslRsdlCapaVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * [ EES_EQR_0060 : Vessel R.Capa. - Lane 체크해서 VVD 가져오기]<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchVslResidualSpaceLaneInfo(Event e) throws EventException {	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0060Event event = (EesEqr0060Event)e;
		VslResidualSpaceManageBC command = new VslResidualSpaceManageBCImpl();
		EesEqr0060ConditionVO eesEqr0060ConditionVO = event.getEesEqr0060ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();
		
		try{
			CommonRsVO commonRsVO = command.searchVslResidualSpaceLaneInfo(eesEqr0060ConditionVO);
			CommonRsVO vo = new CommonRsVO();
			
			vo.setConditionVO(eesEqr0060ConditionVO);
			vo.setDbRowset(commonRsVO.getDbRowset());
			
			returnVOList.add(vo);
			eventResponse.setRsVoList(returnVOList);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	/**
	 * [ EES_EQR_0060 : Vessel R.Capa. - 해당 VVD Click시 VVD SPC 값 체크해서 보여주기.]<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchVslResidualSpaceVvdInfo(Event e) throws EventException {	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0060Event event = (EesEqr0060Event)e;
		VslResidualSpaceManageBC command = new VslResidualSpaceManageBCImpl();
		EesEqr0060ConditionVO eesEqr0060ConditionVO = event.getEesEqr0060ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();
		
		try{
			CommonRsVO commonRsVO = command.searchVslResidualSpaceVvdInfo(eesEqr0060ConditionVO);
			CommonRsVO vo = new CommonRsVO();
			
			vo.setConditionVO(eesEqr0060ConditionVO);
			vo.setDbRowset(commonRsVO.getDbRowset());
			
			returnVOList.add(vo);
			eventResponse.setRsVoList(returnVOList);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	/**
	 * [ EES_EQR_0060 : Vessel R.Capa. - Ecc 체크 ]<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchVslResidualSpaceEccInfo(Event e) throws EventException {	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0060Event event = (EesEqr0060Event)e;
		VslResidualSpaceManageBC command = new VslResidualSpaceManageBCImpl();
		EesEqr0060ConditionVO eesEqr0060ConditionVO = event.getEesEqr0060ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();
		
		try{
			CommonRsVO commonRsVO = command.searchVslResidualSpaceEccInfo(eesEqr0060ConditionVO);
			CommonRsVO vo = new CommonRsVO();
			
			vo.setConditionVO(eesEqr0060ConditionVO);
			vo.setDbRowset(commonRsVO.getDbRowset());
			
			returnVOList.add(vo);
			eventResponse.setRsVoList(returnVOList);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
     * S/T off-Hire 정보조회/수정에 대한 sheet1 리스트 조회 이벤트 처리<br>
     * EES_EQR_085에 대한 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EES_EQR_085EventResponse
     * @exception EventException
     */
	private EventResponse searchSTOffHireInfo(Event e) throws EventException {

		EesEqr0085Event event = (EesEqr0085Event) e; // PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 		   // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		String eccInfo = "";
		CommonRsVO retVO = null;
		try {
			EesEqr0085ConditionVO conditionVO = event.getConditionVO();
			CommonBCImpl common = new CommonBCImpl();
	        
	        if (!conditionVO.getLoctype().equals("")){
	        	eccInfo = common.convertECCInfo(conditionVO.getLoc(),conditionVO.getLoctype()).getResultString();
	        }
			LeaseInfoManageBC command = new LeaseInfoManageBCImpl();
			retVO = command.searchSTOffHireInfo(conditionVO , eccInfo);
			eventResponse.setRs(retVO.getDbRowset());
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
     * S/T off-Hire 정보조회/수정에 대한 sheet1 리스트 수정 이벤트 처리<br>
     * EES_EQR_085에 대한 수정 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EES_EQR_085EventResponse
     * @exception EventException
     */
	public EventResponse modifySTOffHireinfo(Event e) throws EventException {

		EesEqr0085Event event = (EesEqr0085Event) e;  // PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 			// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			LeaseInfoManageBC command = new LeaseInfoManageBCImpl();
			
			begin();
			command.modifySTOffHireInfo(event.getEqrScnrShrtTermOffhCondVOS() , account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * [ EES_EQR_0026 : Safty Stock - Search ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrSafetyStock(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0026Event event = (EesEqr0026Event)e;
		CntrSafetyStockManageBC command = new CntrSafetyStockManageBCImpl();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();
		EesEqr0026ConditionVO conditionVO = event.getEesEqr0026ConditionVO();

		try{
			CommonRsVO commonRsVO = command.searchCntrSafetyStock(event.getEesEqr0026ConditionVO());
			
			CommonRsVO vo = new CommonRsVO();			
			vo.setConditionVO(conditionVO);
			vo.setDbRowset(commonRsVO.getDbRowset());
			returnVOList.add(vo);
			
			eventResponse.setRsVoList(returnVOList);
			eventResponse.setETCData("rowSearchCol", "");
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
	 * [ EES_EQR_0026 : Safty Stock - SFST_VOL_QTY 가져오기. ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrSafetyStockQty(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0026Event event = (EesEqr0026Event)e;
		CntrSafetyStockManageBC command = new CntrSafetyStockManageBCImpl();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();
		EesEqr0026ConditionVO conditionVO = event.getEesEqr0026ConditionVO();

		try{
			String col_name = conditionVO.getCol();
			String cntr_tpsz_cd = ( !col_name.equals("") ) ? col_name.substring(0,2).toUpperCase() : "";
			
			CommonRsVO commonRsVO = command.searchCntrSafetyStockQty(event.getEesEqr0026ConditionVO());
			
			CommonRsVO vo = new CommonRsVO();			
			vo.setConditionVO(conditionVO);
			vo.setDbRowset(commonRsVO.getDbRowset());
			returnVOList.add(vo);
			
			eventResponse.setRsVoList(returnVOList);
			eventResponse.setETCData("rowSearchCol", cntr_tpsz_cd);
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
	 * [ EES_EQR_0026 : Safty Stock - Merge, Delete ]<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCntrSafetyStock(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0026Event event = (EesEqr0026Event)e;
		CntrSafetyStockManageBC command = new CntrSafetyStockManageBCImpl();
		try{
			begin();
			command.multiCntrSafetyStock(event.getEqrScnrEccSftStkVOS(),account);
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
     * 조회 이벤트 처리<br>
     * EES_EQR_090Event 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EES_EQR_090EventResponse
     * @exception EventException
     */
	private EventResponse searchYearSubleasePlan(Event e) throws EventException {
		
		EesEqr0090Event event = (EesEqr0090Event) e; // PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 		   // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		CommonRsVO retVO = null;
		try {
			OnhireDomesticNewvanScheduleInputBC command = new OnhireDomesticNewvanScheduleInputBCImpl();
			retVO = command.searchYearSubleasePlan(event.getConditionVO());
			List<CommonRsVO> listRS = new ArrayList<CommonRsVO>();
			List<CommonRsVO> listVO = new ArrayList<CommonRsVO>();
			CommonRsVO retDBRowSetVO = new CommonRsVO();
			CommonRsVO retVOListVO = new CommonRsVO();
			retDBRowSetVO.setDbRowset(retVO.getDbRowset());
			retDBRowSetVO.setConditionVO(event.getConditionVO());
			retVOListVO.setResultVOList(retVO.getResultVOList());
			retVOListVO.setConditionVO(event.getConditionVO());
			listRS.add(retDBRowSetVO); // dbrowSet setting searchYearSubleaseDetailPlan
			listVO.add(retVOListVO); // volist setting searchYearSubleasePlan
			eventResponse.setRsVoList(listVO);
			eventResponse.setRsVoList(listRS);
			eventResponse.setETCData("statusType",event.getConditionVO().getStatustype());
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * EES_EQR_090Event 수정 이벤트 처리
	 * @param e Event
	 * @return response EES_EQR_090EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyYearSubleasePlan(Event e) throws EventException {

		EesEqr0090Event event = (EesEqr0090Event) e;  // PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();			// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		//CommonRsVO retVO = null;
		try {
			OnhireDomesticNewvanScheduleInputBC command = new OnhireDomesticNewvanScheduleInputBCImpl();
			CommonBCImpl commonImpl = new CommonBCImpl();
			begin();
			commonImpl.modifyScnrRmk(event.getConditionVO().getScnrId(), event.getConditionVO().getScnrRmk(),  account.getUsr_id());
			command.modifyYearSubleasePlan(event.getEqrScnrSlseVOS(),account);
			commit();
			// save 이후 sheet2_OnSaveEnd 메소드에서 searchYearSubleasePlan 재호출됨 09.08.11 By ChungEunHo
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
    /**
     * 멀티 이벤트 처리<br>
     * ScenarioManage의 event에 대한 멀티 이벤트 처리<br>
     * 
     * @param e Event
     * @return EES_EQR_090EventResponse
     * @exception EventException
     */
    public EventResponse searchSubleasePerformance(Event e) throws EventException {
        //사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesEqr0090Event event = (EesEqr0090Event) e;  // PDTO(Data Transfer Object including Parameters)
        try {
            begin();
            OnhireDomesticNewvanScheduleInputBC command = new OnhireDomesticNewvanScheduleInputBCImpl();
            command.searchSubleasePerformance(event.getConditionVO(),account);
            commit();
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        
        return eventResponse;
    }    

	/**
	 * BSA 조회 <br>
	 * ScenarioManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EES_EQR_014EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBSInfo(Event e) throws EventException {		
		EesEqr0014Event event = (EesEqr0014Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();          // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		String flag = "TRUE";
		//String status = "";
		EesEqr0014ConditionVO condiVO = event.getConditionVO();
		List<CommonRsVO> listRS = new ArrayList<CommonRsVO>();
		CommonRsVO commonRsVO = new CommonRsVO();
		try {
			if (condiVO.getStatusType().equals("FALSE")){
				flag ="FALSE";
			}
			condiVO.setFlag(flag);
			//log.info("flag=============>"+ condiVO.getStatusType());
			//status = condiVO.getStatusType();
			VslResidualSpaceManageBC command = new VslResidualSpaceManageBCImpl();
			List<SearchBSInfoVO> list = command.searchBSInfo(condiVO);
			commonRsVO.setConditionVO(condiVO);
			commonRsVO.setResultVOList(list);
			listRS.add(commonRsVO);
			eventResponse.setRsVoList(listRS);
			
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	

	/**
	 * BSA 조회 <br>
	 * ScenarioManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EES_EQR_014EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBSPortInfo(Event e) throws EventException {		
		EesEqr0014Event event = (EesEqr0014Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();           // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		String flag = "";
		//String status = "";
		EesEqr0014ConditionVO condiVO = event.getConditionVO();
		List<CommonRsVO> listRS = new ArrayList<CommonRsVO>();
		CommonRsVO commonRsVO = new CommonRsVO();
		try {
			if (condiVO.getStatusType().equals("FALSE")){
				flag ="FALSE";
			}
			//status = condiVO.getStatusType();
			VslResidualSpaceManageBC command = new VslResidualSpaceManageBCImpl();
			List<SearchBSPortInfoVO> list = command.searchBSPortInfo(condiVO);
			condiVO.setFlag(flag);
			commonRsVO.setConditionVO(condiVO);
			commonRsVO.setResultVOList(list);
			listRS.add(commonRsVO);
			eventResponse.setRsVoList(listRS);
			
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	

	/**
	 * BSA 수정, 삭제. <br>
	 * ScenarioManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EesEqr0014EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBSAInfo(Event e) throws EventException {		
		EesEqr0014Event event = (EesEqr0014Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();           // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EesEqr0014ConditionVO condiVO = event.getConditionVO();
		String scnrId = Constants.SCNR_WORD+condiVO.getYyyyww()+Constants.SCNR_WEEK+condiVO.getSeq();
		try {
	    	CommonBCImpl commonImpl = new CommonBCImpl();
			VslResidualSpaceManageBC command = new VslResidualSpaceManageBCImpl();
			begin();
	    	commonImpl.modifyScnrRmk(scnrId, condiVO.getScnr_rmk(), account.getUsr_id());
			command.modifyBSAInfo(event.getEqrScnrBsaVvdVOS(),account);
			commit();
			return (eventResponse); 
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * BSA 수정, 삭제. <br>
	 * ScenarioManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EesEqr0014EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBSAPortInfo(Event e) throws EventException {		
		EesEqr0014Event event = (EesEqr0014Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();          // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EesEqr0014ConditionVO condiVO = event.getConditionVO();
		String scnrId = Constants.SCNR_WORD+condiVO.getYyyyww()+Constants.SCNR_WEEK+condiVO.getSeq();
		try {
	    	CommonBCImpl commonImpl = new CommonBCImpl();
			VslResidualSpaceManageBC command = new VslResidualSpaceManageBCImpl();
			begin();
	    	commonImpl.modifyScnrRmk(scnrId, condiVO.getScnr_rmk(), account.getUsr_id());
			command.modifyBSAPortInfo(event.getEqrScnrBsaPortVOS(),account);
			commit();
			return eventResponse; 
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * 컨테이너 Turn-Time 조회 정보 <br>
	 * ScenarioManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EES_EQR_126EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrTurnTimeInfo(Event e) throws EventException {		
		EesEqr0126Event event = (EesEqr0126Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();            // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EesEqr0126ConditionVO conditionVO = event.getConditionVO();
		String status = conditionVO.getStatusType();
		List<CommonRsVO> listRS = new ArrayList<CommonRsVO>();
		CommonRsVO commonRsVO = new CommonRsVO();
		try {
			status = "FALSE";                  // 사용자에 의해서 수정 저장이 안되게 하기 위해서 GRID를 활성화를 막음 
			CntrForecastManageBC command = new CntrForecastManageBCImpl();
			CommonVO commonVO = command.searchCntrTurnTimeInfo(conditionVO);
			conditionVO.setStatusType(status);
			commonRsVO.setConditionVO(conditionVO);
			commonRsVO.setDbRowset(commonVO.getDbRowset());
			listRS.add(commonRsVO);
			eventResponse.setRsVoList(listRS);
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	/**
	 * 컨테이너 Turn-Time 변경  정보 <br>
	 * ScenarioManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EES_EQR_126EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCntrTurnTimeInfo(Event e) throws EventException {		
		EesEqr0126Event event = (EesEqr0126Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();            // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		
		try {
			CntrForecastManageBC command = new CntrForecastManageBCImpl();
			begin();
			command.modifyCntrTurnTimeInfo(event.getEqrScnrEccTurnTmVOS(),account);
			commit();
			return (eventResponse); 
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * [ EES_EQR_0026 : Safty Stock - Search ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonitor(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0050Event event = (EesEqr0050Event)e;
		CntrRepoPlanOptiExecuteBC command = new CntrRepoPlanOptiExecuteBCImpl();
		
		try{
			CommonRsVO rsVO = command.searchMonitor(event,account);
			eventResponse.setRsVo(rsVO.getDbRowset());
			
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
	 * Empty Repo Constraint 조회 <br>
	 * Empty Repo Constraint 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
 	 */
	private EventResponse searchEmptyRepoConstraintInfo(Event e) throws EventException {		
		EesEqr0022Event event = (EesEqr0022Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();     
        String[] maxInfo =null;
		try {
			RepoConstraintBC command = new RepoConstraintBCImpl();
			CommonBCImpl commonImpl = new CommonBCImpl();
			//eccWhereCondition = commonImpl.convertECCInfo(event.getLoc(), event.getLoctype());
			maxInfo = commonImpl.searchMaxInfo(event.getMaxInfoTable(), event.getMaxInfoCondition()).getResultStrArray();
			CommonRsVO commonRsVO  = command.searchEmptyRepoConstraintInfo(event.getScnrid() , event.getCnsttype() , event.getTpsz());
			eventResponse.setRs(commonRsVO.getDbRowset());
			eventResponse.setETCData("userid", maxInfo[0]);
			eventResponse.setETCData("date", maxInfo[1]);
			
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * Empty Repo Constraint 저장 <br>
	 * Empty Repo Constraint 저장 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	private EventResponse modifyEmptyRepoConstraintInfo(Event e) throws EventException {
		
		EesEqr0022Event event = (EesEqr0022Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();           // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        String[] maxInfo =null;
		try {
			RepoConstraintBC command = new RepoConstraintBCImpl();
			CommonBCImpl commonImpl = new CommonBCImpl();
			//eccWhereCondition = commonImpl.convertECCInfo(event.getLoc(), event.getLoctype());
			maxInfo = commonImpl.searchMaxInfo(event.getMaxInfoTable(), event.getMaxInfoCondition()).getResultStrArray();
			begin();
			CommonRsVO commonRsVO  = command.modifyEmptyRepoConstraintInfo(event.getScnrid() , event.getCnsttype() , event.getTpsz() , event.getEqrScnrRepoCnstVOS(), account);
			commit();
			eventResponse.setRs(commonRsVO.getDbRowset());
			eventResponse.setETCData("userid", maxInfo[0]);
			eventResponse.setETCData("date", maxInfo[1]);
			return (eventResponse); 
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * [ EES_EQR_0127 : Scenario Copy Monitoring ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse scnrCopysearchMonitor (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0127Event event = (EesEqr0127Event)e;
		CntrRepoPlanOptiExecuteBC command = new CntrRepoPlanOptiExecuteBCImpl();

		try{
			CommonRsVO commonRsVO = command.scnrCopysearchMonitor (event.getScnrId());
			
			eventResponse.setRsVo(commonRsVO.getDbRowset());
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
}