/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : PlanningSC.java
*@FileTitle      : Planning
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.10
*@LastModifier   : JEONGMIN CHO
*@LastVersion    : 1.0
* 2013.05.10 JEONGMIN CHO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning;

import java.util.List;

import com.clt.apps.opus.esm.csq.common.basic.CommonBC;
import com.clt.apps.opus.esm.csq.common.basic.CommonBCImpl;
import com.clt.apps.opus.esm.csq.planning.planning.basic.PlanningBC;
import com.clt.apps.opus.esm.csq.planning.planning.basic.PlanningBCImpl;
import com.clt.apps.opus.esm.csq.planning.planning.event.EsmCsq0020Event;
import com.clt.apps.opus.esm.csq.planning.planning.event.EsmCsq0021Event;
import com.clt.apps.opus.esm.csq.planning.planning.event.EsmCsq0022Event;
import com.clt.apps.opus.esm.csq.planning.planning.event.EsmCsq0023Event;
import com.clt.apps.opus.esm.csq.planning.planning.event.EsmCsq0024Event;
import com.clt.apps.opus.esm.csq.planning.planning.event.EsmCsq0025Event;
import com.clt.apps.opus.esm.csq.planning.planning.event.EsmCsq0026Event;
import com.clt.apps.opus.esm.csq.planning.planning.event.EsmCsq0027Event;
import com.clt.apps.opus.esm.csq.planning.planning.event.EsmCsq0030Event;
import com.clt.apps.opus.esm.csq.planning.planning.event.EsmCsq0033Event;
import com.clt.apps.opus.esm.csq.planning.planning.event.EsmCsq0213Event;
import com.clt.apps.opus.esm.csq.planning.planning.event.EsmCsq0214Event;
import com.clt.apps.opus.esm.csq.planning.planning.event.EsmCsq0215Event;
import com.clt.apps.opus.esm.csq.planning.planning.event.EsmCsq0216Event;
import com.clt.apps.opus.esm.csq.planning.planning.integration.PlanningDBDAO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaByRhqListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaByRhqResultVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaByRhqSimulationVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaLoadRevForSectorAddListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaLoadRevForSectorListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaLoadRevListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaRhqDistributeResultListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaRhqQtaSummaryListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaSetUpHeadOfficeListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaSetupForIsaSecByHoSummaryVO;
import com.clt.apps.opus.esm.csq.planning.planninginquiry.basic.PlanningInquiryBC;
import com.clt.apps.opus.esm.csq.planning.planninginquiry.basic.PlanningInquiryBCImpl;
import com.clt.apps.opus.esm.csq.planning.planninginquiry.event.EsmCsq0037Event;
import com.clt.apps.opus.esm.csq.planning.planninginquiry.event.EsmCsq0038Event;
import com.clt.apps.opus.esm.csq.planning.planninginquiry.event.EsmCsq0217Event;
import com.clt.apps.opus.esm.csq.planning.planninginquiry.event.EsmCsq0218Event;
import com.clt.apps.opus.esm.csq.planning.planninginquiry.vo.SearchPlanningQtaIasSectorVO;
import com.clt.apps.opus.esm.csq.planning.planninginquiry.vo.SearchQtaInquiryListVO;
import com.clt.apps.opus.esm.csq.planning.statusmanage.basic.StatusManageBC;
import com.clt.apps.opus.esm.csq.planning.statusmanage.basic.StatusManageBCImpl;
import com.clt.apps.opus.esm.csq.planning.statusmanage.event.EsmCsq0036Event;
import com.clt.apps.opus.esm.csq.planning.statusmanage.vo.SearchQtaEstablishingStatusListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Planning Business Logic ServiceCommand - ALPS-DataManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author JEONGMIN CHO
 * @see PlanningDBDAO
 * @since J2EE 1.6
 */

