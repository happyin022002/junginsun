/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMAgreementSC.java
*@FileTitle : ACMAgreementSC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmagreement;

import java.util.List;

import com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.basic.AGNCommAgreementBC;
import com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.basic.AGNCommAgreementBCImpl;
import com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.event.EsmAcm0001Event;
import com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.event.EsmAcm0101Event;
import com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.event.EsmAcm0114Event;
import com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.integration.AGNCommAgreementDBDAO;
import com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.vo.AgentRateDetailVO;
import com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.vo.AgentRateMasterVO;
import com.clt.apps.opus.esm.acm.acmagreement.facommagreement.basic.FACommAgreementBC;
import com.clt.apps.opus.esm.acm.acmagreement.facommagreement.basic.FACommAgreementBCImpl;
import com.clt.apps.opus.esm.acm.acmagreement.facommagreement.event.EsmAcm0024Event;
import com.clt.apps.opus.esm.acm.acmagreement.facommagreement.vo.FACAgreementVO;
import com.clt.apps.opus.esm.acm.acmagreement.ffcmpnagreement.basic.FFCmpnAgreementBC;
import com.clt.apps.opus.esm.acm.acmagreement.ffcmpnagreement.basic.FFCmpnAgreementBCImpl;
import com.clt.apps.opus.esm.acm.acmagreement.ffcmpnagreement.event.EsmAcm0023Event;
import com.clt.apps.opus.esm.acm.acmagreement.ffcmpnagreement.vo.FFAgreementVO;
import com.clt.apps.opus.esm.acm.acmagreement.spclcmpnagreement.basic.SPCLCmpnAgreementBC;
import com.clt.apps.opus.esm.acm.acmagreement.spclcmpnagreement.basic.SPCLCmpnAgreementBCImpl;
import com.clt.apps.opus.esm.acm.acmagreement.spclcmpnagreement.event.EsmAcm0025Event;
import com.clt.apps.opus.esm.acm.acmagreement.spclcmpnagreement.vo.SCompAgreementVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-ACMAgreement Business Logic ServiceCommand - OPUS-ACMAgreement handling business transaction.
 *
 * @author KIM, Sang-Soo
 * @see AGNCommAgreementDBDAO
 * @since J2EE 1.6
 */

