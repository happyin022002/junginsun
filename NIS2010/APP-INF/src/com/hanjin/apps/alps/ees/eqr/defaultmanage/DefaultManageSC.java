/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DefaultManageSC.java
*@FileTitle :DefaultManageSC
*Open Issues :
*Change history :
* No.	Ver.		Modifier           	modifier date    explanation
* 1     1.0      	jungran yang		2006-09-05		1.0 최초 생성
* 2     1.0      	Lee Byoung Hun		2009-06-30		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.06.30
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.06.30 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage;


import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.basic.CommonBC;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.basic.CommonBCImpl;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.basic.RepoThresholdManageBC;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.basic.RepoThresholdManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.event.EesEqr0001Event;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.event.EesEqr0035Event;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.event.EesEqr0044Event;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.event.EesEqr0058Event;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.vo.RepoThresholdManageRsVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.vo.SearchRepoPlanRLAThresholdVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.basic.ScenarioDefaultManageBC;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.basic.ScenarioDefaultManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event.EesEqr0034Event;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event.EesEqr0042Event;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event.EesEqr0043Event;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event.EesEqr0115Event;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event.EesEqr0116Event;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event.EesEqr0117Event;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event.EesEqr0118Event;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event.EesEqr0119Event;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event.EesEqr0120Event;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event.EesEqr0121Event;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event.EesEqr0122Event;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event.EesEqr0123Event;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event.EesEqr0124Event;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event.EesEqr0137Event;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0042ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0117ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0121ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0123ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.ScenarioDefaultManageRsVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchAutoRunParameterVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchEccMasterVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchEccTsTmlVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchEqrHolidayEffectVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchYearSubleaseDetailPlanMonthlyVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchYearSubleaseDetailPlanWeeklyVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchYearSubleasePlanVO;
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
import com.hanjin.syscommon.common.table.EqrEccLnkVO;
import com.hanjin.syscommon.common.table.EqrInpDatRedLgtAltVO;
/**
 * NIS2010-DefaultManage Business Logic ServiceCommand - NIS2010-DefaultManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Chae Change Ho
 * @see scenariodefaultmanageDBDAO
 * @since J2EE 1.6 
 */

