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
* 2010.09.16 김태균 [] [EES-DMT] AFTER BOOKING BACKENDJOB 메시지 수정
* 2010.10.20 김태균 [CHM-201006558-01] [EES-DMT] confirm, delete, delete cancel, office transfer 멀티 팝업창에서 처리 안되게 처리
* 2010.12.07 김태균 [] [EES-DMT] 표준위배 수정
* 2011.08.04 김경섭[] [EES-DMT] 표준위배 수정 
* 2011.11.09 김현화 [CHM-201113641-01]E-DO Free Time관련 기능 추가(KT-NET)
* 2012.01.17 김현화[]EDO 전송시 CHG_SEQ가 1이 아닌 데이터가 제외되도록 로직 보완함.
* 2012.01.30 김현화[]EDO 전송대상 선정 로직 추가.- DMIF(DUL_TP_EXPT_FLG = 'N'), CTIC(DUL_TP_EXPT_FLG = 'Y') 만  전송되도록 함.
* 2012.05.11 김현화 [CHM-201217570-01] After-BKG-DAR 신청 사유 선택 기능 추가 - searchAfterBookingList에  DMDT_EXPT_RQST_RSN_CD 추가.
* 2012.05.11 김현화 [CHM-201217746-01] 경인항 터미널과의 DMT EDI를 위한 batch set-up 요청(KRGIN 추가)
* 2012.09.11 김현화[CHM-201219003-01]OP-MT Detention Calculation 화면/기능 개발.  
* 2015.02.10 이성훈 CHM-201533805 [DMT] Deletion Cancel 기능 개선
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.basic.ChargeAmountDiscountMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.basic.ChargeAmountDiscountMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.event.EesDmt2008Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.event.EesDmt2009Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.event.EesDmt2017Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.event.EesDmt2018Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.event.EesDmt2021Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ActualCostListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGCNTRRequestVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGDetailInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGGRPVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGRequestVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBkgRqstAproStsVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingAproItmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingDetailFlgVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingDetailReasonListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingExptClrRqstVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingFileListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingFullHistoryVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingMasListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingPfmcListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingReasonDescVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingReasonDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingRequestDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterProgressVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.BackEndJobResultVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.CommentHistoryVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3001Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3002Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3003Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3004Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3005Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3006Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3014Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3015Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3016Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3017Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3102Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3103Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3104Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3106Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3107Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt4016Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration.ChargeCalculationDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeByOfficeOrVVDVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeDeletionRequstVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeDeltSpecRsnRmkVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeInactivHisListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgCorrHisVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtResultVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.EDIVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.InactiveInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.InactiveListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.InactiveReasonVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ManualChargeCreationVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.MovementSZPBBVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SearchDeleteMultiDetailReasonListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SearchDeleteMultiReasonListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SearchInactiveCheckVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.VDMovementVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.basic.ChargeOfficeTransferMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.basic.ChargeOfficeTransferMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.event.EesDmt3009Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.event.EesDmt3101Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.event.EesDmt3105Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.DmtOfcTrnsHisVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.OfficeTransferHistoryByContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.basic.FaxEmailBC;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.basic.FaxEmailBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.vo.GRWEmailChgDeltNoticeVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.vo.GRWEmailNoticeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBC;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CommonCodeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CoverageVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CurrencyVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.OfficeNameVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.UserRoleVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.basic.RFAExceptionTariffMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.basic.RFAExceptionTariffMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.basic.SCExceptionTariffMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.basic.SCExceptionTariffMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.CalculationTypeParmVO;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * NIS2010-DMTClosing Business Logic ServiceCommand - NIS2010-DMTClosing 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author 
 * @see ChargeCalculationDBDAO
 * @since J2EE 1.6
 */

public class DMTClosingSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * DMTClosing system 업무 시나리오 선행작업<br>
	 * EES_DMT_3001업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * DMTClosing system 업무 시나리오 마감작업<br>
	 * EES_DMT_3001 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("DMTClosingSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-DMTClosing system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
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
//			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
//				eventResponse = approveOfcAfterBookingDAR(e);
//			}	
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
			} 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	// By POD ETA
				eventResponse = searchChargeListByPodEta(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		// Confirm
				eventResponse = confirmContainerCharge(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {	// DEL REQ Cancel(DEL Cancel 기능 개선으로 추가됨. 2015.02.14)
				eventResponse = cancelChargeDeletionRequest(e);
			} 			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	// GrpInv_ExRate
				eventResponse = searchGrpInvExRate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt3002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChargeByBookingList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	// By POD ETA
				eventResponse = searchChargeListByPodEta(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		// Confirm
				eventResponse = confirmContainerCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		// Delete Cancel
//         		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//				CHM-201533805 [DMT] Deletion Cancel 기능 개선 -  2015.02.10
//				AS-IS : 삭제된 Charge 의 상태를 원상태로 복구시킨다. 
//				TO-BE : Charge Deletion 요청건에 대해서 승인처리가 발생되지 않았을 경우, Charge Deletion 요청에 대해서 취소시킨다. 
//         		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////  				
//				eventResponse = removeCancelCharge(e);
				eventResponse = cancelChargeDeletionRequest(e);
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
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt3003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChargeByContainer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		// Confirm
				eventResponse = confirmContainerCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		// Delete Cancel
//         		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//				CHM-201533805 [DMT] Deletion Cancel 기능 개선 -  2015.02.10
//				AS-IS : 삭제된 Charge 의 상태를 원상태로 복구시킨다. 
//				TO-BE : Charge Deletion 요청건에 대해서 승인처리가 발생되지 않았을 경우, Charge Deletion 요청에 대해서 취소시킨다. 
//         		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
				//eventResponse = removeCancelCharge(e);
				eventResponse = cancelChargeDeletionRequest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {		// PreCalculation
				eventResponse = precalDRDateCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {		// D/R Cancel
				eventResponse = cancelDRBalanceCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {		// Save
				eventResponse = modifyChargeByContainer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {	// Web Cancel
				eventResponse = modifyChargeByContainer(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt3004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChargeStatusListByOfficeOrVVD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		// Delete Cancel
//         		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//				CHM-201533805 [DMT] Deletion Cancel 기능 개선 -  2015.02.10
//				AS-IS : 삭제된 Charge 의 상태를 원상태로 복구시킨다. 
//				TO-BE : Charge Deletion 요청건에 대해서 승인처리가 발생되지 않았을 경우, Charge Deletion 요청에 대해서 취소시킨다. 
//         		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////  			
//				eventResponse = removeCancelCharge(e);
				eventResponse = cancelChargeDeletionRequest(e);
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
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = searchDeleteReasonList(e);
//			} 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDeleteMultiReasonList(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDeleteMultiDetailReasonList(e);
			} 
			// Charge Deletion Specific Reason 입력정보를 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchDeletionSpecificReasonRemarkList(e);
			} 			
			// Charge Deletion Specific Reason 입력정보를 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchInactiveHistoryList(e);
			} 				
			// Charge Deletion Specific Reason 입력정보를 조회한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCharge(e);
			} 		
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				//eventResponse = removeCharge(e);
				eventResponse = requestChargeDeletion(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = cancelChargeDeletionRequest(e);
			}	    	
	     	else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
	     		eventResponse = modifyChargeDeletionProcessStatus(e);	//승인 or 거절
			} 
	     	else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchBookingInfo(e);
			} 
	     	else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
	     		eventResponse = searchContractCustomer(e);
	     	} 
	     	else if (e.getFormCommand().isCommand(FormCommand.SEARCH21)) {
	     		eventResponse = searchInvoiceStatus(e);
	     	}
	     	// OC Movement Date Search를 위해 추가 by Wonki Eo
	     	else if (e.getFormCommand().isCommand(FormCommand.SEARCH22)) {
	     		eventResponse = searchOcCnmvDt(e);
	     	}
			// File Upload 추가 by Wonki Eo
	     	else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = inactiveFileUpload(e);
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
	     	} 
	    	else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
		        eventResponse = searchChargeDeletionRequest(e);
		    } 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchChargeDeletionProcessStatus(e);
			} 	     	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchChargeDeletionPath(e);
			} 	    	
	     	else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				//eventResponse = removeCharge(e);			--> modifyChargeDeletionProcessStatus 모듈로 통합됨.
	     		eventResponse = modifyChargeDeletionProcessStatus(e);	//승인 or 거절
			} 