public class ACMAgreementSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ACMAgreement system preceding process for biz scenario<br>
	 * related objects creation<br>
	 */
	public void doStart() {
		log.debug("ACMAgreementSC Start");
		try {
			// checking Login user ID
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ACMAgreement system biz scenario closing<br>
	 * biz scenario closing<br>
	 */
	public void doEnd() {
		log.debug("ACMAgreementSC End");
	}

	/**
	 * Handling working scenario of each event
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsmAcm0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgentRateMaster(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = getNewAgreementNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAgentRateMaster(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchAgentRateDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageAgentRateDetail(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = getAgreementNoInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAgmtCopy(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFFAgreement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageFFAgreement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = searchFFAgreementDup(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFACAgreement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageFACAgreement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = requestFACAgreement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = approveFACAgreement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = rejectFACAgreement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = stateFACAgreement(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = searchFACAgreementDup(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0025Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSCompAgreement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSCompAgreement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = searchSCompAgreementDup(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0114Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgentRateDetail(e);
			}
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0001-01 / ESM_ACM_0001-03 / ESM_ACM_0101] Retrieve<br>
	 * [Master] tab / [Summary] tab - Master Agreement List retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgentRateMaster(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0001Event event = (EsmAcm0001Event)e;
		AGNCommAgreementBC command = new AGNCommAgreementBCImpl();

		try{
			List<AgentRateMasterVO> list = command.searchAgentRateMaster(event.getAgentRateMasterVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0001-01] Save<br>
	 * [Master] tab list save<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAgentRateMaster(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0001Event event = (EsmAcm0001Event)e;
		AGNCommAgreementBC command = new AGNCommAgreementBCImpl();

		try{
			begin();
			command.manageAgentRateMaster(event.getAgentRateMasterVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0001-02 / ESM_ACM_0001-03]
	 * [Detail]tab - Compensation Master / [Summary] tab - Detail list retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgentRateDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AgentRateMasterVO AgentRateMasterVO = new AgentRateMasterVO();
		if (e.getEventName().equalsIgnoreCase("EsmAcm0001Event")) {
			EsmAcm0001Event event = (EsmAcm0001Event)e;
			AgentRateMasterVO = event.getAgentRateMasterVO();
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0114Event")) {
			EsmAcm0114Event event = (EsmAcm0114Event)e;
			AgentRateMasterVO = event.getAgentRateMasterVO();
		}
		AGNCommAgreementBC command = new AGNCommAgreementBCImpl();

		try{
			List<AgentRateDetailVO> list = command.searchAgentRateDetail(AgentRateMasterVO);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0001-02] Save<br>
	 * [Detail]tab - Compensation Master list save<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAgentRateDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0001Event event = (EsmAcm0001Event)e;
		AGNCommAgreementBC command = new AGNCommAgreementBCImpl();

		try{
			begin();
			command.manageAgentRateDetail(event.getAgentRateDetailVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0001-01] Row Add / [ESM_ACM_0101] Select<br>
	 * Get New Agreement No.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getNewAgreementNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0001Event event = (EsmAcm0001Event)e;
		AGNCommAgreementBC command = new AGNCommAgreementBCImpl();

		try{
			List<AgentRateMasterVO> list = command.getNewAgreementNo(event.getAgentRateMasterVO());
			eventResponse.setETCData("new_agmt_no", list.get(0).getNewAgmtNo());
			eventResponse.setETCData("usr_id", account.getUsr_id());    // 로그인한 사용자 ID
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0101] Valiation<br>
	 * Validation of new agreement No. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getAgreementNoInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0101Event event = (EsmAcm0101Event)e;
		AGNCommAgreementBC command = new AGNCommAgreementBCImpl();

		try{
			command.getAgreementNoInfo(event.getAgentRateMasterVO());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0101] Select<br>
	 * Agreement number copy<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAgmtCopy(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0101Event event = (EsmAcm0101Event)e;
		AGNCommAgreementBC command = new AGNCommAgreementBCImpl();

		try{
			begin();
			command.manageAgmtCopy(event.getAgentRateMasterVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0023] Retrieve<br>
	 * FF Compensation Agreement Creation list retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFFAgreement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0023Event event = (EsmAcm0023Event)e;
		FFCmpnAgreementBC command = new FFCmpnAgreementBCImpl();

		try{
			List<FFAgreementVO> list = command.searchFFAgreement(event.getFfagreementVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0023] Retrieve<br>
	 * FF Compensation Agreement Creation list retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFFAgreementDup(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0023Event event = (EsmAcm0023Event)e;
		FFCmpnAgreementBC command = new FFCmpnAgreementBCImpl();
		try{
			List<FFAgreementVO> list = command.searchFFAgreementDup(event.getFfagreementVOs());
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("cnt", String.valueOf(list.size()));
			for (int i=0; i < list.size(); i++) {
				eventResponse.setETCData(String.valueOf(i), String.valueOf(list.get(i).getSeq()));					
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0024] Retrieve<br>
	 * FAC Agreement Creation list retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFACAgreement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0024Event event = (EsmAcm0024Event)e;
		FACommAgreementBC command = new FACommAgreementBCImpl();

		try{
			List<FACAgreementVO> list = command.searchFACAgreement(event.getFacAgreementVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0024] Retrieve<br>
	 * FAC Agreement Creation list retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFACAgreementDup(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0024Event event = (EsmAcm0024Event)e;
		FACommAgreementBC command = new FACommAgreementBCImpl();
		try{
			List<FACAgreementVO> list = command.searchFACAgreementDup(event.getFacAgreementVOs());
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("cnt", String.valueOf(list.size()));
			for (int i=0; i < list.size(); i++) {
				eventResponse.setETCData(String.valueOf(i), String.valueOf(list.get(i).getSeq()));					
			}
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0024] Save<br>
	 * FAC Agreement Creation list retrieve<br>
	 *
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse manageFACAgreement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0024Event event = (EsmAcm0024Event)e;
		FACommAgreementBC command = new FACommAgreementBCImpl();
		
		try {
			begin();
			command.manageFACAgreement(event.getFacAgreementVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0025] Retrieve<br>
	 * Compensation Agreement Rate Creation list retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCompAgreement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0025Event event = (EsmAcm0025Event)e;
		SPCLCmpnAgreementBC command = new SPCLCmpnAgreementBCImpl();

		try{
			List<SCompAgreementVO> list = command.searchSCompAgreement(event.getScompAgreementVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0025] Retrieve<br>
	 * Compensation Agreement Rate Creation list retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCompAgreementDup(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0025Event event = (EsmAcm0025Event)e;
		SPCLCmpnAgreementBC command = new SPCLCmpnAgreementBCImpl();

		try{
			List<SCompAgreementVO> list = command.searchSCompAgreementDup(event.getScompAgreementVOs());
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("cnt", String.valueOf(list.size()));
			for (int i=0; i < list.size(); i++) {
				eventResponse.setETCData(String.valueOf(i), String.valueOf(list.get(i).getSeq()));					
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0024] Request<br>
	 * Handle the 'Request' button click event<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse requestFACAgreement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0024Event event = (EsmAcm0024Event)e;
		FACommAgreementBC command = new FACommAgreementBCImpl();
		try {
			begin();
			command.requestFACAgreement(event.getFacAgreementVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0024] Approve<br>
	 * Handle the 'Approve' button click event
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse approveFACAgreement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0024Event event = (EsmAcm0024Event)e;
		FACommAgreementBC command = new FACommAgreementBCImpl();
		try {

			begin();
			command.approveFACAgreement(event.getFacAgreementVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0024] Reject<br>
	 * Handle the 'Reject' button click event<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse rejectFACAgreement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0024Event event = (EsmAcm0024Event)e;
		FACommAgreementBC command = new FACommAgreementBCImpl();

		try {
			begin();
			command.rejectFACAgreement(event.getFacAgreementVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [ESM_ACM_0024] State update<br>
	 * Handle the 'State' button click event<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse stateFACAgreement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0024Event event = (EsmAcm0024Event)e;
		FACommAgreementBC command = new FACommAgreementBCImpl();

		try {
			begin();
//			command.rejectFACAgreement(event.getFacAgreementVOs(), account);
			command.stateFACAgreement(event.getFacAgreementVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0023] Save<br>
	 * FF Compensation Agreement Creation liste save<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFFAgreement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0023Event event = (EsmAcm0023Event)e;
		FFCmpnAgreementBC command = new FFCmpnAgreementBCImpl();

		try{
			begin();
			command.manageFFAgreement(event.getFfagreementVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0025] Retrieve<br>
	 * Compensation Agreement Rate Creation list retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSCompAgreement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0025Event event = (EsmAcm0025Event)e;
		SPCLCmpnAgreementBC command = new SPCLCmpnAgreementBCImpl();

		try{
			begin();
			command.manageSCompAgreement(event.getScompAgreementVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

}