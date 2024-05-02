/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : SpecialkpiSC.java
*@FileTitle      : specialkpi
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.08
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.08 이혜민
* 1.0 Creation
* 2014.01.16 PEJ   [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2014.09.17 이혜민 [CHM-201431755-01] New Lane Add시 Bound 삽입
* 2014.11.07 이혜민 [CHM-201432524] Current KPI Report 화면 내 Trade Direction 조건 추가
* 2014.12.12 이혜민 [CHM-201432763] RF SPCL TPSZ Master 화면 신규 생성
* 2015.08.06 김용습 [CHM-201537260] [CSR 전환 건] SQM내 Report에 과거 CM 체계 기준 판매목표 데이터 조회 기능 생성 (15년 2Q 이전 데이터 Freeze)
* 2015.11.09 김용습 [CHM-201538494] [CSR 전환건] SKD Adjustment by VVD 화면 보완 (Trade Direction, Adjusting VVD Select, BSA Flag 칼럼 추가)
* 2015.11.10 김성욱 [CHM-201538496] [CSR 전환건] KPI Creation & Edit 화면 보완 (Trade Direction 칼럼 추가)
* 2015.11.19 김용습 [CHM-201538497] [CSR 전환건] KPI Input by Head Office 화면 보완 (Trade Direction 칼럼 추가)
* 2015.11.19 김용습 [CHM-201538495] [CSR 전환건] Basic CMCB 화면 보완 (Trade Direction 칼럼 추가)
* 2015.11.24 김용습 [CHM-201538493] [CSR 전환건] Current KPI Report 화면 보완 (조회 조건 Week → Month 변경, Raw Data Export 버튼 추가)
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi;

import java.util.List;

import com.hanjin.apps.alps.esm.sqm.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.sqm.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.basic.OfficeMappingBC;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.basic.OfficeMappingBCImpl;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.event.EsmSqm0204Event;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.vo.SearchSectorOfcRelationSetListVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.basic.AdjustmentBC;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.basic.AdjustmentBCImpl;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.event.EsmSqm0504Event;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.event.EsmSqm0505Event;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.event.EsmSqm0506Event;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.event.EsmSqm0507Event;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.event.EsmSqm0508Event;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.event.EsmSqm0509Event;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo.SearchCurrentKpiReportVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo.SearchKpiCreationEditNewOfcHisVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo.SearchKpiCreationEditVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo.SearchQtaAdjustmentListVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo.SearchReeferSpclTpSzMgmtVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.basic.SpclPlanningBC;
import com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.basic.SpclPlanningBCImpl;
import com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.event.EsmSqm0501Event;
import com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.event.EsmSqm0502Event;
import com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.event.EsmSqm0503Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SqmSpclLaneOfcCostVO;
import com.hanjin.syscommon.common.table.SqmSpclLodRevVO;
import com.hanjin.syscommon.common.table.SqmSpclNewLaneVO;

/**
 * ALPS-SpecialKpi Business Logic ServiceCommand - ALPS-SpecialKpi 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author HYEMIN LEE
 * @see SpecialkpiDBDAO
 * @since J2EE 1.6
 */

public class SpecialKpiSC extends ServiceCommandSupport {
	
	// Login User Information
	private SignOnUserAccount account = null;
	
	/**
	 * SpecialKpi system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("SpecialkpiSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}
	
	/**
	 * Specialkpi system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("SpecialkpiSC 종료");
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
		if (e.getEventName().equalsIgnoreCase("EsmSqm0501Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0501(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKpiInputbyHeadOffice(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageKpiInputbyHeadOffice(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createKpiInputbyHeadOffice(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0502Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0502(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicCmcb(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBasicCmcb(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createBasicCmcb(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0503Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0503(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createBasicCmcbNewLane(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0504Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0504(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKpiCreationEdit(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = search1QTransferDataCnt(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageKpiCreationEdit(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createKpiCreationEdit(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = create1QTransferData(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0505Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0505(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKpiCreationEditNewLaneHis(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createKpiCreationEditNewLane(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchNewLaneAddBound(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0506Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0506(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKpiCreationEditNewOfcHis(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createKpiCreationEditNewOfc(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0507Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaAdjustmentList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageQtaAdjustment(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0507(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0508Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0508(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCurrentKpiReport(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCurrentKpiReportPreviousVersion(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = excelDownCurrentKPIReport(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0509Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReeferSpclTpSzMgmt(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageReeferSpclTpSzMgmt(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0501 : [INIT]
	 * 공통코드 조회 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0501(Event e) throws EventException {
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
					/* 4. Trade */
					{"mdmTrade", "", "All"},
					/* 5. Bound. */
					{"comCodeBound", "", "All"},
					/* 6. RHQ. */
					{"rhq", "", "All"},
					/* 7. trade Direction. */
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
	 * ESM_SQM_0501 : [SEARCH]<br>
	 * [KPI Input by Head Office]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKpiInputbyHeadOffice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0501Event event = (EsmSqm0501Event)e;
		SpclPlanningBC command = new SpclPlanningBCImpl();
		
		try{
			List<SqmSpclLodRevVO> list = command.searchKpiInputbyHeadOffice(event.getConditionVO());
			String dataCnt = command.searchKpiInputbyHeadOfficeCnt(event.getConditionVO());
			
			eventResponse.setETCData("dataCnt", dataCnt);
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
	 * ESM_SQM_0501 : [MULTI]<br>
	 * [KPI Input by Head Office]을 [저장] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageKpiInputbyHeadOffice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0501Event event = (EsmSqm0501Event)e;
		SpclPlanningBC command = new SpclPlanningBCImpl();
		
		try {
			begin();
			command.manageKpiInputbyHeadOffice(event.getConditionVO(), event.getSqmSpclLodRevVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0501 : [MULTI01]<br>
	 * [KPI Input by Head Office]을 [생성] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createKpiInputbyHeadOffice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0501Event event = (EsmSqm0501Event)e;
		SpclPlanningBC command = new SpclPlanningBCImpl();
		
		try {
			begin();
			command.createKpiInputbyHeadOffice(event.getConditionVO(), account.getUsr_id());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0502 : [INIT]
	 * 공통코드 조회 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0502(Event e) throws EventException {
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
					/* 4. Trade */
					{"mdmTrade", "", "All"},
					/* 5. Bound. */
					{"comCodeBound", "", "All"},
					/* 6. RHQ. */
					{"rhq", "", "All"},
					/* 7. trade Direction. */
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
	 * ESM_SQM_0502 : [SEARCH]<br>
	 * [Basic CMCB]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicCmcb(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0502Event event = (EsmSqm0502Event)e;
		SpclPlanningBC command = new SpclPlanningBCImpl();
		
		try{
			List<SqmSpclLaneOfcCostVO> list = command.searchBasicCmcb(event.getConditionVO());
			String dataCnt = command.searchBasicCmcbCnt(event.getConditionVO());
			
			eventResponse.setETCData("dataCnt", dataCnt);
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
	 * ESM_SQM_0502 : [MULTI]<br>
	 * [Basic CMCB]을 [저장] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageBasicCmcb(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0502Event event = (EsmSqm0502Event)e;
		SpclPlanningBC command = new SpclPlanningBCImpl();
		
		try {
			begin();
			command.manageBasicCmcb(event.getConditionVO(), event.getSqmSpclLaneOfcCostVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0502 : [MULTI01]<br>
	 * [Basic CMCB]을 [생성] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createBasicCmcb(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0502Event event = (EsmSqm0502Event)e;
		SpclPlanningBC command = new SpclPlanningBCImpl();
		
		try {
			begin();
			command.createBasicCmcb(event.getConditionVO(), account.getUsr_id());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0503 : [INIT]
	 * 공통코드 조회 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0503(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Trade */
					{"mdmTrade", "", ""},
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
	 * ESM_SQM_0503 : [MULTI01]<br>
	 * [Basic CMCB New Lane]을 [생성] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createBasicCmcbNewLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0503Event event = (EsmSqm0503Event)e;
		SpclPlanningBC command = new SpclPlanningBCImpl();
		
		try {
			begin();
			String istCnt = command.createBasicCmcbNewLane(event.getConditionVO(), account.getUsr_id());
			eventResponse.setETCData("istCnt", istCnt);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0504 : [INIT]
	 * 공통코드 조회 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0504(Event e) throws EventException {
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
					/* 4. Trade */
					{"mdmTrade", "", ""},
					/* 6. Bound. */
					{"comCodeBound", "", "All"},
					/* 7. RHQ. */
					{"rhq", "", "All"},
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
	 * ESM_SQM_0504 : [SEARCH]<br>
	 * [KPI Creation & Edit]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKpiCreationEdit(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0504Event event = (EsmSqm0504Event)e;
		AdjustmentBC command = new AdjustmentBCImpl();
		
		try{
			List<SearchKpiCreationEditVO> list = command.searchKpiCreationEdit(event.getConditionVO());
			String dataCnt = command.searchKpiCreationEditCnt(event.getConditionVO());
			
			eventResponse.setETCData("dataCnt", dataCnt);
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
	 * ESM_SQM_0504 : [SEARCH01]<br>
	 * [KPI Creation & Edit]화면에서 Creation 후 또는 이미 Yearly 데이터가 있을 경우 1Q 데이터가 있는지 없는지 [확인]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse search1QTransferDataCnt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0504Event event = (EsmSqm0504Event)e;
		AdjustmentBC command = new AdjustmentBCImpl();
		
		try{
			String dataCnt = command.search1QTransferDataCnt(event.getConditionVO());
			
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
	 * ESM_SQM_0504 : [MULTI]<br>
	 * [KPI Creation & Edit]을 [저장] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageKpiCreationEdit(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0504Event event = (EsmSqm0504Event)e;
		AdjustmentBC command = new AdjustmentBCImpl();
		
		try {
			begin();
			command.manageKpiCreationEdit(event.getConditionVO(), event.getSqmSpclCfmQtaVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0504 : [MULTI01]<br>
	 * [KPI Creation & Edit]을 [생성] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createKpiCreationEdit(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0504Event event = (EsmSqm0504Event)e;
		AdjustmentBC command = new AdjustmentBCImpl();
		
		try {
			begin();
			command.createKpiCreationEdit(event.getConditionVO(), account.getUsr_id());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0504 : [MULTI02]<br>
	 * [1Q Data]을 [Transfer] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse create1QTransferData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0504Event event = (EsmSqm0504Event)e;
		AdjustmentBC command = new AdjustmentBCImpl();
		
		try {
			begin();
			command.create1QTransferData(event.getConditionVO(), account.getUsr_id());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0505 : [INIT]
	 * 공통코드 조회 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0505(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Trade */
					{"mdmTrade", "", ""},
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
	 * ESM_SQM_0505 : [SEARCH]<br>
	 * [KPI Creation & Edit New Lane Add History]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKpiCreationEditNewLaneHis(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0505Event event = (EsmSqm0505Event)e;
		AdjustmentBC command = new AdjustmentBCImpl();
		
		try{
			List<SqmSpclNewLaneVO> list = command.searchKpiCreationEditNewLaneHis(event.getConditionVO());
			
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
	 * ESM_SQM_0505 : [MULTI]<br>
	 * [KPI Creation & Edit New Lane Add]을 [생성] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createKpiCreationEditNewLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0505Event event = (EsmSqm0505Event)e;
		AdjustmentBC command = new AdjustmentBCImpl();
		
		try {
			begin();
			String istCnt = command.createKpiCreationEditNewLane(event.getConditionVO(), account.getUsr_id());
			eventResponse.setETCData("istCnt", istCnt);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0505 : [SEARCH01]<br>
	 * [KPI Creation & Edit New Lane Add] 팝업 내 New Lane 입력시 Bound를 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNewLaneAddBound(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0505Event event = (EsmSqm0505Event)e;
		AdjustmentBC command = new AdjustmentBCImpl();
		
		try{
			String tBound = command.searchNewLaneAddBound(event.getConditionVO());
			
			eventResponse.setETCData("tBound", tBound);
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
	 * ESM_SQM_0506 : [INIT]
	 * 공통코드 조회 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0506(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Trade */
					{"mdmTrade", "", ""},
					/* 2. Bound. */
					{"comCodeBound", "", ""},
					/* 3. RHQ. */
					{"rhq", "", ""}
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
	 * ESM_SQM_0506 : [SEARCH]<br>
	 * [KPI Creation & Edit New Office Add History]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKpiCreationEditNewOfcHis(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0506Event event = (EsmSqm0506Event)e;
		AdjustmentBC command = new AdjustmentBCImpl();
		
		try{
			List<SearchKpiCreationEditNewOfcHisVO> list = command.searchKpiCreationEditNewOfcHis(event.getConditionVO());
			
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
	 * ESM_SQM_0506 : [MULTI]<br>
	 * [KPI Creation & Edit New Office]을 [생성] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createKpiCreationEditNewOfc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0506Event event = (EsmSqm0506Event)e;
		AdjustmentBC command = new AdjustmentBCImpl();
		
		try {
			begin();
			command.createKpiCreationEditNewOfc(event.getConditionVO(), event.getSqmSpclNewOfcVOS(), account.getUsr_id());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0507 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0507(Event e) throws EventException {
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
					/* 4. Trade */
					{"mdmTrade", "", ""},
					/* 5. Bound. */
					{"comCodeBound", "", "All"},
					/*6. Currently Quarter*/
					{"currentQta", "", ""},
					/* 7. trade Direction. */
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
	 * ESM_SQM_0507 : Retrieve 이벤트 처리<br>
	 * [SKD Adjustment by VVD]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchQtaAdjustmentList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0507Event event = (EsmSqm0507Event)e;
		AdjustmentBC command = new AdjustmentBCImpl();
		
		try{
			List<SearchQtaAdjustmentListVO> list = command.searchQtaAdjustmentList(event.getConditionVO(), account);
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
	 * ESM_SQM_0507 : MULTI 이벤트 처리<br>
	 * [SKD Adjustment by VVD]을 [CUD 처리] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageQtaAdjustment(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0507Event event = (EsmSqm0507Event)e;
		AdjustmentBC command = new AdjustmentBCImpl();
		
		try {
			begin();
			command.manageQtaAdjustment(event.getManageQtaAdjustmentVOS(), event.getConditionVO(), account);
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
	 * ESM_SQM_0508 : [INIT]
	 * 공통코드 조회 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0508(Event e) throws EventException {
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
					/* 4. Trade */
					{"mdmTrade", "", "All"},
					/* 5. Bound. */
					{"comCodeBound", "", "All"},
					/* 6. RHQ. */
					{"rhq", "", "All"},
					/* 7. Office level */
					{"comCodeOfcLvl", "", ""},
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
	 * ESM_SQM_0508 : [SEARCH]<br>
	 * [Current KPI Report]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrentKpiReport(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0508Event event = (EsmSqm0508Event)e;
		AdjustmentBC command = new AdjustmentBCImpl();
		
		try{
			List<SearchCurrentKpiReportVO> list = command.searchCurrentKpiReport(event.getConditionVO(), "N");
			
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
	 * ESM_SQM_0508 : [SEARCH02]<br>
	 * [Current KPI Report]을 [조회]합니다. (PreviousVersion)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrentKpiReportPreviousVersion(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0508Event event = (EsmSqm0508Event)e;
		AdjustmentBC command = new AdjustmentBCImpl();
		
		try{
			List<SearchCurrentKpiReportVO> list = command.searchCurrentKpiReportPreviousVersion(event.getConditionVO());
			
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
	 * ESM_SQM_0508 : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse excelDownCurrentKPIReport(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0508Event event = (EsmSqm0508Event)e;
		AdjustmentBC command = new AdjustmentBCImpl();
		
		try {
			List<SearchCurrentKpiReportVO> list = command.searchCurrentKpiReport(event.getConditionVO(), "Y");
			
			if(list.size() > 0 && list != null){
				String headTitle    = "Year￠Quarter￠RHQ￠Office￠Trade￠Sub Trade￠Lane￠Lane Bound￠Trade Bound￠Trade Direction￠Month￠Week￠VVD￠Supply￠Load￠G.RPB￠G.REV￠CM Cost(PA)￠CM Cost(RA)￠CMCB(PA)￠CMCB(RA)￠CM(PA)￠CM(RA)￠CMPB(PA)￠CMPA(RA)";
				String column_names = "bse_yr￠bse_qtr_cd￠rhq_cd￠rgn_ofc_cd￠trd_cd￠sub_trd_cd￠rlane_cd￠dir_cd￠conv_dir_cd￠hul_bnd_cd￠bse_mon￠bse_wk￠vvd￠fnl_bsa_capa￠lod_qty￠grpb￠grev￠pa_cm_cost￠ra_cm_cost￠pa_cmcb￠ra_cmcb￠pa_cm￠ra_cm￠pa_cmpb￠ra_cmpb"; 
				
				String title[]   = headTitle.split("￠");
				String columns[] = column_names.split("￠");
				
				eventResponse.setCustomData("vos", list);
				eventResponse.setCustomData("title", title);
				eventResponse.setCustomData("columns", columns);
				eventResponse.setCustomData("fileName", "Current_KPI_Report.xls");
				eventResponse.setCustomData("isZip", false);
			} else {
				SearchCurrentKpiReportVO vo = new SearchCurrentKpiReportVO();
				
				vo.setBseYr("There is no data to search.");
				
				list.add(vo);
				
				String headTitle    = "Data";
				String column_names = "bse_yr"; 
				
				String title[]   = headTitle.split("￠");
				String columns[] = column_names.split("￠");
				
				eventResponse.setCustomData("vos", list);
				eventResponse.setCustomData("title", title);
				eventResponse.setCustomData("columns", columns);
				eventResponse.setCustomData("fileName", "Current_KPI_Report.xls");
				eventResponse.setCustomData("isZip", false);
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0509 : [SEARCH]<br>
	 * [Reefer/Special Type/Size Master]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReeferSpclTpSzMgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0509Event event = (EsmSqm0509Event)e;
		AdjustmentBC command = new AdjustmentBCImpl();
		
		try{
			List<SearchReeferSpclTpSzMgmtVO> list = command.searchReeferSpclTpSzMgmt(event.getConditionVO());
			
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
	 * ESM_SQM_0509 : [SAVE]<br>
	 * [Reefer/Special Type/Size Master]을 [저장]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageReeferSpclTpSzMgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0509Event event = (EsmSqm0509Event)e;
		AdjustmentBC command = new AdjustmentBCImpl();
		
		try{
			begin();
			command.manageReeferSpclTpSzMgmt(event.getSearchReeferSpclTpSzMgmtVOS(), account);
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
	
}