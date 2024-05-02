/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TRIProposalSC.java
 *@FileTitle : TRI Creation & Amendment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.13
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.11.13 박성수
 * 1.0 Creation
=========================================================
* History
* 2011-08-08 서미진 [CHM-201112688] Rate Application 관련 추가 시스템 개발 건 (ESM_PRI_3019 : TAA Proposal & Amendment View)
* 2011-08-17 송호진 [CHM-2011128680-01][PRI] TAA화면에서 EAI(CMS013_0001)호출을 Confirm 후 Sales Rep. 변경시에도 호출 할수 있도록 변경
* 2012-09-18 원종규[CHM-201220110-01] 계약 변경 통보 기능-계약이 사용된 BKG에대해 BKG의 Rating을 진행한 유저에게  G/W 메일 발송 
* 2013.11.07 전윤주 [CHM-201327486] File 시 Revenue Audit System 수입심사 배치대상 추가 요청
* 2016.06.17  [CHM-201642005] TRI Amendment & Creation 상에서 Publish 버튼 클릭 후 30초가 지나도 서비스 가능하도록 시스템 개발 
========================================================= */
package com.hanjin.apps.alps.esm.pri.triproposal;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PriEmailTargetListVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PrsBatchVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.basic.CalculateBC;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.basic.CalculateBCImpl;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.RsltPriPrsRoutCsMaxRoutCsNoVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.basic.CMSummaryBC;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.basic.CMSummaryBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropCustInfoVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.basic.SCRateProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.basic.SCRateProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.InPriPrsRoutCsVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRouteCaseCostVersionVO;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.basic.TAAProposalBC;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.basic.TAAProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.event.EsmPri3004Event;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.event.EsmPri3007Event;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.event.EsmPri3008Event;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.event.EsmPri3009Event;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.event.EsmPri3017Event;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.event.EsmPri3019Event;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.vo.PriTaaListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.vo.RsltTaaListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.vo.RsltTaaMnVO;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.vo.RsltTaaTriListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.trigricalculationproposal.basic.TRIGRICalculationProposalBC;
import com.hanjin.apps.alps.esm.pri.triproposal.trigricalculationproposal.basic.TRIGRICalculationProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.triproposal.trigricalculationproposal.event.EsmPri3010Event;
import com.hanjin.apps.alps.esm.pri.triproposal.trigricalculationproposal.vo.RsltGriCalcGrpListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.trigricalculationproposal.vo.RsltGriCalcListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.basic.TRINoteConversionProposalBC;
import com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.basic.TRINoteConversionProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.event.EsmPri3005Event;
import com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.event.EsmPri3006Event;
import com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.vo.PriTriNoteConvListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.vo.RsltPriTriNoteConvVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.basic.TRIProposalBC;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.basic.TRIProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.event.EsmPri3001Event;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.event.EsmPri3002Event;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.event.EsmPri3003Event;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.event.EsmPri3013Event;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.event.EsmPri3014Event;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.event.EsmPri3015Event;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.event.EsmPri3018Event;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.event.EsmPri6084Event;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.event.EsmPri6085Event;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration.TRIProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltPriCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltPrsSurchargeDetailListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPropDtlListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPropInquiryListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPropListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPrsCostDetailVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPrsCostListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropSendMailVO;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriEaiSndLogVO;
import com.hanjin.syscommon.common.table.PriPrsBatVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;
import com.hanjin.syscommon.common.table.PriTaaMnVO;
import com.hanjin.syscommon.common.table.PriTriNoteVO;
import com.hanjin.syscommon.common.table.PriTriRtUsdRoutCsVO;
import com.hanjin.syscommon.common.table.PriTriRtVO;

/**
 * ALPS-TRIProposal Business Logic ServiceCommand - ALPS-TRIProposal 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Sungsoo Park
 * @see TRIProposalDBDAO
 * @since J2EE 1.6
 */

