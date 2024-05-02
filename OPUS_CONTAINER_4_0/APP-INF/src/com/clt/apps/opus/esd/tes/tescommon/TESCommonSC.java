/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : TESCommonSC.java
 *@FileTitle : TES Common Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016-03-08 KHS
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.tescommon;

import com.clt.apps.opus.esd.tes.tescommon.basic.TESCommonBC;
import com.clt.apps.opus.esd.tes.tescommon.basic.TESCommonBCImpl;
import com.clt.apps.opus.esd.tes.tescommon.event.TESCommonEvent;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * TES Business Logic ServiceCommand<br>
 * 
 * @author KHS
 * @see TESCommonEventResponse,TESCommonDBDAO
 * @since J2EE 1.4
 */
public class TESCommonSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	/**
	 * TES 업무 시나리오 선행작업<br>
	 * TESCommon업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * TES 업무 시나리오 마감작업<br>
	 * TESCommon업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug(":::::::::::::::::::::::::::::: TESCommonSC End !!! ::::::::::::::::::::::::::::::::::::::::::::");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * TESCommon업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("TESCommonEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND11)) {
				eventResponse = searchCurrencyCodeList(e); // Retrieve Currency Code List
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND12)) {
				eventResponse = searchCommonCodeList(e); // Retrieve Common Code List 
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND13)) {
				eventResponse = searchWhldTaxAmtMode(e); // Retrieve WHLD_TAX_AMT_MODE 
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND14)) {
				eventResponse = searchManualLgsCostCdList(e); // Retrieve Manual Lgs Cost Cd
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND15)) {
				eventResponse = searchServiceProviderName(e); // Retrieve Service Provider Name
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND16)) {
				eventResponse = searchInvDuplicateYN(e); // Retrieve Invoice Duplication YN
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND17)) {
				eventResponse = searchErrInvValidYN(e); // Retrieve Error Invoice Validation YN
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND18)) {
				eventResponse = searchYdCdCostCdList(e); // Retrieve Yard Code Validation & Cost Code List
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND19)) {
				eventResponse = searchOfcCd(e); // Retrieve Office Code 
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND20)) {
				eventResponse = searchSubTrdCdList(e); // Retrieve Sub Trade Code List
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND21)) {
				eventResponse = searchAgmtCostCdList(e); // Retrieve Agreement Cost Code List
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND22)) {
				eventResponse = searchAgmtStatusCd(e); // Retrieve Agreement Status Code
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND23)) {
				eventResponse = searchSLanCd(e); // Retrieve SLane Code
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND24)) {
				eventResponse = searchCostOfcValidYN(e); // Retrieve Cost Office Validation YN
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND25)) {
				eventResponse = searchAgmtCurrCd(e); // Retrieve Agreement Curr Cd
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND26)) {
				eventResponse = searchEquipTypeCd(e); // Retrieve Equipment Type Size
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND27)) {
				eventResponse = searchAuthOfcCd(e); // Retrieve Authorization Office Code
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND28)) {
				eventResponse = searchYdCdValid(e); // Retrieve Yard Code Validation
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND29)) {
				eventResponse = searchVndrCdValid(e); // Retrieve Vendor Code Validation
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND30)) {
				eventResponse = searchDBDate(e); // Retrieve CURR_DATE (GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC)
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND31)) {
				eventResponse = searchCostOfcValidDelYN(e); // Retrieve Cost Office Validation Delete YN
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND32)) {
				eventResponse = searchInvOfcValidDelYN(e); // Retrieve Invoice Office Validation Delete YN
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND33)) {
				eventResponse = searchCostCode(e); // Retrieve Cost Code
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND34)) {
				eventResponse = searchNodeCdList(e); // Retrieve Node Code List
				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND35)) {
				eventResponse = searchCntrTpSz(e); // Retrieve Container Type Size
				
			}
		}
		return eventResponse;
	}

	/**
	 * Retrieve Currency Code List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrencyCodeList(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchCurrencyCodeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Retrieve Common Code List <br>
	 * CNTR_TPSZ_CD, MT_A_LGS_COST_CD, ON_A_LGS_COST_CD, OT_A_LGS_COST_CD, OS_A_LGS_COST_CD, ST_A_LGS_COST_CD, CARR_CD, EQ_TPSZ_CD <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonCodeList(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchCommonCodeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve WHLD_TAX_AMT_MODE <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWhldTaxAmtMode(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchWhldTaxAmtMode(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Manual Lgs Cost Cd <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManualLgsCostCdList(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchManualLgsCostCdList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Service Provider Name <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceProviderName(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchServiceProviderName(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Invoice Duplication YN <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvDuplicateYN(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchInvDuplicateYN(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Error Invoice Validation YN <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchErrInvValidYN(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchErrInvValidYN(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Yard Code Validation & Cost Code List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYdCdCostCdList(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchYdCdCostCdList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Office Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcCd(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchOfcCd(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Sub Trade Code List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubTrdCdList(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchSubTrdCdList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Agreement Cost Code List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgmtCostCdList(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchAgmtCostCdList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Agreement Status Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgmtStatusCd(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchAgmtStatusCd(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve SLane Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSLanCd(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchSLanCd(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Cost Office Validation YN <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostOfcValidYN(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchCostOfcValidYN(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Agreement Curr Cd <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgmtCurrCd(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchAgmtCurrCd(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Equipment Type Size <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEquipTypeCd(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchEquipTypeCd(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Authorization Office Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthOfcCd(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchAuthOfcCd(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Yard Code Validation <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYdCdValid(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchYdCdValid(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Vendor Code Validation <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVndrCdValid(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchVndrCdValid(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve CURR_DATE (GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC) <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDBDate(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchDBDate(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Cost Office Validation Delete YN <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostOfcValidDelYN(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchCostOfcValidDelYN(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Invoice Office Validation Delete YN <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvOfcValidDelYN(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchInvOfcValidDelYN(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Cost Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostCode(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchCostCode(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Node Code List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNodeCdList(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchNodeCdList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Container Type Size <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrTpSz(Event e) throws EventException {
		TESCommonEvent event = (TESCommonEvent) e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchCntrTpSz(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
}
