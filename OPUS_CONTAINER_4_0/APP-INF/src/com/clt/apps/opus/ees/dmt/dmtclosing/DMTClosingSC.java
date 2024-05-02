/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTClosingSC.java
*@FileTitle : Charge Calculation by Office & VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.basic.ChargeAmountDiscountMgtBC;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.basic.ChargeAmountDiscountMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.event.EesDmt2008Event;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.event.EesDmt2009Event;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGCNTRRequestVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGDetailInputVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGDetailVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGGRPVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListInputVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGRequestVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterProgressVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerParmVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.CommentHistoryVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3001Event;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3002Event;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3003Event;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3004Event;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3005Event;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3006Event;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3014Event;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3102Event;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3103Event;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3104Event;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3106Event;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3107Event;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt4016Event;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration.ChargeCalculationDBDAO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeByOfficeOrVVDVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationDetailVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeDetailVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DeleteReasonListVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgCorrHisVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtResultVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.EDIVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ManualChargeCreationVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.MovementSZPBBVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.VDMovementVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.basic.ChargeOfficeTransferMgtBC;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.basic.ChargeOfficeTransferMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.event.EesDmt3009Event;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.event.EesDmt3101Event;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.event.EesDmt3105Event;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.DmtOfcTrnsHisVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.OfficeTransferHistoryByContainerVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBC;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBCImpl;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CoverageVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CurrencyVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.OfficeNameVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.UserRoleVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.basic.RFAExceptionTariffMgtBC;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.basic.RFAExceptionTariffMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.basic.SCExceptionTariffMgtBC;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.basic.SCExceptionTariffMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.CalculationTypeParmVO;
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
 * OPUS-DMTClosing Business Logic ServiceCommand - OPUS-DMTClosing handling business transaction
 * 
 * @author 
 * @see ChargeCalculationDBDAO
 * @since J2EE 1.6
 */