public class TRIProposalSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * TRIProposal system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("TRIProposalSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * TRIProposal system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("TRIProposalSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-TRIProposal system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsmPri3001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTRIProposalList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTRIRateProposalList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCheckRateDuplicate(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = executeCalculate(e);
//            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
//                eventResponse = monitorCalculate(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
            	eventResponse = comBackEndJobVOs(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
            	eventResponse = comBackEndJobSearchListGetResult(e);                
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Save
				eventResponse = manageTRIRateProposal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { // Request
				eventResponse = requestTRIRateProposal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) { // Amend
				eventResponse = amendTRIRateProposal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) { // C/Offer
				eventResponse = cofferTRIRateProposal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) { // Approve
				eventResponse = approveTRIRateProposal(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY05)) { // Publish
//				eventResponse = publishTRIRateProposal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY06)) { // TRI No. Assign
				eventResponse = assignNoTRIRateProposal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY07)) { // Cancel
				eventResponse = cancelTRIRateProposal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY11)) { // Request All
				eventResponse = requestMultiTRIRateProposal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY12)) { // Approve All
				eventResponse = approveMultiTRIRateProposal(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY13)) { // Publish All
//				eventResponse = publishMultiTRIRateProposal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY15)) { // Request Cancel All
				eventResponse = cancelMultiTRIRateProposal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY16)) { // Approve Cancel All
				eventResponse = cancelMultiTRIRateProposal(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri3010Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchGRICalculationHeaderList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchGRICalculationList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
                eventResponse = searchCheckGRIApplicable(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageGRICalculation(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
                eventResponse = applyGRICalculation(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
                eventResponse = cancelGRICalculation(e);
            }
        }
		else if (e.getEventName().equalsIgnoreCase("EsmPri3015Event")) {
            if (e.getFormCommand().isCommand(FormCommand.MODIFY05)) { // Publish
                eventResponse = publishTRIRateProposal(e);
            }
        }
		else if (e.getEventName().equalsIgnoreCase("EsmPri3018Event")) {
            if (e.getFormCommand().isCommand(FormCommand.MODIFY13)) { // Publish All
                eventResponse = publishMultiTRIRateProposal(e);
            }
        }
		else if (e.getEventName().equalsIgnoreCase("EsmPri3007Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchTRIProposalTAAList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {    // Amdt Seq Combo
                eventResponse = searchTRIProposalTAAAmdtSeqList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {    // Booking에서 사용여부 validaton
                eventResponse = searchTRIProposalTAACheckUseBkg(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {    // Customer
                eventResponse = searchProposalCustomerInfo(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {    // 승인권한 조회
                eventResponse = searchTRIProposalTAAApprovalAuth(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Save
                eventResponse = manageTRIProposalTAA(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // Confirm
                eventResponse = confirmTRIProposalTAA(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { // Confirm Cancel
                eventResponse = confirmCancelTRIProposalTAA(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) { // Cancel
                eventResponse = cancelTRIProposalTAA(e);
            } else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) { // Open
                eventResponse = openTRIProposalTAAList(e);
            }
        }
		else if (e.getEventName().equalsIgnoreCase("EsmPri3002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {			//Retrieve
				eventResponse = searchNoteConversionList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	//Paste
				eventResponse = searchNoteConversionCopyList(e);
		/*	} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { 	//Save
				eventResponse = manageNoteConversion(e);*/
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { 	//Copy
				eventResponse = manageNoteConversionCopy(e);
		/*	} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) { 		//Save
				eventResponse = manageNote(e);*/
			} else { 	//Open
				eventResponse = searchCommonNoteConversionList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri3003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {			//Retrieve
				eventResponse = searchNoteConversionInquiryList(e);
			} else { 	//Open
				eventResponse = searchCommonNoteConversionInquiryList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri3005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {			//Retrieve
				eventResponse = searchTRIFomulaRuleList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { 	//Duration
				eventResponse = searchTRIFomulaRuleInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { 	//Conversion Code(Rule, Charge)
				eventResponse = searchRuleChargeCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { 	//Save
				eventResponse = manageTRIFomulaRule(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { 	//Copy
				eventResponse = copyTRIFomulaRule(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { 	//Confirm
				eventResponse = confirmTRIFomulaRule(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) { 	//Confirm Cancel
				eventResponse = cancelTRIFomulaRule(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) { 	//Delete
				eventResponse = deleteTRIFomulaRule(e);
			} else{ 															//Open
				eventResponse = searchCommonTRIFomulaRuleList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri3006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {			//Retrieve
				eventResponse = searchTRIFomulaRuleInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { 	//Duration
				eventResponse = searchTRIFomulaRuleInfoInquiry(e);
		/*	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { 	//Scope
				eventResponse = searchServiceScopeCodeInquiryList(e);*/
			} else{ 															//Open
				eventResponse = searchCommonTRIFomulaRuleInquiryList(e);
			}
		}
        else if (e.getEventName().equalsIgnoreCase("EsmPri3017Event")) {
            if (e.getFormCommand().isCommand(FormCommand.MULTI)) {           // TAA Amend
                eventResponse = amendTRIProposalTAA(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmPri3004Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchTRIProposalTAAInquiryList(e);
            }
        }
        // ============================ESM_PRI_6084_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri6084Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchCostDetailList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                    eventResponse = searchCostDetailInquiryList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = modifyPrsCost(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                    eventResponse = modifyPrsSimulationCost(e);
            }
            // =============================ESM_PRI_6084_end===================================
        }
        // ============================ESM_PRI_6085_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri6085Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchRateSurchargeList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageRateSurcharge(e);
            }
            // =============================ESM_PRI_6085_end===================================
        }
        else if (e.getEventName().equalsIgnoreCase("EsmPri3009Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchTRIProposalSelectList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) { // Open
                eventResponse = openTRIProposalSelectList(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmPri3008Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchTRIProposalTAANoList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {    // Customer
                eventResponse = searchProposalCustomerInfo(e);
            } else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) { // Open
                eventResponse = openTRIProposalTAANoList(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmPri3013Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchTRIProposalInquiryList(e);
            } else {
            	eventResponse = initTRIProposalComboData(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmPri3014Event")) {
            if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // Send Mail
                eventResponse = sendMailTRIProposal(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmPri3019Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
                eventResponse = searchTRIProposalTAAViewList(e);
            }
        }
		return eventResponse;
	}

	///////////////////////// ESM_PRI_3001 Start /////////////////////////
	
    /**
     * ESM_PRI_3001 : Retrieve<br>
     * TRI Proposal List를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchTRIProposalList(Event e) throws EventException {
		EsmPri3001Event event = (EsmPri3001Event) e;
		TRIProposalBC command = new TRIProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltTriPropListVO> vos = command.searchTRIProposalList(event.getTriPropParamVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}
    
    /**
     * ESM_PRI_3001 : Sheet1.OnSelect<br>
     * TRI Proposal - Rate 및 Route정보를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchTRIRateProposalList(Event e) throws EventException {
		EsmPri3001Event event = (EsmPri3001Event) e;
		TRIProposalBC command = new TRIProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			RsltTriPropDtlListVO vo = command.searchTRIRateProposalList(event.getPriTriMnVO());
			
            eventResponse.setRsVoList(vo.getRsltTriRtListVOS());
            eventResponse.setRsVoList(vo.getRsltTriRoutOrgPntVOS());
            eventResponse.setRsVoList(vo.getRsltTriRoutOrgViaVOS());
            eventResponse.setRsVoList(vo.getRsltTriRoutDestViaVOS());
            eventResponse.setRsVoList(vo.getRsltTriRoutDestPntVOS());
            eventResponse.setRsVoList(vo.getRsltPriTriNoteConvVO());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

    /**
     * ESM_PRI_3001 : before Save, Approve<br>
     * TRI Proposal Rate가 중복되었는지 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCheckRateDuplicate(Event e) throws EventException {
		EsmPri3001Event event = (EsmPri3001Event) e;
		TRIProposalBC command = new TRIProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String dupTriPropNo = command.searchCheckRateDuplicate(event.getTriPropParamVO());
			eventResponse.setETCData("DUP_PROP_NO", dupTriPropNo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

    /**
     * ESM_PRI_3001 : Save<br>
     * TRI Proposal Route 및 Rate 데이터의 멀티 트랜잭션을 처리한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageTRIRateProposal(Event e) throws EventException {
        EsmPri3001Event event = (EsmPri3001Event) e;
        TRIProposalBC command = new TRIProposalBCImpl();
        TRINoteConversionProposalBC cmdConv = new TRINoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        String newTriPropNo = null;

        try {
            begin();
            
            if (event.getTriPropVO().getPriTriMnVO().getIbflag().equals("I")) {
            	newTriPropNo = command.searchNextTRIPropNo(account);
            	if (newTriPropNo != null) {
            		PriTriNoteConvListVO[] convVOs = event.getPriTriNoteConvListVOs();
            		for (int i = 0; convVOs != null && i < convVOs.length; i++) {
            			convVOs[i].setTriPropNo(newTriPropNo);
            			convVOs[i].setAmdtSeq("0");
            		}
            	}
            }
            cmdConv.manageNoteConversion(event.getPriTriNoteConvListVOs(), account);
            cmdConv.manageTRIRateProposal(event.getTriPropVO(), account);
            command.manageTRIRateProposal(event.getTriPropVO(), account, newTriPropNo);
            eventResponse.setETCData("NEW_PROP_NO", newTriPropNo);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_3001 : Request<br>
     * TRI Proposal 데이터의 승인을 요청한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse requestTRIRateProposal(Event e) throws EventException {
        EsmPri3001Event event = (EsmPri3001Event) e;
        TRIProposalBC command = new TRIProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            command.requestTRIRateProposal(event.getPriTriRtVO(), account);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_3001 : Request All<br>
     * 다건의 TRI Proposal 데이터의 승인을 요청한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse requestMultiTRIRateProposal(Event e) throws EventException {
        EsmPri3001Event event = (EsmPri3001Event) e;
        TRIProposalBC command = new TRIProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            command.requestMultiTRIRateProposal(event.getPriTriRtVOs(), account);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_3001 : Amend<br>
     * TRI Proposal 데이터를 Amend한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse amendTRIRateProposal(Event e) throws EventException {
        EsmPri3001Event event = (EsmPri3001Event) e;
        TRIProposalBC command = new TRIProposalBCImpl();
        TRINoteConversionProposalBC cmdConv = new TRINoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            command.amendTRIRateProposal(event.getPriTriRtVO(), account);
            cmdConv.amendTRIRateProposal(event.getPriTriRtVO(), account);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_3001 : C/Offer<br>
     * TRI Proposal 데이터의 C/Offer 처리한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cofferTRIRateProposal(Event e) throws EventException {
        EsmPri3001Event event = (EsmPri3001Event) e;
        TRIProposalBC command = new TRIProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            command.cofferTRIRateProposal(event.getPriTriRtVO(), account);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_3001 : Approve<br>
     * TRI Proposal 데이터를 승인한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse approveTRIRateProposal(Event e) throws EventException {
        EsmPri3001Event event = (EsmPri3001Event) e;
        TRIProposalBC command = new TRIProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            command.approveTRIRateProposal(event.getPriTriRtVO(), account);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_3001 : Approve All<br>
     * 다건의 TRI Proposal 데이터를 승인한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse approveMultiTRIRateProposal(Event e) throws EventException {
        EsmPri3001Event event = (EsmPri3001Event) e;
        TRIProposalBC command = new TRIProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            command.approveMultiTRIRateProposal(event.getPriTriRtVOs(), account);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_3015 : Publish<br>
     * TRI Proposal 데이터를 Publish한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse publishTRIRateProposal(Event e) throws EventException {
        EsmPri3015Event event = (EsmPri3015Event) e;
        TRIProposalBC command = new TRIProposalBCImpl();
        TRINoteConversionProposalBC cmdConv = new TRINoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            cmdConv.publishTRIRateProposal(event.getPriTriRtVO(), account);
            command.publishTRIRateProposal(event.getPriTriRtVO(), account);
            
            // mail 전송
            command.sendMailTRIProposalPublish(event.getPriTriRtVO(), account);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_3018 : Publish All<br>
     * 다건의 TRI Proposal 데이터를 Publish한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse publishMultiTRIRateProposal(Event e) throws EventException {
        EsmPri3018Event event = (EsmPri3018Event) e;
        TRIProposalBC command = new TRIProposalBCImpl();
//        TRINoteConversionProposalBC cmdConv = new TRINoteConversionProposalBCImpl();  //CHM-201642005
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            //[backend job start]
            String key = command.publishMultiTRIRateProposalPublishBackEnd(event.getPriTriRtVOs(), account);
            eventResponse.setETCData("JOB_KEY", key);
            //[backend job end]
            /**********************************************************************
            [기존 소스]
            command.publishMultiTRIRateProposal(event.getPriTriRtVOs(), account);
            cmdConv.publishMultiTRIRateProposal(event.getPriTriRtVOs(), account);

            PriTriRtVO[] priTriRtVOs = event.getPriTriRtVOs();
            if (priTriRtVOs != null && priTriRtVOs.length > 0) {
                // mail 전송
                for (int i = 0; i < priTriRtVOs.length; i++) {
                    command.sendMailTRIProposalPublish(priTriRtVOs[i], account);
                }
            }
            **********************************************************************/
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_3001 : TRI No. Assign<br>
     * TRI Proposal 데이터에 TRI Number를 Assign한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse assignNoTRIRateProposal(Event e) throws EventException {
        EsmPri3001Event event = (EsmPri3001Event) e;
        TRIProposalBC command = new TRIProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            command.assignNoTRIRateProposal(event.getPriTriMnVO(), account);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_3001 : Cancel<br>
     * TRI Proposal 데이터의 상태를 이전으로 되돌린다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelTRIRateProposal(Event e) throws EventException {
        EsmPri3001Event event = (EsmPri3001Event) e;
        TRIProposalBC command = new TRIProposalBCImpl();
        TRINoteConversionProposalBC cmdConv = new TRINoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            cmdConv.cancelTRIRateProposal(event.getPriTriRtVO(), account);
            command.cancelTRIRateProposal(event.getPriTriRtVO(), account);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_3001 : Cancel All<br>
     * 다건의 TRI Proposal 데이터의 상태를 이전으로 되돌린다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelMultiTRIRateProposal(Event e) throws EventException {
        EsmPri3001Event event = (EsmPri3001Event) e;
        TRIProposalBC command = new TRIProposalBCImpl();
        TRINoteConversionProposalBC cmdConv = new TRINoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            cmdConv.cancelMultiTRIRateProposal(event.getPriTriRtVOs(), account);
            command.cancelMultiTRIRateProposal(event.getPriTriRtVOs(), account);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

	///////////////////////// ESM_PRI_3001 End /////////////////////////

    ///////////////////////// ESM_PRI_3010 Start /////////////////////////
    
    /**
     * ESM_PRI_3010 : Open<br>
     * GRI Calculation Header 리스트를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGRICalculationHeaderList(Event e) throws EventException {
        EsmPri3010Event event = (EsmPri3010Event) e;
        TRIGRICalculationProposalBC command = new TRIGRICalculationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
            List<RsltGriCalcGrpListVO> vos = command.searchGRICalculationHeaderList(event.getPriTriGriGrpVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_3010 : Sheet1.Select<br>
     * GRI Calculation 리스트를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGRICalculationList(Event e) throws EventException {
        EsmPri3010Event event = (EsmPri3010Event) e;
        TRIGRICalculationProposalBC command = new TRIGRICalculationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
            RsltGriCalcListVO vo = command.searchGRICalculationList(event.getPriTriGriGrpVO());
            eventResponse.setRsVoList(vo.getRsltGriCalcRtListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcCmdtListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcOrgPntListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcOrgViaListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcDestViaListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcDestPntListVOS());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }
    
    /**
     * ESM_PRI_3010 : New<br>
     * New클릭시 GRI가 완료되지 않은 Rate가 있는지 확인한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCheckGRIApplicable(Event e) throws EventException {
        EsmPri3010Event event = (EsmPri3010Event) e;
        TRIProposalBC command = new TRIProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
            String dupTriNo = command.searchCheckGRIApplicable(event.getTriPropGRIVO());
            eventResponse.setETCData("DUP_TRI_NO", dupTriNo);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_3010 : Save<br>
     * GRI Calculation 데이터의 CUD 트랜잭션을 처리합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageGRICalculation(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri3010Event event = (EsmPri3010Event) e;
        TRIGRICalculationProposalBC command = new TRIGRICalculationProposalBCImpl();

        try {
            begin();
            command.manageGRICalculation(event.getTriGriCalcVO(), account);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_3010 : Apply<br>
     * Rate 데이터에 GRI Calculation을 적용합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse applyGRICalculation(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri3010Event event = (EsmPri3010Event) e;
        TRIProposalBC command = new TRIProposalBCImpl();
        TRIGRICalculationProposalBC griCommand = new TRIGRICalculationProposalBCImpl();
        TRINoteConversionProposalBC cmdConv = new TRINoteConversionProposalBCImpl();

        try {
            begin();
            command.applyGRICalculation(event.getTriPropGRIVO(), account);
            griCommand.manageGRICalculation(event.getTriGriCalcVO(), account);
            cmdConv.applyGRICalculation(event.getTriPropGRIVO(), account);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_3010 : Cancel<br>
     * 적용한 GRI Calculation을 취소합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelGRICalculation(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri3010Event event = (EsmPri3010Event) e;
        TRIProposalBC command = new TRIProposalBCImpl();
        TRIGRICalculationProposalBC griCommand = new TRIGRICalculationProposalBCImpl();
        TRINoteConversionProposalBC cmdConv = new TRINoteConversionProposalBCImpl();

        try {
            begin();
            cmdConv.cancelGRICalculation(event.getTriPropGRIVO(), account);
            command.cancelGRICalculation(event.getTriPropGRIVO(), account);
            griCommand.manageGRICalculation(event.getTriGriCalcVO(), account);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    ///////////////////////// ESM_PRI_3010 End /////////////////////////
    
    /**
     * ESM_PRI_3007 : Open<br>
     * 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse openTRIProposalTAAList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        List<RsltCdListVO> customData = null;

        try{
            // Service Scope Code List
            customData = command.searchTariffServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_3007 : TAA No<br>
     * TAA No 값 변경시 해당하는 Amdt Seq Combo Item 을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchTRIProposalTAAAmdtSeqList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri3007Event event = (EsmPri3007Event) e;
        TAAProposalBC command = new TAAProposalBCImpl();

        try{
            // Amdt Seq List
            List<RsltCdListVO> list = command.searchTRIProposalTAAAmdtSeqList(event.getRsltTaaMnVO());
            eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_3007,ESM_PRI_3008 : Customer<br>
     * Customer 정보를 조회합니다.<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalCustomerInfo(Event e) throws EventException {
        TAAProposalBC command = new TAAProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PriSpCtrtPtyVO priSpCtrtPtyVO = new PriSpCtrtPtyVO();
        
        try{
            if (e.getEventName().equalsIgnoreCase("EsmPri3007Event")) {
                EsmPri3007Event event = (EsmPri3007Event) e;
                priSpCtrtPtyVO = event.getPriSpCtrtPtyVO();
            } else if (e.getEventName().equalsIgnoreCase("EsmPri3008Event")) {
                EsmPri3008Event event = (EsmPri3008Event) e;
                priSpCtrtPtyVO = event.getPriSpCtrtPtyVO();
            }
            List<RsltPropCustInfoVO> list = command.searchProposalCustomerInfo(priSpCtrtPtyVO);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_3007 : Retrieve<br>
     * TRI Proposal TAA Main 및 TRI List 를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchTRIProposalTAAList(Event e) throws EventException {
        EsmPri3007Event event = (EsmPri3007Event) e;
        TAAProposalBC command = new TAAProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            RsltTaaMnVO paramVo = event.getRsltTaaMnVO();
            log.debug(">>>>>>>>>>>>>>>>>>>>>>> "+paramVo);
            RsltTaaListVO vo = command.searchTRIProposalTAAList(paramVo);

            eventResponse.setRsVoList(vo.getRsltTaaMnVOs());
            eventResponse.setRsVoList(vo.getRsltTaaTriListVOs());
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }

        return eventResponse;
    }
    
    /**
     * ESM_PRI_3007 : Save<br>
     * TRI Proposal TAA 정보를 저장합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageTRIProposalTAA(Event e) throws EventException {
        EsmPri3007Event event = (EsmPri3007Event) e;
        TAAProposalBC command = new TAAProposalBCImpl();
        PRICommonBC commCommand = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        String taaNo = null;
        String taaPropNo = null;

        try {
            begin();
            PriTaaListVO priTaaListVO = event.getPriTaaListVO();
            RsltTaaMnVO[] rsltTaaMnVOs = priTaaListVO.getRsltTaaMnVOs();
            RsltTaaTriListVO[] rsltTaaTriListVOs = priTaaListVO.getRsltTaaTriListVOs();
            
            if ((rsltTaaMnVOs == null || rsltTaaMnVOs.length != 1) && (rsltTaaTriListVOs == null || rsltTaaTriListVOs.length == 0)) {
                // There is no data to save.
                new EventException (new ErrorHandler("PRI00301",new String[]{}).getMessage());
            }
            
            // TAA Main
            if (rsltTaaMnVOs != null && rsltTaaMnVOs.length == 1) {
                // 신규입력일 경우
                if (JSPUtil.getNull(rsltTaaMnVOs[0].getTaaPropNo()).equals("")) {
                    taaNo = command.searchTRIProposalTAANo(account.getOfc_cd());    // 신규 TAA_NO
                    taaPropNo = command.searchTRIProposalTAAPropNo(account.getOfc_cd());    // 신규 TAA_PROP_NO
                    rsltTaaMnVOs[0].setTaaNo(taaNo);
                    rsltTaaMnVOs[0].setTaaPropNo(taaPropNo);
                    rsltTaaMnVOs[0].setAmdtSeq("0");

                    if (rsltTaaTriListVOs != null) {
                        for (int i = 0, n = rsltTaaTriListVOs.length ; i < n ; i++) {
                            rsltTaaTriListVOs[i].setTaaNo(taaNo);
                            rsltTaaTriListVOs[i].setTaaPropNo(taaPropNo);
                            rsltTaaTriListVOs[i].setAmdtSeq("0");
                        }
                    }
                    eventResponse.setETCData("taa_no", taaNo);
                    eventResponse.setETCData("taa_prop_no", taaPropNo);
                }
                // TAA Header
                command.manageTRIProposalTAAHeader(rsltTaaMnVOs, account);
                
                // Confirm 이후 Sales Rep 변경 체크 2011.08.17 - 송호진
                // 설계의 요청에 의해 PriTaaMnVO 를 별도로 생성하여 처리
                // 아래의 TAA Main 변경이전에 호출하여 체크.
                PriTaaMnVO priTaaMnVO = new PriTaaMnVO();
                
                priTaaMnVO.setTaaPropNo(rsltTaaMnVOs[0].getTaaPropNo());
                priTaaMnVO.setAmdtSeq(rsltTaaMnVOs[0].getAmdtSeq());
                priTaaMnVO.setRespbSrepCd(rsltTaaMnVOs[0].getRespbSrepCd());
                
                int cnt = command.searchCheckOfcSrepDiffList(priTaaMnVO);
                
                // TAA Main
                command.manageTRIProposalTAAMain(rsltTaaMnVOs, account);
                
                // Confirm 이후 Sales Rep 변경 체크값 결과에 따라 CMS013_001 메시지 처리 2011.08.17 - 송호진
                // 위의 TAA Main 처리 에서 변경 저장된 값을 가져와 처리하므로 순서가 지켜져야 한다. 
                if ( cnt > 0 ){
                    rsltTaaMnVOs[0].setTaaSts("C"); // Sales Rep. Update 이지만 "C" 로 Setting 하여 보낸다.
                 // CRM Phase-out 됨에 따라 삭제 함 20171204 송민석
                    //String reEaiIfId = command.transferTAAMainInfo(rsltTaaMnVOs[0], account);
                    
                    // PRI_EAI_SND_LOG 건 생성 2011.08.18 송호진 
//                    PriEaiSndLogVO priEaiSndLogVO = new PriEaiSndLogVO();
//                    priEaiSndLogVO.setPropNo(rsltTaaMnVOs[0].getTaaPropNo());
//                    priEaiSndLogVO.setAmdtSeq(rsltTaaMnVOs[0].getAmdtSeq());
//                    priEaiSndLogVO.setEaiIfId(reEaiIfId);
//                    priEaiSndLogVO.setPrcCtrtTpCd("T");
//                    priEaiSndLogVO.setEaiSndParaCtnt("C");
//                    commCommand.addEaiSendLog(priEaiSndLogVO, account);
                    
                }
            }

            // TAA-TRI List
            if (rsltTaaTriListVOs != null) {
                command.manageTRIProposalTAAList(rsltTaaTriListVOs, account);
            }
            eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
            commit();            
            
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_3007 : Confirm<br>
     * TRI Proposal TAA 정보를 Confirm 합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse confirmTRIProposalTAA(Event e) throws EventException {
        EsmPri3007Event event = (EsmPri3007Event) e;
        TAAProposalBC command = new TAAProposalBCImpl();
        PRICommonBC commCommand = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        //Booking Autorating
        BlRatingBC command2 = new BlRatingBCImpl();

        try {
            begin();
            RsltTaaMnVO rsltTaaMnVO = event.getRsltTaaMnVO();
            
            if (rsltTaaMnVO == null || JSPUtil.getNull(rsltTaaMnVO.getTaaNo()).equals("")) {
                // There is no data to save.
                new EventException (new ErrorHandler("PRI00301",new String[]{}).getMessage());
            }
            command.confirmTRIProposalTAA(rsltTaaMnVO, account);
            rsltTaaMnVO.setTaaSts("C"); // Confirm
            // CRM Phase-out 됨에 따라 삭제 함 20171204 송민석
            //String reEaiIfId = command.transferTAAMainInfo(rsltTaaMnVO, account);
            
            // PRI_EAI_SND_LOG 건 생성 2011.08.18 송호진 
//            PriEaiSndLogVO priEaiSndLogVO = new PriEaiSndLogVO();
//            priEaiSndLogVO.setPropNo(rsltTaaMnVO.getTaaPropNo());
//            priEaiSndLogVO.setAmdtSeq(rsltTaaMnVO.getAmdtSeq());
//            priEaiSndLogVO.setEaiIfId(reEaiIfId);
//            priEaiSndLogVO.setPrcCtrtTpCd("T");
//            priEaiSndLogVO.setEaiSndParaCtnt("C");
//            
//            commCommand.addEaiSendLog(priEaiSndLogVO, account);
            
            eventResponse.setUserMessage(new ErrorHandler("PRI00103").getUserMessage());
            
            // confirm 시 Rate apply date 보다 effective date가 이전일 경우 메일로 송부
            List<PriEmailTargetListVO> list = command.sendEmail(rsltTaaMnVO, account);
            
            if (list != null && list.size() > 0) { //메일 송부한 BKG list가 있으면 BKG 심사 배치 리스트에 추가 
            	command2.modifyAudDt(list);
            }
            commit();           
            
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_3007 : Confirm Cancel<br>
     * TRI Proposal TAA 정보를 Booking 에서 사용하는지 체크합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchTRIProposalTAACheckUseBkg(Event e) throws EventException {
        EsmPri3007Event event = (EsmPri3007Event) e;
        TAAProposalBC command = new TAAProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            String[] bkgNos = command.searchTRIProposalTAACheckUseBkg(event.getRsltTaaMnVO());
            if (bkgNos != null && bkgNos.length > 0) {
                StringBuffer sbBkgNo = new StringBuffer();
                for (int i = 0, n = bkgNos.length ; i < n ; i++) {
                    if (i == 5) {
                        sbBkgNo.append(" ...");
                        break;
                    } else if (i != 0) {
                        sbBkgNo.append(", ");
                    }
                    sbBkgNo.append(bkgNos[i]);
                }
                eventResponse.setETCData("bkgNos", sbBkgNo.toString());
            } else {
                eventResponse.setETCData("bkgNos", "");
            }
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }

        return eventResponse;
    }
    
    /**
     * ESM_PRI_3007 : Confirm Cancel<br>
     * TRI Proposal TAA 정보를 Confirm Cancel 합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse confirmCancelTRIProposalTAA(Event e) throws EventException {
        EsmPri3007Event event = (EsmPri3007Event) e;
        TAAProposalBC command = new TAAProposalBCImpl();
        PRICommonBC commCommand = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            RsltTaaMnVO rsltTaaMnVO = event.getRsltTaaMnVO();
            if (rsltTaaMnVO == null || JSPUtil.getNull(rsltTaaMnVO.getTaaNo()).equals("")) {
                // There is no data to save.
                new EventException (new ErrorHandler("PRI00301",new String[]{}).getMessage());
            }
            command.confirmCancelTRIProposalTAA(rsltTaaMnVO, account);
            rsltTaaMnVO.setTaaSts("D"); // Confirm Cancel
            // CRM Phase-out 됨에 따라 삭제 함 20171204 송민석
            //String reEaiIfId = command.transferTAAMainInfo(rsltTaaMnVO, account);
            
            // PRI_EAI_SND_LOG 건 생성 2011.08.18 송호진 
//            PriEaiSndLogVO priEaiSndLogVO = new PriEaiSndLogVO();
//            priEaiSndLogVO.setPropNo(rsltTaaMnVO.getTaaPropNo());
//            priEaiSndLogVO.setAmdtSeq(rsltTaaMnVO.getAmdtSeq());
//            priEaiSndLogVO.setEaiIfId(reEaiIfId);
//            priEaiSndLogVO.setPrcCtrtTpCd("T");
//            priEaiSndLogVO.setEaiSndParaCtnt("D");
//            
//            commCommand.addEaiSendLog(priEaiSndLogVO, account);
            eventResponse.setUserMessage(new ErrorHandler("PRI00104").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_3007 : Cancel<br>
     * TRI Proposal TAA 해당 회차 정보를 Delete 합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelTRIProposalTAA(Event e) throws EventException {
        EsmPri3007Event event = (EsmPri3007Event) e;
        TAAProposalBC command = new TAAProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            RsltTaaMnVO rsltTaaMnVO = event.getRsltTaaMnVO();
            
            if (rsltTaaMnVO == null || JSPUtil.getNull(rsltTaaMnVO.getTaaNo()).equals("")) {
                // There is no data to save.
                new EventException (new ErrorHandler("PRI00301",new String[]{}).getMessage());
            }
            command.cancelTRIProposalTAA(rsltTaaMnVO, account);
            eventResponse.setUserMessage(new ErrorHandler("PRI00102").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_3007 : Button Control<br>
     * TRI Proposal TAA 승인권한을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchTRIProposalTAAApprovalAuth(Event e) throws EventException {
        EsmPri3007Event event = (EsmPri3007Event) e;
        TAAProposalBC command = new TAAProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            String authYn = command.searchTRIProposalTAAApprovalAuth(event.getPriAuthorizationVO());

            eventResponse.setETCData("approvalAuth", authYn);
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_3017 : OK<br>
     * TRI Proposal TAA 정보를 Amend 합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse amendTRIProposalTAA(Event e) throws EventException {
        EsmPri3017Event event = (EsmPri3017Event) e;
        TAAProposalBC command = new TAAProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            RsltTaaMnVO rsltTaaMnVO = event.getRsltTaaMnVO();
            command.amendTRIProposalTAA(rsltTaaMnVO, account);
            eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_3009 : Open<br>
     * Service Scope Code 로 Tariff Code 를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse openTRIProposalSelectList(Event e) throws EventException {
        EsmPri3009Event event = (EsmPri3009Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();

        try{
            RsltCdListVO rsltCdListVO = new RsltCdListVO();
            rsltCdListVO.setSvcScpCd(JSPUtil.getNull(event.getRsltTaaMnVO().getSvcScpCd()));
            // Tariff Code
            List<RsltCdListVO> list = command.searchTariffCodeByServiceScopeCode(rsltCdListVO);
            
            if (list != null && list.size() > 0) {
                RsltCdListVO cdVO = list.get(0);
                eventResponse.setCustomData("trfCd", cdVO.getCd());
                eventResponse.setCustomData("trfNm", cdVO.getNm());
                eventResponse.setCustomData("trfPfxCd", cdVO.getEtc1());
                eventResponse.setCustomData("trfNo", cdVO.getEtc2());
            }
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }
        
        return eventResponse;
    }

    /**
     * ESM_PRI_3009 : Retrieve<br>
     * TRI Proposal Select List 를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchTRIProposalSelectList(Event e) throws EventException {
        EsmPri3009Event event = (EsmPri3009Event) e;
        TAAProposalBC command = new TAAProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltTaaTriListVO> list = command.searchTRIProposalSelectList(event.getRsltTaaTriListVO());
            eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }

        return eventResponse;
    }
    
    /**
     * ESM_PRI_3002 : Retrieve<br>
     * TRI Note 화면을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchNoteConversionList(Event e) throws EventException {
        EsmPri3002Event event = (EsmPri3002Event) e;
        TRINoteConversionProposalBC command = new TRINoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltPriTriNoteConvVO> list = command.searchNoteConversionList(event.getPriTriNoteConvVO());
            eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }

        return eventResponse;
    }
    
    /**
     * ESM_PRI_3002 : Retrieve<br>
     * 복사된 TRI NOTE CONVERSION 데이터를 붙여넣기 합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchNoteConversionCopyList(Event e) throws EventException {
        EsmPri3002Event event = (EsmPri3002Event) e;
        TRINoteConversionProposalBC command = new TRINoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltPriTriNoteConvVO> list = command.searchNoteConversionCopyList(event.getPriTriNoteConvVO(), account);
            eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }

        return eventResponse;
    }
   
    /*
     * ESM_PRI_3002 : Save<br>
     * TRI Note 데이터의 멀티 트랜잭션을 처리한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     *
    private EventResponse manageNoteConversion(Event e) throws EventException {
        EsmPri3002Event event = (EsmPri3002Event) e;
        TRINoteConversionProposalBC command = new TRINoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            command.manageNoteConversion(event.getPriTriNoteConvListVOs(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    */
    
    /**
     * ESM_PRI_3002 : Copy<br>
     * TRI Note 데이터를 복사한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageNoteConversionCopy(Event e) throws EventException {
        EsmPri3002Event event = (EsmPri3002Event) e;
        TRINoteConversionProposalBC command = new TRINoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            command.manageNoteConversionCopy(event.getPriTriNoteConvListVOs(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00110",new String[]{}).getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
        
    /**
     * ESM_PRI_3002 : OPEN <br>
     * TRI Note 화면로딩시 콤보정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchCommonNoteConversionList(Event e) throws EventException {
        EsmPri3002Event event = (EsmPri3002Event) e;
        PRICommonBC command = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;		
		
        try {        	
        	////////////////////COMMON - START/////////////////////
            //APLICATION
            vo.setCd("CD01723");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_APPL_TP_CD", list);
            
            //CARGO TYPE
            vo.setCd("CD01701");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_PRC_CGO_TP_CD", list);
            
            //CAL.
            vo.setCd("CD01724");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_OP_CD", list);
                        
            //PAY TERM
            vo.setCd("CD01713");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PAY_TERM_CD", list);
            
            //US SVC MODE
            vo.setCd("CD01708");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_HNGR_BAR_TP_CD", list);
            //////////////////////COMMON - END///////////////////////
        	
        	//PER TYPE
        	list = command.searchAllPerCodeList(vo);
        	eventResponse.setCustomData("BKG_RAT_UT_CD", list);
			        	
			//CURRENCY
			list = command.searchAllCurrencyCodeList(vo);
			eventResponse.setCustomData("CURR_CD", list);

			//NOTE CONVERSION RULE CODE ( CONVERSION TYPE별)
            //추후에 변경할것.
			vo.setEtc1("T"); // 계약 유형: S->S/C,  R->RFA,  T->TRI
			vo.setEtc2("R"); // CONVERSION TYPE CODE
			list = command.searchNoteConvRuleMapgList(vo);
			eventResponse.setCustomData("RULE_CD", list);
						
            // Scope Charge Code List
			vo.setEtc1("");
			vo.setEtc2(event.getPriTriNoteConvVO().getTrfPfxCd());
			vo.setEtc3(event.getPriTriNoteConvVO().getTrfNo());
            list = command.searchScopeChargeCodeList(vo); 
            eventResponse.setCustomData("CHARGE_CD", list);            
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
     * ESM_PRI_3002 : Retrieve<br>
     * TRI Note 화면을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchNoteConversionInquiryList(Event e) throws EventException {
        EsmPri3003Event event = (EsmPri3003Event) e;
        TRINoteConversionProposalBC command = new TRINoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltPriTriNoteConvVO> list = command.searchNoteConversionList(event.getPriTriNoteConvVO());
            eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_3002 : OPEN <br>
     * TRI Note 화면로딩시 콤보정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchCommonNoteConversionInquiryList(Event e) throws EventException {
        //EsmPri3003Event event = (EsmPri3003Event) e;
        PRICommonBC command = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;		
		
        try {        	
        	////////////////////COMMON - START/////////////////////
            //APLICATION
            vo.setCd("CD01723");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_APPL_TP_CD", list);
            
            //CARGO TYPE
            vo.setCd("CD01701");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_PRC_CGO_TP_CD", list);
            
            //CAL.
            vo.setCd("CD01724");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_OP_CD", list);
                        
            //PAY TERM
            vo.setCd("CD01713");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PAY_TERM_CD", list);
            
            //US SVC MODE
            vo.setCd("CD01708");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_HNGR_BAR_TP_CD", list);
            //////////////////////COMMON - END///////////////////////
        	
        	//PER TYPE
        	list = command.searchAllPerCodeList(vo);
        	eventResponse.setCustomData("BKG_RAT_UT_CD", list);
			        	
			//CURRENCY
			list = command.searchAllCurrencyCodeList(vo);
			eventResponse.setCustomData("CURR_CD", list);
			/*
			//NOTE CONVERSION RULE CODE ( CONVERSION TYPE별)
            //추후에 변경할것.
			vo.setEtc1("T"); // 계약 유형: S->S/C,  R->RFA,  T->TRI
			vo.setEtc2("R"); // CONVERSION TYPE CODE
			list = command.searchNoteConvRuleMapgList(vo);
			eventResponse.setCustomData("RULE_CD", list);
						
            // Scope Charge Code List
			vo.setEtc1("");
			vo.setEtc2(event.getPriTriNoteConvVO().getTrfPfxCd());
			vo.setEtc3(event.getPriTriNoteConvVO().getTrfNo());
            list = command.searchScopeChargeCodeList(vo); 
            eventResponse.setCustomData("CHARGE_CD", list);            
            */
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_3005 : OPEN <br>
     * Tariff Fomula Rule 화면로딩시 콤보정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchCommonTRIFomulaRuleList(Event e) throws EventException {
        //EsmPri3005Event event = (EsmPri3005Event) e;
        PRICommonBC command = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;		
		
        try {        	
        	//TARIFF CODE
        	list = command.searchTariffCodeList(vo);
            eventResponse.setCustomData("SRCH_TRF_CD", list);
        	
        	////////////////////COMMON - START/////////////////////

			//TYPE
            vo.setCd("CD01710");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RULE_APPL_CHG_TP_CD", list);
            
            //APLICATION
            vo.setCd("CD01723");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_APPL_TP_CD", list);
            
            //CARGO TYPE
            vo.setCd("CD01701");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_PRC_CGO_TP_CD", list);
            
            //CAL.
            vo.setCd("CD01724");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_OP_CD", list);
                        
            //PAY TERM
            vo.setCd("CD01713");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PAY_TERM_CD", list);
            
            //US SVC MODE
            vo.setCd("CD01729");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_USA_SVC_MOD_CD", list);
            
            //RECEIVING TERM
            vo.setCd("CD02192");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_RCV_TERM_CD", list);
            
            //DELIVERY TERM
            vo.setCd("CD02191");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_DE_TERM_CD", list);
            //////////////////////COMMON - END///////////////////////
        	
        	//PER TYPE  
        	list = command.searchAllPerCodeList(vo);
        	eventResponse.setCustomData("BKG_RAT_UT_CD", list);
			        	
			//CURRENCY
			list = command.searchAllCurrencyCodeList(vo);
			eventResponse.setCustomData("CURR_CD", list);
			
			//PER TYPE(in S/C)
        	list = command.searchAllPerCodeList(vo);
        	eventResponse.setCustomData("CONV_RAT_UT_CD", list);
        	
        	//CARGO TYPE(in S/C)
            vo.setCd("CD01701");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_CGO_TP_CD", list);
/*
			//NOTE CONVERSION RULE CODE ( CONVERSION TYPE별)
            //추후에 변경할것.
			vo.setEtc1("T"); // 계약 유형: S->S/C,  R->RFA,  T->TRI
			vo.setEtc2("F"); // CONVERSION TYPE CODE
			list = command.searchNoteConvRuleMapgList(vo);
			eventResponse.setCustomData("RULE_CD", list);
						
            // Scope Charge Code List
			vo.setEtc1("");
			vo.setEtc2(event.getPriTriNoteConvVO().getTrfPfxCd());
			vo.setEtc3(event.getPriTriNoteConvVO().getTrfNo());
            list = command.searchScopeChargeCodeList(vo); 
            eventResponse.setCustomData("CHARGE_CD", list);            
  */          
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_PRI_3005 : Retrieve<br>
     * Tariff Fomula Rule의 Conversion 정보을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchTRIFomulaRuleList(Event e) throws EventException {
        EsmPri3005Event event = (EsmPri3005Event) e;
        TRINoteConversionProposalBC command = new TRINoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltPriTriNoteConvVO> list = command.searchNoteConversionList(event.getPriTriNoteConvVO());
            eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }

        return eventResponse;
    }
    
    /**
     * ESM_PRI_3005 : Save<br>
     * Tariff Fomula Rule 데이터의 멀티 트랜잭션을 처리한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageTRIFomulaRule(Event e) throws EventException {
        EsmPri3005Event event = (EsmPri3005Event) e;
        TRINoteConversionProposalBC command = new TRINoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            command.manageTRIFomulaRule(event.getPriTriNoteVO(), account);
            command.manageNoteConversion(event.getPriTriNoteConvListVOs(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_3005 : Copy<br>
     * Tariff Fomula Rule 데이터를 복사한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse copyTRIFomulaRule(Event e) throws EventException {
        EsmPri3005Event event = (EsmPri3005Event) e;
        TRINoteConversionProposalBC command = new TRINoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            command.manageTRIFomulaRule(event.getPriTriNoteVO(), account);
            command.manageNoteConversion(event.getPriTriNoteConvListVOs(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00110",new String[]{}).getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_3005 : CONFIRM<br>
     * Tariff Fomula Rule 데이터를 Confirmation 한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse confirmTRIFomulaRule(Event e) throws EventException {
        EsmPri3005Event event = (EsmPri3005Event) e;
        TRINoteConversionProposalBC command = new TRINoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            command.confirmTRIFomulaRule(event.getPriTriNoteVO(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00103",new String[]{}).getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_3005 : DELETE <br>
     * Tariff Fomula Rule 데이터를 삭제 한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse deleteTRIFomulaRule(Event e) throws EventException {
        EsmPri3005Event event = (EsmPri3005Event) e;
        TRINoteConversionProposalBC command = new TRINoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            command.deleteTRIFomulaRule(event.getPriTriNoteVO());
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00102",new String[]{}).getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_3005 : CONFIRM CANCEL<br>
     * Tariff Fomula Rule 데이터를 Confirm Cancel 한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelTRIFomulaRule(Event e) throws EventException {
        EsmPri3005Event event = (EsmPri3005Event) e;
        TRINoteConversionProposalBC command = new TRINoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            command.cancelTRIFomulaRule(event.getPriTriNoteVO(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00104",new String[]{}).getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    
    /**
     * ESM_PRI_3005 : TARIFF CODE COMBO <br>
     * Conversion Code 에 해당하는 RULE, CHARGE CODE를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRuleChargeCodeList(Event e) throws EventException {
        EsmPri3005Event event = (EsmPri3005Event) e;
        TRINoteConversionProposalBC command = new TRINoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltCdListVO> list = command.searchRuleChargeCodeList(event.getPriTriNoteConvVO());
            eventResponse.setRsVoList(list);            
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }

        return eventResponse;
    }
    
    /**
     * ESM_PRI_3005 : SERVICE SCOPE COMBO <br>
     * Tariff Fomula Rule 화면의 Note정보를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchTRIFomulaRuleInfo(Event e) throws EventException {
        EsmPri3005Event event = (EsmPri3005Event) e;
        TRINoteConversionProposalBC command = new TRINoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
        	
            List<PriTriNoteVO> list = command.searchTRIFomulaRuleInfo(event.getPriTriNoteVO());            
            //사용자권한 정보를 넘긴다.
            String authFlag = command.searchAuthScopeCount(event.getPriTriNoteVO(), account);
                        
            eventResponse.setRsVoList(list);
            eventResponse.setETCData("AUTH_YN", authFlag);
            
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }

        return eventResponse;
    }
    
    /**
     * ESM_PRI_3006 : Retrieve<br>
     * Tariff Fomula Rule의 Conversion 정보을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchTRIFomulaRuleInquiryList(Event e) throws EventException {
        EsmPri3006Event event = (EsmPri3006Event) e;
        TRINoteConversionProposalBC command = new TRINoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltPriTriNoteConvVO> list = command.searchNoteConversionList(event.getPriTriNoteConvVO());
            eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }

        return eventResponse;
    }
    
    /**
     * ESM_PRI_3006 : SERVICE SCOPE COMBO <br>
     * Tariff Fomula Rule 화면의 Note정보를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchTRIFomulaRuleInfoInquiry(Event e) throws EventException {
        EsmPri3006Event event = (EsmPri3006Event) e;
        TRINoteConversionProposalBC command = new TRINoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<PriTriNoteVO> list = command.searchTRIFomulaRuleInfo(event.getPriTriNoteVO());
            eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }

        return eventResponse;
    }
    
	/*
     * ESM_PRI_3006 : OPEN<br>
     * Tariff Fomula Rule 화면에서 Tariff Code를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     
    private EventResponse searchServiceScopeCodeInquiryList(Event e) throws EventException {
        EsmPri3006Event event = (EsmPri3006Event) e;
        TRINoteConversionProposalBC command = new TRINoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltCdListVO> list = command.searchServiceScopeCodeList(event.getPriTriNoteConvVO());
            eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }

        return eventResponse;
    }
    */
    
    /**
     * ESM_PRI_3006 : OPEN <br>
     * Tariff Fomula Rule 화면로딩시 콤보정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchCommonTRIFomulaRuleInquiryList(Event e) throws EventException {
        //EsmPri3006Event event = (EsmPri3006Event) e;
        PRICommonBC command = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;		
		
        try {        	
        	//TARIFF CODE
        	list = command.searchTariffCodeList(vo);
            eventResponse.setCustomData("SRCH_TRF_CD", list);
        	
        	////////////////////COMMON - START/////////////////////
			//TYPE
            vo.setCd("CD01710");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RULE_APPL_CHG_TP_CD", list);
            
            //APLICATION
            vo.setCd("CD01723");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_APPL_TP_CD", list);
          /*  
            //CARGO TYPE
            vo.setCd("CD01701");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_PRC_CGO_TP_CD", list);
            
            //CAL.
            vo.setCd("CD01724");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_OP_CD", list);
                 */       
            //PAY TERM
            vo.setCd("CD01713");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PAY_TERM_CD", list);
            
            //US SVC MODE
            vo.setCd("CD01729");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_USA_SVC_MOD_CD", list);
            
            //RECEIVING TERM
            vo.setCd("CD02192");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_RCV_TERM_CD", list);
            
            //DELIVERY TERM
            vo.setCd("CD02191");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_DE_TERM_CD", list);
            //////////////////////COMMON - END///////////////////////
        	/*
        	//PER TYPE  
        	list = command.searchAllPerCodeList(vo);
        	eventResponse.setCustomData("BKG_RAT_UT_CD", list);
			        	
			//CURRENCY
			list = command.searchAllCurrencyCodeList(vo);
			eventResponse.setCustomData("CURR_CD", list);
			
			//PER TYPE(in S/C)
        	list = command.searchAllPerCodeList(vo);
        	eventResponse.setCustomData("CONV_RAT_UT_CD", list);
        	
        	//CARGO TYPE(in S/C)
            vo.setCd("CD02202");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_CGO_TP_CD", list);

			//NOTE CONVERSION RULE CODE ( CONVERSION TYPE별)
            //추후에 변경할것.
			vo.setEtc1("T"); // 계약 유형: S->S/C,  R->RFA,  T->TRI
			vo.setEtc2("F"); // CONVERSION TYPE CODE
			list = command.searchNoteConvRuleMapgList(vo);
			eventResponse.setCustomData("RULE_CD", list);
						
            // Scope Charge Code List
			vo.setEtc1("");
			vo.setEtc2(event.getPriTriNoteConvVO().getTrfPfxCd());
			vo.setEtc3(event.getPriTriNoteConvVO().getTrfNo());
            list = command.searchScopeChargeCodeList(vo); 
            eventResponse.setCustomData("CHARGE_CD", list);            
  */          
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
	/**
     * ESM_PRI_3004 : loadPage <br>
     * TRI Inquiry List 를 조회합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchTRIProposalTAAInquiryList(Event e) throws EventException {
        EsmPri3004Event event = (EsmPri3004Event) e;
        TAAProposalBC command = new TAAProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltTaaMnVO> list = command.searchTRIProposalTAAInquiryList(event.getPriTriMnVO());
            eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }

        return eventResponse;
    }
    
    
    
    /**
     * ESM_PRI_6084 : onLoad  <BR>
     * PRS- Cost Detail List 확인 리스트 조회 이벤트 처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCostDetailList(Event e) throws EventException {

        // PDTO(Data Transfer Object including Parameters)
        EsmPri6084Event event = (EsmPri6084Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        TRIProposalBC command1 = new TRIProposalBCImpl();
        try{
	        List<RsltTriPrsCostListVO> list = command1.searchCostDetailList(event.getRsltTriPrsCostListVO());
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_6084 : onClick(sheet1)  <BR>
     * PRS- Cost Detail List 확인 리스트 조회 이벤트 처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCostDetailInquiryList(Event e) throws EventException {

        // PDTO(Data Transfer Object including Parameters)
        EsmPri6084Event event = (EsmPri6084Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        TRIProposalBC command1 = new TRIProposalBCImpl();
        try{
	        List<RsltTriPrsCostDetailVO> list = command1.searchCostDetailInquiryList(event.getRsltTriPrsCostDetailVO());
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_6084 : Save <BR>
     * RATE관련 Cost, CMPB,OPB 값을 갱신하고 그 갱신여부를 Mark해둔다.
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse modifyPrsCost(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri6084Event event = (EsmPri6084Event) e;
        try {
            begin();
            TRIProposalBC command = new TRIProposalBCImpl();
            command.modifyPrsCost(event.getRsltTriPrsCostListVOS(), account);
            eventResponse.setUserMessage(new ErrorHandler("PRI01072").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    
    /**
     * ESM_PRI_6023 : OK <BR>
     * Pre CM/OP Simulation Cost관련 Cost, CMPB,OPB 값을 갱신.
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse modifyPrsSimulationCost(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri6084Event event = (EsmPri6084Event) e;
        try {
//            begin();
//            TRIProposalBC command = new TRIProposalBCImpl(); 
//            command.modifyPrsSimulationCost(event.getRsltTriPrsCostListVOS(),account); //여기 안의 로직은 calc logic에서 호출한다.
//            eventResponse.setUserMessage(new ErrorHandler("PRI01072").getUserMessage());
//            commit();
            begin();
            TRIProposalBC command = new TRIProposalBCImpl();
            SCRateProposalBC commandForCopy = new SCRateProposalBCImpl();
            CalculateBC commandForCalculation = new CalculateBCImpl();
            
            //command.modifyPrsSimulationCost(event.getRsltPriPrsCostListVOS(),account);
            
            List<RsltTriPrsCostListVO> listRsltPriPrsCostListVO = new ArrayList<RsltTriPrsCostListVO>();
            String newRoutCsNo = null;
            String newRoutCsSrcDt = null;
            RsltTriPrsCostListVO[] rsltTriPrsCostListVOs =event.getRsltTriPrsCostListVOS() ;
            InPriPrsRoutCsVO inPriPrsRoutCsVO = event.getInPriPrsRoutCsVO();
            rsltTriPrsCostListVOs[0].setIbflag("U");
            rsltTriPrsCostListVOs[0].setUsdRoutCsSelFlg("N");
            rsltTriPrsCostListVOs[0].setUpdUsrId(account.getUsr_id());
            listRsltPriPrsCostListVO.add(rsltTriPrsCostListVOs[0]);
            
            
            //POL(TERM),POD(TERM)의 조합이 정확한지 검사 한다.
            List<RsltPriCostSimulationCheckRouteVO> checkList =  command.searchCostSimulationCheckRoutList( event.getInCostSimulationCheckRouteVO());
            if( checkList.size() == 0 ){
            	//route와 term을 잘 못 입력 하였다.
            	throw new EventException(new ErrorHandler("PRI03021").getMessage());
            }
            
            //0. PRI_PRS_BAT에서  pgm_no = 'ESM_PRI_T001'인 ROW의
            //  PARA_INFO_CTNT(ROUT_CS_SRC_DT)  , PRS_BAT_ID(ROUT_CS_CLSS_NO)를 SELECT한다.
            RsltRouteCaseCostVersionVO rsltRouteCaseCostVersionVO = commandForCopy.searchRouteCaseCostVersion( ); // <--
         
 
            
            //1. 새로운 Rout_cs_no를 select한다. 
//            RsltNewRoutCaseNoVO rsltNewRoutCaseNoVO  = commandForCopy.searchNewRouteCaseNo(rsltRouteCaseCostVersionVO);
//            newRoutCsNo = rsltNewRoutCaseNoVO.getRoutCsNo();
//            newRoutCsSrcDt = rsltNewRoutCaseNoVO.getRoutCsSrcDt();
            RsltPriPrsRoutCsMaxRoutCsNoVO maxRoutCsVO = commandForCalculation.searchPriPrsRoutCsMaxRoutCsNoCalculate(null);
            newRoutCsNo = maxRoutCsVO.getRoutCsNo();
            newRoutCsSrcDt = rsltRouteCaseCostVersionVO.getParaInfoCtnt();
            log.debug("=====rsltNewRoutCaseNoVO==>"+newRoutCsNo);
            log.debug("=====rsltNewRoutCaseNoVO==>"+newRoutCsSrcDt);
            inPriPrsRoutCsVO.setUpdUsrId(account.getUsr_id());

            //2. PRI_PRS_ROUT_CS(BATCH)에 한건을 INSERT한다.(화면에서 입력받은값을 사용.)
            inPriPrsRoutCsVO.setRoutCsNo(newRoutCsNo);
            inPriPrsRoutCsVO.setRoutCsClssNo(rsltRouteCaseCostVersionVO.getPrsBatId()); // <-- rout_cs_clss_no
            commandForCalculation.managePriPrsRouteCase(inPriPrsRoutCsVO, account);
            
            
            //2. Route Case를 New Rout_cs_no를 이용해서 입력한다. (online)
             
            PriTriRtUsdRoutCsVO routCsVO = event.getPriTriRtUsdRoutCsVO() ;
            routCsVO.setRoutCsNo(newRoutCsNo);
            routCsVO.setRoutCsSrcDt(newRoutCsSrcDt);
            command.managePriTriRateUsedRouteCase(routCsVO,account);  

            //3. Route를 변경한다. usd_rout_cs_sel_flg ( Y --> N )
            command.modifyPrsRateCommodityRoute(listRsltPriPrsCostListVO);  
            log.debug("===== ******************************* modifyRateCommodityRoute 종료  ==>" ); 
            
            //4. PRI_PRS_USD_ROUT_CS_INFO,PRI_PRS_USD_ROUT_ACT_COST,PRI_PRS_USD_ROUT_ESTM_COST Table에 COA 데이터 카피 Insert
            log.debug("===== ******************************* copyBatchCostInfoToOnlineCostInfo 실행  ==>" ); 
			inPriPrsRoutCsVO.setRoutCsNo(newRoutCsNo); 
			inPriPrsRoutCsVO.setRoutCsSrcDt(newRoutCsSrcDt);
			commandForCalculation.copyCoaCostInfoToOnlineCostInfo(inPriPrsRoutCsVO, account);
            log.debug("===== ******************************* copyBatchCostInfoToOnlineCostInfo 종료  ==>" ); 
            
            
            
            log.debug("===== ******************************* copyBatchCostInfoToOnlineCostInfoBatch 실행  ==>" ); 
            commandForCalculation.copyOnlineCostInfoToBatchCostInfo(inPriPrsRoutCsVO, account);
            log.debug("===== ******************************* copyBatchCostInfoToOnlineCostInfoBatch 종료  ==>" );
            
            //5. Calculate Batch Logic과 동일한 로직을 돌린다.
            command.modifyCalculateLogicData(listRsltPriPrsCostListVO); // XA Driver를 사용하면 문제가 생길수 있음 (Merge, with 문장)
            log.debug("===== *******************************  후 ==>");
            
            eventResponse.setUserMessage(new ErrorHandler("PRI01072").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }     
    

    /**
     * ESM_PRI_6085 : Retrieve , onLoad , onSaveEnd <BR>
     * PRS- Applicable Route, Surcharge Detail을 조회 처리합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateSurchargeList(Event e) throws EventException {
        EsmPri6085Event event = (EsmPri6085Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        TRIProposalBC command1 = new TRIProposalBCImpl();
        try{
	        RsltPrsSurchargeDetailListVO rsltPrsSurchargeDetailListVO = command1.searchRateSurchargeList(event.getInpPrsSurchargeDetailApplicableRouteVO());
	        eventResponse.setRsVoList(rsltPrsSurchargeDetailListVO.getRsltPrsSurchargeDetailApplicableRouteVOS());
	        eventResponse.setRsVoList(rsltPrsSurchargeDetailListVO.getRsltPrsSurchargeDetailVOS());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_6085 : Save <BR>
     * PRS- Surcharge Detail 내용을 추가,삭제,갱신처리 합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException 
     */
    private EventResponse manageRateSurcharge(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri6085Event event = (EsmPri6085Event) e;

        try {
            begin();
            TRIProposalBC command = new TRIProposalBCImpl();
            command.manageRateSurcharge(event.getPriTriRtScgVOS(), account);
//            eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_3008 : Open<br>
     * 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse openTRIProposalTAANoList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        List<RsltCdListVO> customData = null;

        try{
            // Service Scope Code List
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_3008 : Retrieve<br>
     * TRI Proposal TAA No List 를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchTRIProposalTAANoList(Event e) throws EventException {
        EsmPri3008Event event = (EsmPri3008Event) e;
        TAAProposalBC command = new TAAProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltTaaMnVO> list = command.searchTRIProposalTAANoList(event.getRsltTaaMnVO());
            eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }

        return eventResponse;
    }
    
    /**
     * ESM_PRI_3001 : Retrieve<br>
     * TRI Proposal List를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchTRIProposalInquiryList(Event e) throws EventException {
		EsmPri3013Event event = (EsmPri3013Event) e;
		TRIProposalBC command = new TRIProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltTriPropInquiryListVO> list = command.searchTRIProposalInquiryList(event.getTriPropParamVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

    /**
     * ESM_PRI_3014 : Send<br>
     * TRI Proposal Excel Data 를 첨부하여 Descartes 로 메일을 전송합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse sendMailTRIProposal(Event e) throws EventException {
        EsmPri3014Event event = (EsmPri3014Event) e;
        TRIProposalBC command = new TRIProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            TriPropSendMailVO triPropSendMailVO = event.getTriPropSendMailVO();
            begin();
            if (triPropSendMailVO == null || JSPUtil.getNull(triPropSendMailVO.getFileKey()).equals("")) {
                throw new EventException(new ErrorHandler("PRI00120",new String[]{}).getMessage());
            }
            command.modifyPriTriRtSendDate(event.getPriTriRtVOs(), account);    // send date update
            command.sendMailTRIProposal(triPropSendMailVO, account);
            eventResponse.setUserMessage(new ErrorHandler("PRI00119").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00120",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    
    /**
     * Calculate Batch를 비동기 적으로 실행킨다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse executeCalculate_BATCH(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri3001Event event = (EsmPri3001Event)e;
        TRIProposalBC command = new TRIProposalBCImpl();
        PRICommonBC comCommand = new PRICommonBCImpl();
        String prsBatId = "";

        try{
 
 
        	
        	PriPrsBatVO priPrsBatVO = command.searchMonitorCalculateParam(event.getPriTriRtVO());
        	PrsBatchVO prsBatchVO = comCommand.searchPrsBatch(priPrsBatVO);
            
            
            //pri_Prs_Bat table에 데이터가 있을경우
            if( prsBatchVO != null ){
            	String status  = command.monitorCalculate(prsBatchVO);
            	
            	if( "0".equals(status)  // Nothing 아직 상태모름
            			|| "1".equals(status) // running
            			|| "8".equals(status) // INACTIVE	실행대기
            			|| "12".equals(status)// QUE_WAIT	 로드밸런싱 대기 
            			){
            		//이미 실행중이라면 에러 처리한다.
            		 throw new EventException(new ErrorHandler("PRI03019",new String[]{account.getUsr_id()}).getMessage());
            	}
            }
            
            
        	priPrsBatVO = command.executeCalculate_BATCH(event.getPriTriRtVO(),account); 
        	
            if( priPrsBatVO != null ){ 
            	begin();
            	comCommand.addPrsBatch(priPrsBatVO,account);
            	prsBatId = priPrsBatVO.getPrsBatId();
            	commit();
            }
            
            eventResponse.setETCData("JOB_ID",prsBatId);

        }catch(EventException ex){
        	rollback();
            throw ex;
        }catch(Exception ex){
        	rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }finally{

        }
        return eventResponse;
    }
    
    
    /**
     * Calculate Batch를 비동기 적으로 실행킨다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse executeCalculate(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri3001Event event = (EsmPri3001Event)e;
        TRIProposalBC command = new TRIProposalBCImpl();
        PRICommonBC comCommand = new PRICommonBCImpl();
//        String prsBatId = "";;

        try{
//			begin();
//			//MAIN에 update  해준 다.
//			PriPrsInCalculateVO priPrsInCalculateVO = new PriPrsInCalculateVO();
//			priPrsInCalculateVO.setTriPropNo( event.getPriTriRtVO().getTriPropNo());
//			priPrsInCalculateVO.setAmdtSeq(event.getPriTriRtVO().getAmdtSeq());
//			command.modifyPriTriMnCalcFlgCalculate( priPrsInCalculateVO);
//			commit();
			
        	PriPrsBatVO priPrsBatVO = command.searchMonitorCalculateParam(event.getPriTriRtVO());
        	//PrsBatchVO prsBatchVO = comCommand.searchPrsBatch(priPrsBatVO);

//        	begin();
//			priPrsBatVO.setPrsBatId("0");
//			priPrsBatVO.setParaInfoCtnt(priPrsBatVO.getParaInfoCtnt() + account.getUsr_id() );
//        	comCommand.addPrsBatch(priPrsBatVO,account);
//        	commit();
			
			begin();
			eventResponse.setETCData("BackEndJobKey", command.executeCalculate(event.getPriTriRtVO(),priPrsBatVO,account));
			commit();

        	
//        	PriPrsBatVO priPrsBatVO = command.searchMonitorCalculateParam(event.getPriTriRtVO());
//        	PrsBatchVO prsBatchVO = comCommand.searchPrsBatch(priPrsBatVO);
//            
//            
//            //pri_Prs_Bat table에 데이터가 있을경우
//            if( prsBatchVO != null ){
//            	String status  = command.monitorCalculate(prsBatchVO);
//            	
//            	if( "0".equals(status)  // Nothing 아직 상태모름
//            			|| "1".equals(status) // running
//            			|| "8".equals(status) // INACTIVE	실행대기
//            			|| "12".equals(status)// QUE_WAIT	 로드밸런싱 대기 
//            			){
//            		//이미 실행중이라면 에러 처리한다.
//            		 throw new EventException(new ErrorHandler("PRI03019",new String[]{account.getUsr_id()}).getMessage());
//            	}
//            }
//            
//            
//        	priPrsBatVO = command.executeCalculate(event.getPriTriRtVO(),account); 
//        	
//            if( priPrsBatVO != null ){ 
//            	begin();
//            	comCommand.addPrsBatch(priPrsBatVO,account);
//            	prsBatId = priPrsBatVO.getPrsBatId();
//            	commit();
//            }
//            
//            eventResponse.setETCData("JOB_ID",prsBatId);

        }catch(EventException ex){
        	rollback();
            throw ex;
        }catch(Exception ex){
        	rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }finally{

        }
        return eventResponse;
    }
    
	/**
	 * BackEndJob : interval <br>
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse comBackEndJobVOs(Event e) throws EventException {
		String key = (String)e.getAttribute("KEY");
		String status = null;
		CMSummaryBC command = new CMSummaryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			status = command.comBackEndJobVOs(key);			
			eventResponse.setETCData("jb_sts_flg", status);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * BackEndJob : search <br>
	 * BackEndJob 결과 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse comBackEndJobSearchListGetResult(Event e) throws EventException {
		String key = (String)e.getAttribute("KEY");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<DBRowSet> rowSets = new ArrayList<DBRowSet>();
		try {
			rowSets.add((DBRowSet)BackEndJobResult.loadFromFile(key));
			//eventResponse.setETCData("RESULT",(String)BackEndJobResult.loadFromFile(key));
			eventResponse.setRsVoList(rowSets);		
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	    

    /**
     * Calculate Batch의 실행 상태를 조회 한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse monitorCalculate(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri3001Event event = (EsmPri3001Event)e;
        TRIProposalBC command = new TRIProposalBCImpl();
        PRICommonBC comCommand = new PRICommonBCImpl();
        String batchId = "";

        try{
        	PriPrsBatVO priPrsBatVO = command.searchMonitorCalculateParam(event.getPriTriRtVO());
        	PrsBatchVO prsBatchVO = comCommand.searchPrsBatch(priPrsBatVO);
            String status  = command.monitorCalculate(prsBatchVO);
            
            if( prsBatchVO != null ){
            	batchId = prsBatchVO.getPrsBatId();
            }
            //SUCCESS일경우 PRI_PRS_BAT의 PRS_BAT_ERR_VAL의 결과를 이용한다.
            if( "4".equals(status) ){
            	// null도 success로 간주한다.
            	if( prsBatchVO.getPrsBatErrVal() != null 
            			&& prsBatchVO.getPrsBatErrVal().length() != 0
            			&& !"0".equals( prsBatchVO.getPrsBatErrVal() )){//SUCCESS가 아니면 FAIL처리            	
            		status = "90";
            	}
            	 
            }        
            eventResponse.setETCData("JOB_ID",batchId);
            eventResponse.setETCData("BATCH_STATUS",status);

        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
	 * ESM_PRI_3013 : Load Page <br>
	 * 기본 Code List를 초기화한다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initTRIProposalComboData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		PRICommonBC command = new PRICommonBCImpl();
//		CodeUtil cdUtil = CodeUtil.getInstance();
		List<RsltCdListVO> customData = null;
//		List<CodeInfo> codeInfos = null;
		
		try {
			// Tariff Code
			customData = command.searchTariffCodeList(new RsltCdListVO());
			eventResponse.setCustomData("trfCd", customData);
			
			// Per code
			RsltCdListVO rsltCdListVO = new RsltCdListVO();
			rsltCdListVO.setEtc5("TRI");
			customData = command.searchPerCodeList(rsltCdListVO);
			eventResponse.setCustomData("ratUtCd", customData);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
    /**
     * ESM_PRI_3019 : POPUP - OPEN 시 자동조회<br>
     * TAA Creation & Amendment View 를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchTRIProposalTAAViewList(Event e) throws EventException {
        EsmPri3019Event event = (EsmPri3019Event) e;
        TAAProposalBC command = new TAAProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            RsltTaaMnVO paramVo = event.getRsltTaaMnVO();   
            RsltTaaListVO vo = command.searchTRIProposalTAAList(paramVo);

            eventResponse.setRsVoList(vo.getRsltTaaMnVOs());
            eventResponse.setRsVoList(vo.getRsltTaaTriListVOs());
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }

        return eventResponse;
    }

}