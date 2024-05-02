/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortChargeBudgetSC.java
*@FileTitle : Bank Information 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.04.30 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget;

import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.basic.BudgetPortChargeMgtBC;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.basic.BudgetPortChargeMgtBCImpl;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0008Event;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0009Event;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0010Event;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0013Event;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0025Event;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0026Event;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0035Event;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0201Event;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0207Event;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0213Event;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0214Event;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.BudCreVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.BudEstSumByMonVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.ContinentVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.CtrlOfficeVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.ErpDtlVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.ErpSumVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.EstCreVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.EstExpnCreVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.EstTgtVvdByMonVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.ExpnDtlVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.InvSumByMonVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.InvSumDtlVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.PortChgBudByYearVO;
import com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.basic.LaneExpenseRatioMgtBC;
import com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.basic.LaneExpenseRatioMgtBCImpl;
import com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.event.VopPso0006Event;
import com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.integration.LaneExpenseRatioMgtDBDAO;
import com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.vo.ServiceLaneListVO;
import com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.vo.SvcLaneVO;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.basic.PSOCodeFinderBC;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.basic.PSOCodeFinderBCImpl;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.vo.CostListVO;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.vo.MdmVslCntrVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBC;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.OfficeVO;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * Handling business transaction about ALPS-PortChargeBudget Business Logic ServiceCommand - ALPS-PortChargeBudget 
 * 
 * @author 
 * @see LaneExpenseRatioMgtDBDAO
 * @since J2EE 1.6
 */

