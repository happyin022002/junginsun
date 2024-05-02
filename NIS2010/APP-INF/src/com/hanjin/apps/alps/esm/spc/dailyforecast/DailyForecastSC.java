/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DailyForecastSC.java
*@FileTitle : DailyForecast
*Open Issues :
*Change history :
*2008-03-06 김원섭
* CSR : N200803110001   T/S booking 조회 화면 개발
* 2008-03-20 서관영
* CSR : N200802185179 
* Forecast Histroy 화면 개발  - by Office,by Account  
*
* 2008-09-30 임옥영 CSR:N200809109297
*   -FCAST Input 화면(ESM_SPC_102)에서 Data변경없이 SAVE할수 있도록
*    updateDailyForcastForHistory(Event) 추가 
*@LastModifyDate : 2009.07.23
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.07.23 한상훈
* 1.0 Creation
* 2011.11.10 김종준 [CHM-201114445-01] f"cast history 화면 RGN Office 창 활성화
* 2013.01.04 최윤성 [CHM-201322312-01] FCST Input(SELSA) 2차 수정요청
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.05.20 진마리아 [CHM-201324741-01] Lane Office POL 화면 로직 보완 - validation 및 error handling
* 2013.08.14 [Trouble shooting] Accum 팝업 내 Period 변경 가능하도록 수정
* 2013.10.17 [CHM-201325350] Split 04-영업지원 Application 개발 요청
* 2014.11.14 신자영 [CHM-201432770] T/S Booking Report 개선
* 2015.11.19 이혜민 [CHM-201538569] FCST Input > Account Add/Del 사용시 Data 확인 및 팝업처리 요청 
* 2016.04.01 이혜민 [CHM-201640539] ALPS Live Out Of Memory Error 확인 및 조치 요청(Sales Rep이 몇 개의 Account를 체크했는지 개수 조회)
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.spc.common.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.spc.common.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SearchOfficeCondVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.basic.BasicDataBC;
import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.basic.BasicDataBCImpl;
import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.event.EsmSpc0100Event;
import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.integration.BasicDataDBDAO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.vo.SearchDailyForcastManageByVvdListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.vo.SearchDailyForcastManageByWeekListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.basic.DailyForecastInquiryBC;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.basic.DailyForecastInquiryBCImpl;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.event.EsmSpc0072Event;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.event.EsmSpc0105Event;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.event.EsmSpc0113Event;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo.SearchTSBookingListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo.SearchTSBookingNewListRSQLVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo.SpcFcastBkgListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.basic.DailyForecastManageBC;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.basic.DailyForecastManageBCImpl;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0102Event;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0103Event;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0104Event;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0106Event;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0108Event;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0109Event;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0110Event;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0111Event;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0112Event;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0999Event;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.DailyforecastmanageMainVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchAccumulatedGuidePfmcVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchContractForecastManageListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastHistorySrepAcctListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastManageListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchLoadOfficeMappingListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchSalesRepInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcDlyFcastCustVO;


/**
 * ALPS-DailyForecast Business Logic ServiceCommand - ALPS-DailyForecast 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Han Sang Hoon
 * @see BasicDataDBDAO
 * @since J2EE 1.6
 */