public class DMTClosingSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * DMTClosing system preceding process for biz scenario<br>
	 * EES_DMT_3001 related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * DMTClosing system biz scenario closing<br>
	 * EES_DMT_3001 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("DMTClosingSC 종료");
	}

	/**
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		//DEM/DET Adjustment Request - After Booking Request
		if (e.getEventName().equalsIgnoreCase("EesDmt2008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAfterBookingList(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContainerChargeByBooking(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBookingData(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCommentHistory(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkCalcuationType(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkDupTariffBKGBLNo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = checkBalanceCharge(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchAfterNewDAR(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = cancelAfterBookingDAR(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {	// Confirm
				eventResponse = requestAfterBookingDAR(e);
			}			
		} 
		//DEM/DET Adjustment Request - After Booking Approval
		else if (e.getEventName().equalsIgnoreCase("EesDmt2009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAfterBookingList(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContainerChargeByBooking(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBookingData(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCommentHistory(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkCalcuationType(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkDupTariffBKGBLNo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = checkBalanceCharge(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchAfterNewDAR(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = cancelAfterBookingDAR(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = counterofferAfterBookingDAR(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = rejectAfterBookingDAR(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {	// Confirm
				eventResponse = requestAfterBookingDAR(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = doBackEndJobApproval(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = checkBackEndJobApproval(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = completeBackEndJobApproval(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt3001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChargeListByOfficeOrVVD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	// By POD ETA
				eventResponse = searchChargeListByPodEta(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		// Confirm
				eventResponse = confirmContainerCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	// GrpInv_ExRate
				eventResponse = searchGrpInvExRate(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {	// BackEndJob Start
				eventResponse = doBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {	// BackEndJob Status Check
				eventResponse = checkBackEndJob(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt3002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChargeByBookingList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	// By POD ETA
				eventResponse = searchChargeListByPodEta(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		// Confirm
				eventResponse = confirmContainerCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		// Delete Cancel
				eventResponse = removeCancelCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {		// PreCalculation
				eventResponse = precalDRDateChargeBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {		// D/R Save
				eventResponse = modifyCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {		// Balance Creation
				eventResponse = createBalanceCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {	// BackEndJob Start
				eventResponse = doBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {	// BackEndJob Status Check
				eventResponse = checkBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {	    // recalculation
				eventResponse = modifyChargeByBooking(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {	    // Today Daily Batch By booking
				eventResponse = createDailyBatchByBooking(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	// 일배치 대상 건수 체크
				eventResponse = checkDailyMovementCalculationByBooking(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {	// 일배치 대상 건수 체크
				eventResponse = checkCalculationByBooking(e);
			}	
		} else if (e.getEventName().equalsIgnoreCase("EesDmt3003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChargeByContainer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		// Confirm
				eventResponse = confirmContainerCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		// Delete Cancel
				eventResponse = removeCancelCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {		// PreCalculation
				eventResponse = precalDRDateCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {		// D/R Cancel
				eventResponse = cancelDRBalanceCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {		// Save
				eventResponse = modifyChargeByContainer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {	// Web Cancel
				eventResponse = modifyChargeByContainer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	// Web Cancel
				eventResponse = searchBalanceCount(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt3004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChargeStatusListByOfficeOrVVD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		// Delete Cancel
				eventResponse = removeCancelCharge(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt3005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChargeByBookingList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {	// BackEndJob Start
				eventResponse = doBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {	// BackEndJob Status Check
				eventResponse = checkBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {		// BackEndJob Result (PreCalculation)
				eventResponse = precalDRDateChargeBackEndJob(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("EesDmt3006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChargeByContainer(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt3009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfficeTransferHistoryList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt3101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createOfficeTransferCharge(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt3102Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPartialPayment(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {	// BackEndJob Start
				eventResponse = doBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {	// BackEndJob Status Check
				eventResponse = checkBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		// BackEndJob Result (Partial)
				eventResponse = createPartialPayment(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt3103Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCorrectionHistory(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt3104Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDeleteReasonList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = removeCharge(e);
//				eventResponse = requestChargeDeletion(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt3105Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfficeTransferHistoryListByContainer(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt3106Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = searchPODEta(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = searchVDMovementByPodEta(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {	// BackEndJob Start
				eventResponse = doBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {	// BackEndJob Status Check
				eventResponse = checkBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		// BackEndJob Result (Manual Batch by POD ETA)
				eventResponse = createManualCharge(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt3107Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChargeDetail(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt4016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchChargeBySZPBB(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMovementBySZPBB(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {	// BackEndJob Start
				eventResponse = doBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {	// BackEndJob Status Check
				eventResponse = checkBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		// BackEndJob Result (Calculate)
				eventResponse = createChargeBySZPBB(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = confirmContainerCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyChargeCorrRmk(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt3014Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
		    	eventResponse = searchDMTOfficeByApprovalOffice(e);
	     	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
		        eventResponse = searchChargeDeletionRequest(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = removeCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = rejectChargeDeletion(e);
			}
		}

		return eventResponse;
	}
	/**
	 * EES_DMT_2008 :  <br>
	 * DEM/DET Adjustment Request - Retrieving After Booking Request.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAfterBookingList(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		ChargeAmountDiscountMgtBC 	chgCommand 			= new ChargeAmountDiscountMgtBCImpl();
		CommonFinderBC 				cmnCommand 			= new CommonFinderBCImpl();
		
		AfterBKGListInputVO 		inputVO 			= null;
		List<AfterBKGListVO> 		afterBKGListVO		= null;
		List<AfterBKGListInputVO> 	afterBKGListInputVO	= null;
		String 						cntCd 				= null;
		String 						tariff 				= null;
		CoverageVO					coverageVO			= null;
		List<CurrencyVO> 			currencyVOS 		= null;
		
		StringBuffer 				sbCurrencyCodes 	= null;
		StringBuffer 				sbCurrencyNames 	= null;
		Map<String, String> 		mapCurrencyCodes	= new HashMap<String, String>();
		Map<String, String> 		mapCurrencyNames	= new HashMap<String, String>();
		
		if (e instanceof EesDmt2008Event) {
			inputVO = ((EesDmt2008Event)e).getAfterBKGListInputVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			inputVO = ((EesDmt2009Event)e).getAfterBKGListInputVO();
		}
		
		try{
			if(inputVO != null) {
				afterBKGListInputVO = chgCommand.searchAfterBookingDAR(inputVO);
				afterBKGListVO 		= chgCommand.searchAfterBookingList(inputVO);
			}

			if (afterBKGListVO != null && afterBKGListVO.size() > 0) {
				for (int i = 0 ; i < afterBKGListVO.size() ; i++) {
					
					tariff = afterBKGListVO.get(i).getDmdtTrfCd();
					if (tariff != null && tariff.length() > 3) {
						
						if ("M".equals(tariff.substring(1, 2))) {
							if ("I".equals(tariff.substring(2, 3))) {
								cntCd = afterBKGListVO.get(i).getPodCd();
							}
							else if ("O".equals(tariff.substring(2, 3))) {
								cntCd = afterBKGListVO.get(i).getPolCd();
							}
						}
						else if ("T".equals(tariff.substring(1, 2))) {
							if ("I".equals(tariff.substring(2, 3))) {
								cntCd = afterBKGListVO.get(i).getDelCd();
							}
							else if ("O".equals(tariff.substring(2, 3))) {
								cntCd = afterBKGListVO.get(i).getPorCd();
							}						
						}
						
						if (cntCd != null && cntCd.length() > 2) {
							cntCd = cntCd.substring(0, 2);
							
							if (!mapCurrencyCodes.containsKey(cntCd)) {

								coverageVO = new CoverageVO();
								coverageVO.setCntCd(cntCd);
								
								currencyVOS = cmnCommand.searchCurrencyList(coverageVO);
								if (currencyVOS != null && currencyVOS.size() > 0) {
									
									sbCurrencyCodes = new StringBuffer();
									sbCurrencyNames	= new StringBuffer();
									
									for (int j = 0 ; j < currencyVOS.size() ; j++) {
										
										sbCurrencyCodes.append(currencyVOS.get(j).getCurrCd());
										sbCurrencyNames.append(currencyVOS.get(j).getCurrCd());
										sbCurrencyNames.append("\t");
										sbCurrencyNames.append(currencyVOS.get(j).getCurrNm());

										if (j < currencyVOS.size()-1) {
											sbCurrencyCodes.append("|");
											sbCurrencyNames.append("|");
										}							
									}
									
									mapCurrencyCodes.put(cntCd, sbCurrencyCodes.toString());
									mapCurrencyNames.put(cntCd, sbCurrencyNames.toString());	
								}											
								//===================================================================================
							}
							afterBKGListVO.get(i).setAllCurrCd((String)mapCurrencyCodes.get(cntCd));
							afterBKGListVO.get(i).setAllCurrNm((String)mapCurrencyNames.get(cntCd));
						}
						else {
							afterBKGListVO.get(i).setAllCurrCd("");
							afterBKGListVO.get(i).setAllCurrNm("");
						}
					}
				}
			}
			if(afterBKGListVO != null) eventResponse.setRsVoList(afterBKGListVO);				
				
			if (afterBKGListInputVO != null && afterBKGListInputVO.size() > 0) {
				eventResponse.setETCData("APVL_OFC_CD", afterBKGListInputVO.get(0).getApvlOfcCd());
				eventResponse.setETCData("DAR_NO", afterBKGListInputVO.get(0).getDarNo());
				eventResponse.setETCData("APVL_NO", afterBKGListInputVO.get(0).getApvlNo());
				eventResponse.setETCData("STS_DESC", afterBKGListInputVO.get(0).getStsDesc());
				eventResponse.setETCData("SC_NO", afterBKGListInputVO.get(0).getScNo());
				eventResponse.setETCData("RFA_NO", afterBKGListInputVO.get(0).getRfaNo());
				eventResponse.setETCData("CUST_CD", afterBKGListInputVO.get(0).getCustCd());
				eventResponse.setETCData("CUST_NM", afterBKGListInputVO.get(0).getCustNm());
			}
			else {
				eventResponse.setETCData("APVL_OFC_CD", "");
				eventResponse.setETCData("DAR_NO", "");
				eventResponse.setETCData("APVL_NO", "");
				eventResponse.setETCData("STS_DESC", "");
				eventResponse.setETCData("SC_NO", "");
				eventResponse.setETCData("RFA_NO", "");
				eventResponse.setETCData("CUST_CD", "");
				eventResponse.setETCData("CUST_NM", "");			
			}
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EES_DMT_2008 :  <br>
	 * DEM/DET Adjustment Request - Retrieving payment Info of After Booking Request by Container.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerChargeByBooking(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		ChargeAmountDiscountMgtBC 		chgCommand 			= new ChargeAmountDiscountMgtBCImpl();
		CommonFinderBC 					cmnCommand 			= new CommonFinderBCImpl();

		String 							cntCd 				= null;
		String 							tariff 				= null;
		CoverageVO						coverageVO			= null;
		List<CurrencyVO> 				currencyVOS 		= null;
		
		ChargeBookingContainerParmVO 	paramVO 			= null;
		List<ChargeBookingContainerVO> 	containerListVO		= null;
		
		StringBuffer 					sbCurrencyCodes 	= null;
		StringBuffer 					sbCurrencyNames 	= null;
		Map<String, String> 			mapCurrencyCodes	= new HashMap<String, String>();
		Map<String, String> 			mapCurrencyNames	= new HashMap<String, String>();
		
		if (e instanceof EesDmt2008Event) {
			paramVO = ((EesDmt2008Event)e).getChargeBookingContainerParmVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			paramVO = ((EesDmt2009Event)e).getChargeBookingContainerParmVO();
		}		

		try{
			if(paramVO != null) {
				containerListVO = chgCommand.searchContainerChargeByBooking(paramVO);
			}
			
			if (containerListVO != null && containerListVO.size() > 0) {
				for (int i = 0 ; i < containerListVO.size() ; i++) {
					
					tariff = containerListVO.get(i).getDmdtTrfCd();
					if (tariff != null && tariff.length() > 3) {
						
						if ("M".equals(tariff.substring(1, 2))) {
							if ("I".equals(tariff.substring(2, 3))) {
								cntCd = containerListVO.get(i).getPodCd();
							}
							else if ("O".equals(tariff.substring(2, 3))) {
								cntCd = containerListVO.get(i).getPolCd();
							}
						}
						else if ("T".equals(tariff.substring(1, 2))) {
							if ("I".equals(tariff.substring(2, 3))) {
								cntCd = containerListVO.get(i).getDelCd();
							}
							else if ("O".equals(tariff.substring(2, 3))) {
								cntCd = containerListVO.get(i).getPorCd();
							}						
						}
						
						if (cntCd != null && cntCd.length() > 2) {
							cntCd = cntCd.substring(0, 2);
							
							if (!mapCurrencyCodes.containsKey(cntCd)) {

								coverageVO = new CoverageVO();
								coverageVO.setCntCd(cntCd);
								
								currencyVOS = cmnCommand.searchCurrencyList(coverageVO);
								if (currencyVOS != null && currencyVOS.size() > 0) {
									
									sbCurrencyCodes = new StringBuffer();
									sbCurrencyNames	= new StringBuffer();
									
									for (int j = 0 ; j < currencyVOS.size() ; j++) {
										
										sbCurrencyCodes.append(currencyVOS.get(j).getCurrCd());
										sbCurrencyNames.append(currencyVOS.get(j).getCurrCd());
										sbCurrencyNames.append("\t");
										sbCurrencyNames.append(currencyVOS.get(j).getCurrNm());

										if (j < currencyVOS.size()-1) {
											sbCurrencyCodes.append("|");
											sbCurrencyNames.append("|");
										}							
									}
									
									mapCurrencyCodes.put(cntCd, sbCurrencyCodes.toString());
									mapCurrencyNames.put(cntCd, sbCurrencyNames.toString());	
								}											
								//===================================================================================						
							}
							containerListVO.get(i).setAllCurrCd((String)mapCurrencyCodes.get(cntCd));
							containerListVO.get(i).setAllCurrNm((String)mapCurrencyNames.get(cntCd));
						}
						else {
							containerListVO.get(i).setAllCurrCd("");
							containerListVO.get(i).setAllCurrNm("");
						}
					}
				}
			}

			if(containerListVO != null) eventResponse.setRsVoList(containerListVO);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2008 :  <br>
	 * DEM/DET Adjustment Request - Retrieving Comment History of After Booking Request.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBookingData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AfterBKGDetailInputVO inputVO = null;
		if (e instanceof EesDmt2008Event) {
			inputVO = ((EesDmt2008Event)e).getAfterBKGDetailInputVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			inputVO = ((EesDmt2009Event)e).getAfterBKGDetailInputVO();
		}
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();

		try{
			if(inputVO != null) {
				List<AfterBKGDetailVO> afterBKGDetailVOList = command.searchBookingData(inputVO);
				
				if (afterBKGDetailVOList != null && afterBKGDetailVOList.size() > 0) {
					eventResponse.setETCData("TVVD", afterBKGDetailVOList.get(0).getTvvd());
					eventResponse.setETCData("POR", afterBKGDetailVOList.get(0).getPorCd());
					eventResponse.setETCData("POL", afterBKGDetailVOList.get(0).getPolCd());
					eventResponse.setETCData("POD", afterBKGDetailVOList.get(0).getPodCd());
					eventResponse.setETCData("DEL", afterBKGDetailVOList.get(0).getDelCd());
					eventResponse.setETCData("RD", afterBKGDetailVOList.get(0).getRd());
					eventResponse.setETCData("DG_FLG", afterBKGDetailVOList.get(0).getDcgoFlg());
					eventResponse.setETCData("RF_FLG", afterBKGDetailVOList.get(0).getRcFlg());
					eventResponse.setETCData("AK_FLG", afterBKGDetailVOList.get(0).getAwkCgoFlg());
					eventResponse.setETCData("BB_FLG", afterBKGDetailVOList.get(0).getBbCgoFlg());
					eventResponse.setETCData("RD_FLG", afterBKGDetailVOList.get(0).getRdCgoFlg());
					eventResponse.setETCData("SOC_FLG", afterBKGDetailVOList.get(0).getSocFlg());
					eventResponse.setETCData("CMDT_CD", afterBKGDetailVOList.get(0).getCmdtCd());
					eventResponse.setETCData("CMDT_NM", afterBKGDetailVOList.get(0).getCmdtNm());
					eventResponse.setETCData("SC_NO", afterBKGDetailVOList.get(0).getScNo());
					eventResponse.setETCData("RFA_NO", afterBKGDetailVOList.get(0).getRfaNo());
					eventResponse.setETCData("BKG_NO", afterBKGDetailVOList.get(0).getBkgNo());	
					eventResponse.setETCData("BL_NO", afterBKGDetailVOList.get(0).getBlNo());
					eventResponse.setETCData("CUST_CD", afterBKGDetailVOList.get(0).getCustCd());
					eventResponse.setETCData("CUST_NM", afterBKGDetailVOList.get(0).getCustNm());
				}
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	
	/**
	 * EES_DMT_2008 :  <br>
	 * DEM/DET Adjustment Request - Retrieving Comment History of After Booking Request.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommentHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AfterBKGListInputVO inputVO = null;
		if (e instanceof EesDmt2008Event) {
			inputVO = ((EesDmt2008Event)e).getAfterBKGListInputVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			inputVO = ((EesDmt2009Event)e).getAfterBKGListInputVO();
		}		
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();

		try{
			if(inputVO != null) {
				List<CommentHistoryVO> commentHistoryVOList = command.searchCommentHistory(inputVO);
				eventResponse.setRsVoList(commentHistoryVOList);
			}
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	
	/**
	 * EES_DMT_2008 :  <br>
	 * DEM/DET Adjustment Request - handling checking process of Tariff Type by BKG/B/L No of After Booking Request.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCalcuationType(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		AfterBKGListInputVO inputVO = null;
		
		String cntCd = null;
		String rgnCd = null;
		String steCd = null;
		String locCd = null;
		String calcTypeCd = null;
		
		if (e instanceof EesDmt2008Event) {
			inputVO = ((EesDmt2008Event)e).getAfterBKGListInputVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			inputVO = ((EesDmt2009Event)e).getAfterBKGListInputVO();
		}
		
		try{
			if(inputVO != null) {
				boolean result = command.checkCalcuationType(inputVO);			
		
				if (!result) {
					if(inputVO != null) {
						locCd = command.searchLocationByBKGBLNo(inputVO);
						eventResponse.setETCData("LOC", locCd);
					}
					
					CommonFinderBC cmmonCommand = new CommonFinderBCImpl();
					CoverageVO coverageVO = new CoverageVO();
					coverageVO.setLocCd(locCd);
					List<CoverageVO> coverageList = cmmonCommand.searchContinentHierarchyByLocation(coverageVO);
					if (coverageList != null && coverageList.size() > 0) {
						cntCd = coverageList.get(0).getCntCd();
						if ("CA".equals(locCd.substring(0, 2)) || "US".equals(locCd.substring(0, 2))) {
							steCd = coverageList.get(0).getSteCd();	
						}
						else {
							rgnCd = coverageList.get(0).getRgnCd();	
						}
					}
	
					SCExceptionTariffMgtBC scCommand = new SCExceptionTariffMgtBCImpl();
					CalculationTypeParmVO calcParmVO = new CalculationTypeParmVO();
					if(inputVO != null) calcParmVO.setIoBndCd(inputVO.getTariff().substring(2, 3));
					if(inputVO != null) calcParmVO.setDmdtCalcTpCd(inputVO.getTariff().substring(0, 1));
					if(cntCd != null) calcParmVO.setCntCd(cntCd);
					if(rgnCd != null) calcParmVO.setRgnCd(rgnCd);
					if(steCd != null) calcParmVO.setSteCd(steCd);
					calcParmVO.setLocCd(locCd);
					result = scCommand.checkCalcType(calcParmVO);
				}
				eventResponse.setETCData("CHECK_CALC", result ? "Y" : "N");
				
				if (!result) {
					calcTypeCd = command.searchCalcTypeCode(locCd, inputVO.getTariff().substring(2, 3));
					eventResponse.setETCData("CALC_TYPE", calcTypeCd);
				}
				else {
					eventResponse.setETCData("LOC", "");
					eventResponse.setETCData("CALC_TYPE", "");
				}
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}		
	/**
	 * EES_DMT_2008 :  <br>
	 * DEM/DET Adjustment Request - handling checking process of duplication of Tariff Type and BKG or B/L No of After Booking Request.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDupTariffBKGBLNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AfterBKGListInputVO inputVO = null;
		if (e instanceof EesDmt2008Event) {
			inputVO = ((EesDmt2008Event)e).getAfterBKGListInputVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			inputVO = ((EesDmt2009Event)e).getAfterBKGListInputVO();
		}
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();

		try{
			String darNo = "";
			if(inputVO != null) {
				darNo = command.checkDupTariffBKGBLNo(inputVO);
			}
			//String darNo = command.checkDupTariffBKGBLNo(inputVO);
			eventResponse.setETCData("DAR_NO", darNo != null ? darNo : "");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2008 :  <br>
	 * DEM/DET Adjustment Request -  handling checking event process of CNTR having Balance Charge of After Booking Request.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkBalanceCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AfterBKGListInputVO inputVO = null;
		if (e instanceof EesDmt2008Event) {
			inputVO = ((EesDmt2008Event)e).getAfterBKGListInputVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			inputVO = ((EesDmt2009Event)e).getAfterBKGListInputVO();
		}
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();

		try{
			if(inputVO != null) {
				boolean result = command.checkBalanceCharge(inputVO);
				eventResponse.setETCData("CHECK_BALCHG", result ? "Y" : "N");
			}else{
				eventResponse.setETCData("CHECK_BALCHG", "");
			}
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * Creating and Retrieving DAR No.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAfterNewDAR(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 		= new RFAExceptionTariffMgtBCImpl();
		String 						darNo 			= command.searchNewDAR(account, "A");
		
		eventResponse.setETCData("DAR", darNo);
		return eventResponse;
	}
	/**
	 * Canceling registered After Booking DAR.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelAfterBookingDAR(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AfterProgressVO afterProgressVO = null;
		if (e instanceof EesDmt2008Event) {
			afterProgressVO = ((EesDmt2008Event)e).getAfterProgressVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			afterProgressVO = ((EesDmt2009Event)e).getAfterProgressVO();
		}		
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();

		//Set Parameters 
		if(afterProgressVO != null) {
			afterProgressVO.setCreUsrId(account.getUsr_id());
			afterProgressVO.setCreOfcCd(account.getOfc_cd());
			afterProgressVO.setUpdUsrId(account.getUsr_id());
			afterProgressVO.setUpdOfcCd(account.getOfc_cd());
		}
		
		try {
			if(afterProgressVO != null) {
				begin();
				command.cancelAfterBookingDAR(afterProgressVO);
				commit();
				
				if ("Y".equals(afterProgressVO.getPopupFlag()))
					eventResponse.setETCData("upd_dt", command.searchUpdateDate(afterProgressVO));
			}
			
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
	 * Counter Offering registered After Booking DAR.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse counterofferAfterBookingDAR(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AfterProgressVO afterProgressVO = null;
		if (e instanceof EesDmt2008Event) {
			afterProgressVO = ((EesDmt2008Event)e).getAfterProgressVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			afterProgressVO = ((EesDmt2009Event)e).getAfterProgressVO();
		}		
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();

		//Set Parameters 
		if(afterProgressVO != null) {
			afterProgressVO.setCreUsrId(account.getUsr_id());
			afterProgressVO.setCreOfcCd(account.getOfc_cd());
			afterProgressVO.setUpdUsrId(account.getUsr_id());
			afterProgressVO.setUpdOfcCd(account.getOfc_cd());
		}
		
		try {
			if(afterProgressVO != null) {
				begin();
				command.counterofferAfterBookingDAR(afterProgressVO);
				commit();
				
				if ("Y".equals(afterProgressVO.getPopupFlag()))
					eventResponse.setETCData("upd_dt", command.searchUpdateDate(afterProgressVO));
			}
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}			
		
		return eventResponse;
	}
	/**
	 * Rejecting registered After Booking DAR.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse rejectAfterBookingDAR(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AfterProgressVO afterProgressVO = null;
		if (e instanceof EesDmt2008Event) {
			afterProgressVO = ((EesDmt2008Event)e).getAfterProgressVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			afterProgressVO = ((EesDmt2009Event)e).getAfterProgressVO();
		}		
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();

		//Set Parameters 
		if(afterProgressVO != null) {
			afterProgressVO.setCreUsrId(account.getUsr_id());
			afterProgressVO.setCreOfcCd(account.getOfc_cd());
			afterProgressVO.setUpdUsrId(account.getUsr_id());
			afterProgressVO.setUpdOfcCd(account.getOfc_cd());
		}
		
		try {
			if(afterProgressVO != null) {
				begin();
				command.rejectAfterBookingDAR(afterProgressVO);
				commit();
				
				if ("Y".equals(afterProgressVO.getPopupFlag()))
					eventResponse.setETCData("upd_dt", command.searchUpdateDate(afterProgressVO));
			}
			
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
	 * EES_DMT_2008 :  <br>
	 * DEM/DET Adjustment Request - handling check process of CNTR having Balance Charge of After Booking Request.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse requestAfterBookingDAR(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 			= new GeneralEventResponse();
		AfterProgressVO 			afterProgressVO 		= null;
		AfterBKGRequestVO[] 		afterBKGRequestVOS 		= null;
		AfterBKGCNTRRequestVO[] 	afterBKGCNTRRequestVOS 	= null;
		if (e instanceof EesDmt2008Event) {
			afterProgressVO 		= ((EesDmt2008Event)e).getAfterProgressVO();
			afterBKGRequestVOS 		= ((EesDmt2008Event)e).getAfterBKGRequestVOS();
			afterBKGCNTRRequestVOS 	= ((EesDmt2008Event)e).getAfterBKGCNTRRequestVOS();
		} 
		else if (e instanceof EesDmt2009Event) {
			afterProgressVO 		= ((EesDmt2009Event)e).getAfterProgressVO();
			afterBKGRequestVOS 		= ((EesDmt2009Event)e).getAfterBKGRequestVOS();
			afterBKGCNTRRequestVOS 	= ((EesDmt2009Event)e).getAfterBKGCNTRRequestVOS();
		}		
		
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		AfterBKGGRPVO afterBKGGRPVO = new AfterBKGGRPVO();
		if(afterProgressVO != null) 				afterBKGGRPVO.setAfterProgressVO(afterProgressVO);
		if(afterBKGRequestVOS != null) 			afterBKGGRPVO.setAfterBKGRequestVOS(afterBKGRequestVOS);
		if(afterBKGCNTRRequestVOS != null) 	afterBKGGRPVO.setAfterBKGCNTRRequestVOS(afterBKGCNTRRequestVOS);
		
		try {
			begin();
			command.requestAfterBookingDAR(afterBKGGRPVO, account);
			commit();
			
			if(afterProgressVO != null) {
				if ("Y".equals(afterProgressVO.getPopupFlag()))
					eventResponse.setETCData("upd_dt", command.searchUpdateDate(afterProgressVO));
			}
			
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
	 * EES_DMT_3001 : Charge by Office & VVD <br>
	 * Retrieving Charge List by Office or VVD.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeListByOfficeOrVVD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3001Event event = (EesDmt3001Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();

		try{
			List<ChargeCalculationContainerVO> list = command.searchChargeListByOfficeOrVVD(event.getChargeByOfficeOrVVDVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3001, EES_DMT_3002 :  <br>
	 * Retrieving Container List by Yard.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeListByPodEta(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();

		try{
			ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO = null;
			
			if(e instanceof EesDmt3001Event) {
				chargeByOfficeOrVVDVO = ((EesDmt3001Event)e).getChargeByOfficeOrVVDVO();
			} else if(e instanceof EesDmt3002Event) {
				chargeByOfficeOrVVDVO = ((EesDmt3002Event)e).getChargeByOfficeOrVVDVO();
			}
			
			DmtResultVO dmtResultVO = null;
			if(chargeByOfficeOrVVDVO != null) {
				dmtResultVO = command.searchChargeListByPodEta(chargeByOfficeOrVVDVO);
			}
			//[2015.05.28]소스품질 Modify
			if(null != dmtResultVO){
				if("DMT01075".equals(dmtResultVO.getResultCode()) || "DMT01129".equals(dmtResultVO.getResultCode())) {
					eventResponse.setUserMessage(new ErrorHandler(dmtResultVO.getResultCode()).getUserMessage());
					
				} else {
					eventResponse.setETCData(dmtResultVO.getEtcData());
					eventResponse.setRsVoList(dmtResultVO.getChargeCalculationContainerVOs());
					
					if("DMT01053".equals(dmtResultVO.getResultCode())) {
						eventResponse.setUserMessage(dmtResultVO.getResultMsg());
						
					} else {
						List<ChargeCalculationContainerVO> list = dmtResultVO.getChargeCalculationContainerVOs();
						if(list != null) {
							HashMap<String, String> cntrInfo = new HashMap<String, String>();
							
							for(int i=0; i < list.size(); i++) {
								ChargeCalculationContainerVO vo = list.get(i);
								
								if(!cntrInfo.containsKey(vo.getCntrNo())) {
									cntrInfo.put(vo.getCntrNo(), "");
								}
							}
							
							eventResponse.setETCData("cntr_qty", String.valueOf(cntrInfo.size()));
						}
					}
				}
			}
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3001, EES_DMT_3002, EES_DMT_3003 :  <br>
	 * Confirming for occurred Charge.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmContainerCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		String msg = "";
		
		try{
			begin();
			if(e instanceof EesDmt3001Event) {
				msg = command.confirmContainerCharge(((EesDmt3001Event)e).getChargeCalculationContainerVOS(),account);
			} else if(e instanceof EesDmt3002Event) {
				msg = command.confirmContainerCharge(((EesDmt3002Event)e).getChargeCalculationContainerVOS(),account);
			} else if(e instanceof EesDmt3003Event) {
				ChargeCalculationContainerVO[] chargeCalculationContainerVOs = new ChargeCalculationContainerVO[1];
				chargeCalculationContainerVOs[0] = ((EesDmt3003Event)e).getChargeCalculationContainerVO();
				msg = command.confirmContainerCharge(chargeCalculationContainerVOs,account);
			} else if(e instanceof EesDmt4016Event) {
				msg = command.confirmContainerCharge(((EesDmt4016Event)e).getChargeCalculationContainerVOs(),account);
			}
			if(!msg.equals("")){
				rollback();
				eventResponse.setUserMessage(msg);
			}else{
				commit();
			}
		}catch(EventException ex){
			log.debug("error (1) "+ex.getMessage());
			rollback();
			//throw ex;
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			log.debug("error (2) "+ex.getMessage());
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_4016 : Save
	 * Updating  CorrRmk Info of Charge.
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyChargeCorrRmk(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt4016Event event = (EesDmt4016Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();

		try{
			begin();
			command.modifyChargeCorrRmk(event.getChargeArgumentVO());
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
	 * EES_DMT_3001 : GRP INV Creation
	 * Retrieving Exchange Rate Info of Charge for GRP INV Creation.
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGrpInvExRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3001Event event = (EesDmt3001Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();

		try{
			List<ChargeCalculationContainerVO> list = command.searchGrpInvExRate(event.getChargeCalculationContainerVOS());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3002, EES_DMT_3003, EES_DMT_3004 :  <br>
	 * Retrieving Container Charge List by Booking.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeByBookingList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//EesDmt3002Event event = (EesDmt3002Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();

		try{
			DmtResultVO dmtResultVO = null;
			
			if(e instanceof EesDmt3002Event)
				dmtResultVO = command.searchChargeByBookingList(((EesDmt3002Event)e).getChargeArgumentVO());
			else if(e instanceof EesDmt3005Event)
				dmtResultVO = command.searchChargeByBookingList(((EesDmt3005Event)e).getChargeArgumentVO());
			
			if(dmtResultVO != null) {
				eventResponse.setETCData(dmtResultVO.getEtcData());
				eventResponse.setRsVoList(dmtResultVO.getChargeCalculationContainerVOs());
			}
			
			List<ChargeCalculationContainerVO> list = null;
			if(dmtResultVO != null) {
				list = dmtResultVO.getChargeCalculationContainerVOs();
			}
			//[2015.05.28]소스품질 Modify
			//if(list.size() > 0) {
			if(null != list && list.size() > 0) {
				HashMap<String, String> cntrInfo = new HashMap<String, String>();
				
				for(int i=0; i < list.size(); i++) {
					ChargeCalculationContainerVO vo = list.get(i);
					
					if(!cntrInfo.containsKey(vo.getCntrNo())) {
						cntrInfo.put(vo.getCntrNo(), "");
					}
				}
				eventResponse.setETCData("cntr_qty", String.valueOf(cntrInfo.size()));
			}
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3002, EES_DMT_3003, EES_DMT_3004 :  <br>
	 * Restoring Deleted Charge to previous Status.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeCancelCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		String msg = "";
		try{
			ChargeCalculationContainerVO[] chargeCalculationContainerVOs = null;
			
			begin();
			if(e instanceof EesDmt3002Event) {
				chargeCalculationContainerVOs = ((EesDmt3002Event)e).getChargeCalculationContainerVOS();
				msg = command.removeCancelCharge(chargeCalculationContainerVOs, account);
			} else if(e instanceof EesDmt3003Event) {
				chargeCalculationContainerVOs = new ChargeCalculationContainerVO[1];
				chargeCalculationContainerVOs[0] = ((EesDmt3003Event)e).getChargeCalculationContainerVO();
				msg = command.removeCancelCharge(chargeCalculationContainerVOs, account);
			} else if(e instanceof EesDmt3004Event) {
				chargeCalculationContainerVOs = ((EesDmt3004Event)e).getChargeCalculationContainerVOS();
				msg = command.removeCancelCharge(chargeCalculationContainerVOs, account);
			}
			
			if(!msg.equals("")) {
				rollback();
				eventResponse.setUserMessage(msg);
			}else{
				commit();
			}

			
		}catch(EventException ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
			//throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3002, EES_DMT_3005 : Pre Cal.<br>
	 * Input DR Data on To Data of Charge and Retrieving calculated sum before saving.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse precalDRDateCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();

		try{
			ChargeArgumentVO chargeArgumentVO = null;
			ChargeCalculationContainerVO[] chargeCalculationContainerVOs = null;
			
			
			if(e instanceof EesDmt3002Event) {
				chargeArgumentVO = ((EesDmt3002Event)e).getChargeArgumentVO();
				chargeCalculationContainerVOs = ((EesDmt3002Event)e).getChargeCalculationContainerVOS();
			} else if(e instanceof EesDmt3003Event) {
				chargeCalculationContainerVOs = ((EesDmt3003Event)e).getChargeCalculationContainerVOS();
			} else if(e instanceof EesDmt3005Event) {
				chargeArgumentVO = ((EesDmt3005Event)e).getChargeArgumentVO();
				chargeCalculationContainerVOs = ((EesDmt3005Event)e).getChargeCalculationContainerVOS();
			}
			
			begin();
			DmtResultVO resultVO = command.precalDRDateCharge(chargeArgumentVO, chargeCalculationContainerVOs, account);
			
			if(resultVO.getResultCode() == null) {
				commit();
				
				if(chargeArgumentVO != null)
					eventResponse.setRsVoList(resultVO.getChargeCalculationContainerVOs());
				
			} else {
				rollback();
				
				if(resultVO.getResultMsg() != null)
					eventResponse.setUserMessage(resultVO.getResultMsg());
				else
					eventResponse.setUserMessage(new ErrorHandler(resultVO.getResultCode()).getUserMessage());
			}
			
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
	 * EES_DMT_3002, EES_DMT_3005 : Pre Cal.<br>
	 * Return Pre Calculation BackEndJob process result.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse precalDRDateChargeBackEndJob(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			ChargeArgumentVO chargeArgumentVO = null;
			
			if(e instanceof EesDmt3002Event) {
				chargeArgumentVO = ((EesDmt3002Event)e).getChargeArgumentVO();
			} else if(e instanceof EesDmt3005Event) {
				chargeArgumentVO = ((EesDmt3005Event)e).getChargeArgumentVO();
			}
			
			String key = "";
			if(chargeArgumentVO != null) {
				key = chargeArgumentVO.getBackendjobKey();
			}
			DmtResultVO resultVO = (DmtResultVO)BackEndJobResult.loadFromFile(key);
			
			if(resultVO.getResultCode() == null) {
				eventResponse.setRsVoList(resultVO.getChargeCalculationContainerVOs());
				
			} else {
				if(resultVO.getResultMsg() != null)
					eventResponse.setUserMessage(resultVO.getResultMsg());
				else
					eventResponse.setUserMessage(new ErrorHandler(resultVO.getResultCode()).getUserMessage());
			}
		
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3002, EES_DMT_3005, EES_DMT_3102, EES_DMT_3106, EES_DMT_4016 : Pre Cal.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse doBackEndJob(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();

		try{
			ChargeArgumentVO chargeArgumentVO = null;
			ChargeCalculationContainerVO[] chargeCalculationContainerVOs = null;
			String backEndJobKey = null;
			if(e instanceof EesDmt3001Event) {
				chargeArgumentVO = ((EesDmt3001Event)e).getChargeArgumentVO();
				chargeCalculationContainerVOs = ((EesDmt3001Event)e).getChargeCalculationContainerVOS();
				
			} else if(e instanceof EesDmt3002Event) {
				chargeArgumentVO = ((EesDmt3002Event)e).getChargeArgumentVO();
				chargeCalculationContainerVOs = ((EesDmt3002Event)e).getChargeCalculationContainerVOS();
				
			} else if(e instanceof EesDmt3005Event) {
				chargeArgumentVO = ((EesDmt3005Event)e).getChargeArgumentVO();
				chargeCalculationContainerVOs = ((EesDmt3005Event)e).getChargeCalculationContainerVOS();
				
			} else if(e instanceof EesDmt3102Event) {
				chargeArgumentVO = ((EesDmt3102Event)e).getChargeArgumentVO();
				chargeCalculationContainerVOs = ((EesDmt3102Event)e).getChargeCalculationContainerVOS();
				
			} else if(e instanceof EesDmt3106Event) {
				chargeArgumentVO = ((EesDmt3106Event)e).getChargeArgumentVO();
				chargeCalculationContainerVOs = ((EesDmt3106Event)e).getChargeCalculationContainerVOs();
				
			} else if(e instanceof EesDmt4016Event) {
				chargeArgumentVO = ((EesDmt4016Event)e).getChargeArgumentVO();
				chargeCalculationContainerVOs = ((EesDmt4016Event)e).getChargeCalculationContainerVOs();
			}
			
			backEndJobKey = command.doBackEndJob(chargeArgumentVO, chargeCalculationContainerVOs, account);
			eventResponse.setETCData("BackEndJobKey", backEndJobKey);
			
		}catch(EventException ex){
			throw ex;
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_2009 : btn_approval<br>
	 * Retrieving Long Tx status<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse checkBackEndJob(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		
		try{
			ChargeArgumentVO chargeArgumentVO = null;
			
			if(e instanceof EesDmt3001Event) {
				chargeArgumentVO = ((EesDmt3001Event)e).getChargeArgumentVO();
			} else if(e instanceof EesDmt3002Event) {
				chargeArgumentVO = ((EesDmt3002Event)e).getChargeArgumentVO();
			} else if(e instanceof EesDmt3005Event) {
				chargeArgumentVO = ((EesDmt3005Event)e).getChargeArgumentVO();
			} else if(e instanceof EesDmt3102Event) {
				chargeArgumentVO = ((EesDmt3102Event)e).getChargeArgumentVO();
			} else if(e instanceof EesDmt3106Event) {
				chargeArgumentVO = ((EesDmt3106Event)e).getChargeArgumentVO();
			} else if(e instanceof EesDmt4016Event) {
				chargeArgumentVO = ((EesDmt4016Event)e).getChargeArgumentVO();
			}
			
			//[2015.05.28]소스품질 Modify
			if(null != chargeArgumentVO){
				String[] result = command.checkBackEndJob(chargeArgumentVO.getBackendjobKey());
				eventResponse.setETCData("jb_sts_flg",		result[0]);
				eventResponse.setETCData("jb_usr_err_msg",	result[1]);
			}else{
				eventResponse.setETCData("jb_sts_flg",		"");
				eventResponse.setETCData("jb_usr_err_msg",	"");
			}
			/*String[] result = command.checkBackEndJob(chargeArgumentVO.getBackendjobKey());
			eventResponse.setETCData("jb_sts_flg",		result[0]);
			eventResponse.setETCData("jb_usr_err_msg",	result[1]);*/
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3002 : D/R Save<br>
	 * Updating Container Charge Info.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3002Event event = (EesDmt3002Event)e;

		try{
			ChargeArgumentVO chargeArgumentVO = event.getChargeArgumentVO();
			
			String key = chargeArgumentVO.getBackendjobKey();
			DmtResultVO resultVO = (DmtResultVO)BackEndJobResult.loadFromFile(key);
			
			if(resultVO.getResultCode() != null){
				if(resultVO.getResultMsg() != null)
					eventResponse.setUserMessage(resultVO.getResultMsg());
				else
					eventResponse.setUserMessage(new ErrorHandler(resultVO.getResultCode()).getUserMessage());
			}
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3002 : Balance Creation<br>
	 * Creating Balance Charge.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBalanceCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3002Event event = (EesDmt3002Event)e;

		try{
			ChargeArgumentVO chargeArgumentVO = event.getChargeArgumentVO();
			
			String key = chargeArgumentVO.getBackendjobKey();
			DmtResultVO resultVO = (DmtResultVO)BackEndJobResult.loadFromFile(key);
			
			if(resultVO.getResultCode() == null) {
				if(resultVO.getResultMsg() != null)
					eventResponse.setUserMessage(resultVO.getResultMsg());
				else
					eventResponse.setUserMessage(new ErrorHandler(resultVO.getResultCode()).getUserMessage());
			}
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3006 : Charge Inquiry by CNTR <br>
	 * Retrieving a Charge by Container or Tariff Type.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeByContainer(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();

		try{
			ChargeArgumentVO chargeArgumentVO = null;
			
			if(e instanceof EesDmt3003Event) {
				chargeArgumentVO = ((EesDmt3003Event)e).getChargeArgumentVO();
			} else if(e instanceof EesDmt3006Event) {
				chargeArgumentVO = ((EesDmt3006Event)e).getChargeArgumentVO();
			}
			
			DmtResultVO resultVO = null;
			if(chargeArgumentVO != null) {
				chargeArgumentVO.setOfcCd(account.getOfc_cd());			
				resultVO = command.searchChargeByContainer(chargeArgumentVO);
				
				//[2015.05.28]소스품질 Modify
				eventResponse.setETCData(resultVO.getEtcData());
				eventResponse.setRsVoList(resultVO.getChrgDtlVOs());
			}
			
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3003 : D/R Cancel <br>
	 * Deleting all Balance Charge with DR excluded General Charge.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelDRBalanceCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3003Event event = (EesDmt3003Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();

		try{
			begin();
			String result = command.cancelDRBalanceCharge(event.getChargeCalculationContainerVO(), account);
			
			if(result != null && !result.equals("")) { 				
				eventResponse.setUserMessage(new ErrorHandler(result).getUserMessage());
				rollback();
			} else {
				commit();
			}
			
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
	 * EES_DMT_3003 : Save <br>
	 * Updating Container Charge Info.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyChargeByContainer(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3003Event event = (EesDmt3003Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();

		try{
			begin();
			DmtResultVO resultVO = command.modifyChargeByContainer(event.getChargeCalculationContainerVO(), account);
			
			if(resultVO.getResultCode() == null) {
				commit();
				
			} else {
				rollback();
				
				if(resultVO.getResultMsg() != null)
					eventResponse.setUserMessage(resultVO.getResultMsg());
				else
					eventResponse.setUserMessage(new ErrorHandler(resultVO.getResultCode()).getUserMessage());
			}
			
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
	 * EES_DMT_3003 :  <br>
	 * Search Balance Count<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBalanceCount(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3003Event event = (EesDmt3003Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();

		try{
			String count = command.searchBalanceCount(event.getChargeCalculationContainerVO());
			eventResponse.setETCData("COUNT", count);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	
	/**
	 * EES_DMT_3004 : Charge Inquiry by Office & VVD <br>
	 * Retrieving Charge List created by Office or VVD별 Charge.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeStatusListByOfficeOrVVD(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3004Event event = (EesDmt3004Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();

		try{
			List<ChargeCalculationContainerVO> list = command.searchChargeStatusListByOfficeOrVVD(event.getChargeByOfficeOrVVDVO());
			eventResponse.setRsVoList(list);

			UserRoleVO paramRoleVO = new UserRoleVO();
			paramRoleVO.setUsrId(account.getUsr_id());
			paramRoleVO.setPgmNo("EES_DMT_3002");
			paramRoleVO.setUsrRoleCd("DMT01,DMT02,DMT03,DMT04");
			
			CommonFinderBC command2 = new CommonFinderBCImpl();
			UserRoleVO roleVO = command2.hasRoleAuth(paramRoleVO);

			eventResponse.setETCData("ROLE_PERMIT",	roleVO.getIsAuthorized());
			eventResponse.setETCData("ROLE_AUTH",	roleVO.getUsrRoleCd());
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3103 : Correction History <br>
	 * Retrieving History calculated by Charge.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCorrectionHistory(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3103Event event = (EesDmt3103Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		
		try{
			List<DmtChgCorrHisVO> list = command.searchCorrectionHistory(event.getChargeArgumentVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3104 : Open
	 * Retrieving Delete Reason List when Charge is deleted.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDeleteReasonList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		
		try{
			List<DeleteReasonListVO> list = command.searchDeleteReasonList();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3104 : Save
	 * Deleting Charge.
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3104Event event = (EesDmt3104Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		try{
			begin();
			String result = command.removeCharge(event.getChargeCalculationContainerVOS(), account);
			
			if(!"".equals(result)) {
				eventResponse.setUserMessage(new ErrorHandler(result).getUserMessage());
				rollback();
			} else
				commit();
		}catch(EventException ex){
			rollback();
			//throw ex;
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	
	/**
	 * EES_DMT_3009 : O/T History <br>
	 * Retrieving Office Transfer records by Office or Date.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeTransferHistoryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3009Event event = (EesDmt3009Event)e;
		ChargeOfficeTransferMgtBC command = new ChargeOfficeTransferMgtBCImpl();
		
		try{
			List<DmtOfcTrnsHisVO> list = command.searchOfficeTransferHistoryList(event.getOfficeTransferParmVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3101 : OFC Trans <br>
	 * Updating Charge Data to be Office Transfer.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createOfficeTransferCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3101Event event = (EesDmt3101Event)e;
		ChargeOfficeTransferMgtBC command = new ChargeOfficeTransferMgtBCImpl();
		
		try{
			begin();
			String[] result = command.createOfficeTransferCharge(event.getOfficeTransferParmVOS(), account);
			
			if(result[0] != null) {
				String errCode = result[0];
				
				if("DMT01011".equals(errCode)) {
					String errMsg = new ErrorHandler(errCode).getUserMessage();
					eventResponse.setUserMessage(errMsg.replaceAll("CNTR_NO", result[1]));
				} else
					eventResponse.setUserMessage(new ErrorHandler(errCode).getUserMessage());
				
				rollback();
			} else {
				ChargeCalculationBC command2 = new ChargeCalculationBCImpl();
				String rhqChkFlg = result[1];
				String errCode2    = "";
				//[2015.05.28]소스품질 Modify
				if(null != rhqChkFlg && !rhqChkFlg.equals("") && rhqChkFlg.equals("N")) {

					errCode2 = command2.modifyChargeByOfficeTransfer(event.getOfficeTransferParmVOS(), account);
					
					if(errCode2.equals("")){
						commit();
					}else{

						eventResponse.setUserMessage(new ErrorHandler(errCode2).getUserMessage());
						rollback();
					}
				} else {

					command2.createChargeByOfficeTransfer(event.getOfficeTransferParmVOS());
					commit();
				}
				
			}
				
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
	 * EES_DMT_3102 : Partial <br>
	 * Retrieving Charge to be Partial.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPartialPayment(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3102Event event = (EesDmt3102Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		
		try{
			List<ChargeCalculationContainerVO> list = command.searchPartialPayment(event.getChargeArgumentVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3102 : Delete <br>
	 * Making one Charge Partial.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createPartialPayment(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3102Event event = (EesDmt3102Event)e;
		
		try{
			ChargeArgumentVO chargeArgumentVO = event.getChargeArgumentVO();
			
			String key = chargeArgumentVO.getBackendjobKey();
			DmtResultVO resultVO = (DmtResultVO)BackEndJobResult.loadFromFile(key);
			
			if(resultVO.getResultCode() != null) {
				if(resultVO.getResultMsg() != null)
					eventResponse.setUserMessage(resultVO.getResultMsg());
				else
					eventResponse.setUserMessage(new ErrorHandler(resultVO.getResultCode()).getUserMessage());
			}
			
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3105 : Open
	 * Retrieving Office Transfer History Info By Container.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeTransferHistoryListByContainer(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3105Event event = (EesDmt3105Event)e;
		ChargeOfficeTransferMgtBC command = new ChargeOfficeTransferMgtBCImpl();
		
		try{
			List<OfficeTransferHistoryByContainerVO> list = command.searchOfficeTransferHistoryListByContainer(event.getOfficeTransferParmVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3106 : by ETA<br>
	 * Retrieving POD ETA Date.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPODEta(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3106Event event = (EesDmt3106Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		
		try{
			List<ManualChargeCreationVO> list = command.searchPODEta(event.getManualChargeCreationVOs());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3106 : Get VD MVMT<br>
	 * Retrieving VD Movement Date by Container.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVDMovementByPodEta(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3106Event event = (EesDmt3106Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		
		try{
			List<VDMovementVO> list = command.searchVDMovementByPodEta(event.getVdMovementVOs());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3106 : Save<br>
	 * Creating Charge with not Batch created by Batch but Manual.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createManualCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3106Event event = (EesDmt3106Event)e;
		
		try{
			ChargeArgumentVO chargeArgumentVO = event.getChargeArgumentVO();
			
			String key = chargeArgumentVO.getBackendjobKey();
			DmtResultVO resultVO = (DmtResultVO)BackEndJobResult.loadFromFile(key);
			
			if(resultVO.getResultCode() != null) {
				if(resultVO.getResultMsg() != null)
					eventResponse.setUserMessage(resultVO.getResultMsg());
				else
					eventResponse.setUserMessage(new ErrorHandler(resultVO.getResultCode()).getUserMessage());
			}
			
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3107 : Open
	 * Retrieving calculated records of Basic and Exception Tariff and Clock Stop applied by Container Charge.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3107Event event = (EesDmt3107Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		
		try{
			ChargeCalculationDetailVO chgCalcDtlVO = command.searchChargeDetail(event.getChargeArgumentVO());
			
			ChargeDetailVO chgDtlVO = chgCalcDtlVO.getChargeDetailVO();
			eventResponse.setETCData("bzc_trf_curr_cd", chgDtlVO.getBzcTrfCurrCd());
			eventResponse.setETCData("org_chg_amt", 	chgDtlVO.getOrgChgAmt());
			eventResponse.setETCData("cmdt_expt_amt", 	chgDtlVO.getCmdtExptAmt());
			eventResponse.setETCData("sc_rfa_expt_amt", chgDtlVO.getScRfaExptAmt());
			eventResponse.setETCData("aft_expt_dc_amt", chgDtlVO.getAftExptDcAmt());
			eventResponse.setETCData("bil_amt", 		chgDtlVO.getBilAmt());
			
			eventResponse.setRsVoList(chgCalcDtlVO.getClockStopVOs());
			eventResponse.setRsVoList(chgCalcDtlVO.getChargeBasicFreeTimeVOs());
			eventResponse.setRsVoList(chgCalcDtlVO.getCommodityGroupTariffVOs());
			
			if(chgCalcDtlVO.getBeforeExceptionTariffVOs() != null)
				eventResponse.setRsVoList(chgCalcDtlVO.getBeforeExceptionTariffVOs());
			else
				eventResponse.setRsVoList(chgCalcDtlVO.getScExceptionTariffVOs());
			
			eventResponse.setRsVoList(chgCalcDtlVO.getAfterExceptionTariffVOs());
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_4016-1 : Retrieve<br>
	 * Retrieving Container Charge created with SZPBB Office.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeBySZPBB(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt4016Event event = (EesDmt4016Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();

		try{
			List<ChargeCalculationContainerVO> list = command.searchChargeBySZPBB(event.getChargeByOfficeOrVVDVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_4016_1 : Get To MVMT<br>
	 * Retrieving Movement Data related to Charge occurred by SZPBB Office<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMovementBySZPBB(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt4016Event event = (EesDmt4016Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();

		try{
			List<MovementSZPBBVO> list = command.searchMovementBySZPBB(event.getMovementSZPBBParmVOS());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_4016-1 : Calculate<br>
	 * Creating "DMOF", "DMIF" Charge of SZPBB Office.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createChargeBySZPBB(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt4016Event event = (EesDmt4016Event)e;

		try{
			ChargeArgumentVO chargeArgumentVO = event.getChargeArgumentVO();
			
			String key = chargeArgumentVO.getBackendjobKey();
			DmtResultVO resultVO = (DmtResultVO)BackEndJobResult.loadFromFile(key);
			
			if(resultVO.getResultCode() != null) {
				if(resultVO.getResultMsg() != null)
					eventResponse.setUserMessage(resultVO.getResultMsg());
				else
					eventResponse.setUserMessage(new ErrorHandler(resultVO.getResultCode()).getUserMessage());
			} else {
				eventResponse.setRsVoList(resultVO.getChargeCalculationContainerVOs());
			}
		
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2009 : btn_approval<br>
	 * Action Long Tx <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse doBackEndJobApproval(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 			= new GeneralEventResponse();
		ChargeAmountDiscountMgtBC		command					= new ChargeAmountDiscountMgtBCImpl();
		AfterProgressVO 				afterProgressVO 		= null;
		AfterBKGRequestVO[] 			afterBKGRequestVOS 		= null;
		AfterBKGCNTRRequestVO[] 		afterBKGCNTRRequestVOS 	= null;

		if (e instanceof EesDmt2008Event) {
			afterProgressVO 		= ((EesDmt2008Event)e).getAfterProgressVO();
			afterBKGRequestVOS 		= ((EesDmt2008Event)e).getAfterBKGRequestVOS();
			afterBKGCNTRRequestVOS 	= ((EesDmt2008Event)e).getAfterBKGCNTRRequestVOS();
		} 
		else if (e instanceof EesDmt2009Event) {
			afterProgressVO 		= ((EesDmt2009Event)e).getAfterProgressVO();
			afterBKGRequestVOS 		= ((EesDmt2009Event)e).getAfterBKGRequestVOS();
			afterBKGCNTRRequestVOS 	= ((EesDmt2009Event)e).getAfterBKGCNTRRequestVOS();
		}			
		
		//Set Parameters -----------------------------------------------------------------------
		if(afterProgressVO != null) {
			afterProgressVO.setCreUsrId(account.getUsr_id());
			afterProgressVO.setCreOfcCd(account.getOfc_cd());
			afterProgressVO.setUpdUsrId(account.getUsr_id());
			afterProgressVO.setUpdOfcCd(account.getOfc_cd());
			afterProgressVO.setRhqOfcCd(account.getRhq_ofc_cd());
		}
		
		AfterBKGGRPVO afterBKGGRPVO = new AfterBKGGRPVO();
		if(afterProgressVO != null) afterBKGGRPVO.setAfterProgressVO(			afterProgressVO				);
		if(afterBKGRequestVOS != null) afterBKGGRPVO.setAfterBKGRequestVOS(		afterBKGRequestVOS			);
		if(afterBKGCNTRRequestVOS != null) afterBKGGRPVO.setAfterBKGCNTRRequestVOS(	afterBKGCNTRRequestVOS		);	
		//-------------------------------------------------------------------------------------
		
		try {
			eventResponse.setETCData("BackEndJobKey", command.doBackEndJobApproval(afterBKGGRPVO, account));
			
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2009 : btn_approval<br>
	 * Retrieving Long Tx result<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse checkBackEndJobApproval(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		ChargeAmountDiscountMgtBC		command				= new ChargeAmountDiscountMgtBCImpl();
		AfterProgressVO 				afterProgressVO 	= null;
		
		if (e instanceof EesDmt2008Event) {
			afterProgressVO = ((EesDmt2008Event)e).getAfterProgressVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			afterProgressVO = ((EesDmt2009Event)e).getAfterProgressVO();
		}
		
		try {
			//[2015.05.28]소스품질 Modify
			if(null != afterProgressVO){
				String[] result = command.checkBackEndJobApproval(afterProgressVO.getJobKey());
	
				eventResponse.setETCData("jb_sts_flg",		result[0]);
				eventResponse.setETCData("jb_usr_err_msg",	result[1]);
			}else{
				eventResponse.setETCData("jb_sts_flg",		"");
				eventResponse.setETCData("jb_usr_err_msg",	"");
			}
			
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}		
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2009 : btn_approval<br>
	 * Retrieving Long Tx result<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse completeBackEndJobApproval(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		ChargeAmountDiscountMgtBC		command				= new ChargeAmountDiscountMgtBCImpl();		
		AfterProgressVO 				afterProgressVO 	= null;
		
		if (e instanceof EesDmt2008Event) {
			afterProgressVO = ((EesDmt2008Event)e).getAfterProgressVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			afterProgressVO = ((EesDmt2009Event)e).getAfterProgressVO();
		}
		
		try {
			if(afterProgressVO != null) {
				if ("Y".equals(afterProgressVO.getPopupFlag()))
					eventResponse.setETCData("upd_dt", command.searchUpdateDate(afterProgressVO));
			}
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException("DMT02036");
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3104 : Save
	 * 해당 Charge를 Deletion 대상으로 추가함.
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	/*private EventResponse requestChargeDeletion(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3104Event event = (EesDmt3104Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		try{
			begin();
			String result = command.requestChargeDeletion(event.getChargeCalculationContainerVOS(), account);

			if(result != null) {
				if (!result.equals("DMT01081")) {
					eventResponse.setUserMessage(result);
				}else{
				eventResponse.setUserMessage(new ErrorHandler(result).getUserMessage());
				}
				rollback();
			} else
				commit();
		}catch(EventException ex){
			rollback();
			//throw ex;
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	*/
	/**
	 * EES_DMT_3014 : Office List
	 * 대상 DMT Office List를 조회함.
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDMTOfficeByApprovalOffice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		try{
			String ofcCd = account.getOfc_cd();
			String rhq = account.getRhq_ofc_cd();
			List<OfficeNameVO> list = command.searchDMTOfficeByApprovalOffice(ofcCd, rhq);
			
			if (list != null && list.size() > 0) {
				StringBuffer ofc_cds = new StringBuffer();
				StringBuffer ofc_nms = new StringBuffer();
				
				for (int i = 0 ; i < list.size() ; i++) {
					OfficeNameVO vo = (OfficeNameVO)list.get(i);
					ofc_cds.append(vo.getOfcCd()).append("|");
					ofc_nms.append(vo.getOfcEngNm()).append("|");
				}
				
				ofc_cds.deleteCharAt(ofc_cds.length()-1);
				ofc_nms.deleteCharAt(ofc_nms.length()-1);
				
				eventResponse.setETCData("OFC_CD", ofc_cds.toString());
				eventResponse.setETCData("OFC_NM", ofc_nms.toString());
			}      
			} catch(EventException ex) {
				throw ex;
			} catch(Exception ex) {
				throw new EventException(ex.getMessage(), ex);
			}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3014 : Retrieve
	 * 대상 DMT Office List를 조회함.
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeDeletionRequest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3014Event event = (EesDmt3014Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		
		try{
			List<ChargeCalculationContainerVO> list = command.searchChargeDeletionRequest(event.getChargeDeletionRequstVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3014 : Reject
	 * 대상 DMT Office List를 조회함.
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse rejectChargeDeletion(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3014Event event = (EesDmt3014Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		try{
				begin();
				command.rejectChargeDeletion(event.getChargeCalculationContainerVOS(), account);
				eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
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
	 * EES_DMT_3002 : Recalculation <br>
	 * Charge 정보를 Recalculation 하여 수정한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyChargeByBooking(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3002Event event = (EesDmt3002Event)e;
		//ChargeCalculationBC command = new ChargeCalculationBCImpl();
		try{
			
			ChargeArgumentVO chargeArgumentVO = event.getChargeArgumentVO();
			String key = chargeArgumentVO.getBackendjobKey();

			DmtResultVO resultVO = (DmtResultVO)BackEndJobResult.loadFromFile(key);
	
			if(resultVO.getResultCode() == null) {

				//EDI 로 전송할 데이터 객체를 생성합니다.
				String			ydCd	= null;
				EDIVO 			eDIVO 	= null;
				List<EDIVO> 	eDIVOs	= null;
			
	
				ChargeCalculationContainerVO[] chargeCalculationContainerVOs = resultVO.getChargeCalculationContainerVOArray();
				List<ChargeCalculationContainerVO> chgCalcContainerVOS = new ArrayList<ChargeCalculationContainerVO>();
			
				for(int i=0; i < chargeCalculationContainerVOs.length; i++) {
					chgCalcContainerVOS.add(chargeCalculationContainerVOs[i]);
				}
				
				if (chgCalcContainerVOS != null && chgCalcContainerVOS.size() > 0) {
					eDIVOs = new ArrayList<EDIVO>(); 
					for (int i = 0 ; i < chgCalcContainerVOS.size() ; i++) {
						ydCd = chgCalcContainerVOS.get(i).getFmMvmtYdCd();
						
						if (ydCd == null || ydCd.length() != 7) continue;
						
						String locCd = ydCd.substring(0, 5);
						if ("KOR".equals(chgCalcContainerVOS.get(i).getSvrId()) 
								&& ("KRPUS".equals(locCd) ||
									"KRKAN".equals(locCd) ||
									"KRINC".equals(locCd) ||
									"KRPYT".equals(locCd) ||
									"KRUSN".equals(locCd) ||
									"KRPTK".equals(locCd)) ) {
							eDIVO = new EDIVO();
							eDIVO.setBkgNo(			chgCalcContainerVOS.get(i).getBkgNo()		);
							eDIVO.setSysAreaGrpId(	chgCalcContainerVOS.get(i).getSvrId()		);
							eDIVO.setCntrNo(		chgCalcContainerVOS.get(i).getCntrNo()		);
							eDIVO.setCntrCycNo(		chgCalcContainerVOS.get(i).getCntrCycNo()	);
							eDIVO.setAcount(		account										);
							eDIVOs.add(eDIVO);
						}
					}
				 }
				
				//if (eDIVOs != null && eDIVOs.size() > 0) {
					//공통모듈을 통해서 EDI 전송을 수행한다.
					//20150430 Park Young Jin 주석 처리  강환수석님 요청
					//command.sendToEDI(eDIVOs);
				//}

			} else {
				
				if(resultVO.getResultMsg() != null)
					eventResponse.setUserMessage(resultVO.getResultMsg());
				else
					eventResponse.setUserMessage(new ErrorHandler(resultVO.getResultCode()).getUserMessage());
			}
				
		/*}catch(EventException ex){
			//rollback();
			throw ex;*/
		}catch(Exception ex){
			//rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * EES_DMT_3002 : createDailyBatchByBooking <br>
	 * 
	 * @param 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createDailyBatchByBooking(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3002Event event = (EesDmt3002Event)e ;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		try {
	    	String status = command.createDailyBatchByBooking(event.getChargeArgumentVO(), account);
			eventResponse.setETCData("BatchStatus", status);
	    } catch (EventException de) {
	        log.error("err " + de.toString(), de);
	        throw new EventException(de.getMessage());
	    }
	    return eventResponse;
	}	
	
	/**
	 * EES_DMT_3002: 일배치 대상 건수 체크<br>
	 * Return multiChargeBackEndJob BackEndJob process result.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDailyMovementCalculationByBooking(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		
		try{
			ChargeArgumentVO chargeArgumentVO = ((EesDmt3002Event)e).getChargeArgumentVO();

			String date = command.searchDate();
			String value = command.checkDailyMovementCalculationByBooking(chargeArgumentVO, account, date);
			eventResponse.setETCData("CHECK_BATCH", value);
			eventResponse.setETCData("BAT_RUN_TM_ID", date);

		
		} catch(Exception ex) {
			log.error("ERROR=>"+ex.getMessage());
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * EES_DMT_3002: 일배치 대상 건수 체크<br>
	 * Return multiChargeBackEndJob BackEndJob process result.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCalculationByBooking(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		
		try{
			ChargeArgumentVO chargeArgumentVO = ((EesDmt3002Event)e).getChargeArgumentVO();
			
			String value = command.checkCalculationByBooking(chargeArgumentVO);

			String[] valueInfo         = value.split("\\|");
			
			eventResponse.setETCData("BAT_RSLT_FLG", valueInfo[0].toString());
			eventResponse.setETCData("BAT_RSLT_RMK", valueInfo[1].toString());
		
		} catch(Exception ex) {
			log.error("ERROR=>"+ex.getMessage());
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
}