public class PortChargeBudgetSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * PortChargeBudget system preceding process for biz scenario<br>
	 * VSO_PSO_0006 related objects creation<br>
	 */
	public void doStart() {
		log.debug("PortChargeBudgetSC 시작");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * PortChargeBudget system biz scenario closing <br>
	 * clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("PortChargeBudgetSC 종료");
	}

	/**
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// Part of using in case SC handles many events
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
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkRevenueDirection(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRevenueDirectionByRevLane(e);
			}
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}
		if (e.getEventName().equalsIgnoreCase("VopPso0025Event")) {
			//Get BankInformation of VendorSeq chosen in case of PageLoad
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
			//Get BankInformation of VendorSeq chosen in case of PageLoad
			if (e.getFormCommand().isCommand(FormCommand.SEARCH )) {
				eventResponse = searchSumRptByPeriodInv(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchAccoutVslClassList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBasicList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchControlOfficeList(e);
			}
			/* 1. Retrieve BackEndJob*/
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSumRptByPeriodInvBackEndJob(e);
			}
			/* 2. retrieving BackEndJob status */
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchComBackEndJobStatus(e);
			}
			/* 3. retrieving BackEndJob result */
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				try{
					eventResponse = searchComBackEndJobResult(e);
				}catch(BackEndJobException ex){
					throw new EventException(ex.getMessage());
				}
			}
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}		
		//VOP_PSO_0008 Budget Creation [START]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		if (e.getEventName().equalsIgnoreCase("VopPso0008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.ADD)) {//Handling Creation Button Click  
				
				eventResponse = createPortChgBudByYear(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Retrieve
				
				boolean status = this.checkRunningBatch("VOP_PSO_B002", false);
				eventResponse = searchBudCreByMon(e);
				eventResponse.setETCData("IS_RUNNING", status == true ? "true" : "false");	
				
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {//OPEN (check running batch) 
				
				boolean status = this.checkRunningBatch("VOP_PSO_B002", false);
				eventResponse = new GeneralEventResponse();
				eventResponse.setETCData("IS_RUNNING", status == true ? "true" : "false");	
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {//Handling Rev VVD Upload 
				eventResponse = createBudgetRevVVDByUpload(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {//excel upload 
				eventResponse = manageBudCre(e);
			}
		}		
		//VOP_PSO_0008 Budget Creation [E N D]<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		//VOP_PSO_0009 Estimate Creation [START]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		if (e.getEventName().equalsIgnoreCase("VopPso0009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.ADD)) {//Handling Creation Button Click 
				
				eventResponse = createEstExpnByMon(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Retrieve
				
				boolean status = this.checkRunningBatch("VOP_PSO_B003", false);
				eventResponse = searchEstCreByMon(e);
				eventResponse.setETCData("IS_RUNNING", status == true ? "true" : "false");
				
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {//OPEN (check running batch)
				
				boolean status = this.checkRunningBatch("VOP_PSO_B003", false);
				eventResponse = new GeneralEventResponse();
				eventResponse.setETCData("IS_RUNNING", status == true ? "true" : "false");	
			}
		}		
		//VOP_PSO_0009 Estimate Creation [E N D]<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		//VOP_PSO_0201 Expense Plan Per VVD(Pop-Up) [START]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		if (e.getEventName().equalsIgnoreCase("VopPso0201Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Handling retrieve in case of PopUp 
				eventResponse = searchBudEstDtlByMonCost(e);
			}
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}		
		//VOP_PSO_0201 Expense Plan Per VVD(Pop-Up) [E N D]<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		//VOP_PSO_0010 Estimate Expense Creation [START]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		if (e.getEventName().equalsIgnoreCase("VopPso0010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Handling Retrieve Button Click 
				eventResponse = searchEstTgtVvdByMon(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {//Handling Expense Apply Button Click 				
				eventResponse = createEstTgtVvdByMon(e);
			}
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}		
		//VOP_PSO_0010 Estimate Expense Creation [E N D]<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		//VOP_PSO_0013 Monthly Estimation Creation [START]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		if (e.getEventName().equalsIgnoreCase("VopPso0013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Handling Retrieve Button Click 
				boolean status = this.checkRunningBatch("VOP_PSO_B003", false);//true-local, false-autosys
				eventResponse = searchErpSum(e);
				eventResponse.setETCData("IS_RUNNING", status == true ? "true" : "false");
			//} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {//Handling Detail Button Click 
			//	eventResponse = createEstTgtVvdByMon(e);
			//} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {//Creation 
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {//Creation 
				eventResponse = createInterfaceToERP(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {//OPEN (check running batch)
				
				boolean status = this.checkRunningBatch("VOP_PSO_B003", false);
				eventResponse = new GeneralEventResponse();
				eventResponse.setETCData("IS_RUNNING", status == true ? "true" : "false");	
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {//detail down excel
				
				boolean status = this.checkRunningBatch("VOP_PSO_B003", false); //true-local, false-autosys
				eventResponse = searchErpDtlExcelData(e);
				eventResponse.setETCData("IS_RUNNING", status == true ? "true" : "false");	
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { /* 1. Retrieve BackEndJob*/
				eventResponse = searchErpDtlExcelDataBackEndJob(e); //Batch 가 도는지 확인 후에 Down 한다.
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {/* 2. retrieving BackEndJob status */
				eventResponse = searchComBackEndJobStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {/* 3. retrieving BackEndJob result */
				try{
					eventResponse = searchComBackEndJobResult(e);
				}catch(BackEndJobException ex){
					throw new EventException(ex.getMessage());
				}
			}else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}		
		//VOP_PSO_0013 Monthly Estimation Creation [E N D]<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		//VOP_PSO_0207 Monthly Estimation Creation (Detail) [START]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		if (e.getEventName().equalsIgnoreCase("VopPso0207Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Handling Open N' Retrieve Button Click 
				eventResponse = searchErpDtl(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {//Handling Save Button Click 
				eventResponse = modifyErpDtl(e);
			}/* 5. Open */
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openVopPso0207(e);
			}
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}		
		//VOP_PSO_0207 Monthly Estimation Creation (Detail) [E N D]<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		//VOP_PSO_0035 Budget Year [START]▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶>>
		if (e.getEventName().equalsIgnoreCase("VopPso0035Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Handling Budget Audit Retrieve Button Click  
				eventResponse = searchPortChgBudByYear(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {//Handling Creation Button Click  
				eventResponse = createBudget(e);
			}
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}		
		//VOP_PSO_0035 Budget Year [E N D]◀◀◀◀◀◀◀◀◀◀◀◀◀◀◀<<
		//VOP_PSO_0213 Expense Detail [START]===========================>>
		if (e.getEventName().equalsIgnoreCase("VopPso0213Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Handling Open 
				eventResponse = searchExpenseDetail(e);
			} 
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}		
		//VOP_PSO_0213 Expense Detail [E N D]===========================<<

		//Invoice Summary Detail
		if (e.getEventName().equalsIgnoreCase("VopPso0214Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Handling Open  
				eventResponse = searchInvSumDtl(e);
			} 
		}	
		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0213 : Open <br />
	 * Show Expense Detail Info by VVD chosen <br />
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
	 * Recreate Budget Info by VVD Chosen in main list <br />
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
			command.createBudget(event.getPortChgBudByYearVOs(), account);//2Phase in case of handling Commit 
			eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PSO90011", new String[]{}).getMessage(), ex);	//Save Exception Message
		}
		return eventResponse;
	}

	/**VOP_PSO_0035 : RetrieveButtonClick
	 * Retrieve business plan by year
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
	
			//≪≫ searchPortChgBudByYear ( [in] portChgBudByYearVO : PortChgBudByYearVO ) : PortChgBudByYearVO []
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
     * VOP_PSO_0207 : Open
     * retrieving Trade, Carrier, Lane Code Combo
     * @param Event e
     * @return EventResponse
     * @throws Exception
     */
	@SuppressWarnings({ "rawtypes" })
	private EventResponse openVopPso0207(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0207Event event = (VopPso0207Event)e;
		BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
		
		List<ContinentVO> list = command.searchContinentByErp(event.getErpDtlVO());
		
		StringBuilder sb = new StringBuilder();
		Iterator iterator = (Iterator) list.iterator();
		int iCnt = 0;
		while(iterator.hasNext()){
			ContinentVO vo = (ContinentVO)iterator.next();
			if(iCnt == 0){
				sb.append(vo.getContiCd()+","+vo.getContiNm());
			}else{
				sb.append("|"+vo.getContiCd()+","+vo.getContiNm());
			}
			iCnt++;
		}
		
		List<CostListVO> accCdList = command.searchAccountCodeByErp(event.getErpDtlVO());
		
		StringBuilder accSb = new StringBuilder();
		Iterator accIt = (Iterator) accCdList.iterator();
		iCnt = 0;
		while(accIt.hasNext()){
			CostListVO vo = (CostListVO)accIt.next();
			if(iCnt == 0){
				accSb.append(vo.getAcctCd()+","+vo.getAcctEngNm());
			}else{
				accSb.append("|"+vo.getAcctCd()+","+vo.getAcctEngNm());
			}
			iCnt++;
		}
		
		eventResponse.setETCData("conti_cd"  , sb.toString());
		eventResponse.setETCData("acct_cd"  , accSb.toString());
		return eventResponse;
	}

	/**
	 * VOP_PSO_0207 : Save <br>
	 * Change estimated cost to interface ERP estimated performance cost of previous month at the beginning of the month <br>
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
			//≪≫ modifyErpDtl ( [in] erpDtlVOs : ErpDtlVO [] ) : void
			begin();
			command.modifyErpDtl(event.getErpDtlVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PSO90011", new String[]{}).getMessage(), ex);	// Save Exception Message
		}
		return eventResponse;
	}

	/**
	 * VOP_PSO_0207 : Open,Retreive <br>
	 * Retrieve a detailed estimated cost to interface ERP estimated performance cost of previous month at the beginning of the month<br>
	 * @category VOP_PSO_0207_OpenNRetrieveBtnClick
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchErpDtl(Event e) throws EventException {
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0207Event event = (VopPso0207Event)e;
			BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
			//≪≫ searchErpDtl ( [in] erpDtlVO : ErpDtlVO ) : ErpDtlVO[]
			List<ErpDtlVO> list = command.searchErpDtl(event.getErpDtlVO());
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
	 * Retrieve estimated cost to interface ERP estimated performance cost of previous month at the beginning of the month<br>
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
			//≪≫ searchErpSum ( [in] erpSumVO : ErpSumVO ) : ErpSumVO []
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
	 * VOP_PSO_0013 : Detail Excel Retreive <br>
	 * @category VOP_PSO_0013_OpenNRetrieveBtnClick
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchErpDtlExcelData(Event e) throws EventException {
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0013Event event = (VopPso0013Event)e;
			BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
			
			List<ErpDtlVO> list = command.searchErpDtlExcelData(event.getErpSumVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	

	
	/**
	 * VOP_PSO_0013
     * Detail Excel Retreive BackEndJob
     * 2016.12.19 Add
	 * 
	 * @category VOP_PSO_0013_DetailExcelBackEndJobRetrieveBtnClick
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchErpDtlExcelDataBackEndJob(Event e) throws EventException {
		BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0013Event event = (VopPso0013Event) e;
		try {
			//begin();
			boolean status = this.checkRunningBatch("VOP_PSO_B003", false);//true-local, false-autosys
			if(!status){
				ErpSumVO erpSumVo = event.getErpSumVO();
				String key = command.searchErpDtlExcelDataBackEndJob(erpSumVo, account);
				eventResponse.setETCData("key", key);
				eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
			}			
			eventResponse.setETCData("IS_RUNNING", status == true ? "true" : "false");
			
			//commit();
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VOP_PSO_0010 : ExpenseApplyButtonClick <br>
	 * Create VVD which is object of port expense of this month by VVD standard which is object of monthly income  <br>
	 * @category VOP_PSO_0010_ExpenseApplyButtonClick
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createEstTgtVvdByMon(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0010Event event = (VopPso0010Event)e;
		BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();//2-phase commit
		try{
			//begin();
			//2016.10.19 Add
			boolean status = this.checkRunningBatch("VOP_PSO_B003", false);
			
			if(!status){
				command.createEstTgtVvdByMon(event.getEstExpnCreVOs(), account);
				eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
			}
			
			eventResponse.setETCData("IS_RUNNING", status == true ? "true" : "false");
			
			//commit();
		}catch(EventException ex){
			//rollback();
			throw ex;
		} catch(Exception ex) {
			//rollback();
			throw new EventException(new ErrorHandler("PSO90011", new String[]{}).getMessage(), ex);	//[2010.04.30] Save Exception Message
		}
		return eventResponse;
	}

	/**VOP_PSO_0010 : RetrieveButtonClick
	 * Retrieve by lane and month which is object of estimated which is already created for Estimate VVD Creation
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
			List<EstExpnCreVO> list = command.searchEstTgtVvdByMon(event.getEstExpnCreVO());
			eventResponse.setRsVoList(list);
			
			//2016.10.19 Add
			boolean status = this.checkRunningBatch("VOP_PSO_B003", false);
			eventResponse.setETCData("IS_RUNNING", status == true ? "true" : "false");
			
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}

	/**
	 * VOP_PSO_0201 : Open
	 * Handling retrieve Expense Plan Per VVD(Pop-Up) 
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
			//≪≫ searchBudEstDtlByMonCost ( [in] yyyymm : String , [in] vVDCd : String ) : BudEstSumByMonVO []
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
	 * Handle in case of clicking Creation Button in Estimate Creation page 
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
	
			//Putting in action Batch Module directly
			eventResponse.setETCData("BatchStatus", strStatus);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PSO90011", new String[]{}).getMessage(), ex);	// Save Exception Message
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0008 : Creation <br>
	 * Create business plan by year <br>
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
		try{
			begin();
			String strStatus = command.generateYearBudgetPlan(event.getStartDt(), event.getEndDt(), account.getUsr_id());
				
			//Putting in action Batch Module directly
			eventResponse.setETCData("BatchStatus", strStatus);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PSO90011", new String[]{}).getMessage(), ex);	// Save Exception Message
		}	
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0008 : Budget Upload <br>
	 * Update target VVD business plan by year <br>
	 * @category VOP_PSO_0008_creationButtonClick
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createBudgetRevVVDByUpload(Event e) throws EventException {
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		VopPso0008Event event = (VopPso0008Event) e; 
//		
//		BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
//		try{
//			begin();
//			String strStatus = command.generateYearBudgetPlan(event.getStartDt(), event.getEndDt(), account.getUsr_id());
//				
//			//Putting in action Batch Module directly 
//			eventResponse.setETCData("BatchStatus", strStatus);
//			commit();
//		}catch(EventException ex){
//			rollback();
//			throw ex;
//		} catch(Exception ex) {
//			rollback();
//			throw new EventException(new ErrorHandler("PSO90011", new String[]{}).getMessage(), ex);	// Save Exception Message
//		}	
		return eventResponse;
	}

	/**VOP_PSO_0006 : Retrieve
	 * Show Service Lane List registered by PSO_PORT_EXPN_DIV table standard<br>
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
	 * Show Service Lane List registered by PSO_PORT_EXPN_DIV table standard<br>
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
	 * Show Service Lane List registered by PSO_PORT_EXPN_DIV table standard<br>
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
	 * Save Lane/Port Expense Ratio Creation 
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
			command.manageLaneExpnRto(event.getSvcLaneVO() ,event.getServiceLaneListVOS() , account);
			
			eventResponse.setETCData("vsl_slan_cd", event.getVsl_slan_cd());
			
			eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PSO90011", new String[]{}).getMessage(), ex);	//Save Exception Message
		}
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0026 : Retrieve <br>
	 * Retrieve Budget vs Actual
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
	 * VOP_PSO_0026
     * Retrieve Invoice Summary BackEndJob
     * 2016.05.19 Add
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSumRptByPeriodInvBackEndJob(Event e) throws EventException {
		BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0026Event event = (VopPso0026Event) e;
		try {
			//begin();
			InvSumByMonVO invSumByMonVO = event.getInvSumByMonVO();
			String key = command.searchSumRptByPeriodInvBackEndJob(invSumByMonVO, account);
			eventResponse.setETCData("key", key);
			//commit();
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
    /**
     * VOP_PSO_0026
     * Retrieve Common BackEndJob Status
     * 2016.05.19 Add
     * 
     * @param Event e
     * @return EventResponse
     * @throws BackEndJobException
     */
	private EventResponse searchComBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
		String key = (String)e.getAttribute("key");
		String status = null;
		try {
			status = command.searchComBackEndJobStatus(key);			
			eventResponse.setETCData("jb_sts_flg", status);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}		
		return eventResponse;
	}


	/**
     * VOP_PSO_0026
     * Retrieve Common BackEndJob Result
     * 2016.05.19 Add
     * 
     * @param Event e
     * @return EventResponse
	 * @throws BackEndJobException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchComBackEndJobResult(Event e) throws EventException, BackEndJobException {
		String key = (String)e.getAttribute("key");		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if(e.getEventName().equalsIgnoreCase("VopPso0026Event")) {
				List<InvSumByMonVO> list = null;
				list = (List<InvSumByMonVO>)BackEndJobResult.loadFromFile(key);
				
				if( list != null ) {
					eventResponse.setRsVoList(list);
				}
			}else if(e.getEventName().equalsIgnoreCase("VopPso0013Event")){
				List<ErpDtlVO> list = null;
				list = (List<ErpDtlVO>)BackEndJobResult.loadFromFile(key);
				
				//프레임워크 공통(com.clt.framework.core.controller.DownloadViewAdapter)을 사용 하였으나, 다운로드시 경고 문구가 나오는 문제로 adapter를 만들어 사용함(http://support.microsoft.com/kb/948615/ko)
				if( list != null ) {
					eventResponse.setRsVoList(list);
				}
			}
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * VOP_PSO_0026 : Retrieve<br/>
	 * Retrieve Budget vs Actual<br>
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
	 * Show vsl class registered by mdm_vsl_cntr table standard<br>
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

			//2015.10.05 Modify ofcCd
			//List<CostListVO> list2 = command.searchAccountList();
			List<CostListVO> list2 = command.searchAccountList(account.getOfc_cd());
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
	 * Show vsl class registered by mdm_vsl_cntr table standard<br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkRevLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopPso0006Event event = (VopPso0006Event)e;
		LaneExpenseRatioMgtBC command = new LaneExpenseRatioMgtBCImpl();
		PSOCodeFinderBC command2 = new PSOCodeFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			String isLane = command2.checkRevLane(event.getVsl_slan_cd());
			String strRevDirection = command.searchRevenueDirectionByRevLane(event.getServiceLaneListVO());

			eventResponse.setETCData("rlaneDirCd", StringUtils.isNotEmpty(strRevDirection) ? strRevDirection : "");
			eventResponse.setETCData("isLane", isLane);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**VOP_PSO_0214 : OPEN
	 * Retrieve Invoice Summary Detail<br>
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
	 * Monthly Estimation Creation (Delete, Insert)<br>
	 * @category VOP_PSO_0013_Creation
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
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
			throw new EventException(new ErrorHandler("PSO90001", new String[]{}).getMessage(), ex);	//$s Occured system error
		}
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0008 : Retrieve<br>
	 * Retrieve Budget Creation<br>
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

			List<BudCreVO> listMonth	= command.searchBudCreByMon(startDt, endDt);
			List<BudCreVO> listCurrency = command.searchBudCreByCurrency(startDt, endDt);
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
	 * Retrieve Estimate Creation.<br>
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
	 * Check whether Batch module is in action 
	 * @category VOP_PSO_0009
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
	 * 배치 실행 여부 체크.- Local 테스트 시 : true, 서버 : false 로 변환해야 한다.
	 * @param batchID
	 * @param bLocal
	 * @return
	 * @throws EventException
	 */
	private boolean checkRunningBatch(String batchID, boolean bLocal) throws EventException {
		boolean status = false;
		try{
			if(!bLocal){
				status = this.checkRunningBatch(batchID);
			}
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

			//2015.10.05 Modify
			//List<CostListVO> list2 = command.searchAccountList();
			List<CostListVO> list2 = command.searchAccountList(account.getOfc_cd());
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
				data.append(list3.get(0).getOfcCd());
				for(int i=1; i<list3.size(); i++){
					data.append("|"+list3.get(i).getOfcCd());
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
	 * VOP_PSO_0026 : Control Office 
	 * @category VOP_PSO_0026	
	 * @param Event e 
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchControlOfficeList(Event e) throws EventException{
		VopPso0026Event event = (VopPso0026Event)e;
		BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<CtrlOfficeVO> list = null;
		try{
			
			list = command.searchControlOfficeList(event.getInvSumByMonVO().getVskdPortRhqCd());
			
			StringBuilder sb = new StringBuilder();
			if(list != null){
				sb.append(list.get(0).getVopPortCtrlOfcCd());
				for(int i=1; i<list.size(); i++){
					sb.append("|"+list.get(i).getVopPortCtrlOfcCd());
				}
			}
			eventResponse.setETCData("ctrl_ofc_list", sb.toString());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0008 : Save<br>
	 * Save Budget Creation data(excel upload) 
	 * @category VOP_PSO_0008
	 * @param e
	 * @return EventResponse
	 * @throws EventException 
	 */
	private EventResponse manageBudCre(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0008Event event = (VopPso0008Event)e;
		BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
		try{
			begin();
			command.manageBudCre(event.getBudCreVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PSO90011", new String[]{}).getMessage(), ex);	// Save Exception Message
		}
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0006 : Check Rev Direction
	 * @category VOP_PSO_0006
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkRevenueDirection(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopPso0006Event event = (VopPso0006Event)e;
		LaneExpenseRatioMgtBC command = new LaneExpenseRatioMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			String strRevDirection = command.searchRevenueDirection(event.getServiceLaneListVO());
			
			//PA1|PA1TA|W|W > 데이타를 파싱한다.
			//String arrCheckRev[] = StringUtils.split(strRevDirection, "|");
			/*for(String revDir : arrCheckRev){
			}*/ 
			eventResponse.setETCData("checkYn", StringUtils.isNotEmpty(strRevDirection) ? "Y" : "N");
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0006 : Search Rev Direction
	 * @category VOP_PSO_0006
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRevenueDirectionByRevLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopPso0006Event event = (VopPso0006Event)e;
		LaneExpenseRatioMgtBC command = new LaneExpenseRatioMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			String strRevDirection = command.searchRevenueDirectionByRevLane(event.getServiceLaneListVO());

			eventResponse.setETCData("rlaneDirCd", StringUtils.isNotEmpty(strRevDirection) ? strRevDirection : "");
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
}