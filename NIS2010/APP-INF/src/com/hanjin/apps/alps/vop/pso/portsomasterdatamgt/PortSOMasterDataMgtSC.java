/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : portsomasterdatamgtSC.java
*@FileTitle : Service Provider Help
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.27
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.04.28 김진일
* 1.0 Creation
*
* History
* 2010.11.24 CHM-201006949-01 박희동 특정 Tariff가 존재하는 Yard List를 조회한다.
* 2011.06.27 진마리아 CHM-201111838-01 소스품질 결함 수정 - catch절에서 예외를 throw 하지 않는다면 반드시 오류 메시지( log.error())를 기술하여야 한다
* 2011.07.15 김기종 CHM-201111662-01 0002,0004화면 Formula 및 Condition ID 입력 변경 & 칼럼 숨김 요청 
* 2011.07.28 김기종 CHM-201112475-01 [VOP_PSO] Port Tariff Inquiry 메뉴 수정 요청건
* 2014.03.12 박다은 CHM-201429104 	[PSO] Tariff Attribute 내 불필요 Tariff 삭제 기능 요청
* 2014.03.19 최문환 CHM-201428969 [PSO] Port tariff Inquiry - 조회조건 및 화면 변경
* 2014.07.11 이성훈 CHM-201430928 	[PSO] Port Tariff Contract 및 URL 저장
* 2015.02.10 CHM-201533892 Tariff내 Formula 및 Condition 생성 로직변경  
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt;

import java.util.ArrayList;
import java.util.List;

import weblogic.wsee.util.StringUtil;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.basic.GeneralInvoiceAuditBC;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.basic.GeneralInvoiceAuditBCImpl;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event.VopPso0014Event;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.basic.PortSOMasterDataMgtBC;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.basic.PortSOMasterDataMgtBCImpl;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.event.VopPso0001Event;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.event.VopPso0003Event;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.event.VopPso0203Event;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.AuditDataCheckListVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.DefaultCostVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.DefaultVendorVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PortSOMasterDataMgtVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PsoInvOfcYdVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PsoObjListVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.SearchYardsVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.basic.PortTariffMgtBC;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.basic.PortTariffMgtBCImpl;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0002Event;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0004Event;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0007Event;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0036Event;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0037Event;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0041Event;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0042Event;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0205Event;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0206Event;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0208Event;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0209Event;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0210Event;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0211Event;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0212Event;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0237Event;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.AccountAndCostVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.ConditionVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.CondtionOpertionVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.CostCodeVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.CurrencyVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.EffectiveDateListVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.FormulaVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.PortTariffCodeGRPVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.PortTariffListVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.SearchTariffConditionVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffAtchFileVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffBaseVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffListGRPVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffValueMgtGRPVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConForVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConditonFormulaDtlVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConditonFormulaVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.VendorVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YardChargeVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YardChargeVersionVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YdChgObjVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YdChgNoDataInfoVO;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.basic.PSOCodeFinderBC;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.basic.PSOCodeFinderBCImpl;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.vo.CostListVO;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.vo.VendorListVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBC;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmVendorVO;
import com.hanjin.syscommon.common.table.PsoFormulaVO;
import com.hanjin.syscommon.common.table.PsoTrfAtchFileVO;
import com.hanjin.syscommon.common.table.PsoYdChgObjListVO;


/**
 * NIS2010-portsomasterdatamgt Business Logic ServiceCommand - NIS2010-portsomasterdatamgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Kim Jin Ihl
 * @see porttariffmgtDBDAO
 * @since J2EE 1.4
 */

