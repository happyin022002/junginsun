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
* 2015.05.15 이혜민 [CHM-201535608] Freezing전 RHQ별 Portion 존재하고, Office portion이 없는 List 조회.
* 2015.09.17 김용습 [CHM-201537764] [CSR 전환건] QTA Set up by Head Office for IAS Sector 화면 내 Raw Data Export 버튼 신규 생성  
* 2015.09.22 김용습 [CHM-201537819] [CSR 전환건] QTA Set up by Head Office for IAS Sector 화면 내 Freezing, Add-Freezing 버튼 Validation 추가
* 2016.07.04 최성민 [CHM-201642330] SQM 화면 버튼 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning;

import java.util.List;

import com.hanjin.apps.alps.esm.sqm.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.sqm.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.sqm.planning.planning.basic.PlanningBC;
import com.hanjin.apps.alps.esm.sqm.planning.planning.basic.PlanningBCImpl;
import com.hanjin.apps.alps.esm.sqm.planning.planning.event.EsmSqm0014Event;
import com.hanjin.apps.alps.esm.sqm.planning.planning.event.EsmSqm0015Event;
import com.hanjin.apps.alps.esm.sqm.planning.planning.event.EsmSqm0016Event;
import com.hanjin.apps.alps.esm.sqm.planning.planning.event.EsmSqm0017Event;
import com.hanjin.apps.alps.esm.sqm.planning.planning.event.EsmSqm0018Event;
import com.hanjin.apps.alps.esm.sqm.planning.planning.event.EsmSqm0019Event;
import com.hanjin.apps.alps.esm.sqm.planning.planning.event.EsmSqm0020Event;
import com.hanjin.apps.alps.esm.sqm.planning.planning.event.EsmSqm0021Event;
import com.hanjin.apps.alps.esm.sqm.planning.planning.event.EsmSqm0022Event;
import com.hanjin.apps.alps.esm.sqm.planning.planning.event.EsmSqm0025Event;
import com.hanjin.apps.alps.esm.sqm.planning.planning.event.EsmSqm0040Event;
import com.hanjin.apps.alps.esm.sqm.planning.planning.event.EsmSqm0213Event;
import com.hanjin.apps.alps.esm.sqm.planning.planning.event.EsmSqm0214Event;
import com.hanjin.apps.alps.esm.sqm.planning.planning.event.EsmSqm0215Event;
import com.hanjin.apps.alps.esm.sqm.planning.planning.event.EsmSqm0216Event;
import com.hanjin.apps.alps.esm.sqm.planning.planning.integration.PlanningDBDAO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaByRhqListVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaByRhqResultVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaByRhqSimulationVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaLoadRevForSectorAddListVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaLoadRevForSectorListVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaLoadRevListVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaRhqDistributeResultListVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaRhqQtaSummaryListVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaSetUpHeadOfficeListVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaSetupForIsaSecByHoSummaryVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchRbcLaneQtaListVO;
import com.hanjin.apps.alps.esm.sqm.planning.planninginquiry.basic.PlanningInquiryBC;
import com.hanjin.apps.alps.esm.sqm.planning.planninginquiry.basic.PlanningInquiryBCImpl;
import com.hanjin.apps.alps.esm.sqm.planning.planninginquiry.event.EsmSqm0029Event;
import com.hanjin.apps.alps.esm.sqm.planning.planninginquiry.event.EsmSqm0030Event;
import com.hanjin.apps.alps.esm.sqm.planning.planninginquiry.event.EsmSqm0217Event;
import com.hanjin.apps.alps.esm.sqm.planning.planninginquiry.event.EsmSqm0218Event;
import com.hanjin.apps.alps.esm.sqm.planning.planninginquiry.vo.SearchPlanningQtaIasSectorVO;
import com.hanjin.apps.alps.esm.sqm.planning.planninginquiry.vo.SearchQtaInquiryListVO;
import com.hanjin.apps.alps.esm.sqm.planning.statusmanage.basic.StatusManageBC;
import com.hanjin.apps.alps.esm.sqm.planning.statusmanage.basic.StatusManageBCImpl;
import com.hanjin.apps.alps.esm.sqm.planning.statusmanage.event.EsmSqm0028Event;
import com.hanjin.apps.alps.esm.sqm.planning.statusmanage.vo.SearchQtaEstablishingStatusListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

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
		if (e.getEventName().equalsIgnoreCase("EsmSqm0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaLoadRevList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0014(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageQtaLoadRev(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = confirmQtaLoadRev(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0015Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRbcLaneQtaList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0015(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createRbcLaneQtaSetting(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRbcLaneQtaSetting(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0016Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaSetUpHeadOfficeList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageQtaSetUpHeadOffice(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = confirmQtaSetUpHeadOffice(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0016(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0017Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaRhqDistributeResultList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0018Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaRhqQtaSummaryList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0019Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaByRhqObLoadList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0019(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageQtaByRhqObLoad(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = confirmQtaByRhqObLoad(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0020Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchQtaByRhqResult(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0021Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchQtaByRhqSimulation(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0022Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaByRhqNobCtrtList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0022(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageQtaByRhqNobCtrt(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = confirmQtaByRhqNobCtrt(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0025Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaByRhqobCtrtList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0025(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageQtaByRhqobCtrt(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = confirmQtaByRhqobCtrt(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLoadingViewFigureList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0028Event")) { 
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
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchOfcZeroPortion(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0028(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0029Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaInquiryForYear(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0029(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0030Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaInquiryForQuarter(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0030(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0040Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaByRhqCtrtList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0040(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0213Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {       // Loading 시 콤보 세팅
				eventResponse = searchComBoCdList0213(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Retrieve
				eventResponse = searchQtaLoadRevForSectorList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) { // Raw Data Export
				eventResponse = searchRawDataOfQtaLoadRevForSectorList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) { // Freezing 및 Add-Freezing 시도시 Load가 0이 아닌데 G.RPB가 0인 데이터를 찾아냄
				eventResponse = searchProblematicDataInFreezing(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Save
				eventResponse = updateQtaLoadRevForSector(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) { // Creation
				eventResponse = createQtaLoadRevForSector(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI03)) { // Freezing
				eventResponse = createQtaFreezingForSector(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI04)) { // 1Q Transfer
				eventResponse = createQtaTransferForSector(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0214Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0214(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaLoadRevForSectorAddCreationList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createQtaLoadRevForSectorAddCreation(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0215Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0215(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaLoadRevForSectorAddFreezingList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createQtaLoadRevForSectorAddFreezing(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0216Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0216(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaSetupForIsaSecByHoSummary(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0217Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0217(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPlanningQtaYrIasSector(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0218Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0218(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPlanningQtaQtrIasSector(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0014 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0014(Event e) throws EventException {
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
					/* 4. trade Direction. */
					{"comCodeTrdDir", "", "All"}
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
	 * ESM_SQM_0015 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0015(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year. */
					{"year", "", ""},
					/* 2. Quarter. */
					{"quarter", "", ""},
					/* 3. Next Quarter. */
					{"nextQta", "", ""},
					/* 4. Office View. */
					{"officeView", "", ""},
					/* 5. RHQ. */
					{"rhq", "", "All"},
					/* 6. Office. */
					{"office", "", "All"}
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
	 * ESM_SQM_0016 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0016(Event e) throws EventException {
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
					/* 6. trade Direction. */
					{"comCodeTrdDir", "", "All"},
					/* 7. Out/Non Out Bound. */
					{"comCodeOutNonOutBound", "", "All"},
					/* 8. RHQ. */
					{"rhq", "", "All"}
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
	 * ESM_SQM_0019 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0019(Event e) throws EventException {
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
					{"officeForPlan",account.getOfc_cd(), "All"},
					/* 5. trade Direction. */
					{"comCodeTrdDir", "", "All"} 
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
	 * ESM_SQM_0022 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0022(Event e) throws EventException {
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
					{"officeForPlan",account.getOfc_cd(), "All"},
					/* 5. trade Direction. */
					{"comCodeTrdDir", "", "All"}
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
	 * ESM_SQM_0025 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0025(Event e) throws EventException {
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
					{"officeForPlan",account.getOfc_cd(), "All"},
					/* 5. trade Direction. */
					{"comCodeTrdDir", "", "All"}
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
	 * ESM_SQM_0028 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0028(Event e) throws EventException {
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
	 * ESM_SQM_0029 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0029(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Office level */
					{"comCodeOfcLvl", "", ""},   
					/* 3. Trade */
					{"mdmTrade", "", "All"},
					/* 4. RHQ. */
					{"rhq", "", "All"},
					/* 5. Office View */
					{"officeView", "", ""},
					/* 6. Bound. */
					{"comCodeBound", "", "All"},
					/* 7. Next Quarter. */
					{"nextQta", "", ""},
					/* 8. trade Direction. */
					{"comCodeTrdDir", "", "All"}
					
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
	 * ESM_SQM_0030 : 공통코드 조회 이벤트 처리<br>
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
					/* 2. Office level */
					{"comCodeOfcLvl", "", ""},   
					/* 3. Trade */
					{"mdmTrade", "", "All"},
					/* 4. RHQ. */
					{"rhq", "", "All"},
					/* 5. Office View */
					{"officeView", "", ""},
					/* 6. Bound. */
					{"comCodeBound", "", "All"},
					/* 7. Quarter */
					{"quarter", "", ""},
					/* 8. Next Quarter. */
					{"nextQta", "", ""},
					/* 9. trade Direction. */
					{"comCodeTrdDir", "", "All"}
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
	 * ESM_SQM_0015 : Retrieve 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRbcLaneQtaList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0015Event event = (EsmSqm0015Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			List<SearchRbcLaneQtaListVO> list = command.searchRbcLaneQtaList(event.getConditionVO());
			String dataCnt = command.searchRbcLaneQtaListCnt(event.getConditionVO());
			
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
	 * ESM_SQM_0015 : MULTI01 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createRbcLaneQtaSetting(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0015Event event = (EsmSqm0015Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.createRbcLaneQtaSetting(event.getConditionVO(), account.getUsr_id());
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
	 * ESM_SQM_0015 : MULTI 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageRbcLaneQtaSetting(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0015Event event = (EsmSqm0015Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.manageRbcLaneQtaSetting(event.getConditionVO(), event.getSqmQtaRbcVOS(), account);
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
	 * ESM_SQM_0014 : Retrieve 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaLoadRevList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0014Event event = (EsmSqm0014Event)e;
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
	 * ESM_SQM_0014 : MULTI 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageQtaLoadRev(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0014Event event = (EsmSqm0014Event)e; 
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.manageQtaLoadRev(event.getConditionVO(), event.getSqmQtaLodRevVOS(), account);
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
	 * ESM_SQM_0014 : MULTI01 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse confirmQtaLoadRev(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0014Event event = (EsmSqm0014Event)e; 
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
	 * ESM_SQM_0016 : [이벤트]<br>
	 * [QTA Set-up by Head Office]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaSetUpHeadOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0016Event event = (EsmSqm0016Event)e;
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
	 * ESM_SQM_0016 : [이벤트]<br>
	 * [QTA Set-up by Head Office]을 [수정] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageQtaSetUpHeadOffice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0016Event event = (EsmSqm0016Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.manageQtaSetUpHeadOffice(event.getSqmQtaPotnMgmtVOS(), event.getConditionVO(), account);
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
	 * ESM_SQM_0016 : [이벤트]<br>
	 * [QTA Set-up by Head Office]을 [confirm] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse confirmQtaSetUpHeadOffice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0016Event event = (EsmSqm0016Event)e; 
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
	 * ESM_SQM_0017 : [이벤트]<br>
	 * [QTA Set up by Head Office RHQ Distribute Result]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaRhqDistributeResultList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0017Event event = (EsmSqm0017Event)e;
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
	 * ESM_SQM_0018 : [이벤트]<br>
	 * [QTA Set up by Head Office RHQ QTA Summary]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaRhqQtaSummaryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0018Event event = (EsmSqm0018Event)e;
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
	 * ESM_SQM_0019 : Retrieve 이벤트 처리<br>
	 * [QTA Set up by RHQ_OB Loading]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaByRhqObLoadList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0019Event event = (EsmSqm0019Event)e;
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
	 * ESM_SQM_0019 : MULTI 이벤트 처리<br>
	 * [QTA Set up by RHQ_OB Loading]을 [저장] 합니다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageQtaByRhqObLoad(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0019Event event = (EsmSqm0019Event)e; 
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.manageQtaByRhq(event.getConditionVO(), event.getSqmQtaPotnMgmtVOS(), account);
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
	 * ESM_SQM_0019 : MULTI01 이벤트 처리<br>
	 * [QTA Set up by RHQ_OB Loading]을 [컨펌] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse confirmQtaByRhqObLoad(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0019Event event = (EsmSqm0019Event)e; 
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
	 * ESM_SQM_0022 : Retrieve 이벤트 처리<br>
	 * [QTA Set up by RHQ_NON OB Contract]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaByRhqNobCtrtList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0022Event event = (EsmSqm0022Event)e;
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
	 * ESM_SQM_0022 : MULTI 이벤트 처리<br>
	 * [QTA Set up by RHQ_NON OB Contract]을 [저장] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageQtaByRhqNobCtrt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0022Event event = (EsmSqm0022Event)e; 
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.manageQtaByRhq(event.getConditionVO(), event.getSqmQtaPotnMgmtVOS(), account);
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
	 * ESM_SQM_0022 : MULTI01 이벤트 처리<br>
	 * [QTA Set up by RHQ_NON OB Contract]을 [컨펌] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse confirmQtaByRhqNobCtrt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0022Event event = (EsmSqm0022Event)e; 
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
	 * ESM_SQM_0020 : Retrieve 이벤트 처리<br>
	 * [ QTA Set-up by RHQ _Office Distribute Result] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaByRhqResult(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0020Event event = (EsmSqm0020Event)e;
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
	 * ESM_SQM_0021 : Retrieve 이벤트 처리<br>
	 * [QTA Set-up by RHQ _Office QTA Simulation]을 [조회] 합니다
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaByRhqSimulation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0021Event event = (EsmSqm0021Event)e;
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
	 * ESM_SQM_0025 : Retrieve 이벤트 처리<br>
	 * [QTA Set up by RHQ_OB Contract]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaByRhqobCtrtList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0025Event event = (EsmSqm0025Event)e;
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
	 * ESM_SQM_0025 : Retrieve 이벤트 처리<br>
	 * [Loading View Figure Copy]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLoadingViewFigureList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0025Event event = (EsmSqm0025Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			List<SearchQtaByRhqListVO> list = command.searchLoadingViewFigureList(event.getConditionVO(),account);
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
	 * ESM_SQM_0025 : MULTI 이벤트 처리<br>
	 * [QTA Set up by RHQ_OB Contract]을 [저장] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageQtaByRhqobCtrt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0025Event event = (EsmSqm0025Event)e; 
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.manageQtaByRhq(event.getConditionVO(), event.getSqmQtaPotnMgmtVOS(), account);
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
	 * ESM_SQM_0025 : MULTI01 이벤트 처리<br>
	 * [QTA Set up by RHQ_OB Contract]을 [컨펌] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse confirmQtaByRhqobCtrt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0025Event event = (EsmSqm0025Event)e; 
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
	 * ESM_SQM_0028 : SEARCH 이벤트 처리<br>
	 * [QTA Establishing Status]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaEstablishingStatusList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0028Event event = (EsmSqm0028Event)e;
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
	 * ESM_SQM_0028 : MULTI 이벤트 처리<br>
	 * [QTA Establishing Status]을 [Cancel Confirm] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse cancelConfirmQtaStepVer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0028Event event = (EsmSqm0028Event)e; 
		StatusManageBC command = new StatusManageBCImpl();
		
		try {
			begin();
			command.cancelConfirmQtaStepVer(event.getSqmQtaStepVerVOS(),event.getConditionVO(), account);
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
	 * ESM_SQM_0028 : MULTI 이벤트 처리<br>
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
		EsmSqm0028Event event = (EsmSqm0028Event)e; 
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
	 * ESM_SQM_0028 : MULTI04 이벤트 처리<br>
	 * [QTA Establishing Status]을 [생성] 전 RHQ에는 Portion을 부여했으나 해당 RHQ 산하의 Office에게 Portion을 부여하지 않은 RHQ List를 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcZeroPortion(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0028Event event = (EsmSqm0028Event)e; 
		StatusManageBC command = new StatusManageBCImpl();
		String list = "";
		StringBuffer listTtl = new StringBuffer();

		try{
			List<String> OfcZeroPortion = command.searchOfcZeroPortion(event.getConditionVO());
			if(OfcZeroPortion.size()>0){
				for(int i=0; i<OfcZeroPortion.size(); i++){
					listTtl.append(",\n");
					listTtl.append(OfcZeroPortion.get(i));
					list = listTtl.toString();
				}
			}
			eventResponse.setETCData("OfcZeroPortion", list);
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
	 * ESM_SQM_0028 : MULTI04 이벤트 처리<br>
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
		EsmSqm0028Event event = (EsmSqm0028Event)e; 
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
	 * ESM_SQM_0028 : MULTI05 이벤트 처리<br>
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
		EsmSqm0028Event event = (EsmSqm0028Event)e; 
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
	 * ESM_SQM_0029 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Planning]을 [조회] 합니다
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaInquiryForYear(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0029Event event = (EsmSqm0029Event)e;
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
	 * ESM_SQM_0030 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Planning]을 [조회] 합니다
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaInquiryForQuarter(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0030Event event = (EsmSqm0030Event)e;
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
	 * ESM_SQM_0040 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0040(Event e) throws EventException {
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
					{"officeForPlan",account.getOfc_cd(), "All"},
					/* 6. trade Direction. */
					{"comCodeTrdDir", "", "All"}
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
	 * ESM_SQM_0040 : Retrieve 이벤트 처리<br>
	 * [QTA Set-up by RHQ (Contract TTL retrieve only)]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaByRhqCtrtList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0040Event event = (EsmSqm0040Event)e;
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
	 * ESM_SQM_0213 : 공통코드 조회 이벤트 처리<br>
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
					/* 5. sub Trade. */
					{"subTradeSector", "", "All"},
					/* 6. IAS Region */
					{"iasRegion", "", "All"},
					/* 7. Bound. */
					{"comCodeBound", "", "All"},
					/* 8. trade Direction. */
					{"comCodeTrdDir", "", "All"},					
					/* 9. RHQ. */
					{"rhq", "", "All"}
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
	 * ESM_SQM_0213 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaLoadRevForSectorList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0213Event event = (EsmSqm0213Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			List<SearchQtaLoadRevForSectorListVO> list = command.searchQtaLoadRevForSectorList(event.getConditionVO(), "N");
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
	 * ESM_SQM_0213 : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRawDataOfQtaLoadRevForSectorList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0213Event event = (EsmSqm0213Event)e;
		PlanningBC command = new PlanningBCImpl();

		try {
			eventResponse.setRs(command.searchRawDataOfQtaLoadRevForSectorList(event.getConditionVO(), "Y"));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0213 : Freezing 및 Add-Freezing 클릭시 발생<br>
	 * Freezing 및 Add-Freezing 시도시 Load가 0이 아닌데 G.RPB가 0인 데이터를 찾아냄
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProblematicDataInFreezing(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0213Event event = (EsmSqm0213Event)e;
		PlanningBC command = new PlanningBCImpl();

		try {
			eventResponse.setRs(command.searchProblematicDataInFreezing(event.getConditionVO(), "Y"));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0213 : [Creation]<br>
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
		EsmSqm0213Event event = (EsmSqm0213Event)e; 
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
	 * ESM_SQM_0213 : [Freezing]<br>
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
		EsmSqm0213Event event = (EsmSqm0213Event)e; 
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
	 * ESM_SQM_0213 : [1Q Transfer]<br>
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
		EsmSqm0213Event event = (EsmSqm0213Event)e; 
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
	 * ESM_SQM_0213 : [Save]<br>
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
		EsmSqm0213Event event = (EsmSqm0213Event)e; 
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.updateQtaLoadRevForSector(event.getSqmSctrLodRevVOS(),event.getConditionVO(), account);
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
	 * ESM_SQM_0214 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0214(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. sub Trade. */
					{"subTradeSector", "", ""},
					/* 2. IAS Region */
					{"iasRegion", "", "All"}
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
	 * ESM_SQM_0214 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Creation]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaLoadRevForSectorAddCreationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0214Event event = (EsmSqm0214Event)e;
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
	 * ESM_SQM_0214 : [Creation]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Creation]의 [생성] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createQtaLoadRevForSectorAddCreation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0214Event event = (EsmSqm0214Event)e; 
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.createQtaLoadRevForSectorAddCreation(event.getConditionVO(), event.getSqmQtaLodRevForSectorAddListVOs(), account);
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
	 * ESM_SQM_0215 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0215(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. sub Trade. */
					{"subTradeSector", "", ""},
					/* 2. IAS Region */
					{"iasRegion", "", "All"}
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
	 * ESM_SQM_0215 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Freezing]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaLoadRevForSectorAddFreezingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0215Event event = (EsmSqm0215Event)e;
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
	 * ESM_SQM_0215 : [Creation]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Freezing]의 [생성] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createQtaLoadRevForSectorAddFreezing(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0215Event event = (EsmSqm0215Event)e; 
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.createQtaLoadRevForSectorAddFreezing(event.getConditionVO(), event.getSqmQtaLodRevForSectorAddListVOs(), account);
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
	 * ESM_SQM_0216 : 공통코드 조회 이벤트 처리<br>
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
					/* 5. sub Trade. */
					{"subTradeSector", "", "All"},
					/* 6. IAS Region */
					{"iasRegion", "", "All"},
					/* 7. Bound. */
					{"comCodeBound", "", "All"},
					/* 8. trade Direction. */
					{"comCodeTrdDir", "", "All"},					
					/* 9. RHQ. */
					{"rhq", "", "All"}
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
	 * ESM_SQM_0216 : [Retrieve]<br>
	 * [QTA Set Up for IAS Sector by Head Office_Summary]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaSetupForIsaSecByHoSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0216Event event = (EsmSqm0216Event)e;
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
	 * ESM_SQM_0217 : 공통코드 조회 이벤트 처리<br>
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
					{"rhq", "", "All"},
					/* 6. sub Trade. */
					{"subTradeSector", "", "All"},
					/* 7. IAS Region */
					{"iasRegion", "", "All"},
					/* 8. Bound. */
					{"comCodeBound", "", "All"},
					/* 9. trade Direction. */
					{"comCodeTrdDir", "", "All"}		
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
	 * ESM_SQM_0217 : [Retrieve]<br>
	 * [Planning QTA Inquiry_Yearly Planning_IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPlanningQtaYrIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0217Event event = (EsmSqm0217Event)e;
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
	 * ESM_SQM_0218 : 공통코드 조회 이벤트 처리<br>
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
					{"rhq", "", "All"},
					/* 7. sub Trade. */
					{"subTradeSector", "", "All"},
					/* 8. IAS Region */
					{"iasRegion", "", "All"},
					/* 9. Bound. */
					{"comCodeBound", "", "All"},
					/* 10. trade Direction. */
					{"comCodeTrdDir", "", "All"}	
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
	 * ESM_SQM_0218 : [Retrieve]<br>
	 * [Planning QTA Inquiry_Quarterly Planning_IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPlanningQtaQtrIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0218Event event = (EsmSqm0218Event)e;
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