//	     	else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
//				eventResponse = rejectChargeDeletion(e);	--> modifyChargeDeletionProcessStatus 모듈로 통합됨
//			}
		} 
		else if (e.getEventName().equalsIgnoreCase("EesDmt3015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOPMTChargeListbyInquiry(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		// Delete Cancel
//         		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//				CHM-201533805 [DMT] Deletion Cancel 기능 개선 -  2015.02.10
//				AS-IS : 삭제된 Charge 의 상태를 원상태로 복구시킨다. 
//				TO-BE : Charge Deletion 요청건에 대해서 승인처리가 발생되지 않았을 경우, Charge Deletion 요청에 대해서 취소시킨다. 
//         		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////				
//				eventResponse = removeCancelCharge(e);
				eventResponse = cancelChargeDeletionRequest(e);				
			}
		} 
		else if (e.getEventName().equalsIgnoreCase("EesDmt3016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOPMTChargeListbyCalculation(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		// Delete Cancel
//         		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//				CHM-201533805 [DMT] Deletion Cancel 기능 개선 -  2015.02.10
//				AS-IS : 삭제된 Charge 의 상태를 원상태로 복구시킨다. 
//				TO-BE : Charge Deletion 요청건에 대해서 승인처리가 발생되지 않았을 경우, Charge Deletion 요청에 대해서 취소시킨다. 
//         		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////  				
//				eventResponse = removeCancelCharge(e);
				eventResponse = cancelChargeDeletionRequest(e);				
			}
		} 
		else if (e.getEventName().equalsIgnoreCase("EesDmt3017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInactiveList(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchInactiveReason(e);
			} 
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt2017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchActualCostList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchAfterBookingFullHistory(e);
			}  else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchAfterBookingReasonDesc(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchAfterBookingDetailReasonList(e);
			}  else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAfterBookingPfmcList(e);
			}  else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchAfterBookingAproItm(e);				
			}  else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchAfterBookingRsnVal(e);				
			}  else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchAfterBookingReasonUcTtl(e);
			}  else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchAfterBookingMasList(e);
			}  else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchAfterBookingVvdCd(e);
			}   else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createAfterBookingRequestDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = fileUpload(e);
			} 		
		} else if (e.getEventName().equalsIgnoreCase("EesDmt2018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAfterBookingListTSave(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContainerChargeByBookingTSave(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBookingDataTSave(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCommentHistoryTSave(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkCalcuationTypeTSave(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkDupTariffBKGBLNoTSave(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = checkBalanceChargeTSave(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchAfterNewDAR(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = cancelAfterBookingDARTSave(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = counterofferAfterBookingDAR(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = rejectAfterBookingDAR(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {	// Confirm
				eventResponse = requestAfterBookingTSave(e);
			}					
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {	// Confirm
				eventResponse = requestAfterBookingTSave(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = doBackEndJobApprovalTSave(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = modifyAfterBookingStatusUpdate(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = searchOfcChkFlg(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDmt2021Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAfterBookingrRequestApprovalStatusList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAfterBookingrAllStatusCodeList(e);
			}
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2008 :  <br>
	 * DEM/DET Adjustment Request - After Booking Request 의 목록을 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAfterBookingList(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		ChargeAmountDiscountMgtBC 	chgCommand 			= new ChargeAmountDiscountMgtBCImpl();
		CommonFinderBC 				cmnCommand 			= new CommonFinderBCImpl();
		
		AfterBKGListInputVO 		inputVO 			= new AfterBKGListInputVO();

		if (e instanceof EesDmt2008Event) {
			inputVO = ((EesDmt2008Event)e).getAfterBKGListInputVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			inputVO = ((EesDmt2009Event)e).getAfterBKGListInputVO();
		}
		
		try {
			List<AfterBKGListInputVO> afterBKGListInputVO = chgCommand.searchAfterBookingDAR(inputVO);
			List<AfterBKGListVO>      afterBKGListVO 	  = chgCommand.searchAfterBookingList(inputVO);
			
			// Currency 정보를 보여주기 위한 처리부분(시작) ########################################################################
			if (afterBKGListVO != null && afterBKGListVO.size() > 0) {
				CoverageVO	coverageVO = new CoverageVO();
				
				for (int i = 0 ; i < afterBKGListVO.size() ; i++) {
					
					//Currency 정보를 구하기 위한 Country 정보를 구한다.
					String tariff = afterBKGListVO.get(i).getDmdtTrfCd();
					String cntCd  = "";
					
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
							Map<String, String> mapCurrencyCodes = new HashMap<String, String>();
							Map<String, String> mapCurrencyNames = new HashMap<String, String>();

							cntCd = cntCd.substring(0, 2);
							
							if (!mapCurrencyCodes.containsKey(cntCd)) {

								//국가별 Currency 를 구한다. ============================================================
								coverageVO.setCntCd(cntCd);
								
								List<CurrencyVO> currencyVOS = cmnCommand.searchCurrencyList(coverageVO);
								if (currencyVOS != null && currencyVOS.size() > 0) {
									
									StringBuffer sbCurrencyCodes = new StringBuffer();
									StringBuffer sbCurrencyNames = new StringBuffer();
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
									
									sbCurrencyCodes.setLength(0);
									sbCurrencyNames.setLength(0);
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
				eventResponse.setRsVoList(afterBKGListVO);
			}
			//Currency 정보를 보여주기 위한 처리부분(끝) ########################################################################
				
			if (afterBKGListInputVO != null && afterBKGListInputVO.size() > 0) {
				eventResponse.setETCData("APVL_OFC_CD", afterBKGListInputVO.get(0).getApvlOfcCd());
				eventResponse.setETCData("DAR_NO", afterBKGListInputVO.get(0).getDarNo());
				eventResponse.setETCData("APVL_NO", afterBKGListInputVO.get(0).getApvlNo());
				eventResponse.setETCData("STS_DESC", afterBKGListInputVO.get(0).getStsDesc());
				eventResponse.setETCData("SC_NO", afterBKGListInputVO.get(0).getScNo());
				eventResponse.setETCData("RFA_NO", afterBKGListInputVO.get(0).getRfaNo());
				eventResponse.setETCData("CUST_CD", afterBKGListInputVO.get(0).getCustCd());
				eventResponse.setETCData("CUST_NM", afterBKGListInputVO.get(0).getCustNm());
				eventResponse.setETCData("DMDT_EXPT_RQST_RSN_CD", afterBKGListInputVO.get(0).getDmdtExptRqstRsnCd());
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
				eventResponse.setETCData("DMDT_EXPT_RQST_RSN_CD", "");	
			}
			
//			if(afterApprovalSetup != null && afterApprovalSetup.size() > 0){
//				eventResponse.setETCData("DMDT_BRNC_FLG", 		afterApprovalSetup.get(0).getDmdtBrncFlg());
//				eventResponse.setETCData("DMDT_RHQ_PIC_FLG", 	afterApprovalSetup.get(0).getDmdtRhqPicFlg());
//				eventResponse.setETCData("DMDT_RHQ_FLG", 		afterApprovalSetup.get(0).getDmdtRhqFlg());
//				eventResponse.setETCData("DMDT_HO_FLG", 		afterApprovalSetup.get(0).getDmdtHoFlg());
//			}
//			else {
//				eventResponse.setETCData("DMDT_BRNC_FLG", 		"");
//				eventResponse.setETCData("DMDT_RHQ_PIC_FLG", 	"");
//				eventResponse.setETCData("DMDT_RHQ_FLG", 		"");
//				eventResponse.setETCData("DMDT_HO_FLG", 		"");
//			}
			
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2008 :  <br>
	 * DEM/DET Adjustment Request - After Booking Request 의 Container 별 지불요금 정보를 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerChargeByBooking(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		ChargeAmountDiscountMgtBC 		chgCommand 			= new ChargeAmountDiscountMgtBCImpl();
		CommonFinderBC 					cmnCommand 			= new CommonFinderBCImpl();

		CoverageVO						coverageVO			= new CoverageVO();
		List<CurrencyVO> 				currencyVOS 		= new ArrayList<CurrencyVO>();
		
		ChargeBookingContainerParmVO 	paramVO 			= new ChargeBookingContainerParmVO();
		List<ChargeBookingContainerVO> 	containerListVO		= new ArrayList<ChargeBookingContainerVO>();
		
		StringBuffer 					sbCurrencyCodes 	= new StringBuffer();
		StringBuffer 					sbCurrencyNames 	= new StringBuffer();
		Map<String, String> 			mapCurrencyCodes	= new HashMap<String, String>();
		Map<String, String> 			mapCurrencyNames	= new HashMap<String, String>();
		
		if (e instanceof EesDmt2008Event) {
			paramVO = ((EesDmt2008Event)e).getChargeBookingContainerParmVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			paramVO = ((EesDmt2009Event)e).getChargeBookingContainerParmVO();
		}		

		try {
			//Billable Amout per CNTR 조회
			containerListVO = chgCommand.searchContainerChargeByBooking(paramVO);
			
			//Currency 정보를 보여주기 위한 처리부분(시작) ########################################################################
			if (containerListVO != null && containerListVO.size() > 0) {
				for (int i = 0 ; i < containerListVO.size() ; i++) {
					
					//Currency 정보를 구하기 위한 Country 정보를 구한다.
					String tariff = containerListVO.get(i).getDmdtTrfCd();
					String cntCd  = "";
					
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

								//국가별 Currency 를 구한다. ============================================================
								coverageVO.setCntCd(cntCd);
								
								currencyVOS = cmnCommand.searchCurrencyList(coverageVO);
								if (currencyVOS != null && currencyVOS.size() > 0) {
									
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
									
									sbCurrencyCodes.setLength(0);
									sbCurrencyNames.setLength(0);
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
				eventResponse.setRsVoList(containerListVO);
			}
			//Currency 정보를 보여주기 위한 처리부분(끝) ########################################################################
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2008 :  <br>
	 * DEM/DET Adjustment Request - After Booking Request 의 Comment History 리스트 조회 이벤트 처리.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBookingData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		AfterBKGDetailInputVO inputVO = new AfterBKGDetailInputVO();
		if (e instanceof EesDmt2008Event) {
			inputVO = ((EesDmt2008Event)e).getAfterBKGDetailInputVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			inputVO = ((EesDmt2009Event)e).getAfterBKGDetailInputVO();
		}

		try {
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
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2008 :  <br>
	 * DEM/DET Adjustment Request - After Booking Request 의 Comment History 리스트 조회 이벤트 처리.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommentHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		AfterBKGListInputVO inputVO = new AfterBKGListInputVO();
		if (e instanceof EesDmt2008Event) {
			inputVO = ((EesDmt2008Event)e).getAfterBKGListInputVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			inputVO = ((EesDmt2009Event)e).getAfterBKGListInputVO();
		}		

		try {
			List<CommentHistoryVO> commentHistoryVOList = command.searchCommentHistory(inputVO);
			eventResponse.setRsVoList(commentHistoryVOList);
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2008 :  <br>
	 * DEM/DET Adjustment Request - After Booking Request 의 BKG/B/L No 의 Tariff Type 이 맞는지 체크 이벤트 처리.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCalcuationType(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		AfterBKGListInputVO inputVO = new AfterBKGListInputVO();
		
		if (e instanceof EesDmt2008Event) {
			inputVO = ((EesDmt2008Event)e).getAfterBKGListInputVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			inputVO = ((EesDmt2009Event)e).getAfterBKGListInputVO();
		}
		
		try {
			if (inputVO != null) {

				boolean result = command.checkCalcuationType(inputVO);
				
				//S/C Exception 의 Calculation Type Check 로직을 수행한다.
				if (!result) {
					
					String cntCd 	= "";
					String rgnCd 	= "";
					String steCd 	= "";
					String ioBndCd  = "";
					String calcTpCd = "";
					
					if (inputVO.getTariff() != null && inputVO.getTariff().length() == 4) {
						ioBndCd  = inputVO.getTariff().substring(2, 3);
						calcTpCd = inputVO.getTariff().substring(0, 1);
					}					
					
					String locCd = command.searchLocationByBKGBLNo(inputVO);
					eventResponse.setETCData("LOC", locCd);
					
					//Location Code 로 Country, Regin, State 정보를 조회한다. =============================================
					CommonFinderBC cmmonCommand = new CommonFinderBCImpl();
					CoverageVO coverageVO = new CoverageVO();
					coverageVO.setLocCd(locCd);
					List<CoverageVO> coverageList = cmmonCommand.searchContinentHierarchyByLocation(coverageVO);
					
					if (coverageList != null && coverageList.size() > 0) {
						cntCd = coverageList.get(0).getCntCd();
						
						if (locCd != null && locCd.length() == 5) {
							if ("CA".equals(locCd.substring(0, 2)) || "US".equals(locCd.substring(0, 2))) {
								steCd = coverageList.get(0).getSteCd();	
							}
							else {
								rgnCd = coverageList.get(0).getRgnCd();	
							}
						}
					}
	
					//Calculation Type Check 로직을 수행한다. ===========================================================
					SCExceptionTariffMgtBC scCommand = new SCExceptionTariffMgtBCImpl();
					CalculationTypeParmVO calcParmVO = new CalculationTypeParmVO();
					calcParmVO.setIoBndCd(ioBndCd);
					calcParmVO.setDmdtCalcTpCd(calcTpCd);
					calcParmVO.setCntCd(cntCd);
					calcParmVO.setRgnCd(rgnCd);
					calcParmVO.setSteCd(steCd);
					calcParmVO.setLocCd(locCd);
					result = scCommand.checkCalcType(calcParmVO);
				
					if (!result) {
						//Calculation Type을 조회한다. ======================================================================
						eventResponse.setETCData("CHECK_CALC", "N");
						eventResponse.setETCData("CALC_TYPE",  command.searchCalcTypeCode(locCd, ioBndCd));
					}
					else {
						eventResponse.setETCData("CHECK_CALC", "Y");
						eventResponse.setETCData("CALC_TYPE",  "");
						eventResponse.setETCData("LOC",        "");
					}			
				}
				else {
					eventResponse.setETCData("CHECK_CALC", "Y");
					eventResponse.setETCData("CALC_TYPE",  "");
					eventResponse.setETCData("LOC",        "");
				}
			}
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2008 :  <br>
	 * DEM/DET Adjustment Request - After Booking Request 의 Tariff Type 과 BKG 또는 B/L No. 가 중복되는지 체크 이벤트 처리.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDupTariffBKGBLNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		AfterBKGListInputVO inputVO = new AfterBKGListInputVO();
		if (e instanceof EesDmt2008Event) {
			inputVO = ((EesDmt2008Event)e).getAfterBKGListInputVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			inputVO = ((EesDmt2009Event)e).getAfterBKGListInputVO();
		}

		try {
			String darNo = command.checkDupTariffBKGBLNo(inputVO);
			eventResponse.setETCData("DAR_NO", darNo != null ? darNo : "");
		}
		catch(EventException ex) {
			throw ex;
		} 
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2008 :  <br>
	 * DEM/DET Adjustment Request - After Booking Request 의 Balance Charge 가 있는 CNTR 인지 체크 이벤트 처리.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkBalanceCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		AfterBKGListInputVO inputVO = new AfterBKGListInputVO();
		if (e instanceof EesDmt2008Event) {
			inputVO = ((EesDmt2008Event)e).getAfterBKGListInputVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			inputVO = ((EesDmt2009Event)e).getAfterBKGListInputVO();
		}

		try {
			boolean result = command.checkBalanceCharge(inputVO);
			eventResponse.setETCData("CHECK_BALCHG", result ? "Y" : "N");
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * DAR No. 채번 및 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAfterNewDAR(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 		= new RFAExceptionTariffMgtBCImpl();
		
		eventResponse.setETCData("DAR", command.searchNewDAR("A", account.getUsr_id(), account.getOfc_cd()));
		return eventResponse;
	}
	
	/**
	 * 등록된 After Booking DAR 를 Cancel 한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelAfterBookingDAR(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		AfterProgressVO afterProgressVO = new AfterProgressVO();
		if (e instanceof EesDmt2008Event) {
			afterProgressVO = ((EesDmt2008Event)e).getAfterProgressVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			afterProgressVO = ((EesDmt2009Event)e).getAfterProgressVO();
		}		
		
		try {
			if (afterProgressVO != null) {
				//Set Parameters 
				afterProgressVO.setCreUsrId(account.getUsr_id());
				afterProgressVO.setCreOfcCd(account.getOfc_cd());
				afterProgressVO.setUpdUsrId(account.getUsr_id());
				afterProgressVO.setUpdOfcCd(account.getOfc_cd());

				begin();
				command.cancelAfterBookingDAR(afterProgressVO);
				commit();
				
				if ("Y".equals(afterProgressVO.getPopupFlag())) {
					//2006 번 화면에서 팝업으로 띄울 경우 Counter Offer 한 DATE 정보를 보여주기 위해서 조회함. 
					eventResponse.setETCData("upd_dt", command.searchUpdateDate(afterProgressVO));
				}
			}
		}
		catch(EventException ex) {
			rollback();
			throw ex;
		}
		catch(Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;
	}
	
	/**
	 * 등록된 After Booking DAR 를 Counter Offer 한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse counterofferAfterBookingDAR(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		AfterProgressVO afterProgressVO = new AfterProgressVO();
		if (e instanceof EesDmt2008Event) {
			afterProgressVO = ((EesDmt2008Event)e).getAfterProgressVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			afterProgressVO = ((EesDmt2009Event)e).getAfterProgressVO();
		}
		else if (e instanceof EesDmt2018Event) {
			afterProgressVO = ((EesDmt2018Event)e).getAfterProgressVO();
		}	

		try {
			if (afterProgressVO != null) {
				//Set Parameters 
				afterProgressVO.setCreUsrId(account.getUsr_id());
				afterProgressVO.setCreOfcCd(account.getOfc_cd());
				afterProgressVO.setUpdUsrId(account.getUsr_id());
				afterProgressVO.setUpdOfcCd(account.getOfc_cd());
						
				begin();
				command.counterofferAfterBookingDAR(afterProgressVO);
				commit();
				
				//2006 번 화면에서 팝업으로 띄울 경우 Counter Offer 한 DATE 정보를 보여주기 위해서 조회함.
				if ("Y".equals(afterProgressVO.getPopupFlag())) {
					eventResponse.setETCData("upd_dt", command.searchUpdateDate(afterProgressVO));
				}
	
				//COUNTER OFFER 처리 후 메일송부 ###############################################################
				afterProgressVO.setAftBkgAproNo("");
				sendEmail(afterProgressVO);
				//############################################################################################
			}
		}
		catch(EventException ex){
			rollback();
			throw ex;
		}			
		return eventResponse;
	}
	
	/**
	 * 등록된 After Booking DAR 를 Reject 한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse rejectAfterBookingDAR(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		AfterProgressVO afterProgressVO = new AfterProgressVO();
		if (e instanceof EesDmt2008Event) {
			afterProgressVO = ((EesDmt2008Event)e).getAfterProgressVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			afterProgressVO = ((EesDmt2009Event)e).getAfterProgressVO();
		}	
		else if (e instanceof EesDmt2018Event) {
			afterProgressVO = ((EesDmt2018Event)e).getAfterProgressVO();
		}		

		try {
			if (afterProgressVO != null) {
				//Set Parameters 
				afterProgressVO.setCreUsrId(account.getUsr_id());
				afterProgressVO.setCreOfcCd(account.getOfc_cd());
				afterProgressVO.setUpdUsrId(account.getUsr_id());
				afterProgressVO.setUpdOfcCd(account.getOfc_cd());
				
				begin();
				command.rejectAfterBookingDAR(afterProgressVO);
				commit();
				
				//2006 번 화면에서 팝업으로 띄울 경우 Counter Offer 한 DATE 정보를 보여주기 위해서 조회함. 
				if ("Y".equals(afterProgressVO.getPopupFlag())) {
					eventResponse.setETCData("upd_dt", command.searchUpdateDate(afterProgressVO));
				}
				
				//REJECT 처리 후 메일송부 ######################################################################
				afterProgressVO.setAftBkgAproNo("");
				sendEmail(afterProgressVO);
				//############################################################################################
			}
		}
		catch(EventException ex){
			rollback();
			throw ex;
		}
		catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2008 :  <br>
	 * DEM/DET Adjustment Request - After Booking Request 의 Balance Charge 가 있는 CNTR 인지 체크 이벤트 처리.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse requestAfterBookingDAR(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		AfterProgressVO 			afterProgressVO 		= new AfterProgressVO();
		AfterBKGRequestVO[] 		afterBKGRequestVOS 		= new AfterBKGRequestVO[1];
		AfterBKGCNTRRequestVO[] 	afterBKGCNTRRequestVOS 	= new AfterBKGCNTRRequestVO[1];

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
			
		AfterBKGGRPVO afterBKGGRPVO = new AfterBKGGRPVO();
		afterBKGGRPVO.setAfterProgressVO(afterProgressVO);
		afterBKGGRPVO.setAfterBKGRequestVOS(afterBKGRequestVOS);
		afterBKGGRPVO.setAfterBKGCNTRRequestVOS(afterBKGCNTRRequestVOS);
		
		try {
			if (afterProgressVO != null) {
				begin();
				command.requestAfterBookingSave(afterBKGGRPVO, account);
				commit();
				
				//2006 번 화면에서 팝업으로 띄울 경우 Counter Offer 한 DATE 정보를 보여주기 위해서 조회함. 
				if ("Y".equals(afterProgressVO.getPopupFlag())) {
					eventResponse.setETCData("upd_dt", command.searchUpdateDate(afterProgressVO));
				}
			}
		}
		catch(EventException ex) {
			rollback();
			throw ex;
		}
		catch(Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3001 : Charge by Office & VVD <br>
	 * Office별 또는 VVD별 Charge List를 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeListByOfficeOrVVD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt3001Event event = (EesDmt3001Event)e;

		try {
			List<ChargeCalculationContainerVO> list = command.searchChargeListByOfficeOrVVD(event.getChargeByOfficeOrVVDVO());
			eventResponse.setRsVoList(list);
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3001, EES_DMT_3002 :  <br>
	 * Yard별 Container List를 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeListByPodEta(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();

		try {
			ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO = new ChargeByOfficeOrVVDVO();
			if (e instanceof EesDmt3001Event) {
				chargeByOfficeOrVVDVO = ((EesDmt3001Event)e).getChargeByOfficeOrVVDVO();
			} 
			else if (e instanceof EesDmt3002Event) {
				chargeByOfficeOrVVDVO = ((EesDmt3002Event)e).getChargeByOfficeOrVVDVO();
			}
			
			DmtResultVO dmtResultVO = command.searchChargeListByPodEta(chargeByOfficeOrVVDVO);
			if (dmtResultVO != null) {
			
				// DMT01075: Vessel's schedule is not found
				// DMT01129: Location code is not in your area
				if ("DMT01075".equals(dmtResultVO.getResultCode()) || "DMT01129".equals(dmtResultVO.getResultCode())) {
					eventResponse.setUserMessage(new ErrorHandler(dmtResultVO.getResultCode()).getUserMessage());
					
				} 
				else {
					eventResponse.setETCData(dmtResultVO.getEtcData());
					eventResponse.setRsVoList(dmtResultVO.getChargeCalculationContainerVOs());
					
					// ****** Calc Type: 'D'ual / 'C'ombined(오류처리) *****
					if ("DMT01053".equals(dmtResultVO.getResultCode())) {
						// Calc Type이 'C'인 경우
						eventResponse.setUserMessage(dmtResultVO.getResultMsg());
						
					} 
					else {
						List<ChargeCalculationContainerVO> list = dmtResultVO.getChargeCalculationContainerVOs();
						if (list != null && list.size() > 0) {
							HashMap<String, String> cntrInfo = new HashMap<String, String>();
							
							for (int i=0; i < list.size(); i++) {
								ChargeCalculationContainerVO vo = list.get(i);
								
								if (!cntrInfo.containsKey(vo.getCntrNo())) {
									cntrInfo.put(vo.getCntrNo(), "");
								}
							}
							eventResponse.setETCData("cntr_qty", String.valueOf(cntrInfo.size()));
						}
					}
				}
			}
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3001, EES_DMT_3002, EES_DMT_3003 :  <br>
	 * Charge 발생된 금액에 대해서 확정(Confirm)한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmContainerCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		String msg = "";
		
		try {
			begin();
			
			if(e instanceof EesDmt3001Event) {
				msg = command.confirmContainerCharge(((EesDmt3001Event)e).getChargeCalculationContainerVOS(),account);
			} 
			else if(e instanceof EesDmt3002Event) {
				msg = command.confirmContainerCharge(((EesDmt3002Event)e).getChargeCalculationContainerVOS(),account);
			} 
			else if(e instanceof EesDmt3003Event) {
				ChargeCalculationContainerVO[] chargeCalculationContainerVOs = new ChargeCalculationContainerVO[1];
				chargeCalculationContainerVOs[0] = ((EesDmt3003Event)e).getChargeCalculationContainerVO();
				msg = command.confirmContainerCharge(chargeCalculationContainerVOs,account);
			} 
			else if(e instanceof EesDmt4016Event) {
				msg = command.confirmContainerCharge(((EesDmt4016Event)e).getChargeCalculationContainerVOs(),account);
			}
			
			if (!"".equals(msg)) {
				rollback();
				eventResponse.setUserMessage(msg);
			}
			else {
				commit();
			}
		}
		catch(EventException ex) {
			log.debug("error (1) "+ex.getMessage());
			rollback();
			//throw ex;
			throw new EventException(ex.getMessage(), ex);
		}
		catch(Exception ex) {
			log.debug("error (2) "+ex.getMessage());
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_4016 : Save
	 * 해당 Charge의 CorrRmk 정보를 수정한다.
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyChargeCorrRmk(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt4016Event event = (EesDmt4016Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();

		try {
			begin();
			command.modifyChargeCorrRmk(event.getChargeArgumentVO());
			commit();
		}
		catch(EventException ex){
			rollback();
			throw ex;
		}
		catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3001 : GRP INV Creation
	 * GRP INV Creation 대상 Charge의 Exchange Rate 정보를 조회한다.
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGrpInvExRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt3001Event event = (EesDmt3001Event)e;

		try {
			List<ChargeCalculationContainerVO> list = command.searchGrpInvExRate(event.getChargeCalculationContainerVOS());
			eventResponse.setRsVoList(list);
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3002, EES_DMT_3003, EES_DMT_3004 :  <br>
	 * Booking별 Container Charge List 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeByBookingList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		//EesDmt3002Event event = (EesDmt3002Event)e;

		try {
			DmtResultVO dmtResultVO = new DmtResultVO();
			
			if (e instanceof EesDmt3002Event) {
				dmtResultVO = command.searchChargeByBookingList(((EesDmt3002Event)e).getChargeArgumentVO());
			}
			else if (e instanceof EesDmt3005Event) {
				dmtResultVO = command.searchChargeByBookingList(((EesDmt3005Event)e).getChargeArgumentVO());
			}
			
			if (dmtResultVO != null) {
				eventResponse.setETCData(dmtResultVO.getEtcData());
				eventResponse.setRsVoList(dmtResultVO.getChargeCalculationContainerVOs());
				
				List<ChargeCalculationContainerVO> list = dmtResultVO.getChargeCalculationContainerVOs();
				
				if (list != null && list.size() > 0) {
					HashMap<String, String> cntrInfo = new HashMap<String, String>();
					
					for (int i=0; i < list.size(); i++) {
						ChargeCalculationContainerVO vo = list.get(i);
						
						if (!cntrInfo.containsKey(vo.getCntrNo())) {
							cntrInfo.put(vo.getCntrNo(), "");
						}
					}
					eventResponse.setETCData("cntr_qty", String.valueOf(cntrInfo.size()));
				}
			}
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
//	/**
//	 * EES_DMT_3002, EES_DMT_3003, EES_DMT_3004 :  <br>
//	 * Delete한 Charge를 이전 Status로 복구한다.<br>
//	 * 
//	 * @param Event e 
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse removeCancelCharge(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		ChargeCalculationBC command = new ChargeCalculationBCImpl();
//		String msg = "";
//		try{
//			ChargeCalculationContainerVO[] chargeCalculationContainerVOs = null;
//			
//			begin();
//			if(e instanceof EesDmt3002Event) {
//				chargeCalculationContainerVOs = ((EesDmt3002Event)e).getChargeCalculationContainerVOS();
//				msg = command.removeCancelCharge(chargeCalculationContainerVOs, account);
//			} else if(e instanceof EesDmt3003Event) {
//				chargeCalculationContainerVOs = new ChargeCalculationContainerVO[1];
//				chargeCalculationContainerVOs[0] = ((EesDmt3003Event)e).getChargeCalculationContainerVO();
//				msg = command.removeCancelCharge(chargeCalculationContainerVOs, account);
//			} else if(e instanceof EesDmt3004Event) {
//				chargeCalculationContainerVOs = ((EesDmt3004Event)e).getChargeCalculationContainerVOS();
//				msg = command.removeCancelCharge(chargeCalculationContainerVOs, account);
//			}
//			
//			if(!msg.equals("")) {
//				rollback();
//				eventResponse.setUserMessage(msg);
//			}else{
//				commit();
//				//EDI 로 전송할 데이터 객체를 생성합니다.
//				String			ydCd	= null;
//				EDIVO 			eDIVO 	= null;
//				List<EDIVO> 	eDIVOs	= null;
//		
//				List<ChargeCalculationContainerVO> chgCalcContainerVOS = new ArrayList<ChargeCalculationContainerVO>();
//				
//				for(int i=0; i < chargeCalculationContainerVOs.length; i++) {
//					chgCalcContainerVOS.add(chargeCalculationContainerVOs[i]);
//				}
//				
//				if (chgCalcContainerVOS != null && chgCalcContainerVOS.size() > 0) {
//					eDIVOs = new ArrayList<EDIVO>(); 
//				
//					for (int i = 0 ; i < chgCalcContainerVOS.size() ; i++) {
//						
//					ydCd = chgCalcContainerVOS.get(i).getFmMvmtYdCd();
//						
//						if (ydCd == null || ydCd.length() != 7) continue;
//						
//						String locCd = ydCd.substring(0, 5);
//						//2012.05.11 KRGIN 추가
//						if ("KOR".equals(chgCalcContainerVOS.get(i).getSvrId()) 
//								&& ("KRPUS".equals(locCd) ||
//									"KRKAN".equals(locCd) ||
//									"KRINC".equals(locCd) ||
//									"KRPYT".equals(locCd) ||
//									"KRUSN".equals(locCd) ||
//									"KRGIN".equals(locCd) ||
//									"KRPTK".equals(locCd)) ) {
//							eDIVO = new EDIVO();
//							eDIVO.setBkgNo(			chgCalcContainerVOS.get(i).getBkgNo()		);
//							eDIVO.setSysAreaGrpId(	chgCalcContainerVOS.get(i).getSvrId()		);
//							eDIVO.setCntrNo(		chgCalcContainerVOS.get(i).getCntrNo()		);
//							eDIVO.setCntrCycNo(		chgCalcContainerVOS.get(i).getCntrCycNo()	);
//							eDIVO.setAcount(		account										);
//							eDIVOs.add(eDIVO);
//						}
//					}
//				}
//				
//				if (eDIVOs != null && eDIVOs.size() > 0) {
//					//공통모듈을 통해서 EDI 전송을 수행한다.
//					command.sendToEDI(eDIVOs);
//				}
//			}
//			
//		}catch(EventException ex){
//			rollback();
//			throw new EventException(ex.getMessage(), ex);
//			//throw ex;
//		}catch(Exception ex){
//			rollback();
//			throw new EventException(ex.getMessage(), ex);
//		}
//		return eventResponse;
//	}
	
	
	/**
	 * EES_DMT_3002, EES_DMT_3005 : Pre Cal.<br>
	 * Charge의 To Data에 DR Data를 입력하고, 저장전에 미리 얼마의 금액이 계산되는지 조회한다.<br>
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
				
				// by BKG(EES_DMT_3002.do), by BKG Inquiry(EES_DMT_3005.do) 화면에서 호출시 실행된다.
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
	 * Pre Calculation BackEndJob 처리 결과를 리턴한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse precalDRDateChargeBackEndJob(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			ChargeArgumentVO chargeArgumentVO = new ChargeArgumentVO();
			
			if (e instanceof EesDmt3002Event) {
				chargeArgumentVO = ((EesDmt3002Event)e).getChargeArgumentVO();
			} 
			else if(e instanceof EesDmt3005Event) {
				chargeArgumentVO = ((EesDmt3005Event)e).getChargeArgumentVO();
			}
			
			if (chargeArgumentVO != null) {
				
				DmtResultVO resultVO = (DmtResultVO)BackEndJobResult.loadFromFile(chargeArgumentVO.getBackendjobKey());
				if (resultVO != null) {
					
					if (resultVO.getResultCode() == null) {
						// by BKG(EES_DMT_3002.do), by BKG Inquiry(EES_DMT_3005.do) 화면에서 호출시 실행된다.
						eventResponse.setRsVoList(resultVO.getChargeCalculationContainerVOs());
					} 
					else {
						if (resultVO.getResultMsg() != null) {
							eventResponse.setUserMessage(resultVO.getResultMsg());
						}
						else {
							eventResponse.setUserMessage(new ErrorHandler(resultVO.getResultCode()).getUserMessage());
						}
					}
				}
			}
		} 
		catch(Exception ex) {
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
			ChargeArgumentVO chargeArgumentVO = new ChargeArgumentVO();
			ChargeCalculationContainerVO[] chargeCalculationContainerVOs = new ChargeCalculationContainerVO[1];
			
			if(e instanceof EesDmt3002Event) {
				chargeArgumentVO = ((EesDmt3002Event)e).getChargeArgumentVO();
				chargeCalculationContainerVOs = ((EesDmt3002Event)e).getChargeCalculationContainerVOS();
				
			} 
			else if(e instanceof EesDmt3005Event) {
				chargeArgumentVO = ((EesDmt3005Event)e).getChargeArgumentVO();
				chargeCalculationContainerVOs = ((EesDmt3005Event)e).getChargeCalculationContainerVOS();
				
			} 
			else if(e instanceof EesDmt3102Event) {
				chargeArgumentVO = ((EesDmt3102Event)e).getChargeArgumentVO();
				chargeCalculationContainerVOs = ((EesDmt3102Event)e).getChargeCalculationContainerVOS();
				
			} 
			else if(e instanceof EesDmt3106Event) {
				chargeArgumentVO = ((EesDmt3106Event)e).getChargeArgumentVO();
				chargeCalculationContainerVOs = ((EesDmt3106Event)e).getChargeCalculationContainerVOs();
				
			} 
			else if(e instanceof EesDmt4016Event) {
				chargeArgumentVO = ((EesDmt4016Event)e).getChargeArgumentVO();
				chargeCalculationContainerVOs = ((EesDmt4016Event)e).getChargeCalculationContainerVOs();
			}
			
			//BackEndJob 모듈을 호출한다.
			String backEndJobKey = command.doBackEndJob(chargeArgumentVO, chargeCalculationContainerVOs, account);
			eventResponse.setETCData("BackEndJobKey", backEndJobKey);
		}
		catch(EventException ex){
			throw ex;
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_2009 : btn_approval<br>
	 * Long Tx 상태 조회<br>
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
			ChargeArgumentVO chargeArgumentVO = new ChargeArgumentVO();
			
			if (e instanceof EesDmt3002Event) {
				chargeArgumentVO = ((EesDmt3002Event)e).getChargeArgumentVO();
			} 
			else if(e instanceof EesDmt3005Event) {
				chargeArgumentVO = ((EesDmt3005Event)e).getChargeArgumentVO();
			} 
			else if(e instanceof EesDmt3102Event) {
				chargeArgumentVO = ((EesDmt3102Event)e).getChargeArgumentVO();
			} 
			else if(e instanceof EesDmt3106Event) {
				chargeArgumentVO = ((EesDmt3106Event)e).getChargeArgumentVO();
			} 
			else if(e instanceof EesDmt4016Event) {
				chargeArgumentVO = ((EesDmt4016Event)e).getChargeArgumentVO();
			}
			
			if (chargeArgumentVO != null) {
				//BackEndJob 모듈의 현재 작업상태와  오류 발생시 오류 메세지를 조회한다.
				String[] result = command.checkBackEndJob(chargeArgumentVO.getBackendjobKey());
				
				if (result != null && result.length > 1) {
					eventResponse.setETCData("jb_sts_flg",		result[0]);
					eventResponse.setETCData("jb_usr_err_msg",	result[1]);
				}
			}
		}
		catch(EventException ex){
//			rollback();
			throw ex;
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3002 : D/R Save<br>
	 * Container Charge 정보를 수정한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3002Event event = (EesDmt3002Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();

		try {
			ChargeArgumentVO chargeArgumentVO = event.getChargeArgumentVO();
			if (chargeArgumentVO != null) {
				
				DmtResultVO resultVO = (DmtResultVO)BackEndJobResult.loadFromFile(chargeArgumentVO.getBackendjobKey());
				if (resultVO != null) {
					
					if (resultVO.getResultCode() == null) {
						//EDI 로 전송할 데이터 객체를 생성합니다.
						List<EDIVO>	eDIVOs			= new ArrayList<EDIVO>();
						List<EDIVO>	ftEndDtEDIVOs	= new ArrayList<EDIVO>();
						
						ChargeCalculationContainerVO[] chargeCalculationContainerVOs = resultVO.getChargeCalculationContainerVOArray();
						List<ChargeCalculationContainerVO> chgCalcContainerVOS = new ArrayList<ChargeCalculationContainerVO>();
						
						for (int i=0; i < chargeCalculationContainerVOs.length; i++) {
							chgCalcContainerVOS.add(chargeCalculationContainerVOs[i]);
						}
						
						if (chgCalcContainerVOS != null && chgCalcContainerVOS.size() > 0) {
							for (int i = 0 ; i < chgCalcContainerVOS.size() ; i++) {
							
								String ydCd = chgCalcContainerVOS.get(i).getFmMvmtYdCd();
								if (ydCd == null || ydCd.length() != 7) continue;
								
								String locCd = ydCd.substring(0, 5);
								//2012.05.11 KRGIN 추가
								if ("KOR".equals(chgCalcContainerVOS.get(i).getSvrId()) 
										&& ("KRPUS".equals(locCd) ||
											"KRKAN".equals(locCd) ||
											"KRINC".equals(locCd) ||
											"KRPYT".equals(locCd) ||
											"KRUSN".equals(locCd) ||
											"KRGIN".equals(locCd) ||
											"KRPTK".equals(locCd)) ) {
									EDIVO eDIVO = new EDIVO();
									eDIVO.setBkgNo(			chgCalcContainerVOS.get(i).getBkgNo()		);
									eDIVO.setSysAreaGrpId(	chgCalcContainerVOS.get(i).getSvrId()		);
									eDIVO.setCntrNo(		chgCalcContainerVOS.get(i).getCntrNo()		);
									eDIVO.setCntrCycNo(		chgCalcContainerVOS.get(i).getCntrCycNo()	);
									eDIVO.setAcount(		account										);
									eDIVOs.add(eDIVO);
									//2011.11.07 김현화 [CHM-201113641-01]E-DO Free Time관련 기능 추가(KT-NET)
									// Chg_seq가 1일 경우만 전송하도록 함.2012.01.12 김현화
									//log.debug("modifyCharge=======SC==== chg_seq===="+ chgCalcContainerVOS.get(i).getChgSeq());
									// EDO는 DMIF, CTIC 만  전송되도록 함. 2012.01.26  김현화	
									String trfCd = chgCalcContainerVOS.get(i).getDmdtTrfCd();
									String dulTpExptFlg = chgCalcContainerVOS.get(i).getDulTpExptFlg();
									if (dulTpExptFlg == null) {
										dulTpExptFlg = "N";
									}
									if ("1".equals(chgCalcContainerVOS.get(i).getChgSeq())
											&& ( ("DMIF".equals(trfCd) && "N".equals(dulTpExptFlg))
											   ||("CTIC".equals(trfCd) && "Y".equals(dulTpExptFlg)))
										) {
										EDIVO ftEndDtEDIVO = new EDIVO();
									    ftEndDtEDIVO.setBkgNo(   chgCalcContainerVOS.get(i).getBkgNo() );
									    ftEndDtEDIVO.setFtEndDt( chgCalcContainerVOS.get(i).getFtEndDt() );
									    ftEndDtEDIVO.setCntrNo(	 chgCalcContainerVOS.get(i).getCntrNo()	 );
									    ftEndDtEDIVO.setAcount(	 account);
									    ftEndDtEDIVOs.add(ftEndDtEDIVO);
									}
								}
							}
						}
						
						if (eDIVOs != null && eDIVOs.size() > 0) {
							//공통모듈을 통해서 EDI 전송을 수행한다.
							command.sendToEDI(eDIVOs);
						}
						
						if (ftEndDtEDIVOs != null && ftEndDtEDIVOs.size() > 0) {
							//EDO charge Free time End date 변경된 경우   EDI 전송을 수행한다. 2011.11.07
							//log.debug("modifyCharge sendEDOChargeFreeTime====start====");
							command.sendEDOChargeFreeTime(ftEndDtEDIVOs);
						}
						   // log.debug("modifyCharge ===end===");
					} 
					else {
						if (resultVO.getResultMsg() != null) {
							eventResponse.setUserMessage(resultVO.getResultMsg());
						}
						else {
							eventResponse.setUserMessage(new ErrorHandler(resultVO.getResultCode()).getUserMessage());
						}
					}
				}
			}
		} 
		catch(EventException ex){
			throw ex;
		} 
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3002 : Balance Creation<br>
	 * Balance Charge를 생성한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBalanceCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt3002Event event = (EesDmt3002Event)e;

		try {
			ChargeArgumentVO chargeArgumentVO = event.getChargeArgumentVO();
			if (chargeArgumentVO != null) {
				
				DmtResultVO resultVO = (DmtResultVO)BackEndJobResult.loadFromFile(chargeArgumentVO.getBackendjobKey());
				if (resultVO != null) {
					
					if (resultVO.getResultCode() == null) {
						//EDI 로 전송할 데이터 객체를 생성합니다.
						List<EDIVO> 	eDIVOs	= new ArrayList<EDIVO>();
		//				EDIVO 			ftEndDtEDIVO 	= null;
		//				List<EDIVO> 	ftEndDtEDIVOs	= null;
						
						ChargeCalculationContainerVO[] chargeCalculationContainerVOs = resultVO.getChargeCalculationContainerVOArray();
						List<ChargeCalculationContainerVO> chgCalcContainerVOS = new ArrayList<ChargeCalculationContainerVO>();
						
						for (int i=0; i < chargeCalculationContainerVOs.length; i++) {
							chgCalcContainerVOS.add(chargeCalculationContainerVOs[i]);
						}
						
						if (chgCalcContainerVOS != null && chgCalcContainerVOS.size() > 0) {
							//ftEndDtEDIVOs = new ArrayList<EDIVO>(); 
							for (int i = 0 ; i < chgCalcContainerVOS.size() ; i++) {

								String ydCd = chgCalcContainerVOS.get(i).getFmMvmtYdCd();
								if (ydCd == null || ydCd.length() != 7) continue;
								
								String locCd = ydCd.substring(0, 5);
								//2012.05.11 KRGIN 추가
								if ("KOR".equals(chgCalcContainerVOS.get(i).getSvrId()) 
										&& ("KRPUS".equals(locCd) ||
											"KRKAN".equals(locCd) ||
											"KRINC".equals(locCd) ||
											"KRPYT".equals(locCd) ||
											"KRUSN".equals(locCd) ||
											"KRGIN".equals(locCd) ||
											"KRPTK".equals(locCd)) ) {
									EDIVO eDIVO = new EDIVO();
									eDIVO.setBkgNo(			chgCalcContainerVOS.get(i).getBkgNo()		);
									eDIVO.setSysAreaGrpId(	chgCalcContainerVOS.get(i).getSvrId()		);
									eDIVO.setCntrNo(		chgCalcContainerVOS.get(i).getCntrNo()		);
									eDIVO.setCntrCycNo(		chgCalcContainerVOS.get(i).getCntrCycNo()	);
									eDIVO.setAcount(		account										);
									eDIVOs.add(eDIVO);
									
		//							//2011.11.07 김현화 [CHM-201113641-01]E-DO Free Time관련 기능 추가(KT-NET)
		//							if ("1".equals(chgCalcContainerVOS.get(i).getChgSeq())){
		//							    ftEndDtEDIVO = new EDIVO();
		//							    ftEndDtEDIVO.setBkgNo(   chgCalcContainerVOS.get(i).getBkgNo() );
		//							    ftEndDtEDIVO.setFtEndDt( chgCalcContainerVOS.get(i).getFtEndDt() );
		//							    ftEndDtEDIVO.setAcount(  account);
		//							    ftEndDtEDIVOs.add(ftEndDtEDIVO);
		//							}  
								}
							}
						}
						
						if (eDIVOs != null && eDIVOs.size() > 0) {
							//공통모듈을 통해서 EDI 전송을 수행한다.
							command.sendToEDI(eDIVOs);
						}
		                //Balanced charge는 전송 안함. 2012.01.12				
		//				if (ftEndDtEDIVOs != null && ftEndDtEDIVOs.size() > 0) {
		//					//EDO charge Free time End date 변경된 경우   EDI 전송을 수행한다. 2011.11.07
		//					command.sendEDOChargeFreeTime(ftEndDtEDIVOs);
		//				}
					} 
					else {
						if (resultVO.getResultMsg() != null) {
							eventResponse.setUserMessage(resultVO.getResultMsg());
						}
						else {
							eventResponse.setUserMessage(new ErrorHandler(resultVO.getResultCode()).getUserMessage());
						}
					}
				}
			}
		} 
		catch(EventException ex){
			throw ex;
		} 
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3006 : Charge Inquiry by CNTR <br>
	 * Container별 Tariff Type별 Charge 한건을 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeByContainer(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();

		try{
			ChargeArgumentVO chargeArgumentVO = new ChargeArgumentVO();
			
			if(e instanceof EesDmt3003Event) {
				chargeArgumentVO = ((EesDmt3003Event)e).getChargeArgumentVO();
			} else if(e instanceof EesDmt3006Event) {
				chargeArgumentVO = ((EesDmt3006Event)e).getChargeArgumentVO();
			}
			
			if (chargeArgumentVO != null) {
				chargeArgumentVO.setOfcCd(account.getOfc_cd());
				DmtResultVO resultVO = command.searchChargeByContainer(chargeArgumentVO);
				
				if (resultVO != null) {
					eventResponse.setETCData(resultVO.getEtcData());
					eventResponse.setRsVoList(resultVO.getChrgDtlVOs());
				}
			}
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3003 : D/R Cancel <br>
	 * General Charge를 제외한 DR로 생성된 모든 Balance Charge를 삭제한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelDRBalanceCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3003Event event = (EesDmt3003Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();

		try {
			begin();
			String result = command.cancelDRBalanceCharge(event.getChargeCalculationContainerVO(), account);
			
			if (!"".equals(result)) {
				eventResponse.setUserMessage(new ErrorHandler(result).getUserMessage());
				rollback();
			} 
			else {
				commit();
				
				//EDI 로 전송할 데이터 객체를 생성합니다.
				List<EDIVO> eDIVOs = new ArrayList<EDIVO>(); 
				
				List<ChargeCalculationContainerVO> chgCalcContainerVOS = new ArrayList<ChargeCalculationContainerVO>();
				chgCalcContainerVOS.add(event.getChargeCalculationContainerVO());
				
				if (chgCalcContainerVOS != null && chgCalcContainerVOS.size() > 0) {
					for (int i = 0; i < chgCalcContainerVOS.size(); i++) {
						
						String ydCd = chgCalcContainerVOS.get(i).getFmMvmtYdCd();
						if (ydCd == null || ydCd.length() != 7) continue;
						
						String locCd = ydCd.substring(0, 5);
						//2012.05.11 KRGIN 추가
						if ("KOR".equals(chgCalcContainerVOS.get(i).getSvrId()) 
								&& ("KRPUS".equals(locCd) ||
									"KRKAN".equals(locCd) ||
									"KRINC".equals(locCd) ||
									"KRPYT".equals(locCd) ||
									"KRUSN".equals(locCd) ||
									"KRGIN".equals(locCd) ||
									"KRPTK".equals(locCd)) ) {
							EDIVO eDIVO = new EDIVO();
							eDIVO.setBkgNo(			chgCalcContainerVOS.get(i).getBkgNo()		);
							eDIVO.setSysAreaGrpId(	chgCalcContainerVOS.get(i).getSvrId()		);
							eDIVO.setCntrNo(		chgCalcContainerVOS.get(i).getCntrNo()		);
							eDIVO.setCntrCycNo(		chgCalcContainerVOS.get(i).getCntrCycNo()	);
							eDIVO.setAcount(		account										);
							eDIVOs.add(eDIVO);
						}
					}
				}
				
				if (eDIVOs != null && eDIVOs.size() > 0) {
					//공통모듈을 통해서 EDI 전송을 수행한다.
					command.sendToEDI(eDIVOs);
				}
			}
			
		}
		catch(EventException ex){
			rollback();
			throw ex;
		}
		catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3003 : Save <br>
	 * Container Charge 정보를 수정한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyChargeByContainer(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt3003Event event = (EesDmt3003Event)e;

		try {
			begin();
			DmtResultVO resultVO = command.modifyChargeByContainer(event.getChargeCalculationContainerVO(), account);
			if (resultVO != null) {
				
				if (resultVO.getResultCode() == null) {
					commit();
					
					//EDI 로 전송할 데이터 객체를 생성합니다.
					List<EDIVO> eDIVOs			= new ArrayList<EDIVO>();
					List<EDIVO> ftEndDtEDIVOs	= new ArrayList<EDIVO>(); 
					
					List<ChargeCalculationContainerVO> chgCalcContainerVOS = new ArrayList<ChargeCalculationContainerVO>();
					chgCalcContainerVOS.add(event.getChargeCalculationContainerVO());
									
					 //단건 처리 경우이므로 resultVO의 FtEndDt 하나로 사용하도록 처리하였음.
					String ftEndDt = "";
					ChargeCalculationContainerVO[] chargeCalculationContainerVOs = resultVO.getChargeCalculationContainerVOArray();
					if (chargeCalculationContainerVOs != null && chargeCalculationContainerVOs.length > 0) {
						ftEndDt = chargeCalculationContainerVOs[0].getFtEndDt();
					}
					
					if (chgCalcContainerVOS != null && chgCalcContainerVOS.size() > 0) {
						for (int i = 0 ; i < chgCalcContainerVOS.size() ; i++) {
	
							String ydCd = chgCalcContainerVOS.get(i).getFmMvmtYdCd();
							if (ydCd == null || ydCd.length() != 7) continue;
							
							String locCd = ydCd.substring(0, 5);
							//2012.05.11 KRGIN 추가
							if ("KOR".equals(chgCalcContainerVOS.get(i).getSvrId()) 
									&& ("KRPUS".equals(locCd) ||
										"KRKAN".equals(locCd) ||
										"KRINC".equals(locCd) ||
										"KRPYT".equals(locCd) ||
										"KRUSN".equals(locCd) ||
										"KRGIN".equals(locCd) ||
										"KRPTK".equals(locCd)) ) {
								EDIVO eDIVO = new EDIVO();
								eDIVO.setBkgNo(			chgCalcContainerVOS.get(i).getBkgNo()		);
								eDIVO.setSysAreaGrpId(	chgCalcContainerVOS.get(i).getSvrId()		);
								eDIVO.setCntrNo(		chgCalcContainerVOS.get(i).getCntrNo()		);
								eDIVO.setCntrCycNo(		chgCalcContainerVOS.get(i).getCntrCycNo()	);
								eDIVO.setAcount(		account										);
								eDIVOs.add(eDIVO);
								
								//2011.11.07 김현화 [CHM-201113641-01]E-DO Free Time관련 기능 추가(KT-NET)
								// Chg_seq가 1일 경우만 전송하도록 함.2012.01.12 김현화
								//log.debug("modifyChargeByContainer=======SC==== chg_seq===="+ chgCalcContainerVOS.get(i).getChgSeq());
								// EDO는 DMIF, CTIC 만  전송되도록 함. 2012.01.26  김현화	
								String trfCd = chgCalcContainerVOS.get(i).getDmdtTrfCd();
								String dulTpExptFlg = chgCalcContainerVOS.get(i).getDulTpExptFlg();
								if (dulTpExptFlg == null) {
									dulTpExptFlg = "N";
								}
								//log.debug("modifyChargeByContainer dulTpExptFlg===="+dulTpExptFlg+"====");
								//log.debug("modifyChargeByContainer getChgSeq===="+chgCalcContainerVOS.get(i).getChgSeq()+"====");
								if ("1".equals(chgCalcContainerVOS.get(i).getChgSeq())
										&& ( ("DMIF".equals(trfCd) && "N".equals(dulTpExptFlg))
										   ||("CTIC".equals(trfCd) && "Y".equals(dulTpExptFlg)))
									) {
									EDIVO ftEndDtEDIVO = new EDIVO();
								    ftEndDtEDIVO.setBkgNo(   chgCalcContainerVOS.get(i).getBkgNo() );
								    ftEndDtEDIVO.setFtEndDt( ftEndDt );
								    ftEndDtEDIVO.setCntrNo(	 chgCalcContainerVOS.get(i).getCntrNo()	 );
								    ftEndDtEDIVO.setAcount(	 account);
								//log.debug("cntr no =======SC====== chgCalcContainerVOS.get(i).getCntrNo()===="+ chgCalcContainerVOS.get(i).getCntrNo());
								//log.debug("modifyChargeByContainer  cntr no =======SC============"+ftEndDtEDIVO.getCntrNo());
								
								    ftEndDtEDIVOs.add(ftEndDtEDIVO);
								}
							}
						}
					}
					
					if (eDIVOs != null && eDIVOs.size() > 0) {
						//공통모듈을 통해서 EDI 전송을 수행한다.
						command.sendToEDI(eDIVOs);
					}
					if (ftEndDtEDIVOs != null && ftEndDtEDIVOs.size() > 0) {
						//EDO charge Free time End date 변경된 경우   EDI 전송을 수행한다. 2011.11.07
						//log.debug("modifyChargeByContainer sendEDOChargeFreeTime====start====");
						command.sendEDOChargeFreeTime(ftEndDtEDIVOs);
					}
					    //log.debug("modifyChargeByContainer sendEDOChargeFreeTime====end====");
				} 
				else {
					rollback();
					
					if (resultVO.getResultMsg() != null) {
						eventResponse.setUserMessage(resultVO.getResultMsg());
					}
					else {
						eventResponse.setUserMessage(new ErrorHandler(resultVO.getResultCode()).getUserMessage());
					}
				}
			}
			else {
				rollback();
			}
		}
		catch(EventException ex) {
			rollback();
			throw ex;
		}
		catch(Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3004 : Charge Inquiry by Office & VVD <br>
	 * Office별 또는 VVD별 Charge 생성한 List를 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeStatusListByOfficeOrVVD(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		CommonFinderBC command2 = new CommonFinderBCImpl();
		EesDmt3004Event event = (EesDmt3004Event)e;

		try {
			ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO = event.getChargeByOfficeOrVVDVO();

			DBRowSet rsSet = command.searchChargeStatusListByOfficeOrVVD(chargeByOfficeOrVVDVO);
			eventResponse.setRs(rsSet);
			
			UserRoleVO paramRoleVO = new UserRoleVO();
			paramRoleVO.setUsrId(account.getUsr_id());
			paramRoleVO.setPgmNo("EES_DMT_3002");
			paramRoleVO.setUsrRoleCd("DMT01,DMT02,DMT03,DMT04");
			//로그인 User의  해당 페이지(EES_DMT_3002) Access 권한 정보를 조회한다.
			UserRoleVO roleVO = command2.hasRoleAuth(paramRoleVO);
			
			if (roleVO != null) {
				eventResponse.setETCData("ROLE_PERMIT",	roleVO.getIsAuthorized());
				eventResponse.setETCData("ROLE_AUTH",	roleVO.getUsrRoleCd());
			}
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3103 : Correction History <br>
	 * Charge별 계산한 History를 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCorrectionHistory(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt3103Event event = (EesDmt3103Event)e;
		
		try {
			List<DmtChgCorrHisVO> list = command.searchCorrectionHistory(event.getChargeArgumentVO());
			eventResponse.setRsVoList(list);
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
//	/**
//	 * EES_DMT_3104 : Open
//	 * Charge Delete시 Delete Reason List를 조회한다.<br>
//	 * 
//	 * @param Event e 
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse searchDeleteReasonList(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		ChargeCalculationBC command = new ChargeCalculationBCImpl();
//		//EesDmt3104Event event = (EesDmt3104Event)e;
//		
//		try {
//			List<DeleteReasonListVO> list = command.searchDeleteReasonList();
//			eventResponse.setRsVoList(list);
//		}
//		catch(EventException ex) {
//			throw ex;
//		}
//		catch(Exception ex) {
//			throw new EventException(ex.getMessage(), ex);
//		}
//		return eventResponse;
//	}
	
//	/**
//	 * EES_DMT_3104 : Save --> EES_DMT_3014 : Save 로 변경(2011.07.18)
//	 * 해당 Charge를 Delete 처리한다.
//	 * 
//	 * @param Event e 
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse removeCharge(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EesDmt3014Event event = (EesDmt3014Event)e;
//		ChargeCalculationBC command = new ChargeCalculationBCImpl();
//		try{
//			begin();
//			String result = command.removeCharge(event.getChargeCalculationContainerVOS(), account);
//			
//			if(!result.equals("")) {
//				eventResponse.setUserMessage(new ErrorHandler(result).getUserMessage());
//				rollback();
//			} else {
//				eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
//				commit();
//			}
//		}catch(EventException ex){
//			rollback();
//			//throw ex;
//			throw new EventException(ex.getMessage(), ex);
//		}catch(Exception ex){
//			rollback();
//			throw new EventException(ex.getMessage(), ex);
//		}
//		return eventResponse;
//	}

	/**
	 * EES_DMT_3014 : Approval for Charge Deletion
	 * 해당 Charge를 Approval or Reject 한다.
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyChargeDeletionProcessStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EesDmt3014Event event = (EesDmt3014Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();

		RFAExceptionTariffMgtBC 	commandrqst 		= new RFAExceptionTariffMgtBCImpl();
		String aproNo = "";
//		ChargeCalculationContainerVO[] chargeCalculationContainerVOs = event.getChargeCalculationContainerVOS();
				
		try {
			log.debug("\n[modifyChargeDeletionProcessStatus] STEP-1.1 :: CHARGE DELETION 요청에 대한 승인처리를 실행합니다.");

			ChargeCalculationContainerVO[] chargeCalculationContainerVOs = new ChargeCalculationContainerVO[1];

			if (e instanceof EesDmt3014Event) {
				chargeCalculationContainerVOs = ((EesDmt3014Event)e).getChargeCalculationContainerVOS();
			} 		
			else if (e instanceof EesDmt3104Event) {
				chargeCalculationContainerVOs = ((EesDmt3104Event)e).getChargeCalculationContainerVOS();
			}

			// Charge Deletion 승인처리 전 승인권한과 승인상태의 유효여부를 체크합니다.
			command.checkChargeDeletionValidation(chargeCalculationContainerVOs, account);
			
			// Charge Deletion 요청에 대한 승인 or 승인거절을 처리한다.
			begin();
			
			if ( "".equals(chargeCalculationContainerVOs[0].getInactAproNo()) && command.isChargeDeletionLastApprovalPath(chargeCalculationContainerVOs[0])){
				aproNo = commandrqst.searchNewApprovalNo(account.getUsr_id(), account.getOfc_cd(),"D");
				chargeCalculationContainerVOs[0].setInactAproNo(aproNo);
			}
			
			command.modifyChargeDeletionProcessStatus(chargeCalculationContainerVOs, account);
			commit();
			log.debug("\n[modifyChargeDeletionProcessStatus] STEP-1.2 :: CHARGE DELETION 요청에 대한 승인처리를 종료합니다.");
			
			log.debug("\n[modifyChargeDeletionProcessStatus] STEP-2.1 :: CHARGE DELETION 요청에 대한 EDI 전송을 실행합니다.");
			// EDI 전송(삭제 후 복원된 CNTR. 에 대해서 EDI 전송을 실행합니다.)
			this.sendToEDIforChgDelt(chargeCalculationContainerVOs, account);
			log.debug("\n[modifyChargeDeletionProcessStatus] STEP-2.2 :: CHARGE DELETION 요청에 대한 EDI 전송을 종료합니다.");
			
			log.debug("\n[modifyChargeDeletionProcessStatus] STEP-3.1 :: CHARGE DELETION 요청에 대한 NOTICE 메일전송을 실행합니다.");
			// Notice 메일을 전송한다.
			this.sendChgDeltNoticeGWMail(chargeCalculationContainerVOs, account);
			log.debug("\n[modifyChargeDeletionProcessStatus] STEP-3.2 :: CHARGE DELETION 요청에 대한 NOTICE 메일전송을 종료합니다.");

			if ( "".equals(chargeCalculationContainerVOs[0].getInactAproNo()))
				eventResponse.setETCData("APVL_NO",	" ");
			else
				eventResponse.setETCData("APVL_NO",	aproNo);
			
			if("J".equals(chargeCalculationContainerVOs[0].getChgDeltStsCd()))
				eventResponse.setETCData("STS_CD",	chargeCalculationContainerVOs[0].getChgDeltPathCd()+" Reject");
			else if("A".equals(chargeCalculationContainerVOs[0].getChgDeltStsCd()))
				eventResponse.setETCData("STS_CD",	chargeCalculationContainerVOs[0].getChgDeltPathCd()+" Aproval");
			
//			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
		}
		catch(EventException ex) {
			rollback();
			throw ex;
		}
		catch(Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3009 : O/T History <br>
	 * Office Transfer 내역을 Office/날짜별로 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeTransferHistoryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeOfficeTransferMgtBC command = new ChargeOfficeTransferMgtBCImpl();
		EesDmt3009Event event = (EesDmt3009Event)e;
		
		try {
			List<DmtOfcTrnsHisVO> list = command.searchOfficeTransferHistoryList(event.getOfficeTransferParmVO());
			eventResponse.setRsVoList(list);
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3101 : OFC Trans <br>
	 * Charge를 Office Transfer되도록 Data를 수정한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createOfficeTransferCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3101Event event = (EesDmt3101Event)e;
		ChargeOfficeTransferMgtBC command = new ChargeOfficeTransferMgtBCImpl();
		
		try {
			begin();
			String[] result = command.createOfficeTransferCharge(event.getOfficeTransferParmVOS(), account);
			
			if (result != null && result.length > 1) {
				if (result[0] != null) {
					String errCode = result[0];
					
					if ("DMT01011".equals(errCode)) {
						String errMsg = new ErrorHandler(errCode).getUserMessage();
						eventResponse.setUserMessage(errMsg.replaceAll("CNTR_NO", result[1]));
					} 
					else {
						eventResponse.setUserMessage(new ErrorHandler(errCode).getUserMessage());
					}
					rollback();
				} 
				else if (result[1] != null) {
					ChargeCalculationBC command2 = new ChargeCalculationBCImpl();
					String rhqChkFlg = result[1];
					String errCode2    = "";
					
					if ("N".equals(rhqChkFlg)) {
						// 동일한 RHQ
						errCode2 = command2.modifyChargeByOfficeTransfer(event.getOfficeTransferParmVOS(), account);
						
						if ("".equals(errCode2)) {
							commit();
						}
						else {
							//FROM OFFICE 가 존재하는지 체크 함 , 존재하지 않으면 에러 처리함(DMT01081)
							eventResponse.setUserMessage(new ErrorHandler(errCode2).getUserMessage());
							rollback();
						}
					} 
					else {
						// 다른 RHQ, SVR_ID가 다름
						command2.createChargeByOfficeTransfer(event.getOfficeTransferParmVOS());
						commit();
					}
				}
			}
			else {
				rollback();
			}
		}
		catch(EventException ex) {
			rollback();
			throw ex;
		}
		catch(Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
	}
	
	/**
	 * EES_DMT_3102 : Partial <br>
	 * Partial할 대상 Charge를 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPartialPayment(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt3102Event event = (EesDmt3102Event)e;
		
		try {
			List<ChargeCalculationContainerVO> list = command.searchPartialPayment(event.getChargeArgumentVO());
			eventResponse.setRsVoList(list);
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3102 : Delete <br>
	 * 하나의 Charge를 Partial한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createPartialPayment(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt3102Event event = (EesDmt3102Event)e;
		
		try {
			ChargeArgumentVO chargeArgumentVO = event.getChargeArgumentVO();
			if (chargeArgumentVO != null) {
				
				DmtResultVO resultVO = (DmtResultVO)BackEndJobResult.loadFromFile(chargeArgumentVO.getBackendjobKey());
				if (resultVO != null) {
					
					if (resultVO.getResultCode() == null) {
						//EDI 로 전송할 데이터 객체를 생성합니다.
						List<EDIVO> eDIVOs			= new ArrayList<EDIVO>();
						List<EDIVO> ftEndDtEDIVOs	= new ArrayList<EDIVO>();
						
						ChargeCalculationContainerVO[] chargeCalculationContainerVOs = resultVO.getChargeCalculationContainerVOArray();
						List<ChargeCalculationContainerVO> chgCalcContainerVOS = new ArrayList<ChargeCalculationContainerVO>();
						
						for (int i=0; i < chargeCalculationContainerVOs.length; i++) {
							chgCalcContainerVOS.add(chargeCalculationContainerVOs[i]);
						}
						
						if (chgCalcContainerVOS != null && chgCalcContainerVOS.size() > 0) {
							for (int i = 0 ; i < chgCalcContainerVOS.size() ; i++) {
		
								String ydCd = chgCalcContainerVOS.get(i).getFmMvmtYdCd();
								if (ydCd == null || ydCd.length() != 7) continue;
								
								String locCd = ydCd.substring(0, 5);
								//2012.05.11 KRGIN 추가
								if ("KOR".equals(chgCalcContainerVOS.get(i).getSvrId()) 
										&& ("KRPUS".equals(locCd) ||
											"KRKAN".equals(locCd) ||
											"KRINC".equals(locCd) ||
											"KRPYT".equals(locCd) ||
											"KRUSN".equals(locCd) ||
											"KRGIN".equals(locCd) ||
											"KRPTK".equals(locCd)) ) {
									EDIVO eDIVO = new EDIVO();
									eDIVO.setBkgNo(			chgCalcContainerVOS.get(i).getBkgNo()		);
									eDIVO.setSysAreaGrpId(	chgCalcContainerVOS.get(i).getSvrId()		);
									eDIVO.setCntrNo(		chgCalcContainerVOS.get(i).getCntrNo()		);
									eDIVO.setCntrCycNo(		chgCalcContainerVOS.get(i).getCntrCycNo()	);
									eDIVO.setAcount(		account										);
									eDIVOs.add(eDIVO);
									
									//2011.11.07  김현화 [CHM-201113641-01]E-DO Free Time관련 기능 추가(KT-NET)
									// Chg_seq가 1일 경우만 전송하도록 함. 2012.01.12 김현화
									//log.debug("createPartialPayment=======SC==== chg_seq===="+ chgCalcContainerVOS.get(i).getChgSeq());
									// EDO는 DMIF, CTIC 만 전송되도록 함. 2012.01.26  김현화	
									String trfCd = chgCalcContainerVOS.get(i).getDmdtTrfCd();
									String dulTpExptFlg = chgCalcContainerVOS.get(i).getDulTpExptFlg();
									if (dulTpExptFlg == null) {
										dulTpExptFlg = "N";
									}
									//log.debug("modifyChargeByBooking trfCd===="+trfCd+"====");
									//log.debug("modifyChargeByBooking dulTpExptFlg===="+dulTpExptFlg+"====");
									//log.debug("modifyChargeByBooking getChgSeq===="+chgCalcContainerVOS.get(i).getChgSeq()+"====");
									
									if ("1".equals(chgCalcContainerVOS.get(i).getChgSeq())
											&& ( ("DMIF".equals(trfCd) && "N".equals(dulTpExptFlg))
											   ||("CTIC".equals(trfCd) && "Y".equals(dulTpExptFlg)))	
									   ) {
										EDIVO ftEndDtEDIVO = new EDIVO();
									     ftEndDtEDIVO.setBkgNo(   chgCalcContainerVOS.get(i).getBkgNo()   );
									     ftEndDtEDIVO.setFtEndDt( chgCalcContainerVOS.get(i).getFtEndDt() );
									     ftEndDtEDIVO.setCntrNo(	 chgCalcContainerVOS.get(i).getCntrNo()	 );
									     ftEndDtEDIVO.setAcount(	 account);
									     ftEndDtEDIVOs.add(ftEndDtEDIVO);
									}
								}
							}
						}
						
						if (eDIVOs != null && eDIVOs.size() > 0) {
							//공통모듈을 통해서 EDI 전송을 수행한다.
							command.sendToEDI(eDIVOs);
						}
						
						if (ftEndDtEDIVOs != null && ftEndDtEDIVOs.size() > 0) {
							//EDO charge Free time End date 변경된 경우   EDI 전송을 수행한다. 2011.11.07
							//log.debug("sendEDOChargeFreeTime===========================");
							command.sendEDOChargeFreeTime(ftEndDtEDIVOs);
						}
					} 
					else {
						if (resultVO.getResultMsg() != null) {
							eventResponse.setUserMessage(resultVO.getResultMsg());
						}
						else {
							eventResponse.setUserMessage(new ErrorHandler(resultVO.getResultCode()).getUserMessage());
						}
					}
				}
			}
		} 
		catch(EventException ex) {
			throw ex;
		} 
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3105 : Open
	 * Container별 Office Transfer History 정보를 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeTransferHistoryListByContainer(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeOfficeTransferMgtBC command = new ChargeOfficeTransferMgtBCImpl();
		EesDmt3105Event event = (EesDmt3105Event)e;
		
		try {
			List<OfficeTransferHistoryByContainerVO> list = command.searchOfficeTransferHistoryListByContainer(event.getOfficeTransferParmVO());
			eventResponse.setRsVoList(list);
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3106 : by ETA<br>
	 * POD ETA 날짜를 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPODEta(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt3106Event event = (EesDmt3106Event)e;
		
		try {
			List<ManualChargeCreationVO> list = command.searchPODEta(event.getManualChargeCreationVOs());
			eventResponse.setRsVoList(list);
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3106 : Get VD MVMT<br>
	 * Container별 VD Movement Date를 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVDMovementByPodEta(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt3106Event event = (EesDmt3106Event)e;
		
		try {
			List<VDMovementVO> list = command.searchVDMovementByPodEta(event.getVdMovementVOs());
			eventResponse.setRsVoList(list);
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3106 : Save<br>
	 * Batch로 생성되지 않은 Batch를 미리 Manual로 Charge를 생성한다.<br>
	 * Charge를 생성할 Container의 "DMIF" Charge가 생성되지 않아야하고, From Date는 POD ETA, From Yard는 POD 정보로 설정한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createManualCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt3106Event event = (EesDmt3106Event)e;
		
		try {
			ChargeArgumentVO chargeArgumentVO = event.getChargeArgumentVO();
			if (chargeArgumentVO != null) {

				DmtResultVO resultVO = (DmtResultVO)BackEndJobResult.loadFromFile(chargeArgumentVO.getBackendjobKey());
				if (resultVO != null) {
					
					if (resultVO.getResultCode() == null) {
						//EDI 로 전송할 데이터 객체를 생성합니다.
						//2012.01.02  김현화 [CHM-201113641-01]E-DO Free Time관련 기능 추가(KT-NET)
						List<EDIVO> eDIVOs			= new ArrayList<EDIVO>();
						List<EDIVO> ftEndDtEDIVOs	= new ArrayList<EDIVO>(); 
						
						ChargeCalculationContainerVO[] chargeCalculationContainerVOs = resultVO.getChargeCalculationContainerVOArray();
						List<ChargeCalculationContainerVO> chgCalcContainerVOS = new ArrayList<ChargeCalculationContainerVO>();
						
						for (int i=0; i < chargeCalculationContainerVOs.length; i++) {
							chgCalcContainerVOS.add(chargeCalculationContainerVOs[i]);
						}
						
						if (chgCalcContainerVOS != null && chgCalcContainerVOS.size() > 0) {
							for (int i = 0; i < chgCalcContainerVOS.size(); i++) {
		
								String ydCd = chgCalcContainerVOS.get(i).getFmMvmtYdCd();
								if (ydCd == null || ydCd.length() != 7) continue;
								
								String locCd = ydCd.substring(0, 5);
								//2012.05.11 KRGIN 추가
								if ("KOR".equals(chgCalcContainerVOS.get(i).getSvrId()) 
										&& ("KRPUS".equals(locCd) ||
											"KRKAN".equals(locCd) ||
											"KRINC".equals(locCd) ||
											"KRPYT".equals(locCd) ||
											"KRUSN".equals(locCd) ||
											"KRGIN".equals(locCd) ||
											"KRPTK".equals(locCd)) ) {
									EDIVO eDIVO = new EDIVO();
									eDIVO.setBkgNo(			chgCalcContainerVOS.get(i).getBkgNo()		);
									eDIVO.setSysAreaGrpId(	chgCalcContainerVOS.get(i).getSvrId()		);
									eDIVO.setCntrNo(		chgCalcContainerVOS.get(i).getCntrNo()		);
									eDIVO.setCntrCycNo(		chgCalcContainerVOS.get(i).getCntrCycNo()	);
									eDIVO.setAcount(		account										);
									eDIVOs.add(eDIVO);
		
									String trfCd = chgCalcContainerVOS.get(i).getDmdtTrfCd();
									String dulTpExptFlg = chgCalcContainerVOS.get(i).getDulTpExptFlg();
									if (dulTpExptFlg == null) {
										dulTpExptFlg = "N";
									}
									// Chg_seq가 1일 경우만 전송하도록 함.2012.01.12 김현화
									// EDO는 DMIF, CTIC 만  전송되도록 함. 2012.01.26  김현화
									//log.debug("createManualCharge=======SC==== chg_seq===="+ chgCalcContainerVOS.get(i).getChgSeq());
									if ( "1".equals(chgCalcContainerVOS.get(i).getChgSeq())
											&& ( ("DMIF".equals(trfCd) && "N".equals(dulTpExptFlg))
											   ||("CTIC".equals(trfCd) && "Y".equals(dulTpExptFlg)))
										) {
										EDIVO ftEndDtEDIVO = new EDIVO();
									    ftEndDtEDIVO.setBkgNo(   chgCalcContainerVOS.get(i).getBkgNo()   );
								     	ftEndDtEDIVO.setFtEndDt( chgCalcContainerVOS.get(i).getFtEndDt() );
								   	    ftEndDtEDIVO.setCntrNo(	 chgCalcContainerVOS.get(i).getCntrNo()	 );
									    ftEndDtEDIVO.setAcount(	 account);
								 		ftEndDtEDIVOs.add(ftEndDtEDIVO);
									}
								}
							}
						}
						
						if (eDIVOs != null && eDIVOs.size() > 0) {
							//공통모듈을 통해서 EDI 전송을 수행한다.
							//log.debug("sendToEDI===========================");
							command.sendToEDI(eDIVOs);
						}
						
						if (ftEndDtEDIVOs != null && ftEndDtEDIVOs.size() > 0) {
							//EDO charge Free time End date 변경된 경우   EDI 전송을 수행한다. 2011.11.07
							//log.debug("sendEDOChargeFreeTime===========================");
							command.sendEDOChargeFreeTime(ftEndDtEDIVOs);
						}
					} 
					else {
						if (resultVO.getResultMsg() != null) {
							eventResponse.setUserMessage(resultVO.getResultMsg());
						}
						else {
							eventResponse.setUserMessage(new ErrorHandler(resultVO.getResultCode()).getUserMessage());
						}
					}
				}
			}
		} 
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_3107 : Open
	 * 해당 Container Charge에 적용된 Basic 및 Exception Tariff와 Clock Stop 등의 계산 내역을 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt3107Event event = (EesDmt3107Event)e;
		
		try {
			ChargeCalculationDetailVO chgCalcDtlVO = command.searchChargeDetail(event.getChargeArgumentVO());
			if (chgCalcDtlVO != null) {
				
				ChargeDetailVO chgDtlVO = chgCalcDtlVO.getChargeDetailVO();
				if (chgDtlVO != null) {
					eventResponse.setETCData("bzc_trf_curr_cd", chgDtlVO.getBzcTrfCurrCd());
					eventResponse.setETCData("org_chg_amt", 	chgDtlVO.getOrgChgAmt());
					eventResponse.setETCData("cmdt_expt_amt", 	chgDtlVO.getCmdtExptAmt());
					eventResponse.setETCData("sc_rfa_expt_amt", chgDtlVO.getScRfaExptAmt());
					eventResponse.setETCData("aft_expt_dc_amt", chgDtlVO.getAftExptDcAmt());
					eventResponse.setETCData("bil_amt", 		chgDtlVO.getBilAmt());
				}
				
				eventResponse.setRsVoList(chgCalcDtlVO.getClockStopVOs());
				eventResponse.setRsVoList(chgCalcDtlVO.getChargeBasicFreeTimeVOs());
				eventResponse.setRsVoList(chgCalcDtlVO.getCommodityGroupTariffVOs());
				
				if (chgCalcDtlVO.getBeforeExceptionTariffVOs() != null) {
					eventResponse.setRsVoList(chgCalcDtlVO.getBeforeExceptionTariffVOs());
				}
				else {
					eventResponse.setRsVoList(chgCalcDtlVO.getScExceptionTariffVOs());
				}
				eventResponse.setRsVoList(chgCalcDtlVO.getAfterExceptionTariffVOs());
				eventResponse.setRsVoList(chgCalcDtlVO.getExceptionCostVOs());
			}
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_4016-1 : Retrieve<br>
	 * SZPBB Office로 생성된 Container Charge List조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeBySZPBB(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt4016Event event = (EesDmt4016Event)e;

		try {
			List<ChargeCalculationContainerVO> list = command.searchChargeBySZPBB(event.getChargeByOfficeOrVVDVO());
			eventResponse.setRsVoList(list);
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_4016_1 : Get To MVMT<br>
	 * SZPBB Office로 발생한 Charge 관련한 Movement Data를 조회한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMovementBySZPBB(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt4016Event event = (EesDmt4016Event)e;
		
		try {
			List<MovementSZPBBVO> list = command.searchMovementBySZPBB(event.getMovementSZPBBParmVOS());
			eventResponse.setRsVoList(list);
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_4016-1 : Calculate<br>
	 * SZPBB Office의 "DMOF', "DMIF" Charge를 생성한다.<br>
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
			if (chargeArgumentVO != null) {
				
				DmtResultVO resultVO = (DmtResultVO)BackEndJobResult.loadFromFile(chargeArgumentVO.getBackendjobKey());
				if (resultVO != null) {
					
					if (resultVO.getResultCode() != null) {
						if (resultVO.getResultMsg() != null) {
							eventResponse.setUserMessage(resultVO.getResultMsg());
						}
						else {
							eventResponse.setUserMessage(new ErrorHandler(resultVO.getResultCode()).getUserMessage());
						}
					} 
					else {
						eventResponse.setRsVoList(resultVO.getChargeCalculationContainerVOs());
					}
				}
			}
		} 
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2009 : Calculate<br>
	 * APPROVAL, COUNTER OFFER, REJECT 처리후 메일을 전송 합니다.<br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @return void
	 * @exception EventException
	 */	
	private void sendEmail(AfterProgressVO afterProgressVO) throws EventException {
		
		boolean		isSending		= false;
		
		try {
			if (afterProgressVO != null) {
				//승인처리 후 메일송부 ##########################################################################
				FaxEmailBC 					mailBC 		= new FaxEmailBCImpl();
				GRWEmailNoticeVO 			emailVO 	= new GRWEmailNoticeVO();
				ChargeAmountDiscountMgtBC 	command 	= new ChargeAmountDiscountMgtBCImpl();
				
				String 				receivers		= mailBC.searchAfterBookingUserEmailByDARNo(afterProgressVO.getAftExptDarNo());
				String				subject_text 	= command.searchAfterBookingSubject(afterProgressVO.getAftExptDarNo());

				String[]            subjectText         = subject_text.split("\\|");
				
//				StringBuffer		subject			= new StringBuffer();				
				//제목설정
//				subject.append("[DEM/DET] DAR No. ");
//				subject.append(afterProgressVO.getAftExptDarNo());
//				subject.append(" - ");
//				subject.append(afterProgressVO.getDmdtExptRqstStsDesc());
		
				emailVO.setSender(		account.getUsr_eml()					);
				emailVO.setRecipient(	receivers								);
				emailVO.setSubject(		subjectText[0]							);
				
				//HTML Template 의 파라미터와 매핑되어져 나타날 데이터들 설정
				emailVO.setDarNo(		afterProgressVO.getAftExptDarNo()		);
	
				emailVO.setApvlNo(		afterProgressVO.getAftBkgAproNo()		);
	 			if (afterProgressVO.getAftBkgAproNo() != null 
	 					&& afterProgressVO.getAftBkgAproNo().length() > 0) {
	 				//Approval No. 를 주어진 형식의 Content 로 보여주도록 처리한다.
	 				StringBuffer sbApvlCntn = new StringBuffer();
	 				sbApvlCntn.append("(Approval No.: ");
	 				sbApvlCntn.append(afterProgressVO.getAftBkgAproNo());
	 				sbApvlCntn.append(")");
	 				
	 				emailVO.setApvlNo(	sbApvlCntn.toString()					);
	 			}
	 			else {
	 				emailVO.setApvlNo(		""									);	
	 			}
	 			
				emailVO.setStatus(		afterProgressVO.getDmdtExptRqstStsDesc());
				emailVO.setScNo(		afterProgressVO.getScNo()				);
				emailVO.setRfaNo(		afterProgressVO.getRfaNo()				);
				emailVO.setBlNo(		afterProgressVO.getBlNo()				);
				emailVO.setCustCd(		afterProgressVO.getCustCd()				);
				emailVO.setCustNm(		afterProgressVO.getCustNm()				);
				emailVO.setComments(	afterProgressVO.getProgRmk()			);			

				emailVO.setTextcontent(	subjectText[1]							);
						
				//HTML Template 파일명 설정
				emailVO.setHtmltemplate("EES_DMT_0001_02T.html"					);
	
				isSending = true;
				
				//메일 송신
				begin();
				mailBC.sendGRWEmail(emailVO);
				commit();
				//############################################################################################	
			}
		} 
		catch(EventException e) {
			rollback();
			if (!isSending) {
				throw e;
			}
		} 
		catch(Exception ex) {
			rollback();
			if (!isSending) {
				throw new EventException(ex.getMessage(), ex);
			}
		}
	}
	
	/**
	 * EES_DMT_2009 : btn_approval<br>
	 * Long Tx 실행<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse doBackEndJobApproval(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 			= new GeneralEventResponse();
		ChargeAmountDiscountMgtBC		command					= new ChargeAmountDiscountMgtBCImpl();
		AfterProgressVO 				afterProgressVO 		= new AfterProgressVO();
		AfterBKGRequestVO[] 			afterBKGRequestVOS 		= new AfterBKGRequestVO[1];
		AfterBKGCNTRRequestVO[] 		afterBKGCNTRRequestVOS 	= new AfterBKGCNTRRequestVO[1];

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
		else if (e instanceof EesDmt2018Event) {
			afterProgressVO 		= ((EesDmt2018Event)e).getAfterProgressVO();
			afterBKGRequestVOS 		= ((EesDmt2018Event)e).getAfterBKGRequestVOS();
			afterBKGCNTRRequestVOS 	= ((EesDmt2018Event)e).getAfterBKGCNTRRequestVOS();
		}			
		
		try {
			if (afterProgressVO != null) {
				//Set Parameters -----------------------------------------------------------------------
				afterProgressVO.setCreUsrId(account.getUsr_id());
				afterProgressVO.setCreOfcCd(account.getOfc_cd());
				afterProgressVO.setUpdUsrId(account.getUsr_id());
				afterProgressVO.setUpdOfcCd(account.getOfc_cd());
				afterProgressVO.setRhqOfcCd(account.getRhq_ofc_cd());
				
				AfterBKGGRPVO afterBKGGRPVO = new AfterBKGGRPVO();
				afterBKGGRPVO.setAfterProgressVO(			afterProgressVO				);
				afterBKGGRPVO.setAfterBKGRequestVOS(		afterBKGRequestVOS			);
				afterBKGGRPVO.setAfterBKGCNTRRequestVOS(	afterBKGCNTRRequestVOS		);	
				//-------------------------------------------------------------------------------------
				
				//BackEndJob 모듈을 호출한다.
				eventResponse.setETCData("BackEndJobKey", command.doBackEndJobApproval(afterBKGGRPVO, account));
			}
		} 
		catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2009 : btn_approval<br>
	 * Long Tx 결과 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse checkBackEndJobApproval(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		ChargeAmountDiscountMgtBC		command				= new ChargeAmountDiscountMgtBCImpl();
		AfterProgressVO 				afterProgressVO 	= new AfterProgressVO();
		
		if (e instanceof EesDmt2008Event) {
			afterProgressVO = ((EesDmt2008Event)e).getAfterProgressVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			afterProgressVO = ((EesDmt2009Event)e).getAfterProgressVO();
		}
		
		try {
			if (afterProgressVO != null) {
				//BackEndJob 모듈의 현재 작업상태를 조회한다.
				String[] result = command.checkBackEndJobApproval(afterProgressVO.getJobKey());
				//eventResponse.setETCData("jb_sts_flg", command.checkBackEndJobApproval(afterProgressVO.getJobKey()));
				
				if (result != null && result.length > 1) {
					eventResponse.setETCData("jb_sts_flg",		result[0]);
					eventResponse.setETCData("jb_usr_err_msg",	result[1]);
				}
			}
		} 
		catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2009 : btn_approval<br>
	 * Long Tx 결과 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse completeBackEndJobApproval(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		ChargeAmountDiscountMgtBC		command				= new ChargeAmountDiscountMgtBCImpl();		
		AfterProgressVO 				afterProgressVO 	= new AfterProgressVO();
		
		if (e instanceof EesDmt2008Event) {
			afterProgressVO = ((EesDmt2008Event)e).getAfterProgressVO();
		} 
		else if (e instanceof EesDmt2009Event) {
			afterProgressVO = ((EesDmt2009Event)e).getAfterProgressVO();
		}
		
		try {
			if (afterProgressVO != null) {
				BackEndJobResultVO backEndJobResultVO = command.completeBackEndJobApproval(afterProgressVO.getJobKey());
	
				//2006 번 화면에서 팝업으로 띄울 경우 Counter Offer 한 DATE 정보를 보여주기 위해서 조회함. 
				if ("Y".equals(afterProgressVO.getPopupFlag())) {
					eventResponse.setETCData("upd_dt", command.searchUpdateDate(afterProgressVO));
				}
				
				if (backEndJobResultVO != null) {
					//1>BackEndJob 이 완료되면 EDI 전송 후 메일을 전송합니다.
					//1-1>EDI 로 데이터를 전송합니다. >--------------------------------------------------------------------------------------------
					sendToEDI(backEndJobResultVO.getChargeCalculationContainerVOs());
					//-----------------------------------------------------------------------------------------------------------------------------
					
					//1-2>Email 전송을 수행합니다. >-----------------------------------------------------------------------------------------------
					sendEmail(backEndJobResultVO.getAfterProgressVO());
					//-----------------------------------------------------------------------------------------------------------------------------
					
					//1-3> Cancel 된 Invoice 가 존재할 경우, Invoice 생성자에게 Email 전송을 수행합니다. >-----------------------------------------
					// Before Booking, S/C 에서 Invoice 취소 메일전송 기능이 완료되면 함께 반영할 예정임.
		//			List<Properties> listEmail = setEmailInfoforCancelInvoice(backEndJobResultVO.getCancelInvoiceNoList());
		//			if (listEmail != null) {
		//				sendEmailforCancelInvoice(listEmail);
		//			}
					//-----------------------------------------------------------------------------------------------------------------------------
				}
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
	 * EES_DMT_2009 : btn_approval<br>
	 * EDI 로 전송 합니다.<br>
	 *
	 * @param List<ChargeCalculationContainerVO> chargeCalculationContainerVOs
	 * @throws EventException 
	 * @exception EventException
	 */
	public void sendToEDI(List<ChargeCalculationContainerVO> chargeCalculationContainerVOs) throws EventException {
		ChargeCalculationBCImpl	command		= new ChargeCalculationBCImpl();	//EDI 호출을 위한 BC 객체를 생성합니다.

		List<EDIVO> eDIVOs			= new ArrayList<EDIVO>();
		List<EDIVO> ftEndDtEDIVOs	= new ArrayList<EDIVO>();
		boolean		isSending		= false;
		
		try {
			if (chargeCalculationContainerVOs != null && chargeCalculationContainerVOs.size() > 0) {
				for (int i = 0 ; i < chargeCalculationContainerVOs.size() ; i++) {

					String ydCd = chargeCalculationContainerVOs.get(i).getFmMvmtYdCd();
					if (ydCd == null || ydCd.length() != 7) continue;
					
					String locCd = ydCd.substring(0, 5);
					//2012.05.11 KRGIN 추가
					if ("KOR".equals(chargeCalculationContainerVOs.get(i).getSvrId()) 
							&& ("KRPUS".equals(locCd) ||
								"KRKAN".equals(locCd) ||
								"KRINC".equals(locCd) ||
								"KRPYT".equals(locCd) ||
								"KRUSN".equals(locCd) ||
								"KRGIN".equals(locCd) ||
								"KRPTK".equals(locCd)) ) {
						EDIVO eDIVO = new EDIVO();
						eDIVO.setBkgNo(			chargeCalculationContainerVOs.get(i).getBkgNo()		);
						eDIVO.setSysAreaGrpId(	chargeCalculationContainerVOs.get(i).getSvrId()		);
						eDIVO.setCntrNo(		chargeCalculationContainerVOs.get(i).getCntrNo()	);
						eDIVO.setCntrCycNo(		chargeCalculationContainerVOs.get(i).getCntrCycNo()	);
						eDIVO.setEdiIssUsrId(	account.getUsr_id()									);
						eDIVO.setCreUsrId(		account.getUsr_id()									);
						eDIVO.setCreOfcCd(		account.getOfc_cd()									);
						eDIVOs.add(eDIVO);
					// Chg_seq가 1일 경우만 전송하도록 함.2012.01.12 김현화
						//log.debug("sendToEDI=======SC==== chg_seq===="+ chargeCalculationContainerVOs.get(i).getChgSeq());
					// EDO는 DMIF, CTIC 만  전송되도록 함. 2012.01.26  김현화	
						String trfCd = chargeCalculationContainerVOs.get(i).getDmdtTrfCd();
						String dulTpExptFlg = chargeCalculationContainerVOs.get(i).getDulTpExptFlg();
						if (dulTpExptFlg == null) {
							dulTpExptFlg = "N";
						}
						if ("1".equals(chargeCalculationContainerVOs.get(i).getChgSeq())
								&& ( ("DMIF".equals(trfCd) && "N".equals(dulTpExptFlg))
								   ||("CTIC".equals(trfCd) && "Y".equals(dulTpExptFlg)))	
							) {
							EDIVO ftEndDtEDIVO = new EDIVO();
							ftEndDtEDIVO.setBkgNo(   chargeCalculationContainerVOs.get(i).getBkgNo() );
							ftEndDtEDIVO.setFtEndDt( chargeCalculationContainerVOs.get(i).getFtEndDt() );
							ftEndDtEDIVO.setCntrNo(	 chargeCalculationContainerVOs.get(i).getCntrNo()	 );
							ftEndDtEDIVO.setAcount(	 account);
							ftEndDtEDIVOs.add(ftEndDtEDIVO);
						}
					}
				}
			}			
			if (eDIVOs != null && eDIVOs.size() > 0) {
				isSending = true;
				command.sendToEDI(eDIVOs);
			}
			
			if (ftEndDtEDIVOs != null && ftEndDtEDIVOs.size() > 0) {
				//EDO charge Free time End date 변경된 경우   EDI 전송을 수행한다.2011.11.07
				command.sendEDOChargeFreeTime(ftEndDtEDIVOs);
			}
		}
		catch(Exception e) {
			if (!isSending) {
				throw new EventException("BKG00099");
			}
		}
	}

	/**
	 * EES_DMT_3104 : Save
	 * 해당 Charge를 Deletion 대상으로 추가함.
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse requestChargeDeletion(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt3104Event event = (EesDmt3104Event)e;

		RFAExceptionTariffMgtBC 	commandrqst 		= new RFAExceptionTariffMgtBCImpl();
		String rqstNo = "";
		try {
			begin();
			
			if ( "".equals(event.getChargeInactivDetailVOS()[0].getInactRqstNo())){
				rqstNo = commandrqst.searchNewDAR("D", account.getUsr_id(), account.getOfc_cd());
			} else {
				rqstNo = event.getChargeInactivDetailVOS()[0].getInactRqstNo();
			}
			
			String result = command.requestChargeDeletion(event.getChargeInactivDetailVOS(), event.getChargeInactivFileVOS(), account, rqstNo);

			if (!"".equals(result)) {
				if (!"DMT01081".equals(result)) {
					eventResponse.setUserMessage(result);
				}
				else {
					eventResponse.setUserMessage(new ErrorHandler(result).getUserMessage());
				}
				rollback();
			}
			else {				
				eventResponse.setETCData("RQST_NO", rqstNo.toString());
				commit();
			}
		}
		catch(EventException ex) {
			rollback();
			throw ex;
//			throw new EventException(ex.getMessage(), ex);
		}
		catch(Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
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
		CommonFinderBC command2 = new CommonFinderBCImpl();
		
		try {
			//String ofcCd = account.getOfc_cd();
			String rhq = account.getRhq_ofc_cd();
			String usrId = account.getUsr_id();
			
			String usrOfc = command2.searchUserOfcCd(usrId);
			
		//	List<OfficeNameVO> list = command.searchDMTOfficeByApprovalOffice(ofcCd, rhq);
			List<OfficeNameVO> list = command.searchDMTOfficeByApprovalOffice(usrOfc, rhq);
				
			if (list != null && list.size() > 0) {
				StringBuffer ofc_cds = new StringBuffer();
				StringBuffer ofc_nms = new StringBuffer();
				
				for (int i = 0; i < list.size(); i++) {
					OfficeNameVO vo = (OfficeNameVO)list.get(i);
					ofc_cds.append(vo.getOfcCd()).append("|");
					ofc_nms.append(vo.getOfcEngNm()).append("|");
				}
				
				if (ofc_cds.length() > 1) ofc_cds.deleteCharAt(ofc_cds.length()-1);
				if (ofc_nms.length() > 1) ofc_nms.deleteCharAt(ofc_nms.length()-1);
				
				eventResponse.setETCData("OFC_CD", ofc_cds.toString());
				eventResponse.setETCData("OFC_NM", ofc_nms.toString());
			}      
		} 
		catch(EventException ex) {
			throw ex;
		} 
		catch(Exception ex) {
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
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt3014Event event = (EesDmt3014Event)e;
		
		ChargeDeletionRequstVO chargeDeletionRequstVO = event.getChargeDeletionRequstVO();

		try {
			if (chargeDeletionRequstVO != null) {
				chargeDeletionRequstVO.setChgDeltUsrId(account.getUsr_id());

				List<ChargeCalculationContainerVO> list = command.searchChargeDeletionRequest(chargeDeletionRequstVO);
				eventResponse.setRsVoList(list);
			}
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3014 : Approval for Charge Deletion
	 * Charge Deletion 의 승인진행단계 상태코드를 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeDeletionProcessStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC 	  	 commonCommand = new CommonFinderBCImpl();
		
		try {
			CommonCodeVO paramCodeVO  = new CommonCodeVO();
			paramCodeVO.setIntgCdId("CD03382");
			List<CommonCodeVO> commonCodeVOList = commonCommand.searchCommonCode(paramCodeVO);
			
			StringBuilder sbCodes = new StringBuilder();
			sbCodes.append("All=").append("All");
			if (commonCodeVOList != null && commonCodeVOList.size() > 0) {
				for (CommonCodeVO codeVO : commonCodeVOList) {
					if (sbCodes.length() > 0) sbCodes.append("|");
					sbCodes.append(codeVO.getIntgCdValCtnt()).append("=").append(codeVO.getIntgCdValDpDesc());
				}
			}
			eventResponse.setETCData("chg_delt_proc_sts", sbCodes.toString());
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3014 : Approval for Charge Deletion (화면 로드시점에 호출)
	 * 로그인 사용자가 승인권한을 갖는 승인단계를 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeDeletionPath(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
 		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		
		try {
			String chgDeltPathCd = command.searchChargeDeletionPath(account.getUsr_id(), account.getOfc_cd());
			eventResponse.setETCData("CHG_DELT_PATH_CD", chgDeltPathCd);
		}
		catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
//	/**
//	 * EES_DMT_3014 : Reject
//	 * 대상 DMT Office List를 조회함.
//	 * 
//	 * @param Event e 
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse rejectChargeDeletion(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EesDmt3014Event event = (EesDmt3014Event)e;
//		ChargeCalculationBC command = new ChargeCalculationBCImpl();
//		try{
//				begin();
//				command.rejectChargeDeletion(event.getChargeCalculationContainerVOS(), account);
//				eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
//				commit();
//			}catch(EventException ex){
//				rollback();
//				throw ex;
//			}catch(Exception ex){
//				rollback();
//				throw new EventException(ex.getMessage(), ex);
//			}
//			return eventResponse;	
//	}
	
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
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt3002Event event = (EesDmt3002Event)e;
		
		try {
			ChargeArgumentVO chargeArgumentVO = event.getChargeArgumentVO();
			if (chargeArgumentVO != null) {
			
				DmtResultVO resultVO = (DmtResultVO)BackEndJobResult.loadFromFile(chargeArgumentVO.getBackendjobKey());
				if (resultVO != null) {
					if (resultVO.getResultCode() == null) {
		
						//EDI 로 전송할 데이터 객체를 생성합니다.
						List<EDIVO> eDIVOs			= new ArrayList<EDIVO>();
						List<EDIVO> ftEndDtEDIVOs	= new ArrayList<EDIVO>();
			
						ChargeCalculationContainerVO[] chargeCalculationContainerVOs = resultVO.getChargeCalculationContainerVOArray();
						List<ChargeCalculationContainerVO> chgCalcContainerVOS = new ArrayList<ChargeCalculationContainerVO>();
						
						for (int i=0; i < chargeCalculationContainerVOs.length; i++) {
							chgCalcContainerVOS.add(chargeCalculationContainerVOs[i]);
						}
						
						if (chgCalcContainerVOS != null && chgCalcContainerVOS.size() > 0) {
							for (int i = 0; i < chgCalcContainerVOS.size(); i++) {
							
								String ydCd = chgCalcContainerVOS.get(i).getFmMvmtYdCd();
								if (ydCd == null || ydCd.length() != 7) continue;
								
								String locCd = ydCd.substring(0, 5);
								//2012.05.11 KRGIN 추가
								if ("KOR".equals(chgCalcContainerVOS.get(i).getSvrId()) 
										&& ("KRPUS".equals(locCd) ||
											"KRKAN".equals(locCd) ||
											"KRINC".equals(locCd) ||
											"KRPYT".equals(locCd) ||
											"KRUSN".equals(locCd) ||
											"KRGIN".equals(locCd) ||
											"KRPTK".equals(locCd)) ) {
									EDIVO eDIVO = new EDIVO();
									eDIVO.setBkgNo(			chgCalcContainerVOS.get(i).getBkgNo()		);
									eDIVO.setSysAreaGrpId(	chgCalcContainerVOS.get(i).getSvrId()		);
									eDIVO.setCntrNo(		chgCalcContainerVOS.get(i).getCntrNo()		);
									eDIVO.setCntrCycNo(		chgCalcContainerVOS.get(i).getCntrCycNo()	);
									eDIVO.setAcount(		account										);
									eDIVOs.add(eDIVO);
									
									//2011.11.07 김현화 [CHM-201113641-01]E-DO Free Time관련 기능 추가(KT-NET)
									// Chg_seq가 1일 경우만 전송하도록 함.2012.01.12 김현화
									//log.debug("modifyChargeByBooking=======SC==== chg_seq===="+ chgCalcContainerVOS.get(i).getChgSeq());
									// EDO는 DMIF, CTIC 만  전송되도록 함. 2012.01.26  김현화	
									String trfCd = chgCalcContainerVOS.get(i).getDmdtTrfCd();
									String dulTpExptFlg = chgCalcContainerVOS.get(i).getDulTpExptFlg();
									if (dulTpExptFlg == null) {
										dulTpExptFlg = "N";
									}
									//log.debug("modifyChargeByBooking trfCd===="+trfCd+"====");
									//log.debug("modifyChargeByBooking dulTpExptFlg===="+dulTpExptFlg+"====");
									//log.debug("modifyChargeByBooking getChgSeq===="+chgCalcContainerVOS.get(i).getChgSeq()+"====");
				
									if ("1".equals(chgCalcContainerVOS.get(i).getChgSeq())
											&& ( ("DMIF".equals(trfCd) && "N".equals(dulTpExptFlg))
											   ||("CTIC".equals(trfCd) && "Y".equals(dulTpExptFlg)))
									   ) {
										EDIVO ftEndDtEDIVO = new EDIVO();
									   ftEndDtEDIVO.setBkgNo(   chgCalcContainerVOS.get(i).getBkgNo() );
									   ftEndDtEDIVO.setFtEndDt( chgCalcContainerVOS.get(i).getFtEndDt() );
									   ftEndDtEDIVO.setCntrNo(	 chgCalcContainerVOS.get(i).getCntrNo()	 );
									   ftEndDtEDIVO.setAcount(	 account);
									   ftEndDtEDIVOs.add(ftEndDtEDIVO);
									}
								}
							}
						 }
						
						if (eDIVOs != null && eDIVOs.size() > 0) {
							//공통모듈을 통해서 EDI 전송을 수행한다.
							command.sendToEDI(eDIVOs);
						}
						if (ftEndDtEDIVOs != null && ftEndDtEDIVOs.size() > 0) {
							//EDO charge Free time End date 변경된 경우   EDI 전송을 수행한다. 2011.11.07
							//log.debug("sendEDOChargeFreeTime====start====");
		 				    command.sendEDOChargeFreeTime(ftEndDtEDIVOs);
						}
						 //log.debug("sendEDOChargeFreeTime====end====");
					} 
					else {
						if (resultVO.getResultMsg() != null) {
							eventResponse.setUserMessage(resultVO.getResultMsg());
						}
						else {
							eventResponse.setUserMessage(new ErrorHandler(resultVO.getResultCode()).getUserMessage());
						}
					}
				}
			}
		}
		catch(EventException ex) {
			//rollback();
			throw ex;
		}
		catch(Exception ex) {
			//rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * EES_DMT_3015: OP-MT Detention Inquiry <br>
	 * OP-MT Detention Container Charge List 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOPMTChargeListbyInquiry(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt3015Event event = (EesDmt3015Event)e;
		ChargeCalculationBC command = new ChargeCalculationBCImpl();

		try{
			List<ChargeCalculationContainerVO> list = command.searchOPMTChargeListbyInquiry(event.getOPMTChargeParmVO());
			eventResponse.setRsVoList(list); 

			UserRoleVO paramRoleVO = new UserRoleVO();
			paramRoleVO.setUsrId(account.getUsr_id());
			paramRoleVO.setPgmNo("EES_DMT_3015");
			paramRoleVO.setUsrRoleCd("DMT01,DMT02,DMT03,DMT04");
			
			//로그인 User의  해당 페이지(EES_DMT_3002) Access 권한 정보를 조회한다.
			CommonFinderBC command2 = new CommonFinderBCImpl();
			UserRoleVO roleVO = command2.hasRoleAuth(paramRoleVO);
			
			if (roleVO != null) {
				eventResponse.setETCData("ROLE_PERMIT",	roleVO.getIsAuthorized());
				eventResponse.setETCData("ROLE_AUTH",	roleVO.getUsrRoleCd());
			}
		}
		catch(EventException ex) {
			throw ex;
		} 
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * EES_DMT_3016 : OP-MT Detention Calculation <br>
	 * OP-MT Detention Container Charge List 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOPMTChargeListbyCalculation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt3016Event event = (EesDmt3016Event)e;

		try {
			List<ChargeCalculationContainerVO> list = command.searchOPMTChargeListbyCalculation(event.getOPMTChargeParmVO());
			eventResponse.setRsVoList(list);
			
			//log.debug("ROLE_PERMIT=account.getUsr_id()==="+account.getUsr_id());
			UserRoleVO paramRoleVO = new UserRoleVO();
			paramRoleVO.setUsrId(account.getUsr_id());
			paramRoleVO.setPgmNo("EES_DMT_3015");
			paramRoleVO.setUsrRoleCd("DMT01,DMT02,DMT03,DMT04");
			
			//로그인 User의  해당 페이지(EES_DMT_3002) Access 권한 정보를 조회한다.
			CommonFinderBC command2 = new CommonFinderBCImpl();
			UserRoleVO roleVO = command2.hasRoleAuth(paramRoleVO);
			
			if (roleVO != null) {
	            //log.debug("ROLE_PERMIT===="+roleVO.getIsAuthorized());
				eventResponse.setETCData("ROLE_PERMIT",	roleVO.getIsAuthorized());
				eventResponse.setETCData("ROLE_AUTH",	roleVO.getUsrRoleCd());
			}
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * EES_DMT_3014 : Approval for Charge Deletion<br>
	 * [Charge Deletion 요청에 대해 Approval, Reject 처리시 하위 Office 결재자들에게 Notice] 를 [Email Send] 합니다.<br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	private void sendChgDeltNoticeGWMail(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account) {
		
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		List<ChargeCalculationContainerVO> chargeCalculationContainerVOList = new ArrayList<ChargeCalculationContainerVO>();
		
		// 1. 승인처리 후 메일송부 ############################################################################
		FaxEmailBC mailBC = new FaxEmailBCImpl();
		GRWEmailChgDeltNoticeVO emailVO = new GRWEmailChgDeltNoticeVO();
		
		String subject = "Approval for Charge Deletion - E-mail Notification";
		
		if (chargeCalculationContainerVOs != null && chargeCalculationContainerVOs.length > 0) {
			for (ChargeCalculationContainerVO chgCalcCntrNo : chargeCalculationContainerVOs) {
	
				if ("Y".equals(chgCalcCntrNo.getEmlSndYn())) {
					
					String chgDeltStsCd  =   "A".equals(chgCalcCntrNo.getChgDeltStsCd())  ? "approved" : "rejected";
					String chgDeltPathCd = "HDO".equals(chgCalcCntrNo.getChgDeltPathCd()) ? "HO"       : chgCalcCntrNo.getChgDeltPathCd();
					
					emailVO.setSender(			account.getUsr_eml()				);
					emailVO.setRecipient(		chgCalcCntrNo.getEmlRcvrAddr()		);
					emailVO.setSubject(			subject								);
					emailVO.setHtmltemplate(	"EES_DMT_3014_01T.html"				);					
					emailVO.setBkgNo(			chgCalcCntrNo.getBkgNo()			);
					emailVO.setCntrNo(			chgCalcCntrNo.getCntrNo()			);
					emailVO.setDmdtTrfCd(		chgCalcCntrNo.getDmdtTrfCd()		);
					emailVO.setChgDeltStsCd(	chgDeltStsCd						);
					emailVO.setChgDeltPathCd(	chgDeltPathCd						);
					emailVO.setChgDeltUsrOfcCd(	account.getOfc_cd()					);
					
					try {
						//메일 송신
						begin();
						chgCalcCntrNo.setEmlSndNo(mailBC.sendChgDeltNoticeGWMail(emailVO));
						log.debug("\n>>>>[sendChgDeltNoticeGWMail] STEP-3.1.1 :: Send Email(CNTR_NO : " + chgCalcCntrNo.getCntrNo() + ", CNTR_CYC_NO : " + chgCalcCntrNo.getCntrCycNo() + ", EML_SND_NO : " + chgCalcCntrNo.getEmlSndNo() + ")");
						commit();
						
						chargeCalculationContainerVOList.add(chgCalcCntrNo);
					}
					catch(EventException ex) {
						rollback();
						log.error(ex.getMessage());
					}					
					catch(Exception ex) {
						rollback();
						log.error(ex.getMessage());
					}
				}
			}
		}
		//############################################################################################	

		// 2. 메일송부 후 메일송부번호 업데이트 ######################################################
		if (chargeCalculationContainerVOList.size() > 0) {
			try {
				begin();
				// Notice 메일전송번호를 갱신한다.
				command.modifyChargeDeletionEmlSndNo(chargeCalculationContainerVOList, account);
				commit();
			}
			catch(EventException ex) {
				rollback();
				log.error(ex.getMessage());
			}
			catch(Exception ex) {
				rollback();
				log.error(ex.getMessage());
			}
		}
		//############################################################################################		
	}	
	
	/**
	 * EES_DMT_3014 : Approval for Charge Deletion<br>
	 * [Charge Deletion 삭제 후 상태복원] 될 경우 [EDI Send] 합니다.<br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	private void sendToEDIforChgDelt(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account) {
		
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		
		List<EDIVO> 	eDIVOs	= new ArrayList<EDIVO>();
		
		for (ChargeCalculationContainerVO chgCalcCntrNo : chargeCalculationContainerVOs) {
			if ("Y".equals(chgCalcCntrNo.getSndToEdiYn())) {
				EDIVO eDIVO = new EDIVO();
				eDIVO.setBkgNo(			chgCalcCntrNo.getBkgNo()		);
				eDIVO.setSysAreaGrpId(	chgCalcCntrNo.getSvrId()		);
				eDIVO.setCntrNo(		chgCalcCntrNo.getCntrNo()		);
				eDIVO.setCntrCycNo(		chgCalcCntrNo.getCntrCycNo()	);
				eDIVO.setAcount(		account							);
				eDIVOs.add(eDIVO);
			}
		}
		
		if (eDIVOs.size() > 0) {
			log.debug("\n>>>>[sendToEDIforChgDelt] STEP-2.1.1 :: CHARGE DELETION 요청에 대한 EDI 전송 실행 (전송 건수 : " + eDIVOs.size() + ")");
			//공통모듈을 통해서 EDI 전송을 수행한다.
			try {
				command.sendToEDI(eDIVOs);
			}
			catch(EventException ex) {
				log.error(ex.getMessage());
			}
			catch(Exception ex) {
				log.error(ex.getMessage());
			}
			log.debug("\n>>>>[sendToEDIforChgDelt] STEP-2.1.2 :: CHARGE DELETION 요청에 대한 EDI 전송 종료");
		}	
		else {
			log.debug("\n>>>>[sendToEDIforChgDelt] STEP-2.1.1 :: CHARGE DELETION 요청에 대한 EDI 전송 미실행 (전송 건수 : 0)");
		}
	}
	
	/**
	 * EES_DMT_3002, EES_DMT_3003, EES_DMT_3004 :  <br>
	 * Charge Deletion 요청을 취소한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelChargeDeletionRequest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();

		try{
			ChargeCalculationContainerVO[] chargeCalculationContainerVOs = new ChargeCalculationContainerVO[1];

			if (e instanceof EesDmt3001Event) {
				chargeCalculationContainerVOs = ((EesDmt3001Event)e).getChargeCalculationContainerVOS();
			} 			
			else if (e instanceof EesDmt3002Event) {
				chargeCalculationContainerVOs = ((EesDmt3002Event)e).getChargeCalculationContainerVOS();
			} 
			else if (e instanceof EesDmt3003Event) {
				chargeCalculationContainerVOs = new ChargeCalculationContainerVO[1];
				chargeCalculationContainerVOs[0] = ((EesDmt3003Event)e).getChargeCalculationContainerVO();
			} 
			else if (e instanceof EesDmt3004Event) {
				chargeCalculationContainerVOs = ((EesDmt3004Event)e).getChargeCalculationContainerVOS();
			}
			else if (e instanceof EesDmt3104Event) {
				chargeCalculationContainerVOs = ((EesDmt3104Event)e).getChargeCalculationContainerVOS();
			}
			
			begin();
			command.cancelChargeDeletionRequest(chargeCalculationContainerVOs, account);
			commit();
			
//			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
		}
		catch(EventException ex){
			rollback();
			throw ex;
		}
		catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3104 : Open
	 * 화면 Open 시점에 Charge Deletion Specific Reason 코드목록을 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDeleteMultiReasonList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		
		try {
			List<SearchDeleteMultiReasonListVO> list = command.searchDeleteMultiReasonList();
			eventResponse.setRsVoList(list);
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_3104 : Click
	 * Charge Deletion Specific Reason 코드를 선택할 때마다, 코드별로 입력해야될 1 ~ 6 단계의 상세내역을 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDeleteMultiDetailReasonList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt3104Event event = (EesDmt3104Event)e;
		
		try {
			List<SearchDeleteMultiDetailReasonListVO> list = command.searchDeleteMultiDetailReasonList(event.getSearchDeleteMultiReasonListVO());
			
			if (list != null && list.size() > 0) {
				for (SearchDeleteMultiDetailReasonListVO vo : list) {
					String prefix = "detail_" + vo.getSpecRsnFieldLevel() + "_";
				       
					eventResponse.setETCData(prefix + "rsn_field_name",   vo.getSpecRsnFieldName());
					eventResponse.setETCData(prefix + "rsn_field_type",   vo.getSpecRsnFieldType());
					eventResponse.setETCData(prefix + "rsn_field_size",   vo.getSpecRsnFieldSize());
					eventResponse.setETCData(prefix + "rsn_field_format", vo.getSpecRsnFieldFormat());
					eventResponse.setETCData(prefix + "rsn_field_item",   vo.getSpecRsnFieldItem());
					eventResponse.setETCData(prefix + "rsn_field_cond",   vo.getSpecRsnFieldCond());
					eventResponse.setETCData(prefix + "rsn_field_popup",  vo.getSpecRsnFieldPopup());
					eventResponse.setETCData(prefix + "rsn_field_value",  vo.getSpecRsnFieldValue());										
				}
			}
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * EES_DMT_3104 : Open
	 * Charge Deletion 요청시 입력한 Specific Reason 별 Remark 상세내역을 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDeletionSpecificReasonRemarkList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt3104Event event = (EesDmt3104Event)e;
		
		try {
			event.getChargeCalculationContainerVO().setUsrId(account.getUsr_id());			
			List<ChargeDeltSpecRsnRmkVO> list = command.searchDeletionSpecificReasonRemarkList(event.getChargeCalculationContainerVO());			
			eventResponse.setRsVoList(list);
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	

	/**
	 * EES_DMT_3104 : Open
	 * Inactive History 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInactiveHistoryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt3104Event event = (EesDmt3104Event)e;
		
		try {
			List<ChargeInactivHisListVO> list = command.searchInactiveHistoryList(event.getChargeCalculationContainerVO());
			eventResponse.setRsVoList(list);
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	

	/**
	 * EES_DMT_3104 : Open
	 * Inactive History 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt3104Event event = (EesDmt3104Event)e;
		
		try {
			String rtnValue = command.searchCharge(event.getChargeInactivDetailVO());

			eventResponse.setETCData("rtnValue",   rtnValue);
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	


	/**
	 * EES_DMT_3017 : Inactive Reason 조회
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInactiveReason(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt3017Event event = (EesDmt3017Event)e;
		
		InactiveReasonVO inactiveReasonVO = event.getInactiveReasonVO();

		try {
			List<InactiveReasonVO> list = command.searchInactiveReason(inactiveReasonVO);
			
			if (list != null && list.size() > 0) {			
				StringBuffer sbRsnCd = new StringBuffer();
				sbRsnCd.append("All=All");
				for (InactiveReasonVO rsnCdVO : list) {
					if (sbRsnCd.length() > 0) sbRsnCd.append("|");
					sbRsnCd.append(rsnCdVO.getRsnCd()).append("=").append(rsnCdVO.getRsnNm());
				}
				
				eventResponse.setETCData("RSN_CD", sbRsnCd.toString());
			}
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_DMT_3017 : search Inactive List 조회
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInactiveList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt3017Event event = (EesDmt3017Event)e;
		
		InactiveInputVO inactiveInputVO = event.getInactiveInputVO();

		try {
			List<InactiveListVO> list = command.searchInactiveList(inactiveInputVO, account);
			eventResponse.setRsVoList(list);
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_DMT_3104 : Booking Info, INV Validation
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBookingInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		EesDmt3104Event event = (EesDmt3104Event)e;
		
		SearchInactiveCheckVO searchInactiveCheckVO = event.getSearchInactiveCheckVO();

		try {
			String bookingInfo = command.searchBookingInfo(searchInactiveCheckVO);
			
			String[] arrBkgInfo         = bookingInfo.split("\\|");
			
			eventResponse.setETCData("VVD_CD", arrBkgInfo[0].toString());
			eventResponse.setETCData("RD_TERM_CD", arrBkgInfo[1].toString());
			
			eventResponse.setETCData("DMDT_INV_FLG", arrBkgInfo[2].toString());
			eventResponse.setETCData("INV_CURR_CD", arrBkgInfo[3].toString());			
			eventResponse.setETCData("INV_CHG_AMT", arrBkgInfo[4].toString());			
			eventResponse.setETCData("INV_PAY_CD", arrBkgInfo[5].toString());
			eventResponse.setETCData("INV_PAY_NM", arrBkgInfo[6].toString());

			eventResponse.setETCData("OTS_STS_NM", arrBkgInfo[7].toString());
			eventResponse.setETCData("OTS_CURR_CD", arrBkgInfo[8].toString());
			eventResponse.setETCData("OTS_INV_AMT", arrBkgInfo[9].toString());			

			eventResponse.setETCData("SOC_FLG", arrBkgInfo[10].toString());

			eventResponse.setETCData("AR_CHG_CD", arrBkgInfo[11].toString());
			eventResponse.setETCData("AR_CURR_CD", arrBkgInfo[12].toString());
			eventResponse.setETCData("AR_CHG_AMT", arrBkgInfo[13].toString());			

			eventResponse.setETCData("VVD_FLG", arrBkgInfo[14].toString());
			eventResponse.setETCData("CURR_CD", arrBkgInfo[15].toString());

			eventResponse.setETCData("MTY_PKUP_YD_CD", arrBkgInfo[16].toString());
			eventResponse.setETCData("SVC_SCP_CD", arrBkgInfo[17].toString());
			
			eventResponse.setETCData("CHG_CD", arrBkgInfo[18].toString());
			eventResponse.setETCData("CHG_AMT", arrBkgInfo[19].toString());
			

			eventResponse.setETCData("CTRT_NO", arrBkgInfo[20].toString());
			eventResponse.setETCData("CTRT_CUST_CD", arrBkgInfo[21].toString());
			eventResponse.setETCData("CTRT_CUST_NM", arrBkgInfo[22].toString());
			
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * DMTCalculationTypeMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActualCostList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt2017Event event = (EesDmt2017Event)e;
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		AfterBookingFileListVO afterBookingFileListVO = null;
		
		try {
						
			List<ActualCostListVO> list = command.searchActualCostList(event.getInputVO());
			eventResponse.setRsVoList(list);

			afterBookingFileListVO = new AfterBookingFileListVO();
			afterBookingFileListVO.setAftExptDarNo(event.getInputVO().getDarNo());
			
			afterBookingFileListVO.setAftBkgFileDivCd("CSRL01");
			List<AfterBookingFileListVO> list1 = command.searchAfterBookingFileList(afterBookingFileListVO);
			eventResponse.setRsVoList(list1);

			afterBookingFileListVO.setAftBkgFileDivCd("OAIN01");
			List<AfterBookingFileListVO> list2 = command.searchAfterBookingFileList(afterBookingFileListVO);
			eventResponse.setRsVoList(list2);

			// CSR #2100 [DMT] DAR after BKG Detail 화면 변경 요청 ( Cargo Invoice 입력 란 통합 )========================
			afterBookingFileListVO.setAftBkgFileDivCd("CIOD01");
			List<AfterBookingFileListVO> list3 = command.searchAfterBookingFileList(afterBookingFileListVO);
			//eventResponse.setRsVoList(list3);
			
			afterBookingFileListVO.setAftBkgFileDivCd("CINW01");
			List<AfterBookingFileListVO> list4 = command.searchAfterBookingFileList(afterBookingFileListVO);
			list3.addAll(list4);
			eventResponse.setRsVoList(list3);
			//============================================================================================================

			afterBookingFileListVO.setAftBkgFileDivCd("CSSP01");
			List<AfterBookingFileListVO> list5 = command.searchAfterBookingFileList(afterBookingFileListVO);
			eventResponse.setRsVoList(list5);
			
			List<AfterBookingExptClrRqstVO> list6 = command.searchAfterBookingExptClrRqst(event.getAfterBKGListVOs());
			eventResponse.setRsVoList(list6);
			
			event.getInputVO().setStsDesc("Reason");
			List<ActualCostListVO> list7 = command.searchActualCostList(event.getInputVO());
			for (int i = 0 ; i < list7.size() ; i++) {
				if ( "Reason of D/C Request".equals(list7.get(i).getAftBkgActCostItmNm())){
					eventResponse.setETCData("RSN_DC_RQST", list7.get(i).getAftBkgActCostRmk());
				}
				if ( "Reason of Clearance Delay".equals(list7.get(i).getAftBkgActCostItmNm())){
					eventResponse.setETCData("RSN_CLE_DELAY", list7.get(i).getAftBkgActCostRmk());
				}
			}
			
			String ucCgoPsblFlg = command.searchUcCgoPsblFlg(event.getInputVO());

			if ( ucCgoPsblFlg != null && !"".equals(ucCgoPsblFlg) ){

				String[] ucCgoPsblFlgInfo         = ucCgoPsblFlg.split("\\|");

				eventResponse.setETCData("UC_CGO_PSBL_FLG", ucCgoPsblFlgInfo[0].toString());
				eventResponse.setETCData("GNTE_LTR_CD", ucCgoPsblFlgInfo[1].toString());
			}
			
			afterBookingFileListVO.setAftBkgFileDivCd("LETT01");
			List<AfterBookingFileListVO> list8 = command.searchAfterBookingFileList(afterBookingFileListVO);
			eventResponse.setRsVoList(list8);
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	

	/**
	 * 조회 이벤트 처리<br>
	 * DMTCalculationTypeMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAfterBookingFullHistory(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt2017Event event = (EesDmt2017Event)e;
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		try {
						
			List<AfterBookingFullHistoryVO> list = command.searchAfterBookingFullHistory(event.getInputVO());
			eventResponse.setRsVoList(list);
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * DMTCalculationTypeMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAfterBookingReasonDesc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt2017Event event = (EesDmt2017Event)e;
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		AfterBookingFileListVO afterBookingFileListVO = null;
		AfterBKGListInputVO afterBKGListInputVO = null;
		
		try {
						
			List<AfterBookingReasonDescVO> list = command.searchAfterBookingReasonDesc();
			eventResponse.setRsVoList(list);

			afterBookingFileListVO = new AfterBookingFileListVO();
			
			afterBookingFileListVO.setAftExptDarNo(event.getInputVO().getDarNo());			
			afterBookingFileListVO.setAftBkgFileDivCd("All");
			List<AfterBookingFileListVO> list1 = command.searchAfterBookingFileList(afterBookingFileListVO);
			eventResponse.setRsVoList(list1);
			
			List<AfterBookingReasonDetailVO> list2 = command.searchAfterBookingReasonDetail(event.getInputVO());
			eventResponse.setRsVoList(list2);
			
			afterBKGListInputVO = new AfterBKGListInputVO();
			afterBKGListInputVO = event.getInputVO();
			afterBKGListInputVO.setStsCd("A");
			List<AfterBookingReasonDetailVO> list3 = command.searchAfterBookingReasonDetail(event.getInputVO());
			
			if ( list3 != null && list3.size() > 0 ){
				eventResponse.setETCData("SPEC_RSN_CD", list3.get(0).getAftBkgFileDivCd());
			}
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2017 : Click
	 * After Booking Specific Reason 코드를 선택할 때마다, 코드별로 입력해야될 1 ~ 6 단계의 상세내역을 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAfterBookingDetailReasonList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		EesDmt2017Event event = (EesDmt2017Event)e;
		
		try {
			List<AfterBookingDetailReasonListVO> list = command.searchAfterBookingDetailReasonList(event.getAfterBookingReasonDescVO());
			
			if (list != null && list.size() > 0) {
				for (AfterBookingDetailReasonListVO vo : list) {
					String prefix = "detail_" + vo.getSpecRsnFieldLevel() + "_";
				       
					eventResponse.setETCData(prefix + "rsn_field_name",   vo.getSpecRsnFieldName());
					eventResponse.setETCData(prefix + "rsn_field_type",   vo.getSpecRsnFieldType());
					eventResponse.setETCData(prefix + "rsn_field_size",   vo.getSpecRsnFieldSize());
					eventResponse.setETCData(prefix + "rsn_field_format", vo.getSpecRsnFieldFormat());
					eventResponse.setETCData(prefix + "rsn_field_item",   vo.getSpecRsnFieldItem());
					eventResponse.setETCData(prefix + "rsn_field_cond",   vo.getSpecRsnFieldCond());
					eventResponse.setETCData(prefix + "rsn_field_popup",  vo.getSpecRsnFieldPopup());
					eventResponse.setETCData(prefix + "rsn_field_value",  vo.getSpecRsnFieldValue());
				}
			}
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	


	/**
	 * 조회 이벤트 처리<br>
	 * DMTCalculationTypeMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAfterBookingPfmcList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt2017Event event = (EesDmt2017Event)e;
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		try {

			List<AfterBookingPfmcListVO> list = command.searchAfterBookingPfmcList(event.getAfterBookingPfmcListVO());
			eventResponse.setRsVoList(list);
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * DMTCalculationTypeMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAfterBookingMasList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt2017Event event = (EesDmt2017Event)e;
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		try {

			List<AfterBookingMasListVO> list = command.searchAfterBookingMasList(event.getAfterBookingMasListVO());
			eventResponse.setRsVoList(list);
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * DMTCalculationTypeMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAfterBookingVvdCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt2017Event event = (EesDmt2017Event)e;
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		try {

			String vvd_flg = command.searchAfterBookingVvdCd(event.getVvdCd());
			eventResponse.setETCData("VVD_FLG", vvd_flg);
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	

	/**
	 * 조회 이벤트 처리<br>
	 * DMTCalculationTypeMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAfterBookingAproItm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt2017Event event = (EesDmt2017Event)e;
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		try {

			List<AfterBookingAproItmVO> list = command.searchAfterBookingAproItm(event.getInputVO());
			eventResponse.setRsVoList(list);
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	

	/**
	 * EES_DMT_2017 : Save<br>
	 * After Booking Detail Request 생성한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createAfterBookingRequestDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt2017Event event = (EesDmt2017Event)e;
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();

		ActualCostListVO[] 	actualCostListVOs 	= new ActualCostListVO[1];
		AfterBookingFullHistoryVO[] 	afterBookingFullHistoryVOs 	= new AfterBookingFullHistoryVO[1];
		AfterBookingReasonDetailVO[] afterBookingReasonDetailVOs = new AfterBookingReasonDetailVO[1];
		AfterBookingFileListVO[] afterBookingFileListVOs = new AfterBookingFileListVO[1];
		AfterBookingPfmcListVO[] afterBookingPfmcListVOs = new AfterBookingPfmcListVO[1];
		AfterBookingAproItmVO[] afterBookingAproItmVOs = new AfterBookingAproItmVO[1];
		AfterBookingMasListVO[] afterBookingMasListVOs = new AfterBookingMasListVO[1];
		
		AfterBookingExptClrRqstVO[] afterBookingExptClrRqstVOs = new AfterBookingExptClrRqstVO[1];
		
		actualCostListVOs = event.getActualCostListVOs();
		afterBookingFullHistoryVOs = event.getAfterBookingFullHistoryVOs();
		afterBookingReasonDetailVOs = event.getAfterBookingReasonDetailVOs();
		afterBookingFileListVOs = event.getAfterBookingFileListVOs();
		afterBookingExptClrRqstVOs = event.getAfterBookingExptClrRqstVOs();
		afterBookingPfmcListVOs = event.getAfterBookingPfmcListVOs();
		afterBookingAproItmVOs = event.getAfterBookingAproItmVOs();
		afterBookingMasListVOs = event.getAfterBookingMasListVOs();

		AfterBookingRequestDetailVO afterBookingRequestDetailVO = new AfterBookingRequestDetailVO();
		
		afterBookingRequestDetailVO.setActualCostListVOs(actualCostListVOs);
		afterBookingRequestDetailVO.setInputVO(event.getInputVO());
		afterBookingRequestDetailVO.setAfterBookingFullHistoryVOs(afterBookingFullHistoryVOs);
		afterBookingRequestDetailVO.setAfterBookingReasonDescVO(event.getAfterBookingReasonDescVO());
		afterBookingRequestDetailVO.setAfterBookingReasonDetailVOs(afterBookingReasonDetailVOs);
		afterBookingRequestDetailVO.setAfterBookingFileListVOs(afterBookingFileListVOs);
		afterBookingRequestDetailVO.setAfterBookingExptClrRqstVOs(afterBookingExptClrRqstVOs);

		afterBookingRequestDetailVO.setAfterBookingPfmcListVOs(afterBookingPfmcListVOs);
		afterBookingRequestDetailVO.setAfterBookingAproItmVOs(afterBookingAproItmVOs);		

		afterBookingRequestDetailVO.setAfterBookingMasListVOs(afterBookingMasListVOs);	

		afterBookingRequestDetailVO.setAfterProgressVO(event.getAfterProgressVO());
		
	try {
			if (afterBookingRequestDetailVO != null) {
				begin();
				command.createAfterBookingRequestDetail(afterBookingRequestDetailVO, account);
				commit();
			}
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	

	/**
	 * EES_DMT_2018 :  <br>
	 * DEM/DET Adjustment Request - After Booking Request 의 Balance Charge 가 있는 CNTR 인지 체크 이벤트 처리.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse requestAfterBookingTSave(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();

		AfterBKGListInputVO 		inputVO 			= new AfterBKGListInputVO();

		EesDmt2018Event event = (EesDmt2018Event)e;
		
		AfterProgressVO 			afterProgressVO 		= new AfterProgressVO();
		AfterBKGRequestVO[] 		afterBKGRequestVOS 		= new AfterBKGRequestVO[1];
		AfterBKGCNTRRequestVO[] 	afterBKGCNTRRequestVOS 	= new AfterBKGCNTRRequestVO[1];

		afterProgressVO 		= event.getAfterProgressVO();
		afterBKGRequestVOS 		= event.getAfterBKGRequestVOS();
		afterBKGCNTRRequestVOS 	= event.getAfterBKGCNTRRequestVOS();

		AfterBKGGRPVO afterBKGGRPVO = new AfterBKGGRPVO();
		afterBKGGRPVO.setAfterProgressVO(afterProgressVO);
		afterBKGGRPVO.setAfterBKGRequestVOS(afterBKGRequestVOS);
		afterBKGGRPVO.setAfterBKGCNTRRequestVOS(afterBKGCNTRRequestVOS);		

		inputVO = event.getAfterBKGListInputVO();
		
		try {
			if (afterProgressVO != null) {		

				if ( "R".equals(afterProgressVO.getDmdtExptRqstStsCd())){
					
					List<AfterBookingDetailFlgVO>      afterBKGDetailFlgVOs 	  = command.searchAfterBookingDetailFlg(inputVO);
					
					if( !"Y".equals(afterBKGDetailFlgVOs.get(0).getRsnDcFlg())){
						throw new EventException(new ErrorHandler("DMT01186", new String[]{"Reason of D/C Request"}).getMessage());
					}
					if( !"Y".equals(afterBKGDetailFlgVOs.get(0).getRsnCleFlg())){
						throw new EventException(new ErrorHandler("DMT01186", new String[]{"Reason of Clearance Delay"}).getMessage());
					}
					if( !"Y".equals(afterBKGDetailFlgVOs.get(0).getCustRqstFlg())){
						throw new EventException(new ErrorHandler("DMT01186", new String[]{"Customer's Request Letter"}).getMessage());
					}
					if( !"Y".equals(afterBKGDetailFlgVOs.get(0).getCgoInvNewFlg())){
						throw new EventException(new ErrorHandler("DMT01186", new String[]{"Cargo invoice NEW"}).getMessage());
					}
					if( !"Y".equals(afterBKGDetailFlgVOs.get(0).getCustSalPfmcFlg())){
						throw new EventException(new ErrorHandler("DMT01186", new String[]{"Customer's Sales Performance Load / CM / CMPB"}).getMessage());
					}
					if( !"Y".equals(afterBKGDetailFlgVOs.get(0).getDmtPfmcFlg())){
						throw new EventException(new ErrorHandler("DMT01186", new String[]{"DMT PFMC"}).getMessage());
					}
					if( !"Y".equals(afterBKGDetailFlgVOs.get(0).getFullHisFlg())){
						throw new EventException(new ErrorHandler("DMT01186", new String[]{"Full History"}).getMessage());
					}
					if( "".equals(afterBKGDetailFlgVOs.get(0).getRsnCd())){
						throw new EventException(new ErrorHandler("DMT01186", new String[]{"Additional Evidence Reason"}).getMessage());
					}
				} 
				
				begin();
				command.requestAfterBookingTSave(afterBKGGRPVO, account);
				commit();
				
				//2006 번 화면에서 팝업으로 띄울 경우 Counter Offer 한 DATE 정보를 보여주기 위해서 조회함. 
				if ("Y".equals(afterProgressVO.getPopupFlag())) {
					eventResponse.setETCData("upd_dt", command.searchUpdateDate(afterProgressVO));
				}
				if ( !"T".equals(afterProgressVO.getDmdtExptRqstStsCd()) ){
					sendEmail(afterProgressVO);
				}
			}
		}
		catch(EventException ex) {
			rollback();
			throw ex;
		}
		catch(Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	
	/**
	 * EES_DMT_2018 :  <br>
	 * DEM/DET Adjustment Request - After Booking Request 의 BKG/B/L No 의 Tariff Type 이 맞는지 체크 이벤트 처리.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCalcuationTypeTSave(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		AfterBKGListInputVO inputVO = new AfterBKGListInputVO();

		EesDmt2018Event event = (EesDmt2018Event)e;

		inputVO = event.getAfterBKGListInputVO();		
		
		try {
			if (inputVO != null) {

				boolean result = command.checkCalcuationType(inputVO);
				
				//S/C Exception 의 Calculation Type Check 로직을 수행한다.
				if (!result) {
					
					String cntCd 	= "";
					String rgnCd 	= "";
					String steCd 	= "";
					String ioBndCd  = "";
					String calcTpCd = "";
					
					if (inputVO.getTariff() != null && inputVO.getTariff().length() == 4) {
						ioBndCd  = inputVO.getTariff().substring(2, 3);
						calcTpCd = inputVO.getTariff().substring(0, 1);
					}					
					
					String locCd = command.searchLocationByBKGBLNo(inputVO);
					eventResponse.setETCData("LOC", locCd);
					
					//Location Code 로 Country, Regin, State 정보를 조회한다. =============================================
					CommonFinderBC cmmonCommand = new CommonFinderBCImpl();
					CoverageVO coverageVO = new CoverageVO();
					coverageVO.setLocCd(locCd);
					List<CoverageVO> coverageList = cmmonCommand.searchContinentHierarchyByLocation(coverageVO);
					
					if (coverageList != null && coverageList.size() > 0) {
						cntCd = coverageList.get(0).getCntCd();
						
						if (locCd != null && locCd.length() == 5) {
							if ("CA".equals(locCd.substring(0, 2)) || "US".equals(locCd.substring(0, 2))) {
								steCd = coverageList.get(0).getSteCd();	
							}
							else {
								rgnCd = coverageList.get(0).getRgnCd();	
							}
						}
					}
	
					//Calculation Type Check 로직을 수행한다. ===========================================================
					SCExceptionTariffMgtBC scCommand = new SCExceptionTariffMgtBCImpl();
					CalculationTypeParmVO calcParmVO = new CalculationTypeParmVO();
					calcParmVO.setIoBndCd(ioBndCd);
					calcParmVO.setDmdtCalcTpCd(calcTpCd);
					calcParmVO.setCntCd(cntCd);
					calcParmVO.setRgnCd(rgnCd);
					calcParmVO.setSteCd(steCd);
					calcParmVO.setLocCd(locCd);
					result = scCommand.checkCalcType(calcParmVO);
				
					if (!result) {
						//Calculation Type을 조회한다. ======================================================================
						eventResponse.setETCData("CHECK_CALC", "N");
						eventResponse.setETCData("CALC_TYPE",  command.searchCalcTypeCode(locCd, ioBndCd));
					}
					else {
						eventResponse.setETCData("CHECK_CALC", "Y");
						eventResponse.setETCData("CALC_TYPE",  "");
						eventResponse.setETCData("LOC",        "");
					}			
				}
				else {
					eventResponse.setETCData("CHECK_CALC", "Y");
					eventResponse.setETCData("CALC_TYPE",  "");
					eventResponse.setETCData("LOC",        "");
				}
			}
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2018 :  <br>
	 * DEM/DET Adjustment Request - After Booking Request 의 Comment History 리스트 조회 이벤트 처리.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBookingDataTSave(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();

		EesDmt2018Event event = (EesDmt2018Event)e;
		
		AfterBKGDetailInputVO inputVO = new AfterBKGDetailInputVO();

		inputVO = event.getAfterBKGDetailInputVO();		

		try {
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
				eventResponse.setETCData("TAA_NO", afterBKGDetailVOList.get(0).getTaaNo());
				eventResponse.setETCData("BKG_NO", afterBKGDetailVOList.get(0).getBkgNo());	
				eventResponse.setETCData("BL_NO", afterBKGDetailVOList.get(0).getBlNo());
				eventResponse.setETCData("CUST_CD", afterBKGDetailVOList.get(0).getCustCd());
				eventResponse.setETCData("CUST_NM", afterBKGDetailVOList.get(0).getCustNm());
				eventResponse.setETCData("AFT_BKG_CM_AMT", afterBKGDetailVOList.get(0).getAftBkgCmAmt());
				eventResponse.setETCData("GNTE_LTR_FLG", afterBKGDetailVOList.get(0).getGnteLtrFlg());
				eventResponse.setETCData("OFC_CD", afterBKGDetailVOList.get(0).getOfcCd());
				
			}
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2018 :  <br>
	 * DEM/DET Adjustment Request - After Booking Request 의 Tariff Type 과 BKG 또는 B/L No. 가 중복되는지 체크 이벤트 처리.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDupTariffBKGBLNoTSave(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		AfterBKGListInputVO inputVO = new AfterBKGListInputVO();
		EesDmt2018Event event = (EesDmt2018Event)e;

		inputVO = event.getAfterBKGListInputVO();
		
		try {
			String darNo = command.checkDupTariffBKGBLNo(inputVO);
			eventResponse.setETCData("DAR_NO", darNo != null ? darNo : "");
		}
		catch(EventException ex) {
			throw ex;
		} 
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	
	/**
	 * EES_DMT_2008 :  <br>
	 * DEM/DET Adjustment Request - After Booking Request 의 Container 별 지불요금 정보를 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerChargeByBookingTSave(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		ChargeAmountDiscountMgtBC 		chgCommand 			= new ChargeAmountDiscountMgtBCImpl();
		CommonFinderBC 					cmnCommand 			= new CommonFinderBCImpl();

		CoverageVO						coverageVO			= new CoverageVO();
		List<CurrencyVO> 				currencyVOS 		= new ArrayList<CurrencyVO>();
		
		ChargeBookingContainerParmVO 	paramVO 			= new ChargeBookingContainerParmVO();
		List<ChargeBookingContainerVO> 	containerListVO		= new ArrayList<ChargeBookingContainerVO>();
		
		StringBuffer 					sbCurrencyCodes 	= new StringBuffer();
		StringBuffer 					sbCurrencyNames 	= new StringBuffer();
		Map<String, String> 			mapCurrencyCodes	= new HashMap<String, String>();
		Map<String, String> 			mapCurrencyNames	= new HashMap<String, String>();

		EesDmt2018Event event = (EesDmt2018Event)e;

		paramVO = event.getChargeBookingContainerParmVO();

		try {
			//Billable Amout per CNTR 조회
			containerListVO = chgCommand.searchContainerChargeByBooking(paramVO);
			
			//Currency 정보를 보여주기 위한 처리부분(시작) ########################################################################
			if (containerListVO != null && containerListVO.size() > 0) {
				for (int i = 0 ; i < containerListVO.size() ; i++) {
					
					//Currency 정보를 구하기 위한 Country 정보를 구한다.
					String tariff = containerListVO.get(i).getDmdtTrfCd();
					String cntCd  = "";
					
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

								//국가별 Currency 를 구한다. ============================================================
								coverageVO.setCntCd(cntCd);
								
								currencyVOS = cmnCommand.searchCurrencyList(coverageVO);
								if (currencyVOS != null && currencyVOS.size() > 0) {
									
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
									
									sbCurrencyCodes.setLength(0);
									sbCurrencyNames.setLength(0);
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
				eventResponse.setRsVoList(containerListVO);
			}
			//Currency 정보를 보여주기 위한 처리부분(끝) ########################################################################
			
			String exchangeRate = chgCommand.searchExchangeRate(paramVO);
			
			if ( exchangeRate != null && !"".equals(exchangeRate) ){	

				String[] exchangeRateInfo         = exchangeRate.split("\\|");
				
				if ( exchangeRateInfo[1].toString() != null && !"".equals(exchangeRateInfo[1].toString())){
					eventResponse.setETCData("EX_CD", exchangeRateInfo[0].toString());
					eventResponse.setETCData("EX_RATE", exchangeRateInfo[1].toString());
				}
			}
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	

	
	/**
	 * EES_DMT_2008 :  <br>
	 * DEM/DET Adjustment Request - After Booking Request 의 목록을 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAfterBookingListTSave(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		ChargeAmountDiscountMgtBC 	chgCommand 			= new ChargeAmountDiscountMgtBCImpl();
		CommonFinderBC 				cmnCommand 			= new CommonFinderBCImpl();
		
		AfterBKGListInputVO 		inputVO 			= new AfterBKGListInputVO();

		EesDmt2018Event event = (EesDmt2018Event)e;

		inputVO = event.getAfterBKGListInputVO();
		
		
		try {
			List<AfterBKGListInputVO> afterBKGListInputVO = chgCommand.searchAfterBookingDAR(inputVO);
			List<AfterBKGListVO>      afterBKGListVO 	  = chgCommand.searchAfterBookingList(inputVO);
			
			// Currency 정보를 보여주기 위한 처리부분(시작) ########################################################################
			if (afterBKGListVO != null && afterBKGListVO.size() > 0) {
				CoverageVO	coverageVO = new CoverageVO();
				
				for (int i = 0 ; i < afterBKGListVO.size() ; i++) {
					
					//Currency 정보를 구하기 위한 Country 정보를 구한다.
					String tariff = afterBKGListVO.get(i).getDmdtTrfCd();
					String cntCd  = "";
					
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
							Map<String, String> mapCurrencyCodes = new HashMap<String, String>();
							Map<String, String> mapCurrencyNames = new HashMap<String, String>();

							cntCd = cntCd.substring(0, 2);
							
							if (!mapCurrencyCodes.containsKey(cntCd)) {

								//국가별 Currency 를 구한다. ============================================================
								coverageVO.setCntCd(cntCd);
								
								List<CurrencyVO> currencyVOS = cmnCommand.searchCurrencyList(coverageVO);
								if (currencyVOS != null && currencyVOS.size() > 0) {
									
									StringBuffer sbCurrencyCodes = new StringBuffer();
									StringBuffer sbCurrencyNames = new StringBuffer();
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
									
									sbCurrencyCodes.setLength(0);
									sbCurrencyNames.setLength(0);
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
				eventResponse.setRsVoList(afterBKGListVO);
			}
			//Currency 정보를 보여주기 위한 처리부분(끝) ########################################################################
			
			inputVO.setCustCd(afterBKGListInputVO.get(0).getCustCd());
							
			if (afterBKGListInputVO != null && afterBKGListInputVO.size() > 0) {
				eventResponse.setETCData("DAR_NO", afterBKGListInputVO.get(0).getDarNo());
				eventResponse.setETCData("APVL_NO", afterBKGListInputVO.get(0).getApvlNo());
				eventResponse.setETCData("STS_DESC", afterBKGListInputVO.get(0).getStsDesc());
				eventResponse.setETCData("SC_NO", afterBKGListInputVO.get(0).getScNo());
				eventResponse.setETCData("RFA_NO", afterBKGListInputVO.get(0).getRfaNo());
				eventResponse.setETCData("TAA_NO", afterBKGListInputVO.get(0).getTaaNo());
				eventResponse.setETCData("CUST_CD", afterBKGListInputVO.get(0).getCustCd());
				eventResponse.setETCData("CUST_NM", afterBKGListInputVO.get(0).getCustNm());
				eventResponse.setETCData("DMDT_EXPT_RQST_RSN_CD", afterBKGListInputVO.get(0).getDmdtExptRqstRsnCd());
			}
			else {
				eventResponse.setETCData("DAR_NO", "");
				eventResponse.setETCData("APVL_NO", "");
				eventResponse.setETCData("STS_DESC", "");
				eventResponse.setETCData("SC_NO", "");
				eventResponse.setETCData("RFA_NO", "");
				eventResponse.setETCData("TAA_NO", "");
				eventResponse.setETCData("CUST_CD", "");
				eventResponse.setETCData("CUST_NM", "");
				eventResponse.setETCData("DMDT_EXPT_RQST_RSN_CD", "");	
			}
			
			String pathRoleCd = chgCommand.searchAfterBookingPathRole(inputVO);

			if ( pathRoleCd != null && !"".equals(pathRoleCd) ){

				String[] pathRoleCdInfo         = pathRoleCd.split("\\|");
				
				eventResponse.setETCData("APVL_PATH_CD", pathRoleCdInfo[0].toString());
				eventResponse.setETCData("APVL_ROLE_STS_CD", pathRoleCdInfo[1].toString());
				eventResponse.setETCData("APVL_OFC_CD", pathRoleCdInfo[2].toString());
				eventResponse.setETCData("APVL_END_FLG", pathRoleCdInfo[3].toString());		
				
				eventResponse.setETCData("END_PATH_CD", pathRoleCdInfo[4].toString());
				eventResponse.setETCData("END_ROLE_STS_CD", pathRoleCdInfo[5].toString());
				eventResponse.setETCData("END_OFC_CD", pathRoleCdInfo[6].toString());
			}
			
			List<AfterBookingDetailFlgVO>      afterBKGDetailFlgVOs 	  = chgCommand.searchAfterBookingDetailFlg(inputVO);
			
			if(afterBKGDetailFlgVOs != null && afterBKGDetailFlgVOs.size() > 0){
				eventResponse.setETCData("ACT_COST_FLG", 		afterBKGDetailFlgVOs.get(0).getActCostFlg());
				eventResponse.setETCData("RSN_DC_FLG", 			afterBKGDetailFlgVOs.get(0).getRsnDcFlg());
				eventResponse.setETCData("RSN_CLE_FLG", 		afterBKGDetailFlgVOs.get(0).getRsnCleFlg());
				eventResponse.setETCData("CUST_RQST_FLG", 		afterBKGDetailFlgVOs.get(0).getCustRqstFlg());
				eventResponse.setETCData("OTH_ATT_FLG", 		afterBKGDetailFlgVOs.get(0).getOthAttFlg());
				
				eventResponse.setETCData("CGO_INV_OLD_FLG", 	afterBKGDetailFlgVOs.get(0).getCgoInvOldFlg());
				eventResponse.setETCData("CGO_INV_NEW_FLG", 	afterBKGDetailFlgVOs.get(0).getCgoInvNewFlg());
				eventResponse.setETCData("HIGH_LOW_FLG", 		afterBKGDetailFlgVOs.get(0).getHighLowFlg());
				eventResponse.setETCData("EXP_CLE_FLG", 		afterBKGDetailFlgVOs.get(0).getExpCleFlg());
				eventResponse.setETCData("CUST_SAL_PFMC_FLG", 	afterBKGDetailFlgVOs.get(0).getCustSalPfmcFlg());				

				eventResponse.setETCData("RSN_CD", 				afterBKGDetailFlgVOs.get(0).getRsnCd());
				eventResponse.setETCData("ATT_FILE_FLG", 		afterBKGDetailFlgVOs.get(0).getAttFileFlg());
				eventResponse.setETCData("RSN_DTL_RMK_FLG", 	afterBKGDetailFlgVOs.get(0).getRsnDtlRmkFlg());				

				eventResponse.setETCData("DMT_PFMC_FLG", 		afterBKGDetailFlgVOs.get(0).getDmtPfmcFlg());
				eventResponse.setETCData("FULL_HIS_FLG", 		afterBKGDetailFlgVOs.get(0).getFullHisFlg());
				eventResponse.setETCData("RSN_DESC", 			afterBKGDetailFlgVOs.get(0).getRsnDesc());
				eventResponse.setETCData("GNTE_LTR_FLG", 		afterBKGDetailFlgVOs.get(0).getGnteLtrFlg());
			}
			else {

				eventResponse.setETCData("ACT_COST_FLG", 		"");
				eventResponse.setETCData("RSN_DC_FLG", 			"");
				eventResponse.setETCData("RSN_CLE_FLG", 		"");
				eventResponse.setETCData("CUST_RQST_FLG", 		"");
				eventResponse.setETCData("OTH_ATT_FLG", 		"");
				
				eventResponse.setETCData("CGO_INV_OLD_FLG", 	"");
				eventResponse.setETCData("CGO_INV_NEW_FLG", 	"");
				eventResponse.setETCData("EXP_CLE_FLG", 		"");
				eventResponse.setETCData("CUST_SAL_PFMC_FLG", 	"");
				eventResponse.setETCData("RSN_DESC", 			"");
				eventResponse.setETCData("GNTE_LTR_FLG", 		"");
			}
			
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * EES_DMT_2018 :  <br>
	 * DEM/DET Adjustment Request - After Booking Request 의 Comment History 리스트 조회 이벤트 처리.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommentHistoryTSave(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		AfterBKGListInputVO inputVO = new AfterBKGListInputVO();

		inputVO = ((EesDmt2018Event)e).getAfterBKGListInputVO();
		
		try {
			List<CommentHistoryVO> commentHistoryVOList = command.searchCommentHistory(inputVO);

			List<CommentHistoryVO> commentApprovalVOList = command.searchAproPath(inputVO);
			
			eventResponse.setRsVoList(commentHistoryVOList);
			eventResponse.setRsVoList(commentApprovalVOList);
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	

	/**
	 * EES_DMT_2008 :  <br>
	 * DEM/DET Adjustment Request - After Booking Request 의 Balance Charge 가 있는 CNTR 인지 체크 이벤트 처리.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkBalanceChargeTSave(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		AfterBKGListInputVO inputVO = new AfterBKGListInputVO();

		inputVO = ((EesDmt2018Event)e).getAfterBKGListInputVO();
		
		try {
			boolean result = command.checkBalanceCharge(inputVO);
			eventResponse.setETCData("CHECK_BALCHG", result ? "Y" : "N");
		}
		catch(EventException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * 등록된 After Booking DAR 를 Cancel 한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelAfterBookingDARTSave(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		AfterProgressVO afterProgressVO = new AfterProgressVO();

		afterProgressVO = ((EesDmt2018Event)e).getAfterProgressVO();
	
		try {
			if (afterProgressVO != null) {
				//Set Parameters 
				afterProgressVO.setCreUsrId(account.getUsr_id());
				afterProgressVO.setCreOfcCd(account.getOfc_cd());
				afterProgressVO.setUpdUsrId(account.getUsr_id());
				afterProgressVO.setUpdOfcCd(account.getOfc_cd());

				begin();
				command.cancelAfterBookingDAR(afterProgressVO);
				commit();
				
				if ("Y".equals(afterProgressVO.getPopupFlag())) {
					//2006 번 화면에서 팝업으로 띄울 경우 Counter Offer 한 DATE 정보를 보여주기 위해서 조회함. 
					eventResponse.setETCData("upd_dt", command.searchUpdateDate(afterProgressVO));
				}
			}
		}
		catch(EventException ex) {
			rollback();
			throw ex;
		}
		catch(Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2009 : btn_approval<br>
	 * Long Tx 실행<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse doBackEndJobApprovalTSave(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 			= new GeneralEventResponse();
		ChargeAmountDiscountMgtBC		command					= new ChargeAmountDiscountMgtBCImpl();
		AfterProgressVO 				afterProgressVO 		= new AfterProgressVO();
		AfterBKGRequestVO[] 			afterBKGRequestVOS 		= new AfterBKGRequestVO[1];
		AfterBKGCNTRRequestVO[] 		afterBKGCNTRRequestVOS 	= new AfterBKGCNTRRequestVO[1];

		afterProgressVO 		= ((EesDmt2018Event)e).getAfterProgressVO();
		afterBKGRequestVOS 		= ((EesDmt2018Event)e).getAfterBKGRequestVOS();
		afterBKGCNTRRequestVOS 	= ((EesDmt2018Event)e).getAfterBKGCNTRRequestVOS();
			
		try {
			if (afterProgressVO != null) {
				//Set Parameters -----------------------------------------------------------------------
				afterProgressVO.setCreUsrId(account.getUsr_id());
				afterProgressVO.setCreOfcCd(account.getOfc_cd());
				afterProgressVO.setUpdUsrId(account.getUsr_id());
				afterProgressVO.setUpdOfcCd(account.getOfc_cd());
				afterProgressVO.setRhqOfcCd(account.getRhq_ofc_cd());
				
				AfterBKGGRPVO afterBKGGRPVO = new AfterBKGGRPVO();
				afterBKGGRPVO.setAfterProgressVO(			afterProgressVO				);
				afterBKGGRPVO.setAfterBKGRequestVOS(		afterBKGRequestVOS			);
				afterBKGGRPVO.setAfterBKGCNTRRequestVOS(	afterBKGCNTRRequestVOS		);	
				//-------------------------------------------------------------------------------------
				
				//BackEndJob 모듈을 호출한다.
				eventResponse.setETCData("BackEndJobKey", command.doBackEndJobApproval(afterBKGGRPVO, account));
			}
		} 
		catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_DMT_2018 :  <br>
	 * DEM/DET Adjustment Request - After Booking Request 의 Balance Charge 가 있는 CNTR 인지 체크 이벤트 처리.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyAfterBookingStatusUpdate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();

		AfterBKGListInputVO 		inputVO 			= new AfterBKGListInputVO();

		EesDmt2018Event event = (EesDmt2018Event)e;
		
		inputVO = event.getAfterBKGListInputVO();
		
		try {
							
			List<AfterBookingDetailFlgVO>      afterBKGDetailFlgVOs 	  = command.searchAfterBookingDetailFlg(inputVO);
			
			if( !"Y".equals(afterBKGDetailFlgVOs.get(0).getRsnDcFlg())){
				throw new EventException(new ErrorHandler("DMT01186", new String[]{"Reason of D/C Request"}).getMessage());
			}
			if( !"Y".equals(afterBKGDetailFlgVOs.get(0).getRsnCleFlg())){
				throw new EventException(new ErrorHandler("DMT01186", new String[]{"Reason of Clearance Delay"}).getMessage());
			}
			if( !"Y".equals(afterBKGDetailFlgVOs.get(0).getCustRqstFlg())){
				throw new EventException(new ErrorHandler("DMT01186", new String[]{"Customer's Request Letter"}).getMessage());
			}
			if( !"Y".equals(afterBKGDetailFlgVOs.get(0).getCgoInvNewFlg())){
				throw new EventException(new ErrorHandler("DMT01186", new String[]{"Cargo invoice NEW"}).getMessage());
			}
			if( !"Y".equals(afterBKGDetailFlgVOs.get(0).getCustSalPfmcFlg())){
				throw new EventException(new ErrorHandler("DMT01186", new String[]{"Customer's Sales Performance Load / CM / CMPB"}).getMessage());
			}
			if( !"Y".equals(afterBKGDetailFlgVOs.get(0).getDmtPfmcFlg())){
				throw new EventException(new ErrorHandler("DMT01186", new String[]{"DMT PFMC"}).getMessage());
			}
			if( !"Y".equals(afterBKGDetailFlgVOs.get(0).getFullHisFlg())){
				throw new EventException(new ErrorHandler("DMT01186", new String[]{"Full History"}).getMessage());
			}
			if( "".equals(afterBKGDetailFlgVOs.get(0).getRsnCd())){
				throw new EventException(new ErrorHandler("DMT01186", new String[]{"Additional Evidence Reason"}).getMessage());
			}
			
			begin();
			command.modifyAfterBookingStatusUpdate(event.getAfterProgressVO(), account);
			commit();
			
			//2006 번 화면에서 팝업으로 띄울 경우 Counter Offer 한 DATE 정보를 보여주기 위해서 조회함. 
			if ("Y".equals(event.getAfterProgressVO().getPopupFlag())) {
				eventResponse.setETCData("upd_dt", command.searchUpdateDate(event.getAfterProgressVO()));
			}
			
			sendEmail(event.getAfterProgressVO());
		}
		catch(EventException ex) {
			rollback();
			throw ex;
		}
		catch(Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2018 :  <br>
	 * DEM/DET Adjustment Request - After Booking Request 의 Tariff Type 과 BKG 또는 B/L No. 가 중복되는지 체크 이벤트 처리.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAfterBookingRsnVal(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		ChargeBookingContainerVO chargeBookingContainerVO = new ChargeBookingContainerVO();
		EesDmt2017Event event = (EesDmt2017Event)e;

		chargeBookingContainerVO = event.getChargeBookingContainerVO();
		
		try {
			String rsnVal = command.searchAfterBookingRsnVal(chargeBookingContainerVO);
			
			String[] arrRsnVal         = rsnVal.split("\\|");
			
			eventResponse.setETCData("UCLM_FLG", arrRsnVal[0].toString());
			eventResponse.setETCData("TTL_INV_NO", arrRsnVal[1].toString());
			eventResponse.setETCData("BKG_STS_CD", arrRsnVal[2].toString());
		}
		catch(EventException ex) {
			throw ex;
		} 
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * DMTCalculationTypeMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAfterBookingReasonUcTtl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt2017Event event = (EesDmt2017Event)e;
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		try {
			List<AfterBookingReasonDetailVO> list = command.searchAfterBookingReasonUcTtl(event.getInputVO());
			eventResponse.setRsVoList(list);
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * DMTCalculationTypeMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAfterBookingrRequestApprovalStatusList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt2021Event event = (EesDmt2021Event)e;
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		try {
			List<AfterBkgRqstAproStsVO> list = command.searchAfterBookingrRequestApprovalStatusList(event.getAfterBkgRqstAproStsParamVO(), account);
			eventResponse.setRsVoList(list);
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * DMTCalculationTypeMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAfterBookingrAllStatusCodeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC 	  	 commonCommand = new CommonFinderBCImpl();
		
		try {
			CommonCodeVO paramCodeVO  = new CommonCodeVO();
			paramCodeVO.setIntgCdId("CD01971");
			List<CommonCodeVO> commonCodeVOList = commonCommand.searchCommonCode(paramCodeVO);
			
			StringBuilder sbCodes = new StringBuilder();
			sbCodes.append("All=").append("All");
			if (commonCodeVOList != null && commonCodeVOList.size() > 0) {
				// After Status 코드 목록에서 화면에 표시하지 않을 코드들
				String[] invalidCodes = {"T", "C", "D", "L", "B", "P", "Q"};
				for (CommonCodeVO codeVO : commonCodeVOList) {
					boolean flag = true;
					for(String code : invalidCodes) {
						if(codeVO.getIntgCdValCtnt().equals(code)) {
							flag = false;
							break;
						}
					}
					if (flag) {
						if (sbCodes.length() > 0) sbCodes.append("|");					
						sbCodes.append(codeVO.getIntgCdValCtnt()).append("=").append(codeVO.getIntgCdValDpDesc());	
					}
				}
			}
			eventResponse.setETCData("aft_bkg_proc_sts", sbCodes.toString());
		}
		catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * File Upload 처리
	 * @param event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse fileUpload(Event e) throws EventException {
		EesDmt2017Event event = (EesDmt2017Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			eventResponse.setETCData("fileSaveId", event.getAfterBookingFileListVO().getFileSavId());
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	// 2016.08.04 Wonki Eo Edit
	/**
	 * Inactive File Upload 처리
	 * @param event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse inactiveFileUpload(Event e) throws EventException {
		EesDmt3104Event event = (EesDmt3104Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			
			eventResponse.setETCData("fileSaveId", event.getChargeInactivFileVO().getFileSavId());
			
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
//	/**
//	 * 등록된 After Booking DAR 를 OFC Appoved 한다.<br>
//	 * 
//	 * @param e Event
//	 * @return response EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse approveOfcAfterBookingDAR(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		AfterProgressVO afterProgressVO = null;
//		if (e instanceof EesDmt2008Event) {
//			afterProgressVO = ((EesDmt2008Event)e).getAfterProgressVO();
//		} 
//		else if (e instanceof EesDmt2009Event) {
//			afterProgressVO = ((EesDmt2009Event)e).getAfterProgressVO();
//		}		
//		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
//
//		//Set Parameters 
//		afterProgressVO.setCreUsrId(account.getUsr_id());
//		afterProgressVO.setCreOfcCd(account.getOfc_cd());
//		afterProgressVO.setUpdUsrId(account.getUsr_id());
//		afterProgressVO.setUpdOfcCd(account.getOfc_cd());
//		
//		try {
//			begin();
//			command.approveOfcAfterBookingDAR(afterProgressVO);
//			commit();
//			
//			//2006 번 화면에서 팝업으로 띄울 경우 Counter Offer 한 DATE 정보를 보여주기 위해서 조회함. 
//			if ("Y".equals(afterProgressVO.getPopupFlag()))
//				eventResponse.setETCData("upd_dt", command.searchUpdateDate(afterProgressVO));			
//			
//			//REJECT 처리 후 메일송부 ######################################################################
//			afterProgressVO.setAftBkgAproNo("");
//			sendEmail(afterProgressVO);
//			//############################################################################################
//			
//		}catch(EventException ex){
//			rollback();
//			throw ex;
//		}catch(Exception ex){
//			rollback();
//			throw new EventException(ex.getMessage(), ex);
//		}
//		
//		return eventResponse;
//	}	
	
//	/**
//	 * EES_DMT_2009 : setEmailInfoforCancelInvoice<br>
//	 * Invoice 취소메일 정보를 설정한다.<br>
//	 * 
//	 * @param List<String> cancelInvoiceNoList
//	 * @return List<Properties> listRtn
//	 * @exception EventException
//	 */	
//	private List<Properties> setEmailInfoforCancelInvoice(List<String> cancelInvoiceNoList) throws EventException {
//		
//		List<Properties> listRtn = null;
//		
//		ChargeAmountDiscountMgtBC	bcCharge = new ChargeAmountDiscountMgtBCImpl();
//	
//		log.debug("\n [DMTClosingSC.[sendEmailforCancelInvoice]] :::::> START ");
//		if (cancelInvoiceNoList != null && !cancelInvoiceNoList.isEmpty()) {
//			
//			listRtn = new ArrayList<Properties>();
//			
//			Properties propsRtn = null;
//			
//			for (String cancelInvoiceNo : cancelInvoiceNoList) {
//				propsRtn = new Properties();
//				
//				// 메일 수신자 조회
//				propsRtn.setProperty("receiver", bcCharge.searchInvoiceCreateUserEmail(cancelInvoiceNo));
//				log.debug("\n [DMTClosingSC.[setEmailInfoforCancelInvoice]][" + cancelInvoiceNo + "] :::::> receiver : " + propsRtn.getProperty("receiver"));
//
//				// 메일 송신자 설정
//				propsRtn.setProperty("sender", account.getUsr_eml());
//				log.debug("\n [DMTClosingSC.[setEmailInfoforCancelInvoice]][" + cancelInvoiceNo + "] :::::> sender : " + propsRtn.getProperty("sender"));
//				
//				// 메일 내용 조회
//				propsRtn.setProperty("content", bcCharge.searchInvoiceCancelContentFromCancelRmk(cancelInvoiceNo));
//				log.debug("\n [DMTClosingSC.[setEmailInfoforCancelInvoice]][" + cancelInvoiceNo + "] :::::> content : " + propsRtn.getProperty("content"));
//				
//				listRtn.add(propsRtn);
//			}
//		}
//		log.debug("\n [DMTClosingSC.[sendEmailforCancelInvoice]] :::::> END ");
//		return listRtn;
//	}
	
//	/**
//	 * EES_DMT_2009 : sendEmailforCancelInvoice<br>
//	 * 취소된 Invoice 에 대한 이메일을 전송한다.<br>
//	 * 
//	 * @param List<Properties> listEmail
//	 * @return void
//	 * @exception EventException
//	 */	
//	private void sendEmailforCancelInvoice(List<Properties> listEmail) throws EventException {
//		
//		FaxEmailBC 					bcMail	 = new FaxEmailBCImpl();
//
//		log.debug("\n [DMTClosingSC.[sendEmailforCancelInvoice]] :::::> START ");
//			
//		begin();
//		for (Properties email : listEmail) {
//			//메일 송신
//			bcMail.sendEmailforCancelInvoice(email.getProperty("receiver"), email.getProperty("sender"), email.getProperty("content"));
//		}
//		commit();
//
//		log.debug("\n [DMTClosingSC.[sendEmailforCancelInvoice]] :::::> END ");
//	}
	
	/**
	 * Contract Customer 검색*(EES_DMT_3104 Spec Reason 전용)
	 * @param event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchContractCustomer(Event e) throws EventException {
		EesDmt3104Event event = (EesDmt3104Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		String scNo = event.getAttribute("sc_no").toString();
		try {			
			eventResponse.setETCData("cust_yn", command.searchContractCustomer(scNo) ? "Y" : "N");
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Manual Invoice STS 확인하여 Cancel 여부를 판단한다*(EES_DMT_3104 Spec Reason 전용)
	 * @param event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchInvoiceStatus(Event e) throws EventException {
		EesDmt3104Event event = (EesDmt3104Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		String invNo = event.getAttribute("inv_no").toString();
		try {			
			eventResponse.setETCData("CANCEL_FLG", command.searchInvoiceStatus(invNo));
			log.error("###Canel####" + eventResponse.getETCData("CANCEL_FLG") );
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * OC 시점의 Container Movement Date 조회
	 * @param event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchOcCnmvDt(Event e) throws EventException {
		EesDmt3104Event event = (EesDmt3104Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		
		String temp_bkg_no = event.getAttribute("temp_bkg_no").toString();
		String temp_cntr_no = event.getAttribute("temp_cntr_no").toString();
		String temp_cntr_cyc_no = event.getAttribute("temp_cntr_cyc_no").toString();
		
		try {			
			eventResponse.setETCData("OC_DT", command.searchOcCnmvDt(temp_bkg_no,temp_cntr_no,temp_cntr_cyc_no));
			log.error("###OC_DT####" + eventResponse.getETCData("OC_DT") );
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	

	
	/**
	 * After Booking Office Code Check 로직 조회
	 * @param event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchOfcChkFlg(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeAmountDiscountMgtBC command = new ChargeAmountDiscountMgtBCImpl();
		
		
		try {			
			eventResponse.setETCData("OFC_CHK_LIST", command.searchOfcChkFlg());
			log.error("###OFC_CHK_LIST####" + eventResponse.getETCData("OFC_CHK_LIST") );
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
}