public class PortSOMasterDataMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * portsomasterdatamgt system 업무 시나리오 선행작업<br>
	 * UI_PSO-0205업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * portsomasterdatamgt system 업무 시나리오 마감작업<br>
	 * UI_PSO-0205 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("portsomasterdatamgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-portsomasterdatamgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VopPso0001Event")) {
			//PageLoad시.. 해당 VendorSeq의 BankInformation을 가지고 온다.
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
			//PageLoad시.. 해당 VendorSeq의 BankInformation을 가지고 온다.
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {			//Yard
				eventResponse = searchYardList2(e , "0002" );
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02) ) {	//SearchVersion
				eventResponse = searchEffectiveDate(e, "0002");
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE) ) {		//Delete	//COMMAND03 -> REMOVE
				eventResponse = deletePortCharge(e, "0002");
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND05) ) {	//[2009.08.24:jmh]	Port Code 변경시(Key-In)
				eventResponse = checkPort(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND06) ) {	//[2009.08.24:jmh]	Service Provider 변경시(Key-In)
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
			//PageLoad시.. 해당 VendorSeq의 BankInformation을 가지고 온다.
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAuditDataCheckList(e);
			}
			else{
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
			}
		}
		if (e.getEventName().equalsIgnoreCase("VopPso0004Event")) {
			//PageLoad시.. 해당 VendorSeq의 BankInformation을 가지고 온다.
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
			//PageLoad시.. 해당 VendorSeq의 BankInformation을 가지고 온다.
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
				VopPso0001Event event = new VopPso0001Event();
				event.setYdCd1(portCd);
				eventResponse = searchYardList(event);	//Yard List
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {	//VOP_PSO_0036에서 사용
				eventResponse = searchOfficeObjectList4(e, "0211" );
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {// Version리스트 콜. 
				eventResponse = searchEffectiveDate2(e, "0211");
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {// Vendor리스트 콜. 
				eventResponse = searchVendorByYardAndCost(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("VopPso0212Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH )) {
				eventResponse = searchPortChargeList(e, "0212");
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				VopPso0212Event eve = (VopPso0212Event)e;
				String portCd = eve.getPortCd();
				VopPso0001Event event = new VopPso0001Event();
				event.setYdCd1(portCd);
				eventResponse = searchYardList(event);	//Yard List
				
//				eventResponse = searchYardListWithTariff(e);
				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchOfficeObjectList4(e, "0212" );
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {// Version리스트 콜. 
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
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {//Tariff List 조회
				eventResponse = searchPortChargeList(e, "0036");
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchAccountAndCostByCondition(e);
			}
			else{//최초 Open시에는 이곳으로 들어 온다. 
				log.debug(">>>>>>>>>>>>"+e.getFormCommand().getCommand());
				//eventResponse = searchTerminalList(e, "0212");
			}
		}
		//[VOP_PSO_0036 Port Tariff Condition]<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		//[VOP_PSO_0007 Formula N' Condition Creation]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		//VOP_PSO_0007 Formula N' Condition Creation
		if (e.getEventName().equalsIgnoreCase("VopPso0007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH )) {//VOP_PSO_0007_RetrieveBtnClick 
				//해당 flag가 Formula 인지 Condition 인지 구분 
				VopPso0007Event event = (VopPso0007Event) e;
				if(event.getFlag().equals("1"))
					eventResponse = searchFormula(e);
				else if (event.getFlag().equals("2"))
					eventResponse = searchCondition(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//Button의 레이아웃을 쿼리한다. 
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
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {//VOP_PSO_0007_Auto ID foml_no
				VopPso0007Event event = (VopPso0007Event) e;
				if(event.getFlag().equals("1"))
					eventResponse = autoCreateFormula(e);
				else if (event.getFlag().equals("2"))
					eventResponse = autoCreateCondition(e);
			}
			else{//최초 Open시에는 이곳으로 들어 온다. // OnOpen Event 처리
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
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02 )) {//VOP_PSO_0037_Invoice_Count
				eventResponse = getInvCnt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI )) {//VOP_PSO_0037_Save
				eventResponse = manageTariffValue(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01 )) {//VOP_PSO_0037_Delete_Tariff
				eventResponse = deleteTariffAttribute(e);
			}
		}
		
		//[VOP_PSO_0041 Port Tariff File Upload]<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		if (e.getEventName().equalsIgnoreCase("VopPso0041Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTariffAtchFileList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTariffAtchFile(e);
			}
		}
		//[VOP_PSO_0041 Port Tariff File Upload]<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

		//[VOP_PSO_0042 Port Tariff Remark]<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		if (e.getEventName().equalsIgnoreCase("VopPso0042Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTariffRemark(e);
			}
		}
		//[VOP_PSO_0042 Port Tariff Remark]<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		if (e.getEventName().equalsIgnoreCase("VopPso0237Event")) {
			//PageLoad시.. 해당 VendorSeq의 BankInformation을 가지고 온다.
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchYdChgNoDataInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = copyTariff(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchVendorListCheck(e);
			}
//			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
//				eventResponse = searchVendorTariffCheck(e);
//			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = searchMdmYardCheck(e);
			}
		
		}
		return eventResponse;
	}
	
	/**VOP_PSO_0007 : Save
	 * Condition 정보를 저장한다.
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
			throw new EventException(new ErrorHandler("PSO90011", new String[]{}).getMessage(), ex);	//[2010.04.30] Save Exception Message
		}
		return eventResponse;
	}

	/**VOP_PSO_0007 : Save
	 * Formula 정보를 저장한다. 
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
			if(ex.getMessage().indexOf("PSO_OBJECT") == -1) {
				rollback();
			    throw ex; }
			else {
				rollback();
				eventResponse.setETCData("ERROR", "Y");
				}
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PSO90011", new String[]{}).getMessage(), ex);	//[2010.04.30] Save Exception Message
		}
		return eventResponse;
	}
	
	/**VOP_PSO_0007 : Auto ID - FOML_NO
	 * Formula 정보를 저장한다. 
	 * @category VOP_PSO_0007_AutoIDClickFormula
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse autoCreateFormula(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PortTariffMgtBC command = new PortTariffMgtBCImpl();
		
		try{
			String fomlNo  = command.autoCreateFormula();
			eventResponse.setETCData("AUTO_NO", fomlNo);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**VOP_PSO_0007 : Auto ID - FOML_NO
	 * Formula 정보를 저장한다. 
	 * @category VOP_PSO_0007_AutoIDClickFormula
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse autoCreateCondition(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PortTariffMgtBC command = new PortTariffMgtBCImpl();
	
		try{
			String condNo  = command.autoCreateCondition();
			eventResponse.setETCData("AUTO_NO", condNo);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}


	/**VOP_PSO_0007 : Delete
	 * Formula N' Condition Creation 화면의 Delete Button을 ClicK 했을 경우 처리
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
	 * Formula N' Condition Creation 화면의 Delete Button을 ClicK 했을 경우 처리
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
	 *  Formula N' Condition Creation 화면의 Retrieve Button을 ClicK 했을 경우의 Condition 정보 조회 
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
	 * Formula N' Condition Creation 화면의 Retrieve Button을 ClicK 했을 경우의 Formula 정보 조회 
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
	 * Charge Creation(Invoice 생성)시에 필요한 Effective Date(지불일)의 Version 을 조회한다.
	 * @category VOP_PSO_0036_EffDateClick
	 * @param Event e
	 * @return EventResponse
	 */
	private EventResponse searchYardChargeVersion(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			VopPso0036Event event = (VopPso0036Event) e;
			StringBuffer data = new StringBuffer();
			
			List<YardChargeVersionVO> versionList = command.searchYardChargeVersion(event.getPortTariffListVO());

			if (versionList != null && !versionList.isEmpty()) {

				String portTrfRmk = null;

				int itemCurCount = 0;
				int itemTotCount = versionList.size();
				
				for (YardChargeVersionVO version : versionList) {
					
					// =======================================================================================
					// 필드구분자로 ',' 를 사용하기 때문에, Remark 에 ',' 를 사용할 경우 오류가 발생됨.
					// 그래서, ',' 문자를 '^' 문자로 변환해서 전송해주고, 화면에서 복원해서 사용하도록 구성함
					// =======================================================================================
					portTrfRmk = version.getPortTrfRmk();
					if (!StringUtil.isEmpty(portTrfRmk) && portTrfRmk.indexOf(",") > -1) {
						portTrfRmk = portTrfRmk.replaceAll(",", "^");
					}
					//========================================================================================

					data.append(version.getYdChgVerSeq());
					data.append(",");
					data.append(version.getYdChgNo());
					data.append(",");
					data.append(version.getRn());
					data.append(",");
					data.append(version.getUpdUsrId());
					data.append(",");
					data.append(version.getUpdDt());
					data.append(",");
					data.append(version.getPortTrfUrl());
					data.append(",");
					data.append(portTrfRmk);
					data.append(",");
					data.append(this.getAtchFileNames(version.getYdChgNo(), version.getYdChgVerSeq()));
					
					if (itemCurCount < itemTotCount-1)
						data.append("|");
					
					itemCurCount++;
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
	 * Charge Creation(Invoice 생성)시에 필요한 Effective Date(지불일)를 조회한다.
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
	 * Terminal 별로  Tariff List(Account/Vendor/Update ID/Update Date)를 조회함
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

			List<PortTariffListVO> list = command.searchPortTariffList(vo.getYdCd(), vo.getYear(), vo.getAcctCd());

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

			List<AccountAndCostVO> list = command.searchAccountAndCostByCondition(vo.getYdCd(), vo.getYear());

			eventResponse.setRsVoList(list);
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
		
	/**VOP_PSO_0209 : OPEN
	 * VOP_PSO_0209에서 charge_type과 object_list를 조회한다.
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
	 * VOP_PSO_0209에서 object_list를 조회한다.
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
	 * VOP_PSO_0211에서 ofc_cd를 이용하여 해당 Termianl정보를 조회한다.
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
	 * VOP_PSO_0002에서 로그인 유저가 소속한 Office가 설정한 Object List를 조회한다.
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
			PSOCodeFinderBC comCommand =  new PSOCodeFinderBCImpl();

			if(uid.equals("0002")) {
				VopPso0002Event event = (VopPso0002Event)e;
				ofccdList = command.searchOfficeObjectList1(account.getOfc_cd(), event.getTypes() );
			} else if(uid.equals("0004")) {
				VopPso0004Event event = (VopPso0004Event)e;
				ofccdList = command.searchOfficeObjectList1(account.getOfc_cd(), event.getTypes() );
			}

			StringBuffer data = new StringBuffer();
			StringBuffer dataUOM = new StringBuffer();

			if(ofccdList != null && ofccdList.size() > 0){
				for (int i = 0; i < ofccdList.size(); i++) {
					//Object
					data.append(ofccdList.get(i).getPsoObjCd());
					data.append(",");
					data.append(ofccdList.get(i).getPsoObjCdDsp());
					data.append(",");
					data.append(ofccdList.get(i).getPsoMeasUtCd());
					data.append(",");
					data.append(ofccdList.get(i).getPsoMeasUtCdDsp());
					data.append(",");
					data.append(ofccdList.get(i).getObjListNo());

					//UOM
					dataUOM.append(ofccdList.get(i).getPsoObjCd());
					dataUOM.append(",");
					dataUOM.append(ofccdList.get(i).getPsoMeasUtCd());
					dataUOM.append(",");
					dataUOM.append(ofccdList.get(i).getPsoMeasUtCdDsp());

					if (i < ofccdList.size()-1){
						data.append("|");
						dataUOM.append("|");
					}	
				}
			}

			eventResponse.setETCData("objlist", data.toString());
			eventResponse.setETCData("uomlist", dataUOM.toString());

			List<CostCodeVO> costCodeList = command.searchCostCodeList(account.getOfc_cd());

			data = new StringBuffer();

			if(costCodeList != null && costCodeList.size() > 0){
				for (int i = 0; i < costCodeList.size(); i++) {
					//data.append(costCodeList.get(i).getLgsCostCd());
					data.append(costCodeList.get(i).getAcctEngNm());
					data.append(",");
					data.append(costCodeList.get(i).getAcctCd());
					if (i < costCodeList.size() - 1)
						data.append("|");
				}
			}

			eventResponse.setETCData("account", data.toString());

			data = new StringBuffer();
			if(costCodeList != null && costCodeList.size() > 0){
				for (int i = 0; i < costCodeList.size(); i++) {
					data.append(costCodeList.get(i).getLgsCostCd());
					data.append(",");
					data.append(costCodeList.get(i).getLgsCostFullNm());
					if (i < costCodeList.size() - 1)
						data.append("|");
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
					data.append(",");
					data.append(currencyList.get(i).getCurrNm());
					if (i < currencyList.size() - 1){
						data.append("|");
					}

					if("Y".equals(currencyList.get(i).getIsLocalCurr())){
						localCurrency = currencyList.get(i).getCurrCd();
					}
				}
			}
			eventResponse.setETCData("currency", data.toString());		

			List<CostListVO> listAcct = comCommand.searchAccountList();
			for(int i=0; i<listAcct.size(); i++){
				if("511911".equals(listAcct.get(i).getAcctCd())){
					eventResponse.setETCData("accountForCanal", listAcct.get(i).getAcctEngNm() + "," + listAcct.get(i).getAcctCd());	//511911계정명
					break;
				}
			}

			//For 0004.do
			List<PsoObjListVO> listObjByTpCd = command.searchPsoObjListByPsoObjListTpCd("M");
			data = new StringBuffer();
			if(listObjByTpCd != null && listObjByTpCd.size() > 0){
				for (int i = 0; i < listObjByTpCd.size(); i++) {
					//Object
					data.append(listObjByTpCd.get(i).getPsoObjCd());
					data.append(",");
					data.append(listObjByTpCd.get(i).getPsoObjCdDsp());
					data.append(",");
					data.append(listObjByTpCd.get(i).getPsoMeasUtCd());
					data.append(",");
					data.append(listObjByTpCd.get(i).getPsoMeasUtCdDsp());
					data.append(",");
					data.append(listObjByTpCd.get(i).getObjListNo());

					if (i < listObjByTpCd.size()-1){
						data.append("|");
					}
				}
			}
			eventResponse.setETCData("objListByTpCd", data.toString());

			eventResponse.setETCData("localCurrency", localCurrency);	//My Office의 기본통화		

			eventResponse.setRsVoList(ofccdList);
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}	
	
	
	
	/**VOP_PSO_0208 : OPEN
	 * VOP_PSO_0208에서 로그인 유저가 소속한 Office가 설정한 Object List를 조회한다.
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
	 * VOP_PSO_0206에서 로그인 유저가 소속한 Office가 설정한 Object List를 조회한다.
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
	 * VOP_PSO_0208에서 로그인 유저가 소속한 Office가 설정한 Object List를 조회한다.
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
	 * VOP_PSO_0001에서 vendor_seq를 이용하여 해당 vendor의 BankInfo를 Setting한다.
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
	 * VOP_PSO_0001에서 ofc_cd를 이용하여 해당 yard를 조회한다.
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
	 * VOP_PSO_0002에서 ofc_cd를 이용하여 해당 yard를 조회한다.
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
	 * VOP_PSO_0001에서 ofc_cd를 이용하여 해당 yard를 조회한다.
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
	 * tariff list 정보를 조회한다.
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
				this.changeComboValue(portTariffCodeGRPVO);	// Currency Code, Version Code 의 Combo 변수명 변경
				baseTariff 	 = command.searchBaseTariff( portTariffCodeGRPVO );

				for(int i=0; i<baseTariff.size(); i++){
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
				this.changeComboValue(portTariffCodeGRPVO);	// Currency Code, Version Code 의 Combo 변수명 변경
				baseTariff 	 = command.searchBaseTariff( portTariffCodeGRPVO );

				if(baseTariff.size() > 0){
					//Regular Value 조회를 위한 yd_chg_no, yd_chg_ver_seq 세팅
					ydChgNo = baseTariff.get(0).getYdChgNo();
					ydChgVerSeq = baseTariff.get(0).getYdChgVerSeq();
				}

				for(int i=0; i<baseTariff.size(); i++){
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
				this.changeComboValue(portTariffCodeGRPVO);	// Currency Code, Version Code 의 Combo 변수명 변경
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
	 * tariff list 정보를 삭제한다.
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
				portTariffCodeGRPVO.setUid(uid);
				this.changeComboValue(portTariffCodeGRPVO);	// Currency Code, Version Code 의 Combo 변수명 변경
				
				command.deletePortChargeSimple( portTariffCodeGRPVO );
				eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
				
			} else if( uid.equals("0004")) {
				VopPso0004Event event = (VopPso0004Event)e;
				portTariffCodeGRPVO = event.getPortTariffCodeGRPVO();
				portTariffCodeGRPVO.setOfcCd(account.getOfc_cd());
				portTariffCodeGRPVO.setUid(uid);
				this.changeComboValue(portTariffCodeGRPVO);	// Currency Code, Version Code 의 Combo 변수명 변경
				
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
	 * fromula or condition 정보를 조회한다.
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
				if (formula.size() > 0) eventResponse.setETCData(formula.get(0).getColumnValues());
			} else {
				condition 	 = command.searchUseStatusConditon( useStatusConForVO );
				eventResponse.setRsVoList( condition );
				if (condition.size() > 0) eventResponse.setETCData(condition.get(0).getColumnValues());
			}
			
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0209 : OPEN
	 * fromula or condition의 id를 조회한다.
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
	 * tariff list 정보를 조회한다.
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
	 * tariff version 정보를 조회한다.
	 * @param Event e
	 * @param String uid
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchEffectiveDate(Event e,String uid) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			PortTariffCodeGRPVO portTariffCodeGRPVO = null;
			List<TariffListGRPVO> tariffList = null;
			String localCurrency = "";
			StringBuffer data = new StringBuffer();
			
			if ("0002".equals(uid)) {
				portTariffCodeGRPVO = ((VopPso0002Event) e).getPortTariffCodeGRPVO();
				
				if (!StringUtil.isEmpty(portTariffCodeGRPVO.getPortCd())) {
					localCurrency = command.searchLocalCurrencyByPortCd(portTariffCodeGRPVO.getPortCd());
				}
			} 
			else if ("0004".equals(uid)) {
				portTariffCodeGRPVO = ((VopPso0004Event) e).getPortTariffCodeGRPVO();
				
				// =======================================================================================
				// 수정일자 : 2014.07.08
				// 수정내용 : Port 기준으로 조회되는 Currency 호출로직을 Service Provider 기준으로 변경
				// =======================================================================================
				if (!StringUtil.isEmpty(portTariffCodeGRPVO.getVndrSeq())) {
					localCurrency = command.searchCurrencyByVndrSeq(portTariffCodeGRPVO.getVndrSeq());
					// =======================================================================================
				}
			}
			
			tariffList = command.searchEffectiveDateList(portTariffCodeGRPVO, uid);
			
			if (tariffList != null && !tariffList.isEmpty()) {

				String portTrfRmk = null;
				
				int itemCurCount = 0;
				int itemTotCount = tariffList.size();
				
				for (TariffListGRPVO tariff : tariffList) {

					if ("0002".equals(uid) && "2".equals(tariff.getUpdMnuNo())) {
						eventResponse.setETCData("errorMessage", "ALREADY INPUT");	//이미 복잡 Tariff 화면에서 입력되었습니다. -> Message는 화면에서 처리		
						//eventResponse.setETCData("errorMessage", new ErrorHandler("PSO99003", new String[]{"Complex Tariff"}).getMessage());		
						return eventResponse;
					}

					if ("0004".equals(uid) && "1".equals(tariff.getUpdMnuNo())) {
						eventResponse.setETCData("errorMessage", "ALREADY INPUT");	//이미 단순 Tariff 화면에서 입력되었습니다. -> Message는 화면에서 처리		
						//eventResponse.setETCData("errorMessage", new ErrorHandler("PSO99003", new String[]{"Simple Tariff"}).getMessage());	
						return eventResponse;
					}

					// =======================================================================================
					// 필드구분자로 ',' 를 사용하기 때문에, Remark 에 ',' 를 사용할 경우 오류가 발생됨.
					// 그래서, ',' 문자를 '^' 문자로 변환해서 전송해주고, 화면에서 복원해서 사용하도록 구성함
					// =======================================================================================
					portTrfRmk = tariff.getPortTrfRmk();
					if (!StringUtil.isEmpty(portTrfRmk) && portTrfRmk.indexOf(",") > -1) {
						portTrfRmk = portTrfRmk.replaceAll(",", "^");
					}
					//========================================================================================

					data.append(tariff.getYdChgNo());
					data.append(",");
					data.append(tariff.getVer());
					data.append(",");
					data.append(tariff.getEffDt()+"~"+tariff.getExpDt());
					data.append(",");
					data.append(tariff.getCurrCd());
					data.append(",");
					data.append(tariff.getCplsFlg());
					data.append(",");
					data.append(tariff.getIssCtyCd());
					data.append(",");
					data.append(tariff.getOrgVndrNm());
					data.append(",");
					data.append(tariff.getPortTrfUrl());
					data.append(",");
					data.append(portTrfRmk);
					data.append(",");
					data.append(this.getAtchFileNames(tariff.getYdChgNo(), tariff.getVer()));
					
					if (itemCurCount < itemTotCount-1)
						data.append("|");
					
					itemCurCount++;
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
	 * TariffList copy 의 version 정보를 조회한다.
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
	 * Yard/Vendor/Cost를 저장합니다.<br><br>
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
	 * Tariff List를 저장합니다.<br>
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
				portTariffCodeGRPVO.setUid(uid);
				this.changeComboValue(portTariffCodeGRPVO);	// Currency Code, Version Code 의 Combo 변수명 변경
				
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
				portTariffCodeGRPVO.setUid(uid);
				this.changeComboValue(portTariffCodeGRPVO);	// Currency Code, Version Code 의 Combo 변수명 변경
				
				command.managePortChargeComplex( portTariffCodeGRPVO );
				eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
			}	
 
			commit();
		}catch(EventException ex){
			if(ex.getMessage().indexOf("PSO_OBJECT") == -1) {
				rollback();
			    throw ex; }
			else {
				rollback();
				eventResponse.setETCData("ERROR", "Y");
				//throw ex;
				}
			
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PSO90001", new String[]{}).getMessage(), ex);	//$s 시스템 에러가 발생하였습니다
		}
		return eventResponse;
	}

	/**
	 * VOP_PSO_0206 : OK<br>
	 * Condition을 생성합니다.<br>
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
				eventResponse.setETCData("new_condition", newCondNoAndCondDesc);	//'||'로 구분
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
	 * VOP_PSO_0003에서 vendor_seq를 이용하여 해당 vessle를 조회한다.
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
	 * VOP_PSO_0001에서 ofc_cd를 이용하여 해당 Default Setting를 조회한다.
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
	 * VOP_PSO_0203에서 vendor_seq를 이용하여 해당 vendor의 BankInfo를 Setting한다.
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
	 * Office 별 Favorite Object List를 저장합니다.
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
	 * PortSOMasterDataMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * @category VOP_PSO_0208_Vendor별ObjectList조회
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

				// Json형태로 가공한다. 
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

				//예외처리 
				// 1. 데이터가 한건도 없는 경우 
				if(sb.toString().equals("btnObjects=["))
					sb.append("];");
				// 2. 2번째 ROW이후에 데이터가 없는 경우 마지막이 ,로 끝난다.
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
	 * Service Vendor Help화면 조회 
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
	 * Formula/Condition 를 조회합니다.<br>
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
	
	/**VOP_PSO_0002 : Port Code 변경시(Key-In)
	 * VOP_PSO_0002에서 Port 정보를 조회한다.
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
			String isNotPort = command.checkPort(event.getPortCd());	//X:존재, "":미존재
			String isPort = isNotPort.equals("X") ? "O" : "X"; 

			eventResponse.setETCData("isPort", isPort);
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
	/**VOP_PSO_0002 : Service Provider 변경시(Key-In)
	 * VOP_PSO_0002에서 Service Provider 정보를 조회한다.
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
	 * VOP_PSO_0211 : Combo/Input 조회조건 onChange
	 * Service Provider 정보를 조회한다.
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
	 * 모든 Account & Cost 를 조회한다.
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

			List<AccountAndCostVO> list = command.searchAccountAndCost();
			StringBuffer data = new StringBuffer();

			for (int i = 0; i < list.size(); i++) {
				data.append(list.get(i).getAcctCd());
				data.append("↕");
				data.append(list.get(i).getAcctNm());
				data.append("↕");
				data.append(list.get(i).getCostCd());
				data.append("↕");
				data.append(list.get(i).getCostNm());

				if (i < list.size()-1){
					data.append("↔");
				}	
			}

			eventResponse.setETCData("accountAndCost", data.toString());
			eventResponse.setRsVoList(list);
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}	
	
	/**VOP_PSO_0037 : Retrieve
	 * Tariff Value Management 조회
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
	 * Regular Value Management 조회
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
	
	/**VOP_PSO_0037 : Delete
	 * Invoice count 조회
	 * @category VOP_PSO_0037_Retrieve
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse getInvCnt(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0037Event event = (VopPso0037Event)e;
		PortTariffMgtBC command = new PortTariffMgtBCImpl();
		
		try{
			String invCnt = command.getInvCnt(event.getYardChargeVO());
			
//			List<YdChgObjVO> list = command.searchObjByYdChg(event.getYdChgObjVO());
			eventResponse.setETCData("invCnt", invCnt);
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
	
		
	/**
	 * VOP_PSO_0037 : Save<br>
	 * Tariff Value List를 저장합니다.<br>
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
			throw new EventException(new ErrorHandler("PSO90001", new String[]{}).getMessage(), ex);	//$s 시스템 에러가 발생하였습니다
		}
		return eventResponse;
	}
	
	/**VOP_PSO_0037 : When calendar in sheet closes
	 * Expired Date 유효성 체크
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
	
	/**
	 * VOP_PSO_0037 Delete
	 * tariff list 정보를 삭제한다.
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse deleteTariffAttribute(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			begin();
		
			YardChargeVO yardChargeVO = null;
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			VopPso0037Event event = (VopPso0037Event)e;
			yardChargeVO = event.getYardChargeVO();
			
			command.deleteTariffAttribute( yardChargeVO );
			eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
		
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
	 * VOP_PSO_0041 조회 이벤트 처리
	 * tariff upload file 을 조회한다.
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException 
	 */
	private EventResponse searchTariffAtchFileList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			VopPso0041Event event = (VopPso0041Event)e;
			TariffAtchFileVO tariffAtchFileVO = event.getTariffAtchFileVO();
			
			String auths[] = event.getSignOnUserAccount().getUserAuth();
			for(String auth : auths){ 
				if(auth.equals("PSO01")||auth.equals("PSO02")){
					tariffAtchFileVO.setAtchFileAuth("Y");
					//break;
				}
			}
			
			List<PsoTrfAtchFileVO> voList = command.searchPsoTrfAtchFileList(tariffAtchFileVO);
			eventResponse.setRsVoList(voList);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0041 저장 이벤트 처리<br>
	 * tariff upload file 을 생성 처리<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTariffAtchFile(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		PortTariffMgtBC command = new PortTariffMgtBCImpl();
		
		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		VopPso0041Event event = (VopPso0041Event)e;
		TariffAtchFileVO tariffAtchFileVO = event.getTariffAtchFileVO();
		tariffAtchFileVO.setAccount(account);

		try{
			//2.로직 처리 실행
			begin();
			command.manageTariffUploadFile(tariffAtchFileVO);
			commit();

			//3.로직 처리후 결과처리
			//PSO01003: 성공적으로 처리가 완료되었습니다.
			eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage()); // 정상으로 저장되었습니다.

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	// Version 과 Currency 화면 위치변경에 따른 필드값 변경
	private void changeComboValue(PortTariffCodeGRPVO portTariffCodeGRPVO) {
		
		if (portTariffCodeGRPVO != null) {
			if ("0002".equals(portTariffCodeGRPVO.getUid()) || "0004".equals(portTariffCodeGRPVO.getUid())) {
				//==================================================================================
				// Version 과 Currency 화면 위치변경에 따른 필드값 변경. 2014.07.11 by jameskai
				//==================================================================================
				String combo4 = portTariffCodeGRPVO.getCombo4();//As-is:Version, To-be:Currency
				String combo5 = portTariffCodeGRPVO.getCombo5();//As-is:Currency,To-be:Version
				log.debug("combo4+combo5"+combo4+combo5);
				portTariffCodeGRPVO.setCombo4(combo5);
				portTariffCodeGRPVO.setCombo5(combo4);
				//==================================================================================	
			}
		}
	}
	
	// Regulation, Contract 첨부파일명을 일련의 문자열로 반환해주는 공통 메소드
	private String getAtchFileNames(String ydChgNo, String ydChgVerSeq) throws EventException {
		
		PortTariffMgtBC command = new PortTariffMgtBCImpl();
		StringBuilder sbAtchFileNames = new StringBuilder();
		String[] arrAtchFileDivCd = {"R", "C"};
		
		// =======================================================================================
		// [Regulation][Contract] 첨부파일명을 조회한다.
		//========================================================================================
		TariffAtchFileVO tariffAtchFileVO = new TariffAtchFileVO();
		tariffAtchFileVO.setYdChgNo(ydChgNo);
		tariffAtchFileVO.setYdChgVerSeq(ydChgVerSeq);
		
		try{
			List<PsoTrfAtchFileVO> psoTrfAtchFileVOList = null;
			for (String atchFileDivCd : arrAtchFileDivCd) {
				tariffAtchFileVO.setAtchFileDivCd(atchFileDivCd);
				psoTrfAtchFileVOList = command.searchPsoTrfAtchFileList(tariffAtchFileVO);
				if (psoTrfAtchFileVOList != null && !psoTrfAtchFileVOList.isEmpty()) {
					sbAtchFileNames.append("[").append(atchFileDivCd).append("]");
					for (PsoTrfAtchFileVO psoTrfAtchFileVO : psoTrfAtchFileVOList) {
						sbAtchFileNames.append(psoTrfAtchFileVO.getFileNm()).append("^");
					}
					sbAtchFileNames.deleteCharAt(sbAtchFileNames.length()-1);
				}
				
				if (sbAtchFileNames.length() > 0)
					sbAtchFileNames.append(" ");
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
		}				
		//========================================================================================	
		return sbAtchFileNames.toString();
	}	
	
	/**
	 * VOP_PSO_0042 조회 이벤트 처리
	 * Yard Charge에 등록된 Remark를 조회한다.
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException 
	 */
	private EventResponse searchTariffRemark(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			VopPso0042Event event = (VopPso0042Event)e;
			PortTariffListVO portTariffListVO = event.getPortTariffListVO();
			
			List<YardChargeVersionVO> voList = command.searchYardChargeRemark(portTariffListVO);
			
			String remark = null;
			if (voList != null && !voList.isEmpty()) {
				remark = voList.get(0).getPortTrfRmk();
			}
			eventResponse.setETCData("port_trf_rmk", remark);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**VOP_PSO_0237 : Service Provider 변경시(Key-In)
	 * VOP_PSO_0237에서 Service Provider 정보를 조회한다.
	 * @category VOP_PSO_0237_Vendor_Key-In
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVendorListCheck(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0237Event event = (VopPso0237Event)e;
			PSOCodeFinderBC command = new PSOCodeFinderBCImpl();
			
			String strVendorName = command.searchVendorName(event.getVndrSeq2());//,account);
			eventResponse.setETCData("vendor", strVendorName);
	
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{"Retrieval of Vendors"}).getMessage());
		}
		
		return eventResponse;
	}
	
//	/**VOP_PSO_0237 : Service Provider 변경시(Key-In)
//	 * VOP_PSO_0237에서 Service Provider 정보를 조회한다.
//	 * @category VOP_PSO_0237_Vendor_Key-In
//	 * @param Event e
//	 * @return EventResponse
//	 * @throws EventException
//	 */
//	private EventResponse searchVendorTariffCheck(Event e) throws EventException{
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		try{
//			VopPso0237Event event = (VopPso0237Event)e;
//			PortTariffMgtBC command = new PortTariffMgtBCImpl();
//			
//			String strExist= command.searchVendorTariffCheck(event.getVndrSeq2());//,account);
//			eventResponse.setETCData("tariff", strExist);
//			
//		}catch(EventException ex){
//			throw ex;
//		} catch(Exception ex) {
//			throw new EventException(new ErrorHandler("PSO90005", new String[]{"Retrieval of Vendors"}).getMessage());
//		}
//		
//		return eventResponse;
//	}
	
	/**VOP_PSO_0237 : yard code 입력시 validation
	 * @category VOP_PSO_0237_yard_code_key_in
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMdmYardCheck(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VopPso0237Event event = (VopPso0237Event)e;
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			
			String strExist= command.searchMdmYardCheck(event.getNewYdCd());//,account);
			eventResponse.setETCData("ydcd", strExist);
			
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{"Retrieval of Vendors"}).getMessage());
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0237 조회 이벤트 처리
	 * Yard Charge에 등록된 Remark를 조회한다.
	 * @param  Event e
	 * @return response EventResponse
	 * @exception EventException 
	 */
	private EventResponse searchYdChgNoDataInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			VopPso0237Event event = (VopPso0237Event)e;
			YdChgNoDataInfoVO ydChgNoDataInfoVO = event.getYdChgNoDataInfoVO();
			
       	
			List<YdChgNoDataInfoVO> voList = command.searchYdChgNoDataInfo(ydChgNoDataInfoVO);
			
			eventResponse.setRsVoList(voList);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0237 조회 이벤트 처리
	 * Yard Charge에 등록된 Remark를 조회한다.
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException 
	 */
	private EventResponse copyTariff(Event e ) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			PortTariffMgtBC command = new PortTariffMgtBCImpl();
			VopPso0237Event event = (VopPso0237Event)e;
			String newydcd1 = event.getNewYdCd1();
			String newydcd2 = event.getNewYdCd2();
			String newydcd3 = event.getNewYdCd3();
			String newydcd4 = event.getNewYdCd4();
			String newydcd5 = event.getNewYdCd5();
			
			begin();
			if(newydcd1.length()>0)  command.validationTariff(event.getYdChgNoDataInfoVOs(), newydcd1 );
			if(newydcd2.length()>0)  command.validationTariff(event.getYdChgNoDataInfoVOs(), newydcd2);
			if(newydcd3.length()>0)  command.validationTariff(event.getYdChgNoDataInfoVOs(), newydcd3 );
			if(newydcd4.length()>0)  command.validationTariff(event.getYdChgNoDataInfoVOs(), newydcd4 );
			if(newydcd5.length()>0)  command.validationTariff(event.getYdChgNoDataInfoVOs(), newydcd5 );
			
			
		    if(newydcd1.length()>0)  command.copyTariff(event.getYdChgNoDataInfoVOs(),account, newydcd1 );
			if(newydcd2.length()>0)  command.copyTariff(event.getYdChgNoDataInfoVOs(),account, newydcd2 );
			if(newydcd3.length()>0)  command.copyTariff(event.getYdChgNoDataInfoVOs(),account, newydcd3 );
			if(newydcd4.length()>0)  command.copyTariff(event.getYdChgNoDataInfoVOs(),account, newydcd4 );
			if(newydcd5.length()>0)  command.copyTariff(event.getYdChgNoDataInfoVOs(),account, newydcd5 );
		
			commit();
				
			eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage()); // 정상으로 저장되었습니다.

			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	
	
//	/*
//	 * CHM-201006949-01
//	 */
//	/**
//	 * 해당 Tariff를 가지는 Yard List를 구한다.
//	 * 
//	 * @category VOP_PSO_0212_Open
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse searchYardListWithTariff(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		try{
//			VopPso0212Event event = (VopPso0212Event)e;
//			PortTariffMgtBC command = new PortTariffMgtBCImpl();
//			List<TariffListWithYdNmVO> tariffList = command.searchTariffWithCostCd(event.getPortCd(), event.getCostCd());
//
//			StringBuffer data = new StringBuffer();
//
//			if(tariffList != null && tariffList.size() > 0){
//				//addEmptyData(data);
//
//				for (int i = 0; i < tariffList.size(); i++) {
//
//					//data.append(cdList.get(i).getCode());
//					data.append(tariffList.get(i).getYdCd().substring(5));
//					data.append(",");
//					//data.append(cdList.get(i).getName());
//					data.append(tariffList.get(i).getYdNm());
//					if (i < tariffList.size()-1)
//						data.append("|");
//				}
//			}
//			
//			eventResponse.setETCData("lane", data.toString());
//
//		} catch(EventException ex){
//			throw ex;
//		} catch(Exception ex) {
//			throw new EventException(new ErrorHandler("PSO90005", new String[]{""}).getMessage());
//		}
//		return eventResponse;
//	}
}