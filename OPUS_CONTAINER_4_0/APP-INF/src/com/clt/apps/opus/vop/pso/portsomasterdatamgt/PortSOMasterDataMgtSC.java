/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PortSOMasterDataMgtSC.java
*@FileTitle : 공통
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-31 Hyung Choon_Roh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.basic.PortSOMasterDataMgtBC;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.basic.PortSOMasterDataMgtBCImpl;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.event.VopPso0001Event;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.event.VopPso0003Event;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.event.VopPso0203Event;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.AuditDataCheckListVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.DefaultCostVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.DefaultVendorVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PortSOMasterDataMgtVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PsoInvOfcYdVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PsoObjListVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.SearchYardsVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.basic.PortTariffMgtBC;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.basic.PortTariffMgtBCImpl;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0002Event;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0004Event;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0007Event;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0036Event;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0037Event;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0040Event;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0205Event;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0206Event;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0208Event;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0209Event;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0210Event;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0211Event;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0212Event;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.AccountAndCostVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.ConditionVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.CondtionOpertionVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.CostCodeVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.CurrencyVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.EffectiveDateListVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.FormulaVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.PortTariffCodeGRPVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.PortTariffListVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.SearchTariffConditionVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffBaseVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffListGRPVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffListWithYdNmVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffValueMgtGRPVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConForVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConditonFormulaDtlVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConditonFormulaVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.VendorVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YardChargeVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YardChargeVersionVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YdChgObjVO;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.basic.PSOCodeFinderBC;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.basic.PSOCodeFinderBCImpl;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.vo.VendorListVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBC;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmVendorVO;
import com.clt.syscommon.common.table.PsoFormulaVO;
import com.clt.syscommon.common.table.PsoYdChgObjListVO;


/**
 * portsomasterdatamgt Business Logic ServiceCommand
 * Handling business transaction about NIS2010-portsomasterdatamgt
 * 
 * @author 
 * @see porttariffmgtDBDAO
 * @since J2EE 1.4
 */

