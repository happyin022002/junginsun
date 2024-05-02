/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PortChargeBudgetSC.java
 *@FileTitle : Lane/Port Expense Ratio Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.08.20
 *@LastModifier : 이혜민
 *@LastVersion : 1.0
 * 2009.05.27 박명종
 * 1.0 Creation
 * 
 * History
 * 2010.09.15 진마리아 CHM-201005696-01 지점및 지역 본부에서 Port charge inovice summary 수정 변경
 * 2010.10.27 진마리아 CHM-201006714-01 추정결산 로직 보완
 * 2010.12.08 진마리아 CHM-201007135-01 Vessel class 호출 로직 변경 요청건
 * 2011.03.04 진마리아 CHM-201108564-01 I/F to ERP화면내 조회 로직 및 버튼 추가
 * 2012.08.20 이혜민    CHM-201219078-01 사업계획 - 시나리오 연도 추가
 * 2013.03.18 S.K.Y  CHM-201323211 월 추정 Report 개발 (진행항차)
 * 2013.03.18 S.K.Y  CHM-201323212 월 추정 Report 개발 (대상항차)
 * 2013.04.26 조정민    CHM-201323376 Monthly Estimation Comparison (raw date 다운 포함)
 * 2013.06.10 S.K.Y  CHM-201323634 Budget Summary 조회 기능
 * 2013.09.03 SKY   CHM-201326398 Monthly Estimation Comparision 검색 조건(Scenario CD) 추가
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.basic.BudgetPortChargeMgtBC;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.basic.BudgetPortChargeMgtBCImpl;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0008Event;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0009Event;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0010Event;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0013Event;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0025Event;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0026Event;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0035Event;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0201Event;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0207Event;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0213Event;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0214Event;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.BudCreVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.BudEstSumByMonVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.ErpDtlVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.ErpSumVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.EstCreVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.EstExpnCreVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.EstTgtVvdByMonVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.ExpnDtlVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.InvSumByMonVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.InvSumDtlVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.PortChgBudByYearVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.basic.EstimationReportBC;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.basic.EstimationReportBCImpl;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.event.VopPso0100Event;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.event.VopPso0101Event;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.event.VopPso0102Event;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.BudgetSmryByVvdVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.EstimationByVvdVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.MonEstmCompVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.MonEstmRawDataForBudVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.MonEstmRawDataVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.basic.LaneExpenseRatioMgtBC;
import com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.basic.LaneExpenseRatioMgtBCImpl;
import com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.event.VopPso0006Event;
import com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.integration.LaneExpenseRatioMgtDBDAO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.vo.ServiceLaneListVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.vo.SvcLaneVO;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.basic.PSOCodeFinderBC;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.basic.PSOCodeFinderBCImpl;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.vo.CostListVO;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.vo.MdmVslCntrVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBC;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.OfficeVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-PortChargeBudget Business Logic ServiceCommand - ALPS-PortChargeBudget 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author myoungjong park
 * @see LaneExpenseRatioMgtDBDAO
 * @since J2EE 1.6
 */

