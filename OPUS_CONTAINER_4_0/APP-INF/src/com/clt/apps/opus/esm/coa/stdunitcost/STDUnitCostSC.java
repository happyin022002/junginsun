/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : STDUnitCostSC.java
 *@FileTitle : Register code for the logistics cost and accounts list
 *Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
*
 =========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.coa.common.Utils;
import com.clt.apps.opus.esm.coa.common.basic.CommonBC;
import com.clt.apps.opus.esm.coa.common.basic.CommonBCImpl;
import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;			//SJH.20140916.ADD
import com.clt.apps.opus.esm.coa.common.vo.GetCodeSelectVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.agencycommission.basic.AgencyCommissionBC;
import com.clt.apps.opus.esm.coa.stdunitcost.agencycommission.basic.AgencyCommissionBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.agencycommission.event.EsmCoa0157Event;
import com.clt.apps.opus.esm.coa.stdunitcost.agencycommission.vo.SearchAgnOtrCommCostListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.averagerpb.basic.AverageRPBBC;
import com.clt.apps.opus.esm.coa.stdunitcost.averagerpb.basic.AverageRPBBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.averagerpb.event.EsmCoa0183Event;
import com.clt.apps.opus.esm.coa.stdunitcost.averagerpb.event.EsmCoa0184Event;
import com.clt.apps.opus.esm.coa.stdunitcost.averagerpb.vo.AverageRPBVO;
import com.clt.apps.opus.esm.coa.stdunitcost.avgagncommission.basic.AvgAgencyCommissionBC;
import com.clt.apps.opus.esm.coa.stdunitcost.avgagncommission.basic.AvgAgencyCommissionBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.avgagncommission.event.EsmCoa4014Event;
import com.clt.apps.opus.esm.coa.stdunitcost.avgagncommission.vo.AvgAgencyCommissionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBC;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.event.EsmCoaAssignEvent;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.basic.CostStructureBC;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.basic.CostStructureBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event.EsmCoa0001Event;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event.EsmCoa0002Event;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event.EsmCoa0003Event;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event.EsmCoa0137Event;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event.EsmCoa0139Event;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event.EsmCoa0140Event;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event.EsmCoa2001Event;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event.EsmCoa2002Event;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event.EsmCoa2006Event;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event.EsmCoa2007Event;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration.CostStructureDBDAO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.CostStructureSoCodeRtnVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.EsmCoa0002ComboVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.MainGrpCostCodeVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.NodLnkCostCodeVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SearchCostCodeListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SearchCostStructure0139ListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SearchCostStructure0140ListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SpclRepoCntrVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SubGrpCostCodeVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.TableColumnVO;
import com.clt.apps.opus.esm.coa.stdunitcost.demdet3rd.basic.DemDet3rdBC;
import com.clt.apps.opus.esm.coa.stdunitcost.demdet3rd.basic.DemDet3rdBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.demdet3rd.event.EsmCoa0015Event;
import com.clt.apps.opus.esm.coa.stdunitcost.demdet3rd.vo.DemDet3rdVO;
import com.clt.apps.opus.esm.coa.stdunitcost.eqholding.basic.EQHoldingBC;
import com.clt.apps.opus.esm.coa.stdunitcost.eqholding.basic.EQHoldingBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.eqholding.event.EsmCoa0013Event;
import com.clt.apps.opus.esm.coa.stdunitcost.eqholding.vo.EqHoldingCostVO;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.basic.FullCostBC;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.basic.FullCostBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.event.EsmCoa0004Event;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.event.EsmCoa0008Event;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.event.EsmCoa0141Event;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.vo.SearchLinkCostListByPRDVO;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.vo.SearchLinkCostListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.vo.SearchMonthNodeCostListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.vo.SearchMonthYardCodeListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.genexpense.basic.GenExpenseBC;
import com.clt.apps.opus.esm.coa.stdunitcost.genexpense.basic.GenExpenseBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.genexpense.event.EsmCoa0019Event;
import com.clt.apps.opus.esm.coa.stdunitcost.genexpense.vo.SearchGeneralExpenseByVesselVO;
import com.clt.apps.opus.esm.coa.stdunitcost.genexpense.vo.SearchGeneralExpenseVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mriinquiry.basic.MRIInquiryBC;
import com.clt.apps.opus.esm.coa.stdunitcost.mriinquiry.basic.MRIInquiryBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.mriinquiry.event.EsmCoa0152Event;
import com.clt.apps.opus.esm.coa.stdunitcost.mriinquiry.vo.SearchMRIInquiryListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.basic.MTCostBC;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.basic.MTCostBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.event.EsmCoa0009Event;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.event.EsmCoa0010Event;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.event.EsmCoa4003Event;		//SJH.20140922.ADD
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListPopUpVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO10;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO11;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO12;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO13;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO14;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO2;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO3;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO4;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO5;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO6;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO7;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO8;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO9;
import com.clt.apps.opus.esm.coa.stdunitcost.sltint.basic.SLTIntBC;				//SJH.20141006.ADD
import com.clt.apps.opus.esm.coa.stdunitcost.sltint.basic.SLTIntBCImpl;			//SJH.20141006.ADD
import com.clt.apps.opus.esm.coa.stdunitcost.sltint.event.EsmCoa4001Event;		//SJH.20141006.ADD
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaBkgCostCalcVO;
import com.clt.syscommon.common.table.CoaUsaSvcModVO;
import com.clt.syscommon.common.table.CoaWkPrdVO;
//SJH.20140922.ADD

/**
 * COA Business Logic ServiceCommand<br> 
 *
 * @author
 * @see CostStructureDBDAO reference
 * @since J2EE 1.5
 */
public class STDUnitCostSC extends ServiceCommandSupport { 
	// Login User Information
	private SignOnUserAccount account = null;


	/**
	 * COA preceding process for a biz scenario<br>
	 * CostStructurerelated objects creation<br>
	 */
	public void doStart() {
		try {
			
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("STDUnitCostSC error " + e.toString(), e);
		}
	}