public class PortSOMasterDataMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * portsomasterdatamgt system preceding process for biz scenario<br>
	 * UI_PSO-0205related objects creation<br>
	 */
	public void doStart() {
		try {

			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * portsomasterdatamgt system biz scenario closing<br>
	 * UI_PSO-0205 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("portsomasterdatamgtSC 종료");
	}

	/**
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// Part of using in case SC handles many events
		if (e.getEventName().equalsIgnoreCase("VopPso0001Event")) {
			//In case of PageLoad, get BankInformation of VendorSeq chosen
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchVendorName(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUserDefault(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchYardList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPsoYardList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageUserDefault(e);
			}
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}
		if (e.getEventName().equalsIgnoreCase("VopPso0002Event")) {
			//In case of PageLoad, get BankInformation of VendorSeq chosen
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {			//Yard
				eventResponse = searchYardList2(e , "0002" );
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02) ) {	//SearchVersion
				eventResponse = searchEffectiveDate(e, "0002");
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE) ) {		//Delete	//COMMAND03 -> REMOVE
				eventResponse = deletePortCharge(e, "0002");
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND05) ) {	//In case of changing Port Code (Key-In)
				eventResponse = checkPort(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND06) ) {	//In case of changing Service Provider (Key-In)
				eventResponse = searchVendorList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH )) {		//Retrieve
				eventResponse = searchPortChargeList(e, "0002");
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {//Loading
				eventResponse = searchPortTariffCodeList(e, "0002");
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchOfficeObjectList4(e,"0002" );
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		//Save	
				eventResponse = managePortCharge(e, "0002");
			}
		}
		if (e.getEventName().equalsIgnoreCase("VopPso0003Event")) {
			//In case of PageLoad, get BankInformation of VendorSeq chosen
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAuditDataCheckList(e);
			}
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}
		if (e.getEventName().equalsIgnoreCase("VopPso0004Event")) {
			//In case of PageLoad, get BankInformation of VendorSeq chosen
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchYardList2(e, "0004" );
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND02) ) {	//SearchVersion
					eventResponse = searchEffectiveDate(e, "0004");
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE) ) {		//Delete
				eventResponse = deletePortCharge(e, "0004");
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH )) {		//Retrieve
				eventResponse = searchPortChargeList(e, "0004");
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {	//Loading
				eventResponse = searchPortTariffCodeList(e, "0004");
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchOfficeObjectList4(e,"0004" );
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {			//Save	
				eventResponse = managePortCharge(e, "0004");
			}
		}
		if (e.getEventName().equalsIgnoreCase("VopPso0203Event")) {
			//In case of PageLoad, get BankInformation of VendorSeq chosen
			//if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			eventResponse = searchAgentBankInfo(e);
			//}
			//else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			//}
		}
		if (e.getEventName().equalsIgnoreCase("VopPso0205Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfficeVendor(e);
			}
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}
		if (e.getEventName().equalsIgnoreCase("VopPso0206Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {	//Page Loading
				eventResponse = searchOfficeObjectList1(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchOfficeObjectList2(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		//Save
				eventResponse = manageConditionByPopup(e, "0002");
			}
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}
		if (e.getEventName().equalsIgnoreCase("VopPso0208Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfficeObjectList(e, "VopPso0208Event");
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageOfficeObjectList(e);
			}
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}
		if (e.getEventName().equalsIgnoreCase("VopPso0209Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {			//Retrieve
				eventResponse = searchCondFormulaList(e);	
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {	//Loading
				eventResponse = searchCondFormulaListId(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {	//2015.02.16 ADD 직접 입력된 데이타를 ETC로 내리는 공통 모듈.
				eventResponse = searchCondFormulaInfo(e);
			}
			else{
				log.debug("> >"+e.getFormCommand().getCommand());
				//eventResponse = searchChargeTypeObjectList(e);
				eventResponse = searchObjectListAll(e);
			}
		}		
		if (e.getEventName().equalsIgnoreCase("VopPso0210Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUseIdConditonFormulaDetail(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("VopPso0211Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				VopPso0211Event eve = (VopPso0211Event)e;
				
				String portCd = eve.getPortCd();
				VopPso0212Event event = new VopPso0212Event();
				event.setPortCd(portCd);
				
				eventResponse = searchYardListWithTariff(event);
				
				//2015.04.08 NYK Modify
				/*
				String portCd = eve.getPortCd();
				VopPso0001Event event = new VopPso0001Event();
				event.setYdCd1(portCd);
				eventResponse = searchYardList(event);	//Yard List
				*/
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {	//Using in VOP_PSO_0036
				eventResponse = searchOfficeObjectList4(e, "0211" );
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {// Call Version List  
				eventResponse = searchEffectiveDate2(e, "0211");
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {// call Vendor List. 
				eventResponse = searchVendorByYardAndCost(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("VopPso0212Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH )) {
				eventResponse = searchPortChargeList(e, "0212");
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
//				VopPso0212Event eve = (VopPso0212Event)e;
//				String portCd = eve.getPortCd();
//				VopPso0001Event event = new VopPso0001Event();
//				event.setYdCd1(portCd);
//				eventResponse = searchYardList(event);	//Yard List
				
				eventResponse = searchYardListWithTariff(e);
				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchOfficeObjectList4(e, "0212" );
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {//call Vendor List.
				eventResponse = searchEffectiveDate2(e, "0212");
			}
		}
		
		//[VOP_PSO_0036 Port Tariff Condition]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		//VOP_PSO_0036 Port Tariff Condition
		if (e.getEventName().equalsIgnoreCase("VopPso0036Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH )) {//VOP_PSO_0036_RetrieveBtnClick 
				eventResponse = searchPortChargeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//VOP_PSO_0036_VerClick
				eventResponse = searchDistinctEffectiveDate(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {//VOP_PSO_0036_EffDateClick
				eventResponse = searchYardChargeVersion(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {//Tariff List Retrieve
				eventResponse = searchPortChargeList(e, "0036");
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchAccountAndCostByCondition(e);
			}
			else{ //case of first open , get here
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
				//eventResponse = searchTerminalList(e, "0212");
			}
		}
		//[VOP_PSO_0036 Port Tariff Condition]<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		//[VOP_PSO_0007 Formula N' Condition Creation]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		//VOP_PSO_0007 Formula N' Condition Creation
		if (e.getEventName().equalsIgnoreCase("VopPso0007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH )) {//VOP_PSO_0007_RetrieveBtnClick 
				//Classify either flag chosen is Formula or Condition 
				VopPso0007Event event = (VopPso0007Event) e;
				if(event.getFlag().equals("1"))
					eventResponse = searchFormula(e);
				else if (event.getFlag().equals("2"))
					eventResponse = searchCondition(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { 
				eventResponse = searchOfficeObjectList(e, "VopPso0007Event");
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {//VOP_PSO_0007_DeleteBtnClick 
				VopPso0007Event event = (VopPso0007Event) e;
				if(event.getFlag().equals("1"))
					eventResponse = removeFormula(e);
				else if (event.getFlag().equals("2"))
					eventResponse = removeCondition(e);

			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {//VOP_PSO_0007_SaveBtnClick
				VopPso0007Event event = (VopPso0007Event) e;
				if(event.getFlag().equals("1"))
					eventResponse = manageFormula(e);
				else if (event.getFlag().equals("2"))
					eventResponse = manageCondition(e);
			}
			else{//In case of first open , get here // Handling OnOpen Event 
				eventResponse = searchOfficeObjectList(e, "VopPso0007Event");
			}
		}
		//[VOP_PSO_0007 Formula N' Condition Creation]<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		if (e.getEventName().equalsIgnoreCase("VopPso0037Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01 )) {//VOP_PSO_0037_Open
				eventResponse = searchAccountAndCost(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02 )) {//VOP_PSO_0037_Calendar_In_Sheet
				eventResponse = checkExpDateForTariffMgt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH )) {//VOP_PSO_0037_Retrieve_Main
				eventResponse = searchYardChargeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01 )) {//VOP_PSO_0037_Retrieve_Detail
				eventResponse = searchObjByYdChg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI )) {//VOP_PSO_0037_Save
				eventResponse = manageTariffValue(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("VopPso0040Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH )) {//VOP_PSO_0040 Retrieve
				eventResponse = searchObjBasicAll(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){ //VOP_PSO_0040 OPEN
				eventResponse = searchObjectBasic(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){ //VOP_PSO_0040 Save
				eventResponse = manageObjectList(e);
			}
		
		}
		return eventResponse;
	}
	/**VOP_PSO_0007 : Save
	 * Save Condition Info
	 * @category VOP_PSO_0007_SaveBtnClickCondtion
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCondition(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PortTariffMgtBC command = new PortTariffMgtBCImpl();
		VopPso0007Event event = (VopPso0007Event) e;

		try{
			begin();
			String newId = command.manageCondition(event.getFormulaGRPVO());
			eventResponse.setETCData("NEW_ID", newId); 
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

	/**VOP_PSO_0007 : Save
	 * Save Formula Info
	 * @category VOP_PSO_0007_SaveBtnClickFormula
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageFormula(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PortTariffMgtBC command = new PortTariffMgtBCImpl();
		VopPso0007Event event = (VopPso0007Event) e;

		try{
			begin();
			String newId = command.manageFormula(event.getFormulaGRPVO());
			eventResponse.setETCData("NEW_ID", newId); 
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

	/**VOP_PSO_0007 : Delete
	 * Handle in case of Clicking Delete Button of Formula N' Condition Creation page
	 * @category VOP_PSO_0007_DeleteBtnClickCondition
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeCondition(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PortTariffMgtBC command = new PortTariffMgtBCImpl();
		VopPso0007Event event = (VopPso0007Event) e;

		try{
			begin();
			command.removeCondition(event.getId());
			eventResponse.setUserMessage(new ErrorHandler("PSO99013").getUserMessage());
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

	/**VOP_PSO_0007 : Delete
	 * Handle in case of Clicking Delete Button of Formula N' Condition Creation page
	 * @category VOP_PSO_0007_DeleteBtnClickFormula
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeFormula(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PortTariffMgtBC command = new PortTariffMgtBCImpl();
		VopPso0007Event event = (VopPso0007Event) e;

		try{
			begin();
			command.removeFormula(event.getId());
			eventResponse.setUserMessage(new ErrorHandler("PSO99013").getUserMessage());
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

	/**VOP_PSO_0007 : Retrieve
	 * Retrieve condition Info in case of Clicking Retrieve Button of Formula N' Condition Creation page 
	 * @category VOP_PSO_0007_RetrieveBtnClickCondition
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCondition(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			VopPso0007Event event = (VopPso0007Event) e;

			List<FormulaVO> list = command.searchCondition(event.getId());
			List<FormulaVO> list2 = command.searchConditionSys(event.getId());

			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}

	/**VOP_PSO_0007 : Retrieve
	 * Retrieve Formula Info in case of Clicking Retrieve Button of Formula N' Condition Creation page 
	 * @category VOP_PSO_0007_RetrieveBtnClickFormula
	 * @param Event e
	 * @return EventResponse
	 */
	private EventResponse searchFormula(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			VopPso0007Event event = (VopPso0007Event) e;

			List<FormulaVO> list = command.searchFormula(event.getId());
			List<FormulaVO> list2 = command.searchFormulaSys(event.getId());

			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}

	/**VOP_PSO_0036 : EffDate Click
	 * Retrieve Version of Effective Date neccessary in case of creating Charge Creation(Invoice creation)
	 * @category VOP_PSO_0036_EffDateClick
	 * @param Event e
	 * @return EventResponse
	 */
	private EventResponse searchYardChargeVersion(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			VopPso0036Event event = (VopPso0036Event) e;

			List<YardChargeVersionVO> list = command.searchYardChargeVersion(event.getPortTariffListVO());

			StringBuffer data = new StringBuffer();

			if(list != null && list.size() > 0){
				//addEmptyData(data);

				for (int i = 0; i < list.size(); i++) {
					data.append(list.get(i).getYdChgVerSeq());
					data.append(",");
					data.append(list.get(i).getYdChgNo());
					data.append(",");
					data.append(list.get(i).getRn());
					data.append(",");
					data.append(list.get(i).getUpdUsrId());
					data.append(",");
					data.append(list.get(i).getUpdDt());
					data.append(",");
					data.append(list.get(i).getUpdMnuNo()); //2016.11.22 Add.
					if (i < list.size()-1)
						data.append("|");
				}
			}

			eventResponse.setETCData("lane", data.toString());

			//eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}		
		return eventResponse;
	}

	/**VOP_PSO_0036 : Version onChange
	 * Retrieve Effective Date neccessary in case of creating Charge Creation(Invoice creation)
	 * @category VOP_PSO_0036_VerClick
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchDistinctEffectiveDate(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			VopPso0036Event event = (VopPso0036Event) e;

			List<EffectiveDateListVO> list = command.searchDistinctEffectiveDateList(event.getPortTariffListVO());

			StringBuffer data = new StringBuffer();

			if(list != null && list.size() > 0){
				//addEmptyData(data);

				for (int i = 0; i < list.size(); i++) {
					data.append(list.get(i).getEffDt()+"~"+list.get(i).getExpDt());
					data.append(",");
					data.append(list.get(i).getRn());
					if (i < list.size()-1)
						data.append("|");
				}
			}

			eventResponse.setETCData("lane", data.toString());

			//eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}	
		return eventResponse;
	}

	/**VOP_PSO_0036 : Retrieve
	 * Retrieve Tariff List(Account/Vendor/Update ID/Update Date) by Terminal 
	 * @category VOP_PSO_0036_RetrieveBtnClick 
	 * @param Event e
	 * @return EventResponse
	 */
	private EventResponse searchPortChargeList(Event e) throws EventException{
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			VopPso0036Event event = (VopPso0036Event) e;
			PortTariffListVO vo = event.getPortTariffListVO();

			List<PortTariffListVO> list = command.searchPortTariffList(vo.getYdCd(), vo.getYear());

			eventResponse.setRsVoList(list);
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	/**VOP_PSO_0036 : Retrieve
	 * PSO yard Charge 정보와 비교하여 조건에 따흔 Account Code를 조회한다.
	 * @category VOP_PSO_0036_Account Code
	 * @param Event e
	 * @return EventResponse
	 */
	private EventResponse searchAccountAndCostByCondition(Event e) throws EventException{
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			VopPso0036Event event = (VopPso0036Event) e;
			PortTariffListVO vo = event.getPortTariffListVO();

			List<AccountAndCostVO> list = command.searchAccountAndCostByCondition(vo.getYdCd(), vo.getYear(), vo.getUpdMnuNo());

			eventResponse.setRsVoList(list);
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}

	/**VOP_PSO_0209 : OPEN
	 * Retrieve charge_type and object_list in VOP_PSO_0209
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	/*
	private EventResponse searchChargeTypeObjectList(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		  StringBuffer data = new StringBuffer();

		  GeneralEventResponse eventResponse = new GeneralEventResponse();
		  PortTariffMgtBC command2 = new PortTariffMgtBCImpl();

		  List<PsoObjListVO> ofccdList = null;
		  //ofccdList = command2.searchOfficeObjectList1(account.getOfc_cd(), "" );
		  ofccdList = command2.searchObjectListA();
			
		  data = new StringBuffer();
			  
		  if(ofccdList != null && ofccdList.size() > 0){
			  for (int i = 0; i < ofccdList.size(); i++) {
				data.append(ofccdList.get(i).getPsoObjCd());
				data.append(",");
				//data.append(ofccdList.get(i).getObjListNm());
				data.append(ofccdList.get(i).getPsoObjCdDsp());
				if (i < ofccdList.size()-1)
					data.append("|");
				}
		  }
			  
		  eventResponse.setETCData("objlist", data.toString());
		  return eventResponse;
	}
	*/
		
	/**VOP_PSO_0209 : OPEN
	 * Retrieve object_list in VOP_PSO_0209
	 * @category VOP_PSO_0209_Open
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchObjectListAll(Event e) throws EventException{
		StringBuffer data = new StringBuffer();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			PortTariffMgtBC command = new PortTariffMgtBCImpl();

			List<PsoObjListVO> objList = null;
			objList = command.searchObjectListAll();

			data = new StringBuffer();

			if(objList != null && objList.size() > 0){
				for (int i = 0; i < objList.size(); i++) {
					data.append(objList.get(i).getObjListNo());
					data.append("↔");
					data.append(objList.get(i).getPsoObjCdDsp());
					data.append("↔");
					data.append(objList.get(i).getPsoMeasUtCdDsp());
					data.append("↔");
					data.append(objList.get(i).getPsoObjCd());
					data.append("↔");
					data.append(objList.get(i).getPsoMeasUtCd());
					data.append("↔");
					data.append(objList.get(i).getPsoObjCdDsp() + " - " + objList.get(i).getPsoMeasUtCdDsp());
					if (i < objList.size()-1)
						data.append("↕");
				}
			}

			eventResponse.setETCData("objlist", data.toString());
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	/*
	 * Retrieve Terminal applicable in VOP_PSO_0211 by using ofc_cd
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	/*
	private EventResponse searchTerminalList( Event e,String uid ) throws EventException{
		// PDTO(Data Transfer Object including Parameters)

		PortSOMasterDataMgtBC command = new PortSOMasterDataMgtBCImpl();
		List<SearchYardsVO> cdList = null;
		PortTariffMgtBCImpl command2 = new PortTariffMgtBCImpl();
		List<CostCodeVO> costCodeList = command2.searchCostCodeList(account.getOfc_cd());
		List<PsoObjListVO> ofccdList = null;

		if( uid.equals("0211")){
			VopPso0211Event event = (VopPso0211Event)e;
			cdList = command.searchPsoYardList(account.getOfc_cd(),"");
			ofccdList = command2.searchOfficeObjectList1(account.getOfc_cd(), event.getTypes() );
		} else if( uid.equals("0212")){
			VopPso0212Event event = (VopPso0212Event)e;
			cdList = command.searchPsoYardList(account.getOfc_cd(),"");
			ofccdList = command2.searchOfficeObjectList1(account.getOfc_cd(), event.getTypes() );
		}

		  StringBuffer data = new StringBuffer();
		  
		  if(cdList != null && cdList.size() > 0){
		   //addEmptyData(data);
		   
		   for (int i = 0; i < cdList.size(); i++) {
		    
		    //data.append(cdList.get(i).getCode());
		    data.append(cdList.get(i).getYdCd());
		    data.append(",");
		    //data.append(cdList.get(i).getName());
		    data.append(cdList.get(i).getYdCd());
		    if (i < cdList.size()-1)
		     data.append("|");
		   }
		  }

		  GeneralEventResponse eventResponse = new GeneralEventResponse();
		  eventResponse.setETCData("lane", data.toString());

			data = new StringBuffer();

			if(costCodeList != null && costCodeList.size() > 0){
				for (int i = 0; i < costCodeList.size(); i++) {
					data.append(costCodeList.get(i).getAcctCd());
					data.append(",");
					data.append(costCodeList.get(i).getAcctCd());
					if (i < costCodeList.size() - 1)
						data.append("|");
				}
			}

			eventResponse.setETCData("account", data.toString());
		  

		    data = new StringBuffer();
			  
		    if(ofccdList != null && ofccdList.size() > 0){
		    	for (int i = 0; i < ofccdList.size(); i++) {
				    data.append(ofccdList.get(i).getPsoObjCd());
				    data.append(",");
				    data.append(ofccdList.get(i).getObjListNm());
					if (i < ofccdList.size()-1)
						data.append("|");
				}
			}
	  
	    	eventResponse.setETCData("objlist", data.toString());
			
		return eventResponse;
	}
	*/
	

	
	/**VOP_PSO_0002 : OPEN
	 * Retrieve Object List which office of login user set in VOP_PSO_0002
	 * @category VOP_PSO_0002_Open
	 * @param Event e
	 * @param String uid
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPortTariffCodeList(Event e,String uid ) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<PsoObjListVO> ofccdList = null;
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			//PSOCodeFinderBC comCommand =  new PSOCodeFinderBCImpl();

			if(uid.equals("0002")) {
				VopPso0002Event event = (VopPso0002Event)e;
				ofccdList = command.searchOfficeObjectList1(account.getOfc_cd(), event.getTypes() );
			} else if(uid.equals("0004")) {
				VopPso0004Event event = (VopPso0004Event)e;
				ofccdList = command.searchOfficeObjectList1(account.getOfc_cd(), event.getTypes() );
			}

			StringBuffer data = new StringBuffer();
			StringBuffer dataUOM = new StringBuffer();
			
			String ROWMARK = "|";
			String FIELDMARK = ",";

			if(ofccdList != null && ofccdList.size() > 0){
				for (int i = 0; i < ofccdList.size(); i++) {
					//Object
					data.append(ofccdList.get(i).getPsoObjCd());
					data.append(FIELDMARK);
					data.append(ofccdList.get(i).getPsoObjCdDsp());
					data.append(FIELDMARK);
					data.append(ofccdList.get(i).getPsoMeasUtCd());
					data.append(FIELDMARK);
					data.append(ofccdList.get(i).getPsoMeasUtCdDsp());
					data.append(FIELDMARK);
					data.append(ofccdList.get(i).getObjListNo());

					//UOM
					dataUOM.append(ofccdList.get(i).getPsoObjCd());
					dataUOM.append(FIELDMARK);
					dataUOM.append(ofccdList.get(i).getPsoMeasUtCd());
					dataUOM.append(FIELDMARK);
					dataUOM.append(ofccdList.get(i).getPsoMeasUtCdDsp());

					if (i < ofccdList.size()-1){
						data.append(ROWMARK);
						dataUOM.append(ROWMARK);
					}	
				}
				
				eventResponse.setETCData("objlist", data.toString());
				eventResponse.setETCData("uomlist", dataUOM.toString());
				
				eventResponse.setRsVoList(ofccdList);
			}
			

			List<CostCodeVO> costCodeList = command.searchAccountAndCost(account.getOfc_cd());

			data = new StringBuffer();

			if(costCodeList != null && costCodeList.size() > 0){
				String tmpAcctCd = "";
				for (int i = 0; i < costCodeList.size(); i++) {
					if(!"CN".equals(costCodeList.get(i).getLgsCostSubjCd())){
						if(!tmpAcctCd.equals(costCodeList.get(i).getAcctCd())){
							//data.append(costCodeList.get(i).getLgsCostCd());
							data.append(costCodeList.get(i).getAcctEngNm());
							data.append(FIELDMARK);
							data.append(costCodeList.get(i).getAcctCd());
							data.append(FIELDMARK);
							data.append(costCodeList.get(i).getLgsCostCd());
							//if (i < costCodeList.size() - 1)
							data.append(ROWMARK);
							
							tmpAcctCd = costCodeList.get(i).getAcctCd();
						}
					}
				}
			}
			
			String tmpAccount = data.toString();
			if(!StringUtils.isEmpty(tmpAccount)){
				tmpAccount = tmpAccount.substring(0,tmpAccount.length()-1);
			}
			eventResponse.setETCData("account", tmpAccount);

			data = new StringBuffer();
			if(costCodeList != null && costCodeList.size() > 0){
				for (int i = 0; i < costCodeList.size(); i++) {
					data.append(costCodeList.get(i).getLgsCostCd());
					data.append(FIELDMARK);
					data.append(costCodeList.get(i).getLgsCostFullNm());
					data.append(FIELDMARK);
					data.append(costCodeList.get(i).getAcctCd());
					data.append(FIELDMARK);
					data.append(costCodeList.get(i).getLgsCostSubjCd());
					if (i < costCodeList.size() - 1)
						data.append(ROWMARK);
				}
			}

			eventResponse.setETCData("cost", data.toString());

			List<PsoFormulaVO> formulaList = command.searchFormulaNoForLoading();
			data = new StringBuffer();
			for(int i=0; i<formulaList.size(); i++){
				data.append(formulaList.get(i).getFomlNo());
				data.append("|@DELIM|");
				data.append(formulaList.get(i).getFomlDesc());
				if (i < formulaList.size() - 1){
					data.append("|@LF|");
				}
			}
			eventResponse.setETCData("formula4Loading", data.toString());

			String localCurrency = "";
			List<CurrencyVO> currencyList = command.searchCurrencyList(account.getOfc_cd());
			data = new StringBuffer();
			if(currencyList != null && currencyList.size() > 0){
				for (int i = 0; i < currencyList.size(); i++) {
					data.append(currencyList.get(i).getCurrCd());
					data.append(FIELDMARK);
					data.append(currencyList.get(i).getCurrNm());
					if (i < currencyList.size() - 1){
						data.append(ROWMARK);
					}

					if("Y".equals(currencyList.get(i).getIsLocalCurr())){
						localCurrency = currencyList.get(i).getCurrCd();
					}
				}
			}
			eventResponse.setETCData("currency", data.toString());		
			/*
			List<CostListVO> listAcct = comCommand.searchAccountList();
			data = new StringBuffer();
			for(int i=0; i<listAcct.size(); i++){
				//if("511911".equals(listAcct.get(i).getAcctCd())){
				if("CN".equals(listAcct.get(i).getLgsCostSubjCd())){
					data.append(listAcct.get(i).getAcctEngNm());
					data.append(FILEDMARK);
					data.append(listAcct.get(i).getAcctCd());
					data.append(ROWMARK);
					//eventResponse.setETCData("accountForCanal", listAcct.get(i).getAcctEngNm() + "," + listAcct.get(i).getAcctCd());	//511911계정명
					//break;
				}
			}*/
			
			data = new StringBuffer();
			if(costCodeList != null && costCodeList.size() > 0){
				String tmpAcctCd = "";
				for (int i = 0; i < costCodeList.size(); i++) {
					if("CN".equals(costCodeList.get(i).getLgsCostSubjCd())){
						if(!tmpAcctCd.equals(costCodeList.get(i).getAcctCd())){
							//data.append(costCodeList.get(i).getLgsCostCd());
							data.append(costCodeList.get(i).getAcctEngNm());
							data.append(FIELDMARK);
							data.append(costCodeList.get(i).getAcctCd());
							data.append(FIELDMARK);
							data.append(costCodeList.get(i).getLgsCostCd());
							//if (i < costCodeList.size() - 1)
							data.append(ROWMARK);
							
							tmpAcctCd = costCodeList.get(i).getAcctCd();
						}
					}
				}
			}
			
			String tmpAccountForCanal = data.toString();
			if(!StringUtils.isEmpty(tmpAccountForCanal)){
				tmpAccountForCanal = tmpAccountForCanal.substring(0,tmpAccountForCanal.length()-1);
			}
			log.debug("\n############## tmpAccountForCanal ["+tmpAccountForCanal+"]");
			eventResponse.setETCData("accountForCanal", tmpAccountForCanal);	//511911계정명
			
			//For 0004.do
			List<PsoObjListVO> listObjByTpCd = command.searchPsoObjListByPsoObjListTpCd("M");
			data = new StringBuffer();
			if(listObjByTpCd != null && listObjByTpCd.size() > 0){
				for (int i = 0; i < listObjByTpCd.size(); i++) {
					//Object
					data.append(listObjByTpCd.get(i).getPsoObjCd());
					data.append(FIELDMARK);
					data.append(listObjByTpCd.get(i).getPsoObjCdDsp());
					data.append(FIELDMARK);
					data.append(listObjByTpCd.get(i).getPsoMeasUtCd());
					data.append(FIELDMARK);
					data.append(listObjByTpCd.get(i).getPsoMeasUtCdDsp());
					data.append(FIELDMARK);
					data.append(listObjByTpCd.get(i).getObjListNo());

					if (i < listObjByTpCd.size()-1){
						data.append(ROWMARK);
					}
				}
			}
			eventResponse.setETCData("objListByTpCd", data.toString());

			eventResponse.setETCData("localCurrency", localCurrency);	//Currency of My Office		

			
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}	
	
	
	
	/**VOP_PSO_0208 : OPEN
	 * Retrieve Object List which office of login user set in VOP_PSO_0208
	 * @category VOP_PSO_0208_Open
	 * @param Event e
	 * @param String uid 
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchOfficeObjectList4(Event e,String uid ) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<PsoObjListVO> cdList = null;

			if( uid.equals("0211")){
				VopPso0211Event event = (VopPso0211Event)e;
				PortTariffMgtBC command = new PortTariffMgtBCImpl();
				cdList = command.searchOfficeObjectList2(account.getOfc_cd() ,event.getPsoObjCd(), event.getTypes());
			} else if( uid.equals("0212")){
				VopPso0212Event event = (VopPso0212Event)e;
				PortTariffMgtBC command = new PortTariffMgtBCImpl();
				cdList = command.searchOfficeObjectList2(account.getOfc_cd() ,event.getPsoObjCd(), event.getTypes());
			} else if( uid.equals("0004")){
				VopPso0004Event event = (VopPso0004Event)e;
				PortTariffMgtBC command = new PortTariffMgtBCImpl();
				cdList = command.searchOfficeObjectList2(account.getOfc_cd() ,event.getPsoObjCd(), event.getTypes());
			} else {
				VopPso0002Event event = (VopPso0002Event)e;
				PortTariffMgtBC command = new PortTariffMgtBCImpl();
				cdList = command.searchOfficeObjectList2(account.getOfc_cd() ,event.getPsoObjCd(), event.getTypes());
			}

			StringBuffer data = new StringBuffer();

			if(cdList != null && cdList.size() > 0){
				//addEmptyData(data);

				for (int i = 0; i < cdList.size(); i++) {

					//data.append(cdList.get(i).getCode());
					data.append(cdList.get(i).getObjListNo());
					data.append(",");
					//data.append(cdList.get(i).getName());
					data.append(cdList.get(i).getPsoMeasUtCd());
					if (i < cdList.size()-1)
						data.append("|");
				}
			}

			eventResponse.setETCData("objlist2", data.toString());
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}		


	/**VOP_PSO_0206 : OPEN
	 * Retrieve Object List which office of login user set in VOP_PSO_0206
	 * @category VOP_PSO_0206_Open
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchOfficeObjectList1(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0206Event event = (VopPso0206Event)e;
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			List<CondtionOpertionVO> andorcdList = command.searchConditonAndOrOperator();
			List<CondtionOpertionVO> compcdList = command.searchConditionCompairingOperator();
			List<PsoObjListVO> ofccdList = command.searchOfficeObjectList1(account.getOfc_cd(), event.getTypes() );

			List<SearchTariffConditionVO> searchTariffConditionVOList = command.searchTariffCondition(event.getCondNo());

			StringBuffer data = new StringBuffer();

			if(andorcdList != null && andorcdList.size() > 0){
				//addEmptyData(data);

				for (int i = 0; i < andorcdList.size(); i++) {

					//data.append(cdList.get(i).getCode());
					data.append(andorcdList.get(i).getIntgCdValCtnt());
					data.append(",");
					//data.append(cdList.get(i).getName());
					data.append(andorcdList.get(i).getIntgCdValDesc());
					if (i < andorcdList.size()-1)
						data.append("|");
				}
			}
			eventResponse.setETCData("operator", data.toString()); 

			data = new StringBuffer();

			if(compcdList != null && compcdList.size() > 0){
				for (int i = 0; i < compcdList.size(); i++) {

					//data.append(cdList.get(i).getCode());
					data.append(compcdList.get(i).getIntgCdValCtnt());
					data.append(",");
					//data.append(cdList.get(i).getName());
					data.append(compcdList.get(i).getIntgCdValDesc());
					if (i < compcdList.size()-1)
						data.append("|");
				}
			}

			eventResponse.setETCData("complist", data.toString());

			data = new StringBuffer();
			/*
		   SELECT DISTINCT PSO_OBJ_CD               PSO_OBJ_CD
               ,C1.INTG_CD_VAL_DP_DESC   PSO_OBJ_CD_DSP
               ,PSO_MEAS_UT_CD           PSO_MEAS_UT_CD
               ,C2.INTG_CD_VAL_DP_DESC   PSO_MEAS_UT_CD_DSP 
			 */
			if(ofccdList != null && ofccdList.size() > 0){
				//addEmptyData(data);

				for (int i = 0; i < ofccdList.size(); i++) {
					data.append(ofccdList.get(i).getPsoObjCd());
					data.append(",");
					data.append(ofccdList.get(i).getPsoObjCdDsp());
					data.append(",");
					data.append(ofccdList.get(i).getPsoMeasUtCd());
					data.append(",");
					data.append(ofccdList.get(i).getPsoMeasUtCdDsp());
					data.append(",");
					data.append(ofccdList.get(i).getObjListNo());
					if (i < ofccdList.size()-1)
						data.append("|");
				}
			}

			eventResponse.setETCData("objlist", data.toString());

			eventResponse.setRsVoList(searchTariffConditionVOList);
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}	
		return eventResponse;
	}		
	

	
	/**VOP_PSO_0208 : OPEN
	 * Retrieve Object List which office of login user set in VOP_PSO_0208
	 * @category VOP_PSO_0208_Open
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchOfficeObjectList2(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0206Event event = (VopPso0206Event)e;
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			List<PsoObjListVO> cdList = command.searchOfficeObjectList2(account.getOfc_cd() ,event.getPsoObjCd(), event.getTypes());

			StringBuffer data = new StringBuffer();

			if(cdList != null && cdList.size() > 0){
				//addEmptyData(data);

				for (int i = 0; i < cdList.size(); i++) {

					data.append(cdList.get(i).getObjListNo());
					data.append(",");
					data.append(cdList.get(i).getPsoMeasUtCd());

					if (i < cdList.size()-1)
						data.append("|");
				}
			}

			eventResponse.setETCData("objlist2", data.toString());
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}		

	
	
	/**VOP_PSO_0001 : Sheet OnChange
	 * Set BankInfo of vendor applicable by using vendor_seq in VOP_PSO_0001
	 * @category VOP_PSO_0001_SheetOnChange
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVendorName(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0001Event event = (VopPso0001Event)e;
			PSOCodeFinderBC command = new PSOCodeFinderBCImpl();
			String strVendorName = command.searchVendorName(event.getVndrSeq());//,account);
			eventResponse.setETCData("vendor", strVendorName);
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}	
	
	/**VOP_PSO_0001 : Sheet1 OnPopupClick
	 * Retrieve yard applicable by using ofc_cd in VOP_PSO_0001
	 * @category VOP_PSO_0001_Sheet1_OnPopupClick
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchYardList(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0001Event event = (VopPso0001Event)e;
			PortSOMasterDataMgtBC command = new PortSOMasterDataMgtBCImpl();
			List<SearchYardsVO> cdList = command.searchYardList(event.getOfcCd(),event.getYdCd1());

			StringBuffer data = new StringBuffer();

			if(cdList != null && cdList.size() > 0){
				//addEmptyData(data);

				for (int i = 0; i < cdList.size(); i++) {

					//data.append(cdList.get(i).getCode());
					data.append(cdList.get(i).getYdCd().substring(5));
					data.append(",");
					//data.append(cdList.get(i).getName());
					data.append(cdList.get(i).getYdNm());
					if (i < cdList.size()-1)
						data.append("|");
				}
			}

			eventResponse.setETCData("lane", data.toString());
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}


	/**VOP_PSO_0002 : Port OnChange
	 * Retrieve yard applicable by using ofc_cd in VOP_PSO_0002
	 * @category VOP_PSO_0002_PortOnChange
	 * @param Event e
	 * @param String uid
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchYardList2( Event e , String uid ) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<SearchYardsVO> cdList = null;
			PortSOMasterDataMgtBC command = null;

			if( uid.equals("0002")) {
				command = new PortSOMasterDataMgtBCImpl();
				VopPso0002Event event = (VopPso0002Event)e;
				cdList = command.searchYardList( account.getOfc_cd() ,event.getYdCd1());
			} else if( uid.equals("0004")) {
				command = new PortSOMasterDataMgtBCImpl();
				VopPso0004Event event = (VopPso0004Event)e;
				cdList = command.searchYardList( account.getOfc_cd() ,event.getYdCd1());
			}

			StringBuffer data = new StringBuffer();

			if(cdList != null && cdList.size() > 0){
				//addEmptyData(data);

				for (int i = 0; i < cdList.size(); i++) {

					//data.append(cdList.get(i).getCode());
					data.append(cdList.get(i).getYdCd().substring(5));
					data.append(",");
					//data.append(cdList.get(i).getName());
					data.append(cdList.get(i).getYdNm());
					if (i < cdList.size()-1)
						data.append("|");
				}
			}

			eventResponse.setETCData("lane", data.toString());
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}		
		return eventResponse;
	}
	
	
	
	/**VOP_PSO_0001 : Retrieve
	 * Retrieve yard applicable by using ofc_cd in VOP_PSO_0001
	 * @category VOP_PSO_0001_Retrieve
	 * @param  Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPsoYardList(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0001Event event = (VopPso0001Event)e;
			PortSOMasterDataMgtBC command = new PortSOMasterDataMgtBCImpl();
			List<SearchYardsVO> cdList = command.searchPsoYardList(event.getOfcCd(),event.getYdCd1());

			StringBuffer data = new StringBuffer();

			if(cdList != null && cdList.size() > 0){
				//addEmptyData(data);

				for (int i = 0; i < cdList.size(); i++) {

					//data.append(cdList.get(i).getCode());
					data.append(cdList.get(i).getYdCd().substring(5));
					data.append(",");
					//data.append(cdList.get(i).getName());
					data.append(cdList.get(i).getYdCd().substring(5));
					if (i < cdList.size()-1)
						data.append("|");
				}
			}

			eventResponse.setETCData("lane", data.toString());
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}


	/**
	 * VOP_PSO_0002 : Retrieve
	 * Retrieve tariff list Info.
	 * @category VOP_PSO_0002_Retrieve
	 * @param Event e
	 * @param String uid
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPortChargeList(Event e, String uid ) throws EventException{

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<TariffBaseVO> baseTariff 	 = null;
			List<ConditionVO>  baseCondition = null;

			List<TariffBaseVO> baseList 	 = new ArrayList<TariffBaseVO>();
			List<TariffBaseVO> surchargeList = new ArrayList<TariffBaseVO>();
			List<TariffBaseVO> discountList  = new ArrayList<TariffBaseVO>();

			List<TariffBaseVO> bmBaseList 	 = new ArrayList<TariffBaseVO>();
			List<YdChgObjVO>   bmRegValList	 = new ArrayList<YdChgObjVO>();	

			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			PortTariffCodeGRPVO portTariffCodeGRPVO = null;

			String ydChgNo = "";
			String ydChgVerSeq = "";

			if( uid.equals("0002")) {
				VopPso0002Event event = (VopPso0002Event)e;
				portTariffCodeGRPVO = event.getPortTariffCodeGRPVO();
				portTariffCodeGRPVO.setOfcCd(account.getOfc_cd());
				portTariffCodeGRPVO.setType("1");
				portTariffCodeGRPVO.setUid(uid);
				baseTariff 	 = command.searchBaseTariff( portTariffCodeGRPVO );

				for(int i=0; i<baseTariff.size(); i++){
					baseTariff.get(i).setUpdMnuNoCondText(baseTariff.get(i).getUpdMnuNoCond()==""?"0":baseTariff.get(i).getUpdMnuNoCond());//sheet image의 text를 가지지 못하므로 따로 copy
					if("B".equals(baseTariff.get(i).getPsoChgTpCd())){
						baseList.add(baseTariff.get(i));
					} else if("S".equals(baseTariff.get(i).getPsoChgTpCd())){
						surchargeList.add(baseTariff.get(i));
					} else if("D".equals(baseTariff.get(i).getPsoChgTpCd())){
						discountList.add(baseTariff.get(i));
					}
				}

				eventResponse.setRsVoList( baseList );
				eventResponse.setRsVoList( surchargeList );
				eventResponse.setRsVoList( discountList );

			} else if( uid.equals("0004")) {

				VopPso0004Event event = (VopPso0004Event)e;
				portTariffCodeGRPVO = event.getPortTariffCodeGRPVO();
				portTariffCodeGRPVO.setOfcCd(account.getOfc_cd());
				portTariffCodeGRPVO.setType("1");
				portTariffCodeGRPVO.setUid(uid);
				baseTariff 	 = command.searchBaseTariff( portTariffCodeGRPVO );

				if(baseTariff.size() > 0){
					//Setting yd_chg_no, yd_chg_ver_seq to retrieve Regular Value 
					ydChgNo = baseTariff.get(0).getYdChgNo();
					ydChgVerSeq = baseTariff.get(0).getYdChgVerSeq();
				}

				for(int i=0; i<baseTariff.size(); i++){
					baseTariff.get(i).setUpdMnuNoCondText(baseTariff.get(i).getUpdMnuNoCond()==""?"0":baseTariff.get(i).getUpdMnuNoCond());//sheet image의 text를 가지지 못하므로 따로 copy
					if("B".equals(baseTariff.get(i).getPsoChgTpCd())){
						baseList.add(baseTariff.get(i));

						//Base Master
						if("B".equals(baseTariff.get(i).getPsoChgTpCd()) && "1".equals(baseTariff.get(i).getBm())){
							TariffBaseVO bmBaseVO = new TariffBaseVO();
							bmBaseVO.setDefault2(baseTariff.get(i).getDefault2());
							bmBaseVO.setFormulaNo(baseTariff.get(i).getFormulaNo());
							bmBaseVO.setFomlDesc(baseTariff.get(i).getFomlDesc());
							bmBaseVO.setFomlSysDesc(baseTariff.get(i).getFomlSysDesc());
							bmBaseVO.setCondition(baseTariff.get(i).getBmCondition());
							bmBaseVO.setCondDesc(baseTariff.get(i).getBmCondDesc());
							bmBaseVO.setCplsFlg(baseTariff.get(i).getCplsFlg());
							bmBaseVO.setUk(baseTariff.get(i).getUk());
							bmBaseVO.setUpdMnuNoCond(baseTariff.get(i).getUpdMnuNoCond());
							bmBaseVO.setUpdMnuNoCondText(baseTariff.get(i).getUpdMnuNoCondText());
							bmBaseList.add(bmBaseVO);
						}

					} else if("S".equals(baseTariff.get(i).getPsoChgTpCd())){
						surchargeList.add(baseTariff.get(i));
					} else if("D".equals(baseTariff.get(i).getPsoChgTpCd())){
						discountList.add(baseTariff.get(i));
					}

				}

				//Regular Value
				PsoYdChgObjListVO psoYdChgObjListVO = new PsoYdChgObjListVO();
				psoYdChgObjListVO.setYdChgNo(ydChgNo);
				psoYdChgObjListVO.setYdChgVerSeq(ydChgVerSeq);
				bmRegValList = command.searchPsoYdChgObjListByPK(psoYdChgObjListVO);

				eventResponse.setRsVoList( bmBaseList );
				eventResponse.setRsVoList( baseList );
				eventResponse.setRsVoList( bmRegValList );
				eventResponse.setRsVoList( surchargeList );
				eventResponse.setRsVoList( discountList );

				//		} else if( uid.equals("0212")) {
				//			VopPso0212Event event = (VopPso0212Event)e;
				//			portTariffCodeGRPVO = event.getPortTariffCodeGRPVO();
				//			portTariffCodeGRPVO.setOfcCd(account.getOfc_cd());
				//			portTariffCodeGRPVO.setType("A");
				//			baseTariff 	 = command.searchBaseTariff( portTariffCodeGRPVO );
				//			eventResponse.setRsVoList( baseTariff );
				//
				//			portTariffCodeGRPVO = event.getPortTariffCodeGRPVO();
				//			portTariffCodeGRPVO.setOfcCd(account.getOfc_cd());
				//			portTariffCodeGRPVO.setType("2");
				//			baseTariff 	 = command.searchBaseTariff( portTariffCodeGRPVO );
				//			eventResponse.setRsVoList( baseTariff );
				//
				//			baseCondition = command.searchBaseCondition( portTariffCodeGRPVO );
				//			eventResponse.setRsVoList( null );
				//			eventResponse.setRsVoList( baseCondition );

			} else if( uid.equals("0036")) {//VOP_PSO_0036_PortTariffCondition
				VopPso0036Event event = (VopPso0036Event)e;
				portTariffCodeGRPVO = event.getPortTariffCodeGRPVO();
				portTariffCodeGRPVO.setOfcCd(account.getOfc_cd());
				portTariffCodeGRPVO.setType("1");
				baseTariff 	 = command.searchBaseTariff( portTariffCodeGRPVO );
				baseCondition = command.searchBaseCondition( portTariffCodeGRPVO );

				eventResponse.setRsVoList( baseTariff );
				eventResponse.setRsVoList( null );
				eventResponse.setRsVoList( null );
				eventResponse.setRsVoList( baseCondition );
			}
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0002, VOP_PSO_0004 : Delete
	 * Delete tariff list Info
	 * @category VOP_PSO_0002_Delete 
	 * @param  Event e
	 * @param  String uid
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse deletePortCharge(Event e,String uid ) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			begin();
		
			PortTariffCodeGRPVO portTariffCodeGRPVO = null;
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			
			if( uid.equals("0002")) {
				VopPso0002Event event = (VopPso0002Event)e;
				portTariffCodeGRPVO = event.getPortTariffCodeGRPVO();
				portTariffCodeGRPVO.setOfcCd(account.getOfc_cd());
				
				command.deletePortChargeSimple( portTariffCodeGRPVO );
				eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
				
			} else if( uid.equals("0004")) {
				VopPso0004Event event = (VopPso0004Event)e;
				portTariffCodeGRPVO = event.getPortTariffCodeGRPVO();
				portTariffCodeGRPVO.setOfcCd(account.getOfc_cd());
				
				command.deletePortChargeComplex( portTariffCodeGRPVO );
				eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
			}
		
		
			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PSO90012", new String[]{"Tariff Creation"}).getMessage());
		}
		return eventResponse;
	}


	/**
	 * VOP_PSO_0209 : Retrieve
	 * Retrieve formula or condition Info
	 * @category VOP_PSO_0209_Retrieve
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCondFormulaList(Event e ) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<UseStatusConditonFormulaVO>  condition = null;
			List<UseStatusConditonFormulaVO>  formula   = null;

			VopPso0209Event event = (VopPso0209Event)e;
			PortTariffMgtBC command = new PortTariffMgtBCImpl();

			UseStatusConForVO useStatusConForVO = event.getUseStatusConForVO();

			if( useStatusConForVO.getFormcond().equals("1")) {
				formula      = command.searchUseStatusFormula( useStatusConForVO );
				eventResponse.setRsVoList( formula );
			} else {
				condition 	 = command.searchUseStatusConditon( useStatusConForVO );
				eventResponse.setRsVoList( condition );
			}

		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}


	/**
	 * VOP_PSO_0209 : ETC Retrieve ( 공통 호출)
	 * Retrieve formula or condition Info
	 * @category VOP_PSO_0209_Retrieve
	 * @param Event e
	 * @return EventResponse ETC
	 * @throws EventException
	 */
	private EventResponse searchCondFormulaInfo(Event e ) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<UseStatusConditonFormulaVO>  conditionList = null;
			List<UseStatusConditonFormulaVO>  formulaList   = null;
			UseStatusConditonFormulaVO vo = null;

			VopPso0209Event event = (VopPso0209Event)e;
			PortTariffMgtBC command = new PortTariffMgtBCImpl();

			UseStatusConForVO useStatusConForVO = event.getUseStatusConForVO();

			StringBuffer data = new StringBuffer();
			if("1".equals(useStatusConForVO.getFormcond())) {//Formula
				formulaList      = command.searchUseStatusFormula( useStatusConForVO );
				if(null != formulaList && formulaList.size() > 0){
					vo = (UseStatusConditonFormulaVO)formulaList.get(0);
				}
				//eventResponse.setRsVoList( formula );
			} else { //Condition
				conditionList 	 = command.searchUseStatusConditon( useStatusConForVO );
				if(null != conditionList && conditionList.size() > 0){
					vo = (UseStatusConditonFormulaVO)conditionList.get(0);
				}
				//eventResponse.setRsVoList( condition );
			}
			if(null != vo){
				data.append(vo.getIbflag());
				data.append("|");
				data.append(vo.getId());
				data.append("|");
				data.append(vo.getDescript());
				data.append("|");
				data.append(vo.getLink());
				data.append("|");
				data.append(vo.getCreDate());
				data.append("|");
				data.append(vo.getCreUsr());
				data.append("|");
				data.append(vo.getUpdMnuNoFoml());
				data.append("|");
				data.append(vo.getUpdMnuNoCond());
				data.append("|");
				data.append(vo.getFomlSysDesc());
			}
			
			eventResponse.setETCData("ROW_DATA", data.toString());
			
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0209 : OPEN
	 * Retrieve id of formula or condition
	 * @category VOP_PSO_0209_Open
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCondFormulaListId(Event e ) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{		
			List<UseStatusConditonFormulaVO>  formulaCondition   = null;

			VopPso0209Event event = (VopPso0209Event)e;
			PortTariffMgtBC command = new PortTariffMgtBCImpl();

			UseStatusConForVO useStatusConForVO = event.getUseStatusConForVO();

			if( useStatusConForVO.getFormcond().equals("1")) {
				formulaCondition      = command.searchUseStatusFormula( useStatusConForVO );
			} else {
				formulaCondition 	 = command.searchUseStatusConditon( useStatusConForVO );
			}

			StringBuffer data = new StringBuffer();

			if(formulaCondition != null && formulaCondition.size() > 0){
				//addEmptyData(data);

				for (int i = 0; i < formulaCondition.size(); i++) {

					//data.append(cdList.get(i).getCode());
					data.append( formulaCondition.get(i).getId()  );
					data.append(",");	
					//data.append(cdList.get(i).getName());
					data.append( formulaCondition.get(i).getId());
					if (i < formulaCondition.size()-1)
						data.append("|");
				}
			}

			eventResponse.setETCData("id", data.toString());				
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}	
		return eventResponse;
	}	

	
	/**
	 * VOP_PSO_0211 : Retrieve
	 * Retrieve tariff list Info
	 * @category VOP_PSO_0211_Retrieve
	 * @param Event e
	 * @param String uid
	 * @return EventResponse
	 * @throws EventException
	 */
	/*
	private EventResponse searchPortChargeList2(Event e, String uid ) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		List<TariffBaseVO> baseTariff 	 = null;
		List<ConditionVO>  baseCondition = null;
		PortTariffCodeGRPVO portTariffCodeGRPVO = null;

		PortTariffMgtBC command = new PortTariffMgtBCImpl();
		
		if( uid.equals("0211")) {
			VopPso0211Event event = (VopPso0211Event)e;
			portTariffCodeGRPVO = event.getPortTariffCodeGRPVO();
			portTariffCodeGRPVO.setOfcCd(account.getOfc_cd());
		} else if( uid.equals("0212")) {
			VopPso0212Event event = (VopPso0212Event)e;
			portTariffCodeGRPVO = event.getPortTariffCodeGRPVO();
			portTariffCodeGRPVO.setOfcCd(account.getOfc_cd());
		}
		
		
		baseTariff 	 = command.searchBaseTariff( portTariffCodeGRPVO );
		baseCondition = command.searchBaseCondition( portTariffCodeGRPVO );
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList( baseTariff );
		eventResponse.setRsVoList( null );
		eventResponse.setRsVoList( null );
		eventResponse.setRsVoList( baseCondition );
		
		return eventResponse;
	}
	*/
	
	/**
	 * VOP_PSO_0002 : onChange (Port/Account/Cost/Service Provider) 
	 * @category VOP_PSO_0002_SearchConditionsOnChange
	 * Retrieve tariff version Info
	 * @param Event e
	 * @param String uid
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchEffectiveDate(Event e,String uid ) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<TariffListGRPVO> tariff = null;
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			String portCd = "";
			String localCurrency = "";


			if( uid.equals("0002")) {
				VopPso0002Event event = (VopPso0002Event)e;
				tariff	 = command.searchEffectiveDateList(event.getPortTariffCodeGRPVO(), "0002");
				portCd = event.getPortTariffCodeGRPVO().getPortCd();
			} else if(uid.equals("0004")) {
				VopPso0004Event event = (VopPso0004Event)e;
				tariff	 = command.searchEffectiveDateList(event.getPortTariffCodeGRPVO(), "0004");
				portCd = event.getPortTariffCodeGRPVO().getPortCd();
			}

			localCurrency = command.searchLocalCurrencyByPortCd(portCd);

			StringBuffer data = new StringBuffer();

			if(tariff != null && tariff.size() > 0){

				for (int i = 0; i < tariff.size(); i++) {
					/* 2016.11.18 Mod.
					if(uid.equals("0002") && "2".equals(tariff.get(i).getUpdMnuNo())){
						eventResponse.setETCData("errorMessage", "ALREADY INPUT");	//ALREADY INPUT in complicate Tariff page ->  Handling Message in page			
						//eventResponse.setETCData("errorMessage", new ErrorHandler("PSO99003", new String[]{"Complex Tariff"}).getMessage());		
						return eventResponse;
					}

					if(uid.equals("0004") && "1".equals(tariff.get(i).getUpdMnuNo())){
						eventResponse.setETCData("errorMessage", "ALREADY INPUT");	//ALREADY INPUT in simple Tariff page -> Handling Message in page		
						//eventResponse.setETCData("errorMessage", new ErrorHandler("PSO99003", new String[]{"Simple Tariff"}).getMessage());	
						return eventResponse;
					}*/

					data.append( tariff.get(i).getYdChgNo() );
					data.append(",");
					data.append( tariff.get(i).getVer() );
					data.append(",");
					data.append( tariff.get(i).getEffDt()+"~"+tariff.get(i).getExpDt());
					data.append(",");
					data.append( tariff.get(i).getCurrCd() );
					data.append(",");
					data.append( tariff.get(i).getCplsFlg() );
					data.append(",");
					data.append( tariff.get(i).getIssCtyCd() );
					data.append(",");
					data.append( tariff.get(i).getOrgVndrNm() );
					if (i < tariff.size()-1)
						data.append("|");
				}
			}

			eventResponse.setETCData("ver", data.toString());		
			eventResponse.setETCData("localCurrency", localCurrency);		
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;

	}
	

	/**VOP_PSO_0002 : onChange (Port/Account/Cost/Service Provider) 
	 * Retrieve version Info of TariffList 
	 * @category VOP_PSO_0002_SearchConditionsOnChange
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchEffectiveDate2(Event e, String uid) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<TariffListGRPVO> tariff = null;
			PortTariffMgtBC command = new PortTariffMgtBCImpl();

			if( uid.equals("")){
				VopPso0211Event event = (VopPso0211Event)e;
				tariff	 = command.searchEffectiveDateList2( event.getCombo1() , event.getVndrSeq() ,event.getAcctCd() , account.getOfc_cd() );
			} else if( uid.equals("0212")){
				VopPso0212Event event = (VopPso0212Event)e;
				tariff	 = command.searchEffectiveDateList2( event.getCombo1() , event.getVndrSeq() ,event.getAcctCd() , account.getOfc_cd() );
			}


			StringBuffer data = new StringBuffer();

			if(tariff != null && tariff.size() > 0){
				//addEmptyData(data);

				for (int i = 0; i < tariff.size(); i++) {

					//data.append(cdList.get(i).getCode());
					data.append( tariff.get(i).getVer() );
					data.append(",");
					//data.append(cdList.get(i).getName());
					data.append( tariff.get(i).getEffDt()+"~"+tariff.get(i).getExpDt());
					if (i < tariff.size()-1)
						data.append("|");
				}
			}

			eventResponse.setETCData("ver", data.toString());	
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	
	
	/**
	 * VOP_PSO_0001 : Save<br>
	 * Save Yard/Vendor/Cost<br><br>
	 * @category VOP_PSO_0001_SaveClick
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 */
	private EventResponse manageUserDefault(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0001Event event = (VopPso0001Event)e;
		PortSOMasterDataMgtBC command = new PortSOMasterDataMgtBCImpl();
		try{
			begin();
			PortSOMasterDataMgtVO portSOMasterDataMgtVO = new PortSOMasterDataMgtVO();
			portSOMasterDataMgtVO.setPsoInvOfcYdVO(event.getPsoInvOfcYdVO());
			portSOMasterDataMgtVO.setDefaultCostVO(event.getDefaultCostVO());
			portSOMasterDataMgtVO.setDefaultVendorVO(event.getDefaultVendorVO());
			portSOMasterDataMgtVO.setAccount(account);
			
			command.manageUserDefault( portSOMasterDataMgtVO, (String)event.getChargeType() );
			eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	
	/**
	 * VOP_PSO_0002 : Save<br>
	 * Save Tariff List<br>
	 * @category VOP_PSO_0002_SaveClick
	 * @param Event e
	 * @param String uid
	 * @return EventResponse
	 * @throws EventException 
	 */
	private EventResponse managePortCharge( Event e,String uid ) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PortTariffMgtBC command = new PortTariffMgtBCImpl();
		try{
			begin();

			if( uid.equals("0002")) {
				
				VopPso0002Event event = (VopPso0002Event)e;
				PortTariffCodeGRPVO portTariffCodeGRPVO = event.getPortTariffCodeGRPVO();

				portTariffCodeGRPVO.setTariffBaseVOs(event.getTariffBaseVOs());	
				portTariffCodeGRPVO.setTariffSurchargeVOs(event.getTariffSurchargeVOs());
				portTariffCodeGRPVO.setTariffDiscountVOs(event.getTariffDiscountVOs());
				portTariffCodeGRPVO.setOfcCd(account.getOfc_cd());
				portTariffCodeGRPVO.setCreUsrId(account.getUsr_id());
				
				command.managePortChargeSimple( portTariffCodeGRPVO );
				eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
				
			} else if( uid.equals("0004")) {
				
				VopPso0004Event event = (VopPso0004Event)e;
				PortTariffCodeGRPVO portTariffCodeGRPVO = event.getPortTariffCodeGRPVO();

				portTariffCodeGRPVO.setTariffBaseFomlCondVOs(event.getTariffBaseFomlCondVOs());
				portTariffCodeGRPVO.setTariffBaseRegValVOs(event.getTariffBaseRegValVOs());
				portTariffCodeGRPVO.setTariffBaseVOs(event.getTariffBaseVOs());	
				portTariffCodeGRPVO.setTariffSurchargeVOs(event.getTariffSurchargeVOs());
				portTariffCodeGRPVO.setTariffDiscountVOs(event.getTariffDiscountVOs());
				portTariffCodeGRPVO.setOfcCd(account.getOfc_cd());
				portTariffCodeGRPVO.setCreUsrId(account.getUsr_id());
				
				command.managePortChargeComplex( portTariffCodeGRPVO );
				eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
			}	
 
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PSO90001", new String[]{}).getMessage(), ex);	//$s System Error Occur
		}
		return eventResponse;
	}

	/**
	 * VOP_PSO_0206 : OK<br>
	 * Create Condition<br>
	 * @category VOP_PSO_0206_OKClick (jmh)
	 * @param Event e
	 * @param String uid
	 * @return EventResponse
	 * @throws EventException 
	 */
	private EventResponse manageConditionByPopup( Event e,String uid ) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PortTariffMgtBC command = new PortTariffMgtBCImpl();
		try{
			begin();
			
			if( uid.equals("0002")) {
				
				VopPso0206Event event = (VopPso0206Event)e;
				ConditionVO[] conditionVOs = event.getConditionVOs();
				conditionVOs[0].setCreUsrId(account.getUsr_id());

				
				String newCondNoAndCondDesc = command.manageConditionByPopup( conditionVOs );
				eventResponse.setETCData("new_condition", newCondNoAndCondDesc);	//Divide by '||'
				//eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
				
			}
			commit();
		} catch(EventException ex) {
			rollback();
			log.error(">>EventException SC : " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err >> " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO97002").getMessage(), ex);
		}
		return eventResponse;

	}
	
	/**VOP_PSO_0003 : Retrieve
	 * Retrieve vessel applicable by using vendor_seq in VOP_PSO_0003
	 * @category VOP_PSO_0003_Retrieve
	 * @param  Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAuditDataCheckList(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0003Event event = (VopPso0003Event)e;
			PortSOMasterDataMgtBC command = new PortSOMasterDataMgtBCImpl();
			List<AuditDataCheckListVO> list = command.searchAuditDataCheckList( event.getFromDate() ,  event.getToDate() , event.getSrhCnd() );
			eventResponse.setRsVoList(list);
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}

	/**VOP_PSO_0001 : Retrieve
	 * Retrieve Default Setting applicable by using ofc_cd in VOP_PSO_0001
	 * @category VOP_PSO_0001_Retrieve
	 * @param  Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchUserDefault(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0001Event event = (VopPso0001Event)e;
			PortSOMasterDataMgtBC command = new PortSOMasterDataMgtBCImpl();
			List<PsoInvOfcYdVO> psoInvOfcYdVO 		= command.searchYardListByUserOffice(event.getOfcCd());
			List<DefaultVendorVO> defaultVendorVO 	= command.searchVendorListByUserOffice(event.getOfcCd());
			List<DefaultCostVO> defaultCostVO 		= command.searchCostListByUserOffice(event.getOfcCd(), event.getChargeType());

			eventResponse.setRsVoList(psoInvOfcYdVO);
			eventResponse.setRsVoList(defaultVendorVO);
			eventResponse.setRsVoList(defaultCostVO);
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	/**VOP_PSO_0203 : Retrieve
	 * Setting BankInfo of vendor by using vendor_seq in VOP_PSO_0203
	 * @category VOP_PSO_0203_WindowOpen
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAgentBankInfo(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0203Event event = (VopPso0203Event)e;
			PortSOMasterDataMgtBC command = new PortSOMasterDataMgtBCImpl();
			String strBankInfo = command.searchAgentBankInfo(event.getVndrSeq());//,account);
			eventResponse.setCustomData("BANKINFO", strBankInfo);
			eventResponse.setETCData("BANKINFO", strBankInfo);	//[2010.05.13:jmh]	
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}

	/**VOP_PSO_0208 : OK
	 * Save Favorite Object List by Office 
	 * @category VOP_PSO_0208_OKButtonClick
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageOfficeObjectList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0208Event event = (VopPso0208Event)e;
		PortTariffMgtBC command = new PortTariffMgtBCImpl();
		try{
			begin();
			command.manageOfficeObjectList(event.getListPsoObjListAll(),account);
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

//	private EventResponse searchOfficeObject1stList(Event e) throws EventException{
//		// TODO Auto-generated method stub
//		VopPso0208Event event = (VopPso0208Event)e;
//		PortTariffMgtBCImpl command = new PortTariffMgtBCImpl();
//		List<PsoObjListVO> list = command.searchOfficeObject1stList(event.getPsoObjListVO());
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		eventResponse.setRsVoList(list);
//		return eventResponse;
//	}


	/**
	 * VOP_PSO_0208 : Retrieve<br>
	 * Handling certain list retrieve event about event of PortSOMasterDataMgt <br>
	 * @Retrieve ObjectList by category VOP_PSO_0208_Vendor
	 * @param Event e
	 * @param String eventName
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeObjectList(Event e, String eventName) throws EventException{
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			PortTariffMgtBC command = new PortTariffMgtBCImpl();

			if(eventName.equals("VopPso0208Event")){
				VopPso0208Event event = (VopPso0208Event)e;
				List<PsoObjListVO> list = command.searchObjectList(event.getPsoObjListVO());
				List<PsoObjListVO> list2 = command.searchOfficeObjectList(event.getPsoObjListVO().getPsoOfcCd());

				PsoObjListVO vo = list2.get(0);

				eventResponse.setRsVoList(list);
				eventResponse.setRsVoList(vo.getList1());
				eventResponse.setRsVoList(vo.getList2());
				eventResponse.setRsVoList(vo.getList3());
			}
			else if (eventName.equals("VopPso0007Event")){//Formula & Condition Creation 

				List<PsoObjListVO> list2 = command.searchOfficeObjectList(account.getOfc_cd());

				PsoObjListVO vo = list2.get(0);

				// Work into Json form
				List<PsoObjListVO> volist = null;

				volist = vo.getList1();


				StringBuilder sb = new StringBuilder("btnObjects=[");
				for(int i=0; i<volist.size();i++){
					PsoObjListVO rvo = volist.get(i);
					sb.append("{\"row\":\"1\",");
					sb.append("\"no\":\""+rvo.getObjListNo()+"\",");
					sb.append("\"name\":\""+rvo.getObjListNm()+"\",");
					sb.append("\"dspname\":\""+rvo.getPsoObjCdDsp()+"\",");
					sb.append("\"uomcd\":\""+rvo.getPsoMeasUtCd()+"\",");
					sb.append("\"uom\":\""+rvo.getPsoMeasUtCdDsp()+"\"},");
				}

				volist = vo.getList2();
				for(int i=0; i<volist.size();i++){
					PsoObjListVO rvo = volist.get(i);
					sb.append("{\"row\":\"2\",");
					sb.append("\"no\":\""+rvo.getObjListNo()+"\",");
					sb.append("\"name\":\""+rvo.getObjListNm()+"\",");
					sb.append("\"dspname\":\""+rvo.getPsoObjCdDsp()+"\",");
					sb.append("\"uomcd\":\""+rvo.getPsoMeasUtCd()+"\",");
					sb.append("\"uom\":\""+rvo.getPsoMeasUtCdDsp()+"\"},");
				}
				volist = vo.getList3();
				for(int i=0; i<volist.size();i++){
					PsoObjListVO rvo = volist.get(i);
					sb.append("{\"row\":\"3\",");
					sb.append("\"no\":\""+rvo.getObjListNo()+"\",");
					sb.append("\"name\":\""+rvo.getObjListNm()+"\",");
					sb.append("\"dspname\":\""+rvo.getPsoObjCdDsp()+"\",");
					sb.append("\"uomcd\":\""+rvo.getPsoMeasUtCd()+"\",");
					if(i+1==volist.size()){
						sb.append("\"uom\":\""+rvo.getPsoMeasUtCdDsp()+"\"}");
						sb.append("];");
					}
					else{
						sb.append("\"uom\":\""+rvo.getPsoMeasUtCdDsp()+"\"},");
					}
				}

				//exception handling  
				// 1. In case Data not exist
				if(sb.toString().equals("btnObjects=["))
					sb.append("];");
				// 2. In case Data not exist after second Row, end in ,  
				int len = sb.toString().length();
				if(sb.toString().substring(len-1, len).equals(",")){
					sb.delete(len-1, len);
					sb.append("];");
				}

				log.debug(sb.toString());

				eventResponse.setCustomData("BTNLIST", sb.toString());
				eventResponse.setETCData("BTNLIST", sb.toString());
			}
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	/**VOP_PSO_0205 : Retrieve
	 * Retrieve Service Vendor Help
	 * @category VOP_PSO_0205_Retrieve
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchOfficeVendor(Event e) throws EventException{
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0205Event event = (VopPso0205Event)e;
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			List<VendorVO> list = command.searchOfficeVendor(event.getVendorVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0210 : OPEN<br>
	 * Retrieve Formula/Condition <br>
	 * @category VOP_PSO_0210 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUseIdConditonFormulaDetail(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0210Event event = (VopPso0210Event)e;
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			List<UseStatusConditonFormulaDtlVO> list = command.searchUseIdConditonFormulaDetail(event.getUseStatusConditonFormulaDtlVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	/**VOP_PSO_0002 : In case of changing Port Code (Key-In)
	 * Retrieve Port Info in VOP_PSO_0002
	 * @category VOP_PSO_0002_PortCode_Key-In
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkPort(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0002Event event = (VopPso0002Event)e;
			VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
			String isNotPort = command.checkPort(event.getPortCd());	//X:exist, "":not exist
			String isPort = isNotPort.equals("X") ? "O" : "X"; 

			eventResponse.setETCData("isPort", isPort);
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	/**VOP_PSO_0002 : In case of changing Service Provider (Key-In)
	 * Retrieve Service Provider Info in VOP_PSO_0002.
	 * @category VOP_PSO_0002_Vendor_Key-In
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVendorList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0002Event event = (VopPso0002Event)e;
			PSOCodeFinderBC command = new PSOCodeFinderBCImpl();
			
			String vndrSeq = event.getVndrSeq();
			VendorListVO vendorListVO = new VendorListVO();
			vendorListVO.setVndrSeq(vndrSeq);
			
			List<VendorListVO> list = command.searchVendorList(vendorListVO);
			String spName = "";
			if(list.size() != 0){
				spName = list.get(0).getVndrLglEngNm();
			}
			
			eventResponse.setETCData("spName", spName);
		
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{"Retrieval of Vendors"}).getMessage());
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0211 : Combo/Input retrieve condition onChange
	 * Retrieve Service Provider 
	 * @category VOP_PSO_0211_SearchConditionsOnChange 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVendorByYardAndCost(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0211Event event = (VopPso0211Event)e;
			PortTariffMgtBC command = new PortTariffMgtBCImpl();

			String portCd = event.getPortCd();
			String costCd = event.getCostCd();
			String year   = event.getYear();
			String uid    = event.getUid();
			String acctcd = event.getAcctCd();

			List<MdmVendorVO> list = command.searchVendorByYardAndCost(portCd, costCd, year, uid, acctcd);
			StringBuffer data = new StringBuffer();

			for (int i = 0; i < list.size(); i++) {
				data.append(list.get(i).getVndrSeq());
				data.append(",,");
				data.append(list.get(i).getVndrLglEngNm());
				if (i < list.size()-1){
					data.append("||");
				}	
			}

			eventResponse.setETCData("vendorList", data.toString());
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}

	/**
	 * VOP_PSO_0037 : OPEN
	 * Retrieve all Account & Cost 
	 * @category VOP_PSO_0004_Open
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAccountAndCost(Event e) throws EventException{
		//VopPso0037Event event = (VopPso0037Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			
			
			List<CostCodeVO> accountList = command.searchAccountAndCost(account.getOfc_cd());
			StringBuffer data = new StringBuffer();

			for (int i = 0; i < accountList.size(); i++) {
				data.append(accountList.get(i).getAcctCd());
				data.append("↕");
				data.append(accountList.get(i).getAcctEngNm());
				data.append("↕");
				data.append(accountList.get(i).getLgsCostCd());
				data.append("↕");
				data.append(accountList.get(i).getLgsCostFullNm());
				data.append("↕");
				data.append(accountList.get(i).getLgsCostSubjCd());

				if (i < accountList.size()-1){
					data.append("↔");
				}	
			}
			eventResponse.setETCData("accountAndCost", data.toString());
			
			List<CostCodeVO> list = command.searchCostCodeList(account.getOfc_cd());
			data.setLength(0);
			//data = new StringBuffer();

			for (int i = 0; i < list.size(); i++) {
				data.append(list.get(i).getAcctCd());
				data.append("↕");
				data.append(list.get(i).getAcctEngNm());
				data.append("↕");
				data.append(list.get(i).getLgsCostCd());
				data.append("↕");
				data.append(list.get(i).getLgsCostFullNm());
				data.append("↕");
				data.append(list.get(i).getLgsCostSubjCd());

				if (i < list.size()-1){
					data.append("↔");
				}	
			}			
			eventResponse.setETCData("costCode", data.toString());
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}	
	
	/**VOP_PSO_0037 : Retrieve
	 * Retrieve Tariff Value Management 
	 * @category VOP_PSO_0037_Retrieve
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchYardChargeList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0037Event event = (VopPso0037Event)e;
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			List<YardChargeVO> list = command.searchYardChargeList(event.getYardChargeVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	/**VOP_PSO_0037 : Retrieve
	 * Retrieve Regular Value Management 
	 * @category VOP_PSO_0037_Retrieve
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchObjByYdChg(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0037Event event = (VopPso0037Event)e;
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			List<YdChgObjVO> list = command.searchObjByYdChg(event.getYdChgObjVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0037 : Save<br>
	 * Save Tariff Value List<br>
	 * @category VOP_PSO_0037_SaveClick (jmh)
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 */
	private EventResponse manageTariffValue( Event e ) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PortTariffMgtBC command = new PortTariffMgtBCImpl();
		try{
			begin();
				
			VopPso0037Event event = (VopPso0037Event)e;
			TariffValueMgtGRPVO tariffValueMgtGRPVO = event.getTariffValueMgtGRPVO();
			tariffValueMgtGRPVO.setAccount(account);
			
			command.manageTariffValue( tariffValueMgtGRPVO );
			/*
			HashMap<String, String> msgHash = command.manageTariffValue( tariffValueMgtGRPVO );
			Iterator iter = msgHash.keySet().iterator();
			while(iter.hasNext()){
				String key  = (String)iter.next();
				log.debug("manageTariffValue SC>>" + key + " : " + msgHash.get(key));
			}
			*/

			eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
				
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PSO90001", new String[]{}).getMessage(), ex);	//$s System Error Occur
		}
		return eventResponse;
	}
	
	/**VOP_PSO_0037 : When calendar in sheet closes
	 * Expired Date validation check
	 * @category VOP_PSO_0037_Calendar
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkExpDateForTariffMgt(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0037Event event = (VopPso0037Event)e;
			PortTariffMgtBC command = new PortTariffMgtBCImpl();

			String flag = command.checkExpDateForTariffMgt(event.getYardChargeVO());
			eventResponse.setETCData("checkExpDate", flag);
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	/*
	 * CHM-201006949-01
	 */
	/**
	 * Get Yard List which contains Tariff applicable 
	 * 
	 * @category VOP_PSO_0212_Open
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardListWithTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0212Event event = (VopPso0212Event)e;
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			//List<TariffListWithYdNmVO> tariffList = command.searchTariffWithCostCd(event.getPortCd(), event.getCostCd());
			List<TariffListWithYdNmVO> tariffList = command.searchTariffWithCostCd(event.getPortCd(), "");

			StringBuffer data = new StringBuffer();

			if(tariffList != null && tariffList.size() > 0){
				//addEmptyData(data);

				for (int i = 0; i < tariffList.size(); i++) {

					//data.append(cdList.get(i).getCode());
					data.append(tariffList.get(i).getYdCd().substring(5));
					data.append(",");
					//data.append(cdList.get(i).getName());
					data.append(tariffList.get(i).getYdNm());
					if (i < tariffList.size()-1)
						data.append("|");
				}
			}
			
			eventResponse.setETCData("lane", data.toString());

		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0040 : Open <br>
	 * Retrieve Combo in Object List page in case of Loading page <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchObjectBasic(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			String objTpCd = "CD01847";
			String MeasUtCd = "CD01848";
			CodeUtil cdUtil = CodeUtil.getInstance();
			ArrayList<CodeInfo> objTpCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect(objTpCd, 1);
			ArrayList<CodeInfo> MeasUtCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect(MeasUtCd, 1);
			
			StringBuffer TpCd = new StringBuffer();
			StringBuffer TpNm = new StringBuffer();
			StringBuffer UtCd = new StringBuffer();
			StringBuffer UtNm = new StringBuffer();
	
			if (objTpCdList != null && objTpCdList.size() > 0) {
				for (int i = 0; i < objTpCdList.size(); i++) {
					TpCd.append(objTpCdList.get(i).getCode());
					TpNm.append(objTpCdList.get(i).getName());
					if (i < objTpCdList.size() - 1){
						TpCd.append("|");
						TpNm.append("|");
					}
				}
			}
			
			if (MeasUtCdList != null && MeasUtCdList.size() > 0) {
				for (int i = 0; i < MeasUtCdList.size(); i++) {
					UtCd.append(MeasUtCdList.get(i).getCode());
					UtNm.append(MeasUtCdList.get(i).getName());
					if (i < MeasUtCdList.size() - 1){
						UtCd.append("|");
						UtNm.append("|");
					}
				}
			}
	
			eventResponse.setETCData("tp_cd", TpCd.toString());
			eventResponse.setETCData("tp_nm", TpNm.toString());
			eventResponse.setETCData("ut_cd", UtCd.toString());
			eventResponse.setETCData("ut_nm", UtNm.toString());
			
//		}catch(EventException ex){
//			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Objcet Type & Measure Unit"}).getMessage(), ex);
		}		
		return eventResponse;
	} 	
	
	/**
	 * VOP_PSO_0040 : Retrieve <br>
	 * Retrieve Object List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchObjBasicAll(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0040Event event = (VopPso0040Event)e;
		PortTariffMgtBC command = new PortTariffMgtBCImpl();

		try{

			List<PsoObjListVO> list = command.searchObjBasicAll(event.getObjNm());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Object List"}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Object List"}).getMessage(), ex);
		}		
		return eventResponse;
	} 	
	
	/**
	 * VOP_PSO_0040 : Save <br>
	 * Save Object List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageObjectList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0040Event event = (VopPso0040Event)e;
		PortTariffMgtBC command = new PortTariffMgtBCImpl();
		try{
			begin();
			command.manageObjectList(event.getPsoObjListVOS(),account);
			commit();
        } catch (EventException ex) {
        	log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("PSO90011",new String[]{"Object List"}).getMessage(), ex);
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("PSO90011",new String[]{"Object List"}).getMessage(), ex);
        }
		return eventResponse;
	}	

}