public class PlanningSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	
	/**
	 * Planning system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("PlanningSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}
	
	/**
	 * Planning system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("PlanningSC 종료");
	}
	
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-DataManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmCsq0020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaLoadRevList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0020(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageQtaLoadRev(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = confirmQtaLoadRev(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0021Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaSetUpHeadOfficeList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageQtaSetUpHeadOffice(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = confirmQtaSetUpHeadOffice(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0021(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0022Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaRhqDistributeResultList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0023Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaRhqQtaSummaryList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0024Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaByRhqObLoadList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0024(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageQtaByRhqObLoad(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = confirmQtaByRhqObLoad(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0025Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchQtaByRhqResult(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0026Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchQtaByRhqSimulation(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0027Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaByRhqNobCtrtList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0027(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageQtaByRhqNobCtrt(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = confirmQtaByRhqNobCtrt(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0030Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaByRhqobCtrtList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0030(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageQtaByRhqobCtrt(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = confirmQtaByRhqobCtrt(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0036Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaEstablishingStatusList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = cancelConfirmQtaStepVer(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createQtaStepVer(e, "GRPB");
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = createQtaStepVer(e, "HO");
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = createQtaStepVer(e, "RHQ");
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = createQtaFreezing(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = createQtaTransfer(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBackEndJobVO(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0036(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0037Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaInquiryForYear(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0037(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0038Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaInquiryForQuarter(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0038(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0033Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaByRhqCtrtList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0033(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0213Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {       // Loading 시 콤보 세팅
				eventResponse = searchComBoCdList0213(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Retrieve
				eventResponse = searchQtaLoadRevForSectorList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Save
				eventResponse = updateQtaLoadRevForSector(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) { // Creation
				eventResponse = createQtaLoadRevForSector(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI03)) { // Freezing
				eventResponse = createQtaFreezingForSector(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI04)) { // 1Q Transfer
				eventResponse = createQtaTransferForSector(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0214Event")) { 
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaLoadRevForSectorAddCreationList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createQtaLoadRevForSectorAddCreation(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0215Event")) { 
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaLoadRevForSectorAddFreezingList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createQtaLoadRevForSectorAddFreezing(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0216Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0216(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaSetupForIsaSecByHoSummary(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0217Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0217(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPlanningQtaYrIasSector(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0218Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0218(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPlanningQtaQtrIasSector(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0020 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0020(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Next Quarter. */
					{"nextQta", "", ""}
			};
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	

	/**
	 * ESM_CSQ_0021 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0021(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Next Quarter. */
					{"nextQta", "", ""},
					/* 4. Office View */
					{"officeView", "", ""},
					/* 5. Bound. */
					{"comCodeBound", "", "All"},
					/* 7. Out/Non Out Bound. */
					{"comCodeOutNonOutBound", "", "All"},
					/* 8. RHQ. */
					{"rhqForPlan", "", "All"}
			};
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0024 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0024(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Next Quarter. */
					{"nextQta", "", ""},
					/*.4. OFC. */
					{"officeForPlan",account.getOfc_cd(), "All"}
			};
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0027 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0027(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Next Quarter. */
					{"nextQta", "", ""},
					/*.4. OFC. */
					{"officeForPlan",account.getOfc_cd(), "All"}
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0030 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0030(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Next Quarter. */
					{"nextQta", "", ""},
					/*.4. OFC. */
					{"officeForPlan",account.getOfc_cd(), "All"}
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0036 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0036(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Next Quarter. */
					{"nextQta", "", ""},
					/* 4. Qta Step. */
					{"comCodeQtaStep", "", "All"},
					/* 5. Bound. */
					{"comCodeBound", "", "All"},
					/* 6. H/O Teams. */
					{"hoTeams", "", "All"},
					/* 7. Org. */
					{"hoTeams", "Org", "All"},
					/* 8. Office View */
					{"officeView", "", ""}
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0037 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0037(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Office level */
					{"comCodeOfcLvl", "", ""},   
					/* 3. RHQ. */
					{"rhqForPlan", "", "All"},
					/* 4. Office View */
					{"officeView", "", ""},
					/* 5. Bound. */
					{"comCodeBound", "", "All"},
					/* 6. Next Quarter. */
					{"nextQta", "", ""}
					
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0038 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0038(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Office level */
					{"comCodeOfcLvl", "", ""},   
					/* 3. RHQ. */
					{"rhqForPlan", "", "All"},
					/* 4. Office View */
					{"officeView", "", ""},
					/* 5. Bound. */
					{"comCodeBound", "", "All"},
					/* 6. Quarter */
					{"quarter", "", ""},
					/* 7. Next Quarter. */
					{"nextQta", "", ""}
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	
	/**
	 * ESM_CSQ_0020 : Retrieve 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaLoadRevList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0020Event event = (EsmCsq0020Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			List<SearchQtaLoadRevListVO> list = command.searchQtaLoadRevList(event.getConditionVO(),account);
			String dataCnt = Integer.toString(command.searchQtaVerStatusCnt(event.getConditionVO(),account,"C"));			
			eventResponse.setETCData("dataCnt", dataCnt);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0020 : MULTI 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageQtaLoadRev(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0020Event event = (EsmCsq0020Event)e; 
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.manageQtaLoadRev(event.getConditionVO(), event.getCsqQtaLodRevVOS(), account);
			commit();
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
	 * ESM_CSQ_0020 : MULTI01 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse confirmQtaLoadRev(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0020Event event = (EsmCsq0020Event)e; 
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.confirmQtaLoadRev(event.getConditionVO(), account);
			commit();
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
	 * ESM_CSQ_0021 : [이벤트]<br>
	 * [QTA Set-up by Head Office]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaSetUpHeadOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0021Event event = (EsmCsq0021Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			List<SearchQtaSetUpHeadOfficeListVO> list = command.searchQtaSetUpHeadOfficeList(event.getConditionVO(), account);
			String dataCnt = Integer.toString(command.searchQtaVerStatusCnt(event.getConditionVO(), account, "C"));			
			eventResponse.setETCData("dataCnt", dataCnt);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0021 : [이벤트]<br>
	 * [QTA Set-up by Head Office]을 [수정] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageQtaSetUpHeadOffice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0021Event event = (EsmCsq0021Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.manageQtaSetUpHeadOffice(event.getCsqQtaPotnMgmtVOS(), event.getConditionVO(), account);
			commit();
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
	 * ESM_CSQ_0021 : [이벤트]<br>
	 * [QTA Set-up by Head Office]을 [confirm] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse confirmQtaSetUpHeadOffice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0021Event event = (EsmCsq0021Event)e; 
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.confirmQtaSetUpHeadOffice(event.getConditionVO(), account);
			commit();
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
	 * ESM_CSQ_0022 : [이벤트]<br>
	 * [QTA Set up by Head Office RHQ Distribute Result]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaRhqDistributeResultList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0022Event event = (EsmCsq0022Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			List<SearchQtaRhqDistributeResultListVO> list = command.searchQtaRhqDistributeResultList(event.getConditionVO(), account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0023 : [이벤트]<br>
	 * [QTA Set up by Head Office RHQ QTA Summary]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaRhqQtaSummaryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0023Event event = (EsmCsq0023Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			List<SearchQtaRhqQtaSummaryListVO> list = command.searchQtaRhqQtaSummaryList(event.getConditionVO(), account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0024 : Retrieve 이벤트 처리<br>
	 * [QTA Set up by RHQ_OB Loading]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaByRhqObLoadList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0024Event event = (EsmCsq0024Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			List<SearchQtaByRhqListVO> list = command.searchQtaByRhqList(event.getConditionVO(),account);
			String dataCnt = Integer.toString(command.searchQtaVerStatusCnt(event.getConditionVO(),account,"C"));			
			eventResponse.setETCData("dataCnt", dataCnt);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0024 : MULTI 이벤트 처리<br>
	 * [QTA Set up by RHQ_OB Loading]을 [저장] 합니다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageQtaByRhqObLoad(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0024Event event = (EsmCsq0024Event)e; 
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.manageQtaByRhq(event.getConditionVO(), event.getCsqQtaPotnMgmtVOS(), account);
			commit();
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
	 * ESM_CSQ_0024 : MULTI01 이벤트 처리<br>
	 * [QTA Set up by RHQ_OB Loading]을 [컨펌] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse confirmQtaByRhqObLoad(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0024Event event = (EsmCsq0024Event)e; 
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.confirmQtaByRhq(event.getConditionVO(), account);
			commit();
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
	 * ESM_CSQ_0027 : Retrieve 이벤트 처리<br>
	 * [QTA Set up by RHQ_NON OB Contract]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaByRhqNobCtrtList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0027Event event = (EsmCsq0027Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			List<SearchQtaByRhqListVO> list = command.searchQtaByRhqList(event.getConditionVO(),account);
			String dataCnt = Integer.toString(command.searchQtaVerStatusCnt(event.getConditionVO(),account,"C"));			
			eventResponse.setETCData("dataCnt", dataCnt);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0027 : MULTI 이벤트 처리<br>
	 * [QTA Set up by RHQ_NON OB Contract]을 [저장] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageQtaByRhqNobCtrt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0027Event event = (EsmCsq0027Event)e; 
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.manageQtaByRhq(event.getConditionVO(), event.getCsqQtaPotnMgmtVOS(), account);
			commit();
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
	 * ESM_CSQ_0027 : MULTI01 이벤트 처리<br>
	 * [QTA Set up by RHQ_NON OB Contract]을 [컨펌] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse confirmQtaByRhqNobCtrt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0027Event event = (EsmCsq0027Event)e; 
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.confirmQtaByRhq(event.getConditionVO(), account);
			commit();
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
	 * ESM_CSQ_0025 : Retrieve 이벤트 처리<br>
	 * [ QTA Set-up by RHQ _Office Distribute Result] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaByRhqResult(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0025Event event = (EsmCsq0025Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			List<SearchQtaByRhqResultVO> list = command.searchQtaByRhqResult(event.getConditionVO(),account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0026 : Retrieve 이벤트 처리<br>
	 * [QTA Set-up by RHQ _Office QTA Simulation]을 [조회] 합니다
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaByRhqSimulation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0026Event event = (EsmCsq0026Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			List<SearchQtaByRhqSimulationVO> list = command.searchQtaByRhqSimulation(event.getConditionVO(),account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0030 : Retrieve 이벤트 처리<br>
	 * [QTA Set up by RHQ_OB Contract]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaByRhqobCtrtList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0030Event event = (EsmCsq0030Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			List<SearchQtaByRhqListVO> list = command.searchQtaByRhqList(event.getConditionVO(),account);
			String dataCnt = Integer.toString(command.searchQtaVerStatusCnt(event.getConditionVO(),account,"C"));			
			eventResponse.setETCData("dataCnt", dataCnt);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0030 : MULTI 이벤트 처리<br>
	 * [QTA Set up by RHQ_OB Contract]을 [저장] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageQtaByRhqobCtrt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0030Event event = (EsmCsq0030Event)e; 
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.manageQtaByRhq(event.getConditionVO(), event.getCsqQtaPotnMgmtVOS(), account);
			commit();
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
	 * ESM_CSQ_0030 : MULTI01 이벤트 처리<br>
	 * [QTA Set up by RHQ_OB Contract]을 [컨펌] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse confirmQtaByRhqobCtrt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0030Event event = (EsmCsq0030Event)e; 
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.confirmQtaByRhq(event.getConditionVO(), account);
			commit();
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
	 * ESM_CSQ_0036 : SEARCH 이벤트 처리<br>
	 * [QTA Establishing Status]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaEstablishingStatusList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0036Event event = (EsmCsq0036Event)e;
		StatusManageBC command = new StatusManageBCImpl();
		
		try {
			List<SearchQtaEstablishingStatusListVO> list = command.searchQtaEstablishingStatusList(event.getConditionVO());
			String dataCnt = command.searchQtaStepCnt(event.getConditionVO());
			
			if ( !dataCnt.isEmpty() ) {
				String data[] = dataCnt.split("[|]");
				
				eventResponse.setETCData("step01Cnt", data[0]);
				eventResponse.setETCData("step02Cnt", data[1]);
				eventResponse.setETCData("step03Cnt", data[2]);
				eventResponse.setETCData("freezeFlg", data[3]);
				eventResponse.setETCData("rlseFlg"  , data[4]);
				eventResponse.setETCData("transFlg" , data[5]);
			} else {
				eventResponse.setETCData("NODATA", "Y");
			}
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0036 : MULTI 이벤트 처리<br>
	 * [QTA Establishing Status]을 [Cancel Confirm] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse cancelConfirmQtaStepVer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0036Event event = (EsmCsq0036Event)e; 
		StatusManageBC command = new StatusManageBCImpl();
		
		try {
			begin();
			command.cancelConfirmQtaStepVer(event.getCsqQtaStepVerVOS(),event.getConditionVO(), account);
			commit();
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
	 * ESM_CSQ_0036 : MULTI 이벤트 처리<br>
	 * [QTA Establishing Status]을 [생성] 합니다.<br>
	 * 
	 * @param Event e
	 * @param String step
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createQtaStepVer(Event e, String step) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0036Event event = (EsmCsq0036Event)e; 
		StatusManageBC command = new StatusManageBCImpl();
		
		try {
			begin();
			command.createQtaStepVer(event.getConditionVO(), account, step);
			commit();
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
	 * ESM_CSQ_0036 : MULTI04 이벤트 처리<br>
	 * [QTA Establishing Status]을 [생성] 합니다.<br>
	 * 
	 * @param Event e
	 * @param String step
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createQtaFreezing(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0036Event event = (EsmCsq0036Event)e; 
		StatusManageBC command = new StatusManageBCImpl();
		
		try {
			begin();
			eventResponse.setETCData("BackEndJobKey", command.createQtaFreezing(event.getConditionVO(), account));
			commit();
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
	 * ESM_CSQ_0036 : MULTI05 이벤트 처리<br>
	 * [QTA Establishing Status]을 [연간으로 1Q 생성] 합니다.<br>
	 * 
	 * @param Event e
	 * @param String step
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createQtaTransfer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0036Event event = (EsmCsq0036Event)e; 
		StatusManageBC command = new StatusManageBCImpl();
		
		try {
			begin();
			eventResponse.setETCData("BackEndJobKey", command.createQtaTransfer(event.getConditionVO(), account));
			commit();
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
     * BackEndJob : interval <br>
     * BackEndJob의 상태값을 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBackEndJobVO(Event e) throws EventException {
        String key = (String)e.getAttribute("KEY");
        String[] rtnArr = null;
        String status = null;
        String errMsg = null;
        StatusManageBC command = new StatusManageBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try {
        	rtnArr = command.searchBackEndJobVO(key);
        	status = rtnArr[0];
        	errMsg = rtnArr[1];
            eventResponse.setETCData("jb_sts_flg", status);
            eventResponse.setETCData("jb_usr_err_msg", errMsg);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_CSQ_0037 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Planning]을 [조회] 합니다
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaInquiryForYear(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0037Event event = (EsmCsq0037Event)e;
		PlanningInquiryBC command = new PlanningInquiryBCImpl();
		
		try {
			List<SearchQtaInquiryListVO> list = command.searchQtaInquiryList(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0038 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Planning]을 [조회] 합니다
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaInquiryForQuarter(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0038Event event = (EsmCsq0038Event)e;
		PlanningInquiryBC command = new PlanningInquiryBCImpl();
		
		try {
			List<SearchQtaInquiryListVO> list = command.searchQtaInquiryList(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0033 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0033(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Next Quarter. */
					{"nextQta", "", ""},
					/* 4. Out/Non Out Bound. */
					{"comCodeOutNonOutBound", "", "All"},
					/*.5. OFC. */
					{"officeForPlan",account.getOfc_cd(), "All"}
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0033 : Retrieve 이벤트 처리<br>
	 * [QTA Set-up by RHQ (Contract TTL retrieve only)]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaByRhqCtrtList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0033Event event = (EsmCsq0033Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			List<SearchQtaByRhqListVO> list = command.searchQtaByRhqList(event.getConditionVO(),account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0213 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0213(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Next Quarter. */
					{"nextQta", "", ""},
					/* 4. Office View */
					{"officeView", "", ""},
					/* 5. Bound. */
					{"comCodeBound", "", "All"},					
					/* 6. RHQ. */
					{"rhqForPlan", "", "All"}
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}	


	/**
	 * ESM_CSQ_0213 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaLoadRevForSectorList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0213Event event = (EsmCsq0213Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			List<SearchQtaLoadRevForSectorListVO> list = command.searchQtaLoadRevForSectorList(event.getConditionVO());
			String rtnValue = command.searchQtaLoadRevForSectorListCnt(event.getConditionVO());			

			String[] cnt = rtnValue.split("[|]");
			if (cnt.length > 0) {
				eventResponse.setETCData("p_cnt", cnt[0]);
				eventResponse.setETCData("c_cnt", cnt[1]);
				eventResponse.setETCData("t_cnt", cnt[2]);
			} 
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_CSQ_0213 : [Creation]<br>
	 * [QTA Set up for IAS Sector by Head Office]의 [생성] 합니다.<br>
	 * 
	 * @param Event e
	 * @param String step
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createQtaLoadRevForSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0213Event event = (EsmCsq0213Event)e; 
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.createQtaLoadRevForSector(event.getConditionVO(), account);
			commit();
			
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
	 * ESM_CSQ_0213 : [Freezing]<br>
	 * [확정] 데이터를 [생성] 합니다.<br>
	 * 
	 * @param Event e
	 * @param String step
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createQtaFreezingForSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0213Event event = (EsmCsq0213Event)e; 
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.createQtaFreezingForSector(event.getConditionVO(), account);
			commit();
			
			// 데이터 생성후 버튼 컨트롤을 위해서 조회
			String rtnValue = command.searchQtaLoadRevForSectorListCnt(event.getConditionVO());			
			String[] cnt = rtnValue.split("[|]");
			if (cnt.length > 0) {
				eventResponse.setETCData("p_cnt", cnt[0]);
				eventResponse.setETCData("c_cnt", cnt[1]);
				eventResponse.setETCData("t_cnt", cnt[2]);
			} 
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
	 * ESM_CSQ_0213 : [1Q Transfer]<br>
	 * [1Q] 데이터를 [복사] 합니다.<br>
	 * 
	 * @param Event e
	 * @param String step
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createQtaTransferForSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0213Event event = (EsmCsq0213Event)e; 
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.createQtaTransferForSector(event.getConditionVO(), account);
			commit();
			// 데이터 생성후 버튼 컨트롤을 위해서 조회
			String rtnValue = command.searchQtaLoadRevForSectorListCnt(event.getConditionVO());			
			String[] cnt = rtnValue.split("[|]");
			if (cnt.length > 0) {
				eventResponse.setETCData("p_cnt", cnt[0]);
				eventResponse.setETCData("c_cnt", cnt[1]);
				eventResponse.setETCData("t_cnt", cnt[2]);
			} 
			
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
	 * ESM_CSQ_0213 : [Save]<br>
	 * [QTA Set up for IAS Sector by Head Office]을 [저장] 합니다.<br>
	 * 
	 * @param Event e
	 * @param String step
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse updateQtaLoadRevForSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0213Event event = (EsmCsq0213Event)e; 
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.updateQtaLoadRevForSector(event.getCsqSctrLodRevVOS(),event.getConditionVO(), account);
			commit();
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
	 * ESM_CSQ_0214 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Creation]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaLoadRevForSectorAddCreationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0214Event event = (EsmCsq0214Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			List<SearchQtaLoadRevForSectorAddListVO> list = command.searchQtaLoadRevForSectorAddCreationList(event.getConditionVO());
			log.debug("\n총 건수 :" + list.size());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_CSQ_0214 : [Creation]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Creation]의 [생성] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createQtaLoadRevForSectorAddCreation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0214Event event = (EsmCsq0214Event)e; 
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.createQtaLoadRevForSectorAddCreation(event.getConditionVO(), event.getCsqQtaLodRevForSectorAddListVOs(), account);
			commit();
			
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
	 * ESM_CSQ_0215 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Freezing]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaLoadRevForSectorAddFreezingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0215Event event = (EsmCsq0215Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			List<SearchQtaLoadRevForSectorAddListVO> list = command.searchQtaLoadRevForSectorAddFreezingList(event.getConditionVO());
			log.debug("\n총 건수 :" + list.size());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_CSQ_0215 : [Creation]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Freezing]의 [생성] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createQtaLoadRevForSectorAddFreezing(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0215Event event = (EsmCsq0215Event)e; 
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.createQtaLoadRevForSectorAddFreezing(event.getConditionVO(), event.getCsqQtaLodRevForSectorAddListVOs(), account);
			commit();
			
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
	 * ESM_CSQ_0216 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0216(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Next Quarter. */
					{"nextQta", "", ""},
					/* 4. Office View */
					{"officeView", "", ""},
					/* 5. Bound. */
					{"comCodeBound", "", "All"},					
					/* 6. RHQ. */
					{"rhqForPlan", "", "All"}
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0216 : [Retrieve]<br>
	 * [QTA Set Up for IAS Sector by Head Office_Summary]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaSetupForIsaSecByHoSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0216Event event = (EsmCsq0216Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			List<SearchQtaSetupForIsaSecByHoSummaryVO> list = command.searchQtaSetupForIsaSecByHoSummary(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_CSQ_0217 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0217(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Next Quarter. */
					{"nextQta", "", ""},					
					/* 3. Office View */
					{"officeView", "", ""},
					/* 4. Office level */
					{"comCodeOfcLvl", "", ""},   
					/* 5. RHQ. */
					{"rhqForPlan", "", "All"},
					/* 6. Bound. */
					{"comCodeBound", "", "All"}		
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0217 : [Retrieve]<br>
	 * [Planning QTA Inquiry_Yearly Planning_IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPlanningQtaYrIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0217Event event = (EsmCsq0217Event)e;
		PlanningInquiryBC command = new PlanningInquiryBCImpl();
		
		try {
			List<SearchPlanningQtaIasSectorVO> list = command.searchPlanningQtaYrIasSector(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_CSQ_0218 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0218(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Next Quarter. */
					{"nextQta", "", ""},
					/* 4. Office View */
					{"officeView", "", ""},
					/* 5. Office level */
					{"comCodeOfcLvl", "", ""},   
					/* 6. RHQ. */
					{"rhqForPlan", "", "All"},
					/* 7. Bound. */
					{"comCodeBound", "", "All"}	
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}	
	
	/**
	 * ESM_CSQ_0218 : [Retrieve]<br>
	 * [Planning QTA Inquiry_Quarterly Planning_IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPlanningQtaQtrIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0218Event event = (EsmCsq0218Event)e;
		PlanningInquiryBC command = new PlanningInquiryBCImpl();
		
		try {
			List<SearchPlanningQtaIasSectorVO> list = command.searchPlanningQtaQtrIasSector(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}	
	
}