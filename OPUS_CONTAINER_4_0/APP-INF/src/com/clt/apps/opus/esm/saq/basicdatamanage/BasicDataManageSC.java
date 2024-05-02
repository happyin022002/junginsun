/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : BasicDataManageSC.java
*@FileTitle      : BasicDataManage
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage;

import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.basic.MonthlyCustomizedConditionBC;
import com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.basic.MonthlyCustomizedConditionBCImpl;
import com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.event.EsmSaq0163Event;
import com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.basic.MonthlyTargetVVDBC;
import com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.basic.MonthlyTargetVVDBCImpl;
import com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.event.EsmSaq0040Event;
import com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.event.EsmSaq0154Event;
import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.basic.TargetGroupBC;
import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.basic.TargetGroupBCImpl;
import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.event.EsmSaq0013Event;
import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.event.EsmSaq0014Event;
import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.event.EsmSaq0170Event;
import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.integration.TargetGroupDBDAO;
import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.vo.SearchCostManagement0170ListVO;
import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.vo.SearchTargetGroup0014ListVO;
import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.vo.SearchTargetGroupTrade0013ListVO;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;



/**
 * BasicDataManage Business Logic ServiceCommand - BasicDataManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Jong-Ho Kim
 * @see TargetGroupDBDAO
 * @since J2EE 1.6
 */

