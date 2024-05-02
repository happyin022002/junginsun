/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESCommonSC.java
*@FileTitle : TES Common Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.common;

import com.clt.apps.opus.esd.tes.common.tescommon.basic.TESCommonBC;
import com.clt.apps.opus.esd.tes.common.tescommon.basic.TESCommonBCImpl;
import com.clt.apps.opus.esd.tes.common.tescommon.event.TESCommonEvent;
import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBC;
import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBCImpl;
import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.event.TESInvoiceCommonEvent;
import com.clt.apps.opus.esd.tpb.common.combo.basic.CommonCodeBC;
import com.clt.apps.opus.esd.tpb.common.combo.basic.CommonCodeBCImpl;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;

/**
 * ESD Business Logic ServiceCommand<br>
 * Handling business transaction for ESD<br>
 *
 * @author byungheeyoo
 * @see TESCommonEventResponse,TESCommonDBDAO
 * @since J2EE 1.4
 */
public class TESCommonSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	/**
	 * ESD preceding process for biz scenario<br>
	 * TESCommon preceding process for biz scenario<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account=getSignOnUserAccount();
		} catch (Exception e) {
			log.error("TESCommonSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * ESD Handling for the end of working scenario<br>
	 * TESCommon Clearing object by the end of work scenario<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("TESCommonSC 종료");
	}


	/**
	 * ESD Handling working scenario of each event<br>
	 *
	 * @param e 
	 * @return  EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

		log.debug("\n\n ### [TESCommonSC] ~~~~~~"+JSPUtil.getNull(e.getEventName())+"~~~~\n");
		log.debug("\n ### [TESCommonSC] f_cmd:"+e.getFormCommand().getCommand()+"~~~~\n");
		
		EventResponse eventResponse = null;
		
		/**
		 * TES Entire common
		 */
		if (e.getEventName().equalsIgnoreCase("TESCommonEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCostOFC(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCurrencyList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = validateCostOFC(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = validateYardCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = getDBdate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = validateVndrCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchYdCostCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = validateYardCodeNsearchYdCostCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchTESCostCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchCntrTPCDList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchCntrSZCDList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchCntrTPSZCDList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchLaneList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchAutoTESTmlSoCostCDList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchManualTESTmlSoCostCDList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = searchTESInvoiceCommonCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = searchAgreementCostCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				eventResponse = searchLaneCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = validateYardCode2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH21)) {
				eventResponse = searchInvNoDupChk(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH22)) {
				eventResponse = searchSubTrdCodeList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH23)) {
				eventResponse = searchBkgCntrTPCDList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = validateVndrCode2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = validateCostOFC2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = validateInvOFC(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = getNodeCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) {
				eventResponse = searchMDMAccount(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST07)) {
				eventResponse = searchAuthOfcCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST08)) {
				eventResponse = new GeneralEventResponse();
				eventResponse.setETCData("successFlag","success");
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST09)) {
				eventResponse = searchEQNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
				eventResponse = searchAgmtCostCodeList(e);
			}
			
		/**
		 * TES INVOICE Coomon
		 */
		} else if (e.getEventName().equalsIgnoreCase("TESInvoiceCommonEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getAgmtCurrCD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = getN3ptyBilCSCD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = isValidErrInvNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = getAgmtSts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = getWHTmode(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
//				eventResponse = validateEDIInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {		
				// TPB BillingCase Code
				eventResponse = searchBillingCaseCodeByTES(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {		//MGSet
				eventResponse = getMgstNos(e);
			}
			
		} 
		return eventResponse;
	}

	/**
	 * ofc_cd Get Withholding tax input mode
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getWHTmode(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][getWHTmode] \n");
		TESInvoiceCommonEvent event = (TESInvoiceCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESInvoiceCommonBC command = new TESInvoiceCommonBCImpl();
			eventResponse = command.getWHTmode(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * (calc Calculation) Get agreement currency code
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getAgmtCurrCD(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][getAgmtCurrCD] \n");
		TESInvoiceCommonEvent	event			= (TESInvoiceCommonEvent)e;
		EventResponse			eventResponse	= null;

		try {
			TESInvoiceCommonBC	command	= new TESInvoiceCommonBCImpl();
			eventResponse	= command.getAgmtCurrCD(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * (calc Calculation) agreement retrieve status
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getAgmtSts(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][getAgmtSts] \n");
		TESInvoiceCommonEvent event = (TESInvoiceCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESInvoiceCommonBC command = new TESInvoiceCommonBCImpl();
			eventResponse = command.getAgmtSts(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * (TPB Calculation) COST CODE retrieve N3PTY_BIL_CS_CD
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getN3ptyBilCSCD(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][getN3ptyBilCSCD] \n");
		TESInvoiceCommonEvent event = (TESInvoiceCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESInvoiceCommonBC command = new TESInvoiceCommonBCImpl();
			eventResponse = command.getN3ptyBilCSCD(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse isValidErrInvNo(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][isValidErrInvNo] \n");
		TESInvoiceCommonEvent event = (TESInvoiceCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESInvoiceCommonBC command = new TESInvoiceCommonBCImpl();
			eventResponse = command.isValidErrInvNo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostOFC(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchCostOFC] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchCostOFC(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/** searchEQNo
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchEQNo(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchEQNo] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchEQNo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrencyList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchCurrencyList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchCurrencyList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateCostOFC(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][validateCostOFC] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.validateCostOFC(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateCostOFC2(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][validateCostOFC2] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.validateCostOFC2(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateInvOFC(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][validateInvOFC] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.validateInvOFC(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getNodeCode(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][validateInvOFC] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.getNodeCode(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateYardCode(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][validateYardCode] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.validateYardCode(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateYardCode2(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][validateYardCode2] \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= null;

		try {
			TESCommonBC		command	= new TESCommonBCImpl();
			eventResponse = (GeneralEventResponse)command.validateYardCode2(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getDBdate(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][getDBdate] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.getDBdate(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateVndrCode(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][validateVndrCode] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.validateVndrCode(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateVndrCode2(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][validateVndrCode2] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.validateVndrCode2(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYdCostCodeList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchYdCostCodeList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchYdCostCodeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateYardCodeNsearchYdCostCodeList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][validateYardCodeNsearchYdCostCodeList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.validateYardCodeNsearchYdCostCodeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTESCostCodeList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchTESCostCodeList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchTESCostCodeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/** searchAgmtCostCodeList
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchAgmtCostCodeList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchAgmtCostCodeList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchAgmtCostCodeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrTPCDList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchCntrTPCDList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchCntrTPCDList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrSZCDList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchCntrSZCDList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchCntrSZCDList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrTPSZCDList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchCntrTPSZCDList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchCntrTPSZCDList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchLaneList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchLaneList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAutoTESTmlSoCostCDList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchAutoTESTmlSoCostCDList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchAutoTESTmlSoCostCDList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManualTESTmlSoCostCDList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchManualTESTmlSoCostCDList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchManualTESTmlSoCostCDList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTESInvoiceCommonCodeList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchTESInvoiceCommonCodeList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchTESInvoiceCommonCodeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementCostCodeList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchAgreementCostCodeList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchAgreementCostCodeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneCodeList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchLaneCodeList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchLaneCodeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubTrdCodeList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchSubTrdCodeList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchSubTrdCodeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/** searchBkgCntrTPCDList
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchBkgCntrTPCDList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchBkgCntrTPCDList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchBkgCntrTPCDList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * EDI Invoice Validation
	 * @param tml_edi_so_ofc_cty_cd
	 * @param tml_edi_so_seq
	 * @exception EventException
	 */
//	private EventResponse validateEDIInvoice(Event e) throws EventException {
//		
//		log.debug("\n\n SC.validateEDIInvoice \n");
//
//		//
//		//
//		
//		com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0013Event event
//		 = (com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0013Event)e;
//		EventResponse eventResponse = null;
//
//		try {
//
//			TESInvoiceCommonBC command = new TESInvoiceCommonBCImpl();
//			command.validateEDIInvoice(event.getEventParams().get("tml_edi_so_ofc_cty_cd").toString(), event.getEventParams().get("tml_edi_so_seq").toString());
//		} catch (EventException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
//	}
	
	
	/**
	 * Search Third Party BillingCase Code
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBillingCaseCodeByTES(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchBillingCaseCodeByTES] \n");
		CommonCodeBC			command			= new CommonCodeBCImpl();
		TESInvoiceCommonEvent	event 			= (TESInvoiceCommonEvent)e;
		EventResponse			eventResponse	= null;

		try {
			
			eventResponse	= command.searchBillingCaseCodeByTES();
			eventResponse.setETCData("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
	}

	
	/**
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse getMgstNos(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][getMgstNos] \n");
		
		TESInvoiceCommonEvent event = (TESInvoiceCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESInvoiceCommonBC command = new TESInvoiceCommonBCImpl();
			eventResponse = command.getMgstNos(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
	}

	/**
	 * Search MDM_Account
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMDMAccount(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchMDMAccount] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;
		TESCommonBC command = null;
		
		try {
			command = new TESCommonBCImpl();
			
			begin();
			eventResponse = command.searchMDMAccount(event);
			commit();			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Search Authority AGMT, INV OFC
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthOfcCd(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchAuthOfcCd] ===========>\n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;
		TESCommonBC command = null;
		
		try {
			command = new TESCommonBCImpl();
			eventResponse = command.searchAuthOfcCd(event);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvNoDupChk(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchInvNoDupChk] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;
 
		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchInvNoDupChk(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
}