	/**
	 * COA biz scenario closing<br>
	 * CostStructureclearing related objects<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("STDUnitCostSC close");
	}

	/**
	 *
	 * @param e
	 *            Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

		log.debug("\n[CALL] Service Command ----------------------------- " + "\n EventName   : " + e.getEventName()
				+ "\n Command     : " + e.getFormCommand().getCommand());

		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsmCoa0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSpclRepoCntrList();
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSpclRepoCntr(e);
			} 	
		}

		//else if (e.getEventName().equalsIgnoreCase("EsmCoa0124Event")) {}

		else if (e.getEventName().equalsIgnoreCase("EsmCoa0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiCostCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = createOfficeLevel(e);					
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCostCodeList(e);					
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = getEsmCoa0002Combo(e);
			}  else if (e.getFormCommand().isCommand(FormCommand.INIT)){
				eventResponse =  searchComBoCdList0002(e);	
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmCoa0003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSoCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSoCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {// rowsearch
				return null;
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
				eventResponse = searchComBoCdList0003(e);	
			} else {
				eventResponse = searchSoCodeList();
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmCoa0004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMonthYardCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMonthNodeCostList (e);
			}
			else {
				eventResponse = searchComBoCdList0004 (e);
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmCoa0008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLinkCostList(e);
			}
			else {
				eventResponse = searchComBoCdList0008 (e);
			}
		}
		
//		/*
//		else if (e.getEventName().equalsIgnoreCase("ESM_COA_083Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {// sheet1 retrieve
//				eventResponse = searchNodeCostList(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {// sheet2 retreive
//				eventResponse = searchNodeCostDTLList(e);
//			}
//		}
//		*/
//
	else if (e.getEventName().equalsIgnoreCase("EsmCoa0009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMTCostList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMTCostList2(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchMTCostList3(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchMTCostList4(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchMTCostList5(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchMTCostList6(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchMTCostList7(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchMTCostList8(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchMTCostList9(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchMTCostList10(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchMTCostList11(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchMTCostList12(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchMTCostList13(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchMTCostList14(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createMBInfo(e);
			}
			else {
				eventResponse = searchComBoCdList0009(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmCoa0010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMTCostListPopUp(e);
			}	
		}

		else if (e.getEventName().equalsIgnoreCase("EsmCoa0013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEQHoldingCost(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiEQHoldingCost(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0013(e);
			}
		}
		

		else if (e.getEventName().equalsIgnoreCase("EsmCoa0015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDEMDET3RDList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiDEMDET3RD(e);
			}
			else {
				eventResponse = searchComBoCdList(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsmCoaAssignEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND21)) {//PRD (createCostAssignPrd)
				eventResponse = createCostAssignPrd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND22)) {//COP (createCostAssignCop)
				eventResponse = createCostAssignCopLoop(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND23)) {				
//				eventResponse = callOther(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchListAssign(e);
			}
		}
//
		else if (e.getEventName().equalsIgnoreCase("EsmCoa0137Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)||e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = this.searchCostStructure0137List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)||e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = this.searchCostStructure0137List2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiCostStructure0137(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0137(e);
			} else {
				eventResponse = searchComBoCdList0137(e);
			}
		}	

		else if (e.getEventName().equalsIgnoreCase("EsmCoa0139Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = this.searchCostStructure0139List(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiCostStructure0139(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmCoa0140Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCostStructure0140List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiCostStructure0140(e);
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmCoa0141Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLinkCostListByPRD(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmCoa0152Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMRIInquiryList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiMRIInquiry (e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchMRIInquiryCheck (e);
			} else {
            	eventResponse = searchComBoCdList0152(e);
            }
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmCoa0157Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgnOtrCommCostList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiAgnOtrCommCost(e);
			}else {
            	eventResponse = searchComBoCdList0157(e);
            }
		}

		else if (e.getEventName().equalsIgnoreCase("EsmCoa0019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchGeneralExpenseList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGeneralExpenseByVessel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiGeneralExpense(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createGeneralExpenseByVessel(e);
			//SJH.20141229.ADD
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = multiGeneralExpense3(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = multiGeneralExpense4(e);
			} else {
            	eventResponse = searchGeneralExpenseInit(e);
            }
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmCoa2001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { //inquiry 
				eventResponse = searchMainGrpCostCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { //save
				eventResponse = multiMainGrpCostCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)){ //combo
				eventResponse =  searchComBoCdList2001(e);	
			} else {
            	eventResponse = searchMainGrpCostCode(e);
            } 
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmCoa2002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { //retrieve 
				eventResponse = searchSubGrpCostCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { //save
				eventResponse = multiSubGrpCostCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)){ //combo box
				eventResponse = searchComBoCdList2002(e);
			} else {
            	eventResponse = searchSubGrpCostCode(e);
            } 
		}

		else if (e.getEventName().equalsIgnoreCase("EsmCoa2006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { //retrieve 
				eventResponse = searchUsaServiceMode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { //save
				eventResponse = multiUsaServiceMode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)){ //combo box
				eventResponse =  searchComBoCdList2006(e);	
            }
		}

		else if (e.getEventName().equalsIgnoreCase("EsmCoa2007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { //retrieve 
				eventResponse = searchWeekPeriod(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { //save
				eventResponse = multiWeekPeriod(e);
            }
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmCoa0183Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComBoCdList0183(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchAverageRPBCreationStatus(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRouteRPBList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSCCRPBList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchTradeRPBList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchLaneRPBList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchCustomerRPBList(e);
			//PCM.20150105.ADD
			}else {
            	eventResponse = searchGeneralExpenseInit(e);
            }			
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmCoa0184Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRPBStatus(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = monitorAverageRPB(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createAverageRPB(e);
			}
		}
		
		//20140915.SJH.ADD
		else if (e.getEventName().equalsIgnoreCase("EsmCoa4001Event")) {
			log.debug("\n==========================EsmCoa4001Event");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSlotIPList(e);
	        }else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {	        	
				eventResponse = multiSlotIPInfo(e);
	        } else {
	        	eventResponse = searchComBoCdList4001(e);
	        }
		}
		
		//20140922.SJH.ADD
		else if (e.getEventName().equalsIgnoreCase("EsmCoa4003Event")) {
			log.debug("\n==========================EsmCoa4003Event");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)||
				e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEqRepoCostList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)||
				 	 e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multiEqRepoCostInfo(e);
			}
			else {
				eventResponse = searchComBoCdList4003(e);
			}
		}
		
		//2017.01.11. NYK ADD
		else if (e.getEventName().equalsIgnoreCase("EsmCoa4014Event")) {
			log.debug("\n==========================EsmCoa4014Event");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Office, Country R
				eventResponse = searchAvgAgencyCommissionList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)){ //Office CUD
				eventResponse = manageAvgAgencyCommissionOffice(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){//Country CUD
				eventResponse = manageAvgAgencyCommissionCountry(e);
			}else{
				eventResponse = searchComBoCdList4014(e);
			}
		}

		return eventResponse;
	}