public class BasicDataManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * BasicDataManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("BasicDataManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * BasicDataManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("BasicDataManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * BasicDataManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmSaq0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchTargetGroup0014List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiTargetGroup0014(e);
			}
		}		
		else if (e.getEventName().equalsIgnoreCase("EsmSaq0013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchTargetGroupTrade0013List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiTargetGroupTrade0013(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0154Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchMonthlyTargetVVDInquiry0154List01(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0163Event")) {			// Customized Conditions
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {			// 1번(Load Target - Regional Group Mapping) 탭 조회
				eventResponse = searchMonthlyCustomizedConditionTabLoadTarget0163Tab01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {	// 2번(Lane - Bound Switch) 탭 조회
				eventResponse = searchMonthlyCustomizedConditionTabLaneBound0163Tab02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {	    // 1번 탭 Save
				eventResponse = multiMonthlyCustomizedConditionTabLoadTargetSave0163Tab01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {	    // 2번 탭 Save 
				eventResponse = multiMonthlyCustomizedConditionTabLaneBoundSave0163Tab02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {	    // 2번 탭 Confirm, Cancel Confirm 
				eventResponse = updateMonthlyCustomizedConditionTabLaneBound0163Tab02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {	    // 1번 탭 Data Copy 
				eventResponse = multiMonthlyCustomizedConditionTabLoadTargetCopy0163Tab01(e);			
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {	    // 2번 탭 Data Copy 
				eventResponse = multiMonthlyCustomizedConditionTabLaneBoundCopy0163Tab02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {	    // 1번 탭 Confirm, Cancel Confirm 
				eventResponse = updateMonthlyCustomizedConditionTabLoadTarget0163Tab01(e);
			}
			//2010.05.15 Lee Sang-Yong : 아키텍쳐위배사항 수정 COMMAND0X -> MULTI0X 변경
		}
		else if (e.getEventName().equalsIgnoreCase("EsmSaq0170Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCostManagement0170List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {  
				eventResponse = multiCostManagementSave0170(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multiCostManagementCopy0170(e);
			} //2009.11.25 김종호 : 변경된 F/W에 의해 새로고침이 일어나지 않도록 COMMAND 대신 MULTI 코드로 교체
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0040Event")) {   // Target VVD/Supply Management 
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {    // Information 탭 조회
			eventResponse = searchMonthlyTargetVVD0040Tab01(e);       
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // VVD Group
			eventResponse = searchMonthlyTargetVVDGroup0040Tab02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {   // Save
			eventResponse = multiMonthlyTargetVVD0040(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {  // Confirm
			eventResponse = processConfirm0040(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {  // Cancel Confirmation
			eventResponse = processCancelConfirm0040(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {  // SKD Copy 
			eventResponse = processSKDCopy0040(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY05)) {  // SKD Copy Message생성    
			eventResponse = searchSKDCopyMessage0040(e);   
			} 
		}	
		return eventResponse;
	}


	
	/**
	 * ESM_SAQ_0154 : [이벤트]<br>
	 * [비즈니스대상]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyTargetVVDInquiry0154List01(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0154Event event = (EsmSaq0154Event)e;
		MonthlyTargetVVDBC command = new MonthlyTargetVVDBCImpl();

		try{ 
			ReturnVO list = command.searchMonthlyTargetVVDInquiry0154List01(event.getMonthlyTargetVVDInquiryConditionVO());
			eventResponse.setRsVo(list);
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
	 * ESM_SAQ_0014 : [이벤트]<br>
	 * [Traget Group Control]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTargetGroup0014List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		TargetGroupBC command = new TargetGroupBCImpl();

		try{
			List<SearchTargetGroup0014ListVO> list = command.searchTargetGroup0014List();
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
	 * ESM_SAQ_0014 : [이벤트]<br>
	 * [Traget Group Control]을 [멀티]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiTargetGroup0014(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0014Event event = (EsmSaq0014Event)e;
		TargetGroupBC command = new TargetGroupBCImpl();
		try{
			begin();
			command.multiTargetGroup0014(event.getSaqTgtGrpVOS() ,account);
			commit();
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	/**
	 * ESM_SAQ_0013 : [이벤트]<br>
	 * [Sales Quota Scope]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTargetGroupTrade0013List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0013Event event = (EsmSaq0013Event)e;
		TargetGroupBC command = new TargetGroupBCImpl();

		try{
			List<SearchTargetGroupTrade0013ListVO> list = command.searchTargetGroupTrade0013List(event.getModelConditionVO());
				
			
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
	 * ESM_SAQ_0013 : [이벤트]<br>
	 * [Sales Quota Scope]을 [멀티]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiTargetGroupTrade0013(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0013Event event = (EsmSaq0013Event)e;
		TargetGroupBC command = new TargetGroupBCImpl();

		try{
			begin();
			command.multiTargetGroupTrade0013(event.getSaqTgtGrpTrdVOS(),account);
			commit();
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
			return eventResponse;
	}

	/**
	 * ESM_SAQ_0170 : [이벤트]<br>
	 * [Year/Month Set for Cost Management ]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostManagement0170List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0170Event event = (EsmSaq0170Event)e;
		TargetGroupBC command = new TargetGroupBCImpl();

		String bse_yr = event.getBseYr();
		String bse_qtr_cd = event.getBseQtrCd();
		try{
			List<SearchCostManagement0170ListVO> list = command.searchCostManagement0170List(bse_yr, bse_qtr_cd);
			eventResponse.setRsVoList(list);		

			String existCheck = command.searchCostManagementExistCheck0170(bse_yr, bse_qtr_cd);	//Create Initial Data 버튼 활성화 유무에 대한 처리를 위해 해당 테이블에 데이터 존재 유무를 체크
			eventResponse.setETCData("existCheck", existCheck); //

			eventResponse.setETCData("status", "OK"); //메소드 실행 끝에 기존 소스의 GS단의 <RESULT>태그에서 ETC데이터를 OK로 바꿔주는 것을 이 곳에 처리  
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
	 * ESM_SAQ_0170 : [이벤트]<br>
	 * [Year/Month Set for Cost Management ]을 [멀티1]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCostManagementSave0170(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0170Event event = (EsmSaq0170Event)e;
		TargetGroupBC command = new TargetGroupBCImpl();
		try{
			begin();
			command.multiCostManagementSave0170(event.getSaqCostApplBseVOS(),account);
			commit();
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK"); //메소드 실행 끝에 기존 소스의 GS단의 <RESULT>태그에서 ETC데이터를 OK로 바꿔주는 것을 이 곳에 처리
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	/**
	 * ESM_SAQ_0170 : [이벤트]<br>
	 * [Year/Month Set for Cost Management ]을 [멀티2]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCostManagementCopy0170(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0170Event event = (EsmSaq0170Event)e;
		TargetGroupBC command = new TargetGroupBCImpl();
		
		String bse_yr = event.getBseYr();
		String bse_qtr_cd = event.getBseQtrCd();
		
		try{
			begin();
			command.multiCostManagementCopy0170(bse_yr, bse_qtr_cd, account);
			commit();
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "DataCopy"); //메소드 실행 끝에 기존 소스의 GS단의 <RESULT>태그에서 ETC데이터를 OK로 바꿔주는 것을 이 곳에 처리
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAQ_0163 : [이벤트]<br>
	 * [MonthlyCustomizedCondition]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyCustomizedConditionTabLoadTarget0163Tab01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0163Event event = (EsmSaq0163Event)e;
		MonthlyCustomizedConditionBC command = new MonthlyCustomizedConditionBCImpl();

		try{
			
			event.getMonthlyCustomizedConditionTabLoadTargetVO().setChkCommand("SEARCHLIST01");
			
			ReturnVO list = command.searchMonthlyCustomizedConditionTabLoadTarget0163Tab01(event.getMonthlyCustomizedConditionTabLoadTargetVO());
			list.setConditionVO(event.getMonthlyCustomizedConditionTabLoadTargetVO());
			eventResponse.setRsVo(list);
			
			// Status 조회
			String status = command.getMonthlyCustomizedConditionLodTargetStatus(event.getMonthlyCustomizedConditionTabLoadTargetVO());
			eventResponse.setETCData("status", status);
			
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
	 * ESM_SAQ_0163 : [이벤트]<br>
	 * [MonthlyCustomizedCondition]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyCustomizedConditionTabLaneBound0163Tab02(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0163Event event = (EsmSaq0163Event)e;
		MonthlyCustomizedConditionBC command = new MonthlyCustomizedConditionBCImpl();

	try{
		
			event.getMonthlyCustomizedConditionTabLaneBoundVO().setChkCommand("SEARCHLIST02");
			
			ReturnVO list = command.searchMonthlyCustomizedConditionTabLaneBound0163Tab02(event.getMonthlyCustomizedConditionTabLaneBoundVO());
			list.setConditionVO(event.getMonthlyCustomizedConditionTabLoadTargetVO());
			eventResponse.setRsVo(list);
			
			// Status 조회
			String status = command.getMonthlyCustomizedConditionLaneBoundStatus(event.getMonthlyCustomizedConditionTabLaneBoundVO());
			eventResponse.setETCData("status", status);
			
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
	 * ESM_SAQ_0163 : [이벤트]<br>
	 * Load Target - Regional Group Mapping Data Save <br>
	 * MonthlyCustomizedCondition에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 1tab 저장
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiMonthlyCustomizedConditionTabLoadTargetSave0163Tab01(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0163Event event = (EsmSaq0163Event)e;

		try {
			begin();			
			MonthlyCustomizedConditionBC command = new MonthlyCustomizedConditionBCImpl();
			command.multiMonthlyCustomizedConditionTabLoadTargetSave0163Tab01(event.getMonthlyCustomizedConditionTabLoadTargetVOS(),account);
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAQ_0163 : [1tab confirm]<br>
	 * Load Target - Regional Group Mapping Data confirm <br>
	 * MonthlyCustomizedCondition에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse updateMonthlyCustomizedConditionTabLoadTarget0163Tab01(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0163Event event = (EsmSaq0163Event)e;

		try {
			begin();			
			MonthlyCustomizedConditionBC command = new MonthlyCustomizedConditionBCImpl();
			command.updateMonthlyCustomizedConditionTabLoadTarget0163Tab01(event.getMonthlyCustomizedConditionTabLoadTargetVO(),account);
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_SAQ_0163 : [이벤트]<br>
	 * Load Target - Regional Group Mapping Data Copy <br>
	 * MonthlyCustomizedCondition에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiMonthlyCustomizedConditionTabLoadTargetCopy0163Tab01(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0163Event event = (EsmSaq0163Event)e;

		try {
			begin();			
			MonthlyCustomizedConditionBC command = new MonthlyCustomizedConditionBCImpl();
			String rtnVal = command.multiMonthlyCustomizedConditionTabLoadTargetCopy0163Tab01(event.getMonthlyCustomizedConditionTabLoadTargetVO(),account);
			if(!"".equals(rtnVal)) {
				eventResponse.setETCData("status", "DataCopyFail");
			}else {
				eventResponse.setETCData("status", "DataCopy");
				eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			}
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAQ_0163 : [이벤트]<br>
	 * Lane - Bound Switch Data Copy <br>
	 * MonthlyCustomizedCondition에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiMonthlyCustomizedConditionTabLaneBoundCopy0163Tab02(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0163Event event = (EsmSaq0163Event)e;

		try {
			begin();			
			MonthlyCustomizedConditionBC command = new MonthlyCustomizedConditionBCImpl();
			String rtnVal = command.multiMonthlyCustomizedConditionTabLaneBoundCopy0163Tab02(event.getMonthlyCustomizedConditionTabLoadTargetVO(),account);
			if(!"".equals(rtnVal)) {
				eventResponse.setETCData("status", "DataCopyFail");
			}else {
				eventResponse.setETCData("status", "DataCopy");
				eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			}
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAQ_0163 : [2tab 저장]<br>
	 * Lane - Bound Switch Data Save <br>
	 * MonthlyCustomizedCondition에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiMonthlyCustomizedConditionTabLaneBoundSave0163Tab02(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0163Event event = (EsmSaq0163Event)e;

		try {
			begin();			
			MonthlyCustomizedConditionBC command = new MonthlyCustomizedConditionBCImpl();
			command.multiMonthlyCustomizedConditionTabLaneBoundSave0163Tab02(event.getMonthlyCustomizedConditionTabLaneBoundVOS(),account);
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAQ_0163 : [2tab confirm]<br>
	 * Lane - Bound Switch Data confirm <br>
	 * MonthlyCustomizedCondition에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse updateMonthlyCustomizedConditionTabLaneBound0163Tab02(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0163Event event = (EsmSaq0163Event)e;

		try {
			begin();			
			MonthlyCustomizedConditionBC command = new MonthlyCustomizedConditionBCImpl();
			command.updateMonthlyCustomizedConditionTabLaneBound0163Tab02(event.getMonthlyCustomizedConditionTabLaneBoundVO(),account);
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return eventResponse;
	}	
	
	  /**
	   * ESM_SAQ_0040 : [이벤트]<br>
	   * [Target VVD/Supply Management 1tab Information]을 [조회]합니다.<br>
	   * 
	   * @param Event e
	   * @return EventResponse
	   * @exception EventException
	   */
	  private EventResponse searchMonthlyTargetVVD0040Tab01(Event e) throws EventException {
	   GeneralEventResponse eventResponse = new GeneralEventResponse();
	   EsmSaq0040Event event = (EsmSaq0040Event)e;
	   MonthlyTargetVVDBC command = new MonthlyTargetVVDBCImpl();

	   try{
		   QuotaConditionVO condition = event.getQuotaConditionVO();
		   condition.setFormCommand(e.getFormCommand());
		   ReturnVO list = command.searchMonthlyTargetVVD0040Tab01(condition);
		   eventResponse.setRsVo(list);
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
	   * ESM_SAQ_0040 : [이벤트]<br>
	   * [Target VVD/Supply Management 2tab VVD Group]을 [조회]합니다.<br>
	   * 
	   * @param Event e
	   * @return EventResponse
	   * @exception EventException
	   */
	  private EventResponse searchMonthlyTargetVVDGroup0040Tab02(Event e) throws EventException {
	   GeneralEventResponse eventResponse = new GeneralEventResponse();
	   EsmSaq0040Event event = (EsmSaq0040Event)e;
	   MonthlyTargetVVDBC command = new MonthlyTargetVVDBCImpl();

	   try{
	    QuotaConditionVO condition = event.getQuotaConditionVO();
	    condition.setFormCommand(e.getFormCommand());
	    ReturnVO list = command.searchMonthlyTargetVVDGroup0040Tab02(condition);
	    eventResponse.setRsVo(list);
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
	   * ESM_SAQ_0040 : [저장]<br>
	   * [Target VVD/Supply Management]을 [저장]합니다.<br>
	   * 
	   * @param e Event
	   * @return response EventResponse
	   * @exception EventException
	   */
	  private EventResponse multiMonthlyTargetVVD0040(Event e) throws EventException {
	   // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
	   GeneralEventResponse eventResponse = new GeneralEventResponse();
	   EsmSaq0040Event event = (EsmSaq0040Event)e;
	   MonthlyTargetVVDBC command = new MonthlyTargetVVDBCImpl();

	   try {
	    begin();   
	      QuotaConditionVO condition = event.getQuotaConditionVO();
	      condition.setFormCommand(e.getFormCommand());
	      ReturnVO listVO = new ReturnVO();
	      listVO.addList(condition);
	      eventResponse.setRsVo(listVO);
	      command.multiMonthlyTargetVVD0040(event.getSaqMonTgtVvdVOS(),account);
	      eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
	      
	      eventResponse.setETCData("tgt_vvd_sts_cd", "0");
	      eventResponse.setETCData("status", "OK");
	      
	    commit();
	   } catch(EventException ex) {
	    rollback();
	    log.error("err " + ex.toString(), ex);
	    throw new EventException(ex.getMessage(),ex);
	   } catch(Exception ex) {
	    rollback();
	    log.error("err " + ex.toString(), ex);
	    throw new EventException(ex.getMessage(),ex);
	   }
	   return eventResponse;
	  }
	  
	  /**
	   * ESM_SAQ_0040 : [SKD Copy]<br>
	   * [Target VVD/Supply Management]을 [SKD Copy]합니다.<br>
	   * 
	   * @param e Event
	   * @return response EventResponse
	   * @exception EventException
	   */
	  private EventResponse processSKDCopy0040(Event e) throws EventException {
	   // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
	   GeneralEventResponse eventResponse = new GeneralEventResponse();
	   EsmSaq0040Event event = (EsmSaq0040Event)e;
	   MonthlyTargetVVDBC command = new MonthlyTargetVVDBCImpl();

	   try {
	    begin();   
	     QuotaConditionVO condition = event.getQuotaConditionVO();
	     condition.setFormCommand(e.getFormCommand());
	     ReturnVO listVO = new ReturnVO();
	     listVO.addList(condition);
	     eventResponse.setRsVo(listVO);
	    command.processSKDCopy0040(event.getQuotaConditionVO(),account);
	    eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
	    eventResponse.setETCData("tgt_vvd_sts_cd", "N");
	     eventResponse.setETCData("status", "OK");
	    commit();
	   } catch(EventException ex) {
	    rollback();
	    log.error("err " + ex.toString(), ex);
	    throw new EventException(ex.getMessage(),ex);
	   } catch(Exception ex) {
	    rollback();
	    log.error("err " + ex.toString(), ex);
	    throw new EventException(ex.getMessage(),ex);
	   }
	   return eventResponse;
	  }

	  /**
	   * ESM_SAQ_0040 : [Confirm]<br>
	   * [Target VVD/Supply Management]을 [Confirm]합니다.<br>
	   * 
	   * @param e Event
	   * @return response EventResponse
	   * @exception EventException
	   */
	  private EventResponse processConfirm0040(Event e) throws EventException {
	   // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
	   GeneralEventResponse eventResponse = new GeneralEventResponse();
	   EsmSaq0040Event event = (EsmSaq0040Event)e;
	   MonthlyTargetVVDBC command = new MonthlyTargetVVDBCImpl();

	   try {
	    begin();   
	     QuotaConditionVO condition = event.getQuotaConditionVO();
	     condition.setFormCommand(e.getFormCommand());
	     ReturnVO listVO = new ReturnVO();
	     listVO.addList(condition);
	     eventResponse.setRsVo(listVO);
	     command.processConfirm0040(event.getQuotaConditionVO(),account);
	     eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
	     eventResponse.setETCData("tgt_vvd_sts_cd", "C");
	     eventResponse.setETCData("status", "OK");
	    commit();
	   } catch(EventException ex) {
	    rollback();
	    log.error("err " + ex.toString(), ex);
	    throw new EventException(ex.getMessage(),ex);
	   } catch(Exception ex) {
	    rollback();
	    log.error("err " + ex.toString(), ex);
	    throw new EventException(ex.getMessage(),ex);
	   }
	   return eventResponse;
	  }

	  /**
	   * ESM_SAQ_0040 : [Cancel Confirmation]<br>
	   * [Target VVD/Supply Management]을 [Cancel Confirmation]합니다.<br>
	   * 
	   * @param e Event
	   * @return response EventResponse
	   * @exception EventException
	   */
	  private EventResponse processCancelConfirm0040(Event e) throws EventException {
	   // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
	   GeneralEventResponse eventResponse = new GeneralEventResponse();
	   EsmSaq0040Event event = (EsmSaq0040Event)e;
	   MonthlyTargetVVDBC command = new MonthlyTargetVVDBCImpl();

	   try {
	    begin();   
	     QuotaConditionVO condition = event.getQuotaConditionVO();
	     condition.setFormCommand(e.getFormCommand());
	     ReturnVO listVO = new ReturnVO();
	     listVO.addList(condition);
	     eventResponse.setRsVo(listVO);
	     command.processCancelConfirm0040(event.getQuotaConditionVO(),account);
	     eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
	     eventResponse.setETCData("tgt_vvd_sts_cd", "0");
	     eventResponse.setETCData("status", "OK");
	    commit();
	   } catch(EventException ex) {
	    rollback();
	    log.error("err " + ex.toString(), ex);
	    throw new EventException(ex.getMessage(),ex);
	   } catch(Exception ex) {
	    rollback();
	    log.error("err " + ex.toString(), ex);
	    throw new EventException(ex.getMessage(),ex);
	   }
	   return eventResponse;
	  }


		  /**
	   * ESM_SAQ_0040 : [SKD Copy Message생성]<br>
	   * [Target VVD/Supply Management]을 [SKD Copy Message생성]합니다.<br>
	   * 
	   * @param Event e
	   * @return EventResponse
	   * @exception EventException
	   */
	  private EventResponse searchSKDCopyMessage0040(Event e) throws EventException {
	   GeneralEventResponse eventResponse = new GeneralEventResponse();
	   EsmSaq0040Event event = (EsmSaq0040Event)e;
	   MonthlyTargetVVDBC command = new MonthlyTargetVVDBCImpl();

	   try{
	      QuotaConditionVO condition = event.getQuotaConditionVO();
	      condition.setFormCommand(e.getFormCommand());
	      ReturnVO listVO = new ReturnVO();
	   	  listVO.addList(condition);
	   	  eventResponse.setRsVo(listVO);
	      HashMap list = command.searchSKDCopyMessage0040(event.getQuotaConditionVO());
	      eventResponse.setETCData(list);
		  eventResponse.setETCData("status", "OK");
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