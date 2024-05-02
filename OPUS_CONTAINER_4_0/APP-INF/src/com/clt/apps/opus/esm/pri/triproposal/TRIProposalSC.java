/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TRIProposalSC.java
 *@FileTitle : TRI Creation & Amendment
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal;

import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropCustInfoVO;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.basic.TAAProposalBC;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.basic.TAAProposalBCImpl;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.event.EsmPri3004Event;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.event.EsmPri3007Event;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.event.EsmPri3008Event;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.event.EsmPri3009Event;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.event.EsmPri3017Event;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.vo.PriTaaListVO;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.vo.RsltTaaListVO;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.vo.RsltTaaMnVO;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.vo.RsltTaaTriListVO;
import com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.basic.TRIGRICalculationProposalBC;
import com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.basic.TRIGRICalculationProposalBCImpl;
import com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.event.EsmPri3010Event;
import com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.vo.RsltGriCalcGrpListVO;
import com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.vo.RsltGriCalcListVO;
import com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.basic.TRINoteConversionProposalBC;
import com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.basic.TRINoteConversionProposalBCImpl;
import com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.event.EsmPri3005Event;
import com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.event.EsmPri3006Event;
import com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.vo.PriTriNoteConvListVO;
import com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.vo.RsltPriTriNoteConvVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.basic.TRIProposalBC;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.basic.TRIProposalBCImpl;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.event.EsmPri3001Event;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.event.EsmPri3002Event;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.event.EsmPri3003Event;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.event.EsmPri3013Event;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.event.EsmPri3015Event;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.event.EsmPri3018Event;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.integration.TRIProposalDBDAO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.RsltTriPropDtlListVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.RsltTriPropInquiryListVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.RsltTriPropListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpCtrtPtyVO;
import com.clt.syscommon.common.table.PriTriNoteVO;
import com.clt.syscommon.common.table.PriTriRtVO;

/**
 * TRIProposal Business Logic ServiceCommand - handling business transaction about TRIProposal
 * 
 * @author
 * @see TRIProposalDBDAO
 * @since J2EE 1.6
 */