public class PortChargeBudgetSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * PortChargeBudget system 업무 시나리오 선행작업<br>
	 * VSO_PSO_0006업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("PortChargeBudgetSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * PortChargeBudget system 업무 시나리오 마감작업<br>
	 * VSO_PSO_0006 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("PortChargeBudgetSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-PortChargeBudget system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VopPso0006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLaneExpenseRatioKeyValue(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchLaneExpnRto(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchPfLaneTypeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageLaneExpnRto(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = checkRevLane(e);
			}
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}
		if (e.getEventName().equalsIgnoreCase("VopPso0025Event")) {
			//PageLoad시.. 해당 VendorSeq의 BankInformation을 가지고 온다.
			if (e.getFormCommand().isCommand(FormCommand.SEARCH )) {
				eventResponse = searchSumRptByPeriodSo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchAccoutVslClassList(e);
			}
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}	
		if (e.getEventName().equalsIgnoreCase("VopPso0026Event")) {
			//PageLoad시.. 해당 VendorSeq의 BankInformation을 가지고 온다.
			if (e.getFormCommand().isCommand(FormCommand.SEARCH )) {
				eventResponse = searchSumRptByPeriodInv(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchAccoutVslClassList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBasicList(e);
			}
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}		
		//VOP_PSO_0008 Budget Creation [START]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		if (e.getEventName().equalsIgnoreCase("VopPso0008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.ADD)) {//Creation Button Click 처리 
				
				eventResponse = createPortChgBudByYear(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Retrieve
				
				boolean status = checkRunningBatch("VOP_PSO_B002");
				eventResponse = searchBudCreByMon(e);
				eventResponse.setETCData("IS_RUNNING", status == true ? "true" : "false");	
				
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {//OPEN (check running batch) jmh
				
				boolean status = checkRunningBatch("VOP_PSO_B002");
				eventResponse = new GeneralEventResponse();
				eventResponse.setETCData("IS_RUNNING", status == true ? "true" : "false");	
			}
		}		
		//VOP_PSO_0008 Budget Creation [E N D]<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		//VOP_PSO_0009 Estimate Creation [START]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		if (e.getEventName().equalsIgnoreCase("VopPso0009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.ADD)) {//Creation Button Click 처리 
				
				eventResponse = createEstExpnByMon(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Retrieve
				
				boolean status = checkRunningBatch("VOP_PSO_B003");
				eventResponse = searchEstCreByMon(e);
				eventResponse.setETCData("IS_RUNNING", status == true ? "true" : "false");
				
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {//OPEN (check running batch)
				
				boolean status = checkRunningBatch("VOP_PSO_B003");
				eventResponse = new GeneralEventResponse();
				eventResponse.setETCData("IS_RUNNING", status == true ? "true" : "false");	
			}
		}		
		//VOP_PSO_0009 Estimate Creation [E N D]<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		//VOP_PSO_0201 Expense Plan Per VVD(Pop-Up) [START]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		if (e.getEventName().equalsIgnoreCase("VopPso0201Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//PopUp실행시 조회 처리  
				eventResponse = searchBudEstDtlByMonCost(e);
			}
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}		
		//VOP_PSO_0201 Expense Plan Per VVD(Pop-Up) [E N D]<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		//VOP_PSO_0010 Estimate Expense Creation [START]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		if (e.getEventName().equalsIgnoreCase("VopPso0010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Retrieve Button Click 처리   
				eventResponse = searchEstTgtVvdByMon(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {//Expense Apply Button Click 처리 
				eventResponse = createEstTgtVvdByMon(e);
			}
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}		
		//VOP_PSO_0010 Estimate Expense Creation [E N D]<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		//VOP_PSO_0013 Interface to ERP [START]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		if (e.getEventName().equalsIgnoreCase("VopPso0013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Retrieve Button Click 처리
				boolean status = checkRunningBatch("VOP_PSO_B003");
				eventResponse = searchErpSum(e);
				eventResponse.setETCData("IS_RUNNING", status == true ? "true" : "false");
			//} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {//Detail Button Click 처리 
			//	eventResponse = createEstTgtVvdByMon(e);
			//} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {//Creation 
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {//Creation 
				eventResponse = createInterfaceToERP(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {//OPEN (check running batch)
				
				boolean status = checkRunningBatch("VOP_PSO_B003");
				eventResponse = new GeneralEventResponse();
				eventResponse.setETCData("IS_RUNNING", status == true ? "true" : "false");	
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){ // Down Excel
				eventResponse = searchErpDtl(e);
			} else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}		
		//VOP_PSO_0013 Interface to ERP [E N D]<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		//VOP_PSO_0207 Interface to ERP (Detail) [START]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		if (e.getEventName().equalsIgnoreCase("VopPso0207Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Open N' Retrieve Button Click 처리   
				eventResponse = searchErpDtl(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {//Save Button Click 처리 
				eventResponse = modifyErpDtl(e);
			}
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}		
		//VOP_PSO_0207 Interface to ERP (Detail) [E N D]<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		//VOP_PSO_0035 Budget Year [START]▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶>>
		if (e.getEventName().equalsIgnoreCase("VopPso0035Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Budget Audit Retrieve Button Click 처리   
				eventResponse = searchPortChgBudByYear(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {//Creation Button Click 처리 
				eventResponse = createBudget(e);
			}
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}		
		//VOP_PSO_0035 Budget Year [E N D]◀◀◀◀◀◀◀◀◀◀◀◀◀◀◀<<
		//VOP_PSO_0213 Expense Detail [START]===========================>>
		if (e.getEventName().equalsIgnoreCase("VopPso0213Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Open 처리 
				eventResponse = searchExpenseDetail(e);
			} 
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}		
		//VOP_PSO_0213 Expense Detail [E N D]===========================<<

		//Invoice Summary Detail
		if (e.getEventName().equalsIgnoreCase("VopPso0214Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Open 처리 
				eventResponse = searchInvSumDtl(e);
			} 
		}	
		
		//VOP_PSO_0100 Estimation Report  [START]===========================>>
		if (e.getEventName().equalsIgnoreCase("VopPso0100Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Open 처리 
			   
				eventResponse = searchMonthlyByVvd(e);
			} 
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}		
		//VOP_PSO_0100 Estimation Report [E N D]===========================<<
		
		//VOP_PSO_0101 Estimation Report  [START]===========================>>
		if (e.getEventName().equalsIgnoreCase("VopPso0101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Open 처리 
				eventResponse = searchMonEstmCompList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//raw data retrieve
				eventResponse = searchMonEstmRawDataList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {//raw data retrieve
				eventResponse = searchEstmRawDataListForBudget(e);
			}
		}
		
			
		//VOP_PSO_0101 Estimation Report [E N D]===========================<<
		
		//VOP_PSO_0102 Budget Summary Report  [START]===========================>>
		if (e.getEventName().equalsIgnoreCase("VopPso0102Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {//Tab1 Budget Summry by VVD
			   
				eventResponse = searchBudgetSmryByVvd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {  //Tab2 Budget Summry by Month
				eventResponse = searchBudgetSmryByMon(e);
			}
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}		
		//VOP_PSO_0102 Budget Summary Report[E N D]===========================<<
		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0213 : Open <br />
	 * 선택한 VVD 별 Expense Detail 정보를 표시한다. <br />
	 * @category VOP_PSO_0213_Open
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchExpenseDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0213Event event = (VopPso0213Event)e;
			BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
	
			List<ExpnDtlVO> list = command.searchExpenseDetail(event.getExpnDtlVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}

	/**
	 * VOP_PSO_0035 : Creation Button Click <br />
	 * 메인 리스트에서 선택한 VVD 별 Budget 정보를 재 생성한다. <br />
	 * @category VOP_PSO_0035_CreationButtonClick
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createBudget(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0035Event event = (VopPso0035Event)e;
		BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();//2-phase commit

		try{
			begin();
			command.createBudget(event.getPortChgBudByYearVOs(), account);//2Phase Commit처리 시 
			eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PSO90011", new String[]{}).getMessage(), ex);	//[2010.04.30] Save Exception Message
		}
		return eventResponse;
	}

	/**VOP_PSO_0035 : RetrieveButtonClick
	 * 년도별 사업 계획을 조회한다.
	 * @category VOP_PSO_0035_RetrieveButtonClick
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPortChgBudByYear(Event e) throws EventException {
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0035Event event = (VopPso0035Event)e;
			BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
	
			//«» searchPortChgBudByYear ( [in] portChgBudByYearVO : PortChgBudByYearVO ) : PortChgBudByYearVO []
			List<PortChgBudByYearVO> list = command.searchPortChgBudByYear(event.getPortChgBudByYearVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}

	/**
	 * VOP_PSO_0207 : Save <br>
	 * 월초에 전달의 추정실적비용을 ERP로 인터페이스하기 위해 추정비용을 변경한다. <br>
	 * @category VOP_PSO_0207_SaveButtonClick
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse modifyErpDtl(Event e) throws EventException {
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0207Event event = (VopPso0207Event)e;
		BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
		try{
			//«» modifyErpDtl ( [in] erpDtlVOs : ErpDtlVO [] ) : void
			begin();
			command.modifyErpDtl(event.getErpDtlVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PSO90011", new String[]{}).getMessage(), ex);	//[2010.04.30] Save Exception Message
		}
		return eventResponse;
	}

	/**
	 * VOP_PSO_0207 : Open,Retreive <br>
	 * 월초에 전달의 추정실적비용을 ERP로 인터페이스하기 위해 상세한 추정비용을 조회한다. <br>
	 * @category VOP_PSO_0207_OpenNRetrieveBtnClick
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchErpDtl(Event e) throws EventException {
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
			ErpDtlVO erpDtlVO = new ErpDtlVO();
			//«» searchErpDtl ( [in] erpDtlVO : ErpDtlVO ) : ErpDtlVO[]
			if(e instanceof VopPso0207Event){
				VopPso0207Event event = (VopPso0207Event)e;
				erpDtlVO = event.getErpDtlVO();
			}else if(e instanceof VopPso0013Event){
				VopPso0013Event event = (VopPso0013Event)e;
				erpDtlVO = event.getErpDtlVO();
//				erpDtlVO.setSdt(erpDtlVO.get)
			}
			List<ErpDtlVO> list = command.searchErpDtl(erpDtlVO);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}

	/**
	 * VOP_PSO_0013 : RetrieveButton <br>
	 * 월초에 전달의 추정실적비용을 ERP로 인터페이스하기 위해 추정비용을 조회한다.<br>
	 * @category VOP_PSO_0013_RetrieveButtonClick
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchErpSum(Event e) throws EventException {
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0013Event event = (VopPso0013Event)e;
			BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
			//«» searchErpSum ( [in] erpSumVO : ErpSumVO ) : ErpSumVO []
			List<ErpSumVO> list = command.searchErpSum(event.getErpSumVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}

	/**
	 * VOP_PSO_0010 : ExpenseApplyButtonClick <br>
	 * 재무 월간 수입 대상 항차 기준으로 해당월의 항비 대상 항차를 생성한다. <br>
	 * @category VOP_PSO_0010_ExpenseApplyButtonClick
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createEstTgtVvdByMon(Event e) throws EventException {
		// TODO ERP연동처리 필요 Flow가 없음.
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0010Event event = (VopPso0010Event)e;
		BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();//2-phase commit
		try{
			begin();
			//«» createEstTgtVvdByMon ( [in] estExpnCreVOs : EstExpnCreVO [] ) : void
			command.createEstTgtVvdByMon(event.getEstExpnCreVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PSO90011", new String[]{}).getMessage(), ex);	//[2010.04.30] Save Exception Message
		}
		return eventResponse;
	}

	/**VOP_PSO_0010 : RetrieveButtonClick
	 * Estimate VVD Creation하기 위해 기 생성한 추정 대상월 및 노선별로 조회한다.
	 * @category VOP_PSO_0010_RetrieveButtonClick
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchEstTgtVvdByMon(Event e) throws EventException {
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0010Event event = (VopPso0010Event)e;
			BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
			//«» searchEstTgtVvdByMon ( [in] estTgtVvdByMonVO : EstTgtVvdByMonVO ) : EstTgtVvdByMonVO []
			List<EstExpnCreVO> list = command.searchEstTgtVvdByMon(event.getEstExpnCreVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}

	/**
	 * VOP_PSO_0201 : Open
	 * Expense Plan Per VVD(Pop-Up) 조회 처리 
	 * @category VOP_PSO_0201_windowOpen
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBudEstDtlByMonCost(Event e) throws EventException {
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0201Event event = (VopPso0201Event)e;
			BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
			//«» searchBudEstDtlByMonCost ( [in] yyyymm : String , [in] vVDCd : String ) : BudEstSumByMonVO []
			List<BudEstSumByMonVO> list = command.searchBudEstDtlByMonCost(event.getBudEstDtlCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}

	/**
	 * VOP_PSO_0009 : estimateCreationButtonClick
	 * Estimate Creation화면의 Creation Button 클릭 시 처리
	 * @category VOP_PSO_0009_estimateCreationButtonClick
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createEstExpnByMon(Event e) throws EventException {
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0009Event event = (VopPso0009Event) e; 
		

		BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
		
		try{
			begin();
			String strStatus = command.createEstExpnByMon(event.getRevYrmon(),event.getVslSlanCd(), account.getUsr_id());	//"[In] yyyymm : String , [in] laneCd : String
			//[Return] void"
	
			//Batch모듈을 직접 실행한다. 
			eventResponse.setETCData("BatchStatus", strStatus);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PSO90011", new String[]{}).getMessage(), ex);	//[2010.04.30] Save Exception Message
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0008 : Creation <br>
	 * 년도별 사업 계획을 생성한다. <br>
	 * @category VOP_PSO_0008_creationButtonClick
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createPortChgBudByYear(Event e) throws EventException {
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0008Event event = (VopPso0008Event) e; 
		BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
		String scrNo = event.getScnDt() + event.getScnCd();
		
		try{
			begin();

			String strStatus = command.generateYearBudgetPlan(event.getStartDt(), event.getEndDt(), scrNo, account.getUsr_id());
				
			//Batch모듈을 직접 실행한다. 
			eventResponse.setETCData("BatchStatus", strStatus);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PSO90011", new String[]{}).getMessage(), ex);	//[2010.04.30] Save Exception Message
		}	
		return eventResponse;
	}

	/**VOP_PSO_0006 : Retrieve
	 * PSO_PORT_EXPN_DIV 테이블 기준으로 등록된 Service Lane List를 표시한다.<br>
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLaneExpenseRatioKeyValue(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			LaneExpenseRatioMgtBC command = new LaneExpenseRatioMgtBCImpl();

			List<SvcLaneVO> list = command.searchLaneExpenseRatioKeyValue();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}

	
	/**VOP_PSO_0006 : Sheet Double Click
	 * PSO_PORT_EXPN_DIV 테이블 기준으로 등록된 Service Lane List를 표시한다.<br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLaneExpnRto(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0006Event event = (VopPso0006Event)e;
		LaneExpenseRatioMgtBC command = new LaneExpenseRatioMgtBCImpl();

		try{
			List<ServiceLaneListVO> list = command.searchPsoPortExpenseDivision(event.getVsl_slan_cd());
			if( list.size() == 0 )
				list = command.searchPfSkdDetail(event.getVsl_slan_cd());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**VOP_PSO_0006 : Sheet OnChange
	 * PSO_PORT_EXPN_DIV 테이블 기준으로 등록된 Service Lane List를 표시한다.<br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPfLaneTypeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopPso0006Event event = (VopPso0006Event)e;
		LaneExpenseRatioMgtBC command = new LaneExpenseRatioMgtBCImpl();
	    GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<SvcLaneVO> list = command.searchPfLaneTypeList(event.getVsl_slan_cd());
			
			  StringBuffer data = new StringBuffer();
			  
			  if(list != null && list.size() > 0){
				  for (int i = 0; i < list.size(); i++) {
				    data.append(list.get(i).getPfSvcTpCd());
				  }
			  }

			  eventResponse.setETCData("PfSvcTpCd", data.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	
	/**
	 * VOP_PSO_0006 : Save<br>
	 * Lane/Port Expense Ratio Creation 저장
	 * @param e
	 * @return EventResponse
	 * @throws EventException 
	 */
	private EventResponse manageLaneExpnRto(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0006Event event = (VopPso0006Event)e;
		LaneExpenseRatioMgtBC command = new LaneExpenseRatioMgtBCImpl();
		try{
			begin();
			command.manageLaneExpnRto(event.getSvcLaneVO() ,event.getServiceLaneListVO() , account);
			eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PSO90011", new String[]{}).getMessage(), ex);	//[2010.04.30] Save Exception Message
		}
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0026 : Retrieve <br>
	 * Budget vs Actual조회
	 * @param e
	 * @return EventResponse
	 * @throws EventException 
	 */
	private EventResponse searchSumRptByPeriodInv(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0026Event event = (VopPso0026Event)e;
			BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
			List<InvSumByMonVO> list = command.searchSumRptByPeriodInv(event.getInvSumByMonVO());
			
            SortedMap<Integer, String> capaMap = new TreeMap<Integer, String>();
            String vslClass = "";
            for(InvSumByMonVO invSumByMonVO : list){
                   vslClass = invSumByMonVO.getVslClss();
                   if(vslClass!=null && vslClass.length()!=0){
                	   capaMap.put(new Integer(vslClass), vslClass);
                   }
            }
            StringBuffer sb = new StringBuffer();
            for(String val : capaMap.values()){
                   sb.append("|").append(val);
            }
            eventResponse.setETCData("VSL_CLASS", sb.toString());

			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * VOP_PSO_0025 : Retrieve<br/>
	 * Budget vs Actual조회<br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException 
	 */
	private EventResponse searchSumRptByPeriodSo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0025Event event = (VopPso0025Event)e;
			BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
			List<EstTgtVvdByMonVO> list = command.searchSumRptByPeriodSo(event.getEstTgtVvdByMonVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	
	/**VOP_PSO_0025 : OPEN
	 * mdm_vsl_cntr 테이블 기준으로 등록된 vsl class를 표시한다.<br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAccoutVslClassList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PSOCodeFinderBC command = new PSOCodeFinderBCImpl();
	    GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<MdmVslCntrVO> list = command.searchVesselClassList();
			StringBuffer data = new StringBuffer();

			if(list != null && list.size() > 0){
				for (int i = 0; i < list.size(); i++) {
					data.append(list.get(i).getCntrVslClssCapa()); 
					data.append(",");
					data.append(list.get(i).getCntrVslClssCapa());
					if (i < list.size() - 1)
						data.append("|");
				}
			}

			eventResponse.setETCData("vsl", data.toString());

			List<CostListVO> list2 = command.searchAccountList();
			data = new StringBuffer();

			if(list2 != null && list2.size() > 0){
				for (int i = 0; i < list2.size(); i++) {
					data.append(list2.get(i).getAcctCd());
					data.append(",");
					data.append(list2.get(i).getAcctEngNm());
					if (i < list2.size() - 1)
						data.append("|");
				}
			}
			
			eventResponse.setETCData("account", data.toString());
			  
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**VOP_PSO_0006 : Sheet OnKeyUp
	 * mdm_vsl_cntr 테이블 기준으로 등록된 vsl class를 표시한다.<br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkRevLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopPso0006Event event = (VopPso0006Event)e;
		PSOCodeFinderBC command = new PSOCodeFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			String isLane = command.checkRevLane(event.getVsl_slan_cd());
			
			eventResponse.setETCData("isLane", isLane);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**VOP_PSO_0214 : OPEN
	 * Invoice Summary Detail을 조회한다.<br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchInvSumDtl(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopPso0214Event event = (VopPso0214Event)e;
		BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<InvSumDtlVO> list = command.searchInvSumDtl(event.getInvSumDtlVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0013 : Creation<br>
	 * Interface To ERP (Delete, Insert)<br>
	 * @category VOP_PSO_0013_Creation
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 */
	/*
	 * CHM-201006714-01 추정결산 로직 보완
	 */
	private EventResponse createInterfaceToERP(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
		try{
			begin();
				
			VopPso0013Event event = (VopPso0013Event)e;
			ErpSumVO erpSumVO = event.getErpSumVO();

			erpSumVO.setCreUsrId(account.getUsr_id());
			
			String strStatus = command.createInterfaceToERP(erpSumVO);
			eventResponse.setETCData("BatchStatus", strStatus);
			
			//eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
				
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PSO90001", new String[]{}).getMessage(), ex);	//$s 시스템 에러가 발생하였습니다
		}
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0008 : Retrieve<br>
	 * Budget Creation를 조회합니다.<br>
	 * @category VOP_PSO_0008
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBudCreByMon(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0008Event event = (VopPso0008Event)e;
			BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();

			String startDt = event.getStartDt().replaceAll("-", "");
			String endDt = event.getEndDt().replaceAll("-", "");
			String scrNo = event.getScnDt() + event.getScnCd();
			
			List<BudCreVO> listMonth	= command.searchBudCreByMon(startDt, endDt, scrNo);
			List<BudCreVO> listCurrency = command.searchBudCreByCurrency(startDt, endDt, scrNo);
			eventResponse.setRsVoList(listMonth);
			eventResponse.setRsVoList(listCurrency);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0009 : Retrieve<br>
	 * Estimate Creation를 조회합니다.<br>
	 * @category VOP_PSO_0009
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEstCreByMon(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0009Event event = (VopPso0009Event)e;
			BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();

			String revYrmon = event.getRevYrmon().replaceAll("-", "");
			String vslSlanCd = event.getVslSlanCd();

			List<EstCreVO> list = command.searchEstCreByMon(revYrmon, vslSlanCd);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0009 : Retrieve
	 * Batch 모듈이 실행 중인지 확인한다. 
	 * @category VOP_PSO_0009	(jmh)
	 * @param String batchID
	 * @return boolean
	 * @throws EventException
	 */
	private boolean checkRunningBatch(String batchID) throws EventException {
		boolean status = false;
		try{
			BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
			status = command.checkRunningBatch(batchID);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return status;
	}
	
	/**
	 * VOP_PSO_0026 : Open
	 * @category VOP_PSO_0026	
	 * @param Event e 
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBasicList(Event e) throws EventException{
		
		PSOCodeFinderBC command = new PSOCodeFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<MdmVslCntrVO> list = command.searchVesselClassList();
			StringBuffer data = new StringBuffer();

			if(list != null && list.size() > 0){
				for (int i = 0; i < list.size(); i++) {
					data.append(list.get(i).getCntrVslClssCapa()); 
					data.append(",");
					data.append(list.get(i).getCntrVslClssCapa());
					if (i < list.size() - 1)
						data.append("|");
				}
			}

			eventResponse.setETCData("vsl", data.toString());

			List<CostListVO> list2 = command.searchAccountList();
			data = new StringBuffer();

			if(list2 != null && list2.size() > 0){
				for (int i = 0; i < list2.size(); i++) {
					data.append(list2.get(i).getAcctCd());
					data.append(",");
					data.append(list2.get(i).getAcctEngNm());
					if (i < list2.size() - 1)
						data.append("|");
				}
			}
				
			eventResponse.setETCData("account", data.toString());
			  
						
			VSKCodeFinderBC command1 = new VSKCodeFinderBCImpl();
			List<OfficeVO> list3 = command1.searchRhqList();
			data = new StringBuffer();
			
			if(list3 != null && list3.size() > 0){
				data.append(list3.get(0).getPrntOfcCd());
				for(int i=1; i<list3.size(); i++){
					data.append("|"+list3.get(i).getPrntOfcCd());
				}
			}
			eventResponse.setETCData("rhq_list", data.toString());
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	
	/**
	 * VOP_PSO_0101 : Retrieve
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMonEstmCompList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0101Event event = (VopPso0101Event)e;
			EstimationReportBC command = new EstimationReportBCImpl();
			//당월 추정치
			List<MonEstmCompVO> list1 = command.searchMonEstmCompList(event.getRevYrmon(),"",event.getScnCd()); 
			//전년,전월 추정치 or 사업계획 추정치
			List<MonEstmCompVO> list2 = command.searchMonEstmCompList(event.getRevYrmon(),event.getChkRdo(),event.getScnCd());
			//추정치 간의 차이
			List<MonEstmCompVO> list3 = command.searchMonEstmCompDiffList(event.getRevYrmon(),event.getChkRdo(),event.getScnCd());

			

			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
			eventResponse.setRsVoList(list3);
		
	 
				         
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0101 : Raw data Retrieve
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMonEstmRawDataList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0101Event event = (VopPso0101Event)e;
			EstimationReportBC command = new EstimationReportBCImpl();
			//1. Raw data : 추정결산 VVD별 집계 
			List<MonEstmRawDataVO> list1 = command.searchMonEstmRawDataListByVvd(event.getRevYrmon(),event.getRawFlg());
			//2. Raw data : 추정결산 YD별 집계 
			List<MonEstmRawDataVO> list2 = command.searchMonEstmRawDataListByYd(event.getRevYrmon(),event.getRawFlg());
			//3. Raw data : 추정결산 ACCT별 집계 
			List<MonEstmRawDataVO> list3 = command.searchMonEstmRawDataListByAcct(event.getRevYrmon(),event.getRawFlg());
			
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
			eventResponse.setRsVoList(list3);


		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * VOP_PSO_0100 : Open
	 * VOP_PSO_0100 : Retreive
	 * @category VOP_PSO_0100_windowOpen
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMonthlyByVvd(Event e) throws EventException {
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0100Event event = (VopPso0100Event)e;
			EstimationReportBC command = new EstimationReportBCImpl();
			List<EstimationByVvdVO> list = command.searchMonthlyByVvd(event.getEstimationByVvdVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
//	/**
//	 * VOP_PSO_0013 : Down Excel Button <br>
//	 * Raw Data를 조회한다.<br>
//	 * @category VOP_PSO_0013_Down ExcelButtonClick
//	 * @param e Event
//	 * @return EventResponse
//	 * @throws EventException
//	 */
//	private EventResponse searchErpDetail(Event e) throws EventException {
//		// TODO Auto-generated method stub
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		try{
//			VopPso0013Event event = (VopPso0013Event)e;
//			BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
//			//«» searchErpSum ( [in] erpSumVO : ErpSumVO ) : ErpSumVO []
//			List<ErpSumVO> list = command.searchErpDetail(event.getErpSumVO());
//			eventResponse.setRsVoList(list);
//		}catch(EventException ex){
//			throw ex;
//		} catch(Exception ex) {
//			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
//		}
//		return eventResponse;
//	}
	/**
	 * VOP_PSO_0101 : Raw data for budget Retrieve
	 * @param Event e e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchEstmRawDataListForBudget(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0101Event event = (VopPso0101Event)e;
			EstimationReportBC command = new EstimationReportBCImpl();
	
//			String budStr = "";
//			String budYrmon = event.getRevYrmon().substring(5,7);
//			if(Integer.parseInt(budYrmon)<7){
//				budStr = "BP";
//			}else if(Integer.parseInt(budYrmon)<10){
//				budStr = "BP";
//			}else {
//				budStr = "Q4";
//			}
			//1. Raw data for budget : 추정결산 VBP별 집계
			List<MonEstmRawDataForBudVO> list1 = command.searchRawDataByVBPForBudget(event.getRevYrmon(),event.getScnCd());
			//2. Raw data for budget : 추정결산 VVD별 집계
			List<MonEstmRawDataForBudVO> list2 = command.searchRawDataByVvdForBudget(event.getRevYrmon(),event.getScnCd());
			//3. Raw data for budget : 추정결산 YD별 집계
			List<MonEstmRawDataForBudVO> list3 = command.searchRawDataByYdForBudget(event.getRevYrmon(),event.getScnCd());
			//4. Raw data for budget : 추정결산 ACCT별 집계
			List<MonEstmRawDataForBudVO> list4 = command.searchRawDataByAcctForBudget(event.getRevYrmon(),event.getScnCd());
			
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
			eventResponse.setRsVoList(list3);
			eventResponse.setRsVoList(list4);


		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * VOP_PSO_0102 : Open
	 * VOP_PSO_0102 : tab1 Retreive
	 * @category VOP_PSO_0102_windowOpen
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBudgetSmryByVvd(Event e) throws EventException {
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0102Event event = (VopPso0102Event)e;
			EstimationReportBC command = new EstimationReportBCImpl();
					
		   List<BudgetSmryByVvdVO> list =  command.searchBudgetSmryByVvd(event.getBudgetSmryByVvdVO());
			eventResponse.setRsVoList(list);
			
		  
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0102 : Open
	 * VOP_PSO_0102 :  tab2  Retreive
	 * @category VOP_PSO_0102_windowOpen
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBudgetSmryByMon(Event e) throws EventException {
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0102Event event = (VopPso0102Event)e;
			EstimationReportBC command = new EstimationReportBCImpl();
					
		   List<BudgetSmryByVvdVO> list =  command.searchBudgetSmryByMon(event.getBudgetSmryByVvdVO());
			eventResponse.setRsVoList(list);
			
		  
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	

}