	/**
	 * Handling the inquiry event<br>
	 * CostStructure event list, Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpclRepoCntrList() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CostStructureBC command = new CostStructureBCImpl();

		try{
			List<SpclRepoCntrVO> list = command.searchSpclRepoCntrList();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * Handling multi event<br>
	 * CostStructure event, Handling multi event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpclRepoCntr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0001Event event = (EsmCoa0001Event)e;
		CostStructureBC command = new CostStructureBCImpl();
		try{
			begin();
			command.multiSpclRepoCntr(event.getCoaSpclRepoCntrRgstVOS(),account);
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
	 * Handling the inquiry event<br>
	 * About the Cost Element, Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostCodeList(Event e) throws EventException {
		EsmCoa0002Event event = (EsmCoa0002Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			CostStructureBC command = new CostStructureBCImpl();
			List<SearchCostCodeListVO> list = command.searchCostCodeList(event.getSearchConditionVO());			
			String tYearMonth = command.searchYearMonthValue();
			
			eventResponse.setRsVoList(list);			
			eventResponse.setETCData("T_YEAR_MONTH", tYearMonth);
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}
	

	/**
	 * ESM_COA_0002 : [Office Creation]
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createOfficeLevel(Event e) throws EventException {
		EsmCoa0002Event event = (EsmCoa0002Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			CostStructureBC command = new CostStructureBCImpl();
			command.createOfficeLevel(event.getSearchConditionVO());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}

	
	/**
	 * ESM_COA_0002 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0002(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
       try {    
    	   
    	    if (e.getFormCommand().isCommand(FormCommand.INIT)){
		       	String array[][] = { {"CD00205","",""},  			//PCM.20141222.MOD
		       						 {"mnGroup","",""},
		       						 {"subGroup","",""},
		       						 {"raMnGrp","",""},
		       						 {"raSubGrp","",""}
		       						};
		       	;
	    	    
		       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
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
	 * Handling the inquiry event<br>
	 * STDUnitCost event combo, Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse getEsmCoa0002Combo(Event e) throws EventException {
		EsmCoa0002Event event = (EsmCoa0002Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			EsmCoa0002ComboVO vo = event.getComboVO();
			EsmCoa0002ComboVO tempVo = event.getComboVO();
			
			List<EsmCoa0002ComboVO> list = new ArrayList<EsmCoa0002ComboVO>();
			list.add(tempVo);
			vo.setListSet(list);
			
			eventResponse.setRsVoList(vo.getListSet());
			return eventResponse; 
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}	
	
	
	/**
	 * Handling multi event<br>
	 * Cost Element event, Handling multi event<br>
	 *
	 * @param Event e          
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCostCode(Event e) throws EventException {
		EsmCoa0002Event event = (EsmCoa0002Event)e; // The objects contained the results of the user's request(DB Result Set, objects, values Etc.)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			String userId = event.getSignOnUserAccount().getUsr_id();
			CostStructureBC command = new CostStructureBCImpl();
			
			//Cost Year Month Update
			
			if(!event.getSearchConditionVO().getFCostYrmon().equals("") ) {
				command.multiYearMonthValue(event.getSearchConditionVO());
			}
				
			//sheet  save
			if(event.getCoaStndAcctVOs() != null) {
				command.multiCostCode(event.getCoaStndAcctVOs(), userId);
			}
			
			eventResponse.setUserMessage((String) new ErrorHandler("COM12116",new String[]{"Save"}).getUserMessage());
			commit();
			return (eventResponse); 
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
        }
	}		

	/**
	 * Cost Assign from the PRD
	 *
	 * @param et
	 * @return
	 * @throws EventException
	 */
	private EventResponse createCostAssignCopLoop(Event et) throws EventException {
		log.debug("### createCostAssignCopLoop");
		EsmCoaAssignEvent event = (EsmCoaAssignEvent) et;
		// RDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			CostAssignBC cmdCostAssign = new CostAssignBCImpl();
//			log.debug("\n bkg_no = "  + event.getFBkgNo());
//			log.debug("\n del_para = "  + event.getFDelPara());
//			log.debug("\n del_para = "  + event.getFLevel());
			cmdCostAssign.createCostAssignCopLoop(event.getFBkgNo(),  event.getFDelPara(), event.getFLevel(), "SYSTEM_COA");

			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Cost Assign from the PRD
	 *
	 * @param et
	 * @return
	 * @throws EventException
	 */
	private EventResponse createCostAssignPrd(Event et) throws EventException {
		log.debug("### createCostAssignPrd");
		EsmCoaAssignEvent event = (EsmCoaAssignEvent) et;
		// RDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// -----------------------------------------------------------------
			begin();
			CostAssignBC cmdCostAssign = new CostAssignBCImpl();
			cmdCostAssign.createCostAssignPrd(event.getFStartPctlNo(), event.getFEndPctlNo(), "SYSTEM_COA");
			commit();
			// -----------------------------------------------------------------

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	

	/**
	 * ESM_COA_0004 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0004(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
       try {    
	       	String array[][] = { {"costTableTpsz","",""},  
	       						 {"actGrp","",""},
	       						 {"CD00207","",""}
	       						};
	       						
	       	;
	       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
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
	 * ESM_COA_0004 <br>
	 * search event handling, Sheet1<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthYardCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0004Event event = (EsmCoa0004Event)e;
		FullCostBC command = new FullCostBCImpl();

		try{
			
			List<SearchMonthYardCodeListVO> list = command.searchMonthYardCodeList(event.getSearchMonthYardCodeListVO()
					                                                              ,event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0004 <br>
	 * search event handling, Sheet2<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthNodeCostList (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0004Event event = (EsmCoa0004Event)e;
		FullCostBC command = new FullCostBCImpl();

		try{		
			List<SearchMonthNodeCostListVO> list = command.searchMonthNodeCostList (event.getSearchMonthYardCodeListVO()
					                                                               ,event.getSearchMonthNodeCostListVO()
																				   ,event.getSearchConditionVO());			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * ESM_COA_0008 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0008(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
       try {    
	       	String array[][] = { {"CD00207","",""},
	       						 {"costTableTpsz","",""},  
	       						 {"actGrp","",""}
	       						};
	       						
	       	;
	       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
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
	 * ESM_COA_0008 <br>
	 * search event handling, Sheet1<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLinkCostList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0008Event event = (EsmCoa0008Event)e;
		FullCostBC command = new FullCostBCImpl();

		try{
			List<SearchLinkCostListVO> list = command.searchLinkCostList(event.getSearchLinkCostListVO()
					                                                    ,event.getSearchConditionVO());
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
	 * search event handling<br>
	 * ESM_COA_141 Popup, search event handling<br>
	 *
	 * @param e
	 *            Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLinkCostListByPRD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0141Event event = (EsmCoa0141Event)e;
		FullCostBC command = new FullCostBCImpl();

		try{
			List<SearchLinkCostListByPRDVO> list = command.searchLinkCostListByPRD(event.getSearchLinkCostListByPRDVO(),event.getSearchConditionVO());
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
	 * ESM_COA_0009 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0009(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
       try {    
	       	String array[][] = { {"CD20015","",""}, 
	       						 {"ECC","",""},
	       						 {"LCC","",""},  
	       						 {"RCC","",""},
	       						 {"tpSz","",""}
	       						};
	       						
	       	;
	       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
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
	 * ESM_COA_0009 <br>
	 * search event handling, Sheet1_MTY<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCostList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0009Event event = (EsmCoa0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCostListVO> list = command.searchMTCostList(event.getSearchMTCostListVO()
					                                                ,event.getSearchConditionVO());
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
	 * ESM_COA_0009 <br>
	 * search event handling, Sheet2_MTY<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCostList2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0009Event event = (EsmCoa0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCostListVO2> list = command.searchMTCostList2(event.getSearchMTCostListVO2()
					                                                  ,event.getSearchMTCostListVO());
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
	 * ESM_COA_0009 <br>
	 * search event handling, Sheet3_MTY<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCostList3(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0009Event event = (EsmCoa0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCostListVO3> list = command.searchMTCostList3(event.getSearchMTCostListVO3()
					                                                  ,event.getSearchMTCostListVO2());
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
	 * ESM_COA_0009 <br>
	 * search event handling, Sheet4_MTY<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCostList4(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0009Event event = (EsmCoa0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCostListVO4> list = command.searchMTCostList4(event.getSearchMTCostListVO4()
					                                                  ,event.getSearchConditionVO());
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
	 * ESM_COA_0009 <br>
	 * search event handling, Sheet5_MTY<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCostList5(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0009Event event = (EsmCoa0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCostListVO5> list = command.searchMTCostList5(event.getSearchMTCostListVO5()
					                                                  ,event.getSearchMTCostListVO4());
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
	 * ESM_COA_0009 <br>
	 * search event handling, Sheet6_MTY<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCostList6(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0009Event event = (EsmCoa0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCostListVO6> list = command.searchMTCostList6(event.getSearchMTCostListVO6()
					                                                  ,event.getSearchConditionVO());
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
	 * ESM_COA_0009 <br>
	 * search event handling, Sheet6_MTY<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCostList7(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0009Event event = (EsmCoa0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCostListVO7> list = command.searchMTCostList7(event.getSearchMTCostListVO7()
					                                                  ,event.getSearchMTCostListVO6());
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
	 * ESM_COA_0009 <br>
	 * search event handling, Sheet8_FULL<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCostList8(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0009Event event = (EsmCoa0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCostListVO8> list = command.searchMTCostList8(event.getSearchMTCostListVO8()
					                                                  ,event.getSearchConditionVO());
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
	 * ESM_COA_0009 <br>
	 * search event handling, Sheet9_FULL<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCostList9(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0009Event event = (EsmCoa0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCostListVO9> list = command.searchMTCostList9(event.getSearchMTCostListVO9()
					                                                  ,event.getSearchMTCostListVO8());
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
	 * ESM_COA_0009 <br>
	 * search event handling, Sheet10_FULL<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCostList10(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0009Event event = (EsmCoa0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCostListVO10> list = command.searchMTCostList10(event.getSearchMTCostListVO10()
					                                                    ,event.getSearchMTCostListVO9());
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
	 * ESM_COA_0009 <br>
	 * search event handling, Sheet11_FULL<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCostList11(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0009Event event = (EsmCoa0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCostListVO11> list = command.searchMTCostList11(event.getSearchMTCostListVO11()
					                                                    ,event.getSearchConditionVO());
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
	 * ESM_COA_0009 <br>
	 * search event handling, Sheet12_FULL<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCostList12(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0009Event event = (EsmCoa0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCostListVO12> list = command.searchMTCostList12(event.getSearchMTCostListVO12()
					                                                    ,event.getSearchMTCostListVO11());
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
	 * ESM_COA_0009 <br>
	 * search event handling, Sheet13_FULL<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCostList13(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0009Event event = (EsmCoa0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCostListVO13> list = command.searchMTCostList13(event.getSearchMTCostListVO13()
					                                                    ,event.getSearchConditionVO());
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
	 * ESM_COA_0009 <br>
	 * search event handling, Sheet14_FULL<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCostList14(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0009Event event = (EsmCoa0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCostListVO14> list = command.searchMTCostList14(event.getSearchMTCostListVO14()
					                                                    ,event.getSearchMTCostListVO13());
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
	 * Handling the inquiry event<br>
	 * CostStructure event list, Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createMBInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0009Event event = (EsmCoa0009Event)e;
		MTCostBC command = new MTCostBCImpl();
		try{
			String strStatus = command.createMBInfo(event.getSearchConditionVO(),account);				
			eventResponse.setETCData("BatchStatus", strStatus);
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0010 <br>
	 * <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private EventResponse searchMTCostListPopUp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0010Event event = (EsmCoa0010Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCostListPopUpVO> list = command.searchMTCostListPopUp(event.getSearchMTCostListPopUpVO()
																			  ,event.getSearchConditionVO());
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
	 * ESM_COA_0013 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0013(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
	   	//EsmCoa0013Event event = (EsmCoa0013Event)e;
	   	//String code = null;
       try {        	  
	       	String array[][] = {
						 {"tpSz","",""},
						 //SJH.20141226.MOD : EQSF, CVMR
   						 {"coaCode","EQCF,CVMR"," "}, // container eq holding C/A code   						 
   					     //SJH.20141222.MOD : EQSF -> CVSF
   						 {"coaCode","CVSF"," "},
   					 	 {"CD00201","",""}, // contract average indicator
   					 	 {"CD00817","",""}
	       						};
	       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);	       						
	       	
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
	 * ESM_COA_0013 <br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQHoldingCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0013Event event = (EsmCoa0013Event)e;
		EQHoldingBC command = new EQHoldingBCImpl();

		try{
			List<EqHoldingCostVO> list = command.searchEQHoldingCost(event.getSearchConditionVO());
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
	 * ESM_COA_0013 <br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiEQHoldingCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0013Event event = (EsmCoa0013Event)e;
		EQHoldingBC command = new EQHoldingBCImpl();
		try{
			begin();
			command.multiEQHoldingCost(event.getEqHoldingCostVOS(), event.getSearchConditionVO(), account);
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
	 * ESM_COA_0015 <br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDEMDET3RDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0015Event event = (EsmCoa0015Event)e;
		DemDet3rdBC command = new DemDet3rdBCImpl();

		try{
			List<DemDet3rdVO> list = command.searchDEMDET3RDList(event.getSearchConditionVO());
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
	 * ESM_COA_0015 <br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiDEMDET3RD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0015Event event = (EsmCoa0015Event)e;
		DemDet3rdBC command = new DemDet3rdBCImpl();
		try{
			begin();
			command.multiDEMDET3RD(event.getDemDet3rdVOS(), event.getSearchConditionVO(), account);
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
	 * ESM_COA_0137 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event 
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0137(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0137Event event = (EsmCoa0137Event)e;
	   	CommonBC codeUtil = new CommonBCImpl();
	   	SearchConditionVO vo  = event.getSearchConditionVO();
	   	
       try {    
    	    if (e.getFormCommand().isCommand(FormCommand.INIT)){
		       	String array[][] = { 
		       							{"srcCd",event.getFTableName(),""},
		       							{"srcStndCd",event.getFTableName(),""},
		       							{"currency",event.getFTableName(),""},
		       							{"CD00207",event.getFTableName(),""},
		       							{"tpsz",event.getFTableName(),""}
		       						};
		       	;
	    	    
		       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	    }else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)){
				boolean  rtnValue = codeUtil.checkNodeCode(vo.getFTmlCd());
				eventResponse.setETCData("rtnValue", String.valueOf(rtnValue));
    	    }else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)){
				boolean  rtnValue = codeUtil.checkLocationCode(vo.getFLocCd());
				eventResponse.setETCData("rtnValue", String.valueOf(rtnValue));
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
	 * Handling the inquiry event<br>
	 * NODE, LINK cost table Inquiry<br>
	 *
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostStructure0137List(Event e) throws EventException {
		EsmCoa0137Event event = (EsmCoa0137Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			CostStructureBC command = new CostStructureBCImpl();
			List<TableColumnVO> list = command.searchCostStructure0137List(event.getFTableName());
			eventResponse.setRsVoList(list);
			return eventResponse; 
		} catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}
	
	/**
	 * Handling the inquiry event<br>
	 * NODE,LINK unit cost  Inquiry<br>
	 *
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostStructure0137List2(Event e) throws EventException {
		EsmCoa0137Event event = (EsmCoa0137Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			CostStructureBC command = new CostStructureBCImpl();
			List<NodLnkCostCodeVO> list = command.searchCostStructure0137List2(event.getFTableName(), event.getTableColumnVOs());
			eventResponse.setRsVoList(list);
			return eventResponse; 
		} catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}
			
	/**
	 * Handling multi event<br>
	 * NODE unit cost,  Handling multi event<br>
	 *
	 * @param e
	 *            Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCostStructure0137(Event e) throws EventException {
		EsmCoa0137Event event = (EsmCoa0137Event)e; // The objects contained the results of the user's request(DB Result Set, objects, values Etc.)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			CostStructureBC command = new CostStructureBCImpl();
			command.multiCostStructure0137(event.getFTableName(), event.getNodLnkCostCodeVOs(),   account);
			commit();
			return (eventResponse); 
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESM_COA_0139 <br>
	 * <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */

	private EventResponse searchCostStructure0139List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0139Event event = (EsmCoa0139Event)e;
		CostStructureBC command = new CostStructureBCImpl();
		
		try{
			List<SearchCostStructure0139ListVO> list = command.searchCostStructure0139List(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	/**
	 * ESM_COA_0139 <br>
	 * <br>
	 *
	 * @param Event e
	 * @exception EventException
	 */
	private EventResponse multiCostStructure0139(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0139Event event = (EsmCoa0139Event)e;
		CostStructureBC command = new CostStructureBCImpl();
		try{
			begin();
			command.multiCostStructure0139(event.getCoaTrnsFdrTermVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}


	/**
	 * ESM_COA_0140 <br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostStructure0140List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0140Event event = (EsmCoa0140Event)e;
		CostStructureBC command = new CostStructureBCImpl();

		try{
			List<SearchCostStructure0140ListVO> list = command.searchCostStructure0140List(event.getSearchCostStructure0140ListVO()
					                                                                      ,event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * ESM_COA_0140 <br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCostStructure0140(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0140Event event = (EsmCoa0140Event)e;
		CostStructureBC command = new CostStructureBCImpl();
		try{
			begin();
			command.multiCostStructure0140(event.getCoaTrnsTermCalcVOS(),account);
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
	 * Handling the inquiry event<br>
	 * ESM_COA_assign event list, Handling the inquiry event<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchListAssign(Event e) throws EventException {
log.debug("\n==========================STDUnitCostSC searchListAssign(Event e) ");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoaAssignEvent event = (EsmCoaAssignEvent)e;
		CostAssignBC command = new CostAssignBCImpl();

		try{
			 List<CoaBkgCostCalcVO>  list = command.searchListAssign(event.getFCoaBatCd());
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
	 * ESM_COA_0152 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0152(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0152Event event = (EsmCoa0152Event)e;
	   	CommonBC codeUtil = new CommonBCImpl();
       try {    
    	   if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)){
    		    String array[][] = { {"rLane",event.getSearchConditionVO().getFTrdCd(),""},		//SJH.20141230.MOD
    		    					};
    		    eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
    		    String array[][] = { 
 						 {"rLane2",event.getSearchConditionVO().getFTrdCd(),""}
 						};
			 	;
			 	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)){
	   		    String array[][] = { {"rLane",event.getSearchConditionVO().getFTrdCd(),""},
				};
	   		    eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);	 	
    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)){
	   		    String array[][] = { {"rLane2","",""}};
			 	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
		   }else{
    		   /*-------------------------------------------------------*/
		       	String array[][] = { {"trade","",""},  
		       					//	 {"rLane","",""}, 
		       						 {"rLane2","",""},
		       						 {"CD00593","",""},
		       						 {"trade","",""}, 
		       						};
		       						
		       	;
		       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
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
	 * ESM_COA_0152 <br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMRIInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0152Event event = (EsmCoa0152Event)e;
		MRIInquiryBC command = new MRIInquiryBCImpl();

		try{
			List<SearchMRIInquiryListVO> list = command.searchMRIInquiryList(event.getSearchMRIInquiryListVO()
																			,event.getSearchConditionVO());
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
	 * ESM_COA_0152 : [SAVE]<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMRIInquiryCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0152Event event = (EsmCoa0152Event)e;
		MRIInquiryBC command = new MRIInquiryBCImpl();

		try{
			List<GetCodeSelectVO> list = command.searchMRIInquiryCheck(event.getSearchMRIInquiryListVOs());
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
	 * ESM_COA_0152 <br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiMRIInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0152Event event = (EsmCoa0152Event)e;
		MRIInquiryBC command = new MRIInquiryBCImpl();
		try{
			begin();
			command.multiMRIInquiry(event.getCoaMonMiscRevPreTeuVOS(), event.getSearchConditionVO(), account);
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
	 * ESM_COA_0157 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event 
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0157(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
       try {    
    	    if (e.getFormCommand().isCommand(FormCommand.INIT)){
		       	String array[][] = { 
				       				{"OtrCommLoc","","All"},
									{"costSrcAcctGrpCd","CVAC|51269",""},			//SJH.20150205.MOD : 다른쿼리
									{"CD00817","",""}
		       						};
		       	;
	    	    
		       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
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
	 * ESM_COA_0157 <br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgnOtrCommCostList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0157Event event = (EsmCoa0157Event)e;
		AgencyCommissionBC command = new AgencyCommissionBCImpl();

		try{
			List<SearchAgnOtrCommCostListVO> list = command.searchAgnOtrCommCostList(event.getSearchAgnOtrCommCostListVO(),event.getSearchConditionVO());
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
	 * ESM_COA_0157 <br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiAgnOtrCommCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0157Event event = (EsmCoa0157Event)e;
		AgencyCommissionBC command = new AgencyCommissionBCImpl();
		try{
			begin();
			command.multiAgnOtrCommCost(event.getCoaOtrCommVOS(), event.getSearchConditionVO(), account);
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
	 * ESM_COA_0003 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0003(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
	   	EsmCoa0003Event event = (EsmCoa0003Event)e;
       try {    
    	   
    	    if (e.getFormCommand().isCommand(FormCommand.INIT)){
		       	String array[][] = { {"subGroup","",""},  
		       						 {"coaCode","",""},  
		       						 {"CD00201","",""}
		       						};
		       						
		       	;
	    	    
		       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	    }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)){
    	    	String array[][] = { {"coaCode",event.getCostStructureConditionVO().getFSgrpCostCd(),""}
  						};
  						
    	    	;
   
    	    	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
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
	 * Handling the inquiry event<br>
	 * About the SO Cost Code, Handling the inquiry event<br>
	 *
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSoCodeList() throws EventException {
		// The objects contained the results of the user's request(DB Result Set, objects, values Etc.)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CostStructureBC command = new CostStructureBCImpl();

		try{
			CostStructureSoCodeRtnVO mVo = command.searchSoCodeList();
			eventResponse.setCustomData("retVo", mVo);	
		
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0003 <br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSoCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0003Event event = (EsmCoa0003Event)e;
		CostStructureBC command = new CostStructureBCImpl();
		CostStructureSoCodeRtnVO rsVO = null;
		
		String userId = event.getSignOnUserAccount().getUsr_id();
		
		try{ 
			List<CostStructureSoCodeRtnVO> list = new ArrayList<CostStructureSoCodeRtnVO>();
			rsVO = command.searchSoCodeList(event.getCostStructureConditionVO(), userId);
			list.add(rsVO);
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
	 * Handling multi event<br>
	 * SO Cost Code event, Handling multi event<br>
	 *
	 * @param e
	 *            Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSoCode(Event e) throws EventException {
		EsmCoa0003Event event = (EsmCoa0003Event)e; // The objects contained the results of the user's request(DB Result Set, objects, values Etc.)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String userId = event.getSignOnUserAccount().getUsr_id();
		try {
			begin();
			CostStructureBC command = new CostStructureBCImpl();
			command.multiSoCode(event.getSearchSoCodeListVO(), event.getSearchSoCodeListVOs(), userId);
			commit();
			return (eventResponse); 
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
	}	
	
    
    /**
	 * ESM_COA_XXXX : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC commonBC = new CommonBCImpl();
       try {    
    	   if(e.getEventName().equals("EsmCoa0015Event")){
    			String array[][] = {{"demdetCACd","",""}, 
  						 			{"CD00201","",""},
  						 			{"CD00817","",""}
  									};
    		    eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
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
	 * ESM_COA_0019 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGeneralExpenseInit(Event e) throws EventException {		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			
			String[] yrMon = Utils.getYearMonthList("", 9); //SJH.20140724/20141229 MOD : 7->8->9
			
			//String colYrMon = "";
			StringBuffer sb = new StringBuffer();
			for(int i=2; i< yrMon.length; i++) {			//SJH.20140724/20141229 MOD : i=0->1->2
				//colYrMon = colYrMon + "|" + yrMon[i];
				sb.append("|");
				sb.append(yrMon[i]);
				
			}
			
			eventResponse.setETCData("YRMON", yrMon[0]);
			eventResponse.setETCData("COL_YRMON", sb.toString());
		
	    } catch(Exception ex){
	        throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
	    }
		
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0019: [Retrieve]<br>
	 * [General Expense Information] Inquiry<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGeneralExpenseList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0019Event event = (EsmCoa0019Event)e;
		GenExpenseBC command = new GenExpenseBCImpl();

		try{
			List<SearchGeneralExpenseVO> list = command.searchGeneralExpenseList(event.getCoaDmdtN3rdPtyVO());
			
			String[] cols = Utils.getYearMonthList(event.getCoaDmdtN3rdPtyVO().getCostYrmon(), 9); 	//SJH.20140724/20141229 MOD : 7->8->9
			//String colYrMon = "";
			StringBuffer sb = new StringBuffer();
			for(int i=2; i<cols.length; i++) {														//SJH.20140724/20141229 MOD : 0->1->2
				//colYrMon = colYrMon + "|" + cols[i];
				sb.append("|");
				sb.append(cols[i]);				
			}
			
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("COL_YRMON", sb.toString());
			
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
		
	/**
	 * ESM_COA_0019: [VSL Unit cost]<br>
	 * [General Expense Information by VSL] Inquiry<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGeneralExpenseByVessel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0019Event event = (EsmCoa0019Event)e;
		GenExpenseBC command = new GenExpenseBCImpl();

		try{
			List<SearchGeneralExpenseByVesselVO> list1 = command.searchGeneralExpenseByVessel(event.getCoaDmdtN3rdPtyVO());
			List<SearchGeneralExpenseByVesselVO> list2 = command.searchGeneralExpenseByVesselClass(event.getCoaDmdtN3rdPtyVO());
			
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
			
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0019 : [Save]<br>
	 * [General Expense Information] Save<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiGeneralExpense(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0019Event event = (EsmCoa0019Event)e;
		GenExpenseBC command = new GenExpenseBCImpl();
		try{
			begin();			
			command.multiGeneralExpense(event.getCoaDmdtN3rdPtyVOS(),account);			
            //eventResponse.setUserMessage((String) new ErrorHandler("COM12191",new String[]{"Data"}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0019 : [Save]<br>
	 * [General Expense Information] Save<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiGeneralExpense3(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0019Event event = (EsmCoa0019Event)e;
		GenExpenseBC command = new GenExpenseBCImpl();
		try{
			begin();
			command.multiGeneralExpense3(event.getCoaDmdtN3rdPtyVOS(),account);			
            //eventResponse.setUserMessage((String) new ErrorHandler("COM12191",new String[]{"Data"}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0019 : [Save]<br>
	 * [General Expense Information] Save<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiGeneralExpense4(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0019Event event = (EsmCoa0019Event)e;
		GenExpenseBC command = new GenExpenseBCImpl();
		try{
			begin();			
			command.multiGeneralExpense4(event.getCoaDmdtN3rdPtyVOS(),account);			
            //eventResponse.setUserMessage((String) new ErrorHandler("COM12191",new String[]{"Data"}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}	
	
	
	/**
	 * ESM_COA_0019 : [Create]<br>
	 * [GeneralExpense Information by VSL] Creation<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createGeneralExpenseByVessel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0019Event event = (EsmCoa0019Event)e;
		GenExpenseBC command = new GenExpenseBCImpl();
		try{
			begin();			
			command.createGeneralExpenseByVessel(event.getCoaDmdtN3rdPtyVO());		
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_COA_2001: [Register Main Group Cost Code]<br>
	 * [Main Group Cost Code Information] Inquiry<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMainGrpCostCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa2001Event event = (EsmCoa2001Event)e;
		CostStructureBC command = new CostStructureBCImpl();
		try{
		
			List<MainGrpCostCodeVO> list = command.searchMainGrpCostCode(event.getStndCostTpCd());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_COA_2001: [Register Main Group Cost Code]<br>
	 * [Main Group Cost Code Information] Creation/Save/Delete<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiMainGrpCostCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa2001Event event = (EsmCoa2001Event)e;
		CostStructureBC command = new CostStructureBCImpl();
		try{
			begin();
			String DupChk = command.multiMainGrpCostCode(event.getMainGrpCostCodeVOS(), account);
//			command.multiMainGrpCostCode(event.getMainGrpCostCodeVOS(), account);
			if(DupChk.equals("Dup")||DupChk.equals("DescDup")){
				rollback();
			}
			else{
				commit();
			}
			eventResponse.setETCData("dup_chk", DupChk);
			
				
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_COA_2001: [Register Main Group Cost Code]<br>
	 * [Profit Level Information] Inquiry<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList2001(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
       	   
	   	try{
		   	 if (e.getFormCommand().isCommand(FormCommand.INIT)){
			       	String array[][] = { {"CD00205","",""} };					
		    	    
			       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
		   	 }
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse; 

   }
	
	/**
	 * ESM_COA_2002: [Register Sub Group Cost Code]<br>
	 * [Sub Group Cost Code information] [retrieve]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubGrpCostCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa2002Event event = (EsmCoa2002Event)e;
		CostStructureBC command = new CostStructureBCImpl();
		try{
		
			List<SubGrpCostCodeVO> list = command.searchSubGrpCostCode(event.getStndCostTpCd(),event.getMainGroupCostCd());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_COA_2002: [Register Sub Group Cost Code]<br>
	 * [Sub Group Cost Code information] [create/save/delete]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSubGrpCostCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa2002Event event = (EsmCoa2002Event)e;
		CostStructureBC command = new CostStructureBCImpl();
		try{
			begin();
			String DupChk = command.multiSubGrpCostCode(event.getSubGrpCostCodeVOS(), account);
			if(DupChk.equals("Dup")||DupChk.equals("DescDup")){
				rollback();
			}
			else{
				commit();
			}
			eventResponse.setETCData("dup_chk", DupChk);
			
				
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_COA_2002: [Register Sub Group Cost Code]<br>
	 * [Profit Level information] [retrieve]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList2002(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
	   	CostStructureBC command = new CostStructureBCImpl();
	   	
	   	try{
	   		if (e.getFormCommand().isCommand(FormCommand.INIT)){
	   			String array[][] = { {"CD00205","",""}};	
	   			String tempStndCostTpCd = null;
				tempStndCostTpCd = "All";
				List<MainGrpCostCodeVO> list = command.searchMainGrpCostCode(tempStndCostTpCd);

	   			log.debug(array);
		       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
		       	eventResponse.setRsVoList(list);
    	    }
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse; 

   }

	/**
	 * ESM_COA_2006 : retrieve<br>
	 * Retrieving USA Service Mode<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsaServiceMode(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		EsmCoa2006Event event = (EsmCoa2006Event)e;
		CostStructureBC command = new CostStructureBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{		
			List<CoaUsaSvcModVO> list = command.searchUsaServiceMode(event.getOrgRgnCd(), event.getDestRgnCd(), event.getSvcModCd());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}			
		return eventResponse;
	}



	/**
	 * ESM_COA_2006 : save<br>
	 * Saving USA Service Mode<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiUsaServiceMode(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa2006Event event = (EsmCoa2006Event)e;
		CostStructureBC command = new CostStructureBCImpl();
		try{
			begin();
			command.multiUsaServiceMode(event.getCoaUsaSvcModVOS(),account);
			commit();
			//eventResponse.setUserMessage(new ErrorHandler("COA00003").getMessage());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}


	
	/**
	 * ESM_COA_2006 : combo<br>
	 * Retrieving USA Service Mode<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList2006(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
       	   
	   	try{
		   	 if (e.getFormCommand().isCommand(FormCommand.INIT)){
			       	String array[][] = { {"mdmUSARegion","",""}, {"mdmUSARegion","",""}, {"CD01052","",""} };					
		    	    
			       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
		   	 }
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse; 

   }

	
	/**
	 * ESM_COA_2007 : retrieve<br>
	 * Retrieving Week Period<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeekPeriod(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		EsmCoa2007Event event = (EsmCoa2007Event)e;
		CostStructureBC command = new CostStructureBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{		
			List<CoaWkPrdVO> list = command.searchWeekPeriod(event.getCostYr(), event.getCostWkFm(), event.getCostWkTo());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}			
		return eventResponse;
	}



	/**
	 * ESM_COA_2007 : save<br>
	 * Saving Week Period<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiWeekPeriod(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa2007Event event = (EsmCoa2007Event)e;
		CostStructureBC command = new CostStructureBCImpl();
		try{
			begin();
			command.multiWeekPeriod(event.getCoaWkPrdVOS(),account);
			commit();
			//eventResponse.setUserMessage(new ErrorHandler("COA00003").getMessage());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	   /**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
private EventResponse searchComBoCdList0183(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC commonBC = new CommonBCImpl();
	   	try {    
			       	
			        /*-------------------------------------------------------*/
			       	String array[][] = { 
							 /*1. Trade*/
							 {"trade","","All"}, 
							 /*2. Service Lane*/
							 {"rLane3","","All"},
							 /*3. IOC */
							 {"IOC","","All"}, 
							 /*4. Direction*/
							 {"Dir","","All"},
							 /*5.Container Type Size*/
							 {"tpSz","","All"}
							 
	  						};
	  						
				  	;
				  	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
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
	 * ESM_COA_0183 : CREATE 된 기간 조회
	 *
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAverageRPBCreationStatus(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AverageRPBBC command = null;
		String retVal = "";
		try{
			EsmCoa0183Event event = (EsmCoa0183Event) e;
			command = new AverageRPBBCImpl();
			retVal = command.searchAverageRPBCreationStatus(event.getAverageRPBVO().getFRpbYrmon());
			eventResponse.setETCData("period", retVal);
//			eventResponse.setETCData("period", !"".equalsIgnoreCase(period) ? "("+period+")":"");
		} catch(EventException ex) {
         rollback();
         log.error("err " + ex.toString(), ex);
         throw ex;
     } catch(Exception ex) {
         rollback();
         log.error("err " + ex.toString(), ex);
         throw new EventException(new ErrorHandler(ex).getMessage());
     }	
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0183 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRouteRPBList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0183Event event = (EsmCoa0183Event)e;
		try{
			AverageRPBBC command = new AverageRPBBCImpl();
			List<AverageRPBVO> list = command.searchRouteRPBList(event.getAverageRPBVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
		return eventResponse; 
	}
	
	/**
	 * ESM_COA_0183 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSCCRPBList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0183Event event = (EsmCoa0183Event)e;
		try{
			AverageRPBBC command = new AverageRPBBCImpl();
			List<AverageRPBVO> list = command.searchSCCRPBList(event.getAverageRPBVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
		return eventResponse; 
	}
	
	/**
	 * ESM_COA_0183 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTradeRPBList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0183Event event = (EsmCoa0183Event)e;
		try{
			AverageRPBBC command = new AverageRPBBCImpl();
			List<AverageRPBVO> list = command.searchTradeRPBList(event.getAverageRPBVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
		return eventResponse; 
	}
	
	/**
	 * ESM_COA_0183 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLaneRPBList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0183Event event = (EsmCoa0183Event)e;
		try{
			AverageRPBBC command = new AverageRPBBCImpl();
			List<AverageRPBVO> list = command.searchLaneRPBList(event.getAverageRPBVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
		return eventResponse; 
	}
	
	/**
	 * ESM_COA_0183 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCustomerRPBList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0183Event event = (EsmCoa0183Event)e;
		try{
			AverageRPBBC command = new AverageRPBBCImpl();
			List<AverageRPBVO> list = command.searchCustomerRPBList(event.getAverageRPBVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
		return eventResponse; 
	}
	
	/**
	 * ESM_COA_0184 : Creation <br>
	 * Create TS Allocation 1<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRPBStatus(Event e) throws EventException {
		EsmCoa0184Event event = (EsmCoa0184Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AverageRPBBC command = new AverageRPBBCImpl();
		try {			
			//1. Target YRMON 에 대해 배치가 실행 되었는지 확인한다
			String tagetYrMonStatus = command.searchRPBStatus(event.getAverageRPBVO().getFTargetYrmon());		
				eventResponse.setETCData("TagetYrMonStatus", tagetYrMonStatus);
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Average RPB Batch <br>
	 * Batch status monitoring
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse monitorAverageRPB(Event e) throws EventException {
		EsmCoa0184Event event = (EsmCoa0184Event)e;																		//20150817.ADD
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AverageRPBBC command = new AverageRPBBCImpl();	
		try {
			//1. 배치가 돌고 있는지 Check 한다
			String strStatus = command.checkAverageRPBCreateBatchStatus(event.getAverageRPBVO().getFTargetYrmon());		//20150817.ADD
			eventResponse.setETCData("BatchStatus", strStatus);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0047 : Creation <br>
	 * Create TS Allocation 1<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createAverageRPB(Event e) throws EventException {
		EsmCoa0184Event event = (EsmCoa0184Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AverageRPBBC command = new AverageRPBBCImpl();
		try {			
//			//1. 배치가 돌고 있는지 Check 한다
//			String strStatus = command.checkAverageRPBCreateBatchStatus();		
//			//2. 만약 진행중인 상태이면 해당 상태를 알리고 더 이상 진행하지 않는다. 
//			if("P".equals(strStatus)){
//				eventResponse.setETCData("BatchStatus", strStatus);
//				return eventResponse;
//			}
			// 3. batch status를 생성한다.
			begin();
			command.modifyAverageRPBStatus(event.getAverageRPBVO(), account);		
			commit();
			// 4. batch를 실행한다.
			String strStatus = command.createAverageRPB(event.getAverageRPBVO(), account);						
			eventResponse.setETCData("BatchStatus", strStatus);
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_COA_4001 : Search <br>
	 * Search Slot Internal Pricing<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author SJH.20140916.ADD
	 */
	private EventResponse searchSlotIPList(Event e) throws EventException {
		EsmCoa4001Event event = (EsmCoa4001Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{			
			SLTIntBC command = new SLTIntBCImpl();
            event.getCommonCoaRsVO().setEventName("EsmCoa4001Event");
            CommonCoaRsVO rtnVo = command.searchSlotIPList(event.getSearchConditionVO());
            eventResponse.setRsVo(rtnVo.getDbRowset());	
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
    }
	
	/**
	 * ESM_COA_4001 : Save <br>
	 * Save Slot Internal Pricing<br>
	 *
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 * @author SJH.20140916.ADD
	 */
    private EventResponse multiSlotIPInfo(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa4001Event event = (EsmCoa4001Event)e;
		SLTIntBC command = new SLTIntBCImpl();
		try{
//			begin();
//			String DupChk = command.multiSlotIPInfo(event.getSlotInternalPricingVOS(), event.getSearchConditionVO(), account);
//			if(DupChk.equals("Dup")){
//				rollback();
//			}
//			else{
//				commit();
//			}
//			eventResponse.setETCData("dup_chk", DupChk);
			
			begin();
			command.multiSlotIPInfo(event.getSlotInternalPricingVOS(), event.getSearchConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();		
			eventResponse.setETCData("dup_chk", "");
			
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
    }	
    
    /**
	 * ESM_COA_4001 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author 20140915.SJH.ADD
	 */
   private EventResponse searchComBoCdList4001(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa4001Event event = (EsmCoa4001Event)e;
	   	CommonBC commonBC = new CommonBCImpl();
       try {   
   	  	    //SJH.20150105.ADD
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){
			    String array[][] = { {"subTrade",event.getSearchConditionVO().getFTrdCd(),""},	
			    					};
			    eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)){
			    String array[][] = { {"subTrade",event.getSearchConditionVO().getFCbotrade(),""},	
			    					};
			    eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
			} else {
		       	String array[][] = { {"sLane", "", ""},
  						 {"trade","",""},
  					 	 {"subTrade2", "", ""},
  						 {"CD01956","",""}, 
  						 {"cnt","",""}					//SJH.20150224.ADD
  						};
  						
			  	;
			  	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);				
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
	 * ESM_COA_4003 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author 20140922.SJH.ADD
	 */
  private EventResponse searchComBoCdList4003(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa4003Event event = (EsmCoa4003Event)e;
	   	CommonBC codeUtil = new CommonBCImpl();
      try { 
    	  	//SJH.20150105.ADD
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){
			    String array[][] = { {"locAll",event.getSearchConditionVO().getFCostLocGrpCd(),""},	
			    					};
			    eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
			} else {
		       	String array[][] = { {"CD20015","",""}, 
  			             {"trade","",""},
  						 {"ECC","",""},
  						 {"ORITPSZ","",""},				//PCM.20141222.MOD
  						 {"CD00849","",""},
  					     {"CD00812","",""}				//SJH.20141014.ADD
  						};
			  	;
			  	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);					
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
	 * ESM_COA_4003 <br>
	 * search event handling, Sheet1_FULL<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqRepoCostList(Event e) throws EventException {
		EsmCoa4003Event event = (EsmCoa4003Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			MTCostBC command = new MTCostBCImpl();
            event.getCommonCoaRsVO().setEventName("EsmCoa4003Event");
            CommonCoaRsVO rtnVo = command.searchEqRepoCostList(event.getSearchConditionVO(), e);
            eventResponse.setRsVo(rtnVo.getDbRowset());	
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
    }
	
	/**
	 * ESM_COA_4003 : Save <br>
	 * Save Eq Repo Cost<br>
	 *
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 * @author SJH.20140923.ADD
	 */
    private EventResponse multiEqRepoCostInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa4003Event event = (EsmCoa4003Event)e;
		MTCostBC command = new MTCostBCImpl();
		try{
			begin();
			command.multiEqRepoCostInfo(event.getEqRepoCostVOS(), event.getSearchConditionVO(), account, e);
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
	 * Average Agency Commission Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList4014(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
	   	//EsmCoa4014Event event = (EsmCoa4014Event)e;
	   	//String code = null;
       try {        
    	   //avgAgnAcTpCd avgAgnIoBndCd avgAgnCostCd
	       	String array[][] = {
       				{"avgAgnAcTpCd"		,"",""},     //account
       				{"avgAgnIoBndCd"	,"",""},     //bound
					{"ORITPSZ"			,"",""},     //Type/Size
       				{"avgAgnCostCd"		,"",""},     //cost code
	       			{"trade"			,"",""}     //Trade
	       						};
	       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);	       						
	       	
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
	 * Average Agency Commission 정보를 조회 합니다.<br>
	 * 2017.01.11 Nyk Add
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAvgAgencyCommissionList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa4014Event event = (EsmCoa4014Event)e;
		AvgAgencyCommissionBC command = new AvgAgencyCommissionBCImpl();
		List<AvgAgencyCommissionVO> list = new ArrayList<AvgAgencyCommissionVO>();
		try{
			SearchConditionVO searchConditionVO = (SearchConditionVO)event.getSearchConditionVO();
			
			if("OFC".equals(searchConditionVO.getFSelgroup())){
				list = command.searchAvgAgencyCommissionOfficeList(searchConditionVO);
			}else{
				list = command.searchAvgAgencyCommissionCountryList(searchConditionVO);
			}
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * Office Average Agency Commission 입력,수정,삭제 <br>
	 * 2017.01.11 Nyk Add
	 *
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
    private EventResponse manageAvgAgencyCommissionOffice(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmCoa4014Event event = (EsmCoa4014Event)e;
		AvgAgencyCommissionBC command = new AvgAgencyCommissionBCImpl();
		try{
			command.manageAvgAgencyCommissionOffice(event.getAvgAgencyCommissionVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
    }
	
	/**
	 * Country Average Agency Commission 입력,수정,삭제 <br>
	 * 2017.01.11 Nyk Add
	 *
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
    private EventResponse manageAvgAgencyCommissionCountry(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmCoa4014Event event = (EsmCoa4014Event)e;
		AvgAgencyCommissionBC command = new AvgAgencyCommissionBCImpl();
		try{
			command.manageAvgAgencyCommissionCountry(event.getAvgAgencyCommissionVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
    }


}