public class TRIProposalSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * preceding process for TRIProposal system biz scenario <br>
	 * related objects creation<br>
	 */
	public void doStart() {
		log.debug("Starting TRIProposalSC");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * TRIProposal system biz scenario closing<br>
	 * clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("Closing TRIProposalSC");
	}

	/**
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
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {    
                eventResponse = searchTRIProposalTAACheckUseBkg(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {    // Customer
                eventResponse = searchProposalCustomerInfo(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {    // Retrieving a authority of approval
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
        /*else if (e.getEventName().equalsIgnoreCase("EsmPri6084Event")) {
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
        }*/
        // ============================ESM_PRI_6085_Start====================================
        /*else if (e.getEventName().equalsIgnoreCase("EsmPri6085Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchRateSurchargeList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageRateSurcharge(e);
            }
            // =============================ESM_PRI_6085_end===================================
        }*/
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
		return eventResponse;
	}

	///////////////////////// ESM_PRI_3001 Start /////////////////////////
	
    /**
     * ESM_PRI_3001 : Retrieve<br>
     * Retrieving TRI Proposal List<br>
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
     * Retrieving TRI Proposal - Rate and  Route information<br>
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
     * retireving wheather checking duplication of TRI Proposal Rate<br>
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
     * Handling multi transaction of TRI Proposal Route and  Rate data<br>
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
            if (newTriPropNo != null) {
            	command.manageTRIRateProposal(event.getTriPropVO(), account, newTriPropNo);
            	eventResponse.setETCData("NEW_PROP_NO", newTriPropNo);
            } else {
            	command.manageTRIRateProposal(event.getTriPropVO(), account, null);
            	eventResponse.setETCData("NEW_PROP_NO", null);
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
     * ESM_PRI_3001 : Request<br>
     * Reuqesting a approval of TRI Proposal data<br>
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
     * Requesting a approval of multiple TRI Proposal datas<br>
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
     * Amending TRI Proposal DATA<br>
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
     * Handling C/Offer of TRI Proposal data<br>
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
     * Approving TRI Proposal data<br>
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
     * Approving several TRI Proposal datas<br>
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
     * Publishing TRI Proposal data<br>
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
            
            // Sending mail - comment (2016.12.15)
            // command.sendMailTRIProposalPublish(event.getPriTriRtVO(), account);
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
     * Publishing several TRI Proposal datas<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse publishMultiTRIRateProposal(Event e) throws EventException {
        EsmPri3018Event event = (EsmPri3018Event) e;
        TRIProposalBC command = new TRIProposalBCImpl();
        TRINoteConversionProposalBC cmdConv = new TRINoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            command.publishMultiTRIRateProposal(event.getPriTriRtVOs(), account);
            cmdConv.publishMultiTRIRateProposal(event.getPriTriRtVOs(), account);
            
//            Send email - Comment (2016.12.15)
//            PriTriRtVO[] priTriRtVOs = event.getPriTriRtVOs();
//            if (priTriRtVOs != null && priTriRtVOs.length > 0) {
//                // sending mail
//                for (int i = 0; i < priTriRtVOs.length; i++) {
//                    command.sendMailTRIProposalPublish(priTriRtVOs[i], account);
//                }
//            }
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
     * Assigning TRI Number to TRI Proposal data<br>
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
     * Rollback TRI Proposal data into previous status<br>
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
     * Rollback Serveral TRI Proposal into its previous status<br>
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
     * Retrieving GRI Calculation Header list<br>
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
     * Retrieving GRI Calculation list<br>
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
     * Checking wheather Rate with un-completing GRI exists or not when clicking NEW<br>
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
     * Handling CUD transaction of GRI Calculation data<br>
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
     * Applying GRI Calculation to Rate data.<br>
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
     * Cancelling applied GRI Calculation<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelGRICalculation(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri3010Event event = (EsmPri3010Event) e;
        TRIGRICalculationProposalBC griCommand = new TRIGRICalculationProposalBCImpl();
        TRINoteConversionProposalBC cmdConv = new TRINoteConversionProposalBCImpl();

        try {
            begin();
            cmdConv.cancelGRICalculation(event.getTriPropGRIVO(), account);
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
     * REtrieving amend sequence combo item when modifying TAA No value<br>
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
     * Retrieving Customer information<br>
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
     * Retrieving TRI Proposal TAA Main &TRI List<br>
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
     * Saving TRI Proposal TAA Information<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageTRIProposalTAA(Event e) throws EventException {
        EsmPri3007Event event = (EsmPri3007Event) e;
        TAAProposalBC command = new TAAProposalBCImpl();
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
                // In case of new data
                if (JSPUtil.getNull(rsltTaaMnVOs[0].getTaaPropNo()).equals("")) {
                    taaNo = command.searchTRIProposalTAANo(account.getOfc_cd());    // new TAA_NO
                    taaPropNo = command.searchTRIProposalTAAPropNo(account.getOfc_cd());    // new TAA_PROP_NO
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

                // TAA Main
                command.manageTRIProposalTAAMain(rsltTaaMnVOs, account);
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
     * Confirming TRI Proposal TAA Information<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse confirmTRIProposalTAA(Event e) throws EventException {
        EsmPri3007Event event = (EsmPri3007Event) e;
        TAAProposalBC command = new TAAProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            RsltTaaMnVO rsltTaaMnVO = event.getRsltTaaMnVO();
            
            if (rsltTaaMnVO == null || JSPUtil.getNull(rsltTaaMnVO.getTaaNo()).equals("")) {
                // There is no data to save.
                new EventException (new ErrorHandler("PRI00301",new String[]{}).getMessage());
            } else {
	            command.confirmTRIProposalTAA(rsltTaaMnVO, account);
	            rsltTaaMnVO.setTaaSts("C"); // Confirm
            }
            eventResponse.setUserMessage(new ErrorHandler("PRI00103").getUserMessage());
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
     * Checking wheather TRI Proposal TAA Information is used to Booking or not <br>
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
     * Cancelling a confiration of TRI Proposal TAA Information<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse confirmCancelTRIProposalTAA(Event e) throws EventException {
        EsmPri3007Event event = (EsmPri3007Event) e;
        TAAProposalBC command = new TAAProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();
            RsltTaaMnVO rsltTaaMnVO = event.getRsltTaaMnVO();
            if (rsltTaaMnVO == null || JSPUtil.getNull(rsltTaaMnVO.getTaaNo()).equals("")) {
                // There is no data to save.
                new EventException (new ErrorHandler("PRI00301",new String[]{}).getMessage());
            } else {
	            command.confirmCancelTRIProposalTAA(rsltTaaMnVO, account);
	            rsltTaaMnVO.setTaaSts("D"); // Confirm Cancel
            }
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
     * Deleting a information of TRI Proposal TAA Sequence<br>
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
            } else {
            	command.cancelTRIProposalTAA(rsltTaaMnVO, account);
            }
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
     * Retrieving a approval authority about TRI Proposal TAA <br>
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
     * Amending TRI Proposal TAA Information<br>
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
     * Retrieving Tariff code using Service Scope Code<br>
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
     * Retrieving TRI Proposal Select List<br>
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
     * REtrieving TRI Note screen<br>
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
     * Pasting copied TRI NOTE CONVERSION data<br>
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
     * Hadnling multi transaction of TRI Note data <br>
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
     * Copying TRI Note data<br>
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
     * Retreiving combo information when loading TRI Note screen<br>
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

			//NOTE CONVERSION RULE CODE ( By CONVERSION TYPE)
			vo.setEtc1("T"); // Agreement type: S->S/C,  R->RFA,  T->TRI
			vo.setEtc2("R"); // CONVERSION TYPE CODE
			list = command.searchNoteConvRuleMapgList(vo);
			eventResponse.setCustomData("RULE_CD", list);
						
            // Scope Charge Code List
			vo.setEtc1("");
			vo.setEtc2(event.getPriTriNoteConvVO().getTrfPfxCd());
			vo.setEtc3(event.getPriTriNoteConvVO().getTrfNo());
            list = command.searchScopeChargeCodeList(vo); 
            eventResponse.setCustomData("CHARGE_CD", list);  
            
            //B/I - PRICING E-SERVICE CONVERSION TYPE CODE
            vo.setCd("CD02582");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ESVC_TP_CD", list);
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
     * ESM_PRI_3002 : Retrieve<br>
     * Retrieving TRI Note screen.<br>
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
     * Retreiving combo information when loading TRI Note screen<br>
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
			
			//B/I - PRICING E-SERVICE CONVERSION TYPE CODE
            vo.setCd("CD02582");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ESVC_TP_CD", list);
			
			/*
			//NOTE CONVERSION RULE CODE ( By CONVERSION TYPE)
			vo.setEtc1("T"); // Agreement: S->S/C,  R->RFA,  T->TRI
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
     * Retreiving combo information when loading Tariff Fomula Rulescreen<br>
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
			//NOTE CONVERSION RULE CODE (By CONVERSION TYPE )
			vo.setEtc1("T"); // Agreement type: S->S/C,  R->RFA,  T->TRI
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
     * Retrieving  Conversion Information of Tariff Fomula Rule<br>
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
     * handling multi transaction of Tariff Fomula Rule data<br>
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
     * Copying Tariff Fomula Rule data<br>
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
     * Confirming Tariff Fomula Rule data<br>
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
     * Deleting Tariff Fomula Rule data<br>
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
     * Canceled confirmed Tariff Fomula Rule data<br>
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
     * retrieving  RULE, CHARGE CODE about Conversion Code<br>
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
     * Retrieving  Note Information on Tariff Fomula Rule screen<br>
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
            //사용자권한 Information를 넘긴다.
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
     * Retrieving Conversion Information of Tariff Fomula Rule<br>
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
     * Retrieving  Note Information on Tariff Fomula Rule screen<br>
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
     * Retrieving   Tariff Code on Tariff Fomula Rule screen<br>
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
     * Retrieving  Combo Information when loading Tariff Fomula Rule screen.<br>
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

			//NOTE CONVERSION RULE CODE (By CONVERSION TYPE)
			vo.setEtc1("T"); // Agreement type: S->S/C,  R->RFA,  T->TRI
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
     * Retrieving TRI Inquiry List<br>
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
     * ESM_PRI_3008 : Open<br>
     * Retrieving Combo Item on a screen<br>
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
     * Retrieving TRI Proposal TAA No List<br>
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
     * Retrieving TRI Proposal List<br>
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
	 * ESM_PRI_3013 : Load Page <br>
	 * Initializing basic Code list<br>
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
}