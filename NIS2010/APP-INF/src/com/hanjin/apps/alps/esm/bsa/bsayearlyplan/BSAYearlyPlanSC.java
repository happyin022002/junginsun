/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BSAYearlyPlanSC.java
*@FileTitle : BSAYearlyPlanSC
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.13
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.13 이행지
* 1.0 Creation
*=========================================================
* History :
* 2011.01.17 이행지 [CHM-201108497-01] 사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
* 2011.04.04 최윤성 [CHM-201109932-01] BSA Yearly PLan 메뉴에 Live Data I/F 기능 추가
* 2011.07.15 이행지 [CHM-201112101-01] Currency Code 검색조건 추가되어 로딩시 콤보셋팅 추가
=========================================================*/

package com.hanjin.apps.alps.esm.bsa.bsayearlyplan;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.basic.BSAManageBC;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.basic.BSAManageBCImpl;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.CreateBSAVO;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.basic.BSAYearlyPlanBC;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.basic.BSAYearlyPlanBCImpl;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.event.EsmBsa0040Event;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.event.EsmBsa0041Event;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.event.EsmBsa0042Event;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.event.EsmBsa0043Event;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.event.EsmBsa0044Event;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.event.EsmBsa0045Event;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo.ParamProcedureVO;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo.RsltCoaMonVvdYryPlnVO;
import com.hanjin.apps.alps.esm.bsa.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.bsa.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-BSAYearlyPlan Business Logic ServiceCommand - ALPS-BSAYearlyPlan 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Haeng-ji,Lee
 * @see BSAYearlyPlanDBDAO
 * @since J2EE 1.6
 */

