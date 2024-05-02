/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EstimateInvoiceAuditSC.java
 *@FileTitle : Requested MSA
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.10.04
 *@LastModifier : 유혁
 *@LastVersion : 1.0
 * 2009.06.08 박명종
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.bcm.fin.fincommon.fincommon.basic.FinCommonBC;
import com.clt.apps.opus.bcm.fin.fincommon.fincommon.basic.FinCommonBCImpl;
import com.clt.apps.opus.bcm.fin.fincommon.fincommon.vo.CheckInvoiceNoVO;
import com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.basic.CanalTransitFeeEstimateBC;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.basic.CanalTransitFeeEstimateBCImpl;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.event.VopPso0017Event;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.event.VopPso0018Event;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.AuditDataValidVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeEstDtlByVvdVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeSumVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.basic.CanalTransitFeeInvoiceBC;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.basic.CanalTransitFeeInvoiceBCImpl;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.event.VopPso0019Event;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeInvDtlVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.basic.GeneralInvoiceAuditBC;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.basic.GeneralInvoiceAuditBCImpl;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event.VopPso0014Event;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event.VopPso0038Event;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event.VopPso0039Event;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.CalcTariffResultVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.CalcTariffVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.InvAuditDataValidVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationConditionVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationInvoiceListVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationObjectListVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffGRPVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffInfoVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.basic.PortSOMasterDataMgtBC;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.basic.PortSOMasterDataMgtBCImpl;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.CurrencyVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.DefaultCostVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.DefaultVendorVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PsoInvOfcYdVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.SearchYardsVO;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.basic.PSOCodeFinderBC;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.basic.PSOCodeFinderBCImpl;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.vo.CostListVO;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.vo.MdmVslCntrVO;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.vo.VendorListVO;
import com.clt.apps.opus.vop.pso.psocommonutil.PsoConstants;
import com.clt.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBC;
import com.clt.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.ConvertUtils;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.utility.StringUtilities;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.PsoChargeVO;
import com.clt.syscommon.common.table.PsoYdChgVO;



/**
 * Handling business transaction about ALPS-EstimateInvoiceAudit Business Logic ServiceCommand - ALPS-EstimateInvoiceAudit 
 * 
 * @author
 * @see CanalTransitFeeBalanceDBDAO
 * @since J2EE 1.4
 */

public class EstimateInvoiceAuditSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * EstimateInvoiceAudit system preceding process for biz scenario<br>
	 * VOP_PSO-0017related objects creation<br>
	 */
	public void doStart() {
		log.debug("EstimateInvoiceAuditSC 시작");
		try {

			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * EstimateInvoiceAudit system biz scenario closing<br>
	 * VOP_PSO-0017 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("EstimateInvoiceAuditSC 종료");
	}

	/**
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// Part of using in case SC handles many events
		if(e.getEventName().equalsIgnoreCase("VopPso0017Event")){//VOP_PSO-0017 Canal Invoce UI
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
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//confirm@button click	//COMMAND01 -> MULTI01
				eventResponse = createCanalTzFeeEst(e);
			}
			//else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {//ToCSR@button click
			//	eventResponse = createEstApprovalRqst(e);
			//}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {//Reject@button click	//COMMAND03 -> MODIFY
				eventResponse = cancelCanalTzFeeEst(e);
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
		else if(e.getEventName().equalsIgnoreCase("VopPso0014Event")){//VOP_PSO-0014 Invoice Creation N' Audit
			if(e.getFormCommand().isCommand(FormCommand.COMMAND01)){//In case of VOP_PSO-0014 WindowOpen, List Query
				eventResponse = searchSettingInfoByUserOffice(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){//VOP_PSO-0014 Confirm Button Click
				eventResponse = createInvApprovalRqstAp(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)){//VOP_PSO-0014 VVD Level Check 
				eventResponse = checkVvdLevel(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND04)){//VOP_PSO-0014 Grid input VVD Validation 
				eventResponse = checkVslPortSkdVvd(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND05)){//VOP_PSO-0014 Putting in action Calculation of Row unit
				eventResponse = calGeneralInvAudit(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND06)){//VOP_PSO-0014 In case of selecting Issue Date , Retrieve Effective Date  
				eventResponse = searchEffDateByIssDate(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND07)){//VOP_PSO-0014 Putting in action Calculation of CheckBox Row unit 
				eventResponse = calGeneralInvAudits(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND08)){//In case of Change Event in INV No. field, check existence of inv_no applicable  
				eventResponse = checkInvNo(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)){//VOP_PSO-0014 Save Button Click 
				eventResponse = manageGenInvAudit(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){//VOP_PSO-0014 Retrieve Button Click 
				eventResponse = searchGenInvAudit(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.REMOVE)){//VOP_PSO-0014 Delete Button Click
				eventResponse = removeGenInvAudit(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND09)){//In case of VOP_PSO-0014 WindowOpen, List Query
				eventResponse = searchSettingInfoByUserOfficeAndCanal(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND10)){//In case of VOP_PSO-0014 Before Save Checked.
				eventResponse = searchExistExchangeRate(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND11)){//In case of VOP_PSO-0014 Before save ar_mst_rev_vvd Checked.
				eventResponse = checkArMasterRevenueByVvd(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND12)){//유저가 입력한 VVD의 Yard가 스킵인지 확인한다.
				eventResponse = checkSkipYardInVvd(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND13)){//2016.12.19 유저가 입력한 VVD가  해당 Vendor/Cost_ofc/Cost_cd/YD_CD에 따라서 기존 입력된 Invoice여부 체크 
				eventResponse = checkDoublePayInv(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("VopPso0038Event")){//Port Charge Simulation
			if(e.getFormCommand().isCommand(FormCommand.COMMAND01)){//In case of changing retrieve condition, Search Tariff 
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
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)){//Search Clpt ind seq 
				eventResponse = searchClptIndSeq(e);
			} 
		}
		else if(e.getEventName().equalsIgnoreCase("VopPso0039Event")){//Tariff Simulation By VVD
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){//Calculation
				eventResponse = searchSimulationByVvd(e);
			}
		}
		return eventResponse;
	}

	/**
	 * VOP_PSO-0038 : Port Charge Simulation <br />
	 * Calculating Tariff by condition 
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
			SimulationConditionVO sVO = event.getSimulationConditionVO();
			if(null != sVO){
				//port + yard 를 합친다.
				sVO.setYardCd(sVO.getPortCd()+sVO.getYardCd());
			
				List<CalcTariffResultVO> calVOs = command.calculateTariff(sVO, event.getSimulationConditionVOs(), event.getSimulationObjectListVOs(), event.getMenualObjectVOs());
				eventResponse.setRsVoList(calVOs);
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		
		return eventResponse;
	}

	/**
	 * VOP_PSO-0014 : INV No. Focus Out Event <br />
	 * Checking existence INV No. input 
	 * @category VOP_PSO_0014_InvNoFocusOut
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkInvNo(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();

		try{
			PsoChargeVO vo = command.checkInvNo(event.getVndrSeq(), event.getInvNo(), event.getDftVslCd());
			
			String strInvNo = "";
			String strIssCtyCd = "";
			String strSoSeq = "";
			String strExistYn = "";
			String strExistDtlYn = "";
			if(null != vo){
				strInvNo 	= vo.getInvNo();
				strIssCtyCd = vo.getIssCtyCd();
				strSoSeq 	= vo.getSoSeq();
				
				strExistDtlYn = StringUtils.isNotEmpty(vo.getExistDtlYn()) ? vo.getExistDtlYn() : "N";
				strExistYn = StringUtils.isNotEmpty(strInvNo) ? "Y" : "N";
			}
			eventResponse.setETCData("EXIST_YN", strExistYn);
			eventResponse.setETCData("EXIST_ISS_CTY_CD", strIssCtyCd);
			eventResponse.setETCData("EXIST_SO_SEQ", strSoSeq);
			eventResponse.setETCData("EXIST_INV_NO", strInvNo);
			eventResponse.setETCData("EXIST_DTL_YN", strExistDtlYn);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO-0014 : Calculation Button Click <br />
	 * Putting in action Calculation of CheckBox Row unit
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
		
		String currCdOfTariff  	= "";		
		String currCdOfInvoice 	= "";		
		String eIssDt		   	= "";
		String eYdCd			= "";
		String eVndrSeq			= "";
		String eCurrCd			= "";				

		log.debug("\n/*******************************************/"+
	              "\n VOP_PSO_0014 Calculation n Rows Event Start."+
	              "\n/*******************************************/");
		try{
			for(int i=0; i<auditDataValidVos.length; i++){
				log.debug("\nVOP_PSO_0014 Calculation n Rows Loop Count ["+i+"] Start.");
				
				eYdCd		= event.getYdCd();
				eVndrSeq	= event.getVndrSeq();				
				eIssDt		= event.getIssDt().replaceAll("-", "");	
				eCurrCd		= event.getCurrCd();
				
				String dCostCd 		= auditDataValidVos[i].getCostCd();
				String dVslCd		= auditDataValidVos[i].getVslCd();
				String dSkdVoyNo 	= auditDataValidVos[i].getSkdVoyNo();
				String dSkdDirCd 	= auditDataValidVos[i].getSkdDirCd();
				String dIo 			= auditDataValidVos[i].getIo();
				String dClptIndSeq  = auditDataValidVos[i].getClptIndSeq(); //2016.04.26 Double calling port Add 
				
				//if(auditDataValidVos[i].getIbflag().equals("")||auditDataValidVos[i].getIbflag().equals("D")){
				if(auditDataValidVos[i].getDelChk().equals("0")){	//Checked Rows
					auditDataValidVos[i].setIoChk("N");
					continue;
				}	
				
				List<PsoYdChgVO> listPsoYdChg = null;
				listPsoYdChg = command.searchPsoYdChg(dCostCd, eYdCd, eVndrSeq, eIssDt);
				
				if(listPsoYdChg != null && listPsoYdChg.size() > 0 ){
					PsoYdChgVO vo = listPsoYdChg.get(0);
					log.debug("\n/*******************************************/"+
				              "\n eYdCd			["+eYdCd+"]."+
				              "\n eVndrSeq		["+eVndrSeq+"]."+
				              "\n eIssDt		["+eIssDt+"]."+
				              "\n eCurrCd		["+eCurrCd+"]."+
				              "\n dCostCd 		["+dCostCd+"]."+
				              "\n dVvd			["+dVslCd + dSkdVoyNo + dSkdDirCd+"]."+
				              "\n dClptIndSeq   ["+dClptIndSeq+"]."+
				              "\n dIo 			["+dIo+"]."+
				              "\n YdChgNo		["+vo.getYdChgNo()+"]."+
				              "\n YdChgVerSeq	["+vo.getYdChgVerSeq()+"]."+
				              "\n Yd CurrCd		["+vo.getCurrCd()+"]."+
				              "\n eVndrSeq		["+eVndrSeq+"]."+
				              "\n eVndrSeq		["+eVndrSeq+"]."+
				              "\n/*******************************************/");	
					
					//Input Parameter to Calc...
					CalcTariffVO calcTariffVO = new CalcTariffVO();
					calcTariffVO.setVvd			(dVslCd + dSkdVoyNo + dSkdDirCd);
					calcTariffVO.setYdChgNo		(vo.getYdChgNo());
					calcTariffVO.setYdChgVerSeq	(vo.getYdChgVerSeq());
					calcTariffVO.setYdCd		(eYdCd);
					calcTariffVO.setLgsCostCd	(dCostCd);
					calcTariffVO.setCurrCd		(eCurrCd);
					calcTariffVO.setIoFlag		(dIo);
					
					calcTariffVO.setClptIndSeq	(dClptIndSeq);//2016.04.26 Double calling port Add 
					
					currCdOfInvoice = calcTariffVO.getCurrCd();						
					currCdOfTariff  = vo.getCurrCd();							
					
					//Handling Manually Input value 
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
					<o114>114</o114>	SDR		SDR
					<o115>115</o115>	Tier
					<o116>116</o116>	Limit Time
					<o116>125</o116>	co-pilot
					<o170>170</o170>	Others
					<o171>171</o171>	OtherValue
					 */
					//Input Value : float
					calcTariffVO.setArrNT	    (auditDataValidVos[i].getArrnt()); //6 Arr. NT	Arrival No. of Tug
					calcTariffVO.setDepNT	    (auditDataValidVos[i].getDepnt()); //7 Dep. NT	Departure No. of Tug
					calcTariffVO.setArrTP	    (auditDataValidVos[i].getArrtp()); //8 Arr. TP	Arrival Tug Power
					calcTariffVO.setDepTP	    (auditDataValidVos[i].getDeptp()); //9 Dep. TP	Departure Tug Power
					calcTariffVO.setArrTUH	    (auditDataValidVos[i].getArrtuh()); //10 Arr. TUH	Arrival Tug Used Hour
					calcTariffVO.setDepTUH	    (auditDataValidVos[i].getDeptuh()); //11 Dep.TUH	Departure Tug Used Hour
					calcTariffVO.setArrLH	    (auditDataValidVos[i].getArrlh()); //50 Arr. LH	Arrival Line Handing Hour
					calcTariffVO.setDepLH	    (auditDataValidVos[i].getDeplh()); //60 Dep. LH	Departure Line handing Hour
					calcTariffVO.setUsdhrs	    (auditDataValidVos[i].getUsdhrs()); //111 Used HRS		Used Hours
					calcTariffVO.setSDR		    (auditDataValidVos[i].getSdr());//114 sdr
					calcTariffVO.setTier	    (auditDataValidVos[i].getTier());//115 Tier
					calcTariffVO.setLimitTm	    (auditDataValidVos[i].getLimitTime());//116 Limit Time
					calcTariffVO.setOtherValue	(auditDataValidVos[i].getOtherValue());//171 OtherValue //2015.02.10 Add
					
					//Check Value : Flag(N, Y)
					calcTariffVO.setBoat		("'"+(auditDataValidVos[i].getBoat().equals("") 		? "N":auditDataValidVos[i].getBoat())+"'");
					calcTariffVO.setBarge		("'"+(auditDataValidVos[i].getBarge().equals("") 		? "N":auditDataValidVos[i].getBarge())+"'");
					calcTariffVO.setBuoy		("'"+(auditDataValidVos[i].getBuoy().equals("") 		? "N":auditDataValidVos[i].getBuoy())+"'");
					calcTariffVO.setHoliday		("'"+(auditDataValidVos[i].getHoliday().equals("") 		? "N":auditDataValidVos[i].getHoliday())+"'");
					calcTariffVO.setInspection	("'"+(auditDataValidVos[i].getInspection().equals("") 	? "N":auditDataValidVos[i].getInspection())+"'");
					calcTariffVO.setNight		("'"+(auditDataValidVos[i].getNight().equals("") 		? "N":auditDataValidVos[i].getNight())+"'");
					calcTariffVO.setSanit		("'"+(auditDataValidVos[i].getSanitation().equals("") 	? "N":auditDataValidVos[i].getSanitation())+"'");
					calcTariffVO.setTUGRope		("'"+(auditDataValidVos[i].getTugrope().equals("") 		? "N":auditDataValidVos[i].getTugrope())+"'");
					calcTariffVO.setNewservice	("'"+(auditDataValidVos[i].getNewservice().equals("") 	? "N":auditDataValidVos[i].getNewservice())+"'");					
					calcTariffVO.setOthers		("'"+(auditDataValidVos[i].getOthers().equals("") 		? "N":auditDataValidVos[i].getOthers())+"'");//170 Others //2015.02.10 Add					
					calcTariffVO.setCopilot		("'"+(auditDataValidVos[i].getCopilot().equals("") 		? "N":auditDataValidVos[i].getCopilot())+"'"); //125
					
					log.debug("\nVOP_PSO_0014 Calculation n Rows Loop Count ["+i+"] calGeneralInvAudit Call.");
					CalcTariffResultVO calcVo = command.calGeneralInvAudit(calcTariffVO);
	
					//>>Currency Conversion		add
					int rowsNumberOfDesc = Integer.parseInt(calcVo.getPagerows());
					if(!currCdOfTariff.equals(currCdOfInvoice)){		//In case Tariff Curr and Invoice Curr are not same
						String div = "";	//USD2Local or Local2USD
						String amt = calcVo.getTariffAmount();
						//String currCd = "";
						//boolean exec = true;
						
						String[] arrConversion = new String[]{"0","0"};
						
						if(currCdOfInvoice.equals("USD")){
							div = "Local2USD";
							//currCd = currCdOfTariff;
							
							arrConversion = command.searchConvertedAmount(div, amt, eIssDt, currCdOfTariff);
						} else if(currCdOfTariff.equals("USD")){
							div = "USD2Local";
							//currCd = currCdOfInvoice;
							
							arrConversion = command.searchConvertedAmount(div, amt, eIssDt, currCdOfInvoice);
						} else{	//Prohibit converting with different currency not USD
							//exec = false;	
							
							div = "Local2Local";
							
							arrConversion = command.searchConvertedInvoiceAmount(div, amt, eIssDt, currCdOfTariff, currCdOfInvoice);
						}
						
						calcVo.setTariffAmount(arrConversion[0]);
						calcVo.setRuntimeFormulaDesc(calcVo.getRuntimeFormulaDesc() + "\n[R]: " + arrConversion[1]);	//Formula in Sheet
						calcVo.setDisplayFormulaDesc(calcVo.getDisplayFormulaDesc() + "\n[R]: " + arrConversion[1]);	//Formula Value in Sheet
						rowsNumberOfDesc++;
						
						/*
						if(exec){
							String[] arrConversion = command.searchConvertedAmount(div, amt, eIssDt, currCd);	//arrConversion[0] : convertedAmt, arrConversion[1] : exchangeRate
							//log.error("\nConvertedAmount>> " + arrConversion[0] + " : " + arrConversion[1]);
							//Setting sum converted and Description in calcVo
							calcVo.setTariffAmount(arrConversion[0]);
							calcVo.setRuntimeFormulaDesc(calcVo.getRuntimeFormulaDesc() + "\n[R]: " + arrConversion[1]);	//Formula in Sheet
							calcVo.setDisplayFormulaDesc(calcVo.getDisplayFormulaDesc() + "\n[R]: " + arrConversion[1]);	//Formula Value in Sheet
							rowsNumberOfDesc++;
						}*/
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
   
					if(calcVo.existObj(77) || calcVo.existObj(89)){
						auditDataValidVos[i].setIoChk("Y");
					} else {
						auditDataValidVos[i].setIoChk("N");
					}
				}
				/*
				else{
					//tariff가 존재 하지 않음
					StringBuffer sb = new StringBuffer();
					sb.append(" S/P Code :").append(eVndrSeq);
					sb.append(" Teminal :").append(eYdCd);
					sb.append(" Issue Date :").append(event.getIssDt());
					sb.append(" Cost Code :").append(dCostCd);
					
					throw new EventException(new ErrorHandler("PSO90002", new String[] { "Please check the tariff : "+sb.toString() }).getMessage());
				}*/
				log.debug("\nVOP_PSO_0014 Calculation n Rows Loop Count ["+i+"] E n d.");
			}
			log.debug("\n/*******************************************/"+
		              "\n VOP_PSO_0014 Calculation n Rows Event E n d."+
		              "\n/*******************************************/");
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
	 * Handlign in case of clicking Confirm Button in Invoice Creation & Audit page<br />
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
		try{
			
			begin();
			
			//Save in case Info changed exist in data grid 
			if (event.getAuditDataValidVOs() != null){ 
				if (event.getAuditDataValidVOs().length > 0) {
					InvAuditDataValidVO[] vos = event.getAuditDataValidVOs();
				
					command.manageGenInvAudit(vos);
				}
			}
			
			//command.createInvApprovalRqstAp(event.getInvAuditDataValidVO());
			ApPayInvVO 		apPayInvVO	 	= command.searchApPayInv	(event.getInvAuditDataValidVO());
			ApPayInvDtlVO[] apPayInvDtlVOs 	= command.searchApPayInvDtl	(event.getInvAuditDataValidVO());
			
			for(int i=0; i<apPayInvDtlVOs.length; i++){
				apPayInvDtlVOs[i].setIbflag("I");
			}
			
			String strInvRgstNo = command2.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);
					
			//Update INV_RGST_NO by Return in PSO_CHAREGE TAble
			if(!StringUtils.isEmpty(strInvRgstNo)){
				InvAuditDataValidVO vo = event.getInvAuditDataValidVO();
				
				vo.setInvRgstNo		(strInvRgstNo);
				vo.setPsoChgStsCd	("A");//Approved 
				
				command.updatePsoCharge(vo);
			}else{
				eventResponse.setUserMessage(new ErrorHandler("PSO90013").getUserMessage());
			}
			
			eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());

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
	 * Handling In case of changing Account Code in grid of Invoice Creation & Audit page<br />
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
	 * Handling in case of Clicking Delete Button in Invoice Creation & Audit page.<br />
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
			if(event.getPsoChgStsCd().equals("A")){//Confirm 

//				boolean bRet = command.checkApPayInv(event.getVndrSeq(), event.getYdCd(), event.getInvNo());
//				if(!bRet){//In case AP_PAY_INV.CSR_NO value not exist, delete 
					ApPayInvVO apPayInvVO = command.searchApPayInv(event.getInvAuditDataValidVO());
					ApPayInvDtlVO[] apPayInvDtlVOs = command.searchApPayInvDtl(event.getInvAuditDataValidVO());
					
					for(int i=0; i<apPayInvDtlVOs.length; i++){
						apPayInvDtlVOs[i].setIbflag("U");
						apPayInvDtlVOs[i].setDeltFlg("Y");
					}
					
					command2.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);
					
					
					//command.removeGenInvAudit(event.getVndrSeq(), event.getYdCd(), event.getInvNo());

					InvAuditDataValidVO vo = event.getInvAuditDataValidVO();
					vo.setInvRgstNo("");
					vo.setPsoChgStsCd("I");	//A->I 
					vo.setVndrSeq(event.getVndrSeq());
					vo.setYdCd(event.getYdCd());
					vo.setInvNo(event.getInvNo());
					command.updatePsoCharge(vo);
			
					
					eventResponse.setUserMessage(new ErrorHandler("PSO99001").getUserMessage());//Saved Successfully 
//				}
//				else{
//					throw new EventException(new ErrorHandler("PSO90014").getMessage());//showing cannot delete Message 
//				}
			}
			else{//except for Confirm 
				command.removeGenInvAudit(event.getVndrSeq(), event.getYdCd(), event.getInvNo());
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
	 * Retrieve In case of Clicking Retrieve Button in Invoice Creation & Audit page.<br />
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
			//1.Detail 있는 데이타인지 먼저 조회한다.
			//2.Detail 존재 : 기존 조회
			//3.Detail 미존재 : 마스터만 조회.
			String schVndrSeq = event.getInvAuditDataValidVO().getVndrSeq();
			String schInvNo   = event.getInvAuditDataValidVO().getInvNo();
			PsoChargeVO dtlExistVo = command.checkInvNo(schVndrSeq, schInvNo, "");
			boolean isExistDtlYn = true;
			
			if(null != dtlExistVo &&  StringUtils.isNotEmpty(dtlExistVo.getExistDtlYn()) ){
				isExistDtlYn = "Y".equals(dtlExistVo.getExistDtlYn()) ? true : false; 
			}			
			
			if(isExistDtlYn){
				list = command.searchGenInvAudit(event.getInvAuditDataValidVO());
				
				eventResponse.setETCData("EXIST_DTL_YN", "Y");
				eventResponse.setRsVoList(list);
			}else{			
				//저장된 마스터 데이타 재조회 한다.
				InvAuditDataValidVO condVo = event.getInvAuditDataValidVO();
				List<InvAuditDataValidVO> mstList = command.searchGenInvAuditMaster(condVo);
				
				String tmpYdCd 			= condVo.getYdCd();
				String tmpInvLoclAmt 	= condVo.getInvLoclAmt().replace(",", "");
				String tmpLoclTaxAmt 	= condVo.getLoclTaxAmt().replace(",", "");
				String tmpLoclWhldTaxAmt= condVo.getLoclWhldTaxAmt().replace(",", "");
				String tmpCurrCd 		= condVo.getCurrCd();
				String tmpPsoTrnsSlpCtnt= condVo.getPsoTrnsSlpCtnt();
				String tmpPsoChgStsCd	= condVo.getPsoChgStsCd();
				String tmpIssDt 		= condVo.getIssDt().replace("-", "");
				String tmpAcptDt 		= condVo.getAcptDt().replace("-", "");
				String tmpCostOfcCd 	= condVo.getCostOfcCd();
				String tmpIssCtyCd 		= condVo.getIssCtyCd();
				String tmpSoSeq 		= condVo.getSoSeq();
				
				if(null != mstList && mstList.size() > 0){
					tmpYdCd 			= mstList.get(0).getYdCd();             
					tmpInvLoclAmt 		= mstList.get(0).getInvLoclAmt();       
					tmpLoclTaxAmt 		= mstList.get(0).getLoclTaxAmt();       
					tmpLoclWhldTaxAmt 	= mstList.get(0).getLoclWhldTaxAmt();   
					tmpCurrCd		 	= mstList.get(0).getCurrCd();           
					tmpPsoTrnsSlpCtnt 	= mstList.get(0).getPsoTrnsSlpCtnt();     
					tmpPsoChgStsCd 		= mstList.get(0).getPsoChgStsCd();   
					tmpIssDt 			= mstList.get(0).getIssDt();            
					tmpAcptDt 			= mstList.get(0).getAcptDt();           
					tmpCostOfcCd 		= mstList.get(0).getCostOfcCd();        
					tmpIssCtyCd 		= mstList.get(0).getIssCtyCd();           
					tmpSoSeq 			= mstList.get(0).getSoSeq();        
				}
				
				eventResponse.setETCData("EXIST_DTL_YN", "N");
				
				eventResponse.setETCData("yd_cd"			, tmpYdCd);
				eventResponse.setETCData("inv_locl_amt"		, tmpInvLoclAmt);
				eventResponse.setETCData("locl_tax_amt"		, tmpLoclTaxAmt);
				eventResponse.setETCData("locl_whld_tax_amt", tmpLoclWhldTaxAmt);
				eventResponse.setETCData("curr_cd"			, tmpCurrCd);
				eventResponse.setETCData("pso_chg_sts_cd"	, tmpPsoChgStsCd);
				eventResponse.setETCData("pso_trns_slp_ctnt", tmpPsoTrnsSlpCtnt);
				eventResponse.setETCData("iss_dt"			, tmpIssDt);
				eventResponse.setETCData("acpt_dt"			, tmpAcptDt);
				eventResponse.setETCData("cost_ofc_cd"		, tmpCostOfcCd);
				eventResponse.setETCData("iss_cty_cd"		, tmpIssCtyCd);
				eventResponse.setETCData("so_seq"			, tmpSoSeq);
			}
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Save In case of Clicking Save Button in Invoice Creation & Audit page<br />
	 * @category VOP_PSO_0014_SaveButtonClick
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageGenInvAudit(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
		
		FinCommonBC command2 = new FinCommonBCImpl(); // InvoiceNo Checked add.
		try{
			begin();
			String strExistDtlYn = event.getExistDtlYn();
			
			//마스터 정보 조회 : 신규인지 Update 인지 판단하기 위해서.
			InvAuditDataValidVO[] invAuditDataValidVOs = event.getAuditDataValidVOs();
			String vndrSeq 	= invAuditDataValidVOs[0].getVndrSeq();
			String invNo 	= invAuditDataValidVOs[0].getInvNo();
			

			InvAuditDataValidVO existVo = new InvAuditDataValidVO();
			existVo.setVndrSeq(vndrSeq);
			existVo.setInvNo(invNo);
			
			List<InvAuditDataValidVO> existMstList = command.searchGenInvAuditMaster(existVo);
			
			//신규 등록일때 Invoice No 체크 한다.
			if(null == existMstList || existMstList.size() == 0){
				log.debug("\nnew Master Data for checkInvoiceNo Check Call["+vndrSeq+"]["+invNo+"].");
				//InvoiceNo Checked.
				CheckInvoiceNoVO checkInvoiceNoVO = new CheckInvoiceNoVO();
				checkInvoiceNoVO.setVndrSeq(vndrSeq);
				checkInvoiceNoVO.setInvNo(invNo);

				//존재시에 EventException 발생함.
				command2.checkInvoiceNo(checkInvoiceNoVO);
			}			
			
			if(StringUtils.isNotEmpty(strExistDtlYn) && "Y".equals(strExistDtlYn)){
				//기존 로직 그대로 Detail 까지 저장.
				command.manageGenInvAudit(invAuditDataValidVOs);
			}else{
				//InvAuditDataValidVO[] invAuditDataValidVOs = event.getAuditDataValidVOs();
				
				//마스터만 저장.
				command.manageGenInvAuditMaster(invAuditDataValidVOs);
				
				//저장된 마스터 데이타 재조회 한다.
				InvAuditDataValidVO condVo = invAuditDataValidVOs[0];
				List<InvAuditDataValidVO> mstList = command.searchGenInvAuditMaster(condVo);
				
				String tmpYdCd 			= condVo.getYdCd();
				String tmpInvLoclAmt 	= condVo.getInvLoclAmt().replace(",", "");
				String tmpLoclTaxAmt 	= condVo.getLoclTaxAmt().replace(",", "");
				String tmpLoclWhldTaxAmt= condVo.getLoclWhldTaxAmt().replace(",", "");
				String tmpCurrCd 		= condVo.getCurrCd();
				String tmpPsoTrnsSlpCtnt= condVo.getPsoTrnsSlpCtnt();
				String tmpPsoChgStsCd	= condVo.getPsoChgStsCd();
				String tmpIssDt 		= condVo.getIssDt();
				String tmpAcptDt 		= condVo.getAcptDt();
				String tmpCostOfcCd 	= condVo.getCostOfcCd();
				String tmpIssCtyCd 		= condVo.getIssCtyCd();
				String tmpSoSeq 		= condVo.getSoSeq();
				
				if(null != mstList && mstList.size() > 0){
					tmpYdCd 			= mstList.get(0).getYdCd();             
					tmpInvLoclAmt 		= mstList.get(0).getInvLoclAmt();       
					tmpLoclTaxAmt 		= mstList.get(0).getLoclTaxAmt();       
					tmpLoclWhldTaxAmt 	= mstList.get(0).getLoclWhldTaxAmt();   
					tmpCurrCd		 	= mstList.get(0).getCurrCd();            
					tmpPsoTrnsSlpCtnt 	= mstList.get(0).getPsoTrnsSlpCtnt();       
					tmpPsoChgStsCd 		= mstList.get(0).getPsoChgStsCd();   
					tmpIssDt 			= mstList.get(0).getIssDt();            
					tmpAcptDt 			= mstList.get(0).getAcptDt();           
					tmpCostOfcCd 		= mstList.get(0).getCostOfcCd();        
					tmpIssCtyCd 		= mstList.get(0).getIssCtyCd();           
					tmpSoSeq 			= mstList.get(0).getSoSeq();       
				}
				
				eventResponse.setETCData("EXIST_DTL_YN"		, "N");
				
				eventResponse.setETCData("yd_cd"			, tmpYdCd);
				eventResponse.setETCData("inv_locl_amt"		, tmpInvLoclAmt);
				eventResponse.setETCData("locl_tax_amt"		, tmpLoclTaxAmt);
				eventResponse.setETCData("locl_whld_tax_amt", tmpLoclWhldTaxAmt);
				eventResponse.setETCData("curr_cd"			, tmpCurrCd);
				eventResponse.setETCData("pso_chg_sts_cd"	, tmpPsoChgStsCd);
				eventResponse.setETCData("pso_trns_slp_ctnt", tmpPsoTrnsSlpCtnt);
				eventResponse.setETCData("iss_dt"			, tmpIssDt);
				eventResponse.setETCData("acpt_dt"			, tmpAcptDt);
				eventResponse.setETCData("cost_ofc_cd"		, tmpCostOfcCd);
				eventResponse.setETCData("iss_cty_cd"		, tmpIssCtyCd);
				eventResponse.setETCData("so_seq"			, tmpSoSeq);
			}
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
	 * Retrieve Effective Date In case of selecting Issue Date in Invoice Creation & Audit page<br />
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
	 * Calculating Tariff in Invoice Creation & Audit page<br />
	 * @category VOP_PSO_0014_OnGridCostCdChange
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse calGeneralInvAudit(Event e) throws EventException{
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		VopPso0014Event event 				= (VopPso0014Event)e;
		GeneralInvoiceAuditBC command 		= new GeneralInvoiceAuditBCImpl();

		List<PsoYdChgVO> listPsoYdChg 		= null;
		
		String currCdOfTariff  = "";		
		String currCdOfInvoice = "";	
		String eIssDt		   = "";
		
		log.debug("\n/******************************************************/"+
	              "\n VOP_PSO_0014 Calculation One Selected Rows Event Start."+
	              "\n/******************************************************/");
		try{
							
			eIssDt		= event.getIssDt().replaceAll("-", "");	
			
			listPsoYdChg = command.searchPsoYdChg(event.getLgsCostCd(), event.getYdCd(), event.getVndrSeq(), event.getIssDt());
			StringBuilder data 		= new StringBuilder();
			StringBuilder dataObj 	= new StringBuilder();
			
			if(listPsoYdChg != null && listPsoYdChg.size() > 0 ){
				log.debug("\nVOP_PSO_0014 Calculation One Selected Row Start.");

				PsoYdChgVO vo = listPsoYdChg.get(0);
				
				log.debug("\n/*******************************************/"+
			              "\n eYdCd			["+event.getYdCd()+"]."+
			              "\n eIssDt		["+eIssDt+"]."+
			              "\n eCurrCd		["+event.getCurrCd()+"]."+
			              "\n eCostCd 		["+event.getLgsCostCd()+"]."+
			              "\n eVvd			["+event.getVslCd() + event.getSkdVoyNo() + event.getSkdDirCd()+"]."+
			              "\n eClptIndSeq   ["+event.getClptIndSeq()+"]."+
			              "\n eIo 			["+event.getIoFlag()+"]."+
			              "\n YdChgNo		["+vo.getYdChgNo()+"]."+
			              "\n YdChgVerSeq	["+vo.getYdChgVerSeq()+"]."+
			              "\n Yd CurrCd		["+vo.getCurrCd()+"]."+
			              "\n/*******************************************/");
				
				//Input Parameter to Calc
				CalcTariffVO calcTariffVO = new CalcTariffVO();
				
				calcTariffVO.setVslCd		(event.getVslCd());
				calcTariffVO.setSkdVoyNo	(event.getSkdVoyNo());
				calcTariffVO.setSkdDirCd	(event.getSkdDirCd());
				calcTariffVO.setVvd			(event.getVslCd()+event.getSkdVoyNo()+event.getSkdDirCd());
				calcTariffVO.setYdChgNo		(vo.getYdChgNo());
				calcTariffVO.setChgVerSeq	(vo.getYdChgVerSeq());
				calcTariffVO.setYdCd		(event.getYdCd());
				calcTariffVO.setLgsCostCd	(event.getLgsCostCd());
				calcTariffVO.setCurrCd		(event.getCurrCd());
				calcTariffVO.setIoFlag		(event.getIoFlag());
				
				calcTariffVO.setClptIndSeq	(event.getClptIndSeq()); //2016.04.26 Double calling port Add 
				
				currCdOfInvoice 			= event.getCurrCd();	
				//currCdOfTariff  			= calcTariffVO.getCurrCd();			
				currCdOfTariff  			= vo.getCurrCd(); //Tariff Curr.			
								
				InvAuditDataValidVO ivo 	= event.getInvAuditDataValidVO();

				//Handling Manually Input value
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
				<o114>114</o114>	SDR		SDR
				<o115>115</o115>	Tier
				<o116>116</o116>	Limit Time
				<o170>170</o170>	Others
				<o171>171</o171>	OtherValue
				 */
				
				/*
				 * Default Value 정책.
				 * 1. 아래 Reqular Value 값은 파라메터의 Object 에 Default Value 값을 조회 한다.
				 * 2. 조회 한 데이타를 Set 한다.
				 *   - Input Object : Default Value 존재시 해당 값, 존재 하지 않을시 "" 값 대체
				 *   - Check Object : Default Value 존재시 해당 값 NVL(xxx,'N') 이므로 값이 없으면 'N' 으로 대체 됨.
				 */
				/*String[] invDftObjList = {"6", "7", "8", "9", "10","11", "17", "50", "52", "57",
										  "60", "75", "78", "86", "97", "110", "111", "114", "115", "116",
										  "119", "125", "170", "171"};*/
				List<String> invObjNoList = (List<String>)Arrays.asList(PsoConstants.ARRAY_DEFAULT_MANUAL_VALUE_OBJECT_NO);
				
				Map<String, Object> dftValMap = command.getRegularValueByObjectNoMap(vo.getYdChgNo(), vo.getYdChgVerSeq(), invObjNoList);
				
				//Input Value : float
				String inArrNT 		= ivo.getArrnt(); //6 Arr. NT	Arrival No. of Tug
				String inDepNT 		= ivo.getDepnt(); //7 Dep. NT	Departure No. of Tug
				String inArrTP 		= ivo.getArrtp(); //8 Arr. TP	Arrival Tug Power
				String inDepTP 		= ivo.getDeptp(); //9 Dep. TP	Departure Tug Power
				String inArrTUH 	= ivo.getArrtuh(); //10 Arr. TUH	Arrival Tug Used Hour
				String inDepTUH 	= ivo.getDeptuh(); //11 Dep.TUH	Departure Tug Used Hour
				String inArrLH 		= ivo.getArrlh(); //50 Arr. LH	Arrival Line Handing Hour
				String inDepLH 		= ivo.getDeplh(); //60 Dep. LH	Departure Line handing Hour
				String inUsdhrs 	= ivo.getUsdhrs(); //111 Used HRS		Used Hours
				String inSDR	 	= ivo.getSdr();//114 sdr
				String inTier 		= ivo.getTier();//115 Tier
				String inLimitTm 	= ivo.getLimitTime();//116 Limit Time
				String inOtherValue	= ivo.getOtherValue();//171 OtherValue //2015.02.10 Add
				
				//Check Value : Flag(N, Y)
				String chkBoat		= "'"+(ivo.getBoat().equals("") 		? "N":ivo.getBoat())+"'";
				String chkBarge		= "'"+(ivo.getBarge().equals("") 		? "N":ivo.getBarge())+"'";
				String chkBuoy		= "'"+(ivo.getBuoy().equals("") 		? "N":ivo.getBuoy())+"'";
				String chkHoliday	= "'"+(ivo.getHoliday().equals("") 		? "N":ivo.getHoliday())+"'";
				String chkInspection= "'"+(ivo.getInspection().equals("") 	? "N":ivo.getInspection())+"'";
				String chkNight		= "'"+(ivo.getNight().equals("") 		? "N":ivo.getNight())+"'";
				String chkSanit		= "'"+(ivo.getSanitation().equals("") 	? "N":ivo.getSanitation())+"'";
				String chkTUGRope	= "'"+(ivo.getTugrope().equals("") 		? "N":ivo.getTugrope())+"'";
				String chkNewservice= "'"+(ivo.getNewservice().equals("") 	? "N":ivo.getNewservice())+"'";					
				String chkOthers	= "'"+(ivo.getOthers().equals("") 		? "N":ivo.getOthers())+"'";//170 Others //2015.02.10 Add
				String chkCopilot	= "'"+(ivo.getCopilot().equals("") 		? "N":ivo.getCopilot())+"'";//125 Co-pilot	
				
				
				if(dftValMap.containsKey("6")) 		inArrNT 		= (String)dftValMap.get("6"); //6 Input , Arr. NT	Arrival No. of Tug
				if(dftValMap.containsKey("7")) 		inDepNT 		= (String)dftValMap.get("7"); //7 Input ,Dep. NT	Departure No. of Tug
				if(dftValMap.containsKey("8")) 		inArrTP 		= (String)dftValMap.get("8"); //8 Input ,Arr. TP	Arrival Tug Power
				if(dftValMap.containsKey("9")) 		inDepTP 		= (String)dftValMap.get("9"); //9 Input ,Dep. TP	Departure Tug Power
				if(dftValMap.containsKey("10")) 	inArrTUH 		= (String)dftValMap.get("10"); //10 Arr. TUH	Arrival Tug Used Hour
				if(dftValMap.containsKey("11")) 	inDepTUH 		= (String)dftValMap.get("11"); //11 Dep.TUH	Departure Tug Used Hour
				if(dftValMap.containsKey("50")) 	inArrLH 		= (String)dftValMap.get("50"); //50 Arr. LH	Arrival Line Handing Hour
				if(dftValMap.containsKey("60")) 	inDepLH 		= (String)dftValMap.get("60"); //60 Dep. LH	Departure Line handing Hour
				if(dftValMap.containsKey("111")) 	inUsdhrs 		= (String)dftValMap.get("111"); //111 Used HRS		Used Hours
				if(dftValMap.containsKey("114")) 	inSDR 			= (String)dftValMap.get("114"); //114 sdr
				if(dftValMap.containsKey("115")) 	inTier 			= (String)dftValMap.get("115"); //115 Tier
				if(dftValMap.containsKey("116")) 	inLimitTm 		= (String)dftValMap.get("116"); //116 Limit Time
				if(dftValMap.containsKey("171")) 	inOtherValue	= (String)dftValMap.get("171"); //171 OtherValue
				
				if(dftValMap.containsKey("17")) 	chkBoat 		= (String)dftValMap.get("17"); //17	Boat
				if(dftValMap.containsKey("52")) 	chkBarge 		= (String)dftValMap.get("52"); //52	Barge
				if(dftValMap.containsKey("57")) 	chkBuoy 		= (String)dftValMap.get("57"); //57	Buoy
				if(dftValMap.containsKey("75")) 	chkHoliday 		= (String)dftValMap.get("75"); //75	Holiday
				if(dftValMap.containsKey("78")) 	chkInspection 	= (String)dftValMap.get("78"); //78	Inspection
				if(dftValMap.containsKey("86")) 	chkNight 		= (String)dftValMap.get("86"); //86	Night
				if(dftValMap.containsKey("97")) 	chkSanit 		= (String)dftValMap.get("97"); //97	Sanitation
				if(dftValMap.containsKey("110")) 	chkTUGRope 		= (String)dftValMap.get("110"); //110	TUG Rope
				if(dftValMap.containsKey("119")) 	chkNewservice 	= (String)dftValMap.get("119"); //119	New Service
				if(dftValMap.containsKey("170")) 	chkOthers 		= (String)dftValMap.get("170"); //170	Others
				if(dftValMap.containsKey("125")) 	chkCopilot 		= (String)dftValMap.get("125"); //170	Co-pilot

				log.debug("\n/*******************************************/"+
			              "\n inArrNT 				["+inArrNT 		+"]."+
			              "\n inDepNT 				["+inDepNT 		+"]."+
			              "\n inArrTP 				["+inArrTP 		+"]."+
			              "\n inDepTP 				["+inDepTP 		+"]."+
			              "\n inArrTUH 				["+inArrTUH 	+"]."+
			              "\n inDepTUH 				["+inDepTUH 	+"]."+
			              "\n inArrLH 				["+inArrLH 		+"]."+
			              "\n inDepLH 				["+inDepLH 		+"]."+
			              "\n inUsdhrs 				["+inUsdhrs 	+"]."+
			              "\n inSDR 				["+inSDR 		+"]."+
			              "\n inTier 				["+inTier 		+"]."+
			              "\n inLimitTm 			["+inLimitTm 	+"]."+
			              "\n inOtherValue			["+inOtherValue	+"]."+
			              "\n chkBoat 				["+chkBoat 		+"]."+
			              "\n chkBarge 				["+chkBarge 	+"]."+
			              "\n chkBuoy 				["+chkBuoy 		+"]."+
			              "\n chkHoliday 			["+chkHoliday 	+"]."+
			              "\n chkInspection 		["+chkInspection+"]."+
			              "\n chkNight 				["+chkNight 	+"]."+
			              "\n chkSanit 				["+chkSanit 	+"]."+
			              "\n chkTUGRope 			["+chkTUGRope 	+"]."+
			              "\n chkNewservice 		["+chkNewservice+"]."+
			              "\n chkOthers 			["+chkOthers 	+"]."+
			              "\n chkCopilot 			["+chkCopilot 	+"]."+
		                  "\n/*******************************************/");
				
				//Input Value : float
				calcTariffVO.setArrNT	    (inArrNT); //6 Arr. NT	Arrival No. of Tug
				calcTariffVO.setDepNT	    (inDepNT); //7 Dep. NT	Departure No. of Tug
				calcTariffVO.setArrTP	    (inArrTP); //8 Arr. TP	Arrival Tug Power
				calcTariffVO.setDepTP	    (inDepTP); //9 Dep. TP	Departure Tug Power
				calcTariffVO.setArrTUH	    (inArrTUH); //10 Arr. TUH	Arrival Tug Used Hour
				calcTariffVO.setDepTUH	    (inDepTUH); //11 Dep.TUH	Departure Tug Used Hour
				calcTariffVO.setArrLH	    (inArrLH); //50 Arr. LH	Arrival Line Handing Hour
				calcTariffVO.setDepLH	    (inDepLH); //60 Dep. LH	Departure Line handing Hour
				calcTariffVO.setUsdhrs	    (inUsdhrs); //111 Used HRS		Used Hours
				calcTariffVO.setSDR		    (inSDR);//114 sdr
				calcTariffVO.setTier	    (inTier);//115 Tier
				calcTariffVO.setLimitTm	    (inLimitTm);//116 Limit Time
				calcTariffVO.setOtherValue	(inOtherValue);//171 OtherValue //2015.02.10 Add
				
				//Check Value : Flag(N, Y)
				calcTariffVO.setBoat		(chkBoat);
				calcTariffVO.setBarge		(chkBarge);
				calcTariffVO.setBuoy		(chkBuoy);
				calcTariffVO.setHoliday		(chkHoliday);
				calcTariffVO.setInspection	(chkInspection);
				calcTariffVO.setNight		(chkNight);
				calcTariffVO.setSanit		(chkSanit);
				calcTariffVO.setTUGRope		(chkTUGRope);
				calcTariffVO.setNewservice	(chkNewservice);					
				calcTariffVO.setOthers		(chkOthers);//170 Others //2015.02.10 Add
				calcTariffVO.setCopilot		(chkCopilot);//125 Co-pilot
				
				calcTariffVO.setFrom		("INVOICE");
				
				log.debug("\nVOP_PSO_0014 Calculation One Selected Row calGeneralInvAudit Call.");
								
				CalcTariffResultVO calcVo = command.calGeneralInvAudit(calcTariffVO);

				//>>Currency Conversion		
				int rowsNumberOfDesc = Integer.parseInt(calcVo.getPagerows());
				if(!currCdOfTariff.equals(currCdOfInvoice)){		//Tariff Curr and Invoice Curr are not same
					String div = "";	//USD2Local or Local2USD
					String amt = calcVo.getTariffAmount();
					//String currCd = ""; //2016.08.17 주석처리
					//boolean exec = true;//2016.08.17 주석처리
					
					String[] arrConversion = new String[]{"0","0"};
					
					if(currCdOfInvoice.equals("USD")){
						div = "Local2USD";
						//currCd = currCdOfTariff;
						
						arrConversion = command.searchConvertedAmount(div, amt, eIssDt, currCdOfTariff);
					} else if(currCdOfTariff.equals("USD")){
						div = "USD2Local";
						//currCd = currCdOfInvoice;
						
						arrConversion = command.searchConvertedAmount(div, amt, eIssDt, currCdOfInvoice);
					} else{	//Prohibit converting with different currency not USD
						//exec = false;
						
						div = "Local2Local";
						
						arrConversion = command.searchConvertedInvoiceAmount(div, amt, eIssDt, currCdOfTariff, currCdOfInvoice);
					}
					
					calcVo.setTariffAmount(arrConversion[0]);
					calcVo.setRuntimeFormulaDesc(calcVo.getRuntimeFormulaDesc() + "\n[R]: " + arrConversion[1]);	//Formula in Sheet
					calcVo.setDisplayFormulaDesc(calcVo.getDisplayFormulaDesc() + "\n[R]: " + arrConversion[1]);	//Formula Value in Sheet
					rowsNumberOfDesc++;
					
					/* 2016.08.17 주석처리함.
					if(exec){
						String[] arrConversion = command.searchConvertedAmount(div, amt, eIssDt, currCd);	//arrConversion[0] : convertedAmt, arrConversion[1] : exchangeRate
						//log.error("\nConvertedAmount>> " + arrConversion[0] + " : " + arrConversion[1]);
						//Setting sum converted and Description in calcVo
						calcVo.setTariffAmount(arrConversion[0]);
						calcVo.setRuntimeFormulaDesc(calcVo.getRuntimeFormulaDesc() + "\n[R]: " + arrConversion[1]);	//Formula in Sheet
						calcVo.setDisplayFormulaDesc(calcVo.getDisplayFormulaDesc() + "\n[R]: " + arrConversion[1]);	//Formula Value in Sheet
						rowsNumberOfDesc++;
					}*/
					
				}
				
				if(rowsNumberOfDesc == 3){
					calcVo.setRuntimeFormulaDesc(calcVo.getRuntimeFormulaDesc() + "\n");
					calcVo.setDisplayFormulaDesc(calcVo.getDisplayFormulaDesc() + "\n");
				}
				//log.error("\n" + "rowsNumberOfDesc : " + rowsNumberOfDesc);
				//<<Currency Conversion

				data.append(calcVo.getTariffAmount());
				data.append("^");
				data.append(calcVo.getDisplayFormulaDesc());
				data.append("^");
				data.append(calcVo.getRuntimeFormulaDesc());
				data.append("^");
				data.append(vo.getYdChgNo());
				data.append("^");
				data.append(vo.getYdChgVerSeq());
				data.append("^");

				// Comment: Originally use in case of existing Condition "IN" or "OUT" in  Tariff.
				// Although Condition not exist, in case of selecting Account in column applicable, read Tariff registered to account chosen 
			
				if(calcVo.existObj(77) || calcVo.existObj(89)){
					data.append("Y");
				} else {
					data.append("N");
				}
				
				//Add Information Default Value Set.
				dataObj.append(inArrNT 		).append("^");
				dataObj.append(inDepNT 		).append("^");
				dataObj.append(inArrTP 		).append("^");
				dataObj.append(inDepTP 		).append("^");
				dataObj.append(inArrTUH 	).append("^");
				dataObj.append(inDepTUH 	).append("^");
				dataObj.append(inArrLH 		).append("^");
				dataObj.append(inDepLH 		).append("^");
				dataObj.append(inUsdhrs 	).append("^");
				dataObj.append(inSDR 		).append("^");
				dataObj.append(inTier 		).append("^");
				dataObj.append(inLimitTm 	).append("^");
				dataObj.append(inOtherValue	).append("^");
				dataObj.append(StringUtils.replaceChars(chkBoat			, "'", "") 	).append("^");
				dataObj.append(StringUtils.replaceChars(chkBarge		, "'", "") 	).append("^");
				dataObj.append(StringUtils.replaceChars(chkBuoy 		, "'", "")	).append("^");
				dataObj.append(StringUtils.replaceChars(chkHoliday		, "'", "") 	).append("^");
				dataObj.append(StringUtils.replaceChars(chkInspection	, "'", "")	).append("^");
				dataObj.append(StringUtils.replaceChars(chkNight		, "'", "") 	).append("^");
				dataObj.append(StringUtils.replaceChars(chkSanit		, "'", "") 	).append("^");
				dataObj.append(StringUtils.replaceChars(chkTUGRope		, "'", "") 	).append("^");
				dataObj.append(StringUtils.replaceChars(chkNewservice	, "'", "")	).append("^");
				dataObj.append(StringUtils.replaceChars(chkOthers		, "'", "") 	).append("^");
				dataObj.append(StringUtils.replaceChars(chkCopilot		, "'", "") 	);;
				
				//log.error("\nJMH>>CALCINFO : " + data.toString());
				eventResponse.setETCData("CALCINFO", data.toString());
				//순서 중요 : inArrNT inDepNT inArrTP inDepTP inArrTUH inDepTUH inArrLH inDepLH inUsdhrs inSDR inTier inLimitTm inOtherValue
				//          chkBoat chkBarge chkBuoy chkHoliday chkInspection chkNight chkSanit chkTUGRope chkNewservice chkOthers chkCopilot
				eventResponse.setETCData("VALUEINFO", dataObj.toString());
				
				log.debug("\nVOP_PSO_0014 Calculation One Selected Row E n d.");
			} else{
				
				eventResponse.setETCData("CALCINFO", "NO_TARIFF_FOUND");
				eventResponse.setETCData("VALUEINFO", "NO_VALUE_FOUND");
				log.debug("\nVOP_PSO_0014 Calculation One Selected Row [NO_TARIFF_FOUND] E n d.");
			}
		}catch(EventException ex){
			log.error("\n\nd^^b : " + ex);
			throw ex;
		}catch(Exception ex){
			log.error("\n\nd^^b : " + ex);
			throw new EventException(ex.getMessage(), ex);
		}		
		
		log.debug("\n/******************************************************/"+
	              "\n VOP_PSO_0014 Calculation One Selected Rows Event E n d."+
	              "\n/******************************************************/");
		return eventResponse;
	}

	
	/**
	 * VOP_PSO_0014 : Window Open <br/>
	 * Initial date Query of Invoice Creation & Audit page
	 * @category VOP_PSO_0014_WndowsOpen
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSettingInfoByUserOffice(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//VopPso0014Event event = (VopPso0014Event)e;
		PortSOMasterDataMgtBC command = new PortSOMasterDataMgtBCImpl();
		List<DefaultCostVO> list = null;
		List<DefaultCostVO> list5 = null;
		List<PsoInvOfcYdVO> list2 = null;
		List<CurrencyVO> list3 = null;
		List<DefaultVendorVO> list4 = null;
		
		
		try{
			//searchOfficeCosts ( [in] ofcCd : String , [in] chrgTypeCd : String ) : DefaultCostVO []
			list = command.searchOfficeCosts(account.getOfc_cd(), "", "");
			//≪≫ searchOfficeYards ( [in] ofcCd : String ) : PsoInvOfcYdVO[]
			list2 = command.searchOfficeYards(account.getOfc_cd());
//			eventResponse.setRsVoList(list);
			list3 = command.searchCurrency();
//			≪≫ searchOfficeVendors ( [in] ofcCd : String ) : DefaultVendorVO []
			list4 = command.searchOfficeVendors(account.getOfc_cd());
			
			//searchOfficeCosts ( [in] ofcCd : String , [in] chrgTypeCd : String ) : DefaultCostVO []
			list5 = command.searchOfficeCosts(account.getOfc_cd(), "", "Y");//canal Code Search.
						                                                                  
			StringBuilder data = new StringBuilder();
			
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
			
					data.append(list.get(i).getAcctCd());
					data.append("^");
					data.append(list.get(i).getLgsCostCd());
					data.append("^");
					data.append(list.get(i).getLgsCostFullNm());
					data.append("^");
					data.append(list.get(i).getAcctEngNm());
					if (i < list.size() - 1)
						data.append("|");
				}
			}
			eventResponse.setETCData("ACCTCOSTCDLIST", data.toString());
			
			data.setLength(0);
			if (list2 != null && list2.size() > 0) {
				for (int i = 0; i < list2.size(); i++) {
			
					data.append(list2.get(i).getYdCd1());//yd_cd
					data.append("^");
					data.append(list2.get(i).getYdCd2());//yd_nm
					data.append("^");
					data.append(list2.get(i).getOfcCd());//ofc_cd
					data.append("^");
					data.append(list2.get(i).getCurrCd());//curr_cd
					data.append("^");
					data.append(list2.get(i).getCanalFlag());//canal_flag
					if (i < list2.size() - 1)
						data.append("|");
				}
			}
			eventResponse.setETCData("YDCDLIST", data.toString());
			
			data.setLength(0);
			if (list3 != null && list3.size() > 0) {
				for (int i = 0; i < list3.size(); i++) {
					
					data.append(list3.get(i).getCurrCd());
					data.append("^");
					data.append(list3.get(i).getCurrNm());
					data.append("^");
					data.append(list3.get(i).getCntCd());
					data.append("^");
					data.append(list3.get(i).getDpPrcsKnt());	
					if (i < list3.size() - 1)
						data.append("|");
				}
			}
			eventResponse.setETCData("CURRENCYLIST", data.toString());
			
			data.setLength(0);
			if (list4 != null && list4.size() > 0) {
				for (int i = 0; i < list4.size(); i++) {
					
					data.append(list4.get(i).getVndrSeq());
					data.append("^");
					data.append(list4.get(i).getVndrLglEngNm());
					data.append("^");
					data.append(list4.get(i).getDeltFlg()); 
					data.append("^");
					data.append(list4.get(i).getCnlAgnFlg()); 
					if (i < list4.size() - 1)
						data.append("|");
				}
			}
			eventResponse.setETCData("VENDORLIST", data.toString());
			
			data.setLength(0);
			if (list5 != null && list5.size() > 0) {
				for (int i = 0; i < list5.size(); i++) {
			
					data.append(list5.get(i).getAcctCd());
					data.append("^");
					data.append(list5.get(i).getLgsCostCd());
					data.append("^");
					data.append(list5.get(i).getLgsCostFullNm());
					data.append("^");
					data.append(list5.get(i).getAcctEngNm());
					if (i < list5.size() - 1)
						data.append("|");
				}
			}
			eventResponse.setETCData("CANALACCTCOSTCDLIST", data.toString());
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	
	/**
	 * VOP_PSO_0014 : Window Open <br/>
	 * Initial date Query of Invoice Creation & Audit page
	 * @category VOP_PSO_0014_WndowsOpen
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSettingInfoByUserOfficeAndCanal(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		PortSOMasterDataMgtBC command = new PortSOMasterDataMgtBCImpl();
		List<DefaultCostVO> list = null;
		//List<PsoInvOfcYdVO> list2 = null;
		//List<CurrencyVO> list3 = null;
		//List<DefaultVendorVO> list4 = null;
		try{
			//searchOfficeCosts ( [in] ofcCd : String , [in] chrgTypeCd : String ) : DefaultCostVO []
			list = command.searchOfficeCosts(account.getOfc_cd(), "", event.getSpCalAngFlg());
			   
			StringBuilder data = new StringBuilder();
			
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
			
					data.append(list.get(i).getAcctCd());
					data.append("^");
					data.append(list.get(i).getLgsCostCd());
					data.append("^");
					data.append(list.get(i).getLgsCostFullNm());
					data.append("^");
					data.append(list.get(i).getAcctEngNm());
					if (i < list.size() - 1)
						data.append("|");
				}
			}
			eventResponse.setETCData("ACCTCOSTCDLIST", data.toString());
			
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	
	/**
	 * VOP_PSO_0014 : Window Open <br/>
	 * Initial date Query of Invoice Creation & Audit page
	 * @category VOP_PSO_0014_WndowsOpen
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchExistExchangeRate(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		PortSOMasterDataMgtBC command = new PortSOMasterDataMgtBCImpl();
		try{
			
			String existRateYn = command.searchExistExchageRate(event.getCurrCd(), event.getIssDt());

			eventResponse.setETCData("EXIST_RATE_YN", existRateYn);
			
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0014 : AfterEdit Grid VVD <br/>
	 * Check existence VVD input by user in VSK_VSL_PORT_SKD
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
			String pVslCd 		= event.getVslCd();
			String pSkdVoyNo 	= event.getSkdVoyNo();
			String pSkdDirCd	= event.getSkdDirCd();
			String pYdCd		= event.getYdCd();

			String turnPortIndCd= "";
			String clptIndSeqs	= "";
			boolean bRet		= false;
			
			bRet = command.checkVslPortSkdVvd(pVslCd, pSkdVoyNo, pSkdDirCd, pYdCd);
			if(bRet && !StringUtils.isEmpty(pVslCd) && !StringUtils.isEmpty(pSkdVoyNo) && !StringUtils.isEmpty(pSkdDirCd)){// TURN_PORT_IND_CD Check
				turnPortIndCd 	= command.getTurnPortIndCd(pVslCd, pSkdVoyNo, pSkdDirCd, pYdCd);
				String vvd 		= pVslCd + pSkdVoyNo + pSkdDirCd;
				clptIndSeqs		= command.searchClptIndSeq(vvd, pYdCd);
			}
			String turnPortIndIoData = command.getDefaultTurnPortIndIoData(pVslCd, pSkdVoyNo, pSkdDirCd, pYdCd);
			eventResponse.setETCData("TURNPORTINDCD"	, turnPortIndCd);
			eventResponse.setETCData("ISEXIST"			, bRet ? "Y" : "N");
			eventResponse.setETCData("TURNPORTINDIODATA", turnPortIndIoData);
			eventResponse.setETCData("CLPT_IND_SEQS"	, clptIndSeqs); //2016.04.26 Double Calling
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0019 : ToCSR Button Click <br>
	 * Provide Info in common table to receiving approval request and  CSR creation about Invoice Info registered<br>
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
	 * Reject Invoice Info requested<br>
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
			//Cancel
			event.getCanalTzFeeEstDtlByVvdCondVO().setCnlTzBztpCd("I");//Invoice
			event.getCanalTzFeeEstDtlByVvdCondVO().setUpdUsrId(account.getUsr_id());//Update UserID
			command.cancelCanalTzFeeEst ( event.getCanalTzFeeEstDtlByVvdCondVO() );
			
			//Remark Update
			command.modifyRemark(event.getAuditDataValidVOs());
			
			if(event.getCanalTzFeeEstDtlByVvdCondVO().getSts().equals("10")){//In case of Confirmed 
				//PSO_CHARGE/PSO_CHG_DTL/ApPayInvInfo --> Record delete by inv_no
				//Delete 
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
	 * Register Invoice about VVD which is object of navigation on this month in canal agency <br>
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
			String strInvNo = command.createCanalTzFeeEst(event.getCanalTzFeeHdVO());
			eventResponse.setETCData("invoiceNo", strInvNo);
			//Logic of creating InvoiceData actually
			//Setting inv_no created  
			AuditDataValidVO[] auditDataValidVOs = event.getAuditDataValidVOs();
			if(auditDataValidVOs==null){
				eventResponse.setETCData("invoiceNo", "");
				rollback();
				return eventResponse;
			}
			for(int i=0; i<auditDataValidVOs.length;i++){
				auditDataValidVOs[i].setVvd(event.getCanalTzFeeHdVO().getVvd());
				auditDataValidVOs[i].setCnlTzBztpCd("I");//Invoice cf>> E : Advance Payment
				auditDataValidVOs[i].setInvNo(strInvNo);
				auditDataValidVOs[i].setVndrSeq(event.getCanalTzFeeHdVO().getVndrSeq());
				
				auditDataValidVOs[i].setCreUsrId(account.getUsr_id());
				auditDataValidVOs[i].setUpdUsrId(account.getUsr_id());
				List<String> ofcCdList = OfficeCodeMgr.getOfficeCodeList(PsoConstants.HO_VSL_OP_TEAM, PsoConstants.OFC_MODULE);
				if(ofcCdList==null || ofcCdList.size()!=1){
					// PSO90015 No office code found. Please check [$s].
					throw new EventException(new ErrorHandler(PsoConstants.PSO90015, PsoConstants.HO_VSL_OP_TEAM).getMessage());
				}
				auditDataValidVOs[i].setOfcCd(ofcCdList.get(0));
				
			}
			begin();
			
			//First INSERT PSO_CHARGE
			command1.manageGenInvAudit (event.getAuditDataValidVOs() );
			
			//Step1.UPDATE PSO_CNL_TZ_FEE_DTL's items
			//Step4.UPdate Status code of PSO_CNL_TZ_FEE to A(Approved)
			command.manageCanalTzFee(auditDataValidVOs);
			
			
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
			
//			String strInvRgstNo = "TEST";
			
			//Update INV_RGST_NO by return in PSO_CHAREGE TAble 
			if(strInvRgstNo.equals("")){
				rollback();
				eventResponse.setUserMessage(new ErrorHandler("PSO90013").getUserMessage());//In case of failure of recieving strInvRgstNo
			}
			else{
				vo.setInvRgstNo(strInvRgstNo);
				vo.setPsoChgStsCd("A");//Approved 
				List<String> ofcCdList = OfficeCodeMgr.getOfficeCodeList(PsoConstants.HO_VSL_OP_TEAM, PsoConstants.OFC_MODULE);
				if(ofcCdList==null || ofcCdList.size()!=1){
					// PSO90015 No office code found. Please check [$s].
					throw new EventException(new ErrorHandler(PsoConstants.PSO90015, PsoConstants.HO_VSL_OP_TEAM).getMessage());
				}
				vo.setInvOfcCd(ofcCdList.get(0));
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
	 * Retrieve Tariff Info calculated by formula of NIS and detailed money paid in advance records input by canal agency <br/>
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
			//Need TODO implement 
			List<CanalTzFeeInvDtlVO> list = command.searchCanalTzFeeInvByVvd(event.getCanalTzFeeInvDtlCondVO());
			ArrayList<CanalTzFeeInvDtlVO> list1 = new ArrayList<CanalTzFeeInvDtlVO>();
//			ArrayList<CanalTzFeeInvDtlVO> list2 = new ArrayList<CanalTzFeeInvDtlVO>();
			//eventResponse.setRsVoList(list);
			
			if(!event.getCanalTzFeeInvDtlCondVO().getSts().equals("10")){
				//Need TODO implement 
				//calGeneralInvAudit ( [in] auditDataValidVOs : AuditDataValidVO[] ) : AuditDataValidVO []
				//int Array to remember index site to have sum value  
				float[] idxs = new float[list.size()];
				float rsum = 0;
				String trfAmt = "";
				// Setting sum 
				for(int i = 0; i<idxs.length;i++){
					idxs[i] = 0;//initialize
				}

				for(int i=0; i<list.size();i++){
					CanalTzFeeInvDtlVO vo =	(CanalTzFeeInvDtlVO)list.get(i);
					
//					if(i==2)
//						i= i+0;
					if( 
//						(vo.getLgsCostCd().equals("")||vo.getLgsCostCd().equals("0"))
//						&& !vo.getLgsCostFullNm().equals("TTL Amount:") //Check omission of sum
						vo.getFlg().equals("1") || vo.getFlg().equals("2")
							){//not data of calculation target
//						log.debug("Passed Row := [" +i+ "]");
//						if(!vo.getLgsCostCd().equals("0")){
//							list2.add(vo);
//						}
//						else{
//							vo.setLgsCostCd("");
							list1.add(vo);

							for(int x=i-1; x>=0; x--){
								if(idxs[x] == 0){
									idxs[x] = rsum;
									rsum = 0;//after setup clear
									break;//after setup loop exit 
								}
							}
							
							if(i+1 == list.size()) {//Last sum
								for(int x=i-1; x>=0; x--){
									if(idxs[x] > 0){
										idxs[i] += idxs[x];
									}
								}
							}


//						}
						continue;
					}
					
					idxs[i] = -1;
					
					//chang in VO
					calcTariffVO.setVvd(vo.getVvd());
					calcTariffVO.setYdCd(vo.getYdCd());
					calcTariffVO.setLgsCostCd(vo.getLgsCostCd());
					calcTariffVO.setYdChgNo(vo.getYdChgNo());
					calcTariffVO.setYdChgVerSeq(vo.getYdChgVerSeq());
					calcTariffVO.setCurrCd("USD");
					calcTariffVO.setIoFlag("O");//Classify InBound/OutBound
					//Input Limit Time  Surcharge value
					calcTariffVO.setLimitTm(vo.getScgRtAmt());
					
					
					String strSdr = vo.getLoclXchRt();//Setting SDR sent by page  
					calcTariffVO.setSDR(strSdr);// SDR => [110]
					
					//Implement SCNT by same way 
					String strScnt = vo.getSuzNetTongWgt();
					calcTariffVO.setScnt(strScnt);//SCNT[38], SCNT1[98]
					calcTariffVO.setScntOne(strScnt);
					
					//Inputting Tier value got in page by same way  
					calcTariffVO.setTier(vo.getTrVolVal());
					
					// CalcTariffResultVO
					// tariffAmount
					// displayFormulaDesc
					// runtimeFormulaDesc
					//List<AuditDataValidVO> list1 = command1.calGeneralInvAudit(<AuditDataValidVO[]>auditDataValidVOs);
					//Return after adding item calculated in list chosen  
					CalcTariffResultVO resultvo = command1.calGeneralInvAudit(calcTariffVO);
					
					//Setting calculated result in List
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

				// Setting Sum
				for(int i = 0; i<idxs.length;i++){
					if(idxs[i]>0){
						list1.get(i).setCalcAmt(idxs[i]+"");
					}
				}
				
				eventResponse.setRsVoList(list1);
			}
			else//In case of approval
				eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_PSO_0018 : Reject Button Click <br/>
	 * Handling reject@click in Requested Advance Payment page <br/>
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
			//Cancel 
			event.getCanalTzFeeEstDtlByVvdCondVO().setCnlTzBztpCd("E");//Set to money paid in advance work 
			event.getCanalTzFeeEstDtlByVvdCondVO().setUpdUsrId(account.getUsr_id());//Setting UpdateUser Info
			command.cancelCanalTzFeeEst ( event.getCanalTzFeeEstDtlByVvdCondVO() );
			
			//Remark Update
			command.modifyRemark(event.getAuditDataValidVOs());
			
			if(event.getCanalTzFeeEstDtlByVvdCondVO().getSts().equals("10")){//In case of Confirmed 
				//PSO_CHARGE/PSO_CHG_DTL/ApPayInvInfo --> Record Delete by inv_no

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
	 * Handling ToCSR@click in Requested Advance Payment page<br> 
	 * @param Event e
	 * @return
	 */
//	private EventResponse createEstApprovalRqst(Event e) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	/**
	 * VOP_PSO_0018 : Confirm Button Click <br>
	 * Handling confirm@click in Requested Advance Payment page<br>
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
			//Need TODO implement
			String strInvNo = command.createCanalTzFeeEst(event.getCanalTzFeeHdVO());
			eventResponse.setETCData("invoiceNo", strInvNo);
			//Logic of creating InvoiceData in practice 
			//Setting inv_no created  
			AuditDataValidVO[] auditDataValidVOs = event.getAuditDataValidVOs();
			for(int i=0; i<auditDataValidVOs.length;i++){
				auditDataValidVOs[i].setVvd(event.getCanalTzFeeHdVO().getVvd());
				auditDataValidVOs[i].setCnlTzBztpCd("E");//Set to money paid in advance work     
				auditDataValidVOs[i].setInvNo(strInvNo);
				auditDataValidVOs[i].setCreUsrId(account.getUsr_id());
				auditDataValidVOs[i].setUpdUsrId(account.getUsr_id());
				List<String> ofcCdList = OfficeCodeMgr.getOfficeCodeList(PsoConstants.HO_VSL_OP_TEAM, PsoConstants.OFC_MODULE);
				if(ofcCdList==null || ofcCdList.size()!=1){
					// PSO90015 No office code found. Please check [$s].
					throw new EventException(new ErrorHandler(PsoConstants.PSO90015, PsoConstants.HO_VSL_OP_TEAM).getMessage());
				}
				auditDataValidVOs[i].setOfcCd(ofcCdList.get(0));
				
			}
			
				begin();

				//INSERT PSO_CHARGE
				command1.manageGenInvAudit (auditDataValidVOs);
				
				strDebug = "2";
//				command1.searchPsoChargePk();
				
				//Step1.UPDATE PSO_CNL_TZ_FEE_DTL items
				//Step4.UPDATE Status code of PSO_CNL_TZ_FEE to A(Approved)
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
				apPayInvVO.setPsoTrnsSlpCtnt("GO");//
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
					
					//Update INV_RGST_NO by Return in PSO_CHAREGE TAble
					if(strInvRgstNo.equals("")){
						rollback();
						eventResponse.setUserMessage(new ErrorHandler("PSO90013").getUserMessage());//In case strInvRgstNo is not sent
					}
					else{
						vo.setInvRgstNo(strInvRgstNo);
						vo.setPsoChgStsCd("A");//Approved 
						List<String> ofcCdList = OfficeCodeMgr.getOfficeCodeList(PsoConstants.HO_VSL_OP_TEAM, PsoConstants.OFC_MODULE);
						if(ofcCdList==null || ofcCdList.size()!=1){
							// PSO90015 No office code found. Please check [$s].
							throw new EventException(new ErrorHandler(PsoConstants.PSO90015, PsoConstants.HO_VSL_OP_TEAM).getMessage());
						}
						vo.setInvOfcCd(ofcCdList.get(0));
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
	 * Handling window@open in Requested Advance Payment page<br>
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
			//Need TODO implement
			
			String flag = event.getCanalTzFeeEstDtlByVvdCondVO().getSts();
			List<CanalTzFeeEstDtlByVvdVO> list = null ;
			if(flag.equals("10") || flag.equals("12"))//In case of Approved, Paid
			{
				list = command.searchCanalTzFeeEstDtlByVvd(event.getCanalTzFeeEstDtlByVvdCondVO());
			}
			else{
				list = command.searchCanalTzFeeEstDtlByVvd(event.getCanalTzFeeEstDtlByVvdCondVO());
				//eventResponse.setRsVoList(list);
				//Need TODO implement
				//calGeneralInvAudit ( [in] auditDataValidVOs : AuditDataValidVO[] ) : AuditDataValidVO []

				for(int i=0; i<list.size();i++){
					CanalTzFeeEstDtlByVvdVO vo = (CanalTzFeeEstDtlByVvdVO)list.get(i);
					//changing in VO
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
					calcTariffVO.setIoFlag("O");//classify InBound/OutBound

//TODO ://					
					String strSdr = vo.getLoclXchRt();//Setting SDR sent by page  
					calcTariffVO.setSDR(strSdr);// SDR => [110]
					
					//Implement SCNT by same way 
					String strScnt = vo.getSuzNetTongWgt();
					calcTariffVO.setScnt(strScnt);//SCNT[38], SCNT1[98]
					calcTariffVO.setScntOne(strScnt);
					
					//Inputting Tier value got in page by same way  
					calcTariffVO.setTier(vo.getTrVolVal());
					
					// CalcTariffResultVO
					// tariffAmount
					// displayFormulaDesc
					// runtimeFormulaDesc
					//List<AuditDataValidVO> list1 = command1.calGeneralInvAudit(<AuditDataValidVO[]>auditDataValidVOs);
					//Return after adding item calculated in list chosen  
					CalcTariffResultVO resultvo = command1.calGeneralInvAudit(calcTariffVO);
					
					//Set result calculated in List
					vo.setCalcAmt(resultvo.getTariffAmount());
					vo.setDfltXprDesc(resultvo.getDisplayFormulaDesc());
					vo.setSysXprDesc(resultvo.getRuntimeFormulaDesc());
					
				}
			}
			//Grouping by SUBSTRING of cost code by VVD before setting list in event
			List<CanalTzFeeEstDtlByVvdVO> list2 = new ArrayList<CanalTzFeeEstDtlByVvdVO>() ;
			//
			String prvVvdCostCd = "-1";//this value is not available in practice
			float fval = 0;
			String strTmp = "";
			CanalTzFeeEstDtlByVvdVO prvVo = new CanalTzFeeEstDtlByVvdVO();
			for(int i=0; i<list.size();i++){
//				if(i==5)
//					i= i+0;
				CanalTzFeeEstDtlByVvdVO vo = (CanalTzFeeEstDtlByVvdVO)list.get(i);
				String curVvdCostCd = vo.getVslCd()+vo.getSkdVoyNo()+vo.getSkdDirCd();
				if(vo.getLgsCostCd()!=null && !vo.getLgsCostCd().equals(""))
					curVvdCostCd = curVvdCostCd + vo.getLgsCostCd().substring(0, 4);
				else{//handling independence --> In case of not exist cost code
					list2.add(prvVo);
					prvVo = vo;
					prvVvdCostCd = curVvdCostCd;
					if(i+1 == list.size()){
						list2.add(prvVo);
					}
					continue;
				}
				if(prvVvdCostCd.equals(curVvdCostCd)){//accumulating
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
				else{
					if(i==0){
						prvVo = vo;
						if(i+1 == list.size()){
							list2.add(prvVo);
						}
						else{//accumulating
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
	 * Retrieve searchVendorList in Canal Invoice page<br>
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
	 * Retrieve Vendor <br>
	 * @category VOP_PSO_0017_searchVendorList retrieve
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
		}
		// TODO Auto-generated method stub
		StringBuilder data = new StringBuilder();
		
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
		
				data.append(list.get(i).getVndrLglEngNm());
				data.append("^");
				data.append(list.get(i).getVndrSeq());
				if (i < list.size() - 1)
					data.append("|");
			}
		}
		eventResponse.setETCData("vendor", data.toString());
		return eventResponse;
	}

	/**VOP_PSO_0038 : In case of changin retrieve condition
	 * Retrieve Tariff of recent version 
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
	 * Retrieve Object, Invoice of Tariff 
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
			
			//Remove in case of Provider is not only one since Invoide Info retrieve is duplicated 
			/*Map<String, SimulationInvoiceListVO> invoices = new HashMap<String, SimulationInvoiceListVO>();
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
			}*/

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
	
	
	/**VOP_PSO_0038 : In case of changing Port/Account retrieve condition
	 * Retrieve Service Providers of Tariff chosen
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
	
	/**VOP_PSO_0038 : In case of changing Port/Yard/VVD retrieve condition
	 * Check whether VVD is vaild 
	 * @category VOP_PSO_0038
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkVVDBySimulation(Event e) throws EventException{
		VopPso0038Event event = (VopPso0038Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
		String vvd  		= event.getSimulationConditionVO().getVslCd() + event.getSimulationConditionVO().getSkdVoyNo() + event.getSimulationConditionVO().getSkdDirCd();
		String yard 		= event.getSimulationConditionVO().getPortCd() + event.getSimulationConditionVO().getYardCd();
		String clptIndSeq 	= event.getSimulationConditionVO().getClptIndSeq();
		try{
			boolean isValid = command.checkTurningPort(vvd, yard, clptIndSeq);

			eventResponse.setETCData("isValidVVD", isValid == true ? "FALSE" : "TRUE");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**VOP_PSO_0038 : In case of changing Port/Yard retrieve condition
	 * Retrieve Account used in Tariff
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
	
	/**VOP_PSO_0038 : In case of selecting Port 
	 * Retrieve yard used in Tariff
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
	
	/**VOP_PSO_0038 : In case of changing Port/Yard retrieve condition
	 * Retrieve Account used in Tariff
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
	
	/**VOP_PSO_0038 : In case of clpt_ind_seq
	 * Retrieve clpt_ind_seq
	 * @category VOP_PSO_0038
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchClptIndSeq(Event e) throws EventException{
		VopPso0038Event event = (VopPso0038Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSOCodeFinderBC command = new PSOCodeFinderBCImpl();
		try{
			String ydCd = event.getSimulationConditionVO().getPortCd() + event.getSimulationConditionVO().getYardCd();
			String vvd 	= event.getSimulationConditionVO().getVslCd() + event.getSimulationConditionVO().getSkdVoyNo() + event.getSimulationConditionVO().getSkdDirCd();
			
			//ex: 1|2|....|9  쿼리에서 만들어서 보냄.
			String clptIndSeqs = command.searchClptIndSeq(vvd, ydCd);
			
			//if(StringUtils.isEmpty(clptIndSeqs)) clptIndSeqs = "1"; //Default 1로 셋팅.
			
			eventResponse.setETCData("clptIndSeqs", clptIndSeqs);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**VOP_PSO_0038 : OPEN
	 * Showing vsl class registered by mdm_vsl_cntr table stardard<br>
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

	/**
	 * VOP_PSO_0014 : Before Confirm Button Click <br/>
	 * Confirm In case of Clicking Invoice Creation & Audit page<br />
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkArMasterRevenueByVvd(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		PSOCodeFinderBC command = new PSOCodeFinderBCImpl();
		
		try{
			//Port charge Invoic creation Detail VVD 정보
			InvAuditDataValidVO[] invAuditDataValidVOs = event.getAuditDataValidVOs();
			
			StringBuffer chkArVvd = new StringBuffer();
			int iNotArCnt = 0;
			String checkVvd = "";
			for( InvAuditDataValidVO vo : invAuditDataValidVOs){
				String checkYn = command.checkArMasterRevenueByVvd(vo.getVslCd(), vo.getSkdVoyNo(), vo.getSkdDirCd());
				//N : AR_MST_REV_VVD 존재 No, Y : AR_MST_REV_VVD 존재 Yes
				if("N".equals(checkYn)){
					String tmpVvd = vo.getVslCd()+vo.getSkdVoyNo()+vo.getSkdDirCd();
					if(iNotArCnt == 0){
						chkArVvd.append(tmpVvd);
					}else{
						if(!checkVvd.equals(tmpVvd)) chkArVvd.append(" , ").append(tmpVvd);
					}
					iNotArCnt++;
					checkVvd = tmpVvd;
				}
			}
			eventResponse.setETCData("EXIST_AR_VVD"		, chkArVvd.toString());
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
	 * 유저가 입력한 VVD에 따른 Vendor/Cost_ofc/Cost_cd/YD_CD/CLPT_IND_SEQ가 기존 입력된 Invoice가 있는지 체크
	 * @category VOP_PSO_0014_Sheet1Change
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkDoublePayInv(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopPso0014Event event = (VopPso0014Event)e;
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();
	    
		//master 의 vndrSeq, ydCd, costOfcCd, invNo

        try{
        	InvAuditDataValidVO[] invAuditDataValidVOs = event.getAuditDataValidVOs();
        	List<String> tmpList = new ArrayList<String>();
        	if(null != invAuditDataValidVOs && invAuditDataValidVOs.length > 0){
        		String tmpVndrSeq = event.getVndrSeq();
        		String tmpCostOfcCd = event.getCostOfcCd();
        		String tmpYdCd = event.getYdCd();
        		String tmpInvNo = event.getInvNo();
	        	for(InvAuditDataValidVO condVo : invAuditDataValidVOs){
	        		condVo.setVndrSeq(tmpVndrSeq);
	        		condVo.setCostOfcCd(tmpCostOfcCd);
	        		condVo.setYdCd(tmpYdCd);
	        		condVo.setInvNo(tmpInvNo);
	        		
	        		log.debug("========================================================== checkDoublePayInv START"+
	        		          "\n vndr_seq      ["+condVo.getVndrSeq()+"]"+
	        		          "\n cost_ofc_cd   ["+condVo.getCostOfcCd()+"]"+
	        		          "\n yd_cd         ["+condVo.getYdCd()+"]"+
	        		          "\n cost_cd       ["+condVo.getCostCd()+"]"+
	        		          "\n vsl_cd        ["+condVo.getVslCd()+"]"+
	        		          "\n skd_voy_no    ["+condVo.getSkdVoyNo()+"]"+
	        		          "\n skd_dir_cd    ["+condVo.getSkdDirCd()+"]"+
	        		          "\n clpt_ind_seq  ["+condVo.getClptIndSeq()+"]"+
	        		          "\n inv_no        ["+condVo.getInvNo()+"]"+
	        		          "========================================================== checkDoublePayInv E N D");
	        		
	        		
	        		List<String> list = command.checkDoublePayInv(condVo);
	        		
	        		if(null != list && list.size() > 0){
	        			String[] tmpTgtArr = ConvertUtils.listStringToStringArray(list);
	        			String[] tmpMergeArr = ConvertUtils.listStringToStringArray(tmpList);
	        			
	        			tmpMergeArr = (String[])StringUtilities.mergeStringArrays(tmpTgtArr, tmpMergeArr);
	        			
	        			tmpList = Arrays.asList(tmpMergeArr);
	        		}
	        	}
        	}
        	StringBuffer checkinfo	= new StringBuffer();
         	if(tmpList != null && tmpList.size() > 0){
				for (int i = 0; i < tmpList.size(); i++) {
					if(i==0){
						checkinfo.append(tmpList.get(i));
					}else{
						checkinfo.append(", " + tmpList.get(i));
					}
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
}