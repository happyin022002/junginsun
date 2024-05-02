/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EstimateInvoiceAuditSC.java
*@FileTitle : Requested MSA
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.26
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.20 김진일
* 1.0 Creation
* 
* History
* 2010.11.22 진마리아 CHM-201006692-01 Port charge simulation 이 터미널별로 한번에 계산이 될수 있도록 멀티 기능 추가
* 2010.11.24 이석준 CHM-201007129-01 Service provider help pop-up내 Delete 칼럼 추가
* 2011.03.28 진마리아 [선처리(SRM-201114694)] 사업계획 항비 로직 수정 요청
* 2011.06.15 진마리아 CHM-201111910-01 [PSO] Tariff Simulation By VVD 신규화면 생성
* 2012.01.10 진마리아 선처리(SRM-201222935) invoice creation 화면 오픈시 미 Confirm된 Invoice List Notice 메시지 alert
* 2012.02.01 진마리아 CHM-201215859-01 전도금 비용 수정 기능 추가 요청건(spp로부터 입력받는 전도금을 alps 화면을 통해 수정하여 저장 가능하도록)
* 2012.03.05 진마리아 CHM-201216583-01 Port Charge Invoice Creation 로직 변경 - 스케줄 존재 여부 점검 로직 추가 / KRPUS 스케줄에 대해 'Actual SKD 존재 체크' 로직 제외
* 2012.03.09 진마리아 CHM-201216307-01 Canal invoice 화면 변경 및 File download 기능 개발
* 2012.04.09 진마리아 CHM-201217036-01 SPP-Port SO/ Actual Invoice 화면 변경 및 기능, 로직 추가 - file download는 전도금이 아닌 invoice 화면으로 수정
* 2012.09.25 진마리아 CHM-201220208-01 YD/ACCT별 Detail 비용을 Excel Down 기능 추가
* 2012.11.19 이혜민   CHM-201221185-01 [PSO] 항비 입력시 skip port 에 대한 pop up 메시지 추가 요청
* 2012.11.26 진마리아 CHM-201220618-01 TPB 비용 정보 지정시 해당 정보를 TPB IF용 테이블에 저장하고 제어함
* 2013.01.24 SKY    CHM-201322525    Invoice creation 중복 account code 체크 로직 추가
* 2014.05.30 박다은 [CHM-201430328] [PSO] Port Charge invoice Creation 기능 개선
* 2014.08.05 이성훈 HJSBIZ_CR_671 [PSO] Invoice내 Exchanage Rate 칼럼 추가
* 2014.09.15 이윤정 [CHM-201430851] 전도금 invoice내 tariff Amount/Formula/Formula Expression 오류  
* 2015.05.13 김기원 CHM-201535833 [PSO] USD이외의 Local 환율적용에 따른 exchange Rate 적용
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import weblogic.wsee.util.StringUtil;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.basic.CanalTransitFeeBalanceBC;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.basic.CanalTransitFeeBalanceBCImpl;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.event.VopPso0020Event;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.event.VopPso0031Event;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.event.VopPso0032Event;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.integration.CanalTransitFeeBalanceDBDAO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.BalDiffAcctDtlVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.BalDiffAcctMstVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.BalDiffAcctVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.CanalTzFeeBalDtlVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.CanalTzFeeBalVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.GlIfDataThisMonVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.GlIfDataTtlVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.GlIfGRPVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.basic.CanalTransitFeeEstimateBC;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.basic.CanalTransitFeeEstimateBCImpl;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.event.VopPso0017Event;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.event.VopPso0018Event;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.AuditDataValidVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeEstDtlByVvdVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeSumVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeSummaryVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.basic.CanalTransitFeeInvoiceBC;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.basic.CanalTransitFeeInvoiceBCImpl;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.event.VopPso0019Event;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.event.VopPso0215Event;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event.VopPso0217Event;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event.VopPso0218Event;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.AtchFileVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeInvDtlByVvdOwnerAccountVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeInvDtlVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.basic.GeneralInvoiceAuditBC;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.basic.GeneralInvoiceAuditBCImpl;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event.VopPso0014Event;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event.VopPso0038Event;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event.VopPso0039Event;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event.VopPso0216Event;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.CalcTariffResultVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.CalcTariffVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.InvAuditDataValidVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationConditionVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationInvoiceListVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationObjectListVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffGRPVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffInfoVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TpbIfVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.basic.PortSOMasterDataMgtBC;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.basic.PortSOMasterDataMgtBCImpl;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.CurrencyVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.DefaultCostVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.DefaultVendorVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PsoInvOfcYdVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.SearchYardsVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.basic.PortTariffMgtBC;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.basic.PortTariffMgtBCImpl;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.basic.PSOCodeFinderBC;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.basic.PSOCodeFinderBCImpl;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.vo.CostListVO;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.vo.MdmVslCntrVO;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.vo.VendorListVO;
import com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBC;
import com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ApPayInvDtlVO;
import com.hanjin.syscommon.common.table.ApPayInvVO;
import com.hanjin.syscommon.common.table.PsoYdChgVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.AuditDataValidOwnerAccountVO;


/**
 * ALPS-EstimateInvoiceAudit Business Logic ServiceCommand - ALPS-EstimateInvoiceAudit 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Kim Jin Ihl
 * @see CanalTransitFeeBalanceDBDAO
 * @since J2EE 1.4
 */

public class EstimateInvoiceAuditSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * EstimateInvoiceAudit system 업무 시나리오 선행작업<br>
	 * VOP_PSO-0020업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("EstimateInvoiceAuditSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * EstimateInvoiceAudit system 업무 시나리오 마감작업<br>
	 * VOP_PSO-0020 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("EstimateInvoiceAuditSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-EstimateInvoiceAudit system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VopPso0020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				//String sFlag = ((VopPso0020Event)e).getCanalTzFeeBalVO().getOpflag();
				//if(sFlag.equals("S"))//Sum
					eventResponse = searchCanalTzFeeBal(e);
				//else if(sFlag.equals("B"))//Remittance
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {//Confirm@Click
				eventResponse = createCanalTzFeeBal(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//Confirm@Click
				eventResponse = removeCanalTzFeeBal(e);
			}
			else{//최초 폼 로드 시.. 
				//eventResponse = searchCanalTzFeeBalSum(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("VopPso0017Event")){//VOP_PSO-0017 Canal Invoce UI
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {//searchVendorList
				eventResponse = searchVendorList(e, "VopPso0017Event");
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//when Retreive button click
				eventResponse = searchCanalTzFeeSumRpt(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("VopPso0018Event")){//VOP_PSO-0018 Requested Advance Payment
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//searchCanalTzFeeEstDtlByVvd
				eventResponse = searchCanalTzFeeEstDtlByVvd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//confirm@button click	//[2010.05.11:jmh] COMMAND01 -> MULTI01
				eventResponse = createCanalTzFeeEst(e);
			}
			//else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {//ToCSR@button click
			//	eventResponse = createEstApprovalRqst(e);
			//}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {//Reject@button click	//[2010.05.11:jmh] COMMAND03 -> MODIFY
				eventResponse = cancelCanalTzFeeEst(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {//Save@button click
				eventResponse = manageCanalTzFeeRqstAmt(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("VopPso0019Event")){//VOP_PSO-0019 Requested Actual Invoice
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//searchCanalTzFeeEstDtlByVvd
				eventResponse = searchCanalTzFeeInvDtlByVvd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//save@button click
				eventResponse = createCanalTzFeeInvByVvd(e);
			}
//			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {//ToCSR@button click
//				eventResponse = createInvApprovalRqst(e);
//			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {//Reject@button click
				eventResponse = cancelCanalTzFeeInvByVvd(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("VopPso0031Event")){//VOP_PSO-0031 G/L Data
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//
				eventResponse = searchCanalTzFeeInvDtlByVvd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//List 조회 
				eventResponse = searchGlifDateByMon(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {//Service Provider Combo List 조회 
				eventResponse = searchVendorList(e, "VopPso0031Event");
			}
//			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {//ToCSR@button click
//				eventResponse = createInvApprovalRqst(e);
//			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {//Reject@button click
				eventResponse = cancelCanalTzFeeInvByVvd(e);
			}
		} 
		else if(e.getEventName().equalsIgnoreCase("VopPso0032Event")){//VOP_PSO-0032 Balance Diff. Account
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBalDiffAcct(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("VopPso0014Event")){//VOP_PSO-0014 Invoice Creation N' Audit
			if(e.getFormCommand().isCommand(FormCommand.COMMAND01)){//VOP_PSO-0014 WindowOpen시 리스트 쿼리 
				eventResponse = searchSettingInfoByUserOffice(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){//VOP_PSO-0014 Confirm Button Click
				eventResponse = createInvApprovalRqstAp(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)){//VOP_PSO-0014 VVD Level Check 
				eventResponse = checkVvdLevel(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND04)){//VOP_PSO-0014 Grid 입력 VVD Validation 
				eventResponse = checkVslPortSkdVvd(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND05)){//VOP_PSO-0014 Row 단위의 Calculation 을 실행한다. 
				eventResponse = calGeneralInvAudit(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND06)){//VOP_PSO-0014 Issue Date 선택 시 Effective Date 를 조회한다. 
				eventResponse = searchEffDateByIssDate(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND07)){//VOP_PSO-0014 CheckBox Row 단위의 Calculation 을 실행한다. 
				eventResponse = calGeneralInvAudits(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND08)){//INV No. 필드의 Change Event 시 해당 inv_no의 존재 여부를 체크한다. 
				//eventResponse = checkInvNo(e);
				eventResponse = checkDoubleInvNo(e); //2014.12.16 중복 ALERT 메세지 변경
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND09)){//유저가 입력한 VVD의 Yard가 스킵인지 확인한다.
				eventResponse = checkSkipYardInVvd(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND10)){//유저가 입력한 VVD가  해당 Vendor/Cost_ofc/Cost_cd/YD_CD에 따라서 기존 입력된 Invoice여부 체크 
				eventResponse = checkDoublePayInv(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND11)){//유저가 입력한 Service Provider 의 Currency 를 조회한다.
				eventResponse = searchCurrencyByVndrSeq(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND12)){//tonnage 배분 여부를 조회한다.
				eventResponse = searchTonnageDivFlag(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND13)){// tug boat 사용 유무  계정 확인 2015-06-18
				eventResponse = searchAddInfo(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND14)){// BAF Object 사용 유무  계정 확인 2015-12-18
				eventResponse = searchAddCharge(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)){//VOP_PSO-0014 Save Button Click 시 처리 
				eventResponse = manageGenInvAudit(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){//VOP_PSO-0014 Retrieve Button Click 시 처리 
				eventResponse = searchGenInvAudit(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.REMOVE)){//VOP_PSO-0014 Delete Button Click 시 처리 
				eventResponse = removeGenInvAudit(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){//VOP_PSO-0014 open 시 처리 
				eventResponse = searchNoConfirmInvoice(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){//VOP_PSO-0014 ATD 조회 
				eventResponse = searchAtdData(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("VopPso0038Event")){//Port Charge Simulation
			if(e.getFormCommand().isCommand(FormCommand.COMMAND01)){//조회조건 변경시, Search Tariff 
				eventResponse = getTariff(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){//Retrieve 
				eventResponse = searchSimulation(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)){//Calculate 
				eventResponse = calculateTariff(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)){//Search Provider 
				eventResponse = searchProviderBySimulation(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND04)){//Check VVD 
				eventResponse = checkVVDBySimulation(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND05)){//Search Account 
				eventResponse = searchAccountBySimulation(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){//Search Yard 
				eventResponse = searchYardList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){//Search Cost
				eventResponse = searchCostBySimulation(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){//Search Vsl Class
				eventResponse = searchVslClassListBySimulation(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("VopPso0039Event")){//Tariff Simulation By VVD
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){//Calculation
				eventResponse = searchSimulationByVvd(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("VopPso0215Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchAtchFileList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = multiAtchFile(e);	
			}
		}
		else if(e.getEventName().equalsIgnoreCase("VopPso0216Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchTpbBillType(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = checkVndr(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("VopPso0217Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchRegularAddInfo(e);
			}
		}
		
		else if(e.getEventName().equalsIgnoreCase("VopPso0218Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchLastBafRate(e);
			}
		}
		return eventResponse;
	}

	/**
	 * VOP_PSO-0038 : Port Charge Simulation <br />
	 * 주어진 조건으로 Tariff 값을 계산한다.
	 * @category VOP_PSO_0038_CalculationBtnClick
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse calculateTariff(Event e) throws EventException {
		VopPso0038Event event = (VopPso0038Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
		try{
		List<CalcTariffResultVO> calVOs = command.calculateTariff(event.getSimulationConditionVO(), event.getSimulationConditionVOs(), event.getSimulationObjectListVOs(), event.getMenualObjectVOs());
		eventResponse.setRsVoList(calVOs);
//		SimulationConditionVO vo = event.getSimulationConditionVO();
////		SimulationConditionVO[] simulationConditionVOs = event.getSimulationConditionVOs();
//		
//		SimulationObjectListVO[] autovos = event.getSimulationObjectListVOs();//Automatic VO
//		SimulationObjectListVO[] vos = event.getMenualObjectVOs();
////		int objNo = 0;
//		
//		try{
//			StringBuilder data = new StringBuilder();
//				//Calc를 위한 파라미터 Input...
//				CalcTariffVO calcTariffVO = new CalcTariffVO();
//				
//				calcTariffVO.setVslCd(vo.getVslCd());
//				calcTariffVO.setSkdVoyNo(vo.getSkdVoyNo());
//				calcTariffVO.setSkdDirCd(vo.getSkdDirCd());
//				calcTariffVO.setVvd(vo.getVslCd()+vo.getSkdVoyNo()+vo.getSkdDirCd());
//				calcTariffVO.setYdChgNo(vo.getYdChgNo());
//				calcTariffVO.setChgVerSeq(vo.getYdChgVerSeq());
//				calcTariffVO.setYdCd(vo.getYardCd());
//				calcTariffVO.setLgsCostCd(vo.getCostCd());
//				calcTariffVO.setCurrCd(vo.getCurrCd());
//				calcTariffVO.setIoFlag("OUT");
//				
//				//Manually Input 값처리 
//				if(autovos!=null){//MenualType 설정 
//					for(int i=0; i<autovos.length; i++){
//						calcTariffVO.hMap.put("["+autovos[i].getObjListNo()+"]", autovos[i].getDfltVal());
//					}
//				}
//				if(vos!=null){//MenualType 설정 
//					for(int i=0; i<vos.length; i++){
//						if(vos[i].getObjListNo().equals("77")&&vos[i].getDfltVal().indexOf("Y")!=-1){//IN
//							calcTariffVO.setIoFlag("IN");
//						}
//						if(vos[i].getObjListNo().equals("89")&&vos[i].getDfltVal().indexOf("Y")!=-1){//OUT
//							calcTariffVO.setIoFlag("OUT");
//						}
//						calcTariffVO.hMap.put("["+vos[i].getObjListNo()+"]", vos[i].getDfltVal());
//					}
//				}
//				
//				calcTariffVO.setFrom("SIMULATION");//
//				
//				CalcTariffResultVO calcVo = command.calGeneralInvAudit(calcTariffVO);
//
//				
//
//				data.append(calcVo.getTariffAmount());
//				data.append("");
//				data.append(calcVo.getDisplayFormulaDesc());
//				data.append("");
//				data.append(calcVo.getRuntimeFormulaDesc());
//				eventResponse.setETCData("CALCINFO", data.toString());
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		
		return eventResponse;
	}

//	/**
//	 * VOP_PSO-0014 : INV No. Focus Out Event <br />
//	 * VOP_PSO-0014 입력된 INV No.가 존재하는지 확인한다.
//	 * @category VOP_PSO_0014_InvNoFocusOut
//	 * @param Event e
//	 * @return EventResponse
//	 * @throws EventException
//	 * 2014.12.17 checkDoubleInvNo() 로 대체함.
//	 */
//	private EventResponse checkInvNo(Event e) throws EventException{
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		VopPso0014Event event = (VopPso0014Event)e;
//		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
//
//		try{
//			String strExist = command.checkInvNo(event.getVndrSeq(), event.getInvNo());
//			eventResponse.setETCData("ISEXIST", strExist);
//			
//		}catch(EventException ex){
//			throw ex;
//		}catch(Exception ex){
//			throw new EventException(ex.getMessage(), ex);
//		}		
//		return eventResponse;
//	}
	
	/**
	 * VOP_PSO-0014 : INV No. Focus Out Event <br />
	 * VOP_PSO-0014 입력된 INV No.가 존재하는지 확인한다. alert 메세지 상세화  2014.12.16
	 * @category VOP_PSO_0014_InvNoFocusOut
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 */
	private EventResponse checkDoubleInvNo(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();

		try{
			String strInvExist = command.checkDoubleInvNo(event.getVndrSeq(), event.getInvNo());
			eventResponse.setETCData("ISINVOEXIST", strInvExist);

			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0014 : Sheet1Change Event <br/>
	 * 유저가 입력한 VVD의 Yard가 스킵인지 확인 
	 * @category VOP_PSO_0014_Sheet1Change
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkSkipYardInVvd(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
		boolean sRet = false;
		try{
			sRet = command.checkSkipYardInVvd(event.getVslCd(), event.getSkdVoyNo(), event.getSkdDirCd(), event.getYdCd());
			eventResponse.setETCData("SKIPYARD", sRet ? "Y" : "N");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	
	/**
	 * VOP_PSO_0014 : Sheet1Change Event <br/>
	 * 유저가 입력한 VVD에 따른 Vendor/Cost_ofc/Cost_cd/YD_CD가 기존 입력된 Invoice가 있는지 체크
	 * @category VOP_PSO_0014_Sheet1Change
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkDoublePayInv(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
	     

		String vndrSeq = event.getVndrSeq();
        String costOfcCd = event.getCostOfcCd();
        String ydCd = event.getYdCd();
        String costCd =event.getLgsCostCd();
        String vslCd = event.getVslCd();
        String skdVoyNo = event.getSkdVoyNo();
        String skdDirCd = event.getSkdDirCd();
		
		
        try{
        	
        	List<String> list = command.checkDoublePayInv(vndrSeq,costOfcCd,ydCd, costCd, vslCd, skdVoyNo, skdDirCd);
//        	String checkinfo = "";
        	StringBuffer checkinfo	= new StringBuffer();
         	if(list != null && list.size() > 0){
				for (int i = 0; i < list.size(); i++) {
					checkinfo.append("|" + list.get(i));
//					checkinfo = checkinfo + "|" + list.get(i);
				}
			}
			eventResponse.setETCData("CHECKINV", checkinfo.toString());
		
		}

		catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0014 : Sheet1Change Event <br/>
	 * 유저가 입력한 VVD에 따른 Vendor/Cost_ofc/Cost_cd/YD_CD가 기존 입력된 Invoice가 있는지 체크
	 * @category VOP_PSO_0014_Sheet1Change
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCurrencyByVndrSeq(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		PortTariffMgtBC command = new PortTariffMgtBCImpl();
		
        try{
        	String currCd = command.searchCurrencyByVndrSeq(event.getVndrSeq());
			eventResponse.setETCData("CURR_CD", currCd);
		}
		catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * VOP_PSO_0014 : doActionIBSheet Event <br/>
	 * cost_calc_eff_fm_dt와 cost_calc_eff_to_dt가 존재하는지를 체크
	 * @category VOP_PSO_0014_Sheet1Change
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTonnageDivFlag(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
		
        try{
        	String tonnageFlag = command.searchTonnageDivFlag(event.getInvNo(),event.getVndrSeq());
        	eventResponse.setETCData("ISTONNAGE", tonnageFlag);
		}
		catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0014 : doActionIBSheet Event <br/>
	 * tug boat 사용 수량 object를 사용하는 계정코드 인지 확인하기 위함.
	 * @category VOP_PSO_0014_Sheet1Change
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAddInfo(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();

		
        try{
        	String addinfoFlag = command.searchAddInfo(event.getVndrSeq(),event.getYdCd(),event.getLgsCostCd(),event.getIssDt());
 
        	eventResponse.setETCData("ADDINFO", addinfoFlag);
		}
		catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0014 : doActionIBSheet Event <br/>
	 * BAF object를 사용하는 계정코드 인지 확인하기 위함.
	 * @category VOP_PSO_0014_Sheet1Change
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAddCharge(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();

		
        try{
        	String addinfoFlag = command.searchAddCharge(event.getVndrSeq(),event.getYdCd(),event.getLgsCostCd(),event.getIssDt());
 
        	eventResponse.setETCData("BAF", addinfoFlag);
		}
		catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
		
	/**
	 * VOP_PSO-0014 : Calculation Button Click <br />
	 * VOP_PSO-0014 CheckBox Row 단위의 Calculation 을 실행한다. 
	 * @category VOP_PSO_0014_CalclationButtonClick
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse calGeneralInvAudits(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();

		InvAuditDataValidVO[] auditDataValidVos = event.getAuditDataValidVOs();
		
		String currCdOfTariff  = "";		//[2010.04.14:jmh] add
		String currCdOfInvoice = "";		//[2010.04.14:jmh] add
		String issDt		   = "";		//[2010.04.14:jmh] add
		String mnlInpXchRt	   = null;		//[2014.07.28:lsh] add Exchange Rate
		
		try{
			for(int i=0; i<auditDataValidVos.length; i++){
				//log.error("\nIBFLAG>> " + (i+1) + ". " + auditDataValidVos[i].getIbflag() + " : del_chk-" + auditDataValidVos[i].getDelChk());	//[2010.02.24:jmh]
				//if(auditDataValidVos[i].getIbflag().equals("")||auditDataValidVos[i].getIbflag().equals("D")){
				if(auditDataValidVos[i].getDelChk().equals("0")){	//Checked Rows
					auditDataValidVos[i].setIoChk("N");
					continue;
				}	
				List<PsoYdChgVO> listPsoYdChg = null;
					listPsoYdChg = command.searchPsoYdChg(auditDataValidVos[i].getAcctCd(), event.getYdCd(), event.getVndrSeq(), event.getIssDt());
					if(listPsoYdChg.size() > 0 ){
						PsoYdChgVO vo = listPsoYdChg.get(0);
						log.debug("vo.getYdChgNo():="+vo.getYdChgNo());
						//vo.getYdChgVerSeq();
						//Calc를 위한 파라미터 Input...
//						HashMap<String, String> hMap = new HashMap<String, String>();
						CalcTariffVO calcTariffVO = new CalcTariffVO();
//						hMap.put("vvd",auditDataValidVos[i].getVslCd()+auditDataValidVos[0].getSkdVoyNo()+auditDataValidVos[0].getSkdDirCd());//vvd
						calcTariffVO.setVvd(auditDataValidVos[i].getVslCd()+auditDataValidVos[0].getSkdVoyNo()+auditDataValidVos[0].getSkdDirCd());
//						hMap.put("ydChgNo", vo.getYdChgNo());
						calcTariffVO.setYdChgNo(vo.getYdChgNo());
//						hMap.put("ydChgVerSeq",vo.getYdChgVerSeq());
						calcTariffVO.setYdChgVerSeq(vo.getYdChgVerSeq());
//						hMap.put("ydCd",event.getYdCd());
						calcTariffVO.setYdCd(event.getYdCd());
//						hMap.put("lgsCostCd", auditDataValidVos[i].getAcctCd());
						calcTariffVO.setLgsCostCd(auditDataValidVos[i].getAcctCd());
//						hMap.put("currCd", event.getCurrCd());
						calcTariffVO.setCurrCd(event.getCurrCd());
//						hMap.put("ioFlag", auditDataValidVos[i].getIo());//InBound/OutBound구분
						calcTariffVO.setIoFlag(auditDataValidVos[i].getIo());
						
						currCdOfInvoice = event.getCurrCd();						//[2010.04.14:jmh] add
						currCdOfTariff  = vo.getCurrCd();							//[2010.04.14:jmh] add
						issDt			= event.getIssDt().replaceAll("-", "");		//[2010.04.14:jmh] add
						mnlInpXchRt		= auditDataValidVos[i].getMnlInpXchRt();	//[2014.07.28:lsh] add Exchange Rate
						log.debug("MNL_INP_XCH_RT :: " + mnlInpXchRt);
						
						//Manually Input 값처리 
						/**
						 * 
						<o6>6</o6>	Arr. NT	Arrival No. of Tug
						<o7>7</o7>	Dep. NT	Departure No. of Tug
						<o8>8</o8>	Arr. TP	Arrival Tug Power
						<o9>9</o9>	Dep. TP	Departure Tug Power
						<o10>10</o10>	Arr. TUH	Arrival Tug Used Hour
						<o11>11</o11>	Dep.TUH	Departure Tug Used Hour
						<o17>17</o17>	Boat	Boat
						<o50>50</o50>	Arr. LH	Arrival Line Handing Hour
						<o52>52</o52>	Barge	Barge
						<o57>57</o57>	Buoy	Buoy
						<o60>60</o60>	Dep. LH	Departure Line handing Hour
						<o75>75</o75>	Holiday	Holiday
						<o78>78</o78>	Inspection	Inspection
						<o86>86</o86>	Night	Night
						<o97>97</o97>	Sanit	Sanitation
						<o110>110</o110>	TUG Rope	TUG Rope
						<o111>111</o111>	Used HRS		Used Hours
						<o119>119</o119>	New SVC		New Service
						<o176>176</o176>	BAF         BAF
						 */
//						hMap.put("[6]", auditDataValidVos[i].getArrnt());
						calcTariffVO.setArrNT(auditDataValidVos[i].getArrnt());
//						hMap.put("[7]", auditDataValidVos[i].getDepnt());
						calcTariffVO.setDepNT(auditDataValidVos[i].getDepnt());
//						hMap.put("[8]", auditDataValidVos[i].getArrtp());
						calcTariffVO.setArrTP(auditDataValidVos[i].getArrtp());
//						hMap.put("[9]", auditDataValidVos[i].getDeptp());
						calcTariffVO.setDepTP(auditDataValidVos[i].getDeptp());
//						hMap.put("[10]", auditDataValidVos[i].getArrtuh());
						calcTariffVO.setArrTUH(auditDataValidVos[i].getArrtuh());
//						hMap.put("[11]", auditDataValidVos[i].getDeptuh());
						calcTariffVO.setDepTUH(auditDataValidVos[i].getDeptuh());
//						hMap.put("[17]", auditDataValidVos[i].getBoat());
						calcTariffVO.setBoat("'"+(auditDataValidVos[i].getBoat().equals("") ? "N":auditDataValidVos[i].getBoat())+"'");
//						hMap.put("[50]", auditDataValidVos[i].getArrlh());
						calcTariffVO.setArrLH(auditDataValidVos[i].getArrlh());
//						hMap.put("[111]", auditDataValidVos[i].getUsdhrs());
						calcTariffVO.setUsdhrs(auditDataValidVos[i].getUsdhrs());
//						hMap.put("[52]", auditDataValidVos[i].getBarge());
						calcTariffVO.setBarge("'"+(auditDataValidVos[i].getBarge().equals("") ? "N":auditDataValidVos[i].getBarge())+"'");
//						hMap.put("[57]", auditDataValidVos[i].getBuoy());
						calcTariffVO.setBuoy("'"+(auditDataValidVos[i].getBuoy().equals("") ? "N":auditDataValidVos[i].getBuoy())+"'");
//						hMap.put("[60]", auditDataValidVos[i].getDeplh());
						calcTariffVO.setDepLH(auditDataValidVos[i].getDeplh());
//						hMap.put("[75]", auditDataValidVos[i].getHoliday());
						calcTariffVO.setHoliday("'"+(auditDataValidVos[i].getHoliday().equals("") ? "N":auditDataValidVos[i].getHoliday())+"'");
//						hMap.put("[78]", auditDataValidVos[i].getInspection());
						calcTariffVO.setInspection("'"+(auditDataValidVos[i].getInspection().equals("") ? "N":auditDataValidVos[i].getInspection())+"'");
//						hMap.put("[86]", auditDataValidVos[i].getNight());
						calcTariffVO.setNight("'"+(auditDataValidVos[i].getNight().equals("") ? "N":auditDataValidVos[i].getNight())+"'");
//						hMap.put("[97]", auditDataValidVos[i].getSanitation());
						calcTariffVO.setSanit("'"+(auditDataValidVos[i].getSanitation().equals("") ? "N":auditDataValidVos[i].getSanitation())+"'");
//						hMap.put("[110]", auditDataValidVos[i].getTugrope());
						calcTariffVO.setTUGRope("'"+(auditDataValidVos[i].getTugrope().equals("") ? "N":auditDataValidVos[i].getTugrope())+"'");
//						hMap.put("[119]", auditDataValidVos[i].getNewservice());
						calcTariffVO.setNewservice("'"+(auditDataValidVos[i].getNewservice().equals("") ? "N":auditDataValidVos[i].getNewservice())+"'");
						calcTariffVO.setBafRt("'"+(auditDataValidVos[i].getNewservice().equals("") ? "N":auditDataValidVos[i].getNewservice())+"'");
						calcTariffVO.setBafRt(auditDataValidVos[i].getBafRt());	
						
						CalcTariffResultVO calcVo = command.calGeneralInvAudit(calcTariffVO);
		
						//>>Currency Conversion		[2010.04.14:jmh] add
						int rowsNumberOfDesc = Integer.parseInt(calcVo.getPagerows());
						if(!currCdOfTariff.equals(currCdOfInvoice)){		//Tariff Curr와 Invoice Curr이 다르면
							String div = "";	//USD2Local or Local2USD
							String amt = calcVo.getTariffAmount();
							String currCd = "";
							boolean exec = true;
							
							if(currCdOfInvoice.equals("USD")){
								div = "Local2USD";
								currCd = currCdOfTariff;
							} else if(currCdOfTariff.equals("USD")){
								div = "USD2Local";
								currCd = currCdOfInvoice;
							} else{	//USD가 아닌 다른 통화끼리의 변환은 금지
								exec = false;	
							}
							
							if (exec) {
								String[] arrConversion = null;
								if (!StringUtil.isEmpty(mnlInpXchRt)) {
									arrConversion = command.searchConvertedAmountByXchRt(div, amt, mnlInpXchRt, currCd);//arrConversion[0] : convertedAmt, arrConversion[1] : exchangeRate
								}
								else {
									arrConversion = command.searchConvertedAmount(div, amt, issDt, currCd);	//arrConversion[0] : convertedAmt, arrConversion[1]
								}
								//log.error("\nConvertedAmount>> " + arrConversion[0] + " : " + arrConversion[1]);
								//변환된 금액과 Description을 calcVo에 setting함
								calcVo.setTariffAmount(arrConversion[0]);
								calcVo.setRuntimeFormulaDesc(calcVo.getRuntimeFormulaDesc() + "\n[R]: " + arrConversion[1]);	//Formula in Sheet
								calcVo.setDisplayFormulaDesc(calcVo.getDisplayFormulaDesc() + "\n[R]: " + arrConversion[1]);	//Formula Value in Sheet
								rowsNumberOfDesc++;
							}
						}
						
						if(rowsNumberOfDesc == 3){
							calcVo.setRuntimeFormulaDesc(calcVo.getRuntimeFormulaDesc() + "\n");
							calcVo.setDisplayFormulaDesc(calcVo.getDisplayFormulaDesc() + "\n");
						}
						//log.error("\n" + "rowsNumberOfDesc : " + rowsNumberOfDesc);
						//<<Currency Conversion
						
						auditDataValidVos[i].setTariffCost(calcVo.getTariffAmount());
						auditDataValidVos[i].setFoml2(calcVo.getDisplayFormulaDesc());
						auditDataValidVos[i].setFoml1(calcVo.getRuntimeFormulaDesc());
						
						auditDataValidVos[i].setYdChgNo(vo.getYdChgNo());
						auditDataValidVos[i].setYdChgVerSeq(vo.getYdChgVerSeq());
				    	// 2010.08.23 이준범    
						if(calcVo.existObj(77) || calcVo.existObj(89)){
							auditDataValidVos[i].setIoChk("Y");
						} else {
							auditDataValidVos[i].setIoChk("N");
						}
					}
			}
			eventResponse.setRsVoList(Arrays.asList(auditDataValidVos));
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0014 : Confirm Button Click <br />
	 * Invoice Creation & Audit 화면의 Confirm Button 클릭 시 처리를 한다.<br />
	 * @category VOP_PSO_0014_ConfirmButtonClick
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createInvApprovalRqstAp(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
		CSRExternalFinderBC command2 = new CSRExternalFinderBCImpl(); 
		log.error("\n createInvApprovalRqstAp START!!");
		InvAuditDataValidVO[] fileSrchVOs = event.getAuditDataValidVOs();
		log.error("\n fileSrchVOs>"+fileSrchVOs.length);
		try{
			begin();
			log.error("\n SC ===> fileSrchYdChgNos START!!");
			//20141029 HDS > Tariff File 객체 COPY 위하여 YD_CHG_NO를 구해와서 FILE_SAV_ID, FILE_PATH_URL구하고 /a_upload/FILE/GW_CSR_APRO 폴더로 카피
			command.fileSrchYdChgNos(fileSrchVOs);
			log.error("\n SC ===> fileSrchYdChgNos END!!");
			//우선 데이터 그리드에 변경 정보가 있으면 저장한다.
			if (fileSrchVOs != null){
				if (fileSrchVOs.length > 0) {
					InvAuditDataValidVO[] vos = fileSrchVOs;
					
					//for(InvAuditDataValidVO vo1 : vos){
					//	vo1.setPsoChgStsCd("A");
					//}
					command.manageGenInvAudit(vos);
				}
			}
			
			InvAuditDataValidVO vo = event.getInvAuditDataValidVO();
//			command.createInvApprovalRqstAp(event.getInvAuditDataValidVO());
			
			ApPayInvVO apPayInvVO = command.searchApPayInv(event.getInvAuditDataValidVO());
			String VvdDivFlag = command.searchTonnageDiv(event.getInvAuditDataValidVO());
			
			ApPayInvDtlVO[] apPayInvDtlVOs = null;
			
			if(VvdDivFlag.equals("Y")) {
				apPayInvDtlVOs = command.searchApPayInvDtlDiv(event.getInvAuditDataValidVO());	
	  		 }
			else {
				apPayInvDtlVOs = command.searchApPayInvDtl(event.getInvAuditDataValidVO());
			}			
					
			for(int i=0; i<apPayInvDtlVOs.length; i++){
				apPayInvDtlVOs[i].setIbflag("I");
			}
			
			String strInvRgstNo = command2.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);
			
		
			//Return 받은 INV_RGST_NO를  PSO_CHAREGE TAble에 update 
			if(!strInvRgstNo.equals("")){
				vo.setInvRgstNo(strInvRgstNo);
				vo.setPsoChgStsCd("A");//Approved 로 변경 
				command.updatePsoCharge(vo);
			}
			else{
				eventResponse.setUserMessage(new ErrorHandler("PSO90013").getUserMessage());//strInvRgstNo를 받아오지 못했을 경우 
			}
			
			eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
			
			//rollback();
			commit();
		}catch(EventException ex){
			eventResponse.setETCData("ERRCODE", "PSO90007");
			eventResponse.setUserMessage(new ErrorHandler("PSO90007").getUserMessage());
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0014 : Grid Account Cd Change <br />
	 * Invoice Creation & Audit 화면의 그리드에서 Account Code 변경 시 처리를 한다.<br />
	 * @category VOP_PSO_0014_VvdLevelCheck
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkVvdLevel(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
		try{
			String strChkVvd = command.checkVvdLevel(event.getInvAuditDataValidVO());
			eventResponse.setETCData("VALIDVVD", strChkVvd);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0014 : Delete Button Click <br />
	 * Invoice Creation & Audit 화면에서 Delete Button Click 시 처리를 한다.<br />
	 * @category VOP_PSO_0014_DELETEBTTNCLICK
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeGenInvAudit(Event e) throws EventException{
	GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
		CSRExternalFinderBC command2 = new CSRExternalFinderBCImpl(); 
		
		try{
			//≪≫ removeGenInvAudit ( vndrSeq, invNo ) 
			begin();
			if(event.getPsoChgStsCd().equals("A")){//Confirm 되었을 경우 
				//AP_PAY_INV.CSR_NO 값이 존재하면 삭제 불가 //--> 존재 여부 확인할 필요 없다고 해서 제거 함. 2009.11.25.
//				boolean bRet = command.checkApPayInv(event.getVndrSeq(), event.getYdCd(), event.getInvNo());
//				if(!bRet){//AP_PAY_INV.CSR_NO 값이 존재하지 않으면 삭제 처리
					ApPayInvVO apPayInvVO = command.searchApPayInv(event.getInvAuditDataValidVO());
					ApPayInvDtlVO[] apPayInvDtlVOs = null;
					String VvdDivFlag = command.searchTonnageDiv(event.getInvAuditDataValidVO());
					
					if(VvdDivFlag.equals("Y"))
					{
						apPayInvDtlVOs = command.searchApPayInvDtlDiv(event.getInvAuditDataValidVO());	
					}
					else {
						apPayInvDtlVOs = command.searchApPayInvDtl(event.getInvAuditDataValidVO());
					}	
					
					
					for(int i=0; i<apPayInvDtlVOs.length; i++){
						apPayInvDtlVOs[i].setIbflag("U");
						apPayInvDtlVOs[i].setDeltFlg("Y");
					}
					
					command2.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);
					
					//우리쪽 Delete 처리 
					//command.removeGenInvAudit(event.getVndrSeq(), event.getYdCd(), event.getInvNo());
					//>>[2010.02.18:jmh]
					InvAuditDataValidVO vo = event.getInvAuditDataValidVO();
					vo.setInvRgstNo("");
					vo.setPsoChgStsCd("I");	//A->I로 변경 
					vo.setVndrSeq(event.getVndrSeq());
					vo.setYdCd(event.getYdCd());
					vo.setInvNo(event.getInvNo());
					command.updatePsoCharge(vo);
					//<<[2010.02.18:jmh]
					
					eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());//Saved Successfully 
//				}
//				else{
//					throw new EventException(new ErrorHandler("PSO90014").getMessage());//삭제 불가 Message 표시
//				}
			}
			else{//Confirm 이외 
				command.removeGenInvAudit(event.getVndrSeq(), event.getYdCd(), event.getInvNo());

				//removeGenInvAudit method는 canal쪽에서 사용하므로, 따로 추가함.
				command.removeTpbInv(event.getInvAuditDataValidVO().getIssCtyCd(), event.getInvAuditDataValidVO().getSoSeq());
			}
//			eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
//			rollback();
			commit();
		}catch(EventException ex){
//			eventResponse.setETCData("ERRCODE", "PSO90007");
//			eventResponse.setUserMessage(new ErrorHandler("PSO90007").getUserMessage());
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0014 : Retrieve Button Click <br/>
	 * Invoice Creation & Audit 화면에서 Retrieve Button Click 시 조회 처리를 한다.<br />
	 * @category VOP_PSO_0014_RetrieveButtonClick
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchGenInvAudit(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
		List<InvAuditDataValidVO> list = null;
		
		try{
			//≪≫ searchGenInvAudit ( [in] invAuditDataValidVO : InvAuditDataValidVO ) : InvAuditDataValidVO []
			list = command.searchGenInvAudit(event.getInvAuditDataValidVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Invoice Creation & Audit 화면에서 Save Button Click 시 저장처리를 한다.<br />
	 * @category VOP_PSO_0014_SaveButtonClick
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageGenInvAudit(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();

		try{
			begin();
			command.manageGenInvAudit(event.getAuditDataValidVOs());
			eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0014 : select Issue Date <br/>
	 * Invoice Creation & Audit 화면에서 Issue Date 선택 시 Effective Date 를 조회한다.<br />
	 * @category VOP_PSO_0014_OnChangeIssueDate
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchEffDateByIssDate(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
//		List<DefaultCostVO> list = null;
		try{
			//searchEffDateByIssDate ( [in] issueDt : String , [in] ofcCd : String ) : String
			String strEffDt = command.searchEffDateByIssDate(event.getRcvDt(), account.getOfc_cd());
			eventResponse.setETCData("EFFDT", strEffDt);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 *  VOP_PSO_0014 : Caculation Tariff <br/>
	 * Invoice Creation & Audit 화면에서 Tariff 계산을 실행 한다.<br />
	 * @category VOP_PSO_0014_OnGridCostCdChange
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse calGeneralInvAudit(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();

//		List<DefaultCostVO> list = null;
		List<PsoYdChgVO> listPsoYdChg = null;
		
		String currCdOfTariff  = "";		//[2010.04.14:jmh] add
		String currCdOfInvoice = "";		//[2010.04.14:jmh] add
		String issDt		   = "";		//[2010.04.14:jmh] add
		String mnlInpXchRt	   = null;		//[2014.07.29:lsh] add
		
		try{
			listPsoYdChg = command.searchPsoYdChg(event.getLgsCostCd(), event.getYdCd(), event.getVndrSeq(), event.getIssDt());
			StringBuilder data = new StringBuilder();
			if (listPsoYdChg.size() > 0) {
				PsoYdChgVO vo = listPsoYdChg.get(0);
				log.debug("vo.getYdChgNo():="+vo.getYdChgNo());
				//Calc를 위한 파라미터 Input...
				CalcTariffVO calcTariffVO = new CalcTariffVO();
				
				calcTariffVO.setVslCd(event.getVslCd());
				calcTariffVO.setSkdVoyNo(event.getSkdVoyNo());
				calcTariffVO.setSkdDirCd(event.getSkdDirCd());
				calcTariffVO.setVvd(event.getVslCd()+event.getSkdVoyNo()+event.getSkdDirCd());
				calcTariffVO.setYdChgNo(vo.getYdChgNo());
				calcTariffVO.setChgVerSeq(vo.getYdChgVerSeq());
				calcTariffVO.setYdCd(event.getYdCd());
				calcTariffVO.setLgsCostCd(event.getLgsCostCd());
				calcTariffVO.setCurrCd(event.getCurrCd());
				calcTariffVO.setIoFlag(event.getIoFlag());
				
				currCdOfInvoice = event.getCurrCd();	//[2010.04.14:jmh] add
				currCdOfTariff  = vo.getCurrCd();		//[2010.04.14:jmh] add
				issDt			= event.getIssDt().replaceAll("-", "");		//[2010.04.14:jmh] add

//				InvAuditDataValidVO[] auditDataValidVos = event.getAuditDataValidVOs();
				
				InvAuditDataValidVO ivo = event.getInvAuditDataValidVO();
				mnlInpXchRt		= ivo.getMnlInpXchRt().replaceAll(",", "");	//[2014.07.29:lsh] add				
//				int i = Integer.parseInt(event.getRowIdx());
//				i--;
//				
				//Manually Input 값처리 
				/**
				 * 
				<o6>6</o6>	Arr. NT	Arrival No. of Tug
				<o7>7</o7>	Dep. NT	Departure No. of Tug
				<o8>8</o8>	Arr. TP	Arrival Tug Power
				<o9>9</o9>	Dep. TP	Departure Tug Power
				<o10>10</o10>	Arr. TUH	Arrival Tug Used Hour
				<o11>11</o11>	Dep.TUH	Departure Tug Used Hour
				<o17>17</o17>	Boat	Boat
				<o50>50</o50>	Arr. LH	Arrival Line Handing Hour
				<o52>52</o52>	Barge	Barge
				<o57>57</o57>	Buoy	Buoy
				<o60>60</o60>	Dep. LH	Departure Line handing Hour
				<o75>75</o75>	Holiday	Holiday
				<o78>78</o78>	Inspection	Inspection
				<o86>86</o86>	Night	Night
				<o97>97</o97>	Sanit	Sanitation
				<o110>110</o110>	TUG Rope	TUG Rope
				<o119>119</o119>	New SVC		New Service
				<o176>176</o176>    BAF Rate    BAF Rate
				 */
//				hMap.put("[6]", auditDataValidVos[i].getArrnt());
				log.debug("ivo.getArrnt"+ivo.getArrnt());
				log.debug("ivo.getDepnt"+ivo.getDepnt());
				log.debug("ivo.getBafRt***"+ivo.getBafRt());
						
				calcTariffVO.setArrNT(ivo.getArrnt());
//				hMap.put("[7]", auditDataValidVos[i].getDepnt());
				calcTariffVO.setDepNT(ivo.getDepnt());
//				hMap.put("[8]", auditDataValidVos[i].getArrtp());
				calcTariffVO.setArrTP(ivo.getArrtp());
//				hMap.put("[9]", auditDataValidVos[i].getDeptp());
				calcTariffVO.setDepTP(ivo.getDeptp());
//				hMap.put("[10]", auditDataValidVos[i].getArrtuh());
				calcTariffVO.setArrTUH(ivo.getArrtuh());
//				hMap.put("[11]", auditDataValidVos[i].getDeptuh());
				calcTariffVO.setDepTUH(ivo.getDeptuh());
//				hMap.put("[17]", auditDataValidVos[i].getBoat());
				calcTariffVO.setBoat("'"+(ivo.getBoat().equals("") ? "N":ivo.getBoat())+"'");
//				hMap.put("[50]", ivo.getArrlh());
				calcTariffVO.setArrLH(ivo.getArrlh());
//				hMap.put("[52]", ivo.getBarge());
				calcTariffVO.setBarge("'"+(ivo.getBarge().equals("") ? "N":ivo.getBarge())+"'");
//				hMap.put("[57]", ivo.getBuoy());
				calcTariffVO.setBuoy("'"+(ivo.getBuoy().equals("") ? "N":ivo.getBuoy())+"'");
//				hMap.put("[60]", ivo.getDeplh());
				calcTariffVO.setDepLH(ivo.getDeplh());
//				hMap.put("[75]", ivo.getHoliday());
				calcTariffVO.setHoliday("'"+(ivo.getHoliday().equals("") ? "N":ivo.getHoliday())+"'");
//				hMap.put("[78]", ivo.getInspection());
				calcTariffVO.setInspection("'"+(ivo.getInspection().equals("") ? "N":ivo.getInspection())+"'");
//				hMap.put("[86]", ivo.getNight());
				calcTariffVO.setNight("'"+(ivo.getNight().equals("") ? "N":ivo.getNight())+"'");
//				hMap.put("[97]", ivo.getSanitation());
				calcTariffVO.setSanit("'"+(ivo.getSanitation().equals("") ? "N":ivo.getSanitation())+"'");
//				hMap.put("[110]", ivo.getTugrope());
				calcTariffVO.setTUGRope("'"+(ivo.getTugrope().equals("") ? "N":ivo.getTugrope())+"'");
//				hMap.put("[119]", ivo.getNewservice());
				calcTariffVO.setNewservice("'"+(ivo.getNewservice().equals("") ? "N":ivo.getNewservice())+"'");
//				hMap.put("[176]", ivo.getBafRt());
				calcTariffVO.setBafRt(ivo.getBafRt());				
				
				CalcTariffResultVO calcVo = command.calGeneralInvAudit(calcTariffVO);
				
				//>>Currency Conversion		//[2010.04.14:jmh] add
				int rowsNumberOfDesc = Integer.parseInt(calcVo.getPagerows());
				if (!currCdOfTariff.equals(currCdOfInvoice)) {		//Tariff Curr와 Invoice Curr이 다르면
					String div = "";	//USD2Local or Local2USD
					String amt = calcVo.getTariffAmount();
					String currCd = "";
					String bcurrCd = "";
					boolean exec = true;

			
					if (currCdOfInvoice.equals("USD")) {
						div = "Local2USD";
						currCd = currCdOfTariff;
					} 
					else if (currCdOfTariff.equals("USD")) {
						div = "USD2Local";
						currCd = currCdOfInvoice;
					} 
					
					else {	//USD가 아닌 다른 통화끼리의 변환은 금지..LOCAL --> USD  ---> INVOICE CURRENCY 2015.05.12
						exec = false;					
						div = "Local2"+currCdOfInvoice;
						bcurrCd = currCdOfTariff;
						currCd  = currCdOfInvoice;
					 
						String[] arrConversionOther = null;
						if (StringUtil.isEmpty(ivo.getMnlInpXchRt())) {
							arrConversionOther = command.searchConvertedAmountOther( amt, issDt, bcurrCd, currCd);	//arrConversionOther[0] : convertedAmt, arrConversionOther[1] : exchangeRate
					        log.debug("arrConversionOther++"+arrConversionOther);
						}
						else {
							arrConversionOther = command.searchConvertedAmountOtherByXchRt( amt, mnlInpXchRt, bcurrCd,currCd);//arrConversionOther[0] : convertedAmt, arrConversionOther[1] : exchangeRate
							 log.debug("arrConversionOther222++"+arrConversionOther);
						}
						
						//변환된 금액과 Description을 calcVo에 setting함
						calcVo.setTariffAmount(arrConversionOther[0]);
						//calcVo.setRuntimeFormulaDesc(calcVo.getRuntimeFormulaDesc() + "\n[R]: " + arrConversionOther[1]);	//Formula in Sheet 
					 	//calcVo.setDisplayFormulaDesc(calcVo.getDisplayFormulaDesc() + "\n[R]: " + arrConversionOther[1]);	//Formula Value in Sheet
						calcVo.setRuntimeFormulaDesc(calcVo.getRuntimeFormulaDesc());	//Formula in Sheet 
						calcVo.setDisplayFormulaDesc(calcVo.getDisplayFormulaDesc());	//Formula Value in Sheet
						calcVo.setExchgRate(arrConversionOther[2]);
						
						rowsNumberOfDesc++;
					}
					
					if (exec) {
						String[] arrConversion = null;

						if (StringUtil.isEmpty(ivo.getMnlInpXchRt())) {
							arrConversion = command.searchConvertedAmount(div, amt, issDt, currCd);	//arrConversion[0] : convertedAmt, arrConversion[1] : exchangeRate
						}
						else {
							arrConversion = command.searchConvertedAmountByXchRt(div, amt, mnlInpXchRt, currCd);//arrConversion[0] : convertedAmt, arrConversion[1] : exchangeRate
						}
						//log.error("\nConvertedAmount>> " + arrConversion[0] + " : " + arrConversion[1]);
						//변환된 금액과 Description을 calcVo에 setting함
						calcVo.setTariffAmount(arrConversion[0]);
						//calcVo.setRuntimeFormulaDesc(calcVo.getRuntimeFormulaDesc() + "\n[R]: " + arrConversion[1]);	//Formula in Sheet 
						//calcVo.setDisplayFormulaDesc(calcVo.getDisplayFormulaDesc() + "\n[R]: " + arrConversion[1]);	//Formula Value in Sheet
						calcVo.setRuntimeFormulaDesc(calcVo.getRuntimeFormulaDesc());	//Formula in Sheet 
						calcVo.setDisplayFormulaDesc(calcVo.getDisplayFormulaDesc());	//Formula Value in Sheet
						calcVo.setExchgRate(arrConversion[2]);
						
						rowsNumberOfDesc++;
					}
				}
				
				if (rowsNumberOfDesc == 3) {
					calcVo.setRuntimeFormulaDesc(calcVo.getRuntimeFormulaDesc());
					calcVo.setDisplayFormulaDesc(calcVo.getDisplayFormulaDesc());
				}
				
				//log.error("\n" + "rowsNumberOfDesc : " + rowsNumberOfDesc);
				//<<Currency Conversion
				data.append(calcVo.getTariffAmount());
				data.append("");
				data.append(calcVo.getDisplayFormulaDesc());
				data.append("");
				data.append(calcVo.getRuntimeFormulaDesc());
				data.append("");
				data.append(vo.getYdChgNo());
				data.append("");
				data.append(vo.getYdChgVerSeq());
				data.append("");

				// 2010.08.23 이준범 OPMS Ticket ID : CHM-201005473-01
				// Comment: Tariff에 "IN" 혹은 "OUT"의 Condition이 있을때 사용 하도록 되어 있는데
				//          Condition이 없더라도 사용하고 있어 해당 칼럼을 Account를 선택시 해당 account로
				//          등록된 Tariff을 읽어서 Condition에 IN/OUT이 있을때만 해당 칼럼을 활성화하도록 
				//          로직 수정
				if(calcVo.existObj(77) || calcVo.existObj(89)){
					data.append("Y");
				} else {
					data.append("N");
				}
				
				//======================================================================================
				// 수정일시 : 2014.07.28
				// 수정내용 : 화면(0014)에서 선택한 Currency와 Tariff Currency를 비교하기 위해서 추가함.
				//            Currency 가 다를 경우, Exchage Rate는 필수입력상태가 된다.
				//======================================================================================
				data.append("");				
				data.append(currCdOfTariff);
				//======================================================================================
				
				//======================================================================================
				// 수정일시 : 2015.05.13
				// 수정내용 : EXCHANGE RATE를 보여주기 위함.
				//======================================================================================
				data.append("");	
				data.append(calcVo.getExchgRate());
				
				
				//log.error("\nJMH>>CALCINFO : " + data.toString());
				eventResponse.setETCData("CALCINFO", data.toString());
			}
			else{
				eventResponse.setETCData("CALCINFO", "NO_TARIFF_FOUND");
			}
		}catch(EventException ex){
			log.error("\n\nd^^b : " + ex);
			throw ex;
		}catch(Exception ex){
			log.error("\n\nd^^b : " + ex);
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/*
	 * CHM-201007129-01
	 */
	/**
	 * VOP_PSO_0014 : Window Open <br/>
	 * Invoice Creation & Audit 화면의 초기 데이터 쿼리
	 * @category VOP_PSO_0014_WndowsOpen
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSettingInfoByUserOffice(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		VopPso0014Event event = (VopPso0014Event)e;
		PortSOMasterDataMgtBC command = new PortSOMasterDataMgtBCImpl();
		List<DefaultCostVO> list = null;
		List<PsoInvOfcYdVO> list2 = null;
		List<CurrencyVO> list3 = null;
		List<DefaultVendorVO> list4 = null;
		try{
			//searchOfficeCosts ( [in] ofcCd : String , [in] chrgTypeCd : String ) : DefaultCostVO []
			list = command.searchOfficeCosts(account.getOfc_cd(), "");
			//≪≫ searchOfficeYards ( [in] ofcCd : String ) : PsoInvOfcYdVO[]
			list2 = command.searchOfficeYards(account.getOfc_cd());
//			eventResponse.setRsVoList(list);
			list3 = command.searchCurrency();
//			≪≫ searchOfficeVendors ( [in] ofcCd : String ) : DefaultVendorVO []
			list4 = command.searchOfficeVendors(account.getOfc_cd());
			                                                                  
			StringBuilder data = new StringBuilder();
			
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
			
					data.append(list.get(i).getAcctCd());
					data.append("");
					data.append(list.get(i).getLgsCostCd());
					data.append("");
					data.append(list.get(i).getLgsCostFullNm());
					data.append("");
					data.append(list.get(i).getPagerows());
					if (i < list.size() - 1)
						data.append("|");
				}
			}
			eventResponse.setETCData("ACCTCOSTCDLIST", data.toString());
			
			data.setLength(0);
			if (list2 != null && list2.size() > 0) {
				for (int i = 0; i < list2.size(); i++) {
			
					data.append(list2.get(i).getYdCd1());//yd_cd
					data.append("");
					data.append(list2.get(i).getYdCd2());//yd_nm
					data.append("");
					data.append(list2.get(i).getOfcCd());//ofc_cd
					data.append("");
					data.append(list2.get(i).getCurrCd());//curr_cd
					if (i < list2.size() - 1)
						data.append("|");
				}
			}
			eventResponse.setETCData("YDCDLIST", data.toString());
			
			data.setLength(0);
			if (list3 != null && list3.size() > 0) {
				for (int i = 0; i < list3.size(); i++) {
					
					data.append(list3.get(i).getCurrCd());
					data.append("");
					data.append(list3.get(i).getCurrNm());
					data.append("");
					data.append(list3.get(i).getCntCd());
					data.append("");
					data.append(list3.get(i).getDpPrcsKnt());	//[2010.04.21:jmh]
					if (i < list3.size() - 1)
						data.append("|");
				}
			}
			eventResponse.setETCData("CURRENCYLIST", data.toString());
			
			data.setLength(0);
			if (list4 != null && list4.size() > 0) {
				for (int i = 0; i < list4.size(); i++) {
					
					data.append(list4.get(i).getVndrSeq());
					data.append("");
					data.append(list4.get(i).getVndrLglEngNm());
					data.append("");
					data.append(list4.get(i).getDeltFlg()); // [2010.11.24]CHM-201007129-01
					if (i < list4.size() - 1)
						data.append("|");
				}
			}
			eventResponse.setETCData("VENDORLIST", data.toString());
			
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0014 : AfterEdit Grid VVD <br/>
	 * 유저가 입력한 VVD가 VSK_VSL_PORT_SKD에 존재하는 가 확인 
	 * @category VOP_PSO_0014_GridVVDCheck
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkVslPortSkdVvd(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		PSOCodeFinderBC command = new PSOCodeFinderBCImpl();
		try{
			boolean skdRet = command.checkVslSkdVvd(event.getVslCd(), event.getSkdVoyNo(), event.getSkdDirCd(), event.getYdCd());
			boolean bRet = false;
			String turnPortIndCd = "";
			
			if(skdRet){
				bRet = command.checkVslPortSkdVvd(event.getVslCd(), event.getSkdVoyNo(), event.getSkdDirCd(), event.getYdCd());
				if(bRet && !event.getVslCd().equals("") && !event.getSkdVoyNo().equals("") && !event.getSkdDirCd().equals("")){// TURN_PORT_IND_CD Check
					turnPortIndCd = command.getTurnPortIndCd(event.getVslCd(), event.getSkdVoyNo(), event.getSkdDirCd(), event.getYdCd());
				}
			}
			
			eventResponse.setETCData("TURNPORTINDCD", turnPortIndCd);
			eventResponse.setETCData("ISEXIST", bRet ? "Y" : "N");
			eventResponse.setETCData("SKDEXIST", skdRet ? "Y" : "N");
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0019 : ToCSR Button Click <br>
	 * 등록한 Invoice 정보에 대해서 CSR 생성 및 승인 요청을 받을 수 있도록  정보를 공통 Table 에 제공함<br>
	 * @category  VOP_PSO_0019_ToCSRButtonClick
	 * @param Event e
	 * @return EventResponse
	 */
//	private EventResponse createInvApprovalRqst(Event e) throws EventException{
//		// TODO Auto-generated method stub
//		return null;
//	}

	/**
	 * VOP_PSO_0019 : Reject Button Click <br>
	 * 요청된 Invoice정보를 Reject한다.<br>
	 * @category VOP_PSO_0019_rejectButtonClick
	 * @param Event e
	 * @return EventResponse
	 */
	private EventResponse cancelCanalTzFeeInvByVvd(Event e) throws EventException{
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0019Event event = (VopPso0019Event)e;
		CanalTransitFeeEstimateBC command = new CanalTransitFeeEstimateBCImpl();
		GeneralInvoiceAuditBC command2 = new GeneralInvoiceAuditBCImpl();
		CSRExternalFinderBC command3 = new CSRExternalFinderBCImpl(); 

		try{
			begin();
			//Cancel처리 
			AuditDataValidOwnerAccountVO[] auditDataValidOwnerAccountVOs = event.getAuditDataValidOwnerAccountVOs();
			event.getCanalTzFeeEstDtlByVvdCondVO().setCnlTzBztpCd("I");//Invoice업무로설정
			event.getCanalTzFeeEstDtlByVvdCondVO().setUpdUsrId(account.getUsr_id());//Update UserID설정
		
			command.cancelCanalTzFeeEst ( event.getCanalTzFeeEstDtlByVvdCondVO() );
		    
			//Remark Update
			command.modifyRemark(event.getAuditDataValidVOs());
			
			if(auditDataValidOwnerAccountVOs != null) {
			  //Remark Update
		  	   command.modifyRemarkOwnerAccount(event.getAuditDataValidOwnerAccountVOs());
			}
			
			if(event.getCanalTzFeeEstDtlByVvdCondVO().getSts().equals("10")){//Confirmed 인 경우 만
				//PSO_CHARGE/PSO_CHG_DTL/ApPayInvInfo --> Record삭제 처리 by inv_no
				//우리쪽 Delete 처리 
				command2.removeGenInvAudit(event.getCanalTzFeeEstDtlByVvdCondVO().getVndrSeq(), event.getCanalTzFeeEstDtlByVvdCondVO().getYdCd(), event.getInvNo());
			
				ApPayInvVO apPayInvVO = new ApPayInvVO();
				ApPayInvDtlVO[] apPayInvDtlVOs = new ApPayInvDtlVO[1];
				
				apPayInvVO.setInvIssDt(account.getUpd_dt());
				apPayInvVO.setInvRgstNo(event.getInvRgstNo());
				apPayInvVO.setInvSubSysCd("PSO");
				apPayInvVO.setInvOfcCd(account.getOfc_cd());
				apPayInvVO.setDeltFlg("Y");
				
				apPayInvDtlVOs[0] = new ApPayInvDtlVO(); 
				apPayInvDtlVOs[0].setIbflag("U");
				
				command3.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);
			    //<<----------------------
			}
			eventResponse.setETCData("calcelResult", "OK");
//			rollback();
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0019 : Confirm Button Click <br>
	 * 운하 대리점에 해당 월에 통항 대상이 VVD에 대해서 Invoice를 등록한다.<br>
	 * @category VOP_PSO_0019_ConfirmButtonClick
	 * @param Event e
	 * @return EventResponse
	 */
	private EventResponse createCanalTzFeeInvByVvd(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0019Event event = (VopPso0019Event)e;
		CanalTransitFeeEstimateBC command = new CanalTransitFeeEstimateBCImpl();
		GeneralInvoiceAuditBC command1= new GeneralInvoiceAuditBCImpl();
		CSRExternalFinderBC command2 = new CSRExternalFinderBCImpl();
		GeneralInvoiceAuditBC command3 = new GeneralInvoiceAuditBCImpl();
//		HashMap<String, String> hMap = new HashMap<String, String>();
		try{
			//TODO 임플리먼트 필요
			String strInvNo = command.createCanalTzFeeEst(event.getCanalTzFeeHdVO());
			eventResponse.setETCData("invoiceNo", strInvNo);
			//InvoiceData를 실제로 생성하는 로직.
			//생성된 inv_no를 셋트 해 준다. 
			AuditDataValidVO[] auditDataValidVOs = event.getAuditDataValidVOs();
			AuditDataValidOwnerAccountVO[] auditDataValidOwnerAccountVOs = event.getAuditDataValidOwnerAccountVOs();

			if(auditDataValidVOs==null){
				eventResponse.setETCData("invoiceNo", "");
				rollback();
				return eventResponse;//아무일도 하지 않음 
			}
			for(int i=0; i<auditDataValidVOs.length;i++){
				auditDataValidVOs[i].setVvd(event.getCanalTzFeeHdVO().getVvd());
				auditDataValidVOs[i].setCnlTzBztpCd("I");//Invoice 업무로 설정
				auditDataValidVOs[i].setInvNo(strInvNo);
				auditDataValidVOs[i].setVndrSeq(event.getCanalTzFeeHdVO().getVndrSeq());
				
				auditDataValidVOs[i].setCreUsrId(account.getUsr_id());
				auditDataValidVOs[i].setUpdUsrId(account.getUsr_id());
				//TODO 이것이 맞는지 확인 필요
				auditDataValidVOs[i].setOfcCd("PUSMOV");//account.getOfc_cd());//
				
			}
			
			
			begin();
			
			//PSO_CHARGE를 먼저 INSERT한다. 
			command1.manageGenInvAudit (event.getAuditDataValidVOs() );
			
			//Step1.PSO_CNL_TZ_FEE_DTL의 항목을 UPDATE한다.
			//Step4.PSO_CNL_TZ_FEE의 Status코드를 A(Approved)로 UPdate한다.
			command.manageCanalTzFee(auditDataValidVOs);
			
			//Step4.PSO_CNL_TZ_FEE의 OA비용이 있으면 REMARK UPDATE
			if(auditDataValidOwnerAccountVOs != null) {
				command.manageCanalTzFeeOwnerAccount(auditDataValidOwnerAccountVOs);
			}
			
			//-------------->
			InvAuditDataValidVO vo = new InvAuditDataValidVO();
			vo.setInvNo(strInvNo);
			vo.setVndrSeq(event.getCanalTzFeeHdVO().getVndrSeq());
			ApPayInvVO apPayInvVO = command3.searchApPayInv(vo);
			ApPayInvDtlVO[] apPayInvDtlVOs = command3.searchApPayInvDtl(vo);
			
			apPayInvVO.setPsoTrnsSlpCtnt("AA");//2009.12.18 added

			for(int i=0; i<apPayInvDtlVOs.length; i++){
				apPayInvDtlVOs[i].setIbflag("I");
			}
			
			String strInvRgstNo = command2.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);
			
			//Return 받은 INV_RGST_NO를  PSO_CHAREGE TAble에 update 
			if(strInvRgstNo.equals("")){
				rollback();
				eventResponse.setUserMessage(new ErrorHandler("PSO90013").getUserMessage());//strInvRgstNo를 받아오지 못했을 경우
			}
			else{
				vo.setInvRgstNo(strInvRgstNo);
				vo.setPsoChgStsCd("A");//Approved 로 변경 
				vo.setInvOfcCd("PUSMOV");
//				vo.setIssCtyCd()
				command3.updatePsoCharge(vo);
			}
			
			eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
			//<---------------
			
			commit();
//			rollback();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0019 : Window Open <br/>
	 * 운하 대리점에서 입력한 상세 전도금 내역과 NIS에 계산식에 의해 산출된 Tariff 정보를 조회한다.<br/>
	 * @category VOP_PSO_0019_windowOpen
	 * @param Event e
	 * @return EventResponse
	 */
	private EventResponse searchCanalTzFeeInvDtlByVvd(Event e) throws EventException{
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0019Event event = (VopPso0019Event)e;
		CanalTransitFeeInvoiceBC command = new CanalTransitFeeInvoiceBCImpl();
		GeneralInvoiceAuditBC command1= new GeneralInvoiceAuditBCImpl();

		CalcTariffVO calcTariffVO = new CalcTariffVO(); 
		try{
			//TODO 임플리먼트 필요
			List<CanalTzFeeInvDtlVO> list = command.searchCanalTzFeeInvByVvd(event.getCanalTzFeeInvDtlCondVO());
			ArrayList<CanalTzFeeInvDtlVO> list1 = new ArrayList<CanalTzFeeInvDtlVO>();
//			ArrayList<CanalTzFeeInvDtlVO> list2 = new ArrayList<CanalTzFeeInvDtlVO>();
			//eventResponse.setRsVoList(list);
			
			List<CanalTzFeeInvDtlByVvdOwnerAccountVO> olist= command.searchCanalTzFeeInvByVvdOwnerAccount(event.getCanalTzFeeInvDtlCondVO());
			List<CanalTzFeeSummaryVO> slist= command.searchCanalTzFeeSummary(event.getCanalTzFeeInvDtlCondVO());
			
			
			if(!event.getCanalTzFeeInvDtlCondVO().getSts().equals("10")){
				//TODO 임플리먼트 필요 
				//calGeneralInvAudit ( [in] auditDataValidVOs : AuditDataValidVO[] ) : AuditDataValidVO []
				//합계값을 가지고 있기 위한 index위치 기억을 위한 int어레이 
				float[] idxs = new float[list.size()];
				float rsum = 0;
				String trfAmt = "";
				// 합계 값을 설정 한다. 
				for(int i = 0; i<idxs.length;i++){
					idxs[i] = 0;//초기화 
				}
				//위의 계산 대상의 데이터만큼 돌면서..
				for(int i=0; i<list.size();i++){
					CanalTzFeeInvDtlVO vo =	(CanalTzFeeInvDtlVO)list.get(i);
					
//					if(i==2)
//						i= i+0;
					if( 
//						(vo.getLgsCostCd().equals("")||vo.getLgsCostCd().equals("0"))
//						&& !vo.getLgsCostFullNm().equals("TTL Amount:") //합계 누락되는 것 체크	
						//vo.getFlg().equals("1") || 
						vo.getFlg().equals("2")
							){//계산 대상의 데이터가 아님.
//						log.debug("Passed Row := [" +i+ "]");
//						if(!vo.getLgsCostCd().equals("0")){
//							list2.add(vo);
//						}
//						else{
//							vo.setLgsCostCd("");
							list1.add(vo);
							//for(int x=i; x>=0; x--){
							//	if(idxs[x] == 0){
								//	idxs[x] = rsum;
									//log.debug("Passed Rowx := [" +x+ "]"+rsum);
						//	rsum = 0;//설정 후 클리어 
							//		break;//설정후 loop exit 
								//}
						//	}
				
						if(i+1 == list.size()) {//마지막 합계
								for(int x=i; x>=0; x--){
									if(idxs[x] == 0){
										idxs[i] = rsum;
									}
								}
							}


//					}
						continue;
					}
					
					idxs[i] = -1;
					
					//VO로 변경
					calcTariffVO.setVvd(vo.getVvd());
					calcTariffVO.setYdCd(vo.getYdCd());
					calcTariffVO.setLgsCostCd(vo.getLgsCostCd());
					calcTariffVO.setYdChgNo(vo.getYdChgNo());
					calcTariffVO.setYdChgVerSeq(vo.getYdChgVerSeq());
					calcTariffVO.setCurrCd("USD");
					calcTariffVO.setIoFlag("O");//InBound/OutBound구분
					//Limit Time  Surcharge 의 값을 input
					calcTariffVO.setLimitTm(vo.getScgRtAmt());
					
					
					String strSdr = vo.getLoclXchRt();//화면에서 넘ㅇ어가는 SDR을 일단 Setting하다. 
					calcTariffVO.setSDR(strSdr);// SDR => [110]
					
					//SCNT도 같은 방식으로 Implement 해야됨.. 
					String strScnt = vo.getSuzNetTongWgt();
					calcTariffVO.setScnt(strScnt);//SCNT[38], SCNT1[98]
					calcTariffVO.setScntOne(strScnt);
					
					//Tier의 값도 같은 방식으로 화면에서 구한 값을 넣어 줌
					calcTariffVO.setTier(vo.getTrVolVal());
					
					// CalcTariffResultVO
					// tariffAmount
					// displayFormulaDesc
					// runtimeFormulaDesc
					//List<AuditDataValidVO> list1 = command1.calGeneralInvAudit(<AuditDataValidVO[]>auditDataValidVOs);
					//해당 리스트에 계산된 항목을 add하여 리턴한다.
					CalcTariffResultVO resultvo = command1.calGeneralInvAudit(calcTariffVO);
					
					//계산된 결과를 List에 셋팅한다. 
					
					log.debug("resultvo.getTariffAmount()**"+resultvo.getTariffAmount());
					vo.setCalcAmt(resultvo.getTariffAmount());
					vo.setDfltXprDesc(resultvo.getDisplayFormulaDesc());
					vo.setSysXprDesc(resultvo.getRuntimeFormulaDesc());
					
					trfAmt = resultvo.getTariffAmount();
					if(trfAmt!=null){
						if(!trfAmt.equals("")){
							rsum += Float.parseFloat(trfAmt);
							
						}
					}
				
					list1.add(vo);
				}//END FOR LOOP

				// 합계 값을 설정 한다. 
				for(int i = 0; i<idxs.length;i++){
					if(idxs[i]>0){
						list1.get(i).setCalcAmt(idxs[i]+"");
					}
				}
				
				eventResponse.setRsVoList(list1);
				eventResponse.setRsVoList(slist);
				eventResponse.setRsVoList(olist);      
			
		}
				
				
			
			else//승인된경우  
			{ 
				eventResponse.setRsVoList(list);
				eventResponse.setRsVoList(slist);
			    eventResponse.setRsVoList(olist); 
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0018 : Reject Button Click <br/>
	 * Requested Advance Payment 화면의 reject@click 처리<br/>
	 * @category VOP_PSO_0018_reject_click
	 * @param Event e
	 * @return EventResponse
	 */
	private EventResponse cancelCanalTzFeeEst(Event e) throws EventException{
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0018Event event = (VopPso0018Event)e;
		CanalTransitFeeEstimateBC command = new CanalTransitFeeEstimateBCImpl();
		GeneralInvoiceAuditBC command2 = new GeneralInvoiceAuditBCImpl();
		CSRExternalFinderBC command3 = new CSRExternalFinderBCImpl(); 
		
		try{
			begin();
			//Cancel처리 
			event.getCanalTzFeeEstDtlByVvdCondVO().setCnlTzBztpCd("E");//전도금 업무로설정
			event.getCanalTzFeeEstDtlByVvdCondVO().setUpdUsrId(account.getUsr_id());//UpdateUser정보 셋팅.
			command.cancelCanalTzFeeEst ( event.getCanalTzFeeEstDtlByVvdCondVO() );
			
			//Remark Update
			command.modifyRemark(event.getAuditDataValidVOs());
			
			if(event.getCanalTzFeeEstDtlByVvdCondVO().getSts().equals("10")){//Confirmed 인 경우 만 
				//PSO_CHARGE/PSO_CHG_DTL/ApPayInvInfo --> Record삭제 처리 by inv_no
				//우리쪽 Delete 처리 
				command2.removeGenInvAudit(event.getCanalTzFeeEstDtlByVvdCondVO().getVndrSeq(), event.getCanalTzFeeEstDtlByVvdCondVO().getYdCd(), event.getInvNo());
				
				ApPayInvVO apPayInvVO = new ApPayInvVO();
				ApPayInvDtlVO[] apPayInvDtlVOs = new ApPayInvDtlVO[1];
				
				apPayInvVO.setInvIssDt(account.getUpd_dt());
				apPayInvVO.setInvRgstNo(event.getInvRgstNo());
				apPayInvVO.setInvSubSysCd("PSO");
				apPayInvVO.setInvOfcCd(account.getOfc_cd());
				apPayInvVO.setDeltFlg("Y");
				
				apPayInvDtlVOs[0] = new ApPayInvDtlVO(); 
				apPayInvDtlVOs[0].setIbflag("U");
				
				command3.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);
				
				//<<----------------------
			}
			
			eventResponse.setETCData("calcelResult", "OK");
//			rollback();
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0018 : ToCSR Button Click <br>
	 * Requested Advance Payment 화면의 ToCSR@click 처리<br> 
	 * @param Event e
	 * @return
	 */
//	private EventResponse createEstApprovalRqst(Event e) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	/**
	 * VOP_PSO_0018 : Confirm Button Click <br>
	 * Requested Advance Payment 화면의 confirm@click 처리<br>
	 * @category VOP_PSO_0018_confirm_click
	 * @param Event e
	 * @return EventResponse
	 */
	private EventResponse createCanalTzFeeEst(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0018Event event = (VopPso0018Event)e;
		CanalTransitFeeEstimateBC command = new CanalTransitFeeEstimateBCImpl();
		GeneralInvoiceAuditBC command1= new GeneralInvoiceAuditBCImpl();
		CSRExternalFinderBC command2 = new CSRExternalFinderBCImpl(); 
		GeneralInvoiceAuditBC command3 = new GeneralInvoiceAuditBCImpl();
//		HashMap<String, String> hMap = new HashMap<String, String>();
		String strDebug = "1";
		
		try{
			//TODO 임플리먼트 필요
			String strInvNo = command.createCanalTzFeeEst(event.getCanalTzFeeHdVO());
			eventResponse.setETCData("invoiceNo", strInvNo);
			//InvoiceData를 실제로 생성하는 로직.
			//생성된 inv_no를 셋트 해 준다. 
			AuditDataValidVO[] auditDataValidVOs = event.getAuditDataValidVOs();
			for(int i=0; i<auditDataValidVOs.length;i++){
				auditDataValidVOs[i].setVvd(event.getCanalTzFeeHdVO().getVvd());
				auditDataValidVOs[i].setCnlTzBztpCd("E");//전도금 업무로 설정
				auditDataValidVOs[i].setInvNo(strInvNo);
				auditDataValidVOs[i].setCreUsrId(account.getUsr_id());
				auditDataValidVOs[i].setUpdUsrId(account.getUsr_id());
				auditDataValidVOs[i].setOfcCd("PUSMOV");//account.getOfc_cd());
			}
			
				begin();

				//PSO_CHARGE를 먼저 INSERT
				command1.manageGenInvAudit (auditDataValidVOs);
				
				strDebug = "2";
//				command1.searchPsoChargePk();
				
				//Step1.PSO_CNL_TZ_FEE_DTL의 항목을 UPDATE한다.
				//Step4.PSO_CNL_TZ_FEE의 Status코드를 A(Approved)로 UPdate한다.
				command.manageCanalTzFee(auditDataValidVOs);
				
				
				strDebug = "3";
				
				InvAuditDataValidVO vo = new InvAuditDataValidVO();
				vo.setInvNo(strInvNo);
				vo.setVndrSeq(event.getCanalTzFeeHdVO().getVndrSeq());	
				
				strDebug = "4";
				
				ApPayInvVO apPayInvVO = command3.searchApPayInv(vo);
				strDebug = "5";
				ApPayInvDtlVO[] apPayInvDtlVOs = command3.searchApPayInvDtl(vo);
				strDebug = "6";
				apPayInvVO.setPsoTrnsSlpCtnt("GO");//2009.12.18 added
				if(apPayInvDtlVOs == null ){
					eventResponse.setUserMessage(new ErrorHandler("PSO90013").getUserMessage()+"apPayInvDtlVOs == null step:="+strDebug);//apPayInvDtlVOs == null
					rollback();
				}
				else{
					for(int i=0; i<apPayInvDtlVOs.length; i++){
						apPayInvDtlVOs[i].setIbflag("I");
						apPayInvDtlVOs[i].setVslCd("0000");
						apPayInvDtlVOs[i].setSkdVoyNo("0000");
						apPayInvDtlVOs[i].setSkdDirCd("0");
						apPayInvDtlVOs[i].setRevDirCd("0");
						apPayInvDtlVOs[i].setInvDesc(event.getCanalTzFeeHdVO().getVvd());
						
					}
					
					String strInvRgstNo = command2.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);
					
	//				String strInvRgstNo = "TEST";
					
					//Return 받은 INV_RGST_NO를  PSO_CHAREGE TAble에 update 
					if(strInvRgstNo.equals("")){
						rollback();
						eventResponse.setUserMessage(new ErrorHandler("PSO90013").getUserMessage());//strInvRgstNo를 받아오지 못했을 경우
					}
					else{
						vo.setInvRgstNo(strInvRgstNo);
						vo.setPsoChgStsCd("A");//Approved 로 변경 
						vo.setInvOfcCd("PUSMOV");
						command3.updatePsoCharge(vo);
					}
					
					eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
				
				
					commit();
				}
//			rollback();
		}catch(EventException ex){
			rollback();
			eventResponse.setUserMessage(new ErrorHandler("PSO90013").getUserMessage()+"apPayInvDtlVOs == null step:="+strDebug);
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0018 : Window Open <br>
	 * Requested Advance Payment 화면의 window@open 처리<br>
	 * [CHM-201430851] 전도금 invoice내 tariff Amount/Formula/Formula Expression 오류
	 * @category VOP_PSO_0018_windowopen
	 * @param Event e
	 * @return EventResponse
	 */
	private EventResponse searchCanalTzFeeEstDtlByVvd(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0018Event event = (VopPso0018Event)e;
		CanalTransitFeeEstimateBC command = new CanalTransitFeeEstimateBCImpl();
		GeneralInvoiceAuditBC command1= new GeneralInvoiceAuditBCImpl();

		CalcTariffVO calcTariffVO = new CalcTariffVO(); 
		try{
			//TODO 임플리먼트 필요
			
			String flag = event.getCanalTzFeeEstDtlByVvdCondVO().getSts();
			List<CanalTzFeeEstDtlByVvdVO> list = null ;
			if(flag.equals(""))//(flag.equals("10") || flag.equals("12"))//Approved, Paid의 경우 
			{
				list = command.searchCanalTzFeeEstDtlByVvd(event.getCanalTzFeeEstDtlByVvdCondVO());
			}
			else{
				list = command.searchCanalTzFeeEstDtlByVvd(event.getCanalTzFeeEstDtlByVvdCondVO());
				//eventResponse.setRsVoList(list);
				//TODO 임플리먼트 필요 
				//calGeneralInvAudit ( [in] auditDataValidVOs : AuditDataValidVO[] ) : AuditDataValidVO []
				//위의 계산 대상의 데이터만큼 돌면서..
				for(int i=0; i<list.size();i++){
					CanalTzFeeEstDtlByVvdVO vo = (CanalTzFeeEstDtlByVvdVO)list.get(i);
					//VO로 변경
					String vvd = event.getVvd();
					if(vvd==null)
						vvd = event.getCanalTzFeeEstDtlByVvdCondVO().getVvd();
					
					//CalcParam
					calcTariffVO.setVvd(vvd);
					calcTariffVO.setYdCd(vo.getYdCd());
					calcTariffVO.setLgsCostCd(vo.getLgsCostCd());
					calcTariffVO.setYdChgNo(vo.getYdChgNo());
					calcTariffVO.setYdChgVerSeq(vo.getYdChgVerSeq());
					calcTariffVO.setCurrCd("USD");
					calcTariffVO.setIoFlag("O");//InBound/OutBound구분

//TODO ://					
					String strSdr = vo.getLoclXchRt();//화면에서 넘ㅇ어가는 SDR을 일단 Setting하다. 
					calcTariffVO.setSDR(strSdr);// SDR => [110]
					
					//SCNT도 같은 방식으로 Implement 해야됨.. 
					String strScnt = vo.getSuzNetTongWgt();
					calcTariffVO.setScnt(strScnt);//SCNT[38], SCNT1[98]
					calcTariffVO.setScntOne(strScnt);
					
					//Tier의 값도 같은 방식으로 화면에서 구한 값을 넣어 줌
					calcTariffVO.setTier(vo.getTrVolVal());
					
					// CalcTariffResultVO
					// tariffAmount
					// displayFormulaDesc
					// runtimeFormulaDesc
					//List<AuditDataValidVO> list1 = command1.calGeneralInvAudit(<AuditDataValidVO[]>auditDataValidVOs);
					//해당 리스트에 계산된 항목을 add하여 리턴한다.
					CalcTariffResultVO resultvo = command1.calGeneralInvAudit(calcTariffVO);
					
					//계산된 결과를 List에 셋팅한다. 
					vo.setCalcAmt(resultvo.getTariffAmount());
					vo.setDfltXprDesc(resultvo.getDisplayFormulaDesc());
					vo.setSysXprDesc(resultvo.getRuntimeFormulaDesc());
					
				}
			}
			//list를 이벤트에 셋팅하기전에 vvd 별 코스트코드의 SUBSTRING별로 Grouping한다.
			List<CanalTzFeeEstDtlByVvdVO> list2 = new ArrayList<CanalTzFeeEstDtlByVvdVO>() ;
			//
			String prvVvdCostCd = "-1";//실제로 이러한 값이 들어 올 수 없다.
			float fval = 0;
			String strTmp = "";
			CanalTzFeeEstDtlByVvdVO prvVo = new CanalTzFeeEstDtlByVvdVO();

			for(int i=0; i<list.size();i++){
//				if(i==5)
//					i= i+0;
				CanalTzFeeEstDtlByVvdVO vo = (CanalTzFeeEstDtlByVvdVO)list.get(i);
				String curVvdCostCd = vo.getVslCd()+vo.getSkdVoyNo()+vo.getSkdDirCd();
			   
				if(vo.getLgsCostCd()!=null && !vo.getLgsCostCd().equals("")) {
					 curVvdCostCd = curVvdCostCd + vo.getLgsCostCd().substring(0, 4); 	
				     }
				else{//독립처리 --> cost 코드가 없는 경우 
					list2.add(prvVo);
					prvVo = vo;
					prvVvdCostCd = curVvdCostCd;
					
					if(i+1 == list.size()){
						list2.add(prvVo);
					}
					continue;
				}
		
				if(prvVvdCostCd.equals(curVvdCostCd)){//누적한다. 
					strTmp = prvVo.getCalcAmt();
					if(strTmp != null && !strTmp.equals(""))
						fval = Float.parseFloat(strTmp);
			         strTmp = vo.getCalcAmt();
					if(strTmp != null && !strTmp.equals(""))
						fval += Float.parseFloat(strTmp);
					prvVo.setCalcAmt(fval+"");
					prvVo.setDfltXprDesc(prvVo.getDfltXprDesc()+" + "+ vo.getDfltXprDesc());
					prvVo.setSysXprDesc(prvVo.getSysXprDesc() +" + "+ vo.getSysXprDesc());

					
					if(i+1 == list.size()){
						list2.add(prvVo);
					}
				}
				else{//이전과 같지 않으면 저장
					if(i==0){//최초
						prvVo = vo;
						if(i+1 == list.size()){//최초면서 한건
							list2.add(prvVo);
						}
						else{//일단 누적 
							prvVo = vo;
							prvVvdCostCd = curVvdCostCd;
						}
					}
					else{
						list2.add(prvVo);
						prvVo = vo;
						prvVvdCostCd = curVvdCostCd;
						if(i+1 == list.size()){
							list2.add(prvVo);
						}
					}
				}
			}
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0017 : Retrieve Button Click <br>
	 * Canal Invoice 화면의 searchVendorList조회 처리<br>
	 * @category VOP_PSO_0017_retrieve_button_click
	 * @param    Event e
	 * @return   EventResponse
	 */
	private EventResponse searchCanalTzFeeSumRpt(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0017Event event = (VopPso0017Event)e;
		CanalTransitFeeEstimateBC command = new CanalTransitFeeEstimateBCImpl();
		try{
			List<CanalTzFeeSumVO> list = command.searchCanalTzFeeSumRpt(event.getCanalTzFeeSumVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0017 : Window Open<br>
	 * Vendor 를 조회합니다.<br>
	 * @category VOP_PSO_0017_searchVendorList조회처리
	 * @param Event e
	 * @param String eventName
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVendorList(Event e, String eventName) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSOCodeFinderBC command = new PSOCodeFinderBCImpl();
		List<VendorListVO> list = null;
		if(eventName.equals("VopPso0017Event")){
			VopPso0017Event event = (VopPso0017Event)e;
			list = command.searchVendorList(event.getVendorListVO());
		} else if(eventName.equals("VopPso0031Event")){
			VopPso0031Event event = (VopPso0031Event)e;
			list = command.searchVendorList(event.getVendorListVO());
		}
		// TODO Auto-generated method stub
		StringBuilder data = new StringBuilder();
		
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
		
				data.append(list.get(i).getVndrLglEngNm());
				data.append("");
				data.append(list.get(i).getVndrSeq());
				if (i < list.size() - 1)
					data.append("|");
			}
		}
		eventResponse.setETCData("vendor", data.toString());
		return eventResponse;
	}

	/**
	 * VOP_PSO_0020-1 : Reject Button Click <br>
	 * Requested MSA의 정보를 거절 처리한다.<br>
	 * @category PSO_0020_1
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeCanalTzFeeBal(Event e)throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0020Event event = (VopPso0020Event)e;
		CanalTransitFeeBalanceBC command = new CanalTransitFeeBalanceBCImpl();
		try{
			begin();
			command.removeCanalTzFeeBal(event.getCanalTzFeeBalVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
//			rollback();
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VOP_PSO_0020-1 : Confirm Button Click <br>
	 * 요청된 Requested MSA의 정보를 확약처리한다.<br>
	 * @category PSO_0020_1
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createCanalTzFeeBal(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0020Event event = (VopPso0020Event)e;
		CanalTransitFeeBalanceBC command = new CanalTransitFeeBalanceBCImpl();
		try{
			begin();
			command.createCanalTzFeeBal(event.getCanalTzFeeBalVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
//			rollback();
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VOP_PSO_0020-1 : Tab Click<br>
	 * CanalTransitFeeBalance의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * @category VOP_PSO-0020-1 MSA의 첫번째 Tab정보를 조회하는 이벤트 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCanalTzFeeBal(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0020Event event = (VopPso0020Event)e;
		CanalTransitFeeBalanceBC command = new CanalTransitFeeBalanceBCImpl();
		String sFlag = ((VopPso0020Event)e).getCanalTzFeeBalVO().getOpflag();
		
		try{
			if(sFlag.equals("S")){//Sum
				List<CanalTzFeeBalVO> list = command.searchCanalTzFeeBalSum(event.getCanalTzFeeBalVO());
				eventResponse.setRsVoList(list);
			}
			else if(sFlag.equals("B")){//Remittance
				//AND A.CNL_TZ_BZTP_CD = 'E'
				event.getCanalTzFeeBalDtlVO().setCnlTzBztpCd("E");
				List<CanalTzFeeBalDtlVO> list = command.searchCanalTzFeeBalDtl(event.getCanalTzFeeBalDtlVO());
				eventResponse.setRsVoList(list);
			}
			else if(sFlag.equals("C")){//Disbursement
				//AND A.CNL_TZ_BZTP_CD = 'I'
				event.getCanalTzFeeBalDtlVO().setCnlTzBztpCd("I");
				List<CanalTzFeeBalDtlVO> list = command.searchCanalTzFeeBalDtl(event.getCanalTzFeeBalDtlVO());
				eventResponse.setRsVoList(list);
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0031 : G/L Data <br>
	 * G/L 을 조회 합니다. <br>
	 * @category VOP_PSO-0031 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGlifDateByMon(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0031Event event = (VopPso0031Event)e;
		CanalTransitFeeBalanceBC command = new CanalTransitFeeBalanceBCImpl();
		try{
			GlIfGRPVO glIfGRPVO = command.searchGlifDateByMon(event.getPsoMsaVO());
			List<GlIfDataThisMonVO> list1 = glIfGRPVO.getGlIfDataThisMonVOlist();
			List<GlIfDataTtlVO> 	list2 = glIfGRPVO.getGlIfDataTtlVOlist();
			
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0032 : Window Open <br>
	 * Balance Diff. Account 정보를 조회한다.<br>
	 * @category VOP_PSO-0032
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBalDiffAcct(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0032Event event = (VopPso0032Event)e;
		CanalTransitFeeBalanceBC command = new CanalTransitFeeBalanceBCImpl();
		try{
			BalDiffAcctVO balDiffAcctVO = command.searchBalDiffAcct(event.getBalDiffAcctVO());

			List<BalDiffAcctMstVO> list1 = balDiffAcctVO.getBalDiffAcctMstVOlist();
			List<BalDiffAcctDtlVO> 	list2 = balDiffAcctVO.getBalDiffAcctDtlVOlist();
			
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**VOP_PSO_0038 : 조회조건 변경시
	 * 최근 버전의 Tariff 조회
	 * @category VOP_PSO_0038
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse getTariff(Event e) throws EventException{
		VopPso0038Event event = (VopPso0038Event)e;
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<TariffInfoVO> list = command.getTariff(event.getSimulationConditionVO());
//			String pk = ",";
//			String etc = ",";
//			if(list.size() > 0){
//				pk  = list.get(0).getYdChgNo() + "," + list.get(0).getYdChgVerSeq(); 
//				etc = list.get(0).getCurrCd()  + "," + list.get(0).getUpdUsrId() + "," + list.get(0).getUpdDt();   
//			}
//			eventResponse.setETCData("tariffPK",  pk);
//			eventResponse.setETCData("tariffETC", etc);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**VOP_PSO_0038 : Retrieve
	 * 해당 Tariff의 Object와 Invoice를 조회한다.
	 * @category VOP_PSO_0038
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSimulation(Event e) throws EventException{
		VopPso0038Event event = (VopPso0038Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
	
		HashMap<String, SimulationObjectListVO> autoObjMap = new HashMap<String, SimulationObjectListVO>();
		HashMap<String, SimulationObjectListVO> manuObjMap = new HashMap<String, SimulationObjectListVO>();
		try{
			//1.Objects
			List<SimulationObjectListVO> objectsList = command.searchObjectListBySimulation(event.getSimulationConditionVO(), event.getSimulationConditionVOs());
			List<SimulationObjectListVO> autoObjectList = new ArrayList<SimulationObjectListVO>();
			List<SimulationObjectListVO> manualObjectList = new ArrayList<SimulationObjectListVO>();
			for(int i=0; i<objectsList.size(); i++){
				if("A".equals(objectsList.get(i).getPsoObjListTpCd())){
					autoObjMap.put(objectsList.get(i).getObjListNo(), objectsList.get(i)); 
				} else if("M".equals(objectsList.get(i).getPsoObjListTpCd())){
					manuObjMap.put(objectsList.get(i).getObjListNo(), objectsList.get(i));
				}
			}
			
			for(SimulationObjectListVO simulationObjectListVO : autoObjMap.values()){
				autoObjectList.add(simulationObjectListVO);
			}
			
			for(SimulationObjectListVO simulationObjectListVO : manuObjMap.values()){
				manualObjectList.add(simulationObjectListVO);
			}
			
			//2.Invoice Detail
			List<SimulationInvoiceListVO> invoiceList = command.searchInvoiceBySimulation(event.getSimulationConditionVO(), event.getSimulationConditionVOs());
			
			//Provider가 복수개인 경우 Invoide 정보가 중복 조회 되므로 이를 제거한다.
			Map<String, SimulationInvoiceListVO> invoices = new HashMap<String, SimulationInvoiceListVO>();
			String key = null;
			for(SimulationInvoiceListVO simulationInvoiceListVO : invoiceList){
				key = simulationInvoiceListVO.getAcctCd() + simulationInvoiceListVO.getVndrSeq() + simulationInvoiceListVO.getCurrCd() + simulationInvoiceListVO.getDpIoBndCd();
				if(!invoices.containsKey(key)){
					invoices.put(key, simulationInvoiceListVO);
				}
			}
			invoiceList = new ArrayList<SimulationInvoiceListVO>();
			for(Iterator<SimulationInvoiceListVO> i= invoices.values().iterator(); i.hasNext();){
				invoiceList.add(i.next());
			}

			eventResponse.setRsVoList(autoObjectList);		//Objects (Auto)   
			eventResponse.setRsVoList(manualObjectList);	//Objects (Manual)
			eventResponse.setRsVoList(invoiceList);			//Invoice Detail
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**VOP_PSO_0038 : Port/Account 조회조건 변경시
	 * 해당 Tariff의 Service Providers를 조회한다.
	 * @category VOP_PSO_0038
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchProviderBySimulation(Event e) throws EventException{
		VopPso0038Event event = (VopPso0038Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
		try{

			List<SimulationConditionVO> providerList = command.searchProviderBySimulation(event.getSimulationConditionVO());
			StringBuffer bufAccount = new StringBuffer();

			if(providerList != null && providerList.size() > 0){
				for (int i = 0; i < providerList.size(); i++) {
					//Account
					bufAccount.append(providerList.get(i).getVndrLglEngNm());

					bufAccount.append("*");
					bufAccount.append(providerList.get(i).getVndrSeq());
					if (i < providerList.size() - 1){
						bufAccount.append("|");
					}	
				}
			}
			eventResponse.setETCData("vndr", bufAccount.toString());
//			eventResponse.setRsVoList(providerList);			//Service Providers
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**VOP_PSO_0038 : Port/Yard/VVD 조회조건 변경시
	 * 유효한 VVD인지 조사
	 * @category VOP_PSO_0038
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkVVDBySimulation(Event e) throws EventException{
		VopPso0038Event event = (VopPso0038Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
		String vvd  = event.getSimulationConditionVO().getVslCd() + event.getSimulationConditionVO().getSkdVoyNo() + event.getSimulationConditionVO().getSkdDirCd();
		String yard = event.getSimulationConditionVO().getPortCd() + event.getSimulationConditionVO().getYardCd();
		
		try{
			boolean isValid = command.checkTurningPort(vvd, yard);

			eventResponse.setETCData("isValidVVD", isValid == true ? "FALSE" : "TRUE");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**VOP_PSO_0038 : Port/Yard 조회조건 변경시
	 * Tariff에 사용된 Account 조회
	 * @category VOP_PSO_0038
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAccountBySimulation(Event e) throws EventException{
		VopPso0038Event event = (VopPso0038Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
		try{
			List<CostListVO> accountList = command.searchAccountBySimulation(event.getSimulationConditionVO());

			StringBuffer bufAccount = new StringBuffer();

			if(accountList != null && accountList.size() > 0){
				for (int i = 0; i < accountList.size(); i++) {
					//Account
					bufAccount.append(accountList.get(i).getAcctNm());
					bufAccount.append(",");
					bufAccount.append(accountList.get(i).getAcctCd());
					if (i < accountList.size() - 1){
						bufAccount.append("|");
					}	
				}
			}

			eventResponse.setETCData("account", bufAccount.toString());

//			eventResponse.setRsVoList(accountList);			//Accounts
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**VOP_PSO_0038 : Port 선택시
	 * Tariff에 사용된 yard 조회
	 * @category VOP_PSO_0038
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchYardList(Event e) throws EventException{
		VopPso0038Event event = (VopPso0038Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
		try{
			List<SearchYardsVO> ydList = command.searchYardList(event.getPortCd(), event.getIssueDate());

			StringBuffer data = new StringBuffer();

			if(ydList != null && ydList.size() > 0){
				//addEmptyData(data);

				for (int i = 0; i < ydList.size(); i++) {

					//data.append(cdList.get(i).getCode());
					data.append(ydList.get(i).getYdCd().substring(5));
					data.append(",");
					//data.append(cdList.get(i).getName());
					data.append(ydList.get(i).getYdNm());
					if (i < ydList.size()-1)
						data.append("|");
				}
			}

			eventResponse.setETCData("lane", data.toString());

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**VOP_PSO_0038 : Port/Yard 조회조건 변경시
	 * Tariff에 사용된 Account 조회
	 * @category VOP_PSO_0038
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCostBySimulation(Event e) throws EventException{
		VopPso0038Event event = (VopPso0038Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
		try{
			List<CostListVO> costList = command.searchCostBySimulation(event.getSimulationConditionVO());

			StringBuffer bufAccount = new StringBuffer();

			if(costList != null && costList.size() > 0){
				for (int i = 0; i < costList.size(); i++) {
					//Account
					bufAccount.append(costList.get(i).getCostNm());
					bufAccount.append(",");
					bufAccount.append(costList.get(i).getCostCd());
					if (i < costList.size() - 1){
						bufAccount.append("|");
					}	
				}
			}

			eventResponse.setETCData("cost", bufAccount.toString());
//			eventResponse.setRsVoList(accountList);			//Accounts
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**VOP_PSO_0038 : OPEN
	 * mdm_vsl_cntr 테이블 기준으로 등록된 vsl class를 표시한다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVslClassListBySimulation(Event e) throws EventException {
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

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**VOP_PSO_0039 : Calculation
	 * @category VOP_PSO_0039
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSimulationByVvd(Event e) throws EventException{
		VopPso0039Event event = (VopPso0039Event)e;
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			TariffGRPVO vo = command.searchSimulationByVvd(event.getTariffSimByVvdVO());
			
			Map<String, String> yards = vo.getYards();
			Map<String, String> accts = vo.getAccts();
			
			StringBuffer yardEtcData = new StringBuffer();
			StringBuffer acctEtcData = new StringBuffer();
			StringBuffer acctNmEtcData = new StringBuffer();
			
			if(yards!=null){
				for(Iterator<String> i = yards.keySet().iterator(); i.hasNext(); ){
					String key = i.next();
					yardEtcData.append(key);
					if(i.hasNext()){
						yardEtcData.append("|");
					}
				}
			}
			
			if(accts!=null){
				for(Iterator<String> i = accts.keySet().iterator(); i.hasNext(); ){
					String key = i.next();
					acctEtcData.append(key);
					acctNmEtcData.append(accts.get(key));
					if(i.hasNext()){
						acctEtcData.append("|");
						acctNmEtcData.append("|");
					}
				}
			}
			
			eventResponse.setRsVoList(vo.getTariffSimByVvdVOs());//화면에 보여지는 grid
			eventResponse.setRsVoList(vo.getCalcTariffResultVOs());//detail excel download를 위한 grid
			
			eventResponse.setETCData("yards", yardEtcData.length()>0?yardEtcData.toString():"");//detail grid의 header
			eventResponse.setETCData("accts", acctEtcData.length()>0?acctEtcData.toString():"");//detail grid의 column
			eventResponse.setETCData("acctNms", acctNmEtcData.length()>0?acctNmEtcData.toString():"");//detail grid의 column
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**VOP_PSO_0014 : Open
	 * @category VOP_PSO_0014
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchNoConfirmInvoice(Event e) throws EventException{
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<String> list = command.searchNoConfirmInvoice(account);
			
			StringBuffer data = new StringBuffer();

			if(list != null && list.size() > 0){
				for (int i = 0; i < list.size(); i++) {
					data.append(list.get(i)); 
					if (i < list.size() - 1)
						data.append("");
				}
			}
			eventResponse.setETCData("inv_info", data.toString());
		
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0018 : Save Button Click <br/>
	 * Request Amount, Remark 수정 후 save<br />
	 * @category VOP_PSO_0018_SaveButtonClick
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCanalTzFeeRqstAmt(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0018Event event = (VopPso0018Event)e;
		CanalTransitFeeEstimateBC command = new CanalTransitFeeEstimateBCImpl();

		try{
			begin();
			AuditDataValidVO[] auditDataValidVOs = event.getAuditDataValidVOs();
			for(int i=0; i<auditDataValidVOs.length;i++){
				auditDataValidVOs[i].setVvd(event.getCanalTzFeeHdVO().getVvd());

				auditDataValidVOs[i].setUpdUsrId(account.getUsr_id());
			}
			command.manageCanalTzFeeRqstAmt(auditDataValidVOs);
			eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**VOP_PSO_0215 : Open
	 * @category VOP_PSO_0215
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAtchFileList(Event e) throws EventException{
		CanalTransitFeeInvoiceBC command = new CanalTransitFeeInvoiceBCImpl();
		VopPso0215Event event = (VopPso0215Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
		
			List<AtchFileVO> list = command.searchAtchFileList(event.getAtchFileVO());
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0215 저장 이벤트 처리<br>
	 * tariff upload file 을 생성 처리<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiAtchFile(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		CanalTransitFeeInvoiceBC command = new CanalTransitFeeInvoiceBCImpl();
		
		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		VopPso0215Event event = (VopPso0215Event)e;
		AtchFileVO atchFileVO = event.getAtchFileVO();
//		if(atchFileVO == null)  log.debug("\n\n vo is null");
		atchFileVO.setAccount(account);

		try{
			//2.로직 처리 실행
			begin();
			command.multiAtchFile(atchFileVO);
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
	
	/**VOP_PSO_0216 : Open
	 * @category VOP_PSO_0216
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTpbBillType(Event e) throws EventException{
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
//		VopPso0216Event event = (VopPso0216Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			
			List<TpbIfVO> list = command.searchTpbBillType();
			StringBuilder sb = new StringBuilder();
			StringBuilder sb1 = new StringBuilder();

			if(list != null && list.size() > 0){
				sb.append(list.get(0).getN3ptyBilTpCd());
				sb1.append(list.get(0).getN3ptyBilTpNm());
				for (int i = 1; i < list.size(); i++) {
					sb.append("|");
					sb1.append("|");
					sb.append(list.get(i).getN3ptyBilTpCd());
					sb1.append(list.get(i).getN3ptyBilTpNm());
				}
			}
			eventResponse.setETCData("billTypeCd", sb.toString());
			eventResponse.setETCData("billTypeNm", sb1.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_PSO_0216 : Vendor Change<br>
	 * Carrier Code 가 존재하는지 여부를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVndr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0216Event event = (VopPso0216Event)e;
		PSOCodeFinderBC command = new PSOCodeFinderBCImpl();
		VendorListVO vendorListVO = new VendorListVO();
		
		try{
			vendorListVO.setVndrSeq(event.getN3ptyVndrSeq());
			List<VendorListVO> list = command.searchVendorList(vendorListVO);
			String chkVndr = null;
			if(list != null && list.size() > 0){
				chkVndr = "X";//사용가능
			}
			eventResponse.setETCData("check_vndr", chkVndr);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**VOP_PSO_0217 : Open 
	 * @category VOP_PSO_0217
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRegularAddInfo(Event e) throws EventException{
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
		VopPso0217Event event = (VopPso0217Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
		
			String vvd         = event.getVvd();
			String ydcd        = event.getYdCd();
			String io          = event.getIo();
			String ydchgno     = event.getYdChgNo();
			String ydchgverseq = event.getYdChgVerSeq();

			if (!vvd.equals("")) {
			    String regval = command.searchRegularAddInfo(vvd,ydcd,io,ydchgno,ydchgverseq);
			    eventResponse.setETCData("OBJVAL", regval);
			  }
		        
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**VOP_PSO_0218 : Open 
	 * @category VOP_PSO_0218
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLastBafRate(Event e) throws EventException{
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
		VopPso0218Event event = (VopPso0218Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
		
			String ydcd           = event.getYdCd();
			String vndrSeq        = event.getVndrSeq();
			String lgscostCd         = event.getLgsCostCd();
			
			if (!ydcd.equals("")) {
			    String regval = command.searchLastBafRate(vndrSeq,ydcd,lgscostCd);
			    eventResponse.setETCData("BAF", regval);
			  }
		        
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * [VOP_PSO_0014] VVD 입력 시 해당 ATD 를 조회한다.
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchAtdData(Event e) throws EventException{		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
		
		try{
			String strAtdData = command.searchAtdData(event.getInvAuditDataValidVO());
			eventResponse.setETCData("ATD", strAtdData);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
}