public class BSAYearlyPlanSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * BSAYearlyPlan system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("BSAYearlyPlanSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * BSAYearlyPlan system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("BSAYearlyPlanSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-BSAYearlyPlan system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		log.debug("EventName : " + e.getEventName());
		log.debug("e.getFormCommand().getCommand() = " + e.getFormCommand().getCommand());


		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		//===============================================================================
		// ESM_BSA_0040: BSA Creation/Update(Yearly Plan)
		//=============================================================================== 
		if (e.getEventName().equalsIgnoreCase("EsmBsa0040Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // JO							
				eventResponse = searchBSATableJOList(e);                 // 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // SC			
				eventResponse = searchBSATableSCList(e); // 조회	
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // JO		
				eventResponse = multiBSATableJO(e); // 저장
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // SC			
				eventResponse = multiBSATableSC(e); // 저장		
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) { // JO
				eventResponse = removeBSATableJO(e); // 삭제				
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE02)) { // SC
				eventResponse = removeBSATableSC(e);  // 삭제					
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)
				 || e.getFormCommand().isCommand(FormCommand.MULTI04)) { // JO / SC
				eventResponse = createBSA(e); // 생성								
			} else {
				eventResponse = searchInitComBo(e);
				eventResponse.setCustomData(searchBSATableHeaderList(e).getCustomData());			
			}
		}

		//===============================================================================
		// ESM_BSA_0041: Slot Price Creation/Update(Yearly Plan)
		//=============================================================================== 
		else if (e.getEventName().equalsIgnoreCase("EsmBsa0041Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // 조회
				eventResponse = searchSlotCostList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // 저장
				eventResponse = multiSlotCost(e);
			} else { // 초기Load시
				eventResponse = searchInitComBo(e);
				eventResponse.setCustomData(searchBsaCrrRgstList(e).getCustomData());
			}
		}

		//===============================================================================
		// ESM_BSA_0042:  BSA Inquiry by VVD(Yearly Plan)
		//=============================================================================== 
		else if (e.getEventName().equalsIgnoreCase("EsmBsa0042Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // 조회
				eventResponse = searchTEUPrcSwapVvdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // 조회
				eventResponse = searchRevCostSwapVvdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // 생성
				eventResponse = createBSABatch(e);
			} else {
				eventResponse = searchInitComBo(e);
				eventResponse.setETCData(searchPrevWkPrd(e).getETCData());
			}
		}
		
		//===============================================================================
		// ESM_BSA_0043:  Target VVD(Yearly Plan)
		//=============================================================================== 
		else if (e.getEventName().equalsIgnoreCase("EsmBsa0043Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 			// Retrieve
                eventResponse = searchYearlyPlanTargetVVDList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { 	// Creation
                eventResponse = createYearlyPlanTargetVVD(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { 	// BackEndJob 상태값 조회
                eventResponse = searchBackEndJobVO(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { 	// BackEndJob 결과 조회
                eventResponse = searchBackEndJobGetResult(e);
            } else {
            	eventResponse = searchInitComBo(e);
            }
        }
		
		//===============================================================================
		// ESM_BSA_0044:  BSA Creation/Update [Create] PopUp(Yearly Plan)
		//=============================================================================== 
		else if (e.getEventName().equalsIgnoreCase("EsmBsa0044Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { 			// Creation
                eventResponse = createBSABatch(e);
            } else {
            	eventResponse = searchInitComBo(e);
            }
        }
		
		//===============================================================================
		// ESM_BSA_0045:  BSA Data I/F PopUp
		//=============================================================================== 
		else if (e.getEventName().equalsIgnoreCase("EsmBsa0045Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { 			// 계약 정보 & JO
                eventResponse = interfaceBSAJO(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { 	// 계약 정보 & SC
                eventResponse = interfaceBSASC(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { 	// 단가 정보
                eventResponse = interfaceSlotCost(e);
            } else {
            	eventResponse = searchInitComBo(e);
            }
        }
		return eventResponse;
	}

	/**
	 * 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchInitComBo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC comCommand = new CommonBCImpl();
		try {
			if(e.getEventName().equals("EsmBsa0040Event")){
				String array[][] = { {"trade","",""},  
									 {"rLane","",""},
		       						 {"CD00593","",""}
		       						};
				eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
			}
			else if(e.getEventName().equals("EsmBsa0041Event")){
				String array[][] = { {"trade","",""},  
			             			{"rLane","",""},
			             			{"CD00593","",""}, 
			             			{"rLane4","",""},
			             			{"currency","",""}
		       						};
		       eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
			}
			else if(e.getEventName().equals("EsmBsa0042Event")){
				String array[][] = { {"trade","",""},  
			             			{"rLane","",""},
			             			{"CD00593","",""}, 
			             			{"CD00206","",""}
		       						};
				eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
	       	}
	       	else if(e.getEventName().equals("EsmBsa0043Event")){
				EsmBsa0043Event event = (EsmBsa0043Event)e;
				if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)){
					//TARGET VVD - TRADE MULTI COMBO ONCHANGE 시에 호출
	    		    String array[][] = { {"rLane",event.getSearchConditionVO().getFSeltrade(),"All"},
	    		    					 {"sLane",event.getSearchConditionVO().getFSeltrade(),"All"}
	    		    					};
	    		    eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
				} else {	
					//TARGET VVD 화면로딩시 호출
					 String fYear = com.hanjin.framework.component.util.DateTime.getYear() + "";
				     String prevWeek = comCommand.searchPrevWkPrd();
				     String period = comCommand.getDatePeriod(fYear, prevWeek, prevWeek, "WEEK");
				     eventResponse.setETCData("prevWeek", prevWeek);
				     eventResponse.setETCData("period", period);
				       	
					String array[][] = { {"trade","",""},  
							 			 {"rLane","",""},
							 			 {"sLane","",""},
			       						 {"CD00593","",""},
			       						 {"CD00206","",""}
	  									};
					eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
				}
			}
	       	else if(e.getEventName().equals("EsmBsa0044Event")){
	       		String year		= com.hanjin.framework.component.util.DateTime.getYear() + "";
			    String prevWeek	= comCommand.searchPrevWkPrd();
			    String period		= comCommand.getDatePeriod(year, prevWeek, prevWeek, "WEEK");
			    eventResponse.setETCData("prevWeek", prevWeek);
			    eventResponse.setETCData("period", period);
				String array[][] = { {"trade","",""},  
									 {"rLane","",""},
			  						 {"CD00593","",""},
			   						 {"CD00206","",""}
  						};
				eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
	       	}
	       	else if(e.getEventName().equals("EsmBsa0045Event")){
				String array[][] = { {"trade","",""},
						             {"rLane","",""}
  						            };
				eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
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
	 * ESM_BSA_0040: 헤더조회 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 헤더조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchBSATableHeaderList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BSAManageBC command = new BSAManageBCImpl();
		try{			
			CommonBsaRsVO rtnVo = command.searchBSATableHeaderList();			
			eventResponse.setCustomData("rtnVo", rtnVo);			
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESM_BSA_0040 : [Retrieve]<br>
	 * [BSA Creation/Update - JO]을 [Retrieve]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBSATableJOList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0040Event event = (EsmBsa0040Event)e;
		BSAYearlyPlanBC command = new BSAYearlyPlanBCImpl();
		
		try{			
			CommonBsaRsVO rtnVo = command.searchBSATableJOList(event.getSearchBsaConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rtnVo);

			eventResponse.setRsVoList(list);			
			eventResponse.setCustomData("rtnVo", rtnVo);
			
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}

	/**
	 * ESM_BSA_0040: 조회 이벤트 처리<br>
	 * [BSA Creation/Update - SC]을 [Retrieve]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBSATableSCList(Event e) throws EventException {
		EsmBsa0040Event event = (EsmBsa0040Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{			
			BSAYearlyPlanBC command = new BSAYearlyPlanBCImpl();
			CommonBsaRsVO rtnVo = command.searchBSATableSCList(event.getSearchBsaConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rtnVo);

			eventResponse.setRsVoList(list);			
			eventResponse.setCustomData("rtnVo", rtnVo);			
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}
	
	/**
	 * ESM_BSA_0040: 멀티 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse multiBSATableJO(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0040Event event = (EsmBsa0040Event)e; 
		BSAYearlyPlanBC command = new BSAYearlyPlanBCImpl();
		try {
			begin();
			command.multiBSATableJO(event.getBsaBudJntOpBzcVOs(), event.getBsaBudJntOpCrrCapaVOs(), account);
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
	 * ESM_BSA_0040: 멀티 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse multiBSATableSC(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0040Event event = (EsmBsa0040Event)e; 
		BSAYearlyPlanBC command = new BSAYearlyPlanBCImpl();
		try {
			begin();
//			command.multiBSATableSC(event.getBsaTableSaveVOs(), account);
			command.multiBSATableSC(event.getBsaBudSltChtrBzcVOs(), event.getBsaBudSltChtrCrrCapaVOs(), account);
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
	 * ESM_BSA_0040: 멀티 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse removeBSATableJO(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0040Event event = (EsmBsa0040Event)e; 
		BSAYearlyPlanBC command = new BSAYearlyPlanBCImpl();
		try {
			begin();
			command.removeBSATableJO(event.getBsaBudJntOpBzcVOs());
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
	 * ESM_BSA_0040: 멀티 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse removeBSATableSC(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0040Event event = (EsmBsa0040Event)e; 
		BSAYearlyPlanBC command = new BSAYearlyPlanBCImpl();
		try {
			begin();
//			command.removeBSATableSC(event.getBsaTableSaveVOs());
			command.removeBSATableSC(event.getBsaBudSltChtrBzcVOs());
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
	 * ESM_BSA_0040: 생성 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 생성 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse createBSA(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0040Event event = (EsmBsa0040Event)e; 
		BSAYearlyPlanBC command = new BSAYearlyPlanBCImpl();
		try {
			begin();
			CreateBSAVO createRtnVo = command.createBSA(event.getSearchBsaConditionVO(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			
			eventResponse.setETCData("err_cd", createRtnVo.getPErrorCode());
			eventResponse.setETCData("err_msg", createRtnVo.getPErrorMsg());
			eventResponse.setCustomData("rtnVo", createRtnVo);
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
	 * ESM_BSA_041: 헤더구성 조회 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchBsaCrrRgstList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BSAManageBC command = new BSAManageBCImpl();
 
		try{
			CommonBsaRsVO vo = command.searchBsaCrrRgstList();
			eventResponse.setCustomData("rtnVo", vo);
			eventResponse.setETCData("headSet", vo.getStrTemp());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse; 		
	}
	/**
	 * ESM_BSA_0041: 조회 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event E
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchSlotCostList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0041Event event = (EsmBsa0041Event)e;
		BSAYearlyPlanBC command = new BSAYearlyPlanBCImpl();
		try {
			CommonBsaRsVO rsVO = command.searchSlotCostList(event.getBsaYearlyPlanConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVO);

			eventResponse.setRsVoList(list);			
			eventResponse.setCustomData("rtnVo", rsVO);

			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}
	/**
	 * ESM_BSA_0041: 멀티 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse multiSlotCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0041Event event = (EsmBsa0041Event)e;
		BSAYearlyPlanBC command = new BSAYearlyPlanBCImpl();
		try{
			begin();
			command.multiSlotCost(event.getBsaBudSltPrcVOs(), event.getBsaBudSltPrcCrrVOs(), account);
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
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse searchPrevWkPrd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC comCommand = new CommonBCImpl();
	   	String prevWk = "";
	
		try {
			prevWk =comCommand.searchPrevWkPrd();
			eventResponse.setETCData("prevWk", prevWk);
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * ESM_BSA_0042: 조회 이벤트 처리 - TEU & Slot Price<br>
	 * SPCManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchTEUPrcSwapVvdList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0042Event event = (EsmBsa0042Event)e;
		BSAYearlyPlanBC command = new BSAYearlyPlanBCImpl();
		
		try {
			CommonBsaRsVO rsVO = command.searchTEUPrcSwapVvdList(event.getBsaYearlyPlanConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVO);
			eventResponse.setRsVoList(list);	
			
			return eventResponse; 
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	/**
	 * ESM_BSA_0042: 조회 이벤트 처리( Revenue & Cost Of Slot-swap By VVD List)<br>
	 * SPCManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRevCostSwapVvdList(Event e)	throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0042Event event = (EsmBsa0042Event)e; 
		BSAYearlyPlanBC command = new BSAYearlyPlanBCImpl();
		
		try {
			CommonBsaRsVO rsVO = command.searchRevCostSwapVvdList(event.getBsaYearlyPlanConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVO);

			eventResponse.setRsVoList(list);
			return eventResponse; 
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

    /**
     * ESM_BSA_0043: YearlyPlan 대상항차 화면에 대한 Sheet1 리스트 조회<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchYearlyPlanTargetVVDList(Event e) throws EventException {
        EsmBsa0043Event event = (EsmBsa0043Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	BSAYearlyPlanBC command = new BSAYearlyPlanBCImpl();
            List<RsltCoaMonVvdYryPlnVO> list = command.searchYearlyPlanTargetVVDList(event.getParamCoaMonVvdYryPlnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
	    }
        return eventResponse;
    }    
	
    /* ************************************************
       BACK END JOB 관련 - Start
       ************************************************/
    /**
     * ESM_BSA_0043: Creation
     * 대상항차화면에 대한 Sheet1 의 Create 이벤트 처리<br>
     * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse createYearlyPlanTargetVVD(Event e) throws EventException {
    	EsmBsa0043Event event = (EsmBsa0043Event)e;
        BSAYearlyPlanBC command = new BSAYearlyPlanBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {                  
            eventResponse.setETCData("BackEndJobKey", command.createYearlyPlanTargetVVD(event.getParamCoaMonVvdYryPlnVO(), account));            
        }catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
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
    private EventResponse searchBackEndJobVO(Event e) throws EventException {
        String key = (String)e.getAttribute("KEY");
        String status = null;
        BSAYearlyPlanBC command = new BSAYearlyPlanBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            status = command.searchBackEndJobVO(key);
            eventResponse.setETCData("jb_sts_flg", status);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
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
    private EventResponse searchBackEndJobGetResult(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse(); 	
        String key = (String)e.getAttribute("KEY");
        try {            
        	ParamProcedureVO vo= (ParamProcedureVO)BackEndJobResult.loadFromFile(key);
           
        	eventResponse.setETCData("err_cd", vo.getPErrCd());
            eventResponse.setETCData("err_msg", vo.getPErrMsg());
            eventResponse.setETCData("vsl_cd", vo.getPVslCd()==null?"":vo.getPVslCd());
            
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    /* ************************************************
       BACK END JOB 관련 - End
       ************************************************/
    /**
	 * ESM_BSA_0044: 생성 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 생성 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse createBSABatch(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BSAYearlyPlanBC command = new BSAYearlyPlanBCImpl();
		
		try {
			if( e.getEventName().equals("EsmBsa0042Event") ){ // BSA Inquiry by VVD(Yearly Plan) [Creation]
				EsmBsa0042Event event = (EsmBsa0042Event)e;		
	
				event.getBsaYearlyPlanConditionVO().setEventName(event.getEventName());
				String strStatus  = command.createBSABatch(event.getBsaYearlyPlanConditionVO(), account);
				eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
				
				//Batch모듈을 직접 실행한다. 
				eventResponse.setETCData("BatchStatus", strStatus);
			} else if( e.getEventName().equals("EsmBsa0044Event") ){ // BSA Creation/Update(Yearly Plan) [Creation]
				EsmBsa0044Event event = (EsmBsa0044Event)e;
				
				event.getBsaYearlyPlanConditionVO().setEventName(event.getEventName());
				String strStatus  = command.createBSABatch(event.getBsaYearlyPlanConditionVO(), account);
				eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
				
				//Batch모듈을 직접 실행한다. 
				eventResponse.setETCData("BatchStatus", strStatus);
			}
		} catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BSA_0045: 멀티 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse interfaceBSAJO(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0045Event event = (EsmBsa0045Event)e;
		BSAYearlyPlanBC command = new BSAYearlyPlanBCImpl();
		
		try{
			begin();
			command.interfaceBSAJO(event.getBsaTableSaveVOs(), account);
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
	 * ESM_BSA_0045: 멀티 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse interfaceBSASC(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0045Event event = (EsmBsa0045Event)e;
		BSAYearlyPlanBC command = new BSAYearlyPlanBCImpl();
		
		try{
			begin();
			command.interfaceBSASC(event.getBsaTableSaveVOs(), account);
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
	 * ESM_BSA_0045: 멀티 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse interfaceSlotCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0045Event event = (EsmBsa0045Event)e;
		BSAYearlyPlanBC command = new BSAYearlyPlanBCImpl();
		
		try{
			begin();
			command.interfaceSlotCost(event.getBsaTableSaveVOs(), account);
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
}