public class DefaultManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * DefaultManage system 업무 시나리오 선행작업<br>
	 * EES_EQR_034업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("DefaultManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * DefaultManage system 업무 시나리오 마감작업<br>
	 * EES_EQR_034 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("DefaultManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-DefaultManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
        
		// ECC 정보 조회/수정
		if (e.getEventName().equalsIgnoreCase("EesEqr0115Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {			// Retrieve 버튼 클릭시
				eventResponse = searchDefaultECCInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {	// TS 컬럼 클릭시
				eventResponse = searchDefaultTSTMLInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {		// Save 버튼 클릭시
				eventResponse = modifyDefaultECCInfo(e);
			}
		}
		
		// S/T On-Hire 정보 조회/수정
		if (e.getEventName().equalsIgnoreCase("EesEqr0118Event")) {	
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {    			// Retrieve 버튼 클릭시
				eventResponse = searchDefaultSTOnHireInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {			// Save 버튼 클릭시
				eventResponse = modifyDefaultSTOnHireInfo(e);
			}
		}
		
		// L/T Off-Hire 정보 조회/수정
		if (e.getEventName().equalsIgnoreCase("EesEqr0120Event")) {	
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {    			// Retrieve 버튼 클릭시
				eventResponse = searchDefaultLTOffHireInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {			// Save 버튼 클릭시
				eventResponse = modifyDefaultLTOffHireInfo(e);
			}
		}
		
		// Sublease 물량 조회/수정
		if (e.getEventName().equalsIgnoreCase("EesEqr0123Event")) {	
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {				// Retrieve 버튼 클릭시
				eventResponse = searchDefaultYearSubleasePlan(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {				// Share 버튼 클릭시 
				eventResponse = createDefaultYearSubleasePlan(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {			// Save 버튼 클릭시 
				eventResponse = modifyDefaultYearSubleasePlan(e);
			}		
		}
		
		// Red Light Alert 기준 조회/수정---컨테이너 수급 예측
		if (e.getEventName().equalsIgnoreCase("EesEqr0035Event")) {	
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {    			// Retrieve 버튼 클릭시
				eventResponse = searchCntrForecastRLAThreshold(e);				
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {       		// Save 버튼 클릭시
				eventResponse = modifyCntrForecastRLAThreshold(e);
			} 		
		}	
		
		// Red Light Alert 기준 조회/수정---컨테이너 이송 계획 
		if (e.getEventName().equalsIgnoreCase("EesEqr0044Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {    			// Retrieve 버튼 클릭시
				eventResponse = searchCntrRepoPlanRLAThreshold(e);				
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {  	// sheet1에서 check box 클릭시		
				eventResponse = searchCntrRepoPlanRLADTLThreshold(e);				
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {       	// Save 버튼 클릭시
				eventResponse = modifyCntrRepoPlanRLAThreshold(e);
			} 		
		}
		
		//실행 계획 Feedback 기준 설정
		if (e.getEventName().equalsIgnoreCase("EesEqr0058Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {			// Retrieve 버튼 클릭시
				eventResponse = searchExecutionFeedback(e);
			} 
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {						// Save 버튼 클릭시 (Basic 시트 내용)
				eventResponse = multiExecutionFeedback(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {					// Save 버튼 클릭시 (Exceptional 시트 내용)
				eventResponse = multiExecutionFeedbackExpt(e);
			}
		}
		// Holiday Effect
		if (e.getEventName().equalsIgnoreCase("EesEqr0042Event")) {				
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {				// Retrieve 버튼 클릭시
				eventResponse = searchDefaultHolidayEffectInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {				// Save 버튼 클릭시 
				eventResponse = modifyDefaultHolidayEffectInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {			// Save 버튼 클릭시 
				eventResponse = modifyDefaultHolidayEffectDetailInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {			// Save 버튼 클릭시 
				eventResponse = modifyDefaultHolidayEffectDetailInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {		// Detail 버튼 클릭시  사용안함 ( SEARCHLIST02 , SEARCHLIST03 으로 분기 ) 09.07.10 정은호
				eventResponse = searchDefaultHolidayEffectDetailInfo(e);
			}		
		}	

		// 연간 신조 계획 조회/수정	
		if (e.getEventName().equalsIgnoreCase("EesEqr0121Event")) {	
			if(e.getFormCommand().isCommand(FormCommand.DEFAULT)) {            // 
				eventResponse = searchDefaultYearNewVanPlanMonthWeekInfo(e);				
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {  // Retrieve 버튼 클릭시
				eventResponse = searchDefaultYearNewvanPlan(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // Weekly 버튼 클릭시
				eventResponse = searchDefaultWeekNewvanPlan(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {        // Weekly 버튼 클릭시
				eventResponse = modifyDefaultYearNewvanPlan(e);				
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {      // Save 버튼 클릭시 sheet2 저장
				eventResponse = modifyDefaultWeekNewvanPlan(e);
			} 		
		}
		
		// 연간 신조 계획 조회/수정	
		if (e.getEventName().equalsIgnoreCase("EesEqr0116Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {  // Retrieve 버튼 클릭시
				eventResponse = searchDefaultECCLinkInfo(e);
				log.debug("EesEqr116Event start FormCommand.SEARCH "+FormCommand.SEARCH);
			}else if(e.getFormCommand().isCommand(FormCommand.MODIFY)) { // SAVE 버튼 클릭시
				eventResponse = modifyDefaultECCLinkInfo(e);	
			} 		
		}		

		//Red Light Alert 기준 조회/수정 이송 계획 Input Data
		if (e.getEventName().equalsIgnoreCase("EesEqr0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCntrRepoPlanInputDataRLAThreshold();
			} 
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiCntrRepoPlanInputDataRLAThreshold(e);
			}
		}
      
		// Turn Time
		if (e.getEventName().equalsIgnoreCase("EesEqr0043Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){
				eventResponse = searchDefaultCntrTurnTimeInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = modifyDefaultCntrTurnTimeInfo(e);
			}
		}
		
		// S/T Off Hire 조회
		if (e.getEventName().equalsIgnoreCase("EesEqr0119Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchDefaultSTOffHireInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyDefaultSTOffHireInfo(e);
			}
		}
		
		// Cabotage & HJS Rule 조회
		if (e.getEventName().equalsIgnoreCase("EesEqr0124Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchDefaultEmptyRepoConstraintInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyDefaultEmptyRepoConstraintInfo(e);
			}
		}
		
		// Constraint by Lane/POD 조회
		if (e.getEventName().equalsIgnoreCase("EesEqr0137Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchDefaultConstraintLandPod(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyDefaultConstraintLandPod(e);
			}
		}
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		//Demand Forecast Parameter
		if (e.getEventName().equalsIgnoreCase("EesEqr0034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAutoRunParameter(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiAutoRunParameter(e);
			}
		}
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		//Safety Stock
		if (e.getEventName().equalsIgnoreCase("EesEqr0117Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDefaultCntrSafetyStock(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){
				eventResponse = searchDefaultCntrSafetyStockQty(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiDefaultCntrSafetyStock(e);
			}
		}
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		// HJL Domestic
		if (e.getEventName().equalsIgnoreCase("EesEqr0122Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchDefaultYearDomesticPlan(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createDefaultYearDomesticPlan(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = modifyDefaultYearDomesticPlan(e);
			}
		}
		return eventResponse;
	}
	/**
	 * 조회 이벤트 처리<br>
	 * scenariodefaultmanage의 event에 대한 특정 리스트 조회 이벤트 처리(0034화면)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAutoRunParameter(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0034Event event = (EesEqr0034Event)e;
		//SearchAutoRunParameterVO SearchAutoRunParameterVO = null;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		CommonBC  commonCommand = new CommonBCImpl();
		try{
			List<SearchAutoRunParameterVO> list = command.searchAutoRunParameter(event.getsearchAutoRunParameter());
			eventResponse.setRsVoList(list);
			String[] maxArr = commonCommand.searchMaxInfo("EQR_AUTO_RUN_FCAST_PARA" ,"").getResultStrArray();
			eventResponse.setETCData("upd_usr_id",maxArr[0]);
			eventResponse.setETCData("upd_dt",maxArr[1]);    
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * [ EES_EQR_0115 : Retrieve ]
	 * ECC 정보 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDefaultECCInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0115Event event = (EesEqr0115Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		CommonBCImpl commonImpl = new CommonBCImpl();
		String status = event.getStatus();
		String location = event.getLocation();

		try{
			List<SearchEccMasterVO> list = command.searchDefaultECCInfo(status, location);
			eventResponse.setRsVoList(list);
			
			String[] maxArr = commonImpl.searchMaxInfo("EQR_ECC_MST", "").getResultStrArray();
			eventResponse.setETCData("userid", maxArr[0]);
			eventResponse.setETCData("date", maxArr[1]);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * ECC 정보 조회/수정의 TS 정보 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDefaultTSTMLInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0115Event event = (EesEqr0115Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		String eccCd = event.getEccCd();

		try{
			List<SearchEccTsTmlVO> list = command.searchDefaultTSTMLInfo(eccCd);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * ECC 정보 조회/수정의 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyDefaultECCInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0115Event event = (EesEqr0115Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		
		try{
			begin();
			command.modifyDefaultECCInfo(event.getEqrEccMstVOS(), account);   // EQR_ECC_MST table modify
			command.modifyDefaultTSTMLInfo(event.getEqrTsTmlVOS(), account);   // EQR_TS_TML table modify
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
	 * S/T On Hire 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchDefaultSTOnHireInfo(Event e) throws EventException {		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0118Event event = (EesEqr0118Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		CommonBCImpl commonImpl = new CommonBCImpl();
		String status = event.getStatus();
		String location = event.getLocation();
		String tpsztype = event.getTpsztype();
		String eccWhereCondition = "";
		
		try{
			if (!"".equals(status)) {
				eccWhereCondition = commonImpl.convertECCInfo(status, location).getResultString();
			}
			CommonRsVO rsVO = command.searchDefaultSTOnHireInfo(eccWhereCondition, tpsztype);
			eventResponse.setRsVo(rsVO.getDbRowset());
			
			String[] maxArr = commonImpl.searchMaxInfo("EQR_SHRT_TERM_ONH_COND", "").getResultStrArray();
			eventResponse.setETCData("userid", maxArr[0]);
			eventResponse.setETCData("date", maxArr[1]);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * S/T On Hire 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyDefaultSTOnHireInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0118Event event = (EesEqr0118Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		
		try{
			begin();
			command.modifyDefaultSTOnHireInfo(event.getEqrShrtTermOnhCondVOS(), account);
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
	 * L/T Off-Hire 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchDefaultLTOffHireInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0120Event event = (EesEqr0120Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		CommonBCImpl commonImpl = new CommonBCImpl();
		String status = event.getStatus();
		String location = event.getLocation();
		String tpsztype = event.getTpsztype();
		String eccWhereCondition = "";
		
		try{
			if (!"".equals(status)) {
				eccWhereCondition = commonImpl.convertECCInfo(status, location).getResultString();
			}
			CommonRsVO rsVO = command.searchDefaultLTOffHireInfo(eccWhereCondition, tpsztype);
			eventResponse.setRsVo(rsVO.getDbRowset());
			
			String[] maxArr = commonImpl.searchMaxInfo("EQR_LONG_TERM_OFFH_COND", "").getResultStrArray();
			eventResponse.setETCData("userid", maxArr[0]);
			eventResponse.setETCData("date", maxArr[1]);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * L/T Off-Hire 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyDefaultLTOffHireInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0120Event event = (EesEqr0120Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		
		try{
			begin();
			command.modifyDefaultLTOffHireInfo(event.getEqrLongTermOffhCondVOS(), account);
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
	 * Sublease Out 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchDefaultYearSubleasePlan(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0123Event event = (EesEqr0123Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		CommonBCImpl commonImpl = new CommonBCImpl();
		EesEqr0123ConditionVO conditionVO = event.getEesEqr123ConditionVO();
		String plnYr = null;
		
		try{
			List<SearchYearSubleasePlanVO> list1 = command.searchDefaultYearSubleasePlan(conditionVO);
			eventResponse.setRsVoList(list1);
			
			if ("1".equals(conditionVO.getMonthWeek())) {
				List<SearchYearSubleaseDetailPlanMonthlyVO> list2 = command.searchDefaultYearSubleaseDetailPlanMonthly(conditionVO);
				eventResponse.setRsVoList(list2);
			} else {
				List<SearchYearSubleaseDetailPlanWeeklyVO>	list3 = command.searchDefaultYearSubleaseDetailPlanWeekly(conditionVO);
				eventResponse.setRsVoList(list3);
			}
			
			
			if ("1".equals(conditionVO.getFmToAt())) {
				plnYr = conditionVO.getFmPlnYr();
			} else {
				plnYr = conditionVO.getAtPlnYr();
			}
			
			String[] maxArr = commonImpl.searchMaxInfo("eqr_sublease", " SUBSTR(pln_yrwk, 1, 4) = '"+ plnYr +"'").getResultStrArray();
			eventResponse.setETCData("updUsrId", maxArr[0]);
			eventResponse.setETCData("updDt", maxArr[1]);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Sublease Out 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse createDefaultYearSubleasePlan(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0123Event event = (EesEqr0123Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		CommonBCImpl commonImpl = new CommonBCImpl();
		EesEqr0123ConditionVO conditionVO = event.getEesEqr123ConditionVO();
		
    	List<String> countWeek = new ArrayList<String>();
		
		try{
        	if(conditionVO.getFmToAt().equals("1")) {
        		countWeek = commonImpl.searchWeek(conditionVO.getFmPlnYr()).getList();
        	}
        	if(conditionVO.getFmToAt().equals("2")) {
        		countWeek = commonImpl.searchWeek(conditionVO.getAtPlnYr()).getList();
        	}
			
			begin();
			command.createDefaultYearSubleasePlan(conditionVO, countWeek, account);
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
     * Sublease Out 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyDefaultYearSubleasePlan(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0123Event event = (EesEqr0123Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		
		try{
			begin();
			command.modifyDefaultYearSubleasePlan(event.getEqrSubleaseVOS(), account);
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
	 * Red Light Alert 기준 조회/수정---컨테이너 이송 계획 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchCntrRepoPlanRLAThreshold(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepoThresholdManageBC command = new RepoThresholdManageBCImpl();
		CommonBCImpl commonImpl = new CommonBCImpl();
		
		try{
			List<SearchRepoPlanRLAThresholdVO> list = command.searchCntrRepoPlanRLAThreshold();
			eventResponse.setRsVoList(list);
			
			String[] maxArr = commonImpl.searchMaxInfo("EQR_REPO_PLN_RED_LGT_ALT_MST", "").getResultStrArray();
			eventResponse.setETCData("userid", maxArr[0]);
			eventResponse.setETCData("date", maxArr[1]);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Red Light Alert 기준 조회/수정---컨테이너 이송 계획 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchCntrRepoPlanRLADTLThreshold(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0044Event event = (EesEqr0044Event)e;
		RepoThresholdManageBC command = new RepoThresholdManageBCImpl();
		String rccCd = event.getRccCd();
		String tpsz = event.getTpsz();
		
		try{
			CommonRsVO rsVO = command.searchCntrRepoPlanRLADTLThreshold(rccCd, tpsz);
			eventResponse.setRsVo(rsVO.getDbRowset());
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
     * Red Light Alert 기준 조회/수정---컨테이너 이송 계획 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCntrRepoPlanRLAThreshold(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0044Event event = (EesEqr0044Event)e;
		RepoThresholdManageBC command = new RepoThresholdManageBCImpl();
		
		try{
			begin();
			command.modifyCntrRepoPlanRLAThreshold(event.getEqrRepoPlnRedLgtAltMstVOS(), account);
			command.modifyCntrRepoPlanRLADTLThreshold(event.getEqrRepoPlnRedLgtAltDtlVOS(), account);
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
	 * 실행 계획 Feedback 기준 설정 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	//@SuppressWarnings("deprecation")
	private EventResponse searchExecutionFeedback(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0058Event event = (EesEqr0058Event)e;
		RepoThresholdManageBC command = new RepoThresholdManageBCImpl();
		CommonBCImpl commonImpl = new CommonBCImpl();
		String tpsz = event.getTpszall();
		
		try{
			CommonRsVO rsVO = command.searchExecutionFeedback(tpsz);
			
			eventResponse.setRsList(rsVO.getRsList());
			
			String[] maxArr = commonImpl.searchMaxInfo("EQR_REPO_EXE_PLN_FB", "").getResultStrArray();
			eventResponse.setETCData("upd_usr_id", maxArr[0]);
			eventResponse.setETCData("upd_dt", maxArr[1]);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * 실행 계획 Feedback 기준 설정 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiExecutionFeedback(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0058Event event = (EesEqr0058Event)e;
		RepoThresholdManageBC command = new RepoThresholdManageBCImpl();
		
		try{
			begin();
			command.multiExecutionFeedback(event.getEqrRepoExePlnFbVOS(), account);
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
	 * 실행 계획 Feedback 기준 설정 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiExecutionFeedbackExpt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0058Event event = (EesEqr0058Event)e;
		RepoThresholdManageBC command = new RepoThresholdManageBCImpl();
		
		try{
			begin();
			command.multiExecutionFeedbackExpt(event.getEqrRepoExePlnFbExptVOS(), account);
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
	 * Red Light Alert 기준 조회/수정---컨테이너 수급 예측 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchCntrForecastRLAThreshold(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0035Event event = (EesEqr0035Event)e;
		RepoThresholdManageBC command = new RepoThresholdManageBCImpl();
		CommonBCImpl commonImpl = new CommonBCImpl();
		String tpsz = event.getTpsz();
		
		try{
			CommonRsVO rsVO = command.searchCntrForecastRLAThreshold(tpsz);
			eventResponse.setRsVo(rsVO.getDbRowset());
			
			String[] maxArr = commonImpl.searchMaxInfo("EQR_OB_FCAST_RED_LGT_ALT", "").getResultStrArray();
			eventResponse.setETCData("userid", maxArr[0]);
			eventResponse.setETCData("date", maxArr[1]);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Red Light Alert 기준 조회/수정---컨테이너 수급 예측 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCntrForecastRLAThreshold(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0035Event event = (EesEqr0035Event)e;
		RepoThresholdManageBC command = new RepoThresholdManageBCImpl();
		
		try{
			begin();
			command.modifyCntrForecastRLAThreshold(event.getEqrObFcastRedLgtAltVOS(), account);
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
	 * Holiday Effect 조회 이벤트 처리<br>
	 * ScenarioDefaultManage 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchDefaultHolidayEffectInfo(Event e) throws EventException {		
		EesEqr0042Event event = (EesEqr0042Event)e;        // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 사용자 요청의 결과(List, 객체, 값 등)을 담은 객체
		String condition="";
		try {
			ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
			
			String stPlnYrwk = event.getConditionVO().getStPlnYr() + event.getConditionVO().getStPlnWk();
			String endPlnYrwk = event.getConditionVO().getEndPlnYr() + event.getConditionVO().getEndPlnWk();
			
			condition = "SQL|"+stPlnYrwk.trim()+"|"+endPlnYrwk.trim();
			
			CommonBCImpl commonImpl = new CommonBCImpl();
			String[] maxArr = commonImpl.searchMaxInfo("EQR_HOLIDAY", condition).getResultStrArray();  // max search
			List<SearchEqrHolidayEffectVO> list = command.searchDefaultHolidayEffectInfo(event.getConditionVO());
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("upd_usr_id", maxArr[0]);
			eventResponse.setETCData("upd_dt", maxArr[1]);
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	} 

	/**
	 * Holiday Effect Detail 조회/수정 조회 이벤트 처리<br>
	 * ScenarioDefaultManage 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchDefaultHolidayEffectDetailInfo(Event e) throws EventException {		
		EesEqr0042Event event = (EesEqr0042Event)e;        // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();                  // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EesEqr0042ConditionVO condiVo  = event.getConditionVO();
		String[] yrwkArr = null;
		String newHolidayTitle = "";
		try {
			ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
			String stHolYr = condiVo.getStHolYr();
			String endHolYr = condiVo.getEndHolYr();
			String stHolWk = condiVo.getStHolWk();
			String endHolWk = condiVo.getEndHolWk();
			
			CommonBCImpl commonImpl = new CommonBCImpl();
			yrwkArr = commonImpl.newHolidaySelect(stHolYr, endHolYr, stHolWk, endHolWk).getResultStrArray();			
			newHolidayTitle = commonImpl.getNewHolidayTitle();			
			
			// etc DATA setting
			condiVo.setWkInfo(yrwkArr);	
			condiVo.setNewHolidayTitle(newHolidayTitle);
			//eventResponse = command.searchDefaultHolidayEffectDetailInfo(event);
			ScenarioDefaultManageRsVO scenarioDefaultManageRsVO2 = command.searchDefaultHolidayEffectDetailInfo2(event.getConditionVO());
			ScenarioDefaultManageRsVO scenarioDefaultManageRsVO3 = command.searchDefaultHolidayEffectDetailInfo3(event.getConditionVO());
			List<DBRowSet> rsVoList = new ArrayList<DBRowSet>();
			rsVoList.add(scenarioDefaultManageRsVO2.getDBRowSet());
			rsVoList.add(scenarioDefaultManageRsVO3.getDBRowSet());
			eventResponse.setETCData("title", event.getConditionVO().getNewHolidayTitle());
			eventResponse.setRsList(rsVoList);
			
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	} 	

	/**
     * EES_EQR_042Event HolidayEffect <br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
    */	
	public EventResponse modifyDefaultHolidayEffectInfo(Event e) throws EventException {
		EesEqr0042Event event = (EesEqr0042Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 			
		EesEqr0042ConditionVO condiVo = event.getConditionVO();
		try { 
			ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
			// CommonBCImpl MaxUpdate , MaxUserid 사용안함  확인 필요
			//*
			String condition="";
			String stPlnYrwk = condiVo.getStPlnYr() + condiVo.getStPlnWk();
			String endPlnYrwk = condiVo.getEndPlnYr() + condiVo.getEndPlnWk();
			condition = "SQL|"+stPlnYrwk.trim()+"|"+endPlnYrwk.trim();
			CommonBCImpl commonImpl = new CommonBCImpl();
			String[] maxArr = commonImpl.searchMaxInfo("EQR_HOLIDAY", condition).getResultStrArray();  // max search
			
			condiVo.setMaxUpdate(maxArr[1]);
			condiVo.setMaxUserid(maxArr[0]);
			begin();
			command.modifyDefaultHolidayEffectInfo( event.getEqrHolidayVOS() , account);      
			commit();
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
    }	
	
	/**
	 * EES_EQR_042Event 수정로직 처
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	public EventResponse modifyDefaultHolidayEffectDetailInfo(Event e) throws EventException {		
		EesEqr0042Event event = (EesEqr0042Event)e;
		try {
			ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
			
			begin();
			command.modifyDefaultHolidayEffectDetailInfo(event.getEqrHolEffRtoVOS() , account);      
			commit();
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return this.searchDefaultHolidayEffectInfo(e);
    }	
	
	/**
	 * 연간 신조 계획 조회/수정<br>
	 * ScenarioDefaultManage의 event에 대한 특정 리스트 조회 이벤트 처리<br> BC 로직 제거함 09.07.22
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchDefaultYearNewVanPlanMonthWeekInfo(Event e) throws EventException {		
		EesEqr0121Event event = (EesEqr0121Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();           // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EesEqr0121ConditionVO condiVO = event.getConditionVO();

		String[] monthInfo = null;    
        String[] weekInfo = null;   
		try {
			String year = condiVO.getYear();
			CommonBCImpl commonImpl = new CommonBCImpl();
			
			// 해당년도의 최대,최소 주차정보 (53,01)
			String[] maxminWeek = commonImpl.getMinMaxWeek(year).getResultStrArray();  
			String[] conStr = {year, maxminWeek[1], "01", year, maxminWeek[0], "12"};			
									
			monthInfo = commonImpl.tiltelMakMonth(conStr).getResultStrArray();	
			weekInfo  = commonImpl.tiltelMakWeek(conStr).getResultStrArray();	
                        
			condiVO.setMonthInfo(monthInfo[0]);
			condiVO.setWeekInfo(weekInfo[0]);
			condiVO.setWeekTitleInfo(weekInfo[1]);
			eventResponse.setETCData("monthSaveInfo", condiVO.getMonthInfo());
			eventResponse.setETCData("weekSaveInfo", condiVO.getWeekInfo());
			eventResponse.setETCData("weekTitleInfo", condiVO.getWeekTitleInfo());
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * 연간 신조 계획 조회/수정<br>
	 * ScenarioDefaultManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchDefaultYearNewvanPlan(Event e) throws EventException {		
		EesEqr0121Event event = (EesEqr0121Event)e;        // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();                   // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EesEqr0121ConditionVO condiVO = event.getConditionVO();
		ScenarioDefaultManageRsVO retVo = null;
		String[] monthInfo = null;    
        String[] weekInfo  = null;  
        String eccWhereCondition = "";
		try {
			ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
			CommonBCImpl commonImpl = new CommonBCImpl();
			
			// 해당년도의 최대,최소 주차정보 (53,01)
			String[] maxminWeek = commonImpl.getMinMaxWeek(condiVO.getYear()).getResultStrArray();			
			String[] conStr = {condiVO.getYear(), maxminWeek[1], "01", condiVO.getYear(), maxminWeek[0], "12"};						
			
			monthInfo = commonImpl.tiltelMakMonth(conStr).getResultStrArray();	
			weekInfo  = commonImpl.tiltelMakWeek(conStr).getResultStrArray();	
			if(monthInfo != null && monthInfo.length > 0)
            	condiVO.setMonthInfo(monthInfo[0]);
            if(weekInfo != null && weekInfo.length > 0){
            	condiVO.setWeekInfo(weekInfo[0]);
            	condiVO.setWeekTitleInfo(weekInfo[1]);
            }
            
			if(!condiVO.getStatus().equals("")) {
				eccWhereCondition = commonImpl.convertECCInfoString(condiVO.getStatus(), condiVO.getLocation()).getResultString();
				String[] eccSArr  = eccWhereCondition.split(",");
				ArrayList<String> eccArr = new ArrayList<String>(); // 밸로시티에서 배열의 사이즈 확인을 위해 ArrayList 로 변환
				for(int i = 0 ; eccSArr != null && i < eccSArr.length ; i++){
					eccArr.add(eccSArr[i]);
				}
				condiVO.setEccArr(eccArr);
			}	
			retVo = command.searchDefaultYearNewvanPlan(event.getConditionVO()); // 결과 데이터 와 EesEqr121ConditionVO 의 ETC 데이터가 setting 된다.

            // 최종 수정일, 최종수정자 
            String[] maxArr  = commonImpl.searchMaxInfo("EQR_NEW_VAN_LONG_TERM", "").getResultStrArray();
            // etc DATA setting
            condiVO.setMaxUpdate(maxArr[1]);  
            condiVO.setMaxUserid(maxArr[0]);
			eventResponse.setRs(retVo.getDBRowSet());
			eventResponse.setETCData("userid", condiVO.getMaxUserid());
			eventResponse.setETCData("date", condiVO.getMaxUpdate());
			eventResponse.setETCData("monthSaveInfo", condiVO.getMonthInfo());
			eventResponse.setETCData("weekSaveInfo", condiVO.getWeekInfo());
			eventResponse.setETCData("weekTitleInfo", condiVO.getWeekTitleInfo());
			
			
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * 연간 Week 신조 계획 조회/수정<br>
	 * ScenarioDefaultManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchDefaultWeekNewvanPlan(Event e) throws EventException {		
		EesEqr0121Event event = (EesEqr0121Event)e;        // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();                  // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EesEqr0121ConditionVO condiVO = event.getConditionVO();
        String[] weekInfo  = null;  
        String eccWhereCondition = "";
		try {
			ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
			CommonBCImpl commonImpl = new CommonBCImpl();
			
			// 해당년도의 최대,최소 주차정보 (53,01)
			String[] maxminWeek = commonImpl.getMinMaxWeek(condiVO.getYear()).getResultStrArray();			
			String[] conStr = {condiVO.getYear(), maxminWeek[1], "01", condiVO.getYear(), maxminWeek[0], "12"};						
						
			weekInfo  = commonImpl.tiltelMakWeek(conStr).getResultStrArray();	
			if(weekInfo != null && weekInfo.length > 0){
            	condiVO.setWeekInfo(weekInfo[0]);
            	condiVO.setWeekTitleInfo(weekInfo[1]);
			}
			if(!condiVO.getStatus().equals("")) {
				eccWhereCondition = commonImpl.convertECCInfoString(condiVO.getStatus(), condiVO.getLocation()).getResultString();
				String[] eccSArr  = eccWhereCondition.split(",");
				ArrayList<String> eccArr = new ArrayList<String>(); // 밸로시티에서 배열의 사이즈 확인을 위해 ArrayList 로 변환
				for(int i = 0 ; eccSArr != null && i < eccSArr.length ; i++){
					eccArr.add(eccSArr[i]);
				}
				condiVO.setEccArr(eccArr);
			}	
			ScenarioDefaultManageRsVO retVo = command.searchDefaultWeekNewvanPlan(event.getConditionVO());
			eventResponse.setRs(retVo.getDBRowSet());
			eventResponse.setETCData("weekSaveInfo", condiVO.getWeekSaveInfo());
			eventResponse.setETCData("weekTitleInfo", condiVO.getWeekTitleInfo());
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * 연간 Year 신조 계획 수정 이벤트 처리<br>
	 * ScenarioDefaultManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse modifyDefaultYearNewvanPlan(Event e) throws EventException {		
		EesEqr0121Event event = (EesEqr0121Event)e;        // PDTO(Data Transfer Object including Parameters)	
        String monthInCount = "";
        String[][] monthWeek = null;   // month week 2중배열 (저장, 입력시 사용됨)
        EesEqr0121ConditionVO condiVO = event.getConditionVO();
		
		try {
			ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
			// month week 2중배열 (저장, 입력시 사용됨) 생성
        	CommonBCImpl commonImpl = new CommonBCImpl();
			String[] maxminWeek = commonImpl.getMinMaxWeek(condiVO.getYear()).getResultStrArray();	
			String[] conStr = {condiVO.getYear(), maxminWeek[1], "01", condiVO.getYear(), maxminWeek[0], "12"};									

			monthInCount= commonImpl.monthCount(conStr).getResultString();
			String[] monthCount = monthInCount.split(",");
			String[] monthSaveInfo = (String[])condiVO.getMonthArr();
			String[] weekSaveInfo  = (String[])condiVO.getWeekArr();
			int weekCount = 0;
			
			monthWeek = new String[monthSaveInfo.length][];
        	for(int i=0; i<monthSaveInfo.length; i++) {
        		monthWeek[i] = new String[Integer.parseInt(monthCount[i])];
        		
        		for(int j=0; j<Integer.parseInt(monthCount[i]); j++) {
         			monthWeek[i][j] = weekSaveInfo[weekCount + j];
        		}
        		
        		weekCount = weekCount + Integer.parseInt(monthCount[i]);
        	}
        	
			begin();
			command.modifyDefaultYearNewvanPlan(condiVO,event.getEqrNewVanLongTermVOS(),account,monthWeek);
			commit();
						
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return this.searchDefaultYearNewvanPlan(event);  // 필수 
	}		
	
	/**
	 * 연간 Week 신조 계획 수정 이벤트 처리<br>
	 * ScenarioDefaultManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse modifyDefaultWeekNewvanPlan(Event e) throws EventException {		
		EesEqr0121Event event = (EesEqr0121Event)e;        // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();                  // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		
		try {
			ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
			
			begin();
			command.modifyDefaultWeekNewvanPlan(event.getConditionVO(),event.getEqrNewVanLongTermVOS(),account);
			commit();
						
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return (eventResponse);
	}		

	/**
	 * ECC Link 정보 조회<br>
	 * ScenarioDefaultManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchDefaultECCLinkInfo(Event e) throws EventException {		
		EesEqr0116Event event = (EesEqr0116Event)e; // PDTO(Data Transfer Object including Parameters) 개체를 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse(); // 사용자 요청의 결과(List, 객체, 값 등)을 담은 객체
		String fromLocation = "";
		String toLocation = "";
		try {
			ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
			CommonBCImpl commonImpl = new CommonBCImpl();
			if(!event.getConditionVO().getFromStatus().equals("")) {
				fromLocation = commonImpl.convertECCInfoString(event.getConditionVO().getFromStatus(), event.getConditionVO().getFromLocation()).getResultString();
			}
			if(!event.getConditionVO().getToStatus().equals("")) {
				toLocation = commonImpl.convertECCInfoString(event.getConditionVO().getToStatus(), event.getConditionVO().getToLocation()).getResultString();
			}		
			ArrayList<String> fromEccAL = new ArrayList<String>();
			String[] fromEccArr = fromLocation.split(",");
			for(int i = 0 ; fromEccArr != null && i < fromEccArr.length ; i++){
				fromEccAL.add(fromEccArr[i]);
			}
			ArrayList<String> toEccAL = new ArrayList<String>();
			String[] toEccArr = toLocation.split(",");
			for(int i = 0 ; toEccArr != null && i < toEccArr.length ; i++){
				toEccAL.add(toEccArr[i]);
			}
			List<EqrEccLnkVO> list = command.searchDefaultECCLinkInfo(event.getConditionVO(),fromEccAL,toEccAL);
			eventResponse.setRsVoList(list);
			String[] maxArr = commonImpl.searchMaxInfo("EQR_ECC_LNK", "").getResultStrArray();
			eventResponse.setETCData("userid", maxArr[0]);
			eventResponse.setETCData("date", maxArr[1]);
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * ECC Link 정보 수정<br>
	 * ScenarioDefaultManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse modifyDefaultECCLinkInfo(Event e) throws EventException {		
		EesEqr0116Event event = (EesEqr0116Event)e; // PDTO(Data Transfer Object including Parameters) 개체를 담은 객체		
		GeneralEventResponse eventResponse = new GeneralEventResponse();          // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		
		try {
			ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
			command.modifyDefaultECCLinkInfo(event.getEqrEccLnkVOS(),account);
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}		
	

	/**
	 * 조회 이벤트 처리<br>
	 * RepoThresholdManage event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrRepoPlanInputDataRLAThreshold() throws EventException {
		RepoThresholdManageRsVO retVO=null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();          // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		try {
			RepoThresholdManageBC command = new RepoThresholdManageBCImpl();
			retVO = command.searchCntrRepoPlanInputDataRLAThreshold();
			eventResponse.setRs(retVO.getDBRowSet());
			CommonBCImpl commonImpl = new CommonBCImpl();
		    String[] maxArr = commonImpl.searchMaxInfo("EQR_INP_DAT_RED_LGT_ALT", "").getResultStrArray();  // max search
		    eventResponse.setETCData("upd_usr_id",maxArr[0]);
		    eventResponse.setETCData("upd_dt",maxArr[1]);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * EesEqr0001Event RepoThresholdManage event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiCntrRepoPlanInputDataRLAThreshold(Event e) throws EventException {
		EesEqr0001Event event = (EesEqr0001Event)e;
		
		try {
			EqrInpDatRedLgtAltVO[] vos = event.getEqrInpDatRedLgtAltVOS();
			begin();
			RepoThresholdManageBC command = new RepoThresholdManageBCImpl();
			command.multiCntrRepoPlanInputDataRLAThreshold(vos,account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return this.searchCntrRepoPlanInputDataRLAThreshold();
	}
	
	/**
	 * [EES_EQR_0043 : Turn Time 조회]<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDefaultCntrTurnTimeInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0043Event event = (EesEqr0043Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();		
		CommonBCImpl commonImpl = new CommonBCImpl();
		String[] maxInfo =null;
		CommonRsVO commonRsVO = null;
		
		try{
			commonRsVO = command.searchDefaultCntrTurnTimeInfo(event.getEesEqr0043ConditionVO());
			eventResponse.setRsVo(commonRsVO.getDbRowset());
			
			// 가장 최근의 수정자와 수정일 Setting 
			maxInfo = commonImpl.searchMaxInfo("EQR_ECC_TURN_TM", "").getResultStrArray();
			eventResponse.setETCData("userid", maxInfo[0]);
			eventResponse.setETCData("date", maxInfo[1]);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * [EES_EQR_0043 : Turn Time 수정 및 삭제]
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyDefaultCntrTurnTimeInfo (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0043Event event = (EesEqr0043Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		try{
			begin();
			command.modifyDefaultCntrTurnTimeInfo(event.getEqrEccTurnTmVOS(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * [EES_EQR_0119 : S/T Off Hire 조회]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDefaultSTOffHireInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0119Event event = (EesEqr0119Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();		
		CommonBCImpl commonImpl = new CommonBCImpl();
		String[] maxInfo =null;
		CommonRsVO commonRsVO = null;
		String eccWhereCondition = "";
		
		try{
			// 3개미만 검색조건 Event에서 가져와서 prameter로 넘김.
			String status	= event.getStatus();
			String location = event.getLocation();
			String tpsztype = event.getTpsztype();
			
			// 검색조건의 location을 ECC로 변환하여 가져오기.
			if(!status.equals("")) {
				eccWhereCondition = commonImpl.convertECCInfo(status, location).getResultString();
			}
			
			commonRsVO = command.searchDefaultSTOffHireInfo(status, eccWhereCondition, tpsztype);
			eventResponse.setRsVo(commonRsVO.getDbRowset());
			
			// 가장 최근의 수정자와 수정일 Setting 
			maxInfo = commonImpl.searchMaxInfo("EQR_SHRT_TERM_OFFH_COND", "").getResultStrArray();
			eventResponse.setETCData("userid", maxInfo[0]);
			eventResponse.setETCData("date", maxInfo[1]);			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * [EES_EQR_0119 : S/T Off Hire 수정, 삭제]<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyDefaultSTOffHireInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0119Event event = (EesEqr0119Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		try{
			begin();
			command.modifyDefaultSTOffHireInfo(event.getEqrShrtTermOffhCondVOS(),account);
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
	 * [EES_EQR_0124 : Cabotage & HJS Rule 조회]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDefaultEmptyRepoConstraintInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0124Event event = (EesEqr0124Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();		
		CommonBCImpl commonImpl = new CommonBCImpl();
		String[] maxInfo =null;
		CommonRsVO commonRsVO = null;
		try{
			// 검색조건 4개미만 
			String cnsttype = event.getCnsttype();
			String tpsztype = event.getTpsztype();
			
			commonRsVO = command.searchDefaultEmptyRepoConstraintInfo(cnsttype, tpsztype);
			eventResponse.setRsVo(commonRsVO.getDbRowset());
			
			// 가장 최근의 수정자와 수정일 Setting 
			maxInfo = commonImpl.searchMaxInfo("EQR_REPO_CNST", "").getResultStrArray();
			eventResponse.setETCData("userid", maxInfo[0]);
			eventResponse.setETCData("date", maxInfo[1]);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * [EES_EQR_0124 : Cabotage & HJS Rule 수정, 삭제]<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyDefaultEmptyRepoConstraintInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0124Event event = (EesEqr0124Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		try{
			begin();
			command.modifyDefaultEmptyRepoConstraintInfo(event.getEqrRepoCnstVOS(),account);
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
	 * EES_EQR_0137 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDefaultConstraintLandPod(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0137Event event = (EesEqr0137Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		CommonRsVO commonRsVORsVO = null;
		CommonBCImpl commonImpl = new CommonBCImpl();
		String[] maxInfo =null;

		try{
		
			commonRsVORsVO = command.searchDefaultConstraintLandPod(event.getEesEqr0137ConditionVO());
			eventResponse.setRsVo(commonRsVORsVO.getDbRowset());
			
			// 가장 최근의 수정자와 수정일 Setting 
			maxInfo = commonImpl.searchMaxInfo("EQR_PORT_DCHG_CNST", "").getResultStrArray();
			eventResponse.setETCData("userid", maxInfo[0]);
			eventResponse.setETCData("date", maxInfo[1]);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EES_EQR_137 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyDefaultConstraintLandPod(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0137Event event = (EesEqr0137Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		try{
			begin();
			command.modifyDefaultConstraintLandPod(event.getEqrPortDchgCnstVOS(),account);
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
	 * Multi 이벤트 처리 <br>
	 * scenariodefaultmanage의 event에 대한 특정 리스트 Multi 이벤트 처리(0034화면)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiAutoRunParameter(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0034Event event = (EesEqr0034Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		CommonBC  commonCommand = new CommonBCImpl();
		try{
			begin();
			command.multiAutoRunParameter(event.getEqrAutoRunFcastParaVO(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			List<SearchAutoRunParameterVO> list = command.searchAutoRunParameter(event.getsearchAutoRunParameter());
			eventResponse.setRsVoList(list);
			String[] maxArr = commonCommand.searchMaxInfo("EQR_AUTO_RUN_FCAST_PARA" ,"").getResultStrArray();
			eventResponse.setETCData("upd_usr_id",maxArr[0]);
			eventResponse.setETCData("upd_dt",maxArr[1]); 
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * scenariodefaultmanage의 event에 대한 특정 리스트 조회 이벤트 처리(0117화면)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDefaultCntrSafetyStock(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0117Event event = (EesEqr0117Event)e;
		
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		CommonBC  commonCommand = new CommonBCImpl();
		try{
			//List<SearchSafetyStockVO> list = command.searchDefaultCntrSafetyStock(event.getSearchSafetyStockVO() ,event.getLoc() ,event.getLoctype() , event.getTpze() ,event.getTpsztype() ,event.getTpsztypes() ,event.getLvlcd());
			CommonRsVO rsVO = command.searchDefaultCntrSafetyStock(event.getSearchSafetyStockVO() ,event.getLoc() ,event.getLoctype() , event.getTpze() ,event.getTpsztype() ,event.getTpsztypes() ,event.getLvlcd());
			String[] maxArr = commonCommand.searchMaxInfo(event.getMaxInfoTable() ,"").getResultStrArray();
			List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();
			rsVoList.add(rsVO);
			eventResponse.setRsVoList(rsVoList);
			eventResponse.setETCData("upd_usr_id",maxArr[0]);
			eventResponse.setETCData("upd_dt",maxArr[1]);  
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * scenariodefaultmanage의 event에 대한 특정 리스트 조회 이벤트 처리(0117화면)<br>
	 * level 별 수량을 검색 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDefaultCntrSafetyStockQty(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0117Event event = (EesEqr0117Event)e;
		 
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
	
		try{
			List<EesEqr0117ConditionVO> list = command.searchDefaultCntrSafetyStockQty(event.getEesEqr0117ConditionVO());
//			List<SearchMaxInfoVO> maxidInfo = commonCommand.SearchMaxInfo(searchMaxInfoVOs);
			//eventResponse.setRsVoList(list);
			eventResponse.setETCData("QTY", list.get(0).getSfstk_vol_qty());
//			searchMaxInfoVO = maxidInfo.get(0);
//			eventResponse.setETCData("upd_usr_id",searchMaxInfoVO.getMaxUsrid());
//			eventResponse.setETCData("upd_dt",searchMaxInfoVO.getMaxUpdate());  
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * Multi 이벤트 처리 <br>
	 * cenariodefaultmanage의 event에 대한 특정 리스트 Multi 이벤트 처리(0117화면)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiDefaultCntrSafetyStock(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0117Event event = (EesEqr0117Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		log.debug("=======SC");
		String lvl_cd = event.getEesEqr0117ConditionVO().getLvl_cd();
		try{
			begin();
			command.multiDefaultCntrSafetyStock(event.getEqrEccSftStkVOs(),account ,lvl_cd);
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
	 * 조회 이벤트 처리<br>
	 * scenariodefaultmanage의 event에 대한 특정 리스트 조회 이벤트 처리(0117화면)<br>
	 * level 별 수량을 검색 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDefaultYearDomesticPlan(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0122Event event = (EesEqr0122Event)e;
	    
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		CommonBC  commonCommand = new CommonBCImpl();
		try{
			ScenarioDefaultManageRsVO rsVO = command.searchDefaultYearDomesticPlan(event.getEesEqr0122ConditionVO());
			ScenarioDefaultManageRsVO rsVO1 = command.searchDefaultYearDomesticDetailPlan(event.getEesEqr0122ConditionVO());
			String[] maxArr = commonCommand.searchMaxInfo("eqr_dmst_pln" ," SUBSTR(pln_yrwk, 1, 4) = '"+ event.getEesEqr0122ConditionVO().getFmPlnYr() +"'").getResultStrArray();
			rsVO.setConditionVo(event.getEesEqr0122ConditionVO());
			rsVO1.setConditionVo(event.getEesEqr0122ConditionVO());
			List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();
			List<AbstractValueObject> rsVoList1 = new ArrayList<AbstractValueObject>();
			rsVoList.add(rsVO);
			rsVoList1.add(rsVO1);
			eventResponse.setRsVoList(rsVoList);
			eventResponse.setRsVoList(rsVoList1);
			
			eventResponse.setETCData("updUsrId",maxArr[0]);
			eventResponse.setETCData("updDt",maxArr[1]);
			eventResponse.setETCData("fmToAt2" ,event.getEesEqr0122ConditionVO().getFmToAt());
			eventResponse.setETCData("fmEccCd" ,event.getEesEqr0122ConditionVO().getFmEccCd());
			eventResponse.setETCData("toEccCd" ,event.getEesEqr0122ConditionVO().getToEccCd());
			eventResponse.setETCData("atEccCd" ,event.getEesEqr0122ConditionVO().getAtEccCd());
			}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * Multi 이벤트 처리 <br>
	 * cenariodefaultmanage의 event에 대한 특정 리스트 Multi 이벤트 처리(0122화면)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */	
	@SuppressWarnings("unchecked")
	private EventResponse createDefaultYearDomesticPlan(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0122Event event = (EesEqr0122Event)e;
		//List<EqrWkPrdVO> voList = null;
		//EqrWkPrdVO week = new EqrWkPrdVO();
		//CommonRsVO commonVO = new CommonRsVO();
		
		//CommonVO commonVO =null;
		
		List countWeek = new ArrayList();
	    List month = event.getMonth();
	        
	    List rsWeek = new ArrayList();	// E를 제외한 주를 담을 리스트
	    List rsCount = new ArrayList();	// E를 제외한 해당주의 수량을 담을 리스트   

	    
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		CommonBC commonCommand = new CommonBCImpl();
		try{
			begin();
	    	if(event.getEesEqr0122ConditionVO().getFmToAt().equals("1")) {
        		countWeek = commonCommand.searchWeek(event.getEesEqr0122ConditionVO().getFmPlnYr()).getList();
        	}
        	if(event.getEesEqr0122ConditionVO().getFmToAt().equals("2")) {
        		countWeek = commonCommand.searchWeek(event.getEesEqr0122ConditionVO().getFmPlnYr()).getList();
        	}
        	
			// 52,53주까지 카운트될 변수
        	int iWeek = 1;
        	
        	/* rsWeek 를 셋팅한다. */
        	for( int i=0; i < month.size(); i++ ) {
        		int monthWeek = Integer.parseInt((String)countWeek.get(i));	// 월당 주개수
        		
        		// E를 제외한 해당주를 담는다.
        		if(!((String)month.get(i)).equals("E")) {	
        			for( int j = 0; j < monthWeek; j++ ) {
        				 log.debug("=====month==E" +iWeek);
        				rsWeek.add(new Integer(iWeek));
        				iWeek++;
        			}
        		}
        		else {
        			for( int j = 0; j < monthWeek; j++ ) {
        				iWeek++;
        			}
        		}
        	}     
        	
        	/* rsCount 를 셋팅한다. */
        	for( int i = 0 ; i < month.size() ; i++ ) {
        		if(!((String)month.get(i)).equals("E")) {	
        			int monthQty  = Integer.parseInt((String)month.get(i));		// 월당 총수량
    				int monthWeek = Integer.parseInt((String)countWeek.get(i)); // 월당 주개수
    	
    				// 월당 총수량 / 월당 주개수
    				int countPerWeek = monthQty / monthWeek;
    	
    				// 마지막 주 개수 : 총 개수에서 총 주개수-1 의 총수량을 뺀 수량.
    				int countLastWeek = monthQty - countPerWeek * (monthWeek-1);
    				
    				for( int j = 0 ; j < (monthWeek - 1) ; j++ ) {
    					rsCount.add(new Integer(countPerWeek));
    				}
    				rsCount.add(new Integer(countLastWeek));
    			}
        	}        	
		
			// 2. EQR_SCNR_DMST Table 삭제하고 EQR_DMST_PERF를 조회하여 월별 수량을 등록한다.
			command.createDefaultYearDomesticPlan(event.getEqrDmstPlnVOs(),event.getEesEqr0122ConditionVO(),rsCount ,rsWeek ,account);
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
	 * Multi 이벤트 처리 <br>
	 * cenariodefaultmanage의 event에 대한 특정 리스트 Multi 이벤트 처리(122화면)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyDefaultYearDomesticPlan(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0122Event event = (EesEqr0122Event)e;
		
		
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		try{
			begin();
			command.modifyDefaultYearDomesticPlan(event.getEqrDmstPlnVOs(),event.getEesEqr0122ConditionVO(),account);
			//eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
}