public class DailyForecastSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * DailyForecast system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("DailyForecastSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * DailyForecast system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("DailyForecastSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-DailyForecast system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
//log.debug("DailyForecastSC perform Event Name : "+e.getEventName());
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmSpc0100Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchDailyForcastManageByVvdList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchDailyForcastManageByWeekList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multiDailyForcastVvdManage(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiDailyForcastManage(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkLanePortValid(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkOfficeValid(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkVvdValid(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSpc0106Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSalesRepAccountList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSalesRepAccountManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchSalesRepVolExistList(e);
			}  else{
				//if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
					eventResponse = searchSalesRepList(e);				
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSpc0105Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchTSBookingList(e);
			} else {
				eventResponse = searchSpaceAllocationOfficeCond(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSpc0113Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchTSBookingListOld(e);
			} else {
				eventResponse = searchSpaceAllocationOfficeCond(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSpc0072Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchBookingList(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsmSpc0103Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchDailyForecastSrepAccountManageList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = multiDailyForecastSrepAccountManage(e);
			}
			else {
				//log.debug("To set UI display");
				eventResponse = searchSpaceAllocationOfficeCond(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSpc0999Event")) {
			// 현재 SEARCHLIST01, MULTI01  호출되지 않지만 ENIS 같이 구현해 놓음.
//			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
//				//eventResponse = searchDailyForecastManage1List(e);
//			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchDailyForecastManage2List(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
//				//eventResponse = multiDailyForecastManage1(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multiDailyForecastManage2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = multiDailyForcastForHistory(e);
			} else {
				eventResponse = searchSpaceAllocationOfficeCond(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSpc0104Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchDailyForecastHistoryOfcList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)){
				eventResponse = searchDailyForecastHistorySrepAcctList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchUserRoleYn(e);
			} else {
				eventResponse = searchSpaceAllocationOfficeCond(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSpc0102Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiDailyForecastManageByKor(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)){				
				eventResponse = multiDailyForecastManageBySAP(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){				
				eventResponse = searchDailyForecastManageListByKor(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)){				
				eventResponse = searchSrepAccountCnt(e);	
			}else {
				eventResponse = searchSpaceAllocationOfficeCond(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSpc0108Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){				
				eventResponse = searchAccumulatedGuidePfmcList(e);	
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSpc0109Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiContractForecastManage(e);
			}else 
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){				
				eventResponse = searchContractForecastManageList(e);	
			} else {
				eventResponse = searchSpaceAllocationOfficeCond(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSpc0110Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiDailyForecastManageSwitch(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){				
				eventResponse = searchPreviousSalesRepList(e);	
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSpc0111Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiLoadOfficeMappingList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){				
				eventResponse = searchLoadOfficeMappingList(e);	
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSpc0112Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiAccountSrepList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){				
				eventResponse = searchAccountSrepList(e);	
			}
		}
		
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0111 : [이벤트]
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiLoadOfficeMappingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0111Event event = (EsmSpc0111Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();
		try{
			begin();
			command.multiLoadOfficeMappingList(event.getSpcCtrtFcastOfcMapgVOS(), account, event.getDailyforecastmanageConditionVO());
			eventResponse.setETCData("status", "OK"); 
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
	 * ESM_SPC_0111 : [이벤트]
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchLoadOfficeMappingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0111Event event = (EsmSpc0111Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();
		
		try{
			List<SearchLoadOfficeMappingListVO> rsVoList = command.searchLoadOfficeMappingList(event.getDailyforecastmanageConditionVO());
			eventResponse.setRsVoList(rsVoList);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_SPC_0112 : [이벤트]
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiAccountSrepList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0112Event event = (EsmSpc0112Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();
		try{
			begin();
			command.multiAccountSrepList(event.getSpcSlsRepCustVOS(),account);
			eventResponse.setETCData("status", "OK"); 
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
	 * ESM_SPC_0112 : [이벤트]
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchAccountSrepList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0112Event event = (EsmSpc0112Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();

		try{
			List<SearchSalesRepInfoVO> rsVoList = command.searchAccountSrepList(event.getSearchSalesRepInfoVO());
			eventResponse.setRsVoList(rsVoList);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_SPC_0110 : [이벤트]
	 * 전임 S.REP이 입력한 Forecast를 승계
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiDailyForecastManageSwitch(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0110Event event = (EsmSpc0110Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();
		try{
			begin();
			command.multiDailyForecastManageSwitch(event.getSearchDailyForecastManageListVOS(), account);
			eventResponse.setETCData("status", "OK");
			commit();
			//rollback();
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
	 * ESM_SPC_0110 : [이벤트]
	 * Forecast 승계를 위한 화주별 전임 S.REP 조회
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchPreviousSalesRepList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0110Event event = (EsmSpc0110Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();
		
		try{
			List<SearchDailyForecastHistorySrepAcctListVO> rsVoList = command.searchPreviousSalesRepList(event.getConditionVO());
			eventResponse.setRsVoList(rsVoList);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0109 : [이벤트]
	 * Contract Office에서 Forecast 입력을 위해 조회.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchContractForecastManageList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0109Event event = (EsmSpc0109Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();
		
		try{
			List<SearchContractForecastManageListVO> rsVoList = command.searchContractForecastManageList(event.getConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setViewType(event.getConditionVO().getViewType());
			}
			eventResponse.setRsVoList(rsVoList);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_SPC_0106 : [이벤트]
	 * 한국지점 - Sales Rep별 Account 정보를 관리한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiSalesRepAccountManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0106Event event = (EsmSpc0106Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();
		try{
			begin();
			command.multiSalesRepAccountManage(event.getSpcSlsRepCustVOS(),account);
			eventResponse.setETCData("status", "OK");
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
	 * ESM_SPC_0106 : [이벤트]
	 * 한국지점 - Sales Rep별 Account 정보를 조회한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSalesRepAccountList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0106Event event = (EsmSpc0106Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();

		try{
			List<SearchSalesRepInfoVO> rsVoList = command.searchSalesRepAccountList(event.getSearchSalesRepInfoVO());
			eventResponse.setRsVoList(rsVoList);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_SPC_0106 : [이벤트]
	 * 한국지점 - Sales Rep 정보를 조회한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSalesRepList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0106Event event = (EsmSpc0106Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();

		try{
			List<SearchSalesRepInfoVO> rsVoList = command.searchSalesRepList(event.getSearchSalesRepInfoVO());
			eventResponse.setRsVoList(rsVoList);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_SPC_0106 : SEARCHLIST03
	 * Individual 을 언체크 할경우 해당 S.Rep, 화주, S.office 에 이번주 이후에 물량을 준게 있는지 확인한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSalesRepVolExistList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0106Event event = (EsmSpc0106Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();
		String list = "";
		StringBuffer listTtl = new StringBuffer();
		
		try{
			List<String> rsList = command.searchSalesRepVolExistList(event.getSearchSalesRepInfoVO());
			if(rsList.size()>0){
				for(int i=0; i<rsList.size(); i++){
					listTtl.append("/\n");
					listTtl.append(rsList.get(i));
					list = listTtl.toString();
				}
			}
			eventResponse.setETCData("VolExistWk", list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0104 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDailyForecastHistoryOfcList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0104Event event = (EsmSpc0104Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();

		try{
			List<DailyforecastmanageMainVO> rsVoList = command.searchDailyForecastHistoryOfcList(event.getDailyforecastmanageConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST01");
			}
			eventResponse.setRsVoList(rsVoList);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0104 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDailyForecastHistorySrepAcctList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0104Event event = (EsmSpc0104Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();

		try{
			List<DailyforecastmanageMainVO> rsVoList = command.searchDailyForecastHistorySrepAcctList(event.getDailyforecastmanageConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST02");
			}
			eventResponse.setRsVoList(rsVoList);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * ESM_SPC_0103 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiDailyForecastSrepAccountManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0103Event event = (EsmSpc0103Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();
		try{
			begin();
			command.multiDailyForecastSrepAccountManage(event.getSpcSlsRepCustMapgVOS(),account);
			eventResponse.setETCData("status", "OK");
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
	 * ESM_SPC_0103 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDailyForecastSrepAccountManageList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0103Event event = (EsmSpc0103Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();

		try{
			List<DailyforecastmanageMainVO> rsVoList = command.searchDailyForecastSrepAccountManageList(event.getDailyforecastmanageConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST");
			}
			eventResponse.setRsVoList(rsVoList);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * ESM_SPC_0105 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTSBookingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0105Event event = (EsmSpc0105Event)e;
		DailyForecastInquiryBC command = new DailyForecastInquiryBCImpl();

		try{
			List<SearchTSBookingNewListRSQLVO> list = command.searchTSBookingList(event.getSearchTSBookingListConditionVO());
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
	 * ESM_SPC_0113 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTSBookingListOld(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0113Event event = (EsmSpc0113Event)e;
		DailyForecastInquiryBC command = new DailyForecastInquiryBCImpl();

		try{
			List<SearchTSBookingListVO> list = command.searchTSBookingListOld(event.getSearchTSBookingListConditionVO());
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
	 * ESM_SPC_0072 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBookingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0072Event event = (EsmSpc0072Event)e;
		DailyForecastInquiryBC command = new DailyForecastInquiryBCImpl();

		try{
			List<SpcFcastBkgListVO> list = command.searchBookingList(event.getSearchTSBookingListConditionVO());
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
	 * ESM_SPC_0100 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDailyForcastManageByVvdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0100Event event = (EsmSpc0100Event)e;
		BasicDataBC command = new BasicDataBCImpl();

		try{
			List<SearchDailyForcastManageByVvdListVO> list = command.searchDailyForcastManageByVvdList(event.getSearchDailyForcastManageByVvdListConditionVO());
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
	 * ESM_SPC_0100 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDailyForcastManageByWeekList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0100Event event = (EsmSpc0100Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
			List<SearchDailyForcastManageByWeekListVO> list = command.searchDailyForcastManageByWeekList(event.getSpcFcastOfcPolMapgConditionVO());
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
	 * ESM_SPC_0100 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiDailyForcastVvdManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0100Event event = (EsmSpc0100Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		try{
			begin();
			command.multiDailyForcastVvdManage(event.getSpcIrrFcastOfcPolMapgVOS(),account);
			eventResponse.setETCData("status", "OK");
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
	 * ESM_SPC_0100 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiDailyForcastManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0100Event event = (EsmSpc0100Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		try{
			begin();
			command.multiDailyForcastManage(event.getSpcFcastOfcPolMapgVOS(),account);
			eventResponse.setETCData("status", "OK");
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
	 * ESM_SPC_0999 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDailyForecastManage2List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0999Event event = (EsmSpc0999Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();

		try{
			List<SearchDailyForecastManageListVO> list = command.searchDailyForecastManage2List(event.getConditionVO());
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
	 * ESM_SPC_0999 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiDailyForecastManage2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0999Event event = (EsmSpc0999Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();
		
		try{
			begin();
			command.multiDailyForecastManage2(event.getSpcDlyFcastCustVOS(),account);
			eventResponse.setETCData("status", "OK");
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
	 * ESM_SPC_0999 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiDailyForcastForHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0999Event event = (EsmSpc0999Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();
		
		try{
			begin();
			command.multiDailyForcastForHistory(event.getConditionVO(),account);
			eventResponse.setETCData("status", "OK");
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
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocationOfficeCond(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC command = new CommonBCImpl();
		
		try{
			List<SearchOfficeCondVO> list = command.searchOfficeCond(e, account);
			if(list.size() > 0){
				SearchOfficeCondVO searchOfficeCondVO = list.get(0);
				eventResponse.setETCData(searchOfficeCondVO.getColumnValues());
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
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserRoleYn(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC command = new CommonBCImpl();
		try{
			String ui_name = e.getEventName().substring(0, 10);
			List<SearchOfficeCondVO> list = command.searchUserRoleYn(e, account,ui_name);
			if(list.size() > 0){
				SearchOfficeCondVO searchOfficeCondVO = list.get(0);

				Map<String,String> etcData = new HashMap<String,String>();
				
				etcData.put("usrRoleYn",searchOfficeCondVO.getUsrRoleYn());
				eventResponse.setETCData(etcData);				
			}
		}catch(EventException ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	


	/**
	 * ESM_SPC_0102 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDailyForecastManageListByKor(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0102Event event = (EsmSpc0102Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();

		try{
			List<SearchDailyForecastManageListVO> list = command.searchDailyForecastManageListByKor(event.getConditionVO());
			if(list.size() > 0){
				list.get(0).setViewType(event.getConditionVO().getViewType());
			}
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
	 * ESM_SPC_0102 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiDailyForecastManageByKor(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0102Event event = (EsmSpc0102Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();
		
		try{
			begin();
			command.multiDailyForecastManageForKor(event.getSpcDlyFcastCustVOS(),account.getUsr_id());
			eventResponse.setETCData("status", "OK");
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
	 * ESM_SPC_0102 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiDailyForecastManageBySAP(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0102Event event = (EsmSpc0102Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();
		 
		try{
			begin();
			SpcDlyFcastCustVO[] vos = event.getSpcDlyFcastCustVOS();
			String usrId = null;
			if(vos.length>0){
				usrId = vos[0].getUpdUsrId();
			}else{
				throw new EventException("There is no transfered SAP data");
			}
			command.multiDailyForecastManageForKor(event.getSpcDlyFcastCustVOS(),usrId);
			//others fcast 입력시 내부에 존재하는 fcast를 0으로 update (alps는 화면내에서 control함)
			command.multiOthersFcastToZero(event.getSpcDlyFcastCustVOS(),usrId);
			eventResponse.setETCData("status", "OK");
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
	 * ESM_SPC_0102 : [Retreive 전]<br>
	 * 해당 Sales Rep이 몇 개의 Account를 체크했는지 개수를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSrepAccountCnt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0102Event event = (EsmSpc0102Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();

		try{
			String dataCnt = command.searchSrepAccountCnt(event.getConditionVO());
			
			eventResponse.setETCData("dataCnt", dataCnt);

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
	 * ESM_SPC_0108 : [이벤트]
	 * Accumulated Guide & PFMC List 를 조회
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchAccumulatedGuidePfmcList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0108Event event = (EsmSpc0108Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();
		
		try{
			List<SearchAccumulatedGuidePfmcVO> rsVoList = command.searchAccumulatedGuidePfmcList(event.getConditionVO());
			String sdate = "";
			String edate = "";
			if(rsVoList.size()>0){
				sdate = rsVoList.get(0).getSdate();
				edate = rsVoList.get(0).getEdate();
			}
			eventResponse.setETCData("sdate", sdate);
			eventResponse.setETCData("edate", edate);
			eventResponse.setRsVoList(rsVoList);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0109 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiContractForecastManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0109Event event = (EsmSpc0109Event)e;
		DailyForecastManageBC command = new DailyForecastManageBCImpl();
		
		try{
			begin();
			command.multiContractForecastManage(event.getSpcCtrtFcastCustVOS(),account);
			eventResponse.setETCData("status", "OK");
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
	 * ESM_SPC_0100 : sheet Port Change
	 * Lane, Bound 에 등록 가능한 Port인지 체크
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkLanePortValid(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0100Event event = (EsmSpc0100Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
			String flg = command.checkLanePortValid(event.getSpcFcastOfcPolMapgVO());
			eventResponse.setETCData("valid_flg", flg);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0100 : sheet Office Change
	 * Region Office 체크
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkOfficeValid(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0100Event event = (EsmSpc0100Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
			String flg = command.checkOfficeValid(event.getSpcFcastOfcPolMapgVO());
			eventResponse.setETCData("valid_flg", flg);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0100 : sheet vvd Change
	 * vvd 체크
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkVvdValid(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0100Event event = (EsmSpc0100Event)e;
		BasicDataBC command = new BasicDataBCImpl();
		
		try{
			String flg = command.checkVvdValid(event.getSpcIrrFcastOfcPolMapgVO());
			eventResponse.setETCData("valid_flg", flg);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
}
